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