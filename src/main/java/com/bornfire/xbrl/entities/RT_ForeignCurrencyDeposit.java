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
@Table(name = "BCBUAE_CROSS_CUR_FUNDING_FOREIGN_DEPOSITS")

public class RT_ForeignCurrencyDeposit{
	
	@Id
	private String SI_NO;
	
	@Column(name = "REPORT_DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
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
	
	@Column(name = "DEPOSIT_INTERNAL_REFERENCE")
	private String depositInternalReference;
	
	@Column(name = "ON_BALANCE_SHEET_DEP_TYPE")
	private String onBalanceSheetDepType;
	
	@Column(name = "FUNDING_COUNTERPARTY")
	private String fundingCounterParty;
	
	@Column(name = "COUNTERPARTY_TYPE")
	private String counterpartyType;
	
	@Column(name = "INDUSTRY_GCIS")
	private String industryGcis;
	
	@Column(name = "COUNTERPARTY_COUNTRY_RISK")
	private String counterpartyCountryRisk;
	
	@Column(name = "CBUAE_REGIONAL_ZONE")
	private String cbuaeRegionalZone;
	
	@Column(name = "NOMINAL")
	private BigDecimal nominal;
	
	@Column(name = "NOMINAL_IN_AED")
	private BigDecimal nominalInAed;
	
	@Column(name = "CURRENCY")
	private String currency;
	
	@Column(name = "RATE_TYPE")
	private String rateType;
	
	@Column(name = "DEP_FIXED_RATE_OR_ADMINIS_RATE")
	private BigDecimal depositFixedRateOrAdministrativeRate;
	
	@Column(name = "BENCHMARK_FLOATING_RATE")
	private String benchmarkFloatingRate;
	
	@Column(name = "TENOR_FLOATING_RATE")
	private String tenorFloatingRate;
	
	@Column(name = "SPREAD_OVER_BENCHMARK_RATE")
	private BigDecimal spreadOverBenchmarkRate;
	
	@Column(name = "MATURITY_DATE")
	private Date maturityDate;
	
	@Column(name = "TENOR_MTHS")
	private BigDecimal tenorMths;
	
	@Column(name = "MATURITY_PERIOD")
	private BigDecimal maturityPeriod;
	
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

	public String getDepositInternalReference() {
		return depositInternalReference;
	}

	public void setDepositInternalReference(String depositInternalReference) {
		this.depositInternalReference = depositInternalReference;
	}

	public String getOnBalanceSheetDepType() {
		return onBalanceSheetDepType;
	}

	public void setOnBalanceSheetDepType(String onBalanceSheetDepType) {
		this.onBalanceSheetDepType = onBalanceSheetDepType;
	}

	public String getFundingCounterParty() {
		return fundingCounterParty;
	}

	public void setFundingCounterParty(String fundingCounterParty) {
		this.fundingCounterParty = fundingCounterParty;
	}

	public String getCounterpartyType() {
		return counterpartyType;
	}

	public void setCounterpartyType(String counterpartyType) {
		this.counterpartyType = counterpartyType;
	}

	public String getIndustryGcis() {
		return industryGcis;
	}

	public void setIndustryGcis(String industryGcis) {
		this.industryGcis = industryGcis;
	}

	public String getCounterpartyCountryRisk() {
		return counterpartyCountryRisk;
	}

	public void setCounterpartyCountryRisk(String counterpartyCountryRisk) {
		this.counterpartyCountryRisk = counterpartyCountryRisk;
	}

	public String getCbuaeRegionalZone() {
		return cbuaeRegionalZone;
	}

	public void setCbuaeRegionalZone(String cbuaeRegionalZone) {
		this.cbuaeRegionalZone = cbuaeRegionalZone;
	}

	public BigDecimal getNominal() {
		return nominal;
	}

	public void setNominal(BigDecimal nominal) {
		this.nominal = nominal;
	}

	public BigDecimal getNominalInAed() {
		return nominalInAed;
	}

	public void setNominalInAed(BigDecimal nominalInAed) {
		this.nominalInAed = nominalInAed;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
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

	public String getBenchmarkFloatingRate() {
		return benchmarkFloatingRate;
	}

	public void setBenchmarkFloatingRate(String benchmarkFloatingRate) {
		this.benchmarkFloatingRate = benchmarkFloatingRate;
	}

	public String getTenorFloatingRate() {
		return tenorFloatingRate;
	}

	public void setTenorFloatingRate(String tenorFloatingRate) {
		this.tenorFloatingRate = tenorFloatingRate;
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

	public BigDecimal getMaturityPeriod() {
		return maturityPeriod;
	}

	public void setMaturityPeriod(BigDecimal maturityPeriod) {
		this.maturityPeriod = maturityPeriod;
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

	public RT_ForeignCurrencyDeposit(String sI_NO, Date date, String bankName, String headOfficeSubsidiary,
			String subsidiary, String bankSymbol, String conventionalOrIslamic, String localOrForeign,
			String cbuaeTiering, String depositInternalReference, String onBalanceSheetDepType,
			String fundingCounterParty, String counterpartyType, String industryGcis, String counterpartyCountryRisk,
			String cbuaeRegionalZone, BigDecimal nominal, BigDecimal nominalInAed, String currency, String rateType,
			BigDecimal depositFixedRateOrAdministrativeRate, String benchmarkFloatingRate, String tenorFloatingRate,
			BigDecimal spreadOverBenchmarkRate, Date maturityDate, BigDecimal tenorMths, BigDecimal maturityPeriod,
			Date reportFromDate, Date reportToDate, String entityFlg, String modifyFlg, String delFlg,
			String reportCode, Date reportSubmitDate, String entryUser, String modifyUser, String verifyUser,
			Date entryTime, Date modifyTime, Date verifyTime) {
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
		this.depositInternalReference = depositInternalReference;
		this.onBalanceSheetDepType = onBalanceSheetDepType;
		this.fundingCounterParty = fundingCounterParty;
		this.counterpartyType = counterpartyType;
		this.industryGcis = industryGcis;
		this.counterpartyCountryRisk = counterpartyCountryRisk;
		this.cbuaeRegionalZone = cbuaeRegionalZone;
		this.nominal = nominal;
		this.nominalInAed = nominalInAed;
		this.currency = currency;
		this.rateType = rateType;
		this.depositFixedRateOrAdministrativeRate = depositFixedRateOrAdministrativeRate;
		this.benchmarkFloatingRate = benchmarkFloatingRate;
		this.tenorFloatingRate = tenorFloatingRate;
		this.spreadOverBenchmarkRate = spreadOverBenchmarkRate;
		this.maturityDate = maturityDate;
		this.tenorMths = tenorMths;
		this.maturityPeriod = maturityPeriod;
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

	public RT_ForeignCurrencyDeposit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
