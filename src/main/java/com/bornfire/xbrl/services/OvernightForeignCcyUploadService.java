package com.bornfire.xbrl.services;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import com.bornfire.xbrl.util.ExcelUploadHelper;

@Service
public class OvernightForeignCcyUploadService {



	@Autowired
	private AuditService auditService;


	private int[] discoverColumns(Sheet sheet, DataFormatter formatter) {
		int currencyCol = -1;
		int closingCol = -1;
		int headerRow = -1;
		int scanLimit = Math.min(sheet.getLastRowNum(), 20);

		for (int r = 0; r <= scanLimit; r++) {
			Row row = sheet.getRow(r);
			if (row == null) {
				continue;
			}
			int rowCurrencyCol = -1;
			int rowClosingCol = -1;
			short lastCell = row.getLastCellNum();
			for (int c = 0; c < lastCell; c++) {
				String text = normalizeHeader(readCell(row, c, formatter));
				if (text == null) {
					continue;
				}
				if (text.contains("currency")) {
					rowCurrencyCol = c;
				}
				if (text.contains("closing") && text.contains("position")) {
					rowClosingCol = c;
				} else if (rowClosingCol < 0 && text.equals("closing position")) {
					rowClosingCol = c;
				}
			}
			if (rowCurrencyCol >= 0 && rowClosingCol >= 0) {
				currencyCol = rowCurrencyCol;
				closingCol = rowClosingCol;
				headerRow = r;
				break;
			}
		}

		if (headerRow < 0) {
			return new int[] { 0, 1, 0 };
		}
		return new int[] { currencyCol, closingCol, headerRow + 1 };
	}

	private String readCell(Row row, int colIdx, DataFormatter formatter) {
		Cell cell = row.getCell(colIdx);
		if (cell == null) {
			return null;
		}
		String val = formatter.formatCellValue(cell);
		return val == null ? null : val.trim();
	}

	private String normalizeHeader(String value) {
		if (value == null) {
			return null;
		}
		return value.toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9]+", " ").trim();
	}

	private String normalizeCurrency(String value) {
		if (value == null) {
			return null;
		}
		String currency = value.trim().toUpperCase(Locale.ROOT);
		if (currency.isEmpty()) {
			return null;
		}
		if (currency.length() > 3) {
			currency = currency.substring(0, 3);
		}
		return currency;
	}

	private BigDecimal parseClosingPosition(String raw) {
		if (raw == null) {
			return null;
		}
		String val = raw.trim();
		if (val.isEmpty()) {
			return null;
		}

		boolean negative = false;
		if (val.startsWith("(") && val.endsWith(")")) {
			negative = true;
			val = val.substring(1, val.length() - 1).trim();
		} else if (val.startsWith("-")) {
			negative = true;
			val = val.substring(1).trim();
		}

		val = val.replaceAll(",", "").trim();
		if (val.isEmpty()) {
			return null;
		}

		BigDecimal amount = new BigDecimal(val);
		return negative ? amount.negate() : amount;
	}
}
