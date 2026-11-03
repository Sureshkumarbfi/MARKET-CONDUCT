package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Eod_Acct_Bal_Excep_Table_Id implements Serializable {

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name = "REPORT_DATE")
	private Date report_date;

	@Column(name = "ACID", length = 14)
	private String acid;

	@Column(name = "TRAN_ID", length = 14)
	private String tran_id;

	@Column(name = "PART_TRAN_SRL_NUM", length = 14)
	private String part_tran_srl_num;

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public String getAcid() {
		return acid;
	}

	public void setAcid(String acid) {
		this.acid = acid;
	}

	public String getTran_id() {
		return tran_id;
	}

	public void setTran_id(String tran_id) {
		this.tran_id = tran_id;
	}

	public String getPart_tran_srl_num() {
		return part_tran_srl_num;
	}

	public void setPart_tran_srl_num(String part_tran_srl_num) {
		this.part_tran_srl_num = part_tran_srl_num;
	}

	@Override
	public int hashCode() {
		return Objects.hash(acid, part_tran_srl_num, report_date, tran_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Eod_Acct_Bal_Excep_Table_Id)) {
			return false;
		}
		Eod_Acct_Bal_Excep_Table_Id other = (Eod_Acct_Bal_Excep_Table_Id) obj;
		return Objects.equals(acid, other.acid) && Objects.equals(part_tran_srl_num, other.part_tran_srl_num)
				&& Objects.equals(report_date, other.report_date) && Objects.equals(tran_id, other.tran_id);
	}
}
