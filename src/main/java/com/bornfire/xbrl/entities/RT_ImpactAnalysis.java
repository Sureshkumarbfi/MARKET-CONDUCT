package com.bornfire.xbrl.entities;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BCBUAE_CROSS_CUR_FUNDING_IMPACT_ANALYSIS")

public class RT_ImpactAnalysis{
	
	@Id
	private String SI_NO;
	
	
	@Column(name = "REPORT_DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@Column(name = "BANK_NAME")
	private String bankName;
	
	@Column(name = "HEAD_OFFICE_SUBSIDIARY")
	private String headOfficeSubsidiary;
	
	@Column(name = "SUBSIDIARY")
	private String subsidiary;
	
	@Column(name = "BANK_SYMBOL")
	private String bankSymbol;
	
	@Column(name = "CONVENTIONAL_OR_ISLAMIC")
	private String conventionalOrIslamic;
	
	@Column(name = "LOCAL_OR_FOREIGN")
	private String localOrForeign;
	
	@Column(name = "CBUAE_TIERING")
	private String cbuaeTiering;
	
	@Column(name = "DEAL_INTERNAL_REFERENCE")
	private String dealInternalReference;
	
	@Column(name = "LEG_TYPE")
	private String legType;
	
	@Column(name = "INTERNAL_COUNTERPARTY_REFERENCE")
	private String internalCounterpartyReference;
	
	@Column(name = "CPTY_NAME")
	private String cptyName;
	
	@Column(name = "DERIVATIVES_CPTY_COUNTRY_OF_RISK")
	private String derivativesCptyCountryOfRisk;
	
	@Column(name = "CBUAE_REGIONAL_ZONE")
	private String cbuaeRegionalZone;
	
	@Column(name = "CCY_BOUGHT")
	private String ccyBought;
	
	@Column(name = "AMOUNT_BOUGHT")
	private BigDecimal amountBought;
	
	@Column(name = "DEAL_RATE")
	private BigDecimal dealRate;
	
	@Column(name = "CCY_SOLD")
	private String ccySold;
	
	@Column(name = "AMOUNT_SOLD")
	private BigDecimal amountSold;
	
	@Column(name = "VALUE_DATE")
	private Date valueDate;
	
	@Column(name = "DEAL_DATE")
	private Date dealDate;
	
	@Column(name = "DERIVATIVES_TENOR_MONTHS")
	private BigDecimal derivativesTenorMonths;
	
	@Column(name = "MATURITY_PERIOD")
	private String maturityPeriod;
	
	@Column(name = "DEALER_NAME")
	private String dealerName;
	
	@Column(name = "MTM_AED_EQUIVALENT_REPORTING_DATE")
	private Date mtmAedEquivalentReportingDate;
	
	@Column(name = "MTM_AED_EQUIVALENT_PREVIOUS_QUARTER")
	private BigDecimal mtmAedEquivalentPreviousQuarter;
	
	@Column(name = "MTM_CHANGE")
	private BigDecimal mtmChange;
	
	@Column(name = "FUNDING_OR_LOANS_INTERNAL_REFERENCE")
	private String fundingOrLoansInternalReference;
	
	@Column(name = "ON_BALANCE_SHEET_ITEM_TYPE")
	private String onBalanceSheetItemType;
	
	@Column(name = "ON_BALANCE_ITEM_COUNTERPARTY")
	private String onBalanceItemCounterparty;
	
	@Column(name = "COUNTERPARTY_COUNTRY_OF_RISK")
	private String counterpartyCountryOfRisk;
	
	@Column(name = "CBUAE_REGIONAL_ZNE")
	private String cbuaeRegionalZne;
	
	@Column(name = "NOMINAL")
	private BigDecimal nominal;
	
	@Column(name = "CURRENCY")
	private String currency;
	
	@Column(name = "OVERALL_IMPACT")
	private BigDecimal overallImpact;
	
	@Column(name = "ACCRUAL_IMPACT")
	private BigDecimal accrualImpact;
	
	@Column(name = "RATE_TYPE")
	private String rateType;
	
	@Column(name = "DEP_FIXED_RATE_OR_ADMINIS_RATE")
	private BigDecimal depositFixedRateOrAdministrativeRate;
	
	@Column(name = "FIXED_DEPOSIT_RATE_EQUIVALENT")
	private BigDecimal fixedDepositRateEquivalent;
	
	@Column(name = "FLOATING_RATE_TYPE")
	private String floatingRateType;
	
	@Column(name = "BENCHMARK_FLOATING_RATE")
	private String benchmarkFloatingRate;
	
	@Column(name = "SPREAD_OVER_BENCHMARK_RATE")
	private BigDecimal spreadOverBenchmarkRate;
	
	@Column(name = "MATURITY_DATE")
	private Date maturityDate;
	
	@Column(name = "TENOR_MTHS")
	private BigDecimal tenorMths;
	
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

	public String getSI_NO() {
		return SI_NO;
	}

	public void setSI_NO(String sI_NO) {
		SI_NO = sI_NO;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getConventionalOrIslamic() {
		return conventionalOrIslamic;
	}

	public void setConventionalOrIslamic(String conventionalOrIslamic) {
		this.conventionalOrIslamic = conventionalOrIslamic;
	}

	public String getLocalOrForeign() {
		return localOrForeign;
	}

	public void setLocalOrForeign(String localOrForeign) {
		this.localOrForeign = localOrForeign;
	}

	public String getCbuaeTiering() {
		return cbuaeTiering;
	}

	public void setCbuaeTiering(String cbuaeTiering) {
		this.cbuaeTiering = cbuaeTiering;
	}

	public String getDealInternalReference() {
		return dealInternalReference;
	}

	public void setDealInternalReference(String dealInternalReference) {
		this.dealInternalReference = dealInternalReference;
	}

	public String getLegType() {
		return legType;
	}

	public void setLegType(String legType) {
		this.legType = legType;
	}

	public String getInternalCounterpartyReference() {
		return internalCounterpartyReference;
	}

	public void setInternalCounterpartyReference(String internalCounterpartyReference) {
		this.internalCounterpartyReference = internalCounterpartyReference;
	}

	public String getCptyName() {
		return cptyName;
	}

	public void setCptyName(String cptyName) {
		this.cptyName = cptyName;
	}

	public String getDerivativesCptyCountryOfRisk() {
		return derivativesCptyCountryOfRisk;
	}

	public void setDerivativesCptyCountryOfRisk(String derivativesCptyCountryOfRisk) {
		this.derivativesCptyCountryOfRisk = derivativesCptyCountryOfRisk;
	}

	public String getCbuaeRegionalZone() {
		return cbuaeRegionalZone;
	}

	public void setCbuaeRegionalZone(String cbuaeRegionalZone) {
		this.cbuaeRegionalZone = cbuaeRegionalZone;
	}

	public String getCcyBought() {
		return ccyBought;
	}

	public void setCcyBought(String ccyBought) {
		this.ccyBought = ccyBought;
	}

	public BigDecimal getAmountBought() {
		return amountBought;
	}

	public void setAmountBought(BigDecimal amountBought) {
		this.amountBought = amountBought;
	}

	public BigDecimal getDealRate() {
		return dealRate;
	}

	public void setDealRate(BigDecimal dealRate) {
		this.dealRate = dealRate;
	}

	public String getCcySold() {
		return ccySold;
	}

	public void setCcySold(String ccySold) {
		this.ccySold = ccySold;
	}

	public BigDecimal getAmountSold() {
		return amountSold;
	}

	public void setAmountSold(BigDecimal amountSold) {
		this.amountSold = amountSold;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public Date getDealDate() {
		return dealDate;
	}

	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}

	public BigDecimal getDerivativesTenorMonths() {
		return derivativesTenorMonths;
	}

	public void setDerivativesTenorMonths(BigDecimal derivativesTenorMonths) {
		this.derivativesTenorMonths = derivativesTenorMonths;
	}

	public String getMaturityPeriod() {
		return maturityPeriod;
	}

	public void setMaturityPeriod(String maturityPeriod) {
		this.maturityPeriod = maturityPeriod;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public Date getMtmAedEquivalentReportingDate() {
		return mtmAedEquivalentReportingDate;
	}

	public void setMtmAedEquivalentReportingDate(Date mtmAedEquivalentReportingDate) {
		this.mtmAedEquivalentReportingDate = mtmAedEquivalentReportingDate;
	}

	public BigDecimal getMtmAedEquivalentPreviousQuarter() {
		return mtmAedEquivalentPreviousQuarter;
	}

	public void setMtmAedEquivalentPreviousQuarter(BigDecimal mtmAedEquivalentPreviousQuarter) {
		this.mtmAedEquivalentPreviousQuarter = mtmAedEquivalentPreviousQuarter;
	}

	public BigDecimal getMtmChange() {
		return mtmChange;
	}

	public void setMtmChange(BigDecimal mtmChange) {
		this.mtmChange = mtmChange;
	}

	public String getFundingOrLoansInternalReference() {
		return fundingOrLoansInternalReference;
	}

	public void setFundingOrLoansInternalReference(String fundingOrLoansInternalReference) {
		this.fundingOrLoansInternalReference = fundingOrLoansInternalReference;
	}

	public String getOnBalanceSheetItemType() {
		return onBalanceSheetItemType;
	}

	public void setOnBalanceSheetItemType(String onBalanceSheetItemType) {
		this.onBalanceSheetItemType = onBalanceSheetItemType;
	}

	public String getOnBalanceItemCounterparty() {
		return onBalanceItemCounterparty;
	}

	public void setOnBalanceItemCounterparty(String onBalanceItemCounterparty) {
		this.onBalanceItemCounterparty = onBalanceItemCounterparty;
	}

	public String getCounterpartyCountryOfRisk() {
		return counterpartyCountryOfRisk;
	}

	public void setCounterpartyCountryOfRisk(String counterpartyCountryOfRisk) {
		this.counterpartyCountryOfRisk = counterpartyCountryOfRisk;
	}

	public String getCbuaeRegionalZne() {
		return cbuaeRegionalZne;
	}

	public void setCbuaeRegionalZne(String cbuaeRegionalZne) {
		this.cbuaeRegionalZne = cbuaeRegionalZne;
	}

	public BigDecimal getNominal() {
		return nominal;
	}

	public void setNominal(BigDecimal nominal) {
		this.nominal = nominal;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getOverallImpact() {
		return overallImpact;
	}

	public void setOverallImpact(BigDecimal overallImpact) {
		this.overallImpact = overallImpact;
	}

	public BigDecimal getAccrualImpact() {
		return accrualImpact;
	}

	public void setAccrualImpact(BigDecimal accrualImpact) {
		this.accrualImpact = accrualImpact;
	}

	public String getRateType() {
		return rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public BigDecimal getDepositFixedRateOrAdministrativeRate() {
		return depositFixedRateOrAdministrativeRate;
	}

	public void setDepositFixedRateOrAdministrativeRate(BigDecimal depositFixedRateOrAdministrativeRate) {
		this.depositFixedRateOrAdministrativeRate = depositFixedRateOrAdministrativeRate;
	}

	public BigDecimal getFixedDepositRateEquivalent() {
		return fixedDepositRateEquivalent;
	}

	public void setFixedDepositRateEquivalent(BigDecimal fixedDepositRateEquivalent) {
		this.fixedDepositRateEquivalent = fixedDepositRateEquivalent;
	}

	public String getFloatingRateType() {
		return floatingRateType;
	}

	public void setFloatingRateType(String floatingRateType) {
		this.floatingRateType = floatingRateType;
	}

	public String getBenchmarkFloatingRate() {
		return benchmarkFloatingRate;
	}

	public void setBenchmarkFloatingRate(String benchmarkFloatingRate) {
		this.benchmarkFloatingRate = benchmarkFloatingRate;
	}

	public BigDecimal getSpreadOverBenchmarkRate() {
		return spreadOverBenchmarkRate;
	}

	public void setSpreadOverBenchmarkRate(BigDecimal spreadOverBenchmarkRate) {
		this.spreadOverBenchmarkRate = spreadOverBenchmarkRate;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public BigDecimal getTenorMths() {
		return tenorMths;
	}

	public void setTenorMths(BigDecimal tenorMths) {
		this.tenorMths = tenorMths;
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

	public Date getReportSubmitDate() {
		return reportSubmitDate;
	}

	public void setReportSubmitDate(Date reportSubmitDate) {
		this.reportSubmitDate = reportSubmitDate;
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

	public RT_ImpactAnalysis(String sI_NO, Date date, String bankName, String headOfficeSubsidiary, String subsidiary,
			String bankSymbol, String conventionalOrIslamic, String localOrForeign, String cbuaeTiering,
			String dealInternalReference, String legType, String internalCounterpartyReference, String cptyName,
			String derivativesCptyCountryOfRisk, String cbuaeRegionalZone, String ccyBought, BigDecimal amountBought,
			BigDecimal dealRate, String ccySold, BigDecimal amountSold, Date valueDate, Date dealDate,
			BigDecimal derivativesTenorMonths, String maturityPeriod, String dealerName,
			Date mtmAedEquivalentReportingDate, BigDecimal mtmAedEquivalentPreviousQuarter, BigDecimal mtmChange,
			String fundingOrLoansInternalReference, String onBalanceSheetItemType, String onBalanceItemCounterparty,
			String counterpartyCountryOfRisk, String cbuaeRegionalZne, BigDecimal nominal, String currency,
			BigDecimal overallImpact, BigDecimal accrualImpact, String rateType,
			BigDecimal depositFixedRateOrAdministrativeRate, BigDecimal fixedDepositRateEquivalent,
			String floatingRateType, String benchmarkFloatingRate, BigDecimal spreadOverBenchmarkRate,
			Date maturityDate, BigDecimal tenorMths, Date reportFromDate, Date reportToDate, String entityFlg,
			String modifyFlg, String delFlg, String reportCode, Date reportSubmitDate, String entryUser,
			String modifyUser, String verifyUser, Date entryTime, Date modifyTime, Date verifyTime) {
		super();
		SI_NO = sI_NO;
		this.date = date;
		this.bankName = bankName;
		this.headOfficeSubsidiary = headOfficeSubsidiary;
		this.subsidiary = subsidiary;
		this.bankSymbol = bankSymbol;
		this.conventionalOrIslamic = conventionalOrIslamic;
		this.localOrForeign = localOrForeign;
		this.cbuaeTiering = cbuaeTiering;
		this.dealInternalReference = dealInternalReference;
		this.legType = legType;
		this.internalCounterpartyReference = internalCounterpartyReference;
		this.cptyName = cptyName;
		this.derivativesCptyCountryOfRisk = derivativesCptyCountryOfRisk;
		this.cbuaeRegionalZone = cbuaeRegionalZone;
		this.ccyBought = ccyBought;
		this.amountBought = amountBought;
		this.dealRate = dealRate;
		this.ccySold = ccySold;
		this.amountSold = amountSold;
		this.valueDate = valueDate;
		this.dealDate = dealDate;
		this.derivativesTenorMonths = derivativesTenorMonths;
		this.maturityPeriod = maturityPeriod;
		this.dealerName = dealerName;
		this.mtmAedEquivalentReportingDate = mtmAedEquivalentReportingDate;
		this.mtmAedEquivalentPreviousQuarter = mtmAedEquivalentPreviousQuarter;
		this.mtmChange = mtmChange;
		this.fundingOrLoansInternalReference = fundingOrLoansInternalReference;
		this.onBalanceSheetItemType = onBalanceSheetItemType;
		this.onBalanceItemCounterparty = onBalanceItemCounterparty;
		this.counterpartyCountryOfRisk = counterpartyCountryOfRisk;
		this.cbuaeRegionalZne = cbuaeRegionalZne;
		this.nominal = nominal;
		this.currency = currency;
		this.overallImpact = overallImpact;
		this.accrualImpact = accrualImpact;
		this.rateType = rateType;
		this.depositFixedRateOrAdministrativeRate = depositFixedRateOrAdministrativeRate;
		this.fixedDepositRateEquivalent = fixedDepositRateEquivalent;
		this.floatingRateType = floatingRateType;
		this.benchmarkFloatingRate = benchmarkFloatingRate;
		this.spreadOverBenchmarkRate = spreadOverBenchmarkRate;
		this.maturityDate = maturityDate;
		this.tenorMths = tenorMths;
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

	public RT_ImpactAnalysis() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
