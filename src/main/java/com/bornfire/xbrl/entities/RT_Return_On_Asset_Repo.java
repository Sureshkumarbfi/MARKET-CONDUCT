package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_Return_On_Asset_Repo extends JpaRepository<RT_Return_On_Asset_Entity, Date> {

	@Query("SELECT e FROM RT_Return_On_Asset_Entity e WHERE e.report_date = :d")
	Optional<RT_Return_On_Asset_Entity> findByReportDate(@Param("d") Date reportDate);

	@Query("SELECT e FROM RT_Return_On_Asset_Entity e WHERE e.report_date BETWEEN :start AND :end ORDER BY e.report_date ASC")
	List<RT_Return_On_Asset_Entity> findByReportDateBetween(@Param("start") Date start, @Param("end") Date end);

	
	@Query(value = "SELECT DAILY_AVG_ASSETS_NET_OF_INTER_BRANCH_BORR, NET_PROFIT, RETURN_ON_ASST_PER "
			+ "FROM RT_RETURN_ON_ASSET WHERE TRUNC(REPORT_DATE) = TRUNC(:reportDate)", nativeQuery = true)
	List<Object[]> GetByReportDate(@Param("reportDate") Date reportDate);

}
