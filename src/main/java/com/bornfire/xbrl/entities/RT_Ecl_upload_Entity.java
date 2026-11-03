package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


public class RT_Ecl_upload_Entity {
	
	private String	facilityid;
	private String	customerid;
	private String	cust_name;
	private String	branch_name;
	private String	portfoliotype;
	private String	portfolioname;
	private String	subportfolioname;
	private String	productname;
	private String	rating;
	private BigDecimal	dpdbucket;
	private String	currency;
	private BigDecimal	limit;
	private BigDecimal	drawnamount;
	private BigDecimal	undrawnamount;
	private BigDecimal	ccf;
	private BigDecimal	ead;
	private String	interestaccrued;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date	report_date;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date	maturitydate;
	private BigDecimal	paymentfrequency;
	private BigDecimal	eir;
	private String	collateraltype;
	private BigDecimal	collateralvalue;
	private BigDecimal	basepd;
	private BigDecimal	positivepd;
	private BigDecimal	negativepd;
	private String	weighted_pd;
	private BigDecimal	unsecuredlgdrate;
	private BigDecimal	lgdrate;
	private BigDecimal	pastduedays;
	private String	stage;
	private String	stagereason;
	private BigDecimal	lecl_base;
	private BigDecimal	lecl_positive;
	private BigDecimal	lecl_negative;
	private BigDecimal	life_time_weigthed;
	private BigDecimal	ecl12m_base;
	private BigDecimal	ecl12m_positive;
	private BigDecimal	ecl12m_negative;
	private BigDecimal	a12monthweighted;
	private BigDecimal	ifrs9_ecl_number_base;
	private BigDecimal	ifrs9_ecl_number_positive;
	private BigDecimal	ifrs9_ecl_number_negative;
	private BigDecimal	finalweightedecl;
	private String	deferral;
	private BigDecimal	ecl_incul_deferral;
	private BigDecimal	ecl_mgmt_overlay;
	private BigDecimal	specific_provision;
	private BigDecimal	interest_suspense;
	private BigDecimal	modificationflag;
	private BigDecimal	modificationvalue;
	private BigDecimal	writtenoffflag;
	private BigDecimal	writtenoffvalue;
	private BigDecimal	infoflag;
	private String	country;
	private BigDecimal	isindividualflag;
	private String	asset_class;
	private String	transfer_stage;
	private String	brf_1_classification;
	private String	brf_107;
	private String	brf_106;
	private String	basel_2_category;
	private String	provision_coverage;
	private String	mgmtoverlay;
	private BigDecimal	total_rwa;
	private String wait_pd;
	
	public String getFacilityid() {
		return facilityid;
	}
	public void setFacilityid(String facilityid) {
		this.facilityid = facilityid;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getPortfoliotype() {
		return portfoliotype;
	}
	public void setPortfoliotype(String portfoliotype) {
		this.portfoliotype = portfoliotype;
	}
	public String getPortfolioname() {
		return portfolioname;
	}
	public void setPortfolioname(String portfolioname) {
		this.portfolioname = portfolioname;
	}
	public String getSubportfolioname() {
		return subportfolioname;
	}
	public void setSubportfolioname(String subportfolioname) {
		this.subportfolioname = subportfolioname;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public BigDecimal getDpdbucket() {
		return dpdbucket;
	}
	public void setDpdbucket(BigDecimal dpdbucket) {
		this.dpdbucket = dpdbucket;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getLimit() {
		return limit;
	}
	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}
	public BigDecimal getDrawnamount() {
		return drawnamount;
	}
	public void setDrawnamount(BigDecimal drawnamount) {
		this.drawnamount = drawnamount;
	}
	public BigDecimal getUndrawnamount() {
		return undrawnamount;
	}
	public void setUndrawnamount(BigDecimal undrawnamount) {
		this.undrawnamount = undrawnamount;
	}
	public BigDecimal getCcf() {
		return ccf;
	}
	public void setCcf(BigDecimal ccf) {
		this.ccf = ccf;
	}
	public BigDecimal getEad() {
		return ead;
	}
	public void setEad(BigDecimal ead) {
		this.ead = ead;
	}
	public String getInterestaccrued() {
		return interestaccrued;
	}
	public void setInterestaccrued(String interestaccrued) {
		this.interestaccrued = interestaccrued;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public Date getMaturitydate() {
		return maturitydate;
	}
	public void setMaturitydate(Date maturitydate) {
		this.maturitydate = maturitydate;
	}
	public BigDecimal getPaymentfrequency() {
		return paymentfrequency;
	}
	public void setPaymentfrequency(BigDecimal paymentfrequency) {
		this.paymentfrequency = paymentfrequency;
	}
	public BigDecimal getEir() {
		return eir;
	}
	public void setEir(BigDecimal eir) {
		this.eir = eir;
	}
	public String getCollateraltype() {
		return collateraltype;
	}
	public void setCollateraltype(String collateraltype) {
		this.collateraltype = collateraltype;
	}
	public BigDecimal getCollateralvalue() {
		return collateralvalue;
	}
	public void setCollateralvalue(BigDecimal collateralvalue) {
		this.collateralvalue = collateralvalue;
	}
	public BigDecimal getBasepd() {
		return basepd;
	}
	public void setBasepd(BigDecimal basepd) {
		this.basepd = basepd;
	}
	public BigDecimal getPositivepd() {
		return positivepd;
	}
	public void setPositivepd(BigDecimal positivepd) {
		this.positivepd = positivepd;
	}
	public BigDecimal getNegativepd() {
		return negativepd;
	}
	public void setNegativepd(BigDecimal negativepd) {
		this.negativepd = negativepd;
	}
	public String getWeighted_pd() {
		return weighted_pd;
	}
	public void setWeighted_pd(String weighted_pd) {
		this.weighted_pd = weighted_pd;
	}
	public BigDecimal getUnsecuredlgdrate() {
		return unsecuredlgdrate;
	}
	public void setUnsecuredlgdrate(BigDecimal unsecuredlgdrate) {
		this.unsecuredlgdrate = unsecuredlgdrate;
	}
	public BigDecimal getLgdrate() {
		return lgdrate;
	}
	public void setLgdrate(BigDecimal lgdrate) {
		this.lgdrate = lgdrate;
	}
	public BigDecimal getPastduedays() {
		return pastduedays;
	}
	public void setPastduedays(BigDecimal pastduedays) {
		this.pastduedays = pastduedays;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getStagereason() {
		return stagereason;
	}
	public void setStagereason(String stagereason) {
		this.stagereason = stagereason;
	}
	public BigDecimal getLecl_base() {
		return lecl_base;
	}
	public void setLecl_base(BigDecimal lecl_base) {
		this.lecl_base = lecl_base;
	}
	public BigDecimal getLecl_positive() {
		return lecl_positive;
	}
	public void setLecl_positive(BigDecimal lecl_positive) {
		this.lecl_positive = lecl_positive;
	}
	public BigDecimal getLecl_negative() {
		return lecl_negative;
	}
	public void setLecl_negative(BigDecimal lecl_negative) {
		this.lecl_negative = lecl_negative;
	}
	public BigDecimal getLife_time_weigthed() {
		return life_time_weigthed;
	}
	public void setLife_time_weigthed(BigDecimal life_time_weigthed) {
		this.life_time_weigthed = life_time_weigthed;
	}
	public BigDecimal getEcl12m_base() {
		return ecl12m_base;
	}
	public void setEcl12m_base(BigDecimal ecl12m_base) {
		this.ecl12m_base = ecl12m_base;
	}
	public BigDecimal getEcl12m_positive() {
		return ecl12m_positive;
	}
	public void setEcl12m_positive(BigDecimal ecl12m_positive) {
		this.ecl12m_positive = ecl12m_positive;
	}
	public BigDecimal getEcl12m_negative() {
		return ecl12m_negative;
	}
	public void setEcl12m_negative(BigDecimal ecl12m_negative) {
		this.ecl12m_negative = ecl12m_negative;
	}
	public BigDecimal getA12monthweighted() {
		return a12monthweighted;
	}
	public void setA12monthweighted(BigDecimal a12monthweighted) {
		this.a12monthweighted = a12monthweighted;
	}
	public BigDecimal getIfrs9_ecl_number_base() {
		return ifrs9_ecl_number_base;
	}
	public void setIfrs9_ecl_number_base(BigDecimal ifrs9_ecl_number_base) {
		this.ifrs9_ecl_number_base = ifrs9_ecl_number_base;
	}
	public BigDecimal getIfrs9_ecl_number_positive() {
		return ifrs9_ecl_number_positive;
	}
	public void setIfrs9_ecl_number_positive(BigDecimal ifrs9_ecl_number_positive) {
		this.ifrs9_ecl_number_positive = ifrs9_ecl_number_positive;
	}
	public BigDecimal getIfrs9_ecl_number_negative() {
		return ifrs9_ecl_number_negative;
	}
	public void setIfrs9_ecl_number_negative(BigDecimal ifrs9_ecl_number_negative) {
		this.ifrs9_ecl_number_negative = ifrs9_ecl_number_negative;
	}
	public BigDecimal getFinalweightedecl() {
		return finalweightedecl;
	}
	public void setFinalweightedecl(BigDecimal finalweightedecl) {
		this.finalweightedecl = finalweightedecl;
	}
	public String getDeferral() {
		return deferral;
	}
	public void setDeferral(String deferral) {
		this.deferral = deferral;
	}
	public BigDecimal getEcl_incul_deferral() {
		return ecl_incul_deferral;
	}
	public void setEcl_incul_deferral(BigDecimal ecl_incul_deferral) {
		this.ecl_incul_deferral = ecl_incul_deferral;
	}
	public BigDecimal getEcl_mgmt_overlay() {
		return ecl_mgmt_overlay;
	}
	public void setEcl_mgmt_overlay(BigDecimal ecl_mgmt_overlay) {
		this.ecl_mgmt_overlay = ecl_mgmt_overlay;
	}
	public BigDecimal getSpecific_provision() {
		return specific_provision;
	}
	public void setSpecific_provision(BigDecimal specific_provision) {
		this.specific_provision = specific_provision;
	}
	public BigDecimal getInterest_suspense() {
		return interest_suspense;
	}
	public void setInterest_suspense(BigDecimal interest_suspense) {
		this.interest_suspense = interest_suspense;
	}
	public BigDecimal getModificationflag() {
		return modificationflag;
	}
	public void setModificationflag(BigDecimal modificationflag) {
		this.modificationflag = modificationflag;
	}
	public BigDecimal getModificationvalue() {
		return modificationvalue;
	}
	public void setModificationvalue(BigDecimal modificationvalue) {
		this.modificationvalue = modificationvalue;
	}
	public BigDecimal getWrittenoffflag() {
		return writtenoffflag;
	}
	public void setWrittenoffflag(BigDecimal writtenoffflag) {
		this.writtenoffflag = writtenoffflag;
	}
	public BigDecimal getWrittenoffvalue() {
		return writtenoffvalue;
	}
	public void setWrittenoffvalue(BigDecimal writtenoffvalue) {
		this.writtenoffvalue = writtenoffvalue;
	}
	public BigDecimal getInfoflag() {
		return infoflag;
	}
	public void setInfoflag(BigDecimal infoflag) {
		this.infoflag = infoflag;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public BigDecimal getIsindividualflag() {
		return isindividualflag;
	}
	public void setIsindividualflag(BigDecimal isindividualflag) {
		this.isindividualflag = isindividualflag;
	}
	public String getAsset_class() {
		return asset_class;
	}
	public void setAsset_class(String asset_class) {
		this.asset_class = asset_class;
	}
	public String getTransfer_stage() {
		return transfer_stage;
	}
	public void setTransfer_stage(String transfer_stage) {
		this.transfer_stage = transfer_stage;
	}
	public String getBrf_1_classification() {
		return brf_1_classification;
	}
	public void setBrf_1_classification(String brf_1_classification) {
		this.brf_1_classification = brf_1_classification;
	}
	public String getBrf_107() {
		return brf_107;
	}
	public void setBrf_107(String brf_107) {
		this.brf_107 = brf_107;
	}
	public String getBrf_106() {
		return brf_106;
	}
	public void setBrf_106(String brf_106) {
		this.brf_106 = brf_106;
	}
	public String getBasel_2_category() {
		return basel_2_category;
	}
	public void setBasel_2_category(String basel_2_category) {
		this.basel_2_category = basel_2_category;
	}
	public String getProvision_coverage() {
		return provision_coverage;
	}
	public void setProvision_coverage(String provision_coverage) {
		this.provision_coverage = provision_coverage;
	}
	public String getMgmtoverlay() {
		return mgmtoverlay;
	}
	public void setMgmtoverlay(String mgmtoverlay) {
		this.mgmtoverlay = mgmtoverlay;
	}
	public BigDecimal getTotal_rwa() {
		return total_rwa;
	}
	public void setTotal_rwa(BigDecimal total_rwa) {
		this.total_rwa = total_rwa;
	}
	public String getWait_pd() {
		return wait_pd;
	}
	public void setWait_pd(String wait_pd) {
		this.wait_pd = wait_pd;
	}
	public RT_Ecl_upload_Entity(String facilityid, String customerid, String cust_name, String branch_name,
			String portfoliotype, String portfolioname, String subportfolioname, String productname, String rating,
			BigDecimal dpdbucket, String currency, BigDecimal limit, BigDecimal drawnamount, BigDecimal undrawnamount,
			BigDecimal ccf, BigDecimal ead, String interestaccrued, Date report_date, Date maturitydate,
			BigDecimal paymentfrequency, BigDecimal eir, String collateraltype, BigDecimal collateralvalue,
			BigDecimal basepd, BigDecimal positivepd, BigDecimal negativepd, String weighted_pd,
			BigDecimal unsecuredlgdrate, BigDecimal lgdrate, BigDecimal pastduedays, String stage, String stagereason,
			BigDecimal lecl_base, BigDecimal lecl_positive, BigDecimal lecl_negative, BigDecimal life_time_weigthed,
			BigDecimal ecl12m_base, BigDecimal ecl12m_positive, BigDecimal ecl12m_negative, BigDecimal a12monthweighted,
			BigDecimal ifrs9_ecl_number_base, BigDecimal ifrs9_ecl_number_positive,
			BigDecimal ifrs9_ecl_number_negative, BigDecimal finalweightedecl, String deferral,
			BigDecimal ecl_incul_deferral, BigDecimal ecl_mgmt_overlay, BigDecimal specific_provision,
			BigDecimal interest_suspense, BigDecimal modificationflag, BigDecimal modificationvalue,
			BigDecimal writtenoffflag, BigDecimal writtenoffvalue, BigDecimal infoflag, String country,
			BigDecimal isindividualflag, String asset_class, String transfer_stage, String brf_1_classification,
			String brf_107, String brf_106, String basel_2_category, String provision_coverage, String mgmtoverlay,
			BigDecimal total_rwa, String wait_pd) {
		super();
		this.facilityid = facilityid;
		this.customerid = customerid;
		this.cust_name = cust_name;
		this.branch_name = branch_name;
		this.portfoliotype = portfoliotype;
		this.portfolioname = portfolioname;
		this.subportfolioname = subportfolioname;
		this.productname = productname;
		this.rating = rating;
		this.dpdbucket = dpdbucket;
		this.currency = currency;
		this.limit = limit;
		this.drawnamount = drawnamount;
		this.undrawnamount = undrawnamount;
		this.ccf = ccf;
		this.ead = ead;
		this.interestaccrued = interestaccrued;
		this.report_date = report_date;
		this.maturitydate = maturitydate;
		this.paymentfrequency = paymentfrequency;
		this.eir = eir;
		this.collateraltype = collateraltype;
		this.collateralvalue = collateralvalue;
		this.basepd = basepd;
		this.positivepd = positivepd;
		this.negativepd = negativepd;
		this.weighted_pd = weighted_pd;
		this.unsecuredlgdrate = unsecuredlgdrate;
		this.lgdrate = lgdrate;
		this.pastduedays = pastduedays;
		this.stage = stage;
		this.stagereason = stagereason;
		this.lecl_base = lecl_base;
		this.lecl_positive = lecl_positive;
		this.lecl_negative = lecl_negative;
		this.life_time_weigthed = life_time_weigthed;
		this.ecl12m_base = ecl12m_base;
		this.ecl12m_positive = ecl12m_positive;
		this.ecl12m_negative = ecl12m_negative;
		this.a12monthweighted = a12monthweighted;
		this.ifrs9_ecl_number_base = ifrs9_ecl_number_base;
		this.ifrs9_ecl_number_positive = ifrs9_ecl_number_positive;
		this.ifrs9_ecl_number_negative = ifrs9_ecl_number_negative;
		this.finalweightedecl = finalweightedecl;
		this.deferral = deferral;
		this.ecl_incul_deferral = ecl_incul_deferral;
		this.ecl_mgmt_overlay = ecl_mgmt_overlay;
		this.specific_provision = specific_provision;
		this.interest_suspense = interest_suspense;
		this.modificationflag = modificationflag;
		this.modificationvalue = modificationvalue;
		this.writtenoffflag = writtenoffflag;
		this.writtenoffvalue = writtenoffvalue;
		this.infoflag = infoflag;
		this.country = country;
		this.isindividualflag = isindividualflag;
		this.asset_class = asset_class;
		this.transfer_stage = transfer_stage;
		this.brf_1_classification = brf_1_classification;
		this.brf_107 = brf_107;
		this.brf_106 = brf_106;
		this.basel_2_category = basel_2_category;
		this.provision_coverage = provision_coverage;
		this.mgmtoverlay = mgmtoverlay;
		this.total_rwa = total_rwa;
		this.wait_pd = wait_pd;
	}
	public RT_Ecl_upload_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
