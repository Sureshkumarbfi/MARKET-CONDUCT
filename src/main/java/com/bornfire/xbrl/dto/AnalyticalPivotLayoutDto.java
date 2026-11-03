package com.bornfire.xbrl.dto;

import java.util.List;

public class AnalyticalPivotLayoutDto {

	private Long layoutId;
	private String layoutName;
	private String tableName;
	/** Legacy saved layouts: comma-separated column names. */
	private List<String> rowColumns;
	private List<String> columnColumns;
	/** Preferred: dimensions with optional filters (mirrors request). */
	private List<AnalyticalPivotDimensionDto> rowDimensions;
	private List<AnalyticalPivotDimensionDto> columnDimensions;
	private String aggregation;
	private String valueColumn;
	private List<String> valueColumns;
	private String aggregateTransform;
	private String aggregateTransformOperand;

	public Long getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(Long layoutId) {
		this.layoutId = layoutId;
	}

	public String getLayoutName() {
		return layoutName;
	}

	public void setLayoutName(String layoutName) {
		this.layoutName = layoutName;
	}

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

	public List<AnalyticalPivotDimensionDto> getRowDimensions() {
		return rowDimensions;
	}

	public void setRowDimensions(List<AnalyticalPivotDimensionDto> rowDimensions) {
		this.rowDimensions = rowDimensions;
	}

	public List<AnalyticalPivotDimensionDto> getColumnDimensions() {
		return columnDimensions;
	}

	public void setColumnDimensions(List<AnalyticalPivotDimensionDto> columnDimensions) {
		this.columnDimensions = columnDimensions;
	}

	public String getAggregateTransform() {
		return aggregateTransform;
	}

	public void setAggregateTransform(String aggregateTransform) {
		this.aggregateTransform = aggregateTransform;
	}

	public String getAggregateTransformOperand() {
		return aggregateTransformOperand;
	}

	public void setAggregateTransformOperand(String aggregateTransformOperand) {
		this.aggregateTransformOperand = aggregateTransformOperand;
	}
}
