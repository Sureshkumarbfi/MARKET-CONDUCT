package com.bornfire.xbrl.entities;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_Liquidity_Risk_Dashboard_Template_repository  extends JpaRepository<RT_Liquidity_Risk_Dashboard_Template,String>{
	
	@Query(value="SELECT * FROM BCBUAE_LIQUIDITY_RISK_DASHBOARD_TEMPLATE Where REPORT_DATE=TO_DATE(?1, 'DD-MM-YYYY')" ,nativeQuery=true)
	List<RT_Liquidity_Risk_Dashboard_Template> getAlldetails(String REPORT_DATE);
	
	@Query(value = "SELECT * FROM BCBUAE_LIQUIDITY_RISK_DASHBOARD_TEMPLATE where SI_NO =?1 ", nativeQuery = true)
	RT_Liquidity_Risk_Dashboard_Template getParticularDataBySI_NO(String SI_NO);
	
	@Query(value = "SELECT * FROM BCBUAE_LIQUIDITY_RISK_DASHBOARD_TEMPLATE Where REPORT_DATE=TO_DATE(?1, 'DD-MM-YYYY') ", nativeQuery = true)
	List<Object[]> getliquidityriskdashboarddata1(String REPORT_DATE);
	

	@Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM BCBUAE_LIQUIDITY_RISK_DASHBOARD_TEMPLATE", nativeQuery = true)
	Timestamp findLastReportDate();
	
	@Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM BCBUAE_LIQUIDITY_RISK_DASHBOARD_TEMPLATE WHERE REPORT_DATE < (SELECT MAX(REPORT_DATE) FROM BCBUAE_LIQUIDITY_RISK_DASHBOARD_TEMPLATE)", nativeQuery = true)
	Timestamp findSecondLastReportDate();

}
