package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@IdClass(BRF_SMA_MASTER_DATA_id.class)
@Table(name = "BRF_SMA_MASTER_DATA_TABLE") 
public class BRF_SMA_MASTER_DATA_Entity {

	    @Id
	    @Column(name = "ACCOUNT_NO")
	    private String accountNo;

	    @Column(name = "TERRITORY")
	    private String territory;

	    @Column(name = "BRANCH")
	    private String branch;

	    @Column(name = "SOL_ID")
	    private String solId;

	    @Column(name = "CUSTOMER_ID")
	    private String customerId;

	    @Column(name = "ACCOUNT_NAME")
	    private String accountName;

	    @Column(name = "BILL_ID")
	    private String billId;

	    @Column(name = "SCHEME_CODE")
	    private String schemeCode;

	    @Column(name = "GL_SUB_HEAD")
	    private String glSubHead;

	    @Column(name = "ACCOUNT_CCY")
	    private String accountCcy;

	    @Column(name = "CLEAR_BAL_AMT")
	    private BigDecimal clearBalAmt;

	    @Column(name = "CREDIT_TURNOVER")
	    private BigDecimal creditTurnover;

	    @Column(name = "INT_CHARGES_AMT")
	    private BigDecimal intChargesAmt;

	    @JsonFormat(pattern = "yyyy-MM-dd")
	    @Column(name = "CONT_EXCESS_SINCE")
	    private Date contExcessSince;

	    @JsonFormat(pattern = "yyyy-MM-dd")
	    @Column(name = "OVERDUE__DUE_DATEFOR_BILLS__PC_DISB")
	    private Date overdueDueDate;

	    @Column(name = "TOTAL_OVERDUE")
	    private BigDecimal totalOverdue;

	    @Column(name = "SMA0")
	    private BigDecimal sma0;

	    @Column(name = "SMA1")
	    private BigDecimal sma1;

	    @Column(name = "SMA2")
	    private BigDecimal sma2;

	    @JsonFormat(pattern = "yyyy-MM-dd")
	    @Column(name = "REVIEW_DATE")
	    private Date reviewDate;

	    @JsonFormat(pattern = "yyyy-MM-dd")
	    @Column(name = "STKSTATMENT_DATE")
	    private Date stkStatementDate;

	    @Column(name = "REASON_FOR_DEGRADATION")
	    private String reasonForDegradation;

	    @Column(name = "CUSTOMER_WISE_OSBALANCE")
	    private BigDecimal customerWiseOsBalance;

	    @JsonFormat(pattern = "yyyy-MM-dd")
	    @Column(name = "NPA_DATE")
	    private Date npaDate;

	    @Column(name = "DPD")
	    private BigDecimal dpd;

	    @Id
	    @JsonFormat(pattern = "yyyy-MM-dd")
	    @Column(name = "AS_ON_DATE")
	    private Date asOnDate;

	    @Column(name = "PAN_NUMBER")
	    private String panNumber;

		public String getAccountNo() {
			return accountNo;
		}

		public void setAccountNo(String accountNo) {
			this.accountNo = accountNo;
		}

		public String getTerritory() {
			return territory;
		}

		public void setTerritory(String territory) {
			this.territory = territory;
		}

		public String getBranch() {
			return branch;
		}

		public void setBranch(String branch) {
			this.branch = branch;
		}

		public String getSolId() {
			return solId;
		}

		public void setSolId(String solId) {
			this.solId = solId;
		}

		public String getCustomerId() {
			return customerId;
		}

		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}

		public String getAccountName() {
			return accountName;
		}

		public void setAccountName(String accountName) {
			this.accountName = accountName;
		}

		public String getBillId() {
			return billId;
		}

		public void setBillId(String billId) {
			this.billId = billId;
		}

		public String getSchemeCode() {
			return schemeCode;
		}

		public void setSchemeCode(String schemeCode) {
			this.schemeCode = schemeCode;
		}

		public String getGlSubHead() {
			return glSubHead;
		}

		public void setGlSubHead(String glSubHead) {
			this.glSubHead = glSubHead;
		}

		public String getAccountCcy() {
			return accountCcy;
		}

		public void setAccountCcy(String accountCcy) {
			this.accountCcy = accountCcy;
		}

		public BigDecimal getClearBalAmt() {
			return clearBalAmt;
		}

		public void setClearBalAmt(BigDecimal clearBalAmt) {
			this.clearBalAmt = clearBalAmt;
		}

		public BigDecimal getCreditTurnover() {
			return creditTurnover;
		}

		public void setCreditTurnover(BigDecimal creditTurnover) {
			this.creditTurnover = creditTurnover;
		}

		public BigDecimal getIntChargesAmt() {
			return intChargesAmt;
		}

		public void setIntChargesAmt(BigDecimal intChargesAmt) {
			this.intChargesAmt = intChargesAmt;
		}

		public Date getContExcessSince() {
			return contExcessSince;
		}

		public void setContExcessSince(Date contExcessSince) {
			this.contExcessSince = contExcessSince;
		}

		public Date getOverdueDueDate() {
			return overdueDueDate;
		}

		public void setOverdueDueDate(Date overdueDueDate) {
			this.overdueDueDate = overdueDueDate;
		}

		public BigDecimal getTotalOverdue() {
			return totalOverdue;
		}

		public void setTotalOverdue(BigDecimal totalOverdue) {
			this.totalOverdue = totalOverdue;
		}

		public BigDecimal getSma0() {
			return sma0;
		}

		public void setSma0(BigDecimal sma0) {
			this.sma0 = sma0;
		}

		public BigDecimal getSma1() {
			return sma1;
		}

		public void setSma1(BigDecimal sma1) {
			this.sma1 = sma1;
		}

		public BigDecimal getSma2() {
			return sma2;
		}

		public void setSma2(BigDecimal sma2) {
			this.sma2 = sma2;
		}

		public Date getReviewDate() {
			return reviewDate;
		}

		public void setReviewDate(Date reviewDate) {
			this.reviewDate = reviewDate;
		}

		public Date getStkStatementDate() {
			return stkStatementDate;
		}

		public void setStkStatementDate(Date stkStatementDate) {
			this.stkStatementDate = stkStatementDate;
		}

		public String getReasonForDegradation() {
			return reasonForDegradation;
		}

		public void setReasonForDegradation(String reasonForDegradation) {
			this.reasonForDegradation = reasonForDegradation;
		}

		public BigDecimal getCustomerWiseOsBalance() {
			return customerWiseOsBalance;
		}

		public void setCustomerWiseOsBalance(BigDecimal customerWiseOsBalance) {
			this.customerWiseOsBalance = customerWiseOsBalance;
		}

		public Date getNpaDate() {
			return npaDate;
		}

		public void setNpaDate(Date npaDate) {
			this.npaDate = npaDate;
		}

		public BigDecimal getDpd() {
			return dpd;
		}

		public void setDpd(BigDecimal dpd) {
			this.dpd = dpd;
		}

		public Date getAsOnDate() {
			return asOnDate;
		}

		public void setAsOnDate(Date asOnDate) {
			this.asOnDate = asOnDate;
		}

		public String getPanNumber() {
			return panNumber;
		}

		public void setPanNumber(String panNumber) {
			this.panNumber = panNumber;
		}

		public BRF_SMA_MASTER_DATA_Entity(String accountNo, String territory, String branch, String solId,
				String customerId, String accountName, String billId, String schemeCode, String glSubHead,
				String accountCcy, BigDecimal clearBalAmt, BigDecimal creditTurnover, BigDecimal intChargesAmt,
				Date contExcessSince, Date overdueDueDate, BigDecimal totalOverdue, BigDecimal sma0, BigDecimal sma1,
				BigDecimal sma2, Date reviewDate, Date stkStatementDate, String reasonForDegradation,
				BigDecimal customerWiseOsBalance, Date npaDate, BigDecimal dpd, Date asOnDate, String panNumber) {
			super();
			this.accountNo = accountNo;
			this.territory = territory;
			this.branch = branch;
			this.solId = solId;
			this.customerId = customerId;
			this.accountName = accountName;
			this.billId = billId;
			this.schemeCode = schemeCode;
			this.glSubHead = glSubHead;
			this.accountCcy = accountCcy;
			this.clearBalAmt = clearBalAmt;
			this.creditTurnover = creditTurnover;
			this.intChargesAmt = intChargesAmt;
			this.contExcessSince = contExcessSince;
			this.overdueDueDate = overdueDueDate;
			this.totalOverdue = totalOverdue;
			this.sma0 = sma0;
			this.sma1 = sma1;
			this.sma2 = sma2;
			this.reviewDate = reviewDate;
			this.stkStatementDate = stkStatementDate;
			this.reasonForDegradation = reasonForDegradation;
			this.customerWiseOsBalance = customerWiseOsBalance;
			this.npaDate = npaDate;
			this.dpd = dpd;
			this.asOnDate = asOnDate;
			this.panNumber = panNumber;
		}

		public BRF_SMA_MASTER_DATA_Entity() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    

	    
}
