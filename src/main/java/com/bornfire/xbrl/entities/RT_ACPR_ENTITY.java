package com.bornfire.xbrl.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "RT_ACPR_TABLE")
public class RT_ACPR_ENTITY {
	@Id
	@Column(name = "SRL_NO")
	private String srlNo;

	@Column(name = "REPORT_DATE")
	private Date reportDate;

	@Column(name = "TERRITORY_NAME")
	private String territoryName;

	@Column(name = "SOL_ID")
	private String solId;

	@Column(name = "CUST_ID")
	private String custId;

	@Column(name = "ACCOUNT_ID")
	private String accountId;

	@Column(name = "ACCOUNT_NAME")
	private String accountName;

	@Column(name = "OPENING_DATE")
	private Date openingDate;

	@Column(name = "SANCT_DATE")
	private Date sanctDate;

	@Column(name = "GL_HEAD")
	private String glHead;

	@Column(name = "SCHEME")
	private String scheme;

	@Column(name = "CONST_CODE")
	private String constCode;

	@Column(name = "DOCU_DATE")
	private Date docuDate;

	@Column(name = "LAD_DATE")
	private Date ladDate;

	@Column(name = "NEXT_REVIEW")
	private Date nextReview;

	@Column(name = "LIMIT_EXPIRY")
	private Date limitExpiry;

	@Column(name = "ASSET_CLASS")
	private String assetClass;

	@Column(name = "NPA_DATE")
	private Date npaDate;

	@Column(name = "FRAUD")
	private String fraud;

	@Column(name = "RESTR_DATE")
	private Date restrDate;

	@Column(name = "INT_RATE")
	private BigDecimal intRate;

	@Column(name = "CURRENCY")
	private String currency;

	@Column(name = "SANCTION_LIMIT")
	private BigDecimal sanctionLimit;

	@Column(name = "ADHOC_LIMIT")
	private BigDecimal adhocLimit;

	@Column(name = "BALANCE")
	private BigDecimal balance;

	@Column(name = "INTEREST_SUSPENSE")
	private BigDecimal interestSuspense;

	@Column(name = "DEDUCTION")
	private BigDecimal deduction;

	@Column(name = "STOCK_DATE")
	private Date stockDate;

	@Column(name = "STOCK_AMOUNT")
	private BigDecimal stockAmount;

	@Column(name = "BOOK_DEBT_AMOUNT")
	private BigDecimal bookDebtAmount;

	@Column(name = "FD_AMOUNT")
	private BigDecimal fdAmount;

	@Column(name = "RESIDENTIAL_AMOUNT")
	private BigDecimal residentialAmount;

	@Column(name = "OTHERS_SECURITY_AMOUNT")
	private BigDecimal othersSecurityAmount;

	@Column(name = "SEC_VAL_DATE")
	private Date secValDate;

	@Column(name = "ALLOC_SEC_AMOUNT")
	private BigDecimal allocSecAmount;

	@Column(name = "SECURED_AMOUNT")
	private BigDecimal securedAmount;

	@Column(name = "HOME_SEC_PROV")
	private BigDecimal homeSecProv;

	@Column(name = "HOME_UNSEC_PROV")
	private BigDecimal homeUnsecProv;

	@Column(name = "HOME_TOT_PROV")
	private BigDecimal homeTotProv;

	@Column(name = "HOST_SEC_PROV")
	private BigDecimal hostSecProv;

	@Column(name = "HOST_UNSEC_PROV")
	private BigDecimal hostUnsecProv;

	@Column(name = "HOST_TOT_PROV")
	private BigDecimal hostTotProv;

	@Column(name = "STRINGENT_SEC_PROV")
	private BigDecimal stringentSecProv;

	@Column(name = "STRINGENT_UNSEC_PROV")
	private BigDecimal stringentUnsecProv;

	@Column(name = "STRINGENT_PROV")
	private BigDecimal stringentProv;

	@Column(name = "ADDITIONAL_PROVISION")
	private BigDecimal additionalProvision;

	@Column(name = "TOTAL_PROVISION")
	private BigDecimal totalProvision;

	@Column(name = "NET_AMOUNT")
	private BigDecimal netAmount;

	@Column(name = "SECURED")
	private BigDecimal secured;

	@Column(name = "BANK_GOVT_GTEE")
	private BigDecimal bankGovtGtee;

	@Column(name = "UNSECURED")
	private BigDecimal unsecured;

	@Column(name = "SECTOR_CODE")
	private String sectorCode;

	@Column(name = "ACTIVITY_CODE")
	private String activityCode;

	@Column(name = "INDUSTRY_DETAILS")
	private String industryDetails;

	@Column(name = "PAN_NUMBER")
	private String panNumber;

	@Column(name = "CUSTOMER_HEALTH")
	private String customerHealth;

	// --- AUDIT FIELDS ---

	@Column(name = "REPORT_FROM_DATE")
	private Date reportFromDate;

	@Column(name = "REPORT_TO_DATE")
	private Date reportToDate;

	@Column(name = "DEL_FLG")
	private String delFlg;

	@Column(name = "RCRE_USER_ID")
	private String rcreUserId;

	@Column(name = "CREATE_USER")
	private String createUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TIME")
	private Date createTime;

	@Column(name = "ENTITY_FLG")
	private String entityFlg;

	@Column(name = "MODIFY_FLG")
	private String modifyFlg;

	@Column(name = "RCRE_TIME")
	private Date rcreTime;

	public String getSrlNo() {
		return srlNo;
	}

	public void setSrlNo(String srlNo) {
		this.srlNo = srlNo;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getTerritoryName() {
		return territoryName;
	}

	public void setTerritoryName(String territoryName) {
		this.territoryName = territoryName;
	}

	public String getSolId() {
		return solId;
	}

	public void setSolId(String solId) {
		this.solId = solId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public Date getSanctDate() {
		return sanctDate;
	}

	public void setSanctDate(Date sanctDate) {
		this.sanctDate = sanctDate;
	}

	public String getGlHead() {
		return glHead;
	}

	public void setGlHead(String glHead) {
		this.glHead = glHead;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getConstCode() {
		return constCode;
	}

	public void setConstCode(String constCode) {
		this.constCode = constCode;
	}

	public Date getDocuDate() {
		return docuDate;
	}

	public void setDocuDate(Date docuDate) {
		this.docuDate = docuDate;
	}

	public Date getLadDate() {
		return ladDate;
	}

	public void setLadDate(Date ladDate) {
		this.ladDate = ladDate;
	}

	public Date getNextReview() {
		return nextReview;
	}

	public void setNextReview(Date nextReview) {
		this.nextReview = nextReview;
	}

	public Date getLimitExpiry() {
		return limitExpiry;
	}

	public void setLimitExpiry(Date limitExpiry) {
		this.limitExpiry = limitExpiry;
	}

	public String getAssetClass() {
		return assetClass;
	}

	public void setAssetClass(String assetClass) {
		this.assetClass = assetClass;
	}

	public Date getNpaDate() {
		return npaDate;
	}

	public void setNpaDate(Date npaDate) {
		this.npaDate = npaDate;
	}

	public String getFraud() {
		return fraud;
	}

	public void setFraud(String fraud) {
		this.fraud = fraud;
	}

	public Date getRestrDate() {
		return restrDate;
	}

	public void setRestrDate(Date restrDate) {
		this.restrDate = restrDate;
	}

	public BigDecimal getIntRate() {
		return intRate;
	}

	public void setIntRate(BigDecimal intRate) {
		this.intRate = intRate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getSanctionLimit() {
		return sanctionLimit;
	}

	public void setSanctionLimit(BigDecimal sanctionLimit) {
		this.sanctionLimit = sanctionLimit;
	}

	public BigDecimal getAdhocLimit() {
		return adhocLimit;
	}

	public void setAdhocLimit(BigDecimal adhocLimit) {
		this.adhocLimit = adhocLimit;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getInterestSuspense() {
		return interestSuspense;
	}

	public void setInterestSuspense(BigDecimal interestSuspense) {
		this.interestSuspense = interestSuspense;
	}

	public BigDecimal getDeduction() {
		return deduction;
	}

	public void setDeduction(BigDecimal deduction) {
		this.deduction = deduction;
	}

	public Date getStockDate() {
		return stockDate;
	}

	public void setStockDate(Date stockDate) {
		this.stockDate = stockDate;
	}

	public BigDecimal getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(BigDecimal stockAmount) {
		this.stockAmount = stockAmount;
	}

	public BigDecimal getBookDebtAmount() {
		return bookDebtAmount;
	}

	public void setBookDebtAmount(BigDecimal bookDebtAmount) {
		this.bookDebtAmount = bookDebtAmount;
	}

	public BigDecimal getFdAmount() {
		return fdAmount;
	}

	public void setFdAmount(BigDecimal fdAmount) {
		this.fdAmount = fdAmount;
	}

	public BigDecimal getResidentialAmount() {
		return residentialAmount;
	}

	public void setResidentialAmount(BigDecimal residentialAmount) {
		this.residentialAmount = residentialAmount;
	}

	public BigDecimal getOthersSecurityAmount() {
		return othersSecurityAmount;
	}

	public void setOthersSecurityAmount(BigDecimal othersSecurityAmount) {
		this.othersSecurityAmount = othersSecurityAmount;
	}

	public Date getSecValDate() {
		return secValDate;
	}

	public void setSecValDate(Date secValDate) {
		this.secValDate = secValDate;
	}

	public BigDecimal getAllocSecAmount() {
		return allocSecAmount;
	}

	public void setAllocSecAmount(BigDecimal allocSecAmount) {
		this.allocSecAmount = allocSecAmount;
	}

	public BigDecimal getSecuredAmount() {
		return securedAmount;
	}

	public void setSecuredAmount(BigDecimal securedAmount) {
		this.securedAmount = securedAmount;
	}

	public BigDecimal getHomeSecProv() {
		return homeSecProv;
	}

	public void setHomeSecProv(BigDecimal homeSecProv) {
		this.homeSecProv = homeSecProv;
	}

	public BigDecimal getHomeUnsecProv() {
		return homeUnsecProv;
	}

	public void setHomeUnsecProv(BigDecimal homeUnsecProv) {
		this.homeUnsecProv = homeUnsecProv;
	}

	public BigDecimal getHomeTotProv() {
		return homeTotProv;
	}

	public void setHomeTotProv(BigDecimal homeTotProv) {
		this.homeTotProv = homeTotProv;
	}

	public BigDecimal getHostSecProv() {
		return hostSecProv;
	}

	public void setHostSecProv(BigDecimal hostSecProv) {
		this.hostSecProv = hostSecProv;
	}

	public BigDecimal getHostUnsecProv() {
		return hostUnsecProv;
	}

	public void setHostUnsecProv(BigDecimal hostUnsecProv) {
		this.hostUnsecProv = hostUnsecProv;
	}

	public BigDecimal getHostTotProv() {
		return hostTotProv;
	}

	public void setHostTotProv(BigDecimal hostTotProv) {
		this.hostTotProv = hostTotProv;
	}

	public BigDecimal getStringentSecProv() {
		return stringentSecProv;
	}

	public void setStringentSecProv(BigDecimal stringentSecProv) {
		this.stringentSecProv = stringentSecProv;
	}

	public BigDecimal getStringentUnsecProv() {
		return stringentUnsecProv;
	}

	public void setStringentUnsecProv(BigDecimal stringentUnsecProv) {
		this.stringentUnsecProv = stringentUnsecProv;
	}

	public BigDecimal getStringentProv() {
		return stringentProv;
	}

	public void setStringentProv(BigDecimal stringentProv) {
		this.stringentProv = stringentProv;
	}

	public BigDecimal getAdditionalProvision() {
		return additionalProvision;
	}

	public void setAdditionalProvision(BigDecimal additionalProvision) {
		this.additionalProvision = additionalProvision;
	}

	public BigDecimal getTotalProvision() {
		return totalProvision;
	}

	public void setTotalProvision(BigDecimal totalProvision) {
		this.totalProvision = totalProvision;
	}

	public BigDecimal getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}

	public BigDecimal getSecured() {
		return secured;
	}

	public void setSecured(BigDecimal secured) {
		this.secured = secured;
	}

	public BigDecimal getBankGovtGtee() {
		return bankGovtGtee;
	}

	public void setBankGovtGtee(BigDecimal bankGovtGtee) {
		this.bankGovtGtee = bankGovtGtee;
	}

	public BigDecimal getUnsecured() {
		return unsecured;
	}

	public void setUnsecured(BigDecimal unsecured) {
		this.unsecured = unsecured;
	}

	public String getSectorCode() {
		return sectorCode;
	}

	public void setSectorCode(String sectorCode) {
		this.sectorCode = sectorCode;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public String getIndustryDetails() {
		return industryDetails;
	}

	public void setIndustryDetails(String industryDetails) {
		this.industryDetails = industryDetails;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getCustomerHealth() {
		return customerHealth;
	}

	public void setCustomerHealth(String customerHealth) {
		this.customerHealth = customerHealth;
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

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	public String getRcreUserId() {
		return rcreUserId;
	}

	public void setRcreUserId(String rcreUserId) {
		this.rcreUserId = rcreUserId;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public Date getRcreTime() {
		return rcreTime;
	}

	public void setRcreTime(Date rcreTime) {
		this.rcreTime = rcreTime;
	}

	@Override
	public String toString() {
		return "RT_ACPR_ENTITY [srlNo=" + srlNo + ", reportDate=" + reportDate + ", territoryName=" + territoryName
				+ ", solId=" + solId + ", custId=" + custId + ", accountId=" + accountId + ", accountName="
				+ accountName + ", openingDate=" + openingDate + ", sanctDate=" + sanctDate + ", glHead=" + glHead
				+ ", scheme=" + scheme + ", constCode=" + constCode + ", docuDate=" + docuDate + ", ladDate=" + ladDate
				+ ", nextReview=" + nextReview + ", limitExpiry=" + limitExpiry + ", assetClass=" + assetClass
				+ ", npaDate=" + npaDate + ", fraud=" + fraud + ", restrDate=" + restrDate + ", intRate=" + intRate
				+ ", currency=" + currency + ", sanctionLimit=" + sanctionLimit + ", adhocLimit=" + adhocLimit
				+ ", balance=" + balance + ", interestSuspense=" + interestSuspense + ", deduction=" + deduction
				+ ", stockDate=" + stockDate + ", stockAmount=" + stockAmount + ", bookDebtAmount=" + bookDebtAmount
				+ ", fdAmount=" + fdAmount + ", residentialAmount=" + residentialAmount + ", othersSecurityAmount="
				+ othersSecurityAmount + ", secValDate=" + secValDate + ", allocSecAmount=" + allocSecAmount
				+ ", securedAmount=" + securedAmount + ", homeSecProv=" + homeSecProv + ", homeUnsecProv="
				+ homeUnsecProv + ", homeTotProv=" + homeTotProv + ", hostSecProv=" + hostSecProv + ", hostUnsecProv="
				+ hostUnsecProv + ", hostTotProv=" + hostTotProv + ", stringentSecProv=" + stringentSecProv
				+ ", stringentUnsecProv=" + stringentUnsecProv + ", stringentProv=" + stringentProv
				+ ", additionalProvision=" + additionalProvision + ", totalProvision=" + totalProvision + ", netAmount="
				+ netAmount + ", secured=" + secured + ", bankGovtGtee=" + bankGovtGtee + ", unsecured=" + unsecured
				+ ", sectorCode=" + sectorCode + ", activityCode=" + activityCode + ", industryDetails="
				+ industryDetails + ", panNumber=" + panNumber + ", customerHealth=" + customerHealth
				+ ", reportFromDate=" + reportFromDate + ", reportToDate=" + reportToDate + ", delFlg=" + delFlg
				+ ", rcreUserId=" + rcreUserId + ", createUser=" + createUser + ", createTime=" + createTime
				+ ", entityFlg=" + entityFlg + ", modifyFlg=" + modifyFlg + ", rcreTime=" + rcreTime + ", getSrlNo()="
				+ getSrlNo() + ", getReportDate()=" + getReportDate() + ", getTerritoryName()=" + getTerritoryName()
				+ ", getSolId()=" + getSolId() + ", getCustId()=" + getCustId() + ", getAccountId()=" + getAccountId()
				+ ", getAccountName()=" + getAccountName() + ", getOpeningDate()=" + getOpeningDate()
				+ ", getSanctDate()=" + getSanctDate() + ", getGlHead()=" + getGlHead() + ", getScheme()=" + getScheme()
				+ ", getConstCode()=" + getConstCode() + ", getDocuDate()=" + getDocuDate() + ", getLadDate()="
				+ getLadDate() + ", getNextReview()=" + getNextReview() + ", getLimitExpiry()=" + getLimitExpiry()
				+ ", getAssetClass()=" + getAssetClass() + ", getNpaDate()=" + getNpaDate() + ", getFraud()="
				+ getFraud() + ", getRestrDate()=" + getRestrDate() + ", getIntRate()=" + getIntRate()
				+ ", getCurrency()=" + getCurrency() + ", getSanctionLimit()=" + getSanctionLimit()
				+ ", getAdhocLimit()=" + getAdhocLimit() + ", getBalance()=" + getBalance() + ", getInterestSuspense()="
				+ getInterestSuspense() + ", getDeduction()=" + getDeduction() + ", getStockDate()=" + getStockDate()
				+ ", getStockAmount()=" + getStockAmount() + ", getBookDebtAmount()=" + getBookDebtAmount()
				+ ", getFdAmount()=" + getFdAmount() + ", getResidentialAmount()=" + getResidentialAmount()
				+ ", getOthersSecurityAmount()=" + getOthersSecurityAmount() + ", getSecValDate()=" + getSecValDate()
				+ ", getAllocSecAmount()=" + getAllocSecAmount() + ", getSecuredAmount()=" + getSecuredAmount()
				+ ", getHomeSecProv()=" + getHomeSecProv() + ", getHomeUnsecProv()=" + getHomeUnsecProv()
				+ ", getHomeTotProv()=" + getHomeTotProv() + ", getHostSecProv()=" + getHostSecProv()
				+ ", getHostUnsecProv()=" + getHostUnsecProv() + ", getHostTotProv()=" + getHostTotProv()
				+ ", getStringentSecProv()=" + getStringentSecProv() + ", getStringentUnsecProv()="
				+ getStringentUnsecProv() + ", getStringentProv()=" + getStringentProv() + ", getAdditionalProvision()="
				+ getAdditionalProvision() + ", getTotalProvision()=" + getTotalProvision() + ", getNetAmount()="
				+ getNetAmount() + ", getSecured()=" + getSecured() + ", getBankGovtGtee()=" + getBankGovtGtee()
				+ ", getUnsecured()=" + getUnsecured() + ", getSectorCode()=" + getSectorCode() + ", getActivityCode()="
				+ getActivityCode() + ", getIndustryDetails()=" + getIndustryDetails() + ", getPanNumber()="
				+ getPanNumber() + ", getCustomerHealth()=" + getCustomerHealth() + ", getReportFromDate()="
				+ getReportFromDate() + ", getReportToDate()=" + getReportToDate() + ", getDelFlg()=" + getDelFlg()
				+ ", getRcreUserId()=" + getRcreUserId() + ", getCreateUser()=" + getCreateUser() + ", getCreateTime()="
				+ getCreateTime() + ", getEntityFlg()=" + getEntityFlg() + ", getModifyFlg()=" + getModifyFlg()
				+ ", getRcreTime()=" + getRcreTime() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public RT_ACPR_ENTITY(String srlNo, Date reportDate, String territoryName, String solId, String custId,
			String accountId, String accountName, Date openingDate, Date sanctDate, String glHead, String scheme,
			String constCode, Date docuDate, Date ladDate, Date nextReview, Date limitExpiry, String assetClass,
			Date npaDate, String fraud, Date restrDate, BigDecimal intRate, String currency, BigDecimal sanctionLimit,
			BigDecimal adhocLimit, BigDecimal balance, BigDecimal interestSuspense, BigDecimal deduction,
			Date stockDate, BigDecimal stockAmount, BigDecimal bookDebtAmount, BigDecimal fdAmount,
			BigDecimal residentialAmount, BigDecimal othersSecurityAmount, Date secValDate, BigDecimal allocSecAmount,
			BigDecimal securedAmount, BigDecimal homeSecProv, BigDecimal homeUnsecProv, BigDecimal homeTotProv,
			BigDecimal hostSecProv, BigDecimal hostUnsecProv, BigDecimal hostTotProv, BigDecimal stringentSecProv,
			BigDecimal stringentUnsecProv, BigDecimal stringentProv, BigDecimal additionalProvision,
			BigDecimal totalProvision, BigDecimal netAmount, BigDecimal secured, BigDecimal bankGovtGtee,
			BigDecimal unsecured, String sectorCode, String activityCode, String industryDetails, String panNumber,
			String customerHealth, Date reportFromDate, Date reportToDate, String delFlg, String rcreUserId,
			String createUser, Date createTime, String entityFlg, String modifyFlg, Date rcreTime) {
		super();
		this.srlNo = srlNo;
		this.reportDate = reportDate;
		this.territoryName = territoryName;
		this.solId = solId;
		this.custId = custId;
		this.accountId = accountId;
		this.accountName = accountName;
		this.openingDate = openingDate;
		this.sanctDate = sanctDate;
		this.glHead = glHead;
		this.scheme = scheme;
		this.constCode = constCode;
		this.docuDate = docuDate;
		this.ladDate = ladDate;
		this.nextReview = nextReview;
		this.limitExpiry = limitExpiry;
		this.assetClass = assetClass;
		this.npaDate = npaDate;
		this.fraud = fraud;
		this.restrDate = restrDate;
		this.intRate = intRate;
		this.currency = currency;
		this.sanctionLimit = sanctionLimit;
		this.adhocLimit = adhocLimit;
		this.balance = balance;
		this.interestSuspense = interestSuspense;
		this.deduction = deduction;
		this.stockDate = stockDate;
		this.stockAmount = stockAmount;
		this.bookDebtAmount = bookDebtAmount;
		this.fdAmount = fdAmount;
		this.residentialAmount = residentialAmount;
		this.othersSecurityAmount = othersSecurityAmount;
		this.secValDate = secValDate;
		this.allocSecAmount = allocSecAmount;
		this.securedAmount = securedAmount;
		this.homeSecProv = homeSecProv;
		this.homeUnsecProv = homeUnsecProv;
		this.homeTotProv = homeTotProv;
		this.hostSecProv = hostSecProv;
		this.hostUnsecProv = hostUnsecProv;
		this.hostTotProv = hostTotProv;
		this.stringentSecProv = stringentSecProv;
		this.stringentUnsecProv = stringentUnsecProv;
		this.stringentProv = stringentProv;
		this.additionalProvision = additionalProvision;
		this.totalProvision = totalProvision;
		this.netAmount = netAmount;
		this.secured = secured;
		this.bankGovtGtee = bankGovtGtee;
		this.unsecured = unsecured;
		this.sectorCode = sectorCode;
		this.activityCode = activityCode;
		this.industryDetails = industryDetails;
		this.panNumber = panNumber;
		this.customerHealth = customerHealth;
		this.reportFromDate = reportFromDate;
		this.reportToDate = reportToDate;
		this.delFlg = delFlg;
		this.rcreUserId = rcreUserId;
		this.createUser = createUser;
		this.createTime = createTime;
		this.entityFlg = entityFlg;
		this.modifyFlg = modifyFlg;
		this.rcreTime = rcreTime;
	}

	public RT_ACPR_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}

}