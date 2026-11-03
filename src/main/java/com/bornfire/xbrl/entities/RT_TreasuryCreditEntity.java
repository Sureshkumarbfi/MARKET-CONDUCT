package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "BCBUAE_TREASURY_CRE_LMT_MANAGEMENT")
public class RT_TreasuryCreditEntity {

    @Id
    @Column(name = "SL_NO")
    private Integer slNo;

    @Temporal(TemporalType.DATE)
    @Column(name = "REPORT_DATE")
    private Date reportDate;

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

    @Column(name = "COUNTERPARTY_INT_REF")
    private String counterpartyIntRef;

    @Column(name = "COUNTERPARTY_RISK_RATING")
    private String counterpartyRiskRating;

    @Column(name = "FINAL_RATING_CBUAE")
    private String finalRatingCbuae;

    @Column(name = "COUNTRY_OF_RISK")
    private String countryOfRisk;

    @Column(name = "CBUAE_GEOGRAPHICAL_ZONE")
    private String cbuaeGeographicalZone;

    @Column(name = "COUNTERPARTY_TYPE")
    private String counterpartyType;

    @Column(name = "LIMIT_AED_MONEYMARKET")
    private BigDecimal limitAedMoneymarket;

    @Column(name = "UTILIZATION_AED_MONEYMARKET")
    private BigDecimal utilizationAedMoneymarket;

    @Column(name = "MONEYMARKET_PERCENT")
    private BigDecimal moneymarketPercent;

    @Column(name = "LIMIT_AED_REPO")
    private BigDecimal limitAedRepo;

    @Column(name = "UTILIZATION_AED_REPO")
    private BigDecimal utilizationAedRepo;

    @Column(name = "REPO_PERCENT")
    private BigDecimal repoPercent;

    @Column(name = "LIMIT_AED_BONDS")
    private BigDecimal limitAedBonds;

    @Column(name = "UTILIZATION_AED_BONDS")
    private BigDecimal utilizationAedBonds;

    @Column(name = "BONDS_PERCENT")
    private BigDecimal bondsPercent;

    @Column(name = "LIMIT_AED_EQUITY")
    private BigDecimal limitAedEquity;

    @Column(name = "UTILIZATION_AED_EQUITY")
    private BigDecimal utilizationAedEquity;

    @Column(name = "EQUITY_PERCENT")
    private BigDecimal equityPercent;

    @Column(name = "LIMIT_AED_CREDIT")
    private BigDecimal limitAedCredit;

    @Column(name = "UTILIZATION_AED_CREDIT")
    private BigDecimal utilizationAedCredit;

    @Column(name = "CREDIT_PERCENT")
    private BigDecimal creditPercent;

    @Column(name = "LIMIT_AED_OTHER")
    private BigDecimal limitAedOther;

    @Column(name = "UTILIZATION_AED_OTHER")
    private BigDecimal utilizationAedOther;

    @Column(name = "OTHER_PERCENT")
    private BigDecimal otherPercent;

    @Column(name = "LIMIT_AED_NOSTRO")
    private BigDecimal limitAedNostro;

    @Column(name = "UTILIZATION_AED_NOSTRO")
    private BigDecimal utilizationAedNostro;

    @Column(name = "NOSTRO_PERCENT")
    private BigDecimal nostroPercent;

    @Column(name = "LIMIT_AED_DERIVATIVES")
    private BigDecimal limitAedDerivatives;

    @Column(name = "UTILIZATION_AED_DERIVATIVES")
    private BigDecimal utilizationAedDerivatives;

    @Column(name = "DERIVATIVES_PERCENT")
    private BigDecimal derivativesPercent;

    @Column(name = "LIMIT_AED_FXSETTLEMENT")
    private BigDecimal limitAedFxsettlement;

    @Column(name = "UTILIZATION_AED_FXSETTLEMENT")
    private BigDecimal utilizationAedFxsettlement;

    @Column(name = "FXSETTLEMENT_PERCENT")
    private BigDecimal fxsettlementPercent;

    @Column(name = "LIMIT_AED_BONDSETTLEMENT")
    private BigDecimal limitAedBondsettlement;

    @Column(name = "UTILIZATION_AED_BONDSETTLEMENT")
    private BigDecimal utilizationAedBondsettlement;

    @Column(name = "BONDSETTLEMENT_PERCENT")
    private BigDecimal bondsettlementPercent;

    @Column(name = "TREASURY_LMT_AED")
    private BigDecimal treasuryLmtAed;

    @Column(name = "TREASURY_LMT")
    private BigDecimal treasuryLmt;

    @Column(name = "EXPOSURE_AED")
    private BigDecimal exposureAed;

    @Column(name = "EXPOSURE")
    private BigDecimal exposure;

    @Temporal(TemporalType.DATE)
    @Column(name = "REPORT_SUBMIT_DATE")
    private Date reportSubmitDate;

    @Column(name = "ENTITY_FLG")
    private String entityFlg;

    @Column(name = "MODIFY_FLG")
    private String modifyFlg;

    @Column(name = "DEL_FLG")
    private String delFlg;

    @Temporal(TemporalType.DATE)
    @Column(name = "REPORT_FROM_DATE")
    private Date reportFromDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "REPORT_TO_DATE")
    private Date reportToDate;

    @Column(name = "REPORT_CODE")
    private String reportCode;

    @Column(name = "ENTRY_USER")
    private String entryUser;

    @Column(name = "MODIFY_USER")
    private String modifyUser;

    @Column(name = "VERIFY_USER")
    private String verifyUser;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ENTRY_TIME")
    private Date entryTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFY_TIME")
    private Date modifyTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "VERIFY_TIME")
    private Date verifyTime;

	public Integer getSlNo() {
		return slNo;
	}

	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
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

	public String getCounterpartyIntRef() {
		return counterpartyIntRef;
	}

	public void setCounterpartyIntRef(String counterpartyIntRef) {
		this.counterpartyIntRef = counterpartyIntRef;
	}

	public String getCounterpartyRiskRating() {
		return counterpartyRiskRating;
	}

	public void setCounterpartyRiskRating(String counterpartyRiskRating) {
		this.counterpartyRiskRating = counterpartyRiskRating;
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

	public String getCbuaeGeographicalZone() {
		return cbuaeGeographicalZone;
	}

	public void setCbuaeGeographicalZone(String cbuaeGeographicalZone) {
		this.cbuaeGeographicalZone = cbuaeGeographicalZone;
	}

	public String getCounterpartyType() {
		return counterpartyType;
	}

	public void setCounterpartyType(String counterpartyType) {
		this.counterpartyType = counterpartyType;
	}

	public BigDecimal getLimitAedMoneymarket() {
		return limitAedMoneymarket;
	}

	public void setLimitAedMoneymarket(BigDecimal limitAedMoneymarket) {
		this.limitAedMoneymarket = limitAedMoneymarket;
	}

	public BigDecimal getUtilizationAedMoneymarket() {
		return utilizationAedMoneymarket;
	}

	public void setUtilizationAedMoneymarket(BigDecimal utilizationAedMoneymarket) {
		this.utilizationAedMoneymarket = utilizationAedMoneymarket;
	}

	public BigDecimal getMoneymarketPercent() {
		return moneymarketPercent;
	}

	public void setMoneymarketPercent(BigDecimal moneymarketPercent) {
		this.moneymarketPercent = moneymarketPercent;
	}

	public BigDecimal getLimitAedRepo() {
		return limitAedRepo;
	}

	public void setLimitAedRepo(BigDecimal limitAedRepo) {
		this.limitAedRepo = limitAedRepo;
	}

	public BigDecimal getUtilizationAedRepo() {
		return utilizationAedRepo;
	}

	public void setUtilizationAedRepo(BigDecimal utilizationAedRepo) {
		this.utilizationAedRepo = utilizationAedRepo;
	}

	public BigDecimal getRepoPercent() {
		return repoPercent;
	}

	public void setRepoPercent(BigDecimal repoPercent) {
		this.repoPercent = repoPercent;
	}

	public BigDecimal getLimitAedBonds() {
		return limitAedBonds;
	}

	public void setLimitAedBonds(BigDecimal limitAedBonds) {
		this.limitAedBonds = limitAedBonds;
	}

	public BigDecimal getUtilizationAedBonds() {
		return utilizationAedBonds;
	}

	public void setUtilizationAedBonds(BigDecimal utilizationAedBonds) {
		this.utilizationAedBonds = utilizationAedBonds;
	}

	public BigDecimal getBondsPercent() {
		return bondsPercent;
	}

	public void setBondsPercent(BigDecimal bondsPercent) {
		this.bondsPercent = bondsPercent;
	}

	public BigDecimal getLimitAedEquity() {
		return limitAedEquity;
	}

	public void setLimitAedEquity(BigDecimal limitAedEquity) {
		this.limitAedEquity = limitAedEquity;
	}

	public BigDecimal getUtilizationAedEquity() {
		return utilizationAedEquity;
	}

	public void setUtilizationAedEquity(BigDecimal utilizationAedEquity) {
		this.utilizationAedEquity = utilizationAedEquity;
	}

	public BigDecimal getEquityPercent() {
		return equityPercent;
	}

	public void setEquityPercent(BigDecimal equityPercent) {
		this.equityPercent = equityPercent;
	}

	public BigDecimal getLimitAedCredit() {
		return limitAedCredit;
	}

	public void setLimitAedCredit(BigDecimal limitAedCredit) {
		this.limitAedCredit = limitAedCredit;
	}

	public BigDecimal getUtilizationAedCredit() {
		return utilizationAedCredit;
	}

	public void setUtilizationAedCredit(BigDecimal utilizationAedCredit) {
		this.utilizationAedCredit = utilizationAedCredit;
	}

	public BigDecimal getCreditPercent() {
		return creditPercent;
	}

	public void setCreditPercent(BigDecimal creditPercent) {
		this.creditPercent = creditPercent;
	}

	public BigDecimal getLimitAedOther() {
		return limitAedOther;
	}

	public void setLimitAedOther(BigDecimal limitAedOther) {
		this.limitAedOther = limitAedOther;
	}

	public BigDecimal getUtilizationAedOther() {
		return utilizationAedOther;
	}

	public void setUtilizationAedOther(BigDecimal utilizationAedOther) {
		this.utilizationAedOther = utilizationAedOther;
	}

	public BigDecimal getOtherPercent() {
		return otherPercent;
	}

	public void setOtherPercent(BigDecimal otherPercent) {
		this.otherPercent = otherPercent;
	}

	public BigDecimal getLimitAedNostro() {
		return limitAedNostro;
	}

	public void setLimitAedNostro(BigDecimal limitAedNostro) {
		this.limitAedNostro = limitAedNostro;
	}

	public BigDecimal getUtilizationAedNostro() {
		return utilizationAedNostro;
	}

	public void setUtilizationAedNostro(BigDecimal utilizationAedNostro) {
		this.utilizationAedNostro = utilizationAedNostro;
	}

	public BigDecimal getNostroPercent() {
		return nostroPercent;
	}

	public void setNostroPercent(BigDecimal nostroPercent) {
		this.nostroPercent = nostroPercent;
	}

	public BigDecimal getLimitAedDerivatives() {
		return limitAedDerivatives;
	}

	public void setLimitAedDerivatives(BigDecimal limitAedDerivatives) {
		this.limitAedDerivatives = limitAedDerivatives;
	}

	public BigDecimal getUtilizationAedDerivatives() {
		return utilizationAedDerivatives;
	}

	public void setUtilizationAedDerivatives(BigDecimal utilizationAedDerivatives) {
		this.utilizationAedDerivatives = utilizationAedDerivatives;
	}

	public BigDecimal getDerivativesPercent() {
		return derivativesPercent;
	}

	public void setDerivativesPercent(BigDecimal derivativesPercent) {
		this.derivativesPercent = derivativesPercent;
	}

	public BigDecimal getLimitAedFxsettlement() {
		return limitAedFxsettlement;
	}

	public void setLimitAedFxsettlement(BigDecimal limitAedFxsettlement) {
		this.limitAedFxsettlement = limitAedFxsettlement;
	}

	public BigDecimal getUtilizationAedFxsettlement() {
		return utilizationAedFxsettlement;
	}

	public void setUtilizationAedFxsettlement(BigDecimal utilizationAedFxsettlement) {
		this.utilizationAedFxsettlement = utilizationAedFxsettlement;
	}

	public BigDecimal getFxsettlementPercent() {
		return fxsettlementPercent;
	}

	public void setFxsettlementPercent(BigDecimal fxsettlementPercent) {
		this.fxsettlementPercent = fxsettlementPercent;
	}

	public BigDecimal getLimitAedBondsettlement() {
		return limitAedBondsettlement;
	}

	public void setLimitAedBondsettlement(BigDecimal limitAedBondsettlement) {
		this.limitAedBondsettlement = limitAedBondsettlement;
	}

	public BigDecimal getUtilizationAedBondsettlement() {
		return utilizationAedBondsettlement;
	}

	public void setUtilizationAedBondsettlement(BigDecimal utilizationAedBondsettlement) {
		this.utilizationAedBondsettlement = utilizationAedBondsettlement;
	}

	public BigDecimal getBondsettlementPercent() {
		return bondsettlementPercent;
	}

	public void setBondsettlementPercent(BigDecimal bondsettlementPercent) {
		this.bondsettlementPercent = bondsettlementPercent;
	}

	public BigDecimal getTreasuryLmtAed() {
		return treasuryLmtAed;
	}

	public void setTreasuryLmtAed(BigDecimal treasuryLmtAed) {
		this.treasuryLmtAed = treasuryLmtAed;
	}

	public BigDecimal getTreasuryLmt() {
		return treasuryLmt;
	}

	public void setTreasuryLmt(BigDecimal treasuryLmt) {
		this.treasuryLmt = treasuryLmt;
	}

	public BigDecimal getExposureAed() {
		return exposureAed;
	}

	public void setExposureAed(BigDecimal exposureAed) {
		this.exposureAed = exposureAed;
	}

	public BigDecimal getExposure() {
		return exposure;
	}

	public void setExposure(BigDecimal exposure) {
		this.exposure = exposure;
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

	@Override
	public String toString() {
		return "RT_TreasuryCreditEntity [slNo=" + slNo + ", reportDate=" + reportDate + ", bankName=" + bankName
				+ ", headOfficeSubsidiary=" + headOfficeSubsidiary + ", subsidiary=" + subsidiary + ", bankSymbol="
				+ bankSymbol + ", conventionalIslamic=" + conventionalIslamic + ", localForeign=" + localForeign
				+ ", cbuaeTiering=" + cbuaeTiering + ", counterpartyName=" + counterpartyName + ", counterpartyIntRef="
				+ counterpartyIntRef + ", counterpartyRiskRating=" + counterpartyRiskRating + ", finalRatingCbuae="
				+ finalRatingCbuae + ", countryOfRisk=" + countryOfRisk + ", cbuaeGeographicalZone="
				+ cbuaeGeographicalZone + ", counterpartyType=" + counterpartyType + ", limitAedMoneymarket="
				+ limitAedMoneymarket + ", utilizationAedMoneymarket=" + utilizationAedMoneymarket
				+ ", moneymarketPercent=" + moneymarketPercent + ", limitAedRepo=" + limitAedRepo
				+ ", utilizationAedRepo=" + utilizationAedRepo + ", repoPercent=" + repoPercent + ", limitAedBonds="
				+ limitAedBonds + ", utilizationAedBonds=" + utilizationAedBonds + ", bondsPercent=" + bondsPercent
				+ ", limitAedEquity=" + limitAedEquity + ", utilizationAedEquity=" + utilizationAedEquity
				+ ", equityPercent=" + equityPercent + ", limitAedCredit=" + limitAedCredit + ", utilizationAedCredit="
				+ utilizationAedCredit + ", creditPercent=" + creditPercent + ", limitAedOther=" + limitAedOther
				+ ", utilizationAedOther=" + utilizationAedOther + ", otherPercent=" + otherPercent
				+ ", limitAedNostro=" + limitAedNostro + ", utilizationAedNostro=" + utilizationAedNostro
				+ ", nostroPercent=" + nostroPercent + ", limitAedDerivatives=" + limitAedDerivatives
				+ ", utilizationAedDerivatives=" + utilizationAedDerivatives + ", derivativesPercent="
				+ derivativesPercent + ", limitAedFxsettlement=" + limitAedFxsettlement
				+ ", utilizationAedFxsettlement=" + utilizationAedFxsettlement + ", fxsettlementPercent="
				+ fxsettlementPercent + ", limitAedBondsettlement=" + limitAedBondsettlement
				+ ", utilizationAedBondsettlement=" + utilizationAedBondsettlement + ", bondsettlementPercent="
				+ bondsettlementPercent + ", treasuryLmtAed=" + treasuryLmtAed + ", treasuryLmt=" + treasuryLmt
				+ ", exposureAed=" + exposureAed + ", exposure=" + exposure + ", reportSubmitDate=" + reportSubmitDate
				+ ", entityFlg=" + entityFlg + ", modifyFlg=" + modifyFlg + ", delFlg=" + delFlg + ", reportFromDate="
				+ reportFromDate + ", reportToDate=" + reportToDate + ", reportCode=" + reportCode + ", entryUser="
				+ entryUser + ", modifyUser=" + modifyUser + ", verifyUser=" + verifyUser + ", entryTime=" + entryTime
				+ ", modifyTime=" + modifyTime + ", verifyTime=" + verifyTime + ", getSlNo()=" + getSlNo()
				+ ", getReportDate()=" + getReportDate() + ", getBankName()=" + getBankName()
				+ ", getHeadOfficeSubsidiary()=" + getHeadOfficeSubsidiary() + ", getSubsidiary()=" + getSubsidiary()
				+ ", getBankSymbol()=" + getBankSymbol() + ", getConventionalIslamic()=" + getConventionalIslamic()
				+ ", getLocalForeign()=" + getLocalForeign() + ", getCbuaeTiering()=" + getCbuaeTiering()
				+ ", getCounterpartyName()=" + getCounterpartyName() + ", getCounterpartyIntRef()="
				+ getCounterpartyIntRef() + ", getCounterpartyRiskRating()=" + getCounterpartyRiskRating()
				+ ", getFinalRatingCbuae()=" + getFinalRatingCbuae() + ", getCountryOfRisk()=" + getCountryOfRisk()
				+ ", getCbuaeGeographicalZone()=" + getCbuaeGeographicalZone() + ", getCounterpartyType()="
				+ getCounterpartyType() + ", getLimitAedMoneymarket()=" + getLimitAedMoneymarket()
				+ ", getUtilizationAedMoneymarket()=" + getUtilizationAedMoneymarket() + ", getMoneymarketPercent()="
				+ getMoneymarketPercent() + ", getLimitAedRepo()=" + getLimitAedRepo() + ", getUtilizationAedRepo()="
				+ getUtilizationAedRepo() + ", getRepoPercent()=" + getRepoPercent() + ", getLimitAedBonds()="
				+ getLimitAedBonds() + ", getUtilizationAedBonds()=" + getUtilizationAedBonds() + ", getBondsPercent()="
				+ getBondsPercent() + ", getLimitAedEquity()=" + getLimitAedEquity() + ", getUtilizationAedEquity()="
				+ getUtilizationAedEquity() + ", getEquityPercent()=" + getEquityPercent() + ", getLimitAedCredit()="
				+ getLimitAedCredit() + ", getUtilizationAedCredit()=" + getUtilizationAedCredit()
				+ ", getCreditPercent()=" + getCreditPercent() + ", getLimitAedOther()=" + getLimitAedOther()
				+ ", getUtilizationAedOther()=" + getUtilizationAedOther() + ", getOtherPercent()=" + getOtherPercent()
				+ ", getLimitAedNostro()=" + getLimitAedNostro() + ", getUtilizationAedNostro()="
				+ getUtilizationAedNostro() + ", getNostroPercent()=" + getNostroPercent()
				+ ", getLimitAedDerivatives()=" + getLimitAedDerivatives() + ", getUtilizationAedDerivatives()="
				+ getUtilizationAedDerivatives() + ", getDerivativesPercent()=" + getDerivativesPercent()
				+ ", getLimitAedFxsettlement()=" + getLimitAedFxsettlement() + ", getUtilizationAedFxsettlement()="
				+ getUtilizationAedFxsettlement() + ", getFxsettlementPercent()=" + getFxsettlementPercent()
				+ ", getLimitAedBondsettlement()=" + getLimitAedBondsettlement()
				+ ", getUtilizationAedBondsettlement()=" + getUtilizationAedBondsettlement()
				+ ", getBondsettlementPercent()=" + getBondsettlementPercent() + ", getTreasuryLmtAed()="
				+ getTreasuryLmtAed() + ", getTreasuryLmt()=" + getTreasuryLmt() + ", getExposureAed()="
				+ getExposureAed() + ", getExposure()=" + getExposure() + ", getReportSubmitDate()="
				+ getReportSubmitDate() + ", getEntityFlg()=" + getEntityFlg() + ", getModifyFlg()=" + getModifyFlg()
				+ ", getDelFlg()=" + getDelFlg() + ", getReportFromDate()=" + getReportFromDate()
				+ ", getReportToDate()=" + getReportToDate() + ", getReportCode()=" + getReportCode()
				+ ", getEntryUser()=" + getEntryUser() + ", getModifyUser()=" + getModifyUser() + ", getVerifyUser()="
				+ getVerifyUser() + ", getEntryTime()=" + getEntryTime() + ", getModifyTime()=" + getModifyTime()
				+ ", getVerifyTime()=" + getVerifyTime() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public RT_TreasuryCreditEntity(Integer slNo, Date reportDate, String bankName, String headOfficeSubsidiary,
			String subsidiary, String bankSymbol, String conventionalIslamic, String localForeign, String cbuaeTiering,
			String counterpartyName, String counterpartyIntRef, String counterpartyRiskRating, String finalRatingCbuae,
			String countryOfRisk, String cbuaeGeographicalZone, String counterpartyType, BigDecimal limitAedMoneymarket,
			BigDecimal utilizationAedMoneymarket, BigDecimal moneymarketPercent, BigDecimal limitAedRepo,
			BigDecimal utilizationAedRepo, BigDecimal repoPercent, BigDecimal limitAedBonds,
			BigDecimal utilizationAedBonds, BigDecimal bondsPercent, BigDecimal limitAedEquity,
			BigDecimal utilizationAedEquity, BigDecimal equityPercent, BigDecimal limitAedCredit,
			BigDecimal utilizationAedCredit, BigDecimal creditPercent, BigDecimal limitAedOther,
			BigDecimal utilizationAedOther, BigDecimal otherPercent, BigDecimal limitAedNostro,
			BigDecimal utilizationAedNostro, BigDecimal nostroPercent, BigDecimal limitAedDerivatives,
			BigDecimal utilizationAedDerivatives, BigDecimal derivativesPercent, BigDecimal limitAedFxsettlement,
			BigDecimal utilizationAedFxsettlement, BigDecimal fxsettlementPercent, BigDecimal limitAedBondsettlement,
			BigDecimal utilizationAedBondsettlement, BigDecimal bondsettlementPercent, BigDecimal treasuryLmtAed,
			BigDecimal treasuryLmt, BigDecimal exposureAed, BigDecimal exposure, Date reportSubmitDate,
			String entityFlg, String modifyFlg, String delFlg, Date reportFromDate, Date reportToDate,
			String reportCode, String entryUser, String modifyUser, String verifyUser, Date entryTime, Date modifyTime,
			Date verifyTime) {
		super();
		this.slNo = slNo;
		this.reportDate = reportDate;
		this.bankName = bankName;
		this.headOfficeSubsidiary = headOfficeSubsidiary;
		this.subsidiary = subsidiary;
		this.bankSymbol = bankSymbol;
		this.conventionalIslamic = conventionalIslamic;
		this.localForeign = localForeign;
		this.cbuaeTiering = cbuaeTiering;
		this.counterpartyName = counterpartyName;
		this.counterpartyIntRef = counterpartyIntRef;
		this.counterpartyRiskRating = counterpartyRiskRating;
		this.finalRatingCbuae = finalRatingCbuae;
		this.countryOfRisk = countryOfRisk;
		this.cbuaeGeographicalZone = cbuaeGeographicalZone;
		this.counterpartyType = counterpartyType;
		this.limitAedMoneymarket = limitAedMoneymarket;
		this.utilizationAedMoneymarket = utilizationAedMoneymarket;
		this.moneymarketPercent = moneymarketPercent;
		this.limitAedRepo = limitAedRepo;
		this.utilizationAedRepo = utilizationAedRepo;
		this.repoPercent = repoPercent;
		this.limitAedBonds = limitAedBonds;
		this.utilizationAedBonds = utilizationAedBonds;
		this.bondsPercent = bondsPercent;
		this.limitAedEquity = limitAedEquity;
		this.utilizationAedEquity = utilizationAedEquity;
		this.equityPercent = equityPercent;
		this.limitAedCredit = limitAedCredit;
		this.utilizationAedCredit = utilizationAedCredit;
		this.creditPercent = creditPercent;
		this.limitAedOther = limitAedOther;
		this.utilizationAedOther = utilizationAedOther;
		this.otherPercent = otherPercent;
		this.limitAedNostro = limitAedNostro;
		this.utilizationAedNostro = utilizationAedNostro;
		this.nostroPercent = nostroPercent;
		this.limitAedDerivatives = limitAedDerivatives;
		this.utilizationAedDerivatives = utilizationAedDerivatives;
		this.derivativesPercent = derivativesPercent;
		this.limitAedFxsettlement = limitAedFxsettlement;
		this.utilizationAedFxsettlement = utilizationAedFxsettlement;
		this.fxsettlementPercent = fxsettlementPercent;
		this.limitAedBondsettlement = limitAedBondsettlement;
		this.utilizationAedBondsettlement = utilizationAedBondsettlement;
		this.bondsettlementPercent = bondsettlementPercent;
		this.treasuryLmtAed = treasuryLmtAed;
		this.treasuryLmt = treasuryLmt;
		this.exposureAed = exposureAed;
		this.exposure = exposure;
		this.reportSubmitDate = reportSubmitDate;
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
		this.verifyTime = verifyTime;
	}

	public RT_TreasuryCreditEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


}
