package com.bornfire.xbrl.services;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import com.bornfire.xbrl.util.ExcelUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bornfire.xbrl.entities.Eod_acct_balance_pojo;
import com.bornfire.xbrl.entities.RT_Ecl_upload_Entity;
import com.bornfire.xbrl.entities.RtInvestmentDealDataDump;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

@Service
public class ECLDataUploadService {
	
	@Autowired
	private DataSource srcdataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public String uploadECLdata(MultipartFile file, Date toDate, boolean forceUpload) throws Exception {

	   
	    String checkSql = "SELECT COUNT(*) FROM ECL_REPORT_TABLE WHERE TRUNC(REPORT_DATE)=TRUNC(?)";

	    Integer count = jdbcTemplate.queryForObject(
	            checkSql,
	            Integer.class,
	            new java.sql.Date(toDate.getTime())
	    );

	    if (count != null && count > 0 && !forceUpload) {
	        throw new RuntimeException("already uploaded");
	    }

	    if (count != null && count > 0 && forceUpload) {
	        jdbcTemplate.update(
	                "DELETE FROM ECL_REPORT_TABLE WHERE TRUNC(REPORT_DATE)=TRUNC(?)",
	                new java.sql.Date(toDate.getTime())
	        );
	    }

	    List<RT_Ecl_upload_Entity> list = readExcel(file);

	    if (list == null || list.isEmpty()) {
	        throw new RuntimeException("Uploaded file is empty");
	    }

	    Date excelDate = list.get(0).getReport_date();

	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	    if (excelDate == null || !sdf.format(excelDate).equals(sdf.format(toDate))) {
	        throw new RuntimeException("Report Date Mismatched with the Selected Report Date");
	    }

	  
	    int inserted = saveECLBatch(list);

	    return "Upload Complete. Rows Inserted: " + inserted;
	}

	public void deleteByReportDate(Date reportDate) {
	    if (reportDate == null) {
	        throw new RuntimeException("Report date is required.");
	    }
	    jdbcTemplate.update(
	            "DELETE FROM ECL_REPORT_TABLE WHERE TRUNC(REPORT_DATE)=TRUNC(?)",
	            new java.sql.Date(reportDate.getTime()));
	}
	
	
	private List<RT_Ecl_upload_Entity> readExcel(MultipartFile file) throws Exception {

	    List<RT_Ecl_upload_Entity> list = new ArrayList<>();

	    try (Workbook workbook = ExcelUploadHelper.openExcelWorkbook(file)) {

	        DataFormatter formatter = new DataFormatter();
	        Sheet sheet = workbook.getSheetAt(0);

	        for (Row row : sheet) {

	            if (row.getRowNum() == 0) continue;
	            if (isRowEmpty(row)) continue;

	            RT_Ecl_upload_Entity e = new RT_Ecl_upload_Entity();
	            
	            e.setFacilityid(getString(row.getCell(0), formatter));
	            e.setCustomerid(getString(row.getCell(1), formatter));
	            e.setCust_name(getString(row.getCell(2), formatter));
	            e.setCurrency(getString(row.getCell(3), formatter));
	            e.setDrawnamount(getBigDecimal(row.getCell(4), formatter));
	            e.setUndrawnamount(getBigDecimal(row.getCell(5), formatter));
	            e.setEad(getBigDecimal(row.getCell(6), formatter));
	            e.setReport_date(getDate(row.getCell(7)));
	            e.setStage(getString(row.getCell(8), formatter));
	            e.setEcl_mgmt_overlay(getBigDecimal(row.getCell(9), formatter));
	            e.setSpecific_provision(getBigDecimal(row.getCell(10), formatter));
	            e.setInterest_suspense(getBigDecimal(row.getCell(11), formatter));
	            e.setCountry(getString(row.getCell(12), formatter));
	            e.setTransfer_stage(getString(row.getCell(13), formatter));
	            e.setBrf_1_classification(getString(row.getCell(14), formatter));
	            e.setBrf_106(getString(row.getCell(15), formatter));
	            e.setBrf_107(getString(row.getCell(16), formatter));
	            e.setBasel_2_category(getString(row.getCell(17), formatter));
	            e.setWait_pd(getString(row.getCell(18), formatter));
	            
	            
	            
	            list.add(e);
	        }
	    }

	    return list;
	}
	
	private int saveECLBatch(List<RT_Ecl_upload_Entity> list) throws Exception {

	    int totalInserted = 0;
	   

	    try (Connection conn = srcdataSource.getConnection()) {
	    	

	        conn.setAutoCommit(false);

	        oracle.jdbc.OracleConnection oracleConn = (oracle.jdbc.OracleConnection) conn;

	        StructDescriptor structDesc = StructDescriptor.createDescriptor("ECL_UPLOAD_OBJECT", oracleConn);
	        ArrayDescriptor arrayDesc = ArrayDescriptor.createDescriptor("ECL_UPLOAD_TABLE", oracleConn);

	        STRUCT[] structArray = new STRUCT[list.size()];
	        int i = 0;

	        for (RT_Ecl_upload_Entity e : list) {

	            Object[] attr = {
	                e.getFacilityid(), e.getCustomerid(), e.getCust_name(), e.getCurrency(),
	                e.getDrawnamount(), e.getUndrawnamount(), e.getEad(),
	                e.getReport_date(), e.getStage(), e.getEcl_mgmt_overlay(),
	                e.getSpecific_provision(), e.getInterest_suspense(),
	                e.getCountry(), e.getTransfer_stage(),
	                e.getBrf_1_classification(),e.getBrf_106(), e.getBrf_107(), e.getBasel_2_category(),
	                e.getWait_pd()
	            };

	            structArray[i++] = new STRUCT(structDesc, oracleConn, attr);
	        }

	        ARRAY array = new ARRAY(arrayDesc, oracleConn, structArray);

	        CallableStatement cs = conn.prepareCall("{ ? = call SAVE_ECL_UPLOAD_FN(?) }");
	        
	        cs.registerOutParameter(1, Types.NUMERIC); 
	        cs.setArray(2, array);              
	        cs.execute();

	        totalInserted = cs.getInt(1);

	        conn.commit();
	    }

	    return totalInserted;
	}
	
	private boolean isRowEmpty(Row row) {
	    if (row == null) return true;

	    DataFormatter formatter = new DataFormatter();

	    for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
	        Cell cell = row.getCell(i);

	        if (cell != null) {
	            String value = formatter.formatCellValue(cell).trim();
	            if (!value.isEmpty()) {
	                return false;
	            }
	        }
	    }
	    return true;
	}
	
	private LocalDate getLocalDateFromCell(Cell cell) {
	    if (cell == null) return null;

	    if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
	        if (DateUtil.isCellDateFormatted(cell)) {
	            Date date = cell.getDateCellValue();
	            return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	        }
	    }
	    return null;
	}
	
	private String getString(Cell cell, DataFormatter formatter) {
	    if (cell == null) return null;
	    String value = formatter.formatCellValue(cell);
	    return value != null && !value.trim().isEmpty() ? value.trim() : null;
	}

	private BigDecimal getBigDecimal(Cell cell, DataFormatter formatter) {

	    if (cell == null)
	        return BigDecimal.ZERO;

	    String value = formatter.formatCellValue(cell);

	    if (value == null || value.trim().isEmpty())
	        return BigDecimal.ZERO;

	    try {
	        // Remove comma separators
	        value = value.replace(",", "").trim();

	        return new BigDecimal(value);

	    } catch (Exception e) {
	        throw new RuntimeException(
	                "Invalid numeric value: " + value
	        );
	    }
	}

	private Date getDate(Cell cell) {
	    if (cell == null) return null;

	    try {
	        LocalDate localDate = getLocalDateFromCell(cell);
	        return (localDate != null) ? java.sql.Date.valueOf(localDate) : null;
	    } catch (Exception e) {
	        throw new RuntimeException("Invalid date format in Excel");
	    }
	}
	
	

}
