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

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileNotFoundException;



@Service
public class RT_Irrbb_Ear_Service {

	@Autowired
	private Environment env;
	
    private static final Logger logger = LoggerFactory.getLogger(RT_Irrbb_Ear_Service.class);


    @Autowired 
    RT_IRRBB_Data_EAR_Repository IRRBB_EAR_Repository;

	@Autowired
	private SessionFactory sessionFactory;

	public boolean updateirrbbear(RT_IRRBB_Data_EAR updatedData) {
	    System.out.println("Looking for record with SI_NO: " + updatedData.getSI_NO());

		/*
		 * RT_IRRBB_Data_EAR existing =
		 * IRRBB_EAR_Repository.getParticularDataBySI_NO(updatedData.getSI_NO());
		 */
	    //RT_IRRBB_Data_EAR existing = IRRBB_EAR_Repository.findById(updatedData.getSI_NO()).orElse(null);
	    RT_IRRBB_Data_EAR existing = null;

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
	    	existing.setPassThroughRate(updatedData.getPassThroughRate());
	    	existing.setOvernight(updatedData.getOvernight());
	    	existing.setOnToTwoW(updatedData.getOnToTwoW());
	    	existing.setTwoWToOneM(updatedData.getTwoWToOneM());
	    	existing.setOneMToTwoM(updatedData.getOneMToTwoM());
	    	existing.setTwoMToThreeM(updatedData.getTwoMToThreeM());
	    	existing.setThreeMToFourM(updatedData.getThreeMToFourM());
	    	existing.setFourMToFiveM(updatedData.getFourMToFiveM());
	    	existing.setFiveMToSixM(updatedData.getFiveMToSixM());
	    	existing.setSixMToSevenM(updatedData.getSixMToSevenM());
	    	existing.setSevenMToEightM(updatedData.getSevenMToEightM());
	    	existing.setEightMToNineM(updatedData.getEightMToNineM());
	    	existing.setNineMToTenM(updatedData.getNineMToTenM());
	    	existing.setTenMToElevenM(updatedData.getTenMToElevenM());
	    	existing.setElevenMToTwelveM(updatedData.getElevenMToTwelveM());

	  

	        IRRBB_EAR_Repository.save(existing);
	        return true;
	    } else {
	        System.out.println("No record found for SI_NO: " + updatedData.getSI_NO());
	        return false;
	    }
	}
	
	
	 public byte[] generateIrrbbearExcel(Date Report_date) throws Exception {
	        logger.info("Service: Starting IRRBB EAR Excel generation process in memory for report date {}.", Report_date);

	        List<Object[]> irrbbearList = IRRBB_EAR_Repository.getirrbbeardatalistdata1(Report_date);

	        if (irrbbearList.isEmpty()) {
	            logger.warn("Service: No data found for IRRBB DATA EAR report. Returning empty result.");
	            return new byte[0];
	        }

	        String templateDir = env.getProperty("output.exportpathtemp");  // Corrected property key
	        String templateFileName = "CBUAE_Irrbb_Data_EAR_Template.xlsx";
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

	            if (!irrbbearList.isEmpty()) {
	                for (int i = 0; i < irrbbearList.size(); i++) {
	                    Object[] mm = irrbbearList.get(i);
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

	            
	                workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
			} else {
				System.out.println("No Mm data found to generate the Excel file.");
			}

			// Write the final workbook content to the in-memory stream.
			workbook.write(out);

			logger.info("Service: Excel data successfully written to memory buffer ({} bytes).", out.size());

			return out.toByteArray();
		}
	}

	



	
}
