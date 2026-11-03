package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_Report_Step_Repo extends JpaRepository<RT_Report_Step_Entity, Long> {

	@Query(value = "SELECT * FROM RT_REPORT_STEP WHERE REPORT_ID = :rid ORDER BY STEP_ORDER ASC", nativeQuery = true)
	List<RT_Report_Step_Entity> findByReportIdOrdered(@Param("rid") BigDecimal reportId);
}
