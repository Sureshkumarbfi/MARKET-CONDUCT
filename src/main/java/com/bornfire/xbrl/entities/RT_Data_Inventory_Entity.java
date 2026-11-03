package com.bornfire.xbrl.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RT_DATA_INVENTORY")
public class RT_Data_Inventory_Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rt_data_inventory_seq")
	@SequenceGenerator(name = "rt_data_inventory_seq", sequenceName = "RT_DATA_INVENTORY_SEQ", allocationSize = 1)
	@Column(name = "INVENTORY_ID")
	private Long inventoryId;

	@Column(name = "REPORT_NAME", nullable = false, length = 200)
	private String reportName;

	@Column(name = "TABLE_NAME", nullable = false, length = 128)
	private String tableName;

	@Column(name = "DATE_COLUMN_NAME", nullable = false, length = 128)
	private String dateColumnName;

	@Column(name = "EXPORT_COLUMNS", nullable = false, length = 4000)
	private String exportColumns;

	@Column(name = "IS_ACTIVE", nullable = false, length = 1)
	private String isActive;

	@Column(name = "SORT_ORDER")
	private Integer sortOrder;

	@Column(name = "REPORT_TYPE_CODE", length = 50)
	private String reportTypeCode;

	/** JSON: extra filter fields and date rules — see RT_DATA_INVENTORY_EXTRA_FILTERS.sql */
	@Column(name = "EXTRA_FILTERS", length = 4000)
	private String extraFilters;

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getDateColumnName() {
		return dateColumnName;
	}

	public void setDateColumnName(String dateColumnName) {
		this.dateColumnName = dateColumnName;
	}

	public String getExportColumns() {
		return exportColumns;
	}

	public void setExportColumns(String exportColumns) {
		this.exportColumns = exportColumns;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getReportTypeCode() {
		return reportTypeCode;
	}

	public void setReportTypeCode(String reportTypeCode) {
		this.reportTypeCode = reportTypeCode;
	}

	public String getExtraFilters() {
		return extraFilters;
	}

	public void setExtraFilters(String extraFilters) {
		this.extraFilters = extraFilters;
	}
}
