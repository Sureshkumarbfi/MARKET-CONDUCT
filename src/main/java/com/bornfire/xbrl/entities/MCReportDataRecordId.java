package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class MCReportDataRecordId implements Serializable {

	private String formMode;
	private Date reportDate;
	private String cellName;
	private String timeperiod;

	public String getFormMode() {
		return formMode;
	}

	public void setFormMode(String formMode) {
		this.formMode = formMode;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getCellName() {
		return cellName;
	}

	public void setCellName(String cellName) {
		this.cellName = cellName;
	}

	public String getTimeperiod() {
		return timeperiod;
	}

	public void setTimeperiod(String timeperiod) {
		this.timeperiod = timeperiod;
	}

}
