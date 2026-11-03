package com.bornfire.xbrl.entities;


import java.util.List;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bornfire.xbrl.entities.AccessAndRoles;

@Repository
public interface  AccessandRolesRepository extends JpaRepository<AccessAndRoles,String> {
	 Optional<AccessAndRoles> findById( String directorId);

	 @Query(value = "select * from BRF_ACCESS_AND_ROLES_TABLE  where ROLE_ID =?1", nativeQuery = true)
		String FindByAll(String roleId);

	 
	 @Query(value = "select * from BRF_ACCESS_AND_ROLES_TABLE where DEL_FLG!='Y'", nativeQuery = true)
	 List<AccessAndRoles> rulelist();
	 
	 
	 @Modifying
		@Query(value = "UPDATE BRF_ACCESS_AND_ROLES_TABLE set DEL_FLG ='Y' where ROLE_ID =?1", nativeQuery = true)
		String findByfgdg1(String roleId);
	 
	 @Query(value = "select distinct ROLE_ID from BRF_ACCESS_AND_ROLES_TABLE  where DEL_FLG='N' AND ENTITY_FLG='Y'", nativeQuery = true)
		List<String> roleidtype();
	 
	 @Query(value = "select MENULIST from BRF_ACCESS_AND_ROLES_TABLE  where ROLE_ID =?1", nativeQuery = true)
	 String getMenulist(String role_id);

}
