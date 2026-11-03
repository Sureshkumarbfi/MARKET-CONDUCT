package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF39_ENTITYREP extends JpaRepository<BRF39_ENTITY, String> {

	@Query(value = "select * from BRF39_SUMMARYTABLE where trunc(report_date)=?1", nativeQuery = true)
	List<Object[]> findllvalues(String reportdate);

	// CAPITAL CASE
	@Query(value = "select DISTINCT capital_case  from BRF39_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getcapitalcase(String value);
	
	

//SUM TOTAL
	@Query(value = " select nvl(sum(funded_os),0)  from BRF39_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getFunded_os(String value);

	@Query(value = " select nvl(sum(credit_risk),0)  from BRF39_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getCredit_risk(String value);

	@Query(value = " select nvl(sum(debt_securities),0)  from BRF39_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getDebt_securities(String value);

	@Query(value = " select nvl(sum(equities),0)  from BRF39_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getEquities(String value);

	@Query(value = " select nvl(sum(unfunded_os),0)  from BRF39_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getUnfunded_os(String value);

	@Query(value = " select nvl(sum(ccf_equivalent_of_unfunded_os),0)  from BRF39_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getCcf_equivalent_of_unfunded_os(String value);

	@Query(value = " select nvl(sum(ccf_equivalent_limits),0)  from BRF39_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getCcf_equivalent_limits(String value);

	@Query(value = "  select (nvl(sum(funded_os),0)+ nvl(sum(debt_securities),0)+nvl(sum(equities),0)+nvl(sum(ccf_equivalent_of_unfunded_os),0)+nvl(sum(ccf_equivalent_limits),0)) as total_exposure_without_credit_risk from BRF39_SUMMARYTABLE WHERE trunc(report_date) =?1", nativeQuery = true)
	String gettotalexposurewithout_creditrisk(String value);

	@Query(value = "  select (nvl(sum(funded_os),0)- nvl(sum(credit_risk),0)+nvl(sum(debt_securities),0)+nvl(sum(equities),0)+nvl(sum(ccf_equivalent_of_unfunded_os),0)+nvl(sum(ccf_equivalent_limits),0)) as total_exposure_net from BRF39_SUMMARYTABLE WHERE trunc(report_date) =?1", nativeQuery = true)
	String gettotal_exposure_net(String value);
	
	@Query(value = "SELECT name_of_borrower, borrower_type, residency_status, country_incorporated, economic_status, currency, funded_os FROM BRF39_SUMMARYTABLE ORDER BY funded_os DESC FETCH FIRST 10 ROWS ONLY", nativeQuery = true)
	List<Object[]> top10Bank();

   
	
	


}
