package com.bornfire.xbrl.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@IdClass(MCReportId.class)
@Table(name = "RT_MC_TABLE4_1")
public class RT_MC_TABLE4_1_ENTITY {
	
	public String R6_BANK;
    public String R6_PRODUCT;
    public String R6_AVG_TME_LWRSK;
    public String R6_AVG_NO_LOAN;
    public String R6_AVG_NO_LWRSK_SME;
    public String R6_AVG_NO_DYS_SME;
    public String R6_NO_REQ_CLO;
    public String R6_NO_PRD_VAR_SPC_TP;
    public String R6_NO_REQ_RES_SPT;
    public String R6_NO_REQ_PAYDEF;
    public String R6_AVG_TME_REPAY;
    public String R6_NO_INST_BAL;
    public String R6_NET_FEE_AED;
    public String R6_NET_PROF_AED;
    public String R6_TOT_NO_ACC_SPD;
    public String R6_TOT_ACCS_DOR;
    public String R6_TOT_NEW_LOAN;
    public String R6_TOT_VAL_NEWACCS_AED;
    public String R6_TOT_NO_LOAN_SPD;
    public String R6_TOT_REQ_OTBNK;
    public String R6_TOT_LOAN_OTBNK;
    public String R6_NO_CRACC_MIN;
    public String R6_AVG_TME_CLSACC;
    public String R6_N0_CON_MORE1_LOAN;
    public String R6_NO_INST_WITH90;
    public String R6_TOT_GROSS_ASET;
    public String R6_RET_LIAB_AED;
    public String R6_HIG_PER_PROD_CAT;
    public String R6_NO_ACCS_TAG_NPA;
    public String R6_NO_CHG_FEE_GRT5;
    public String R6_NO_CON_FLEX_INT;
    public String R6_NO_CON_FIXED_INT;
    public String R6_NO_LOAN_MAY_2011;
    public String R6_VAL_LEGA_MAY_AED;
    public String R6_AVG_DAY_NLL;
    public String R6_PER_DOR_ACCS;
    public String R6_INT_RET_PROF;
    public String R6_FEE_COMM_PROF;
    public String R6_TOT_UNCLM_90;
    public String R6_TOT_VAL_UNBAL;
    public String R6_NO_INST_CONTRACT;
    public String R6_TOT_DORACC_NOTICE;
    public String R6_NO_CONS_LIAB_7DAY;
    public String R6_TOT_REQ_LIAB_NONLIA;
    public String R6_NO_RESTU_ONBO;
    public String R6_TOT_DELAY_TAT;
    public String R6_TOT_FND_TRAN;
    public String R6_NO_FUND_RET24;
    public String R6_NO_FAIL_TRAN;
    public String R6_CUS_FND_SVF_SPT;
    public String R6_CUS_FND_SVF_PRE;
    public String R6_TOT_CRDR_UND_SPT;
    public String R6_TOT_CRD_ISU_SPT;
    public String R6_NO_ACC_BLK_FIN;
    public String R6_NO_INQ_AVL_BAL;
    public String R6_TOT_PRE_EXP_SPT;
    public String R6_TOT_PRE_POS_EXP;
    public String R6_TOT_PRE_CARD_SPD;
    public String R6_TOT_ACCS_SPD;
    public String R6_NO_LANG_VOICE;
    public String R6_AVG_NOD_LOWRSK;
    public String R6_NO_CUST_REISS_LIA;
    public String R6_NO_INS_CRRATE_CON;
    public String R7_BANK;
    public String R7_PRODUCT;
    public String R7_AVG_TME_LWRSK;
    public String R7_AVG_NO_LOAN;
    public String R7_AVG_NO_LWRSK_SME;
    public String R7_AVG_NO_DYS_SME;
    public String R7_NO_REQ_CLO;
    public String R7_NO_PRD_VAR_SPC_TP;
    public String R7_NO_REQ_RES_SPT;
    public String R7_NO_REQ_PAYDEF;
    public String R7_AVG_TME_REPAY;
    public String R7_NO_INST_BAL;
    public String R7_NET_FEE_AED;
    public String R7_NET_PROF_AED;
    public String R7_TOT_NO_ACC_SPD;
    public String R7_TOT_ACCS_DOR;
    public String R7_TOT_NEW_LOAN;
    public String R7_TOT_VAL_NEWACCS_AED;
    public String R7_TOT_NO_LOAN_SPD;
    public String R7_TOT_REQ_OTBNK;
    public String R7_TOT_LOAN_OTBNK;
    public String R7_NO_CRACC_MIN;
    public String R7_AVG_TME_CLSACC;
    public String R7_N0_CON_MORE1_LOAN;
    public String R7_NO_INST_WITH90;
    public String R7_TOT_GROSS_ASET;
    public String R7_RET_LIAB_AED;
    public String R7_HIG_PER_PROD_CAT;
    public String R7_NO_ACCS_TAG_NPA;
    public String R7_NO_CHG_FEE_GRT5;
    public String R7_NO_CON_FLEX_INT;
    public String R7_NO_CON_FIXED_INT;
    public String R7_NO_LOAN_MAY_2011;
    public String R7_VAL_LEGA_MAY_AED;
    public String R7_AVG_DAY_NLL;
    public String R7_PER_DOR_ACCS;
    public String R7_INT_RET_PROF;
    public String R7_FEE_COMM_PROF;
    public String R7_TOT_UNCLM_90;
    public String R7_TOT_VAL_UNBAL;
    public String R7_NO_INST_CONTRACT;
    public String R7_TOT_DORACC_NOTICE;
    public String R7_NO_CONS_LIAB_7DAY;
    public String R7_TOT_REQ_LIAB_NONLIA;
    public String R7_NO_RESTU_ONBO;
    public String R7_TOT_DELAY_TAT;
    public String R7_TOT_FND_TRAN;
    public String R7_NO_FUND_RET24;
    public String R7_NO_FAIL_TRAN;
    public String R7_CUS_FND_SVF_SPT;
    public String R7_CUS_FND_SVF_PRE;
    public String R7_TOT_CRDR_UND_SPT;
    public String R7_TOT_CRD_ISU_SPT;
    public String R7_NO_ACC_BLK_FIN;
    public String R7_NO_INQ_AVL_BAL;
    public String R7_TOT_PRE_EXP_SPT;
    public String R7_TOT_PRE_POS_EXP;
    public String R7_TOT_PRE_CARD_SPD;
    public String R7_TOT_ACCS_SPD;
    public String R7_NO_LANG_VOICE;
    public String R7_AVG_NOD_LOWRSK;
    public String R7_NO_CUST_REISS_LIA;
    public String R7_NO_INS_CRRATE_CON;
    public String R8_BANK;
    public String R8_PRODUCT;
    public String R8_AVG_TME_LWRSK;
    public String R8_AVG_NO_LOAN;
    public String R8_AVG_NO_LWRSK_SME;
    public String R8_AVG_NO_DYS_SME;
    public String R8_NO_REQ_CLO;
    public String R8_NO_PRD_VAR_SPC_TP;
    public String R8_NO_REQ_RES_SPT;
    public String R8_NO_REQ_PAYDEF;
    public String R8_AVG_TME_REPAY;
    public String R8_NO_INST_BAL;
    public String R8_NET_FEE_AED;
    public String R8_NET_PROF_AED;
    public String R8_TOT_NO_ACC_SPD;
    public String R8_TOT_ACCS_DOR;
    public String R8_TOT_NEW_LOAN;
    public String R8_TOT_VAL_NEWACCS_AED;
    public String R8_TOT_NO_LOAN_SPD;
    public String R8_TOT_REQ_OTBNK;
    public String R8_TOT_LOAN_OTBNK;
    public String R8_NO_CRACC_MIN;
    public String R8_AVG_TME_CLSACC;
    public String R8_N0_CON_MORE1_LOAN;
    public String R8_NO_INST_WITH90;
    public String R8_TOT_GROSS_ASET;
    public String R8_RET_LIAB_AED;
    public String R8_HIG_PER_PROD_CAT;
    public String R8_NO_ACCS_TAG_NPA;
    public String R8_NO_CHG_FEE_GRT5;
    public String R8_NO_CON_FLEX_INT;
    public String R8_NO_CON_FIXED_INT;
    public String R8_NO_LOAN_MAY_2011;
    public String R8_VAL_LEGA_MAY_AED;
    public String R8_AVG_DAY_NLL;
    public String R8_PER_DOR_ACCS;
    public String R8_INT_RET_PROF;
    public String R8_FEE_COMM_PROF;
    public String R8_TOT_UNCLM_90;
    public String R8_TOT_VAL_UNBAL;
    public String R8_NO_INST_CONTRACT;
    public String R8_TOT_DORACC_NOTICE;
    public String R8_NO_CONS_LIAB_7DAY;
    public String R8_TOT_REQ_LIAB_NONLIA;
    public String R8_NO_RESTU_ONBO;
    public String R8_TOT_DELAY_TAT;
    public String R8_TOT_FND_TRAN;
    public String R8_NO_FUND_RET24;
    public String R8_NO_FAIL_TRAN;
    public String R8_CUS_FND_SVF_SPT;
    public String R8_CUS_FND_SVF_PRE;
    public String R8_TOT_CRDR_UND_SPT;
    public String R8_TOT_CRD_ISU_SPT;
    public String R8_NO_ACC_BLK_FIN;
    public String R8_NO_INQ_AVL_BAL;
    public String R8_TOT_PRE_EXP_SPT;
    public String R8_TOT_PRE_POS_EXP;
    public String R8_TOT_PRE_CARD_SPD;
    public String R8_TOT_ACCS_SPD;
    public String R8_NO_LANG_VOICE;
    public String R8_AVG_NOD_LOWRSK;
    public String R8_NO_CUST_REISS_LIA;
    public String R8_NO_INS_CRRATE_CON;
    public String R9_BANK;
    public String R9_PRODUCT;
    public String R9_AVG_TME_LWRSK;
    public String R9_AVG_NO_LOAN;
    public String R9_AVG_NO_LWRSK_SME;
    public String R9_AVG_NO_DYS_SME;
    public String R9_NO_REQ_CLO;
    public String R9_NO_PRD_VAR_SPC_TP;
    public String R9_NO_REQ_RES_SPT;
    public String R9_NO_REQ_PAYDEF;
    public String R9_AVG_TME_REPAY;
    public String R9_NO_INST_BAL;
    public String R9_NET_FEE_AED;
    public String R9_NET_PROF_AED;
    public String R9_TOT_NO_ACC_SPD;
    public String R9_TOT_ACCS_DOR;
    public String R9_TOT_NEW_LOAN;
    public String R9_TOT_VAL_NEWACCS_AED;
    public String R9_TOT_NO_LOAN_SPD;
    public String R9_TOT_REQ_OTBNK;
    public String R9_TOT_LOAN_OTBNK;
    public String R9_NO_CRACC_MIN;
    public String R9_AVG_TME_CLSACC;
    public String R9_N0_CON_MORE1_LOAN;
    public String R9_NO_INST_WITH90;
    public String R9_TOT_GROSS_ASET;
    public String R9_RET_LIAB_AED;
    public String R9_HIG_PER_PROD_CAT;
    public String R9_NO_ACCS_TAG_NPA;
    public String R9_NO_CHG_FEE_GRT5;
    public String R9_NO_CON_FLEX_INT;
    public String R9_NO_CON_FIXED_INT;
    public String R9_NO_LOAN_MAY_2011;
    public String R9_VAL_LEGA_MAY_AED;
    public String R9_AVG_DAY_NLL;
    public String R9_PER_DOR_ACCS;
    public String R9_INT_RET_PROF;
    public String R9_FEE_COMM_PROF;
    public String R9_TOT_UNCLM_90;
    public String R9_TOT_VAL_UNBAL;
    public String R9_NO_INST_CONTRACT;
    public String R9_TOT_DORACC_NOTICE;
    public String R9_NO_CONS_LIAB_7DAY;
    public String R9_TOT_REQ_LIAB_NONLIA;
    public String R9_NO_RESTU_ONBO;
    public String R9_TOT_DELAY_TAT;
    public String R9_TOT_FND_TRAN;
    public String R9_NO_FUND_RET24;
    public String R9_NO_FAIL_TRAN;
    public String R9_CUS_FND_SVF_SPT;
    public String R9_CUS_FND_SVF_PRE;
    public String R9_TOT_CRDR_UND_SPT;
    public String R9_TOT_CRD_ISU_SPT;
    public String R9_NO_ACC_BLK_FIN;
    public String R9_NO_INQ_AVL_BAL;
    public String R9_TOT_PRE_EXP_SPT;
    public String R9_TOT_PRE_POS_EXP;
    public String R9_TOT_PRE_CARD_SPD;
    public String R9_TOT_ACCS_SPD;
    public String R9_NO_LANG_VOICE;
    public String R9_AVG_NOD_LOWRSK;
    public String R9_NO_CUST_REISS_LIA;
    public String R9_NO_INS_CRRATE_CON;
    public String R10_BANK;
    public String R10_PRODUCT;
    public String R10_AVG_TME_LWRSK;
    public String R10_AVG_NO_LOAN;
    public String R10_AVG_NO_LWRSK_SME;
    public String R10_AVG_NO_DYS_SME;
    public String R10_NO_REQ_CLO;
    public String R10_NO_PRD_VAR_SPC_TP;
    public String R10_NO_REQ_RES_SPT;
    public String R10_NO_REQ_PAYDEF;
    public String R10_AVG_TME_REPAY;
    public String R10_NO_INST_BAL;
    public String R10_NET_FEE_AED;
    public String R10_NET_PROF_AED;
    public String R10_TOT_NO_ACC_SPD;
    public String R10_TOT_ACCS_DOR;
    public String R10_TOT_NEW_LOAN;
    public String R10_TOT_VAL_NEWACCS_AED;
    public String R10_TOT_NO_LOAN_SPD;
    public String R10_TOT_REQ_OTBNK;
    public String R10_TOT_LOAN_OTBNK;
    public String R10_NO_CRACC_MIN;
    public String R10_AVG_TME_CLSACC;
    public String R10_N0_CON_MORE1_LOAN;
    public String R10_NO_INST_WITH90;
    public String R10_TOT_GROSS_ASET;
    public String R10_RET_LIAB_AED;
    public String R10_HIG_PER_PROD_CAT;
    public String R10_NO_ACCS_TAG_NPA;
    public String R10_NO_CHG_FEE_GRT5;
    public String R10_NO_CON_FLEX_INT;
    public String R10_NO_CON_FIXED_INT;
    public String R10_NO_LOAN_MAY_2011;
    public String R10_VAL_LEGA_MAY_AED;
    public String R10_AVG_DAY_NLL;
    public String R10_PER_DOR_ACCS;
    public String R10_INT_RET_PROF;
    public String R10_FEE_COMM_PROF;
    public String R10_TOT_UNCLM_90;
    public String R10_TOT_VAL_UNBAL;
    public String R10_NO_INST_CONTRACT;
    public String R10_TOT_DORACC_NOTICE;
    public String R10_NO_CONS_LIAB_7DAY;
    public String R10_TOT_REQ_LIAB_NONLIA;
    public String R10_NO_RESTU_ONBO;
    public String R10_TOT_DELAY_TAT;
    public String R10_TOT_FND_TRAN;
    public String R10_NO_FUND_RET24;
    public String R10_NO_FAIL_TRAN;
    public String R10_CUS_FND_SVF_SPT;
    public String R10_CUS_FND_SVF_PRE;
    public String R10_TOT_CRDR_UND_SPT;
    public String R10_TOT_CRD_ISU_SPT;
    public String R10_NO_ACC_BLK_FIN;
    public String R10_NO_INQ_AVL_BAL;
    public String R10_TOT_PRE_EXP_SPT;
    public String R10_TOT_PRE_POS_EXP;
    public String R10_TOT_PRE_CARD_SPD;
    public String R10_TOT_ACCS_SPD;
    public String R10_NO_LANG_VOICE;
    public String R10_AVG_NOD_LOWRSK;
    public String R10_NO_CUST_REISS_LIA;
    public String R10_NO_INS_CRRATE_CON;
    public String R11_BANK;
    public String R11_PRODUCT;
    public String R11_AVG_TME_LWRSK;
    public String R11_AVG_NO_LOAN;
    public String R11_AVG_NO_LWRSK_SME;
    public String R11_AVG_NO_DYS_SME;
    public String R11_NO_REQ_CLO;
    public String R11_NO_PRD_VAR_SPC_TP;
    public String R11_NO_REQ_RES_SPT;
    public String R11_NO_REQ_PAYDEF;
    public String R11_AVG_TME_REPAY;
    public String R11_NO_INST_BAL;
    public String R11_NET_FEE_AED;
    public String R11_NET_PROF_AED;
    public String R11_TOT_NO_ACC_SPD;
    public String R11_TOT_ACCS_DOR;
    public String R11_TOT_NEW_LOAN;
    public String R11_TOT_VAL_NEWACCS_AED;
    public String R11_TOT_NO_LOAN_SPD;
    public String R11_TOT_REQ_OTBNK;
    public String R11_TOT_LOAN_OTBNK;
    public String R11_NO_CRACC_MIN;
    public String R11_AVG_TME_CLSACC;
    public String R11_N0_CON_MORE1_LOAN;
    public String R11_NO_INST_WITH90;
    public String R11_TOT_GROSS_ASET;
    public String R11_RET_LIAB_AED;
    public String R11_HIG_PER_PROD_CAT;
    public String R11_NO_ACCS_TAG_NPA;
    public String R11_NO_CHG_FEE_GRT5;
    public String R11_NO_CON_FLEX_INT;
    public String R11_NO_CON_FIXED_INT;
    public String R11_NO_LOAN_MAY_2011;
    public String R11_VAL_LEGA_MAY_AED;
    public String R11_AVG_DAY_NLL;
    public String R11_PER_DOR_ACCS;
    public String R11_INT_RET_PROF;
    public String R11_FEE_COMM_PROF;
    public String R11_TOT_UNCLM_90;
    public String R11_TOT_VAL_UNBAL;
    public String R11_NO_INST_CONTRACT;
    public String R11_TOT_DORACC_NOTICE;
    public String R11_NO_CONS_LIAB_7DAY;
    public String R11_TOT_REQ_LIAB_NONLIA;
    public String R11_NO_RESTU_ONBO;
    public String R11_TOT_DELAY_TAT;
    public String R11_TOT_FND_TRAN;
    public String R11_NO_FUND_RET24;
    public String R11_NO_FAIL_TRAN;
    public String R11_CUS_FND_SVF_SPT;
    public String R11_CUS_FND_SVF_PRE;
    public String R11_TOT_CRDR_UND_SPT;
    public String R11_TOT_CRD_ISU_SPT;
    public String R11_NO_ACC_BLK_FIN;
    public String R11_NO_INQ_AVL_BAL;
    public String R11_TOT_PRE_EXP_SPT;
    public String R11_TOT_PRE_POS_EXP;
    public String R11_TOT_PRE_CARD_SPD;
    public String R11_TOT_ACCS_SPD;
    public String R11_NO_LANG_VOICE;
    public String R11_AVG_NOD_LOWRSK;
    public String R11_NO_CUST_REISS_LIA;
    public String R11_NO_INS_CRRATE_CON;
    public String R12_BANK;
    public String R12_PRODUCT;
    public String R12_AVG_TME_LWRSK;
    public String R12_AVG_NO_LOAN;
    public String R12_AVG_NO_LWRSK_SME;
    public String R12_AVG_NO_DYS_SME;
    public String R12_NO_REQ_CLO;
    public String R12_NO_PRD_VAR_SPC_TP;
    public String R12_NO_REQ_RES_SPT;
    public String R12_NO_REQ_PAYDEF;
    public String R12_AVG_TME_REPAY;
    public String R12_NO_INST_BAL;
    public String R12_NET_FEE_AED;
    public String R12_NET_PROF_AED;
    public String R12_TOT_NO_ACC_SPD;
    public String R12_TOT_ACCS_DOR;
    public String R12_TOT_NEW_LOAN;
    public String R12_TOT_VAL_NEWACCS_AED;
    public String R12_TOT_NO_LOAN_SPD;
    public String R12_TOT_REQ_OTBNK;
    public String R12_TOT_LOAN_OTBNK;
    public String R12_NO_CRACC_MIN;
    public String R12_AVG_TME_CLSACC;
    public String R12_N0_CON_MORE1_LOAN;
    public String R12_NO_INST_WITH90;
    public String R12_TOT_GROSS_ASET;
    public String R12_RET_LIAB_AED;
    public String R12_HIG_PER_PROD_CAT;
    public String R12_NO_ACCS_TAG_NPA;
    public String R12_NO_CHG_FEE_GRT5;
    public String R12_NO_CON_FLEX_INT;
    public String R12_NO_CON_FIXED_INT;
    public String R12_NO_LOAN_MAY_2011;
    public String R12_VAL_LEGA_MAY_AED;
    public String R12_AVG_DAY_NLL;
    public String R12_PER_DOR_ACCS;
    public String R12_INT_RET_PROF;
    public String R12_FEE_COMM_PROF;
    public String R12_TOT_UNCLM_90;
    public String R12_TOT_VAL_UNBAL;
    public String R12_NO_INST_CONTRACT;
    public String R12_TOT_DORACC_NOTICE;
    public String R12_NO_CONS_LIAB_7DAY;
    public String R12_TOT_REQ_LIAB_NONLIA;
    public String R12_NO_RESTU_ONBO;
    public String R12_TOT_DELAY_TAT;
    public String R12_TOT_FND_TRAN;
    public String R12_NO_FUND_RET24;
    public String R12_NO_FAIL_TRAN;
    public String R12_CUS_FND_SVF_SPT;
    public String R12_CUS_FND_SVF_PRE;
    public String R12_TOT_CRDR_UND_SPT;
    public String R12_TOT_CRD_ISU_SPT;
    public String R12_NO_ACC_BLK_FIN;
    public String R12_NO_INQ_AVL_BAL;
    public String R12_TOT_PRE_EXP_SPT;
    public String R12_TOT_PRE_POS_EXP;
    public String R12_TOT_PRE_CARD_SPD;
    public String R12_TOT_ACCS_SPD;
    public String R12_NO_LANG_VOICE;
    public String R12_AVG_NOD_LOWRSK;
    public String R12_NO_CUST_REISS_LIA;
    public String R12_NO_INS_CRRATE_CON;
    public String R13_BANK;
    public String R13_PRODUCT;
    public String R13_AVG_TME_LWRSK;
    public String R13_AVG_NO_LOAN;
    public String R13_AVG_NO_LWRSK_SME;
    public String R13_AVG_NO_DYS_SME;
    public String R13_NO_REQ_CLO;
    public String R13_NO_PRD_VAR_SPC_TP;
    public String R13_NO_REQ_RES_SPT;
    public String R13_NO_REQ_PAYDEF;
    public String R13_AVG_TME_REPAY;
    public String R13_NO_INST_BAL;
    public String R13_NET_FEE_AED;
    public String R13_NET_PROF_AED;
    public String R13_TOT_NO_ACC_SPD;
    public String R13_TOT_ACCS_DOR;
    public String R13_TOT_NEW_LOAN;
    public String R13_TOT_VAL_NEWACCS_AED;
    public String R13_TOT_NO_LOAN_SPD;
    public String R13_TOT_REQ_OTBNK;
    public String R13_TOT_LOAN_OTBNK;
    public String R13_NO_CRACC_MIN;
    public String R13_AVG_TME_CLSACC;
    public String R13_N0_CON_MORE1_LOAN;
    public String R13_NO_INST_WITH90;
    public String R13_TOT_GROSS_ASET;
    public String R13_RET_LIAB_AED;
    public String R13_HIG_PER_PROD_CAT;
    public String R13_NO_ACCS_TAG_NPA;
    public String R13_NO_CHG_FEE_GRT5;
    public String R13_NO_CON_FLEX_INT;
    public String R13_NO_CON_FIXED_INT;
    public String R13_NO_LOAN_MAY_2011;
    public String R13_VAL_LEGA_MAY_AED;
    public String R13_AVG_DAY_NLL;
    public String R13_PER_DOR_ACCS;
    public String R13_INT_RET_PROF;
    public String R13_FEE_COMM_PROF;
    public String R13_TOT_UNCLM_90;
    public String R13_TOT_VAL_UNBAL;
    public String R13_NO_INST_CONTRACT;
    public String R13_TOT_DORACC_NOTICE;
    public String R13_NO_CONS_LIAB_7DAY;
    public String R13_TOT_REQ_LIAB_NONLIA;
    public String R13_NO_RESTU_ONBO;
    public String R13_TOT_DELAY_TAT;
    public String R13_TOT_FND_TRAN;
    public String R13_NO_FUND_RET24;
    public String R13_NO_FAIL_TRAN;
    public String R13_CUS_FND_SVF_SPT;
    public String R13_CUS_FND_SVF_PRE;
    public String R13_TOT_CRDR_UND_SPT;
    public String R13_TOT_CRD_ISU_SPT;
    public String R13_NO_ACC_BLK_FIN;
    public String R13_NO_INQ_AVL_BAL;
    public String R13_TOT_PRE_EXP_SPT;
    public String R13_TOT_PRE_POS_EXP;
    public String R13_TOT_PRE_CARD_SPD;
    public String R13_TOT_ACCS_SPD;
    public String R13_NO_LANG_VOICE;
    public String R13_AVG_NOD_LOWRSK;
    public String R13_NO_CUST_REISS_LIA;
    public String R13_NO_INS_CRRATE_CON;
    public String R14_BANK;
    public String R14_PRODUCT;
    public String R14_AVG_TME_LWRSK;
    public String R14_AVG_NO_LOAN;
    public String R14_AVG_NO_LWRSK_SME;
    public String R14_AVG_NO_DYS_SME;
    public String R14_NO_REQ_CLO;
    public String R14_NO_PRD_VAR_SPC_TP;
    public String R14_NO_REQ_RES_SPT;
    public String R14_NO_REQ_PAYDEF;
    public String R14_AVG_TME_REPAY;
    public String R14_NO_INST_BAL;
    public String R14_NET_FEE_AED;
    public String R14_NET_PROF_AED;
    public String R14_TOT_NO_ACC_SPD;
    public String R14_TOT_ACCS_DOR;
    public String R14_TOT_NEW_LOAN;
    public String R14_TOT_VAL_NEWACCS_AED;
    public String R14_TOT_NO_LOAN_SPD;
    public String R14_TOT_REQ_OTBNK;
    public String R14_TOT_LOAN_OTBNK;
    public String R14_NO_CRACC_MIN;
    public String R14_AVG_TME_CLSACC;
    public String R14_N0_CON_MORE1_LOAN;
    public String R14_NO_INST_WITH90;
    public String R14_TOT_GROSS_ASET;
    public String R14_RET_LIAB_AED;
    public String R14_HIG_PER_PROD_CAT;
    public String R14_NO_ACCS_TAG_NPA;
    public String R14_NO_CHG_FEE_GRT5;
    public String R14_NO_CON_FLEX_INT;
    public String R14_NO_CON_FIXED_INT;
    public String R14_NO_LOAN_MAY_2011;
    public String R14_VAL_LEGA_MAY_AED;
    public String R14_AVG_DAY_NLL;
    public String R14_PER_DOR_ACCS;
    public String R14_INT_RET_PROF;
    public String R14_FEE_COMM_PROF;
    public String R14_TOT_UNCLM_90;
    public String R14_TOT_VAL_UNBAL;
    public String R14_NO_INST_CONTRACT;
    public String R14_TOT_DORACC_NOTICE;
    public String R14_NO_CONS_LIAB_7DAY;
    public String R14_TOT_REQ_LIAB_NONLIA;
    public String R14_NO_RESTU_ONBO;
    public String R14_TOT_DELAY_TAT;
    public String R14_TOT_FND_TRAN;
    public String R14_NO_FUND_RET24;
    public String R14_NO_FAIL_TRAN;
    public String R14_CUS_FND_SVF_SPT;
    public String R14_CUS_FND_SVF_PRE;
    public String R14_TOT_CRDR_UND_SPT;
    public String R14_TOT_CRD_ISU_SPT;
    public String R14_NO_ACC_BLK_FIN;
    public String R14_NO_INQ_AVL_BAL;
    public String R14_TOT_PRE_EXP_SPT;
    public String R14_TOT_PRE_POS_EXP;
    public String R14_TOT_PRE_CARD_SPD;
    public String R14_TOT_ACCS_SPD;
    public String R14_NO_LANG_VOICE;
    public String R14_AVG_NOD_LOWRSK;
    public String R14_NO_CUST_REISS_LIA;
    public String R14_NO_INS_CRRATE_CON;
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
	public String getR6_AVG_TME_LWRSK() {
		return R6_AVG_TME_LWRSK;
	}
	public void setR6_AVG_TME_LWRSK(String r6_AVG_TME_LWRSK) {
		R6_AVG_TME_LWRSK = r6_AVG_TME_LWRSK;
	}
	public String getR6_AVG_NO_LOAN() {
		return R6_AVG_NO_LOAN;
	}
	public void setR6_AVG_NO_LOAN(String r6_AVG_NO_LOAN) {
		R6_AVG_NO_LOAN = r6_AVG_NO_LOAN;
	}
	public String getR6_AVG_NO_LWRSK_SME() {
		return R6_AVG_NO_LWRSK_SME;
	}
	public void setR6_AVG_NO_LWRSK_SME(String r6_AVG_NO_LWRSK_SME) {
		R6_AVG_NO_LWRSK_SME = r6_AVG_NO_LWRSK_SME;
	}
	public String getR6_AVG_NO_DYS_SME() {
		return R6_AVG_NO_DYS_SME;
	}
	public void setR6_AVG_NO_DYS_SME(String r6_AVG_NO_DYS_SME) {
		R6_AVG_NO_DYS_SME = r6_AVG_NO_DYS_SME;
	}
	public String getR6_NO_REQ_CLO() {
		return R6_NO_REQ_CLO;
	}
	public void setR6_NO_REQ_CLO(String r6_NO_REQ_CLO) {
		R6_NO_REQ_CLO = r6_NO_REQ_CLO;
	}
	public String getR6_NO_PRD_VAR_SPC_TP() {
		return R6_NO_PRD_VAR_SPC_TP;
	}
	public void setR6_NO_PRD_VAR_SPC_TP(String r6_NO_PRD_VAR_SPC_TP) {
		R6_NO_PRD_VAR_SPC_TP = r6_NO_PRD_VAR_SPC_TP;
	}
	public String getR6_NO_REQ_RES_SPT() {
		return R6_NO_REQ_RES_SPT;
	}
	public void setR6_NO_REQ_RES_SPT(String r6_NO_REQ_RES_SPT) {
		R6_NO_REQ_RES_SPT = r6_NO_REQ_RES_SPT;
	}
	public String getR6_NO_REQ_PAYDEF() {
		return R6_NO_REQ_PAYDEF;
	}
	public void setR6_NO_REQ_PAYDEF(String r6_NO_REQ_PAYDEF) {
		R6_NO_REQ_PAYDEF = r6_NO_REQ_PAYDEF;
	}
	public String getR6_AVG_TME_REPAY() {
		return R6_AVG_TME_REPAY;
	}
	public void setR6_AVG_TME_REPAY(String r6_AVG_TME_REPAY) {
		R6_AVG_TME_REPAY = r6_AVG_TME_REPAY;
	}
	public String getR6_NO_INST_BAL() {
		return R6_NO_INST_BAL;
	}
	public void setR6_NO_INST_BAL(String r6_NO_INST_BAL) {
		R6_NO_INST_BAL = r6_NO_INST_BAL;
	}
	public String getR6_NET_FEE_AED() {
		return R6_NET_FEE_AED;
	}
	public void setR6_NET_FEE_AED(String r6_NET_FEE_AED) {
		R6_NET_FEE_AED = r6_NET_FEE_AED;
	}
	public String getR6_NET_PROF_AED() {
		return R6_NET_PROF_AED;
	}
	public void setR6_NET_PROF_AED(String r6_NET_PROF_AED) {
		R6_NET_PROF_AED = r6_NET_PROF_AED;
	}
	public String getR6_TOT_NO_ACC_SPD() {
		return R6_TOT_NO_ACC_SPD;
	}
	public void setR6_TOT_NO_ACC_SPD(String r6_TOT_NO_ACC_SPD) {
		R6_TOT_NO_ACC_SPD = r6_TOT_NO_ACC_SPD;
	}
	public String getR6_TOT_ACCS_DOR() {
		return R6_TOT_ACCS_DOR;
	}
	public void setR6_TOT_ACCS_DOR(String r6_TOT_ACCS_DOR) {
		R6_TOT_ACCS_DOR = r6_TOT_ACCS_DOR;
	}
	public String getR6_TOT_NEW_LOAN() {
		return R6_TOT_NEW_LOAN;
	}
	public void setR6_TOT_NEW_LOAN(String r6_TOT_NEW_LOAN) {
		R6_TOT_NEW_LOAN = r6_TOT_NEW_LOAN;
	}
	public String getR6_TOT_VAL_NEWACCS_AED() {
		return R6_TOT_VAL_NEWACCS_AED;
	}
	public void setR6_TOT_VAL_NEWACCS_AED(String r6_TOT_VAL_NEWACCS_AED) {
		R6_TOT_VAL_NEWACCS_AED = r6_TOT_VAL_NEWACCS_AED;
	}
	public String getR6_TOT_NO_LOAN_SPD() {
		return R6_TOT_NO_LOAN_SPD;
	}
	public void setR6_TOT_NO_LOAN_SPD(String r6_TOT_NO_LOAN_SPD) {
		R6_TOT_NO_LOAN_SPD = r6_TOT_NO_LOAN_SPD;
	}
	public String getR6_TOT_REQ_OTBNK() {
		return R6_TOT_REQ_OTBNK;
	}
	public void setR6_TOT_REQ_OTBNK(String r6_TOT_REQ_OTBNK) {
		R6_TOT_REQ_OTBNK = r6_TOT_REQ_OTBNK;
	}
	public String getR6_TOT_LOAN_OTBNK() {
		return R6_TOT_LOAN_OTBNK;
	}
	public void setR6_TOT_LOAN_OTBNK(String r6_TOT_LOAN_OTBNK) {
		R6_TOT_LOAN_OTBNK = r6_TOT_LOAN_OTBNK;
	}
	public String getR6_NO_CRACC_MIN() {
		return R6_NO_CRACC_MIN;
	}
	public void setR6_NO_CRACC_MIN(String r6_NO_CRACC_MIN) {
		R6_NO_CRACC_MIN = r6_NO_CRACC_MIN;
	}
	public String getR6_AVG_TME_CLSACC() {
		return R6_AVG_TME_CLSACC;
	}
	public void setR6_AVG_TME_CLSACC(String r6_AVG_TME_CLSACC) {
		R6_AVG_TME_CLSACC = r6_AVG_TME_CLSACC;
	}
	public String getR6_N0_CON_MORE1_LOAN() {
		return R6_N0_CON_MORE1_LOAN;
	}
	public void setR6_N0_CON_MORE1_LOAN(String r6_N0_CON_MORE1_LOAN) {
		R6_N0_CON_MORE1_LOAN = r6_N0_CON_MORE1_LOAN;
	}
	public String getR6_NO_INST_WITH90() {
		return R6_NO_INST_WITH90;
	}
	public void setR6_NO_INST_WITH90(String r6_NO_INST_WITH90) {
		R6_NO_INST_WITH90 = r6_NO_INST_WITH90;
	}
	public String getR6_TOT_GROSS_ASET() {
		return R6_TOT_GROSS_ASET;
	}
	public void setR6_TOT_GROSS_ASET(String r6_TOT_GROSS_ASET) {
		R6_TOT_GROSS_ASET = r6_TOT_GROSS_ASET;
	}
	public String getR6_RET_LIAB_AED() {
		return R6_RET_LIAB_AED;
	}
	public void setR6_RET_LIAB_AED(String r6_RET_LIAB_AED) {
		R6_RET_LIAB_AED = r6_RET_LIAB_AED;
	}
	public String getR6_HIG_PER_PROD_CAT() {
		return R6_HIG_PER_PROD_CAT;
	}
	public void setR6_HIG_PER_PROD_CAT(String r6_HIG_PER_PROD_CAT) {
		R6_HIG_PER_PROD_CAT = r6_HIG_PER_PROD_CAT;
	}
	public String getR6_NO_ACCS_TAG_NPA() {
		return R6_NO_ACCS_TAG_NPA;
	}
	public void setR6_NO_ACCS_TAG_NPA(String r6_NO_ACCS_TAG_NPA) {
		R6_NO_ACCS_TAG_NPA = r6_NO_ACCS_TAG_NPA;
	}
	public String getR6_NO_CHG_FEE_GRT5() {
		return R6_NO_CHG_FEE_GRT5;
	}
	public void setR6_NO_CHG_FEE_GRT5(String r6_NO_CHG_FEE_GRT5) {
		R6_NO_CHG_FEE_GRT5 = r6_NO_CHG_FEE_GRT5;
	}
	public String getR6_NO_CON_FLEX_INT() {
		return R6_NO_CON_FLEX_INT;
	}
	public void setR6_NO_CON_FLEX_INT(String r6_NO_CON_FLEX_INT) {
		R6_NO_CON_FLEX_INT = r6_NO_CON_FLEX_INT;
	}
	public String getR6_NO_CON_FIXED_INT() {
		return R6_NO_CON_FIXED_INT;
	}
	public void setR6_NO_CON_FIXED_INT(String r6_NO_CON_FIXED_INT) {
		R6_NO_CON_FIXED_INT = r6_NO_CON_FIXED_INT;
	}
	public String getR6_NO_LOAN_MAY_2011() {
		return R6_NO_LOAN_MAY_2011;
	}
	public void setR6_NO_LOAN_MAY_2011(String r6_NO_LOAN_MAY_2011) {
		R6_NO_LOAN_MAY_2011 = r6_NO_LOAN_MAY_2011;
	}
	public String getR6_VAL_LEGA_MAY_AED() {
		return R6_VAL_LEGA_MAY_AED;
	}
	public void setR6_VAL_LEGA_MAY_AED(String r6_VAL_LEGA_MAY_AED) {
		R6_VAL_LEGA_MAY_AED = r6_VAL_LEGA_MAY_AED;
	}
	public String getR6_AVG_DAY_NLL() {
		return R6_AVG_DAY_NLL;
	}
	public void setR6_AVG_DAY_NLL(String r6_AVG_DAY_NLL) {
		R6_AVG_DAY_NLL = r6_AVG_DAY_NLL;
	}
	public String getR6_PER_DOR_ACCS() {
		return R6_PER_DOR_ACCS;
	}
	public void setR6_PER_DOR_ACCS(String r6_PER_DOR_ACCS) {
		R6_PER_DOR_ACCS = r6_PER_DOR_ACCS;
	}
	public String getR6_INT_RET_PROF() {
		return R6_INT_RET_PROF;
	}
	public void setR6_INT_RET_PROF(String r6_INT_RET_PROF) {
		R6_INT_RET_PROF = r6_INT_RET_PROF;
	}
	public String getR6_FEE_COMM_PROF() {
		return R6_FEE_COMM_PROF;
	}
	public void setR6_FEE_COMM_PROF(String r6_FEE_COMM_PROF) {
		R6_FEE_COMM_PROF = r6_FEE_COMM_PROF;
	}
	public String getR6_TOT_UNCLM_90() {
		return R6_TOT_UNCLM_90;
	}
	public void setR6_TOT_UNCLM_90(String r6_TOT_UNCLM_90) {
		R6_TOT_UNCLM_90 = r6_TOT_UNCLM_90;
	}
	public String getR6_TOT_VAL_UNBAL() {
		return R6_TOT_VAL_UNBAL;
	}
	public void setR6_TOT_VAL_UNBAL(String r6_TOT_VAL_UNBAL) {
		R6_TOT_VAL_UNBAL = r6_TOT_VAL_UNBAL;
	}
	public String getR6_NO_INST_CONTRACT() {
		return R6_NO_INST_CONTRACT;
	}
	public void setR6_NO_INST_CONTRACT(String r6_NO_INST_CONTRACT) {
		R6_NO_INST_CONTRACT = r6_NO_INST_CONTRACT;
	}
	public String getR6_TOT_DORACC_NOTICE() {
		return R6_TOT_DORACC_NOTICE;
	}
	public void setR6_TOT_DORACC_NOTICE(String r6_TOT_DORACC_NOTICE) {
		R6_TOT_DORACC_NOTICE = r6_TOT_DORACC_NOTICE;
	}
	public String getR6_NO_CONS_LIAB_7DAY() {
		return R6_NO_CONS_LIAB_7DAY;
	}
	public void setR6_NO_CONS_LIAB_7DAY(String r6_NO_CONS_LIAB_7DAY) {
		R6_NO_CONS_LIAB_7DAY = r6_NO_CONS_LIAB_7DAY;
	}
	public String getR6_TOT_REQ_LIAB_NONLIA() {
		return R6_TOT_REQ_LIAB_NONLIA;
	}
	public void setR6_TOT_REQ_LIAB_NONLIA(String r6_TOT_REQ_LIAB_NONLIA) {
		R6_TOT_REQ_LIAB_NONLIA = r6_TOT_REQ_LIAB_NONLIA;
	}
	public String getR6_NO_RESTU_ONBO() {
		return R6_NO_RESTU_ONBO;
	}
	public void setR6_NO_RESTU_ONBO(String r6_NO_RESTU_ONBO) {
		R6_NO_RESTU_ONBO = r6_NO_RESTU_ONBO;
	}
	public String getR6_TOT_DELAY_TAT() {
		return R6_TOT_DELAY_TAT;
	}
	public void setR6_TOT_DELAY_TAT(String r6_TOT_DELAY_TAT) {
		R6_TOT_DELAY_TAT = r6_TOT_DELAY_TAT;
	}
	public String getR6_TOT_FND_TRAN() {
		return R6_TOT_FND_TRAN;
	}
	public void setR6_TOT_FND_TRAN(String r6_TOT_FND_TRAN) {
		R6_TOT_FND_TRAN = r6_TOT_FND_TRAN;
	}
	public String getR6_NO_FUND_RET24() {
		return R6_NO_FUND_RET24;
	}
	public void setR6_NO_FUND_RET24(String r6_NO_FUND_RET24) {
		R6_NO_FUND_RET24 = r6_NO_FUND_RET24;
	}
	public String getR6_NO_FAIL_TRAN() {
		return R6_NO_FAIL_TRAN;
	}
	public void setR6_NO_FAIL_TRAN(String r6_NO_FAIL_TRAN) {
		R6_NO_FAIL_TRAN = r6_NO_FAIL_TRAN;
	}
	public String getR6_CUS_FND_SVF_SPT() {
		return R6_CUS_FND_SVF_SPT;
	}
	public void setR6_CUS_FND_SVF_SPT(String r6_CUS_FND_SVF_SPT) {
		R6_CUS_FND_SVF_SPT = r6_CUS_FND_SVF_SPT;
	}
	public String getR6_CUS_FND_SVF_PRE() {
		return R6_CUS_FND_SVF_PRE;
	}
	public void setR6_CUS_FND_SVF_PRE(String r6_CUS_FND_SVF_PRE) {
		R6_CUS_FND_SVF_PRE = r6_CUS_FND_SVF_PRE;
	}
	public String getR6_TOT_CRDR_UND_SPT() {
		return R6_TOT_CRDR_UND_SPT;
	}
	public void setR6_TOT_CRDR_UND_SPT(String r6_TOT_CRDR_UND_SPT) {
		R6_TOT_CRDR_UND_SPT = r6_TOT_CRDR_UND_SPT;
	}
	public String getR6_TOT_CRD_ISU_SPT() {
		return R6_TOT_CRD_ISU_SPT;
	}
	public void setR6_TOT_CRD_ISU_SPT(String r6_TOT_CRD_ISU_SPT) {
		R6_TOT_CRD_ISU_SPT = r6_TOT_CRD_ISU_SPT;
	}
	public String getR6_NO_ACC_BLK_FIN() {
		return R6_NO_ACC_BLK_FIN;
	}
	public void setR6_NO_ACC_BLK_FIN(String r6_NO_ACC_BLK_FIN) {
		R6_NO_ACC_BLK_FIN = r6_NO_ACC_BLK_FIN;
	}
	public String getR6_NO_INQ_AVL_BAL() {
		return R6_NO_INQ_AVL_BAL;
	}
	public void setR6_NO_INQ_AVL_BAL(String r6_NO_INQ_AVL_BAL) {
		R6_NO_INQ_AVL_BAL = r6_NO_INQ_AVL_BAL;
	}
	public String getR6_TOT_PRE_EXP_SPT() {
		return R6_TOT_PRE_EXP_SPT;
	}
	public void setR6_TOT_PRE_EXP_SPT(String r6_TOT_PRE_EXP_SPT) {
		R6_TOT_PRE_EXP_SPT = r6_TOT_PRE_EXP_SPT;
	}
	public String getR6_TOT_PRE_POS_EXP() {
		return R6_TOT_PRE_POS_EXP;
	}
	public void setR6_TOT_PRE_POS_EXP(String r6_TOT_PRE_POS_EXP) {
		R6_TOT_PRE_POS_EXP = r6_TOT_PRE_POS_EXP;
	}
	public String getR6_TOT_PRE_CARD_SPD() {
		return R6_TOT_PRE_CARD_SPD;
	}
	public void setR6_TOT_PRE_CARD_SPD(String r6_TOT_PRE_CARD_SPD) {
		R6_TOT_PRE_CARD_SPD = r6_TOT_PRE_CARD_SPD;
	}
	public String getR6_TOT_ACCS_SPD() {
		return R6_TOT_ACCS_SPD;
	}
	public void setR6_TOT_ACCS_SPD(String r6_TOT_ACCS_SPD) {
		R6_TOT_ACCS_SPD = r6_TOT_ACCS_SPD;
	}
	public String getR6_NO_LANG_VOICE() {
		return R6_NO_LANG_VOICE;
	}
	public void setR6_NO_LANG_VOICE(String r6_NO_LANG_VOICE) {
		R6_NO_LANG_VOICE = r6_NO_LANG_VOICE;
	}
	public String getR6_AVG_NOD_LOWRSK() {
		return R6_AVG_NOD_LOWRSK;
	}
	public void setR6_AVG_NOD_LOWRSK(String r6_AVG_NOD_LOWRSK) {
		R6_AVG_NOD_LOWRSK = r6_AVG_NOD_LOWRSK;
	}
	public String getR6_NO_CUST_REISS_LIA() {
		return R6_NO_CUST_REISS_LIA;
	}
	public void setR6_NO_CUST_REISS_LIA(String r6_NO_CUST_REISS_LIA) {
		R6_NO_CUST_REISS_LIA = r6_NO_CUST_REISS_LIA;
	}
	public String getR6_NO_INS_CRRATE_CON() {
		return R6_NO_INS_CRRATE_CON;
	}
	public void setR6_NO_INS_CRRATE_CON(String r6_NO_INS_CRRATE_CON) {
		R6_NO_INS_CRRATE_CON = r6_NO_INS_CRRATE_CON;
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
	public String getR7_AVG_TME_LWRSK() {
		return R7_AVG_TME_LWRSK;
	}
	public void setR7_AVG_TME_LWRSK(String r7_AVG_TME_LWRSK) {
		R7_AVG_TME_LWRSK = r7_AVG_TME_LWRSK;
	}
	public String getR7_AVG_NO_LOAN() {
		return R7_AVG_NO_LOAN;
	}
	public void setR7_AVG_NO_LOAN(String r7_AVG_NO_LOAN) {
		R7_AVG_NO_LOAN = r7_AVG_NO_LOAN;
	}
	public String getR7_AVG_NO_LWRSK_SME() {
		return R7_AVG_NO_LWRSK_SME;
	}
	public void setR7_AVG_NO_LWRSK_SME(String r7_AVG_NO_LWRSK_SME) {
		R7_AVG_NO_LWRSK_SME = r7_AVG_NO_LWRSK_SME;
	}
	public String getR7_AVG_NO_DYS_SME() {
		return R7_AVG_NO_DYS_SME;
	}
	public void setR7_AVG_NO_DYS_SME(String r7_AVG_NO_DYS_SME) {
		R7_AVG_NO_DYS_SME = r7_AVG_NO_DYS_SME;
	}
	public String getR7_NO_REQ_CLO() {
		return R7_NO_REQ_CLO;
	}
	public void setR7_NO_REQ_CLO(String r7_NO_REQ_CLO) {
		R7_NO_REQ_CLO = r7_NO_REQ_CLO;
	}
	public String getR7_NO_PRD_VAR_SPC_TP() {
		return R7_NO_PRD_VAR_SPC_TP;
	}
	public void setR7_NO_PRD_VAR_SPC_TP(String r7_NO_PRD_VAR_SPC_TP) {
		R7_NO_PRD_VAR_SPC_TP = r7_NO_PRD_VAR_SPC_TP;
	}
	public String getR7_NO_REQ_RES_SPT() {
		return R7_NO_REQ_RES_SPT;
	}
	public void setR7_NO_REQ_RES_SPT(String r7_NO_REQ_RES_SPT) {
		R7_NO_REQ_RES_SPT = r7_NO_REQ_RES_SPT;
	}
	public String getR7_NO_REQ_PAYDEF() {
		return R7_NO_REQ_PAYDEF;
	}
	public void setR7_NO_REQ_PAYDEF(String r7_NO_REQ_PAYDEF) {
		R7_NO_REQ_PAYDEF = r7_NO_REQ_PAYDEF;
	}
	public String getR7_AVG_TME_REPAY() {
		return R7_AVG_TME_REPAY;
	}
	public void setR7_AVG_TME_REPAY(String r7_AVG_TME_REPAY) {
		R7_AVG_TME_REPAY = r7_AVG_TME_REPAY;
	}
	public String getR7_NO_INST_BAL() {
		return R7_NO_INST_BAL;
	}
	public void setR7_NO_INST_BAL(String r7_NO_INST_BAL) {
		R7_NO_INST_BAL = r7_NO_INST_BAL;
	}
	public String getR7_NET_FEE_AED() {
		return R7_NET_FEE_AED;
	}
	public void setR7_NET_FEE_AED(String r7_NET_FEE_AED) {
		R7_NET_FEE_AED = r7_NET_FEE_AED;
	}
	public String getR7_NET_PROF_AED() {
		return R7_NET_PROF_AED;
	}
	public void setR7_NET_PROF_AED(String r7_NET_PROF_AED) {
		R7_NET_PROF_AED = r7_NET_PROF_AED;
	}
	public String getR7_TOT_NO_ACC_SPD() {
		return R7_TOT_NO_ACC_SPD;
	}
	public void setR7_TOT_NO_ACC_SPD(String r7_TOT_NO_ACC_SPD) {
		R7_TOT_NO_ACC_SPD = r7_TOT_NO_ACC_SPD;
	}
	public String getR7_TOT_ACCS_DOR() {
		return R7_TOT_ACCS_DOR;
	}
	public void setR7_TOT_ACCS_DOR(String r7_TOT_ACCS_DOR) {
		R7_TOT_ACCS_DOR = r7_TOT_ACCS_DOR;
	}
	public String getR7_TOT_NEW_LOAN() {
		return R7_TOT_NEW_LOAN;
	}
	public void setR7_TOT_NEW_LOAN(String r7_TOT_NEW_LOAN) {
		R7_TOT_NEW_LOAN = r7_TOT_NEW_LOAN;
	}
	public String getR7_TOT_VAL_NEWACCS_AED() {
		return R7_TOT_VAL_NEWACCS_AED;
	}
	public void setR7_TOT_VAL_NEWACCS_AED(String r7_TOT_VAL_NEWACCS_AED) {
		R7_TOT_VAL_NEWACCS_AED = r7_TOT_VAL_NEWACCS_AED;
	}
	public String getR7_TOT_NO_LOAN_SPD() {
		return R7_TOT_NO_LOAN_SPD;
	}
	public void setR7_TOT_NO_LOAN_SPD(String r7_TOT_NO_LOAN_SPD) {
		R7_TOT_NO_LOAN_SPD = r7_TOT_NO_LOAN_SPD;
	}
	public String getR7_TOT_REQ_OTBNK() {
		return R7_TOT_REQ_OTBNK;
	}
	public void setR7_TOT_REQ_OTBNK(String r7_TOT_REQ_OTBNK) {
		R7_TOT_REQ_OTBNK = r7_TOT_REQ_OTBNK;
	}
	public String getR7_TOT_LOAN_OTBNK() {
		return R7_TOT_LOAN_OTBNK;
	}
	public void setR7_TOT_LOAN_OTBNK(String r7_TOT_LOAN_OTBNK) {
		R7_TOT_LOAN_OTBNK = r7_TOT_LOAN_OTBNK;
	}
	public String getR7_NO_CRACC_MIN() {
		return R7_NO_CRACC_MIN;
	}
	public void setR7_NO_CRACC_MIN(String r7_NO_CRACC_MIN) {
		R7_NO_CRACC_MIN = r7_NO_CRACC_MIN;
	}
	public String getR7_AVG_TME_CLSACC() {
		return R7_AVG_TME_CLSACC;
	}
	public void setR7_AVG_TME_CLSACC(String r7_AVG_TME_CLSACC) {
		R7_AVG_TME_CLSACC = r7_AVG_TME_CLSACC;
	}
	public String getR7_N0_CON_MORE1_LOAN() {
		return R7_N0_CON_MORE1_LOAN;
	}
	public void setR7_N0_CON_MORE1_LOAN(String r7_N0_CON_MORE1_LOAN) {
		R7_N0_CON_MORE1_LOAN = r7_N0_CON_MORE1_LOAN;
	}
	public String getR7_NO_INST_WITH90() {
		return R7_NO_INST_WITH90;
	}
	public void setR7_NO_INST_WITH90(String r7_NO_INST_WITH90) {
		R7_NO_INST_WITH90 = r7_NO_INST_WITH90;
	}
	public String getR7_TOT_GROSS_ASET() {
		return R7_TOT_GROSS_ASET;
	}
	public void setR7_TOT_GROSS_ASET(String r7_TOT_GROSS_ASET) {
		R7_TOT_GROSS_ASET = r7_TOT_GROSS_ASET;
	}
	public String getR7_RET_LIAB_AED() {
		return R7_RET_LIAB_AED;
	}
	public void setR7_RET_LIAB_AED(String r7_RET_LIAB_AED) {
		R7_RET_LIAB_AED = r7_RET_LIAB_AED;
	}
	public String getR7_HIG_PER_PROD_CAT() {
		return R7_HIG_PER_PROD_CAT;
	}
	public void setR7_HIG_PER_PROD_CAT(String r7_HIG_PER_PROD_CAT) {
		R7_HIG_PER_PROD_CAT = r7_HIG_PER_PROD_CAT;
	}
	public String getR7_NO_ACCS_TAG_NPA() {
		return R7_NO_ACCS_TAG_NPA;
	}
	public void setR7_NO_ACCS_TAG_NPA(String r7_NO_ACCS_TAG_NPA) {
		R7_NO_ACCS_TAG_NPA = r7_NO_ACCS_TAG_NPA;
	}
	public String getR7_NO_CHG_FEE_GRT5() {
		return R7_NO_CHG_FEE_GRT5;
	}
	public void setR7_NO_CHG_FEE_GRT5(String r7_NO_CHG_FEE_GRT5) {
		R7_NO_CHG_FEE_GRT5 = r7_NO_CHG_FEE_GRT5;
	}
	public String getR7_NO_CON_FLEX_INT() {
		return R7_NO_CON_FLEX_INT;
	}
	public void setR7_NO_CON_FLEX_INT(String r7_NO_CON_FLEX_INT) {
		R7_NO_CON_FLEX_INT = r7_NO_CON_FLEX_INT;
	}
	public String getR7_NO_CON_FIXED_INT() {
		return R7_NO_CON_FIXED_INT;
	}
	public void setR7_NO_CON_FIXED_INT(String r7_NO_CON_FIXED_INT) {
		R7_NO_CON_FIXED_INT = r7_NO_CON_FIXED_INT;
	}
	public String getR7_NO_LOAN_MAY_2011() {
		return R7_NO_LOAN_MAY_2011;
	}
	public void setR7_NO_LOAN_MAY_2011(String r7_NO_LOAN_MAY_2011) {
		R7_NO_LOAN_MAY_2011 = r7_NO_LOAN_MAY_2011;
	}
	public String getR7_VAL_LEGA_MAY_AED() {
		return R7_VAL_LEGA_MAY_AED;
	}
	public void setR7_VAL_LEGA_MAY_AED(String r7_VAL_LEGA_MAY_AED) {
		R7_VAL_LEGA_MAY_AED = r7_VAL_LEGA_MAY_AED;
	}
	public String getR7_AVG_DAY_NLL() {
		return R7_AVG_DAY_NLL;
	}
	public void setR7_AVG_DAY_NLL(String r7_AVG_DAY_NLL) {
		R7_AVG_DAY_NLL = r7_AVG_DAY_NLL;
	}
	public String getR7_PER_DOR_ACCS() {
		return R7_PER_DOR_ACCS;
	}
	public void setR7_PER_DOR_ACCS(String r7_PER_DOR_ACCS) {
		R7_PER_DOR_ACCS = r7_PER_DOR_ACCS;
	}
	public String getR7_INT_RET_PROF() {
		return R7_INT_RET_PROF;
	}
	public void setR7_INT_RET_PROF(String r7_INT_RET_PROF) {
		R7_INT_RET_PROF = r7_INT_RET_PROF;
	}
	public String getR7_FEE_COMM_PROF() {
		return R7_FEE_COMM_PROF;
	}
	public void setR7_FEE_COMM_PROF(String r7_FEE_COMM_PROF) {
		R7_FEE_COMM_PROF = r7_FEE_COMM_PROF;
	}
	public String getR7_TOT_UNCLM_90() {
		return R7_TOT_UNCLM_90;
	}
	public void setR7_TOT_UNCLM_90(String r7_TOT_UNCLM_90) {
		R7_TOT_UNCLM_90 = r7_TOT_UNCLM_90;
	}
	public String getR7_TOT_VAL_UNBAL() {
		return R7_TOT_VAL_UNBAL;
	}
	public void setR7_TOT_VAL_UNBAL(String r7_TOT_VAL_UNBAL) {
		R7_TOT_VAL_UNBAL = r7_TOT_VAL_UNBAL;
	}
	public String getR7_NO_INST_CONTRACT() {
		return R7_NO_INST_CONTRACT;
	}
	public void setR7_NO_INST_CONTRACT(String r7_NO_INST_CONTRACT) {
		R7_NO_INST_CONTRACT = r7_NO_INST_CONTRACT;
	}
	public String getR7_TOT_DORACC_NOTICE() {
		return R7_TOT_DORACC_NOTICE;
	}
	public void setR7_TOT_DORACC_NOTICE(String r7_TOT_DORACC_NOTICE) {
		R7_TOT_DORACC_NOTICE = r7_TOT_DORACC_NOTICE;
	}
	public String getR7_NO_CONS_LIAB_7DAY() {
		return R7_NO_CONS_LIAB_7DAY;
	}
	public void setR7_NO_CONS_LIAB_7DAY(String r7_NO_CONS_LIAB_7DAY) {
		R7_NO_CONS_LIAB_7DAY = r7_NO_CONS_LIAB_7DAY;
	}
	public String getR7_TOT_REQ_LIAB_NONLIA() {
		return R7_TOT_REQ_LIAB_NONLIA;
	}
	public void setR7_TOT_REQ_LIAB_NONLIA(String r7_TOT_REQ_LIAB_NONLIA) {
		R7_TOT_REQ_LIAB_NONLIA = r7_TOT_REQ_LIAB_NONLIA;
	}
	public String getR7_NO_RESTU_ONBO() {
		return R7_NO_RESTU_ONBO;
	}
	public void setR7_NO_RESTU_ONBO(String r7_NO_RESTU_ONBO) {
		R7_NO_RESTU_ONBO = r7_NO_RESTU_ONBO;
	}
	public String getR7_TOT_DELAY_TAT() {
		return R7_TOT_DELAY_TAT;
	}
	public void setR7_TOT_DELAY_TAT(String r7_TOT_DELAY_TAT) {
		R7_TOT_DELAY_TAT = r7_TOT_DELAY_TAT;
	}
	public String getR7_TOT_FND_TRAN() {
		return R7_TOT_FND_TRAN;
	}
	public void setR7_TOT_FND_TRAN(String r7_TOT_FND_TRAN) {
		R7_TOT_FND_TRAN = r7_TOT_FND_TRAN;
	}
	public String getR7_NO_FUND_RET24() {
		return R7_NO_FUND_RET24;
	}
	public void setR7_NO_FUND_RET24(String r7_NO_FUND_RET24) {
		R7_NO_FUND_RET24 = r7_NO_FUND_RET24;
	}
	public String getR7_NO_FAIL_TRAN() {
		return R7_NO_FAIL_TRAN;
	}
	public void setR7_NO_FAIL_TRAN(String r7_NO_FAIL_TRAN) {
		R7_NO_FAIL_TRAN = r7_NO_FAIL_TRAN;
	}
	public String getR7_CUS_FND_SVF_SPT() {
		return R7_CUS_FND_SVF_SPT;
	}
	public void setR7_CUS_FND_SVF_SPT(String r7_CUS_FND_SVF_SPT) {
		R7_CUS_FND_SVF_SPT = r7_CUS_FND_SVF_SPT;
	}
	public String getR7_CUS_FND_SVF_PRE() {
		return R7_CUS_FND_SVF_PRE;
	}
	public void setR7_CUS_FND_SVF_PRE(String r7_CUS_FND_SVF_PRE) {
		R7_CUS_FND_SVF_PRE = r7_CUS_FND_SVF_PRE;
	}
	public String getR7_TOT_CRDR_UND_SPT() {
		return R7_TOT_CRDR_UND_SPT;
	}
	public void setR7_TOT_CRDR_UND_SPT(String r7_TOT_CRDR_UND_SPT) {
		R7_TOT_CRDR_UND_SPT = r7_TOT_CRDR_UND_SPT;
	}
	public String getR7_TOT_CRD_ISU_SPT() {
		return R7_TOT_CRD_ISU_SPT;
	}
	public void setR7_TOT_CRD_ISU_SPT(String r7_TOT_CRD_ISU_SPT) {
		R7_TOT_CRD_ISU_SPT = r7_TOT_CRD_ISU_SPT;
	}
	public String getR7_NO_ACC_BLK_FIN() {
		return R7_NO_ACC_BLK_FIN;
	}
	public void setR7_NO_ACC_BLK_FIN(String r7_NO_ACC_BLK_FIN) {
		R7_NO_ACC_BLK_FIN = r7_NO_ACC_BLK_FIN;
	}
	public String getR7_NO_INQ_AVL_BAL() {
		return R7_NO_INQ_AVL_BAL;
	}
	public void setR7_NO_INQ_AVL_BAL(String r7_NO_INQ_AVL_BAL) {
		R7_NO_INQ_AVL_BAL = r7_NO_INQ_AVL_BAL;
	}
	public String getR7_TOT_PRE_EXP_SPT() {
		return R7_TOT_PRE_EXP_SPT;
	}
	public void setR7_TOT_PRE_EXP_SPT(String r7_TOT_PRE_EXP_SPT) {
		R7_TOT_PRE_EXP_SPT = r7_TOT_PRE_EXP_SPT;
	}
	public String getR7_TOT_PRE_POS_EXP() {
		return R7_TOT_PRE_POS_EXP;
	}
	public void setR7_TOT_PRE_POS_EXP(String r7_TOT_PRE_POS_EXP) {
		R7_TOT_PRE_POS_EXP = r7_TOT_PRE_POS_EXP;
	}
	public String getR7_TOT_PRE_CARD_SPD() {
		return R7_TOT_PRE_CARD_SPD;
	}
	public void setR7_TOT_PRE_CARD_SPD(String r7_TOT_PRE_CARD_SPD) {
		R7_TOT_PRE_CARD_SPD = r7_TOT_PRE_CARD_SPD;
	}
	public String getR7_TOT_ACCS_SPD() {
		return R7_TOT_ACCS_SPD;
	}
	public void setR7_TOT_ACCS_SPD(String r7_TOT_ACCS_SPD) {
		R7_TOT_ACCS_SPD = r7_TOT_ACCS_SPD;
	}
	public String getR7_NO_LANG_VOICE() {
		return R7_NO_LANG_VOICE;
	}
	public void setR7_NO_LANG_VOICE(String r7_NO_LANG_VOICE) {
		R7_NO_LANG_VOICE = r7_NO_LANG_VOICE;
	}
	public String getR7_AVG_NOD_LOWRSK() {
		return R7_AVG_NOD_LOWRSK;
	}
	public void setR7_AVG_NOD_LOWRSK(String r7_AVG_NOD_LOWRSK) {
		R7_AVG_NOD_LOWRSK = r7_AVG_NOD_LOWRSK;
	}
	public String getR7_NO_CUST_REISS_LIA() {
		return R7_NO_CUST_REISS_LIA;
	}
	public void setR7_NO_CUST_REISS_LIA(String r7_NO_CUST_REISS_LIA) {
		R7_NO_CUST_REISS_LIA = r7_NO_CUST_REISS_LIA;
	}
	public String getR7_NO_INS_CRRATE_CON() {
		return R7_NO_INS_CRRATE_CON;
	}
	public void setR7_NO_INS_CRRATE_CON(String r7_NO_INS_CRRATE_CON) {
		R7_NO_INS_CRRATE_CON = r7_NO_INS_CRRATE_CON;
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
	public String getR8_AVG_TME_LWRSK() {
		return R8_AVG_TME_LWRSK;
	}
	public void setR8_AVG_TME_LWRSK(String r8_AVG_TME_LWRSK) {
		R8_AVG_TME_LWRSK = r8_AVG_TME_LWRSK;
	}
	public String getR8_AVG_NO_LOAN() {
		return R8_AVG_NO_LOAN;
	}
	public void setR8_AVG_NO_LOAN(String r8_AVG_NO_LOAN) {
		R8_AVG_NO_LOAN = r8_AVG_NO_LOAN;
	}
	public String getR8_AVG_NO_LWRSK_SME() {
		return R8_AVG_NO_LWRSK_SME;
	}
	public void setR8_AVG_NO_LWRSK_SME(String r8_AVG_NO_LWRSK_SME) {
		R8_AVG_NO_LWRSK_SME = r8_AVG_NO_LWRSK_SME;
	}
	public String getR8_AVG_NO_DYS_SME() {
		return R8_AVG_NO_DYS_SME;
	}
	public void setR8_AVG_NO_DYS_SME(String r8_AVG_NO_DYS_SME) {
		R8_AVG_NO_DYS_SME = r8_AVG_NO_DYS_SME;
	}
	public String getR8_NO_REQ_CLO() {
		return R8_NO_REQ_CLO;
	}
	public void setR8_NO_REQ_CLO(String r8_NO_REQ_CLO) {
		R8_NO_REQ_CLO = r8_NO_REQ_CLO;
	}
	public String getR8_NO_PRD_VAR_SPC_TP() {
		return R8_NO_PRD_VAR_SPC_TP;
	}
	public void setR8_NO_PRD_VAR_SPC_TP(String r8_NO_PRD_VAR_SPC_TP) {
		R8_NO_PRD_VAR_SPC_TP = r8_NO_PRD_VAR_SPC_TP;
	}
	public String getR8_NO_REQ_RES_SPT() {
		return R8_NO_REQ_RES_SPT;
	}
	public void setR8_NO_REQ_RES_SPT(String r8_NO_REQ_RES_SPT) {
		R8_NO_REQ_RES_SPT = r8_NO_REQ_RES_SPT;
	}
	public String getR8_NO_REQ_PAYDEF() {
		return R8_NO_REQ_PAYDEF;
	}
	public void setR8_NO_REQ_PAYDEF(String r8_NO_REQ_PAYDEF) {
		R8_NO_REQ_PAYDEF = r8_NO_REQ_PAYDEF;
	}
	public String getR8_AVG_TME_REPAY() {
		return R8_AVG_TME_REPAY;
	}
	public void setR8_AVG_TME_REPAY(String r8_AVG_TME_REPAY) {
		R8_AVG_TME_REPAY = r8_AVG_TME_REPAY;
	}
	public String getR8_NO_INST_BAL() {
		return R8_NO_INST_BAL;
	}
	public void setR8_NO_INST_BAL(String r8_NO_INST_BAL) {
		R8_NO_INST_BAL = r8_NO_INST_BAL;
	}
	public String getR8_NET_FEE_AED() {
		return R8_NET_FEE_AED;
	}
	public void setR8_NET_FEE_AED(String r8_NET_FEE_AED) {
		R8_NET_FEE_AED = r8_NET_FEE_AED;
	}
	public String getR8_NET_PROF_AED() {
		return R8_NET_PROF_AED;
	}
	public void setR8_NET_PROF_AED(String r8_NET_PROF_AED) {
		R8_NET_PROF_AED = r8_NET_PROF_AED;
	}
	public String getR8_TOT_NO_ACC_SPD() {
		return R8_TOT_NO_ACC_SPD;
	}
	public void setR8_TOT_NO_ACC_SPD(String r8_TOT_NO_ACC_SPD) {
		R8_TOT_NO_ACC_SPD = r8_TOT_NO_ACC_SPD;
	}
	public String getR8_TOT_ACCS_DOR() {
		return R8_TOT_ACCS_DOR;
	}
	public void setR8_TOT_ACCS_DOR(String r8_TOT_ACCS_DOR) {
		R8_TOT_ACCS_DOR = r8_TOT_ACCS_DOR;
	}
	public String getR8_TOT_NEW_LOAN() {
		return R8_TOT_NEW_LOAN;
	}
	public void setR8_TOT_NEW_LOAN(String r8_TOT_NEW_LOAN) {
		R8_TOT_NEW_LOAN = r8_TOT_NEW_LOAN;
	}
	public String getR8_TOT_VAL_NEWACCS_AED() {
		return R8_TOT_VAL_NEWACCS_AED;
	}
	public void setR8_TOT_VAL_NEWACCS_AED(String r8_TOT_VAL_NEWACCS_AED) {
		R8_TOT_VAL_NEWACCS_AED = r8_TOT_VAL_NEWACCS_AED;
	}
	public String getR8_TOT_NO_LOAN_SPD() {
		return R8_TOT_NO_LOAN_SPD;
	}
	public void setR8_TOT_NO_LOAN_SPD(String r8_TOT_NO_LOAN_SPD) {
		R8_TOT_NO_LOAN_SPD = r8_TOT_NO_LOAN_SPD;
	}
	public String getR8_TOT_REQ_OTBNK() {
		return R8_TOT_REQ_OTBNK;
	}
	public void setR8_TOT_REQ_OTBNK(String r8_TOT_REQ_OTBNK) {
		R8_TOT_REQ_OTBNK = r8_TOT_REQ_OTBNK;
	}
	public String getR8_TOT_LOAN_OTBNK() {
		return R8_TOT_LOAN_OTBNK;
	}
	public void setR8_TOT_LOAN_OTBNK(String r8_TOT_LOAN_OTBNK) {
		R8_TOT_LOAN_OTBNK = r8_TOT_LOAN_OTBNK;
	}
	public String getR8_NO_CRACC_MIN() {
		return R8_NO_CRACC_MIN;
	}
	public void setR8_NO_CRACC_MIN(String r8_NO_CRACC_MIN) {
		R8_NO_CRACC_MIN = r8_NO_CRACC_MIN;
	}
	public String getR8_AVG_TME_CLSACC() {
		return R8_AVG_TME_CLSACC;
	}
	public void setR8_AVG_TME_CLSACC(String r8_AVG_TME_CLSACC) {
		R8_AVG_TME_CLSACC = r8_AVG_TME_CLSACC;
	}
	public String getR8_N0_CON_MORE1_LOAN() {
		return R8_N0_CON_MORE1_LOAN;
	}
	public void setR8_N0_CON_MORE1_LOAN(String r8_N0_CON_MORE1_LOAN) {
		R8_N0_CON_MORE1_LOAN = r8_N0_CON_MORE1_LOAN;
	}
	public String getR8_NO_INST_WITH90() {
		return R8_NO_INST_WITH90;
	}
	public void setR8_NO_INST_WITH90(String r8_NO_INST_WITH90) {
		R8_NO_INST_WITH90 = r8_NO_INST_WITH90;
	}
	public String getR8_TOT_GROSS_ASET() {
		return R8_TOT_GROSS_ASET;
	}
	public void setR8_TOT_GROSS_ASET(String r8_TOT_GROSS_ASET) {
		R8_TOT_GROSS_ASET = r8_TOT_GROSS_ASET;
	}
	public String getR8_RET_LIAB_AED() {
		return R8_RET_LIAB_AED;
	}
	public void setR8_RET_LIAB_AED(String r8_RET_LIAB_AED) {
		R8_RET_LIAB_AED = r8_RET_LIAB_AED;
	}
	public String getR8_HIG_PER_PROD_CAT() {
		return R8_HIG_PER_PROD_CAT;
	}
	public void setR8_HIG_PER_PROD_CAT(String r8_HIG_PER_PROD_CAT) {
		R8_HIG_PER_PROD_CAT = r8_HIG_PER_PROD_CAT;
	}
	public String getR8_NO_ACCS_TAG_NPA() {
		return R8_NO_ACCS_TAG_NPA;
	}
	public void setR8_NO_ACCS_TAG_NPA(String r8_NO_ACCS_TAG_NPA) {
		R8_NO_ACCS_TAG_NPA = r8_NO_ACCS_TAG_NPA;
	}
	public String getR8_NO_CHG_FEE_GRT5() {
		return R8_NO_CHG_FEE_GRT5;
	}
	public void setR8_NO_CHG_FEE_GRT5(String r8_NO_CHG_FEE_GRT5) {
		R8_NO_CHG_FEE_GRT5 = r8_NO_CHG_FEE_GRT5;
	}
	public String getR8_NO_CON_FLEX_INT() {
		return R8_NO_CON_FLEX_INT;
	}
	public void setR8_NO_CON_FLEX_INT(String r8_NO_CON_FLEX_INT) {
		R8_NO_CON_FLEX_INT = r8_NO_CON_FLEX_INT;
	}
	public String getR8_NO_CON_FIXED_INT() {
		return R8_NO_CON_FIXED_INT;
	}
	public void setR8_NO_CON_FIXED_INT(String r8_NO_CON_FIXED_INT) {
		R8_NO_CON_FIXED_INT = r8_NO_CON_FIXED_INT;
	}
	public String getR8_NO_LOAN_MAY_2011() {
		return R8_NO_LOAN_MAY_2011;
	}
	public void setR8_NO_LOAN_MAY_2011(String r8_NO_LOAN_MAY_2011) {
		R8_NO_LOAN_MAY_2011 = r8_NO_LOAN_MAY_2011;
	}
	public String getR8_VAL_LEGA_MAY_AED() {
		return R8_VAL_LEGA_MAY_AED;
	}
	public void setR8_VAL_LEGA_MAY_AED(String r8_VAL_LEGA_MAY_AED) {
		R8_VAL_LEGA_MAY_AED = r8_VAL_LEGA_MAY_AED;
	}
	public String getR8_AVG_DAY_NLL() {
		return R8_AVG_DAY_NLL;
	}
	public void setR8_AVG_DAY_NLL(String r8_AVG_DAY_NLL) {
		R8_AVG_DAY_NLL = r8_AVG_DAY_NLL;
	}
	public String getR8_PER_DOR_ACCS() {
		return R8_PER_DOR_ACCS;
	}
	public void setR8_PER_DOR_ACCS(String r8_PER_DOR_ACCS) {
		R8_PER_DOR_ACCS = r8_PER_DOR_ACCS;
	}
	public String getR8_INT_RET_PROF() {
		return R8_INT_RET_PROF;
	}
	public void setR8_INT_RET_PROF(String r8_INT_RET_PROF) {
		R8_INT_RET_PROF = r8_INT_RET_PROF;
	}
	public String getR8_FEE_COMM_PROF() {
		return R8_FEE_COMM_PROF;
	}
	public void setR8_FEE_COMM_PROF(String r8_FEE_COMM_PROF) {
		R8_FEE_COMM_PROF = r8_FEE_COMM_PROF;
	}
	public String getR8_TOT_UNCLM_90() {
		return R8_TOT_UNCLM_90;
	}
	public void setR8_TOT_UNCLM_90(String r8_TOT_UNCLM_90) {
		R8_TOT_UNCLM_90 = r8_TOT_UNCLM_90;
	}
	public String getR8_TOT_VAL_UNBAL() {
		return R8_TOT_VAL_UNBAL;
	}
	public void setR8_TOT_VAL_UNBAL(String r8_TOT_VAL_UNBAL) {
		R8_TOT_VAL_UNBAL = r8_TOT_VAL_UNBAL;
	}
	public String getR8_NO_INST_CONTRACT() {
		return R8_NO_INST_CONTRACT;
	}
	public void setR8_NO_INST_CONTRACT(String r8_NO_INST_CONTRACT) {
		R8_NO_INST_CONTRACT = r8_NO_INST_CONTRACT;
	}
	public String getR8_TOT_DORACC_NOTICE() {
		return R8_TOT_DORACC_NOTICE;
	}
	public void setR8_TOT_DORACC_NOTICE(String r8_TOT_DORACC_NOTICE) {
		R8_TOT_DORACC_NOTICE = r8_TOT_DORACC_NOTICE;
	}
	public String getR8_NO_CONS_LIAB_7DAY() {
		return R8_NO_CONS_LIAB_7DAY;
	}
	public void setR8_NO_CONS_LIAB_7DAY(String r8_NO_CONS_LIAB_7DAY) {
		R8_NO_CONS_LIAB_7DAY = r8_NO_CONS_LIAB_7DAY;
	}
	public String getR8_TOT_REQ_LIAB_NONLIA() {
		return R8_TOT_REQ_LIAB_NONLIA;
	}
	public void setR8_TOT_REQ_LIAB_NONLIA(String r8_TOT_REQ_LIAB_NONLIA) {
		R8_TOT_REQ_LIAB_NONLIA = r8_TOT_REQ_LIAB_NONLIA;
	}
	public String getR8_NO_RESTU_ONBO() {
		return R8_NO_RESTU_ONBO;
	}
	public void setR8_NO_RESTU_ONBO(String r8_NO_RESTU_ONBO) {
		R8_NO_RESTU_ONBO = r8_NO_RESTU_ONBO;
	}
	public String getR8_TOT_DELAY_TAT() {
		return R8_TOT_DELAY_TAT;
	}
	public void setR8_TOT_DELAY_TAT(String r8_TOT_DELAY_TAT) {
		R8_TOT_DELAY_TAT = r8_TOT_DELAY_TAT;
	}
	public String getR8_TOT_FND_TRAN() {
		return R8_TOT_FND_TRAN;
	}
	public void setR8_TOT_FND_TRAN(String r8_TOT_FND_TRAN) {
		R8_TOT_FND_TRAN = r8_TOT_FND_TRAN;
	}
	public String getR8_NO_FUND_RET24() {
		return R8_NO_FUND_RET24;
	}
	public void setR8_NO_FUND_RET24(String r8_NO_FUND_RET24) {
		R8_NO_FUND_RET24 = r8_NO_FUND_RET24;
	}
	public String getR8_NO_FAIL_TRAN() {
		return R8_NO_FAIL_TRAN;
	}
	public void setR8_NO_FAIL_TRAN(String r8_NO_FAIL_TRAN) {
		R8_NO_FAIL_TRAN = r8_NO_FAIL_TRAN;
	}
	public String getR8_CUS_FND_SVF_SPT() {
		return R8_CUS_FND_SVF_SPT;
	}
	public void setR8_CUS_FND_SVF_SPT(String r8_CUS_FND_SVF_SPT) {
		R8_CUS_FND_SVF_SPT = r8_CUS_FND_SVF_SPT;
	}
	public String getR8_CUS_FND_SVF_PRE() {
		return R8_CUS_FND_SVF_PRE;
	}
	public void setR8_CUS_FND_SVF_PRE(String r8_CUS_FND_SVF_PRE) {
		R8_CUS_FND_SVF_PRE = r8_CUS_FND_SVF_PRE;
	}
	public String getR8_TOT_CRDR_UND_SPT() {
		return R8_TOT_CRDR_UND_SPT;
	}
	public void setR8_TOT_CRDR_UND_SPT(String r8_TOT_CRDR_UND_SPT) {
		R8_TOT_CRDR_UND_SPT = r8_TOT_CRDR_UND_SPT;
	}
	public String getR8_TOT_CRD_ISU_SPT() {
		return R8_TOT_CRD_ISU_SPT;
	}
	public void setR8_TOT_CRD_ISU_SPT(String r8_TOT_CRD_ISU_SPT) {
		R8_TOT_CRD_ISU_SPT = r8_TOT_CRD_ISU_SPT;
	}
	public String getR8_NO_ACC_BLK_FIN() {
		return R8_NO_ACC_BLK_FIN;
	}
	public void setR8_NO_ACC_BLK_FIN(String r8_NO_ACC_BLK_FIN) {
		R8_NO_ACC_BLK_FIN = r8_NO_ACC_BLK_FIN;
	}
	public String getR8_NO_INQ_AVL_BAL() {
		return R8_NO_INQ_AVL_BAL;
	}
	public void setR8_NO_INQ_AVL_BAL(String r8_NO_INQ_AVL_BAL) {
		R8_NO_INQ_AVL_BAL = r8_NO_INQ_AVL_BAL;
	}
	public String getR8_TOT_PRE_EXP_SPT() {
		return R8_TOT_PRE_EXP_SPT;
	}
	public void setR8_TOT_PRE_EXP_SPT(String r8_TOT_PRE_EXP_SPT) {
		R8_TOT_PRE_EXP_SPT = r8_TOT_PRE_EXP_SPT;
	}
	public String getR8_TOT_PRE_POS_EXP() {
		return R8_TOT_PRE_POS_EXP;
	}
	public void setR8_TOT_PRE_POS_EXP(String r8_TOT_PRE_POS_EXP) {
		R8_TOT_PRE_POS_EXP = r8_TOT_PRE_POS_EXP;
	}
	public String getR8_TOT_PRE_CARD_SPD() {
		return R8_TOT_PRE_CARD_SPD;
	}
	public void setR8_TOT_PRE_CARD_SPD(String r8_TOT_PRE_CARD_SPD) {
		R8_TOT_PRE_CARD_SPD = r8_TOT_PRE_CARD_SPD;
	}
	public String getR8_TOT_ACCS_SPD() {
		return R8_TOT_ACCS_SPD;
	}
	public void setR8_TOT_ACCS_SPD(String r8_TOT_ACCS_SPD) {
		R8_TOT_ACCS_SPD = r8_TOT_ACCS_SPD;
	}
	public String getR8_NO_LANG_VOICE() {
		return R8_NO_LANG_VOICE;
	}
	public void setR8_NO_LANG_VOICE(String r8_NO_LANG_VOICE) {
		R8_NO_LANG_VOICE = r8_NO_LANG_VOICE;
	}
	public String getR8_AVG_NOD_LOWRSK() {
		return R8_AVG_NOD_LOWRSK;
	}
	public void setR8_AVG_NOD_LOWRSK(String r8_AVG_NOD_LOWRSK) {
		R8_AVG_NOD_LOWRSK = r8_AVG_NOD_LOWRSK;
	}
	public String getR8_NO_CUST_REISS_LIA() {
		return R8_NO_CUST_REISS_LIA;
	}
	public void setR8_NO_CUST_REISS_LIA(String r8_NO_CUST_REISS_LIA) {
		R8_NO_CUST_REISS_LIA = r8_NO_CUST_REISS_LIA;
	}
	public String getR8_NO_INS_CRRATE_CON() {
		return R8_NO_INS_CRRATE_CON;
	}
	public void setR8_NO_INS_CRRATE_CON(String r8_NO_INS_CRRATE_CON) {
		R8_NO_INS_CRRATE_CON = r8_NO_INS_CRRATE_CON;
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
	public String getR9_AVG_TME_LWRSK() {
		return R9_AVG_TME_LWRSK;
	}
	public void setR9_AVG_TME_LWRSK(String r9_AVG_TME_LWRSK) {
		R9_AVG_TME_LWRSK = r9_AVG_TME_LWRSK;
	}
	public String getR9_AVG_NO_LOAN() {
		return R9_AVG_NO_LOAN;
	}
	public void setR9_AVG_NO_LOAN(String r9_AVG_NO_LOAN) {
		R9_AVG_NO_LOAN = r9_AVG_NO_LOAN;
	}
	public String getR9_AVG_NO_LWRSK_SME() {
		return R9_AVG_NO_LWRSK_SME;
	}
	public void setR9_AVG_NO_LWRSK_SME(String r9_AVG_NO_LWRSK_SME) {
		R9_AVG_NO_LWRSK_SME = r9_AVG_NO_LWRSK_SME;
	}
	public String getR9_AVG_NO_DYS_SME() {
		return R9_AVG_NO_DYS_SME;
	}
	public void setR9_AVG_NO_DYS_SME(String r9_AVG_NO_DYS_SME) {
		R9_AVG_NO_DYS_SME = r9_AVG_NO_DYS_SME;
	}
	public String getR9_NO_REQ_CLO() {
		return R9_NO_REQ_CLO;
	}
	public void setR9_NO_REQ_CLO(String r9_NO_REQ_CLO) {
		R9_NO_REQ_CLO = r9_NO_REQ_CLO;
	}
	public String getR9_NO_PRD_VAR_SPC_TP() {
		return R9_NO_PRD_VAR_SPC_TP;
	}
	public void setR9_NO_PRD_VAR_SPC_TP(String r9_NO_PRD_VAR_SPC_TP) {
		R9_NO_PRD_VAR_SPC_TP = r9_NO_PRD_VAR_SPC_TP;
	}
	public String getR9_NO_REQ_RES_SPT() {
		return R9_NO_REQ_RES_SPT;
	}
	public void setR9_NO_REQ_RES_SPT(String r9_NO_REQ_RES_SPT) {
		R9_NO_REQ_RES_SPT = r9_NO_REQ_RES_SPT;
	}
	public String getR9_NO_REQ_PAYDEF() {
		return R9_NO_REQ_PAYDEF;
	}
	public void setR9_NO_REQ_PAYDEF(String r9_NO_REQ_PAYDEF) {
		R9_NO_REQ_PAYDEF = r9_NO_REQ_PAYDEF;
	}
	public String getR9_AVG_TME_REPAY() {
		return R9_AVG_TME_REPAY;
	}
	public void setR9_AVG_TME_REPAY(String r9_AVG_TME_REPAY) {
		R9_AVG_TME_REPAY = r9_AVG_TME_REPAY;
	}
	public String getR9_NO_INST_BAL() {
		return R9_NO_INST_BAL;
	}
	public void setR9_NO_INST_BAL(String r9_NO_INST_BAL) {
		R9_NO_INST_BAL = r9_NO_INST_BAL;
	}
	public String getR9_NET_FEE_AED() {
		return R9_NET_FEE_AED;
	}
	public void setR9_NET_FEE_AED(String r9_NET_FEE_AED) {
		R9_NET_FEE_AED = r9_NET_FEE_AED;
	}
	public String getR9_NET_PROF_AED() {
		return R9_NET_PROF_AED;
	}
	public void setR9_NET_PROF_AED(String r9_NET_PROF_AED) {
		R9_NET_PROF_AED = r9_NET_PROF_AED;
	}
	public String getR9_TOT_NO_ACC_SPD() {
		return R9_TOT_NO_ACC_SPD;
	}
	public void setR9_TOT_NO_ACC_SPD(String r9_TOT_NO_ACC_SPD) {
		R9_TOT_NO_ACC_SPD = r9_TOT_NO_ACC_SPD;
	}
	public String getR9_TOT_ACCS_DOR() {
		return R9_TOT_ACCS_DOR;
	}
	public void setR9_TOT_ACCS_DOR(String r9_TOT_ACCS_DOR) {
		R9_TOT_ACCS_DOR = r9_TOT_ACCS_DOR;
	}
	public String getR9_TOT_NEW_LOAN() {
		return R9_TOT_NEW_LOAN;
	}
	public void setR9_TOT_NEW_LOAN(String r9_TOT_NEW_LOAN) {
		R9_TOT_NEW_LOAN = r9_TOT_NEW_LOAN;
	}
	public String getR9_TOT_VAL_NEWACCS_AED() {
		return R9_TOT_VAL_NEWACCS_AED;
	}
	public void setR9_TOT_VAL_NEWACCS_AED(String r9_TOT_VAL_NEWACCS_AED) {
		R9_TOT_VAL_NEWACCS_AED = r9_TOT_VAL_NEWACCS_AED;
	}
	public String getR9_TOT_NO_LOAN_SPD() {
		return R9_TOT_NO_LOAN_SPD;
	}
	public void setR9_TOT_NO_LOAN_SPD(String r9_TOT_NO_LOAN_SPD) {
		R9_TOT_NO_LOAN_SPD = r9_TOT_NO_LOAN_SPD;
	}
	public String getR9_TOT_REQ_OTBNK() {
		return R9_TOT_REQ_OTBNK;
	}
	public void setR9_TOT_REQ_OTBNK(String r9_TOT_REQ_OTBNK) {
		R9_TOT_REQ_OTBNK = r9_TOT_REQ_OTBNK;
	}
	public String getR9_TOT_LOAN_OTBNK() {
		return R9_TOT_LOAN_OTBNK;
	}
	public void setR9_TOT_LOAN_OTBNK(String r9_TOT_LOAN_OTBNK) {
		R9_TOT_LOAN_OTBNK = r9_TOT_LOAN_OTBNK;
	}
	public String getR9_NO_CRACC_MIN() {
		return R9_NO_CRACC_MIN;
	}
	public void setR9_NO_CRACC_MIN(String r9_NO_CRACC_MIN) {
		R9_NO_CRACC_MIN = r9_NO_CRACC_MIN;
	}
	public String getR9_AVG_TME_CLSACC() {
		return R9_AVG_TME_CLSACC;
	}
	public void setR9_AVG_TME_CLSACC(String r9_AVG_TME_CLSACC) {
		R9_AVG_TME_CLSACC = r9_AVG_TME_CLSACC;
	}
	public String getR9_N0_CON_MORE1_LOAN() {
		return R9_N0_CON_MORE1_LOAN;
	}
	public void setR9_N0_CON_MORE1_LOAN(String r9_N0_CON_MORE1_LOAN) {
		R9_N0_CON_MORE1_LOAN = r9_N0_CON_MORE1_LOAN;
	}
	public String getR9_NO_INST_WITH90() {
		return R9_NO_INST_WITH90;
	}
	public void setR9_NO_INST_WITH90(String r9_NO_INST_WITH90) {
		R9_NO_INST_WITH90 = r9_NO_INST_WITH90;
	}
	public String getR9_TOT_GROSS_ASET() {
		return R9_TOT_GROSS_ASET;
	}
	public void setR9_TOT_GROSS_ASET(String r9_TOT_GROSS_ASET) {
		R9_TOT_GROSS_ASET = r9_TOT_GROSS_ASET;
	}
	public String getR9_RET_LIAB_AED() {
		return R9_RET_LIAB_AED;
	}
	public void setR9_RET_LIAB_AED(String r9_RET_LIAB_AED) {
		R9_RET_LIAB_AED = r9_RET_LIAB_AED;
	}
	public String getR9_HIG_PER_PROD_CAT() {
		return R9_HIG_PER_PROD_CAT;
	}
	public void setR9_HIG_PER_PROD_CAT(String r9_HIG_PER_PROD_CAT) {
		R9_HIG_PER_PROD_CAT = r9_HIG_PER_PROD_CAT;
	}
	public String getR9_NO_ACCS_TAG_NPA() {
		return R9_NO_ACCS_TAG_NPA;
	}
	public void setR9_NO_ACCS_TAG_NPA(String r9_NO_ACCS_TAG_NPA) {
		R9_NO_ACCS_TAG_NPA = r9_NO_ACCS_TAG_NPA;
	}
	public String getR9_NO_CHG_FEE_GRT5() {
		return R9_NO_CHG_FEE_GRT5;
	}
	public void setR9_NO_CHG_FEE_GRT5(String r9_NO_CHG_FEE_GRT5) {
		R9_NO_CHG_FEE_GRT5 = r9_NO_CHG_FEE_GRT5;
	}
	public String getR9_NO_CON_FLEX_INT() {
		return R9_NO_CON_FLEX_INT;
	}
	public void setR9_NO_CON_FLEX_INT(String r9_NO_CON_FLEX_INT) {
		R9_NO_CON_FLEX_INT = r9_NO_CON_FLEX_INT;
	}
	public String getR9_NO_CON_FIXED_INT() {
		return R9_NO_CON_FIXED_INT;
	}
	public void setR9_NO_CON_FIXED_INT(String r9_NO_CON_FIXED_INT) {
		R9_NO_CON_FIXED_INT = r9_NO_CON_FIXED_INT;
	}
	public String getR9_NO_LOAN_MAY_2011() {
		return R9_NO_LOAN_MAY_2011;
	}
	public void setR9_NO_LOAN_MAY_2011(String r9_NO_LOAN_MAY_2011) {
		R9_NO_LOAN_MAY_2011 = r9_NO_LOAN_MAY_2011;
	}
	public String getR9_VAL_LEGA_MAY_AED() {
		return R9_VAL_LEGA_MAY_AED;
	}
	public void setR9_VAL_LEGA_MAY_AED(String r9_VAL_LEGA_MAY_AED) {
		R9_VAL_LEGA_MAY_AED = r9_VAL_LEGA_MAY_AED;
	}
	public String getR9_AVG_DAY_NLL() {
		return R9_AVG_DAY_NLL;
	}
	public void setR9_AVG_DAY_NLL(String r9_AVG_DAY_NLL) {
		R9_AVG_DAY_NLL = r9_AVG_DAY_NLL;
	}
	public String getR9_PER_DOR_ACCS() {
		return R9_PER_DOR_ACCS;
	}
	public void setR9_PER_DOR_ACCS(String r9_PER_DOR_ACCS) {
		R9_PER_DOR_ACCS = r9_PER_DOR_ACCS;
	}
	public String getR9_INT_RET_PROF() {
		return R9_INT_RET_PROF;
	}
	public void setR9_INT_RET_PROF(String r9_INT_RET_PROF) {
		R9_INT_RET_PROF = r9_INT_RET_PROF;
	}
	public String getR9_FEE_COMM_PROF() {
		return R9_FEE_COMM_PROF;
	}
	public void setR9_FEE_COMM_PROF(String r9_FEE_COMM_PROF) {
		R9_FEE_COMM_PROF = r9_FEE_COMM_PROF;
	}
	public String getR9_TOT_UNCLM_90() {
		return R9_TOT_UNCLM_90;
	}
	public void setR9_TOT_UNCLM_90(String r9_TOT_UNCLM_90) {
		R9_TOT_UNCLM_90 = r9_TOT_UNCLM_90;
	}
	public String getR9_TOT_VAL_UNBAL() {
		return R9_TOT_VAL_UNBAL;
	}
	public void setR9_TOT_VAL_UNBAL(String r9_TOT_VAL_UNBAL) {
		R9_TOT_VAL_UNBAL = r9_TOT_VAL_UNBAL;
	}
	public String getR9_NO_INST_CONTRACT() {
		return R9_NO_INST_CONTRACT;
	}
	public void setR9_NO_INST_CONTRACT(String r9_NO_INST_CONTRACT) {
		R9_NO_INST_CONTRACT = r9_NO_INST_CONTRACT;
	}
	public String getR9_TOT_DORACC_NOTICE() {
		return R9_TOT_DORACC_NOTICE;
	}
	public void setR9_TOT_DORACC_NOTICE(String r9_TOT_DORACC_NOTICE) {
		R9_TOT_DORACC_NOTICE = r9_TOT_DORACC_NOTICE;
	}
	public String getR9_NO_CONS_LIAB_7DAY() {
		return R9_NO_CONS_LIAB_7DAY;
	}
	public void setR9_NO_CONS_LIAB_7DAY(String r9_NO_CONS_LIAB_7DAY) {
		R9_NO_CONS_LIAB_7DAY = r9_NO_CONS_LIAB_7DAY;
	}
	public String getR9_TOT_REQ_LIAB_NONLIA() {
		return R9_TOT_REQ_LIAB_NONLIA;
	}
	public void setR9_TOT_REQ_LIAB_NONLIA(String r9_TOT_REQ_LIAB_NONLIA) {
		R9_TOT_REQ_LIAB_NONLIA = r9_TOT_REQ_LIAB_NONLIA;
	}
	public String getR9_NO_RESTU_ONBO() {
		return R9_NO_RESTU_ONBO;
	}
	public void setR9_NO_RESTU_ONBO(String r9_NO_RESTU_ONBO) {
		R9_NO_RESTU_ONBO = r9_NO_RESTU_ONBO;
	}
	public String getR9_TOT_DELAY_TAT() {
		return R9_TOT_DELAY_TAT;
	}
	public void setR9_TOT_DELAY_TAT(String r9_TOT_DELAY_TAT) {
		R9_TOT_DELAY_TAT = r9_TOT_DELAY_TAT;
	}
	public String getR9_TOT_FND_TRAN() {
		return R9_TOT_FND_TRAN;
	}
	public void setR9_TOT_FND_TRAN(String r9_TOT_FND_TRAN) {
		R9_TOT_FND_TRAN = r9_TOT_FND_TRAN;
	}
	public String getR9_NO_FUND_RET24() {
		return R9_NO_FUND_RET24;
	}
	public void setR9_NO_FUND_RET24(String r9_NO_FUND_RET24) {
		R9_NO_FUND_RET24 = r9_NO_FUND_RET24;
	}
	public String getR9_NO_FAIL_TRAN() {
		return R9_NO_FAIL_TRAN;
	}
	public void setR9_NO_FAIL_TRAN(String r9_NO_FAIL_TRAN) {
		R9_NO_FAIL_TRAN = r9_NO_FAIL_TRAN;
	}
	public String getR9_CUS_FND_SVF_SPT() {
		return R9_CUS_FND_SVF_SPT;
	}
	public void setR9_CUS_FND_SVF_SPT(String r9_CUS_FND_SVF_SPT) {
		R9_CUS_FND_SVF_SPT = r9_CUS_FND_SVF_SPT;
	}
	public String getR9_CUS_FND_SVF_PRE() {
		return R9_CUS_FND_SVF_PRE;
	}
	public void setR9_CUS_FND_SVF_PRE(String r9_CUS_FND_SVF_PRE) {
		R9_CUS_FND_SVF_PRE = r9_CUS_FND_SVF_PRE;
	}
	public String getR9_TOT_CRDR_UND_SPT() {
		return R9_TOT_CRDR_UND_SPT;
	}
	public void setR9_TOT_CRDR_UND_SPT(String r9_TOT_CRDR_UND_SPT) {
		R9_TOT_CRDR_UND_SPT = r9_TOT_CRDR_UND_SPT;
	}
	public String getR9_TOT_CRD_ISU_SPT() {
		return R9_TOT_CRD_ISU_SPT;
	}
	public void setR9_TOT_CRD_ISU_SPT(String r9_TOT_CRD_ISU_SPT) {
		R9_TOT_CRD_ISU_SPT = r9_TOT_CRD_ISU_SPT;
	}
	public String getR9_NO_ACC_BLK_FIN() {
		return R9_NO_ACC_BLK_FIN;
	}
	public void setR9_NO_ACC_BLK_FIN(String r9_NO_ACC_BLK_FIN) {
		R9_NO_ACC_BLK_FIN = r9_NO_ACC_BLK_FIN;
	}
	public String getR9_NO_INQ_AVL_BAL() {
		return R9_NO_INQ_AVL_BAL;
	}
	public void setR9_NO_INQ_AVL_BAL(String r9_NO_INQ_AVL_BAL) {
		R9_NO_INQ_AVL_BAL = r9_NO_INQ_AVL_BAL;
	}
	public String getR9_TOT_PRE_EXP_SPT() {
		return R9_TOT_PRE_EXP_SPT;
	}
	public void setR9_TOT_PRE_EXP_SPT(String r9_TOT_PRE_EXP_SPT) {
		R9_TOT_PRE_EXP_SPT = r9_TOT_PRE_EXP_SPT;
	}
	public String getR9_TOT_PRE_POS_EXP() {
		return R9_TOT_PRE_POS_EXP;
	}
	public void setR9_TOT_PRE_POS_EXP(String r9_TOT_PRE_POS_EXP) {
		R9_TOT_PRE_POS_EXP = r9_TOT_PRE_POS_EXP;
	}
	public String getR9_TOT_PRE_CARD_SPD() {
		return R9_TOT_PRE_CARD_SPD;
	}
	public void setR9_TOT_PRE_CARD_SPD(String r9_TOT_PRE_CARD_SPD) {
		R9_TOT_PRE_CARD_SPD = r9_TOT_PRE_CARD_SPD;
	}
	public String getR9_TOT_ACCS_SPD() {
		return R9_TOT_ACCS_SPD;
	}
	public void setR9_TOT_ACCS_SPD(String r9_TOT_ACCS_SPD) {
		R9_TOT_ACCS_SPD = r9_TOT_ACCS_SPD;
	}
	public String getR9_NO_LANG_VOICE() {
		return R9_NO_LANG_VOICE;
	}
	public void setR9_NO_LANG_VOICE(String r9_NO_LANG_VOICE) {
		R9_NO_LANG_VOICE = r9_NO_LANG_VOICE;
	}
	public String getR9_AVG_NOD_LOWRSK() {
		return R9_AVG_NOD_LOWRSK;
	}
	public void setR9_AVG_NOD_LOWRSK(String r9_AVG_NOD_LOWRSK) {
		R9_AVG_NOD_LOWRSK = r9_AVG_NOD_LOWRSK;
	}
	public String getR9_NO_CUST_REISS_LIA() {
		return R9_NO_CUST_REISS_LIA;
	}
	public void setR9_NO_CUST_REISS_LIA(String r9_NO_CUST_REISS_LIA) {
		R9_NO_CUST_REISS_LIA = r9_NO_CUST_REISS_LIA;
	}
	public String getR9_NO_INS_CRRATE_CON() {
		return R9_NO_INS_CRRATE_CON;
	}
	public void setR9_NO_INS_CRRATE_CON(String r9_NO_INS_CRRATE_CON) {
		R9_NO_INS_CRRATE_CON = r9_NO_INS_CRRATE_CON;
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
	public String getR10_AVG_TME_LWRSK() {
		return R10_AVG_TME_LWRSK;
	}
	public void setR10_AVG_TME_LWRSK(String r10_AVG_TME_LWRSK) {
		R10_AVG_TME_LWRSK = r10_AVG_TME_LWRSK;
	}
	public String getR10_AVG_NO_LOAN() {
		return R10_AVG_NO_LOAN;
	}
	public void setR10_AVG_NO_LOAN(String r10_AVG_NO_LOAN) {
		R10_AVG_NO_LOAN = r10_AVG_NO_LOAN;
	}
	public String getR10_AVG_NO_LWRSK_SME() {
		return R10_AVG_NO_LWRSK_SME;
	}
	public void setR10_AVG_NO_LWRSK_SME(String r10_AVG_NO_LWRSK_SME) {
		R10_AVG_NO_LWRSK_SME = r10_AVG_NO_LWRSK_SME;
	}
	public String getR10_AVG_NO_DYS_SME() {
		return R10_AVG_NO_DYS_SME;
	}
	public void setR10_AVG_NO_DYS_SME(String r10_AVG_NO_DYS_SME) {
		R10_AVG_NO_DYS_SME = r10_AVG_NO_DYS_SME;
	}
	public String getR10_NO_REQ_CLO() {
		return R10_NO_REQ_CLO;
	}
	public void setR10_NO_REQ_CLO(String r10_NO_REQ_CLO) {
		R10_NO_REQ_CLO = r10_NO_REQ_CLO;
	}
	public String getR10_NO_PRD_VAR_SPC_TP() {
		return R10_NO_PRD_VAR_SPC_TP;
	}
	public void setR10_NO_PRD_VAR_SPC_TP(String r10_NO_PRD_VAR_SPC_TP) {
		R10_NO_PRD_VAR_SPC_TP = r10_NO_PRD_VAR_SPC_TP;
	}
	public String getR10_NO_REQ_RES_SPT() {
		return R10_NO_REQ_RES_SPT;
	}
	public void setR10_NO_REQ_RES_SPT(String r10_NO_REQ_RES_SPT) {
		R10_NO_REQ_RES_SPT = r10_NO_REQ_RES_SPT;
	}
	public String getR10_NO_REQ_PAYDEF() {
		return R10_NO_REQ_PAYDEF;
	}
	public void setR10_NO_REQ_PAYDEF(String r10_NO_REQ_PAYDEF) {
		R10_NO_REQ_PAYDEF = r10_NO_REQ_PAYDEF;
	}
	public String getR10_AVG_TME_REPAY() {
		return R10_AVG_TME_REPAY;
	}
	public void setR10_AVG_TME_REPAY(String r10_AVG_TME_REPAY) {
		R10_AVG_TME_REPAY = r10_AVG_TME_REPAY;
	}
	public String getR10_NO_INST_BAL() {
		return R10_NO_INST_BAL;
	}
	public void setR10_NO_INST_BAL(String r10_NO_INST_BAL) {
		R10_NO_INST_BAL = r10_NO_INST_BAL;
	}
	public String getR10_NET_FEE_AED() {
		return R10_NET_FEE_AED;
	}
	public void setR10_NET_FEE_AED(String r10_NET_FEE_AED) {
		R10_NET_FEE_AED = r10_NET_FEE_AED;
	}
	public String getR10_NET_PROF_AED() {
		return R10_NET_PROF_AED;
	}
	public void setR10_NET_PROF_AED(String r10_NET_PROF_AED) {
		R10_NET_PROF_AED = r10_NET_PROF_AED;
	}
	public String getR10_TOT_NO_ACC_SPD() {
		return R10_TOT_NO_ACC_SPD;
	}
	public void setR10_TOT_NO_ACC_SPD(String r10_TOT_NO_ACC_SPD) {
		R10_TOT_NO_ACC_SPD = r10_TOT_NO_ACC_SPD;
	}
	public String getR10_TOT_ACCS_DOR() {
		return R10_TOT_ACCS_DOR;
	}
	public void setR10_TOT_ACCS_DOR(String r10_TOT_ACCS_DOR) {
		R10_TOT_ACCS_DOR = r10_TOT_ACCS_DOR;
	}
	public String getR10_TOT_NEW_LOAN() {
		return R10_TOT_NEW_LOAN;
	}
	public void setR10_TOT_NEW_LOAN(String r10_TOT_NEW_LOAN) {
		R10_TOT_NEW_LOAN = r10_TOT_NEW_LOAN;
	}
	public String getR10_TOT_VAL_NEWACCS_AED() {
		return R10_TOT_VAL_NEWACCS_AED;
	}
	public void setR10_TOT_VAL_NEWACCS_AED(String r10_TOT_VAL_NEWACCS_AED) {
		R10_TOT_VAL_NEWACCS_AED = r10_TOT_VAL_NEWACCS_AED;
	}
	public String getR10_TOT_NO_LOAN_SPD() {
		return R10_TOT_NO_LOAN_SPD;
	}
	public void setR10_TOT_NO_LOAN_SPD(String r10_TOT_NO_LOAN_SPD) {
		R10_TOT_NO_LOAN_SPD = r10_TOT_NO_LOAN_SPD;
	}
	public String getR10_TOT_REQ_OTBNK() {
		return R10_TOT_REQ_OTBNK;
	}
	public void setR10_TOT_REQ_OTBNK(String r10_TOT_REQ_OTBNK) {
		R10_TOT_REQ_OTBNK = r10_TOT_REQ_OTBNK;
	}
	public String getR10_TOT_LOAN_OTBNK() {
		return R10_TOT_LOAN_OTBNK;
	}
	public void setR10_TOT_LOAN_OTBNK(String r10_TOT_LOAN_OTBNK) {
		R10_TOT_LOAN_OTBNK = r10_TOT_LOAN_OTBNK;
	}
	public String getR10_NO_CRACC_MIN() {
		return R10_NO_CRACC_MIN;
	}
	public void setR10_NO_CRACC_MIN(String r10_NO_CRACC_MIN) {
		R10_NO_CRACC_MIN = r10_NO_CRACC_MIN;
	}
	public String getR10_AVG_TME_CLSACC() {
		return R10_AVG_TME_CLSACC;
	}
	public void setR10_AVG_TME_CLSACC(String r10_AVG_TME_CLSACC) {
		R10_AVG_TME_CLSACC = r10_AVG_TME_CLSACC;
	}
	public String getR10_N0_CON_MORE1_LOAN() {
		return R10_N0_CON_MORE1_LOAN;
	}
	public void setR10_N0_CON_MORE1_LOAN(String r10_N0_CON_MORE1_LOAN) {
		R10_N0_CON_MORE1_LOAN = r10_N0_CON_MORE1_LOAN;
	}
	public String getR10_NO_INST_WITH90() {
		return R10_NO_INST_WITH90;
	}
	public void setR10_NO_INST_WITH90(String r10_NO_INST_WITH90) {
		R10_NO_INST_WITH90 = r10_NO_INST_WITH90;
	}
	public String getR10_TOT_GROSS_ASET() {
		return R10_TOT_GROSS_ASET;
	}
	public void setR10_TOT_GROSS_ASET(String r10_TOT_GROSS_ASET) {
		R10_TOT_GROSS_ASET = r10_TOT_GROSS_ASET;
	}
	public String getR10_RET_LIAB_AED() {
		return R10_RET_LIAB_AED;
	}
	public void setR10_RET_LIAB_AED(String r10_RET_LIAB_AED) {
		R10_RET_LIAB_AED = r10_RET_LIAB_AED;
	}
	public String getR10_HIG_PER_PROD_CAT() {
		return R10_HIG_PER_PROD_CAT;
	}
	public void setR10_HIG_PER_PROD_CAT(String r10_HIG_PER_PROD_CAT) {
		R10_HIG_PER_PROD_CAT = r10_HIG_PER_PROD_CAT;
	}
	public String getR10_NO_ACCS_TAG_NPA() {
		return R10_NO_ACCS_TAG_NPA;
	}
	public void setR10_NO_ACCS_TAG_NPA(String r10_NO_ACCS_TAG_NPA) {
		R10_NO_ACCS_TAG_NPA = r10_NO_ACCS_TAG_NPA;
	}
	public String getR10_NO_CHG_FEE_GRT5() {
		return R10_NO_CHG_FEE_GRT5;
	}
	public void setR10_NO_CHG_FEE_GRT5(String r10_NO_CHG_FEE_GRT5) {
		R10_NO_CHG_FEE_GRT5 = r10_NO_CHG_FEE_GRT5;
	}
	public String getR10_NO_CON_FLEX_INT() {
		return R10_NO_CON_FLEX_INT;
	}
	public void setR10_NO_CON_FLEX_INT(String r10_NO_CON_FLEX_INT) {
		R10_NO_CON_FLEX_INT = r10_NO_CON_FLEX_INT;
	}
	public String getR10_NO_CON_FIXED_INT() {
		return R10_NO_CON_FIXED_INT;
	}
	public void setR10_NO_CON_FIXED_INT(String r10_NO_CON_FIXED_INT) {
		R10_NO_CON_FIXED_INT = r10_NO_CON_FIXED_INT;
	}
	public String getR10_NO_LOAN_MAY_2011() {
		return R10_NO_LOAN_MAY_2011;
	}
	public void setR10_NO_LOAN_MAY_2011(String r10_NO_LOAN_MAY_2011) {
		R10_NO_LOAN_MAY_2011 = r10_NO_LOAN_MAY_2011;
	}
	public String getR10_VAL_LEGA_MAY_AED() {
		return R10_VAL_LEGA_MAY_AED;
	}
	public void setR10_VAL_LEGA_MAY_AED(String r10_VAL_LEGA_MAY_AED) {
		R10_VAL_LEGA_MAY_AED = r10_VAL_LEGA_MAY_AED;
	}
	public String getR10_AVG_DAY_NLL() {
		return R10_AVG_DAY_NLL;
	}
	public void setR10_AVG_DAY_NLL(String r10_AVG_DAY_NLL) {
		R10_AVG_DAY_NLL = r10_AVG_DAY_NLL;
	}
	public String getR10_PER_DOR_ACCS() {
		return R10_PER_DOR_ACCS;
	}
	public void setR10_PER_DOR_ACCS(String r10_PER_DOR_ACCS) {
		R10_PER_DOR_ACCS = r10_PER_DOR_ACCS;
	}
	public String getR10_INT_RET_PROF() {
		return R10_INT_RET_PROF;
	}
	public void setR10_INT_RET_PROF(String r10_INT_RET_PROF) {
		R10_INT_RET_PROF = r10_INT_RET_PROF;
	}
	public String getR10_FEE_COMM_PROF() {
		return R10_FEE_COMM_PROF;
	}
	public void setR10_FEE_COMM_PROF(String r10_FEE_COMM_PROF) {
		R10_FEE_COMM_PROF = r10_FEE_COMM_PROF;
	}
	public String getR10_TOT_UNCLM_90() {
		return R10_TOT_UNCLM_90;
	}
	public void setR10_TOT_UNCLM_90(String r10_TOT_UNCLM_90) {
		R10_TOT_UNCLM_90 = r10_TOT_UNCLM_90;
	}
	public String getR10_TOT_VAL_UNBAL() {
		return R10_TOT_VAL_UNBAL;
	}
	public void setR10_TOT_VAL_UNBAL(String r10_TOT_VAL_UNBAL) {
		R10_TOT_VAL_UNBAL = r10_TOT_VAL_UNBAL;
	}
	public String getR10_NO_INST_CONTRACT() {
		return R10_NO_INST_CONTRACT;
	}
	public void setR10_NO_INST_CONTRACT(String r10_NO_INST_CONTRACT) {
		R10_NO_INST_CONTRACT = r10_NO_INST_CONTRACT;
	}
	public String getR10_TOT_DORACC_NOTICE() {
		return R10_TOT_DORACC_NOTICE;
	}
	public void setR10_TOT_DORACC_NOTICE(String r10_TOT_DORACC_NOTICE) {
		R10_TOT_DORACC_NOTICE = r10_TOT_DORACC_NOTICE;
	}
	public String getR10_NO_CONS_LIAB_7DAY() {
		return R10_NO_CONS_LIAB_7DAY;
	}
	public void setR10_NO_CONS_LIAB_7DAY(String r10_NO_CONS_LIAB_7DAY) {
		R10_NO_CONS_LIAB_7DAY = r10_NO_CONS_LIAB_7DAY;
	}
	public String getR10_TOT_REQ_LIAB_NONLIA() {
		return R10_TOT_REQ_LIAB_NONLIA;
	}
	public void setR10_TOT_REQ_LIAB_NONLIA(String r10_TOT_REQ_LIAB_NONLIA) {
		R10_TOT_REQ_LIAB_NONLIA = r10_TOT_REQ_LIAB_NONLIA;
	}
	public String getR10_NO_RESTU_ONBO() {
		return R10_NO_RESTU_ONBO;
	}
	public void setR10_NO_RESTU_ONBO(String r10_NO_RESTU_ONBO) {
		R10_NO_RESTU_ONBO = r10_NO_RESTU_ONBO;
	}
	public String getR10_TOT_DELAY_TAT() {
		return R10_TOT_DELAY_TAT;
	}
	public void setR10_TOT_DELAY_TAT(String r10_TOT_DELAY_TAT) {
		R10_TOT_DELAY_TAT = r10_TOT_DELAY_TAT;
	}
	public String getR10_TOT_FND_TRAN() {
		return R10_TOT_FND_TRAN;
	}
	public void setR10_TOT_FND_TRAN(String r10_TOT_FND_TRAN) {
		R10_TOT_FND_TRAN = r10_TOT_FND_TRAN;
	}
	public String getR10_NO_FUND_RET24() {
		return R10_NO_FUND_RET24;
	}
	public void setR10_NO_FUND_RET24(String r10_NO_FUND_RET24) {
		R10_NO_FUND_RET24 = r10_NO_FUND_RET24;
	}
	public String getR10_NO_FAIL_TRAN() {
		return R10_NO_FAIL_TRAN;
	}
	public void setR10_NO_FAIL_TRAN(String r10_NO_FAIL_TRAN) {
		R10_NO_FAIL_TRAN = r10_NO_FAIL_TRAN;
	}
	public String getR10_CUS_FND_SVF_SPT() {
		return R10_CUS_FND_SVF_SPT;
	}
	public void setR10_CUS_FND_SVF_SPT(String r10_CUS_FND_SVF_SPT) {
		R10_CUS_FND_SVF_SPT = r10_CUS_FND_SVF_SPT;
	}
	public String getR10_CUS_FND_SVF_PRE() {
		return R10_CUS_FND_SVF_PRE;
	}
	public void setR10_CUS_FND_SVF_PRE(String r10_CUS_FND_SVF_PRE) {
		R10_CUS_FND_SVF_PRE = r10_CUS_FND_SVF_PRE;
	}
	public String getR10_TOT_CRDR_UND_SPT() {
		return R10_TOT_CRDR_UND_SPT;
	}
	public void setR10_TOT_CRDR_UND_SPT(String r10_TOT_CRDR_UND_SPT) {
		R10_TOT_CRDR_UND_SPT = r10_TOT_CRDR_UND_SPT;
	}
	public String getR10_TOT_CRD_ISU_SPT() {
		return R10_TOT_CRD_ISU_SPT;
	}
	public void setR10_TOT_CRD_ISU_SPT(String r10_TOT_CRD_ISU_SPT) {
		R10_TOT_CRD_ISU_SPT = r10_TOT_CRD_ISU_SPT;
	}
	public String getR10_NO_ACC_BLK_FIN() {
		return R10_NO_ACC_BLK_FIN;
	}
	public void setR10_NO_ACC_BLK_FIN(String r10_NO_ACC_BLK_FIN) {
		R10_NO_ACC_BLK_FIN = r10_NO_ACC_BLK_FIN;
	}
	public String getR10_NO_INQ_AVL_BAL() {
		return R10_NO_INQ_AVL_BAL;
	}
	public void setR10_NO_INQ_AVL_BAL(String r10_NO_INQ_AVL_BAL) {
		R10_NO_INQ_AVL_BAL = r10_NO_INQ_AVL_BAL;
	}
	public String getR10_TOT_PRE_EXP_SPT() {
		return R10_TOT_PRE_EXP_SPT;
	}
	public void setR10_TOT_PRE_EXP_SPT(String r10_TOT_PRE_EXP_SPT) {
		R10_TOT_PRE_EXP_SPT = r10_TOT_PRE_EXP_SPT;
	}
	public String getR10_TOT_PRE_POS_EXP() {
		return R10_TOT_PRE_POS_EXP;
	}
	public void setR10_TOT_PRE_POS_EXP(String r10_TOT_PRE_POS_EXP) {
		R10_TOT_PRE_POS_EXP = r10_TOT_PRE_POS_EXP;
	}
	public String getR10_TOT_PRE_CARD_SPD() {
		return R10_TOT_PRE_CARD_SPD;
	}
	public void setR10_TOT_PRE_CARD_SPD(String r10_TOT_PRE_CARD_SPD) {
		R10_TOT_PRE_CARD_SPD = r10_TOT_PRE_CARD_SPD;
	}
	public String getR10_TOT_ACCS_SPD() {
		return R10_TOT_ACCS_SPD;
	}
	public void setR10_TOT_ACCS_SPD(String r10_TOT_ACCS_SPD) {
		R10_TOT_ACCS_SPD = r10_TOT_ACCS_SPD;
	}
	public String getR10_NO_LANG_VOICE() {
		return R10_NO_LANG_VOICE;
	}
	public void setR10_NO_LANG_VOICE(String r10_NO_LANG_VOICE) {
		R10_NO_LANG_VOICE = r10_NO_LANG_VOICE;
	}
	public String getR10_AVG_NOD_LOWRSK() {
		return R10_AVG_NOD_LOWRSK;
	}
	public void setR10_AVG_NOD_LOWRSK(String r10_AVG_NOD_LOWRSK) {
		R10_AVG_NOD_LOWRSK = r10_AVG_NOD_LOWRSK;
	}
	public String getR10_NO_CUST_REISS_LIA() {
		return R10_NO_CUST_REISS_LIA;
	}
	public void setR10_NO_CUST_REISS_LIA(String r10_NO_CUST_REISS_LIA) {
		R10_NO_CUST_REISS_LIA = r10_NO_CUST_REISS_LIA;
	}
	public String getR10_NO_INS_CRRATE_CON() {
		return R10_NO_INS_CRRATE_CON;
	}
	public void setR10_NO_INS_CRRATE_CON(String r10_NO_INS_CRRATE_CON) {
		R10_NO_INS_CRRATE_CON = r10_NO_INS_CRRATE_CON;
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
	public String getR11_AVG_TME_LWRSK() {
		return R11_AVG_TME_LWRSK;
	}
	public void setR11_AVG_TME_LWRSK(String r11_AVG_TME_LWRSK) {
		R11_AVG_TME_LWRSK = r11_AVG_TME_LWRSK;
	}
	public String getR11_AVG_NO_LOAN() {
		return R11_AVG_NO_LOAN;
	}
	public void setR11_AVG_NO_LOAN(String r11_AVG_NO_LOAN) {
		R11_AVG_NO_LOAN = r11_AVG_NO_LOAN;
	}
	public String getR11_AVG_NO_LWRSK_SME() {
		return R11_AVG_NO_LWRSK_SME;
	}
	public void setR11_AVG_NO_LWRSK_SME(String r11_AVG_NO_LWRSK_SME) {
		R11_AVG_NO_LWRSK_SME = r11_AVG_NO_LWRSK_SME;
	}
	public String getR11_AVG_NO_DYS_SME() {
		return R11_AVG_NO_DYS_SME;
	}
	public void setR11_AVG_NO_DYS_SME(String r11_AVG_NO_DYS_SME) {
		R11_AVG_NO_DYS_SME = r11_AVG_NO_DYS_SME;
	}
	public String getR11_NO_REQ_CLO() {
		return R11_NO_REQ_CLO;
	}
	public void setR11_NO_REQ_CLO(String r11_NO_REQ_CLO) {
		R11_NO_REQ_CLO = r11_NO_REQ_CLO;
	}
	public String getR11_NO_PRD_VAR_SPC_TP() {
		return R11_NO_PRD_VAR_SPC_TP;
	}
	public void setR11_NO_PRD_VAR_SPC_TP(String r11_NO_PRD_VAR_SPC_TP) {
		R11_NO_PRD_VAR_SPC_TP = r11_NO_PRD_VAR_SPC_TP;
	}
	public String getR11_NO_REQ_RES_SPT() {
		return R11_NO_REQ_RES_SPT;
	}
	public void setR11_NO_REQ_RES_SPT(String r11_NO_REQ_RES_SPT) {
		R11_NO_REQ_RES_SPT = r11_NO_REQ_RES_SPT;
	}
	public String getR11_NO_REQ_PAYDEF() {
		return R11_NO_REQ_PAYDEF;
	}
	public void setR11_NO_REQ_PAYDEF(String r11_NO_REQ_PAYDEF) {
		R11_NO_REQ_PAYDEF = r11_NO_REQ_PAYDEF;
	}
	public String getR11_AVG_TME_REPAY() {
		return R11_AVG_TME_REPAY;
	}
	public void setR11_AVG_TME_REPAY(String r11_AVG_TME_REPAY) {
		R11_AVG_TME_REPAY = r11_AVG_TME_REPAY;
	}
	public String getR11_NO_INST_BAL() {
		return R11_NO_INST_BAL;
	}
	public void setR11_NO_INST_BAL(String r11_NO_INST_BAL) {
		R11_NO_INST_BAL = r11_NO_INST_BAL;
	}
	public String getR11_NET_FEE_AED() {
		return R11_NET_FEE_AED;
	}
	public void setR11_NET_FEE_AED(String r11_NET_FEE_AED) {
		R11_NET_FEE_AED = r11_NET_FEE_AED;
	}
	public String getR11_NET_PROF_AED() {
		return R11_NET_PROF_AED;
	}
	public void setR11_NET_PROF_AED(String r11_NET_PROF_AED) {
		R11_NET_PROF_AED = r11_NET_PROF_AED;
	}
	public String getR11_TOT_NO_ACC_SPD() {
		return R11_TOT_NO_ACC_SPD;
	}
	public void setR11_TOT_NO_ACC_SPD(String r11_TOT_NO_ACC_SPD) {
		R11_TOT_NO_ACC_SPD = r11_TOT_NO_ACC_SPD;
	}
	public String getR11_TOT_ACCS_DOR() {
		return R11_TOT_ACCS_DOR;
	}
	public void setR11_TOT_ACCS_DOR(String r11_TOT_ACCS_DOR) {
		R11_TOT_ACCS_DOR = r11_TOT_ACCS_DOR;
	}
	public String getR11_TOT_NEW_LOAN() {
		return R11_TOT_NEW_LOAN;
	}
	public void setR11_TOT_NEW_LOAN(String r11_TOT_NEW_LOAN) {
		R11_TOT_NEW_LOAN = r11_TOT_NEW_LOAN;
	}
	public String getR11_TOT_VAL_NEWACCS_AED() {
		return R11_TOT_VAL_NEWACCS_AED;
	}
	public void setR11_TOT_VAL_NEWACCS_AED(String r11_TOT_VAL_NEWACCS_AED) {
		R11_TOT_VAL_NEWACCS_AED = r11_TOT_VAL_NEWACCS_AED;
	}
	public String getR11_TOT_NO_LOAN_SPD() {
		return R11_TOT_NO_LOAN_SPD;
	}
	public void setR11_TOT_NO_LOAN_SPD(String r11_TOT_NO_LOAN_SPD) {
		R11_TOT_NO_LOAN_SPD = r11_TOT_NO_LOAN_SPD;
	}
	public String getR11_TOT_REQ_OTBNK() {
		return R11_TOT_REQ_OTBNK;
	}
	public void setR11_TOT_REQ_OTBNK(String r11_TOT_REQ_OTBNK) {
		R11_TOT_REQ_OTBNK = r11_TOT_REQ_OTBNK;
	}
	public String getR11_TOT_LOAN_OTBNK() {
		return R11_TOT_LOAN_OTBNK;
	}
	public void setR11_TOT_LOAN_OTBNK(String r11_TOT_LOAN_OTBNK) {
		R11_TOT_LOAN_OTBNK = r11_TOT_LOAN_OTBNK;
	}
	public String getR11_NO_CRACC_MIN() {
		return R11_NO_CRACC_MIN;
	}
	public void setR11_NO_CRACC_MIN(String r11_NO_CRACC_MIN) {
		R11_NO_CRACC_MIN = r11_NO_CRACC_MIN;
	}
	public String getR11_AVG_TME_CLSACC() {
		return R11_AVG_TME_CLSACC;
	}
	public void setR11_AVG_TME_CLSACC(String r11_AVG_TME_CLSACC) {
		R11_AVG_TME_CLSACC = r11_AVG_TME_CLSACC;
	}
	public String getR11_N0_CON_MORE1_LOAN() {
		return R11_N0_CON_MORE1_LOAN;
	}
	public void setR11_N0_CON_MORE1_LOAN(String r11_N0_CON_MORE1_LOAN) {
		R11_N0_CON_MORE1_LOAN = r11_N0_CON_MORE1_LOAN;
	}
	public String getR11_NO_INST_WITH90() {
		return R11_NO_INST_WITH90;
	}
	public void setR11_NO_INST_WITH90(String r11_NO_INST_WITH90) {
		R11_NO_INST_WITH90 = r11_NO_INST_WITH90;
	}
	public String getR11_TOT_GROSS_ASET() {
		return R11_TOT_GROSS_ASET;
	}
	public void setR11_TOT_GROSS_ASET(String r11_TOT_GROSS_ASET) {
		R11_TOT_GROSS_ASET = r11_TOT_GROSS_ASET;
	}
	public String getR11_RET_LIAB_AED() {
		return R11_RET_LIAB_AED;
	}
	public void setR11_RET_LIAB_AED(String r11_RET_LIAB_AED) {
		R11_RET_LIAB_AED = r11_RET_LIAB_AED;
	}
	public String getR11_HIG_PER_PROD_CAT() {
		return R11_HIG_PER_PROD_CAT;
	}
	public void setR11_HIG_PER_PROD_CAT(String r11_HIG_PER_PROD_CAT) {
		R11_HIG_PER_PROD_CAT = r11_HIG_PER_PROD_CAT;
	}
	public String getR11_NO_ACCS_TAG_NPA() {
		return R11_NO_ACCS_TAG_NPA;
	}
	public void setR11_NO_ACCS_TAG_NPA(String r11_NO_ACCS_TAG_NPA) {
		R11_NO_ACCS_TAG_NPA = r11_NO_ACCS_TAG_NPA;
	}
	public String getR11_NO_CHG_FEE_GRT5() {
		return R11_NO_CHG_FEE_GRT5;
	}
	public void setR11_NO_CHG_FEE_GRT5(String r11_NO_CHG_FEE_GRT5) {
		R11_NO_CHG_FEE_GRT5 = r11_NO_CHG_FEE_GRT5;
	}
	public String getR11_NO_CON_FLEX_INT() {
		return R11_NO_CON_FLEX_INT;
	}
	public void setR11_NO_CON_FLEX_INT(String r11_NO_CON_FLEX_INT) {
		R11_NO_CON_FLEX_INT = r11_NO_CON_FLEX_INT;
	}
	public String getR11_NO_CON_FIXED_INT() {
		return R11_NO_CON_FIXED_INT;
	}
	public void setR11_NO_CON_FIXED_INT(String r11_NO_CON_FIXED_INT) {
		R11_NO_CON_FIXED_INT = r11_NO_CON_FIXED_INT;
	}
	public String getR11_NO_LOAN_MAY_2011() {
		return R11_NO_LOAN_MAY_2011;
	}
	public void setR11_NO_LOAN_MAY_2011(String r11_NO_LOAN_MAY_2011) {
		R11_NO_LOAN_MAY_2011 = r11_NO_LOAN_MAY_2011;
	}
	public String getR11_VAL_LEGA_MAY_AED() {
		return R11_VAL_LEGA_MAY_AED;
	}
	public void setR11_VAL_LEGA_MAY_AED(String r11_VAL_LEGA_MAY_AED) {
		R11_VAL_LEGA_MAY_AED = r11_VAL_LEGA_MAY_AED;
	}
	public String getR11_AVG_DAY_NLL() {
		return R11_AVG_DAY_NLL;
	}
	public void setR11_AVG_DAY_NLL(String r11_AVG_DAY_NLL) {
		R11_AVG_DAY_NLL = r11_AVG_DAY_NLL;
	}
	public String getR11_PER_DOR_ACCS() {
		return R11_PER_DOR_ACCS;
	}
	public void setR11_PER_DOR_ACCS(String r11_PER_DOR_ACCS) {
		R11_PER_DOR_ACCS = r11_PER_DOR_ACCS;
	}
	public String getR11_INT_RET_PROF() {
		return R11_INT_RET_PROF;
	}
	public void setR11_INT_RET_PROF(String r11_INT_RET_PROF) {
		R11_INT_RET_PROF = r11_INT_RET_PROF;
	}
	public String getR11_FEE_COMM_PROF() {
		return R11_FEE_COMM_PROF;
	}
	public void setR11_FEE_COMM_PROF(String r11_FEE_COMM_PROF) {
		R11_FEE_COMM_PROF = r11_FEE_COMM_PROF;
	}
	public String getR11_TOT_UNCLM_90() {
		return R11_TOT_UNCLM_90;
	}
	public void setR11_TOT_UNCLM_90(String r11_TOT_UNCLM_90) {
		R11_TOT_UNCLM_90 = r11_TOT_UNCLM_90;
	}
	public String getR11_TOT_VAL_UNBAL() {
		return R11_TOT_VAL_UNBAL;
	}
	public void setR11_TOT_VAL_UNBAL(String r11_TOT_VAL_UNBAL) {
		R11_TOT_VAL_UNBAL = r11_TOT_VAL_UNBAL;
	}
	public String getR11_NO_INST_CONTRACT() {
		return R11_NO_INST_CONTRACT;
	}
	public void setR11_NO_INST_CONTRACT(String r11_NO_INST_CONTRACT) {
		R11_NO_INST_CONTRACT = r11_NO_INST_CONTRACT;
	}
	public String getR11_TOT_DORACC_NOTICE() {
		return R11_TOT_DORACC_NOTICE;
	}
	public void setR11_TOT_DORACC_NOTICE(String r11_TOT_DORACC_NOTICE) {
		R11_TOT_DORACC_NOTICE = r11_TOT_DORACC_NOTICE;
	}
	public String getR11_NO_CONS_LIAB_7DAY() {
		return R11_NO_CONS_LIAB_7DAY;
	}
	public void setR11_NO_CONS_LIAB_7DAY(String r11_NO_CONS_LIAB_7DAY) {
		R11_NO_CONS_LIAB_7DAY = r11_NO_CONS_LIAB_7DAY;
	}
	public String getR11_TOT_REQ_LIAB_NONLIA() {
		return R11_TOT_REQ_LIAB_NONLIA;
	}
	public void setR11_TOT_REQ_LIAB_NONLIA(String r11_TOT_REQ_LIAB_NONLIA) {
		R11_TOT_REQ_LIAB_NONLIA = r11_TOT_REQ_LIAB_NONLIA;
	}
	public String getR11_NO_RESTU_ONBO() {
		return R11_NO_RESTU_ONBO;
	}
	public void setR11_NO_RESTU_ONBO(String r11_NO_RESTU_ONBO) {
		R11_NO_RESTU_ONBO = r11_NO_RESTU_ONBO;
	}
	public String getR11_TOT_DELAY_TAT() {
		return R11_TOT_DELAY_TAT;
	}
	public void setR11_TOT_DELAY_TAT(String r11_TOT_DELAY_TAT) {
		R11_TOT_DELAY_TAT = r11_TOT_DELAY_TAT;
	}
	public String getR11_TOT_FND_TRAN() {
		return R11_TOT_FND_TRAN;
	}
	public void setR11_TOT_FND_TRAN(String r11_TOT_FND_TRAN) {
		R11_TOT_FND_TRAN = r11_TOT_FND_TRAN;
	}
	public String getR11_NO_FUND_RET24() {
		return R11_NO_FUND_RET24;
	}
	public void setR11_NO_FUND_RET24(String r11_NO_FUND_RET24) {
		R11_NO_FUND_RET24 = r11_NO_FUND_RET24;
	}
	public String getR11_NO_FAIL_TRAN() {
		return R11_NO_FAIL_TRAN;
	}
	public void setR11_NO_FAIL_TRAN(String r11_NO_FAIL_TRAN) {
		R11_NO_FAIL_TRAN = r11_NO_FAIL_TRAN;
	}
	public String getR11_CUS_FND_SVF_SPT() {
		return R11_CUS_FND_SVF_SPT;
	}
	public void setR11_CUS_FND_SVF_SPT(String r11_CUS_FND_SVF_SPT) {
		R11_CUS_FND_SVF_SPT = r11_CUS_FND_SVF_SPT;
	}
	public String getR11_CUS_FND_SVF_PRE() {
		return R11_CUS_FND_SVF_PRE;
	}
	public void setR11_CUS_FND_SVF_PRE(String r11_CUS_FND_SVF_PRE) {
		R11_CUS_FND_SVF_PRE = r11_CUS_FND_SVF_PRE;
	}
	public String getR11_TOT_CRDR_UND_SPT() {
		return R11_TOT_CRDR_UND_SPT;
	}
	public void setR11_TOT_CRDR_UND_SPT(String r11_TOT_CRDR_UND_SPT) {
		R11_TOT_CRDR_UND_SPT = r11_TOT_CRDR_UND_SPT;
	}
	public String getR11_TOT_CRD_ISU_SPT() {
		return R11_TOT_CRD_ISU_SPT;
	}
	public void setR11_TOT_CRD_ISU_SPT(String r11_TOT_CRD_ISU_SPT) {
		R11_TOT_CRD_ISU_SPT = r11_TOT_CRD_ISU_SPT;
	}
	public String getR11_NO_ACC_BLK_FIN() {
		return R11_NO_ACC_BLK_FIN;
	}
	public void setR11_NO_ACC_BLK_FIN(String r11_NO_ACC_BLK_FIN) {
		R11_NO_ACC_BLK_FIN = r11_NO_ACC_BLK_FIN;
	}
	public String getR11_NO_INQ_AVL_BAL() {
		return R11_NO_INQ_AVL_BAL;
	}
	public void setR11_NO_INQ_AVL_BAL(String r11_NO_INQ_AVL_BAL) {
		R11_NO_INQ_AVL_BAL = r11_NO_INQ_AVL_BAL;
	}
	public String getR11_TOT_PRE_EXP_SPT() {
		return R11_TOT_PRE_EXP_SPT;
	}
	public void setR11_TOT_PRE_EXP_SPT(String r11_TOT_PRE_EXP_SPT) {
		R11_TOT_PRE_EXP_SPT = r11_TOT_PRE_EXP_SPT;
	}
	public String getR11_TOT_PRE_POS_EXP() {
		return R11_TOT_PRE_POS_EXP;
	}
	public void setR11_TOT_PRE_POS_EXP(String r11_TOT_PRE_POS_EXP) {
		R11_TOT_PRE_POS_EXP = r11_TOT_PRE_POS_EXP;
	}
	public String getR11_TOT_PRE_CARD_SPD() {
		return R11_TOT_PRE_CARD_SPD;
	}
	public void setR11_TOT_PRE_CARD_SPD(String r11_TOT_PRE_CARD_SPD) {
		R11_TOT_PRE_CARD_SPD = r11_TOT_PRE_CARD_SPD;
	}
	public String getR11_TOT_ACCS_SPD() {
		return R11_TOT_ACCS_SPD;
	}
	public void setR11_TOT_ACCS_SPD(String r11_TOT_ACCS_SPD) {
		R11_TOT_ACCS_SPD = r11_TOT_ACCS_SPD;
	}
	public String getR11_NO_LANG_VOICE() {
		return R11_NO_LANG_VOICE;
	}
	public void setR11_NO_LANG_VOICE(String r11_NO_LANG_VOICE) {
		R11_NO_LANG_VOICE = r11_NO_LANG_VOICE;
	}
	public String getR11_AVG_NOD_LOWRSK() {
		return R11_AVG_NOD_LOWRSK;
	}
	public void setR11_AVG_NOD_LOWRSK(String r11_AVG_NOD_LOWRSK) {
		R11_AVG_NOD_LOWRSK = r11_AVG_NOD_LOWRSK;
	}
	public String getR11_NO_CUST_REISS_LIA() {
		return R11_NO_CUST_REISS_LIA;
	}
	public void setR11_NO_CUST_REISS_LIA(String r11_NO_CUST_REISS_LIA) {
		R11_NO_CUST_REISS_LIA = r11_NO_CUST_REISS_LIA;
	}
	public String getR11_NO_INS_CRRATE_CON() {
		return R11_NO_INS_CRRATE_CON;
	}
	public void setR11_NO_INS_CRRATE_CON(String r11_NO_INS_CRRATE_CON) {
		R11_NO_INS_CRRATE_CON = r11_NO_INS_CRRATE_CON;
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
	public String getR12_AVG_TME_LWRSK() {
		return R12_AVG_TME_LWRSK;
	}
	public void setR12_AVG_TME_LWRSK(String r12_AVG_TME_LWRSK) {
		R12_AVG_TME_LWRSK = r12_AVG_TME_LWRSK;
	}
	public String getR12_AVG_NO_LOAN() {
		return R12_AVG_NO_LOAN;
	}
	public void setR12_AVG_NO_LOAN(String r12_AVG_NO_LOAN) {
		R12_AVG_NO_LOAN = r12_AVG_NO_LOAN;
	}
	public String getR12_AVG_NO_LWRSK_SME() {
		return R12_AVG_NO_LWRSK_SME;
	}
	public void setR12_AVG_NO_LWRSK_SME(String r12_AVG_NO_LWRSK_SME) {
		R12_AVG_NO_LWRSK_SME = r12_AVG_NO_LWRSK_SME;
	}
	public String getR12_AVG_NO_DYS_SME() {
		return R12_AVG_NO_DYS_SME;
	}
	public void setR12_AVG_NO_DYS_SME(String r12_AVG_NO_DYS_SME) {
		R12_AVG_NO_DYS_SME = r12_AVG_NO_DYS_SME;
	}
	public String getR12_NO_REQ_CLO() {
		return R12_NO_REQ_CLO;
	}
	public void setR12_NO_REQ_CLO(String r12_NO_REQ_CLO) {
		R12_NO_REQ_CLO = r12_NO_REQ_CLO;
	}
	public String getR12_NO_PRD_VAR_SPC_TP() {
		return R12_NO_PRD_VAR_SPC_TP;
	}
	public void setR12_NO_PRD_VAR_SPC_TP(String r12_NO_PRD_VAR_SPC_TP) {
		R12_NO_PRD_VAR_SPC_TP = r12_NO_PRD_VAR_SPC_TP;
	}
	public String getR12_NO_REQ_RES_SPT() {
		return R12_NO_REQ_RES_SPT;
	}
	public void setR12_NO_REQ_RES_SPT(String r12_NO_REQ_RES_SPT) {
		R12_NO_REQ_RES_SPT = r12_NO_REQ_RES_SPT;
	}
	public String getR12_NO_REQ_PAYDEF() {
		return R12_NO_REQ_PAYDEF;
	}
	public void setR12_NO_REQ_PAYDEF(String r12_NO_REQ_PAYDEF) {
		R12_NO_REQ_PAYDEF = r12_NO_REQ_PAYDEF;
	}
	public String getR12_AVG_TME_REPAY() {
		return R12_AVG_TME_REPAY;
	}
	public void setR12_AVG_TME_REPAY(String r12_AVG_TME_REPAY) {
		R12_AVG_TME_REPAY = r12_AVG_TME_REPAY;
	}
	public String getR12_NO_INST_BAL() {
		return R12_NO_INST_BAL;
	}
	public void setR12_NO_INST_BAL(String r12_NO_INST_BAL) {
		R12_NO_INST_BAL = r12_NO_INST_BAL;
	}
	public String getR12_NET_FEE_AED() {
		return R12_NET_FEE_AED;
	}
	public void setR12_NET_FEE_AED(String r12_NET_FEE_AED) {
		R12_NET_FEE_AED = r12_NET_FEE_AED;
	}
	public String getR12_NET_PROF_AED() {
		return R12_NET_PROF_AED;
	}
	public void setR12_NET_PROF_AED(String r12_NET_PROF_AED) {
		R12_NET_PROF_AED = r12_NET_PROF_AED;
	}
	public String getR12_TOT_NO_ACC_SPD() {
		return R12_TOT_NO_ACC_SPD;
	}
	public void setR12_TOT_NO_ACC_SPD(String r12_TOT_NO_ACC_SPD) {
		R12_TOT_NO_ACC_SPD = r12_TOT_NO_ACC_SPD;
	}
	public String getR12_TOT_ACCS_DOR() {
		return R12_TOT_ACCS_DOR;
	}
	public void setR12_TOT_ACCS_DOR(String r12_TOT_ACCS_DOR) {
		R12_TOT_ACCS_DOR = r12_TOT_ACCS_DOR;
	}
	public String getR12_TOT_NEW_LOAN() {
		return R12_TOT_NEW_LOAN;
	}
	public void setR12_TOT_NEW_LOAN(String r12_TOT_NEW_LOAN) {
		R12_TOT_NEW_LOAN = r12_TOT_NEW_LOAN;
	}
	public String getR12_TOT_VAL_NEWACCS_AED() {
		return R12_TOT_VAL_NEWACCS_AED;
	}
	public void setR12_TOT_VAL_NEWACCS_AED(String r12_TOT_VAL_NEWACCS_AED) {
		R12_TOT_VAL_NEWACCS_AED = r12_TOT_VAL_NEWACCS_AED;
	}
	public String getR12_TOT_NO_LOAN_SPD() {
		return R12_TOT_NO_LOAN_SPD;
	}
	public void setR12_TOT_NO_LOAN_SPD(String r12_TOT_NO_LOAN_SPD) {
		R12_TOT_NO_LOAN_SPD = r12_TOT_NO_LOAN_SPD;
	}
	public String getR12_TOT_REQ_OTBNK() {
		return R12_TOT_REQ_OTBNK;
	}
	public void setR12_TOT_REQ_OTBNK(String r12_TOT_REQ_OTBNK) {
		R12_TOT_REQ_OTBNK = r12_TOT_REQ_OTBNK;
	}
	public String getR12_TOT_LOAN_OTBNK() {
		return R12_TOT_LOAN_OTBNK;
	}
	public void setR12_TOT_LOAN_OTBNK(String r12_TOT_LOAN_OTBNK) {
		R12_TOT_LOAN_OTBNK = r12_TOT_LOAN_OTBNK;
	}
	public String getR12_NO_CRACC_MIN() {
		return R12_NO_CRACC_MIN;
	}
	public void setR12_NO_CRACC_MIN(String r12_NO_CRACC_MIN) {
		R12_NO_CRACC_MIN = r12_NO_CRACC_MIN;
	}
	public String getR12_AVG_TME_CLSACC() {
		return R12_AVG_TME_CLSACC;
	}
	public void setR12_AVG_TME_CLSACC(String r12_AVG_TME_CLSACC) {
		R12_AVG_TME_CLSACC = r12_AVG_TME_CLSACC;
	}
	public String getR12_N0_CON_MORE1_LOAN() {
		return R12_N0_CON_MORE1_LOAN;
	}
	public void setR12_N0_CON_MORE1_LOAN(String r12_N0_CON_MORE1_LOAN) {
		R12_N0_CON_MORE1_LOAN = r12_N0_CON_MORE1_LOAN;
	}
	public String getR12_NO_INST_WITH90() {
		return R12_NO_INST_WITH90;
	}
	public void setR12_NO_INST_WITH90(String r12_NO_INST_WITH90) {
		R12_NO_INST_WITH90 = r12_NO_INST_WITH90;
	}
	public String getR12_TOT_GROSS_ASET() {
		return R12_TOT_GROSS_ASET;
	}
	public void setR12_TOT_GROSS_ASET(String r12_TOT_GROSS_ASET) {
		R12_TOT_GROSS_ASET = r12_TOT_GROSS_ASET;
	}
	public String getR12_RET_LIAB_AED() {
		return R12_RET_LIAB_AED;
	}
	public void setR12_RET_LIAB_AED(String r12_RET_LIAB_AED) {
		R12_RET_LIAB_AED = r12_RET_LIAB_AED;
	}
	public String getR12_HIG_PER_PROD_CAT() {
		return R12_HIG_PER_PROD_CAT;
	}
	public void setR12_HIG_PER_PROD_CAT(String r12_HIG_PER_PROD_CAT) {
		R12_HIG_PER_PROD_CAT = r12_HIG_PER_PROD_CAT;
	}
	public String getR12_NO_ACCS_TAG_NPA() {
		return R12_NO_ACCS_TAG_NPA;
	}
	public void setR12_NO_ACCS_TAG_NPA(String r12_NO_ACCS_TAG_NPA) {
		R12_NO_ACCS_TAG_NPA = r12_NO_ACCS_TAG_NPA;
	}
	public String getR12_NO_CHG_FEE_GRT5() {
		return R12_NO_CHG_FEE_GRT5;
	}
	public void setR12_NO_CHG_FEE_GRT5(String r12_NO_CHG_FEE_GRT5) {
		R12_NO_CHG_FEE_GRT5 = r12_NO_CHG_FEE_GRT5;
	}
	public String getR12_NO_CON_FLEX_INT() {
		return R12_NO_CON_FLEX_INT;
	}
	public void setR12_NO_CON_FLEX_INT(String r12_NO_CON_FLEX_INT) {
		R12_NO_CON_FLEX_INT = r12_NO_CON_FLEX_INT;
	}
	public String getR12_NO_CON_FIXED_INT() {
		return R12_NO_CON_FIXED_INT;
	}
	public void setR12_NO_CON_FIXED_INT(String r12_NO_CON_FIXED_INT) {
		R12_NO_CON_FIXED_INT = r12_NO_CON_FIXED_INT;
	}
	public String getR12_NO_LOAN_MAY_2011() {
		return R12_NO_LOAN_MAY_2011;
	}
	public void setR12_NO_LOAN_MAY_2011(String r12_NO_LOAN_MAY_2011) {
		R12_NO_LOAN_MAY_2011 = r12_NO_LOAN_MAY_2011;
	}
	public String getR12_VAL_LEGA_MAY_AED() {
		return R12_VAL_LEGA_MAY_AED;
	}
	public void setR12_VAL_LEGA_MAY_AED(String r12_VAL_LEGA_MAY_AED) {
		R12_VAL_LEGA_MAY_AED = r12_VAL_LEGA_MAY_AED;
	}
	public String getR12_AVG_DAY_NLL() {
		return R12_AVG_DAY_NLL;
	}
	public void setR12_AVG_DAY_NLL(String r12_AVG_DAY_NLL) {
		R12_AVG_DAY_NLL = r12_AVG_DAY_NLL;
	}
	public String getR12_PER_DOR_ACCS() {
		return R12_PER_DOR_ACCS;
	}
	public void setR12_PER_DOR_ACCS(String r12_PER_DOR_ACCS) {
		R12_PER_DOR_ACCS = r12_PER_DOR_ACCS;
	}
	public String getR12_INT_RET_PROF() {
		return R12_INT_RET_PROF;
	}
	public void setR12_INT_RET_PROF(String r12_INT_RET_PROF) {
		R12_INT_RET_PROF = r12_INT_RET_PROF;
	}
	public String getR12_FEE_COMM_PROF() {
		return R12_FEE_COMM_PROF;
	}
	public void setR12_FEE_COMM_PROF(String r12_FEE_COMM_PROF) {
		R12_FEE_COMM_PROF = r12_FEE_COMM_PROF;
	}
	public String getR12_TOT_UNCLM_90() {
		return R12_TOT_UNCLM_90;
	}
	public void setR12_TOT_UNCLM_90(String r12_TOT_UNCLM_90) {
		R12_TOT_UNCLM_90 = r12_TOT_UNCLM_90;
	}
	public String getR12_TOT_VAL_UNBAL() {
		return R12_TOT_VAL_UNBAL;
	}
	public void setR12_TOT_VAL_UNBAL(String r12_TOT_VAL_UNBAL) {
		R12_TOT_VAL_UNBAL = r12_TOT_VAL_UNBAL;
	}
	public String getR12_NO_INST_CONTRACT() {
		return R12_NO_INST_CONTRACT;
	}
	public void setR12_NO_INST_CONTRACT(String r12_NO_INST_CONTRACT) {
		R12_NO_INST_CONTRACT = r12_NO_INST_CONTRACT;
	}
	public String getR12_TOT_DORACC_NOTICE() {
		return R12_TOT_DORACC_NOTICE;
	}
	public void setR12_TOT_DORACC_NOTICE(String r12_TOT_DORACC_NOTICE) {
		R12_TOT_DORACC_NOTICE = r12_TOT_DORACC_NOTICE;
	}
	public String getR12_NO_CONS_LIAB_7DAY() {
		return R12_NO_CONS_LIAB_7DAY;
	}
	public void setR12_NO_CONS_LIAB_7DAY(String r12_NO_CONS_LIAB_7DAY) {
		R12_NO_CONS_LIAB_7DAY = r12_NO_CONS_LIAB_7DAY;
	}
	public String getR12_TOT_REQ_LIAB_NONLIA() {
		return R12_TOT_REQ_LIAB_NONLIA;
	}
	public void setR12_TOT_REQ_LIAB_NONLIA(String r12_TOT_REQ_LIAB_NONLIA) {
		R12_TOT_REQ_LIAB_NONLIA = r12_TOT_REQ_LIAB_NONLIA;
	}
	public String getR12_NO_RESTU_ONBO() {
		return R12_NO_RESTU_ONBO;
	}
	public void setR12_NO_RESTU_ONBO(String r12_NO_RESTU_ONBO) {
		R12_NO_RESTU_ONBO = r12_NO_RESTU_ONBO;
	}
	public String getR12_TOT_DELAY_TAT() {
		return R12_TOT_DELAY_TAT;
	}
	public void setR12_TOT_DELAY_TAT(String r12_TOT_DELAY_TAT) {
		R12_TOT_DELAY_TAT = r12_TOT_DELAY_TAT;
	}
	public String getR12_TOT_FND_TRAN() {
		return R12_TOT_FND_TRAN;
	}
	public void setR12_TOT_FND_TRAN(String r12_TOT_FND_TRAN) {
		R12_TOT_FND_TRAN = r12_TOT_FND_TRAN;
	}
	public String getR12_NO_FUND_RET24() {
		return R12_NO_FUND_RET24;
	}
	public void setR12_NO_FUND_RET24(String r12_NO_FUND_RET24) {
		R12_NO_FUND_RET24 = r12_NO_FUND_RET24;
	}
	public String getR12_NO_FAIL_TRAN() {
		return R12_NO_FAIL_TRAN;
	}
	public void setR12_NO_FAIL_TRAN(String r12_NO_FAIL_TRAN) {
		R12_NO_FAIL_TRAN = r12_NO_FAIL_TRAN;
	}
	public String getR12_CUS_FND_SVF_SPT() {
		return R12_CUS_FND_SVF_SPT;
	}
	public void setR12_CUS_FND_SVF_SPT(String r12_CUS_FND_SVF_SPT) {
		R12_CUS_FND_SVF_SPT = r12_CUS_FND_SVF_SPT;
	}
	public String getR12_CUS_FND_SVF_PRE() {
		return R12_CUS_FND_SVF_PRE;
	}
	public void setR12_CUS_FND_SVF_PRE(String r12_CUS_FND_SVF_PRE) {
		R12_CUS_FND_SVF_PRE = r12_CUS_FND_SVF_PRE;
	}
	public String getR12_TOT_CRDR_UND_SPT() {
		return R12_TOT_CRDR_UND_SPT;
	}
	public void setR12_TOT_CRDR_UND_SPT(String r12_TOT_CRDR_UND_SPT) {
		R12_TOT_CRDR_UND_SPT = r12_TOT_CRDR_UND_SPT;
	}
	public String getR12_TOT_CRD_ISU_SPT() {
		return R12_TOT_CRD_ISU_SPT;
	}
	public void setR12_TOT_CRD_ISU_SPT(String r12_TOT_CRD_ISU_SPT) {
		R12_TOT_CRD_ISU_SPT = r12_TOT_CRD_ISU_SPT;
	}
	public String getR12_NO_ACC_BLK_FIN() {
		return R12_NO_ACC_BLK_FIN;
	}
	public void setR12_NO_ACC_BLK_FIN(String r12_NO_ACC_BLK_FIN) {
		R12_NO_ACC_BLK_FIN = r12_NO_ACC_BLK_FIN;
	}
	public String getR12_NO_INQ_AVL_BAL() {
		return R12_NO_INQ_AVL_BAL;
	}
	public void setR12_NO_INQ_AVL_BAL(String r12_NO_INQ_AVL_BAL) {
		R12_NO_INQ_AVL_BAL = r12_NO_INQ_AVL_BAL;
	}
	public String getR12_TOT_PRE_EXP_SPT() {
		return R12_TOT_PRE_EXP_SPT;
	}
	public void setR12_TOT_PRE_EXP_SPT(String r12_TOT_PRE_EXP_SPT) {
		R12_TOT_PRE_EXP_SPT = r12_TOT_PRE_EXP_SPT;
	}
	public String getR12_TOT_PRE_POS_EXP() {
		return R12_TOT_PRE_POS_EXP;
	}
	public void setR12_TOT_PRE_POS_EXP(String r12_TOT_PRE_POS_EXP) {
		R12_TOT_PRE_POS_EXP = r12_TOT_PRE_POS_EXP;
	}
	public String getR12_TOT_PRE_CARD_SPD() {
		return R12_TOT_PRE_CARD_SPD;
	}
	public void setR12_TOT_PRE_CARD_SPD(String r12_TOT_PRE_CARD_SPD) {
		R12_TOT_PRE_CARD_SPD = r12_TOT_PRE_CARD_SPD;
	}
	public String getR12_TOT_ACCS_SPD() {
		return R12_TOT_ACCS_SPD;
	}
	public void setR12_TOT_ACCS_SPD(String r12_TOT_ACCS_SPD) {
		R12_TOT_ACCS_SPD = r12_TOT_ACCS_SPD;
	}
	public String getR12_NO_LANG_VOICE() {
		return R12_NO_LANG_VOICE;
	}
	public void setR12_NO_LANG_VOICE(String r12_NO_LANG_VOICE) {
		R12_NO_LANG_VOICE = r12_NO_LANG_VOICE;
	}
	public String getR12_AVG_NOD_LOWRSK() {
		return R12_AVG_NOD_LOWRSK;
	}
	public void setR12_AVG_NOD_LOWRSK(String r12_AVG_NOD_LOWRSK) {
		R12_AVG_NOD_LOWRSK = r12_AVG_NOD_LOWRSK;
	}
	public String getR12_NO_CUST_REISS_LIA() {
		return R12_NO_CUST_REISS_LIA;
	}
	public void setR12_NO_CUST_REISS_LIA(String r12_NO_CUST_REISS_LIA) {
		R12_NO_CUST_REISS_LIA = r12_NO_CUST_REISS_LIA;
	}
	public String getR12_NO_INS_CRRATE_CON() {
		return R12_NO_INS_CRRATE_CON;
	}
	public void setR12_NO_INS_CRRATE_CON(String r12_NO_INS_CRRATE_CON) {
		R12_NO_INS_CRRATE_CON = r12_NO_INS_CRRATE_CON;
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
	public String getR13_AVG_TME_LWRSK() {
		return R13_AVG_TME_LWRSK;
	}
	public void setR13_AVG_TME_LWRSK(String r13_AVG_TME_LWRSK) {
		R13_AVG_TME_LWRSK = r13_AVG_TME_LWRSK;
	}
	public String getR13_AVG_NO_LOAN() {
		return R13_AVG_NO_LOAN;
	}
	public void setR13_AVG_NO_LOAN(String r13_AVG_NO_LOAN) {
		R13_AVG_NO_LOAN = r13_AVG_NO_LOAN;
	}
	public String getR13_AVG_NO_LWRSK_SME() {
		return R13_AVG_NO_LWRSK_SME;
	}
	public void setR13_AVG_NO_LWRSK_SME(String r13_AVG_NO_LWRSK_SME) {
		R13_AVG_NO_LWRSK_SME = r13_AVG_NO_LWRSK_SME;
	}
	public String getR13_AVG_NO_DYS_SME() {
		return R13_AVG_NO_DYS_SME;
	}
	public void setR13_AVG_NO_DYS_SME(String r13_AVG_NO_DYS_SME) {
		R13_AVG_NO_DYS_SME = r13_AVG_NO_DYS_SME;
	}
	public String getR13_NO_REQ_CLO() {
		return R13_NO_REQ_CLO;
	}
	public void setR13_NO_REQ_CLO(String r13_NO_REQ_CLO) {
		R13_NO_REQ_CLO = r13_NO_REQ_CLO;
	}
	public String getR13_NO_PRD_VAR_SPC_TP() {
		return R13_NO_PRD_VAR_SPC_TP;
	}
	public void setR13_NO_PRD_VAR_SPC_TP(String r13_NO_PRD_VAR_SPC_TP) {
		R13_NO_PRD_VAR_SPC_TP = r13_NO_PRD_VAR_SPC_TP;
	}
	public String getR13_NO_REQ_RES_SPT() {
		return R13_NO_REQ_RES_SPT;
	}
	public void setR13_NO_REQ_RES_SPT(String r13_NO_REQ_RES_SPT) {
		R13_NO_REQ_RES_SPT = r13_NO_REQ_RES_SPT;
	}
	public String getR13_NO_REQ_PAYDEF() {
		return R13_NO_REQ_PAYDEF;
	}
	public void setR13_NO_REQ_PAYDEF(String r13_NO_REQ_PAYDEF) {
		R13_NO_REQ_PAYDEF = r13_NO_REQ_PAYDEF;
	}
	public String getR13_AVG_TME_REPAY() {
		return R13_AVG_TME_REPAY;
	}
	public void setR13_AVG_TME_REPAY(String r13_AVG_TME_REPAY) {
		R13_AVG_TME_REPAY = r13_AVG_TME_REPAY;
	}
	public String getR13_NO_INST_BAL() {
		return R13_NO_INST_BAL;
	}
	public void setR13_NO_INST_BAL(String r13_NO_INST_BAL) {
		R13_NO_INST_BAL = r13_NO_INST_BAL;
	}
	public String getR13_NET_FEE_AED() {
		return R13_NET_FEE_AED;
	}
	public void setR13_NET_FEE_AED(String r13_NET_FEE_AED) {
		R13_NET_FEE_AED = r13_NET_FEE_AED;
	}
	public String getR13_NET_PROF_AED() {
		return R13_NET_PROF_AED;
	}
	public void setR13_NET_PROF_AED(String r13_NET_PROF_AED) {
		R13_NET_PROF_AED = r13_NET_PROF_AED;
	}
	public String getR13_TOT_NO_ACC_SPD() {
		return R13_TOT_NO_ACC_SPD;
	}
	public void setR13_TOT_NO_ACC_SPD(String r13_TOT_NO_ACC_SPD) {
		R13_TOT_NO_ACC_SPD = r13_TOT_NO_ACC_SPD;
	}
	public String getR13_TOT_ACCS_DOR() {
		return R13_TOT_ACCS_DOR;
	}
	public void setR13_TOT_ACCS_DOR(String r13_TOT_ACCS_DOR) {
		R13_TOT_ACCS_DOR = r13_TOT_ACCS_DOR;
	}
	public String getR13_TOT_NEW_LOAN() {
		return R13_TOT_NEW_LOAN;
	}
	public void setR13_TOT_NEW_LOAN(String r13_TOT_NEW_LOAN) {
		R13_TOT_NEW_LOAN = r13_TOT_NEW_LOAN;
	}
	public String getR13_TOT_VAL_NEWACCS_AED() {
		return R13_TOT_VAL_NEWACCS_AED;
	}
	public void setR13_TOT_VAL_NEWACCS_AED(String r13_TOT_VAL_NEWACCS_AED) {
		R13_TOT_VAL_NEWACCS_AED = r13_TOT_VAL_NEWACCS_AED;
	}
	public String getR13_TOT_NO_LOAN_SPD() {
		return R13_TOT_NO_LOAN_SPD;
	}
	public void setR13_TOT_NO_LOAN_SPD(String r13_TOT_NO_LOAN_SPD) {
		R13_TOT_NO_LOAN_SPD = r13_TOT_NO_LOAN_SPD;
	}
	public String getR13_TOT_REQ_OTBNK() {
		return R13_TOT_REQ_OTBNK;
	}
	public void setR13_TOT_REQ_OTBNK(String r13_TOT_REQ_OTBNK) {
		R13_TOT_REQ_OTBNK = r13_TOT_REQ_OTBNK;
	}
	public String getR13_TOT_LOAN_OTBNK() {
		return R13_TOT_LOAN_OTBNK;
	}
	public void setR13_TOT_LOAN_OTBNK(String r13_TOT_LOAN_OTBNK) {
		R13_TOT_LOAN_OTBNK = r13_TOT_LOAN_OTBNK;
	}
	public String getR13_NO_CRACC_MIN() {
		return R13_NO_CRACC_MIN;
	}
	public void setR13_NO_CRACC_MIN(String r13_NO_CRACC_MIN) {
		R13_NO_CRACC_MIN = r13_NO_CRACC_MIN;
	}
	public String getR13_AVG_TME_CLSACC() {
		return R13_AVG_TME_CLSACC;
	}
	public void setR13_AVG_TME_CLSACC(String r13_AVG_TME_CLSACC) {
		R13_AVG_TME_CLSACC = r13_AVG_TME_CLSACC;
	}
	public String getR13_N0_CON_MORE1_LOAN() {
		return R13_N0_CON_MORE1_LOAN;
	}
	public void setR13_N0_CON_MORE1_LOAN(String r13_N0_CON_MORE1_LOAN) {
		R13_N0_CON_MORE1_LOAN = r13_N0_CON_MORE1_LOAN;
	}
	public String getR13_NO_INST_WITH90() {
		return R13_NO_INST_WITH90;
	}
	public void setR13_NO_INST_WITH90(String r13_NO_INST_WITH90) {
		R13_NO_INST_WITH90 = r13_NO_INST_WITH90;
	}
	public String getR13_TOT_GROSS_ASET() {
		return R13_TOT_GROSS_ASET;
	}
	public void setR13_TOT_GROSS_ASET(String r13_TOT_GROSS_ASET) {
		R13_TOT_GROSS_ASET = r13_TOT_GROSS_ASET;
	}
	public String getR13_RET_LIAB_AED() {
		return R13_RET_LIAB_AED;
	}
	public void setR13_RET_LIAB_AED(String r13_RET_LIAB_AED) {
		R13_RET_LIAB_AED = r13_RET_LIAB_AED;
	}
	public String getR13_HIG_PER_PROD_CAT() {
		return R13_HIG_PER_PROD_CAT;
	}
	public void setR13_HIG_PER_PROD_CAT(String r13_HIG_PER_PROD_CAT) {
		R13_HIG_PER_PROD_CAT = r13_HIG_PER_PROD_CAT;
	}
	public String getR13_NO_ACCS_TAG_NPA() {
		return R13_NO_ACCS_TAG_NPA;
	}
	public void setR13_NO_ACCS_TAG_NPA(String r13_NO_ACCS_TAG_NPA) {
		R13_NO_ACCS_TAG_NPA = r13_NO_ACCS_TAG_NPA;
	}
	public String getR13_NO_CHG_FEE_GRT5() {
		return R13_NO_CHG_FEE_GRT5;
	}
	public void setR13_NO_CHG_FEE_GRT5(String r13_NO_CHG_FEE_GRT5) {
		R13_NO_CHG_FEE_GRT5 = r13_NO_CHG_FEE_GRT5;
	}
	public String getR13_NO_CON_FLEX_INT() {
		return R13_NO_CON_FLEX_INT;
	}
	public void setR13_NO_CON_FLEX_INT(String r13_NO_CON_FLEX_INT) {
		R13_NO_CON_FLEX_INT = r13_NO_CON_FLEX_INT;
	}
	public String getR13_NO_CON_FIXED_INT() {
		return R13_NO_CON_FIXED_INT;
	}
	public void setR13_NO_CON_FIXED_INT(String r13_NO_CON_FIXED_INT) {
		R13_NO_CON_FIXED_INT = r13_NO_CON_FIXED_INT;
	}
	public String getR13_NO_LOAN_MAY_2011() {
		return R13_NO_LOAN_MAY_2011;
	}
	public void setR13_NO_LOAN_MAY_2011(String r13_NO_LOAN_MAY_2011) {
		R13_NO_LOAN_MAY_2011 = r13_NO_LOAN_MAY_2011;
	}
	public String getR13_VAL_LEGA_MAY_AED() {
		return R13_VAL_LEGA_MAY_AED;
	}
	public void setR13_VAL_LEGA_MAY_AED(String r13_VAL_LEGA_MAY_AED) {
		R13_VAL_LEGA_MAY_AED = r13_VAL_LEGA_MAY_AED;
	}
	public String getR13_AVG_DAY_NLL() {
		return R13_AVG_DAY_NLL;
	}
	public void setR13_AVG_DAY_NLL(String r13_AVG_DAY_NLL) {
		R13_AVG_DAY_NLL = r13_AVG_DAY_NLL;
	}
	public String getR13_PER_DOR_ACCS() {
		return R13_PER_DOR_ACCS;
	}
	public void setR13_PER_DOR_ACCS(String r13_PER_DOR_ACCS) {
		R13_PER_DOR_ACCS = r13_PER_DOR_ACCS;
	}
	public String getR13_INT_RET_PROF() {
		return R13_INT_RET_PROF;
	}
	public void setR13_INT_RET_PROF(String r13_INT_RET_PROF) {
		R13_INT_RET_PROF = r13_INT_RET_PROF;
	}
	public String getR13_FEE_COMM_PROF() {
		return R13_FEE_COMM_PROF;
	}
	public void setR13_FEE_COMM_PROF(String r13_FEE_COMM_PROF) {
		R13_FEE_COMM_PROF = r13_FEE_COMM_PROF;
	}
	public String getR13_TOT_UNCLM_90() {
		return R13_TOT_UNCLM_90;
	}
	public void setR13_TOT_UNCLM_90(String r13_TOT_UNCLM_90) {
		R13_TOT_UNCLM_90 = r13_TOT_UNCLM_90;
	}
	public String getR13_TOT_VAL_UNBAL() {
		return R13_TOT_VAL_UNBAL;
	}
	public void setR13_TOT_VAL_UNBAL(String r13_TOT_VAL_UNBAL) {
		R13_TOT_VAL_UNBAL = r13_TOT_VAL_UNBAL;
	}
	public String getR13_NO_INST_CONTRACT() {
		return R13_NO_INST_CONTRACT;
	}
	public void setR13_NO_INST_CONTRACT(String r13_NO_INST_CONTRACT) {
		R13_NO_INST_CONTRACT = r13_NO_INST_CONTRACT;
	}
	public String getR13_TOT_DORACC_NOTICE() {
		return R13_TOT_DORACC_NOTICE;
	}
	public void setR13_TOT_DORACC_NOTICE(String r13_TOT_DORACC_NOTICE) {
		R13_TOT_DORACC_NOTICE = r13_TOT_DORACC_NOTICE;
	}
	public String getR13_NO_CONS_LIAB_7DAY() {
		return R13_NO_CONS_LIAB_7DAY;
	}
	public void setR13_NO_CONS_LIAB_7DAY(String r13_NO_CONS_LIAB_7DAY) {
		R13_NO_CONS_LIAB_7DAY = r13_NO_CONS_LIAB_7DAY;
	}
	public String getR13_TOT_REQ_LIAB_NONLIA() {
		return R13_TOT_REQ_LIAB_NONLIA;
	}
	public void setR13_TOT_REQ_LIAB_NONLIA(String r13_TOT_REQ_LIAB_NONLIA) {
		R13_TOT_REQ_LIAB_NONLIA = r13_TOT_REQ_LIAB_NONLIA;
	}
	public String getR13_NO_RESTU_ONBO() {
		return R13_NO_RESTU_ONBO;
	}
	public void setR13_NO_RESTU_ONBO(String r13_NO_RESTU_ONBO) {
		R13_NO_RESTU_ONBO = r13_NO_RESTU_ONBO;
	}
	public String getR13_TOT_DELAY_TAT() {
		return R13_TOT_DELAY_TAT;
	}
	public void setR13_TOT_DELAY_TAT(String r13_TOT_DELAY_TAT) {
		R13_TOT_DELAY_TAT = r13_TOT_DELAY_TAT;
	}
	public String getR13_TOT_FND_TRAN() {
		return R13_TOT_FND_TRAN;
	}
	public void setR13_TOT_FND_TRAN(String r13_TOT_FND_TRAN) {
		R13_TOT_FND_TRAN = r13_TOT_FND_TRAN;
	}
	public String getR13_NO_FUND_RET24() {
		return R13_NO_FUND_RET24;
	}
	public void setR13_NO_FUND_RET24(String r13_NO_FUND_RET24) {
		R13_NO_FUND_RET24 = r13_NO_FUND_RET24;
	}
	public String getR13_NO_FAIL_TRAN() {
		return R13_NO_FAIL_TRAN;
	}
	public void setR13_NO_FAIL_TRAN(String r13_NO_FAIL_TRAN) {
		R13_NO_FAIL_TRAN = r13_NO_FAIL_TRAN;
	}
	public String getR13_CUS_FND_SVF_SPT() {
		return R13_CUS_FND_SVF_SPT;
	}
	public void setR13_CUS_FND_SVF_SPT(String r13_CUS_FND_SVF_SPT) {
		R13_CUS_FND_SVF_SPT = r13_CUS_FND_SVF_SPT;
	}
	public String getR13_CUS_FND_SVF_PRE() {
		return R13_CUS_FND_SVF_PRE;
	}
	public void setR13_CUS_FND_SVF_PRE(String r13_CUS_FND_SVF_PRE) {
		R13_CUS_FND_SVF_PRE = r13_CUS_FND_SVF_PRE;
	}
	public String getR13_TOT_CRDR_UND_SPT() {
		return R13_TOT_CRDR_UND_SPT;
	}
	public void setR13_TOT_CRDR_UND_SPT(String r13_TOT_CRDR_UND_SPT) {
		R13_TOT_CRDR_UND_SPT = r13_TOT_CRDR_UND_SPT;
	}
	public String getR13_TOT_CRD_ISU_SPT() {
		return R13_TOT_CRD_ISU_SPT;
	}
	public void setR13_TOT_CRD_ISU_SPT(String r13_TOT_CRD_ISU_SPT) {
		R13_TOT_CRD_ISU_SPT = r13_TOT_CRD_ISU_SPT;
	}
	public String getR13_NO_ACC_BLK_FIN() {
		return R13_NO_ACC_BLK_FIN;
	}
	public void setR13_NO_ACC_BLK_FIN(String r13_NO_ACC_BLK_FIN) {
		R13_NO_ACC_BLK_FIN = r13_NO_ACC_BLK_FIN;
	}
	public String getR13_NO_INQ_AVL_BAL() {
		return R13_NO_INQ_AVL_BAL;
	}
	public void setR13_NO_INQ_AVL_BAL(String r13_NO_INQ_AVL_BAL) {
		R13_NO_INQ_AVL_BAL = r13_NO_INQ_AVL_BAL;
	}
	public String getR13_TOT_PRE_EXP_SPT() {
		return R13_TOT_PRE_EXP_SPT;
	}
	public void setR13_TOT_PRE_EXP_SPT(String r13_TOT_PRE_EXP_SPT) {
		R13_TOT_PRE_EXP_SPT = r13_TOT_PRE_EXP_SPT;
	}
	public String getR13_TOT_PRE_POS_EXP() {
		return R13_TOT_PRE_POS_EXP;
	}
	public void setR13_TOT_PRE_POS_EXP(String r13_TOT_PRE_POS_EXP) {
		R13_TOT_PRE_POS_EXP = r13_TOT_PRE_POS_EXP;
	}
	public String getR13_TOT_PRE_CARD_SPD() {
		return R13_TOT_PRE_CARD_SPD;
	}
	public void setR13_TOT_PRE_CARD_SPD(String r13_TOT_PRE_CARD_SPD) {
		R13_TOT_PRE_CARD_SPD = r13_TOT_PRE_CARD_SPD;
	}
	public String getR13_TOT_ACCS_SPD() {
		return R13_TOT_ACCS_SPD;
	}
	public void setR13_TOT_ACCS_SPD(String r13_TOT_ACCS_SPD) {
		R13_TOT_ACCS_SPD = r13_TOT_ACCS_SPD;
	}
	public String getR13_NO_LANG_VOICE() {
		return R13_NO_LANG_VOICE;
	}
	public void setR13_NO_LANG_VOICE(String r13_NO_LANG_VOICE) {
		R13_NO_LANG_VOICE = r13_NO_LANG_VOICE;
	}
	public String getR13_AVG_NOD_LOWRSK() {
		return R13_AVG_NOD_LOWRSK;
	}
	public void setR13_AVG_NOD_LOWRSK(String r13_AVG_NOD_LOWRSK) {
		R13_AVG_NOD_LOWRSK = r13_AVG_NOD_LOWRSK;
	}
	public String getR13_NO_CUST_REISS_LIA() {
		return R13_NO_CUST_REISS_LIA;
	}
	public void setR13_NO_CUST_REISS_LIA(String r13_NO_CUST_REISS_LIA) {
		R13_NO_CUST_REISS_LIA = r13_NO_CUST_REISS_LIA;
	}
	public String getR13_NO_INS_CRRATE_CON() {
		return R13_NO_INS_CRRATE_CON;
	}
	public void setR13_NO_INS_CRRATE_CON(String r13_NO_INS_CRRATE_CON) {
		R13_NO_INS_CRRATE_CON = r13_NO_INS_CRRATE_CON;
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
	public String getR14_AVG_TME_LWRSK() {
		return R14_AVG_TME_LWRSK;
	}
	public void setR14_AVG_TME_LWRSK(String r14_AVG_TME_LWRSK) {
		R14_AVG_TME_LWRSK = r14_AVG_TME_LWRSK;
	}
	public String getR14_AVG_NO_LOAN() {
		return R14_AVG_NO_LOAN;
	}
	public void setR14_AVG_NO_LOAN(String r14_AVG_NO_LOAN) {
		R14_AVG_NO_LOAN = r14_AVG_NO_LOAN;
	}
	public String getR14_AVG_NO_LWRSK_SME() {
		return R14_AVG_NO_LWRSK_SME;
	}
	public void setR14_AVG_NO_LWRSK_SME(String r14_AVG_NO_LWRSK_SME) {
		R14_AVG_NO_LWRSK_SME = r14_AVG_NO_LWRSK_SME;
	}
	public String getR14_AVG_NO_DYS_SME() {
		return R14_AVG_NO_DYS_SME;
	}
	public void setR14_AVG_NO_DYS_SME(String r14_AVG_NO_DYS_SME) {
		R14_AVG_NO_DYS_SME = r14_AVG_NO_DYS_SME;
	}
	public String getR14_NO_REQ_CLO() {
		return R14_NO_REQ_CLO;
	}
	public void setR14_NO_REQ_CLO(String r14_NO_REQ_CLO) {
		R14_NO_REQ_CLO = r14_NO_REQ_CLO;
	}
	public String getR14_NO_PRD_VAR_SPC_TP() {
		return R14_NO_PRD_VAR_SPC_TP;
	}
	public void setR14_NO_PRD_VAR_SPC_TP(String r14_NO_PRD_VAR_SPC_TP) {
		R14_NO_PRD_VAR_SPC_TP = r14_NO_PRD_VAR_SPC_TP;
	}
	public String getR14_NO_REQ_RES_SPT() {
		return R14_NO_REQ_RES_SPT;
	}
	public void setR14_NO_REQ_RES_SPT(String r14_NO_REQ_RES_SPT) {
		R14_NO_REQ_RES_SPT = r14_NO_REQ_RES_SPT;
	}
	public String getR14_NO_REQ_PAYDEF() {
		return R14_NO_REQ_PAYDEF;
	}
	public void setR14_NO_REQ_PAYDEF(String r14_NO_REQ_PAYDEF) {
		R14_NO_REQ_PAYDEF = r14_NO_REQ_PAYDEF;
	}
	public String getR14_AVG_TME_REPAY() {
		return R14_AVG_TME_REPAY;
	}
	public void setR14_AVG_TME_REPAY(String r14_AVG_TME_REPAY) {
		R14_AVG_TME_REPAY = r14_AVG_TME_REPAY;
	}
	public String getR14_NO_INST_BAL() {
		return R14_NO_INST_BAL;
	}
	public void setR14_NO_INST_BAL(String r14_NO_INST_BAL) {
		R14_NO_INST_BAL = r14_NO_INST_BAL;
	}
	public String getR14_NET_FEE_AED() {
		return R14_NET_FEE_AED;
	}
	public void setR14_NET_FEE_AED(String r14_NET_FEE_AED) {
		R14_NET_FEE_AED = r14_NET_FEE_AED;
	}
	public String getR14_NET_PROF_AED() {
		return R14_NET_PROF_AED;
	}
	public void setR14_NET_PROF_AED(String r14_NET_PROF_AED) {
		R14_NET_PROF_AED = r14_NET_PROF_AED;
	}
	public String getR14_TOT_NO_ACC_SPD() {
		return R14_TOT_NO_ACC_SPD;
	}
	public void setR14_TOT_NO_ACC_SPD(String r14_TOT_NO_ACC_SPD) {
		R14_TOT_NO_ACC_SPD = r14_TOT_NO_ACC_SPD;
	}
	public String getR14_TOT_ACCS_DOR() {
		return R14_TOT_ACCS_DOR;
	}
	public void setR14_TOT_ACCS_DOR(String r14_TOT_ACCS_DOR) {
		R14_TOT_ACCS_DOR = r14_TOT_ACCS_DOR;
	}
	public String getR14_TOT_NEW_LOAN() {
		return R14_TOT_NEW_LOAN;
	}
	public void setR14_TOT_NEW_LOAN(String r14_TOT_NEW_LOAN) {
		R14_TOT_NEW_LOAN = r14_TOT_NEW_LOAN;
	}
	public String getR14_TOT_VAL_NEWACCS_AED() {
		return R14_TOT_VAL_NEWACCS_AED;
	}
	public void setR14_TOT_VAL_NEWACCS_AED(String r14_TOT_VAL_NEWACCS_AED) {
		R14_TOT_VAL_NEWACCS_AED = r14_TOT_VAL_NEWACCS_AED;
	}
	public String getR14_TOT_NO_LOAN_SPD() {
		return R14_TOT_NO_LOAN_SPD;
	}
	public void setR14_TOT_NO_LOAN_SPD(String r14_TOT_NO_LOAN_SPD) {
		R14_TOT_NO_LOAN_SPD = r14_TOT_NO_LOAN_SPD;
	}
	public String getR14_TOT_REQ_OTBNK() {
		return R14_TOT_REQ_OTBNK;
	}
	public void setR14_TOT_REQ_OTBNK(String r14_TOT_REQ_OTBNK) {
		R14_TOT_REQ_OTBNK = r14_TOT_REQ_OTBNK;
	}
	public String getR14_TOT_LOAN_OTBNK() {
		return R14_TOT_LOAN_OTBNK;
	}
	public void setR14_TOT_LOAN_OTBNK(String r14_TOT_LOAN_OTBNK) {
		R14_TOT_LOAN_OTBNK = r14_TOT_LOAN_OTBNK;
	}
	public String getR14_NO_CRACC_MIN() {
		return R14_NO_CRACC_MIN;
	}
	public void setR14_NO_CRACC_MIN(String r14_NO_CRACC_MIN) {
		R14_NO_CRACC_MIN = r14_NO_CRACC_MIN;
	}
	public String getR14_AVG_TME_CLSACC() {
		return R14_AVG_TME_CLSACC;
	}
	public void setR14_AVG_TME_CLSACC(String r14_AVG_TME_CLSACC) {
		R14_AVG_TME_CLSACC = r14_AVG_TME_CLSACC;
	}
	public String getR14_N0_CON_MORE1_LOAN() {
		return R14_N0_CON_MORE1_LOAN;
	}
	public void setR14_N0_CON_MORE1_LOAN(String r14_N0_CON_MORE1_LOAN) {
		R14_N0_CON_MORE1_LOAN = r14_N0_CON_MORE1_LOAN;
	}
	public String getR14_NO_INST_WITH90() {
		return R14_NO_INST_WITH90;
	}
	public void setR14_NO_INST_WITH90(String r14_NO_INST_WITH90) {
		R14_NO_INST_WITH90 = r14_NO_INST_WITH90;
	}
	public String getR14_TOT_GROSS_ASET() {
		return R14_TOT_GROSS_ASET;
	}
	public void setR14_TOT_GROSS_ASET(String r14_TOT_GROSS_ASET) {
		R14_TOT_GROSS_ASET = r14_TOT_GROSS_ASET;
	}
	public String getR14_RET_LIAB_AED() {
		return R14_RET_LIAB_AED;
	}
	public void setR14_RET_LIAB_AED(String r14_RET_LIAB_AED) {
		R14_RET_LIAB_AED = r14_RET_LIAB_AED;
	}
	public String getR14_HIG_PER_PROD_CAT() {
		return R14_HIG_PER_PROD_CAT;
	}
	public void setR14_HIG_PER_PROD_CAT(String r14_HIG_PER_PROD_CAT) {
		R14_HIG_PER_PROD_CAT = r14_HIG_PER_PROD_CAT;
	}
	public String getR14_NO_ACCS_TAG_NPA() {
		return R14_NO_ACCS_TAG_NPA;
	}
	public void setR14_NO_ACCS_TAG_NPA(String r14_NO_ACCS_TAG_NPA) {
		R14_NO_ACCS_TAG_NPA = r14_NO_ACCS_TAG_NPA;
	}
	public String getR14_NO_CHG_FEE_GRT5() {
		return R14_NO_CHG_FEE_GRT5;
	}
	public void setR14_NO_CHG_FEE_GRT5(String r14_NO_CHG_FEE_GRT5) {
		R14_NO_CHG_FEE_GRT5 = r14_NO_CHG_FEE_GRT5;
	}
	public String getR14_NO_CON_FLEX_INT() {
		return R14_NO_CON_FLEX_INT;
	}
	public void setR14_NO_CON_FLEX_INT(String r14_NO_CON_FLEX_INT) {
		R14_NO_CON_FLEX_INT = r14_NO_CON_FLEX_INT;
	}
	public String getR14_NO_CON_FIXED_INT() {
		return R14_NO_CON_FIXED_INT;
	}
	public void setR14_NO_CON_FIXED_INT(String r14_NO_CON_FIXED_INT) {
		R14_NO_CON_FIXED_INT = r14_NO_CON_FIXED_INT;
	}
	public String getR14_NO_LOAN_MAY_2011() {
		return R14_NO_LOAN_MAY_2011;
	}
	public void setR14_NO_LOAN_MAY_2011(String r14_NO_LOAN_MAY_2011) {
		R14_NO_LOAN_MAY_2011 = r14_NO_LOAN_MAY_2011;
	}
	public String getR14_VAL_LEGA_MAY_AED() {
		return R14_VAL_LEGA_MAY_AED;
	}
	public void setR14_VAL_LEGA_MAY_AED(String r14_VAL_LEGA_MAY_AED) {
		R14_VAL_LEGA_MAY_AED = r14_VAL_LEGA_MAY_AED;
	}
	public String getR14_AVG_DAY_NLL() {
		return R14_AVG_DAY_NLL;
	}
	public void setR14_AVG_DAY_NLL(String r14_AVG_DAY_NLL) {
		R14_AVG_DAY_NLL = r14_AVG_DAY_NLL;
	}
	public String getR14_PER_DOR_ACCS() {
		return R14_PER_DOR_ACCS;
	}
	public void setR14_PER_DOR_ACCS(String r14_PER_DOR_ACCS) {
		R14_PER_DOR_ACCS = r14_PER_DOR_ACCS;
	}
	public String getR14_INT_RET_PROF() {
		return R14_INT_RET_PROF;
	}
	public void setR14_INT_RET_PROF(String r14_INT_RET_PROF) {
		R14_INT_RET_PROF = r14_INT_RET_PROF;
	}
	public String getR14_FEE_COMM_PROF() {
		return R14_FEE_COMM_PROF;
	}
	public void setR14_FEE_COMM_PROF(String r14_FEE_COMM_PROF) {
		R14_FEE_COMM_PROF = r14_FEE_COMM_PROF;
	}
	public String getR14_TOT_UNCLM_90() {
		return R14_TOT_UNCLM_90;
	}
	public void setR14_TOT_UNCLM_90(String r14_TOT_UNCLM_90) {
		R14_TOT_UNCLM_90 = r14_TOT_UNCLM_90;
	}
	public String getR14_TOT_VAL_UNBAL() {
		return R14_TOT_VAL_UNBAL;
	}
	public void setR14_TOT_VAL_UNBAL(String r14_TOT_VAL_UNBAL) {
		R14_TOT_VAL_UNBAL = r14_TOT_VAL_UNBAL;
	}
	public String getR14_NO_INST_CONTRACT() {
		return R14_NO_INST_CONTRACT;
	}
	public void setR14_NO_INST_CONTRACT(String r14_NO_INST_CONTRACT) {
		R14_NO_INST_CONTRACT = r14_NO_INST_CONTRACT;
	}
	public String getR14_TOT_DORACC_NOTICE() {
		return R14_TOT_DORACC_NOTICE;
	}
	public void setR14_TOT_DORACC_NOTICE(String r14_TOT_DORACC_NOTICE) {
		R14_TOT_DORACC_NOTICE = r14_TOT_DORACC_NOTICE;
	}
	public String getR14_NO_CONS_LIAB_7DAY() {
		return R14_NO_CONS_LIAB_7DAY;
	}
	public void setR14_NO_CONS_LIAB_7DAY(String r14_NO_CONS_LIAB_7DAY) {
		R14_NO_CONS_LIAB_7DAY = r14_NO_CONS_LIAB_7DAY;
	}
	public String getR14_TOT_REQ_LIAB_NONLIA() {
		return R14_TOT_REQ_LIAB_NONLIA;
	}
	public void setR14_TOT_REQ_LIAB_NONLIA(String r14_TOT_REQ_LIAB_NONLIA) {
		R14_TOT_REQ_LIAB_NONLIA = r14_TOT_REQ_LIAB_NONLIA;
	}
	public String getR14_NO_RESTU_ONBO() {
		return R14_NO_RESTU_ONBO;
	}
	public void setR14_NO_RESTU_ONBO(String r14_NO_RESTU_ONBO) {
		R14_NO_RESTU_ONBO = r14_NO_RESTU_ONBO;
	}
	public String getR14_TOT_DELAY_TAT() {
		return R14_TOT_DELAY_TAT;
	}
	public void setR14_TOT_DELAY_TAT(String r14_TOT_DELAY_TAT) {
		R14_TOT_DELAY_TAT = r14_TOT_DELAY_TAT;
	}
	public String getR14_TOT_FND_TRAN() {
		return R14_TOT_FND_TRAN;
	}
	public void setR14_TOT_FND_TRAN(String r14_TOT_FND_TRAN) {
		R14_TOT_FND_TRAN = r14_TOT_FND_TRAN;
	}
	public String getR14_NO_FUND_RET24() {
		return R14_NO_FUND_RET24;
	}
	public void setR14_NO_FUND_RET24(String r14_NO_FUND_RET24) {
		R14_NO_FUND_RET24 = r14_NO_FUND_RET24;
	}
	public String getR14_NO_FAIL_TRAN() {
		return R14_NO_FAIL_TRAN;
	}
	public void setR14_NO_FAIL_TRAN(String r14_NO_FAIL_TRAN) {
		R14_NO_FAIL_TRAN = r14_NO_FAIL_TRAN;
	}
	public String getR14_CUS_FND_SVF_SPT() {
		return R14_CUS_FND_SVF_SPT;
	}
	public void setR14_CUS_FND_SVF_SPT(String r14_CUS_FND_SVF_SPT) {
		R14_CUS_FND_SVF_SPT = r14_CUS_FND_SVF_SPT;
	}
	public String getR14_CUS_FND_SVF_PRE() {
		return R14_CUS_FND_SVF_PRE;
	}
	public void setR14_CUS_FND_SVF_PRE(String r14_CUS_FND_SVF_PRE) {
		R14_CUS_FND_SVF_PRE = r14_CUS_FND_SVF_PRE;
	}
	public String getR14_TOT_CRDR_UND_SPT() {
		return R14_TOT_CRDR_UND_SPT;
	}
	public void setR14_TOT_CRDR_UND_SPT(String r14_TOT_CRDR_UND_SPT) {
		R14_TOT_CRDR_UND_SPT = r14_TOT_CRDR_UND_SPT;
	}
	public String getR14_TOT_CRD_ISU_SPT() {
		return R14_TOT_CRD_ISU_SPT;
	}
	public void setR14_TOT_CRD_ISU_SPT(String r14_TOT_CRD_ISU_SPT) {
		R14_TOT_CRD_ISU_SPT = r14_TOT_CRD_ISU_SPT;
	}
	public String getR14_NO_ACC_BLK_FIN() {
		return R14_NO_ACC_BLK_FIN;
	}
	public void setR14_NO_ACC_BLK_FIN(String r14_NO_ACC_BLK_FIN) {
		R14_NO_ACC_BLK_FIN = r14_NO_ACC_BLK_FIN;
	}
	public String getR14_NO_INQ_AVL_BAL() {
		return R14_NO_INQ_AVL_BAL;
	}
	public void setR14_NO_INQ_AVL_BAL(String r14_NO_INQ_AVL_BAL) {
		R14_NO_INQ_AVL_BAL = r14_NO_INQ_AVL_BAL;
	}
	public String getR14_TOT_PRE_EXP_SPT() {
		return R14_TOT_PRE_EXP_SPT;
	}
	public void setR14_TOT_PRE_EXP_SPT(String r14_TOT_PRE_EXP_SPT) {
		R14_TOT_PRE_EXP_SPT = r14_TOT_PRE_EXP_SPT;
	}
	public String getR14_TOT_PRE_POS_EXP() {
		return R14_TOT_PRE_POS_EXP;
	}
	public void setR14_TOT_PRE_POS_EXP(String r14_TOT_PRE_POS_EXP) {
		R14_TOT_PRE_POS_EXP = r14_TOT_PRE_POS_EXP;
	}
	public String getR14_TOT_PRE_CARD_SPD() {
		return R14_TOT_PRE_CARD_SPD;
	}
	public void setR14_TOT_PRE_CARD_SPD(String r14_TOT_PRE_CARD_SPD) {
		R14_TOT_PRE_CARD_SPD = r14_TOT_PRE_CARD_SPD;
	}
	public String getR14_TOT_ACCS_SPD() {
		return R14_TOT_ACCS_SPD;
	}
	public void setR14_TOT_ACCS_SPD(String r14_TOT_ACCS_SPD) {
		R14_TOT_ACCS_SPD = r14_TOT_ACCS_SPD;
	}
	public String getR14_NO_LANG_VOICE() {
		return R14_NO_LANG_VOICE;
	}
	public void setR14_NO_LANG_VOICE(String r14_NO_LANG_VOICE) {
		R14_NO_LANG_VOICE = r14_NO_LANG_VOICE;
	}
	public String getR14_AVG_NOD_LOWRSK() {
		return R14_AVG_NOD_LOWRSK;
	}
	public void setR14_AVG_NOD_LOWRSK(String r14_AVG_NOD_LOWRSK) {
		R14_AVG_NOD_LOWRSK = r14_AVG_NOD_LOWRSK;
	}
	public String getR14_NO_CUST_REISS_LIA() {
		return R14_NO_CUST_REISS_LIA;
	}
	public void setR14_NO_CUST_REISS_LIA(String r14_NO_CUST_REISS_LIA) {
		R14_NO_CUST_REISS_LIA = r14_NO_CUST_REISS_LIA;
	}
	public String getR14_NO_INS_CRRATE_CON() {
		return R14_NO_INS_CRRATE_CON;
	}
	public void setR14_NO_INS_CRRATE_CON(String r14_NO_INS_CRRATE_CON) {
		R14_NO_INS_CRRATE_CON = r14_NO_INS_CRRATE_CON;
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
	public RT_MC_TABLE4_1_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
