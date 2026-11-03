package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.util.Date;

public class RT_Nostro_IdClass implements Serializable {

	private String accountNo;
	private Date reportDate;

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

}