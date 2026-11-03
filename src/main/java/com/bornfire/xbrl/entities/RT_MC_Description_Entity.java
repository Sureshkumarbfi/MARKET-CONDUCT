package com.bornfire.xbrl.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RT_MC_DESCRIPTION")
public class RT_MC_Description_Entity {

	@Id
	@Column(name = "S_NO")
	private BigDecimal sNo;

	@Column(name = "SECTION_NAME")
	private String sectionName;

	@Column(name = "DATA_ELEMENT")
	private String dataElement;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "CELL_NAME")
	private String cellName;

	@Column(name = "COLUMN_ID")
	private String ColumnId;

	public String getCellName() {
		return cellName;
	}

	public void setCellName(String cellName) {
		this.cellName = cellName;
	}

	public BigDecimal getsNo() {
		return sNo;
	}

	public void setsNo(BigDecimal sNo) {
		this.sNo = sNo;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getDataElement() {
		return dataElement;
	}

	public void setDataElement(String dataElement) {
		this.dataElement = dataElement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColumnId() {
		return ColumnId;
	}

	public void setColumnId(String columnId) {
		ColumnId = columnId;
	}

}