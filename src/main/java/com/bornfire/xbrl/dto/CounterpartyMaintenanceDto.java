package com.bornfire.xbrl.dto;

import java.util.Date;

public class CounterpartyMaintenanceDto {

	private String counterpartyCode;
	private String aliasCounterCode;
	private String counterpartyName;
	private String aslBankName;
	private String counterpartyRating;
	private String countryRisk;
	private String cbuaeGeographicalZone;
	private String counterpartyType;
	private String reportDate;
	private boolean presentInMaintenance;
	private String createUser;
	private String modifyUser;
	private Date createTime;
	private Date modifyTime;

	public CounterpartyMaintenanceDto() {
	}

	public CounterpartyMaintenanceDto(String counterpartyCode, String aliasCounterCode, String counterpartyName,
			String aslBankName) {
		this.counterpartyCode = counterpartyCode;
		this.aliasCounterCode = aliasCounterCode;
		this.counterpartyName = counterpartyName;
		this.aslBankName = aslBankName;
	}

	public CounterpartyMaintenanceDto copy() {
		CounterpartyMaintenanceDto copy = new CounterpartyMaintenanceDto();
		copy.counterpartyCode = this.counterpartyCode;
		copy.aliasCounterCode = this.aliasCounterCode;
		copy.counterpartyName = this.counterpartyName;
		copy.aslBankName = this.aslBankName;
		copy.counterpartyRating = this.counterpartyRating;
		copy.countryRisk = this.countryRisk;
		copy.cbuaeGeographicalZone = this.cbuaeGeographicalZone;
		copy.counterpartyType = this.counterpartyType;
		copy.reportDate = this.reportDate;
		copy.presentInMaintenance = this.presentInMaintenance;
		copy.createUser = this.createUser;
		copy.modifyUser = this.modifyUser;
		copy.createTime = this.createTime;
		copy.modifyTime = this.modifyTime;
		return copy;
	}

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

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public boolean isPresentInMaintenance() {
		return presentInMaintenance;
	}

	public void setPresentInMaintenance(boolean presentInMaintenance) {
		this.presentInMaintenance = presentInMaintenance;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
}
