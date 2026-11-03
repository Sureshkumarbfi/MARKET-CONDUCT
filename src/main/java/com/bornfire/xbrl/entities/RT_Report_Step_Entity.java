package com.bornfire.xbrl.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RT_REPORT_STEP")
public class RT_Report_Step_Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rt_report_step_seq")
	@SequenceGenerator(name = "rt_report_step_seq", sequenceName = "RT_REPORT_STEP_SEQ", allocationSize = 1)
	@Column(name = "STEP_ID")
	private Long step_id;

	@Column(name = "REPORT_ID", nullable = false)
	private BigDecimal report_id;

	@Column(name = "STEP_ORDER", nullable = false)
	private Integer step_order;

	@Column(name = "PROCEDURE_NAME", nullable = false, length = 200)
	private String procedure_name;

	public Long getStep_id() {
		return step_id;
	}

	public void setStep_id(Long step_id) {
		this.step_id = step_id;
	}

	public BigDecimal getReport_id() {
		return report_id;
	}

	public void setReport_id(BigDecimal report_id) {
		this.report_id = report_id;
	}

	public Integer getStep_order() {
		return step_order;
	}

	public void setStep_order(Integer step_order) {
		this.step_order = step_order;
	}

	public String getProcedure_name() {
		return procedure_name;
	}

	public void setProcedure_name(String procedure_name) {
		this.procedure_name = procedure_name;
	}
}
