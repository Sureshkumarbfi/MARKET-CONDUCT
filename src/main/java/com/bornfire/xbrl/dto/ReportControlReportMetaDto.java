package com.bornfire.xbrl.dto;

import java.util.Date;

/**
 * Aggregated report run state for Report Control Center (master row + lock info).
 */
public class ReportControlReportMetaDto {

	private String reportStatus;
	private Integer totalSteps;
	private Integer completedSteps;
	private Integer failedSteps;
	private Date reportDate;
	private boolean runInProgress;
	private String activeRunner;
	private boolean lockedByOtherUser;
	private String lockMessage;

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

	public boolean isRunInProgress() {
		return runInProgress;
	}

	public void setRunInProgress(boolean runInProgress) {
		this.runInProgress = runInProgress;
	}

	public String getActiveRunner() {
		return activeRunner;
	}

	public void setActiveRunner(String activeRunner) {
		this.activeRunner = activeRunner;
	}

	public boolean isLockedByOtherUser() {
		return lockedByOtherUser;
	}

	public void setLockedByOtherUser(boolean lockedByOtherUser) {
		this.lockedByOtherUser = lockedByOtherUser;
	}

	public String getLockMessage() {
		return lockMessage;
	}

	public void setLockMessage(String lockMessage) {
		this.lockMessage = lockMessage;
	}
}
