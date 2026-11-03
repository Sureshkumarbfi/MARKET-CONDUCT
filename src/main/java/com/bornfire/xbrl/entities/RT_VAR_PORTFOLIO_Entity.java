package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "RT_VAR_PORTFOLIO_TABLE")
public class RT_VAR_PORTFOLIO_Entity {

    @Id
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date reportDate;
    private BigDecimal totalPortfolioLiqdnValue;
    private BigDecimal varOnForex;
    private BigDecimal varOnInvestmentsAfs;
    private BigDecimal varOnEquitiesAfs;
    private BigDecimal varOnMoneyMktAfs;
    private BigDecimal varOnEquitiesHft;
    private BigDecimal varOnPdHft;
    private BigDecimal varOnBkBondsHft;
    private BigDecimal varOnIrsCirsHft;
    private BigDecimal totalVar;
    private BigDecimal varPercentOfLiqdnValue;
    private String delFlg;
    private String entityFlg;
    private String modifyFlg;
    private String verifyFlg;
    private String entryUser;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date entryTime;
    private String verifyUser;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date verifyTime;
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public BigDecimal getTotalPortfolioLiqdnValue() {
		return totalPortfolioLiqdnValue;
	}
	public void setTotalPortfolioLiqdnValue(BigDecimal totalPortfolioLiqdnValue) {
		this.totalPortfolioLiqdnValue = totalPortfolioLiqdnValue;
	}
	public BigDecimal getVarOnForex() {
		return varOnForex;
	}
	public void setVarOnForex(BigDecimal varOnForex) {
		this.varOnForex = varOnForex;
	}
	public BigDecimal getVarOnInvestmentsAfs() {
		return varOnInvestmentsAfs;
	}
	public void setVarOnInvestmentsAfs(BigDecimal varOnInvestmentsAfs) {
		this.varOnInvestmentsAfs = varOnInvestmentsAfs;
	}
	public BigDecimal getVarOnEquitiesAfs() {
		return varOnEquitiesAfs;
	}
	public void setVarOnEquitiesAfs(BigDecimal varOnEquitiesAfs) {
		this.varOnEquitiesAfs = varOnEquitiesAfs;
	}
	public BigDecimal getVarOnMoneyMktAfs() {
		return varOnMoneyMktAfs;
	}
	public void setVarOnMoneyMktAfs(BigDecimal varOnMoneyMktAfs) {
		this.varOnMoneyMktAfs = varOnMoneyMktAfs;
	}
	public BigDecimal getVarOnEquitiesHft() {
		return varOnEquitiesHft;
	}
	public void setVarOnEquitiesHft(BigDecimal varOnEquitiesHft) {
		this.varOnEquitiesHft = varOnEquitiesHft;
	}
	public BigDecimal getVarOnPdHft() {
		return varOnPdHft;
	}
	public void setVarOnPdHft(BigDecimal varOnPdHft) {
		this.varOnPdHft = varOnPdHft;
	}
	public BigDecimal getVarOnBkBondsHft() {
		return varOnBkBondsHft;
	}
	public void setVarOnBkBondsHft(BigDecimal varOnBkBondsHft) {
		this.varOnBkBondsHft = varOnBkBondsHft;
	}
	public BigDecimal getVarOnIrsCirsHft() {
		return varOnIrsCirsHft;
	}
	public void setVarOnIrsCirsHft(BigDecimal varOnIrsCirsHft) {
		this.varOnIrsCirsHft = varOnIrsCirsHft;
	}
	public BigDecimal getTotalVar() {
		return totalVar;
	}
	public void setTotalVar(BigDecimal totalVar) {
		this.totalVar = totalVar;
	}
	public BigDecimal getVarPercentOfLiqdnValue() {
		return varPercentOfLiqdnValue;
	}
	public void setVarPercentOfLiqdnValue(BigDecimal varPercentOfLiqdnValue) {
		this.varPercentOfLiqdnValue = varPercentOfLiqdnValue;
	}
	public String getDelFlg() {
		return delFlg;
	}
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
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
	public String getVerifyFlg() {
		return verifyFlg;
	}
	public void setVerifyFlg(String verifyFlg) {
		this.verifyFlg = verifyFlg;
	}
	public String getEntryUser() {
		return entryUser;
	}
	public void setEntryUser(String entryUser) {
		this.entryUser = entryUser;
	}
	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
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
	public RT_VAR_PORTFOLIO_Entity(Date reportDate, BigDecimal totalPortfolioLiqdnValue, BigDecimal varOnForex,
			BigDecimal varOnInvestmentsAfs, BigDecimal varOnEquitiesAfs, BigDecimal varOnMoneyMktAfs,
			BigDecimal varOnEquitiesHft, BigDecimal varOnPdHft, BigDecimal varOnBkBondsHft, BigDecimal varOnIrsCirsHft,
			BigDecimal totalVar, BigDecimal varPercentOfLiqdnValue, String delFlg, String entityFlg, String modifyFlg,
			String verifyFlg, String entryUser, Date entryTime, String verifyUser, Date verifyTime) {
		super();
		this.reportDate = reportDate;
		this.totalPortfolioLiqdnValue = totalPortfolioLiqdnValue;
		this.varOnForex = varOnForex;
		this.varOnInvestmentsAfs = varOnInvestmentsAfs;
		this.varOnEquitiesAfs = varOnEquitiesAfs;
		this.varOnMoneyMktAfs = varOnMoneyMktAfs;
		this.varOnEquitiesHft = varOnEquitiesHft;
		this.varOnPdHft = varOnPdHft;
		this.varOnBkBondsHft = varOnBkBondsHft;
		this.varOnIrsCirsHft = varOnIrsCirsHft;
		this.totalVar = totalVar;
		this.varPercentOfLiqdnValue = varPercentOfLiqdnValue;
		this.delFlg = delFlg;
		this.entityFlg = entityFlg;
		this.modifyFlg = modifyFlg;
		this.verifyFlg = verifyFlg;
		this.entryUser = entryUser;
		this.entryTime = entryTime;
		this.verifyUser = verifyUser;
		this.verifyTime = verifyTime;
	}
	public RT_VAR_PORTFOLIO_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
 
    
}