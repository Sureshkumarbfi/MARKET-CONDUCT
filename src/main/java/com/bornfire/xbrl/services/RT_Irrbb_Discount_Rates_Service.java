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
import com.bornfire.xbrl.entities.RT_IRRBB_Data_Discount_Rates;
import com.bornfire.xbrl.entities.RT_IRRBB_Data_Discount_Rates_Repository;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileNotFoundException;



@Service
public class RT_Irrbb_Discount_Rates_Service {

	@Autowired
	private Environment env;
	
    private static final Logger logger = LoggerFactory.getLogger(RT_Irrbb_Discount_Rates_Service.class);


    @Autowired 
    RT_IRRBB_Data_Discount_Rates_Repository IRRBB_Data_Template_DiscountRate_repo;

	@Autowired
	private SessionFactory sessionFactory;

	public boolean updateirrbbdiscount(RT_IRRBB_Data_Discount_Rates updatedData) {
	    System.out.println("Looking for record with SI_NO: " + updatedData.getSI_NO());

	    RT_IRRBB_Data_Discount_Rates existing = IRRBB_Data_Template_DiscountRate_repo.getParticularDataBySI_NO(updatedData.getSI_NO());

	    if (existing != null) {
	        // Update fields
	    	existing.setDerivedTenor(updatedData.getDerivedTenor());
	    	existing.setOvernight(updatedData.getOvernight());
	    	existing.setOneWeek(updatedData.getOneWeek());
	    	existing.setOneMonth(updatedData.getOneMonth());
	    	existing.setTwoMonth(updatedData.getTwoMonth());
	    	existing.setThreeMonth(updatedData.getThreeMonth());
	    	existing.setSixMonth(updatedData.getSixMonth());
	    	existing.setNineMonth(updatedData.getNineMonth());
	    	existing.setOneYear(updatedData.getOneYear());
	    	existing.setOnePointFiveYear(updatedData.getOnePointFiveYear());
	    	existing.setTwoYear(updatedData.getTwoYear());
	    	existing.setThreeYear(updatedData.getThreeYear());
	    	existing.setFourYear(updatedData.getFourYear());
	    	existing.setFiveYear(updatedData.getFiveYear());
	    	existing.setSixYear(updatedData.getSixYear());
	    	existing.setSevenYear(updatedData.getSevenYear());
	    	existing.setEightYear(updatedData.getEightYear());
	    	existing.setNineYear(updatedData.getNineYear());
	    	existing.setTenYear(updatedData.getTenYear());
	    	existing.setTwelveYear(updatedData.getTwelveYear());
	    	existing.setFifteenYear(updatedData.getFifteenYear());
	    	existing.setTwentyYear(updatedData.getTwentyYear());
	    	existing.setThirtyYear(updatedData.getThirtyYear());
	

	        IRRBB_Data_Template_DiscountRate_repo.save(existing);
	        return true;
	    } else {
	        System.out.println("No record found for SI_NO: " + updatedData.getSI_NO());
	        return false;
	    }
	}
	
	
	
	public byte[] generateIrrbbdiscountrateExcel(Date Report_date) throws Exception {
        logger.info("Service: Starting IRRBB Discount Rate Excel generation process in memory for report date {}.", Report_date);

        List<Object[]> irrbbdiscountList = IRRBB_Data_Template_DiscountRate_repo.getirrbbdiscountratesdatalistdata1(Report_date);

        if (irrbbdiscountList.isEmpty()) {
            logger.warn("Service: No data found for IRRBB Discount Rate  report. Returning empty result.");
            return new byte[0];
        }

        String templateDir = env.getProperty("output.exportpathtemp");  // Corrected property key
        String templateFileName = "CBUAE_Irrbb_Data_Discount_Rate_Template.xls";
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

            if (!irrbbdiscountList.isEmpty()) {
                for (int i = 0; i < irrbbdiscountList.size(); i++) {
                    Object[] mm = irrbbdiscountList.get(i);
                    Row row = sheet.getRow(startRow + i);
                    if (row == null) row = sheet.createRow(startRow + i);

                 // 0 - DERIVED_TENOR
                    Cell cell0 = row.getCell(0);
                    if (cell0 == null) cell0 = row.createCell(0);
                    cell0.setCellValue(mm[0] == null ? "" : mm[0].toString());

                    // 1 - OVERNIGHT
                    Cell cell1 = row.getCell(1);
                    if (cell1 == null) cell1 = row.createCell(1);
                    if (mm[1] instanceof BigDecimal) {
                        cell1.setCellValue(((BigDecimal) mm[1]).doubleValue());
                    } else {
                        cell1.setCellValue("");
                    }

                    // 2 - ONE_WEEK
                    Cell cell2 = row.getCell(2);
                    if (cell2 == null) cell2 = row.createCell(2);
                    if (mm[2] instanceof BigDecimal) {
                        cell2.setCellValue(((BigDecimal) mm[2]).doubleValue());
                    } else {
                        cell2.setCellValue("");
                    }

                    // 3 - ONE_MONTH
                    Cell cell3 = row.getCell(3);
                    if (cell3 == null) cell3 = row.createCell(3);
                    if (mm[3] instanceof BigDecimal) {
                        cell3.setCellValue(((BigDecimal) mm[3]).doubleValue());
                    } else {
                        cell3.setCellValue("");
                    }

                    // 4 - TWO_MONTH
                    Cell cell4 = row.getCell(4);
                    if (cell4 == null) cell4 = row.createCell(4);
                    if (mm[4] instanceof BigDecimal) {
                        cell4.setCellValue(((BigDecimal) mm[4]).doubleValue());
                    } else {
                        cell4.setCellValue("");
                    }

                    // 5 - THREE_MONTH
                    Cell cell5 = row.getCell(5);
                    if (cell5 == null) cell5 = row.createCell(5);
                    if (mm[5] instanceof BigDecimal) {
                        cell5.setCellValue(((BigDecimal) mm[5]).doubleValue());
                    } else {
                        cell5.setCellValue("");
                    }

                    // 6 - SIX_MONTH
                    Cell cell6 = row.getCell(6);
                    if (cell6 == null) cell6 = row.createCell(6);
                    if (mm[6] instanceof BigDecimal) {
                        cell6.setCellValue(((BigDecimal) mm[6]).doubleValue());
                    } else {
                        cell6.setCellValue("");
                    }

                    // 7 - NINE_MONTH
                    Cell cell7 = row.getCell(7);
                    if (cell7 == null) cell7 = row.createCell(7);
                    if (mm[7] instanceof BigDecimal) {
                        cell7.setCellValue(((BigDecimal) mm[7]).doubleValue());
                    } else {
                        cell7.setCellValue("");
                    }

                    // 8 - ONE_YEAR
                    Cell cell8 = row.getCell(8);
                    if (cell8 == null) cell8 = row.createCell(8);
                    if (mm[8] instanceof BigDecimal) {
                        cell8.setCellValue(((BigDecimal) mm[8]).doubleValue());
                    } else {
                        cell8.setCellValue("");
                    }

                    // 9 - ONE_POINT_FIVE_YEAR
                    Cell cell9 = row.getCell(9);
                    if (cell9 == null) cell9 = row.createCell(9);
                    if (mm[9] instanceof BigDecimal) {
                        cell9.setCellValue(((BigDecimal) mm[9]).doubleValue());
                    } else {
                        cell9.setCellValue("");
                    }

                    // 10 - TWO_YEAR
                    Cell cell10 = row.getCell(10);
                    if (cell10 == null) cell10 = row.createCell(10);
                    if (mm[10] instanceof BigDecimal) {
                        cell10.setCellValue(((BigDecimal) mm[10]).doubleValue());
                    } else {
                        cell10.setCellValue("");
                    }

                    // 11 - THREE_YEAR
                    Cell cell11 = row.getCell(11);
                    if (cell11 == null) cell11 = row.createCell(11);
                    if (mm[11] instanceof BigDecimal) {
                        cell11.setCellValue(((BigDecimal) mm[11]).doubleValue());
                    } else {
                        cell11.setCellValue("");
                    }

                    // 12 - FOUR_YEAR
                    Cell cell12 = row.getCell(12);
                    if (cell12 == null) cell12 = row.createCell(12);
                    if (mm[12] instanceof BigDecimal) {
                        cell12.setCellValue(((BigDecimal) mm[12]).doubleValue());
                    } else {
                        cell12.setCellValue("");
                    }

                    // 13 - FIVE_YEAR
                    Cell cell13 = row.getCell(13);
                    if (cell13 == null) cell13 = row.createCell(13);
                    if (mm[13] instanceof BigDecimal) {
                        cell13.setCellValue(((BigDecimal) mm[13]).doubleValue());
                    } else {
                        cell13.setCellValue("");
                    }

                    // 14 - SIX_YEAR
                    Cell cell14 = row.getCell(14);
                    if (cell14 == null) cell14 = row.createCell(14);
                    if (mm[14] instanceof BigDecimal) {
                        cell14.setCellValue(((BigDecimal) mm[14]).doubleValue());
                    } else {
                        cell14.setCellValue("");
                    }

                    // 15 - SEVEN_YEAR
                    Cell cell15 = row.getCell(15);
                    if (cell15 == null) cell15 = row.createCell(15);
                    if (mm[15] instanceof BigDecimal) {
                        cell15.setCellValue(((BigDecimal) mm[15]).doubleValue());
                    } else {
                        cell15.setCellValue("");
                    }

                    // 16 - EIGHT_YEAR
                    Cell cell16 = row.getCell(16);
                    if (cell16 == null) cell16 = row.createCell(16);
                    if (mm[16] instanceof BigDecimal) {
                        cell16.setCellValue(((BigDecimal) mm[16]).doubleValue());
                    } else {
                        cell16.setCellValue("");
                    }

                    // 17 - NINE_YEAR
                    Cell cell17 = row.getCell(17);
                    if (cell17 == null) cell17 = row.createCell(17);
                    if (mm[17] instanceof BigDecimal) {
                        cell17.setCellValue(((BigDecimal) mm[17]).doubleValue());
                    } else {
                        cell17.setCellValue("");
                    }

                    // 18 - TEN_YEAR
                    Cell cell18 = row.getCell(18);
                    if (cell18 == null) cell18 = row.createCell(18);
                    if (mm[18] instanceof BigDecimal) {
                        cell18.setCellValue(((BigDecimal) mm[18]).doubleValue());
                    } else {
                        cell18.setCellValue("");
                    }

                    // 19 - TWELVE_YEAR
                    Cell cell19 = row.getCell(19);
                    if (cell19 == null) cell19 = row.createCell(19);
                    if (mm[19] instanceof BigDecimal) {
                        cell19.setCellValue(((BigDecimal) mm[19]).doubleValue());
                    } else {
                        cell19.setCellValue("");
                    }

                    // 20 - FIFTEEN_YEAR
                    Cell cell20 = row.getCell(20);
                    if (cell20 == null) cell20 = row.createCell(20);
                    if (mm[20] instanceof BigDecimal) {
                        cell20.setCellValue(((BigDecimal) mm[20]).doubleValue());
                    } else {
                        cell20.setCellValue("");
                    }

                    // 21 - TWENTY_YEAR
                    Cell cell21 = row.getCell(21);
                    if (cell21 == null) cell21 = row.createCell(21);
                    if (mm[21] instanceof BigDecimal) {
                        cell21.setCellValue(((BigDecimal) mm[21]).doubleValue());
                    } else {
                        cell21.setCellValue("");
                    }

                    // 22 - THIRTY_YEAR
                    Cell cell22 = row.getCell(22);
                    if (cell22 == null) cell22 = row.createCell(22);
                    if (mm[22] instanceof BigDecimal) {
                        cell22.setCellValue(((BigDecimal) mm[22]).doubleValue());
                    } else {
                        cell22.setCellValue("");
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







	
	



	
}
