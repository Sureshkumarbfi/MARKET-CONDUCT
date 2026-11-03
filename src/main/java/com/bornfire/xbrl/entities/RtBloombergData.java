package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RT_BLOOMBERG_DATA")
public class RtBloombergData {

	@Id
    @Column(name = "ISIN")
    private String isin;

    @Column(name = "COUPON_TYPE")
    private String couponType;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COUNTRY_OF_RISK")
    private String countryOfRisk;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SECTOR")
    private String sector;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "AMOUNT_ISSUED")
    private BigDecimal amountIssued;

    @Column(name = "CLEAN_PRICE")
    private BigDecimal cleanPrice;

    @Column(name = "YTM")
    private BigDecimal ytm;

    @Column(name = "MATURITY_DATE")
    private Date maturityDate;

    @Column(name = "ENTRY_DATE")
    private Date entryDate;

    @Column(name = "MODIFY_DATE")
    private Date modifyDate;

    @Column(name = "VERIFY_DATE")
    private Date verifyDate;

    @Column(name = "ENTRY_USER")
    private String entryUser;

    @Column(name = "MODIFY_USER")
    private String modifyUser;

    @Column(name = "VERIFY_USER")
    private String verifyUser;

    @Column(name = "ENTRY_FLG")
    private String entryFlg;

    @Column(name = "MODIFY_FLG")
    private String modifyFlg;

    @Column(name = "VERIFY_FLG")
    private String verifyFlg;

    @Column(name = "DEL_FLG")
    private String delFlg;
    
    @Column(name = "STATUS_FLG")
    private String statusflg;
    

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public String getCouponType() {
		return couponType;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryOfRisk() {
		return countryOfRisk;
	}

	public void setCountryOfRisk(String countryOfRisk) {
		this.countryOfRisk = countryOfRisk;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getAmountIssued() {
		return amountIssued;
	}

	public void setAmountIssued(BigDecimal amountIssued) {
		this.amountIssued = amountIssued;
	}

	public BigDecimal getCleanPrice() {
		return cleanPrice;
	}

	public void setCleanPrice(BigDecimal cleanPrice) {
		this.cleanPrice = cleanPrice;
	}

	public BigDecimal getYtm() {
		return ytm;
	}

	public void setYtm(BigDecimal ytm) {
		this.ytm = ytm;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Date getVerifyDate() {
		return verifyDate;
	}

	public void setVerifyDate(Date verifyDate) {
		this.verifyDate = verifyDate;
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

	public String getEntryFlg() {
		return entryFlg;
	}

	public void setEntryFlg(String entryFlg) {
		this.entryFlg = entryFlg;
	}

	public String getModifyFlg() {
		return modifyFlg;
	}

	public void setModifyFlg(String modifyFlg) {
		this.modifyFlg = modifyFlg;
	}

	public String getVerifyFlg() {
		return verifyFlg;
	}

	public void setVerifyFlg(String verifyFlg) {
		this.verifyFlg = verifyFlg;
	}

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	public String getStatusflg() {
		return statusflg;
	}

	public void setStatusflg(String statusflg) {
		this.statusflg = statusflg;
	}

	public RtBloombergData(String isin, String couponType, String name, String countryOfRisk, String description,
			String sector, String currency, BigDecimal amountIssued, BigDecimal cleanPrice, BigDecimal ytm,
			Date maturityDate, Date entryDate, Date modifyDate, Date verifyDate, String entryUser, String modifyUser,
			String verifyUser, String entryFlg, String modifyFlg, String verifyFlg, String delFlg, String statusflg) {
		super();
		this.isin = isin;
		this.couponType = couponType;
		this.name = name;
		this.countryOfRisk = countryOfRisk;
		this.description = description;
		this.sector = sector;
		this.currency = currency;
		this.amountIssued = amountIssued;
		this.cleanPrice = cleanPrice;
		this.ytm = ytm;
		this.maturityDate = maturityDate;
		this.entryDate = entryDate;
		this.modifyDate = modifyDate;
		this.verifyDate = verifyDate;
		this.entryUser = entryUser;
		this.modifyUser = modifyUser;
		this.verifyUser = verifyUser;
		this.entryFlg = entryFlg;
		this.modifyFlg = modifyFlg;
		this.verifyFlg = verifyFlg;
		this.delFlg = delFlg;
		this.statusflg = statusflg;
	}

	public RtBloombergData() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    
    
}
