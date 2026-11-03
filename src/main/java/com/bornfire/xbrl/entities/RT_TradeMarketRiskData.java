package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BCBUAE_TRADE_MARKET_RISK_DATA")
public class RT_TradeMarketRiskData {

	@Id
	@Column(name = "REPORT_DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date reportDate;

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
	private String cbuaeTiering;

	@Column(name = "TRADING_BOOK_DESKS")
	private String tradingBookDesks;

	@Column(name = "CBUAE_INTERNAL_DESK_REFERENCE")
	private String cbuaeInternalDeskReference;

	@Column(name = "ANNUAL_BUDGET_AED")
	private BigDecimal annualBudgetAed;

	@Column(name = "TRADING_DESK_BOOK_SIZE__MARKET_VALUE_AED")
	private BigDecimal tradingDeskBookSizeMarketValueAed;

	@Column(name = "RELATIVE_SIZE_PERCENT_TOTAL_ASSETS_OR_PERCENT_TOTAL_TRADING_BOOK")
	private BigDecimal relativeSizePercentTotalAssetsOrPercentTotalTradingBook;

	@Column(name = "YTD_P_AND_L_AED")
	private BigDecimal ytdPandLAed;

	@Column(name = "MAXIMUM_LOSS_OVER_THE_PERIOD_AED")
	private BigDecimal maximumLossOverThePeriodAed;

	@Column(name = "CONFIDENCE_INTERVAL")
	private String confidenceInterval;

	@Column(name = "HOLDING_PERIOD")
	private BigDecimal holdingPeriod;

	@Column(name = "VAR_EXPOSURE_AED")
	private BigDecimal varExposureAed;

	@Column(name = "VAR_LIMIT_AED")
	private BigDecimal varLimitAed;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "EXPECTED_SHORTFALL_AED")
	private BigDecimal expectedShortfallAed;

	@Column(name = "EXPECTED_SHORTFALL_LIMIT_AED")
	private BigDecimal expectedShortfallLimitAed;

	@Column(name = "STATUS2")
	private String status2;

	@Column(name = "MODIFIED_DURATION")
	private BigDecimal modifiedDuration;

	@Column(name = "INTEREST_RATE_SHOCK_APPLIED_BPS")
	private BigDecimal interestRateShockAppliedBps;

	@Column(name = "LIMIT1")
	private BigDecimal limit1;

	@Column(name = "STATUS3")
	private String status3;

	@Column(name = "DV01")
	private BigDecimal dv01;

	@Column(name = "LIMIT2")
	private BigDecimal limit2;

	@Column(name = "STATUS4")
	private String status4;

	@Column(name = "DV01_TENOR_GAPS_LT_3YR")
	private BigDecimal dv01TenorGapsLt3Yr;

	@Column(name = "DV01_TENOR_GAPS_GT_3YR")
	private BigDecimal dv01TenorGapsGt3Yr;

	@Column(name = "CREDIT_SPREAD_CS01")
	private BigDecimal creditSpreadCs01;

	@Column(name = "CREDIT_SPREAD_SHOCK_APPLIED_BPS")
	private BigDecimal creditSpreadShockAppliedBps;

	@Column(name = "LIMIT3")
	private BigDecimal limit3;

	@Column(name = "STATUS5")
	private String status5;

	@Column(name = "CREDIT_SPREAD_CS01_INVESTMENT_GRADE")
	private BigDecimal creditSpreadCs01InvestmentGrade;

	@Column(name = "CREDIT_SPREAD_CS01_SUB_INVESTMENT")
	private BigDecimal creditSpreadCs01SubInvestment;

	@Column(name = "CREDIT_SPREAD_CS01_UNRATED")
	private BigDecimal creditSpreadCs01Unrated;

	@Column(name = "BETA_EQUITY")
	private BigDecimal betaEquity;

	@Column(name = "EQUITY_SHOCK_APPLIED_BPS")
	private BigDecimal equityShockAppliedBps;

	@Column(name = "LIMIT4")
	private BigDecimal limit4;

	@Column(name = "STATUS6")
	private String status6;

	@Column(name = "BR01")
	private BigDecimal br01;

	@Column(name = "INTEREST_RATE_DIFFERENTIAL_SHOCK_APPLIED_BPS")
	private BigDecimal interestRateDifferentialShockAppliedBps;

	@Column(name = "LIMIT5")
	private BigDecimal limit5;

	@Column(name = "STATUS7")
	private String status7;

	@Column(name = "DOLLAR_DELTA")
	private BigDecimal dollarDelta;

	@Column(name = "SHOCK_APPLIED_BPS1")
	private BigDecimal shockAppliedBps1;

	@Column(name = "LIMIT6")
	private BigDecimal limit6;

	@Column(name = "STATUS8")
	private String status8;

	@Column(name = "DOLLAR_GAMMA")
	private BigDecimal dollarGamma;

	@Column(name = "SHOCK_APPLIED_BPS2")
	private BigDecimal shockAppliedBps2;

	@Column(name = "LIMIT7")
	private BigDecimal limit7;

	@Column(name = "STATUS9")
	private String status9;

	@Column(name = "DOLLAR_VEGA")
	private BigDecimal dollarVega;

	@Column(name = "IMPLIED_VOLATILITY_TYPE")
	private String impliedVolatilityType;

	@Column(name = "SHOCK_APPLIED_BPS3")
	private BigDecimal shockAppliedBps3;

	@Column(name = "LIMIT8")
	private BigDecimal limit8;

	@Column(name = "STATUS10")
	private String status10;

	@Column(name = "DOLLAR_THETA")
	private BigDecimal dollarTheta;

	@Column(name = "LIMIT9")
	private BigDecimal limit9;

	@Column(name = "STATUS11")
	private String status11;

	@Column(name = "DOLLAR_RHO")
	private BigDecimal dollarRho;

	@Column(name = "SHOCK_APPLIED_BPS4")
	private BigDecimal shockAppliedBps4;

	@Column(name = "LIMIT10")
	private BigDecimal limit10;

	@Column(name = "STATUS12")
	private String status12;

	@Column(name = "DOLLAR_VANNA")
	private BigDecimal dollarVanna;

	@Column(name = "SHOCK_APPLIED_BPS5")
	private BigDecimal shockAppliedBps5;

	@Column(name = "LIMIT11")
	private BigDecimal limit11;

	@Column(name = "STATUS13")
	private String status13;

	@Column(name = "DOLLAR_VOLGA")
	private BigDecimal dollarVolga;

	@Column(name = "SHOCK_APPLIED_BPS6")
	private BigDecimal shockAppliedBps6;

	@Column(name = "LIMIT12")
	private BigDecimal limit12;

	@Column(name = "STATUS14")
	private String status14;

	@Column(name = "CREDIT_SPREAD_AED")
	private BigDecimal creditSpreadAed;

	@Column(name = "CREDIT_SENSITIVE_IMPACT_PERCENT")
	private BigDecimal creditSensitiveImpactPercent;

	@Column(name = "INTEREST_RATE_IN_THE_TRADING_BOOK_AED")
	private BigDecimal interestRateInTheTradingBookAed;

	@Column(name = "RATE_SENSITIVE_IMPACT_PERCENT")
	private BigDecimal rateSensitiveImpactPercent;

	@Column(name = "FOREIGN_EXCHANGE_AED")
	private BigDecimal foreignExchangeAed;

	@Column(name = "FX_SENSITIVE_IMPACT_PERCENT")
	private BigDecimal fxSensitiveImpactPercent;

	@Column(name = "EQUITY_AED")
	private BigDecimal equityAed;

	@Column(name = "EQUITY_SENSITIVE_RELATIVE_IMPACT_PERCENT")
	private BigDecimal equitySensitiveRelativeImpactPercent;

	@Column(name = "COMMODITIES_AED")
	private BigDecimal commoditiesAed;

	@Column(name = "COMMODITY_SENSITIVE_RELATIVE_IMPACT_PERCENT")
	private BigDecimal commoditySensitiveRelativeImpactPercent;

	@Column(name = "CREDIT_DERIVATIVES_AED")
	private BigDecimal creditDerivativesAed;

	@Column(name = "RELATIVE_IMPACT_PERCENT")
	private BigDecimal relativeImpactPercent;

	@Column(name = "JUMP_TO_DEFAULT_LOSS_AED")
	private BigDecimal jumpToDefaultLossAed;

	@Column(name = "JTD_RELATIVE_IMPACT_PERCENT")
	private BigDecimal jtdRelativeImpactPercent;

	@Column(name = "OVERALL_IMPACT_AED")
	private BigDecimal overallImpactAed;

	@Column(name = "OVERALL_RELATIVE_IMPACT_PERCENT")
	private BigDecimal overallRelativeImpactPercent;

	@Column(name = "REPORT_FROM_DATE")
	private Date reportFromDate;

	@Column(name = "REPORT_TO_DATE")
	private Date reportToDate;

	@Column(name = "ENTITY_FLG")
	private String entityFlg;

	@Column(name = "MODIFY_FLG")
	private String modifyFlg;

	@Column(name = "DEL_FLG")
	private String delFlg;

	@Column(name = "REPORT_CODE")
	private String reportCode;

	@Column(name = "REPORT_SUBMIT_DATE")
	private Date reportSubmitDate;

	@Column(name = "ENTRY_USER")
	private String entryUser;

	@Column(name = "MODIFY_USER")
	private String modifyUser;

	@Column(name = "VERIFY_USER")
	private String verifyUser;

	@Column(name = "ENTRY_TIME")
	private Date entryTime;

	@Column(name = "MODIFY_TIME")
	private Date modifyTime;

	@Column(name = "VERIFY_TIME")
	private Date verifyTime;

	public Date getReportDate() {
		return reportDate;
	}

	public String getBankName() {
		return bankName;
	}

	public String getGroupHeadOfficeSubsidiary() {
		return groupHeadOfficeSubsidiary;
	}

	public String getSubsidiary() {
		return subsidiary;
	}

	public String getBankSymbol() {
		return bankSymbol;
	}

	public String getConventionalIslamic() {
		return conventionalIslamic;
	}

	public String getLocalForeign() {
		return localForeign;
	}

	public String getCbuaeTiering() {
		return cbuaeTiering;
	}

	public String getTradingBookDesks() {
		return tradingBookDesks;
	}

	public String getCbuaeInternalDeskReference() {
		return cbuaeInternalDeskReference;
	}

	public BigDecimal getAnnualBudgetAed() {
		return annualBudgetAed;
	}

	public BigDecimal getTradingDeskBookSizeMarketValueAed() {
		return tradingDeskBookSizeMarketValueAed;
	}

	public BigDecimal getRelativeSizePercentTotalAssetsOrPercentTotalTradingBook() {
		return relativeSizePercentTotalAssetsOrPercentTotalTradingBook;
	}

	public BigDecimal getYtdPandLAed() {
		return ytdPandLAed;
	}

	public BigDecimal getMaximumLossOverThePeriodAed() {
		return maximumLossOverThePeriodAed;
	}

	public String getConfidenceInterval() {
		return confidenceInterval;
	}

	public BigDecimal getHoldingPeriod() {
		return holdingPeriod;
	}

	public BigDecimal getVarExposureAed() {
		return varExposureAed;
	}

	public BigDecimal getVarLimitAed() {
		return varLimitAed;
	}

	public String getStatus() {
		return status;
	}

	public BigDecimal getExpectedShortfallAed() {
		return expectedShortfallAed;
	}

	public BigDecimal getExpectedShortfallLimitAed() {
		return expectedShortfallLimitAed;
	}

	public String getStatus2() {
		return status2;
	}

	public BigDecimal getModifiedDuration() {
		return modifiedDuration;
	}

	public BigDecimal getInterestRateShockAppliedBps() {
		return interestRateShockAppliedBps;
	}

	public BigDecimal getLimit1() {
		return limit1;
	}

	public String getStatus3() {
		return status3;
	}

	public BigDecimal getDv01() {
		return dv01;
	}

	public BigDecimal getLimit2() {
		return limit2;
	}

	public String getStatus4() {
		return status4;
	}

	public BigDecimal getDv01TenorGapsLt3Yr() {
		return dv01TenorGapsLt3Yr;
	}

	public BigDecimal getDv01TenorGapsGt3Yr() {
		return dv01TenorGapsGt3Yr;
	}

	public BigDecimal getCreditSpreadCs01() {
		return creditSpreadCs01;
	}

	public BigDecimal getCreditSpreadShockAppliedBps() {
		return creditSpreadShockAppliedBps;
	}

	public BigDecimal getLimit3() {
		return limit3;
	}

	public String getStatus5() {
		return status5;
	}

	public BigDecimal getCreditSpreadCs01InvestmentGrade() {
		return creditSpreadCs01InvestmentGrade;
	}

	public BigDecimal getCreditSpreadCs01SubInvestment() {
		return creditSpreadCs01SubInvestment;
	}

	public BigDecimal getCreditSpreadCs01Unrated() {
		return creditSpreadCs01Unrated;
	}

	public BigDecimal getBetaEquity() {
		return betaEquity;
	}

	public BigDecimal getEquityShockAppliedBps() {
		return equityShockAppliedBps;
	}

	public BigDecimal getLimit4() {
		return limit4;
	}

	public String getStatus6() {
		return status6;
	}

	public BigDecimal getBr01() {
		return br01;
	}

	public BigDecimal getInterestRateDifferentialShockAppliedBps() {
		return interestRateDifferentialShockAppliedBps;
	}

	public BigDecimal getLimit5() {
		return limit5;
	}

	public String getStatus7() {
		return status7;
	}

	public BigDecimal getDollarDelta() {
		return dollarDelta;
	}

	public BigDecimal getShockAppliedBps1() {
		return shockAppliedBps1;
	}

	public BigDecimal getLimit6() {
		return limit6;
	}

	public String getStatus8() {
		return status8;
	}

	public BigDecimal getDollarGamma() {
		return dollarGamma;
	}

	public BigDecimal getShockAppliedBps2() {
		return shockAppliedBps2;
	}

	public BigDecimal getLimit7() {
		return limit7;
	}

	public String getStatus9() {
		return status9;
	}

	public BigDecimal getDollarVega() {
		return dollarVega;
	}

	public String getImpliedVolatilityType() {
		return impliedVolatilityType;
	}

	public BigDecimal getShockAppliedBps3() {
		return shockAppliedBps3;
	}

	public BigDecimal getLimit8() {
		return limit8;
	}

	public String getStatus10() {
		return status10;
	}

	public BigDecimal getDollarTheta() {
		return dollarTheta;
	}

	public BigDecimal getLimit9() {
		return limit9;
	}

	public String getStatus11() {
		return status11;
	}

	public BigDecimal getDollarRho() {
		return dollarRho;
	}

	public BigDecimal getShockAppliedBps4() {
		return shockAppliedBps4;
	}

	public BigDecimal getLimit10() {
		return limit10;
	}

	public String getStatus12() {
		return status12;
	}

	public BigDecimal getDollarVanna() {
		return dollarVanna;
	}

	public BigDecimal getShockAppliedBps5() {
		return shockAppliedBps5;
	}

	public BigDecimal getLimit11() {
		return limit11;
	}

	public String getStatus13() {
		return status13;
	}

	public BigDecimal getDollarVolga() {
		return dollarVolga;
	}

	public BigDecimal getShockAppliedBps6() {
		return shockAppliedBps6;
	}

	public BigDecimal getLimit12() {
		return limit12;
	}

	public String getStatus14() {
		return status14;
	}

	public BigDecimal getCreditSpreadAed() {
		return creditSpreadAed;
	}

	public BigDecimal getCreditSensitiveImpactPercent() {
		return creditSensitiveImpactPercent;
	}

	public BigDecimal getInterestRateInTheTradingBookAed() {
		return interestRateInTheTradingBookAed;
	}

	public BigDecimal getRateSensitiveImpactPercent() {
		return rateSensitiveImpactPercent;
	}

	public BigDecimal getForeignExchangeAed() {
		return foreignExchangeAed;
	}

	public BigDecimal getFxSensitiveImpactPercent() {
		return fxSensitiveImpactPercent;
	}

	public BigDecimal getEquityAed() {
		return equityAed;
	}

	public BigDecimal getEquitySensitiveRelativeImpactPercent() {
		return equitySensitiveRelativeImpactPercent;
	}

	public BigDecimal getCommoditiesAed() {
		return commoditiesAed;
	}

	public BigDecimal getCommoditySensitiveRelativeImpactPercent() {
		return commoditySensitiveRelativeImpactPercent;
	}

	public BigDecimal getCreditDerivativesAed() {
		return creditDerivativesAed;
	}

	public BigDecimal getRelativeImpactPercent() {
		return relativeImpactPercent;
	}

	public BigDecimal getJumpToDefaultLossAed() {
		return jumpToDefaultLossAed;
	}

	public BigDecimal getJtdRelativeImpactPercent() {
		return jtdRelativeImpactPercent;
	}

	public BigDecimal getOverallImpactAed() {
		return overallImpactAed;
	}

	public BigDecimal getOverallRelativeImpactPercent() {
		return overallRelativeImpactPercent;
	}

	public Date getReportFromDate() {
		return reportFromDate;
	}

	public Date getReportToDate() {
		return reportToDate;
	}

	public String getEntityFlg() {
		return entityFlg;
	}

	public String getModifyFlg() {
		return modifyFlg;
	}

	public String getDelFlg() {
		return delFlg;
	}

	public String getReportCode() {
		return reportCode;
	}

	public Date getReportSubmitDate() {
		return reportSubmitDate;
	}

	public String getEntryUser() {
		return entryUser;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public String getVerifyUser() {
		return verifyUser;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public Date getVerifyTime() {
		return verifyTime;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void setGroupHeadOfficeSubsidiary(String groupHeadOfficeSubsidiary) {
		this.groupHeadOfficeSubsidiary = groupHeadOfficeSubsidiary;
	}

	public void setSubsidiary(String subsidiary) {
		this.subsidiary = subsidiary;
	}

	public void setBankSymbol(String bankSymbol) {
		this.bankSymbol = bankSymbol;
	}

	public void setConventionalIslamic(String conventionalIslamic) {
		this.conventionalIslamic = conventionalIslamic;
	}

	public void setLocalForeign(String localForeign) {
		this.localForeign = localForeign;
	}

	public void setCbuaeTiering(String cbuaeTiering) {
		this.cbuaeTiering = cbuaeTiering;
	}

	public void setTradingBookDesks(String tradingBookDesks) {
		this.tradingBookDesks = tradingBookDesks;
	}

	public void setCbuaeInternalDeskReference(String cbuaeInternalDeskReference) {
		this.cbuaeInternalDeskReference = cbuaeInternalDeskReference;
	}

	public void setAnnualBudgetAed(BigDecimal annualBudgetAed) {
		this.annualBudgetAed = annualBudgetAed;
	}

	public void setTradingDeskBookSizeMarketValueAed(BigDecimal tradingDeskBookSizeMarketValueAed) {
		this.tradingDeskBookSizeMarketValueAed = tradingDeskBookSizeMarketValueAed;
	}

	public void setRelativeSizePercentTotalAssetsOrPercentTotalTradingBook(
			BigDecimal relativeSizePercentTotalAssetsOrPercentTotalTradingBook) {
		this.relativeSizePercentTotalAssetsOrPercentTotalTradingBook = relativeSizePercentTotalAssetsOrPercentTotalTradingBook;
	}

	public void setYtdPandLAed(BigDecimal ytdPandLAed) {
		this.ytdPandLAed = ytdPandLAed;
	}

	public void setMaximumLossOverThePeriodAed(BigDecimal maximumLossOverThePeriodAed) {
		this.maximumLossOverThePeriodAed = maximumLossOverThePeriodAed;
	}

	public void setConfidenceInterval(String confidenceInterval) {
		this.confidenceInterval = confidenceInterval;
	}

	public void setHoldingPeriod(BigDecimal holdingPeriod) {
		this.holdingPeriod = holdingPeriod;
	}

	public void setVarExposureAed(BigDecimal varExposureAed) {
		this.varExposureAed = varExposureAed;
	}

	public void setVarLimitAed(BigDecimal varLimitAed) {
		this.varLimitAed = varLimitAed;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setExpectedShortfallAed(BigDecimal expectedShortfallAed) {
		this.expectedShortfallAed = expectedShortfallAed;
	}

	public void setExpectedShortfallLimitAed(BigDecimal expectedShortfallLimitAed) {
		this.expectedShortfallLimitAed = expectedShortfallLimitAed;
	}

	public void setStatus2(String status2) {
		this.status2 = status2;
	}

	public void setModifiedDuration(BigDecimal modifiedDuration) {
		this.modifiedDuration = modifiedDuration;
	}

	public void setInterestRateShockAppliedBps(BigDecimal interestRateShockAppliedBps) {
		this.interestRateShockAppliedBps = interestRateShockAppliedBps;
	}

	public void setLimit1(BigDecimal limit1) {
		this.limit1 = limit1;
	}

	public void setStatus3(String status3) {
		this.status3 = status3;
	}

	public void setDv01(BigDecimal dv01) {
		this.dv01 = dv01;
	}

	public void setLimit2(BigDecimal limit2) {
		this.limit2 = limit2;
	}

	public void setStatus4(String status4) {
		this.status4 = status4;
	}

	public void setDv01TenorGapsLt3Yr(BigDecimal dv01TenorGapsLt3Yr) {
		this.dv01TenorGapsLt3Yr = dv01TenorGapsLt3Yr;
	}

	public void setDv01TenorGapsGt3Yr(BigDecimal dv01TenorGapsGt3Yr) {
		this.dv01TenorGapsGt3Yr = dv01TenorGapsGt3Yr;
	}

	public void setCreditSpreadCs01(BigDecimal creditSpreadCs01) {
		this.creditSpreadCs01 = creditSpreadCs01;
	}

	public void setCreditSpreadShockAppliedBps(BigDecimal creditSpreadShockAppliedBps) {
		this.creditSpreadShockAppliedBps = creditSpreadShockAppliedBps;
	}

	public void setLimit3(BigDecimal limit3) {
		this.limit3 = limit3;
	}

	public void setStatus5(String status5) {
		this.status5 = status5;
	}

	public void setCreditSpreadCs01InvestmentGrade(BigDecimal creditSpreadCs01InvestmentGrade) {
		this.creditSpreadCs01InvestmentGrade = creditSpreadCs01InvestmentGrade;
	}

	public void setCreditSpreadCs01SubInvestment(BigDecimal creditSpreadCs01SubInvestment) {
		this.creditSpreadCs01SubInvestment = creditSpreadCs01SubInvestment;
	}

	public void setCreditSpreadCs01Unrated(BigDecimal creditSpreadCs01Unrated) {
		this.creditSpreadCs01Unrated = creditSpreadCs01Unrated;
	}

	public void setBetaEquity(BigDecimal betaEquity) {
		this.betaEquity = betaEquity;
	}

	public void setEquityShockAppliedBps(BigDecimal equityShockAppliedBps) {
		this.equityShockAppliedBps = equityShockAppliedBps;
	}

	public void setLimit4(BigDecimal limit4) {
		this.limit4 = limit4;
	}

	public void setStatus6(String status6) {
		this.status6 = status6;
	}

	public void setBr01(BigDecimal br01) {
		this.br01 = br01;
	}

	public void setInterestRateDifferentialShockAppliedBps(BigDecimal interestRateDifferentialShockAppliedBps) {
		this.interestRateDifferentialShockAppliedBps = interestRateDifferentialShockAppliedBps;
	}

	public void setLimit5(BigDecimal limit5) {
		this.limit5 = limit5;
	}

	public void setStatus7(String status7) {
		this.status7 = status7;
	}

	public void setDollarDelta(BigDecimal dollarDelta) {
		this.dollarDelta = dollarDelta;
	}

	public void setShockAppliedBps1(BigDecimal shockAppliedBps1) {
		this.shockAppliedBps1 = shockAppliedBps1;
	}

	public void setLimit6(BigDecimal limit6) {
		this.limit6 = limit6;
	}

	public void setStatus8(String status8) {
		this.status8 = status8;
	}

	public void setDollarGamma(BigDecimal dollarGamma) {
		this.dollarGamma = dollarGamma;
	}

	public void setShockAppliedBps2(BigDecimal shockAppliedBps2) {
		this.shockAppliedBps2 = shockAppliedBps2;
	}

	public void setLimit7(BigDecimal limit7) {
		this.limit7 = limit7;
	}

	public void setStatus9(String status9) {
		this.status9 = status9;
	}

	public void setDollarVega(BigDecimal dollarVega) {
		this.dollarVega = dollarVega;
	}

	public void setImpliedVolatilityType(String impliedVolatilityType) {
		this.impliedVolatilityType = impliedVolatilityType;
	}

	public void setShockAppliedBps3(BigDecimal shockAppliedBps3) {
		this.shockAppliedBps3 = shockAppliedBps3;
	}

	public void setLimit8(BigDecimal limit8) {
		this.limit8 = limit8;
	}

	public void setStatus10(String status10) {
		this.status10 = status10;
	}

	public void setDollarTheta(BigDecimal dollarTheta) {
		this.dollarTheta = dollarTheta;
	}

	public void setLimit9(BigDecimal limit9) {
		this.limit9 = limit9;
	}

	public void setStatus11(String status11) {
		this.status11 = status11;
	}

	public void setDollarRho(BigDecimal dollarRho) {
		this.dollarRho = dollarRho;
	}

	public void setShockAppliedBps4(BigDecimal shockAppliedBps4) {
		this.shockAppliedBps4 = shockAppliedBps4;
	}

	public void setLimit10(BigDecimal limit10) {
		this.limit10 = limit10;
	}

	public void setStatus12(String status12) {
		this.status12 = status12;
	}

	public void setDollarVanna(BigDecimal dollarVanna) {
		this.dollarVanna = dollarVanna;
	}

	public void setShockAppliedBps5(BigDecimal shockAppliedBps5) {
		this.shockAppliedBps5 = shockAppliedBps5;
	}

	public void setLimit11(BigDecimal limit11) {
		this.limit11 = limit11;
	}

	public void setStatus13(String status13) {
		this.status13 = status13;
	}

	public void setDollarVolga(BigDecimal dollarVolga) {
		this.dollarVolga = dollarVolga;
	}

	public void setShockAppliedBps6(BigDecimal shockAppliedBps6) {
		this.shockAppliedBps6 = shockAppliedBps6;
	}

	public void setLimit12(BigDecimal limit12) {
		this.limit12 = limit12;
	}

	public void setStatus14(String status14) {
		this.status14 = status14;
	}

	public void setCreditSpreadAed(BigDecimal creditSpreadAed) {
		this.creditSpreadAed = creditSpreadAed;
	}

	public void setCreditSensitiveImpactPercent(BigDecimal creditSensitiveImpactPercent) {
		this.creditSensitiveImpactPercent = creditSensitiveImpactPercent;
	}

	public void setInterestRateInTheTradingBookAed(BigDecimal interestRateInTheTradingBookAed) {
		this.interestRateInTheTradingBookAed = interestRateInTheTradingBookAed;
	}

	public void setRateSensitiveImpactPercent(BigDecimal rateSensitiveImpactPercent) {
		this.rateSensitiveImpactPercent = rateSensitiveImpactPercent;
	}

	public void setForeignExchangeAed(BigDecimal foreignExchangeAed) {
		this.foreignExchangeAed = foreignExchangeAed;
	}

	public void setFxSensitiveImpactPercent(BigDecimal fxSensitiveImpactPercent) {
		this.fxSensitiveImpactPercent = fxSensitiveImpactPercent;
	}

	public void setEquityAed(BigDecimal equityAed) {
		this.equityAed = equityAed;
	}

	public void setEquitySensitiveRelativeImpactPercent(BigDecimal equitySensitiveRelativeImpactPercent) {
		this.equitySensitiveRelativeImpactPercent = equitySensitiveRelativeImpactPercent;
	}

	public void setCommoditiesAed(BigDecimal commoditiesAed) {
		this.commoditiesAed = commoditiesAed;
	}

	public void setCommoditySensitiveRelativeImpactPercent(BigDecimal commoditySensitiveRelativeImpactPercent) {
		this.commoditySensitiveRelativeImpactPercent = commoditySensitiveRelativeImpactPercent;
	}

	public void setCreditDerivativesAed(BigDecimal creditDerivativesAed) {
		this.creditDerivativesAed = creditDerivativesAed;
	}

	public void setRelativeImpactPercent(BigDecimal relativeImpactPercent) {
		this.relativeImpactPercent = relativeImpactPercent;
	}

	public void setJumpToDefaultLossAed(BigDecimal jumpToDefaultLossAed) {
		this.jumpToDefaultLossAed = jumpToDefaultLossAed;
	}

	public void setJtdRelativeImpactPercent(BigDecimal jtdRelativeImpactPercent) {
		this.jtdRelativeImpactPercent = jtdRelativeImpactPercent;
	}

	public void setOverallImpactAed(BigDecimal overallImpactAed) {
		this.overallImpactAed = overallImpactAed;
	}

	public void setOverallRelativeImpactPercent(BigDecimal overallRelativeImpactPercent) {
		this.overallRelativeImpactPercent = overallRelativeImpactPercent;
	}

	public void setReportFromDate(Date reportFromDate) {
		this.reportFromDate = reportFromDate;
	}

	public void setReportToDate(Date reportToDate) {
		this.reportToDate = reportToDate;
	}

	public void setEntityFlg(String entityFlg) {
		this.entityFlg = entityFlg;
	}

	public void setModifyFlg(String modifyFlg) {
		this.modifyFlg = modifyFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}

	public void setReportSubmitDate(Date reportSubmitDate) {
		this.reportSubmitDate = reportSubmitDate;
	}

	public void setEntryUser(String entryUser) {
		this.entryUser = entryUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public void setVerifyUser(String verifyUser) {
		this.verifyUser = verifyUser;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public void setVerifyTime(Date verifyTime) {
		this.verifyTime = verifyTime;
	}

	public RT_TradeMarketRiskData(Date reportDate, String bankName, String groupHeadOfficeSubsidiary,
			String subsidiary, String bankSymbol, String conventionalIslamic, String localForeign, String cbuaeTiering,
			String tradingBookDesks, String cbuaeInternalDeskReference, BigDecimal annualBudgetAed,
			BigDecimal tradingDeskBookSizeMarketValueAed,
			BigDecimal relativeSizePercentTotalAssetsOrPercentTotalTradingBook, BigDecimal ytdPandLAed,
			BigDecimal maximumLossOverThePeriodAed, String confidenceInterval, BigDecimal holdingPeriod,
			BigDecimal varExposureAed, BigDecimal varLimitAed, String status, BigDecimal expectedShortfallAed,
			BigDecimal expectedShortfallLimitAed, String status2, BigDecimal modifiedDuration,
			BigDecimal interestRateShockAppliedBps, BigDecimal limit1, String status3, BigDecimal dv01,
			BigDecimal limit2, String status4, BigDecimal dv01TenorGapsLt3Yr, BigDecimal dv01TenorGapsGt3Yr,
			BigDecimal creditSpreadCs01, BigDecimal creditSpreadShockAppliedBps, BigDecimal limit3, String status5,
			BigDecimal creditSpreadCs01InvestmentGrade, BigDecimal creditSpreadCs01SubInvestment,
			BigDecimal creditSpreadCs01Unrated, BigDecimal betaEquity, BigDecimal equityShockAppliedBps,
			BigDecimal limit4, String status6, BigDecimal br01, BigDecimal interestRateDifferentialShockAppliedBps,
			BigDecimal limit5, String status7, BigDecimal dollarDelta, BigDecimal shockAppliedBps1, BigDecimal limit6,
			String status8, BigDecimal dollarGamma, BigDecimal shockAppliedBps2, BigDecimal limit7, String status9,
			BigDecimal dollarVega, String impliedVolatilityType, BigDecimal shockAppliedBps3, BigDecimal limit8,
			String status10, BigDecimal dollarTheta, BigDecimal limit9, String status11, BigDecimal dollarRho,
			BigDecimal shockAppliedBps4, BigDecimal limit10, String status12, BigDecimal dollarVanna,
			BigDecimal shockAppliedBps5, BigDecimal limit11, String status13, BigDecimal dollarVolga,
			BigDecimal shockAppliedBps6, BigDecimal limit12, String status14, BigDecimal creditSpreadAed,
			BigDecimal creditSensitiveImpactPercent, BigDecimal interestRateInTheTradingBookAed,
			BigDecimal rateSensitiveImpactPercent, BigDecimal foreignExchangeAed, BigDecimal fxSensitiveImpactPercent,
			BigDecimal equityAed, BigDecimal equitySensitiveRelativeImpactPercent, BigDecimal commoditiesAed,
			BigDecimal commoditySensitiveRelativeImpactPercent, BigDecimal creditDerivativesAed,
			BigDecimal relativeImpactPercent, BigDecimal jumpToDefaultLossAed, BigDecimal jtdRelativeImpactPercent,
			BigDecimal overallImpactAed, BigDecimal overallRelativeImpactPercent, Date reportFromDate,
			Date reportToDate, String entityFlg, String modifyFlg, String delFlg, String reportCode,
			Date reportSubmitDate, String entryUser, String modifyUser, String verifyUser, Date entryTime,
			Date modifyTime, Date verifyTime) {
		super();
		this.reportDate = reportDate;
		this.bankName = bankName;
		this.groupHeadOfficeSubsidiary = groupHeadOfficeSubsidiary;
		this.subsidiary = subsidiary;
		this.bankSymbol = bankSymbol;
		this.conventionalIslamic = conventionalIslamic;
		this.localForeign = localForeign;
		this.cbuaeTiering = cbuaeTiering;
		this.tradingBookDesks = tradingBookDesks;
		this.cbuaeInternalDeskReference = cbuaeInternalDeskReference;
		this.annualBudgetAed = annualBudgetAed;
		this.tradingDeskBookSizeMarketValueAed = tradingDeskBookSizeMarketValueAed;
		this.relativeSizePercentTotalAssetsOrPercentTotalTradingBook = relativeSizePercentTotalAssetsOrPercentTotalTradingBook;
		this.ytdPandLAed = ytdPandLAed;
		this.maximumLossOverThePeriodAed = maximumLossOverThePeriodAed;
		this.confidenceInterval = confidenceInterval;
		this.holdingPeriod = holdingPeriod;
		this.varExposureAed = varExposureAed;
		this.varLimitAed = varLimitAed;
		this.status = status;
		this.expectedShortfallAed = expectedShortfallAed;
		this.expectedShortfallLimitAed = expectedShortfallLimitAed;
		this.status2 = status2;
		this.modifiedDuration = modifiedDuration;
		this.interestRateShockAppliedBps = interestRateShockAppliedBps;
		this.limit1 = limit1;
		this.status3 = status3;
		this.dv01 = dv01;
		this.limit2 = limit2;
		this.status4 = status4;
		this.dv01TenorGapsLt3Yr = dv01TenorGapsLt3Yr;
		this.dv01TenorGapsGt3Yr = dv01TenorGapsGt3Yr;
		this.creditSpreadCs01 = creditSpreadCs01;
		this.creditSpreadShockAppliedBps = creditSpreadShockAppliedBps;
		this.limit3 = limit3;
		this.status5 = status5;
		this.creditSpreadCs01InvestmentGrade = creditSpreadCs01InvestmentGrade;
		this.creditSpreadCs01SubInvestment = creditSpreadCs01SubInvestment;
		this.creditSpreadCs01Unrated = creditSpreadCs01Unrated;
		this.betaEquity = betaEquity;
		this.equityShockAppliedBps = equityShockAppliedBps;
		this.limit4 = limit4;
		this.status6 = status6;
		this.br01 = br01;
		this.interestRateDifferentialShockAppliedBps = interestRateDifferentialShockAppliedBps;
		this.limit5 = limit5;
		this.status7 = status7;
		this.dollarDelta = dollarDelta;
		this.shockAppliedBps1 = shockAppliedBps1;
		this.limit6 = limit6;
		this.status8 = status8;
		this.dollarGamma = dollarGamma;
		this.shockAppliedBps2 = shockAppliedBps2;
		this.limit7 = limit7;
		this.status9 = status9;
		this.dollarVega = dollarVega;
		this.impliedVolatilityType = impliedVolatilityType;
		this.shockAppliedBps3 = shockAppliedBps3;
		this.limit8 = limit8;
		this.status10 = status10;
		this.dollarTheta = dollarTheta;
		this.limit9 = limit9;
		this.status11 = status11;
		this.dollarRho = dollarRho;
		this.shockAppliedBps4 = shockAppliedBps4;
		this.limit10 = limit10;
		this.status12 = status12;
		this.dollarVanna = dollarVanna;
		this.shockAppliedBps5 = shockAppliedBps5;
		this.limit11 = limit11;
		this.status13 = status13;
		this.dollarVolga = dollarVolga;
		this.shockAppliedBps6 = shockAppliedBps6;
		this.limit12 = limit12;
		this.status14 = status14;
		this.creditSpreadAed = creditSpreadAed;
		this.creditSensitiveImpactPercent = creditSensitiveImpactPercent;
		this.interestRateInTheTradingBookAed = interestRateInTheTradingBookAed;
		this.rateSensitiveImpactPercent = rateSensitiveImpactPercent;
		this.foreignExchangeAed = foreignExchangeAed;
		this.fxSensitiveImpactPercent = fxSensitiveImpactPercent;
		this.equityAed = equityAed;
		this.equitySensitiveRelativeImpactPercent = equitySensitiveRelativeImpactPercent;
		this.commoditiesAed = commoditiesAed;
		this.commoditySensitiveRelativeImpactPercent = commoditySensitiveRelativeImpactPercent;
		this.creditDerivativesAed = creditDerivativesAed;
		this.relativeImpactPercent = relativeImpactPercent;
		this.jumpToDefaultLossAed = jumpToDefaultLossAed;
		this.jtdRelativeImpactPercent = jtdRelativeImpactPercent;
		this.overallImpactAed = overallImpactAed;
		this.overallRelativeImpactPercent = overallRelativeImpactPercent;
		this.reportFromDate = reportFromDate;
		this.reportToDate = reportToDate;
		this.entityFlg = entityFlg;
		this.modifyFlg = modifyFlg;
		this.delFlg = delFlg;
		this.reportCode = reportCode;
		this.reportSubmitDate = reportSubmitDate;
		this.entryUser = entryUser;
		this.modifyUser = modifyUser;
		this.verifyUser = verifyUser;
		this.entryTime = entryTime;
		this.modifyTime = modifyTime;
		this.verifyTime = verifyTime;
	}

	public RT_TradeMarketRiskData() {
		super();
		// TODO Auto-generated constructor stub
	}

}
