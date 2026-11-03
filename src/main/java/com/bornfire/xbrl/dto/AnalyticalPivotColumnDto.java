package com.bornfire.xbrl.dto;

public class AnalyticalPivotColumnDto {

	private String columnName;
	private String dataType;
	private boolean numeric;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public boolean isNumeric() {
		return numeric;
	}

	public void setNumeric(boolean numeric) {
		this.numeric = numeric;
	}
}
