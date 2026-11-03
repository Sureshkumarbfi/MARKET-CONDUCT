package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
@Embeddable
public class MIS_Treasury_placement_id_class implements Serializable {
	
	
	private String	num_operation;
	private Date	report_date;
	public String getNum_operation() {
		return num_operation;
	}
	public void setNum_operation(String num_operation) {
		this.num_operation = num_operation;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	
	

}
