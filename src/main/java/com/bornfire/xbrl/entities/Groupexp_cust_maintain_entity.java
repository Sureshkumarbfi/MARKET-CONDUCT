package com.bornfire.xbrl.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GROUP_EXPOSURE_MAINTENANCE_TABLE")
public class Groupexp_cust_maintain_entity {
	
	@Id
	private String group_id;
	private String group_name;
	private String belonging_customer_id;
	private String del_flg;
	
	
	
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getBelonging_customer_id() {
		return belonging_customer_id;
	}
	public void setBelonging_customer_id(String belonging_customer_id) {
		this.belonging_customer_id = belonging_customer_id;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	@Override
	public String toString() {
		return "Groupexp_cust_maintain_entity [group_id=" + group_id + ", group_name=" + group_name
				+ ", belonging_customer_id=" + belonging_customer_id + ", del_flg=" + del_flg + "]";
	}
	public Groupexp_cust_maintain_entity(String group_id, String group_name, String belonging_customer_id,
			String del_flg) {
		super();
		this.group_id = group_id;
		this.group_name = group_name;
		this.belonging_customer_id = belonging_customer_id;
		this.del_flg = del_flg;
	}
	public Groupexp_cust_maintain_entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
