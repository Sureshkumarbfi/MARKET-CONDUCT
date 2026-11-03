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

import com.bornfire.xbrl.entities.RT_Investment_Securities_Data_Template;
import com.bornfire.xbrl.entities.RT_Investment_Securities_Data_Template_Repo;
import com.bornfire.xbrl.entities.RT_Liquidity_Risk_Data_Template;

@Service
public class RT_InvestmentSecurity_Service {

	private static final Logger logger = LoggerFactory.getLogger(RT_InvestmentSecurity_Service.class);

	@Autowired
	RT_Investment_Securities_Data_Template_Repo investmentSecuritiesRepo;

	@Autowired
	private Environment env;

	@Autowired
	AuditService auditService;

	// Update existing record
	public boolean updateInvestmentSecurity(RT_Investment_Securities_Data_Template updatedEntity) {
		Optional<RT_Investment_Securities_Data_Template> existingOpt = investmentSecuritiesRepo
				.findById(updatedEntity.getSiNo());

		if (existingOpt.isPresent()) {
			RT_Investment_Securities_Data_Template existing = existingOpt.get();
			
			RT_Investment_Securities_Data_Template dbUser = new RT_Investment_Securities_Data_Template();
			org.springframework.beans.BeanUtils.copyProperties(existing, dbUser);

			// Copy all fields
			existing.setDataDate(updatedEntity.getDataDate());
			existing.setBankName(updatedEntity.getBankName());
			existing.setHeadOfficeSubsidiary(updatedEntity.getHeadOfficeSubsidiary());
			existing.setSubsidiary(updatedEntity.getSubsidiary());
			existing.setBankSymbol(updatedEntity.getBankSymbol());
			existing.setConventionalIslamic(updatedEntity.getConventionalIslamic());
			existing.setLocalForeign(updatedEntity.getLocalForeign());
			existing.setCbuAeTiering(updatedEntity.getCbuAeTiering());
			existing.setAccountingClassification(updatedEntity.getAccountingClassification());
			existing.setInstrumentType(updatedEntity.getInstrumentType());
			existing.setInstrumentSubcategoryType(updatedEntity.getInstrumentSubcategoryType());
			existing.setIsinCode(updatedEntity.getIsinCode());
			existing.setBankInternalPortfolioCode(updatedEntity.getBankInternalPortfolioCode());
			existing.setCbuAeSecurityId(updatedEntity.getCbuAeSecurityId());
			existing.setCbuAeAccessPrimaryKey(updatedEntity.getCbuAeAccessPrimaryKey());
			existing.setSecurityDescription(updatedEntity.getSecurityDescription());
			existing.setAssetCurrency(updatedEntity.getAssetCurrency());
			existing.setObligor(updatedEntity.getObligor());
			existing.setCountryOfRisk(updatedEntity.getCountryOfRisk());
			existing.setCbuAeGeographicalZone(updatedEntity.getCbuAeGeographicalZone());
			existing.setIndustry(updatedEntity.getIndustry());
			existing.setSector(updatedEntity.getSector());
			existing.setIssuerType(updatedEntity.getIssuerType());
			existing.setIssueSize(updatedEntity.getIssueSize());
			existing.setPercentIssueSize(updatedEntity.getPercentIssueSize());
			existing.setNominalTradeCurrency(updatedEntity.getNominalTradeCurrency());
			existing.setNominalAedEquivalent(updatedEntity.getNominalAedEquivalent());
			existing.setPremDiscAedEquivalent(updatedEntity.getPremDiscAedEquivalent());
			existing.setSpecificProvisionAed(updatedEntity.getSpecificProvisionAed());
			existing.setFixedIncomeInfoNetBookPrice(updatedEntity.getFixedIncomeInfoNetBookPrice());
			existing.setNetBookValueAed(updatedEntity.getNetBookValueAed());
			existing.setPurchaseYieldToMaturity(updatedEntity.getPurchaseYieldToMaturity());
			existing.setCleanPrice(updatedEntity.getCleanPrice());
			existing.setCleanMarketValueAed(updatedEntity.getCleanMarketValueAed());
			existing.setCurrentYieldToMaturity(updatedEntity.getCurrentYieldToMaturity());
			existing.setUnrealizedGainLossAed(updatedEntity.getUnrealizedGainLossAed());
			existing.setSubordinatedDebtSukuk(updatedEntity.getSubordinatedDebtSukuk());
			existing.setFinalRatingBanks(updatedEntity.getFinalRatingBanks());
			existing.setFinalRatingCbuae(updatedEntity.getFinalRatingCbuae());
			existing.setCreditQuality(updatedEntity.getCreditQuality());
			existing.setMaturityDate(updatedEntity.getMaturityDate());
			existing.setResidualMaturity(updatedEntity.getResidualMaturity());
			existing.setMaturityPeriod(updatedEntity.getMaturityPeriod());
			existing.setPercentHoldingsFi(updatedEntity.getPercentHoldingsFi());
			existing.setQtyEquityFunds(updatedEntity.getQtyEquityFunds());
			existing.setEquityFloatingFundAssets(updatedEntity.getEquityFloatingFundAssets());
			existing.setTotalFloatingShareFundAum(updatedEntity.getTotalFloatingShareFundAum());
			existing.setSpecificProvision(updatedEntity.getSpecificProvision());
			existing.setNetBookValue(updatedEntity.getNetBookValue());
			existing.setOtherSecInfoNetBookPrice(updatedEntity.getOtherSecInfoNetBookPrice());
			existing.setMarketPrice(updatedEntity.getMarketPrice());
			existing.setFairValueAmountAed(updatedEntity.getFairValueAmountAed());
			existing.setUnrealizedGainLossAgain(updatedEntity.getUnrealizedGainLossAgain());
			existing.setPercentHoldingsOther(updatedEntity.getPercentHoldingsOther());
			existing.setTotalNetBookValueAed(updatedEntity.getTotalNetBookValueAed());
			existing.setTotalMarketValueAed(updatedEntity.getTotalMarketValueAed());
			existing.setTotalUnrealizedGainLoss(updatedEntity.getTotalUnrealizedGainLoss());
			existing.setUnrealizedGainLossContrib(updatedEntity.getUnrealizedGainLossContrib());
			existing.setPercentHoldings(updatedEntity.getPercentHoldings());
			existing.setExistingPledgeStatus(updatedEntity.getExistingPledgeStatus());
			existing.setPledgedAmountAed(updatedEntity.getPledgedAmountAed());
			existing.setUnencumberedAmountAed(updatedEntity.getUnencumberedAmountAed());
			existing.setProportionUnencumbered(updatedEntity.getProportionUnencumbered());
			existing.setHqlaElarEligibility(updatedEntity.getHqlaElarEligibility());
			existing.setLiquidityType(updatedEntity.getLiquidityType());
			existing.setSukukType(updatedEntity.getSukukType());
			existing.setTtcPd(updatedEntity.getTtcPd());
			existing.setPitPd(updatedEntity.getPitPd());
			existing.setEcl1y(updatedEntity.getEcl1y());
			existing.setEclLifetime(updatedEntity.getEclLifetime());
			existing.setEclFinal(updatedEntity.getEclFinal());
			existing.setIfrs9Staging(updatedEntity.getIfrs9Staging());
			existing.setBankCoreTier1CapitalAed(updatedEntity.getBankCoreTier1CapitalAed());

			existing.setReportSubmitDate(updatedEntity.getReportSubmitDate());



            List<String> ignoreFields = Arrays.asList("createUser", "modifyUser", "delFlg");

			Map<String, String> changes = new LinkedHashMap<>();

			for (Field field : RT_Investment_Securities_Data_Template.class.getDeclaredFields()) {
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
			
			
			investmentSecuritiesRepo.save(existing);

			 System.out.println("changes : "+changes);

		        // Audit only if any field was changed
		        if (!changes.isEmpty()) {
		        	auditService.createBusinessAudit(
		        			updatedEntity.getSiNo(),           // Unique ID
		                "MODIFY",                             // Action
		                "INVESTMENT_SECURITIES_DATA_EDIT_SCREEN",                  // Screen name
		                changes,                              // Changed fields map
		                "BCBUAE_INVESTMENT_SECURITIES_DATA"              // Table name
		            );
		        }
			return true;
		} else {
			return false;
		}
	}

	public byte[] generateInvestmentSecuritiesExcel(Date Report_date) throws Exception {
		logger.info("Service: Starting Investment Securities Excel generation process in memory.");

		List<RT_Investment_Securities_Data_Template> dataList = investmentSecuritiesRepo.getlist(Report_date);

		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for Investment Securities report. Returning empty result.");
			return new byte[0];
		}

		String templateDir = env.getProperty("output.exportpathtemp");
		String templateFileName = "CBUAE_Investment_Securities_Data_Template_Pillar2.xlsx";
		Path templatePath = Paths.get(templateDir, templateFileName);

		logger.info("Service: Attempting to load template from path: {}", templatePath.toAbsolutePath());

		if (!Files.exists(templatePath)) {
			throw new FileNotFoundException("Template file not found at: " + templatePath.toAbsolutePath());
		}
		if (!Files.isReadable(templatePath)) {
			throw new SecurityException(
					"Template file is not readable (check permissions): " + templatePath.toAbsolutePath());
		}

		try (InputStream templateInputStream = Files.newInputStream(templatePath);
				Workbook workbook = WorkbookFactory.create(templateInputStream);
				ByteArrayOutputStream out = new ByteArrayOutputStream()) {

			Sheet sheet = workbook.getSheet("Securities");

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

			CellStyle percentStyle = workbook.createCellStyle();
			percentStyle.setDataFormat(createHelper.createDataFormat().getFormat("0.00%"));
			percentStyle.setBorderBottom(BorderStyle.THIN);
			percentStyle.setBorderTop(BorderStyle.THIN);
			percentStyle.setBorderLeft(BorderStyle.THIN);
			percentStyle.setBorderRight(BorderStyle.THIN);

			// YTM values are stored as 3.88 (already a percent), not 0.0388.
			// Excel 0.00% would display 3.88 as 388.00%; keep the stored number and append %.
			CellStyle ytmPercentStyle = workbook.createCellStyle();
			ytmPercentStyle.setDataFormat(createHelper.createDataFormat().getFormat("0.00\"%\""));
			ytmPercentStyle.setBorderBottom(BorderStyle.THIN);
			ytmPercentStyle.setBorderTop(BorderStyle.THIN);
			ytmPercentStyle.setBorderLeft(BorderStyle.THIN);
			ytmPercentStyle.setBorderRight(BorderStyle.THIN);

			int startRow = 4;

			for (int i = 0; i < dataList.size(); i++) {
				RT_Investment_Securities_Data_Template record = dataList.get(i);
				Row row = sheet.getRow(startRow + i);
				if (row == null)
					row = sheet.createRow(startRow + i);

				// Write every stored column. Grey template cells are overwritten with
				// database values; they are not left blank for a formula.

				Cell cell0 = valueCell(row, 0);
				if (record.getDataDate() != null) {
					cell0.setCellValue(record.getDataDate());
					cell0.setCellStyle(dateStyle);
				} else {
					cell0.setCellValue("");
					cell0.setCellStyle(textStyle);
				}
				Cell cell1 = valueCell(row, 1);
				cell1.setCellValue(record.getBankName() != null ? record.getBankName() : "");
				cell1.setCellStyle(textStyle);
				Cell cell2 = valueCell(row, 2);
				cell2.setCellValue(record.getHeadOfficeSubsidiary() != null ? record.getHeadOfficeSubsidiary() : "");
				cell2.setCellStyle(textStyle);
				Cell cell3 = valueCell(row, 3);
				cell3.setCellValue(record.getSubsidiary() != null ? record.getSubsidiary() : "");
				cell3.setCellStyle(textStyle);
				Cell cell4 = valueCell(row, 4);
				cell4.setCellValue(record.getBankSymbol() != null ? record.getBankSymbol() : "");
				cell4.setCellStyle(textStyle);
				Cell cell5 = valueCell(row, 5);
				cell5.setCellValue(record.getConventionalIslamic() != null ? record.getConventionalIslamic() : "");
				cell5.setCellStyle(textStyle);
				Cell cell6 = valueCell(row, 6);
				cell6.setCellValue(record.getLocalForeign() != null ? record.getLocalForeign() : "");
				cell6.setCellStyle(textStyle);
				Cell cell7 = valueCell(row, 7);
				cell7.setCellValue(record.getCbuAeTiering() != null ? record.getCbuAeTiering() : "");
				cell7.setCellStyle(textStyle);
				Cell cell8 = valueCell(row, 8);
				cell8.setCellValue(
						record.getAccountingClassification() != null ? record.getAccountingClassification() : "");
				cell8.setCellStyle(textStyle);
				Cell cell9 = valueCell(row, 9);
				cell9.setCellValue(record.getInstrumentType() != null ? record.getInstrumentType() : "");
				cell9.setCellStyle(textStyle);
				Cell cell10 = valueCell(row, 10);
				cell10.setCellValue(
						record.getInstrumentSubcategoryType() != null ? record.getInstrumentSubcategoryType() : "");
				cell10.setCellStyle(textStyle);
				Cell cell11 = valueCell(row, 11);
				cell11.setCellValue(record.getIsinCode() != null ? record.getIsinCode() : "");
				cell11.setCellStyle(textStyle);
				Cell cell12 = valueCell(row, 12);
				cell12.setCellValue(
						record.getBankInternalPortfolioCode() != null ? record.getBankInternalPortfolioCode() : "");
				cell12.setCellStyle(textStyle);
				Cell cell13 = valueCell(row, 13);
				cell13.setCellValue(record.getCbuAeSecurityId() != null ? record.getCbuAeSecurityId() : "");
				cell13.setCellStyle(textStyle);
				Cell cell14 = valueCell(row, 14);
				cell14.setCellValue(record.getCbuAeAccessPrimaryKey() != null ? record.getCbuAeAccessPrimaryKey() : "");
				cell14.setCellStyle(textStyle);
				Cell cell15 = valueCell(row, 15);
				cell15.setCellValue(record.getSecurityDescription() != null ? record.getSecurityDescription() : "");
				cell15.setCellStyle(textStyle);
				Cell cell16 = valueCell(row, 16);
				cell16.setCellValue(record.getAssetCurrency() != null ? record.getAssetCurrency() : "");
				cell16.setCellStyle(textStyle);
				Cell cell17 = valueCell(row, 17);
				cell17.setCellValue(record.getObligor() != null ? record.getObligor() : "");
				cell17.setCellStyle(textStyle);
				Cell cell18 = valueCell(row, 18);
				cell18.setCellValue(record.getCountryOfRisk() != null ? record.getCountryOfRisk() : "");
				cell18.setCellStyle(textStyle);
				Cell cell19 = valueCell(row, 19);
				cell19.setCellValue(record.getCbuAeGeographicalZone() != null ? record.getCbuAeGeographicalZone() : "");
				cell19.setCellStyle(textStyle);
				Cell cell20 = valueCell(row, 20);
				cell20.setCellValue(record.getIndustry() != null ? record.getIndustry() : "");
				cell20.setCellStyle(textStyle);
				Cell cell21 = valueCell(row, 21);
				cell21.setCellValue(record.getSector() != null ? record.getSector() : "");
				cell21.setCellStyle(textStyle);
				Cell cell22 = valueCell(row, 22);
				cell22.setCellValue(record.getIssuerType() != null ? record.getIssuerType() : "");
				cell22.setCellStyle(textStyle);
				Cell cell23 = valueCell(row, 23);
				cell23.setCellValue(record.getIssueSize() != null ? record.getIssueSize().doubleValue() : 0.0);
				cell23.setCellStyle(numberStyle);
				Cell cell24 = valueCell(row, 24);
				cell24.setCellValue(
						record.getPercentIssueSize() != null ? record.getPercentIssueSize().doubleValue() : 0.0);
				cell24.setCellStyle(percentStyle);
				Cell cell25 = valueCell(row, 25);
				cell25.setCellValue(
						record.getNominalTradeCurrency() != null ? record.getNominalTradeCurrency().doubleValue()
								: 0.0);
				cell25.setCellStyle(numberStyle);
				Cell cell26 = valueCell(row, 26);
				cell26.setCellValue(
						record.getNominalAedEquivalent() != null ? record.getNominalAedEquivalent().doubleValue()
								: 0.0);
				cell26.setCellStyle(numberStyle);
				Cell cell27 = valueCell(row, 27);
				cell27.setCellValue(
						record.getPremDiscAedEquivalent() != null ? record.getPremDiscAedEquivalent().doubleValue()
								: 0.0);
				cell27.setCellStyle(numberStyle);
				Cell cell28 = valueCell(row, 28);
				cell28.setCellValue(
						record.getSpecificProvisionAed() != null ? record.getSpecificProvisionAed().doubleValue()
								: 0.0);
				cell28.setCellStyle(numberStyle);
				Cell cell29 = valueCell(row, 29);
				cell29.setCellValue(record.getFixedIncomeInfoNetBookPrice() != null
						? record.getFixedIncomeInfoNetBookPrice().doubleValue()
						: 0.0);
				cell29.setCellStyle(numberStyle);
				Cell cell30 = valueCell(row, 30);
				cell30.setCellValue(
						record.getNetBookValueAed() != null ? record.getNetBookValueAed().doubleValue() : 0.0);
				cell30.setCellStyle(numberStyle);
				Cell cell31 = valueCell(row, 31);
				cell31.setCellValue(
						record.getPurchaseYieldToMaturity() != null ? record.getPurchaseYieldToMaturity().doubleValue()
								: 0.0);
				cell31.setCellStyle(ytmPercentStyle);
				Cell cell32 = valueCell(row, 32);
				cell32.setCellValue(record.getCleanPrice() != null ? record.getCleanPrice().doubleValue() : 0.0);
				cell32.setCellStyle(numberStyle);
				Cell cell33 = valueCell(row, 33);
				cell33.setCellValue(
						record.getCleanMarketValueAed() != null ? record.getCleanMarketValueAed().doubleValue() : 0.0);
				cell33.setCellStyle(numberStyle);
				Cell cell34 = valueCell(row, 34);
				cell34.setCellValue(
						record.getCurrentYieldToMaturity() != null ? record.getCurrentYieldToMaturity().doubleValue()
								: 0.0);
				cell34.setCellStyle(ytmPercentStyle);
				Cell cell35 = valueCell(row, 35);
				cell35.setCellValue(
						record.getUnrealizedGainLossAed() != null ? record.getUnrealizedGainLossAed().doubleValue()
								: 0.0);
				cell35.setCellStyle(numberStyle);
				Cell cell36 = valueCell(row, 36);
				cell36.setCellValue(record.getSubordinatedDebtSukuk() != null ? record.getSubordinatedDebtSukuk() : "");
				cell36.setCellStyle(textStyle);
				Cell cell37 = valueCell(row, 37);
				cell37.setCellValue(record.getFinalRatingBanks() != null ? record.getFinalRatingBanks() : "");
				cell37.setCellStyle(textStyle);
				Cell cell38 = valueCell(row, 38);
				cell38.setCellValue(record.getFinalRatingCbuae() != null ? record.getFinalRatingCbuae() : "");
				cell38.setCellStyle(textStyle);
				Cell cell39 = valueCell(row, 39);
				cell39.setCellValue(record.getCreditQuality() != null ? record.getCreditQuality() : "");
				cell39.setCellStyle(textStyle);
				Cell cell40 = valueCell(row, 40);
				if (record.getMaturityDate() != null) {
					cell40.setCellValue(record.getMaturityDate());
					cell40.setCellStyle(dateStyle);
				} else {
					cell40.setCellValue("");
					cell40.setCellStyle(textStyle);
				}
				Cell cell41 = valueCell(row, 41);
				cell41.setCellValue(record.getResidualMaturity() != null ? record.getResidualMaturity().doubleValue() : 0.00);
				cell41.setCellStyle(textStyle);
				Cell cell42 = valueCell(row, 42);
				cell42.setCellValue(record.getMaturityPeriod() != null ? record.getMaturityPeriod() : "");
				cell42.setCellStyle(textStyle);
				Cell cell43 = valueCell(row, 43);
				cell43.setCellValue(
						record.getPercentHoldingsFi() != null ? record.getPercentHoldingsFi().doubleValue() : 0.0);
				cell43.setCellStyle(percentStyle);
				Cell cell44 = valueCell(row, 44);
				cell44.setCellValue(
						record.getQtyEquityFunds() != null ? record.getQtyEquityFunds().doubleValue() : 0.0);
				cell44.setCellStyle(numberStyle);
				Cell cell45 = valueCell(row, 45);
				cell45.setCellValue(record.getEquityFloatingFundAssets() != null
						? record.getEquityFloatingFundAssets().doubleValue()
						: 0.0);
				cell45.setCellStyle(numberStyle);
				Cell cell46 = valueCell(row, 46);
				cell46.setCellValue(record.getTotalFloatingShareFundAum() != null
						? record.getTotalFloatingShareFundAum().doubleValue()
						: 0.0);
				cell46.setCellStyle(percentStyle);
				Cell cell47 = valueCell(row, 47);
				cell47.setCellValue(
						record.getSpecificProvision() != null ? record.getSpecificProvision().doubleValue() : 0.0);
				cell47.setCellStyle(numberStyle);
				Cell cell48 = valueCell(row, 48);
				cell48.setCellValue(record.getNetBookValue() != null ? record.getNetBookValue().doubleValue() : 0.0);
				cell48.setCellStyle(numberStyle);
				Cell cell49 = valueCell(row, 49);
				cell49.setCellValue(record.getOtherSecInfoNetBookPrice() != null
						? record.getOtherSecInfoNetBookPrice().doubleValue()
						: 0.0);
				cell49.setCellStyle(numberStyle);
				Cell cell50 = valueCell(row, 50);
				cell50.setCellValue(record.getMarketPrice() != null ? record.getMarketPrice().doubleValue() : 0.0);
				cell50.setCellStyle(numberStyle);
				Cell cell51 = valueCell(row, 51);
				cell51.setCellValue(
						record.getFairValueAmountAed() != null ? record.getFairValueAmountAed().doubleValue() : 0.0);
				cell51.setCellStyle(numberStyle);
				Cell cell52 = valueCell(row, 52);
				cell52.setCellValue(
						record.getUnrealizedGainLossAgain() != null ? record.getUnrealizedGainLossAgain().doubleValue()
								: 0.0);
				cell52.setCellStyle(numberStyle);
				Cell cell53 = valueCell(row, 53);
				cell53.setCellValue(
						record.getPercentHoldingsOther() != null ? record.getPercentHoldingsOther().doubleValue()
								: 0.0);
				cell53.setCellStyle(percentStyle);
				Cell cell54 = valueCell(row, 54);
				cell54.setCellValue(
						record.getTotalNetBookValueAed() != null ? record.getTotalNetBookValueAed().doubleValue()
								: 0.0);
				cell54.setCellStyle(numberStyle);
				Cell cell55 = valueCell(row, 55);
				cell55.setCellValue(
						record.getTotalMarketValueAed() != null ? record.getTotalMarketValueAed().doubleValue() : 0.0);
				cell55.setCellStyle(numberStyle);
				Cell cell56 = valueCell(row, 56);
				cell56.setCellValue(
						record.getTotalUnrealizedGainLoss() != null ? record.getTotalUnrealizedGainLoss().doubleValue()
								: 0.0);
				cell56.setCellStyle(numberStyle);
				Cell cell57 = valueCell(row, 57);
				cell57.setCellValue(record.getUnrealizedGainLossContrib() != null
						? record.getUnrealizedGainLossContrib().doubleValue()
						: 0.0);
				cell57.setCellStyle(percentStyle);
				Cell cell58 = valueCell(row, 58);
				cell58.setCellValue(
						record.getPercentHoldings() != null ? record.getPercentHoldings().doubleValue() : 0.0);
				cell58.setCellStyle(percentStyle);
				Cell cell59 = valueCell(row, 59);
				cell59.setCellValue(record.getExistingPledgeStatus() != null ? record.getExistingPledgeStatus() : "");
				cell59.setCellStyle(textStyle);
				Cell cell60 = valueCell(row, 60);
				cell60.setCellValue(
						record.getPledgedAmountAed() != null ? record.getPledgedAmountAed().doubleValue() : 0.0);
				cell60.setCellStyle(numberStyle);
				Cell cell61 = valueCell(row, 61);
				cell61.setCellValue(
						record.getUnencumberedAmountAed() != null ? record.getUnencumberedAmountAed().doubleValue()
								: 0.0);
				cell61.setCellStyle(numberStyle);
				Cell cell62 = valueCell(row, 62);
				cell62.setCellValue(
						record.getProportionUnencumbered() != null ? record.getProportionUnencumbered().doubleValue()
								: 0.0);
				cell62.setCellStyle(percentStyle);
				Cell cell63 = valueCell(row, 63);
				cell63.setCellValue(record.getHqlaElarEligibility() != null ? record.getHqlaElarEligibility() : "");
				cell63.setCellStyle(textStyle);
				Cell cell64 = valueCell(row, 64);
				cell64.setCellValue(record.getLiquidityType() != null ? record.getLiquidityType() : "");
				cell64.setCellStyle(textStyle);
				Cell cell65 = valueCell(row, 65);
				cell65.setCellValue(record.getSukukType() != null ? record.getSukukType() : "");
				cell65.setCellStyle(textStyle);
				Cell cell66 = valueCell(row, 66);
				cell66.setCellValue(record.getTtcPd() != null ? record.getTtcPd().doubleValue() : 0.0);
				cell66.setCellStyle(numberStyle);
				Cell cell67 = valueCell(row, 67);
				cell67.setCellValue(record.getPitPd() != null ? record.getPitPd().doubleValue() : 0.0);
				cell67.setCellStyle(numberStyle);
				Cell cell68 = valueCell(row, 68);
				cell68.setCellValue(record.getEcl1y() != null ? record.getEcl1y().doubleValue() : 0.0);
				cell68.setCellStyle(numberStyle);
				Cell cell69 = valueCell(row, 69);
				cell69.setCellValue(record.getEclLifetime() != null ? record.getEclLifetime().doubleValue() : 0.0);
				cell69.setCellStyle(numberStyle);
				Cell cell70 = valueCell(row, 70);
				cell70.setCellValue(record.getEclFinal() != null ? record.getEclFinal().doubleValue() : 0.0);
				cell70.setCellStyle(numberStyle);
				Cell cell71 = valueCell(row, 71);
				cell71.setCellValue(record.getIfrs9Staging() != null ? record.getIfrs9Staging() : "");
				cell71.setCellStyle(textStyle);

				Cell cell73 = valueCell(row, 73);
				cell73.setCellValue(
				    record.getBankCoreTier1CapitalAed() != null ? record.getBankCoreTier1CapitalAed().doubleValue() : 0.0);
				cell73.setCellStyle(numberStyle);


			}
			// Auto-size all columns
			for (int i = 0; i <= 73; i++) {
			    sheet.autoSizeColumn(i);
			}
			workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
			workbook.write(out);

			String finalPath = env.getProperty("output.exportpathfinal"); // e.g. finaltemp path
            File outputFile = new File(finalPath + "CBUAE_Investment_Securities_Data_Template_Pillar2.xlsx");
            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                fos.write(out.toByteArray());
                logger.info("Service: Excel also saved to file: {}", outputFile.getAbsolutePath());
            }

            logger.info("Service: INVESTMENT SECURITIES DATA DATA Excel data successfully written to memory buffer ({} bytes).", out.size());
            return out.toByteArray();
		}
	}

	/** Replace any template cell, including a grey formula cell, with a writable cell. */
	private Cell valueCell(Row row, int col) {
		Cell existing = row.getCell(col);
		if (existing != null) {
			row.removeCell(existing);
		}
		return row.createCell(col);
	}
}
