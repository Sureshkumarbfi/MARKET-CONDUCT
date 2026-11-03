package com.bornfire.xbrl.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_CCR_DATA_TEMPLATE_REPOSITORY extends JpaRepository<RT_CCR_DATA_TEMPLATE, String> {

	@Query(value = "select * from BCBUAE_CCR_DATA_TABLE where SI_NO=?1  ", nativeQuery = true)
	RT_CCR_DATA_TEMPLATE editccr(String siNo);

	/*
	 * @Query(value = "SELECT * FROM BCBUAE_CCR_DATA_TABLE WHERE DEL_FLG = 'N'",
	 * nativeQuery = true) List<RT_CCR_DATA_TEMPLATE> getlist();
	 */
	
	/*
	 * @Query(value = "SELECT * FROM BCBUAE_CCR_DATA_TABLE WHERE SI_NO =?1 AND
	 * DEL_FLG = 'N', nativeQuery = true) List<RT_CCR_DATA_TEMPLATE> getlist();
	 */
	
    @Query(value = "SELECT * FROM BCBUAE_CCR_DATA_TABLE WHERE TRIM(DEL_FLG) = 'N' and REPORT_DATE=?1", nativeQuery = true)
    List<RT_CCR_DATA_TEMPLATE> getlist(Date REPORT_DATE);
    
	
	@Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM BCBUAE_CCR_DATA_TABLE", nativeQuery = true)
	Timestamp findLastReportDate();
		
     @Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM BCBUAE_CCR_DATA_TABLE WHERE REPORT_DATE < (SELECT MAX(REPORT_DATE) FROM BCBUAE_CCR_DATA_TABLE)", nativeQuery = true)
    Timestamp findSecondLastReportDate();
}
