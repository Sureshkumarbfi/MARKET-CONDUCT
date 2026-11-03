package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface KriMasterTable_Rep  extends JpaRepository<KriMasterTable, KriMasterTable_Id> {

	@Query(value = "SELECT * FROM KRI_MASTER_TABLE WHERE TRUNC(REPORT_DATE) = TRUNC(?1)  AND DEL_FLG='N' ORDER BY SN", nativeQuery = true)
	List<KriMasterTable> getalllist(Date reportDate);
	
	
}
