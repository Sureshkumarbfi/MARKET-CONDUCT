package com.bornfire.xbrl.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_FxRiskDataRepository extends JpaRepository<RT_Fxriskdata, String> {
	// Add custom queries if needed

	@Query(value = "select * from BCBUAE_FX_RISK_DATA  ", nativeQuery = true)
	List<RT_Fxriskdata> getlist();
	
	@Query(value = "select * from BCBUAE_FX_RISK_DATA where  REPORT_DATE=?1 ", nativeQuery = true)
	List<RT_Fxriskdata> getlist(Date REPORT_DATE);

	@Query(value = "SELECT * FROM BCBUAE_FX_RISK_DATA ", nativeQuery = true)
	List<RT_Fxriskdata> getfxriskdatalistdata();

	@Query(value = "SELECT * FROM BCBUAE_FX_RISK_DATA  WHERE REPORT_DATE =?1", nativeQuery = true)
	List<Object[]> getfxriskdatalistdata1(Date Report_date);
	
	
	@Query(value = "SELECT * FROM BCBUAE_FX_RISK_DATA where SI_NO =?1 ", nativeQuery = true)
	RT_Fxriskdata getParticularDataBySI_NO(String SI_NO);

	@Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM BCBUAE_FX_RISK_DATA", nativeQuery = true)
	Timestamp findLastReportDate();
	
	@Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM BCBUAE_FX_RISK_DATA WHERE REPORT_DATE < (SELECT MAX(REPORT_DATE) FROM BCBUAE_FX_RISK_DATA)", nativeQuery = true)
	Timestamp findSecondLastReportDate();
	
}
