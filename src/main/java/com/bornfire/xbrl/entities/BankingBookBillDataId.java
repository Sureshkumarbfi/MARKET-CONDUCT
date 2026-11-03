package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class BankingBookBillDataId implements Serializable {

	private static final long serialVersionUID = 1L;

	private String billId;
	private Date reportDate;

	public BankingBookBillDataId() {
	}

	public BankingBookBillDataId(String billId, Date reportDate) {
		this.billId = billId;
		this.reportDate = reportDate;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof BankingBookBillDataId)) {
			return false;
		}
		BankingBookBillDataId that = (BankingBookBillDataId) o;
		return Objects.equals(billId, that.billId) && Objects.equals(reportDate, that.reportDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(billId, reportDate);
	}
}
