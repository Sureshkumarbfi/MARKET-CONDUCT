package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RtInvestmentRiskDataDetail_Rep extends JpaRepository<RtInvestmentRiskDataDetail, String> {
	 @Query(value = "select * from RT_INVESTMENT_RISK_DATA_DETAIL_TABLE where REPORT_DATE=?1 AND REPORT_ADDL_CRITERIA_2=?2 ORDER BY foracid  OFFSET ?3 ROWS FETCH NEXT ?4 ROWS ONLY", nativeQuery = true)
	 List<RtInvestmentRiskDataDetail> RtInvestmentRiskDatalistrowid(Date REPORT_DATE,String REPORT_LABEL,int offset,int pageSize);
	 
	@Query(value = "SELECT COUNT(*) FROM RT_INVESTMENT_RISK_DATA_DETAIL_TABLE WHERE TRUNC(REPORT_DATE) = TRUNC(?1)AND REPORT_ADDL_CRITERIA_2 = ?2 ", nativeQuery = true)
	int RtInvestmentRiskDatacountROWID(Date reportDate,String rowid);
}
