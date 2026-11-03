package com.bornfire.xbrl.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BRF95_RWA_RATING_GUIDELINES")
public class RT_RWA_RATING_GUIDELINES {
	@Id
	private String  rating;
	private String lt_rwa;
	private String st_rwa;
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getLt_rwa() {
		return lt_rwa;
	}
	public void setLt_rwa(String lt_rwa) {
		this.lt_rwa = lt_rwa;
	}
	public String getSt_rwa() {
		return st_rwa;
	}
	public void setSt_rwa(String st_rwa) {
		this.st_rwa = st_rwa;
	}
	public RT_RWA_RATING_GUIDELINES(String rating, String lt_rwa, String st_rwa) {
		super();
		this.rating = rating;
		this.lt_rwa = lt_rwa;
		this.st_rwa = st_rwa;
	}
	public RT_RWA_RATING_GUIDELINES() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
