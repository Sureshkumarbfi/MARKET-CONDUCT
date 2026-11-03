package com.bornfire.xbrl.entities;

import java.math.BigDecimal;

public class RT_Chart_pojo {

	private String date;
	private BigDecimal value;
	private String Classification;
	private BigDecimal Exposureperc;
	private BigDecimal Exposurebal;
	private String branch_name;
	private BigDecimal book_Exposure_in_aed;
	private BigDecimal book_rwa_in_aed;
	private BigDecimal branch_rwa_density;
	private BigDecimal active_account;
	private BigDecimal active_exposure;
	private BigDecimal npa_accounts;
	private BigDecimal npa_exposure;
	private BigDecimal watchlist_accounts;
	private BigDecimal watchlist_exposure;
	private BigDecimal overdue_accounts;
	private BigDecimal overdue_exposure;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getClassification() {
		return Classification;
	}

	public void setClassification(String classification) {
		Classification = classification;
	}

	public BigDecimal getExposureperc() {
		return Exposureperc;
	}

	public void setExposureperc(BigDecimal exposureperc) {
		Exposureperc = exposureperc;
	}

	public BigDecimal getExposurebal() {
		return Exposurebal;
	}

	public void setExposurebal(BigDecimal exposurebal) {
		Exposurebal = exposurebal;
	}
	

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public BigDecimal getBook_Exposure_in_aed() {
		return book_Exposure_in_aed;
	}

	public void setBook_Exposure_in_aed(BigDecimal book_Exposure_in_aed) {
		this.book_Exposure_in_aed = book_Exposure_in_aed;
	}

	public BigDecimal getBook_rwa_in_aed() {
		return book_rwa_in_aed;
	}

	public void setBook_rwa_in_aed(BigDecimal book_rwa_in_aed) {
		this.book_rwa_in_aed = book_rwa_in_aed;
	}

	public BigDecimal getBranch_rwa_density() {
		return branch_rwa_density;
	}

	public void setBranch_rwa_density(BigDecimal branch_rwa_density) {
		this.branch_rwa_density = branch_rwa_density;
	}

	public BigDecimal getActive_account() {
		return active_account;
	}

	public void setActive_account(BigDecimal active_account) {
		this.active_account = active_account;
	}

	public BigDecimal getActive_exposure() {
		return active_exposure;
	}

	public void setActive_exposure(BigDecimal active_exposure) {
		this.active_exposure = active_exposure;
	}

	public BigDecimal getNpa_accounts() {
		return npa_accounts;
	}

	public void setNpa_accounts(BigDecimal npa_accounts) {
		this.npa_accounts = npa_accounts;
	}

	public BigDecimal getNpa_exposure() {
		return npa_exposure;
	}

	public void setNpa_exposure(BigDecimal npa_exposure) {
		this.npa_exposure = npa_exposure;
	}

	public BigDecimal getWatchlist_accounts() {
		return watchlist_accounts;
	}

	public void setWatchlist_accounts(BigDecimal watchlist_accounts) {
		this.watchlist_accounts = watchlist_accounts;
	}

	public BigDecimal getWatchlist_exposure() {
		return watchlist_exposure;
	}

	public void setWatchlist_exposure(BigDecimal watchlist_exposure) {
		this.watchlist_exposure = watchlist_exposure;
	}

	public BigDecimal getOverdue_accounts() {
		return overdue_accounts;
	}

	public void setOverdue_accounts(BigDecimal overdue_accounts) {
		this.overdue_accounts = overdue_accounts;
	}

	public BigDecimal getOverdue_exposure() {
		return overdue_exposure;
	}

	public void setOverdue_exposure(BigDecimal overdue_exposure) {
		this.overdue_exposure = overdue_exposure;
	}

	public RT_Chart_pojo(String date, BigDecimal value) {
		super();
		this.date = date;
		this.value = value;
	}


	@Override
	public String toString() {
		return "RT_Chart_pojo [date=" + date + ", value=" + value + ", Classification=" + Classification
				+ ", Exposureperc=" + Exposureperc + ", Exposurebal=" + Exposurebal + ", branch_name=" + branch_name
				+ ", book_Exposure_in_aed=" + book_Exposure_in_aed + ", book_rwa_in_aed=" + book_rwa_in_aed
				+ ", branch_rwa_density=" + branch_rwa_density + ", active_account=" + active_account
				+ ", active_exposure=" + active_exposure + ", npa_accounts=" + npa_accounts + ", npa_exposure="
				+ npa_exposure + ", watchlist_accounts=" + watchlist_accounts + ", watchlist_exposure="
				+ watchlist_exposure + ", overdue_accounts=" + overdue_accounts + ", overdue_exposure="
				+ overdue_exposure + "]";
	}

	public RT_Chart_pojo(String date, BigDecimal value, String classification, BigDecimal exposureperc,
			BigDecimal exposurebal) {
		super();
		this.date = date;
		this.value = value;
		Classification = classification;
		Exposureperc = exposureperc;
		Exposurebal = exposurebal;
	}

	public RT_Chart_pojo(String classification, BigDecimal exposureperc, BigDecimal exposurebal) {
		super();
		Classification = classification;
		Exposureperc = exposureperc;
		Exposurebal = exposurebal;
	}

	public RT_Chart_pojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RT_Chart_pojo(String branch_name, BigDecimal book_Exposure_in_aed, BigDecimal book_rwa_in_aed,
			BigDecimal branch_rwa_density, BigDecimal active_account, BigDecimal active_exposure,
			BigDecimal npa_accounts, BigDecimal npa_exposure, BigDecimal watchlist_accounts,
			BigDecimal watchlist_exposure, BigDecimal overdue_accounts, BigDecimal overdue_exposure) {
		super();
		this.branch_name = branch_name;
		this.book_Exposure_in_aed = book_Exposure_in_aed;
		this.book_rwa_in_aed = book_rwa_in_aed;
		this.branch_rwa_density = branch_rwa_density;
		this.active_account = active_account;
		this.active_exposure = active_exposure;
		this.npa_accounts = npa_accounts;
		this.npa_exposure = npa_exposure;
		this.watchlist_accounts = watchlist_accounts;
		this.watchlist_exposure = watchlist_exposure;
		this.overdue_accounts = overdue_accounts;
		this.overdue_exposure = overdue_exposure;
	}
	
	
	 

}
