package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MC_Service_audit_Repo extends JpaRepository<MC_Service_audit_entity, String> {

	@Query(value = "SELECT * FROM RT_MC_SERVICE_AUDIT_TABLE WHERE " + "(LOWER(audit_screen) LIKE :wildcardKeyword OR "
			+ "LOWER(func_code) LIKE :wildcardKeyword OR "
			+ "DBMS_LOB.INSTR(LOWER(modi_details), :exactKeyword) > 0 OR "
			+ "DBMS_LOB.INSTR(LOWER(FIELD_HEADER), :exactKeyword) > 0 OR "
			+ "LOWER(entry_user) LIKE :wildcardKeyword OR " + "LOWER(session_id) LIKE :wildcardKeyword) "
			+ "ORDER BY entry_time DESC", countQuery = "SELECT count(*) FROM RT_MC_SERVICE_AUDIT_TABLE WHERE "
					+ "(LOWER(audit_screen) LIKE :wildcardKeyword OR " + "LOWER(func_code) LIKE :wildcardKeyword OR "
					+ "DBMS_LOB.INSTR(LOWER(modi_details), :exactKeyword) > 0 OR "
					+ "DBMS_LOB.INSTR(LOWER(FIELD_HEADER), :exactKeyword) > 0 OR "
					+ "LOWER(entry_user) LIKE :wildcardKeyword OR "
					+ "LOWER(session_id) LIKE :wildcardKeyword)", nativeQuery = true)
	Page<MC_Service_audit_entity> searchByKeyword(@Param("wildcardKeyword") String wildcardKeyword,
			@Param("exactKeyword") String exactKeyword, Pageable pageable);

	@Query("SELECT a FROM MC_Service_audit_entity a ORDER BY a.entry_time DESC")
	Page<MC_Service_audit_entity> findAllByOrderByDateDesc(Pageable pageable);

	@Query(value = "SELECT * FROM RT_MC_SERVICE_AUDIT_TABLE WHERE entry_time BETWEEN :fromDate AND :toDate", nativeQuery = true)
	List<MC_Service_audit_entity> findByEntryTimeBetween(@Param("fromDate") Date fromDate,
			@Param("toDate") Date toDate);

	@Query(value = "SELECT * FROM RT_MC_SERVICE_AUDIT_TABLE WHERE entry_time >= :fromDate AND entry_time < :toDateExclusive ORDER BY entry_time DESC", nativeQuery = true)
	List<MC_Service_audit_entity> findByEntryTimeRange(@Param("fromDate") Date fromDate,
			@Param("toDateExclusive") Date toDateExclusive);

}
