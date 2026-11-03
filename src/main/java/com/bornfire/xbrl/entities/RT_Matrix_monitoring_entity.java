package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RT_MATRIX_MONITORED_TABLE")
public class RT_Matrix_monitoring_entity {
	@Id
	private BigDecimal primary_num;
	private BigDecimal s_no;
	private String matrix_label;
	private String guidelines_or_policy;
	private String limit_assigned;
	private BigDecimal position_of_matrix;
	private String status;
	private Date report_date;

	public BigDecimal getPrimary_num() {
		return primary_num;
	}

	public void setPrimary_num(BigDecimal primary_num) {
		this.primary_num = primary_num;
	}

	public BigDecimal getS_no() {
		return s_no;
	}

	public void setS_no(BigDecimal s_no) {
		this.s_no = s_no;
	}

	public String getMatrix_label() {
		return matrix_label;
	}

	public void setMatrix_label(String matrix_label) {
		this.matrix_label = matrix_label;
	}

	public String getGuidelines_or_policy() {
		return guidelines_or_policy;
	}

	public void setGuidelines_or_policy(String guidelines_or_policy) {
		this.guidelines_or_policy = guidelines_or_policy;
	}

	public String getLimit_assigned() {
		return limit_assigned;
	}

	public void setLimit_assigned(String limit_assigned) {
		this.limit_assigned = limit_assigned;
	}

	public BigDecimal getPosition_of_matrix() {
		return position_of_matrix;
	}

	public void setPosition_of_matrix(BigDecimal position_of_matrix) {
		this.position_of_matrix = position_of_matrix;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	@Override
	public String toString() {
		return "RT_Matrix_monitoring_entity [primary_num=" + primary_num + ", s_no=" + s_no + ", matrix_label="
				+ matrix_label + ", guidelines_or_policy=" + guidelines_or_policy + ", limit_assigned=" + limit_assigned
				+ ", position_of_matrix=" + position_of_matrix + ", status=" + status + ", report_date=" + report_date
				+ "]";
	}

	public RT_Matrix_monitoring_entity(BigDecimal primary_num, BigDecimal s_no, String matrix_label,
			String guidelines_or_policy, String limit_assigned, BigDecimal position_of_matrix, String status,
			Date report_date) {
		super();
		this.primary_num = primary_num;
		this.s_no = s_no;
		this.matrix_label = matrix_label;
		this.guidelines_or_policy = guidelines_or_policy;
		this.limit_assigned = limit_assigned;
		this.position_of_matrix = position_of_matrix;
		this.status = status;
		this.report_date = report_date;
	}

	public RT_Matrix_monitoring_entity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
