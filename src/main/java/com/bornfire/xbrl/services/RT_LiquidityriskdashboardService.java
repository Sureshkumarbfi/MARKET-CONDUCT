package com.bornfire.xbrl.services;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.persistence.Column;
import java.io.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.bornfire.xbrl.entities.RT_FxRiskDataRepository;
import com.bornfire.xbrl.entities.RT_Fxriskdata;
import com.bornfire.xbrl.entities.RT_Investment_Risk_Data_Dashboard_Template;
import com.bornfire.xbrl.entities.RT_Liquidity_Risk_Dashboard_Template;
import com.bornfire.xbrl.entities.RT_Liquidity_Risk_Dashboard_Template_repository;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.io.FileNotFoundException;



@Service
public class RT_LiquidityriskdashboardService {

	@Autowired
	private Environment env;
	
    private static final Logger logger = LoggerFactory.getLogger(RT_LiquidityriskdashboardService.class);


    @Autowired 
    RT_Liquidity_Risk_Dashboard_Template_repository LiquidityRiskDashboardRepo;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SessionFactory sessionFactory;

	private static final Map<String, Field> LIQUIDITY_COLUMNS = liquidityColumns();
	
	@Autowired
	AuditService auditservice;    

	public boolean updateliquidityriskdashboard(RT_Liquidity_Risk_Dashboard_Template updatedData) {
	    System.out.println("Looking for record with SI_NO: " + updatedData.getSI_NO());

	    RT_Liquidity_Risk_Dashboard_Template existing = findBySiNo(updatedData.getSI_NO());
	    
	    RT_Liquidity_Risk_Dashboard_Template dbUser = new RT_Liquidity_Risk_Dashboard_Template();
		org.springframework.beans.BeanUtils.copyProperties(existing, dbUser);
		
	    if (existing != null) {
	        // Update fields
	    	existing.setReportDate(updatedData.getReportDate());
	    	existing.setBankName(updatedData.getBankName());
	    	existing.setGroupHeadOfficeSubsidiary(updatedData.getGroupHeadOfficeSubsidiary());
	    	existing.setSubsidiary(updatedData.getSubsidiary());
	    	existing.setBankSymbol(updatedData.getBankSymbol());
	    	existing.setConventionalIslamic(updatedData.getConventionalIslamic());
	    	existing.setLocalForeign(updatedData.getLocalForeign());
	    	existing.setCbuAeTiering(updatedData.getCbuAeTiering());
	    	existing.setAssetBalanceSheetSizeAed(updatedData.getAssetBalanceSheetSizeAed());
	    	existing.setCashAed(updatedData.getCashAed());
	    	existing.setCashPercent(updatedData.getCashPercent());
	    	existing.setDueFromCentralBankAed(updatedData.getDueFromCentralBankAed());
	    	existing.setDueFromCentralBankPercent(updatedData.getDueFromCentralBankPercent());
	    	existing.setDueFromHoBranchSubsAed(updatedData.getDueFromHoBranchSubsAed());
	    	existing.setDueFromHoBranchSubsPercent(updatedData.getDueFromHoBranchSubsPercent());
	    	existing.setDueFromBanksAed(updatedData.getDueFromBanksAed());
	    	existing.setDueFromBanksPercent(updatedData.getDueFromBanksPercent());
	    	existing.setDueFromNbfiAed(updatedData.getDueFromNbfiAed());
	    	existing.setDueFromNbfiPercent(updatedData.getDueFromNbfiPercent());
	    	existing.setInvestmentAed(updatedData.getInvestmentAed());
	    	existing.setInvestmentPercent(updatedData.getInvestmentPercent());
	    	existing.setOtherInvestmentsAed(updatedData.getOtherInvestmentsAed());
	    	existing.setOtherInvestmentsPercent(updatedData.getOtherInvestmentsPercent());
	    	existing.setNetCreditPortfolioAed(updatedData.getNetCreditPortfolioAed());
	    	existing.setNetCreditPortfolioPercent(updatedData.getNetCreditPortfolioPercent());
	    	existing.setTradeBillsAed(updatedData.getTradeBillsAed());
	    	existing.setTradeBillsPercent(updatedData.getTradeBillsPercent());
	    	existing.setNetFixedOtherAssetsAed(updatedData.getNetFixedOtherAssetsAed());
	    	existing.setNetFixedOtherAssetsPercent(updatedData.getNetFixedOtherAssetsPercent());
	    	existing.setPositiveFvDerivativesAed(updatedData.getPositiveFvDerivativesAed());
	    	existing.setPositiveFvDerivativesPercent(updatedData.getPositiveFvDerivativesPercent());
	    	existing.setLiabilityBalanceSheetSizeAed(updatedData.getLiabilityBalanceSheetSizeAed());
	    	existing.setDueToCentralBankAed(updatedData.getDueToCentralBankAed());
	    	existing.setDueToCentralBankPercent(updatedData.getDueToCentralBankPercent());
	    	existing.setDueToHoBranchSubsAed(updatedData.getDueToHoBranchSubsAed());
	    	existing.setDueToHoPercent(updatedData.getDueToHoPercent());
	    	existing.setDueToBanksAed(updatedData.getDueToBanksAed());
	    	existing.setDueToBanksPercent(updatedData.getDueToBanksPercent());
	    	existing.setDueToNbfiAed(updatedData.getDueToNbfiAed());
	    	existing.setDueToNbfiPercent(updatedData.getDueToNbfiPercent());
	    	existing.setCustomerDepositAed(updatedData.getCustomerDepositAed());
	    	existing.setCustomerDepositPercent(updatedData.getCustomerDepositPercent());
	    	existing.setLongTermFundingAed(updatedData.getLongTermFundingAed());
	    	existing.setLongTermFundingPercent(updatedData.getLongTermFundingPercent());
	    	existing.setOtherLiabilitiesAed(updatedData.getOtherLiabilitiesAed());
	    	existing.setOtherLiabilitiesPercent(updatedData.getOtherLiabilitiesPercent());
	    	existing.setNegativeFvDerivativesAed(updatedData.getNegativeFvDerivativesAed());
	    	existing.setNegativeFvDerivativesPercent(updatedData.getNegativeFvDerivativesPercent());
	    	existing.setCapitalReservesAed(updatedData.getCapitalReservesAed());
	    	existing.setCapitalReservesPercent(updatedData.getCapitalReservesPercent());
	    	existing.setShortTermRegRatioReq(updatedData.getShortTermRegRatioReq());
	    	existing.setHqAssetsConvertedAed(updatedData.getHqAssetsConvertedAed());
	    	existing.setOutflows30dAed(updatedData.getOutflows30dAed());
	    	existing.setInflows30dAed(updatedData.getInflows30dAed());
	    	existing.setLcr(updatedData.getLcr());
	    	existing.setAedHqAssets(updatedData.getAedHqAssets());
	    	existing.setAedOutflows30d(updatedData.getAedOutflows30d());
	    	existing.setAedInflows30d(updatedData.getAedInflows30d());
	    	existing.setAedLcr(updatedData.getAedLcr());
	    	existing.setUsdHqAssets(updatedData.getUsdHqAssets());
	    	existing.setUsdOutflows30d(updatedData.getUsdOutflows30d());
	    	existing.setUsdInflows30d(updatedData.getUsdInflows30d());
	    	existing.setUsdLcr(updatedData.getUsdLcr());
	    	existing.setElarHqAssetsConvertedAed(updatedData.getElarHqAssetsConvertedAed());
	    	existing.setTotalLiabilitiesConvertedAed(updatedData.getTotalLiabilitiesConvertedAed());
	    	existing.setEligibleAssetRatio(updatedData.getEligibleAssetRatio());
	    	existing.setAedElarHqAssets(updatedData.getAedElarHqAssets());
	    	existing.setAedTotalLiabilities(updatedData.getAedTotalLiabilities());
	    	existing.setAedEligiblrAssetRatio(updatedData.getAedEligiblrAssetRatio());
	    	existing.setUsdElarHqAssets(updatedData.getUsdElarHqAssets());
	    	existing.setUsdTotalLiabilities(updatedData.getUsdTotalLiabilities());
	    	existing.setUsdEigibleAssetRatio(updatedData.getUsdEigibleAssetRatio());
	    	existing.setAsfConvertedAed(updatedData.getAsfConvertedAed());
	    	existing.setRsfConvertedAed(updatedData.getRsfConvertedAed());
	    	existing.setNsfr(updatedData.getNsfr());
	    	existing.setAedAsf(updatedData.getAedAsf());
	    	existing.setAedRsf(updatedData.getAedRsf());
	    	existing.setAedNsfr(updatedData.getAedNsfr());
	    	existing.setUsdAsf(updatedData.getUsdAsf());
	    	existing.setUsdRsf(updatedData.getUsdRsf());
	    	existing.setUsdNsfr(updatedData.getUsdNsfr());
	    	existing.setLoansAdvancesConvertedAed(updatedData.getLoansAdvancesConvertedAed());
	    	existing.setStableResourcesConvertedAed(updatedData.getStableResourcesConvertedAed());
	    	existing.setLoansToStableResourcesRatio(updatedData.getLoansToStableResourcesRatio());
	    	existing.setAedLoansAdvances(updatedData.getAedLoansAdvances());
	    	existing.setAedStableResources(updatedData.getAedStableResources());
	    	existing.setAedLtsRatio(updatedData.getAedLtsRatio());
	    	existing.setUsdLoansAdvances(updatedData.getUsdLoansAdvances());
	    	existing.setUsdStableResources(updatedData.getUsdStableResources());
	    	existing.setUsdLtsRatio(updatedData.getUsdLtsRatio());
	    	existing.setStableTermDepositAed(updatedData.getStableTermDepositAed());
	    	existing.setVolatileTermDepositAed(updatedData.getVolatileTermDepositAed());
	    	existing.setStableCasaAed(updatedData.getStableCasaAed());
	    	existing.setVolatileCasaAed(updatedData.getVolatileCasaAed());
	    	existing.setTermDepositAed(updatedData.getTermDepositAed());
	    	existing.setCasaAed(updatedData.getCasaAed());
	    	existing.setLoansToDepositsRatio(updatedData.getLoansToDepositsRatio());
	    	existing.setStableTermDepositToAssets(updatedData.getStableTermDepositToAssets());
	    	existing.setVolatileTermDepositToAssets(updatedData.getVolatileTermDepositToAssets());
	    	existing.setStableCasaToAssets(updatedData.getStableCasaToAssets());
	    	existing.setVolatileCasaToAssets(updatedData.getVolatileCasaToAssets());
	    	existing.setLiquidAssetsToTotalDeposits(updatedData.getLiquidAssetsToTotalDeposits());
	    	existing.setLiquidAssetsToTotalCasa(updatedData.getLiquidAssetsToTotalCasa());
	    	existing.setSixMonthCashFlowGapAed(updatedData.getSixMonthCashFlowGapAed());
	    	existing.setTotalLiabilitiesExclCapital(updatedData.getTotalLiabilitiesExclCapital());
	    	existing.setSixMonthGapRatio(updatedData.getSixMonthGapRatio());
	    	existing.setAedSixMonthCashFlowGap(updatedData.getAedSixMonthCashFlowGap());
	    	existing.setAedLiabilitiesExclCapital(updatedData.getAedLiabilitiesExclCapital());
	    	existing.setAedSixMonthGapRatio(updatedData.getAedSixMonthGapRatio());
	    	existing.setUsdSixMonthCashFlowGap(updatedData.getUsdSixMonthCashFlowGap());
	    	existing.setUsdLiabilitiesExclCapital(updatedData.getUsdLiabilitiesExclCapital());
	    	existing.setUsdSixMonthGapRatio(updatedData.getUsdSixMonthGapRatio());
	    	existing.setThreeMonthCashFlowGapAed(updatedData.getThreeMonthCashFlowGapAed());
	    	existing.setThreeMonthGapRatio(updatedData.getThreeMonthGapRatio());
	    	existing.setOneMonthCashFlowGapAed(updatedData.getOneMonthCashFlowGapAed());
	    	existing.setOneMonthGapRatio(updatedData.getOneMonthGapRatio());
	    	existing.setSevenDayCashFlowGapAed(updatedData.getSevenDayCashFlowGapAed());
	    	existing.setSevenDayGapRatio(updatedData.getSevenDayGapRatio());
	    	existing.setUnencumberedLiquidAssetsAed(updatedData.getUnencumberedLiquidAssetsAed());
	    	existing.setOneMonthCashFlowGapCopy(updatedData.getOneMonthCashFlowGapCopy());
	    	existing.setUnencumberedTo1mGapRatio(updatedData.getUnencumberedTo1mGapRatio());
	    	existing.setCbuaeCashBalances(updatedData.getCbuaeCashBalances());
	    	existing.setCbuaeCashBalancesPercent(updatedData.getCbuaeCashBalancesPercent());
	    	existing.setMoneyMktPlacementsLt6m(updatedData.getMoneyMktPlacementsLt6m());
	    	existing.setMoneyMktPlacementsLt6mPercent(updatedData.getMoneyMktPlacementsLt6mPercent());
	    	existing.setLocalCurrencyGovtBonds(updatedData.getLocalCurrencyGovtBonds());
	    	existing.setLocalCurrencyGovtBondsPercent(updatedData.getLocalCurrencyGovtBondsPercent());
	    	existing.setHardCurrencyGovtBonds(updatedData.getHardCurrencyGovtBonds());
	    	existing.setHardCurrencyGovtBondsPercent(updatedData.getHardCurrencyGovtBondsPercent());
	    	existing.setForeignGovtBonds(updatedData.getForeignGovtBonds());
	    	existing.setForeignGovtBondsPercent(updatedData.getForeignGovtBondsPercent());
	    	existing.setPledgeSecurities(updatedData.getPledgeSecurities());
	    	existing.setTotalPledgeableSecurities(updatedData.getTotalPledgeableSecurities());
	    	existing.setPledgeRatio(updatedData.getPledgeRatio());
	    	existing.setTotalComplexFinInstruments(updatedData.getTotalComplexFinInstruments());
	    	existing.setTotalTradableAssets(updatedData.getTotalTradableAssets());
	    	existing.setComplexToTradableRatio(updatedData.getComplexToTradableRatio());
	    	existing.setTop10Deposits(updatedData.getTop10Deposits());
	    	existing.setTotalDepositsAed1(updatedData.getTotalDepositsAed1());
	    	existing.setTop10ToTotalRatio(updatedData.getTop10ToTotalRatio());
	    	existing.setStIbBorrowingLt3m(updatedData.getStIbBorrowingLt3m());
	    	existing.setStRepoLt3m(updatedData.getStRepoLt3m());
	    	existing.setInterbankBorrowing(updatedData.getInterbankBorrowing());
	    	existing.setRepoAgreements(updatedData.getRepoAgreements());
	    	existing.setTotalDepositsAed2(updatedData.getTotalDepositsAed2());
	    	existing.setLongTermFundingCopy(updatedData.getLongTermFundingCopy());
	    	existing.setStIbRepoToTotalFundingRatio(updatedData.getStIbRepoToTotalFundingRatio());
	    	existing.setLargestSingleDepositor(updatedData.getLargestSingleDepositor());
	    	existing.setIndividualCounterpartyToTotalFundingRatio(updatedData.getIndividualCounterpartyToTotalFundingRatio());
	    	existing.setUnutilizedLoansCreditLines(updatedData.getUnutilizedLoansCreditLines());
	    	existing.setDerivativesExpectedNegExposure(updatedData.getDerivativesExpectedNegExposure());
	    	existing.setDerivativesExpectedNegExposureProxy(updatedData.getDerivativesExpectedNegExposureProxy());
	    	existing.setContingentLiabilities(updatedData.getContingentLiabilities());
	    	existing.setContingentLiabilitiesToTotalFundingRatio(updatedData.getContingentLiabilitiesToTotalFundingRatio());
	    	existing.setTop5IndustryDeposits(updatedData.getTop5IndustryDeposits());
	    	existing.setTop5ToTotalDepositsRatio(updatedData.getTop5ToTotalDepositsRatio());
	    	existing.setLongTermLiabilitiesToTotalLiabilitiesRatio(updatedData.getLongTermLiabilitiesToTotalLiabilitiesRatio());



			List<String> ignoreFields = Arrays.asList("createUser", "modifyUser", "delFlg");

			Map<String, String> changes = new LinkedHashMap<>();

			for (Field field : RT_Liquidity_Risk_Dashboard_Template.class.getDeclaredFields()) {
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
			

	        LiquidityRiskDashboardRepo.save(existing);
	        

	        System.out.println("changes : "+changes);

	        // Audit only if any field was changed
	        if (!changes.isEmpty()) {
	            auditservice.createBusinessAudit(
	            		updatedData.getSI_NO(),           // Unique ID
	                "MODIFY",                             // Action
	                "LIQUIDITY_RISK_DASHBOARD_EDIT_SCREEN",                  // Screen name
	                changes,                              // Changed fields map
	                "BCBUAE_LIQUIDITY_RISK_DASHBOARD_TEMPLATE"              // Table name
	            );
	        }
	        
	        return true;
	    } else {
	        System.out.println("No record found for SI_NO: " + updatedData.getSI_NO());
	        return false;
	    }
	}



	public byte[] generateLiquidityriskdashboardExcel(String report_date) throws Exception {
        logger.info("Service: Starting MM Excel generation process in memory.");

        List<Object[]> liquidityriskdashboard = LiquidityRiskDashboardRepo.getliquidityriskdashboarddata1(report_date);

        if (liquidityriskdashboard.isEmpty()) {
            logger.warn("Service: No data found for LRD report. Returning empty result.");
            return new byte[0];
        }

        String templateDir = env.getProperty("output.exportpathtemp");  // Corrected property key
        String templateFileName = "CBUAE_Liquidity_Risk_Dashboard_Template.xlsx";
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
                sheet = workbook.getSheetAt(3);
            }
            CreationHelper createHelper = workbook.getCreationHelper();

            // Define cell styles
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

            // Data sheet rows 1-2 are headers. Values are written from row 3.
            // Grey cells and any cell that already has a formula are left unchanged.
            int startRow = 2;
            Row templateRow = sheet.getRow(startRow);

            if (!liquidityriskdashboard.isEmpty()) {
                for (int i = 0; i < liquidityriskdashboard.size(); i++) {
                    Object[] lrd = liquidityriskdashboard.get(i);
                    Row row = sheet.getRow(startRow + i);
                    if (row == null) {
                        row = sheet.createRow(startRow + i);
                    }
                    int lastCol = Math.min(lrd.length, 157);
                    for (int col = 0; col < lastCol; col++) {
                        if (isAutomaticLiquidityCell(templateRow, row, col)) {
                            preserveLiquidityFormula(templateRow, row, col);
                            continue;
                        }
                        writeLiquidityInputCell(row, col, lrd[col], dateStyle, numberStyle);
                    }
                }
             // Auto-size all columns
				for (int i = 0; i <= 156; i++) {
				    sheet.autoSizeColumn(i);
				}
			workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
		} else {
			System.out.println("No Mm data found to generate the Excel file.");
		}

		// Write the final workbook content to the in-memory stream.
		workbook.write(out);

		String finalPath = env.getProperty("output.exportpathfinal"); // e.g. finaltemp path
        File outputFile = new File(finalPath + "CBUAE_Liquidity_Risk_Dashboard_Template.xlsx");
        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            fos.write(out.toByteArray());
            logger.info("Service: Excel also saved to file: {}", outputFile.getAbsolutePath());
        }

        logger.info("Service: CCR DATA Excel data successfully written to memory buffer ({} bytes).", out.size());
        return out.toByteArray();
	}
}

	/**
	 * Skip grey shaded cells and cells that already contain a formula.
	 * Fully white input cells are filled from the database.
	 */
	private boolean isAutomaticLiquidityCell(Row templateRow, Row row, int col) {
		Cell target = row.getCell(col);
		if (target != null && (isGreyFill(target) || target.getCellTypeEnum() == CellType.FORMULA)) {
			return true;
		}
		Cell templateCell = templateRow == null ? null : templateRow.getCell(col);
		if (templateCell == null) {
			return false;
		}
		return isGreyFill(templateCell) || templateCell.getCellTypeEnum() == CellType.FORMULA;
	}

	private void preserveLiquidityFormula(Row templateRow, Row row, int col) {
		if (templateRow == null || row.getRowNum() == templateRow.getRowNum()) {
			return;
		}
		Cell target = row.getCell(col);
		if (target != null && target.getCellTypeEnum() == CellType.FORMULA) {
			return;
		}
		Cell templateCell = templateRow.getCell(col);
		if (templateCell == null || templateCell.getCellTypeEnum() != CellType.FORMULA) {
			return;
		}
		if (target == null) {
			target = row.createCell(col);
		}
		if (templateCell.getCellStyle() != null) {
			target.setCellStyle(templateCell.getCellStyle());
		}
		int fromExcelRow = templateRow.getRowNum() + 1;
		int toExcelRow = row.getRowNum() + 1;
		target.setCellFormula(adjustFormulaRow(templateCell.getCellFormula(), fromExcelRow, toExcelRow));
	}

	private void writeLiquidityInputCell(Row row, int col, Object value, CellStyle dateStyle, CellStyle numberStyle) {
		Cell cell = row.getCell(col);
		if (cell == null) {
			cell = row.createCell(col);
		}
		if (col == 0) {
			cell.setCellStyle(dateStyle);
			if (value instanceof Date) {
				cell.setCellValue((Date) value);
			} else {
				cell.setCellValue("");
			}
			return;
		}
		if (col <= 7) {
			cell.setCellValue(value == null ? "" : value.toString());
			return;
		}
		cell.setCellStyle(numberStyle);
		BigDecimal number = toBigDecimal(value);
		cell.setCellValue(number == null ? 0 : number.doubleValue());
	}

	public List<RT_Liquidity_Risk_Dashboard_Template> findByReportDate(String reportDate) {
		if (reportDate == null || reportDate.trim().isEmpty()) {
			return new ArrayList<RT_Liquidity_Risk_Dashboard_Template>();
		}
		String sql = "SELECT * FROM BCBUAE_LIQUIDITY_RISK_DASHBOARD_TEMPLATE WHERE REPORT_DATE = TO_DATE(?, 'DD-MM-YYYY')";
		List<RT_Liquidity_Risk_Dashboard_Template> rows = jdbcTemplate.query(sql, new Object[] { reportDate.trim() },
				(rs, rowNum) -> mapLiquidityRow(rs));
		return rows == null ? new ArrayList<RT_Liquidity_Risk_Dashboard_Template>() : rows;
	}

	public RT_Liquidity_Risk_Dashboard_Template findBySiNo(String siNo) {
		if (siNo == null || siNo.trim().isEmpty()) {
			return null;
		}
		String sql = "SELECT * FROM BCBUAE_LIQUIDITY_RISK_DASHBOARD_TEMPLATE WHERE SI_NO = ?";
		List<RT_Liquidity_Risk_Dashboard_Template> rows = jdbcTemplate.query(sql, new Object[] { siNo.trim() },
				(rs, rowNum) -> mapLiquidityRow(rs));
		return rows == null || rows.isEmpty() ? null : rows.get(0);
	}

	private static Map<String, Field> liquidityColumns() {
		Map<String, Field> columns = new LinkedHashMap<String, Field>();
		for (Field field : RT_Liquidity_Risk_Dashboard_Template.class.getDeclaredFields()) {
			field.setAccessible(true);
			Column column = field.getAnnotation(Column.class);
			String name = column != null && column.name() != null && !column.name().isEmpty()
					? column.name()
					: field.getName();
			columns.put(name.toUpperCase(Locale.ENGLISH), field);
		}
		return Collections.unmodifiableMap(columns);
	}

	private RT_Liquidity_Risk_Dashboard_Template mapLiquidityRow(ResultSet rs) throws SQLException {
		RT_Liquidity_Risk_Dashboard_Template row = new RT_Liquidity_Risk_Dashboard_Template();
		ResultSetMetaData meta = rs.getMetaData();
		for (int i = 1; i <= meta.getColumnCount(); i++) {
			String label = meta.getColumnLabel(i);
			if (label == null) {
				continue;
			}
			Field field = LIQUIDITY_COLUMNS.get(label.toUpperCase(Locale.ENGLISH));
			if (field == null) {
				continue;
			}
			try {
				field.set(row, readLiquidityValue(rs, i, field.getType(), label));
			} catch (IllegalAccessException ex) {
				throw new SQLException("Unable to read column " + label, ex);
			}
		}
		return row;
	}

	private Object readLiquidityValue(ResultSet rs, int index, Class<?> type, String column) throws SQLException {
		if (BigDecimal.class.equals(type)) {
			return toBigDecimal(rs.getString(index), column);
		}
		if (String.class.equals(type)) {
			return rs.getString(index);
		}
		if (Date.class.isAssignableFrom(type)) {
			return rs.getTimestamp(index);
		}
		return rs.getObject(index);
	}

	private BigDecimal toBigDecimal(Object raw) {
		return toBigDecimal(raw == null ? null : raw.toString(), null);
	}

	private BigDecimal toBigDecimal(String raw, String column) {
		if (raw == null) {
			return null;
		}
		String text = raw.trim().replace(",", "");
		if (text.isEmpty()) {
			return null;
		}
		try {
			return new BigDecimal(text);
		} catch (NumberFormatException ex) {
			logger.warn("Liquidity column {} contains non-numeric value [{}]; leaving it blank.", column, text);
			return null;
		}
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

	private String adjustFormulaRow(String formula, int fromExcelRow, int toExcelRow) {
		if (formula == null || fromExcelRow == toExcelRow) {
			return formula;
		}
		return formula.replaceAll("(\\$?[A-Z]{1,3})(\\$?)" + fromExcelRow + "(?!\\d)", "$1$2" + toExcelRow);
	}
}
