package com.bornfire.xbrl.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
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

import com.bornfire.xbrl.entities.BRF_FB_NFB_PROVISIONING_Entity;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

@Service
public class ProvisioningFileUploadService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource srcdataSource;

    public String ProvisioningFileUpload(MultipartFile file, String reportType, Date toDate, boolean forceUpload) throws Exception {

        
        String checkSql = "SELECT COUNT(*) FROM BRF_FB_NFB_PROVISIONING_TABLE WHERE TRUNC(LST_EXEDATE)=TRUNC(?)";

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
                    "DELETE FROM BRF_FB_NFB_PROVISIONING_TABLE WHERE TRUNC(LST_EXEDATE)=TRUNC(?)",
                    new java.sql.Date(toDate.getTime())
            );
        }

        // ✅ 2. Read File
        List<BRF_FB_NFB_PROVISIONING_Entity> dataList = readFile(file);

        if (dataList.isEmpty()) {
            throw new RuntimeException("File contains no valid data");
        }
        
        Date excelDate = dataList.get(0).getLstExeDate();

	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	    if (excelDate == null || !sdf.format(excelDate).equals(sdf.format(toDate))) {
	        throw new RuntimeException("Report Date Mismatched with the Selected Report Date");
	    }

        // ✅ 3. Oracle Upload
        int inserted = uploadToOracle(dataList);

        return "Upload Complete. Inserted Rows: " + inserted;
    }

    public void deleteByReportDate(Date reportDate) {
        if (reportDate == null) {
            throw new RuntimeException("Report date is required.");
        }
        jdbcTemplate.update(
                "DELETE FROM BRF_FB_NFB_PROVISIONING_TABLE WHERE TRUNC(LST_EXEDATE)=TRUNC(?)",
                new java.sql.Date(reportDate.getTime()));
    }

    // ==========================================================
    // ✅ FILE READING
    // ==========================================================

    private List<BRF_FB_NFB_PROVISIONING_Entity> readFile(MultipartFile file) throws Exception {

        List<BRF_FB_NFB_PROVISIONING_Entity> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

      
            String line;
			String delimiter = "\\|";

            while ((line = br.readLine()) != null) {

            	line = line.trim();
				if (line.isEmpty())
					continue;

                if (line.toUpperCase().startsWith("SOL_ID")) continue;

                String[] v = line.split("\\|", -1);
                if (v.length < 31) {
                    throw new RuntimeException("Invalid column count in file");
                }
                
                System.out.println("solid="+v[0]);

                BRF_FB_NFB_PROVISIONING_Entity e = new BRF_FB_NFB_PROVISIONING_Entity();
                e.setSolId(v[0].trim());
                e.setCustId(v[1].trim());
                e.setForacid(v[2].trim());
                e.setAcctName(v[3].trim());
                e.setAssetClass(v[4].trim());
                e.setClassNew(v[5].trim());

                e.setOsAmt(toBigDecimal(v[6]));
                e.setAccountCrncy(v[7].trim());
                e.setDeductionAmt(toBigDecimal(v[8]));
                e.setIntSuspAmt(toBigDecimal(v[9]));
                e.setNetOsAmt(toBigDecimal(v[10]));
                e.setAllocSecAmt(toBigDecimal(v[11]));
                e.setSecAmt(toBigDecimal(v[12]));
                e.setUnsecAmt(toBigDecimal(v[13]));
                e.setHomeSecProv(toBigDecimal(v[14]));
                e.setHomeUnsecProv(toBigDecimal(v[15]));
                e.setHomeTotProv(toBigDecimal(v[16]));
                e.setCollaccDisc(toBigDecimal(v[17]));
                e.setNetExposure(toBigDecimal(v[18]));
                e.setHostProv(toBigDecimal(v[19]));
                e.setHostProvOld(toBigDecimal(v[20]));
                e.setHostProvNew(toBigDecimal(v[21]));
                e.setStringentProv(toBigDecimal(v[22]));
                e.setAddProv(toBigDecimal(v[23]));
                e.setTotalProv(toBigDecimal(v[24]));

                e.setNpaDate(toDate(v[25]));
                e.setLstExeDate(toDate(v[26]));
                e.setDelFlg(v[27].trim());
                e.setOrigValBgAmt(toBigDecimal(v[28]));
                e.setDcBillUtilAmt(toBigDecimal(v[29]));
                e.setContLiabAmt(toBigDecimal(v[30]));
                list.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();   
            throw new RuntimeException("Error reading file: " + e.getMessage(), e);
        }

        return list;
    }

    // ==========================================================
    // ✅ ORACLE STRUCT UPLOAD
    // ==========================================================

    private int uploadToOracle(List<BRF_FB_NFB_PROVISIONING_Entity> list) throws Exception {

        int totalInserted = 0;
        int batchSize = 5000;

        try (Connection conn = srcdataSource.getConnection()) {

            conn.setAutoCommit(false);

            oracle.jdbc.OracleConnection oracleConn = conn.unwrap(oracle.jdbc.OracleConnection.class);

            StructDescriptor structDesc =
                    StructDescriptor.createDescriptor("BRF_FB_NFB_PROVISIONING_UPLOAD_OBJECT", oracleConn);

            ArrayDescriptor arrayDesc =
                    ArrayDescriptor.createDescriptor("BRF_FB_NFB_PROVISIONING_UPLOAD_TABLE", oracleConn);

            for (int i = 0; i < list.size(); i += batchSize) {

                List<BRF_FB_NFB_PROVISIONING_Entity> batch =
                        list.subList(i, Math.min(i + batchSize, list.size()));

                STRUCT[] structs = new STRUCT[batch.size()];

                int idx = 0;

                for (BRF_FB_NFB_PROVISIONING_Entity e : batch) {

                    Object[] attr = new Object[]{
                            e.getSolId(),
                            e.getCustId(),
                            e.getForacid(),
                            e.getAcctName(),
                            e.getAssetClass(),
                            e.getClassNew(),
                            e.getOsAmt(),
                            e.getAccountCrncy(),
                            e.getDeductionAmt(),
                            e.getIntSuspAmt(),
                            e.getNetOsAmt(),
                            e.getAllocSecAmt(),
                            e.getSecAmt(),
                            e.getUnsecAmt(),
                            e.getHomeSecProv(),
                            e.getHomeUnsecProv(),
                            e.getHomeTotProv(),
                            e.getCollaccDisc(),
                            e.getNetExposure(),
                            e.getHostProv(),
                            e.getHostProvOld(),
                            e.getHostProvNew(),
                            e.getStringentProv(),
                            e.getAddProv(),
                            e.getTotalProv(),
                            e.getNpaDate(),
                            e.getLstExeDate(),
                            e.getDelFlg(),
                            e.getOrigValBgAmt(),
                            e.getDcBillUtilAmt(),
                            e.getContLiabAmt()
                    };

                    structs[idx++] = new STRUCT(structDesc, oracleConn, attr);
                }

                ARRAY array = new ARRAY(arrayDesc, oracleConn, structs);

                CallableStatement cs =
                        conn.prepareCall("{ ? = call SAVE_BRF_FB_NFB_UPLOAD_FN(?) }");

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
        if (val == null || val.trim().isEmpty()) return BigDecimal.ZERO;
        return new BigDecimal(val.trim());
    }

    private java.sql.Date toDate(String val) {
        try {
            if (val == null || val.trim().isEmpty()) return null;
            return java.sql.Date.valueOf(
                    LocalDate.parse(val.trim(), DateTimeFormatter.ofPattern("dd-MM-yyyy"))
            );
        } catch (Exception e) {
            throw new RuntimeException("Invalid date: " + val);
        }
    }

    private boolean isSameDate(Date d1, Date d2) {
        return new java.sql.Date(d1.getTime())
                .equals(new java.sql.Date(d2.getTime()));
    }
}