package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Embeddable;
@Embeddable
public class Forward_reveal_manual_id implements Serializable {

	private BigDecimal	num_operation;
	private Date	report_date;
	
	public BigDecimal getNum_operation() {
		return num_operation;
	}
	public void setNum_operation(BigDecimal num_operation) {
		this.num_operation = num_operation;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	
	
	
}
