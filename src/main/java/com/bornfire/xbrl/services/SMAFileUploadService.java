package com.bornfire.xbrl.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bornfire.xbrl.entities.BRF_SMA_MASTER_DATA_Entity;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

@Service
public class SMAFileUploadService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource srcdataSource;

    public String SMAFileUpload(MultipartFile file, String reportType, Date toDate, boolean forceUpload) throws Exception {

        // ✅ 1. CHECK EXISTING DATA
        String checkSql = "SELECT COUNT(*) FROM BRF_SMA_MASTER_DATA_TABLE WHERE TRUNC(AS_ON_DATE)=TRUNC(?)";

        Integer count = jdbcTemplate.queryForObject(
                checkSql,
                Integer.class,
                new java.sql.Date(toDate.getTime())
        );

        Date today = new Date();

        if (count != null && count > 0 && !forceUpload) {
	        throw new RuntimeException("already uploaded");
	    }

        if (count != null && count > 0 && forceUpload) {
            jdbcTemplate.update(
                    "DELETE FROM BRF_SMA_MASTER_DATA_TABLE WHERE TRUNC(AS_ON_DATE)=TRUNC(?)",
                    new java.sql.Date(toDate.getTime())
            );
        }

        // ✅ 2. READ FILE
        List<BRF_SMA_MASTER_DATA_Entity> dataList = readFile(file);

        if (dataList.isEmpty()) {
            throw new RuntimeException("File contains no valid data");
        }
        
        Date excelDate = dataList.get(0).getAsOnDate();

	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	    if (excelDate == null || !sdf.format(excelDate).equals(sdf.format(toDate))) {
	        throw new RuntimeException("Report Date Mismatched with the Selected Report Date");
	    }

        // ✅ 3. UPLOAD TO ORACLE
        int inserted = uploadToOracle(dataList);

        return "Upload Complete. Inserted Rows: " + inserted;
    }

    public void deleteByReportDate(Date reportDate) {
        if (reportDate == null) {
            throw new RuntimeException("Report date is required.");
        }
        jdbcTemplate.update(
                "DELETE FROM BRF_SMA_MASTER_DATA_TABLE WHERE TRUNC(AS_ON_DATE)=TRUNC(?)",
                new java.sql.Date(reportDate.getTime()));
    }

    // ==========================================================
    // ✅ FILE READING (FIXED)
    // ==========================================================

    private List<BRF_SMA_MASTER_DATA_Entity> readFile(MultipartFile file) {

        List<BRF_SMA_MASTER_DATA_Entity> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {

            String line;

            while ((line = br.readLine()) != null) {

                line = line.trim();
                if (line.isEmpty()) continue;

                String upper = line.toUpperCase();
                if (upper.startsWith("TERRITORY") || upper.startsWith("SQL") || upper.startsWith("--"))
                    continue;

                String[] v = line.split("\\|", -1); // ✅ important

                if (v.length < 27) {
                    System.out.println("Invalid row skipped: " + line);
                    continue;
                }

                BRF_SMA_MASTER_DATA_Entity e = new BRF_SMA_MASTER_DATA_Entity();

                e.setTerritory(v[0].trim());
                e.setBranch(v[1].trim());
                e.setSolId(v[2].trim());
                e.setCustomerId(v[3].trim());
                e.setAccountName(v[4].trim());
                e.setAccountNo(v[5].trim());
                e.setBillId(v[6].trim());
                e.setSchemeCode(v[7].trim());
                e.setGlSubHead(v[8].trim());
                e.setAccountCcy(v[9].trim());

                e.setClearBalAmt(toBigDecimal(v[10]));
                e.setCreditTurnover(toBigDecimal(v[11]));
                e.setIntChargesAmt(toBigDecimal(v[12]));

                e.setContExcessSince(toDate(v[13]));
                e.setOverdueDueDate(toDate(v[14]));

                e.setTotalOverdue(toBigDecimal(v[15]));
                e.setSma0(toBigDecimal(v[16]));
                e.setSma1(toBigDecimal(v[17]));
                e.setSma2(toBigDecimal(v[18]));

                e.setReviewDate(toDate(v[19]));
                e.setStkStatementDate(toDate(v[20]));

                e.setReasonForDegradation(v[21].trim());

                e.setCustomerWiseOsBalance(toBigDecimal(v[22]));
                e.setNpaDate(toDate(v[23]));

                e.setDpd(toBigDecimal(v[24]));
                e.setAsOnDate(toDate(v[25]));

                e.setPanNumber(v[26].trim());

                list.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading SMA file: " + e.getMessage(), e);
        }

        return list;
    }

    // ==========================================================
    // ✅ ORACLE UPLOAD
    // ==========================================================

    private int uploadToOracle(List<BRF_SMA_MASTER_DATA_Entity> list) throws Exception {

        int totalInserted = 0;
        int batchSize = 5000;

        try (Connection conn = srcdataSource.getConnection()) {

            conn.setAutoCommit(false);

            oracle.jdbc.OracleConnection oracleConn =
                    conn.unwrap(oracle.jdbc.OracleConnection.class);

            StructDescriptor structDesc =
                    StructDescriptor.createDescriptor("BRF_SMA_MASTER_DATA_OBJECT", oracleConn);

            ArrayDescriptor arrayDesc =
                    ArrayDescriptor.createDescriptor("BRF_SMA_MASTER_DATA_TABLE_TYPE", oracleConn);

            for (int i = 0; i < list.size(); i += batchSize) {

                List<BRF_SMA_MASTER_DATA_Entity> batch =
                        list.subList(i, Math.min(i + batchSize, list.size()));

                STRUCT[] structs = new STRUCT[batch.size()];

                int idx = 0;

                for (BRF_SMA_MASTER_DATA_Entity e : batch) {

                    Object[] attr = new Object[]{
                            e.getTerritory(),
                            e.getBranch(),
                            e.getSolId(),
                            e.getCustomerId(),
                            e.getAccountName(),
                            e.getAccountNo(),
                            e.getBillId(),
                            e.getSchemeCode(),
                            e.getGlSubHead(),
                            e.getAccountCcy(),
                            e.getClearBalAmt(),
                            e.getCreditTurnover(),
                            e.getIntChargesAmt(),
                            e.getContExcessSince(),
                            e.getOverdueDueDate(),
                            e.getTotalOverdue(),
                            e.getSma0(),
                            e.getSma1(),
                            e.getSma2(),
                            e.getReviewDate(),
                            e.getStkStatementDate(),
                            e.getReasonForDegradation(),
                            e.getCustomerWiseOsBalance(),
                            e.getNpaDate(),
                            e.getDpd(),
                            e.getAsOnDate(),
                            e.getPanNumber()
                    };

                    structs[idx++] = new STRUCT(structDesc, oracleConn, attr);
                }

                ARRAY array = new ARRAY(arrayDesc, oracleConn, structs);

                CallableStatement cs =
                        conn.prepareCall("{ ? = call SAVE_SMA_MASTER_DATA_FN(?) }");

                cs.registerOutParameter(1, Types.NUMERIC);
                cs.setArray(2, array);

                cs.execute();

                totalInserted += cs.getInt(1);

                cs.close();
            }

            conn.commit();
        }

        return totalInserted;
    }

    // ==========================================================
    // ✅ HELPERS
    // ==========================================================

    private BigDecimal toBigDecimal(String val) {
        try {
            if (val == null || val.trim().isEmpty()) return BigDecimal.ZERO;
            return new BigDecimal(val.trim());
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }

    private java.sql.Date toDate(String val) {
        try {
            if (val == null || val.trim().isEmpty()) return null;

            return java.sql.Date.valueOf(
                    LocalDate.parse(val.trim(), DateTimeFormatter.ofPattern("dd-MM-yyyy"))
            );
        } catch (Exception e) {
            System.out.println("Invalid date: " + val);
            return null;
        }
    }

    private boolean isSameDate(Date d1, Date d2) {
        return new java.sql.Date(d1.getTime())
                .equals(new java.sql.Date(d2.getTime()));
    }
}