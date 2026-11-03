package com.bornfire.xbrl.entities;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RT_Data_Inventory_Repo extends JpaRepository<RT_Data_Inventory_Entity, Long> {

	List<RT_Data_Inventory_Entity> findByIsActiveOrderBySortOrderAscReportNameAsc(String isActive);

	Optional<RT_Data_Inventory_Entity> findFirstByReportTypeCodeIgnoreCaseAndIsActive(String reportTypeCode,
			String isActive);
}
