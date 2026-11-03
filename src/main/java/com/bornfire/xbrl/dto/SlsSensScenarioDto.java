package com.bornfire.xbrl.dto;

import java.util.Date;

/**
 * One sensitivity scenario (Day 0 … Day +6) for list and report navigation.
 */
public class SlsSensScenarioDto {

	private Date positionDate;
	private String positionDateFormatted;
	private Date asOfDate;
	private String asOfDateFormatted;
	private Integer sensDayOffset;
	private String scenarioLabel;
	private String reportCurrency;
	private boolean baseScenario;

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

	public Date getAsOfDate() {
		return asOfDate;
	}

	public void setAsOfDate(Date asOfDate) {
		this.asOfDate = asOfDate;
	}

	public String getAsOfDateFormatted() {
		return asOfDateFormatted;
	}

	public void setAsOfDateFormatted(String asOfDateFormatted) {
		this.asOfDateFormatted = asOfDateFormatted;
	}

	public Integer getSensDayOffset() {
		return sensDayOffset;
	}

	public void setSensDayOffset(Integer sensDayOffset) {
		this.sensDayOffset = sensDayOffset;
	}

	public String getScenarioLabel() {
		return scenarioLabel;
	}

	public void setScenarioLabel(String scenarioLabel) {
		this.scenarioLabel = scenarioLabel;
	}

	public String getReportCurrency() {
		return reportCurrency;
	}

	public void setReportCurrency(String reportCurrency) {
		this.reportCurrency = reportCurrency;
	}

	public boolean isBaseScenario() {
		return baseScenario;
	}

	public void setBaseScenario(boolean baseScenario) {
		this.baseScenario = baseScenario;
	}
}
