package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "RT_IRRBB_RECON")
public class RT_IRRBB_RECON implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private BigDecimal id;

	@Column(name = "REPORT_DATE")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date reportDate;

	@Column(name = "FX_CODE", length = 20)
	private String fxCode;

	@Column(name = "CONVERSION_RATE_TO_AED", precision = 20, scale = 8)
	private BigDecimal conversionRateToAed;

	@Column(name = "OS_CCY", precision = 20, scale = 4)
	private BigDecimal osCcy;

	@Column(name = "OS_AED", precision = 20, scale = 4)
	private BigDecimal osAed;

	@Column(name = "ASSET_FX_CODE", length = 20)
	private String assetFxCode;

	@Column(name = "ASSET_VALUE", precision = 20, scale = 4)
	private BigDecimal assetValue;

	@Column(name = "ASSET_CF_FOREIGN_CCY", precision = 20, scale = 4)
	private BigDecimal assetCfForeignCcy;

	@Column(name = "ASSET_CF_AED", precision = 20, scale = 4)
	private BigDecimal assetCfAed;

	@Column(name = "LIABILITY_CF_FOREIGN_CCY", precision = 20, scale = 4)
	private BigDecimal liabilityCfForeignCcy;

	@Column(name = "LIABILITY_CF_AED", precision = 20, scale = 4)
	private BigDecimal liabilityCfAed;

	@Column(name = "EAR_CF_FOREIGN_CCY", precision = 20, scale = 4)
	private BigDecimal earCfForeignCcy;

	@Column(name = "EAR_CF_AED", precision = 20, scale = 4)
	private BigDecimal earCfAed;

	@Column(name = "ASSETS_LIABILITIES_PORTFOLIO_DATE", precision = 20, scale = 4)
	private BigDecimal assetsLiabilitiesPortfolioDate;

	@Column(name = "ABSOLUTE_DIFFERENCE", precision = 20, scale = 4)
	private BigDecimal absoluteDifference;

	@Column(name = "PERCENTAGE_DIFFERENCE", precision = 20, scale = 4)
	private BigDecimal percentageDifference;

	@Column(name = "REPORTED_BEHAVIOURAL_REPRICING_GAP", precision = 20, scale = 4)
	private BigDecimal reportedBehaviouralRepricingGap;

	@Column(name = "RELATIVE_DIFFERENCE", precision = 20, scale = 4)
	private BigDecimal relativeDifference;

	@Column(name = "CREATED_BY", length = 100)
	private String createdBy;

	@Column(name = "CREATED_DATE")
	private LocalDateTime createdDate;

	@PrePersist
	protected void onCreate() {
		if (createdDate == null) {
			createdDate = LocalDateTime.now();
		}
	}

	public RT_IRRBB_RECON() {
		super();
	}

	public RT_IRRBB_RECON(BigDecimal id, Date reportDate, String fxCode, BigDecimal conversionRateToAed,
			BigDecimal osCcy, BigDecimal osAed, String assetFxCode, BigDecimal assetValue,
			BigDecimal assetCfForeignCcy, BigDecimal assetCfAed, BigDecimal liabilityCfForeignCcy,
			BigDecimal liabilityCfAed, BigDecimal earCfForeignCcy, BigDecimal earCfAed, String createdBy,
			LocalDateTime createdDate) {
		super();
		this.id = id;
		this.reportDate = reportDate;
		this.fxCode = fxCode;
		this.conversionRateToAed = conversionRateToAed;
		this.osCcy = osCcy;
		this.osAed = osAed;
		this.assetFxCode = assetFxCode;
		this.assetValue = assetValue;
		this.assetCfForeignCcy = assetCfForeignCcy;
		this.assetCfAed = assetCfAed;
		this.liabilityCfForeignCcy = liabilityCfForeignCcy;
		this.liabilityCfAed = liabilityCfAed;
		this.earCfForeignCcy = earCfForeignCcy;
		this.earCfAed = earCfAed;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public RT_IRRBB_RECON(BigDecimal id, Date reportDate, String fxCode, BigDecimal conversionRateToAed,
			BigDecimal osCcy, BigDecimal osAed, String assetFxCode, BigDecimal assetValue,
			BigDecimal assetCfForeignCcy, BigDecimal assetCfAed, BigDecimal liabilityCfForeignCcy,
			BigDecimal liabilityCfAed, BigDecimal earCfForeignCcy, BigDecimal earCfAed,
			BigDecimal assetsLiabilitiesPortfolioDate, BigDecimal absoluteDifference,
			BigDecimal percentageDifference, BigDecimal reportedBehaviouralRepricingGap,
			BigDecimal relativeDifference, String createdBy, LocalDateTime createdDate) {
		super();
		this.id = id;
		this.reportDate = reportDate;
		this.fxCode = fxCode;
		this.conversionRateToAed = conversionRateToAed;
		this.osCcy = osCcy;
		this.osAed = osAed;
		this.assetFxCode = assetFxCode;
		this.assetValue = assetValue;
		this.assetCfForeignCcy = assetCfForeignCcy;
		this.assetCfAed = assetCfAed;
		this.liabilityCfForeignCcy = liabilityCfForeignCcy;
		this.liabilityCfAed = liabilityCfAed;
		this.earCfForeignCcy = earCfForeignCcy;
		this.earCfAed = earCfAed;
		this.assetsLiabilitiesPortfolioDate = assetsLiabilitiesPortfolioDate;
		this.absoluteDifference = absoluteDifference;
		this.percentageDifference = percentageDifference;
		this.reportedBehaviouralRepricingGap = reportedBehaviouralRepricingGap;
		this.relativeDifference = relativeDifference;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public void setId(Long id) {
		this.id = (id != null) ? BigDecimal.valueOf(id) : null;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getFxCode() {
		return fxCode;
	}

	public void setFxCode(String fxCode) {
		this.fxCode = fxCode;
	}

	public BigDecimal getConversionRateToAed() {
		return conversionRateToAed;
	}

	public void setConversionRateToAed(BigDecimal conversionRateToAed) {
		this.conversionRateToAed = conversionRateToAed;
	}

	public BigDecimal getOsCcy() {
		return osCcy;
	}

	public void setOsCcy(BigDecimal osCcy) {
		this.osCcy = osCcy;
	}

	public BigDecimal getOsAed() {
		return osAed;
	}

	public void setOsAed(BigDecimal osAed) {
		this.osAed = osAed;
	}

	public String getAssetFxCode() {
		return assetFxCode;
	}

	public void setAssetFxCode(String assetFxCode) {
		this.assetFxCode = assetFxCode;
	}

	public BigDecimal getAssetValue() {
		return assetValue;
	}

	public void setAssetValue(BigDecimal assetValue) {
		this.assetValue = assetValue;
	}

	public BigDecimal getAssetCfForeignCcy() {
		return assetCfForeignCcy;
	}

	public void setAssetCfForeignCcy(BigDecimal assetCfForeignCcy) {
		this.assetCfForeignCcy = assetCfForeignCcy;
	}

	public BigDecimal getAssetCfAed() {
		return assetCfAed;
	}

	public void setAssetCfAed(BigDecimal assetCfAed) {
		this.assetCfAed = assetCfAed;
	}

	public BigDecimal getLiabilityCfForeignCcy() {
		return liabilityCfForeignCcy;
	}

	public void setLiabilityCfForeignCcy(BigDecimal liabilityCfForeignCcy) {
		this.liabilityCfForeignCcy = liabilityCfForeignCcy;
	}

	public BigDecimal getLiabilityCfAed() {
		return liabilityCfAed;
	}

	public void setLiabilityCfAed(BigDecimal liabilityCfAed) {
		this.liabilityCfAed = liabilityCfAed;
	}

	public BigDecimal getEarCfForeignCcy() {
		return earCfForeignCcy;
	}

	public void setEarCfForeignCcy(BigDecimal earCfForeignCcy) {
		this.earCfForeignCcy = earCfForeignCcy;
	}

	public BigDecimal getEarCfAed() {
		return earCfAed;
	}

	public void setEarCfAed(BigDecimal earCfAed) {
		this.earCfAed = earCfAed;
	}

	public BigDecimal getAssetsLiabilitiesPortfolioDate() {
		return assetsLiabilitiesPortfolioDate;
	}

	public void setAssetsLiabilitiesPortfolioDate(BigDecimal assetsLiabilitiesPortfolioDate) {
		this.assetsLiabilitiesPortfolioDate = assetsLiabilitiesPortfolioDate;
	}

	public BigDecimal getAbsoluteDifference() {
		return absoluteDifference;
	}

	public void setAbsoluteDifference(BigDecimal absoluteDifference) {
		this.absoluteDifference = absoluteDifference;
	}

	public BigDecimal getPercentageDifference() {
		return percentageDifference;
	}

	public void setPercentageDifference(BigDecimal percentageDifference) {
		this.percentageDifference = percentageDifference;
	}

	public BigDecimal getReportedBehaviouralRepricingGap() {
		return reportedBehaviouralRepricingGap;
	}

	public void setReportedBehaviouralRepricingGap(BigDecimal reportedBehaviouralRepricingGap) {
		this.reportedBehaviouralRepricingGap = reportedBehaviouralRepricingGap;
	}

	public BigDecimal getRelativeDifference() {
		return relativeDifference;
	}

	public void setRelativeDifference(BigDecimal relativeDifference) {
		this.relativeDifference = relativeDifference;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
