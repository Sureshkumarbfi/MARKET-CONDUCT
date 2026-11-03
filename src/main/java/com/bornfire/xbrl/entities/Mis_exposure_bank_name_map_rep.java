package com.bornfire.xbrl.entities;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Mis_exposure_bank_name_map_rep extends JpaRepository<Mis_exposure_bank_name_map_entity, Long> {

	@Query(value = "SELECT * FROM MIS_ASL_EXPOSURE_BANK_NAME_MAP WHERE DEL_FLG = 'N' "
			+ "AND UPPER(TRIM(OLD_BANK_NAME)) = UPPER(TRIM(:oldBankName))", nativeQuery = true)
	Optional<Mis_exposure_bank_name_map_entity> findActiveByOldBankName(@Param("oldBankName") String oldBankName);
}
