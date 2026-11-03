package com.bornfire.xbrl.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

/**
 * Standard upload result and error messages for the common upload endpoint and monitor.
 */
public final class UploadMessageHelper {

	private UploadMessageHelper() {
	}

	public static String success(String reportName, Date reportDate, int inserted, int failed, int total) {
		return success(reportName, reportDate, inserted, failed, total, null);
	}

	public static String success(String reportName, Date reportDate, int inserted, int failed, int total,
			List<String> sampleErrors) {
		StringBuilder message = new StringBuilder();
		message.append("Upload complete for ").append(reportName);
		message.append(" (Report Date: ").append(formatReportDate(reportDate)).append("). ");
		message.append("Inserted rows: ").append(inserted).append(". ");
		if (failed > 0) {
			message.append("Failed rows: ").append(failed).append(". ");
		}
		message.append("Total rows processed: ").append(total).append(".");
		appendSampleErrors(message, sampleErrors);
		return message.toString();
	}

	public static String failure(String reportName, Date reportDate, int failed, int total,
			List<String> sampleErrors) {
		StringBuilder message = new StringBuilder();
		message.append("Upload failed for ").append(reportName);
		message.append(" (Report Date: ").append(formatReportDate(reportDate)).append("). ");
		message.append("No rows were inserted. ");
		message.append("Failed rows: ").append(failed).append(". ");
		message.append("Total rows processed: ").append(total).append(".");
		appendSampleErrors(message, sampleErrors);
		return message.toString();
	}

	public static String userFriendlyError(Throwable error) {
		if (error == null) {
			return "Upload failed due to an unknown error. Please try again.";
		}

		Throwable root = error;
		while (root.getCause() != null && root.getCause() != root) {
			root = root.getCause();
		}

		String message = root.getMessage();
		if (message == null || message.trim().isEmpty()) {
			message = error.getMessage();
		}
		if (message == null || message.trim().isEmpty()) {
			return "Upload failed due to an unexpected error. Please verify the file and try again.";
		}

		if (message.contains("Invalid or corrupted Excel file")) {
			return "The selected file is not a valid Excel workbook. Please upload a .xlsx or .xls file.";
		}
		if (message.contains("Header row not found")) {
			return "Required column headers were not found in the Excel file. Please use the correct template.";
		}
		if (message.contains("NumberFormatException") || message.contains("For input string")) {
			return "Invalid numeric value found in the Excel file. Please check number columns and try again.";
		}
		if (message.contains("NullPointerException")) {
			return "Required data is missing in the Excel file. Please verify all mandatory columns are filled.";
		}
		if (message.contains("Excel upload supports") || message.contains("SLS upload supports")
				|| message.contains("Please select a valid file")) {
			return message;
		}

		return message;
	}

	public static String rowError(int excelRowNum, Exception error) {
		String detail = error != null ? error.getMessage() : null;
		if (detail == null || detail.trim().isEmpty()) {
			detail = error != null ? error.getClass().getSimpleName() : "Unknown error";
		}
		if (detail.length() > 160) {
			detail = detail.substring(0, 160) + "...";
		}
		return "Row " + excelRowNum + ": " + detail;
	}

	public static boolean isBlankRow(Row row, DataFormatter formatter) {
		if (row == null) {
			return true;
		}
		for (Cell cell : row) {
			if (cell != null && !formatter.formatCellValue(cell).trim().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	public static String formatReportDate(Date reportDate) {
		if (reportDate == null) {
			return "-";
		}
		return new SimpleDateFormat("dd-MM-yyyy").format(reportDate);
	}

	private static void appendSampleErrors(StringBuilder message, List<String> sampleErrors) {
		if (sampleErrors == null || sampleErrors.isEmpty()) {
			return;
		}
		message.append(" Sample errors: ").append(String.join("; ", sampleErrors)).append(".");
	}
}
