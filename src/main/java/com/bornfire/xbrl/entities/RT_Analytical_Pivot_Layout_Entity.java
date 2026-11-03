package com.bornfire.xbrl.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "RT_ANALYTICAL_PIVOT_LAYOUT")
public class RT_Analytical_Pivot_Layout_Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rt_analytical_pivot_layout_seq")
	@SequenceGenerator(name = "rt_analytical_pivot_layout_seq", sequenceName = "RT_ANALYTICAL_PIVOT_LAYOUT_SEQ", allocationSize = 1)
	@Column(name = "LAYOUT_ID")
	private Long layoutId;

	@Column(name = "USER_ID", nullable = false, length = 100)
	private String userId;

	@Column(name = "LAYOUT_NAME", nullable = false, length = 120)
	private String layoutName;

	@Column(name = "TABLE_NAME", nullable = false, length = 100)
	private String tableName;

	@Column(name = "ROW_COLUMNS", length = 4000)
	private String rowColumns;

	@Column(name = "COLUMN_COLUMNS", length = 4000)
	private String columnColumns;

	@Column(name = "AGGREGATION_TYPE", nullable = false, length = 10)
	private String aggregationType;

	@Column(name = "VALUE_COLUMN", length = 100)
	private String valueColumn;

	@Column(name = "AGGREGATE_TRANSFORM", length = 20)
	private String aggregateTransform;

	@Column(name = "AGGREGATE_OPERAND", length = 50)
	private String aggregateOperand;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TIME")
	private Date createdTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_TIME")
	private Date updatedTime;

	public Long getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(Long layoutId) {
		this.layoutId = layoutId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getRowColumns() {
		return rowColumns;
	}

	public void setRowColumns(String rowColumns) {
		this.rowColumns = rowColumns;
	}

	public String getColumnColumns() {
		return columnColumns;
	}

	public void setColumnColumns(String columnColumns) {
		this.columnColumns = columnColumns;
	}

	public String getAggregationType() {
		return aggregationType;
	}

	public void setAggregationType(String aggregationType) {
		this.aggregationType = aggregationType;
	}

	public String getValueColumn() {
		return valueColumn;
	}

	public void setValueColumn(String valueColumn) {
		this.valueColumn = valueColumn;
	}

	public String getAggregateTransform() {
		return aggregateTransform;
	}

	public void setAggregateTransform(String aggregateTransform) {
		this.aggregateTransform = aggregateTransform;
	}

	public String getAggregateOperand() {
		return aggregateOperand;
	}

	public void setAggregateOperand(String aggregateOperand) {
		this.aggregateOperand = aggregateOperand;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
}
