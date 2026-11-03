package com.bornfire.xbrl.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@IdClass(MCReportId.class)
@Table(name = "RT_MC_TABLE4_2")
public class RT_MC_TABLE4_2_ENTITY {
	
    public String R15_BANK;
    public String R15_PRODUCT;
    public String R15_AVG_TME_LWRSK;
    public String R15_AVG_NO_LOAN;
    public String R15_AVG_NO_LWRSK_SME;
    public String R15_AVG_NO_DYS_SME;
    public String R15_NO_REQ_CLO;
    public String R15_NO_PRD_VAR_SPC_TP;
    public String R15_NO_REQ_RES_SPT;
    public String R15_NO_REQ_PAYDEF;
    public String R15_AVG_TME_REPAY;
    public String R15_NO_INST_BAL;
    public String R15_NET_FEE_AED;
    public String R15_NET_PROF_AED;
    public String R15_TOT_NO_ACC_SPD;
    public String R15_TOT_ACCS_DOR;
    public String R15_TOT_NEW_LOAN;
    public String R15_TOT_VAL_NEWACCS_AED;
    public String R15_TOT_NO_LOAN_SPD;
    public String R15_TOT_REQ_OTBNK;
    public String R15_TOT_LOAN_OTBNK;
    public String R15_NO_CRACC_MIN;
    public String R15_AVG_TME_CLSACC;
    public String R15_N0_CON_MORE1_LOAN;
    public String R15_NO_INST_WITH90;
    public String R15_TOT_GROSS_ASET;
    public String R15_RET_LIAB_AED;
    public String R15_HIG_PER_PROD_CAT;
    public String R15_NO_ACCS_TAG_NPA;
    public String R15_NO_CHG_FEE_GRT5;
    public String R15_NO_CON_FLEX_INT;
    public String R15_NO_CON_FIXED_INT;
    public String R15_NO_LOAN_MAY_2011;
    public String R15_VAL_LEGA_MAY_AED;
    public String R15_AVG_DAY_NLL;
    public String R15_PER_DOR_ACCS;
    public String R15_INT_RET_PROF;
    public String R15_FEE_COMM_PROF;
    public String R15_TOT_UNCLM_90;
    public String R15_TOT_VAL_UNBAL;
    public String R15_NO_INST_CONTRACT;
    public String R15_TOT_DORACC_NOTICE;
    public String R15_NO_CONS_LIAB_7DAY;
    public String R15_TOT_REQ_LIAB_NONLIA;
    public String R15_NO_RESTU_ONBO;
    public String R15_TOT_DELAY_TAT;
    public String R15_TOT_FND_TRAN;
    public String R15_NO_FUND_RET24;
    public String R15_NO_FAIL_TRAN;
    public String R15_CUS_FND_SVF_SPT;
    public String R15_CUS_FND_SVF_PRE;
    public String R15_TOT_CRDR_UND_SPT;
    public String R15_TOT_CRD_ISU_SPT;
    public String R15_NO_ACC_BLK_FIN;
    public String R15_NO_INQ_AVL_BAL;
    public String R15_TOT_PRE_EXP_SPT;
    public String R15_TOT_PRE_POS_EXP;
    public String R15_TOT_PRE_CARD_SPD;
    public String R15_TOT_ACCS_SPD;
    public String R15_NO_LANG_VOICE;
    public String R15_AVG_NOD_LOWRSK;
    public String R15_NO_CUST_REISS_LIA;
    public String R15_NO_INS_CRRATE_CON;
    public String R16_BANK;
    public String R16_PRODUCT;
    public String R16_AVG_TME_LWRSK;
    public String R16_AVG_NO_LOAN;
    public String R16_AVG_NO_LWRSK_SME;
    public String R16_AVG_NO_DYS_SME;
    public String R16_NO_REQ_CLO;
    public String R16_NO_PRD_VAR_SPC_TP;
    public String R16_NO_REQ_RES_SPT;
    public String R16_NO_REQ_PAYDEF;
    public String R16_AVG_TME_REPAY;
    public String R16_NO_INST_BAL;
    public String R16_NET_FEE_AED;
    public String R16_NET_PROF_AED;
    public String R16_TOT_NO_ACC_SPD;
    public String R16_TOT_ACCS_DOR;
    public String R16_TOT_NEW_LOAN;
    public String R16_TOT_VAL_NEWACCS_AED;
    public String R16_TOT_NO_LOAN_SPD;
    public String R16_TOT_REQ_OTBNK;
    public String R16_TOT_LOAN_OTBNK;
    public String R16_NO_CRACC_MIN;
    public String R16_AVG_TME_CLSACC;
    public String R16_N0_CON_MORE1_LOAN;
    public String R16_NO_INST_WITH90;
    public String R16_TOT_GROSS_ASET;
    public String R16_RET_LIAB_AED;
    public String R16_HIG_PER_PROD_CAT;
    public String R16_NO_ACCS_TAG_NPA;
    public String R16_NO_CHG_FEE_GRT5;
    public String R16_NO_CON_FLEX_INT;
    public String R16_NO_CON_FIXED_INT;
    public String R16_NO_LOAN_MAY_2011;
    public String R16_VAL_LEGA_MAY_AED;
    public String R16_AVG_DAY_NLL;
    public String R16_PER_DOR_ACCS;
    public String R16_INT_RET_PROF;
    public String R16_FEE_COMM_PROF;
    public String R16_TOT_UNCLM_90;
    public String R16_TOT_VAL_UNBAL;
    public String R16_NO_INST_CONTRACT;
    public String R16_TOT_DORACC_NOTICE;
    public String R16_NO_CONS_LIAB_7DAY;
    public String R16_TOT_REQ_LIAB_NONLIA;
    public String R16_NO_RESTU_ONBO;
    public String R16_TOT_DELAY_TAT;
    public String R16_TOT_FND_TRAN;
    public String R16_NO_FUND_RET24;
    public String R16_NO_FAIL_TRAN;
    public String R16_CUS_FND_SVF_SPT;
    public String R16_CUS_FND_SVF_PRE;
    public String R16_TOT_CRDR_UND_SPT;
    public String R16_TOT_CRD_ISU_SPT;
    public String R16_NO_ACC_BLK_FIN;
    public String R16_NO_INQ_AVL_BAL;
    public String R16_TOT_PRE_EXP_SPT;
    public String R16_TOT_PRE_POS_EXP;
    public String R16_TOT_PRE_CARD_SPD;
    public String R16_TOT_ACCS_SPD;
    public String R16_NO_LANG_VOICE;
    public String R16_AVG_NOD_LOWRSK;
    public String R16_NO_CUST_REISS_LIA;
    public String R16_NO_INS_CRRATE_CON;
    public String R17_BANK;
    public String R17_PRODUCT;
    public String R17_AVG_TME_LWRSK;
    public String R17_AVG_NO_LOAN;
    public String R17_AVG_NO_LWRSK_SME;
    public String R17_AVG_NO_DYS_SME;
    public String R17_NO_REQ_CLO;
    public String R17_NO_PRD_VAR_SPC_TP;
    public String R17_NO_REQ_RES_SPT;
    public String R17_NO_REQ_PAYDEF;
    public String R17_AVG_TME_REPAY;
    public String R17_NO_INST_BAL;
    public String R17_NET_FEE_AED;
    public String R17_NET_PROF_AED;
    public String R17_TOT_NO_ACC_SPD;
    public String R17_TOT_ACCS_DOR;
    public String R17_TOT_NEW_LOAN;
    public String R17_TOT_VAL_NEWACCS_AED;
    public String R17_TOT_NO_LOAN_SPD;
    public String R17_TOT_REQ_OTBNK;
    public String R17_TOT_LOAN_OTBNK;
    public String R17_NO_CRACC_MIN;
    public String R17_AVG_TME_CLSACC;
    public String R17_N0_CON_MORE1_LOAN;
    public String R17_NO_INST_WITH90;
    public String R17_TOT_GROSS_ASET;
    public String R17_RET_LIAB_AED;
    public String R17_HIG_PER_PROD_CAT;
    public String R17_NO_ACCS_TAG_NPA;
    public String R17_NO_CHG_FEE_GRT5;
    public String R17_NO_CON_FLEX_INT;
    public String R17_NO_CON_FIXED_INT;
    public String R17_NO_LOAN_MAY_2011;
    public String R17_VAL_LEGA_MAY_AED;
    public String R17_AVG_DAY_NLL;
    public String R17_PER_DOR_ACCS;
    public String R17_INT_RET_PROF;
    public String R17_FEE_COMM_PROF;
    public String R17_TOT_UNCLM_90;
    public String R17_TOT_VAL_UNBAL;
    public String R17_NO_INST_CONTRACT;
    public String R17_TOT_DORACC_NOTICE;
    public String R17_NO_CONS_LIAB_7DAY;
    public String R17_TOT_REQ_LIAB_NONLIA;
    public String R17_NO_RESTU_ONBO;
    public String R17_TOT_DELAY_TAT;
    public String R17_TOT_FND_TRAN;
    public String R17_NO_FUND_RET24;
    public String R17_NO_FAIL_TRAN;
    public String R17_CUS_FND_SVF_SPT;
    public String R17_CUS_FND_SVF_PRE;
    public String R17_TOT_CRDR_UND_SPT;
    public String R17_TOT_CRD_ISU_SPT;
    public String R17_NO_ACC_BLK_FIN;
    public String R17_NO_INQ_AVL_BAL;
    public String R17_TOT_PRE_EXP_SPT;
    public String R17_TOT_PRE_POS_EXP;
    public String R17_TOT_PRE_CARD_SPD;
    public String R17_TOT_ACCS_SPD;
    public String R17_NO_LANG_VOICE;
    public String R17_AVG_NOD_LOWRSK;
    public String R17_NO_CUST_REISS_LIA;
    public String R17_NO_INS_CRRATE_CON;
    public String R18_BANK;
    public String R18_PRODUCT;
    public String R18_AVG_TME_LWRSK;
    public String R18_AVG_NO_LOAN;
    public String R18_AVG_NO_LWRSK_SME;
    public String R18_AVG_NO_DYS_SME;
    public String R18_NO_REQ_CLO;
    public String R18_NO_PRD_VAR_SPC_TP;
    public String R18_NO_REQ_RES_SPT;
    public String R18_NO_REQ_PAYDEF;
    public String R18_AVG_TME_REPAY;
    public String R18_NO_INST_BAL;
    public String R18_NET_FEE_AED;
    public String R18_NET_PROF_AED;
    public String R18_TOT_NO_ACC_SPD;
    public String R18_TOT_ACCS_DOR;
    public String R18_TOT_NEW_LOAN;
    public String R18_TOT_VAL_NEWACCS_AED;
    public String R18_TOT_NO_LOAN_SPD;
    public String R18_TOT_REQ_OTBNK;
    public String R18_TOT_LOAN_OTBNK;
    public String R18_NO_CRACC_MIN;
    public String R18_AVG_TME_CLSACC;
    public String R18_N0_CON_MORE1_LOAN;
    public String R18_NO_INST_WITH90;
    public String R18_TOT_GROSS_ASET;
    public String R18_RET_LIAB_AED;
    public String R18_HIG_PER_PROD_CAT;
    public String R18_NO_ACCS_TAG_NPA;
    public String R18_NO_CHG_FEE_GRT5;
    public String R18_NO_CON_FLEX_INT;
    public String R18_NO_CON_FIXED_INT;
    public String R18_NO_LOAN_MAY_2011;
    public String R18_VAL_LEGA_MAY_AED;
    public String R18_AVG_DAY_NLL;
    public String R18_PER_DOR_ACCS;
    public String R18_INT_RET_PROF;
    public String R18_FEE_COMM_PROF;
    public String R18_TOT_UNCLM_90;
    public String R18_TOT_VAL_UNBAL;
    public String R18_NO_INST_CONTRACT;
    public String R18_TOT_DORACC_NOTICE;
    public String R18_NO_CONS_LIAB_7DAY;
    public String R18_TOT_REQ_LIAB_NONLIA;
    public String R18_NO_RESTU_ONBO;
    public String R18_TOT_DELAY_TAT;
    public String R18_TOT_FND_TRAN;
    public String R18_NO_FUND_RET24;
    public String R18_NO_FAIL_TRAN;
    public String R18_CUS_FND_SVF_SPT;
    public String R18_CUS_FND_SVF_PRE;
    public String R18_TOT_CRDR_UND_SPT;
    public String R18_TOT_CRD_ISU_SPT;
    public String R18_NO_ACC_BLK_FIN;
    public String R18_NO_INQ_AVL_BAL;
    public String R18_TOT_PRE_EXP_SPT;
    public String R18_TOT_PRE_POS_EXP;
    public String R18_TOT_PRE_CARD_SPD;
    public String R18_TOT_ACCS_SPD;
    public String R18_NO_LANG_VOICE;
    public String R18_AVG_NOD_LOWRSK;
    public String R18_NO_CUST_REISS_LIA;
    public String R18_NO_INS_CRRATE_CON;
    public String R19_BANK;
    public String R19_PRODUCT;
    public String R19_AVG_TME_LWRSK;
    public String R19_AVG_NO_LOAN;
    public String R19_AVG_NO_LWRSK_SME;
    public String R19_AVG_NO_DYS_SME;
    public String R19_NO_REQ_CLO;
    public String R19_NO_PRD_VAR_SPC_TP;
    public String R19_NO_REQ_RES_SPT;
    public String R19_NO_REQ_PAYDEF;
    public String R19_AVG_TME_REPAY;
    public String R19_NO_INST_BAL;
    public String R19_NET_FEE_AED;
    public String R19_NET_PROF_AED;
    public String R19_TOT_NO_ACC_SPD;
    public String R19_TOT_ACCS_DOR;
    public String R19_TOT_NEW_LOAN;
    public String R19_TOT_VAL_NEWACCS_AED;
    public String R19_TOT_NO_LOAN_SPD;
    public String R19_TOT_REQ_OTBNK;
    public String R19_TOT_LOAN_OTBNK;
    public String R19_NO_CRACC_MIN;
    public String R19_AVG_TME_CLSACC;
    public String R19_N0_CON_MORE1_LOAN;
    public String R19_NO_INST_WITH90;
    public String R19_TOT_GROSS_ASET;
    public String R19_RET_LIAB_AED;
    public String R19_HIG_PER_PROD_CAT;
    public String R19_NO_ACCS_TAG_NPA;
    public String R19_NO_CHG_FEE_GRT5;
    public String R19_NO_CON_FLEX_INT;
    public String R19_NO_CON_FIXED_INT;
    public String R19_NO_LOAN_MAY_2011;
    public String R19_VAL_LEGA_MAY_AED;
    public String R19_AVG_DAY_NLL;
    public String R19_PER_DOR_ACCS;
    public String R19_INT_RET_PROF;
    public String R19_FEE_COMM_PROF;
    public String R19_TOT_UNCLM_90;
    public String R19_TOT_VAL_UNBAL;
    public String R19_NO_INST_CONTRACT;
    public String R19_TOT_DORACC_NOTICE;
    public String R19_NO_CONS_LIAB_7DAY;
    public String R19_TOT_REQ_LIAB_NONLIA;
    public String R19_NO_RESTU_ONBO;
    public String R19_TOT_DELAY_TAT;
    public String R19_TOT_FND_TRAN;
    public String R19_NO_FUND_RET24;
    public String R19_NO_FAIL_TRAN;
    public String R19_CUS_FND_SVF_SPT;
    public String R19_CUS_FND_SVF_PRE;
    public String R19_TOT_CRDR_UND_SPT;
    public String R19_TOT_CRD_ISU_SPT;
    public String R19_NO_ACC_BLK_FIN;
    public String R19_NO_INQ_AVL_BAL;
    public String R19_TOT_PRE_EXP_SPT;
    public String R19_TOT_PRE_POS_EXP;
    public String R19_TOT_PRE_CARD_SPD;
    public String R19_TOT_ACCS_SPD;
    public String R19_NO_LANG_VOICE;
    public String R19_AVG_NOD_LOWRSK;
    public String R19_NO_CUST_REISS_LIA;
    public String R19_NO_INS_CRRATE_CON;
    public String R20_BANK;
    public String R20_PRODUCT;
    public String R20_AVG_TME_LWRSK;
    public String R20_AVG_NO_LOAN;
    public String R20_AVG_NO_LWRSK_SME;
    public String R20_AVG_NO_DYS_SME;
    public String R20_NO_REQ_CLO;
    public String R20_NO_PRD_VAR_SPC_TP;
    public String R20_NO_REQ_RES_SPT;
    public String R20_NO_REQ_PAYDEF;
    public String R20_AVG_TME_REPAY;
    public String R20_NO_INST_BAL;
    public String R20_NET_FEE_AED;
    public String R20_NET_PROF_AED;
    public String R20_TOT_NO_ACC_SPD;
    public String R20_TOT_ACCS_DOR;
    public String R20_TOT_NEW_LOAN;
    public String R20_TOT_VAL_NEWACCS_AED;
    public String R20_TOT_NO_LOAN_SPD;
    public String R20_TOT_REQ_OTBNK;
    public String R20_TOT_LOAN_OTBNK;
    public String R20_NO_CRACC_MIN;
    public String R20_AVG_TME_CLSACC;
    public String R20_N0_CON_MORE1_LOAN;
    public String R20_NO_INST_WITH90;
    public String R20_TOT_GROSS_ASET;
    public String R20_RET_LIAB_AED;
    public String R20_HIG_PER_PROD_CAT;
    public String R20_NO_ACCS_TAG_NPA;
    public String R20_NO_CHG_FEE_GRT5;
    public String R20_NO_CON_FLEX_INT;
    public String R20_NO_CON_FIXED_INT;
    public String R20_NO_LOAN_MAY_2011;
    public String R20_VAL_LEGA_MAY_AED;
    public String R20_AVG_DAY_NLL;
    public String R20_PER_DOR_ACCS;
    public String R20_INT_RET_PROF;
    public String R20_FEE_COMM_PROF;
    public String R20_TOT_UNCLM_90;
    public String R20_TOT_VAL_UNBAL;
    public String R20_NO_INST_CONTRACT;
    public String R20_TOT_DORACC_NOTICE;
    public String R20_NO_CONS_LIAB_7DAY;
    public String R20_TOT_REQ_LIAB_NONLIA;
    public String R20_NO_RESTU_ONBO;
    public String R20_TOT_DELAY_TAT;
    public String R20_TOT_FND_TRAN;
    public String R20_NO_FUND_RET24;
    public String R20_NO_FAIL_TRAN;
    public String R20_CUS_FND_SVF_SPT;
    public String R20_CUS_FND_SVF_PRE;
    public String R20_TOT_CRDR_UND_SPT;
    public String R20_TOT_CRD_ISU_SPT;
    public String R20_NO_ACC_BLK_FIN;
    public String R20_NO_INQ_AVL_BAL;
    public String R20_TOT_PRE_EXP_SPT;
    public String R20_TOT_PRE_POS_EXP;
    public String R20_TOT_PRE_CARD_SPD;
    public String R20_TOT_ACCS_SPD;
    public String R20_NO_LANG_VOICE;
    public String R20_AVG_NOD_LOWRSK;
    public String R20_NO_CUST_REISS_LIA;
    public String R20_NO_INS_CRRATE_CON;
    public String R21_BANK;
    public String R21_PRODUCT;
    public String R21_AVG_TME_LWRSK;
    public String R21_AVG_NO_LOAN;
    public String R21_AVG_NO_LWRSK_SME;
    public String R21_AVG_NO_DYS_SME;
    public String R21_NO_REQ_CLO;
    public String R21_NO_PRD_VAR_SPC_TP;
    public String R21_NO_REQ_RES_SPT;
    public String R21_NO_REQ_PAYDEF;
    public String R21_AVG_TME_REPAY;
    public String R21_NO_INST_BAL;
    public String R21_NET_FEE_AED;
    public String R21_NET_PROF_AED;
    public String R21_TOT_NO_ACC_SPD;
    public String R21_TOT_ACCS_DOR;
    public String R21_TOT_NEW_LOAN;
    public String R21_TOT_VAL_NEWACCS_AED;
    public String R21_TOT_NO_LOAN_SPD;
    public String R21_TOT_REQ_OTBNK;
    public String R21_TOT_LOAN_OTBNK;
    public String R21_NO_CRACC_MIN;
    public String R21_AVG_TME_CLSACC;
    public String R21_N0_CON_MORE1_LOAN;
    public String R21_NO_INST_WITH90;
    public String R21_TOT_GROSS_ASET;
    public String R21_RET_LIAB_AED;
    public String R21_HIG_PER_PROD_CAT;
    public String R21_NO_ACCS_TAG_NPA;
    public String R21_NO_CHG_FEE_GRT5;
    public String R21_NO_CON_FLEX_INT;
    public String R21_NO_CON_FIXED_INT;
    public String R21_NO_LOAN_MAY_2011;
    public String R21_VAL_LEGA_MAY_AED;
    public String R21_AVG_DAY_NLL;
    public String R21_PER_DOR_ACCS;
    public String R21_INT_RET_PROF;
    public String R21_FEE_COMM_PROF;
    public String R21_TOT_UNCLM_90;
    public String R21_TOT_VAL_UNBAL;
    public String R21_NO_INST_CONTRACT;
    public String R21_TOT_DORACC_NOTICE;
    public String R21_NO_CONS_LIAB_7DAY;
    public String R21_TOT_REQ_LIAB_NONLIA;
    public String R21_NO_RESTU_ONBO;
    public String R21_TOT_DELAY_TAT;
    public String R21_TOT_FND_TRAN;
    public String R21_NO_FUND_RET24;
    public String R21_NO_FAIL_TRAN;
    public String R21_CUS_FND_SVF_SPT;
    public String R21_CUS_FND_SVF_PRE;
    public String R21_TOT_CRDR_UND_SPT;
    public String R21_TOT_CRD_ISU_SPT;
    public String R21_NO_ACC_BLK_FIN;
    public String R21_NO_INQ_AVL_BAL;
    public String R21_TOT_PRE_EXP_SPT;
    public String R21_TOT_PRE_POS_EXP;
    public String R21_TOT_PRE_CARD_SPD;
    public String R21_TOT_ACCS_SPD;
    public String R21_NO_LANG_VOICE;
    public String R21_AVG_NOD_LOWRSK;
    public String R21_NO_CUST_REISS_LIA;
    public String R21_NO_INS_CRRATE_CON;
    public String R22_BANK;
    public String R22_PRODUCT;
    public String R22_AVG_TME_LWRSK;
    public String R22_AVG_NO_LOAN;
    public String R22_AVG_NO_LWRSK_SME;
    public String R22_AVG_NO_DYS_SME;
    public String R22_NO_REQ_CLO;
    public String R22_NO_PRD_VAR_SPC_TP;
    public String R22_NO_REQ_RES_SPT;
    public String R22_NO_REQ_PAYDEF;
    public String R22_AVG_TME_REPAY;
    public String R22_NO_INST_BAL;
    public String R22_NET_FEE_AED;
    public String R22_NET_PROF_AED;
    public String R22_TOT_NO_ACC_SPD;
    public String R22_TOT_ACCS_DOR;
    public String R22_TOT_NEW_LOAN;
    public String R22_TOT_VAL_NEWACCS_AED;
    public String R22_TOT_NO_LOAN_SPD;
    public String R22_TOT_REQ_OTBNK;
    public String R22_TOT_LOAN_OTBNK;
    public String R22_NO_CRACC_MIN;
    public String R22_AVG_TME_CLSACC;
    public String R22_N0_CON_MORE1_LOAN;
    public String R22_NO_INST_WITH90;
    public String R22_TOT_GROSS_ASET;
    public String R22_RET_LIAB_AED;
    public String R22_HIG_PER_PROD_CAT;
    public String R22_NO_ACCS_TAG_NPA;
    public String R22_NO_CHG_FEE_GRT5;
    public String R22_NO_CON_FLEX_INT;
    public String R22_NO_CON_FIXED_INT;
    public String R22_NO_LOAN_MAY_2011;
    public String R22_VAL_LEGA_MAY_AED;
    public String R22_AVG_DAY_NLL;
    public String R22_PER_DOR_ACCS;
    public String R22_INT_RET_PROF;
    public String R22_FEE_COMM_PROF;
    public String R22_TOT_UNCLM_90;
    public String R22_TOT_VAL_UNBAL;
    public String R22_NO_INST_CONTRACT;
    public String R22_TOT_DORACC_NOTICE;
    public String R22_NO_CONS_LIAB_7DAY;
    public String R22_TOT_REQ_LIAB_NONLIA;
    public String R22_NO_RESTU_ONBO;
    public String R22_TOT_DELAY_TAT;
    public String R22_TOT_FND_TRAN;
    public String R22_NO_FUND_RET24;
    public String R22_NO_FAIL_TRAN;
    public String R22_CUS_FND_SVF_SPT;
    public String R22_CUS_FND_SVF_PRE;
    public String R22_TOT_CRDR_UND_SPT;
    public String R22_TOT_CRD_ISU_SPT;
    public String R22_NO_ACC_BLK_FIN;
    public String R22_NO_INQ_AVL_BAL;
    public String R22_TOT_PRE_EXP_SPT;
    public String R22_TOT_PRE_POS_EXP;
    public String R22_TOT_PRE_CARD_SPD;
    public String R22_TOT_ACCS_SPD;
    public String R22_NO_LANG_VOICE;
    public String R22_AVG_NOD_LOWRSK;
    public String R22_NO_CUST_REISS_LIA;
    public String R22_NO_INS_CRRATE_CON;
    public String R23_BANK;
    public String R23_PRODUCT;
    public String R23_AVG_TME_LWRSK;
    public String R23_AVG_NO_LOAN;
    public String R23_AVG_NO_LWRSK_SME;
    public String R23_AVG_NO_DYS_SME;
    public String R23_NO_REQ_CLO;
    public String R23_NO_PRD_VAR_SPC_TP;
    public String R23_NO_REQ_RES_SPT;
    public String R23_NO_REQ_PAYDEF;
    public String R23_AVG_TME_REPAY;
    public String R23_NO_INST_BAL;
    public String R23_NET_FEE_AED;
    public String R23_NET_PROF_AED;
    public String R23_TOT_NO_ACC_SPD;
    public String R23_TOT_ACCS_DOR;
    public String R23_TOT_NEW_LOAN;
    public String R23_TOT_VAL_NEWACCS_AED;
    public String R23_TOT_NO_LOAN_SPD;
    public String R23_TOT_REQ_OTBNK;
    public String R23_TOT_LOAN_OTBNK;
    public String R23_NO_CRACC_MIN;
    public String R23_AVG_TME_CLSACC;
    public String R23_N0_CON_MORE1_LOAN;
    public String R23_NO_INST_WITH90;
    public String R23_TOT_GROSS_ASET;
    public String R23_RET_LIAB_AED;
    public String R23_HIG_PER_PROD_CAT;
    public String R23_NO_ACCS_TAG_NPA;
    public String R23_NO_CHG_FEE_GRT5;
    public String R23_NO_CON_FLEX_INT;
    public String R23_NO_CON_FIXED_INT;
    public String R23_NO_LOAN_MAY_2011;
    public String R23_VAL_LEGA_MAY_AED;
    public String R23_AVG_DAY_NLL;
    public String R23_PER_DOR_ACCS;
    public String R23_INT_RET_PROF;
    public String R23_FEE_COMM_PROF;
    public String R23_TOT_UNCLM_90;
    public String R23_TOT_VAL_UNBAL;
    public String R23_NO_INST_CONTRACT;
    public String R23_TOT_DORACC_NOTICE;
    public String R23_NO_CONS_LIAB_7DAY;
    public String R23_TOT_REQ_LIAB_NONLIA;
    public String R23_NO_RESTU_ONBO;
    public String R23_TOT_DELAY_TAT;
    public String R23_TOT_FND_TRAN;
    public String R23_NO_FUND_RET24;
    public String R23_NO_FAIL_TRAN;
    public String R23_CUS_FND_SVF_SPT;
    public String R23_CUS_FND_SVF_PRE;
    public String R23_TOT_CRDR_UND_SPT;
    public String R23_TOT_CRD_ISU_SPT;
    public String R23_NO_ACC_BLK_FIN;
    public String R23_NO_INQ_AVL_BAL;
    public String R23_TOT_PRE_EXP_SPT;
    public String R23_TOT_PRE_POS_EXP;
    public String R23_TOT_PRE_CARD_SPD;
    public String R23_TOT_ACCS_SPD;
    public String R23_NO_LANG_VOICE;
    public String R23_AVG_NOD_LOWRSK;
    public String R23_NO_CUST_REISS_LIA;
    public String R23_NO_INS_CRRATE_CON;
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
	public String getR15_AVG_TME_LWRSK() {
		return R15_AVG_TME_LWRSK;
	}
	public void setR15_AVG_TME_LWRSK(String r15_AVG_TME_LWRSK) {
		R15_AVG_TME_LWRSK = r15_AVG_TME_LWRSK;
	}
	public String getR15_AVG_NO_LOAN() {
		return R15_AVG_NO_LOAN;
	}
	public void setR15_AVG_NO_LOAN(String r15_AVG_NO_LOAN) {
		R15_AVG_NO_LOAN = r15_AVG_NO_LOAN;
	}
	public String getR15_AVG_NO_LWRSK_SME() {
		return R15_AVG_NO_LWRSK_SME;
	}
	public void setR15_AVG_NO_LWRSK_SME(String r15_AVG_NO_LWRSK_SME) {
		R15_AVG_NO_LWRSK_SME = r15_AVG_NO_LWRSK_SME;
	}
	public String getR15_AVG_NO_DYS_SME() {
		return R15_AVG_NO_DYS_SME;
	}
	public void setR15_AVG_NO_DYS_SME(String r15_AVG_NO_DYS_SME) {
		R15_AVG_NO_DYS_SME = r15_AVG_NO_DYS_SME;
	}
	public String getR15_NO_REQ_CLO() {
		return R15_NO_REQ_CLO;
	}
	public void setR15_NO_REQ_CLO(String r15_NO_REQ_CLO) {
		R15_NO_REQ_CLO = r15_NO_REQ_CLO;
	}
	public String getR15_NO_PRD_VAR_SPC_TP() {
		return R15_NO_PRD_VAR_SPC_TP;
	}
	public void setR15_NO_PRD_VAR_SPC_TP(String r15_NO_PRD_VAR_SPC_TP) {
		R15_NO_PRD_VAR_SPC_TP = r15_NO_PRD_VAR_SPC_TP;
	}
	public String getR15_NO_REQ_RES_SPT() {
		return R15_NO_REQ_RES_SPT;
	}
	public void setR15_NO_REQ_RES_SPT(String r15_NO_REQ_RES_SPT) {
		R15_NO_REQ_RES_SPT = r15_NO_REQ_RES_SPT;
	}
	public String getR15_NO_REQ_PAYDEF() {
		return R15_NO_REQ_PAYDEF;
	}
	public void setR15_NO_REQ_PAYDEF(String r15_NO_REQ_PAYDEF) {
		R15_NO_REQ_PAYDEF = r15_NO_REQ_PAYDEF;
	}
	public String getR15_AVG_TME_REPAY() {
		return R15_AVG_TME_REPAY;
	}
	public void setR15_AVG_TME_REPAY(String r15_AVG_TME_REPAY) {
		R15_AVG_TME_REPAY = r15_AVG_TME_REPAY;
	}
	public String getR15_NO_INST_BAL() {
		return R15_NO_INST_BAL;
	}
	public void setR15_NO_INST_BAL(String r15_NO_INST_BAL) {
		R15_NO_INST_BAL = r15_NO_INST_BAL;
	}
	public String getR15_NET_FEE_AED() {
		return R15_NET_FEE_AED;
	}
	public void setR15_NET_FEE_AED(String r15_NET_FEE_AED) {
		R15_NET_FEE_AED = r15_NET_FEE_AED;
	}
	public String getR15_NET_PROF_AED() {
		return R15_NET_PROF_AED;
	}
	public void setR15_NET_PROF_AED(String r15_NET_PROF_AED) {
		R15_NET_PROF_AED = r15_NET_PROF_AED;
	}
	public String getR15_TOT_NO_ACC_SPD() {
		return R15_TOT_NO_ACC_SPD;
	}
	public void setR15_TOT_NO_ACC_SPD(String r15_TOT_NO_ACC_SPD) {
		R15_TOT_NO_ACC_SPD = r15_TOT_NO_ACC_SPD;
	}
	public String getR15_TOT_ACCS_DOR() {
		return R15_TOT_ACCS_DOR;
	}
	public void setR15_TOT_ACCS_DOR(String r15_TOT_ACCS_DOR) {
		R15_TOT_ACCS_DOR = r15_TOT_ACCS_DOR;
	}
	public String getR15_TOT_NEW_LOAN() {
		return R15_TOT_NEW_LOAN;
	}
	public void setR15_TOT_NEW_LOAN(String r15_TOT_NEW_LOAN) {
		R15_TOT_NEW_LOAN = r15_TOT_NEW_LOAN;
	}
	public String getR15_TOT_VAL_NEWACCS_AED() {
		return R15_TOT_VAL_NEWACCS_AED;
	}
	public void setR15_TOT_VAL_NEWACCS_AED(String r15_TOT_VAL_NEWACCS_AED) {
		R15_TOT_VAL_NEWACCS_AED = r15_TOT_VAL_NEWACCS_AED;
	}
	public String getR15_TOT_NO_LOAN_SPD() {
		return R15_TOT_NO_LOAN_SPD;
	}
	public void setR15_TOT_NO_LOAN_SPD(String r15_TOT_NO_LOAN_SPD) {
		R15_TOT_NO_LOAN_SPD = r15_TOT_NO_LOAN_SPD;
	}
	public String getR15_TOT_REQ_OTBNK() {
		return R15_TOT_REQ_OTBNK;
	}
	public void setR15_TOT_REQ_OTBNK(String r15_TOT_REQ_OTBNK) {
		R15_TOT_REQ_OTBNK = r15_TOT_REQ_OTBNK;
	}
	public String getR15_TOT_LOAN_OTBNK() {
		return R15_TOT_LOAN_OTBNK;
	}
	public void setR15_TOT_LOAN_OTBNK(String r15_TOT_LOAN_OTBNK) {
		R15_TOT_LOAN_OTBNK = r15_TOT_LOAN_OTBNK;
	}
	public String getR15_NO_CRACC_MIN() {
		return R15_NO_CRACC_MIN;
	}
	public void setR15_NO_CRACC_MIN(String r15_NO_CRACC_MIN) {
		R15_NO_CRACC_MIN = r15_NO_CRACC_MIN;
	}
	public String getR15_AVG_TME_CLSACC() {
		return R15_AVG_TME_CLSACC;
	}
	public void setR15_AVG_TME_CLSACC(String r15_AVG_TME_CLSACC) {
		R15_AVG_TME_CLSACC = r15_AVG_TME_CLSACC;
	}
	public String getR15_N0_CON_MORE1_LOAN() {
		return R15_N0_CON_MORE1_LOAN;
	}
	public void setR15_N0_CON_MORE1_LOAN(String r15_N0_CON_MORE1_LOAN) {
		R15_N0_CON_MORE1_LOAN = r15_N0_CON_MORE1_LOAN;
	}
	public String getR15_NO_INST_WITH90() {
		return R15_NO_INST_WITH90;
	}
	public void setR15_NO_INST_WITH90(String r15_NO_INST_WITH90) {
		R15_NO_INST_WITH90 = r15_NO_INST_WITH90;
	}
	public String getR15_TOT_GROSS_ASET() {
		return R15_TOT_GROSS_ASET;
	}
	public void setR15_TOT_GROSS_ASET(String r15_TOT_GROSS_ASET) {
		R15_TOT_GROSS_ASET = r15_TOT_GROSS_ASET;
	}
	public String getR15_RET_LIAB_AED() {
		return R15_RET_LIAB_AED;
	}
	public void setR15_RET_LIAB_AED(String r15_RET_LIAB_AED) {
		R15_RET_LIAB_AED = r15_RET_LIAB_AED;
	}
	public String getR15_HIG_PER_PROD_CAT() {
		return R15_HIG_PER_PROD_CAT;
	}
	public void setR15_HIG_PER_PROD_CAT(String r15_HIG_PER_PROD_CAT) {
		R15_HIG_PER_PROD_CAT = r15_HIG_PER_PROD_CAT;
	}
	public String getR15_NO_ACCS_TAG_NPA() {
		return R15_NO_ACCS_TAG_NPA;
	}
	public void setR15_NO_ACCS_TAG_NPA(String r15_NO_ACCS_TAG_NPA) {
		R15_NO_ACCS_TAG_NPA = r15_NO_ACCS_TAG_NPA;
	}
	public String getR15_NO_CHG_FEE_GRT5() {
		return R15_NO_CHG_FEE_GRT5;
	}
	public void setR15_NO_CHG_FEE_GRT5(String r15_NO_CHG_FEE_GRT5) {
		R15_NO_CHG_FEE_GRT5 = r15_NO_CHG_FEE_GRT5;
	}
	public String getR15_NO_CON_FLEX_INT() {
		return R15_NO_CON_FLEX_INT;
	}
	public void setR15_NO_CON_FLEX_INT(String r15_NO_CON_FLEX_INT) {
		R15_NO_CON_FLEX_INT = r15_NO_CON_FLEX_INT;
	}
	public String getR15_NO_CON_FIXED_INT() {
		return R15_NO_CON_FIXED_INT;
	}
	public void setR15_NO_CON_FIXED_INT(String r15_NO_CON_FIXED_INT) {
		R15_NO_CON_FIXED_INT = r15_NO_CON_FIXED_INT;
	}
	public String getR15_NO_LOAN_MAY_2011() {
		return R15_NO_LOAN_MAY_2011;
	}
	public void setR15_NO_LOAN_MAY_2011(String r15_NO_LOAN_MAY_2011) {
		R15_NO_LOAN_MAY_2011 = r15_NO_LOAN_MAY_2011;
	}
	public String getR15_VAL_LEGA_MAY_AED() {
		return R15_VAL_LEGA_MAY_AED;
	}
	public void setR15_VAL_LEGA_MAY_AED(String r15_VAL_LEGA_MAY_AED) {
		R15_VAL_LEGA_MAY_AED = r15_VAL_LEGA_MAY_AED;
	}
	public String getR15_AVG_DAY_NLL() {
		return R15_AVG_DAY_NLL;
	}
	public void setR15_AVG_DAY_NLL(String r15_AVG_DAY_NLL) {
		R15_AVG_DAY_NLL = r15_AVG_DAY_NLL;
	}
	public String getR15_PER_DOR_ACCS() {
		return R15_PER_DOR_ACCS;
	}
	public void setR15_PER_DOR_ACCS(String r15_PER_DOR_ACCS) {
		R15_PER_DOR_ACCS = r15_PER_DOR_ACCS;
	}
	public String getR15_INT_RET_PROF() {
		return R15_INT_RET_PROF;
	}
	public void setR15_INT_RET_PROF(String r15_INT_RET_PROF) {
		R15_INT_RET_PROF = r15_INT_RET_PROF;
	}
	public String getR15_FEE_COMM_PROF() {
		return R15_FEE_COMM_PROF;
	}
	public void setR15_FEE_COMM_PROF(String r15_FEE_COMM_PROF) {
		R15_FEE_COMM_PROF = r15_FEE_COMM_PROF;
	}
	public String getR15_TOT_UNCLM_90() {
		return R15_TOT_UNCLM_90;
	}
	public void setR15_TOT_UNCLM_90(String r15_TOT_UNCLM_90) {
		R15_TOT_UNCLM_90 = r15_TOT_UNCLM_90;
	}
	public String getR15_TOT_VAL_UNBAL() {
		return R15_TOT_VAL_UNBAL;
	}
	public void setR15_TOT_VAL_UNBAL(String r15_TOT_VAL_UNBAL) {
		R15_TOT_VAL_UNBAL = r15_TOT_VAL_UNBAL;
	}
	public String getR15_NO_INST_CONTRACT() {
		return R15_NO_INST_CONTRACT;
	}
	public void setR15_NO_INST_CONTRACT(String r15_NO_INST_CONTRACT) {
		R15_NO_INST_CONTRACT = r15_NO_INST_CONTRACT;
	}
	public String getR15_TOT_DORACC_NOTICE() {
		return R15_TOT_DORACC_NOTICE;
	}
	public void setR15_TOT_DORACC_NOTICE(String r15_TOT_DORACC_NOTICE) {
		R15_TOT_DORACC_NOTICE = r15_TOT_DORACC_NOTICE;
	}
	public String getR15_NO_CONS_LIAB_7DAY() {
		return R15_NO_CONS_LIAB_7DAY;
	}
	public void setR15_NO_CONS_LIAB_7DAY(String r15_NO_CONS_LIAB_7DAY) {
		R15_NO_CONS_LIAB_7DAY = r15_NO_CONS_LIAB_7DAY;
	}
	public String getR15_TOT_REQ_LIAB_NONLIA() {
		return R15_TOT_REQ_LIAB_NONLIA;
	}
	public void setR15_TOT_REQ_LIAB_NONLIA(String r15_TOT_REQ_LIAB_NONLIA) {
		R15_TOT_REQ_LIAB_NONLIA = r15_TOT_REQ_LIAB_NONLIA;
	}
	public String getR15_NO_RESTU_ONBO() {
		return R15_NO_RESTU_ONBO;
	}
	public void setR15_NO_RESTU_ONBO(String r15_NO_RESTU_ONBO) {
		R15_NO_RESTU_ONBO = r15_NO_RESTU_ONBO;
	}
	public String getR15_TOT_DELAY_TAT() {
		return R15_TOT_DELAY_TAT;
	}
	public void setR15_TOT_DELAY_TAT(String r15_TOT_DELAY_TAT) {
		R15_TOT_DELAY_TAT = r15_TOT_DELAY_TAT;
	}
	public String getR15_TOT_FND_TRAN() {
		return R15_TOT_FND_TRAN;
	}
	public void setR15_TOT_FND_TRAN(String r15_TOT_FND_TRAN) {
		R15_TOT_FND_TRAN = r15_TOT_FND_TRAN;
	}
	public String getR15_NO_FUND_RET24() {
		return R15_NO_FUND_RET24;
	}
	public void setR15_NO_FUND_RET24(String r15_NO_FUND_RET24) {
		R15_NO_FUND_RET24 = r15_NO_FUND_RET24;
	}
	public String getR15_NO_FAIL_TRAN() {
		return R15_NO_FAIL_TRAN;
	}
	public void setR15_NO_FAIL_TRAN(String r15_NO_FAIL_TRAN) {
		R15_NO_FAIL_TRAN = r15_NO_FAIL_TRAN;
	}
	public String getR15_CUS_FND_SVF_SPT() {
		return R15_CUS_FND_SVF_SPT;
	}
	public void setR15_CUS_FND_SVF_SPT(String r15_CUS_FND_SVF_SPT) {
		R15_CUS_FND_SVF_SPT = r15_CUS_FND_SVF_SPT;
	}
	public String getR15_CUS_FND_SVF_PRE() {
		return R15_CUS_FND_SVF_PRE;
	}
	public void setR15_CUS_FND_SVF_PRE(String r15_CUS_FND_SVF_PRE) {
		R15_CUS_FND_SVF_PRE = r15_CUS_FND_SVF_PRE;
	}
	public String getR15_TOT_CRDR_UND_SPT() {
		return R15_TOT_CRDR_UND_SPT;
	}
	public void setR15_TOT_CRDR_UND_SPT(String r15_TOT_CRDR_UND_SPT) {
		R15_TOT_CRDR_UND_SPT = r15_TOT_CRDR_UND_SPT;
	}
	public String getR15_TOT_CRD_ISU_SPT() {
		return R15_TOT_CRD_ISU_SPT;
	}
	public void setR15_TOT_CRD_ISU_SPT(String r15_TOT_CRD_ISU_SPT) {
		R15_TOT_CRD_ISU_SPT = r15_TOT_CRD_ISU_SPT;
	}
	public String getR15_NO_ACC_BLK_FIN() {
		return R15_NO_ACC_BLK_FIN;
	}
	public void setR15_NO_ACC_BLK_FIN(String r15_NO_ACC_BLK_FIN) {
		R15_NO_ACC_BLK_FIN = r15_NO_ACC_BLK_FIN;
	}
	public String getR15_NO_INQ_AVL_BAL() {
		return R15_NO_INQ_AVL_BAL;
	}
	public void setR15_NO_INQ_AVL_BAL(String r15_NO_INQ_AVL_BAL) {
		R15_NO_INQ_AVL_BAL = r15_NO_INQ_AVL_BAL;
	}
	public String getR15_TOT_PRE_EXP_SPT() {
		return R15_TOT_PRE_EXP_SPT;
	}
	public void setR15_TOT_PRE_EXP_SPT(String r15_TOT_PRE_EXP_SPT) {
		R15_TOT_PRE_EXP_SPT = r15_TOT_PRE_EXP_SPT;
	}
	public String getR15_TOT_PRE_POS_EXP() {
		return R15_TOT_PRE_POS_EXP;
	}
	public void setR15_TOT_PRE_POS_EXP(String r15_TOT_PRE_POS_EXP) {
		R15_TOT_PRE_POS_EXP = r15_TOT_PRE_POS_EXP;
	}
	public String getR15_TOT_PRE_CARD_SPD() {
		return R15_TOT_PRE_CARD_SPD;
	}
	public void setR15_TOT_PRE_CARD_SPD(String r15_TOT_PRE_CARD_SPD) {
		R15_TOT_PRE_CARD_SPD = r15_TOT_PRE_CARD_SPD;
	}
	public String getR15_TOT_ACCS_SPD() {
		return R15_TOT_ACCS_SPD;
	}
	public void setR15_TOT_ACCS_SPD(String r15_TOT_ACCS_SPD) {
		R15_TOT_ACCS_SPD = r15_TOT_ACCS_SPD;
	}
	public String getR15_NO_LANG_VOICE() {
		return R15_NO_LANG_VOICE;
	}
	public void setR15_NO_LANG_VOICE(String r15_NO_LANG_VOICE) {
		R15_NO_LANG_VOICE = r15_NO_LANG_VOICE;
	}
	public String getR15_AVG_NOD_LOWRSK() {
		return R15_AVG_NOD_LOWRSK;
	}
	public void setR15_AVG_NOD_LOWRSK(String r15_AVG_NOD_LOWRSK) {
		R15_AVG_NOD_LOWRSK = r15_AVG_NOD_LOWRSK;
	}
	public String getR15_NO_CUST_REISS_LIA() {
		return R15_NO_CUST_REISS_LIA;
	}
	public void setR15_NO_CUST_REISS_LIA(String r15_NO_CUST_REISS_LIA) {
		R15_NO_CUST_REISS_LIA = r15_NO_CUST_REISS_LIA;
	}
	public String getR15_NO_INS_CRRATE_CON() {
		return R15_NO_INS_CRRATE_CON;
	}
	public void setR15_NO_INS_CRRATE_CON(String r15_NO_INS_CRRATE_CON) {
		R15_NO_INS_CRRATE_CON = r15_NO_INS_CRRATE_CON;
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
	public String getR16_AVG_TME_LWRSK() {
		return R16_AVG_TME_LWRSK;
	}
	public void setR16_AVG_TME_LWRSK(String r16_AVG_TME_LWRSK) {
		R16_AVG_TME_LWRSK = r16_AVG_TME_LWRSK;
	}
	public String getR16_AVG_NO_LOAN() {
		return R16_AVG_NO_LOAN;
	}
	public void setR16_AVG_NO_LOAN(String r16_AVG_NO_LOAN) {
		R16_AVG_NO_LOAN = r16_AVG_NO_LOAN;
	}
	public String getR16_AVG_NO_LWRSK_SME() {
		return R16_AVG_NO_LWRSK_SME;
	}
	public void setR16_AVG_NO_LWRSK_SME(String r16_AVG_NO_LWRSK_SME) {
		R16_AVG_NO_LWRSK_SME = r16_AVG_NO_LWRSK_SME;
	}
	public String getR16_AVG_NO_DYS_SME() {
		return R16_AVG_NO_DYS_SME;
	}
	public void setR16_AVG_NO_DYS_SME(String r16_AVG_NO_DYS_SME) {
		R16_AVG_NO_DYS_SME = r16_AVG_NO_DYS_SME;
	}
	public String getR16_NO_REQ_CLO() {
		return R16_NO_REQ_CLO;
	}
	public void setR16_NO_REQ_CLO(String r16_NO_REQ_CLO) {
		R16_NO_REQ_CLO = r16_NO_REQ_CLO;
	}
	public String getR16_NO_PRD_VAR_SPC_TP() {
		return R16_NO_PRD_VAR_SPC_TP;
	}
	public void setR16_NO_PRD_VAR_SPC_TP(String r16_NO_PRD_VAR_SPC_TP) {
		R16_NO_PRD_VAR_SPC_TP = r16_NO_PRD_VAR_SPC_TP;
	}
	public String getR16_NO_REQ_RES_SPT() {
		return R16_NO_REQ_RES_SPT;
	}
	public void setR16_NO_REQ_RES_SPT(String r16_NO_REQ_RES_SPT) {
		R16_NO_REQ_RES_SPT = r16_NO_REQ_RES_SPT;
	}
	public String getR16_NO_REQ_PAYDEF() {
		return R16_NO_REQ_PAYDEF;
	}
	public void setR16_NO_REQ_PAYDEF(String r16_NO_REQ_PAYDEF) {
		R16_NO_REQ_PAYDEF = r16_NO_REQ_PAYDEF;
	}
	public String getR16_AVG_TME_REPAY() {
		return R16_AVG_TME_REPAY;
	}
	public void setR16_AVG_TME_REPAY(String r16_AVG_TME_REPAY) {
		R16_AVG_TME_REPAY = r16_AVG_TME_REPAY;
	}
	public String getR16_NO_INST_BAL() {
		return R16_NO_INST_BAL;
	}
	public void setR16_NO_INST_BAL(String r16_NO_INST_BAL) {
		R16_NO_INST_BAL = r16_NO_INST_BAL;
	}
	public String getR16_NET_FEE_AED() {
		return R16_NET_FEE_AED;
	}
	public void setR16_NET_FEE_AED(String r16_NET_FEE_AED) {
		R16_NET_FEE_AED = r16_NET_FEE_AED;
	}
	public String getR16_NET_PROF_AED() {
		return R16_NET_PROF_AED;
	}
	public void setR16_NET_PROF_AED(String r16_NET_PROF_AED) {
		R16_NET_PROF_AED = r16_NET_PROF_AED;
	}
	public String getR16_TOT_NO_ACC_SPD() {
		return R16_TOT_NO_ACC_SPD;
	}
	public void setR16_TOT_NO_ACC_SPD(String r16_TOT_NO_ACC_SPD) {
		R16_TOT_NO_ACC_SPD = r16_TOT_NO_ACC_SPD;
	}
	public String getR16_TOT_ACCS_DOR() {
		return R16_TOT_ACCS_DOR;
	}
	public void setR16_TOT_ACCS_DOR(String r16_TOT_ACCS_DOR) {
		R16_TOT_ACCS_DOR = r16_TOT_ACCS_DOR;
	}
	public String getR16_TOT_NEW_LOAN() {
		return R16_TOT_NEW_LOAN;
	}
	public void setR16_TOT_NEW_LOAN(String r16_TOT_NEW_LOAN) {
		R16_TOT_NEW_LOAN = r16_TOT_NEW_LOAN;
	}
	public String getR16_TOT_VAL_NEWACCS_AED() {
		return R16_TOT_VAL_NEWACCS_AED;
	}
	public void setR16_TOT_VAL_NEWACCS_AED(String r16_TOT_VAL_NEWACCS_AED) {
		R16_TOT_VAL_NEWACCS_AED = r16_TOT_VAL_NEWACCS_AED;
	}
	public String getR16_TOT_NO_LOAN_SPD() {
		return R16_TOT_NO_LOAN_SPD;
	}
	public void setR16_TOT_NO_LOAN_SPD(String r16_TOT_NO_LOAN_SPD) {
		R16_TOT_NO_LOAN_SPD = r16_TOT_NO_LOAN_SPD;
	}
	public String getR16_TOT_REQ_OTBNK() {
		return R16_TOT_REQ_OTBNK;
	}
	public void setR16_TOT_REQ_OTBNK(String r16_TOT_REQ_OTBNK) {
		R16_TOT_REQ_OTBNK = r16_TOT_REQ_OTBNK;
	}
	public String getR16_TOT_LOAN_OTBNK() {
		return R16_TOT_LOAN_OTBNK;
	}
	public void setR16_TOT_LOAN_OTBNK(String r16_TOT_LOAN_OTBNK) {
		R16_TOT_LOAN_OTBNK = r16_TOT_LOAN_OTBNK;
	}
	public String getR16_NO_CRACC_MIN() {
		return R16_NO_CRACC_MIN;
	}
	public void setR16_NO_CRACC_MIN(String r16_NO_CRACC_MIN) {
		R16_NO_CRACC_MIN = r16_NO_CRACC_MIN;
	}
	public String getR16_AVG_TME_CLSACC() {
		return R16_AVG_TME_CLSACC;
	}
	public void setR16_AVG_TME_CLSACC(String r16_AVG_TME_CLSACC) {
		R16_AVG_TME_CLSACC = r16_AVG_TME_CLSACC;
	}
	public String getR16_N0_CON_MORE1_LOAN() {
		return R16_N0_CON_MORE1_LOAN;
	}
	public void setR16_N0_CON_MORE1_LOAN(String r16_N0_CON_MORE1_LOAN) {
		R16_N0_CON_MORE1_LOAN = r16_N0_CON_MORE1_LOAN;
	}
	public String getR16_NO_INST_WITH90() {
		return R16_NO_INST_WITH90;
	}
	public void setR16_NO_INST_WITH90(String r16_NO_INST_WITH90) {
		R16_NO_INST_WITH90 = r16_NO_INST_WITH90;
	}
	public String getR16_TOT_GROSS_ASET() {
		return R16_TOT_GROSS_ASET;
	}
	public void setR16_TOT_GROSS_ASET(String r16_TOT_GROSS_ASET) {
		R16_TOT_GROSS_ASET = r16_TOT_GROSS_ASET;
	}
	public String getR16_RET_LIAB_AED() {
		return R16_RET_LIAB_AED;
	}
	public void setR16_RET_LIAB_AED(String r16_RET_LIAB_AED) {
		R16_RET_LIAB_AED = r16_RET_LIAB_AED;
	}
	public String getR16_HIG_PER_PROD_CAT() {
		return R16_HIG_PER_PROD_CAT;
	}
	public void setR16_HIG_PER_PROD_CAT(String r16_HIG_PER_PROD_CAT) {
		R16_HIG_PER_PROD_CAT = r16_HIG_PER_PROD_CAT;
	}
	public String getR16_NO_ACCS_TAG_NPA() {
		return R16_NO_ACCS_TAG_NPA;
	}
	public void setR16_NO_ACCS_TAG_NPA(String r16_NO_ACCS_TAG_NPA) {
		R16_NO_ACCS_TAG_NPA = r16_NO_ACCS_TAG_NPA;
	}
	public String getR16_NO_CHG_FEE_GRT5() {
		return R16_NO_CHG_FEE_GRT5;
	}
	public void setR16_NO_CHG_FEE_GRT5(String r16_NO_CHG_FEE_GRT5) {
		R16_NO_CHG_FEE_GRT5 = r16_NO_CHG_FEE_GRT5;
	}
	public String getR16_NO_CON_FLEX_INT() {
		return R16_NO_CON_FLEX_INT;
	}
	public void setR16_NO_CON_FLEX_INT(String r16_NO_CON_FLEX_INT) {
		R16_NO_CON_FLEX_INT = r16_NO_CON_FLEX_INT;
	}
	public String getR16_NO_CON_FIXED_INT() {
		return R16_NO_CON_FIXED_INT;
	}
	public void setR16_NO_CON_FIXED_INT(String r16_NO_CON_FIXED_INT) {
		R16_NO_CON_FIXED_INT = r16_NO_CON_FIXED_INT;
	}
	public String getR16_NO_LOAN_MAY_2011() {
		return R16_NO_LOAN_MAY_2011;
	}
	public void setR16_NO_LOAN_MAY_2011(String r16_NO_LOAN_MAY_2011) {
		R16_NO_LOAN_MAY_2011 = r16_NO_LOAN_MAY_2011;
	}
	public String getR16_VAL_LEGA_MAY_AED() {
		return R16_VAL_LEGA_MAY_AED;
	}
	public void setR16_VAL_LEGA_MAY_AED(String r16_VAL_LEGA_MAY_AED) {
		R16_VAL_LEGA_MAY_AED = r16_VAL_LEGA_MAY_AED;
	}
	public String getR16_AVG_DAY_NLL() {
		return R16_AVG_DAY_NLL;
	}
	public void setR16_AVG_DAY_NLL(String r16_AVG_DAY_NLL) {
		R16_AVG_DAY_NLL = r16_AVG_DAY_NLL;
	}
	public String getR16_PER_DOR_ACCS() {
		return R16_PER_DOR_ACCS;
	}
	public void setR16_PER_DOR_ACCS(String r16_PER_DOR_ACCS) {
		R16_PER_DOR_ACCS = r16_PER_DOR_ACCS;
	}
	public String getR16_INT_RET_PROF() {
		return R16_INT_RET_PROF;
	}
	public void setR16_INT_RET_PROF(String r16_INT_RET_PROF) {
		R16_INT_RET_PROF = r16_INT_RET_PROF;
	}
	public String getR16_FEE_COMM_PROF() {
		return R16_FEE_COMM_PROF;
	}
	public void setR16_FEE_COMM_PROF(String r16_FEE_COMM_PROF) {
		R16_FEE_COMM_PROF = r16_FEE_COMM_PROF;
	}
	public String getR16_TOT_UNCLM_90() {
		return R16_TOT_UNCLM_90;
	}
	public void setR16_TOT_UNCLM_90(String r16_TOT_UNCLM_90) {
		R16_TOT_UNCLM_90 = r16_TOT_UNCLM_90;
	}
	public String getR16_TOT_VAL_UNBAL() {
		return R16_TOT_VAL_UNBAL;
	}
	public void setR16_TOT_VAL_UNBAL(String r16_TOT_VAL_UNBAL) {
		R16_TOT_VAL_UNBAL = r16_TOT_VAL_UNBAL;
	}
	public String getR16_NO_INST_CONTRACT() {
		return R16_NO_INST_CONTRACT;
	}
	public void setR16_NO_INST_CONTRACT(String r16_NO_INST_CONTRACT) {
		R16_NO_INST_CONTRACT = r16_NO_INST_CONTRACT;
	}
	public String getR16_TOT_DORACC_NOTICE() {
		return R16_TOT_DORACC_NOTICE;
	}
	public void setR16_TOT_DORACC_NOTICE(String r16_TOT_DORACC_NOTICE) {
		R16_TOT_DORACC_NOTICE = r16_TOT_DORACC_NOTICE;
	}
	public String getR16_NO_CONS_LIAB_7DAY() {
		return R16_NO_CONS_LIAB_7DAY;
	}
	public void setR16_NO_CONS_LIAB_7DAY(String r16_NO_CONS_LIAB_7DAY) {
		R16_NO_CONS_LIAB_7DAY = r16_NO_CONS_LIAB_7DAY;
	}
	public String getR16_TOT_REQ_LIAB_NONLIA() {
		return R16_TOT_REQ_LIAB_NONLIA;
	}
	public void setR16_TOT_REQ_LIAB_NONLIA(String r16_TOT_REQ_LIAB_NONLIA) {
		R16_TOT_REQ_LIAB_NONLIA = r16_TOT_REQ_LIAB_NONLIA;
	}
	public String getR16_NO_RESTU_ONBO() {
		return R16_NO_RESTU_ONBO;
	}
	public void setR16_NO_RESTU_ONBO(String r16_NO_RESTU_ONBO) {
		R16_NO_RESTU_ONBO = r16_NO_RESTU_ONBO;
	}
	public String getR16_TOT_DELAY_TAT() {
		return R16_TOT_DELAY_TAT;
	}
	public void setR16_TOT_DELAY_TAT(String r16_TOT_DELAY_TAT) {
		R16_TOT_DELAY_TAT = r16_TOT_DELAY_TAT;
	}
	public String getR16_TOT_FND_TRAN() {
		return R16_TOT_FND_TRAN;
	}
	public void setR16_TOT_FND_TRAN(String r16_TOT_FND_TRAN) {
		R16_TOT_FND_TRAN = r16_TOT_FND_TRAN;
	}
	public String getR16_NO_FUND_RET24() {
		return R16_NO_FUND_RET24;
	}
	public void setR16_NO_FUND_RET24(String r16_NO_FUND_RET24) {
		R16_NO_FUND_RET24 = r16_NO_FUND_RET24;
	}
	public String getR16_NO_FAIL_TRAN() {
		return R16_NO_FAIL_TRAN;
	}
	public void setR16_NO_FAIL_TRAN(String r16_NO_FAIL_TRAN) {
		R16_NO_FAIL_TRAN = r16_NO_FAIL_TRAN;
	}
	public String getR16_CUS_FND_SVF_SPT() {
		return R16_CUS_FND_SVF_SPT;
	}
	public void setR16_CUS_FND_SVF_SPT(String r16_CUS_FND_SVF_SPT) {
		R16_CUS_FND_SVF_SPT = r16_CUS_FND_SVF_SPT;
	}
	public String getR16_CUS_FND_SVF_PRE() {
		return R16_CUS_FND_SVF_PRE;
	}
	public void setR16_CUS_FND_SVF_PRE(String r16_CUS_FND_SVF_PRE) {
		R16_CUS_FND_SVF_PRE = r16_CUS_FND_SVF_PRE;
	}
	public String getR16_TOT_CRDR_UND_SPT() {
		return R16_TOT_CRDR_UND_SPT;
	}
	public void setR16_TOT_CRDR_UND_SPT(String r16_TOT_CRDR_UND_SPT) {
		R16_TOT_CRDR_UND_SPT = r16_TOT_CRDR_UND_SPT;
	}
	public String getR16_TOT_CRD_ISU_SPT() {
		return R16_TOT_CRD_ISU_SPT;
	}
	public void setR16_TOT_CRD_ISU_SPT(String r16_TOT_CRD_ISU_SPT) {
		R16_TOT_CRD_ISU_SPT = r16_TOT_CRD_ISU_SPT;
	}
	public String getR16_NO_ACC_BLK_FIN() {
		return R16_NO_ACC_BLK_FIN;
	}
	public void setR16_NO_ACC_BLK_FIN(String r16_NO_ACC_BLK_FIN) {
		R16_NO_ACC_BLK_FIN = r16_NO_ACC_BLK_FIN;
	}
	public String getR16_NO_INQ_AVL_BAL() {
		return R16_NO_INQ_AVL_BAL;
	}
	public void setR16_NO_INQ_AVL_BAL(String r16_NO_INQ_AVL_BAL) {
		R16_NO_INQ_AVL_BAL = r16_NO_INQ_AVL_BAL;
	}
	public String getR16_TOT_PRE_EXP_SPT() {
		return R16_TOT_PRE_EXP_SPT;
	}
	public void setR16_TOT_PRE_EXP_SPT(String r16_TOT_PRE_EXP_SPT) {
		R16_TOT_PRE_EXP_SPT = r16_TOT_PRE_EXP_SPT;
	}
	public String getR16_TOT_PRE_POS_EXP() {
		return R16_TOT_PRE_POS_EXP;
	}
	public void setR16_TOT_PRE_POS_EXP(String r16_TOT_PRE_POS_EXP) {
		R16_TOT_PRE_POS_EXP = r16_TOT_PRE_POS_EXP;
	}
	public String getR16_TOT_PRE_CARD_SPD() {
		return R16_TOT_PRE_CARD_SPD;
	}
	public void setR16_TOT_PRE_CARD_SPD(String r16_TOT_PRE_CARD_SPD) {
		R16_TOT_PRE_CARD_SPD = r16_TOT_PRE_CARD_SPD;
	}
	public String getR16_TOT_ACCS_SPD() {
		return R16_TOT_ACCS_SPD;
	}
	public void setR16_TOT_ACCS_SPD(String r16_TOT_ACCS_SPD) {
		R16_TOT_ACCS_SPD = r16_TOT_ACCS_SPD;
	}
	public String getR16_NO_LANG_VOICE() {
		return R16_NO_LANG_VOICE;
	}
	public void setR16_NO_LANG_VOICE(String r16_NO_LANG_VOICE) {
		R16_NO_LANG_VOICE = r16_NO_LANG_VOICE;
	}
	public String getR16_AVG_NOD_LOWRSK() {
		return R16_AVG_NOD_LOWRSK;
	}
	public void setR16_AVG_NOD_LOWRSK(String r16_AVG_NOD_LOWRSK) {
		R16_AVG_NOD_LOWRSK = r16_AVG_NOD_LOWRSK;
	}
	public String getR16_NO_CUST_REISS_LIA() {
		return R16_NO_CUST_REISS_LIA;
	}
	public void setR16_NO_CUST_REISS_LIA(String r16_NO_CUST_REISS_LIA) {
		R16_NO_CUST_REISS_LIA = r16_NO_CUST_REISS_LIA;
	}
	public String getR16_NO_INS_CRRATE_CON() {
		return R16_NO_INS_CRRATE_CON;
	}
	public void setR16_NO_INS_CRRATE_CON(String r16_NO_INS_CRRATE_CON) {
		R16_NO_INS_CRRATE_CON = r16_NO_INS_CRRATE_CON;
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
	public String getR17_AVG_TME_LWRSK() {
		return R17_AVG_TME_LWRSK;
	}
	public void setR17_AVG_TME_LWRSK(String r17_AVG_TME_LWRSK) {
		R17_AVG_TME_LWRSK = r17_AVG_TME_LWRSK;
	}
	public String getR17_AVG_NO_LOAN() {
		return R17_AVG_NO_LOAN;
	}
	public void setR17_AVG_NO_LOAN(String r17_AVG_NO_LOAN) {
		R17_AVG_NO_LOAN = r17_AVG_NO_LOAN;
	}
	public String getR17_AVG_NO_LWRSK_SME() {
		return R17_AVG_NO_LWRSK_SME;
	}
	public void setR17_AVG_NO_LWRSK_SME(String r17_AVG_NO_LWRSK_SME) {
		R17_AVG_NO_LWRSK_SME = r17_AVG_NO_LWRSK_SME;
	}
	public String getR17_AVG_NO_DYS_SME() {
		return R17_AVG_NO_DYS_SME;
	}
	public void setR17_AVG_NO_DYS_SME(String r17_AVG_NO_DYS_SME) {
		R17_AVG_NO_DYS_SME = r17_AVG_NO_DYS_SME;
	}
	public String getR17_NO_REQ_CLO() {
		return R17_NO_REQ_CLO;
	}
	public void setR17_NO_REQ_CLO(String r17_NO_REQ_CLO) {
		R17_NO_REQ_CLO = r17_NO_REQ_CLO;
	}
	public String getR17_NO_PRD_VAR_SPC_TP() {
		return R17_NO_PRD_VAR_SPC_TP;
	}
	public void setR17_NO_PRD_VAR_SPC_TP(String r17_NO_PRD_VAR_SPC_TP) {
		R17_NO_PRD_VAR_SPC_TP = r17_NO_PRD_VAR_SPC_TP;
	}
	public String getR17_NO_REQ_RES_SPT() {
		return R17_NO_REQ_RES_SPT;
	}
	public void setR17_NO_REQ_RES_SPT(String r17_NO_REQ_RES_SPT) {
		R17_NO_REQ_RES_SPT = r17_NO_REQ_RES_SPT;
	}
	public String getR17_NO_REQ_PAYDEF() {
		return R17_NO_REQ_PAYDEF;
	}
	public void setR17_NO_REQ_PAYDEF(String r17_NO_REQ_PAYDEF) {
		R17_NO_REQ_PAYDEF = r17_NO_REQ_PAYDEF;
	}
	public String getR17_AVG_TME_REPAY() {
		return R17_AVG_TME_REPAY;
	}
	public void setR17_AVG_TME_REPAY(String r17_AVG_TME_REPAY) {
		R17_AVG_TME_REPAY = r17_AVG_TME_REPAY;
	}
	public String getR17_NO_INST_BAL() {
		return R17_NO_INST_BAL;
	}
	public void setR17_NO_INST_BAL(String r17_NO_INST_BAL) {
		R17_NO_INST_BAL = r17_NO_INST_BAL;
	}
	public String getR17_NET_FEE_AED() {
		return R17_NET_FEE_AED;
	}
	public void setR17_NET_FEE_AED(String r17_NET_FEE_AED) {
		R17_NET_FEE_AED = r17_NET_FEE_AED;
	}
	public String getR17_NET_PROF_AED() {
		return R17_NET_PROF_AED;
	}
	public void setR17_NET_PROF_AED(String r17_NET_PROF_AED) {
		R17_NET_PROF_AED = r17_NET_PROF_AED;
	}
	public String getR17_TOT_NO_ACC_SPD() {
		return R17_TOT_NO_ACC_SPD;
	}
	public void setR17_TOT_NO_ACC_SPD(String r17_TOT_NO_ACC_SPD) {
		R17_TOT_NO_ACC_SPD = r17_TOT_NO_ACC_SPD;
	}
	public String getR17_TOT_ACCS_DOR() {
		return R17_TOT_ACCS_DOR;
	}
	public void setR17_TOT_ACCS_DOR(String r17_TOT_ACCS_DOR) {
		R17_TOT_ACCS_DOR = r17_TOT_ACCS_DOR;
	}
	public String getR17_TOT_NEW_LOAN() {
		return R17_TOT_NEW_LOAN;
	}
	public void setR17_TOT_NEW_LOAN(String r17_TOT_NEW_LOAN) {
		R17_TOT_NEW_LOAN = r17_TOT_NEW_LOAN;
	}
	public String getR17_TOT_VAL_NEWACCS_AED() {
		return R17_TOT_VAL_NEWACCS_AED;
	}
	public void setR17_TOT_VAL_NEWACCS_AED(String r17_TOT_VAL_NEWACCS_AED) {
		R17_TOT_VAL_NEWACCS_AED = r17_TOT_VAL_NEWACCS_AED;
	}
	public String getR17_TOT_NO_LOAN_SPD() {
		return R17_TOT_NO_LOAN_SPD;
	}
	public void setR17_TOT_NO_LOAN_SPD(String r17_TOT_NO_LOAN_SPD) {
		R17_TOT_NO_LOAN_SPD = r17_TOT_NO_LOAN_SPD;
	}
	public String getR17_TOT_REQ_OTBNK() {
		return R17_TOT_REQ_OTBNK;
	}
	public void setR17_TOT_REQ_OTBNK(String r17_TOT_REQ_OTBNK) {
		R17_TOT_REQ_OTBNK = r17_TOT_REQ_OTBNK;
	}
	public String getR17_TOT_LOAN_OTBNK() {
		return R17_TOT_LOAN_OTBNK;
	}
	public void setR17_TOT_LOAN_OTBNK(String r17_TOT_LOAN_OTBNK) {
		R17_TOT_LOAN_OTBNK = r17_TOT_LOAN_OTBNK;
	}
	public String getR17_NO_CRACC_MIN() {
		return R17_NO_CRACC_MIN;
	}
	public void setR17_NO_CRACC_MIN(String r17_NO_CRACC_MIN) {
		R17_NO_CRACC_MIN = r17_NO_CRACC_MIN;
	}
	public String getR17_AVG_TME_CLSACC() {
		return R17_AVG_TME_CLSACC;
	}
	public void setR17_AVG_TME_CLSACC(String r17_AVG_TME_CLSACC) {
		R17_AVG_TME_CLSACC = r17_AVG_TME_CLSACC;
	}
	public String getR17_N0_CON_MORE1_LOAN() {
		return R17_N0_CON_MORE1_LOAN;
	}
	public void setR17_N0_CON_MORE1_LOAN(String r17_N0_CON_MORE1_LOAN) {
		R17_N0_CON_MORE1_LOAN = r17_N0_CON_MORE1_LOAN;
	}
	public String getR17_NO_INST_WITH90() {
		return R17_NO_INST_WITH90;
	}
	public void setR17_NO_INST_WITH90(String r17_NO_INST_WITH90) {
		R17_NO_INST_WITH90 = r17_NO_INST_WITH90;
	}
	public String getR17_TOT_GROSS_ASET() {
		return R17_TOT_GROSS_ASET;
	}
	public void setR17_TOT_GROSS_ASET(String r17_TOT_GROSS_ASET) {
		R17_TOT_GROSS_ASET = r17_TOT_GROSS_ASET;
	}
	public String getR17_RET_LIAB_AED() {
		return R17_RET_LIAB_AED;
	}
	public void setR17_RET_LIAB_AED(String r17_RET_LIAB_AED) {
		R17_RET_LIAB_AED = r17_RET_LIAB_AED;
	}
	public String getR17_HIG_PER_PROD_CAT() {
		return R17_HIG_PER_PROD_CAT;
	}
	public void setR17_HIG_PER_PROD_CAT(String r17_HIG_PER_PROD_CAT) {
		R17_HIG_PER_PROD_CAT = r17_HIG_PER_PROD_CAT;
	}
	public String getR17_NO_ACCS_TAG_NPA() {
		return R17_NO_ACCS_TAG_NPA;
	}
	public void setR17_NO_ACCS_TAG_NPA(String r17_NO_ACCS_TAG_NPA) {
		R17_NO_ACCS_TAG_NPA = r17_NO_ACCS_TAG_NPA;
	}
	public String getR17_NO_CHG_FEE_GRT5() {
		return R17_NO_CHG_FEE_GRT5;
	}
	public void setR17_NO_CHG_FEE_GRT5(String r17_NO_CHG_FEE_GRT5) {
		R17_NO_CHG_FEE_GRT5 = r17_NO_CHG_FEE_GRT5;
	}
	public String getR17_NO_CON_FLEX_INT() {
		return R17_NO_CON_FLEX_INT;
	}
	public void setR17_NO_CON_FLEX_INT(String r17_NO_CON_FLEX_INT) {
		R17_NO_CON_FLEX_INT = r17_NO_CON_FLEX_INT;
	}
	public String getR17_NO_CON_FIXED_INT() {
		return R17_NO_CON_FIXED_INT;
	}
	public void setR17_NO_CON_FIXED_INT(String r17_NO_CON_FIXED_INT) {
		R17_NO_CON_FIXED_INT = r17_NO_CON_FIXED_INT;
	}
	public String getR17_NO_LOAN_MAY_2011() {
		return R17_NO_LOAN_MAY_2011;
	}
	public void setR17_NO_LOAN_MAY_2011(String r17_NO_LOAN_MAY_2011) {
		R17_NO_LOAN_MAY_2011 = r17_NO_LOAN_MAY_2011;
	}
	public String getR17_VAL_LEGA_MAY_AED() {
		return R17_VAL_LEGA_MAY_AED;
	}
	public void setR17_VAL_LEGA_MAY_AED(String r17_VAL_LEGA_MAY_AED) {
		R17_VAL_LEGA_MAY_AED = r17_VAL_LEGA_MAY_AED;
	}
	public String getR17_AVG_DAY_NLL() {
		return R17_AVG_DAY_NLL;
	}
	public void setR17_AVG_DAY_NLL(String r17_AVG_DAY_NLL) {
		R17_AVG_DAY_NLL = r17_AVG_DAY_NLL;
	}
	public String getR17_PER_DOR_ACCS() {
		return R17_PER_DOR_ACCS;
	}
	public void setR17_PER_DOR_ACCS(String r17_PER_DOR_ACCS) {
		R17_PER_DOR_ACCS = r17_PER_DOR_ACCS;
	}
	public String getR17_INT_RET_PROF() {
		return R17_INT_RET_PROF;
	}
	public void setR17_INT_RET_PROF(String r17_INT_RET_PROF) {
		R17_INT_RET_PROF = r17_INT_RET_PROF;
	}
	public String getR17_FEE_COMM_PROF() {
		return R17_FEE_COMM_PROF;
	}
	public void setR17_FEE_COMM_PROF(String r17_FEE_COMM_PROF) {
		R17_FEE_COMM_PROF = r17_FEE_COMM_PROF;
	}
	public String getR17_TOT_UNCLM_90() {
		return R17_TOT_UNCLM_90;
	}
	public void setR17_TOT_UNCLM_90(String r17_TOT_UNCLM_90) {
		R17_TOT_UNCLM_90 = r17_TOT_UNCLM_90;
	}
	public String getR17_TOT_VAL_UNBAL() {
		return R17_TOT_VAL_UNBAL;
	}
	public void setR17_TOT_VAL_UNBAL(String r17_TOT_VAL_UNBAL) {
		R17_TOT_VAL_UNBAL = r17_TOT_VAL_UNBAL;
	}
	public String getR17_NO_INST_CONTRACT() {
		return R17_NO_INST_CONTRACT;
	}
	public void setR17_NO_INST_CONTRACT(String r17_NO_INST_CONTRACT) {
		R17_NO_INST_CONTRACT = r17_NO_INST_CONTRACT;
	}
	public String getR17_TOT_DORACC_NOTICE() {
		return R17_TOT_DORACC_NOTICE;
	}
	public void setR17_TOT_DORACC_NOTICE(String r17_TOT_DORACC_NOTICE) {
		R17_TOT_DORACC_NOTICE = r17_TOT_DORACC_NOTICE;
	}
	public String getR17_NO_CONS_LIAB_7DAY() {
		return R17_NO_CONS_LIAB_7DAY;
	}
	public void setR17_NO_CONS_LIAB_7DAY(String r17_NO_CONS_LIAB_7DAY) {
		R17_NO_CONS_LIAB_7DAY = r17_NO_CONS_LIAB_7DAY;
	}
	public String getR17_TOT_REQ_LIAB_NONLIA() {
		return R17_TOT_REQ_LIAB_NONLIA;
	}
	public void setR17_TOT_REQ_LIAB_NONLIA(String r17_TOT_REQ_LIAB_NONLIA) {
		R17_TOT_REQ_LIAB_NONLIA = r17_TOT_REQ_LIAB_NONLIA;
	}
	public String getR17_NO_RESTU_ONBO() {
		return R17_NO_RESTU_ONBO;
	}
	public void setR17_NO_RESTU_ONBO(String r17_NO_RESTU_ONBO) {
		R17_NO_RESTU_ONBO = r17_NO_RESTU_ONBO;
	}
	public String getR17_TOT_DELAY_TAT() {
		return R17_TOT_DELAY_TAT;
	}
	public void setR17_TOT_DELAY_TAT(String r17_TOT_DELAY_TAT) {
		R17_TOT_DELAY_TAT = r17_TOT_DELAY_TAT;
	}
	public String getR17_TOT_FND_TRAN() {
		return R17_TOT_FND_TRAN;
	}
	public void setR17_TOT_FND_TRAN(String r17_TOT_FND_TRAN) {
		R17_TOT_FND_TRAN = r17_TOT_FND_TRAN;
	}
	public String getR17_NO_FUND_RET24() {
		return R17_NO_FUND_RET24;
	}
	public void setR17_NO_FUND_RET24(String r17_NO_FUND_RET24) {
		R17_NO_FUND_RET24 = r17_NO_FUND_RET24;
	}
	public String getR17_NO_FAIL_TRAN() {
		return R17_NO_FAIL_TRAN;
	}
	public void setR17_NO_FAIL_TRAN(String r17_NO_FAIL_TRAN) {
		R17_NO_FAIL_TRAN = r17_NO_FAIL_TRAN;
	}
	public String getR17_CUS_FND_SVF_SPT() {
		return R17_CUS_FND_SVF_SPT;
	}
	public void setR17_CUS_FND_SVF_SPT(String r17_CUS_FND_SVF_SPT) {
		R17_CUS_FND_SVF_SPT = r17_CUS_FND_SVF_SPT;
	}
	public String getR17_CUS_FND_SVF_PRE() {
		return R17_CUS_FND_SVF_PRE;
	}
	public void setR17_CUS_FND_SVF_PRE(String r17_CUS_FND_SVF_PRE) {
		R17_CUS_FND_SVF_PRE = r17_CUS_FND_SVF_PRE;
	}
	public String getR17_TOT_CRDR_UND_SPT() {
		return R17_TOT_CRDR_UND_SPT;
	}
	public void setR17_TOT_CRDR_UND_SPT(String r17_TOT_CRDR_UND_SPT) {
		R17_TOT_CRDR_UND_SPT = r17_TOT_CRDR_UND_SPT;
	}
	public String getR17_TOT_CRD_ISU_SPT() {
		return R17_TOT_CRD_ISU_SPT;
	}
	public void setR17_TOT_CRD_ISU_SPT(String r17_TOT_CRD_ISU_SPT) {
		R17_TOT_CRD_ISU_SPT = r17_TOT_CRD_ISU_SPT;
	}
	public String getR17_NO_ACC_BLK_FIN() {
		return R17_NO_ACC_BLK_FIN;
	}
	public void setR17_NO_ACC_BLK_FIN(String r17_NO_ACC_BLK_FIN) {
		R17_NO_ACC_BLK_FIN = r17_NO_ACC_BLK_FIN;
	}
	public String getR17_NO_INQ_AVL_BAL() {
		return R17_NO_INQ_AVL_BAL;
	}
	public void setR17_NO_INQ_AVL_BAL(String r17_NO_INQ_AVL_BAL) {
		R17_NO_INQ_AVL_BAL = r17_NO_INQ_AVL_BAL;
	}
	public String getR17_TOT_PRE_EXP_SPT() {
		return R17_TOT_PRE_EXP_SPT;
	}
	public void setR17_TOT_PRE_EXP_SPT(String r17_TOT_PRE_EXP_SPT) {
		R17_TOT_PRE_EXP_SPT = r17_TOT_PRE_EXP_SPT;
	}
	public String getR17_TOT_PRE_POS_EXP() {
		return R17_TOT_PRE_POS_EXP;
	}
	public void setR17_TOT_PRE_POS_EXP(String r17_TOT_PRE_POS_EXP) {
		R17_TOT_PRE_POS_EXP = r17_TOT_PRE_POS_EXP;
	}
	public String getR17_TOT_PRE_CARD_SPD() {
		return R17_TOT_PRE_CARD_SPD;
	}
	public void setR17_TOT_PRE_CARD_SPD(String r17_TOT_PRE_CARD_SPD) {
		R17_TOT_PRE_CARD_SPD = r17_TOT_PRE_CARD_SPD;
	}
	public String getR17_TOT_ACCS_SPD() {
		return R17_TOT_ACCS_SPD;
	}
	public void setR17_TOT_ACCS_SPD(String r17_TOT_ACCS_SPD) {
		R17_TOT_ACCS_SPD = r17_TOT_ACCS_SPD;
	}
	public String getR17_NO_LANG_VOICE() {
		return R17_NO_LANG_VOICE;
	}
	public void setR17_NO_LANG_VOICE(String r17_NO_LANG_VOICE) {
		R17_NO_LANG_VOICE = r17_NO_LANG_VOICE;
	}
	public String getR17_AVG_NOD_LOWRSK() {
		return R17_AVG_NOD_LOWRSK;
	}
	public void setR17_AVG_NOD_LOWRSK(String r17_AVG_NOD_LOWRSK) {
		R17_AVG_NOD_LOWRSK = r17_AVG_NOD_LOWRSK;
	}
	public String getR17_NO_CUST_REISS_LIA() {
		return R17_NO_CUST_REISS_LIA;
	}
	public void setR17_NO_CUST_REISS_LIA(String r17_NO_CUST_REISS_LIA) {
		R17_NO_CUST_REISS_LIA = r17_NO_CUST_REISS_LIA;
	}
	public String getR17_NO_INS_CRRATE_CON() {
		return R17_NO_INS_CRRATE_CON;
	}
	public void setR17_NO_INS_CRRATE_CON(String r17_NO_INS_CRRATE_CON) {
		R17_NO_INS_CRRATE_CON = r17_NO_INS_CRRATE_CON;
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
	public String getR18_AVG_TME_LWRSK() {
		return R18_AVG_TME_LWRSK;
	}
	public void setR18_AVG_TME_LWRSK(String r18_AVG_TME_LWRSK) {
		R18_AVG_TME_LWRSK = r18_AVG_TME_LWRSK;
	}
	public String getR18_AVG_NO_LOAN() {
		return R18_AVG_NO_LOAN;
	}
	public void setR18_AVG_NO_LOAN(String r18_AVG_NO_LOAN) {
		R18_AVG_NO_LOAN = r18_AVG_NO_LOAN;
	}
	public String getR18_AVG_NO_LWRSK_SME() {
		return R18_AVG_NO_LWRSK_SME;
	}
	public void setR18_AVG_NO_LWRSK_SME(String r18_AVG_NO_LWRSK_SME) {
		R18_AVG_NO_LWRSK_SME = r18_AVG_NO_LWRSK_SME;
	}
	public String getR18_AVG_NO_DYS_SME() {
		return R18_AVG_NO_DYS_SME;
	}
	public void setR18_AVG_NO_DYS_SME(String r18_AVG_NO_DYS_SME) {
		R18_AVG_NO_DYS_SME = r18_AVG_NO_DYS_SME;
	}
	public String getR18_NO_REQ_CLO() {
		return R18_NO_REQ_CLO;
	}
	public void setR18_NO_REQ_CLO(String r18_NO_REQ_CLO) {
		R18_NO_REQ_CLO = r18_NO_REQ_CLO;
	}
	public String getR18_NO_PRD_VAR_SPC_TP() {
		return R18_NO_PRD_VAR_SPC_TP;
	}
	public void setR18_NO_PRD_VAR_SPC_TP(String r18_NO_PRD_VAR_SPC_TP) {
		R18_NO_PRD_VAR_SPC_TP = r18_NO_PRD_VAR_SPC_TP;
	}
	public String getR18_NO_REQ_RES_SPT() {
		return R18_NO_REQ_RES_SPT;
	}
	public void setR18_NO_REQ_RES_SPT(String r18_NO_REQ_RES_SPT) {
		R18_NO_REQ_RES_SPT = r18_NO_REQ_RES_SPT;
	}
	public String getR18_NO_REQ_PAYDEF() {
		return R18_NO_REQ_PAYDEF;
	}
	public void setR18_NO_REQ_PAYDEF(String r18_NO_REQ_PAYDEF) {
		R18_NO_REQ_PAYDEF = r18_NO_REQ_PAYDEF;
	}
	public String getR18_AVG_TME_REPAY() {
		return R18_AVG_TME_REPAY;
	}
	public void setR18_AVG_TME_REPAY(String r18_AVG_TME_REPAY) {
		R18_AVG_TME_REPAY = r18_AVG_TME_REPAY;
	}
	public String getR18_NO_INST_BAL() {
		return R18_NO_INST_BAL;
	}
	public void setR18_NO_INST_BAL(String r18_NO_INST_BAL) {
		R18_NO_INST_BAL = r18_NO_INST_BAL;
	}
	public String getR18_NET_FEE_AED() {
		return R18_NET_FEE_AED;
	}
	public void setR18_NET_FEE_AED(String r18_NET_FEE_AED) {
		R18_NET_FEE_AED = r18_NET_FEE_AED;
	}
	public String getR18_NET_PROF_AED() {
		return R18_NET_PROF_AED;
	}
	public void setR18_NET_PROF_AED(String r18_NET_PROF_AED) {
		R18_NET_PROF_AED = r18_NET_PROF_AED;
	}
	public String getR18_TOT_NO_ACC_SPD() {
		return R18_TOT_NO_ACC_SPD;
	}
	public void setR18_TOT_NO_ACC_SPD(String r18_TOT_NO_ACC_SPD) {
		R18_TOT_NO_ACC_SPD = r18_TOT_NO_ACC_SPD;
	}
	public String getR18_TOT_ACCS_DOR() {
		return R18_TOT_ACCS_DOR;
	}
	public void setR18_TOT_ACCS_DOR(String r18_TOT_ACCS_DOR) {
		R18_TOT_ACCS_DOR = r18_TOT_ACCS_DOR;
	}
	public String getR18_TOT_NEW_LOAN() {
		return R18_TOT_NEW_LOAN;
	}
	public void setR18_TOT_NEW_LOAN(String r18_TOT_NEW_LOAN) {
		R18_TOT_NEW_LOAN = r18_TOT_NEW_LOAN;
	}
	public String getR18_TOT_VAL_NEWACCS_AED() {
		return R18_TOT_VAL_NEWACCS_AED;
	}
	public void setR18_TOT_VAL_NEWACCS_AED(String r18_TOT_VAL_NEWACCS_AED) {
		R18_TOT_VAL_NEWACCS_AED = r18_TOT_VAL_NEWACCS_AED;
	}
	public String getR18_TOT_NO_LOAN_SPD() {
		return R18_TOT_NO_LOAN_SPD;
	}
	public void setR18_TOT_NO_LOAN_SPD(String r18_TOT_NO_LOAN_SPD) {
		R18_TOT_NO_LOAN_SPD = r18_TOT_NO_LOAN_SPD;
	}
	public String getR18_TOT_REQ_OTBNK() {
		return R18_TOT_REQ_OTBNK;
	}
	public void setR18_TOT_REQ_OTBNK(String r18_TOT_REQ_OTBNK) {
		R18_TOT_REQ_OTBNK = r18_TOT_REQ_OTBNK;
	}
	public String getR18_TOT_LOAN_OTBNK() {
		return R18_TOT_LOAN_OTBNK;
	}
	public void setR18_TOT_LOAN_OTBNK(String r18_TOT_LOAN_OTBNK) {
		R18_TOT_LOAN_OTBNK = r18_TOT_LOAN_OTBNK;
	}
	public String getR18_NO_CRACC_MIN() {
		return R18_NO_CRACC_MIN;
	}
	public void setR18_NO_CRACC_MIN(String r18_NO_CRACC_MIN) {
		R18_NO_CRACC_MIN = r18_NO_CRACC_MIN;
	}
	public String getR18_AVG_TME_CLSACC() {
		return R18_AVG_TME_CLSACC;
	}
	public void setR18_AVG_TME_CLSACC(String r18_AVG_TME_CLSACC) {
		R18_AVG_TME_CLSACC = r18_AVG_TME_CLSACC;
	}
	public String getR18_N0_CON_MORE1_LOAN() {
		return R18_N0_CON_MORE1_LOAN;
	}
	public void setR18_N0_CON_MORE1_LOAN(String r18_N0_CON_MORE1_LOAN) {
		R18_N0_CON_MORE1_LOAN = r18_N0_CON_MORE1_LOAN;
	}
	public String getR18_NO_INST_WITH90() {
		return R18_NO_INST_WITH90;
	}
	public void setR18_NO_INST_WITH90(String r18_NO_INST_WITH90) {
		R18_NO_INST_WITH90 = r18_NO_INST_WITH90;
	}
	public String getR18_TOT_GROSS_ASET() {
		return R18_TOT_GROSS_ASET;
	}
	public void setR18_TOT_GROSS_ASET(String r18_TOT_GROSS_ASET) {
		R18_TOT_GROSS_ASET = r18_TOT_GROSS_ASET;
	}
	public String getR18_RET_LIAB_AED() {
		return R18_RET_LIAB_AED;
	}
	public void setR18_RET_LIAB_AED(String r18_RET_LIAB_AED) {
		R18_RET_LIAB_AED = r18_RET_LIAB_AED;
	}
	public String getR18_HIG_PER_PROD_CAT() {
		return R18_HIG_PER_PROD_CAT;
	}
	public void setR18_HIG_PER_PROD_CAT(String r18_HIG_PER_PROD_CAT) {
		R18_HIG_PER_PROD_CAT = r18_HIG_PER_PROD_CAT;
	}
	public String getR18_NO_ACCS_TAG_NPA() {
		return R18_NO_ACCS_TAG_NPA;
	}
	public void setR18_NO_ACCS_TAG_NPA(String r18_NO_ACCS_TAG_NPA) {
		R18_NO_ACCS_TAG_NPA = r18_NO_ACCS_TAG_NPA;
	}
	public String getR18_NO_CHG_FEE_GRT5() {
		return R18_NO_CHG_FEE_GRT5;
	}
	public void setR18_NO_CHG_FEE_GRT5(String r18_NO_CHG_FEE_GRT5) {
		R18_NO_CHG_FEE_GRT5 = r18_NO_CHG_FEE_GRT5;
	}
	public String getR18_NO_CON_FLEX_INT() {
		return R18_NO_CON_FLEX_INT;
	}
	public void setR18_NO_CON_FLEX_INT(String r18_NO_CON_FLEX_INT) {
		R18_NO_CON_FLEX_INT = r18_NO_CON_FLEX_INT;
	}
	public String getR18_NO_CON_FIXED_INT() {
		return R18_NO_CON_FIXED_INT;
	}
	public void setR18_NO_CON_FIXED_INT(String r18_NO_CON_FIXED_INT) {
		R18_NO_CON_FIXED_INT = r18_NO_CON_FIXED_INT;
	}
	public String getR18_NO_LOAN_MAY_2011() {
		return R18_NO_LOAN_MAY_2011;
	}
	public void setR18_NO_LOAN_MAY_2011(String r18_NO_LOAN_MAY_2011) {
		R18_NO_LOAN_MAY_2011 = r18_NO_LOAN_MAY_2011;
	}
	public String getR18_VAL_LEGA_MAY_AED() {
		return R18_VAL_LEGA_MAY_AED;
	}
	public void setR18_VAL_LEGA_MAY_AED(String r18_VAL_LEGA_MAY_AED) {
		R18_VAL_LEGA_MAY_AED = r18_VAL_LEGA_MAY_AED;
	}
	public String getR18_AVG_DAY_NLL() {
		return R18_AVG_DAY_NLL;
	}
	public void setR18_AVG_DAY_NLL(String r18_AVG_DAY_NLL) {
		R18_AVG_DAY_NLL = r18_AVG_DAY_NLL;
	}
	public String getR18_PER_DOR_ACCS() {
		return R18_PER_DOR_ACCS;
	}
	public void setR18_PER_DOR_ACCS(String r18_PER_DOR_ACCS) {
		R18_PER_DOR_ACCS = r18_PER_DOR_ACCS;
	}
	public String getR18_INT_RET_PROF() {
		return R18_INT_RET_PROF;
	}
	public void setR18_INT_RET_PROF(String r18_INT_RET_PROF) {
		R18_INT_RET_PROF = r18_INT_RET_PROF;
	}
	public String getR18_FEE_COMM_PROF() {
		return R18_FEE_COMM_PROF;
	}
	public void setR18_FEE_COMM_PROF(String r18_FEE_COMM_PROF) {
		R18_FEE_COMM_PROF = r18_FEE_COMM_PROF;
	}
	public String getR18_TOT_UNCLM_90() {
		return R18_TOT_UNCLM_90;
	}
	public void setR18_TOT_UNCLM_90(String r18_TOT_UNCLM_90) {
		R18_TOT_UNCLM_90 = r18_TOT_UNCLM_90;
	}
	public String getR18_TOT_VAL_UNBAL() {
		return R18_TOT_VAL_UNBAL;
	}
	public void setR18_TOT_VAL_UNBAL(String r18_TOT_VAL_UNBAL) {
		R18_TOT_VAL_UNBAL = r18_TOT_VAL_UNBAL;
	}
	public String getR18_NO_INST_CONTRACT() {
		return R18_NO_INST_CONTRACT;
	}
	public void setR18_NO_INST_CONTRACT(String r18_NO_INST_CONTRACT) {
		R18_NO_INST_CONTRACT = r18_NO_INST_CONTRACT;
	}
	public String getR18_TOT_DORACC_NOTICE() {
		return R18_TOT_DORACC_NOTICE;
	}
	public void setR18_TOT_DORACC_NOTICE(String r18_TOT_DORACC_NOTICE) {
		R18_TOT_DORACC_NOTICE = r18_TOT_DORACC_NOTICE;
	}
	public String getR18_NO_CONS_LIAB_7DAY() {
		return R18_NO_CONS_LIAB_7DAY;
	}
	public void setR18_NO_CONS_LIAB_7DAY(String r18_NO_CONS_LIAB_7DAY) {
		R18_NO_CONS_LIAB_7DAY = r18_NO_CONS_LIAB_7DAY;
	}
	public String getR18_TOT_REQ_LIAB_NONLIA() {
		return R18_TOT_REQ_LIAB_NONLIA;
	}
	public void setR18_TOT_REQ_LIAB_NONLIA(String r18_TOT_REQ_LIAB_NONLIA) {
		R18_TOT_REQ_LIAB_NONLIA = r18_TOT_REQ_LIAB_NONLIA;
	}
	public String getR18_NO_RESTU_ONBO() {
		return R18_NO_RESTU_ONBO;
	}
	public void setR18_NO_RESTU_ONBO(String r18_NO_RESTU_ONBO) {
		R18_NO_RESTU_ONBO = r18_NO_RESTU_ONBO;
	}
	public String getR18_TOT_DELAY_TAT() {
		return R18_TOT_DELAY_TAT;
	}
	public void setR18_TOT_DELAY_TAT(String r18_TOT_DELAY_TAT) {
		R18_TOT_DELAY_TAT = r18_TOT_DELAY_TAT;
	}
	public String getR18_TOT_FND_TRAN() {
		return R18_TOT_FND_TRAN;
	}
	public void setR18_TOT_FND_TRAN(String r18_TOT_FND_TRAN) {
		R18_TOT_FND_TRAN = r18_TOT_FND_TRAN;
	}
	public String getR18_NO_FUND_RET24() {
		return R18_NO_FUND_RET24;
	}
	public void setR18_NO_FUND_RET24(String r18_NO_FUND_RET24) {
		R18_NO_FUND_RET24 = r18_NO_FUND_RET24;
	}
	public String getR18_NO_FAIL_TRAN() {
		return R18_NO_FAIL_TRAN;
	}
	public void setR18_NO_FAIL_TRAN(String r18_NO_FAIL_TRAN) {
		R18_NO_FAIL_TRAN = r18_NO_FAIL_TRAN;
	}
	public String getR18_CUS_FND_SVF_SPT() {
		return R18_CUS_FND_SVF_SPT;
	}
	public void setR18_CUS_FND_SVF_SPT(String r18_CUS_FND_SVF_SPT) {
		R18_CUS_FND_SVF_SPT = r18_CUS_FND_SVF_SPT;
	}
	public String getR18_CUS_FND_SVF_PRE() {
		return R18_CUS_FND_SVF_PRE;
	}
	public void setR18_CUS_FND_SVF_PRE(String r18_CUS_FND_SVF_PRE) {
		R18_CUS_FND_SVF_PRE = r18_CUS_FND_SVF_PRE;
	}
	public String getR18_TOT_CRDR_UND_SPT() {
		return R18_TOT_CRDR_UND_SPT;
	}
	public void setR18_TOT_CRDR_UND_SPT(String r18_TOT_CRDR_UND_SPT) {
		R18_TOT_CRDR_UND_SPT = r18_TOT_CRDR_UND_SPT;
	}
	public String getR18_TOT_CRD_ISU_SPT() {
		return R18_TOT_CRD_ISU_SPT;
	}
	public void setR18_TOT_CRD_ISU_SPT(String r18_TOT_CRD_ISU_SPT) {
		R18_TOT_CRD_ISU_SPT = r18_TOT_CRD_ISU_SPT;
	}
	public String getR18_NO_ACC_BLK_FIN() {
		return R18_NO_ACC_BLK_FIN;
	}
	public void setR18_NO_ACC_BLK_FIN(String r18_NO_ACC_BLK_FIN) {
		R18_NO_ACC_BLK_FIN = r18_NO_ACC_BLK_FIN;
	}
	public String getR18_NO_INQ_AVL_BAL() {
		return R18_NO_INQ_AVL_BAL;
	}
	public void setR18_NO_INQ_AVL_BAL(String r18_NO_INQ_AVL_BAL) {
		R18_NO_INQ_AVL_BAL = r18_NO_INQ_AVL_BAL;
	}
	public String getR18_TOT_PRE_EXP_SPT() {
		return R18_TOT_PRE_EXP_SPT;
	}
	public void setR18_TOT_PRE_EXP_SPT(String r18_TOT_PRE_EXP_SPT) {
		R18_TOT_PRE_EXP_SPT = r18_TOT_PRE_EXP_SPT;
	}
	public String getR18_TOT_PRE_POS_EXP() {
		return R18_TOT_PRE_POS_EXP;
	}
	public void setR18_TOT_PRE_POS_EXP(String r18_TOT_PRE_POS_EXP) {
		R18_TOT_PRE_POS_EXP = r18_TOT_PRE_POS_EXP;
	}
	public String getR18_TOT_PRE_CARD_SPD() {
		return R18_TOT_PRE_CARD_SPD;
	}
	public void setR18_TOT_PRE_CARD_SPD(String r18_TOT_PRE_CARD_SPD) {
		R18_TOT_PRE_CARD_SPD = r18_TOT_PRE_CARD_SPD;
	}
	public String getR18_TOT_ACCS_SPD() {
		return R18_TOT_ACCS_SPD;
	}
	public void setR18_TOT_ACCS_SPD(String r18_TOT_ACCS_SPD) {
		R18_TOT_ACCS_SPD = r18_TOT_ACCS_SPD;
	}
	public String getR18_NO_LANG_VOICE() {
		return R18_NO_LANG_VOICE;
	}
	public void setR18_NO_LANG_VOICE(String r18_NO_LANG_VOICE) {
		R18_NO_LANG_VOICE = r18_NO_LANG_VOICE;
	}
	public String getR18_AVG_NOD_LOWRSK() {
		return R18_AVG_NOD_LOWRSK;
	}
	public void setR18_AVG_NOD_LOWRSK(String r18_AVG_NOD_LOWRSK) {
		R18_AVG_NOD_LOWRSK = r18_AVG_NOD_LOWRSK;
	}
	public String getR18_NO_CUST_REISS_LIA() {
		return R18_NO_CUST_REISS_LIA;
	}
	public void setR18_NO_CUST_REISS_LIA(String r18_NO_CUST_REISS_LIA) {
		R18_NO_CUST_REISS_LIA = r18_NO_CUST_REISS_LIA;
	}
	public String getR18_NO_INS_CRRATE_CON() {
		return R18_NO_INS_CRRATE_CON;
	}
	public void setR18_NO_INS_CRRATE_CON(String r18_NO_INS_CRRATE_CON) {
		R18_NO_INS_CRRATE_CON = r18_NO_INS_CRRATE_CON;
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
	public String getR19_AVG_TME_LWRSK() {
		return R19_AVG_TME_LWRSK;
	}
	public void setR19_AVG_TME_LWRSK(String r19_AVG_TME_LWRSK) {
		R19_AVG_TME_LWRSK = r19_AVG_TME_LWRSK;
	}
	public String getR19_AVG_NO_LOAN() {
		return R19_AVG_NO_LOAN;
	}
	public void setR19_AVG_NO_LOAN(String r19_AVG_NO_LOAN) {
		R19_AVG_NO_LOAN = r19_AVG_NO_LOAN;
	}
	public String getR19_AVG_NO_LWRSK_SME() {
		return R19_AVG_NO_LWRSK_SME;
	}
	public void setR19_AVG_NO_LWRSK_SME(String r19_AVG_NO_LWRSK_SME) {
		R19_AVG_NO_LWRSK_SME = r19_AVG_NO_LWRSK_SME;
	}
	public String getR19_AVG_NO_DYS_SME() {
		return R19_AVG_NO_DYS_SME;
	}
	public void setR19_AVG_NO_DYS_SME(String r19_AVG_NO_DYS_SME) {
		R19_AVG_NO_DYS_SME = r19_AVG_NO_DYS_SME;
	}
	public String getR19_NO_REQ_CLO() {
		return R19_NO_REQ_CLO;
	}
	public void setR19_NO_REQ_CLO(String r19_NO_REQ_CLO) {
		R19_NO_REQ_CLO = r19_NO_REQ_CLO;
	}
	public String getR19_NO_PRD_VAR_SPC_TP() {
		return R19_NO_PRD_VAR_SPC_TP;
	}
	public void setR19_NO_PRD_VAR_SPC_TP(String r19_NO_PRD_VAR_SPC_TP) {
		R19_NO_PRD_VAR_SPC_TP = r19_NO_PRD_VAR_SPC_TP;
	}
	public String getR19_NO_REQ_RES_SPT() {
		return R19_NO_REQ_RES_SPT;
	}
	public void setR19_NO_REQ_RES_SPT(String r19_NO_REQ_RES_SPT) {
		R19_NO_REQ_RES_SPT = r19_NO_REQ_RES_SPT;
	}
	public String getR19_NO_REQ_PAYDEF() {
		return R19_NO_REQ_PAYDEF;
	}
	public void setR19_NO_REQ_PAYDEF(String r19_NO_REQ_PAYDEF) {
		R19_NO_REQ_PAYDEF = r19_NO_REQ_PAYDEF;
	}
	public String getR19_AVG_TME_REPAY() {
		return R19_AVG_TME_REPAY;
	}
	public void setR19_AVG_TME_REPAY(String r19_AVG_TME_REPAY) {
		R19_AVG_TME_REPAY = r19_AVG_TME_REPAY;
	}
	public String getR19_NO_INST_BAL() {
		return R19_NO_INST_BAL;
	}
	public void setR19_NO_INST_BAL(String r19_NO_INST_BAL) {
		R19_NO_INST_BAL = r19_NO_INST_BAL;
	}
	public String getR19_NET_FEE_AED() {
		return R19_NET_FEE_AED;
	}
	public void setR19_NET_FEE_AED(String r19_NET_FEE_AED) {
		R19_NET_FEE_AED = r19_NET_FEE_AED;
	}
	public String getR19_NET_PROF_AED() {
		return R19_NET_PROF_AED;
	}
	public void setR19_NET_PROF_AED(String r19_NET_PROF_AED) {
		R19_NET_PROF_AED = r19_NET_PROF_AED;
	}
	public String getR19_TOT_NO_ACC_SPD() {
		return R19_TOT_NO_ACC_SPD;
	}
	public void setR19_TOT_NO_ACC_SPD(String r19_TOT_NO_ACC_SPD) {
		R19_TOT_NO_ACC_SPD = r19_TOT_NO_ACC_SPD;
	}
	public String getR19_TOT_ACCS_DOR() {
		return R19_TOT_ACCS_DOR;
	}
	public void setR19_TOT_ACCS_DOR(String r19_TOT_ACCS_DOR) {
		R19_TOT_ACCS_DOR = r19_TOT_ACCS_DOR;
	}
	public String getR19_TOT_NEW_LOAN() {
		return R19_TOT_NEW_LOAN;
	}
	public void setR19_TOT_NEW_LOAN(String r19_TOT_NEW_LOAN) {
		R19_TOT_NEW_LOAN = r19_TOT_NEW_LOAN;
	}
	public String getR19_TOT_VAL_NEWACCS_AED() {
		return R19_TOT_VAL_NEWACCS_AED;
	}
	public void setR19_TOT_VAL_NEWACCS_AED(String r19_TOT_VAL_NEWACCS_AED) {
		R19_TOT_VAL_NEWACCS_AED = r19_TOT_VAL_NEWACCS_AED;
	}
	public String getR19_TOT_NO_LOAN_SPD() {
		return R19_TOT_NO_LOAN_SPD;
	}
	public void setR19_TOT_NO_LOAN_SPD(String r19_TOT_NO_LOAN_SPD) {
		R19_TOT_NO_LOAN_SPD = r19_TOT_NO_LOAN_SPD;
	}
	public String getR19_TOT_REQ_OTBNK() {
		return R19_TOT_REQ_OTBNK;
	}
	public void setR19_TOT_REQ_OTBNK(String r19_TOT_REQ_OTBNK) {
		R19_TOT_REQ_OTBNK = r19_TOT_REQ_OTBNK;
	}
	public String getR19_TOT_LOAN_OTBNK() {
		return R19_TOT_LOAN_OTBNK;
	}
	public void setR19_TOT_LOAN_OTBNK(String r19_TOT_LOAN_OTBNK) {
		R19_TOT_LOAN_OTBNK = r19_TOT_LOAN_OTBNK;
	}
	public String getR19_NO_CRACC_MIN() {
		return R19_NO_CRACC_MIN;
	}
	public void setR19_NO_CRACC_MIN(String r19_NO_CRACC_MIN) {
		R19_NO_CRACC_MIN = r19_NO_CRACC_MIN;
	}
	public String getR19_AVG_TME_CLSACC() {
		return R19_AVG_TME_CLSACC;
	}
	public void setR19_AVG_TME_CLSACC(String r19_AVG_TME_CLSACC) {
		R19_AVG_TME_CLSACC = r19_AVG_TME_CLSACC;
	}
	public String getR19_N0_CON_MORE1_LOAN() {
		return R19_N0_CON_MORE1_LOAN;
	}
	public void setR19_N0_CON_MORE1_LOAN(String r19_N0_CON_MORE1_LOAN) {
		R19_N0_CON_MORE1_LOAN = r19_N0_CON_MORE1_LOAN;
	}
	public String getR19_NO_INST_WITH90() {
		return R19_NO_INST_WITH90;
	}
	public void setR19_NO_INST_WITH90(String r19_NO_INST_WITH90) {
		R19_NO_INST_WITH90 = r19_NO_INST_WITH90;
	}
	public String getR19_TOT_GROSS_ASET() {
		return R19_TOT_GROSS_ASET;
	}
	public void setR19_TOT_GROSS_ASET(String r19_TOT_GROSS_ASET) {
		R19_TOT_GROSS_ASET = r19_TOT_GROSS_ASET;
	}
	public String getR19_RET_LIAB_AED() {
		return R19_RET_LIAB_AED;
	}
	public void setR19_RET_LIAB_AED(String r19_RET_LIAB_AED) {
		R19_RET_LIAB_AED = r19_RET_LIAB_AED;
	}
	public String getR19_HIG_PER_PROD_CAT() {
		return R19_HIG_PER_PROD_CAT;
	}
	public void setR19_HIG_PER_PROD_CAT(String r19_HIG_PER_PROD_CAT) {
		R19_HIG_PER_PROD_CAT = r19_HIG_PER_PROD_CAT;
	}
	public String getR19_NO_ACCS_TAG_NPA() {
		return R19_NO_ACCS_TAG_NPA;
	}
	public void setR19_NO_ACCS_TAG_NPA(String r19_NO_ACCS_TAG_NPA) {
		R19_NO_ACCS_TAG_NPA = r19_NO_ACCS_TAG_NPA;
	}
	public String getR19_NO_CHG_FEE_GRT5() {
		return R19_NO_CHG_FEE_GRT5;
	}
	public void setR19_NO_CHG_FEE_GRT5(String r19_NO_CHG_FEE_GRT5) {
		R19_NO_CHG_FEE_GRT5 = r19_NO_CHG_FEE_GRT5;
	}
	public String getR19_NO_CON_FLEX_INT() {
		return R19_NO_CON_FLEX_INT;
	}
	public void setR19_NO_CON_FLEX_INT(String r19_NO_CON_FLEX_INT) {
		R19_NO_CON_FLEX_INT = r19_NO_CON_FLEX_INT;
	}
	public String getR19_NO_CON_FIXED_INT() {
		return R19_NO_CON_FIXED_INT;
	}
	public void setR19_NO_CON_FIXED_INT(String r19_NO_CON_FIXED_INT) {
		R19_NO_CON_FIXED_INT = r19_NO_CON_FIXED_INT;
	}
	public String getR19_NO_LOAN_MAY_2011() {
		return R19_NO_LOAN_MAY_2011;
	}
	public void setR19_NO_LOAN_MAY_2011(String r19_NO_LOAN_MAY_2011) {
		R19_NO_LOAN_MAY_2011 = r19_NO_LOAN_MAY_2011;
	}
	public String getR19_VAL_LEGA_MAY_AED() {
		return R19_VAL_LEGA_MAY_AED;
	}
	public void setR19_VAL_LEGA_MAY_AED(String r19_VAL_LEGA_MAY_AED) {
		R19_VAL_LEGA_MAY_AED = r19_VAL_LEGA_MAY_AED;
	}
	public String getR19_AVG_DAY_NLL() {
		return R19_AVG_DAY_NLL;
	}
	public void setR19_AVG_DAY_NLL(String r19_AVG_DAY_NLL) {
		R19_AVG_DAY_NLL = r19_AVG_DAY_NLL;
	}
	public String getR19_PER_DOR_ACCS() {
		return R19_PER_DOR_ACCS;
	}
	public void setR19_PER_DOR_ACCS(String r19_PER_DOR_ACCS) {
		R19_PER_DOR_ACCS = r19_PER_DOR_ACCS;
	}
	public String getR19_INT_RET_PROF() {
		return R19_INT_RET_PROF;
	}
	public void setR19_INT_RET_PROF(String r19_INT_RET_PROF) {
		R19_INT_RET_PROF = r19_INT_RET_PROF;
	}
	public String getR19_FEE_COMM_PROF() {
		return R19_FEE_COMM_PROF;
	}
	public void setR19_FEE_COMM_PROF(String r19_FEE_COMM_PROF) {
		R19_FEE_COMM_PROF = r19_FEE_COMM_PROF;
	}
	public String getR19_TOT_UNCLM_90() {
		return R19_TOT_UNCLM_90;
	}
	public void setR19_TOT_UNCLM_90(String r19_TOT_UNCLM_90) {
		R19_TOT_UNCLM_90 = r19_TOT_UNCLM_90;
	}
	public String getR19_TOT_VAL_UNBAL() {
		return R19_TOT_VAL_UNBAL;
	}
	public void setR19_TOT_VAL_UNBAL(String r19_TOT_VAL_UNBAL) {
		R19_TOT_VAL_UNBAL = r19_TOT_VAL_UNBAL;
	}
	public String getR19_NO_INST_CONTRACT() {
		return R19_NO_INST_CONTRACT;
	}
	public void setR19_NO_INST_CONTRACT(String r19_NO_INST_CONTRACT) {
		R19_NO_INST_CONTRACT = r19_NO_INST_CONTRACT;
	}
	public String getR19_TOT_DORACC_NOTICE() {
		return R19_TOT_DORACC_NOTICE;
	}
	public void setR19_TOT_DORACC_NOTICE(String r19_TOT_DORACC_NOTICE) {
		R19_TOT_DORACC_NOTICE = r19_TOT_DORACC_NOTICE;
	}
	public String getR19_NO_CONS_LIAB_7DAY() {
		return R19_NO_CONS_LIAB_7DAY;
	}
	public void setR19_NO_CONS_LIAB_7DAY(String r19_NO_CONS_LIAB_7DAY) {
		R19_NO_CONS_LIAB_7DAY = r19_NO_CONS_LIAB_7DAY;
	}
	public String getR19_TOT_REQ_LIAB_NONLIA() {
		return R19_TOT_REQ_LIAB_NONLIA;
	}
	public void setR19_TOT_REQ_LIAB_NONLIA(String r19_TOT_REQ_LIAB_NONLIA) {
		R19_TOT_REQ_LIAB_NONLIA = r19_TOT_REQ_LIAB_NONLIA;
	}
	public String getR19_NO_RESTU_ONBO() {
		return R19_NO_RESTU_ONBO;
	}
	public void setR19_NO_RESTU_ONBO(String r19_NO_RESTU_ONBO) {
		R19_NO_RESTU_ONBO = r19_NO_RESTU_ONBO;
	}
	public String getR19_TOT_DELAY_TAT() {
		return R19_TOT_DELAY_TAT;
	}
	public void setR19_TOT_DELAY_TAT(String r19_TOT_DELAY_TAT) {
		R19_TOT_DELAY_TAT = r19_TOT_DELAY_TAT;
	}
	public String getR19_TOT_FND_TRAN() {
		return R19_TOT_FND_TRAN;
	}
	public void setR19_TOT_FND_TRAN(String r19_TOT_FND_TRAN) {
		R19_TOT_FND_TRAN = r19_TOT_FND_TRAN;
	}
	public String getR19_NO_FUND_RET24() {
		return R19_NO_FUND_RET24;
	}
	public void setR19_NO_FUND_RET24(String r19_NO_FUND_RET24) {
		R19_NO_FUND_RET24 = r19_NO_FUND_RET24;
	}
	public String getR19_NO_FAIL_TRAN() {
		return R19_NO_FAIL_TRAN;
	}
	public void setR19_NO_FAIL_TRAN(String r19_NO_FAIL_TRAN) {
		R19_NO_FAIL_TRAN = r19_NO_FAIL_TRAN;
	}
	public String getR19_CUS_FND_SVF_SPT() {
		return R19_CUS_FND_SVF_SPT;
	}
	public void setR19_CUS_FND_SVF_SPT(String r19_CUS_FND_SVF_SPT) {
		R19_CUS_FND_SVF_SPT = r19_CUS_FND_SVF_SPT;
	}
	public String getR19_CUS_FND_SVF_PRE() {
		return R19_CUS_FND_SVF_PRE;
	}
	public void setR19_CUS_FND_SVF_PRE(String r19_CUS_FND_SVF_PRE) {
		R19_CUS_FND_SVF_PRE = r19_CUS_FND_SVF_PRE;
	}
	public String getR19_TOT_CRDR_UND_SPT() {
		return R19_TOT_CRDR_UND_SPT;
	}
	public void setR19_TOT_CRDR_UND_SPT(String r19_TOT_CRDR_UND_SPT) {
		R19_TOT_CRDR_UND_SPT = r19_TOT_CRDR_UND_SPT;
	}
	public String getR19_TOT_CRD_ISU_SPT() {
		return R19_TOT_CRD_ISU_SPT;
	}
	public void setR19_TOT_CRD_ISU_SPT(String r19_TOT_CRD_ISU_SPT) {
		R19_TOT_CRD_ISU_SPT = r19_TOT_CRD_ISU_SPT;
	}
	public String getR19_NO_ACC_BLK_FIN() {
		return R19_NO_ACC_BLK_FIN;
	}
	public void setR19_NO_ACC_BLK_FIN(String r19_NO_ACC_BLK_FIN) {
		R19_NO_ACC_BLK_FIN = r19_NO_ACC_BLK_FIN;
	}
	public String getR19_NO_INQ_AVL_BAL() {
		return R19_NO_INQ_AVL_BAL;
	}
	public void setR19_NO_INQ_AVL_BAL(String r19_NO_INQ_AVL_BAL) {
		R19_NO_INQ_AVL_BAL = r19_NO_INQ_AVL_BAL;
	}
	public String getR19_TOT_PRE_EXP_SPT() {
		return R19_TOT_PRE_EXP_SPT;
	}
	public void setR19_TOT_PRE_EXP_SPT(String r19_TOT_PRE_EXP_SPT) {
		R19_TOT_PRE_EXP_SPT = r19_TOT_PRE_EXP_SPT;
	}
	public String getR19_TOT_PRE_POS_EXP() {
		return R19_TOT_PRE_POS_EXP;
	}
	public void setR19_TOT_PRE_POS_EXP(String r19_TOT_PRE_POS_EXP) {
		R19_TOT_PRE_POS_EXP = r19_TOT_PRE_POS_EXP;
	}
	public String getR19_TOT_PRE_CARD_SPD() {
		return R19_TOT_PRE_CARD_SPD;
	}
	public void setR19_TOT_PRE_CARD_SPD(String r19_TOT_PRE_CARD_SPD) {
		R19_TOT_PRE_CARD_SPD = r19_TOT_PRE_CARD_SPD;
	}
	public String getR19_TOT_ACCS_SPD() {
		return R19_TOT_ACCS_SPD;
	}
	public void setR19_TOT_ACCS_SPD(String r19_TOT_ACCS_SPD) {
		R19_TOT_ACCS_SPD = r19_TOT_ACCS_SPD;
	}
	public String getR19_NO_LANG_VOICE() {
		return R19_NO_LANG_VOICE;
	}
	public void setR19_NO_LANG_VOICE(String r19_NO_LANG_VOICE) {
		R19_NO_LANG_VOICE = r19_NO_LANG_VOICE;
	}
	public String getR19_AVG_NOD_LOWRSK() {
		return R19_AVG_NOD_LOWRSK;
	}
	public void setR19_AVG_NOD_LOWRSK(String r19_AVG_NOD_LOWRSK) {
		R19_AVG_NOD_LOWRSK = r19_AVG_NOD_LOWRSK;
	}
	public String getR19_NO_CUST_REISS_LIA() {
		return R19_NO_CUST_REISS_LIA;
	}
	public void setR19_NO_CUST_REISS_LIA(String r19_NO_CUST_REISS_LIA) {
		R19_NO_CUST_REISS_LIA = r19_NO_CUST_REISS_LIA;
	}
	public String getR19_NO_INS_CRRATE_CON() {
		return R19_NO_INS_CRRATE_CON;
	}
	public void setR19_NO_INS_CRRATE_CON(String r19_NO_INS_CRRATE_CON) {
		R19_NO_INS_CRRATE_CON = r19_NO_INS_CRRATE_CON;
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
	public String getR20_AVG_TME_LWRSK() {
		return R20_AVG_TME_LWRSK;
	}
	public void setR20_AVG_TME_LWRSK(String r20_AVG_TME_LWRSK) {
		R20_AVG_TME_LWRSK = r20_AVG_TME_LWRSK;
	}
	public String getR20_AVG_NO_LOAN() {
		return R20_AVG_NO_LOAN;
	}
	public void setR20_AVG_NO_LOAN(String r20_AVG_NO_LOAN) {
		R20_AVG_NO_LOAN = r20_AVG_NO_LOAN;
	}
	public String getR20_AVG_NO_LWRSK_SME() {
		return R20_AVG_NO_LWRSK_SME;
	}
	public void setR20_AVG_NO_LWRSK_SME(String r20_AVG_NO_LWRSK_SME) {
		R20_AVG_NO_LWRSK_SME = r20_AVG_NO_LWRSK_SME;
	}
	public String getR20_AVG_NO_DYS_SME() {
		return R20_AVG_NO_DYS_SME;
	}
	public void setR20_AVG_NO_DYS_SME(String r20_AVG_NO_DYS_SME) {
		R20_AVG_NO_DYS_SME = r20_AVG_NO_DYS_SME;
	}
	public String getR20_NO_REQ_CLO() {
		return R20_NO_REQ_CLO;
	}
	public void setR20_NO_REQ_CLO(String r20_NO_REQ_CLO) {
		R20_NO_REQ_CLO = r20_NO_REQ_CLO;
	}
	public String getR20_NO_PRD_VAR_SPC_TP() {
		return R20_NO_PRD_VAR_SPC_TP;
	}
	public void setR20_NO_PRD_VAR_SPC_TP(String r20_NO_PRD_VAR_SPC_TP) {
		R20_NO_PRD_VAR_SPC_TP = r20_NO_PRD_VAR_SPC_TP;
	}
	public String getR20_NO_REQ_RES_SPT() {
		return R20_NO_REQ_RES_SPT;
	}
	public void setR20_NO_REQ_RES_SPT(String r20_NO_REQ_RES_SPT) {
		R20_NO_REQ_RES_SPT = r20_NO_REQ_RES_SPT;
	}
	public String getR20_NO_REQ_PAYDEF() {
		return R20_NO_REQ_PAYDEF;
	}
	public void setR20_NO_REQ_PAYDEF(String r20_NO_REQ_PAYDEF) {
		R20_NO_REQ_PAYDEF = r20_NO_REQ_PAYDEF;
	}
	public String getR20_AVG_TME_REPAY() {
		return R20_AVG_TME_REPAY;
	}
	public void setR20_AVG_TME_REPAY(String r20_AVG_TME_REPAY) {
		R20_AVG_TME_REPAY = r20_AVG_TME_REPAY;
	}
	public String getR20_NO_INST_BAL() {
		return R20_NO_INST_BAL;
	}
	public void setR20_NO_INST_BAL(String r20_NO_INST_BAL) {
		R20_NO_INST_BAL = r20_NO_INST_BAL;
	}
	public String getR20_NET_FEE_AED() {
		return R20_NET_FEE_AED;
	}
	public void setR20_NET_FEE_AED(String r20_NET_FEE_AED) {
		R20_NET_FEE_AED = r20_NET_FEE_AED;
	}
	public String getR20_NET_PROF_AED() {
		return R20_NET_PROF_AED;
	}
	public void setR20_NET_PROF_AED(String r20_NET_PROF_AED) {
		R20_NET_PROF_AED = r20_NET_PROF_AED;
	}
	public String getR20_TOT_NO_ACC_SPD() {
		return R20_TOT_NO_ACC_SPD;
	}
	public void setR20_TOT_NO_ACC_SPD(String r20_TOT_NO_ACC_SPD) {
		R20_TOT_NO_ACC_SPD = r20_TOT_NO_ACC_SPD;
	}
	public String getR20_TOT_ACCS_DOR() {
		return R20_TOT_ACCS_DOR;
	}
	public void setR20_TOT_ACCS_DOR(String r20_TOT_ACCS_DOR) {
		R20_TOT_ACCS_DOR = r20_TOT_ACCS_DOR;
	}
	public String getR20_TOT_NEW_LOAN() {
		return R20_TOT_NEW_LOAN;
	}
	public void setR20_TOT_NEW_LOAN(String r20_TOT_NEW_LOAN) {
		R20_TOT_NEW_LOAN = r20_TOT_NEW_LOAN;
	}
	public String getR20_TOT_VAL_NEWACCS_AED() {
		return R20_TOT_VAL_NEWACCS_AED;
	}
	public void setR20_TOT_VAL_NEWACCS_AED(String r20_TOT_VAL_NEWACCS_AED) {
		R20_TOT_VAL_NEWACCS_AED = r20_TOT_VAL_NEWACCS_AED;
	}
	public String getR20_TOT_NO_LOAN_SPD() {
		return R20_TOT_NO_LOAN_SPD;
	}
	public void setR20_TOT_NO_LOAN_SPD(String r20_TOT_NO_LOAN_SPD) {
		R20_TOT_NO_LOAN_SPD = r20_TOT_NO_LOAN_SPD;
	}
	public String getR20_TOT_REQ_OTBNK() {
		return R20_TOT_REQ_OTBNK;
	}
	public void setR20_TOT_REQ_OTBNK(String r20_TOT_REQ_OTBNK) {
		R20_TOT_REQ_OTBNK = r20_TOT_REQ_OTBNK;
	}
	public String getR20_TOT_LOAN_OTBNK() {
		return R20_TOT_LOAN_OTBNK;
	}
	public void setR20_TOT_LOAN_OTBNK(String r20_TOT_LOAN_OTBNK) {
		R20_TOT_LOAN_OTBNK = r20_TOT_LOAN_OTBNK;
	}
	public String getR20_NO_CRACC_MIN() {
		return R20_NO_CRACC_MIN;
	}
	public void setR20_NO_CRACC_MIN(String r20_NO_CRACC_MIN) {
		R20_NO_CRACC_MIN = r20_NO_CRACC_MIN;
	}
	public String getR20_AVG_TME_CLSACC() {
		return R20_AVG_TME_CLSACC;
	}
	public void setR20_AVG_TME_CLSACC(String r20_AVG_TME_CLSACC) {
		R20_AVG_TME_CLSACC = r20_AVG_TME_CLSACC;
	}
	public String getR20_N0_CON_MORE1_LOAN() {
		return R20_N0_CON_MORE1_LOAN;
	}
	public void setR20_N0_CON_MORE1_LOAN(String r20_N0_CON_MORE1_LOAN) {
		R20_N0_CON_MORE1_LOAN = r20_N0_CON_MORE1_LOAN;
	}
	public String getR20_NO_INST_WITH90() {
		return R20_NO_INST_WITH90;
	}
	public void setR20_NO_INST_WITH90(String r20_NO_INST_WITH90) {
		R20_NO_INST_WITH90 = r20_NO_INST_WITH90;
	}
	public String getR20_TOT_GROSS_ASET() {
		return R20_TOT_GROSS_ASET;
	}
	public void setR20_TOT_GROSS_ASET(String r20_TOT_GROSS_ASET) {
		R20_TOT_GROSS_ASET = r20_TOT_GROSS_ASET;
	}
	public String getR20_RET_LIAB_AED() {
		return R20_RET_LIAB_AED;
	}
	public void setR20_RET_LIAB_AED(String r20_RET_LIAB_AED) {
		R20_RET_LIAB_AED = r20_RET_LIAB_AED;
	}
	public String getR20_HIG_PER_PROD_CAT() {
		return R20_HIG_PER_PROD_CAT;
	}
	public void setR20_HIG_PER_PROD_CAT(String r20_HIG_PER_PROD_CAT) {
		R20_HIG_PER_PROD_CAT = r20_HIG_PER_PROD_CAT;
	}
	public String getR20_NO_ACCS_TAG_NPA() {
		return R20_NO_ACCS_TAG_NPA;
	}
	public void setR20_NO_ACCS_TAG_NPA(String r20_NO_ACCS_TAG_NPA) {
		R20_NO_ACCS_TAG_NPA = r20_NO_ACCS_TAG_NPA;
	}
	public String getR20_NO_CHG_FEE_GRT5() {
		return R20_NO_CHG_FEE_GRT5;
	}
	public void setR20_NO_CHG_FEE_GRT5(String r20_NO_CHG_FEE_GRT5) {
		R20_NO_CHG_FEE_GRT5 = r20_NO_CHG_FEE_GRT5;
	}
	public String getR20_NO_CON_FLEX_INT() {
		return R20_NO_CON_FLEX_INT;
	}
	public void setR20_NO_CON_FLEX_INT(String r20_NO_CON_FLEX_INT) {
		R20_NO_CON_FLEX_INT = r20_NO_CON_FLEX_INT;
	}
	public String getR20_NO_CON_FIXED_INT() {
		return R20_NO_CON_FIXED_INT;
	}
	public void setR20_NO_CON_FIXED_INT(String r20_NO_CON_FIXED_INT) {
		R20_NO_CON_FIXED_INT = r20_NO_CON_FIXED_INT;
	}
	public String getR20_NO_LOAN_MAY_2011() {
		return R20_NO_LOAN_MAY_2011;
	}
	public void setR20_NO_LOAN_MAY_2011(String r20_NO_LOAN_MAY_2011) {
		R20_NO_LOAN_MAY_2011 = r20_NO_LOAN_MAY_2011;
	}
	public String getR20_VAL_LEGA_MAY_AED() {
		return R20_VAL_LEGA_MAY_AED;
	}
	public void setR20_VAL_LEGA_MAY_AED(String r20_VAL_LEGA_MAY_AED) {
		R20_VAL_LEGA_MAY_AED = r20_VAL_LEGA_MAY_AED;
	}
	public String getR20_AVG_DAY_NLL() {
		return R20_AVG_DAY_NLL;
	}
	public void setR20_AVG_DAY_NLL(String r20_AVG_DAY_NLL) {
		R20_AVG_DAY_NLL = r20_AVG_DAY_NLL;
	}
	public String getR20_PER_DOR_ACCS() {
		return R20_PER_DOR_ACCS;
	}
	public void setR20_PER_DOR_ACCS(String r20_PER_DOR_ACCS) {
		R20_PER_DOR_ACCS = r20_PER_DOR_ACCS;
	}
	public String getR20_INT_RET_PROF() {
		return R20_INT_RET_PROF;
	}
	public void setR20_INT_RET_PROF(String r20_INT_RET_PROF) {
		R20_INT_RET_PROF = r20_INT_RET_PROF;
	}
	public String getR20_FEE_COMM_PROF() {
		return R20_FEE_COMM_PROF;
	}
	public void setR20_FEE_COMM_PROF(String r20_FEE_COMM_PROF) {
		R20_FEE_COMM_PROF = r20_FEE_COMM_PROF;
	}
	public String getR20_TOT_UNCLM_90() {
		return R20_TOT_UNCLM_90;
	}
	public void setR20_TOT_UNCLM_90(String r20_TOT_UNCLM_90) {
		R20_TOT_UNCLM_90 = r20_TOT_UNCLM_90;
	}
	public String getR20_TOT_VAL_UNBAL() {
		return R20_TOT_VAL_UNBAL;
	}
	public void setR20_TOT_VAL_UNBAL(String r20_TOT_VAL_UNBAL) {
		R20_TOT_VAL_UNBAL = r20_TOT_VAL_UNBAL;
	}
	public String getR20_NO_INST_CONTRACT() {
		return R20_NO_INST_CONTRACT;
	}
	public void setR20_NO_INST_CONTRACT(String r20_NO_INST_CONTRACT) {
		R20_NO_INST_CONTRACT = r20_NO_INST_CONTRACT;
	}
	public String getR20_TOT_DORACC_NOTICE() {
		return R20_TOT_DORACC_NOTICE;
	}
	public void setR20_TOT_DORACC_NOTICE(String r20_TOT_DORACC_NOTICE) {
		R20_TOT_DORACC_NOTICE = r20_TOT_DORACC_NOTICE;
	}
	public String getR20_NO_CONS_LIAB_7DAY() {
		return R20_NO_CONS_LIAB_7DAY;
	}
	public void setR20_NO_CONS_LIAB_7DAY(String r20_NO_CONS_LIAB_7DAY) {
		R20_NO_CONS_LIAB_7DAY = r20_NO_CONS_LIAB_7DAY;
	}
	public String getR20_TOT_REQ_LIAB_NONLIA() {
		return R20_TOT_REQ_LIAB_NONLIA;
	}
	public void setR20_TOT_REQ_LIAB_NONLIA(String r20_TOT_REQ_LIAB_NONLIA) {
		R20_TOT_REQ_LIAB_NONLIA = r20_TOT_REQ_LIAB_NONLIA;
	}
	public String getR20_NO_RESTU_ONBO() {
		return R20_NO_RESTU_ONBO;
	}
	public void setR20_NO_RESTU_ONBO(String r20_NO_RESTU_ONBO) {
		R20_NO_RESTU_ONBO = r20_NO_RESTU_ONBO;
	}
	public String getR20_TOT_DELAY_TAT() {
		return R20_TOT_DELAY_TAT;
	}
	public void setR20_TOT_DELAY_TAT(String r20_TOT_DELAY_TAT) {
		R20_TOT_DELAY_TAT = r20_TOT_DELAY_TAT;
	}
	public String getR20_TOT_FND_TRAN() {
		return R20_TOT_FND_TRAN;
	}
	public void setR20_TOT_FND_TRAN(String r20_TOT_FND_TRAN) {
		R20_TOT_FND_TRAN = r20_TOT_FND_TRAN;
	}
	public String getR20_NO_FUND_RET24() {
		return R20_NO_FUND_RET24;
	}
	public void setR20_NO_FUND_RET24(String r20_NO_FUND_RET24) {
		R20_NO_FUND_RET24 = r20_NO_FUND_RET24;
	}
	public String getR20_NO_FAIL_TRAN() {
		return R20_NO_FAIL_TRAN;
	}
	public void setR20_NO_FAIL_TRAN(String r20_NO_FAIL_TRAN) {
		R20_NO_FAIL_TRAN = r20_NO_FAIL_TRAN;
	}
	public String getR20_CUS_FND_SVF_SPT() {
		return R20_CUS_FND_SVF_SPT;
	}
	public void setR20_CUS_FND_SVF_SPT(String r20_CUS_FND_SVF_SPT) {
		R20_CUS_FND_SVF_SPT = r20_CUS_FND_SVF_SPT;
	}
	public String getR20_CUS_FND_SVF_PRE() {
		return R20_CUS_FND_SVF_PRE;
	}
	public void setR20_CUS_FND_SVF_PRE(String r20_CUS_FND_SVF_PRE) {
		R20_CUS_FND_SVF_PRE = r20_CUS_FND_SVF_PRE;
	}
	public String getR20_TOT_CRDR_UND_SPT() {
		return R20_TOT_CRDR_UND_SPT;
	}
	public void setR20_TOT_CRDR_UND_SPT(String r20_TOT_CRDR_UND_SPT) {
		R20_TOT_CRDR_UND_SPT = r20_TOT_CRDR_UND_SPT;
	}
	public String getR20_TOT_CRD_ISU_SPT() {
		return R20_TOT_CRD_ISU_SPT;
	}
	public void setR20_TOT_CRD_ISU_SPT(String r20_TOT_CRD_ISU_SPT) {
		R20_TOT_CRD_ISU_SPT = r20_TOT_CRD_ISU_SPT;
	}
	public String getR20_NO_ACC_BLK_FIN() {
		return R20_NO_ACC_BLK_FIN;
	}
	public void setR20_NO_ACC_BLK_FIN(String r20_NO_ACC_BLK_FIN) {
		R20_NO_ACC_BLK_FIN = r20_NO_ACC_BLK_FIN;
	}
	public String getR20_NO_INQ_AVL_BAL() {
		return R20_NO_INQ_AVL_BAL;
	}
	public void setR20_NO_INQ_AVL_BAL(String r20_NO_INQ_AVL_BAL) {
		R20_NO_INQ_AVL_BAL = r20_NO_INQ_AVL_BAL;
	}
	public String getR20_TOT_PRE_EXP_SPT() {
		return R20_TOT_PRE_EXP_SPT;
	}
	public void setR20_TOT_PRE_EXP_SPT(String r20_TOT_PRE_EXP_SPT) {
		R20_TOT_PRE_EXP_SPT = r20_TOT_PRE_EXP_SPT;
	}
	public String getR20_TOT_PRE_POS_EXP() {
		return R20_TOT_PRE_POS_EXP;
	}
	public void setR20_TOT_PRE_POS_EXP(String r20_TOT_PRE_POS_EXP) {
		R20_TOT_PRE_POS_EXP = r20_TOT_PRE_POS_EXP;
	}
	public String getR20_TOT_PRE_CARD_SPD() {
		return R20_TOT_PRE_CARD_SPD;
	}
	public void setR20_TOT_PRE_CARD_SPD(String r20_TOT_PRE_CARD_SPD) {
		R20_TOT_PRE_CARD_SPD = r20_TOT_PRE_CARD_SPD;
	}
	public String getR20_TOT_ACCS_SPD() {
		return R20_TOT_ACCS_SPD;
	}
	public void setR20_TOT_ACCS_SPD(String r20_TOT_ACCS_SPD) {
		R20_TOT_ACCS_SPD = r20_TOT_ACCS_SPD;
	}
	public String getR20_NO_LANG_VOICE() {
		return R20_NO_LANG_VOICE;
	}
	public void setR20_NO_LANG_VOICE(String r20_NO_LANG_VOICE) {
		R20_NO_LANG_VOICE = r20_NO_LANG_VOICE;
	}
	public String getR20_AVG_NOD_LOWRSK() {
		return R20_AVG_NOD_LOWRSK;
	}
	public void setR20_AVG_NOD_LOWRSK(String r20_AVG_NOD_LOWRSK) {
		R20_AVG_NOD_LOWRSK = r20_AVG_NOD_LOWRSK;
	}
	public String getR20_NO_CUST_REISS_LIA() {
		return R20_NO_CUST_REISS_LIA;
	}
	public void setR20_NO_CUST_REISS_LIA(String r20_NO_CUST_REISS_LIA) {
		R20_NO_CUST_REISS_LIA = r20_NO_CUST_REISS_LIA;
	}
	public String getR20_NO_INS_CRRATE_CON() {
		return R20_NO_INS_CRRATE_CON;
	}
	public void setR20_NO_INS_CRRATE_CON(String r20_NO_INS_CRRATE_CON) {
		R20_NO_INS_CRRATE_CON = r20_NO_INS_CRRATE_CON;
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
	public String getR21_AVG_TME_LWRSK() {
		return R21_AVG_TME_LWRSK;
	}
	public void setR21_AVG_TME_LWRSK(String r21_AVG_TME_LWRSK) {
		R21_AVG_TME_LWRSK = r21_AVG_TME_LWRSK;
	}
	public String getR21_AVG_NO_LOAN() {
		return R21_AVG_NO_LOAN;
	}
	public void setR21_AVG_NO_LOAN(String r21_AVG_NO_LOAN) {
		R21_AVG_NO_LOAN = r21_AVG_NO_LOAN;
	}
	public String getR21_AVG_NO_LWRSK_SME() {
		return R21_AVG_NO_LWRSK_SME;
	}
	public void setR21_AVG_NO_LWRSK_SME(String r21_AVG_NO_LWRSK_SME) {
		R21_AVG_NO_LWRSK_SME = r21_AVG_NO_LWRSK_SME;
	}
	public String getR21_AVG_NO_DYS_SME() {
		return R21_AVG_NO_DYS_SME;
	}
	public void setR21_AVG_NO_DYS_SME(String r21_AVG_NO_DYS_SME) {
		R21_AVG_NO_DYS_SME = r21_AVG_NO_DYS_SME;
	}
	public String getR21_NO_REQ_CLO() {
		return R21_NO_REQ_CLO;
	}
	public void setR21_NO_REQ_CLO(String r21_NO_REQ_CLO) {
		R21_NO_REQ_CLO = r21_NO_REQ_CLO;
	}
	public String getR21_NO_PRD_VAR_SPC_TP() {
		return R21_NO_PRD_VAR_SPC_TP;
	}
	public void setR21_NO_PRD_VAR_SPC_TP(String r21_NO_PRD_VAR_SPC_TP) {
		R21_NO_PRD_VAR_SPC_TP = r21_NO_PRD_VAR_SPC_TP;
	}
	public String getR21_NO_REQ_RES_SPT() {
		return R21_NO_REQ_RES_SPT;
	}
	public void setR21_NO_REQ_RES_SPT(String r21_NO_REQ_RES_SPT) {
		R21_NO_REQ_RES_SPT = r21_NO_REQ_RES_SPT;
	}
	public String getR21_NO_REQ_PAYDEF() {
		return R21_NO_REQ_PAYDEF;
	}
	public void setR21_NO_REQ_PAYDEF(String r21_NO_REQ_PAYDEF) {
		R21_NO_REQ_PAYDEF = r21_NO_REQ_PAYDEF;
	}
	public String getR21_AVG_TME_REPAY() {
		return R21_AVG_TME_REPAY;
	}
	public void setR21_AVG_TME_REPAY(String r21_AVG_TME_REPAY) {
		R21_AVG_TME_REPAY = r21_AVG_TME_REPAY;
	}
	public String getR21_NO_INST_BAL() {
		return R21_NO_INST_BAL;
	}
	public void setR21_NO_INST_BAL(String r21_NO_INST_BAL) {
		R21_NO_INST_BAL = r21_NO_INST_BAL;
	}
	public String getR21_NET_FEE_AED() {
		return R21_NET_FEE_AED;
	}
	public void setR21_NET_FEE_AED(String r21_NET_FEE_AED) {
		R21_NET_FEE_AED = r21_NET_FEE_AED;
	}
	public String getR21_NET_PROF_AED() {
		return R21_NET_PROF_AED;
	}
	public void setR21_NET_PROF_AED(String r21_NET_PROF_AED) {
		R21_NET_PROF_AED = r21_NET_PROF_AED;
	}
	public String getR21_TOT_NO_ACC_SPD() {
		return R21_TOT_NO_ACC_SPD;
	}
	public void setR21_TOT_NO_ACC_SPD(String r21_TOT_NO_ACC_SPD) {
		R21_TOT_NO_ACC_SPD = r21_TOT_NO_ACC_SPD;
	}
	public String getR21_TOT_ACCS_DOR() {
		return R21_TOT_ACCS_DOR;
	}
	public void setR21_TOT_ACCS_DOR(String r21_TOT_ACCS_DOR) {
		R21_TOT_ACCS_DOR = r21_TOT_ACCS_DOR;
	}
	public String getR21_TOT_NEW_LOAN() {
		return R21_TOT_NEW_LOAN;
	}
	public void setR21_TOT_NEW_LOAN(String r21_TOT_NEW_LOAN) {
		R21_TOT_NEW_LOAN = r21_TOT_NEW_LOAN;
	}
	public String getR21_TOT_VAL_NEWACCS_AED() {
		return R21_TOT_VAL_NEWACCS_AED;
	}
	public void setR21_TOT_VAL_NEWACCS_AED(String r21_TOT_VAL_NEWACCS_AED) {
		R21_TOT_VAL_NEWACCS_AED = r21_TOT_VAL_NEWACCS_AED;
	}
	public String getR21_TOT_NO_LOAN_SPD() {
		return R21_TOT_NO_LOAN_SPD;
	}
	public void setR21_TOT_NO_LOAN_SPD(String r21_TOT_NO_LOAN_SPD) {
		R21_TOT_NO_LOAN_SPD = r21_TOT_NO_LOAN_SPD;
	}
	public String getR21_TOT_REQ_OTBNK() {
		return R21_TOT_REQ_OTBNK;
	}
	public void setR21_TOT_REQ_OTBNK(String r21_TOT_REQ_OTBNK) {
		R21_TOT_REQ_OTBNK = r21_TOT_REQ_OTBNK;
	}
	public String getR21_TOT_LOAN_OTBNK() {
		return R21_TOT_LOAN_OTBNK;
	}
	public void setR21_TOT_LOAN_OTBNK(String r21_TOT_LOAN_OTBNK) {
		R21_TOT_LOAN_OTBNK = r21_TOT_LOAN_OTBNK;
	}
	public String getR21_NO_CRACC_MIN() {
		return R21_NO_CRACC_MIN;
	}
	public void setR21_NO_CRACC_MIN(String r21_NO_CRACC_MIN) {
		R21_NO_CRACC_MIN = r21_NO_CRACC_MIN;
	}
	public String getR21_AVG_TME_CLSACC() {
		return R21_AVG_TME_CLSACC;
	}
	public void setR21_AVG_TME_CLSACC(String r21_AVG_TME_CLSACC) {
		R21_AVG_TME_CLSACC = r21_AVG_TME_CLSACC;
	}
	public String getR21_N0_CON_MORE1_LOAN() {
		return R21_N0_CON_MORE1_LOAN;
	}
	public void setR21_N0_CON_MORE1_LOAN(String r21_N0_CON_MORE1_LOAN) {
		R21_N0_CON_MORE1_LOAN = r21_N0_CON_MORE1_LOAN;
	}
	public String getR21_NO_INST_WITH90() {
		return R21_NO_INST_WITH90;
	}
	public void setR21_NO_INST_WITH90(String r21_NO_INST_WITH90) {
		R21_NO_INST_WITH90 = r21_NO_INST_WITH90;
	}
	public String getR21_TOT_GROSS_ASET() {
		return R21_TOT_GROSS_ASET;
	}
	public void setR21_TOT_GROSS_ASET(String r21_TOT_GROSS_ASET) {
		R21_TOT_GROSS_ASET = r21_TOT_GROSS_ASET;
	}
	public String getR21_RET_LIAB_AED() {
		return R21_RET_LIAB_AED;
	}
	public void setR21_RET_LIAB_AED(String r21_RET_LIAB_AED) {
		R21_RET_LIAB_AED = r21_RET_LIAB_AED;
	}
	public String getR21_HIG_PER_PROD_CAT() {
		return R21_HIG_PER_PROD_CAT;
	}
	public void setR21_HIG_PER_PROD_CAT(String r21_HIG_PER_PROD_CAT) {
		R21_HIG_PER_PROD_CAT = r21_HIG_PER_PROD_CAT;
	}
	public String getR21_NO_ACCS_TAG_NPA() {
		return R21_NO_ACCS_TAG_NPA;
	}
	public void setR21_NO_ACCS_TAG_NPA(String r21_NO_ACCS_TAG_NPA) {
		R21_NO_ACCS_TAG_NPA = r21_NO_ACCS_TAG_NPA;
	}
	public String getR21_NO_CHG_FEE_GRT5() {
		return R21_NO_CHG_FEE_GRT5;
	}
	public void setR21_NO_CHG_FEE_GRT5(String r21_NO_CHG_FEE_GRT5) {
		R21_NO_CHG_FEE_GRT5 = r21_NO_CHG_FEE_GRT5;
	}
	public String getR21_NO_CON_FLEX_INT() {
		return R21_NO_CON_FLEX_INT;
	}
	public void setR21_NO_CON_FLEX_INT(String r21_NO_CON_FLEX_INT) {
		R21_NO_CON_FLEX_INT = r21_NO_CON_FLEX_INT;
	}
	public String getR21_NO_CON_FIXED_INT() {
		return R21_NO_CON_FIXED_INT;
	}
	public void setR21_NO_CON_FIXED_INT(String r21_NO_CON_FIXED_INT) {
		R21_NO_CON_FIXED_INT = r21_NO_CON_FIXED_INT;
	}
	public String getR21_NO_LOAN_MAY_2011() {
		return R21_NO_LOAN_MAY_2011;
	}
	public void setR21_NO_LOAN_MAY_2011(String r21_NO_LOAN_MAY_2011) {
		R21_NO_LOAN_MAY_2011 = r21_NO_LOAN_MAY_2011;
	}
	public String getR21_VAL_LEGA_MAY_AED() {
		return R21_VAL_LEGA_MAY_AED;
	}
	public void setR21_VAL_LEGA_MAY_AED(String r21_VAL_LEGA_MAY_AED) {
		R21_VAL_LEGA_MAY_AED = r21_VAL_LEGA_MAY_AED;
	}
	public String getR21_AVG_DAY_NLL() {
		return R21_AVG_DAY_NLL;
	}
	public void setR21_AVG_DAY_NLL(String r21_AVG_DAY_NLL) {
		R21_AVG_DAY_NLL = r21_AVG_DAY_NLL;
	}
	public String getR21_PER_DOR_ACCS() {
		return R21_PER_DOR_ACCS;
	}
	public void setR21_PER_DOR_ACCS(String r21_PER_DOR_ACCS) {
		R21_PER_DOR_ACCS = r21_PER_DOR_ACCS;
	}
	public String getR21_INT_RET_PROF() {
		return R21_INT_RET_PROF;
	}
	public void setR21_INT_RET_PROF(String r21_INT_RET_PROF) {
		R21_INT_RET_PROF = r21_INT_RET_PROF;
	}
	public String getR21_FEE_COMM_PROF() {
		return R21_FEE_COMM_PROF;
	}
	public void setR21_FEE_COMM_PROF(String r21_FEE_COMM_PROF) {
		R21_FEE_COMM_PROF = r21_FEE_COMM_PROF;
	}
	public String getR21_TOT_UNCLM_90() {
		return R21_TOT_UNCLM_90;
	}
	public void setR21_TOT_UNCLM_90(String r21_TOT_UNCLM_90) {
		R21_TOT_UNCLM_90 = r21_TOT_UNCLM_90;
	}
	public String getR21_TOT_VAL_UNBAL() {
		return R21_TOT_VAL_UNBAL;
	}
	public void setR21_TOT_VAL_UNBAL(String r21_TOT_VAL_UNBAL) {
		R21_TOT_VAL_UNBAL = r21_TOT_VAL_UNBAL;
	}
	public String getR21_NO_INST_CONTRACT() {
		return R21_NO_INST_CONTRACT;
	}
	public void setR21_NO_INST_CONTRACT(String r21_NO_INST_CONTRACT) {
		R21_NO_INST_CONTRACT = r21_NO_INST_CONTRACT;
	}
	public String getR21_TOT_DORACC_NOTICE() {
		return R21_TOT_DORACC_NOTICE;
	}
	public void setR21_TOT_DORACC_NOTICE(String r21_TOT_DORACC_NOTICE) {
		R21_TOT_DORACC_NOTICE = r21_TOT_DORACC_NOTICE;
	}
	public String getR21_NO_CONS_LIAB_7DAY() {
		return R21_NO_CONS_LIAB_7DAY;
	}
	public void setR21_NO_CONS_LIAB_7DAY(String r21_NO_CONS_LIAB_7DAY) {
		R21_NO_CONS_LIAB_7DAY = r21_NO_CONS_LIAB_7DAY;
	}
	public String getR21_TOT_REQ_LIAB_NONLIA() {
		return R21_TOT_REQ_LIAB_NONLIA;
	}
	public void setR21_TOT_REQ_LIAB_NONLIA(String r21_TOT_REQ_LIAB_NONLIA) {
		R21_TOT_REQ_LIAB_NONLIA = r21_TOT_REQ_LIAB_NONLIA;
	}
	public String getR21_NO_RESTU_ONBO() {
		return R21_NO_RESTU_ONBO;
	}
	public void setR21_NO_RESTU_ONBO(String r21_NO_RESTU_ONBO) {
		R21_NO_RESTU_ONBO = r21_NO_RESTU_ONBO;
	}
	public String getR21_TOT_DELAY_TAT() {
		return R21_TOT_DELAY_TAT;
	}
	public void setR21_TOT_DELAY_TAT(String r21_TOT_DELAY_TAT) {
		R21_TOT_DELAY_TAT = r21_TOT_DELAY_TAT;
	}
	public String getR21_TOT_FND_TRAN() {
		return R21_TOT_FND_TRAN;
	}
	public void setR21_TOT_FND_TRAN(String r21_TOT_FND_TRAN) {
		R21_TOT_FND_TRAN = r21_TOT_FND_TRAN;
	}
	public String getR21_NO_FUND_RET24() {
		return R21_NO_FUND_RET24;
	}
	public void setR21_NO_FUND_RET24(String r21_NO_FUND_RET24) {
		R21_NO_FUND_RET24 = r21_NO_FUND_RET24;
	}
	public String getR21_NO_FAIL_TRAN() {
		return R21_NO_FAIL_TRAN;
	}
	public void setR21_NO_FAIL_TRAN(String r21_NO_FAIL_TRAN) {
		R21_NO_FAIL_TRAN = r21_NO_FAIL_TRAN;
	}
	public String getR21_CUS_FND_SVF_SPT() {
		return R21_CUS_FND_SVF_SPT;
	}
	public void setR21_CUS_FND_SVF_SPT(String r21_CUS_FND_SVF_SPT) {
		R21_CUS_FND_SVF_SPT = r21_CUS_FND_SVF_SPT;
	}
	public String getR21_CUS_FND_SVF_PRE() {
		return R21_CUS_FND_SVF_PRE;
	}
	public void setR21_CUS_FND_SVF_PRE(String r21_CUS_FND_SVF_PRE) {
		R21_CUS_FND_SVF_PRE = r21_CUS_FND_SVF_PRE;
	}
	public String getR21_TOT_CRDR_UND_SPT() {
		return R21_TOT_CRDR_UND_SPT;
	}
	public void setR21_TOT_CRDR_UND_SPT(String r21_TOT_CRDR_UND_SPT) {
		R21_TOT_CRDR_UND_SPT = r21_TOT_CRDR_UND_SPT;
	}
	public String getR21_TOT_CRD_ISU_SPT() {
		return R21_TOT_CRD_ISU_SPT;
	}
	public void setR21_TOT_CRD_ISU_SPT(String r21_TOT_CRD_ISU_SPT) {
		R21_TOT_CRD_ISU_SPT = r21_TOT_CRD_ISU_SPT;
	}
	public String getR21_NO_ACC_BLK_FIN() {
		return R21_NO_ACC_BLK_FIN;
	}
	public void setR21_NO_ACC_BLK_FIN(String r21_NO_ACC_BLK_FIN) {
		R21_NO_ACC_BLK_FIN = r21_NO_ACC_BLK_FIN;
	}
	public String getR21_NO_INQ_AVL_BAL() {
		return R21_NO_INQ_AVL_BAL;
	}
	public void setR21_NO_INQ_AVL_BAL(String r21_NO_INQ_AVL_BAL) {
		R21_NO_INQ_AVL_BAL = r21_NO_INQ_AVL_BAL;
	}
	public String getR21_TOT_PRE_EXP_SPT() {
		return R21_TOT_PRE_EXP_SPT;
	}
	public void setR21_TOT_PRE_EXP_SPT(String r21_TOT_PRE_EXP_SPT) {
		R21_TOT_PRE_EXP_SPT = r21_TOT_PRE_EXP_SPT;
	}
	public String getR21_TOT_PRE_POS_EXP() {
		return R21_TOT_PRE_POS_EXP;
	}
	public void setR21_TOT_PRE_POS_EXP(String r21_TOT_PRE_POS_EXP) {
		R21_TOT_PRE_POS_EXP = r21_TOT_PRE_POS_EXP;
	}
	public String getR21_TOT_PRE_CARD_SPD() {
		return R21_TOT_PRE_CARD_SPD;
	}
	public void setR21_TOT_PRE_CARD_SPD(String r21_TOT_PRE_CARD_SPD) {
		R21_TOT_PRE_CARD_SPD = r21_TOT_PRE_CARD_SPD;
	}
	public String getR21_TOT_ACCS_SPD() {
		return R21_TOT_ACCS_SPD;
	}
	public void setR21_TOT_ACCS_SPD(String r21_TOT_ACCS_SPD) {
		R21_TOT_ACCS_SPD = r21_TOT_ACCS_SPD;
	}
	public String getR21_NO_LANG_VOICE() {
		return R21_NO_LANG_VOICE;
	}
	public void setR21_NO_LANG_VOICE(String r21_NO_LANG_VOICE) {
		R21_NO_LANG_VOICE = r21_NO_LANG_VOICE;
	}
	public String getR21_AVG_NOD_LOWRSK() {
		return R21_AVG_NOD_LOWRSK;
	}
	public void setR21_AVG_NOD_LOWRSK(String r21_AVG_NOD_LOWRSK) {
		R21_AVG_NOD_LOWRSK = r21_AVG_NOD_LOWRSK;
	}
	public String getR21_NO_CUST_REISS_LIA() {
		return R21_NO_CUST_REISS_LIA;
	}
	public void setR21_NO_CUST_REISS_LIA(String r21_NO_CUST_REISS_LIA) {
		R21_NO_CUST_REISS_LIA = r21_NO_CUST_REISS_LIA;
	}
	public String getR21_NO_INS_CRRATE_CON() {
		return R21_NO_INS_CRRATE_CON;
	}
	public void setR21_NO_INS_CRRATE_CON(String r21_NO_INS_CRRATE_CON) {
		R21_NO_INS_CRRATE_CON = r21_NO_INS_CRRATE_CON;
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
	public String getR22_AVG_TME_LWRSK() {
		return R22_AVG_TME_LWRSK;
	}
	public void setR22_AVG_TME_LWRSK(String r22_AVG_TME_LWRSK) {
		R22_AVG_TME_LWRSK = r22_AVG_TME_LWRSK;
	}
	public String getR22_AVG_NO_LOAN() {
		return R22_AVG_NO_LOAN;
	}
	public void setR22_AVG_NO_LOAN(String r22_AVG_NO_LOAN) {
		R22_AVG_NO_LOAN = r22_AVG_NO_LOAN;
	}
	public String getR22_AVG_NO_LWRSK_SME() {
		return R22_AVG_NO_LWRSK_SME;
	}
	public void setR22_AVG_NO_LWRSK_SME(String r22_AVG_NO_LWRSK_SME) {
		R22_AVG_NO_LWRSK_SME = r22_AVG_NO_LWRSK_SME;
	}
	public String getR22_AVG_NO_DYS_SME() {
		return R22_AVG_NO_DYS_SME;
	}
	public void setR22_AVG_NO_DYS_SME(String r22_AVG_NO_DYS_SME) {
		R22_AVG_NO_DYS_SME = r22_AVG_NO_DYS_SME;
	}
	public String getR22_NO_REQ_CLO() {
		return R22_NO_REQ_CLO;
	}
	public void setR22_NO_REQ_CLO(String r22_NO_REQ_CLO) {
		R22_NO_REQ_CLO = r22_NO_REQ_CLO;
	}
	public String getR22_NO_PRD_VAR_SPC_TP() {
		return R22_NO_PRD_VAR_SPC_TP;
	}
	public void setR22_NO_PRD_VAR_SPC_TP(String r22_NO_PRD_VAR_SPC_TP) {
		R22_NO_PRD_VAR_SPC_TP = r22_NO_PRD_VAR_SPC_TP;
	}
	public String getR22_NO_REQ_RES_SPT() {
		return R22_NO_REQ_RES_SPT;
	}
	public void setR22_NO_REQ_RES_SPT(String r22_NO_REQ_RES_SPT) {
		R22_NO_REQ_RES_SPT = r22_NO_REQ_RES_SPT;
	}
	public String getR22_NO_REQ_PAYDEF() {
		return R22_NO_REQ_PAYDEF;
	}
	public void setR22_NO_REQ_PAYDEF(String r22_NO_REQ_PAYDEF) {
		R22_NO_REQ_PAYDEF = r22_NO_REQ_PAYDEF;
	}
	public String getR22_AVG_TME_REPAY() {
		return R22_AVG_TME_REPAY;
	}
	public void setR22_AVG_TME_REPAY(String r22_AVG_TME_REPAY) {
		R22_AVG_TME_REPAY = r22_AVG_TME_REPAY;
	}
	public String getR22_NO_INST_BAL() {
		return R22_NO_INST_BAL;
	}
	public void setR22_NO_INST_BAL(String r22_NO_INST_BAL) {
		R22_NO_INST_BAL = r22_NO_INST_BAL;
	}
	public String getR22_NET_FEE_AED() {
		return R22_NET_FEE_AED;
	}
	public void setR22_NET_FEE_AED(String r22_NET_FEE_AED) {
		R22_NET_FEE_AED = r22_NET_FEE_AED;
	}
	public String getR22_NET_PROF_AED() {
		return R22_NET_PROF_AED;
	}
	public void setR22_NET_PROF_AED(String r22_NET_PROF_AED) {
		R22_NET_PROF_AED = r22_NET_PROF_AED;
	}
	public String getR22_TOT_NO_ACC_SPD() {
		return R22_TOT_NO_ACC_SPD;
	}
	public void setR22_TOT_NO_ACC_SPD(String r22_TOT_NO_ACC_SPD) {
		R22_TOT_NO_ACC_SPD = r22_TOT_NO_ACC_SPD;
	}
	public String getR22_TOT_ACCS_DOR() {
		return R22_TOT_ACCS_DOR;
	}
	public void setR22_TOT_ACCS_DOR(String r22_TOT_ACCS_DOR) {
		R22_TOT_ACCS_DOR = r22_TOT_ACCS_DOR;
	}
	public String getR22_TOT_NEW_LOAN() {
		return R22_TOT_NEW_LOAN;
	}
	public void setR22_TOT_NEW_LOAN(String r22_TOT_NEW_LOAN) {
		R22_TOT_NEW_LOAN = r22_TOT_NEW_LOAN;
	}
	public String getR22_TOT_VAL_NEWACCS_AED() {
		return R22_TOT_VAL_NEWACCS_AED;
	}
	public void setR22_TOT_VAL_NEWACCS_AED(String r22_TOT_VAL_NEWACCS_AED) {
		R22_TOT_VAL_NEWACCS_AED = r22_TOT_VAL_NEWACCS_AED;
	}
	public String getR22_TOT_NO_LOAN_SPD() {
		return R22_TOT_NO_LOAN_SPD;
	}
	public void setR22_TOT_NO_LOAN_SPD(String r22_TOT_NO_LOAN_SPD) {
		R22_TOT_NO_LOAN_SPD = r22_TOT_NO_LOAN_SPD;
	}
	public String getR22_TOT_REQ_OTBNK() {
		return R22_TOT_REQ_OTBNK;
	}
	public void setR22_TOT_REQ_OTBNK(String r22_TOT_REQ_OTBNK) {
		R22_TOT_REQ_OTBNK = r22_TOT_REQ_OTBNK;
	}
	public String getR22_TOT_LOAN_OTBNK() {
		return R22_TOT_LOAN_OTBNK;
	}
	public void setR22_TOT_LOAN_OTBNK(String r22_TOT_LOAN_OTBNK) {
		R22_TOT_LOAN_OTBNK = r22_TOT_LOAN_OTBNK;
	}
	public String getR22_NO_CRACC_MIN() {
		return R22_NO_CRACC_MIN;
	}
	public void setR22_NO_CRACC_MIN(String r22_NO_CRACC_MIN) {
		R22_NO_CRACC_MIN = r22_NO_CRACC_MIN;
	}
	public String getR22_AVG_TME_CLSACC() {
		return R22_AVG_TME_CLSACC;
	}
	public void setR22_AVG_TME_CLSACC(String r22_AVG_TME_CLSACC) {
		R22_AVG_TME_CLSACC = r22_AVG_TME_CLSACC;
	}
	public String getR22_N0_CON_MORE1_LOAN() {
		return R22_N0_CON_MORE1_LOAN;
	}
	public void setR22_N0_CON_MORE1_LOAN(String r22_N0_CON_MORE1_LOAN) {
		R22_N0_CON_MORE1_LOAN = r22_N0_CON_MORE1_LOAN;
	}
	public String getR22_NO_INST_WITH90() {
		return R22_NO_INST_WITH90;
	}
	public void setR22_NO_INST_WITH90(String r22_NO_INST_WITH90) {
		R22_NO_INST_WITH90 = r22_NO_INST_WITH90;
	}
	public String getR22_TOT_GROSS_ASET() {
		return R22_TOT_GROSS_ASET;
	}
	public void setR22_TOT_GROSS_ASET(String r22_TOT_GROSS_ASET) {
		R22_TOT_GROSS_ASET = r22_TOT_GROSS_ASET;
	}
	public String getR22_RET_LIAB_AED() {
		return R22_RET_LIAB_AED;
	}
	public void setR22_RET_LIAB_AED(String r22_RET_LIAB_AED) {
		R22_RET_LIAB_AED = r22_RET_LIAB_AED;
	}
	public String getR22_HIG_PER_PROD_CAT() {
		return R22_HIG_PER_PROD_CAT;
	}
	public void setR22_HIG_PER_PROD_CAT(String r22_HIG_PER_PROD_CAT) {
		R22_HIG_PER_PROD_CAT = r22_HIG_PER_PROD_CAT;
	}
	public String getR22_NO_ACCS_TAG_NPA() {
		return R22_NO_ACCS_TAG_NPA;
	}
	public void setR22_NO_ACCS_TAG_NPA(String r22_NO_ACCS_TAG_NPA) {
		R22_NO_ACCS_TAG_NPA = r22_NO_ACCS_TAG_NPA;
	}
	public String getR22_NO_CHG_FEE_GRT5() {
		return R22_NO_CHG_FEE_GRT5;
	}
	public void setR22_NO_CHG_FEE_GRT5(String r22_NO_CHG_FEE_GRT5) {
		R22_NO_CHG_FEE_GRT5 = r22_NO_CHG_FEE_GRT5;
	}
	public String getR22_NO_CON_FLEX_INT() {
		return R22_NO_CON_FLEX_INT;
	}
	public void setR22_NO_CON_FLEX_INT(String r22_NO_CON_FLEX_INT) {
		R22_NO_CON_FLEX_INT = r22_NO_CON_FLEX_INT;
	}
	public String getR22_NO_CON_FIXED_INT() {
		return R22_NO_CON_FIXED_INT;
	}
	public void setR22_NO_CON_FIXED_INT(String r22_NO_CON_FIXED_INT) {
		R22_NO_CON_FIXED_INT = r22_NO_CON_FIXED_INT;
	}
	public String getR22_NO_LOAN_MAY_2011() {
		return R22_NO_LOAN_MAY_2011;
	}
	public void setR22_NO_LOAN_MAY_2011(String r22_NO_LOAN_MAY_2011) {
		R22_NO_LOAN_MAY_2011 = r22_NO_LOAN_MAY_2011;
	}
	public String getR22_VAL_LEGA_MAY_AED() {
		return R22_VAL_LEGA_MAY_AED;
	}
	public void setR22_VAL_LEGA_MAY_AED(String r22_VAL_LEGA_MAY_AED) {
		R22_VAL_LEGA_MAY_AED = r22_VAL_LEGA_MAY_AED;
	}
	public String getR22_AVG_DAY_NLL() {
		return R22_AVG_DAY_NLL;
	}
	public void setR22_AVG_DAY_NLL(String r22_AVG_DAY_NLL) {
		R22_AVG_DAY_NLL = r22_AVG_DAY_NLL;
	}
	public String getR22_PER_DOR_ACCS() {
		return R22_PER_DOR_ACCS;
	}
	public void setR22_PER_DOR_ACCS(String r22_PER_DOR_ACCS) {
		R22_PER_DOR_ACCS = r22_PER_DOR_ACCS;
	}
	public String getR22_INT_RET_PROF() {
		return R22_INT_RET_PROF;
	}
	public void setR22_INT_RET_PROF(String r22_INT_RET_PROF) {
		R22_INT_RET_PROF = r22_INT_RET_PROF;
	}
	public String getR22_FEE_COMM_PROF() {
		return R22_FEE_COMM_PROF;
	}
	public void setR22_FEE_COMM_PROF(String r22_FEE_COMM_PROF) {
		R22_FEE_COMM_PROF = r22_FEE_COMM_PROF;
	}
	public String getR22_TOT_UNCLM_90() {
		return R22_TOT_UNCLM_90;
	}
	public void setR22_TOT_UNCLM_90(String r22_TOT_UNCLM_90) {
		R22_TOT_UNCLM_90 = r22_TOT_UNCLM_90;
	}
	public String getR22_TOT_VAL_UNBAL() {
		return R22_TOT_VAL_UNBAL;
	}
	public void setR22_TOT_VAL_UNBAL(String r22_TOT_VAL_UNBAL) {
		R22_TOT_VAL_UNBAL = r22_TOT_VAL_UNBAL;
	}
	public String getR22_NO_INST_CONTRACT() {
		return R22_NO_INST_CONTRACT;
	}
	public void setR22_NO_INST_CONTRACT(String r22_NO_INST_CONTRACT) {
		R22_NO_INST_CONTRACT = r22_NO_INST_CONTRACT;
	}
	public String getR22_TOT_DORACC_NOTICE() {
		return R22_TOT_DORACC_NOTICE;
	}
	public void setR22_TOT_DORACC_NOTICE(String r22_TOT_DORACC_NOTICE) {
		R22_TOT_DORACC_NOTICE = r22_TOT_DORACC_NOTICE;
	}
	public String getR22_NO_CONS_LIAB_7DAY() {
		return R22_NO_CONS_LIAB_7DAY;
	}
	public void setR22_NO_CONS_LIAB_7DAY(String r22_NO_CONS_LIAB_7DAY) {
		R22_NO_CONS_LIAB_7DAY = r22_NO_CONS_LIAB_7DAY;
	}
	public String getR22_TOT_REQ_LIAB_NONLIA() {
		return R22_TOT_REQ_LIAB_NONLIA;
	}
	public void setR22_TOT_REQ_LIAB_NONLIA(String r22_TOT_REQ_LIAB_NONLIA) {
		R22_TOT_REQ_LIAB_NONLIA = r22_TOT_REQ_LIAB_NONLIA;
	}
	public String getR22_NO_RESTU_ONBO() {
		return R22_NO_RESTU_ONBO;
	}
	public void setR22_NO_RESTU_ONBO(String r22_NO_RESTU_ONBO) {
		R22_NO_RESTU_ONBO = r22_NO_RESTU_ONBO;
	}
	public String getR22_TOT_DELAY_TAT() {
		return R22_TOT_DELAY_TAT;
	}
	public void setR22_TOT_DELAY_TAT(String r22_TOT_DELAY_TAT) {
		R22_TOT_DELAY_TAT = r22_TOT_DELAY_TAT;
	}
	public String getR22_TOT_FND_TRAN() {
		return R22_TOT_FND_TRAN;
	}
	public void setR22_TOT_FND_TRAN(String r22_TOT_FND_TRAN) {
		R22_TOT_FND_TRAN = r22_TOT_FND_TRAN;
	}
	public String getR22_NO_FUND_RET24() {
		return R22_NO_FUND_RET24;
	}
	public void setR22_NO_FUND_RET24(String r22_NO_FUND_RET24) {
		R22_NO_FUND_RET24 = r22_NO_FUND_RET24;
	}
	public String getR22_NO_FAIL_TRAN() {
		return R22_NO_FAIL_TRAN;
	}
	public void setR22_NO_FAIL_TRAN(String r22_NO_FAIL_TRAN) {
		R22_NO_FAIL_TRAN = r22_NO_FAIL_TRAN;
	}
	public String getR22_CUS_FND_SVF_SPT() {
		return R22_CUS_FND_SVF_SPT;
	}
	public void setR22_CUS_FND_SVF_SPT(String r22_CUS_FND_SVF_SPT) {
		R22_CUS_FND_SVF_SPT = r22_CUS_FND_SVF_SPT;
	}
	public String getR22_CUS_FND_SVF_PRE() {
		return R22_CUS_FND_SVF_PRE;
	}
	public void setR22_CUS_FND_SVF_PRE(String r22_CUS_FND_SVF_PRE) {
		R22_CUS_FND_SVF_PRE = r22_CUS_FND_SVF_PRE;
	}
	public String getR22_TOT_CRDR_UND_SPT() {
		return R22_TOT_CRDR_UND_SPT;
	}
	public void setR22_TOT_CRDR_UND_SPT(String r22_TOT_CRDR_UND_SPT) {
		R22_TOT_CRDR_UND_SPT = r22_TOT_CRDR_UND_SPT;
	}
	public String getR22_TOT_CRD_ISU_SPT() {
		return R22_TOT_CRD_ISU_SPT;
	}
	public void setR22_TOT_CRD_ISU_SPT(String r22_TOT_CRD_ISU_SPT) {
		R22_TOT_CRD_ISU_SPT = r22_TOT_CRD_ISU_SPT;
	}
	public String getR22_NO_ACC_BLK_FIN() {
		return R22_NO_ACC_BLK_FIN;
	}
	public void setR22_NO_ACC_BLK_FIN(String r22_NO_ACC_BLK_FIN) {
		R22_NO_ACC_BLK_FIN = r22_NO_ACC_BLK_FIN;
	}
	public String getR22_NO_INQ_AVL_BAL() {
		return R22_NO_INQ_AVL_BAL;
	}
	public void setR22_NO_INQ_AVL_BAL(String r22_NO_INQ_AVL_BAL) {
		R22_NO_INQ_AVL_BAL = r22_NO_INQ_AVL_BAL;
	}
	public String getR22_TOT_PRE_EXP_SPT() {
		return R22_TOT_PRE_EXP_SPT;
	}
	public void setR22_TOT_PRE_EXP_SPT(String r22_TOT_PRE_EXP_SPT) {
		R22_TOT_PRE_EXP_SPT = r22_TOT_PRE_EXP_SPT;
	}
	public String getR22_TOT_PRE_POS_EXP() {
		return R22_TOT_PRE_POS_EXP;
	}
	public void setR22_TOT_PRE_POS_EXP(String r22_TOT_PRE_POS_EXP) {
		R22_TOT_PRE_POS_EXP = r22_TOT_PRE_POS_EXP;
	}
	public String getR22_TOT_PRE_CARD_SPD() {
		return R22_TOT_PRE_CARD_SPD;
	}
	public void setR22_TOT_PRE_CARD_SPD(String r22_TOT_PRE_CARD_SPD) {
		R22_TOT_PRE_CARD_SPD = r22_TOT_PRE_CARD_SPD;
	}
	public String getR22_TOT_ACCS_SPD() {
		return R22_TOT_ACCS_SPD;
	}
	public void setR22_TOT_ACCS_SPD(String r22_TOT_ACCS_SPD) {
		R22_TOT_ACCS_SPD = r22_TOT_ACCS_SPD;
	}
	public String getR22_NO_LANG_VOICE() {
		return R22_NO_LANG_VOICE;
	}
	public void setR22_NO_LANG_VOICE(String r22_NO_LANG_VOICE) {
		R22_NO_LANG_VOICE = r22_NO_LANG_VOICE;
	}
	public String getR22_AVG_NOD_LOWRSK() {
		return R22_AVG_NOD_LOWRSK;
	}
	public void setR22_AVG_NOD_LOWRSK(String r22_AVG_NOD_LOWRSK) {
		R22_AVG_NOD_LOWRSK = r22_AVG_NOD_LOWRSK;
	}
	public String getR22_NO_CUST_REISS_LIA() {
		return R22_NO_CUST_REISS_LIA;
	}
	public void setR22_NO_CUST_REISS_LIA(String r22_NO_CUST_REISS_LIA) {
		R22_NO_CUST_REISS_LIA = r22_NO_CUST_REISS_LIA;
	}
	public String getR22_NO_INS_CRRATE_CON() {
		return R22_NO_INS_CRRATE_CON;
	}
	public void setR22_NO_INS_CRRATE_CON(String r22_NO_INS_CRRATE_CON) {
		R22_NO_INS_CRRATE_CON = r22_NO_INS_CRRATE_CON;
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
	public String getR23_AVG_TME_LWRSK() {
		return R23_AVG_TME_LWRSK;
	}
	public void setR23_AVG_TME_LWRSK(String r23_AVG_TME_LWRSK) {
		R23_AVG_TME_LWRSK = r23_AVG_TME_LWRSK;
	}
	public String getR23_AVG_NO_LOAN() {
		return R23_AVG_NO_LOAN;
	}
	public void setR23_AVG_NO_LOAN(String r23_AVG_NO_LOAN) {
		R23_AVG_NO_LOAN = r23_AVG_NO_LOAN;
	}
	public String getR23_AVG_NO_LWRSK_SME() {
		return R23_AVG_NO_LWRSK_SME;
	}
	public void setR23_AVG_NO_LWRSK_SME(String r23_AVG_NO_LWRSK_SME) {
		R23_AVG_NO_LWRSK_SME = r23_AVG_NO_LWRSK_SME;
	}
	public String getR23_AVG_NO_DYS_SME() {
		return R23_AVG_NO_DYS_SME;
	}
	public void setR23_AVG_NO_DYS_SME(String r23_AVG_NO_DYS_SME) {
		R23_AVG_NO_DYS_SME = r23_AVG_NO_DYS_SME;
	}
	public String getR23_NO_REQ_CLO() {
		return R23_NO_REQ_CLO;
	}
	public void setR23_NO_REQ_CLO(String r23_NO_REQ_CLO) {
		R23_NO_REQ_CLO = r23_NO_REQ_CLO;
	}
	public String getR23_NO_PRD_VAR_SPC_TP() {
		return R23_NO_PRD_VAR_SPC_TP;
	}
	public void setR23_NO_PRD_VAR_SPC_TP(String r23_NO_PRD_VAR_SPC_TP) {
		R23_NO_PRD_VAR_SPC_TP = r23_NO_PRD_VAR_SPC_TP;
	}
	public String getR23_NO_REQ_RES_SPT() {
		return R23_NO_REQ_RES_SPT;
	}
	public void setR23_NO_REQ_RES_SPT(String r23_NO_REQ_RES_SPT) {
		R23_NO_REQ_RES_SPT = r23_NO_REQ_RES_SPT;
	}
	public String getR23_NO_REQ_PAYDEF() {
		return R23_NO_REQ_PAYDEF;
	}
	public void setR23_NO_REQ_PAYDEF(String r23_NO_REQ_PAYDEF) {
		R23_NO_REQ_PAYDEF = r23_NO_REQ_PAYDEF;
	}
	public String getR23_AVG_TME_REPAY() {
		return R23_AVG_TME_REPAY;
	}
	public void setR23_AVG_TME_REPAY(String r23_AVG_TME_REPAY) {
		R23_AVG_TME_REPAY = r23_AVG_TME_REPAY;
	}
	public String getR23_NO_INST_BAL() {
		return R23_NO_INST_BAL;
	}
	public void setR23_NO_INST_BAL(String r23_NO_INST_BAL) {
		R23_NO_INST_BAL = r23_NO_INST_BAL;
	}
	public String getR23_NET_FEE_AED() {
		return R23_NET_FEE_AED;
	}
	public void setR23_NET_FEE_AED(String r23_NET_FEE_AED) {
		R23_NET_FEE_AED = r23_NET_FEE_AED;
	}
	public String getR23_NET_PROF_AED() {
		return R23_NET_PROF_AED;
	}
	public void setR23_NET_PROF_AED(String r23_NET_PROF_AED) {
		R23_NET_PROF_AED = r23_NET_PROF_AED;
	}
	public String getR23_TOT_NO_ACC_SPD() {
		return R23_TOT_NO_ACC_SPD;
	}
	public void setR23_TOT_NO_ACC_SPD(String r23_TOT_NO_ACC_SPD) {
		R23_TOT_NO_ACC_SPD = r23_TOT_NO_ACC_SPD;
	}
	public String getR23_TOT_ACCS_DOR() {
		return R23_TOT_ACCS_DOR;
	}
	public void setR23_TOT_ACCS_DOR(String r23_TOT_ACCS_DOR) {
		R23_TOT_ACCS_DOR = r23_TOT_ACCS_DOR;
	}
	public String getR23_TOT_NEW_LOAN() {
		return R23_TOT_NEW_LOAN;
	}
	public void setR23_TOT_NEW_LOAN(String r23_TOT_NEW_LOAN) {
		R23_TOT_NEW_LOAN = r23_TOT_NEW_LOAN;
	}
	public String getR23_TOT_VAL_NEWACCS_AED() {
		return R23_TOT_VAL_NEWACCS_AED;
	}
	public void setR23_TOT_VAL_NEWACCS_AED(String r23_TOT_VAL_NEWACCS_AED) {
		R23_TOT_VAL_NEWACCS_AED = r23_TOT_VAL_NEWACCS_AED;
	}
	public String getR23_TOT_NO_LOAN_SPD() {
		return R23_TOT_NO_LOAN_SPD;
	}
	public void setR23_TOT_NO_LOAN_SPD(String r23_TOT_NO_LOAN_SPD) {
		R23_TOT_NO_LOAN_SPD = r23_TOT_NO_LOAN_SPD;
	}
	public String getR23_TOT_REQ_OTBNK() {
		return R23_TOT_REQ_OTBNK;
	}
	public void setR23_TOT_REQ_OTBNK(String r23_TOT_REQ_OTBNK) {
		R23_TOT_REQ_OTBNK = r23_TOT_REQ_OTBNK;
	}
	public String getR23_TOT_LOAN_OTBNK() {
		return R23_TOT_LOAN_OTBNK;
	}
	public void setR23_TOT_LOAN_OTBNK(String r23_TOT_LOAN_OTBNK) {
		R23_TOT_LOAN_OTBNK = r23_TOT_LOAN_OTBNK;
	}
	public String getR23_NO_CRACC_MIN() {
		return R23_NO_CRACC_MIN;
	}
	public void setR23_NO_CRACC_MIN(String r23_NO_CRACC_MIN) {
		R23_NO_CRACC_MIN = r23_NO_CRACC_MIN;
	}
	public String getR23_AVG_TME_CLSACC() {
		return R23_AVG_TME_CLSACC;
	}
	public void setR23_AVG_TME_CLSACC(String r23_AVG_TME_CLSACC) {
		R23_AVG_TME_CLSACC = r23_AVG_TME_CLSACC;
	}
	public String getR23_N0_CON_MORE1_LOAN() {
		return R23_N0_CON_MORE1_LOAN;
	}
	public void setR23_N0_CON_MORE1_LOAN(String r23_N0_CON_MORE1_LOAN) {
		R23_N0_CON_MORE1_LOAN = r23_N0_CON_MORE1_LOAN;
	}
	public String getR23_NO_INST_WITH90() {
		return R23_NO_INST_WITH90;
	}
	public void setR23_NO_INST_WITH90(String r23_NO_INST_WITH90) {
		R23_NO_INST_WITH90 = r23_NO_INST_WITH90;
	}
	public String getR23_TOT_GROSS_ASET() {
		return R23_TOT_GROSS_ASET;
	}
	public void setR23_TOT_GROSS_ASET(String r23_TOT_GROSS_ASET) {
		R23_TOT_GROSS_ASET = r23_TOT_GROSS_ASET;
	}
	public String getR23_RET_LIAB_AED() {
		return R23_RET_LIAB_AED;
	}
	public void setR23_RET_LIAB_AED(String r23_RET_LIAB_AED) {
		R23_RET_LIAB_AED = r23_RET_LIAB_AED;
	}
	public String getR23_HIG_PER_PROD_CAT() {
		return R23_HIG_PER_PROD_CAT;
	}
	public void setR23_HIG_PER_PROD_CAT(String r23_HIG_PER_PROD_CAT) {
		R23_HIG_PER_PROD_CAT = r23_HIG_PER_PROD_CAT;
	}
	public String getR23_NO_ACCS_TAG_NPA() {
		return R23_NO_ACCS_TAG_NPA;
	}
	public void setR23_NO_ACCS_TAG_NPA(String r23_NO_ACCS_TAG_NPA) {
		R23_NO_ACCS_TAG_NPA = r23_NO_ACCS_TAG_NPA;
	}
	public String getR23_NO_CHG_FEE_GRT5() {
		return R23_NO_CHG_FEE_GRT5;
	}
	public void setR23_NO_CHG_FEE_GRT5(String r23_NO_CHG_FEE_GRT5) {
		R23_NO_CHG_FEE_GRT5 = r23_NO_CHG_FEE_GRT5;
	}
	public String getR23_NO_CON_FLEX_INT() {
		return R23_NO_CON_FLEX_INT;
	}
	public void setR23_NO_CON_FLEX_INT(String r23_NO_CON_FLEX_INT) {
		R23_NO_CON_FLEX_INT = r23_NO_CON_FLEX_INT;
	}
	public String getR23_NO_CON_FIXED_INT() {
		return R23_NO_CON_FIXED_INT;
	}
	public void setR23_NO_CON_FIXED_INT(String r23_NO_CON_FIXED_INT) {
		R23_NO_CON_FIXED_INT = r23_NO_CON_FIXED_INT;
	}
	public String getR23_NO_LOAN_MAY_2011() {
		return R23_NO_LOAN_MAY_2011;
	}
	public void setR23_NO_LOAN_MAY_2011(String r23_NO_LOAN_MAY_2011) {
		R23_NO_LOAN_MAY_2011 = r23_NO_LOAN_MAY_2011;
	}
	public String getR23_VAL_LEGA_MAY_AED() {
		return R23_VAL_LEGA_MAY_AED;
	}
	public void setR23_VAL_LEGA_MAY_AED(String r23_VAL_LEGA_MAY_AED) {
		R23_VAL_LEGA_MAY_AED = r23_VAL_LEGA_MAY_AED;
	}
	public String getR23_AVG_DAY_NLL() {
		return R23_AVG_DAY_NLL;
	}
	public void setR23_AVG_DAY_NLL(String r23_AVG_DAY_NLL) {
		R23_AVG_DAY_NLL = r23_AVG_DAY_NLL;
	}
	public String getR23_PER_DOR_ACCS() {
		return R23_PER_DOR_ACCS;
	}
	public void setR23_PER_DOR_ACCS(String r23_PER_DOR_ACCS) {
		R23_PER_DOR_ACCS = r23_PER_DOR_ACCS;
	}
	public String getR23_INT_RET_PROF() {
		return R23_INT_RET_PROF;
	}
	public void setR23_INT_RET_PROF(String r23_INT_RET_PROF) {
		R23_INT_RET_PROF = r23_INT_RET_PROF;
	}
	public String getR23_FEE_COMM_PROF() {
		return R23_FEE_COMM_PROF;
	}
	public void setR23_FEE_COMM_PROF(String r23_FEE_COMM_PROF) {
		R23_FEE_COMM_PROF = r23_FEE_COMM_PROF;
	}
	public String getR23_TOT_UNCLM_90() {
		return R23_TOT_UNCLM_90;
	}
	public void setR23_TOT_UNCLM_90(String r23_TOT_UNCLM_90) {
		R23_TOT_UNCLM_90 = r23_TOT_UNCLM_90;
	}
	public String getR23_TOT_VAL_UNBAL() {
		return R23_TOT_VAL_UNBAL;
	}
	public void setR23_TOT_VAL_UNBAL(String r23_TOT_VAL_UNBAL) {
		R23_TOT_VAL_UNBAL = r23_TOT_VAL_UNBAL;
	}
	public String getR23_NO_INST_CONTRACT() {
		return R23_NO_INST_CONTRACT;
	}
	public void setR23_NO_INST_CONTRACT(String r23_NO_INST_CONTRACT) {
		R23_NO_INST_CONTRACT = r23_NO_INST_CONTRACT;
	}
	public String getR23_TOT_DORACC_NOTICE() {
		return R23_TOT_DORACC_NOTICE;
	}
	public void setR23_TOT_DORACC_NOTICE(String r23_TOT_DORACC_NOTICE) {
		R23_TOT_DORACC_NOTICE = r23_TOT_DORACC_NOTICE;
	}
	public String getR23_NO_CONS_LIAB_7DAY() {
		return R23_NO_CONS_LIAB_7DAY;
	}
	public void setR23_NO_CONS_LIAB_7DAY(String r23_NO_CONS_LIAB_7DAY) {
		R23_NO_CONS_LIAB_7DAY = r23_NO_CONS_LIAB_7DAY;
	}
	public String getR23_TOT_REQ_LIAB_NONLIA() {
		return R23_TOT_REQ_LIAB_NONLIA;
	}
	public void setR23_TOT_REQ_LIAB_NONLIA(String r23_TOT_REQ_LIAB_NONLIA) {
		R23_TOT_REQ_LIAB_NONLIA = r23_TOT_REQ_LIAB_NONLIA;
	}
	public String getR23_NO_RESTU_ONBO() {
		return R23_NO_RESTU_ONBO;
	}
	public void setR23_NO_RESTU_ONBO(String r23_NO_RESTU_ONBO) {
		R23_NO_RESTU_ONBO = r23_NO_RESTU_ONBO;
	}
	public String getR23_TOT_DELAY_TAT() {
		return R23_TOT_DELAY_TAT;
	}
	public void setR23_TOT_DELAY_TAT(String r23_TOT_DELAY_TAT) {
		R23_TOT_DELAY_TAT = r23_TOT_DELAY_TAT;
	}
	public String getR23_TOT_FND_TRAN() {
		return R23_TOT_FND_TRAN;
	}
	public void setR23_TOT_FND_TRAN(String r23_TOT_FND_TRAN) {
		R23_TOT_FND_TRAN = r23_TOT_FND_TRAN;
	}
	public String getR23_NO_FUND_RET24() {
		return R23_NO_FUND_RET24;
	}
	public void setR23_NO_FUND_RET24(String r23_NO_FUND_RET24) {
		R23_NO_FUND_RET24 = r23_NO_FUND_RET24;
	}
	public String getR23_NO_FAIL_TRAN() {
		return R23_NO_FAIL_TRAN;
	}
	public void setR23_NO_FAIL_TRAN(String r23_NO_FAIL_TRAN) {
		R23_NO_FAIL_TRAN = r23_NO_FAIL_TRAN;
	}
	public String getR23_CUS_FND_SVF_SPT() {
		return R23_CUS_FND_SVF_SPT;
	}
	public void setR23_CUS_FND_SVF_SPT(String r23_CUS_FND_SVF_SPT) {
		R23_CUS_FND_SVF_SPT = r23_CUS_FND_SVF_SPT;
	}
	public String getR23_CUS_FND_SVF_PRE() {
		return R23_CUS_FND_SVF_PRE;
	}
	public void setR23_CUS_FND_SVF_PRE(String r23_CUS_FND_SVF_PRE) {
		R23_CUS_FND_SVF_PRE = r23_CUS_FND_SVF_PRE;
	}
	public String getR23_TOT_CRDR_UND_SPT() {
		return R23_TOT_CRDR_UND_SPT;
	}
	public void setR23_TOT_CRDR_UND_SPT(String r23_TOT_CRDR_UND_SPT) {
		R23_TOT_CRDR_UND_SPT = r23_TOT_CRDR_UND_SPT;
	}
	public String getR23_TOT_CRD_ISU_SPT() {
		return R23_TOT_CRD_ISU_SPT;
	}
	public void setR23_TOT_CRD_ISU_SPT(String r23_TOT_CRD_ISU_SPT) {
		R23_TOT_CRD_ISU_SPT = r23_TOT_CRD_ISU_SPT;
	}
	public String getR23_NO_ACC_BLK_FIN() {
		return R23_NO_ACC_BLK_FIN;
	}
	public void setR23_NO_ACC_BLK_FIN(String r23_NO_ACC_BLK_FIN) {
		R23_NO_ACC_BLK_FIN = r23_NO_ACC_BLK_FIN;
	}
	public String getR23_NO_INQ_AVL_BAL() {
		return R23_NO_INQ_AVL_BAL;
	}
	public void setR23_NO_INQ_AVL_BAL(String r23_NO_INQ_AVL_BAL) {
		R23_NO_INQ_AVL_BAL = r23_NO_INQ_AVL_BAL;
	}
	public String getR23_TOT_PRE_EXP_SPT() {
		return R23_TOT_PRE_EXP_SPT;
	}
	public void setR23_TOT_PRE_EXP_SPT(String r23_TOT_PRE_EXP_SPT) {
		R23_TOT_PRE_EXP_SPT = r23_TOT_PRE_EXP_SPT;
	}
	public String getR23_TOT_PRE_POS_EXP() {
		return R23_TOT_PRE_POS_EXP;
	}
	public void setR23_TOT_PRE_POS_EXP(String r23_TOT_PRE_POS_EXP) {
		R23_TOT_PRE_POS_EXP = r23_TOT_PRE_POS_EXP;
	}
	public String getR23_TOT_PRE_CARD_SPD() {
		return R23_TOT_PRE_CARD_SPD;
	}
	public void setR23_TOT_PRE_CARD_SPD(String r23_TOT_PRE_CARD_SPD) {
		R23_TOT_PRE_CARD_SPD = r23_TOT_PRE_CARD_SPD;
	}
	public String getR23_TOT_ACCS_SPD() {
		return R23_TOT_ACCS_SPD;
	}
	public void setR23_TOT_ACCS_SPD(String r23_TOT_ACCS_SPD) {
		R23_TOT_ACCS_SPD = r23_TOT_ACCS_SPD;
	}
	public String getR23_NO_LANG_VOICE() {
		return R23_NO_LANG_VOICE;
	}
	public void setR23_NO_LANG_VOICE(String r23_NO_LANG_VOICE) {
		R23_NO_LANG_VOICE = r23_NO_LANG_VOICE;
	}
	public String getR23_AVG_NOD_LOWRSK() {
		return R23_AVG_NOD_LOWRSK;
	}
	public void setR23_AVG_NOD_LOWRSK(String r23_AVG_NOD_LOWRSK) {
		R23_AVG_NOD_LOWRSK = r23_AVG_NOD_LOWRSK;
	}
	public String getR23_NO_CUST_REISS_LIA() {
		return R23_NO_CUST_REISS_LIA;
	}
	public void setR23_NO_CUST_REISS_LIA(String r23_NO_CUST_REISS_LIA) {
		R23_NO_CUST_REISS_LIA = r23_NO_CUST_REISS_LIA;
	}
	public String getR23_NO_INS_CRRATE_CON() {
		return R23_NO_INS_CRRATE_CON;
	}
	public void setR23_NO_INS_CRRATE_CON(String r23_NO_INS_CRRATE_CON) {
		R23_NO_INS_CRRATE_CON = r23_NO_INS_CRRATE_CON;
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
	public RT_MC_TABLE4_2_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
