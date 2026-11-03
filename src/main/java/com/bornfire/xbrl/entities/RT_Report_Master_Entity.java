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
 * Maps {@code RT_REPORT_MASTER}. {@code report_status} holds overall execution state
 * (e.g. SUCCESS, FAILED, IN_PROGRESS).
 */
@Entity
@Table(name = "RT_REPORT_MASTER")
public class RT_Report_Master_Entity {

	@Id
	@Column(name = "REPORT_ID")
	private BigDecimal report_id;

	@Column(name = "REPORT_NAME", length = 200)
	private String report_name;

	@Column(name = "IS_ACTIVE", length = 1)
	private String is_active;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REPORT_DATE")
	private Date report_date;

	/** Overall status: SUCCESS, FAILED, IN_PROGRESS, etc. */
	@Column(name = "REPORT_STATUS", length = 20)
	private String report_status;

	/** Daily / Weekly / Monthly (or codes stored by your process) */
	@Column(name = "REPORT_FREQ", length = 20)
	private String report_freq;

	@Column(name = "TOTAL_STEPS")
	private Integer total_steps;

	@Column(name = "COMPLETED_STEPS")
	private Integer completed_steps;

	@Column(name = "FAILED_STEPS")
	private Integer failed_steps;

	public BigDecimal getReport_id() {
		return report_id;
	}

	public void setReport_id(BigDecimal report_id) {
		this.report_id = report_id;
	}

	public String getReport_name() {
		return report_name;
	}

	public void setReport_name(String report_name) {
		this.report_name = report_name;
	}

	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public String getReport_status() {
		return report_status;
	}

	public void setReport_status(String report_status) {
		this.report_status = report_status;
	}

	public String getReport_freq() {
		return report_freq;
	}

	public void setReport_freq(String report_freq) {
		this.report_freq = report_freq;
	}

	public Integer getTotal_steps() {
		return total_steps;
	}

	public void setTotal_steps(Integer total_steps) {
		this.total_steps = total_steps;
	}

	public Integer getCompleted_steps() {
		return completed_steps;
	}

	public void setCompleted_steps(Integer completed_steps) {
		this.completed_steps = completed_steps;
	}

	public Integer getFailed_steps() {
		return failed_steps;
	}

	public void setFailed_steps(Integer failed_steps) {
		this.failed_steps = failed_steps;
	}

	@Override
	public String toString() {
		return "RT_Report_Master_Entity [report_id=" + report_id + ", report_name=" + report_name + ", is_active="
				+ is_active + ", report_date=" + report_date + ", report_status=" + report_status + ", report_freq="
				+ report_freq + ", total_steps=" + total_steps + ", completed_steps=" + completed_steps
				+ ", failed_steps=" + failed_steps + "]";
	}

	public RT_Report_Master_Entity(BigDecimal report_id, String report_name, String is_active, Date report_date,
			String report_status, String report_freq, Integer total_steps, Integer completed_steps,
			Integer failed_steps) {
		super();
		this.report_id = report_id;
		this.report_name = report_name;
		this.is_active = is_active;
		this.report_date = report_date;
		this.report_status = report_status;
		this.report_freq = report_freq;
		this.total_steps = total_steps;
		this.completed_steps = completed_steps;
		this.failed_steps = failed_steps;
	}

	public RT_Report_Master_Entity() {
		super();
	}
}
