package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RT_ACPR_SECURED_UNSECURED")
public class Rt_AcprSecuredUnsecuredEntity {
	@Id
    @Column(name = "REPORT_DATE")
    private Date reportDate;

    @Column(name = "SECURED_FB")
    private BigDecimal securedFb;

    @Column(name = "SECURED_NFB")
    private BigDecimal securedNfb;

    @Column(name = "TOTAL_SECURED")
    private BigDecimal totalSecured;

    @Column(name = "SECURED_OTHER_BANK_FB")
    private BigDecimal securedOtherBankFb;

    @Column(name = "SECURED_OTHER_BANK_NFB")
    private BigDecimal securedOtherBankNfb;

    @Column(name = "TOTAL_SECURED_OTHER_BANK")
    private BigDecimal totalSecuredOtherBank;

    @Column(name = "INTEREST_SUSPENSE_FB")
    private BigDecimal interestSuspenseFb;

    @Column(name = "INTEREST_SUSPENSE_NFB")
    private BigDecimal interestSuspenseNfb;

    @Column(name = "TOTAL_INTEREST_SUSPENSE")
    private BigDecimal totalInterestSuspense;

    @Column(name = "PROVISION_FB")
    private BigDecimal provisionFb;

    @Column(name = "PROVISION_NFB")
    private BigDecimal provisionNfb;

    @Column(name = "TOTAL_PROVISION")
    private BigDecimal totalProvision;

    @Column(name = "UNSECURED_FB")
    private BigDecimal unsecuredFb;

    @Column(name = "UNSECURED_NFB")
    private BigDecimal unsecuredNfb;

    @Column(name = "TOTAL_UNSECURED")
    private BigDecimal totalUnsecured;

    @Column(name = "BALANCE_FB")
    private BigDecimal balanceFb;

    @Column(name = "BALANCE_NFB")
    private BigDecimal balanceNfb;

    @Column(name = "TOTAL_ADVANCES")
    private BigDecimal totalAdvances;

    @Column(name = "TOTAL_FB_NFB")
    private BigDecimal totalFbNfb;

    @Column(name = "TOTAL_RATIO")
    private BigDecimal totalRatio;

    @Column(name = "UNSECURED_CAP_TA")
    private BigDecimal unsecuredCapTa;

    @Column(name = "HEADROOM_AVAILABLE_AED")
    private BigDecimal headroomAvailableAed;

    @Column(name = "HEADROOM_AVAILABLE_USD")
    private BigDecimal headroomAvailableUsd;

    @Column(name = "DEL_FLG")
    private String delFlg;

    @Column(name = "CREATE_USER")
    private String createUser;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "MODIFY_USER")
    private String modifyUser;

    @Column(name = "MODIFY_TIME")
    private Date modifyTime;

    @Column(name = "VERIFY_USER")
    private String verifyUser;

    @Column(name = "VERIFY_TIME")
    private Date verifyTime;

    @Column(name = "ENTITY_FLG")
    private String entityFlg;

    @Column(name = "MODIFY_FLG")
    private String modifyFlg;

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public BigDecimal getSecuredFb() {
		return securedFb;
	}

	public void setSecuredFb(BigDecimal securedFb) {
		this.securedFb = securedFb;
	}

	public BigDecimal getSecuredNfb() {
		return securedNfb;
	}

	public void setSecuredNfb(BigDecimal securedNfb) {
		this.securedNfb = securedNfb;
	}

	public BigDecimal getTotalSecured() {
		return totalSecured;
	}

	public void setTotalSecured(BigDecimal totalSecured) {
		this.totalSecured = totalSecured;
	}

	public BigDecimal getSecuredOtherBankFb() {
		return securedOtherBankFb;
	}

	public void setSecuredOtherBankFb(BigDecimal securedOtherBankFb) {
		this.securedOtherBankFb = securedOtherBankFb;
	}

	public BigDecimal getSecuredOtherBankNfb() {
		return securedOtherBankNfb;
	}

	public void setSecuredOtherBankNfb(BigDecimal securedOtherBankNfb) {
		this.securedOtherBankNfb = securedOtherBankNfb;
	}

	public BigDecimal getTotalSecuredOtherBank() {
		return totalSecuredOtherBank;
	}

	public void setTotalSecuredOtherBank(BigDecimal totalSecuredOtherBank) {
		this.totalSecuredOtherBank = totalSecuredOtherBank;
	}

	public BigDecimal getInterestSuspenseFb() {
		return interestSuspenseFb;
	}

	public void setInterestSuspenseFb(BigDecimal interestSuspenseFb) {
		this.interestSuspenseFb = interestSuspenseFb;
	}

	public BigDecimal getInterestSuspenseNfb() {
		return interestSuspenseNfb;
	}

	public void setInterestSuspenseNfb(BigDecimal interestSuspenseNfb) {
		this.interestSuspenseNfb = interestSuspenseNfb;
	}

	public BigDecimal getTotalInterestSuspense() {
		return totalInterestSuspense;
	}

	public void setTotalInterestSuspense(BigDecimal totalInterestSuspense) {
		this.totalInterestSuspense = totalInterestSuspense;
	}

	public BigDecimal getProvisionFb() {
		return provisionFb;
	}

	public void setProvisionFb(BigDecimal provisionFb) {
		this.provisionFb = provisionFb;
	}

	public BigDecimal getProvisionNfb() {
		return provisionNfb;
	}

	public void setProvisionNfb(BigDecimal provisionNfb) {
		this.provisionNfb = provisionNfb;
	}

	public BigDecimal getTotalProvision() {
		return totalProvision;
	}

	public void setTotalProvision(BigDecimal totalProvision) {
		this.totalProvision = totalProvision;
	}

	public BigDecimal getUnsecuredFb() {
		return unsecuredFb;
	}

	public void setUnsecuredFb(BigDecimal unsecuredFb) {
		this.unsecuredFb = unsecuredFb;
	}

	public BigDecimal getUnsecuredNfb() {
		return unsecuredNfb;
	}

	public void setUnsecuredNfb(BigDecimal unsecuredNfb) {
		this.unsecuredNfb = unsecuredNfb;
	}

	public BigDecimal getTotalUnsecured() {
		return totalUnsecured;
	}

	public void setTotalUnsecured(BigDecimal totalUnsecured) {
		this.totalUnsecured = totalUnsecured;
	}

	public BigDecimal getBalanceFb() {
		return balanceFb;
	}

	public void setBalanceFb(BigDecimal balanceFb) {
		this.balanceFb = balanceFb;
	}

	public BigDecimal getBalanceNfb() {
		return balanceNfb;
	}

	public void setBalanceNfb(BigDecimal balanceNfb) {
		this.balanceNfb = balanceNfb;
	}

	public BigDecimal getTotalAdvances() {
		return totalAdvances;
	}

	public void setTotalAdvances(BigDecimal totalAdvances) {
		this.totalAdvances = totalAdvances;
	}

	public BigDecimal getTotalFbNfb() {
		return totalFbNfb;
	}

	public void setTotalFbNfb(BigDecimal totalFbNfb) {
		this.totalFbNfb = totalFbNfb;
	}

	public BigDecimal getTotalRatio() {
		return totalRatio;
	}

	public void setTotalRatio(BigDecimal totalRatio) {
		this.totalRatio = totalRatio;
	}

	public BigDecimal getUnsecuredCapTa() {
		return unsecuredCapTa;
	}

	public void setUnsecuredCapTa(BigDecimal unsecuredCapTa) {
		this.unsecuredCapTa = unsecuredCapTa;
	}

	public BigDecimal getHeadroomAvailableAed() {
		return headroomAvailableAed;
	}

	public void setHeadroomAvailableAed(BigDecimal headroomAvailableAed) {
		this.headroomAvailableAed = headroomAvailableAed;
	}

	public BigDecimal getHeadroomAvailableUsd() {
		return headroomAvailableUsd;
	}

	public void setHeadroomAvailableUsd(BigDecimal headroomAvailableUsd) {
		this.headroomAvailableUsd = headroomAvailableUsd;
	}

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
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

	public Rt_AcprSecuredUnsecuredEntity(Date reportDate, BigDecimal securedFb, BigDecimal securedNfb,
			BigDecimal totalSecured, BigDecimal securedOtherBankFb, BigDecimal securedOtherBankNfb,
			BigDecimal totalSecuredOtherBank, BigDecimal interestSuspenseFb, BigDecimal interestSuspenseNfb,
			BigDecimal totalInterestSuspense, BigDecimal provisionFb, BigDecimal provisionNfb,
			BigDecimal totalProvision, BigDecimal unsecuredFb, BigDecimal unsecuredNfb, BigDecimal totalUnsecured,
			BigDecimal balanceFb, BigDecimal balanceNfb, BigDecimal totalAdvances, BigDecimal totalFbNfb,
			BigDecimal totalRatio, BigDecimal unsecuredCapTa, BigDecimal headroomAvailableAed,
			BigDecimal headroomAvailableUsd, String delFlg, String createUser, Date createTime, String modifyUser,
			Date modifyTime, String verifyUser, Date verifyTime, String entityFlg, String modifyFlg) {
		super();
		this.reportDate = reportDate;
		this.securedFb = securedFb;
		this.securedNfb = securedNfb;
		this.totalSecured = totalSecured;
		this.securedOtherBankFb = securedOtherBankFb;
		this.securedOtherBankNfb = securedOtherBankNfb;
		this.totalSecuredOtherBank = totalSecuredOtherBank;
		this.interestSuspenseFb = interestSuspenseFb;
		this.interestSuspenseNfb = interestSuspenseNfb;
		this.totalInterestSuspense = totalInterestSuspense;
		this.provisionFb = provisionFb;
		this.provisionNfb = provisionNfb;
		this.totalProvision = totalProvision;
		this.unsecuredFb = unsecuredFb;
		this.unsecuredNfb = unsecuredNfb;
		this.totalUnsecured = totalUnsecured;
		this.balanceFb = balanceFb;
		this.balanceNfb = balanceNfb;
		this.totalAdvances = totalAdvances;
		this.totalFbNfb = totalFbNfb;
		this.totalRatio = totalRatio;
		this.unsecuredCapTa = unsecuredCapTa;
		this.headroomAvailableAed = headroomAvailableAed;
		this.headroomAvailableUsd = headroomAvailableUsd;
		this.delFlg = delFlg;
		this.createUser = createUser;
		this.createTime = createTime;
		this.modifyUser = modifyUser;
		this.modifyTime = modifyTime;
		this.verifyUser = verifyUser;
		this.verifyTime = verifyTime;
		this.entityFlg = entityFlg;
		this.modifyFlg = modifyFlg;
	}

	public Rt_AcprSecuredUnsecuredEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    
}
