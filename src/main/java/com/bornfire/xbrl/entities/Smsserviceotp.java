package com.bornfire.xbrl.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Smsserviceotp {

	@JsonProperty("WrapperApiKey")
	public String WrapperApiKey;
	@JsonProperty("smssenderid")
	public String smssenderid;
	@JsonProperty("smsmobilenumber")
	public String smsmobilenumber;
	@JsonProperty("smstext")
	public String smstext;
	@JsonProperty("Toemail")
	public String Toemail;
	@JsonProperty("emailsubject")
	public String emailsubject;
	@JsonProperty("emailtemplateid")
	public String emailtemplateid;
	@JsonProperty("emailtext")
	public String emailtext;

	public String getWrapperApiKey() {
		return WrapperApiKey;
	}

	public void setWrapperApiKey(String wrapperApiKey) {
		WrapperApiKey = wrapperApiKey;
	}

	public String getSmssenderid() {
		return smssenderid;
	}

	public void setSmssenderid(String smssenderid) {
		this.smssenderid = smssenderid;
	}

	public String getSmsmobilenumber() {
		return smsmobilenumber;
	}

	public void setSmsmobilenumber(String smsmobilenumber) {
		this.smsmobilenumber = smsmobilenumber;
	}

	public String getSmstext() {
		return smstext;
	}

	public void setSmstext(String smstext) {
		this.smstext = smstext;
	}

	public String getToemail() {
		return Toemail;
	}

	public void setToemail(String toemail) {
		Toemail = toemail;
	}

	public String getEmailsubject() {
		return emailsubject;
	}

	public void setEmailsubject(String emailsubject) {
		this.emailsubject = emailsubject;
	}

	public String getEmailtemplateid() {
		return emailtemplateid;
	}

	public void setEmailtemplateid(String emailtemplateid) {
		this.emailtemplateid = emailtemplateid;
	}

	public String getEmailtext() {
		return emailtext;
	}

	public void setEmailtext(String emailtext) {
		this.emailtext = emailtext;
	}

	@Override
	public String toString() {
		return "Smsserviceotp [WrapperApiKey=" + WrapperApiKey + ", smssenderid=" + smssenderid + ", smsmobilenumber="
				+ smsmobilenumber + ", smstext=" + smstext + ", Toemail=" + Toemail + ", emailsubject=" + emailsubject
				+ ", emailtemplateid=" + emailtemplateid + ", emailtext=" + emailtext + "]";
	}

	public Smsserviceotp(String wrapperApiKey, String smssenderid, String smsmobilenumber, String smstext,
			String toemail, String emailsubject, String emailtemplateid, String emailtext) {
		super();
		WrapperApiKey = wrapperApiKey;
		this.smssenderid = smssenderid;
		this.smsmobilenumber = smsmobilenumber;
		this.smstext = smstext;
		Toemail = toemail;
		this.emailsubject = emailsubject;
		this.emailtemplateid = emailtemplateid;
		this.emailtext = emailtext;
	}

	public Smsserviceotp() {
		super();
	}
}

