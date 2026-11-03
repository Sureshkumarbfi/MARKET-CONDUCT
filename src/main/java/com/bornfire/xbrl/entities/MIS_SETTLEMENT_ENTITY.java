package com.bornfire.xbrl.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MIS_SETTLEMENT") // Replace with actual table name
public class MIS_SETTLEMENT_ENTITY {

    @Id
    @Column(name = "DEAL_ID", length = 50)
    private String dealId;

    @Column(name = "AMOUNT1", precision = 20, scale = 2)
    private Double amount1;

    @Column(name = "AMOUNT2", precision = 20, scale = 2)
    private Double amount2;

    @Column(name = "RATE_OR_PRICE", precision = 10, scale = 4)
    private Double rateOrPrice;

    @Column(name = "SECURITY", length = 20)
    private String security;

    @Temporal(TemporalType.DATE)
    @Column(name = "TRADE_DATE")
    private Date tradeDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "VALUE_DATE")
    private Date valueDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "MATURITY_DATE")
    private Date maturityDate;

    @Column(name = "DAY")
    private Integer day;

    @Column(name = "COUNTERPARTY_CODE", length = 20)
    private String counterpartyCode;

    @Column(name = "COUNTERPARTY_NAME", length = 100)
    private String counterpartyName;

    @Column(name = "AMOUNT", precision = 20, scale = 2)
    private Double amount;

    @Column(name = "RESIDUAL_MATURITY")
    private Integer residualMaturity;

    @Column(name = "CCF", length = 10)
    private String ccf;

    @Column(name = "CCF_AMOUNT", precision = 20, scale = 2)
    private Double ccfAmount;

    @Column(name = "CREATE_USER", length = 10)
    private String createUser;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "MODIFY_USER", length = 50)
    private String modifyUser;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFY_TIME")
    private Date modifyTime;

    @Column(name = "VERIFY_USER", length = 10)
    private String verifyUser;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "VERIFY_TIME")
    private Date verifyTime;

    @Column(name = "ENTITY_FLG", length = 1)
    private String entityFlg;

    @Column(name = "MODIFY_FLG", length = 1)
    private String modifyFlg;

    @Temporal(TemporalType.DATE)
    @Column(name = "REPORT_DATE")
    private Date reportDate;

    @Column(name = "BRANCH_CODE", length = 50)
    private String branchCode;

    @Column(name = "BRANCH_NAME", length = 50)
    private String branchName;

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	public Double getAmount1() {
		return amount1;
	}

	public void setAmount1(Double amount1) {
		this.amount1 = amount1;
	}

	public Double getAmount2() {
		return amount2;
	}

	public void setAmount2(Double amount2) {
		this.amount2 = amount2;
	}

	public Double getRateOrPrice() {
		return rateOrPrice;
	}

	public void setRateOrPrice(Double rateOrPrice) {
		this.rateOrPrice = rateOrPrice;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public String getCounterpartyCode() {
		return counterpartyCode;
	}

	public void setCounterpartyCode(String counterpartyCode) {
		this.counterpartyCode = counterpartyCode;
	}

	public String getCounterpartyName() {
		return counterpartyName;
	}

	public void setCounterpartyName(String counterpartyName) {
		this.counterpartyName = counterpartyName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getResidualMaturity() {
		return residualMaturity;
	}

	public void setResidualMaturity(Integer residualMaturity) {
		this.residualMaturity = residualMaturity;
	}

	public String getCcf() {
		return ccf;
	}

	public void setCcf(String ccf) {
		this.ccf = ccf;
	}

	public Double getCcfAmount() {
		return ccfAmount;
	}

	public void setCcfAmount(Double ccfAmount) {
		this.ccfAmount = ccfAmount;
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

    // Getters and setters...
    
}
