package com.bornfire.xbrl.services;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
import com.bornfire.xbrl.entities.RT_NostroAccBalData;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.io.FileNotFoundException;



@Service
public class RT_FxriskdataService {

	@Autowired
	private Environment env;
	
    private static final Logger logger = LoggerFactory.getLogger(RT_FxriskdataService.class);


	@Autowired
	private RT_FxRiskDataRepository friskdataRepo;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	AuditService auditservice;
	
	public boolean updateFxriskdata(RT_Fxriskdata updatedData) {
	    System.out.println("Looking for record with SI_NO: " + updatedData.getSI_NO());

	    RT_Fxriskdata existing = friskdataRepo.getParticularDataBySI_NO(updatedData.getSI_NO());
	    
	    RT_Fxriskdata dbUser = new RT_Fxriskdata();
		org.springframework.beans.BeanUtils.copyProperties(existing, dbUser);

	    if (existing != null) {
	        // Update fields
	        existing.setBank_date(updatedData.getBank_date());
	        existing.setBank_name(updatedData.getBank_name());
	        existing.setBank_symbol(updatedData.getBank_symbol());
	        existing.setConventional_islamic(updatedData.getConventional_islamic());
	        existing.setLocal_foreign(updatedData.getLocal_foreign());
	        existing.setCbuae_tiering(updatedData.getCbuae_tiering());
	        existing.setCurrency(updatedData.getCurrency());
	        existing.setFx_net_openposition(updatedData.getFx_net_openposition());
	        existing.setOff_balance_sheet_position(updatedData.getOff_balance_sheet_position());
	        existing.setOn_balance_sheet_position(updatedData.getOn_balance_sheet_position());
	        existing.setFx_net_openposition_foreign_currency(updatedData.getFx_net_openposition_foreign_currency());
	        existing.setInternal_long_limit(updatedData.getInternal_long_limit());
	        existing.setInternal_long_limit_trigger_status(updatedData.getInternal_long_limit_trigger_status());
	        existing.setInternal_short_limit(updatedData.getInternal_short_limit());
	        existing.setInternal_short_limit_trigger_status(updatedData.getInternal_short_limit_trigger_status());
	        existing.setBank_core_tier1_capital(updatedData.getBank_core_tier1_capital());
	        existing.setBank_core_tier1_capital_lc(updatedData.getBank_core_tier1_capital_lc());
	        existing.setPercent_of_group_capital(updatedData.getPercent_of_group_capital());
	        existing.setBank_core_tier1_capital_aed(updatedData.getBank_core_tier1_capital_aed());
	        existing.setReport_submit_date(updatedData.getReport_submit_date());
	        existing.setReport_from_date(updatedData.getReport_from_date());
	        existing.setReport_to_date(updatedData.getReport_to_date());
	        existing.setReport_date(updatedData.getReport_date());
	        existing.setEntity_flg(updatedData.getEntity_flg());
	        existing.setModify_flg(updatedData.getModify_flg());
	        existing.setDel_flg(updatedData.getDel_flg());

			List<String> ignoreFields = Arrays.asList("createUser", "modifyUser", "delFlg");

			Map<String, String> changes = new LinkedHashMap<>();

			for (Field field : RT_Fxriskdata.class.getDeclaredFields()) {
				field.setAccessible(true);
				try {
					Object oldValue = field.get(dbUser);
					Object newValue = field.get(existing);
					if ((oldValue == null || oldValue.toString().trim().isEmpty())
							&& (newValue == null || newValue.toString().trim().isEmpty())) {
						continue;
					}

					if (ignoreFields.contains(field.getName()) && newValue == null) {
						continue;
					}

					if (oldValue instanceof Date || newValue instanceof Date) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String oldDateStr = (oldValue != null) ? sdf.format(oldValue) : null;
						String newDateStr = (newValue != null) ? sdf.format(newValue) : null;

						if (Objects.equals(oldDateStr, newDateStr)) {
							continue;
						}
					} else {
						if (Objects.equals(oldValue, newValue)) {
							continue;
						}
					}

					if (newValue == null) {
						changes.put(field.getName(), "OldValue: " + oldValue + ", NewValue: null");
					} else {
						changes.put(field.getName(), "OldValue: " + oldValue + ", NewValue: " + newValue);
					}

					if (newValue != null) {
						field.set(dbUser, newValue);
					}

				} catch (IllegalAccessException e) {
					System.err.println("Access error for field: " + field.getName() + " - " + e.getMessage());
				}
			}
	        friskdataRepo.save(existing);
	        
	        System.out.println("changes : "+changes);

	        // Audit only if any field was changed
	        if (!changes.isEmpty()) {
	            auditservice.createBusinessAudit(
	                updatedData.getSI_NO(),           // Unique ID
	                "MODIFY",                             // Action
	                "Fx_Risk_Data_Edit_SCREEN",                  // Screen name
	                changes,                              // Changed fields map
	                "BCBUAE_FX_RISK_DATA"              // Table name
	            );
	        }
	        
	        return true;
	    } else {
	        System.out.println("No record found for SI_NO: " + updatedData.getSI_NO());
	        return false;
	    }
	}



	public byte[] generateFxRiskExcel(Date Report_date) throws Exception {
		logger.info("Service: Starting Fx Risk Excel generation process in memory.");

	    List<Object[]> fxDataList = friskdataRepo.getfxriskdatalistdata1(Report_date);

	    if (fxDataList.isEmpty()) {
	        logger.warn("Service: No data found for Fx Risk report. Returning empty result.");
	        return new byte[0];
	    }

	    String templateDir = env.getProperty("ou-tput.exportpathtemp");
	    String templateFileName = "CBUAE_FX_Risk_Data_Template.xlsx";
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

	        Sheet sheet = workbook.getSheetAt(2);
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

			int startRow = 2; // assuming data starts from row 3 (index 2)
			BigDecimal Bank_Core_Tier_1_Capital =BigDecimal.ZERO;


			if (!fxDataList.isEmpty()) {
				
				
				
				for (int i = 0; i < fxDataList.size(); i++) {
					
					for (int j = 2; j <= 53; j++) {
						
						
						
						 Object[] fxdata =fxDataList.get(i);
						Row row = sheet.getRow(j);
						Cell cell6 = row.getCell(6);
						//System.out.println(fxdata[6]);
						if(cell6.getStringCellValue().equals(fxdata[6])) {
							
							// 0 - Date column
							  Cell cell0 = row.getCell(0);
			                    if (cell0 == null) cell0 = row.createCell(0);
			                    if (fxdata[0] instanceof Date) {
			                        cell0.setCellValue((Date) fxdata[0]);
			                        cell0.setCellStyle(dateStyle);
			                    } else {
			                        cell0.setCellValue("");
			                    }

							
							
							// 1 - String
							Cell cell1 = row.getCell(1);
							if (cell1 == null)
								cell1 = row.createCell(1);
							cell1.setCellValue(fxdata[1] == null ? "" : fxdata[1].toString());
							
							// 2 - String
							Cell cell2 = row.getCell(2);
							if (cell2 == null)
								cell2 = row.createCell(2);
							cell2.setCellValue(fxdata[2] == null ? "" : fxdata[2].toString());

							// 3 - String
							Cell cell3 = row.getCell(3);
							if (cell3 == null)
								cell3 = row.createCell(3);
							cell3.setCellValue(fxdata[3] == null ? "" : fxdata[3].toString());

							// 4 - String
							Cell cell4 = row.getCell(4);
							if (cell4 == null)
								cell4 = row.createCell(4);
							cell4.setCellValue(fxdata[4] == null ? "" : fxdata[4].toString());

							// 5 - String
							Cell cell5 = row.getCell(5);
							if (cell5 == null)
								cell5 = row.createCell(5);
							cell5.setCellValue(fxdata[5] == null ? "" : fxdata[5].toString());
							
							// 7 - BigDecimal
							Cell cell7 = row.getCell(7);
							if (cell7 == null)
								cell7 = row.createCell(7);
							cell7.setCellValue(fxdata[7] instanceof BigDecimal ? ((BigDecimal) fxdata[7]).doubleValue() : 0);

							// 8 - BigDecimal
							Cell cell8 = row.getCell(8);
							if (cell8 == null)
								cell8 = row.createCell(8);
							cell8.setCellValue(fxdata[8] instanceof BigDecimal ? ((BigDecimal) fxdata[8]).doubleValue() : 0);

							// 9 - BigDecimal
							Cell cell9 = row.getCell(9);
							if (cell9 == null)
								cell9 = row.createCell(9);
							cell9.setCellValue(fxdata[9] instanceof BigDecimal ? ((BigDecimal) fxdata[9]).doubleValue() : 0);

							// 10 - BigDecimal
							Cell cell10 = row.getCell(10);
							if (cell10 == null)
								cell10 = row.createCell(10);
							cell10.setCellValue(fxdata[10] instanceof BigDecimal ? ((BigDecimal) fxdata[10]).doubleValue() : 0);

							// 11 - BigDecimal
							Cell cell11 = row.getCell(11);
							if (cell11 == null)
								cell11 = row.createCell(11);
							cell11.setCellValue(fxdata[11] instanceof BigDecimal ? ((BigDecimal) fxdata[11]).doubleValue() : 0);

							// 12 - String
							Cell cell12 = row.getCell(12);
							if (cell12 == null)
								cell12 = row.createCell(12);
							cell12.setCellValue(fxdata[12] == null ? "" : fxdata[12].toString());

							// 13 - BigDecimal
							Cell cell13 = row.getCell(13);
							if (cell13 == null)
								cell13 = row.createCell(13);
							cell13.setCellValue(fxdata[13] instanceof BigDecimal ? ((BigDecimal) fxdata[13]).doubleValue() : 0);

							// 14 - String
							Cell cell14 = row.getCell(14);
							if (cell14 == null)
								cell14 = row.createCell(14);
							cell14.setCellValue(fxdata[14] == null ? "" : fxdata[14].toString());

							// 15 - BigDecimal
							/*Cell cell15 = row.getCell(15);
							if (cell15 == null)
								cell15 = row.createCell(15);
							cell15.setCellValue(fxdata[15] instanceof BigDecimal ? ((BigDecimal) fxdata[15]).doubleValue() : 0);*/

							// 16 - BigDecimal
							/*Cell cell16 = row.getCell(16);
							if (cell16 == null)
								cell16 = row.createCell(16);
							cell16.setCellValue(fxdata[16] instanceof BigDecimal ? ((BigDecimal) fxdata[16]).doubleValue() : 0);*/

							if (fxdata[16] != null) {
								Bank_Core_Tier_1_Capital = new BigDecimal(fxdata[16].toString());
							}
							// 17 - BigDecimal
							Cell cell17 = row.getCell(17);
							if (cell17 == null)
								cell17 = row.createCell(17);
							cell17.setCellValue(fxdata[17] instanceof BigDecimal ? ((BigDecimal) fxdata[17]).doubleValue() : 0);

							System.out.println(cell6.getStringCellValue()+"_"+fxdata[1]);
							
							
						}
	
						
						
					}
					
					Row row = sheet.getRow(1);
					Cell cell6 = row.getCell(20);
					cell6.setCellValue(Bank_Core_Tier_1_Capital instanceof BigDecimal ? ((BigDecimal) Bank_Core_Tier_1_Capital).doubleValue() : 0);
					
				
				}
				
				
				
				
				// Auto-size all columns
				for (int i = 0; i <= 18; i++) {
				    sheet.autoSizeColumn(i);
				}
				workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
			} else {
				System.out.println("No Fx Risk data found to generate the Excel file.");
			}

			// Write the final workbook content to the in-memory stream.
			workbook.write(out);

			String finalPath = env.getProperty("output.exportpathfinal"); // e.g. finaltemp path
            File outputFile = new File(finalPath + "CBUAE_FX_Risk_Data_Template.xlsx");
            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                fos.write(out.toByteArray());
                logger.info("Service: Excel also saved to file: {}", outputFile.getAbsolutePath());
            }

            logger.info("Service: FX RISK DATA Excel data successfully written to memory buffer ({} bytes).", out.size());
            return out.toByteArray();
		}
	}
}
