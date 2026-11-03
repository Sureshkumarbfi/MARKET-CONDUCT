package com.bornfire.xbrl.entities;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "BCBUAE_REPO_DATA_TEMPLATE")
public class RT_RepoDataTemplate {

    @Id
    @Column(name = "SL_NO")
    private Long slNo;

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
    private String cbuaeTiering;

    @Column(name = "COUNTERPARTY_NAME")
    private String counterpartyName;

    @Column(name = "COUNTERPARTY_INTERNAL_REF")
    private String counterpartyInternalRef;

    @Column(name = "FINAL_RATING_BANKS")
    private String finalRatingBanks;

    @Column(name = "FINAL_RATING_CBUAE")
    private String finalRatingCbuae;

    @Column(name = "COUNTRY_OF_RISK")
    private String countryOfRisk;

    @Column(name = "CBUAE_GEO_ZONE")
    private String cbuaeGeoZone;

    @Column(name = "CBUAE_INTERNAL_REF")
    private String cbuaeInternalRef;

    @Column(name = "TRANSACTION_TYPE")
    private String transactionType;

    @Column(name = "DEAL_NO")
    private String dealNo;

    @Column(name = "REPO_START_DATE")
    private Date repoStartDate;

    @Column(name = "REPO_MATURITY_DATE")
    private Date repoMaturityDate;

    @Column(name = "INITIAL_MATURITY")
    private Double initialMaturity;

    @Column(name = "INITIAL_MATURITY_ROUNDED")
    private Integer initialMaturityRounded;

    @Column(name = "INITIAL_MATURITY_PERIOD")
    private BigDecimal initialMaturityPeriod;

    @Column(name = "RESIDUAL_MATURITY_DATE")
    private Date residualMaturityDate;

    @Column(name = "MATURITY_PERIOD")
    private BigDecimal maturityPeriod;

    @Column(name = "REPO_CURRENCY")
    private String repoCurrency;

    @Column(name = "UNDERLYING_SECURITY_ISIN")
    private String underlyingSecurityIsin;

    @Column(name = "REHYPOTHECATION_STATUS")
    private String rehypothecationStatus;

    @Column(name = "SECURITY_CURRENCY")
    private String securityCurrency;

    @Column(name = "OBLIGOR")
    private String obligor;

    @Column(name = "ISSUER_TYPE")
    private String issuerType;

    @Column(name = "INDUSTRY")
    private String industry;

    @Column(name = "SECTOR")
    private String sector;

    @Column(name = "UNDERLYING_BOND_DETAILS")
    private String underlyingBondDetails;

    @Column(name = "SECURITY_FINAL_RATING")
    private String securityFinalRating;

    @Column(name = "FINAL_SECURITY_RATING_CBUAE")
    private String finalSecurityRatingCbuae;

    @Column(name = "SECURITY_COUNTRY_OF_RISK")
    private String securityCountryOfRisk;

    @Column(name = "CBUAE_GEO_ZONE_2")
    private String cbuaeGeoZone2;

    @Column(name = "BOND_SUKUK_NOMINAL")
    private Double bondSukukNominal;

    @Column(name = "SECURITY_MATURITY_DATE")
    private Date securityMaturityDate;

    @Column(name = "SECURITY_RESIDUAL_MATURITY")
    private Date securityResidualMaturity;

    @Column(name = "SECURITY_MATURITY_PERIOD")
    private BigDecimal securityMaturityPeriod;

    @Column(name = "GMRA_EFFECTIVE_HAIRCUT")
    private Double gmraEffectiveHaircut;

    @Column(name = "SECURITY_START_PRICE")
    private Double securityStartPrice;

    @Column(name = "SECURITY_START_CASH_AMOUNT")
    private Double securityStartCashAmount;

    @Column(name = "START_CASH_AMOUNT")
    private Double startCashAmount;

    @Column(name = "INTEREST_PROFIT_RATE")
    private Double interestProfitRate;

    @Column(name = "FIXED_RATE")
    private Double fixedRate;

    @Column(name = "FLOATING_RATE_TYPE")
    private String floatingRateType;

    @Column(name = "REPO_MARGIN")
    private Double repoMargin;

    @Column(name = "INTEREST_ACCRUALS")
    private Double interestAccruals;

    @Column(name = "REPO_VALUATION")
    private Double repoValuation;

    @Column(name = "DIRTY_PRICE")
    private Double dirtyPrice;

    @Column(name = "GMRA_COLLATERAL_MTM")
    private Double gmraCollateralMtm;

    @Column(name = "MIN_TRANSFER_AMOUNT")
    private Double minTransferAmount;

    @Column(name = "THRESHOLD")
    private Double threshold;

    @Column(name = "MARGIN_CALL_FREQ")
    private String marginCallFreq;

    @Column(name = "REPORT_SUBMIT_DATE")
    private Date reportSubmitDate;

    @Column(name = "REPORT_DATE")
    private Date reportDate;

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

    @Column(name = "MODIFY_TIME")
    private Date modifyTime;

	public Long getSlNo() {
		return slNo;
	}

	public void setSlNo(Long slNo) {
		this.slNo = slNo;
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

	public String getCbuaeTiering() {
		return cbuaeTiering;
	}

	public void setCbuaeTiering(String cbuaeTiering) {
		this.cbuaeTiering = cbuaeTiering;
	}

	public String getCounterpartyName() {
		return counterpartyName;
	}

	public void setCounterpartyName(String counterpartyName) {
		this.counterpartyName = counterpartyName;
	}

	public String getCounterpartyInternalRef() {
		return counterpartyInternalRef;
	}

	public void setCounterpartyInternalRef(String counterpartyInternalRef) {
		this.counterpartyInternalRef = counterpartyInternalRef;
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

	public String getCountryOfRisk() {
		return countryOfRisk;
	}

	public void setCountryOfRisk(String countryOfRisk) {
		this.countryOfRisk = countryOfRisk;
	}

	public String getCbuaeGeoZone() {
		return cbuaeGeoZone;
	}

	public void setCbuaeGeoZone(String cbuaeGeoZone) {
		this.cbuaeGeoZone = cbuaeGeoZone;
	}

	public String getCbuaeInternalRef() {
		return cbuaeInternalRef;
	}

	public void setCbuaeInternalRef(String cbuaeInternalRef) {
		this.cbuaeInternalRef = cbuaeInternalRef;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getDealNo() {
		return dealNo;
	}

	public void setDealNo(String dealNo) {
		this.dealNo = dealNo;
	}

	public Date getRepoStartDate() {
		return repoStartDate;
	}

	public void setRepoStartDate(Date repoStartDate) {
		this.repoStartDate = repoStartDate;
	}

	public Date getRepoMaturityDate() {
		return repoMaturityDate;
	}

	public void setRepoMaturityDate(Date repoMaturityDate) {
		this.repoMaturityDate = repoMaturityDate;
	}

	public Double getInitialMaturity() {
		return initialMaturity;
	}

	public void setInitialMaturity(Double initialMaturity) {
		this.initialMaturity = initialMaturity;
	}

	public Integer getInitialMaturityRounded() {
		return initialMaturityRounded;
	}

	public void setInitialMaturityRounded(Integer initialMaturityRounded) {
		this.initialMaturityRounded = initialMaturityRounded;
	}

	public BigDecimal getInitialMaturityPeriod() {
		return initialMaturityPeriod;
	}

	public void setInitialMaturityPeriod(BigDecimal initialMaturityPeriod) {
		this.initialMaturityPeriod = initialMaturityPeriod;
	}

	public Date getResidualMaturityDate() {
		return residualMaturityDate;
	}

	public void setResidualMaturityDate(Date residualMaturityDate) {
		this.residualMaturityDate = residualMaturityDate;
	}

	public BigDecimal getMaturityPeriod() {
		return maturityPeriod;
	}

	public void setMaturityPeriod(BigDecimal maturityPeriod) {
		this.maturityPeriod = maturityPeriod;
	}

	public String getRepoCurrency() {
		return repoCurrency;
	}

	public void setRepoCurrency(String repoCurrency) {
		this.repoCurrency = repoCurrency;
	}

	public String getUnderlyingSecurityIsin() {
		return underlyingSecurityIsin;
	}

	public void setUnderlyingSecurityIsin(String underlyingSecurityIsin) {
		this.underlyingSecurityIsin = underlyingSecurityIsin;
	}

	public String getRehypothecationStatus() {
		return rehypothecationStatus;
	}

	public void setRehypothecationStatus(String rehypothecationStatus) {
		this.rehypothecationStatus = rehypothecationStatus;
	}

	public String getSecurityCurrency() {
		return securityCurrency;
	}

	public void setSecurityCurrency(String securityCurrency) {
		this.securityCurrency = securityCurrency;
	}

	public String getObligor() {
		return obligor;
	}

	public void setObligor(String obligor) {
		this.obligor = obligor;
	}

	public String getIssuerType() {
		return issuerType;
	}

	public void setIssuerType(String issuerType) {
		this.issuerType = issuerType;
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

	public String getUnderlyingBondDetails() {
		return underlyingBondDetails;
	}

	public void setUnderlyingBondDetails(String underlyingBondDetails) {
		this.underlyingBondDetails = underlyingBondDetails;
	}

	public String getSecurityFinalRating() {
		return securityFinalRating;
	}

	public void setSecurityFinalRating(String securityFinalRating) {
		this.securityFinalRating = securityFinalRating;
	}

	public String getFinalSecurityRatingCbuae() {
		return finalSecurityRatingCbuae;
	}

	public void setFinalSecurityRatingCbuae(String finalSecurityRatingCbuae) {
		this.finalSecurityRatingCbuae = finalSecurityRatingCbuae;
	}

	public String getSecurityCountryOfRisk() {
		return securityCountryOfRisk;
	}

	public void setSecurityCountryOfRisk(String securityCountryOfRisk) {
		this.securityCountryOfRisk = securityCountryOfRisk;
	}

	public String getCbuaeGeoZone2() {
		return cbuaeGeoZone2;
	}

	public void setCbuaeGeoZone2(String cbuaeGeoZone2) {
		this.cbuaeGeoZone2 = cbuaeGeoZone2;
	}

	public Double getBondSukukNominal() {
		return bondSukukNominal;
	}

	public void setBondSukukNominal(Double bondSukukNominal) {
		this.bondSukukNominal = bondSukukNominal;
	}

	public Date getSecurityMaturityDate() {
		return securityMaturityDate;
	}

	public void setSecurityMaturityDate(Date securityMaturityDate) {
		this.securityMaturityDate = securityMaturityDate;
	}

	public Date getSecurityResidualMaturity() {
		return securityResidualMaturity;
	}

	public void setSecurityResidualMaturity(Date securityResidualMaturity) {
		this.securityResidualMaturity = securityResidualMaturity;
	}

	public BigDecimal getSecurityMaturityPeriod() {
		return securityMaturityPeriod;
	}

	public void setSecurityMaturityPeriod(BigDecimal securityMaturityPeriod) {
		this.securityMaturityPeriod = securityMaturityPeriod;
	}

	public Double getGmraEffectiveHaircut() {
		return gmraEffectiveHaircut;
	}

	public void setGmraEffectiveHaircut(Double gmraEffectiveHaircut) {
		this.gmraEffectiveHaircut = gmraEffectiveHaircut;
	}

	public Double getSecurityStartPrice() {
		return securityStartPrice;
	}

	public void setSecurityStartPrice(Double securityStartPrice) {
		this.securityStartPrice = securityStartPrice;
	}

	public Double getSecurityStartCashAmount() {
		return securityStartCashAmount;
	}

	public void setSecurityStartCashAmount(Double securityStartCashAmount) {
		this.securityStartCashAmount = securityStartCashAmount;
	}

	public Double getStartCashAmount() {
		return startCashAmount;
	}

	public void setStartCashAmount(Double startCashAmount) {
		this.startCashAmount = startCashAmount;
	}

	public Double getInterestProfitRate() {
		return interestProfitRate;
	}

	public void setInterestProfitRate(Double interestProfitRate) {
		this.interestProfitRate = interestProfitRate;
	}

	public Double getFixedRate() {
		return fixedRate;
	}

	public void setFixedRate(Double fixedRate) {
		this.fixedRate = fixedRate;
	}

	public String getFloatingRateType() {
		return floatingRateType;
	}

	public void setFloatingRateType(String floatingRateType) {
		this.floatingRateType = floatingRateType;
	}

	public Double getRepoMargin() {
		return repoMargin;
	}

	public void setRepoMargin(Double repoMargin) {
		this.repoMargin = repoMargin;
	}

	public Double getInterestAccruals() {
		return interestAccruals;
	}

	public void setInterestAccruals(Double interestAccruals) {
		this.interestAccruals = interestAccruals;
	}

	public Double getRepoValuation() {
		return repoValuation;
	}

	public void setRepoValuation(Double repoValuation) {
		this.repoValuation = repoValuation;
	}

	public Double getDirtyPrice() {
		return dirtyPrice;
	}

	public void setDirtyPrice(Double dirtyPrice) {
		this.dirtyPrice = dirtyPrice;
	}

	public Double getGmraCollateralMtm() {
		return gmraCollateralMtm;
	}

	public void setGmraCollateralMtm(Double gmraCollateralMtm) {
		this.gmraCollateralMtm = gmraCollateralMtm;
	}

	public Double getMinTransferAmount() {
		return minTransferAmount;
	}

	public void setMinTransferAmount(Double minTransferAmount) {
		this.minTransferAmount = minTransferAmount;
	}

	public Double getThreshold() {
		return threshold;
	}

	public void setThreshold(Double threshold) {
		this.threshold = threshold;
	}

	public String getMarginCallFreq() {
		return marginCallFreq;
	}

	public void setMarginCallFreq(String marginCallFreq) {
		this.marginCallFreq = marginCallFreq;
	}

	public Date getReportSubmitDate() {
		return reportSubmitDate;
	}

	public void setReportSubmitDate(Date reportSubmitDate) {
		this.reportSubmitDate = reportSubmitDate;
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

	public RT_RepoDataTemplate(Long slNo, Date dataDate, String bankName, String headOfficeSubsidiary,
			String subsidiary, String bankSymbol, String conventionalIslamic, String localForeign, String cbuaeTiering,
			String counterpartyName, String counterpartyInternalRef, String finalRatingBanks, String finalRatingCbuae,
			String countryOfRisk, String cbuaeGeoZone, String cbuaeInternalRef, String transactionType, String dealNo,
			Date repoStartDate, Date repoMaturityDate, Double initialMaturity, Integer initialMaturityRounded,
			BigDecimal initialMaturityPeriod, Date residualMaturityDate, BigDecimal maturityPeriod, String repoCurrency,
			String underlyingSecurityIsin, String rehypothecationStatus, String securityCurrency, String obligor,
			String issuerType, String industry, String sector, String underlyingBondDetails, String securityFinalRating,
			String finalSecurityRatingCbuae, String securityCountryOfRisk, String cbuaeGeoZone2,
			Double bondSukukNominal, Date securityMaturityDate, Date securityResidualMaturity,
			BigDecimal securityMaturityPeriod, Double gmraEffectiveHaircut, Double securityStartPrice,
			Double securityStartCashAmount, Double startCashAmount, Double interestProfitRate, Double fixedRate,
			String floatingRateType, Double repoMargin, Double interestAccruals, Double repoValuation,
			Double dirtyPrice, Double gmraCollateralMtm, Double minTransferAmount, Double threshold,
			String marginCallFreq, Date reportSubmitDate, Date reportDate, String entityFlg, String modifyFlg,
			String delFlg, Date reportFromDate, Date reportToDate, String reportCode, String entryUser,
			String modifyUser, String verifyUser, Date entryTime, Date modifyTime) {
		super();
		this.slNo = slNo;
		this.dataDate = dataDate;
		this.bankName = bankName;
		this.headOfficeSubsidiary = headOfficeSubsidiary;
		this.subsidiary = subsidiary;
		this.bankSymbol = bankSymbol;
		this.conventionalIslamic = conventionalIslamic;
		this.localForeign = localForeign;
		this.cbuaeTiering = cbuaeTiering;
		this.counterpartyName = counterpartyName;
		this.counterpartyInternalRef = counterpartyInternalRef;
		this.finalRatingBanks = finalRatingBanks;
		this.finalRatingCbuae = finalRatingCbuae;
		this.countryOfRisk = countryOfRisk;
		this.cbuaeGeoZone = cbuaeGeoZone;
		this.cbuaeInternalRef = cbuaeInternalRef;
		this.transactionType = transactionType;
		this.dealNo = dealNo;
		this.repoStartDate = repoStartDate;
		this.repoMaturityDate = repoMaturityDate;
		this.initialMaturity = initialMaturity;
		this.initialMaturityRounded = initialMaturityRounded;
		this.initialMaturityPeriod = initialMaturityPeriod;
		this.residualMaturityDate = residualMaturityDate;
		this.maturityPeriod = maturityPeriod;
		this.repoCurrency = repoCurrency;
		this.underlyingSecurityIsin = underlyingSecurityIsin;
		this.rehypothecationStatus = rehypothecationStatus;
		this.securityCurrency = securityCurrency;
		this.obligor = obligor;
		this.issuerType = issuerType;
		this.industry = industry;
		this.sector = sector;
		this.underlyingBondDetails = underlyingBondDetails;
		this.securityFinalRating = securityFinalRating;
		this.finalSecurityRatingCbuae = finalSecurityRatingCbuae;
		this.securityCountryOfRisk = securityCountryOfRisk;
		this.cbuaeGeoZone2 = cbuaeGeoZone2;
		this.bondSukukNominal = bondSukukNominal;
		this.securityMaturityDate = securityMaturityDate;
		this.securityResidualMaturity = securityResidualMaturity;
		this.securityMaturityPeriod = securityMaturityPeriod;
		this.gmraEffectiveHaircut = gmraEffectiveHaircut;
		this.securityStartPrice = securityStartPrice;
		this.securityStartCashAmount = securityStartCashAmount;
		this.startCashAmount = startCashAmount;
		this.interestProfitRate = interestProfitRate;
		this.fixedRate = fixedRate;
		this.floatingRateType = floatingRateType;
		this.repoMargin = repoMargin;
		this.interestAccruals = interestAccruals;
		this.repoValuation = repoValuation;
		this.dirtyPrice = dirtyPrice;
		this.gmraCollateralMtm = gmraCollateralMtm;
		this.minTransferAmount = minTransferAmount;
		this.threshold = threshold;
		this.marginCallFreq = marginCallFreq;
		this.reportSubmitDate = reportSubmitDate;
		this.reportDate = reportDate;
		this.entityFlg = entityFlg;
		this.modifyFlg = modifyFlg;
		this.delFlg = delFlg;
		this.reportFromDate = reportFromDate;
		this.reportToDate = reportToDate;
		this.reportCode = reportCode;
		this.entryUser = entryUser;
		this.modifyUser = modifyUser;
		this.verifyUser = verifyUser;
		this.entryTime = entryTime;
		this.modifyTime = modifyTime;
	}

	public RT_RepoDataTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	    
}
