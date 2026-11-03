package com.bornfire.xbrl.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;



@Service
public class DaylightDataUploadService {

	private static final Logger logger = LoggerFactory.getLogger(DaylightDataUploadService.class);

	private static final int FIELD_TIME = 0;
	private static final int FIELD_DEAL = 1;
	private static final int FIELD_COUNTERPARTY = 2;
	private static final int FIELD_VALUE_DATE = 3;
	private static final int FIELD_RATE = 4;
	private static final int FIELD_PURCHASE = 5;
	private static final int FIELD_SALE = 6;
	private static final int FIELD_NET = 7;
	private static final int FIELD_CURRENCY = 8;

	private static final int FIELD_COUNT = 9;

	private static final String[] EXPECTED_HEADER_DISPLAY = { "Time of Deal", "Deal Type/Id", "Counterparty",
			"Value Date", "Rate", "Purchase", "Sale", "Net Position", "Currency" };

	/** Column index (0-based) for each logical field after header scan; same order as {@link #EXPECTED_HEADER_DISPLAY}. */
	private static final class HeaderPlacement {
		final int headerRowIndex;
		final int[] colByField;

		HeaderPlacement(int headerRowIndex, int[] colByField) {
			this.headerRowIndex = headerRowIndex;
			this.colByField = colByField;
		}
	}

	/** Header scan result: either a usable {@link #placement} or a short {@link #skipReason} for messaging. */
	private static final class DiscoverOutcome {
		final HeaderPlacement placement;
		final String skipReason;

		private DiscoverOutcome(HeaderPlacement placement, String skipReason) {
			this.placement = placement;
			this.skipReason = skipReason;
		}

		static DiscoverOutcome ok(HeaderPlacement placement) {
			return new DiscoverOutcome(placement, null);
		}

		static DiscoverOutcome skip(String reason) {
			return new DiscoverOutcome(null, reason);
		}

		boolean isOk() {
			return placement != null;
		}
	}


	private String buildUploadSuccessMessage(int inserted, int totalRowsSeen, int sheetCount,
			List<String> uploadedSheetSummaries, List<String> skippedSheetSummaries) {
		StringBuilder b = new StringBuilder();
		b.append("Upload complete. Inserted rows: ").append(inserted);
		b.append(". Data rows processed: ").append(totalRowsSeen);
		b.append(". Sheets in file: ").append(sheetCount);
		b.append(". Uploaded sheets: ").append(joinHumanList(uploadedSheetSummaries));
		b.append(". Skipped sheets: ").append(joinHumanList(skippedSheetSummaries));
		return b.toString();
	}

	private String joinHumanList(List<String> items) {
		if (items == null || items.isEmpty()) {
			return "None";
		}
		return String.join("; ", items);
	}

	/**
	 * Scans the sheet for the nine known headers (normalized text). Each title is taken from the first matching
	 * cell. All must lie on the same Excel row. If anything is missing or inconsistent, returns {@link DiscoverOutcome#skip(String)} so the sheet can be skipped without failing the workbook.
	 */
	private DiscoverOutcome discoverHeaderPlacementOutcome(Sheet sheet, DataFormatter formatter) {

		int[] colByField = new int[FIELD_COUNT];
		int[] rowByField = new int[FIELD_COUNT];
		for (int i = 0; i < FIELD_COUNT; i++) {
			colByField[i] = -1;
			rowByField[i] = -1;
		}

		int lastRow = sheet.getLastRowNum();
		for (int r = 0; r <= lastRow; r++) {
			Row row = sheet.getRow(r);
			if (row == null) {
				continue;
			}
			int firstCell = row.getFirstCellNum();
			int lastCell = row.getLastCellNum();
			if (firstCell < 0) {
				continue;
			}
			for (int c = firstCell; c < lastCell; c++) {
				Cell cell = row.getCell(c);
				String norm = normalizeHeader(formatter.formatCellValue(cell));
				if (norm.isEmpty()) {
					continue;
				}
				int field = resolveFieldIndexFromHeader(norm);
				if (field < 0) {
					continue;
				}
				if (colByField[field] >= 0) {
					// Keep first occurrence only (ignore duplicate label cells).
					continue;
				}
				colByField[field] = c;
				rowByField[field] = r;
			}
		}

		for (int i = 0; i < FIELD_COUNT; i++) {
			if (colByField[i] < 0) {
				return DiscoverOutcome.skip("no daylight template — missing \"" + EXPECTED_HEADER_DISPLAY[i] + "\"");
			}
		}

		int headerRow = rowByField[0];
		for (int i = 1; i < FIELD_COUNT; i++) {
			if (rowByField[i] != headerRow) {
				return DiscoverOutcome.skip("headers not on the same row");
			}
		}

		return DiscoverOutcome.ok(new HeaderPlacement(headerRow, colByField));
	}

	private int resolveFieldIndexFromHeader(String normalized) {
		if ("time of deal".equals(normalized)) {
			return FIELD_TIME;
		}
		if ("deal type id".equals(normalized) || "deal type or id".equals(normalized)) {
			return FIELD_DEAL;
		}
		if ("counterparty".equals(normalized)) {
			return FIELD_COUNTERPARTY;
		}
		if ("value date".equals(normalized)) {
			return FIELD_VALUE_DATE;
		}
		if ("rate".equals(normalized)) {
			return FIELD_RATE;
		}
		if ("purchase".equals(normalized)) {
			return FIELD_PURCHASE;
		}
		if ("sale".equals(normalized)) {
			return FIELD_SALE;
		}
		if ("net position".equals(normalized)) {
			return FIELD_NET;
		}
		if ("currency".equals(normalized)) {
			return FIELD_CURRENCY;
		}
		return -1;
	}

	private String normalizeHeader(String raw) {
		if (raw == null) {
			return "";
		}
		String s = raw.replace('\u00a0', ' ').trim().toLowerCase(Locale.ROOT);
		s = s.replace('/', ' ');
		s = s.replaceAll("\\s+", " ").trim();
		return s;
	}


	private Date toUtilDate(LocalDate ld) {
		if (ld == null) {
			return null;
		}
		return java.sql.Date.valueOf(ld);
	}

	private String getCellString(Row row, int colIndex, DataFormatter formatter) {
		Cell cell = row.getCell(colIndex);
		if (cell == null) {
			return null;
		}
		String v = formatter.formatCellValue(cell);
		return v == null ? null : v.trim();
	}

	private BigDecimal getBigDecimal(Row row, int colIndex, DataFormatter formatter) {
		Cell cell = row.getCell(colIndex);
		if (cell == null) {
			return null;
		}
		String value = formatter.formatCellValue(cell);
		if (value == null || value.trim().isEmpty()) {
			return null;
		}
		value = value.replace(",", "").trim();
		try {
			return new BigDecimal(value);
		} catch (NumberFormatException ex) {
			throw new RuntimeException("Invalid numeric value at row " + (row.getRowNum() + 1) + ": \"" + value + "\"",
					ex);
		}
	}

	private LocalDate getValueDateLocal(Row row, int colIndex, DataFormatter formatter) {
		Cell cell = row.getCell(colIndex);
		if (cell == null) {
			return null;
		}
		try {
			if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC && DateUtil.isCellDateFormatted(cell)) {
				Date d = cell.getDateCellValue();
				return d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			}
			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				String value = cell.getStringCellValue();
				if (value == null || value.trim().isEmpty()) {
					return null;
				}
				value = value.trim();
				try {
					return LocalDate.parse(value, DateTimeFormatter.ofPattern("dd-MMM-yy"));
				} catch (Exception ignored) {
				}
				try {
					return LocalDate.parse(value, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
				} catch (Exception ignored) {
				}
				try {
					return LocalDate.parse(value, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				} catch (Exception ignored) {
				}
				try {
					return LocalDate.parse(value, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				} catch (Exception ignored) {
				}
				throw new RuntimeException("Unsupported value date format at row " + (row.getRowNum() + 1) + ": "
						+ value);
			}
		} catch (RuntimeException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new RuntimeException("Error reading value date at row " + (row.getRowNum() + 1), ex);
		}
		return null;
	}

	/** True when every mapped data column is blank (row is not a data line). */
	private boolean isDataRowEmpty(Row row, int[] colByField, DataFormatter formatter) {
		if (row == null) {
			return true;
		}
		for (int f = 0; f < FIELD_COUNT; f++) {
			int c = colByField[f];
			Cell cell = row.getCell(c);
			if (cell == null) {
				continue;
			}
			String value = formatter.formatCellValue(cell);
			if (value != null && !value.trim().isEmpty()) {
				return false;
			}
		}
		return true;
	}
}
