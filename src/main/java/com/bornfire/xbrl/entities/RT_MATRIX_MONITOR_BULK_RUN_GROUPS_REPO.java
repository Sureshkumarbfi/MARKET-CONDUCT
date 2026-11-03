package com.bornfire.xbrl.entities;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_MATRIX_MONITOR_BULK_RUN_GROUPS_REPO
		extends JpaRepository<RT_MATRIX_MONITOR_BULK_RUN_GROUPS_ENTITY, Long> {

	@Query(value = "SELECT COALESCE(MAX(id), 0) FROM RT_MATRIX_MONITOR_BULK_RUN_GROUPS", nativeQuery = true)
	Long getMaxId();

	@Query(value = "SELECT * FROM RT_MATRIX_MONITOR_BULK_RUN_GROUPS WHERE DEL_FLG = 'N'", nativeQuery = true)
	List<RT_MATRIX_MONITOR_BULK_RUN_GROUPS_ENTITY> findAllActiveGroups();

	@Modifying
	@Transactional
	@Query(value = "UPDATE RT_MATRIX_MONITOR_BULK_RUN_GROUPS SET DEL_FLG = 'Y' WHERE GROUP_NAME = ?1", nativeQuery = true)
	void softDeleteByGroupName(String groupName);
}