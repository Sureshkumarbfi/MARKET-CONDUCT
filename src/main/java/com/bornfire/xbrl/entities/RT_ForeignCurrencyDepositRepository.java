package com.bornfire.xbrl.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_ForeignCurrencyDepositRepository extends JpaRepository<RT_ForeignCurrencyDeposit, String> {
	// Add custom queries if needed

	@Query(value = "select * from BCBUAE_CROSS_CUR_FUNDING_FOREIGN_DEPOSITS Where Report_date =?1 ", nativeQuery = true)
	List<RT_ForeignCurrencyDeposit> getlist(Date Report_date);

	@Query(value = "SELECT * FROM BCBUAE_CROSS_CUR_FUNDING_FOREIGN_DEPOSITS ", nativeQuery = true)
	List<RT_ForeignCurrencyDeposit> getfxriskdatalistdata();

	@Query(value = "SELECT * FROM BCBUAE_CROSS_CUR_FUNDING_FOREIGN_DEPOSITS Where Report_date =?1 ", nativeQuery = true)
	List<Object[]> getforeigncurrencylistdata1(Date Report_date);
	
	
	@Query(value = "SELECT * FROM BCBUAE_CROSS_CUR_FUNDING_FOREIGN_DEPOSITS where SI_NO =?1 ", nativeQuery = true)
	RT_ForeignCurrencyDeposit getParticularDataBySI_NO(String SI_NO);
	
	@Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM BCBUAE_CROSS_CUR_FUNDING_FOREIGN_DEPOSITS", nativeQuery = true)
	Timestamp findLastReportDate();

	@Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM BCBUAE_CROSS_CUR_FUNDING_FOREIGN_DEPOSITS WHERE REPORT_DATE < (SELECT MAX(REPORT_DATE) FROM BCBUAE_CROSS_CUR_FUNDING_FOREIGN_DEPOSITS)", nativeQuery = true)
	Timestamp findSecondLastReportDate();
}
