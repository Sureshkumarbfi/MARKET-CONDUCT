package com.bornfire.xbrl.dto;

import java.util.Date;

public class ReportControlStepDto {

	private Long stepId;
	private Integer stepOrder;
	private String procedureName;
	private String status;
	private String errorMessage;
	private String execUserName;
	private Date stepStartTime;
	private Date stepEndTime;

	public Long getStepId() {
		return stepId;
	}

	public void setStepId(Long stepId) {
		this.stepId = stepId;
	}

	public Integer getStepOrder() {
		return stepOrder;
	}

	public void setStepOrder(Integer stepOrder) {
		this.stepOrder = stepOrder;
	}

	public String getProcedureName() {
		return procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getExecUserName() {
		return execUserName;
	}

	public void setExecUserName(String execUserName) {
		this.execUserName = execUserName;
	}

	public Date getStepStartTime() {
		return stepStartTime;
	}

	public void setStepStartTime(Date stepStartTime) {
		this.stepStartTime = stepStartTime;
	}

	public Date getStepEndTime() {
		return stepEndTime;
	}

	public void setStepEndTime(Date stepEndTime) {
		this.stepEndTime = stepEndTime;
	}
}
