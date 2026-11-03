package com.bornfire.xbrl.services;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bornfire.xbrl.entities.Counterparty_Rep;


@Service
@Transactional
public class Excel_Services {
	private static final Logger logger = LoggerFactory.getLogger(Excel_Services.class);
	
	@Autowired
	Counterparty_Rep Counterparty_Reps;

	public byte[] generateExcel() {
		try {
			logger.info("Generating Excel file For Exposure Template ...");

			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Total");

			CellStyle unlockedStyle = workbook.createCellStyle();
			unlockedStyle.setLocked(false);

			CellStyle lockedStyle = workbook.createCellStyle();
			lockedStyle.setLocked(true);

			Font headerFont = workbook.createFont();
			headerFont.setFontHeightInPoints((short) 9);
			headerFont.setBold(true);
			lockedStyle.setFont(headerFont);

			CellStyle lockedCenterStyle = workbook.createCellStyle();
			lockedCenterStyle.setLocked(true);
			lockedCenterStyle.setFont(headerFont);
			lockedCenterStyle.setAlignment(HorizontalAlignment.CENTER);

			// Header row
			XSSFRow headerRow = sheet.createRow(0);
			String[] headers = { "BRANCH NAME", "SRL. NO.", "NAME OF THE COUNTERPARTY BANK", "BUYERS CREDIT",
					"FOREIGN BILL DISCOUNTING", "LOCAL BILL DISCOUNTING", "GUARANTEE SBLC'S",
					"SYNDICATED LOANS AND INVESTMENT", "OTHERS", "REMARKS" };

			for (int i = 0; i < headers.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(headers[i]);
				cell.setCellStyle(lockedStyle);
				sheet.setColumnWidth(i, (i == 1) ? 2000 : 7500);
			}

			List<String> counterbanklist = Counterparty_Reps.getall();
			logger.info("Retrieved {} counterparties", counterbanklist.size());

			int serialNumber = 1;
			int rowIndex = 1;

			for (String counterparty : counterbanklist) {
				XSSFRow row = sheet.createRow(rowIndex++);
				for (int i = 0; i < headers.length; i++) {
					Cell cell = row.createCell(i);
					if (i == 1) {
						cell.setCellValue(serialNumber++);
						cell.setCellStyle(lockedCenterStyle);
					} else if (i == 2) {
						cell.setCellValue(counterparty);
						cell.setCellStyle(lockedStyle);
					} else {
						cell.setCellValue("");
						cell.setCellStyle(unlockedStyle);
					}
				}
			}

			for (int i = rowIndex; i <= 50; i++) {
				XSSFRow row = sheet.createRow(i);
				for (int j = 0; j < headers.length; j++) {
					Cell cell = row.createCell(j);
					cell.setCellStyle(lockedStyle);
				}
			}

			sheet.protectSheet("");

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			workbook.close();

			logger.info("Excel generation completed successfully.");
			return bos.toByteArray();

		} catch (Exception e) {
			logger.error("Error generating Excel file", e);
			return null;
		}
	}

	public byte[] generateExcel_placement() {
		try {
			logger.info("Generating Excel file For Treasury Placement Template ...");

			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Treasury Placements");

			// Styles
			Font headerFont = workbook.createFont();
			headerFont.setFontHeightInPoints((short) 9);
			headerFont.setBold(true);

			CellStyle lockedStyle = workbook.createCellStyle(); // For headers
			lockedStyle.setLocked(true);
			lockedStyle.setFont(headerFont);
			lockedStyle.setAlignment(HorizontalAlignment.CENTER);

			CellStyle unlockedStyle = workbook.createCellStyle(); // For data rows
			unlockedStyle.setLocked(false);

			// Header row (locked)
			String[] headers = { "Titre", "Device 1", "Nominal 1", "Date Operation", "Date Valeur", "Date Echeance",
					"Portefeuille", "CounterParty" };

			XSSFRow headerRow = sheet.createRow(0);
			for (int i = 0; i < headers.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(headers[i]);
				cell.setCellStyle(lockedStyle);
				sheet.setColumnWidth(i, 6000); // Adjust width as needed
			}

			// Data rows (1000 rows editable)
			for (int i = 1; i <= 1000; i++) {
				XSSFRow row = sheet.createRow(i);
				for (int j = 0; j < headers.length; j++) {
					Cell cell = row.createCell(j);
					cell.setCellStyle(unlockedStyle); // Editable
				}
			}

			// Lock the sheet (so locked cells take effect)
			sheet.protectSheet("placement");

			// Write to byte stream
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			workbook.close();

			logger.info("Excel generation completed successfully for Treasury Placement.");
			return bos.toByteArray();

		} catch (Exception e) {
			logger.error("Error generating Excel file for Treasury Placement.", e);
			return null;
		}
	}

	public byte[] generateExcel_Settlement() {
		try {
			logger.info("Generating Excel file For Settlement Template ...");

			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Settlement");

			// Styles
			Font headerFont = workbook.createFont();
			headerFont.setFontHeightInPoints((short) 9);
			headerFont.setBold(true);

			CellStyle lockedStyle = workbook.createCellStyle(); // For headers
			lockedStyle.setLocked(true);
			lockedStyle.setFont(headerFont);
			lockedStyle.setAlignment(HorizontalAlignment.CENTER);

			CellStyle unlockedStyle = workbook.createCellStyle(); // For data rows
			unlockedStyle.setLocked(false);

			// Header row (locked)
			String[] headers = { "Deal Id", "Amount 1", "Amount 2", "Rate / Price", "Security", "Trade Date",
					"Value Date", "Mat. Date", "Cpty." };

			XSSFRow headerRow = sheet.createRow(0);
			for (int i = 0; i < headers.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(headers[i]);
				cell.setCellStyle(lockedStyle);
				sheet.setColumnWidth(i, 6000); // Adjust width as needed
			}

			// Data rows (1000 rows editable)
			for (int i = 1; i <= 1000; i++) {
				XSSFRow row = sheet.createRow(i);
				for (int j = 0; j < headers.length; j++) {
					Cell cell = row.createCell(j);
					cell.setCellStyle(unlockedStyle); // Editable
				}
			}

			// Lock the sheet (so locked cells take effect)
			sheet.protectSheet("Settlement");

			// Write to byte stream
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			workbook.close();

			logger.info("Excel generation completed successfully for Settlement.");
			return bos.toByteArray();

		} catch (Exception e) {
			logger.error("Error generating Excel file for Settlement.", e);
			return null;
		}
	}

	// Helper for BigDecimal nulls
	private String valueOf(BigDecimal val) {
		return val != null ? val.toPlainString() : "";
	}

	// Helper for Date formatting
	private String formatDate(Date date) {
		return date != null ? new SimpleDateFormat("dd-MM-yyyy").format(date) : "";
	}



	// Utilities

	private String nullSafe(String value) {
		return value != null ? value : "";
	}

	private String nullSafeDouble(Double value) {
		return new java.text.DecimalFormat("#0.00").format(value != null ? value : 0.0);
	}

	private int nullSafeInt(Integer value) {
		return value != null ? value : 0;
	}

	private String formatDecimal(Double value) {
		return String.format("%.2f", value != null ? value : 0.0);
	}

	private String formatDecimalString(String value) {
		try {
			double d = Double.parseDouble(value);
			return String.format("%.2f", d);
		} catch (Exception e) {
			return "0.00"; // if value is null, empty, or not a number
		}
	}

	private String formatDateTime(Date dateTime) {
		if (dateTime == null)
			return "";
		return new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(dateTime);
	}

}
