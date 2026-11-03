package com.bornfire.xbrl.entities;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RT_EAR_REPO extends JpaRepository<RT_EAR_ENTITY, RT_EAR_IDCLASS> {

	@Query(value = "SELECT * FROM RT_EAR_TABLE r "
			+ "WHERE r.REPORT_TYPE = :reportType AND r.REPORT_DATE= :formatreportdate "
			+ "AND ROWNUM = 1", nativeQuery = true)
	RT_EAR_ENTITY findbyReportTypeandReportDate(@Param("formatreportdate") LocalDate formatreportdate,
			@Param("reportType") String reportType);

}
