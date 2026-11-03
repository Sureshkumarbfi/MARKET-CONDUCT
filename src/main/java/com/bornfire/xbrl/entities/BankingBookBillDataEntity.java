package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BANKING_BOOK_BILL_DATA")
@IdClass(BankingBookBillDataId.class)
public class BankingBookBillDataEntity {

	@Id
	@Column(name = "BILL_ID")
	private String billId;

	@Column(name = "BILL_AMT")
	private BigDecimal billAmt;

	@Column(name = "BILL_CNTRY_CODE")
	private String billCntryCode;

	@Column(name = "BILL_CRNCY_CODE")
	private String billCrncyCode;

	@Column(name = "BILL_LIAB")
	private String billLiab;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "DUE_DATE")
	private Date dueDate;

	@Column(name = "FORACID")
	private String foracid;

	@Column(name = "ACID")
	private String acid;

	@Id
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "REPORT_DATE")
	private Date reportDate;

	@Column(name = "BILL_RMV_FLG")
	private String billRmvFlg;

	@Column(name = "BILL_ADJ_FLG")
	private String billAdjFlg;

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public BigDecimal getBillAmt() {
		return billAmt;
	}

	public void setBillAmt(BigDecimal billAmt) {
		this.billAmt = billAmt;
	}

	public String getBillCntryCode() {
		return billCntryCode;
	}

	public void setBillCntryCode(String billCntryCode) {
		this.billCntryCode = billCntryCode;
	}

	public String getBillCrncyCode() {
		return billCrncyCode;
	}

	public void setBillCrncyCode(String billCrncyCode) {
		this.billCrncyCode = billCrncyCode;
	}

	public String getBillLiab() {
		return billLiab;
	}

	public void setBillLiab(String billLiab) {
		this.billLiab = billLiab;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getForacid() {
		return foracid;
	}

	public void setForacid(String foracid) {
		this.foracid = foracid;
	}

	public String getAcid() {
		return acid;
	}

	public void setAcid(String acid) {
		this.acid = acid;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getBillRmvFlg() {
		return billRmvFlg;
	}

	public void setBillRmvFlg(String billRmvFlg) {
		this.billRmvFlg = billRmvFlg;
	}

	public String getBillAdjFlg() {
		return billAdjFlg;
	}

	public void setBillAdjFlg(String billAdjFlg) {
		this.billAdjFlg = billAdjFlg;
	}
}
