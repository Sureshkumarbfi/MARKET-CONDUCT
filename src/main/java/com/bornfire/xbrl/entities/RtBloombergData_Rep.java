package com.bornfire.xbrl.entities;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface RtBloombergData_Rep extends JpaRepository<RtBloombergData, String> {
	@Query(value = "select * from RT_BLOOMBERG_DATA where DEL_FLG='N'", nativeQuery = true)
	List<RtBloombergData> getrtbloombergdatalist();
	
	@Query(value = "select * from RT_BLOOMBERG_DATA where isin=?1 AND DEL_FLG='N'", nativeQuery = true)
	RtBloombergData getrtbloombergdatabyisin(String isin);
	
	boolean existsByIsinAndDelFlg(String isin, String delFlg);
	
	Optional<RtBloombergData> findByIsinAndDelFlg(String isin, String delFlg);
	
}
