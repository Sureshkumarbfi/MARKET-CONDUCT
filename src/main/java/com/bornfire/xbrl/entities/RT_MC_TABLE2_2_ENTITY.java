package com.bornfire.xbrl.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@IdClass(MCReportId.class)
@Table(name = "RT_MC_TABLE2_2")
public class RT_MC_TABLE2_2_ENTITY {
	public String R15_BANK;
	public String R15_PRODUCT;
	public String R15_NO_WO_SD;
	public String R15_NO_CON_POD_SD;
	public String R15_NO_CON_UNAU_SP_TP;
	public String R15_NO_CON_45_50;
	public String R15_NO_CON_50;
	public String R15_NO_OF_LES_50;
	public String R15_NO_OF_BNK_18;
	public String R15_NO_OF_BNK_18_25;
	public String R15_NO_OF_BNK_26_35;
	public String R15_NO_OF_BNK_36_50;
	public String R15_NO_CON_BNK_50;
	public String R15_NO_CON_SAL_SPD;
	public String R15_NO_CON_BUS_SPD;
	public String R15_NO_CON_PRO_SPD;
	public String R15_NO_CON_INC_5K;
	public String R15_NO_CON_INC_5K_10K;
	public String R15_NO_CON_INC_10K_20K;
	public String R15_NO_CON_INC_20K_35K;
	public String R15_NO_CON_INC_35K;
	public String R15_NO_CON_BEL_SCL;
	public String R15_NO_CON_BAC;
	public String R15_NO_CON_ABV_MAS;
	public String R15_NO_CON_ABU_KYC;
	public String R15_NO_CON_DUB_KYC;
	public String R15_NO_CON_SHJ_KYC;
	public String R15_NO_CON_AJM_KYC;
	public String R15_NO_CON_FUJ_KYC;
	public String R15_NO_CON_RAK_KYC;
	public String R15_NO_CON_UAQ_KYC;
	public String R15_NO_CON_RET;
	public String R15_NO_CON_DBR_LIM;
	public String R15_NO_UAE_CON_SPC_TP;
	public String R15_NO_UAE_CON_NLS;
	public String R15_VAL_LOS_AED;
	public String R15_NO_CON_ONB_90;
	public String R15_NO_CON_BAL_PAY;
	public String R15_NO_CON_BAL_SPC_TP;
	public String R15_NO_CON_DEBT;
	public String R15_NO_CON_ONB_REF;
	public String R15_NO_CON_ONB_AGE;
	public String R15_NO_CON_AFF_UNAU;
	public String R15_NO_OF_ACCS_POD;
	public String R15_NO_DEL_CON;
	public String R15_NO_INS_FUN_LFI;
	public String R15_NO_CON_COL_FIN;
	public String R15_TOT_NO_NEW_FIN;
	public String R15_TOT_NO_NEW_NOSGN;
	public String R15_NO_CON_START;
	public String R15_NO_NEW_CON_ONBO;
	public String R15_NO_CON_DEBT_COUN;
	public String R15_NO_CON_DEL_NPA;
	public String R15_NO_CON_GOV_50;
	public String R15_NO_SME_SOLE;
	public String R15_NO_CON_TAG_VUL;
	public String R15_NO_NEW_CON_ONB_GNP;
	public String R15_NO_CON_END;
	public String R16_BANK;
	public String R16_PRODUCT;
	public String R16_NO_WO_SD;
	public String R16_NO_CON_POD_SD;
	public String R16_NO_CON_UNAU_SP_TP;
	public String R16_NO_CON_45_50;
	public String R16_NO_CON_50;
	public String R16_NO_OF_LES_50;
	public String R16_NO_OF_BNK_18;
	public String R16_NO_OF_BNK_18_25;
	public String R16_NO_OF_BNK_26_35;
	public String R16_NO_OF_BNK_36_50;
	public String R16_NO_CON_BNK_50;
	public String R16_NO_CON_SAL_SPD;
	public String R16_NO_CON_BUS_SPD;
	public String R16_NO_CON_PRO_SPD;
	public String R16_NO_CON_INC_5K;
	public String R16_NO_CON_INC_5K_10K;
	public String R16_NO_CON_INC_10K_20K;
	public String R16_NO_CON_INC_20K_35K;
	public String R16_NO_CON_INC_35K;
	public String R16_NO_CON_BEL_SCL;
	public String R16_NO_CON_BAC;
	public String R16_NO_CON_ABV_MAS;
	public String R16_NO_CON_ABU_KYC;
	public String R16_NO_CON_DUB_KYC;
	public String R16_NO_CON_SHJ_KYC;
	public String R16_NO_CON_AJM_KYC;
	public String R16_NO_CON_FUJ_KYC;
	public String R16_NO_CON_RAK_KYC;
	public String R16_NO_CON_UAQ_KYC;
	public String R16_NO_CON_RET;
	public String R16_NO_CON_DBR_LIM;
	public String R16_NO_UAE_CON_SPC_TP;
	public String R16_NO_UAE_CON_NLS;
	public String R16_VAL_LOS_AED;
	public String R16_NO_CON_ONB_90;
	public String R16_NO_CON_BAL_PAY;
	public String R16_NO_CON_BAL_SPC_TP;
	public String R16_NO_CON_DEBT;
	public String R16_NO_CON_ONB_REF;
	public String R16_NO_CON_ONB_AGE;
	public String R16_NO_CON_AFF_UNAU;
	public String R16_NO_OF_ACCS_POD;
	public String R16_NO_DEL_CON;
	public String R16_NO_INS_FUN_LFI;
	public String R16_NO_CON_COL_FIN;
	public String R16_TOT_NO_NEW_FIN;
	public String R16_TOT_NO_NEW_NOSGN;
	public String R16_NO_CON_START;
	public String R16_NO_NEW_CON_ONBO;
	public String R16_NO_CON_DEBT_COUN;
	public String R16_NO_CON_DEL_NPA;
	public String R16_NO_CON_GOV_50;
	public String R16_NO_SME_SOLE;
	public String R16_NO_CON_TAG_VUL;
	public String R16_NO_NEW_CON_ONB_GNP;
	public String R16_NO_CON_END;
	public String R17_BANK;
	public String R17_PRODUCT;
	public String R17_NO_WO_SD;
	public String R17_NO_CON_POD_SD;
	public String R17_NO_CON_UNAU_SP_TP;
	public String R17_NO_CON_45_50;
	public String R17_NO_CON_50;
	public String R17_NO_OF_LES_50;
	public String R17_NO_OF_BNK_18;
	public String R17_NO_OF_BNK_18_25;
	public String R17_NO_OF_BNK_26_35;
	public String R17_NO_OF_BNK_36_50;
	public String R17_NO_CON_BNK_50;
	public String R17_NO_CON_SAL_SPD;
	public String R17_NO_CON_BUS_SPD;
	public String R17_NO_CON_PRO_SPD;
	public String R17_NO_CON_INC_5K;
	public String R17_NO_CON_INC_5K_10K;
	public String R17_NO_CON_INC_10K_20K;
	public String R17_NO_CON_INC_20K_35K;
	public String R17_NO_CON_INC_35K;
	public String R17_NO_CON_BEL_SCL;
	public String R17_NO_CON_BAC;
	public String R17_NO_CON_ABV_MAS;
	public String R17_NO_CON_ABU_KYC;
	public String R17_NO_CON_DUB_KYC;
	public String R17_NO_CON_SHJ_KYC;
	public String R17_NO_CON_AJM_KYC;
	public String R17_NO_CON_FUJ_KYC;
	public String R17_NO_CON_RAK_KYC;
	public String R17_NO_CON_UAQ_KYC;
	public String R17_NO_CON_RET;
	public String R17_NO_CON_DBR_LIM;
	public String R17_NO_UAE_CON_SPC_TP;
	public String R17_NO_UAE_CON_NLS;
	public String R17_VAL_LOS_AED;
	public String R17_NO_CON_ONB_90;
	public String R17_NO_CON_BAL_PAY;
	public String R17_NO_CON_BAL_SPC_TP;
	public String R17_NO_CON_DEBT;
	public String R17_NO_CON_ONB_REF;
	public String R17_NO_CON_ONB_AGE;
	public String R17_NO_CON_AFF_UNAU;
	public String R17_NO_OF_ACCS_POD;
	public String R17_NO_DEL_CON;
	public String R17_NO_INS_FUN_LFI;
	public String R17_NO_CON_COL_FIN;
	public String R17_TOT_NO_NEW_FIN;
	public String R17_TOT_NO_NEW_NOSGN;
	public String R17_NO_CON_START;
	public String R17_NO_NEW_CON_ONBO;
	public String R17_NO_CON_DEBT_COUN;
	public String R17_NO_CON_DEL_NPA;
	public String R17_NO_CON_GOV_50;
	public String R17_NO_SME_SOLE;
	public String R17_NO_CON_TAG_VUL;
	public String R17_NO_NEW_CON_ONB_GNP;
	public String R17_NO_CON_END;
	public String R18_BANK;
	public String R18_PRODUCT;
	public String R18_NO_WO_SD;
	public String R18_NO_CON_POD_SD;
	public String R18_NO_CON_UNAU_SP_TP;
	public String R18_NO_CON_45_50;
	public String R18_NO_CON_50;
	public String R18_NO_OF_LES_50;
	public String R18_NO_OF_BNK_18;
	public String R18_NO_OF_BNK_18_25;
	public String R18_NO_OF_BNK_26_35;
	public String R18_NO_OF_BNK_36_50;
	public String R18_NO_CON_BNK_50;
	public String R18_NO_CON_SAL_SPD;
	public String R18_NO_CON_BUS_SPD;
	public String R18_NO_CON_PRO_SPD;
	public String R18_NO_CON_INC_5K;
	public String R18_NO_CON_INC_5K_10K;
	public String R18_NO_CON_INC_10K_20K;
	public String R18_NO_CON_INC_20K_35K;
	public String R18_NO_CON_INC_35K;
	public String R18_NO_CON_BEL_SCL;
	public String R18_NO_CON_BAC;
	public String R18_NO_CON_ABV_MAS;
	public String R18_NO_CON_ABU_KYC;
	public String R18_NO_CON_DUB_KYC;
	public String R18_NO_CON_SHJ_KYC;
	public String R18_NO_CON_AJM_KYC;
	public String R18_NO_CON_FUJ_KYC;
	public String R18_NO_CON_RAK_KYC;
	public String R18_NO_CON_UAQ_KYC;
	public String R18_NO_CON_RET;
	public String R18_NO_CON_DBR_LIM;
	public String R18_NO_UAE_CON_SPC_TP;
	public String R18_NO_UAE_CON_NLS;
	public String R18_VAL_LOS_AED;
	public String R18_NO_CON_ONB_90;
	public String R18_NO_CON_BAL_PAY;
	public String R18_NO_CON_BAL_SPC_TP;
	public String R18_NO_CON_DEBT;
	public String R18_NO_CON_ONB_REF;
	public String R18_NO_CON_ONB_AGE;
	public String R18_NO_CON_AFF_UNAU;
	public String R18_NO_OF_ACCS_POD;
	public String R18_NO_DEL_CON;
	public String R18_NO_INS_FUN_LFI;
	public String R18_NO_CON_COL_FIN;
	public String R18_TOT_NO_NEW_FIN;
	public String R18_TOT_NO_NEW_NOSGN;
	public String R18_NO_CON_START;
	public String R18_NO_NEW_CON_ONBO;
	public String R18_NO_CON_DEBT_COUN;
	public String R18_NO_CON_DEL_NPA;
	public String R18_NO_CON_GOV_50;
	public String R18_NO_SME_SOLE;
	public String R18_NO_CON_TAG_VUL;
	public String R18_NO_NEW_CON_ONB_GNP;
	public String R18_NO_CON_END;
	public String R19_BANK;
	public String R19_PRODUCT;
	public String R19_NO_WO_SD;
	public String R19_NO_CON_POD_SD;
	public String R19_NO_CON_UNAU_SP_TP;
	public String R19_NO_CON_45_50;
	public String R19_NO_CON_50;
	public String R19_NO_OF_LES_50;
	public String R19_NO_OF_BNK_18;
	public String R19_NO_OF_BNK_18_25;
	public String R19_NO_OF_BNK_26_35;
	public String R19_NO_OF_BNK_36_50;
	public String R19_NO_CON_BNK_50;
	public String R19_NO_CON_SAL_SPD;
	public String R19_NO_CON_BUS_SPD;
	public String R19_NO_CON_PRO_SPD;
	public String R19_NO_CON_INC_5K;
	public String R19_NO_CON_INC_5K_10K;
	public String R19_NO_CON_INC_10K_20K;
	public String R19_NO_CON_INC_20K_35K;
	public String R19_NO_CON_INC_35K;
	public String R19_NO_CON_BEL_SCL;
	public String R19_NO_CON_BAC;
	public String R19_NO_CON_ABV_MAS;
	public String R19_NO_CON_ABU_KYC;
	public String R19_NO_CON_DUB_KYC;
	public String R19_NO_CON_SHJ_KYC;
	public String R19_NO_CON_AJM_KYC;
	public String R19_NO_CON_FUJ_KYC;
	public String R19_NO_CON_RAK_KYC;
	public String R19_NO_CON_UAQ_KYC;
	public String R19_NO_CON_RET;
	public String R19_NO_CON_DBR_LIM;
	public String R19_NO_UAE_CON_SPC_TP;
	public String R19_NO_UAE_CON_NLS;
	public String R19_VAL_LOS_AED;
	public String R19_NO_CON_ONB_90;
	public String R19_NO_CON_BAL_PAY;
	public String R19_NO_CON_BAL_SPC_TP;
	public String R19_NO_CON_DEBT;
	public String R19_NO_CON_ONB_REF;
	public String R19_NO_CON_ONB_AGE;
	public String R19_NO_CON_AFF_UNAU;
	public String R19_NO_OF_ACCS_POD;
	public String R19_NO_DEL_CON;
	public String R19_NO_INS_FUN_LFI;
	public String R19_NO_CON_COL_FIN;
	public String R19_TOT_NO_NEW_FIN;
	public String R19_TOT_NO_NEW_NOSGN;
	public String R19_NO_CON_START;
	public String R19_NO_NEW_CON_ONBO;
	public String R19_NO_CON_DEBT_COUN;
	public String R19_NO_CON_DEL_NPA;
	public String R19_NO_CON_GOV_50;
	public String R19_NO_SME_SOLE;
	public String R19_NO_CON_TAG_VUL;
	public String R19_NO_NEW_CON_ONB_GNP;
	public String R19_NO_CON_END;
	public String R20_BANK;
	public String R20_PRODUCT;
	public String R20_NO_WO_SD;
	public String R20_NO_CON_POD_SD;
	public String R20_NO_CON_UNAU_SP_TP;
	public String R20_NO_CON_45_50;
	public String R20_NO_CON_50;
	public String R20_NO_OF_LES_50;
	public String R20_NO_OF_BNK_18;
	public String R20_NO_OF_BNK_18_25;
	public String R20_NO_OF_BNK_26_35;
	public String R20_NO_OF_BNK_36_50;
	public String R20_NO_CON_BNK_50;
	public String R20_NO_CON_SAL_SPD;
	public String R20_NO_CON_BUS_SPD;
	public String R20_NO_CON_PRO_SPD;
	public String R20_NO_CON_INC_5K;
	public String R20_NO_CON_INC_5K_10K;
	public String R20_NO_CON_INC_10K_20K;
	public String R20_NO_CON_INC_20K_35K;
	public String R20_NO_CON_INC_35K;
	public String R20_NO_CON_BEL_SCL;
	public String R20_NO_CON_BAC;
	public String R20_NO_CON_ABV_MAS;
	public String R20_NO_CON_ABU_KYC;
	public String R20_NO_CON_DUB_KYC;
	public String R20_NO_CON_SHJ_KYC;
	public String R20_NO_CON_AJM_KYC;
	public String R20_NO_CON_FUJ_KYC;
	public String R20_NO_CON_RAK_KYC;
	public String R20_NO_CON_UAQ_KYC;
	public String R20_NO_CON_RET;
	public String R20_NO_CON_DBR_LIM;
	public String R20_NO_UAE_CON_SPC_TP;
	public String R20_NO_UAE_CON_NLS;
	public String R20_VAL_LOS_AED;
	public String R20_NO_CON_ONB_90;
	public String R20_NO_CON_BAL_PAY;
	public String R20_NO_CON_BAL_SPC_TP;
	public String R20_NO_CON_DEBT;
	public String R20_NO_CON_ONB_REF;
	public String R20_NO_CON_ONB_AGE;
	public String R20_NO_CON_AFF_UNAU;
	public String R20_NO_OF_ACCS_POD;
	public String R20_NO_DEL_CON;
	public String R20_NO_INS_FUN_LFI;
	public String R20_NO_CON_COL_FIN;
	public String R20_TOT_NO_NEW_FIN;
	public String R20_TOT_NO_NEW_NOSGN;
	public String R20_NO_CON_START;
	public String R20_NO_NEW_CON_ONBO;
	public String R20_NO_CON_DEBT_COUN;
	public String R20_NO_CON_DEL_NPA;
	public String R20_NO_CON_GOV_50;
	public String R20_NO_SME_SOLE;
	public String R20_NO_CON_TAG_VUL;
	public String R20_NO_NEW_CON_ONB_GNP;
	public String R20_NO_CON_END;
	public String R21_BANK;
	public String R21_PRODUCT;
	public String R21_NO_WO_SD;
	public String R21_NO_CON_POD_SD;
	public String R21_NO_CON_UNAU_SP_TP;
	public String R21_NO_CON_45_50;
	public String R21_NO_CON_50;
	public String R21_NO_OF_LES_50;
	public String R21_NO_OF_BNK_18;
	public String R21_NO_OF_BNK_18_25;
	public String R21_NO_OF_BNK_26_35;
	public String R21_NO_OF_BNK_36_50;
	public String R21_NO_CON_BNK_50;
	public String R21_NO_CON_SAL_SPD;
	public String R21_NO_CON_BUS_SPD;
	public String R21_NO_CON_PRO_SPD;
	public String R21_NO_CON_INC_5K;
	public String R21_NO_CON_INC_5K_10K;
	public String R21_NO_CON_INC_10K_20K;
	public String R21_NO_CON_INC_20K_35K;
	public String R21_NO_CON_INC_35K;
	public String R21_NO_CON_BEL_SCL;
	public String R21_NO_CON_BAC;
	public String R21_NO_CON_ABV_MAS;
	public String R21_NO_CON_ABU_KYC;
	public String R21_NO_CON_DUB_KYC;
	public String R21_NO_CON_SHJ_KYC;
	public String R21_NO_CON_AJM_KYC;
	public String R21_NO_CON_FUJ_KYC;
	public String R21_NO_CON_RAK_KYC;
	public String R21_NO_CON_UAQ_KYC;
	public String R21_NO_CON_RET;
	public String R21_NO_CON_DBR_LIM;
	public String R21_NO_UAE_CON_SPC_TP;
	public String R21_NO_UAE_CON_NLS;
	public String R21_VAL_LOS_AED;
	public String R21_NO_CON_ONB_90;
	public String R21_NO_CON_BAL_PAY;
	public String R21_NO_CON_BAL_SPC_TP;
	public String R21_NO_CON_DEBT;
	public String R21_NO_CON_ONB_REF;
	public String R21_NO_CON_ONB_AGE;
	public String R21_NO_CON_AFF_UNAU;
	public String R21_NO_OF_ACCS_POD;
	public String R21_NO_DEL_CON;
	public String R21_NO_INS_FUN_LFI;
	public String R21_NO_CON_COL_FIN;
	public String R21_TOT_NO_NEW_FIN;
	public String R21_TOT_NO_NEW_NOSGN;
	public String R21_NO_CON_START;
	public String R21_NO_NEW_CON_ONBO;
	public String R21_NO_CON_DEBT_COUN;
	public String R21_NO_CON_DEL_NPA;
	public String R21_NO_CON_GOV_50;
	public String R21_NO_SME_SOLE;
	public String R21_NO_CON_TAG_VUL;
	public String R21_NO_NEW_CON_ONB_GNP;
	public String R21_NO_CON_END;
	public String R22_BANK;
	public String R22_PRODUCT;
	public String R22_NO_WO_SD;
	public String R22_NO_CON_POD_SD;
	public String R22_NO_CON_UNAU_SP_TP;
	public String R22_NO_CON_45_50;
	public String R22_NO_CON_50;
	public String R22_NO_OF_LES_50;
	public String R22_NO_OF_BNK_18;
	public String R22_NO_OF_BNK_18_25;
	public String R22_NO_OF_BNK_26_35;
	public String R22_NO_OF_BNK_36_50;
	public String R22_NO_CON_BNK_50;
	public String R22_NO_CON_SAL_SPD;
	public String R22_NO_CON_BUS_SPD;
	public String R22_NO_CON_PRO_SPD;
	public String R22_NO_CON_INC_5K;
	public String R22_NO_CON_INC_5K_10K;
	public String R22_NO_CON_INC_10K_20K;
	public String R22_NO_CON_INC_20K_35K;
	public String R22_NO_CON_INC_35K;
	public String R22_NO_CON_BEL_SCL;
	public String R22_NO_CON_BAC;
	public String R22_NO_CON_ABV_MAS;
	public String R22_NO_CON_ABU_KYC;
	public String R22_NO_CON_DUB_KYC;
	public String R22_NO_CON_SHJ_KYC;
	public String R22_NO_CON_AJM_KYC;
	public String R22_NO_CON_FUJ_KYC;
	public String R22_NO_CON_RAK_KYC;
	public String R22_NO_CON_UAQ_KYC;
	public String R22_NO_CON_RET;
	public String R22_NO_CON_DBR_LIM;
	public String R22_NO_UAE_CON_SPC_TP;
	public String R22_NO_UAE_CON_NLS;
	public String R22_VAL_LOS_AED;
	public String R22_NO_CON_ONB_90;
	public String R22_NO_CON_BAL_PAY;
	public String R22_NO_CON_BAL_SPC_TP;
	public String R22_NO_CON_DEBT;
	public String R22_NO_CON_ONB_REF;
	public String R22_NO_CON_ONB_AGE;
	public String R22_NO_CON_AFF_UNAU;
	public String R22_NO_OF_ACCS_POD;
	public String R22_NO_DEL_CON;
	public String R22_NO_INS_FUN_LFI;
	public String R22_NO_CON_COL_FIN;
	public String R22_TOT_NO_NEW_FIN;
	public String R22_TOT_NO_NEW_NOSGN;
	public String R22_NO_CON_START;
	public String R22_NO_NEW_CON_ONBO;
	public String R22_NO_CON_DEBT_COUN;
	public String R22_NO_CON_DEL_NPA;
	public String R22_NO_CON_GOV_50;
	public String R22_NO_SME_SOLE;
	public String R22_NO_CON_TAG_VUL;
	public String R22_NO_NEW_CON_ONB_GNP;
	public String R22_NO_CON_END;
	public String R23_BANK;
	public String R23_PRODUCT;
	public String R23_NO_WO_SD;
	public String R23_NO_CON_POD_SD;
	public String R23_NO_CON_UNAU_SP_TP;
	public String R23_NO_CON_45_50;
	public String R23_NO_CON_50;
	public String R23_NO_OF_LES_50;
	public String R23_NO_OF_BNK_18;
	public String R23_NO_OF_BNK_18_25;
	public String R23_NO_OF_BNK_26_35;
	public String R23_NO_OF_BNK_36_50;
	public String R23_NO_CON_BNK_50;
	public String R23_NO_CON_SAL_SPD;
	public String R23_NO_CON_BUS_SPD;
	public String R23_NO_CON_PRO_SPD;
	public String R23_NO_CON_INC_5K;
	public String R23_NO_CON_INC_5K_10K;
	public String R23_NO_CON_INC_10K_20K;
	public String R23_NO_CON_INC_20K_35K;
	public String R23_NO_CON_INC_35K;
	public String R23_NO_CON_BEL_SCL;
	public String R23_NO_CON_BAC;
	public String R23_NO_CON_ABV_MAS;
	public String R23_NO_CON_ABU_KYC;
	public String R23_NO_CON_DUB_KYC;
	public String R23_NO_CON_SHJ_KYC;
	public String R23_NO_CON_AJM_KYC;
	public String R23_NO_CON_FUJ_KYC;
	public String R23_NO_CON_RAK_KYC;
	public String R23_NO_CON_UAQ_KYC;
	public String R23_NO_CON_RET;
	public String R23_NO_CON_DBR_LIM;
	public String R23_NO_UAE_CON_SPC_TP;
	public String R23_NO_UAE_CON_NLS;
	public String R23_VAL_LOS_AED;
	public String R23_NO_CON_ONB_90;
	public String R23_NO_CON_BAL_PAY;
	public String R23_NO_CON_BAL_SPC_TP;
	public String R23_NO_CON_DEBT;
	public String R23_NO_CON_ONB_REF;
	public String R23_NO_CON_ONB_AGE;
	public String R23_NO_CON_AFF_UNAU;
	public String R23_NO_OF_ACCS_POD;
	public String R23_NO_DEL_CON;
	public String R23_NO_INS_FUN_LFI;
	public String R23_NO_CON_COL_FIN;
	public String R23_TOT_NO_NEW_FIN;
	public String R23_TOT_NO_NEW_NOSGN;
	public String R23_NO_CON_START;
	public String R23_NO_NEW_CON_ONBO;
	public String R23_NO_CON_DEBT_COUN;
	public String R23_NO_CON_DEL_NPA;
	public String R23_NO_CON_GOV_50;
	public String R23_NO_SME_SOLE;
	public String R23_NO_CON_TAG_VUL;
	public String R23_NO_NEW_CON_ONB_GNP;
	public String R23_NO_CON_END;
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
	public String getR15_BANK() {
		return R15_BANK;
	}

	public void setR15_BANK(String r15_BANK) {
		R15_BANK = r15_BANK;
	}

	public String getR15_PRODUCT() {
		return R15_PRODUCT;
	}

	public void setR15_PRODUCT(String r15_PRODUCT) {
		R15_PRODUCT = r15_PRODUCT;
	}

	public String getR15_NO_WO_SD() {
		return R15_NO_WO_SD;
	}

	public void setR15_NO_WO_SD(String r15_NO_WO_SD) {
		R15_NO_WO_SD = r15_NO_WO_SD;
	}

	public String getR15_NO_CON_POD_SD() {
		return R15_NO_CON_POD_SD;
	}

	public void setR15_NO_CON_POD_SD(String r15_NO_CON_POD_SD) {
		R15_NO_CON_POD_SD = r15_NO_CON_POD_SD;
	}

	public String getR15_NO_CON_UNAU_SP_TP() {
		return R15_NO_CON_UNAU_SP_TP;
	}

	public void setR15_NO_CON_UNAU_SP_TP(String r15_NO_CON_UNAU_SP_TP) {
		R15_NO_CON_UNAU_SP_TP = r15_NO_CON_UNAU_SP_TP;
	}

	public String getR15_NO_CON_45_50() {
		return R15_NO_CON_45_50;
	}

	public void setR15_NO_CON_45_50(String r15_NO_CON_45_50) {
		R15_NO_CON_45_50 = r15_NO_CON_45_50;
	}

	public String getR15_NO_CON_50() {
		return R15_NO_CON_50;
	}

	public void setR15_NO_CON_50(String r15_NO_CON_50) {
		R15_NO_CON_50 = r15_NO_CON_50;
	}

	public String getR15_NO_OF_LES_50() {
		return R15_NO_OF_LES_50;
	}

	public void setR15_NO_OF_LES_50(String r15_NO_OF_LES_50) {
		R15_NO_OF_LES_50 = r15_NO_OF_LES_50;
	}

	public String getR15_NO_OF_BNK_18() {
		return R15_NO_OF_BNK_18;
	}

	public void setR15_NO_OF_BNK_18(String r15_NO_OF_BNK_18) {
		R15_NO_OF_BNK_18 = r15_NO_OF_BNK_18;
	}

	public String getR15_NO_OF_BNK_18_25() {
		return R15_NO_OF_BNK_18_25;
	}

	public void setR15_NO_OF_BNK_18_25(String r15_NO_OF_BNK_18_25) {
		R15_NO_OF_BNK_18_25 = r15_NO_OF_BNK_18_25;
	}

	public String getR15_NO_OF_BNK_26_35() {
		return R15_NO_OF_BNK_26_35;
	}

	public void setR15_NO_OF_BNK_26_35(String r15_NO_OF_BNK_26_35) {
		R15_NO_OF_BNK_26_35 = r15_NO_OF_BNK_26_35;
	}

	public String getR15_NO_OF_BNK_36_50() {
		return R15_NO_OF_BNK_36_50;
	}

	public void setR15_NO_OF_BNK_36_50(String r15_NO_OF_BNK_36_50) {
		R15_NO_OF_BNK_36_50 = r15_NO_OF_BNK_36_50;
	}

	public String getR15_NO_CON_BNK_50() {
		return R15_NO_CON_BNK_50;
	}

	public void setR15_NO_CON_BNK_50(String r15_NO_CON_BNK_50) {
		R15_NO_CON_BNK_50 = r15_NO_CON_BNK_50;
	}

	public String getR15_NO_CON_SAL_SPD() {
		return R15_NO_CON_SAL_SPD;
	}

	public void setR15_NO_CON_SAL_SPD(String r15_NO_CON_SAL_SPD) {
		R15_NO_CON_SAL_SPD = r15_NO_CON_SAL_SPD;
	}

	public String getR15_NO_CON_BUS_SPD() {
		return R15_NO_CON_BUS_SPD;
	}

	public void setR15_NO_CON_BUS_SPD(String r15_NO_CON_BUS_SPD) {
		R15_NO_CON_BUS_SPD = r15_NO_CON_BUS_SPD;
	}

	public String getR15_NO_CON_PRO_SPD() {
		return R15_NO_CON_PRO_SPD;
	}

	public void setR15_NO_CON_PRO_SPD(String r15_NO_CON_PRO_SPD) {
		R15_NO_CON_PRO_SPD = r15_NO_CON_PRO_SPD;
	}

	public String getR15_NO_CON_INC_5K() {
		return R15_NO_CON_INC_5K;
	}

	public void setR15_NO_CON_INC_5K(String r15_NO_CON_INC_5K) {
		R15_NO_CON_INC_5K = r15_NO_CON_INC_5K;
	}

	public String getR15_NO_CON_INC_5K_10K() {
		return R15_NO_CON_INC_5K_10K;
	}

	public void setR15_NO_CON_INC_5K_10K(String r15_NO_CON_INC_5K_10K) {
		R15_NO_CON_INC_5K_10K = r15_NO_CON_INC_5K_10K;
	}

	public String getR15_NO_CON_INC_10K_20K() {
		return R15_NO_CON_INC_10K_20K;
	}

	public void setR15_NO_CON_INC_10K_20K(String r15_NO_CON_INC_10K_20K) {
		R15_NO_CON_INC_10K_20K = r15_NO_CON_INC_10K_20K;
	}

	public String getR15_NO_CON_INC_20K_35K() {
		return R15_NO_CON_INC_20K_35K;
	}

	public void setR15_NO_CON_INC_20K_35K(String r15_NO_CON_INC_20K_35K) {
		R15_NO_CON_INC_20K_35K = r15_NO_CON_INC_20K_35K;
	}

	public String getR15_NO_CON_INC_35K() {
		return R15_NO_CON_INC_35K;
	}

	public void setR15_NO_CON_INC_35K(String r15_NO_CON_INC_35K) {
		R15_NO_CON_INC_35K = r15_NO_CON_INC_35K;
	}

	public String getR15_NO_CON_BEL_SCL() {
		return R15_NO_CON_BEL_SCL;
	}

	public void setR15_NO_CON_BEL_SCL(String r15_NO_CON_BEL_SCL) {
		R15_NO_CON_BEL_SCL = r15_NO_CON_BEL_SCL;
	}

	public String getR15_NO_CON_BAC() {
		return R15_NO_CON_BAC;
	}

	public void setR15_NO_CON_BAC(String r15_NO_CON_BAC) {
		R15_NO_CON_BAC = r15_NO_CON_BAC;
	}

	public String getR15_NO_CON_ABV_MAS() {
		return R15_NO_CON_ABV_MAS;
	}

	public void setR15_NO_CON_ABV_MAS(String r15_NO_CON_ABV_MAS) {
		R15_NO_CON_ABV_MAS = r15_NO_CON_ABV_MAS;
	}

	public String getR15_NO_CON_ABU_KYC() {
		return R15_NO_CON_ABU_KYC;
	}

	public void setR15_NO_CON_ABU_KYC(String r15_NO_CON_ABU_KYC) {
		R15_NO_CON_ABU_KYC = r15_NO_CON_ABU_KYC;
	}

	public String getR15_NO_CON_DUB_KYC() {
		return R15_NO_CON_DUB_KYC;
	}

	public void setR15_NO_CON_DUB_KYC(String r15_NO_CON_DUB_KYC) {
		R15_NO_CON_DUB_KYC = r15_NO_CON_DUB_KYC;
	}

	public String getR15_NO_CON_SHJ_KYC() {
		return R15_NO_CON_SHJ_KYC;
	}

	public void setR15_NO_CON_SHJ_KYC(String r15_NO_CON_SHJ_KYC) {
		R15_NO_CON_SHJ_KYC = r15_NO_CON_SHJ_KYC;
	}

	public String getR15_NO_CON_AJM_KYC() {
		return R15_NO_CON_AJM_KYC;
	}

	public void setR15_NO_CON_AJM_KYC(String r15_NO_CON_AJM_KYC) {
		R15_NO_CON_AJM_KYC = r15_NO_CON_AJM_KYC;
	}

	public String getR15_NO_CON_FUJ_KYC() {
		return R15_NO_CON_FUJ_KYC;
	}

	public void setR15_NO_CON_FUJ_KYC(String r15_NO_CON_FUJ_KYC) {
		R15_NO_CON_FUJ_KYC = r15_NO_CON_FUJ_KYC;
	}

	public String getR15_NO_CON_RAK_KYC() {
		return R15_NO_CON_RAK_KYC;
	}

	public void setR15_NO_CON_RAK_KYC(String r15_NO_CON_RAK_KYC) {
		R15_NO_CON_RAK_KYC = r15_NO_CON_RAK_KYC;
	}

	public String getR15_NO_CON_UAQ_KYC() {
		return R15_NO_CON_UAQ_KYC;
	}

	public void setR15_NO_CON_UAQ_KYC(String r15_NO_CON_UAQ_KYC) {
		R15_NO_CON_UAQ_KYC = r15_NO_CON_UAQ_KYC;
	}

	public String getR15_NO_CON_RET() {
		return R15_NO_CON_RET;
	}

	public void setR15_NO_CON_RET(String r15_NO_CON_RET) {
		R15_NO_CON_RET = r15_NO_CON_RET;
	}

	public String getR15_NO_CON_DBR_LIM() {
		return R15_NO_CON_DBR_LIM;
	}

	public void setR15_NO_CON_DBR_LIM(String r15_NO_CON_DBR_LIM) {
		R15_NO_CON_DBR_LIM = r15_NO_CON_DBR_LIM;
	}

	public String getR15_NO_UAE_CON_SPC_TP() {
		return R15_NO_UAE_CON_SPC_TP;
	}

	public void setR15_NO_UAE_CON_SPC_TP(String r15_NO_UAE_CON_SPC_TP) {
		R15_NO_UAE_CON_SPC_TP = r15_NO_UAE_CON_SPC_TP;
	}

	public String getR15_NO_UAE_CON_NLS() {
		return R15_NO_UAE_CON_NLS;
	}

	public void setR15_NO_UAE_CON_NLS(String r15_NO_UAE_CON_NLS) {
		R15_NO_UAE_CON_NLS = r15_NO_UAE_CON_NLS;
	}

	public String getR15_VAL_LOS_AED() {
		return R15_VAL_LOS_AED;
	}

	public void setR15_VAL_LOS_AED(String r15_VAL_LOS_AED) {
		R15_VAL_LOS_AED = r15_VAL_LOS_AED;
	}

	public String getR15_NO_CON_ONB_90() {
		return R15_NO_CON_ONB_90;
	}

	public void setR15_NO_CON_ONB_90(String r15_NO_CON_ONB_90) {
		R15_NO_CON_ONB_90 = r15_NO_CON_ONB_90;
	}

	public String getR15_NO_CON_BAL_PAY() {
		return R15_NO_CON_BAL_PAY;
	}

	public void setR15_NO_CON_BAL_PAY(String r15_NO_CON_BAL_PAY) {
		R15_NO_CON_BAL_PAY = r15_NO_CON_BAL_PAY;
	}

	public String getR15_NO_CON_BAL_SPC_TP() {
		return R15_NO_CON_BAL_SPC_TP;
	}

	public void setR15_NO_CON_BAL_SPC_TP(String r15_NO_CON_BAL_SPC_TP) {
		R15_NO_CON_BAL_SPC_TP = r15_NO_CON_BAL_SPC_TP;
	}

	public String getR15_NO_CON_DEBT() {
		return R15_NO_CON_DEBT;
	}

	public void setR15_NO_CON_DEBT(String r15_NO_CON_DEBT) {
		R15_NO_CON_DEBT = r15_NO_CON_DEBT;
	}

	public String getR15_NO_CON_ONB_REF() {
		return R15_NO_CON_ONB_REF;
	}

	public void setR15_NO_CON_ONB_REF(String r15_NO_CON_ONB_REF) {
		R15_NO_CON_ONB_REF = r15_NO_CON_ONB_REF;
	}

	public String getR15_NO_CON_ONB_AGE() {
		return R15_NO_CON_ONB_AGE;
	}

	public void setR15_NO_CON_ONB_AGE(String r15_NO_CON_ONB_AGE) {
		R15_NO_CON_ONB_AGE = r15_NO_CON_ONB_AGE;
	}

	public String getR15_NO_CON_AFF_UNAU() {
		return R15_NO_CON_AFF_UNAU;
	}

	public void setR15_NO_CON_AFF_UNAU(String r15_NO_CON_AFF_UNAU) {
		R15_NO_CON_AFF_UNAU = r15_NO_CON_AFF_UNAU;
	}

	public String getR15_NO_OF_ACCS_POD() {
		return R15_NO_OF_ACCS_POD;
	}

	public void setR15_NO_OF_ACCS_POD(String r15_NO_OF_ACCS_POD) {
		R15_NO_OF_ACCS_POD = r15_NO_OF_ACCS_POD;
	}

	public String getR15_NO_DEL_CON() {
		return R15_NO_DEL_CON;
	}

	public void setR15_NO_DEL_CON(String r15_NO_DEL_CON) {
		R15_NO_DEL_CON = r15_NO_DEL_CON;
	}

	public String getR15_NO_INS_FUN_LFI() {
		return R15_NO_INS_FUN_LFI;
	}

	public void setR15_NO_INS_FUN_LFI(String r15_NO_INS_FUN_LFI) {
		R15_NO_INS_FUN_LFI = r15_NO_INS_FUN_LFI;
	}

	public String getR15_NO_CON_COL_FIN() {
		return R15_NO_CON_COL_FIN;
	}

	public void setR15_NO_CON_COL_FIN(String r15_NO_CON_COL_FIN) {
		R15_NO_CON_COL_FIN = r15_NO_CON_COL_FIN;
	}

	public String getR15_TOT_NO_NEW_FIN() {
		return R15_TOT_NO_NEW_FIN;
	}

	public void setR15_TOT_NO_NEW_FIN(String r15_TOT_NO_NEW_FIN) {
		R15_TOT_NO_NEW_FIN = r15_TOT_NO_NEW_FIN;
	}

	public String getR15_TOT_NO_NEW_NOSGN() {
		return R15_TOT_NO_NEW_NOSGN;
	}

	public void setR15_TOT_NO_NEW_NOSGN(String r15_TOT_NO_NEW_NOSGN) {
		R15_TOT_NO_NEW_NOSGN = r15_TOT_NO_NEW_NOSGN;
	}

	public String getR15_NO_CON_START() {
		return R15_NO_CON_START;
	}

	public void setR15_NO_CON_START(String r15_NO_CON_START) {
		R15_NO_CON_START = r15_NO_CON_START;
	}

	public String getR15_NO_NEW_CON_ONBO() {
		return R15_NO_NEW_CON_ONBO;
	}

	public void setR15_NO_NEW_CON_ONBO(String r15_NO_NEW_CON_ONBO) {
		R15_NO_NEW_CON_ONBO = r15_NO_NEW_CON_ONBO;
	}

	public String getR15_NO_CON_DEBT_COUN() {
		return R15_NO_CON_DEBT_COUN;
	}

	public void setR15_NO_CON_DEBT_COUN(String r15_NO_CON_DEBT_COUN) {
		R15_NO_CON_DEBT_COUN = r15_NO_CON_DEBT_COUN;
	}

	public String getR15_NO_CON_DEL_NPA() {
		return R15_NO_CON_DEL_NPA;
	}

	public void setR15_NO_CON_DEL_NPA(String r15_NO_CON_DEL_NPA) {
		R15_NO_CON_DEL_NPA = r15_NO_CON_DEL_NPA;
	}

	public String getR15_NO_CON_GOV_50() {
		return R15_NO_CON_GOV_50;
	}

	public void setR15_NO_CON_GOV_50(String r15_NO_CON_GOV_50) {
		R15_NO_CON_GOV_50 = r15_NO_CON_GOV_50;
	}

	public String getR15_NO_SME_SOLE() {
		return R15_NO_SME_SOLE;
	}

	public void setR15_NO_SME_SOLE(String r15_NO_SME_SOLE) {
		R15_NO_SME_SOLE = r15_NO_SME_SOLE;
	}

	public String getR15_NO_CON_TAG_VUL() {
		return R15_NO_CON_TAG_VUL;
	}

	public void setR15_NO_CON_TAG_VUL(String r15_NO_CON_TAG_VUL) {
		R15_NO_CON_TAG_VUL = r15_NO_CON_TAG_VUL;
	}

	public String getR15_NO_NEW_CON_ONB_GNP() {
		return R15_NO_NEW_CON_ONB_GNP;
	}

	public void setR15_NO_NEW_CON_ONB_GNP(String r15_NO_NEW_CON_ONB_GNP) {
		R15_NO_NEW_CON_ONB_GNP = r15_NO_NEW_CON_ONB_GNP;
	}

	public String getR15_NO_CON_END() {
		return R15_NO_CON_END;
	}

	public void setR15_NO_CON_END(String r15_NO_CON_END) {
		R15_NO_CON_END = r15_NO_CON_END;
	}

	public String getR16_BANK() {
		return R16_BANK;
	}

	public void setR16_BANK(String r16_BANK) {
		R16_BANK = r16_BANK;
	}

	public String getR16_PRODUCT() {
		return R16_PRODUCT;
	}

	public void setR16_PRODUCT(String r16_PRODUCT) {
		R16_PRODUCT = r16_PRODUCT;
	}

	public String getR16_NO_WO_SD() {
		return R16_NO_WO_SD;
	}

	public void setR16_NO_WO_SD(String r16_NO_WO_SD) {
		R16_NO_WO_SD = r16_NO_WO_SD;
	}

	public String getR16_NO_CON_POD_SD() {
		return R16_NO_CON_POD_SD;
	}

	public void setR16_NO_CON_POD_SD(String r16_NO_CON_POD_SD) {
		R16_NO_CON_POD_SD = r16_NO_CON_POD_SD;
	}

	public String getR16_NO_CON_UNAU_SP_TP() {
		return R16_NO_CON_UNAU_SP_TP;
	}

	public void setR16_NO_CON_UNAU_SP_TP(String r16_NO_CON_UNAU_SP_TP) {
		R16_NO_CON_UNAU_SP_TP = r16_NO_CON_UNAU_SP_TP;
	}

	public String getR16_NO_CON_45_50() {
		return R16_NO_CON_45_50;
	}

	public void setR16_NO_CON_45_50(String r16_NO_CON_45_50) {
		R16_NO_CON_45_50 = r16_NO_CON_45_50;
	}

	public String getR16_NO_CON_50() {
		return R16_NO_CON_50;
	}

	public void setR16_NO_CON_50(String r16_NO_CON_50) {
		R16_NO_CON_50 = r16_NO_CON_50;
	}

	public String getR16_NO_OF_LES_50() {
		return R16_NO_OF_LES_50;
	}

	public void setR16_NO_OF_LES_50(String r16_NO_OF_LES_50) {
		R16_NO_OF_LES_50 = r16_NO_OF_LES_50;
	}

	public String getR16_NO_OF_BNK_18() {
		return R16_NO_OF_BNK_18;
	}

	public void setR16_NO_OF_BNK_18(String r16_NO_OF_BNK_18) {
		R16_NO_OF_BNK_18 = r16_NO_OF_BNK_18;
	}

	public String getR16_NO_OF_BNK_18_25() {
		return R16_NO_OF_BNK_18_25;
	}

	public void setR16_NO_OF_BNK_18_25(String r16_NO_OF_BNK_18_25) {
		R16_NO_OF_BNK_18_25 = r16_NO_OF_BNK_18_25;
	}

	public String getR16_NO_OF_BNK_26_35() {
		return R16_NO_OF_BNK_26_35;
	}

	public void setR16_NO_OF_BNK_26_35(String r16_NO_OF_BNK_26_35) {
		R16_NO_OF_BNK_26_35 = r16_NO_OF_BNK_26_35;
	}

	public String getR16_NO_OF_BNK_36_50() {
		return R16_NO_OF_BNK_36_50;
	}

	public void setR16_NO_OF_BNK_36_50(String r16_NO_OF_BNK_36_50) {
		R16_NO_OF_BNK_36_50 = r16_NO_OF_BNK_36_50;
	}

	public String getR16_NO_CON_BNK_50() {
		return R16_NO_CON_BNK_50;
	}

	public void setR16_NO_CON_BNK_50(String r16_NO_CON_BNK_50) {
		R16_NO_CON_BNK_50 = r16_NO_CON_BNK_50;
	}

	public String getR16_NO_CON_SAL_SPD() {
		return R16_NO_CON_SAL_SPD;
	}

	public void setR16_NO_CON_SAL_SPD(String r16_NO_CON_SAL_SPD) {
		R16_NO_CON_SAL_SPD = r16_NO_CON_SAL_SPD;
	}

	public String getR16_NO_CON_BUS_SPD() {
		return R16_NO_CON_BUS_SPD;
	}

	public void setR16_NO_CON_BUS_SPD(String r16_NO_CON_BUS_SPD) {
		R16_NO_CON_BUS_SPD = r16_NO_CON_BUS_SPD;
	}

	public String getR16_NO_CON_PRO_SPD() {
		return R16_NO_CON_PRO_SPD;
	}

	public void setR16_NO_CON_PRO_SPD(String r16_NO_CON_PRO_SPD) {
		R16_NO_CON_PRO_SPD = r16_NO_CON_PRO_SPD;
	}

	public String getR16_NO_CON_INC_5K() {
		return R16_NO_CON_INC_5K;
	}

	public void setR16_NO_CON_INC_5K(String r16_NO_CON_INC_5K) {
		R16_NO_CON_INC_5K = r16_NO_CON_INC_5K;
	}

	public String getR16_NO_CON_INC_5K_10K() {
		return R16_NO_CON_INC_5K_10K;
	}

	public void setR16_NO_CON_INC_5K_10K(String r16_NO_CON_INC_5K_10K) {
		R16_NO_CON_INC_5K_10K = r16_NO_CON_INC_5K_10K;
	}

	public String getR16_NO_CON_INC_10K_20K() {
		return R16_NO_CON_INC_10K_20K;
	}

	public void setR16_NO_CON_INC_10K_20K(String r16_NO_CON_INC_10K_20K) {
		R16_NO_CON_INC_10K_20K = r16_NO_CON_INC_10K_20K;
	}

	public String getR16_NO_CON_INC_20K_35K() {
		return R16_NO_CON_INC_20K_35K;
	}

	public void setR16_NO_CON_INC_20K_35K(String r16_NO_CON_INC_20K_35K) {
		R16_NO_CON_INC_20K_35K = r16_NO_CON_INC_20K_35K;
	}

	public String getR16_NO_CON_INC_35K() {
		return R16_NO_CON_INC_35K;
	}

	public void setR16_NO_CON_INC_35K(String r16_NO_CON_INC_35K) {
		R16_NO_CON_INC_35K = r16_NO_CON_INC_35K;
	}

	public String getR16_NO_CON_BEL_SCL() {
		return R16_NO_CON_BEL_SCL;
	}

	public void setR16_NO_CON_BEL_SCL(String r16_NO_CON_BEL_SCL) {
		R16_NO_CON_BEL_SCL = r16_NO_CON_BEL_SCL;
	}

	public String getR16_NO_CON_BAC() {
		return R16_NO_CON_BAC;
	}

	public void setR16_NO_CON_BAC(String r16_NO_CON_BAC) {
		R16_NO_CON_BAC = r16_NO_CON_BAC;
	}

	public String getR16_NO_CON_ABV_MAS() {
		return R16_NO_CON_ABV_MAS;
	}

	public void setR16_NO_CON_ABV_MAS(String r16_NO_CON_ABV_MAS) {
		R16_NO_CON_ABV_MAS = r16_NO_CON_ABV_MAS;
	}

	public String getR16_NO_CON_ABU_KYC() {
		return R16_NO_CON_ABU_KYC;
	}

	public void setR16_NO_CON_ABU_KYC(String r16_NO_CON_ABU_KYC) {
		R16_NO_CON_ABU_KYC = r16_NO_CON_ABU_KYC;
	}

	public String getR16_NO_CON_DUB_KYC() {
		return R16_NO_CON_DUB_KYC;
	}

	public void setR16_NO_CON_DUB_KYC(String r16_NO_CON_DUB_KYC) {
		R16_NO_CON_DUB_KYC = r16_NO_CON_DUB_KYC;
	}

	public String getR16_NO_CON_SHJ_KYC() {
		return R16_NO_CON_SHJ_KYC;
	}

	public void setR16_NO_CON_SHJ_KYC(String r16_NO_CON_SHJ_KYC) {
		R16_NO_CON_SHJ_KYC = r16_NO_CON_SHJ_KYC;
	}

	public String getR16_NO_CON_AJM_KYC() {
		return R16_NO_CON_AJM_KYC;
	}

	public void setR16_NO_CON_AJM_KYC(String r16_NO_CON_AJM_KYC) {
		R16_NO_CON_AJM_KYC = r16_NO_CON_AJM_KYC;
	}

	public String getR16_NO_CON_FUJ_KYC() {
		return R16_NO_CON_FUJ_KYC;
	}

	public void setR16_NO_CON_FUJ_KYC(String r16_NO_CON_FUJ_KYC) {
		R16_NO_CON_FUJ_KYC = r16_NO_CON_FUJ_KYC;
	}

	public String getR16_NO_CON_RAK_KYC() {
		return R16_NO_CON_RAK_KYC;
	}

	public void setR16_NO_CON_RAK_KYC(String r16_NO_CON_RAK_KYC) {
		R16_NO_CON_RAK_KYC = r16_NO_CON_RAK_KYC;
	}

	public String getR16_NO_CON_UAQ_KYC() {
		return R16_NO_CON_UAQ_KYC;
	}

	public void setR16_NO_CON_UAQ_KYC(String r16_NO_CON_UAQ_KYC) {
		R16_NO_CON_UAQ_KYC = r16_NO_CON_UAQ_KYC;
	}

	public String getR16_NO_CON_RET() {
		return R16_NO_CON_RET;
	}

	public void setR16_NO_CON_RET(String r16_NO_CON_RET) {
		R16_NO_CON_RET = r16_NO_CON_RET;
	}

	public String getR16_NO_CON_DBR_LIM() {
		return R16_NO_CON_DBR_LIM;
	}

	public void setR16_NO_CON_DBR_LIM(String r16_NO_CON_DBR_LIM) {
		R16_NO_CON_DBR_LIM = r16_NO_CON_DBR_LIM;
	}

	public String getR16_NO_UAE_CON_SPC_TP() {
		return R16_NO_UAE_CON_SPC_TP;
	}

	public void setR16_NO_UAE_CON_SPC_TP(String r16_NO_UAE_CON_SPC_TP) {
		R16_NO_UAE_CON_SPC_TP = r16_NO_UAE_CON_SPC_TP;
	}

	public String getR16_NO_UAE_CON_NLS() {
		return R16_NO_UAE_CON_NLS;
	}

	public void setR16_NO_UAE_CON_NLS(String r16_NO_UAE_CON_NLS) {
		R16_NO_UAE_CON_NLS = r16_NO_UAE_CON_NLS;
	}

	public String getR16_VAL_LOS_AED() {
		return R16_VAL_LOS_AED;
	}

	public void setR16_VAL_LOS_AED(String r16_VAL_LOS_AED) {
		R16_VAL_LOS_AED = r16_VAL_LOS_AED;
	}

	public String getR16_NO_CON_ONB_90() {
		return R16_NO_CON_ONB_90;
	}

	public void setR16_NO_CON_ONB_90(String r16_NO_CON_ONB_90) {
		R16_NO_CON_ONB_90 = r16_NO_CON_ONB_90;
	}

	public String getR16_NO_CON_BAL_PAY() {
		return R16_NO_CON_BAL_PAY;
	}

	public void setR16_NO_CON_BAL_PAY(String r16_NO_CON_BAL_PAY) {
		R16_NO_CON_BAL_PAY = r16_NO_CON_BAL_PAY;
	}

	public String getR16_NO_CON_BAL_SPC_TP() {
		return R16_NO_CON_BAL_SPC_TP;
	}

	public void setR16_NO_CON_BAL_SPC_TP(String r16_NO_CON_BAL_SPC_TP) {
		R16_NO_CON_BAL_SPC_TP = r16_NO_CON_BAL_SPC_TP;
	}

	public String getR16_NO_CON_DEBT() {
		return R16_NO_CON_DEBT;
	}

	public void setR16_NO_CON_DEBT(String r16_NO_CON_DEBT) {
		R16_NO_CON_DEBT = r16_NO_CON_DEBT;
	}

	public String getR16_NO_CON_ONB_REF() {
		return R16_NO_CON_ONB_REF;
	}

	public void setR16_NO_CON_ONB_REF(String r16_NO_CON_ONB_REF) {
		R16_NO_CON_ONB_REF = r16_NO_CON_ONB_REF;
	}

	public String getR16_NO_CON_ONB_AGE() {
		return R16_NO_CON_ONB_AGE;
	}

	public void setR16_NO_CON_ONB_AGE(String r16_NO_CON_ONB_AGE) {
		R16_NO_CON_ONB_AGE = r16_NO_CON_ONB_AGE;
	}

	public String getR16_NO_CON_AFF_UNAU() {
		return R16_NO_CON_AFF_UNAU;
	}

	public void setR16_NO_CON_AFF_UNAU(String r16_NO_CON_AFF_UNAU) {
		R16_NO_CON_AFF_UNAU = r16_NO_CON_AFF_UNAU;
	}

	public String getR16_NO_OF_ACCS_POD() {
		return R16_NO_OF_ACCS_POD;
	}

	public void setR16_NO_OF_ACCS_POD(String r16_NO_OF_ACCS_POD) {
		R16_NO_OF_ACCS_POD = r16_NO_OF_ACCS_POD;
	}

	public String getR16_NO_DEL_CON() {
		return R16_NO_DEL_CON;
	}

	public void setR16_NO_DEL_CON(String r16_NO_DEL_CON) {
		R16_NO_DEL_CON = r16_NO_DEL_CON;
	}

	public String getR16_NO_INS_FUN_LFI() {
		return R16_NO_INS_FUN_LFI;
	}

	public void setR16_NO_INS_FUN_LFI(String r16_NO_INS_FUN_LFI) {
		R16_NO_INS_FUN_LFI = r16_NO_INS_FUN_LFI;
	}

	public String getR16_NO_CON_COL_FIN() {
		return R16_NO_CON_COL_FIN;
	}

	public void setR16_NO_CON_COL_FIN(String r16_NO_CON_COL_FIN) {
		R16_NO_CON_COL_FIN = r16_NO_CON_COL_FIN;
	}

	public String getR16_TOT_NO_NEW_FIN() {
		return R16_TOT_NO_NEW_FIN;
	}

	public void setR16_TOT_NO_NEW_FIN(String r16_TOT_NO_NEW_FIN) {
		R16_TOT_NO_NEW_FIN = r16_TOT_NO_NEW_FIN;
	}

	public String getR16_TOT_NO_NEW_NOSGN() {
		return R16_TOT_NO_NEW_NOSGN;
	}

	public void setR16_TOT_NO_NEW_NOSGN(String r16_TOT_NO_NEW_NOSGN) {
		R16_TOT_NO_NEW_NOSGN = r16_TOT_NO_NEW_NOSGN;
	}

	public String getR16_NO_CON_START() {
		return R16_NO_CON_START;
	}

	public void setR16_NO_CON_START(String r16_NO_CON_START) {
		R16_NO_CON_START = r16_NO_CON_START;
	}

	public String getR16_NO_NEW_CON_ONBO() {
		return R16_NO_NEW_CON_ONBO;
	}

	public void setR16_NO_NEW_CON_ONBO(String r16_NO_NEW_CON_ONBO) {
		R16_NO_NEW_CON_ONBO = r16_NO_NEW_CON_ONBO;
	}

	public String getR16_NO_CON_DEBT_COUN() {
		return R16_NO_CON_DEBT_COUN;
	}

	public void setR16_NO_CON_DEBT_COUN(String r16_NO_CON_DEBT_COUN) {
		R16_NO_CON_DEBT_COUN = r16_NO_CON_DEBT_COUN;
	}

	public String getR16_NO_CON_DEL_NPA() {
		return R16_NO_CON_DEL_NPA;
	}

	public void setR16_NO_CON_DEL_NPA(String r16_NO_CON_DEL_NPA) {
		R16_NO_CON_DEL_NPA = r16_NO_CON_DEL_NPA;
	}

	public String getR16_NO_CON_GOV_50() {
		return R16_NO_CON_GOV_50;
	}

	public void setR16_NO_CON_GOV_50(String r16_NO_CON_GOV_50) {
		R16_NO_CON_GOV_50 = r16_NO_CON_GOV_50;
	}

	public String getR16_NO_SME_SOLE() {
		return R16_NO_SME_SOLE;
	}

	public void setR16_NO_SME_SOLE(String r16_NO_SME_SOLE) {
		R16_NO_SME_SOLE = r16_NO_SME_SOLE;
	}

	public String getR16_NO_CON_TAG_VUL() {
		return R16_NO_CON_TAG_VUL;
	}

	public void setR16_NO_CON_TAG_VUL(String r16_NO_CON_TAG_VUL) {
		R16_NO_CON_TAG_VUL = r16_NO_CON_TAG_VUL;
	}

	public String getR16_NO_NEW_CON_ONB_GNP() {
		return R16_NO_NEW_CON_ONB_GNP;
	}

	public void setR16_NO_NEW_CON_ONB_GNP(String r16_NO_NEW_CON_ONB_GNP) {
		R16_NO_NEW_CON_ONB_GNP = r16_NO_NEW_CON_ONB_GNP;
	}

	public String getR16_NO_CON_END() {
		return R16_NO_CON_END;
	}

	public void setR16_NO_CON_END(String r16_NO_CON_END) {
		R16_NO_CON_END = r16_NO_CON_END;
	}

	public String getR17_BANK() {
		return R17_BANK;
	}

	public void setR17_BANK(String r17_BANK) {
		R17_BANK = r17_BANK;
	}

	public String getR17_PRODUCT() {
		return R17_PRODUCT;
	}

	public void setR17_PRODUCT(String r17_PRODUCT) {
		R17_PRODUCT = r17_PRODUCT;
	}

	public String getR17_NO_WO_SD() {
		return R17_NO_WO_SD;
	}

	public void setR17_NO_WO_SD(String r17_NO_WO_SD) {
		R17_NO_WO_SD = r17_NO_WO_SD;
	}

	public String getR17_NO_CON_POD_SD() {
		return R17_NO_CON_POD_SD;
	}

	public void setR17_NO_CON_POD_SD(String r17_NO_CON_POD_SD) {
		R17_NO_CON_POD_SD = r17_NO_CON_POD_SD;
	}

	public String getR17_NO_CON_UNAU_SP_TP() {
		return R17_NO_CON_UNAU_SP_TP;
	}

	public void setR17_NO_CON_UNAU_SP_TP(String r17_NO_CON_UNAU_SP_TP) {
		R17_NO_CON_UNAU_SP_TP = r17_NO_CON_UNAU_SP_TP;
	}

	public String getR17_NO_CON_45_50() {
		return R17_NO_CON_45_50;
	}

	public void setR17_NO_CON_45_50(String r17_NO_CON_45_50) {
		R17_NO_CON_45_50 = r17_NO_CON_45_50;
	}

	public String getR17_NO_CON_50() {
		return R17_NO_CON_50;
	}

	public void setR17_NO_CON_50(String r17_NO_CON_50) {
		R17_NO_CON_50 = r17_NO_CON_50;
	}

	public String getR17_NO_OF_LES_50() {
		return R17_NO_OF_LES_50;
	}

	public void setR17_NO_OF_LES_50(String r17_NO_OF_LES_50) {
		R17_NO_OF_LES_50 = r17_NO_OF_LES_50;
	}

	public String getR17_NO_OF_BNK_18() {
		return R17_NO_OF_BNK_18;
	}

	public void setR17_NO_OF_BNK_18(String r17_NO_OF_BNK_18) {
		R17_NO_OF_BNK_18 = r17_NO_OF_BNK_18;
	}

	public String getR17_NO_OF_BNK_18_25() {
		return R17_NO_OF_BNK_18_25;
	}

	public void setR17_NO_OF_BNK_18_25(String r17_NO_OF_BNK_18_25) {
		R17_NO_OF_BNK_18_25 = r17_NO_OF_BNK_18_25;
	}

	public String getR17_NO_OF_BNK_26_35() {
		return R17_NO_OF_BNK_26_35;
	}

	public void setR17_NO_OF_BNK_26_35(String r17_NO_OF_BNK_26_35) {
		R17_NO_OF_BNK_26_35 = r17_NO_OF_BNK_26_35;
	}

	public String getR17_NO_OF_BNK_36_50() {
		return R17_NO_OF_BNK_36_50;
	}

	public void setR17_NO_OF_BNK_36_50(String r17_NO_OF_BNK_36_50) {
		R17_NO_OF_BNK_36_50 = r17_NO_OF_BNK_36_50;
	}

	public String getR17_NO_CON_BNK_50() {
		return R17_NO_CON_BNK_50;
	}

	public void setR17_NO_CON_BNK_50(String r17_NO_CON_BNK_50) {
		R17_NO_CON_BNK_50 = r17_NO_CON_BNK_50;
	}

	public String getR17_NO_CON_SAL_SPD() {
		return R17_NO_CON_SAL_SPD;
	}

	public void setR17_NO_CON_SAL_SPD(String r17_NO_CON_SAL_SPD) {
		R17_NO_CON_SAL_SPD = r17_NO_CON_SAL_SPD;
	}

	public String getR17_NO_CON_BUS_SPD() {
		return R17_NO_CON_BUS_SPD;
	}

	public void setR17_NO_CON_BUS_SPD(String r17_NO_CON_BUS_SPD) {
		R17_NO_CON_BUS_SPD = r17_NO_CON_BUS_SPD;
	}

	public String getR17_NO_CON_PRO_SPD() {
		return R17_NO_CON_PRO_SPD;
	}

	public void setR17_NO_CON_PRO_SPD(String r17_NO_CON_PRO_SPD) {
		R17_NO_CON_PRO_SPD = r17_NO_CON_PRO_SPD;
	}

	public String getR17_NO_CON_INC_5K() {
		return R17_NO_CON_INC_5K;
	}

	public void setR17_NO_CON_INC_5K(String r17_NO_CON_INC_5K) {
		R17_NO_CON_INC_5K = r17_NO_CON_INC_5K;
	}

	public String getR17_NO_CON_INC_5K_10K() {
		return R17_NO_CON_INC_5K_10K;
	}

	public void setR17_NO_CON_INC_5K_10K(String r17_NO_CON_INC_5K_10K) {
		R17_NO_CON_INC_5K_10K = r17_NO_CON_INC_5K_10K;
	}

	public String getR17_NO_CON_INC_10K_20K() {
		return R17_NO_CON_INC_10K_20K;
	}

	public void setR17_NO_CON_INC_10K_20K(String r17_NO_CON_INC_10K_20K) {
		R17_NO_CON_INC_10K_20K = r17_NO_CON_INC_10K_20K;
	}

	public String getR17_NO_CON_INC_20K_35K() {
		return R17_NO_CON_INC_20K_35K;
	}

	public void setR17_NO_CON_INC_20K_35K(String r17_NO_CON_INC_20K_35K) {
		R17_NO_CON_INC_20K_35K = r17_NO_CON_INC_20K_35K;
	}

	public String getR17_NO_CON_INC_35K() {
		return R17_NO_CON_INC_35K;
	}

	public void setR17_NO_CON_INC_35K(String r17_NO_CON_INC_35K) {
		R17_NO_CON_INC_35K = r17_NO_CON_INC_35K;
	}

	public String getR17_NO_CON_BEL_SCL() {
		return R17_NO_CON_BEL_SCL;
	}

	public void setR17_NO_CON_BEL_SCL(String r17_NO_CON_BEL_SCL) {
		R17_NO_CON_BEL_SCL = r17_NO_CON_BEL_SCL;
	}

	public String getR17_NO_CON_BAC() {
		return R17_NO_CON_BAC;
	}

	public void setR17_NO_CON_BAC(String r17_NO_CON_BAC) {
		R17_NO_CON_BAC = r17_NO_CON_BAC;
	}

	public String getR17_NO_CON_ABV_MAS() {
		return R17_NO_CON_ABV_MAS;
	}

	public void setR17_NO_CON_ABV_MAS(String r17_NO_CON_ABV_MAS) {
		R17_NO_CON_ABV_MAS = r17_NO_CON_ABV_MAS;
	}

	public String getR17_NO_CON_ABU_KYC() {
		return R17_NO_CON_ABU_KYC;
	}

	public void setR17_NO_CON_ABU_KYC(String r17_NO_CON_ABU_KYC) {
		R17_NO_CON_ABU_KYC = r17_NO_CON_ABU_KYC;
	}

	public String getR17_NO_CON_DUB_KYC() {
		return R17_NO_CON_DUB_KYC;
	}

	public void setR17_NO_CON_DUB_KYC(String r17_NO_CON_DUB_KYC) {
		R17_NO_CON_DUB_KYC = r17_NO_CON_DUB_KYC;
	}

	public String getR17_NO_CON_SHJ_KYC() {
		return R17_NO_CON_SHJ_KYC;
	}

	public void setR17_NO_CON_SHJ_KYC(String r17_NO_CON_SHJ_KYC) {
		R17_NO_CON_SHJ_KYC = r17_NO_CON_SHJ_KYC;
	}

	public String getR17_NO_CON_AJM_KYC() {
		return R17_NO_CON_AJM_KYC;
	}

	public void setR17_NO_CON_AJM_KYC(String r17_NO_CON_AJM_KYC) {
		R17_NO_CON_AJM_KYC = r17_NO_CON_AJM_KYC;
	}

	public String getR17_NO_CON_FUJ_KYC() {
		return R17_NO_CON_FUJ_KYC;
	}

	public void setR17_NO_CON_FUJ_KYC(String r17_NO_CON_FUJ_KYC) {
		R17_NO_CON_FUJ_KYC = r17_NO_CON_FUJ_KYC;
	}

	public String getR17_NO_CON_RAK_KYC() {
		return R17_NO_CON_RAK_KYC;
	}

	public void setR17_NO_CON_RAK_KYC(String r17_NO_CON_RAK_KYC) {
		R17_NO_CON_RAK_KYC = r17_NO_CON_RAK_KYC;
	}

	public String getR17_NO_CON_UAQ_KYC() {
		return R17_NO_CON_UAQ_KYC;
	}

	public void setR17_NO_CON_UAQ_KYC(String r17_NO_CON_UAQ_KYC) {
		R17_NO_CON_UAQ_KYC = r17_NO_CON_UAQ_KYC;
	}

	public String getR17_NO_CON_RET() {
		return R17_NO_CON_RET;
	}

	public void setR17_NO_CON_RET(String r17_NO_CON_RET) {
		R17_NO_CON_RET = r17_NO_CON_RET;
	}

	public String getR17_NO_CON_DBR_LIM() {
		return R17_NO_CON_DBR_LIM;
	}

	public void setR17_NO_CON_DBR_LIM(String r17_NO_CON_DBR_LIM) {
		R17_NO_CON_DBR_LIM = r17_NO_CON_DBR_LIM;
	}

	public String getR17_NO_UAE_CON_SPC_TP() {
		return R17_NO_UAE_CON_SPC_TP;
	}

	public void setR17_NO_UAE_CON_SPC_TP(String r17_NO_UAE_CON_SPC_TP) {
		R17_NO_UAE_CON_SPC_TP = r17_NO_UAE_CON_SPC_TP;
	}

	public String getR17_NO_UAE_CON_NLS() {
		return R17_NO_UAE_CON_NLS;
	}

	public void setR17_NO_UAE_CON_NLS(String r17_NO_UAE_CON_NLS) {
		R17_NO_UAE_CON_NLS = r17_NO_UAE_CON_NLS;
	}

	public String getR17_VAL_LOS_AED() {
		return R17_VAL_LOS_AED;
	}

	public void setR17_VAL_LOS_AED(String r17_VAL_LOS_AED) {
		R17_VAL_LOS_AED = r17_VAL_LOS_AED;
	}

	public String getR17_NO_CON_ONB_90() {
		return R17_NO_CON_ONB_90;
	}

	public void setR17_NO_CON_ONB_90(String r17_NO_CON_ONB_90) {
		R17_NO_CON_ONB_90 = r17_NO_CON_ONB_90;
	}

	public String getR17_NO_CON_BAL_PAY() {
		return R17_NO_CON_BAL_PAY;
	}

	public void setR17_NO_CON_BAL_PAY(String r17_NO_CON_BAL_PAY) {
		R17_NO_CON_BAL_PAY = r17_NO_CON_BAL_PAY;
	}

	public String getR17_NO_CON_BAL_SPC_TP() {
		return R17_NO_CON_BAL_SPC_TP;
	}

	public void setR17_NO_CON_BAL_SPC_TP(String r17_NO_CON_BAL_SPC_TP) {
		R17_NO_CON_BAL_SPC_TP = r17_NO_CON_BAL_SPC_TP;
	}

	public String getR17_NO_CON_DEBT() {
		return R17_NO_CON_DEBT;
	}

	public void setR17_NO_CON_DEBT(String r17_NO_CON_DEBT) {
		R17_NO_CON_DEBT = r17_NO_CON_DEBT;
	}

	public String getR17_NO_CON_ONB_REF() {
		return R17_NO_CON_ONB_REF;
	}

	public void setR17_NO_CON_ONB_REF(String r17_NO_CON_ONB_REF) {
		R17_NO_CON_ONB_REF = r17_NO_CON_ONB_REF;
	}

	public String getR17_NO_CON_ONB_AGE() {
		return R17_NO_CON_ONB_AGE;
	}

	public void setR17_NO_CON_ONB_AGE(String r17_NO_CON_ONB_AGE) {
		R17_NO_CON_ONB_AGE = r17_NO_CON_ONB_AGE;
	}

	public String getR17_NO_CON_AFF_UNAU() {
		return R17_NO_CON_AFF_UNAU;
	}

	public void setR17_NO_CON_AFF_UNAU(String r17_NO_CON_AFF_UNAU) {
		R17_NO_CON_AFF_UNAU = r17_NO_CON_AFF_UNAU;
	}

	public String getR17_NO_OF_ACCS_POD() {
		return R17_NO_OF_ACCS_POD;
	}

	public void setR17_NO_OF_ACCS_POD(String r17_NO_OF_ACCS_POD) {
		R17_NO_OF_ACCS_POD = r17_NO_OF_ACCS_POD;
	}

	public String getR17_NO_DEL_CON() {
		return R17_NO_DEL_CON;
	}

	public void setR17_NO_DEL_CON(String r17_NO_DEL_CON) {
		R17_NO_DEL_CON = r17_NO_DEL_CON;
	}

	public String getR17_NO_INS_FUN_LFI() {
		return R17_NO_INS_FUN_LFI;
	}

	public void setR17_NO_INS_FUN_LFI(String r17_NO_INS_FUN_LFI) {
		R17_NO_INS_FUN_LFI = r17_NO_INS_FUN_LFI;
	}

	public String getR17_NO_CON_COL_FIN() {
		return R17_NO_CON_COL_FIN;
	}

	public void setR17_NO_CON_COL_FIN(String r17_NO_CON_COL_FIN) {
		R17_NO_CON_COL_FIN = r17_NO_CON_COL_FIN;
	}

	public String getR17_TOT_NO_NEW_FIN() {
		return R17_TOT_NO_NEW_FIN;
	}

	public void setR17_TOT_NO_NEW_FIN(String r17_TOT_NO_NEW_FIN) {
		R17_TOT_NO_NEW_FIN = r17_TOT_NO_NEW_FIN;
	}

	public String getR17_TOT_NO_NEW_NOSGN() {
		return R17_TOT_NO_NEW_NOSGN;
	}

	public void setR17_TOT_NO_NEW_NOSGN(String r17_TOT_NO_NEW_NOSGN) {
		R17_TOT_NO_NEW_NOSGN = r17_TOT_NO_NEW_NOSGN;
	}

	public String getR17_NO_CON_START() {
		return R17_NO_CON_START;
	}

	public void setR17_NO_CON_START(String r17_NO_CON_START) {
		R17_NO_CON_START = r17_NO_CON_START;
	}

	public String getR17_NO_NEW_CON_ONBO() {
		return R17_NO_NEW_CON_ONBO;
	}

	public void setR17_NO_NEW_CON_ONBO(String r17_NO_NEW_CON_ONBO) {
		R17_NO_NEW_CON_ONBO = r17_NO_NEW_CON_ONBO;
	}

	public String getR17_NO_CON_DEBT_COUN() {
		return R17_NO_CON_DEBT_COUN;
	}

	public void setR17_NO_CON_DEBT_COUN(String r17_NO_CON_DEBT_COUN) {
		R17_NO_CON_DEBT_COUN = r17_NO_CON_DEBT_COUN;
	}

	public String getR17_NO_CON_DEL_NPA() {
		return R17_NO_CON_DEL_NPA;
	}

	public void setR17_NO_CON_DEL_NPA(String r17_NO_CON_DEL_NPA) {
		R17_NO_CON_DEL_NPA = r17_NO_CON_DEL_NPA;
	}

	public String getR17_NO_CON_GOV_50() {
		return R17_NO_CON_GOV_50;
	}

	public void setR17_NO_CON_GOV_50(String r17_NO_CON_GOV_50) {
		R17_NO_CON_GOV_50 = r17_NO_CON_GOV_50;
	}

	public String getR17_NO_SME_SOLE() {
		return R17_NO_SME_SOLE;
	}

	public void setR17_NO_SME_SOLE(String r17_NO_SME_SOLE) {
		R17_NO_SME_SOLE = r17_NO_SME_SOLE;
	}

	public String getR17_NO_CON_TAG_VUL() {
		return R17_NO_CON_TAG_VUL;
	}

	public void setR17_NO_CON_TAG_VUL(String r17_NO_CON_TAG_VUL) {
		R17_NO_CON_TAG_VUL = r17_NO_CON_TAG_VUL;
	}

	public String getR17_NO_NEW_CON_ONB_GNP() {
		return R17_NO_NEW_CON_ONB_GNP;
	}

	public void setR17_NO_NEW_CON_ONB_GNP(String r17_NO_NEW_CON_ONB_GNP) {
		R17_NO_NEW_CON_ONB_GNP = r17_NO_NEW_CON_ONB_GNP;
	}

	public String getR17_NO_CON_END() {
		return R17_NO_CON_END;
	}

	public void setR17_NO_CON_END(String r17_NO_CON_END) {
		R17_NO_CON_END = r17_NO_CON_END;
	}

	public String getR18_BANK() {
		return R18_BANK;
	}

	public void setR18_BANK(String r18_BANK) {
		R18_BANK = r18_BANK;
	}

	public String getR18_PRODUCT() {
		return R18_PRODUCT;
	}

	public void setR18_PRODUCT(String r18_PRODUCT) {
		R18_PRODUCT = r18_PRODUCT;
	}

	public String getR18_NO_WO_SD() {
		return R18_NO_WO_SD;
	}

	public void setR18_NO_WO_SD(String r18_NO_WO_SD) {
		R18_NO_WO_SD = r18_NO_WO_SD;
	}

	public String getR18_NO_CON_POD_SD() {
		return R18_NO_CON_POD_SD;
	}

	public void setR18_NO_CON_POD_SD(String r18_NO_CON_POD_SD) {
		R18_NO_CON_POD_SD = r18_NO_CON_POD_SD;
	}

	public String getR18_NO_CON_UNAU_SP_TP() {
		return R18_NO_CON_UNAU_SP_TP;
	}

	public void setR18_NO_CON_UNAU_SP_TP(String r18_NO_CON_UNAU_SP_TP) {
		R18_NO_CON_UNAU_SP_TP = r18_NO_CON_UNAU_SP_TP;
	}

	public String getR18_NO_CON_45_50() {
		return R18_NO_CON_45_50;
	}

	public void setR18_NO_CON_45_50(String r18_NO_CON_45_50) {
		R18_NO_CON_45_50 = r18_NO_CON_45_50;
	}

	public String getR18_NO_CON_50() {
		return R18_NO_CON_50;
	}

	public void setR18_NO_CON_50(String r18_NO_CON_50) {
		R18_NO_CON_50 = r18_NO_CON_50;
	}

	public String getR18_NO_OF_LES_50() {
		return R18_NO_OF_LES_50;
	}

	public void setR18_NO_OF_LES_50(String r18_NO_OF_LES_50) {
		R18_NO_OF_LES_50 = r18_NO_OF_LES_50;
	}

	public String getR18_NO_OF_BNK_18() {
		return R18_NO_OF_BNK_18;
	}

	public void setR18_NO_OF_BNK_18(String r18_NO_OF_BNK_18) {
		R18_NO_OF_BNK_18 = r18_NO_OF_BNK_18;
	}

	public String getR18_NO_OF_BNK_18_25() {
		return R18_NO_OF_BNK_18_25;
	}

	public void setR18_NO_OF_BNK_18_25(String r18_NO_OF_BNK_18_25) {
		R18_NO_OF_BNK_18_25 = r18_NO_OF_BNK_18_25;
	}

	public String getR18_NO_OF_BNK_26_35() {
		return R18_NO_OF_BNK_26_35;
	}

	public void setR18_NO_OF_BNK_26_35(String r18_NO_OF_BNK_26_35) {
		R18_NO_OF_BNK_26_35 = r18_NO_OF_BNK_26_35;
	}

	public String getR18_NO_OF_BNK_36_50() {
		return R18_NO_OF_BNK_36_50;
	}

	public void setR18_NO_OF_BNK_36_50(String r18_NO_OF_BNK_36_50) {
		R18_NO_OF_BNK_36_50 = r18_NO_OF_BNK_36_50;
	}

	public String getR18_NO_CON_BNK_50() {
		return R18_NO_CON_BNK_50;
	}

	public void setR18_NO_CON_BNK_50(String r18_NO_CON_BNK_50) {
		R18_NO_CON_BNK_50 = r18_NO_CON_BNK_50;
	}

	public String getR18_NO_CON_SAL_SPD() {
		return R18_NO_CON_SAL_SPD;
	}

	public void setR18_NO_CON_SAL_SPD(String r18_NO_CON_SAL_SPD) {
		R18_NO_CON_SAL_SPD = r18_NO_CON_SAL_SPD;
	}

	public String getR18_NO_CON_BUS_SPD() {
		return R18_NO_CON_BUS_SPD;
	}

	public void setR18_NO_CON_BUS_SPD(String r18_NO_CON_BUS_SPD) {
		R18_NO_CON_BUS_SPD = r18_NO_CON_BUS_SPD;
	}

	public String getR18_NO_CON_PRO_SPD() {
		return R18_NO_CON_PRO_SPD;
	}

	public void setR18_NO_CON_PRO_SPD(String r18_NO_CON_PRO_SPD) {
		R18_NO_CON_PRO_SPD = r18_NO_CON_PRO_SPD;
	}

	public String getR18_NO_CON_INC_5K() {
		return R18_NO_CON_INC_5K;
	}

	public void setR18_NO_CON_INC_5K(String r18_NO_CON_INC_5K) {
		R18_NO_CON_INC_5K = r18_NO_CON_INC_5K;
	}

	public String getR18_NO_CON_INC_5K_10K() {
		return R18_NO_CON_INC_5K_10K;
	}

	public void setR18_NO_CON_INC_5K_10K(String r18_NO_CON_INC_5K_10K) {
		R18_NO_CON_INC_5K_10K = r18_NO_CON_INC_5K_10K;
	}

	public String getR18_NO_CON_INC_10K_20K() {
		return R18_NO_CON_INC_10K_20K;
	}

	public void setR18_NO_CON_INC_10K_20K(String r18_NO_CON_INC_10K_20K) {
		R18_NO_CON_INC_10K_20K = r18_NO_CON_INC_10K_20K;
	}

	public String getR18_NO_CON_INC_20K_35K() {
		return R18_NO_CON_INC_20K_35K;
	}

	public void setR18_NO_CON_INC_20K_35K(String r18_NO_CON_INC_20K_35K) {
		R18_NO_CON_INC_20K_35K = r18_NO_CON_INC_20K_35K;
	}

	public String getR18_NO_CON_INC_35K() {
		return R18_NO_CON_INC_35K;
	}

	public void setR18_NO_CON_INC_35K(String r18_NO_CON_INC_35K) {
		R18_NO_CON_INC_35K = r18_NO_CON_INC_35K;
	}

	public String getR18_NO_CON_BEL_SCL() {
		return R18_NO_CON_BEL_SCL;
	}

	public void setR18_NO_CON_BEL_SCL(String r18_NO_CON_BEL_SCL) {
		R18_NO_CON_BEL_SCL = r18_NO_CON_BEL_SCL;
	}

	public String getR18_NO_CON_BAC() {
		return R18_NO_CON_BAC;
	}

	public void setR18_NO_CON_BAC(String r18_NO_CON_BAC) {
		R18_NO_CON_BAC = r18_NO_CON_BAC;
	}

	public String getR18_NO_CON_ABV_MAS() {
		return R18_NO_CON_ABV_MAS;
	}

	public void setR18_NO_CON_ABV_MAS(String r18_NO_CON_ABV_MAS) {
		R18_NO_CON_ABV_MAS = r18_NO_CON_ABV_MAS;
	}

	public String getR18_NO_CON_ABU_KYC() {
		return R18_NO_CON_ABU_KYC;
	}

	public void setR18_NO_CON_ABU_KYC(String r18_NO_CON_ABU_KYC) {
		R18_NO_CON_ABU_KYC = r18_NO_CON_ABU_KYC;
	}

	public String getR18_NO_CON_DUB_KYC() {
		return R18_NO_CON_DUB_KYC;
	}

	public void setR18_NO_CON_DUB_KYC(String r18_NO_CON_DUB_KYC) {
		R18_NO_CON_DUB_KYC = r18_NO_CON_DUB_KYC;
	}

	public String getR18_NO_CON_SHJ_KYC() {
		return R18_NO_CON_SHJ_KYC;
	}

	public void setR18_NO_CON_SHJ_KYC(String r18_NO_CON_SHJ_KYC) {
		R18_NO_CON_SHJ_KYC = r18_NO_CON_SHJ_KYC;
	}

	public String getR18_NO_CON_AJM_KYC() {
		return R18_NO_CON_AJM_KYC;
	}

	public void setR18_NO_CON_AJM_KYC(String r18_NO_CON_AJM_KYC) {
		R18_NO_CON_AJM_KYC = r18_NO_CON_AJM_KYC;
	}

	public String getR18_NO_CON_FUJ_KYC() {
		return R18_NO_CON_FUJ_KYC;
	}

	public void setR18_NO_CON_FUJ_KYC(String r18_NO_CON_FUJ_KYC) {
		R18_NO_CON_FUJ_KYC = r18_NO_CON_FUJ_KYC;
	}

	public String getR18_NO_CON_RAK_KYC() {
		return R18_NO_CON_RAK_KYC;
	}

	public void setR18_NO_CON_RAK_KYC(String r18_NO_CON_RAK_KYC) {
		R18_NO_CON_RAK_KYC = r18_NO_CON_RAK_KYC;
	}

	public String getR18_NO_CON_UAQ_KYC() {
		return R18_NO_CON_UAQ_KYC;
	}

	public void setR18_NO_CON_UAQ_KYC(String r18_NO_CON_UAQ_KYC) {
		R18_NO_CON_UAQ_KYC = r18_NO_CON_UAQ_KYC;
	}

	public String getR18_NO_CON_RET() {
		return R18_NO_CON_RET;
	}

	public void setR18_NO_CON_RET(String r18_NO_CON_RET) {
		R18_NO_CON_RET = r18_NO_CON_RET;
	}

	public String getR18_NO_CON_DBR_LIM() {
		return R18_NO_CON_DBR_LIM;
	}

	public void setR18_NO_CON_DBR_LIM(String r18_NO_CON_DBR_LIM) {
		R18_NO_CON_DBR_LIM = r18_NO_CON_DBR_LIM;
	}

	public String getR18_NO_UAE_CON_SPC_TP() {
		return R18_NO_UAE_CON_SPC_TP;
	}

	public void setR18_NO_UAE_CON_SPC_TP(String r18_NO_UAE_CON_SPC_TP) {
		R18_NO_UAE_CON_SPC_TP = r18_NO_UAE_CON_SPC_TP;
	}

	public String getR18_NO_UAE_CON_NLS() {
		return R18_NO_UAE_CON_NLS;
	}

	public void setR18_NO_UAE_CON_NLS(String r18_NO_UAE_CON_NLS) {
		R18_NO_UAE_CON_NLS = r18_NO_UAE_CON_NLS;
	}

	public String getR18_VAL_LOS_AED() {
		return R18_VAL_LOS_AED;
	}

	public void setR18_VAL_LOS_AED(String r18_VAL_LOS_AED) {
		R18_VAL_LOS_AED = r18_VAL_LOS_AED;
	}

	public String getR18_NO_CON_ONB_90() {
		return R18_NO_CON_ONB_90;
	}

	public void setR18_NO_CON_ONB_90(String r18_NO_CON_ONB_90) {
		R18_NO_CON_ONB_90 = r18_NO_CON_ONB_90;
	}

	public String getR18_NO_CON_BAL_PAY() {
		return R18_NO_CON_BAL_PAY;
	}

	public void setR18_NO_CON_BAL_PAY(String r18_NO_CON_BAL_PAY) {
		R18_NO_CON_BAL_PAY = r18_NO_CON_BAL_PAY;
	}

	public String getR18_NO_CON_BAL_SPC_TP() {
		return R18_NO_CON_BAL_SPC_TP;
	}

	public void setR18_NO_CON_BAL_SPC_TP(String r18_NO_CON_BAL_SPC_TP) {
		R18_NO_CON_BAL_SPC_TP = r18_NO_CON_BAL_SPC_TP;
	}

	public String getR18_NO_CON_DEBT() {
		return R18_NO_CON_DEBT;
	}

	public void setR18_NO_CON_DEBT(String r18_NO_CON_DEBT) {
		R18_NO_CON_DEBT = r18_NO_CON_DEBT;
	}

	public String getR18_NO_CON_ONB_REF() {
		return R18_NO_CON_ONB_REF;
	}

	public void setR18_NO_CON_ONB_REF(String r18_NO_CON_ONB_REF) {
		R18_NO_CON_ONB_REF = r18_NO_CON_ONB_REF;
	}

	public String getR18_NO_CON_ONB_AGE() {
		return R18_NO_CON_ONB_AGE;
	}

	public void setR18_NO_CON_ONB_AGE(String r18_NO_CON_ONB_AGE) {
		R18_NO_CON_ONB_AGE = r18_NO_CON_ONB_AGE;
	}

	public String getR18_NO_CON_AFF_UNAU() {
		return R18_NO_CON_AFF_UNAU;
	}

	public void setR18_NO_CON_AFF_UNAU(String r18_NO_CON_AFF_UNAU) {
		R18_NO_CON_AFF_UNAU = r18_NO_CON_AFF_UNAU;
	}

	public String getR18_NO_OF_ACCS_POD() {
		return R18_NO_OF_ACCS_POD;
	}

	public void setR18_NO_OF_ACCS_POD(String r18_NO_OF_ACCS_POD) {
		R18_NO_OF_ACCS_POD = r18_NO_OF_ACCS_POD;
	}

	public String getR18_NO_DEL_CON() {
		return R18_NO_DEL_CON;
	}

	public void setR18_NO_DEL_CON(String r18_NO_DEL_CON) {
		R18_NO_DEL_CON = r18_NO_DEL_CON;
	}

	public String getR18_NO_INS_FUN_LFI() {
		return R18_NO_INS_FUN_LFI;
	}

	public void setR18_NO_INS_FUN_LFI(String r18_NO_INS_FUN_LFI) {
		R18_NO_INS_FUN_LFI = r18_NO_INS_FUN_LFI;
	}

	public String getR18_NO_CON_COL_FIN() {
		return R18_NO_CON_COL_FIN;
	}

	public void setR18_NO_CON_COL_FIN(String r18_NO_CON_COL_FIN) {
		R18_NO_CON_COL_FIN = r18_NO_CON_COL_FIN;
	}

	public String getR18_TOT_NO_NEW_FIN() {
		return R18_TOT_NO_NEW_FIN;
	}

	public void setR18_TOT_NO_NEW_FIN(String r18_TOT_NO_NEW_FIN) {
		R18_TOT_NO_NEW_FIN = r18_TOT_NO_NEW_FIN;
	}

	public String getR18_TOT_NO_NEW_NOSGN() {
		return R18_TOT_NO_NEW_NOSGN;
	}

	public void setR18_TOT_NO_NEW_NOSGN(String r18_TOT_NO_NEW_NOSGN) {
		R18_TOT_NO_NEW_NOSGN = r18_TOT_NO_NEW_NOSGN;
	}

	public String getR18_NO_CON_START() {
		return R18_NO_CON_START;
	}

	public void setR18_NO_CON_START(String r18_NO_CON_START) {
		R18_NO_CON_START = r18_NO_CON_START;
	}

	public String getR18_NO_NEW_CON_ONBO() {
		return R18_NO_NEW_CON_ONBO;
	}

	public void setR18_NO_NEW_CON_ONBO(String r18_NO_NEW_CON_ONBO) {
		R18_NO_NEW_CON_ONBO = r18_NO_NEW_CON_ONBO;
	}

	public String getR18_NO_CON_DEBT_COUN() {
		return R18_NO_CON_DEBT_COUN;
	}

	public void setR18_NO_CON_DEBT_COUN(String r18_NO_CON_DEBT_COUN) {
		R18_NO_CON_DEBT_COUN = r18_NO_CON_DEBT_COUN;
	}

	public String getR18_NO_CON_DEL_NPA() {
		return R18_NO_CON_DEL_NPA;
	}

	public void setR18_NO_CON_DEL_NPA(String r18_NO_CON_DEL_NPA) {
		R18_NO_CON_DEL_NPA = r18_NO_CON_DEL_NPA;
	}

	public String getR18_NO_CON_GOV_50() {
		return R18_NO_CON_GOV_50;
	}

	public void setR18_NO_CON_GOV_50(String r18_NO_CON_GOV_50) {
		R18_NO_CON_GOV_50 = r18_NO_CON_GOV_50;
	}

	public String getR18_NO_SME_SOLE() {
		return R18_NO_SME_SOLE;
	}

	public void setR18_NO_SME_SOLE(String r18_NO_SME_SOLE) {
		R18_NO_SME_SOLE = r18_NO_SME_SOLE;
	}

	public String getR18_NO_CON_TAG_VUL() {
		return R18_NO_CON_TAG_VUL;
	}

	public void setR18_NO_CON_TAG_VUL(String r18_NO_CON_TAG_VUL) {
		R18_NO_CON_TAG_VUL = r18_NO_CON_TAG_VUL;
	}

	public String getR18_NO_NEW_CON_ONB_GNP() {
		return R18_NO_NEW_CON_ONB_GNP;
	}

	public void setR18_NO_NEW_CON_ONB_GNP(String r18_NO_NEW_CON_ONB_GNP) {
		R18_NO_NEW_CON_ONB_GNP = r18_NO_NEW_CON_ONB_GNP;
	}

	public String getR18_NO_CON_END() {
		return R18_NO_CON_END;
	}

	public void setR18_NO_CON_END(String r18_NO_CON_END) {
		R18_NO_CON_END = r18_NO_CON_END;
	}

	public String getR19_BANK() {
		return R19_BANK;
	}

	public void setR19_BANK(String r19_BANK) {
		R19_BANK = r19_BANK;
	}

	public String getR19_PRODUCT() {
		return R19_PRODUCT;
	}

	public void setR19_PRODUCT(String r19_PRODUCT) {
		R19_PRODUCT = r19_PRODUCT;
	}

	public String getR19_NO_WO_SD() {
		return R19_NO_WO_SD;
	}

	public void setR19_NO_WO_SD(String r19_NO_WO_SD) {
		R19_NO_WO_SD = r19_NO_WO_SD;
	}

	public String getR19_NO_CON_POD_SD() {
		return R19_NO_CON_POD_SD;
	}

	public void setR19_NO_CON_POD_SD(String r19_NO_CON_POD_SD) {
		R19_NO_CON_POD_SD = r19_NO_CON_POD_SD;
	}

	public String getR19_NO_CON_UNAU_SP_TP() {
		return R19_NO_CON_UNAU_SP_TP;
	}

	public void setR19_NO_CON_UNAU_SP_TP(String r19_NO_CON_UNAU_SP_TP) {
		R19_NO_CON_UNAU_SP_TP = r19_NO_CON_UNAU_SP_TP;
	}

	public String getR19_NO_CON_45_50() {
		return R19_NO_CON_45_50;
	}

	public void setR19_NO_CON_45_50(String r19_NO_CON_45_50) {
		R19_NO_CON_45_50 = r19_NO_CON_45_50;
	}

	public String getR19_NO_CON_50() {
		return R19_NO_CON_50;
	}

	public void setR19_NO_CON_50(String r19_NO_CON_50) {
		R19_NO_CON_50 = r19_NO_CON_50;
	}

	public String getR19_NO_OF_LES_50() {
		return R19_NO_OF_LES_50;
	}

	public void setR19_NO_OF_LES_50(String r19_NO_OF_LES_50) {
		R19_NO_OF_LES_50 = r19_NO_OF_LES_50;
	}

	public String getR19_NO_OF_BNK_18() {
		return R19_NO_OF_BNK_18;
	}

	public void setR19_NO_OF_BNK_18(String r19_NO_OF_BNK_18) {
		R19_NO_OF_BNK_18 = r19_NO_OF_BNK_18;
	}

	public String getR19_NO_OF_BNK_18_25() {
		return R19_NO_OF_BNK_18_25;
	}

	public void setR19_NO_OF_BNK_18_25(String r19_NO_OF_BNK_18_25) {
		R19_NO_OF_BNK_18_25 = r19_NO_OF_BNK_18_25;
	}

	public String getR19_NO_OF_BNK_26_35() {
		return R19_NO_OF_BNK_26_35;
	}

	public void setR19_NO_OF_BNK_26_35(String r19_NO_OF_BNK_26_35) {
		R19_NO_OF_BNK_26_35 = r19_NO_OF_BNK_26_35;
	}

	public String getR19_NO_OF_BNK_36_50() {
		return R19_NO_OF_BNK_36_50;
	}

	public void setR19_NO_OF_BNK_36_50(String r19_NO_OF_BNK_36_50) {
		R19_NO_OF_BNK_36_50 = r19_NO_OF_BNK_36_50;
	}

	public String getR19_NO_CON_BNK_50() {
		return R19_NO_CON_BNK_50;
	}

	public void setR19_NO_CON_BNK_50(String r19_NO_CON_BNK_50) {
		R19_NO_CON_BNK_50 = r19_NO_CON_BNK_50;
	}

	public String getR19_NO_CON_SAL_SPD() {
		return R19_NO_CON_SAL_SPD;
	}

	public void setR19_NO_CON_SAL_SPD(String r19_NO_CON_SAL_SPD) {
		R19_NO_CON_SAL_SPD = r19_NO_CON_SAL_SPD;
	}

	public String getR19_NO_CON_BUS_SPD() {
		return R19_NO_CON_BUS_SPD;
	}

	public void setR19_NO_CON_BUS_SPD(String r19_NO_CON_BUS_SPD) {
		R19_NO_CON_BUS_SPD = r19_NO_CON_BUS_SPD;
	}

	public String getR19_NO_CON_PRO_SPD() {
		return R19_NO_CON_PRO_SPD;
	}

	public void setR19_NO_CON_PRO_SPD(String r19_NO_CON_PRO_SPD) {
		R19_NO_CON_PRO_SPD = r19_NO_CON_PRO_SPD;
	}

	public String getR19_NO_CON_INC_5K() {
		return R19_NO_CON_INC_5K;
	}

	public void setR19_NO_CON_INC_5K(String r19_NO_CON_INC_5K) {
		R19_NO_CON_INC_5K = r19_NO_CON_INC_5K;
	}

	public String getR19_NO_CON_INC_5K_10K() {
		return R19_NO_CON_INC_5K_10K;
	}

	public void setR19_NO_CON_INC_5K_10K(String r19_NO_CON_INC_5K_10K) {
		R19_NO_CON_INC_5K_10K = r19_NO_CON_INC_5K_10K;
	}

	public String getR19_NO_CON_INC_10K_20K() {
		return R19_NO_CON_INC_10K_20K;
	}

	public void setR19_NO_CON_INC_10K_20K(String r19_NO_CON_INC_10K_20K) {
		R19_NO_CON_INC_10K_20K = r19_NO_CON_INC_10K_20K;
	}

	public String getR19_NO_CON_INC_20K_35K() {
		return R19_NO_CON_INC_20K_35K;
	}

	public void setR19_NO_CON_INC_20K_35K(String r19_NO_CON_INC_20K_35K) {
		R19_NO_CON_INC_20K_35K = r19_NO_CON_INC_20K_35K;
	}

	public String getR19_NO_CON_INC_35K() {
		return R19_NO_CON_INC_35K;
	}

	public void setR19_NO_CON_INC_35K(String r19_NO_CON_INC_35K) {
		R19_NO_CON_INC_35K = r19_NO_CON_INC_35K;
	}

	public String getR19_NO_CON_BEL_SCL() {
		return R19_NO_CON_BEL_SCL;
	}

	public void setR19_NO_CON_BEL_SCL(String r19_NO_CON_BEL_SCL) {
		R19_NO_CON_BEL_SCL = r19_NO_CON_BEL_SCL;
	}

	public String getR19_NO_CON_BAC() {
		return R19_NO_CON_BAC;
	}

	public void setR19_NO_CON_BAC(String r19_NO_CON_BAC) {
		R19_NO_CON_BAC = r19_NO_CON_BAC;
	}

	public String getR19_NO_CON_ABV_MAS() {
		return R19_NO_CON_ABV_MAS;
	}

	public void setR19_NO_CON_ABV_MAS(String r19_NO_CON_ABV_MAS) {
		R19_NO_CON_ABV_MAS = r19_NO_CON_ABV_MAS;
	}

	public String getR19_NO_CON_ABU_KYC() {
		return R19_NO_CON_ABU_KYC;
	}

	public void setR19_NO_CON_ABU_KYC(String r19_NO_CON_ABU_KYC) {
		R19_NO_CON_ABU_KYC = r19_NO_CON_ABU_KYC;
	}

	public String getR19_NO_CON_DUB_KYC() {
		return R19_NO_CON_DUB_KYC;
	}

	public void setR19_NO_CON_DUB_KYC(String r19_NO_CON_DUB_KYC) {
		R19_NO_CON_DUB_KYC = r19_NO_CON_DUB_KYC;
	}

	public String getR19_NO_CON_SHJ_KYC() {
		return R19_NO_CON_SHJ_KYC;
	}

	public void setR19_NO_CON_SHJ_KYC(String r19_NO_CON_SHJ_KYC) {
		R19_NO_CON_SHJ_KYC = r19_NO_CON_SHJ_KYC;
	}

	public String getR19_NO_CON_AJM_KYC() {
		return R19_NO_CON_AJM_KYC;
	}

	public void setR19_NO_CON_AJM_KYC(String r19_NO_CON_AJM_KYC) {
		R19_NO_CON_AJM_KYC = r19_NO_CON_AJM_KYC;
	}

	public String getR19_NO_CON_FUJ_KYC() {
		return R19_NO_CON_FUJ_KYC;
	}

	public void setR19_NO_CON_FUJ_KYC(String r19_NO_CON_FUJ_KYC) {
		R19_NO_CON_FUJ_KYC = r19_NO_CON_FUJ_KYC;
	}

	public String getR19_NO_CON_RAK_KYC() {
		return R19_NO_CON_RAK_KYC;
	}

	public void setR19_NO_CON_RAK_KYC(String r19_NO_CON_RAK_KYC) {
		R19_NO_CON_RAK_KYC = r19_NO_CON_RAK_KYC;
	}

	public String getR19_NO_CON_UAQ_KYC() {
		return R19_NO_CON_UAQ_KYC;
	}

	public void setR19_NO_CON_UAQ_KYC(String r19_NO_CON_UAQ_KYC) {
		R19_NO_CON_UAQ_KYC = r19_NO_CON_UAQ_KYC;
	}

	public String getR19_NO_CON_RET() {
		return R19_NO_CON_RET;
	}

	public void setR19_NO_CON_RET(String r19_NO_CON_RET) {
		R19_NO_CON_RET = r19_NO_CON_RET;
	}

	public String getR19_NO_CON_DBR_LIM() {
		return R19_NO_CON_DBR_LIM;
	}

	public void setR19_NO_CON_DBR_LIM(String r19_NO_CON_DBR_LIM) {
		R19_NO_CON_DBR_LIM = r19_NO_CON_DBR_LIM;
	}

	public String getR19_NO_UAE_CON_SPC_TP() {
		return R19_NO_UAE_CON_SPC_TP;
	}

	public void setR19_NO_UAE_CON_SPC_TP(String r19_NO_UAE_CON_SPC_TP) {
		R19_NO_UAE_CON_SPC_TP = r19_NO_UAE_CON_SPC_TP;
	}

	public String getR19_NO_UAE_CON_NLS() {
		return R19_NO_UAE_CON_NLS;
	}

	public void setR19_NO_UAE_CON_NLS(String r19_NO_UAE_CON_NLS) {
		R19_NO_UAE_CON_NLS = r19_NO_UAE_CON_NLS;
	}

	public String getR19_VAL_LOS_AED() {
		return R19_VAL_LOS_AED;
	}

	public void setR19_VAL_LOS_AED(String r19_VAL_LOS_AED) {
		R19_VAL_LOS_AED = r19_VAL_LOS_AED;
	}

	public String getR19_NO_CON_ONB_90() {
		return R19_NO_CON_ONB_90;
	}

	public void setR19_NO_CON_ONB_90(String r19_NO_CON_ONB_90) {
		R19_NO_CON_ONB_90 = r19_NO_CON_ONB_90;
	}

	public String getR19_NO_CON_BAL_PAY() {
		return R19_NO_CON_BAL_PAY;
	}

	public void setR19_NO_CON_BAL_PAY(String r19_NO_CON_BAL_PAY) {
		R19_NO_CON_BAL_PAY = r19_NO_CON_BAL_PAY;
	}

	public String getR19_NO_CON_BAL_SPC_TP() {
		return R19_NO_CON_BAL_SPC_TP;
	}

	public void setR19_NO_CON_BAL_SPC_TP(String r19_NO_CON_BAL_SPC_TP) {
		R19_NO_CON_BAL_SPC_TP = r19_NO_CON_BAL_SPC_TP;
	}

	public String getR19_NO_CON_DEBT() {
		return R19_NO_CON_DEBT;
	}

	public void setR19_NO_CON_DEBT(String r19_NO_CON_DEBT) {
		R19_NO_CON_DEBT = r19_NO_CON_DEBT;
	}

	public String getR19_NO_CON_ONB_REF() {
		return R19_NO_CON_ONB_REF;
	}

	public void setR19_NO_CON_ONB_REF(String r19_NO_CON_ONB_REF) {
		R19_NO_CON_ONB_REF = r19_NO_CON_ONB_REF;
	}

	public String getR19_NO_CON_ONB_AGE() {
		return R19_NO_CON_ONB_AGE;
	}

	public void setR19_NO_CON_ONB_AGE(String r19_NO_CON_ONB_AGE) {
		R19_NO_CON_ONB_AGE = r19_NO_CON_ONB_AGE;
	}

	public String getR19_NO_CON_AFF_UNAU() {
		return R19_NO_CON_AFF_UNAU;
	}

	public void setR19_NO_CON_AFF_UNAU(String r19_NO_CON_AFF_UNAU) {
		R19_NO_CON_AFF_UNAU = r19_NO_CON_AFF_UNAU;
	}

	public String getR19_NO_OF_ACCS_POD() {
		return R19_NO_OF_ACCS_POD;
	}

	public void setR19_NO_OF_ACCS_POD(String r19_NO_OF_ACCS_POD) {
		R19_NO_OF_ACCS_POD = r19_NO_OF_ACCS_POD;
	}

	public String getR19_NO_DEL_CON() {
		return R19_NO_DEL_CON;
	}

	public void setR19_NO_DEL_CON(String r19_NO_DEL_CON) {
		R19_NO_DEL_CON = r19_NO_DEL_CON;
	}

	public String getR19_NO_INS_FUN_LFI() {
		return R19_NO_INS_FUN_LFI;
	}

	public void setR19_NO_INS_FUN_LFI(String r19_NO_INS_FUN_LFI) {
		R19_NO_INS_FUN_LFI = r19_NO_INS_FUN_LFI;
	}

	public String getR19_NO_CON_COL_FIN() {
		return R19_NO_CON_COL_FIN;
	}

	public void setR19_NO_CON_COL_FIN(String r19_NO_CON_COL_FIN) {
		R19_NO_CON_COL_FIN = r19_NO_CON_COL_FIN;
	}

	public String getR19_TOT_NO_NEW_FIN() {
		return R19_TOT_NO_NEW_FIN;
	}

	public void setR19_TOT_NO_NEW_FIN(String r19_TOT_NO_NEW_FIN) {
		R19_TOT_NO_NEW_FIN = r19_TOT_NO_NEW_FIN;
	}

	public String getR19_TOT_NO_NEW_NOSGN() {
		return R19_TOT_NO_NEW_NOSGN;
	}

	public void setR19_TOT_NO_NEW_NOSGN(String r19_TOT_NO_NEW_NOSGN) {
		R19_TOT_NO_NEW_NOSGN = r19_TOT_NO_NEW_NOSGN;
	}

	public String getR19_NO_CON_START() {
		return R19_NO_CON_START;
	}

	public void setR19_NO_CON_START(String r19_NO_CON_START) {
		R19_NO_CON_START = r19_NO_CON_START;
	}

	public String getR19_NO_NEW_CON_ONBO() {
		return R19_NO_NEW_CON_ONBO;
	}

	public void setR19_NO_NEW_CON_ONBO(String r19_NO_NEW_CON_ONBO) {
		R19_NO_NEW_CON_ONBO = r19_NO_NEW_CON_ONBO;
	}

	public String getR19_NO_CON_DEBT_COUN() {
		return R19_NO_CON_DEBT_COUN;
	}

	public void setR19_NO_CON_DEBT_COUN(String r19_NO_CON_DEBT_COUN) {
		R19_NO_CON_DEBT_COUN = r19_NO_CON_DEBT_COUN;
	}

	public String getR19_NO_CON_DEL_NPA() {
		return R19_NO_CON_DEL_NPA;
	}

	public void setR19_NO_CON_DEL_NPA(String r19_NO_CON_DEL_NPA) {
		R19_NO_CON_DEL_NPA = r19_NO_CON_DEL_NPA;
	}

	public String getR19_NO_CON_GOV_50() {
		return R19_NO_CON_GOV_50;
	}

	public void setR19_NO_CON_GOV_50(String r19_NO_CON_GOV_50) {
		R19_NO_CON_GOV_50 = r19_NO_CON_GOV_50;
	}

	public String getR19_NO_SME_SOLE() {
		return R19_NO_SME_SOLE;
	}

	public void setR19_NO_SME_SOLE(String r19_NO_SME_SOLE) {
		R19_NO_SME_SOLE = r19_NO_SME_SOLE;
	}

	public String getR19_NO_CON_TAG_VUL() {
		return R19_NO_CON_TAG_VUL;
	}

	public void setR19_NO_CON_TAG_VUL(String r19_NO_CON_TAG_VUL) {
		R19_NO_CON_TAG_VUL = r19_NO_CON_TAG_VUL;
	}

	public String getR19_NO_NEW_CON_ONB_GNP() {
		return R19_NO_NEW_CON_ONB_GNP;
	}

	public void setR19_NO_NEW_CON_ONB_GNP(String r19_NO_NEW_CON_ONB_GNP) {
		R19_NO_NEW_CON_ONB_GNP = r19_NO_NEW_CON_ONB_GNP;
	}

	public String getR19_NO_CON_END() {
		return R19_NO_CON_END;
	}

	public void setR19_NO_CON_END(String r19_NO_CON_END) {
		R19_NO_CON_END = r19_NO_CON_END;
	}

	public String getR20_BANK() {
		return R20_BANK;
	}

	public void setR20_BANK(String r20_BANK) {
		R20_BANK = r20_BANK;
	}

	public String getR20_PRODUCT() {
		return R20_PRODUCT;
	}

	public void setR20_PRODUCT(String r20_PRODUCT) {
		R20_PRODUCT = r20_PRODUCT;
	}

	public String getR20_NO_WO_SD() {
		return R20_NO_WO_SD;
	}

	public void setR20_NO_WO_SD(String r20_NO_WO_SD) {
		R20_NO_WO_SD = r20_NO_WO_SD;
	}

	public String getR20_NO_CON_POD_SD() {
		return R20_NO_CON_POD_SD;
	}

	public void setR20_NO_CON_POD_SD(String r20_NO_CON_POD_SD) {
		R20_NO_CON_POD_SD = r20_NO_CON_POD_SD;
	}

	public String getR20_NO_CON_UNAU_SP_TP() {
		return R20_NO_CON_UNAU_SP_TP;
	}

	public void setR20_NO_CON_UNAU_SP_TP(String r20_NO_CON_UNAU_SP_TP) {
		R20_NO_CON_UNAU_SP_TP = r20_NO_CON_UNAU_SP_TP;
	}

	public String getR20_NO_CON_45_50() {
		return R20_NO_CON_45_50;
	}

	public void setR20_NO_CON_45_50(String r20_NO_CON_45_50) {
		R20_NO_CON_45_50 = r20_NO_CON_45_50;
	}

	public String getR20_NO_CON_50() {
		return R20_NO_CON_50;
	}

	public void setR20_NO_CON_50(String r20_NO_CON_50) {
		R20_NO_CON_50 = r20_NO_CON_50;
	}

	public String getR20_NO_OF_LES_50() {
		return R20_NO_OF_LES_50;
	}

	public void setR20_NO_OF_LES_50(String r20_NO_OF_LES_50) {
		R20_NO_OF_LES_50 = r20_NO_OF_LES_50;
	}

	public String getR20_NO_OF_BNK_18() {
		return R20_NO_OF_BNK_18;
	}

	public void setR20_NO_OF_BNK_18(String r20_NO_OF_BNK_18) {
		R20_NO_OF_BNK_18 = r20_NO_OF_BNK_18;
	}

	public String getR20_NO_OF_BNK_18_25() {
		return R20_NO_OF_BNK_18_25;
	}

	public void setR20_NO_OF_BNK_18_25(String r20_NO_OF_BNK_18_25) {
		R20_NO_OF_BNK_18_25 = r20_NO_OF_BNK_18_25;
	}

	public String getR20_NO_OF_BNK_26_35() {
		return R20_NO_OF_BNK_26_35;
	}

	public void setR20_NO_OF_BNK_26_35(String r20_NO_OF_BNK_26_35) {
		R20_NO_OF_BNK_26_35 = r20_NO_OF_BNK_26_35;
	}

	public String getR20_NO_OF_BNK_36_50() {
		return R20_NO_OF_BNK_36_50;
	}

	public void setR20_NO_OF_BNK_36_50(String r20_NO_OF_BNK_36_50) {
		R20_NO_OF_BNK_36_50 = r20_NO_OF_BNK_36_50;
	}

	public String getR20_NO_CON_BNK_50() {
		return R20_NO_CON_BNK_50;
	}

	public void setR20_NO_CON_BNK_50(String r20_NO_CON_BNK_50) {
		R20_NO_CON_BNK_50 = r20_NO_CON_BNK_50;
	}

	public String getR20_NO_CON_SAL_SPD() {
		return R20_NO_CON_SAL_SPD;
	}

	public void setR20_NO_CON_SAL_SPD(String r20_NO_CON_SAL_SPD) {
		R20_NO_CON_SAL_SPD = r20_NO_CON_SAL_SPD;
	}

	public String getR20_NO_CON_BUS_SPD() {
		return R20_NO_CON_BUS_SPD;
	}

	public void setR20_NO_CON_BUS_SPD(String r20_NO_CON_BUS_SPD) {
		R20_NO_CON_BUS_SPD = r20_NO_CON_BUS_SPD;
	}

	public String getR20_NO_CON_PRO_SPD() {
		return R20_NO_CON_PRO_SPD;
	}

	public void setR20_NO_CON_PRO_SPD(String r20_NO_CON_PRO_SPD) {
		R20_NO_CON_PRO_SPD = r20_NO_CON_PRO_SPD;
	}

	public String getR20_NO_CON_INC_5K() {
		return R20_NO_CON_INC_5K;
	}

	public void setR20_NO_CON_INC_5K(String r20_NO_CON_INC_5K) {
		R20_NO_CON_INC_5K = r20_NO_CON_INC_5K;
	}

	public String getR20_NO_CON_INC_5K_10K() {
		return R20_NO_CON_INC_5K_10K;
	}

	public void setR20_NO_CON_INC_5K_10K(String r20_NO_CON_INC_5K_10K) {
		R20_NO_CON_INC_5K_10K = r20_NO_CON_INC_5K_10K;
	}

	public String getR20_NO_CON_INC_10K_20K() {
		return R20_NO_CON_INC_10K_20K;
	}

	public void setR20_NO_CON_INC_10K_20K(String r20_NO_CON_INC_10K_20K) {
		R20_NO_CON_INC_10K_20K = r20_NO_CON_INC_10K_20K;
	}

	public String getR20_NO_CON_INC_20K_35K() {
		return R20_NO_CON_INC_20K_35K;
	}

	public void setR20_NO_CON_INC_20K_35K(String r20_NO_CON_INC_20K_35K) {
		R20_NO_CON_INC_20K_35K = r20_NO_CON_INC_20K_35K;
	}

	public String getR20_NO_CON_INC_35K() {
		return R20_NO_CON_INC_35K;
	}

	public void setR20_NO_CON_INC_35K(String r20_NO_CON_INC_35K) {
		R20_NO_CON_INC_35K = r20_NO_CON_INC_35K;
	}

	public String getR20_NO_CON_BEL_SCL() {
		return R20_NO_CON_BEL_SCL;
	}

	public void setR20_NO_CON_BEL_SCL(String r20_NO_CON_BEL_SCL) {
		R20_NO_CON_BEL_SCL = r20_NO_CON_BEL_SCL;
	}

	public String getR20_NO_CON_BAC() {
		return R20_NO_CON_BAC;
	}

	public void setR20_NO_CON_BAC(String r20_NO_CON_BAC) {
		R20_NO_CON_BAC = r20_NO_CON_BAC;
	}

	public String getR20_NO_CON_ABV_MAS() {
		return R20_NO_CON_ABV_MAS;
	}

	public void setR20_NO_CON_ABV_MAS(String r20_NO_CON_ABV_MAS) {
		R20_NO_CON_ABV_MAS = r20_NO_CON_ABV_MAS;
	}

	public String getR20_NO_CON_ABU_KYC() {
		return R20_NO_CON_ABU_KYC;
	}

	public void setR20_NO_CON_ABU_KYC(String r20_NO_CON_ABU_KYC) {
		R20_NO_CON_ABU_KYC = r20_NO_CON_ABU_KYC;
	}

	public String getR20_NO_CON_DUB_KYC() {
		return R20_NO_CON_DUB_KYC;
	}

	public void setR20_NO_CON_DUB_KYC(String r20_NO_CON_DUB_KYC) {
		R20_NO_CON_DUB_KYC = r20_NO_CON_DUB_KYC;
	}

	public String getR20_NO_CON_SHJ_KYC() {
		return R20_NO_CON_SHJ_KYC;
	}

	public void setR20_NO_CON_SHJ_KYC(String r20_NO_CON_SHJ_KYC) {
		R20_NO_CON_SHJ_KYC = r20_NO_CON_SHJ_KYC;
	}

	public String getR20_NO_CON_AJM_KYC() {
		return R20_NO_CON_AJM_KYC;
	}

	public void setR20_NO_CON_AJM_KYC(String r20_NO_CON_AJM_KYC) {
		R20_NO_CON_AJM_KYC = r20_NO_CON_AJM_KYC;
	}

	public String getR20_NO_CON_FUJ_KYC() {
		return R20_NO_CON_FUJ_KYC;
	}

	public void setR20_NO_CON_FUJ_KYC(String r20_NO_CON_FUJ_KYC) {
		R20_NO_CON_FUJ_KYC = r20_NO_CON_FUJ_KYC;
	}

	public String getR20_NO_CON_RAK_KYC() {
		return R20_NO_CON_RAK_KYC;
	}

	public void setR20_NO_CON_RAK_KYC(String r20_NO_CON_RAK_KYC) {
		R20_NO_CON_RAK_KYC = r20_NO_CON_RAK_KYC;
	}

	public String getR20_NO_CON_UAQ_KYC() {
		return R20_NO_CON_UAQ_KYC;
	}

	public void setR20_NO_CON_UAQ_KYC(String r20_NO_CON_UAQ_KYC) {
		R20_NO_CON_UAQ_KYC = r20_NO_CON_UAQ_KYC;
	}

	public String getR20_NO_CON_RET() {
		return R20_NO_CON_RET;
	}

	public void setR20_NO_CON_RET(String r20_NO_CON_RET) {
		R20_NO_CON_RET = r20_NO_CON_RET;
	}

	public String getR20_NO_CON_DBR_LIM() {
		return R20_NO_CON_DBR_LIM;
	}

	public void setR20_NO_CON_DBR_LIM(String r20_NO_CON_DBR_LIM) {
		R20_NO_CON_DBR_LIM = r20_NO_CON_DBR_LIM;
	}

	public String getR20_NO_UAE_CON_SPC_TP() {
		return R20_NO_UAE_CON_SPC_TP;
	}

	public void setR20_NO_UAE_CON_SPC_TP(String r20_NO_UAE_CON_SPC_TP) {
		R20_NO_UAE_CON_SPC_TP = r20_NO_UAE_CON_SPC_TP;
	}

	public String getR20_NO_UAE_CON_NLS() {
		return R20_NO_UAE_CON_NLS;
	}

	public void setR20_NO_UAE_CON_NLS(String r20_NO_UAE_CON_NLS) {
		R20_NO_UAE_CON_NLS = r20_NO_UAE_CON_NLS;
	}

	public String getR20_VAL_LOS_AED() {
		return R20_VAL_LOS_AED;
	}

	public void setR20_VAL_LOS_AED(String r20_VAL_LOS_AED) {
		R20_VAL_LOS_AED = r20_VAL_LOS_AED;
	}

	public String getR20_NO_CON_ONB_90() {
		return R20_NO_CON_ONB_90;
	}

	public void setR20_NO_CON_ONB_90(String r20_NO_CON_ONB_90) {
		R20_NO_CON_ONB_90 = r20_NO_CON_ONB_90;
	}

	public String getR20_NO_CON_BAL_PAY() {
		return R20_NO_CON_BAL_PAY;
	}

	public void setR20_NO_CON_BAL_PAY(String r20_NO_CON_BAL_PAY) {
		R20_NO_CON_BAL_PAY = r20_NO_CON_BAL_PAY;
	}

	public String getR20_NO_CON_BAL_SPC_TP() {
		return R20_NO_CON_BAL_SPC_TP;
	}

	public void setR20_NO_CON_BAL_SPC_TP(String r20_NO_CON_BAL_SPC_TP) {
		R20_NO_CON_BAL_SPC_TP = r20_NO_CON_BAL_SPC_TP;
	}

	public String getR20_NO_CON_DEBT() {
		return R20_NO_CON_DEBT;
	}

	public void setR20_NO_CON_DEBT(String r20_NO_CON_DEBT) {
		R20_NO_CON_DEBT = r20_NO_CON_DEBT;
	}

	public String getR20_NO_CON_ONB_REF() {
		return R20_NO_CON_ONB_REF;
	}

	public void setR20_NO_CON_ONB_REF(String r20_NO_CON_ONB_REF) {
		R20_NO_CON_ONB_REF = r20_NO_CON_ONB_REF;
	}

	public String getR20_NO_CON_ONB_AGE() {
		return R20_NO_CON_ONB_AGE;
	}

	public void setR20_NO_CON_ONB_AGE(String r20_NO_CON_ONB_AGE) {
		R20_NO_CON_ONB_AGE = r20_NO_CON_ONB_AGE;
	}

	public String getR20_NO_CON_AFF_UNAU() {
		return R20_NO_CON_AFF_UNAU;
	}

	public void setR20_NO_CON_AFF_UNAU(String r20_NO_CON_AFF_UNAU) {
		R20_NO_CON_AFF_UNAU = r20_NO_CON_AFF_UNAU;
	}

	public String getR20_NO_OF_ACCS_POD() {
		return R20_NO_OF_ACCS_POD;
	}

	public void setR20_NO_OF_ACCS_POD(String r20_NO_OF_ACCS_POD) {
		R20_NO_OF_ACCS_POD = r20_NO_OF_ACCS_POD;
	}

	public String getR20_NO_DEL_CON() {
		return R20_NO_DEL_CON;
	}

	public void setR20_NO_DEL_CON(String r20_NO_DEL_CON) {
		R20_NO_DEL_CON = r20_NO_DEL_CON;
	}

	public String getR20_NO_INS_FUN_LFI() {
		return R20_NO_INS_FUN_LFI;
	}

	public void setR20_NO_INS_FUN_LFI(String r20_NO_INS_FUN_LFI) {
		R20_NO_INS_FUN_LFI = r20_NO_INS_FUN_LFI;
	}

	public String getR20_NO_CON_COL_FIN() {
		return R20_NO_CON_COL_FIN;
	}

	public void setR20_NO_CON_COL_FIN(String r20_NO_CON_COL_FIN) {
		R20_NO_CON_COL_FIN = r20_NO_CON_COL_FIN;
	}

	public String getR20_TOT_NO_NEW_FIN() {
		return R20_TOT_NO_NEW_FIN;
	}

	public void setR20_TOT_NO_NEW_FIN(String r20_TOT_NO_NEW_FIN) {
		R20_TOT_NO_NEW_FIN = r20_TOT_NO_NEW_FIN;
	}

	public String getR20_TOT_NO_NEW_NOSGN() {
		return R20_TOT_NO_NEW_NOSGN;
	}

	public void setR20_TOT_NO_NEW_NOSGN(String r20_TOT_NO_NEW_NOSGN) {
		R20_TOT_NO_NEW_NOSGN = r20_TOT_NO_NEW_NOSGN;
	}

	public String getR20_NO_CON_START() {
		return R20_NO_CON_START;
	}

	public void setR20_NO_CON_START(String r20_NO_CON_START) {
		R20_NO_CON_START = r20_NO_CON_START;
	}

	public String getR20_NO_NEW_CON_ONBO() {
		return R20_NO_NEW_CON_ONBO;
	}

	public void setR20_NO_NEW_CON_ONBO(String r20_NO_NEW_CON_ONBO) {
		R20_NO_NEW_CON_ONBO = r20_NO_NEW_CON_ONBO;
	}

	public String getR20_NO_CON_DEBT_COUN() {
		return R20_NO_CON_DEBT_COUN;
	}

	public void setR20_NO_CON_DEBT_COUN(String r20_NO_CON_DEBT_COUN) {
		R20_NO_CON_DEBT_COUN = r20_NO_CON_DEBT_COUN;
	}

	public String getR20_NO_CON_DEL_NPA() {
		return R20_NO_CON_DEL_NPA;
	}

	public void setR20_NO_CON_DEL_NPA(String r20_NO_CON_DEL_NPA) {
		R20_NO_CON_DEL_NPA = r20_NO_CON_DEL_NPA;
	}

	public String getR20_NO_CON_GOV_50() {
		return R20_NO_CON_GOV_50;
	}

	public void setR20_NO_CON_GOV_50(String r20_NO_CON_GOV_50) {
		R20_NO_CON_GOV_50 = r20_NO_CON_GOV_50;
	}

	public String getR20_NO_SME_SOLE() {
		return R20_NO_SME_SOLE;
	}

	public void setR20_NO_SME_SOLE(String r20_NO_SME_SOLE) {
		R20_NO_SME_SOLE = r20_NO_SME_SOLE;
	}

	public String getR20_NO_CON_TAG_VUL() {
		return R20_NO_CON_TAG_VUL;
	}

	public void setR20_NO_CON_TAG_VUL(String r20_NO_CON_TAG_VUL) {
		R20_NO_CON_TAG_VUL = r20_NO_CON_TAG_VUL;
	}

	public String getR20_NO_NEW_CON_ONB_GNP() {
		return R20_NO_NEW_CON_ONB_GNP;
	}

	public void setR20_NO_NEW_CON_ONB_GNP(String r20_NO_NEW_CON_ONB_GNP) {
		R20_NO_NEW_CON_ONB_GNP = r20_NO_NEW_CON_ONB_GNP;
	}

	public String getR20_NO_CON_END() {
		return R20_NO_CON_END;
	}

	public void setR20_NO_CON_END(String r20_NO_CON_END) {
		R20_NO_CON_END = r20_NO_CON_END;
	}

	public String getR21_BANK() {
		return R21_BANK;
	}

	public void setR21_BANK(String r21_BANK) {
		R21_BANK = r21_BANK;
	}

	public String getR21_PRODUCT() {
		return R21_PRODUCT;
	}

	public void setR21_PRODUCT(String r21_PRODUCT) {
		R21_PRODUCT = r21_PRODUCT;
	}

	public String getR21_NO_WO_SD() {
		return R21_NO_WO_SD;
	}

	public void setR21_NO_WO_SD(String r21_NO_WO_SD) {
		R21_NO_WO_SD = r21_NO_WO_SD;
	}

	public String getR21_NO_CON_POD_SD() {
		return R21_NO_CON_POD_SD;
	}

	public void setR21_NO_CON_POD_SD(String r21_NO_CON_POD_SD) {
		R21_NO_CON_POD_SD = r21_NO_CON_POD_SD;
	}

	public String getR21_NO_CON_UNAU_SP_TP() {
		return R21_NO_CON_UNAU_SP_TP;
	}

	public void setR21_NO_CON_UNAU_SP_TP(String r21_NO_CON_UNAU_SP_TP) {
		R21_NO_CON_UNAU_SP_TP = r21_NO_CON_UNAU_SP_TP;
	}

	public String getR21_NO_CON_45_50() {
		return R21_NO_CON_45_50;
	}

	public void setR21_NO_CON_45_50(String r21_NO_CON_45_50) {
		R21_NO_CON_45_50 = r21_NO_CON_45_50;
	}

	public String getR21_NO_CON_50() {
		return R21_NO_CON_50;
	}

	public void setR21_NO_CON_50(String r21_NO_CON_50) {
		R21_NO_CON_50 = r21_NO_CON_50;
	}

	public String getR21_NO_OF_LES_50() {
		return R21_NO_OF_LES_50;
	}

	public void setR21_NO_OF_LES_50(String r21_NO_OF_LES_50) {
		R21_NO_OF_LES_50 = r21_NO_OF_LES_50;
	}

	public String getR21_NO_OF_BNK_18() {
		return R21_NO_OF_BNK_18;
	}

	public void setR21_NO_OF_BNK_18(String r21_NO_OF_BNK_18) {
		R21_NO_OF_BNK_18 = r21_NO_OF_BNK_18;
	}

	public String getR21_NO_OF_BNK_18_25() {
		return R21_NO_OF_BNK_18_25;
	}

	public void setR21_NO_OF_BNK_18_25(String r21_NO_OF_BNK_18_25) {
		R21_NO_OF_BNK_18_25 = r21_NO_OF_BNK_18_25;
	}

	public String getR21_NO_OF_BNK_26_35() {
		return R21_NO_OF_BNK_26_35;
	}

	public void setR21_NO_OF_BNK_26_35(String r21_NO_OF_BNK_26_35) {
		R21_NO_OF_BNK_26_35 = r21_NO_OF_BNK_26_35;
	}

	public String getR21_NO_OF_BNK_36_50() {
		return R21_NO_OF_BNK_36_50;
	}

	public void setR21_NO_OF_BNK_36_50(String r21_NO_OF_BNK_36_50) {
		R21_NO_OF_BNK_36_50 = r21_NO_OF_BNK_36_50;
	}

	public String getR21_NO_CON_BNK_50() {
		return R21_NO_CON_BNK_50;
	}

	public void setR21_NO_CON_BNK_50(String r21_NO_CON_BNK_50) {
		R21_NO_CON_BNK_50 = r21_NO_CON_BNK_50;
	}

	public String getR21_NO_CON_SAL_SPD() {
		return R21_NO_CON_SAL_SPD;
	}

	public void setR21_NO_CON_SAL_SPD(String r21_NO_CON_SAL_SPD) {
		R21_NO_CON_SAL_SPD = r21_NO_CON_SAL_SPD;
	}

	public String getR21_NO_CON_BUS_SPD() {
		return R21_NO_CON_BUS_SPD;
	}

	public void setR21_NO_CON_BUS_SPD(String r21_NO_CON_BUS_SPD) {
		R21_NO_CON_BUS_SPD = r21_NO_CON_BUS_SPD;
	}

	public String getR21_NO_CON_PRO_SPD() {
		return R21_NO_CON_PRO_SPD;
	}

	public void setR21_NO_CON_PRO_SPD(String r21_NO_CON_PRO_SPD) {
		R21_NO_CON_PRO_SPD = r21_NO_CON_PRO_SPD;
	}

	public String getR21_NO_CON_INC_5K() {
		return R21_NO_CON_INC_5K;
	}

	public void setR21_NO_CON_INC_5K(String r21_NO_CON_INC_5K) {
		R21_NO_CON_INC_5K = r21_NO_CON_INC_5K;
	}

	public String getR21_NO_CON_INC_5K_10K() {
		return R21_NO_CON_INC_5K_10K;
	}

	public void setR21_NO_CON_INC_5K_10K(String r21_NO_CON_INC_5K_10K) {
		R21_NO_CON_INC_5K_10K = r21_NO_CON_INC_5K_10K;
	}

	public String getR21_NO_CON_INC_10K_20K() {
		return R21_NO_CON_INC_10K_20K;
	}

	public void setR21_NO_CON_INC_10K_20K(String r21_NO_CON_INC_10K_20K) {
		R21_NO_CON_INC_10K_20K = r21_NO_CON_INC_10K_20K;
	}

	public String getR21_NO_CON_INC_20K_35K() {
		return R21_NO_CON_INC_20K_35K;
	}

	public void setR21_NO_CON_INC_20K_35K(String r21_NO_CON_INC_20K_35K) {
		R21_NO_CON_INC_20K_35K = r21_NO_CON_INC_20K_35K;
	}

	public String getR21_NO_CON_INC_35K() {
		return R21_NO_CON_INC_35K;
	}

	public void setR21_NO_CON_INC_35K(String r21_NO_CON_INC_35K) {
		R21_NO_CON_INC_35K = r21_NO_CON_INC_35K;
	}

	public String getR21_NO_CON_BEL_SCL() {
		return R21_NO_CON_BEL_SCL;
	}

	public void setR21_NO_CON_BEL_SCL(String r21_NO_CON_BEL_SCL) {
		R21_NO_CON_BEL_SCL = r21_NO_CON_BEL_SCL;
	}

	public String getR21_NO_CON_BAC() {
		return R21_NO_CON_BAC;
	}

	public void setR21_NO_CON_BAC(String r21_NO_CON_BAC) {
		R21_NO_CON_BAC = r21_NO_CON_BAC;
	}

	public String getR21_NO_CON_ABV_MAS() {
		return R21_NO_CON_ABV_MAS;
	}

	public void setR21_NO_CON_ABV_MAS(String r21_NO_CON_ABV_MAS) {
		R21_NO_CON_ABV_MAS = r21_NO_CON_ABV_MAS;
	}

	public String getR21_NO_CON_ABU_KYC() {
		return R21_NO_CON_ABU_KYC;
	}

	public void setR21_NO_CON_ABU_KYC(String r21_NO_CON_ABU_KYC) {
		R21_NO_CON_ABU_KYC = r21_NO_CON_ABU_KYC;
	}

	public String getR21_NO_CON_DUB_KYC() {
		return R21_NO_CON_DUB_KYC;
	}

	public void setR21_NO_CON_DUB_KYC(String r21_NO_CON_DUB_KYC) {
		R21_NO_CON_DUB_KYC = r21_NO_CON_DUB_KYC;
	}

	public String getR21_NO_CON_SHJ_KYC() {
		return R21_NO_CON_SHJ_KYC;
	}

	public void setR21_NO_CON_SHJ_KYC(String r21_NO_CON_SHJ_KYC) {
		R21_NO_CON_SHJ_KYC = r21_NO_CON_SHJ_KYC;
	}

	public String getR21_NO_CON_AJM_KYC() {
		return R21_NO_CON_AJM_KYC;
	}

	public void setR21_NO_CON_AJM_KYC(String r21_NO_CON_AJM_KYC) {
		R21_NO_CON_AJM_KYC = r21_NO_CON_AJM_KYC;
	}

	public String getR21_NO_CON_FUJ_KYC() {
		return R21_NO_CON_FUJ_KYC;
	}

	public void setR21_NO_CON_FUJ_KYC(String r21_NO_CON_FUJ_KYC) {
		R21_NO_CON_FUJ_KYC = r21_NO_CON_FUJ_KYC;
	}

	public String getR21_NO_CON_RAK_KYC() {
		return R21_NO_CON_RAK_KYC;
	}

	public void setR21_NO_CON_RAK_KYC(String r21_NO_CON_RAK_KYC) {
		R21_NO_CON_RAK_KYC = r21_NO_CON_RAK_KYC;
	}

	public String getR21_NO_CON_UAQ_KYC() {
		return R21_NO_CON_UAQ_KYC;
	}

	public void setR21_NO_CON_UAQ_KYC(String r21_NO_CON_UAQ_KYC) {
		R21_NO_CON_UAQ_KYC = r21_NO_CON_UAQ_KYC;
	}

	public String getR21_NO_CON_RET() {
		return R21_NO_CON_RET;
	}

	public void setR21_NO_CON_RET(String r21_NO_CON_RET) {
		R21_NO_CON_RET = r21_NO_CON_RET;
	}

	public String getR21_NO_CON_DBR_LIM() {
		return R21_NO_CON_DBR_LIM;
	}

	public void setR21_NO_CON_DBR_LIM(String r21_NO_CON_DBR_LIM) {
		R21_NO_CON_DBR_LIM = r21_NO_CON_DBR_LIM;
	}

	public String getR21_NO_UAE_CON_SPC_TP() {
		return R21_NO_UAE_CON_SPC_TP;
	}

	public void setR21_NO_UAE_CON_SPC_TP(String r21_NO_UAE_CON_SPC_TP) {
		R21_NO_UAE_CON_SPC_TP = r21_NO_UAE_CON_SPC_TP;
	}

	public String getR21_NO_UAE_CON_NLS() {
		return R21_NO_UAE_CON_NLS;
	}

	public void setR21_NO_UAE_CON_NLS(String r21_NO_UAE_CON_NLS) {
		R21_NO_UAE_CON_NLS = r21_NO_UAE_CON_NLS;
	}

	public String getR21_VAL_LOS_AED() {
		return R21_VAL_LOS_AED;
	}

	public void setR21_VAL_LOS_AED(String r21_VAL_LOS_AED) {
		R21_VAL_LOS_AED = r21_VAL_LOS_AED;
	}

	public String getR21_NO_CON_ONB_90() {
		return R21_NO_CON_ONB_90;
	}

	public void setR21_NO_CON_ONB_90(String r21_NO_CON_ONB_90) {
		R21_NO_CON_ONB_90 = r21_NO_CON_ONB_90;
	}

	public String getR21_NO_CON_BAL_PAY() {
		return R21_NO_CON_BAL_PAY;
	}

	public void setR21_NO_CON_BAL_PAY(String r21_NO_CON_BAL_PAY) {
		R21_NO_CON_BAL_PAY = r21_NO_CON_BAL_PAY;
	}

	public String getR21_NO_CON_BAL_SPC_TP() {
		return R21_NO_CON_BAL_SPC_TP;
	}

	public void setR21_NO_CON_BAL_SPC_TP(String r21_NO_CON_BAL_SPC_TP) {
		R21_NO_CON_BAL_SPC_TP = r21_NO_CON_BAL_SPC_TP;
	}

	public String getR21_NO_CON_DEBT() {
		return R21_NO_CON_DEBT;
	}

	public void setR21_NO_CON_DEBT(String r21_NO_CON_DEBT) {
		R21_NO_CON_DEBT = r21_NO_CON_DEBT;
	}

	public String getR21_NO_CON_ONB_REF() {
		return R21_NO_CON_ONB_REF;
	}

	public void setR21_NO_CON_ONB_REF(String r21_NO_CON_ONB_REF) {
		R21_NO_CON_ONB_REF = r21_NO_CON_ONB_REF;
	}

	public String getR21_NO_CON_ONB_AGE() {
		return R21_NO_CON_ONB_AGE;
	}

	public void setR21_NO_CON_ONB_AGE(String r21_NO_CON_ONB_AGE) {
		R21_NO_CON_ONB_AGE = r21_NO_CON_ONB_AGE;
	}

	public String getR21_NO_CON_AFF_UNAU() {
		return R21_NO_CON_AFF_UNAU;
	}

	public void setR21_NO_CON_AFF_UNAU(String r21_NO_CON_AFF_UNAU) {
		R21_NO_CON_AFF_UNAU = r21_NO_CON_AFF_UNAU;
	}

	public String getR21_NO_OF_ACCS_POD() {
		return R21_NO_OF_ACCS_POD;
	}

	public void setR21_NO_OF_ACCS_POD(String r21_NO_OF_ACCS_POD) {
		R21_NO_OF_ACCS_POD = r21_NO_OF_ACCS_POD;
	}

	public String getR21_NO_DEL_CON() {
		return R21_NO_DEL_CON;
	}

	public void setR21_NO_DEL_CON(String r21_NO_DEL_CON) {
		R21_NO_DEL_CON = r21_NO_DEL_CON;
	}

	public String getR21_NO_INS_FUN_LFI() {
		return R21_NO_INS_FUN_LFI;
	}

	public void setR21_NO_INS_FUN_LFI(String r21_NO_INS_FUN_LFI) {
		R21_NO_INS_FUN_LFI = r21_NO_INS_FUN_LFI;
	}

	public String getR21_NO_CON_COL_FIN() {
		return R21_NO_CON_COL_FIN;
	}

	public void setR21_NO_CON_COL_FIN(String r21_NO_CON_COL_FIN) {
		R21_NO_CON_COL_FIN = r21_NO_CON_COL_FIN;
	}

	public String getR21_TOT_NO_NEW_FIN() {
		return R21_TOT_NO_NEW_FIN;
	}

	public void setR21_TOT_NO_NEW_FIN(String r21_TOT_NO_NEW_FIN) {
		R21_TOT_NO_NEW_FIN = r21_TOT_NO_NEW_FIN;
	}

	public String getR21_TOT_NO_NEW_NOSGN() {
		return R21_TOT_NO_NEW_NOSGN;
	}

	public void setR21_TOT_NO_NEW_NOSGN(String r21_TOT_NO_NEW_NOSGN) {
		R21_TOT_NO_NEW_NOSGN = r21_TOT_NO_NEW_NOSGN;
	}

	public String getR21_NO_CON_START() {
		return R21_NO_CON_START;
	}

	public void setR21_NO_CON_START(String r21_NO_CON_START) {
		R21_NO_CON_START = r21_NO_CON_START;
	}

	public String getR21_NO_NEW_CON_ONBO() {
		return R21_NO_NEW_CON_ONBO;
	}

	public void setR21_NO_NEW_CON_ONBO(String r21_NO_NEW_CON_ONBO) {
		R21_NO_NEW_CON_ONBO = r21_NO_NEW_CON_ONBO;
	}

	public String getR21_NO_CON_DEBT_COUN() {
		return R21_NO_CON_DEBT_COUN;
	}

	public void setR21_NO_CON_DEBT_COUN(String r21_NO_CON_DEBT_COUN) {
		R21_NO_CON_DEBT_COUN = r21_NO_CON_DEBT_COUN;
	}

	public String getR21_NO_CON_DEL_NPA() {
		return R21_NO_CON_DEL_NPA;
	}

	public void setR21_NO_CON_DEL_NPA(String r21_NO_CON_DEL_NPA) {
		R21_NO_CON_DEL_NPA = r21_NO_CON_DEL_NPA;
	}

	public String getR21_NO_CON_GOV_50() {
		return R21_NO_CON_GOV_50;
	}

	public void setR21_NO_CON_GOV_50(String r21_NO_CON_GOV_50) {
		R21_NO_CON_GOV_50 = r21_NO_CON_GOV_50;
	}

	public String getR21_NO_SME_SOLE() {
		return R21_NO_SME_SOLE;
	}

	public void setR21_NO_SME_SOLE(String r21_NO_SME_SOLE) {
		R21_NO_SME_SOLE = r21_NO_SME_SOLE;
	}

	public String getR21_NO_CON_TAG_VUL() {
		return R21_NO_CON_TAG_VUL;
	}

	public void setR21_NO_CON_TAG_VUL(String r21_NO_CON_TAG_VUL) {
		R21_NO_CON_TAG_VUL = r21_NO_CON_TAG_VUL;
	}

	public String getR21_NO_NEW_CON_ONB_GNP() {
		return R21_NO_NEW_CON_ONB_GNP;
	}

	public void setR21_NO_NEW_CON_ONB_GNP(String r21_NO_NEW_CON_ONB_GNP) {
		R21_NO_NEW_CON_ONB_GNP = r21_NO_NEW_CON_ONB_GNP;
	}

	public String getR21_NO_CON_END() {
		return R21_NO_CON_END;
	}

	public void setR21_NO_CON_END(String r21_NO_CON_END) {
		R21_NO_CON_END = r21_NO_CON_END;
	}

	public String getR22_BANK() {
		return R22_BANK;
	}

	public void setR22_BANK(String r22_BANK) {
		R22_BANK = r22_BANK;
	}

	public String getR22_PRODUCT() {
		return R22_PRODUCT;
	}

	public void setR22_PRODUCT(String r22_PRODUCT) {
		R22_PRODUCT = r22_PRODUCT;
	}

	public String getR22_NO_WO_SD() {
		return R22_NO_WO_SD;
	}

	public void setR22_NO_WO_SD(String r22_NO_WO_SD) {
		R22_NO_WO_SD = r22_NO_WO_SD;
	}

	public String getR22_NO_CON_POD_SD() {
		return R22_NO_CON_POD_SD;
	}

	public void setR22_NO_CON_POD_SD(String r22_NO_CON_POD_SD) {
		R22_NO_CON_POD_SD = r22_NO_CON_POD_SD;
	}

	public String getR22_NO_CON_UNAU_SP_TP() {
		return R22_NO_CON_UNAU_SP_TP;
	}

	public void setR22_NO_CON_UNAU_SP_TP(String r22_NO_CON_UNAU_SP_TP) {
		R22_NO_CON_UNAU_SP_TP = r22_NO_CON_UNAU_SP_TP;
	}

	public String getR22_NO_CON_45_50() {
		return R22_NO_CON_45_50;
	}

	public void setR22_NO_CON_45_50(String r22_NO_CON_45_50) {
		R22_NO_CON_45_50 = r22_NO_CON_45_50;
	}

	public String getR22_NO_CON_50() {
		return R22_NO_CON_50;
	}

	public void setR22_NO_CON_50(String r22_NO_CON_50) {
		R22_NO_CON_50 = r22_NO_CON_50;
	}

	public String getR22_NO_OF_LES_50() {
		return R22_NO_OF_LES_50;
	}

	public void setR22_NO_OF_LES_50(String r22_NO_OF_LES_50) {
		R22_NO_OF_LES_50 = r22_NO_OF_LES_50;
	}

	public String getR22_NO_OF_BNK_18() {
		return R22_NO_OF_BNK_18;
	}

	public void setR22_NO_OF_BNK_18(String r22_NO_OF_BNK_18) {
		R22_NO_OF_BNK_18 = r22_NO_OF_BNK_18;
	}

	public String getR22_NO_OF_BNK_18_25() {
		return R22_NO_OF_BNK_18_25;
	}

	public void setR22_NO_OF_BNK_18_25(String r22_NO_OF_BNK_18_25) {
		R22_NO_OF_BNK_18_25 = r22_NO_OF_BNK_18_25;
	}

	public String getR22_NO_OF_BNK_26_35() {
		return R22_NO_OF_BNK_26_35;
	}

	public void setR22_NO_OF_BNK_26_35(String r22_NO_OF_BNK_26_35) {
		R22_NO_OF_BNK_26_35 = r22_NO_OF_BNK_26_35;
	}

	public String getR22_NO_OF_BNK_36_50() {
		return R22_NO_OF_BNK_36_50;
	}

	public void setR22_NO_OF_BNK_36_50(String r22_NO_OF_BNK_36_50) {
		R22_NO_OF_BNK_36_50 = r22_NO_OF_BNK_36_50;
	}

	public String getR22_NO_CON_BNK_50() {
		return R22_NO_CON_BNK_50;
	}

	public void setR22_NO_CON_BNK_50(String r22_NO_CON_BNK_50) {
		R22_NO_CON_BNK_50 = r22_NO_CON_BNK_50;
	}

	public String getR22_NO_CON_SAL_SPD() {
		return R22_NO_CON_SAL_SPD;
	}

	public void setR22_NO_CON_SAL_SPD(String r22_NO_CON_SAL_SPD) {
		R22_NO_CON_SAL_SPD = r22_NO_CON_SAL_SPD;
	}

	public String getR22_NO_CON_BUS_SPD() {
		return R22_NO_CON_BUS_SPD;
	}

	public void setR22_NO_CON_BUS_SPD(String r22_NO_CON_BUS_SPD) {
		R22_NO_CON_BUS_SPD = r22_NO_CON_BUS_SPD;
	}

	public String getR22_NO_CON_PRO_SPD() {
		return R22_NO_CON_PRO_SPD;
	}

	public void setR22_NO_CON_PRO_SPD(String r22_NO_CON_PRO_SPD) {
		R22_NO_CON_PRO_SPD = r22_NO_CON_PRO_SPD;
	}

	public String getR22_NO_CON_INC_5K() {
		return R22_NO_CON_INC_5K;
	}

	public void setR22_NO_CON_INC_5K(String r22_NO_CON_INC_5K) {
		R22_NO_CON_INC_5K = r22_NO_CON_INC_5K;
	}

	public String getR22_NO_CON_INC_5K_10K() {
		return R22_NO_CON_INC_5K_10K;
	}

	public void setR22_NO_CON_INC_5K_10K(String r22_NO_CON_INC_5K_10K) {
		R22_NO_CON_INC_5K_10K = r22_NO_CON_INC_5K_10K;
	}

	public String getR22_NO_CON_INC_10K_20K() {
		return R22_NO_CON_INC_10K_20K;
	}

	public void setR22_NO_CON_INC_10K_20K(String r22_NO_CON_INC_10K_20K) {
		R22_NO_CON_INC_10K_20K = r22_NO_CON_INC_10K_20K;
	}

	public String getR22_NO_CON_INC_20K_35K() {
		return R22_NO_CON_INC_20K_35K;
	}

	public void setR22_NO_CON_INC_20K_35K(String r22_NO_CON_INC_20K_35K) {
		R22_NO_CON_INC_20K_35K = r22_NO_CON_INC_20K_35K;
	}

	public String getR22_NO_CON_INC_35K() {
		return R22_NO_CON_INC_35K;
	}

	public void setR22_NO_CON_INC_35K(String r22_NO_CON_INC_35K) {
		R22_NO_CON_INC_35K = r22_NO_CON_INC_35K;
	}

	public String getR22_NO_CON_BEL_SCL() {
		return R22_NO_CON_BEL_SCL;
	}

	public void setR22_NO_CON_BEL_SCL(String r22_NO_CON_BEL_SCL) {
		R22_NO_CON_BEL_SCL = r22_NO_CON_BEL_SCL;
	}

	public String getR22_NO_CON_BAC() {
		return R22_NO_CON_BAC;
	}

	public void setR22_NO_CON_BAC(String r22_NO_CON_BAC) {
		R22_NO_CON_BAC = r22_NO_CON_BAC;
	}

	public String getR22_NO_CON_ABV_MAS() {
		return R22_NO_CON_ABV_MAS;
	}

	public void setR22_NO_CON_ABV_MAS(String r22_NO_CON_ABV_MAS) {
		R22_NO_CON_ABV_MAS = r22_NO_CON_ABV_MAS;
	}

	public String getR22_NO_CON_ABU_KYC() {
		return R22_NO_CON_ABU_KYC;
	}

	public void setR22_NO_CON_ABU_KYC(String r22_NO_CON_ABU_KYC) {
		R22_NO_CON_ABU_KYC = r22_NO_CON_ABU_KYC;
	}

	public String getR22_NO_CON_DUB_KYC() {
		return R22_NO_CON_DUB_KYC;
	}

	public void setR22_NO_CON_DUB_KYC(String r22_NO_CON_DUB_KYC) {
		R22_NO_CON_DUB_KYC = r22_NO_CON_DUB_KYC;
	}

	public String getR22_NO_CON_SHJ_KYC() {
		return R22_NO_CON_SHJ_KYC;
	}

	public void setR22_NO_CON_SHJ_KYC(String r22_NO_CON_SHJ_KYC) {
		R22_NO_CON_SHJ_KYC = r22_NO_CON_SHJ_KYC;
	}

	public String getR22_NO_CON_AJM_KYC() {
		return R22_NO_CON_AJM_KYC;
	}

	public void setR22_NO_CON_AJM_KYC(String r22_NO_CON_AJM_KYC) {
		R22_NO_CON_AJM_KYC = r22_NO_CON_AJM_KYC;
	}

	public String getR22_NO_CON_FUJ_KYC() {
		return R22_NO_CON_FUJ_KYC;
	}

	public void setR22_NO_CON_FUJ_KYC(String r22_NO_CON_FUJ_KYC) {
		R22_NO_CON_FUJ_KYC = r22_NO_CON_FUJ_KYC;
	}

	public String getR22_NO_CON_RAK_KYC() {
		return R22_NO_CON_RAK_KYC;
	}

	public void setR22_NO_CON_RAK_KYC(String r22_NO_CON_RAK_KYC) {
		R22_NO_CON_RAK_KYC = r22_NO_CON_RAK_KYC;
	}

	public String getR22_NO_CON_UAQ_KYC() {
		return R22_NO_CON_UAQ_KYC;
	}

	public void setR22_NO_CON_UAQ_KYC(String r22_NO_CON_UAQ_KYC) {
		R22_NO_CON_UAQ_KYC = r22_NO_CON_UAQ_KYC;
	}

	public String getR22_NO_CON_RET() {
		return R22_NO_CON_RET;
	}

	public void setR22_NO_CON_RET(String r22_NO_CON_RET) {
		R22_NO_CON_RET = r22_NO_CON_RET;
	}

	public String getR22_NO_CON_DBR_LIM() {
		return R22_NO_CON_DBR_LIM;
	}

	public void setR22_NO_CON_DBR_LIM(String r22_NO_CON_DBR_LIM) {
		R22_NO_CON_DBR_LIM = r22_NO_CON_DBR_LIM;
	}

	public String getR22_NO_UAE_CON_SPC_TP() {
		return R22_NO_UAE_CON_SPC_TP;
	}

	public void setR22_NO_UAE_CON_SPC_TP(String r22_NO_UAE_CON_SPC_TP) {
		R22_NO_UAE_CON_SPC_TP = r22_NO_UAE_CON_SPC_TP;
	}

	public String getR22_NO_UAE_CON_NLS() {
		return R22_NO_UAE_CON_NLS;
	}

	public void setR22_NO_UAE_CON_NLS(String r22_NO_UAE_CON_NLS) {
		R22_NO_UAE_CON_NLS = r22_NO_UAE_CON_NLS;
	}

	public String getR22_VAL_LOS_AED() {
		return R22_VAL_LOS_AED;
	}

	public void setR22_VAL_LOS_AED(String r22_VAL_LOS_AED) {
		R22_VAL_LOS_AED = r22_VAL_LOS_AED;
	}

	public String getR22_NO_CON_ONB_90() {
		return R22_NO_CON_ONB_90;
	}

	public void setR22_NO_CON_ONB_90(String r22_NO_CON_ONB_90) {
		R22_NO_CON_ONB_90 = r22_NO_CON_ONB_90;
	}

	public String getR22_NO_CON_BAL_PAY() {
		return R22_NO_CON_BAL_PAY;
	}

	public void setR22_NO_CON_BAL_PAY(String r22_NO_CON_BAL_PAY) {
		R22_NO_CON_BAL_PAY = r22_NO_CON_BAL_PAY;
	}

	public String getR22_NO_CON_BAL_SPC_TP() {
		return R22_NO_CON_BAL_SPC_TP;
	}

	public void setR22_NO_CON_BAL_SPC_TP(String r22_NO_CON_BAL_SPC_TP) {
		R22_NO_CON_BAL_SPC_TP = r22_NO_CON_BAL_SPC_TP;
	}

	public String getR22_NO_CON_DEBT() {
		return R22_NO_CON_DEBT;
	}

	public void setR22_NO_CON_DEBT(String r22_NO_CON_DEBT) {
		R22_NO_CON_DEBT = r22_NO_CON_DEBT;
	}

	public String getR22_NO_CON_ONB_REF() {
		return R22_NO_CON_ONB_REF;
	}

	public void setR22_NO_CON_ONB_REF(String r22_NO_CON_ONB_REF) {
		R22_NO_CON_ONB_REF = r22_NO_CON_ONB_REF;
	}

	public String getR22_NO_CON_ONB_AGE() {
		return R22_NO_CON_ONB_AGE;
	}

	public void setR22_NO_CON_ONB_AGE(String r22_NO_CON_ONB_AGE) {
		R22_NO_CON_ONB_AGE = r22_NO_CON_ONB_AGE;
	}

	public String getR22_NO_CON_AFF_UNAU() {
		return R22_NO_CON_AFF_UNAU;
	}

	public void setR22_NO_CON_AFF_UNAU(String r22_NO_CON_AFF_UNAU) {
		R22_NO_CON_AFF_UNAU = r22_NO_CON_AFF_UNAU;
	}

	public String getR22_NO_OF_ACCS_POD() {
		return R22_NO_OF_ACCS_POD;
	}

	public void setR22_NO_OF_ACCS_POD(String r22_NO_OF_ACCS_POD) {
		R22_NO_OF_ACCS_POD = r22_NO_OF_ACCS_POD;
	}

	public String getR22_NO_DEL_CON() {
		return R22_NO_DEL_CON;
	}

	public void setR22_NO_DEL_CON(String r22_NO_DEL_CON) {
		R22_NO_DEL_CON = r22_NO_DEL_CON;
	}

	public String getR22_NO_INS_FUN_LFI() {
		return R22_NO_INS_FUN_LFI;
	}

	public void setR22_NO_INS_FUN_LFI(String r22_NO_INS_FUN_LFI) {
		R22_NO_INS_FUN_LFI = r22_NO_INS_FUN_LFI;
	}

	public String getR22_NO_CON_COL_FIN() {
		return R22_NO_CON_COL_FIN;
	}

	public void setR22_NO_CON_COL_FIN(String r22_NO_CON_COL_FIN) {
		R22_NO_CON_COL_FIN = r22_NO_CON_COL_FIN;
	}

	public String getR22_TOT_NO_NEW_FIN() {
		return R22_TOT_NO_NEW_FIN;
	}

	public void setR22_TOT_NO_NEW_FIN(String r22_TOT_NO_NEW_FIN) {
		R22_TOT_NO_NEW_FIN = r22_TOT_NO_NEW_FIN;
	}

	public String getR22_TOT_NO_NEW_NOSGN() {
		return R22_TOT_NO_NEW_NOSGN;
	}

	public void setR22_TOT_NO_NEW_NOSGN(String r22_TOT_NO_NEW_NOSGN) {
		R22_TOT_NO_NEW_NOSGN = r22_TOT_NO_NEW_NOSGN;
	}

	public String getR22_NO_CON_START() {
		return R22_NO_CON_START;
	}

	public void setR22_NO_CON_START(String r22_NO_CON_START) {
		R22_NO_CON_START = r22_NO_CON_START;
	}

	public String getR22_NO_NEW_CON_ONBO() {
		return R22_NO_NEW_CON_ONBO;
	}

	public void setR22_NO_NEW_CON_ONBO(String r22_NO_NEW_CON_ONBO) {
		R22_NO_NEW_CON_ONBO = r22_NO_NEW_CON_ONBO;
	}

	public String getR22_NO_CON_DEBT_COUN() {
		return R22_NO_CON_DEBT_COUN;
	}

	public void setR22_NO_CON_DEBT_COUN(String r22_NO_CON_DEBT_COUN) {
		R22_NO_CON_DEBT_COUN = r22_NO_CON_DEBT_COUN;
	}

	public String getR22_NO_CON_DEL_NPA() {
		return R22_NO_CON_DEL_NPA;
	}

	public void setR22_NO_CON_DEL_NPA(String r22_NO_CON_DEL_NPA) {
		R22_NO_CON_DEL_NPA = r22_NO_CON_DEL_NPA;
	}

	public String getR22_NO_CON_GOV_50() {
		return R22_NO_CON_GOV_50;
	}

	public void setR22_NO_CON_GOV_50(String r22_NO_CON_GOV_50) {
		R22_NO_CON_GOV_50 = r22_NO_CON_GOV_50;
	}

	public String getR22_NO_SME_SOLE() {
		return R22_NO_SME_SOLE;
	}

	public void setR22_NO_SME_SOLE(String r22_NO_SME_SOLE) {
		R22_NO_SME_SOLE = r22_NO_SME_SOLE;
	}

	public String getR22_NO_CON_TAG_VUL() {
		return R22_NO_CON_TAG_VUL;
	}

	public void setR22_NO_CON_TAG_VUL(String r22_NO_CON_TAG_VUL) {
		R22_NO_CON_TAG_VUL = r22_NO_CON_TAG_VUL;
	}

	public String getR22_NO_NEW_CON_ONB_GNP() {
		return R22_NO_NEW_CON_ONB_GNP;
	}

	public void setR22_NO_NEW_CON_ONB_GNP(String r22_NO_NEW_CON_ONB_GNP) {
		R22_NO_NEW_CON_ONB_GNP = r22_NO_NEW_CON_ONB_GNP;
	}

	public String getR22_NO_CON_END() {
		return R22_NO_CON_END;
	}

	public void setR22_NO_CON_END(String r22_NO_CON_END) {
		R22_NO_CON_END = r22_NO_CON_END;
	}

	public String getR23_BANK() {
		return R23_BANK;
	}

	public void setR23_BANK(String r23_BANK) {
		R23_BANK = r23_BANK;
	}

	public String getR23_PRODUCT() {
		return R23_PRODUCT;
	}

	public void setR23_PRODUCT(String r23_PRODUCT) {
		R23_PRODUCT = r23_PRODUCT;
	}

	public String getR23_NO_WO_SD() {
		return R23_NO_WO_SD;
	}

	public void setR23_NO_WO_SD(String r23_NO_WO_SD) {
		R23_NO_WO_SD = r23_NO_WO_SD;
	}

	public String getR23_NO_CON_POD_SD() {
		return R23_NO_CON_POD_SD;
	}

	public void setR23_NO_CON_POD_SD(String r23_NO_CON_POD_SD) {
		R23_NO_CON_POD_SD = r23_NO_CON_POD_SD;
	}

	public String getR23_NO_CON_UNAU_SP_TP() {
		return R23_NO_CON_UNAU_SP_TP;
	}

	public void setR23_NO_CON_UNAU_SP_TP(String r23_NO_CON_UNAU_SP_TP) {
		R23_NO_CON_UNAU_SP_TP = r23_NO_CON_UNAU_SP_TP;
	}

	public String getR23_NO_CON_45_50() {
		return R23_NO_CON_45_50;
	}

	public void setR23_NO_CON_45_50(String r23_NO_CON_45_50) {
		R23_NO_CON_45_50 = r23_NO_CON_45_50;
	}

	public String getR23_NO_CON_50() {
		return R23_NO_CON_50;
	}

	public void setR23_NO_CON_50(String r23_NO_CON_50) {
		R23_NO_CON_50 = r23_NO_CON_50;
	}

	public String getR23_NO_OF_LES_50() {
		return R23_NO_OF_LES_50;
	}

	public void setR23_NO_OF_LES_50(String r23_NO_OF_LES_50) {
		R23_NO_OF_LES_50 = r23_NO_OF_LES_50;
	}

	public String getR23_NO_OF_BNK_18() {
		return R23_NO_OF_BNK_18;
	}

	public void setR23_NO_OF_BNK_18(String r23_NO_OF_BNK_18) {
		R23_NO_OF_BNK_18 = r23_NO_OF_BNK_18;
	}

	public String getR23_NO_OF_BNK_18_25() {
		return R23_NO_OF_BNK_18_25;
	}

	public void setR23_NO_OF_BNK_18_25(String r23_NO_OF_BNK_18_25) {
		R23_NO_OF_BNK_18_25 = r23_NO_OF_BNK_18_25;
	}

	public String getR23_NO_OF_BNK_26_35() {
		return R23_NO_OF_BNK_26_35;
	}

	public void setR23_NO_OF_BNK_26_35(String r23_NO_OF_BNK_26_35) {
		R23_NO_OF_BNK_26_35 = r23_NO_OF_BNK_26_35;
	}

	public String getR23_NO_OF_BNK_36_50() {
		return R23_NO_OF_BNK_36_50;
	}

	public void setR23_NO_OF_BNK_36_50(String r23_NO_OF_BNK_36_50) {
		R23_NO_OF_BNK_36_50 = r23_NO_OF_BNK_36_50;
	}

	public String getR23_NO_CON_BNK_50() {
		return R23_NO_CON_BNK_50;
	}

	public void setR23_NO_CON_BNK_50(String r23_NO_CON_BNK_50) {
		R23_NO_CON_BNK_50 = r23_NO_CON_BNK_50;
	}

	public String getR23_NO_CON_SAL_SPD() {
		return R23_NO_CON_SAL_SPD;
	}

	public void setR23_NO_CON_SAL_SPD(String r23_NO_CON_SAL_SPD) {
		R23_NO_CON_SAL_SPD = r23_NO_CON_SAL_SPD;
	}

	public String getR23_NO_CON_BUS_SPD() {
		return R23_NO_CON_BUS_SPD;
	}

	public void setR23_NO_CON_BUS_SPD(String r23_NO_CON_BUS_SPD) {
		R23_NO_CON_BUS_SPD = r23_NO_CON_BUS_SPD;
	}

	public String getR23_NO_CON_PRO_SPD() {
		return R23_NO_CON_PRO_SPD;
	}

	public void setR23_NO_CON_PRO_SPD(String r23_NO_CON_PRO_SPD) {
		R23_NO_CON_PRO_SPD = r23_NO_CON_PRO_SPD;
	}

	public String getR23_NO_CON_INC_5K() {
		return R23_NO_CON_INC_5K;
	}

	public void setR23_NO_CON_INC_5K(String r23_NO_CON_INC_5K) {
		R23_NO_CON_INC_5K = r23_NO_CON_INC_5K;
	}

	public String getR23_NO_CON_INC_5K_10K() {
		return R23_NO_CON_INC_5K_10K;
	}

	public void setR23_NO_CON_INC_5K_10K(String r23_NO_CON_INC_5K_10K) {
		R23_NO_CON_INC_5K_10K = r23_NO_CON_INC_5K_10K;
	}

	public String getR23_NO_CON_INC_10K_20K() {
		return R23_NO_CON_INC_10K_20K;
	}

	public void setR23_NO_CON_INC_10K_20K(String r23_NO_CON_INC_10K_20K) {
		R23_NO_CON_INC_10K_20K = r23_NO_CON_INC_10K_20K;
	}

	public String getR23_NO_CON_INC_20K_35K() {
		return R23_NO_CON_INC_20K_35K;
	}

	public void setR23_NO_CON_INC_20K_35K(String r23_NO_CON_INC_20K_35K) {
		R23_NO_CON_INC_20K_35K = r23_NO_CON_INC_20K_35K;
	}

	public String getR23_NO_CON_INC_35K() {
		return R23_NO_CON_INC_35K;
	}

	public void setR23_NO_CON_INC_35K(String r23_NO_CON_INC_35K) {
		R23_NO_CON_INC_35K = r23_NO_CON_INC_35K;
	}

	public String getR23_NO_CON_BEL_SCL() {
		return R23_NO_CON_BEL_SCL;
	}

	public void setR23_NO_CON_BEL_SCL(String r23_NO_CON_BEL_SCL) {
		R23_NO_CON_BEL_SCL = r23_NO_CON_BEL_SCL;
	}

	public String getR23_NO_CON_BAC() {
		return R23_NO_CON_BAC;
	}

	public void setR23_NO_CON_BAC(String r23_NO_CON_BAC) {
		R23_NO_CON_BAC = r23_NO_CON_BAC;
	}

	public String getR23_NO_CON_ABV_MAS() {
		return R23_NO_CON_ABV_MAS;
	}

	public void setR23_NO_CON_ABV_MAS(String r23_NO_CON_ABV_MAS) {
		R23_NO_CON_ABV_MAS = r23_NO_CON_ABV_MAS;
	}

	public String getR23_NO_CON_ABU_KYC() {
		return R23_NO_CON_ABU_KYC;
	}

	public void setR23_NO_CON_ABU_KYC(String r23_NO_CON_ABU_KYC) {
		R23_NO_CON_ABU_KYC = r23_NO_CON_ABU_KYC;
	}

	public String getR23_NO_CON_DUB_KYC() {
		return R23_NO_CON_DUB_KYC;
	}

	public void setR23_NO_CON_DUB_KYC(String r23_NO_CON_DUB_KYC) {
		R23_NO_CON_DUB_KYC = r23_NO_CON_DUB_KYC;
	}

	public String getR23_NO_CON_SHJ_KYC() {
		return R23_NO_CON_SHJ_KYC;
	}

	public void setR23_NO_CON_SHJ_KYC(String r23_NO_CON_SHJ_KYC) {
		R23_NO_CON_SHJ_KYC = r23_NO_CON_SHJ_KYC;
	}

	public String getR23_NO_CON_AJM_KYC() {
		return R23_NO_CON_AJM_KYC;
	}

	public void setR23_NO_CON_AJM_KYC(String r23_NO_CON_AJM_KYC) {
		R23_NO_CON_AJM_KYC = r23_NO_CON_AJM_KYC;
	}

	public String getR23_NO_CON_FUJ_KYC() {
		return R23_NO_CON_FUJ_KYC;
	}

	public void setR23_NO_CON_FUJ_KYC(String r23_NO_CON_FUJ_KYC) {
		R23_NO_CON_FUJ_KYC = r23_NO_CON_FUJ_KYC;
	}

	public String getR23_NO_CON_RAK_KYC() {
		return R23_NO_CON_RAK_KYC;
	}

	public void setR23_NO_CON_RAK_KYC(String r23_NO_CON_RAK_KYC) {
		R23_NO_CON_RAK_KYC = r23_NO_CON_RAK_KYC;
	}

	public String getR23_NO_CON_UAQ_KYC() {
		return R23_NO_CON_UAQ_KYC;
	}

	public void setR23_NO_CON_UAQ_KYC(String r23_NO_CON_UAQ_KYC) {
		R23_NO_CON_UAQ_KYC = r23_NO_CON_UAQ_KYC;
	}

	public String getR23_NO_CON_RET() {
		return R23_NO_CON_RET;
	}

	public void setR23_NO_CON_RET(String r23_NO_CON_RET) {
		R23_NO_CON_RET = r23_NO_CON_RET;
	}

	public String getR23_NO_CON_DBR_LIM() {
		return R23_NO_CON_DBR_LIM;
	}

	public void setR23_NO_CON_DBR_LIM(String r23_NO_CON_DBR_LIM) {
		R23_NO_CON_DBR_LIM = r23_NO_CON_DBR_LIM;
	}

	public String getR23_NO_UAE_CON_SPC_TP() {
		return R23_NO_UAE_CON_SPC_TP;
	}

	public void setR23_NO_UAE_CON_SPC_TP(String r23_NO_UAE_CON_SPC_TP) {
		R23_NO_UAE_CON_SPC_TP = r23_NO_UAE_CON_SPC_TP;
	}

	public String getR23_NO_UAE_CON_NLS() {
		return R23_NO_UAE_CON_NLS;
	}

	public void setR23_NO_UAE_CON_NLS(String r23_NO_UAE_CON_NLS) {
		R23_NO_UAE_CON_NLS = r23_NO_UAE_CON_NLS;
	}

	public String getR23_VAL_LOS_AED() {
		return R23_VAL_LOS_AED;
	}

	public void setR23_VAL_LOS_AED(String r23_VAL_LOS_AED) {
		R23_VAL_LOS_AED = r23_VAL_LOS_AED;
	}

	public String getR23_NO_CON_ONB_90() {
		return R23_NO_CON_ONB_90;
	}

	public void setR23_NO_CON_ONB_90(String r23_NO_CON_ONB_90) {
		R23_NO_CON_ONB_90 = r23_NO_CON_ONB_90;
	}

	public String getR23_NO_CON_BAL_PAY() {
		return R23_NO_CON_BAL_PAY;
	}

	public void setR23_NO_CON_BAL_PAY(String r23_NO_CON_BAL_PAY) {
		R23_NO_CON_BAL_PAY = r23_NO_CON_BAL_PAY;
	}

	public String getR23_NO_CON_BAL_SPC_TP() {
		return R23_NO_CON_BAL_SPC_TP;
	}

	public void setR23_NO_CON_BAL_SPC_TP(String r23_NO_CON_BAL_SPC_TP) {
		R23_NO_CON_BAL_SPC_TP = r23_NO_CON_BAL_SPC_TP;
	}

	public String getR23_NO_CON_DEBT() {
		return R23_NO_CON_DEBT;
	}

	public void setR23_NO_CON_DEBT(String r23_NO_CON_DEBT) {
		R23_NO_CON_DEBT = r23_NO_CON_DEBT;
	}

	public String getR23_NO_CON_ONB_REF() {
		return R23_NO_CON_ONB_REF;
	}

	public void setR23_NO_CON_ONB_REF(String r23_NO_CON_ONB_REF) {
		R23_NO_CON_ONB_REF = r23_NO_CON_ONB_REF;
	}

	public String getR23_NO_CON_ONB_AGE() {
		return R23_NO_CON_ONB_AGE;
	}

	public void setR23_NO_CON_ONB_AGE(String r23_NO_CON_ONB_AGE) {
		R23_NO_CON_ONB_AGE = r23_NO_CON_ONB_AGE;
	}

	public String getR23_NO_CON_AFF_UNAU() {
		return R23_NO_CON_AFF_UNAU;
	}

	public void setR23_NO_CON_AFF_UNAU(String r23_NO_CON_AFF_UNAU) {
		R23_NO_CON_AFF_UNAU = r23_NO_CON_AFF_UNAU;
	}

	public String getR23_NO_OF_ACCS_POD() {
		return R23_NO_OF_ACCS_POD;
	}

	public void setR23_NO_OF_ACCS_POD(String r23_NO_OF_ACCS_POD) {
		R23_NO_OF_ACCS_POD = r23_NO_OF_ACCS_POD;
	}

	public String getR23_NO_DEL_CON() {
		return R23_NO_DEL_CON;
	}

	public void setR23_NO_DEL_CON(String r23_NO_DEL_CON) {
		R23_NO_DEL_CON = r23_NO_DEL_CON;
	}

	public String getR23_NO_INS_FUN_LFI() {
		return R23_NO_INS_FUN_LFI;
	}

	public void setR23_NO_INS_FUN_LFI(String r23_NO_INS_FUN_LFI) {
		R23_NO_INS_FUN_LFI = r23_NO_INS_FUN_LFI;
	}

	public String getR23_NO_CON_COL_FIN() {
		return R23_NO_CON_COL_FIN;
	}

	public void setR23_NO_CON_COL_FIN(String r23_NO_CON_COL_FIN) {
		R23_NO_CON_COL_FIN = r23_NO_CON_COL_FIN;
	}

	public String getR23_TOT_NO_NEW_FIN() {
		return R23_TOT_NO_NEW_FIN;
	}

	public void setR23_TOT_NO_NEW_FIN(String r23_TOT_NO_NEW_FIN) {
		R23_TOT_NO_NEW_FIN = r23_TOT_NO_NEW_FIN;
	}

	public String getR23_TOT_NO_NEW_NOSGN() {
		return R23_TOT_NO_NEW_NOSGN;
	}

	public void setR23_TOT_NO_NEW_NOSGN(String r23_TOT_NO_NEW_NOSGN) {
		R23_TOT_NO_NEW_NOSGN = r23_TOT_NO_NEW_NOSGN;
	}

	public String getR23_NO_CON_START() {
		return R23_NO_CON_START;
	}

	public void setR23_NO_CON_START(String r23_NO_CON_START) {
		R23_NO_CON_START = r23_NO_CON_START;
	}

	public String getR23_NO_NEW_CON_ONBO() {
		return R23_NO_NEW_CON_ONBO;
	}

	public void setR23_NO_NEW_CON_ONBO(String r23_NO_NEW_CON_ONBO) {
		R23_NO_NEW_CON_ONBO = r23_NO_NEW_CON_ONBO;
	}

	public String getR23_NO_CON_DEBT_COUN() {
		return R23_NO_CON_DEBT_COUN;
	}

	public void setR23_NO_CON_DEBT_COUN(String r23_NO_CON_DEBT_COUN) {
		R23_NO_CON_DEBT_COUN = r23_NO_CON_DEBT_COUN;
	}

	public String getR23_NO_CON_DEL_NPA() {
		return R23_NO_CON_DEL_NPA;
	}

	public void setR23_NO_CON_DEL_NPA(String r23_NO_CON_DEL_NPA) {
		R23_NO_CON_DEL_NPA = r23_NO_CON_DEL_NPA;
	}

	public String getR23_NO_CON_GOV_50() {
		return R23_NO_CON_GOV_50;
	}

	public void setR23_NO_CON_GOV_50(String r23_NO_CON_GOV_50) {
		R23_NO_CON_GOV_50 = r23_NO_CON_GOV_50;
	}

	public String getR23_NO_SME_SOLE() {
		return R23_NO_SME_SOLE;
	}

	public void setR23_NO_SME_SOLE(String r23_NO_SME_SOLE) {
		R23_NO_SME_SOLE = r23_NO_SME_SOLE;
	}

	public String getR23_NO_CON_TAG_VUL() {
		return R23_NO_CON_TAG_VUL;
	}

	public void setR23_NO_CON_TAG_VUL(String r23_NO_CON_TAG_VUL) {
		R23_NO_CON_TAG_VUL = r23_NO_CON_TAG_VUL;
	}

	public String getR23_NO_NEW_CON_ONB_GNP() {
		return R23_NO_NEW_CON_ONB_GNP;
	}

	public void setR23_NO_NEW_CON_ONB_GNP(String r23_NO_NEW_CON_ONB_GNP) {
		R23_NO_NEW_CON_ONB_GNP = r23_NO_NEW_CON_ONB_GNP;
	}

	public String getR23_NO_CON_END() {
		return R23_NO_CON_END;
	}

	public void setR23_NO_CON_END(String r23_NO_CON_END) {
		R23_NO_CON_END = r23_NO_CON_END;
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
