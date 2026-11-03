
package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import oracle.sql.DATE;

public interface RT_IRS2_REPOSITORY extends JpaRepository<RT_IRS_ENTITY2, String> {
	 
	@Query(value = "select * from RT_IRS_SUMMARY_TABLE2 order by REPORT_DATE", nativeQuery = true)
	 List<RT_IRS_ENTITY2> rtirslist();
	 
	 @Query(value = "select * from RT_IRS_SUMMARY_TABLE2 where TRUNC(REPORT_DATE)=?1 AND REPORT_CURRENCY=?2", nativeQuery = true)
	 List<RT_IRS_ENTITY2> rtirslistbydate(Date reportdate,String currency);

	 
	 @Query(value = "select * from RT_IRS_SUMMARY_TABLE2 where REPORT_DATE=?1", nativeQuery = true)
	 List<RT_IRS_ENTITY2> getIrsCurrencyByDate(Date reportdate);

}

