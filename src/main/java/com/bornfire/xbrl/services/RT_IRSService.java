package com.bornfire.xbrl.services;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.bornfire.xbrl.entities.RT_IRS2_REPOSITORY;
import com.bornfire.xbrl.entities.RT_IRS_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.RT_IRS_DETAIL_REPO;
import com.bornfire.xbrl.entities.RT_IRS_ENTITY;
import com.bornfire.xbrl.entities.RT_IRS_ENTITY2;
import com.bornfire.xbrl.entities.RT_IRS_REPOSITORY;
import com.bornfire.xbrl.entities.RT_SLS_Detail_Enitity;
import com.bornfire.xbrl.entities.RT_SLS_Detail_Repository;



@Service
public class RT_IRSService {
	private static final Logger logger = LoggerFactory.getLogger(RT_IRSService.class);
	

	@Autowired
	private Environment env;
	
	@Autowired
	RT_SLS_Detail_Repository rt_sls_detail_repository;
	
	@Autowired
	RT_IRS_REPOSITORY rt_irs_repository;
	
	@Autowired
	RT_IRS2_REPOSITORY rt_Irs2_Repository;
	
	@Autowired
	RT_IRS_DETAIL_REPO RT_IRS_DETAIL_REPO;

	
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	
	public byte[] getIrsExcel(String filename, String reportdate, String currency, String version) throws Exception {

	    logger.info("Service: Starting IRS Excel generation process.");

	    /* ================= TABLE 1 : R7 to R60 ================= */
	    List<RT_IRS_ENTITY> dataList =
	            rt_irs_repository.rtirslistbydate(dateformat.parse(reportdate), currency);

	    if (dataList == null || dataList.isEmpty()) {
	        logger.warn("Service: No data found for IRS report. Returning empty result.");
	        return new byte[0];
	    }

	    RT_IRS_ENTITY record1 = dataList.get(0);

	    /* ================= TABLE 2 : R61 to R87 ================= */
	    List<RT_IRS_ENTITY2> dataList2 =
	            rt_Irs2_Repository.rtirslistbydate(dateformat.parse(reportdate), currency);

	    RT_IRS_ENTITY2 record2 = null;
	    if (dataList2 != null && !dataList2.isEmpty()) {
	        record2 = dataList2.get(0);
	    }

	    String templateDir = env.getProperty("output.exportpathtemp");
	    Path templatePath = Paths.get(templateDir, filename);

	    if (!Files.exists(templatePath)) {
	        throw new FileNotFoundException("Template file not found: " + templatePath.toAbsolutePath());
	    }

	    try (InputStream templateInputStream = Files.newInputStream(templatePath);
	         Workbook workbook = WorkbookFactory.create(templateInputStream);
	         ByteArrayOutputStream out = new ByteArrayOutputStream()) {

	        Sheet sheet = workbook.getSheetAt(0);

	        String[] fieldSuffixes = {
	                "DAY1_28", "DAY29_3M", "OVER3M_TO_6M", "OVER6M_TO_1Y",
	                "OVER1Y_TO_3Y", "OVER3Y_TO_5Y", "OVER5Y_TO_7Y",
	                "OVER7Y_TO_10Y", "OVER10Y_TO_15Y", "OVER15Y",
	                "NON_SENSITIVE", "TOTAL_RSL", "TOTAL"
	        };

	        /* ================= TABLE 1 LOOP (R7–R60) ================= */
	        for (int rowIndex = 6; rowIndex < 59; rowIndex++) {

	            if (rowIndex == 45 || rowIndex == 46 ||
	                rowIndex == 47 || rowIndex == 48) {
	                continue;
	            }

	            Row row = sheet.getRow(rowIndex);
	            if (row == null) row = sheet.createRow(rowIndex);

	            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {

	                Cell cell = row.getCell(colIndex + 2);
	                if (cell == null) cell = row.createCell(colIndex + 2);

	                String fieldName =
	                        ("r" + (rowIndex + 1) + "_" + fieldSuffixes[colIndex]).toLowerCase();

	                try {
	                    Field field = RT_IRS_ENTITY.class.getDeclaredField(fieldName);
	                    field.setAccessible(true);
	                    Object value = field.get(record1);

	                    if (value instanceof BigDecimal) {
	                        cell.setCellValue(((BigDecimal) value).doubleValue());
	                    } else {
	                        cell.setCellValue(0.00);
	                    }

	                } catch (Exception e) {
	                    cell.setCellValue("");
	                }
	            }
	        }

	        /* ================= TABLE 2 LOOP (R61–R87) ================= */
	        if (record2 != null) {

	            for (int rowIndex = 60; rowIndex < 87; rowIndex++) {

	                Row row = sheet.getRow(rowIndex);
	                if (row == null) row = sheet.createRow(rowIndex);

	                for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {

	                    Cell cell = row.getCell(colIndex + 2);
	                    if (cell == null) cell = row.createCell(colIndex + 2);

	                    String fieldName =
	                            ("r" + (rowIndex + 1) + "_" + fieldSuffixes[colIndex]).toLowerCase();

	                    try {
	                        Field field = RT_IRS_ENTITY2.class.getDeclaredField(fieldName);
	                        field.setAccessible(true);
	                        Object value = field.get(record2);

	                        if (value instanceof BigDecimal) {
	                            cell.setCellValue(((BigDecimal) value).doubleValue());
	                        } else {
	                            cell.setCellValue(0.00);
	                        }

	                    } catch (Exception e) {
	                        cell.setCellValue("");
	                    }
	                }
	            }
	        }

	        workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
	        workbook.write(out);

	        logger.info("Service: IRS Excel generated successfully ({} bytes).", out.size());
	        return out.toByteArray();
	    }
	}

	
	
	public byte[] getDetailExcel(String filename,String reportdate, String currency,String version){
		try {
			logger.info("Generating Excel for IRS Details...");
			
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("IRS_Details");

			// Common border style
			BorderStyle border = BorderStyle.THIN;

			// Header style (left aligned)
			CellStyle headerStyle = workbook.createCellStyle();
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setFontHeightInPoints((short) 10);
			headerStyle.setFont(headerFont);
			headerStyle.setAlignment(HorizontalAlignment.LEFT);
			headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerStyle.setBorderTop(border);
			headerStyle.setBorderBottom(border);
			headerStyle.setBorderLeft(border);
			headerStyle.setBorderRight(border);

			// Right-aligned header style for ACCT BALANCE
			CellStyle rightAlignedHeaderStyle = workbook.createCellStyle();
			rightAlignedHeaderStyle.cloneStyleFrom(headerStyle);
			rightAlignedHeaderStyle.setAlignment(HorizontalAlignment.RIGHT);

			// Default data style (left aligned)
			CellStyle dataStyle = workbook.createCellStyle();
			dataStyle.setAlignment(HorizontalAlignment.LEFT);
			dataStyle.setBorderTop(border);
			dataStyle.setBorderBottom(border);
			dataStyle.setBorderLeft(border);
			dataStyle.setBorderRight(border);

			// ACCT BALANCE style (right aligned with 3 decimals)
			CellStyle balanceStyle = workbook.createCellStyle();
			balanceStyle.setAlignment(HorizontalAlignment.RIGHT);
			balanceStyle.setDataFormat(workbook.createDataFormat().getFormat("0.000"));
			balanceStyle.setBorderTop(border);
			balanceStyle.setBorderBottom(border);
			balanceStyle.setBorderLeft(border);
			balanceStyle.setBorderRight(border);

			// Header row
			String[] headers = { "CUST ID", "ACCT NO", "ACCT NAME", "ACCT BALANCE", "ROWID",
					"REPORT_DATE" };

			XSSFRow headerRow = sheet.createRow(0);
			for (int i = 0; i < headers.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(headers[i]);

				if (i == 3) { // ACCT BALANCE
					cell.setCellStyle(rightAlignedHeaderStyle);
				} else {
					cell.setCellStyle(headerStyle);
				}

				sheet.setColumnWidth(i, 5000);
			}

			// Get data
			Date parsedToDate = new SimpleDateFormat("dd-MMM-yyyy").parse(reportdate);
			
			 int batchSize = 5000;
		     int offset = 0;
		     int rowIndex = 1;
		     List<RT_IRS_DETAIL_ENTITY> reportData= new ArrayList<RT_IRS_DETAIL_ENTITY>();
		     //System.out.println("offset=="+offset);
		     while (true) {
		    	 
		    	 //System.out.println("offsettest");
		    	  reportData = RT_IRS_DETAIL_REPO.irsdetaillist(parsedToDate,offset,batchSize);
		    	    if (reportData.isEmpty()) break;  // <-- STOP when there is no more data

		    	    
		    	    if (reportData != null && !reportData.isEmpty()) {
						
						for (RT_IRS_DETAIL_ENTITY item : reportData) {
							XSSFRow row = sheet.createRow(rowIndex++);
							
							if(item.getCustId()!=null) {
								row.createCell(0).setCellValue(item.getCustId());
							}
							else {
								row.createCell(0).setCellValue(" ");
							}
							
							if(item.getForacid()!=null) {
								row.createCell(1).setCellValue(item.getForacid());
							}
							else {
								row.createCell(1).setCellValue(" ");
							}
							if(item.getAcctName()!=null) {
								row.createCell(2).setCellValue(item.getAcctName());
							}
							else {
								row.createCell(2).setCellValue("");
							}
							
							
							

							// ACCT BALANCE (right aligned, 3 decimal places)
							Cell balanceCell = row.createCell(3);
							if (item.getAcctBalanceLc() != null) {
								balanceCell.setCellValue(item.getAcctBalanceLc().doubleValue());
							} else {
								balanceCell.setCellValue(0.000);
							}
							balanceCell.setCellStyle(balanceStyle);

							row.createCell(4).setCellValue(item.getReportLabel());
							row.createCell(5)
									.setCellValue(item.getReportDate() != null ? new SimpleDateFormat("dd-MM-yyyy").format(item.getReportDate()) : "");

							
							// Apply data style for all other cells
							for (int j = 0; j <=5; j++) {
								if (j != 3) {
									row.getCell(j).setCellStyle(dataStyle);
								}
							}
						}
					} else {
						logger.info("No data found for sls — only header will be written.");
					}

		    	    offset += batchSize;
		    	   
		    	}
		     
			
			System.out.println(reportData.size());

			

			// Write to byte[]
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			workbook.close();

			logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
			return bos.toByteArray();

		} catch (Exception e) {
			logger.error("Error generating sls Excel", e);
			return null;
		}
	}
	
	
	private final ConcurrentHashMap<String, byte[]> jobStorage = new ConcurrentHashMap<>();

	
    @Async
    public void generateReportAsync(String jobId, String filename, String reportDate, String currency,String version) {
        //System.out.println("Starting report generation for: " + filename);
		        
		byte[] fileData = getDetailExcel(filename,reportDate,currency, version);
		if (fileData == null) {
		    //logger.warn("Excel generation failed or no data for jobId: {}", jobId);
			System.out.println("the file data" + fileData);
		    if (fileData != null && fileData.length > 0) {
		        jobStorage.put(jobId, fileData);
		    }

		} else {
		    jobStorage.put(jobId, fileData);
		}

		//System.out.println("Report generation completed for: " + filename);
    }

    
    public byte[] getReport(String jobId) {
        return jobStorage.get(jobId);
    }

	
	
	
}

