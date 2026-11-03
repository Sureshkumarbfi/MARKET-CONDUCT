package com.bornfire.xbrl.entities;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "MIS_ASL_DETAIL_REPORT")
public class ASL_Report_Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asl_seq")
	@SequenceGenerator(name = "asl_seq", sequenceName = "ASL_ID", allocationSize = 1)
	private Long id;


    @Column(name = "BRANCH_NAME")
    private String branchName;

    @Column(name = "SRL_NO")
    private String srlNo;

    @Column(name = "COUNTERPARTY_BANK_NAME")
    private String counterpartyBankName;

    @Column(name = "BUYERS_CREDIT")
    private Double buyersCredit;

    @Column(name = "FOREIGN_BILL_DISCOUNTING")
    private Double foreignBillDiscounting;

    @Column(name = "LOCAL_BILL_DISCOUNTING")
    private Double localBillDiscounting;

    @Column(name = "GUARANTEE_SBLCS")
    private Double guaranteeSblcs;

    @Column(name = "SYNDICATED_LOANS_INVESTMENT")
    private Double syndicatedLoansInvestment;

    @Column(name = "OTHERS")
    private Double others;

    @Column(name = "REMARKS")
    private String remarks;

    @Column(name = "TOTAL")
    private Double total;

    @Column(name = "COUNTERPARTY_BANK")
    private String counterpartyBank;

    @Column(name = "I_BRANCH_CODE")
    private String iBranchCode;

    @Column(name = "I_BRANCH_NAME")
    private String iBranchName;

    @Column(name = "UPLOADED_BY")
    private String uploadedBy;

    @Column(name = "REPORT_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date reportDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getSrlNo() {
		return srlNo;
	}

	public void setSrlNo(String srlNo) {
		this.srlNo = srlNo;
	}

	public String getCounterpartyBankName() {
		return counterpartyBankName;
	}

	public void setCounterpartyBankName(String counterpartyBankName) {
		this.counterpartyBankName = counterpartyBankName;
	}

	public Double getBuyersCredit() {
		return buyersCredit;
	}

	public void setBuyersCredit(Double buyersCredit) {
		this.buyersCredit = buyersCredit;
	}

	public Double getForeignBillDiscounting() {
		return foreignBillDiscounting;
	}

	public void setForeignBillDiscounting(Double foreignBillDiscounting) {
		this.foreignBillDiscounting = foreignBillDiscounting;
	}

	public Double getLocalBillDiscounting() {
		return localBillDiscounting;
	}

	public void setLocalBillDiscounting(Double localBillDiscounting) {
		this.localBillDiscounting = localBillDiscounting;
	}

	public Double getGuaranteeSblcs() {
		return guaranteeSblcs;
	}

	public void setGuaranteeSblcs(Double guaranteeSblcs) {
		this.guaranteeSblcs = guaranteeSblcs;
	}

	public Double getSyndicatedLoansInvestment() {
		return syndicatedLoansInvestment;
	}

	public void setSyndicatedLoansInvestment(Double syndicatedLoansInvestment) {
		this.syndicatedLoansInvestment = syndicatedLoansInvestment;
	}

	public Double getOthers() {
		return others;
	}

	public void setOthers(Double others) {
		this.others = others;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getCounterpartyBank() {
		return counterpartyBank;
	}

	public void setCounterpartyBank(String counterpartyBank) {
		this.counterpartyBank = counterpartyBank;
	}

	public String getiBranchCode() {
		return iBranchCode;
	}

	public void setiBranchCode(String iBranchCode) {
		this.iBranchCode = iBranchCode;
	}

	public String getiBranchName() {
		return iBranchName;
	}

	public void setiBranchName(String iBranchName) {
		this.iBranchName = iBranchName;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

}
