package com.bornfire.xbrl.services;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bornfire.xbrl.entities.RT_VAR_PORTFOLIO_Entity;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

@Service
public class VarPortfolioUploadService {

    @Autowired
    private DataSource srcdataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public String uploadVarPortfolio(MultipartFile file,String reportType,Date toDate,boolean forceUpload) throws Exception {

        
        Set<java.sql.Date> existingDates = getExistingReportDates();

        
        List<RT_VAR_PORTFOLIO_Entity> list = readFile(file, existingDates);

        if (list.isEmpty()) {
            return "All report dates already exist. No new rows inserted.";
        }

        int inserted = uploadToOracle(list);

        return "Upload Complete. Inserted Rows: " + inserted;
    }


    private Set<java.sql.Date> getExistingReportDates() {

        String sql = "SELECT DISTINCT TRUNC(REPORT_DATE) FROM RT_VAR_PORTFOLIO_TABLE";

        List<java.sql.Date> dateList = jdbcTemplate.query(sql,(rs, rowNum) -> rs.getDate(1));

        return new HashSet<>(dateList);
    }

    
    private List<RT_VAR_PORTFOLIO_Entity> readFile(MultipartFile file,Set<java.sql.Date> existingDates) throws Exception {

        List<RT_VAR_PORTFOLIO_Entity> list = new ArrayList<>();

        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {

            DataFormatter formatter = new DataFormatter();
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {

                
                if (row.getRowNum() == 0)
                    continue;

                if (isRowEmpty(row))
                    continue;

                RT_VAR_PORTFOLIO_Entity e = new RT_VAR_PORTFOLIO_Entity();

                
                Date reportDate = getDate(row.getCell(0));

                if (reportDate == null)
                    continue;

                java.sql.Date sqlDate =new java.sql.Date(reportDate.getTime());

               
                if (existingDates.contains(sqlDate)) {
                    continue;
                }

                existingDates.add(sqlDate);

                e.setReportDate(sqlDate);
                e.setTotalPortfolioLiqdnValue(getBigDecimal(row.getCell(1), formatter));
                e.setVarOnForex(getBigDecimal(row.getCell(2), formatter));
                e.setVarOnInvestmentsAfs(getBigDecimal(row.getCell(3), formatter));
                e.setVarOnEquitiesAfs(getBigDecimal(row.getCell(4), formatter));
                e.setVarOnMoneyMktAfs(getBigDecimal(row.getCell(5), formatter));
                e.setVarOnEquitiesHft(getBigDecimal(row.getCell(6), formatter));
                e.setVarOnPdHft(getBigDecimal(row.getCell(7), formatter));
                e.setVarOnBkBondsHft(getBigDecimal(row.getCell(8), formatter));
                e.setVarOnIrsCirsHft(getBigDecimal(row.getCell(9), formatter));
                e.setTotalVar(getBigDecimal(row.getCell(10), formatter));
                e.setVarPercentOfLiqdnValue(getBigDecimal(row.getCell(11), formatter));
                e.setDelFlg("N");
                e.setEntityFlg("Y");
                e.setModifyFlg("N");
                e.setVerifyFlg("N");
                e.setEntryUser("SYSTEM");
                e.setEntryTime(new java.sql.Date(System.currentTimeMillis()));
                e.setVerifyUser(null);
                e.setVerifyTime(null);

                list.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while reading Excel file", e);
        }

        return list;
    }

    
    private int uploadToOracle(List<RT_VAR_PORTFOLIO_Entity> list) throws Exception {

        int totalInserted = 0;

        try (Connection conn = srcdataSource.getConnection()) {

            conn.setAutoCommit(false);

            oracle.jdbc.OracleConnection oracleConn =
                    conn.unwrap(oracle.jdbc.OracleConnection.class);

            StructDescriptor structDesc =
                    StructDescriptor.createDescriptor(
                            "RT_VAR_PORTFOLIO_OBJECT",
                            oracleConn);

            ArrayDescriptor arrayDesc =
                    ArrayDescriptor.createDescriptor(
                            "RT_VAR_PORTFOLIO_TABLE_TYPE",
                            oracleConn);

            STRUCT[] structArray = new STRUCT[list.size()];
            int idx = 0;

            for (RT_VAR_PORTFOLIO_Entity e : list) {

                Object[] attributes = new Object[] {
                        e.getReportDate(),
                        e.getTotalPortfolioLiqdnValue(),
                        e.getVarOnForex(),
                        e.getVarOnInvestmentsAfs(),
                        e.getVarOnEquitiesAfs(),
                        e.getVarOnMoneyMktAfs(),
                        e.getVarOnEquitiesHft(),
                        e.getVarOnPdHft(),
                        e.getVarOnBkBondsHft(),
                        e.getVarOnIrsCirsHft(),
                        e.getTotalVar(),
                        e.getVarPercentOfLiqdnValue(),
                        e.getDelFlg(),
                        e.getEntityFlg(),
                        e.getModifyFlg(),
                        e.getVerifyFlg(),
                        e.getEntryUser(),
                        e.getEntryTime(),
                        e.getVerifyUser(),
                        e.getVerifyTime()
                };

                structArray[idx++] =
                        new STRUCT(structDesc, oracleConn, attributes);
            }

            ARRAY oracleArray =
                    new ARRAY(arrayDesc, oracleConn, structArray);

            CallableStatement cs =
                    conn.prepareCall(
                            "{ ? = call SAVE_RT_VAR_PORTFOLIO_FN(?) }");

            cs.registerOutParameter(1, Types.NUMERIC);
            cs.setArray(2, oracleArray);

            cs.execute();

            totalInserted = cs.getInt(1);

            cs.close();
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(
                    "Error while uploading to Oracle table", e);
        }

        return totalInserted;
    }

    
    private BigDecimal getBigDecimal(Cell cell, DataFormatter formatter) {

        if (cell == null)
            return BigDecimal.ZERO;

        String value = formatter.formatCellValue(cell);

        if (value == null || value.trim().isEmpty())
            return BigDecimal.ZERO;

        try {
            
            value = value.replace(",", "").trim();

            return new BigDecimal(value);

        } catch (Exception e) {
            throw new RuntimeException(
                    "Invalid numeric value: " + value);
        }
    }

    
    private LocalDate getLocalDateFromCell(Cell cell) {

        if (cell == null)
            return null;

        try {

            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {

                if (DateUtil.isCellDateFormatted(cell)) {

                    Date date = cell.getDateCellValue();

                    return date.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();
                }
            }

            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {

                String value = cell.getStringCellValue();

                if (value == null || value.trim().isEmpty())
                    return null;

                value = value.trim();

                try {
                    return LocalDate.parse(
                            value,
                            DateTimeFormatter.ofPattern("dd-MMM-yy"));
                } catch (Exception e) {}

                try {
                    return LocalDate.parse(
                            value,
                            DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
                } catch (Exception e) {}

                try {
                    return LocalDate.parse(
                            value,
                            DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                } catch (Exception e) {}

                try {
                    return LocalDate.parse(
                            value,
                            DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                } catch (Exception e) {}

                throw new RuntimeException(
                        "Unsupported date format: " + value);
            }

        } catch (Exception e) {
            throw new RuntimeException(
                    "Error while reading REPORT_DATE", e);
        }

        return null;
    }

    private Date getDate(Cell cell) {

        if (cell == null)
            return null;

        LocalDate localDate = getLocalDateFromCell(cell);

        if (localDate == null)
            return null;

        return java.sql.Date.valueOf(localDate);
    }

    
    private boolean isRowEmpty(Row row) {

        if (row == null)
            return true;

        DataFormatter formatter = new DataFormatter();

        for (int i = row.getFirstCellNum();
             i < row.getLastCellNum();
             i++) {

            Cell cell = row.getCell(i);

            if (cell != null) {

                String value =
                        formatter.formatCellValue(cell).trim();

                if (!value.isEmpty()) {
                    return false;
                }
            }
        }

        return true;
    }
}