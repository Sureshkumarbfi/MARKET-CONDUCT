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
@Table(name = "MIS_ASL_EXPOSURE_BANK_NAME_MAP")
public class Mis_exposure_bank_name_map_entity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mis_asl_exp_bank_map_seq")
	@SequenceGenerator(name = "mis_asl_exp_bank_map_seq", sequenceName = "MIS_ASL_EXP_BANK_MAP_SEQ", allocationSize = 1)
	private Long id;

	@Column(name = "OLD_BANK_NAME", nullable = false, length = 500)
	private String oldBankName;

	@Column(name = "NEW_BANK_NAME", nullable = false, length = 500)
	private String newBankName;

	@Column(name = "BILL_SRL_NO", length = 50)
	private String billSrlNo;

	@Column(name = "CREATE_USER", length = 100)
	private String createUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TIME")
	private Date createTime;

	@Column(name = "MODIFY_USER", length = 100)
	private String modifyUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFY_TIME")
	private Date modifyTime;

	@Column(name = "DEL_FLG", length = 1)
	private String delFlg = "N";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOldBankName() {
		return oldBankName;
	}

	public void setOldBankName(String oldBankName) {
		this.oldBankName = oldBankName;
	}

	public String getNewBankName() {
		return newBankName;
	}

	public void setNewBankName(String newBankName) {
		this.newBankName = newBankName;
	}

	public String getBillSrlNo() {
		return billSrlNo;
	}

	public void setBillSrlNo(String billSrlNo) {
		this.billSrlNo = billSrlNo;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}
}
