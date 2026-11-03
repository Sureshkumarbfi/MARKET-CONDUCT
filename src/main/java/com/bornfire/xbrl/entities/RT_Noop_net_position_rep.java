package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RT_Noop_net_position_rep extends JpaRepository<RT_Noop_net_position_entity, RT_Noop_net_position_id_class> {

	@Query(value="Select * from RT_NET_POSITION_LIMIT_NOOP",nativeQuery=true)
	List<Object[]> GetNoopcalculationdetail();
	
	@Query(value="Select REPORT_DATE,CURRENCY, READY_EXCHAGE_POSITION_IN_AC, CBS_FX_POSITION_AC,\r\n"
			+ "MTM_AC,NVL(FORWARD_REVAL_POSITION_AC,0) AS FORWARD_REVAL_POSITION_AC, TOTAL_NOOP_IN_AC, TOTAL_NOOP_IN_LC from RT_NET_POSITION_LIMIT_NOOP\r\n"
			+ "where REPORT_DATE = ?1",nativeQuery=true)
	List<Object[]> Getnoopdetail(Date Report_date);

	@Query(value = "SELECT USD_INR_FEDAI_RATE, AED_INR_FEDAI_RATE, USD_AED_FEDAI_RATE "
			+ "FROM RT_NET_POSITION_LIMIT_NOOP WHERE REPORT_DATE = ?1 AND ROWNUM = 1", nativeQuery = true)
	List<Object[]> getFedaiRatesByReportDate(Date reportDate);

	@Modifying
	@Transactional
	@Query(value = "UPDATE RT_NET_POSITION_LIMIT_NOOP SET "
			+ "USD_INR_FEDAI_RATE = ?2, AED_INR_FEDAI_RATE = ?3, USD_AED_FEDAI_RATE = ?4 "
			+ "WHERE REPORT_DATE = ?1", nativeQuery = true)
	int updateFedaiRatesByReportDate(Date reportDate, BigDecimal usdInrRate, BigDecimal aedInrRate,
			BigDecimal usdAedRate);

}
