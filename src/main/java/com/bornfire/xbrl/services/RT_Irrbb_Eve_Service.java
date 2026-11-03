package com.bornfire.xbrl.services;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.io.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.bornfire.xbrl.entities.RT_FxRiskDataRepository;
import com.bornfire.xbrl.entities.RT_Fxriskdata;
import com.bornfire.xbrl.entities.RT_IRRBB_Data_EAR;
import com.bornfire.xbrl.entities.RT_IRRBB_Data_EAR_Repository;
import com.bornfire.xbrl.entities.RT_IRRBB_Data_EVE_Template;
import com.bornfire.xbrl.entities.RT_IRRBB_Data_EVE_Template_Repository;
import com.bornfire.xbrl.entities.RT_IRRBB_RECON;
import com.bornfire.xbrl.entities.RT_IRRBB_RECON_Repository;
import org.apache.poi.ss.usermodel.CellType;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileNotFoundException;



@Service
public class RT_Irrbb_Eve_Service {

	@Autowired
	private Environment env;
	
	
	
    private static final Logger logger = LoggerFactory.getLogger(RT_Irrbb_Eve_Service.class);

	 @Autowired
	 RT_IRRBB_Data_EAR_Repository IRRBB_EAR_Repository;
	
    @Autowired
    RT_IRRBB_Data_EVE_Template_Repository IRRB_EVE_Repo;

    @Autowired
    RT_IRRBB_RECON_Repository rt_irrbb_recon_repository;

	@Autowired
	private SessionFactory sessionFactory;

	public boolean updateirrbbeve(RT_IRRBB_Data_EVE_Template updatedData) {
	    System.out.println("Looking for record with SI_NO: " + updatedData.getSI_NO());

	   // RT_IRRBB_Data_EVE_Template existing = IRRB_EVE_Repo.getParticularDataBySI_NO(updatedData.getSI_NO());
	    RT_IRRBB_Data_EVE_Template existing =null;
	    //RT_IRRBB_Data_EVE_Template existing =IRRB_EVE_Repo.findById(updatedData.getSI_NO()).orElse(null);

	    if (existing != null) {
	        // Update fields
	    	existing.setReportDate(updatedData.getReportDate());
	    	existing.setBankName(updatedData.getBankName());
	    	existing.setGroupHeadOfficeSubsidiary(updatedData.getGroupHeadOfficeSubsidiary());
	    	existing.setBankSymbol(updatedData.getBankSymbol());
	    	existing.setConventionalOrIslamic(updatedData.getConventionalOrIslamic());
	    	existing.setLocalOrForeign(updatedData.getLocalOrForeign());
	    	existing.setCbuaeTiering(updatedData.getCbuaeTiering());
	    	existing.setSubsidiary(updatedData.getSubsidiary());
	    	existing.setScenario(updatedData.getScenario());
	    	existing.setGlLevel1(updatedData.getGlLevel1());
	    	existing.setGlLevel2(updatedData.getGlLevel2());
	    	existing.setGlLevel3(updatedData.getGlLevel3());
	    	existing.setOptionType(updatedData.getOptionType());
	    	existing.setRateType(updatedData.getRateType());
	    	existing.setReferenceRate(updatedData.getReferenceRate());
	    	existing.setInstrumentCurrency(updatedData.getInstrumentCurrency());
	    	existing.setOutstandingBalance(updatedData.getOutstandingBalance());
	    	existing.setOvernight(updatedData.getOvernight());
	    	existing.setOnToOneM(updatedData.getOnToOneM());
	    	existing.setOneMToThreeM(updatedData.getOneMToThreeM());
	    	existing.setThreeMToSixM(updatedData.getThreeMToSixM());
	    	existing.setSixMonthToNineM(updatedData.getSixMonthToNineM());
	    	existing.setNineMonthToOneY(updatedData.getNineMonthToOneY());
	    	existing.setOneYToFiveY(updatedData.getOneYToFiveY());
	    	existing.setOnePointFiveYToTwoY(updatedData.getOnePointFiveYToTwoY());
	    	existing.setTwoYToThreeY(updatedData.getTwoYToThreeY());
	    	existing.setThreeYToFourY(updatedData.getThreeYToFourY());
	    	existing.setFourYToFiveY(updatedData.getFourYToFiveY());
	    	existing.setFiveYToSixY(updatedData.getFiveYToSixY());
	    	existing.setSixYToSevenY(updatedData.getSixYToSevenY());
	    	existing.setSevenYToEightY(updatedData.getSevenYToEightY());
	    	existing.setEightYToNineY(updatedData.getEightYToNineY());
	    	existing.setNineYToTenY(updatedData.getNineYToTenY());
	    	existing.setTenYToFifteenY(updatedData.getTenYToFifteenY());
	    	existing.setFifteenYToTwentyY(updatedData.getFifteenYToTwentyY());
	    	existing.setTwentyYearAbove(updatedData.getTwentyYearAbove());
	    	existing.setNonRateSensitive(updatedData.getNonRateSensitive());

	    	

	    	IRRB_EVE_Repo.save(existing);
	        return true;
	    } else {
	        System.out.println("No record found for SI_NO: " + updatedData.getSI_NO());
	        return false;
	    }
	}
	
	
	 public byte[] generateIrrbbeveExcel(Date Report_date) throws Exception {
	        logger.info("Service: Starting IRRBB EVE Excel generation process in memory for report date {}.", Report_date);

	        List<Object[]> irrbbeveList = IRRB_EVE_Repo.getirrbbevedatalistdata1(Report_date);

	        if (irrbbeveList.isEmpty()) {
	            logger.warn("Service: No data found for IRRBB EVE report. Returning empty result.");
	            return new byte[0];
	        }

	        String templateDir = env.getProperty("output.exportpathtemp");  // Corrected property key
	        String templateFileName = "CBUAE_Irrbb_Data_EVE_Template.xlsx";
	        Path templatePath = Paths.get(templateDir, templateFileName);

	        logger.info("Service: Attempting to load template from path: {}", templatePath.toAbsolutePath());

	        if (!Files.exists(templatePath)) {
	            throw new FileNotFoundException("Template file not found at: " + templatePath.toAbsolutePath());
	        }

	        if (!Files.isReadable(templatePath)) {
	            throw new SecurityException("Template file exists but is not readable: " + templatePath.toAbsolutePath());
	        }

	        try (InputStream templateInputStream = Files.newInputStream(templatePath);
	             Workbook workbook = WorkbookFactory.create(templateInputStream);
	             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

	            Sheet sheet = workbook.getSheetAt(0);
	            CreationHelper createHelper = workbook.getCreationHelper();

	            // Define cell styles
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

	            CellStyle numberStyle = workbook.createCellStyle();
	            numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("#,##0.00"));
	            numberStyle.setBorderBottom(BorderStyle.THIN);
	            numberStyle.setBorderTop(BorderStyle.THIN);
	            numberStyle.setBorderLeft(BorderStyle.THIN);
	            numberStyle.setBorderRight(BorderStyle.THIN);

	            int startRow = 1; // Assuming data starts from row index 3 (4rd row)

	            if (!irrbbeveList.isEmpty()) {
	                for (int i = 0; i < irrbbeveList.size(); i++) {
	                    Object[] mm = irrbbeveList.get(i);
	                    Row row = sheet.getRow(startRow + i);
	                    if (row == null) row = sheet.createRow(startRow + i);

	                 // 0 - REPORT_DATE (Date)
	                    Cell cell0 = row.getCell(0);
	                    if (cell0 == null) cell0 = row.createCell(0);
	                    if (mm[0] instanceof Date) {
	                        cell0.setCellValue((Date) mm[0]);
	                        cell0.setCellStyle(dateStyle);
	                    } else {
	                        cell0.setCellValue("");
	                    }

	                    // 1 - BANK_NAME
	                    Cell cell1 = row.getCell(1);
	                    if (cell1 == null) cell1 = row.createCell(1);
	                    cell1.setCellValue(mm[1] == null ? "" : mm[1].toString());

	                    // 2 - GROUP_HEAD_OFFICE_SUBSIDIARY
	                    Cell cell2 = row.getCell(2);
	                    if (cell2 == null) cell2 = row.createCell(2);
	                    cell2.setCellValue(mm[2] == null ? "" : mm[2].toString());

	                    // 3 - BANK_SYMBOL
	                    Cell cell3 = row.getCell(3);
	                    if (cell3 == null) cell3 = row.createCell(3);
	                    cell3.setCellValue(mm[3] == null ? "" : mm[3].toString());

	                    // 4 - CONVENTIONAL_OR_ISLAMIC
	                    Cell cell4 = row.getCell(4);
	                    if (cell4 == null) cell4 = row.createCell(4);
	                    cell4.setCellValue(mm[4] == null ? "" : mm[4].toString());

	                    // 5 - LOCAL_OR_FOREIGN
	                    Cell cell5 = row.getCell(5);
	                    if (cell5 == null) cell5 = row.createCell(5);
	                    cell5.setCellValue(mm[5] == null ? "" : mm[5].toString());

	                    // 6 - CBUAE_TIERING
	                    Cell cell6 = row.getCell(6);
	                    if (cell6 == null) cell6 = row.createCell(6);
	                    cell6.setCellValue(mm[6] == null ? "" : mm[6].toString());

	                    // 7 - SUBSIDIARY
	                    Cell cell7 = row.getCell(7);
	                    if (cell7 == null) cell7 = row.createCell(7);
	                    cell7.setCellValue(mm[7] == null ? "" : mm[7].toString());

	                    // 8 - SCENARIO
	                    Cell cell8 = row.getCell(8);
	                    if (cell8 == null) cell8 = row.createCell(8);
	                    cell8.setCellValue(mm[8] == null ? "" : mm[8].toString());

	                    // 9 - GL_LEVEL_1
	                    Cell cell9 = row.getCell(9);
	                    if (cell9 == null) cell9 = row.createCell(9);
	                    cell9.setCellValue(mm[9] == null ? "" : mm[9].toString());

	                    // 10 - GL_LEVEL_2
	                    Cell cell10 = row.getCell(10);
	                    if (cell10 == null) cell10 = row.createCell(10);
	                    cell10.setCellValue(mm[10] == null ? "" : mm[10].toString());

	                    // 11 - GL_LEVEL_3
	                    Cell cell11 = row.getCell(11);
	                    if (cell11 == null) cell11 = row.createCell(11);
	                    cell11.setCellValue(mm[11] == null ? "" : mm[11].toString());

	                    // 12 - OPTION_TYPE
	                    Cell cell12 = row.getCell(12);
	                    if (cell12 == null) cell12 = row.createCell(12);
	                    cell12.setCellValue(mm[12] == null ? "" : mm[12].toString());

	                    // 13 - RATE_TYPE
	                    Cell cell13 = row.getCell(13);
	                    if (cell13 == null) cell13 = row.createCell(13);
	                    cell13.setCellValue(mm[13] == null ? "" : mm[13].toString());

	                    // 14 - REFERENCE_RATE
	                    Cell cell14 = row.getCell(14);
	                    if (cell14 == null) cell14 = row.createCell(14);
	                    cell14.setCellValue(mm[14] == null ? "" : mm[14].toString());

	                    // 15 - INSTRUMENT_CURRENCY
	                    Cell cell15 = row.getCell(15);
	                    if (cell15 == null) cell15 = row.createCell(15);
	                    cell15.setCellValue(mm[15] == null ? "" : mm[15].toString());

	                    // 16 - OUTSTANDING_BALANCE
	                    Cell cell16 = row.getCell(16);
	                    if (cell16 == null) cell16 = row.createCell(16);
	                    if (mm[16] instanceof BigDecimal) {
	                        cell16.setCellValue(((BigDecimal) mm[16]).doubleValue());
	                    } else {
	                        cell16.setCellValue("");
	                    }

	                    // 17 - OVERNIGHT
	                    Cell cell17 = row.getCell(17);
	                    if (cell17 == null) cell17 = row.createCell(17);
	                    if (mm[17] instanceof BigDecimal) {
	                        cell17.setCellValue(((BigDecimal) mm[17]).doubleValue());
	                    } else {
	                        cell17.setCellValue("");
	                    }

	                    // 18 - ON_TO_ONE_M
	                    Cell cell18 = row.getCell(18);
	                    if (cell18 == null) cell18 = row.createCell(18);
	                    if (mm[18] instanceof BigDecimal) {
	                        cell18.setCellValue(((BigDecimal) mm[18]).doubleValue());
	                    } else {
	                        cell18.setCellValue("");
	                    }

	                    // 19 - ONE_M_TO_THREE_M
	                    Cell cell19 = row.getCell(19);
	                    if (cell19 == null) cell19 = row.createCell(19);
	                    if (mm[19] instanceof BigDecimal) {
	                        cell19.setCellValue(((BigDecimal) mm[19]).doubleValue());
	                    } else {
	                        cell19.setCellValue("");
	                    }

	                    // 20 - THREE_M_TO_SIX_M
	                    Cell cell20 = row.getCell(20);
	                    if (cell20 == null) cell20 = row.createCell(20);
	                    if (mm[20] instanceof BigDecimal) {
	                        cell20.setCellValue(((BigDecimal) mm[20]).doubleValue());
	                    } else {
	                        cell20.setCellValue("");
	                    }

	                    // 21 - SIX_M_TO_NINE_M
	                    Cell cell21 = row.getCell(21);
	                    if (cell21 == null) cell21 = row.createCell(21);
	                    if (mm[21] instanceof BigDecimal) {
	                        cell21.setCellValue(((BigDecimal) mm[21]).doubleValue());
	                    } else {
	                        cell21.setCellValue("");
	                    }

	                    // 22 - NINE_M_TO_ONE_Y
	                    Cell cell22 = row.getCell(22);
	                    if (cell22 == null) cell22 = row.createCell(22);
	                    if (mm[22] instanceof BigDecimal) {
	                        cell22.setCellValue(((BigDecimal) mm[22]).doubleValue());
	                    } else {
	                        cell22.setCellValue("");
	                    }

	                    // 23 - ONE_Y_TO_FIVE_Y
	                    Cell cell23 = row.getCell(23);
	                    if (cell23 == null) cell23 = row.createCell(23);
	                    if (mm[23] instanceof BigDecimal) {
	                        cell23.setCellValue(((BigDecimal) mm[23]).doubleValue());
	                    } else {
	                        cell23.setCellValue("");
	                    }

	                    // 24 - ONE_POINT_FIVE_Y_TO_TWO_Y
	                    Cell cell24 = row.getCell(24);
	                    if (cell24 == null) cell24 = row.createCell(24);
	                    if (mm[24] instanceof BigDecimal) {
	                        cell24.setCellValue(((BigDecimal) mm[24]).doubleValue());
	                    } else {
	                        cell24.setCellValue("");
	                    }

	                    // 25 - TWO_Y_TO_THREE_Y
	                    Cell cell25 = row.getCell(25);
	                    if (cell25 == null) cell25 = row.createCell(25);
	                    if (mm[25] instanceof BigDecimal) {
	                        cell25.setCellValue(((BigDecimal) mm[25]).doubleValue());
	                    } else {
	                        cell25.setCellValue("");
	                    }

	                    // 26 - THREE_Y_TO_FOUR_Y
	                    Cell cell26 = row.getCell(26);
	                    if (cell26 == null) cell26 = row.createCell(26);
	                    if (mm[26] instanceof BigDecimal) {
	                        cell26.setCellValue(((BigDecimal) mm[26]).doubleValue());
	                    } else {
	                        cell26.setCellValue("");
	                    }

	                    // 27 - FOUR_Y_TO_FIVE_Y
	                    Cell cell27 = row.getCell(27);
	                    if (cell27 == null) cell27 = row.createCell(27);
	                    if (mm[27] instanceof BigDecimal) {
	                        cell27.setCellValue(((BigDecimal) mm[27]).doubleValue());
	                    } else {
	                        cell27.setCellValue("");
	                    }

	                    // 28 - FIVE_Y_TO_SIX_Y
	                    Cell cell28 = row.getCell(28);
	                    if (cell28 == null) cell28 = row.createCell(28);
	                    if (mm[28] instanceof BigDecimal) {
	                        cell28.setCellValue(((BigDecimal) mm[28]).doubleValue());
	                    } else {
	                        cell28.setCellValue("");
	                    }

	                    // 29 - SIX_Y_TO_SEVEN_Y
	                    Cell cell29 = row.getCell(29);
	                    if (cell29 == null) cell29 = row.createCell(29);
	                    if (mm[29] instanceof BigDecimal) {
	                        cell29.setCellValue(((BigDecimal) mm[29]).doubleValue());
	                    } else {
	                        cell29.setCellValue("");
	                    }

	                    // 30 - SEVEN_Y_TO_EIGHT_Y
	                    Cell cell30 = row.getCell(30);
	                    if (cell30 == null) cell30 = row.createCell(30);
	                    if (mm[30] instanceof BigDecimal) {
	                        cell30.setCellValue(((BigDecimal) mm[30]).doubleValue());
	                    } else {
	                        cell30.setCellValue("");
	                    }

	                    // 31 - EIGHT_Y_TO_NINE_Y
	                    Cell cell31 = row.getCell(31);
	                    if (cell31 == null) cell31 = row.createCell(31);
	                    if (mm[31] instanceof BigDecimal) {
	                        cell31.setCellValue(((BigDecimal) mm[31]).doubleValue());
	                    } else {
	                        cell31.setCellValue("");
	                    }

	                    // 32 - NINE_Y_TO_TEN_Y
	                    Cell cell32 = row.getCell(32);
	                    if (cell32 == null) cell32 = row.createCell(32);
	                    if (mm[32] instanceof BigDecimal) {
	                        cell32.setCellValue(((BigDecimal) mm[32]).doubleValue());
	                    } else {
	                        cell32.setCellValue("");
	                    }

	                    // 33 - TEN_Y_TO_FIFTEEN_Y
	                    Cell cell33 = row.getCell(33);
	                    if (cell33 == null) cell33 = row.createCell(33);
	                    if (mm[33] instanceof BigDecimal) {
	                        cell33.setCellValue(((BigDecimal) mm[33]).doubleValue());
	                    } else {
	                        cell33.setCellValue("");
	                    }

	                    // 34 - FIFTEEN_Y_TO_TWENTY_Y
	                    Cell cell34 = row.getCell(34);
	                    if (cell34 == null) cell34 = row.createCell(34);
	                    if (mm[34] instanceof BigDecimal) {
	                        cell34.setCellValue(((BigDecimal) mm[34]).doubleValue());
	                    } else {
	                        cell34.setCellValue("");
	                    }

	                    // 35 - TWENTY_YEAR_ABOVE
	                    Cell cell35 = row.getCell(35);
	                    if (cell35 == null) cell35 = row.createCell(35);
	                    if (mm[35] instanceof BigDecimal) {
	                        cell35.setCellValue(((BigDecimal) mm[35]).doubleValue());
	                    } else {
	                        cell35.setCellValue("");
	                    }

	                    // 36 - NON_RATE_SENSITIVE
	                    Cell cell36 = row.getCell(36);
	                    if (cell36 == null) cell36 = row.createCell(36);
	                    if (mm[36] instanceof BigDecimal) {
	                        cell36.setCellValue(((BigDecimal) mm[36]).doubleValue());
	                    } else {
	                        cell36.setCellValue("");
	                    }

	                
	                }

	            
				workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
			} else {
				System.out.println("No Irrbb data EVE found to generate the Excel file.");
			}

			// Write the final workbook content to the in-memory stream.
			workbook.write(out);

			logger.info("Service: Excel data successfully written to memory buffer ({} bytes).", out.size());

			return out.toByteArray();
		}
	}
	 
	 
	 public byte[] generateIrrbbExcel(Date Report_date) throws Exception {
	        logger.info("Service: Starting IRRBB Excel generation process in memory for report date {}.", Report_date);

	        List<Object[]> irrbbeveList = IRRB_EVE_Repo.getirrbbevedatalistdata1(Report_date);
	        List<Object[]> irrbbearList = IRRBB_EAR_Repository.getirrbbeardatalistdata1(Report_date);

	        List<RT_IRRBB_RECON> reconList = null;
	        if (Report_date != null) {
	            reconList = rt_irrbb_recon_repository.getAlldetails(Report_date);
	            if (reconList == null || reconList.isEmpty()) {
	                reconList = rt_irrbb_recon_repository.getDetailsByReportDate(Report_date);
	            }
	        }
	        if (reconList == null || reconList.isEmpty()) {
	            reconList = rt_irrbb_recon_repository.getAllRecords();
	        }

	        if (irrbbeveList.isEmpty() && irrbbearList.isEmpty() && (reconList == null || reconList.isEmpty())) {
	            logger.warn("Service: No data found for IRRBB report on {}. Returning empty result.", Report_date);
	            return new byte[0];
	        }

	        String templateDir = env.getProperty("output.exportpathtemp");  // Corrected property key
	        String templateFileName = "CBUAE_Irrbb_Data_Template.xlsx";
	        Path templatePath = Paths.get(templateDir, templateFileName);

	        logger.info("Service: Attempting to load template from path: {}", templatePath.toAbsolutePath());

	        if (!Files.exists(templatePath)) {
	            throw new FileNotFoundException("Template file not found at: " + templatePath.toAbsolutePath());
	        }

	        if (!Files.isReadable(templatePath)) {
	            throw new SecurityException("Template file exists but is not readable: " + templatePath.toAbsolutePath());
	        }

	        try (InputStream templateInputStream = Files.newInputStream(templatePath);
	             Workbook workbook = WorkbookFactory.create(templateInputStream);
	             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

	            Sheet sheet = workbook.getSheetAt(3);
	            Sheet sheet4 = workbook.getSheetAt(4);
	            
	            Sheet reconSheet = null;
	            try {
	                reconSheet = workbook.getSheet("Reconciliation");
	            } catch (Exception e) {
	                logger.warn("Could not find sheet named 'Reconciliation'", e);
	            }
	            if (reconSheet == null && workbook.getNumberOfSheets() > 6) {
	                reconSheet = workbook.getSheetAt(6);
	            }
	            
	            CreationHelper createHelper = workbook.getCreationHelper();

	            // Define cell styles
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

	            CellStyle numberStyle = workbook.createCellStyle();
	            numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("#,##0.00"));
	            numberStyle.setBorderBottom(BorderStyle.THIN);
	            numberStyle.setBorderTop(BorderStyle.THIN);
	            numberStyle.setBorderLeft(BorderStyle.THIN);
	            numberStyle.setBorderRight(BorderStyle.THIN);

	            int startRow = 1; // Assuming data starts from row index 3 (4rd row)

	            if (!irrbbeveList.isEmpty()) {
	                for (int i = 0; i < irrbbeveList.size(); i++) {
	                    Object[] mm = irrbbeveList.get(i);
	                    Row row = sheet.getRow(startRow + i);
	                    if (row == null) row = sheet.createRow(startRow + i);

	                 // 0 - REPORT_DATE (Date)
	                    Cell cell0 = row.getCell(0);
	                    if (cell0 == null) cell0 = row.createCell(0);
	                    if (mm[0] instanceof Date) {
	                        cell0.setCellValue((Date) mm[0]);
	                        cell0.setCellStyle(dateStyle);
	                    } else {
	                        cell0.setCellValue("");
	                    }

	                    // 1 - BANK_NAME
	                    Cell cell1 = row.getCell(1);
	                    if (cell1 == null) cell1 = row.createCell(1);
	                    cell1.setCellValue(mm[1] == null ? "" : mm[1].toString());

	                    // 2 - GROUP_HEAD_OFFICE_SUBSIDIARY
	                    Cell cell2 = row.getCell(2);
	                    if (cell2 == null) cell2 = row.createCell(2);
	                    cell2.setCellValue(mm[2] == null ? "" : mm[2].toString());

	                    // 3 - BANK_SYMBOL
	                    Cell cell3 = row.getCell(3);
	                    if (cell3 == null) cell3 = row.createCell(3);
	                    cell3.setCellValue(mm[3] == null ? "" : mm[3].toString());

	                    // 4 - CONVENTIONAL_OR_ISLAMIC
	                    Cell cell4 = row.getCell(4);
	                    if (cell4 == null) cell4 = row.createCell(4);
	                    cell4.setCellValue(mm[4] == null ? "" : mm[4].toString());

	                    // 5 - LOCAL_OR_FOREIGN
	                    Cell cell5 = row.getCell(5);
	                    if (cell5 == null) cell5 = row.createCell(5);
	                    cell5.setCellValue(mm[5] == null ? "" : mm[5].toString());

	                    // 6 - CBUAE_TIERING
	                    Cell cell6 = row.getCell(6);
	                    if (cell6 == null) cell6 = row.createCell(6);
	                    cell6.setCellValue(mm[6] == null ? "" : mm[6].toString());

	                    // 7 - SUBSIDIARY
	                    Cell cell7 = row.getCell(7);
	                    if (cell7 == null) cell7 = row.createCell(7);
	                    cell7.setCellValue(mm[7] == null ? "" : mm[7].toString());

	                    // 8 - SCENARIO
	                    Cell cell8 = row.getCell(8);
	                    if (cell8 == null) cell8 = row.createCell(8);
	                    cell8.setCellValue(mm[8] == null ? "" : mm[8].toString());

	                    // 9 - GL_LEVEL_1
	                    Cell cell9 = row.getCell(9);
	                    if (cell9 == null) cell9 = row.createCell(9);
	                    cell9.setCellValue(mm[9] == null ? "" : mm[9].toString());

	                    // 10 - GL_LEVEL_2
	                    Cell cell10 = row.getCell(10);
	                    if (cell10 == null) cell10 = row.createCell(10);
	                    cell10.setCellValue(mm[10] == null ? "" : mm[10].toString());

	                    // 11 - GL_LEVEL_3
	                    Cell cell11 = row.getCell(11);
	                    if (cell11 == null) cell11 = row.createCell(11);
	                    cell11.setCellValue(mm[11] == null ? "" : mm[11].toString());

	                    // 12 - OPTION_TYPE
	                    Cell cell12 = row.getCell(12);
	                    if (cell12 == null) cell12 = row.createCell(12);
	                    cell12.setCellValue(mm[12] == null ? "" : mm[12].toString());

	                    // 13 - RATE_TYPE
	                    Cell cell13 = row.getCell(13);
	                    if (cell13 == null) cell13 = row.createCell(13);
	                    cell13.setCellValue(mm[13] == null ? "" : mm[13].toString());

	                    // 14 - REFERENCE_RATE
	                    Cell cell14 = row.getCell(14);
	                    if (cell14 == null) cell14 = row.createCell(14);
	                    cell14.setCellValue(mm[14] == null ? "" : mm[14].toString());

	                    // 15 - INSTRUMENT_CURRENCY
	                    Cell cell15 = row.getCell(15);
	                    if (cell15 == null) cell15 = row.createCell(15);
	                    cell15.setCellValue(mm[15] == null ? "" : mm[15].toString());

	                    // 16 - OUTSTANDING_BALANCE
	                    Cell cell16 = row.getCell(16);
	                    if (cell16 == null) cell16 = row.createCell(16);
	                    if (mm[16] instanceof BigDecimal) {
	                        cell16.setCellValue(((BigDecimal) mm[16]).doubleValue());
	                    } else {
	                        cell16.setCellValue("");
	                    }

	                    // 17 - OVERNIGHT
	                    Cell cell17 = row.getCell(17);
	                    if (cell17 == null) cell17 = row.createCell(17);
	                    if (mm[17] instanceof BigDecimal) {
	                        cell17.setCellValue(((BigDecimal) mm[17]).doubleValue());
	                    } else {
	                        cell17.setCellValue("");
	                    }

	                    // 18 - ON_TO_ONE_M
	                    Cell cell18 = row.getCell(18);
	                    if (cell18 == null) cell18 = row.createCell(18);
	                    if (mm[18] instanceof BigDecimal) {
	                        cell18.setCellValue(((BigDecimal) mm[18]).doubleValue());
	                    } else {
	                        cell18.setCellValue("");
	                    }

	                    // 19 - ONE_M_TO_THREE_M
	                    Cell cell19 = row.getCell(19);
	                    if (cell19 == null) cell19 = row.createCell(19);
	                    if (mm[19] instanceof BigDecimal) {
	                        cell19.setCellValue(((BigDecimal) mm[19]).doubleValue());
	                    } else {
	                        cell19.setCellValue("");
	                    }

	                    // 20 - THREE_M_TO_SIX_M
	                    Cell cell20 = row.getCell(20);
	                    if (cell20 == null) cell20 = row.createCell(20);
	                    if (mm[20] instanceof BigDecimal) {
	                        cell20.setCellValue(((BigDecimal) mm[20]).doubleValue());
	                    } else {
	                        cell20.setCellValue("");
	                    }

	                    // 21 - SIX_M_TO_NINE_M
	                    Cell cell21 = row.getCell(21);
	                    if (cell21 == null) cell21 = row.createCell(21);
	                    if (mm[21] instanceof BigDecimal) {
	                        cell21.setCellValue(((BigDecimal) mm[21]).doubleValue());
	                    } else {
	                        cell21.setCellValue("");
	                    }

	                    // 22 - NINE_M_TO_ONE_Y
	                    Cell cell22 = row.getCell(22);
	                    if (cell22 == null) cell22 = row.createCell(22);
	                    if (mm[22] instanceof BigDecimal) {
	                        cell22.setCellValue(((BigDecimal) mm[22]).doubleValue());
	                    } else {
	                        cell22.setCellValue("");
	                    }

	                    // 23 - ONE_Y_TO_FIVE_Y
	                    Cell cell23 = row.getCell(23);
	                    if (cell23 == null) cell23 = row.createCell(23);
	                    if (mm[23] instanceof BigDecimal) {
	                        cell23.setCellValue(((BigDecimal) mm[23]).doubleValue());
	                    } else {
	                        cell23.setCellValue("");
	                    }

	                    // 24 - ONE_POINT_FIVE_Y_TO_TWO_Y
	                    Cell cell24 = row.getCell(24);
	                    if (cell24 == null) cell24 = row.createCell(24);
	                    if (mm[24] instanceof BigDecimal) {
	                        cell24.setCellValue(((BigDecimal) mm[24]).doubleValue());
	                    } else {
	                        cell24.setCellValue("");
	                    }

	                    // 25 - TWO_Y_TO_THREE_Y
	                    Cell cell25 = row.getCell(25);
	                    if (cell25 == null) cell25 = row.createCell(25);
	                    if (mm[25] instanceof BigDecimal) {
	                        cell25.setCellValue(((BigDecimal) mm[25]).doubleValue());
	                    } else {
	                        cell25.setCellValue("");
	                    }

	                    // 26 - THREE_Y_TO_FOUR_Y
	                    Cell cell26 = row.getCell(26);
	                    if (cell26 == null) cell26 = row.createCell(26);
	                    if (mm[26] instanceof BigDecimal) {
	                        cell26.setCellValue(((BigDecimal) mm[26]).doubleValue());
	                    } else {
	                        cell26.setCellValue("");
	                    }

	                    // 27 - FOUR_Y_TO_FIVE_Y
	                    Cell cell27 = row.getCell(27);
	                    if (cell27 == null) cell27 = row.createCell(27);
	                    if (mm[27] instanceof BigDecimal) {
	                        cell27.setCellValue(((BigDecimal) mm[27]).doubleValue());
	                    } else {
	                        cell27.setCellValue("");
	                    }

	                    // 28 - FIVE_Y_TO_SIX_Y
	                    Cell cell28 = row.getCell(28);
	                    if (cell28 == null) cell28 = row.createCell(28);
	                    if (mm[28] instanceof BigDecimal) {
	                        cell28.setCellValue(((BigDecimal) mm[28]).doubleValue());
	                    } else {
	                        cell28.setCellValue("");
	                    }

	                    // 29 - SIX_Y_TO_SEVEN_Y
	                    Cell cell29 = row.getCell(29);
	                    if (cell29 == null) cell29 = row.createCell(29);
	                    if (mm[29] instanceof BigDecimal) {
	                        cell29.setCellValue(((BigDecimal) mm[29]).doubleValue());
	                    } else {
	                        cell29.setCellValue("");
	                    }

	                    // 30 - SEVEN_Y_TO_EIGHT_Y
	                    Cell cell30 = row.getCell(30);
	                    if (cell30 == null) cell30 = row.createCell(30);
	                    if (mm[30] instanceof BigDecimal) {
	                        cell30.setCellValue(((BigDecimal) mm[30]).doubleValue());
	                    } else {
	                        cell30.setCellValue("");
	                    }

	                    // 31 - EIGHT_Y_TO_NINE_Y
	                    Cell cell31 = row.getCell(31);
	                    if (cell31 == null) cell31 = row.createCell(31);
	                    if (mm[31] instanceof BigDecimal) {
	                        cell31.setCellValue(((BigDecimal) mm[31]).doubleValue());
	                    } else {
	                        cell31.setCellValue("");
	                    }

	                    // 32 - NINE_Y_TO_TEN_Y
	                    Cell cell32 = row.getCell(32);
	                    if (cell32 == null) cell32 = row.createCell(32);
	                    if (mm[32] instanceof BigDecimal) {
	                        cell32.setCellValue(((BigDecimal) mm[32]).doubleValue());
	                    } else {
	                        cell32.setCellValue("");
	                    }

	                    // 33 - TEN_Y_TO_FIFTEEN_Y
	                    Cell cell33 = row.getCell(33);
	                    if (cell33 == null) cell33 = row.createCell(33);
	                    if (mm[33] instanceof BigDecimal) {
	                        cell33.setCellValue(((BigDecimal) mm[33]).doubleValue());
	                    } else {
	                        cell33.setCellValue("");
	                    }

	                    // 34 - FIFTEEN_Y_TO_TWENTY_Y
	                    Cell cell34 = row.getCell(34);
	                    if (cell34 == null) cell34 = row.createCell(34);
	                    if (mm[34] instanceof BigDecimal) {
	                        cell34.setCellValue(((BigDecimal) mm[34]).doubleValue());
	                    } else {
	                        cell34.setCellValue("");
	                    }

	                    // 35 - TWENTY_YEAR_ABOVE
	                    Cell cell35 = row.getCell(35);
	                    if (cell35 == null) cell35 = row.createCell(35);
	                    if (mm[35] instanceof BigDecimal) {
	                        cell35.setCellValue(((BigDecimal) mm[35]).doubleValue());
	                    } else {
	                        cell35.setCellValue("");
	                    }

	                    // 36 - NON_RATE_SENSITIVE
	                    Cell cell36 = row.getCell(36);
	                    if (cell36 == null) cell36 = row.createCell(36);
	                    if (mm[36] instanceof BigDecimal) {
	                        cell36.setCellValue(((BigDecimal) mm[36]).doubleValue());
	                    } else {
	                        cell36.setCellValue("");
	                    }

	                
	                }
	                
	                

	            
				workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
			} 
	         
	            if (!irrbbearList.isEmpty()) {
	            	 startRow = 1;
	                for (int i = 0; i < irrbbearList.size(); i++) {
	                    Object[] mm = irrbbearList.get(i);
	                    Row row = sheet4.getRow(startRow + i);
	                    if (row == null) row = sheet.createRow(startRow + i);
	                 // 0 - REPORT_DATE (Date)
	                    Cell cell0 = row.getCell(0);
	                    if (cell0 == null) cell0 = row.createCell(0);
	                    if (mm[0] instanceof Date) {
	                        cell0.setCellValue((Date) mm[0]);
	                        cell0.setCellStyle(dateStyle);
	                    } else {
	                        cell0.setCellValue("");
	                    }

	                    // 1 - BANK_NAME
	                    Cell cell1 = row.getCell(1);
	                    if (cell1 == null) cell1 = row.createCell(1);
	                    cell1.setCellValue(mm[1] == null ? "" : mm[1].toString());

	                    // 2 - GROUP_HEAD_OFFICE_SUBSIDIARY
	                    Cell cell2 = row.getCell(2);
	                    if (cell2 == null) cell2 = row.createCell(2);
	                    cell2.setCellValue(mm[2] == null ? "" : mm[2].toString());

	                    // 3 - BANK_SYMBOL
	                    Cell cell3 = row.getCell(3);
	                    if (cell3 == null) cell3 = row.createCell(3);
	                    cell3.setCellValue(mm[3] == null ? "" : mm[3].toString());

	                    // 4 - CONVENTIONAL_OR_ISLAMIC
	                    Cell cell4 = row.getCell(4);
	                    if (cell4 == null) cell4 = row.createCell(4);
	                    cell4.setCellValue(mm[4] == null ? "" : mm[4].toString());

	                    // 5 - LOCAL_OR_FOREIGN
	                    Cell cell5 = row.getCell(5);
	                    if (cell5 == null) cell5 = row.createCell(5);
	                    cell5.setCellValue(mm[5] == null ? "" : mm[5].toString());

	                    // 6 - CBUAE_TIERING
	                    Cell cell6 = row.getCell(6);
	                    if (cell6 == null) cell6 = row.createCell(6);
	                    cell6.setCellValue(mm[6] == null ? "" : mm[6].toString());

	                    // 7 - SUBSIDIARY
	                    Cell cell7 = row.getCell(7);
	                    if (cell7 == null) cell7 = row.createCell(7);
	                    cell7.setCellValue(mm[7] == null ? "" : mm[7].toString());

	                    // 8 - SCENARIO
	                    Cell cell8 = row.getCell(8);
	                    if (cell8 == null) cell8 = row.createCell(8);
	                    cell8.setCellValue(mm[8] == null ? "" : mm[8].toString());

	                    // 9 - GL_LEVEL_1
	                    Cell cell9 = row.getCell(9);
	                    if (cell9 == null) cell9 = row.createCell(9);
	                    cell9.setCellValue(mm[9] == null ? "" : mm[9].toString());

	                    // 10 - GL_LEVEL_2
	                    Cell cell10 = row.getCell(10);
	                    if (cell10 == null) cell10 = row.createCell(10);
	                    cell10.setCellValue(mm[10] == null ? "" : mm[10].toString());

	                    // 11 - GL_LEVEL_3
	                    Cell cell11 = row.getCell(11);
	                    if (cell11 == null) cell11 = row.createCell(11);
	                    cell11.setCellValue(mm[11] == null ? "" : mm[11].toString());

	                    // 12 - OPTION_TYPE
	                    Cell cell12 = row.getCell(12);
	                    if (cell12 == null) cell12 = row.createCell(12);
	                    cell12.setCellValue(mm[12] == null ? "" : mm[12].toString());

	                    // 13 - RATE_TYPE
	                    Cell cell13 = row.getCell(13);
	                    if (cell13 == null) cell13 = row.createCell(13);
	                    cell13.setCellValue(mm[13] == null ? "" : mm[13].toString());

	                    // 14 - REFERENCE_RATE
	                    Cell cell14 = row.getCell(14);
	                    if (cell14 == null) cell14 = row.createCell(14);
	                    cell14.setCellValue(mm[14] == null ? "" : mm[14].toString());

	                    // 15 - INSTRUMENT_CURRENCY
	                    Cell cell15 = row.getCell(15);
	                    if (cell15 == null) cell15 = row.createCell(15);
	                    cell15.setCellValue(mm[15] == null ? "" : mm[15].toString());

	                    // 16 - PASS_THROUGH_RATE
	                    Cell cell16 = row.getCell(16);
	                    if (cell16 == null) cell16 = row.createCell(16);
	                    if (mm[16] instanceof BigDecimal) {
	                        cell16.setCellValue(((BigDecimal) mm[16]).doubleValue());
	                    } else {
	                        cell16.setCellValue("");
	                    }

	                    // 17 - OVERNIGHT
	                    Cell cell17 = row.getCell(17);
	                    if (cell17 == null) cell17 = row.createCell(17);
	                    if (mm[17] instanceof BigDecimal) {
	                        cell17.setCellValue(((BigDecimal) mm[17]).doubleValue());
	                    } else {
	                        cell17.setCellValue("");
	                    }

	                    // 18 - ON_TO_TWO_W
	                    Cell cell18 = row.getCell(18);
	                    if (cell18 == null) cell18 = row.createCell(18);
	                    if (mm[18] instanceof BigDecimal) {
	                        cell18.setCellValue(((BigDecimal) mm[18]).doubleValue());
	                    } else {
	                        cell18.setCellValue("");
	                    }

	                    // 19 - TWO_W_TO_ONE_M
	                    Cell cell19 = row.getCell(19);
	                    if (cell19 == null) cell19 = row.createCell(19);
	                    if (mm[19] instanceof BigDecimal) {
	                        cell19.setCellValue(((BigDecimal) mm[19]).doubleValue());
	                    } else {
	                        cell19.setCellValue("");
	                    }

	                    // 20 - ONE_M_TO_TWO_M
	                    Cell cell20 = row.getCell(20);
	                    if (cell20 == null) cell20 = row.createCell(20);
	                    if (mm[20] instanceof BigDecimal) {
	                        cell20.setCellValue(((BigDecimal) mm[20]).doubleValue());
	                    } else {
	                        cell20.setCellValue("");
	                    }

	                    // 21 - TWO_M_TO_THREE_M
	                    Cell cell21 = row.getCell(21);
	                    if (cell21 == null) cell21 = row.createCell(21);
	                    if (mm[21] instanceof BigDecimal) {
	                        cell21.setCellValue(((BigDecimal) mm[21]).doubleValue());
	                    } else {
	                        cell21.setCellValue("");
	                    }

	                    // 22 - THREE_M_TO_FOUR_M
	                    Cell cell22 = row.getCell(22);
	                    if (cell22 == null) cell22 = row.createCell(22);
	                    if (mm[22] instanceof BigDecimal) {
	                        cell22.setCellValue(((BigDecimal) mm[22]).doubleValue());
	                    } else {
	                        cell22.setCellValue("");
	                    }

	                    // 23 - FOUR_M_TO_FIVE_M
	                    Cell cell23 = row.getCell(23);
	                    if (cell23 == null) cell23 = row.createCell(23);
	                    if (mm[23] instanceof BigDecimal) {
	                        cell23.setCellValue(((BigDecimal) mm[23]).doubleValue());
	                    } else {
	                        cell23.setCellValue("");
	                    }

	                    // 24 - FIVE_M_TO_SIX_M
	                    Cell cell24 = row.getCell(24);
	                    if (cell24 == null) cell24 = row.createCell(24);
	                    if (mm[24] instanceof BigDecimal) {
	                        cell24.setCellValue(((BigDecimal) mm[24]).doubleValue());
	                    } else {
	                        cell24.setCellValue("");
	                    }

	                    // 25 - SIX_M_TO_SEVEN_M
	                    Cell cell25 = row.getCell(25);
	                    if (cell25 == null) cell25 = row.createCell(25);
	                    if (mm[25] instanceof BigDecimal) {
	                        cell25.setCellValue(((BigDecimal) mm[25]).doubleValue());
	                    } else {
	                        cell25.setCellValue("");
	                    }

	                    // 26 - SEVEN_M_TO_EIGHT_M
	                    Cell cell26 = row.getCell(26);
	                    if (cell26 == null) cell26 = row.createCell(26);
	                    if (mm[26] instanceof BigDecimal) {
	                        cell26.setCellValue(((BigDecimal) mm[26]).doubleValue());
	                    } else {
	                        cell26.setCellValue("");
	                    }

	                    // 27 - EIGHT_M_TO_NINE_M
	                    Cell cell27 = row.getCell(27);
	                    if (cell27 == null) cell27 = row.createCell(27);
	                    if (mm[27] instanceof BigDecimal) {
	                        cell27.setCellValue(((BigDecimal) mm[27]).doubleValue());
	                    } else {
	                        cell27.setCellValue("");
	                    }

	                    // 28 - NINE_M_TO_TEN_M
	                    Cell cell28 = row.getCell(28);
	                    if (cell28 == null) cell28 = row.createCell(28);
	                    if (mm[28] instanceof BigDecimal) {
	                        cell28.setCellValue(((BigDecimal) mm[28]).doubleValue());
	                    } else {
	                        cell28.setCellValue("");
	                    }

	                    // 29 - TEN_M_TO_ELEVEN_M
	                    Cell cell29 = row.getCell(29);
	                    if (cell29 == null) cell29 = row.createCell(29);
	                    if (mm[29] instanceof BigDecimal) {
	                        cell29.setCellValue(((BigDecimal) mm[29]).doubleValue());
	                    } else {
	                        cell29.setCellValue("");
	                    }

	                    // 30 - ELEVEN_M_TO_TWELVE_M
	                    Cell cell30 = row.getCell(30);
	                    if (cell30 == null) cell30 = row.createCell(30);
	                    if (mm[30] instanceof BigDecimal) {
	                        cell30.setCellValue(((BigDecimal) mm[30]).doubleValue());
	                    } else {
	                        cell30.setCellValue("");
	                    }

	                }
	            }    
	            
	            if (reconSheet != null && reconList != null && !reconList.isEmpty()) {
	                logger.info("Service: Populating Reconciliation sheet (sheet 7) with {} records.", reconList.size());
	                int reconStartRow = 4; // Excel row 5 (0-based index 4)

	                for (int i = 0; i < reconList.size() && (reconStartRow + i) < 13; i++) {
	                    RT_IRRBB_RECON recon = reconList.get(i);
	                    Row row = reconSheet.getRow(reconStartRow + i);
	                    if (row == null) row = reconSheet.createRow(reconStartRow + i);

	                    // Left Table: EVE reconciliation
	                    // Col 1 (B) - FX**
	                    setCellString(row, 1, recon.getFxCode());

	                    // Col 2 (C) - Conversion rate to AED
	                    setCellNumeric(row, 2, recon.getConversionRateToAed(), numberStyle);

	                    // Col 3 (D) - O/S Ccy
	                    setCellNumeric(row, 3, recon.getOsCcy(), numberStyle);

	                    // Col 4 (E) - O/S AED
	                    setCellNumeric(row, 4, recon.getOsAed(), numberStyle);

	                    // Right Table: Repricing gap reconciliation over the next 12 months
	                    // Col 7 (H) - FX**
	                    String assetFx = recon.getAssetFxCode() != null && !recon.getAssetFxCode().trim().isEmpty()
	                            ? recon.getAssetFxCode() : recon.getFxCode();
	                    setCellString(row, 7, assetFx);

	                    // Col 8 (I) - Value
	                    BigDecimal assetVal = recon.getAssetValue() != null ? recon.getAssetValue() : recon.getConversionRateToAed();
	                    setCellNumeric(row, 8, assetVal, numberStyle);

	                    // Col 9 (J) - CF from Assets: CF in foreign Ccy
	                    setCellNumeric(row, 9, recon.getAssetCfForeignCcy(), numberStyle);

	                    // Col 10 (K) - CF from Assets: CF in AED
	                    setCellNumeric(row, 10, recon.getAssetCfAed(), numberStyle);

	                    // Col 11 (L) - CF from Liabilities: CF in foreign Ccy
	                    setCellNumeric(row, 11, recon.getLiabilityCfForeignCcy(), numberStyle);

	                    // Col 12 (M) - CF from Liabilities: CF in AED
	                    setCellNumeric(row, 12, recon.getLiabilityCfAed(), numberStyle);

	                    // Col 13 (N) - Earning At Risk (EAR): CF in foreign Ccy -> Formula cell (=Jn-Ln), NEVER overwrite!
	                    // Col 14 (O) - Earning At Risk (EAR): CF in AED -> Formula cell (=Kn-Mn), NEVER overwrite!
	                }

	                // Find summary values across reconList
	                BigDecimal assetsLiabilitiesPortfolioDate = null;
	                BigDecimal reportedBehaviouralRepricingGap = null;

	                for (RT_IRRBB_RECON r : reconList) {
	                    if (assetsLiabilitiesPortfolioDate == null && r.getAssetsLiabilitiesPortfolioDate() != null) {
	                        assetsLiabilitiesPortfolioDate = r.getAssetsLiabilitiesPortfolioDate();
	                    }
	                    if (reportedBehaviouralRepricingGap == null && r.getReportedBehaviouralRepricingGap() != null) {
	                        reportedBehaviouralRepricingGap = r.getReportedBehaviouralRepricingGap();
	                    }
	                    if (assetsLiabilitiesPortfolioDate != null && reportedBehaviouralRepricingGap != null) {
	                        break;
	                    }
	                }
	                if (assetsLiabilitiesPortfolioDate == null && !reconList.isEmpty()) {
	                    assetsLiabilitiesPortfolioDate = reconList.get(0).getAssetsLiabilitiesPortfolioDate();
	                }
	                if (reportedBehaviouralRepricingGap == null && !reconList.isEmpty()) {
	                    reportedBehaviouralRepricingGap = reconList.get(0).getReportedBehaviouralRepricingGap();
	                }

	                // Excel row 16 (0-based index 15): Assets and Liabilities as of portfolio date in published financials
	                // Col 2 (C) - Value
	                Row row16 = reconSheet.getRow(15);
	                if (row16 == null) row16 = reconSheet.createRow(15);
	                if (assetsLiabilitiesPortfolioDate != null) {
	                    setCellNumeric(row16, 2, assetsLiabilitiesPortfolioDate, numberStyle);
	                }

	                // Excel row 17 (0-based index 16):
	                // Col 2 (C) - Absolute difference -> Formula cell (=E14-C16), NEVER overwrite!
	                // Col 14 (O) - Reported behavioural REPRICING GAP as of portfolio date in the ALCO presentation -> Value
	                Row row17 = reconSheet.getRow(16);
	                if (row17 == null) row17 = reconSheet.createRow(16);
	                if (reportedBehaviouralRepricingGap != null) {
	                    setCellNumeric(row17, 14, reportedBehaviouralRepricingGap, numberStyle);
	                }

	                // Excel row 18 (0-based index 17):
	                // Col 2 (C) - % difference -> Formula cell (=IFERROR((E14/C16)-1,0)), NEVER overwrite!
	                // Col 14 (O) - Relative difference -> Formula cell (=IFERROR((O14/O17)-1,0)), NEVER overwrite!
	            }

	            workbook.setForceFormulaRecalculation(true);
	            try {
	                workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
	            } catch (Exception e) {
	                logger.warn("Could not evaluate all formulas via POI: {}", e.getMessage());
	            }

	            // Write the final workbook content to the in-memory stream.
	            workbook.write(out);

	            logger.info("Service: Excel data successfully written to memory buffer ({} bytes).", out.size());

	            return out.toByteArray();
	        }
	    }

	private void setCellNumeric(Row row, int colIndex, BigDecimal value, CellStyle defaultStyle) {
		if (row == null) return;
		Cell cell = row.getCell(colIndex);
		if (cell == null) {
			cell = row.createCell(colIndex);
			if (defaultStyle != null) {
				cell.setCellStyle(defaultStyle);
			}
		}
		// DO NOT overwrite formula cells
		if (cell.getCellTypeEnum() == CellType.FORMULA) {
			return;
		}
		if (value != null) {
			cell.setCellValue(value.doubleValue());
		}
	}

	private void setCellString(Row row, int colIndex, String value) {
		if (row == null || value == null || value.trim().isEmpty()) return;
		Cell cell = row.getCell(colIndex);
		if (cell == null) {
			cell = row.createCell(colIndex);
		}
		// DO NOT overwrite formula cells
		if (cell.getCellTypeEnum() == CellType.FORMULA) {
			return;
		}
		cell.setCellValue(value);
	}
}
