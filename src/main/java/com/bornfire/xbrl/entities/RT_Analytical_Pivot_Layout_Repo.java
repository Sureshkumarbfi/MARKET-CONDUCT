package com.bornfire.xbrl.entities;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_Analytical_Pivot_Layout_Repo extends JpaRepository<RT_Analytical_Pivot_Layout_Entity, Long> {

	List<RT_Analytical_Pivot_Layout_Entity> findByUserIdOrderByUpdatedTimeDesc(String userId);

	Optional<RT_Analytical_Pivot_Layout_Entity> findByUserIdAndLayoutName(String userId, String layoutName);
}
