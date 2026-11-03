package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MIS_SBLC_Maintenance_Repo extends JpaRepository<MIS_SBLC_Maintenance_Entity, BigDecimal> {

	// Only fetch records where DEL_FLG is 'N'
	@Query(value = "SELECT * FROM MIS_SBLC_MAINTENANCE_TABLE WHERE DEL_FLG = 'N' ORDER BY ID", nativeQuery = true)
	List<MIS_SBLC_Maintenance_Entity> getalllist();

	@Query(value = "SELECT NVL(MAX(ID), 0) + 1 FROM MIS_SBLC_MAINTENANCE_TABLE", nativeQuery = true)
	BigDecimal getNextId();
}