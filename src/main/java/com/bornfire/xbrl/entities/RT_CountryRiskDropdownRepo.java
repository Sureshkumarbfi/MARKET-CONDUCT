package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RT_CountryRiskDropdownRepo extends JpaRepository<RT_CountryRiskDropdown, Integer> {
    List<RT_CountryRiskDropdown> findAllByOrderByCountryOfRiskAsc();
    
    RT_CountryRiskDropdown findByCountryOfRisk(String countryOfRisk);

}
