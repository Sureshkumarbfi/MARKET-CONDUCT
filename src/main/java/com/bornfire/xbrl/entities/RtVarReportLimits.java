package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "RT_VAR_REPORT_LIMITS")
public class RtVarReportLimits {
	
	@Column(name = "FOREX_LIMITS")
    private BigDecimal forexLimits;

    @Column(name = "INVESTMENTS_BONDS")
    private BigDecimal investmentsBonds;

    @Column(name = "INVESTMENT_EQUITY")
    private BigDecimal investmentEquity;

    @Column(name = "MONEY_MARKET")
    private BigDecimal moneyMarket;

    @Column(name = "DERIVATIVE_HFT")
    private BigDecimal derivativeHft;

    @Column(name = "TOTAL_VAR")
    private BigDecimal totalVar;

    @Id
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "REPORT_DATE")
    private Date reportDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "ENTRY_DATE")
    private Date entryDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "MODIFY_DATE")
    private Date modifyDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
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

	public BigDecimal getForexLimits() {
		return forexLimits;
	}

	public void setForexLimits(BigDecimal forexLimits) {
		this.forexLimits = forexLimits;
	}

	public BigDecimal getInvestmentsBonds() {
		return investmentsBonds;
	}

	public void setInvestmentsBonds(BigDecimal investmentsBonds) {
		this.investmentsBonds = investmentsBonds;
	}

	public BigDecimal getInvestmentEquity() {
		return investmentEquity;
	}

	public void setInvestmentEquity(BigDecimal investmentEquity) {
		this.investmentEquity = investmentEquity;
	}

	public BigDecimal getMoneyMarket() {
		return moneyMarket;
	}

	public void setMoneyMarket(BigDecimal moneyMarket) {
		this.moneyMarket = moneyMarket;
	}

	public BigDecimal getDerivativeHft() {
		return derivativeHft;
	}

	public void setDerivativeHft(BigDecimal derivativeHft) {
		this.derivativeHft = derivativeHft;
	}

	public BigDecimal getTotalVar() {
		return totalVar;
	}

	public void setTotalVar(BigDecimal totalVar) {
		this.totalVar = totalVar;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
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

	public RtVarReportLimits(BigDecimal forexLimits, BigDecimal investmentsBonds, BigDecimal investmentEquity,
			BigDecimal moneyMarket, BigDecimal derivativeHft, BigDecimal totalVar, Date reportDate, Date entryDate,
			Date modifyDate, Date verifyDate, String entryUser, String modifyUser, String verifyUser, String entryFlg,
			String modifyFlg, String verifyFlg, String delFlg) {
		super();
		this.forexLimits = forexLimits;
		this.investmentsBonds = investmentsBonds;
		this.investmentEquity = investmentEquity;
		this.moneyMarket = moneyMarket;
		this.derivativeHft = derivativeHft;
		this.totalVar = totalVar;
		this.reportDate = reportDate;
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
	}

	public RtVarReportLimits() {
		super();
	}
    
    
}


