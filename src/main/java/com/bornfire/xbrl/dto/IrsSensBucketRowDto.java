package com.bornfire.xbrl.dto;

import java.math.BigDecimal;

/** One maturity bucket row for IRS sensitivity summary (R45 RSL / R84 RSA). */
public class IrsSensBucketRowDto {

	private String bucket;
	private String limitPct;
	private BigDecimal rsl;
	private BigDecimal rsa;

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	public String getLimitPct() {
		return limitPct;
	}

	public void setLimitPct(String limitPct) {
		this.limitPct = limitPct;
	}

	public BigDecimal getRsl() {
		return rsl;
	}

	public void setRsl(BigDecimal rsl) {
		this.rsl = rsl;
	}

	public BigDecimal getRsa() {
		return rsa;
	}

	public void setRsa(BigDecimal rsa) {
		this.rsa = rsa;
	}
}
