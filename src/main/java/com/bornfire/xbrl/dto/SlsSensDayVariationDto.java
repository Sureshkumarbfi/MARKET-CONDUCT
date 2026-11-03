package com.bornfire.xbrl.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Change from Base (Day 0) for one sensitivity scenario day, with day ratios.
 */
public class SlsSensDayVariationDto {

	private Integer sensDayOffset;
	private String scenarioLabel;
	private String asOfDateFormatted;
	private BigDecimal deltaOutflowMediumTerm;
	private BigDecimal deltaOutflowLongTerm;
	private BigDecimal deltaInflowMediumTerm;
	private BigDecimal deltaInflowLongTerm;
	private BigDecimal longTermRatio;
	private BigDecimal medLongTermRatio;
	private BigDecimal deltaLongTermRatio;
	private BigDecimal deltaMedLongTermRatio;
	private List<IrsSensBucketRowDto> buckets = new ArrayList<>();
	private BigDecimal deltaTotalRsl;
	private BigDecimal deltaTotalRsa;

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

	public BigDecimal getDeltaOutflowMediumTerm() {
		return deltaOutflowMediumTerm;
	}

	public void setDeltaOutflowMediumTerm(BigDecimal deltaOutflowMediumTerm) {
		this.deltaOutflowMediumTerm = deltaOutflowMediumTerm;
	}

	public BigDecimal getDeltaOutflowLongTerm() {
		return deltaOutflowLongTerm;
	}

	public void setDeltaOutflowLongTerm(BigDecimal deltaOutflowLongTerm) {
		this.deltaOutflowLongTerm = deltaOutflowLongTerm;
	}

	public BigDecimal getDeltaInflowMediumTerm() {
		return deltaInflowMediumTerm;
	}

	public void setDeltaInflowMediumTerm(BigDecimal deltaInflowMediumTerm) {
		this.deltaInflowMediumTerm = deltaInflowMediumTerm;
	}

	public BigDecimal getDeltaInflowLongTerm() {
		return deltaInflowLongTerm;
	}

	public void setDeltaInflowLongTerm(BigDecimal deltaInflowLongTerm) {
		this.deltaInflowLongTerm = deltaInflowLongTerm;
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

	public BigDecimal getDeltaLongTermRatio() {
		return deltaLongTermRatio;
	}

	public void setDeltaLongTermRatio(BigDecimal deltaLongTermRatio) {
		this.deltaLongTermRatio = deltaLongTermRatio;
	}

	public BigDecimal getDeltaMedLongTermRatio() {
		return deltaMedLongTermRatio;
	}

	public void setDeltaMedLongTermRatio(BigDecimal deltaMedLongTermRatio) {
		this.deltaMedLongTermRatio = deltaMedLongTermRatio;
	}

	public List<IrsSensBucketRowDto> getBuckets() {
		return buckets;
	}

	public void setBuckets(List<IrsSensBucketRowDto> buckets) {
		this.buckets = buckets != null ? buckets : new ArrayList<>();
	}

	public BigDecimal getDeltaTotalRsl() {
		return deltaTotalRsl;
	}

	public void setDeltaTotalRsl(BigDecimal deltaTotalRsl) {
		this.deltaTotalRsl = deltaTotalRsl;
	}

	public BigDecimal getDeltaTotalRsa() {
		return deltaTotalRsa;
	}

	public void setDeltaTotalRsa(BigDecimal deltaTotalRsa) {
		this.deltaTotalRsa = deltaTotalRsa;
	}
}
