package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Daylight_data_repo extends JpaRepository<Daylight_data_entity, BigDecimal> {

	@Modifying(clearAutomatically = true)
	@Query(value = "Delete from RT_MATRIX_DAY_LIGHT_DATA where report_date = ?1", nativeQuery = true)
	void Deletedetail(Date Selecteddate);

	@Query(value = "SELECT NVL(MAX(SRLNO), 0) FROM RT_MATRIX_DAY_LIGHT_DATA", nativeQuery = true)
	BigDecimal findMaxSrlno();

	@Query(value = "SELECT COUNT(1) FROM RT_MATRIX_DAY_LIGHT_DATA WHERE report_date = ?1", nativeQuery = true)
	long countForReportDate(Date reportDate);

}
