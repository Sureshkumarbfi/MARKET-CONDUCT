package com.bornfire.xbrl.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@IdClass(MCReportId.class)
@Table(name = "RT_MC_TABLE2_1")
public class RT_MC_TABLE2_1_ENTITY {

	public String R6_BANK;
	public String R6_PRODUCT;
	public String R6_NO_WO_SD;
	public String R6_NO_CON_POD_SD;
	public String R6_NO_CON_UNAU_SP_TP;
	public String R6_NO_CON_45_50;
	public String R6_NO_CON_50;
	public String R6_NO_OF_LES_50;
	public String R6_NO_OF_BNK_18;
	public String R6_NO_OF_BNK_18_25;
	public String R6_NO_OF_BNK_26_35;
	public String R6_NO_OF_BNK_36_50;
	public String R6_NO_CON_BNK_50;
	public String R6_NO_CON_SAL_SPD;
	public String R6_NO_CON_BUS_SPD;
	public String R6_NO_CON_PRO_SPD;
	public String R6_NO_CON_INC_5K;
	public String R6_NO_CON_INC_5K_10K;
	public String R6_NO_CON_INC_10K_20K;
	public String R6_NO_CON_INC_20K_35K;
	public String R6_NO_CON_INC_35K;
	public String R6_NO_CON_BEL_SCL;
	public String R6_NO_CON_BAC;
	public String R6_NO_CON_ABV_MAS;
	public String R6_NO_CON_ABU_KYC;
	public String R6_NO_CON_DUB_KYC;
	public String R6_NO_CON_SHJ_KYC;
	public String R6_NO_CON_AJM_KYC;
	public String R6_NO_CON_FUJ_KYC;
	public String R6_NO_CON_RAK_KYC;
	public String R6_NO_CON_UAQ_KYC;
	public String R6_NO_CON_RET;
	public String R6_NO_CON_DBR_LIM;
	public String R6_NO_UAE_CON_SPC_TP;
	public String R6_NO_UAE_CON_NLS;
	public String R6_VAL_LOS_AED;
	public String R6_NO_CON_ONB_90;
	public String R6_NO_CON_BAL_PAY;
	public String R6_NO_CON_BAL_SPC_TP;
	public String R6_NO_CON_DEBT;
	public String R6_NO_CON_ONB_REF;
	public String R6_NO_CON_ONB_AGE;
	public String R6_NO_CON_AFF_UNAU;
	public String R6_NO_OF_ACCS_POD;
	public String R6_NO_DEL_CON;
	public String R6_NO_INS_FUN_LFI;
	public String R6_NO_CON_COL_FIN;
	public String R6_TOT_NO_NEW_FIN;
	public String R6_TOT_NO_NEW_NOSGN;
	public String R6_NO_CON_START;
	public String R6_NO_NEW_CON_ONBO;
	public String R6_NO_CON_DEBT_COUN;
	public String R6_NO_CON_DEL_NPA;
	public String R6_NO_CON_GOV_50;
	public String R6_NO_SME_SOLE;
	public String R6_NO_CON_TAG_VUL;
	public String R6_NO_NEW_CON_ONB_GNP;
	public String R6_NO_CON_END;
	public String R7_BANK;
	public String R7_PRODUCT;
	public String R7_NO_WO_SD;
	public String R7_NO_CON_POD_SD;
	public String R7_NO_CON_UNAU_SP_TP;
	public String R7_NO_CON_45_50;
	public String R7_NO_CON_50;
	public String R7_NO_OF_LES_50;
	public String R7_NO_OF_BNK_18;
	public String R7_NO_OF_BNK_18_25;
	public String R7_NO_OF_BNK_26_35;
	public String R7_NO_OF_BNK_36_50;
	public String R7_NO_CON_BNK_50;
	public String R7_NO_CON_SAL_SPD;
	public String R7_NO_CON_BUS_SPD;
	public String R7_NO_CON_PRO_SPD;
	public String R7_NO_CON_INC_5K;
	public String R7_NO_CON_INC_5K_10K;
	public String R7_NO_CON_INC_10K_20K;
	public String R7_NO_CON_INC_20K_35K;
	public String R7_NO_CON_INC_35K;
	public String R7_NO_CON_BEL_SCL;
	public String R7_NO_CON_BAC;
	public String R7_NO_CON_ABV_MAS;
	public String R7_NO_CON_ABU_KYC;
	public String R7_NO_CON_DUB_KYC;
	public String R7_NO_CON_SHJ_KYC;
	public String R7_NO_CON_AJM_KYC;
	public String R7_NO_CON_FUJ_KYC;
	public String R7_NO_CON_RAK_KYC;
	public String R7_NO_CON_UAQ_KYC;
	public String R7_NO_CON_RET;
	public String R7_NO_CON_DBR_LIM;
	public String R7_NO_UAE_CON_SPC_TP;
	public String R7_NO_UAE_CON_NLS;
	public String R7_VAL_LOS_AED;
	public String R7_NO_CON_ONB_90;
	public String R7_NO_CON_BAL_PAY;
	public String R7_NO_CON_BAL_SPC_TP;
	public String R7_NO_CON_DEBT;
	public String R7_NO_CON_ONB_REF;
	public String R7_NO_CON_ONB_AGE;
	public String R7_NO_CON_AFF_UNAU;
	public String R7_NO_OF_ACCS_POD;
	public String R7_NO_DEL_CON;
	public String R7_NO_INS_FUN_LFI;
	public String R7_NO_CON_COL_FIN;
	public String R7_TOT_NO_NEW_FIN;
	public String R7_TOT_NO_NEW_NOSGN;
	public String R7_NO_CON_START;
	public String R7_NO_NEW_CON_ONBO;
	public String R7_NO_CON_DEBT_COUN;
	public String R7_NO_CON_DEL_NPA;
	public String R7_NO_CON_GOV_50;
	public String R7_NO_SME_SOLE;
	public String R7_NO_CON_TAG_VUL;
	public String R7_NO_NEW_CON_ONB_GNP;
	public String R7_NO_CON_END;
	public String R8_BANK;
	public String R8_PRODUCT;
	public String R8_NO_WO_SD;
	public String R8_NO_CON_POD_SD;
	public String R8_NO_CON_UNAU_SP_TP;
	public String R8_NO_CON_45_50;
	public String R8_NO_CON_50;
	public String R8_NO_OF_LES_50;
	public String R8_NO_OF_BNK_18;
	public String R8_NO_OF_BNK_18_25;
	public String R8_NO_OF_BNK_26_35;
	public String R8_NO_OF_BNK_36_50;
	public String R8_NO_CON_BNK_50;
	public String R8_NO_CON_SAL_SPD;
	public String R8_NO_CON_BUS_SPD;
	public String R8_NO_CON_PRO_SPD;
	public String R8_NO_CON_INC_5K;
	public String R8_NO_CON_INC_5K_10K;
	public String R8_NO_CON_INC_10K_20K;
	public String R8_NO_CON_INC_20K_35K;
	public String R8_NO_CON_INC_35K;
	public String R8_NO_CON_BEL_SCL;
	public String R8_NO_CON_BAC;
	public String R8_NO_CON_ABV_MAS;
	public String R8_NO_CON_ABU_KYC;
	public String R8_NO_CON_DUB_KYC;
	public String R8_NO_CON_SHJ_KYC;
	public String R8_NO_CON_AJM_KYC;
	public String R8_NO_CON_FUJ_KYC;
	public String R8_NO_CON_RAK_KYC;
	public String R8_NO_CON_UAQ_KYC;
	public String R8_NO_CON_RET;
	public String R8_NO_CON_DBR_LIM;
	public String R8_NO_UAE_CON_SPC_TP;
	public String R8_NO_UAE_CON_NLS;
	public String R8_VAL_LOS_AED;
	public String R8_NO_CON_ONB_90;
	public String R8_NO_CON_BAL_PAY;
	public String R8_NO_CON_BAL_SPC_TP;
	public String R8_NO_CON_DEBT;
	public String R8_NO_CON_ONB_REF;
	public String R8_NO_CON_ONB_AGE;
	public String R8_NO_CON_AFF_UNAU;
	public String R8_NO_OF_ACCS_POD;
	public String R8_NO_DEL_CON;
	public String R8_NO_INS_FUN_LFI;
	public String R8_NO_CON_COL_FIN;
	public String R8_TOT_NO_NEW_FIN;
	public String R8_TOT_NO_NEW_NOSGN;
	public String R8_NO_CON_START;
	public String R8_NO_NEW_CON_ONBO;
	public String R8_NO_CON_DEBT_COUN;
	public String R8_NO_CON_DEL_NPA;
	public String R8_NO_CON_GOV_50;
	public String R8_NO_SME_SOLE;
	public String R8_NO_CON_TAG_VUL;
	public String R8_NO_NEW_CON_ONB_GNP;
	public String R8_NO_CON_END;
	public String R9_BANK;
	public String R9_PRODUCT;
	public String R9_NO_WO_SD;
	public String R9_NO_CON_POD_SD;
	public String R9_NO_CON_UNAU_SP_TP;
	public String R9_NO_CON_45_50;
	public String R9_NO_CON_50;
	public String R9_NO_OF_LES_50;
	public String R9_NO_OF_BNK_18;
	public String R9_NO_OF_BNK_18_25;
	public String R9_NO_OF_BNK_26_35;
	public String R9_NO_OF_BNK_36_50;
	public String R9_NO_CON_BNK_50;
	public String R9_NO_CON_SAL_SPD;
	public String R9_NO_CON_BUS_SPD;
	public String R9_NO_CON_PRO_SPD;
	public String R9_NO_CON_INC_5K;
	public String R9_NO_CON_INC_5K_10K;
	public String R9_NO_CON_INC_10K_20K;
	public String R9_NO_CON_INC_20K_35K;
	public String R9_NO_CON_INC_35K;
	public String R9_NO_CON_BEL_SCL;
	public String R9_NO_CON_BAC;
	public String R9_NO_CON_ABV_MAS;
	public String R9_NO_CON_ABU_KYC;
	public String R9_NO_CON_DUB_KYC;
	public String R9_NO_CON_SHJ_KYC;
	public String R9_NO_CON_AJM_KYC;
	public String R9_NO_CON_FUJ_KYC;
	public String R9_NO_CON_RAK_KYC;
	public String R9_NO_CON_UAQ_KYC;
	public String R9_NO_CON_RET;
	public String R9_NO_CON_DBR_LIM;
	public String R9_NO_UAE_CON_SPC_TP;
	public String R9_NO_UAE_CON_NLS;
	public String R9_VAL_LOS_AED;
	public String R9_NO_CON_ONB_90;
	public String R9_NO_CON_BAL_PAY;
	public String R9_NO_CON_BAL_SPC_TP;
	public String R9_NO_CON_DEBT;
	public String R9_NO_CON_ONB_REF;
	public String R9_NO_CON_ONB_AGE;
	public String R9_NO_CON_AFF_UNAU;
	public String R9_NO_OF_ACCS_POD;
	public String R9_NO_DEL_CON;
	public String R9_NO_INS_FUN_LFI;
	public String R9_NO_CON_COL_FIN;
	public String R9_TOT_NO_NEW_FIN;
	public String R9_TOT_NO_NEW_NOSGN;
	public String R9_NO_CON_START;
	public String R9_NO_NEW_CON_ONBO;
	public String R9_NO_CON_DEBT_COUN;
	public String R9_NO_CON_DEL_NPA;
	public String R9_NO_CON_GOV_50;
	public String R9_NO_SME_SOLE;
	public String R9_NO_CON_TAG_VUL;
	public String R9_NO_NEW_CON_ONB_GNP;
	public String R9_NO_CON_END;
	public String R10_BANK;
	public String R10_PRODUCT;
	public String R10_NO_WO_SD;
	public String R10_NO_CON_POD_SD;
	public String R10_NO_CON_UNAU_SP_TP;
	public String R10_NO_CON_45_50;
	public String R10_NO_CON_50;
	public String R10_NO_OF_LES_50;
	public String R10_NO_OF_BNK_18;
	public String R10_NO_OF_BNK_18_25;
	public String R10_NO_OF_BNK_26_35;
	public String R10_NO_OF_BNK_36_50;
	public String R10_NO_CON_BNK_50;
	public String R10_NO_CON_SAL_SPD;
	public String R10_NO_CON_BUS_SPD;
	public String R10_NO_CON_PRO_SPD;
	public String R10_NO_CON_INC_5K;
	public String R10_NO_CON_INC_5K_10K;
	public String R10_NO_CON_INC_10K_20K;
	public String R10_NO_CON_INC_20K_35K;
	public String R10_NO_CON_INC_35K;
	public String R10_NO_CON_BEL_SCL;
	public String R10_NO_CON_BAC;
	public String R10_NO_CON_ABV_MAS;
	public String R10_NO_CON_ABU_KYC;
	public String R10_NO_CON_DUB_KYC;
	public String R10_NO_CON_SHJ_KYC;
	public String R10_NO_CON_AJM_KYC;
	public String R10_NO_CON_FUJ_KYC;
	public String R10_NO_CON_RAK_KYC;
	public String R10_NO_CON_UAQ_KYC;
	public String R10_NO_CON_RET;
	public String R10_NO_CON_DBR_LIM;
	public String R10_NO_UAE_CON_SPC_TP;
	public String R10_NO_UAE_CON_NLS;
	public String R10_VAL_LOS_AED;
	public String R10_NO_CON_ONB_90;
	public String R10_NO_CON_BAL_PAY;
	public String R10_NO_CON_BAL_SPC_TP;
	public String R10_NO_CON_DEBT;
	public String R10_NO_CON_ONB_REF;
	public String R10_NO_CON_ONB_AGE;
	public String R10_NO_CON_AFF_UNAU;
	public String R10_NO_OF_ACCS_POD;
	public String R10_NO_DEL_CON;
	public String R10_NO_INS_FUN_LFI;
	public String R10_NO_CON_COL_FIN;
	public String R10_TOT_NO_NEW_FIN;
	public String R10_TOT_NO_NEW_NOSGN;
	public String R10_NO_CON_START;
	public String R10_NO_NEW_CON_ONBO;
	public String R10_NO_CON_DEBT_COUN;
	public String R10_NO_CON_DEL_NPA;
	public String R10_NO_CON_GOV_50;
	public String R10_NO_SME_SOLE;
	public String R10_NO_CON_TAG_VUL;
	public String R10_NO_NEW_CON_ONB_GNP;
	public String R10_NO_CON_END;
	public String R11_BANK;
	public String R11_PRODUCT;
	public String R11_NO_WO_SD;
	public String R11_NO_CON_POD_SD;
	public String R11_NO_CON_UNAU_SP_TP;
	public String R11_NO_CON_45_50;
	public String R11_NO_CON_50;
	public String R11_NO_OF_LES_50;
	public String R11_NO_OF_BNK_18;
	public String R11_NO_OF_BNK_18_25;
	public String R11_NO_OF_BNK_26_35;
	public String R11_NO_OF_BNK_36_50;
	public String R11_NO_CON_BNK_50;
	public String R11_NO_CON_SAL_SPD;
	public String R11_NO_CON_BUS_SPD;
	public String R11_NO_CON_PRO_SPD;
	public String R11_NO_CON_INC_5K;
	public String R11_NO_CON_INC_5K_10K;
	public String R11_NO_CON_INC_10K_20K;
	public String R11_NO_CON_INC_20K_35K;
	public String R11_NO_CON_INC_35K;
	public String R11_NO_CON_BEL_SCL;
	public String R11_NO_CON_BAC;
	public String R11_NO_CON_ABV_MAS;
	public String R11_NO_CON_ABU_KYC;
	public String R11_NO_CON_DUB_KYC;
	public String R11_NO_CON_SHJ_KYC;
	public String R11_NO_CON_AJM_KYC;
	public String R11_NO_CON_FUJ_KYC;
	public String R11_NO_CON_RAK_KYC;
	public String R11_NO_CON_UAQ_KYC;
	public String R11_NO_CON_RET;
	public String R11_NO_CON_DBR_LIM;
	public String R11_NO_UAE_CON_SPC_TP;
	public String R11_NO_UAE_CON_NLS;
	public String R11_VAL_LOS_AED;
	public String R11_NO_CON_ONB_90;
	public String R11_NO_CON_BAL_PAY;
	public String R11_NO_CON_BAL_SPC_TP;
	public String R11_NO_CON_DEBT;
	public String R11_NO_CON_ONB_REF;
	public String R11_NO_CON_ONB_AGE;
	public String R11_NO_CON_AFF_UNAU;
	public String R11_NO_OF_ACCS_POD;
	public String R11_NO_DEL_CON;
	public String R11_NO_INS_FUN_LFI;
	public String R11_NO_CON_COL_FIN;
	public String R11_TOT_NO_NEW_FIN;
	public String R11_TOT_NO_NEW_NOSGN;
	public String R11_NO_CON_START;
	public String R11_NO_NEW_CON_ONBO;
	public String R11_NO_CON_DEBT_COUN;
	public String R11_NO_CON_DEL_NPA;
	public String R11_NO_CON_GOV_50;
	public String R11_NO_SME_SOLE;
	public String R11_NO_CON_TAG_VUL;
	public String R11_NO_NEW_CON_ONB_GNP;
	public String R11_NO_CON_END;
	public String R12_BANK;
	public String R12_PRODUCT;
	public String R12_NO_WO_SD;
	public String R12_NO_CON_POD_SD;
	public String R12_NO_CON_UNAU_SP_TP;
	public String R12_NO_CON_45_50;
	public String R12_NO_CON_50;
	public String R12_NO_OF_LES_50;
	public String R12_NO_OF_BNK_18;
	public String R12_NO_OF_BNK_18_25;
	public String R12_NO_OF_BNK_26_35;
	public String R12_NO_OF_BNK_36_50;
	public String R12_NO_CON_BNK_50;
	public String R12_NO_CON_SAL_SPD;
	public String R12_NO_CON_BUS_SPD;
	public String R12_NO_CON_PRO_SPD;
	public String R12_NO_CON_INC_5K;
	public String R12_NO_CON_INC_5K_10K;
	public String R12_NO_CON_INC_10K_20K;
	public String R12_NO_CON_INC_20K_35K;
	public String R12_NO_CON_INC_35K;
	public String R12_NO_CON_BEL_SCL;
	public String R12_NO_CON_BAC;
	public String R12_NO_CON_ABV_MAS;
	public String R12_NO_CON_ABU_KYC;
	public String R12_NO_CON_DUB_KYC;
	public String R12_NO_CON_SHJ_KYC;
	public String R12_NO_CON_AJM_KYC;
	public String R12_NO_CON_FUJ_KYC;
	public String R12_NO_CON_RAK_KYC;
	public String R12_NO_CON_UAQ_KYC;
	public String R12_NO_CON_RET;
	public String R12_NO_CON_DBR_LIM;
	public String R12_NO_UAE_CON_SPC_TP;
	public String R12_NO_UAE_CON_NLS;
	public String R12_VAL_LOS_AED;
	public String R12_NO_CON_ONB_90;
	public String R12_NO_CON_BAL_PAY;
	public String R12_NO_CON_BAL_SPC_TP;
	public String R12_NO_CON_DEBT;
	public String R12_NO_CON_ONB_REF;
	public String R12_NO_CON_ONB_AGE;
	public String R12_NO_CON_AFF_UNAU;
	public String R12_NO_OF_ACCS_POD;
	public String R12_NO_DEL_CON;
	public String R12_NO_INS_FUN_LFI;
	public String R12_NO_CON_COL_FIN;
	public String R12_TOT_NO_NEW_FIN;
	public String R12_TOT_NO_NEW_NOSGN;
	public String R12_NO_CON_START;
	public String R12_NO_NEW_CON_ONBO;
	public String R12_NO_CON_DEBT_COUN;
	public String R12_NO_CON_DEL_NPA;
	public String R12_NO_CON_GOV_50;
	public String R12_NO_SME_SOLE;
	public String R12_NO_CON_TAG_VUL;
	public String R12_NO_NEW_CON_ONB_GNP;
	public String R12_NO_CON_END;
	public String R13_BANK;
	public String R13_PRODUCT;
	public String R13_NO_WO_SD;
	public String R13_NO_CON_POD_SD;
	public String R13_NO_CON_UNAU_SP_TP;
	public String R13_NO_CON_45_50;
	public String R13_NO_CON_50;
	public String R13_NO_OF_LES_50;
	public String R13_NO_OF_BNK_18;
	public String R13_NO_OF_BNK_18_25;
	public String R13_NO_OF_BNK_26_35;
	public String R13_NO_OF_BNK_36_50;
	public String R13_NO_CON_BNK_50;
	public String R13_NO_CON_SAL_SPD;
	public String R13_NO_CON_BUS_SPD;
	public String R13_NO_CON_PRO_SPD;
	public String R13_NO_CON_INC_5K;
	public String R13_NO_CON_INC_5K_10K;
	public String R13_NO_CON_INC_10K_20K;
	public String R13_NO_CON_INC_20K_35K;
	public String R13_NO_CON_INC_35K;
	public String R13_NO_CON_BEL_SCL;
	public String R13_NO_CON_BAC;
	public String R13_NO_CON_ABV_MAS;
	public String R13_NO_CON_ABU_KYC;
	public String R13_NO_CON_DUB_KYC;
	public String R13_NO_CON_SHJ_KYC;
	public String R13_NO_CON_AJM_KYC;
	public String R13_NO_CON_FUJ_KYC;
	public String R13_NO_CON_RAK_KYC;
	public String R13_NO_CON_UAQ_KYC;
	public String R13_NO_CON_RET;
	public String R13_NO_CON_DBR_LIM;
	public String R13_NO_UAE_CON_SPC_TP;
	public String R13_NO_UAE_CON_NLS;
	public String R13_VAL_LOS_AED;
	public String R13_NO_CON_ONB_90;
	public String R13_NO_CON_BAL_PAY;
	public String R13_NO_CON_BAL_SPC_TP;
	public String R13_NO_CON_DEBT;
	public String R13_NO_CON_ONB_REF;
	public String R13_NO_CON_ONB_AGE;
	public String R13_NO_CON_AFF_UNAU;
	public String R13_NO_OF_ACCS_POD;
	public String R13_NO_DEL_CON;
	public String R13_NO_INS_FUN_LFI;
	public String R13_NO_CON_COL_FIN;
	public String R13_TOT_NO_NEW_FIN;
	public String R13_TOT_NO_NEW_NOSGN;
	public String R13_NO_CON_START;
	public String R13_NO_NEW_CON_ONBO;
	public String R13_NO_CON_DEBT_COUN;
	public String R13_NO_CON_DEL_NPA;
	public String R13_NO_CON_GOV_50;
	public String R13_NO_SME_SOLE;
	public String R13_NO_CON_TAG_VUL;
	public String R13_NO_NEW_CON_ONB_GNP;
	public String R13_NO_CON_END;
	public String R14_BANK;
	public String R14_PRODUCT;
	public String R14_NO_WO_SD;
	public String R14_NO_CON_POD_SD;
	public String R14_NO_CON_UNAU_SP_TP;
	public String R14_NO_CON_45_50;
	public String R14_NO_CON_50;
	public String R14_NO_OF_LES_50;
	public String R14_NO_OF_BNK_18;
	public String R14_NO_OF_BNK_18_25;
	public String R14_NO_OF_BNK_26_35;
	public String R14_NO_OF_BNK_36_50;
	public String R14_NO_CON_BNK_50;
	public String R14_NO_CON_SAL_SPD;
	public String R14_NO_CON_BUS_SPD;
	public String R14_NO_CON_PRO_SPD;
	public String R14_NO_CON_INC_5K;
	public String R14_NO_CON_INC_5K_10K;
	public String R14_NO_CON_INC_10K_20K;
	public String R14_NO_CON_INC_20K_35K;
	public String R14_NO_CON_INC_35K;
	public String R14_NO_CON_BEL_SCL;
	public String R14_NO_CON_BAC;
	public String R14_NO_CON_ABV_MAS;
	public String R14_NO_CON_ABU_KYC;
	public String R14_NO_CON_DUB_KYC;
	public String R14_NO_CON_SHJ_KYC;
	public String R14_NO_CON_AJM_KYC;
	public String R14_NO_CON_FUJ_KYC;
	public String R14_NO_CON_RAK_KYC;
	public String R14_NO_CON_UAQ_KYC;
	public String R14_NO_CON_RET;
	public String R14_NO_CON_DBR_LIM;
	public String R14_NO_UAE_CON_SPC_TP;
	public String R14_NO_UAE_CON_NLS;
	public String R14_VAL_LOS_AED;
	public String R14_NO_CON_ONB_90;
	public String R14_NO_CON_BAL_PAY;
	public String R14_NO_CON_BAL_SPC_TP;
	public String R14_NO_CON_DEBT;
	public String R14_NO_CON_ONB_REF;
	public String R14_NO_CON_ONB_AGE;
	public String R14_NO_CON_AFF_UNAU;
	public String R14_NO_OF_ACCS_POD;
	public String R14_NO_DEL_CON;
	public String R14_NO_INS_FUN_LFI;
	public String R14_NO_CON_COL_FIN;
	public String R14_TOT_NO_NEW_FIN;
	public String R14_TOT_NO_NEW_NOSGN;
	public String R14_NO_CON_START;
	public String R14_NO_NEW_CON_ONBO;
	public String R14_NO_CON_DEBT_COUN;
	public String R14_NO_CON_DEL_NPA;
	public String R14_NO_CON_GOV_50;
	public String R14_NO_SME_SOLE;
	public String R14_NO_CON_TAG_VUL;
	public String R14_NO_NEW_CON_ONB_GNP;
	public String R14_NO_CON_END;
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
	public String getR6_BANK() {
		return R6_BANK;
	}

	public void setR6_BANK(String r6_BANK) {
		R6_BANK = r6_BANK;
	}

	public String getR6_PRODUCT() {
		return R6_PRODUCT;
	}

	public void setR6_PRODUCT(String r6_PRODUCT) {
		R6_PRODUCT = r6_PRODUCT;
	}

	public String getR6_NO_WO_SD() {
		return R6_NO_WO_SD;
	}

	public void setR6_NO_WO_SD(String r6_NO_WO_SD) {
		R6_NO_WO_SD = r6_NO_WO_SD;
	}

	public String getR6_NO_CON_POD_SD() {
		return R6_NO_CON_POD_SD;
	}

	public void setR6_NO_CON_POD_SD(String r6_NO_CON_POD_SD) {
		R6_NO_CON_POD_SD = r6_NO_CON_POD_SD;
	}

	public String getR6_NO_CON_UNAU_SP_TP() {
		return R6_NO_CON_UNAU_SP_TP;
	}

	public void setR6_NO_CON_UNAU_SP_TP(String r6_NO_CON_UNAU_SP_TP) {
		R6_NO_CON_UNAU_SP_TP = r6_NO_CON_UNAU_SP_TP;
	}

	public String getR6_NO_CON_45_50() {
		return R6_NO_CON_45_50;
	}

	public void setR6_NO_CON_45_50(String r6_NO_CON_45_50) {
		R6_NO_CON_45_50 = r6_NO_CON_45_50;
	}

	public String getR6_NO_CON_50() {
		return R6_NO_CON_50;
	}

	public void setR6_NO_CON_50(String r6_NO_CON_50) {
		R6_NO_CON_50 = r6_NO_CON_50;
	}

	public String getR6_NO_OF_LES_50() {
		return R6_NO_OF_LES_50;
	}

	public void setR6_NO_OF_LES_50(String r6_NO_OF_LES_50) {
		R6_NO_OF_LES_50 = r6_NO_OF_LES_50;
	}

	public String getR6_NO_OF_BNK_18() {
		return R6_NO_OF_BNK_18;
	}

	public void setR6_NO_OF_BNK_18(String r6_NO_OF_BNK_18) {
		R6_NO_OF_BNK_18 = r6_NO_OF_BNK_18;
	}

	public String getR6_NO_OF_BNK_18_25() {
		return R6_NO_OF_BNK_18_25;
	}

	public void setR6_NO_OF_BNK_18_25(String r6_NO_OF_BNK_18_25) {
		R6_NO_OF_BNK_18_25 = r6_NO_OF_BNK_18_25;
	}

	public String getR6_NO_OF_BNK_26_35() {
		return R6_NO_OF_BNK_26_35;
	}

	public void setR6_NO_OF_BNK_26_35(String r6_NO_OF_BNK_26_35) {
		R6_NO_OF_BNK_26_35 = r6_NO_OF_BNK_26_35;
	}

	public String getR6_NO_OF_BNK_36_50() {
		return R6_NO_OF_BNK_36_50;
	}

	public void setR6_NO_OF_BNK_36_50(String r6_NO_OF_BNK_36_50) {
		R6_NO_OF_BNK_36_50 = r6_NO_OF_BNK_36_50;
	}

	public String getR6_NO_CON_BNK_50() {
		return R6_NO_CON_BNK_50;
	}

	public void setR6_NO_CON_BNK_50(String r6_NO_CON_BNK_50) {
		R6_NO_CON_BNK_50 = r6_NO_CON_BNK_50;
	}

	public String getR6_NO_CON_SAL_SPD() {
		return R6_NO_CON_SAL_SPD;
	}

	public void setR6_NO_CON_SAL_SPD(String r6_NO_CON_SAL_SPD) {
		R6_NO_CON_SAL_SPD = r6_NO_CON_SAL_SPD;
	}

	public String getR6_NO_CON_BUS_SPD() {
		return R6_NO_CON_BUS_SPD;
	}

	public void setR6_NO_CON_BUS_SPD(String r6_NO_CON_BUS_SPD) {
		R6_NO_CON_BUS_SPD = r6_NO_CON_BUS_SPD;
	}

	public String getR6_NO_CON_PRO_SPD() {
		return R6_NO_CON_PRO_SPD;
	}

	public void setR6_NO_CON_PRO_SPD(String r6_NO_CON_PRO_SPD) {
		R6_NO_CON_PRO_SPD = r6_NO_CON_PRO_SPD;
	}

	public String getR6_NO_CON_INC_5K() {
		return R6_NO_CON_INC_5K;
	}

	public void setR6_NO_CON_INC_5K(String r6_NO_CON_INC_5K) {
		R6_NO_CON_INC_5K = r6_NO_CON_INC_5K;
	}

	public String getR6_NO_CON_INC_5K_10K() {
		return R6_NO_CON_INC_5K_10K;
	}

	public void setR6_NO_CON_INC_5K_10K(String r6_NO_CON_INC_5K_10K) {
		R6_NO_CON_INC_5K_10K = r6_NO_CON_INC_5K_10K;
	}

	public String getR6_NO_CON_INC_10K_20K() {
		return R6_NO_CON_INC_10K_20K;
	}

	public void setR6_NO_CON_INC_10K_20K(String r6_NO_CON_INC_10K_20K) {
		R6_NO_CON_INC_10K_20K = r6_NO_CON_INC_10K_20K;
	}

	public String getR6_NO_CON_INC_20K_35K() {
		return R6_NO_CON_INC_20K_35K;
	}

	public void setR6_NO_CON_INC_20K_35K(String r6_NO_CON_INC_20K_35K) {
		R6_NO_CON_INC_20K_35K = r6_NO_CON_INC_20K_35K;
	}

	public String getR6_NO_CON_INC_35K() {
		return R6_NO_CON_INC_35K;
	}

	public void setR6_NO_CON_INC_35K(String r6_NO_CON_INC_35K) {
		R6_NO_CON_INC_35K = r6_NO_CON_INC_35K;
	}

	public String getR6_NO_CON_BEL_SCL() {
		return R6_NO_CON_BEL_SCL;
	}

	public void setR6_NO_CON_BEL_SCL(String r6_NO_CON_BEL_SCL) {
		R6_NO_CON_BEL_SCL = r6_NO_CON_BEL_SCL;
	}

	public String getR6_NO_CON_BAC() {
		return R6_NO_CON_BAC;
	}

	public void setR6_NO_CON_BAC(String r6_NO_CON_BAC) {
		R6_NO_CON_BAC = r6_NO_CON_BAC;
	}

	public String getR6_NO_CON_ABV_MAS() {
		return R6_NO_CON_ABV_MAS;
	}

	public void setR6_NO_CON_ABV_MAS(String r6_NO_CON_ABV_MAS) {
		R6_NO_CON_ABV_MAS = r6_NO_CON_ABV_MAS;
	}

	public String getR6_NO_CON_ABU_KYC() {
		return R6_NO_CON_ABU_KYC;
	}

	public void setR6_NO_CON_ABU_KYC(String r6_NO_CON_ABU_KYC) {
		R6_NO_CON_ABU_KYC = r6_NO_CON_ABU_KYC;
	}

	public String getR6_NO_CON_DUB_KYC() {
		return R6_NO_CON_DUB_KYC;
	}

	public void setR6_NO_CON_DUB_KYC(String r6_NO_CON_DUB_KYC) {
		R6_NO_CON_DUB_KYC = r6_NO_CON_DUB_KYC;
	}

	public String getR6_NO_CON_SHJ_KYC() {
		return R6_NO_CON_SHJ_KYC;
	}

	public void setR6_NO_CON_SHJ_KYC(String r6_NO_CON_SHJ_KYC) {
		R6_NO_CON_SHJ_KYC = r6_NO_CON_SHJ_KYC;
	}

	public String getR6_NO_CON_AJM_KYC() {
		return R6_NO_CON_AJM_KYC;
	}

	public void setR6_NO_CON_AJM_KYC(String r6_NO_CON_AJM_KYC) {
		R6_NO_CON_AJM_KYC = r6_NO_CON_AJM_KYC;
	}

	public String getR6_NO_CON_FUJ_KYC() {
		return R6_NO_CON_FUJ_KYC;
	}

	public void setR6_NO_CON_FUJ_KYC(String r6_NO_CON_FUJ_KYC) {
		R6_NO_CON_FUJ_KYC = r6_NO_CON_FUJ_KYC;
	}

	public String getR6_NO_CON_RAK_KYC() {
		return R6_NO_CON_RAK_KYC;
	}

	public void setR6_NO_CON_RAK_KYC(String r6_NO_CON_RAK_KYC) {
		R6_NO_CON_RAK_KYC = r6_NO_CON_RAK_KYC;
	}

	public String getR6_NO_CON_UAQ_KYC() {
		return R6_NO_CON_UAQ_KYC;
	}

	public void setR6_NO_CON_UAQ_KYC(String r6_NO_CON_UAQ_KYC) {
		R6_NO_CON_UAQ_KYC = r6_NO_CON_UAQ_KYC;
	}

	public String getR6_NO_CON_RET() {
		return R6_NO_CON_RET;
	}

	public void setR6_NO_CON_RET(String r6_NO_CON_RET) {
		R6_NO_CON_RET = r6_NO_CON_RET;
	}

	public String getR6_NO_CON_DBR_LIM() {
		return R6_NO_CON_DBR_LIM;
	}

	public void setR6_NO_CON_DBR_LIM(String r6_NO_CON_DBR_LIM) {
		R6_NO_CON_DBR_LIM = r6_NO_CON_DBR_LIM;
	}

	public String getR6_NO_UAE_CON_SPC_TP() {
		return R6_NO_UAE_CON_SPC_TP;
	}

	public void setR6_NO_UAE_CON_SPC_TP(String r6_NO_UAE_CON_SPC_TP) {
		R6_NO_UAE_CON_SPC_TP = r6_NO_UAE_CON_SPC_TP;
	}

	public String getR6_NO_UAE_CON_NLS() {
		return R6_NO_UAE_CON_NLS;
	}

	public void setR6_NO_UAE_CON_NLS(String r6_NO_UAE_CON_NLS) {
		R6_NO_UAE_CON_NLS = r6_NO_UAE_CON_NLS;
	}

	public String getR6_VAL_LOS_AED() {
		return R6_VAL_LOS_AED;
	}

	public void setR6_VAL_LOS_AED(String r6_VAL_LOS_AED) {
		R6_VAL_LOS_AED = r6_VAL_LOS_AED;
	}

	public String getR6_NO_CON_ONB_90() {
		return R6_NO_CON_ONB_90;
	}

	public void setR6_NO_CON_ONB_90(String r6_NO_CON_ONB_90) {
		R6_NO_CON_ONB_90 = r6_NO_CON_ONB_90;
	}

	public String getR6_NO_CON_BAL_PAY() {
		return R6_NO_CON_BAL_PAY;
	}

	public void setR6_NO_CON_BAL_PAY(String r6_NO_CON_BAL_PAY) {
		R6_NO_CON_BAL_PAY = r6_NO_CON_BAL_PAY;
	}

	public String getR6_NO_CON_BAL_SPC_TP() {
		return R6_NO_CON_BAL_SPC_TP;
	}

	public void setR6_NO_CON_BAL_SPC_TP(String r6_NO_CON_BAL_SPC_TP) {
		R6_NO_CON_BAL_SPC_TP = r6_NO_CON_BAL_SPC_TP;
	}

	public String getR6_NO_CON_DEBT() {
		return R6_NO_CON_DEBT;
	}

	public void setR6_NO_CON_DEBT(String r6_NO_CON_DEBT) {
		R6_NO_CON_DEBT = r6_NO_CON_DEBT;
	}

	public String getR6_NO_CON_ONB_REF() {
		return R6_NO_CON_ONB_REF;
	}

	public void setR6_NO_CON_ONB_REF(String r6_NO_CON_ONB_REF) {
		R6_NO_CON_ONB_REF = r6_NO_CON_ONB_REF;
	}

	public String getR6_NO_CON_ONB_AGE() {
		return R6_NO_CON_ONB_AGE;
	}

	public void setR6_NO_CON_ONB_AGE(String r6_NO_CON_ONB_AGE) {
		R6_NO_CON_ONB_AGE = r6_NO_CON_ONB_AGE;
	}

	public String getR6_NO_CON_AFF_UNAU() {
		return R6_NO_CON_AFF_UNAU;
	}

	public void setR6_NO_CON_AFF_UNAU(String r6_NO_CON_AFF_UNAU) {
		R6_NO_CON_AFF_UNAU = r6_NO_CON_AFF_UNAU;
	}

	public String getR6_NO_OF_ACCS_POD() {
		return R6_NO_OF_ACCS_POD;
	}

	public void setR6_NO_OF_ACCS_POD(String r6_NO_OF_ACCS_POD) {
		R6_NO_OF_ACCS_POD = r6_NO_OF_ACCS_POD;
	}

	public String getR6_NO_DEL_CON() {
		return R6_NO_DEL_CON;
	}

	public void setR6_NO_DEL_CON(String r6_NO_DEL_CON) {
		R6_NO_DEL_CON = r6_NO_DEL_CON;
	}

	public String getR6_NO_INS_FUN_LFI() {
		return R6_NO_INS_FUN_LFI;
	}

	public void setR6_NO_INS_FUN_LFI(String r6_NO_INS_FUN_LFI) {
		R6_NO_INS_FUN_LFI = r6_NO_INS_FUN_LFI;
	}

	public String getR6_NO_CON_COL_FIN() {
		return R6_NO_CON_COL_FIN;
	}

	public void setR6_NO_CON_COL_FIN(String r6_NO_CON_COL_FIN) {
		R6_NO_CON_COL_FIN = r6_NO_CON_COL_FIN;
	}

	public String getR6_TOT_NO_NEW_FIN() {
		return R6_TOT_NO_NEW_FIN;
	}

	public void setR6_TOT_NO_NEW_FIN(String r6_TOT_NO_NEW_FIN) {
		R6_TOT_NO_NEW_FIN = r6_TOT_NO_NEW_FIN;
	}

	public String getR6_TOT_NO_NEW_NOSGN() {
		return R6_TOT_NO_NEW_NOSGN;
	}

	public void setR6_TOT_NO_NEW_NOSGN(String r6_TOT_NO_NEW_NOSGN) {
		R6_TOT_NO_NEW_NOSGN = r6_TOT_NO_NEW_NOSGN;
	}

	public String getR6_NO_CON_START() {
		return R6_NO_CON_START;
	}

	public void setR6_NO_CON_START(String r6_NO_CON_START) {
		R6_NO_CON_START = r6_NO_CON_START;
	}

	public String getR6_NO_NEW_CON_ONBO() {
		return R6_NO_NEW_CON_ONBO;
	}

	public void setR6_NO_NEW_CON_ONBO(String r6_NO_NEW_CON_ONBO) {
		R6_NO_NEW_CON_ONBO = r6_NO_NEW_CON_ONBO;
	}

	public String getR6_NO_CON_DEBT_COUN() {
		return R6_NO_CON_DEBT_COUN;
	}

	public void setR6_NO_CON_DEBT_COUN(String r6_NO_CON_DEBT_COUN) {
		R6_NO_CON_DEBT_COUN = r6_NO_CON_DEBT_COUN;
	}

	public String getR6_NO_CON_DEL_NPA() {
		return R6_NO_CON_DEL_NPA;
	}

	public void setR6_NO_CON_DEL_NPA(String r6_NO_CON_DEL_NPA) {
		R6_NO_CON_DEL_NPA = r6_NO_CON_DEL_NPA;
	}

	public String getR6_NO_CON_GOV_50() {
		return R6_NO_CON_GOV_50;
	}

	public void setR6_NO_CON_GOV_50(String r6_NO_CON_GOV_50) {
		R6_NO_CON_GOV_50 = r6_NO_CON_GOV_50;
	}

	public String getR6_NO_SME_SOLE() {
		return R6_NO_SME_SOLE;
	}

	public void setR6_NO_SME_SOLE(String r6_NO_SME_SOLE) {
		R6_NO_SME_SOLE = r6_NO_SME_SOLE;
	}

	public String getR6_NO_CON_TAG_VUL() {
		return R6_NO_CON_TAG_VUL;
	}

	public void setR6_NO_CON_TAG_VUL(String r6_NO_CON_TAG_VUL) {
		R6_NO_CON_TAG_VUL = r6_NO_CON_TAG_VUL;
	}

	public String getR6_NO_NEW_CON_ONB_GNP() {
		return R6_NO_NEW_CON_ONB_GNP;
	}

	public void setR6_NO_NEW_CON_ONB_GNP(String r6_NO_NEW_CON_ONB_GNP) {
		R6_NO_NEW_CON_ONB_GNP = r6_NO_NEW_CON_ONB_GNP;
	}

	public String getR6_NO_CON_END() {
		return R6_NO_CON_END;
	}

	public void setR6_NO_CON_END(String r6_NO_CON_END) {
		R6_NO_CON_END = r6_NO_CON_END;
	}

	public String getR7_BANK() {
		return R7_BANK;
	}

	public void setR7_BANK(String r7_BANK) {
		R7_BANK = r7_BANK;
	}

	public String getR7_PRODUCT() {
		return R7_PRODUCT;
	}

	public void setR7_PRODUCT(String r7_PRODUCT) {
		R7_PRODUCT = r7_PRODUCT;
	}

	public String getR7_NO_WO_SD() {
		return R7_NO_WO_SD;
	}

	public void setR7_NO_WO_SD(String r7_NO_WO_SD) {
		R7_NO_WO_SD = r7_NO_WO_SD;
	}

	public String getR7_NO_CON_POD_SD() {
		return R7_NO_CON_POD_SD;
	}

	public void setR7_NO_CON_POD_SD(String r7_NO_CON_POD_SD) {
		R7_NO_CON_POD_SD = r7_NO_CON_POD_SD;
	}

	public String getR7_NO_CON_UNAU_SP_TP() {
		return R7_NO_CON_UNAU_SP_TP;
	}

	public void setR7_NO_CON_UNAU_SP_TP(String r7_NO_CON_UNAU_SP_TP) {
		R7_NO_CON_UNAU_SP_TP = r7_NO_CON_UNAU_SP_TP;
	}

	public String getR7_NO_CON_45_50() {
		return R7_NO_CON_45_50;
	}

	public void setR7_NO_CON_45_50(String r7_NO_CON_45_50) {
		R7_NO_CON_45_50 = r7_NO_CON_45_50;
	}

	public String getR7_NO_CON_50() {
		return R7_NO_CON_50;
	}

	public void setR7_NO_CON_50(String r7_NO_CON_50) {
		R7_NO_CON_50 = r7_NO_CON_50;
	}

	public String getR7_NO_OF_LES_50() {
		return R7_NO_OF_LES_50;
	}

	public void setR7_NO_OF_LES_50(String r7_NO_OF_LES_50) {
		R7_NO_OF_LES_50 = r7_NO_OF_LES_50;
	}

	public String getR7_NO_OF_BNK_18() {
		return R7_NO_OF_BNK_18;
	}

	public void setR7_NO_OF_BNK_18(String r7_NO_OF_BNK_18) {
		R7_NO_OF_BNK_18 = r7_NO_OF_BNK_18;
	}

	public String getR7_NO_OF_BNK_18_25() {
		return R7_NO_OF_BNK_18_25;
	}

	public void setR7_NO_OF_BNK_18_25(String r7_NO_OF_BNK_18_25) {
		R7_NO_OF_BNK_18_25 = r7_NO_OF_BNK_18_25;
	}

	public String getR7_NO_OF_BNK_26_35() {
		return R7_NO_OF_BNK_26_35;
	}

	public void setR7_NO_OF_BNK_26_35(String r7_NO_OF_BNK_26_35) {
		R7_NO_OF_BNK_26_35 = r7_NO_OF_BNK_26_35;
	}

	public String getR7_NO_OF_BNK_36_50() {
		return R7_NO_OF_BNK_36_50;
	}

	public void setR7_NO_OF_BNK_36_50(String r7_NO_OF_BNK_36_50) {
		R7_NO_OF_BNK_36_50 = r7_NO_OF_BNK_36_50;
	}

	public String getR7_NO_CON_BNK_50() {
		return R7_NO_CON_BNK_50;
	}

	public void setR7_NO_CON_BNK_50(String r7_NO_CON_BNK_50) {
		R7_NO_CON_BNK_50 = r7_NO_CON_BNK_50;
	}

	public String getR7_NO_CON_SAL_SPD() {
		return R7_NO_CON_SAL_SPD;
	}

	public void setR7_NO_CON_SAL_SPD(String r7_NO_CON_SAL_SPD) {
		R7_NO_CON_SAL_SPD = r7_NO_CON_SAL_SPD;
	}

	public String getR7_NO_CON_BUS_SPD() {
		return R7_NO_CON_BUS_SPD;
	}

	public void setR7_NO_CON_BUS_SPD(String r7_NO_CON_BUS_SPD) {
		R7_NO_CON_BUS_SPD = r7_NO_CON_BUS_SPD;
	}

	public String getR7_NO_CON_PRO_SPD() {
		return R7_NO_CON_PRO_SPD;
	}

	public void setR7_NO_CON_PRO_SPD(String r7_NO_CON_PRO_SPD) {
		R7_NO_CON_PRO_SPD = r7_NO_CON_PRO_SPD;
	}

	public String getR7_NO_CON_INC_5K() {
		return R7_NO_CON_INC_5K;
	}

	public void setR7_NO_CON_INC_5K(String r7_NO_CON_INC_5K) {
		R7_NO_CON_INC_5K = r7_NO_CON_INC_5K;
	}

	public String getR7_NO_CON_INC_5K_10K() {
		return R7_NO_CON_INC_5K_10K;
	}

	public void setR7_NO_CON_INC_5K_10K(String r7_NO_CON_INC_5K_10K) {
		R7_NO_CON_INC_5K_10K = r7_NO_CON_INC_5K_10K;
	}

	public String getR7_NO_CON_INC_10K_20K() {
		return R7_NO_CON_INC_10K_20K;
	}

	public void setR7_NO_CON_INC_10K_20K(String r7_NO_CON_INC_10K_20K) {
		R7_NO_CON_INC_10K_20K = r7_NO_CON_INC_10K_20K;
	}

	public String getR7_NO_CON_INC_20K_35K() {
		return R7_NO_CON_INC_20K_35K;
	}

	public void setR7_NO_CON_INC_20K_35K(String r7_NO_CON_INC_20K_35K) {
		R7_NO_CON_INC_20K_35K = r7_NO_CON_INC_20K_35K;
	}

	public String getR7_NO_CON_INC_35K() {
		return R7_NO_CON_INC_35K;
	}

	public void setR7_NO_CON_INC_35K(String r7_NO_CON_INC_35K) {
		R7_NO_CON_INC_35K = r7_NO_CON_INC_35K;
	}

	public String getR7_NO_CON_BEL_SCL() {
		return R7_NO_CON_BEL_SCL;
	}

	public void setR7_NO_CON_BEL_SCL(String r7_NO_CON_BEL_SCL) {
		R7_NO_CON_BEL_SCL = r7_NO_CON_BEL_SCL;
	}

	public String getR7_NO_CON_BAC() {
		return R7_NO_CON_BAC;
	}

	public void setR7_NO_CON_BAC(String r7_NO_CON_BAC) {
		R7_NO_CON_BAC = r7_NO_CON_BAC;
	}

	public String getR7_NO_CON_ABV_MAS() {
		return R7_NO_CON_ABV_MAS;
	}

	public void setR7_NO_CON_ABV_MAS(String r7_NO_CON_ABV_MAS) {
		R7_NO_CON_ABV_MAS = r7_NO_CON_ABV_MAS;
	}

	public String getR7_NO_CON_ABU_KYC() {
		return R7_NO_CON_ABU_KYC;
	}

	public void setR7_NO_CON_ABU_KYC(String r7_NO_CON_ABU_KYC) {
		R7_NO_CON_ABU_KYC = r7_NO_CON_ABU_KYC;
	}

	public String getR7_NO_CON_DUB_KYC() {
		return R7_NO_CON_DUB_KYC;
	}

	public void setR7_NO_CON_DUB_KYC(String r7_NO_CON_DUB_KYC) {
		R7_NO_CON_DUB_KYC = r7_NO_CON_DUB_KYC;
	}

	public String getR7_NO_CON_SHJ_KYC() {
		return R7_NO_CON_SHJ_KYC;
	}

	public void setR7_NO_CON_SHJ_KYC(String r7_NO_CON_SHJ_KYC) {
		R7_NO_CON_SHJ_KYC = r7_NO_CON_SHJ_KYC;
	}

	public String getR7_NO_CON_AJM_KYC() {
		return R7_NO_CON_AJM_KYC;
	}

	public void setR7_NO_CON_AJM_KYC(String r7_NO_CON_AJM_KYC) {
		R7_NO_CON_AJM_KYC = r7_NO_CON_AJM_KYC;
	}

	public String getR7_NO_CON_FUJ_KYC() {
		return R7_NO_CON_FUJ_KYC;
	}

	public void setR7_NO_CON_FUJ_KYC(String r7_NO_CON_FUJ_KYC) {
		R7_NO_CON_FUJ_KYC = r7_NO_CON_FUJ_KYC;
	}

	public String getR7_NO_CON_RAK_KYC() {
		return R7_NO_CON_RAK_KYC;
	}

	public void setR7_NO_CON_RAK_KYC(String r7_NO_CON_RAK_KYC) {
		R7_NO_CON_RAK_KYC = r7_NO_CON_RAK_KYC;
	}

	public String getR7_NO_CON_UAQ_KYC() {
		return R7_NO_CON_UAQ_KYC;
	}

	public void setR7_NO_CON_UAQ_KYC(String r7_NO_CON_UAQ_KYC) {
		R7_NO_CON_UAQ_KYC = r7_NO_CON_UAQ_KYC;
	}

	public String getR7_NO_CON_RET() {
		return R7_NO_CON_RET;
	}

	public void setR7_NO_CON_RET(String r7_NO_CON_RET) {
		R7_NO_CON_RET = r7_NO_CON_RET;
	}

	public String getR7_NO_CON_DBR_LIM() {
		return R7_NO_CON_DBR_LIM;
	}

	public void setR7_NO_CON_DBR_LIM(String r7_NO_CON_DBR_LIM) {
		R7_NO_CON_DBR_LIM = r7_NO_CON_DBR_LIM;
	}

	public String getR7_NO_UAE_CON_SPC_TP() {
		return R7_NO_UAE_CON_SPC_TP;
	}

	public void setR7_NO_UAE_CON_SPC_TP(String r7_NO_UAE_CON_SPC_TP) {
		R7_NO_UAE_CON_SPC_TP = r7_NO_UAE_CON_SPC_TP;
	}

	public String getR7_NO_UAE_CON_NLS() {
		return R7_NO_UAE_CON_NLS;
	}

	public void setR7_NO_UAE_CON_NLS(String r7_NO_UAE_CON_NLS) {
		R7_NO_UAE_CON_NLS = r7_NO_UAE_CON_NLS;
	}

	public String getR7_VAL_LOS_AED() {
		return R7_VAL_LOS_AED;
	}

	public void setR7_VAL_LOS_AED(String r7_VAL_LOS_AED) {
		R7_VAL_LOS_AED = r7_VAL_LOS_AED;
	}

	public String getR7_NO_CON_ONB_90() {
		return R7_NO_CON_ONB_90;
	}

	public void setR7_NO_CON_ONB_90(String r7_NO_CON_ONB_90) {
		R7_NO_CON_ONB_90 = r7_NO_CON_ONB_90;
	}

	public String getR7_NO_CON_BAL_PAY() {
		return R7_NO_CON_BAL_PAY;
	}

	public void setR7_NO_CON_BAL_PAY(String r7_NO_CON_BAL_PAY) {
		R7_NO_CON_BAL_PAY = r7_NO_CON_BAL_PAY;
	}

	public String getR7_NO_CON_BAL_SPC_TP() {
		return R7_NO_CON_BAL_SPC_TP;
	}

	public void setR7_NO_CON_BAL_SPC_TP(String r7_NO_CON_BAL_SPC_TP) {
		R7_NO_CON_BAL_SPC_TP = r7_NO_CON_BAL_SPC_TP;
	}

	public String getR7_NO_CON_DEBT() {
		return R7_NO_CON_DEBT;
	}

	public void setR7_NO_CON_DEBT(String r7_NO_CON_DEBT) {
		R7_NO_CON_DEBT = r7_NO_CON_DEBT;
	}

	public String getR7_NO_CON_ONB_REF() {
		return R7_NO_CON_ONB_REF;
	}

	public void setR7_NO_CON_ONB_REF(String r7_NO_CON_ONB_REF) {
		R7_NO_CON_ONB_REF = r7_NO_CON_ONB_REF;
	}

	public String getR7_NO_CON_ONB_AGE() {
		return R7_NO_CON_ONB_AGE;
	}

	public void setR7_NO_CON_ONB_AGE(String r7_NO_CON_ONB_AGE) {
		R7_NO_CON_ONB_AGE = r7_NO_CON_ONB_AGE;
	}

	public String getR7_NO_CON_AFF_UNAU() {
		return R7_NO_CON_AFF_UNAU;
	}

	public void setR7_NO_CON_AFF_UNAU(String r7_NO_CON_AFF_UNAU) {
		R7_NO_CON_AFF_UNAU = r7_NO_CON_AFF_UNAU;
	}

	public String getR7_NO_OF_ACCS_POD() {
		return R7_NO_OF_ACCS_POD;
	}

	public void setR7_NO_OF_ACCS_POD(String r7_NO_OF_ACCS_POD) {
		R7_NO_OF_ACCS_POD = r7_NO_OF_ACCS_POD;
	}

	public String getR7_NO_DEL_CON() {
		return R7_NO_DEL_CON;
	}

	public void setR7_NO_DEL_CON(String r7_NO_DEL_CON) {
		R7_NO_DEL_CON = r7_NO_DEL_CON;
	}

	public String getR7_NO_INS_FUN_LFI() {
		return R7_NO_INS_FUN_LFI;
	}

	public void setR7_NO_INS_FUN_LFI(String r7_NO_INS_FUN_LFI) {
		R7_NO_INS_FUN_LFI = r7_NO_INS_FUN_LFI;
	}

	public String getR7_NO_CON_COL_FIN() {
		return R7_NO_CON_COL_FIN;
	}

	public void setR7_NO_CON_COL_FIN(String r7_NO_CON_COL_FIN) {
		R7_NO_CON_COL_FIN = r7_NO_CON_COL_FIN;
	}

	public String getR7_TOT_NO_NEW_FIN() {
		return R7_TOT_NO_NEW_FIN;
	}

	public void setR7_TOT_NO_NEW_FIN(String r7_TOT_NO_NEW_FIN) {
		R7_TOT_NO_NEW_FIN = r7_TOT_NO_NEW_FIN;
	}

	public String getR7_TOT_NO_NEW_NOSGN() {
		return R7_TOT_NO_NEW_NOSGN;
	}

	public void setR7_TOT_NO_NEW_NOSGN(String r7_TOT_NO_NEW_NOSGN) {
		R7_TOT_NO_NEW_NOSGN = r7_TOT_NO_NEW_NOSGN;
	}

	public String getR7_NO_CON_START() {
		return R7_NO_CON_START;
	}

	public void setR7_NO_CON_START(String r7_NO_CON_START) {
		R7_NO_CON_START = r7_NO_CON_START;
	}

	public String getR7_NO_NEW_CON_ONBO() {
		return R7_NO_NEW_CON_ONBO;
	}

	public void setR7_NO_NEW_CON_ONBO(String r7_NO_NEW_CON_ONBO) {
		R7_NO_NEW_CON_ONBO = r7_NO_NEW_CON_ONBO;
	}

	public String getR7_NO_CON_DEBT_COUN() {
		return R7_NO_CON_DEBT_COUN;
	}

	public void setR7_NO_CON_DEBT_COUN(String r7_NO_CON_DEBT_COUN) {
		R7_NO_CON_DEBT_COUN = r7_NO_CON_DEBT_COUN;
	}

	public String getR7_NO_CON_DEL_NPA() {
		return R7_NO_CON_DEL_NPA;
	}

	public void setR7_NO_CON_DEL_NPA(String r7_NO_CON_DEL_NPA) {
		R7_NO_CON_DEL_NPA = r7_NO_CON_DEL_NPA;
	}

	public String getR7_NO_CON_GOV_50() {
		return R7_NO_CON_GOV_50;
	}

	public void setR7_NO_CON_GOV_50(String r7_NO_CON_GOV_50) {
		R7_NO_CON_GOV_50 = r7_NO_CON_GOV_50;
	}

	public String getR7_NO_SME_SOLE() {
		return R7_NO_SME_SOLE;
	}

	public void setR7_NO_SME_SOLE(String r7_NO_SME_SOLE) {
		R7_NO_SME_SOLE = r7_NO_SME_SOLE;
	}

	public String getR7_NO_CON_TAG_VUL() {
		return R7_NO_CON_TAG_VUL;
	}

	public void setR7_NO_CON_TAG_VUL(String r7_NO_CON_TAG_VUL) {
		R7_NO_CON_TAG_VUL = r7_NO_CON_TAG_VUL;
	}

	public String getR7_NO_NEW_CON_ONB_GNP() {
		return R7_NO_NEW_CON_ONB_GNP;
	}

	public void setR7_NO_NEW_CON_ONB_GNP(String r7_NO_NEW_CON_ONB_GNP) {
		R7_NO_NEW_CON_ONB_GNP = r7_NO_NEW_CON_ONB_GNP;
	}

	public String getR7_NO_CON_END() {
		return R7_NO_CON_END;
	}

	public void setR7_NO_CON_END(String r7_NO_CON_END) {
		R7_NO_CON_END = r7_NO_CON_END;
	}

	public String getR8_BANK() {
		return R8_BANK;
	}

	public void setR8_BANK(String r8_BANK) {
		R8_BANK = r8_BANK;
	}

	public String getR8_PRODUCT() {
		return R8_PRODUCT;
	}

	public void setR8_PRODUCT(String r8_PRODUCT) {
		R8_PRODUCT = r8_PRODUCT;
	}

	public String getR8_NO_WO_SD() {
		return R8_NO_WO_SD;
	}

	public void setR8_NO_WO_SD(String r8_NO_WO_SD) {
		R8_NO_WO_SD = r8_NO_WO_SD;
	}

	public String getR8_NO_CON_POD_SD() {
		return R8_NO_CON_POD_SD;
	}

	public void setR8_NO_CON_POD_SD(String r8_NO_CON_POD_SD) {
		R8_NO_CON_POD_SD = r8_NO_CON_POD_SD;
	}

	public String getR8_NO_CON_UNAU_SP_TP() {
		return R8_NO_CON_UNAU_SP_TP;
	}

	public void setR8_NO_CON_UNAU_SP_TP(String r8_NO_CON_UNAU_SP_TP) {
		R8_NO_CON_UNAU_SP_TP = r8_NO_CON_UNAU_SP_TP;
	}

	public String getR8_NO_CON_45_50() {
		return R8_NO_CON_45_50;
	}

	public void setR8_NO_CON_45_50(String r8_NO_CON_45_50) {
		R8_NO_CON_45_50 = r8_NO_CON_45_50;
	}

	public String getR8_NO_CON_50() {
		return R8_NO_CON_50;
	}

	public void setR8_NO_CON_50(String r8_NO_CON_50) {
		R8_NO_CON_50 = r8_NO_CON_50;
	}

	public String getR8_NO_OF_LES_50() {
		return R8_NO_OF_LES_50;
	}

	public void setR8_NO_OF_LES_50(String r8_NO_OF_LES_50) {
		R8_NO_OF_LES_50 = r8_NO_OF_LES_50;
	}

	public String getR8_NO_OF_BNK_18() {
		return R8_NO_OF_BNK_18;
	}

	public void setR8_NO_OF_BNK_18(String r8_NO_OF_BNK_18) {
		R8_NO_OF_BNK_18 = r8_NO_OF_BNK_18;
	}

	public String getR8_NO_OF_BNK_18_25() {
		return R8_NO_OF_BNK_18_25;
	}

	public void setR8_NO_OF_BNK_18_25(String r8_NO_OF_BNK_18_25) {
		R8_NO_OF_BNK_18_25 = r8_NO_OF_BNK_18_25;
	}

	public String getR8_NO_OF_BNK_26_35() {
		return R8_NO_OF_BNK_26_35;
	}

	public void setR8_NO_OF_BNK_26_35(String r8_NO_OF_BNK_26_35) {
		R8_NO_OF_BNK_26_35 = r8_NO_OF_BNK_26_35;
	}

	public String getR8_NO_OF_BNK_36_50() {
		return R8_NO_OF_BNK_36_50;
	}

	public void setR8_NO_OF_BNK_36_50(String r8_NO_OF_BNK_36_50) {
		R8_NO_OF_BNK_36_50 = r8_NO_OF_BNK_36_50;
	}

	public String getR8_NO_CON_BNK_50() {
		return R8_NO_CON_BNK_50;
	}

	public void setR8_NO_CON_BNK_50(String r8_NO_CON_BNK_50) {
		R8_NO_CON_BNK_50 = r8_NO_CON_BNK_50;
	}

	public String getR8_NO_CON_SAL_SPD() {
		return R8_NO_CON_SAL_SPD;
	}

	public void setR8_NO_CON_SAL_SPD(String r8_NO_CON_SAL_SPD) {
		R8_NO_CON_SAL_SPD = r8_NO_CON_SAL_SPD;
	}

	public String getR8_NO_CON_BUS_SPD() {
		return R8_NO_CON_BUS_SPD;
	}

	public void setR8_NO_CON_BUS_SPD(String r8_NO_CON_BUS_SPD) {
		R8_NO_CON_BUS_SPD = r8_NO_CON_BUS_SPD;
	}

	public String getR8_NO_CON_PRO_SPD() {
		return R8_NO_CON_PRO_SPD;
	}

	public void setR8_NO_CON_PRO_SPD(String r8_NO_CON_PRO_SPD) {
		R8_NO_CON_PRO_SPD = r8_NO_CON_PRO_SPD;
	}

	public String getR8_NO_CON_INC_5K() {
		return R8_NO_CON_INC_5K;
	}

	public void setR8_NO_CON_INC_5K(String r8_NO_CON_INC_5K) {
		R8_NO_CON_INC_5K = r8_NO_CON_INC_5K;
	}

	public String getR8_NO_CON_INC_5K_10K() {
		return R8_NO_CON_INC_5K_10K;
	}

	public void setR8_NO_CON_INC_5K_10K(String r8_NO_CON_INC_5K_10K) {
		R8_NO_CON_INC_5K_10K = r8_NO_CON_INC_5K_10K;
	}

	public String getR8_NO_CON_INC_10K_20K() {
		return R8_NO_CON_INC_10K_20K;
	}

	public void setR8_NO_CON_INC_10K_20K(String r8_NO_CON_INC_10K_20K) {
		R8_NO_CON_INC_10K_20K = r8_NO_CON_INC_10K_20K;
	}

	public String getR8_NO_CON_INC_20K_35K() {
		return R8_NO_CON_INC_20K_35K;
	}

	public void setR8_NO_CON_INC_20K_35K(String r8_NO_CON_INC_20K_35K) {
		R8_NO_CON_INC_20K_35K = r8_NO_CON_INC_20K_35K;
	}

	public String getR8_NO_CON_INC_35K() {
		return R8_NO_CON_INC_35K;
	}

	public void setR8_NO_CON_INC_35K(String r8_NO_CON_INC_35K) {
		R8_NO_CON_INC_35K = r8_NO_CON_INC_35K;
	}

	public String getR8_NO_CON_BEL_SCL() {
		return R8_NO_CON_BEL_SCL;
	}

	public void setR8_NO_CON_BEL_SCL(String r8_NO_CON_BEL_SCL) {
		R8_NO_CON_BEL_SCL = r8_NO_CON_BEL_SCL;
	}

	public String getR8_NO_CON_BAC() {
		return R8_NO_CON_BAC;
	}

	public void setR8_NO_CON_BAC(String r8_NO_CON_BAC) {
		R8_NO_CON_BAC = r8_NO_CON_BAC;
	}

	public String getR8_NO_CON_ABV_MAS() {
		return R8_NO_CON_ABV_MAS;
	}

	public void setR8_NO_CON_ABV_MAS(String r8_NO_CON_ABV_MAS) {
		R8_NO_CON_ABV_MAS = r8_NO_CON_ABV_MAS;
	}

	public String getR8_NO_CON_ABU_KYC() {
		return R8_NO_CON_ABU_KYC;
	}

	public void setR8_NO_CON_ABU_KYC(String r8_NO_CON_ABU_KYC) {
		R8_NO_CON_ABU_KYC = r8_NO_CON_ABU_KYC;
	}

	public String getR8_NO_CON_DUB_KYC() {
		return R8_NO_CON_DUB_KYC;
	}

	public void setR8_NO_CON_DUB_KYC(String r8_NO_CON_DUB_KYC) {
		R8_NO_CON_DUB_KYC = r8_NO_CON_DUB_KYC;
	}

	public String getR8_NO_CON_SHJ_KYC() {
		return R8_NO_CON_SHJ_KYC;
	}

	public void setR8_NO_CON_SHJ_KYC(String r8_NO_CON_SHJ_KYC) {
		R8_NO_CON_SHJ_KYC = r8_NO_CON_SHJ_KYC;
	}

	public String getR8_NO_CON_AJM_KYC() {
		return R8_NO_CON_AJM_KYC;
	}

	public void setR8_NO_CON_AJM_KYC(String r8_NO_CON_AJM_KYC) {
		R8_NO_CON_AJM_KYC = r8_NO_CON_AJM_KYC;
	}

	public String getR8_NO_CON_FUJ_KYC() {
		return R8_NO_CON_FUJ_KYC;
	}

	public void setR8_NO_CON_FUJ_KYC(String r8_NO_CON_FUJ_KYC) {
		R8_NO_CON_FUJ_KYC = r8_NO_CON_FUJ_KYC;
	}

	public String getR8_NO_CON_RAK_KYC() {
		return R8_NO_CON_RAK_KYC;
	}

	public void setR8_NO_CON_RAK_KYC(String r8_NO_CON_RAK_KYC) {
		R8_NO_CON_RAK_KYC = r8_NO_CON_RAK_KYC;
	}

	public String getR8_NO_CON_UAQ_KYC() {
		return R8_NO_CON_UAQ_KYC;
	}

	public void setR8_NO_CON_UAQ_KYC(String r8_NO_CON_UAQ_KYC) {
		R8_NO_CON_UAQ_KYC = r8_NO_CON_UAQ_KYC;
	}

	public String getR8_NO_CON_RET() {
		return R8_NO_CON_RET;
	}

	public void setR8_NO_CON_RET(String r8_NO_CON_RET) {
		R8_NO_CON_RET = r8_NO_CON_RET;
	}

	public String getR8_NO_CON_DBR_LIM() {
		return R8_NO_CON_DBR_LIM;
	}

	public void setR8_NO_CON_DBR_LIM(String r8_NO_CON_DBR_LIM) {
		R8_NO_CON_DBR_LIM = r8_NO_CON_DBR_LIM;
	}

	public String getR8_NO_UAE_CON_SPC_TP() {
		return R8_NO_UAE_CON_SPC_TP;
	}

	public void setR8_NO_UAE_CON_SPC_TP(String r8_NO_UAE_CON_SPC_TP) {
		R8_NO_UAE_CON_SPC_TP = r8_NO_UAE_CON_SPC_TP;
	}

	public String getR8_NO_UAE_CON_NLS() {
		return R8_NO_UAE_CON_NLS;
	}

	public void setR8_NO_UAE_CON_NLS(String r8_NO_UAE_CON_NLS) {
		R8_NO_UAE_CON_NLS = r8_NO_UAE_CON_NLS;
	}

	public String getR8_VAL_LOS_AED() {
		return R8_VAL_LOS_AED;
	}

	public void setR8_VAL_LOS_AED(String r8_VAL_LOS_AED) {
		R8_VAL_LOS_AED = r8_VAL_LOS_AED;
	}

	public String getR8_NO_CON_ONB_90() {
		return R8_NO_CON_ONB_90;
	}

	public void setR8_NO_CON_ONB_90(String r8_NO_CON_ONB_90) {
		R8_NO_CON_ONB_90 = r8_NO_CON_ONB_90;
	}

	public String getR8_NO_CON_BAL_PAY() {
		return R8_NO_CON_BAL_PAY;
	}

	public void setR8_NO_CON_BAL_PAY(String r8_NO_CON_BAL_PAY) {
		R8_NO_CON_BAL_PAY = r8_NO_CON_BAL_PAY;
	}

	public String getR8_NO_CON_BAL_SPC_TP() {
		return R8_NO_CON_BAL_SPC_TP;
	}

	public void setR8_NO_CON_BAL_SPC_TP(String r8_NO_CON_BAL_SPC_TP) {
		R8_NO_CON_BAL_SPC_TP = r8_NO_CON_BAL_SPC_TP;
	}

	public String getR8_NO_CON_DEBT() {
		return R8_NO_CON_DEBT;
	}

	public void setR8_NO_CON_DEBT(String r8_NO_CON_DEBT) {
		R8_NO_CON_DEBT = r8_NO_CON_DEBT;
	}

	public String getR8_NO_CON_ONB_REF() {
		return R8_NO_CON_ONB_REF;
	}

	public void setR8_NO_CON_ONB_REF(String r8_NO_CON_ONB_REF) {
		R8_NO_CON_ONB_REF = r8_NO_CON_ONB_REF;
	}

	public String getR8_NO_CON_ONB_AGE() {
		return R8_NO_CON_ONB_AGE;
	}

	public void setR8_NO_CON_ONB_AGE(String r8_NO_CON_ONB_AGE) {
		R8_NO_CON_ONB_AGE = r8_NO_CON_ONB_AGE;
	}

	public String getR8_NO_CON_AFF_UNAU() {
		return R8_NO_CON_AFF_UNAU;
	}

	public void setR8_NO_CON_AFF_UNAU(String r8_NO_CON_AFF_UNAU) {
		R8_NO_CON_AFF_UNAU = r8_NO_CON_AFF_UNAU;
	}

	public String getR8_NO_OF_ACCS_POD() {
		return R8_NO_OF_ACCS_POD;
	}

	public void setR8_NO_OF_ACCS_POD(String r8_NO_OF_ACCS_POD) {
		R8_NO_OF_ACCS_POD = r8_NO_OF_ACCS_POD;
	}

	public String getR8_NO_DEL_CON() {
		return R8_NO_DEL_CON;
	}

	public void setR8_NO_DEL_CON(String r8_NO_DEL_CON) {
		R8_NO_DEL_CON = r8_NO_DEL_CON;
	}

	public String getR8_NO_INS_FUN_LFI() {
		return R8_NO_INS_FUN_LFI;
	}

	public void setR8_NO_INS_FUN_LFI(String r8_NO_INS_FUN_LFI) {
		R8_NO_INS_FUN_LFI = r8_NO_INS_FUN_LFI;
	}

	public String getR8_NO_CON_COL_FIN() {
		return R8_NO_CON_COL_FIN;
	}

	public void setR8_NO_CON_COL_FIN(String r8_NO_CON_COL_FIN) {
		R8_NO_CON_COL_FIN = r8_NO_CON_COL_FIN;
	}

	public String getR8_TOT_NO_NEW_FIN() {
		return R8_TOT_NO_NEW_FIN;
	}

	public void setR8_TOT_NO_NEW_FIN(String r8_TOT_NO_NEW_FIN) {
		R8_TOT_NO_NEW_FIN = r8_TOT_NO_NEW_FIN;
	}

	public String getR8_TOT_NO_NEW_NOSGN() {
		return R8_TOT_NO_NEW_NOSGN;
	}

	public void setR8_TOT_NO_NEW_NOSGN(String r8_TOT_NO_NEW_NOSGN) {
		R8_TOT_NO_NEW_NOSGN = r8_TOT_NO_NEW_NOSGN;
	}

	public String getR8_NO_CON_START() {
		return R8_NO_CON_START;
	}

	public void setR8_NO_CON_START(String r8_NO_CON_START) {
		R8_NO_CON_START = r8_NO_CON_START;
	}

	public String getR8_NO_NEW_CON_ONBO() {
		return R8_NO_NEW_CON_ONBO;
	}

	public void setR8_NO_NEW_CON_ONBO(String r8_NO_NEW_CON_ONBO) {
		R8_NO_NEW_CON_ONBO = r8_NO_NEW_CON_ONBO;
	}

	public String getR8_NO_CON_DEBT_COUN() {
		return R8_NO_CON_DEBT_COUN;
	}

	public void setR8_NO_CON_DEBT_COUN(String r8_NO_CON_DEBT_COUN) {
		R8_NO_CON_DEBT_COUN = r8_NO_CON_DEBT_COUN;
	}

	public String getR8_NO_CON_DEL_NPA() {
		return R8_NO_CON_DEL_NPA;
	}

	public void setR8_NO_CON_DEL_NPA(String r8_NO_CON_DEL_NPA) {
		R8_NO_CON_DEL_NPA = r8_NO_CON_DEL_NPA;
	}

	public String getR8_NO_CON_GOV_50() {
		return R8_NO_CON_GOV_50;
	}

	public void setR8_NO_CON_GOV_50(String r8_NO_CON_GOV_50) {
		R8_NO_CON_GOV_50 = r8_NO_CON_GOV_50;
	}

	public String getR8_NO_SME_SOLE() {
		return R8_NO_SME_SOLE;
	}

	public void setR8_NO_SME_SOLE(String r8_NO_SME_SOLE) {
		R8_NO_SME_SOLE = r8_NO_SME_SOLE;
	}

	public String getR8_NO_CON_TAG_VUL() {
		return R8_NO_CON_TAG_VUL;
	}

	public void setR8_NO_CON_TAG_VUL(String r8_NO_CON_TAG_VUL) {
		R8_NO_CON_TAG_VUL = r8_NO_CON_TAG_VUL;
	}

	public String getR8_NO_NEW_CON_ONB_GNP() {
		return R8_NO_NEW_CON_ONB_GNP;
	}

	public void setR8_NO_NEW_CON_ONB_GNP(String r8_NO_NEW_CON_ONB_GNP) {
		R8_NO_NEW_CON_ONB_GNP = r8_NO_NEW_CON_ONB_GNP;
	}

	public String getR8_NO_CON_END() {
		return R8_NO_CON_END;
	}

	public void setR8_NO_CON_END(String r8_NO_CON_END) {
		R8_NO_CON_END = r8_NO_CON_END;
	}

	public String getR9_BANK() {
		return R9_BANK;
	}

	public void setR9_BANK(String r9_BANK) {
		R9_BANK = r9_BANK;
	}

	public String getR9_PRODUCT() {
		return R9_PRODUCT;
	}

	public void setR9_PRODUCT(String r9_PRODUCT) {
		R9_PRODUCT = r9_PRODUCT;
	}

	public String getR9_NO_WO_SD() {
		return R9_NO_WO_SD;
	}

	public void setR9_NO_WO_SD(String r9_NO_WO_SD) {
		R9_NO_WO_SD = r9_NO_WO_SD;
	}

	public String getR9_NO_CON_POD_SD() {
		return R9_NO_CON_POD_SD;
	}

	public void setR9_NO_CON_POD_SD(String r9_NO_CON_POD_SD) {
		R9_NO_CON_POD_SD = r9_NO_CON_POD_SD;
	}

	public String getR9_NO_CON_UNAU_SP_TP() {
		return R9_NO_CON_UNAU_SP_TP;
	}

	public void setR9_NO_CON_UNAU_SP_TP(String r9_NO_CON_UNAU_SP_TP) {
		R9_NO_CON_UNAU_SP_TP = r9_NO_CON_UNAU_SP_TP;
	}

	public String getR9_NO_CON_45_50() {
		return R9_NO_CON_45_50;
	}

	public void setR9_NO_CON_45_50(String r9_NO_CON_45_50) {
		R9_NO_CON_45_50 = r9_NO_CON_45_50;
	}

	public String getR9_NO_CON_50() {
		return R9_NO_CON_50;
	}

	public void setR9_NO_CON_50(String r9_NO_CON_50) {
		R9_NO_CON_50 = r9_NO_CON_50;
	}

	public String getR9_NO_OF_LES_50() {
		return R9_NO_OF_LES_50;
	}

	public void setR9_NO_OF_LES_50(String r9_NO_OF_LES_50) {
		R9_NO_OF_LES_50 = r9_NO_OF_LES_50;
	}

	public String getR9_NO_OF_BNK_18() {
		return R9_NO_OF_BNK_18;
	}

	public void setR9_NO_OF_BNK_18(String r9_NO_OF_BNK_18) {
		R9_NO_OF_BNK_18 = r9_NO_OF_BNK_18;
	}

	public String getR9_NO_OF_BNK_18_25() {
		return R9_NO_OF_BNK_18_25;
	}

	public void setR9_NO_OF_BNK_18_25(String r9_NO_OF_BNK_18_25) {
		R9_NO_OF_BNK_18_25 = r9_NO_OF_BNK_18_25;
	}

	public String getR9_NO_OF_BNK_26_35() {
		return R9_NO_OF_BNK_26_35;
	}

	public void setR9_NO_OF_BNK_26_35(String r9_NO_OF_BNK_26_35) {
		R9_NO_OF_BNK_26_35 = r9_NO_OF_BNK_26_35;
	}

	public String getR9_NO_OF_BNK_36_50() {
		return R9_NO_OF_BNK_36_50;
	}

	public void setR9_NO_OF_BNK_36_50(String r9_NO_OF_BNK_36_50) {
		R9_NO_OF_BNK_36_50 = r9_NO_OF_BNK_36_50;
	}

	public String getR9_NO_CON_BNK_50() {
		return R9_NO_CON_BNK_50;
	}

	public void setR9_NO_CON_BNK_50(String r9_NO_CON_BNK_50) {
		R9_NO_CON_BNK_50 = r9_NO_CON_BNK_50;
	}

	public String getR9_NO_CON_SAL_SPD() {
		return R9_NO_CON_SAL_SPD;
	}

	public void setR9_NO_CON_SAL_SPD(String r9_NO_CON_SAL_SPD) {
		R9_NO_CON_SAL_SPD = r9_NO_CON_SAL_SPD;
	}

	public String getR9_NO_CON_BUS_SPD() {
		return R9_NO_CON_BUS_SPD;
	}

	public void setR9_NO_CON_BUS_SPD(String r9_NO_CON_BUS_SPD) {
		R9_NO_CON_BUS_SPD = r9_NO_CON_BUS_SPD;
	}

	public String getR9_NO_CON_PRO_SPD() {
		return R9_NO_CON_PRO_SPD;
	}

	public void setR9_NO_CON_PRO_SPD(String r9_NO_CON_PRO_SPD) {
		R9_NO_CON_PRO_SPD = r9_NO_CON_PRO_SPD;
	}

	public String getR9_NO_CON_INC_5K() {
		return R9_NO_CON_INC_5K;
	}

	public void setR9_NO_CON_INC_5K(String r9_NO_CON_INC_5K) {
		R9_NO_CON_INC_5K = r9_NO_CON_INC_5K;
	}

	public String getR9_NO_CON_INC_5K_10K() {
		return R9_NO_CON_INC_5K_10K;
	}

	public void setR9_NO_CON_INC_5K_10K(String r9_NO_CON_INC_5K_10K) {
		R9_NO_CON_INC_5K_10K = r9_NO_CON_INC_5K_10K;
	}

	public String getR9_NO_CON_INC_10K_20K() {
		return R9_NO_CON_INC_10K_20K;
	}

	public void setR9_NO_CON_INC_10K_20K(String r9_NO_CON_INC_10K_20K) {
		R9_NO_CON_INC_10K_20K = r9_NO_CON_INC_10K_20K;
	}

	public String getR9_NO_CON_INC_20K_35K() {
		return R9_NO_CON_INC_20K_35K;
	}

	public void setR9_NO_CON_INC_20K_35K(String r9_NO_CON_INC_20K_35K) {
		R9_NO_CON_INC_20K_35K = r9_NO_CON_INC_20K_35K;
	}

	public String getR9_NO_CON_INC_35K() {
		return R9_NO_CON_INC_35K;
	}

	public void setR9_NO_CON_INC_35K(String r9_NO_CON_INC_35K) {
		R9_NO_CON_INC_35K = r9_NO_CON_INC_35K;
	}

	public String getR9_NO_CON_BEL_SCL() {
		return R9_NO_CON_BEL_SCL;
	}

	public void setR9_NO_CON_BEL_SCL(String r9_NO_CON_BEL_SCL) {
		R9_NO_CON_BEL_SCL = r9_NO_CON_BEL_SCL;
	}

	public String getR9_NO_CON_BAC() {
		return R9_NO_CON_BAC;
	}

	public void setR9_NO_CON_BAC(String r9_NO_CON_BAC) {
		R9_NO_CON_BAC = r9_NO_CON_BAC;
	}

	public String getR9_NO_CON_ABV_MAS() {
		return R9_NO_CON_ABV_MAS;
	}

	public void setR9_NO_CON_ABV_MAS(String r9_NO_CON_ABV_MAS) {
		R9_NO_CON_ABV_MAS = r9_NO_CON_ABV_MAS;
	}

	public String getR9_NO_CON_ABU_KYC() {
		return R9_NO_CON_ABU_KYC;
	}

	public void setR9_NO_CON_ABU_KYC(String r9_NO_CON_ABU_KYC) {
		R9_NO_CON_ABU_KYC = r9_NO_CON_ABU_KYC;
	}

	public String getR9_NO_CON_DUB_KYC() {
		return R9_NO_CON_DUB_KYC;
	}

	public void setR9_NO_CON_DUB_KYC(String r9_NO_CON_DUB_KYC) {
		R9_NO_CON_DUB_KYC = r9_NO_CON_DUB_KYC;
	}

	public String getR9_NO_CON_SHJ_KYC() {
		return R9_NO_CON_SHJ_KYC;
	}

	public void setR9_NO_CON_SHJ_KYC(String r9_NO_CON_SHJ_KYC) {
		R9_NO_CON_SHJ_KYC = r9_NO_CON_SHJ_KYC;
	}

	public String getR9_NO_CON_AJM_KYC() {
		return R9_NO_CON_AJM_KYC;
	}

	public void setR9_NO_CON_AJM_KYC(String r9_NO_CON_AJM_KYC) {
		R9_NO_CON_AJM_KYC = r9_NO_CON_AJM_KYC;
	}

	public String getR9_NO_CON_FUJ_KYC() {
		return R9_NO_CON_FUJ_KYC;
	}

	public void setR9_NO_CON_FUJ_KYC(String r9_NO_CON_FUJ_KYC) {
		R9_NO_CON_FUJ_KYC = r9_NO_CON_FUJ_KYC;
	}

	public String getR9_NO_CON_RAK_KYC() {
		return R9_NO_CON_RAK_KYC;
	}

	public void setR9_NO_CON_RAK_KYC(String r9_NO_CON_RAK_KYC) {
		R9_NO_CON_RAK_KYC = r9_NO_CON_RAK_KYC;
	}

	public String getR9_NO_CON_UAQ_KYC() {
		return R9_NO_CON_UAQ_KYC;
	}

	public void setR9_NO_CON_UAQ_KYC(String r9_NO_CON_UAQ_KYC) {
		R9_NO_CON_UAQ_KYC = r9_NO_CON_UAQ_KYC;
	}

	public String getR9_NO_CON_RET() {
		return R9_NO_CON_RET;
	}

	public void setR9_NO_CON_RET(String r9_NO_CON_RET) {
		R9_NO_CON_RET = r9_NO_CON_RET;
	}

	public String getR9_NO_CON_DBR_LIM() {
		return R9_NO_CON_DBR_LIM;
	}

	public void setR9_NO_CON_DBR_LIM(String r9_NO_CON_DBR_LIM) {
		R9_NO_CON_DBR_LIM = r9_NO_CON_DBR_LIM;
	}

	public String getR9_NO_UAE_CON_SPC_TP() {
		return R9_NO_UAE_CON_SPC_TP;
	}

	public void setR9_NO_UAE_CON_SPC_TP(String r9_NO_UAE_CON_SPC_TP) {
		R9_NO_UAE_CON_SPC_TP = r9_NO_UAE_CON_SPC_TP;
	}

	public String getR9_NO_UAE_CON_NLS() {
		return R9_NO_UAE_CON_NLS;
	}

	public void setR9_NO_UAE_CON_NLS(String r9_NO_UAE_CON_NLS) {
		R9_NO_UAE_CON_NLS = r9_NO_UAE_CON_NLS;
	}

	public String getR9_VAL_LOS_AED() {
		return R9_VAL_LOS_AED;
	}

	public void setR9_VAL_LOS_AED(String r9_VAL_LOS_AED) {
		R9_VAL_LOS_AED = r9_VAL_LOS_AED;
	}

	public String getR9_NO_CON_ONB_90() {
		return R9_NO_CON_ONB_90;
	}

	public void setR9_NO_CON_ONB_90(String r9_NO_CON_ONB_90) {
		R9_NO_CON_ONB_90 = r9_NO_CON_ONB_90;
	}

	public String getR9_NO_CON_BAL_PAY() {
		return R9_NO_CON_BAL_PAY;
	}

	public void setR9_NO_CON_BAL_PAY(String r9_NO_CON_BAL_PAY) {
		R9_NO_CON_BAL_PAY = r9_NO_CON_BAL_PAY;
	}

	public String getR9_NO_CON_BAL_SPC_TP() {
		return R9_NO_CON_BAL_SPC_TP;
	}

	public void setR9_NO_CON_BAL_SPC_TP(String r9_NO_CON_BAL_SPC_TP) {
		R9_NO_CON_BAL_SPC_TP = r9_NO_CON_BAL_SPC_TP;
	}

	public String getR9_NO_CON_DEBT() {
		return R9_NO_CON_DEBT;
	}

	public void setR9_NO_CON_DEBT(String r9_NO_CON_DEBT) {
		R9_NO_CON_DEBT = r9_NO_CON_DEBT;
	}

	public String getR9_NO_CON_ONB_REF() {
		return R9_NO_CON_ONB_REF;
	}

	public void setR9_NO_CON_ONB_REF(String r9_NO_CON_ONB_REF) {
		R9_NO_CON_ONB_REF = r9_NO_CON_ONB_REF;
	}

	public String getR9_NO_CON_ONB_AGE() {
		return R9_NO_CON_ONB_AGE;
	}

	public void setR9_NO_CON_ONB_AGE(String r9_NO_CON_ONB_AGE) {
		R9_NO_CON_ONB_AGE = r9_NO_CON_ONB_AGE;
	}

	public String getR9_NO_CON_AFF_UNAU() {
		return R9_NO_CON_AFF_UNAU;
	}

	public void setR9_NO_CON_AFF_UNAU(String r9_NO_CON_AFF_UNAU) {
		R9_NO_CON_AFF_UNAU = r9_NO_CON_AFF_UNAU;
	}

	public String getR9_NO_OF_ACCS_POD() {
		return R9_NO_OF_ACCS_POD;
	}

	public void setR9_NO_OF_ACCS_POD(String r9_NO_OF_ACCS_POD) {
		R9_NO_OF_ACCS_POD = r9_NO_OF_ACCS_POD;
	}

	public String getR9_NO_DEL_CON() {
		return R9_NO_DEL_CON;
	}

	public void setR9_NO_DEL_CON(String r9_NO_DEL_CON) {
		R9_NO_DEL_CON = r9_NO_DEL_CON;
	}

	public String getR9_NO_INS_FUN_LFI() {
		return R9_NO_INS_FUN_LFI;
	}

	public void setR9_NO_INS_FUN_LFI(String r9_NO_INS_FUN_LFI) {
		R9_NO_INS_FUN_LFI = r9_NO_INS_FUN_LFI;
	}

	public String getR9_NO_CON_COL_FIN() {
		return R9_NO_CON_COL_FIN;
	}

	public void setR9_NO_CON_COL_FIN(String r9_NO_CON_COL_FIN) {
		R9_NO_CON_COL_FIN = r9_NO_CON_COL_FIN;
	}

	public String getR9_TOT_NO_NEW_FIN() {
		return R9_TOT_NO_NEW_FIN;
	}

	public void setR9_TOT_NO_NEW_FIN(String r9_TOT_NO_NEW_FIN) {
		R9_TOT_NO_NEW_FIN = r9_TOT_NO_NEW_FIN;
	}

	public String getR9_TOT_NO_NEW_NOSGN() {
		return R9_TOT_NO_NEW_NOSGN;
	}

	public void setR9_TOT_NO_NEW_NOSGN(String r9_TOT_NO_NEW_NOSGN) {
		R9_TOT_NO_NEW_NOSGN = r9_TOT_NO_NEW_NOSGN;
	}

	public String getR9_NO_CON_START() {
		return R9_NO_CON_START;
	}

	public void setR9_NO_CON_START(String r9_NO_CON_START) {
		R9_NO_CON_START = r9_NO_CON_START;
	}

	public String getR9_NO_NEW_CON_ONBO() {
		return R9_NO_NEW_CON_ONBO;
	}

	public void setR9_NO_NEW_CON_ONBO(String r9_NO_NEW_CON_ONBO) {
		R9_NO_NEW_CON_ONBO = r9_NO_NEW_CON_ONBO;
	}

	public String getR9_NO_CON_DEBT_COUN() {
		return R9_NO_CON_DEBT_COUN;
	}

	public void setR9_NO_CON_DEBT_COUN(String r9_NO_CON_DEBT_COUN) {
		R9_NO_CON_DEBT_COUN = r9_NO_CON_DEBT_COUN;
	}

	public String getR9_NO_CON_DEL_NPA() {
		return R9_NO_CON_DEL_NPA;
	}

	public void setR9_NO_CON_DEL_NPA(String r9_NO_CON_DEL_NPA) {
		R9_NO_CON_DEL_NPA = r9_NO_CON_DEL_NPA;
	}

	public String getR9_NO_CON_GOV_50() {
		return R9_NO_CON_GOV_50;
	}

	public void setR9_NO_CON_GOV_50(String r9_NO_CON_GOV_50) {
		R9_NO_CON_GOV_50 = r9_NO_CON_GOV_50;
	}

	public String getR9_NO_SME_SOLE() {
		return R9_NO_SME_SOLE;
	}

	public void setR9_NO_SME_SOLE(String r9_NO_SME_SOLE) {
		R9_NO_SME_SOLE = r9_NO_SME_SOLE;
	}

	public String getR9_NO_CON_TAG_VUL() {
		return R9_NO_CON_TAG_VUL;
	}

	public void setR9_NO_CON_TAG_VUL(String r9_NO_CON_TAG_VUL) {
		R9_NO_CON_TAG_VUL = r9_NO_CON_TAG_VUL;
	}

	public String getR9_NO_NEW_CON_ONB_GNP() {
		return R9_NO_NEW_CON_ONB_GNP;
	}

	public void setR9_NO_NEW_CON_ONB_GNP(String r9_NO_NEW_CON_ONB_GNP) {
		R9_NO_NEW_CON_ONB_GNP = r9_NO_NEW_CON_ONB_GNP;
	}

	public String getR9_NO_CON_END() {
		return R9_NO_CON_END;
	}

	public void setR9_NO_CON_END(String r9_NO_CON_END) {
		R9_NO_CON_END = r9_NO_CON_END;
	}

	public String getR10_BANK() {
		return R10_BANK;
	}

	public void setR10_BANK(String r10_BANK) {
		R10_BANK = r10_BANK;
	}

	public String getR10_PRODUCT() {
		return R10_PRODUCT;
	}

	public void setR10_PRODUCT(String r10_PRODUCT) {
		R10_PRODUCT = r10_PRODUCT;
	}

	public String getR10_NO_WO_SD() {
		return R10_NO_WO_SD;
	}

	public void setR10_NO_WO_SD(String r10_NO_WO_SD) {
		R10_NO_WO_SD = r10_NO_WO_SD;
	}

	public String getR10_NO_CON_POD_SD() {
		return R10_NO_CON_POD_SD;
	}

	public void setR10_NO_CON_POD_SD(String r10_NO_CON_POD_SD) {
		R10_NO_CON_POD_SD = r10_NO_CON_POD_SD;
	}

	public String getR10_NO_CON_UNAU_SP_TP() {
		return R10_NO_CON_UNAU_SP_TP;
	}

	public void setR10_NO_CON_UNAU_SP_TP(String r10_NO_CON_UNAU_SP_TP) {
		R10_NO_CON_UNAU_SP_TP = r10_NO_CON_UNAU_SP_TP;
	}

	public String getR10_NO_CON_45_50() {
		return R10_NO_CON_45_50;
	}

	public void setR10_NO_CON_45_50(String r10_NO_CON_45_50) {
		R10_NO_CON_45_50 = r10_NO_CON_45_50;
	}

	public String getR10_NO_CON_50() {
		return R10_NO_CON_50;
	}

	public void setR10_NO_CON_50(String r10_NO_CON_50) {
		R10_NO_CON_50 = r10_NO_CON_50;
	}

	public String getR10_NO_OF_LES_50() {
		return R10_NO_OF_LES_50;
	}

	public void setR10_NO_OF_LES_50(String r10_NO_OF_LES_50) {
		R10_NO_OF_LES_50 = r10_NO_OF_LES_50;
	}

	public String getR10_NO_OF_BNK_18() {
		return R10_NO_OF_BNK_18;
	}

	public void setR10_NO_OF_BNK_18(String r10_NO_OF_BNK_18) {
		R10_NO_OF_BNK_18 = r10_NO_OF_BNK_18;
	}

	public String getR10_NO_OF_BNK_18_25() {
		return R10_NO_OF_BNK_18_25;
	}

	public void setR10_NO_OF_BNK_18_25(String r10_NO_OF_BNK_18_25) {
		R10_NO_OF_BNK_18_25 = r10_NO_OF_BNK_18_25;
	}

	public String getR10_NO_OF_BNK_26_35() {
		return R10_NO_OF_BNK_26_35;
	}

	public void setR10_NO_OF_BNK_26_35(String r10_NO_OF_BNK_26_35) {
		R10_NO_OF_BNK_26_35 = r10_NO_OF_BNK_26_35;
	}

	public String getR10_NO_OF_BNK_36_50() {
		return R10_NO_OF_BNK_36_50;
	}

	public void setR10_NO_OF_BNK_36_50(String r10_NO_OF_BNK_36_50) {
		R10_NO_OF_BNK_36_50 = r10_NO_OF_BNK_36_50;
	}

	public String getR10_NO_CON_BNK_50() {
		return R10_NO_CON_BNK_50;
	}

	public void setR10_NO_CON_BNK_50(String r10_NO_CON_BNK_50) {
		R10_NO_CON_BNK_50 = r10_NO_CON_BNK_50;
	}

	public String getR10_NO_CON_SAL_SPD() {
		return R10_NO_CON_SAL_SPD;
	}

	public void setR10_NO_CON_SAL_SPD(String r10_NO_CON_SAL_SPD) {
		R10_NO_CON_SAL_SPD = r10_NO_CON_SAL_SPD;
	}

	public String getR10_NO_CON_BUS_SPD() {
		return R10_NO_CON_BUS_SPD;
	}

	public void setR10_NO_CON_BUS_SPD(String r10_NO_CON_BUS_SPD) {
		R10_NO_CON_BUS_SPD = r10_NO_CON_BUS_SPD;
	}

	public String getR10_NO_CON_PRO_SPD() {
		return R10_NO_CON_PRO_SPD;
	}

	public void setR10_NO_CON_PRO_SPD(String r10_NO_CON_PRO_SPD) {
		R10_NO_CON_PRO_SPD = r10_NO_CON_PRO_SPD;
	}

	public String getR10_NO_CON_INC_5K() {
		return R10_NO_CON_INC_5K;
	}

	public void setR10_NO_CON_INC_5K(String r10_NO_CON_INC_5K) {
		R10_NO_CON_INC_5K = r10_NO_CON_INC_5K;
	}

	public String getR10_NO_CON_INC_5K_10K() {
		return R10_NO_CON_INC_5K_10K;
	}

	public void setR10_NO_CON_INC_5K_10K(String r10_NO_CON_INC_5K_10K) {
		R10_NO_CON_INC_5K_10K = r10_NO_CON_INC_5K_10K;
	}

	public String getR10_NO_CON_INC_10K_20K() {
		return R10_NO_CON_INC_10K_20K;
	}

	public void setR10_NO_CON_INC_10K_20K(String r10_NO_CON_INC_10K_20K) {
		R10_NO_CON_INC_10K_20K = r10_NO_CON_INC_10K_20K;
	}

	public String getR10_NO_CON_INC_20K_35K() {
		return R10_NO_CON_INC_20K_35K;
	}

	public void setR10_NO_CON_INC_20K_35K(String r10_NO_CON_INC_20K_35K) {
		R10_NO_CON_INC_20K_35K = r10_NO_CON_INC_20K_35K;
	}

	public String getR10_NO_CON_INC_35K() {
		return R10_NO_CON_INC_35K;
	}

	public void setR10_NO_CON_INC_35K(String r10_NO_CON_INC_35K) {
		R10_NO_CON_INC_35K = r10_NO_CON_INC_35K;
	}

	public String getR10_NO_CON_BEL_SCL() {
		return R10_NO_CON_BEL_SCL;
	}

	public void setR10_NO_CON_BEL_SCL(String r10_NO_CON_BEL_SCL) {
		R10_NO_CON_BEL_SCL = r10_NO_CON_BEL_SCL;
	}

	public String getR10_NO_CON_BAC() {
		return R10_NO_CON_BAC;
	}

	public void setR10_NO_CON_BAC(String r10_NO_CON_BAC) {
		R10_NO_CON_BAC = r10_NO_CON_BAC;
	}

	public String getR10_NO_CON_ABV_MAS() {
		return R10_NO_CON_ABV_MAS;
	}

	public void setR10_NO_CON_ABV_MAS(String r10_NO_CON_ABV_MAS) {
		R10_NO_CON_ABV_MAS = r10_NO_CON_ABV_MAS;
	}

	public String getR10_NO_CON_ABU_KYC() {
		return R10_NO_CON_ABU_KYC;
	}

	public void setR10_NO_CON_ABU_KYC(String r10_NO_CON_ABU_KYC) {
		R10_NO_CON_ABU_KYC = r10_NO_CON_ABU_KYC;
	}

	public String getR10_NO_CON_DUB_KYC() {
		return R10_NO_CON_DUB_KYC;
	}

	public void setR10_NO_CON_DUB_KYC(String r10_NO_CON_DUB_KYC) {
		R10_NO_CON_DUB_KYC = r10_NO_CON_DUB_KYC;
	}

	public String getR10_NO_CON_SHJ_KYC() {
		return R10_NO_CON_SHJ_KYC;
	}

	public void setR10_NO_CON_SHJ_KYC(String r10_NO_CON_SHJ_KYC) {
		R10_NO_CON_SHJ_KYC = r10_NO_CON_SHJ_KYC;
	}

	public String getR10_NO_CON_AJM_KYC() {
		return R10_NO_CON_AJM_KYC;
	}

	public void setR10_NO_CON_AJM_KYC(String r10_NO_CON_AJM_KYC) {
		R10_NO_CON_AJM_KYC = r10_NO_CON_AJM_KYC;
	}

	public String getR10_NO_CON_FUJ_KYC() {
		return R10_NO_CON_FUJ_KYC;
	}

	public void setR10_NO_CON_FUJ_KYC(String r10_NO_CON_FUJ_KYC) {
		R10_NO_CON_FUJ_KYC = r10_NO_CON_FUJ_KYC;
	}

	public String getR10_NO_CON_RAK_KYC() {
		return R10_NO_CON_RAK_KYC;
	}

	public void setR10_NO_CON_RAK_KYC(String r10_NO_CON_RAK_KYC) {
		R10_NO_CON_RAK_KYC = r10_NO_CON_RAK_KYC;
	}

	public String getR10_NO_CON_UAQ_KYC() {
		return R10_NO_CON_UAQ_KYC;
	}

	public void setR10_NO_CON_UAQ_KYC(String r10_NO_CON_UAQ_KYC) {
		R10_NO_CON_UAQ_KYC = r10_NO_CON_UAQ_KYC;
	}

	public String getR10_NO_CON_RET() {
		return R10_NO_CON_RET;
	}

	public void setR10_NO_CON_RET(String r10_NO_CON_RET) {
		R10_NO_CON_RET = r10_NO_CON_RET;
	}

	public String getR10_NO_CON_DBR_LIM() {
		return R10_NO_CON_DBR_LIM;
	}

	public void setR10_NO_CON_DBR_LIM(String r10_NO_CON_DBR_LIM) {
		R10_NO_CON_DBR_LIM = r10_NO_CON_DBR_LIM;
	}

	public String getR10_NO_UAE_CON_SPC_TP() {
		return R10_NO_UAE_CON_SPC_TP;
	}

	public void setR10_NO_UAE_CON_SPC_TP(String r10_NO_UAE_CON_SPC_TP) {
		R10_NO_UAE_CON_SPC_TP = r10_NO_UAE_CON_SPC_TP;
	}

	public String getR10_NO_UAE_CON_NLS() {
		return R10_NO_UAE_CON_NLS;
	}

	public void setR10_NO_UAE_CON_NLS(String r10_NO_UAE_CON_NLS) {
		R10_NO_UAE_CON_NLS = r10_NO_UAE_CON_NLS;
	}

	public String getR10_VAL_LOS_AED() {
		return R10_VAL_LOS_AED;
	}

	public void setR10_VAL_LOS_AED(String r10_VAL_LOS_AED) {
		R10_VAL_LOS_AED = r10_VAL_LOS_AED;
	}

	public String getR10_NO_CON_ONB_90() {
		return R10_NO_CON_ONB_90;
	}

	public void setR10_NO_CON_ONB_90(String r10_NO_CON_ONB_90) {
		R10_NO_CON_ONB_90 = r10_NO_CON_ONB_90;
	}

	public String getR10_NO_CON_BAL_PAY() {
		return R10_NO_CON_BAL_PAY;
	}

	public void setR10_NO_CON_BAL_PAY(String r10_NO_CON_BAL_PAY) {
		R10_NO_CON_BAL_PAY = r10_NO_CON_BAL_PAY;
	}

	public String getR10_NO_CON_BAL_SPC_TP() {
		return R10_NO_CON_BAL_SPC_TP;
	}

	public void setR10_NO_CON_BAL_SPC_TP(String r10_NO_CON_BAL_SPC_TP) {
		R10_NO_CON_BAL_SPC_TP = r10_NO_CON_BAL_SPC_TP;
	}

	public String getR10_NO_CON_DEBT() {
		return R10_NO_CON_DEBT;
	}

	public void setR10_NO_CON_DEBT(String r10_NO_CON_DEBT) {
		R10_NO_CON_DEBT = r10_NO_CON_DEBT;
	}

	public String getR10_NO_CON_ONB_REF() {
		return R10_NO_CON_ONB_REF;
	}

	public void setR10_NO_CON_ONB_REF(String r10_NO_CON_ONB_REF) {
		R10_NO_CON_ONB_REF = r10_NO_CON_ONB_REF;
	}

	public String getR10_NO_CON_ONB_AGE() {
		return R10_NO_CON_ONB_AGE;
	}

	public void setR10_NO_CON_ONB_AGE(String r10_NO_CON_ONB_AGE) {
		R10_NO_CON_ONB_AGE = r10_NO_CON_ONB_AGE;
	}

	public String getR10_NO_CON_AFF_UNAU() {
		return R10_NO_CON_AFF_UNAU;
	}

	public void setR10_NO_CON_AFF_UNAU(String r10_NO_CON_AFF_UNAU) {
		R10_NO_CON_AFF_UNAU = r10_NO_CON_AFF_UNAU;
	}

	public String getR10_NO_OF_ACCS_POD() {
		return R10_NO_OF_ACCS_POD;
	}

	public void setR10_NO_OF_ACCS_POD(String r10_NO_OF_ACCS_POD) {
		R10_NO_OF_ACCS_POD = r10_NO_OF_ACCS_POD;
	}

	public String getR10_NO_DEL_CON() {
		return R10_NO_DEL_CON;
	}

	public void setR10_NO_DEL_CON(String r10_NO_DEL_CON) {
		R10_NO_DEL_CON = r10_NO_DEL_CON;
	}

	public String getR10_NO_INS_FUN_LFI() {
		return R10_NO_INS_FUN_LFI;
	}

	public void setR10_NO_INS_FUN_LFI(String r10_NO_INS_FUN_LFI) {
		R10_NO_INS_FUN_LFI = r10_NO_INS_FUN_LFI;
	}

	public String getR10_NO_CON_COL_FIN() {
		return R10_NO_CON_COL_FIN;
	}

	public void setR10_NO_CON_COL_FIN(String r10_NO_CON_COL_FIN) {
		R10_NO_CON_COL_FIN = r10_NO_CON_COL_FIN;
	}

	public String getR10_TOT_NO_NEW_FIN() {
		return R10_TOT_NO_NEW_FIN;
	}

	public void setR10_TOT_NO_NEW_FIN(String r10_TOT_NO_NEW_FIN) {
		R10_TOT_NO_NEW_FIN = r10_TOT_NO_NEW_FIN;
	}

	public String getR10_TOT_NO_NEW_NOSGN() {
		return R10_TOT_NO_NEW_NOSGN;
	}

	public void setR10_TOT_NO_NEW_NOSGN(String r10_TOT_NO_NEW_NOSGN) {
		R10_TOT_NO_NEW_NOSGN = r10_TOT_NO_NEW_NOSGN;
	}

	public String getR10_NO_CON_START() {
		return R10_NO_CON_START;
	}

	public void setR10_NO_CON_START(String r10_NO_CON_START) {
		R10_NO_CON_START = r10_NO_CON_START;
	}

	public String getR10_NO_NEW_CON_ONBO() {
		return R10_NO_NEW_CON_ONBO;
	}

	public void setR10_NO_NEW_CON_ONBO(String r10_NO_NEW_CON_ONBO) {
		R10_NO_NEW_CON_ONBO = r10_NO_NEW_CON_ONBO;
	}

	public String getR10_NO_CON_DEBT_COUN() {
		return R10_NO_CON_DEBT_COUN;
	}

	public void setR10_NO_CON_DEBT_COUN(String r10_NO_CON_DEBT_COUN) {
		R10_NO_CON_DEBT_COUN = r10_NO_CON_DEBT_COUN;
	}

	public String getR10_NO_CON_DEL_NPA() {
		return R10_NO_CON_DEL_NPA;
	}

	public void setR10_NO_CON_DEL_NPA(String r10_NO_CON_DEL_NPA) {
		R10_NO_CON_DEL_NPA = r10_NO_CON_DEL_NPA;
	}

	public String getR10_NO_CON_GOV_50() {
		return R10_NO_CON_GOV_50;
	}

	public void setR10_NO_CON_GOV_50(String r10_NO_CON_GOV_50) {
		R10_NO_CON_GOV_50 = r10_NO_CON_GOV_50;
	}

	public String getR10_NO_SME_SOLE() {
		return R10_NO_SME_SOLE;
	}

	public void setR10_NO_SME_SOLE(String r10_NO_SME_SOLE) {
		R10_NO_SME_SOLE = r10_NO_SME_SOLE;
	}

	public String getR10_NO_CON_TAG_VUL() {
		return R10_NO_CON_TAG_VUL;
	}

	public void setR10_NO_CON_TAG_VUL(String r10_NO_CON_TAG_VUL) {
		R10_NO_CON_TAG_VUL = r10_NO_CON_TAG_VUL;
	}

	public String getR10_NO_NEW_CON_ONB_GNP() {
		return R10_NO_NEW_CON_ONB_GNP;
	}

	public void setR10_NO_NEW_CON_ONB_GNP(String r10_NO_NEW_CON_ONB_GNP) {
		R10_NO_NEW_CON_ONB_GNP = r10_NO_NEW_CON_ONB_GNP;
	}

	public String getR10_NO_CON_END() {
		return R10_NO_CON_END;
	}

	public void setR10_NO_CON_END(String r10_NO_CON_END) {
		R10_NO_CON_END = r10_NO_CON_END;
	}

	public String getR11_BANK() {
		return R11_BANK;
	}

	public void setR11_BANK(String r11_BANK) {
		R11_BANK = r11_BANK;
	}

	public String getR11_PRODUCT() {
		return R11_PRODUCT;
	}

	public void setR11_PRODUCT(String r11_PRODUCT) {
		R11_PRODUCT = r11_PRODUCT;
	}

	public String getR11_NO_WO_SD() {
		return R11_NO_WO_SD;
	}

	public void setR11_NO_WO_SD(String r11_NO_WO_SD) {
		R11_NO_WO_SD = r11_NO_WO_SD;
	}

	public String getR11_NO_CON_POD_SD() {
		return R11_NO_CON_POD_SD;
	}

	public void setR11_NO_CON_POD_SD(String r11_NO_CON_POD_SD) {
		R11_NO_CON_POD_SD = r11_NO_CON_POD_SD;
	}

	public String getR11_NO_CON_UNAU_SP_TP() {
		return R11_NO_CON_UNAU_SP_TP;
	}

	public void setR11_NO_CON_UNAU_SP_TP(String r11_NO_CON_UNAU_SP_TP) {
		R11_NO_CON_UNAU_SP_TP = r11_NO_CON_UNAU_SP_TP;
	}

	public String getR11_NO_CON_45_50() {
		return R11_NO_CON_45_50;
	}

	public void setR11_NO_CON_45_50(String r11_NO_CON_45_50) {
		R11_NO_CON_45_50 = r11_NO_CON_45_50;
	}

	public String getR11_NO_CON_50() {
		return R11_NO_CON_50;
	}

	public void setR11_NO_CON_50(String r11_NO_CON_50) {
		R11_NO_CON_50 = r11_NO_CON_50;
	}

	public String getR11_NO_OF_LES_50() {
		return R11_NO_OF_LES_50;
	}

	public void setR11_NO_OF_LES_50(String r11_NO_OF_LES_50) {
		R11_NO_OF_LES_50 = r11_NO_OF_LES_50;
	}

	public String getR11_NO_OF_BNK_18() {
		return R11_NO_OF_BNK_18;
	}

	public void setR11_NO_OF_BNK_18(String r11_NO_OF_BNK_18) {
		R11_NO_OF_BNK_18 = r11_NO_OF_BNK_18;
	}

	public String getR11_NO_OF_BNK_18_25() {
		return R11_NO_OF_BNK_18_25;
	}

	public void setR11_NO_OF_BNK_18_25(String r11_NO_OF_BNK_18_25) {
		R11_NO_OF_BNK_18_25 = r11_NO_OF_BNK_18_25;
	}

	public String getR11_NO_OF_BNK_26_35() {
		return R11_NO_OF_BNK_26_35;
	}

	public void setR11_NO_OF_BNK_26_35(String r11_NO_OF_BNK_26_35) {
		R11_NO_OF_BNK_26_35 = r11_NO_OF_BNK_26_35;
	}

	public String getR11_NO_OF_BNK_36_50() {
		return R11_NO_OF_BNK_36_50;
	}

	public void setR11_NO_OF_BNK_36_50(String r11_NO_OF_BNK_36_50) {
		R11_NO_OF_BNK_36_50 = r11_NO_OF_BNK_36_50;
	}

	public String getR11_NO_CON_BNK_50() {
		return R11_NO_CON_BNK_50;
	}

	public void setR11_NO_CON_BNK_50(String r11_NO_CON_BNK_50) {
		R11_NO_CON_BNK_50 = r11_NO_CON_BNK_50;
	}

	public String getR11_NO_CON_SAL_SPD() {
		return R11_NO_CON_SAL_SPD;
	}

	public void setR11_NO_CON_SAL_SPD(String r11_NO_CON_SAL_SPD) {
		R11_NO_CON_SAL_SPD = r11_NO_CON_SAL_SPD;
	}

	public String getR11_NO_CON_BUS_SPD() {
		return R11_NO_CON_BUS_SPD;
	}

	public void setR11_NO_CON_BUS_SPD(String r11_NO_CON_BUS_SPD) {
		R11_NO_CON_BUS_SPD = r11_NO_CON_BUS_SPD;
	}

	public String getR11_NO_CON_PRO_SPD() {
		return R11_NO_CON_PRO_SPD;
	}

	public void setR11_NO_CON_PRO_SPD(String r11_NO_CON_PRO_SPD) {
		R11_NO_CON_PRO_SPD = r11_NO_CON_PRO_SPD;
	}

	public String getR11_NO_CON_INC_5K() {
		return R11_NO_CON_INC_5K;
	}

	public void setR11_NO_CON_INC_5K(String r11_NO_CON_INC_5K) {
		R11_NO_CON_INC_5K = r11_NO_CON_INC_5K;
	}

	public String getR11_NO_CON_INC_5K_10K() {
		return R11_NO_CON_INC_5K_10K;
	}

	public void setR11_NO_CON_INC_5K_10K(String r11_NO_CON_INC_5K_10K) {
		R11_NO_CON_INC_5K_10K = r11_NO_CON_INC_5K_10K;
	}

	public String getR11_NO_CON_INC_10K_20K() {
		return R11_NO_CON_INC_10K_20K;
	}

	public void setR11_NO_CON_INC_10K_20K(String r11_NO_CON_INC_10K_20K) {
		R11_NO_CON_INC_10K_20K = r11_NO_CON_INC_10K_20K;
	}

	public String getR11_NO_CON_INC_20K_35K() {
		return R11_NO_CON_INC_20K_35K;
	}

	public void setR11_NO_CON_INC_20K_35K(String r11_NO_CON_INC_20K_35K) {
		R11_NO_CON_INC_20K_35K = r11_NO_CON_INC_20K_35K;
	}

	public String getR11_NO_CON_INC_35K() {
		return R11_NO_CON_INC_35K;
	}

	public void setR11_NO_CON_INC_35K(String r11_NO_CON_INC_35K) {
		R11_NO_CON_INC_35K = r11_NO_CON_INC_35K;
	}

	public String getR11_NO_CON_BEL_SCL() {
		return R11_NO_CON_BEL_SCL;
	}

	public void setR11_NO_CON_BEL_SCL(String r11_NO_CON_BEL_SCL) {
		R11_NO_CON_BEL_SCL = r11_NO_CON_BEL_SCL;
	}

	public String getR11_NO_CON_BAC() {
		return R11_NO_CON_BAC;
	}

	public void setR11_NO_CON_BAC(String r11_NO_CON_BAC) {
		R11_NO_CON_BAC = r11_NO_CON_BAC;
	}

	public String getR11_NO_CON_ABV_MAS() {
		return R11_NO_CON_ABV_MAS;
	}

	public void setR11_NO_CON_ABV_MAS(String r11_NO_CON_ABV_MAS) {
		R11_NO_CON_ABV_MAS = r11_NO_CON_ABV_MAS;
	}

	public String getR11_NO_CON_ABU_KYC() {
		return R11_NO_CON_ABU_KYC;
	}

	public void setR11_NO_CON_ABU_KYC(String r11_NO_CON_ABU_KYC) {
		R11_NO_CON_ABU_KYC = r11_NO_CON_ABU_KYC;
	}

	public String getR11_NO_CON_DUB_KYC() {
		return R11_NO_CON_DUB_KYC;
	}

	public void setR11_NO_CON_DUB_KYC(String r11_NO_CON_DUB_KYC) {
		R11_NO_CON_DUB_KYC = r11_NO_CON_DUB_KYC;
	}

	public String getR11_NO_CON_SHJ_KYC() {
		return R11_NO_CON_SHJ_KYC;
	}

	public void setR11_NO_CON_SHJ_KYC(String r11_NO_CON_SHJ_KYC) {
		R11_NO_CON_SHJ_KYC = r11_NO_CON_SHJ_KYC;
	}

	public String getR11_NO_CON_AJM_KYC() {
		return R11_NO_CON_AJM_KYC;
	}

	public void setR11_NO_CON_AJM_KYC(String r11_NO_CON_AJM_KYC) {
		R11_NO_CON_AJM_KYC = r11_NO_CON_AJM_KYC;
	}

	public String getR11_NO_CON_FUJ_KYC() {
		return R11_NO_CON_FUJ_KYC;
	}

	public void setR11_NO_CON_FUJ_KYC(String r11_NO_CON_FUJ_KYC) {
		R11_NO_CON_FUJ_KYC = r11_NO_CON_FUJ_KYC;
	}

	public String getR11_NO_CON_RAK_KYC() {
		return R11_NO_CON_RAK_KYC;
	}

	public void setR11_NO_CON_RAK_KYC(String r11_NO_CON_RAK_KYC) {
		R11_NO_CON_RAK_KYC = r11_NO_CON_RAK_KYC;
	}

	public String getR11_NO_CON_UAQ_KYC() {
		return R11_NO_CON_UAQ_KYC;
	}

	public void setR11_NO_CON_UAQ_KYC(String r11_NO_CON_UAQ_KYC) {
		R11_NO_CON_UAQ_KYC = r11_NO_CON_UAQ_KYC;
	}

	public String getR11_NO_CON_RET() {
		return R11_NO_CON_RET;
	}

	public void setR11_NO_CON_RET(String r11_NO_CON_RET) {
		R11_NO_CON_RET = r11_NO_CON_RET;
	}

	public String getR11_NO_CON_DBR_LIM() {
		return R11_NO_CON_DBR_LIM;
	}

	public void setR11_NO_CON_DBR_LIM(String r11_NO_CON_DBR_LIM) {
		R11_NO_CON_DBR_LIM = r11_NO_CON_DBR_LIM;
	}

	public String getR11_NO_UAE_CON_SPC_TP() {
		return R11_NO_UAE_CON_SPC_TP;
	}

	public void setR11_NO_UAE_CON_SPC_TP(String r11_NO_UAE_CON_SPC_TP) {
		R11_NO_UAE_CON_SPC_TP = r11_NO_UAE_CON_SPC_TP;
	}

	public String getR11_NO_UAE_CON_NLS() {
		return R11_NO_UAE_CON_NLS;
	}

	public void setR11_NO_UAE_CON_NLS(String r11_NO_UAE_CON_NLS) {
		R11_NO_UAE_CON_NLS = r11_NO_UAE_CON_NLS;
	}

	public String getR11_VAL_LOS_AED() {
		return R11_VAL_LOS_AED;
	}

	public void setR11_VAL_LOS_AED(String r11_VAL_LOS_AED) {
		R11_VAL_LOS_AED = r11_VAL_LOS_AED;
	}

	public String getR11_NO_CON_ONB_90() {
		return R11_NO_CON_ONB_90;
	}

	public void setR11_NO_CON_ONB_90(String r11_NO_CON_ONB_90) {
		R11_NO_CON_ONB_90 = r11_NO_CON_ONB_90;
	}

	public String getR11_NO_CON_BAL_PAY() {
		return R11_NO_CON_BAL_PAY;
	}

	public void setR11_NO_CON_BAL_PAY(String r11_NO_CON_BAL_PAY) {
		R11_NO_CON_BAL_PAY = r11_NO_CON_BAL_PAY;
	}

	public String getR11_NO_CON_BAL_SPC_TP() {
		return R11_NO_CON_BAL_SPC_TP;
	}

	public void setR11_NO_CON_BAL_SPC_TP(String r11_NO_CON_BAL_SPC_TP) {
		R11_NO_CON_BAL_SPC_TP = r11_NO_CON_BAL_SPC_TP;
	}

	public String getR11_NO_CON_DEBT() {
		return R11_NO_CON_DEBT;
	}

	public void setR11_NO_CON_DEBT(String r11_NO_CON_DEBT) {
		R11_NO_CON_DEBT = r11_NO_CON_DEBT;
	}

	public String getR11_NO_CON_ONB_REF() {
		return R11_NO_CON_ONB_REF;
	}

	public void setR11_NO_CON_ONB_REF(String r11_NO_CON_ONB_REF) {
		R11_NO_CON_ONB_REF = r11_NO_CON_ONB_REF;
	}

	public String getR11_NO_CON_ONB_AGE() {
		return R11_NO_CON_ONB_AGE;
	}

	public void setR11_NO_CON_ONB_AGE(String r11_NO_CON_ONB_AGE) {
		R11_NO_CON_ONB_AGE = r11_NO_CON_ONB_AGE;
	}

	public String getR11_NO_CON_AFF_UNAU() {
		return R11_NO_CON_AFF_UNAU;
	}

	public void setR11_NO_CON_AFF_UNAU(String r11_NO_CON_AFF_UNAU) {
		R11_NO_CON_AFF_UNAU = r11_NO_CON_AFF_UNAU;
	}

	public String getR11_NO_OF_ACCS_POD() {
		return R11_NO_OF_ACCS_POD;
	}

	public void setR11_NO_OF_ACCS_POD(String r11_NO_OF_ACCS_POD) {
		R11_NO_OF_ACCS_POD = r11_NO_OF_ACCS_POD;
	}

	public String getR11_NO_DEL_CON() {
		return R11_NO_DEL_CON;
	}

	public void setR11_NO_DEL_CON(String r11_NO_DEL_CON) {
		R11_NO_DEL_CON = r11_NO_DEL_CON;
	}

	public String getR11_NO_INS_FUN_LFI() {
		return R11_NO_INS_FUN_LFI;
	}

	public void setR11_NO_INS_FUN_LFI(String r11_NO_INS_FUN_LFI) {
		R11_NO_INS_FUN_LFI = r11_NO_INS_FUN_LFI;
	}

	public String getR11_NO_CON_COL_FIN() {
		return R11_NO_CON_COL_FIN;
	}

	public void setR11_NO_CON_COL_FIN(String r11_NO_CON_COL_FIN) {
		R11_NO_CON_COL_FIN = r11_NO_CON_COL_FIN;
	}

	public String getR11_TOT_NO_NEW_FIN() {
		return R11_TOT_NO_NEW_FIN;
	}

	public void setR11_TOT_NO_NEW_FIN(String r11_TOT_NO_NEW_FIN) {
		R11_TOT_NO_NEW_FIN = r11_TOT_NO_NEW_FIN;
	}

	public String getR11_TOT_NO_NEW_NOSGN() {
		return R11_TOT_NO_NEW_NOSGN;
	}

	public void setR11_TOT_NO_NEW_NOSGN(String r11_TOT_NO_NEW_NOSGN) {
		R11_TOT_NO_NEW_NOSGN = r11_TOT_NO_NEW_NOSGN;
	}

	public String getR11_NO_CON_START() {
		return R11_NO_CON_START;
	}

	public void setR11_NO_CON_START(String r11_NO_CON_START) {
		R11_NO_CON_START = r11_NO_CON_START;
	}

	public String getR11_NO_NEW_CON_ONBO() {
		return R11_NO_NEW_CON_ONBO;
	}

	public void setR11_NO_NEW_CON_ONBO(String r11_NO_NEW_CON_ONBO) {
		R11_NO_NEW_CON_ONBO = r11_NO_NEW_CON_ONBO;
	}

	public String getR11_NO_CON_DEBT_COUN() {
		return R11_NO_CON_DEBT_COUN;
	}

	public void setR11_NO_CON_DEBT_COUN(String r11_NO_CON_DEBT_COUN) {
		R11_NO_CON_DEBT_COUN = r11_NO_CON_DEBT_COUN;
	}

	public String getR11_NO_CON_DEL_NPA() {
		return R11_NO_CON_DEL_NPA;
	}

	public void setR11_NO_CON_DEL_NPA(String r11_NO_CON_DEL_NPA) {
		R11_NO_CON_DEL_NPA = r11_NO_CON_DEL_NPA;
	}

	public String getR11_NO_CON_GOV_50() {
		return R11_NO_CON_GOV_50;
	}

	public void setR11_NO_CON_GOV_50(String r11_NO_CON_GOV_50) {
		R11_NO_CON_GOV_50 = r11_NO_CON_GOV_50;
	}

	public String getR11_NO_SME_SOLE() {
		return R11_NO_SME_SOLE;
	}

	public void setR11_NO_SME_SOLE(String r11_NO_SME_SOLE) {
		R11_NO_SME_SOLE = r11_NO_SME_SOLE;
	}

	public String getR11_NO_CON_TAG_VUL() {
		return R11_NO_CON_TAG_VUL;
	}

	public void setR11_NO_CON_TAG_VUL(String r11_NO_CON_TAG_VUL) {
		R11_NO_CON_TAG_VUL = r11_NO_CON_TAG_VUL;
	}

	public String getR11_NO_NEW_CON_ONB_GNP() {
		return R11_NO_NEW_CON_ONB_GNP;
	}

	public void setR11_NO_NEW_CON_ONB_GNP(String r11_NO_NEW_CON_ONB_GNP) {
		R11_NO_NEW_CON_ONB_GNP = r11_NO_NEW_CON_ONB_GNP;
	}

	public String getR11_NO_CON_END() {
		return R11_NO_CON_END;
	}

	public void setR11_NO_CON_END(String r11_NO_CON_END) {
		R11_NO_CON_END = r11_NO_CON_END;
	}

	public String getR12_BANK() {
		return R12_BANK;
	}

	public void setR12_BANK(String r12_BANK) {
		R12_BANK = r12_BANK;
	}

	public String getR12_PRODUCT() {
		return R12_PRODUCT;
	}

	public void setR12_PRODUCT(String r12_PRODUCT) {
		R12_PRODUCT = r12_PRODUCT;
	}

	public String getR12_NO_WO_SD() {
		return R12_NO_WO_SD;
	}

	public void setR12_NO_WO_SD(String r12_NO_WO_SD) {
		R12_NO_WO_SD = r12_NO_WO_SD;
	}

	public String getR12_NO_CON_POD_SD() {
		return R12_NO_CON_POD_SD;
	}

	public void setR12_NO_CON_POD_SD(String r12_NO_CON_POD_SD) {
		R12_NO_CON_POD_SD = r12_NO_CON_POD_SD;
	}

	public String getR12_NO_CON_UNAU_SP_TP() {
		return R12_NO_CON_UNAU_SP_TP;
	}

	public void setR12_NO_CON_UNAU_SP_TP(String r12_NO_CON_UNAU_SP_TP) {
		R12_NO_CON_UNAU_SP_TP = r12_NO_CON_UNAU_SP_TP;
	}

	public String getR12_NO_CON_45_50() {
		return R12_NO_CON_45_50;
	}

	public void setR12_NO_CON_45_50(String r12_NO_CON_45_50) {
		R12_NO_CON_45_50 = r12_NO_CON_45_50;
	}

	public String getR12_NO_CON_50() {
		return R12_NO_CON_50;
	}

	public void setR12_NO_CON_50(String r12_NO_CON_50) {
		R12_NO_CON_50 = r12_NO_CON_50;
	}

	public String getR12_NO_OF_LES_50() {
		return R12_NO_OF_LES_50;
	}

	public void setR12_NO_OF_LES_50(String r12_NO_OF_LES_50) {
		R12_NO_OF_LES_50 = r12_NO_OF_LES_50;
	}

	public String getR12_NO_OF_BNK_18() {
		return R12_NO_OF_BNK_18;
	}

	public void setR12_NO_OF_BNK_18(String r12_NO_OF_BNK_18) {
		R12_NO_OF_BNK_18 = r12_NO_OF_BNK_18;
	}

	public String getR12_NO_OF_BNK_18_25() {
		return R12_NO_OF_BNK_18_25;
	}

	public void setR12_NO_OF_BNK_18_25(String r12_NO_OF_BNK_18_25) {
		R12_NO_OF_BNK_18_25 = r12_NO_OF_BNK_18_25;
	}

	public String getR12_NO_OF_BNK_26_35() {
		return R12_NO_OF_BNK_26_35;
	}

	public void setR12_NO_OF_BNK_26_35(String r12_NO_OF_BNK_26_35) {
		R12_NO_OF_BNK_26_35 = r12_NO_OF_BNK_26_35;
	}

	public String getR12_NO_OF_BNK_36_50() {
		return R12_NO_OF_BNK_36_50;
	}

	public void setR12_NO_OF_BNK_36_50(String r12_NO_OF_BNK_36_50) {
		R12_NO_OF_BNK_36_50 = r12_NO_OF_BNK_36_50;
	}

	public String getR12_NO_CON_BNK_50() {
		return R12_NO_CON_BNK_50;
	}

	public void setR12_NO_CON_BNK_50(String r12_NO_CON_BNK_50) {
		R12_NO_CON_BNK_50 = r12_NO_CON_BNK_50;
	}

	public String getR12_NO_CON_SAL_SPD() {
		return R12_NO_CON_SAL_SPD;
	}

	public void setR12_NO_CON_SAL_SPD(String r12_NO_CON_SAL_SPD) {
		R12_NO_CON_SAL_SPD = r12_NO_CON_SAL_SPD;
	}

	public String getR12_NO_CON_BUS_SPD() {
		return R12_NO_CON_BUS_SPD;
	}

	public void setR12_NO_CON_BUS_SPD(String r12_NO_CON_BUS_SPD) {
		R12_NO_CON_BUS_SPD = r12_NO_CON_BUS_SPD;
	}

	public String getR12_NO_CON_PRO_SPD() {
		return R12_NO_CON_PRO_SPD;
	}

	public void setR12_NO_CON_PRO_SPD(String r12_NO_CON_PRO_SPD) {
		R12_NO_CON_PRO_SPD = r12_NO_CON_PRO_SPD;
	}

	public String getR12_NO_CON_INC_5K() {
		return R12_NO_CON_INC_5K;
	}

	public void setR12_NO_CON_INC_5K(String r12_NO_CON_INC_5K) {
		R12_NO_CON_INC_5K = r12_NO_CON_INC_5K;
	}

	public String getR12_NO_CON_INC_5K_10K() {
		return R12_NO_CON_INC_5K_10K;
	}

	public void setR12_NO_CON_INC_5K_10K(String r12_NO_CON_INC_5K_10K) {
		R12_NO_CON_INC_5K_10K = r12_NO_CON_INC_5K_10K;
	}

	public String getR12_NO_CON_INC_10K_20K() {
		return R12_NO_CON_INC_10K_20K;
	}

	public void setR12_NO_CON_INC_10K_20K(String r12_NO_CON_INC_10K_20K) {
		R12_NO_CON_INC_10K_20K = r12_NO_CON_INC_10K_20K;
	}

	public String getR12_NO_CON_INC_20K_35K() {
		return R12_NO_CON_INC_20K_35K;
	}

	public void setR12_NO_CON_INC_20K_35K(String r12_NO_CON_INC_20K_35K) {
		R12_NO_CON_INC_20K_35K = r12_NO_CON_INC_20K_35K;
	}

	public String getR12_NO_CON_INC_35K() {
		return R12_NO_CON_INC_35K;
	}

	public void setR12_NO_CON_INC_35K(String r12_NO_CON_INC_35K) {
		R12_NO_CON_INC_35K = r12_NO_CON_INC_35K;
	}

	public String getR12_NO_CON_BEL_SCL() {
		return R12_NO_CON_BEL_SCL;
	}

	public void setR12_NO_CON_BEL_SCL(String r12_NO_CON_BEL_SCL) {
		R12_NO_CON_BEL_SCL = r12_NO_CON_BEL_SCL;
	}

	public String getR12_NO_CON_BAC() {
		return R12_NO_CON_BAC;
	}

	public void setR12_NO_CON_BAC(String r12_NO_CON_BAC) {
		R12_NO_CON_BAC = r12_NO_CON_BAC;
	}

	public String getR12_NO_CON_ABV_MAS() {
		return R12_NO_CON_ABV_MAS;
	}

	public void setR12_NO_CON_ABV_MAS(String r12_NO_CON_ABV_MAS) {
		R12_NO_CON_ABV_MAS = r12_NO_CON_ABV_MAS;
	}

	public String getR12_NO_CON_ABU_KYC() {
		return R12_NO_CON_ABU_KYC;
	}

	public void setR12_NO_CON_ABU_KYC(String r12_NO_CON_ABU_KYC) {
		R12_NO_CON_ABU_KYC = r12_NO_CON_ABU_KYC;
	}

	public String getR12_NO_CON_DUB_KYC() {
		return R12_NO_CON_DUB_KYC;
	}

	public void setR12_NO_CON_DUB_KYC(String r12_NO_CON_DUB_KYC) {
		R12_NO_CON_DUB_KYC = r12_NO_CON_DUB_KYC;
	}

	public String getR12_NO_CON_SHJ_KYC() {
		return R12_NO_CON_SHJ_KYC;
	}

	public void setR12_NO_CON_SHJ_KYC(String r12_NO_CON_SHJ_KYC) {
		R12_NO_CON_SHJ_KYC = r12_NO_CON_SHJ_KYC;
	}

	public String getR12_NO_CON_AJM_KYC() {
		return R12_NO_CON_AJM_KYC;
	}

	public void setR12_NO_CON_AJM_KYC(String r12_NO_CON_AJM_KYC) {
		R12_NO_CON_AJM_KYC = r12_NO_CON_AJM_KYC;
	}

	public String getR12_NO_CON_FUJ_KYC() {
		return R12_NO_CON_FUJ_KYC;
	}

	public void setR12_NO_CON_FUJ_KYC(String r12_NO_CON_FUJ_KYC) {
		R12_NO_CON_FUJ_KYC = r12_NO_CON_FUJ_KYC;
	}

	public String getR12_NO_CON_RAK_KYC() {
		return R12_NO_CON_RAK_KYC;
	}

	public void setR12_NO_CON_RAK_KYC(String r12_NO_CON_RAK_KYC) {
		R12_NO_CON_RAK_KYC = r12_NO_CON_RAK_KYC;
	}

	public String getR12_NO_CON_UAQ_KYC() {
		return R12_NO_CON_UAQ_KYC;
	}

	public void setR12_NO_CON_UAQ_KYC(String r12_NO_CON_UAQ_KYC) {
		R12_NO_CON_UAQ_KYC = r12_NO_CON_UAQ_KYC;
	}

	public String getR12_NO_CON_RET() {
		return R12_NO_CON_RET;
	}

	public void setR12_NO_CON_RET(String r12_NO_CON_RET) {
		R12_NO_CON_RET = r12_NO_CON_RET;
	}

	public String getR12_NO_CON_DBR_LIM() {
		return R12_NO_CON_DBR_LIM;
	}

	public void setR12_NO_CON_DBR_LIM(String r12_NO_CON_DBR_LIM) {
		R12_NO_CON_DBR_LIM = r12_NO_CON_DBR_LIM;
	}

	public String getR12_NO_UAE_CON_SPC_TP() {
		return R12_NO_UAE_CON_SPC_TP;
	}

	public void setR12_NO_UAE_CON_SPC_TP(String r12_NO_UAE_CON_SPC_TP) {
		R12_NO_UAE_CON_SPC_TP = r12_NO_UAE_CON_SPC_TP;
	}

	public String getR12_NO_UAE_CON_NLS() {
		return R12_NO_UAE_CON_NLS;
	}

	public void setR12_NO_UAE_CON_NLS(String r12_NO_UAE_CON_NLS) {
		R12_NO_UAE_CON_NLS = r12_NO_UAE_CON_NLS;
	}

	public String getR12_VAL_LOS_AED() {
		return R12_VAL_LOS_AED;
	}

	public void setR12_VAL_LOS_AED(String r12_VAL_LOS_AED) {
		R12_VAL_LOS_AED = r12_VAL_LOS_AED;
	}

	public String getR12_NO_CON_ONB_90() {
		return R12_NO_CON_ONB_90;
	}

	public void setR12_NO_CON_ONB_90(String r12_NO_CON_ONB_90) {
		R12_NO_CON_ONB_90 = r12_NO_CON_ONB_90;
	}

	public String getR12_NO_CON_BAL_PAY() {
		return R12_NO_CON_BAL_PAY;
	}

	public void setR12_NO_CON_BAL_PAY(String r12_NO_CON_BAL_PAY) {
		R12_NO_CON_BAL_PAY = r12_NO_CON_BAL_PAY;
	}

	public String getR12_NO_CON_BAL_SPC_TP() {
		return R12_NO_CON_BAL_SPC_TP;
	}

	public void setR12_NO_CON_BAL_SPC_TP(String r12_NO_CON_BAL_SPC_TP) {
		R12_NO_CON_BAL_SPC_TP = r12_NO_CON_BAL_SPC_TP;
	}

	public String getR12_NO_CON_DEBT() {
		return R12_NO_CON_DEBT;
	}

	public void setR12_NO_CON_DEBT(String r12_NO_CON_DEBT) {
		R12_NO_CON_DEBT = r12_NO_CON_DEBT;
	}

	public String getR12_NO_CON_ONB_REF() {
		return R12_NO_CON_ONB_REF;
	}

	public void setR12_NO_CON_ONB_REF(String r12_NO_CON_ONB_REF) {
		R12_NO_CON_ONB_REF = r12_NO_CON_ONB_REF;
	}

	public String getR12_NO_CON_ONB_AGE() {
		return R12_NO_CON_ONB_AGE;
	}

	public void setR12_NO_CON_ONB_AGE(String r12_NO_CON_ONB_AGE) {
		R12_NO_CON_ONB_AGE = r12_NO_CON_ONB_AGE;
	}

	public String getR12_NO_CON_AFF_UNAU() {
		return R12_NO_CON_AFF_UNAU;
	}

	public void setR12_NO_CON_AFF_UNAU(String r12_NO_CON_AFF_UNAU) {
		R12_NO_CON_AFF_UNAU = r12_NO_CON_AFF_UNAU;
	}

	public String getR12_NO_OF_ACCS_POD() {
		return R12_NO_OF_ACCS_POD;
	}

	public void setR12_NO_OF_ACCS_POD(String r12_NO_OF_ACCS_POD) {
		R12_NO_OF_ACCS_POD = r12_NO_OF_ACCS_POD;
	}

	public String getR12_NO_DEL_CON() {
		return R12_NO_DEL_CON;
	}

	public void setR12_NO_DEL_CON(String r12_NO_DEL_CON) {
		R12_NO_DEL_CON = r12_NO_DEL_CON;
	}

	public String getR12_NO_INS_FUN_LFI() {
		return R12_NO_INS_FUN_LFI;
	}

	public void setR12_NO_INS_FUN_LFI(String r12_NO_INS_FUN_LFI) {
		R12_NO_INS_FUN_LFI = r12_NO_INS_FUN_LFI;
	}

	public String getR12_NO_CON_COL_FIN() {
		return R12_NO_CON_COL_FIN;
	}

	public void setR12_NO_CON_COL_FIN(String r12_NO_CON_COL_FIN) {
		R12_NO_CON_COL_FIN = r12_NO_CON_COL_FIN;
	}

	public String getR12_TOT_NO_NEW_FIN() {
		return R12_TOT_NO_NEW_FIN;
	}

	public void setR12_TOT_NO_NEW_FIN(String r12_TOT_NO_NEW_FIN) {
		R12_TOT_NO_NEW_FIN = r12_TOT_NO_NEW_FIN;
	}

	public String getR12_TOT_NO_NEW_NOSGN() {
		return R12_TOT_NO_NEW_NOSGN;
	}

	public void setR12_TOT_NO_NEW_NOSGN(String r12_TOT_NO_NEW_NOSGN) {
		R12_TOT_NO_NEW_NOSGN = r12_TOT_NO_NEW_NOSGN;
	}

	public String getR12_NO_CON_START() {
		return R12_NO_CON_START;
	}

	public void setR12_NO_CON_START(String r12_NO_CON_START) {
		R12_NO_CON_START = r12_NO_CON_START;
	}

	public String getR12_NO_NEW_CON_ONBO() {
		return R12_NO_NEW_CON_ONBO;
	}

	public void setR12_NO_NEW_CON_ONBO(String r12_NO_NEW_CON_ONBO) {
		R12_NO_NEW_CON_ONBO = r12_NO_NEW_CON_ONBO;
	}

	public String getR12_NO_CON_DEBT_COUN() {
		return R12_NO_CON_DEBT_COUN;
	}

	public void setR12_NO_CON_DEBT_COUN(String r12_NO_CON_DEBT_COUN) {
		R12_NO_CON_DEBT_COUN = r12_NO_CON_DEBT_COUN;
	}

	public String getR12_NO_CON_DEL_NPA() {
		return R12_NO_CON_DEL_NPA;
	}

	public void setR12_NO_CON_DEL_NPA(String r12_NO_CON_DEL_NPA) {
		R12_NO_CON_DEL_NPA = r12_NO_CON_DEL_NPA;
	}

	public String getR12_NO_CON_GOV_50() {
		return R12_NO_CON_GOV_50;
	}

	public void setR12_NO_CON_GOV_50(String r12_NO_CON_GOV_50) {
		R12_NO_CON_GOV_50 = r12_NO_CON_GOV_50;
	}

	public String getR12_NO_SME_SOLE() {
		return R12_NO_SME_SOLE;
	}

	public void setR12_NO_SME_SOLE(String r12_NO_SME_SOLE) {
		R12_NO_SME_SOLE = r12_NO_SME_SOLE;
	}

	public String getR12_NO_CON_TAG_VUL() {
		return R12_NO_CON_TAG_VUL;
	}

	public void setR12_NO_CON_TAG_VUL(String r12_NO_CON_TAG_VUL) {
		R12_NO_CON_TAG_VUL = r12_NO_CON_TAG_VUL;
	}

	public String getR12_NO_NEW_CON_ONB_GNP() {
		return R12_NO_NEW_CON_ONB_GNP;
	}

	public void setR12_NO_NEW_CON_ONB_GNP(String r12_NO_NEW_CON_ONB_GNP) {
		R12_NO_NEW_CON_ONB_GNP = r12_NO_NEW_CON_ONB_GNP;
	}

	public String getR12_NO_CON_END() {
		return R12_NO_CON_END;
	}

	public void setR12_NO_CON_END(String r12_NO_CON_END) {
		R12_NO_CON_END = r12_NO_CON_END;
	}

	public String getR13_BANK() {
		return R13_BANK;
	}

	public void setR13_BANK(String r13_BANK) {
		R13_BANK = r13_BANK;
	}

	public String getR13_PRODUCT() {
		return R13_PRODUCT;
	}

	public void setR13_PRODUCT(String r13_PRODUCT) {
		R13_PRODUCT = r13_PRODUCT;
	}

	public String getR13_NO_WO_SD() {
		return R13_NO_WO_SD;
	}

	public void setR13_NO_WO_SD(String r13_NO_WO_SD) {
		R13_NO_WO_SD = r13_NO_WO_SD;
	}

	public String getR13_NO_CON_POD_SD() {
		return R13_NO_CON_POD_SD;
	}

	public void setR13_NO_CON_POD_SD(String r13_NO_CON_POD_SD) {
		R13_NO_CON_POD_SD = r13_NO_CON_POD_SD;
	}

	public String getR13_NO_CON_UNAU_SP_TP() {
		return R13_NO_CON_UNAU_SP_TP;
	}

	public void setR13_NO_CON_UNAU_SP_TP(String r13_NO_CON_UNAU_SP_TP) {
		R13_NO_CON_UNAU_SP_TP = r13_NO_CON_UNAU_SP_TP;
	}

	public String getR13_NO_CON_45_50() {
		return R13_NO_CON_45_50;
	}

	public void setR13_NO_CON_45_50(String r13_NO_CON_45_50) {
		R13_NO_CON_45_50 = r13_NO_CON_45_50;
	}

	public String getR13_NO_CON_50() {
		return R13_NO_CON_50;
	}

	public void setR13_NO_CON_50(String r13_NO_CON_50) {
		R13_NO_CON_50 = r13_NO_CON_50;
	}

	public String getR13_NO_OF_LES_50() {
		return R13_NO_OF_LES_50;
	}

	public void setR13_NO_OF_LES_50(String r13_NO_OF_LES_50) {
		R13_NO_OF_LES_50 = r13_NO_OF_LES_50;
	}

	public String getR13_NO_OF_BNK_18() {
		return R13_NO_OF_BNK_18;
	}

	public void setR13_NO_OF_BNK_18(String r13_NO_OF_BNK_18) {
		R13_NO_OF_BNK_18 = r13_NO_OF_BNK_18;
	}

	public String getR13_NO_OF_BNK_18_25() {
		return R13_NO_OF_BNK_18_25;
	}

	public void setR13_NO_OF_BNK_18_25(String r13_NO_OF_BNK_18_25) {
		R13_NO_OF_BNK_18_25 = r13_NO_OF_BNK_18_25;
	}

	public String getR13_NO_OF_BNK_26_35() {
		return R13_NO_OF_BNK_26_35;
	}

	public void setR13_NO_OF_BNK_26_35(String r13_NO_OF_BNK_26_35) {
		R13_NO_OF_BNK_26_35 = r13_NO_OF_BNK_26_35;
	}

	public String getR13_NO_OF_BNK_36_50() {
		return R13_NO_OF_BNK_36_50;
	}

	public void setR13_NO_OF_BNK_36_50(String r13_NO_OF_BNK_36_50) {
		R13_NO_OF_BNK_36_50 = r13_NO_OF_BNK_36_50;
	}

	public String getR13_NO_CON_BNK_50() {
		return R13_NO_CON_BNK_50;
	}

	public void setR13_NO_CON_BNK_50(String r13_NO_CON_BNK_50) {
		R13_NO_CON_BNK_50 = r13_NO_CON_BNK_50;
	}

	public String getR13_NO_CON_SAL_SPD() {
		return R13_NO_CON_SAL_SPD;
	}

	public void setR13_NO_CON_SAL_SPD(String r13_NO_CON_SAL_SPD) {
		R13_NO_CON_SAL_SPD = r13_NO_CON_SAL_SPD;
	}

	public String getR13_NO_CON_BUS_SPD() {
		return R13_NO_CON_BUS_SPD;
	}

	public void setR13_NO_CON_BUS_SPD(String r13_NO_CON_BUS_SPD) {
		R13_NO_CON_BUS_SPD = r13_NO_CON_BUS_SPD;
	}

	public String getR13_NO_CON_PRO_SPD() {
		return R13_NO_CON_PRO_SPD;
	}

	public void setR13_NO_CON_PRO_SPD(String r13_NO_CON_PRO_SPD) {
		R13_NO_CON_PRO_SPD = r13_NO_CON_PRO_SPD;
	}

	public String getR13_NO_CON_INC_5K() {
		return R13_NO_CON_INC_5K;
	}

	public void setR13_NO_CON_INC_5K(String r13_NO_CON_INC_5K) {
		R13_NO_CON_INC_5K = r13_NO_CON_INC_5K;
	}

	public String getR13_NO_CON_INC_5K_10K() {
		return R13_NO_CON_INC_5K_10K;
	}

	public void setR13_NO_CON_INC_5K_10K(String r13_NO_CON_INC_5K_10K) {
		R13_NO_CON_INC_5K_10K = r13_NO_CON_INC_5K_10K;
	}

	public String getR13_NO_CON_INC_10K_20K() {
		return R13_NO_CON_INC_10K_20K;
	}

	public void setR13_NO_CON_INC_10K_20K(String r13_NO_CON_INC_10K_20K) {
		R13_NO_CON_INC_10K_20K = r13_NO_CON_INC_10K_20K;
	}

	public String getR13_NO_CON_INC_20K_35K() {
		return R13_NO_CON_INC_20K_35K;
	}

	public void setR13_NO_CON_INC_20K_35K(String r13_NO_CON_INC_20K_35K) {
		R13_NO_CON_INC_20K_35K = r13_NO_CON_INC_20K_35K;
	}

	public String getR13_NO_CON_INC_35K() {
		return R13_NO_CON_INC_35K;
	}

	public void setR13_NO_CON_INC_35K(String r13_NO_CON_INC_35K) {
		R13_NO_CON_INC_35K = r13_NO_CON_INC_35K;
	}

	public String getR13_NO_CON_BEL_SCL() {
		return R13_NO_CON_BEL_SCL;
	}

	public void setR13_NO_CON_BEL_SCL(String r13_NO_CON_BEL_SCL) {
		R13_NO_CON_BEL_SCL = r13_NO_CON_BEL_SCL;
	}

	public String getR13_NO_CON_BAC() {
		return R13_NO_CON_BAC;
	}

	public void setR13_NO_CON_BAC(String r13_NO_CON_BAC) {
		R13_NO_CON_BAC = r13_NO_CON_BAC;
	}

	public String getR13_NO_CON_ABV_MAS() {
		return R13_NO_CON_ABV_MAS;
	}

	public void setR13_NO_CON_ABV_MAS(String r13_NO_CON_ABV_MAS) {
		R13_NO_CON_ABV_MAS = r13_NO_CON_ABV_MAS;
	}

	public String getR13_NO_CON_ABU_KYC() {
		return R13_NO_CON_ABU_KYC;
	}

	public void setR13_NO_CON_ABU_KYC(String r13_NO_CON_ABU_KYC) {
		R13_NO_CON_ABU_KYC = r13_NO_CON_ABU_KYC;
	}

	public String getR13_NO_CON_DUB_KYC() {
		return R13_NO_CON_DUB_KYC;
	}

	public void setR13_NO_CON_DUB_KYC(String r13_NO_CON_DUB_KYC) {
		R13_NO_CON_DUB_KYC = r13_NO_CON_DUB_KYC;
	}

	public String getR13_NO_CON_SHJ_KYC() {
		return R13_NO_CON_SHJ_KYC;
	}

	public void setR13_NO_CON_SHJ_KYC(String r13_NO_CON_SHJ_KYC) {
		R13_NO_CON_SHJ_KYC = r13_NO_CON_SHJ_KYC;
	}

	public String getR13_NO_CON_AJM_KYC() {
		return R13_NO_CON_AJM_KYC;
	}

	public void setR13_NO_CON_AJM_KYC(String r13_NO_CON_AJM_KYC) {
		R13_NO_CON_AJM_KYC = r13_NO_CON_AJM_KYC;
	}

	public String getR13_NO_CON_FUJ_KYC() {
		return R13_NO_CON_FUJ_KYC;
	}

	public void setR13_NO_CON_FUJ_KYC(String r13_NO_CON_FUJ_KYC) {
		R13_NO_CON_FUJ_KYC = r13_NO_CON_FUJ_KYC;
	}

	public String getR13_NO_CON_RAK_KYC() {
		return R13_NO_CON_RAK_KYC;
	}

	public void setR13_NO_CON_RAK_KYC(String r13_NO_CON_RAK_KYC) {
		R13_NO_CON_RAK_KYC = r13_NO_CON_RAK_KYC;
	}

	public String getR13_NO_CON_UAQ_KYC() {
		return R13_NO_CON_UAQ_KYC;
	}

	public void setR13_NO_CON_UAQ_KYC(String r13_NO_CON_UAQ_KYC) {
		R13_NO_CON_UAQ_KYC = r13_NO_CON_UAQ_KYC;
	}

	public String getR13_NO_CON_RET() {
		return R13_NO_CON_RET;
	}

	public void setR13_NO_CON_RET(String r13_NO_CON_RET) {
		R13_NO_CON_RET = r13_NO_CON_RET;
	}

	public String getR13_NO_CON_DBR_LIM() {
		return R13_NO_CON_DBR_LIM;
	}

	public void setR13_NO_CON_DBR_LIM(String r13_NO_CON_DBR_LIM) {
		R13_NO_CON_DBR_LIM = r13_NO_CON_DBR_LIM;
	}

	public String getR13_NO_UAE_CON_SPC_TP() {
		return R13_NO_UAE_CON_SPC_TP;
	}

	public void setR13_NO_UAE_CON_SPC_TP(String r13_NO_UAE_CON_SPC_TP) {
		R13_NO_UAE_CON_SPC_TP = r13_NO_UAE_CON_SPC_TP;
	}

	public String getR13_NO_UAE_CON_NLS() {
		return R13_NO_UAE_CON_NLS;
	}

	public void setR13_NO_UAE_CON_NLS(String r13_NO_UAE_CON_NLS) {
		R13_NO_UAE_CON_NLS = r13_NO_UAE_CON_NLS;
	}

	public String getR13_VAL_LOS_AED() {
		return R13_VAL_LOS_AED;
	}

	public void setR13_VAL_LOS_AED(String r13_VAL_LOS_AED) {
		R13_VAL_LOS_AED = r13_VAL_LOS_AED;
	}

	public String getR13_NO_CON_ONB_90() {
		return R13_NO_CON_ONB_90;
	}

	public void setR13_NO_CON_ONB_90(String r13_NO_CON_ONB_90) {
		R13_NO_CON_ONB_90 = r13_NO_CON_ONB_90;
	}

	public String getR13_NO_CON_BAL_PAY() {
		return R13_NO_CON_BAL_PAY;
	}

	public void setR13_NO_CON_BAL_PAY(String r13_NO_CON_BAL_PAY) {
		R13_NO_CON_BAL_PAY = r13_NO_CON_BAL_PAY;
	}

	public String getR13_NO_CON_BAL_SPC_TP() {
		return R13_NO_CON_BAL_SPC_TP;
	}

	public void setR13_NO_CON_BAL_SPC_TP(String r13_NO_CON_BAL_SPC_TP) {
		R13_NO_CON_BAL_SPC_TP = r13_NO_CON_BAL_SPC_TP;
	}

	public String getR13_NO_CON_DEBT() {
		return R13_NO_CON_DEBT;
	}

	public void setR13_NO_CON_DEBT(String r13_NO_CON_DEBT) {
		R13_NO_CON_DEBT = r13_NO_CON_DEBT;
	}

	public String getR13_NO_CON_ONB_REF() {
		return R13_NO_CON_ONB_REF;
	}

	public void setR13_NO_CON_ONB_REF(String r13_NO_CON_ONB_REF) {
		R13_NO_CON_ONB_REF = r13_NO_CON_ONB_REF;
	}

	public String getR13_NO_CON_ONB_AGE() {
		return R13_NO_CON_ONB_AGE;
	}

	public void setR13_NO_CON_ONB_AGE(String r13_NO_CON_ONB_AGE) {
		R13_NO_CON_ONB_AGE = r13_NO_CON_ONB_AGE;
	}

	public String getR13_NO_CON_AFF_UNAU() {
		return R13_NO_CON_AFF_UNAU;
	}

	public void setR13_NO_CON_AFF_UNAU(String r13_NO_CON_AFF_UNAU) {
		R13_NO_CON_AFF_UNAU = r13_NO_CON_AFF_UNAU;
	}

	public String getR13_NO_OF_ACCS_POD() {
		return R13_NO_OF_ACCS_POD;
	}

	public void setR13_NO_OF_ACCS_POD(String r13_NO_OF_ACCS_POD) {
		R13_NO_OF_ACCS_POD = r13_NO_OF_ACCS_POD;
	}

	public String getR13_NO_DEL_CON() {
		return R13_NO_DEL_CON;
	}

	public void setR13_NO_DEL_CON(String r13_NO_DEL_CON) {
		R13_NO_DEL_CON = r13_NO_DEL_CON;
	}

	public String getR13_NO_INS_FUN_LFI() {
		return R13_NO_INS_FUN_LFI;
	}

	public void setR13_NO_INS_FUN_LFI(String r13_NO_INS_FUN_LFI) {
		R13_NO_INS_FUN_LFI = r13_NO_INS_FUN_LFI;
	}

	public String getR13_NO_CON_COL_FIN() {
		return R13_NO_CON_COL_FIN;
	}

	public void setR13_NO_CON_COL_FIN(String r13_NO_CON_COL_FIN) {
		R13_NO_CON_COL_FIN = r13_NO_CON_COL_FIN;
	}

	public String getR13_TOT_NO_NEW_FIN() {
		return R13_TOT_NO_NEW_FIN;
	}

	public void setR13_TOT_NO_NEW_FIN(String r13_TOT_NO_NEW_FIN) {
		R13_TOT_NO_NEW_FIN = r13_TOT_NO_NEW_FIN;
	}

	public String getR13_TOT_NO_NEW_NOSGN() {
		return R13_TOT_NO_NEW_NOSGN;
	}

	public void setR13_TOT_NO_NEW_NOSGN(String r13_TOT_NO_NEW_NOSGN) {
		R13_TOT_NO_NEW_NOSGN = r13_TOT_NO_NEW_NOSGN;
	}

	public String getR13_NO_CON_START() {
		return R13_NO_CON_START;
	}

	public void setR13_NO_CON_START(String r13_NO_CON_START) {
		R13_NO_CON_START = r13_NO_CON_START;
	}

	public String getR13_NO_NEW_CON_ONBO() {
		return R13_NO_NEW_CON_ONBO;
	}

	public void setR13_NO_NEW_CON_ONBO(String r13_NO_NEW_CON_ONBO) {
		R13_NO_NEW_CON_ONBO = r13_NO_NEW_CON_ONBO;
	}

	public String getR13_NO_CON_DEBT_COUN() {
		return R13_NO_CON_DEBT_COUN;
	}

	public void setR13_NO_CON_DEBT_COUN(String r13_NO_CON_DEBT_COUN) {
		R13_NO_CON_DEBT_COUN = r13_NO_CON_DEBT_COUN;
	}

	public String getR13_NO_CON_DEL_NPA() {
		return R13_NO_CON_DEL_NPA;
	}

	public void setR13_NO_CON_DEL_NPA(String r13_NO_CON_DEL_NPA) {
		R13_NO_CON_DEL_NPA = r13_NO_CON_DEL_NPA;
	}

	public String getR13_NO_CON_GOV_50() {
		return R13_NO_CON_GOV_50;
	}

	public void setR13_NO_CON_GOV_50(String r13_NO_CON_GOV_50) {
		R13_NO_CON_GOV_50 = r13_NO_CON_GOV_50;
	}

	public String getR13_NO_SME_SOLE() {
		return R13_NO_SME_SOLE;
	}

	public void setR13_NO_SME_SOLE(String r13_NO_SME_SOLE) {
		R13_NO_SME_SOLE = r13_NO_SME_SOLE;
	}

	public String getR13_NO_CON_TAG_VUL() {
		return R13_NO_CON_TAG_VUL;
	}

	public void setR13_NO_CON_TAG_VUL(String r13_NO_CON_TAG_VUL) {
		R13_NO_CON_TAG_VUL = r13_NO_CON_TAG_VUL;
	}

	public String getR13_NO_NEW_CON_ONB_GNP() {
		return R13_NO_NEW_CON_ONB_GNP;
	}

	public void setR13_NO_NEW_CON_ONB_GNP(String r13_NO_NEW_CON_ONB_GNP) {
		R13_NO_NEW_CON_ONB_GNP = r13_NO_NEW_CON_ONB_GNP;
	}

	public String getR13_NO_CON_END() {
		return R13_NO_CON_END;
	}

	public void setR13_NO_CON_END(String r13_NO_CON_END) {
		R13_NO_CON_END = r13_NO_CON_END;
	}

	public String getR14_BANK() {
		return R14_BANK;
	}

	public void setR14_BANK(String r14_BANK) {
		R14_BANK = r14_BANK;
	}

	public String getR14_PRODUCT() {
		return R14_PRODUCT;
	}

	public void setR14_PRODUCT(String r14_PRODUCT) {
		R14_PRODUCT = r14_PRODUCT;
	}

	public String getR14_NO_WO_SD() {
		return R14_NO_WO_SD;
	}

	public void setR14_NO_WO_SD(String r14_NO_WO_SD) {
		R14_NO_WO_SD = r14_NO_WO_SD;
	}

	public String getR14_NO_CON_POD_SD() {
		return R14_NO_CON_POD_SD;
	}

	public void setR14_NO_CON_POD_SD(String r14_NO_CON_POD_SD) {
		R14_NO_CON_POD_SD = r14_NO_CON_POD_SD;
	}

	public String getR14_NO_CON_UNAU_SP_TP() {
		return R14_NO_CON_UNAU_SP_TP;
	}

	public void setR14_NO_CON_UNAU_SP_TP(String r14_NO_CON_UNAU_SP_TP) {
		R14_NO_CON_UNAU_SP_TP = r14_NO_CON_UNAU_SP_TP;
	}

	public String getR14_NO_CON_45_50() {
		return R14_NO_CON_45_50;
	}

	public void setR14_NO_CON_45_50(String r14_NO_CON_45_50) {
		R14_NO_CON_45_50 = r14_NO_CON_45_50;
	}

	public String getR14_NO_CON_50() {
		return R14_NO_CON_50;
	}

	public void setR14_NO_CON_50(String r14_NO_CON_50) {
		R14_NO_CON_50 = r14_NO_CON_50;
	}

	public String getR14_NO_OF_LES_50() {
		return R14_NO_OF_LES_50;
	}

	public void setR14_NO_OF_LES_50(String r14_NO_OF_LES_50) {
		R14_NO_OF_LES_50 = r14_NO_OF_LES_50;
	}

	public String getR14_NO_OF_BNK_18() {
		return R14_NO_OF_BNK_18;
	}

	public void setR14_NO_OF_BNK_18(String r14_NO_OF_BNK_18) {
		R14_NO_OF_BNK_18 = r14_NO_OF_BNK_18;
	}

	public String getR14_NO_OF_BNK_18_25() {
		return R14_NO_OF_BNK_18_25;
	}

	public void setR14_NO_OF_BNK_18_25(String r14_NO_OF_BNK_18_25) {
		R14_NO_OF_BNK_18_25 = r14_NO_OF_BNK_18_25;
	}

	public String getR14_NO_OF_BNK_26_35() {
		return R14_NO_OF_BNK_26_35;
	}

	public void setR14_NO_OF_BNK_26_35(String r14_NO_OF_BNK_26_35) {
		R14_NO_OF_BNK_26_35 = r14_NO_OF_BNK_26_35;
	}

	public String getR14_NO_OF_BNK_36_50() {
		return R14_NO_OF_BNK_36_50;
	}

	public void setR14_NO_OF_BNK_36_50(String r14_NO_OF_BNK_36_50) {
		R14_NO_OF_BNK_36_50 = r14_NO_OF_BNK_36_50;
	}

	public String getR14_NO_CON_BNK_50() {
		return R14_NO_CON_BNK_50;
	}

	public void setR14_NO_CON_BNK_50(String r14_NO_CON_BNK_50) {
		R14_NO_CON_BNK_50 = r14_NO_CON_BNK_50;
	}

	public String getR14_NO_CON_SAL_SPD() {
		return R14_NO_CON_SAL_SPD;
	}

	public void setR14_NO_CON_SAL_SPD(String r14_NO_CON_SAL_SPD) {
		R14_NO_CON_SAL_SPD = r14_NO_CON_SAL_SPD;
	}

	public String getR14_NO_CON_BUS_SPD() {
		return R14_NO_CON_BUS_SPD;
	}

	public void setR14_NO_CON_BUS_SPD(String r14_NO_CON_BUS_SPD) {
		R14_NO_CON_BUS_SPD = r14_NO_CON_BUS_SPD;
	}

	public String getR14_NO_CON_PRO_SPD() {
		return R14_NO_CON_PRO_SPD;
	}

	public void setR14_NO_CON_PRO_SPD(String r14_NO_CON_PRO_SPD) {
		R14_NO_CON_PRO_SPD = r14_NO_CON_PRO_SPD;
	}

	public String getR14_NO_CON_INC_5K() {
		return R14_NO_CON_INC_5K;
	}

	public void setR14_NO_CON_INC_5K(String r14_NO_CON_INC_5K) {
		R14_NO_CON_INC_5K = r14_NO_CON_INC_5K;
	}

	public String getR14_NO_CON_INC_5K_10K() {
		return R14_NO_CON_INC_5K_10K;
	}

	public void setR14_NO_CON_INC_5K_10K(String r14_NO_CON_INC_5K_10K) {
		R14_NO_CON_INC_5K_10K = r14_NO_CON_INC_5K_10K;
	}

	public String getR14_NO_CON_INC_10K_20K() {
		return R14_NO_CON_INC_10K_20K;
	}

	public void setR14_NO_CON_INC_10K_20K(String r14_NO_CON_INC_10K_20K) {
		R14_NO_CON_INC_10K_20K = r14_NO_CON_INC_10K_20K;
	}

	public String getR14_NO_CON_INC_20K_35K() {
		return R14_NO_CON_INC_20K_35K;
	}

	public void setR14_NO_CON_INC_20K_35K(String r14_NO_CON_INC_20K_35K) {
		R14_NO_CON_INC_20K_35K = r14_NO_CON_INC_20K_35K;
	}

	public String getR14_NO_CON_INC_35K() {
		return R14_NO_CON_INC_35K;
	}

	public void setR14_NO_CON_INC_35K(String r14_NO_CON_INC_35K) {
		R14_NO_CON_INC_35K = r14_NO_CON_INC_35K;
	}

	public String getR14_NO_CON_BEL_SCL() {
		return R14_NO_CON_BEL_SCL;
	}

	public void setR14_NO_CON_BEL_SCL(String r14_NO_CON_BEL_SCL) {
		R14_NO_CON_BEL_SCL = r14_NO_CON_BEL_SCL;
	}

	public String getR14_NO_CON_BAC() {
		return R14_NO_CON_BAC;
	}

	public void setR14_NO_CON_BAC(String r14_NO_CON_BAC) {
		R14_NO_CON_BAC = r14_NO_CON_BAC;
	}

	public String getR14_NO_CON_ABV_MAS() {
		return R14_NO_CON_ABV_MAS;
	}

	public void setR14_NO_CON_ABV_MAS(String r14_NO_CON_ABV_MAS) {
		R14_NO_CON_ABV_MAS = r14_NO_CON_ABV_MAS;
	}

	public String getR14_NO_CON_ABU_KYC() {
		return R14_NO_CON_ABU_KYC;
	}

	public void setR14_NO_CON_ABU_KYC(String r14_NO_CON_ABU_KYC) {
		R14_NO_CON_ABU_KYC = r14_NO_CON_ABU_KYC;
	}

	public String getR14_NO_CON_DUB_KYC() {
		return R14_NO_CON_DUB_KYC;
	}

	public void setR14_NO_CON_DUB_KYC(String r14_NO_CON_DUB_KYC) {
		R14_NO_CON_DUB_KYC = r14_NO_CON_DUB_KYC;
	}

	public String getR14_NO_CON_SHJ_KYC() {
		return R14_NO_CON_SHJ_KYC;
	}

	public void setR14_NO_CON_SHJ_KYC(String r14_NO_CON_SHJ_KYC) {
		R14_NO_CON_SHJ_KYC = r14_NO_CON_SHJ_KYC;
	}

	public String getR14_NO_CON_AJM_KYC() {
		return R14_NO_CON_AJM_KYC;
	}

	public void setR14_NO_CON_AJM_KYC(String r14_NO_CON_AJM_KYC) {
		R14_NO_CON_AJM_KYC = r14_NO_CON_AJM_KYC;
	}

	public String getR14_NO_CON_FUJ_KYC() {
		return R14_NO_CON_FUJ_KYC;
	}

	public void setR14_NO_CON_FUJ_KYC(String r14_NO_CON_FUJ_KYC) {
		R14_NO_CON_FUJ_KYC = r14_NO_CON_FUJ_KYC;
	}

	public String getR14_NO_CON_RAK_KYC() {
		return R14_NO_CON_RAK_KYC;
	}

	public void setR14_NO_CON_RAK_KYC(String r14_NO_CON_RAK_KYC) {
		R14_NO_CON_RAK_KYC = r14_NO_CON_RAK_KYC;
	}

	public String getR14_NO_CON_UAQ_KYC() {
		return R14_NO_CON_UAQ_KYC;
	}

	public void setR14_NO_CON_UAQ_KYC(String r14_NO_CON_UAQ_KYC) {
		R14_NO_CON_UAQ_KYC = r14_NO_CON_UAQ_KYC;
	}

	public String getR14_NO_CON_RET() {
		return R14_NO_CON_RET;
	}

	public void setR14_NO_CON_RET(String r14_NO_CON_RET) {
		R14_NO_CON_RET = r14_NO_CON_RET;
	}

	public String getR14_NO_CON_DBR_LIM() {
		return R14_NO_CON_DBR_LIM;
	}

	public void setR14_NO_CON_DBR_LIM(String r14_NO_CON_DBR_LIM) {
		R14_NO_CON_DBR_LIM = r14_NO_CON_DBR_LIM;
	}

	public String getR14_NO_UAE_CON_SPC_TP() {
		return R14_NO_UAE_CON_SPC_TP;
	}

	public void setR14_NO_UAE_CON_SPC_TP(String r14_NO_UAE_CON_SPC_TP) {
		R14_NO_UAE_CON_SPC_TP = r14_NO_UAE_CON_SPC_TP;
	}

	public String getR14_NO_UAE_CON_NLS() {
		return R14_NO_UAE_CON_NLS;
	}

	public void setR14_NO_UAE_CON_NLS(String r14_NO_UAE_CON_NLS) {
		R14_NO_UAE_CON_NLS = r14_NO_UAE_CON_NLS;
	}

	public String getR14_VAL_LOS_AED() {
		return R14_VAL_LOS_AED;
	}

	public void setR14_VAL_LOS_AED(String r14_VAL_LOS_AED) {
		R14_VAL_LOS_AED = r14_VAL_LOS_AED;
	}

	public String getR14_NO_CON_ONB_90() {
		return R14_NO_CON_ONB_90;
	}

	public void setR14_NO_CON_ONB_90(String r14_NO_CON_ONB_90) {
		R14_NO_CON_ONB_90 = r14_NO_CON_ONB_90;
	}

	public String getR14_NO_CON_BAL_PAY() {
		return R14_NO_CON_BAL_PAY;
	}

	public void setR14_NO_CON_BAL_PAY(String r14_NO_CON_BAL_PAY) {
		R14_NO_CON_BAL_PAY = r14_NO_CON_BAL_PAY;
	}

	public String getR14_NO_CON_BAL_SPC_TP() {
		return R14_NO_CON_BAL_SPC_TP;
	}

	public void setR14_NO_CON_BAL_SPC_TP(String r14_NO_CON_BAL_SPC_TP) {
		R14_NO_CON_BAL_SPC_TP = r14_NO_CON_BAL_SPC_TP;
	}

	public String getR14_NO_CON_DEBT() {
		return R14_NO_CON_DEBT;
	}

	public void setR14_NO_CON_DEBT(String r14_NO_CON_DEBT) {
		R14_NO_CON_DEBT = r14_NO_CON_DEBT;
	}

	public String getR14_NO_CON_ONB_REF() {
		return R14_NO_CON_ONB_REF;
	}

	public void setR14_NO_CON_ONB_REF(String r14_NO_CON_ONB_REF) {
		R14_NO_CON_ONB_REF = r14_NO_CON_ONB_REF;
	}

	public String getR14_NO_CON_ONB_AGE() {
		return R14_NO_CON_ONB_AGE;
	}

	public void setR14_NO_CON_ONB_AGE(String r14_NO_CON_ONB_AGE) {
		R14_NO_CON_ONB_AGE = r14_NO_CON_ONB_AGE;
	}

	public String getR14_NO_CON_AFF_UNAU() {
		return R14_NO_CON_AFF_UNAU;
	}

	public void setR14_NO_CON_AFF_UNAU(String r14_NO_CON_AFF_UNAU) {
		R14_NO_CON_AFF_UNAU = r14_NO_CON_AFF_UNAU;
	}

	public String getR14_NO_OF_ACCS_POD() {
		return R14_NO_OF_ACCS_POD;
	}

	public void setR14_NO_OF_ACCS_POD(String r14_NO_OF_ACCS_POD) {
		R14_NO_OF_ACCS_POD = r14_NO_OF_ACCS_POD;
	}

	public String getR14_NO_DEL_CON() {
		return R14_NO_DEL_CON;
	}

	public void setR14_NO_DEL_CON(String r14_NO_DEL_CON) {
		R14_NO_DEL_CON = r14_NO_DEL_CON;
	}

	public String getR14_NO_INS_FUN_LFI() {
		return R14_NO_INS_FUN_LFI;
	}

	public void setR14_NO_INS_FUN_LFI(String r14_NO_INS_FUN_LFI) {
		R14_NO_INS_FUN_LFI = r14_NO_INS_FUN_LFI;
	}

	public String getR14_NO_CON_COL_FIN() {
		return R14_NO_CON_COL_FIN;
	}

	public void setR14_NO_CON_COL_FIN(String r14_NO_CON_COL_FIN) {
		R14_NO_CON_COL_FIN = r14_NO_CON_COL_FIN;
	}

	public String getR14_TOT_NO_NEW_FIN() {
		return R14_TOT_NO_NEW_FIN;
	}

	public void setR14_TOT_NO_NEW_FIN(String r14_TOT_NO_NEW_FIN) {
		R14_TOT_NO_NEW_FIN = r14_TOT_NO_NEW_FIN;
	}

	public String getR14_TOT_NO_NEW_NOSGN() {
		return R14_TOT_NO_NEW_NOSGN;
	}

	public void setR14_TOT_NO_NEW_NOSGN(String r14_TOT_NO_NEW_NOSGN) {
		R14_TOT_NO_NEW_NOSGN = r14_TOT_NO_NEW_NOSGN;
	}

	public String getR14_NO_CON_START() {
		return R14_NO_CON_START;
	}

	public void setR14_NO_CON_START(String r14_NO_CON_START) {
		R14_NO_CON_START = r14_NO_CON_START;
	}

	public String getR14_NO_NEW_CON_ONBO() {
		return R14_NO_NEW_CON_ONBO;
	}

	public void setR14_NO_NEW_CON_ONBO(String r14_NO_NEW_CON_ONBO) {
		R14_NO_NEW_CON_ONBO = r14_NO_NEW_CON_ONBO;
	}

	public String getR14_NO_CON_DEBT_COUN() {
		return R14_NO_CON_DEBT_COUN;
	}

	public void setR14_NO_CON_DEBT_COUN(String r14_NO_CON_DEBT_COUN) {
		R14_NO_CON_DEBT_COUN = r14_NO_CON_DEBT_COUN;
	}

	public String getR14_NO_CON_DEL_NPA() {
		return R14_NO_CON_DEL_NPA;
	}

	public void setR14_NO_CON_DEL_NPA(String r14_NO_CON_DEL_NPA) {
		R14_NO_CON_DEL_NPA = r14_NO_CON_DEL_NPA;
	}

	public String getR14_NO_CON_GOV_50() {
		return R14_NO_CON_GOV_50;
	}

	public void setR14_NO_CON_GOV_50(String r14_NO_CON_GOV_50) {
		R14_NO_CON_GOV_50 = r14_NO_CON_GOV_50;
	}

	public String getR14_NO_SME_SOLE() {
		return R14_NO_SME_SOLE;
	}

	public void setR14_NO_SME_SOLE(String r14_NO_SME_SOLE) {
		R14_NO_SME_SOLE = r14_NO_SME_SOLE;
	}

	public String getR14_NO_CON_TAG_VUL() {
		return R14_NO_CON_TAG_VUL;
	}

	public void setR14_NO_CON_TAG_VUL(String r14_NO_CON_TAG_VUL) {
		R14_NO_CON_TAG_VUL = r14_NO_CON_TAG_VUL;
	}

	public String getR14_NO_NEW_CON_ONB_GNP() {
		return R14_NO_NEW_CON_ONB_GNP;
	}

	public void setR14_NO_NEW_CON_ONB_GNP(String r14_NO_NEW_CON_ONB_GNP) {
		R14_NO_NEW_CON_ONB_GNP = r14_NO_NEW_CON_ONB_GNP;
	}

	public String getR14_NO_CON_END() {
		return R14_NO_CON_END;
	}

	public void setR14_NO_CON_END(String r14_NO_CON_END) {
		R14_NO_CON_END = r14_NO_CON_END;
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
