package com.bornfire.xbrl.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BCBUAE_RT_BANKNAME")
public class RT_BankNameMaster {

    @Id
    @Column(name = "SI_NO")
    private Integer siNo;

    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "BANK_SYMBOL")
    private String bankSymbol;

    @Column(name = "CONVENTIONAL_ISLAMIC")
    private String conventionalIslamic;

    @Column(name = "LOCAL_FOREIGN")
    private String localForeign;

    @Column(name = "CBUAE_TIERING")
    private String cbuaeTiering;

	public RT_BankNameMaster(Integer siNo, String bankName, String bankSymbol, String conventionalIslamic,
			String localForeign, String cbuaeTiering) {
		super();
		this.siNo = siNo;
		this.bankName = bankName;
		this.bankSymbol = bankSymbol;
		this.conventionalIslamic = conventionalIslamic;
		this.localForeign = localForeign;
		this.cbuaeTiering = cbuaeTiering;
	}

	public RT_BankNameMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getSiNo() {
		return siNo;
	}

	public void setSiNo(Integer siNo) {
		this.siNo = siNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankSymbol() {
		return bankSymbol;
	}

	public void setBankSymbol(String bankSymbol) {
		this.bankSymbol = bankSymbol;
	}

	public String getConventionalIslamic() {
		return conventionalIslamic;
	}

	public void setConventionalIslamic(String conventionalIslamic) {
		this.conventionalIslamic = conventionalIslamic;
	}

	public String getLocalForeign() {
		return localForeign;
	}

	public void setLocalForeign(String localForeign) {
		this.localForeign = localForeign;
	}

	public String getCbuaeTiering() {
		return cbuaeTiering;
	}

	public void setCbuaeTiering(String cbuaeTiering) {
		this.cbuaeTiering = cbuaeTiering;
	}

    // Getters and Setters
    
}

