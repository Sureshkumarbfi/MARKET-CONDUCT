package com.bornfire.xbrl.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ReportControlMasterRowDto {

	private BigDecimal reportId;
	private String reportName;
	private String reportStatus;
	private Integer totalSteps;
	private Integer completedSteps;
	private Integer failedSteps;
	private Date reportDate;
	private boolean generatedForSelectedDay;
	private boolean runInProgress;

	public BigDecimal getReportId() {
		return reportId;
	}

	public void setReportId(BigDecimal reportId) {
		this.reportId = reportId;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}

	public Integer getTotalSteps() {
		return totalSteps;
	}

	public void setTotalSteps(Integer totalSteps) {
		this.totalSteps = totalSteps;
	}

	public Integer getCompletedSteps() {
		return completedSteps;
	}

	public void setCompletedSteps(Integer completedSteps) {
		this.completedSteps = completedSteps;
	}

	public Integer getFailedSteps() {
		return failedSteps;
	}

	public void setFailedSteps(Integer failedSteps) {
		this.failedSteps = failedSteps;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public boolean isGeneratedForSelectedDay() {
		return generatedForSelectedDay;
	}

	public void setGeneratedForSelectedDay(boolean generatedForSelectedDay) {
		this.generatedForSelectedDay = generatedForSelectedDay;
	}

	public boolean isRunInProgress() {
		return runInProgress;
	}

	public void setRunInProgress(boolean runInProgress) {
		this.runInProgress = runInProgress;
	}
}
