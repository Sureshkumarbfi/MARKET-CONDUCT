package com.bornfire.xbrl.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ASL_BANKMASTER_REPO extends JpaRepository<ASL_BANKMASTER_ENTITY, String> {

    // Fetch bank details by bank name
	@Query(value = "SELECT * FROM MIS_ASL_BANK_MASTER WHERE TRIM(LOWER(BANK_NAME)) = TRIM(LOWER(?1))", nativeQuery = true)
	List<ASL_BANKMASTER_ENTITY> getBankDetails(String name);

    @Query(value = "SELECT DISTINCT BANK_NAME FROM MIS_ASL_BANK_MASTER WHERE BANK_NAME IS NOT NULL", nativeQuery = true)
    List<String> findDistinctBankNames();

}
