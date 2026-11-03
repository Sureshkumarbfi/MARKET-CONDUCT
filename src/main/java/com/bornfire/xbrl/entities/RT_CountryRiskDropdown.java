package com.bornfire.xbrl.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BCBUAE_CI_DROPDOWN_LIST")
public class RT_CountryRiskDropdown {

    @Id
    @Column(name = "SL_NO")
    private Integer slNo;

    @Column(name = "COUNTRY_OF_RISK")
    private String countryOfRisk;

    @Column(name = "CBUAE_GEOGRAPHICAL_ZONE")
    private String cbuaeGeographicalZone;

    // Getters and Setters
    public Integer getSlNo() {
        return slNo;
    }

    public void setSlNo(Integer slNo) {
        this.slNo = slNo;
    }

    public String getCountryOfRisk() {
        return countryOfRisk;
    }

    public void setCountryOfRisk(String countryOfRisk) {
        this.countryOfRisk = countryOfRisk;
    }

    public String getCbuaeGeographicalZone() {
        return cbuaeGeographicalZone;
    }

    public void setCbuaeGeographicalZone(String cbuaeGeographicalZone) {
        this.cbuaeGeographicalZone = cbuaeGeographicalZone;
    }

	public RT_CountryRiskDropdown(Integer slNo, String countryOfRisk, String cbuaeGeographicalZone) {
		super();
		this.slNo = slNo;
		this.countryOfRisk = countryOfRisk;
		this.cbuaeGeographicalZone = cbuaeGeographicalZone;
	}

	public RT_CountryRiskDropdown() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
    
}
