package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Maps {@code RT_OVERNIGHT_FOREIGN_CCY_DATA}. Natural key: report date + currency.
 */
@Entity
@Table(name = "RT_OVERNIGHT_FOREIGN_CCY_DATA")
@IdClass(RT_Overnight_Foreign_Ccy_Data_Id.class)
public class RT_Overnight_Foreign_Ccy_Data_Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Temporal(TemporalType.DATE)
	@Column(name = "REPORT_DATE", nullable = false)
	private Date report_date;

	@Id
	@Column(name = "CURRENCY", nullable = false, length = 3)
	private String currency;

	@Column(name = "CLOSING_POSITION", precision = 24, scale = 4)
	private BigDecimal closing_position;

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getClosing_position() {
		return closing_position;
	}

	public void setClosing_position(BigDecimal closing_position) {
		this.closing_position = closing_position;
	}
}
