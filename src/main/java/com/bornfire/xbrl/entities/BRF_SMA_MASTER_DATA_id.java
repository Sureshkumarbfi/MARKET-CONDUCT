package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.util.Date;

public class BRF_SMA_MASTER_DATA_id implements Serializable{

	  private String accountNo;
	  private Date asOnDate;
	  public String getAccountNo() {
		  return accountNo;
	  }
	  public void setAccountNo(String accountNo) {
		  this.accountNo = accountNo;
	  }
	  public Date getAsOnDate() {
		  return asOnDate;
	  }
	  public void setAsOnDate(Date asOnDate) {
		  this.asOnDate = asOnDate;
	  }

}
