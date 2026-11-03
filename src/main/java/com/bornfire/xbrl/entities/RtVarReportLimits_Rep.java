package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RtVarReportLimits_Rep extends JpaRepository<RtVarReportLimits, Date> {

	@Query(value = "select * from RT_VAR_REPORT_LIMITS where REPORT_DATE=?1", nativeQuery = true)
	 RtVarReportLimits RtInvestmentRiskDatalistrowid(Date REPORT_DATE);
	 
}
