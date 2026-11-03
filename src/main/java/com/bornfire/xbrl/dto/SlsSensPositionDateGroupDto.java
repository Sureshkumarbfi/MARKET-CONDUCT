package com.bornfire.xbrl.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Grouped list entry: one position date + currency with up to 7 sensitivity scenarios.
 */
public class SlsSensPositionDateGroupDto {

	private Date positionDate;
	private String positionDateFormatted;
	private String reportCurrency;
	private int scenarioCount;
	private List<SlsSensScenarioDto> scenarios = new ArrayList<>();

	public Date getPositionDate() {
		return positionDate;
	}

	public void setPositionDate(Date positionDate) {
		this.positionDate = positionDate;
	}

	public String getPositionDateFormatted() {
		return positionDateFormatted;
	}

	public void setPositionDateFormatted(String positionDateFormatted) {
		this.positionDateFormatted = positionDateFormatted;
	}

	public String getReportCurrency() {
		return reportCurrency;
	}

	public void setReportCurrency(String reportCurrency) {
		this.reportCurrency = reportCurrency;
	}

	public int getScenarioCount() {
		return scenarioCount;
	}

	public void setScenarioCount(int scenarioCount) {
		this.scenarioCount = scenarioCount;
	}

	public List<SlsSensScenarioDto> getScenarios() {
		return scenarios;
	}

	public void setScenarios(List<SlsSensScenarioDto> scenarios) {
		this.scenarios = scenarios;
	}
}
