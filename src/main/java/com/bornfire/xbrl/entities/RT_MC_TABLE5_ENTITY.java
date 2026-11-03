package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@IdClass(MCReportId.class)
@Table(name = "RT_MC_TABLE5")
public class RT_MC_TABLE5_ENTITY {

	public String R8_BANK;
	public String R8_BNK_EMP_TYPE;
	public String R8_NO_CON_EMP_SPCD;
	public String R8_NO_EMP_LFI;
	public String R8_NO_DIS_POOR;
	public String R8_NO_CON_AGS;
	public String R8_NO_SAL_STF_EMP;
	public String R8_NO_FXD_RENUM;
	public String R8_NO_SAL_REN_50;
	public String R8_AVG_BON_CON;
	public String R8_NO_EMP_DIS_ACT;
	public String R8_NO_COM_SPC_PT;
	public String R8_NO_INS_COC_PT;
	public String R8_NO_WSTLE_RSK;
	public String R9_BANK;
	public String R9_BNK_EMP_TYPE;
	public String R9_NO_CON_EMP_SPCD;
	public String R9_NO_EMP_LFI;
	public String R9_NO_DIS_POOR;
	public String R9_NO_CON_AGS;
	public String R9_NO_SAL_STF_EMP;
	public String R9_NO_FXD_RENUM;
	public String R9_NO_SAL_REN_50;
	public String R9_AVG_BON_CON;
	public String R9_NO_EMP_DIS_ACT;
	public String R9_NO_COM_SPC_PT;
	public String R9_NO_INS_COC_PT;
	public String R9_NO_WSTLE_RSK;
	public String R10_BANK;
	public String R10_BNK_EMP_TYPE;
	public String R10_NO_CON_EMP_SPCD;
	public String R10_NO_EMP_LFI;
	public String R10_NO_DIS_POOR;
	public String R10_NO_CON_AGS;
	public String R10_NO_SAL_STF_EMP;
	public String R10_NO_FXD_RENUM;
	public String R10_NO_SAL_REN_50;
	public String R10_AVG_BON_CON;
	public String R10_NO_EMP_DIS_ACT;
	public String R10_NO_COM_SPC_PT;
	public String R10_NO_INS_COC_PT;
	public String R10_NO_WSTLE_RSK;
	public String R11_BANK;
	public String R11_BNK_EMP_TYPE;
	public String R11_NO_CON_EMP_SPCD;
	public String R11_NO_EMP_LFI;
	public String R11_NO_DIS_POOR;
	public String R11_NO_CON_AGS;
	public String R11_NO_SAL_STF_EMP;
	public String R11_NO_FXD_RENUM;
	public String R11_NO_SAL_REN_50;
	public String R11_AVG_BON_CON;
	public String R11_NO_EMP_DIS_ACT;
	public String R11_NO_COM_SPC_PT;
	public String R11_NO_INS_COC_PT;
	public String R11_NO_WSTLE_RSK;
	public String R12_BANK;
	public String R12_BNK_EMP_TYPE;
	public String R12_NO_CON_EMP_SPCD;
	public String R12_NO_EMP_LFI;
	public String R12_NO_DIS_POOR;
	public String R12_NO_CON_AGS;
	public String R12_NO_SAL_STF_EMP;
	public String R12_NO_FXD_RENUM;
	public String R12_NO_SAL_REN_50;
	public String R12_AVG_BON_CON;
	public String R12_NO_EMP_DIS_ACT;
	public String R12_NO_COM_SPC_PT;
	public String R12_NO_INS_COC_PT;
	public String R12_NO_WSTLE_RSK;
	public String R13_BANK;
	public String R13_BNK_EMP_TYPE;
	public String R13_NO_CON_EMP_SPCD;
	public String R13_NO_EMP_LFI;
	public String R13_NO_DIS_POOR;
	public String R13_NO_CON_AGS;
	public String R13_NO_SAL_STF_EMP;
	public String R13_NO_FXD_RENUM;
	public String R13_NO_SAL_REN_50;
	public String R13_AVG_BON_CON;
	public String R13_NO_EMP_DIS_ACT;
	public String R13_NO_COM_SPC_PT;
	public String R13_NO_INS_COC_PT;
	public String R13_NO_WSTLE_RSK;
	@Id
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	public Date REPORT_DATE;
	@Id
	public String BRANCH_CODE;
	public String ENTITY_FLG;
	public String MODIFY_FLG;
	public String DEL_FLG;
	public String SOLID;
	public String BRANCH_NAME;
	public String MODIFY_USERID;
	public String VERIFY_FLG;
	public String VERIFY_USERID;
	public String REMARKS;
	public String SIGNOFF_REMARKS;

	public String getSIGNOFF_REMARKS() {
		return SIGNOFF_REMARKS;
	}

	public void setSIGNOFF_REMARKS(String sIGNOFF_REMARKS) {
		SIGNOFF_REMARKS = sIGNOFF_REMARKS;
	}

	public String getREMARKS() {
		return REMARKS;
	}

	public void setREMARKS(String rEMARKS) {
		REMARKS = rEMARKS;
	}
	public String getR8_BANK() {
		return R8_BANK;
	}

	public void setR8_BANK(String r8_BANK) {
		R8_BANK = r8_BANK;
	}

	public String getR8_BNK_EMP_TYPE() {
		return R8_BNK_EMP_TYPE;
	}

	public void setR8_BNK_EMP_TYPE(String r8_BNK_EMP_TYPE) {
		R8_BNK_EMP_TYPE = r8_BNK_EMP_TYPE;
	}

	public String getR8_NO_CON_EMP_SPCD() {
		return R8_NO_CON_EMP_SPCD;
	}

	public void setR8_NO_CON_EMP_SPCD(String r8_NO_CON_EMP_SPCD) {
		R8_NO_CON_EMP_SPCD = r8_NO_CON_EMP_SPCD;
	}

	public String getR8_NO_EMP_LFI() {
		return R8_NO_EMP_LFI;
	}

	public void setR8_NO_EMP_LFI(String r8_NO_EMP_LFI) {
		R8_NO_EMP_LFI = r8_NO_EMP_LFI;
	}

	public String getR8_NO_DIS_POOR() {
		return R8_NO_DIS_POOR;
	}

	public void setR8_NO_DIS_POOR(String r8_NO_DIS_POOR) {
		R8_NO_DIS_POOR = r8_NO_DIS_POOR;
	}

	public String getR8_NO_CON_AGS() {
		return R8_NO_CON_AGS;
	}

	public void setR8_NO_CON_AGS(String r8_NO_CON_AGS) {
		R8_NO_CON_AGS = r8_NO_CON_AGS;
	}

	public String getR8_NO_SAL_STF_EMP() {
		return R8_NO_SAL_STF_EMP;
	}

	public void setR8_NO_SAL_STF_EMP(String r8_NO_SAL_STF_EMP) {
		R8_NO_SAL_STF_EMP = r8_NO_SAL_STF_EMP;
	}

	public String getR8_NO_FXD_RENUM() {
		return R8_NO_FXD_RENUM;
	}

	public void setR8_NO_FXD_RENUM(String r8_NO_FXD_RENUM) {
		R8_NO_FXD_RENUM = r8_NO_FXD_RENUM;
	}

	public String getR8_NO_SAL_REN_50() {
		return R8_NO_SAL_REN_50;
	}

	public void setR8_NO_SAL_REN_50(String r8_NO_SAL_REN_50) {
		R8_NO_SAL_REN_50 = r8_NO_SAL_REN_50;
	}

	public String getR8_AVG_BON_CON() {
		return R8_AVG_BON_CON;
	}

	public void setR8_AVG_BON_CON(String r8_AVG_BON_CON) {
		R8_AVG_BON_CON = r8_AVG_BON_CON;
	}

	public String getR8_NO_EMP_DIS_ACT() {
		return R8_NO_EMP_DIS_ACT;
	}

	public void setR8_NO_EMP_DIS_ACT(String r8_NO_EMP_DIS_ACT) {
		R8_NO_EMP_DIS_ACT = r8_NO_EMP_DIS_ACT;
	}

	public String getR8_NO_COM_SPC_PT() {
		return R8_NO_COM_SPC_PT;
	}

	public void setR8_NO_COM_SPC_PT(String r8_NO_COM_SPC_PT) {
		R8_NO_COM_SPC_PT = r8_NO_COM_SPC_PT;
	}

	public String getR8_NO_INS_COC_PT() {
		return R8_NO_INS_COC_PT;
	}

	public void setR8_NO_INS_COC_PT(String r8_NO_INS_COC_PT) {
		R8_NO_INS_COC_PT = r8_NO_INS_COC_PT;
	}

	public String getR8_NO_WSTLE_RSK() {
		return R8_NO_WSTLE_RSK;
	}

	public void setR8_NO_WSTLE_RSK(String r8_NO_WSTLE_RSK) {
		R8_NO_WSTLE_RSK = r8_NO_WSTLE_RSK;
	}

	public String getR9_BANK() {
		return R9_BANK;
	}

	public void setR9_BANK(String r9_BANK) {
		R9_BANK = r9_BANK;
	}

	public String getR9_BNK_EMP_TYPE() {
		return R9_BNK_EMP_TYPE;
	}

	public void setR9_BNK_EMP_TYPE(String r9_BNK_EMP_TYPE) {
		R9_BNK_EMP_TYPE = r9_BNK_EMP_TYPE;
	}

	public String getR9_NO_CON_EMP_SPCD() {
		return R9_NO_CON_EMP_SPCD;
	}

	public void setR9_NO_CON_EMP_SPCD(String r9_NO_CON_EMP_SPCD) {
		R9_NO_CON_EMP_SPCD = r9_NO_CON_EMP_SPCD;
	}

	public String getR9_NO_EMP_LFI() {
		return R9_NO_EMP_LFI;
	}

	public void setR9_NO_EMP_LFI(String r9_NO_EMP_LFI) {
		R9_NO_EMP_LFI = r9_NO_EMP_LFI;
	}

	public String getR9_NO_DIS_POOR() {
		return R9_NO_DIS_POOR;
	}

	public void setR9_NO_DIS_POOR(String r9_NO_DIS_POOR) {
		R9_NO_DIS_POOR = r9_NO_DIS_POOR;
	}

	public String getR9_NO_CON_AGS() {
		return R9_NO_CON_AGS;
	}

	public void setR9_NO_CON_AGS(String r9_NO_CON_AGS) {
		R9_NO_CON_AGS = r9_NO_CON_AGS;
	}

	public String getR9_NO_SAL_STF_EMP() {
		return R9_NO_SAL_STF_EMP;
	}

	public void setR9_NO_SAL_STF_EMP(String r9_NO_SAL_STF_EMP) {
		R9_NO_SAL_STF_EMP = r9_NO_SAL_STF_EMP;
	}

	public String getR9_NO_FXD_RENUM() {
		return R9_NO_FXD_RENUM;
	}

	public void setR9_NO_FXD_RENUM(String r9_NO_FXD_RENUM) {
		R9_NO_FXD_RENUM = r9_NO_FXD_RENUM;
	}

	public String getR9_NO_SAL_REN_50() {
		return R9_NO_SAL_REN_50;
	}

	public void setR9_NO_SAL_REN_50(String r9_NO_SAL_REN_50) {
		R9_NO_SAL_REN_50 = r9_NO_SAL_REN_50;
	}

	public String getR9_AVG_BON_CON() {
		return R9_AVG_BON_CON;
	}

	public void setR9_AVG_BON_CON(String r9_AVG_BON_CON) {
		R9_AVG_BON_CON = r9_AVG_BON_CON;
	}

	public String getR9_NO_EMP_DIS_ACT() {
		return R9_NO_EMP_DIS_ACT;
	}

	public void setR9_NO_EMP_DIS_ACT(String r9_NO_EMP_DIS_ACT) {
		R9_NO_EMP_DIS_ACT = r9_NO_EMP_DIS_ACT;
	}

	public String getR9_NO_COM_SPC_PT() {
		return R9_NO_COM_SPC_PT;
	}

	public void setR9_NO_COM_SPC_PT(String r9_NO_COM_SPC_PT) {
		R9_NO_COM_SPC_PT = r9_NO_COM_SPC_PT;
	}

	public String getR9_NO_INS_COC_PT() {
		return R9_NO_INS_COC_PT;
	}

	public void setR9_NO_INS_COC_PT(String r9_NO_INS_COC_PT) {
		R9_NO_INS_COC_PT = r9_NO_INS_COC_PT;
	}

	public String getR9_NO_WSTLE_RSK() {
		return R9_NO_WSTLE_RSK;
	}

	public void setR9_NO_WSTLE_RSK(String r9_NO_WSTLE_RSK) {
		R9_NO_WSTLE_RSK = r9_NO_WSTLE_RSK;
	}

	public String getR10_BANK() {
		return R10_BANK;
	}

	public void setR10_BANK(String r10_BANK) {
		R10_BANK = r10_BANK;
	}

	public String getR10_BNK_EMP_TYPE() {
		return R10_BNK_EMP_TYPE;
	}

	public void setR10_BNK_EMP_TYPE(String r10_BNK_EMP_TYPE) {
		R10_BNK_EMP_TYPE = r10_BNK_EMP_TYPE;
	}

	public String getR10_NO_CON_EMP_SPCD() {
		return R10_NO_CON_EMP_SPCD;
	}

	public void setR10_NO_CON_EMP_SPCD(String r10_NO_CON_EMP_SPCD) {
		R10_NO_CON_EMP_SPCD = r10_NO_CON_EMP_SPCD;
	}

	public String getR10_NO_EMP_LFI() {
		return R10_NO_EMP_LFI;
	}

	public void setR10_NO_EMP_LFI(String r10_NO_EMP_LFI) {
		R10_NO_EMP_LFI = r10_NO_EMP_LFI;
	}

	public String getR10_NO_DIS_POOR() {
		return R10_NO_DIS_POOR;
	}

	public void setR10_NO_DIS_POOR(String r10_NO_DIS_POOR) {
		R10_NO_DIS_POOR = r10_NO_DIS_POOR;
	}

	public String getR10_NO_CON_AGS() {
		return R10_NO_CON_AGS;
	}

	public void setR10_NO_CON_AGS(String r10_NO_CON_AGS) {
		R10_NO_CON_AGS = r10_NO_CON_AGS;
	}

	public String getR10_NO_SAL_STF_EMP() {
		return R10_NO_SAL_STF_EMP;
	}

	public void setR10_NO_SAL_STF_EMP(String r10_NO_SAL_STF_EMP) {
		R10_NO_SAL_STF_EMP = r10_NO_SAL_STF_EMP;
	}

	public String getR10_NO_FXD_RENUM() {
		return R10_NO_FXD_RENUM;
	}

	public void setR10_NO_FXD_RENUM(String r10_NO_FXD_RENUM) {
		R10_NO_FXD_RENUM = r10_NO_FXD_RENUM;
	}

	public String getR10_NO_SAL_REN_50() {
		return R10_NO_SAL_REN_50;
	}

	public void setR10_NO_SAL_REN_50(String r10_NO_SAL_REN_50) {
		R10_NO_SAL_REN_50 = r10_NO_SAL_REN_50;
	}

	public String getR10_AVG_BON_CON() {
		return R10_AVG_BON_CON;
	}

	public void setR10_AVG_BON_CON(String r10_AVG_BON_CON) {
		R10_AVG_BON_CON = r10_AVG_BON_CON;
	}

	public String getR10_NO_EMP_DIS_ACT() {
		return R10_NO_EMP_DIS_ACT;
	}

	public void setR10_NO_EMP_DIS_ACT(String r10_NO_EMP_DIS_ACT) {
		R10_NO_EMP_DIS_ACT = r10_NO_EMP_DIS_ACT;
	}

	public String getR10_NO_COM_SPC_PT() {
		return R10_NO_COM_SPC_PT;
	}

	public void setR10_NO_COM_SPC_PT(String r10_NO_COM_SPC_PT) {
		R10_NO_COM_SPC_PT = r10_NO_COM_SPC_PT;
	}

	public String getR10_NO_INS_COC_PT() {
		return R10_NO_INS_COC_PT;
	}

	public void setR10_NO_INS_COC_PT(String r10_NO_INS_COC_PT) {
		R10_NO_INS_COC_PT = r10_NO_INS_COC_PT;
	}

	public String getR10_NO_WSTLE_RSK() {
		return R10_NO_WSTLE_RSK;
	}

	public void setR10_NO_WSTLE_RSK(String r10_NO_WSTLE_RSK) {
		R10_NO_WSTLE_RSK = r10_NO_WSTLE_RSK;
	}

	public String getR11_BANK() {
		return R11_BANK;
	}

	public void setR11_BANK(String r11_BANK) {
		R11_BANK = r11_BANK;
	}

	public String getR11_BNK_EMP_TYPE() {
		return R11_BNK_EMP_TYPE;
	}

	public void setR11_BNK_EMP_TYPE(String r11_BNK_EMP_TYPE) {
		R11_BNK_EMP_TYPE = r11_BNK_EMP_TYPE;
	}

	public String getR11_NO_CON_EMP_SPCD() {
		return R11_NO_CON_EMP_SPCD;
	}

	public void setR11_NO_CON_EMP_SPCD(String r11_NO_CON_EMP_SPCD) {
		R11_NO_CON_EMP_SPCD = r11_NO_CON_EMP_SPCD;
	}

	public String getR11_NO_EMP_LFI() {
		return R11_NO_EMP_LFI;
	}

	public void setR11_NO_EMP_LFI(String r11_NO_EMP_LFI) {
		R11_NO_EMP_LFI = r11_NO_EMP_LFI;
	}

	public String getR11_NO_DIS_POOR() {
		return R11_NO_DIS_POOR;
	}

	public void setR11_NO_DIS_POOR(String r11_NO_DIS_POOR) {
		R11_NO_DIS_POOR = r11_NO_DIS_POOR;
	}

	public String getR11_NO_CON_AGS() {
		return R11_NO_CON_AGS;
	}

	public void setR11_NO_CON_AGS(String r11_NO_CON_AGS) {
		R11_NO_CON_AGS = r11_NO_CON_AGS;
	}

	public String getR11_NO_SAL_STF_EMP() {
		return R11_NO_SAL_STF_EMP;
	}

	public void setR11_NO_SAL_STF_EMP(String r11_NO_SAL_STF_EMP) {
		R11_NO_SAL_STF_EMP = r11_NO_SAL_STF_EMP;
	}

	public String getR11_NO_FXD_RENUM() {
		return R11_NO_FXD_RENUM;
	}

	public void setR11_NO_FXD_RENUM(String r11_NO_FXD_RENUM) {
		R11_NO_FXD_RENUM = r11_NO_FXD_RENUM;
	}

	public String getR11_NO_SAL_REN_50() {
		return R11_NO_SAL_REN_50;
	}

	public void setR11_NO_SAL_REN_50(String r11_NO_SAL_REN_50) {
		R11_NO_SAL_REN_50 = r11_NO_SAL_REN_50;
	}

	public String getR11_AVG_BON_CON() {
		return R11_AVG_BON_CON;
	}

	public void setR11_AVG_BON_CON(String r11_AVG_BON_CON) {
		R11_AVG_BON_CON = r11_AVG_BON_CON;
	}

	public String getR11_NO_EMP_DIS_ACT() {
		return R11_NO_EMP_DIS_ACT;
	}

	public void setR11_NO_EMP_DIS_ACT(String r11_NO_EMP_DIS_ACT) {
		R11_NO_EMP_DIS_ACT = r11_NO_EMP_DIS_ACT;
	}

	public String getR11_NO_COM_SPC_PT() {
		return R11_NO_COM_SPC_PT;
	}

	public void setR11_NO_COM_SPC_PT(String r11_NO_COM_SPC_PT) {
		R11_NO_COM_SPC_PT = r11_NO_COM_SPC_PT;
	}

	public String getR11_NO_INS_COC_PT() {
		return R11_NO_INS_COC_PT;
	}

	public void setR11_NO_INS_COC_PT(String r11_NO_INS_COC_PT) {
		R11_NO_INS_COC_PT = r11_NO_INS_COC_PT;
	}

	public String getR11_NO_WSTLE_RSK() {
		return R11_NO_WSTLE_RSK;
	}

	public void setR11_NO_WSTLE_RSK(String r11_NO_WSTLE_RSK) {
		R11_NO_WSTLE_RSK = r11_NO_WSTLE_RSK;
	}

	public String getR12_BANK() {
		return R12_BANK;
	}

	public void setR12_BANK(String r12_BANK) {
		R12_BANK = r12_BANK;
	}

	public String getR12_BNK_EMP_TYPE() {
		return R12_BNK_EMP_TYPE;
	}

	public void setR12_BNK_EMP_TYPE(String r12_BNK_EMP_TYPE) {
		R12_BNK_EMP_TYPE = r12_BNK_EMP_TYPE;
	}

	public String getR12_NO_CON_EMP_SPCD() {
		return R12_NO_CON_EMP_SPCD;
	}

	public void setR12_NO_CON_EMP_SPCD(String r12_NO_CON_EMP_SPCD) {
		R12_NO_CON_EMP_SPCD = r12_NO_CON_EMP_SPCD;
	}

	public String getR12_NO_EMP_LFI() {
		return R12_NO_EMP_LFI;
	}

	public void setR12_NO_EMP_LFI(String r12_NO_EMP_LFI) {
		R12_NO_EMP_LFI = r12_NO_EMP_LFI;
	}

	public String getR12_NO_DIS_POOR() {
		return R12_NO_DIS_POOR;
	}

	public void setR12_NO_DIS_POOR(String r12_NO_DIS_POOR) {
		R12_NO_DIS_POOR = r12_NO_DIS_POOR;
	}

	public String getR12_NO_CON_AGS() {
		return R12_NO_CON_AGS;
	}

	public void setR12_NO_CON_AGS(String r12_NO_CON_AGS) {
		R12_NO_CON_AGS = r12_NO_CON_AGS;
	}

	public String getR12_NO_SAL_STF_EMP() {
		return R12_NO_SAL_STF_EMP;
	}

	public void setR12_NO_SAL_STF_EMP(String r12_NO_SAL_STF_EMP) {
		R12_NO_SAL_STF_EMP = r12_NO_SAL_STF_EMP;
	}

	public String getR12_NO_FXD_RENUM() {
		return R12_NO_FXD_RENUM;
	}

	public void setR12_NO_FXD_RENUM(String r12_NO_FXD_RENUM) {
		R12_NO_FXD_RENUM = r12_NO_FXD_RENUM;
	}

	public String getR12_NO_SAL_REN_50() {
		return R12_NO_SAL_REN_50;
	}

	public void setR12_NO_SAL_REN_50(String r12_NO_SAL_REN_50) {
		R12_NO_SAL_REN_50 = r12_NO_SAL_REN_50;
	}

	public String getR12_AVG_BON_CON() {
		return R12_AVG_BON_CON;
	}

	public void setR12_AVG_BON_CON(String r12_AVG_BON_CON) {
		R12_AVG_BON_CON = r12_AVG_BON_CON;
	}

	public String getR12_NO_EMP_DIS_ACT() {
		return R12_NO_EMP_DIS_ACT;
	}

	public void setR12_NO_EMP_DIS_ACT(String r12_NO_EMP_DIS_ACT) {
		R12_NO_EMP_DIS_ACT = r12_NO_EMP_DIS_ACT;
	}

	public String getR12_NO_COM_SPC_PT() {
		return R12_NO_COM_SPC_PT;
	}

	public void setR12_NO_COM_SPC_PT(String r12_NO_COM_SPC_PT) {
		R12_NO_COM_SPC_PT = r12_NO_COM_SPC_PT;
	}

	public String getR12_NO_INS_COC_PT() {
		return R12_NO_INS_COC_PT;
	}

	public void setR12_NO_INS_COC_PT(String r12_NO_INS_COC_PT) {
		R12_NO_INS_COC_PT = r12_NO_INS_COC_PT;
	}

	public String getR12_NO_WSTLE_RSK() {
		return R12_NO_WSTLE_RSK;
	}

	public void setR12_NO_WSTLE_RSK(String r12_NO_WSTLE_RSK) {
		R12_NO_WSTLE_RSK = r12_NO_WSTLE_RSK;
	}

	public String getR13_BANK() {
		return R13_BANK;
	}

	public void setR13_BANK(String r13_BANK) {
		R13_BANK = r13_BANK;
	}

	public String getR13_BNK_EMP_TYPE() {
		return R13_BNK_EMP_TYPE;
	}

	public void setR13_BNK_EMP_TYPE(String r13_BNK_EMP_TYPE) {
		R13_BNK_EMP_TYPE = r13_BNK_EMP_TYPE;
	}

	public String getR13_NO_CON_EMP_SPCD() {
		return R13_NO_CON_EMP_SPCD;
	}

	public void setR13_NO_CON_EMP_SPCD(String r13_NO_CON_EMP_SPCD) {
		R13_NO_CON_EMP_SPCD = r13_NO_CON_EMP_SPCD;
	}

	public String getR13_NO_EMP_LFI() {
		return R13_NO_EMP_LFI;
	}

	public void setR13_NO_EMP_LFI(String r13_NO_EMP_LFI) {
		R13_NO_EMP_LFI = r13_NO_EMP_LFI;
	}

	public String getR13_NO_DIS_POOR() {
		return R13_NO_DIS_POOR;
	}

	public void setR13_NO_DIS_POOR(String r13_NO_DIS_POOR) {
		R13_NO_DIS_POOR = r13_NO_DIS_POOR;
	}

	public String getR13_NO_CON_AGS() {
		return R13_NO_CON_AGS;
	}

	public void setR13_NO_CON_AGS(String r13_NO_CON_AGS) {
		R13_NO_CON_AGS = r13_NO_CON_AGS;
	}

	public String getR13_NO_SAL_STF_EMP() {
		return R13_NO_SAL_STF_EMP;
	}

	public void setR13_NO_SAL_STF_EMP(String r13_NO_SAL_STF_EMP) {
		R13_NO_SAL_STF_EMP = r13_NO_SAL_STF_EMP;
	}

	public String getR13_NO_FXD_RENUM() {
		return R13_NO_FXD_RENUM;
	}

	public void setR13_NO_FXD_RENUM(String r13_NO_FXD_RENUM) {
		R13_NO_FXD_RENUM = r13_NO_FXD_RENUM;
	}

	public String getR13_NO_SAL_REN_50() {
		return R13_NO_SAL_REN_50;
	}

	public void setR13_NO_SAL_REN_50(String r13_NO_SAL_REN_50) {
		R13_NO_SAL_REN_50 = r13_NO_SAL_REN_50;
	}

	public String getR13_AVG_BON_CON() {
		return R13_AVG_BON_CON;
	}

	public void setR13_AVG_BON_CON(String r13_AVG_BON_CON) {
		R13_AVG_BON_CON = r13_AVG_BON_CON;
	}

	public String getR13_NO_EMP_DIS_ACT() {
		return R13_NO_EMP_DIS_ACT;
	}

	public void setR13_NO_EMP_DIS_ACT(String r13_NO_EMP_DIS_ACT) {
		R13_NO_EMP_DIS_ACT = r13_NO_EMP_DIS_ACT;
	}

	public String getR13_NO_COM_SPC_PT() {
		return R13_NO_COM_SPC_PT;
	}

	public void setR13_NO_COM_SPC_PT(String r13_NO_COM_SPC_PT) {
		R13_NO_COM_SPC_PT = r13_NO_COM_SPC_PT;
	}

	public String getR13_NO_INS_COC_PT() {
		return R13_NO_INS_COC_PT;
	}

	public void setR13_NO_INS_COC_PT(String r13_NO_INS_COC_PT) {
		R13_NO_INS_COC_PT = r13_NO_INS_COC_PT;
	}

	public String getR13_NO_WSTLE_RSK() {
		return R13_NO_WSTLE_RSK;
	}

	public void setR13_NO_WSTLE_RSK(String r13_NO_WSTLE_RSK) {
		R13_NO_WSTLE_RSK = r13_NO_WSTLE_RSK;
	}

	public Date getREPORT_DATE() {
		return REPORT_DATE;
	}

	public void setREPORT_DATE(Date rEPORT_DATE) {
		REPORT_DATE = rEPORT_DATE;
	}

	public String getBRANCH_CODE() {
		return BRANCH_CODE;
	}

	public void setBRANCH_CODE(String bRANCH_CODE) {
		BRANCH_CODE = bRANCH_CODE;
	}

	public String getENTITY_FLG() {
		return ENTITY_FLG;
	}

	public void setENTITY_FLG(String eNTITY_FLG) {
		ENTITY_FLG = eNTITY_FLG;
	}

	public String getMODIFY_FLG() {
		return MODIFY_FLG;
	}

	public void setMODIFY_FLG(String mODIFY_FLG) {
		MODIFY_FLG = mODIFY_FLG;
	}

	public String getDEL_FLG() {
		return DEL_FLG;
	}

	public void setDEL_FLG(String dEL_FLG) {
		DEL_FLG = dEL_FLG;
	}

	public String getSOLID() {
		return SOLID;
	}

	public void setSOLID(String sOLID) {
		SOLID = sOLID;
	}

	public String getBRANCH_NAME() {
		return BRANCH_NAME;
	}

	public void setBRANCH_NAME(String bRANCH_NAME) {
		BRANCH_NAME = bRANCH_NAME;
	}

	public String getMODIFY_USERID() {
		return MODIFY_USERID;
	}

	public void setMODIFY_USERID(String mODIFY_USERID) {
		MODIFY_USERID = mODIFY_USERID;
	}

	public String getVERIFY_FLG() {
		return VERIFY_FLG;
	}

	public void setVERIFY_FLG(String vERIFY_FLG) {
		VERIFY_FLG = vERIFY_FLG;
	}

	public String getVERIFY_USERID() {
		return VERIFY_USERID;
	}

	public void setVERIFY_USERID(String vERIFY_USERID) {
		VERIFY_USERID = vERIFY_USERID;
	}

}
