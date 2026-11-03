package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BCBUAE_CCR_DATA_TABLE")
public class RT_CCR_DATA_TEMPLATE {


	    @Id
	    @Column(name = "SI_NO")
	    private String siNo;

	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    @Column(name = "TRANSACTION_DATE")
	    private Date transactionDate;

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

	    @Column(name = "CBUAE_TIERING")
	    private String cbuaeTiering;

	    @Column(name = "LOCAL_FOREIGN")
	    private String localForeign;

	    @Column(name = "COUNTERPARTY_NAME")
	    private String counterpartyName;

	    @Column(name = "INTERNAL_COUNTERPARTY_REF")
	    private String internalCounterpartyRef;

	    @Column(name = "INTERNAL_COUNTERPARTY_RATING")
	    private String internalCounterpartyRating;

	    @Column(name = "FINAL_RATING_CBUAE")
	    private String finalRatingCbuae;

	    @Column(name = "COUNTRY_OF_RISK")
	    private String countryOfRisk;

	    @Column(name = "CBUAE_GEOGRAPHICAL_ZONE")
	    private String cbuaeGeographicalZone;

	    @Column(name = "COUNTERPARTY_TYPE")
	    private String counterpartyType;

	    @Column(name = "SECTOR")
	    private String sector;

	    @Column(name = "PFE_95_AED")
	    private BigDecimal pfe95Aed;

	    @Column(name = "EXPECTED_POSITIVE_EXPOSURE_AED")
	    private BigDecimal expectedPositiveExposureAed;

	    @Column(name = "EXPECTED_NEGATIVE_EXPOSURE_AED")
	    private BigDecimal expectedNegativeExposureAed;

	    @Column(name = "CSA")
	    private String csa;

	    @Column(name = "COLLATERAL_TYPE")
	    private String collateralType;

	    @Column(name = "THRESHOLD")
	    private BigDecimal threshold;

	    @Column(name = "MINIMUM_TRANSFER_AMOUNT_AED")
	    private BigDecimal minimumTransferAmountAed;

	    @Column(name = "INDEPENDENT_AMOUNT_AED")
	    private BigDecimal independentAmountAed;

	    @Column(name = "MARGIN_CALL_FREQUENCY")
	    private String marginCallFrequency;

	    @Column(name = "NET_COLLATERAL_OUTSTANDING_AED")
	    private BigDecimal netCollateralOutstandingAed;

	    @Column(name = "CVA_AED")
	    private BigDecimal cvaAed;

	    @Column(name = "DVA_AED")
	    private BigDecimal dvaAed;

	    @Column(name = "BILATERAL_CVA_AED")
	    private BigDecimal bilateralCvaAed;

	    @Column(name = "FVA_AED")
	    private BigDecimal fvaAed;

	    @Column(name = "INCREMENTAL_PFE")
	    private BigDecimal incrementalPfe;

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

	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    @Column(name = "ENTRY_TIME")
	    private Date entryTime;

	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    @Column(name = "MODIFY_TIME")
	    private Date modifyTime;

	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    @Column(name = "VERIFY_TIME")
	    private Date verifyTime;

		public String getSiNo() {
			return siNo;
		}

		public void setSiNo(String siNo) {
			this.siNo = siNo;
		}

		public Date getTransactionDate() {
			return transactionDate;
		}

		public void setTransactionDate(Date transactionDate) {
			this.transactionDate = transactionDate;
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

		public String getCbuaeTiering() {
			return cbuaeTiering;
		}

		public void setCbuaeTiering(String cbuaeTiering) {
			this.cbuaeTiering = cbuaeTiering;
		}

		public String getLocalForeign() {
			return localForeign;
		}

		public void setLocalForeign(String localForeign) {
			this.localForeign = localForeign;
		}

		public String getCounterpartyName() {
			return counterpartyName;
		}

		public void setCounterpartyName(String counterpartyName) {
			this.counterpartyName = counterpartyName;
		}

		public String getInternalCounterpartyRef() {
			return internalCounterpartyRef;
		}

		public void setInternalCounterpartyRef(String internalCounterpartyRef) {
			this.internalCounterpartyRef = internalCounterpartyRef;
		}

		public String getInternalCounterpartyRating() {
			return internalCounterpartyRating;
		}

		public void setInternalCounterpartyRating(String internalCounterpartyRating) {
			this.internalCounterpartyRating = internalCounterpartyRating;
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

		public String getSector() {
			return sector;
		}

		public void setSector(String sector) {
			this.sector = sector;
		}

		public BigDecimal getPfe95Aed() {
			return pfe95Aed;
		}

		public void setPfe95Aed(BigDecimal pfe95Aed) {
			this.pfe95Aed = pfe95Aed;
		}

		public BigDecimal getExpectedPositiveExposureAed() {
			return expectedPositiveExposureAed;
		}

		public void setExpectedPositiveExposureAed(BigDecimal expectedPositiveExposureAed) {
			this.expectedPositiveExposureAed = expectedPositiveExposureAed;
		}

		public BigDecimal getExpectedNegativeExposureAed() {
			return expectedNegativeExposureAed;
		}

		public void setExpectedNegativeExposureAed(BigDecimal expectedNegativeExposureAed) {
			this.expectedNegativeExposureAed = expectedNegativeExposureAed;
		}

		public String getCsa() {
			return csa;
		}

		public void setCsa(String csa) {
			this.csa = csa;
		}

		public String getCollateralType() {
			return collateralType;
		}

		public void setCollateralType(String collateralType) {
			this.collateralType = collateralType;
		}

		public BigDecimal getThreshold() {
			return threshold;
		}

		public void setThreshold(BigDecimal threshold) {
			this.threshold = threshold;
		}

		public BigDecimal getMinimumTransferAmountAed() {
			return minimumTransferAmountAed;
		}

		public void setMinimumTransferAmountAed(BigDecimal minimumTransferAmountAed) {
			this.minimumTransferAmountAed = minimumTransferAmountAed;
		}

		public BigDecimal getIndependentAmountAed() {
			return independentAmountAed;
		}

		public void setIndependentAmountAed(BigDecimal independentAmountAed) {
			this.independentAmountAed = independentAmountAed;
		}

		public String getMarginCallFrequency() {
			return marginCallFrequency;
		}

		public void setMarginCallFrequency(String marginCallFrequency) {
			this.marginCallFrequency = marginCallFrequency;
		}

		public BigDecimal getNetCollateralOutstandingAed() {
			return netCollateralOutstandingAed;
		}

		public void setNetCollateralOutstandingAed(BigDecimal netCollateralOutstandingAed) {
			this.netCollateralOutstandingAed = netCollateralOutstandingAed;
		}

		public BigDecimal getCvaAed() {
			return cvaAed;
		}

		public void setCvaAed(BigDecimal cvaAed) {
			this.cvaAed = cvaAed;
		}

		public BigDecimal getDvaAed() {
			return dvaAed;
		}

		public void setDvaAed(BigDecimal dvaAed) {
			this.dvaAed = dvaAed;
		}

		public BigDecimal getBilateralCvaAed() {
			return bilateralCvaAed;
		}

		public void setBilateralCvaAed(BigDecimal bilateralCvaAed) {
			this.bilateralCvaAed = bilateralCvaAed;
		}

		public BigDecimal getFvaAed() {
			return fvaAed;
		}

		public void setFvaAed(BigDecimal fvaAed) {
			this.fvaAed = fvaAed;
		}

		public BigDecimal getIncrementalPfe() {
			return incrementalPfe;
		}

		public void setIncrementalPfe(BigDecimal incrementalPfe) {
			this.incrementalPfe = incrementalPfe;
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

		public RT_CCR_DATA_TEMPLATE(String siNo, Date transactionDate, String bankName, String headOfficeSubsidiary,
				String subsidiary, String bankSymbol, String conventionalIslamic, String cbuaeTiering,
				String localForeign, String counterpartyName, String internalCounterpartyRef,
				String internalCounterpartyRating, String finalRatingCbuae, String countryOfRisk,
				String cbuaeGeographicalZone, String counterpartyType, String sector, BigDecimal pfe95Aed,
				BigDecimal expectedPositiveExposureAed, BigDecimal expectedNegativeExposureAed, String csa,
				String collateralType, BigDecimal threshold, BigDecimal minimumTransferAmountAed,
				BigDecimal independentAmountAed, String marginCallFrequency, BigDecimal netCollateralOutstandingAed,
				BigDecimal cvaAed, BigDecimal dvaAed, BigDecimal bilateralCvaAed, BigDecimal fvaAed,
				BigDecimal incrementalPfe, Date reportSubmitDate, Date reportFromDate, Date reportToDate,
				Date reportDate, String entityFlg, String modifyFlg, String delFlg, String reportCode, String entryUser,
				String modifyUser, String verifyUser, Date entryTime, Date modifyTime, Date verifyTime) {
			super();
			this.siNo = siNo;
			this.transactionDate = transactionDate;
			this.bankName = bankName;
			this.headOfficeSubsidiary = headOfficeSubsidiary;
			this.subsidiary = subsidiary;
			this.bankSymbol = bankSymbol;
			this.conventionalIslamic = conventionalIslamic;
			this.cbuaeTiering = cbuaeTiering;
			this.localForeign = localForeign;
			this.counterpartyName = counterpartyName;
			this.internalCounterpartyRef = internalCounterpartyRef;
			this.internalCounterpartyRating = internalCounterpartyRating;
			this.finalRatingCbuae = finalRatingCbuae;
			this.countryOfRisk = countryOfRisk;
			this.cbuaeGeographicalZone = cbuaeGeographicalZone;
			this.counterpartyType = counterpartyType;
			this.sector = sector;
			this.pfe95Aed = pfe95Aed;
			this.expectedPositiveExposureAed = expectedPositiveExposureAed;
			this.expectedNegativeExposureAed = expectedNegativeExposureAed;
			this.csa = csa;
			this.collateralType = collateralType;
			this.threshold = threshold;
			this.minimumTransferAmountAed = minimumTransferAmountAed;
			this.independentAmountAed = independentAmountAed;
			this.marginCallFrequency = marginCallFrequency;
			this.netCollateralOutstandingAed = netCollateralOutstandingAed;
			this.cvaAed = cvaAed;
			this.dvaAed = dvaAed;
			this.bilateralCvaAed = bilateralCvaAed;
			this.fvaAed = fvaAed;
			this.incrementalPfe = incrementalPfe;
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

		public RT_CCR_DATA_TEMPLATE() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
	    
	    

}
