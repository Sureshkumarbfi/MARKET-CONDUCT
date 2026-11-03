package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RT_MATRIX_DAY_LIGHT_DATA")
public class Daylight_data_entity {

	@Id
	private BigDecimal srlno;
	private Date	report_date;
	private String	time_of_deal;
	private String	deal_type_or_id;
	private String	counterparty;
	private Date	value_date;
	private BigDecimal	rate;
	private BigDecimal	purchase;
	private BigDecimal	sale;
	private BigDecimal	net_position;
	private String	currency;
	public BigDecimal getSrlno() {
		return srlno;
	}
	public void setSrlno(BigDecimal srlno) {
		this.srlno = srlno;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getTime_of_deal() {
		return time_of_deal;
	}
	public void setTime_of_deal(String time_of_deal) {
		this.time_of_deal = time_of_deal;
	}
	public String getDeal_type_or_id() {
		return deal_type_or_id;
	}
	public void setDeal_type_or_id(String deal_type_or_id) {
		this.deal_type_or_id = deal_type_or_id;
	}
	public String getCounterparty() {
		return counterparty;
	}
	public void setCounterparty(String counterparty) {
		this.counterparty = counterparty;
	}
	public Date getValue_date() {
		return value_date;
	}
	public void setValue_date(Date value_date) {
		this.value_date = value_date;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public BigDecimal getPurchase() {
		return purchase;
	}
	public void setPurchase(BigDecimal purchase) {
		this.purchase = purchase;
	}
	public BigDecimal getSale() {
		return sale;
	}
	public void setSale(BigDecimal sale) {
		this.sale = sale;
	}
	public BigDecimal getNet_position() {
		return net_position;
	}
	public void setNet_position(BigDecimal net_position) {
		this.net_position = net_position;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@Override
	public String toString() {
		return "Daylight_data_entity [srlno=" + srlno + ", report_date=" + report_date + ", time_of_deal="
				+ time_of_deal + ", deal_type_or_id=" + deal_type_or_id + ", counterparty=" + counterparty
				+ ", value_date=" + value_date + ", rate=" + rate + ", purchase=" + purchase + ", sale=" + sale
				+ ", net_position=" + net_position + ", currency=" + currency + "]";
	}
	public Daylight_data_entity(BigDecimal srlno, Date report_date, String time_of_deal, String deal_type_or_id,
			String counterparty, Date value_date, BigDecimal rate, BigDecimal purchase, BigDecimal sale,
			BigDecimal net_position, String currency) {
		super();
		this.srlno = srlno;
		this.report_date = report_date;
		this.time_of_deal = time_of_deal;
		this.deal_type_or_id = deal_type_or_id;
		this.counterparty = counterparty;
		this.value_date = value_date;
		this.rate = rate;
		this.purchase = purchase;
		this.sale = sale;
		this.net_position = net_position;
		this.currency = currency;
	}
	public Daylight_data_entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
