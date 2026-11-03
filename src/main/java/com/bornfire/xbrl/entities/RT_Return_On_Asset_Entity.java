package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Maps {@code RT_RETURN_ON_ASSET}. Natural key: one row per {@link #report_date}.
 */
@Entity
@Table(name = "RT_RETURN_ON_ASSET")
public class RT_Return_On_Asset_Entity {

	@Id
	@Temporal(TemporalType.DATE)
	@Column(name = "REPORT_DATE", nullable = false)
	private Date report_date;

	@Column(name = "NET_PROFIT", precision = 24, scale = 2)
	private BigDecimal net_profit;

	@Column(name = "DAILY_AVG_ASSETS_NET_OF_INTER_BRANCH_BORR", precision = 24, scale = 2)
	private BigDecimal daily_avg_assets_net_of_inter_branch_borr;

	@Column(name = "RETURN_ON_ASST_PER", precision = 10, scale = 2)
	private BigDecimal return_on_asst_per;

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public BigDecimal getNet_profit() {
		return net_profit;
	}

	public void setNet_profit(BigDecimal net_profit) {
		this.net_profit = net_profit;
	}

	public BigDecimal getDaily_avg_assets_net_of_inter_branch_borr() {
		return daily_avg_assets_net_of_inter_branch_borr;
	}

	public void setDaily_avg_assets_net_of_inter_branch_borr(BigDecimal daily_avg_assets_net_of_inter_branch_borr) {
		this.daily_avg_assets_net_of_inter_branch_borr = daily_avg_assets_net_of_inter_branch_borr;
	}

	public BigDecimal getReturn_on_asst_per() {
		return return_on_asst_per;
	}

	public void setReturn_on_asst_per(BigDecimal return_on_asst_per) {
		this.return_on_asst_per = return_on_asst_per;
	}
}
