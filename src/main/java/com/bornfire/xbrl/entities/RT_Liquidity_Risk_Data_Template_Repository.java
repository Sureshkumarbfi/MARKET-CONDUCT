package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_Liquidity_Risk_Data_Template_Repository extends JpaRepository<RT_Liquidity_Risk_Data_Template, RT_Liquidity_Risk_Data_Template_class> {

	@Query(value = "select * from BCBUAE_LIQUIDITY_RISK_DATA_TEMPLATE where DEL_FLG != 'Y' AND Report_date=?1", nativeQuery = true)
	List<RT_Liquidity_Risk_Data_Template> getLiquiditylist(Date Report_date);
	
	@Query(value = "select * from BCBUAE_LIQUIDITY_RISK_DATA_TEMPLATE where DEL_FLG != 'Y' AND Report_date=?1 AND GL_LEVEL_1 =?2 AND GL_LEVEL_2 =?3 AND GL_LEVEL_3 =?4 AND INSTRUMENT_CURRENCY =?5", nativeQuery = true)
	RT_Liquidity_Risk_Data_Template getbyGlLevelsReportDateIC(Date Report_date,String glLevel1,String glLevel2,String glLevel3,String instrumentCurrency);
	
	@Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM BCBUAE_LIQUIDITY_RISK_DATA_TEMPLATE", nativeQuery = true)
	Timestamp findLastReportDate();
		
     @Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM BCBUAE_LIQUIDITY_RISK_DATA_TEMPLATE WHERE REPORT_DATE < (SELECT MAX(REPORT_DATE) FROM BCBUAE_LIQUIDITY_RISK_DATA_TEMPLATE)", nativeQuery = true)
    Timestamp findSecondLastReportDate();
}
