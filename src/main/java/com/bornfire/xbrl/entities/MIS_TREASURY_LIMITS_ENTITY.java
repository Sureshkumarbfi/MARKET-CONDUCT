package com.bornfire.xbrl.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "MIS_TREASURY_LIMITS") // Replace with actual table name
public class MIS_TREASURY_LIMITS_ENTITY {

    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "COUNTERPARTY")
    private String counterparty;

    @Column(name = "PORTEFEUILLE")
    private String portefeuille;

    @Column(name = "AMT_AED")
    private BigDecimal amtAed;

    @Column(name = "AMT_GBP")
    private BigDecimal amtGbp;

    @Column(name = "AMT_USD")
    private BigDecimal amtUsd;

    @Column(name = "AMT_EUR")
    private BigDecimal amtEur;

    @Column(name = "IN_USD_MN")
    private BigDecimal inUsdMn;

    @Column(name = "CREATE_USER")
    private String createUser;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "MODIFY_USER")
    private String modifyUser;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFY_TIME")
    private Date modifyTime;

    @Column(name = "VERIFY_USER")
    private String verifyUser;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "VERIFY_TIME")
    private Date verifyTime;

    @Column(name = "ENTITY_FLG")
    private String entityFlg;

    @Column(name = "MODIFY_FLG")
    private String modifyFlg;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Temporal(TemporalType.DATE)
    @Column(name = "REPORT_DATE")
    private Date reportDate;

    @Column(name = "BRANCH_CODE")
    private String branchCode;

    @Column(name = "BRANCH_NAME")
    private String branchName;


	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCounterparty() {
		return counterparty;
	}

	public void setCounterparty(String counterparty) {
		this.counterparty = counterparty;
	}

	public String getPortefeuille() {
		return portefeuille;
	}

	public void setPortefeuille(String portefeuille) {
		this.portefeuille = portefeuille;
	}

	public BigDecimal getAmtAed() {
		return amtAed;
	}

	public void setAmtAed(BigDecimal amtAed) {
		this.amtAed = amtAed;
	}

	public BigDecimal getAmtGbp() {
		return amtGbp;
	}

	public void setAmtGbp(BigDecimal amtGbp) {
		this.amtGbp = amtGbp;
	}

	public BigDecimal getAmtUsd() {
		return amtUsd;
	}

	public void setAmtUsd(BigDecimal amtUsd) {
		this.amtUsd = amtUsd;
	}

	public BigDecimal getAmtEur() {
		return amtEur;
	}

	public void setAmtEur(BigDecimal amtEur) {
		this.amtEur = amtEur;
	}

	public BigDecimal getInUsdMn() {
		return inUsdMn;
	}

	public void setInUsdMn(BigDecimal inUsdMn) {
		this.inUsdMn = inUsdMn;
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

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

    // Getters and Setters

}

