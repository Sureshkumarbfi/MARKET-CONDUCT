package com.bornfire.xbrl.dto;

public class ReportControlRunAllResponseDto {

	private String status;
	private String message;
	private int completedSteps;
	private int totalSteps;
	private Long failedStepId;

	public ReportControlRunAllResponseDto() {
	}

	public ReportControlRunAllResponseDto(String status, String message, int completedSteps, int totalSteps,
			Long failedStepId) {
		this.status = status;
		this.message = message;
		this.completedSteps = completedSteps;
		this.totalSteps = totalSteps;
		this.failedStepId = failedStepId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCompletedSteps() {
		return completedSteps;
	}

	public void setCompletedSteps(int completedSteps) {
		this.completedSteps = completedSteps;
	}

	public int getTotalSteps() {
		return totalSteps;
	}

	public void setTotalSteps(int totalSteps) {
		this.totalSteps = totalSteps;
	}

	public Long getFailedStepId() {
		return failedStepId;
	}

	public void setFailedStepId(Long failedStepId) {
		this.failedStepId = failedStepId;
	}
}
