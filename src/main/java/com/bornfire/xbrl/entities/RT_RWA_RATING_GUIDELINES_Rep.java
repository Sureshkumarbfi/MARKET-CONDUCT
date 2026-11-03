package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_RWA_RATING_GUIDELINES_Rep extends JpaRepository<RT_RWA_RATING_GUIDELINES,String> {
	
	@Query(value = "select * from BRF95_RWA_RATING_GUIDELINES", nativeQuery = true)
	List<RT_RWA_RATING_GUIDELINES> getratinglist();

}
