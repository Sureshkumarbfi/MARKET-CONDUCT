package com.bornfire.xbrl.services;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bornfire.xbrl.entities.*;
import com.bornfire.xbrl.entities.RT_MC_DATA_RECORD_REPO.RecordMetadataProjection;
import com.microsoft.schemas.office.visio.x2012.main.CellType;

@Service
public class RT_MC_TABLE_ALL_Service {
	private static final Logger logger = LoggerFactory.getLogger(RT_MC_TABLE_ALL_Service.class);

	@Autowired
	private Environment env;

	@Autowired
	AuditService auditservice;
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	RT_MC_TABLE1_REPO RT_MC_TABLE1_REPO;
	@Autowired
	RT_MC_TABLE2_1_REPO RT_MC_TABLE2_1_REPO;
	@Autowired
	RT_MC_TABLE2_2_REPO RT_MC_TABLE2_2_REPO;
	@Autowired
	RT_MC_TABLE3_REPO RT_MC_TABLE3_REPO;
	@Autowired
	RT_MC_TABLE4_1_REPO RT_MC_TABLE4_1_REPO;
	@Autowired
	RT_MC_TABLE4_2_REPO RT_MC_TABLE4_2_REPO;
	@Autowired
	RT_MC_TABLE5_REPO RT_MC_TABLE5_REPO;
	@Autowired
	RT_MC_TABLE6_REPO RT_MC_TABLE6_REPO;
	@Autowired
	RT_MC_TABLE7_1_REPO RT_MC_TABLE7_1_REPO;
	@Autowired
	RT_MC_TABLE7_2_REPO RT_MC_TABLE7_2_REPO;
	@Autowired
	RT_MC_TABLE8_REPO RT_MC_TABLE8_REPO;
	@Autowired
	RT_MC_TABLE9_REPO RT_MC_TABLE9_REPO;
	@Autowired
	RT_MC_DATA_RECORD_REPO RT_MC_DATA_RECORD_REPO;
	@Autowired
	RT_MC_Description_Repo RT_MC_Description_Repo;

	String templateFileName = "1.Main_RBS_MC_Bank of Baroda_Annual_Data Submission.xlsx";

	public byte[] generateReportFile(String branch, String jobId, Map<String, Integer> progressMap, String formmode,
			String reportDate, String userid, ServletRequestAttributes attr, String isConsolidated, String reportOption,
			String selectedDepartments, String specialValues, String tableNames) throws Exception {
		long downloadStarted = System.currentTimeMillis();
		logger.info(
				"MC download START jobId={} formmode={} reportDate={} branch={} consolidated={} reportOption={} departments={} specialValues={} tables={}",
				jobId, formmode, reportDate, branch, isConsolidated, reportOption, selectedDepartments, specialValues,
				tableNames);
		try {
		if (specialValues != null && !specialValues.trim().isEmpty()) {
			logger.info("MC download jobId={} path=not-applicability specialValues={}", jobId, specialValues);
			setMcProgress(progressMap, jobId, 10);
			byte[] fileData = generateNotApplicabilityExcel(reportDate, branch, progressMap, jobId, specialValues);
			setMcProgress(progressMap, jobId, 100);
			logger.info("MC download END jobId={} path=not-applicability bytes={} elapsedMs={}", jobId,
					fileData == null ? 0 : fileData.length, System.currentTimeMillis() - downloadStarted);
			return fileData;
		}
		if ("manager_all".equalsIgnoreCase(reportOption) || "manager_specific".equalsIgnoreCase(reportOption)) {
			logger.info("MC download jobId={} path=manager tables={}", jobId, tableNames);
			setMcProgress(progressMap, jobId, 10);
			byte[] fileData = generateManagerReportsExcel(reportDate, branch, tableNames, progressMap, jobId); 
			setMcProgress(progressMap, jobId, 100);
			logger.info("MC download END jobId={} path=manager bytes={} elapsedMs={}", jobId,
					fileData == null ? 0 : fileData.length, System.currentTimeMillis() - downloadStarted);
			return fileData;
		}
		String templateDir = env.getProperty("output.exportpathtemp");
		Path templatePath = Paths.get(templateDir, templateFileName);
		System.out.println("Report Date : "+reportDate);
		System.out.println("Branch : "+branch);
		System.out.println("Consolidated : "+isConsolidated);
		logger.info("MC download jobId={} opening template {}", jobId, templatePath.toAbsolutePath());

		if (!Files.exists(templatePath)) {
			throw new FileNotFoundException("Template file not found at: " + templatePath.toAbsolutePath());
		}
		if (!Files.isReadable(templatePath)) {
			throw new SecurityException(
					"Template file exists but is not readable (check permissions): " + templatePath.toAbsolutePath());
		}

		long templateStarted = System.currentTimeMillis();
		try (InputStream templateInputStream = Files.newInputStream(templatePath);
				Workbook workbook = WorkbookFactory.create(templateInputStream);
				ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			logger.info("MC download jobId={} template opened sheets={} elapsedMs={}", jobId,
					workbook.getNumberOfSheets(), System.currentTimeMillis() - templateStarted);

			if ("YES".equalsIgnoreCase(isConsolidated)) {				
				GenerateTable_1_Excel(workbook, branch, jobId, progressMap, formmode, reportDate, isConsolidated,
						reportOption, selectedDepartments);
				GenerateTable_2_Excel(workbook,branch, jobId, progressMap, formmode, reportDate, isConsolidated,
						reportOption, selectedDepartments);
				GenerateTable_3_Excel(workbook,branch, jobId, progressMap, formmode, reportDate, isConsolidated,
						reportOption, selectedDepartments);
				GenerateTable_4_Excel(workbook,branch, jobId, progressMap, formmode, reportDate, isConsolidated,
						reportOption, selectedDepartments);
				GenerateTable_5_Excel(workbook,branch, jobId, progressMap, formmode, reportDate, isConsolidated,
						reportOption, selectedDepartments);
				GenerateTable_6_Excel(workbook,branch, jobId, progressMap, formmode, reportDate, isConsolidated,
						reportOption, selectedDepartments);
				GenerateTable_7_Excel(workbook,branch, jobId, progressMap, formmode, reportDate, isConsolidated,
						reportOption, selectedDepartments);
				GenerateTable_8_Excel(workbook,branch, jobId, progressMap, formmode, reportDate, isConsolidated,
						reportOption, selectedDepartments);
				GenerateTable_9_Excel(workbook,branch, jobId, progressMap, formmode, reportDate, isConsolidated,
						reportOption, selectedDepartments);
				auditservice.auditMCEntitymanual("CONSOLIDATED DOWNLOAD", reportDate, screenName(formmode), "ALL_RBS_MC_TABLES", "",
						"Downloaded successfully", null);
			} else if ("bankinformation".equalsIgnoreCase(formmode)) {
				GenerateTable_1_Excel(workbook, branch, jobId, progressMap, formmode, reportDate, isConsolidated,
						reportOption, selectedDepartments);
				auditservice.auditMCEntitymanual("DOWNLOAD", reportDate, screenName(formmode), "RBS_MC_TABLE1", "",
						"Downloaded successfully", null);

			} else if ("bankconsumers".equalsIgnoreCase(formmode)) {
				GenerateTable_2_Excel(workbook,branch, jobId, progressMap, formmode, reportDate, isConsolidated,
						reportOption, selectedDepartments);
				auditservice.auditMCEntitymanual("DOWNLOAD", reportDate, screenName(formmode),
						"RT_MC_TABLE2_1 AND RT_MC_TABLE2_2", "", "Downloaded successfully", null);

			} else if ("complaints".equalsIgnoreCase(formmode)) {
				GenerateTable_3_Excel(workbook,branch, jobId, progressMap, formmode, reportDate, isConsolidated,
						reportOption, selectedDepartments);
				auditservice.auditMCEntitymanual("DOWNLOAD", reportDate, screenName(formmode), "RBS_MC_TABLE3", "",
						"Downloaded successfully", null);
			} else if ("retailproducts".equalsIgnoreCase(formmode)) {
				GenerateTable_4_Excel(workbook,branch, jobId, progressMap, formmode, reportDate, isConsolidated,
						reportOption, selectedDepartments);
				auditservice.auditMCEntitymanual("DOWNLOAD", reportDate, screenName(formmode),
						"RT_MC_TABLE4_1 AND RT_MC_TABLE4_2", "", "Downloaded successfully", null);
			} else if ("bankemployee".equalsIgnoreCase(formmode)) {
				GenerateTable_5_Excel(workbook,branch, jobId, progressMap, formmode, reportDate, isConsolidated,
						reportOption, selectedDepartments);
				auditservice.auditMCEntitymanual("DOWNLOAD", reportDate, screenName(formmode), "RBS_MC_TABLE5", "",
						"Downloaded successfully", null);
			} else if ("trainings".equalsIgnoreCase(formmode)) {
				GenerateTable_6_Excel(workbook,branch, jobId, progressMap, formmode, reportDate, isConsolidated,
						reportOption, selectedDepartments);
				auditservice.auditMCEntitymanual("DOWNLOAD", reportDate, screenName(formmode), "RBS_MC_TABLE6", "",
						"Downloaded successfully", null);
			} else if ("additionalinformation".equalsIgnoreCase(formmode)) {
				GenerateTable_7_Excel(workbook,branch, jobId, progressMap, formmode, reportDate, isConsolidated,
						reportOption, selectedDepartments);
				auditservice.auditMCEntitymanual("DOWNLOAD", reportDate, screenName(formmode),
						"RT_MC_TABLE7_1 AND RT_MC_TABLE7_2", "", "Downloaded successfully", null);
			} else if ("islamicbanking".equalsIgnoreCase(formmode)) {
				GenerateTable_8_Excel(workbook,branch, jobId, progressMap, formmode, reportDate, isConsolidated,
						reportOption, selectedDepartments);
				auditservice.auditMCEntitymanual("DOWNLOAD", reportDate, screenName(formmode), "RBS_MC_TABLE8", "",
						"Downloaded successfully", null);
			} else if ("conductcultureassessment".equalsIgnoreCase(formmode)) {
				GenerateTable_9_Excel(workbook,branch, jobId, progressMap, formmode, reportDate, isConsolidated,
						reportOption, selectedDepartments);
				auditservice.auditMCEntitymanual("DOWNLOAD", reportDate, screenName(formmode), "RBS_MC_TABLE9", "",
						"Downloaded successfully", null);
			} else {
				logger.warn("MC download jobId={} no table matched formmode={} consolidated={}", jobId, formmode,
						isConsolidated);
			}
			logger.info("MC download jobId={} writing workbook to memory", jobId);
			long writeStarted = System.currentTimeMillis();
			workbook.write(out);
			byte[] fileData = out.toByteArray();
			logger.info("MC download END jobId={} formmode={} bytes={} writeElapsedMs={} totalElapsedMs={}", jobId,
					formmode, fileData.length, System.currentTimeMillis() - writeStarted,
					System.currentTimeMillis() - downloadStarted);
			return fileData;
		}
		} catch (Exception e) {
			logger.error("MC download FAILED jobId={} formmode={} reportDate={} branch={} elapsedMs={}", jobId,
					formmode, reportDate, branch, System.currentTimeMillis() - downloadStarted, e);
			throw e;
		}
	}

	public void GenerateTable_1_Excel(Workbook workbook, String branch, String jobId, Map<String, Integer> progressMap, 
	        String formmode, String reportDate, String isConsolidated, String reportOption, String selectedDepartments) throws Exception {
//		logMcDownload(jobId, "fetching database rows", reportDate, branch, isConsolidated, formmode);
//		List<RT_MC_TABLE1_ENTITY> dataList ;
//		if (branch =="DEPT" || branch.equals("DEPT")) {
//			dataList = RT_MC_TABLE1_REPO.findBybranchcode(branch);
//		}
//		else {
//			dataList= RT_MC_TABLE1_REPO.findByReportDateAndBranchCode(reportDate, branch);
//			
//		}

		logMcDownload(jobId, "fetching database rows", reportDate, branch, isConsolidated, formmode);
	    List<RT_MC_TABLE1_ENTITY> dataList = new ArrayList<>();

	    if ("YES".equalsIgnoreCase(isConsolidated)) {
	        
	        List<RT_MC_TABLE1_ENTITY> numData = RT_MC_TABLE1_REPO.findByReportDateAndBranchCode(reportDate, branch);
	        List<RT_MC_TABLE1_ENTITY> deptData = RT_MC_TABLE1_REPO.findBybranchcode("DEPT");
	        
	        dataList = mergeReportData(numData, deptData, reportOption, selectedDepartments, RT_MC_TABLE1_ENTITY.class);
	        
	    } else {
	        if ("DEPT".equals(branch)) {
	            dataList = RT_MC_TABLE1_REPO.findBybranchcode(branch);
	        } else {
	            dataList = RT_MC_TABLE1_REPO.findByReportDateAndBranchCode(reportDate, branch);
	        }
	    }

	    if (dataList == null || dataList.isEmpty()) {
	        logger.warn("MC download jobId={} no rows after fetch. reportDate={} branch={} formmode={}", jobId,
	        		reportDate, branch, formmode);
	        return;
	    }
	    logger.info("MC download jobId={} fetched {} rows. Sheet write starts next.", jobId, dataList.size());
		
		try {

			Sheet sheet = openMcSheet(workbook, jobId, 3);

			// --- Style Definitions ---
			CreationHelper createHelper = workbook.getCreationHelper();

			CellStyle dateStyle = workbook.createCellStyle();
			dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
			dateStyle.setBorderBottom(BorderStyle.THIN);
			dateStyle.setBorderTop(BorderStyle.THIN);
			dateStyle.setBorderLeft(BorderStyle.THIN);
			dateStyle.setBorderRight(BorderStyle.THIN);

			CellStyle textStyle = workbook.createCellStyle();
			textStyle.setBorderBottom(BorderStyle.THIN);
			textStyle.setBorderTop(BorderStyle.THIN);
			textStyle.setBorderLeft(BorderStyle.THIN);
			textStyle.setBorderRight(BorderStyle.THIN);

			// Create the font
			Font font = workbook.createFont();
			font.setFontHeightInPoints((short) 8); // size 8
			font.setFontName("Arial");

			CellStyle numberStyle = workbook.createCellStyle();
			// numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("0.000"));
			numberStyle.setBorderBottom(BorderStyle.THIN);
			numberStyle.setBorderTop(BorderStyle.THIN);
			numberStyle.setBorderLeft(BorderStyle.THIN);
			numberStyle.setBorderRight(BorderStyle.THIN);
			numberStyle.setFont(font);
			// --- End of Style Definitions ---

			int startRow = 21;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {
					RT_MC_TABLE1_ENTITY record = dataList.get(i);
					System.out.println("rownumber=" + startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}
					setMcProgress(progressMap, jobId, 5, "writing row " + (i + 1) + " excelRow " + (startRow + i));
					updateCellPreserveStyle(row, 5, record.getR22_NO_EMP_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR22_NO_CON_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR22_AVG_NO_EMP_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR22_NO_BRN_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR22_TOT_NO_BRN_POD(), null, createHelper);
					setMcProgress(progressMap, jobId, 15);
					updateCellPreserveStyle(row, 10, record.getR22_NO_ATM_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR22_NO_ATM_DET_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR22_NO_AUT_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR22_NO_INS_BNK_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR22_NO_INS_DWN_SPC_TP(), null, createHelper);
					setMcProgress(progressMap, jobId, 35);
					updateCellPreserveStyle(row, 15, record.getR22_NO_EMP_RSK_SPC_DTE(), null, createHelper);
					updateCellPreserveStyle(row, 16, record.getR22_NO_EXT_FRD_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 17, record.getR22_NO_INT_FRD_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 18, record.getR22_NO_FRD_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 19, record.getR22_NO_FRD_PP(), null, createHelper);
					updateCellPreserveStyle(row, 20, record.getR22_TOT_REV_SPC_TP(), null, createHelper);
					setMcProgress(progressMap, jobId, 65);
					updateCellPreserveStyle(row, 21, record.getR22_TOT_INS_UNP_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 22, record.getR22_TOT_NO_HRS_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 23, record.getR22_TOT_NO_INC_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 24, record.getR22_TOT_NO_PEN_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 25, record.getR22_TOT_NO_AUT_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 26, record.getR22_TOT_NO_SAL_SPC_TP(), null, createHelper);
					setMcProgress(progressMap, jobId, 85);
					updateCellPreserveStyle(row, 27, record.getR22_TOT_NO_MER_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 28, record.getR22_NO_INQ_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 29, record.getR22_NO_SER_SPC_TP(), null, createHelper);

				}
				evaluateMcFormulas(workbook, jobId);
			} else {

			}
		
		} catch (Exception e) {
			logger.error("MC download jobId={} excel write failed reportDate={} branch={} formmode={}", jobId,
					reportDate, branch, formmode, e);
			throw e;
		}

	}

	public void GenerateTable_2_Excel(Workbook workbook,String branch, String jobId, Map<String, Integer> progressMap, String formmode,
			String reportDate, String isConsolidated, String reportOption, String selectedDepartments) throws Exception {
//		logMcDownload(jobId, "fetching database rows", reportDate, branch, isConsolidated, formmode);
//
//		List<RT_MC_TABLE2_1_ENTITY> dataList1 ;
//		List<RT_MC_TABLE2_2_ENTITY> dataList2 ;
//		if (branch =="DEPT" || branch.equals("DEPT")) {
//			dataList1 = RT_MC_TABLE2_1_REPO.findBybranchcode(branch);
//			dataList2 = RT_MC_TABLE2_2_REPO.findBybranchcode(branch);
//		}
//		else {
//			 dataList1 = RT_MC_TABLE2_1_REPO.findByReportDateAndBranchCode(reportDate, branch);
//			dataList2 = RT_MC_TABLE2_2_REPO.findByReportDateAndBranchCode(reportDate, branch);
//		}

		logMcDownload(jobId, "fetching database rows", reportDate, branch, isConsolidated, formmode);
	    List<RT_MC_TABLE2_1_ENTITY> dataList1 = new ArrayList<>();
	    List<RT_MC_TABLE2_2_ENTITY> dataList2 = new ArrayList<>();

	    if ("YES".equalsIgnoreCase(isConsolidated)) {
	        
	        List<RT_MC_TABLE2_1_ENTITY> numData1 = RT_MC_TABLE2_1_REPO.findByReportDateAndBranchCode(reportDate, branch);
	        List<RT_MC_TABLE2_1_ENTITY> deptData1 = RT_MC_TABLE2_1_REPO.findBybranchcode("DEPT");
	        List<RT_MC_TABLE2_2_ENTITY> numData2 = RT_MC_TABLE2_2_REPO.findByReportDateAndBranchCode(reportDate, branch);
	        List<RT_MC_TABLE2_2_ENTITY> deptData2 = RT_MC_TABLE2_2_REPO.findBybranchcode("DEPT");
	        dataList1 = mergeReportData(numData1, deptData1, reportOption, selectedDepartments, RT_MC_TABLE2_1_ENTITY.class);
	        dataList2 = mergeReportData(numData2, deptData2, reportOption, selectedDepartments, RT_MC_TABLE2_2_ENTITY.class);
	        
	    } else {
	        if ("DEPT".equals(branch)) {
	        	dataList1 = RT_MC_TABLE2_1_REPO.findBybranchcode(branch);
    			dataList2 = RT_MC_TABLE2_2_REPO.findBybranchcode(branch);
	        } else {
	        	dataList1 = RT_MC_TABLE2_1_REPO.findByReportDateAndBranchCode(reportDate, branch);
				dataList2 = RT_MC_TABLE2_2_REPO.findByReportDateAndBranchCode(reportDate, branch);
	        }
	    }

	    if (dataList1 == null || dataList1.isEmpty() || dataList2 == null || dataList2.isEmpty() ) {
	        logger.warn(
	        		"MC download jobId={} no rows after fetch. list1={} list2={} reportDate={} branch={} formmode={}",
	        		jobId, dataList1 == null ? 0 : dataList1.size(), dataList2 == null ? 0 : dataList2.size(),
	        		reportDate, branch, formmode);
	        return;
	    }
	    logger.info("MC download jobId={} fetched list1={} list2={} rows. Sheet write starts next.", jobId,
	    		dataList1.size(), dataList2.size());
	    
		
		try{

			Sheet sheet = openMcSheet(workbook, jobId, 4);

			// --- Style Definitions ---
			CreationHelper createHelper = workbook.getCreationHelper();

			CellStyle dateStyle = workbook.createCellStyle();
			dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
			dateStyle.setBorderBottom(BorderStyle.THIN);
			dateStyle.setBorderTop(BorderStyle.THIN);
			dateStyle.setBorderLeft(BorderStyle.THIN);
			dateStyle.setBorderRight(BorderStyle.THIN);

			CellStyle textStyle = workbook.createCellStyle();
			textStyle.setBorderBottom(BorderStyle.THIN);
			textStyle.setBorderTop(BorderStyle.THIN);
			textStyle.setBorderLeft(BorderStyle.THIN);
			textStyle.setBorderRight(BorderStyle.THIN);

			// Create the font
			Font font = workbook.createFont();
			font.setFontHeightInPoints((short) 8); // size 8
			font.setFontName("Arial");

			CellStyle numberStyle = workbook.createCellStyle();
			// numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("0.000"));
			numberStyle.setBorderBottom(BorderStyle.THIN);
			numberStyle.setBorderTop(BorderStyle.THIN);
			numberStyle.setBorderLeft(BorderStyle.THIN);
			numberStyle.setBorderRight(BorderStyle.THIN);
			numberStyle.setFont(font);
			// --- End of Style Definitions ---

			int startRow = 5;

			if (!dataList1.isEmpty() && !dataList2.isEmpty()) {
				for (int i = 0; i < dataList1.size(); i++) {
					RT_MC_TABLE2_1_ENTITY record1 = dataList1.get(i);
					RT_MC_TABLE2_2_ENTITY record2 = dataList2.get(i);
					System.out.println("rownumber=" + (startRow + i));
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}
					setMcProgress(progressMap, jobId, 5, "writing row " + (i + 1) + " excelRow " + (startRow + i));
					updateCellPreserveStyle(row, 5, record1.getR6_NO_WO_SD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record1.getR6_NO_CON_POD_SD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record1.getR6_NO_CON_UNAU_SP_TP(), null, createHelper);
					updateCellPreserveStyle(row, 8, record1.getR6_NO_CON_45_50(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR6_NO_CON_50(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR6_NO_OF_LES_50(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR6_NO_OF_BNK_18(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR6_NO_OF_BNK_18_25(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR6_NO_OF_BNK_26_35(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR6_NO_OF_BNK_36_50(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR6_NO_CON_BNK_50(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR6_NO_CON_SAL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR6_NO_CON_BUS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR6_NO_CON_PRO_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR6_NO_CON_INC_5K(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR6_NO_CON_INC_5K_10K(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR6_NO_CON_INC_10K_20K(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR6_NO_CON_INC_20K_35K(), null, createHelper);
					updateCellPreserveStyle(row, 23, record1.getR6_NO_CON_INC_35K(), null, createHelper);
					updateCellPreserveStyle(row, 24, record1.getR6_NO_CON_BEL_SCL(), null, createHelper);
					updateCellPreserveStyle(row, 25, record1.getR6_NO_CON_BAC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record1.getR6_NO_CON_ABV_MAS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record1.getR6_NO_CON_ABU_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 28, record1.getR6_NO_CON_DUB_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 29, record1.getR6_NO_CON_SHJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 30, record1.getR6_NO_CON_AJM_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 31, record1.getR6_NO_CON_FUJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 32, record1.getR6_NO_CON_RAK_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 33, record1.getR6_NO_CON_UAQ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 34, record1.getR6_NO_CON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 35, record1.getR6_NO_CON_DBR_LIM(), null, createHelper);
					updateCellPreserveStyle(row, 36, record1.getR6_NO_UAE_CON_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 37, record1.getR6_NO_UAE_CON_NLS(), null, createHelper);
					updateCellPreserveStyle(row, 38, record1.getR6_VAL_LOS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 39, record1.getR6_NO_CON_ONB_90(), null, createHelper);
					updateCellPreserveStyle(row, 40, record1.getR6_NO_CON_BAL_PAY(), null, createHelper);
					updateCellPreserveStyle(row, 41, record1.getR6_NO_CON_BAL_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 42, record1.getR6_NO_CON_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 43, record1.getR6_NO_CON_ONB_REF(), null, createHelper);
					updateCellPreserveStyle(row, 44, record1.getR6_NO_CON_ONB_AGE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record1.getR6_NO_CON_AFF_UNAU(), null, createHelper);
					updateCellPreserveStyle(row, 46, record1.getR6_NO_OF_ACCS_POD(), null, createHelper);
					updateCellPreserveStyle(row, 47, record1.getR6_NO_DEL_CON(), null, createHelper);
					updateCellPreserveStyle(row, 48, record1.getR6_NO_INS_FUN_LFI(), null, createHelper);
					updateCellPreserveStyle(row, 49, record1.getR6_NO_CON_COL_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 50, record1.getR6_TOT_NO_NEW_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 51, record1.getR6_TOT_NO_NEW_NOSGN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR6_NO_CON_START(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR6_NO_NEW_CON_ONBO(), null, createHelper);
					updateCellPreserveStyle(row, 54, record1.getR6_NO_CON_DEBT_COUN(), null, createHelper);
					updateCellPreserveStyle(row, 55, record1.getR6_NO_CON_DEL_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 56, record1.getR6_NO_CON_GOV_50(), null, createHelper);
					updateCellPreserveStyle(row, 57, record1.getR6_NO_SME_SOLE(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR6_NO_CON_TAG_VUL(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR6_NO_NEW_CON_ONB_GNP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR6_NO_CON_END(), null, createHelper);

					row = sheet.getRow(6);
					updateCellPreserveStyle(row, 5, record1.getR7_NO_WO_SD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record1.getR7_NO_CON_POD_SD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record1.getR7_NO_CON_UNAU_SP_TP(), null, createHelper);
					updateCellPreserveStyle(row, 8, record1.getR7_NO_CON_45_50(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR7_NO_CON_50(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR7_NO_OF_LES_50(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR7_NO_OF_BNK_18(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR7_NO_OF_BNK_18_25(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR7_NO_OF_BNK_26_35(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR7_NO_OF_BNK_36_50(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR7_NO_CON_BNK_50(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR7_NO_CON_SAL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR7_NO_CON_BUS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR7_NO_CON_PRO_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR7_NO_CON_INC_5K(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR7_NO_CON_INC_5K_10K(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR7_NO_CON_INC_10K_20K(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR7_NO_CON_INC_20K_35K(), null, createHelper);
					updateCellPreserveStyle(row, 23, record1.getR7_NO_CON_INC_35K(), null, createHelper);
					updateCellPreserveStyle(row, 24, record1.getR7_NO_CON_BEL_SCL(), null, createHelper);
					updateCellPreserveStyle(row, 25, record1.getR7_NO_CON_BAC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record1.getR7_NO_CON_ABV_MAS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record1.getR7_NO_CON_ABU_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 28, record1.getR7_NO_CON_DUB_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 29, record1.getR7_NO_CON_SHJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 30, record1.getR7_NO_CON_AJM_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 31, record1.getR7_NO_CON_FUJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 32, record1.getR7_NO_CON_RAK_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 33, record1.getR7_NO_CON_UAQ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 34, record1.getR7_NO_CON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 35, record1.getR7_NO_CON_DBR_LIM(), null, createHelper);
					updateCellPreserveStyle(row, 36, record1.getR7_NO_UAE_CON_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 37, record1.getR7_NO_UAE_CON_NLS(), null, createHelper);
					updateCellPreserveStyle(row, 38, record1.getR7_VAL_LOS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 39, record1.getR7_NO_CON_ONB_90(), null, createHelper);
					updateCellPreserveStyle(row, 40, record1.getR7_NO_CON_BAL_PAY(), null, createHelper);
					updateCellPreserveStyle(row, 41, record1.getR7_NO_CON_BAL_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 42, record1.getR7_NO_CON_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 43, record1.getR7_NO_CON_ONB_REF(), null, createHelper);
					updateCellPreserveStyle(row, 44, record1.getR7_NO_CON_ONB_AGE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record1.getR7_NO_CON_AFF_UNAU(), null, createHelper);
					updateCellPreserveStyle(row, 46, record1.getR7_NO_OF_ACCS_POD(), null, createHelper);
					updateCellPreserveStyle(row, 47, record1.getR7_NO_DEL_CON(), null, createHelper);
					updateCellPreserveStyle(row, 48, record1.getR7_NO_INS_FUN_LFI(), null, createHelper);
					updateCellPreserveStyle(row, 49, record1.getR7_NO_CON_COL_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 50, record1.getR7_TOT_NO_NEW_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 51, record1.getR7_TOT_NO_NEW_NOSGN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR7_NO_CON_START(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR7_NO_NEW_CON_ONBO(), null, createHelper);
					updateCellPreserveStyle(row, 54, record1.getR7_NO_CON_DEBT_COUN(), null, createHelper);
					updateCellPreserveStyle(row, 55, record1.getR7_NO_CON_DEL_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 56, record1.getR7_NO_CON_GOV_50(), null, createHelper);
					updateCellPreserveStyle(row, 57, record1.getR7_NO_SME_SOLE(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR7_NO_CON_TAG_VUL(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR7_NO_NEW_CON_ONB_GNP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR7_NO_CON_END(), null, createHelper);

					setMcProgress(progressMap, jobId, 15);
					row = sheet.getRow(7);
					updateCellPreserveStyle(row, 5, record1.getR8_NO_WO_SD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record1.getR8_NO_CON_POD_SD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record1.getR8_NO_CON_UNAU_SP_TP(), null, createHelper);
					updateCellPreserveStyle(row, 8, record1.getR8_NO_CON_45_50(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR8_NO_CON_50(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR8_NO_OF_LES_50(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR8_NO_OF_BNK_18(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR8_NO_OF_BNK_18_25(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR8_NO_OF_BNK_26_35(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR8_NO_OF_BNK_36_50(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR8_NO_CON_BNK_50(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR8_NO_CON_SAL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR8_NO_CON_BUS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR8_NO_CON_PRO_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR8_NO_CON_INC_5K(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR8_NO_CON_INC_5K_10K(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR8_NO_CON_INC_10K_20K(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR8_NO_CON_INC_20K_35K(), null, createHelper);
					updateCellPreserveStyle(row, 23, record1.getR8_NO_CON_INC_35K(), null, createHelper);
					updateCellPreserveStyle(row, 24, record1.getR8_NO_CON_BEL_SCL(), null, createHelper);
					updateCellPreserveStyle(row, 25, record1.getR8_NO_CON_BAC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record1.getR8_NO_CON_ABV_MAS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record1.getR8_NO_CON_ABU_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 28, record1.getR8_NO_CON_DUB_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 29, record1.getR8_NO_CON_SHJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 30, record1.getR8_NO_CON_AJM_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 31, record1.getR8_NO_CON_FUJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 32, record1.getR8_NO_CON_RAK_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 33, record1.getR8_NO_CON_UAQ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 34, record1.getR8_NO_CON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 35, record1.getR8_NO_CON_DBR_LIM(), null, createHelper);
					updateCellPreserveStyle(row, 36, record1.getR8_NO_UAE_CON_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 37, record1.getR8_NO_UAE_CON_NLS(), null, createHelper);
					updateCellPreserveStyle(row, 38, record1.getR8_VAL_LOS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 39, record1.getR8_NO_CON_ONB_90(), null, createHelper);
					updateCellPreserveStyle(row, 40, record1.getR8_NO_CON_BAL_PAY(), null, createHelper);
					updateCellPreserveStyle(row, 41, record1.getR8_NO_CON_BAL_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 42, record1.getR8_NO_CON_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 43, record1.getR8_NO_CON_ONB_REF(), null, createHelper);
					updateCellPreserveStyle(row, 44, record1.getR8_NO_CON_ONB_AGE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record1.getR8_NO_CON_AFF_UNAU(), null, createHelper);
					updateCellPreserveStyle(row, 46, record1.getR8_NO_OF_ACCS_POD(), null, createHelper);
					updateCellPreserveStyle(row, 47, record1.getR8_NO_DEL_CON(), null, createHelper);
					updateCellPreserveStyle(row, 48, record1.getR8_NO_INS_FUN_LFI(), null, createHelper);
					updateCellPreserveStyle(row, 49, record1.getR8_NO_CON_COL_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 50, record1.getR8_TOT_NO_NEW_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 51, record1.getR8_TOT_NO_NEW_NOSGN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR8_NO_CON_START(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR8_NO_NEW_CON_ONBO(), null, createHelper);
					updateCellPreserveStyle(row, 54, record1.getR8_NO_CON_DEBT_COUN(), null, createHelper);
					updateCellPreserveStyle(row, 55, record1.getR8_NO_CON_DEL_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 56, record1.getR8_NO_CON_GOV_50(), null, createHelper);
					updateCellPreserveStyle(row, 57, record1.getR8_NO_SME_SOLE(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR8_NO_CON_TAG_VUL(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR8_NO_NEW_CON_ONB_GNP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR8_NO_CON_END(), null, createHelper);

					row = sheet.getRow(8);
					updateCellPreserveStyle(row, 5, record1.getR9_NO_WO_SD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record1.getR9_NO_CON_POD_SD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record1.getR9_NO_CON_UNAU_SP_TP(), null, createHelper);
					updateCellPreserveStyle(row, 8, record1.getR9_NO_CON_45_50(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR9_NO_CON_50(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR9_NO_OF_LES_50(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR9_NO_OF_BNK_18(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR9_NO_OF_BNK_18_25(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR9_NO_OF_BNK_26_35(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR9_NO_OF_BNK_36_50(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR9_NO_CON_BNK_50(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR9_NO_CON_SAL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR9_NO_CON_BUS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR9_NO_CON_PRO_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR9_NO_CON_INC_5K(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR9_NO_CON_INC_5K_10K(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR9_NO_CON_INC_10K_20K(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR9_NO_CON_INC_20K_35K(), null, createHelper);
					updateCellPreserveStyle(row, 23, record1.getR9_NO_CON_INC_35K(), null, createHelper);
					updateCellPreserveStyle(row, 24, record1.getR9_NO_CON_BEL_SCL(), null, createHelper);
					updateCellPreserveStyle(row, 25, record1.getR9_NO_CON_BAC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record1.getR9_NO_CON_ABV_MAS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record1.getR9_NO_CON_ABU_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 28, record1.getR9_NO_CON_DUB_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 29, record1.getR9_NO_CON_SHJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 30, record1.getR9_NO_CON_AJM_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 31, record1.getR9_NO_CON_FUJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 32, record1.getR9_NO_CON_RAK_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 33, record1.getR9_NO_CON_UAQ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 34, record1.getR9_NO_CON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 35, record1.getR9_NO_CON_DBR_LIM(), null, createHelper);
					updateCellPreserveStyle(row, 36, record1.getR9_NO_UAE_CON_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 37, record1.getR9_NO_UAE_CON_NLS(), null, createHelper);
					updateCellPreserveStyle(row, 38, record1.getR9_VAL_LOS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 39, record1.getR9_NO_CON_ONB_90(), null, createHelper);
					updateCellPreserveStyle(row, 40, record1.getR9_NO_CON_BAL_PAY(), null, createHelper);
					updateCellPreserveStyle(row, 41, record1.getR9_NO_CON_BAL_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 42, record1.getR9_NO_CON_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 43, record1.getR9_NO_CON_ONB_REF(), null, createHelper);
					updateCellPreserveStyle(row, 44, record1.getR9_NO_CON_ONB_AGE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record1.getR9_NO_CON_AFF_UNAU(), null, createHelper);
					updateCellPreserveStyle(row, 46, record1.getR9_NO_OF_ACCS_POD(), null, createHelper);
					updateCellPreserveStyle(row, 47, record1.getR9_NO_DEL_CON(), null, createHelper);
					updateCellPreserveStyle(row, 48, record1.getR9_NO_INS_FUN_LFI(), null, createHelper);
					updateCellPreserveStyle(row, 49, record1.getR9_NO_CON_COL_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 50, record1.getR9_TOT_NO_NEW_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 51, record1.getR9_TOT_NO_NEW_NOSGN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR9_NO_CON_START(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR9_NO_NEW_CON_ONBO(), null, createHelper);
					updateCellPreserveStyle(row, 54, record1.getR9_NO_CON_DEBT_COUN(), null, createHelper);
					updateCellPreserveStyle(row, 55, record1.getR9_NO_CON_DEL_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 56, record1.getR9_NO_CON_GOV_50(), null, createHelper);
					updateCellPreserveStyle(row, 57, record1.getR9_NO_SME_SOLE(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR9_NO_CON_TAG_VUL(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR9_NO_NEW_CON_ONB_GNP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR9_NO_CON_END(), null, createHelper);

					setMcProgress(progressMap, jobId, 25);
					row = sheet.getRow(9);
					updateCellPreserveStyle(row, 5, record1.getR10_NO_WO_SD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record1.getR10_NO_CON_POD_SD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record1.getR10_NO_CON_UNAU_SP_TP(), null, createHelper);
					updateCellPreserveStyle(row, 8, record1.getR10_NO_CON_45_50(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR10_NO_CON_50(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR10_NO_OF_LES_50(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR10_NO_OF_BNK_18(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR10_NO_OF_BNK_18_25(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR10_NO_OF_BNK_26_35(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR10_NO_OF_BNK_36_50(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR10_NO_CON_BNK_50(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR10_NO_CON_SAL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR10_NO_CON_BUS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR10_NO_CON_PRO_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR10_NO_CON_INC_5K(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR10_NO_CON_INC_5K_10K(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR10_NO_CON_INC_10K_20K(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR10_NO_CON_INC_20K_35K(), null, createHelper);
					updateCellPreserveStyle(row, 23, record1.getR10_NO_CON_INC_35K(), null, createHelper);
					updateCellPreserveStyle(row, 24, record1.getR10_NO_CON_BEL_SCL(), null, createHelper);
					updateCellPreserveStyle(row, 25, record1.getR10_NO_CON_BAC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record1.getR10_NO_CON_ABV_MAS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record1.getR10_NO_CON_ABU_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 28, record1.getR10_NO_CON_DUB_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 29, record1.getR10_NO_CON_SHJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 30, record1.getR10_NO_CON_AJM_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 31, record1.getR10_NO_CON_FUJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 32, record1.getR10_NO_CON_RAK_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 33, record1.getR10_NO_CON_UAQ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 34, record1.getR10_NO_CON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 35, record1.getR10_NO_CON_DBR_LIM(), null, createHelper);
					updateCellPreserveStyle(row, 36, record1.getR10_NO_UAE_CON_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 37, record1.getR10_NO_UAE_CON_NLS(), null, createHelper);
					updateCellPreserveStyle(row, 38, record1.getR10_VAL_LOS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 39, record1.getR10_NO_CON_ONB_90(), null, createHelper);
					updateCellPreserveStyle(row, 40, record1.getR10_NO_CON_BAL_PAY(), null, createHelper);
					updateCellPreserveStyle(row, 41, record1.getR10_NO_CON_BAL_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 42, record1.getR10_NO_CON_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 43, record1.getR10_NO_CON_ONB_REF(), null, createHelper);
					updateCellPreserveStyle(row, 44, record1.getR10_NO_CON_ONB_AGE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record1.getR10_NO_CON_AFF_UNAU(), null, createHelper);
					updateCellPreserveStyle(row, 46, record1.getR10_NO_OF_ACCS_POD(), null, createHelper);
					updateCellPreserveStyle(row, 47, record1.getR10_NO_DEL_CON(), null, createHelper);
					updateCellPreserveStyle(row, 48, record1.getR10_NO_INS_FUN_LFI(), null, createHelper);
					updateCellPreserveStyle(row, 49, record1.getR10_NO_CON_COL_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 50, record1.getR10_TOT_NO_NEW_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 51, record1.getR10_TOT_NO_NEW_NOSGN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR10_NO_CON_START(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR10_NO_NEW_CON_ONBO(), null, createHelper);
					updateCellPreserveStyle(row, 54, record1.getR10_NO_CON_DEBT_COUN(), null, createHelper);
					updateCellPreserveStyle(row, 55, record1.getR10_NO_CON_DEL_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 56, record1.getR10_NO_CON_GOV_50(), null, createHelper);
					updateCellPreserveStyle(row, 57, record1.getR10_NO_SME_SOLE(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR10_NO_CON_TAG_VUL(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR10_NO_NEW_CON_ONB_GNP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR10_NO_CON_END(), null, createHelper);

					row = sheet.getRow(10);
					updateCellPreserveStyle(row, 5, record1.getR11_NO_WO_SD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record1.getR11_NO_CON_POD_SD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record1.getR11_NO_CON_UNAU_SP_TP(), null, createHelper);
					updateCellPreserveStyle(row, 8, record1.getR11_NO_CON_45_50(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR11_NO_CON_50(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR11_NO_OF_LES_50(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR11_NO_OF_BNK_18(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR11_NO_OF_BNK_18_25(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR11_NO_OF_BNK_26_35(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR11_NO_OF_BNK_36_50(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR11_NO_CON_BNK_50(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR11_NO_CON_SAL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR11_NO_CON_BUS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR11_NO_CON_PRO_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR11_NO_CON_INC_5K(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR11_NO_CON_INC_5K_10K(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR11_NO_CON_INC_10K_20K(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR11_NO_CON_INC_20K_35K(), null, createHelper);
					updateCellPreserveStyle(row, 23, record1.getR11_NO_CON_INC_35K(), null, createHelper);
					updateCellPreserveStyle(row, 24, record1.getR11_NO_CON_BEL_SCL(), null, createHelper);
					updateCellPreserveStyle(row, 25, record1.getR11_NO_CON_BAC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record1.getR11_NO_CON_ABV_MAS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record1.getR11_NO_CON_ABU_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 28, record1.getR11_NO_CON_DUB_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 29, record1.getR11_NO_CON_SHJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 30, record1.getR11_NO_CON_AJM_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 31, record1.getR11_NO_CON_FUJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 32, record1.getR11_NO_CON_RAK_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 33, record1.getR11_NO_CON_UAQ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 34, record1.getR11_NO_CON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 35, record1.getR11_NO_CON_DBR_LIM(), null, createHelper);
					updateCellPreserveStyle(row, 36, record1.getR11_NO_UAE_CON_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 37, record1.getR11_NO_UAE_CON_NLS(), null, createHelper);
					updateCellPreserveStyle(row, 38, record1.getR11_VAL_LOS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 39, record1.getR11_NO_CON_ONB_90(), null, createHelper);
					updateCellPreserveStyle(row, 40, record1.getR11_NO_CON_BAL_PAY(), null, createHelper);
					updateCellPreserveStyle(row, 41, record1.getR11_NO_CON_BAL_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 42, record1.getR11_NO_CON_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 43, record1.getR11_NO_CON_ONB_REF(), null, createHelper);
					updateCellPreserveStyle(row, 44, record1.getR11_NO_CON_ONB_AGE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record1.getR11_NO_CON_AFF_UNAU(), null, createHelper);
					updateCellPreserveStyle(row, 46, record1.getR11_NO_OF_ACCS_POD(), null, createHelper);
					updateCellPreserveStyle(row, 47, record1.getR11_NO_DEL_CON(), null, createHelper);
					updateCellPreserveStyle(row, 48, record1.getR11_NO_INS_FUN_LFI(), null, createHelper);
					updateCellPreserveStyle(row, 49, record1.getR11_NO_CON_COL_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 50, record1.getR11_TOT_NO_NEW_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 51, record1.getR11_TOT_NO_NEW_NOSGN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR11_NO_CON_START(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR11_NO_NEW_CON_ONBO(), null, createHelper);
					updateCellPreserveStyle(row, 54, record1.getR11_NO_CON_DEBT_COUN(), null, createHelper);
					updateCellPreserveStyle(row, 55, record1.getR11_NO_CON_DEL_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 56, record1.getR11_NO_CON_GOV_50(), null, createHelper);
					updateCellPreserveStyle(row, 57, record1.getR11_NO_SME_SOLE(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR11_NO_CON_TAG_VUL(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR11_NO_NEW_CON_ONB_GNP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR11_NO_CON_END(), null, createHelper);

					setMcProgress(progressMap, jobId, 35);
					row = sheet.getRow(11);
					updateCellPreserveStyle(row, 5, record1.getR12_NO_WO_SD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record1.getR12_NO_CON_POD_SD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record1.getR12_NO_CON_UNAU_SP_TP(), null, createHelper);
					updateCellPreserveStyle(row, 8, record1.getR12_NO_CON_45_50(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR12_NO_CON_50(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR12_NO_OF_LES_50(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR12_NO_OF_BNK_18(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR12_NO_OF_BNK_18_25(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR12_NO_OF_BNK_26_35(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR12_NO_OF_BNK_36_50(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR12_NO_CON_BNK_50(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR12_NO_CON_SAL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR12_NO_CON_BUS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR12_NO_CON_PRO_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR12_NO_CON_INC_5K(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR12_NO_CON_INC_5K_10K(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR12_NO_CON_INC_10K_20K(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR12_NO_CON_INC_20K_35K(), null, createHelper);
					updateCellPreserveStyle(row, 23, record1.getR12_NO_CON_INC_35K(), null, createHelper);
					updateCellPreserveStyle(row, 24, record1.getR12_NO_CON_BEL_SCL(), null, createHelper);
					updateCellPreserveStyle(row, 25, record1.getR12_NO_CON_BAC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record1.getR12_NO_CON_ABV_MAS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record1.getR12_NO_CON_ABU_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 28, record1.getR12_NO_CON_DUB_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 29, record1.getR12_NO_CON_SHJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 30, record1.getR12_NO_CON_AJM_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 31, record1.getR12_NO_CON_FUJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 32, record1.getR12_NO_CON_RAK_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 33, record1.getR12_NO_CON_UAQ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 34, record1.getR12_NO_CON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 35, record1.getR12_NO_CON_DBR_LIM(), null, createHelper);
					updateCellPreserveStyle(row, 36, record1.getR12_NO_UAE_CON_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 37, record1.getR12_NO_UAE_CON_NLS(), null, createHelper);
					updateCellPreserveStyle(row, 38, record1.getR12_VAL_LOS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 39, record1.getR12_NO_CON_ONB_90(), null, createHelper);
					updateCellPreserveStyle(row, 40, record1.getR12_NO_CON_BAL_PAY(), null, createHelper);
					updateCellPreserveStyle(row, 41, record1.getR12_NO_CON_BAL_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 42, record1.getR12_NO_CON_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 43, record1.getR12_NO_CON_ONB_REF(), null, createHelper);
					updateCellPreserveStyle(row, 44, record1.getR12_NO_CON_ONB_AGE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record1.getR12_NO_CON_AFF_UNAU(), null, createHelper);
					updateCellPreserveStyle(row, 46, record1.getR12_NO_OF_ACCS_POD(), null, createHelper);
					updateCellPreserveStyle(row, 47, record1.getR12_NO_DEL_CON(), null, createHelper);
					updateCellPreserveStyle(row, 48, record1.getR12_NO_INS_FUN_LFI(), null, createHelper);
					updateCellPreserveStyle(row, 49, record1.getR12_NO_CON_COL_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 50, record1.getR12_TOT_NO_NEW_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 51, record1.getR12_TOT_NO_NEW_NOSGN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR12_NO_CON_START(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR12_NO_NEW_CON_ONBO(), null, createHelper);
					updateCellPreserveStyle(row, 54, record1.getR12_NO_CON_DEBT_COUN(), null, createHelper);
					updateCellPreserveStyle(row, 55, record1.getR12_NO_CON_DEL_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 56, record1.getR12_NO_CON_GOV_50(), null, createHelper);
					updateCellPreserveStyle(row, 57, record1.getR12_NO_SME_SOLE(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR12_NO_CON_TAG_VUL(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR12_NO_NEW_CON_ONB_GNP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR12_NO_CON_END(), null, createHelper);

					row = sheet.getRow(12);
					updateCellPreserveStyle(row, 5, record1.getR13_NO_WO_SD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record1.getR13_NO_CON_POD_SD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record1.getR13_NO_CON_UNAU_SP_TP(), null, createHelper);
					updateCellPreserveStyle(row, 8, record1.getR13_NO_CON_45_50(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR13_NO_CON_50(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR13_NO_OF_LES_50(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR13_NO_OF_BNK_18(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR13_NO_OF_BNK_18_25(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR13_NO_OF_BNK_26_35(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR13_NO_OF_BNK_36_50(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR13_NO_CON_BNK_50(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR13_NO_CON_SAL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR13_NO_CON_BUS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR13_NO_CON_PRO_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR13_NO_CON_INC_5K(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR13_NO_CON_INC_5K_10K(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR13_NO_CON_INC_10K_20K(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR13_NO_CON_INC_20K_35K(), null, createHelper);
					updateCellPreserveStyle(row, 23, record1.getR13_NO_CON_INC_35K(), null, createHelper);
					updateCellPreserveStyle(row, 24, record1.getR13_NO_CON_BEL_SCL(), null, createHelper);
					updateCellPreserveStyle(row, 25, record1.getR13_NO_CON_BAC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record1.getR13_NO_CON_ABV_MAS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record1.getR13_NO_CON_ABU_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 28, record1.getR13_NO_CON_DUB_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 29, record1.getR13_NO_CON_SHJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 30, record1.getR13_NO_CON_AJM_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 31, record1.getR13_NO_CON_FUJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 32, record1.getR13_NO_CON_RAK_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 33, record1.getR13_NO_CON_UAQ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 34, record1.getR13_NO_CON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 35, record1.getR13_NO_CON_DBR_LIM(), null, createHelper);
					updateCellPreserveStyle(row, 36, record1.getR13_NO_UAE_CON_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 37, record1.getR13_NO_UAE_CON_NLS(), null, createHelper);
					updateCellPreserveStyle(row, 38, record1.getR13_VAL_LOS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 39, record1.getR13_NO_CON_ONB_90(), null, createHelper);
					updateCellPreserveStyle(row, 40, record1.getR13_NO_CON_BAL_PAY(), null, createHelper);
					updateCellPreserveStyle(row, 41, record1.getR13_NO_CON_BAL_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 42, record1.getR13_NO_CON_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 43, record1.getR13_NO_CON_ONB_REF(), null, createHelper);
					updateCellPreserveStyle(row, 44, record1.getR13_NO_CON_ONB_AGE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record1.getR13_NO_CON_AFF_UNAU(), null, createHelper);
					updateCellPreserveStyle(row, 46, record1.getR13_NO_OF_ACCS_POD(), null, createHelper);
					updateCellPreserveStyle(row, 47, record1.getR13_NO_DEL_CON(), null, createHelper);
					updateCellPreserveStyle(row, 48, record1.getR13_NO_INS_FUN_LFI(), null, createHelper);
					updateCellPreserveStyle(row, 49, record1.getR13_NO_CON_COL_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 50, record1.getR13_TOT_NO_NEW_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 51, record1.getR13_TOT_NO_NEW_NOSGN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR13_NO_CON_START(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR13_NO_NEW_CON_ONBO(), null, createHelper);
					updateCellPreserveStyle(row, 54, record1.getR13_NO_CON_DEBT_COUN(), null, createHelper);
					updateCellPreserveStyle(row, 55, record1.getR13_NO_CON_DEL_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 56, record1.getR13_NO_CON_GOV_50(), null, createHelper);
					updateCellPreserveStyle(row, 57, record1.getR13_NO_SME_SOLE(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR13_NO_CON_TAG_VUL(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR13_NO_NEW_CON_ONB_GNP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR13_NO_CON_END(), null, createHelper);

					setMcProgress(progressMap, jobId, 45);
					row = sheet.getRow(13);
					updateCellPreserveStyle(row, 5, record1.getR14_NO_WO_SD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record1.getR14_NO_CON_POD_SD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record1.getR14_NO_CON_UNAU_SP_TP(), null, createHelper);
					updateCellPreserveStyle(row, 8, record1.getR14_NO_CON_45_50(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR14_NO_CON_50(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR14_NO_OF_LES_50(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR14_NO_OF_BNK_18(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR14_NO_OF_BNK_18_25(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR14_NO_OF_BNK_26_35(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR14_NO_OF_BNK_36_50(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR14_NO_CON_BNK_50(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR14_NO_CON_SAL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR14_NO_CON_BUS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR14_NO_CON_PRO_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR14_NO_CON_INC_5K(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR14_NO_CON_INC_5K_10K(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR14_NO_CON_INC_10K_20K(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR14_NO_CON_INC_20K_35K(), null, createHelper);
					updateCellPreserveStyle(row, 23, record1.getR14_NO_CON_INC_35K(), null, createHelper);
					updateCellPreserveStyle(row, 24, record1.getR14_NO_CON_BEL_SCL(), null, createHelper);
					updateCellPreserveStyle(row, 25, record1.getR14_NO_CON_BAC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record1.getR14_NO_CON_ABV_MAS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record1.getR14_NO_CON_ABU_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 28, record1.getR14_NO_CON_DUB_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 29, record1.getR14_NO_CON_SHJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 30, record1.getR14_NO_CON_AJM_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 31, record1.getR14_NO_CON_FUJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 32, record1.getR14_NO_CON_RAK_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 33, record1.getR14_NO_CON_UAQ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 34, record1.getR14_NO_CON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 35, record1.getR14_NO_CON_DBR_LIM(), null, createHelper);
					updateCellPreserveStyle(row, 36, record1.getR14_NO_UAE_CON_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 37, record1.getR14_NO_UAE_CON_NLS(), null, createHelper);
					updateCellPreserveStyle(row, 38, record1.getR14_VAL_LOS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 39, record1.getR14_NO_CON_ONB_90(), null, createHelper);
					updateCellPreserveStyle(row, 40, record1.getR14_NO_CON_BAL_PAY(), null, createHelper);
					updateCellPreserveStyle(row, 41, record1.getR14_NO_CON_BAL_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 42, record1.getR14_NO_CON_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 43, record1.getR14_NO_CON_ONB_REF(), null, createHelper);
					updateCellPreserveStyle(row, 44, record1.getR14_NO_CON_ONB_AGE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record1.getR14_NO_CON_AFF_UNAU(), null, createHelper);
					updateCellPreserveStyle(row, 46, record1.getR14_NO_OF_ACCS_POD(), null, createHelper);
					updateCellPreserveStyle(row, 47, record1.getR14_NO_DEL_CON(), null, createHelper);
					updateCellPreserveStyle(row, 48, record1.getR14_NO_INS_FUN_LFI(), null, createHelper);
					updateCellPreserveStyle(row, 49, record1.getR14_NO_CON_COL_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 50, record1.getR14_TOT_NO_NEW_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 51, record1.getR14_TOT_NO_NEW_NOSGN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR14_NO_CON_START(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR14_NO_NEW_CON_ONBO(), null, createHelper);
					updateCellPreserveStyle(row, 54, record1.getR14_NO_CON_DEBT_COUN(), null, createHelper);
					updateCellPreserveStyle(row, 55, record1.getR14_NO_CON_DEL_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 56, record1.getR14_NO_CON_GOV_50(), null, createHelper);
					updateCellPreserveStyle(row, 57, record1.getR14_NO_SME_SOLE(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR14_NO_CON_TAG_VUL(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR14_NO_NEW_CON_ONB_GNP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR14_NO_CON_END(), null, createHelper);

					row = sheet.getRow(14);
					updateCellPreserveStyle(row, 5, record2.getR15_NO_WO_SD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record2.getR15_NO_CON_POD_SD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record2.getR15_NO_CON_UNAU_SP_TP(), null, createHelper);
					updateCellPreserveStyle(row, 8, record2.getR15_NO_CON_45_50(), null, createHelper);
					updateCellPreserveStyle(row, 9, record2.getR15_NO_CON_50(), null, createHelper);
					updateCellPreserveStyle(row, 10, record2.getR15_NO_OF_LES_50(), null, createHelper);
					updateCellPreserveStyle(row, 11, record2.getR15_NO_OF_BNK_18(), null, createHelper);
					updateCellPreserveStyle(row, 12, record2.getR15_NO_OF_BNK_18_25(), null, createHelper);
					updateCellPreserveStyle(row, 13, record2.getR15_NO_OF_BNK_26_35(), null, createHelper);
					updateCellPreserveStyle(row, 14, record2.getR15_NO_OF_BNK_36_50(), null, createHelper);
					updateCellPreserveStyle(row, 15, record2.getR15_NO_CON_BNK_50(), null, createHelper);
					updateCellPreserveStyle(row, 16, record2.getR15_NO_CON_SAL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 17, record2.getR15_NO_CON_BUS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record2.getR15_NO_CON_PRO_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 19, record2.getR15_NO_CON_INC_5K(), null, createHelper);
					updateCellPreserveStyle(row, 20, record2.getR15_NO_CON_INC_5K_10K(), null, createHelper);
					updateCellPreserveStyle(row, 21, record2.getR15_NO_CON_INC_10K_20K(), null, createHelper);
					updateCellPreserveStyle(row, 22, record2.getR15_NO_CON_INC_20K_35K(), null, createHelper);
					updateCellPreserveStyle(row, 23, record2.getR15_NO_CON_INC_35K(), null, createHelper);
					updateCellPreserveStyle(row, 24, record2.getR15_NO_CON_BEL_SCL(), null, createHelper);
					updateCellPreserveStyle(row, 25, record2.getR15_NO_CON_BAC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record2.getR15_NO_CON_ABV_MAS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record2.getR15_NO_CON_ABU_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 28, record2.getR15_NO_CON_DUB_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 29, record2.getR15_NO_CON_SHJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 30, record2.getR15_NO_CON_AJM_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 31, record2.getR15_NO_CON_FUJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 32, record2.getR15_NO_CON_RAK_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 33, record2.getR15_NO_CON_UAQ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 34, record2.getR15_NO_CON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 35, record2.getR15_NO_CON_DBR_LIM(), null, createHelper);
					updateCellPreserveStyle(row, 36, record2.getR15_NO_UAE_CON_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 37, record2.getR15_NO_UAE_CON_NLS(), null, createHelper);
					updateCellPreserveStyle(row, 38, record2.getR15_VAL_LOS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 39, record2.getR15_NO_CON_ONB_90(), null, createHelper);
					updateCellPreserveStyle(row, 40, record2.getR15_NO_CON_BAL_PAY(), null, createHelper);
					updateCellPreserveStyle(row, 41, record2.getR15_NO_CON_BAL_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 42, record2.getR15_NO_CON_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 43, record2.getR15_NO_CON_ONB_REF(), null, createHelper);
					updateCellPreserveStyle(row, 44, record2.getR15_NO_CON_ONB_AGE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record2.getR15_NO_CON_AFF_UNAU(), null, createHelper);
					updateCellPreserveStyle(row, 46, record2.getR15_NO_OF_ACCS_POD(), null, createHelper);
					updateCellPreserveStyle(row, 47, record2.getR15_NO_DEL_CON(), null, createHelper);
					updateCellPreserveStyle(row, 48, record2.getR15_NO_INS_FUN_LFI(), null, createHelper);
					updateCellPreserveStyle(row, 49, record2.getR15_NO_CON_COL_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 50, record2.getR15_TOT_NO_NEW_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 51, record2.getR15_TOT_NO_NEW_NOSGN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record2.getR15_NO_CON_START(), null, createHelper);
					updateCellPreserveStyle(row, 53, record2.getR15_NO_NEW_CON_ONBO(), null, createHelper);
					updateCellPreserveStyle(row, 54, record2.getR15_NO_CON_DEBT_COUN(), null, createHelper);
					updateCellPreserveStyle(row, 55, record2.getR15_NO_CON_DEL_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 56, record2.getR15_NO_CON_GOV_50(), null, createHelper);
					updateCellPreserveStyle(row, 57, record2.getR15_NO_SME_SOLE(), null, createHelper);
					updateCellPreserveStyle(row, 58, record2.getR15_NO_CON_TAG_VUL(), null, createHelper);
					updateCellPreserveStyle(row, 59, record2.getR15_NO_NEW_CON_ONB_GNP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record2.getR15_NO_CON_END(), null, createHelper);

					setMcProgress(progressMap, jobId, 55);
					row = sheet.getRow(15);
					updateCellPreserveStyle(row, 5, record2.getR16_NO_WO_SD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record2.getR16_NO_CON_POD_SD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record2.getR16_NO_CON_UNAU_SP_TP(), null, createHelper);
					updateCellPreserveStyle(row, 8, record2.getR16_NO_CON_45_50(), null, createHelper);
					updateCellPreserveStyle(row, 9, record2.getR16_NO_CON_50(), null, createHelper);
					updateCellPreserveStyle(row, 10, record2.getR16_NO_OF_LES_50(), null, createHelper);
					updateCellPreserveStyle(row, 11, record2.getR16_NO_OF_BNK_18(), null, createHelper);
					updateCellPreserveStyle(row, 12, record2.getR16_NO_OF_BNK_18_25(), null, createHelper);
					updateCellPreserveStyle(row, 13, record2.getR16_NO_OF_BNK_26_35(), null, createHelper);
					updateCellPreserveStyle(row, 14, record2.getR16_NO_OF_BNK_36_50(), null, createHelper);
					updateCellPreserveStyle(row, 15, record2.getR16_NO_CON_BNK_50(), null, createHelper);
					updateCellPreserveStyle(row, 16, record2.getR16_NO_CON_SAL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 17, record2.getR16_NO_CON_BUS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record2.getR16_NO_CON_PRO_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 19, record2.getR16_NO_CON_INC_5K(), null, createHelper);
					updateCellPreserveStyle(row, 20, record2.getR16_NO_CON_INC_5K_10K(), null, createHelper);
					updateCellPreserveStyle(row, 21, record2.getR16_NO_CON_INC_10K_20K(), null, createHelper);
					updateCellPreserveStyle(row, 22, record2.getR16_NO_CON_INC_20K_35K(), null, createHelper);
					updateCellPreserveStyle(row, 23, record2.getR16_NO_CON_INC_35K(), null, createHelper);
					updateCellPreserveStyle(row, 24, record2.getR16_NO_CON_BEL_SCL(), null, createHelper);
					updateCellPreserveStyle(row, 25, record2.getR16_NO_CON_BAC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record2.getR16_NO_CON_ABV_MAS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record2.getR16_NO_CON_ABU_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 28, record2.getR16_NO_CON_DUB_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 29, record2.getR16_NO_CON_SHJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 30, record2.getR16_NO_CON_AJM_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 31, record2.getR16_NO_CON_FUJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 32, record2.getR16_NO_CON_RAK_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 33, record2.getR16_NO_CON_UAQ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 34, record2.getR16_NO_CON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 35, record2.getR16_NO_CON_DBR_LIM(), null, createHelper);
					updateCellPreserveStyle(row, 36, record2.getR16_NO_UAE_CON_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 37, record2.getR16_NO_UAE_CON_NLS(), null, createHelper);
					updateCellPreserveStyle(row, 38, record2.getR16_VAL_LOS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 39, record2.getR16_NO_CON_ONB_90(), null, createHelper);
					updateCellPreserveStyle(row, 40, record2.getR16_NO_CON_BAL_PAY(), null, createHelper);
					updateCellPreserveStyle(row, 41, record2.getR16_NO_CON_BAL_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 42, record2.getR16_NO_CON_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 43, record2.getR16_NO_CON_ONB_REF(), null, createHelper);
					updateCellPreserveStyle(row, 44, record2.getR16_NO_CON_ONB_AGE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record2.getR16_NO_CON_AFF_UNAU(), null, createHelper);
					updateCellPreserveStyle(row, 46, record2.getR16_NO_OF_ACCS_POD(), null, createHelper);
					updateCellPreserveStyle(row, 47, record2.getR16_NO_DEL_CON(), null, createHelper);
					updateCellPreserveStyle(row, 48, record2.getR16_NO_INS_FUN_LFI(), null, createHelper);
					updateCellPreserveStyle(row, 49, record2.getR16_NO_CON_COL_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 50, record2.getR16_TOT_NO_NEW_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 51, record2.getR16_TOT_NO_NEW_NOSGN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record2.getR16_NO_CON_START(), null, createHelper);
					updateCellPreserveStyle(row, 53, record2.getR16_NO_NEW_CON_ONBO(), null, createHelper);
					updateCellPreserveStyle(row, 54, record2.getR16_NO_CON_DEBT_COUN(), null, createHelper);
					updateCellPreserveStyle(row, 55, record2.getR16_NO_CON_DEL_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 56, record2.getR16_NO_CON_GOV_50(), null, createHelper);
					updateCellPreserveStyle(row, 57, record2.getR16_NO_SME_SOLE(), null, createHelper);
					updateCellPreserveStyle(row, 58, record2.getR16_NO_CON_TAG_VUL(), null, createHelper);
					updateCellPreserveStyle(row, 59, record2.getR16_NO_NEW_CON_ONB_GNP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record2.getR16_NO_CON_END(), null, createHelper);

					row = sheet.getRow(16);
					updateCellPreserveStyle(row, 5, record2.getR17_NO_WO_SD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record2.getR17_NO_CON_POD_SD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record2.getR17_NO_CON_UNAU_SP_TP(), null, createHelper);
					updateCellPreserveStyle(row, 8, record2.getR17_NO_CON_45_50(), null, createHelper);
					updateCellPreserveStyle(row, 9, record2.getR17_NO_CON_50(), null, createHelper);
					updateCellPreserveStyle(row, 10, record2.getR17_NO_OF_LES_50(), null, createHelper);
					updateCellPreserveStyle(row, 11, record2.getR17_NO_OF_BNK_18(), null, createHelper);
					updateCellPreserveStyle(row, 12, record2.getR17_NO_OF_BNK_18_25(), null, createHelper);
					updateCellPreserveStyle(row, 13, record2.getR17_NO_OF_BNK_26_35(), null, createHelper);
					updateCellPreserveStyle(row, 14, record2.getR17_NO_OF_BNK_36_50(), null, createHelper);
					updateCellPreserveStyle(row, 15, record2.getR17_NO_CON_BNK_50(), null, createHelper);
					updateCellPreserveStyle(row, 16, record2.getR17_NO_CON_SAL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 17, record2.getR17_NO_CON_BUS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record2.getR17_NO_CON_PRO_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 19, record2.getR17_NO_CON_INC_5K(), null, createHelper);
					updateCellPreserveStyle(row, 20, record2.getR17_NO_CON_INC_5K_10K(), null, createHelper);
					updateCellPreserveStyle(row, 21, record2.getR17_NO_CON_INC_10K_20K(), null, createHelper);
					updateCellPreserveStyle(row, 22, record2.getR17_NO_CON_INC_20K_35K(), null, createHelper);
					updateCellPreserveStyle(row, 23, record2.getR17_NO_CON_INC_35K(), null, createHelper);
					updateCellPreserveStyle(row, 24, record2.getR17_NO_CON_BEL_SCL(), null, createHelper);
					updateCellPreserveStyle(row, 25, record2.getR17_NO_CON_BAC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record2.getR17_NO_CON_ABV_MAS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record2.getR17_NO_CON_ABU_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 28, record2.getR17_NO_CON_DUB_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 29, record2.getR17_NO_CON_SHJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 30, record2.getR17_NO_CON_AJM_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 31, record2.getR17_NO_CON_FUJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 32, record2.getR17_NO_CON_RAK_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 33, record2.getR17_NO_CON_UAQ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 34, record2.getR17_NO_CON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 35, record2.getR17_NO_CON_DBR_LIM(), null, createHelper);
					updateCellPreserveStyle(row, 36, record2.getR17_NO_UAE_CON_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 37, record2.getR17_NO_UAE_CON_NLS(), null, createHelper);
					updateCellPreserveStyle(row, 38, record2.getR17_VAL_LOS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 39, record2.getR17_NO_CON_ONB_90(), null, createHelper);
					updateCellPreserveStyle(row, 40, record2.getR17_NO_CON_BAL_PAY(), null, createHelper);
					updateCellPreserveStyle(row, 41, record2.getR17_NO_CON_BAL_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 42, record2.getR17_NO_CON_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 43, record2.getR17_NO_CON_ONB_REF(), null, createHelper);
					updateCellPreserveStyle(row, 44, record2.getR17_NO_CON_ONB_AGE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record2.getR17_NO_CON_AFF_UNAU(), null, createHelper);
					updateCellPreserveStyle(row, 46, record2.getR17_NO_OF_ACCS_POD(), null, createHelper);
					updateCellPreserveStyle(row, 47, record2.getR17_NO_DEL_CON(), null, createHelper);
					updateCellPreserveStyle(row, 48, record2.getR17_NO_INS_FUN_LFI(), null, createHelper);
					updateCellPreserveStyle(row, 49, record2.getR17_NO_CON_COL_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 50, record2.getR17_TOT_NO_NEW_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 51, record2.getR17_TOT_NO_NEW_NOSGN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record2.getR17_NO_CON_START(), null, createHelper);
					updateCellPreserveStyle(row, 53, record2.getR17_NO_NEW_CON_ONBO(), null, createHelper);
					updateCellPreserveStyle(row, 54, record2.getR17_NO_CON_DEBT_COUN(), null, createHelper);
					updateCellPreserveStyle(row, 55, record2.getR17_NO_CON_DEL_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 56, record2.getR17_NO_CON_GOV_50(), null, createHelper);
					updateCellPreserveStyle(row, 57, record2.getR17_NO_SME_SOLE(), null, createHelper);
					updateCellPreserveStyle(row, 58, record2.getR17_NO_CON_TAG_VUL(), null, createHelper);
					updateCellPreserveStyle(row, 59, record2.getR17_NO_NEW_CON_ONB_GNP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record2.getR17_NO_CON_END(), null, createHelper);

					setMcProgress(progressMap, jobId, 65);
					row = sheet.getRow(17);
					updateCellPreserveStyle(row, 5, record2.getR18_NO_WO_SD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record2.getR18_NO_CON_POD_SD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record2.getR18_NO_CON_UNAU_SP_TP(), null, createHelper);
					updateCellPreserveStyle(row, 8, record2.getR18_NO_CON_45_50(), null, createHelper);
					updateCellPreserveStyle(row, 9, record2.getR18_NO_CON_50(), null, createHelper);
					updateCellPreserveStyle(row, 10, record2.getR18_NO_OF_LES_50(), null, createHelper);
					updateCellPreserveStyle(row, 11, record2.getR18_NO_OF_BNK_18(), null, createHelper);
					updateCellPreserveStyle(row, 12, record2.getR18_NO_OF_BNK_18_25(), null, createHelper);
					updateCellPreserveStyle(row, 13, record2.getR18_NO_OF_BNK_26_35(), null, createHelper);
					updateCellPreserveStyle(row, 14, record2.getR18_NO_OF_BNK_36_50(), null, createHelper);
					updateCellPreserveStyle(row, 15, record2.getR18_NO_CON_BNK_50(), null, createHelper);
					updateCellPreserveStyle(row, 16, record2.getR18_NO_CON_SAL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 17, record2.getR18_NO_CON_BUS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record2.getR18_NO_CON_PRO_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 19, record2.getR18_NO_CON_INC_5K(), null, createHelper);
					updateCellPreserveStyle(row, 20, record2.getR18_NO_CON_INC_5K_10K(), null, createHelper);
					updateCellPreserveStyle(row, 21, record2.getR18_NO_CON_INC_10K_20K(), null, createHelper);
					updateCellPreserveStyle(row, 22, record2.getR18_NO_CON_INC_20K_35K(), null, createHelper);
					updateCellPreserveStyle(row, 23, record2.getR18_NO_CON_INC_35K(), null, createHelper);
					updateCellPreserveStyle(row, 24, record2.getR18_NO_CON_BEL_SCL(), null, createHelper);
					updateCellPreserveStyle(row, 25, record2.getR18_NO_CON_BAC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record2.getR18_NO_CON_ABV_MAS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record2.getR18_NO_CON_ABU_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 28, record2.getR18_NO_CON_DUB_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 29, record2.getR18_NO_CON_SHJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 30, record2.getR18_NO_CON_AJM_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 31, record2.getR18_NO_CON_FUJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 32, record2.getR18_NO_CON_RAK_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 33, record2.getR18_NO_CON_UAQ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 34, record2.getR18_NO_CON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 35, record2.getR18_NO_CON_DBR_LIM(), null, createHelper);
					updateCellPreserveStyle(row, 36, record2.getR18_NO_UAE_CON_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 37, record2.getR18_NO_UAE_CON_NLS(), null, createHelper);
					updateCellPreserveStyle(row, 38, record2.getR18_VAL_LOS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 39, record2.getR18_NO_CON_ONB_90(), null, createHelper);
					updateCellPreserveStyle(row, 40, record2.getR18_NO_CON_BAL_PAY(), null, createHelper);
					updateCellPreserveStyle(row, 41, record2.getR18_NO_CON_BAL_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 42, record2.getR18_NO_CON_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 43, record2.getR18_NO_CON_ONB_REF(), null, createHelper);
					updateCellPreserveStyle(row, 44, record2.getR18_NO_CON_ONB_AGE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record2.getR18_NO_CON_AFF_UNAU(), null, createHelper);
					updateCellPreserveStyle(row, 46, record2.getR18_NO_OF_ACCS_POD(), null, createHelper);
					updateCellPreserveStyle(row, 47, record2.getR18_NO_DEL_CON(), null, createHelper);
					updateCellPreserveStyle(row, 48, record2.getR18_NO_INS_FUN_LFI(), null, createHelper);
					updateCellPreserveStyle(row, 49, record2.getR18_NO_CON_COL_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 50, record2.getR18_TOT_NO_NEW_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 51, record2.getR18_TOT_NO_NEW_NOSGN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record2.getR18_NO_CON_START(), null, createHelper);
					updateCellPreserveStyle(row, 53, record2.getR18_NO_NEW_CON_ONBO(), null, createHelper);
					updateCellPreserveStyle(row, 54, record2.getR18_NO_CON_DEBT_COUN(), null, createHelper);
					updateCellPreserveStyle(row, 55, record2.getR18_NO_CON_DEL_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 56, record2.getR18_NO_CON_GOV_50(), null, createHelper);
					updateCellPreserveStyle(row, 57, record2.getR18_NO_SME_SOLE(), null, createHelper);
					updateCellPreserveStyle(row, 58, record2.getR18_NO_CON_TAG_VUL(), null, createHelper);
					updateCellPreserveStyle(row, 59, record2.getR18_NO_NEW_CON_ONB_GNP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record2.getR18_NO_CON_END(), null, createHelper);

					row = sheet.getRow(18);
					updateCellPreserveStyle(row, 5, record2.getR19_NO_WO_SD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record2.getR19_NO_CON_POD_SD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record2.getR19_NO_CON_UNAU_SP_TP(), null, createHelper);
					updateCellPreserveStyle(row, 8, record2.getR19_NO_CON_45_50(), null, createHelper);
					updateCellPreserveStyle(row, 9, record2.getR19_NO_CON_50(), null, createHelper);
					updateCellPreserveStyle(row, 10, record2.getR19_NO_OF_LES_50(), null, createHelper);
					updateCellPreserveStyle(row, 11, record2.getR19_NO_OF_BNK_18(), null, createHelper);
					updateCellPreserveStyle(row, 12, record2.getR19_NO_OF_BNK_18_25(), null, createHelper);
					updateCellPreserveStyle(row, 13, record2.getR19_NO_OF_BNK_26_35(), null, createHelper);
					updateCellPreserveStyle(row, 14, record2.getR19_NO_OF_BNK_36_50(), null, createHelper);
					updateCellPreserveStyle(row, 15, record2.getR19_NO_CON_BNK_50(), null, createHelper);
					updateCellPreserveStyle(row, 16, record2.getR19_NO_CON_SAL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 17, record2.getR19_NO_CON_BUS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record2.getR19_NO_CON_PRO_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 19, record2.getR19_NO_CON_INC_5K(), null, createHelper);
					updateCellPreserveStyle(row, 20, record2.getR19_NO_CON_INC_5K_10K(), null, createHelper);
					updateCellPreserveStyle(row, 21, record2.getR19_NO_CON_INC_10K_20K(), null, createHelper);
					updateCellPreserveStyle(row, 22, record2.getR19_NO_CON_INC_20K_35K(), null, createHelper);
					updateCellPreserveStyle(row, 23, record2.getR19_NO_CON_INC_35K(), null, createHelper);
					updateCellPreserveStyle(row, 24, record2.getR19_NO_CON_BEL_SCL(), null, createHelper);
					updateCellPreserveStyle(row, 25, record2.getR19_NO_CON_BAC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record2.getR19_NO_CON_ABV_MAS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record2.getR19_NO_CON_ABU_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 28, record2.getR19_NO_CON_DUB_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 29, record2.getR19_NO_CON_SHJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 30, record2.getR19_NO_CON_AJM_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 31, record2.getR19_NO_CON_FUJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 32, record2.getR19_NO_CON_RAK_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 33, record2.getR19_NO_CON_UAQ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 34, record2.getR19_NO_CON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 35, record2.getR19_NO_CON_DBR_LIM(), null, createHelper);
					updateCellPreserveStyle(row, 36, record2.getR19_NO_UAE_CON_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 37, record2.getR19_NO_UAE_CON_NLS(), null, createHelper);
					updateCellPreserveStyle(row, 38, record2.getR19_VAL_LOS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 39, record2.getR19_NO_CON_ONB_90(), null, createHelper);
					updateCellPreserveStyle(row, 40, record2.getR19_NO_CON_BAL_PAY(), null, createHelper);
					updateCellPreserveStyle(row, 41, record2.getR19_NO_CON_BAL_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 42, record2.getR19_NO_CON_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 43, record2.getR19_NO_CON_ONB_REF(), null, createHelper);
					updateCellPreserveStyle(row, 44, record2.getR19_NO_CON_ONB_AGE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record2.getR19_NO_CON_AFF_UNAU(), null, createHelper);
					updateCellPreserveStyle(row, 46, record2.getR19_NO_OF_ACCS_POD(), null, createHelper);
					updateCellPreserveStyle(row, 47, record2.getR19_NO_DEL_CON(), null, createHelper);
					updateCellPreserveStyle(row, 48, record2.getR19_NO_INS_FUN_LFI(), null, createHelper);
					updateCellPreserveStyle(row, 49, record2.getR19_NO_CON_COL_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 50, record2.getR19_TOT_NO_NEW_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 51, record2.getR19_TOT_NO_NEW_NOSGN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record2.getR19_NO_CON_START(), null, createHelper);
					updateCellPreserveStyle(row, 53, record2.getR19_NO_NEW_CON_ONBO(), null, createHelper);
					updateCellPreserveStyle(row, 54, record2.getR19_NO_CON_DEBT_COUN(), null, createHelper);
					updateCellPreserveStyle(row, 55, record2.getR19_NO_CON_DEL_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 56, record2.getR19_NO_CON_GOV_50(), null, createHelper);
					updateCellPreserveStyle(row, 57, record2.getR19_NO_SME_SOLE(), null, createHelper);
					updateCellPreserveStyle(row, 58, record2.getR19_NO_CON_TAG_VUL(), null, createHelper);
					updateCellPreserveStyle(row, 59, record2.getR19_NO_NEW_CON_ONB_GNP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record2.getR19_NO_CON_END(), null, createHelper);

					setMcProgress(progressMap, jobId, 75);
					row = sheet.getRow(19);
					updateCellPreserveStyle(row, 5, record2.getR20_NO_WO_SD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record2.getR20_NO_CON_POD_SD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record2.getR20_NO_CON_UNAU_SP_TP(), null, createHelper);
					updateCellPreserveStyle(row, 8, record2.getR20_NO_CON_45_50(), null, createHelper);
					updateCellPreserveStyle(row, 9, record2.getR20_NO_CON_50(), null, createHelper);
					updateCellPreserveStyle(row, 10, record2.getR20_NO_OF_LES_50(), null, createHelper);
					updateCellPreserveStyle(row, 11, record2.getR20_NO_OF_BNK_18(), null, createHelper);
					updateCellPreserveStyle(row, 12, record2.getR20_NO_OF_BNK_18_25(), null, createHelper);
					updateCellPreserveStyle(row, 13, record2.getR20_NO_OF_BNK_26_35(), null, createHelper);
					updateCellPreserveStyle(row, 14, record2.getR20_NO_OF_BNK_36_50(), null, createHelper);
					updateCellPreserveStyle(row, 15, record2.getR20_NO_CON_BNK_50(), null, createHelper);
					updateCellPreserveStyle(row, 16, record2.getR20_NO_CON_SAL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 17, record2.getR20_NO_CON_BUS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record2.getR20_NO_CON_PRO_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 19, record2.getR20_NO_CON_INC_5K(), null, createHelper);
					updateCellPreserveStyle(row, 20, record2.getR20_NO_CON_INC_5K_10K(), null, createHelper);
					updateCellPreserveStyle(row, 21, record2.getR20_NO_CON_INC_10K_20K(), null, createHelper);
					updateCellPreserveStyle(row, 22, record2.getR20_NO_CON_INC_20K_35K(), null, createHelper);
					updateCellPreserveStyle(row, 23, record2.getR20_NO_CON_INC_35K(), null, createHelper);
					updateCellPreserveStyle(row, 24, record2.getR20_NO_CON_BEL_SCL(), null, createHelper);
					updateCellPreserveStyle(row, 25, record2.getR20_NO_CON_BAC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record2.getR20_NO_CON_ABV_MAS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record2.getR20_NO_CON_ABU_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 28, record2.getR20_NO_CON_DUB_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 29, record2.getR20_NO_CON_SHJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 30, record2.getR20_NO_CON_AJM_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 31, record2.getR20_NO_CON_FUJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 32, record2.getR20_NO_CON_RAK_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 33, record2.getR20_NO_CON_UAQ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 34, record2.getR20_NO_CON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 35, record2.getR20_NO_CON_DBR_LIM(), null, createHelper);
					updateCellPreserveStyle(row, 36, record2.getR20_NO_UAE_CON_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 37, record2.getR20_NO_UAE_CON_NLS(), null, createHelper);
					updateCellPreserveStyle(row, 38, record2.getR20_VAL_LOS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 39, record2.getR20_NO_CON_ONB_90(), null, createHelper);
					updateCellPreserveStyle(row, 40, record2.getR20_NO_CON_BAL_PAY(), null, createHelper);
					updateCellPreserveStyle(row, 41, record2.getR20_NO_CON_BAL_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 42, record2.getR20_NO_CON_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 43, record2.getR20_NO_CON_ONB_REF(), null, createHelper);
					updateCellPreserveStyle(row, 44, record2.getR20_NO_CON_ONB_AGE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record2.getR20_NO_CON_AFF_UNAU(), null, createHelper);
					updateCellPreserveStyle(row, 46, record2.getR20_NO_OF_ACCS_POD(), null, createHelper);
					updateCellPreserveStyle(row, 47, record2.getR20_NO_DEL_CON(), null, createHelper);
					updateCellPreserveStyle(row, 48, record2.getR20_NO_INS_FUN_LFI(), null, createHelper);
					updateCellPreserveStyle(row, 49, record2.getR20_NO_CON_COL_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 50, record2.getR20_TOT_NO_NEW_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 51, record2.getR20_TOT_NO_NEW_NOSGN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record2.getR20_NO_CON_START(), null, createHelper);
					updateCellPreserveStyle(row, 53, record2.getR20_NO_NEW_CON_ONBO(), null, createHelper);
					updateCellPreserveStyle(row, 54, record2.getR20_NO_CON_DEBT_COUN(), null, createHelper);
					updateCellPreserveStyle(row, 55, record2.getR20_NO_CON_DEL_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 56, record2.getR20_NO_CON_GOV_50(), null, createHelper);
					updateCellPreserveStyle(row, 57, record2.getR20_NO_SME_SOLE(), null, createHelper);
					updateCellPreserveStyle(row, 58, record2.getR20_NO_CON_TAG_VUL(), null, createHelper);
					updateCellPreserveStyle(row, 59, record2.getR20_NO_NEW_CON_ONB_GNP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record2.getR20_NO_CON_END(), null, createHelper);

					row = sheet.getRow(20);
					updateCellPreserveStyle(row, 5, record2.getR21_NO_WO_SD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record2.getR21_NO_CON_POD_SD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record2.getR21_NO_CON_UNAU_SP_TP(), null, createHelper);
					updateCellPreserveStyle(row, 8, record2.getR21_NO_CON_45_50(), null, createHelper);
					updateCellPreserveStyle(row, 9, record2.getR21_NO_CON_50(), null, createHelper);
					updateCellPreserveStyle(row, 10, record2.getR21_NO_OF_LES_50(), null, createHelper);
					updateCellPreserveStyle(row, 11, record2.getR21_NO_OF_BNK_18(), null, createHelper);
					updateCellPreserveStyle(row, 12, record2.getR21_NO_OF_BNK_18_25(), null, createHelper);
					updateCellPreserveStyle(row, 13, record2.getR21_NO_OF_BNK_26_35(), null, createHelper);
					updateCellPreserveStyle(row, 14, record2.getR21_NO_OF_BNK_36_50(), null, createHelper);
					updateCellPreserveStyle(row, 15, record2.getR21_NO_CON_BNK_50(), null, createHelper);
					updateCellPreserveStyle(row, 16, record2.getR21_NO_CON_SAL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 17, record2.getR21_NO_CON_BUS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record2.getR21_NO_CON_PRO_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 19, record2.getR21_NO_CON_INC_5K(), null, createHelper);
					updateCellPreserveStyle(row, 20, record2.getR21_NO_CON_INC_5K_10K(), null, createHelper);
					updateCellPreserveStyle(row, 21, record2.getR21_NO_CON_INC_10K_20K(), null, createHelper);
					updateCellPreserveStyle(row, 22, record2.getR21_NO_CON_INC_20K_35K(), null, createHelper);
					updateCellPreserveStyle(row, 23, record2.getR21_NO_CON_INC_35K(), null, createHelper);
					updateCellPreserveStyle(row, 24, record2.getR21_NO_CON_BEL_SCL(), null, createHelper);
					updateCellPreserveStyle(row, 25, record2.getR21_NO_CON_BAC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record2.getR21_NO_CON_ABV_MAS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record2.getR21_NO_CON_ABU_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 28, record2.getR21_NO_CON_DUB_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 29, record2.getR21_NO_CON_SHJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 30, record2.getR21_NO_CON_AJM_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 31, record2.getR21_NO_CON_FUJ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 32, record2.getR21_NO_CON_RAK_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 33, record2.getR21_NO_CON_UAQ_KYC(), null, createHelper);
					updateCellPreserveStyle(row, 34, record2.getR21_NO_CON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 35, record2.getR21_NO_CON_DBR_LIM(), null, createHelper);
					updateCellPreserveStyle(row, 36, record2.getR21_NO_UAE_CON_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 37, record2.getR21_NO_UAE_CON_NLS(), null, createHelper);
					updateCellPreserveStyle(row, 38, record2.getR21_VAL_LOS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 39, record2.getR21_NO_CON_ONB_90(), null, createHelper);
					updateCellPreserveStyle(row, 40, record2.getR21_NO_CON_BAL_PAY(), null, createHelper);
					updateCellPreserveStyle(row, 41, record2.getR21_NO_CON_BAL_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 42, record2.getR21_NO_CON_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 43, record2.getR21_NO_CON_ONB_REF(), null, createHelper);
					updateCellPreserveStyle(row, 44, record2.getR21_NO_CON_ONB_AGE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record2.getR21_NO_CON_AFF_UNAU(), null, createHelper);
					updateCellPreserveStyle(row, 46, record2.getR21_NO_OF_ACCS_POD(), null, createHelper);
					updateCellPreserveStyle(row, 47, record2.getR21_NO_DEL_CON(), null, createHelper);
					updateCellPreserveStyle(row, 48, record2.getR21_NO_INS_FUN_LFI(), null, createHelper);
					updateCellPreserveStyle(row, 49, record2.getR21_NO_CON_COL_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 50, record2.getR21_TOT_NO_NEW_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 51, record2.getR21_TOT_NO_NEW_NOSGN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record2.getR21_NO_CON_START(), null, createHelper);
					updateCellPreserveStyle(row, 53, record2.getR21_NO_NEW_CON_ONBO(), null, createHelper);
					updateCellPreserveStyle(row, 54, record2.getR21_NO_CON_DEBT_COUN(), null, createHelper);
					updateCellPreserveStyle(row, 55, record2.getR21_NO_CON_DEL_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 56, record2.getR21_NO_CON_GOV_50(), null, createHelper);
					updateCellPreserveStyle(row, 57, record2.getR21_NO_SME_SOLE(), null, createHelper);
					updateCellPreserveStyle(row, 58, record2.getR21_NO_CON_TAG_VUL(), null, createHelper);
					updateCellPreserveStyle(row, 59, record2.getR21_NO_NEW_CON_ONB_GNP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record2.getR21_NO_CON_END(), null, createHelper);

					setMcProgress(progressMap, jobId, 85);
//					row = sheet.getRow(21);
//					updateCellPreserveStyle(row, 5, record2.getR22_NO_WO_SD(), null, createHelper);
//					updateCellPreserveStyle(row, 6, record2.getR22_NO_CON_POD_SD(), null, createHelper);
//					updateCellPreserveStyle(row, 7, record2.getR22_NO_CON_UNAU_SP_TP(), null, createHelper);
//					updateCellPreserveStyle(row, 8, record2.getR22_NO_CON_45_50(), null, createHelper);
//					updateCellPreserveStyle(row, 9, record2.getR22_NO_CON_50(), null, createHelper);
//					updateCellPreserveStyle(row, 10, record2.getR22_NO_OF_LES_50(), null, createHelper);
//					updateCellPreserveStyle(row, 11, record2.getR22_NO_OF_BNK_18(), null, createHelper);
//					updateCellPreserveStyle(row, 12, record2.getR22_NO_OF_BNK_18_25(), null, createHelper);
//					updateCellPreserveStyle(row, 13, record2.getR22_NO_OF_BNK_26_35(), null, createHelper);
//					updateCellPreserveStyle(row, 14, record2.getR22_NO_OF_BNK_36_50(), null, createHelper);
//					updateCellPreserveStyle(row, 15, record2.getR22_NO_CON_BNK_50(), null, createHelper);
//					updateCellPreserveStyle(row, 16, record2.getR22_NO_CON_SAL_SPD(), null, createHelper);
//					updateCellPreserveStyle(row, 17, record2.getR22_NO_CON_BUS_SPD(), null, createHelper);
//					updateCellPreserveStyle(row, 18, record2.getR22_NO_CON_PRO_SPD(), null, createHelper);
//					updateCellPreserveStyle(row, 19, record2.getR22_NO_CON_INC_5K(), null, createHelper);
//					updateCellPreserveStyle(row, 20, record2.getR22_NO_CON_INC_5K_10K(), null, createHelper);
//					updateCellPreserveStyle(row, 21, record2.getR22_NO_CON_INC_10K_20K(), null, createHelper);
//					updateCellPreserveStyle(row, 22, record2.getR22_NO_CON_INC_20K_35K(), null, createHelper);
//					updateCellPreserveStyle(row, 23, record2.getR22_NO_CON_INC_35K(), null, createHelper);
//					updateCellPreserveStyle(row, 24, record2.getR22_NO_CON_BEL_SCL(), null, createHelper);
//					updateCellPreserveStyle(row, 25, record2.getR22_NO_CON_BAC(), null, createHelper);
//					updateCellPreserveStyle(row, 26, record2.getR22_NO_CON_ABV_MAS(), null, createHelper);
//					updateCellPreserveStyle(row, 27, record2.getR22_NO_CON_ABU_KYC(), null, createHelper);
//					updateCellPreserveStyle(row, 28, record2.getR22_NO_CON_DUB_KYC(), null, createHelper);
//					updateCellPreserveStyle(row, 29, record2.getR22_NO_CON_SHJ_KYC(), null, createHelper);
//					updateCellPreserveStyle(row, 30, record2.getR22_NO_CON_AJM_KYC(), null, createHelper);
//					updateCellPreserveStyle(row, 31, record2.getR22_NO_CON_FUJ_KYC(), null, createHelper);
//					updateCellPreserveStyle(row, 32, record2.getR22_NO_CON_RAK_KYC(), null, createHelper);
//					updateCellPreserveStyle(row, 33, record2.getR22_NO_CON_UAQ_KYC(), null, createHelper);
//					updateCellPreserveStyle(row, 34, record2.getR22_NO_CON_RET(), null, createHelper);
//					updateCellPreserveStyle(row, 35, record2.getR22_NO_CON_DBR_LIM(), null, createHelper);
//					updateCellPreserveStyle(row, 36, record2.getR22_NO_UAE_CON_SPC_TP(), null, createHelper);
//					updateCellPreserveStyle(row, 37, record2.getR22_NO_UAE_CON_NLS(), null, createHelper);
//					updateCellPreserveStyle(row, 38, record2.getR22_VAL_LOS_AED(), null, createHelper);
//					updateCellPreserveStyle(row, 39, record2.getR22_NO_CON_ONB_90(), null, createHelper);
//					updateCellPreserveStyle(row, 40, record2.getR22_NO_CON_BAL_PAY(), null, createHelper);
//					updateCellPreserveStyle(row, 41, record2.getR22_NO_CON_BAL_SPC_TP(), null, createHelper);
//					updateCellPreserveStyle(row, 42, record2.getR22_NO_CON_DEBT(), null, createHelper);
//					updateCellPreserveStyle(row, 43, record2.getR22_NO_CON_ONB_REF(), null, createHelper);
//					updateCellPreserveStyle(row, 44, record2.getR22_NO_CON_ONB_AGE(), null, createHelper);
//					updateCellPreserveStyle(row, 45, record2.getR22_NO_CON_AFF_UNAU(), null, createHelper);
//					updateCellPreserveStyle(row, 46, record2.getR22_NO_OF_ACCS_POD(), null, createHelper);
//					updateCellPreserveStyle(row, 47, record2.getR22_NO_DEL_CON(), null, createHelper);
//					updateCellPreserveStyle(row, 48, record2.getR22_NO_INS_FUN_LFI(), null, createHelper);
//					updateCellPreserveStyle(row, 49, record2.getR22_NO_CON_COL_FIN(), null, createHelper);
//					updateCellPreserveStyle(row, 50, record2.getR22_TOT_NO_NEW_FIN(), null, createHelper);
//					updateCellPreserveStyle(row, 51, record2.getR22_TOT_NO_NEW_NOSGN(), null, createHelper);
//					updateCellPreserveStyle(row, 52, record2.getR22_NO_CON_START(), null, createHelper);
//					updateCellPreserveStyle(row, 53, record2.getR22_NO_NEW_CON_ONBO(), null, createHelper);
//					updateCellPreserveStyle(row, 54, record2.getR22_NO_CON_DEBT_COUN(), null, createHelper);
//					updateCellPreserveStyle(row, 55, record2.getR22_NO_CON_DEL_NPA(), null, createHelper);
//					updateCellPreserveStyle(row, 56, record2.getR22_NO_CON_GOV_50(), null, createHelper);
//					updateCellPreserveStyle(row, 57, record2.getR22_NO_SME_SOLE(), null, createHelper);
//					updateCellPreserveStyle(row, 58, record2.getR22_NO_CON_TAG_VUL(), null, createHelper);
//					updateCellPreserveStyle(row, 59, record2.getR22_NO_NEW_CON_ONB_GNP(), null, createHelper);
//					updateCellPreserveStyle(row, 60, record2.getR22_NO_CON_END(), null, createHelper);


				}
				evaluateMcFormulas(workbook, jobId);
			} else {

			}

			
		} catch (Exception e) {
			logger.error("MC download jobId={} excel write failed reportDate={} branch={} formmode={}", jobId,
					reportDate, branch, formmode, e);
			throw e;
		}

	}

	public void GenerateTable_3_Excel(Workbook workbook,String branch, String jobId, Map<String, Integer> progressMap, String formmode,
			String reportDate, String isConsolidated, String reportOption, String selectedDepartments) throws Exception {
//		logMcDownload(jobId, "fetching database rows", reportDate, branch, isConsolidated, formmode);
//
//		List<RT_MC_TABLE3_ENTITY> dataList;
//
//		if (branch =="DEPT" || branch.equals("DEPT")) {
//			dataList = RT_MC_TABLE3_REPO.findBybranchcode(branch);
//		}
//		else {
//			dataList = RT_MC_TABLE3_REPO.findByReportDateAndBranchCode(reportDate, branch);
//		}
//		if (dataList.isEmpty()) {
//			logger.warn("Service: No data found for MC report. Returning empty result.");
//			return;
//		}

		logMcDownload(jobId, "fetching database rows", reportDate, branch, isConsolidated, formmode);
	    List<RT_MC_TABLE3_ENTITY> dataList = new ArrayList<>();

	    if ("YES".equalsIgnoreCase(isConsolidated)) {
	        
	        List<RT_MC_TABLE3_ENTITY> numData = RT_MC_TABLE3_REPO.findByReportDateAndBranchCode(reportDate, branch);
	        List<RT_MC_TABLE3_ENTITY> deptData = RT_MC_TABLE3_REPO.findBybranchcode("DEPT");
	        
	        dataList = mergeReportData(numData, deptData, reportOption, selectedDepartments, RT_MC_TABLE3_ENTITY.class);
	        
	    } else {
	        if ("DEPT".equals(branch)) {
	            dataList = RT_MC_TABLE3_REPO.findBybranchcode(branch);
	        } else {
	            dataList = RT_MC_TABLE3_REPO.findByReportDateAndBranchCode(reportDate, branch);
	        }
	    }

	    if (dataList == null || dataList.isEmpty()) {
	        logger.warn("MC download jobId={} no rows after fetch. reportDate={} branch={} formmode={}", jobId,
	        		reportDate, branch, formmode);
	        return;
	    }
	    logger.info("MC download jobId={} fetched {} rows. Sheet write starts next.", jobId, dataList.size());

		try  {

			Sheet sheet = openMcSheet(workbook, jobId, 5);

			// --- Style Definitions ---
			CreationHelper createHelper = workbook.getCreationHelper();

			CellStyle dateStyle = workbook.createCellStyle();
			dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
			dateStyle.setBorderBottom(BorderStyle.THIN);
			dateStyle.setBorderTop(BorderStyle.THIN);
			dateStyle.setBorderLeft(BorderStyle.THIN);
			dateStyle.setBorderRight(BorderStyle.THIN);

			CellStyle textStyle = workbook.createCellStyle();
			textStyle.setBorderBottom(BorderStyle.THIN);
			textStyle.setBorderTop(BorderStyle.THIN);
			textStyle.setBorderLeft(BorderStyle.THIN);
			textStyle.setBorderRight(BorderStyle.THIN);

			// Create the font
			Font font = workbook.createFont();
			font.setFontHeightInPoints((short) 8); // size 8
			font.setFontName("Arial");

			CellStyle numberStyle = workbook.createCellStyle();
			// numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("0.000"));
			numberStyle.setBorderBottom(BorderStyle.THIN);
			numberStyle.setBorderTop(BorderStyle.THIN);
			numberStyle.setBorderLeft(BorderStyle.THIN);
			numberStyle.setBorderRight(BorderStyle.THIN);
			numberStyle.setFont(font);
			// --- End of Style Definitions ---

			int startRow = 5;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {
					RT_MC_TABLE3_ENTITY record = dataList.get(i);
					System.out.println("rownumber=" + startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}
					setMcProgress(progressMap, jobId, 5, "writing row " + (i + 1) + " excelRow " + (startRow + i));

					row = sheet.getRow(5);
					updateCellPreserveStyle(row, 5, record.getR6_NO_COM_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR6_NO_COM_PEN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR6_AMT_FIN_AED(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR6_NO_COM_ADV_FEES(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR6_NO_COM_DET_SPC_PT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR6_NO_COM_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR6_NO_COM_AGNT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR6_NO_COM_MISSEL(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR6_NO_COM_FILCOM(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR6_NO_COM_PRO_SER(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR6_NO_ASO_PROD(), null, createHelper);
					updateCellPreserveStyle(row, 16, record.getR6_NO_CON_PHN(), null, createHelper);
					updateCellPreserveStyle(row, 17, record.getR6_NO_CON_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 18, record.getR6_NO_CON_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 19, record.getR6_NO_OUT_UNRES(), null, createHelper);
					updateCellPreserveStyle(row, 20, record.getR6_NO_COM_RES_CON(), null, createHelper);
					updateCellPreserveStyle(row, 21, record.getR6_NO_RES_30_COM(), null, createHelper);
					updateCellPreserveStyle(row, 22, record.getR6_AVG_TME_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 23, record.getR6_NO_COM_STF_MIS(), null, createHelper);
					updateCellPreserveStyle(row, 24, record.getR6_NO_COM_ATM_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 25, record.getR6_NO_COM_FIN_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 26, record.getR6_NO_COM_FAV_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record.getR6_NO_COM_PRV_PER(), null, createHelper);
					updateCellPreserveStyle(row, 28, record.getR6_NO_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 29, record.getR6_NO_STEP_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 30, record.getR6_NO_CUST_LEGAL(), null, createHelper);
					updateCellPreserveStyle(row, 31, record.getR6_NO_COM_FAIL(), null, createHelper);
					updateCellPreserveStyle(row, 32, record.getR6_NO_COM_EXP_CON(), null, createHelper);
					updateCellPreserveStyle(row, 33, record.getR6_NO_COM_SANA(), null, createHelper);
					updateCellPreserveStyle(row, 34, record.getR6_NO_COM_CBUAE_SD(), null, createHelper);
					updateCellPreserveStyle(row, 35, record.getR6_NO_RES_COM_7(), null, createHelper);
					updateCellPreserveStyle(row, 36, record.getR6_NO_RES_COM_15(), null, createHelper);
					updateCellPreserveStyle(row, 37, record.getR6_NO_COM_UPHEL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record.getR6_NO_COM_BNK_STF(), null, createHelper);
					updateCellPreserveStyle(row, 39, record.getR6_NO_COM_INHOU(), null, createHelper);
					updateCellPreserveStyle(row, 40, record.getR6_NO_COM_ACK_TT(), null, createHelper);
					updateCellPreserveStyle(row, 41, record.getR6_NO_COM_DEBT_COLL(), null, createHelper);
					updateCellPreserveStyle(row, 42, record.getR6_NO_INST_CRE_RATE(), null, createHelper);
					updateCellPreserveStyle(row, 43, record.getR6_NO_CON_DELAY(), null, createHelper);
					updateCellPreserveStyle(row, 44, record.getR6_NO_COM_REP_DTE(), null, createHelper);

					row = sheet.getRow(6);
					updateCellPreserveStyle(row, 5, record.getR7_NO_COM_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR7_NO_COM_PEN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR7_AMT_FIN_AED(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR7_NO_COM_ADV_FEES(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR7_NO_COM_DET_SPC_PT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR7_NO_COM_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR7_NO_COM_AGNT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR7_NO_COM_MISSEL(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR7_NO_COM_FILCOM(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR7_NO_COM_PRO_SER(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR7_NO_ASO_PROD(), null, createHelper);
					updateCellPreserveStyle(row, 16, record.getR7_NO_CON_PHN(), null, createHelper);
					updateCellPreserveStyle(row, 17, record.getR7_NO_CON_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 18, record.getR7_NO_CON_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 19, record.getR7_NO_OUT_UNRES(), null, createHelper);
					updateCellPreserveStyle(row, 20, record.getR7_NO_COM_RES_CON(), null, createHelper);
					updateCellPreserveStyle(row, 21, record.getR7_NO_RES_30_COM(), null, createHelper);
					updateCellPreserveStyle(row, 22, record.getR7_AVG_TME_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 23, record.getR7_NO_COM_STF_MIS(), null, createHelper);
					updateCellPreserveStyle(row, 24, record.getR7_NO_COM_ATM_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 25, record.getR7_NO_COM_FIN_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 26, record.getR7_NO_COM_FAV_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record.getR7_NO_COM_PRV_PER(), null, createHelper);
					updateCellPreserveStyle(row, 28, record.getR7_NO_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 29, record.getR7_NO_STEP_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 30, record.getR7_NO_CUST_LEGAL(), null, createHelper);
					updateCellPreserveStyle(row, 31, record.getR7_NO_COM_FAIL(), null, createHelper);
					updateCellPreserveStyle(row, 32, record.getR7_NO_COM_EXP_CON(), null, createHelper);
					updateCellPreserveStyle(row, 33, record.getR7_NO_COM_SANA(), null, createHelper);
					updateCellPreserveStyle(row, 34, record.getR7_NO_COM_CBUAE_SD(), null, createHelper);
					updateCellPreserveStyle(row, 35, record.getR7_NO_RES_COM_7(), null, createHelper);
					updateCellPreserveStyle(row, 36, record.getR7_NO_RES_COM_15(), null, createHelper);
					updateCellPreserveStyle(row, 37, record.getR7_NO_COM_UPHEL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record.getR7_NO_COM_BNK_STF(), null, createHelper);
					updateCellPreserveStyle(row, 39, record.getR7_NO_COM_INHOU(), null, createHelper);
					updateCellPreserveStyle(row, 40, record.getR7_NO_COM_ACK_TT(), null, createHelper);
					updateCellPreserveStyle(row, 41, record.getR7_NO_COM_DEBT_COLL(), null, createHelper);
					updateCellPreserveStyle(row, 42, record.getR7_NO_INST_CRE_RATE(), null, createHelper);
					updateCellPreserveStyle(row, 43, record.getR7_NO_CON_DELAY(), null, createHelper);
					updateCellPreserveStyle(row, 44, record.getR7_NO_COM_REP_DTE(), null, createHelper);

					setMcProgress(progressMap, jobId, 15);
					row = sheet.getRow(7);
					updateCellPreserveStyle(row, 5, record.getR8_NO_COM_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR8_NO_COM_PEN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR8_AMT_FIN_AED(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR8_NO_COM_ADV_FEES(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR8_NO_COM_DET_SPC_PT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR8_NO_COM_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR8_NO_COM_AGNT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR8_NO_COM_MISSEL(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR8_NO_COM_FILCOM(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR8_NO_COM_PRO_SER(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR8_NO_ASO_PROD(), null, createHelper);
					updateCellPreserveStyle(row, 16, record.getR8_NO_CON_PHN(), null, createHelper);
					updateCellPreserveStyle(row, 17, record.getR8_NO_CON_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 18, record.getR8_NO_CON_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 19, record.getR8_NO_OUT_UNRES(), null, createHelper);
					updateCellPreserveStyle(row, 20, record.getR8_NO_COM_RES_CON(), null, createHelper);
					updateCellPreserveStyle(row, 21, record.getR8_NO_RES_30_COM(), null, createHelper);
					updateCellPreserveStyle(row, 22, record.getR8_AVG_TME_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 23, record.getR8_NO_COM_STF_MIS(), null, createHelper);
					updateCellPreserveStyle(row, 24, record.getR8_NO_COM_ATM_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 25, record.getR8_NO_COM_FIN_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 26, record.getR8_NO_COM_FAV_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record.getR8_NO_COM_PRV_PER(), null, createHelper);
					updateCellPreserveStyle(row, 28, record.getR8_NO_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 29, record.getR8_NO_STEP_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 30, record.getR8_NO_CUST_LEGAL(), null, createHelper);
					updateCellPreserveStyle(row, 31, record.getR8_NO_COM_FAIL(), null, createHelper);
					updateCellPreserveStyle(row, 32, record.getR8_NO_COM_EXP_CON(), null, createHelper);
					updateCellPreserveStyle(row, 33, record.getR8_NO_COM_SANA(), null, createHelper);
					updateCellPreserveStyle(row, 34, record.getR8_NO_COM_CBUAE_SD(), null, createHelper);
					updateCellPreserveStyle(row, 35, record.getR8_NO_RES_COM_7(), null, createHelper);
					updateCellPreserveStyle(row, 36, record.getR8_NO_RES_COM_15(), null, createHelper);
					updateCellPreserveStyle(row, 37, record.getR8_NO_COM_UPHEL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record.getR8_NO_COM_BNK_STF(), null, createHelper);
					updateCellPreserveStyle(row, 39, record.getR8_NO_COM_INHOU(), null, createHelper);
					updateCellPreserveStyle(row, 40, record.getR8_NO_COM_ACK_TT(), null, createHelper);
					updateCellPreserveStyle(row, 41, record.getR8_NO_COM_DEBT_COLL(), null, createHelper);
					updateCellPreserveStyle(row, 42, record.getR8_NO_INST_CRE_RATE(), null, createHelper);
					updateCellPreserveStyle(row, 43, record.getR8_NO_CON_DELAY(), null, createHelper);
					updateCellPreserveStyle(row, 44, record.getR8_NO_COM_REP_DTE(), null, createHelper);

					row = sheet.getRow(8);
					updateCellPreserveStyle(row, 5, record.getR9_NO_COM_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR9_NO_COM_PEN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR9_AMT_FIN_AED(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR9_NO_COM_ADV_FEES(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR9_NO_COM_DET_SPC_PT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR9_NO_COM_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR9_NO_COM_AGNT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR9_NO_COM_MISSEL(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR9_NO_COM_FILCOM(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR9_NO_COM_PRO_SER(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR9_NO_ASO_PROD(), null, createHelper);
					updateCellPreserveStyle(row, 16, record.getR9_NO_CON_PHN(), null, createHelper);
					updateCellPreserveStyle(row, 17, record.getR9_NO_CON_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 18, record.getR9_NO_CON_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 19, record.getR9_NO_OUT_UNRES(), null, createHelper);
					updateCellPreserveStyle(row, 20, record.getR9_NO_COM_RES_CON(), null, createHelper);
					updateCellPreserveStyle(row, 21, record.getR9_NO_RES_30_COM(), null, createHelper);
					updateCellPreserveStyle(row, 22, record.getR9_AVG_TME_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 23, record.getR9_NO_COM_STF_MIS(), null, createHelper);
					updateCellPreserveStyle(row, 24, record.getR9_NO_COM_ATM_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 25, record.getR9_NO_COM_FIN_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 26, record.getR9_NO_COM_FAV_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record.getR9_NO_COM_PRV_PER(), null, createHelper);
					updateCellPreserveStyle(row, 28, record.getR9_NO_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 29, record.getR9_NO_STEP_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 30, record.getR9_NO_CUST_LEGAL(), null, createHelper);
					updateCellPreserveStyle(row, 31, record.getR9_NO_COM_FAIL(), null, createHelper);
					updateCellPreserveStyle(row, 32, record.getR9_NO_COM_EXP_CON(), null, createHelper);
					updateCellPreserveStyle(row, 33, record.getR9_NO_COM_SANA(), null, createHelper);
					updateCellPreserveStyle(row, 34, record.getR9_NO_COM_CBUAE_SD(), null, createHelper);
					updateCellPreserveStyle(row, 35, record.getR9_NO_RES_COM_7(), null, createHelper);
					updateCellPreserveStyle(row, 36, record.getR9_NO_RES_COM_15(), null, createHelper);
					updateCellPreserveStyle(row, 37, record.getR9_NO_COM_UPHEL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record.getR9_NO_COM_BNK_STF(), null, createHelper);
					updateCellPreserveStyle(row, 39, record.getR9_NO_COM_INHOU(), null, createHelper);
					updateCellPreserveStyle(row, 40, record.getR9_NO_COM_ACK_TT(), null, createHelper);
					updateCellPreserveStyle(row, 41, record.getR9_NO_COM_DEBT_COLL(), null, createHelper);
					updateCellPreserveStyle(row, 42, record.getR9_NO_INST_CRE_RATE(), null, createHelper);
					updateCellPreserveStyle(row, 43, record.getR9_NO_CON_DELAY(), null, createHelper);
					updateCellPreserveStyle(row, 44, record.getR9_NO_COM_REP_DTE(), null, createHelper);
					row = sheet.getRow(9);
					setMcProgress(progressMap, jobId, 25);

					updateCellPreserveStyle(row, 5, record.getR10_NO_COM_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR10_NO_COM_PEN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR10_AMT_FIN_AED(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR10_NO_COM_ADV_FEES(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR10_NO_COM_DET_SPC_PT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR10_NO_COM_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR10_NO_COM_AGNT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR10_NO_COM_MISSEL(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR10_NO_COM_FILCOM(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR10_NO_COM_PRO_SER(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR10_NO_ASO_PROD(), null, createHelper);
					updateCellPreserveStyle(row, 16, record.getR10_NO_CON_PHN(), null, createHelper);
					updateCellPreserveStyle(row, 17, record.getR10_NO_CON_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 18, record.getR10_NO_CON_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 19, record.getR10_NO_OUT_UNRES(), null, createHelper);
					updateCellPreserveStyle(row, 20, record.getR10_NO_COM_RES_CON(), null, createHelper);
					updateCellPreserveStyle(row, 21, record.getR10_NO_RES_30_COM(), null, createHelper);
					updateCellPreserveStyle(row, 22, record.getR10_AVG_TME_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 23, record.getR10_NO_COM_STF_MIS(), null, createHelper);
					updateCellPreserveStyle(row, 24, record.getR10_NO_COM_ATM_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 25, record.getR10_NO_COM_FIN_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 26, record.getR10_NO_COM_FAV_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record.getR10_NO_COM_PRV_PER(), null, createHelper);
					updateCellPreserveStyle(row, 28, record.getR10_NO_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 29, record.getR10_NO_STEP_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 30, record.getR10_NO_CUST_LEGAL(), null, createHelper);
					updateCellPreserveStyle(row, 31, record.getR10_NO_COM_FAIL(), null, createHelper);
					updateCellPreserveStyle(row, 32, record.getR10_NO_COM_EXP_CON(), null, createHelper);
					updateCellPreserveStyle(row, 33, record.getR10_NO_COM_SANA(), null, createHelper);
					updateCellPreserveStyle(row, 34, record.getR10_NO_COM_CBUAE_SD(), null, createHelper);
					updateCellPreserveStyle(row, 35, record.getR10_NO_RES_COM_7(), null, createHelper);
					updateCellPreserveStyle(row, 36, record.getR10_NO_RES_COM_15(), null, createHelper);
					updateCellPreserveStyle(row, 37, record.getR10_NO_COM_UPHEL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record.getR10_NO_COM_BNK_STF(), null, createHelper);
					updateCellPreserveStyle(row, 39, record.getR10_NO_COM_INHOU(), null, createHelper);
					updateCellPreserveStyle(row, 40, record.getR10_NO_COM_ACK_TT(), null, createHelper);
					updateCellPreserveStyle(row, 41, record.getR10_NO_COM_DEBT_COLL(), null, createHelper);
					updateCellPreserveStyle(row, 42, record.getR10_NO_INST_CRE_RATE(), null, createHelper);
					updateCellPreserveStyle(row, 43, record.getR10_NO_CON_DELAY(), null, createHelper);
					updateCellPreserveStyle(row, 44, record.getR10_NO_COM_REP_DTE(), null, createHelper);
					row = sheet.getRow(10);

					updateCellPreserveStyle(row, 5, record.getR11_NO_COM_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR11_NO_COM_PEN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR11_AMT_FIN_AED(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR11_NO_COM_ADV_FEES(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR11_NO_COM_DET_SPC_PT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR11_NO_COM_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR11_NO_COM_AGNT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR11_NO_COM_MISSEL(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR11_NO_COM_FILCOM(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR11_NO_COM_PRO_SER(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR11_NO_ASO_PROD(), null, createHelper);
					updateCellPreserveStyle(row, 16, record.getR11_NO_CON_PHN(), null, createHelper);
					updateCellPreserveStyle(row, 17, record.getR11_NO_CON_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 18, record.getR11_NO_CON_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 19, record.getR11_NO_OUT_UNRES(), null, createHelper);
					updateCellPreserveStyle(row, 20, record.getR11_NO_COM_RES_CON(), null, createHelper);
					updateCellPreserveStyle(row, 21, record.getR11_NO_RES_30_COM(), null, createHelper);
					updateCellPreserveStyle(row, 22, record.getR11_AVG_TME_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 23, record.getR11_NO_COM_STF_MIS(), null, createHelper);
					updateCellPreserveStyle(row, 24, record.getR11_NO_COM_ATM_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 25, record.getR11_NO_COM_FIN_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 26, record.getR11_NO_COM_FAV_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record.getR11_NO_COM_PRV_PER(), null, createHelper);
					updateCellPreserveStyle(row, 28, record.getR11_NO_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 29, record.getR11_NO_STEP_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 30, record.getR11_NO_CUST_LEGAL(), null, createHelper);
					updateCellPreserveStyle(row, 31, record.getR11_NO_COM_FAIL(), null, createHelper);
					updateCellPreserveStyle(row, 32, record.getR11_NO_COM_EXP_CON(), null, createHelper);
					updateCellPreserveStyle(row, 33, record.getR11_NO_COM_SANA(), null, createHelper);
					updateCellPreserveStyle(row, 34, record.getR11_NO_COM_CBUAE_SD(), null, createHelper);
					updateCellPreserveStyle(row, 35, record.getR11_NO_RES_COM_7(), null, createHelper);
					updateCellPreserveStyle(row, 36, record.getR11_NO_RES_COM_15(), null, createHelper);
					updateCellPreserveStyle(row, 37, record.getR11_NO_COM_UPHEL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record.getR11_NO_COM_BNK_STF(), null, createHelper);
					updateCellPreserveStyle(row, 39, record.getR11_NO_COM_INHOU(), null, createHelper);
					updateCellPreserveStyle(row, 40, record.getR11_NO_COM_ACK_TT(), null, createHelper);
					updateCellPreserveStyle(row, 41, record.getR11_NO_COM_DEBT_COLL(), null, createHelper);
					updateCellPreserveStyle(row, 42, record.getR11_NO_INST_CRE_RATE(), null, createHelper);
					updateCellPreserveStyle(row, 43, record.getR11_NO_CON_DELAY(), null, createHelper);
					updateCellPreserveStyle(row, 44, record.getR11_NO_COM_REP_DTE(), null, createHelper);
					row = sheet.getRow(11);

					setMcProgress(progressMap, jobId, 35);

					updateCellPreserveStyle(row, 5, record.getR12_NO_COM_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR12_NO_COM_PEN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR12_AMT_FIN_AED(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR12_NO_COM_ADV_FEES(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR12_NO_COM_DET_SPC_PT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR12_NO_COM_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR12_NO_COM_AGNT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR12_NO_COM_MISSEL(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR12_NO_COM_FILCOM(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR12_NO_COM_PRO_SER(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR12_NO_ASO_PROD(), null, createHelper);
					updateCellPreserveStyle(row, 16, record.getR12_NO_CON_PHN(), null, createHelper);
					updateCellPreserveStyle(row, 17, record.getR12_NO_CON_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 18, record.getR12_NO_CON_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 19, record.getR12_NO_OUT_UNRES(), null, createHelper);
					updateCellPreserveStyle(row, 20, record.getR12_NO_COM_RES_CON(), null, createHelper);
					updateCellPreserveStyle(row, 21, record.getR12_NO_RES_30_COM(), null, createHelper);
					updateCellPreserveStyle(row, 22, record.getR12_AVG_TME_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 23, record.getR12_NO_COM_STF_MIS(), null, createHelper);
					updateCellPreserveStyle(row, 24, record.getR12_NO_COM_ATM_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 25, record.getR12_NO_COM_FIN_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 26, record.getR12_NO_COM_FAV_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record.getR12_NO_COM_PRV_PER(), null, createHelper);
					updateCellPreserveStyle(row, 28, record.getR12_NO_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 29, record.getR12_NO_STEP_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 30, record.getR12_NO_CUST_LEGAL(), null, createHelper);
					updateCellPreserveStyle(row, 31, record.getR12_NO_COM_FAIL(), null, createHelper);
					updateCellPreserveStyle(row, 32, record.getR12_NO_COM_EXP_CON(), null, createHelper);
					updateCellPreserveStyle(row, 33, record.getR12_NO_COM_SANA(), null, createHelper);
					updateCellPreserveStyle(row, 34, record.getR12_NO_COM_CBUAE_SD(), null, createHelper);
					updateCellPreserveStyle(row, 35, record.getR12_NO_RES_COM_7(), null, createHelper);
					updateCellPreserveStyle(row, 36, record.getR12_NO_RES_COM_15(), null, createHelper);
					updateCellPreserveStyle(row, 37, record.getR12_NO_COM_UPHEL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record.getR12_NO_COM_BNK_STF(), null, createHelper);
					updateCellPreserveStyle(row, 39, record.getR12_NO_COM_INHOU(), null, createHelper);
					updateCellPreserveStyle(row, 40, record.getR12_NO_COM_ACK_TT(), null, createHelper);
					updateCellPreserveStyle(row, 41, record.getR12_NO_COM_DEBT_COLL(), null, createHelper);
					updateCellPreserveStyle(row, 42, record.getR12_NO_INST_CRE_RATE(), null, createHelper);
					updateCellPreserveStyle(row, 43, record.getR12_NO_CON_DELAY(), null, createHelper);
					updateCellPreserveStyle(row, 44, record.getR12_NO_COM_REP_DTE(), null, createHelper);
					row = sheet.getRow(12);

					updateCellPreserveStyle(row, 5, record.getR13_NO_COM_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR13_NO_COM_PEN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR13_AMT_FIN_AED(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR13_NO_COM_ADV_FEES(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR13_NO_COM_DET_SPC_PT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR13_NO_COM_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR13_NO_COM_AGNT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR13_NO_COM_MISSEL(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR13_NO_COM_FILCOM(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR13_NO_COM_PRO_SER(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR13_NO_ASO_PROD(), null, createHelper);
					updateCellPreserveStyle(row, 16, record.getR13_NO_CON_PHN(), null, createHelper);
					updateCellPreserveStyle(row, 17, record.getR13_NO_CON_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 18, record.getR13_NO_CON_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 19, record.getR13_NO_OUT_UNRES(), null, createHelper);
					updateCellPreserveStyle(row, 20, record.getR13_NO_COM_RES_CON(), null, createHelper);
					updateCellPreserveStyle(row, 21, record.getR13_NO_RES_30_COM(), null, createHelper);
					updateCellPreserveStyle(row, 22, record.getR13_AVG_TME_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 23, record.getR13_NO_COM_STF_MIS(), null, createHelper);
					updateCellPreserveStyle(row, 24, record.getR13_NO_COM_ATM_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 25, record.getR13_NO_COM_FIN_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 26, record.getR13_NO_COM_FAV_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record.getR13_NO_COM_PRV_PER(), null, createHelper);
					updateCellPreserveStyle(row, 28, record.getR13_NO_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 29, record.getR13_NO_STEP_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 30, record.getR13_NO_CUST_LEGAL(), null, createHelper);
					updateCellPreserveStyle(row, 31, record.getR13_NO_COM_FAIL(), null, createHelper);
					updateCellPreserveStyle(row, 32, record.getR13_NO_COM_EXP_CON(), null, createHelper);
					updateCellPreserveStyle(row, 33, record.getR13_NO_COM_SANA(), null, createHelper);
					updateCellPreserveStyle(row, 34, record.getR13_NO_COM_CBUAE_SD(), null, createHelper);
					updateCellPreserveStyle(row, 35, record.getR13_NO_RES_COM_7(), null, createHelper);
					updateCellPreserveStyle(row, 36, record.getR13_NO_RES_COM_15(), null, createHelper);
					updateCellPreserveStyle(row, 37, record.getR13_NO_COM_UPHEL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record.getR13_NO_COM_BNK_STF(), null, createHelper);
					updateCellPreserveStyle(row, 39, record.getR13_NO_COM_INHOU(), null, createHelper);
					updateCellPreserveStyle(row, 40, record.getR13_NO_COM_ACK_TT(), null, createHelper);
					updateCellPreserveStyle(row, 41, record.getR13_NO_COM_DEBT_COLL(), null, createHelper);
					updateCellPreserveStyle(row, 42, record.getR13_NO_INST_CRE_RATE(), null, createHelper);
					updateCellPreserveStyle(row, 43, record.getR13_NO_CON_DELAY(), null, createHelper);
					updateCellPreserveStyle(row, 44, record.getR13_NO_COM_REP_DTE(), null, createHelper);
					row = sheet.getRow(13);

					setMcProgress(progressMap, jobId, 45);
					updateCellPreserveStyle(row, 5, record.getR14_NO_COM_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR14_NO_COM_PEN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR14_AMT_FIN_AED(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR14_NO_COM_ADV_FEES(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR14_NO_COM_DET_SPC_PT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR14_NO_COM_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR14_NO_COM_AGNT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR14_NO_COM_MISSEL(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR14_NO_COM_FILCOM(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR14_NO_COM_PRO_SER(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR14_NO_ASO_PROD(), null, createHelper);
					updateCellPreserveStyle(row, 16, record.getR14_NO_CON_PHN(), null, createHelper);
					updateCellPreserveStyle(row, 17, record.getR14_NO_CON_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 18, record.getR14_NO_CON_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 19, record.getR14_NO_OUT_UNRES(), null, createHelper);
					updateCellPreserveStyle(row, 20, record.getR14_NO_COM_RES_CON(), null, createHelper);
					updateCellPreserveStyle(row, 21, record.getR14_NO_RES_30_COM(), null, createHelper);
					updateCellPreserveStyle(row, 22, record.getR14_AVG_TME_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 23, record.getR14_NO_COM_STF_MIS(), null, createHelper);
					updateCellPreserveStyle(row, 24, record.getR14_NO_COM_ATM_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 25, record.getR14_NO_COM_FIN_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 26, record.getR14_NO_COM_FAV_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record.getR14_NO_COM_PRV_PER(), null, createHelper);
					updateCellPreserveStyle(row, 28, record.getR14_NO_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 29, record.getR14_NO_STEP_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 30, record.getR14_NO_CUST_LEGAL(), null, createHelper);
					updateCellPreserveStyle(row, 31, record.getR14_NO_COM_FAIL(), null, createHelper);
					updateCellPreserveStyle(row, 32, record.getR14_NO_COM_EXP_CON(), null, createHelper);
					updateCellPreserveStyle(row, 33, record.getR14_NO_COM_SANA(), null, createHelper);
					updateCellPreserveStyle(row, 34, record.getR14_NO_COM_CBUAE_SD(), null, createHelper);
					updateCellPreserveStyle(row, 35, record.getR14_NO_RES_COM_7(), null, createHelper);
					updateCellPreserveStyle(row, 36, record.getR14_NO_RES_COM_15(), null, createHelper);
					updateCellPreserveStyle(row, 37, record.getR14_NO_COM_UPHEL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record.getR14_NO_COM_BNK_STF(), null, createHelper);
					updateCellPreserveStyle(row, 39, record.getR14_NO_COM_INHOU(), null, createHelper);
					updateCellPreserveStyle(row, 40, record.getR14_NO_COM_ACK_TT(), null, createHelper);
					updateCellPreserveStyle(row, 41, record.getR14_NO_COM_DEBT_COLL(), null, createHelper);
					updateCellPreserveStyle(row, 42, record.getR14_NO_INST_CRE_RATE(), null, createHelper);
					updateCellPreserveStyle(row, 43, record.getR14_NO_CON_DELAY(), null, createHelper);
					updateCellPreserveStyle(row, 44, record.getR14_NO_COM_REP_DTE(), null, createHelper);
					row = sheet.getRow(14);

					updateCellPreserveStyle(row, 5, record.getR15_NO_COM_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR15_NO_COM_PEN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR15_AMT_FIN_AED(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR15_NO_COM_ADV_FEES(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR15_NO_COM_DET_SPC_PT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR15_NO_COM_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR15_NO_COM_AGNT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR15_NO_COM_MISSEL(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR15_NO_COM_FILCOM(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR15_NO_COM_PRO_SER(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR15_NO_ASO_PROD(), null, createHelper);
					updateCellPreserveStyle(row, 16, record.getR15_NO_CON_PHN(), null, createHelper);
					updateCellPreserveStyle(row, 17, record.getR15_NO_CON_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 18, record.getR15_NO_CON_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 19, record.getR15_NO_OUT_UNRES(), null, createHelper);
					updateCellPreserveStyle(row, 20, record.getR15_NO_COM_RES_CON(), null, createHelper);
					updateCellPreserveStyle(row, 21, record.getR15_NO_RES_30_COM(), null, createHelper);
					updateCellPreserveStyle(row, 22, record.getR15_AVG_TME_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 23, record.getR15_NO_COM_STF_MIS(), null, createHelper);
					updateCellPreserveStyle(row, 24, record.getR15_NO_COM_ATM_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 25, record.getR15_NO_COM_FIN_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 26, record.getR15_NO_COM_FAV_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record.getR15_NO_COM_PRV_PER(), null, createHelper);
					updateCellPreserveStyle(row, 28, record.getR15_NO_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 29, record.getR15_NO_STEP_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 30, record.getR15_NO_CUST_LEGAL(), null, createHelper);
					updateCellPreserveStyle(row, 31, record.getR15_NO_COM_FAIL(), null, createHelper);
					updateCellPreserveStyle(row, 32, record.getR15_NO_COM_EXP_CON(), null, createHelper);
					updateCellPreserveStyle(row, 33, record.getR15_NO_COM_SANA(), null, createHelper);
					updateCellPreserveStyle(row, 34, record.getR15_NO_COM_CBUAE_SD(), null, createHelper);
					updateCellPreserveStyle(row, 35, record.getR15_NO_RES_COM_7(), null, createHelper);
					updateCellPreserveStyle(row, 36, record.getR15_NO_RES_COM_15(), null, createHelper);
					updateCellPreserveStyle(row, 37, record.getR15_NO_COM_UPHEL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record.getR15_NO_COM_BNK_STF(), null, createHelper);
					updateCellPreserveStyle(row, 39, record.getR15_NO_COM_INHOU(), null, createHelper);
					updateCellPreserveStyle(row, 40, record.getR15_NO_COM_ACK_TT(), null, createHelper);
					updateCellPreserveStyle(row, 41, record.getR15_NO_COM_DEBT_COLL(), null, createHelper);
					updateCellPreserveStyle(row, 42, record.getR15_NO_INST_CRE_RATE(), null, createHelper);
					updateCellPreserveStyle(row, 43, record.getR15_NO_CON_DELAY(), null, createHelper);
					updateCellPreserveStyle(row, 44, record.getR15_NO_COM_REP_DTE(), null, createHelper);
					row = sheet.getRow(15);

					setMcProgress(progressMap, jobId, 55);
					updateCellPreserveStyle(row, 5, record.getR16_NO_COM_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR16_NO_COM_PEN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR16_AMT_FIN_AED(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR16_NO_COM_ADV_FEES(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR16_NO_COM_DET_SPC_PT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR16_NO_COM_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR16_NO_COM_AGNT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR16_NO_COM_MISSEL(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR16_NO_COM_FILCOM(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR16_NO_COM_PRO_SER(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR16_NO_ASO_PROD(), null, createHelper);
					updateCellPreserveStyle(row, 16, record.getR16_NO_CON_PHN(), null, createHelper);
					updateCellPreserveStyle(row, 17, record.getR16_NO_CON_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 18, record.getR16_NO_CON_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 19, record.getR16_NO_OUT_UNRES(), null, createHelper);
					updateCellPreserveStyle(row, 20, record.getR16_NO_COM_RES_CON(), null, createHelper);
					updateCellPreserveStyle(row, 21, record.getR16_NO_RES_30_COM(), null, createHelper);
					updateCellPreserveStyle(row, 22, record.getR16_AVG_TME_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 23, record.getR16_NO_COM_STF_MIS(), null, createHelper);
					updateCellPreserveStyle(row, 24, record.getR16_NO_COM_ATM_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 25, record.getR16_NO_COM_FIN_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 26, record.getR16_NO_COM_FAV_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record.getR16_NO_COM_PRV_PER(), null, createHelper);
					updateCellPreserveStyle(row, 28, record.getR16_NO_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 29, record.getR16_NO_STEP_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 30, record.getR16_NO_CUST_LEGAL(), null, createHelper);
					updateCellPreserveStyle(row, 31, record.getR16_NO_COM_FAIL(), null, createHelper);
					updateCellPreserveStyle(row, 32, record.getR16_NO_COM_EXP_CON(), null, createHelper);
					updateCellPreserveStyle(row, 33, record.getR16_NO_COM_SANA(), null, createHelper);
					updateCellPreserveStyle(row, 34, record.getR16_NO_COM_CBUAE_SD(), null, createHelper);
					updateCellPreserveStyle(row, 35, record.getR16_NO_RES_COM_7(), null, createHelper);
					updateCellPreserveStyle(row, 36, record.getR16_NO_RES_COM_15(), null, createHelper);
					updateCellPreserveStyle(row, 37, record.getR16_NO_COM_UPHEL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record.getR16_NO_COM_BNK_STF(), null, createHelper);
					updateCellPreserveStyle(row, 39, record.getR16_NO_COM_INHOU(), null, createHelper);
					updateCellPreserveStyle(row, 40, record.getR16_NO_COM_ACK_TT(), null, createHelper);
					updateCellPreserveStyle(row, 41, record.getR16_NO_COM_DEBT_COLL(), null, createHelper);
					updateCellPreserveStyle(row, 42, record.getR16_NO_INST_CRE_RATE(), null, createHelper);
					updateCellPreserveStyle(row, 43, record.getR16_NO_CON_DELAY(), null, createHelper);
					updateCellPreserveStyle(row, 44, record.getR16_NO_COM_REP_DTE(), null, createHelper);
					row = sheet.getRow(16);

					updateCellPreserveStyle(row, 5, record.getR17_NO_COM_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR17_NO_COM_PEN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR17_AMT_FIN_AED(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR17_NO_COM_ADV_FEES(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR17_NO_COM_DET_SPC_PT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR17_NO_COM_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR17_NO_COM_AGNT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR17_NO_COM_MISSEL(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR17_NO_COM_FILCOM(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR17_NO_COM_PRO_SER(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR17_NO_ASO_PROD(), null, createHelper);
					updateCellPreserveStyle(row, 16, record.getR17_NO_CON_PHN(), null, createHelper);
					updateCellPreserveStyle(row, 17, record.getR17_NO_CON_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 18, record.getR17_NO_CON_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 19, record.getR17_NO_OUT_UNRES(), null, createHelper);
					updateCellPreserveStyle(row, 20, record.getR17_NO_COM_RES_CON(), null, createHelper);
					updateCellPreserveStyle(row, 21, record.getR17_NO_RES_30_COM(), null, createHelper);
					updateCellPreserveStyle(row, 22, record.getR17_AVG_TME_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 23, record.getR17_NO_COM_STF_MIS(), null, createHelper);
					updateCellPreserveStyle(row, 24, record.getR17_NO_COM_ATM_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 25, record.getR17_NO_COM_FIN_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 26, record.getR17_NO_COM_FAV_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record.getR17_NO_COM_PRV_PER(), null, createHelper);
					updateCellPreserveStyle(row, 28, record.getR17_NO_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 29, record.getR17_NO_STEP_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 30, record.getR17_NO_CUST_LEGAL(), null, createHelper);
					updateCellPreserveStyle(row, 31, record.getR17_NO_COM_FAIL(), null, createHelper);
					updateCellPreserveStyle(row, 32, record.getR17_NO_COM_EXP_CON(), null, createHelper);
					updateCellPreserveStyle(row, 33, record.getR17_NO_COM_SANA(), null, createHelper);
					updateCellPreserveStyle(row, 34, record.getR17_NO_COM_CBUAE_SD(), null, createHelper);
					updateCellPreserveStyle(row, 35, record.getR17_NO_RES_COM_7(), null, createHelper);
					updateCellPreserveStyle(row, 36, record.getR17_NO_RES_COM_15(), null, createHelper);
					updateCellPreserveStyle(row, 37, record.getR17_NO_COM_UPHEL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record.getR17_NO_COM_BNK_STF(), null, createHelper);
					updateCellPreserveStyle(row, 39, record.getR17_NO_COM_INHOU(), null, createHelper);
					updateCellPreserveStyle(row, 40, record.getR17_NO_COM_ACK_TT(), null, createHelper);
					updateCellPreserveStyle(row, 41, record.getR17_NO_COM_DEBT_COLL(), null, createHelper);
					updateCellPreserveStyle(row, 42, record.getR17_NO_INST_CRE_RATE(), null, createHelper);
					updateCellPreserveStyle(row, 43, record.getR17_NO_CON_DELAY(), null, createHelper);
					updateCellPreserveStyle(row, 44, record.getR17_NO_COM_REP_DTE(), null, createHelper);
					row = sheet.getRow(17);

					setMcProgress(progressMap, jobId, 65);
					updateCellPreserveStyle(row, 5, record.getR18_NO_COM_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR18_NO_COM_PEN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR18_AMT_FIN_AED(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR18_NO_COM_ADV_FEES(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR18_NO_COM_DET_SPC_PT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR18_NO_COM_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR18_NO_COM_AGNT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR18_NO_COM_MISSEL(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR18_NO_COM_FILCOM(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR18_NO_COM_PRO_SER(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR18_NO_ASO_PROD(), null, createHelper);
					updateCellPreserveStyle(row, 16, record.getR18_NO_CON_PHN(), null, createHelper);
					updateCellPreserveStyle(row, 17, record.getR18_NO_CON_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 18, record.getR18_NO_CON_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 19, record.getR18_NO_OUT_UNRES(), null, createHelper);
					updateCellPreserveStyle(row, 20, record.getR18_NO_COM_RES_CON(), null, createHelper);
					updateCellPreserveStyle(row, 21, record.getR18_NO_RES_30_COM(), null, createHelper);
					updateCellPreserveStyle(row, 22, record.getR18_AVG_TME_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 23, record.getR18_NO_COM_STF_MIS(), null, createHelper);
					updateCellPreserveStyle(row, 24, record.getR18_NO_COM_ATM_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 25, record.getR18_NO_COM_FIN_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 26, record.getR18_NO_COM_FAV_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record.getR18_NO_COM_PRV_PER(), null, createHelper);
					updateCellPreserveStyle(row, 28, record.getR18_NO_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 29, record.getR18_NO_STEP_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 30, record.getR18_NO_CUST_LEGAL(), null, createHelper);
					updateCellPreserveStyle(row, 31, record.getR18_NO_COM_FAIL(), null, createHelper);
					updateCellPreserveStyle(row, 32, record.getR18_NO_COM_EXP_CON(), null, createHelper);
					updateCellPreserveStyle(row, 33, record.getR18_NO_COM_SANA(), null, createHelper);
					updateCellPreserveStyle(row, 34, record.getR18_NO_COM_CBUAE_SD(), null, createHelper);
					updateCellPreserveStyle(row, 35, record.getR18_NO_RES_COM_7(), null, createHelper);
					updateCellPreserveStyle(row, 36, record.getR18_NO_RES_COM_15(), null, createHelper);
					updateCellPreserveStyle(row, 37, record.getR18_NO_COM_UPHEL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record.getR18_NO_COM_BNK_STF(), null, createHelper);
					updateCellPreserveStyle(row, 39, record.getR18_NO_COM_INHOU(), null, createHelper);
					updateCellPreserveStyle(row, 40, record.getR18_NO_COM_ACK_TT(), null, createHelper);
					updateCellPreserveStyle(row, 41, record.getR18_NO_COM_DEBT_COLL(), null, createHelper);
					updateCellPreserveStyle(row, 42, record.getR18_NO_INST_CRE_RATE(), null, createHelper);
					updateCellPreserveStyle(row, 43, record.getR18_NO_CON_DELAY(), null, createHelper);
					updateCellPreserveStyle(row, 44, record.getR18_NO_COM_REP_DTE(), null, createHelper);
					row = sheet.getRow(18);

					updateCellPreserveStyle(row, 5, record.getR19_NO_COM_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR19_NO_COM_PEN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR19_AMT_FIN_AED(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR19_NO_COM_ADV_FEES(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR19_NO_COM_DET_SPC_PT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR19_NO_COM_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR19_NO_COM_AGNT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR19_NO_COM_MISSEL(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR19_NO_COM_FILCOM(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR19_NO_COM_PRO_SER(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR19_NO_ASO_PROD(), null, createHelper);
					updateCellPreserveStyle(row, 16, record.getR19_NO_CON_PHN(), null, createHelper);
					updateCellPreserveStyle(row, 17, record.getR19_NO_CON_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 18, record.getR19_NO_CON_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 19, record.getR19_NO_OUT_UNRES(), null, createHelper);
					updateCellPreserveStyle(row, 20, record.getR19_NO_COM_RES_CON(), null, createHelper);
					updateCellPreserveStyle(row, 21, record.getR19_NO_RES_30_COM(), null, createHelper);
					updateCellPreserveStyle(row, 22, record.getR19_AVG_TME_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 23, record.getR19_NO_COM_STF_MIS(), null, createHelper);
					updateCellPreserveStyle(row, 24, record.getR19_NO_COM_ATM_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 25, record.getR19_NO_COM_FIN_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 26, record.getR19_NO_COM_FAV_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record.getR19_NO_COM_PRV_PER(), null, createHelper);
					updateCellPreserveStyle(row, 28, record.getR19_NO_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 29, record.getR19_NO_STEP_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 30, record.getR19_NO_CUST_LEGAL(), null, createHelper);
					updateCellPreserveStyle(row, 31, record.getR19_NO_COM_FAIL(), null, createHelper);
					updateCellPreserveStyle(row, 32, record.getR19_NO_COM_EXP_CON(), null, createHelper);
					updateCellPreserveStyle(row, 33, record.getR19_NO_COM_SANA(), null, createHelper);
					updateCellPreserveStyle(row, 34, record.getR19_NO_COM_CBUAE_SD(), null, createHelper);
					updateCellPreserveStyle(row, 35, record.getR19_NO_RES_COM_7(), null, createHelper);
					updateCellPreserveStyle(row, 36, record.getR19_NO_RES_COM_15(), null, createHelper);
					updateCellPreserveStyle(row, 37, record.getR19_NO_COM_UPHEL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record.getR19_NO_COM_BNK_STF(), null, createHelper);
					updateCellPreserveStyle(row, 39, record.getR19_NO_COM_INHOU(), null, createHelper);
					updateCellPreserveStyle(row, 40, record.getR19_NO_COM_ACK_TT(), null, createHelper);
					updateCellPreserveStyle(row, 41, record.getR19_NO_COM_DEBT_COLL(), null, createHelper);
					updateCellPreserveStyle(row, 42, record.getR19_NO_INST_CRE_RATE(), null, createHelper);
					updateCellPreserveStyle(row, 43, record.getR19_NO_CON_DELAY(), null, createHelper);
					updateCellPreserveStyle(row, 44, record.getR19_NO_COM_REP_DTE(), null, createHelper);
					row = sheet.getRow(19);

					setMcProgress(progressMap, jobId, 75);
					updateCellPreserveStyle(row, 5, record.getR20_NO_COM_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR20_NO_COM_PEN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR20_AMT_FIN_AED(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR20_NO_COM_ADV_FEES(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR20_NO_COM_DET_SPC_PT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR20_NO_COM_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR20_NO_COM_AGNT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR20_NO_COM_MISSEL(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR20_NO_COM_FILCOM(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR20_NO_COM_PRO_SER(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR20_NO_ASO_PROD(), null, createHelper);
					updateCellPreserveStyle(row, 16, record.getR20_NO_CON_PHN(), null, createHelper);
					updateCellPreserveStyle(row, 17, record.getR20_NO_CON_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 18, record.getR20_NO_CON_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 19, record.getR20_NO_OUT_UNRES(), null, createHelper);
					updateCellPreserveStyle(row, 20, record.getR20_NO_COM_RES_CON(), null, createHelper);
					updateCellPreserveStyle(row, 21, record.getR20_NO_RES_30_COM(), null, createHelper);
					updateCellPreserveStyle(row, 22, record.getR20_AVG_TME_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 23, record.getR20_NO_COM_STF_MIS(), null, createHelper);
					updateCellPreserveStyle(row, 24, record.getR20_NO_COM_ATM_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 25, record.getR20_NO_COM_FIN_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 26, record.getR20_NO_COM_FAV_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record.getR20_NO_COM_PRV_PER(), null, createHelper);
					updateCellPreserveStyle(row, 28, record.getR20_NO_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 29, record.getR20_NO_STEP_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 30, record.getR20_NO_CUST_LEGAL(), null, createHelper);
					updateCellPreserveStyle(row, 31, record.getR20_NO_COM_FAIL(), null, createHelper);
					updateCellPreserveStyle(row, 32, record.getR20_NO_COM_EXP_CON(), null, createHelper);
					updateCellPreserveStyle(row, 33, record.getR20_NO_COM_SANA(), null, createHelper);
					updateCellPreserveStyle(row, 34, record.getR20_NO_COM_CBUAE_SD(), null, createHelper);
					// updateCellPreserveStyle(row, 35, record.getR20_NO_RES_COM_7(), null,
					// createHelper);
					updateCellPreserveStyle(row, 36, record.getR20_NO_RES_COM_15(), null, createHelper);
					updateCellPreserveStyle(row, 37, record.getR20_NO_COM_UPHEL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record.getR20_NO_COM_BNK_STF(), null, createHelper);
					updateCellPreserveStyle(row, 39, record.getR20_NO_COM_INHOU(), null, createHelper);
					updateCellPreserveStyle(row, 40, record.getR20_NO_COM_ACK_TT(), null, createHelper);
					updateCellPreserveStyle(row, 41, record.getR20_NO_COM_DEBT_COLL(), null, createHelper);
					updateCellPreserveStyle(row, 42, record.getR20_NO_INST_CRE_RATE(), null, createHelper);
					updateCellPreserveStyle(row, 43, record.getR20_NO_CON_DELAY(), null, createHelper);
					updateCellPreserveStyle(row, 44, record.getR20_NO_COM_REP_DTE(), null, createHelper);
					row = sheet.getRow(20);

					updateCellPreserveStyle(row, 5, record.getR21_NO_COM_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR21_NO_COM_PEN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR21_AMT_FIN_AED(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR21_NO_COM_ADV_FEES(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR21_NO_COM_DET_SPC_PT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR21_NO_COM_DEBT(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR21_NO_COM_AGNT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR21_NO_COM_MISSEL(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR21_NO_COM_FILCOM(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR21_NO_COM_PRO_SER(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR21_NO_ASO_PROD(), null, createHelper);
					updateCellPreserveStyle(row, 16, record.getR21_NO_CON_PHN(), null, createHelper);
					updateCellPreserveStyle(row, 17, record.getR21_NO_CON_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 18, record.getR21_NO_CON_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 19, record.getR21_NO_OUT_UNRES(), null, createHelper);
					updateCellPreserveStyle(row, 20, record.getR21_NO_COM_RES_CON(), null, createHelper);
					updateCellPreserveStyle(row, 21, record.getR21_NO_RES_30_COM(), null, createHelper);
					updateCellPreserveStyle(row, 22, record.getR21_AVG_TME_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 23, record.getR21_NO_COM_STF_MIS(), null, createHelper);
					updateCellPreserveStyle(row, 24, record.getR21_NO_COM_ATM_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 25, record.getR21_NO_COM_FIN_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 26, record.getR21_NO_COM_FAV_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 27, record.getR21_NO_COM_PRV_PER(), null, createHelper);
					updateCellPreserveStyle(row, 28, record.getR21_NO_RES_COM(), null, createHelper);
					updateCellPreserveStyle(row, 29, record.getR21_NO_STEP_LOS(), null, createHelper);
					updateCellPreserveStyle(row, 30, record.getR21_NO_CUST_LEGAL(), null, createHelper);
					updateCellPreserveStyle(row, 31, record.getR21_NO_COM_FAIL(), null, createHelper);
					updateCellPreserveStyle(row, 32, record.getR21_NO_COM_EXP_CON(), null, createHelper);
					updateCellPreserveStyle(row, 33, record.getR21_NO_COM_SANA(), null, createHelper);
					updateCellPreserveStyle(row, 34, record.getR21_NO_COM_CBUAE_SD(), null, createHelper);
					updateCellPreserveStyle(row, 35, record.getR21_NO_RES_COM_7(), null, createHelper);
					updateCellPreserveStyle(row, 36, record.getR21_NO_RES_COM_15(), null, createHelper);
					updateCellPreserveStyle(row, 37, record.getR21_NO_COM_UPHEL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record.getR21_NO_COM_BNK_STF(), null, createHelper);
					updateCellPreserveStyle(row, 39, record.getR21_NO_COM_INHOU(), null, createHelper);
					updateCellPreserveStyle(row, 40, record.getR21_NO_COM_ACK_TT(), null, createHelper);
					updateCellPreserveStyle(row, 41, record.getR21_NO_COM_DEBT_COLL(), null, createHelper);
					updateCellPreserveStyle(row, 42, record.getR21_NO_INST_CRE_RATE(), null, createHelper);
					updateCellPreserveStyle(row, 43, record.getR21_NO_CON_DELAY(), null, createHelper);
					updateCellPreserveStyle(row, 44, record.getR21_NO_COM_REP_DTE(), null, createHelper);

					setMcProgress(progressMap, jobId, 85);
					
					row = sheet.getRow(21);
//					updateCellPreserveStyle(row, 5, record.getR22_NO_COM_SPC_TP(), null, createHelper);
//					updateCellPreserveStyle(row, 6, record.getR22_NO_COM_PEN(), null, createHelper);
//					updateCellPreserveStyle(row, 7, record.getR22_AMT_FIN_AED(), null, createHelper);
//					updateCellPreserveStyle(row, 8, record.getR22_NO_COM_ADV_FEES(), null, createHelper);
//					updateCellPreserveStyle(row, 9, record.getR22_NO_COM_DET_SPC_PT(), null, createHelper);
//					updateCellPreserveStyle(row, 10, record.getR22_NO_COM_DEBT(), null, createHelper);
//					updateCellPreserveStyle(row, 11, record.getR22_NO_COM_AGNT(), null, createHelper);
//					updateCellPreserveStyle(row, 12, record.getR22_NO_COM_MISSEL(), null, createHelper);
//					updateCellPreserveStyle(row, 13, record.getR22_NO_COM_FILCOM(), null, createHelper);
//					updateCellPreserveStyle(row, 14, record.getR22_NO_COM_PRO_SER(), null, createHelper);
//					updateCellPreserveStyle(row, 15, record.getR22_NO_ASO_PROD(), null, createHelper);
//					updateCellPreserveStyle(row, 16, record.getR22_NO_CON_PHN(), null, createHelper);
//					updateCellPreserveStyle(row, 17, record.getR22_NO_CON_WEB(), null, createHelper);
//					updateCellPreserveStyle(row, 18, record.getR22_NO_CON_BNK(), null, createHelper);
//					updateCellPreserveStyle(row, 19, record.getR22_NO_OUT_UNRES(), null, createHelper);
//					updateCellPreserveStyle(row, 20, record.getR22_NO_COM_RES_CON(), null, createHelper);
//					updateCellPreserveStyle(row, 21, record.getR22_NO_RES_30_COM(), null, createHelper);
					updateCellPreserveStyle(row, 22, record.getR22_AVG_TME_RES_COM(), null, createHelper);
//					updateCellPreserveStyle(row, 23, record.getR22_NO_COM_STF_MIS(), null, createHelper);
//					updateCellPreserveStyle(row, 24, record.getR22_NO_COM_ATM_WEB(), null, createHelper);
//					updateCellPreserveStyle(row, 25, record.getR22_NO_COM_FIN_LOS(), null, createHelper);
//					updateCellPreserveStyle(row, 26, record.getR22_NO_COM_FAV_LOS(), null, createHelper);
//					updateCellPreserveStyle(row, 27, record.getR22_NO_COM_PRV_PER(), null, createHelper);
//					updateCellPreserveStyle(row, 28, record.getR22_NO_RES_COM(), null, createHelper);
//					updateCellPreserveStyle(row, 29, record.getR22_NO_STEP_LOS(), null, createHelper);
//					updateCellPreserveStyle(row, 30, record.getR22_NO_CUST_LEGAL(), null, createHelper);
//					updateCellPreserveStyle(row, 31, record.getR22_NO_COM_FAIL(), null, createHelper);
//					updateCellPreserveStyle(row, 32, record.getR22_NO_COM_EXP_CON(), null, createHelper);
//					updateCellPreserveStyle(row, 33, record.getR22_NO_COM_SANA(), null, createHelper);
//					updateCellPreserveStyle(row, 34, record.getR22_NO_COM_CBUAE_SD(), null, createHelper);
//					updateCellPreserveStyle(row, 35, record.getR22_NO_RES_COM_7(), null, createHelper);
//					updateCellPreserveStyle(row, 36, record.getR22_NO_RES_COM_15(), null, createHelper);
//					updateCellPreserveStyle(row, 37, record.getR22_NO_COM_UPHEL(), null, createHelper);
//					updateCellPreserveStyle(row, 38, record.getR22_NO_COM_BNK_STF(), null, createHelper);
//					updateCellPreserveStyle(row, 39, record.getR22_NO_COM_INHOU(), null, createHelper);
//					updateCellPreserveStyle(row, 40, record.getR22_NO_COM_ACK_TT(), null, createHelper);
//					updateCellPreserveStyle(row, 41, record.getR22_NO_COM_DEBT_COLL(), null, createHelper);
//					updateCellPreserveStyle(row, 42, record.getR22_NO_INST_CRE_RATE(), null, createHelper);
//					updateCellPreserveStyle(row, 43, record.getR22_NO_CON_DELAY(), null, createHelper);
//					updateCellPreserveStyle(row, 44, record.getR22_NO_COM_REP_DTE(), null, createHelper);

				}
				evaluateMcFormulas(workbook, jobId);
			} else {

			}

		} catch (Exception e) {
			logger.error("MC download jobId={} excel write failed reportDate={} branch={} formmode={}", jobId,
					reportDate, branch, formmode, e);
			throw e;
		}

	}

	public void GenerateTable_4_Excel(Workbook workbook,String branch, String jobId, Map<String, Integer> progressMap, String formmode,
			String reportDate, String isConsolidated, String reportOption, String selectedDepartments) throws Exception {
//		logMcDownload(jobId, "fetching database rows", reportDate, branch, isConsolidated, formmode);
//
//		List<RT_MC_TABLE4_1_ENTITY> dataList1 ;
//		List<RT_MC_TABLE4_2_ENTITY> dataList2 ;
//
//		if (branch =="DEPT" || branch.equals("DEPT")) {
//			dataList1 = RT_MC_TABLE4_1_REPO.findBybranchcode(branch);
//			dataList2 = RT_MC_TABLE4_2_REPO.findBybranchcode(branch);
//		}
//		else {
//			dataList1 = RT_MC_TABLE4_1_REPO.findByReportDateAndBranchCode(reportDate, branch);
//			dataList2 = RT_MC_TABLE4_2_REPO.findByReportDateAndBranchCode(reportDate, branch);
//		}

		logMcDownload(jobId, "fetching database rows", reportDate, branch, isConsolidated, formmode);
	    List<RT_MC_TABLE4_1_ENTITY> dataList1 = new ArrayList<>();
	    List<RT_MC_TABLE4_2_ENTITY> dataList2 = new ArrayList<>();

	    if ("YES".equalsIgnoreCase(isConsolidated)) {
	        
	        List<RT_MC_TABLE4_1_ENTITY> numData1 = RT_MC_TABLE4_1_REPO.findByReportDateAndBranchCode(reportDate, branch);
	        List<RT_MC_TABLE4_1_ENTITY> deptData1 = RT_MC_TABLE4_1_REPO.findBybranchcode("DEPT");
	        List<RT_MC_TABLE4_2_ENTITY> numData2 = RT_MC_TABLE4_2_REPO.findByReportDateAndBranchCode(reportDate, branch);
	        List<RT_MC_TABLE4_2_ENTITY> deptData2 = RT_MC_TABLE4_2_REPO.findBybranchcode("DEPT");
	        dataList1 = mergeReportData(numData1, deptData1, reportOption, selectedDepartments, RT_MC_TABLE4_1_ENTITY.class);
	        dataList2 = mergeReportData(numData2, deptData2, reportOption, selectedDepartments, RT_MC_TABLE4_2_ENTITY.class);
	        
	    } else {
	        if ("DEPT".equals(branch)) {
	        	dataList1 = RT_MC_TABLE4_1_REPO.findBybranchcode(branch);
    			dataList2 = RT_MC_TABLE4_2_REPO.findBybranchcode(branch);
	        } else {
	        	dataList1 = RT_MC_TABLE4_1_REPO.findByReportDateAndBranchCode(reportDate, branch);
				dataList2 = RT_MC_TABLE4_2_REPO.findByReportDateAndBranchCode(reportDate, branch);
	        }
	    }

	    if (dataList1 == null || dataList1.isEmpty() || dataList2 == null || dataList2.isEmpty() ) {
	        logger.warn(
	        		"MC download jobId={} no rows after fetch. list1={} list2={} reportDate={} branch={} formmode={}",
	        		jobId, dataList1 == null ? 0 : dataList1.size(), dataList2 == null ? 0 : dataList2.size(),
	        		reportDate, branch, formmode);
	        return;
	    }
	    logger.info("MC download jobId={} fetched list1={} list2={} rows. Sheet write starts next.", jobId,
	    		dataList1.size(), dataList2.size());
	    
		
		try {

			Sheet sheet = openMcSheet(workbook, jobId, 6);

			// --- Style Definitions ---
			CreationHelper createHelper = workbook.getCreationHelper();

			CellStyle dateStyle = workbook.createCellStyle();
			dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
			dateStyle.setBorderBottom(BorderStyle.THIN);
			dateStyle.setBorderTop(BorderStyle.THIN);
			dateStyle.setBorderLeft(BorderStyle.THIN);
			dateStyle.setBorderRight(BorderStyle.THIN);

			CellStyle textStyle = workbook.createCellStyle();
			textStyle.setBorderBottom(BorderStyle.THIN);
			textStyle.setBorderTop(BorderStyle.THIN);
			textStyle.setBorderLeft(BorderStyle.THIN);
			textStyle.setBorderRight(BorderStyle.THIN);

			// Create the font
			Font font = workbook.createFont();
			font.setFontHeightInPoints((short) 8); // size 8
			font.setFontName("Arial");

			CellStyle numberStyle = workbook.createCellStyle();
			// numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("0.000"));
			numberStyle.setBorderBottom(BorderStyle.THIN);
			numberStyle.setBorderTop(BorderStyle.THIN);
			numberStyle.setBorderLeft(BorderStyle.THIN);
			numberStyle.setBorderRight(BorderStyle.THIN);
			numberStyle.setFont(font);
			// --- End of Style Definitions ---

			int startRow = 5;

			if (!dataList1.isEmpty() && !dataList2.isEmpty()) {
				for (int i = 0; i < dataList1.size(); i++) {
					RT_MC_TABLE4_1_ENTITY record1 = dataList1.get(i);
					RT_MC_TABLE4_2_ENTITY record2 = dataList2.get(i);
					System.out.println("rownumber=" + (startRow + i));
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}
					setMcProgress(progressMap, jobId, 5, "writing row " + (i + 1) + " excelRow " + (startRow + i));

					row = sheet.getRow(5);
					updateCellPreserveStyle(row, 5, record1.getR6_AVG_TME_LWRSK(), null, createHelper);
					updateCellPreserveStyle(row, 6, record1.getR6_AVG_NO_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record1.getR6_AVG_NO_LWRSK_SME(), null, createHelper);
					updateCellPreserveStyle(row, 8, record1.getR6_AVG_NO_DYS_SME(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR6_NO_REQ_CLO(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR6_NO_PRD_VAR_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR6_NO_REQ_RES_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR6_NO_REQ_PAYDEF(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR6_AVG_TME_REPAY(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR6_NO_INST_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR6_NET_FEE_AED(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR6_NET_PROF_AED(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR6_TOT_NO_ACC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR6_TOT_ACCS_DOR(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR6_TOT_NEW_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR6_TOT_VAL_NEWACCS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR6_TOT_NO_LOAN_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR6_TOT_REQ_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 23, record1.getR6_TOT_LOAN_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 24, record1.getR6_NO_CRACC_MIN(), null, createHelper);
					updateCellPreserveStyle(row, 25, record1.getR6_AVG_TME_CLSACC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record1.getR6_N0_CON_MORE1_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 27, record1.getR6_NO_INST_WITH90(), null, createHelper);
					updateCellPreserveStyle(row, 28, record1.getR6_TOT_GROSS_ASET(), null, createHelper);
					updateCellPreserveStyle(row, 29, record1.getR6_RET_LIAB_AED(), null, createHelper);
					updateCellPreserveStyle(row, 30, record1.getR6_HIG_PER_PROD_CAT(), null, createHelper);
					updateCellPreserveStyle(row, 31, record1.getR6_NO_ACCS_TAG_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 32, record1.getR6_NO_CHG_FEE_GRT5(), null, createHelper);
					updateCellPreserveStyle(row, 33, record1.getR6_NO_CON_FLEX_INT(), null, createHelper);
					updateCellPreserveStyle(row, 34, record1.getR6_NO_CON_FIXED_INT(), null, createHelper);
					updateCellPreserveStyle(row, 35, record1.getR6_NO_LOAN_MAY_2011(), null, createHelper);
					updateCellPreserveStyle(row, 36, record1.getR6_VAL_LEGA_MAY_AED(), null, createHelper);
					updateCellPreserveStyle(row, 37, record1.getR6_AVG_DAY_NLL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record1.getR6_PER_DOR_ACCS(), null, createHelper);
					updateCellPreserveStyle(row, 39, record1.getR6_INT_RET_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 40, record1.getR6_FEE_COMM_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 41, record1.getR6_TOT_UNCLM_90(), null, createHelper);
					updateCellPreserveStyle(row, 42, record1.getR6_TOT_VAL_UNBAL(), null, createHelper);
					updateCellPreserveStyle(row, 43, record1.getR6_NO_INST_CONTRACT(), null, createHelper);
					updateCellPreserveStyle(row, 44, record1.getR6_TOT_DORACC_NOTICE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record1.getR6_NO_CONS_LIAB_7DAY(), null, createHelper);
					updateCellPreserveStyle(row, 46, record1.getR6_TOT_REQ_LIAB_NONLIA(), null, createHelper);
					updateCellPreserveStyle(row, 47, record1.getR6_NO_RESTU_ONBO(), null, createHelper);
					// updateCellPreserveStyle(row, 48, record1.getR6_TOT_DELAY_TAT(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 49, record1.getR6_TOT_FND_TRAN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 50, record1.getR6_NO_FUND_RET24(), null, createHelper);
					updateCellPreserveStyle(row, 51, record1.getR6_NO_FAIL_TRAN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR6_CUS_FND_SVF_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR6_CUS_FND_SVF_PRE(), null, createHelper);
					updateCellPreserveStyle(row, 54, record1.getR6_TOT_CRDR_UND_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 55, record1.getR6_TOT_CRD_ISU_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 56, record1.getR6_NO_ACC_BLK_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 57, record1.getR6_NO_INQ_AVL_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR6_TOT_PRE_EXP_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR6_TOT_PRE_POS_EXP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR6_TOT_PRE_CARD_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 61, record1.getR6_TOT_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 62, record1.getR6_NO_LANG_VOICE(), null, createHelper);
					updateCellPreserveStyle(row, 63, record1.getR6_AVG_NOD_LOWRSK(), null, createHelper);
					// updateCellPreserveStyle(row, 64, record1.getR6_NO_CUST_REISS_LIA(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 65, record1.getR6_NO_INS_CRRATE_CON(), null,
					// createHelper);

					row = sheet.getRow(6);
					updateCellPreserveStyle(row, 5, record1.getR7_AVG_TME_LWRSK(), null, createHelper);
					updateCellPreserveStyle(row, 6, record1.getR7_AVG_NO_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record1.getR7_AVG_NO_LWRSK_SME(), null, createHelper);
					updateCellPreserveStyle(row, 8, record1.getR7_AVG_NO_DYS_SME(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR7_NO_REQ_CLO(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR7_NO_PRD_VAR_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR7_NO_REQ_RES_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR7_NO_REQ_PAYDEF(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR7_AVG_TME_REPAY(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR7_NO_INST_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR7_NET_FEE_AED(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR7_NET_PROF_AED(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR7_TOT_NO_ACC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR7_TOT_ACCS_DOR(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR7_TOT_NEW_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR7_TOT_VAL_NEWACCS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR7_TOT_NO_LOAN_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR7_TOT_REQ_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 23, record1.getR7_TOT_LOAN_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 24, record1.getR7_NO_CRACC_MIN(), null, createHelper);
					updateCellPreserveStyle(row, 25, record1.getR7_AVG_TME_CLSACC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record1.getR7_N0_CON_MORE1_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 27, record1.getR7_NO_INST_WITH90(), null, createHelper);
					updateCellPreserveStyle(row, 28, record1.getR7_TOT_GROSS_ASET(), null, createHelper);
					updateCellPreserveStyle(row, 29, record1.getR7_RET_LIAB_AED(), null, createHelper);
					updateCellPreserveStyle(row, 30, record1.getR7_HIG_PER_PROD_CAT(), null, createHelper);
					updateCellPreserveStyle(row, 31, record1.getR7_NO_ACCS_TAG_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 32, record1.getR7_NO_CHG_FEE_GRT5(), null, createHelper);
					updateCellPreserveStyle(row, 33, record1.getR7_NO_CON_FLEX_INT(), null, createHelper);
					updateCellPreserveStyle(row, 34, record1.getR7_NO_CON_FIXED_INT(), null, createHelper);
					updateCellPreserveStyle(row, 35, record1.getR7_NO_LOAN_MAY_2011(), null, createHelper);
					updateCellPreserveStyle(row, 36, record1.getR7_VAL_LEGA_MAY_AED(), null, createHelper);
					updateCellPreserveStyle(row, 37, record1.getR7_AVG_DAY_NLL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record1.getR7_PER_DOR_ACCS(), null, createHelper);
					updateCellPreserveStyle(row, 39, record1.getR7_INT_RET_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 40, record1.getR7_FEE_COMM_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 41, record1.getR7_TOT_UNCLM_90(), null, createHelper);
					updateCellPreserveStyle(row, 42, record1.getR7_TOT_VAL_UNBAL(), null, createHelper);
					updateCellPreserveStyle(row, 43, record1.getR7_NO_INST_CONTRACT(), null, createHelper);
					updateCellPreserveStyle(row, 44, record1.getR7_TOT_DORACC_NOTICE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record1.getR7_NO_CONS_LIAB_7DAY(), null, createHelper);
					updateCellPreserveStyle(row, 46, record1.getR7_TOT_REQ_LIAB_NONLIA(), null, createHelper);
					updateCellPreserveStyle(row, 47, record1.getR7_NO_RESTU_ONBO(), null, createHelper);
					// updateCellPreserveStyle(row, 48, record1.getR7_TOT_DELAY_TAT(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 49, record1.getR7_TOT_FND_TRAN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 50, record1.getR7_NO_FUND_RET24(), null, createHelper);
					updateCellPreserveStyle(row, 51, record1.getR7_NO_FAIL_TRAN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR7_CUS_FND_SVF_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR7_CUS_FND_SVF_PRE(), null, createHelper);
					updateCellPreserveStyle(row, 54, record1.getR7_TOT_CRDR_UND_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 55, record1.getR7_TOT_CRD_ISU_SPT(), null, createHelper);
					// updateCellPreserveStyle(row, 56, record1.getR7_NO_ACC_BLK_FIN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 57, record1.getR7_NO_INQ_AVL_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR7_TOT_PRE_EXP_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR7_TOT_PRE_POS_EXP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR7_TOT_PRE_CARD_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 61, record1.getR7_TOT_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 62, record1.getR7_NO_LANG_VOICE(), null, createHelper);
					updateCellPreserveStyle(row, 63, record1.getR7_AVG_NOD_LOWRSK(), null, createHelper);
					// updateCellPreserveStyle(row, 64, record1.getR7_NO_CUST_REISS_LIA(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 65, record1.getR7_NO_INS_CRRATE_CON(), null,
					// createHelper);

					setMcProgress(progressMap, jobId, 15);
					row = sheet.getRow(7);
					updateCellPreserveStyle(row, 5, record1.getR8_AVG_TME_LWRSK(), null, createHelper);
					updateCellPreserveStyle(row, 6, record1.getR8_AVG_NO_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record1.getR8_AVG_NO_LWRSK_SME(), null, createHelper);
					updateCellPreserveStyle(row, 8, record1.getR8_AVG_NO_DYS_SME(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR8_NO_REQ_CLO(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR8_NO_PRD_VAR_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR8_NO_REQ_RES_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR8_NO_REQ_PAYDEF(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR8_AVG_TME_REPAY(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR8_NO_INST_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR8_NET_FEE_AED(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR8_NET_PROF_AED(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR8_TOT_NO_ACC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR8_TOT_ACCS_DOR(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR8_TOT_NEW_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR8_TOT_VAL_NEWACCS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR8_TOT_NO_LOAN_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR8_TOT_REQ_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 23, record1.getR8_TOT_LOAN_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 24, record1.getR8_NO_CRACC_MIN(), null, createHelper);
					updateCellPreserveStyle(row, 25, record1.getR8_AVG_TME_CLSACC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record1.getR8_N0_CON_MORE1_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 27, record1.getR8_NO_INST_WITH90(), null, createHelper);
					updateCellPreserveStyle(row, 28, record1.getR8_TOT_GROSS_ASET(), null, createHelper);
					updateCellPreserveStyle(row, 29, record1.getR8_RET_LIAB_AED(), null, createHelper);
					updateCellPreserveStyle(row, 30, record1.getR8_HIG_PER_PROD_CAT(), null, createHelper);
					updateCellPreserveStyle(row, 31, record1.getR8_NO_ACCS_TAG_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 32, record1.getR8_NO_CHG_FEE_GRT5(), null, createHelper);
					updateCellPreserveStyle(row, 33, record1.getR8_NO_CON_FLEX_INT(), null, createHelper);
					updateCellPreserveStyle(row, 34, record1.getR8_NO_CON_FIXED_INT(), null, createHelper);
					updateCellPreserveStyle(row, 35, record1.getR8_NO_LOAN_MAY_2011(), null, createHelper);
					updateCellPreserveStyle(row, 36, record1.getR8_VAL_LEGA_MAY_AED(), null, createHelper);
					updateCellPreserveStyle(row, 37, record1.getR8_AVG_DAY_NLL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record1.getR8_PER_DOR_ACCS(), null, createHelper);
					updateCellPreserveStyle(row, 39, record1.getR8_INT_RET_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 40, record1.getR8_FEE_COMM_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 41, record1.getR8_TOT_UNCLM_90(), null, createHelper);
					updateCellPreserveStyle(row, 42, record1.getR8_TOT_VAL_UNBAL(), null, createHelper);
					updateCellPreserveStyle(row, 43, record1.getR8_NO_INST_CONTRACT(), null, createHelper);
					updateCellPreserveStyle(row, 44, record1.getR8_TOT_DORACC_NOTICE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record1.getR8_NO_CONS_LIAB_7DAY(), null, createHelper);
					updateCellPreserveStyle(row, 46, record1.getR8_TOT_REQ_LIAB_NONLIA(), null, createHelper);
					updateCellPreserveStyle(row, 47, record1.getR8_NO_RESTU_ONBO(), null, createHelper);
					// updateCellPreserveStyle(row, 48, record1.getR8_TOT_DELAY_TAT(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 49, record1.getR8_TOT_FND_TRAN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 50, record1.getR8_NO_FUND_RET24(), null, createHelper);
					updateCellPreserveStyle(row, 51, record1.getR8_NO_FAIL_TRAN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR8_CUS_FND_SVF_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR8_CUS_FND_SVF_PRE(), null, createHelper);
					updateCellPreserveStyle(row, 54, record1.getR8_TOT_CRDR_UND_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 55, record1.getR8_TOT_CRD_ISU_SPT(), null, createHelper);
					// updateCellPreserveStyle(row, 56, record1.getR8_NO_ACC_BLK_FIN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 57, record1.getR8_NO_INQ_AVL_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR8_TOT_PRE_EXP_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR8_TOT_PRE_POS_EXP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR8_TOT_PRE_CARD_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 61, record1.getR8_TOT_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 62, record1.getR8_NO_LANG_VOICE(), null, createHelper);
					updateCellPreserveStyle(row, 63, record1.getR8_AVG_NOD_LOWRSK(), null, createHelper);
					// updateCellPreserveStyle(row, 64, record1.getR8_NO_CUST_REISS_LIA(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 65, record1.getR8_NO_INS_CRRATE_CON(), null,
					// createHelper);

					row = sheet.getRow(8);
					updateCellPreserveStyle(row, 5, record1.getR9_AVG_TME_LWRSK(), null, createHelper);
					updateCellPreserveStyle(row, 6, record1.getR9_AVG_NO_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record1.getR9_AVG_NO_LWRSK_SME(), null, createHelper);
					updateCellPreserveStyle(row, 8, record1.getR9_AVG_NO_DYS_SME(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR9_NO_REQ_CLO(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR9_NO_PRD_VAR_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR9_NO_REQ_RES_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR9_NO_REQ_PAYDEF(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR9_AVG_TME_REPAY(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR9_NO_INST_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR9_NET_FEE_AED(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR9_NET_PROF_AED(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR9_TOT_NO_ACC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR9_TOT_ACCS_DOR(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR9_TOT_NEW_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR9_TOT_VAL_NEWACCS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR9_TOT_NO_LOAN_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR9_TOT_REQ_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 23, record1.getR9_TOT_LOAN_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 24, record1.getR9_NO_CRACC_MIN(), null, createHelper);
					updateCellPreserveStyle(row, 25, record1.getR9_AVG_TME_CLSACC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record1.getR9_N0_CON_MORE1_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 27, record1.getR9_NO_INST_WITH90(), null, createHelper);
					updateCellPreserveStyle(row, 28, record1.getR9_TOT_GROSS_ASET(), null, createHelper);
					updateCellPreserveStyle(row, 29, record1.getR9_RET_LIAB_AED(), null, createHelper);
					updateCellPreserveStyle(row, 30, record1.getR9_HIG_PER_PROD_CAT(), null, createHelper);
					updateCellPreserveStyle(row, 31, record1.getR9_NO_ACCS_TAG_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 32, record1.getR9_NO_CHG_FEE_GRT5(), null, createHelper);
					updateCellPreserveStyle(row, 33, record1.getR9_NO_CON_FLEX_INT(), null, createHelper);
					updateCellPreserveStyle(row, 34, record1.getR9_NO_CON_FIXED_INT(), null, createHelper);
					updateCellPreserveStyle(row, 35, record1.getR9_NO_LOAN_MAY_2011(), null, createHelper);
					updateCellPreserveStyle(row, 36, record1.getR9_VAL_LEGA_MAY_AED(), null, createHelper);
					updateCellPreserveStyle(row, 37, record1.getR9_AVG_DAY_NLL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record1.getR9_PER_DOR_ACCS(), null, createHelper);
					updateCellPreserveStyle(row, 39, record1.getR9_INT_RET_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 40, record1.getR9_FEE_COMM_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 41, record1.getR9_TOT_UNCLM_90(), null, createHelper);
					updateCellPreserveStyle(row, 42, record1.getR9_TOT_VAL_UNBAL(), null, createHelper);
					updateCellPreserveStyle(row, 43, record1.getR9_NO_INST_CONTRACT(), null, createHelper);
					updateCellPreserveStyle(row, 44, record1.getR9_TOT_DORACC_NOTICE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record1.getR9_NO_CONS_LIAB_7DAY(), null, createHelper);
					updateCellPreserveStyle(row, 46, record1.getR9_TOT_REQ_LIAB_NONLIA(), null, createHelper);
					updateCellPreserveStyle(row, 47, record1.getR9_NO_RESTU_ONBO(), null, createHelper);
					// updateCellPreserveStyle(row, 48, record1.getR9_TOT_DELAY_TAT(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 49, record1.getR9_TOT_FND_TRAN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 50, record1.getR9_NO_FUND_RET24(), null, createHelper);
					updateCellPreserveStyle(row, 51, record1.getR9_NO_FAIL_TRAN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR9_CUS_FND_SVF_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR9_CUS_FND_SVF_PRE(), null, createHelper);
					updateCellPreserveStyle(row, 54, record1.getR9_TOT_CRDR_UND_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 55, record1.getR9_TOT_CRD_ISU_SPT(), null, createHelper);
					// updateCellPreserveStyle(row, 56, record1.getR9_NO_ACC_BLK_FIN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 57, record1.getR9_NO_INQ_AVL_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR9_TOT_PRE_EXP_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR9_TOT_PRE_POS_EXP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR9_TOT_PRE_CARD_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 61, record1.getR9_TOT_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 62, record1.getR9_NO_LANG_VOICE(), null, createHelper);
					updateCellPreserveStyle(row, 63, record1.getR9_AVG_NOD_LOWRSK(), null, createHelper);
					// updateCellPreserveStyle(row, 64, record1.getR9_NO_CUST_REISS_LIA(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 65, record1.getR9_NO_INS_CRRATE_CON(), null,
					// createHelper);

					setMcProgress(progressMap, jobId, 25);
					row = sheet.getRow(9);
					updateCellPreserveStyle(row, 5, record1.getR10_AVG_TME_LWRSK(), null, createHelper);
					updateCellPreserveStyle(row, 6, record1.getR10_AVG_NO_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record1.getR10_AVG_NO_LWRSK_SME(), null, createHelper);
					updateCellPreserveStyle(row, 8, record1.getR10_AVG_NO_DYS_SME(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR10_NO_REQ_CLO(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR10_NO_PRD_VAR_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR10_NO_REQ_RES_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR10_NO_REQ_PAYDEF(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR10_AVG_TME_REPAY(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR10_NO_INST_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR10_NET_FEE_AED(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR10_NET_PROF_AED(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR10_TOT_NO_ACC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR10_TOT_ACCS_DOR(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR10_TOT_NEW_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR10_TOT_VAL_NEWACCS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR10_TOT_NO_LOAN_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR10_TOT_REQ_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 23, record1.getR10_TOT_LOAN_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 24, record1.getR10_NO_CRACC_MIN(), null, createHelper);
					updateCellPreserveStyle(row, 25, record1.getR10_AVG_TME_CLSACC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record1.getR10_N0_CON_MORE1_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 27, record1.getR10_NO_INST_WITH90(), null, createHelper);
					updateCellPreserveStyle(row, 28, record1.getR10_TOT_GROSS_ASET(), null, createHelper);
					updateCellPreserveStyle(row, 29, record1.getR10_RET_LIAB_AED(), null, createHelper);
					updateCellPreserveStyle(row, 30, record1.getR10_HIG_PER_PROD_CAT(), null, createHelper);
					updateCellPreserveStyle(row, 31, record1.getR10_NO_ACCS_TAG_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 32, record1.getR10_NO_CHG_FEE_GRT5(), null, createHelper);
					updateCellPreserveStyle(row, 33, record1.getR10_NO_CON_FLEX_INT(), null, createHelper);
					updateCellPreserveStyle(row, 34, record1.getR10_NO_CON_FIXED_INT(), null, createHelper);
					updateCellPreserveStyle(row, 35, record1.getR10_NO_LOAN_MAY_2011(), null, createHelper);
					updateCellPreserveStyle(row, 36, record1.getR10_VAL_LEGA_MAY_AED(), null, createHelper);
					updateCellPreserveStyle(row, 37, record1.getR10_AVG_DAY_NLL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record1.getR10_PER_DOR_ACCS(), null, createHelper);
					updateCellPreserveStyle(row, 39, record1.getR10_INT_RET_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 40, record1.getR10_FEE_COMM_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 41, record1.getR10_TOT_UNCLM_90(), null, createHelper);
					updateCellPreserveStyle(row, 42, record1.getR10_TOT_VAL_UNBAL(), null, createHelper);
					updateCellPreserveStyle(row, 43, record1.getR10_NO_INST_CONTRACT(), null, createHelper);
					updateCellPreserveStyle(row, 44, record1.getR10_TOT_DORACC_NOTICE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record1.getR10_NO_CONS_LIAB_7DAY(), null, createHelper);
					updateCellPreserveStyle(row, 46, record1.getR10_TOT_REQ_LIAB_NONLIA(), null, createHelper);
					updateCellPreserveStyle(row, 47, record1.getR10_NO_RESTU_ONBO(), null, createHelper);
					// updateCellPreserveStyle(row, 48, record1.getR10_TOT_DELAY_TAT(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 49, record1.getR10_TOT_FND_TRAN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 50, record1.getR10_NO_FUND_RET24(), null, createHelper);
					updateCellPreserveStyle(row, 51, record1.getR10_NO_FAIL_TRAN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR10_CUS_FND_SVF_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR10_CUS_FND_SVF_PRE(), null, createHelper);
					updateCellPreserveStyle(row, 54, record1.getR10_TOT_CRDR_UND_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 55, record1.getR10_TOT_CRD_ISU_SPT(), null, createHelper);
					// updateCellPreserveStyle(row, 56, record1.getR10_NO_ACC_BLK_FIN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 57, record1.getR10_NO_INQ_AVL_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR10_TOT_PRE_EXP_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR10_TOT_PRE_POS_EXP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR10_TOT_PRE_CARD_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 61, record1.getR10_TOT_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 62, record1.getR10_NO_LANG_VOICE(), null, createHelper);
					updateCellPreserveStyle(row, 63, record1.getR10_AVG_NOD_LOWRSK(), null, createHelper);
					// updateCellPreserveStyle(row, 64, record1.getR10_NO_CUST_REISS_LIA(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 65, record1.getR10_NO_INS_CRRATE_CON(), null,
					// createHelper);

					row = sheet.getRow(10);
					updateCellPreserveStyle(row, 5, record1.getR11_AVG_TME_LWRSK(), null, createHelper);
					updateCellPreserveStyle(row, 6, record1.getR11_AVG_NO_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record1.getR11_AVG_NO_LWRSK_SME(), null, createHelper);
					updateCellPreserveStyle(row, 8, record1.getR11_AVG_NO_DYS_SME(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR11_NO_REQ_CLO(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR11_NO_PRD_VAR_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR11_NO_REQ_RES_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR11_NO_REQ_PAYDEF(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR11_AVG_TME_REPAY(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR11_NO_INST_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR11_NET_FEE_AED(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR11_NET_PROF_AED(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR11_TOT_NO_ACC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR11_TOT_ACCS_DOR(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR11_TOT_NEW_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR11_TOT_VAL_NEWACCS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR11_TOT_NO_LOAN_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR11_TOT_REQ_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 23, record1.getR11_TOT_LOAN_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 24, record1.getR11_NO_CRACC_MIN(), null, createHelper);
					updateCellPreserveStyle(row, 25, record1.getR11_AVG_TME_CLSACC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record1.getR11_N0_CON_MORE1_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 27, record1.getR11_NO_INST_WITH90(), null, createHelper);
					updateCellPreserveStyle(row, 28, record1.getR11_TOT_GROSS_ASET(), null, createHelper);
					updateCellPreserveStyle(row, 29, record1.getR11_RET_LIAB_AED(), null, createHelper);
					updateCellPreserveStyle(row, 30, record1.getR11_HIG_PER_PROD_CAT(), null, createHelper);
					updateCellPreserveStyle(row, 31, record1.getR11_NO_ACCS_TAG_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 32, record1.getR11_NO_CHG_FEE_GRT5(), null, createHelper);
					updateCellPreserveStyle(row, 33, record1.getR11_NO_CON_FLEX_INT(), null, createHelper);
					updateCellPreserveStyle(row, 34, record1.getR11_NO_CON_FIXED_INT(), null, createHelper);
					updateCellPreserveStyle(row, 35, record1.getR11_NO_LOAN_MAY_2011(), null, createHelper);
					updateCellPreserveStyle(row, 36, record1.getR11_VAL_LEGA_MAY_AED(), null, createHelper);
					updateCellPreserveStyle(row, 37, record1.getR11_AVG_DAY_NLL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record1.getR11_PER_DOR_ACCS(), null, createHelper);
					updateCellPreserveStyle(row, 39, record1.getR11_INT_RET_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 40, record1.getR11_FEE_COMM_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 41, record1.getR11_TOT_UNCLM_90(), null, createHelper);
					updateCellPreserveStyle(row, 42, record1.getR11_TOT_VAL_UNBAL(), null, createHelper);
					updateCellPreserveStyle(row, 43, record1.getR11_NO_INST_CONTRACT(), null, createHelper);
					updateCellPreserveStyle(row, 44, record1.getR11_TOT_DORACC_NOTICE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record1.getR11_NO_CONS_LIAB_7DAY(), null, createHelper);
					updateCellPreserveStyle(row, 46, record1.getR11_TOT_REQ_LIAB_NONLIA(), null, createHelper);
					updateCellPreserveStyle(row, 47, record1.getR11_NO_RESTU_ONBO(), null, createHelper);
					// updateCellPreserveStyle(row, 48, record1.getR11_TOT_DELAY_TAT(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 49, record1.getR11_TOT_FND_TRAN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 50, record1.getR11_NO_FUND_RET24(), null, createHelper);
					updateCellPreserveStyle(row, 51, record1.getR11_NO_FAIL_TRAN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR11_CUS_FND_SVF_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR11_CUS_FND_SVF_PRE(), null, createHelper);
					updateCellPreserveStyle(row, 54, record1.getR11_TOT_CRDR_UND_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 55, record1.getR11_TOT_CRD_ISU_SPT(), null, createHelper);
					// updateCellPreserveStyle(row, 56, record1.getR11_NO_ACC_BLK_FIN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 57, record1.getR11_NO_INQ_AVL_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR11_TOT_PRE_EXP_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR11_TOT_PRE_POS_EXP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR11_TOT_PRE_CARD_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 61, record1.getR11_TOT_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 62, record1.getR11_NO_LANG_VOICE(), null, createHelper);
					updateCellPreserveStyle(row, 63, record1.getR11_AVG_NOD_LOWRSK(), null, createHelper);
					// updateCellPreserveStyle(row, 64, record1.getR11_NO_CUST_REISS_LIA(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 65, record1.getR11_NO_INS_CRRATE_CON(), null,
					// createHelper);

					setMcProgress(progressMap, jobId, 35);
					row = sheet.getRow(11);
					updateCellPreserveStyle(row, 5, record1.getR12_AVG_TME_LWRSK(), null, createHelper);
					updateCellPreserveStyle(row, 6, record1.getR12_AVG_NO_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record1.getR12_AVG_NO_LWRSK_SME(), null, createHelper);
					updateCellPreserveStyle(row, 8, record1.getR12_AVG_NO_DYS_SME(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR12_NO_REQ_CLO(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR12_NO_PRD_VAR_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR12_NO_REQ_RES_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR12_NO_REQ_PAYDEF(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR12_AVG_TME_REPAY(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR12_NO_INST_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR12_NET_FEE_AED(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR12_NET_PROF_AED(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR12_TOT_NO_ACC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR12_TOT_ACCS_DOR(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR12_TOT_NEW_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR12_TOT_VAL_NEWACCS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR12_TOT_NO_LOAN_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR12_TOT_REQ_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 23, record1.getR12_TOT_LOAN_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 24, record1.getR12_NO_CRACC_MIN(), null, createHelper);
					updateCellPreserveStyle(row, 25, record1.getR12_AVG_TME_CLSACC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record1.getR12_N0_CON_MORE1_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 27, record1.getR12_NO_INST_WITH90(), null, createHelper);
					updateCellPreserveStyle(row, 28, record1.getR12_TOT_GROSS_ASET(), null, createHelper);
					updateCellPreserveStyle(row, 29, record1.getR12_RET_LIAB_AED(), null, createHelper);
					updateCellPreserveStyle(row, 30, record1.getR12_HIG_PER_PROD_CAT(), null, createHelper);
					updateCellPreserveStyle(row, 31, record1.getR12_NO_ACCS_TAG_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 32, record1.getR12_NO_CHG_FEE_GRT5(), null, createHelper);
					updateCellPreserveStyle(row, 33, record1.getR12_NO_CON_FLEX_INT(), null, createHelper);
					updateCellPreserveStyle(row, 34, record1.getR12_NO_CON_FIXED_INT(), null, createHelper);
					updateCellPreserveStyle(row, 35, record1.getR12_NO_LOAN_MAY_2011(), null, createHelper);
					updateCellPreserveStyle(row, 36, record1.getR12_VAL_LEGA_MAY_AED(), null, createHelper);
					updateCellPreserveStyle(row, 37, record1.getR12_AVG_DAY_NLL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record1.getR12_PER_DOR_ACCS(), null, createHelper);
					updateCellPreserveStyle(row, 39, record1.getR12_INT_RET_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 40, record1.getR12_FEE_COMM_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 41, record1.getR12_TOT_UNCLM_90(), null, createHelper);
					updateCellPreserveStyle(row, 42, record1.getR12_TOT_VAL_UNBAL(), null, createHelper);
					updateCellPreserveStyle(row, 43, record1.getR12_NO_INST_CONTRACT(), null, createHelper);
					updateCellPreserveStyle(row, 44, record1.getR12_TOT_DORACC_NOTICE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record1.getR12_NO_CONS_LIAB_7DAY(), null, createHelper);
					updateCellPreserveStyle(row, 46, record1.getR12_TOT_REQ_LIAB_NONLIA(), null, createHelper);
					updateCellPreserveStyle(row, 47, record1.getR12_NO_RESTU_ONBO(), null, createHelper);
					// updateCellPreserveStyle(row, 48, record1.getR12_TOT_DELAY_TAT(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 49, record1.getR12_TOT_FND_TRAN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 50, record1.getR12_NO_FUND_RET24(), null, createHelper);
					updateCellPreserveStyle(row, 51, record1.getR12_NO_FAIL_TRAN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR12_CUS_FND_SVF_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR12_CUS_FND_SVF_PRE(), null, createHelper);
					updateCellPreserveStyle(row, 54, record1.getR12_TOT_CRDR_UND_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 55, record1.getR12_TOT_CRD_ISU_SPT(), null, createHelper);
					// updateCellPreserveStyle(row, 56, record1.getR12_NO_ACC_BLK_FIN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 57, record1.getR12_NO_INQ_AVL_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR12_TOT_PRE_EXP_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR12_TOT_PRE_POS_EXP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR12_TOT_PRE_CARD_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 61, record1.getR12_TOT_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 62, record1.getR12_NO_LANG_VOICE(), null, createHelper);
					updateCellPreserveStyle(row, 63, record1.getR12_AVG_NOD_LOWRSK(), null, createHelper);
					// updateCellPreserveStyle(row, 64, record1.getR12_NO_CUST_REISS_LIA(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 65, record1.getR12_NO_INS_CRRATE_CON(), null,
					// createHelper);
					row = sheet.getRow(12);
					updateCellPreserveStyle(row, 5, record1.getR13_AVG_TME_LWRSK(), null, createHelper);
					updateCellPreserveStyle(row, 6, record1.getR13_AVG_NO_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record1.getR13_AVG_NO_LWRSK_SME(), null, createHelper);
					updateCellPreserveStyle(row, 8, record1.getR13_AVG_NO_DYS_SME(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR13_NO_REQ_CLO(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR13_NO_PRD_VAR_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR13_NO_REQ_RES_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR13_NO_REQ_PAYDEF(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR13_AVG_TME_REPAY(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR13_NO_INST_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR13_NET_FEE_AED(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR13_NET_PROF_AED(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR13_TOT_NO_ACC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR13_TOT_ACCS_DOR(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR13_TOT_NEW_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR13_TOT_VAL_NEWACCS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR13_TOT_NO_LOAN_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR13_TOT_REQ_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 23, record1.getR13_TOT_LOAN_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 24, record1.getR13_NO_CRACC_MIN(), null, createHelper);
					updateCellPreserveStyle(row, 25, record1.getR13_AVG_TME_CLSACC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record1.getR13_N0_CON_MORE1_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 27, record1.getR13_NO_INST_WITH90(), null, createHelper);
					updateCellPreserveStyle(row, 28, record1.getR13_TOT_GROSS_ASET(), null, createHelper);
					updateCellPreserveStyle(row, 29, record1.getR13_RET_LIAB_AED(), null, createHelper);
					updateCellPreserveStyle(row, 30, record1.getR13_HIG_PER_PROD_CAT(), null, createHelper);
					updateCellPreserveStyle(row, 31, record1.getR13_NO_ACCS_TAG_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 32, record1.getR13_NO_CHG_FEE_GRT5(), null, createHelper);
					updateCellPreserveStyle(row, 33, record1.getR13_NO_CON_FLEX_INT(), null, createHelper);
					updateCellPreserveStyle(row, 34, record1.getR13_NO_CON_FIXED_INT(), null, createHelper);
					updateCellPreserveStyle(row, 35, record1.getR13_NO_LOAN_MAY_2011(), null, createHelper);
					updateCellPreserveStyle(row, 36, record1.getR13_VAL_LEGA_MAY_AED(), null, createHelper);
					updateCellPreserveStyle(row, 37, record1.getR13_AVG_DAY_NLL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record1.getR13_PER_DOR_ACCS(), null, createHelper);
					updateCellPreserveStyle(row, 39, record1.getR13_INT_RET_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 40, record1.getR13_FEE_COMM_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 41, record1.getR13_TOT_UNCLM_90(), null, createHelper);
					updateCellPreserveStyle(row, 42, record1.getR13_TOT_VAL_UNBAL(), null, createHelper);
					updateCellPreserveStyle(row, 43, record1.getR13_NO_INST_CONTRACT(), null, createHelper);
					updateCellPreserveStyle(row, 44, record1.getR13_TOT_DORACC_NOTICE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record1.getR13_NO_CONS_LIAB_7DAY(), null, createHelper);
					updateCellPreserveStyle(row, 46, record1.getR13_TOT_REQ_LIAB_NONLIA(), null, createHelper);
					updateCellPreserveStyle(row, 47, record1.getR13_NO_RESTU_ONBO(), null, createHelper);
					// updateCellPreserveStyle(row, 48, record1.getR13_TOT_DELAY_TAT(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 49, record1.getR13_TOT_FND_TRAN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 50, record1.getR13_NO_FUND_RET24(), null, createHelper);
					updateCellPreserveStyle(row, 51, record1.getR13_NO_FAIL_TRAN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR13_CUS_FND_SVF_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR13_CUS_FND_SVF_PRE(), null, createHelper);
					updateCellPreserveStyle(row, 54, record1.getR13_TOT_CRDR_UND_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 55, record1.getR13_TOT_CRD_ISU_SPT(), null, createHelper);
					// updateCellPreserveStyle(row, 56, record1.getR13_NO_ACC_BLK_FIN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 57, record1.getR13_NO_INQ_AVL_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR13_TOT_PRE_EXP_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR13_TOT_PRE_POS_EXP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR13_TOT_PRE_CARD_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 61, record1.getR13_TOT_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 62, record1.getR13_NO_LANG_VOICE(), null, createHelper);
					updateCellPreserveStyle(row, 63, record1.getR13_AVG_NOD_LOWRSK(), null, createHelper);
					// updateCellPreserveStyle(row, 64, record1.getR13_NO_CUST_REISS_LIA(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 65, record1.getR13_NO_INS_CRRATE_CON(), null,
					// createHelper);
					row = sheet.getRow(13);

					setMcProgress(progressMap, jobId, 45);
					updateCellPreserveStyle(row, 5, record1.getR14_AVG_TME_LWRSK(), null, createHelper);
					updateCellPreserveStyle(row, 6, record1.getR14_AVG_NO_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record1.getR14_AVG_NO_LWRSK_SME(), null, createHelper);
					updateCellPreserveStyle(row, 8, record1.getR14_AVG_NO_DYS_SME(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR14_NO_REQ_CLO(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR14_NO_PRD_VAR_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR14_NO_REQ_RES_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR14_NO_REQ_PAYDEF(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR14_AVG_TME_REPAY(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR14_NO_INST_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR14_NET_FEE_AED(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR14_NET_PROF_AED(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR14_TOT_NO_ACC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR14_TOT_ACCS_DOR(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR14_TOT_NEW_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR14_TOT_VAL_NEWACCS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR14_TOT_NO_LOAN_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR14_TOT_REQ_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 23, record1.getR14_TOT_LOAN_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 24, record1.getR14_NO_CRACC_MIN(), null, createHelper);
					updateCellPreserveStyle(row, 25, record1.getR14_AVG_TME_CLSACC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record1.getR14_N0_CON_MORE1_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 27, record1.getR14_NO_INST_WITH90(), null, createHelper);
					updateCellPreserveStyle(row, 28, record1.getR14_TOT_GROSS_ASET(), null, createHelper);
					updateCellPreserveStyle(row, 29, record1.getR14_RET_LIAB_AED(), null, createHelper);
					updateCellPreserveStyle(row, 30, record1.getR14_HIG_PER_PROD_CAT(), null, createHelper);
					updateCellPreserveStyle(row, 31, record1.getR14_NO_ACCS_TAG_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 32, record1.getR14_NO_CHG_FEE_GRT5(), null, createHelper);
					updateCellPreserveStyle(row, 33, record1.getR14_NO_CON_FLEX_INT(), null, createHelper);
					updateCellPreserveStyle(row, 34, record1.getR14_NO_CON_FIXED_INT(), null, createHelper);
					updateCellPreserveStyle(row, 35, record1.getR14_NO_LOAN_MAY_2011(), null, createHelper);
					updateCellPreserveStyle(row, 36, record1.getR14_VAL_LEGA_MAY_AED(), null, createHelper);
					updateCellPreserveStyle(row, 37, record1.getR14_AVG_DAY_NLL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record1.getR14_PER_DOR_ACCS(), null, createHelper);
					updateCellPreserveStyle(row, 39, record1.getR14_INT_RET_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 40, record1.getR14_FEE_COMM_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 41, record1.getR14_TOT_UNCLM_90(), null, createHelper);
					updateCellPreserveStyle(row, 42, record1.getR14_TOT_VAL_UNBAL(), null, createHelper);
					updateCellPreserveStyle(row, 43, record1.getR14_NO_INST_CONTRACT(), null, createHelper);
					updateCellPreserveStyle(row, 44, record1.getR14_TOT_DORACC_NOTICE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record1.getR14_NO_CONS_LIAB_7DAY(), null, createHelper);
					updateCellPreserveStyle(row, 46, record1.getR14_TOT_REQ_LIAB_NONLIA(), null, createHelper);
					updateCellPreserveStyle(row, 47, record1.getR14_NO_RESTU_ONBO(), null, createHelper);
					// updateCellPreserveStyle(row, 48, record1.getR14_TOT_DELAY_TAT(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 49, record1.getR14_TOT_FND_TRAN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 50, record1.getR14_NO_FUND_RET24(), null, createHelper);
					updateCellPreserveStyle(row, 51, record1.getR14_NO_FAIL_TRAN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR14_CUS_FND_SVF_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR14_CUS_FND_SVF_PRE(), null, createHelper);
					updateCellPreserveStyle(row, 54, record1.getR14_TOT_CRDR_UND_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 55, record1.getR14_TOT_CRD_ISU_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 56, record1.getR14_NO_ACC_BLK_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 57, record1.getR14_NO_INQ_AVL_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR14_TOT_PRE_EXP_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR14_TOT_PRE_POS_EXP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR14_TOT_PRE_CARD_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 61, record1.getR14_TOT_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 62, record1.getR14_NO_LANG_VOICE(), null, createHelper);
					updateCellPreserveStyle(row, 63, record1.getR14_AVG_NOD_LOWRSK(), null, createHelper);
					// updateCellPreserveStyle(row, 64, record1.getR14_NO_CUST_REISS_LIA(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 65, record1.getR14_NO_INS_CRRATE_CON(), null,
					// createHelper);

					row = sheet.getRow(14);

					updateCellPreserveStyle(row, 5, record2.getR15_AVG_TME_LWRSK(), null, createHelper);
					updateCellPreserveStyle(row, 6, record2.getR15_AVG_NO_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record2.getR15_AVG_NO_LWRSK_SME(), null, createHelper);
					updateCellPreserveStyle(row, 8, record2.getR15_AVG_NO_DYS_SME(), null, createHelper);
					updateCellPreserveStyle(row, 9, record2.getR15_NO_REQ_CLO(), null, createHelper);
					updateCellPreserveStyle(row, 10, record2.getR15_NO_PRD_VAR_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 11, record2.getR15_NO_REQ_RES_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record2.getR15_NO_REQ_PAYDEF(), null, createHelper);
					updateCellPreserveStyle(row, 13, record2.getR15_AVG_TME_REPAY(), null, createHelper);
					updateCellPreserveStyle(row, 14, record2.getR15_NO_INST_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 15, record2.getR15_NET_FEE_AED(), null, createHelper);
					updateCellPreserveStyle(row, 16, record2.getR15_NET_PROF_AED(), null, createHelper);
					updateCellPreserveStyle(row, 17, record2.getR15_TOT_NO_ACC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record2.getR15_TOT_ACCS_DOR(), null, createHelper);
					updateCellPreserveStyle(row, 19, record2.getR15_TOT_NEW_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 20, record2.getR15_TOT_VAL_NEWACCS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 21, record2.getR15_TOT_NO_LOAN_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 22, record2.getR15_TOT_REQ_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 23, record2.getR15_TOT_LOAN_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 24, record2.getR15_NO_CRACC_MIN(), null, createHelper);
					updateCellPreserveStyle(row, 25, record2.getR15_AVG_TME_CLSACC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record2.getR15_N0_CON_MORE1_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 27, record2.getR15_NO_INST_WITH90(), null, createHelper);
					updateCellPreserveStyle(row, 28, record2.getR15_TOT_GROSS_ASET(), null, createHelper);
					updateCellPreserveStyle(row, 29, record2.getR15_RET_LIAB_AED(), null, createHelper);
					updateCellPreserveStyle(row, 30, record2.getR15_HIG_PER_PROD_CAT(), null, createHelper);
					updateCellPreserveStyle(row, 31, record2.getR15_NO_ACCS_TAG_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 32, record2.getR15_NO_CHG_FEE_GRT5(), null, createHelper);
					updateCellPreserveStyle(row, 33, record2.getR15_NO_CON_FLEX_INT(), null, createHelper);
					updateCellPreserveStyle(row, 34, record2.getR15_NO_CON_FIXED_INT(), null, createHelper);
					updateCellPreserveStyle(row, 35, record2.getR15_NO_LOAN_MAY_2011(), null, createHelper);
					updateCellPreserveStyle(row, 36, record2.getR15_VAL_LEGA_MAY_AED(), null, createHelper);
					updateCellPreserveStyle(row, 37, record2.getR15_AVG_DAY_NLL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record2.getR15_PER_DOR_ACCS(), null, createHelper);
					updateCellPreserveStyle(row, 39, record2.getR15_INT_RET_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 40, record2.getR15_FEE_COMM_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 41, record2.getR15_TOT_UNCLM_90(), null, createHelper);
					updateCellPreserveStyle(row, 42, record2.getR15_TOT_VAL_UNBAL(), null, createHelper);
					updateCellPreserveStyle(row, 43, record2.getR15_NO_INST_CONTRACT(), null, createHelper);
					updateCellPreserveStyle(row, 44, record2.getR15_TOT_DORACC_NOTICE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record2.getR15_NO_CONS_LIAB_7DAY(), null, createHelper);
					updateCellPreserveStyle(row, 46, record2.getR15_TOT_REQ_LIAB_NONLIA(), null, createHelper);
					updateCellPreserveStyle(row, 47, record2.getR15_NO_RESTU_ONBO(), null, createHelper);
					// updateCellPreserveStyle(row, 48, record2.getR15_TOT_DELAY_TAT(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 49, record2.getR15_TOT_FND_TRAN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 50, record2.getR15_NO_FUND_RET24(), null, createHelper);
					updateCellPreserveStyle(row, 51, record2.getR15_NO_FAIL_TRAN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record2.getR15_CUS_FND_SVF_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 53, record2.getR15_CUS_FND_SVF_PRE(), null, createHelper);
					updateCellPreserveStyle(row, 54, record2.getR15_TOT_CRDR_UND_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 55, record2.getR15_TOT_CRD_ISU_SPT(), null, createHelper);
					// updateCellPreserveStyle(row, 56, record2.getR15_NO_ACC_BLK_FIN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 57, record2.getR15_NO_INQ_AVL_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 58, record2.getR15_TOT_PRE_EXP_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 59, record2.getR15_TOT_PRE_POS_EXP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record2.getR15_TOT_PRE_CARD_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 61, record2.getR15_TOT_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 62, record2.getR15_NO_LANG_VOICE(), null, createHelper);
					updateCellPreserveStyle(row, 63, record2.getR15_AVG_NOD_LOWRSK(), null, createHelper);
					// updateCellPreserveStyle(row, 64, record2.getR15_NO_CUST_REISS_LIA(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 65, record2.getR15_NO_INS_CRRATE_CON(), null,
					// createHelper);

					setMcProgress(progressMap, jobId, 55);
					row = sheet.getRow(15);
					updateCellPreserveStyle(row, 5, record2.getR16_AVG_TME_LWRSK(), null, createHelper);
					updateCellPreserveStyle(row, 6, record2.getR16_AVG_NO_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record2.getR16_AVG_NO_LWRSK_SME(), null, createHelper);
					updateCellPreserveStyle(row, 8, record2.getR16_AVG_NO_DYS_SME(), null, createHelper);
					updateCellPreserveStyle(row, 9, record2.getR16_NO_REQ_CLO(), null, createHelper);
					updateCellPreserveStyle(row, 10, record2.getR16_NO_PRD_VAR_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 11, record2.getR16_NO_REQ_RES_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record2.getR16_NO_REQ_PAYDEF(), null, createHelper);
					updateCellPreserveStyle(row, 13, record2.getR16_AVG_TME_REPAY(), null, createHelper);
					updateCellPreserveStyle(row, 14, record2.getR16_NO_INST_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 15, record2.getR16_NET_FEE_AED(), null, createHelper);
					updateCellPreserveStyle(row, 16, record2.getR16_NET_PROF_AED(), null, createHelper);
					updateCellPreserveStyle(row, 17, record2.getR16_TOT_NO_ACC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record2.getR16_TOT_ACCS_DOR(), null, createHelper);
					updateCellPreserveStyle(row, 19, record2.getR16_TOT_NEW_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 20, record2.getR16_TOT_VAL_NEWACCS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 21, record2.getR16_TOT_NO_LOAN_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 22, record2.getR16_TOT_REQ_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 23, record2.getR16_TOT_LOAN_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 24, record2.getR16_NO_CRACC_MIN(), null, createHelper);
					updateCellPreserveStyle(row, 25, record2.getR16_AVG_TME_CLSACC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record2.getR16_N0_CON_MORE1_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 27, record2.getR16_NO_INST_WITH90(), null, createHelper);
					updateCellPreserveStyle(row, 28, record2.getR16_TOT_GROSS_ASET(), null, createHelper);
					updateCellPreserveStyle(row, 29, record2.getR16_RET_LIAB_AED(), null, createHelper);
					updateCellPreserveStyle(row, 30, record2.getR16_HIG_PER_PROD_CAT(), null, createHelper);
					updateCellPreserveStyle(row, 31, record2.getR16_NO_ACCS_TAG_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 32, record2.getR16_NO_CHG_FEE_GRT5(), null, createHelper);
					updateCellPreserveStyle(row, 33, record2.getR16_NO_CON_FLEX_INT(), null, createHelper);
					updateCellPreserveStyle(row, 34, record2.getR16_NO_CON_FIXED_INT(), null, createHelper);
					updateCellPreserveStyle(row, 35, record2.getR16_NO_LOAN_MAY_2011(), null, createHelper);
					updateCellPreserveStyle(row, 36, record2.getR16_VAL_LEGA_MAY_AED(), null, createHelper);
					updateCellPreserveStyle(row, 37, record2.getR16_AVG_DAY_NLL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record2.getR16_PER_DOR_ACCS(), null, createHelper);
					updateCellPreserveStyle(row, 39, record2.getR16_INT_RET_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 40, record2.getR16_FEE_COMM_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 41, record2.getR16_TOT_UNCLM_90(), null, createHelper);
					updateCellPreserveStyle(row, 42, record2.getR16_TOT_VAL_UNBAL(), null, createHelper);
					updateCellPreserveStyle(row, 43, record2.getR16_NO_INST_CONTRACT(), null, createHelper);
					updateCellPreserveStyle(row, 44, record2.getR16_TOT_DORACC_NOTICE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record2.getR16_NO_CONS_LIAB_7DAY(), null, createHelper);
					updateCellPreserveStyle(row, 46, record2.getR16_TOT_REQ_LIAB_NONLIA(), null, createHelper);
					updateCellPreserveStyle(row, 47, record2.getR16_NO_RESTU_ONBO(), null, createHelper);
					// updateCellPreserveStyle(row, 48, record2.getR16_TOT_DELAY_TAT(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 49, record2.getR16_TOT_FND_TRAN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 50, record2.getR16_NO_FUND_RET24(), null, createHelper);
					updateCellPreserveStyle(row, 51, record2.getR16_NO_FAIL_TRAN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record2.getR16_CUS_FND_SVF_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 53, record2.getR16_CUS_FND_SVF_PRE(), null, createHelper);
					updateCellPreserveStyle(row, 54, record2.getR16_TOT_CRDR_UND_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 55, record2.getR16_TOT_CRD_ISU_SPT(), null, createHelper);
					// updateCellPreserveStyle(row, 56, record2.getR16_NO_ACC_BLK_FIN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 57, record2.getR16_NO_INQ_AVL_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 58, record2.getR16_TOT_PRE_EXP_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 59, record2.getR16_TOT_PRE_POS_EXP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record2.getR16_TOT_PRE_CARD_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 61, record2.getR16_TOT_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 62, record2.getR16_NO_LANG_VOICE(), null, createHelper);
					updateCellPreserveStyle(row, 63, record2.getR16_AVG_NOD_LOWRSK(), null, createHelper);
					// updateCellPreserveStyle(row, 64, record2.getR16_NO_CUST_REISS_LIA(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 65, record2.getR16_NO_INS_CRRATE_CON(), null,
					// createHelper);

					row = sheet.getRow(16);
					updateCellPreserveStyle(row, 5, record2.getR17_AVG_TME_LWRSK(), null, createHelper);
					updateCellPreserveStyle(row, 6, record2.getR17_AVG_NO_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record2.getR17_AVG_NO_LWRSK_SME(), null, createHelper);
					updateCellPreserveStyle(row, 8, record2.getR17_AVG_NO_DYS_SME(), null, createHelper);
					updateCellPreserveStyle(row, 9, record2.getR17_NO_REQ_CLO(), null, createHelper);
					updateCellPreserveStyle(row, 10, record2.getR17_NO_PRD_VAR_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 11, record2.getR17_NO_REQ_RES_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record2.getR17_NO_REQ_PAYDEF(), null, createHelper);
					updateCellPreserveStyle(row, 13, record2.getR17_AVG_TME_REPAY(), null, createHelper);
					updateCellPreserveStyle(row, 14, record2.getR17_NO_INST_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 15, record2.getR17_NET_FEE_AED(), null, createHelper);
					updateCellPreserveStyle(row, 16, record2.getR17_NET_PROF_AED(), null, createHelper);
					updateCellPreserveStyle(row, 17, record2.getR17_TOT_NO_ACC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record2.getR17_TOT_ACCS_DOR(), null, createHelper);
					updateCellPreserveStyle(row, 19, record2.getR17_TOT_NEW_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 20, record2.getR17_TOT_VAL_NEWACCS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 21, record2.getR17_TOT_NO_LOAN_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 22, record2.getR17_TOT_REQ_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 23, record2.getR17_TOT_LOAN_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 24, record2.getR17_NO_CRACC_MIN(), null, createHelper);
					updateCellPreserveStyle(row, 25, record2.getR17_AVG_TME_CLSACC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record2.getR17_N0_CON_MORE1_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 27, record2.getR17_NO_INST_WITH90(), null, createHelper);
					updateCellPreserveStyle(row, 28, record2.getR17_TOT_GROSS_ASET(), null, createHelper);
					updateCellPreserveStyle(row, 29, record2.getR17_RET_LIAB_AED(), null, createHelper);
					updateCellPreserveStyle(row, 30, record2.getR17_HIG_PER_PROD_CAT(), null, createHelper);
					updateCellPreserveStyle(row, 31, record2.getR17_NO_ACCS_TAG_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 32, record2.getR17_NO_CHG_FEE_GRT5(), null, createHelper);
					updateCellPreserveStyle(row, 33, record2.getR17_NO_CON_FLEX_INT(), null, createHelper);
					updateCellPreserveStyle(row, 34, record2.getR17_NO_CON_FIXED_INT(), null, createHelper);
					updateCellPreserveStyle(row, 35, record2.getR17_NO_LOAN_MAY_2011(), null, createHelper);
					updateCellPreserveStyle(row, 36, record2.getR17_VAL_LEGA_MAY_AED(), null, createHelper);
					updateCellPreserveStyle(row, 37, record2.getR17_AVG_DAY_NLL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record2.getR17_PER_DOR_ACCS(), null, createHelper);
					updateCellPreserveStyle(row, 39, record2.getR17_INT_RET_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 40, record2.getR17_FEE_COMM_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 41, record2.getR17_TOT_UNCLM_90(), null, createHelper);
					updateCellPreserveStyle(row, 42, record2.getR17_TOT_VAL_UNBAL(), null, createHelper);
					updateCellPreserveStyle(row, 43, record2.getR17_NO_INST_CONTRACT(), null, createHelper);
					updateCellPreserveStyle(row, 44, record2.getR17_TOT_DORACC_NOTICE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record2.getR17_NO_CONS_LIAB_7DAY(), null, createHelper);
					updateCellPreserveStyle(row, 46, record2.getR17_TOT_REQ_LIAB_NONLIA(), null, createHelper);
					updateCellPreserveStyle(row, 47, record2.getR17_NO_RESTU_ONBO(), null, createHelper);
					// updateCellPreserveStyle(row, 48, record2.getR17_TOT_DELAY_TAT(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 49, record2.getR17_TOT_FND_TRAN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 50, record2.getR17_NO_FUND_RET24(), null, createHelper);
					updateCellPreserveStyle(row, 51, record2.getR17_NO_FAIL_TRAN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record2.getR17_CUS_FND_SVF_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 53, record2.getR17_CUS_FND_SVF_PRE(), null, createHelper);
					updateCellPreserveStyle(row, 54, record2.getR17_TOT_CRDR_UND_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 55, record2.getR17_TOT_CRD_ISU_SPT(), null, createHelper);
					// updateCellPreserveStyle(row, 56, record2.getR17_NO_ACC_BLK_FIN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 57, record2.getR17_NO_INQ_AVL_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 58, record2.getR17_TOT_PRE_EXP_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 59, record2.getR17_TOT_PRE_POS_EXP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record2.getR17_TOT_PRE_CARD_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 61, record2.getR17_TOT_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 62, record2.getR17_NO_LANG_VOICE(), null, createHelper);
					updateCellPreserveStyle(row, 63, record2.getR17_AVG_NOD_LOWRSK(), null, createHelper);
					// updateCellPreserveStyle(row, 64, record2.getR17_NO_CUST_REISS_LIA(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 65, record2.getR17_NO_INS_CRRATE_CON(), null,
					// createHelper);

					setMcProgress(progressMap, jobId, 65);
					row = sheet.getRow(17);
					updateCellPreserveStyle(row, 5, record2.getR18_AVG_TME_LWRSK(), null, createHelper);
					updateCellPreserveStyle(row, 6, record2.getR18_AVG_NO_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record2.getR18_AVG_NO_LWRSK_SME(), null, createHelper);
					updateCellPreserveStyle(row, 8, record2.getR18_AVG_NO_DYS_SME(), null, createHelper);
					updateCellPreserveStyle(row, 9, record2.getR18_NO_REQ_CLO(), null, createHelper);
					updateCellPreserveStyle(row, 10, record2.getR18_NO_PRD_VAR_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 11, record2.getR18_NO_REQ_RES_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record2.getR18_NO_REQ_PAYDEF(), null, createHelper);
					updateCellPreserveStyle(row, 13, record2.getR18_AVG_TME_REPAY(), null, createHelper);
					updateCellPreserveStyle(row, 14, record2.getR18_NO_INST_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 15, record2.getR18_NET_FEE_AED(), null, createHelper);
					updateCellPreserveStyle(row, 16, record2.getR18_NET_PROF_AED(), null, createHelper);
					updateCellPreserveStyle(row, 17, record2.getR18_TOT_NO_ACC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record2.getR18_TOT_ACCS_DOR(), null, createHelper);
					updateCellPreserveStyle(row, 19, record2.getR18_TOT_NEW_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 20, record2.getR18_TOT_VAL_NEWACCS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 21, record2.getR18_TOT_NO_LOAN_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 22, record2.getR18_TOT_REQ_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 23, record2.getR18_TOT_LOAN_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 24, record2.getR18_NO_CRACC_MIN(), null, createHelper);
					updateCellPreserveStyle(row, 25, record2.getR18_AVG_TME_CLSACC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record2.getR18_N0_CON_MORE1_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 27, record2.getR18_NO_INST_WITH90(), null, createHelper);
					updateCellPreserveStyle(row, 28, record2.getR18_TOT_GROSS_ASET(), null, createHelper);
					updateCellPreserveStyle(row, 29, record2.getR18_RET_LIAB_AED(), null, createHelper);
					updateCellPreserveStyle(row, 30, record2.getR18_HIG_PER_PROD_CAT(), null, createHelper);
					updateCellPreserveStyle(row, 31, record2.getR18_NO_ACCS_TAG_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 32, record2.getR18_NO_CHG_FEE_GRT5(), null, createHelper);
					updateCellPreserveStyle(row, 33, record2.getR18_NO_CON_FLEX_INT(), null, createHelper);
					updateCellPreserveStyle(row, 34, record2.getR18_NO_CON_FIXED_INT(), null, createHelper);
					updateCellPreserveStyle(row, 35, record2.getR18_NO_LOAN_MAY_2011(), null, createHelper);
					updateCellPreserveStyle(row, 36, record2.getR18_VAL_LEGA_MAY_AED(), null, createHelper);
					updateCellPreserveStyle(row, 37, record2.getR18_AVG_DAY_NLL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record2.getR18_PER_DOR_ACCS(), null, createHelper);
					updateCellPreserveStyle(row, 39, record2.getR18_INT_RET_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 40, record2.getR18_FEE_COMM_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 41, record2.getR18_TOT_UNCLM_90(), null, createHelper);
					updateCellPreserveStyle(row, 42, record2.getR18_TOT_VAL_UNBAL(), null, createHelper);
					updateCellPreserveStyle(row, 43, record2.getR18_NO_INST_CONTRACT(), null, createHelper);
					updateCellPreserveStyle(row, 44, record2.getR18_TOT_DORACC_NOTICE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record2.getR18_NO_CONS_LIAB_7DAY(), null, createHelper);
					updateCellPreserveStyle(row, 46, record2.getR18_TOT_REQ_LIAB_NONLIA(), null, createHelper);
					updateCellPreserveStyle(row, 47, record2.getR18_NO_RESTU_ONBO(), null, createHelper);
					// updateCellPreserveStyle(row, 48, record2.getR18_TOT_DELAY_TAT(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 49, record2.getR18_TOT_FND_TRAN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 50, record2.getR18_NO_FUND_RET24(), null, createHelper);
					updateCellPreserveStyle(row, 51, record2.getR18_NO_FAIL_TRAN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record2.getR18_CUS_FND_SVF_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 53, record2.getR18_CUS_FND_SVF_PRE(), null, createHelper);
					updateCellPreserveStyle(row, 54, record2.getR18_TOT_CRDR_UND_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 55, record2.getR18_TOT_CRD_ISU_SPT(), null, createHelper);
					// updateCellPreserveStyle(row, 56, record2.getR18_NO_ACC_BLK_FIN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 57, record2.getR18_NO_INQ_AVL_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 58, record2.getR18_TOT_PRE_EXP_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 59, record2.getR18_TOT_PRE_POS_EXP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record2.getR18_TOT_PRE_CARD_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 61, record2.getR18_TOT_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 62, record2.getR18_NO_LANG_VOICE(), null, createHelper);
					updateCellPreserveStyle(row, 63, record2.getR18_AVG_NOD_LOWRSK(), null, createHelper);
					// updateCellPreserveStyle(row, 64, record2.getR18_NO_CUST_REISS_LIA(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 65, record2.getR18_NO_INS_CRRATE_CON(), null,
					// createHelper);

					row = sheet.getRow(18);
					updateCellPreserveStyle(row, 5, record2.getR19_AVG_TME_LWRSK(), null, createHelper);
					updateCellPreserveStyle(row, 6, record2.getR19_AVG_NO_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record2.getR19_AVG_NO_LWRSK_SME(), null, createHelper);
					updateCellPreserveStyle(row, 8, record2.getR19_AVG_NO_DYS_SME(), null, createHelper);
					updateCellPreserveStyle(row, 9, record2.getR19_NO_REQ_CLO(), null, createHelper);
					updateCellPreserveStyle(row, 10, record2.getR19_NO_PRD_VAR_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 11, record2.getR19_NO_REQ_RES_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record2.getR19_NO_REQ_PAYDEF(), null, createHelper);
					updateCellPreserveStyle(row, 13, record2.getR19_AVG_TME_REPAY(), null, createHelper);
					updateCellPreserveStyle(row, 14, record2.getR19_NO_INST_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 15, record2.getR19_NET_FEE_AED(), null, createHelper);
					updateCellPreserveStyle(row, 16, record2.getR19_NET_PROF_AED(), null, createHelper);
					updateCellPreserveStyle(row, 17, record2.getR19_TOT_NO_ACC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record2.getR19_TOT_ACCS_DOR(), null, createHelper);
					updateCellPreserveStyle(row, 19, record2.getR19_TOT_NEW_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 20, record2.getR19_TOT_VAL_NEWACCS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 21, record2.getR19_TOT_NO_LOAN_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 22, record2.getR19_TOT_REQ_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 23, record2.getR19_TOT_LOAN_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 24, record2.getR19_NO_CRACC_MIN(), null, createHelper);
					updateCellPreserveStyle(row, 25, record2.getR19_AVG_TME_CLSACC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record2.getR19_N0_CON_MORE1_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 27, record2.getR19_NO_INST_WITH90(), null, createHelper);
					updateCellPreserveStyle(row, 28, record2.getR19_TOT_GROSS_ASET(), null, createHelper);
					updateCellPreserveStyle(row, 29, record2.getR19_RET_LIAB_AED(), null, createHelper);
					updateCellPreserveStyle(row, 30, record2.getR19_HIG_PER_PROD_CAT(), null, createHelper);
					updateCellPreserveStyle(row, 31, record2.getR19_NO_ACCS_TAG_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 32, record2.getR19_NO_CHG_FEE_GRT5(), null, createHelper);
					updateCellPreserveStyle(row, 33, record2.getR19_NO_CON_FLEX_INT(), null, createHelper);
					updateCellPreserveStyle(row, 34, record2.getR19_NO_CON_FIXED_INT(), null, createHelper);
					updateCellPreserveStyle(row, 35, record2.getR19_NO_LOAN_MAY_2011(), null, createHelper);
					updateCellPreserveStyle(row, 36, record2.getR19_VAL_LEGA_MAY_AED(), null, createHelper);
					updateCellPreserveStyle(row, 37, record2.getR19_AVG_DAY_NLL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record2.getR19_PER_DOR_ACCS(), null, createHelper);
					updateCellPreserveStyle(row, 39, record2.getR19_INT_RET_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 40, record2.getR19_FEE_COMM_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 41, record2.getR19_TOT_UNCLM_90(), null, createHelper);
					updateCellPreserveStyle(row, 42, record2.getR19_TOT_VAL_UNBAL(), null, createHelper);
					updateCellPreserveStyle(row, 43, record2.getR19_NO_INST_CONTRACT(), null, createHelper);
					updateCellPreserveStyle(row, 44, record2.getR19_TOT_DORACC_NOTICE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record2.getR19_NO_CONS_LIAB_7DAY(), null, createHelper);
					updateCellPreserveStyle(row, 46, record2.getR19_TOT_REQ_LIAB_NONLIA(), null, createHelper);
					updateCellPreserveStyle(row, 47, record2.getR19_NO_RESTU_ONBO(), null, createHelper);
					// updateCellPreserveStyle(row, 48, record2.getR19_TOT_DELAY_TAT(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 49, record2.getR19_TOT_FND_TRAN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 50, record2.getR19_NO_FUND_RET24(), null, createHelper);
					updateCellPreserveStyle(row, 51, record2.getR19_NO_FAIL_TRAN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record2.getR19_CUS_FND_SVF_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 53, record2.getR19_CUS_FND_SVF_PRE(), null, createHelper);
					updateCellPreserveStyle(row, 54, record2.getR19_TOT_CRDR_UND_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 55, record2.getR19_TOT_CRD_ISU_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 56, record2.getR19_NO_ACC_BLK_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 57, record2.getR19_NO_INQ_AVL_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 58, record2.getR19_TOT_PRE_EXP_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 59, record2.getR19_TOT_PRE_POS_EXP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record2.getR19_TOT_PRE_CARD_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 61, record2.getR19_TOT_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 62, record2.getR19_NO_LANG_VOICE(), null, createHelper);
					updateCellPreserveStyle(row, 63, record2.getR19_AVG_NOD_LOWRSK(), null, createHelper);
					// updateCellPreserveStyle(row, 64, record2.getR19_NO_CUST_REISS_LIA(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 65, record2.getR19_NO_INS_CRRATE_CON(), null,
					// createHelper);

					setMcProgress(progressMap, jobId, 75);
					row = sheet.getRow(19);
					updateCellPreserveStyle(row, 5, record2.getR20_AVG_TME_LWRSK(), null, createHelper);
					updateCellPreserveStyle(row, 6, record2.getR20_AVG_NO_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record2.getR20_AVG_NO_LWRSK_SME(), null, createHelper);
					updateCellPreserveStyle(row, 8, record2.getR20_AVG_NO_DYS_SME(), null, createHelper);
					updateCellPreserveStyle(row, 9, record2.getR20_NO_REQ_CLO(), null, createHelper);
					updateCellPreserveStyle(row, 10, record2.getR20_NO_PRD_VAR_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 11, record2.getR20_NO_REQ_RES_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record2.getR20_NO_REQ_PAYDEF(), null, createHelper);
					updateCellPreserveStyle(row, 13, record2.getR20_AVG_TME_REPAY(), null, createHelper);
					updateCellPreserveStyle(row, 14, record2.getR20_NO_INST_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 15, record2.getR20_NET_FEE_AED(), null, createHelper);
					updateCellPreserveStyle(row, 16, record2.getR20_NET_PROF_AED(), null, createHelper);
					updateCellPreserveStyle(row, 17, record2.getR20_TOT_NO_ACC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record2.getR20_TOT_ACCS_DOR(), null, createHelper);
					updateCellPreserveStyle(row, 19, record2.getR20_TOT_NEW_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 20, record2.getR20_TOT_VAL_NEWACCS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 21, record2.getR20_TOT_NO_LOAN_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 22, record2.getR20_TOT_REQ_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 23, record2.getR20_TOT_LOAN_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 24, record2.getR20_NO_CRACC_MIN(), null, createHelper);
					updateCellPreserveStyle(row, 25, record2.getR20_AVG_TME_CLSACC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record2.getR20_N0_CON_MORE1_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 27, record2.getR20_NO_INST_WITH90(), null, createHelper);
					updateCellPreserveStyle(row, 28, record2.getR20_TOT_GROSS_ASET(), null, createHelper);
					updateCellPreserveStyle(row, 29, record2.getR20_RET_LIAB_AED(), null, createHelper);
					updateCellPreserveStyle(row, 30, record2.getR20_HIG_PER_PROD_CAT(), null, createHelper);
					updateCellPreserveStyle(row, 31, record2.getR20_NO_ACCS_TAG_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 32, record2.getR20_NO_CHG_FEE_GRT5(), null, createHelper);
					updateCellPreserveStyle(row, 33, record2.getR20_NO_CON_FLEX_INT(), null, createHelper);
					updateCellPreserveStyle(row, 34, record2.getR20_NO_CON_FIXED_INT(), null, createHelper);
					updateCellPreserveStyle(row, 35, record2.getR20_NO_LOAN_MAY_2011(), null, createHelper);
					updateCellPreserveStyle(row, 36, record2.getR20_VAL_LEGA_MAY_AED(), null, createHelper);
					updateCellPreserveStyle(row, 37, record2.getR20_AVG_DAY_NLL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record2.getR20_PER_DOR_ACCS(), null, createHelper);
					updateCellPreserveStyle(row, 39, record2.getR20_INT_RET_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 40, record2.getR20_FEE_COMM_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 41, record2.getR20_TOT_UNCLM_90(), null, createHelper);
					updateCellPreserveStyle(row, 42, record2.getR20_TOT_VAL_UNBAL(), null, createHelper);
					updateCellPreserveStyle(row, 43, record2.getR20_NO_INST_CONTRACT(), null, createHelper);
					updateCellPreserveStyle(row, 44, record2.getR20_TOT_DORACC_NOTICE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record2.getR20_NO_CONS_LIAB_7DAY(), null, createHelper);
					updateCellPreserveStyle(row, 46, record2.getR20_TOT_REQ_LIAB_NONLIA(), null, createHelper);
					updateCellPreserveStyle(row, 47, record2.getR20_NO_RESTU_ONBO(), null, createHelper);
					// updateCellPreserveStyle(row, 48, record2.getR20_TOT_DELAY_TAT(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 49, record2.getR20_TOT_FND_TRAN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 50, record2.getR20_NO_FUND_RET24(), null, createHelper);
					updateCellPreserveStyle(row, 51, record2.getR20_NO_FAIL_TRAN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record2.getR20_CUS_FND_SVF_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 53, record2.getR20_CUS_FND_SVF_PRE(), null, createHelper);
					updateCellPreserveStyle(row, 54, record2.getR20_TOT_CRDR_UND_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 55, record2.getR20_TOT_CRD_ISU_SPT(), null, createHelper);
					// updateCellPreserveStyle(row, 56, record2.getR20_NO_ACC_BLK_FIN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 57, record2.getR20_NO_INQ_AVL_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 58, record2.getR20_TOT_PRE_EXP_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 59, record2.getR20_TOT_PRE_POS_EXP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record2.getR20_TOT_PRE_CARD_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 61, record2.getR20_TOT_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 62, record2.getR20_NO_LANG_VOICE(), null, createHelper);
					updateCellPreserveStyle(row, 63, record2.getR20_AVG_NOD_LOWRSK(), null, createHelper);
					// updateCellPreserveStyle(row, 64, record2.getR20_NO_CUST_REISS_LIA(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 65, record2.getR20_NO_INS_CRRATE_CON(), null,
					// createHelper);

					row = sheet.getRow(20);
					updateCellPreserveStyle(row, 5, record2.getR21_AVG_TME_LWRSK(), null, createHelper);
					updateCellPreserveStyle(row, 6, record2.getR21_AVG_NO_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record2.getR21_AVG_NO_LWRSK_SME(), null, createHelper);
					updateCellPreserveStyle(row, 8, record2.getR21_AVG_NO_DYS_SME(), null, createHelper);
					updateCellPreserveStyle(row, 9, record2.getR21_NO_REQ_CLO(), null, createHelper);
					updateCellPreserveStyle(row, 10, record2.getR21_NO_PRD_VAR_SPC_TP(), null, createHelper);
					updateCellPreserveStyle(row, 11, record2.getR21_NO_REQ_RES_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 12, record2.getR21_NO_REQ_PAYDEF(), null, createHelper);
					updateCellPreserveStyle(row, 13, record2.getR21_AVG_TME_REPAY(), null, createHelper);
					updateCellPreserveStyle(row, 14, record2.getR21_NO_INST_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 15, record2.getR21_NET_FEE_AED(), null, createHelper);
					updateCellPreserveStyle(row, 16, record2.getR21_NET_PROF_AED(), null, createHelper);
					updateCellPreserveStyle(row, 17, record2.getR21_TOT_NO_ACC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 18, record2.getR21_TOT_ACCS_DOR(), null, createHelper);
					updateCellPreserveStyle(row, 19, record2.getR21_TOT_NEW_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 20, record2.getR21_TOT_VAL_NEWACCS_AED(), null, createHelper);
					updateCellPreserveStyle(row, 21, record2.getR21_TOT_NO_LOAN_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 22, record2.getR21_TOT_REQ_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 23, record2.getR21_TOT_LOAN_OTBNK(), null, createHelper);
					updateCellPreserveStyle(row, 24, record2.getR21_NO_CRACC_MIN(), null, createHelper);
					updateCellPreserveStyle(row, 25, record2.getR21_AVG_TME_CLSACC(), null, createHelper);
					updateCellPreserveStyle(row, 26, record2.getR21_N0_CON_MORE1_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 27, record2.getR21_NO_INST_WITH90(), null, createHelper);
					updateCellPreserveStyle(row, 28, record2.getR21_TOT_GROSS_ASET(), null, createHelper);
					updateCellPreserveStyle(row, 29, record2.getR21_RET_LIAB_AED(), null, createHelper);
					updateCellPreserveStyle(row, 30, record2.getR21_HIG_PER_PROD_CAT(), null, createHelper);
					updateCellPreserveStyle(row, 31, record2.getR21_NO_ACCS_TAG_NPA(), null, createHelper);
					updateCellPreserveStyle(row, 32, record2.getR21_NO_CHG_FEE_GRT5(), null, createHelper);
					updateCellPreserveStyle(row, 33, record2.getR21_NO_CON_FLEX_INT(), null, createHelper);
					updateCellPreserveStyle(row, 34, record2.getR21_NO_CON_FIXED_INT(), null, createHelper);
					updateCellPreserveStyle(row, 35, record2.getR21_NO_LOAN_MAY_2011(), null, createHelper);
					updateCellPreserveStyle(row, 36, record2.getR21_VAL_LEGA_MAY_AED(), null, createHelper);
					updateCellPreserveStyle(row, 37, record2.getR21_AVG_DAY_NLL(), null, createHelper);
					updateCellPreserveStyle(row, 38, record2.getR21_PER_DOR_ACCS(), null, createHelper);
					updateCellPreserveStyle(row, 39, record2.getR21_INT_RET_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 40, record2.getR21_FEE_COMM_PROF(), null, createHelper);
					updateCellPreserveStyle(row, 41, record2.getR21_TOT_UNCLM_90(), null, createHelper);
					updateCellPreserveStyle(row, 42, record2.getR21_TOT_VAL_UNBAL(), null, createHelper);
					updateCellPreserveStyle(row, 43, record2.getR21_NO_INST_CONTRACT(), null, createHelper);
					updateCellPreserveStyle(row, 44, record2.getR21_TOT_DORACC_NOTICE(), null, createHelper);
					updateCellPreserveStyle(row, 45, record2.getR21_NO_CONS_LIAB_7DAY(), null, createHelper);
					updateCellPreserveStyle(row, 46, record2.getR21_TOT_REQ_LIAB_NONLIA(), null, createHelper);
					updateCellPreserveStyle(row, 47, record2.getR21_NO_RESTU_ONBO(), null, createHelper);
					// updateCellPreserveStyle(row, 48, record2.getR21_TOT_DELAY_TAT(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 49, record2.getR21_TOT_FND_TRAN(), null,
					// createHelper);
					updateCellPreserveStyle(row, 50, record2.getR21_NO_FUND_RET24(), null, createHelper);
					updateCellPreserveStyle(row, 51, record2.getR21_NO_FAIL_TRAN(), null, createHelper);
					updateCellPreserveStyle(row, 52, record2.getR21_CUS_FND_SVF_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 53, record2.getR21_CUS_FND_SVF_PRE(), null, createHelper);
					updateCellPreserveStyle(row, 54, record2.getR21_TOT_CRDR_UND_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 55, record2.getR21_TOT_CRD_ISU_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 56, record2.getR21_NO_ACC_BLK_FIN(), null, createHelper);
					updateCellPreserveStyle(row, 57, record2.getR21_NO_INQ_AVL_BAL(), null, createHelper);
					updateCellPreserveStyle(row, 58, record2.getR21_TOT_PRE_EXP_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 59, record2.getR21_TOT_PRE_POS_EXP(), null, createHelper);
					updateCellPreserveStyle(row, 60, record2.getR21_TOT_PRE_CARD_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 61, record2.getR21_TOT_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 62, record2.getR21_NO_LANG_VOICE(), null, createHelper);
					updateCellPreserveStyle(row, 63, record2.getR21_AVG_NOD_LOWRSK(), null, createHelper);
					// updateCellPreserveStyle(row, 64, record2.getR21_NO_CUST_REISS_LIA(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 65, record2.getR21_NO_INS_CRRATE_CON(), null,
					// createHelper);

					setMcProgress(progressMap, jobId, 85);
					row = sheet.getRow(21);
					updateCellPreserveStyle(row, 5, record2.getR22_AVG_TME_LWRSK(), null, createHelper);
					updateCellPreserveStyle(row, 6, record2.getR22_AVG_NO_LOAN(), null, createHelper);
					updateCellPreserveStyle(row, 7, record2.getR22_AVG_NO_LWRSK_SME(), null, createHelper);
					updateCellPreserveStyle(row, 8, record2.getR22_AVG_NO_DYS_SME(), null, createHelper);
//					updateCellPreserveStyle(row, 9, record2.getR22_NO_REQ_CLO(), null, createHelper);
//					updateCellPreserveStyle(row, 10, record2.getR22_NO_PRD_VAR_SPC_TP(), null, createHelper);
//					updateCellPreserveStyle(row, 11, record2.getR22_NO_REQ_RES_SPT(), null, createHelper);
//					updateCellPreserveStyle(row, 12, record2.getR22_NO_REQ_PAYDEF(), null, createHelper);
					updateCellPreserveStyle(row, 13, record2.getR22_AVG_TME_REPAY(), null, createHelper);
//					updateCellPreserveStyle(row, 14, record2.getR22_NO_INST_BAL(), null, createHelper);
//					updateCellPreserveStyle(row, 15, record2.getR22_NET_FEE_AED(), null, createHelper);
//					updateCellPreserveStyle(row, 16, record2.getR22_NET_PROF_AED(), null, createHelper);
//					updateCellPreserveStyle(row, 17, record2.getR22_TOT_NO_ACC_SPD(), null, createHelper);
//					updateCellPreserveStyle(row, 18, record2.getR22_TOT_ACCS_DOR(), null, createHelper);
//					updateCellPreserveStyle(row, 19, record2.getR22_TOT_NEW_LOAN(), null, createHelper);
//					updateCellPreserveStyle(row, 20, record2.getR22_TOT_VAL_NEWACCS_AED(), null, createHelper);
//					updateCellPreserveStyle(row, 21, record2.getR22_TOT_NO_LOAN_SPD(), null, createHelper);
//					updateCellPreserveStyle(row, 22, record2.getR22_TOT_REQ_OTBNK(), null, createHelper);
//					updateCellPreserveStyle(row, 23, record2.getR22_TOT_LOAN_OTBNK(), null, createHelper);
//					updateCellPreserveStyle(row, 24, record2.getR22_NO_CRACC_MIN(), null, createHelper);
					updateCellPreserveStyle(row, 25, record2.getR22_AVG_TME_CLSACC(), null, createHelper);
//					updateCellPreserveStyle(row, 26, record2.getR22_N0_CON_MORE1_LOAN(), null, createHelper);
//					updateCellPreserveStyle(row, 27, record2.getR22_NO_INST_WITH90(), null, createHelper);
//					updateCellPreserveStyle(row, 28, record2.getR22_TOT_GROSS_ASET(), null, createHelper);
//					updateCellPreserveStyle(row, 29, record2.getR22_RET_LIAB_AED(), null, createHelper);
					String maxRate = record2.getR22_HIG_PER_PROD_CAT();
					if (maxRate == null || maxRate.trim().isEmpty() || "0".equals(maxRate.trim())) {
						String[] childRates = {
							record1.getR6_HIG_PER_PROD_CAT(), record1.getR7_HIG_PER_PROD_CAT(), record1.getR8_HIG_PER_PROD_CAT(),
							record1.getR9_HIG_PER_PROD_CAT(), record1.getR10_HIG_PER_PROD_CAT(), record1.getR11_HIG_PER_PROD_CAT(),
							record1.getR12_HIG_PER_PROD_CAT(), record1.getR13_HIG_PER_PROD_CAT(), record1.getR14_HIG_PER_PROD_CAT(),
							record2.getR15_HIG_PER_PROD_CAT(), record2.getR16_HIG_PER_PROD_CAT(), record2.getR17_HIG_PER_PROD_CAT(),
							record2.getR18_HIG_PER_PROD_CAT(), record2.getR19_HIG_PER_PROD_CAT(), record2.getR20_HIG_PER_PROD_CAT(),
							record2.getR21_HIG_PER_PROD_CAT()
						};
						Double calculatedMax = null;
						boolean hasPercent = false;
						for (String cr : childRates) {
							if (cr != null && !cr.trim().isEmpty() && !"-".equals(cr.trim()) && !"null".equalsIgnoreCase(cr.trim())) {
								String tr = cr.trim();
								if (tr.contains("%")) hasPercent = true;
								try {
									double d = Double.parseDouble(tr.replace("%", "").replace(",", "").trim());
									if (calculatedMax == null || d > calculatedMax) calculatedMax = d;
								} catch (Exception ignored) {}
							}
						}
						if (calculatedMax != null) {
							maxRate = (calculatedMax == Math.floor(calculatedMax) ? String.format("%.0f", calculatedMax) : String.valueOf(calculatedMax)) + (hasPercent ? "%" : "");
						} else {
							maxRate = "0";
						}
					}
					updateCellPreserveStyle(row, 30, maxRate, null, createHelper);
//					updateCellPreserveStyle(row, 31, record2.getR22_NO_ACCS_TAG_NPA(), null, createHelper);
//					updateCellPreserveStyle(row, 32, record2.getR22_NO_CHG_FEE_GRT5(), null, createHelper);
//					updateCellPreserveStyle(row, 33, record2.getR22_NO_CON_FLEX_INT(), null, createHelper);
//					updateCellPreserveStyle(row, 34, record2.getR22_NO_CON_FIXED_INT(), null, createHelper);
//					updateCellPreserveStyle(row, 35, record2.getR22_NO_LOAN_MAY_2011(), null, createHelper);
//					updateCellPreserveStyle(row, 36, record2.getR22_VAL_LEGA_MAY_AED(), null, createHelper);
					updateCellPreserveStyle(row, 37, record2.getR22_AVG_DAY_NLL(), null, createHelper);
//					updateCellPreserveStyle(row, 38, record2.getR22_PER_DOR_ACCS(), null, createHelper);
//					updateCellPreserveStyle(row, 39, record2.getR22_INT_RET_PROF(), null, createHelper);
//					updateCellPreserveStyle(row, 40, record2.getR22_FEE_COMM_PROF(), null, createHelper);
//					updateCellPreserveStyle(row, 41, record2.getR22_TOT_UNCLM_90(), null, createHelper);
//					updateCellPreserveStyle(row, 42, record2.getR22_TOT_VAL_UNBAL(), null, createHelper);
//					updateCellPreserveStyle(row, 43, record2.getR22_NO_INST_CONTRACT(), null, createHelper);
//					updateCellPreserveStyle(row, 44, record2.getR22_TOT_DORACC_NOTICE(), null, createHelper);
//					updateCellPreserveStyle(row, 45, record2.getR22_NO_CONS_LIAB_7DAY(), null, createHelper);
//					updateCellPreserveStyle(row, 46, record2.getR22_TOT_REQ_LIAB_NONLIA(), null, createHelper);
//					updateCellPreserveStyle(row, 47, record2.getR22_NO_RESTU_ONBO(), null, createHelper);
//					updateCellPreserveStyle(row, 48, record2.getR22_TOT_DELAY_TAT(), null, createHelper);
//					updateCellPreserveStyle(row, 49, record2.getR22_TOT_FND_TRAN(), null, createHelper);
//					updateCellPreserveStyle(row, 50, record2.getR22_NO_FUND_RET24(), null, createHelper);
//					updateCellPreserveStyle(row, 51, record2.getR22_NO_FAIL_TRAN(), null, createHelper);
//					updateCellPreserveStyle(row, 52, record2.getR22_CUS_FND_SVF_SPT(), null, createHelper);
//					updateCellPreserveStyle(row, 53, record2.getR22_CUS_FND_SVF_PRE(), null, createHelper);
//					updateCellPreserveStyle(row, 54, record2.getR22_TOT_CRDR_UND_SPT(), null, createHelper);
//					updateCellPreserveStyle(row, 55, record2.getR22_TOT_CRD_ISU_SPT(), null, createHelper);
//					updateCellPreserveStyle(row, 56, record2.getR22_NO_ACC_BLK_FIN(), null, createHelper);
//					updateCellPreserveStyle(row, 57, record2.getR22_NO_INQ_AVL_BAL(), null, createHelper);
//					updateCellPreserveStyle(row, 58, record2.getR22_TOT_PRE_EXP_SPT(), null, createHelper);
//					updateCellPreserveStyle(row, 59, record2.getR22_TOT_PRE_POS_EXP(), null, createHelper);
//					updateCellPreserveStyle(row, 60, record2.getR22_TOT_PRE_CARD_SPD(), null, createHelper);
//					updateCellPreserveStyle(row, 61, record2.getR22_TOT_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 62, record2.getR22_NO_LANG_VOICE(), null, createHelper);
					updateCellPreserveStyle(row, 63, record2.getR22_AVG_NOD_LOWRSK(), null, createHelper);
//					updateCellPreserveStyle(row, 64, record2.getR22_NO_CUST_REISS_LIA(), null, createHelper);
//					updateCellPreserveStyle(row, 65, record2.getR22_NO_INS_CRRATE_CON(), null, createHelper);

				}
				evaluateMcFormulas(workbook, jobId);
			} else {

			}

			
		} catch (Exception e) {
			logger.error("MC download jobId={} excel write failed reportDate={} branch={} formmode={}", jobId,
					reportDate, branch, formmode, e);
			throw e;
		}

	}

	public void GenerateTable_5_Excel(Workbook workbook,String branch, String jobId, Map<String, Integer> progressMap, String formmode,
			String reportDate, String isConsolidated, String reportOption, String selectedDepartments) throws Exception {
//		logMcDownload(jobId, "fetching database rows", reportDate, branch, isConsolidated, formmode);
//
//		List<RT_MC_TABLE5_ENTITY> dataList;
//
//		if (branch =="DEPT" || branch.equals("DEPT")) {
//			dataList = RT_MC_TABLE5_REPO.findBybranchcode(branch);
//		}
//		else {
//			dataList = RT_MC_TABLE5_REPO.findByReportDateAndBranchCode(reportDate, branch);
//		}
//		if (dataList.isEmpty()) {
//			logger.warn("Service: No data found for MC report. Returning empty result.");
//			return;
//		}
		

		logMcDownload(jobId, "fetching database rows", reportDate, branch, isConsolidated, formmode);
	    List<RT_MC_TABLE5_ENTITY> dataList = new ArrayList<>();

	    if ("YES".equalsIgnoreCase(isConsolidated)) {
	        
	        List<RT_MC_TABLE5_ENTITY> numData = RT_MC_TABLE5_REPO.findByReportDateAndBranchCode(reportDate, branch);
	        List<RT_MC_TABLE5_ENTITY> deptData = RT_MC_TABLE5_REPO.findBybranchcode("DEPT");
	        
	        dataList = mergeReportData(numData, deptData, reportOption, selectedDepartments, RT_MC_TABLE5_ENTITY.class);
	        
	    } else {
	        if ("DEPT".equals(branch)) {
	            dataList = RT_MC_TABLE5_REPO.findBybranchcode(branch);
	        } else {
	            dataList = RT_MC_TABLE5_REPO.findByReportDateAndBranchCode(reportDate, branch);
	        }
	    }

	    if (dataList == null || dataList.isEmpty()) {
	        logger.warn("MC download jobId={} no rows after fetch. reportDate={} branch={} formmode={}", jobId,
	        		reportDate, branch, formmode);
	        return;
	    }
	    logger.info("MC download jobId={} fetched {} rows. Sheet write starts next.", jobId, dataList.size());
	    
		try  {

			Sheet sheet = openMcSheet(workbook, jobId, 7);

			// --- Style Definitions ---
			CreationHelper createHelper = workbook.getCreationHelper();

			CellStyle dateStyle = workbook.createCellStyle();
			dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
			dateStyle.setBorderBottom(BorderStyle.THIN);
			dateStyle.setBorderTop(BorderStyle.THIN);
			dateStyle.setBorderLeft(BorderStyle.THIN);
			dateStyle.setBorderRight(BorderStyle.THIN);

			CellStyle textStyle = workbook.createCellStyle();
			textStyle.setBorderBottom(BorderStyle.THIN);
			textStyle.setBorderTop(BorderStyle.THIN);
			textStyle.setBorderLeft(BorderStyle.THIN);
			textStyle.setBorderRight(BorderStyle.THIN);

			// Create the font
			Font font = workbook.createFont();
			font.setFontHeightInPoints((short) 8); // size 8
			font.setFontName("Arial");

			CellStyle numberStyle = workbook.createCellStyle();
			// numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("0.000"));
			numberStyle.setBorderBottom(BorderStyle.THIN);
			numberStyle.setBorderTop(BorderStyle.THIN);
			numberStyle.setBorderLeft(BorderStyle.THIN);
			numberStyle.setBorderRight(BorderStyle.THIN);
			numberStyle.setFont(font);
			// --- End of Style Definitions ---

			int startRow = 7;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {
					RT_MC_TABLE5_ENTITY record = dataList.get(i);
					System.out.println("rownumber=" + startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}
					setMcProgress(progressMap, jobId, 5, "writing row " + (i + 1) + " excelRow " + (startRow + i));

					updateCellPreserveStyle(row, 5, record.getR8_NO_CON_EMP_SPCD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR8_NO_EMP_LFI(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR8_NO_DIS_POOR(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR8_NO_CON_AGS(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR8_NO_SAL_STF_EMP(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR8_NO_FXD_RENUM(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR8_NO_SAL_REN_50(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR8_AVG_BON_CON(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR8_NO_EMP_DIS_ACT(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR8_NO_COM_SPC_PT(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR8_NO_INS_COC_PT(), null, createHelper);
					updateCellPreserveStyle(row, 16, record.getR8_NO_WSTLE_RSK(), null, createHelper);
					setMcProgress(progressMap, jobId, 25);
					row = sheet.getRow(8);
					updateCellPreserveStyle(row, 5, record.getR9_NO_CON_EMP_SPCD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR9_NO_EMP_LFI(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR9_NO_DIS_POOR(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR9_NO_CON_AGS(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR9_NO_SAL_STF_EMP(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR9_NO_FXD_RENUM(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR9_NO_SAL_REN_50(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR9_AVG_BON_CON(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR9_NO_EMP_DIS_ACT(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR9_NO_COM_SPC_PT(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR9_NO_INS_COC_PT(), null, createHelper);
					updateCellPreserveStyle(row, 16, record.getR9_NO_WSTLE_RSK(), null, createHelper);
					setMcProgress(progressMap, jobId, 45);
					row = sheet.getRow(9);
					updateCellPreserveStyle(row, 5, record.getR10_NO_CON_EMP_SPCD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR10_NO_EMP_LFI(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR10_NO_DIS_POOR(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR10_NO_CON_AGS(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR10_NO_SAL_STF_EMP(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR10_NO_FXD_RENUM(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR10_NO_SAL_REN_50(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR10_AVG_BON_CON(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR10_NO_EMP_DIS_ACT(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR10_NO_COM_SPC_PT(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR10_NO_INS_COC_PT(), null, createHelper);
					updateCellPreserveStyle(row, 16, record.getR10_NO_WSTLE_RSK(), null, createHelper);
					setMcProgress(progressMap, jobId, 65);
					row = sheet.getRow(10);
					// updateCellPreserveStyle(row, 5, record.getR11_NO_CON_EMP_SPCD(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 6, record.getR11_NO_EMP_LFI(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 7, record.getR11_NO_DIS_POOR(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 8, record.getR11_NO_CON_AGS(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 9, record.getR11_NO_SAL_STF_EMP(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 10, record.getR11_NO_FXD_RENUM(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 11, record.getR11_NO_SAL_REN_50(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 12, record.getR11_AVG_BON_CON(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 13, record.getR11_NO_EMP_DIS_ACT(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 14, record.getR11_NO_COM_SPC_PT(), null,
					// createHelper);
					updateCellPreserveStyle(row, 15, record.getR11_NO_INS_COC_PT(), null, createHelper);
					updateCellPreserveStyle(row, 16, record.getR11_NO_WSTLE_RSK(), null, createHelper);
					setMcProgress(progressMap, jobId, 85);
//					row = sheet.getRow(11);
//					updateCellPreserveStyle(row, 5, record.getR12_NO_CON_EMP_SPCD(), null, createHelper);
//					updateCellPreserveStyle(row, 6, record.getR12_NO_EMP_LFI(), null, createHelper);
//					updateCellPreserveStyle(row, 7, record.getR12_NO_DIS_POOR(), null, createHelper);
//					updateCellPreserveStyle(row, 8, record.getR12_NO_CON_AGS(), null, createHelper);
//					updateCellPreserveStyle(row, 9, record.getR12_NO_SAL_STF_EMP(), null, createHelper);
//					updateCellPreserveStyle(row, 10, record.getR12_NO_FXD_RENUM(), null, createHelper);
//					updateCellPreserveStyle(row, 11, record.getR12_NO_SAL_REN_50(), null, createHelper);
//					updateCellPreserveStyle(row, 12, record.getR12_AVG_BON_CON(), null, createHelper);
//					updateCellPreserveStyle(row, 13, record.getR12_NO_EMP_DIS_ACT(), null, createHelper);
//					updateCellPreserveStyle(row, 14, record.getR12_NO_COM_SPC_PT(), null, createHelper);
//					updateCellPreserveStyle(row, 15, record.getR12_NO_INS_COC_PT(), null, createHelper);s
//					updateCellPreserveStyle(row, 16, record.getR12_NO_WSTLE_RSK(), null, createHelper);

				}
				evaluateMcFormulas(workbook, jobId);
			} else {

			}
			
		} catch (Exception e) {
			logger.error("MC download jobId={} excel write failed reportDate={} branch={} formmode={}", jobId,
					reportDate, branch, formmode, e);
			throw e;
		}

	}

	public void GenerateTable_6_Excel(Workbook workbook,String branch, String jobId, Map<String, Integer> progressMap, String formmode,
			String reportDate, String isConsolidated, String reportOption, String selectedDepartments) throws Exception {
//		logMcDownload(jobId, "fetching database rows", reportDate, branch, isConsolidated, formmode);
//
//		List<RT_MC_TABLE6_ENTITY> dataList ;
//		if (branch =="DEPT" || branch.equals("DEPT")) {
//			dataList = RT_MC_TABLE6_REPO.findBybranchcode(branch);
//		}
//		else {
//			dataList = RT_MC_TABLE6_REPO.findByReportDateAndBranchCode(reportDate, branch);
//		}
//		if (dataList.isEmpty()) {
//			logger.warn("Service: No data found for MC report. Returning empty result.");
//			return;
//		}

		logMcDownload(jobId, "fetching database rows", reportDate, branch, isConsolidated, formmode);
	    List<RT_MC_TABLE6_ENTITY> dataList = new ArrayList<>();

	    if ("YES".equalsIgnoreCase(isConsolidated)) {
	        
	        List<RT_MC_TABLE6_ENTITY> numData = RT_MC_TABLE6_REPO.findByReportDateAndBranchCode(reportDate, branch);
	        List<RT_MC_TABLE6_ENTITY> deptData = RT_MC_TABLE6_REPO.findBybranchcode("DEPT");
	        
	        dataList = mergeReportData(numData, deptData, reportOption, selectedDepartments, RT_MC_TABLE6_ENTITY.class);
	        
	    } else {
	        if ("DEPT".equals(branch)) {
	            dataList = RT_MC_TABLE6_REPO.findBybranchcode(branch);
	        } else {
	            dataList = RT_MC_TABLE6_REPO.findByReportDateAndBranchCode(reportDate, branch);
	        }
	    }

	    if (dataList == null || dataList.isEmpty()) {
	        logger.warn("MC download jobId={} no rows after fetch. reportDate={} branch={} formmode={}", jobId,
	        		reportDate, branch, formmode);
	        return;
	    }
	    logger.info("MC download jobId={} fetched {} rows. Sheet write starts next.", jobId, dataList.size());
		
		try {

			Sheet sheet = openMcSheet(workbook, jobId, 8);

			// --- Style Definitions ---
			CreationHelper createHelper = workbook.getCreationHelper();

			CellStyle dateStyle = workbook.createCellStyle();
			dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
			dateStyle.setBorderBottom(BorderStyle.THIN);
			dateStyle.setBorderTop(BorderStyle.THIN);
			dateStyle.setBorderLeft(BorderStyle.THIN);
			dateStyle.setBorderRight(BorderStyle.THIN);

			CellStyle textStyle = workbook.createCellStyle();
			textStyle.setBorderBottom(BorderStyle.THIN);
			textStyle.setBorderTop(BorderStyle.THIN);
			textStyle.setBorderLeft(BorderStyle.THIN);
			textStyle.setBorderRight(BorderStyle.THIN);

			// Create the font
			Font font = workbook.createFont();
			font.setFontHeightInPoints((short) 8); // size 8
			font.setFontName("Arial");

			CellStyle numberStyle = workbook.createCellStyle();
			// numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("0.000"));
			numberStyle.setBorderBottom(BorderStyle.THIN);
			numberStyle.setBorderTop(BorderStyle.THIN);
			numberStyle.setBorderLeft(BorderStyle.THIN);
			numberStyle.setBorderRight(BorderStyle.THIN);
			numberStyle.setFont(font);
			// --- End of Style Definitions ---

			int startRow = 6;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {
					RT_MC_TABLE6_ENTITY record = dataList.get(i);
					System.out.println("rownumber=" + startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}
					setMcProgress(progressMap, jobId, 5, "writing row " + (i + 1) + " excelRow " + (startRow + i));

					updateCellPreserveStyle(row, 5, record.getR7_NO_PRO_SNR(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR7_NO_TRA_SNR_SPT(), null, createHelper);
					// updateCellPreserveStyle(row, 7, record.getR7_NO_CONS_VC(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 8, record.getR7_NO_CON_FRA(), null,
					// createHelper);
					updateCellPreserveStyle(row, 9, record.getR7_NO_CON_MRK_FRD(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR7_TOT_CON_PRO_CBUAE(), null, createHelper);
					// updateCellPreserveStyle(row, 11, record.getR7_TOT_TRA_CBUAE(), null,
					// createHelper);
					setMcProgress(progressMap, jobId, 20);
					row = sheet.getRow(7);
					updateCellPreserveStyle(row, 5, record.getR8_NO_PRO_SNR(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR8_NO_TRA_SNR_SPT(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR8_NO_CONS_VC(), null, createHelper);
					// updateCellPreserveStyle(row, 8, record.getR8_NO_CON_FRA(), null,
					// createHelper);
					updateCellPreserveStyle(row, 9, record.getR8_NO_CON_MRK_FRD(), null, createHelper);
					// updateCellPreserveStyle(row, 10, record.getR8_TOT_CON_PRO_CBUAE(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 11, record.getR8_TOT_TRA_CBUAE(), null,
					// createHelper);
					setMcProgress(progressMap, jobId, 35);
					row = sheet.getRow(8);
					updateCellPreserveStyle(row, 5, record.getR9_NO_PRO_SNR(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR9_NO_TRA_SNR_SPT(), null, createHelper);
					// updateCellPreserveStyle(row, 7, record.getR9_NO_CONS_VC(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 8, record.getR9_NO_CON_FRA(), null,
					// createHelper);
					updateCellPreserveStyle(row, 9, record.getR9_NO_CON_MRK_FRD(), null, createHelper);
					// updateCellPreserveStyle(row, 10, record.getR9_TOT_CON_PRO_CBUAE(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 11, record.getR9_TOT_TRA_CBUAE(), null,
					// createHelper);
					setMcProgress(progressMap, jobId, 50);
					row = sheet.getRow(9);
					updateCellPreserveStyle(row, 5, record.getR10_NO_PRO_SNR(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR10_NO_TRA_SNR_SPT(), null, createHelper);
					// updateCellPreserveStyle(row, 7, record.getR10_NO_CONS_VC(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 8, record.getR10_NO_CON_FRA(), null,
					// createHelper);
					updateCellPreserveStyle(row, 9, record.getR10_NO_CON_MRK_FRD(), null, createHelper);
					// updateCellPreserveStyle(row, 10, record.getR10_TOT_CON_PRO_CBUAE(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 11, record.getR10_TOT_TRA_CBUAE(), null,
					// createHelper);
					setMcProgress(progressMap, jobId, 65);
					row = sheet.getRow(10);
					updateCellPreserveStyle(row, 5, record.getR11_NO_PRO_SNR(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR11_NO_TRA_SNR_SPT(), null, createHelper);
					// updateCellPreserveStyle(row, 7, record.getR11_NO_CONS_VC(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 8, record.getR11_NO_CON_FRA(), null,
					// createHelper);
					updateCellPreserveStyle(row, 9, record.getR11_NO_CON_MRK_FRD(), null, createHelper);
					// updateCellPreserveStyle(row, 10, record.getR11_TOT_CON_PRO_CBUAE(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 11, record.getR11_TOT_TRA_CBUAE(), null,
					// createHelper);

					setMcProgress(progressMap, jobId, 85);
					row = sheet.getRow(11);
//					updateCellPreserveStyle(row, 5, record.getR12_NO_PRO_SNR(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR12_NO_TRA_SNR_SPT(), null, createHelper);
//					updateCellPreserveStyle(row, 7, record.getR12_NO_CONS_VC(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR12_NO_CON_FRA(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR12_NO_CON_MRK_FRD(), null, createHelper);
//					updateCellPreserveStyle(row, 10, record.getR12_TOT_CON_PRO_CBUAE(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR12_TOT_TRA_CBUAE(), null, createHelper);

				}
				evaluateMcFormulas(workbook, jobId);
			} else {

			}

			
		} catch (Exception e) {
			logger.error("MC download jobId={} excel write failed reportDate={} branch={} formmode={}", jobId,
					reportDate, branch, formmode, e);
			throw e;
		}

	}

	public void GenerateTable_7_Excel(Workbook workbook,String branch, String jobId, Map<String, Integer> progressMap, String formmode,
			String reportDate, String isConsolidated, String reportOption, String selectedDepartments) throws Exception {
//		logMcDownload(jobId, "fetching database rows", reportDate, branch, isConsolidated, formmode);
//
//		List<RT_MC_TABLE7_1_ENTITY> dataList1;
//		List<RT_MC_TABLE7_2_ENTITY> dataList2 ;
//
//		if (branch =="DEPT" || branch.equals("DEPT")) {
//			dataList1 = RT_MC_TABLE7_1_REPO.findBybranchcode(branch);
//			dataList2 = RT_MC_TABLE7_2_REPO.findBybranchcode(branch);
//		}
//		else {
//			dataList1 = RT_MC_TABLE7_1_REPO.findByReportDateAndBranchCode(reportDate, branch);
//			dataList2 = RT_MC_TABLE7_2_REPO.findByReportDateAndBranchCode(reportDate, branch);
//		}

		logMcDownload(jobId, "fetching database rows", reportDate, branch, isConsolidated, formmode);
	    List<RT_MC_TABLE7_1_ENTITY> dataList1 = new ArrayList<>();
	    List<RT_MC_TABLE7_2_ENTITY> dataList2 = new ArrayList<>();

	    if ("YES".equalsIgnoreCase(isConsolidated)) {
	        
	        List<RT_MC_TABLE7_1_ENTITY> numData1 = RT_MC_TABLE7_1_REPO.findByReportDateAndBranchCode(reportDate, branch);
	        List<RT_MC_TABLE7_1_ENTITY> deptData1 = RT_MC_TABLE7_1_REPO.findBybranchcode("DEPT");
	        List<RT_MC_TABLE7_2_ENTITY> numData2 = RT_MC_TABLE7_2_REPO.findByReportDateAndBranchCode(reportDate, branch);
	        List<RT_MC_TABLE7_2_ENTITY> deptData2 = RT_MC_TABLE7_2_REPO.findBybranchcode("DEPT");
	        dataList1 = mergeReportData(numData1, deptData1, reportOption, selectedDepartments, RT_MC_TABLE7_1_ENTITY.class);
	        dataList2 = mergeReportData(numData2, deptData2, reportOption, selectedDepartments, RT_MC_TABLE7_2_ENTITY.class);
	        
	    } else {
	        if ("DEPT".equals(branch)) {
	        	dataList1 = RT_MC_TABLE7_1_REPO.findBybranchcode(branch);
    			dataList2 = RT_MC_TABLE7_2_REPO.findBybranchcode(branch);
	        } else {
	        	dataList1 = RT_MC_TABLE7_1_REPO.findByReportDateAndBranchCode(reportDate, branch);
				dataList2 = RT_MC_TABLE7_2_REPO.findByReportDateAndBranchCode(reportDate, branch);
	        }
	    }

	    if (dataList1 == null || dataList1.isEmpty() || dataList2 == null || dataList2.isEmpty() ) {
	        logger.warn(
	        		"MC download jobId={} no rows after fetch. list1={} list2={} reportDate={} branch={} formmode={}",
	        		jobId, dataList1 == null ? 0 : dataList1.size(), dataList2 == null ? 0 : dataList2.size(),
	        		reportDate, branch, formmode);
	        return;
	    }
	    logger.info("MC download jobId={} fetched list1={} list2={} rows. Sheet write starts next.", jobId,
	    		dataList1.size(), dataList2.size());
	    
		
		try {

			Sheet sheet = openMcSheet(workbook, jobId, 9);

			// --- Style Definitions ---
			CreationHelper createHelper = workbook.getCreationHelper();

			CellStyle dateStyle = workbook.createCellStyle();
			dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
			dateStyle.setBorderBottom(BorderStyle.THIN);
			dateStyle.setBorderTop(BorderStyle.THIN);
			dateStyle.setBorderLeft(BorderStyle.THIN);
			dateStyle.setBorderRight(BorderStyle.THIN);

			CellStyle textStyle = workbook.createCellStyle();
			textStyle.setBorderBottom(BorderStyle.THIN);
			textStyle.setBorderTop(BorderStyle.THIN);
			textStyle.setBorderLeft(BorderStyle.THIN);
			textStyle.setBorderRight(BorderStyle.THIN);

			// Create the font
			Font font = workbook.createFont();
			font.setFontHeightInPoints((short) 8); // size 8
			font.setFontName("Arial");

			CellStyle numberStyle = workbook.createCellStyle();
			// numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("0.000"));
			numberStyle.setBorderBottom(BorderStyle.THIN);
			numberStyle.setBorderTop(BorderStyle.THIN);
			numberStyle.setBorderLeft(BorderStyle.THIN);
			numberStyle.setBorderRight(BorderStyle.THIN);
			numberStyle.setFont(font);
			// --- End of Style Definitions ---

			int startRow = 6;

			if (!dataList1.isEmpty() && !dataList2.isEmpty()) {
				for (int i = 0; i < dataList1.size(); i++) {
					RT_MC_TABLE7_1_ENTITY record1 = dataList1.get(i);
					RT_MC_TABLE7_2_ENTITY record2 = dataList2.get(i);
					System.out.println("rownumber=" + (startRow + i));
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}
					setMcProgress(progressMap, jobId, 5, "writing row " + (i + 1) + " excelRow " + (startRow + i));

					updateCellPreserveStyle(row, 9, record1.getR7_RET_ASET_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR7_PER_LOAN_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR7_LOAN_SME_WEB_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR7_NO_COMPDIGI_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR7_NO_COMP_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR7_PER_COMPDIGI_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR7_PER_COM_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR7_TOT_REV_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR7_PROF_LOSS_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR7_PROF_MARG_PORTFOLIO(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR7_TOT_RET_ASET_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR7_NP_LOAN_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR7_NON_CON_ONLAST_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR7_TOT_BRAN_PREV(), null, createHelper);

					// updateCellPreserveStyle(row, 51, record1.getR7_NPL_SPD(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 52, record1.getR7_RECO_NPL_SPD(), null,
					// createHelper);
					updateCellPreserveStyle(row, 53, record1.getR7_NO_CON_ONBO_DIGI(), null, createHelper);
					updateCellPreserveStyle(row, 54, record1.getR7_NO_ACCS_AML(), null, createHelper);
					updateCellPreserveStyle(row, 55, record1.getR7_TOT_ACC_LOAN_AML(), null, createHelper);
					updateCellPreserveStyle(row, 56, record1.getR7_TOT_NEW_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 57, record1.getR7_TOT_VALS_LOANS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR7_NO_INQ_WEBMOB(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR7_NO_INQ_TRAD(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR7_NO_RET_POS(), null, createHelper);
					updateCellPreserveStyle(row, 61, record1.getR7_AMT_POS_GATE(), null, createHelper);
					updateCellPreserveStyle(row, 62, record1.getR7_NO_TRAN_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 63, record1.getR7_AMT_RET_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 64, record1.getR7_TOT_WEB_MOB_VIRT(), null, createHelper);
					updateCellPreserveStyle(row, 65, record1.getR7_VAL_UNCL_SVF(), null, createHelper);
					updateCellPreserveStyle(row, 66, record1.getR7_NO_CON_LOW_RSK(), null, createHelper);
					updateCellPreserveStyle(row, 67, record1.getR7_NO_CON_HIGH_RSK(), null, createHelper);
					row = sheet.getRow(7);
					updateCellPreserveStyle(row, 8, record1.getR8_RET_LOAN_DIS(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR8_RET_ASET_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR8_PER_LOAN_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR8_LOAN_SME_WEB_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR8_NO_COMPDIGI_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR8_NO_COMP_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR8_PER_COMPDIGI_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR8_PER_COM_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR8_TOT_REV_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR8_PROF_LOSS_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR8_PROF_MARG_PORTFOLIO(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR8_TOT_RET_ASET_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR8_NP_LOAN_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR8_NON_CON_ONLAST_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR8_TOT_BRAN_PREV(), null, createHelper);

					// updateCellPreserveStyle(row, 51, record1.getR8_NPL_SPD(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 52, record1.getR8_RECO_NPL_SPD(), null,
					// createHelper);
					updateCellPreserveStyle(row, 53, record1.getR8_NO_CON_ONBO_DIGI(), null, createHelper);
					updateCellPreserveStyle(row, 54, record1.getR8_NO_ACCS_AML(), null, createHelper);
					updateCellPreserveStyle(row, 55, record1.getR8_TOT_ACC_LOAN_AML(), null, createHelper);
					updateCellPreserveStyle(row, 56, record1.getR8_TOT_NEW_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 57, record1.getR8_TOT_VALS_LOANS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR8_NO_INQ_WEBMOB(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR8_NO_INQ_TRAD(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR8_NO_RET_POS(), null, createHelper);
					updateCellPreserveStyle(row, 61, record1.getR8_AMT_POS_GATE(), null, createHelper);
					updateCellPreserveStyle(row, 62, record1.getR8_NO_TRAN_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 63, record1.getR8_AMT_RET_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 64, record1.getR8_TOT_WEB_MOB_VIRT(), null, createHelper);
					updateCellPreserveStyle(row, 65, record1.getR8_VAL_UNCL_SVF(), null, createHelper);
					updateCellPreserveStyle(row, 66, record1.getR8_NO_CON_LOW_RSK(), null, createHelper);
					updateCellPreserveStyle(row, 67, record1.getR8_NO_CON_HIGH_RSK(), null, createHelper);
					row = sheet.getRow(8);

					setMcProgress(progressMap, jobId, 12);
					updateCellPreserveStyle(row, 8, record1.getR9_RET_LOAN_DIS(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR9_RET_ASET_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR9_PER_LOAN_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR9_LOAN_SME_WEB_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR9_NO_COMPDIGI_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR9_NO_COMP_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR9_PER_COMPDIGI_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR9_PER_COM_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR9_TOT_REV_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR9_PROF_LOSS_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR9_PROF_MARG_PORTFOLIO(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR9_TOT_RET_ASET_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR9_NP_LOAN_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR9_NON_CON_ONLAST_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR9_TOT_BRAN_PREV(), null, createHelper);

					// updateCellPreserveStyle(row, 51, record1.getR9_NPL_SPD(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 52, record1.getR9_RECO_NPL_SPD(), null,
					// createHelper);
					updateCellPreserveStyle(row, 53, record1.getR9_NO_CON_ONBO_DIGI(), null, createHelper);
					// updateCellPreserveStyle(row, 54, record1.getR9_NO_ACCS_AML(), null,
					// createHelper);
					updateCellPreserveStyle(row, 55, record1.getR9_TOT_ACC_LOAN_AML(), null, createHelper);
					updateCellPreserveStyle(row, 56, record1.getR9_TOT_NEW_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 57, record1.getR9_TOT_VALS_LOANS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR9_NO_INQ_WEBMOB(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR9_NO_INQ_TRAD(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR9_NO_RET_POS(), null, createHelper);
					updateCellPreserveStyle(row, 61, record1.getR9_AMT_POS_GATE(), null, createHelper);
					updateCellPreserveStyle(row, 62, record1.getR9_NO_TRAN_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 63, record1.getR9_AMT_RET_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 64, record1.getR9_TOT_WEB_MOB_VIRT(), null, createHelper);
					updateCellPreserveStyle(row, 65, record1.getR9_VAL_UNCL_SVF(), null, createHelper);
					updateCellPreserveStyle(row, 66, record1.getR9_NO_CON_LOW_RSK(), null, createHelper);
					updateCellPreserveStyle(row, 67, record1.getR9_NO_CON_HIGH_RSK(), null, createHelper);
					row = sheet.getRow(9);

					updateCellPreserveStyle(row, 8, record1.getR10_RET_LOAN_DIS(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR10_RET_ASET_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR10_PER_LOAN_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR10_LOAN_SME_WEB_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR10_NO_COMPDIGI_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR10_NO_COMP_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR10_PER_COMPDIGI_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR10_PER_COM_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR10_TOT_REV_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR10_PROF_LOSS_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR10_PROF_MARG_PORTFOLIO(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR10_TOT_RET_ASET_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR10_NP_LOAN_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR10_NON_CON_ONLAST_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR10_TOT_BRAN_PREV(), null, createHelper);

					updateCellPreserveStyle(row, 51, record1.getR10_NPL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR10_RECO_NPL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR10_NO_CON_ONBO_DIGI(), null, createHelper);
					// updateCellPreserveStyle(row, 54, record1.getR10_NO_ACCS_AML(), null,
					// createHelper);
					updateCellPreserveStyle(row, 55, record1.getR10_TOT_ACC_LOAN_AML(), null, createHelper);
					updateCellPreserveStyle(row, 56, record1.getR10_TOT_NEW_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 57, record1.getR10_TOT_VALS_LOANS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR10_NO_INQ_WEBMOB(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR10_NO_INQ_TRAD(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR10_NO_RET_POS(), null, createHelper);
					updateCellPreserveStyle(row, 61, record1.getR10_AMT_POS_GATE(), null, createHelper);
					updateCellPreserveStyle(row, 62, record1.getR10_NO_TRAN_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 63, record1.getR10_AMT_RET_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 64, record1.getR10_TOT_WEB_MOB_VIRT(), null, createHelper);
					updateCellPreserveStyle(row, 65, record1.getR10_VAL_UNCL_SVF(), null, createHelper);
					updateCellPreserveStyle(row, 66, record1.getR10_NO_CON_LOW_RSK(), null, createHelper);
					updateCellPreserveStyle(row, 67, record1.getR10_NO_CON_HIGH_RSK(), null, createHelper);
					row = sheet.getRow(10);

					setMcProgress(progressMap, jobId, 24);
					updateCellPreserveStyle(row, 8, record1.getR11_RET_LOAN_DIS(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR11_RET_ASET_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR11_PER_LOAN_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR11_LOAN_SME_WEB_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR11_NO_COMPDIGI_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR11_NO_COMP_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR11_PER_COMPDIGI_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR11_PER_COM_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR11_TOT_REV_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR11_PROF_LOSS_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR11_PROF_MARG_PORTFOLIO(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR11_TOT_RET_ASET_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR11_NP_LOAN_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR11_NON_CON_ONLAST_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR11_TOT_BRAN_PREV(), null, createHelper);

					updateCellPreserveStyle(row, 51, record1.getR11_NPL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR11_RECO_NPL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR11_NO_CON_ONBO_DIGI(), null, createHelper);
					// updateCellPreserveStyle(row, 54, record1.getR11_NO_ACCS_AML(), null,
					// createHelper);
					updateCellPreserveStyle(row, 55, record1.getR11_TOT_ACC_LOAN_AML(), null, createHelper);
					updateCellPreserveStyle(row, 56, record1.getR11_TOT_NEW_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 57, record1.getR11_TOT_VALS_LOANS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR11_NO_INQ_WEBMOB(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR11_NO_INQ_TRAD(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR11_NO_RET_POS(), null, createHelper);
					updateCellPreserveStyle(row, 61, record1.getR11_AMT_POS_GATE(), null, createHelper);
					updateCellPreserveStyle(row, 62, record1.getR11_NO_TRAN_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 63, record1.getR11_AMT_RET_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 64, record1.getR11_TOT_WEB_MOB_VIRT(), null, createHelper);
					updateCellPreserveStyle(row, 65, record1.getR11_VAL_UNCL_SVF(), null, createHelper);
					updateCellPreserveStyle(row, 66, record1.getR11_NO_CON_LOW_RSK(), null, createHelper);
					updateCellPreserveStyle(row, 67, record1.getR11_NO_CON_HIGH_RSK(), null, createHelper);
					row = sheet.getRow(11);

					updateCellPreserveStyle(row, 8, record1.getR12_RET_LOAN_DIS(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR12_RET_ASET_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR12_PER_LOAN_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR12_LOAN_SME_WEB_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR12_NO_COMPDIGI_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR12_NO_COMP_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR12_PER_COMPDIGI_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR12_PER_COM_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR12_TOT_REV_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR12_PROF_LOSS_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR12_PROF_MARG_PORTFOLIO(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR12_TOT_RET_ASET_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR12_NP_LOAN_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR12_NON_CON_ONLAST_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR12_TOT_BRAN_PREV(), null, createHelper);

					updateCellPreserveStyle(row, 51, record1.getR12_NPL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR12_RECO_NPL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR12_NO_CON_ONBO_DIGI(), null, createHelper);
					// updateCellPreserveStyle(row, 54, record1.getR12_NO_ACCS_AML(), null,
					// createHelper);
					updateCellPreserveStyle(row, 55, record1.getR12_TOT_ACC_LOAN_AML(), null, createHelper);
					updateCellPreserveStyle(row, 56, record1.getR12_TOT_NEW_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 57, record1.getR12_TOT_VALS_LOANS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR12_NO_INQ_WEBMOB(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR12_NO_INQ_TRAD(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR12_NO_RET_POS(), null, createHelper);
					updateCellPreserveStyle(row, 61, record1.getR12_AMT_POS_GATE(), null, createHelper);
					updateCellPreserveStyle(row, 62, record1.getR12_NO_TRAN_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 63, record1.getR12_AMT_RET_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 64, record1.getR12_TOT_WEB_MOB_VIRT(), null, createHelper);
					updateCellPreserveStyle(row, 65, record1.getR12_VAL_UNCL_SVF(), null, createHelper);
					updateCellPreserveStyle(row, 66, record1.getR12_NO_CON_LOW_RSK(), null, createHelper);
					updateCellPreserveStyle(row, 67, record1.getR12_NO_CON_HIGH_RSK(), null, createHelper);
					row = sheet.getRow(12);

					setMcProgress(progressMap, jobId, 36);
					updateCellPreserveStyle(row, 8, record1.getR13_RET_LOAN_DIS(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR13_RET_ASET_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR13_PER_LOAN_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR13_LOAN_SME_WEB_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR13_NO_COMPDIGI_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR13_NO_COMP_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR13_PER_COMPDIGI_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR13_PER_COM_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR13_TOT_REV_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR13_PROF_LOSS_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR13_PROF_MARG_PORTFOLIO(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR13_TOT_RET_ASET_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR13_NP_LOAN_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR13_NON_CON_ONLAST_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR13_TOT_BRAN_PREV(), null, createHelper);

					updateCellPreserveStyle(row, 51, record1.getR13_NPL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR13_RECO_NPL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR13_NO_CON_ONBO_DIGI(), null, createHelper);
					// updateCellPreserveStyle(row, 54, record1.getR13_NO_ACCS_AML(), null,
					// createHelper);
					updateCellPreserveStyle(row, 55, record1.getR13_TOT_ACC_LOAN_AML(), null, createHelper);
					updateCellPreserveStyle(row, 56, record1.getR13_TOT_NEW_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 57, record1.getR13_TOT_VALS_LOANS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR13_NO_INQ_WEBMOB(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR13_NO_INQ_TRAD(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR13_NO_RET_POS(), null, createHelper);
					updateCellPreserveStyle(row, 61, record1.getR13_AMT_POS_GATE(), null, createHelper);
					updateCellPreserveStyle(row, 62, record1.getR13_NO_TRAN_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 63, record1.getR13_AMT_RET_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 64, record1.getR13_TOT_WEB_MOB_VIRT(), null, createHelper);
					updateCellPreserveStyle(row, 65, record1.getR13_VAL_UNCL_SVF(), null, createHelper);
					updateCellPreserveStyle(row, 66, record1.getR13_NO_CON_LOW_RSK(), null, createHelper);
					updateCellPreserveStyle(row, 67, record1.getR13_NO_CON_HIGH_RSK(), null, createHelper);
					row = sheet.getRow(13);

					setMcProgress(progressMap, jobId, 48);
					updateCellPreserveStyle(row, 8, record1.getR14_RET_LOAN_DIS(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR14_RET_ASET_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR14_PER_LOAN_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR14_LOAN_SME_WEB_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR14_NO_COMPDIGI_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR14_NO_COMP_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR14_PER_COMPDIGI_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR14_PER_COM_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR14_TOT_REV_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR14_PROF_LOSS_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR14_PROF_MARG_PORTFOLIO(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR14_TOT_RET_ASET_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR14_NP_LOAN_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR14_NON_CON_ONLAST_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR14_TOT_BRAN_PREV(), null, createHelper);

					updateCellPreserveStyle(row, 51, record1.getR14_NPL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR14_RECO_NPL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR14_NO_CON_ONBO_DIGI(), null, createHelper);
					// updateCellPreserveStyle(row, 54, record1.getR14_NO_ACCS_AML(), null,
					// createHelper);
					updateCellPreserveStyle(row, 55, record1.getR14_TOT_ACC_LOAN_AML(), null, createHelper);
					updateCellPreserveStyle(row, 56, record1.getR14_TOT_NEW_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 57, record1.getR14_TOT_VALS_LOANS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR14_NO_INQ_WEBMOB(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR14_NO_INQ_TRAD(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR14_NO_RET_POS(), null, createHelper);
					updateCellPreserveStyle(row, 61, record1.getR14_AMT_POS_GATE(), null, createHelper);
					updateCellPreserveStyle(row, 62, record1.getR14_NO_TRAN_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 63, record1.getR14_AMT_RET_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 64, record1.getR14_TOT_WEB_MOB_VIRT(), null, createHelper);
					updateCellPreserveStyle(row, 65, record1.getR14_VAL_UNCL_SVF(), null, createHelper);
					updateCellPreserveStyle(row, 66, record1.getR14_NO_CON_LOW_RSK(), null, createHelper);
					updateCellPreserveStyle(row, 67, record1.getR14_NO_CON_HIGH_RSK(), null, createHelper);
					row = sheet.getRow(14);

					updateCellPreserveStyle(row, 8, record1.getR15_RET_LOAN_DIS(), null, createHelper);
					updateCellPreserveStyle(row, 9, record1.getR15_RET_ASET_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 10, record1.getR15_PER_LOAN_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 11, record1.getR15_LOAN_SME_WEB_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 12, record1.getR15_NO_COMPDIGI_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 13, record1.getR15_NO_COMP_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 14, record1.getR15_PER_COMPDIGI_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 15, record1.getR15_PER_COM_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 16, record1.getR15_TOT_REV_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 17, record1.getR15_PROF_LOSS_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 18, record1.getR15_PROF_MARG_PORTFOLIO(), null, createHelper);
					updateCellPreserveStyle(row, 19, record1.getR15_TOT_RET_ASET_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 20, record1.getR15_NP_LOAN_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 21, record1.getR15_NON_CON_ONLAST_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 22, record1.getR15_TOT_BRAN_PREV(), null, createHelper);

					updateCellPreserveStyle(row, 51, record1.getR15_NPL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 52, record1.getR15_RECO_NPL_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 53, record1.getR15_NO_CON_ONBO_DIGI(), null, createHelper);
					// updateCellPreserveStyle(row, 54, record1.getR15_NO_ACCS_AML(), null,
					// createHelper);
					updateCellPreserveStyle(row, 55, record1.getR15_TOT_ACC_LOAN_AML(), null, createHelper);
					updateCellPreserveStyle(row, 56, record1.getR15_TOT_NEW_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 57, record1.getR15_TOT_VALS_LOANS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 58, record1.getR15_NO_INQ_WEBMOB(), null, createHelper);
					updateCellPreserveStyle(row, 59, record1.getR15_NO_INQ_TRAD(), null, createHelper);
					updateCellPreserveStyle(row, 60, record1.getR15_NO_RET_POS(), null, createHelper);
					updateCellPreserveStyle(row, 61, record1.getR15_AMT_POS_GATE(), null, createHelper);
					updateCellPreserveStyle(row, 62, record1.getR15_NO_TRAN_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 63, record1.getR15_AMT_RET_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 64, record1.getR15_TOT_WEB_MOB_VIRT(), null, createHelper);
					updateCellPreserveStyle(row, 65, record1.getR15_VAL_UNCL_SVF(), null, createHelper);
					updateCellPreserveStyle(row, 66, record1.getR15_NO_CON_LOW_RSK(), null, createHelper);
					updateCellPreserveStyle(row, 67, record1.getR15_NO_CON_HIGH_RSK(), null, createHelper);

					row = sheet.getRow(15);

					setMcProgress(progressMap, jobId, 60);
					updateCellPreserveStyle(row, 8, record2.getR16_RET_LOAN_DIS(), null, createHelper);
					updateCellPreserveStyle(row, 9, record2.getR16_RET_ASET_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 10, record2.getR16_PER_LOAN_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 11, record2.getR16_LOAN_SME_WEB_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 12, record2.getR16_NO_COMPDIGI_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 13, record2.getR16_NO_COMP_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 14, record2.getR16_PER_COMPDIGI_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 15, record2.getR16_PER_COM_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 16, record2.getR16_TOT_REV_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 17, record2.getR16_PROF_LOSS_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 18, record2.getR16_PROF_MARG_PORTFOLIO(), null, createHelper);
					updateCellPreserveStyle(row, 19, record2.getR16_TOT_RET_ASET_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 20, record2.getR16_NP_LOAN_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 21, record2.getR16_NON_CON_ONLAST_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 22, record2.getR16_TOT_BRAN_PREV(), null, createHelper);

					// updateCellPreserveStyle(row, 51, record2.getR16_NPL_SPD(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 52, record2.getR16_RECO_NPL_SPD(), null,
					// createHelper);
					updateCellPreserveStyle(row, 53, record2.getR16_NO_CON_ONBO_DIGI(), null, createHelper);
					// updateCellPreserveStyle(row, 54, record2.getR16_NO_ACCS_AML(), null,
					// createHelper);
					updateCellPreserveStyle(row, 55, record2.getR16_TOT_ACC_LOAN_AML(), null, createHelper);
					updateCellPreserveStyle(row, 56, record2.getR16_TOT_NEW_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 57, record2.getR16_TOT_VALS_LOANS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 58, record2.getR16_NO_INQ_WEBMOB(), null, createHelper);
					updateCellPreserveStyle(row, 59, record2.getR16_NO_INQ_TRAD(), null, createHelper);
					updateCellPreserveStyle(row, 60, record2.getR16_NO_RET_POS(), null, createHelper);
					updateCellPreserveStyle(row, 61, record2.getR16_AMT_POS_GATE(), null, createHelper);
					updateCellPreserveStyle(row, 62, record2.getR16_NO_TRAN_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 63, record2.getR16_AMT_RET_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 64, record2.getR16_TOT_WEB_MOB_VIRT(), null, createHelper);
					updateCellPreserveStyle(row, 65, record2.getR16_VAL_UNCL_SVF(), null, createHelper);
					updateCellPreserveStyle(row, 66, record2.getR16_NO_CON_LOW_RSK(), null, createHelper);
					updateCellPreserveStyle(row, 67, record2.getR16_NO_CON_HIGH_RSK(), null, createHelper);
					row = sheet.getRow(16);

					updateCellPreserveStyle(row, 8, record2.getR17_RET_LOAN_DIS(), null, createHelper);
					updateCellPreserveStyle(row, 9, record2.getR17_RET_ASET_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 10, record2.getR17_PER_LOAN_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 11, record2.getR17_LOAN_SME_WEB_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 12, record2.getR17_NO_COMPDIGI_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 13, record2.getR17_NO_COMP_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 14, record2.getR17_PER_COMPDIGI_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 15, record2.getR17_PER_COM_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 16, record2.getR17_TOT_REV_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 17, record2.getR17_PROF_LOSS_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 18, record2.getR17_PROF_MARG_PORTFOLIO(), null, createHelper);
					updateCellPreserveStyle(row, 19, record2.getR17_TOT_RET_ASET_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 20, record2.getR17_NP_LOAN_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 21, record2.getR17_NON_CON_ONLAST_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 22, record2.getR17_TOT_BRAN_PREV(), null, createHelper);

					// updateCellPreserveStyle(row, 51, record2.getR17_NPL_SPD(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 52, record2.getR17_RECO_NPL_SPD(), null,
					// createHelper);
					updateCellPreserveStyle(row, 53, record2.getR17_NO_CON_ONBO_DIGI(), null, createHelper);
					// updateCellPreserveStyle(row, 54, record2.getR17_NO_ACCS_AML(), null,
					// createHelper);
					updateCellPreserveStyle(row, 55, record2.getR17_TOT_ACC_LOAN_AML(), null, createHelper);
					updateCellPreserveStyle(row, 56, record2.getR17_TOT_NEW_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 57, record2.getR17_TOT_VALS_LOANS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 58, record2.getR17_NO_INQ_WEBMOB(), null, createHelper);
					updateCellPreserveStyle(row, 59, record2.getR17_NO_INQ_TRAD(), null, createHelper);
					updateCellPreserveStyle(row, 60, record2.getR17_NO_RET_POS(), null, createHelper);
					updateCellPreserveStyle(row, 61, record2.getR17_AMT_POS_GATE(), null, createHelper);
					updateCellPreserveStyle(row, 62, record2.getR17_NO_TRAN_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 63, record2.getR17_AMT_RET_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 64, record2.getR17_TOT_WEB_MOB_VIRT(), null, createHelper);
					updateCellPreserveStyle(row, 65, record2.getR17_VAL_UNCL_SVF(), null, createHelper);
					updateCellPreserveStyle(row, 66, record2.getR17_NO_CON_LOW_RSK(), null, createHelper);
					updateCellPreserveStyle(row, 67, record2.getR17_NO_CON_HIGH_RSK(), null, createHelper);
					row = sheet.getRow(17);

					setMcProgress(progressMap, jobId, 72);
					updateCellPreserveStyle(row, 8, record2.getR18_RET_LOAN_DIS(), null, createHelper);
					updateCellPreserveStyle(row, 9, record2.getR18_RET_ASET_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 10, record2.getR18_PER_LOAN_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 11, record2.getR18_LOAN_SME_WEB_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 12, record2.getR18_NO_COMPDIGI_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 13, record2.getR18_NO_COMP_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 14, record2.getR18_PER_COMPDIGI_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 15, record2.getR18_PER_COM_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 16, record2.getR18_TOT_REV_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 17, record2.getR18_PROF_LOSS_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 18, record2.getR18_PROF_MARG_PORTFOLIO(), null, createHelper);
					updateCellPreserveStyle(row, 19, record2.getR18_TOT_RET_ASET_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 20, record2.getR18_NP_LOAN_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 21, record2.getR18_NON_CON_ONLAST_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 22, record2.getR18_TOT_BRAN_PREV(), null, createHelper);

					// updateCellPreserveStyle(row, 51, record2.getR18_NPL_SPD(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 52, record2.getR18_RECO_NPL_SPD(), null,
					// createHelper);
					updateCellPreserveStyle(row, 53, record2.getR18_NO_CON_ONBO_DIGI(), null, createHelper);
					// updateCellPreserveStyle(row, 54, record2.getR18_NO_ACCS_AML(), null,
					// createHelper);
					updateCellPreserveStyle(row, 55, record2.getR18_TOT_ACC_LOAN_AML(), null, createHelper);
					updateCellPreserveStyle(row, 56, record2.getR18_TOT_NEW_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 57, record2.getR18_TOT_VALS_LOANS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 58, record2.getR18_NO_INQ_WEBMOB(), null, createHelper);
					updateCellPreserveStyle(row, 59, record2.getR18_NO_INQ_TRAD(), null, createHelper);
					updateCellPreserveStyle(row, 60, record2.getR18_NO_RET_POS(), null, createHelper);
					updateCellPreserveStyle(row, 61, record2.getR18_AMT_POS_GATE(), null, createHelper);
					updateCellPreserveStyle(row, 62, record2.getR18_NO_TRAN_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 63, record2.getR18_AMT_RET_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 64, record2.getR18_TOT_WEB_MOB_VIRT(), null, createHelper);
					updateCellPreserveStyle(row, 65, record2.getR18_VAL_UNCL_SVF(), null, createHelper);
					updateCellPreserveStyle(row, 66, record2.getR18_NO_CON_LOW_RSK(), null, createHelper);
					updateCellPreserveStyle(row, 67, record2.getR18_NO_CON_HIGH_RSK(), null, createHelper);
					row = sheet.getRow(18);

					updateCellPreserveStyle(row, 8, record2.getR19_RET_LOAN_DIS(), null, createHelper);
					updateCellPreserveStyle(row, 9, record2.getR19_RET_ASET_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 10, record2.getR19_PER_LOAN_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 11, record2.getR19_LOAN_SME_WEB_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 12, record2.getR19_NO_COMPDIGI_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 13, record2.getR19_NO_COMP_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 14, record2.getR19_PER_COMPDIGI_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 15, record2.getR19_PER_COM_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 16, record2.getR19_TOT_REV_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 17, record2.getR19_PROF_LOSS_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 18, record2.getR19_PROF_MARG_PORTFOLIO(), null, createHelper);
					updateCellPreserveStyle(row, 19, record2.getR19_TOT_RET_ASET_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 20, record2.getR19_NP_LOAN_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 21, record2.getR19_NON_CON_ONLAST_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 22, record2.getR19_TOT_BRAN_PREV(), null, createHelper);

					// updateCellPreserveStyle(row, 51, record2.getR19_NPL_SPD(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 52, record2.getR19_RECO_NPL_SPD(), null,
					// createHelper);
					updateCellPreserveStyle(row, 53, record2.getR19_NO_CON_ONBO_DIGI(), null, createHelper);
					// updateCellPreserveStyle(row, 54, record2.getR19_NO_ACCS_AML(), null,
					// createHelper);
					updateCellPreserveStyle(row, 55, record2.getR19_TOT_ACC_LOAN_AML(), null, createHelper);
					updateCellPreserveStyle(row, 56, record2.getR19_TOT_NEW_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 57, record2.getR19_TOT_VALS_LOANS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 58, record2.getR19_NO_INQ_WEBMOB(), null, createHelper);
					updateCellPreserveStyle(row, 59, record2.getR19_NO_INQ_TRAD(), null, createHelper);
					updateCellPreserveStyle(row, 60, record2.getR19_NO_RET_POS(), null, createHelper);
					updateCellPreserveStyle(row, 61, record2.getR19_AMT_POS_GATE(), null, createHelper);
					updateCellPreserveStyle(row, 62, record2.getR19_NO_TRAN_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 63, record2.getR19_AMT_RET_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 64, record2.getR19_TOT_WEB_MOB_VIRT(), null, createHelper);
					updateCellPreserveStyle(row, 65, record2.getR19_VAL_UNCL_SVF(), null, createHelper);
					updateCellPreserveStyle(row, 66, record2.getR19_NO_CON_LOW_RSK(), null, createHelper);
					updateCellPreserveStyle(row, 67, record2.getR19_NO_CON_HIGH_RSK(), null, createHelper);
					row = sheet.getRow(19);

					setMcProgress(progressMap, jobId, 84);
					updateCellPreserveStyle(row, 8, record2.getR20_RET_LOAN_DIS(), null, createHelper);
					updateCellPreserveStyle(row, 9, record2.getR20_RET_ASET_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 10, record2.getR20_PER_LOAN_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 11, record2.getR20_LOAN_SME_WEB_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 12, record2.getR20_NO_COMPDIGI_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 13, record2.getR20_NO_COMP_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 14, record2.getR20_PER_COMPDIGI_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 15, record2.getR20_PER_COM_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 16, record2.getR20_TOT_REV_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 17, record2.getR20_PROF_LOSS_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 18, record2.getR20_PROF_MARG_PORTFOLIO(), null, createHelper);
					updateCellPreserveStyle(row, 19, record2.getR20_TOT_RET_ASET_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 20, record2.getR20_NP_LOAN_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 21, record2.getR20_NON_CON_ONLAST_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 22, record2.getR20_TOT_BRAN_PREV(), null, createHelper);

					// updateCellPreserveStyle(row, 51, record2.getR20_NPL_SPD(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 52, record2.getR20_RECO_NPL_SPD(), null,
					// createHelper);
					updateCellPreserveStyle(row, 53, record2.getR20_NO_CON_ONBO_DIGI(), null, createHelper);
					// updateCellPreserveStyle(row, 54, record2.getR20_NO_ACCS_AML(), null,
					// createHelper);
					updateCellPreserveStyle(row, 55, record2.getR20_TOT_ACC_LOAN_AML(), null, createHelper);
					updateCellPreserveStyle(row, 56, record2.getR20_TOT_NEW_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 57, record2.getR20_TOT_VALS_LOANS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 58, record2.getR20_NO_INQ_WEBMOB(), null, createHelper);
					updateCellPreserveStyle(row, 59, record2.getR20_NO_INQ_TRAD(), null, createHelper);
					updateCellPreserveStyle(row, 60, record2.getR20_NO_RET_POS(), null, createHelper);
					updateCellPreserveStyle(row, 61, record2.getR20_AMT_POS_GATE(), null, createHelper);
					updateCellPreserveStyle(row, 62, record2.getR20_NO_TRAN_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 63, record2.getR20_AMT_RET_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 64, record2.getR20_TOT_WEB_MOB_VIRT(), null, createHelper);
					updateCellPreserveStyle(row, 65, record2.getR20_VAL_UNCL_SVF(), null, createHelper);
					updateCellPreserveStyle(row, 66, record2.getR20_NO_CON_LOW_RSK(), null, createHelper);
					updateCellPreserveStyle(row, 67, record2.getR20_NO_CON_HIGH_RSK(), null, createHelper);
					row = sheet.getRow(20);

					updateCellPreserveStyle(row, 8, record2.getR21_RET_LOAN_DIS(), null, createHelper);
					updateCellPreserveStyle(row, 9, record2.getR21_RET_ASET_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 10, record2.getR21_PER_LOAN_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 11, record2.getR21_LOAN_SME_WEB_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 12, record2.getR21_NO_COMPDIGI_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 13, record2.getR21_NO_COMP_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 14, record2.getR21_PER_COMPDIGI_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 15, record2.getR21_PER_COM_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 16, record2.getR21_TOT_REV_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 17, record2.getR21_PROF_LOSS_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 18, record2.getR21_PROF_MARG_PORTFOLIO(), null, createHelper);
					updateCellPreserveStyle(row, 19, record2.getR21_TOT_RET_ASET_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 20, record2.getR21_NP_LOAN_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 21, record2.getR21_NON_CON_ONLAST_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 22, record2.getR21_TOT_BRAN_PREV(), null, createHelper);

					// updateCellPreserveStyle(row, 51, record2.getR21_NPL_SPD(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 52, record2.getR21_RECO_NPL_SPD(), null,
					// createHelper);
					updateCellPreserveStyle(row, 53, record2.getR21_NO_CON_ONBO_DIGI(), null, createHelper);
					// updateCellPreserveStyle(row, 54, record2.getR21_NO_ACCS_AML(), null,
					// createHelper);
					updateCellPreserveStyle(row, 55, record2.getR21_TOT_ACC_LOAN_AML(), null, createHelper);
					updateCellPreserveStyle(row, 56, record2.getR21_TOT_NEW_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 57, record2.getR21_TOT_VALS_LOANS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 58, record2.getR21_NO_INQ_WEBMOB(), null, createHelper);
					updateCellPreserveStyle(row, 59, record2.getR21_NO_INQ_TRAD(), null, createHelper);
					updateCellPreserveStyle(row, 60, record2.getR21_NO_RET_POS(), null, createHelper);
					updateCellPreserveStyle(row, 61, record2.getR21_AMT_POS_GATE(), null, createHelper);
					updateCellPreserveStyle(row, 62, record2.getR21_NO_TRAN_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 63, record2.getR21_AMT_RET_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 64, record2.getR21_TOT_WEB_MOB_VIRT(), null, createHelper);
					updateCellPreserveStyle(row, 65, record2.getR21_VAL_UNCL_SVF(), null, createHelper);
					updateCellPreserveStyle(row, 66, record2.getR21_NO_CON_LOW_RSK(), null, createHelper);
					updateCellPreserveStyle(row, 67, record2.getR21_NO_CON_HIGH_RSK(), null, createHelper);
					row = sheet.getRow(21);

					setMcProgress(progressMap, jobId, 90);
					updateCellPreserveStyle(row, 8, record2.getR22_RET_LOAN_DIS(), null, createHelper);
					updateCellPreserveStyle(row, 9, record2.getR22_RET_ASET_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 10, record2.getR22_PER_LOAN_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 11, record2.getR22_LOAN_SME_WEB_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 12, record2.getR22_NO_COMPDIGI_MOB(), null, createHelper);
					updateCellPreserveStyle(row, 13, record2.getR22_NO_COMP_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 14, record2.getR22_PER_COMPDIGI_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 15, record2.getR22_PER_COM_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 16, record2.getR22_TOT_REV_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 17, record2.getR22_PROF_LOSS_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 18, record2.getR22_PROF_MARG_PORTFOLIO(), null, createHelper);
					updateCellPreserveStyle(row, 19, record2.getR22_TOT_RET_ASET_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 20, record2.getR22_NP_LOAN_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 21, record2.getR22_NON_CON_ONLAST_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 22, record2.getR22_TOT_BRAN_PREV(), null, createHelper);

					// updateCellPreserveStyle(row, 51, record2.getR22_NPL_SPD(), null,
					// createHelper);
					// updateCellPreserveStyle(row, 52, record2.getR22_RECO_NPL_SPD(), null,
					// createHelper);
					updateCellPreserveStyle(row, 53, record2.getR22_NO_CON_ONBO_DIGI(), null, createHelper);
					// updateCellPreserveStyle(row, 54, record2.getR22_NO_ACCS_AML(), null,
					// createHelper);
					updateCellPreserveStyle(row, 55, record2.getR22_TOT_ACC_LOAN_AML(), null, createHelper);
					updateCellPreserveStyle(row, 56, record2.getR22_TOT_NEW_ACCS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 57, record2.getR22_TOT_VALS_LOANS_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 58, record2.getR22_NO_INQ_WEBMOB(), null, createHelper);
					updateCellPreserveStyle(row, 59, record2.getR22_NO_INQ_TRAD(), null, createHelper);
					updateCellPreserveStyle(row, 60, record2.getR22_NO_RET_POS(), null, createHelper);
					updateCellPreserveStyle(row, 61, record2.getR22_AMT_POS_GATE(), null, createHelper);
					updateCellPreserveStyle(row, 62, record2.getR22_NO_TRAN_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 63, record2.getR22_AMT_RET_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 64, record2.getR22_TOT_WEB_MOB_VIRT(), null, createHelper);
					updateCellPreserveStyle(row, 65, record2.getR22_VAL_UNCL_SVF(), null, createHelper);
					updateCellPreserveStyle(row, 66, record2.getR22_NO_CON_LOW_RSK(), null, createHelper);
					updateCellPreserveStyle(row, 67, record2.getR22_NO_CON_HIGH_RSK(), null, createHelper);
					row = sheet.getRow(22);

					updateCellPreserveStyle(row, 5, record2.getR23_RET_ASET_LTS(), null, createHelper);
					updateCellPreserveStyle(row, 6, record2.getR23_RET_ASET_LTSME(), null, createHelper);
					updateCellPreserveStyle(row, 7, record2.getR23_RET_ASET_SME_GUR(), null, createHelper);
//					updateCellPreserveStyle(row, 8, record2.getR23_RET_LOAN_DIS(), null, createHelper);
//					updateCellPreserveStyle(row, 9, record2.getR23_RET_ASET_LOAN_SME(), null, createHelper);
//					updateCellPreserveStyle(row, 10, record2.getR23_PER_LOAN_WEB(), null, createHelper);
//					updateCellPreserveStyle(row, 11, record2.getR23_LOAN_SME_WEB_MOB(), null, createHelper);
//					updateCellPreserveStyle(row, 12, record2.getR23_NO_COMPDIGI_MOB(), null, createHelper);
//					updateCellPreserveStyle(row, 13, record2.getR23_NO_COMP_TRADCALL(), null, createHelper);
					updateCellPreserveStyle(row, 14, record2.getR23_PER_COMPDIGI_WEB(), null, createHelper);
					updateCellPreserveStyle(row, 15, record2.getR23_PER_COM_TRADCALL(), null, createHelper);
//					updateCellPreserveStyle(row, 16, record2.getR23_TOT_REV_PREV(), null, createHelper);
//					updateCellPreserveStyle(row, 17, record2.getR23_PROF_LOSS_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 18, record2.getR23_PROF_MARG_PORTFOLIO(), null, createHelper);
					updateCellPreserveStyle(row, 19, record2.getR23_TOT_RET_ASET_PREV(), null, createHelper);
//					updateCellPreserveStyle(row, 20, record2.getR23_NP_LOAN_PREV(), null, createHelper);
//					updateCellPreserveStyle(row, 21, record2.getR23_NON_CON_ONLAST_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 22, record2.getR23_TOT_BRAN_PREV(), null, createHelper);
					updateCellPreserveStyle(row, 23, record2.getR23_TOT_REV_RET_CUR(), null, createHelper);
					updateCellPreserveStyle(row, 24, record2.getR23_PROF_LOS_PORT_CUR(), null, createHelper);
					updateCellPreserveStyle(row, 25, record2.getR23_PROF_MARG_PERC_CUR(), null, createHelper);
					updateCellPreserveStyle(row, 26, record2.getR23_TOT_RET_ASET_CUR(), null, createHelper);
					updateCellPreserveStyle(row, 27, record2.getR23_NON_PER_RET_PORT_CUR(), null, createHelper);
					updateCellPreserveStyle(row, 28, record2.getR23_NO_CON_LAST_CUR(), null, createHelper);
					updateCellPreserveStyle(row, 29, record2.getR23_TOT_BRANCH_CUR(), null, createHelper);
					updateCellPreserveStyle(row, 30, record2.getR23_TOT_REV_T1(), null, createHelper);
					updateCellPreserveStyle(row, 31, record2.getR23_PROF_LOS_T1(), null, createHelper);
					updateCellPreserveStyle(row, 32, record2.getR23_PROF_MARG_T1(), null, createHelper);
					updateCellPreserveStyle(row, 33, record2.getR23_TOT_RET_ASET_T1(), null, createHelper);
					updateCellPreserveStyle(row, 34, record2.getR23_NON_PERF_PORT_T1(), null, createHelper);
					updateCellPreserveStyle(row, 35, record2.getR23_NO_CON_LAST_T1(), null, createHelper);
					updateCellPreserveStyle(row, 36, record2.getR23_TOT_BRANCH_T1(), null, createHelper);
					updateCellPreserveStyle(row, 37, record2.getR23_TOT_REV_T2(), null, createHelper);
					updateCellPreserveStyle(row, 38, record2.getR23_PROF_LOS_T2(), null, createHelper);
					updateCellPreserveStyle(row, 39, record2.getR23_PROF_MARG_T2(), null, createHelper);
					updateCellPreserveStyle(row, 40, record2.getR23_TOT_RET_ASET_T2(), null, createHelper);
					updateCellPreserveStyle(row, 41, record2.getR23_NON_PERF_PORT_T2(), null, createHelper);
					updateCellPreserveStyle(row, 42, record2.getR23_NO_CON_LAST_T2(), null, createHelper);
					updateCellPreserveStyle(row, 43, record2.getR23_TOT_BRANCH_T2(), null, createHelper);
					updateCellPreserveStyle(row, 44, record2.getR23_TOT_REV_T3(), null, createHelper);
					updateCellPreserveStyle(row, 45, record2.getR23_PROF_LOS_T3(), null, createHelper);
					updateCellPreserveStyle(row, 46, record2.getR23_PROF_MARG_T3(), null, createHelper);
					updateCellPreserveStyle(row, 47, record2.getR23_TOT_RET_ASET_T3(), null, createHelper);
					updateCellPreserveStyle(row, 48, record2.getR23_NON_PERF_PORT_T3(), null, createHelper);
					updateCellPreserveStyle(row, 49, record2.getR23_NO_CON_LAST_T3(), null, createHelper);
					updateCellPreserveStyle(row, 50, record2.getR23_TOT_BRANCH_T3(), null, createHelper);
//					updateCellPreserveStyle(row, 51, record2.getR23_NPL_SPD(), null, createHelper);
//					updateCellPreserveStyle(row, 52, record2.getR23_RECO_NPL_SPD(), null, createHelper);
//					updateCellPreserveStyle(row, 53, record2.getR23_NO_CON_ONBO_DIGI(), null, createHelper);
//					updateCellPreserveStyle(row, 54, record2.getR23_NO_ACCS_AML(), null, createHelper);
//					updateCellPreserveStyle(row, 55, record2.getR23_TOT_ACC_LOAN_AML(), null, createHelper);
//					updateCellPreserveStyle(row, 56, record2.getR23_TOT_NEW_ACCS_SPD(), null, createHelper);
//					updateCellPreserveStyle(row, 57, record2.getR23_TOT_VALS_LOANS_SPD(), null, createHelper);
//					updateCellPreserveStyle(row, 58, record2.getR23_NO_INQ_WEBMOB(), null, createHelper);
//					updateCellPreserveStyle(row, 59, record2.getR23_NO_INQ_TRAD(), null, createHelper);
//					updateCellPreserveStyle(row, 60, record2.getR23_NO_RET_POS(), null, createHelper);
//					updateCellPreserveStyle(row, 61, record2.getR23_AMT_POS_GATE(), null, createHelper);
//					updateCellPreserveStyle(row, 62, record2.getR23_NO_TRAN_SVF_BNK(), null, createHelper);
//					updateCellPreserveStyle(row, 63, record2.getR23_AMT_RET_SVF_BNK(), null, createHelper);
					updateCellPreserveStyle(row, 64, record2.getR23_TOT_WEB_MOB_VIRT(), null, createHelper);
//					updateCellPreserveStyle(row, 65, record2.getR23_VAL_UNCL_SVF(), null, createHelper);
//					updateCellPreserveStyle(row, 66, record2.getR23_NO_CON_LOW_RSK(), null, createHelper);
//					updateCellPreserveStyle(row, 67, record2.getR23_NO_CON_HIGH_RSK(), null, createHelper);

				}
				evaluateMcFormulas(workbook, jobId);
			} else {

			}

			
		} catch (Exception e) {
			logger.error("MC download jobId={} excel write failed reportDate={} branch={} formmode={}", jobId,
					reportDate, branch, formmode, e);
			throw e;
		}

	}

	public void GenerateTable_8_Excel(Workbook workbook,String branch, String jobId, Map<String, Integer> progressMap, String formmode,
			String reportDate, String isConsolidated, String reportOption, String selectedDepartments) throws Exception {
//		logMcDownload(jobId, "fetching database rows", reportDate, branch, isConsolidated, formmode);
//
//		List<RT_MC_TABLE8_ENTITY> dataList ;
//		
//		if (branch =="DEPT" || branch.equals("DEPT")) {
//			dataList = RT_MC_TABLE8_REPO.findBybranchcode(branch);
//		}
//		else {
//			dataList = RT_MC_TABLE8_REPO.findByReportDateAndBranchCode(reportDate, branch);
//		}
//		if (dataList.isEmpty()) {
//			logger.warn("Service: No data found for MC report. Returning empty result.");
//			return;
//		}

		logMcDownload(jobId, "fetching database rows", reportDate, branch, isConsolidated, formmode);
	    List<RT_MC_TABLE8_ENTITY> dataList = new ArrayList<>();

	    if ("YES".equalsIgnoreCase(isConsolidated)) {
	        
	        List<RT_MC_TABLE8_ENTITY> numData = RT_MC_TABLE8_REPO.findByReportDateAndBranchCode(reportDate, branch);
	        List<RT_MC_TABLE8_ENTITY> deptData = RT_MC_TABLE8_REPO.findBybranchcode("DEPT");
	        
	        dataList = mergeReportData(numData, deptData, reportOption, selectedDepartments, RT_MC_TABLE8_ENTITY.class);
	        
	    } else {
	        if ("DEPT".equals(branch)) {
	            dataList = RT_MC_TABLE8_REPO.findBybranchcode(branch);
	        } else {
	            dataList = RT_MC_TABLE8_REPO.findByReportDateAndBranchCode(reportDate, branch);
	        }
	    }

	    if (dataList == null || dataList.isEmpty()) {
	        logger.warn("MC download jobId={} no rows after fetch. reportDate={} branch={} formmode={}", jobId,
	        		reportDate, branch, formmode);
	        return;
	    }
	    logger.info("MC download jobId={} fetched {} rows. Sheet write starts next.", jobId, dataList.size());
		

		try{

			Sheet sheet = openMcSheet(workbook, jobId, 10);

			// --- Style Definitions ---
			CreationHelper createHelper = workbook.getCreationHelper();

			CellStyle dateStyle = workbook.createCellStyle();
			dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
			dateStyle.setBorderBottom(BorderStyle.THIN);
			dateStyle.setBorderTop(BorderStyle.THIN);
			dateStyle.setBorderLeft(BorderStyle.THIN);
			dateStyle.setBorderRight(BorderStyle.THIN);

			CellStyle textStyle = workbook.createCellStyle();
			textStyle.setBorderBottom(BorderStyle.THIN);
			textStyle.setBorderTop(BorderStyle.THIN);
			textStyle.setBorderLeft(BorderStyle.THIN);
			textStyle.setBorderRight(BorderStyle.THIN);

			// Create the font
			Font font = workbook.createFont();
			font.setFontHeightInPoints((short) 8); // size 8
			font.setFontName("Arial");

			CellStyle numberStyle = workbook.createCellStyle();
			// numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("0.000"));
			numberStyle.setBorderBottom(BorderStyle.THIN);
			numberStyle.setBorderTop(BorderStyle.THIN);
			numberStyle.setBorderLeft(BorderStyle.THIN);
			numberStyle.setBorderRight(BorderStyle.THIN);
			numberStyle.setFont(font);
			// --- End of Style Definitions ---

			int startRow = 7;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {
					RT_MC_TABLE8_ENTITY record = dataList.get(i);
					System.out.println("rownumber=" + startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}
					setMcProgress(progressMap, jobId, 5, "writing row " + (i + 1) + " excelRow " + (startRow + i));

					updateCellPreserveStyle(row, 5, record.getR8_NO_RET_CON_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR8_NO_ISC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR8_NO_SME_CON_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR8_NO_SME_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR8_TOT_AGE_OUT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR8_TOT_PONT_SALE(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR8_TOT_MER_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR8_RET_SIZE_ISC_AED(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR8_RET_ASSE_LON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR8_RET_ASSE_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR8_NO_COMP_ISLAMIC(), null, createHelper);

					row = sheet.getRow(8);
					updateCellPreserveStyle(row, 5, record.getR9_NO_RET_CON_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR9_NO_ISC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR9_NO_SME_CON_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR9_NO_SME_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR9_TOT_AGE_OUT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR9_TOT_PONT_SALE(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR9_TOT_MER_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR9_RET_SIZE_ISC_AED(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR9_RET_ASSE_LON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR9_RET_ASSE_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR9_NO_COMP_ISLAMIC(), null, createHelper);

					setMcProgress(progressMap, jobId, 12);
					row = sheet.getRow(9);
					updateCellPreserveStyle(row, 5, record.getR10_NO_RET_CON_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR10_NO_ISC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR10_NO_SME_CON_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR10_NO_SME_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR10_TOT_AGE_OUT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR10_TOT_PONT_SALE(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR10_TOT_MER_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR10_RET_SIZE_ISC_AED(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR10_RET_ASSE_LON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR10_RET_ASSE_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR10_NO_COMP_ISLAMIC(), null, createHelper);

					row = sheet.getRow(10);
					updateCellPreserveStyle(row, 5, record.getR11_NO_RET_CON_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR11_NO_ISC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR11_NO_SME_CON_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR11_NO_SME_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR11_TOT_AGE_OUT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR11_TOT_PONT_SALE(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR11_TOT_MER_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR11_RET_SIZE_ISC_AED(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR11_RET_ASSE_LON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR11_RET_ASSE_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR11_NO_COMP_ISLAMIC(), null, createHelper);

					setMcProgress(progressMap, jobId, 24);
					row = sheet.getRow(11);
					updateCellPreserveStyle(row, 5, record.getR12_NO_RET_CON_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR12_NO_ISC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR12_NO_SME_CON_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR12_NO_SME_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR12_TOT_AGE_OUT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR12_TOT_PONT_SALE(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR12_TOT_MER_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR12_RET_SIZE_ISC_AED(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR12_RET_ASSE_LON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR12_RET_ASSE_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR12_NO_COMP_ISLAMIC(), null, createHelper);
					row = sheet.getRow(12);
					updateCellPreserveStyle(row, 5, record.getR13_NO_RET_CON_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR13_NO_ISC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR13_NO_SME_CON_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR13_NO_SME_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR13_TOT_AGE_OUT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR13_TOT_PONT_SALE(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR13_TOT_MER_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR13_RET_SIZE_ISC_AED(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR13_RET_ASSE_LON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR13_RET_ASSE_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR13_NO_COMP_ISLAMIC(), null, createHelper);

					setMcProgress(progressMap, jobId, 36);
					row = sheet.getRow(13);
					updateCellPreserveStyle(row, 5, record.getR14_NO_RET_CON_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR14_NO_ISC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR14_NO_SME_CON_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR14_NO_SME_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR14_TOT_AGE_OUT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR14_TOT_PONT_SALE(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR14_TOT_MER_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR14_RET_SIZE_ISC_AED(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR14_RET_ASSE_LON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR14_RET_ASSE_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR14_NO_COMP_ISLAMIC(), null, createHelper);

					row = sheet.getRow(14);
					updateCellPreserveStyle(row, 5, record.getR15_NO_RET_CON_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR15_NO_ISC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR15_NO_SME_CON_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR15_NO_SME_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR15_TOT_AGE_OUT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR15_TOT_PONT_SALE(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR15_TOT_MER_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR15_RET_SIZE_ISC_AED(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR15_RET_ASSE_LON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR15_RET_ASSE_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR15_NO_COMP_ISLAMIC(), null, createHelper);

					setMcProgress(progressMap, jobId, 48);
					row = sheet.getRow(15);
					updateCellPreserveStyle(row, 5, record.getR16_NO_RET_CON_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR16_NO_ISC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR16_NO_SME_CON_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR16_NO_SME_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR16_TOT_AGE_OUT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR16_TOT_PONT_SALE(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR16_TOT_MER_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR16_RET_SIZE_ISC_AED(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR16_RET_ASSE_LON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR16_RET_ASSE_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR16_NO_COMP_ISLAMIC(), null, createHelper);

					row = sheet.getRow(16);
					updateCellPreserveStyle(row, 5, record.getR17_NO_RET_CON_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR17_NO_ISC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR17_NO_SME_CON_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR17_NO_SME_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR17_TOT_AGE_OUT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR17_TOT_PONT_SALE(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR17_TOT_MER_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR17_RET_SIZE_ISC_AED(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR17_RET_ASSE_LON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR17_RET_ASSE_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR17_NO_COMP_ISLAMIC(), null, createHelper);

					setMcProgress(progressMap, jobId, 60);
					row = sheet.getRow(17);
					updateCellPreserveStyle(row, 5, record.getR18_NO_RET_CON_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR18_NO_ISC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR18_NO_SME_CON_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR18_NO_SME_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR18_TOT_AGE_OUT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR18_TOT_PONT_SALE(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR18_TOT_MER_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR18_RET_SIZE_ISC_AED(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR18_RET_ASSE_LON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR18_RET_ASSE_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR18_NO_COMP_ISLAMIC(), null, createHelper);

					row = sheet.getRow(18);
					updateCellPreserveStyle(row, 5, record.getR19_NO_RET_CON_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR19_NO_ISC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR19_NO_SME_CON_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR19_NO_SME_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR19_TOT_AGE_OUT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR19_TOT_PONT_SALE(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR19_TOT_MER_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR19_RET_SIZE_ISC_AED(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR19_RET_ASSE_LON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR19_RET_ASSE_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR19_NO_COMP_ISLAMIC(), null, createHelper);

					setMcProgress(progressMap, jobId, 72);
					row = sheet.getRow(19);
					updateCellPreserveStyle(row, 5, record.getR20_NO_RET_CON_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR20_NO_ISC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR20_NO_SME_CON_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR20_NO_SME_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR20_TOT_AGE_OUT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR20_TOT_PONT_SALE(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR20_TOT_MER_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR20_RET_SIZE_ISC_AED(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR20_RET_ASSE_LON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR20_RET_ASSE_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR20_NO_COMP_ISLAMIC(), null, createHelper);

					row = sheet.getRow(20);
					updateCellPreserveStyle(row, 5, record.getR21_NO_RET_CON_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR21_NO_ISC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR21_NO_SME_CON_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR21_NO_SME_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR21_TOT_AGE_OUT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR21_TOT_PONT_SALE(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR21_TOT_MER_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR21_RET_SIZE_ISC_AED(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR21_RET_ASSE_LON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR21_RET_ASSE_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR21_NO_COMP_ISLAMIC(), null, createHelper);

					setMcProgress(progressMap, jobId, 84);
					row = sheet.getRow(21);
					updateCellPreserveStyle(row, 5, record.getR22_NO_RET_CON_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR22_NO_ISC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR22_NO_SME_CON_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR22_NO_SME_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR22_TOT_AGE_OUT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR22_TOT_PONT_SALE(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR22_TOT_MER_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR22_RET_SIZE_ISC_AED(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR22_RET_ASSE_LON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR22_RET_ASSE_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR22_NO_COMP_ISLAMIC(), null, createHelper);

					row = sheet.getRow(22);
					updateCellPreserveStyle(row, 5, record.getR23_NO_RET_CON_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR23_NO_ISC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR23_NO_SME_CON_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR23_NO_SME_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR23_TOT_AGE_OUT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR23_TOT_PONT_SALE(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR23_TOT_MER_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR23_RET_SIZE_ISC_AED(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR23_RET_ASSE_LON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR23_RET_ASSE_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR23_NO_COMP_ISLAMIC(), null, createHelper);

					setMcProgress(progressMap, jobId, 96);
					row = sheet.getRow(23);
					updateCellPreserveStyle(row, 5, record.getR24_NO_RET_CON_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 6, record.getR24_NO_ISC_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 7, record.getR24_NO_SME_CON_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 8, record.getR24_NO_SME_ISC(), null, createHelper);
					updateCellPreserveStyle(row, 9, record.getR24_TOT_AGE_OUT(), null, createHelper);
					updateCellPreserveStyle(row, 10, record.getR24_TOT_PONT_SALE(), null, createHelper);
					updateCellPreserveStyle(row, 11, record.getR24_TOT_MER_SPD(), null, createHelper);
					updateCellPreserveStyle(row, 12, record.getR24_RET_SIZE_ISC_AED(), null, createHelper);
					updateCellPreserveStyle(row, 13, record.getR24_RET_ASSE_LON_RET(), null, createHelper);
					updateCellPreserveStyle(row, 14, record.getR24_RET_ASSE_LOAN_SME(), null, createHelper);
					updateCellPreserveStyle(row, 15, record.getR24_NO_COMP_ISLAMIC(), null, createHelper);

				}
				evaluateMcFormulas(workbook, jobId);
			} else {

			}

		
		} catch (Exception e) {
			logger.error("MC download jobId={} excel write failed reportDate={} branch={} formmode={}", jobId,
					reportDate, branch, formmode, e);
			throw e;
		}

	}

	public void GenerateTable_9_Excel(Workbook workbook,String branch, String jobId, Map<String, Integer> progressMap, String formmode,
			String reportDate, String isConsolidated, String reportOption, String selectedDepartments) throws Exception {
//		logMcDownload(jobId, "fetching database rows", reportDate, branch, isConsolidated, formmode);
//
//		List<RT_MC_TABLE9_ENTITY> dataList ;
//
//		if (branch =="DEPT" || branch.equals("DEPT")) {
//			dataList = RT_MC_TABLE9_REPO.findBybranchcode(branch);
//		}
//		else {
//			dataList = RT_MC_TABLE9_REPO.findByReportDateAndBranchCode(reportDate, branch);
//		}
//		if (dataList.isEmpty()) {
//			logger.warn("Service: No data found for MC report. Returning empty result.");
//			return;
//		}

		logMcDownload(jobId, "fetching database rows", reportDate, branch, isConsolidated, formmode);
	    List<RT_MC_TABLE9_ENTITY> dataList = new ArrayList<>();

	    if ("YES".equalsIgnoreCase(isConsolidated)) {
	        
	        List<RT_MC_TABLE9_ENTITY> numData = RT_MC_TABLE9_REPO.findByReportDateAndBranchCode(reportDate, branch);
	        List<RT_MC_TABLE9_ENTITY> deptData = RT_MC_TABLE9_REPO.findBybranchcode("DEPT");
	        
	        dataList = mergeReportData(numData, deptData, reportOption, selectedDepartments, RT_MC_TABLE9_ENTITY.class);
	        
	    } else {
	        if ("DEPT".equals(branch)) {
	            dataList = RT_MC_TABLE9_REPO.findBybranchcode(branch);
	        } else {
	            dataList = RT_MC_TABLE9_REPO.findByReportDateAndBranchCode(reportDate, branch);
	        }
	    }

	    if (dataList == null || dataList.isEmpty()) {
	        logger.warn("MC download jobId={} no rows after fetch. reportDate={} branch={} formmode={}", jobId,
	        		reportDate, branch, formmode);
	        return;
	    }
	    logger.info("MC download jobId={} fetched {} rows. Sheet write starts next.", jobId, dataList.size());
		
		try {

			Sheet sheet = openMcSheet(workbook, jobId, 11);

			// --- Style Definitions ---
			CreationHelper createHelper = workbook.getCreationHelper();

			CellStyle dateStyle = workbook.createCellStyle();
			dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
			dateStyle.setBorderBottom(BorderStyle.THIN);
			dateStyle.setBorderTop(BorderStyle.THIN);
			dateStyle.setBorderLeft(BorderStyle.THIN);
			dateStyle.setBorderRight(BorderStyle.THIN);

			CellStyle textStyle = workbook.createCellStyle();
			textStyle.setBorderBottom(BorderStyle.THIN);
			textStyle.setBorderTop(BorderStyle.THIN);
			textStyle.setBorderLeft(BorderStyle.THIN);
			textStyle.setBorderRight(BorderStyle.THIN);

			// Create the font
			Font font = workbook.createFont();
			font.setFontHeightInPoints((short) 8); // size 8
			font.setFontName("Arial");

			CellStyle numberStyle = workbook.createCellStyle();
			// numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("0.000"));
			numberStyle.setBorderBottom(BorderStyle.THIN);
			numberStyle.setBorderTop(BorderStyle.THIN);
			numberStyle.setBorderLeft(BorderStyle.THIN);
			numberStyle.setBorderRight(BorderStyle.THIN);
			numberStyle.setFont(font);
			// --- End of Style Definitions ---
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date reportDatedf = dateFormat.parse(reportDate);
			logger.info("MC download jobId={} table 9 loading past records formmode={} branch={} reportDate={}", jobId,
					formmode, branch, reportDate);
			long pastStarted = System.currentTimeMillis();
			List<RecordMetadataProjection> pastRecord = RT_MC_DATA_RECORD_REPO
					.findByFormModeAndTimeperiodAndReportDateOrderByReportDateDesc(
							formmode, branch, reportDatedf);
			logger.info("MC download jobId={} table 9 past records={} elapsedMs={}", jobId,
					pastRecord == null ? 0 : pastRecord.size(), System.currentTimeMillis() - pastStarted);
			int startRow = 8;

			if (!dataList.isEmpty() && !pastRecord.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {
					RT_MC_TABLE9_ENTITY record = dataList.get(i);
					System.out.println("rownumber=" + startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}
					setMcProgress(progressMap, jobId, 5, "writing row " + (i + 1) + " excelRow " + (startRow + i));
					
					updateCellPreserveStyle(row, 4, record.getR9_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R9_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(9);

					updateCellPreserveStyle(row, 4, record.getR10_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R10_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(10);

					updateCellPreserveStyle(row, 4, record.getR11_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R11_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(11);

					updateCellPreserveStyle(row, 4, record.getR12_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R12_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(12);

					updateCellPreserveStyle(row, 4, record.getR13_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R13_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(13);

					updateCellPreserveStyle(row, 4, record.getR14_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R14_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(14);

					setMcProgress(progressMap, jobId, 10);
					updateCellPreserveStyle(row, 4, record.getR15_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R15_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(15);

					updateCellPreserveStyle(row, 4, record.getR16_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R16_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(16);

					updateCellPreserveStyle(row, 4, record.getR17_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R17_EVID_PRO_LFI"), null, createHelper);

					row = sheet.getRow(19);

					setMcProgress(progressMap, jobId, 15);
					updateCellPreserveStyle(row, 4, record.getR20_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R20_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(20);

					updateCellPreserveStyle(row, 4, record.getR21_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R21_EVID_PRO_LFI"), null, createHelper);

					row = sheet.getRow(23);

					updateCellPreserveStyle(row, 4, record.getR24_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R24_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(24);

					updateCellPreserveStyle(row, 4, record.getR25_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R25_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(25);

					updateCellPreserveStyle(row, 4, record.getR26_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R26_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(26);

					updateCellPreserveStyle(row, 4, record.getR27_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R27_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(27);

					updateCellPreserveStyle(row, 4, record.getR28_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R28_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(28);

					updateCellPreserveStyle(row, 4, record.getR29_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R29_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(29);

					setMcProgress(progressMap, jobId, 35);
					updateCellPreserveStyle(row, 4, record.getR30_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R30_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(30);

					updateCellPreserveStyle(row, 4, record.getR31_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R31_EVID_PRO_LFI"), null, createHelper);

					row = sheet.getRow(33);

					updateCellPreserveStyle(row, 4, record.getR34_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R34_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(34);

					updateCellPreserveStyle(row, 4, record.getR35_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R35_EVID_PRO_LFI"), null, createHelper);

					row = sheet.getRow(37);

					updateCellPreserveStyle(row, 4, record.getR38_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R38_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(38);

					updateCellPreserveStyle(row, 4, record.getR39_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R39_EVID_PRO_LFI"), null, createHelper);

					row = sheet.getRow(41);

					updateCellPreserveStyle(row, 4, record.getR42_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R42_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(42);

					updateCellPreserveStyle(row, 4, record.getR43_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R43_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(43);

					updateCellPreserveStyle(row, 4, record.getR44_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R44_EVID_PRO_LFI"), null, createHelper);

					row = sheet.getRow(46);

					updateCellPreserveStyle(row, 4, record.getR47_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R47_EVID_PRO_LFI"), null, createHelper);

					row = sheet.getRow(49);

					setMcProgress(progressMap, jobId, 70);
					updateCellPreserveStyle(row, 4, record.getR50_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R50_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(50);

					updateCellPreserveStyle(row, 4, record.getR51_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R51_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(51);

					updateCellPreserveStyle(row, 4, record.getR52_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R52_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(52);

					updateCellPreserveStyle(row, 4, record.getR53_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R53_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(53);

					updateCellPreserveStyle(row, 4, record.getR54_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R54_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(54);

					updateCellPreserveStyle(row, 4, record.getR55_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R55_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(55);

					updateCellPreserveStyle(row, 4, record.getR56_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R56_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(56);

					updateCellPreserveStyle(row, 4, record.getR57_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R57_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(57);

					updateCellPreserveStyle(row, 4, record.getR58_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R58_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(58);

					updateCellPreserveStyle(row, 4, record.getR59_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R59_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(59);

					setMcProgress(progressMap, jobId, 90);
					updateCellPreserveStyle(row, 4, record.getR60_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R60_EVID_PRO_LFI"), null, createHelper);
					row = sheet.getRow(60);

					updateCellPreserveStyle(row, 4, record.getR61_LFI_RESP(), null, createHelper);
					updateCellPreserveStyle(row, 5, buildDisplayValueWithFiles(pastRecord,"R61_EVID_PRO_LFI"), null, createHelper);

				}
				evaluateMcFormulas(workbook, jobId);
			} else {

			}

			

		} catch (Exception e) {
			logger.error("MC download jobId={} excel write failed reportDate={} branch={} formmode={}", jobId,
					reportDate, branch, formmode, e);
			throw e;
		}

	}

	private String buildDisplayValueWithFiles(List<RecordMetadataProjection> records, String name) {
		RecordMetadataProjection record = records.stream().filter(d -> name.equals(d.getCellName())).findFirst()
				.orElse(null);
		StringBuilder sb = new StringBuilder();
		if (record != null) {

			sb.append(record.getDataValue() != null ? record.getDataValue() : "");

			List<String> fileNames = Arrays.asList(record.getFileName1(), record.getFileName2(), record.getFileName3(),
					record.getFileName4(), record.getFileName5(), record.getFileName6(), record.getFileName7(),
					record.getFileName8(), record.getFileName9(), record.getFileName10());

			List<String> nonBlank = fileNames.stream().filter(fn -> fn != null && !fn.trim().isEmpty())
					.map(String::trim).map(this::stripExtension).collect(Collectors.toList());

			if (!nonBlank.isEmpty()) {
				sb.append("\n\n").append(String.join("\n", nonBlank));
			}
		}
		return sb.toString();
	}

	private String stripExtension(String fileName) {
		int lastDot = fileName.lastIndexOf('.');
		return (lastDot > 0) ? fileName.substring(0, lastDot) : fileName;
	}

	private void logMcDownload(String jobId, String step, String reportDate, String branch, String isConsolidated,
			String formmode) {
		logger.info("MC download jobId={} {} reportDate={} branch={} consolidated={} formmode={}", jobId, step,
				reportDate, branch, isConsolidated, formmode);
	}

	private void setMcProgress(Map<String, Integer> progressMap, String jobId, int percent) {
		setMcProgress(progressMap, jobId, percent, null);
	}

	private void setMcProgress(Map<String, Integer> progressMap, String jobId, int percent, String detail) {
		progressMap.put(jobId, percent);
		if (detail == null || detail.isEmpty()) {
			logger.info("MC download jobId={} progress={}%", jobId, percent);
		} else {
			logger.info("MC download jobId={} progress={}% {}", jobId, percent, detail);
		}
	}

	private Sheet openMcSheet(Workbook workbook, String jobId, int index) {
		long started = System.currentTimeMillis();
		logger.info("MC download jobId={} opening sheet index {}", jobId, index);
		Sheet sheet = workbook.getSheetAt(index);
		logger.info("MC download jobId={} sheet index {} name='{}' opened elapsedMs={}", jobId, index,
				sheet == null ? "" : sheet.getSheetName(), System.currentTimeMillis() - started);
		return sheet;
	}

	private void evaluateMcFormulas(Workbook workbook, String jobId) {
		long started = System.currentTimeMillis();
		logger.info("MC download jobId={} formula evaluation START", jobId);
		workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
		logger.info("MC download jobId={} formula evaluation END elapsedMs={}", jobId,
				System.currentTimeMillis() - started);
	}

	private void updateCellPreserveStyle(Row row, int colIndex, Object value, String formatStr, CreationHelper helper) {
		Cell cell = (row.getCell(colIndex) != null) ? row.getCell(colIndex) : row.createCell(colIndex);

		boolean needsWrap = value != null && value.toString().contains("\n");

		if (formatStr != null && !formatStr.isEmpty()) {
			CellStyle newStyle = row.getSheet().getWorkbook().createCellStyle();
			newStyle.cloneStyleFrom(cell.getCellStyle());
			newStyle.setDataFormat(helper.createDataFormat().getFormat(formatStr));
			if (needsWrap) {
				newStyle.setWrapText(true);
			}
			cell.setCellStyle(newStyle);
		} else if (needsWrap) {
			CellStyle newStyle = row.getSheet().getWorkbook().createCellStyle();
			newStyle.cloneStyleFrom(cell.getCellStyle());
			newStyle.setWrapText(true);
			cell.setCellStyle(newStyle);
		}

		if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
			cell.setCellFormula(null);
		}
		if (value == null) {
			cell.setCellType(Cell.CELL_TYPE_BLANK);
		} else if (value instanceof Number) {
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(((Number) value).doubleValue());
		} else {
			String strValue = value.toString().trim();
			try {
				double numericValue = Double.parseDouble(strValue);

				cell.setCellType(Cell.CELL_TYPE_NUMERIC);
				cell.setCellValue(numericValue);

			} catch (NumberFormatException e) {
				cell.setCellType(Cell.CELL_TYPE_STRING);
				cell.setCellValue(strValue);
			}
		}
	}

	public void MC_TABLE1_Modify(RT_MC_TABLE1_ENTITY updatedData) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = formatter.format(updatedData.getREPORT_DATE());
		List<RT_MC_TABLE1_ENTITY> rawdata = RT_MC_TABLE1_REPO.findByReportDateAndBranchCode(formattedDate,
				updatedData.getBRANCH_CODE());
		RT_MC_TABLE1_ENTITY existing = rawdata.get(0);
		if (rawdata == null || rawdata.isEmpty()) {
	        System.err.println("Audit skipped: No existing data found for " + formattedDate);
	        return;
	    }
		String uniqueIdValues = formatter.format(updatedData.getREPORT_DATE()) + " - " + updatedData.getBRANCH_CODE();

		auditservice.compareMCEntitiesManualGrouped(existing, updatedData, uniqueIdValues, screenName("bankinformation"),
				"RT_MC_TABLE1","bankinformation");
	}

	public void MC_TABLE2_1_Modify(RT_MC_TABLE2_1_ENTITY updatedData) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = formatter.format(updatedData.getREPORT_DATE());
		List<RT_MC_TABLE2_1_ENTITY> rawdata = RT_MC_TABLE2_1_REPO.findByReportDateAndBranchCode(formattedDate,
				updatedData.getBRANCH_CODE());
		RT_MC_TABLE2_1_ENTITY existing = rawdata.get(0);

		if (rawdata == null || rawdata.isEmpty()) {
	        System.err.println("Audit skipped: No existing data found for " + formattedDate);
	        return;
	    }
		String uniqueIdValues = formatter.format(updatedData.getREPORT_DATE()) + " - " + updatedData.getBRANCH_CODE();

		auditservice.compareMCEntitiesManualGrouped(existing, updatedData, uniqueIdValues, screenName("bankconsumers"),
				"RT_MC_TABLE2_1","bankconsumers");
	    
	}

	public void MC_TABLE2_2_Modify(RT_MC_TABLE2_2_ENTITY updatedData) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = formatter.format(updatedData.getREPORT_DATE());
		List<RT_MC_TABLE2_2_ENTITY> rawdata = RT_MC_TABLE2_2_REPO.findByReportDateAndBranchCode(formattedDate,
				updatedData.getBRANCH_CODE());
		RT_MC_TABLE2_2_ENTITY existing = rawdata.get(0);

		if (rawdata == null || rawdata.isEmpty()) {
	        System.err.println("Audit skipped: No existing data found for " + formattedDate);
	        return;
	    }
		String uniqueIdValues = formatter.format(updatedData.getREPORT_DATE()) + " - " + updatedData.getBRANCH_CODE();

		auditservice.compareMCEntitiesManualGrouped(existing, updatedData, uniqueIdValues, screenName("bankconsumers"),
				"RT_MC_TABLE2_2","bankconsumers");
	}

	public void MC_TABLE3_Modify(RT_MC_TABLE3_ENTITY updatedData) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = formatter.format(updatedData.getREPORT_DATE());
		List<RT_MC_TABLE3_ENTITY> rawdata = RT_MC_TABLE3_REPO.findByReportDateAndBranchCode(formattedDate,
				updatedData.getBRANCH_CODE());
		RT_MC_TABLE3_ENTITY existing = rawdata.get(0);

		if (rawdata == null || rawdata.isEmpty()) {
	        System.err.println("Audit skipped: No existing data found for " + formattedDate);
	        return;
	    }
		String uniqueIdValues = formatter.format(updatedData.getREPORT_DATE()) + " - " + updatedData.getBRANCH_CODE();

		auditservice.compareMCEntitiesManualGrouped(existing, updatedData, uniqueIdValues, screenName("complaints"),
				"RT_MC_TABLE3","complaints");
	}

	public void MC_TABLE4_1_Modify(RT_MC_TABLE4_1_ENTITY updatedData) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = formatter.format(updatedData.getREPORT_DATE());
		List<RT_MC_TABLE4_1_ENTITY> rawdata = RT_MC_TABLE4_1_REPO.findByReportDateAndBranchCode(formattedDate,
				updatedData.getBRANCH_CODE());
		RT_MC_TABLE4_1_ENTITY existing = rawdata.get(0);

		if (rawdata == null || rawdata.isEmpty()) {
	        System.err.println("Audit skipped: No existing data found for " + formattedDate);
	        return;
	    }
		String uniqueIdValues = formatter.format(updatedData.getREPORT_DATE()) + " - " + updatedData.getBRANCH_CODE();

		auditservice.compareMCEntitiesManualGrouped(existing, updatedData, uniqueIdValues, screenName("retailproducts"),
				"RT_MC_TABLE4_1","retailproducts");
	}

	public void MC_TABLE4_2_Modify(RT_MC_TABLE4_2_ENTITY updatedData) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = formatter.format(updatedData.getREPORT_DATE());
		List<RT_MC_TABLE4_2_ENTITY> rawdata = RT_MC_TABLE4_2_REPO.findByReportDateAndBranchCode(formattedDate,
				updatedData.getBRANCH_CODE());
		RT_MC_TABLE4_2_ENTITY existing = rawdata.get(0);


		if (rawdata == null || rawdata.isEmpty()) {
	        System.err.println("Audit skipped: No existing data found for " + formattedDate);
	        return;
	    }
		String uniqueIdValues = formatter.format(updatedData.getREPORT_DATE()) + " - " + updatedData.getBRANCH_CODE();

		auditservice.compareMCEntitiesManualGrouped(existing, updatedData, uniqueIdValues, screenName("retailproducts"),
				"RT_MC_TABLE4_2","retailproducts");
	}

	public void MC_TABLE5_Modify(RT_MC_TABLE5_ENTITY updatedData) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = formatter.format(updatedData.getREPORT_DATE());
		List<RT_MC_TABLE5_ENTITY> rawdata = RT_MC_TABLE5_REPO.findByReportDateAndBranchCode(formattedDate,
				updatedData.getBRANCH_CODE());
		RT_MC_TABLE5_ENTITY existing = rawdata.get(0);

		if (rawdata == null || rawdata.isEmpty()) {
	        System.err.println("Audit skipped: No existing data found for " + formattedDate);
	        return;
	    }
		String uniqueIdValues = formatter.format(updatedData.getREPORT_DATE()) + " - " + updatedData.getBRANCH_CODE();

		auditservice.compareMCEntitiesManualGrouped(existing, updatedData, uniqueIdValues, screenName("bankemployee"),
				"RT_MC_TABLE5","bankemployee");
	}

	public void MC_TABLE6_Modify(RT_MC_TABLE6_ENTITY updatedData) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = formatter.format(updatedData.getREPORT_DATE());
		List<RT_MC_TABLE6_ENTITY> rawdata = RT_MC_TABLE6_REPO.findByReportDateAndBranchCode(formattedDate,
				updatedData.getBRANCH_CODE());
		RT_MC_TABLE6_ENTITY existing = rawdata.get(0);


		if (rawdata == null || rawdata.isEmpty()) {
	        System.err.println("Audit skipped: No existing data found for " + formattedDate);
	        return;
	    }
		String uniqueIdValues = formatter.format(updatedData.getREPORT_DATE()) + " - " + updatedData.getBRANCH_CODE();

		auditservice.compareMCEntitiesManualGrouped(existing, updatedData, uniqueIdValues, screenName("trainings"),
				"RT_MC_TABLE6","trainings");
	}

	public void MC_TABLE7_1_Modify(RT_MC_TABLE7_1_ENTITY updatedData) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = formatter.format(updatedData.getREPORT_DATE());
		List<RT_MC_TABLE7_1_ENTITY> rawdata = RT_MC_TABLE7_1_REPO.findByReportDateAndBranchCode(formattedDate,
				updatedData.getBRANCH_CODE());
		RT_MC_TABLE7_1_ENTITY existing = rawdata.get(0);

		if (rawdata == null || rawdata.isEmpty()) {
	        System.err.println("Audit skipped: No existing data found for " + formattedDate);
	        return;
	    }
		String uniqueIdValues = formatter.format(updatedData.getREPORT_DATE()) + " - " + updatedData.getBRANCH_CODE();

		auditservice.compareMCEntitiesManualGrouped(existing, updatedData, uniqueIdValues, screenName("additionalinformation"),
				"RT_MC_TABLE7_1","additionalinformation");
	}

	public void MC_TABLE7_2_Modify(RT_MC_TABLE7_2_ENTITY updatedData) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = formatter.format(updatedData.getREPORT_DATE());
		List<RT_MC_TABLE7_2_ENTITY> rawdata = RT_MC_TABLE7_2_REPO.findByReportDateAndBranchCode(formattedDate,
				updatedData.getBRANCH_CODE());
		RT_MC_TABLE7_2_ENTITY existing = rawdata.get(0);

		if (rawdata == null || rawdata.isEmpty()) {
	        System.err.println("Audit skipped: No existing data found for " + formattedDate);
	        return;
	    }
		String uniqueIdValues = formatter.format(updatedData.getREPORT_DATE()) + " - " + updatedData.getBRANCH_CODE();

		auditservice.compareMCEntitiesManualGrouped(existing, updatedData, uniqueIdValues, screenName("additionalinformation"),
				"RT_MC_TABLE7_2","additionalinformation");
	}

	public void MC_TABLE8_Modify(RT_MC_TABLE8_ENTITY updatedData) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = formatter.format(updatedData.getREPORT_DATE());
		List<RT_MC_TABLE8_ENTITY> rawdata = RT_MC_TABLE8_REPO.findByReportDateAndBranchCode(formattedDate,
				updatedData.getBRANCH_CODE());
		RT_MC_TABLE8_ENTITY existing = rawdata.get(0);

		if (rawdata == null || rawdata.isEmpty()) {
	        System.err.println("Audit skipped: No existing data found for " + formattedDate);
	        return;
	    }
		String uniqueIdValues = formatter.format(updatedData.getREPORT_DATE()) + " - " + updatedData.getBRANCH_CODE();

		auditservice.compareMCEntitiesManualGrouped(existing, updatedData, uniqueIdValues, screenName("islamicbanking"),
				"RT_MC_TABLE8","islamicbanking");
	}

	public void MC_TABLE9_Modify(RT_MC_TABLE9_ENTITY updatedData) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = formatter.format(updatedData.getREPORT_DATE());
		List<RT_MC_TABLE9_ENTITY> rawdata = RT_MC_TABLE9_REPO.findByReportDateAndBranchCode(formattedDate,
				updatedData.getBRANCH_CODE());
		RT_MC_TABLE9_ENTITY existing = rawdata.get(0);

		if (rawdata == null || rawdata.isEmpty()) {
	        System.err.println("Audit skipped: No existing data found for " + formattedDate);
	        return;
	    }
		String uniqueIdValues = formatter.format(updatedData.getREPORT_DATE()) + " - " + updatedData.getBRANCH_CODE();

		auditservice.compareMCEntitiesManualGrouped(existing, updatedData, uniqueIdValues, screenName("conductcultureassessment"),
				"RT_MC_TABLE9","conductcultureassessment");
	}

	public int updateVerifyFlgAndRemarks(String formMode, String verifyFlg, String remarks, Date reportDate,
			String timeperiod) {

		int rows_updated = 0;

		switch (formMode) {
		case "bankinformation":
			rows_updated = RT_MC_TABLE1_REPO.updateVerifyFlgAndRemarks(verifyFlg, remarks, reportDate, timeperiod);
			return rows_updated;
		case "bankconsumers":
			rows_updated = RT_MC_TABLE2_1_REPO.updateVerifyFlgAndRemarks(verifyFlg, remarks, reportDate, timeperiod);
			rows_updated = RT_MC_TABLE2_2_REPO.updateVerifyFlgAndRemarks(verifyFlg, remarks, reportDate, timeperiod);
			return rows_updated;

		case "complaints":
			rows_updated = RT_MC_TABLE3_REPO.updateVerifyFlgAndRemarks(verifyFlg, remarks, reportDate, timeperiod);
			return rows_updated;
		case "retailproducts":
			rows_updated = RT_MC_TABLE4_1_REPO.updateVerifyFlgAndRemarks(verifyFlg, remarks, reportDate, timeperiod);
			rows_updated = RT_MC_TABLE4_2_REPO.updateVerifyFlgAndRemarks(verifyFlg, remarks, reportDate, timeperiod);

			return rows_updated;
		case "bankemployee":
			rows_updated = RT_MC_TABLE5_REPO.updateVerifyFlgAndRemarks(verifyFlg, remarks, reportDate, timeperiod);
			return rows_updated;
		case "trainings":
			rows_updated = RT_MC_TABLE6_REPO.updateVerifyFlgAndRemarks(verifyFlg, remarks, reportDate, timeperiod);
			return rows_updated;
		case "additionalinformation":
			rows_updated = RT_MC_TABLE7_1_REPO.updateVerifyFlgAndRemarks(verifyFlg, remarks, reportDate, timeperiod);
			rows_updated = RT_MC_TABLE7_2_REPO.updateVerifyFlgAndRemarks(verifyFlg, remarks, reportDate, timeperiod);
			return rows_updated;
		case "islamicbanking":
			rows_updated = RT_MC_TABLE8_REPO.updateVerifyFlgAndRemarks(verifyFlg, remarks, reportDate, timeperiod);
			return rows_updated;
		case "conductcultureassessment":
			rows_updated = RT_MC_TABLE9_REPO.updateVerifyFlgAndRemarks(verifyFlg, remarks, reportDate, timeperiod);
			return rows_updated;
		default:
			return rows_updated;
		}
	}

	public String getMainTableName(String formMode, String cellName) {
		if (formMode == null)
			return null;

		switch (formMode) {
		case "bankinformation":
			return "RT_MC_TABLE1";
		case "bankconsumers":
			if (cellName != null && cellName.matches("^R(6|7|8|9|10|11|12|13|14)_.*")) {
				return "RT_MC_TABLE2_1";
			} else {
				return "RT_MC_TABLE2_2";
			}
		case "complaints":
			return "RT_MC_TABLE3";
		case "retailproducts":
			if (cellName != null && cellName.matches("^R(6|7|8|9|10|11|12|13|14)_.*")) {
				return "RT_MC_TABLE4_1";
			} else {
				return "RT_MC_TABLE4_2";
			}
		case "bankemployee":
			return "RT_MC_TABLE5";
		case "trainings":
			return "RT_MC_TABLE6";
		case "additionalinformation":
			if (cellName != null && cellName.matches("^R(7|8|9|10|11|12|13|14|15)_.*")) {
				return "RT_MC_TABLE7_1";
			} else {
				return "RT_MC_TABLE7_2";
			}
		case "islamicbanking":
			return "RT_MC_TABLE8";
		case "conductcultureassessment":
			return "RT_MC_TABLE9";
		default:
			return formMode;
		}
	}

	public String screenName(String formMode) {
		String screenName = null;
		switch (formMode) {
		case "bankinformation":
			screenName = "Bank Information - Market Conduct";
			return screenName;
		case "bankconsumers":
			screenName = "Bank Consumers - Market Conduct";
			return screenName;
		case "complaints":
			screenName = "Complaints - Market Conduct";
			return screenName;
		case "retailproducts":
			screenName = "Retail Products - Market Conduct";
			return screenName;
		case "bankemployee":
			screenName = "Bank Employee - Market Conduct";
			return screenName;
		case "trainings":
			screenName = "Trainings - Market Conduct";
			return screenName;
		case "additionalinformation":
			screenName = "Additional Informaion - Market Conduct";
			return screenName;
		case "islamicbanking":
			screenName = "Islamic Banking - Market Conduct";
			return screenName;
		case "conductcultureassessment":
			screenName = "Conduct Cultureassessment - Market Conduct";
			return screenName;
		default:
			return formMode;
		}
	}

	public Map<String, Object> getManagerViewData(String formmode, String Date, String timeperiod) {
		Map<String, Object> managerdata = null;
		switch (formmode) {
		case "bankinformation":
			managerdata = getManagerViewDataTable1(Date, timeperiod);
			return managerdata;
		case "bankconsumers":
			managerdata = getManagerViewDataTable2(Date, timeperiod);
			return managerdata;
		case "complaints":
			managerdata = getManagerViewDataTable3(Date, timeperiod);
			return managerdata;
		case "retailproducts":
			managerdata = getManagerViewDataTable4(Date, timeperiod);
			return managerdata;
		case "bankemployee":
			managerdata = getManagerViewDataTable5(Date, timeperiod);
			return managerdata;
		case "trainings":
			managerdata = getManagerViewDataTable6(Date, timeperiod);
			return managerdata;
		case "additionalinformation":
			managerdata = getManagerViewDataTable7(Date, timeperiod);
			return managerdata;
		case "islamicbanking":
			managerdata = getManagerViewDataTable8(Date, timeperiod);
			return managerdata;
		case "conductcultureassessment":
			managerdata = getManagerViewDataTable9(Date, timeperiod);
			return managerdata;
		default:
			return managerdata;
		}

	}

	public Map<String, Object> getManagerViewDataTable1(String Date, String timeperiod) {
		List<RT_MC_TABLE1_ENTITY> top4Rows = RT_MC_TABLE1_REPO.findLastFourReports(Date, "QUARTERLY");
		List<RT_MC_TABLE1_ENTITY> top2RowsYearly = RT_MC_TABLE1_REPO.findLastTwoReports(Date, "YEARLY");
		System.out.println("Last 4Q count : "+top4Rows.size()+ " and last 2Y count : "+top2RowsYearly.size());
		List<String> headerDates = new ArrayList<>();
		List<String> yearDates = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM - yyyy");

		for (RT_MC_TABLE1_ENTITY row : top4Rows) {
			Date rawDate = row.getREPORT_DATE();
			LocalDate displayDate = new java.sql.Date(rawDate.getTime()).toLocalDate();
			headerDates.add(displayDate.format(formatter));
		}

		for (RT_MC_TABLE1_ENTITY row : top2RowsYearly) {
			Date rawDate = row.getREPORT_DATE();
			LocalDate displayDate = new java.sql.Date(rawDate.getTime()).toLocalDate();
			yearDates.add("Yearly - " + displayDate.format(formatter));
		}

		List<RT_MC_Manager_DTO> pivotTable = new ArrayList<>();

		pivotTable.add(new RT_MC_Manager_DTO("Number of employees as of the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_NO_EMP_SPC_TP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_NO_EMP_SPC_TP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_NO_EMP_SPC_TP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_NO_EMP_SPC_TP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_NO_EMP_SPC_TP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_NO_EMP_SPC_TP),
				getMakerJustification("bankinformation", Date, "R22_NO_EMP_SPC_TP", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_NO_EMP_SPC_TP", timeperiod),
				"R22_NO_EMP_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of Consumers as of the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_NO_CON_SPC_TP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_NO_CON_SPC_TP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_NO_CON_SPC_TP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_NO_CON_SPC_TP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_NO_CON_SPC_TP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_NO_CON_SPC_TP),
				getMakerJustification("bankinformation", Date, "R22_NO_CON_SPC_TP", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_NO_CON_SPC_TP", timeperiod),
				"R22_NO_CON_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO("Average Number of employees as of the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_AVG_NO_EMP_SPC_TP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_AVG_NO_EMP_SPC_TP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_AVG_NO_EMP_SPC_TP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_AVG_NO_EMP_SPC_TP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_AVG_NO_EMP_SPC_TP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_AVG_NO_EMP_SPC_TP),
				getMakerJustification("bankinformation", Date, "R22_AVG_NO_EMP_SPC_TP", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_AVG_NO_EMP_SPC_TP", timeperiod),
				"R22_AVG_NO_EMP_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of branches as of the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_NO_BRN_SPC_TP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_NO_BRN_SPC_TP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_NO_BRN_SPC_TP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_NO_BRN_SPC_TP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_NO_BRN_SPC_TP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_NO_BRN_SPC_TP),
				getMakerJustification("bankinformation", Date, "R22_NO_BRN_SPC_TP", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_NO_BRN_SPC_TP", timeperiod),
				"R22_NO_BRN_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total number of Bank branches designated for PoD or branches catering to the needs of PoD during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_BRN_POD),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_BRN_POD),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_BRN_POD),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_BRN_POD),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_BRN_POD),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_BRN_POD),
				getMakerJustification("bankinformation", Date, "R22_TOT_NO_BRN_POD", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_TOT_NO_BRN_POD", timeperiod),
				"R22_TOT_NO_BRN_POD"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of ATMs as of the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_NO_ATM_SPC_TP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_NO_ATM_SPC_TP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_NO_ATM_SPC_TP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_NO_ATM_SPC_TP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_NO_ATM_SPC_TP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_NO_ATM_SPC_TP),
				getMakerJustification("bankinformation", Date, "R22_NO_ATM_SPC_TP", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_NO_ATM_SPC_TP", timeperiod),
				"R22_NO_ATM_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of ATMs having People of Determination specified requirements as of the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_NO_ATM_DET_SPC_TP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_NO_ATM_DET_SPC_TP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_NO_ATM_DET_SPC_TP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_NO_ATM_DET_SPC_TP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_NO_ATM_DET_SPC_TP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_NO_ATM_DET_SPC_TP),
				getMakerJustification("bankinformation", Date, "R22_NO_ATM_DET_SPC_TP", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_NO_ATM_DET_SPC_TP", timeperiod),
				"R22_NO_ATM_DET_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of Authorized Agents as of the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_NO_AUT_SPC_TP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_NO_AUT_SPC_TP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_NO_AUT_SPC_TP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_NO_AUT_SPC_TP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_NO_AUT_SPC_TP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_NO_AUT_SPC_TP),
				getMakerJustification("bankinformation", Date, "R22_NO_AUT_SPC_TP", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_NO_AUT_SPC_TP", timeperiod),
				"R22_NO_AUT_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of instances, wherein service interruptions to internet and mobile Banking is either 1 hour or more than 1 hour during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_NO_INS_BNK_SPC_TP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_NO_INS_BNK_SPC_TP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_NO_INS_BNK_SPC_TP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_NO_INS_BNK_SPC_TP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_NO_INS_BNK_SPC_TP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_NO_INS_BNK_SPC_TP),
				getMakerJustification("bankinformation", Date, "R22_NO_INS_BNK_SPC_TP", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_NO_INS_BNK_SPC_TP", timeperiod),
				"R22_NO_INS_BNK_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of instances, wherein any scheduled or planned downtime for any critical systems of the Bank extended over the scheduled or planned downtime during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_NO_INS_DWN_SPC_TP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_NO_INS_DWN_SPC_TP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_NO_INS_DWN_SPC_TP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_NO_INS_DWN_SPC_TP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_NO_INS_DWN_SPC_TP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_NO_INS_DWN_SPC_TP),
				getMakerJustification("bankinformation", Date, "R22_NO_INS_DWN_SPC_TP", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_NO_INS_DWN_SPC_TP", timeperiod),
				"R22_NO_INS_DWN_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of employees within the second line of defense (Risk /Compliance or any other function which is independent from business) responsible for monitoring Conduct Risk of the Bank as of the specified date",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_NO_EMP_RSK_SPC_DTE),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_NO_EMP_RSK_SPC_DTE),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_NO_EMP_RSK_SPC_DTE),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_NO_EMP_RSK_SPC_DTE),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_NO_EMP_RSK_SPC_DTE),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_NO_EMP_RSK_SPC_DTE),
				getMakerJustification("bankinformation", Date, "R22_NO_EMP_RSK_SPC_DTE", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_NO_EMP_RSK_SPC_DTE", timeperiod),
				"R22_NO_EMP_RSK_SPC_DTE"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of external fraud incidents during specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_NO_EXT_FRD_SPC_TP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_NO_EXT_FRD_SPC_TP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_NO_EXT_FRD_SPC_TP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_NO_EXT_FRD_SPC_TP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_NO_EXT_FRD_SPC_TP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_NO_EXT_FRD_SPC_TP),
				getMakerJustification("bankinformation", Date, "R22_NO_EXT_FRD_SPC_TP", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_NO_EXT_FRD_SPC_TP", timeperiod),
				"R22_NO_EXT_FRD_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of internal fraud incidents during specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_NO_INT_FRD_SPC_TP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_NO_INT_FRD_SPC_TP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_NO_INT_FRD_SPC_TP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_NO_INT_FRD_SPC_TP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_NO_INT_FRD_SPC_TP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_NO_INT_FRD_SPC_TP),
				getMakerJustification("bankinformation", Date, "R22_NO_INT_FRD_SPC_TP", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_NO_INT_FRD_SPC_TP", timeperiod),
				"R22_NO_INT_FRD_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of fraud incidents during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_NO_FRD_SPC_TP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_NO_FRD_SPC_TP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_NO_FRD_SPC_TP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_NO_FRD_SPC_TP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_NO_FRD_SPC_TP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_NO_FRD_SPC_TP),
				getMakerJustification("bankinformation", Date, "R22_NO_FRD_SPC_TP", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_NO_FRD_SPC_TP", timeperiod),
				"R22_NO_FRD_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of fraud incidents during the previous period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_NO_FRD_PP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_NO_FRD_PP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_NO_FRD_PP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_NO_FRD_PP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_NO_FRD_PP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_NO_FRD_PP),
				getMakerJustification("bankinformation", Date, "R22_NO_FRD_PP", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_NO_FRD_PP", timeperiod), "R22_NO_FRD_PP"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total number of reviews conducted by the Bank on authorised agents during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_TOT_REV_SPC_TP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_TOT_REV_SPC_TP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_TOT_REV_SPC_TP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_TOT_REV_SPC_TP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_TOT_REV_SPC_TP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_TOT_REV_SPC_TP),
				getMakerJustification("bankinformation", Date, "R22_TOT_REV_SPC_TP", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_TOT_REV_SPC_TP", timeperiod),
				"R22_TOT_REV_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total number of instances of Unplanned service interuptions including system downtime instances affecting the internet/mobile/devise based instument which resulted in consumer's failure to access Bank's application/website/POS terminals or failure to avail the services provided by the Bank through its application/website/POS terminals during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_TOT_INS_UNP_SPC_TP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_TOT_INS_UNP_SPC_TP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_TOT_INS_UNP_SPC_TP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_TOT_INS_UNP_SPC_TP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_TOT_INS_UNP_SPC_TP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_TOT_INS_UNP_SPC_TP),
				getMakerJustification("bankinformation", Date, "R22_TOT_INS_UNP_SPC_TP", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_TOT_INS_UNP_SPC_TP", timeperiod),
				"R22_TOT_INS_UNP_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total number of hours of Unplanned service interuptions including system downtime (in hours) affecting the internet/mobile/devise based instument which resulted in consumer's failure to access Bank's application/website/POS terminals or failure to avail the services provided by the Bank through its application/website/POS terminals during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_HRS_BNK),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_HRS_BNK),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_HRS_BNK),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_HRS_BNK),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_HRS_BNK),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_HRS_BNK),
				getMakerJustification("bankinformation", Date, "R22_TOT_NO_HRS_BNK", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_TOT_NO_HRS_BNK", timeperiod),
				"R22_TOT_NO_HRS_BNK"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total Number of incidents of system security breaches leading to Consumer data theft (e.g., hacker attacks, personal data leakage, unauthorized access to digital wallets for data theft, etc.) that have impacted consumers as of the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_INC_SPC_TP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_INC_SPC_TP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_INC_SPC_TP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_INC_SPC_TP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_INC_SPC_TP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_INC_SPC_TP),
				getMakerJustification("bankinformation", Date, "R22_TOT_NO_INC_SPC_TP", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_TOT_NO_INC_SPC_TP", timeperiod),
				"R22_TOT_NO_INC_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total number of penetration and cyber-attack simulation testing conducted during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_PEN_SPC_TP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_PEN_SPC_TP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_PEN_SPC_TP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_PEN_SPC_TP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_PEN_SPC_TP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_PEN_SPC_TP),
				getMakerJustification("bankinformation", Date, "R22_TOT_NO_PEN_SPC_TP", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_TOT_NO_PEN_SPC_TP", timeperiod),
				"R22_TOT_NO_PEN_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total Number of Authorised Agents and outsourcing service providers (including services or systems outsourced to authorised agents) during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_AUT_SPC_TP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_AUT_SPC_TP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_AUT_SPC_TP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_AUT_SPC_TP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_AUT_SPC_TP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_AUT_SPC_TP),
				getMakerJustification("bankinformation", Date, "R22_TOT_NO_AUT_SPC_TP", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_TOT_NO_AUT_SPC_TP", timeperiod),
				"R22_TOT_NO_AUT_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO("Total Number of Point of Sale Terminals during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_SAL_SPC_TP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_SAL_SPC_TP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_SAL_SPC_TP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_SAL_SPC_TP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_SAL_SPC_TP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_SAL_SPC_TP),
				getMakerJustification("bankinformation", Date, "R22_TOT_NO_SAL_SPC_TP", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_TOT_NO_SAL_SPC_TP", timeperiod),
				"R22_TOT_NO_SAL_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO("Total Number of Merchant tie ups during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_MER_SPC_TP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_MER_SPC_TP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_MER_SPC_TP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_MER_SPC_TP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_MER_SPC_TP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_TOT_NO_MER_SPC_TP),
				getMakerJustification("bankinformation", Date, "R22_TOT_NO_MER_SPC_TP", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_TOT_NO_MER_SPC_TP", timeperiod),
				"R22_TOT_NO_MER_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of Inquiries received raised during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_NO_INQ_SPC_TP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_NO_INQ_SPC_TP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_NO_INQ_SPC_TP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_NO_INQ_SPC_TP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_NO_INQ_SPC_TP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_NO_INQ_SPC_TP),
				getMakerJustification("bankinformation", Date, "R22_NO_INQ_SPC_TP", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_NO_INQ_SPC_TP", timeperiod),
				"R22_NO_INQ_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of service interruptions caused by authorised agents that have affected consumers during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE1_ENTITY::getR22_NO_SER_SPC_TP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE1_ENTITY::getR22_NO_SER_SPC_TP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE1_ENTITY::getR22_NO_SER_SPC_TP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE1_ENTITY::getR22_NO_SER_SPC_TP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE1_ENTITY::getR22_NO_SER_SPC_TP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE1_ENTITY::getR22_NO_SER_SPC_TP),
				getMakerJustification("bankinformation", Date, "R22_NO_SER_SPC_TP", timeperiod),
				getCheckerJustification("bankinformation", Date, "R22_NO_SER_SPC_TP", timeperiod),
				"R22_NO_SER_SPC_TP"));

		Map<String, Object> modelData = new HashMap<>();
		modelData.put("headerDates", headerDates);
		modelData.put("yearDates", yearDates);
		modelData.put("reportRows", pivotTable);

		return modelData;
	}

	public Map<String, Object> getManagerViewDataTable2(String Date, String timeperiod) {
		List<RT_MC_TABLE2_2_ENTITY> top4Rowstable2 = RT_MC_TABLE2_2_REPO.findLastFourReports(Date, "QUARTERLY");
		List<RT_MC_TABLE2_2_ENTITY> top2RowsYearlytable2 = RT_MC_TABLE2_2_REPO.findLastTwoReports(Date, "YEARLY");

		List<String> headerDates = new ArrayList<>();
		List<String> yearDates = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM - yyyy");

		for (RT_MC_TABLE2_2_ENTITY row : top4Rowstable2) {
			Date rawDate = row.getREPORT_DATE();
			LocalDate displayDate = new java.sql.Date(rawDate.getTime()).toLocalDate();
			headerDates.add(displayDate.format(formatter));
		}

		for (RT_MC_TABLE2_2_ENTITY row : top2RowsYearlytable2) {
			Date rawDate = row.getREPORT_DATE();
			LocalDate displayDate = new java.sql.Date(rawDate.getTime()).toLocalDate();
			yearDates.add("Yearly - " + displayDate.format(formatter));
		}

		List<RT_MC_Manager_DTO> pivotTable = new ArrayList<>();

		pivotTable.add(new RT_MC_Manager_DTO("Number of women Consumers as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_WO_SD),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_WO_SD),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_WO_SD),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_WO_SD),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_WO_SD),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_WO_SD),
				getMakerJustification("bankconsumers", Date, "R22_NO_WO_SD", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_WO_SD", timeperiod), "R22_NO_WO_SD"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers tagged as People of Determination (PoD) as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_POD_SD),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_POD_SD),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_POD_SD),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_POD_SD),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_POD_SD),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_POD_SD),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_POD_SD", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_POD_SD", timeperiod), "R22_NO_CON_POD_SD"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers whose data has been accessed by unauthorized parties during the specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_UNAU_SP_TP),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_UNAU_SP_TP),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_UNAU_SP_TP),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_UNAU_SP_TP),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_UNAU_SP_TP),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_UNAU_SP_TP),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_UNAU_SP_TP", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_UNAU_SP_TP", timeperiod),
				"R22_NO_CON_UNAU_SP_TP"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers having DBR greater than and equal to 45% but less than 50%  ",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_45_50),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_45_50),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_45_50),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_45_50),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_45_50),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_45_50),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_45_50", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_45_50", timeperiod), "R22_NO_CON_45_50"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of Consumers having DBR greater than  or equal to 50%",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_50),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_50),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_50),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_50),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_50),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_50),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_50", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_50", timeperiod), "R22_NO_CON_50"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of new Consumers onboarded having disposable income less than 50% of their total income",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_LES_50),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_LES_50),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_LES_50),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_LES_50),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_LES_50),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_LES_50),
				getMakerJustification("bankconsumers", Date, "R22_NO_OF_LES_50", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_OF_LES_50", timeperiod), "R22_NO_OF_LES_50"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books that fall under the age bracket:  less than 18 years old as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_18),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_18),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_18),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_18),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_18),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_18),
				getMakerJustification("bankconsumers", Date, "R22_NO_OF_BNK_18", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_OF_BNK_18", timeperiod), "R22_NO_OF_BNK_18"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books that fall under the age bracket:  18-25 years as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_18_25),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_18_25),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_18_25),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_18_25),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_18_25),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_18_25),
				getMakerJustification("bankconsumers", Date, "R22_NO_OF_BNK_18_25", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_OF_BNK_18_25", timeperiod),
				"R22_NO_OF_BNK_18_25"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books that fall under the age bracket:  26-35 years  as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_26_35),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_26_35),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_26_35),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_26_35),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_26_35),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_26_35),
				getMakerJustification("bankconsumers", Date, "R22_NO_OF_BNK_26_35", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_OF_BNK_26_35", timeperiod),
				"R22_NO_OF_BNK_26_35"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books that fall under the age bracket:  36-50 years as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_36_50),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_36_50),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_36_50),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_36_50),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_36_50),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_BNK_36_50),
				getMakerJustification("bankconsumers", Date, "R22_NO_OF_BNK_36_50", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_OF_BNK_36_50", timeperiod),
				"R22_NO_OF_BNK_36_50"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books that fall under the age bracket:  Greater than 50 years old as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BNK_50),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BNK_50),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BNK_50),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BNK_50),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BNK_50),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BNK_50),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_BNK_50", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_BNK_50", timeperiod), "R22_NO_CON_BNK_50"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books who's primary source of income is Salary as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_SAL_SPD),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_SAL_SPD),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_SAL_SPD),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_SAL_SPD),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_SAL_SPD),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_SAL_SPD),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_SAL_SPD", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_SAL_SPD", timeperiod),
				"R22_NO_CON_SAL_SPD"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books who's primary source of income is Income from Business as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BUS_SPD),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BUS_SPD),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BUS_SPD),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BUS_SPD),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BUS_SPD),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BUS_SPD),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_BUS_SPD", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_BUS_SPD", timeperiod),
				"R22_NO_CON_BUS_SPD"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books who's primary source of income is from other sources including Investment properties as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_PRO_SPD),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_PRO_SPD),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_PRO_SPD),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_PRO_SPD),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_PRO_SPD),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_PRO_SPD),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_PRO_SPD", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_PRO_SPD", timeperiod),
				"R22_NO_CON_PRO_SPD"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books with the level of monthly income as<= 5,000 AED as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_5K),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_5K),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_5K),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_5K),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_5K),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_5K),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_INC_5K", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_INC_5K", timeperiod), "R22_NO_CON_INC_5K"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books with the level of monthly income as5,001-10,000 AED as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_5K_10K),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_5K_10K),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_5K_10K),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_5K_10K),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_5K_10K),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_5K_10K),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_INC_5K_10K", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_INC_5K_10K", timeperiod),
				"R22_NO_CON_INC_5K_10K"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books with the level of monthly income as 10,001-20,000 AED as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_10K_20K),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_10K_20K),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_10K_20K),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_10K_20K),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_10K_20K),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_10K_20K),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_INC_10K_20K", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_INC_10K_20K", timeperiod),
				"R22_NO_CON_INC_10K_20K"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books with the level of monthly income as 20,001-35,000 AED as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_20K_35K),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_20K_35K),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_20K_35K),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_20K_35K),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_20K_35K),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_20K_35K),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_INC_20K_35K", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_INC_20K_35K", timeperiod),
				"R22_NO_CON_INC_20K_35K"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books with the level of monthly income as >35,001 AED as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_35K),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_35K),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_35K),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_35K),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_35K),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_INC_35K),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_INC_35K", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_INC_35K", timeperiod),
				"R22_NO_CON_INC_35K"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books with the level of education as Secondary school or below as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BEL_SCL),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BEL_SCL),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BEL_SCL),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BEL_SCL),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BEL_SCL),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BEL_SCL),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_BEL_SCL", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_BEL_SCL", timeperiod),
				"R22_NO_CON_BEL_SCL"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books with the level of education as  Bachelor's degree as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BAC),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BAC),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BAC),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BAC),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BAC),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BAC),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_BAC", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_BAC", timeperiod), "R22_NO_CON_BAC"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books with the level of education as Master's degree or above as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ABV_MAS),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ABV_MAS),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ABV_MAS),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ABV_MAS),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ABV_MAS),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ABV_MAS),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_ABV_MAS", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_ABV_MAS", timeperiod),
				"R22_NO_CON_ABV_MAS"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books that reside in Abu Dhabi (as per the KYC document submitted to the Bank) as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ABU_KYC),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ABU_KYC),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ABU_KYC),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ABU_KYC),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ABU_KYC),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ABU_KYC),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_ABU_KYC", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_ABU_KYC", timeperiod),
				"R22_NO_CON_ABU_KYC"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books that reside in Dubai (as per the KYC document submitted to the Bank) as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DUB_KYC),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DUB_KYC),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DUB_KYC),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DUB_KYC),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DUB_KYC),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DUB_KYC),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_DUB_KYC", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_DUB_KYC", timeperiod),
				"R22_NO_CON_DUB_KYC"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books that reside in Sharjah (as per the KYC document submitted to the Bank) as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_SHJ_KYC),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_SHJ_KYC),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_SHJ_KYC),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_SHJ_KYC),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_SHJ_KYC),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_SHJ_KYC),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_SHJ_KYC", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_SHJ_KYC", timeperiod),
				"R22_NO_CON_SHJ_KYC"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books that reside in Ajman (as per the KYC document submitted to the Bank) as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_AJM_KYC),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_AJM_KYC),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_AJM_KYC),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_AJM_KYC),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_AJM_KYC),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_AJM_KYC),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_AJM_KYC", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_AJM_KYC", timeperiod),
				"R22_NO_CON_AJM_KYC"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books that reside in Fujairah (as per the KYC document submitted to the Bank) as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_FUJ_KYC),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_FUJ_KYC),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_FUJ_KYC),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_FUJ_KYC),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_FUJ_KYC),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_FUJ_KYC),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_FUJ_KYC", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_FUJ_KYC", timeperiod),
				"R22_NO_CON_FUJ_KYC"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books that reside in Ras Al Khaimah (as per the KYC document submitted to the Bank) as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_RAK_KYC),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_RAK_KYC),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_RAK_KYC),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_RAK_KYC),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_RAK_KYC),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_RAK_KYC),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_RAK_KYC", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_RAK_KYC", timeperiod),
				"R22_NO_CON_RAK_KYC"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books that reside in Umm Al Quwain (as per the KYC document submitted to the Bank) as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_UAQ_KYC),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_UAQ_KYC),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_UAQ_KYC),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_UAQ_KYC),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_UAQ_KYC),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_UAQ_KYC),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_UAQ_KYC", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_UAQ_KYC", timeperiod),
				"R22_NO_CON_UAQ_KYC"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers on the Bank's books tagged by the Bank as \"Retired\" as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_RET),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_RET),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_RET),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_RET),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_RET),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_RET),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_RET", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_RET", timeperiod), "R22_NO_CON_RET"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers as of a specified date who were provided a loan when stress testing results revealed a breach of the CBUAE DBR limits incase of a increased interest/profit rate scenario",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DBR_LIM),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DBR_LIM),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DBR_LIM),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DBR_LIM),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DBR_LIM),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DBR_LIM),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_DBR_LIM", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_DBR_LIM", timeperiod),
				"R22_NO_CON_DBR_LIM"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of UAE national Consumers during the specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_UAE_CON_SPC_TP),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_UAE_CON_SPC_TP),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_UAE_CON_SPC_TP),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_UAE_CON_SPC_TP),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_UAE_CON_SPC_TP),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_UAE_CON_SPC_TP),
				getMakerJustification("bankconsumers", Date, "R22_NO_UAE_CON_SPC_TP", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_UAE_CON_SPC_TP", timeperiod),
				"R22_NO_UAE_CON_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of UAE national Consumers enrolled for National Loan Scheme during the specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_UAE_CON_NLS),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_UAE_CON_NLS),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_UAE_CON_NLS),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_UAE_CON_NLS),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_UAE_CON_NLS),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_UAE_CON_NLS),
				getMakerJustification("bankconsumers", Date, "R22_NO_UAE_CON_NLS", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_UAE_CON_NLS", timeperiod),
				"R22_NO_UAE_CON_NLS"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Value of financial loss suffered by Consumers due to fraud during the specified time period (AED (000's))",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_VAL_LOS_AED),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_VAL_LOS_AED),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_VAL_LOS_AED),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_VAL_LOS_AED),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_VAL_LOS_AED),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_VAL_LOS_AED),
				getMakerJustification("bankconsumers", Date, "R22_VAL_LOS_AED", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_VAL_LOS_AED", timeperiod), "R22_VAL_LOS_AED"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of new consumer onboarded during the specified time period, who became delinquent and cured within 90 days",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ONB_90),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ONB_90),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ONB_90),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ONB_90),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ONB_90),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ONB_90),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_ONB_90", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_ONB_90", timeperiod), "R22_NO_CON_ONB_90"));
		pivotTable.add(
				new RT_MC_Manager_DTO("Number of new Consumers who have received balloon payment options by the Bank",
						getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BAL_PAY),
						getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BAL_PAY),
						getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BAL_PAY),
						getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BAL_PAY),
						getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BAL_PAY),
						getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BAL_PAY),
						getMakerJustification("bankconsumers", Date, "R22_NO_CON_BAL_PAY", timeperiod),
						getCheckerJustification("bankconsumers", Date, "R22_NO_CON_BAL_PAY", timeperiod),
						"R22_NO_CON_BAL_PAY"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers who have received balloon payment options by the Bank during the specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BAL_SPC_TP),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BAL_SPC_TP),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BAL_SPC_TP),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BAL_SPC_TP),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BAL_SPC_TP),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_BAL_SPC_TP),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_BAL_SPC_TP", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_BAL_SPC_TP", timeperiod),
				"R22_NO_CON_BAL_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers receiving debt counseling services during the specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DEBT),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DEBT),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DEBT),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DEBT),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DEBT),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DEBT),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_DEBT", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_DEBT", timeperiod), "R22_NO_CON_DEBT"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of new Consumers onboarded (including consumers onboarded through referrals) during the specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ONB_REF),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ONB_REF),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ONB_REF),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ONB_REF),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ONB_REF),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ONB_REF),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_ONB_REF", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_ONB_REF", timeperiod),
				"R22_NO_CON_ONB_REF"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of new Consumers onboarded by Authorized Agents (including consumers onboarded through referrals) during the specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ONB_AGE),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ONB_AGE),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ONB_AGE),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ONB_AGE),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ONB_AGE),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_ONB_AGE),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_ONB_AGE", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_ONB_AGE", timeperiod),
				"R22_NO_CON_ONB_AGE"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers affected by Unauthorized Transactions during the specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_AFF_UNAU),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_AFF_UNAU),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_AFF_UNAU),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_AFF_UNAU),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_AFF_UNAU),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_AFF_UNAU),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_AFF_UNAU", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_AFF_UNAU", timeperiod),
				"R22_NO_CON_AFF_UNAU"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of accounts held by POD",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_ACCS_POD),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_ACCS_POD),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_ACCS_POD),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_ACCS_POD),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_ACCS_POD),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_OF_ACCS_POD),
				getMakerJustification("bankconsumers", Date, "R22_NO_OF_ACCS_POD", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_OF_ACCS_POD", timeperiod),
				"R22_NO_OF_ACCS_POD"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of Delinquent Consumers as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_DEL_CON),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_DEL_CON),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_DEL_CON),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_DEL_CON),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_DEL_CON),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_DEL_CON),
				getMakerJustification("bankconsumers", Date, "R22_NO_DEL_CON", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_DEL_CON", timeperiod), "R22_NO_DEL_CON"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of instances where consumer funds are misdirected to an incorrect account or recipient, or not reflected in the correct account, due to errors made by the LFI during the specified time period. ",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_INS_FUN_LFI),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_INS_FUN_LFI),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_INS_FUN_LFI),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_INS_FUN_LFI),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_INS_FUN_LFI),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_INS_FUN_LFI),
				getMakerJustification("bankconsumers", Date, "R22_NO_INS_FUN_LFI", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_INS_FUN_LFI", timeperiod),
				"R22_NO_INS_FUN_LFI"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of customer who provided consent to waive off their cooling off periods for financing products",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_COL_FIN),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_COL_FIN),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_COL_FIN),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_COL_FIN),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_COL_FIN),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_COL_FIN),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_COL_FIN", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_COL_FIN", timeperiod),
				"R22_NO_CON_COL_FIN"));
		pivotTable.add(new RT_MC_Manager_DTO("Total number of new customers who availed the financing products",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_TOT_NO_NEW_FIN),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_TOT_NO_NEW_FIN),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_TOT_NO_NEW_FIN),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_TOT_NO_NEW_FIN),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_TOT_NO_NEW_FIN),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_TOT_NO_NEW_FIN),
				getMakerJustification("bankconsumers", Date, "R22_TOT_NO_NEW_FIN", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_TOT_NO_NEW_FIN", timeperiod),
				"R22_TOT_NO_NEW_FIN"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total number of consumers which were onboarded, without signed acknowledgement of the receipt of Key Facts Statement",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_TOT_NO_NEW_NOSGN),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_TOT_NO_NEW_NOSGN),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_TOT_NO_NEW_NOSGN),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_TOT_NO_NEW_NOSGN),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_TOT_NO_NEW_NOSGN),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_TOT_NO_NEW_NOSGN),
				getMakerJustification("bankconsumers", Date, "R22_TOT_NO_NEW_NOSGN", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_TOT_NO_NEW_NOSGN", timeperiod),
				"R22_TOT_NO_NEW_NOSGN"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of consumers at the start of the period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_START),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_START),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_START),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_START),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_START),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_START),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_START", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_START", timeperiod), "R22_NO_CON_START"));
		pivotTable.add(
				new RT_MC_Manager_DTO("Number of new Consumers onboarded by the Bank during the specified time period",
						getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_NEW_CON_ONBO),
						getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_NEW_CON_ONBO),
						getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_NEW_CON_ONBO),
						getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_NEW_CON_ONBO),
						getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_NEW_CON_ONBO),
						getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_NEW_CON_ONBO),
						getMakerJustification("bankconsumers", Date, "R22_NO_NEW_CON_ONBO", timeperiod),
						getCheckerJustification("bankconsumers", Date, "R22_NO_NEW_CON_ONBO", timeperiod),
						"R22_NO_NEW_CON_ONBO"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of contactable Consumers receiving debt counselling services during the specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DEBT_COUN),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DEBT_COUN),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DEBT_COUN),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DEBT_COUN),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DEBT_COUN),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DEBT_COUN),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_DEBT_COUN", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_DEBT_COUN", timeperiod),
				"R22_NO_CON_DEBT_COUN"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of consumers who become delinquent or tagged as NPA during the specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DEL_NPA),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DEL_NPA),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DEL_NPA),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DEL_NPA),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DEL_NPA),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_DEL_NPA),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_DEL_NPA", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_DEL_NPA", timeperiod),
				"R22_NO_CON_DEL_NPA"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers (excluding government housing schemes consumers) having DBR greater than or equal to 50% as of the specified date.",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_GOV_50),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_GOV_50),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_GOV_50),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_GOV_50),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_GOV_50),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_GOV_50),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_GOV_50", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_GOV_50", timeperiod), "R22_NO_CON_GOV_50"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of SME consumers (including Sole proprietorships)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_SME_SOLE),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_SME_SOLE),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_SME_SOLE),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_SME_SOLE),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_SME_SOLE),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_SME_SOLE),
				getMakerJustification("bankconsumers", Date, "R22_NO_SME_SOLE", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_SME_SOLE", timeperiod), "R22_NO_SME_SOLE"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of consumers tagged as Vulnerable Consumers",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_TAG_VUL),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_TAG_VUL),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_TAG_VUL),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_TAG_VUL),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_TAG_VUL),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_TAG_VUL),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_TAG_VUL", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_TAG_VUL", timeperiod),
				"R22_NO_CON_TAG_VUL"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of new customer onboarded in a given period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_NEW_CON_ONB_GNP),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_NEW_CON_ONB_GNP),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_NEW_CON_ONB_GNP),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_NEW_CON_ONB_GNP),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_NEW_CON_ONB_GNP),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_NEW_CON_ONB_GNP),
				getMakerJustification("bankconsumers", Date, "R22_NO_NEW_CON_ONB_GNP", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_NEW_CON_ONB_GNP", timeperiod),
				"R22_NO_NEW_CON_ONB_GNP"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of consumers at end of the period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_END),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_END),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_END),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_END),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_END),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE2_2_ENTITY::getR22_NO_CON_END),
				getMakerJustification("bankconsumers", Date, "R22_NO_CON_END", timeperiod),
				getCheckerJustification("bankconsumers", Date, "R22_NO_CON_END", timeperiod), "R22_NO_CON_END"));

		Map<String, Object> modelData = new HashMap<>();
		modelData.put("headerDates", headerDates);
		modelData.put("yearDates", yearDates);
		modelData.put("reportRows", pivotTable);

		return modelData;
	}

	public Map<String, Object> getManagerViewDataTable3(String Date, String timeperiod) {
		List<RT_MC_TABLE3_ENTITY> top4Rows = RT_MC_TABLE3_REPO.findLastFourReports(Date, "QUARTERLY");
		List<RT_MC_TABLE3_ENTITY> top2RowsYearly = RT_MC_TABLE3_REPO.findLastTwoReports(Date, "YEARLY");
		List<String> headerDates = new ArrayList<>();
		List<String> yearDates = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM - yyyy");

		for (RT_MC_TABLE3_ENTITY row : top4Rows) {
			Date rawDate = row.getREPORT_DATE();
			LocalDate displayDate = new java.sql.Date(rawDate.getTime()).toLocalDate();
			headerDates.add(displayDate.format(formatter));
		}

		for (RT_MC_TABLE3_ENTITY row : top2RowsYearly) {
			Date rawDate = row.getREPORT_DATE();
			LocalDate displayDate = new java.sql.Date(rawDate.getTime()).toLocalDate();
			yearDates.add("Yearly - " + displayDate.format(formatter));
		}

		List<RT_MC_Manager_DTO> pivotTable = new ArrayList<>();

		pivotTable.add(new RT_MC_Manager_DTO("Number of complaints during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_SPC_TP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_SPC_TP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_SPC_TP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_SPC_TP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_SPC_TP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_SPC_TP),
				getMakerJustification("complaints", Date, "R22_NO_COM_SPC_TP", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_SPC_TP", timeperiod), "R22_NO_COM_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of complaints pending in court",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_PEN),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_PEN),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_PEN),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_PEN),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_PEN),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_PEN),
				getMakerJustification("complaints", Date, "R22_NO_COM_PEN", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_PEN", timeperiod), "R22_NO_COM_PEN"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Amount of financial compensation provided to consumers as redressal for the complaints raised (AED (000's))",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_AMT_FIN_AED),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_AMT_FIN_AED),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_AMT_FIN_AED),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_AMT_FIN_AED),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_AMT_FIN_AED),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_AMT_FIN_AED),
				getMakerJustification("complaints", Date, "R22_AMT_FIN_AED", timeperiod),
				getCheckerJustification("complaints", Date, "R22_AMT_FIN_AED", timeperiod), "R22_AMT_FIN_AED"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of complaints received by Bank on misleading or false advertisements such as incomplete information or improper disclosure such as annual fees/product features (excluding complaints against Authorized Agents)",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_ADV_FEES),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_ADV_FEES),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_ADV_FEES),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_ADV_FEES),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_ADV_FEES),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_ADV_FEES),
				getMakerJustification("complaints", Date, "R22_NO_COM_ADV_FEES", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_ADV_FEES", timeperiod), "R22_NO_COM_ADV_FEES"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of complaints filed by People of Determination during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_DET_SPC_PT),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_DET_SPC_PT),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_DET_SPC_PT),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_DET_SPC_PT),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_DET_SPC_PT),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_DET_SPC_PT),
				getMakerJustification("complaints", Date, "R22_NO_COM_DET_SPC_PT", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_DET_SPC_PT", timeperiod),
				"R22_NO_COM_DET_SPC_PT"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of complaints received on issues dealing with debt collection",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_DEBT),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_DEBT),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_DEBT),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_DEBT),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_DEBT),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_DEBT),
				getMakerJustification("complaints", Date, "R22_NO_COM_DEBT", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_DEBT", timeperiod), "R22_NO_COM_DEBT"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of complaints received against Authorized Agents during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_AGNT),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_AGNT),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_AGNT),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_AGNT),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_AGNT),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_AGNT),
				getMakerJustification("complaints", Date, "R22_NO_COM_AGNT", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_AGNT", timeperiod), "R22_NO_COM_AGNT"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of complaints related to mis-selling by Authorized Agents during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_MISSEL),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_MISSEL),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_MISSEL),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_MISSEL),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_MISSEL),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_MISSEL),
				getMakerJustification("complaints", Date, "R22_NO_COM_MISSEL", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_MISSEL", timeperiod), "R22_NO_COM_MISSEL"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers that filed complaints during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FILCOM),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FILCOM),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FILCOM),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FILCOM),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FILCOM),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FILCOM),
				getMakerJustification("complaints", Date, "R22_NO_COM_FILCOM", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_FILCOM", timeperiod), "R22_NO_COM_FILCOM"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of complaints related to fees and charges on Bank's products and services during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_PRO_SER),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_PRO_SER),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_PRO_SER),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_PRO_SER),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_PRO_SER),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_PRO_SER),
				getMakerJustification("complaints", Date, "R22_NO_COM_PRO_SER", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_PRO_SER", timeperiod), "R22_NO_COM_PRO_SER"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of root cause analysis conducted on the complaints associated with each of the following products during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_ASO_PROD),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_ASO_PROD),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_ASO_PROD),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_ASO_PROD),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_ASO_PROD),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_ASO_PROD),
				getMakerJustification("complaints", Date, "R22_NO_ASO_PROD", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_ASO_PROD", timeperiod), "R22_NO_ASO_PROD"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumer complaints received through a dedicated phone line during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_CON_PHN),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_CON_PHN),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_CON_PHN),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_CON_PHN),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_CON_PHN),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_CON_PHN),
				getMakerJustification("complaints", Date, "R22_NO_CON_PHN", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_CON_PHN", timeperiod), "R22_NO_CON_PHN"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumer complaints received through a secure web based portal system during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_CON_WEB),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_CON_WEB),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_CON_WEB),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_CON_WEB),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_CON_WEB),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_CON_WEB),
				getMakerJustification("complaints", Date, "R22_NO_CON_WEB", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_CON_WEB", timeperiod), "R22_NO_CON_WEB"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumer complaints received through the Bank's website during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_CON_BNK),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_CON_BNK),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_CON_BNK),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_CON_BNK),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_CON_BNK),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_CON_BNK),
				getMakerJustification("complaints", Date, "R22_NO_CON_BNK", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_CON_BNK", timeperiod), "R22_NO_CON_BNK"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of outstanding complaints (unresolved complaints) during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_OUT_UNRES),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_OUT_UNRES),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_OUT_UNRES),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_OUT_UNRES),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_OUT_UNRES),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_OUT_UNRES),
				getMakerJustification("complaints", Date, "R22_NO_OUT_UNRES", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_OUT_UNRES", timeperiod), "R22_NO_OUT_UNRES"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of complaints which were resolved in favor of the Consumers during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_RES_CON),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_RES_CON),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_RES_CON),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_RES_CON),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_RES_CON),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_RES_CON),
				getMakerJustification("complaints", Date, "R22_NO_COM_RES_CON", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_RES_CON", timeperiod), "R22_NO_COM_RES_CON"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of resolved complaints after 30 days from the date of raising of complaint as of the specified date",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_RES_30_COM),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_RES_30_COM),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_RES_30_COM),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_RES_30_COM),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_RES_30_COM),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_RES_30_COM),
				getMakerJustification("complaints", Date, "R22_NO_RES_30_COM", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_RES_30_COM", timeperiod), "R22_NO_RES_30_COM"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Average time taken to resolve complaints during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_AVG_TME_RES_COM),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_AVG_TME_RES_COM),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_AVG_TME_RES_COM),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_AVG_TME_RES_COM),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_AVG_TME_RES_COM),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_AVG_TME_RES_COM),
				getMakerJustification("complaints", Date, "R22_AVG_TME_RES_COM", timeperiod),
				getCheckerJustification("complaints", Date, "R22_AVG_TME_RES_COM", timeperiod), "R22_AVG_TME_RES_COM"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of complaints received on staff misconduct during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_STF_MIS),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_STF_MIS),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_STF_MIS),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_STF_MIS),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_STF_MIS),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_STF_MIS),
				getMakerJustification("complaints", Date, "R22_NO_COM_STF_MIS", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_STF_MIS", timeperiod), "R22_NO_COM_STF_MIS"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of complaints filed by People of Determination Consumers on accessibility (branches, ATMs, kiosk machines, website) during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_ATM_WEB),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_ATM_WEB),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_ATM_WEB),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_ATM_WEB),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_ATM_WEB),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_ATM_WEB),
				getMakerJustification("complaints", Date, "R22_NO_COM_ATM_WEB", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_ATM_WEB", timeperiod), "R22_NO_COM_ATM_WEB"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of complaints received by Consumers who have incurred financial loss during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FIN_LOS),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FIN_LOS),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FIN_LOS),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FIN_LOS),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FIN_LOS),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FIN_LOS),
				getMakerJustification("complaints", Date, "R22_NO_COM_FIN_LOS", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_FIN_LOS", timeperiod), "R22_NO_COM_FIN_LOS"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of complaints resolved in favor of Consumers wherein financial loss is involved during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FAV_LOS),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FAV_LOS),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FAV_LOS),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FAV_LOS),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FAV_LOS),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FAV_LOS),
				getMakerJustification("complaints", Date, "R22_NO_COM_FAV_LOS", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_FAV_LOS", timeperiod), "R22_NO_COM_FAV_LOS"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of complaints at previous reporting period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_PRV_PER),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_PRV_PER),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_PRV_PER),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_PRV_PER),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_PRV_PER),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_PRV_PER),
				getMakerJustification("complaints", Date, "R22_NO_COM_PRV_PER", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_PRV_PER", timeperiod), "R22_NO_COM_PRV_PER"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of resolved Complaints",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_RES_COM),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_RES_COM),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_RES_COM),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_RES_COM),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_RES_COM),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_RES_COM),
				getMakerJustification("complaints", Date, "R22_NO_RES_COM", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_RES_COM", timeperiod), "R22_NO_RES_COM"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of steps a consumer needs to go through to report a complaint related to loss, theft, fraud or misuse of consumer’s products and services",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_STEP_LOS),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_STEP_LOS),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_STEP_LOS),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_STEP_LOS),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_STEP_LOS),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_STEP_LOS),
				getMakerJustification("complaints", Date, "R22_NO_STEP_LOS", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_STEP_LOS", timeperiod), "R22_NO_STEP_LOS"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of customer complaints that evolved into legal cases during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_CUST_LEGAL),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_CUST_LEGAL),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_CUST_LEGAL),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_CUST_LEGAL),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_CUST_LEGAL),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_CUST_LEGAL),
				getMakerJustification("complaints", Date, "R22_NO_CUST_LEGAL", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_CUST_LEGAL", timeperiod), "R22_NO_CUST_LEGAL"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of complaints related to failure to provide clear contractual terms raised by consumers",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FAIL),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FAIL),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FAIL),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FAIL),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FAIL),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_FAIL),
				getMakerJustification("complaints", Date, "R22_NO_COM_FAIL", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_FAIL", timeperiod), "R22_NO_COM_FAIL"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"(Number of complaints related to not taking a expressed or explicit consent from consumers",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_EXP_CON),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_EXP_CON),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_EXP_CON),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_EXP_CON),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_EXP_CON),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_EXP_CON),
				getMakerJustification("complaints", Date, "R22_NO_COM_EXP_CON", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_EXP_CON", timeperiod), "R22_NO_COM_EXP_CON"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of complaints escalated to Sanadak",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_SANA),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_SANA),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_SANA),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_SANA),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_SANA),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_SANA),
				getMakerJustification("complaints", Date, "R22_NO_COM_SANA", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_SANA", timeperiod), "R22_NO_COM_SANA"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of complaints escalated by Sanadak to CBUAE Market Conduct Supervision Department",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_CBUAE_SD),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_CBUAE_SD),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_CBUAE_SD),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_CBUAE_SD),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_CBUAE_SD),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_CBUAE_SD),
				getMakerJustification("complaints", Date, "R22_NO_COM_CBUAE_SD", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_CBUAE_SD", timeperiod), "R22_NO_COM_CBUAE_SD"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of resolved complaints after 7 days from the date of raising the complaint as of specified date",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_RES_COM_7),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_RES_COM_7),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_RES_COM_7),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_RES_COM_7),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_RES_COM_7),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_RES_COM_7),
				getMakerJustification("complaints", Date, "R22_NO_RES_COM_7", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_RES_COM_7", timeperiod), "R22_NO_RES_COM_7"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of resolved complaints (excluding disputed transactions through schemes) after 15 days from the date of raising of complaint as of the specified date",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_RES_COM_15),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_RES_COM_15),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_RES_COM_15),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_RES_COM_15),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_RES_COM_15),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_RES_COM_15),
				getMakerJustification("complaints", Date, "R22_NO_RES_COM_15", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_RES_COM_15", timeperiod), "R22_NO_RES_COM_15"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of complaints upheld (in favour of consumer)",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_UPHEL),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_UPHEL),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_UPHEL),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_UPHEL),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_UPHEL),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_UPHEL),
				getMakerJustification("complaints", Date, "R22_NO_COM_UPHEL", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_UPHEL", timeperiod), "R22_NO_COM_UPHEL"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of complaints received against Bank's Staff during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_BNK_STF),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_BNK_STF),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_BNK_STF),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_BNK_STF),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_BNK_STF),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_BNK_STF),
				getMakerJustification("complaints", Date, "R22_NO_COM_BNK_STF", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_BNK_STF", timeperiod), "R22_NO_COM_BNK_STF"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of complaints received against inhouse Authorized agent staff during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_INHOU),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_INHOU),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_INHOU),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_INHOU),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_INHOU),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_INHOU),
				getMakerJustification("complaints", Date, "R22_NO_COM_INHOU", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_INHOU", timeperiod), "R22_NO_COM_INHOU"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of complaints acknowledged outside target time",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_ACK_TT),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_ACK_TT),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_ACK_TT),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_ACK_TT),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_ACK_TT),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_ACK_TT),
				getMakerJustification("complaints", Date, "R22_NO_COM_ACK_TT", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_ACK_TT", timeperiod), "R22_NO_COM_ACK_TT"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of complaints related to Authorized agents on issues dealing with Debt Collection",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_DEBT_COLL),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_DEBT_COLL),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_DEBT_COLL),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_DEBT_COLL),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_DEBT_COLL),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_DEBT_COLL),
				getMakerJustification("complaints", Date, "R22_NO_COM_DEBT_COLL", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_DEBT_COLL", timeperiod),
				"R22_NO_COM_DEBT_COLL"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of instances of complaints or requests by consumers to change their credit rating during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_INST_CRE_RATE),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_INST_CRE_RATE),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_INST_CRE_RATE),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_INST_CRE_RATE),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_INST_CRE_RATE),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_INST_CRE_RATE),
				getMakerJustification("complaints", Date, "R22_NO_INST_CRE_RATE", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_INST_CRE_RATE", timeperiod),
				"R22_NO_INST_CRE_RATE"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of consumer complaints due to delayed remittance",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_CON_DELAY),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_CON_DELAY),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_CON_DELAY),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_CON_DELAY),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_CON_DELAY),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_CON_DELAY),
				getMakerJustification("complaints", Date, "R22_NO_CON_DELAY", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_CON_DELAY", timeperiod), "R22_NO_CON_DELAY"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of complaints at reporting date",
				getSafeValue(top4Rows, 3, RT_MC_TABLE3_ENTITY::getR22_NO_COM_REP_DTE),
				getSafeValue(top4Rows, 2, RT_MC_TABLE3_ENTITY::getR22_NO_COM_REP_DTE),
				getSafeValue(top4Rows, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_REP_DTE),
				getSafeValue(top4Rows, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_REP_DTE),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE3_ENTITY::getR22_NO_COM_REP_DTE),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE3_ENTITY::getR22_NO_COM_REP_DTE),
				getMakerJustification("complaints", Date, "R22_NO_COM_REP_DTE", timeperiod),
				getCheckerJustification("complaints", Date, "R22_NO_COM_REP_DTE", timeperiod), "R22_NO_COM_REP_DTE"));

		Map<String, Object> modelData = new HashMap<>();
		modelData.put("headerDates", headerDates);
		modelData.put("yearDates", yearDates);
		modelData.put("reportRows", pivotTable);

		return modelData;
	}

	public Map<String, Object> getManagerViewDataTable4(String Date, String timeperiod) {
		List<RT_MC_TABLE4_2_ENTITY> top4Rowstable2 = RT_MC_TABLE4_2_REPO.findLastFourReports(Date, "QUARTERLY");
		List<RT_MC_TABLE4_2_ENTITY> top2RowsYearlytable2 = RT_MC_TABLE4_2_REPO.findLastTwoReports(Date, "YEARLY");

		List<String> headerDates = new ArrayList<>();
		List<String> yearDates = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM - yyyy");

		for (RT_MC_TABLE4_2_ENTITY row : top4Rowstable2) {
			Date rawDate = row.getREPORT_DATE();
			LocalDate displayDate = new java.sql.Date(rawDate.getTime()).toLocalDate();
			headerDates.add(displayDate.format(formatter));
		}

		for (RT_MC_TABLE4_2_ENTITY row : top2RowsYearlytable2) {
			Date rawDate = row.getREPORT_DATE();
			LocalDate displayDate = new java.sql.Date(rawDate.getTime()).toLocalDate();
			yearDates.add("Yearly - " + displayDate.format(formatter));
		}

		List<RT_MC_Manager_DTO> pivotTable = new ArrayList<>();

		pivotTable.add(new RT_MC_Manager_DTO(
				"Average time taken to open an account for a consumer categorized as low risk (Days)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_AVG_TME_LWRSK),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_AVG_TME_LWRSK),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_AVG_TME_LWRSK),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_AVG_TME_LWRSK),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_AVG_TME_LWRSK),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_AVG_TME_LWRSK),
				getMakerJustification("retailproducts", Date, "R22_AVG_TME_LWRSK", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_AVG_TME_LWRSK", timeperiod), "R22_AVG_TME_LWRSK"));
		pivotTable.add(new RT_MC_Manager_DTO("Average number of days taken to disburse a loan (Days)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NO_LOAN),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NO_LOAN),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NO_LOAN),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NO_LOAN),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NO_LOAN),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NO_LOAN),
				getMakerJustification("retailproducts", Date, "R22_AVG_NO_LOAN", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_AVG_NO_LOAN", timeperiod), "R22_AVG_NO_LOAN"));
		pivotTable.add(new RT_MC_Manager_DTO("Average number of days taken to open low risk SME accounts (days)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NO_LWRSK_SME),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NO_LWRSK_SME),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NO_LWRSK_SME),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NO_LWRSK_SME),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NO_LWRSK_SME),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NO_LWRSK_SME),
				getMakerJustification("retailproducts", Date, "R22_AVG_NO_LWRSK_SME", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_AVG_NO_LWRSK_SME", timeperiod),
				"R22_AVG_NO_LWRSK_SME"));
		pivotTable.add(new RT_MC_Manager_DTO("Average number of days taken to disburse SME loans (Days)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NO_DYS_SME),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NO_DYS_SME),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NO_DYS_SME),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NO_DYS_SME),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NO_DYS_SME),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NO_DYS_SME),
				getMakerJustification("retailproducts", Date, "R22_AVG_NO_DYS_SME", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_AVG_NO_DYS_SME", timeperiod),
				"R22_AVG_NO_DYS_SME"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of requests for closure",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NO_REQ_CLO),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NO_REQ_CLO),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_REQ_CLO),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_REQ_CLO),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_REQ_CLO),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_REQ_CLO),
				getMakerJustification("retailproducts", Date, "R22_NO_REQ_CLO", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NO_REQ_CLO", timeperiod), "R22_NO_REQ_CLO"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of Product Variants during the specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NO_PRD_VAR_SPC_TP),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NO_PRD_VAR_SPC_TP),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_PRD_VAR_SPC_TP),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_PRD_VAR_SPC_TP),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_PRD_VAR_SPC_TP),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_PRD_VAR_SPC_TP),
				getMakerJustification("retailproducts", Date, "R22_NO_PRD_VAR_SPC_TP", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NO_PRD_VAR_SPC_TP", timeperiod),
				"R22_NO_PRD_VAR_SPC_TP"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of requests for restructuring/rescheduling received during the specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NO_REQ_RES_SPT),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NO_REQ_RES_SPT),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_REQ_RES_SPT),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_REQ_RES_SPT),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_REQ_RES_SPT),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_REQ_RES_SPT),
				getMakerJustification("retailproducts", Date, "R22_NO_REQ_RES_SPT", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NO_REQ_RES_SPT", timeperiod),
				"R22_NO_REQ_RES_SPT"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of requests for payment deferrals received during the specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NO_REQ_PAYDEF),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NO_REQ_PAYDEF),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_REQ_PAYDEF),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_REQ_PAYDEF),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_REQ_PAYDEF),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_REQ_PAYDEF),
				getMakerJustification("retailproducts", Date, "R22_NO_REQ_PAYDEF", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NO_REQ_PAYDEF", timeperiod), "R22_NO_REQ_PAYDEF"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Average time taken to provide Consumers with revised repayment/payment arrangement (Days)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_AVG_TME_REPAY),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_AVG_TME_REPAY),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_AVG_TME_REPAY),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_AVG_TME_REPAY),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_AVG_TME_REPAY),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_AVG_TME_REPAY),
				getMakerJustification("retailproducts", Date, "R22_AVG_TME_REPAY", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_AVG_TME_REPAY", timeperiod), "R22_AVG_TME_REPAY"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of instances where Bank trangressions (errors and omissions) affected the balance reflection of Consumers",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NO_INST_BAL),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NO_INST_BAL),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_INST_BAL),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_INST_BAL),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_INST_BAL),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_INST_BAL),
				getMakerJustification("retailproducts", Date, "R22_NO_INST_BAL", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NO_INST_BAL", timeperiod), "R22_NO_INST_BAL"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Net Non-Interest/Profit (such as fees and commissions) earned during the specified time period (AED (000's))",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NET_FEE_AED),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NET_FEE_AED),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NET_FEE_AED),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NET_FEE_AED),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NET_FEE_AED),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NET_FEE_AED),
				getMakerJustification("retailproducts", Date, "R22_NET_FEE_AED", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NET_FEE_AED", timeperiod), "R22_NET_FEE_AED"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Net Interest/Profit earned during the specified time period (AED (000's))",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NET_PROF_AED),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NET_PROF_AED),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NET_PROF_AED),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NET_PROF_AED),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NET_PROF_AED),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NET_PROF_AED),
				getMakerJustification("retailproducts", Date, "R22_NET_PROF_AED", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NET_PROF_AED", timeperiod), "R22_NET_PROF_AED"));
		pivotTable.add(new RT_MC_Manager_DTO("Total number of accounts or loans as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_TOT_NO_ACC_SPD),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_TOT_NO_ACC_SPD),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_NO_ACC_SPD),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_NO_ACC_SPD),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_NO_ACC_SPD),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_NO_ACC_SPD),
				getMakerJustification("retailproducts", Date, "R22_TOT_NO_ACC_SPD", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_TOT_NO_ACC_SPD", timeperiod),
				"R22_TOT_NO_ACC_SPD"));
		pivotTable.add(new RT_MC_Manager_DTO("Total number of accounts that has been marked as Dormant Account",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_TOT_ACCS_DOR),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_TOT_ACCS_DOR),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_ACCS_DOR),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_ACCS_DOR),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_ACCS_DOR),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_ACCS_DOR),
				getMakerJustification("retailproducts", Date, "R22_TOT_ACCS_DOR", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_TOT_ACCS_DOR", timeperiod), "R22_TOT_ACCS_DOR"));
		pivotTable.add(new RT_MC_Manager_DTO("Total Number of new loan given during the specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_TOT_NEW_LOAN),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_TOT_NEW_LOAN),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_NEW_LOAN),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_NEW_LOAN),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_NEW_LOAN),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_NEW_LOAN),
				getMakerJustification("retailproducts", Date, "R22_TOT_NEW_LOAN", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_TOT_NEW_LOAN", timeperiod), "R22_TOT_NEW_LOAN"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total value associated with new loan accounts given during the specified time period (AED (000's))",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_TOT_VAL_NEWACCS_AED),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_TOT_VAL_NEWACCS_AED),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_VAL_NEWACCS_AED),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_VAL_NEWACCS_AED),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_VAL_NEWACCS_AED),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_VAL_NEWACCS_AED),
				getMakerJustification("retailproducts", Date, "R22_TOT_VAL_NEWACCS_AED", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_TOT_VAL_NEWACCS_AED", timeperiod),
				"R22_TOT_VAL_NEWACCS_AED"));
		pivotTable.add(
				new RT_MC_Manager_DTO("Total number of account or loan applications received as of the specified date",
						getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_TOT_NO_LOAN_SPD),
						getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_TOT_NO_LOAN_SPD),
						getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_NO_LOAN_SPD),
						getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_NO_LOAN_SPD),
						getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_NO_LOAN_SPD),
						getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_NO_LOAN_SPD),
						getMakerJustification("retailproducts", Date, "R22_TOT_NO_LOAN_SPD", timeperiod),
						getCheckerJustification("retailproducts", Date, "R22_TOT_NO_LOAN_SPD", timeperiod),
						"R22_TOT_NO_LOAN_SPD"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total Number of request of transfer of loans from the Bank to another Bank during the specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_TOT_REQ_OTBNK),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_TOT_REQ_OTBNK),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_REQ_OTBNK),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_REQ_OTBNK),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_REQ_OTBNK),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_REQ_OTBNK),
				getMakerJustification("retailproducts", Date, "R22_TOT_REQ_OTBNK", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_TOT_REQ_OTBNK", timeperiod), "R22_TOT_REQ_OTBNK"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total number of loans transferred from the Bank to another Bank during the specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_TOT_LOAN_OTBNK),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_TOT_LOAN_OTBNK),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_LOAN_OTBNK),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_LOAN_OTBNK),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_LOAN_OTBNK),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_LOAN_OTBNK),
				getMakerJustification("retailproducts", Date, "R22_TOT_LOAN_OTBNK", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_TOT_LOAN_OTBNK", timeperiod),
				"R22_TOT_LOAN_OTBNK"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of credit card accounts where the Consumer paid only the minimum payment (instead of full outstanding amount) during the specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NO_CRACC_MIN),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NO_CRACC_MIN),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_CRACC_MIN),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_CRACC_MIN),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_CRACC_MIN),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_CRACC_MIN),
				getMakerJustification("retailproducts", Date, "R22_NO_CRACC_MIN", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NO_CRACC_MIN", timeperiod), "R22_NO_CRACC_MIN"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Average time taken to close an account (other than credit cards and investment accounts) (Days)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_AVG_TME_CLSACC),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_AVG_TME_CLSACC),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_AVG_TME_CLSACC),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_AVG_TME_CLSACC),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_AVG_TME_CLSACC),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_AVG_TME_CLSACC),
				getMakerJustification("retailproducts", Date, "R22_AVG_TME_CLSACC", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_AVG_TME_CLSACC", timeperiod),
				"R22_AVG_TME_CLSACC"));
		pivotTable
				.add(new RT_MC_Manager_DTO("Number of Consumers that received more than one (1) rescheduling of loans",
						getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_N0_CON_MORE1_LOAN),
						getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_N0_CON_MORE1_LOAN),
						getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_N0_CON_MORE1_LOAN),
						getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_N0_CON_MORE1_LOAN),
						getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_N0_CON_MORE1_LOAN),
						getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_N0_CON_MORE1_LOAN),
						getMakerJustification("retailproducts", Date, "R22_N0_CON_MORE1_LOAN", timeperiod),
						getCheckerJustification("retailproducts", Date, "R22_N0_CON_MORE1_LOAN", timeperiod),
						"R22_N0_CON_MORE1_LOAN"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of instances where Consumers terminated their business relationship (i.e., account closure) within 90 days of  opening it with the Bank during the specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NO_INST_WITH90),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NO_INST_WITH90),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_INST_WITH90),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_INST_WITH90),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_INST_WITH90),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_INST_WITH90),
				getMakerJustification("retailproducts", Date, "R22_NO_INST_WITH90", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NO_INST_WITH90", timeperiod),
				"R22_NO_INST_WITH90"));
		pivotTable.add(new RT_MC_Manager_DTO("Total Gross Assets",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_TOT_GROSS_ASET),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_TOT_GROSS_ASET),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_GROSS_ASET),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_GROSS_ASET),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_GROSS_ASET),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_GROSS_ASET),
				getMakerJustification("retailproducts", Date, "R22_TOT_GROSS_ASET", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_TOT_GROSS_ASET", timeperiod),
				"R22_TOT_GROSS_ASET"));
		pivotTable.add(new RT_MC_Manager_DTO("Retail Asset/ liabilitySize as of the specified date (AED (000's))",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_RET_LIAB_AED),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_RET_LIAB_AED),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_RET_LIAB_AED),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_RET_LIAB_AED),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_RET_LIAB_AED),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_RET_LIAB_AED),
				getMakerJustification("retailproducts", Date, "R22_RET_LIAB_AED", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_RET_LIAB_AED", timeperiod), "R22_RET_LIAB_AED"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Highest Annual Percentage Rates levied on each of the product category during the specified time period*",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_HIG_PER_PROD_CAT),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_HIG_PER_PROD_CAT),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_HIG_PER_PROD_CAT),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_HIG_PER_PROD_CAT),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_HIG_PER_PROD_CAT),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_HIG_PER_PROD_CAT),
				getMakerJustification("retailproducts", Date, "R22_HIG_PER_PROD_CAT", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_HIG_PER_PROD_CAT", timeperiod),
				"R22_HIG_PER_PROD_CAT"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of accounts tagged under NPA (Non Performing Assets)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NO_ACCS_TAG_NPA),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NO_ACCS_TAG_NPA),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_ACCS_TAG_NPA),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_ACCS_TAG_NPA),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_ACCS_TAG_NPA),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_ACCS_TAG_NPA),
				getMakerJustification("retailproducts", Date, "R22_NO_ACCS_TAG_NPA", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NO_ACCS_TAG_NPA", timeperiod),
				"R22_NO_ACCS_TAG_NPA"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of instances of change in fees and charges being greater than 5%",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NO_CHG_FEE_GRT5),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NO_CHG_FEE_GRT5),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_CHG_FEE_GRT5),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_CHG_FEE_GRT5),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_CHG_FEE_GRT5),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_CHG_FEE_GRT5),
				getMakerJustification("retailproducts", Date, "R22_NO_CHG_FEE_GRT5", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NO_CHG_FEE_GRT5", timeperiod),
				"R22_NO_CHG_FEE_GRT5"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers with loan accounts that have flexible interest rates as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NO_CON_FLEX_INT),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NO_CON_FLEX_INT),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_CON_FLEX_INT),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_CON_FLEX_INT),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_CON_FLEX_INT),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_CON_FLEX_INT),
				getMakerJustification("retailproducts", Date, "R22_NO_CON_FLEX_INT", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NO_CON_FLEX_INT", timeperiod),
				"R22_NO_CON_FLEX_INT"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Consumers with loan accounts that have fixed interest rates as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NO_CON_FIXED_INT),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NO_CON_FIXED_INT),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_CON_FIXED_INT),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_CON_FIXED_INT),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_CON_FIXED_INT),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_CON_FIXED_INT),
				getMakerJustification("retailproducts", Date, "R22_NO_CON_FIXED_INT", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NO_CON_FIXED_INT", timeperiod),
				"R22_NO_CON_FIXED_INT"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of loans disbursed prior to May 2011 as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NO_LOAN_MAY_2011),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NO_LOAN_MAY_2011),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_LOAN_MAY_2011),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_LOAN_MAY_2011),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_LOAN_MAY_2011),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_LOAN_MAY_2011),
				getMakerJustification("retailproducts", Date, "R22_NO_LOAN_MAY_2011", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NO_LOAN_MAY_2011", timeperiod),
				"R22_NO_LOAN_MAY_2011"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Value of Legacy Loans (loans disbursed prior to May 2011) outstanding as of the specified date (AED (000's))",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_VAL_LEGA_MAY_AED),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_VAL_LEGA_MAY_AED),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_VAL_LEGA_MAY_AED),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_VAL_LEGA_MAY_AED),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_VAL_LEGA_MAY_AED),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_VAL_LEGA_MAY_AED),
				getMakerJustification("retailproducts", Date, "R22_VAL_LEGA_MAY_AED", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_VAL_LEGA_MAY_AED", timeperiod),
				"R22_VAL_LEGA_MAY_AED"));
		pivotTable.add(new RT_MC_Manager_DTO("Average number of days taken to issue no liability letters (Days)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_AVG_DAY_NLL),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_AVG_DAY_NLL),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_AVG_DAY_NLL),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_AVG_DAY_NLL),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_AVG_DAY_NLL),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_AVG_DAY_NLL),
				getMakerJustification("retailproducts", Date, "R22_AVG_DAY_NLL", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_AVG_DAY_NLL", timeperiod), "R22_AVG_DAY_NLL"));
		pivotTable.add(new RT_MC_Manager_DTO("Percentage of dormant accounts",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_PER_DOR_ACCS),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_PER_DOR_ACCS),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_PER_DOR_ACCS),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_PER_DOR_ACCS),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_PER_DOR_ACCS),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_PER_DOR_ACCS),
				getMakerJustification("retailproducts", Date, "R22_PER_DOR_ACCS", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_PER_DOR_ACCS", timeperiod), "R22_PER_DOR_ACCS"));
		pivotTable.add(new RT_MC_Manager_DTO("Interest income to retail portfolio",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_INT_RET_PROF),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_INT_RET_PROF),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_INT_RET_PROF),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_INT_RET_PROF),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_INT_RET_PROF),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_INT_RET_PROF),
				getMakerJustification("retailproducts", Date, "R22_INT_RET_PROF", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_INT_RET_PROF", timeperiod), "R22_INT_RET_PROF"));
		pivotTable.add(new RT_MC_Manager_DTO("Fees and commissions to retail portfolio",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_FEE_COMM_PROF),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_FEE_COMM_PROF),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_FEE_COMM_PROF),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_FEE_COMM_PROF),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_FEE_COMM_PROF),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_FEE_COMM_PROF),
				getMakerJustification("retailproducts", Date, "R22_FEE_COMM_PROF", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_FEE_COMM_PROF", timeperiod), "R22_FEE_COMM_PROF"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total value of funds that become unclaimed (including unclaimed balances) in the last 90  days",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_TOT_UNCLM_90),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_TOT_UNCLM_90),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_UNCLM_90),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_UNCLM_90),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_UNCLM_90),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_UNCLM_90),
				getMakerJustification("retailproducts", Date, "R22_TOT_UNCLM_90", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_TOT_UNCLM_90", timeperiod), "R22_TOT_UNCLM_90"));
		pivotTable.add(new RT_MC_Manager_DTO("Total value of unclaimed balances",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_TOT_VAL_UNBAL),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_TOT_VAL_UNBAL),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_VAL_UNBAL),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_VAL_UNBAL),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_VAL_UNBAL),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_VAL_UNBAL),
				getMakerJustification("retailproducts", Date, "R22_TOT_VAL_UNBAL", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_TOT_VAL_UNBAL", timeperiod), "R22_TOT_VAL_UNBAL"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of instances of contractual breaches related to consumer data protection by the Authorized Agents during the specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NO_INST_CONTRACT),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NO_INST_CONTRACT),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_INST_CONTRACT),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_INST_CONTRACT),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_INST_CONTRACT),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_INST_CONTRACT),
				getMakerJustification("retailproducts", Date, "R22_NO_INST_CONTRACT", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NO_INST_CONTRACT", timeperiod),
				"R22_NO_INST_CONTRACT"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total number of accounts that has been marked as Dormant Account for which notice was sent to consumer",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_TOT_DORACC_NOTICE),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_TOT_DORACC_NOTICE),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_DORACC_NOTICE),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_DORACC_NOTICE),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_DORACC_NOTICE),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_DORACC_NOTICE),
				getMakerJustification("retailproducts", Date, "R22_TOT_DORACC_NOTICE", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_TOT_DORACC_NOTICE", timeperiod),
				"R22_TOT_DORACC_NOTICE"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of consumers who have been issued liability or no liability letters within 7 days of request",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NO_CONS_LIAB_7DAY),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NO_CONS_LIAB_7DAY),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_CONS_LIAB_7DAY),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_CONS_LIAB_7DAY),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_CONS_LIAB_7DAY),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_CONS_LIAB_7DAY),
				getMakerJustification("retailproducts", Date, "R22_NO_CONS_LIAB_7DAY", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NO_CONS_LIAB_7DAY", timeperiod),
				"R22_NO_CONS_LIAB_7DAY"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total Number of requests received from consumers for liability and no liability letters",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_TOT_REQ_LIAB_NONLIA),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_TOT_REQ_LIAB_NONLIA),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_REQ_LIAB_NONLIA),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_REQ_LIAB_NONLIA),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_REQ_LIAB_NONLIA),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_REQ_LIAB_NONLIA),
				getMakerJustification("retailproducts", Date, "R22_TOT_REQ_LIAB_NONLIA", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_TOT_REQ_LIAB_NONLIA", timeperiod),
				"R22_TOT_REQ_LIAB_NONLIA"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of restructuring and rescheduling requests by new consumers onboarded by the Bank during the specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NO_RESTU_ONBO),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NO_RESTU_ONBO),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_RESTU_ONBO),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_RESTU_ONBO),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_RESTU_ONBO),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_RESTU_ONBO),
				getMakerJustification("retailproducts", Date, "R22_NO_RESTU_ONBO", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NO_RESTU_ONBO", timeperiod), "R22_NO_RESTU_ONBO"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total number of instances of delay in  fund transfers as per  Bank policy defined TATs (other than AML reasons)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_TOT_DELAY_TAT),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_TOT_DELAY_TAT),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_DELAY_TAT),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_DELAY_TAT),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_DELAY_TAT),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_DELAY_TAT),
				getMakerJustification("retailproducts", Date, "R22_TOT_DELAY_TAT", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_TOT_DELAY_TAT", timeperiod), "R22_TOT_DELAY_TAT"));
		pivotTable.add(new RT_MC_Manager_DTO("Total number of fund transfer transactions",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_TOT_FND_TRAN),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_TOT_FND_TRAN),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_FND_TRAN),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_FND_TRAN),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_FND_TRAN),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_FND_TRAN),
				getMakerJustification("retailproducts", Date, "R22_TOT_FND_TRAN", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_TOT_FND_TRAN", timeperiod), "R22_TOT_FND_TRAN"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of instances where consumer funds are retained (unless funds are in transit) for more than 24 hours",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NO_FUND_RET24),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NO_FUND_RET24),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_FUND_RET24),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_FUND_RET24),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_FUND_RET24),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_FUND_RET24),
				getMakerJustification("retailproducts", Date, "R22_NO_FUND_RET24", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NO_FUND_RET24", timeperiod), "R22_NO_FUND_RET24"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of  failed transactions due to Bank's system or technical error",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NO_FAIL_TRAN),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NO_FAIL_TRAN),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_FAIL_TRAN),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_FAIL_TRAN),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_FAIL_TRAN),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_FAIL_TRAN),
				getMakerJustification("retailproducts", Date, "R22_NO_FAIL_TRAN", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NO_FAIL_TRAN", timeperiod), "R22_NO_FAIL_TRAN"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total number of instances in which funds transferred failed to reach the beneficiary (where consumers successfully initiated transaction) during the specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_CUS_FND_SVF_SPT),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_CUS_FND_SVF_SPT),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_CUS_FND_SVF_SPT),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_CUS_FND_SVF_SPT),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_CUS_FND_SVF_SPT),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_CUS_FND_SVF_SPT),
				getMakerJustification("retailproducts", Date, "R22_CUS_FND_SVF_SPT", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_CUS_FND_SVF_SPT", timeperiod),
				"R22_CUS_FND_SVF_SPT"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total consumer funds (float) held in a segregated account by the SVF during the specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_CUS_FND_SVF_PRE),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_CUS_FND_SVF_PRE),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_CUS_FND_SVF_PRE),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_CUS_FND_SVF_PRE),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_CUS_FND_SVF_PRE),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_CUS_FND_SVF_PRE),
				getMakerJustification("retailproducts", Date, "R22_CUS_FND_SVF_PRE", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_CUS_FND_SVF_PRE", timeperiod),
				"R22_CUS_FND_SVF_PRE"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total consumer funds (float) held in a segregated account by the SVF during the previous time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_TOT_CRDR_UND_SPT),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_TOT_CRDR_UND_SPT),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_CRDR_UND_SPT),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_CRDR_UND_SPT),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_CRDR_UND_SPT),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_CRDR_UND_SPT),
				getMakerJustification("retailproducts", Date, "R22_TOT_CRDR_UND_SPT", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_TOT_CRDR_UND_SPT", timeperiod),
				"R22_TOT_CRDR_UND_SPT"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total number of credit and debit cards undelivered to the consumers that have been issued during the specified period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_TOT_CRD_ISU_SPT),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_TOT_CRD_ISU_SPT),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_CRD_ISU_SPT),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_CRD_ISU_SPT),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_CRD_ISU_SPT),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_CRD_ISU_SPT),
				getMakerJustification("retailproducts", Date, "R22_TOT_CRD_ISU_SPT", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_TOT_CRD_ISU_SPT", timeperiod),
				"R22_TOT_CRD_ISU_SPT"));
		pivotTable.add(new RT_MC_Manager_DTO("Total Number of cards issued during the specififed time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NO_ACC_BLK_FIN),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NO_ACC_BLK_FIN),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_ACC_BLK_FIN),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_ACC_BLK_FIN),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_ACC_BLK_FIN),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_ACC_BLK_FIN),
				getMakerJustification("retailproducts", Date, "R22_NO_ACC_BLK_FIN", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NO_ACC_BLK_FIN", timeperiod),
				"R22_NO_ACC_BLK_FIN"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of accounts blocked without informing consumers (other than AML, financial crime or regulatory reasons or if prohibited by regulatory authority)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NO_INQ_AVL_BAL),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NO_INQ_AVL_BAL),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_INQ_AVL_BAL),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_INQ_AVL_BAL),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_INQ_AVL_BAL),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_INQ_AVL_BAL),
				getMakerJustification("retailproducts", Date, "R22_NO_INQ_AVL_BAL", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NO_INQ_AVL_BAL", timeperiod),
				"R22_NO_INQ_AVL_BAL"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of inquiries regarding the available balance in the prepaid card",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_TOT_PRE_EXP_SPT),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_TOT_PRE_EXP_SPT),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_PRE_EXP_SPT),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_PRE_EXP_SPT),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_PRE_EXP_SPT),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_PRE_EXP_SPT),
				getMakerJustification("retailproducts", Date, "R22_TOT_PRE_EXP_SPT", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_TOT_PRE_EXP_SPT", timeperiod),
				"R22_TOT_PRE_EXP_SPT"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total number of prepaid cards having positive balance  that have expired during the specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_TOT_PRE_POS_EXP),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_TOT_PRE_POS_EXP),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_PRE_POS_EXP),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_PRE_POS_EXP),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_PRE_POS_EXP),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_PRE_POS_EXP),
				getMakerJustification("retailproducts", Date, "R22_TOT_PRE_POS_EXP", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_TOT_PRE_POS_EXP", timeperiod),
				"R22_TOT_PRE_POS_EXP"));
		pivotTable.add(new RT_MC_Manager_DTO("Total number of prepaid cards as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_TOT_PRE_CARD_SPD),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_TOT_PRE_CARD_SPD),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_PRE_CARD_SPD),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_PRE_CARD_SPD),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_PRE_CARD_SPD),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_PRE_CARD_SPD),
				getMakerJustification("retailproducts", Date, "R22_TOT_PRE_CARD_SPD", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_TOT_PRE_CARD_SPD", timeperiod),
				"R22_TOT_PRE_CARD_SPD"));
		pivotTable.add(new RT_MC_Manager_DTO("Total number of Accounts as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_TOT_ACCS_SPD),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_TOT_ACCS_SPD),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_ACCS_SPD),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_ACCS_SPD),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_TOT_ACCS_SPD),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_TOT_ACCS_SPD),
				getMakerJustification("retailproducts", Date, "R22_TOT_ACCS_SPD", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_TOT_ACCS_SPD", timeperiod), "R22_TOT_ACCS_SPD"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of languages available through the voice response system",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NO_LANG_VOICE),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NO_LANG_VOICE),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_LANG_VOICE),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_LANG_VOICE),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_LANG_VOICE),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_LANG_VOICE),
				getMakerJustification("retailproducts", Date, "R22_NO_LANG_VOICE", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NO_LANG_VOICE", timeperiod), "R22_NO_LANG_VOICE"));
		pivotTable.add(new RT_MC_Manager_DTO("Average number of days taken to open low risk accounts ",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NOD_LOWRSK),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NOD_LOWRSK),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NOD_LOWRSK),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NOD_LOWRSK),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NOD_LOWRSK),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_AVG_NOD_LOWRSK),
				getMakerJustification("retailproducts", Date, "R22_AVG_NOD_LOWRSK", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_AVG_NOD_LOWRSK", timeperiod),
				"R22_AVG_NOD_LOWRSK"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of consumers who have been reissued liability letters",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NO_CUST_REISS_LIA),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NO_CUST_REISS_LIA),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_CUST_REISS_LIA),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_CUST_REISS_LIA),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_CUST_REISS_LIA),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_CUST_REISS_LIA),
				getMakerJustification("retailproducts", Date, "R22_NO_CUST_REISS_LIA", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NO_CUST_REISS_LIA", timeperiod),
				"R22_NO_CUST_REISS_LIA"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of instances of change in credit rating of consumers",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE4_2_ENTITY::getR22_NO_INS_CRRATE_CON),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE4_2_ENTITY::getR22_NO_INS_CRRATE_CON),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_INS_CRRATE_CON),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_INS_CRRATE_CON),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE4_2_ENTITY::getR22_NO_INS_CRRATE_CON),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE4_2_ENTITY::getR22_NO_INS_CRRATE_CON),
				getMakerJustification("retailproducts", Date, "R22_NO_INS_CRRATE_CON", timeperiod),
				getCheckerJustification("retailproducts", Date, "R22_NO_INS_CRRATE_CON", timeperiod),
				"R22_NO_INS_CRRATE_CON"));

		Map<String, Object> modelData = new HashMap<>();
		modelData.put("headerDates", headerDates);
		modelData.put("yearDates", yearDates);
		modelData.put("reportRows", pivotTable);

		return modelData;
	}

	public Map<String, Object> getManagerViewDataTable5(String Date, String timeperiod) {
		List<RT_MC_TABLE5_ENTITY> top4Rows = RT_MC_TABLE5_REPO.findLastFourReports(Date, "QUARTERLY");
		List<RT_MC_TABLE5_ENTITY> top2RowsYearly = RT_MC_TABLE5_REPO.findLastTwoReports(Date, "YEARLY");
		List<String> headerDates = new ArrayList<>();
		List<String> yearDates = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM - yyyy");

		for (RT_MC_TABLE5_ENTITY row : top4Rows) {
			Date rawDate = row.getREPORT_DATE();
			LocalDate displayDate = new java.sql.Date(rawDate.getTime()).toLocalDate();
			headerDates.add(displayDate.format(formatter));
		}

		for (RT_MC_TABLE5_ENTITY row : top2RowsYearly) {
			Date rawDate = row.getREPORT_DATE();
			LocalDate displayDate = new java.sql.Date(rawDate.getTime()).toLocalDate();
			yearDates.add("Yearly - " + displayDate.format(formatter));
		}

		List<RT_MC_Manager_DTO> pivotTable = new ArrayList<>();

		pivotTable.add(new RT_MC_Manager_DTO("Number of Consumer facing employees as of the specified date",
				getSafeValue(top4Rows, 3, RT_MC_TABLE5_ENTITY::getR12_NO_CON_EMP_SPCD),
				getSafeValue(top4Rows, 2, RT_MC_TABLE5_ENTITY::getR12_NO_CON_EMP_SPCD),
				getSafeValue(top4Rows, 1, RT_MC_TABLE5_ENTITY::getR12_NO_CON_EMP_SPCD),
				getSafeValue(top4Rows, 0, RT_MC_TABLE5_ENTITY::getR12_NO_CON_EMP_SPCD),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE5_ENTITY::getR12_NO_CON_EMP_SPCD),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE5_ENTITY::getR12_NO_CON_EMP_SPCD),
				getMakerJustification("bankemployee", Date, "R12_NO_CON_EMP_SPCD", timeperiod),
				getCheckerJustification("bankemployee", Date, "R12_NO_CON_EMP_SPCD", timeperiod),
				"R12_NO_CON_EMP_SPCD"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of employees who resigned or have been dismissed from the LFI during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE5_ENTITY::getR12_NO_EMP_LFI),
				getSafeValue(top4Rows, 2, RT_MC_TABLE5_ENTITY::getR12_NO_EMP_LFI),
				getSafeValue(top4Rows, 1, RT_MC_TABLE5_ENTITY::getR12_NO_EMP_LFI),
				getSafeValue(top4Rows, 0, RT_MC_TABLE5_ENTITY::getR12_NO_EMP_LFI),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE5_ENTITY::getR12_NO_EMP_LFI),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE5_ENTITY::getR12_NO_EMP_LFI),
				getMakerJustification("bankemployee", Date, "R12_NO_EMP_LFI", timeperiod),
				getCheckerJustification("bankemployee", Date, "R12_NO_EMP_LFI", timeperiod), "R12_NO_EMP_LFI"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of employees who have been dismissed due to poor conduct/behaviour from the Bank during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE5_ENTITY::getR12_NO_DIS_POOR),
				getSafeValue(top4Rows, 2, RT_MC_TABLE5_ENTITY::getR12_NO_DIS_POOR),
				getSafeValue(top4Rows, 1, RT_MC_TABLE5_ENTITY::getR12_NO_DIS_POOR),
				getSafeValue(top4Rows, 0, RT_MC_TABLE5_ENTITY::getR12_NO_DIS_POOR),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE5_ENTITY::getR12_NO_DIS_POOR),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE5_ENTITY::getR12_NO_DIS_POOR),
				getMakerJustification("bankemployee", Date, "R12_NO_DIS_POOR", timeperiod),
				getCheckerJustification("bankemployee", Date, "R12_NO_DIS_POOR", timeperiod), "R12_NO_DIS_POOR"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of instances of contractual breaches by the Authorized Agents during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE5_ENTITY::getR12_NO_CON_AGS),
				getSafeValue(top4Rows, 2, RT_MC_TABLE5_ENTITY::getR12_NO_CON_AGS),
				getSafeValue(top4Rows, 1, RT_MC_TABLE5_ENTITY::getR12_NO_CON_AGS),
				getSafeValue(top4Rows, 0, RT_MC_TABLE5_ENTITY::getR12_NO_CON_AGS),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE5_ENTITY::getR12_NO_CON_AGS),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE5_ENTITY::getR12_NO_CON_AGS),
				getMakerJustification("bankemployee", Date, "R12_NO_CON_AGS", timeperiod),
				getCheckerJustification("bankemployee", Date, "R12_NO_CON_AGS", timeperiod), "R12_NO_CON_AGS"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Sales Staff Employees (including authorized agents) as of the specified date",
				getSafeValue(top4Rows, 3, RT_MC_TABLE5_ENTITY::getR12_NO_SAL_STF_EMP),
				getSafeValue(top4Rows, 2, RT_MC_TABLE5_ENTITY::getR12_NO_SAL_STF_EMP),
				getSafeValue(top4Rows, 1, RT_MC_TABLE5_ENTITY::getR12_NO_SAL_STF_EMP),
				getSafeValue(top4Rows, 0, RT_MC_TABLE5_ENTITY::getR12_NO_SAL_STF_EMP),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE5_ENTITY::getR12_NO_SAL_STF_EMP),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE5_ENTITY::getR12_NO_SAL_STF_EMP),
				getMakerJustification("bankemployee", Date, "R12_NO_SAL_STF_EMP", timeperiod),
				getCheckerJustification("bankemployee", Date, "R12_NO_SAL_STF_EMP", timeperiod), "R12_NO_SAL_STF_EMP"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Sales Staff Employees (including authorized agents) having fixed remuneration with no variable component as of the specified date",
				getSafeValue(top4Rows, 3, RT_MC_TABLE5_ENTITY::getR12_NO_FXD_RENUM),
				getSafeValue(top4Rows, 2, RT_MC_TABLE5_ENTITY::getR12_NO_FXD_RENUM),
				getSafeValue(top4Rows, 1, RT_MC_TABLE5_ENTITY::getR12_NO_FXD_RENUM),
				getSafeValue(top4Rows, 0, RT_MC_TABLE5_ENTITY::getR12_NO_FXD_RENUM),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE5_ENTITY::getR12_NO_FXD_RENUM),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE5_ENTITY::getR12_NO_FXD_RENUM),
				getMakerJustification("bankemployee", Date, "R12_NO_FXD_RENUM", timeperiod),
				getCheckerJustification("bankemployee", Date, "R12_NO_FXD_RENUM", timeperiod), "R12_NO_FXD_RENUM"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Sales Staff Employees (including authorized agents) having a variable component of their remuneration greater than or equal to 50% of their salary as of the specified date",
				getSafeValue(top4Rows, 3, RT_MC_TABLE5_ENTITY::getR12_NO_SAL_REN_50),
				getSafeValue(top4Rows, 2, RT_MC_TABLE5_ENTITY::getR12_NO_SAL_REN_50),
				getSafeValue(top4Rows, 1, RT_MC_TABLE5_ENTITY::getR12_NO_SAL_REN_50),
				getSafeValue(top4Rows, 0, RT_MC_TABLE5_ENTITY::getR12_NO_SAL_REN_50),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE5_ENTITY::getR12_NO_SAL_REN_50),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE5_ENTITY::getR12_NO_SAL_REN_50),
				getMakerJustification("bankemployee", Date, "R12_NO_SAL_REN_50", timeperiod),
				getCheckerJustification("bankemployee", Date, "R12_NO_SAL_REN_50", timeperiod), "R12_NO_SAL_REN_50"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Average value of performance bonuses received by consumer facing employees (AED (000's))",
				getSafeValue(top4Rows, 3, RT_MC_TABLE5_ENTITY::getR12_AVG_BON_CON),
				getSafeValue(top4Rows, 2, RT_MC_TABLE5_ENTITY::getR12_AVG_BON_CON),
				getSafeValue(top4Rows, 1, RT_MC_TABLE5_ENTITY::getR12_AVG_BON_CON),
				getSafeValue(top4Rows, 0, RT_MC_TABLE5_ENTITY::getR12_AVG_BON_CON),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE5_ENTITY::getR12_AVG_BON_CON),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE5_ENTITY::getR12_AVG_BON_CON),
				getMakerJustification("bankemployee", Date, "R12_AVG_BON_CON", timeperiod),
				getCheckerJustification("bankemployee", Date, "R12_AVG_BON_CON", timeperiod), "R12_AVG_BON_CON"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of Employees Undergoing Disciplinary Actions for conduct breaches",
				getSafeValue(top4Rows, 3, RT_MC_TABLE5_ENTITY::getR12_NO_EMP_DIS_ACT),
				getSafeValue(top4Rows, 2, RT_MC_TABLE5_ENTITY::getR12_NO_EMP_DIS_ACT),
				getSafeValue(top4Rows, 1, RT_MC_TABLE5_ENTITY::getR12_NO_EMP_DIS_ACT),
				getSafeValue(top4Rows, 0, RT_MC_TABLE5_ENTITY::getR12_NO_EMP_DIS_ACT),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE5_ENTITY::getR12_NO_EMP_DIS_ACT),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE5_ENTITY::getR12_NO_EMP_DIS_ACT),
				getMakerJustification("bankemployee", Date, "R12_NO_EMP_DIS_ACT", timeperiod),
				getCheckerJustification("bankemployee", Date, "R12_NO_EMP_DIS_ACT", timeperiod), "R12_NO_EMP_DIS_ACT"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of complaints received during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE5_ENTITY::getR12_NO_COM_SPC_PT),
				getSafeValue(top4Rows, 2, RT_MC_TABLE5_ENTITY::getR12_NO_COM_SPC_PT),
				getSafeValue(top4Rows, 1, RT_MC_TABLE5_ENTITY::getR12_NO_COM_SPC_PT),
				getSafeValue(top4Rows, 0, RT_MC_TABLE5_ENTITY::getR12_NO_COM_SPC_PT),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE5_ENTITY::getR12_NO_COM_SPC_PT),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE5_ENTITY::getR12_NO_COM_SPC_PT),
				getMakerJustification("bankemployee", Date, "R12_NO_COM_SPC_PT", timeperiod),
				getCheckerJustification("bankemployee", Date, "R12_NO_COM_SPC_PT", timeperiod), "R12_NO_COM_SPC_PT"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of instances of breaches to the Code of Conduct of the Bank during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE5_ENTITY::getR12_NO_INS_COC_PT),
				getSafeValue(top4Rows, 2, RT_MC_TABLE5_ENTITY::getR12_NO_INS_COC_PT),
				getSafeValue(top4Rows, 1, RT_MC_TABLE5_ENTITY::getR12_NO_INS_COC_PT),
				getSafeValue(top4Rows, 0, RT_MC_TABLE5_ENTITY::getR12_NO_INS_COC_PT),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE5_ENTITY::getR12_NO_INS_COC_PT),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE5_ENTITY::getR12_NO_INS_COC_PT),
				getMakerJustification("bankemployee", Date, "R12_NO_INS_COC_PT", timeperiod),
				getCheckerJustification("bankemployee", Date, "R12_NO_INS_COC_PT", timeperiod), "R12_NO_INS_COC_PT"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of whistleblower reports in the period related to conduct risk",
				getSafeValue(top4Rows, 3, RT_MC_TABLE5_ENTITY::getR12_NO_WSTLE_RSK),
				getSafeValue(top4Rows, 2, RT_MC_TABLE5_ENTITY::getR12_NO_WSTLE_RSK),
				getSafeValue(top4Rows, 1, RT_MC_TABLE5_ENTITY::getR12_NO_WSTLE_RSK),
				getSafeValue(top4Rows, 0, RT_MC_TABLE5_ENTITY::getR12_NO_WSTLE_RSK),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE5_ENTITY::getR12_NO_WSTLE_RSK),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE5_ENTITY::getR12_NO_WSTLE_RSK),
				getMakerJustification("bankemployee", Date, "R12_NO_WSTLE_RSK", timeperiod),
				getCheckerJustification("bankemployee", Date, "R12_NO_WSTLE_RSK", timeperiod), "R12_NO_WSTLE_RSK"));

		Map<String, Object> modelData = new HashMap<>();
		modelData.put("headerDates", headerDates);
		modelData.put("yearDates", yearDates);
		modelData.put("reportRows", pivotTable);

		return modelData;
	}

	public Map<String, Object> getManagerViewDataTable6(String Date, String timeperiod) {
		List<RT_MC_TABLE6_ENTITY> top4Rows = RT_MC_TABLE6_REPO.findLastFourReports(Date, "QUARTERLY");
		List<RT_MC_TABLE6_ENTITY> top2RowsYearly = RT_MC_TABLE6_REPO.findLastTwoReports(Date, "YEARLY");
		List<String> headerDates = new ArrayList<>();
		List<String> yearDates = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM - yyyy");

		for (RT_MC_TABLE6_ENTITY row : top4Rows) {
			Date rawDate = row.getREPORT_DATE();
			LocalDate displayDate = new java.sql.Date(rawDate.getTime()).toLocalDate();
			headerDates.add(displayDate.format(formatter));
		}

		for (RT_MC_TABLE6_ENTITY row : top2RowsYearly) {
			Date rawDate = row.getREPORT_DATE();
			LocalDate displayDate = new java.sql.Date(rawDate.getTime()).toLocalDate();
			yearDates.add("Yearly - " + displayDate.format(formatter));
		}

		List<RT_MC_Manager_DTO> pivotTable = new ArrayList<>();

		pivotTable
				.add(new RT_MC_Manager_DTO("Number of trainings provided to senior management on the mentioned topics",
						getSafeValue(top4Rows, 3, RT_MC_TABLE6_ENTITY::getR12_NO_PRO_SNR),
						getSafeValue(top4Rows, 2, RT_MC_TABLE6_ENTITY::getR12_NO_PRO_SNR),
						getSafeValue(top4Rows, 1, RT_MC_TABLE6_ENTITY::getR12_NO_PRO_SNR),
						getSafeValue(top4Rows, 0, RT_MC_TABLE6_ENTITY::getR12_NO_PRO_SNR),
						getSafeValue(top2RowsYearly, 0, RT_MC_TABLE6_ENTITY::getR12_NO_PRO_SNR),
						getSafeValue(top2RowsYearly, 1, RT_MC_TABLE6_ENTITY::getR12_NO_PRO_SNR),
						getMakerJustification("trainings", Date, "R12_NO_PRO_SNR", timeperiod),
						getCheckerJustification("trainings", Date, "R12_NO_PRO_SNR", timeperiod), "R12_NO_PRO_SNR"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of trainings sessions arranged for Bank employees other than Senior Management  on the mentioned topics during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE6_ENTITY::getR12_NO_TRA_SNR_SPT),
				getSafeValue(top4Rows, 2, RT_MC_TABLE6_ENTITY::getR12_NO_TRA_SNR_SPT),
				getSafeValue(top4Rows, 1, RT_MC_TABLE6_ENTITY::getR12_NO_TRA_SNR_SPT),
				getSafeValue(top4Rows, 0, RT_MC_TABLE6_ENTITY::getR12_NO_TRA_SNR_SPT),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE6_ENTITY::getR12_NO_TRA_SNR_SPT),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE6_ENTITY::getR12_NO_TRA_SNR_SPT),
				getMakerJustification("trainings", Date, "R12_NO_TRA_SNR_SPT", timeperiod),
				getCheckerJustification("trainings", Date, "R12_NO_TRA_SNR_SPT", timeperiod), "R12_NO_TRA_SNR_SPT"));
		pivotTable.add(
				new RT_MC_Manager_DTO("Number of consumer awareness initiatives for VC on the topic related to them",
						getSafeValue(top4Rows, 3, RT_MC_TABLE6_ENTITY::getR12_NO_CONS_VC),
						getSafeValue(top4Rows, 2, RT_MC_TABLE6_ENTITY::getR12_NO_CONS_VC),
						getSafeValue(top4Rows, 1, RT_MC_TABLE6_ENTITY::getR12_NO_CONS_VC),
						getSafeValue(top4Rows, 0, RT_MC_TABLE6_ENTITY::getR12_NO_CONS_VC),
						getSafeValue(top2RowsYearly, 0, RT_MC_TABLE6_ENTITY::getR12_NO_CONS_VC),
						getSafeValue(top2RowsYearly, 1, RT_MC_TABLE6_ENTITY::getR12_NO_CONS_VC),
						getMakerJustification("trainings", Date, "R12_NO_CONS_VC", timeperiod),
						getCheckerJustification("trainings", Date, "R12_NO_CONS_VC", timeperiod), "R12_NO_CONS_VC"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of consumer awareness initiatives or campaign on the topic of frauds and scams only",
				getSafeValue(top4Rows, 3, RT_MC_TABLE6_ENTITY::getR12_NO_CON_FRA),
				getSafeValue(top4Rows, 2, RT_MC_TABLE6_ENTITY::getR12_NO_CON_FRA),
				getSafeValue(top4Rows, 1, RT_MC_TABLE6_ENTITY::getR12_NO_CON_FRA),
				getSafeValue(top4Rows, 0, RT_MC_TABLE6_ENTITY::getR12_NO_CON_FRA),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE6_ENTITY::getR12_NO_CON_FRA),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE6_ENTITY::getR12_NO_CON_FRA),
				getMakerJustification("trainings", Date, "R12_NO_CON_FRA", timeperiod),
				getCheckerJustification("trainings", Date, "R12_NO_CON_FRA", timeperiod), "R12_NO_CON_FRA"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of consumer awareness initiatives or campaign on market conduct issues (excluding awareness sessions on fraud) ",
				getSafeValue(top4Rows, 3, RT_MC_TABLE6_ENTITY::getR12_NO_CON_MRK_FRD),
				getSafeValue(top4Rows, 2, RT_MC_TABLE6_ENTITY::getR12_NO_CON_MRK_FRD),
				getSafeValue(top4Rows, 1, RT_MC_TABLE6_ENTITY::getR12_NO_CON_MRK_FRD),
				getSafeValue(top4Rows, 0, RT_MC_TABLE6_ENTITY::getR12_NO_CON_MRK_FRD),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE6_ENTITY::getR12_NO_CON_MRK_FRD),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE6_ENTITY::getR12_NO_CON_MRK_FRD),
				getMakerJustification("trainings", Date, "R12_NO_CON_MRK_FRD", timeperiod),
				getCheckerJustification("trainings", Date, "R12_NO_CON_MRK_FRD", timeperiod), "R12_NO_CON_MRK_FRD"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total number of trainings arranged on the topic \"consumer protection regulations\", issued by CBUAE",
				getSafeValue(top4Rows, 3, RT_MC_TABLE6_ENTITY::getR12_TOT_CON_PRO_CBUAE),
				getSafeValue(top4Rows, 2, RT_MC_TABLE6_ENTITY::getR12_TOT_CON_PRO_CBUAE),
				getSafeValue(top4Rows, 1, RT_MC_TABLE6_ENTITY::getR12_TOT_CON_PRO_CBUAE),
				getSafeValue(top4Rows, 0, RT_MC_TABLE6_ENTITY::getR12_TOT_CON_PRO_CBUAE),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE6_ENTITY::getR12_TOT_CON_PRO_CBUAE),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE6_ENTITY::getR12_TOT_CON_PRO_CBUAE),
				getMakerJustification("trainings", Date, "R12_TOT_CON_PRO_CBUAE", timeperiod),
				getCheckerJustification("trainings", Date, "R12_TOT_CON_PRO_CBUAE", timeperiod),
				"R12_TOT_CON_PRO_CBUAE"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total number of trainings arranged on the topic \"Ombudsman regulations\", issued by CBUAE",
				getSafeValue(top4Rows, 3, RT_MC_TABLE6_ENTITY::getR12_TOT_TRA_CBUAE),
				getSafeValue(top4Rows, 2, RT_MC_TABLE6_ENTITY::getR12_TOT_TRA_CBUAE),
				getSafeValue(top4Rows, 1, RT_MC_TABLE6_ENTITY::getR12_TOT_TRA_CBUAE),
				getSafeValue(top4Rows, 0, RT_MC_TABLE6_ENTITY::getR12_TOT_TRA_CBUAE),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE6_ENTITY::getR12_TOT_TRA_CBUAE),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE6_ENTITY::getR12_TOT_TRA_CBUAE),
				getMakerJustification("trainings", Date, "R12_TOT_TRA_CBUAE", timeperiod),
				getCheckerJustification("trainings", Date, "R12_TOT_TRA_CBUAE", timeperiod), "R12_TOT_TRA_CBUAE"));

		Map<String, Object> modelData = new HashMap<>();
		modelData.put("headerDates", headerDates);
		modelData.put("yearDates", yearDates);
		modelData.put("reportRows", pivotTable);

		return modelData;
	}

	public Map<String, Object> getManagerViewDataTable7(String Date, String timeperiod) {
		List<RT_MC_TABLE7_2_ENTITY> top4Rowstable2 = RT_MC_TABLE7_2_REPO.findLastFourReports(Date, "QUARTERLY");
		List<RT_MC_TABLE7_2_ENTITY> top2RowsYearlytable2 = RT_MC_TABLE7_2_REPO.findLastTwoReports(Date, "YEARLY");

		List<String> headerDates = new ArrayList<>();
		List<String> yearDates = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM - yyyy");

		for (RT_MC_TABLE7_2_ENTITY row : top4Rowstable2) {
			Date rawDate = row.getREPORT_DATE();
			LocalDate displayDate = new java.sql.Date(rawDate.getTime()).toLocalDate();
			headerDates.add(displayDate.format(formatter));
		}

		for (RT_MC_TABLE7_2_ENTITY row : top2RowsYearlytable2) {
			Date rawDate = row.getREPORT_DATE();
			LocalDate displayDate = new java.sql.Date(rawDate.getTime()).toLocalDate();
			yearDates.add("Yearly - " + displayDate.format(formatter));
		}

		List<RT_MC_Manager_DTO> pivotTable = new ArrayList<>();

		pivotTable.add(
				new RT_MC_Manager_DTO("Retail Asset Composition as of the specified date (Loan to Retail Consumers)",
						getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_LTS),
						getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_LTS),
						getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_LTS),
						getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_LTS),
						getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_LTS),
						getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_LTS),
						getMakerJustification("additionalinformation", Date, "R23_RET_ASET_LTS", timeperiod),
						getCheckerJustification("additionalinformation", Date, "R23_RET_ASET_LTS", timeperiod),
						"R23_RET_ASET_LTS"));
		pivotTable.add(new RT_MC_Manager_DTO("Retail Asset Composition as of the specified date (Loan to SME)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_LTSME),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_LTSME),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_LTSME),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_LTSME),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_LTSME),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_LTSME),
				getMakerJustification("additionalinformation", Date, "R23_RET_ASET_LTSME", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_RET_ASET_LTSME", timeperiod),
				"R23_RET_ASET_LTSME"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Retail Asset Composition as of the specified date (SME - Guarantees & Commitments )",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_SME_GUR),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_SME_GUR),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_SME_GUR),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_SME_GUR),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_SME_GUR),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_SME_GUR),
				getMakerJustification("additionalinformation", Date, "R23_RET_ASET_SME_GUR", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_RET_ASET_SME_GUR", timeperiod),
				"R23_RET_ASET_SME_GUR"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Retail Asset Sales Composition - Loans disbursed to Retail Consumers - where the request application originated through digital channels such as loan application received through website or mobile application etc. ",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_RET_LOAN_DIS),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_RET_LOAN_DIS),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_RET_LOAN_DIS),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_RET_LOAN_DIS),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_RET_LOAN_DIS),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_RET_LOAN_DIS),
				getMakerJustification("additionalinformation", Date, "R23_RET_LOAN_DIS", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_RET_LOAN_DIS", timeperiod),
				"R23_RET_LOAN_DIS"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Retail Asset Sales Composition - Loans disbursed to SME - where the request application originated through digital channels such as loan application received through website or mobile application etc.",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_LOAN_SME),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_LOAN_SME),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_LOAN_SME),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_LOAN_SME),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_LOAN_SME),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_RET_ASET_LOAN_SME),
				getMakerJustification("additionalinformation", Date, "R23_RET_ASET_LOAN_SME", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_RET_ASET_LOAN_SME", timeperiod),
				"R23_RET_ASET_LOAN_SME"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Percentage of Loans / Financing disbursed to Retail Consumers - where the request application originated through digital channels such as loan application received through website or mobile application etc. ",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_PER_LOAN_WEB),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_PER_LOAN_WEB),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PER_LOAN_WEB),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PER_LOAN_WEB),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PER_LOAN_WEB),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PER_LOAN_WEB),
				getMakerJustification("additionalinformation", Date, "R23_PER_LOAN_WEB", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_PER_LOAN_WEB", timeperiod),
				"R23_PER_LOAN_WEB"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Loans / Financingdisbursed to SMEs - where the request application originated through digital channels such as loan application received through website or mobile application etc.",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_LOAN_SME_WEB_MOB),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_LOAN_SME_WEB_MOB),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_LOAN_SME_WEB_MOB),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_LOAN_SME_WEB_MOB),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_LOAN_SME_WEB_MOB),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_LOAN_SME_WEB_MOB),
				getMakerJustification("additionalinformation", Date, "R23_LOAN_SME_WEB_MOB", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_LOAN_SME_WEB_MOB", timeperiod),
				"R23_LOAN_SME_WEB_MOB"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Complaints received through digital channels such as complaints received through website, mobile application etc. ",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_NO_COMPDIGI_MOB),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_NO_COMPDIGI_MOB),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_COMPDIGI_MOB),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_COMPDIGI_MOB),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_COMPDIGI_MOB),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_COMPDIGI_MOB),
				getMakerJustification("additionalinformation", Date, "R23_NO_COMPDIGI_MOB", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_NO_COMPDIGI_MOB", timeperiod),
				"R23_NO_COMPDIGI_MOB"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Complaints received through traditional channels such as complaints received through call centres etc. ",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_NO_COMP_TRADCALL),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_NO_COMP_TRADCALL),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_COMP_TRADCALL),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_COMP_TRADCALL),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_COMP_TRADCALL),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_COMP_TRADCALL),
				getMakerJustification("additionalinformation", Date, "R23_NO_COMP_TRADCALL", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_NO_COMP_TRADCALL", timeperiod),
				"R23_NO_COMP_TRADCALL"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Percentage of Complaints received through digital channels such as complaints received through website, mobile application etc.",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_PER_COMPDIGI_WEB),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_PER_COMPDIGI_WEB),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PER_COMPDIGI_WEB),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PER_COMPDIGI_WEB),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PER_COMPDIGI_WEB),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PER_COMPDIGI_WEB),
				getMakerJustification("additionalinformation", Date, "R23_PER_COMPDIGI_WEB", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_PER_COMPDIGI_WEB", timeperiod),
				"R23_PER_COMPDIGI_WEB"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Percentage of Complaints received  through traditional channels such as complaints received consumer facing centers (e.g., through call centres, branches etc). ",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_PER_COM_TRADCALL),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_PER_COM_TRADCALL),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PER_COM_TRADCALL),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PER_COM_TRADCALL),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PER_COM_TRADCALL),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PER_COM_TRADCALL),
				getMakerJustification("additionalinformation", Date, "R23_PER_COM_TRADCALL", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_PER_COM_TRADCALL", timeperiod),
				"R23_PER_COM_TRADCALL"));
		pivotTable.add(new RT_MC_Manager_DTO("Total Revenue from Retail Portfolio (Previous Year)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_PREV),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_PREV),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_PREV),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_PREV),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_PREV),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_PREV),
				getMakerJustification("additionalinformation", Date, "R23_TOT_REV_PREV", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_TOT_REV_PREV", timeperiod),
				"R23_TOT_REV_PREV"));
		pivotTable.add(new RT_MC_Manager_DTO("Profits/Losses from Retail Portfolio (Previous Year)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOSS_PREV),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOSS_PREV),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOSS_PREV),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOSS_PREV),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOSS_PREV),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOSS_PREV),
				getMakerJustification("additionalinformation", Date, "R23_PROF_LOSS_PREV", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_PROF_LOSS_PREV", timeperiod),
				"R23_PROF_LOSS_PREV"));
		pivotTable.add(new RT_MC_Manager_DTO("Profit Margin (in percentage) from Retail Portfolio (Previous Year)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_PORTFOLIO),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_PORTFOLIO),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_PORTFOLIO),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_PORTFOLIO),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_PORTFOLIO),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_PORTFOLIO),
				getMakerJustification("additionalinformation", Date, "R23_PROF_MARG_PORTFOLIO", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_PROF_MARG_PORTFOLIO", timeperiod),
				"R23_PROF_MARG_PORTFOLIO"));
		pivotTable.add(new RT_MC_Manager_DTO("Total Retail Asset Size (Previous Year)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_PREV),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_PREV),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_PREV),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_PREV),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_PREV),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_PREV),
				getMakerJustification("additionalinformation", Date, "R23_TOT_RET_ASET_PREV", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_TOT_RET_ASET_PREV", timeperiod),
				"R23_TOT_RET_ASET_PREV"));
		pivotTable.add(new RT_MC_Manager_DTO("Non-Performing Loans/financing - Retail Portfolio (Previous Year)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_NP_LOAN_PREV),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_NP_LOAN_PREV),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NP_LOAN_PREV),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NP_LOAN_PREV),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NP_LOAN_PREV),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NP_LOAN_PREV),
				getMakerJustification("additionalinformation", Date, "R23_NP_LOAN_PREV", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_NP_LOAN_PREV", timeperiod),
				"R23_NP_LOAN_PREV"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of Consumers (as on the last day of the period) (Previous Year)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_NON_CON_ONLAST_PREV),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_NON_CON_ONLAST_PREV),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NON_CON_ONLAST_PREV),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NON_CON_ONLAST_PREV),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NON_CON_ONLAST_PREV),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NON_CON_ONLAST_PREV),
				getMakerJustification("additionalinformation", Date, "R23_NON_CON_ONLAST_PREV", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_NON_CON_ONLAST_PREV", timeperiod),
				"R23_NON_CON_ONLAST_PREV"));
		pivotTable.add(new RT_MC_Manager_DTO("Total Number of Branches (Previous Year)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRAN_PREV),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRAN_PREV),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRAN_PREV),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRAN_PREV),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRAN_PREV),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRAN_PREV),
				getMakerJustification("additionalinformation", Date, "R23_TOT_BRAN_PREV", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_TOT_BRAN_PREV", timeperiod),
				"R23_TOT_BRAN_PREV"));
		pivotTable.add(new RT_MC_Manager_DTO("Total Revenue from Retail Portfolio (Current Year)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_RET_CUR),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_RET_CUR),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_RET_CUR),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_RET_CUR),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_RET_CUR),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_RET_CUR),
				getMakerJustification("additionalinformation", Date, "R23_TOT_REV_RET_CUR", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_TOT_REV_RET_CUR", timeperiod),
				"R23_TOT_REV_RET_CUR"));
		pivotTable.add(new RT_MC_Manager_DTO("Profits/Losses from Retail Portfolio (Current Year)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_PORT_CUR),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_PORT_CUR),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_PORT_CUR),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_PORT_CUR),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_PORT_CUR),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_PORT_CUR),
				getMakerJustification("additionalinformation", Date, "R23_PROF_LOS_PORT_CUR", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_PROF_LOS_PORT_CUR", timeperiod),
				"R23_PROF_LOS_PORT_CUR"));
		pivotTable.add(new RT_MC_Manager_DTO("Profit Margin (in percentage) from Retail Portfolio (Current Year)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_PERC_CUR),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_PERC_CUR),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_PERC_CUR),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_PERC_CUR),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_PERC_CUR),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_PERC_CUR),
				getMakerJustification("additionalinformation", Date, "R23_PROF_MARG_PERC_CUR", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_PROF_MARG_PERC_CUR", timeperiod),
				"R23_PROF_MARG_PERC_CUR"));
		pivotTable.add(new RT_MC_Manager_DTO("Total Retail Asset Size (Current Year)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_CUR),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_CUR),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_CUR),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_CUR),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_CUR),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_CUR),
				getMakerJustification("additionalinformation", Date, "R23_TOT_RET_ASET_CUR", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_TOT_RET_ASET_CUR", timeperiod),
				"R23_TOT_RET_ASET_CUR"));
		pivotTable.add(new RT_MC_Manager_DTO("Non-Performing Loans/financing - Retail Portfolio (Current Year)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_NON_PER_RET_PORT_CUR),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_NON_PER_RET_PORT_CUR),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NON_PER_RET_PORT_CUR),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NON_PER_RET_PORT_CUR),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NON_PER_RET_PORT_CUR),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NON_PER_RET_PORT_CUR),
				getMakerJustification("additionalinformation", Date, "R23_NON_PER_RET_PORT_CUR", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_NON_PER_RET_PORT_CUR", timeperiod),
				"R23_NON_PER_RET_PORT_CUR"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of Consumers (as on the last day of the period) (Current Year)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_CUR),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_CUR),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_CUR),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_CUR),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_CUR),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_CUR),
				getMakerJustification("additionalinformation", Date, "R23_NO_CON_LAST_CUR", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_NO_CON_LAST_CUR", timeperiod),
				"R23_NO_CON_LAST_CUR"));
		pivotTable.add(new RT_MC_Manager_DTO("Total Number of Branches (Current Year)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_CUR),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_CUR),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_CUR),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_CUR),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_CUR),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_CUR),
				getMakerJustification("additionalinformation", Date, "R23_TOT_BRANCH_CUR", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_TOT_BRANCH_CUR", timeperiod),
				"R23_TOT_BRANCH_CUR"));
		pivotTable.add(new RT_MC_Manager_DTO("Total Revenue from Retail Portfolio (Next Year - T+1)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_T1),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_T1),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_T1),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_T1),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_T1),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_T1),
				getMakerJustification("additionalinformation", Date, "R23_TOT_REV_T1", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_TOT_REV_T1", timeperiod),
				"R23_TOT_REV_T1"));
		pivotTable.add(new RT_MC_Manager_DTO("Profits/Losses from Retail Portfolio (Next Year - T+1)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_T1),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_T1),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_T1),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_T1),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_T1),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_T1),
				getMakerJustification("additionalinformation", Date, "R23_PROF_LOS_T1", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_PROF_LOS_T1", timeperiod),
				"R23_PROF_LOS_T1"));
		pivotTable.add(new RT_MC_Manager_DTO("Profit Margin (in percentage) from Retail Portfolio (Next Year - T+1)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_T1),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_T1),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_T1),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_T1),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_T1),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_T1),
				getMakerJustification("additionalinformation", Date, "R23_PROF_MARG_T1", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_PROF_MARG_T1", timeperiod),
				"R23_PROF_MARG_T1"));
		pivotTable.add(new RT_MC_Manager_DTO("Total Retail Asset Size (Next Year - T+1)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_T1),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_T1),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_T1),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_T1),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_T1),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_T1),
				getMakerJustification("additionalinformation", Date, "R23_TOT_RET_ASET_T1", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_TOT_RET_ASET_T1", timeperiod),
				"R23_TOT_RET_ASET_T1"));
		pivotTable.add(new RT_MC_Manager_DTO("Non-Performing Loans/financing - Retail Portfolio (Next Year - T+1)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_NON_PERF_PORT_T1),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_NON_PERF_PORT_T1),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NON_PERF_PORT_T1),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NON_PERF_PORT_T1),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NON_PERF_PORT_T1),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NON_PERF_PORT_T1),
				getMakerJustification("additionalinformation", Date, "R23_NON_PERF_PORT_T1", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_NON_PERF_PORT_T1", timeperiod),
				"R23_NON_PERF_PORT_T1"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of Consumers (as on the last day of the period) (Next Year - T+1)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_T1),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_T1),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_T1),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_T1),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_T1),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_T1),
				getMakerJustification("additionalinformation", Date, "R23_NO_CON_LAST_T1", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_NO_CON_LAST_T1", timeperiod),
				"R23_NO_CON_LAST_T1"));
		pivotTable.add(new RT_MC_Manager_DTO("Total Number of Branches (Next Year -  T+1)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_T1),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_T1),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_T1),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_T1),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_T1),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_T1),
				getMakerJustification("additionalinformation", Date, "R23_TOT_BRANCH_T1", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_TOT_BRANCH_T1", timeperiod),
				"R23_TOT_BRANCH_T1"));
		pivotTable.add(new RT_MC_Manager_DTO("Total Revenue from Retail Portfolio (Next Year - T+2)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_T2),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_T2),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_T2),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_T2),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_T2),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_T2),
				getMakerJustification("additionalinformation", Date, "R23_TOT_REV_T2", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_TOT_REV_T2", timeperiod),
				"R23_TOT_REV_T2"));
		pivotTable.add(new RT_MC_Manager_DTO("Profits/Losses from Retail Portfolio (Next Year - T+2)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_T2),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_T2),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_T2),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_T2),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_T2),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_T2),
				getMakerJustification("additionalinformation", Date, "R23_PROF_LOS_T2", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_PROF_LOS_T2", timeperiod),
				"R23_PROF_LOS_T2"));
		pivotTable.add(new RT_MC_Manager_DTO("Profit Margin (in percentage) from Retail Portfolio (Next Year - T+2)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_T2),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_T2),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_T2),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_T2),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_T2),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_T2),
				getMakerJustification("additionalinformation", Date, "R23_PROF_MARG_T2", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_PROF_MARG_T2", timeperiod),
				"R23_PROF_MARG_T2"));
		pivotTable.add(new RT_MC_Manager_DTO("Total Retail Asset Size (Next Year - T+2)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_T2),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_T2),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_T2),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_T2),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_T2),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_T2),
				getMakerJustification("additionalinformation", Date, "R23_TOT_RET_ASET_T2", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_TOT_RET_ASET_T2", timeperiod),
				"R23_TOT_RET_ASET_T2"));
		pivotTable.add(new RT_MC_Manager_DTO("Non-Performing Loans/financing - Retail Portfolio (Next Year - T+2)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_NON_PERF_PORT_T2),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_NON_PERF_PORT_T2),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NON_PERF_PORT_T2),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NON_PERF_PORT_T2),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NON_PERF_PORT_T2),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NON_PERF_PORT_T2),
				getMakerJustification("additionalinformation", Date, "R23_NON_PERF_PORT_T2", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_NON_PERF_PORT_T2", timeperiod),
				"R23_NON_PERF_PORT_T2"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of Consumers (as on the last day of the period) (Next Year - T+2)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_T2),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_T2),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_T2),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_T2),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_T2),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_T2),
				getMakerJustification("additionalinformation", Date, "R23_NO_CON_LAST_T2", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_NO_CON_LAST_T2", timeperiod),
				"R23_NO_CON_LAST_T2"));
		pivotTable.add(new RT_MC_Manager_DTO("Total Number of Branches (Next Year -  T+2)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_T2),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_T2),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_T2),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_T2),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_T2),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_T2),
				getMakerJustification("additionalinformation", Date, "R23_TOT_BRANCH_T2", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_TOT_BRANCH_T2", timeperiod),
				"R23_TOT_BRANCH_T2"));
		pivotTable.add(new RT_MC_Manager_DTO("Total Revenue from Retail Portfolio (Next Year - T+3)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_T3),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_T3),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_T3),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_T3),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_T3),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_REV_T3),
				getMakerJustification("additionalinformation", Date, "R23_TOT_REV_T3", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_TOT_REV_T3", timeperiod),
				"R23_TOT_REV_T3"));
		pivotTable.add(new RT_MC_Manager_DTO("Profits/Losses from Retail Portfolio (Next Year - T+3)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_T3),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_T3),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_T3),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_T3),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_T3),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PROF_LOS_T3),
				getMakerJustification("additionalinformation", Date, "R23_PROF_LOS_T3", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_PROF_LOS_T3", timeperiod),
				"R23_PROF_LOS_T3"));
		pivotTable.add(new RT_MC_Manager_DTO("Profit Margin (in percentage) from Retail Portfolio (Next Year - T+3)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_T3),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_T3),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_T3),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_T3),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_T3),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_PROF_MARG_T3),
				getMakerJustification("additionalinformation", Date, "R23_PROF_MARG_T3", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_PROF_MARG_T3", timeperiod),
				"R23_PROF_MARG_T3"));
		pivotTable.add(new RT_MC_Manager_DTO("Total Retail Asset Size (Next Year - T+3)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_T3),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_T3),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_T3),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_T3),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_T3),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_RET_ASET_T3),
				getMakerJustification("additionalinformation", Date, "R23_TOT_RET_ASET_T3", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_TOT_RET_ASET_T3", timeperiod),
				"R23_TOT_RET_ASET_T3"));
		pivotTable.add(new RT_MC_Manager_DTO("Non-Performing Loans/financing - Retail Portfolio (Next Year - T+3)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_NON_PERF_PORT_T3),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_NON_PERF_PORT_T3),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NON_PERF_PORT_T3),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NON_PERF_PORT_T3),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NON_PERF_PORT_T3),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NON_PERF_PORT_T3),
				getMakerJustification("additionalinformation", Date, "R23_NON_PERF_PORT_T3", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_NON_PERF_PORT_T3", timeperiod),
				"R23_NON_PERF_PORT_T3"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of Consumers (as on the last day of the period) (Next Year - T+3)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_T3),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_T3),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_T3),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_T3),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_T3),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LAST_T3),
				getMakerJustification("additionalinformation", Date, "R23_NO_CON_LAST_T3", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_NO_CON_LAST_T3", timeperiod),
				"R23_NO_CON_LAST_T3"));
		pivotTable.add(new RT_MC_Manager_DTO("Total Number of Branches (Next Year -  T+3)",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_T3),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_T3),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_T3),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_T3),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_T3),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_BRANCH_T3),
				getMakerJustification("additionalinformation", Date, "R23_TOT_BRANCH_T3", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_TOT_BRANCH_T3", timeperiod),
				"R23_TOT_BRANCH_T3"));
		pivotTable.add(new RT_MC_Manager_DTO("NPLs as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_NPL_SPD),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_NPL_SPD),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NPL_SPD),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NPL_SPD),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NPL_SPD),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NPL_SPD),
				getMakerJustification("additionalinformation", Date, "R23_NPL_SPD", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_NPL_SPD", timeperiod), "R23_NPL_SPD"));
		pivotTable.add(new RT_MC_Manager_DTO("Recoveries against NPLs / Debt Collection as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_RECO_NPL_SPD),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_RECO_NPL_SPD),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_RECO_NPL_SPD),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_RECO_NPL_SPD),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_RECO_NPL_SPD),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_RECO_NPL_SPD),
				getMakerJustification("additionalinformation", Date, "R23_RECO_NPL_SPD", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_RECO_NPL_SPD", timeperiod),
				"R23_RECO_NPL_SPD"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of new Consumers onboarded through digital channels during specified time period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_ONBO_DIGI),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_ONBO_DIGI),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_ONBO_DIGI),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_ONBO_DIGI),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_ONBO_DIGI),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_ONBO_DIGI),
				getMakerJustification("additionalinformation", Date, "R23_NO_CON_ONBO_DIGI", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_NO_CON_ONBO_DIGI", timeperiod),
				"R23_NO_CON_ONBO_DIGI"));
		pivotTable.add(
				new RT_MC_Manager_DTO("Number of Accounts closed during specified time period (Other than AML reason)",
						getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_NO_ACCS_AML),
						getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_NO_ACCS_AML),
						getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_ACCS_AML),
						getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_ACCS_AML),
						getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_ACCS_AML),
						getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_ACCS_AML),
						getMakerJustification("additionalinformation", Date, "R23_NO_ACCS_AML", timeperiod),
						getCheckerJustification("additionalinformation", Date, "R23_NO_ACCS_AML", timeperiod),
						"R23_NO_ACCS_AML"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total number of account or loan applications rejected for new Loans / Financing or accounts applications (other than AML reasons) as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_TOT_ACC_LOAN_AML),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_TOT_ACC_LOAN_AML),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_ACC_LOAN_AML),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_ACC_LOAN_AML),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_ACC_LOAN_AML),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_ACC_LOAN_AML),
				getMakerJustification("additionalinformation", Date, "R23_TOT_ACC_LOAN_AML", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_TOT_ACC_LOAN_AML", timeperiod),
				"R23_TOT_ACC_LOAN_AML"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total number of new accounts opened or new Loans / Financing disbursed as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_TOT_NEW_ACCS_SPD),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_TOT_NEW_ACCS_SPD),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_NEW_ACCS_SPD),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_NEW_ACCS_SPD),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_NEW_ACCS_SPD),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_NEW_ACCS_SPD),
				getMakerJustification("additionalinformation", Date, "R23_TOT_NEW_ACCS_SPD", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_TOT_NEW_ACCS_SPD", timeperiod),
				"R23_TOT_NEW_ACCS_SPD"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total value associated with new accounts opened or new Loans / Financing disbursed as of the specified date",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_TOT_VALS_LOANS_SPD),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_TOT_VALS_LOANS_SPD),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_VALS_LOANS_SPD),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_VALS_LOANS_SPD),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_VALS_LOANS_SPD),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_VALS_LOANS_SPD),
				getMakerJustification("additionalinformation", Date, "R23_TOT_VALS_LOANS_SPD", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_TOT_VALS_LOANS_SPD", timeperiod),
				"R23_TOT_VALS_LOANS_SPD"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Inquiries received through digital channels such as complaints received through website, mobile application etc. ",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_NO_INQ_WEBMOB),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_NO_INQ_WEBMOB),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_INQ_WEBMOB),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_INQ_WEBMOB),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_INQ_WEBMOB),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_INQ_WEBMOB),
				getMakerJustification("additionalinformation", Date, "R23_NO_INQ_WEBMOB", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_NO_INQ_WEBMOB", timeperiod),
				"R23_NO_INQ_WEBMOB"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Inquiries received through traditional channels such as complaints received consumer facing centers (e.g., through call centres, branches etc). ",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_NO_INQ_TRAD),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_NO_INQ_TRAD),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_INQ_TRAD),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_INQ_TRAD),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_INQ_TRAD),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_INQ_TRAD),
				getMakerJustification("additionalinformation", Date, "R23_NO_INQ_TRAD", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_NO_INQ_TRAD", timeperiod),
				"R23_NO_INQ_TRAD"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of retail transactions through POS terminal/Payment Gateway",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_NO_RET_POS),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_NO_RET_POS),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_RET_POS),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_RET_POS),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_RET_POS),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_RET_POS),
				getMakerJustification("additionalinformation", Date, "R23_NO_RET_POS", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_NO_RET_POS", timeperiod),
				"R23_NO_RET_POS"));
		pivotTable.add(new RT_MC_Manager_DTO("Amount of retail transactions through POS terminal/Payment Gateway",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_AMT_POS_GATE),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_AMT_POS_GATE),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_AMT_POS_GATE),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_AMT_POS_GATE),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_AMT_POS_GATE),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_AMT_POS_GATE),
				getMakerJustification("additionalinformation", Date, "R23_AMT_POS_GATE", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_AMT_POS_GATE", timeperiod),
				"R23_AMT_POS_GATE"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of retail transactions through SVF Wallets of the Bank",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_NO_TRAN_SVF_BNK),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_NO_TRAN_SVF_BNK),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_TRAN_SVF_BNK),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_TRAN_SVF_BNK),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_TRAN_SVF_BNK),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_TRAN_SVF_BNK),
				getMakerJustification("additionalinformation", Date, "R23_NO_TRAN_SVF_BNK", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_NO_TRAN_SVF_BNK", timeperiod),
				"R23_NO_TRAN_SVF_BNK"));
		pivotTable.add(new RT_MC_Manager_DTO("Amount of retail transactions through SVF Wallets of the Bank",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_AMT_RET_SVF_BNK),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_AMT_RET_SVF_BNK),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_AMT_RET_SVF_BNK),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_AMT_RET_SVF_BNK),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_AMT_RET_SVF_BNK),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_AMT_RET_SVF_BNK),
				getMakerJustification("additionalinformation", Date, "R23_AMT_RET_SVF_BNK", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_AMT_RET_SVF_BNK", timeperiod),
				"R23_AMT_RET_SVF_BNK"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total number of digital channels available such as website, mobile apps, online/internet banking portals, chatbots, and virtual assistants etc. ",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_TOT_WEB_MOB_VIRT),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_TOT_WEB_MOB_VIRT),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_WEB_MOB_VIRT),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_WEB_MOB_VIRT),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_TOT_WEB_MOB_VIRT),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_TOT_WEB_MOB_VIRT),
				getMakerJustification("additionalinformation", Date, "R23_TOT_WEB_MOB_VIRT", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_TOT_WEB_MOB_VIRT", timeperiod),
				"R23_TOT_WEB_MOB_VIRT"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Value of Unclaimed Balances (including unclaimed funds in SVF wallets, prepaid and credit cards) during the specified period",
				getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_VAL_UNCL_SVF),
				getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_VAL_UNCL_SVF),
				getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_VAL_UNCL_SVF),
				getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_VAL_UNCL_SVF),
				getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_VAL_UNCL_SVF),
				getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_VAL_UNCL_SVF),
				getMakerJustification("additionalinformation", Date, "R23_VAL_UNCL_SVF", timeperiod),
				getCheckerJustification("additionalinformation", Date, "R23_VAL_UNCL_SVF", timeperiod),
				"R23_VAL_UNCL_SVF"));
		pivotTable.add(
				new RT_MC_Manager_DTO("Number of Conusmer from countries categorised as low risk as per Bank's Policy",
						getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LOW_RSK),
						getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LOW_RSK),
						getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LOW_RSK),
						getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LOW_RSK),
						getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LOW_RSK),
						getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_LOW_RSK),
						getMakerJustification("additionalinformation", Date, "R23_NO_CON_LOW_RSK", timeperiod),
						getCheckerJustification("additionalinformation", Date, "R23_NO_CON_LOW_RSK", timeperiod),
						"R23_NO_CON_LOW_RSK"));
		pivotTable.add(
				new RT_MC_Manager_DTO("Number of Conusmer from countries categorised as high risk as per Bank's Policy",
						getSafeValue(top4Rowstable2, 3, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_HIGH_RSK),
						getSafeValue(top4Rowstable2, 2, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_HIGH_RSK),
						getSafeValue(top4Rowstable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_HIGH_RSK),
						getSafeValue(top4Rowstable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_HIGH_RSK),
						getSafeValue(top2RowsYearlytable2, 0, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_HIGH_RSK),
						getSafeValue(top2RowsYearlytable2, 1, RT_MC_TABLE7_2_ENTITY::getR23_NO_CON_HIGH_RSK),
						getMakerJustification("additionalinformation", Date, "R23_NO_CON_HIGH_RSK", timeperiod),
						getCheckerJustification("additionalinformation", Date, "R23_NO_CON_HIGH_RSK", timeperiod),
						"R23_NO_CON_HIGH_RSK"));

		Map<String, Object> modelData = new HashMap<>();
		modelData.put("headerDates", headerDates);
		modelData.put("yearDates", yearDates);
		modelData.put("reportRows", pivotTable);

		return modelData;
	}

	public Map<String, Object> getManagerViewDataTable8(String Date, String timeperiod) {
		List<RT_MC_TABLE8_ENTITY> top4Rows = RT_MC_TABLE8_REPO.findLastFourReports(Date, "QUARTERLY");
		List<RT_MC_TABLE8_ENTITY> top2RowsYearly = RT_MC_TABLE8_REPO.findLastTwoReports(Date, "YEARLY");
		List<String> headerDates = new ArrayList<>();
		List<String> yearDates = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM - yyyy");

		for (RT_MC_TABLE8_ENTITY row : top4Rows) {
			Date rawDate = row.getREPORT_DATE();
			LocalDate displayDate = new java.sql.Date(rawDate.getTime()).toLocalDate();
			headerDates.add(displayDate.format(formatter));
		}

		for (RT_MC_TABLE8_ENTITY row : top2RowsYearly) {
			Date rawDate = row.getREPORT_DATE();
			LocalDate displayDate = new java.sql.Date(rawDate.getTime()).toLocalDate();
			yearDates.add("Yearly - " + displayDate.format(formatter));
		}

		List<RT_MC_Manager_DTO> pivotTable = new ArrayList<>();
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of Retail Consumers (Conventional and Islamic) as of the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE8_ENTITY::getR24_NO_RET_CON_SPD),
				getSafeValue(top4Rows, 2, RT_MC_TABLE8_ENTITY::getR24_NO_RET_CON_SPD),
				getSafeValue(top4Rows, 1, RT_MC_TABLE8_ENTITY::getR24_NO_RET_CON_SPD),
				getSafeValue(top4Rows, 0, RT_MC_TABLE8_ENTITY::getR24_NO_RET_CON_SPD),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE8_ENTITY::getR24_NO_RET_CON_SPD),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE8_ENTITY::getR24_NO_RET_CON_SPD),
				getMakerJustification("islamicbanking", Date, "R24_NO_RET_CON_SPD", timeperiod),
				getCheckerJustification("islamicbanking", Date, "R24_NO_RET_CON_SPD", timeperiod),
				"R24_NO_RET_CON_SPD"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of Retail Consumers (Islamic) as of the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE8_ENTITY::getR24_NO_ISC_SPD),
				getSafeValue(top4Rows, 2, RT_MC_TABLE8_ENTITY::getR24_NO_ISC_SPD),
				getSafeValue(top4Rows, 1, RT_MC_TABLE8_ENTITY::getR24_NO_ISC_SPD),
				getSafeValue(top4Rows, 0, RT_MC_TABLE8_ENTITY::getR24_NO_ISC_SPD),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE8_ENTITY::getR24_NO_ISC_SPD),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE8_ENTITY::getR24_NO_ISC_SPD),
				getMakerJustification("islamicbanking", Date, "R24_NO_ISC_SPD", timeperiod),
				getCheckerJustification("islamicbanking", Date, "R24_NO_ISC_SPD", timeperiod), "R24_NO_ISC_SPD"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Number of SME consumers (including Sole proprietorships) - Conventional and Islamic ",
				getSafeValue(top4Rows, 3, RT_MC_TABLE8_ENTITY::getR24_NO_SME_CON_ISC),
				getSafeValue(top4Rows, 2, RT_MC_TABLE8_ENTITY::getR24_NO_SME_CON_ISC),
				getSafeValue(top4Rows, 1, RT_MC_TABLE8_ENTITY::getR24_NO_SME_CON_ISC),
				getSafeValue(top4Rows, 0, RT_MC_TABLE8_ENTITY::getR24_NO_SME_CON_ISC),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE8_ENTITY::getR24_NO_SME_CON_ISC),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE8_ENTITY::getR24_NO_SME_CON_ISC),
				getMakerJustification("islamicbanking", Date, "R24_NO_SME_CON_ISC", timeperiod),
				getCheckerJustification("islamicbanking", Date, "R24_NO_SME_CON_ISC", timeperiod),
				"R24_NO_SME_CON_ISC"));
		pivotTable.add(new RT_MC_Manager_DTO("Number of SME consumers (including Sole proprietorships) - Islamic ",
				getSafeValue(top4Rows, 3, RT_MC_TABLE8_ENTITY::getR24_NO_SME_ISC),
				getSafeValue(top4Rows, 2, RT_MC_TABLE8_ENTITY::getR24_NO_SME_ISC),
				getSafeValue(top4Rows, 1, RT_MC_TABLE8_ENTITY::getR24_NO_SME_ISC),
				getSafeValue(top4Rows, 0, RT_MC_TABLE8_ENTITY::getR24_NO_SME_ISC),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE8_ENTITY::getR24_NO_SME_ISC),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE8_ENTITY::getR24_NO_SME_ISC),
				getMakerJustification("islamicbanking", Date, "R24_NO_SME_ISC", timeperiod),
				getCheckerJustification("islamicbanking", Date, "R24_NO_SME_ISC", timeperiod), "R24_NO_SME_ISC"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total Number of Authorised Agents and outsourcing service providers (including services or systems outsourced to authorised agents)",
				getSafeValue(top4Rows, 3, RT_MC_TABLE8_ENTITY::getR24_TOT_AGE_OUT),
				getSafeValue(top4Rows, 2, RT_MC_TABLE8_ENTITY::getR24_TOT_AGE_OUT),
				getSafeValue(top4Rows, 1, RT_MC_TABLE8_ENTITY::getR24_TOT_AGE_OUT),
				getSafeValue(top4Rows, 0, RT_MC_TABLE8_ENTITY::getR24_TOT_AGE_OUT),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE8_ENTITY::getR24_TOT_AGE_OUT),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE8_ENTITY::getR24_TOT_AGE_OUT),
				getMakerJustification("islamicbanking", Date, "R24_TOT_AGE_OUT", timeperiod),
				getCheckerJustification("islamicbanking", Date, "R24_TOT_AGE_OUT", timeperiod), "R24_TOT_AGE_OUT"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Total Number of Point of Sale Terminals  during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE8_ENTITY::getR24_TOT_PONT_SALE),
				getSafeValue(top4Rows, 2, RT_MC_TABLE8_ENTITY::getR24_TOT_PONT_SALE),
				getSafeValue(top4Rows, 1, RT_MC_TABLE8_ENTITY::getR24_TOT_PONT_SALE),
				getSafeValue(top4Rows, 0, RT_MC_TABLE8_ENTITY::getR24_TOT_PONT_SALE),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE8_ENTITY::getR24_TOT_PONT_SALE),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE8_ENTITY::getR24_TOT_PONT_SALE),
				getMakerJustification("islamicbanking", Date, "R24_TOT_PONT_SALE", timeperiod),
				getCheckerJustification("islamicbanking", Date, "R24_TOT_PONT_SALE", timeperiod), "R24_TOT_PONT_SALE"));
		pivotTable.add(new RT_MC_Manager_DTO("Total Number of Merchant tie ups  during the specified time period",
				getSafeValue(top4Rows, 3, RT_MC_TABLE8_ENTITY::getR24_TOT_MER_SPD),
				getSafeValue(top4Rows, 2, RT_MC_TABLE8_ENTITY::getR24_TOT_MER_SPD),
				getSafeValue(top4Rows, 1, RT_MC_TABLE8_ENTITY::getR24_TOT_MER_SPD),
				getSafeValue(top4Rows, 0, RT_MC_TABLE8_ENTITY::getR24_TOT_MER_SPD),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE8_ENTITY::getR24_TOT_MER_SPD),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE8_ENTITY::getR24_TOT_MER_SPD),
				getMakerJustification("islamicbanking", Date, "R24_TOT_MER_SPD", timeperiod),
				getCheckerJustification("islamicbanking", Date, "R24_TOT_MER_SPD", timeperiod), "R24_TOT_MER_SPD"));
		pivotTable.add(new RT_MC_Manager_DTO(
				"Retail Asset/liability Size as of the specified date(Islamic Only) (AED (000's))",
				getSafeValue(top4Rows, 3, RT_MC_TABLE8_ENTITY::getR24_RET_SIZE_ISC_AED),
				getSafeValue(top4Rows, 2, RT_MC_TABLE8_ENTITY::getR24_RET_SIZE_ISC_AED),
				getSafeValue(top4Rows, 1, RT_MC_TABLE8_ENTITY::getR24_RET_SIZE_ISC_AED),
				getSafeValue(top4Rows, 0, RT_MC_TABLE8_ENTITY::getR24_RET_SIZE_ISC_AED),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE8_ENTITY::getR24_RET_SIZE_ISC_AED),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE8_ENTITY::getR24_RET_SIZE_ISC_AED),
				getMakerJustification("islamicbanking", Date, "R24_RET_SIZE_ISC_AED", timeperiod),
				getCheckerJustification("islamicbanking", Date, "R24_RET_SIZE_ISC_AED", timeperiod),
				"R24_RET_SIZE_ISC_AED"));
		pivotTable.add(
				new RT_MC_Manager_DTO("Retail Asset Composition as of the specified date (Loan to Retail Consumers)",
						getSafeValue(top4Rows, 3, RT_MC_TABLE8_ENTITY::getR24_RET_ASSE_LON_RET),
						getSafeValue(top4Rows, 2, RT_MC_TABLE8_ENTITY::getR24_RET_ASSE_LON_RET),
						getSafeValue(top4Rows, 1, RT_MC_TABLE8_ENTITY::getR24_RET_ASSE_LON_RET),
						getSafeValue(top4Rows, 0, RT_MC_TABLE8_ENTITY::getR24_RET_ASSE_LON_RET),
						getSafeValue(top2RowsYearly, 0, RT_MC_TABLE8_ENTITY::getR24_RET_ASSE_LON_RET),
						getSafeValue(top2RowsYearly, 1, RT_MC_TABLE8_ENTITY::getR24_RET_ASSE_LON_RET),
						getMakerJustification("islamicbanking", Date, "R24_RET_ASSE_LON_RET", timeperiod),
						getCheckerJustification("islamicbanking", Date, "R24_RET_ASSE_LON_RET", timeperiod),
						"R24_RET_ASSE_LON_RET"));
		pivotTable.add(new RT_MC_Manager_DTO("Retail Asset Composition as of the specified date (Loan to SME)",
				getSafeValue(top4Rows, 3, RT_MC_TABLE8_ENTITY::getR24_RET_ASSE_LOAN_SME),
				getSafeValue(top4Rows, 2, RT_MC_TABLE8_ENTITY::getR24_RET_ASSE_LOAN_SME),
				getSafeValue(top4Rows, 1, RT_MC_TABLE8_ENTITY::getR24_RET_ASSE_LOAN_SME),
				getSafeValue(top4Rows, 0, RT_MC_TABLE8_ENTITY::getR24_RET_ASSE_LOAN_SME),
				getSafeValue(top2RowsYearly, 0, RT_MC_TABLE8_ENTITY::getR24_RET_ASSE_LOAN_SME),
				getSafeValue(top2RowsYearly, 1, RT_MC_TABLE8_ENTITY::getR24_RET_ASSE_LOAN_SME),
				getMakerJustification("islamicbanking", Date, "R24_RET_ASSE_LOAN_SME", timeperiod),
				getCheckerJustification("islamicbanking", Date, "R24_RET_ASSE_LOAN_SME", timeperiod),
				"R24_RET_ASSE_LOAN_SME"));
		pivotTable.add(
				new RT_MC_Manager_DTO("Number of complaints received during the specified time period (Islamic Only)",
						getSafeValue(top4Rows, 3, RT_MC_TABLE8_ENTITY::getR24_NO_COMP_ISLAMIC),
						getSafeValue(top4Rows, 2, RT_MC_TABLE8_ENTITY::getR24_NO_COMP_ISLAMIC),
						getSafeValue(top4Rows, 1, RT_MC_TABLE8_ENTITY::getR24_NO_COMP_ISLAMIC),
						getSafeValue(top4Rows, 0, RT_MC_TABLE8_ENTITY::getR24_NO_COMP_ISLAMIC),
						getSafeValue(top2RowsYearly, 0, RT_MC_TABLE8_ENTITY::getR24_NO_COMP_ISLAMIC),
						getSafeValue(top2RowsYearly, 1, RT_MC_TABLE8_ENTITY::getR24_NO_COMP_ISLAMIC),
						getMakerJustification("islamicbanking", Date, "R24_NO_COMP_ISLAMIC", timeperiod),
						getCheckerJustification("islamicbanking", Date, "R24_NO_COMP_ISLAMIC", timeperiod),
						"R24_NO_COMP_ISLAMIC"));

		Map<String, Object> modelData = new HashMap<>();
		modelData.put("headerDates", headerDates);
		modelData.put("yearDates", yearDates);
		modelData.put("reportRows", pivotTable);

		return modelData;
	}

	public Map<String, Object> getManagerViewDataTable9(String Date, String timeperiod) {
		List<RT_MC_TABLE9_ENTITY> top4Rows = RT_MC_TABLE9_REPO.findLastFourReports(Date, "QUARTERLY");
		List<RT_MC_TABLE9_ENTITY> top2RowsYearly = RT_MC_TABLE9_REPO.findLastTwoReports(Date, "YEARLY");
		List<String> headerDates = new ArrayList<>();
		List<String> yearDates = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM - yyyy");

		for (RT_MC_TABLE9_ENTITY row : top4Rows) {
			Date rawDate = row.getREPORT_DATE();
			LocalDate displayDate = new java.sql.Date(rawDate.getTime()).toLocalDate();
			headerDates.add(displayDate.format(formatter));
		}

		for (RT_MC_TABLE9_ENTITY row : top2RowsYearly) {
			Date rawDate = row.getREPORT_DATE();
			LocalDate displayDate = new java.sql.Date(rawDate.getTime()).toLocalDate();
			yearDates.add("Yearly - " + displayDate.format(formatter));
		}

		List<RT_MC_Manager_DTO> pivotTable = new ArrayList<>();

		Map<String, Object> modelData = new HashMap<>();
		modelData.put("headerDates", headerDates);
		modelData.put("yearDates", yearDates);
		modelData.put("reportRows", pivotTable);

		return modelData;
	}

	private <T> Object getSafeValue(List<T> list, int index, Function<T, Object> extractor) {
		if (list != null && index >= 0 && list.size() > index && list.get(index) != null) {
			return extractor.apply(list.get(index));
		}
		return null;
	}

	public String getMakerJustification(String formMode, String reportDate, String cellName, String timeperiod) {
		return RT_MC_DATA_RECORD_REPO.findMakerJustificationByFormModeAndReportDateAndCellNameAndTimeperiod(formMode,
				reportDate, cellName, timeperiod);
	}

	public String getCheckerJustification(String formMode, String reportDate, String cellName, String timeperiod) {
		return RT_MC_DATA_RECORD_REPO.findCheckerJustificationByFormModeAndReportDateAndCellNameAndTimeperiod(formMode,
				reportDate, cellName, timeperiod);
	}

	public void saveSignOffRemarks(String reportDate, String timeperiod, String remarks) {
		int rows_updated = 0;
		rows_updated += RT_MC_TABLE1_REPO.updateEntityFlgAndSignOffRemarks("Y", remarks, reportDate, timeperiod);

		rows_updated += RT_MC_TABLE2_1_REPO.updateEntityFlgAndSignOffRemarks("Y", remarks, reportDate, timeperiod);
		rows_updated += RT_MC_TABLE2_2_REPO.updateEntityFlgAndSignOffRemarks("Y", remarks, reportDate, timeperiod);
		
		rows_updated += RT_MC_TABLE3_REPO.updateEntityFlgAndSignOffRemarks("Y", remarks, reportDate, timeperiod);

		rows_updated += RT_MC_TABLE4_1_REPO.updateEntityFlgAndSignOffRemarks("Y", remarks, reportDate, timeperiod);
		rows_updated += RT_MC_TABLE4_2_REPO.updateEntityFlgAndSignOffRemarks("Y", remarks, reportDate, timeperiod);

		rows_updated += RT_MC_TABLE5_REPO.updateEntityFlgAndSignOffRemarks("Y", remarks, reportDate, timeperiod);

		rows_updated += RT_MC_TABLE6_REPO.updateEntityFlgAndSignOffRemarks("Y", remarks, reportDate, timeperiod);

		rows_updated += RT_MC_TABLE7_1_REPO.updateEntityFlgAndSignOffRemarks("Y", remarks, reportDate, timeperiod);
		rows_updated += RT_MC_TABLE7_2_REPO.updateEntityFlgAndSignOffRemarks("Y", remarks, reportDate, timeperiod);

		rows_updated += RT_MC_TABLE8_REPO.updateEntityFlgAndSignOffRemarks("Y", remarks, reportDate, timeperiod);

		rows_updated += RT_MC_TABLE9_REPO.updateEntityFlgAndSignOffRemarks("Y", remarks, reportDate, timeperiod);
		System.out.println("No of row Updated in Sign Of : "+rows_updated);
	}

	private <T> List<T> mergeReportData(List<T> numList, List<T> deptList, String reportOption,
			String selectedDepartments, Class<T> clazz) {
		List<T> mergedList = new ArrayList<>();

		List<String> targetDepts = new ArrayList<>();
		if (selectedDepartments != null && !selectedDepartments.isEmpty()
				&& !"ALL".equalsIgnoreCase(selectedDepartments)) {
			targetDepts = Arrays.asList(selectedDepartments.split("\\s*,\\s*"));
		}

		int maxRows = Math.min(numList.size(), deptList.size());

		for (int i = 0; i < maxRows; i++) {
			try {
				T numRec = numList.get(i);
				T deptRec = deptList.get(i);

				T mergedRec = clazz.getDeclaredConstructor().newInstance();

				for (java.lang.reflect.Field field : clazz.getDeclaredFields()) {
					field.setAccessible(true);

					Object numVal = field.get(numRec);
					Object deptVal = field.get(deptRec);

					if (field.getType().equals(String.class)) {
						String finalVal = calculateCellData(reportOption, targetDepts, numVal, deptVal);
						field.set(mergedRec, finalVal);
					} else {
						field.set(mergedRec, numVal);
					}
				}
				mergedList.add(mergedRec);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mergedList;
	}

	private String calculateCellData(String reportOption, List<String> targetDepts, Object numValue, Object deptValue) {
		String nVal = (numValue != null) ? numValue.toString().trim() : "";
		String dVal = (deptValue != null) ? deptValue.toString().trim() : "";

		if (nVal.isEmpty() && dVal.isEmpty())
			return null;

		boolean isDeptMatch = true;
		if (reportOption != null && reportOption.endsWith("_dept")) {
			isDeptMatch = false;
			if (!targetDepts.isEmpty() && !dVal.isEmpty()) {
				for (String target : targetDepts) {
					if (dVal.contains(target)) {
						isDeptMatch = true;
						break;
					}
				}
			}
		}

		if (!isDeptMatch)
			return null;
		if (reportOption == null)
			return nVal.isEmpty() ? null : nVal;

		switch (reportOption) {
		case "values_all":
		case "values_dept":
			return nVal.isEmpty() ? null : nVal;

		case "dept_values_all":
		case "dept_values_dept":
			return dVal.isEmpty() ? null : dVal;

		case "diff_all":
		case "diff_dept":
			if (nVal.isEmpty()) {
				if ("Not Applicable".equalsIgnoreCase(dVal)) {
					return dVal;
				}
				return "- " + dVal;
			}
			if (dVal.isEmpty()) {
				return nVal;
			}
			return nVal + " - " + dVal;

		default:
			return nVal.isEmpty() ? null : nVal;
		}
	}
	private byte[] generateNotApplicabilityExcel(String reportDate, String timeperiod, Map<String, Integer> progressMap,
			String jobId, String specialValues) throws Exception {

		logger.info("MC download jobId={} not-applicability query reportDate={} timeperiod={}", jobId, reportDate,
				timeperiod);
		long queryStarted = System.currentTimeMillis();
		List<RT_MC_DATA_RECORD_ENTITY> allRecords = RT_MC_DATA_RECORD_REPO.findByReportDateAndBranchCode(reportDate,
				timeperiod);
		logger.info("MC download jobId={} not-applicability rows={} elapsedMs={}", jobId,
				allRecords == null ? 0 : allRecords.size(), System.currentTimeMillis() - queryStarted);
		setMcProgress(progressMap, jobId, 30);

		List<String> targetSpecialValues = new ArrayList<>();
		if (specialValues != null && !specialValues.isEmpty()) {
			targetSpecialValues = Arrays.asList(specialValues.split("\\s*,\\s*"));
		}

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			Sheet sheet = workbook.createSheet("Special Values Report");

			CellStyle headerStyle = workbook.createCellStyle();
			headerStyle.setFillForegroundColor(IndexedColors.BROWN.getIndex());
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerStyle.setAlignment(HorizontalAlignment.CENTER);
			headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			headerStyle.setBorderBottom(BorderStyle.THIN);
			headerStyle.setBorderTop(BorderStyle.THIN);
			headerStyle.setBorderLeft(BorderStyle.THIN);
			headerStyle.setBorderRight(BorderStyle.THIN);

			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.WHITE.getIndex());
			headerFont.setFontHeightInPoints((short) 11);
			headerStyle.setFont(headerFont);

			CellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setBorderBottom(BorderStyle.THIN);
			cellStyle.setBorderTop(BorderStyle.THIN);
			cellStyle.setBorderLeft(BorderStyle.THIN);
			cellStyle.setBorderRight(BorderStyle.THIN);
			cellStyle.setWrapText(true);
			cellStyle.setAlignment(HorizontalAlignment.CENTER);
			cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

			CellStyle groupHeaderStyle = workbook.createCellStyle();
			groupHeaderStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
			groupHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			groupHeaderStyle.setAlignment(HorizontalAlignment.LEFT);
			groupHeaderStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			groupHeaderStyle.setBorderBottom(BorderStyle.THIN);
			groupHeaderStyle.setBorderTop(BorderStyle.THIN);
			groupHeaderStyle.setBorderLeft(BorderStyle.THIN);
			groupHeaderStyle.setBorderRight(BorderStyle.THIN);

			Font groupFont = workbook.createFont();
			groupFont.setBold(true);
			groupFont.setColor(IndexedColors.BLACK.getIndex());
			groupHeaderStyle.setFont(groupFont);

			Row headerRow = sheet.createRow(0);
			String[] headers = { "Column ID", "Table Reference", "Data Element - Row", "Data Element - Column",
					"Description", "Reason for Not Applicability", "Responsibility" };

			for (int i = 0; i < headers.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(headers[i]);
				cell.setCellStyle(headerStyle);
			}
			setMcProgress(progressMap, jobId, 40);

			int rowNum = 1;
			if (allRecords != null && !allRecords.isEmpty()) {
				
				for (String currentSpecialValue : targetSpecialValues) {
					
					List<RT_MC_DATA_RECORD_ENTITY> groupRecords = new ArrayList<>();
					for (RT_MC_DATA_RECORD_ENTITY record : allRecords) {
						String cellDataVal = (record.getDataValue() != null) ? record.getDataValue().trim() : "";
						
						if ("0".equals(currentSpecialValue)) {
							if ("0".equals(cellDataVal) || "0.0".equals(cellDataVal) || "0.00".equals(cellDataVal)) {
								groupRecords.add(record);
							}
						} else if (currentSpecialValue.equalsIgnoreCase(cellDataVal)) {
							groupRecords.add(record);
						}
					}

					if (!groupRecords.isEmpty()) {
						
						Row groupRow = sheet.createRow(rowNum++);
						Cell groupCell = groupRow.createCell(0);
						groupCell.setCellValue(currentSpecialValue);
						groupCell.setCellStyle(groupHeaderStyle);
						
						for (int i = 1; i < headers.length; i++) {
							Cell emptyCell = groupRow.createCell(i);
							emptyCell.setCellStyle(groupHeaderStyle);
						}
						sheet.addMergedRegion(new CellRangeAddress(rowNum - 1, rowNum - 1, 0, headers.length - 1));

						for (RT_MC_DATA_RECORD_ENTITY record : groupRecords) {
							Row row = sheet.createRow(rowNum++);

							String columnId = "";
							String description = "";

							if (record.getColumnHeader() != null && record.getFormMode() != null) {
								RT_MC_Description_Entity descEntity = RT_MC_Description_Repo
										.findTopBySectionAndElementNative(record.getFormMode(), record.getColumnHeader());
								if (descEntity != null) {
									columnId = descEntity.getColumnId();
									description = descEntity.getDescription();
								}
							}

							createStyledCell(row, 0, getTableId(columnId), cellStyle);

							createStyledCell(row, 1, record.getFormMode(), cellStyle);
							
							String rowElement = getRowDataElementHelper(record.getCellName(), record.getFormMode());
							createStyledCell(row, 2, rowElement, cellStyle);

							createStyledCell(row, 3, record.getColumnHeader(), cellStyle);
							createStyledCell(row, 4, description, cellStyle);
							createStyledCell(row, 5, record.getCheckerJustification(), cellStyle);

							String responsibilityVal = fetchResponsibilityValue(record.getFormMode(), record.getCellName());
							createStyledCell(row, 6, responsibilityVal, cellStyle);
						}
					}
				}
			}

			setMcProgress(progressMap, jobId, 85);

			logger.info("MC download jobId={} not-applicability autosize and write", jobId);
			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(6);
			sheet.setColumnWidth(3, 60 * 256);
			sheet.setColumnWidth(4, 60 * 256);
			sheet.setColumnWidth(5, 40 * 256);
			workbook.write(baos);
			return baos.toByteArray();
		}
	}
	private void createStyledCell(Row row, int colIndex, String value, CellStyle style) {
		Cell cell = row.createCell(colIndex);
		cell.setCellValue(value != null ? value : "");
		cell.setCellStyle(style);
	}

	private String getRowDataElementHelper(String cellName, String formMode) {
		if (cellName == null || formMode == null) {
			return "";
		}

		String prefix = cellName;
		String[] nameParts = cellName.split("_", 2);
		if (nameParts.length == 2) {
			prefix = nameParts[0];
		}

		try {
			String resolvedFieldName = auditservice.getFieldName(formMode, prefix);

			if (resolvedFieldName != null && !resolvedFieldName.trim().isEmpty()) {
				return resolvedFieldName;
			}
		} catch (Exception e) {
			System.err.println("Could not resolve field name for prefix: " + prefix);
		}

		return cellName;
	}
	public String getTableId(String formMode) {
		String tableid = null;
		switch (formMode) {
		case "bankinformation":
			tableid = "Table_1";
			return tableid;
		case "bankconsumers":
			tableid = "Table_2";
			return tableid;
		case "complaints":
			tableid = "Table_3";
			return tableid;
		case "retailproducts":
			tableid = "Table_4";
			return tableid;
		case "bankemployee":
			tableid = "Table_5";
			return tableid;
		case "trainings":
			tableid = "Table_6";
			return tableid;
		case "additionalinformation":
			tableid = "Table_7";
			return tableid;
		case "islamicbanking":
			tableid = "Table_8";
			return tableid;
		case "conductcultureassessment":
			tableid = "Table_9";
			return tableid;
		default:
			return formMode;
		}
	}

	private String fetchResponsibilityValue(String formMode, String cellName) {
		if (formMode == null || cellName == null || cellName.trim().isEmpty()) {
			return "";
		}
		try {
			String tableName = getMainTableName(formMode, cellName);

			if (tableName == null || tableName.trim().isEmpty()) {
				return "";
			}
			String sql = "SELECT " + cellName + " FROM " + tableName + " WHERE BRANCH_CODE = 'DEPT'";
			String value = jdbcTemplate.queryForObject(sql, String.class);
			return value != null ? value : "";

		} catch (EmptyResultDataAccessException e) {
			return "";
		} catch (Exception e) {
			System.err.println("Failed to fetch responsibility for cell: " + cellName + " - " + e.getMessage());
			return "";
		}
	}

	private static final Map<String, String> SHEET_MAP = new LinkedHashMap<>();
	static {
		SHEET_MAP.put("bankinformation", "Bank Information");
		SHEET_MAP.put("bankconsumers", "Bank Consumers");
		SHEET_MAP.put("complaints", "Complaints");
		SHEET_MAP.put("retailproducts", "Retail Products");
		SHEET_MAP.put("bankemployee", "Bank Employee");
		SHEET_MAP.put("trainings", "Trainings");
		SHEET_MAP.put("additionalinformation", "Additional Info");
		SHEET_MAP.put("islamicbanking", "Islamic Banking");
	}

	public byte[] generateManagerReportsExcel(String date, String timeperiod, String tableNames,
			Map<String, Integer> progressMap, String jobId) throws Exception {

		List<String> targetModes = new ArrayList<>();
		if (tableNames == null || tableNames.trim().isEmpty() || tableNames.equalsIgnoreCase("all")) {
			targetModes.addAll(SHEET_MAP.keySet());
		} else {
			String[] requestedTables = tableNames.split(",");
			for (String req : requestedTables) {
				String mode = req.trim().toLowerCase();
				if (SHEET_MAP.containsKey(mode)) {
					targetModes.add(mode);
				}
			}
		}

		if (targetModes.isEmpty()) {
			targetModes.addAll(SHEET_MAP.keySet());
		}

		setMcProgress(progressMap, jobId, 20);

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

			CellStyle headerStyle = workbook.createCellStyle();
			headerStyle.setFillForegroundColor(IndexedColors.BROWN.getIndex());
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerStyle.setAlignment(HorizontalAlignment.CENTER);
			headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			headerStyle.setBorderBottom(BorderStyle.THIN);
			headerStyle.setBorderTop(BorderStyle.THIN);
			headerStyle.setBorderLeft(BorderStyle.THIN);
			headerStyle.setBorderRight(BorderStyle.THIN);

			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.WHITE.getIndex());
			headerFont.setFontHeightInPoints((short) 11);
			headerStyle.setFont(headerFont);

			CellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setBorderBottom(BorderStyle.THIN);
			cellStyle.setBorderTop(BorderStyle.THIN);
			cellStyle.setBorderLeft(BorderStyle.THIN);
			cellStyle.setBorderRight(BorderStyle.THIN);
			cellStyle.setWrapText(true);
			cellStyle.setAlignment(HorizontalAlignment.CENTER);
			cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

			CellStyle percentageStyle = workbook.createCellStyle();
			percentageStyle.cloneStyleFrom(cellStyle);
			percentageStyle.setDataFormat(workbook.createDataFormat().getFormat("0.00%"));

			int progressStep = 60 / Math.max(1, targetModes.size());
			int currentProgress = 20;

			for (String mode : targetModes) {
				logger.info("MC download jobId={} manager sheet START mode={} date={} timeperiod={}", jobId, mode, date,
						timeperiod);
				long modeStarted = System.currentTimeMillis();
				Map<String, Object> managerData = getManagerViewData(mode, date, timeperiod);

				if (managerData == null || !managerData.containsKey("reportRows")) {
					logger.warn("MC download jobId={} manager sheet SKIP mode={} elapsedMs={}", jobId, mode,
							System.currentTimeMillis() - modeStarted);
					continue;
				}

				@SuppressWarnings("unchecked")
				List<RT_MC_Manager_DTO> rows = (List<RT_MC_Manager_DTO>) managerData.get("reportRows");

				@SuppressWarnings("unchecked")
				List<String> headerDates = (List<String>) managerData.get("headerDates");
				@SuppressWarnings("unchecked")
				List<String> yearDates = (List<String>) managerData.get("yearDates");

				String friendlyTableName = SHEET_MAP.get(mode);
				Sheet sheet = workbook.createSheet(friendlyTableName);

				createManagerHeaderRow(sheet, timeperiod, headerStyle, friendlyTableName, headerDates, yearDates);

				int rowIdx = 1;
				for (RT_MC_Manager_DTO dto : rows) {
					Row row = sheet.createRow(rowIdx++);

					createStyledCell(row, 0, dto.getDescription() != null ? dto.getDescription() : "-", cellStyle);

					createStyledNumericCell(row, 1, dto.getQ1Value(), cellStyle);
					createStyledNumericCell(row, 2, dto.getQ2Value(), cellStyle);
					createStyledNumericCell(row, 3, dto.getQ2VsQ1(), percentageStyle);

					createStyledNumericCell(row, 4, dto.getQ3Value(), cellStyle);
					createStyledNumericCell(row, 5, dto.getQ3VsQ2(), percentageStyle);

					createStyledNumericCell(row, 6, dto.getQ4Value(), cellStyle);
					createStyledNumericCell(row, 7, dto.getQuarterlyComparison(), percentageStyle);

					int cellOffset = 8;
					if ("YEARLY".equalsIgnoreCase(timeperiod)) {
						createStyledNumericCell(row, cellOffset, dto.getLastYearValue(), cellStyle);
						createStyledNumericCell(row, cellOffset + 1, dto.getCurrentYearValue(), cellStyle);
						createStyledNumericCell(row, cellOffset + 2, dto.getYearlyComparison(), percentageStyle);
						cellOffset += 3;
					}

					createStyledCell(row, cellOffset, dto.getMakerRemarks() != null ? dto.getMakerRemarks() : "-",
							cellStyle);
					createStyledCell(row, cellOffset + 1,
							dto.getCheckerRemarks() != null ? dto.getCheckerRemarks() : "-", cellStyle);
				}

				logger.info("MC download jobId={} manager autosize mode={} rows={}", jobId, mode, rows.size());
				sheet.setColumnWidth(0, 50 * 256);
				for (int i = 1; i < 15; i++) {
					sheet.autoSizeColumn(i);
				}
				logger.info("MC download jobId={} manager sheet END mode={} elapsedMs={}", jobId, mode,
						System.currentTimeMillis() - modeStarted);

				currentProgress += progressStep;
				setMcProgress(progressMap, jobId, Math.min(85, currentProgress));
			}

			if (workbook.getNumberOfSheets() == 0) {
				workbook.createSheet("No Data Available");
			}

			setMcProgress(progressMap, jobId, 90);
			logger.info("MC download jobId={} manager writing workbook", jobId);
			workbook.write(baos);
			return baos.toByteArray();
		}
	}

	private void createManagerHeaderRow(Sheet sheet, String timeperiod, CellStyle headerStyle, String tableName,
			List<String> headerDates, List<String> yearDates) {
		Row headerRow = sheet.createRow(0);

		String d1 = (headerDates != null && headerDates.size() > 3) ? headerDates.get(3) : "Date 1 (Q1)";
		String d2 = (headerDates != null && headerDates.size() > 2) ? headerDates.get(2) : "Date 2 (Q2)";
		String d3 = (headerDates != null && headerDates.size() > 1) ? headerDates.get(1) : "Date 3 (Q3)";
		String d4 = (headerDates != null && headerDates.size() > 0) ? headerDates.get(0) : "Date 4 (Q4)";

		String[] dynamicHeaders = { tableName, d1, d2, "Variation (Q2 vs Q1)", d3, "Variation (Q3 vs Q2)", d4,
				"Variation over Previous Qtr" };

		int colIdx = 0;
		for (String header : dynamicHeaders) {
			Cell cell = headerRow.createCell(colIdx++);
			cell.setCellValue(header);
			cell.setCellStyle(headerStyle);
		}

		if ("YEARLY".equalsIgnoreCase(timeperiod)) {
			String y1 = (yearDates != null && yearDates.size() > 1) ? yearDates.get(1) : "Last Year";
			String y2 = (yearDates != null && yearDates.size() > 0) ? yearDates.get(0) : "Current Year";

			Cell c1 = headerRow.createCell(colIdx++);
			c1.setCellValue(y1);
			c1.setCellStyle(headerStyle);
			Cell c2 = headerRow.createCell(colIdx++);
			c2.setCellValue(y2);
			c2.setCellStyle(headerStyle);
			Cell c3 = headerRow.createCell(colIdx++);
			c3.setCellValue("Variation over Annual Data");
			c3.setCellStyle(headerStyle);
		}

		Cell cm = headerRow.createCell(colIdx++);
		cm.setCellValue("Maker Remarks");
		cm.setCellStyle(headerStyle);
		Cell cc = headerRow.createCell(colIdx);
		cc.setCellValue("Checker Remarks");
		cc.setCellStyle(headerStyle);
	}

	private void createStyledNumericCell(Row row, int colIndex, Double value, CellStyle style) {
		Cell cell = row.createCell(colIndex);
		if (value != null) {
			cell.setCellValue(value);
		} else {
			cell.setCellValue("");
		}
		cell.setCellStyle(style);
	}
}