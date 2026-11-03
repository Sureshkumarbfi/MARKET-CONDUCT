package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "RT_REPORT_STEP_EXEC")
public class RT_Report_Step_Exec_Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rt_report_step_exec_seq")
	@SequenceGenerator(name = "rt_report_step_exec_seq", sequenceName = "RT_REPORT_STEP_EXEC_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private Long id;

	@Column(name = "REPORT_ID", nullable = false)
	private BigDecimal report_id;

	@Column(name = "STEP_ID", nullable = false)
	private Long step_id;

	@Temporal(TemporalType.DATE)
	@Column(name = "REPORT_DATE", nullable = false)
	private Date report_date;

	@Column(name = "STATUS", nullable = false, length = 20)
	private String status;

	@Column(name = "ERROR_MESSAGE", length = 4000)
	private String error_message;

	/** Session user id / name who executed the step. */
	@Column(name = "EXEC_USER_NAME", length = 200)
	private String exec_user_name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STEP_START_TIME")
	private Date step_start_time;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STEP_END_TIME")
	private Date step_end_time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getReport_id() {
		return report_id;
	}

	public void setReport_id(BigDecimal report_id) {
		this.report_id = report_id;
	}

	public Long getStep_id() {
		return step_id;
	}

	public void setStep_id(Long step_id) {
		this.step_id = step_id;
	}

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	public String getExec_user_name() {
		return exec_user_name;
	}

	public void setExec_user_name(String exec_user_name) {
		this.exec_user_name = exec_user_name;
	}

	public Date getStep_start_time() {
		return step_start_time;
	}

	public void setStep_start_time(Date step_start_time) {
		this.step_start_time = step_start_time;
	}

	public Date getStep_end_time() {
		return step_end_time;
	}

	public void setStep_end_time(Date step_end_time) {
		this.step_end_time = step_end_time;
	}
}
