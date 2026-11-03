package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_Report_Step_Exec_Repo extends JpaRepository<RT_Report_Step_Exec_Entity, Long> {

	@Query(value = "SELECT * FROM RT_REPORT_STEP_EXEC WHERE REPORT_ID = :rid AND STEP_ID = :sid "
			+ "AND TRUNC(REPORT_DATE) = TRUNC(:rday)", nativeQuery = true)
	Optional<RT_Report_Step_Exec_Entity> findForReportStepAndDay(@Param("rid") BigDecimal reportId,
			@Param("sid") Long stepId, @Param("rday") Date reportDay);

	@Query(value = "SELECT * FROM RT_REPORT_STEP_EXEC WHERE REPORT_ID = :rid AND TRUNC(REPORT_DATE) = TRUNC(:rday)",
			nativeQuery = true)
	List<RT_Report_Step_Exec_Entity> findByReportAndDay(@Param("rid") BigDecimal reportId,
			@Param("rday") Date reportDay);
}
