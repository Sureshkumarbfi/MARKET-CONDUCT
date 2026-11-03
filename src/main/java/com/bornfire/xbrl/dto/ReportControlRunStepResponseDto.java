package com.bornfire.xbrl.dto;

public class ReportControlRunStepResponseDto {

	private String status;
	private String message;
	/** True when execution continues in the background (client should poll steps). */
	private boolean accepted;

	public ReportControlRunStepResponseDto() {
	}

	public ReportControlRunStepResponseDto(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public ReportControlRunStepResponseDto(String status, String message, boolean accepted) {
		this.status = status;
		this.message = message;
		this.accepted = accepted;
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

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
}
