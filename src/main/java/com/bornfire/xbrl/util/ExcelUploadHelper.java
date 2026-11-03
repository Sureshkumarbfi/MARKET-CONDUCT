package com.bornfire.xbrl.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

/**
 * Opens regulatory upload workbooks (.xlsx / .xls). SLS remains .xlsx-only.
 */
public final class ExcelUploadHelper {

	private static final Set<String> EXCEL_UPLOAD_REPORT_TYPES = new HashSet<>(Arrays.asList(
			"FXP", "TR_PLC", "TR_INV", "TR_TB", "TR_SWD", "FWD_RVL",
			"TR_INV_DEAL_DUMP", "plcdealdump", "DAY_LIGHT", "MFD", "ECL", "VARFILE", "ONFC"));

	private ExcelUploadHelper() {
	}

	public static boolean isExcelUploadReportType(String reportType) {
		return reportType != null && EXCEL_UPLOAD_REPORT_TYPES.contains(reportType);
	}

	public static boolean isSlsReportType(String reportType) {
		return "SLS".equals(reportType);
	}

	public static void validateUploadFile(MultipartFile file, String reportType) {
		if (file == null || file.isEmpty()) {
			throw new RuntimeException("Please select a valid file.");
		}
		String name = file.getOriginalFilename();
		if (name == null || name.trim().isEmpty()) {
			throw new RuntimeException("File name is required.");
		}
		String lower = name.toLowerCase();
		if (isSlsReportType(reportType)) {
			if (!lower.endsWith(".xlsx")) {
				throw new RuntimeException("SLS upload supports .xlsx format only.");
			}
			return;
		}
		if (isExcelUploadReportType(reportType)) {
			if (!lower.endsWith(".xlsx") && !lower.endsWith(".xls")) {
				throw new RuntimeException("Excel upload supports .xlsx or .xls format.");
			}
		}
	}

	/** .xlsx or .xls — POI picks HSSF / XSSF automatically. */
	public static Workbook openExcelWorkbook(MultipartFile file) throws IOException {
		validateExcelExtension(file, false);
		try {
			return WorkbookFactory.create(file.getInputStream());
		} catch (InvalidFormatException e) {
			throw new RuntimeException("Invalid or corrupted Excel file.", e);
		}
	}

	/** SLS: .xlsx only (same parsing logic, fixed workbook type). */
	public static Workbook openSlsXlsxWorkbook(MultipartFile file) throws IOException {
		validateExcelExtension(file, true);
		return new XSSFWorkbook(file.getInputStream());
	}

	private static void validateExcelExtension(MultipartFile file, boolean xlsxOnly) {
		String name = file.getOriginalFilename();
		if (name == null) {
			throw new RuntimeException("File name is required.");
		}
		String lower = name.toLowerCase();
		if (xlsxOnly) {
			if (!lower.endsWith(".xlsx")) {
				throw new RuntimeException("SLS upload supports .xlsx format only.");
			}
		} else if (!lower.endsWith(".xlsx") && !lower.endsWith(".xls")) {
			throw new RuntimeException("Excel upload supports .xlsx or .xls format.");
		}
	}
}
