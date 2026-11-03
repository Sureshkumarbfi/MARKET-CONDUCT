package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MIS_ASL_BANK_MASTER")
public class ASL_BANKMASTER_ENTITY {
	@Id
	private String srl_no;
	private String bank_code;
	private String bank_name;
	private String country;
	private String rating;
	private BigDecimal total_exposure;

	public String getSrl_no() {
		return srl_no;
	}

	public String getBank_code() {
		return bank_code;
	}

	public String getBank_name() {
		return bank_name;
	}

	public String getCountry() {
		return country;
	}

	public String getRating() {
		return rating;
	}

	public BigDecimal getTotal_exposure() {
		return total_exposure;
	}

	public void setSrl_no(String srl_no) {
		this.srl_no = srl_no;
	}

	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public void setTotal_exposure(BigDecimal total_exposure) {
		this.total_exposure = total_exposure;
	}

	public ASL_BANKMASTER_ENTITY(String srl_no, String bank_code, String bank_name, String country, String rating,
			BigDecimal total_exposure) {
		super();
		this.srl_no = srl_no;
		this.bank_code = bank_code;
		this.bank_name = bank_name;
		this.country = country;
		this.rating = rating;
		this.total_exposure = total_exposure;
	}

	public ASL_BANKMASTER_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}

}
