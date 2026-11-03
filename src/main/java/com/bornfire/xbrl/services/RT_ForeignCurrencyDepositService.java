package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.ss.usermodel.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.io.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.io.FileNotFoundException;


@Service
public class RT_ForeignCurrencyDepositService {
	
    private static final Logger logger = LoggerFactory.getLogger(RT_ForeignCurrencyDepositService.class);


    @Autowired
    private Environment env;


    @Autowired
    private SessionFactory sessionFactory;
    
	@Autowired
	AuditService auditservice;  
    

    private Sheet findSheet(Workbook workbook, String expectedName) {
        Sheet sheet = workbook.getSheet(expectedName);
        if (sheet != null) {
            return sheet;
        }

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            String name = workbook.getSheetName(i);
            if (name != null && name.trim().equalsIgnoreCase(expectedName)) {
                return workbook.getSheetAt(i);
            }
        }

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            String name = workbook.getSheetName(i);
            if (name != null && name.toLowerCase().contains("foreign curr")) {
                return workbook.getSheetAt(i);
            }
        }

        return null;
    }

    private Cell getOrCreateCell(Row row, int col) {
        Cell cell = row.getCell(col);
        if (cell == null) {
            cell = row.createCell(col);
        }
        return cell;
    }

    private void setStringCell(Row row, int col, String value) {
        getOrCreateCell(row, col).setCellValue(value == null ? "" : value);
    }

    private void setDateCell(Row row, int col, Date value, CellStyle dateStyle) {
        Cell cell = getOrCreateCell(row, col);
        if (value != null) {
            cell.setCellValue(value);
            cell.setCellStyle(dateStyle);
        } else {
            cell.setCellValue("");
        }
    }

    private void setNumericCell(Row row, int col, Object value, CellStyle numberStyle) {
        Cell cell = getOrCreateCell(row, col);
        if (value instanceof Number) {
            cell.setCellValue(((Number) value).doubleValue());
            cell.setCellStyle(numberStyle);
            return;
        }
        if (value != null && !value.toString().trim().isEmpty()) {
            try {
                cell.setCellValue(Double.parseDouble(value.toString().trim()));
                cell.setCellStyle(numberStyle);
                return;
            } catch (NumberFormatException e) {
                cell.setCellValue(value.toString());
                return;
            }
        }
        cell.setCellValue("");
    }
}
