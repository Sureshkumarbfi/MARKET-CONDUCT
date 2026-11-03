package com.bornfire.xbrl.dto;

import java.util.ArrayList;
import java.util.List;

public class DataInventoryItemDto {

	private Long inventoryId;
	private String reportName;
	private String tableName;
	private List<DataInventoryFilterFieldDto> extraFilters = new ArrayList<DataInventoryFilterFieldDto>();
	private boolean dateNotFuture;
	private Integer dateMaxDaysBack;

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

	public List<DataInventoryFilterFieldDto> getExtraFilters() {
		return extraFilters;
	}

	public void setExtraFilters(List<DataInventoryFilterFieldDto> extraFilters) {
		this.extraFilters = extraFilters != null ? extraFilters : new ArrayList<DataInventoryFilterFieldDto>();
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
