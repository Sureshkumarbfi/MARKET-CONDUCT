package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "MIS_COUNTER_PARTY_ADHOC_LIMIT_DETAILS")
public class MIS_COUNTER_PARTY_LIMIT_DETAILS_ENTITY {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adhoc_detail_seq")
	@SequenceGenerator(name = "adhoc_detail_seq", sequenceName = "ADHOC_DETAIL_ID_SEQ", allocationSize = 1)
	private Long id;

	@Column(name = "SRL_NO")
	private String srlNo;

	@Column(name = "COUNTER_PARTY_BANK")
	private String counterPartyBank;

	@Column(name = "LIMIT_TYPE")
	private String limit_type;

	@Column(name = "ADHOC_LIMIT")
	private BigDecimal adhocLimit;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ADHOC_LIMIT_DATE")
	private Date adhocLimitDate;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ADHOC_LIMIT_EXP_DATE")
	private Date adhocLimitExpDate;

	@Column(name = "EAR_MARKING_LIMIT")
	private BigDecimal earMarkingLimit;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "EAR_MARKING_DATE")
	private Date earMarkingDate;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "ROLL_OVER")
	private String rollOver;

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
	@Column(name = "DEL_FLG")
	private String delFlg;

	@Column(name = "REPORT_DATE")
	private Date reportDate;
	@Column(name = "BRANCH_CODE")
	private String branchCode;
	@Column(name = "BRANCH_NAME")
	private String branchName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSrlNo() {
		return srlNo;
	}

	public void setSrlNo(String srlNo) {
		this.srlNo = srlNo;
	}

	public String getCounterPartyBank() {
		return counterPartyBank;
	}

	public void setCounterPartyBank(String counterPartyBank) {
		this.counterPartyBank = counterPartyBank;
	}

	public String getLimit_type() {
		return limit_type;
	}

	public void setLimit_type(String limit_type) {
		this.limit_type = limit_type;
	}

	public BigDecimal getAdhocLimit() {
		return adhocLimit;
	}

	public void setAdhocLimit(BigDecimal adhocLimit) {
		this.adhocLimit = adhocLimit;
	}

	public Date getAdhocLimitDate() {
		return adhocLimitDate;
	}

	public void setAdhocLimitDate(Date adhocLimitDate) {
		this.adhocLimitDate = adhocLimitDate;
	}

	public Date getAdhocLimitExpDate() {
		return adhocLimitExpDate;
	}

	public void setAdhocLimitExpDate(Date adhocLimitExpDate) {
		this.adhocLimitExpDate = adhocLimitExpDate;
	}

	public BigDecimal getEarMarkingLimit() {
		return earMarkingLimit;
	}

	public void setEarMarkingLimit(BigDecimal earMarkingLimit) {
		this.earMarkingLimit = earMarkingLimit;
	}

	public Date getEarMarkingDate() {
		return earMarkingDate;
	}

	public void setEarMarkingDate(Date earMarkingDate) {
		this.earMarkingDate = earMarkingDate;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getRollOver() {
		return rollOver;
	}

	public void setRollOver(String rollOver) {
		this.rollOver = rollOver;
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

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
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

	public MIS_COUNTER_PARTY_LIMIT_DETAILS_ENTITY(Long id, String srlNo, String counterPartyBank, String limit_type,
			BigDecimal adhocLimit, Date adhocLimitDate, Date adhocLimitExpDate, BigDecimal earMarkingLimit,
			Date earMarkingDate, String referenceNo, String rollOver, String createUser, Date createTime,
			String modifyUser, Date modifyTime, String verifyUser, Date verifyTime, String entityFlg, String modifyFlg,
			String delFlg, Date reportDate, String branchCode, String branchName) {
		super();
		this.id = id;
		this.srlNo = srlNo;
		this.counterPartyBank = counterPartyBank;
		this.limit_type = limit_type;
		this.adhocLimit = adhocLimit;
		this.adhocLimitDate = adhocLimitDate;
		this.adhocLimitExpDate = adhocLimitExpDate;
		this.earMarkingLimit = earMarkingLimit;
		this.earMarkingDate = earMarkingDate;
		this.referenceNo = referenceNo;
		this.rollOver = rollOver;
		this.createUser = createUser;
		this.createTime = createTime;
		this.modifyUser = modifyUser;
		this.modifyTime = modifyTime;
		this.verifyUser = verifyUser;
		this.verifyTime = verifyTime;
		this.entityFlg = entityFlg;
		this.modifyFlg = modifyFlg;
		this.delFlg = delFlg;
		this.reportDate = reportDate;
		this.branchCode = branchCode;
		this.branchName = branchName;
	}

	public MIS_COUNTER_PARTY_LIMIT_DETAILS_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}
