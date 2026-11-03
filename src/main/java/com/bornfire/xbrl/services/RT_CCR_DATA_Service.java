package com.bornfire.xbrl.services;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.bornfire.xbrl.entities.RT_CCR_DATA_TEMPLATE;
import com.bornfire.xbrl.entities.RT_CCR_DATA_TEMPLATE_REPOSITORY;
import com.bornfire.xbrl.entities.RT_RepoDataTemplate;

@Service
public class RT_CCR_DATA_Service {

	private static final Logger logger = LoggerFactory.getLogger(RT_CCR_DATA_Service.class);

	@Autowired
	private Environment env;

	@Autowired
	private RT_CCR_DATA_TEMPLATE_REPOSITORY ccrDataRepo;
	
	@Autowired
	AuditService auditService;
	
	/*
	 * public boolean updateCCRData(RT_CCR_DATA_TEMPLATE updatedEntity) {
	 * Optional<RT_CCR_DATA_TEMPLATE> existingOpt =
	 * ccrDataRepo.findById(updatedEntity.getSiNo());
	 */
	    
	    public boolean updateCCRData(RT_CCR_DATA_TEMPLATE updatedEntity) {
	        System.out.println("updateCCRData: Received SI_NO = " + updatedEntity.getSiNo());
	        Optional<RT_CCR_DATA_TEMPLATE> existingOpt = ccrDataRepo.findById(updatedEntity.getSiNo());


	    if (existingOpt.isPresent()) {
	    	RT_CCR_DATA_TEMPLATE existing = existingOpt.get();

	    	RT_CCR_DATA_TEMPLATE dbUser = new RT_CCR_DATA_TEMPLATE();
			org.springframework.beans.BeanUtils.copyProperties(existing, dbUser);
			

	        // Basic Information
	        existing.setTransactionDate(updatedEntity.getTransactionDate());
	        existing.setBankName(updatedEntity.getBankName());
	        existing.setHeadOfficeSubsidiary(updatedEntity.getHeadOfficeSubsidiary());
	        existing.setSubsidiary(updatedEntity.getSubsidiary());
	        /*existing.setBankSymbol(updatedEntity.getBankSymbol());
	        existing.setConventionalIslamic(updatedEntity.getConventionalIslamic());
	        existing.setCbuaeTiering(updatedEntity.getCbuaeTiering());
	        existing.setLocalForeign(updatedEntity.getLocalForeign());
*/
	        
	        // Counterparty Info
	        existing.setCounterpartyName(updatedEntity.getCounterpartyName());
	        existing.setInternalCounterpartyRef(updatedEntity.getInternalCounterpartyRef());
	        existing.setInternalCounterpartyRating(updatedEntity.getInternalCounterpartyRating());
	        
	        //existing.setFinalRatingCbuae(updatedEntity.getFinalRatingCbuae());
	        existing.setCountryOfRisk(updatedEntity.getCountryOfRisk());
	        //existing.setCbuaeGeographicalZone(updatedEntity.getCbuaeGeographicalZone());
	        existing.setCounterpartyType(updatedEntity.getCounterpartyType());
	        existing.setSector(updatedEntity.getSector());

	        // Exposure Info
	        existing.setPfe95Aed(updatedEntity.getPfe95Aed());
	        existing.setExpectedPositiveExposureAed(updatedEntity.getExpectedPositiveExposureAed());
	        existing.setExpectedNegativeExposureAed(updatedEntity.getExpectedNegativeExposureAed());

	        // Collateral Info
	        existing.setCsa(updatedEntity.getCsa());
	        existing.setCollateralType(updatedEntity.getCollateralType());
	        existing.setThreshold(updatedEntity.getThreshold());
	        existing.setMinimumTransferAmountAed(updatedEntity.getMinimumTransferAmountAed());
	        existing.setIndependentAmountAed(updatedEntity.getIndependentAmountAed());
	        existing.setMarginCallFrequency(updatedEntity.getMarginCallFrequency());
	        existing.setNetCollateralOutstandingAed(updatedEntity.getNetCollateralOutstandingAed());

	        // Adjustments Info
	        existing.setCvaAed(updatedEntity.getCvaAed());
	        existing.setDvaAed(updatedEntity.getDvaAed());
	        //existing.setBilateralCvaAed(updatedEntity.getBilateralCvaAed());
	        existing.setFvaAed(updatedEntity.getFvaAed());
	        //existing.setIncrementalPfe(updatedEntity.getIncrementalPfe());

	        // Update time

	        existing.setModifyTime(new Date());



            List<String> ignoreFields = Arrays.asList("createUser", "modifyUser", "delFlg","modifyTime");

			Map<String, String> changes = new LinkedHashMap<>();

			for (Field field : RT_CCR_DATA_TEMPLATE.class.getDeclaredFields()) {
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
			
			
	        ccrDataRepo.save(existing);

			 System.out.println("changes : "+changes);

		        // Audit only if any field was changed
		        if (!changes.isEmpty()) {
		        	auditService.createBusinessAudit(
		        			updatedEntity.getSiNo(),           // Unique ID
		                "MODIFY",                             // Action
		                "CCR_DATA_TEMPLATES_EDIT_SCREEN",                  // Screen name
		                changes,                              // Changed fields map
		                "BCBUAE_CCR_DATA_TABLE"              // Table name
		            );
		        }
		        
		        
	        return true;
	    } else {
	        return false;
	    }
	}


	public byte[] generateCCRDataExcel(Date Report_date) throws Exception {
		logger.info("Service: Starting CCR_DATA Excel generation process in memory.");

		List<RT_CCR_DATA_TEMPLATE> dataList = ccrDataRepo.getlist(Report_date);

		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for CCR_DATA report. Returning empty result.");
			return new byte[0];
		}

		String templateDir = env.getProperty("output.exportpathtemp");
		String templateFileName = "CBUAE_CCR_Data_Template.xlsx";
		Path templatePath = Paths.get(templateDir, templateFileName);

		logger.info("Service: Attempting to load template from path: {}", templatePath.toAbsolutePath());

		if (!Files.exists(templatePath)) {
			throw new FileNotFoundException("Template file not found at: " + templatePath.toAbsolutePath());
		}
		if (!Files.isReadable(templatePath)) {
			throw new SecurityException(
					"Template file exists but is not readable (check permissions): " + templatePath.toAbsolutePath());
		}

		try (InputStream templateInputStream = Files.newInputStream(templatePath);
				Workbook workbook = WorkbookFactory.create(templateInputStream);
				ByteArrayOutputStream out = new ByteArrayOutputStream()) {

			Sheet sheet = workbook.getSheetAt(2);

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

			CellStyle numberStyle = workbook.createCellStyle();
			numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("#,##0.00"));
			numberStyle.setBorderBottom(BorderStyle.THIN);
			numberStyle.setBorderTop(BorderStyle.THIN);
			numberStyle.setBorderLeft(BorderStyle.THIN);
			numberStyle.setBorderRight(BorderStyle.THIN);

			int startRow = 4;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {
					RT_CCR_DATA_TEMPLATE record = dataList.get(i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}

					// Column 0: Exposure Date
					Cell cell0 = row.createCell(0);
					if (record.getTransactionDate() != null) {
						cell0.setCellValue(record.getTransactionDate());
						cell0.setCellStyle(dateStyle);
					} else {
						cell0.setCellValue("");
						cell0.setCellStyle(textStyle);
					}

					// Column 1: Bank Name
					Cell cell1 = row.createCell(1);
					cell1.setCellValue(record.getBankName() != null ? record.getBankName() : "");
					cell1.setCellStyle(textStyle);

					// ... The rest of your cell population logic is correct and remains unchanged
					// ...

					// Column 2: Head_Office_Subsidiary
					Cell cell2 = row.createCell(2);
					cell2.setCellValue(
							record.getHeadOfficeSubsidiary() != null ? record.getHeadOfficeSubsidiary() : "");
					cell2.setCellStyle(textStyle);

					// Column 3: Subsidiary
					Cell cell3 = row.createCell(3);
					cell3.setCellValue(record.getSubsidiary() != null ? record.getSubsidiary() : "");
					cell3.setCellStyle(textStyle);

					// Column 4: Bank Symbol
					/*Cell cell4 = row.createCell(4);
					cell4.setCellValue(record.getBankSymbol() != null ? record.getBankSymbol() : "");
					cell4.setCellStyle(textStyle);

					// Column 5: Conventional/Islamic
					Cell cell5 = row.createCell(5);
					cell5.setCellValue(record.getConventionalIslamic() != null ? record.getConventionalIslamic() : "");
					cell5.setCellStyle(textStyle);

					// Column 6: CBUAE Tiering
					Cell cell6 = row.createCell(6);
					cell6.setCellValue(record.getLocalForeign() != null ? record.getLocalForeign() : "");
					cell6.setCellStyle(textStyle);

					// Column 7: CBUAE Tiering (Secondary)
					Cell cell7 = row.createCell(7);
					cell7.setCellValue(
							record.getCbuaeTiering() != null ? record.getCbuaeTiering() : "");
					cell7.setCellStyle(textStyle);
*/
					// Column 8: Cpty Name
					Cell cell8 = row.createCell(8);
					cell8.setCellValue(record.getCounterpartyName() != null ? record.getCounterpartyName() : "");
					cell8.setCellStyle(textStyle);

					// Column 9: Internal Counterparty Reference
					Cell cell9 = row.createCell(9);
					cell9.setCellValue(
							record.getInternalCounterpartyRef() != null ? record.getInternalCounterpartyRef() : "");
					cell9.setCellStyle(textStyle);

					// Column 10: Internal Counterparty Rating
					Cell cell10 = row.createCell(10);
					cell10.setCellValue(
							record.getInternalCounterpartyRating() != null ? record.getInternalCounterpartyRating()
									: "");
					cell10.setCellStyle(textStyle);
/*
					// Column 11: Final Rating CBUAE
					Cell cell11 = row.createCell(11);
					cell11.setCellValue(record.getFinalRatingCbuae() != null ? record.getFinalRatingCbuae() : "");
					cell11.setCellStyle(textStyle);
*/
					// Column 12: Country of Risk
					Cell cell12 = row.createCell(12);
					cell12.setCellValue(record.getCountryOfRisk() != null ? record.getCountryOfRisk() : "");
					cell12.setCellStyle(textStyle);
/*
					// Column 13: CBUAE Geographical zone
					Cell cell13 = row.createCell(13);
					cell13.setCellValue(
							record.getCbuaeGeographicalZone() != null ? record.getCbuaeGeographicalZone() : "");
					cell13.setCellStyle(textStyle);
*/
					// Column 14: Counterparty Type
					Cell cell14 = row.createCell(14);
					cell14.setCellValue(record.getCounterpartyType() != null ? record.getCounterpartyType() : "");
					cell14.setCellStyle(textStyle);

					// Column 15: Sector
					Cell cell15 = row.createCell(15);
					cell15.setCellValue(record.getSector() != null ? record.getSector() : "");
					cell15.setCellStyle(textStyle);

					// Column 16: PFE@95% (AED equivalent)
					Cell cell16 = row.createCell(16);
					cell16.setCellValue(record.getPfe95Aed() != null ? record.getPfe95Aed().doubleValue() : 0.0);
					cell16.setCellStyle(numberStyle);

					// Column 17: Expected Positive Exposure (AED equivalent)
					Cell cell17 = row.createCell(17);
					cell17.setCellValue(record.getExpectedPositiveExposureAed() != null
							? record.getExpectedPositiveExposureAed().doubleValue()
							: 0.0);
					cell17.setCellStyle(numberStyle);

					// Column 18: Expected Negative Exposure (AED equivalent)
					Cell cell18 = row.createCell(18);
					cell18.setCellValue(record.getExpectedNegativeExposureAed() != null
							? record.getExpectedNegativeExposureAed().doubleValue()
							: 0.0);
					cell18.setCellStyle(numberStyle);

					// Column 19: CSA
					Cell cell19 = row.createCell(19);
					cell19.setCellValue(record.getCsa() != null ? record.getCsa() : "");
					cell19.setCellStyle(textStyle);

					// Column 20: Collateral Type
					Cell cell20 = row.createCell(20);
					cell20.setCellValue(record.getCollateralType() != null ? record.getCollateralType() : "");
					cell20.setCellStyle(textStyle);

					// Column 21: Threshold
					Cell cell21 = row.createCell(21);
					cell21.setCellValue(record.getThreshold() != null ? record.getThreshold().doubleValue() : 0.0);
					cell21.setCellStyle(numberStyle);

					// Column 22: Minimum Transfer Amount (MTA)
					Cell cell22 = row.createCell(22);
					cell22.setCellValue(record.getMinimumTransferAmountAed() != null
							? record.getMinimumTransferAmountAed().doubleValue()
							: 0.0);
					cell22.setCellStyle(numberStyle);

					// Column 23: Independent Amount (IA)
					Cell cell23 = row.createCell(23);
					cell23.setCellValue(
							record.getIndependentAmountAed() != null ? record.getIndependentAmountAed().doubleValue()
									: 0.0);
					cell23.setCellStyle(numberStyle);

					// Column 24: Margin Call Frequency
					Cell cell24 = row.createCell(24);
					cell24.setCellValue(record.getMarginCallFrequency() != null ? record.getMarginCallFrequency() : "");
					cell24.setCellStyle(textStyle);

					// Column 25: Net Collateral outstanding (AED equivalent)
					Cell cell25 = row.createCell(25);
					cell25.setCellValue(record.getNetCollateralOutstandingAed() != null
							? record.getNetCollateralOutstandingAed().doubleValue()
							: 0.0);
					cell25.setCellStyle(numberStyle);

					// Column 26: CVA (AED equivalent)
					Cell cell26 = row.createCell(26);
					cell26.setCellValue(record.getCvaAed() != null ? record.getCvaAed().doubleValue() : 0.0);
					cell26.setCellStyle(numberStyle);

					// Column 27: DVA (AED equivalent)
					Cell cell27 = row.createCell(27);
					cell27.setCellValue(record.getDvaAed() != null ? record.getDvaAed().doubleValue() : 0.0);
					cell27.setCellStyle(numberStyle);
/*
					// Column 28: Bilateral CVA (AED equivalent)
					Cell cell28 = row.createCell(28);
					cell28.setCellValue(
							record.getBilateralCvaAed() != null ? record.getBilateralCvaAed().doubleValue() : 0.0);
					cell28.setCellStyle(numberStyle);
*/
					// Column 29: FVA (AED equivalent)
					Cell cell29 = row.createCell(29);
					cell29.setCellValue(record.getFvaAed() != null ? record.getFvaAed().doubleValue() : 0.0);
					cell29.setCellStyle(numberStyle);
/*
					// Column 30: Incremental PFE
					Cell cell30 = row.createCell(30);
					cell30.setCellValue(
							record.getIncrementalPfe() != null ? record.getIncrementalPfe().doubleValue() : 0.0);
					cell30.setCellStyle(numberStyle);*/
				}
				// Auto-size all 31 columns
				for (int i = 0; i <= 30; i++) {
				    sheet.autoSizeColumn(i);
				}

				//workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
			} else {
				logger.warn("No CCR DATA found to populate the Excel file.");
			}
			workbook.write(out);

			 String finalPath = env.getProperty("output.exportpathfinal"); // e.g. finaltemp path
             File outputFile = new File(finalPath + "CBUAE_CCR_Data_Template.xlsx");
             try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                 fos.write(out.toByteArray());
                 logger.info("Service: Excel also saved to file: {}", outputFile.getAbsolutePath());
             }

             logger.info("Service: CCR DATA Excel data successfully written to memory buffer ({} bytes).", out.size());
             return out.toByteArray();
		}
	}
}