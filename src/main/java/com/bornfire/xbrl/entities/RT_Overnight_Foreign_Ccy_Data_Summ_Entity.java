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
 * Maps {@code RT_OVERNIGHT_FOREIGN_CCY_DATA_SUMM}. Natural key: one row per report date.
 */
@Entity
@Table(name = "RT_OVERNIGHT_FOREIGN_CCY_DATA_SUMM")
@IdClass(RT_Overnight_Foreign_Ccy_Data_Summ_Id.class)
public class RT_Overnight_Foreign_Ccy_Data_Summ_Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Temporal(TemporalType.DATE)
	@Column(name = "REPORT_DATE", nullable = false)
	private Date report_date;

	@Column(name = "ONFC_OVER_BOUGHT", precision = 24, scale = 4)
	private BigDecimal onfc_over_bought;

	@Column(name = "ONFC_OVER_SOLD", precision = 24, scale = 4)
	private BigDecimal onfc_over_sold;

	@Column(name = "NOOP_OVER_BOUGHT", precision = 24, scale = 4)
	private BigDecimal noop_over_bought;

	@Column(name = "NOOP_OVER_SOLD", precision = 24, scale = 4)
	private BigDecimal noop_over_sold;

	@Column(name = "GAP_LIMIT", precision = 24, scale = 4)
	private BigDecimal gap_limit;

	@Column(name = "AGGREGATE_GAP_LIMIT_MAIN_CCY", precision = 24, scale = 4)
	private BigDecimal aggregate_gap_limit_main_ccy;

	@Column(name = "AGGREGATE_GAP_LIMIT_OTHER_CCY", precision = 24, scale = 4)
	private BigDecimal aggregate_gap_limit_other_ccy;

	@Column(name = "INDL_GAP_LIMIT_MAIN_CCY", precision = 24, scale = 4)
	private BigDecimal indl_gap_limit_main_ccy;

	@Column(name = "INDL_GAP_LIMIT_OTHER_CCY", precision = 24, scale = 4)
	private BigDecimal indl_gap_limit_other_ccy;

	@Column(name = "BREACH_OF_DAY_LIGHT_EXP", length = 3)
	private String breach_of_day_light_exp;

	@Column(name = "BREACH_OF_STOP_LOSS_LIMIT", length = 3)
	private String breach_of_stop_loss_limit;

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public BigDecimal getOnfc_over_bought() {
		return onfc_over_bought;
	}

	public void setOnfc_over_bought(BigDecimal onfc_over_bought) {
		this.onfc_over_bought = onfc_over_bought;
	}

	public BigDecimal getOnfc_over_sold() {
		return onfc_over_sold;
	}

	public void setOnfc_over_sold(BigDecimal onfc_over_sold) {
		this.onfc_over_sold = onfc_over_sold;
	}

	public BigDecimal getNoop_over_bought() {
		return noop_over_bought;
	}

	public void setNoop_over_bought(BigDecimal noop_over_bought) {
		this.noop_over_bought = noop_over_bought;
	}

	public BigDecimal getNoop_over_sold() {
		return noop_over_sold;
	}

	public void setNoop_over_sold(BigDecimal noop_over_sold) {
		this.noop_over_sold = noop_over_sold;
	}

	public BigDecimal getGap_limit() {
		return gap_limit;
	}

	public void setGap_limit(BigDecimal gap_limit) {
		this.gap_limit = gap_limit;
	}

	public BigDecimal getAggregate_gap_limit_main_ccy() {
		return aggregate_gap_limit_main_ccy;
	}

	public void setAggregate_gap_limit_main_ccy(BigDecimal aggregate_gap_limit_main_ccy) {
		this.aggregate_gap_limit_main_ccy = aggregate_gap_limit_main_ccy;
	}

	public BigDecimal getAggregate_gap_limit_other_ccy() {
		return aggregate_gap_limit_other_ccy;
	}

	public void setAggregate_gap_limit_other_ccy(BigDecimal aggregate_gap_limit_other_ccy) {
		this.aggregate_gap_limit_other_ccy = aggregate_gap_limit_other_ccy;
	}

	public BigDecimal getIndl_gap_limit_main_ccy() {
		return indl_gap_limit_main_ccy;
	}

	public void setIndl_gap_limit_main_ccy(BigDecimal indl_gap_limit_main_ccy) {
		this.indl_gap_limit_main_ccy = indl_gap_limit_main_ccy;
	}

	public BigDecimal getIndl_gap_limit_other_ccy() {
		return indl_gap_limit_other_ccy;
	}

	public void setIndl_gap_limit_other_ccy(BigDecimal indl_gap_limit_other_ccy) {
		this.indl_gap_limit_other_ccy = indl_gap_limit_other_ccy;
	}

	public String getBreach_of_day_light_exp() {
		return breach_of_day_light_exp;
	}

	public void setBreach_of_day_light_exp(String breach_of_day_light_exp) {
		this.breach_of_day_light_exp = breach_of_day_light_exp;
	}

	public String getBreach_of_stop_loss_limit() {
		return breach_of_stop_loss_limit;
	}

	public void setBreach_of_stop_loss_limit(String breach_of_stop_loss_limit) {
		this.breach_of_stop_loss_limit = breach_of_stop_loss_limit;
	}
}
