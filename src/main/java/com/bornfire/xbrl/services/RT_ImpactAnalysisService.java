package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.ss.usermodel.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.bornfire.xbrl.entities.RT_ForeignCurrencyDeposit;
import com.bornfire.xbrl.entities.RT_ForeignCurrencyDepositRepository;
import com.bornfire.xbrl.entities.RT_Fxriskdata;
import com.bornfire.xbrl.entities.RT_ImpactAnalysis;
import com.bornfire.xbrl.entities.RT_ImpactAnalysisRepository;
import com.bornfire.xbrl.entities.RT_MmData;
import com.bornfire.xbrl.entities.RT_MmDataRepository;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.io.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.io.FileNotFoundException;

@Service
public class RT_ImpactAnalysisService {
	
    private static final Logger logger = LoggerFactory.getLogger(RT_ImpactAnalysisService.class);


    @Autowired
    private Environment env;

    @Autowired
    private RT_ImpactAnalysisRepository impactanalysisRepo;

    @Autowired
    private SessionFactory sessionFactory;
    
	@Autowired
	AuditService auditservice;  
    
    public boolean updateImpactAnalysis(RT_ImpactAnalysis updatedData) {
	    System.out.println("Looking for record with SI_NO: " + updatedData.getSI_NO());

	    RT_ImpactAnalysis existing = impactanalysisRepo.getParticularDataBySI_NO(updatedData.getSI_NO());
	    
	    RT_ImpactAnalysis dbUser = new RT_ImpactAnalysis();
		org.springframework.beans.BeanUtils.copyProperties(existing, dbUser);

	    if (existing != null) {
	    	existing.setDate(updatedData.getDate());
	    	existing.setBankName(updatedData.getBankName());
	    	existing.setHeadOfficeSubsidiary(updatedData.getHeadOfficeSubsidiary());
	    	existing.setSubsidiary(updatedData.getSubsidiary());
	    	existing.setBankSymbol(updatedData.getBankSymbol());
	    	existing.setConventionalOrIslamic(updatedData.getConventionalOrIslamic());
	    	existing.setLocalOrForeign(updatedData.getLocalOrForeign());
	    	existing.setCbuaeTiering(updatedData.getCbuaeTiering());
	    	existing.setDealInternalReference(updatedData.getDealInternalReference());
	    	existing.setLegType(updatedData.getLegType());
	    	existing.setInternalCounterpartyReference(updatedData.getInternalCounterpartyReference());
	    	existing.setCptyName(updatedData.getCptyName());
	    	existing.setDerivativesCptyCountryOfRisk(updatedData.getDerivativesCptyCountryOfRisk());
	    	existing.setCbuaeRegionalZone(updatedData.getCbuaeRegionalZone());
	    	existing.setCcyBought(updatedData.getCcyBought());
	    	existing.setAmountBought(updatedData.getAmountBought());
	    	existing.setDealRate(updatedData.getDealRate());
	    	existing.setCcySold(updatedData.getCcySold());
	    	existing.setAmountSold(updatedData.getAmountSold());
	    	existing.setValueDate(updatedData.getValueDate());
	    	existing.setDealDate(updatedData.getDealDate());
	    	existing.setDerivativesTenorMonths(updatedData.getDerivativesTenorMonths());
	    	existing.setMaturityPeriod(updatedData.getMaturityPeriod());
	    	existing.setDealerName(updatedData.getDealerName());
	    	existing.setMtmAedEquivalentReportingDate(updatedData.getMtmAedEquivalentReportingDate());
	    	existing.setMtmAedEquivalentPreviousQuarter(updatedData.getMtmAedEquivalentPreviousQuarter());
	    	existing.setMtmChange(updatedData.getMtmChange());
	    	existing.setFundingOrLoansInternalReference(updatedData.getFundingOrLoansInternalReference());
	    	existing.setOnBalanceSheetItemType(updatedData.getOnBalanceSheetItemType());
	    	existing.setOnBalanceItemCounterparty(updatedData.getOnBalanceItemCounterparty());
	    	existing.setCounterpartyCountryOfRisk(updatedData.getCounterpartyCountryOfRisk());
	    	existing.setCbuaeRegionalZne(updatedData.getCbuaeRegionalZne());
	    	existing.setNominal(updatedData.getNominal());
	    	existing.setCurrency(updatedData.getCurrency());
	    	existing.setOverallImpact(updatedData.getOverallImpact());
	    	existing.setAccrualImpact(updatedData.getAccrualImpact());
	    	existing.setRateType(updatedData.getRateType());
	    	existing.setDepositFixedRateOrAdministrativeRate(updatedData.getDepositFixedRateOrAdministrativeRate());
	    	existing.setFixedDepositRateEquivalent(updatedData.getFixedDepositRateEquivalent());
	    	existing.setFloatingRateType(updatedData.getFloatingRateType());
	    	existing.setBenchmarkFloatingRate(updatedData.getBenchmarkFloatingRate());
	    	existing.setSpreadOverBenchmarkRate(updatedData.getSpreadOverBenchmarkRate());
	    	existing.setMaturityDate(updatedData.getMaturityDate());
	    	existing.setTenorMths(updatedData.getTenorMths());

			List<String> ignoreFields = Arrays.asList("createUser", "modifyUser", "delFlg");

			Map<String, String> changes = new LinkedHashMap<>();

			for (Field field : RT_ImpactAnalysis.class.getDeclaredFields()) {
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
	    	

	    	impactanalysisRepo.save(existing);

	        System.out.println("changes : "+changes);

	        // Audit only if any field was changed
	        if (!changes.isEmpty()) {
	            auditservice.createBusinessAudit(
	            		updatedData.getSI_NO(),           // Unique ID
	                "MODIFY",                             // Action
	                "IMPACT_ANALYSIS_EDIT_SCREEN",                  // Screen name
	                changes,                              // Changed fields map
	                "BCBUAE_CROSS_CUR_FUNDING_IMPACT_ANALYSIS"              // Table name
	            );
	        }
	        
	        
	        return true;
	    } else {
	        System.out.println("No record found for SI_NO: " + updatedData.getSI_NO());
	        return false;
	    }
	}
    
    public byte[] generateImpactAnalysisExcel(Date Report_date) throws Exception {
        logger.info("Service: Starting Impact Analysis Excel generation process in memory.");

        List<Object[]> impactanalysis = impactanalysisRepo.getimpactanalysislistdata1(Report_date);

        if (impactanalysis.isEmpty()) {
            logger.warn("Service: No data found for Impact Analysis report. Returning empty result.");
            return new byte[0];
        }

        String templateDir = env.getProperty("output.exportpathtemp");
        String templateFileName = "CBUAE_Cross_Currency_Funding_Spread_Template.xlsx";
        Path templatePath = Paths.get(templateDir, templateFileName);

        logger.info("Service: Attempting to load template from path: {}", templatePath.toAbsolutePath());

        if (!Files.exists(templatePath)) {
            throw new FileNotFoundException("Template file not found at: " + templatePath.toAbsolutePath());
        }

        if (!Files.isReadable(templatePath)) {
            throw new SecurityException("Template file exists but is not readable: " + templatePath.toAbsolutePath());
        }
     // This has been commented out because of the large file size and nill report 
        /*
        try (InputStream templateInputStream = Files.newInputStream(templatePath);
             Workbook workbook = WorkbookFactory.create(templateInputStream);
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            Sheet sheet = workbook.getSheetAt(3);
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

			if (!impactanalysis.isEmpty()) {
				for (int i = 0; i < impactanalysis.size(); i++) {
					Object[] ia = impactanalysis.get(i);
					Row row = sheet.getRow(startRow + i);
					if (row == null)
						row = sheet.createRow(startRow + i);

					// --------------------------------------------------
					// 0 – REPORT_DATE (Date)
					Cell cell0 = row.getCell(0);
					if (cell0 == null) cell0 = row.createCell(0);
					if (ia[0] instanceof Date) {
					    cell0.setCellValue((Date) ia[0]);
					    cell0.setCellStyle(dateStyle);
					} else {
					    cell0.setCellValue("");
					}

					// 1 – BANK_NAME (String)
					Cell cell1 = row.getCell(1);
					if (cell1 == null) cell1 = row.createCell(1);
					cell1.setCellValue(ia[1] == null ? "" : ia[1].toString());

					// 2 – HEAD_OFFICE_SUBSIDIARY (String)
					Cell cell2 = row.getCell(2);
					if (cell2 == null) cell2 = row.createCell(2);
					cell2.setCellValue(ia[2] == null ? "" : ia[2].toString());

					// 3 – SUBSIDIARY (String)
					Cell cell3 = row.getCell(3);
					if (cell3 == null) cell3 = row.createCell(3);
					cell3.setCellValue(ia[3] == null ? "" : ia[3].toString());

					// 4 – BANK_SYMBOL (String)
					Cell cell4 = row.getCell(4);
					if (cell4 == null) cell4 = row.createCell(4);
					cell4.setCellValue(ia[4] == null ? "" : ia[4].toString());

					// 5 – CONVENTIONAL_OR_ISLAMIC (String)
					Cell cell5 = row.getCell(5);
					if (cell5 == null) cell5 = row.createCell(5);
					cell5.setCellValue(ia[5] == null ? "" : ia[5].toString());

					// 6 – LOCAL_OR_FOREIGN (String)
					Cell cell6 = row.getCell(6);
					if (cell6 == null) cell6 = row.createCell(6);
					cell6.setCellValue(ia[6] == null ? "" : ia[6].toString());

					// 7 – CBUAE_TIERING (String)
					Cell cell7 = row.getCell(7);
					if (cell7 == null) cell7 = row.createCell(7);
					cell7.setCellValue(ia[7] == null ? "" : ia[7].toString());

					// 8 – DEAL_INTERNAL_REFERENCE (String)
					Cell cell8 = row.getCell(8);
					if (cell8 == null) cell8 = row.createCell(8);
					cell8.setCellValue(ia[8] == null ? "" : ia[8].toString());

					// 9 – LEG_TYPE (String)
					Cell cell9 = row.getCell(9);
					if (cell9 == null) cell9 = row.createCell(9);
					cell9.setCellValue(ia[9] == null ? "" : ia[9].toString());

					// 10 – INTERNAL_COUNTERPARTY_REFERENCE (String)
					Cell cell10 = row.getCell(10);
					if (cell10 == null) cell10 = row.createCell(10);
					cell10.setCellValue(ia[10] == null ? "" : ia[10].toString());

					// 11 – CPTY_NAME (String)
					Cell cell11 = row.getCell(11);
					if (cell11 == null) cell11 = row.createCell(11);
					cell11.setCellValue(ia[11] == null ? "" : ia[11].toString());

					// 12 – DERIVATIVES_CPTY_COUNTRY_OF_RISK (String)
					Cell cell12 = row.getCell(12);
					if (cell12 == null) cell12 = row.createCell(12);
					cell12.setCellValue(ia[12] == null ? "" : ia[12].toString());

					// 13 – CBUAE_REGIONAL_ZONE (String)
					Cell cell13 = row.getCell(13);
					if (cell13 == null) cell13 = row.createCell(13);
					cell13.setCellValue(ia[13] == null ? "" : ia[13].toString());

					// 14 – CCY_BOUGHT (String)
					Cell cell14 = row.getCell(14);
					if (cell14 == null) cell14 = row.createCell(14);
					cell14.setCellValue(ia[14] == null ? "" : ia[14].toString());

					// 15 – AMOUNT_BOUGHT (BigDecimal)
					Cell cell15 = row.getCell(15);
					if (cell15 == null) cell15 = row.createCell(15);
					if (ia[15] instanceof BigDecimal)
					    cell15.setCellValue(((BigDecimal) ia[15]).doubleValue());
					else
					    cell15.setCellValue("");

					// 16 – DEAL_RATE (BigDecimal)
					Cell cell16 = row.getCell(16);
					if (cell16 == null) cell16 = row.createCell(16);
					if (ia[16] instanceof BigDecimal)
					    cell16.setCellValue(((BigDecimal) ia[16]).doubleValue());
					else
					    cell16.setCellValue("");

					// 17 – CCY_SOLD (String)
					Cell cell17 = row.getCell(17);
					if (cell17 == null) cell17 = row.createCell(17);
					cell17.setCellValue(ia[17] == null ? "" : ia[17].toString());

					// 18 – AMOUNT_SOLD (BigDecimal)
					Cell cell18 = row.getCell(18);
					if (cell18 == null) cell18 = row.createCell(18);
					if (ia[18] instanceof BigDecimal)
					    cell18.setCellValue(((BigDecimal) ia[18]).doubleValue());
					else
					    cell18.setCellValue("");

					// 19 – VALUE_DATE (Date)
					Cell cell19 = row.getCell(19);
					if (cell19 == null) cell19 = row.createCell(19);
					if (ia[19] instanceof Date) {
					    cell19.setCellValue((Date) ia[19]);
					    cell19.setCellStyle(dateStyle);
					} else {
					    cell19.setCellValue("");
					}

					// 20 – DEAL_DATE (Date)
					Cell cell20 = row.getCell(20);
					if (cell20 == null) cell20 = row.createCell(20);
					if (ia[20] instanceof Date) {
					    cell20.setCellValue((Date) ia[20]);
					    cell20.setCellStyle(dateStyle);
					} else {
					    cell20.setCellValue("");
					}

					// 21 – DERIVATIVES_TENOR_MONTHS (BigDecimal)
					Cell cell21 = row.getCell(21);
					if (cell21 == null) cell21 = row.createCell(21);
					if (ia[21] instanceof BigDecimal)
					    cell21.setCellValue(((BigDecimal) ia[21]).doubleValue());
					else
					    cell21.setCellValue("");

					// 22 – MATURITY_PERIOD (BigDecimal)
					Cell cell22 = row.getCell(22);
					if (cell22 == null) cell22 = row.createCell(22);
					if (ia[22] instanceof BigDecimal)
					    cell22.setCellValue(((BigDecimal) ia[22]).doubleValue());
					else
					    cell22.setCellValue("");

					// 23 – DEALER_NAME (String)
					Cell cell23 = row.getCell(23);
					if (cell23 == null) cell23 = row.createCell(23);
					cell23.setCellValue(ia[23] == null ? "" : ia[23].toString());

					// 24 – MTM_AED_EQUIVALENT_REPORTING_DATE (Date)
					Cell cell24 = row.getCell(24);
					if (cell24 == null) cell24 = row.createCell(24);
					if (ia[24] instanceof Date) {
					    cell24.setCellValue((Date) ia[24]);
					    cell24.setCellStyle(dateStyle);
					} else {
					    cell24.setCellValue("");
					}

					// 25 – MTM_AED_EQUIVALENT_PREVIOUS_QUARTER (BigDecimal)
					Cell cell25 = row.getCell(25);
					if (cell25 == null) cell25 = row.createCell(25);
					if (ia[25] instanceof BigDecimal)
					    cell25.setCellValue(((BigDecimal) ia[25]).doubleValue());
					else
					    cell25.setCellValue("");

					// 26 – MTM_CHANGE (BigDecimal)
					Cell cell26 = row.getCell(26);
					if (cell26 == null) cell26 = row.createCell(26);
					if (ia[26] instanceof BigDecimal)
					    cell26.setCellValue(((BigDecimal) ia[26]).doubleValue());
					else
					    cell26.setCellValue("");

					// 27 – FUNDING_OR_LOANS_INTERNAL_REFERENCE (String)
					Cell cell27 = row.getCell(27);
					if (cell27 == null) cell27 = row.createCell(27);
					cell27.setCellValue(ia[27] == null ? "" : ia[27].toString());

					// 28 – ON_BALANCE_SHEET_ITEM_TYPE (String)
					Cell cell28 = row.getCell(28);
					if (cell28 == null) cell28 = row.createCell(28);
					cell28.setCellValue(ia[28] == null ? "" : ia[28].toString());

					// 29 – ON_BALANCE_ITEM_COUNTERPARTY (String)
					Cell cell29 = row.getCell(29);
					if (cell29 == null) cell29 = row.createCell(29);
					cell29.setCellValue(ia[29] == null ? "" : ia[29].toString());

					// 30 – COUNTERPARTY_COUNTRY_OF_RISK (String)
					Cell cell30 = row.getCell(30);
					if (cell30 == null) cell30 = row.createCell(30);
					cell30.setCellValue(ia[30] == null ? "" : ia[30].toString());

					// 31 – CBUAE_REGIONAL_ZNE (String)
					Cell cell31 = row.getCell(31);
					if (cell31 == null) cell31 = row.createCell(31);
					cell31.setCellValue(ia[31] == null ? "" : ia[31].toString());

					// 32 – NOMINAL (BigDecimal)
					Cell cell32 = row.getCell(32);
					if (cell32 == null) cell32 = row.createCell(32);
					if (ia[32] instanceof BigDecimal)
					    cell32.setCellValue(((BigDecimal) ia[32]).doubleValue());
					else
					    cell32.setCellValue("");

					// 33 – CURRENCY (String)
					Cell cell33 = row.getCell(33);
					if (cell33 == null) cell33 = row.createCell(33);
					cell33.setCellValue(ia[33] == null ? "" : ia[33].toString());

					// 34 – OVERALL_IMPACT (BigDecimal)
					Cell cell34 = row.getCell(34);
					if (cell34 == null) cell34 = row.createCell(34);
					if (ia[34] instanceof BigDecimal)
					    cell34.setCellValue(((BigDecimal) ia[34]).doubleValue());
					else
					    cell34.setCellValue("");

					// 35 – ACCRUAL_IMPACT (BigDecimal)
					Cell cell35 = row.getCell(35);
					if (cell35 == null) cell35 = row.createCell(35);
					if (ia[35] instanceof BigDecimal)
					    cell35.setCellValue(((BigDecimal) ia[35]).doubleValue());
					else
					    cell35.setCellValue("");

					// 36 – RATE_TYPE (String)
					Cell cell36 = row.getCell(36);
					if (cell36 == null) cell36 = row.createCell(36);
					cell36.setCellValue(ia[36] == null ? "" : ia[36].toString());

					// 37 – DEP_FIXED_RATE_OR_ADMINIS_RATE (BigDecimal)
					Cell cell37 = row.getCell(37);
					if (cell37 == null) cell37 = row.createCell(37);
					if (ia[37] instanceof BigDecimal)
					    cell37.setCellValue(((BigDecimal) ia[37]).doubleValue());
					else
					    cell37.setCellValue("");

					// 38 – FIXED_DEPOSIT_RATE_EQUIVALENT (BigDecimal)
					Cell cell38 = row.getCell(38);
					if (cell38 == null) cell38 = row.createCell(38);
					if (ia[38] instanceof BigDecimal)
					    cell38.setCellValue(((BigDecimal) ia[38]).doubleValue());
					else
					    cell38.setCellValue("");

					// 39 – FLOATING_RATE_TYPE (String)
					Cell cell39 = row.getCell(39);
					if (cell39 == null) cell39 = row.createCell(39);
					cell39.setCellValue(ia[39] == null ? "" : ia[39].toString());

					// 40 – BENCHMARK_FLOATING_RATE (String)
					Cell cell40 = row.getCell(40);
					if (cell40 == null) cell40 = row.createCell(40);
					cell40.setCellValue(ia[40] == null ? "" : ia[40].toString());

					// 41 – SPREAD_OVER_BENCHMARK_RATE (BigDecimal)
					Cell cell41 = row.getCell(41);
					if (cell41 == null) cell41 = row.createCell(41);
					if (ia[41] instanceof BigDecimal)
					    cell41.setCellValue(((BigDecimal) ia[41]).doubleValue());
					else
					    cell41.setCellValue("");

					// 42 – MATURITY_DATE (Date)
					Cell cell42 = row.getCell(42);
					if (cell42 == null) cell42 = row.createCell(42);
					if (ia[42] instanceof Date) {
					    cell42.setCellValue((Date) ia[42]);
					    cell42.setCellStyle(dateStyle);
					} else {
					    cell42.setCellValue("");
					}

					// 43 – TENOR_MTHS (BigDecimal)
					Cell cell43 = row.getCell(43);
					if (cell43 == null) cell43 = row.createCell(43);
					if (ia[43] instanceof BigDecimal)
					    cell43.setCellValue(((BigDecimal) ia[43]).doubleValue());
					else
					    cell43.setCellValue("");

					
					
					
				}
				// Auto-size all columns
				for (int i = 0; i <= 43; i++) {
				    sheet.autoSizeColumn(i);
				}
				workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
			} else {
				System.out.println("No Fx Risk data found to generate the Excel file.");
			}

			// Write the final workbook content to the in-memory stream.
			workbook.write(out);

			String finalPath = env.getProperty("output.exportpathfinal"); // e.g. finaltemp path
            File outputFile = new File(finalPath + "CBUAE_Impact_Analysis_Template.xls");
            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                fos.write(out.toByteArray());
                logger.info("Service: Excel also saved to file: {}", outputFile.getAbsolutePath());
            }

            logger.info("Service: IMPACT ANALYSIS Excel data successfully written to memory buffer ({} bytes).", out.size());
            return out.toByteArray();
		}*/
        return Files.readAllBytes(templatePath);// comment this out if its not a nill report
	}
    


    
}
