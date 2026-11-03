package com.bornfire.xbrl.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RT_Investment_Risk_Data_Dashboard_TemplateRepository extends JpaRepository<RT_Investment_Risk_Data_Dashboard_Template,  Long>  {

	@Query(value = "SELECT * FROM BCBUAE_INVESTMENT_RISK_DATA_DASHBOARD_TEMPLATE WHERE REPORT_DATE=?1 ", nativeQuery = true)
    List<RT_Investment_Risk_Data_Dashboard_Template> getlist(Date REPORT_DATE);
    
    @Query(value = "SELECT * FROM BCBUAE_INVESTMENT_RISK_DATA_DASHBOARD_TEMPLATE where SI_NO =?1 ", nativeQuery = true)
    RT_Investment_Risk_Data_Dashboard_Template getParticularDataBySI_NO(Long SI_no);
    
    @Query(value = "SELECT * FROM BCBUAE_INVESTMENT_RISK_DATA_DASHBOARD_TEMPLATE WHERE REPORT_DATE=?1  ", nativeQuery = true)
	List<Object[]> getinvestmentriskdata1(Date Report_date);
    
    
	@Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM BCBUAE_INVESTMENT_RISK_DATA_DASHBOARD_TEMPLATE", nativeQuery = true)
	Timestamp findLastReportDate();
	
	@Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM BCBUAE_INVESTMENT_RISK_DATA_DASHBOARD_TEMPLATE WHERE REPORT_DATE < (SELECT MAX(REPORT_DATE) FROM BCBUAE_INVESTMENT_RISK_DATA_DASHBOARD_TEMPLATE)", nativeQuery = true)
	Timestamp findSecondLastReportDate();
}
