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
import com.bornfire.xbrl.entities.RT_Investment_Risk_Data_Dashboard_Template;
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
public class RT_ForeignCurrencyDepositService {
	
    private static final Logger logger = LoggerFactory.getLogger(RT_ForeignCurrencyDepositService.class);


    @Autowired
    private Environment env;

    @Autowired
    private RT_ForeignCurrencyDepositRepository foreigncurrencydepositRepo;

    @Autowired
    private SessionFactory sessionFactory;
    
	@Autowired
	AuditService auditservice;  
    
    public boolean updateForeignCurrencyDeposit(RT_ForeignCurrencyDeposit updatedData) {
	    System.out.println("Looking for record with SI_NO: " + updatedData.getSI_NO());

	    RT_ForeignCurrencyDeposit existing = foreigncurrencydepositRepo.getParticularDataBySI_NO(updatedData.getSI_NO());
	    
	    RT_ForeignCurrencyDeposit dbUser = new RT_ForeignCurrencyDeposit();
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
	    	existing.setDepositInternalReference(updatedData.getDepositInternalReference());
	    	existing.setOnBalanceSheetDepType(updatedData.getOnBalanceSheetDepType());
	    	existing.setFundingCounterParty(updatedData.getFundingCounterParty());
	    	existing.setCounterpartyType(updatedData.getCounterpartyType());
	    	existing.setIndustryGcis(updatedData.getIndustryGcis());
	    	existing.setCounterpartyCountryRisk(updatedData.getCounterpartyCountryRisk());
	    	existing.setCbuaeRegionalZone(updatedData.getCbuaeRegionalZone());
	    	existing.setNominal(updatedData.getNominal());
	    	existing.setNominalInAed(updatedData.getNominalInAed());
	    	existing.setCurrency(updatedData.getCurrency());
	    	existing.setRateType(updatedData.getRateType());
	    	existing.setDepositFixedRateOrAdministrativeRate(updatedData.getDepositFixedRateOrAdministrativeRate());
	    	existing.setBenchmarkFloatingRate(updatedData.getBenchmarkFloatingRate());
	    	existing.setTenorFloatingRate(updatedData.getTenorFloatingRate());
	    	existing.setSpreadOverBenchmarkRate(updatedData.getSpreadOverBenchmarkRate());
	    	existing.setMaturityDate(updatedData.getMaturityDate());
	    	existing.setTenorMths(updatedData.getTenorMths());
	    	existing.setMaturityPeriod(updatedData.getMaturityPeriod());

			List<String> ignoreFields = Arrays.asList("createUser", "modifyUser", "delFlg");

			Map<String, String> changes = new LinkedHashMap<>();

			for (Field field : RT_ForeignCurrencyDeposit.class.getDeclaredFields()) {
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
	    	
	    	
	       
	    	
	    	foreigncurrencydepositRepo.save(existing);
	    	

	        System.out.println("changes : "+changes);

	        // Audit only if any field was changed
	        if (!changes.isEmpty()) {
	            auditservice.createBusinessAudit(
	            		updatedData.getSI_NO(),           // Unique ID
	                "MODIFY",                             // Action
	                "FOREIGN_CURRENCY_DEPOSIT_EDIT_SCREEN",                  // Screen name
	                changes,                              // Changed fields map
	                "BCBUAE_CROSS_CUR_FUNDING_FOREIGN_DEPOSITS"              // Table name
	            );
	        }
	        
	        
	        return true;
	    } else {
	        System.out.println("No record found for SI_NO: " + updatedData.getSI_NO());
	        return false;
	    }
	}
    
    public byte[] generateForeignCurrencyDepositExcel(Date Report_date) throws Exception {
        logger.info("Service: Starting Foreign Currency Deposit Excel generation process in memory.");

        List<RT_ForeignCurrencyDeposit> foreigncurrencyList = foreigncurrencydepositRepo.getlist(Report_date);

        if (foreigncurrencyList == null || foreigncurrencyList.isEmpty()) {
            logger.warn("Service: No data found for Foreign Currency report. Returning empty result.");
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

        try (InputStream templateInputStream = Files.newInputStream(templatePath);
             Workbook workbook = WorkbookFactory.create(templateInputStream);
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            Sheet sheet = findSheet(workbook, "Foreign Curr Deposits");
            if (sheet == null) {
                throw new FileNotFoundException("Sheet 'Foreign Curr Deposits' not found in template: " + templatePath.toAbsolutePath());
            }

            CreationHelper createHelper = workbook.getCreationHelper();

            CellStyle dateStyle = workbook.createCellStyle();
            dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
            dateStyle.setBorderBottom(BorderStyle.THIN);
            dateStyle.setBorderTop(BorderStyle.THIN);
            dateStyle.setBorderLeft(BorderStyle.THIN);
            dateStyle.setBorderRight(BorderStyle.THIN);

            CellStyle numberStyle = workbook.createCellStyle();
            numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("#,##0.00"));
            numberStyle.setBorderBottom(BorderStyle.THIN);
            numberStyle.setBorderTop(BorderStyle.THIN);
            numberStyle.setBorderLeft(BorderStyle.THIN);
            numberStyle.setBorderRight(BorderStyle.THIN);

            int startRow = 1; // Excel row 2

            for (int i = 0; i < foreigncurrencyList.size(); i++) {
                RT_ForeignCurrencyDeposit fx = foreigncurrencyList.get(i);
                Row row = sheet.getRow(startRow + i);
                if (row == null) {
                    row = sheet.createRow(startRow + i);
                }

                // Same column order as the on-screen table
                setDateCell(row, 0, fx.getDate(), dateStyle);
                setStringCell(row, 1, fx.getBankName());
                setStringCell(row, 2, fx.getHeadOfficeSubsidiary());
                setStringCell(row, 3, fx.getSubsidiary());
                setStringCell(row, 4, fx.getBankSymbol());
                setStringCell(row, 5, fx.getConventionalOrIslamic());
                setStringCell(row, 6, fx.getLocalOrForeign());
                setStringCell(row, 7, fx.getCbuaeTiering());
                setStringCell(row, 8, fx.getDepositInternalReference());
                setStringCell(row, 9, fx.getOnBalanceSheetDepType());
                setStringCell(row, 10, fx.getFundingCounterParty());
                setStringCell(row, 11, fx.getCounterpartyType());
                setStringCell(row, 12, fx.getIndustryGcis());
                setStringCell(row, 13, fx.getCounterpartyCountryRisk());
                setStringCell(row, 14, fx.getCbuaeRegionalZone());
                setNumericCell(row, 15, fx.getNominal(), numberStyle);
                setNumericCell(row, 16, fx.getNominalInAed(), numberStyle);
                setStringCell(row, 17, fx.getCurrency());
                setStringCell(row, 18, fx.getRateType());
                setNumericCell(row, 19, fx.getDepositFixedRateOrAdministrativeRate(), numberStyle);
                setStringCell(row, 20, fx.getBenchmarkFloatingRate());
                setNumericCell(row, 21, fx.getTenorFloatingRate(), numberStyle);
                setNumericCell(row, 22, fx.getSpreadOverBenchmarkRate(), numberStyle);
                setDateCell(row, 23, fx.getMaturityDate(), dateStyle);
                setNumericCell(row, 24, fx.getTenorMths(), numberStyle);
                setNumericCell(row, 25, fx.getMaturityPeriod(), numberStyle);
            }

            workbook.setForceFormulaRecalculation(true);
            workbook.write(out);

            logger.info("Service: Foreign Currency Deposit Excel data successfully written to memory buffer ({} bytes).", out.size());
            return out.toByteArray();
        }
    }

    private Sheet findSheet(Workbook workbook, String expectedName) {
        Sheet sheet = workbook.getSheet(expectedName);
        if (sheet != null) {
            return sheet;
        }

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            String name = workbook.getSheetName(i);
            if (name != null && name.trim().equalsIgnoreCase(expectedName)) {
                return workbook.getSheetAt(i);
            }
        }

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            String name = workbook.getSheetName(i);
            if (name != null && name.toLowerCase().contains("foreign curr")) {
                return workbook.getSheetAt(i);
            }
        }

        return null;
    }

    private Cell getOrCreateCell(Row row, int col) {
        Cell cell = row.getCell(col);
        if (cell == null) {
            cell = row.createCell(col);
        }
        return cell;
    }

    private void setStringCell(Row row, int col, String value) {
        getOrCreateCell(row, col).setCellValue(value == null ? "" : value);
    }

    private void setDateCell(Row row, int col, Date value, CellStyle dateStyle) {
        Cell cell = getOrCreateCell(row, col);
        if (value != null) {
            cell.setCellValue(value);
            cell.setCellStyle(dateStyle);
        } else {
            cell.setCellValue("");
        }
    }

    private void setNumericCell(Row row, int col, Object value, CellStyle numberStyle) {
        Cell cell = getOrCreateCell(row, col);
        if (value instanceof Number) {
            cell.setCellValue(((Number) value).doubleValue());
            cell.setCellStyle(numberStyle);
            return;
        }
        if (value != null && !value.toString().trim().isEmpty()) {
            try {
                cell.setCellValue(Double.parseDouble(value.toString().trim()));
                cell.setCellStyle(numberStyle);
                return;
            } catch (NumberFormatException e) {
                cell.setCellValue(value.toString());
                return;
            }
        }
        cell.setCellValue("");
    }
}
