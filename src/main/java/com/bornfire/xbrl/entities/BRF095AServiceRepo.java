package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF095AServiceRepo extends JpaRepository<BRF_095_A_REPORT_ENTITY, Date> {
	
	
	

	@Query(value = "select * from BRF95_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF_095_A_REPORT_ENTITY> getBRF095REPORTSERVICE(String reportid,String repdesc);
	@Query(value = "SELECT * FROM BRF95_SUMMARYTABLE WHERE TO_CHAR(REPORT_DATE, 'YYYY') = ?1", nativeQuery = true)
	List<BRF_095_A_REPORT_ENTITY> getvalues(String year);

}
