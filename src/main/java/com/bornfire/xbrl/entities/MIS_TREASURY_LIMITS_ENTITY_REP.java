package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MIS_TREASURY_LIMITS_ENTITY_REP extends JpaRepository<MIS_TREASURY_LIMITS_ENTITY, Date> {
	
	
	
	
@Query(value = "SELECT * FROM MIS_TREASURY_LIMITS WHERE REPORT_DATE = :reportDate", nativeQuery = true)
List<MIS_TREASURY_LIMITS_ENTITY> getAllListByDate(@Param("reportDate") Date reportDate);

    
    
    
}