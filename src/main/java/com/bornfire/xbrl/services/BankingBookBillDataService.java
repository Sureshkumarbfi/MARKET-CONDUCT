package com.bornfire.xbrl.services;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bornfire.xbrl.entities.BankingBookBillDataEntity;
import com.bornfire.xbrl.entities.BankingBookBillDataRepo;

@Service
public class BankingBookBillDataService {

	@Autowired
	private BankingBookBillDataRepo bankingBookBillDataRepo;

	public List<BankingBookBillDataEntity> getBillDetailsByReportDate(Date reportDate) {
		return bankingBookBillDataRepo.getListByReportDate(reportDate);
	}

	public byte[] generateBillDetailsExcel(Date reportDate) throws Exception {
		List<BankingBookBillDataEntity> billDetails = getBillDetailsByReportDate(reportDate);
		if (billDetails == null || billDetails.isEmpty()) {
			return new byte[0];
		}

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			Sheet sheet = workbook.createSheet("Bill Details");
			CreationHelper helper = workbook.getCreationHelper();

			CellStyle headerStyle = workbook.createCellStyle();
			headerStyle.setBorderTop(BorderStyle.THIN);
			headerStyle.setBorderBottom(BorderStyle.THIN);
			headerStyle.setBorderLeft(BorderStyle.THIN);
			headerStyle.setBorderRight(BorderStyle.THIN);

			CellStyle bodyStyle = workbook.createCellStyle();
			bodyStyle.setBorderTop(BorderStyle.THIN);
			bodyStyle.setBorderBottom(BorderStyle.THIN);
			bodyStyle.setBorderLeft(BorderStyle.THIN);
			bodyStyle.setBorderRight(BorderStyle.THIN);

			CellStyle dateStyle = workbook.createCellStyle();
			dateStyle.cloneStyleFrom(bodyStyle);
			dateStyle.setDataFormat(helper.createDataFormat().getFormat("dd-MM-yyyy"));

			String[] headers = { "BILL ID", "BILL AMOUNT", "COUNTRY CODE", "CURRENCY CODE", "BILL LIABILITY", "DUE DATE",
					"FORACID", "ACID", "REPORT DATE", "BILL RMV FLG", "BILL ADJ FLG", "STATUS" };

			Row headerRow = sheet.createRow(0);
			for (int i = 0; i < headers.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(headers[i]);
				cell.setCellStyle(headerStyle);
			}

			int rowNum = 1;
			for (BankingBookBillDataEntity bill : billDetails) {
				Row row = sheet.createRow(rowNum++);
				setStringCell(row, 0, bill.getBillId(), bodyStyle);
				setNumberCell(row, 1, bill.getBillAmt(), bodyStyle);
				setStringCell(row, 2, bill.getBillCntryCode(), bodyStyle);
				setStringCell(row, 3, bill.getBillCrncyCode(), bodyStyle);
				setStringCell(row, 4, bill.getBillLiab(), bodyStyle);
				setDateCell(row, 5, bill.getDueDate(), dateStyle, bodyStyle);
				setStringCell(row, 6, bill.getForacid(), bodyStyle);
				setStringCell(row, 7, bill.getAcid(), bodyStyle);
				setDateCell(row, 8, bill.getReportDate(), dateStyle, bodyStyle);
				setStringCell(row, 9, bill.getBillRmvFlg(), bodyStyle);
				setStringCell(row, 10, bill.getBillAdjFlg(), bodyStyle);
				setStringCell(row, 11, deriveStatus(bill), bodyStyle);
			}

			for (int i = 0; i < headers.length; i++) {
				sheet.autoSizeColumn(i);
			}

			workbook.write(out);
			return out.toByteArray();
		}
	}

	public String deriveStatus(BankingBookBillDataEntity bill) {
		if ("Y".equalsIgnoreCase(safeString(bill.getBillRmvFlg()))) {
			return "Bill Amount Made Zero";
		}
		if ("Y".equalsIgnoreCase(safeString(bill.getBillAdjFlg()))) {
			return "Amount Reduced";
		}
		return "";
	}

	private void setStringCell(Row row, int columnIndex, String value, CellStyle style) {
		Cell cell = row.createCell(columnIndex);
		cell.setCellValue(value == null ? "" : value);
		cell.setCellStyle(style);
	}

	private void setNumberCell(Row row, int columnIndex, BigDecimal value, CellStyle style) {
		Cell cell = row.createCell(columnIndex);
		if (value != null) {
			cell.setCellValue(value.doubleValue());
		} else {
			cell.setCellValue("");
		}
		cell.setCellStyle(style);
	}

	private void setDateCell(Row row, int columnIndex, Date value, CellStyle dateStyle, CellStyle fallbackStyle) {
		Cell cell = row.createCell(columnIndex);
		if (value != null) {
			cell.setCellValue(value);
			cell.setCellStyle(dateStyle);
		} else {
			cell.setCellValue("");
			cell.setCellStyle(fallbackStyle);
		}
	}

	private String safeString(String value) {
		return value == null ? "" : value.trim();
	}
}
