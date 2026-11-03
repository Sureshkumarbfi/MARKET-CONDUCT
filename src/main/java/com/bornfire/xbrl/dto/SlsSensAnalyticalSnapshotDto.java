package com.bornfire.xbrl.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Medium/long-term outflows (R39) and inflows (R70) with liquidity ratios for one scenario day.
 */
public class SlsSensAnalyticalSnapshotDto {

	private Integer sensDayOffset;
	private String scenarioLabel;
	private String asOfDateFormatted;
	private BigDecimal outflowMediumTerm;
	private BigDecimal outflowLongTerm;
	private BigDecimal inflowMediumTerm;
	private BigDecimal inflowLongTerm;
	private BigDecimal longTermRatio;
	private BigDecimal medLongTermRatio;
	private List<IrsSensBucketRowDto> buckets = new ArrayList<>();
	private BigDecimal totalRsl;
	private BigDecimal totalRsa;

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

	public BigDecimal getOutflowMediumTerm() {
		return outflowMediumTerm;
	}

	public void setOutflowMediumTerm(BigDecimal outflowMediumTerm) {
		this.outflowMediumTerm = outflowMediumTerm;
	}

	public BigDecimal getOutflowLongTerm() {
		return outflowLongTerm;
	}

	public void setOutflowLongTerm(BigDecimal outflowLongTerm) {
		this.outflowLongTerm = outflowLongTerm;
	}

	public BigDecimal getInflowMediumTerm() {
		return inflowMediumTerm;
	}

	public void setInflowMediumTerm(BigDecimal inflowMediumTerm) {
		this.inflowMediumTerm = inflowMediumTerm;
	}

	public BigDecimal getInflowLongTerm() {
		return inflowLongTerm;
	}

	public void setInflowLongTerm(BigDecimal inflowLongTerm) {
		this.inflowLongTerm = inflowLongTerm;
	}

	public BigDecimal getLongTermRatio() {
		return longTermRatio;
	}

	public void setLongTermRatio(BigDecimal longTermRatio) {
		this.longTermRatio = longTermRatio;
	}

	public BigDecimal getMedLongTermRatio() {
		return medLongTermRatio;
	}

	public void setMedLongTermRatio(BigDecimal medLongTermRatio) {
		this.medLongTermRatio = medLongTermRatio;
	}

	public List<IrsSensBucketRowDto> getBuckets() {
		return buckets;
	}

	public void setBuckets(List<IrsSensBucketRowDto> buckets) {
		this.buckets = buckets != null ? buckets : new ArrayList<>();
	}

	public BigDecimal getTotalRsl() {
		return totalRsl;
	}

	public void setTotalRsl(BigDecimal totalRsl) {
		this.totalRsl = totalRsl;
	}

	public BigDecimal getTotalRsa() {
		return totalRsa;
	}

	public void setTotalRsa(BigDecimal totalRsa) {
		this.totalRsa = totalRsa;
	}
}
