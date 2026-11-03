package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Groupexp_cust_maintain_rep extends JpaRepository<Groupexp_cust_maintain_entity, String> {

	@Query(value = "Select * from GROUP_EXPOSURE_MAINTENANCE_TABLE where group_id = ?1",nativeQuery=true)
	Groupexp_cust_maintain_entity Getgroupdetails(String Selectedgroupid);
	
	@Query(value = "Select * from GROUP_EXPOSURE_MAINTENANCE_TABLE where del_flg = 'N'",nativeQuery=true)
	List<Groupexp_cust_maintain_entity> Getactivegroupdetails();
	
}
