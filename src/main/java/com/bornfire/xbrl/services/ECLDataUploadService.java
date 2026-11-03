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
	


	public void deleteByReportDate(Date reportDate) {
	    if (reportDate == null) {
	        throw new RuntimeException("Report date is required.");
	    }
	    jdbcTemplate.update(
	            "DELETE FROM ECL_REPORT_TABLE WHERE TRUNC(REPORT_DATE)=TRUNC(?)",
	            new java.sql.Date(reportDate.getTime()));
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
