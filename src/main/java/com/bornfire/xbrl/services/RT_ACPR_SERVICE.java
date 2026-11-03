package com.bornfire.xbrl.services;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.bornfire.xbrl.entities.*;

@Service
@Transactional
public class RT_ACPR_SERVICE {

	
	@Autowired
	AuditService auditservice;

	
    private Date parseDate(String value) {
        try {
            if (value == null || value.trim().isEmpty()) {
                return null;
            }
            value = value.trim();
            // handle dd-MM-yyyy
            if (value.length() == 10) {
                return new SimpleDateFormat("dd-MM-yyyy").parse(value);
            }
            // handle dd-MM-yy
            if (value.length() == 8) {
                return new SimpleDateFormat("dd-MM-yy").parse(value);
            }
        } catch (Exception e) {
            System.out.println("Invalid Date Value: " + value);
        }
        return null;
    }
    private Date getAcprFileReportDate(MultipartFile file) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String line;
        int rowNum = 0;
        while ((line = br.readLine()) != null) {
            rowNum++;
            if (rowNum == 1 || line.trim().isEmpty()) {
                continue;
            }
            String[] data = line.split("\\|", -1);
            if (data.length > 0) {
                return new SimpleDateFormat("dd-MM-yyyy").parse(data[0].trim());
            }
        }
        return null;
    }
	// 1. Method for ACPR (Fund Based - 55 Columns)

	// 2. Method for ACPRNF (Non-Fund Based - 11 Columns)

	private Date parseDate(String s, SimpleDateFormat sdf) {
		try { return (s == null || s.trim().isEmpty()) ? null : sdf.parse(s.trim()); } catch (Exception e) { return null; }
	}

	private BigDecimal parseNum(String s) {
		try { return (s == null || s.trim().isEmpty()) ? BigDecimal.ZERO : new BigDecimal(s.trim().replace(",", "")); } catch (Exception e) { return BigDecimal.ZERO; }
	}
}