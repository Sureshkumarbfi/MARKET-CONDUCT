package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Limit_Request_Rep  extends JpaRepository<Limit_Request_Entity, BigDecimal> {
	
	@Query(value = "SELECT NVL(MAX(SRL_NO), 0) + 1 FROM LIMIT_REQUEST", nativeQuery = true)
	int getSrlNo();

	
	@Query(value = "SELECT * FROM LIMIT_REQUEST WHERE DEL_FLG = 'N' AND EXECUTION_DATE >= trunc(SYSDATE)",nativeQuery = true)
	List<Limit_Request_Entity> getAllLimitRequestList();
	
	@Query(value = "SELECT * FROM LIMIT_REQUEST WHERE DEL_FLG = 'N' AND EXECUTION_DATE < trunc(SYSDATE)",nativeQuery = true)
	List<Limit_Request_Entity> getAllLimitRequestListhis();


	
}
