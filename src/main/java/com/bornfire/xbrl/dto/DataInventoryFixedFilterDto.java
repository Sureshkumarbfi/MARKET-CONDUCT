package com.bornfire.xbrl.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Fixed filter applied on export only (configured in EXTRA_FILTERS, not shown on dashboard).
 */
public class DataInventoryFixedFilterDto {

	private String column;
	private List<String> values = new ArrayList<String>();

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values != null ? values : new ArrayList<String>();
	}
}
