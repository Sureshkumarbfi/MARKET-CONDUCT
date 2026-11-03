package com.bornfire.xbrl.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "COUNTERPARTY_MAINTENANCE")
public class CounterpartyMaintenanceEntity {

	@Id
	@Column(name = "COUNTERPARTY_CODE", length = 100)
	private String counterpartyCode;

	@Column(name = "ALIAS_COUNTER_CODE", length = 100)
	private String aliasCounterCode;

	@Column(name = "COUNTERPARTY_NAME", length = 100)
	private String counterpartyName;

	@Column(name = "ASL_BANK_NAME", length = 100)
	private String aslBankName;

	@Column(name = "COUNTERPARTY_RATING", length = 100)
	private String counterpartyRating;

	@Column(name = "COUNTRY_RISK", length = 100)
	private String countryRisk;

	@Column(name = "CBUAE_GEOGRAPHICAL_ZONE", length = 100)
	private String cbuaeGeographicalZone;

	@Column(name = "COUNTERPARTY_TYPE", length = 100)
	private String counterpartyType;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "REPORT_TO_DATE")
	private Date reportToDate;

	@Column(name = "CREATE_USER", length = 100)
	private String createUser;

	@Column(name = "CREATE_TIME")
	private Date createTime;

	@Column(name = "MODIFY_USER", length = 50)
	private String modifyUser;

	@Column(name = "MODIFY_TIME")
	private Date modifyTime;

	@Column(name = "VERIFY_USER", length = 50)
	private String verifyUser;

	@Column(name = "VERIFY_TIME")
	private Date verifyTime;

	@Column(name = "ENTITY_FLG", length = 10)
	private String entityFlg;

	@Column(name = "MODIFY_FLG", length = 10)
	private String modifyFlg;

	public String getCounterpartyCode() {
		return counterpartyCode;
	}

	public void setCounterpartyCode(String counterpartyCode) {
		this.counterpartyCode = counterpartyCode;
	}

	public String getAliasCounterCode() {
		return aliasCounterCode;
	}

	public void setAliasCounterCode(String aliasCounterCode) {
		this.aliasCounterCode = aliasCounterCode;
	}

	public String getCounterpartyName() {
		return counterpartyName;
	}

	public void setCounterpartyName(String counterpartyName) {
		this.counterpartyName = counterpartyName;
	}

	public String getAslBankName() {
		return aslBankName;
	}

	public void setAslBankName(String aslBankName) {
		this.aslBankName = aslBankName;
	}

	public String getCounterpartyRating() {
		return counterpartyRating;
	}

	public void setCounterpartyRating(String counterpartyRating) {
		this.counterpartyRating = counterpartyRating;
	}

	public String getCountryRisk() {
		return countryRisk;
	}

	public void setCountryRisk(String countryRisk) {
		this.countryRisk = countryRisk;
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

	public Date getReportToDate() {
		return reportToDate;
	}

	public void setReportToDate(Date reportToDate) {
		this.reportToDate = reportToDate;
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

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getVerifyUser() {
		return verifyUser;
	}

	public void setVerifyUser(String verifyUser) {
		this.verifyUser = verifyUser;
	}

	public Date getVerifyTime() {
		return verifyTime;
	}

	public void setVerifyTime(Date verifyTime) {
		this.verifyTime = verifyTime;
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
}
