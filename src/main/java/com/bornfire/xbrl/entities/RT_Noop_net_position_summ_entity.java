package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rt_net_position_limit_noop_summ")
public class RT_Noop_net_position_summ_entity {
	
	@Id
	private Date	report_date;
	private BigDecimal	over_bought_amount;
	private BigDecimal	over_sold_amount;
	private BigDecimal	noop_amount_in_inr;
	private BigDecimal	limit_amount_in_inr;
	private BigDecimal	headroom_aval_amount_in_inr;
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public BigDecimal getOver_bought_amount() {
		return over_bought_amount;
	}
	public void setOver_bought_amount(BigDecimal over_bought_amount) {
		this.over_bought_amount = over_bought_amount;
	}
	public BigDecimal getOver_sold_amount() {
		return over_sold_amount;
	}
	public void setOver_sold_amount(BigDecimal over_sold_amount) {
		this.over_sold_amount = over_sold_amount;
	}
	public BigDecimal getNoop_amount_in_inr() {
		return noop_amount_in_inr;
	}
	public void setNoop_amount_in_inr(BigDecimal noop_amount_in_inr) {
		this.noop_amount_in_inr = noop_amount_in_inr;
	}
	public BigDecimal getLimit_amount_in_inr() {
		return limit_amount_in_inr;
	}
	public void setLimit_amount_in_inr(BigDecimal limit_amount_in_inr) {
		this.limit_amount_in_inr = limit_amount_in_inr;
	}
	public BigDecimal getHeadroom_aval_amount_in_inr() {
		return headroom_aval_amount_in_inr;
	}
	public void setHeadroom_aval_amount_in_inr(BigDecimal headroom_aval_amount_in_inr) {
		this.headroom_aval_amount_in_inr = headroom_aval_amount_in_inr;
	}
	@Override
	public String toString() {
		return "RT_Noop_net_position_summ_entity [report_date=" + report_date + ", over_bought_amount="
				+ over_bought_amount + ", over_sold_amount=" + over_sold_amount + ", noop_amount_in_inr="
				+ noop_amount_in_inr + ", limit_amount_in_inr=" + limit_amount_in_inr + ", headroom_aval_amount_in_inr="
				+ headroom_aval_amount_in_inr + "]";
	}
	public RT_Noop_net_position_summ_entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
