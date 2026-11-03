package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_FX_Position_Rep extends JpaRepository<RT_FX_Position_Entity, String> {
	@Query(value = "SELECT * FROM RT_FX_POSITION_TABLE WHERE TRUNC(report_date) = TRUNC(?1) AND position_type = ?2", nativeQuery = true)
	RT_FX_Position_Entity findExistingRecord(Date reportDate, String positionType);

	@Query(value = "SELECT MAX(TO_NUMBER(srl_no)) FROM RT_FX_POSITION_TABLE", nativeQuery = true)
	Integer findMaxSrlNo();

    // delete existing records for the date
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM RT_FX_POSITION_TABLE WHERE TRUNC(report_date) = TRUNC(?1)", nativeQuery = true)
    void deleteByReportDate(Date reportDate);

    @Query(value = "SELECT COUNT(*) FROM RT_FX_POSITION_TABLE WHERE TRUNC(report_date) = TRUNC(?1)", nativeQuery = true)
    int existsByReportDate(Date reportDate);

    @Query(value = "SELECT DISTINCT report_date FROM RT_FX_POSITION_TABLE", nativeQuery = true)
    List<Date> findUploadedDates();
}
