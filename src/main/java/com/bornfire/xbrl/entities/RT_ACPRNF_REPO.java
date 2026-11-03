package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_ACPRNF_REPO extends JpaRepository<RT_ACPRNF_ENTITY, String> {

	// Deletes records for a specific date to prevent duplicates
	@Transactional
	@Modifying
	@Query("DELETE FROM RT_ACPRNF_ENTITY a WHERE a.reportDate = ?1")
	void deleteByReportDate(Date reportDate);
	boolean existsByReportDate(Date reportDate);

    @Query("SELECT DISTINCT r.reportDate FROM RT_ACPRNF_ENTITY r")
    List<Date> findUploadedDates();
}