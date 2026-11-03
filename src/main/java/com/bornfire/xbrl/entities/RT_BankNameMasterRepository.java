package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RT_BankNameMasterRepository extends JpaRepository<RT_BankNameMaster, Integer> {
    List<RT_BankNameMaster> findAllByOrderByBankNameAsc();  // Optional: for sorting alphabetically
    
    RT_BankNameMaster findByBankName(String bankName); 
}