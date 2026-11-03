package com.bornfire.xbrl.dto;

import java.math.BigDecimal;

/**
 * Total outflows (R39) and inflows (R70) for one sensitivity scenario day.
 */
public class SlsSensDayTotalsDto {

	private Integer sensDayOffset;
	private String scenarioLabel;
	private String asOfDateFormatted;
	private BigDecimal totalOutflows;
	private BigDecimal totalInflows;

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

	public String getAsOfDateFormatted() {
		return asOfDateFormatted;
	}

	public void setAsOfDateFormatted(String asOfDateFormatted) {
		this.asOfDateFormatted = asOfDateFormatted;
	}

	public BigDecimal getTotalOutflows() {
		return totalOutflows;
	}

	public void setTotalOutflows(BigDecimal totalOutflows) {
		this.totalOutflows = totalOutflows;
	}

	public BigDecimal getTotalInflows() {
		return totalInflows;
	}

	public void setTotalInflows(BigDecimal totalInflows) {
		this.totalInflows = totalInflows;
	}
}
