package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "RT_MID_FX_DEAL")
public class RT_MID_FX_DEAL_DC {

	@Id
	@Column(name = "SRL_NO")
	private String srlNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "REPORT_DATE")
	private Date reportDate;

	// --- ACTUAL VALUES (INR) ---
	@Column(name = "ACTUAL_BONDS")
	private BigDecimal actualBonds;

	@Column(name = "ACTUAL_FX_SWAPS")
	private BigDecimal actualFxSwaps;

	@Column(name = "ACTUAL_OUTRIGHT_FORWARDS")
	private BigDecimal actualOutrightForwards;

	@Column(name = "ACTUAL_IRS_CIRS")
	private BigDecimal actualIrsCirs;
	
	// --- ACTUAL VALUES (INR) ---
	@Column(name = "ACTUAL_BONDS_MOD")
	private BigDecimal actualBondsmod;

	@Column(name = "ACTUAL_FX_SWAPS_MOD")
	private BigDecimal actualFxSwapsmod;

	@Column(name = "ACTUAL_OUTRIGHT_FORWARDS_MOD")
	private BigDecimal actualOutrightForwardsmod;

	@Column(name = "ACTUAL_IRS_CIRS_MOD")
	private BigDecimal actualIrsCirsmod;

	// --- ABSOLUTE VALUES (INR) ---
	@Column(name = "ABS_BONDS")
	private BigDecimal absBonds;

	@Column(name = "ABS_FX_SWAPS")
	private BigDecimal absFxSwaps;

	@Column(name = "ABS_OUTRIGHT_FORWARDS")
	private BigDecimal absOutrightForwards;

	@Column(name = "ABS_IRS_CIRS")
	private BigDecimal absIrsCirs;

	// --- AED VALUES ---
	@Column(name = "AED_FOREX")
	private BigDecimal aedForex;

	@Column(name = "AED_INT_RATE")
	private BigDecimal aedIntRate;

	@Column(name = "AED_INVEST_BONDS")
	private BigDecimal aedInvestBonds;

	@Column(name = "AED_MONEY_MARKET_CP_CD")
	private BigDecimal aedMoneyMarketCpCd;

	@Column(name = "AED_TOTAL_PV01")
	private BigDecimal aedTotalPv01;

	// --- AUDIT & METADATA FIELDS ---
	@Column(name = "DEL_FLG")
	private String delFlg;

	@Column(name = "RCRE_USER_ID")
	private String rcreUserId;

	@Temporal(TemporalType.DATE)
	@Column(name = "REPORT_FROM_DATE")
	private Date reportFromDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "REPORT_TO_DATE")
	private Date reportToDate;

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

	@Temporal(TemporalType.TIMESTAMP)
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

	public BigDecimal getActualBonds() {
		return actualBonds;
	}

	public void setActualBonds(BigDecimal actualBonds) {
		this.actualBonds = actualBonds;
	}

	public BigDecimal getActualFxSwaps() {
		return actualFxSwaps;
	}

	public void setActualFxSwaps(BigDecimal actualFxSwaps) {
		this.actualFxSwaps = actualFxSwaps;
	}

	public BigDecimal getActualOutrightForwards() {
		return actualOutrightForwards;
	}

	public void setActualOutrightForwards(BigDecimal actualOutrightForwards) {
		this.actualOutrightForwards = actualOutrightForwards;
	}

	public BigDecimal getActualIrsCirs() {
		return actualIrsCirs;
	}

	public void setActualIrsCirs(BigDecimal actualIrsCirs) {
		this.actualIrsCirs = actualIrsCirs;
	}

	public BigDecimal getAbsBonds() {
		return absBonds;
	}

	public void setAbsBonds(BigDecimal absBonds) {
		this.absBonds = absBonds;
	}

	public BigDecimal getAbsFxSwaps() {
		return absFxSwaps;
	}

	public void setAbsFxSwaps(BigDecimal absFxSwaps) {
		this.absFxSwaps = absFxSwaps;
	}

	public BigDecimal getAbsOutrightForwards() {
		return absOutrightForwards;
	}

	public void setAbsOutrightForwards(BigDecimal absOutrightForwards) {
		this.absOutrightForwards = absOutrightForwards;
	}

	public BigDecimal getAbsIrsCirs() {
		return absIrsCirs;
	}

	public void setAbsIrsCirs(BigDecimal absIrsCirs) {
		this.absIrsCirs = absIrsCirs;
	}

	public BigDecimal getAedForex() {
		return aedForex;
	}

	public void setAedForex(BigDecimal aedForex) {
		this.aedForex = aedForex;
	}

	public BigDecimal getAedIntRate() {
		return aedIntRate;
	}

	public void setAedIntRate(BigDecimal aedIntRate) {
		this.aedIntRate = aedIntRate;
	}

	public BigDecimal getAedInvestBonds() {
		return aedInvestBonds;
	}

	public void setAedInvestBonds(BigDecimal aedInvestBonds) {
		this.aedInvestBonds = aedInvestBonds;
	}

	public BigDecimal getAedMoneyMarketCpCd() {
		return aedMoneyMarketCpCd;
	}

	public void setAedMoneyMarketCpCd(BigDecimal aedMoneyMarketCpCd) {
		this.aedMoneyMarketCpCd = aedMoneyMarketCpCd;
	}

	public BigDecimal getAedTotalPv01() {
		return aedTotalPv01;
	}

	public void setAedTotalPv01(BigDecimal aedTotalPv01) {
		this.aedTotalPv01 = aedTotalPv01;
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

	public Date getRcreTime() {
		return rcreTime;
	}

	public void setRcreTime(Date rcreTime) {
		this.rcreTime = rcreTime;
	}
	
	

	public BigDecimal getActualBondsmod() {
		return actualBondsmod;
	}

	public void setActualBondsmod(BigDecimal actualBondsmod) {
		this.actualBondsmod = actualBondsmod;
	}

	public BigDecimal getActualFxSwapsmod() {
		return actualFxSwapsmod;
	}

	public void setActualFxSwapsmod(BigDecimal actualFxSwapsmod) {
		this.actualFxSwapsmod = actualFxSwapsmod;
	}

	public BigDecimal getActualOutrightForwardsmod() {
		return actualOutrightForwardsmod;
	}

	public void setActualOutrightForwardsmod(BigDecimal actualOutrightForwardsmod) {
		this.actualOutrightForwardsmod = actualOutrightForwardsmod;
	}

	public BigDecimal getActualIrsCirsmod() {
		return actualIrsCirsmod;
	}

	public void setActualIrsCirsmod(BigDecimal actualIrsCirsmod) {
		this.actualIrsCirsmod = actualIrsCirsmod;
	}

	public RT_MID_FX_DEAL_DC() {
		super();
		// TODO Auto-generated constructor stub
	}

}
