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

import com.bornfire.xbrl.entities.RT_Overnight_Foreign_Ccy_Data_Entity;
import com.bornfire.xbrl.entities.RT_Overnight_Foreign_Ccy_Data_Repo;
import com.bornfire.xbrl.util.ExcelUploadHelper;

@Service
public class OvernightForeignCcyUploadService {

	@Autowired
	private RT_Overnight_Foreign_Ccy_Data_Repo overnightRepo;

	@Autowired
	private AuditService auditService;

	public List<String> getUploadedDates() {
		List<Date> dates = overnightRepo.findDistinctReportDates();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return dates.stream().map(sdf::format).collect(Collectors.toList());
	}

	@Transactional
	public String uploadOvernightForeignCcy(MultipartFile file, Date reportDate, boolean forceUpload)
			throws Exception {
		if (file == null || file.isEmpty()) {
			throw new RuntimeException("Please select a valid file.");
		}
		if (reportDate == null) {
			throw new RuntimeException("Reference Date is required.");
		}

		long existing = overnightRepo.countByReportDate(reportDate);
		if (existing > 0 && !forceUpload) {
			throw new RuntimeException("already uploaded");
		}
		if (existing > 0) {
			overnightRepo.deleteByReportDate(reportDate);
		}

		DataFormatter formatter = new DataFormatter();
		int totalRows = 0;
		int inserted = 0;
		int failed = 0;
		List<RT_Overnight_Foreign_Ccy_Data_Entity> batch = new ArrayList<>();

		try (Workbook workbook = ExcelUploadHelper.openExcelWorkbook(file)) {
			Sheet sheet = workbook.getNumberOfSheets() > 0 ? workbook.getSheetAt(0) : null;
			if (sheet == null) {
				throw new RuntimeException("Excel file does not contain any sheets.");
			}

			int[] columns = discoverColumns(sheet, formatter);
			int currencyCol = columns[0];
			int closingCol = columns[1];
			int firstDataRow = columns[2];

			if (currencyCol < 0 || closingCol < 0) {
				throw new RuntimeException(
						"Could not find Currency and Closing Position columns in the upload file.");
			}

			java.sql.Date sqlReportDate = new java.sql.Date(reportDate.getTime());
			int lastRow = sheet.getLastRowNum();
			for (int r = firstDataRow; r <= lastRow; r++) {
				Row row = sheet.getRow(r);
				if (row == null) {
					continue;
				}

				String currency = normalizeCurrency(readCell(row, currencyCol, formatter));
				String closingRaw = readCell(row, closingCol, formatter);

				if (currency == null && (closingRaw == null || closingRaw.trim().isEmpty())) {
					continue;
				}

				totalRows++;
				if (currency == null) {
					failed++;
					continue;
				}

				try {
					RT_Overnight_Foreign_Ccy_Data_Entity entity = new RT_Overnight_Foreign_Ccy_Data_Entity();
					entity.setReport_date(sqlReportDate);
					entity.setCurrency(currency);
					entity.setClosing_position(parseClosingPosition(closingRaw));
					batch.add(entity);
					inserted++;
				} catch (Exception ex) {
					failed++;
				}
			}
		}

		if (inserted == 0) {
			throw new RuntimeException("No valid currency rows found in the upload file.");
		}

		overnightRepo.saveAll(batch);
		auditService.createBusinessAudit(String.valueOf(reportDate), "UPLOAD",
				"Regulatory_Data_Ingestion_ONFC", null, "RT_OVERNIGHT_FOREIGN_CCY_DATA");

		return "Upload complete. Inserted rows: " + inserted + ". Data rows processed: " + totalRows
				+ ". Failed rows: " + failed + ".";
	}

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
