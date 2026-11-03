package com.bornfire.xbrl.dto;

import java.util.List;

/**
 * Row or column dimension: column name plus optional equality filter (empty = no filter).
 */
public class AnalyticalPivotDimensionDto {

	private String columnName;
	/** When null or blank, no filter is applied for this dimension. */
	private String filterValue;
	/** Multiple values (IN list). If set and non-empty, takes precedence over {@link #filterValue}. */
	private List<String> filterValues;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getFilterValue() {
		return filterValue;
	}

	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}

	public List<String> getFilterValues() {
		return filterValues;
	}

	public void setFilterValues(List<String> filterValues) {
		this.filterValues = filterValues;
	}
}
