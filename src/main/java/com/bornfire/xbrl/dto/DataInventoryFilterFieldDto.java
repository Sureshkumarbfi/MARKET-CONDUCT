package com.bornfire.xbrl.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * One optional filter field shown on the Data Inventory dashboard (in addition to report date).
 */
public class DataInventoryFilterFieldDto {

	private String column;
	private String label;
	private boolean required;
	private String inputType = "text";
	private List<String> options = new ArrayList<String>();

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public String getInputType() {
		return inputType;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options != null ? options : new ArrayList<String>();
	}
}
