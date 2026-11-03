package com.bornfire.xbrl.entities;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BCBUAE_INVESTMENT_RISK_DATA_DASHBOARD_TEMPLATE")
public class RT_Investment_Risk_Data_Dashboard_Template {
	
	@Id
	private Long SI_NO;

    @Column(name = "DATA_DATE")
    private Date dataDate;

    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "GROUP_HEAD_OFFICE_SUBSIDIARY")
    private String groupHeadOfficeSubsidiary;

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

    @Column(name = "ASSET_BALANCE_SHEET_SIZE_AED")
    private BigDecimal assetBalanceSheetSizeAed;

    @Column(name = "INVESTMENT_BOOK_SIZE_AED")
    private BigDecimal investmentBookSizeAed;

    @Column(name = "BOOK_SIZE_TOTAL_ASSETS_PCT")
    private BigDecimal bookSizeTotalAssetsPct;

    @Column(name = "YTD_NET_PNL_AED")
    private BigDecimal ytdNetPnlAed;

    @Column(name = "YTD_FVTOCI_UNREALIZED_LOSS_AED")
    private BigDecimal ytdFvtociUnrealizedLossAed;

    @Column(name = "CET1_AED")
    private BigDecimal cet1Aed;

    @Column(name = "UGL_CORE_TIER1_RELATIVE_IMPACT_PCT")
    private BigDecimal uglCoreTier1RelativeImpactPct;

    @Column(name = "YTD_AMORTIZED_UNREALIZED_LOSS_AED")
    private BigDecimal ytdAmortizedUnrealizedLossAed;

    @Column(name = "YTD_HQLA_AC_UNREALIZED_LOSS_AED")
    private BigDecimal ytdHqlaAcUnrealizedLossAed;

    @Column(name = "HQLA_AC_CORE_TIER1_IMPACT_PCT")
    private BigDecimal hqlaAcCoreTier1ImpactPct;

    @Column(name = "IR_VAR_CONFIDENCE_INTERVAL")
    private BigDecimal irVarConfidenceInterval;

    @Column(name = "IR_VAR_HOLDING_PERIOD")
    private String irVarHoldingPeriod;

    @Column(name = "IR_FIXED_INCOME_EXPOSURE_AED")
    private BigDecimal irFixedIncomeExposureAed;

    @Column(name = "IR_VAR_EXPOSURE_AED")
    private BigDecimal irVarExposureAed;

    @Column(name = "IR_VAR_LIMIT_AED")
    private BigDecimal irVarLimitAed;

    @Column(name = "IR_STATUS")
    private String irStatus;

    @Column(name = "IR_VAR_IMPACT_PCT")
    private BigDecimal irVarImpactPct;

    @Column(name = "CS_VAR_CONFIDENCE_INTERVAL")
    private BigDecimal csVarConfidenceInterval;

    @Column(name = "CS_VAR_HOLDING_PERIOD")
    private String csVarHoldingPeriod;

    @Column(name = "CS_FIXED_INCOME_EXPOSURE_AED")
    private BigDecimal csFixedIncomeExposureAed;

    @Column(name = "CS_VAR_EXPOSURE_AED")
    private BigDecimal csVarExposureAed;

    @Column(name = "CS_VAR_LIMIT_AED")
    private BigDecimal csVarLimitAed;

    @Column(name = "CS_STATUS")
    private String csStatus;

    @Column(name = "CS_VAR_IMPACT_PCT")
    private BigDecimal csVarImpactPct;

    @Column(name = "FX_VAR_CONFIDENCE_INTERVAL")
    private BigDecimal fxVarConfidenceInterval;

    @Column(name = "FX_VAR_HOLDING_PERIOD")
    private String fxVarHoldingPeriod;

    @Column(name = "FX_EXPOSURE_AED")
    private BigDecimal fxExposureAed;

    @Column(name = "FX_VAR_EXPOSURE_AED")
    private BigDecimal fxVarExposureAed;

    @Column(name = "FX_VAR_LIMIT_AED")
    private BigDecimal fxVarLimitAed;

    @Column(name = "FX_STATUS")
    private String fxStatus;

    @Column(name = "FX_VAR_IMPACT_PCT")
    private BigDecimal fxVarImpactPct;

    @Column(name = "EQ_VAR_CONFIDENCE_INTERVAL")
    private BigDecimal eqVarConfidenceInterval;

    @Column(name = "EQ_VAR_HOLDING_PERIOD")
    private String eqVarHoldingPeriod;

    @Column(name = "EQ_EXPOSURE_AED")
    private BigDecimal eqExposureAed;

    @Column(name = "EQ_VAR_EXPOSURE_AED")
    private BigDecimal eqVarExposureAed;

    @Column(name = "EQ_VAR_LIMIT_AED")
    private BigDecimal eqVarLimitAed;

    @Column(name = "EQ_STATUS")
    private String eqStatus;

    @Column(name = "EQ_VAR_IMPACT_PCT")
    private BigDecimal eqVarImpactPct;

    @Column(name = "COMM_VAR_CONFIDENCE_INTERVAL")
    private BigDecimal commVarConfidenceInterval;

    @Column(name = "COMM_VAR_HOLDING_PERIOD")
    private String commVarHoldingPeriod;

    @Column(name = "COMM_EXPOSURE_AED")
    private BigDecimal commExposureAed;

    @Column(name = "COMM_VAR_EXPOSURE_AED")
    private BigDecimal commVarExposureAed;

    @Column(name = "COMM_VAR_LIMIT_AED")
    private BigDecimal commVarLimitAed;

    @Column(name = "COMM_STATUS")
    private String commStatus;

    @Column(name = "COMM_VAR_IMPACT_PCT")
    private BigDecimal commVarImpactPct;

    @Column(name = "OVERALL_VAR_CONFIDENCE_INTERVAL")
    private BigDecimal overallVarConfidenceInterval;

    @Column(name = "OVERALL_VAR_HOLDING_PERIOD")
    private String overallVarHoldingPeriod;

    @Column(name = "VAR_EXPOSURE_AED")
    private BigDecimal varExposureAed;

    @Column(name = "VAR_LIMIT_AED")
    private BigDecimal varLimitAed;

    @Column(name = "OVERALL_VAR_STATUS")
    private String overallVarStatus;

    @Column(name = "PORTFOLIO_RELATIVE_IMPACT_PCT")
    private BigDecimal portfolioRelativeImpactPct;

    @Column(name = "EXPECTED_SHORTFALL_EXPOSURE_AED")
    private BigDecimal expectedShortfallExposureAed;

    @Column(name = "EXPECTED_SHORTFALL_LIMIT_AED")
    private BigDecimal expectedShortfallLimitAed;

    @Column(name = "EXPECTED_SHORTFALL_STATUS")
    private String expectedShortfallStatus;

    @Column(name = "EXPECTED_SHORTFALL_IMPACT_PCT")
    private BigDecimal expectedShortfallImpactPct;

    @Column(name = "MODIFIED_DURATION")
    private BigDecimal modifiedDuration;

    @Column(name = "INTEREST_RATE_SHOCK_BPS")
    private Integer interestRateShockBps;

    @Column(name = "INTEREST_RATE_LIMIT")
    private BigDecimal interestRateLimit;

    @Column(name = "INTEREST_RATE_STATUS")
    private String interestRateStatus;

    @Column(name = "DV01_AED")
    private BigDecimal dv01Aed;

    @Column(name = "DV01_LIMIT_AED")
    private BigDecimal dv01LimitAed;

    @Column(name = "DV01_STATUS")
    private String dv01Status;

    @Column(name = "DV01_TENOR_GAP_LT3_AED")
    private BigDecimal dv01TenorGapLt3Aed;

    @Column(name = "DV01_TENOR_GAP_GT3_AED")
    private BigDecimal dv01TenorGapGt3Aed;

    @Column(name = "DV01_CHECK")
    private String dv01Check;

    @Column(name = "CS01_AED")
    private BigDecimal cs01Aed;

    @Column(name = "CS01_SHOCK_BPS")
    private Integer cs01ShockBps;

    @Column(name = "CS01_LIMIT")
    private BigDecimal cs01Limit;

    @Column(name = "CS01_STATUS")
    private String cs01Status;

    @Column(name = "CS01_INVESTMENT_GRADE_AED")
    private BigDecimal cs01InvestmentGradeAed;

    @Column(name = "CS01_SUB_INVESTMENT_AED")
    private BigDecimal cs01SubInvestmentAed;

    @Column(name = "CS01_UNRATED_AED")
    private BigDecimal cs01UnratedAed;

    @Column(name = "CS01_CHECK")
    private String cs01Check;

    @Column(name = "BETA_EQUITY")
    private BigDecimal betaEquity;

    @Column(name = "EQUITY_SHOCK_BPS")
    private Integer equityShockBps;

    @Column(name = "EQUITY_LIMIT")
    private BigDecimal equityLimit;

    @Column(name = "EQUITY_STATUS")
    private String equityStatus;

    @Column(name = "CREDIT_SPREAD_IMPACT_AED")
    private BigDecimal creditSpreadImpactAed;

    @Column(name = "CREDIT_SENSITIVE_IMPACT_PCT")
    private BigDecimal creditSensitiveImpactPct;

    @Column(name = "INTEREST_RATE_IMPACT_AED")
    private BigDecimal interestRateImpactAed;

    @Column(name = "RATE_SENSITIVE_IMPACT_PCT")
    private BigDecimal rateSensitiveImpactPct;

    @Column(name = "FX_IMPACT_AED")
    private BigDecimal fxImpactAed;

    @Column(name = "FX_SENSITIVE_IMPACT_PCT")
    private BigDecimal fxSensitiveImpactPct;

    @Column(name = "EQUITY_IMPACT_AED")
    private BigDecimal equityImpactAed;

    @Column(name = "EQUITY_SENSITIVE_IMPACT_PCT")
    private BigDecimal equitySensitiveImpactPct;

    @Column(name = "COMMODITIES_IMPACT_AED")
    private BigDecimal commoditiesImpactAed;

    @Column(name = "COMMODITY_SENSITIVE_IMPACT_PCT")
    private BigDecimal commoditySensitiveImpactPct;

    @Column(name = "JTD_LOSS_IMPACT_AED")
    private BigDecimal jtdLossImpactAed;

    @Column(name = "JTD_RELATIVE_IMPACT_PCT")
    private BigDecimal jtdRelativeImpactPct;

    @Column(name = "OVERALL_IMPACT_AED")
    private BigDecimal overallImpactAed;

    @Column(name = "CORE_TIER1_RELATIVE_IMPACT_PCT")
    private BigDecimal coreTier1RelativeImpactPct;

    @Column(name = "REPORT_SUBMIT_DATE")
    private Date reportSubmitDate;

    @Column(name = "ENTITY_FLG")
    private String entityFlg;

    @Column(name = "MODIFY_FLG")
    private String modifyFlg;

    @Column(name = "DEL_FLG")
    private String delFlg;

    @Column(name = "REPORT_FROM_DATE")
    private Date reportFromDate;

    @Column(name = "REPORT_TO_DATE")
    private Date reportToDate;

    @Column(name = "REPORT_DATE")
    private Date reportDate;

    @Column(name = "REPORT_CODE", length = 10)
    private String reportCode;

    @Column(name = "ENTRY_USER", length = 20)
    private String entryUser;

    @Column(name = "MODIFY_USER", length = 20)
    private String modifyUser;

    @Column(name = "VERIFY_USER", length = 20)
    private String verifyUser;

    @Column(name = "ENTRY_TIME")
    private Date entryTime;
    
    @Column(name="VERIFY_TIME")
    private Date verifyTime;

    @Column(name = "MODIFY_TIME")
    private Date modifyTime;

	public Long getSI_NO() {
		return SI_NO;
	}

	public void setSI_NO(Long sI_NO) {
		SI_NO = sI_NO;
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

	public String getGroupHeadOfficeSubsidiary() {
		return groupHeadOfficeSubsidiary;
	}

	public void setGroupHeadOfficeSubsidiary(String groupHeadOfficeSubsidiary) {
		this.groupHeadOfficeSubsidiary = groupHeadOfficeSubsidiary;
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

	public BigDecimal getAssetBalanceSheetSizeAed() {
		return assetBalanceSheetSizeAed;
	}

	public void setAssetBalanceSheetSizeAed(BigDecimal assetBalanceSheetSizeAed) {
		this.assetBalanceSheetSizeAed = assetBalanceSheetSizeAed;
	}

	public BigDecimal getInvestmentBookSizeAed() {
		return investmentBookSizeAed;
	}

	public void setInvestmentBookSizeAed(BigDecimal investmentBookSizeAed) {
		this.investmentBookSizeAed = investmentBookSizeAed;
	}

	public BigDecimal getBookSizeTotalAssetsPct() {
		return bookSizeTotalAssetsPct;
	}

	public void setBookSizeTotalAssetsPct(BigDecimal bookSizeTotalAssetsPct) {
		this.bookSizeTotalAssetsPct = bookSizeTotalAssetsPct;
	}

	public BigDecimal getYtdNetPnlAed() {
		return ytdNetPnlAed;
	}

	public void setYtdNetPnlAed(BigDecimal ytdNetPnlAed) {
		this.ytdNetPnlAed = ytdNetPnlAed;
	}

	public BigDecimal getYtdFvtociUnrealizedLossAed() {
		return ytdFvtociUnrealizedLossAed;
	}

	public void setYtdFvtociUnrealizedLossAed(BigDecimal ytdFvtociUnrealizedLossAed) {
		this.ytdFvtociUnrealizedLossAed = ytdFvtociUnrealizedLossAed;
	}

	public BigDecimal getCet1Aed() {
		return cet1Aed;
	}

	public void setCet1Aed(BigDecimal cet1Aed) {
		this.cet1Aed = cet1Aed;
	}

	public BigDecimal getUglCoreTier1RelativeImpactPct() {
		return uglCoreTier1RelativeImpactPct;
	}

	public void setUglCoreTier1RelativeImpactPct(BigDecimal uglCoreTier1RelativeImpactPct) {
		this.uglCoreTier1RelativeImpactPct = uglCoreTier1RelativeImpactPct;
	}

	public BigDecimal getYtdAmortizedUnrealizedLossAed() {
		return ytdAmortizedUnrealizedLossAed;
	}

	public void setYtdAmortizedUnrealizedLossAed(BigDecimal ytdAmortizedUnrealizedLossAed) {
		this.ytdAmortizedUnrealizedLossAed = ytdAmortizedUnrealizedLossAed;
	}

	public BigDecimal getYtdHqlaAcUnrealizedLossAed() {
		return ytdHqlaAcUnrealizedLossAed;
	}

	public void setYtdHqlaAcUnrealizedLossAed(BigDecimal ytdHqlaAcUnrealizedLossAed) {
		this.ytdHqlaAcUnrealizedLossAed = ytdHqlaAcUnrealizedLossAed;
	}

	public BigDecimal getHqlaAcCoreTier1ImpactPct() {
		return hqlaAcCoreTier1ImpactPct;
	}

	public void setHqlaAcCoreTier1ImpactPct(BigDecimal hqlaAcCoreTier1ImpactPct) {
		this.hqlaAcCoreTier1ImpactPct = hqlaAcCoreTier1ImpactPct;
	}

	public BigDecimal getIrVarConfidenceInterval() {
		return irVarConfidenceInterval;
	}

	public void setIrVarConfidenceInterval(BigDecimal irVarConfidenceInterval) {
		this.irVarConfidenceInterval = irVarConfidenceInterval;
	}

	public String getIrVarHoldingPeriod() {
		return irVarHoldingPeriod;
	}

	public void setIrVarHoldingPeriod(String irVarHoldingPeriod) {
		this.irVarHoldingPeriod = irVarHoldingPeriod;
	}

	public BigDecimal getIrFixedIncomeExposureAed() {
		return irFixedIncomeExposureAed;
	}

	public void setIrFixedIncomeExposureAed(BigDecimal irFixedIncomeExposureAed) {
		this.irFixedIncomeExposureAed = irFixedIncomeExposureAed;
	}

	public BigDecimal getIrVarExposureAed() {
		return irVarExposureAed;
	}

	public void setIrVarExposureAed(BigDecimal irVarExposureAed) {
		this.irVarExposureAed = irVarExposureAed;
	}

	public BigDecimal getIrVarLimitAed() {
		return irVarLimitAed;
	}

	public void setIrVarLimitAed(BigDecimal irVarLimitAed) {
		this.irVarLimitAed = irVarLimitAed;
	}

	public String getIrStatus() {
		return irStatus;
	}

	public void setIrStatus(String irStatus) {
		this.irStatus = irStatus;
	}

	public BigDecimal getIrVarImpactPct() {
		return irVarImpactPct;
	}

	public void setIrVarImpactPct(BigDecimal irVarImpactPct) {
		this.irVarImpactPct = irVarImpactPct;
	}

	public BigDecimal getCsVarConfidenceInterval() {
		return csVarConfidenceInterval;
	}

	public void setCsVarConfidenceInterval(BigDecimal csVarConfidenceInterval) {
		this.csVarConfidenceInterval = csVarConfidenceInterval;
	}

	public String getCsVarHoldingPeriod() {
		return csVarHoldingPeriod;
	}

	public void setCsVarHoldingPeriod(String csVarHoldingPeriod) {
		this.csVarHoldingPeriod = csVarHoldingPeriod;
	}

	public BigDecimal getCsFixedIncomeExposureAed() {
		return csFixedIncomeExposureAed;
	}

	public void setCsFixedIncomeExposureAed(BigDecimal csFixedIncomeExposureAed) {
		this.csFixedIncomeExposureAed = csFixedIncomeExposureAed;
	}

	public BigDecimal getCsVarExposureAed() {
		return csVarExposureAed;
	}

	public void setCsVarExposureAed(BigDecimal csVarExposureAed) {
		this.csVarExposureAed = csVarExposureAed;
	}

	public BigDecimal getCsVarLimitAed() {
		return csVarLimitAed;
	}

	public void setCsVarLimitAed(BigDecimal csVarLimitAed) {
		this.csVarLimitAed = csVarLimitAed;
	}

	public String getCsStatus() {
		return csStatus;
	}

	public void setCsStatus(String csStatus) {
		this.csStatus = csStatus;
	}

	public BigDecimal getCsVarImpactPct() {
		return csVarImpactPct;
	}

	public void setCsVarImpactPct(BigDecimal csVarImpactPct) {
		this.csVarImpactPct = csVarImpactPct;
	}

	public BigDecimal getFxVarConfidenceInterval() {
		return fxVarConfidenceInterval;
	}

	public void setFxVarConfidenceInterval(BigDecimal fxVarConfidenceInterval) {
		this.fxVarConfidenceInterval = fxVarConfidenceInterval;
	}

	public String getFxVarHoldingPeriod() {
		return fxVarHoldingPeriod;
	}

	public void setFxVarHoldingPeriod(String fxVarHoldingPeriod) {
		this.fxVarHoldingPeriod = fxVarHoldingPeriod;
	}

	public BigDecimal getFxExposureAed() {
		return fxExposureAed;
	}

	public void setFxExposureAed(BigDecimal fxExposureAed) {
		this.fxExposureAed = fxExposureAed;
	}

	public BigDecimal getFxVarExposureAed() {
		return fxVarExposureAed;
	}

	public void setFxVarExposureAed(BigDecimal fxVarExposureAed) {
		this.fxVarExposureAed = fxVarExposureAed;
	}

	public BigDecimal getFxVarLimitAed() {
		return fxVarLimitAed;
	}

	public void setFxVarLimitAed(BigDecimal fxVarLimitAed) {
		this.fxVarLimitAed = fxVarLimitAed;
	}

	public String getFxStatus() {
		return fxStatus;
	}

	public void setFxStatus(String fxStatus) {
		this.fxStatus = fxStatus;
	}

	public BigDecimal getFxVarImpactPct() {
		return fxVarImpactPct;
	}

	public void setFxVarImpactPct(BigDecimal fxVarImpactPct) {
		this.fxVarImpactPct = fxVarImpactPct;
	}

	public BigDecimal getEqVarConfidenceInterval() {
		return eqVarConfidenceInterval;
	}

	public void setEqVarConfidenceInterval(BigDecimal eqVarConfidenceInterval) {
		this.eqVarConfidenceInterval = eqVarConfidenceInterval;
	}

	public String getEqVarHoldingPeriod() {
		return eqVarHoldingPeriod;
	}

	public void setEqVarHoldingPeriod(String eqVarHoldingPeriod) {
		this.eqVarHoldingPeriod = eqVarHoldingPeriod;
	}

	public BigDecimal getEqExposureAed() {
		return eqExposureAed;
	}

	public void setEqExposureAed(BigDecimal eqExposureAed) {
		this.eqExposureAed = eqExposureAed;
	}

	public BigDecimal getEqVarExposureAed() {
		return eqVarExposureAed;
	}

	public void setEqVarExposureAed(BigDecimal eqVarExposureAed) {
		this.eqVarExposureAed = eqVarExposureAed;
	}

	public BigDecimal getEqVarLimitAed() {
		return eqVarLimitAed;
	}

	public void setEqVarLimitAed(BigDecimal eqVarLimitAed) {
		this.eqVarLimitAed = eqVarLimitAed;
	}

	public String getEqStatus() {
		return eqStatus;
	}

	public void setEqStatus(String eqStatus) {
		this.eqStatus = eqStatus;
	}

	public BigDecimal getEqVarImpactPct() {
		return eqVarImpactPct;
	}

	public void setEqVarImpactPct(BigDecimal eqVarImpactPct) {
		this.eqVarImpactPct = eqVarImpactPct;
	}

	public BigDecimal getCommVarConfidenceInterval() {
		return commVarConfidenceInterval;
	}

	public void setCommVarConfidenceInterval(BigDecimal commVarConfidenceInterval) {
		this.commVarConfidenceInterval = commVarConfidenceInterval;
	}

	public String getCommVarHoldingPeriod() {
		return commVarHoldingPeriod;
	}

	public void setCommVarHoldingPeriod(String commVarHoldingPeriod) {
		this.commVarHoldingPeriod = commVarHoldingPeriod;
	}

	public BigDecimal getCommExposureAed() {
		return commExposureAed;
	}

	public void setCommExposureAed(BigDecimal commExposureAed) {
		this.commExposureAed = commExposureAed;
	}

	public BigDecimal getCommVarExposureAed() {
		return commVarExposureAed;
	}

	public void setCommVarExposureAed(BigDecimal commVarExposureAed) {
		this.commVarExposureAed = commVarExposureAed;
	}

	public BigDecimal getCommVarLimitAed() {
		return commVarLimitAed;
	}

	public void setCommVarLimitAed(BigDecimal commVarLimitAed) {
		this.commVarLimitAed = commVarLimitAed;
	}

	public String getCommStatus() {
		return commStatus;
	}

	public void setCommStatus(String commStatus) {
		this.commStatus = commStatus;
	}

	public BigDecimal getCommVarImpactPct() {
		return commVarImpactPct;
	}

	public void setCommVarImpactPct(BigDecimal commVarImpactPct) {
		this.commVarImpactPct = commVarImpactPct;
	}

	public BigDecimal getOverallVarConfidenceInterval() {
		return overallVarConfidenceInterval;
	}

	public void setOverallVarConfidenceInterval(BigDecimal overallVarConfidenceInterval) {
		this.overallVarConfidenceInterval = overallVarConfidenceInterval;
	}

	public String getOverallVarHoldingPeriod() {
		return overallVarHoldingPeriod;
	}

	public void setOverallVarHoldingPeriod(String overallVarHoldingPeriod) {
		this.overallVarHoldingPeriod = overallVarHoldingPeriod;
	}

	public BigDecimal getVarExposureAed() {
		return varExposureAed;
	}

	public void setVarExposureAed(BigDecimal varExposureAed) {
		this.varExposureAed = varExposureAed;
	}

	public BigDecimal getVarLimitAed() {
		return varLimitAed;
	}

	public void setVarLimitAed(BigDecimal varLimitAed) {
		this.varLimitAed = varLimitAed;
	}

	public String getOverallVarStatus() {
		return overallVarStatus;
	}

	public void setOverallVarStatus(String overallVarStatus) {
		this.overallVarStatus = overallVarStatus;
	}

	public BigDecimal getPortfolioRelativeImpactPct() {
		return portfolioRelativeImpactPct;
	}

	public void setPortfolioRelativeImpactPct(BigDecimal portfolioRelativeImpactPct) {
		this.portfolioRelativeImpactPct = portfolioRelativeImpactPct;
	}

	public BigDecimal getExpectedShortfallExposureAed() {
		return expectedShortfallExposureAed;
	}

	public void setExpectedShortfallExposureAed(BigDecimal expectedShortfallExposureAed) {
		this.expectedShortfallExposureAed = expectedShortfallExposureAed;
	}

	public BigDecimal getExpectedShortfallLimitAed() {
		return expectedShortfallLimitAed;
	}

	public void setExpectedShortfallLimitAed(BigDecimal expectedShortfallLimitAed) {
		this.expectedShortfallLimitAed = expectedShortfallLimitAed;
	}

	public String getExpectedShortfallStatus() {
		return expectedShortfallStatus;
	}

	public void setExpectedShortfallStatus(String expectedShortfallStatus) {
		this.expectedShortfallStatus = expectedShortfallStatus;
	}

	public BigDecimal getExpectedShortfallImpactPct() {
		return expectedShortfallImpactPct;
	}

	public void setExpectedShortfallImpactPct(BigDecimal expectedShortfallImpactPct) {
		this.expectedShortfallImpactPct = expectedShortfallImpactPct;
	}

	public BigDecimal getModifiedDuration() {
		return modifiedDuration;
	}

	public void setModifiedDuration(BigDecimal modifiedDuration) {
		this.modifiedDuration = modifiedDuration;
	}

	public Integer getInterestRateShockBps() {
		return interestRateShockBps;
	}

	public void setInterestRateShockBps(Integer interestRateShockBps) {
		this.interestRateShockBps = interestRateShockBps;
	}

	public BigDecimal getInterestRateLimit() {
		return interestRateLimit;
	}

	public void setInterestRateLimit(BigDecimal interestRateLimit) {
		this.interestRateLimit = interestRateLimit;
	}

	public String getInterestRateStatus() {
		return interestRateStatus;
	}

	public void setInterestRateStatus(String interestRateStatus) {
		this.interestRateStatus = interestRateStatus;
	}

	public BigDecimal getDv01Aed() {
		return dv01Aed;
	}

	public void setDv01Aed(BigDecimal dv01Aed) {
		this.dv01Aed = dv01Aed;
	}

	public BigDecimal getDv01LimitAed() {
		return dv01LimitAed;
	}

	public void setDv01LimitAed(BigDecimal dv01LimitAed) {
		this.dv01LimitAed = dv01LimitAed;
	}

	public String getDv01Status() {
		return dv01Status;
	}

	public void setDv01Status(String dv01Status) {
		this.dv01Status = dv01Status;
	}

	public BigDecimal getDv01TenorGapLt3Aed() {
		return dv01TenorGapLt3Aed;
	}

	public void setDv01TenorGapLt3Aed(BigDecimal dv01TenorGapLt3Aed) {
		this.dv01TenorGapLt3Aed = dv01TenorGapLt3Aed;
	}

	public BigDecimal getDv01TenorGapGt3Aed() {
		return dv01TenorGapGt3Aed;
	}

	public void setDv01TenorGapGt3Aed(BigDecimal dv01TenorGapGt3Aed) {
		this.dv01TenorGapGt3Aed = dv01TenorGapGt3Aed;
	}

	public String getDv01Check() {
		return dv01Check;
	}

	public void setDv01Check(String dv01Check) {
		this.dv01Check = dv01Check;
	}

	public BigDecimal getCs01Aed() {
		return cs01Aed;
	}

	public void setCs01Aed(BigDecimal cs01Aed) {
		this.cs01Aed = cs01Aed;
	}

	public Integer getCs01ShockBps() {
		return cs01ShockBps;
	}

	public void setCs01ShockBps(Integer cs01ShockBps) {
		this.cs01ShockBps = cs01ShockBps;
	}

	public BigDecimal getCs01Limit() {
		return cs01Limit;
	}

	public void setCs01Limit(BigDecimal cs01Limit) {
		this.cs01Limit = cs01Limit;
	}

	public String getCs01Status() {
		return cs01Status;
	}

	public void setCs01Status(String cs01Status) {
		this.cs01Status = cs01Status;
	}

	public BigDecimal getCs01InvestmentGradeAed() {
		return cs01InvestmentGradeAed;
	}

	public void setCs01InvestmentGradeAed(BigDecimal cs01InvestmentGradeAed) {
		this.cs01InvestmentGradeAed = cs01InvestmentGradeAed;
	}

	public BigDecimal getCs01SubInvestmentAed() {
		return cs01SubInvestmentAed;
	}

	public void setCs01SubInvestmentAed(BigDecimal cs01SubInvestmentAed) {
		this.cs01SubInvestmentAed = cs01SubInvestmentAed;
	}

	public BigDecimal getCs01UnratedAed() {
		return cs01UnratedAed;
	}

	public void setCs01UnratedAed(BigDecimal cs01UnratedAed) {
		this.cs01UnratedAed = cs01UnratedAed;
	}

	public String getCs01Check() {
		return cs01Check;
	}

	public void setCs01Check(String cs01Check) {
		this.cs01Check = cs01Check;
	}

	public BigDecimal getBetaEquity() {
		return betaEquity;
	}

	public void setBetaEquity(BigDecimal betaEquity) {
		this.betaEquity = betaEquity;
	}

	public Integer getEquityShockBps() {
		return equityShockBps;
	}

	public void setEquityShockBps(Integer equityShockBps) {
		this.equityShockBps = equityShockBps;
	}

	public BigDecimal getEquityLimit() {
		return equityLimit;
	}

	public void setEquityLimit(BigDecimal equityLimit) {
		this.equityLimit = equityLimit;
	}

	public String getEquityStatus() {
		return equityStatus;
	}

	public void setEquityStatus(String equityStatus) {
		this.equityStatus = equityStatus;
	}

	public BigDecimal getCreditSpreadImpactAed() {
		return creditSpreadImpactAed;
	}

	public void setCreditSpreadImpactAed(BigDecimal creditSpreadImpactAed) {
		this.creditSpreadImpactAed = creditSpreadImpactAed;
	}

	public BigDecimal getCreditSensitiveImpactPct() {
		return creditSensitiveImpactPct;
	}

	public void setCreditSensitiveImpactPct(BigDecimal creditSensitiveImpactPct) {
		this.creditSensitiveImpactPct = creditSensitiveImpactPct;
	}

	public BigDecimal getInterestRateImpactAed() {
		return interestRateImpactAed;
	}

	public void setInterestRateImpactAed(BigDecimal interestRateImpactAed) {
		this.interestRateImpactAed = interestRateImpactAed;
	}

	public BigDecimal getRateSensitiveImpactPct() {
		return rateSensitiveImpactPct;
	}

	public void setRateSensitiveImpactPct(BigDecimal rateSensitiveImpactPct) {
		this.rateSensitiveImpactPct = rateSensitiveImpactPct;
	}

	public BigDecimal getFxImpactAed() {
		return fxImpactAed;
	}

	public void setFxImpactAed(BigDecimal fxImpactAed) {
		this.fxImpactAed = fxImpactAed;
	}

	public BigDecimal getFxSensitiveImpactPct() {
		return fxSensitiveImpactPct;
	}

	public void setFxSensitiveImpactPct(BigDecimal fxSensitiveImpactPct) {
		this.fxSensitiveImpactPct = fxSensitiveImpactPct;
	}

	public BigDecimal getEquityImpactAed() {
		return equityImpactAed;
	}

	public void setEquityImpactAed(BigDecimal equityImpactAed) {
		this.equityImpactAed = equityImpactAed;
	}

	public BigDecimal getEquitySensitiveImpactPct() {
		return equitySensitiveImpactPct;
	}

	public void setEquitySensitiveImpactPct(BigDecimal equitySensitiveImpactPct) {
		this.equitySensitiveImpactPct = equitySensitiveImpactPct;
	}

	public BigDecimal getCommoditiesImpactAed() {
		return commoditiesImpactAed;
	}

	public void setCommoditiesImpactAed(BigDecimal commoditiesImpactAed) {
		this.commoditiesImpactAed = commoditiesImpactAed;
	}

	public BigDecimal getCommoditySensitiveImpactPct() {
		return commoditySensitiveImpactPct;
	}

	public void setCommoditySensitiveImpactPct(BigDecimal commoditySensitiveImpactPct) {
		this.commoditySensitiveImpactPct = commoditySensitiveImpactPct;
	}

	public BigDecimal getJtdLossImpactAed() {
		return jtdLossImpactAed;
	}

	public void setJtdLossImpactAed(BigDecimal jtdLossImpactAed) {
		this.jtdLossImpactAed = jtdLossImpactAed;
	}

	public BigDecimal getJtdRelativeImpactPct() {
		return jtdRelativeImpactPct;
	}

	public void setJtdRelativeImpactPct(BigDecimal jtdRelativeImpactPct) {
		this.jtdRelativeImpactPct = jtdRelativeImpactPct;
	}

	public BigDecimal getOverallImpactAed() {
		return overallImpactAed;
	}

	public void setOverallImpactAed(BigDecimal overallImpactAed) {
		this.overallImpactAed = overallImpactAed;
	}

	public BigDecimal getCoreTier1RelativeImpactPct() {
		return coreTier1RelativeImpactPct;
	}

	public void setCoreTier1RelativeImpactPct(BigDecimal coreTier1RelativeImpactPct) {
		this.coreTier1RelativeImpactPct = coreTier1RelativeImpactPct;
	}

	public Date getReportSubmitDate() {
		return reportSubmitDate;
	}

	public void setReportSubmitDate(Date reportSubmitDate) {
		this.reportSubmitDate = reportSubmitDate;
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

	public Date getVerifyTime() {
		return verifyTime;
	}

	public void setVerifyTime(Date verifyTime) {
		this.verifyTime = verifyTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public RT_Investment_Risk_Data_Dashboard_Template(Long sI_NO, Date dataDate, String bankName,
			String groupHeadOfficeSubsidiary, String subsidiary, String bankSymbol, String conventionalIslamic,
			String localForeign, String cbuAeTiering, BigDecimal assetBalanceSheetSizeAed,
			BigDecimal investmentBookSizeAed, BigDecimal bookSizeTotalAssetsPct, BigDecimal ytdNetPnlAed,
			BigDecimal ytdFvtociUnrealizedLossAed, BigDecimal cet1Aed, BigDecimal uglCoreTier1RelativeImpactPct,
			BigDecimal ytdAmortizedUnrealizedLossAed, BigDecimal ytdHqlaAcUnrealizedLossAed,
			BigDecimal hqlaAcCoreTier1ImpactPct, BigDecimal irVarConfidenceInterval, String irVarHoldingPeriod,
			BigDecimal irFixedIncomeExposureAed, BigDecimal irVarExposureAed, BigDecimal irVarLimitAed, String irStatus,
			BigDecimal irVarImpactPct, BigDecimal csVarConfidenceInterval, String csVarHoldingPeriod,
			BigDecimal csFixedIncomeExposureAed, BigDecimal csVarExposureAed, BigDecimal csVarLimitAed, String csStatus,
			BigDecimal csVarImpactPct, BigDecimal fxVarConfidenceInterval, String fxVarHoldingPeriod,
			BigDecimal fxExposureAed, BigDecimal fxVarExposureAed, BigDecimal fxVarLimitAed, String fxStatus,
			BigDecimal fxVarImpactPct, BigDecimal eqVarConfidenceInterval, String eqVarHoldingPeriod,
			BigDecimal eqExposureAed, BigDecimal eqVarExposureAed, BigDecimal eqVarLimitAed, String eqStatus,
			BigDecimal eqVarImpactPct, BigDecimal commVarConfidenceInterval, String commVarHoldingPeriod,
			BigDecimal commExposureAed, BigDecimal commVarExposureAed, BigDecimal commVarLimitAed, String commStatus,
			BigDecimal commVarImpactPct, BigDecimal overallVarConfidenceInterval, String overallVarHoldingPeriod,
			BigDecimal varExposureAed, BigDecimal varLimitAed, String overallVarStatus,
			BigDecimal portfolioRelativeImpactPct, BigDecimal expectedShortfallExposureAed,
			BigDecimal expectedShortfallLimitAed, String expectedShortfallStatus, BigDecimal expectedShortfallImpactPct,
			BigDecimal modifiedDuration, Integer interestRateShockBps, BigDecimal interestRateLimit,
			String interestRateStatus, BigDecimal dv01Aed, BigDecimal dv01LimitAed, String dv01Status,
			BigDecimal dv01TenorGapLt3Aed, BigDecimal dv01TenorGapGt3Aed, String dv01Check, BigDecimal cs01Aed,
			Integer cs01ShockBps, BigDecimal cs01Limit, String cs01Status, BigDecimal cs01InvestmentGradeAed,
			BigDecimal cs01SubInvestmentAed, BigDecimal cs01UnratedAed, String cs01Check, BigDecimal betaEquity,
			Integer equityShockBps, BigDecimal equityLimit, String equityStatus, BigDecimal creditSpreadImpactAed,
			BigDecimal creditSensitiveImpactPct, BigDecimal interestRateImpactAed, BigDecimal rateSensitiveImpactPct,
			BigDecimal fxImpactAed, BigDecimal fxSensitiveImpactPct, BigDecimal equityImpactAed,
			BigDecimal equitySensitiveImpactPct, BigDecimal commoditiesImpactAed,
			BigDecimal commoditySensitiveImpactPct, BigDecimal jtdLossImpactAed, BigDecimal jtdRelativeImpactPct,
			BigDecimal overallImpactAed, BigDecimal coreTier1RelativeImpactPct, Date reportSubmitDate, String entityFlg,
			String modifyFlg, String delFlg, Date reportFromDate, Date reportToDate, Date reportDate, String reportCode,
			String entryUser, String modifyUser, String verifyUser, Date entryTime, Date verifyTime, Date modifyTime) {
		super();
		SI_NO = sI_NO;
		this.dataDate = dataDate;
		this.bankName = bankName;
		this.groupHeadOfficeSubsidiary = groupHeadOfficeSubsidiary;
		this.subsidiary = subsidiary;
		this.bankSymbol = bankSymbol;
		this.conventionalIslamic = conventionalIslamic;
		this.localForeign = localForeign;
		this.cbuAeTiering = cbuAeTiering;
		this.assetBalanceSheetSizeAed = assetBalanceSheetSizeAed;
		this.investmentBookSizeAed = investmentBookSizeAed;
		this.bookSizeTotalAssetsPct = bookSizeTotalAssetsPct;
		this.ytdNetPnlAed = ytdNetPnlAed;
		this.ytdFvtociUnrealizedLossAed = ytdFvtociUnrealizedLossAed;
		this.cet1Aed = cet1Aed;
		this.uglCoreTier1RelativeImpactPct = uglCoreTier1RelativeImpactPct;
		this.ytdAmortizedUnrealizedLossAed = ytdAmortizedUnrealizedLossAed;
		this.ytdHqlaAcUnrealizedLossAed = ytdHqlaAcUnrealizedLossAed;
		this.hqlaAcCoreTier1ImpactPct = hqlaAcCoreTier1ImpactPct;
		this.irVarConfidenceInterval = irVarConfidenceInterval;
		this.irVarHoldingPeriod = irVarHoldingPeriod;
		this.irFixedIncomeExposureAed = irFixedIncomeExposureAed;
		this.irVarExposureAed = irVarExposureAed;
		this.irVarLimitAed = irVarLimitAed;
		this.irStatus = irStatus;
		this.irVarImpactPct = irVarImpactPct;
		this.csVarConfidenceInterval = csVarConfidenceInterval;
		this.csVarHoldingPeriod = csVarHoldingPeriod;
		this.csFixedIncomeExposureAed = csFixedIncomeExposureAed;
		this.csVarExposureAed = csVarExposureAed;
		this.csVarLimitAed = csVarLimitAed;
		this.csStatus = csStatus;
		this.csVarImpactPct = csVarImpactPct;
		this.fxVarConfidenceInterval = fxVarConfidenceInterval;
		this.fxVarHoldingPeriod = fxVarHoldingPeriod;
		this.fxExposureAed = fxExposureAed;
		this.fxVarExposureAed = fxVarExposureAed;
		this.fxVarLimitAed = fxVarLimitAed;
		this.fxStatus = fxStatus;
		this.fxVarImpactPct = fxVarImpactPct;
		this.eqVarConfidenceInterval = eqVarConfidenceInterval;
		this.eqVarHoldingPeriod = eqVarHoldingPeriod;
		this.eqExposureAed = eqExposureAed;
		this.eqVarExposureAed = eqVarExposureAed;
		this.eqVarLimitAed = eqVarLimitAed;
		this.eqStatus = eqStatus;
		this.eqVarImpactPct = eqVarImpactPct;
		this.commVarConfidenceInterval = commVarConfidenceInterval;
		this.commVarHoldingPeriod = commVarHoldingPeriod;
		this.commExposureAed = commExposureAed;
		this.commVarExposureAed = commVarExposureAed;
		this.commVarLimitAed = commVarLimitAed;
		this.commStatus = commStatus;
		this.commVarImpactPct = commVarImpactPct;
		this.overallVarConfidenceInterval = overallVarConfidenceInterval;
		this.overallVarHoldingPeriod = overallVarHoldingPeriod;
		this.varExposureAed = varExposureAed;
		this.varLimitAed = varLimitAed;
		this.overallVarStatus = overallVarStatus;
		this.portfolioRelativeImpactPct = portfolioRelativeImpactPct;
		this.expectedShortfallExposureAed = expectedShortfallExposureAed;
		this.expectedShortfallLimitAed = expectedShortfallLimitAed;
		this.expectedShortfallStatus = expectedShortfallStatus;
		this.expectedShortfallImpactPct = expectedShortfallImpactPct;
		this.modifiedDuration = modifiedDuration;
		this.interestRateShockBps = interestRateShockBps;
		this.interestRateLimit = interestRateLimit;
		this.interestRateStatus = interestRateStatus;
		this.dv01Aed = dv01Aed;
		this.dv01LimitAed = dv01LimitAed;
		this.dv01Status = dv01Status;
		this.dv01TenorGapLt3Aed = dv01TenorGapLt3Aed;
		this.dv01TenorGapGt3Aed = dv01TenorGapGt3Aed;
		this.dv01Check = dv01Check;
		this.cs01Aed = cs01Aed;
		this.cs01ShockBps = cs01ShockBps;
		this.cs01Limit = cs01Limit;
		this.cs01Status = cs01Status;
		this.cs01InvestmentGradeAed = cs01InvestmentGradeAed;
		this.cs01SubInvestmentAed = cs01SubInvestmentAed;
		this.cs01UnratedAed = cs01UnratedAed;
		this.cs01Check = cs01Check;
		this.betaEquity = betaEquity;
		this.equityShockBps = equityShockBps;
		this.equityLimit = equityLimit;
		this.equityStatus = equityStatus;
		this.creditSpreadImpactAed = creditSpreadImpactAed;
		this.creditSensitiveImpactPct = creditSensitiveImpactPct;
		this.interestRateImpactAed = interestRateImpactAed;
		this.rateSensitiveImpactPct = rateSensitiveImpactPct;
		this.fxImpactAed = fxImpactAed;
		this.fxSensitiveImpactPct = fxSensitiveImpactPct;
		this.equityImpactAed = equityImpactAed;
		this.equitySensitiveImpactPct = equitySensitiveImpactPct;
		this.commoditiesImpactAed = commoditiesImpactAed;
		this.commoditySensitiveImpactPct = commoditySensitiveImpactPct;
		this.jtdLossImpactAed = jtdLossImpactAed;
		this.jtdRelativeImpactPct = jtdRelativeImpactPct;
		this.overallImpactAed = overallImpactAed;
		this.coreTier1RelativeImpactPct = coreTier1RelativeImpactPct;
		this.reportSubmitDate = reportSubmitDate;
		this.entityFlg = entityFlg;
		this.modifyFlg = modifyFlg;
		this.delFlg = delFlg;
		this.reportFromDate = reportFromDate;
		this.reportToDate = reportToDate;
		this.reportDate = reportDate;
		this.reportCode = reportCode;
		this.entryUser = entryUser;
		this.modifyUser = modifyUser;
		this.verifyUser = verifyUser;
		this.entryTime = entryTime;
		this.verifyTime = verifyTime;
		this.modifyTime = modifyTime;
	}

	public RT_Investment_Risk_Data_Dashboard_Template() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
