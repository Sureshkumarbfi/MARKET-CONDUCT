package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "MIS_COUNTER_PARTY_TABLE")
public class Counterparty_Entity {

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "SRL_NO")
	private String srlNo;

	@Column(name = "COUNTER_PARTY_BANK", length = 100)
	private String counterPartyBank;

	@Column(name = "COUNTERPARTY_CODE", length = 50)
	private String counterPartyBankCode;

	@Column(name = "LOCATION", length = 100)
	private String location;

	@Column(name = "CREATE_USER", length = 100)
	private String createUser;

	@Column(name = "MODIFY_USER", length = 100)
	private String modifyUser;

	@Column(name = "DEL_FLG", length = 1)
	private String delFlg;

	@Column(name = "RATING", length = 1)
	private String rating;

	@Column(name = "COUNTERPARTY_CREATED_DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date counterpartyCreatedDate;

	@Column(name = "REGULAR_LIMIT", precision = 24, scale = 2)
	private BigDecimal regularLimit;

	@Column(name = "ADHOC_LIMIT", precision = 24, scale = 2)
	private BigDecimal adhocLimit;

	@Column(name = "CREDIT_LIMIT", precision = 24, scale = 2)
	private BigDecimal creditLimit;

	@Column(name = "SETTLEMENT_LIMIT", precision = 24, scale = 2)
	private BigDecimal settlementLimit;

	@Column(name = "MONEY_MARKET_LIMIT", precision = 24, scale = 2)
	private BigDecimal moneyMarketLimit;

	@Column(name = "TRADE_FINANCE_LIMIT", precision = 24, scale = 2)
	private BigDecimal tradeFinanceLimit;

	@Column(name = "EXPIRY_DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expiryDate;

	@Column(name = "ADHOC_LIMIT_EXP_DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date Adhoc_Limit_exp_date;

	@Column(name = "EAR_Marking_Limit", length = 1)
	private String earmarkinglimit;

	@Column(name = "Ear_Marking_Date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date earmarkingdate;

	@Column(name = "COUNTRY_RATING", length = 50)
	private String countryRating;

	@Column(name = "DELETE_REQUEST_STATUS", length = 20)
	private String deleteRequestStatus;

	@Column(name = "DELETE_REMARKS", length = 1000)
	private String deleteRemarks;

	@Column(name = "DELETE_REQUESTED_BY", length = 100)
	private String deleteRequestedBy;

	@Column(name = "DELETE_REQUESTED_AT")
	private Date deleteRequestedAt;

	@Column(name = "DELETE_APPROVED_BY", length = 100)
	private String deleteApprovedBy;

	@Column(name = "DELETE_APPROVED_AT")
	private Date deleteApprovedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSrlNo() {
		return srlNo;
	}

	public void setSrlNo(String srlNo) {
		this.srlNo = srlNo;
	}

	public String getCounterPartyBank() {
		return counterPartyBank;
	}

	public void setCounterPartyBank(String counterPartyBank) {
		this.counterPartyBank = counterPartyBank;
	}

	public String getCounterPartyBankCode() {
		return counterPartyBankCode;
	}

	public void setCounterPartyBankCode(String counterPartyBankCode) {
		this.counterPartyBankCode = counterPartyBankCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Date getCounterpartyCreatedDate() {
		return counterpartyCreatedDate;
	}

	public void setCounterpartyCreatedDate(Date counterpartyCreatedDate) {
		this.counterpartyCreatedDate = counterpartyCreatedDate;
	}

	public BigDecimal getRegularLimit() {
		return regularLimit;
	}

	public void setRegularLimit(BigDecimal regularLimit) {
		this.regularLimit = regularLimit;
	}

	public BigDecimal getAdhocLimit() {
		return adhocLimit;
	}

	public void setAdhocLimit(BigDecimal adhocLimit) {
		this.adhocLimit = adhocLimit;
	}

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	public BigDecimal getSettlementLimit() {
		return settlementLimit;
	}

	public void setSettlementLimit(BigDecimal settlementLimit) {
		this.settlementLimit = settlementLimit;
	}

	public BigDecimal getMoneyMarketLimit() {
		return moneyMarketLimit;
	}

	public void setMoneyMarketLimit(BigDecimal moneyMarketLimit) {
		this.moneyMarketLimit = moneyMarketLimit;
	}

	public BigDecimal getTradeFinanceLimit() {
		return tradeFinanceLimit;
	}

	public void setTradeFinanceLimit(BigDecimal tradeFinanceLimit) {
		this.tradeFinanceLimit = tradeFinanceLimit;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getAdhoc_Limit_exp_date() {
		return Adhoc_Limit_exp_date;
	}

	public void setAdhoc_Limit_exp_date(Date adhoc_Limit_exp_date) {
		Adhoc_Limit_exp_date = adhoc_Limit_exp_date;
	}

	public String getEarmarkinglimit() {
		return earmarkinglimit;
	}

	public void setEarmarkinglimit(String earmarkinglimit) {
		this.earmarkinglimit = earmarkinglimit;
	}

	public Date getEarmarkingdate() {
		return earmarkingdate;
	}

	public void setEarmarkingdate(Date earmarkingdate) {
		this.earmarkingdate = earmarkingdate;
	}

	public String getCountryRating() {
		return countryRating;
	}

	public void setCountryRating(String countryRating) {
		this.countryRating = countryRating;
	}

	public String getDeleteRequestStatus() {
		return deleteRequestStatus;
	}

	public void setDeleteRequestStatus(String deleteRequestStatus) {
		this.deleteRequestStatus = deleteRequestStatus;
	}

	public String getDeleteRemarks() {
		return deleteRemarks;
	}

	public void setDeleteRemarks(String deleteRemarks) {
		this.deleteRemarks = deleteRemarks;
	}

	public String getDeleteRequestedBy() {
		return deleteRequestedBy;
	}

	public void setDeleteRequestedBy(String deleteRequestedBy) {
		this.deleteRequestedBy = deleteRequestedBy;
	}

	public Date getDeleteRequestedAt() {
		return deleteRequestedAt;
	}

	public void setDeleteRequestedAt(Date deleteRequestedAt) {
		this.deleteRequestedAt = deleteRequestedAt;
	}

	public String getDeleteApprovedBy() {
		return deleteApprovedBy;
	}

	public void setDeleteApprovedBy(String deleteApprovedBy) {
		this.deleteApprovedBy = deleteApprovedBy;
	}

	public Date getDeleteApprovedAt() {
		return deleteApprovedAt;
	}

	public void setDeleteApprovedAt(Date deleteApprovedAt) {
		this.deleteApprovedAt = deleteApprovedAt;
	}

	public Counterparty_Entity(Long id, String srlNo, String counterPartyBank, String counterPartyBankCode,
			String location, String createUser, String modifyUser, String delFlg, String rating,
			Date counterpartyCreatedDate, BigDecimal regularLimit, BigDecimal adhocLimit, BigDecimal creditLimit,
			BigDecimal settlementLimit, BigDecimal moneyMarketLimit, BigDecimal tradeFinanceLimit, Date expiryDate,
			Date adhoc_Limit_exp_date, String earmarkinglimit, Date earmarkingdate, String countryRating) {
		super();
		this.id = id;
		this.srlNo = srlNo;
		this.counterPartyBank = counterPartyBank;
		this.counterPartyBankCode = counterPartyBankCode;
		this.location = location;
		this.createUser = createUser;
		this.modifyUser = modifyUser;
		this.delFlg = delFlg;
		this.rating = rating;
		this.counterpartyCreatedDate = counterpartyCreatedDate;
		this.regularLimit = regularLimit;
		this.adhocLimit = adhocLimit;
		this.creditLimit = creditLimit;
		this.settlementLimit = settlementLimit;
		this.moneyMarketLimit = moneyMarketLimit;
		this.tradeFinanceLimit = tradeFinanceLimit;
		this.expiryDate = expiryDate;
		Adhoc_Limit_exp_date = adhoc_Limit_exp_date;
		this.earmarkinglimit = earmarkinglimit;
		this.earmarkingdate = earmarkingdate;
		this.countryRating = countryRating;
	}

	public Counterparty_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
