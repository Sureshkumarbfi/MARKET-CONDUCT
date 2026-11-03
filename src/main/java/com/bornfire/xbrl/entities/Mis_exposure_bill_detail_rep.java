package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Mis_exposure_bill_detail_rep extends JpaRepository<Mis_exposure_bill_detail_entity, String> {

	//By using this query take only active bill details
	@Query(value="Select * from MIS_ASL_EXPOSURE_BILL_DETAIL_TABLE where del_flg = 'N' and Report_date = ?1 and "
			+ "counterparty_status != 'Y'",nativeQuery = true)
	List<Mis_exposure_bill_detail_entity> getbilldetails(Date Report_date);
	
	@Query(value="Select * from MIS_ASL_EXPOSURE_BILL_DETAIL_TABLE where del_flg = 'N' and branch_name = ?1 and Report_date =?2 "
			+ "and counterparty_status != 'Y'",
			nativeQuery = true)
	List<Mis_exposure_bill_detail_entity> getbilldetailsbranchwise(String Branchcode,Date Report_date);

	@Query(value = "Select * from MIS_ASL_EXPOSURE_BILL_DETAIL_TABLE where del_flg = 'N' and Report_date = ?1",
			nativeQuery = true)
	List<Mis_exposure_bill_detail_entity> getallbilldetails(Date Report_date);

	@Query(value = "Select * from MIS_ASL_EXPOSURE_BILL_DETAIL_TABLE where del_flg = 'N' and branch_name = ?1 and Report_date = ?2",
			nativeQuery = true)
	List<Mis_exposure_bill_detail_entity> getallbilldetailsbranchwise(String Branchcode, Date Report_date);
	
	@Query(value="Select * from MIS_ASL_EXPOSURE_BILL_DETAIL_TABLE where del_flg = 'N' and srl_no = ?1 and report_date = ?2",nativeQuery = true)
	Mis_exposure_bill_detail_entity getbilldetail(String Srl_no,Date Report_date);
	
	@Query(value="Select * from MIS_ASL_EXPOSURE_BILL_DETAIL_TABLE where srl_no = ?1",nativeQuery = true)
	Optional<Mis_exposure_bill_detail_entity> checkvalueispresent(String Srl_no);
	
	@Query(value="SELECT XBRL_AUDIT_SEQ.NEXTVAL AS SRL_NO FROM DUAL",nativeQuery = true)
	int Generatesrl_no();
	
	
	//For Dashboard
	@Query(value="SELECT BRANCH_NAME,SUM(CASE WHEN DUE_DATE > SYSDATE AND DEL_FLG = 'N' THEN 1 ELSE 0 END) AS ACTIVE_COUNT,\r\n"
			+ "    SUM(CASE WHEN DUE_DATE < SYSDATE AND DEL_FLG = 'N' THEN 1 ELSE 0 END) AS PENDING_CLOSURE_COUNT\r\n"
			+ "FROM mis_asl_exposure_bill_detail_table GROUP BY BRANCH_NAME ORDER BY BRANCH_NAME",nativeQuery = true)
	List<Object[]> GetExposurecountdetail();

	@Query(value="SELECT BRANCH_NAME,SUM(CASE WHEN DUE_DATE > SYSDATE AND DEL_FLG = 'N' THEN 1 ELSE 0 END) AS ACTIVE_COUNT,\r\n"
			+ "    SUM(CASE WHEN DUE_DATE < SYSDATE AND DEL_FLG = 'N' THEN 1 ELSE 0 END) AS PENDING_CLOSURE_COUNT\r\n"
			+ "FROM mis_asl_exposure_bill_detail_table where BRANCH_NAME = ?1 "
			+ "GROUP BY BRANCH_NAME ORDER BY BRANCH_NAME",nativeQuery = true)
	List<Object[]> GetBranchwiseExpcount(String Branch_name);
}
