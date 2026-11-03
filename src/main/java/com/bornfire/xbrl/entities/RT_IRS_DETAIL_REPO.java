package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import oracle.sql.DATE;

public interface RT_IRS_DETAIL_REPO extends JpaRepository<RT_IRS_DETAIL_ENTITY, String> {
	 @Query(value = "select * from RT_IRS_DETAILTABLE  where TRUNC(REPORT_DATE)=?1", nativeQuery = true)
	 List<RT_IRS_DETAIL_ENTITY> RtIrsDetailList(Date report_date);
	 
		/*
		 * @Query(value =
		 * "select * from RT_IRS_DETAILTABLE where REPORT_DATE=?1 AND Cust_id is NOT null  offset ?2 rows fetch next ?3 rows only"
		 * , nativeQuery = true) List<RT_IRS_DETAIL_ENTITY> irsdetaillist(Date
		 * REPORT_DATE,int startpage,int endpage);
		 */
	 
	 @Query(value = "SELECT * FROM RT_IRS_DETAILTABLE " +
             "WHERE REPORT_DATE = ?1 AND CUST_ID IS NOT NULL " +
             "OFFSET ?2 ROWS FETCH NEXT ?3 ROWS ONLY", nativeQuery = true)
List<RT_IRS_DETAIL_ENTITY> irsdetaillist(Date reportDate, int offset, int size);



	 @Query(value = "select * from RT_IRS_DETAILTABLE where REPORT_DATE=?1 AND REPORT_LABEL=?2", nativeQuery = true)
	 List<RT_IRS_DETAIL_ENTITY> IRSdetaillistrowid(Date REPORT_DATE,String REPORT_LABEL);
	 
	@Query(value = "select count(*) from RT_IRS_DETAILTABLE where REPORT_DATE=?1", nativeQuery = true)
	 int  IRSdetaillistcount(Date REPORT_DATE);
	
	@Query(value = "select count(*) from RT_IRS_DETAILTABLE where REPORT_DATE=?1 AND REPORT_LABEL=?2", nativeQuery = true)
	 int  IRSdetaillistcountROWID(Date REPORT_DATE,String REPORT_LABEL);


}



