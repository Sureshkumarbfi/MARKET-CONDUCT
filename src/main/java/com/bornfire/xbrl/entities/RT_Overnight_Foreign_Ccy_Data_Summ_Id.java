package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class RT_Overnight_Foreign_Ccy_Data_Summ_Id implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date report_date;

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RT_Overnight_Foreign_Ccy_Data_Summ_Id that = (RT_Overnight_Foreign_Ccy_Data_Summ_Id) o;
		return Objects.equals(report_date, that.report_date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(report_date);
	}
}
