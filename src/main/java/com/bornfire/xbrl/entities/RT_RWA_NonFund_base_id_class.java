package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class RT_RWA_NonFund_base_id_class implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date report_date;
	private String lcbg_id;

	public RT_RWA_NonFund_base_id_class() {
		super();
	}

	public RT_RWA_NonFund_base_id_class(Date report_date, String lcbg_id) {
		super();
		this.report_date = report_date;
		this.lcbg_id = lcbg_id;
	}

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public String getLcbg_id() {
		return lcbg_id;
	}

	public void setLcbg_id(String lcbg_id) {
		this.lcbg_id = lcbg_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lcbg_id, report_date);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		RT_RWA_NonFund_base_id_class other = (RT_RWA_NonFund_base_id_class) obj;
		return Objects.equals(lcbg_id, other.lcbg_id) && Objects.equals(report_date, other.report_date);
	}
}