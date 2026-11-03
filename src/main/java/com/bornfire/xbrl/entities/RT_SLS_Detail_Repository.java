package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RT_SLS_Detail_Repository extends JpaRepository<RT_SLS_Detail_Enitity,RT_SLS_Detail_Id_Class>  {

	/*
	 * @Query(value =
	 * "select * from RT_SLS_DETAILTABLE where REPORT_DATE=?1 AND Cust_id is NOT null  offset ?2 rows fetch next ?3 rows only"
	 * , nativeQuery = true) List<RT_SLS_Detail_Enitity> slsdetaillist(Date
	 * REPORT_DATE,int startpage,int endpage);
	 */

	/* @Query(value = "select * from RT_SLS_DETAILTABLE where REPORT_DATE=?1 and ACCT_CRNCY_CODE = ?2 AND Cust_id is NOT null AND offset ?3 rows fetch next ?4 rows only", nativeQuery = true)
	 List<RT_SLS_Detail_Enitity> slsdetaillist(Date REPORT_DATE, String currency, int offset, int pageSize);*/

	 
	@Query(value = " SELECT * FROM RT_SLS_DETAILTABLE  WHERE TRUNC(REPORT_DATE) = TRUNC(?1) AND ACCT_CRNCY_CODE = ?2 ORDER BY FORACID OFFSET ?3 ROWS FETCH NEXT ?4 ROWS ONLY", nativeQuery = true)
		List<RT_SLS_Detail_Enitity> slsdetaillist(Date reportDate,String currency,int offset,int pageSize);
		
		@Query(value = " SELECT * FROM RT_SLS_DETAILTABLE  WHERE TRUNC(REPORT_DATE) = TRUNC(?1) ORDER BY FORACID OFFSET ?2 ROWS FETCH NEXT ?3 ROWS ONLY", nativeQuery = true)
		List<RT_SLS_Detail_Enitity> slsdetaillist(Date reportDate,int offset,int pageSize);
	

	 
	 @Query(value = "select * from RT_SLS_DETAILTABLE where REPORT_DATE=?1 ", nativeQuery = true)
	 List<RT_SLS_Detail_Enitity> slsdetaillistdate(Date REPORT_DATE);

	 @Query(value = "select * from RT_SLS_DETAILTABLE where REPORT_DATE=?1 AND REPORT_LABEL=?2 and ACCT_CRNCY_CODE = ?3 ORDER BY FORACID OFFSET ?4 ROWS FETCH NEXT ?5 ROWS ONLY", nativeQuery = true)
	 List<RT_SLS_Detail_Enitity> slsdetaillistrowid(Date REPORT_DATE,String REPORT_LABEL,String currency,int offset,int pageSize);
	 
	 @Query(value = "select * from RT_SLS_DETAILTABLE where REPORT_DATE=?1 AND REPORT_LABEL=?2 ORDER BY FORACID OFFSET ?3 ROWS FETCH NEXT ?4 ROWS ONLY", nativeQuery = true)
	 List<RT_SLS_Detail_Enitity> slsdetaillistrowid(Date REPORT_DATE,String REPORT_LABEL,int offset,int pageSize);
	
	@Query(value = "select count(*) from RT_SLS_DETAILTABLE where REPORT_DATE=?1 and  ACCT_CRNCY_CODE = ?2", nativeQuery = true)
	 int  slsdetaillistcount(Date REPORT_DATE, String currency);
	
	@Query(value = "select count(*) from RT_SLS_DETAILTABLE where REPORT_DATE=?1", nativeQuery = true)
	 int  slsdetaillistcount(Date REPORT_DATE);
	
	
	@Query(value = "SELECT COUNT(*) FROM RT_SLS_DETAILTABLE WHERE TRUNC(REPORT_DATE) = TRUNC(?1)AND REPORT_LABEL = ?2 AND ACCT_CRNCY_CODE = ?3", nativeQuery = true)
		int slsdetaillistcountROWID(Date reportDate,String rowid,String currency);
	
	@Query(value = "SELECT COUNT(*) FROM RT_SLS_DETAILTABLE WHERE TRUNC(REPORT_DATE) = TRUNC(?1)AND REPORT_LABEL = ?2 ", nativeQuery = true)
	int slsdetaillistcountROWID(Date reportDate,String rowid);

}
