package com.bornfire.xbrl.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Parsed EXTRA_FILTERS configuration: optional filter fields and date rules.
 */
public class DataInventoryValidationConfigDto {

	/** Legacy / UI filters (not exposed on dashboard). */
	private List<DataInventoryFilterFieldDto> filters = new ArrayList<DataInventoryFilterFieldDto>();

	/** Backend-only filters applied automatically on export. */
	private List<DataInventoryFixedFilterDto> fixedFilters = new ArrayList<DataInventoryFixedFilterDto>();
	/** When true, report date cannot be after today. */
	private boolean dateNotFuture;
	/** Report date must be on or after (today - N days). Null = no limit. */
	private Integer dateMaxDaysBack;

	public List<DataInventoryFilterFieldDto> getFilters() {
		return filters;
	}

	public void setFilters(List<DataInventoryFilterFieldDto> filters) {
		this.filters = filters != null ? filters : new ArrayList<DataInventoryFilterFieldDto>();
	}

	public List<DataInventoryFixedFilterDto> getFixedFilters() {
		return fixedFilters;
	}

	public void setFixedFilters(List<DataInventoryFixedFilterDto> fixedFilters) {
		this.fixedFilters = fixedFilters != null ? fixedFilters : new ArrayList<DataInventoryFixedFilterDto>();
	}

	public boolean isDateNotFuture() {
		return dateNotFuture;
	}

	public void setDateNotFuture(boolean dateNotFuture) {
		this.dateNotFuture = dateNotFuture;
	}

	public Integer getDateMaxDaysBack() {
		return dateMaxDaysBack;
	}

	public void setDateMaxDaysBack(Integer dateMaxDaysBack) {
		this.dateMaxDaysBack = dateMaxDaysBack;
	}
}
