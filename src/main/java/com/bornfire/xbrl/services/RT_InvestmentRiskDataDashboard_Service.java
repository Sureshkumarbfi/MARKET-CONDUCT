package com.bornfire.xbrl.services;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.bornfire.xbrl.entities.RT_Fxriskdata;
import com.bornfire.xbrl.entities.RT_Investment_Risk_Data_Dashboard_Template;
import com.bornfire.xbrl.entities.RT_Investment_Risk_Data_Dashboard_TemplateRepository;
import com.bornfire.xbrl.entities.RT_MmData;
import com.bornfire.xbrl.entities.RT_MmDataRepository;
import java.io.InputStream;
import java.nio.file.Files;
import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileNotFoundException;

@Service
public class RT_InvestmentRiskDataDashboard_Service {
	
    private static final Logger logger = LoggerFactory.getLogger(RT_InvestmentRiskDataDashboard_Service.class);

    /**
     * Fallback grey formula columns when the Data sheet template row cannot be read.
     * Column 97 (CT, Overall Impact AED) is a white input cell and must be written.
     * Column 98 (CU) is the grey formula for Core Tier 1 Relative Impact %.
     */
    private static final Set<Integer> AUTOMATIC_FORMULA_COLUMNS = new HashSet<Integer>(Arrays.asList(
            4, 5, 6, 7, 10, 14, 17, 23, 24, 27, 30, 31, 37, 38, 44, 45, 51, 52,
            57, 58, 61, 62, 66, 69, 72, 76, 80, 84, 86, 88, 90, 92, 94, 96, 98));

    @Autowired
    private Environment env;

    @Autowired
	RT_Investment_Risk_Data_Dashboard_TemplateRepository RT_Investment_Risk_Data_Dashboard_TemplateRepositoryS;

    @Autowired
    private SessionFactory sessionFactory;
    
	@Autowired
	AuditService auditservice;    
    
    public boolean updateinvestmentriskdatadictionary(RT_Investment_Risk_Data_Dashboard_Template updatedData) {
	    System.out.println("Looking for record with SI_NO: " + updatedData.getSI_NO());

	    RT_Investment_Risk_Data_Dashboard_Template existing = RT_Investment_Risk_Data_Dashboard_TemplateRepositoryS.getParticularDataBySI_NO(updatedData.getSI_NO());


	    RT_Investment_Risk_Data_Dashboard_Template dbUser = new RT_Investment_Risk_Data_Dashboard_Template();
		org.springframework.beans.BeanUtils.copyProperties(existing, dbUser);
		
	    if (existing != null) {
	        // Update fields
	       
	    	// --- copy every simple field from updatedData to existing -------------------
	    	existing.setDataDate(updatedData.getDataDate());
	    	existing.setBankName(updatedData.getBankName());
	    	existing.setGroupHeadOfficeSubsidiary(updatedData.getGroupHeadOfficeSubsidiary());
	    	existing.setSubsidiary(updatedData.getSubsidiary());
	    	existing.setBankSymbol(updatedData.getBankSymbol());
	    	existing.setConventionalIslamic(updatedData.getConventionalIslamic());
	    	existing.setLocalForeign(updatedData.getLocalForeign());
	    	existing.setCbuAeTiering(updatedData.getCbuAeTiering());

	    	existing.setAssetBalanceSheetSizeAed(updatedData.getAssetBalanceSheetSizeAed());
	    	existing.setInvestmentBookSizeAed(updatedData.getInvestmentBookSizeAed());
	    	existing.setBookSizeTotalAssetsPct(updatedData.getBookSizeTotalAssetsPct());

	    	existing.setYtdNetPnlAed(updatedData.getYtdNetPnlAed());
	    	existing.setYtdFvtociUnrealizedLossAed(updatedData.getYtdFvtociUnrealizedLossAed());
	    	existing.setCet1Aed(updatedData.getCet1Aed());
	    	existing.setUglCoreTier1RelativeImpactPct(updatedData.getUglCoreTier1RelativeImpactPct());
	    	existing.setYtdAmortizedUnrealizedLossAed(updatedData.getYtdAmortizedUnrealizedLossAed());
	    	existing.setYtdHqlaAcUnrealizedLossAed(updatedData.getYtdHqlaAcUnrealizedLossAed());
	    	existing.setHqlaAcCoreTier1ImpactPct(updatedData.getHqlaAcCoreTier1ImpactPct());

	    	existing.setIrVarConfidenceInterval(updatedData.getIrVarConfidenceInterval());
	    	existing.setIrVarHoldingPeriod(updatedData.getIrVarHoldingPeriod());
	    	existing.setIrFixedIncomeExposureAed(updatedData.getIrFixedIncomeExposureAed());
	    	existing.setIrVarExposureAed(updatedData.getIrVarExposureAed());
	    	existing.setIrVarLimitAed(updatedData.getIrVarLimitAed());
	    	existing.setIrStatus(updatedData.getIrStatus());
	    	existing.setIrVarImpactPct(updatedData.getIrVarImpactPct());

	    	existing.setCsVarConfidenceInterval(updatedData.getCsVarConfidenceInterval());
	    	existing.setCsVarHoldingPeriod(updatedData.getCsVarHoldingPeriod());
	    	existing.setCsFixedIncomeExposureAed(updatedData.getCsFixedIncomeExposureAed());
	    	existing.setCsVarExposureAed(updatedData.getCsVarExposureAed());
	    	existing.setCsVarLimitAed(updatedData.getCsVarLimitAed());
	    	existing.setCsStatus(updatedData.getCsStatus());
	    	existing.setCsVarImpactPct(updatedData.getCsVarImpactPct());

	    	existing.setFxVarConfidenceInterval(updatedData.getFxVarConfidenceInterval());
	    	existing.setFxVarHoldingPeriod(updatedData.getFxVarHoldingPeriod());
	    	existing.setFxExposureAed(updatedData.getFxExposureAed());
	    	existing.setFxVarExposureAed(updatedData.getFxVarExposureAed());
	    	existing.setFxVarLimitAed(updatedData.getFxVarLimitAed());
	    	existing.setFxStatus(updatedData.getFxStatus());
	    	existing.setFxVarImpactPct(updatedData.getFxVarImpactPct());

	    	existing.setEqVarConfidenceInterval(updatedData.getEqVarConfidenceInterval());
	    	existing.setEqVarHoldingPeriod(updatedData.getEqVarHoldingPeriod());
	    	existing.setEqExposureAed(updatedData.getEqExposureAed());
	    	existing.setEqVarExposureAed(updatedData.getEqVarExposureAed());
	    	existing.setEqVarLimitAed(updatedData.getEqVarLimitAed());
	    	existing.setEqStatus(updatedData.getEqStatus());
	    	existing.setEqVarImpactPct(updatedData.getEqVarImpactPct());

	    	existing.setCommVarConfidenceInterval(updatedData.getCommVarConfidenceInterval());
	    	existing.setCommVarHoldingPeriod(updatedData.getCommVarHoldingPeriod());
	    	existing.setCommExposureAed(updatedData.getCommExposureAed());
	    	existing.setCommVarExposureAed(updatedData.getCommVarExposureAed());
	    	existing.setCommVarLimitAed(updatedData.getCommVarLimitAed());
	    	existing.setCommStatus(updatedData.getCommStatus());
	    	existing.setCommVarImpactPct(updatedData.getCommVarImpactPct());

	    	existing.setOverallVarConfidenceInterval(updatedData.getOverallVarConfidenceInterval());
	    	existing.setOverallVarHoldingPeriod(updatedData.getOverallVarHoldingPeriod());
	    	existing.setVarExposureAed(updatedData.getVarExposureAed());
	    	existing.setVarLimitAed(updatedData.getVarLimitAed());
	    	existing.setOverallVarStatus(updatedData.getOverallVarStatus());
	    	existing.setPortfolioRelativeImpactPct(updatedData.getPortfolioRelativeImpactPct());

	    	existing.setExpectedShortfallExposureAed(updatedData.getExpectedShortfallExposureAed());
	    	existing.setExpectedShortfallLimitAed(updatedData.getExpectedShortfallLimitAed());
	    	existing.setExpectedShortfallStatus(updatedData.getExpectedShortfallStatus());
	    	existing.setExpectedShortfallImpactPct(updatedData.getExpectedShortfallImpactPct());

	    	existing.setModifiedDuration(updatedData.getModifiedDuration());
	    	existing.setInterestRateShockBps(updatedData.getInterestRateShockBps());
	    	existing.setInterestRateLimit(updatedData.getInterestRateLimit());
	    	existing.setInterestRateStatus(updatedData.getInterestRateStatus());

	    	existing.setDv01Aed(updatedData.getDv01Aed());
	    	existing.setDv01LimitAed(updatedData.getDv01LimitAed());
	    	existing.setDv01Status(updatedData.getDv01Status());
	    	existing.setDv01TenorGapLt3Aed(updatedData.getDv01TenorGapLt3Aed());
	    	existing.setDv01TenorGapGt3Aed(updatedData.getDv01TenorGapGt3Aed());
	    	existing.setDv01Check(updatedData.getDv01Check());

	    	existing.setCs01Aed(updatedData.getCs01Aed());
	    	existing.setCs01ShockBps(updatedData.getCs01ShockBps());
	    	existing.setCs01Limit(updatedData.getCs01Limit());
	    	existing.setCs01Status(updatedData.getCs01Status());
	    	existing.setCs01InvestmentGradeAed(updatedData.getCs01InvestmentGradeAed());
	    	existing.setCs01SubInvestmentAed(updatedData.getCs01SubInvestmentAed());
	    	existing.setCs01UnratedAed(updatedData.getCs01UnratedAed());
	    	existing.setCs01Check(updatedData.getCs01Check());

	    	existing.setBetaEquity(updatedData.getBetaEquity());
	    	existing.setEquityShockBps(updatedData.getEquityShockBps());
	    	existing.setEquityLimit(updatedData.getEquityLimit());
	    	existing.setEquityStatus(updatedData.getEquityStatus());

	    	existing.setCreditSpreadImpactAed(updatedData.getCreditSpreadImpactAed());
	    	existing.setCreditSensitiveImpactPct(updatedData.getCreditSensitiveImpactPct());
	    	existing.setInterestRateImpactAed(updatedData.getInterestRateImpactAed());
	    	existing.setRateSensitiveImpactPct(updatedData.getRateSensitiveImpactPct());

	    	existing.setFxImpactAed(updatedData.getFxImpactAed());
	    	existing.setFxSensitiveImpactPct(updatedData.getFxSensitiveImpactPct());
	    	existing.setEquityImpactAed(updatedData.getEquityImpactAed());
	    	existing.setEquitySensitiveImpactPct(updatedData.getEquitySensitiveImpactPct());

	    	existing.setCommoditiesImpactAed(updatedData.getCommoditiesImpactAed());
	    	existing.setCommoditySensitiveImpactPct(updatedData.getCommoditySensitiveImpactPct());

	    	existing.setJtdLossImpactAed(updatedData.getJtdLossImpactAed());
	    	existing.setJtdRelativeImpactPct(updatedData.getJtdRelativeImpactPct());

	    	existing.setOverallImpactAed(updatedData.getOverallImpactAed());
	    	existing.setCoreTier1RelativeImpactPct(updatedData.getCoreTier1RelativeImpactPct());
	    	// ---------------------------------------------------------------------------


			List<String> ignoreFields = Arrays.asList("createUser", "modifyUser", "delFlg");

			Map<String, String> changes = new LinkedHashMap<>();

			for (Field field : RT_Investment_Risk_Data_Dashboard_Template.class.getDeclaredFields()) {
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
			

	    	RT_Investment_Risk_Data_Dashboard_TemplateRepositoryS.save(existing);

	        System.out.println("changes : "+changes);

	        // Audit only if any field was changed
	        if (!changes.isEmpty()) {
	            auditservice.createBusinessAudit(
	            		String.valueOf(updatedData.getSI_NO()),           // Unique ID
	                "MODIFY",                             // Action
	                "INVESTMENTRISK_DATA_DICTIONARY_TEMPLATE_EDIT_SCREEN",                  // Screen name
	                changes,                              // Changed fields map
	                "BCBUAE_INVESTMENT_RISK_DATA_DASHBOARD_TEMPLATE"              // Table name
	            );
	        }
	        
	        return true;
	    } else {
	        System.out.println("No record found for SI_NO: " + updatedData.getSI_NO());
	        return false;
	    }
	}
    
    
    
    public byte[] generateInvestmentriskdataExcel(Date Report_date) throws Exception {
        logger.info("Service: Starting Investment Risk Data Dashboard Excel generation process in memory.");

        List<RT_Investment_Risk_Data_Dashboard_Template> investmentriskdata = RT_Investment_Risk_Data_Dashboard_TemplateRepositoryS
                .getlist(Report_date);

        if (investmentriskdata == null || investmentriskdata.isEmpty()) {
            logger.warn("Service: No data found for Investment Risk Data Dashboard report. Returning empty result.");
            return new byte[0];
        }

        String templateDir = env.getProperty("output.exportpathtemp");
        String templateFileName = "CBUAE_Investment Risk Data_Dashboard_Template.xlsx";
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

            Sheet sheet = workbook.getSheet("Data");
            if (sheet == null) {
                sheet = workbook.getSheetAt(2);
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

            int startRow = 2;
            Row templateRow = sheet.getRow(startRow);
            Set<Integer> automaticColumns = detectAutomaticColumns(templateRow);
            Map<Integer, String> templateFormulas = snapshotFormulas(templateRow, automaticColumns);
            int templateExcelRow = startRow + 1;

            for (int i = 0; i < investmentriskdata.size(); i++) {
                int rowIndex = startRow + i;
                Row row = sheet.getRow(rowIndex);
                if (row == null) {
                    row = sheet.createRow(rowIndex);
                }

                copyAutomaticFormulaCells(templateRow, row, automaticColumns, templateFormulas, templateExcelRow,
                        rowIndex + 1);
                writeInvestmentRiskInputCells(row, investmentriskdata.get(i), automaticColumns, dateStyle, textStyle,
                        numberStyle);
            }

            for (int i = 0; i <= 98; i++) {
                if (!automaticColumns.contains(i)) {
                    sheet.autoSizeColumn(i);
                }
            }

            workbook.setForceFormulaRecalculation(true);
            workbook.write(out);

            String finalPath = env.getProperty("output.exportpathfinal"); // e.g. finaltemp path
            File outputFile = new File(finalPath + "CBUAE_Investment Risk Data_Dashboard_Template.xlsx");
            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                fos.write(out.toByteArray());
                logger.info("Service: Excel also saved to file: {}", outputFile.getAbsolutePath());
            }

            logger.info("Service: INVESTMENT RISK DATA Excel data successfully written to memory buffer ({} bytes).", out.size());
            return out.toByteArray();
        }
    }

    /**
     * Write only user-input (non-grey) cells. Grey / formula cells keep Excel
     * automation: VLOOKUP, book-size and impact %, Status OK/BREACH, Check,
     * CS Fixed Income, and overall impact.
     */
    private void writeInvestmentRiskInputCells(Row row, RT_Investment_Risk_Data_Dashboard_Template data,
            Set<Integer> automaticColumns, CellStyle dateStyle, CellStyle textStyle, CellStyle numberStyle) {
        setDateValue(row, 0, data.getDataDate(), dateStyle, automaticColumns);
        setTextValue(row, 1, data.getBankName(), textStyle, automaticColumns);
        setTextValue(row, 2, data.getGroupHeadOfficeSubsidiary(), textStyle, automaticColumns);
        setTextValue(row, 3, data.getSubsidiary(), textStyle, automaticColumns);
        setNumberValue(row, 8, data.getAssetBalanceSheetSizeAed(), numberStyle, automaticColumns);
        setNumberValue(row, 9, data.getInvestmentBookSizeAed(), numberStyle, automaticColumns);
        setNumberValue(row, 11, data.getYtdNetPnlAed(), numberStyle, automaticColumns);
        setNumberValue(row, 12, data.getYtdFvtociUnrealizedLossAed(), numberStyle, automaticColumns);
        setNumberValue(row, 13, data.getCet1Aed(), numberStyle, automaticColumns);
        setNumberValue(row, 15, data.getYtdAmortizedUnrealizedLossAed(), numberStyle, automaticColumns);
        setNumberValue(row, 16, data.getYtdHqlaAcUnrealizedLossAed(), numberStyle, automaticColumns);
        setNumberValue(row, 18, data.getIrVarConfidenceInterval(), numberStyle, automaticColumns);
        setTextValue(row, 19, data.getIrVarHoldingPeriod(), textStyle, automaticColumns);
        setNumberValue(row, 20, data.getIrFixedIncomeExposureAed(), numberStyle, automaticColumns);
        setNumberValue(row, 21, data.getIrVarExposureAed(), numberStyle, automaticColumns);
        setNumberValue(row, 22, data.getIrVarLimitAed(), numberStyle, automaticColumns);
        setNumberValue(row, 25, data.getCsVarConfidenceInterval(), numberStyle, automaticColumns);
        setTextValue(row, 26, data.getCsVarHoldingPeriod(), textStyle, automaticColumns);
        setNumberValue(row, 27, data.getCsFixedIncomeExposureAed(), numberStyle, automaticColumns);
        setNumberValue(row, 28, data.getCsVarExposureAed(), numberStyle, automaticColumns);
        setNumberValue(row, 29, data.getCsVarLimitAed(), numberStyle, automaticColumns);
        setNumberValue(row, 32, data.getFxVarConfidenceInterval(), numberStyle, automaticColumns);
        setTextValue(row, 33, data.getFxVarHoldingPeriod(), textStyle, automaticColumns);
        setNumberValue(row, 34, data.getFxExposureAed(), numberStyle, automaticColumns);
        setNumberValue(row, 35, data.getFxVarExposureAed(), numberStyle, automaticColumns);
        setNumberValue(row, 36, data.getFxVarLimitAed(), numberStyle, automaticColumns);
        setNumberValue(row, 39, data.getEqVarConfidenceInterval(), numberStyle, automaticColumns);
        setTextValue(row, 40, data.getEqVarHoldingPeriod(), textStyle, automaticColumns);
        setNumberValue(row, 41, data.getEqExposureAed(), numberStyle, automaticColumns);
        setNumberValue(row, 42, data.getEqVarExposureAed(), numberStyle, automaticColumns);
        setNumberValue(row, 43, data.getEqVarLimitAed(), numberStyle, automaticColumns);
        setNumberValue(row, 46, data.getCommVarConfidenceInterval(), numberStyle, automaticColumns);
        setTextValue(row, 47, data.getCommVarHoldingPeriod(), textStyle, automaticColumns);
        setNumberValue(row, 48, data.getCommExposureAed(), numberStyle, automaticColumns);
        setNumberValue(row, 49, data.getCommVarExposureAed(), numberStyle, automaticColumns);
        setNumberValue(row, 50, data.getCommVarLimitAed(), numberStyle, automaticColumns);
        setNumberValue(row, 53, data.getOverallVarConfidenceInterval(), numberStyle, automaticColumns);
        setTextValue(row, 54, data.getOverallVarHoldingPeriod(), textStyle, automaticColumns);
        setNumberValue(row, 55, data.getVarExposureAed(), numberStyle, automaticColumns);
        setNumberValue(row, 56, data.getVarLimitAed(), numberStyle, automaticColumns);
        setNumberValue(row, 59, data.getExpectedShortfallExposureAed(), numberStyle, automaticColumns);
        setNumberValue(row, 60, data.getExpectedShortfallLimitAed(), numberStyle, automaticColumns);
        setNumberValue(row, 63, data.getModifiedDuration(), numberStyle, automaticColumns);
        setNumberValue(row, 64, data.getInterestRateShockBps(), numberStyle, automaticColumns);
        setNumberValue(row, 65, data.getInterestRateLimit(), numberStyle, automaticColumns);
        setNumberValue(row, 67, data.getDv01Aed(), numberStyle, automaticColumns);
        setNumberValue(row, 68, data.getDv01LimitAed(), numberStyle, automaticColumns);
        setNumberValue(row, 70, data.getDv01TenorGapLt3Aed(), numberStyle, automaticColumns);
        setNumberValue(row, 71, data.getDv01TenorGapGt3Aed(), numberStyle, automaticColumns);
        setNumberValue(row, 73, data.getCs01Aed(), numberStyle, automaticColumns);
        setNumberValue(row, 74, data.getCs01ShockBps(), numberStyle, automaticColumns);
        setNumberValue(row, 75, data.getCs01Limit(), numberStyle, automaticColumns);
        setNumberValue(row, 77, data.getCs01InvestmentGradeAed(), numberStyle, automaticColumns);
        setNumberValue(row, 78, data.getCs01SubInvestmentAed(), numberStyle, automaticColumns);
        setNumberValue(row, 79, data.getCs01UnratedAed(), numberStyle, automaticColumns);
        setNumberValue(row, 81, data.getBetaEquity(), numberStyle, automaticColumns);
        setNumberValue(row, 82, data.getEquityShockBps(), numberStyle, automaticColumns);
        setNumberValue(row, 83, data.getEquityLimit(), numberStyle, automaticColumns);
        setNumberValue(row, 85, data.getCreditSpreadImpactAed(), numberStyle, automaticColumns);
        setNumberValue(row, 87, data.getInterestRateImpactAed(), numberStyle, automaticColumns);
        setNumberValue(row, 89, data.getFxImpactAed(), numberStyle, automaticColumns);
        setNumberValue(row, 91, data.getEquityImpactAed(), numberStyle, automaticColumns);
        setNumberValue(row, 93, data.getCommoditiesImpactAed(), numberStyle, automaticColumns);
        setNumberValue(row, 95, data.getJtdLossImpactAed(), numberStyle, automaticColumns);
        setNumberValue(row, 97, data.getOverallImpactAed(), numberStyle, automaticColumns);
    }

    /**
     * Skip grey formula cells only. A white cell is an input cell and must be
     * written, even when the next column is a grey formula.
     */
    private Set<Integer> detectAutomaticColumns(Row templateRow) {
        if (templateRow == null) {
            return new HashSet<Integer>(AUTOMATIC_FORMULA_COLUMNS);
        }
        Set<Integer> automatic = new HashSet<Integer>();
        short lastCellNum = templateRow.getLastCellNum();
        if (lastCellNum < 0) {
            return new HashSet<Integer>(AUTOMATIC_FORMULA_COLUMNS);
        }
        for (int col = 0; col < lastCellNum; col++) {
            Cell cell = templateRow.getCell(col);
            if (cell == null) {
                continue;
            }
            if (isGreyFill(cell)) {
                automatic.add(col);
            }
        }
        if (automatic.isEmpty()) {
            return new HashSet<Integer>(AUTOMATIC_FORMULA_COLUMNS);
        }
        return automatic;
    }

    private boolean isGreyFill(Cell cell) {
        CellStyle style = cell.getCellStyle();
        if (style == null) {
            return false;
        }
        try {
            if (style.getFillPatternEnum() != FillPatternType.SOLID_FOREGROUND) {
                return false;
            }
        } catch (Exception ignored) {
            if (style.getFillPattern() != FillPatternType.SOLID_FOREGROUND.getCode()) {
                return false;
            }
        }
        short indexed = style.getFillForegroundColor();
        if (indexed == IndexedColors.GREY_25_PERCENT.getIndex()
                || indexed == IndexedColors.GREY_40_PERCENT.getIndex()
                || indexed == IndexedColors.GREY_50_PERCENT.getIndex()
                || indexed == IndexedColors.GREY_80_PERCENT.getIndex()) {
            return true;
        }
        if (style instanceof XSSFCellStyle) {
            XSSFColor color = ((XSSFCellStyle) style).getFillForegroundXSSFColor();
            if (color == null) {
                return false;
            }
            // Template grey formula cells use theme white (lt1) darkened by a small tint.
            // Near-white input fills such as F8FBFC have no tint and must stay writable.
            if (color.getTheme() == 0 && color.getTint() < -0.05d && color.getTint() > -0.45d) {
                return true;
            }
            byte[] rgb = color.getRGBWithTint();
            if (rgb == null) {
                rgb = color.getRGB();
            }
            if (rgb != null && rgb.length >= 3) {
                int r = rgb[0] & 0xFF;
                int g = rgb[1] & 0xFF;
                int b = rgb[2] & 0xFF;
                int max = Math.max(r, Math.max(g, b));
                int min = Math.min(r, Math.min(g, b));
                int avg = (r + g + b) / 3;
                return (max - min) <= 20 && avg >= 160 && avg <= 230;
            }
        }
        return false;
    }

    private Map<Integer, String> snapshotFormulas(Row templateRow, Set<Integer> automaticColumns) {
        Map<Integer, String> formulas = new LinkedHashMap<Integer, String>();
        if (templateRow == null) {
            return formulas;
        }
        for (Integer col : automaticColumns) {
            Cell cell = templateRow.getCell(col);
            if (cell != null && cell.getCellTypeEnum() == CellType.FORMULA) {
                formulas.put(col, cell.getCellFormula());
            }
        }
        return formulas;
    }

    private void copyAutomaticFormulaCells(Row templateRow, Row destRow, Set<Integer> automaticColumns,
            Map<Integer, String> templateFormulas, int templateExcelRow, int destExcelRow) {
        for (Integer col : automaticColumns) {
            Cell destCell = destRow.getCell(col);
            if (destCell == null) {
                destCell = destRow.createCell(col);
            }
            Cell templateCell = templateRow == null ? null : templateRow.getCell(col);
            if (templateCell != null && templateCell.getCellStyle() != null) {
                destCell.setCellStyle(templateCell.getCellStyle());
            }
            String formula = templateFormulas.get(col);
            if (formula != null && !formula.trim().isEmpty()) {
                destCell.setCellFormula(adjustFormulaRow(formula, templateExcelRow, destExcelRow));
            }
        }
    }

    private String adjustFormulaRow(String formula, int fromExcelRow, int toExcelRow) {
        if (formula == null || fromExcelRow == toExcelRow) {
            return formula;
        }
        return formula.replaceAll("(\\$?[A-Z]{1,3})(\\$?)" + fromExcelRow + "(?!\\d)", "$1$2" + toExcelRow);
    }

    private boolean skipAutomaticCell(Set<Integer> automaticColumns, Row row, int col) {
        return automaticColumns != null && automaticColumns.contains(col);
    }

    private Cell writableCell(Row row, int col, Set<Integer> automaticColumns) {
        if (skipAutomaticCell(automaticColumns, row, col)) {
            return null;
        }
        Cell cell = row.getCell(col);
        if (cell == null) {
            cell = row.createCell(col);
        }
        return cell;
    }

    private void setDateValue(Row row, int col, Date value, CellStyle dateStyle, Set<Integer> automaticColumns) {
        Cell cell = writableCell(row, col, automaticColumns);
        if (cell == null) {
            return;
        }
        if (dateStyle != null) {
            cell.setCellStyle(dateStyle);
        }
        if (value != null) {
            cell.setCellValue(value);
        } else {
            cell.setCellValue("");
        }
    }

    private void setTextValue(Row row, int col, String value, CellStyle textStyle, Set<Integer> automaticColumns) {
        Cell cell = writableCell(row, col, automaticColumns);
        if (cell == null) {
            return;
        }
        if (textStyle != null) {
            cell.setCellStyle(textStyle);
        }
        cell.setCellValue(value == null ? "" : value);
    }

    private void setNumberValue(Row row, int col, Number value, CellStyle numberStyle, Set<Integer> automaticColumns) {
        Cell cell = writableCell(row, col, automaticColumns);
        if (cell == null) {
            return;
        }
        if (numberStyle != null) {
            cell.setCellStyle(numberStyle);
        }
        cell.setCellValue(value == null ? 0 : value.doubleValue());
    }
}
