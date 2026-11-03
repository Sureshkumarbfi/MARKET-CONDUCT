package com.bornfire.xbrl.services;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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

import com.bornfire.xbrl.entities.RT_FX_Position_Entity;
import com.bornfire.xbrl.entities.RT_FX_Position_Rep;
import com.bornfire.xbrl.util.ExcelUploadHelper;

@Service
public class RT_FX_Position_Service {

	@Autowired
	RT_FX_Position_Rep rtFxPositionRep;
    @Autowired
    AuditService auditservice;

	  // Get already uploaded dates
    public List<String> getUploadedDates() {
        List<Date> dates = rtFxPositionRep.findUploadedDates();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return dates.stream()
                .map(sdf::format)
                .collect(Collectors.toList());
    }
	
	@Transactional
	public String uploadFxData(MultipartFile file, Date fromDate, Date toDate, String user) throws Exception {

		  Date today = new Date();
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		    boolean exists = rtFxPositionRep.existsByReportDate(toDate) > 0;

		    // Past date already uploaded → block
		    if (exists && !sdf.format(today).equals(sdf.format(toDate))) {
		        throw new RuntimeException("Data already uploaded for this report date: " + toDate);
		    }

		    // If today upload again → replace
		    if (exists) {
		        rtFxPositionRep.deleteByReportDate(toDate);
		    }
		
		try (Workbook workbook = ExcelUploadHelper.openExcelWorkbook(file)) {
		// As per your requirement: Sheet index 2
		Sheet sheet = workbook.getSheetAt(2);
		DataFormatter formatter = new DataFormatter();

		// As per your requirement: Row indices 3, 10, 17
		int[] rowIndices = { 3, 10, 17 };
		String[] types = { "FxSwap Position", "Spot Position", "Total" };

		// Logic for generating new Serial Numbers if record doesn't exist
		Integer maxSrl = rtFxPositionRep.findMaxSrlNo();
		int nextSrl = (maxSrl == null) ? 1 : maxSrl + 1;

		for (int i = 0; i < rowIndices.length; i++) {
			Row row = sheet.getRow(rowIndices[i]);
			if (row == null)
				continue;

			// 1. Check if a record for this Date and Type already exists (Replace Logic)
			RT_FX_Position_Entity entity = rtFxPositionRep.findExistingRecord(toDate, types[i]);

			if (entity == null) {
				// APPEND LOGIC: Create new record
				entity = new RT_FX_Position_Entity();
				entity.setSrl_no(String.valueOf(nextSrl++));
				entity.setCreate_user(user);
				entity.setCreate_time(new Date());
			} else {
				// REPLACE LOGIC: Use the existing record's SRL_NO to trigger an Update
				entity.setModify_user(user);
				entity.setModify_time(new Date());
			}

			// 2. Map the Excel Data to the Entity
			entity.setPosition_type(types[i]);

			// Columns: C(2), E(4), G(6), I(8), K(10), M(12), O(14), Q(16), S(18), U(20),
			// W(22)
			entity.setGbp(getSafeBigDecimal(row, 2, formatter));
			entity.setUsd(getSafeBigDecimal(row, 4, formatter));
			entity.setJpy(getSafeBigDecimal(row, 6, formatter));
			entity.setChf(getSafeBigDecimal(row, 8, formatter));
			entity.setEur(getSafeBigDecimal(row, 10, formatter));
			entity.setInr(getSafeBigDecimal(row, 12, formatter));
			entity.setSgd(getSafeBigDecimal(row, 14, formatter));
			entity.setSar(getSafeBigDecimal(row, 16, formatter));
			entity.setAed(getSafeBigDecimal(row, 18, formatter));
			entity.setKwd(getSafeBigDecimal(row, 20, formatter));
			entity.setQar(getSafeBigDecimal(row, 22, formatter));

			// Standard Reporting Fields
			entity.setReport_from_date(fromDate);
			entity.setReport_to_date(toDate);
			entity.setReport_date(toDate);

			// Flags
			entity.setEntity_flg("N");
			entity.setModify_flg("N");
			entity.setDel_flg("N");

			// 3. Save to Database (JPA automatically Updates if ID exists, otherwise
			// Inserts)
		   
			rtFxPositionRep.save(entity);
		}
		auditservice.createBusinessAudit( String.valueOf(toDate), "UPLOAD",
		        "Regulatory_Data_Ingestion_FXP", null,  "RT_FX_POSITION_TABLE"
		);
		return "FX Position data processed successfully: Records for " + toDate + " updated/appended.";
		}
	}

	/**
	 * Safely extracts numeric values from Excel cells. Handles nulls, empty
	 * strings, and formatted numbers (with commas).
	 */
	private BigDecimal getSafeBigDecimal(Row row, int colIdx, DataFormatter formatter) {
		Cell cell = row.getCell(colIdx);
		if (cell == null) {
			return BigDecimal.ZERO;
		}

		try {
			// Get visible value as string
			String val = formatter.formatCellValue(cell);

			// Clean value: remove commas and trim whitespace
			val = val.replaceAll(",", "").trim();

			if (val.isEmpty() || val.equalsIgnoreCase("null")) {
				return BigDecimal.ZERO;
			}

			// Return parsed number
			return new BigDecimal(val);
		} catch (Exception e) {
			// Return zero if parsing fails to prevent entire upload from crashing
			return BigDecimal.ZERO;
		}
	}
}