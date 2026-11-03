package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Limit_Request")
public class Limit_Request_Entity {

	 	@Id
	    private BigDecimal SRL_NO;

	    @Column(name = "REQUEST_TYPE")
	    private String requestType;

	    @Column(name = "BRANCH")
	    private String branch;

	    @Column(name = "BANK_NAME")
	    private String bankName;

	    @Column(name = "TOTAL_LIMIT")
	    private BigDecimal totalLimit;

	    @Column(name = "AVAILABLE_LIMIT")
	    private BigDecimal availableLimit;

	    @Column(name = "PROPOSED_AMT")
	    private BigDecimal proposedAmt;

	    @Column(name = "TENURE_IN_MONTHS")
	    private BigDecimal tenureInMonths;

	    @Column(name = "RATE_APPROVED")
	    private BigDecimal rateApproved;

	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    @Column(name = "EXECUTION_DATE")
	    private Date executionDate;
	    
	    @Column(name = "CREATEUSER")
	    private String createuser;
	    
	    @Column(name = "CREATEDATE")
	    private Date createdate;
	    
	    @Column(name = "DEL_FLG")
	    private String delFlg;

		public BigDecimal getSRL_NO() {
			return SRL_NO;
		}

		public void setSRL_NO(BigDecimal sRL_NO) {
			SRL_NO = sRL_NO;
		}

		public String getRequestType() {
			return requestType;
		}

		public void setRequestType(String requestType) {
			this.requestType = requestType;
		}

		public String getBranch() {
			return branch;
		}

		public void setBranch(String branch) {
			this.branch = branch;
		}

		public String getBankName() {
			return bankName;
		}

		public void setBankName(String bankName) {
			this.bankName = bankName;
		}

		public BigDecimal getTotalLimit() {
			return totalLimit;
		}

		public void setTotalLimit(BigDecimal totalLimit) {
			this.totalLimit = totalLimit;
		}

		public BigDecimal getAvailableLimit() {
			return availableLimit;
		}

		public void setAvailableLimit(BigDecimal availableLimit) {
			this.availableLimit = availableLimit;
		}

		public BigDecimal getProposedAmt() {
			return proposedAmt;
		}

		public void setProposedAmt(BigDecimal proposedAmt) {
			this.proposedAmt = proposedAmt;
		}

		public BigDecimal getTenureInMonths() {
			return tenureInMonths;
		}

		public void setTenureInMonths(BigDecimal tenureInMonths) {
			this.tenureInMonths = tenureInMonths;
		}

		public BigDecimal getRateApproved() {
			return rateApproved;
		}

		public void setRateApproved(BigDecimal rateApproved) {
			this.rateApproved = rateApproved;
		}

		public Date getExecutionDate() {
			return executionDate;
		}

		public void setExecutionDate(Date executionDate) {
			this.executionDate = executionDate;
		}

		public String getCreateuser() {
			return createuser;
		}

		public void setCreateuser(String createuser) {
			this.createuser = createuser;
		}

		public Date getCreatedate() {
			return createdate;
		}

		public void setCreatedate(Date createdate) {
			this.createdate = createdate;
		}

		public String getDelFlg() {
			return delFlg;
		}

		public void setDelFlg(String delFlg) {
			this.delFlg = delFlg;
		}

		public Limit_Request_Entity(BigDecimal sRL_NO, String requestType, String branch, String bankName,
				BigDecimal totalLimit, BigDecimal availableLimit, BigDecimal proposedAmt, BigDecimal tenureInMonths,
				BigDecimal rateApproved, Date executionDate, String createuser, Date createdate, String delFlg) {
			super();
			SRL_NO = sRL_NO;
			this.requestType = requestType;
			this.branch = branch;
			this.bankName = bankName;
			this.totalLimit = totalLimit;
			this.availableLimit = availableLimit;
			this.proposedAmt = proposedAmt;
			this.tenureInMonths = tenureInMonths;
			this.rateApproved = rateApproved;
			this.executionDate = executionDate;
			this.createuser = createuser;
			this.createdate = createdate;
			this.delFlg = delFlg;
		}

		public Limit_Request_Entity() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
	    

}
