package com.bornfire.xbrl.dto;

import java.util.List;

public class ReportControlStepsResponseDto {

	private List<ReportControlStepDto> steps;
	private ReportControlReportMetaDto meta;

	public ReportControlStepsResponseDto() {
	}

	public ReportControlStepsResponseDto(List<ReportControlStepDto> steps, ReportControlReportMetaDto meta) {
		this.steps = steps;
		this.meta = meta;
	}

	public List<ReportControlStepDto> getSteps() {
		return steps;
	}

	public void setSteps(List<ReportControlStepDto> steps) {
		this.steps = steps;
	}

	public ReportControlReportMetaDto getMeta() {
		return meta;
	}

	public void setMeta(ReportControlReportMetaDto meta) {
		this.meta = meta;
	}
}
