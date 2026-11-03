package com.bornfire.xbrl.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bornfire.xbrl.entities.RT_DataControl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Repository
public interface RT_DatacontrolRepository extends JpaRepository<RT_DataControl, Integer> {

	// You can define custom queries here if needed, for example:
	// List<BcbuaeNostroAccBalDatacontrol> findByEntityFlg(String entityFlg);

	@Query(value = "SELECT * FROM (  SELECT * FROM BCBUAE_DATACONTROL  WHERE TRUNC(PORTFOLIO_DATE) = TRUNC(TO_DATE(:reportDate, 'dd-MM-yyyy'))  AND REPORT_NAME = :reportName   ORDER BY SI_NO DESC ) WHERE ROWNUM = 1 and DEL_FLG='N'", nativeQuery = true)
	RT_DataControl getdata(@Param("reportDate") String reportDate, @Param("reportName") String reportName);

}
