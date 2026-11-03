package com.bornfire.xbrl.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "RT_ACPRNF_TABLE")
public class RT_ACPRNF_ENTITY {
	@Id
	@Column(name = "SRL_NO")
	private String srlNo;

	@Column(name = "REPORT_DATE")
	private Date reportDate;

	@Column(name = "SOL_ID")
	private String solId;

	@Column(name = "LCBG_ID")
	private String lcbgId;

	@Column(name = "CURRENCY")
	private String currency;

	@Column(name = "ISSUE_DATE")
	private Date issueDate;

	@Column(name = "DUE_DATE")
	private Date dueDate;

	@Column(name = "LGBC_AMOUNT")
	private BigDecimal lgbcAmount;

	@Column(name = "OUTSTANDING_AMOUNT")
	private BigDecimal outstandingAmount;

	@Column(name = "ACCEPTED_AMOUNT")
	private BigDecimal acceptedAmount;

	@Column(name = "SECURED_TANGIBLE_ASSET")
	private BigDecimal securedTangibleAsset;

	@Column(name = "TOTAL_PROVISION")
	private BigDecimal totalProvision;

	@Column(name = "DEL_FLG")
	private String delFlg;

	@Column(name = "RCRE_USER_ID")
	private String rcreUserId;

	@Column(name = "REPORT_FROM_DATE")
	private Date reportFromDate;

	@Column(name = "REPORT_TO_DATE")
	private Date reportToDate;

	@Column(name = "CREATE_USER")
	private String createUser;

	@Column(name = "CREATE_TIME")
	private Date createTime;

	@Column(name = "ENTITY_FLG")
	private String entityFlg;

	@Column(name = "MODIFY_FLG")
	private String modifyFlg;

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

	public String getSolId() {
		return solId;
	}

	public void setSolId(String solId) {
		this.solId = solId;
	}

	public String getLcbgId() {
		return lcbgId;
	}

	public void setLcbgId(String lcbgId) {
		this.lcbgId = lcbgId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public BigDecimal getLgbcAmount() {
		return lgbcAmount;
	}

	public void setLgbcAmount(BigDecimal lgbcAmount) {
		this.lgbcAmount = lgbcAmount;
	}

	public BigDecimal getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(BigDecimal outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public BigDecimal getAcceptedAmount() {
		return acceptedAmount;
	}

	public void setAcceptedAmount(BigDecimal acceptedAmount) {
		this.acceptedAmount = acceptedAmount;
	}

	public BigDecimal getSecuredTangibleAsset() {
		return securedTangibleAsset;
	}

	public void setSecuredTangibleAsset(BigDecimal securedTangibleAsset) {
		this.securedTangibleAsset = securedTangibleAsset;
	}

	public BigDecimal getTotalProvision() {
		return totalProvision;
	}

	public void setTotalProvision(BigDecimal totalProvision) {
		this.totalProvision = totalProvision;
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

	public RT_ACPRNF_ENTITY(String srlNo, Date reportDate, String solId, String lcbgId, String currency, Date issueDate,
			Date dueDate, BigDecimal lgbcAmount, BigDecimal outstandingAmount, BigDecimal acceptedAmount,
			BigDecimal securedTangibleAsset, BigDecimal totalProvision, String delFlg, String rcreUserId,
			Date reportFromDate, Date reportToDate, String createUser, Date createTime, String entityFlg,
			String modifyFlg, Date rcreTime) {
		super();
		this.srlNo = srlNo;
		this.reportDate = reportDate;
		this.solId = solId;
		this.lcbgId = lcbgId;
		this.currency = currency;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.lgbcAmount = lgbcAmount;
		this.outstandingAmount = outstandingAmount;
		this.acceptedAmount = acceptedAmount;
		this.securedTangibleAsset = securedTangibleAsset;
		this.totalProvision = totalProvision;
		this.delFlg = delFlg;
		this.rcreUserId = rcreUserId;
		this.reportFromDate = reportFromDate;
		this.reportToDate = reportToDate;
		this.createUser = createUser;
		this.createTime = createTime;
		this.entityFlg = entityFlg;
		this.modifyFlg = modifyFlg;
		this.rcreTime = rcreTime;
	}

	@Override
	public String toString() {
		return "RT_ACPRNF_ENTITY [srlNo=" + srlNo + ", reportDate=" + reportDate + ", solId=" + solId + ", lcbgId="
				+ lcbgId + ", currency=" + currency + ", issueDate=" + issueDate + ", dueDate=" + dueDate
				+ ", lgbcAmount=" + lgbcAmount + ", outstandingAmount=" + outstandingAmount + ", acceptedAmount="
				+ acceptedAmount + ", securedTangibleAsset=" + securedTangibleAsset + ", totalProvision="
				+ totalProvision + ", delFlg=" + delFlg + ", rcreUserId=" + rcreUserId + ", reportFromDate="
				+ reportFromDate + ", reportToDate=" + reportToDate + ", createUser=" + createUser + ", createTime="
				+ createTime + ", entityFlg=" + entityFlg + ", modifyFlg=" + modifyFlg + ", rcreTime=" + rcreTime
				+ ", getSrlNo()=" + getSrlNo() + ", getReportDate()=" + getReportDate() + ", getSolId()=" + getSolId()
				+ ", getLcbgId()=" + getLcbgId() + ", getCurrency()=" + getCurrency() + ", getIssueDate()="
				+ getIssueDate() + ", getDueDate()=" + getDueDate() + ", getLgbcAmount()=" + getLgbcAmount()
				+ ", getOutstandingAmount()=" + getOutstandingAmount() + ", getAcceptedAmount()=" + getAcceptedAmount()
				+ ", getSecuredTangibleAsset()=" + getSecuredTangibleAsset() + ", getTotalProvision()="
				+ getTotalProvision() + ", getDelFlg()=" + getDelFlg() + ", getRcreUserId()=" + getRcreUserId()
				+ ", getReportFromDate()=" + getReportFromDate() + ", getReportToDate()=" + getReportToDate()
				+ ", getCreateUser()=" + getCreateUser() + ", getCreateTime()=" + getCreateTime() + ", getEntityFlg()="
				+ getEntityFlg() + ", getModifyFlg()=" + getModifyFlg() + ", getRcreTime()=" + getRcreTime()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public RT_ACPRNF_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}