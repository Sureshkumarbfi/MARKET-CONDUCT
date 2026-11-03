package com.bornfire.xbrl.dto;

import java.util.List;
import java.util.Map;

public class AnalyticalPivotRunResponseDto {

	private String tableName;
	private List<String> rowColumns;
	private List<String> columnColumns;
	private String aggregation;
	private String valueColumn;
	private List<String> valueColumns;
	private int rowCount;
	private List<Map<String, Object>> data;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<String> getRowColumns() {
		return rowColumns;
	}

	public void setRowColumns(List<String> rowColumns) {
		this.rowColumns = rowColumns;
	}

	public List<String> getColumnColumns() {
		return columnColumns;
	}

	public void setColumnColumns(List<String> columnColumns) {
		this.columnColumns = columnColumns;
	}

	public String getAggregation() {
		return aggregation;
	}

	public void setAggregation(String aggregation) {
		this.aggregation = aggregation;
	}

	public String getValueColumn() {
		return valueColumn;
	}

	public void setValueColumn(String valueColumn) {
		this.valueColumn = valueColumn;
	}

	public List<String> getValueColumns() {
		return valueColumns;
	}

	public void setValueColumns(List<String> valueColumns) {
		this.valueColumns = valueColumns;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public List<Map<String, Object>> getData() {
		return data;
	}

	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}
}
