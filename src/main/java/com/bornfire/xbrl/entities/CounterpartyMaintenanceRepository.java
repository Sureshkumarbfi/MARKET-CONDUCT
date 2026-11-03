package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterpartyMaintenanceRepository extends JpaRepository<CounterpartyMaintenanceEntity, String> {

	@Query(value = "SELECT * FROM COUNTERPARTY_MAINTENANCE ORDER BY COUNTERPARTY_CODE", nativeQuery = true)
	List<CounterpartyMaintenanceEntity> getAllMaintained();

	@Query(value = "SELECT * FROM COUNTERPARTY_MAINTENANCE WHERE UPPER(TRIM(COUNTERPARTY_CODE)) = UPPER(TRIM(?1))", nativeQuery = true)
	CounterpartyMaintenanceEntity getByCounterpartyCode(String counterpartyCode);

	@Query(value = "WITH all_counterparties AS ("
			+ " SELECT DISTINCT CONTREPARTIE AS COUNTERPARTY FROM BRF_TREASURY_PLACEMENT_ID"
			+ " WHERE TRUNC(REPORT_DATE) = TRUNC(?1) AND PORTEFEUILLE IN ('AE-PLC-IB', 'AE-PLC-BR')"
			+ " UNION ALL"
			+ " SELECT DISTINCT ISSUER_ID AS COUNTERPARTY FROM BRF_TREASURY_SWD_TB"
			+ " WHERE TRUNC(REPORT_DATE) = TRUNC(?1) AND NVL(MATURITY_DATE, TRUNC(?1)) >= TRUNC(?1)"
			+ " UNION ALL"
			+ " SELECT CONTREPARTIE AS COUNTERPARTY FROM BRF_FORWARD_REVEAL_MANUAL_TABLE"
			+ " WHERE TRUNC(REPORT_DATE) = TRUNC(?1) AND NVL(MATURITYDATE, TRUNC(?1)) >= TRUNC(?1)"
			+ ") SELECT DISTINCT COUNTERPARTY FROM all_counterparties"
			+ " WHERE COUNTERPARTY IS NOT NULL ORDER BY COUNTERPARTY", nativeQuery = true)
	List<String> findOutstandingCounterparties(Date reportDate);
}
