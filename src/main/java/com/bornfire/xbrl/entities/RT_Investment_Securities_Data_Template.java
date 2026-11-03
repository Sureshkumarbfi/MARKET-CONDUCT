package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BCBUAE_INVESTMENT_SECURITIES_DATA")
public class RT_Investment_Securities_Data_Template {

    @Id
    @Column(name = "SI_NO")
    private String siNo;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "DATA_DATE")
    private Date dataDate;

    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "HEAD_OFFICE_SUBSIDIARY")
    private String headOfficeSubsidiary;

    @Column(name = "SUBSIDIARY")
    private String subsidiary;

    @Column(name = "BANK_SYMBOL")
    private String bankSymbol;

    @Column(name = "CONVENTIONAL_ISLAMIC")
    private String conventionalIslamic;

    @Column(name = "LOCAL_FOREIGN")
    private String localForeign;

    @Column(name = "CBUAE_TIERING")
    private String cbuAeTiering;

    @Column(name = "ACCOUNTING_CLASSIFICATION")
    private String accountingClassification;

    @Column(name = "INSTRUMENT_TYPE")
    private String instrumentType;

    @Column(name = "INSTRUMENT_SUBCATEGORY_TYPE")
    private String instrumentSubcategoryType;

    @Column(name = "ISIN_CODE")
    private String isinCode;

    @Column(name = "BANK_INTERNAL_PORTFOLIO_CODE")
    private String bankInternalPortfolioCode;

    @Column(name = "CBUAE_SECURITY_ID")
    private String cbuAeSecurityId;

    @Column(name = "CBUAE_ACCESS_PRIMARY_KEY")
    private String cbuAeAccessPrimaryKey;

    @Column(name = "SECURITY_DESCRIPTION")
    private String securityDescription;

    @Column(name = "ASSET_CURRENCY")
    private String assetCurrency;

    @Column(name = "OBLIGOR")
    private String obligor;

    @Column(name = "COUNTRY_OF_RISK")
    private String countryOfRisk;

    @Column(name = "CBUAE_GEOGRAPHICAL_ZONE")
    private String cbuAeGeographicalZone;

    @Column(name = "INDUSTRY")
    private String industry;

    @Column(name = "SECTOR")
    private String sector;

    @Column(name = "ISSUER_TYPE")
    private String issuerType;

    @Column(name = "ISSUE_SIZE")
    private BigDecimal issueSize;

    @Column(name = "PERCENT_ISSUE_SIZE")
    private BigDecimal percentIssueSize;

    @Column(name = "NOMINAL_TRADE_CURRENCY")
    private BigDecimal nominalTradeCurrency;

    @Column(name = "NOMINAL_AED_EQUIVALENT")
    private BigDecimal nominalAedEquivalent;

    @Column(name = "PREM_DISC_AED_EQUIVALENT")
    private BigDecimal premDiscAedEquivalent;

    @Column(name = "SPECIFIC_PROVISION_AED")
    private BigDecimal specificProvisionAed;

    @Column(name = "FIXED_INCOME_INFO_NET_BOOK_PRICE")
    private BigDecimal fixedIncomeInfoNetBookPrice;

    @Column(name = "NET_BOOK_VALUE_AED")
    private BigDecimal netBookValueAed;

    @Column(name = "PURCHASE_YIELD_TO_MATURITY")
    private BigDecimal purchaseYieldToMaturity;

    @Column(name = "CLEAN_PRICE")
    private BigDecimal cleanPrice;

    @Column(name = "CLEAN_MARKET_VALUE_AED")
    private BigDecimal cleanMarketValueAed;

    @Column(name = "CURRENT_YIELD_TO_MATURITY")
    private BigDecimal currentYieldToMaturity;

    @Column(name = "UNREALIZED_GAIN_LOSS_AED")
    private BigDecimal unrealizedGainLossAed;

    @Column(name = "SUBORDINATED_DEBT_SUKUK")
    private String subordinatedDebtSukuk;

    @Column(name = "FINAL_RATING_BANKS")
    private String finalRatingBanks;

    @Column(name = "FINAL_RATING_CBUAE")
    private String finalRatingCbuae;

    @Column(name = "CREDIT_QUALITY")
    private String creditQuality;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "MATURITY_DATE")
    private Date maturityDate;

    @Column(name = "RESIDUAL_MATURITY")
    private BigDecimal residualMaturity;

    @Column(name = "MATURITY_PERIOD", length = 50)
    private String maturityPeriod;

    @Column(name = "PERCENT_HOLDINGS_FI")
    private BigDecimal percentHoldingsFi;

    @Column(name = "QTY_EQUITY_FUNDS")
    private BigDecimal qtyEquityFunds;

    @Column(name = "EQUITY_FLOATING_FUND_ASSETS")
    private BigDecimal equityFloatingFundAssets;

    @Column(name = "TOTAL_FLOATING_SHARE_FUND_AUM")
    private BigDecimal totalFloatingShareFundAum;

    @Column(name = "SPECIFIC_PROVISION")
    private BigDecimal specificProvision;

    @Column(name = "NET_BOOK_VALUE")
    private BigDecimal netBookValue;

    @Column(name = "OTHER_SEC_INFO_NET_BOOK_PRICE")
    private BigDecimal otherSecInfoNetBookPrice;

    @Column(name = "MARKET_PRICE")
    private BigDecimal marketPrice;

    @Column(name = "FAIR_VALUE_AMOUNT_AED")
    private BigDecimal fairValueAmountAed;

    @Column(name = "UNREALIZED_GAIN_LOSS_AGAIN")
    private BigDecimal unrealizedGainLossAgain;

    @Column(name = "PERCENT_HOLDINGS_OTHER")
    private BigDecimal percentHoldingsOther;

    @Column(name = "TOTAL_NET_BOOK_VALUE_AED")
    private BigDecimal totalNetBookValueAed;

    @Column(name = "TOTAL_MARKET_VALUE_AED")
    private BigDecimal totalMarketValueAed;

    @Column(name = "TOTAL_UNREALIZED_GAIN_LOSS")
    private BigDecimal totalUnrealizedGainLoss;

    @Column(name = "UNREALIZED_GAIN_LOSS_CONTRIB")
    private BigDecimal unrealizedGainLossContrib;

    @Column(name = "PERCENT_HOLDINGS")
    private BigDecimal percentHoldings;

    @Column(name = "EXISTING_PLEDGE_STATUS")
    private String existingPledgeStatus;

    @Column(name = "PLEDGED_AMOUNT_AED")
    private BigDecimal pledgedAmountAed;

    @Column(name = "UNENCUMBERED_AMOUNT_AED")
    private BigDecimal unencumberedAmountAed;

    @Column(name = "PROPORTION_UNENCUMBERED")
    private BigDecimal proportionUnencumbered;

    @Column(name = "HQLA_ELAR_ELIGIBILITY")
    private String hqlaElarEligibility;

    @Column(name = "LIQUIDITY_TYPE")
    private String liquidityType;

    @Column(name = "SUKUK_TYPE")
    private String sukukType;

    @Column(name = "TTC_PD")
    private BigDecimal ttcPd;

    @Column(name = "PIT_PD")
    private BigDecimal pitPd;

    @Column(name = "ECL_1Y")
    private BigDecimal ecl1y;

    @Column(name = "ECL_LIFETIME")
    private BigDecimal eclLifetime;

    @Column(name = "ECL_FINAL")
    private BigDecimal eclFinal;

    @Column(name = "IFRS9_STAGING")
    private String ifrs9Staging;

    @Column(name = "BANK_CORE_TIER1_CAPITAL_AED")
    private BigDecimal bankCoreTier1CapitalAed;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "REPORT_SUBMIT_DATE")
    private Date reportSubmitDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "REPORT_FROM_DATE")
    private Date reportFromDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "REPORT_TO_DATE")
    private Date reportToDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "REPORT_DATE")
    private Date reportDate;

    @Column(name = "ENTITY_FLG")
    private String entityFlg;

    @Column(name = "MODIFY_FLG")
    private String modifyFlg;

    @Column(name = "DEL_FLG")
    private String delFlg;

    @Column(name = "REPORT_CODE")
    private String reportCode;

    @Column(name = "ENTRY_USER")
    private String entryUser;

    @Column(name = "MODIFY_USER")
    private String modifyUser;

    @Column(name = "VERIFY_USER")
    private String verifyUser;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "ENTRY_TIME")
    private Date entryTime;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "MODIFY_TIME")
    private Date modifyTime;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "VERIFY_TIME")
    private Date verifyTime;

	public String getSiNo() {
		return siNo;
	}

	public void setSiNo(String siNo) {
		this.siNo = siNo;
	}

	public Date getDataDate() {
		return dataDate;
	}

	public void setDataDate(Date dataDate) {
		this.dataDate = dataDate;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getHeadOfficeSubsidiary() {
		return headOfficeSubsidiary;
	}

	public void setHeadOfficeSubsidiary(String headOfficeSubsidiary) {
		this.headOfficeSubsidiary = headOfficeSubsidiary;
	}

	public String getSubsidiary() {
		return subsidiary;
	}

	public void setSubsidiary(String subsidiary) {
		this.subsidiary = subsidiary;
	}

	public String getBankSymbol() {
		return bankSymbol;
	}

	public void setBankSymbol(String bankSymbol) {
		this.bankSymbol = bankSymbol;
	}

	public String getConventionalIslamic() {
		return conventionalIslamic;
	}

	public void setConventionalIslamic(String conventionalIslamic) {
		this.conventionalIslamic = conventionalIslamic;
	}

	public String getLocalForeign() {
		return localForeign;
	}

	public void setLocalForeign(String localForeign) {
		this.localForeign = localForeign;
	}

	public String getCbuAeTiering() {
		return cbuAeTiering;
	}

	public void setCbuAeTiering(String cbuAeTiering) {
		this.cbuAeTiering = cbuAeTiering;
	}

	public String getAccountingClassification() {
		return accountingClassification;
	}

	public void setAccountingClassification(String accountingClassification) {
		this.accountingClassification = accountingClassification;
	}

	public String getInstrumentType() {
		return instrumentType;
	}

	public void setInstrumentType(String instrumentType) {
		this.instrumentType = instrumentType;
	}

	public String getInstrumentSubcategoryType() {
		return instrumentSubcategoryType;
	}

	public void setInstrumentSubcategoryType(String instrumentSubcategoryType) {
		this.instrumentSubcategoryType = instrumentSubcategoryType;
	}

	public String getIsinCode() {
		return isinCode;
	}

	public void setIsinCode(String isinCode) {
		this.isinCode = isinCode;
	}

	public String getBankInternalPortfolioCode() {
		return bankInternalPortfolioCode;
	}

	public void setBankInternalPortfolioCode(String bankInternalPortfolioCode) {
		this.bankInternalPortfolioCode = bankInternalPortfolioCode;
	}

	public String getCbuAeSecurityId() {
		return cbuAeSecurityId;
	}

	public void setCbuAeSecurityId(String cbuAeSecurityId) {
		this.cbuAeSecurityId = cbuAeSecurityId;
	}

	public String getCbuAeAccessPrimaryKey() {
		return cbuAeAccessPrimaryKey;
	}

	public void setCbuAeAccessPrimaryKey(String cbuAeAccessPrimaryKey) {
		this.cbuAeAccessPrimaryKey = cbuAeAccessPrimaryKey;
	}

	public String getSecurityDescription() {
		return securityDescription;
	}

	public void setSecurityDescription(String securityDescription) {
		this.securityDescription = securityDescription;
	}

	public String getAssetCurrency() {
		return assetCurrency;
	}

	public void setAssetCurrency(String assetCurrency) {
		this.assetCurrency = assetCurrency;
	}

	public String getObligor() {
		return obligor;
	}

	public void setObligor(String obligor) {
		this.obligor = obligor;
	}

	public String getCountryOfRisk() {
		return countryOfRisk;
	}

	public void setCountryOfRisk(String countryOfRisk) {
		this.countryOfRisk = countryOfRisk;
	}

	public String getCbuAeGeographicalZone() {
		return cbuAeGeographicalZone;
	}

	public void setCbuAeGeographicalZone(String cbuAeGeographicalZone) {
		this.cbuAeGeographicalZone = cbuAeGeographicalZone;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getIssuerType() {
		return issuerType;
	}

	public void setIssuerType(String issuerType) {
		this.issuerType = issuerType;
	}

	public BigDecimal getIssueSize() {
		return issueSize;
	}

	public void setIssueSize(BigDecimal issueSize) {
		this.issueSize = issueSize;
	}

	public BigDecimal getPercentIssueSize() {
		return percentIssueSize;
	}

	public void setPercentIssueSize(BigDecimal percentIssueSize) {
		this.percentIssueSize = percentIssueSize;
	}

	public BigDecimal getNominalTradeCurrency() {
		return nominalTradeCurrency;
	}

	public void setNominalTradeCurrency(BigDecimal nominalTradeCurrency) {
		this.nominalTradeCurrency = nominalTradeCurrency;
	}

	public BigDecimal getNominalAedEquivalent() {
		return nominalAedEquivalent;
	}

	public void setNominalAedEquivalent(BigDecimal nominalAedEquivalent) {
		this.nominalAedEquivalent = nominalAedEquivalent;
	}

	public BigDecimal getPremDiscAedEquivalent() {
		return premDiscAedEquivalent;
	}

	public void setPremDiscAedEquivalent(BigDecimal premDiscAedEquivalent) {
		this.premDiscAedEquivalent = premDiscAedEquivalent;
	}

	public BigDecimal getSpecificProvisionAed() {
		return specificProvisionAed;
	}

	public void setSpecificProvisionAed(BigDecimal specificProvisionAed) {
		this.specificProvisionAed = specificProvisionAed;
	}

	public BigDecimal getFixedIncomeInfoNetBookPrice() {
		return fixedIncomeInfoNetBookPrice;
	}

	public void setFixedIncomeInfoNetBookPrice(BigDecimal fixedIncomeInfoNetBookPrice) {
		this.fixedIncomeInfoNetBookPrice = fixedIncomeInfoNetBookPrice;
	}

	public BigDecimal getNetBookValueAed() {
		return netBookValueAed;
	}

	public void setNetBookValueAed(BigDecimal netBookValueAed) {
		this.netBookValueAed = netBookValueAed;
	}

	public BigDecimal getPurchaseYieldToMaturity() {
		return purchaseYieldToMaturity;
	}

	public void setPurchaseYieldToMaturity(BigDecimal purchaseYieldToMaturity) {
		this.purchaseYieldToMaturity = purchaseYieldToMaturity;
	}

	public BigDecimal getCleanPrice() {
		return cleanPrice;
	}

	public void setCleanPrice(BigDecimal cleanPrice) {
		this.cleanPrice = cleanPrice;
	}

	public BigDecimal getCleanMarketValueAed() {
		return cleanMarketValueAed;
	}

	public void setCleanMarketValueAed(BigDecimal cleanMarketValueAed) {
		this.cleanMarketValueAed = cleanMarketValueAed;
	}

	public BigDecimal getCurrentYieldToMaturity() {
		return currentYieldToMaturity;
	}

	public void setCurrentYieldToMaturity(BigDecimal currentYieldToMaturity) {
		this.currentYieldToMaturity = currentYieldToMaturity;
	}

	public BigDecimal getUnrealizedGainLossAed() {
		return unrealizedGainLossAed;
	}

	public void setUnrealizedGainLossAed(BigDecimal unrealizedGainLossAed) {
		this.unrealizedGainLossAed = unrealizedGainLossAed;
	}

	public String getSubordinatedDebtSukuk() {
		return subordinatedDebtSukuk;
	}

	public void setSubordinatedDebtSukuk(String subordinatedDebtSukuk) {
		this.subordinatedDebtSukuk = subordinatedDebtSukuk;
	}

	public String getFinalRatingBanks() {
		return finalRatingBanks;
	}

	public void setFinalRatingBanks(String finalRatingBanks) {
		this.finalRatingBanks = finalRatingBanks;
	}

	public String getFinalRatingCbuae() {
		return finalRatingCbuae;
	}

	public void setFinalRatingCbuae(String finalRatingCbuae) {
		this.finalRatingCbuae = finalRatingCbuae;
	}

	public String getCreditQuality() {
		return creditQuality;
	}

	public void setCreditQuality(String creditQuality) {
		this.creditQuality = creditQuality;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public BigDecimal getResidualMaturity() {
		return residualMaturity;
	}

	public void setResidualMaturity(BigDecimal residualMaturity) {
		this.residualMaturity = residualMaturity;
	}

	public String getMaturityPeriod() {
		return maturityPeriod;
	}

	public void setMaturityPeriod(String maturityPeriod) {
		this.maturityPeriod = maturityPeriod;
	}

	public BigDecimal getPercentHoldingsFi() {
		return percentHoldingsFi;
	}

	public void setPercentHoldingsFi(BigDecimal percentHoldingsFi) {
		this.percentHoldingsFi = percentHoldingsFi;
	}

	public BigDecimal getQtyEquityFunds() {
		return qtyEquityFunds;
	}

	public void setQtyEquityFunds(BigDecimal qtyEquityFunds) {
		this.qtyEquityFunds = qtyEquityFunds;
	}

	public BigDecimal getEquityFloatingFundAssets() {
		return equityFloatingFundAssets;
	}

	public void setEquityFloatingFundAssets(BigDecimal equityFloatingFundAssets) {
		this.equityFloatingFundAssets = equityFloatingFundAssets;
	}

	public BigDecimal getTotalFloatingShareFundAum() {
		return totalFloatingShareFundAum;
	}

	public void setTotalFloatingShareFundAum(BigDecimal totalFloatingShareFundAum) {
		this.totalFloatingShareFundAum = totalFloatingShareFundAum;
	}

	public BigDecimal getSpecificProvision() {
		return specificProvision;
	}

	public void setSpecificProvision(BigDecimal specificProvision) {
		this.specificProvision = specificProvision;
	}

	public BigDecimal getNetBookValue() {
		return netBookValue;
	}

	public void setNetBookValue(BigDecimal netBookValue) {
		this.netBookValue = netBookValue;
	}

	public BigDecimal getOtherSecInfoNetBookPrice() {
		return otherSecInfoNetBookPrice;
	}

	public void setOtherSecInfoNetBookPrice(BigDecimal otherSecInfoNetBookPrice) {
		this.otherSecInfoNetBookPrice = otherSecInfoNetBookPrice;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public BigDecimal getFairValueAmountAed() {
		return fairValueAmountAed;
	}

	public void setFairValueAmountAed(BigDecimal fairValueAmountAed) {
		this.fairValueAmountAed = fairValueAmountAed;
	}

	public BigDecimal getUnrealizedGainLossAgain() {
		return unrealizedGainLossAgain;
	}

	public void setUnrealizedGainLossAgain(BigDecimal unrealizedGainLossAgain) {
		this.unrealizedGainLossAgain = unrealizedGainLossAgain;
	}

	public BigDecimal getPercentHoldingsOther() {
		return percentHoldingsOther;
	}

	public void setPercentHoldingsOther(BigDecimal percentHoldingsOther) {
		this.percentHoldingsOther = percentHoldingsOther;
	}

	public BigDecimal getTotalNetBookValueAed() {
		return totalNetBookValueAed;
	}

	public void setTotalNetBookValueAed(BigDecimal totalNetBookValueAed) {
		this.totalNetBookValueAed = totalNetBookValueAed;
	}

	public BigDecimal getTotalMarketValueAed() {
		return totalMarketValueAed;
	}

	public void setTotalMarketValueAed(BigDecimal totalMarketValueAed) {
		this.totalMarketValueAed = totalMarketValueAed;
	}

	public BigDecimal getTotalUnrealizedGainLoss() {
		return totalUnrealizedGainLoss;
	}

	public void setTotalUnrealizedGainLoss(BigDecimal totalUnrealizedGainLoss) {
		this.totalUnrealizedGainLoss = totalUnrealizedGainLoss;
	}

	public BigDecimal getUnrealizedGainLossContrib() {
		return unrealizedGainLossContrib;
	}

	public void setUnrealizedGainLossContrib(BigDecimal unrealizedGainLossContrib) {
		this.unrealizedGainLossContrib = unrealizedGainLossContrib;
	}

	public BigDecimal getPercentHoldings() {
		return percentHoldings;
	}

	public void setPercentHoldings(BigDecimal percentHoldings) {
		this.percentHoldings = percentHoldings;
	}

	public String getExistingPledgeStatus() {
		return existingPledgeStatus;
	}

	public void setExistingPledgeStatus(String existingPledgeStatus) {
		this.existingPledgeStatus = existingPledgeStatus;
	}

	public BigDecimal getPledgedAmountAed() {
		return pledgedAmountAed;
	}

	public void setPledgedAmountAed(BigDecimal pledgedAmountAed) {
		this.pledgedAmountAed = pledgedAmountAed;
	}

	public BigDecimal getUnencumberedAmountAed() {
		return unencumberedAmountAed;
	}

	public void setUnencumberedAmountAed(BigDecimal unencumberedAmountAed) {
		this.unencumberedAmountAed = unencumberedAmountAed;
	}

	public BigDecimal getProportionUnencumbered() {
		return proportionUnencumbered;
	}

	public void setProportionUnencumbered(BigDecimal proportionUnencumbered) {
		this.proportionUnencumbered = proportionUnencumbered;
	}

	public String getHqlaElarEligibility() {
		return hqlaElarEligibility;
	}

	public void setHqlaElarEligibility(String hqlaElarEligibility) {
		this.hqlaElarEligibility = hqlaElarEligibility;
	}

	public String getLiquidityType() {
		return liquidityType;
	}

	public void setLiquidityType(String liquidityType) {
		this.liquidityType = liquidityType;
	}

	public String getSukukType() {
		return sukukType;
	}

	public void setSukukType(String sukukType) {
		this.sukukType = sukukType;
	}

	public BigDecimal getTtcPd() {
		return ttcPd;
	}

	public void setTtcPd(BigDecimal ttcPd) {
		this.ttcPd = ttcPd;
	}

	public BigDecimal getPitPd() {
		return pitPd;
	}

	public void setPitPd(BigDecimal pitPd) {
		this.pitPd = pitPd;
	}

	public BigDecimal getEcl1y() {
		return ecl1y;
	}

	public void setEcl1y(BigDecimal ecl1y) {
		this.ecl1y = ecl1y;
	}

	public BigDecimal getEclLifetime() {
		return eclLifetime;
	}

	public void setEclLifetime(BigDecimal eclLifetime) {
		this.eclLifetime = eclLifetime;
	}

	public BigDecimal getEclFinal() {
		return eclFinal;
	}

	public void setEclFinal(BigDecimal eclFinal) {
		this.eclFinal = eclFinal;
	}

	public String getIfrs9Staging() {
		return ifrs9Staging;
	}

	public void setIfrs9Staging(String ifrs9Staging) {
		this.ifrs9Staging = ifrs9Staging;
	}

	public BigDecimal getBankCoreTier1CapitalAed() {
		return bankCoreTier1CapitalAed;
	}

	public void setBankCoreTier1CapitalAed(BigDecimal bankCoreTier1CapitalAed) {
		this.bankCoreTier1CapitalAed = bankCoreTier1CapitalAed;
	}

	public Date getReportSubmitDate() {
		return reportSubmitDate;
	}

	public void setReportSubmitDate(Date reportSubmitDate) {
		this.reportSubmitDate = reportSubmitDate;
	}

	public Date getReportFromDate() {
		return reportFromDate;
	}

	public void setReportFromDate(Date reportFromDate) {
		this.reportFromDate = reportFromDate;
	}

	public Date getReportToDate() {
		return reportToDate;
	}

	public void setReportToDate(Date reportToDate) {
		this.reportToDate = reportToDate;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getEntityFlg() {
		return entityFlg;
	}

	public void setEntityFlg(String entityFlg) {
		this.entityFlg = entityFlg;
	}

	public String getModifyFlg() {
		return modifyFlg;
	}

	public void setModifyFlg(String modifyFlg) {
		this.modifyFlg = modifyFlg;
	}

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	public String getReportCode() {
		return reportCode;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}

	public String getEntryUser() {
		return entryUser;
	}

	public void setEntryUser(String entryUser) {
		this.entryUser = entryUser;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public String getVerifyUser() {
		return verifyUser;
	}

	public void setVerifyUser(String verifyUser) {
		this.verifyUser = verifyUser;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Date getVerifyTime() {
		return verifyTime;
	}

	public void setVerifyTime(Date verifyTime) {
		this.verifyTime = verifyTime;
	}

	public RT_Investment_Securities_Data_Template(String siNo, Date dataDate, String bankName,
			String headOfficeSubsidiary, String subsidiary, String bankSymbol, String conventionalIslamic,
			String localForeign, String cbuAeTiering, String accountingClassification, String instrumentType,
			String instrumentSubcategoryType, String isinCode, String bankInternalPortfolioCode, String cbuAeSecurityId,
			String cbuAeAccessPrimaryKey, String securityDescription, String assetCurrency, String obligor,
			String countryOfRisk, String cbuAeGeographicalZone, String industry, String sector, String issuerType,
			BigDecimal issueSize, BigDecimal percentIssueSize, BigDecimal nominalTradeCurrency,
			BigDecimal nominalAedEquivalent, BigDecimal premDiscAedEquivalent, BigDecimal specificProvisionAed,
			BigDecimal fixedIncomeInfoNetBookPrice, BigDecimal netBookValueAed, BigDecimal purchaseYieldToMaturity,
			BigDecimal cleanPrice, BigDecimal cleanMarketValueAed, BigDecimal currentYieldToMaturity,
			BigDecimal unrealizedGainLossAed, String subordinatedDebtSukuk, String finalRatingBanks,
			String finalRatingCbuae, String creditQuality, Date maturityDate, BigDecimal residualMaturity,
			String maturityPeriod, BigDecimal percentHoldingsFi, BigDecimal qtyEquityFunds,
			BigDecimal equityFloatingFundAssets, BigDecimal totalFloatingShareFundAum, BigDecimal specificProvision,
			BigDecimal netBookValue, BigDecimal otherSecInfoNetBookPrice, BigDecimal marketPrice,
			BigDecimal fairValueAmountAed, BigDecimal unrealizedGainLossAgain, BigDecimal percentHoldingsOther,
			BigDecimal totalNetBookValueAed, BigDecimal totalMarketValueAed, BigDecimal totalUnrealizedGainLoss,
			BigDecimal unrealizedGainLossContrib, BigDecimal percentHoldings, String existingPledgeStatus,
			BigDecimal pledgedAmountAed, BigDecimal unencumberedAmountAed, BigDecimal proportionUnencumbered,
			String hqlaElarEligibility, String liquidityType, String sukukType, BigDecimal ttcPd, BigDecimal pitPd,
			BigDecimal ecl1y, BigDecimal eclLifetime, BigDecimal eclFinal, String ifrs9Staging,
			BigDecimal bankCoreTier1CapitalAed, Date reportSubmitDate, Date reportFromDate, Date reportToDate,
			Date reportDate, String entityFlg, String modifyFlg, String delFlg, String reportCode, String entryUser,
			String modifyUser, String verifyUser, Date entryTime, Date modifyTime, Date verifyTime) {
		super();
		this.siNo = siNo;
		this.dataDate = dataDate;
		this.bankName = bankName;
		this.headOfficeSubsidiary = headOfficeSubsidiary;
		this.subsidiary = subsidiary;
		this.bankSymbol = bankSymbol;
		this.conventionalIslamic = conventionalIslamic;
		this.localForeign = localForeign;
		this.cbuAeTiering = cbuAeTiering;
		this.accountingClassification = accountingClassification;
		this.instrumentType = instrumentType;
		this.instrumentSubcategoryType = instrumentSubcategoryType;
		this.isinCode = isinCode;
		this.bankInternalPortfolioCode = bankInternalPortfolioCode;
		this.cbuAeSecurityId = cbuAeSecurityId;
		this.cbuAeAccessPrimaryKey = cbuAeAccessPrimaryKey;
		this.securityDescription = securityDescription;
		this.assetCurrency = assetCurrency;
		this.obligor = obligor;
		this.countryOfRisk = countryOfRisk;
		this.cbuAeGeographicalZone = cbuAeGeographicalZone;
		this.industry = industry;
		this.sector = sector;
		this.issuerType = issuerType;
		this.issueSize = issueSize;
		this.percentIssueSize = percentIssueSize;
		this.nominalTradeCurrency = nominalTradeCurrency;
		this.nominalAedEquivalent = nominalAedEquivalent;
		this.premDiscAedEquivalent = premDiscAedEquivalent;
		this.specificProvisionAed = specificProvisionAed;
		this.fixedIncomeInfoNetBookPrice = fixedIncomeInfoNetBookPrice;
		this.netBookValueAed = netBookValueAed;
		this.purchaseYieldToMaturity = purchaseYieldToMaturity;
		this.cleanPrice = cleanPrice;
		this.cleanMarketValueAed = cleanMarketValueAed;
		this.currentYieldToMaturity = currentYieldToMaturity;
		this.unrealizedGainLossAed = unrealizedGainLossAed;
		this.subordinatedDebtSukuk = subordinatedDebtSukuk;
		this.finalRatingBanks = finalRatingBanks;
		this.finalRatingCbuae = finalRatingCbuae;
		this.creditQuality = creditQuality;
		this.maturityDate = maturityDate;
		this.residualMaturity = residualMaturity;
		this.maturityPeriod = maturityPeriod;
		this.percentHoldingsFi = percentHoldingsFi;
		this.qtyEquityFunds = qtyEquityFunds;
		this.equityFloatingFundAssets = equityFloatingFundAssets;
		this.totalFloatingShareFundAum = totalFloatingShareFundAum;
		this.specificProvision = specificProvision;
		this.netBookValue = netBookValue;
		this.otherSecInfoNetBookPrice = otherSecInfoNetBookPrice;
		this.marketPrice = marketPrice;
		this.fairValueAmountAed = fairValueAmountAed;
		this.unrealizedGainLossAgain = unrealizedGainLossAgain;
		this.percentHoldingsOther = percentHoldingsOther;
		this.totalNetBookValueAed = totalNetBookValueAed;
		this.totalMarketValueAed = totalMarketValueAed;
		this.totalUnrealizedGainLoss = totalUnrealizedGainLoss;
		this.unrealizedGainLossContrib = unrealizedGainLossContrib;
		this.percentHoldings = percentHoldings;
		this.existingPledgeStatus = existingPledgeStatus;
		this.pledgedAmountAed = pledgedAmountAed;
		this.unencumberedAmountAed = unencumberedAmountAed;
		this.proportionUnencumbered = proportionUnencumbered;
		this.hqlaElarEligibility = hqlaElarEligibility;
		this.liquidityType = liquidityType;
		this.sukukType = sukukType;
		this.ttcPd = ttcPd;
		this.pitPd = pitPd;
		this.ecl1y = ecl1y;
		this.eclLifetime = eclLifetime;
		this.eclFinal = eclFinal;
		this.ifrs9Staging = ifrs9Staging;
		this.bankCoreTier1CapitalAed = bankCoreTier1CapitalAed;
		this.reportSubmitDate = reportSubmitDate;
		this.reportFromDate = reportFromDate;
		this.reportToDate = reportToDate;
		this.reportDate = reportDate;
		this.entityFlg = entityFlg;
		this.modifyFlg = modifyFlg;
		this.delFlg = delFlg;
		this.reportCode = reportCode;
		this.entryUser = entryUser;
		this.modifyUser = modifyUser;
		this.verifyUser = verifyUser;
		this.entryTime = entryTime;
		this.modifyTime = modifyTime;
		this.verifyTime = verifyTime;
	}

	@Override
	public String toString() {
		return "RT_Investment_Securities_Data_Template [siNo=" + siNo + ", dataDate=" + dataDate + ", bankName="
				+ bankName + ", headOfficeSubsidiary=" + headOfficeSubsidiary + ", subsidiary=" + subsidiary
				+ ", bankSymbol=" + bankSymbol + ", conventionalIslamic=" + conventionalIslamic + ", localForeign="
				+ localForeign + ", cbuAeTiering=" + cbuAeTiering + ", accountingClassification="
				+ accountingClassification + ", instrumentType=" + instrumentType + ", instrumentSubcategoryType="
				+ instrumentSubcategoryType + ", isinCode=" + isinCode + ", bankInternalPortfolioCode="
				+ bankInternalPortfolioCode + ", cbuAeSecurityId=" + cbuAeSecurityId + ", cbuAeAccessPrimaryKey="
				+ cbuAeAccessPrimaryKey + ", securityDescription=" + securityDescription + ", assetCurrency="
				+ assetCurrency + ", obligor=" + obligor + ", countryOfRisk=" + countryOfRisk
				+ ", cbuAeGeographicalZone=" + cbuAeGeographicalZone + ", industry=" + industry + ", sector=" + sector
				+ ", issuerType=" + issuerType + ", issueSize=" + issueSize + ", percentIssueSize=" + percentIssueSize
				+ ", nominalTradeCurrency=" + nominalTradeCurrency + ", nominalAedEquivalent=" + nominalAedEquivalent
				+ ", premDiscAedEquivalent=" + premDiscAedEquivalent + ", specificProvisionAed=" + specificProvisionAed
				+ ", fixedIncomeInfoNetBookPrice=" + fixedIncomeInfoNetBookPrice + ", netBookValueAed="
				+ netBookValueAed + ", purchaseYieldToMaturity=" + purchaseYieldToMaturity + ", cleanPrice="
				+ cleanPrice + ", cleanMarketValueAed=" + cleanMarketValueAed + ", currentYieldToMaturity="
				+ currentYieldToMaturity + ", unrealizedGainLossAed=" + unrealizedGainLossAed
				+ ", subordinatedDebtSukuk=" + subordinatedDebtSukuk + ", finalRatingBanks=" + finalRatingBanks
				+ ", finalRatingCbuae=" + finalRatingCbuae + ", creditQuality=" + creditQuality + ", maturityDate="
				+ maturityDate + ", residualMaturity=" + residualMaturity + ", maturityPeriod=" + maturityPeriod
				+ ", percentHoldingsFi=" + percentHoldingsFi + ", qtyEquityFunds=" + qtyEquityFunds
				+ ", equityFloatingFundAssets=" + equityFloatingFundAssets + ", totalFloatingShareFundAum="
				+ totalFloatingShareFundAum + ", specificProvision=" + specificProvision + ", netBookValue="
				+ netBookValue + ", otherSecInfoNetBookPrice=" + otherSecInfoNetBookPrice + ", marketPrice="
				+ marketPrice + ", fairValueAmountAed=" + fairValueAmountAed + ", unrealizedGainLossAgain="
				+ unrealizedGainLossAgain + ", percentHoldingsOther=" + percentHoldingsOther + ", totalNetBookValueAed="
				+ totalNetBookValueAed + ", totalMarketValueAed=" + totalMarketValueAed + ", totalUnrealizedGainLoss="
				+ totalUnrealizedGainLoss + ", unrealizedGainLossContrib=" + unrealizedGainLossContrib
				+ ", percentHoldings=" + percentHoldings + ", existingPledgeStatus=" + existingPledgeStatus
				+ ", pledgedAmountAed=" + pledgedAmountAed + ", unencumberedAmountAed=" + unencumberedAmountAed
				+ ", proportionUnencumbered=" + proportionUnencumbered + ", hqlaElarEligibility=" + hqlaElarEligibility
				+ ", liquidityType=" + liquidityType + ", sukukType=" + sukukType + ", ttcPd=" + ttcPd + ", pitPd="
				+ pitPd + ", ecl1y=" + ecl1y + ", eclLifetime=" + eclLifetime + ", eclFinal=" + eclFinal
				+ ", ifrs9Staging=" + ifrs9Staging + ", bankCoreTier1CapitalAed=" + bankCoreTier1CapitalAed
				+ ", reportSubmitDate=" + reportSubmitDate + ", reportFromDate=" + reportFromDate + ", reportToDate="
				+ reportToDate + ", reportDate=" + reportDate + ", entityFlg=" + entityFlg + ", modifyFlg=" + modifyFlg
				+ ", delFlg=" + delFlg + ", reportCode=" + reportCode + ", entryUser=" + entryUser + ", modifyUser="
				+ modifyUser + ", verifyUser=" + verifyUser + ", entryTime=" + entryTime + ", modifyTime=" + modifyTime
				+ ", verifyTime=" + verifyTime + ", getSiNo()=" + getSiNo() + ", getDataDate()=" + getDataDate()
				+ ", getBankName()=" + getBankName() + ", getHeadOfficeSubsidiary()=" + getHeadOfficeSubsidiary()
				+ ", getSubsidiary()=" + getSubsidiary() + ", getBankSymbol()=" + getBankSymbol()
				+ ", getConventionalIslamic()=" + getConventionalIslamic() + ", getLocalForeign()=" + getLocalForeign()
				+ ", getCbuAeTiering()=" + getCbuAeTiering() + ", getAccountingClassification()="
				+ getAccountingClassification() + ", getInstrumentType()=" + getInstrumentType()
				+ ", getInstrumentSubcategoryType()=" + getInstrumentSubcategoryType() + ", getIsinCode()="
				+ getIsinCode() + ", getBankInternalPortfolioCode()=" + getBankInternalPortfolioCode()
				+ ", getCbuAeSecurityId()=" + getCbuAeSecurityId() + ", getCbuAeAccessPrimaryKey()="
				+ getCbuAeAccessPrimaryKey() + ", getSecurityDescription()=" + getSecurityDescription()
				+ ", getAssetCurrency()=" + getAssetCurrency() + ", getObligor()=" + getObligor()
				+ ", getCountryOfRisk()=" + getCountryOfRisk() + ", getCbuAeGeographicalZone()="
				+ getCbuAeGeographicalZone() + ", getIndustry()=" + getIndustry() + ", getSector()=" + getSector()
				+ ", getIssuerType()=" + getIssuerType() + ", getIssueSize()=" + getIssueSize()
				+ ", getPercentIssueSize()=" + getPercentIssueSize() + ", getNominalTradeCurrency()="
				+ getNominalTradeCurrency() + ", getNominalAedEquivalent()=" + getNominalAedEquivalent()
				+ ", getPremDiscAedEquivalent()=" + getPremDiscAedEquivalent() + ", getSpecificProvisionAed()="
				+ getSpecificProvisionAed() + ", getFixedIncomeInfoNetBookPrice()=" + getFixedIncomeInfoNetBookPrice()
				+ ", getNetBookValueAed()=" + getNetBookValueAed() + ", getPurchaseYieldToMaturity()="
				+ getPurchaseYieldToMaturity() + ", getCleanPrice()=" + getCleanPrice() + ", getCleanMarketValueAed()="
				+ getCleanMarketValueAed() + ", getCurrentYieldToMaturity()=" + getCurrentYieldToMaturity()
				+ ", getUnrealizedGainLossAed()=" + getUnrealizedGainLossAed() + ", getSubordinatedDebtSukuk()="
				+ getSubordinatedDebtSukuk() + ", getFinalRatingBanks()=" + getFinalRatingBanks()
				+ ", getFinalRatingCbuae()=" + getFinalRatingCbuae() + ", getCreditQuality()=" + getCreditQuality()
				+ ", getMaturityDate()=" + getMaturityDate() + ", getResidualMaturity()=" + getResidualMaturity()
				+ ", getMaturityPeriod()=" + getMaturityPeriod() + ", getPercentHoldingsFi()=" + getPercentHoldingsFi()
				+ ", getQtyEquityFunds()=" + getQtyEquityFunds() + ", getEquityFloatingFundAssets()="
				+ getEquityFloatingFundAssets() + ", getTotalFloatingShareFundAum()=" + getTotalFloatingShareFundAum()
				+ ", getSpecificProvision()=" + getSpecificProvision() + ", getNetBookValue()=" + getNetBookValue()
				+ ", getOtherSecInfoNetBookPrice()=" + getOtherSecInfoNetBookPrice() + ", getMarketPrice()="
				+ getMarketPrice() + ", getFairValueAmountAed()=" + getFairValueAmountAed()
				+ ", getUnrealizedGainLossAgain()=" + getUnrealizedGainLossAgain() + ", getPercentHoldingsOther()="
				+ getPercentHoldingsOther() + ", getTotalNetBookValueAed()=" + getTotalNetBookValueAed()
				+ ", getTotalMarketValueAed()=" + getTotalMarketValueAed() + ", getTotalUnrealizedGainLoss()="
				+ getTotalUnrealizedGainLoss() + ", getUnrealizedGainLossContrib()=" + getUnrealizedGainLossContrib()
				+ ", getPercentHoldings()=" + getPercentHoldings() + ", getExistingPledgeStatus()="
				+ getExistingPledgeStatus() + ", getPledgedAmountAed()=" + getPledgedAmountAed()
				+ ", getUnencumberedAmountAed()=" + getUnencumberedAmountAed() + ", getProportionUnencumbered()="
				+ getProportionUnencumbered() + ", getHqlaElarEligibility()=" + getHqlaElarEligibility()
				+ ", getLiquidityType()=" + getLiquidityType() + ", getSukukType()=" + getSukukType() + ", getTtcPd()="
				+ getTtcPd() + ", getPitPd()=" + getPitPd() + ", getEcl1y()=" + getEcl1y() + ", getEclLifetime()="
				+ getEclLifetime() + ", getEclFinal()=" + getEclFinal() + ", getIfrs9Staging()=" + getIfrs9Staging()
				+ ", getBankCoreTier1CapitalAed()=" + getBankCoreTier1CapitalAed() + ", getReportSubmitDate()="
				+ getReportSubmitDate() + ", getReportFromDate()=" + getReportFromDate() + ", getReportToDate()="
				+ getReportToDate() + ", getReportDate()=" + getReportDate() + ", getEntityFlg()=" + getEntityFlg()
				+ ", getModifyFlg()=" + getModifyFlg() + ", getDelFlg()=" + getDelFlg() + ", getReportCode()="
				+ getReportCode() + ", getEntryUser()=" + getEntryUser() + ", getModifyUser()=" + getModifyUser()
				+ ", getVerifyUser()=" + getVerifyUser() + ", getEntryTime()=" + getEntryTime() + ", getModifyTime()="
				+ getModifyTime() + ", getVerifyTime()=" + getVerifyTime() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public RT_Investment_Securities_Data_Template() {
		super();
		// TODO Auto-generated constructor stub
	}

}
