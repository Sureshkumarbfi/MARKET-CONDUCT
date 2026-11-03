package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.util.Date;

public class BRF_FB_NFB_PROVISIONING_id implements Serializable{
	
	 private String foracid;
	 private Date lstExeDate;
	 public String getForacid() {
		 return foracid;
	 }
	 public void setForacid(String foracid) {
		 this.foracid = foracid;
	 }
	 public Date getLstExeDate() {
		 return lstExeDate;
	 }
	 public void setLstExeDate(Date lstExeDate) {
		 this.lstExeDate = lstExeDate;
	 }
	 
	 

}
