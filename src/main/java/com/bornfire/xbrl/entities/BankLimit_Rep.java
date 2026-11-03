package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BankLimit_Rep extends CrudRepository<BankLimit_Entity,String>{
	
	@Query(
			  value = "SELECT * FROM MIS_BANK_LIMITS " +
			          "WHERE TRUNC(REPORT_DATE) = TRUNC(:reportDate) and TOTAL_EXPOSURE <> 0 " +
			          "ORDER BY S_NO",
			  nativeQuery = true
			)
	List<BankLimit_Entity> getalllist(@Param("reportDate") Date reportDate);

	@Query(value = "select * from MIS_BANK_LIMITS WHERE REPORT_DATE=?1 ORDER BY BANK_NAME desc", nativeQuery = true)
	List<BankLimit_Entity> getalllists(Date REPORT_DATE);
	
	@Query(value = "select * from MIS_BANK_LIMITS WHERE REPORT_DATE=(select max(REPORT_DATE) from MIS_BANK_LIMITS) ORDER BY BANK_NAME ", nativeQuery = true)
	List<BankLimit_Entity> getallbanknamemaxdate();
	
}