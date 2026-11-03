package com.bornfire.xbrl.entities;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface Service_audit_table_Rep extends JpaRepository<Service_audit_table_entity, String> {

	@Query(value = "select * from BCBUAERT_SERVICE_AUDIT_TABLE", nativeQuery = true)
	List<Service_audit_table_entity> getauditListLocalvalues();

	@Query(value = "select * from BCBUAERT_SERVICE_AUDIT_TABLE where AUDIT_TABLE = 'Kyc_corporate'", nativeQuery = true)
	List<Service_audit_table_entity> getauditListLocalvalues1();

	@Query(value = "select * from BTDES_SERVICE_AUDIT_TABLE where TRUNC(AUDIT_DATE) = ?1", nativeQuery = true)
	List<Service_audit_table_entity> getauditListOpeartion(Date audit_date);

	
	  @Query(value = "SELECT BTDES_AUDIT_SEQ.NEXTVAL FROM dual", nativeQuery = true)
	  Long getAuditRefUUID();
	  
		@Query(value = "SELECT audit_table AS \"audit_table\", func_code AS \"func_code\", entry_user AS \"entry_user\", "
				+ "MIN(entry_time) AS \"min_time\", MAX(entry_time) AS \"max_time\" " + "FROM ("
				+ "SELECT audit_table, func_code, entry_user, entry_time, "
				+ "ROW_NUMBER() OVER(ORDER BY entry_time DESC, audit_ref_no DESC) - "
				+ "ROW_NUMBER() OVER(PARTITION BY audit_table, func_code, entry_user ORDER BY entry_time DESC, audit_ref_no DESC) AS island_id "
				+ "FROM BCBUAERT_SERVICE_AUDIT_TABLE "
				+ "WHERE (:filterDate IS NULL OR TRUNC(entry_time) = TO_DATE(:filterDate, 'YYYY-MM-DD')) " + ") "
				+ "GROUP BY audit_table, func_code, entry_user, island_id "
				+ "ORDER BY MAX(entry_time) DESC", countQuery = "SELECT COUNT(*) FROM (" + "SELECT 1 FROM ("
						+ "SELECT audit_table, func_code, entry_user, "
						+ "ROW_NUMBER() OVER(ORDER BY entry_time DESC, audit_ref_no DESC) - "
						+ "ROW_NUMBER() OVER(PARTITION BY audit_table, func_code, entry_user ORDER BY entry_time DESC, audit_ref_no DESC) AS island_id "
						+ "FROM BCBUAERT_SERVICE_AUDIT_TABLE "
						+ "WHERE (:filterDate IS NULL OR TRUNC(entry_time) = TO_DATE(:filterDate, 'YYYY-MM-DD')) "
						+ ") GROUP BY audit_table, func_code, entry_user, island_id" + ")", nativeQuery = true)
		Page<Map<String, Object>> findChronologicalGroups(@Param("filterDate") String filterDate, Pageable pageable);
		
		@Query("SELECT a FROM Service_audit_table_entity a WHERE a.audit_table = :auditTable AND a.func_code = :funcCode AND a.entry_user = :entryUser AND a.entry_time BETWEEN :minTime AND :maxTime ORDER BY a.entry_time DESC")
		List<Service_audit_table_entity> findDetailRows(@Param("auditTable") String auditTable,
				@Param("funcCode") String funcCode, @Param("entryUser") String entryUser,
				@Param("minTime") Date minTime, @Param("maxTime") Date maxTime);
	 

}
