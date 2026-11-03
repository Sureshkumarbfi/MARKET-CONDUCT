package com.bornfire.xbrl.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RT_MATRIX_MONITOR_BULK_RUN_GROUPS")
public class RT_MATRIX_MONITOR_BULK_RUN_GROUPS_ENTITY {

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "GROUP_NAME")
	private String groupName;

	@Column(name = "SNO")
	private String sno;

	@Column(name = "DEL_FLG")
	private String delFlg;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	public RT_MATRIX_MONITOR_BULK_RUN_GROUPS_ENTITY(Long id, String groupName, String sno, String delFlg) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.sno = sno;
		this.delFlg = delFlg;
	}

	public RT_MATRIX_MONITOR_BULK_RUN_GROUPS_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}

}
