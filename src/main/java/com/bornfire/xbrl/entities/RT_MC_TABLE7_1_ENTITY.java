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
@Table(name = "RT_MC_TABLE7_1")
public class RT_MC_TABLE7_1_ENTITY {

	public String R7_BANK;
	public String R7_PRODUCT;
	public String R7_RET_ASET_LTS;
	public String R7_RET_ASET_LTSME;
	public String R7_RET_ASET_SME_GUR;
	public String R7_RET_LOAN_DIS;
	public String R7_RET_ASET_LOAN_SME;
	public String R7_PER_LOAN_WEB;
	public String R7_LOAN_SME_WEB_MOB;
	public String R7_NO_COMPDIGI_MOB;
	public String R7_NO_COMP_TRADCALL;
	public String R7_PER_COMPDIGI_WEB;
	public String R7_PER_COM_TRADCALL;
	public String R7_TOT_REV_PREV;
	public String R7_PROF_LOSS_PREV;
	public String R7_PROF_MARG_PORTFOLIO;
	public String R7_TOT_RET_ASET_PREV;
	public String R7_NP_LOAN_PREV;
	public String R7_NON_CON_ONLAST_PREV;
	public String R7_TOT_BRAN_PREV;
	public String R7_TOT_REV_RET_CUR;
	public String R7_PROF_LOS_PORT_CUR;
	public String R7_PROF_MARG_PERC_CUR;
	public String R7_TOT_RET_ASET_CUR;
	public String R7_NON_PER_RET_PORT_CUR;
	public String R7_NO_CON_LAST_CUR;
	public String R7_TOT_BRANCH_CUR;
	public String R7_TOT_REV_T1;
	public String R7_PROF_LOS_T1;
	public String R7_PROF_MARG_T1;
	public String R7_TOT_RET_ASET_T1;
	public String R7_NON_PERF_PORT_T1;
	public String R7_NO_CON_LAST_T1;
	public String R7_TOT_BRANCH_T1;
	public String R7_TOT_REV_T2;
	public String R7_PROF_LOS_T2;
	public String R7_PROF_MARG_T2;
	public String R7_TOT_RET_ASET_T2;
	public String R7_NON_PERF_PORT_T2;
	public String R7_NO_CON_LAST_T2;
	public String R7_TOT_BRANCH_T2;
	public String R7_TOT_REV_T3;
	public String R7_PROF_LOS_T3;
	public String R7_PROF_MARG_T3;
	public String R7_TOT_RET_ASET_T3;
	public String R7_NON_PERF_PORT_T3;
	public String R7_NO_CON_LAST_T3;
	public String R7_TOT_BRANCH_T3;
	public String R7_NPL_SPD;
	public String R7_RECO_NPL_SPD;
	public String R7_NO_CON_ONBO_DIGI;
	public String R7_NO_ACCS_AML;
	public String R7_TOT_ACC_LOAN_AML;
	public String R7_TOT_NEW_ACCS_SPD;
	public String R7_TOT_VALS_LOANS_SPD;
	public String R7_NO_INQ_WEBMOB;
	public String R7_NO_INQ_TRAD;
	public String R7_NO_RET_POS;
	public String R7_AMT_POS_GATE;
	public String R7_NO_TRAN_SVF_BNK;
	public String R7_AMT_RET_SVF_BNK;
	public String R7_TOT_WEB_MOB_VIRT;
	public String R7_VAL_UNCL_SVF;
	public String R7_NO_CON_LOW_RSK;
	public String R7_NO_CON_HIGH_RSK;
	public String R8_BANK;
	public String R8_PRODUCT;
	public String R8_RET_ASET_LTS;
	public String R8_RET_ASET_LTSME;
	public String R8_RET_ASET_SME_GUR;
	public String R8_RET_LOAN_DIS;
	public String R8_RET_ASET_LOAN_SME;
	public String R8_PER_LOAN_WEB;
	public String R8_LOAN_SME_WEB_MOB;
	public String R8_NO_COMPDIGI_MOB;
	public String R8_NO_COMP_TRADCALL;
	public String R8_PER_COMPDIGI_WEB;
	public String R8_PER_COM_TRADCALL;
	public String R8_TOT_REV_PREV;
	public String R8_PROF_LOSS_PREV;
	public String R8_PROF_MARG_PORTFOLIO;
	public String R8_TOT_RET_ASET_PREV;
	public String R8_NP_LOAN_PREV;
	public String R8_NON_CON_ONLAST_PREV;
	public String R8_TOT_BRAN_PREV;
	public String R8_TOT_REV_RET_CUR;
	public String R8_PROF_LOS_PORT_CUR;
	public String R8_PROF_MARG_PERC_CUR;
	public String R8_TOT_RET_ASET_CUR;
	public String R8_NON_PER_RET_PORT_CUR;
	public String R8_NO_CON_LAST_CUR;
	public String R8_TOT_BRANCH_CUR;
	public String R8_TOT_REV_T1;
	public String R8_PROF_LOS_T1;
	public String R8_PROF_MARG_T1;
	public String R8_TOT_RET_ASET_T1;
	public String R8_NON_PERF_PORT_T1;
	public String R8_NO_CON_LAST_T1;
	public String R8_TOT_BRANCH_T1;
	public String R8_TOT_REV_T2;
	public String R8_PROF_LOS_T2;
	public String R8_PROF_MARG_T2;
	public String R8_TOT_RET_ASET_T2;
	public String R8_NON_PERF_PORT_T2;
	public String R8_NO_CON_LAST_T2;
	public String R8_TOT_BRANCH_T2;
	public String R8_TOT_REV_T3;
	public String R8_PROF_LOS_T3;
	public String R8_PROF_MARG_T3;
	public String R8_TOT_RET_ASET_T3;
	public String R8_NON_PERF_PORT_T3;
	public String R8_NO_CON_LAST_T3;
	public String R8_TOT_BRANCH_T3;
	public String R8_NPL_SPD;
	public String R8_RECO_NPL_SPD;
	public String R8_NO_CON_ONBO_DIGI;
	public String R8_NO_ACCS_AML;
	public String R8_TOT_ACC_LOAN_AML;
	public String R8_TOT_NEW_ACCS_SPD;
	public String R8_TOT_VALS_LOANS_SPD;
	public String R8_NO_INQ_WEBMOB;
	public String R8_NO_INQ_TRAD;
	public String R8_NO_RET_POS;
	public String R8_AMT_POS_GATE;
	public String R8_NO_TRAN_SVF_BNK;
	public String R8_AMT_RET_SVF_BNK;
	public String R8_TOT_WEB_MOB_VIRT;
	public String R8_VAL_UNCL_SVF;
	public String R8_NO_CON_LOW_RSK;
	public String R8_NO_CON_HIGH_RSK;
	public String R9_BANK;
	public String R9_PRODUCT;
	public String R9_RET_ASET_LTS;
	public String R9_RET_ASET_LTSME;
	public String R9_RET_ASET_SME_GUR;
	public String R9_RET_LOAN_DIS;
	public String R9_RET_ASET_LOAN_SME;
	public String R9_PER_LOAN_WEB;
	public String R9_LOAN_SME_WEB_MOB;
	public String R9_NO_COMPDIGI_MOB;
	public String R9_NO_COMP_TRADCALL;
	public String R9_PER_COMPDIGI_WEB;
	public String R9_PER_COM_TRADCALL;
	public String R9_TOT_REV_PREV;
	public String R9_PROF_LOSS_PREV;
	public String R9_PROF_MARG_PORTFOLIO;
	public String R9_TOT_RET_ASET_PREV;
	public String R9_NP_LOAN_PREV;
	public String R9_NON_CON_ONLAST_PREV;
	public String R9_TOT_BRAN_PREV;
	public String R9_TOT_REV_RET_CUR;
	public String R9_PROF_LOS_PORT_CUR;
	public String R9_PROF_MARG_PERC_CUR;
	public String R9_TOT_RET_ASET_CUR;
	public String R9_NON_PER_RET_PORT_CUR;
	public String R9_NO_CON_LAST_CUR;
	public String R9_TOT_BRANCH_CUR;
	public String R9_TOT_REV_T1;
	public String R9_PROF_LOS_T1;
	public String R9_PROF_MARG_T1;
	public String R9_TOT_RET_ASET_T1;
	public String R9_NON_PERF_PORT_T1;
	public String R9_NO_CON_LAST_T1;
	public String R9_TOT_BRANCH_T1;
	public String R9_TOT_REV_T2;
	public String R9_PROF_LOS_T2;
	public String R9_PROF_MARG_T2;
	public String R9_TOT_RET_ASET_T2;
	public String R9_NON_PERF_PORT_T2;
	public String R9_NO_CON_LAST_T2;
	public String R9_TOT_BRANCH_T2;
	public String R9_TOT_REV_T3;
	public String R9_PROF_LOS_T3;
	public String R9_PROF_MARG_T3;
	public String R9_TOT_RET_ASET_T3;
	public String R9_NON_PERF_PORT_T3;
	public String R9_NO_CON_LAST_T3;
	public String R9_TOT_BRANCH_T3;
	public String R9_NPL_SPD;
	public String R9_RECO_NPL_SPD;
	public String R9_NO_CON_ONBO_DIGI;
	public String R9_NO_ACCS_AML;
	public String R9_TOT_ACC_LOAN_AML;
	public String R9_TOT_NEW_ACCS_SPD;
	public String R9_TOT_VALS_LOANS_SPD;
	public String R9_NO_INQ_WEBMOB;
	public String R9_NO_INQ_TRAD;
	public String R9_NO_RET_POS;
	public String R9_AMT_POS_GATE;
	public String R9_NO_TRAN_SVF_BNK;
	public String R9_AMT_RET_SVF_BNK;
	public String R9_TOT_WEB_MOB_VIRT;
	public String R9_VAL_UNCL_SVF;
	public String R9_NO_CON_LOW_RSK;
	public String R9_NO_CON_HIGH_RSK;
	public String R10_BANK;
	public String R10_PRODUCT;
	public String R10_RET_ASET_LTS;
	public String R10_RET_ASET_LTSME;
	public String R10_RET_ASET_SME_GUR;
	public String R10_RET_LOAN_DIS;
	public String R10_RET_ASET_LOAN_SME;
	public String R10_PER_LOAN_WEB;
	public String R10_LOAN_SME_WEB_MOB;
	public String R10_NO_COMPDIGI_MOB;
	public String R10_NO_COMP_TRADCALL;
	public String R10_PER_COMPDIGI_WEB;
	public String R10_PER_COM_TRADCALL;
	public String R10_TOT_REV_PREV;
	public String R10_PROF_LOSS_PREV;
	public String R10_PROF_MARG_PORTFOLIO;
	public String R10_TOT_RET_ASET_PREV;
	public String R10_NP_LOAN_PREV;
	public String R10_NON_CON_ONLAST_PREV;
	public String R10_TOT_BRAN_PREV;
	public String R10_TOT_REV_RET_CUR;
	public String R10_PROF_LOS_PORT_CUR;
	public String R10_PROF_MARG_PERC_CUR;
	public String R10_TOT_RET_ASET_CUR;
	public String R10_NON_PER_RET_PORT_CUR;
	public String R10_NO_CON_LAST_CUR;
	public String R10_TOT_BRANCH_CUR;
	public String R10_TOT_REV_T1;
	public String R10_PROF_LOS_T1;
	public String R10_PROF_MARG_T1;
	public String R10_TOT_RET_ASET_T1;
	public String R10_NON_PERF_PORT_T1;
	public String R10_NO_CON_LAST_T1;
	public String R10_TOT_BRANCH_T1;
	public String R10_TOT_REV_T2;
	public String R10_PROF_LOS_T2;
	public String R10_PROF_MARG_T2;
	public String R10_TOT_RET_ASET_T2;
	public String R10_NON_PERF_PORT_T2;
	public String R10_NO_CON_LAST_T2;
	public String R10_TOT_BRANCH_T2;
	public String R10_TOT_REV_T3;
	public String R10_PROF_LOS_T3;
	public String R10_PROF_MARG_T3;
	public String R10_TOT_RET_ASET_T3;
	public String R10_NON_PERF_PORT_T3;
	public String R10_NO_CON_LAST_T3;
	public String R10_TOT_BRANCH_T3;
	public String R10_NPL_SPD;
	public String R10_RECO_NPL_SPD;
	public String R10_NO_CON_ONBO_DIGI;
	public String R10_NO_ACCS_AML;
	public String R10_TOT_ACC_LOAN_AML;
	public String R10_TOT_NEW_ACCS_SPD;
	public String R10_TOT_VALS_LOANS_SPD;
	public String R10_NO_INQ_WEBMOB;
	public String R10_NO_INQ_TRAD;
	public String R10_NO_RET_POS;
	public String R10_AMT_POS_GATE;
	public String R10_NO_TRAN_SVF_BNK;
	public String R10_AMT_RET_SVF_BNK;
	public String R10_TOT_WEB_MOB_VIRT;
	public String R10_VAL_UNCL_SVF;
	public String R10_NO_CON_LOW_RSK;
	public String R10_NO_CON_HIGH_RSK;
	public String R11_BANK;
	public String R11_PRODUCT;
	public String R11_RET_ASET_LTS;
	public String R11_RET_ASET_LTSME;
	public String R11_RET_ASET_SME_GUR;
	public String R11_RET_LOAN_DIS;
	public String R11_RET_ASET_LOAN_SME;
	public String R11_PER_LOAN_WEB;
	public String R11_LOAN_SME_WEB_MOB;
	public String R11_NO_COMPDIGI_MOB;
	public String R11_NO_COMP_TRADCALL;
	public String R11_PER_COMPDIGI_WEB;
	public String R11_PER_COM_TRADCALL;
	public String R11_TOT_REV_PREV;
	public String R11_PROF_LOSS_PREV;
	public String R11_PROF_MARG_PORTFOLIO;
	public String R11_TOT_RET_ASET_PREV;
	public String R11_NP_LOAN_PREV;
	public String R11_NON_CON_ONLAST_PREV;
	public String R11_TOT_BRAN_PREV;
	public String R11_TOT_REV_RET_CUR;
	public String R11_PROF_LOS_PORT_CUR;
	public String R11_PROF_MARG_PERC_CUR;
	public String R11_TOT_RET_ASET_CUR;
	public String R11_NON_PER_RET_PORT_CUR;
	public String R11_NO_CON_LAST_CUR;
	public String R11_TOT_BRANCH_CUR;
	public String R11_TOT_REV_T1;
	public String R11_PROF_LOS_T1;
	public String R11_PROF_MARG_T1;
	public String R11_TOT_RET_ASET_T1;
	public String R11_NON_PERF_PORT_T1;
	public String R11_NO_CON_LAST_T1;
	public String R11_TOT_BRANCH_T1;
	public String R11_TOT_REV_T2;
	public String R11_PROF_LOS_T2;
	public String R11_PROF_MARG_T2;
	public String R11_TOT_RET_ASET_T2;
	public String R11_NON_PERF_PORT_T2;
	public String R11_NO_CON_LAST_T2;
	public String R11_TOT_BRANCH_T2;
	public String R11_TOT_REV_T3;
	public String R11_PROF_LOS_T3;
	public String R11_PROF_MARG_T3;
	public String R11_TOT_RET_ASET_T3;
	public String R11_NON_PERF_PORT_T3;
	public String R11_NO_CON_LAST_T3;
	public String R11_TOT_BRANCH_T3;
	public String R11_NPL_SPD;
	public String R11_RECO_NPL_SPD;
	public String R11_NO_CON_ONBO_DIGI;
	public String R11_NO_ACCS_AML;
	public String R11_TOT_ACC_LOAN_AML;
	public String R11_TOT_NEW_ACCS_SPD;
	public String R11_TOT_VALS_LOANS_SPD;
	public String R11_NO_INQ_WEBMOB;
	public String R11_NO_INQ_TRAD;
	public String R11_NO_RET_POS;
	public String R11_AMT_POS_GATE;
	public String R11_NO_TRAN_SVF_BNK;
	public String R11_AMT_RET_SVF_BNK;
	public String R11_TOT_WEB_MOB_VIRT;
	public String R11_VAL_UNCL_SVF;
	public String R11_NO_CON_LOW_RSK;
	public String R11_NO_CON_HIGH_RSK;
	public String R12_BANK;
	public String R12_PRODUCT;
	public String R12_RET_ASET_LTS;
	public String R12_RET_ASET_LTSME;
	public String R12_RET_ASET_SME_GUR;
	public String R12_RET_LOAN_DIS;
	public String R12_RET_ASET_LOAN_SME;
	public String R12_PER_LOAN_WEB;
	public String R12_LOAN_SME_WEB_MOB;
	public String R12_NO_COMPDIGI_MOB;
	public String R12_NO_COMP_TRADCALL;
	public String R12_PER_COMPDIGI_WEB;
	public String R12_PER_COM_TRADCALL;
	public String R12_TOT_REV_PREV;
	public String R12_PROF_LOSS_PREV;
	public String R12_PROF_MARG_PORTFOLIO;
	public String R12_TOT_RET_ASET_PREV;
	public String R12_NP_LOAN_PREV;
	public String R12_NON_CON_ONLAST_PREV;
	public String R12_TOT_BRAN_PREV;
	public String R12_TOT_REV_RET_CUR;
	public String R12_PROF_LOS_PORT_CUR;
	public String R12_PROF_MARG_PERC_CUR;
	public String R12_TOT_RET_ASET_CUR;
	public String R12_NON_PER_RET_PORT_CUR;
	public String R12_NO_CON_LAST_CUR;
	public String R12_TOT_BRANCH_CUR;
	public String R12_TOT_REV_T1;
	public String R12_PROF_LOS_T1;
	public String R12_PROF_MARG_T1;
	public String R12_TOT_RET_ASET_T1;
	public String R12_NON_PERF_PORT_T1;
	public String R12_NO_CON_LAST_T1;
	public String R12_TOT_BRANCH_T1;
	public String R12_TOT_REV_T2;
	public String R12_PROF_LOS_T2;
	public String R12_PROF_MARG_T2;
	public String R12_TOT_RET_ASET_T2;
	public String R12_NON_PERF_PORT_T2;
	public String R12_NO_CON_LAST_T2;
	public String R12_TOT_BRANCH_T2;
	public String R12_TOT_REV_T3;
	public String R12_PROF_LOS_T3;
	public String R12_PROF_MARG_T3;
	public String R12_TOT_RET_ASET_T3;
	public String R12_NON_PERF_PORT_T3;
	public String R12_NO_CON_LAST_T3;
	public String R12_TOT_BRANCH_T3;
	public String R12_NPL_SPD;
	public String R12_RECO_NPL_SPD;
	public String R12_NO_CON_ONBO_DIGI;
	public String R12_NO_ACCS_AML;
	public String R12_TOT_ACC_LOAN_AML;
	public String R12_TOT_NEW_ACCS_SPD;
	public String R12_TOT_VALS_LOANS_SPD;
	public String R12_NO_INQ_WEBMOB;
	public String R12_NO_INQ_TRAD;
	public String R12_NO_RET_POS;
	public String R12_AMT_POS_GATE;
	public String R12_NO_TRAN_SVF_BNK;
	public String R12_AMT_RET_SVF_BNK;
	public String R12_TOT_WEB_MOB_VIRT;
	public String R12_VAL_UNCL_SVF;
	public String R12_NO_CON_LOW_RSK;
	public String R12_NO_CON_HIGH_RSK;
	public String R13_BANK;
	public String R13_PRODUCT;
	public String R13_RET_ASET_LTS;
	public String R13_RET_ASET_LTSME;
	public String R13_RET_ASET_SME_GUR;
	public String R13_RET_LOAN_DIS;
	public String R13_RET_ASET_LOAN_SME;
	public String R13_PER_LOAN_WEB;
	public String R13_LOAN_SME_WEB_MOB;
	public String R13_NO_COMPDIGI_MOB;
	public String R13_NO_COMP_TRADCALL;
	public String R13_PER_COMPDIGI_WEB;
	public String R13_PER_COM_TRADCALL;
	public String R13_TOT_REV_PREV;
	public String R13_PROF_LOSS_PREV;
	public String R13_PROF_MARG_PORTFOLIO;
	public String R13_TOT_RET_ASET_PREV;
	public String R13_NP_LOAN_PREV;
	public String R13_NON_CON_ONLAST_PREV;
	public String R13_TOT_BRAN_PREV;
	public String R13_TOT_REV_RET_CUR;
	public String R13_PROF_LOS_PORT_CUR;
	public String R13_PROF_MARG_PERC_CUR;
	public String R13_TOT_RET_ASET_CUR;
	public String R13_NON_PER_RET_PORT_CUR;
	public String R13_NO_CON_LAST_CUR;
	public String R13_TOT_BRANCH_CUR;
	public String R13_TOT_REV_T1;
	public String R13_PROF_LOS_T1;
	public String R13_PROF_MARG_T1;
	public String R13_TOT_RET_ASET_T1;
	public String R13_NON_PERF_PORT_T1;
	public String R13_NO_CON_LAST_T1;
	public String R13_TOT_BRANCH_T1;
	public String R13_TOT_REV_T2;
	public String R13_PROF_LOS_T2;
	public String R13_PROF_MARG_T2;
	public String R13_TOT_RET_ASET_T2;
	public String R13_NON_PERF_PORT_T2;
	public String R13_NO_CON_LAST_T2;
	public String R13_TOT_BRANCH_T2;
	public String R13_TOT_REV_T3;
	public String R13_PROF_LOS_T3;
	public String R13_PROF_MARG_T3;
	public String R13_TOT_RET_ASET_T3;
	public String R13_NON_PERF_PORT_T3;
	public String R13_NO_CON_LAST_T3;
	public String R13_TOT_BRANCH_T3;
	public String R13_NPL_SPD;
	public String R13_RECO_NPL_SPD;
	public String R13_NO_CON_ONBO_DIGI;
	public String R13_NO_ACCS_AML;
	public String R13_TOT_ACC_LOAN_AML;
	public String R13_TOT_NEW_ACCS_SPD;
	public String R13_TOT_VALS_LOANS_SPD;
	public String R13_NO_INQ_WEBMOB;
	public String R13_NO_INQ_TRAD;
	public String R13_NO_RET_POS;
	public String R13_AMT_POS_GATE;
	public String R13_NO_TRAN_SVF_BNK;
	public String R13_AMT_RET_SVF_BNK;
	public String R13_TOT_WEB_MOB_VIRT;
	public String R13_VAL_UNCL_SVF;
	public String R13_NO_CON_LOW_RSK;
	public String R13_NO_CON_HIGH_RSK;
	public String R14_BANK;
	public String R14_PRODUCT;
	public String R14_RET_ASET_LTS;
	public String R14_RET_ASET_LTSME;
	public String R14_RET_ASET_SME_GUR;
	public String R14_RET_LOAN_DIS;
	public String R14_RET_ASET_LOAN_SME;
	public String R14_PER_LOAN_WEB;
	public String R14_LOAN_SME_WEB_MOB;
	public String R14_NO_COMPDIGI_MOB;
	public String R14_NO_COMP_TRADCALL;
	public String R14_PER_COMPDIGI_WEB;
	public String R14_PER_COM_TRADCALL;
	public String R14_TOT_REV_PREV;
	public String R14_PROF_LOSS_PREV;
	public String R14_PROF_MARG_PORTFOLIO;
	public String R14_TOT_RET_ASET_PREV;
	public String R14_NP_LOAN_PREV;
	public String R14_NON_CON_ONLAST_PREV;
	public String R14_TOT_BRAN_PREV;
	public String R14_TOT_REV_RET_CUR;
	public String R14_PROF_LOS_PORT_CUR;
	public String R14_PROF_MARG_PERC_CUR;
	public String R14_TOT_RET_ASET_CUR;
	public String R14_NON_PER_RET_PORT_CUR;
	public String R14_NO_CON_LAST_CUR;
	public String R14_TOT_BRANCH_CUR;
	public String R14_TOT_REV_T1;
	public String R14_PROF_LOS_T1;
	public String R14_PROF_MARG_T1;
	public String R14_TOT_RET_ASET_T1;
	public String R14_NON_PERF_PORT_T1;
	public String R14_NO_CON_LAST_T1;
	public String R14_TOT_BRANCH_T1;
	public String R14_TOT_REV_T2;
	public String R14_PROF_LOS_T2;
	public String R14_PROF_MARG_T2;
	public String R14_TOT_RET_ASET_T2;
	public String R14_NON_PERF_PORT_T2;
	public String R14_NO_CON_LAST_T2;
	public String R14_TOT_BRANCH_T2;
	public String R14_TOT_REV_T3;
	public String R14_PROF_LOS_T3;
	public String R14_PROF_MARG_T3;
	public String R14_TOT_RET_ASET_T3;
	public String R14_NON_PERF_PORT_T3;
	public String R14_NO_CON_LAST_T3;
	public String R14_TOT_BRANCH_T3;
	public String R14_NPL_SPD;
	public String R14_RECO_NPL_SPD;
	public String R14_NO_CON_ONBO_DIGI;
	public String R14_NO_ACCS_AML;
	public String R14_TOT_ACC_LOAN_AML;
	public String R14_TOT_NEW_ACCS_SPD;
	public String R14_TOT_VALS_LOANS_SPD;
	public String R14_NO_INQ_WEBMOB;
	public String R14_NO_INQ_TRAD;
	public String R14_NO_RET_POS;
	public String R14_AMT_POS_GATE;
	public String R14_NO_TRAN_SVF_BNK;
	public String R14_AMT_RET_SVF_BNK;
	public String R14_TOT_WEB_MOB_VIRT;
	public String R14_VAL_UNCL_SVF;
	public String R14_NO_CON_LOW_RSK;
	public String R14_NO_CON_HIGH_RSK;
	public String R15_BANK;
	public String R15_PRODUCT;
	public String R15_RET_ASET_LTS;
	public String R15_RET_ASET_LTSME;
	public String R15_RET_ASET_SME_GUR;
	public String R15_RET_LOAN_DIS;
	public String R15_RET_ASET_LOAN_SME;
	public String R15_PER_LOAN_WEB;
	public String R15_LOAN_SME_WEB_MOB;
	public String R15_NO_COMPDIGI_MOB;
	public String R15_NO_COMP_TRADCALL;
	public String R15_PER_COMPDIGI_WEB;
	public String R15_PER_COM_TRADCALL;
	public String R15_TOT_REV_PREV;
	public String R15_PROF_LOSS_PREV;
	public String R15_PROF_MARG_PORTFOLIO;
	public String R15_TOT_RET_ASET_PREV;
	public String R15_NP_LOAN_PREV;
	public String R15_NON_CON_ONLAST_PREV;
	public String R15_TOT_BRAN_PREV;
	public String R15_TOT_REV_RET_CUR;
	public String R15_PROF_LOS_PORT_CUR;
	public String R15_PROF_MARG_PERC_CUR;
	public String R15_TOT_RET_ASET_CUR;
	public String R15_NON_PER_RET_PORT_CUR;
	public String R15_NO_CON_LAST_CUR;
	public String R15_TOT_BRANCH_CUR;
	public String R15_TOT_REV_T1;
	public String R15_PROF_LOS_T1;
	public String R15_PROF_MARG_T1;
	public String R15_TOT_RET_ASET_T1;
	public String R15_NON_PERF_PORT_T1;
	public String R15_NO_CON_LAST_T1;
	public String R15_TOT_BRANCH_T1;
	public String R15_TOT_REV_T2;
	public String R15_PROF_LOS_T2;
	public String R15_PROF_MARG_T2;
	public String R15_TOT_RET_ASET_T2;
	public String R15_NON_PERF_PORT_T2;
	public String R15_NO_CON_LAST_T2;
	public String R15_TOT_BRANCH_T2;
	public String R15_TOT_REV_T3;
	public String R15_PROF_LOS_T3;
	public String R15_PROF_MARG_T3;
	public String R15_TOT_RET_ASET_T3;
	public String R15_NON_PERF_PORT_T3;
	public String R15_NO_CON_LAST_T3;
	public String R15_TOT_BRANCH_T3;
	public String R15_NPL_SPD;
	public String R15_RECO_NPL_SPD;
	public String R15_NO_CON_ONBO_DIGI;
	public String R15_NO_ACCS_AML;
	public String R15_TOT_ACC_LOAN_AML;
	public String R15_TOT_NEW_ACCS_SPD;
	public String R15_TOT_VALS_LOANS_SPD;
	public String R15_NO_INQ_WEBMOB;
	public String R15_NO_INQ_TRAD;
	public String R15_NO_RET_POS;
	public String R15_AMT_POS_GATE;
	public String R15_NO_TRAN_SVF_BNK;
	public String R15_AMT_RET_SVF_BNK;
	public String R15_TOT_WEB_MOB_VIRT;
	public String R15_VAL_UNCL_SVF;
	public String R15_NO_CON_LOW_RSK;
	public String R15_NO_CON_HIGH_RSK;
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

	public String getR7_RET_ASET_LTS() {
		return R7_RET_ASET_LTS;
	}

	public void setR7_RET_ASET_LTS(String r7_RET_ASET_LTS) {
		R7_RET_ASET_LTS = r7_RET_ASET_LTS;
	}

	public String getR7_RET_ASET_LTSME() {
		return R7_RET_ASET_LTSME;
	}

	public void setR7_RET_ASET_LTSME(String r7_RET_ASET_LTSME) {
		R7_RET_ASET_LTSME = r7_RET_ASET_LTSME;
	}

	public String getR7_RET_ASET_SME_GUR() {
		return R7_RET_ASET_SME_GUR;
	}

	public void setR7_RET_ASET_SME_GUR(String r7_RET_ASET_SME_GUR) {
		R7_RET_ASET_SME_GUR = r7_RET_ASET_SME_GUR;
	}

	public String getR7_RET_LOAN_DIS() {
		return R7_RET_LOAN_DIS;
	}

	public void setR7_RET_LOAN_DIS(String r7_RET_LOAN_DIS) {
		R7_RET_LOAN_DIS = r7_RET_LOAN_DIS;
	}

	public String getR7_RET_ASET_LOAN_SME() {
		return R7_RET_ASET_LOAN_SME;
	}

	public void setR7_RET_ASET_LOAN_SME(String r7_RET_ASET_LOAN_SME) {
		R7_RET_ASET_LOAN_SME = r7_RET_ASET_LOAN_SME;
	}

	public String getR7_PER_LOAN_WEB() {
		return R7_PER_LOAN_WEB;
	}

	public void setR7_PER_LOAN_WEB(String r7_PER_LOAN_WEB) {
		R7_PER_LOAN_WEB = r7_PER_LOAN_WEB;
	}

	public String getR7_LOAN_SME_WEB_MOB() {
		return R7_LOAN_SME_WEB_MOB;
	}

	public void setR7_LOAN_SME_WEB_MOB(String r7_LOAN_SME_WEB_MOB) {
		R7_LOAN_SME_WEB_MOB = r7_LOAN_SME_WEB_MOB;
	}

	public String getR7_NO_COMPDIGI_MOB() {
		return R7_NO_COMPDIGI_MOB;
	}

	public void setR7_NO_COMPDIGI_MOB(String r7_NO_COMPDIGI_MOB) {
		R7_NO_COMPDIGI_MOB = r7_NO_COMPDIGI_MOB;
	}

	public String getR7_NO_COMP_TRADCALL() {
		return R7_NO_COMP_TRADCALL;
	}

	public void setR7_NO_COMP_TRADCALL(String r7_NO_COMP_TRADCALL) {
		R7_NO_COMP_TRADCALL = r7_NO_COMP_TRADCALL;
	}

	public String getR7_PER_COMPDIGI_WEB() {
		return R7_PER_COMPDIGI_WEB;
	}

	public void setR7_PER_COMPDIGI_WEB(String r7_PER_COMPDIGI_WEB) {
		R7_PER_COMPDIGI_WEB = r7_PER_COMPDIGI_WEB;
	}

	public String getR7_PER_COM_TRADCALL() {
		return R7_PER_COM_TRADCALL;
	}

	public void setR7_PER_COM_TRADCALL(String r7_PER_COM_TRADCALL) {
		R7_PER_COM_TRADCALL = r7_PER_COM_TRADCALL;
	}

	public String getR7_TOT_REV_PREV() {
		return R7_TOT_REV_PREV;
	}

	public void setR7_TOT_REV_PREV(String r7_TOT_REV_PREV) {
		R7_TOT_REV_PREV = r7_TOT_REV_PREV;
	}

	public String getR7_PROF_LOSS_PREV() {
		return R7_PROF_LOSS_PREV;
	}

	public void setR7_PROF_LOSS_PREV(String r7_PROF_LOSS_PREV) {
		R7_PROF_LOSS_PREV = r7_PROF_LOSS_PREV;
	}

	public String getR7_PROF_MARG_PORTFOLIO() {
		return R7_PROF_MARG_PORTFOLIO;
	}

	public void setR7_PROF_MARG_PORTFOLIO(String r7_PROF_MARG_PORTFOLIO) {
		R7_PROF_MARG_PORTFOLIO = r7_PROF_MARG_PORTFOLIO;
	}

	public String getR7_TOT_RET_ASET_PREV() {
		return R7_TOT_RET_ASET_PREV;
	}

	public void setR7_TOT_RET_ASET_PREV(String r7_TOT_RET_ASET_PREV) {
		R7_TOT_RET_ASET_PREV = r7_TOT_RET_ASET_PREV;
	}

	public String getR7_NP_LOAN_PREV() {
		return R7_NP_LOAN_PREV;
	}

	public void setR7_NP_LOAN_PREV(String r7_NP_LOAN_PREV) {
		R7_NP_LOAN_PREV = r7_NP_LOAN_PREV;
	}

	public String getR7_NON_CON_ONLAST_PREV() {
		return R7_NON_CON_ONLAST_PREV;
	}

	public void setR7_NON_CON_ONLAST_PREV(String r7_NON_CON_ONLAST_PREV) {
		R7_NON_CON_ONLAST_PREV = r7_NON_CON_ONLAST_PREV;
	}

	public String getR7_TOT_BRAN_PREV() {
		return R7_TOT_BRAN_PREV;
	}

	public void setR7_TOT_BRAN_PREV(String r7_TOT_BRAN_PREV) {
		R7_TOT_BRAN_PREV = r7_TOT_BRAN_PREV;
	}

	public String getR7_TOT_REV_RET_CUR() {
		return R7_TOT_REV_RET_CUR;
	}

	public void setR7_TOT_REV_RET_CUR(String r7_TOT_REV_RET_CUR) {
		R7_TOT_REV_RET_CUR = r7_TOT_REV_RET_CUR;
	}

	public String getR7_PROF_LOS_PORT_CUR() {
		return R7_PROF_LOS_PORT_CUR;
	}

	public void setR7_PROF_LOS_PORT_CUR(String r7_PROF_LOS_PORT_CUR) {
		R7_PROF_LOS_PORT_CUR = r7_PROF_LOS_PORT_CUR;
	}

	public String getR7_PROF_MARG_PERC_CUR() {
		return R7_PROF_MARG_PERC_CUR;
	}

	public void setR7_PROF_MARG_PERC_CUR(String r7_PROF_MARG_PERC_CUR) {
		R7_PROF_MARG_PERC_CUR = r7_PROF_MARG_PERC_CUR;
	}

	public String getR7_TOT_RET_ASET_CUR() {
		return R7_TOT_RET_ASET_CUR;
	}

	public void setR7_TOT_RET_ASET_CUR(String r7_TOT_RET_ASET_CUR) {
		R7_TOT_RET_ASET_CUR = r7_TOT_RET_ASET_CUR;
	}

	public String getR7_NON_PER_RET_PORT_CUR() {
		return R7_NON_PER_RET_PORT_CUR;
	}

	public void setR7_NON_PER_RET_PORT_CUR(String r7_NON_PER_RET_PORT_CUR) {
		R7_NON_PER_RET_PORT_CUR = r7_NON_PER_RET_PORT_CUR;
	}

	public String getR7_NO_CON_LAST_CUR() {
		return R7_NO_CON_LAST_CUR;
	}

	public void setR7_NO_CON_LAST_CUR(String r7_NO_CON_LAST_CUR) {
		R7_NO_CON_LAST_CUR = r7_NO_CON_LAST_CUR;
	}

	public String getR7_TOT_BRANCH_CUR() {
		return R7_TOT_BRANCH_CUR;
	}

	public void setR7_TOT_BRANCH_CUR(String r7_TOT_BRANCH_CUR) {
		R7_TOT_BRANCH_CUR = r7_TOT_BRANCH_CUR;
	}

	public String getR7_TOT_REV_T1() {
		return R7_TOT_REV_T1;
	}

	public void setR7_TOT_REV_T1(String r7_TOT_REV_T1) {
		R7_TOT_REV_T1 = r7_TOT_REV_T1;
	}

	public String getR7_PROF_LOS_T1() {
		return R7_PROF_LOS_T1;
	}

	public void setR7_PROF_LOS_T1(String r7_PROF_LOS_T1) {
		R7_PROF_LOS_T1 = r7_PROF_LOS_T1;
	}

	public String getR7_PROF_MARG_T1() {
		return R7_PROF_MARG_T1;
	}

	public void setR7_PROF_MARG_T1(String r7_PROF_MARG_T1) {
		R7_PROF_MARG_T1 = r7_PROF_MARG_T1;
	}

	public String getR7_TOT_RET_ASET_T1() {
		return R7_TOT_RET_ASET_T1;
	}

	public void setR7_TOT_RET_ASET_T1(String r7_TOT_RET_ASET_T1) {
		R7_TOT_RET_ASET_T1 = r7_TOT_RET_ASET_T1;
	}

	public String getR7_NON_PERF_PORT_T1() {
		return R7_NON_PERF_PORT_T1;
	}

	public void setR7_NON_PERF_PORT_T1(String r7_NON_PERF_PORT_T1) {
		R7_NON_PERF_PORT_T1 = r7_NON_PERF_PORT_T1;
	}

	public String getR7_NO_CON_LAST_T1() {
		return R7_NO_CON_LAST_T1;
	}

	public void setR7_NO_CON_LAST_T1(String r7_NO_CON_LAST_T1) {
		R7_NO_CON_LAST_T1 = r7_NO_CON_LAST_T1;
	}

	public String getR7_TOT_BRANCH_T1() {
		return R7_TOT_BRANCH_T1;
	}

	public void setR7_TOT_BRANCH_T1(String r7_TOT_BRANCH_T1) {
		R7_TOT_BRANCH_T1 = r7_TOT_BRANCH_T1;
	}

	public String getR7_TOT_REV_T2() {
		return R7_TOT_REV_T2;
	}

	public void setR7_TOT_REV_T2(String r7_TOT_REV_T2) {
		R7_TOT_REV_T2 = r7_TOT_REV_T2;
	}

	public String getR7_PROF_LOS_T2() {
		return R7_PROF_LOS_T2;
	}

	public void setR7_PROF_LOS_T2(String r7_PROF_LOS_T2) {
		R7_PROF_LOS_T2 = r7_PROF_LOS_T2;
	}

	public String getR7_PROF_MARG_T2() {
		return R7_PROF_MARG_T2;
	}

	public void setR7_PROF_MARG_T2(String r7_PROF_MARG_T2) {
		R7_PROF_MARG_T2 = r7_PROF_MARG_T2;
	}

	public String getR7_TOT_RET_ASET_T2() {
		return R7_TOT_RET_ASET_T2;
	}

	public void setR7_TOT_RET_ASET_T2(String r7_TOT_RET_ASET_T2) {
		R7_TOT_RET_ASET_T2 = r7_TOT_RET_ASET_T2;
	}

	public String getR7_NON_PERF_PORT_T2() {
		return R7_NON_PERF_PORT_T2;
	}

	public void setR7_NON_PERF_PORT_T2(String r7_NON_PERF_PORT_T2) {
		R7_NON_PERF_PORT_T2 = r7_NON_PERF_PORT_T2;
	}

	public String getR7_NO_CON_LAST_T2() {
		return R7_NO_CON_LAST_T2;
	}

	public void setR7_NO_CON_LAST_T2(String r7_NO_CON_LAST_T2) {
		R7_NO_CON_LAST_T2 = r7_NO_CON_LAST_T2;
	}

	public String getR7_TOT_BRANCH_T2() {
		return R7_TOT_BRANCH_T2;
	}

	public void setR7_TOT_BRANCH_T2(String r7_TOT_BRANCH_T2) {
		R7_TOT_BRANCH_T2 = r7_TOT_BRANCH_T2;
	}

	public String getR7_TOT_REV_T3() {
		return R7_TOT_REV_T3;
	}

	public void setR7_TOT_REV_T3(String r7_TOT_REV_T3) {
		R7_TOT_REV_T3 = r7_TOT_REV_T3;
	}

	public String getR7_PROF_LOS_T3() {
		return R7_PROF_LOS_T3;
	}

	public void setR7_PROF_LOS_T3(String r7_PROF_LOS_T3) {
		R7_PROF_LOS_T3 = r7_PROF_LOS_T3;
	}

	public String getR7_PROF_MARG_T3() {
		return R7_PROF_MARG_T3;
	}

	public void setR7_PROF_MARG_T3(String r7_PROF_MARG_T3) {
		R7_PROF_MARG_T3 = r7_PROF_MARG_T3;
	}

	public String getR7_TOT_RET_ASET_T3() {
		return R7_TOT_RET_ASET_T3;
	}

	public void setR7_TOT_RET_ASET_T3(String r7_TOT_RET_ASET_T3) {
		R7_TOT_RET_ASET_T3 = r7_TOT_RET_ASET_T3;
	}

	public String getR7_NON_PERF_PORT_T3() {
		return R7_NON_PERF_PORT_T3;
	}

	public void setR7_NON_PERF_PORT_T3(String r7_NON_PERF_PORT_T3) {
		R7_NON_PERF_PORT_T3 = r7_NON_PERF_PORT_T3;
	}

	public String getR7_NO_CON_LAST_T3() {
		return R7_NO_CON_LAST_T3;
	}

	public void setR7_NO_CON_LAST_T3(String r7_NO_CON_LAST_T3) {
		R7_NO_CON_LAST_T3 = r7_NO_CON_LAST_T3;
	}

	public String getR7_TOT_BRANCH_T3() {
		return R7_TOT_BRANCH_T3;
	}

	public void setR7_TOT_BRANCH_T3(String r7_TOT_BRANCH_T3) {
		R7_TOT_BRANCH_T3 = r7_TOT_BRANCH_T3;
	}

	public String getR7_NPL_SPD() {
		return R7_NPL_SPD;
	}

	public void setR7_NPL_SPD(String r7_NPL_SPD) {
		R7_NPL_SPD = r7_NPL_SPD;
	}

	public String getR7_RECO_NPL_SPD() {
		return R7_RECO_NPL_SPD;
	}

	public void setR7_RECO_NPL_SPD(String r7_RECO_NPL_SPD) {
		R7_RECO_NPL_SPD = r7_RECO_NPL_SPD;
	}

	public String getR7_NO_CON_ONBO_DIGI() {
		return R7_NO_CON_ONBO_DIGI;
	}

	public void setR7_NO_CON_ONBO_DIGI(String r7_NO_CON_ONBO_DIGI) {
		R7_NO_CON_ONBO_DIGI = r7_NO_CON_ONBO_DIGI;
	}

	public String getR7_NO_ACCS_AML() {
		return R7_NO_ACCS_AML;
	}

	public void setR7_NO_ACCS_AML(String r7_NO_ACCS_AML) {
		R7_NO_ACCS_AML = r7_NO_ACCS_AML;
	}

	public String getR7_TOT_ACC_LOAN_AML() {
		return R7_TOT_ACC_LOAN_AML;
	}

	public void setR7_TOT_ACC_LOAN_AML(String r7_TOT_ACC_LOAN_AML) {
		R7_TOT_ACC_LOAN_AML = r7_TOT_ACC_LOAN_AML;
	}

	public String getR7_TOT_NEW_ACCS_SPD() {
		return R7_TOT_NEW_ACCS_SPD;
	}

	public void setR7_TOT_NEW_ACCS_SPD(String r7_TOT_NEW_ACCS_SPD) {
		R7_TOT_NEW_ACCS_SPD = r7_TOT_NEW_ACCS_SPD;
	}

	public String getR7_TOT_VALS_LOANS_SPD() {
		return R7_TOT_VALS_LOANS_SPD;
	}

	public void setR7_TOT_VALS_LOANS_SPD(String r7_TOT_VALS_LOANS_SPD) {
		R7_TOT_VALS_LOANS_SPD = r7_TOT_VALS_LOANS_SPD;
	}

	public String getR7_NO_INQ_WEBMOB() {
		return R7_NO_INQ_WEBMOB;
	}

	public void setR7_NO_INQ_WEBMOB(String r7_NO_INQ_WEBMOB) {
		R7_NO_INQ_WEBMOB = r7_NO_INQ_WEBMOB;
	}

	public String getR7_NO_INQ_TRAD() {
		return R7_NO_INQ_TRAD;
	}

	public void setR7_NO_INQ_TRAD(String r7_NO_INQ_TRAD) {
		R7_NO_INQ_TRAD = r7_NO_INQ_TRAD;
	}

	public String getR7_NO_RET_POS() {
		return R7_NO_RET_POS;
	}

	public void setR7_NO_RET_POS(String r7_NO_RET_POS) {
		R7_NO_RET_POS = r7_NO_RET_POS;
	}

	public String getR7_AMT_POS_GATE() {
		return R7_AMT_POS_GATE;
	}

	public void setR7_AMT_POS_GATE(String r7_AMT_POS_GATE) {
		R7_AMT_POS_GATE = r7_AMT_POS_GATE;
	}

	public String getR7_NO_TRAN_SVF_BNK() {
		return R7_NO_TRAN_SVF_BNK;
	}

	public void setR7_NO_TRAN_SVF_BNK(String r7_NO_TRAN_SVF_BNK) {
		R7_NO_TRAN_SVF_BNK = r7_NO_TRAN_SVF_BNK;
	}

	public String getR7_AMT_RET_SVF_BNK() {
		return R7_AMT_RET_SVF_BNK;
	}

	public void setR7_AMT_RET_SVF_BNK(String r7_AMT_RET_SVF_BNK) {
		R7_AMT_RET_SVF_BNK = r7_AMT_RET_SVF_BNK;
	}

	public String getR7_TOT_WEB_MOB_VIRT() {
		return R7_TOT_WEB_MOB_VIRT;
	}

	public void setR7_TOT_WEB_MOB_VIRT(String r7_TOT_WEB_MOB_VIRT) {
		R7_TOT_WEB_MOB_VIRT = r7_TOT_WEB_MOB_VIRT;
	}

	public String getR7_VAL_UNCL_SVF() {
		return R7_VAL_UNCL_SVF;
	}

	public void setR7_VAL_UNCL_SVF(String r7_VAL_UNCL_SVF) {
		R7_VAL_UNCL_SVF = r7_VAL_UNCL_SVF;
	}

	public String getR7_NO_CON_LOW_RSK() {
		return R7_NO_CON_LOW_RSK;
	}

	public void setR7_NO_CON_LOW_RSK(String r7_NO_CON_LOW_RSK) {
		R7_NO_CON_LOW_RSK = r7_NO_CON_LOW_RSK;
	}

	public String getR7_NO_CON_HIGH_RSK() {
		return R7_NO_CON_HIGH_RSK;
	}

	public void setR7_NO_CON_HIGH_RSK(String r7_NO_CON_HIGH_RSK) {
		R7_NO_CON_HIGH_RSK = r7_NO_CON_HIGH_RSK;
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

	public String getR8_RET_ASET_LTS() {
		return R8_RET_ASET_LTS;
	}

	public void setR8_RET_ASET_LTS(String r8_RET_ASET_LTS) {
		R8_RET_ASET_LTS = r8_RET_ASET_LTS;
	}

	public String getR8_RET_ASET_LTSME() {
		return R8_RET_ASET_LTSME;
	}

	public void setR8_RET_ASET_LTSME(String r8_RET_ASET_LTSME) {
		R8_RET_ASET_LTSME = r8_RET_ASET_LTSME;
	}

	public String getR8_RET_ASET_SME_GUR() {
		return R8_RET_ASET_SME_GUR;
	}

	public void setR8_RET_ASET_SME_GUR(String r8_RET_ASET_SME_GUR) {
		R8_RET_ASET_SME_GUR = r8_RET_ASET_SME_GUR;
	}

	public String getR8_RET_LOAN_DIS() {
		return R8_RET_LOAN_DIS;
	}

	public void setR8_RET_LOAN_DIS(String r8_RET_LOAN_DIS) {
		R8_RET_LOAN_DIS = r8_RET_LOAN_DIS;
	}

	public String getR8_RET_ASET_LOAN_SME() {
		return R8_RET_ASET_LOAN_SME;
	}

	public void setR8_RET_ASET_LOAN_SME(String r8_RET_ASET_LOAN_SME) {
		R8_RET_ASET_LOAN_SME = r8_RET_ASET_LOAN_SME;
	}

	public String getR8_PER_LOAN_WEB() {
		return R8_PER_LOAN_WEB;
	}

	public void setR8_PER_LOAN_WEB(String r8_PER_LOAN_WEB) {
		R8_PER_LOAN_WEB = r8_PER_LOAN_WEB;
	}

	public String getR8_LOAN_SME_WEB_MOB() {
		return R8_LOAN_SME_WEB_MOB;
	}

	public void setR8_LOAN_SME_WEB_MOB(String r8_LOAN_SME_WEB_MOB) {
		R8_LOAN_SME_WEB_MOB = r8_LOAN_SME_WEB_MOB;
	}

	public String getR8_NO_COMPDIGI_MOB() {
		return R8_NO_COMPDIGI_MOB;
	}

	public void setR8_NO_COMPDIGI_MOB(String r8_NO_COMPDIGI_MOB) {
		R8_NO_COMPDIGI_MOB = r8_NO_COMPDIGI_MOB;
	}

	public String getR8_NO_COMP_TRADCALL() {
		return R8_NO_COMP_TRADCALL;
	}

	public void setR8_NO_COMP_TRADCALL(String r8_NO_COMP_TRADCALL) {
		R8_NO_COMP_TRADCALL = r8_NO_COMP_TRADCALL;
	}

	public String getR8_PER_COMPDIGI_WEB() {
		return R8_PER_COMPDIGI_WEB;
	}

	public void setR8_PER_COMPDIGI_WEB(String r8_PER_COMPDIGI_WEB) {
		R8_PER_COMPDIGI_WEB = r8_PER_COMPDIGI_WEB;
	}

	public String getR8_PER_COM_TRADCALL() {
		return R8_PER_COM_TRADCALL;
	}

	public void setR8_PER_COM_TRADCALL(String r8_PER_COM_TRADCALL) {
		R8_PER_COM_TRADCALL = r8_PER_COM_TRADCALL;
	}

	public String getR8_TOT_REV_PREV() {
		return R8_TOT_REV_PREV;
	}

	public void setR8_TOT_REV_PREV(String r8_TOT_REV_PREV) {
		R8_TOT_REV_PREV = r8_TOT_REV_PREV;
	}

	public String getR8_PROF_LOSS_PREV() {
		return R8_PROF_LOSS_PREV;
	}

	public void setR8_PROF_LOSS_PREV(String r8_PROF_LOSS_PREV) {
		R8_PROF_LOSS_PREV = r8_PROF_LOSS_PREV;
	}

	public String getR8_PROF_MARG_PORTFOLIO() {
		return R8_PROF_MARG_PORTFOLIO;
	}

	public void setR8_PROF_MARG_PORTFOLIO(String r8_PROF_MARG_PORTFOLIO) {
		R8_PROF_MARG_PORTFOLIO = r8_PROF_MARG_PORTFOLIO;
	}

	public String getR8_TOT_RET_ASET_PREV() {
		return R8_TOT_RET_ASET_PREV;
	}

	public void setR8_TOT_RET_ASET_PREV(String r8_TOT_RET_ASET_PREV) {
		R8_TOT_RET_ASET_PREV = r8_TOT_RET_ASET_PREV;
	}

	public String getR8_NP_LOAN_PREV() {
		return R8_NP_LOAN_PREV;
	}

	public void setR8_NP_LOAN_PREV(String r8_NP_LOAN_PREV) {
		R8_NP_LOAN_PREV = r8_NP_LOAN_PREV;
	}

	public String getR8_NON_CON_ONLAST_PREV() {
		return R8_NON_CON_ONLAST_PREV;
	}

	public void setR8_NON_CON_ONLAST_PREV(String r8_NON_CON_ONLAST_PREV) {
		R8_NON_CON_ONLAST_PREV = r8_NON_CON_ONLAST_PREV;
	}

	public String getR8_TOT_BRAN_PREV() {
		return R8_TOT_BRAN_PREV;
	}

	public void setR8_TOT_BRAN_PREV(String r8_TOT_BRAN_PREV) {
		R8_TOT_BRAN_PREV = r8_TOT_BRAN_PREV;
	}

	public String getR8_TOT_REV_RET_CUR() {
		return R8_TOT_REV_RET_CUR;
	}

	public void setR8_TOT_REV_RET_CUR(String r8_TOT_REV_RET_CUR) {
		R8_TOT_REV_RET_CUR = r8_TOT_REV_RET_CUR;
	}

	public String getR8_PROF_LOS_PORT_CUR() {
		return R8_PROF_LOS_PORT_CUR;
	}

	public void setR8_PROF_LOS_PORT_CUR(String r8_PROF_LOS_PORT_CUR) {
		R8_PROF_LOS_PORT_CUR = r8_PROF_LOS_PORT_CUR;
	}

	public String getR8_PROF_MARG_PERC_CUR() {
		return R8_PROF_MARG_PERC_CUR;
	}

	public void setR8_PROF_MARG_PERC_CUR(String r8_PROF_MARG_PERC_CUR) {
		R8_PROF_MARG_PERC_CUR = r8_PROF_MARG_PERC_CUR;
	}

	public String getR8_TOT_RET_ASET_CUR() {
		return R8_TOT_RET_ASET_CUR;
	}

	public void setR8_TOT_RET_ASET_CUR(String r8_TOT_RET_ASET_CUR) {
		R8_TOT_RET_ASET_CUR = r8_TOT_RET_ASET_CUR;
	}

	public String getR8_NON_PER_RET_PORT_CUR() {
		return R8_NON_PER_RET_PORT_CUR;
	}

	public void setR8_NON_PER_RET_PORT_CUR(String r8_NON_PER_RET_PORT_CUR) {
		R8_NON_PER_RET_PORT_CUR = r8_NON_PER_RET_PORT_CUR;
	}

	public String getR8_NO_CON_LAST_CUR() {
		return R8_NO_CON_LAST_CUR;
	}

	public void setR8_NO_CON_LAST_CUR(String r8_NO_CON_LAST_CUR) {
		R8_NO_CON_LAST_CUR = r8_NO_CON_LAST_CUR;
	}

	public String getR8_TOT_BRANCH_CUR() {
		return R8_TOT_BRANCH_CUR;
	}

	public void setR8_TOT_BRANCH_CUR(String r8_TOT_BRANCH_CUR) {
		R8_TOT_BRANCH_CUR = r8_TOT_BRANCH_CUR;
	}

	public String getR8_TOT_REV_T1() {
		return R8_TOT_REV_T1;
	}

	public void setR8_TOT_REV_T1(String r8_TOT_REV_T1) {
		R8_TOT_REV_T1 = r8_TOT_REV_T1;
	}

	public String getR8_PROF_LOS_T1() {
		return R8_PROF_LOS_T1;
	}

	public void setR8_PROF_LOS_T1(String r8_PROF_LOS_T1) {
		R8_PROF_LOS_T1 = r8_PROF_LOS_T1;
	}

	public String getR8_PROF_MARG_T1() {
		return R8_PROF_MARG_T1;
	}

	public void setR8_PROF_MARG_T1(String r8_PROF_MARG_T1) {
		R8_PROF_MARG_T1 = r8_PROF_MARG_T1;
	}

	public String getR8_TOT_RET_ASET_T1() {
		return R8_TOT_RET_ASET_T1;
	}

	public void setR8_TOT_RET_ASET_T1(String r8_TOT_RET_ASET_T1) {
		R8_TOT_RET_ASET_T1 = r8_TOT_RET_ASET_T1;
	}

	public String getR8_NON_PERF_PORT_T1() {
		return R8_NON_PERF_PORT_T1;
	}

	public void setR8_NON_PERF_PORT_T1(String r8_NON_PERF_PORT_T1) {
		R8_NON_PERF_PORT_T1 = r8_NON_PERF_PORT_T1;
	}

	public String getR8_NO_CON_LAST_T1() {
		return R8_NO_CON_LAST_T1;
	}

	public void setR8_NO_CON_LAST_T1(String r8_NO_CON_LAST_T1) {
		R8_NO_CON_LAST_T1 = r8_NO_CON_LAST_T1;
	}

	public String getR8_TOT_BRANCH_T1() {
		return R8_TOT_BRANCH_T1;
	}

	public void setR8_TOT_BRANCH_T1(String r8_TOT_BRANCH_T1) {
		R8_TOT_BRANCH_T1 = r8_TOT_BRANCH_T1;
	}

	public String getR8_TOT_REV_T2() {
		return R8_TOT_REV_T2;
	}

	public void setR8_TOT_REV_T2(String r8_TOT_REV_T2) {
		R8_TOT_REV_T2 = r8_TOT_REV_T2;
	}

	public String getR8_PROF_LOS_T2() {
		return R8_PROF_LOS_T2;
	}

	public void setR8_PROF_LOS_T2(String r8_PROF_LOS_T2) {
		R8_PROF_LOS_T2 = r8_PROF_LOS_T2;
	}

	public String getR8_PROF_MARG_T2() {
		return R8_PROF_MARG_T2;
	}

	public void setR8_PROF_MARG_T2(String r8_PROF_MARG_T2) {
		R8_PROF_MARG_T2 = r8_PROF_MARG_T2;
	}

	public String getR8_TOT_RET_ASET_T2() {
		return R8_TOT_RET_ASET_T2;
	}

	public void setR8_TOT_RET_ASET_T2(String r8_TOT_RET_ASET_T2) {
		R8_TOT_RET_ASET_T2 = r8_TOT_RET_ASET_T2;
	}

	public String getR8_NON_PERF_PORT_T2() {
		return R8_NON_PERF_PORT_T2;
	}

	public void setR8_NON_PERF_PORT_T2(String r8_NON_PERF_PORT_T2) {
		R8_NON_PERF_PORT_T2 = r8_NON_PERF_PORT_T2;
	}

	public String getR8_NO_CON_LAST_T2() {
		return R8_NO_CON_LAST_T2;
	}

	public void setR8_NO_CON_LAST_T2(String r8_NO_CON_LAST_T2) {
		R8_NO_CON_LAST_T2 = r8_NO_CON_LAST_T2;
	}

	public String getR8_TOT_BRANCH_T2() {
		return R8_TOT_BRANCH_T2;
	}

	public void setR8_TOT_BRANCH_T2(String r8_TOT_BRANCH_T2) {
		R8_TOT_BRANCH_T2 = r8_TOT_BRANCH_T2;
	}

	public String getR8_TOT_REV_T3() {
		return R8_TOT_REV_T3;
	}

	public void setR8_TOT_REV_T3(String r8_TOT_REV_T3) {
		R8_TOT_REV_T3 = r8_TOT_REV_T3;
	}

	public String getR8_PROF_LOS_T3() {
		return R8_PROF_LOS_T3;
	}

	public void setR8_PROF_LOS_T3(String r8_PROF_LOS_T3) {
		R8_PROF_LOS_T3 = r8_PROF_LOS_T3;
	}

	public String getR8_PROF_MARG_T3() {
		return R8_PROF_MARG_T3;
	}

	public void setR8_PROF_MARG_T3(String r8_PROF_MARG_T3) {
		R8_PROF_MARG_T3 = r8_PROF_MARG_T3;
	}

	public String getR8_TOT_RET_ASET_T3() {
		return R8_TOT_RET_ASET_T3;
	}

	public void setR8_TOT_RET_ASET_T3(String r8_TOT_RET_ASET_T3) {
		R8_TOT_RET_ASET_T3 = r8_TOT_RET_ASET_T3;
	}

	public String getR8_NON_PERF_PORT_T3() {
		return R8_NON_PERF_PORT_T3;
	}

	public void setR8_NON_PERF_PORT_T3(String r8_NON_PERF_PORT_T3) {
		R8_NON_PERF_PORT_T3 = r8_NON_PERF_PORT_T3;
	}

	public String getR8_NO_CON_LAST_T3() {
		return R8_NO_CON_LAST_T3;
	}

	public void setR8_NO_CON_LAST_T3(String r8_NO_CON_LAST_T3) {
		R8_NO_CON_LAST_T3 = r8_NO_CON_LAST_T3;
	}

	public String getR8_TOT_BRANCH_T3() {
		return R8_TOT_BRANCH_T3;
	}

	public void setR8_TOT_BRANCH_T3(String r8_TOT_BRANCH_T3) {
		R8_TOT_BRANCH_T3 = r8_TOT_BRANCH_T3;
	}

	public String getR8_NPL_SPD() {
		return R8_NPL_SPD;
	}

	public void setR8_NPL_SPD(String r8_NPL_SPD) {
		R8_NPL_SPD = r8_NPL_SPD;
	}

	public String getR8_RECO_NPL_SPD() {
		return R8_RECO_NPL_SPD;
	}

	public void setR8_RECO_NPL_SPD(String r8_RECO_NPL_SPD) {
		R8_RECO_NPL_SPD = r8_RECO_NPL_SPD;
	}

	public String getR8_NO_CON_ONBO_DIGI() {
		return R8_NO_CON_ONBO_DIGI;
	}

	public void setR8_NO_CON_ONBO_DIGI(String r8_NO_CON_ONBO_DIGI) {
		R8_NO_CON_ONBO_DIGI = r8_NO_CON_ONBO_DIGI;
	}

	public String getR8_NO_ACCS_AML() {
		return R8_NO_ACCS_AML;
	}

	public void setR8_NO_ACCS_AML(String r8_NO_ACCS_AML) {
		R8_NO_ACCS_AML = r8_NO_ACCS_AML;
	}

	public String getR8_TOT_ACC_LOAN_AML() {
		return R8_TOT_ACC_LOAN_AML;
	}

	public void setR8_TOT_ACC_LOAN_AML(String r8_TOT_ACC_LOAN_AML) {
		R8_TOT_ACC_LOAN_AML = r8_TOT_ACC_LOAN_AML;
	}

	public String getR8_TOT_NEW_ACCS_SPD() {
		return R8_TOT_NEW_ACCS_SPD;
	}

	public void setR8_TOT_NEW_ACCS_SPD(String r8_TOT_NEW_ACCS_SPD) {
		R8_TOT_NEW_ACCS_SPD = r8_TOT_NEW_ACCS_SPD;
	}

	public String getR8_TOT_VALS_LOANS_SPD() {
		return R8_TOT_VALS_LOANS_SPD;
	}

	public void setR8_TOT_VALS_LOANS_SPD(String r8_TOT_VALS_LOANS_SPD) {
		R8_TOT_VALS_LOANS_SPD = r8_TOT_VALS_LOANS_SPD;
	}

	public String getR8_NO_INQ_WEBMOB() {
		return R8_NO_INQ_WEBMOB;
	}

	public void setR8_NO_INQ_WEBMOB(String r8_NO_INQ_WEBMOB) {
		R8_NO_INQ_WEBMOB = r8_NO_INQ_WEBMOB;
	}

	public String getR8_NO_INQ_TRAD() {
		return R8_NO_INQ_TRAD;
	}

	public void setR8_NO_INQ_TRAD(String r8_NO_INQ_TRAD) {
		R8_NO_INQ_TRAD = r8_NO_INQ_TRAD;
	}

	public String getR8_NO_RET_POS() {
		return R8_NO_RET_POS;
	}

	public void setR8_NO_RET_POS(String r8_NO_RET_POS) {
		R8_NO_RET_POS = r8_NO_RET_POS;
	}

	public String getR8_AMT_POS_GATE() {
		return R8_AMT_POS_GATE;
	}

	public void setR8_AMT_POS_GATE(String r8_AMT_POS_GATE) {
		R8_AMT_POS_GATE = r8_AMT_POS_GATE;
	}

	public String getR8_NO_TRAN_SVF_BNK() {
		return R8_NO_TRAN_SVF_BNK;
	}

	public void setR8_NO_TRAN_SVF_BNK(String r8_NO_TRAN_SVF_BNK) {
		R8_NO_TRAN_SVF_BNK = r8_NO_TRAN_SVF_BNK;
	}

	public String getR8_AMT_RET_SVF_BNK() {
		return R8_AMT_RET_SVF_BNK;
	}

	public void setR8_AMT_RET_SVF_BNK(String r8_AMT_RET_SVF_BNK) {
		R8_AMT_RET_SVF_BNK = r8_AMT_RET_SVF_BNK;
	}

	public String getR8_TOT_WEB_MOB_VIRT() {
		return R8_TOT_WEB_MOB_VIRT;
	}

	public void setR8_TOT_WEB_MOB_VIRT(String r8_TOT_WEB_MOB_VIRT) {
		R8_TOT_WEB_MOB_VIRT = r8_TOT_WEB_MOB_VIRT;
	}

	public String getR8_VAL_UNCL_SVF() {
		return R8_VAL_UNCL_SVF;
	}

	public void setR8_VAL_UNCL_SVF(String r8_VAL_UNCL_SVF) {
		R8_VAL_UNCL_SVF = r8_VAL_UNCL_SVF;
	}

	public String getR8_NO_CON_LOW_RSK() {
		return R8_NO_CON_LOW_RSK;
	}

	public void setR8_NO_CON_LOW_RSK(String r8_NO_CON_LOW_RSK) {
		R8_NO_CON_LOW_RSK = r8_NO_CON_LOW_RSK;
	}

	public String getR8_NO_CON_HIGH_RSK() {
		return R8_NO_CON_HIGH_RSK;
	}

	public void setR8_NO_CON_HIGH_RSK(String r8_NO_CON_HIGH_RSK) {
		R8_NO_CON_HIGH_RSK = r8_NO_CON_HIGH_RSK;
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

	public String getR9_RET_ASET_LTS() {
		return R9_RET_ASET_LTS;
	}

	public void setR9_RET_ASET_LTS(String r9_RET_ASET_LTS) {
		R9_RET_ASET_LTS = r9_RET_ASET_LTS;
	}

	public String getR9_RET_ASET_LTSME() {
		return R9_RET_ASET_LTSME;
	}

	public void setR9_RET_ASET_LTSME(String r9_RET_ASET_LTSME) {
		R9_RET_ASET_LTSME = r9_RET_ASET_LTSME;
	}

	public String getR9_RET_ASET_SME_GUR() {
		return R9_RET_ASET_SME_GUR;
	}

	public void setR9_RET_ASET_SME_GUR(String r9_RET_ASET_SME_GUR) {
		R9_RET_ASET_SME_GUR = r9_RET_ASET_SME_GUR;
	}

	public String getR9_RET_LOAN_DIS() {
		return R9_RET_LOAN_DIS;
	}

	public void setR9_RET_LOAN_DIS(String r9_RET_LOAN_DIS) {
		R9_RET_LOAN_DIS = r9_RET_LOAN_DIS;
	}

	public String getR9_RET_ASET_LOAN_SME() {
		return R9_RET_ASET_LOAN_SME;
	}

	public void setR9_RET_ASET_LOAN_SME(String r9_RET_ASET_LOAN_SME) {
		R9_RET_ASET_LOAN_SME = r9_RET_ASET_LOAN_SME;
	}

	public String getR9_PER_LOAN_WEB() {
		return R9_PER_LOAN_WEB;
	}

	public void setR9_PER_LOAN_WEB(String r9_PER_LOAN_WEB) {
		R9_PER_LOAN_WEB = r9_PER_LOAN_WEB;
	}

	public String getR9_LOAN_SME_WEB_MOB() {
		return R9_LOAN_SME_WEB_MOB;
	}

	public void setR9_LOAN_SME_WEB_MOB(String r9_LOAN_SME_WEB_MOB) {
		R9_LOAN_SME_WEB_MOB = r9_LOAN_SME_WEB_MOB;
	}

	public String getR9_NO_COMPDIGI_MOB() {
		return R9_NO_COMPDIGI_MOB;
	}

	public void setR9_NO_COMPDIGI_MOB(String r9_NO_COMPDIGI_MOB) {
		R9_NO_COMPDIGI_MOB = r9_NO_COMPDIGI_MOB;
	}

	public String getR9_NO_COMP_TRADCALL() {
		return R9_NO_COMP_TRADCALL;
	}

	public void setR9_NO_COMP_TRADCALL(String r9_NO_COMP_TRADCALL) {
		R9_NO_COMP_TRADCALL = r9_NO_COMP_TRADCALL;
	}

	public String getR9_PER_COMPDIGI_WEB() {
		return R9_PER_COMPDIGI_WEB;
	}

	public void setR9_PER_COMPDIGI_WEB(String r9_PER_COMPDIGI_WEB) {
		R9_PER_COMPDIGI_WEB = r9_PER_COMPDIGI_WEB;
	}

	public String getR9_PER_COM_TRADCALL() {
		return R9_PER_COM_TRADCALL;
	}

	public void setR9_PER_COM_TRADCALL(String r9_PER_COM_TRADCALL) {
		R9_PER_COM_TRADCALL = r9_PER_COM_TRADCALL;
	}

	public String getR9_TOT_REV_PREV() {
		return R9_TOT_REV_PREV;
	}

	public void setR9_TOT_REV_PREV(String r9_TOT_REV_PREV) {
		R9_TOT_REV_PREV = r9_TOT_REV_PREV;
	}

	public String getR9_PROF_LOSS_PREV() {
		return R9_PROF_LOSS_PREV;
	}

	public void setR9_PROF_LOSS_PREV(String r9_PROF_LOSS_PREV) {
		R9_PROF_LOSS_PREV = r9_PROF_LOSS_PREV;
	}

	public String getR9_PROF_MARG_PORTFOLIO() {
		return R9_PROF_MARG_PORTFOLIO;
	}

	public void setR9_PROF_MARG_PORTFOLIO(String r9_PROF_MARG_PORTFOLIO) {
		R9_PROF_MARG_PORTFOLIO = r9_PROF_MARG_PORTFOLIO;
	}

	public String getR9_TOT_RET_ASET_PREV() {
		return R9_TOT_RET_ASET_PREV;
	}

	public void setR9_TOT_RET_ASET_PREV(String r9_TOT_RET_ASET_PREV) {
		R9_TOT_RET_ASET_PREV = r9_TOT_RET_ASET_PREV;
	}

	public String getR9_NP_LOAN_PREV() {
		return R9_NP_LOAN_PREV;
	}

	public void setR9_NP_LOAN_PREV(String r9_NP_LOAN_PREV) {
		R9_NP_LOAN_PREV = r9_NP_LOAN_PREV;
	}

	public String getR9_NON_CON_ONLAST_PREV() {
		return R9_NON_CON_ONLAST_PREV;
	}

	public void setR9_NON_CON_ONLAST_PREV(String r9_NON_CON_ONLAST_PREV) {
		R9_NON_CON_ONLAST_PREV = r9_NON_CON_ONLAST_PREV;
	}

	public String getR9_TOT_BRAN_PREV() {
		return R9_TOT_BRAN_PREV;
	}

	public void setR9_TOT_BRAN_PREV(String r9_TOT_BRAN_PREV) {
		R9_TOT_BRAN_PREV = r9_TOT_BRAN_PREV;
	}

	public String getR9_TOT_REV_RET_CUR() {
		return R9_TOT_REV_RET_CUR;
	}

	public void setR9_TOT_REV_RET_CUR(String r9_TOT_REV_RET_CUR) {
		R9_TOT_REV_RET_CUR = r9_TOT_REV_RET_CUR;
	}

	public String getR9_PROF_LOS_PORT_CUR() {
		return R9_PROF_LOS_PORT_CUR;
	}

	public void setR9_PROF_LOS_PORT_CUR(String r9_PROF_LOS_PORT_CUR) {
		R9_PROF_LOS_PORT_CUR = r9_PROF_LOS_PORT_CUR;
	}

	public String getR9_PROF_MARG_PERC_CUR() {
		return R9_PROF_MARG_PERC_CUR;
	}

	public void setR9_PROF_MARG_PERC_CUR(String r9_PROF_MARG_PERC_CUR) {
		R9_PROF_MARG_PERC_CUR = r9_PROF_MARG_PERC_CUR;
	}

	public String getR9_TOT_RET_ASET_CUR() {
		return R9_TOT_RET_ASET_CUR;
	}

	public void setR9_TOT_RET_ASET_CUR(String r9_TOT_RET_ASET_CUR) {
		R9_TOT_RET_ASET_CUR = r9_TOT_RET_ASET_CUR;
	}

	public String getR9_NON_PER_RET_PORT_CUR() {
		return R9_NON_PER_RET_PORT_CUR;
	}

	public void setR9_NON_PER_RET_PORT_CUR(String r9_NON_PER_RET_PORT_CUR) {
		R9_NON_PER_RET_PORT_CUR = r9_NON_PER_RET_PORT_CUR;
	}

	public String getR9_NO_CON_LAST_CUR() {
		return R9_NO_CON_LAST_CUR;
	}

	public void setR9_NO_CON_LAST_CUR(String r9_NO_CON_LAST_CUR) {
		R9_NO_CON_LAST_CUR = r9_NO_CON_LAST_CUR;
	}

	public String getR9_TOT_BRANCH_CUR() {
		return R9_TOT_BRANCH_CUR;
	}

	public void setR9_TOT_BRANCH_CUR(String r9_TOT_BRANCH_CUR) {
		R9_TOT_BRANCH_CUR = r9_TOT_BRANCH_CUR;
	}

	public String getR9_TOT_REV_T1() {
		return R9_TOT_REV_T1;
	}

	public void setR9_TOT_REV_T1(String r9_TOT_REV_T1) {
		R9_TOT_REV_T1 = r9_TOT_REV_T1;
	}

	public String getR9_PROF_LOS_T1() {
		return R9_PROF_LOS_T1;
	}

	public void setR9_PROF_LOS_T1(String r9_PROF_LOS_T1) {
		R9_PROF_LOS_T1 = r9_PROF_LOS_T1;
	}

	public String getR9_PROF_MARG_T1() {
		return R9_PROF_MARG_T1;
	}

	public void setR9_PROF_MARG_T1(String r9_PROF_MARG_T1) {
		R9_PROF_MARG_T1 = r9_PROF_MARG_T1;
	}

	public String getR9_TOT_RET_ASET_T1() {
		return R9_TOT_RET_ASET_T1;
	}

	public void setR9_TOT_RET_ASET_T1(String r9_TOT_RET_ASET_T1) {
		R9_TOT_RET_ASET_T1 = r9_TOT_RET_ASET_T1;
	}

	public String getR9_NON_PERF_PORT_T1() {
		return R9_NON_PERF_PORT_T1;
	}

	public void setR9_NON_PERF_PORT_T1(String r9_NON_PERF_PORT_T1) {
		R9_NON_PERF_PORT_T1 = r9_NON_PERF_PORT_T1;
	}

	public String getR9_NO_CON_LAST_T1() {
		return R9_NO_CON_LAST_T1;
	}

	public void setR9_NO_CON_LAST_T1(String r9_NO_CON_LAST_T1) {
		R9_NO_CON_LAST_T1 = r9_NO_CON_LAST_T1;
	}

	public String getR9_TOT_BRANCH_T1() {
		return R9_TOT_BRANCH_T1;
	}

	public void setR9_TOT_BRANCH_T1(String r9_TOT_BRANCH_T1) {
		R9_TOT_BRANCH_T1 = r9_TOT_BRANCH_T1;
	}

	public String getR9_TOT_REV_T2() {
		return R9_TOT_REV_T2;
	}

	public void setR9_TOT_REV_T2(String r9_TOT_REV_T2) {
		R9_TOT_REV_T2 = r9_TOT_REV_T2;
	}

	public String getR9_PROF_LOS_T2() {
		return R9_PROF_LOS_T2;
	}

	public void setR9_PROF_LOS_T2(String r9_PROF_LOS_T2) {
		R9_PROF_LOS_T2 = r9_PROF_LOS_T2;
	}

	public String getR9_PROF_MARG_T2() {
		return R9_PROF_MARG_T2;
	}

	public void setR9_PROF_MARG_T2(String r9_PROF_MARG_T2) {
		R9_PROF_MARG_T2 = r9_PROF_MARG_T2;
	}

	public String getR9_TOT_RET_ASET_T2() {
		return R9_TOT_RET_ASET_T2;
	}

	public void setR9_TOT_RET_ASET_T2(String r9_TOT_RET_ASET_T2) {
		R9_TOT_RET_ASET_T2 = r9_TOT_RET_ASET_T2;
	}

	public String getR9_NON_PERF_PORT_T2() {
		return R9_NON_PERF_PORT_T2;
	}

	public void setR9_NON_PERF_PORT_T2(String r9_NON_PERF_PORT_T2) {
		R9_NON_PERF_PORT_T2 = r9_NON_PERF_PORT_T2;
	}

	public String getR9_NO_CON_LAST_T2() {
		return R9_NO_CON_LAST_T2;
	}

	public void setR9_NO_CON_LAST_T2(String r9_NO_CON_LAST_T2) {
		R9_NO_CON_LAST_T2 = r9_NO_CON_LAST_T2;
	}

	public String getR9_TOT_BRANCH_T2() {
		return R9_TOT_BRANCH_T2;
	}

	public void setR9_TOT_BRANCH_T2(String r9_TOT_BRANCH_T2) {
		R9_TOT_BRANCH_T2 = r9_TOT_BRANCH_T2;
	}

	public String getR9_TOT_REV_T3() {
		return R9_TOT_REV_T3;
	}

	public void setR9_TOT_REV_T3(String r9_TOT_REV_T3) {
		R9_TOT_REV_T3 = r9_TOT_REV_T3;
	}

	public String getR9_PROF_LOS_T3() {
		return R9_PROF_LOS_T3;
	}

	public void setR9_PROF_LOS_T3(String r9_PROF_LOS_T3) {
		R9_PROF_LOS_T3 = r9_PROF_LOS_T3;
	}

	public String getR9_PROF_MARG_T3() {
		return R9_PROF_MARG_T3;
	}

	public void setR9_PROF_MARG_T3(String r9_PROF_MARG_T3) {
		R9_PROF_MARG_T3 = r9_PROF_MARG_T3;
	}

	public String getR9_TOT_RET_ASET_T3() {
		return R9_TOT_RET_ASET_T3;
	}

	public void setR9_TOT_RET_ASET_T3(String r9_TOT_RET_ASET_T3) {
		R9_TOT_RET_ASET_T3 = r9_TOT_RET_ASET_T3;
	}

	public String getR9_NON_PERF_PORT_T3() {
		return R9_NON_PERF_PORT_T3;
	}

	public void setR9_NON_PERF_PORT_T3(String r9_NON_PERF_PORT_T3) {
		R9_NON_PERF_PORT_T3 = r9_NON_PERF_PORT_T3;
	}

	public String getR9_NO_CON_LAST_T3() {
		return R9_NO_CON_LAST_T3;
	}

	public void setR9_NO_CON_LAST_T3(String r9_NO_CON_LAST_T3) {
		R9_NO_CON_LAST_T3 = r9_NO_CON_LAST_T3;
	}

	public String getR9_TOT_BRANCH_T3() {
		return R9_TOT_BRANCH_T3;
	}

	public void setR9_TOT_BRANCH_T3(String r9_TOT_BRANCH_T3) {
		R9_TOT_BRANCH_T3 = r9_TOT_BRANCH_T3;
	}

	public String getR9_NPL_SPD() {
		return R9_NPL_SPD;
	}

	public void setR9_NPL_SPD(String r9_NPL_SPD) {
		R9_NPL_SPD = r9_NPL_SPD;
	}

	public String getR9_RECO_NPL_SPD() {
		return R9_RECO_NPL_SPD;
	}

	public void setR9_RECO_NPL_SPD(String r9_RECO_NPL_SPD) {
		R9_RECO_NPL_SPD = r9_RECO_NPL_SPD;
	}

	public String getR9_NO_CON_ONBO_DIGI() {
		return R9_NO_CON_ONBO_DIGI;
	}

	public void setR9_NO_CON_ONBO_DIGI(String r9_NO_CON_ONBO_DIGI) {
		R9_NO_CON_ONBO_DIGI = r9_NO_CON_ONBO_DIGI;
	}

	public String getR9_NO_ACCS_AML() {
		return R9_NO_ACCS_AML;
	}

	public void setR9_NO_ACCS_AML(String r9_NO_ACCS_AML) {
		R9_NO_ACCS_AML = r9_NO_ACCS_AML;
	}

	public String getR9_TOT_ACC_LOAN_AML() {
		return R9_TOT_ACC_LOAN_AML;
	}

	public void setR9_TOT_ACC_LOAN_AML(String r9_TOT_ACC_LOAN_AML) {
		R9_TOT_ACC_LOAN_AML = r9_TOT_ACC_LOAN_AML;
	}

	public String getR9_TOT_NEW_ACCS_SPD() {
		return R9_TOT_NEW_ACCS_SPD;
	}

	public void setR9_TOT_NEW_ACCS_SPD(String r9_TOT_NEW_ACCS_SPD) {
		R9_TOT_NEW_ACCS_SPD = r9_TOT_NEW_ACCS_SPD;
	}

	public String getR9_TOT_VALS_LOANS_SPD() {
		return R9_TOT_VALS_LOANS_SPD;
	}

	public void setR9_TOT_VALS_LOANS_SPD(String r9_TOT_VALS_LOANS_SPD) {
		R9_TOT_VALS_LOANS_SPD = r9_TOT_VALS_LOANS_SPD;
	}

	public String getR9_NO_INQ_WEBMOB() {
		return R9_NO_INQ_WEBMOB;
	}

	public void setR9_NO_INQ_WEBMOB(String r9_NO_INQ_WEBMOB) {
		R9_NO_INQ_WEBMOB = r9_NO_INQ_WEBMOB;
	}

	public String getR9_NO_INQ_TRAD() {
		return R9_NO_INQ_TRAD;
	}

	public void setR9_NO_INQ_TRAD(String r9_NO_INQ_TRAD) {
		R9_NO_INQ_TRAD = r9_NO_INQ_TRAD;
	}

	public String getR9_NO_RET_POS() {
		return R9_NO_RET_POS;
	}

	public void setR9_NO_RET_POS(String r9_NO_RET_POS) {
		R9_NO_RET_POS = r9_NO_RET_POS;
	}

	public String getR9_AMT_POS_GATE() {
		return R9_AMT_POS_GATE;
	}

	public void setR9_AMT_POS_GATE(String r9_AMT_POS_GATE) {
		R9_AMT_POS_GATE = r9_AMT_POS_GATE;
	}

	public String getR9_NO_TRAN_SVF_BNK() {
		return R9_NO_TRAN_SVF_BNK;
	}

	public void setR9_NO_TRAN_SVF_BNK(String r9_NO_TRAN_SVF_BNK) {
		R9_NO_TRAN_SVF_BNK = r9_NO_TRAN_SVF_BNK;
	}

	public String getR9_AMT_RET_SVF_BNK() {
		return R9_AMT_RET_SVF_BNK;
	}

	public void setR9_AMT_RET_SVF_BNK(String r9_AMT_RET_SVF_BNK) {
		R9_AMT_RET_SVF_BNK = r9_AMT_RET_SVF_BNK;
	}

	public String getR9_TOT_WEB_MOB_VIRT() {
		return R9_TOT_WEB_MOB_VIRT;
	}

	public void setR9_TOT_WEB_MOB_VIRT(String r9_TOT_WEB_MOB_VIRT) {
		R9_TOT_WEB_MOB_VIRT = r9_TOT_WEB_MOB_VIRT;
	}

	public String getR9_VAL_UNCL_SVF() {
		return R9_VAL_UNCL_SVF;
	}

	public void setR9_VAL_UNCL_SVF(String r9_VAL_UNCL_SVF) {
		R9_VAL_UNCL_SVF = r9_VAL_UNCL_SVF;
	}

	public String getR9_NO_CON_LOW_RSK() {
		return R9_NO_CON_LOW_RSK;
	}

	public void setR9_NO_CON_LOW_RSK(String r9_NO_CON_LOW_RSK) {
		R9_NO_CON_LOW_RSK = r9_NO_CON_LOW_RSK;
	}

	public String getR9_NO_CON_HIGH_RSK() {
		return R9_NO_CON_HIGH_RSK;
	}

	public void setR9_NO_CON_HIGH_RSK(String r9_NO_CON_HIGH_RSK) {
		R9_NO_CON_HIGH_RSK = r9_NO_CON_HIGH_RSK;
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

	public String getR10_RET_ASET_LTS() {
		return R10_RET_ASET_LTS;
	}

	public void setR10_RET_ASET_LTS(String r10_RET_ASET_LTS) {
		R10_RET_ASET_LTS = r10_RET_ASET_LTS;
	}

	public String getR10_RET_ASET_LTSME() {
		return R10_RET_ASET_LTSME;
	}

	public void setR10_RET_ASET_LTSME(String r10_RET_ASET_LTSME) {
		R10_RET_ASET_LTSME = r10_RET_ASET_LTSME;
	}

	public String getR10_RET_ASET_SME_GUR() {
		return R10_RET_ASET_SME_GUR;
	}

	public void setR10_RET_ASET_SME_GUR(String r10_RET_ASET_SME_GUR) {
		R10_RET_ASET_SME_GUR = r10_RET_ASET_SME_GUR;
	}

	public String getR10_RET_LOAN_DIS() {
		return R10_RET_LOAN_DIS;
	}

	public void setR10_RET_LOAN_DIS(String r10_RET_LOAN_DIS) {
		R10_RET_LOAN_DIS = r10_RET_LOAN_DIS;
	}

	public String getR10_RET_ASET_LOAN_SME() {
		return R10_RET_ASET_LOAN_SME;
	}

	public void setR10_RET_ASET_LOAN_SME(String r10_RET_ASET_LOAN_SME) {
		R10_RET_ASET_LOAN_SME = r10_RET_ASET_LOAN_SME;
	}

	public String getR10_PER_LOAN_WEB() {
		return R10_PER_LOAN_WEB;
	}

	public void setR10_PER_LOAN_WEB(String r10_PER_LOAN_WEB) {
		R10_PER_LOAN_WEB = r10_PER_LOAN_WEB;
	}

	public String getR10_LOAN_SME_WEB_MOB() {
		return R10_LOAN_SME_WEB_MOB;
	}

	public void setR10_LOAN_SME_WEB_MOB(String r10_LOAN_SME_WEB_MOB) {
		R10_LOAN_SME_WEB_MOB = r10_LOAN_SME_WEB_MOB;
	}

	public String getR10_NO_COMPDIGI_MOB() {
		return R10_NO_COMPDIGI_MOB;
	}

	public void setR10_NO_COMPDIGI_MOB(String r10_NO_COMPDIGI_MOB) {
		R10_NO_COMPDIGI_MOB = r10_NO_COMPDIGI_MOB;
	}

	public String getR10_NO_COMP_TRADCALL() {
		return R10_NO_COMP_TRADCALL;
	}

	public void setR10_NO_COMP_TRADCALL(String r10_NO_COMP_TRADCALL) {
		R10_NO_COMP_TRADCALL = r10_NO_COMP_TRADCALL;
	}

	public String getR10_PER_COMPDIGI_WEB() {
		return R10_PER_COMPDIGI_WEB;
	}

	public void setR10_PER_COMPDIGI_WEB(String r10_PER_COMPDIGI_WEB) {
		R10_PER_COMPDIGI_WEB = r10_PER_COMPDIGI_WEB;
	}

	public String getR10_PER_COM_TRADCALL() {
		return R10_PER_COM_TRADCALL;
	}

	public void setR10_PER_COM_TRADCALL(String r10_PER_COM_TRADCALL) {
		R10_PER_COM_TRADCALL = r10_PER_COM_TRADCALL;
	}

	public String getR10_TOT_REV_PREV() {
		return R10_TOT_REV_PREV;
	}

	public void setR10_TOT_REV_PREV(String r10_TOT_REV_PREV) {
		R10_TOT_REV_PREV = r10_TOT_REV_PREV;
	}

	public String getR10_PROF_LOSS_PREV() {
		return R10_PROF_LOSS_PREV;
	}

	public void setR10_PROF_LOSS_PREV(String r10_PROF_LOSS_PREV) {
		R10_PROF_LOSS_PREV = r10_PROF_LOSS_PREV;
	}

	public String getR10_PROF_MARG_PORTFOLIO() {
		return R10_PROF_MARG_PORTFOLIO;
	}

	public void setR10_PROF_MARG_PORTFOLIO(String r10_PROF_MARG_PORTFOLIO) {
		R10_PROF_MARG_PORTFOLIO = r10_PROF_MARG_PORTFOLIO;
	}

	public String getR10_TOT_RET_ASET_PREV() {
		return R10_TOT_RET_ASET_PREV;
	}

	public void setR10_TOT_RET_ASET_PREV(String r10_TOT_RET_ASET_PREV) {
		R10_TOT_RET_ASET_PREV = r10_TOT_RET_ASET_PREV;
	}

	public String getR10_NP_LOAN_PREV() {
		return R10_NP_LOAN_PREV;
	}

	public void setR10_NP_LOAN_PREV(String r10_NP_LOAN_PREV) {
		R10_NP_LOAN_PREV = r10_NP_LOAN_PREV;
	}

	public String getR10_NON_CON_ONLAST_PREV() {
		return R10_NON_CON_ONLAST_PREV;
	}

	public void setR10_NON_CON_ONLAST_PREV(String r10_NON_CON_ONLAST_PREV) {
		R10_NON_CON_ONLAST_PREV = r10_NON_CON_ONLAST_PREV;
	}

	public String getR10_TOT_BRAN_PREV() {
		return R10_TOT_BRAN_PREV;
	}

	public void setR10_TOT_BRAN_PREV(String r10_TOT_BRAN_PREV) {
		R10_TOT_BRAN_PREV = r10_TOT_BRAN_PREV;
	}

	public String getR10_TOT_REV_RET_CUR() {
		return R10_TOT_REV_RET_CUR;
	}

	public void setR10_TOT_REV_RET_CUR(String r10_TOT_REV_RET_CUR) {
		R10_TOT_REV_RET_CUR = r10_TOT_REV_RET_CUR;
	}

	public String getR10_PROF_LOS_PORT_CUR() {
		return R10_PROF_LOS_PORT_CUR;
	}

	public void setR10_PROF_LOS_PORT_CUR(String r10_PROF_LOS_PORT_CUR) {
		R10_PROF_LOS_PORT_CUR = r10_PROF_LOS_PORT_CUR;
	}

	public String getR10_PROF_MARG_PERC_CUR() {
		return R10_PROF_MARG_PERC_CUR;
	}

	public void setR10_PROF_MARG_PERC_CUR(String r10_PROF_MARG_PERC_CUR) {
		R10_PROF_MARG_PERC_CUR = r10_PROF_MARG_PERC_CUR;
	}

	public String getR10_TOT_RET_ASET_CUR() {
		return R10_TOT_RET_ASET_CUR;
	}

	public void setR10_TOT_RET_ASET_CUR(String r10_TOT_RET_ASET_CUR) {
		R10_TOT_RET_ASET_CUR = r10_TOT_RET_ASET_CUR;
	}

	public String getR10_NON_PER_RET_PORT_CUR() {
		return R10_NON_PER_RET_PORT_CUR;
	}

	public void setR10_NON_PER_RET_PORT_CUR(String r10_NON_PER_RET_PORT_CUR) {
		R10_NON_PER_RET_PORT_CUR = r10_NON_PER_RET_PORT_CUR;
	}

	public String getR10_NO_CON_LAST_CUR() {
		return R10_NO_CON_LAST_CUR;
	}

	public void setR10_NO_CON_LAST_CUR(String r10_NO_CON_LAST_CUR) {
		R10_NO_CON_LAST_CUR = r10_NO_CON_LAST_CUR;
	}

	public String getR10_TOT_BRANCH_CUR() {
		return R10_TOT_BRANCH_CUR;
	}

	public void setR10_TOT_BRANCH_CUR(String r10_TOT_BRANCH_CUR) {
		R10_TOT_BRANCH_CUR = r10_TOT_BRANCH_CUR;
	}

	public String getR10_TOT_REV_T1() {
		return R10_TOT_REV_T1;
	}

	public void setR10_TOT_REV_T1(String r10_TOT_REV_T1) {
		R10_TOT_REV_T1 = r10_TOT_REV_T1;
	}

	public String getR10_PROF_LOS_T1() {
		return R10_PROF_LOS_T1;
	}

	public void setR10_PROF_LOS_T1(String r10_PROF_LOS_T1) {
		R10_PROF_LOS_T1 = r10_PROF_LOS_T1;
	}

	public String getR10_PROF_MARG_T1() {
		return R10_PROF_MARG_T1;
	}

	public void setR10_PROF_MARG_T1(String r10_PROF_MARG_T1) {
		R10_PROF_MARG_T1 = r10_PROF_MARG_T1;
	}

	public String getR10_TOT_RET_ASET_T1() {
		return R10_TOT_RET_ASET_T1;
	}

	public void setR10_TOT_RET_ASET_T1(String r10_TOT_RET_ASET_T1) {
		R10_TOT_RET_ASET_T1 = r10_TOT_RET_ASET_T1;
	}

	public String getR10_NON_PERF_PORT_T1() {
		return R10_NON_PERF_PORT_T1;
	}

	public void setR10_NON_PERF_PORT_T1(String r10_NON_PERF_PORT_T1) {
		R10_NON_PERF_PORT_T1 = r10_NON_PERF_PORT_T1;
	}

	public String getR10_NO_CON_LAST_T1() {
		return R10_NO_CON_LAST_T1;
	}

	public void setR10_NO_CON_LAST_T1(String r10_NO_CON_LAST_T1) {
		R10_NO_CON_LAST_T1 = r10_NO_CON_LAST_T1;
	}

	public String getR10_TOT_BRANCH_T1() {
		return R10_TOT_BRANCH_T1;
	}

	public void setR10_TOT_BRANCH_T1(String r10_TOT_BRANCH_T1) {
		R10_TOT_BRANCH_T1 = r10_TOT_BRANCH_T1;
	}

	public String getR10_TOT_REV_T2() {
		return R10_TOT_REV_T2;
	}

	public void setR10_TOT_REV_T2(String r10_TOT_REV_T2) {
		R10_TOT_REV_T2 = r10_TOT_REV_T2;
	}

	public String getR10_PROF_LOS_T2() {
		return R10_PROF_LOS_T2;
	}

	public void setR10_PROF_LOS_T2(String r10_PROF_LOS_T2) {
		R10_PROF_LOS_T2 = r10_PROF_LOS_T2;
	}

	public String getR10_PROF_MARG_T2() {
		return R10_PROF_MARG_T2;
	}

	public void setR10_PROF_MARG_T2(String r10_PROF_MARG_T2) {
		R10_PROF_MARG_T2 = r10_PROF_MARG_T2;
	}

	public String getR10_TOT_RET_ASET_T2() {
		return R10_TOT_RET_ASET_T2;
	}

	public void setR10_TOT_RET_ASET_T2(String r10_TOT_RET_ASET_T2) {
		R10_TOT_RET_ASET_T2 = r10_TOT_RET_ASET_T2;
	}

	public String getR10_NON_PERF_PORT_T2() {
		return R10_NON_PERF_PORT_T2;
	}

	public void setR10_NON_PERF_PORT_T2(String r10_NON_PERF_PORT_T2) {
		R10_NON_PERF_PORT_T2 = r10_NON_PERF_PORT_T2;
	}

	public String getR10_NO_CON_LAST_T2() {
		return R10_NO_CON_LAST_T2;
	}

	public void setR10_NO_CON_LAST_T2(String r10_NO_CON_LAST_T2) {
		R10_NO_CON_LAST_T2 = r10_NO_CON_LAST_T2;
	}

	public String getR10_TOT_BRANCH_T2() {
		return R10_TOT_BRANCH_T2;
	}

	public void setR10_TOT_BRANCH_T2(String r10_TOT_BRANCH_T2) {
		R10_TOT_BRANCH_T2 = r10_TOT_BRANCH_T2;
	}

	public String getR10_TOT_REV_T3() {
		return R10_TOT_REV_T3;
	}

	public void setR10_TOT_REV_T3(String r10_TOT_REV_T3) {
		R10_TOT_REV_T3 = r10_TOT_REV_T3;
	}

	public String getR10_PROF_LOS_T3() {
		return R10_PROF_LOS_T3;
	}

	public void setR10_PROF_LOS_T3(String r10_PROF_LOS_T3) {
		R10_PROF_LOS_T3 = r10_PROF_LOS_T3;
	}

	public String getR10_PROF_MARG_T3() {
		return R10_PROF_MARG_T3;
	}

	public void setR10_PROF_MARG_T3(String r10_PROF_MARG_T3) {
		R10_PROF_MARG_T3 = r10_PROF_MARG_T3;
	}

	public String getR10_TOT_RET_ASET_T3() {
		return R10_TOT_RET_ASET_T3;
	}

	public void setR10_TOT_RET_ASET_T3(String r10_TOT_RET_ASET_T3) {
		R10_TOT_RET_ASET_T3 = r10_TOT_RET_ASET_T3;
	}

	public String getR10_NON_PERF_PORT_T3() {
		return R10_NON_PERF_PORT_T3;
	}

	public void setR10_NON_PERF_PORT_T3(String r10_NON_PERF_PORT_T3) {
		R10_NON_PERF_PORT_T3 = r10_NON_PERF_PORT_T3;
	}

	public String getR10_NO_CON_LAST_T3() {
		return R10_NO_CON_LAST_T3;
	}

	public void setR10_NO_CON_LAST_T3(String r10_NO_CON_LAST_T3) {
		R10_NO_CON_LAST_T3 = r10_NO_CON_LAST_T3;
	}

	public String getR10_TOT_BRANCH_T3() {
		return R10_TOT_BRANCH_T3;
	}

	public void setR10_TOT_BRANCH_T3(String r10_TOT_BRANCH_T3) {
		R10_TOT_BRANCH_T3 = r10_TOT_BRANCH_T3;
	}

	public String getR10_NPL_SPD() {
		return R10_NPL_SPD;
	}

	public void setR10_NPL_SPD(String r10_NPL_SPD) {
		R10_NPL_SPD = r10_NPL_SPD;
	}

	public String getR10_RECO_NPL_SPD() {
		return R10_RECO_NPL_SPD;
	}

	public void setR10_RECO_NPL_SPD(String r10_RECO_NPL_SPD) {
		R10_RECO_NPL_SPD = r10_RECO_NPL_SPD;
	}

	public String getR10_NO_CON_ONBO_DIGI() {
		return R10_NO_CON_ONBO_DIGI;
	}

	public void setR10_NO_CON_ONBO_DIGI(String r10_NO_CON_ONBO_DIGI) {
		R10_NO_CON_ONBO_DIGI = r10_NO_CON_ONBO_DIGI;
	}

	public String getR10_NO_ACCS_AML() {
		return R10_NO_ACCS_AML;
	}

	public void setR10_NO_ACCS_AML(String r10_NO_ACCS_AML) {
		R10_NO_ACCS_AML = r10_NO_ACCS_AML;
	}

	public String getR10_TOT_ACC_LOAN_AML() {
		return R10_TOT_ACC_LOAN_AML;
	}

	public void setR10_TOT_ACC_LOAN_AML(String r10_TOT_ACC_LOAN_AML) {
		R10_TOT_ACC_LOAN_AML = r10_TOT_ACC_LOAN_AML;
	}

	public String getR10_TOT_NEW_ACCS_SPD() {
		return R10_TOT_NEW_ACCS_SPD;
	}

	public void setR10_TOT_NEW_ACCS_SPD(String r10_TOT_NEW_ACCS_SPD) {
		R10_TOT_NEW_ACCS_SPD = r10_TOT_NEW_ACCS_SPD;
	}

	public String getR10_TOT_VALS_LOANS_SPD() {
		return R10_TOT_VALS_LOANS_SPD;
	}

	public void setR10_TOT_VALS_LOANS_SPD(String r10_TOT_VALS_LOANS_SPD) {
		R10_TOT_VALS_LOANS_SPD = r10_TOT_VALS_LOANS_SPD;
	}

	public String getR10_NO_INQ_WEBMOB() {
		return R10_NO_INQ_WEBMOB;
	}

	public void setR10_NO_INQ_WEBMOB(String r10_NO_INQ_WEBMOB) {
		R10_NO_INQ_WEBMOB = r10_NO_INQ_WEBMOB;
	}

	public String getR10_NO_INQ_TRAD() {
		return R10_NO_INQ_TRAD;
	}

	public void setR10_NO_INQ_TRAD(String r10_NO_INQ_TRAD) {
		R10_NO_INQ_TRAD = r10_NO_INQ_TRAD;
	}

	public String getR10_NO_RET_POS() {
		return R10_NO_RET_POS;
	}

	public void setR10_NO_RET_POS(String r10_NO_RET_POS) {
		R10_NO_RET_POS = r10_NO_RET_POS;
	}

	public String getR10_AMT_POS_GATE() {
		return R10_AMT_POS_GATE;
	}

	public void setR10_AMT_POS_GATE(String r10_AMT_POS_GATE) {
		R10_AMT_POS_GATE = r10_AMT_POS_GATE;
	}

	public String getR10_NO_TRAN_SVF_BNK() {
		return R10_NO_TRAN_SVF_BNK;
	}

	public void setR10_NO_TRAN_SVF_BNK(String r10_NO_TRAN_SVF_BNK) {
		R10_NO_TRAN_SVF_BNK = r10_NO_TRAN_SVF_BNK;
	}

	public String getR10_AMT_RET_SVF_BNK() {
		return R10_AMT_RET_SVF_BNK;
	}

	public void setR10_AMT_RET_SVF_BNK(String r10_AMT_RET_SVF_BNK) {
		R10_AMT_RET_SVF_BNK = r10_AMT_RET_SVF_BNK;
	}

	public String getR10_TOT_WEB_MOB_VIRT() {
		return R10_TOT_WEB_MOB_VIRT;
	}

	public void setR10_TOT_WEB_MOB_VIRT(String r10_TOT_WEB_MOB_VIRT) {
		R10_TOT_WEB_MOB_VIRT = r10_TOT_WEB_MOB_VIRT;
	}

	public String getR10_VAL_UNCL_SVF() {
		return R10_VAL_UNCL_SVF;
	}

	public void setR10_VAL_UNCL_SVF(String r10_VAL_UNCL_SVF) {
		R10_VAL_UNCL_SVF = r10_VAL_UNCL_SVF;
	}

	public String getR10_NO_CON_LOW_RSK() {
		return R10_NO_CON_LOW_RSK;
	}

	public void setR10_NO_CON_LOW_RSK(String r10_NO_CON_LOW_RSK) {
		R10_NO_CON_LOW_RSK = r10_NO_CON_LOW_RSK;
	}

	public String getR10_NO_CON_HIGH_RSK() {
		return R10_NO_CON_HIGH_RSK;
	}

	public void setR10_NO_CON_HIGH_RSK(String r10_NO_CON_HIGH_RSK) {
		R10_NO_CON_HIGH_RSK = r10_NO_CON_HIGH_RSK;
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

	public String getR11_RET_ASET_LTS() {
		return R11_RET_ASET_LTS;
	}

	public void setR11_RET_ASET_LTS(String r11_RET_ASET_LTS) {
		R11_RET_ASET_LTS = r11_RET_ASET_LTS;
	}

	public String getR11_RET_ASET_LTSME() {
		return R11_RET_ASET_LTSME;
	}

	public void setR11_RET_ASET_LTSME(String r11_RET_ASET_LTSME) {
		R11_RET_ASET_LTSME = r11_RET_ASET_LTSME;
	}

	public String getR11_RET_ASET_SME_GUR() {
		return R11_RET_ASET_SME_GUR;
	}

	public void setR11_RET_ASET_SME_GUR(String r11_RET_ASET_SME_GUR) {
		R11_RET_ASET_SME_GUR = r11_RET_ASET_SME_GUR;
	}

	public String getR11_RET_LOAN_DIS() {
		return R11_RET_LOAN_DIS;
	}

	public void setR11_RET_LOAN_DIS(String r11_RET_LOAN_DIS) {
		R11_RET_LOAN_DIS = r11_RET_LOAN_DIS;
	}

	public String getR11_RET_ASET_LOAN_SME() {
		return R11_RET_ASET_LOAN_SME;
	}

	public void setR11_RET_ASET_LOAN_SME(String r11_RET_ASET_LOAN_SME) {
		R11_RET_ASET_LOAN_SME = r11_RET_ASET_LOAN_SME;
	}

	public String getR11_PER_LOAN_WEB() {
		return R11_PER_LOAN_WEB;
	}

	public void setR11_PER_LOAN_WEB(String r11_PER_LOAN_WEB) {
		R11_PER_LOAN_WEB = r11_PER_LOAN_WEB;
	}

	public String getR11_LOAN_SME_WEB_MOB() {
		return R11_LOAN_SME_WEB_MOB;
	}

	public void setR11_LOAN_SME_WEB_MOB(String r11_LOAN_SME_WEB_MOB) {
		R11_LOAN_SME_WEB_MOB = r11_LOAN_SME_WEB_MOB;
	}

	public String getR11_NO_COMPDIGI_MOB() {
		return R11_NO_COMPDIGI_MOB;
	}

	public void setR11_NO_COMPDIGI_MOB(String r11_NO_COMPDIGI_MOB) {
		R11_NO_COMPDIGI_MOB = r11_NO_COMPDIGI_MOB;
	}

	public String getR11_NO_COMP_TRADCALL() {
		return R11_NO_COMP_TRADCALL;
	}

	public void setR11_NO_COMP_TRADCALL(String r11_NO_COMP_TRADCALL) {
		R11_NO_COMP_TRADCALL = r11_NO_COMP_TRADCALL;
	}

	public String getR11_PER_COMPDIGI_WEB() {
		return R11_PER_COMPDIGI_WEB;
	}

	public void setR11_PER_COMPDIGI_WEB(String r11_PER_COMPDIGI_WEB) {
		R11_PER_COMPDIGI_WEB = r11_PER_COMPDIGI_WEB;
	}

	public String getR11_PER_COM_TRADCALL() {
		return R11_PER_COM_TRADCALL;
	}

	public void setR11_PER_COM_TRADCALL(String r11_PER_COM_TRADCALL) {
		R11_PER_COM_TRADCALL = r11_PER_COM_TRADCALL;
	}

	public String getR11_TOT_REV_PREV() {
		return R11_TOT_REV_PREV;
	}

	public void setR11_TOT_REV_PREV(String r11_TOT_REV_PREV) {
		R11_TOT_REV_PREV = r11_TOT_REV_PREV;
	}

	public String getR11_PROF_LOSS_PREV() {
		return R11_PROF_LOSS_PREV;
	}

	public void setR11_PROF_LOSS_PREV(String r11_PROF_LOSS_PREV) {
		R11_PROF_LOSS_PREV = r11_PROF_LOSS_PREV;
	}

	public String getR11_PROF_MARG_PORTFOLIO() {
		return R11_PROF_MARG_PORTFOLIO;
	}

	public void setR11_PROF_MARG_PORTFOLIO(String r11_PROF_MARG_PORTFOLIO) {
		R11_PROF_MARG_PORTFOLIO = r11_PROF_MARG_PORTFOLIO;
	}

	public String getR11_TOT_RET_ASET_PREV() {
		return R11_TOT_RET_ASET_PREV;
	}

	public void setR11_TOT_RET_ASET_PREV(String r11_TOT_RET_ASET_PREV) {
		R11_TOT_RET_ASET_PREV = r11_TOT_RET_ASET_PREV;
	}

	public String getR11_NP_LOAN_PREV() {
		return R11_NP_LOAN_PREV;
	}

	public void setR11_NP_LOAN_PREV(String r11_NP_LOAN_PREV) {
		R11_NP_LOAN_PREV = r11_NP_LOAN_PREV;
	}

	public String getR11_NON_CON_ONLAST_PREV() {
		return R11_NON_CON_ONLAST_PREV;
	}

	public void setR11_NON_CON_ONLAST_PREV(String r11_NON_CON_ONLAST_PREV) {
		R11_NON_CON_ONLAST_PREV = r11_NON_CON_ONLAST_PREV;
	}

	public String getR11_TOT_BRAN_PREV() {
		return R11_TOT_BRAN_PREV;
	}

	public void setR11_TOT_BRAN_PREV(String r11_TOT_BRAN_PREV) {
		R11_TOT_BRAN_PREV = r11_TOT_BRAN_PREV;
	}

	public String getR11_TOT_REV_RET_CUR() {
		return R11_TOT_REV_RET_CUR;
	}

	public void setR11_TOT_REV_RET_CUR(String r11_TOT_REV_RET_CUR) {
		R11_TOT_REV_RET_CUR = r11_TOT_REV_RET_CUR;
	}

	public String getR11_PROF_LOS_PORT_CUR() {
		return R11_PROF_LOS_PORT_CUR;
	}

	public void setR11_PROF_LOS_PORT_CUR(String r11_PROF_LOS_PORT_CUR) {
		R11_PROF_LOS_PORT_CUR = r11_PROF_LOS_PORT_CUR;
	}

	public String getR11_PROF_MARG_PERC_CUR() {
		return R11_PROF_MARG_PERC_CUR;
	}

	public void setR11_PROF_MARG_PERC_CUR(String r11_PROF_MARG_PERC_CUR) {
		R11_PROF_MARG_PERC_CUR = r11_PROF_MARG_PERC_CUR;
	}

	public String getR11_TOT_RET_ASET_CUR() {
		return R11_TOT_RET_ASET_CUR;
	}

	public void setR11_TOT_RET_ASET_CUR(String r11_TOT_RET_ASET_CUR) {
		R11_TOT_RET_ASET_CUR = r11_TOT_RET_ASET_CUR;
	}

	public String getR11_NON_PER_RET_PORT_CUR() {
		return R11_NON_PER_RET_PORT_CUR;
	}

	public void setR11_NON_PER_RET_PORT_CUR(String r11_NON_PER_RET_PORT_CUR) {
		R11_NON_PER_RET_PORT_CUR = r11_NON_PER_RET_PORT_CUR;
	}

	public String getR11_NO_CON_LAST_CUR() {
		return R11_NO_CON_LAST_CUR;
	}

	public void setR11_NO_CON_LAST_CUR(String r11_NO_CON_LAST_CUR) {
		R11_NO_CON_LAST_CUR = r11_NO_CON_LAST_CUR;
	}

	public String getR11_TOT_BRANCH_CUR() {
		return R11_TOT_BRANCH_CUR;
	}

	public void setR11_TOT_BRANCH_CUR(String r11_TOT_BRANCH_CUR) {
		R11_TOT_BRANCH_CUR = r11_TOT_BRANCH_CUR;
	}

	public String getR11_TOT_REV_T1() {
		return R11_TOT_REV_T1;
	}

	public void setR11_TOT_REV_T1(String r11_TOT_REV_T1) {
		R11_TOT_REV_T1 = r11_TOT_REV_T1;
	}

	public String getR11_PROF_LOS_T1() {
		return R11_PROF_LOS_T1;
	}

	public void setR11_PROF_LOS_T1(String r11_PROF_LOS_T1) {
		R11_PROF_LOS_T1 = r11_PROF_LOS_T1;
	}

	public String getR11_PROF_MARG_T1() {
		return R11_PROF_MARG_T1;
	}

	public void setR11_PROF_MARG_T1(String r11_PROF_MARG_T1) {
		R11_PROF_MARG_T1 = r11_PROF_MARG_T1;
	}

	public String getR11_TOT_RET_ASET_T1() {
		return R11_TOT_RET_ASET_T1;
	}

	public void setR11_TOT_RET_ASET_T1(String r11_TOT_RET_ASET_T1) {
		R11_TOT_RET_ASET_T1 = r11_TOT_RET_ASET_T1;
	}

	public String getR11_NON_PERF_PORT_T1() {
		return R11_NON_PERF_PORT_T1;
	}

	public void setR11_NON_PERF_PORT_T1(String r11_NON_PERF_PORT_T1) {
		R11_NON_PERF_PORT_T1 = r11_NON_PERF_PORT_T1;
	}

	public String getR11_NO_CON_LAST_T1() {
		return R11_NO_CON_LAST_T1;
	}

	public void setR11_NO_CON_LAST_T1(String r11_NO_CON_LAST_T1) {
		R11_NO_CON_LAST_T1 = r11_NO_CON_LAST_T1;
	}

	public String getR11_TOT_BRANCH_T1() {
		return R11_TOT_BRANCH_T1;
	}

	public void setR11_TOT_BRANCH_T1(String r11_TOT_BRANCH_T1) {
		R11_TOT_BRANCH_T1 = r11_TOT_BRANCH_T1;
	}

	public String getR11_TOT_REV_T2() {
		return R11_TOT_REV_T2;
	}

	public void setR11_TOT_REV_T2(String r11_TOT_REV_T2) {
		R11_TOT_REV_T2 = r11_TOT_REV_T2;
	}

	public String getR11_PROF_LOS_T2() {
		return R11_PROF_LOS_T2;
	}

	public void setR11_PROF_LOS_T2(String r11_PROF_LOS_T2) {
		R11_PROF_LOS_T2 = r11_PROF_LOS_T2;
	}

	public String getR11_PROF_MARG_T2() {
		return R11_PROF_MARG_T2;
	}

	public void setR11_PROF_MARG_T2(String r11_PROF_MARG_T2) {
		R11_PROF_MARG_T2 = r11_PROF_MARG_T2;
	}

	public String getR11_TOT_RET_ASET_T2() {
		return R11_TOT_RET_ASET_T2;
	}

	public void setR11_TOT_RET_ASET_T2(String r11_TOT_RET_ASET_T2) {
		R11_TOT_RET_ASET_T2 = r11_TOT_RET_ASET_T2;
	}

	public String getR11_NON_PERF_PORT_T2() {
		return R11_NON_PERF_PORT_T2;
	}

	public void setR11_NON_PERF_PORT_T2(String r11_NON_PERF_PORT_T2) {
		R11_NON_PERF_PORT_T2 = r11_NON_PERF_PORT_T2;
	}

	public String getR11_NO_CON_LAST_T2() {
		return R11_NO_CON_LAST_T2;
	}

	public void setR11_NO_CON_LAST_T2(String r11_NO_CON_LAST_T2) {
		R11_NO_CON_LAST_T2 = r11_NO_CON_LAST_T2;
	}

	public String getR11_TOT_BRANCH_T2() {
		return R11_TOT_BRANCH_T2;
	}

	public void setR11_TOT_BRANCH_T2(String r11_TOT_BRANCH_T2) {
		R11_TOT_BRANCH_T2 = r11_TOT_BRANCH_T2;
	}

	public String getR11_TOT_REV_T3() {
		return R11_TOT_REV_T3;
	}

	public void setR11_TOT_REV_T3(String r11_TOT_REV_T3) {
		R11_TOT_REV_T3 = r11_TOT_REV_T3;
	}

	public String getR11_PROF_LOS_T3() {
		return R11_PROF_LOS_T3;
	}

	public void setR11_PROF_LOS_T3(String r11_PROF_LOS_T3) {
		R11_PROF_LOS_T3 = r11_PROF_LOS_T3;
	}

	public String getR11_PROF_MARG_T3() {
		return R11_PROF_MARG_T3;
	}

	public void setR11_PROF_MARG_T3(String r11_PROF_MARG_T3) {
		R11_PROF_MARG_T3 = r11_PROF_MARG_T3;
	}

	public String getR11_TOT_RET_ASET_T3() {
		return R11_TOT_RET_ASET_T3;
	}

	public void setR11_TOT_RET_ASET_T3(String r11_TOT_RET_ASET_T3) {
		R11_TOT_RET_ASET_T3 = r11_TOT_RET_ASET_T3;
	}

	public String getR11_NON_PERF_PORT_T3() {
		return R11_NON_PERF_PORT_T3;
	}

	public void setR11_NON_PERF_PORT_T3(String r11_NON_PERF_PORT_T3) {
		R11_NON_PERF_PORT_T3 = r11_NON_PERF_PORT_T3;
	}

	public String getR11_NO_CON_LAST_T3() {
		return R11_NO_CON_LAST_T3;
	}

	public void setR11_NO_CON_LAST_T3(String r11_NO_CON_LAST_T3) {
		R11_NO_CON_LAST_T3 = r11_NO_CON_LAST_T3;
	}

	public String getR11_TOT_BRANCH_T3() {
		return R11_TOT_BRANCH_T3;
	}

	public void setR11_TOT_BRANCH_T3(String r11_TOT_BRANCH_T3) {
		R11_TOT_BRANCH_T3 = r11_TOT_BRANCH_T3;
	}

	public String getR11_NPL_SPD() {
		return R11_NPL_SPD;
	}

	public void setR11_NPL_SPD(String r11_NPL_SPD) {
		R11_NPL_SPD = r11_NPL_SPD;
	}

	public String getR11_RECO_NPL_SPD() {
		return R11_RECO_NPL_SPD;
	}

	public void setR11_RECO_NPL_SPD(String r11_RECO_NPL_SPD) {
		R11_RECO_NPL_SPD = r11_RECO_NPL_SPD;
	}

	public String getR11_NO_CON_ONBO_DIGI() {
		return R11_NO_CON_ONBO_DIGI;
	}

	public void setR11_NO_CON_ONBO_DIGI(String r11_NO_CON_ONBO_DIGI) {
		R11_NO_CON_ONBO_DIGI = r11_NO_CON_ONBO_DIGI;
	}

	public String getR11_NO_ACCS_AML() {
		return R11_NO_ACCS_AML;
	}

	public void setR11_NO_ACCS_AML(String r11_NO_ACCS_AML) {
		R11_NO_ACCS_AML = r11_NO_ACCS_AML;
	}

	public String getR11_TOT_ACC_LOAN_AML() {
		return R11_TOT_ACC_LOAN_AML;
	}

	public void setR11_TOT_ACC_LOAN_AML(String r11_TOT_ACC_LOAN_AML) {
		R11_TOT_ACC_LOAN_AML = r11_TOT_ACC_LOAN_AML;
	}

	public String getR11_TOT_NEW_ACCS_SPD() {
		return R11_TOT_NEW_ACCS_SPD;
	}

	public void setR11_TOT_NEW_ACCS_SPD(String r11_TOT_NEW_ACCS_SPD) {
		R11_TOT_NEW_ACCS_SPD = r11_TOT_NEW_ACCS_SPD;
	}

	public String getR11_TOT_VALS_LOANS_SPD() {
		return R11_TOT_VALS_LOANS_SPD;
	}

	public void setR11_TOT_VALS_LOANS_SPD(String r11_TOT_VALS_LOANS_SPD) {
		R11_TOT_VALS_LOANS_SPD = r11_TOT_VALS_LOANS_SPD;
	}

	public String getR11_NO_INQ_WEBMOB() {
		return R11_NO_INQ_WEBMOB;
	}

	public void setR11_NO_INQ_WEBMOB(String r11_NO_INQ_WEBMOB) {
		R11_NO_INQ_WEBMOB = r11_NO_INQ_WEBMOB;
	}

	public String getR11_NO_INQ_TRAD() {
		return R11_NO_INQ_TRAD;
	}

	public void setR11_NO_INQ_TRAD(String r11_NO_INQ_TRAD) {
		R11_NO_INQ_TRAD = r11_NO_INQ_TRAD;
	}

	public String getR11_NO_RET_POS() {
		return R11_NO_RET_POS;
	}

	public void setR11_NO_RET_POS(String r11_NO_RET_POS) {
		R11_NO_RET_POS = r11_NO_RET_POS;
	}

	public String getR11_AMT_POS_GATE() {
		return R11_AMT_POS_GATE;
	}

	public void setR11_AMT_POS_GATE(String r11_AMT_POS_GATE) {
		R11_AMT_POS_GATE = r11_AMT_POS_GATE;
	}

	public String getR11_NO_TRAN_SVF_BNK() {
		return R11_NO_TRAN_SVF_BNK;
	}

	public void setR11_NO_TRAN_SVF_BNK(String r11_NO_TRAN_SVF_BNK) {
		R11_NO_TRAN_SVF_BNK = r11_NO_TRAN_SVF_BNK;
	}

	public String getR11_AMT_RET_SVF_BNK() {
		return R11_AMT_RET_SVF_BNK;
	}

	public void setR11_AMT_RET_SVF_BNK(String r11_AMT_RET_SVF_BNK) {
		R11_AMT_RET_SVF_BNK = r11_AMT_RET_SVF_BNK;
	}

	public String getR11_TOT_WEB_MOB_VIRT() {
		return R11_TOT_WEB_MOB_VIRT;
	}

	public void setR11_TOT_WEB_MOB_VIRT(String r11_TOT_WEB_MOB_VIRT) {
		R11_TOT_WEB_MOB_VIRT = r11_TOT_WEB_MOB_VIRT;
	}

	public String getR11_VAL_UNCL_SVF() {
		return R11_VAL_UNCL_SVF;
	}

	public void setR11_VAL_UNCL_SVF(String r11_VAL_UNCL_SVF) {
		R11_VAL_UNCL_SVF = r11_VAL_UNCL_SVF;
	}

	public String getR11_NO_CON_LOW_RSK() {
		return R11_NO_CON_LOW_RSK;
	}

	public void setR11_NO_CON_LOW_RSK(String r11_NO_CON_LOW_RSK) {
		R11_NO_CON_LOW_RSK = r11_NO_CON_LOW_RSK;
	}

	public String getR11_NO_CON_HIGH_RSK() {
		return R11_NO_CON_HIGH_RSK;
	}

	public void setR11_NO_CON_HIGH_RSK(String r11_NO_CON_HIGH_RSK) {
		R11_NO_CON_HIGH_RSK = r11_NO_CON_HIGH_RSK;
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

	public String getR12_RET_ASET_LTS() {
		return R12_RET_ASET_LTS;
	}

	public void setR12_RET_ASET_LTS(String r12_RET_ASET_LTS) {
		R12_RET_ASET_LTS = r12_RET_ASET_LTS;
	}

	public String getR12_RET_ASET_LTSME() {
		return R12_RET_ASET_LTSME;
	}

	public void setR12_RET_ASET_LTSME(String r12_RET_ASET_LTSME) {
		R12_RET_ASET_LTSME = r12_RET_ASET_LTSME;
	}

	public String getR12_RET_ASET_SME_GUR() {
		return R12_RET_ASET_SME_GUR;
	}

	public void setR12_RET_ASET_SME_GUR(String r12_RET_ASET_SME_GUR) {
		R12_RET_ASET_SME_GUR = r12_RET_ASET_SME_GUR;
	}

	public String getR12_RET_LOAN_DIS() {
		return R12_RET_LOAN_DIS;
	}

	public void setR12_RET_LOAN_DIS(String r12_RET_LOAN_DIS) {
		R12_RET_LOAN_DIS = r12_RET_LOAN_DIS;
	}

	public String getR12_RET_ASET_LOAN_SME() {
		return R12_RET_ASET_LOAN_SME;
	}

	public void setR12_RET_ASET_LOAN_SME(String r12_RET_ASET_LOAN_SME) {
		R12_RET_ASET_LOAN_SME = r12_RET_ASET_LOAN_SME;
	}

	public String getR12_PER_LOAN_WEB() {
		return R12_PER_LOAN_WEB;
	}

	public void setR12_PER_LOAN_WEB(String r12_PER_LOAN_WEB) {
		R12_PER_LOAN_WEB = r12_PER_LOAN_WEB;
	}

	public String getR12_LOAN_SME_WEB_MOB() {
		return R12_LOAN_SME_WEB_MOB;
	}

	public void setR12_LOAN_SME_WEB_MOB(String r12_LOAN_SME_WEB_MOB) {
		R12_LOAN_SME_WEB_MOB = r12_LOAN_SME_WEB_MOB;
	}

	public String getR12_NO_COMPDIGI_MOB() {
		return R12_NO_COMPDIGI_MOB;
	}

	public void setR12_NO_COMPDIGI_MOB(String r12_NO_COMPDIGI_MOB) {
		R12_NO_COMPDIGI_MOB = r12_NO_COMPDIGI_MOB;
	}

	public String getR12_NO_COMP_TRADCALL() {
		return R12_NO_COMP_TRADCALL;
	}

	public void setR12_NO_COMP_TRADCALL(String r12_NO_COMP_TRADCALL) {
		R12_NO_COMP_TRADCALL = r12_NO_COMP_TRADCALL;
	}

	public String getR12_PER_COMPDIGI_WEB() {
		return R12_PER_COMPDIGI_WEB;
	}

	public void setR12_PER_COMPDIGI_WEB(String r12_PER_COMPDIGI_WEB) {
		R12_PER_COMPDIGI_WEB = r12_PER_COMPDIGI_WEB;
	}

	public String getR12_PER_COM_TRADCALL() {
		return R12_PER_COM_TRADCALL;
	}

	public void setR12_PER_COM_TRADCALL(String r12_PER_COM_TRADCALL) {
		R12_PER_COM_TRADCALL = r12_PER_COM_TRADCALL;
	}

	public String getR12_TOT_REV_PREV() {
		return R12_TOT_REV_PREV;
	}

	public void setR12_TOT_REV_PREV(String r12_TOT_REV_PREV) {
		R12_TOT_REV_PREV = r12_TOT_REV_PREV;
	}

	public String getR12_PROF_LOSS_PREV() {
		return R12_PROF_LOSS_PREV;
	}

	public void setR12_PROF_LOSS_PREV(String r12_PROF_LOSS_PREV) {
		R12_PROF_LOSS_PREV = r12_PROF_LOSS_PREV;
	}

	public String getR12_PROF_MARG_PORTFOLIO() {
		return R12_PROF_MARG_PORTFOLIO;
	}

	public void setR12_PROF_MARG_PORTFOLIO(String r12_PROF_MARG_PORTFOLIO) {
		R12_PROF_MARG_PORTFOLIO = r12_PROF_MARG_PORTFOLIO;
	}

	public String getR12_TOT_RET_ASET_PREV() {
		return R12_TOT_RET_ASET_PREV;
	}

	public void setR12_TOT_RET_ASET_PREV(String r12_TOT_RET_ASET_PREV) {
		R12_TOT_RET_ASET_PREV = r12_TOT_RET_ASET_PREV;
	}

	public String getR12_NP_LOAN_PREV() {
		return R12_NP_LOAN_PREV;
	}

	public void setR12_NP_LOAN_PREV(String r12_NP_LOAN_PREV) {
		R12_NP_LOAN_PREV = r12_NP_LOAN_PREV;
	}

	public String getR12_NON_CON_ONLAST_PREV() {
		return R12_NON_CON_ONLAST_PREV;
	}

	public void setR12_NON_CON_ONLAST_PREV(String r12_NON_CON_ONLAST_PREV) {
		R12_NON_CON_ONLAST_PREV = r12_NON_CON_ONLAST_PREV;
	}

	public String getR12_TOT_BRAN_PREV() {
		return R12_TOT_BRAN_PREV;
	}

	public void setR12_TOT_BRAN_PREV(String r12_TOT_BRAN_PREV) {
		R12_TOT_BRAN_PREV = r12_TOT_BRAN_PREV;
	}

	public String getR12_TOT_REV_RET_CUR() {
		return R12_TOT_REV_RET_CUR;
	}

	public void setR12_TOT_REV_RET_CUR(String r12_TOT_REV_RET_CUR) {
		R12_TOT_REV_RET_CUR = r12_TOT_REV_RET_CUR;
	}

	public String getR12_PROF_LOS_PORT_CUR() {
		return R12_PROF_LOS_PORT_CUR;
	}

	public void setR12_PROF_LOS_PORT_CUR(String r12_PROF_LOS_PORT_CUR) {
		R12_PROF_LOS_PORT_CUR = r12_PROF_LOS_PORT_CUR;
	}

	public String getR12_PROF_MARG_PERC_CUR() {
		return R12_PROF_MARG_PERC_CUR;
	}

	public void setR12_PROF_MARG_PERC_CUR(String r12_PROF_MARG_PERC_CUR) {
		R12_PROF_MARG_PERC_CUR = r12_PROF_MARG_PERC_CUR;
	}

	public String getR12_TOT_RET_ASET_CUR() {
		return R12_TOT_RET_ASET_CUR;
	}

	public void setR12_TOT_RET_ASET_CUR(String r12_TOT_RET_ASET_CUR) {
		R12_TOT_RET_ASET_CUR = r12_TOT_RET_ASET_CUR;
	}

	public String getR12_NON_PER_RET_PORT_CUR() {
		return R12_NON_PER_RET_PORT_CUR;
	}

	public void setR12_NON_PER_RET_PORT_CUR(String r12_NON_PER_RET_PORT_CUR) {
		R12_NON_PER_RET_PORT_CUR = r12_NON_PER_RET_PORT_CUR;
	}

	public String getR12_NO_CON_LAST_CUR() {
		return R12_NO_CON_LAST_CUR;
	}

	public void setR12_NO_CON_LAST_CUR(String r12_NO_CON_LAST_CUR) {
		R12_NO_CON_LAST_CUR = r12_NO_CON_LAST_CUR;
	}

	public String getR12_TOT_BRANCH_CUR() {
		return R12_TOT_BRANCH_CUR;
	}

	public void setR12_TOT_BRANCH_CUR(String r12_TOT_BRANCH_CUR) {
		R12_TOT_BRANCH_CUR = r12_TOT_BRANCH_CUR;
	}

	public String getR12_TOT_REV_T1() {
		return R12_TOT_REV_T1;
	}

	public void setR12_TOT_REV_T1(String r12_TOT_REV_T1) {
		R12_TOT_REV_T1 = r12_TOT_REV_T1;
	}

	public String getR12_PROF_LOS_T1() {
		return R12_PROF_LOS_T1;
	}

	public void setR12_PROF_LOS_T1(String r12_PROF_LOS_T1) {
		R12_PROF_LOS_T1 = r12_PROF_LOS_T1;
	}

	public String getR12_PROF_MARG_T1() {
		return R12_PROF_MARG_T1;
	}

	public void setR12_PROF_MARG_T1(String r12_PROF_MARG_T1) {
		R12_PROF_MARG_T1 = r12_PROF_MARG_T1;
	}

	public String getR12_TOT_RET_ASET_T1() {
		return R12_TOT_RET_ASET_T1;
	}

	public void setR12_TOT_RET_ASET_T1(String r12_TOT_RET_ASET_T1) {
		R12_TOT_RET_ASET_T1 = r12_TOT_RET_ASET_T1;
	}

	public String getR12_NON_PERF_PORT_T1() {
		return R12_NON_PERF_PORT_T1;
	}

	public void setR12_NON_PERF_PORT_T1(String r12_NON_PERF_PORT_T1) {
		R12_NON_PERF_PORT_T1 = r12_NON_PERF_PORT_T1;
	}

	public String getR12_NO_CON_LAST_T1() {
		return R12_NO_CON_LAST_T1;
	}

	public void setR12_NO_CON_LAST_T1(String r12_NO_CON_LAST_T1) {
		R12_NO_CON_LAST_T1 = r12_NO_CON_LAST_T1;
	}

	public String getR12_TOT_BRANCH_T1() {
		return R12_TOT_BRANCH_T1;
	}

	public void setR12_TOT_BRANCH_T1(String r12_TOT_BRANCH_T1) {
		R12_TOT_BRANCH_T1 = r12_TOT_BRANCH_T1;
	}

	public String getR12_TOT_REV_T2() {
		return R12_TOT_REV_T2;
	}

	public void setR12_TOT_REV_T2(String r12_TOT_REV_T2) {
		R12_TOT_REV_T2 = r12_TOT_REV_T2;
	}

	public String getR12_PROF_LOS_T2() {
		return R12_PROF_LOS_T2;
	}

	public void setR12_PROF_LOS_T2(String r12_PROF_LOS_T2) {
		R12_PROF_LOS_T2 = r12_PROF_LOS_T2;
	}

	public String getR12_PROF_MARG_T2() {
		return R12_PROF_MARG_T2;
	}

	public void setR12_PROF_MARG_T2(String r12_PROF_MARG_T2) {
		R12_PROF_MARG_T2 = r12_PROF_MARG_T2;
	}

	public String getR12_TOT_RET_ASET_T2() {
		return R12_TOT_RET_ASET_T2;
	}

	public void setR12_TOT_RET_ASET_T2(String r12_TOT_RET_ASET_T2) {
		R12_TOT_RET_ASET_T2 = r12_TOT_RET_ASET_T2;
	}

	public String getR12_NON_PERF_PORT_T2() {
		return R12_NON_PERF_PORT_T2;
	}

	public void setR12_NON_PERF_PORT_T2(String r12_NON_PERF_PORT_T2) {
		R12_NON_PERF_PORT_T2 = r12_NON_PERF_PORT_T2;
	}

	public String getR12_NO_CON_LAST_T2() {
		return R12_NO_CON_LAST_T2;
	}

	public void setR12_NO_CON_LAST_T2(String r12_NO_CON_LAST_T2) {
		R12_NO_CON_LAST_T2 = r12_NO_CON_LAST_T2;
	}

	public String getR12_TOT_BRANCH_T2() {
		return R12_TOT_BRANCH_T2;
	}

	public void setR12_TOT_BRANCH_T2(String r12_TOT_BRANCH_T2) {
		R12_TOT_BRANCH_T2 = r12_TOT_BRANCH_T2;
	}

	public String getR12_TOT_REV_T3() {
		return R12_TOT_REV_T3;
	}

	public void setR12_TOT_REV_T3(String r12_TOT_REV_T3) {
		R12_TOT_REV_T3 = r12_TOT_REV_T3;
	}

	public String getR12_PROF_LOS_T3() {
		return R12_PROF_LOS_T3;
	}

	public void setR12_PROF_LOS_T3(String r12_PROF_LOS_T3) {
		R12_PROF_LOS_T3 = r12_PROF_LOS_T3;
	}

	public String getR12_PROF_MARG_T3() {
		return R12_PROF_MARG_T3;
	}

	public void setR12_PROF_MARG_T3(String r12_PROF_MARG_T3) {
		R12_PROF_MARG_T3 = r12_PROF_MARG_T3;
	}

	public String getR12_TOT_RET_ASET_T3() {
		return R12_TOT_RET_ASET_T3;
	}

	public void setR12_TOT_RET_ASET_T3(String r12_TOT_RET_ASET_T3) {
		R12_TOT_RET_ASET_T3 = r12_TOT_RET_ASET_T3;
	}

	public String getR12_NON_PERF_PORT_T3() {
		return R12_NON_PERF_PORT_T3;
	}

	public void setR12_NON_PERF_PORT_T3(String r12_NON_PERF_PORT_T3) {
		R12_NON_PERF_PORT_T3 = r12_NON_PERF_PORT_T3;
	}

	public String getR12_NO_CON_LAST_T3() {
		return R12_NO_CON_LAST_T3;
	}

	public void setR12_NO_CON_LAST_T3(String r12_NO_CON_LAST_T3) {
		R12_NO_CON_LAST_T3 = r12_NO_CON_LAST_T3;
	}

	public String getR12_TOT_BRANCH_T3() {
		return R12_TOT_BRANCH_T3;
	}

	public void setR12_TOT_BRANCH_T3(String r12_TOT_BRANCH_T3) {
		R12_TOT_BRANCH_T3 = r12_TOT_BRANCH_T3;
	}

	public String getR12_NPL_SPD() {
		return R12_NPL_SPD;
	}

	public void setR12_NPL_SPD(String r12_NPL_SPD) {
		R12_NPL_SPD = r12_NPL_SPD;
	}

	public String getR12_RECO_NPL_SPD() {
		return R12_RECO_NPL_SPD;
	}

	public void setR12_RECO_NPL_SPD(String r12_RECO_NPL_SPD) {
		R12_RECO_NPL_SPD = r12_RECO_NPL_SPD;
	}

	public String getR12_NO_CON_ONBO_DIGI() {
		return R12_NO_CON_ONBO_DIGI;
	}

	public void setR12_NO_CON_ONBO_DIGI(String r12_NO_CON_ONBO_DIGI) {
		R12_NO_CON_ONBO_DIGI = r12_NO_CON_ONBO_DIGI;
	}

	public String getR12_NO_ACCS_AML() {
		return R12_NO_ACCS_AML;
	}

	public void setR12_NO_ACCS_AML(String r12_NO_ACCS_AML) {
		R12_NO_ACCS_AML = r12_NO_ACCS_AML;
	}

	public String getR12_TOT_ACC_LOAN_AML() {
		return R12_TOT_ACC_LOAN_AML;
	}

	public void setR12_TOT_ACC_LOAN_AML(String r12_TOT_ACC_LOAN_AML) {
		R12_TOT_ACC_LOAN_AML = r12_TOT_ACC_LOAN_AML;
	}

	public String getR12_TOT_NEW_ACCS_SPD() {
		return R12_TOT_NEW_ACCS_SPD;
	}

	public void setR12_TOT_NEW_ACCS_SPD(String r12_TOT_NEW_ACCS_SPD) {
		R12_TOT_NEW_ACCS_SPD = r12_TOT_NEW_ACCS_SPD;
	}

	public String getR12_TOT_VALS_LOANS_SPD() {
		return R12_TOT_VALS_LOANS_SPD;
	}

	public void setR12_TOT_VALS_LOANS_SPD(String r12_TOT_VALS_LOANS_SPD) {
		R12_TOT_VALS_LOANS_SPD = r12_TOT_VALS_LOANS_SPD;
	}

	public String getR12_NO_INQ_WEBMOB() {
		return R12_NO_INQ_WEBMOB;
	}

	public void setR12_NO_INQ_WEBMOB(String r12_NO_INQ_WEBMOB) {
		R12_NO_INQ_WEBMOB = r12_NO_INQ_WEBMOB;
	}

	public String getR12_NO_INQ_TRAD() {
		return R12_NO_INQ_TRAD;
	}

	public void setR12_NO_INQ_TRAD(String r12_NO_INQ_TRAD) {
		R12_NO_INQ_TRAD = r12_NO_INQ_TRAD;
	}

	public String getR12_NO_RET_POS() {
		return R12_NO_RET_POS;
	}

	public void setR12_NO_RET_POS(String r12_NO_RET_POS) {
		R12_NO_RET_POS = r12_NO_RET_POS;
	}

	public String getR12_AMT_POS_GATE() {
		return R12_AMT_POS_GATE;
	}

	public void setR12_AMT_POS_GATE(String r12_AMT_POS_GATE) {
		R12_AMT_POS_GATE = r12_AMT_POS_GATE;
	}

	public String getR12_NO_TRAN_SVF_BNK() {
		return R12_NO_TRAN_SVF_BNK;
	}

	public void setR12_NO_TRAN_SVF_BNK(String r12_NO_TRAN_SVF_BNK) {
		R12_NO_TRAN_SVF_BNK = r12_NO_TRAN_SVF_BNK;
	}

	public String getR12_AMT_RET_SVF_BNK() {
		return R12_AMT_RET_SVF_BNK;
	}

	public void setR12_AMT_RET_SVF_BNK(String r12_AMT_RET_SVF_BNK) {
		R12_AMT_RET_SVF_BNK = r12_AMT_RET_SVF_BNK;
	}

	public String getR12_TOT_WEB_MOB_VIRT() {
		return R12_TOT_WEB_MOB_VIRT;
	}

	public void setR12_TOT_WEB_MOB_VIRT(String r12_TOT_WEB_MOB_VIRT) {
		R12_TOT_WEB_MOB_VIRT = r12_TOT_WEB_MOB_VIRT;
	}

	public String getR12_VAL_UNCL_SVF() {
		return R12_VAL_UNCL_SVF;
	}

	public void setR12_VAL_UNCL_SVF(String r12_VAL_UNCL_SVF) {
		R12_VAL_UNCL_SVF = r12_VAL_UNCL_SVF;
	}

	public String getR12_NO_CON_LOW_RSK() {
		return R12_NO_CON_LOW_RSK;
	}

	public void setR12_NO_CON_LOW_RSK(String r12_NO_CON_LOW_RSK) {
		R12_NO_CON_LOW_RSK = r12_NO_CON_LOW_RSK;
	}

	public String getR12_NO_CON_HIGH_RSK() {
		return R12_NO_CON_HIGH_RSK;
	}

	public void setR12_NO_CON_HIGH_RSK(String r12_NO_CON_HIGH_RSK) {
		R12_NO_CON_HIGH_RSK = r12_NO_CON_HIGH_RSK;
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

	public String getR13_RET_ASET_LTS() {
		return R13_RET_ASET_LTS;
	}

	public void setR13_RET_ASET_LTS(String r13_RET_ASET_LTS) {
		R13_RET_ASET_LTS = r13_RET_ASET_LTS;
	}

	public String getR13_RET_ASET_LTSME() {
		return R13_RET_ASET_LTSME;
	}

	public void setR13_RET_ASET_LTSME(String r13_RET_ASET_LTSME) {
		R13_RET_ASET_LTSME = r13_RET_ASET_LTSME;
	}

	public String getR13_RET_ASET_SME_GUR() {
		return R13_RET_ASET_SME_GUR;
	}

	public void setR13_RET_ASET_SME_GUR(String r13_RET_ASET_SME_GUR) {
		R13_RET_ASET_SME_GUR = r13_RET_ASET_SME_GUR;
	}

	public String getR13_RET_LOAN_DIS() {
		return R13_RET_LOAN_DIS;
	}

	public void setR13_RET_LOAN_DIS(String r13_RET_LOAN_DIS) {
		R13_RET_LOAN_DIS = r13_RET_LOAN_DIS;
	}

	public String getR13_RET_ASET_LOAN_SME() {
		return R13_RET_ASET_LOAN_SME;
	}

	public void setR13_RET_ASET_LOAN_SME(String r13_RET_ASET_LOAN_SME) {
		R13_RET_ASET_LOAN_SME = r13_RET_ASET_LOAN_SME;
	}

	public String getR13_PER_LOAN_WEB() {
		return R13_PER_LOAN_WEB;
	}

	public void setR13_PER_LOAN_WEB(String r13_PER_LOAN_WEB) {
		R13_PER_LOAN_WEB = r13_PER_LOAN_WEB;
	}

	public String getR13_LOAN_SME_WEB_MOB() {
		return R13_LOAN_SME_WEB_MOB;
	}

	public void setR13_LOAN_SME_WEB_MOB(String r13_LOAN_SME_WEB_MOB) {
		R13_LOAN_SME_WEB_MOB = r13_LOAN_SME_WEB_MOB;
	}

	public String getR13_NO_COMPDIGI_MOB() {
		return R13_NO_COMPDIGI_MOB;
	}

	public void setR13_NO_COMPDIGI_MOB(String r13_NO_COMPDIGI_MOB) {
		R13_NO_COMPDIGI_MOB = r13_NO_COMPDIGI_MOB;
	}

	public String getR13_NO_COMP_TRADCALL() {
		return R13_NO_COMP_TRADCALL;
	}

	public void setR13_NO_COMP_TRADCALL(String r13_NO_COMP_TRADCALL) {
		R13_NO_COMP_TRADCALL = r13_NO_COMP_TRADCALL;
	}

	public String getR13_PER_COMPDIGI_WEB() {
		return R13_PER_COMPDIGI_WEB;
	}

	public void setR13_PER_COMPDIGI_WEB(String r13_PER_COMPDIGI_WEB) {
		R13_PER_COMPDIGI_WEB = r13_PER_COMPDIGI_WEB;
	}

	public String getR13_PER_COM_TRADCALL() {
		return R13_PER_COM_TRADCALL;
	}

	public void setR13_PER_COM_TRADCALL(String r13_PER_COM_TRADCALL) {
		R13_PER_COM_TRADCALL = r13_PER_COM_TRADCALL;
	}

	public String getR13_TOT_REV_PREV() {
		return R13_TOT_REV_PREV;
	}

	public void setR13_TOT_REV_PREV(String r13_TOT_REV_PREV) {
		R13_TOT_REV_PREV = r13_TOT_REV_PREV;
	}

	public String getR13_PROF_LOSS_PREV() {
		return R13_PROF_LOSS_PREV;
	}

	public void setR13_PROF_LOSS_PREV(String r13_PROF_LOSS_PREV) {
		R13_PROF_LOSS_PREV = r13_PROF_LOSS_PREV;
	}

	public String getR13_PROF_MARG_PORTFOLIO() {
		return R13_PROF_MARG_PORTFOLIO;
	}

	public void setR13_PROF_MARG_PORTFOLIO(String r13_PROF_MARG_PORTFOLIO) {
		R13_PROF_MARG_PORTFOLIO = r13_PROF_MARG_PORTFOLIO;
	}

	public String getR13_TOT_RET_ASET_PREV() {
		return R13_TOT_RET_ASET_PREV;
	}

	public void setR13_TOT_RET_ASET_PREV(String r13_TOT_RET_ASET_PREV) {
		R13_TOT_RET_ASET_PREV = r13_TOT_RET_ASET_PREV;
	}

	public String getR13_NP_LOAN_PREV() {
		return R13_NP_LOAN_PREV;
	}

	public void setR13_NP_LOAN_PREV(String r13_NP_LOAN_PREV) {
		R13_NP_LOAN_PREV = r13_NP_LOAN_PREV;
	}

	public String getR13_NON_CON_ONLAST_PREV() {
		return R13_NON_CON_ONLAST_PREV;
	}

	public void setR13_NON_CON_ONLAST_PREV(String r13_NON_CON_ONLAST_PREV) {
		R13_NON_CON_ONLAST_PREV = r13_NON_CON_ONLAST_PREV;
	}

	public String getR13_TOT_BRAN_PREV() {
		return R13_TOT_BRAN_PREV;
	}

	public void setR13_TOT_BRAN_PREV(String r13_TOT_BRAN_PREV) {
		R13_TOT_BRAN_PREV = r13_TOT_BRAN_PREV;
	}

	public String getR13_TOT_REV_RET_CUR() {
		return R13_TOT_REV_RET_CUR;
	}

	public void setR13_TOT_REV_RET_CUR(String r13_TOT_REV_RET_CUR) {
		R13_TOT_REV_RET_CUR = r13_TOT_REV_RET_CUR;
	}

	public String getR13_PROF_LOS_PORT_CUR() {
		return R13_PROF_LOS_PORT_CUR;
	}

	public void setR13_PROF_LOS_PORT_CUR(String r13_PROF_LOS_PORT_CUR) {
		R13_PROF_LOS_PORT_CUR = r13_PROF_LOS_PORT_CUR;
	}

	public String getR13_PROF_MARG_PERC_CUR() {
		return R13_PROF_MARG_PERC_CUR;
	}

	public void setR13_PROF_MARG_PERC_CUR(String r13_PROF_MARG_PERC_CUR) {
		R13_PROF_MARG_PERC_CUR = r13_PROF_MARG_PERC_CUR;
	}

	public String getR13_TOT_RET_ASET_CUR() {
		return R13_TOT_RET_ASET_CUR;
	}

	public void setR13_TOT_RET_ASET_CUR(String r13_TOT_RET_ASET_CUR) {
		R13_TOT_RET_ASET_CUR = r13_TOT_RET_ASET_CUR;
	}

	public String getR13_NON_PER_RET_PORT_CUR() {
		return R13_NON_PER_RET_PORT_CUR;
	}

	public void setR13_NON_PER_RET_PORT_CUR(String r13_NON_PER_RET_PORT_CUR) {
		R13_NON_PER_RET_PORT_CUR = r13_NON_PER_RET_PORT_CUR;
	}

	public String getR13_NO_CON_LAST_CUR() {
		return R13_NO_CON_LAST_CUR;
	}

	public void setR13_NO_CON_LAST_CUR(String r13_NO_CON_LAST_CUR) {
		R13_NO_CON_LAST_CUR = r13_NO_CON_LAST_CUR;
	}

	public String getR13_TOT_BRANCH_CUR() {
		return R13_TOT_BRANCH_CUR;
	}

	public void setR13_TOT_BRANCH_CUR(String r13_TOT_BRANCH_CUR) {
		R13_TOT_BRANCH_CUR = r13_TOT_BRANCH_CUR;
	}

	public String getR13_TOT_REV_T1() {
		return R13_TOT_REV_T1;
	}

	public void setR13_TOT_REV_T1(String r13_TOT_REV_T1) {
		R13_TOT_REV_T1 = r13_TOT_REV_T1;
	}

	public String getR13_PROF_LOS_T1() {
		return R13_PROF_LOS_T1;
	}

	public void setR13_PROF_LOS_T1(String r13_PROF_LOS_T1) {
		R13_PROF_LOS_T1 = r13_PROF_LOS_T1;
	}

	public String getR13_PROF_MARG_T1() {
		return R13_PROF_MARG_T1;
	}

	public void setR13_PROF_MARG_T1(String r13_PROF_MARG_T1) {
		R13_PROF_MARG_T1 = r13_PROF_MARG_T1;
	}

	public String getR13_TOT_RET_ASET_T1() {
		return R13_TOT_RET_ASET_T1;
	}

	public void setR13_TOT_RET_ASET_T1(String r13_TOT_RET_ASET_T1) {
		R13_TOT_RET_ASET_T1 = r13_TOT_RET_ASET_T1;
	}

	public String getR13_NON_PERF_PORT_T1() {
		return R13_NON_PERF_PORT_T1;
	}

	public void setR13_NON_PERF_PORT_T1(String r13_NON_PERF_PORT_T1) {
		R13_NON_PERF_PORT_T1 = r13_NON_PERF_PORT_T1;
	}

	public String getR13_NO_CON_LAST_T1() {
		return R13_NO_CON_LAST_T1;
	}

	public void setR13_NO_CON_LAST_T1(String r13_NO_CON_LAST_T1) {
		R13_NO_CON_LAST_T1 = r13_NO_CON_LAST_T1;
	}

	public String getR13_TOT_BRANCH_T1() {
		return R13_TOT_BRANCH_T1;
	}

	public void setR13_TOT_BRANCH_T1(String r13_TOT_BRANCH_T1) {
		R13_TOT_BRANCH_T1 = r13_TOT_BRANCH_T1;
	}

	public String getR13_TOT_REV_T2() {
		return R13_TOT_REV_T2;
	}

	public void setR13_TOT_REV_T2(String r13_TOT_REV_T2) {
		R13_TOT_REV_T2 = r13_TOT_REV_T2;
	}

	public String getR13_PROF_LOS_T2() {
		return R13_PROF_LOS_T2;
	}

	public void setR13_PROF_LOS_T2(String r13_PROF_LOS_T2) {
		R13_PROF_LOS_T2 = r13_PROF_LOS_T2;
	}

	public String getR13_PROF_MARG_T2() {
		return R13_PROF_MARG_T2;
	}

	public void setR13_PROF_MARG_T2(String r13_PROF_MARG_T2) {
		R13_PROF_MARG_T2 = r13_PROF_MARG_T2;
	}

	public String getR13_TOT_RET_ASET_T2() {
		return R13_TOT_RET_ASET_T2;
	}

	public void setR13_TOT_RET_ASET_T2(String r13_TOT_RET_ASET_T2) {
		R13_TOT_RET_ASET_T2 = r13_TOT_RET_ASET_T2;
	}

	public String getR13_NON_PERF_PORT_T2() {
		return R13_NON_PERF_PORT_T2;
	}

	public void setR13_NON_PERF_PORT_T2(String r13_NON_PERF_PORT_T2) {
		R13_NON_PERF_PORT_T2 = r13_NON_PERF_PORT_T2;
	}

	public String getR13_NO_CON_LAST_T2() {
		return R13_NO_CON_LAST_T2;
	}

	public void setR13_NO_CON_LAST_T2(String r13_NO_CON_LAST_T2) {
		R13_NO_CON_LAST_T2 = r13_NO_CON_LAST_T2;
	}

	public String getR13_TOT_BRANCH_T2() {
		return R13_TOT_BRANCH_T2;
	}

	public void setR13_TOT_BRANCH_T2(String r13_TOT_BRANCH_T2) {
		R13_TOT_BRANCH_T2 = r13_TOT_BRANCH_T2;
	}

	public String getR13_TOT_REV_T3() {
		return R13_TOT_REV_T3;
	}

	public void setR13_TOT_REV_T3(String r13_TOT_REV_T3) {
		R13_TOT_REV_T3 = r13_TOT_REV_T3;
	}

	public String getR13_PROF_LOS_T3() {
		return R13_PROF_LOS_T3;
	}

	public void setR13_PROF_LOS_T3(String r13_PROF_LOS_T3) {
		R13_PROF_LOS_T3 = r13_PROF_LOS_T3;
	}

	public String getR13_PROF_MARG_T3() {
		return R13_PROF_MARG_T3;
	}

	public void setR13_PROF_MARG_T3(String r13_PROF_MARG_T3) {
		R13_PROF_MARG_T3 = r13_PROF_MARG_T3;
	}

	public String getR13_TOT_RET_ASET_T3() {
		return R13_TOT_RET_ASET_T3;
	}

	public void setR13_TOT_RET_ASET_T3(String r13_TOT_RET_ASET_T3) {
		R13_TOT_RET_ASET_T3 = r13_TOT_RET_ASET_T3;
	}

	public String getR13_NON_PERF_PORT_T3() {
		return R13_NON_PERF_PORT_T3;
	}

	public void setR13_NON_PERF_PORT_T3(String r13_NON_PERF_PORT_T3) {
		R13_NON_PERF_PORT_T3 = r13_NON_PERF_PORT_T3;
	}

	public String getR13_NO_CON_LAST_T3() {
		return R13_NO_CON_LAST_T3;
	}

	public void setR13_NO_CON_LAST_T3(String r13_NO_CON_LAST_T3) {
		R13_NO_CON_LAST_T3 = r13_NO_CON_LAST_T3;
	}

	public String getR13_TOT_BRANCH_T3() {
		return R13_TOT_BRANCH_T3;
	}

	public void setR13_TOT_BRANCH_T3(String r13_TOT_BRANCH_T3) {
		R13_TOT_BRANCH_T3 = r13_TOT_BRANCH_T3;
	}

	public String getR13_NPL_SPD() {
		return R13_NPL_SPD;
	}

	public void setR13_NPL_SPD(String r13_NPL_SPD) {
		R13_NPL_SPD = r13_NPL_SPD;
	}

	public String getR13_RECO_NPL_SPD() {
		return R13_RECO_NPL_SPD;
	}

	public void setR13_RECO_NPL_SPD(String r13_RECO_NPL_SPD) {
		R13_RECO_NPL_SPD = r13_RECO_NPL_SPD;
	}

	public String getR13_NO_CON_ONBO_DIGI() {
		return R13_NO_CON_ONBO_DIGI;
	}

	public void setR13_NO_CON_ONBO_DIGI(String r13_NO_CON_ONBO_DIGI) {
		R13_NO_CON_ONBO_DIGI = r13_NO_CON_ONBO_DIGI;
	}

	public String getR13_NO_ACCS_AML() {
		return R13_NO_ACCS_AML;
	}

	public void setR13_NO_ACCS_AML(String r13_NO_ACCS_AML) {
		R13_NO_ACCS_AML = r13_NO_ACCS_AML;
	}

	public String getR13_TOT_ACC_LOAN_AML() {
		return R13_TOT_ACC_LOAN_AML;
	}

	public void setR13_TOT_ACC_LOAN_AML(String r13_TOT_ACC_LOAN_AML) {
		R13_TOT_ACC_LOAN_AML = r13_TOT_ACC_LOAN_AML;
	}

	public String getR13_TOT_NEW_ACCS_SPD() {
		return R13_TOT_NEW_ACCS_SPD;
	}

	public void setR13_TOT_NEW_ACCS_SPD(String r13_TOT_NEW_ACCS_SPD) {
		R13_TOT_NEW_ACCS_SPD = r13_TOT_NEW_ACCS_SPD;
	}

	public String getR13_TOT_VALS_LOANS_SPD() {
		return R13_TOT_VALS_LOANS_SPD;
	}

	public void setR13_TOT_VALS_LOANS_SPD(String r13_TOT_VALS_LOANS_SPD) {
		R13_TOT_VALS_LOANS_SPD = r13_TOT_VALS_LOANS_SPD;
	}

	public String getR13_NO_INQ_WEBMOB() {
		return R13_NO_INQ_WEBMOB;
	}

	public void setR13_NO_INQ_WEBMOB(String r13_NO_INQ_WEBMOB) {
		R13_NO_INQ_WEBMOB = r13_NO_INQ_WEBMOB;
	}

	public String getR13_NO_INQ_TRAD() {
		return R13_NO_INQ_TRAD;
	}

	public void setR13_NO_INQ_TRAD(String r13_NO_INQ_TRAD) {
		R13_NO_INQ_TRAD = r13_NO_INQ_TRAD;
	}

	public String getR13_NO_RET_POS() {
		return R13_NO_RET_POS;
	}

	public void setR13_NO_RET_POS(String r13_NO_RET_POS) {
		R13_NO_RET_POS = r13_NO_RET_POS;
	}

	public String getR13_AMT_POS_GATE() {
		return R13_AMT_POS_GATE;
	}

	public void setR13_AMT_POS_GATE(String r13_AMT_POS_GATE) {
		R13_AMT_POS_GATE = r13_AMT_POS_GATE;
	}

	public String getR13_NO_TRAN_SVF_BNK() {
		return R13_NO_TRAN_SVF_BNK;
	}

	public void setR13_NO_TRAN_SVF_BNK(String r13_NO_TRAN_SVF_BNK) {
		R13_NO_TRAN_SVF_BNK = r13_NO_TRAN_SVF_BNK;
	}

	public String getR13_AMT_RET_SVF_BNK() {
		return R13_AMT_RET_SVF_BNK;
	}

	public void setR13_AMT_RET_SVF_BNK(String r13_AMT_RET_SVF_BNK) {
		R13_AMT_RET_SVF_BNK = r13_AMT_RET_SVF_BNK;
	}

	public String getR13_TOT_WEB_MOB_VIRT() {
		return R13_TOT_WEB_MOB_VIRT;
	}

	public void setR13_TOT_WEB_MOB_VIRT(String r13_TOT_WEB_MOB_VIRT) {
		R13_TOT_WEB_MOB_VIRT = r13_TOT_WEB_MOB_VIRT;
	}

	public String getR13_VAL_UNCL_SVF() {
		return R13_VAL_UNCL_SVF;
	}

	public void setR13_VAL_UNCL_SVF(String r13_VAL_UNCL_SVF) {
		R13_VAL_UNCL_SVF = r13_VAL_UNCL_SVF;
	}

	public String getR13_NO_CON_LOW_RSK() {
		return R13_NO_CON_LOW_RSK;
	}

	public void setR13_NO_CON_LOW_RSK(String r13_NO_CON_LOW_RSK) {
		R13_NO_CON_LOW_RSK = r13_NO_CON_LOW_RSK;
	}

	public String getR13_NO_CON_HIGH_RSK() {
		return R13_NO_CON_HIGH_RSK;
	}

	public void setR13_NO_CON_HIGH_RSK(String r13_NO_CON_HIGH_RSK) {
		R13_NO_CON_HIGH_RSK = r13_NO_CON_HIGH_RSK;
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

	public String getR14_RET_ASET_LTS() {
		return R14_RET_ASET_LTS;
	}

	public void setR14_RET_ASET_LTS(String r14_RET_ASET_LTS) {
		R14_RET_ASET_LTS = r14_RET_ASET_LTS;
	}

	public String getR14_RET_ASET_LTSME() {
		return R14_RET_ASET_LTSME;
	}

	public void setR14_RET_ASET_LTSME(String r14_RET_ASET_LTSME) {
		R14_RET_ASET_LTSME = r14_RET_ASET_LTSME;
	}

	public String getR14_RET_ASET_SME_GUR() {
		return R14_RET_ASET_SME_GUR;
	}

	public void setR14_RET_ASET_SME_GUR(String r14_RET_ASET_SME_GUR) {
		R14_RET_ASET_SME_GUR = r14_RET_ASET_SME_GUR;
	}

	public String getR14_RET_LOAN_DIS() {
		return R14_RET_LOAN_DIS;
	}

	public void setR14_RET_LOAN_DIS(String r14_RET_LOAN_DIS) {
		R14_RET_LOAN_DIS = r14_RET_LOAN_DIS;
	}

	public String getR14_RET_ASET_LOAN_SME() {
		return R14_RET_ASET_LOAN_SME;
	}

	public void setR14_RET_ASET_LOAN_SME(String r14_RET_ASET_LOAN_SME) {
		R14_RET_ASET_LOAN_SME = r14_RET_ASET_LOAN_SME;
	}

	public String getR14_PER_LOAN_WEB() {
		return R14_PER_LOAN_WEB;
	}

	public void setR14_PER_LOAN_WEB(String r14_PER_LOAN_WEB) {
		R14_PER_LOAN_WEB = r14_PER_LOAN_WEB;
	}

	public String getR14_LOAN_SME_WEB_MOB() {
		return R14_LOAN_SME_WEB_MOB;
	}

	public void setR14_LOAN_SME_WEB_MOB(String r14_LOAN_SME_WEB_MOB) {
		R14_LOAN_SME_WEB_MOB = r14_LOAN_SME_WEB_MOB;
	}

	public String getR14_NO_COMPDIGI_MOB() {
		return R14_NO_COMPDIGI_MOB;
	}

	public void setR14_NO_COMPDIGI_MOB(String r14_NO_COMPDIGI_MOB) {
		R14_NO_COMPDIGI_MOB = r14_NO_COMPDIGI_MOB;
	}

	public String getR14_NO_COMP_TRADCALL() {
		return R14_NO_COMP_TRADCALL;
	}

	public void setR14_NO_COMP_TRADCALL(String r14_NO_COMP_TRADCALL) {
		R14_NO_COMP_TRADCALL = r14_NO_COMP_TRADCALL;
	}

	public String getR14_PER_COMPDIGI_WEB() {
		return R14_PER_COMPDIGI_WEB;
	}

	public void setR14_PER_COMPDIGI_WEB(String r14_PER_COMPDIGI_WEB) {
		R14_PER_COMPDIGI_WEB = r14_PER_COMPDIGI_WEB;
	}

	public String getR14_PER_COM_TRADCALL() {
		return R14_PER_COM_TRADCALL;
	}

	public void setR14_PER_COM_TRADCALL(String r14_PER_COM_TRADCALL) {
		R14_PER_COM_TRADCALL = r14_PER_COM_TRADCALL;
	}

	public String getR14_TOT_REV_PREV() {
		return R14_TOT_REV_PREV;
	}

	public void setR14_TOT_REV_PREV(String r14_TOT_REV_PREV) {
		R14_TOT_REV_PREV = r14_TOT_REV_PREV;
	}

	public String getR14_PROF_LOSS_PREV() {
		return R14_PROF_LOSS_PREV;
	}

	public void setR14_PROF_LOSS_PREV(String r14_PROF_LOSS_PREV) {
		R14_PROF_LOSS_PREV = r14_PROF_LOSS_PREV;
	}

	public String getR14_PROF_MARG_PORTFOLIO() {
		return R14_PROF_MARG_PORTFOLIO;
	}

	public void setR14_PROF_MARG_PORTFOLIO(String r14_PROF_MARG_PORTFOLIO) {
		R14_PROF_MARG_PORTFOLIO = r14_PROF_MARG_PORTFOLIO;
	}

	public String getR14_TOT_RET_ASET_PREV() {
		return R14_TOT_RET_ASET_PREV;
	}

	public void setR14_TOT_RET_ASET_PREV(String r14_TOT_RET_ASET_PREV) {
		R14_TOT_RET_ASET_PREV = r14_TOT_RET_ASET_PREV;
	}

	public String getR14_NP_LOAN_PREV() {
		return R14_NP_LOAN_PREV;
	}

	public void setR14_NP_LOAN_PREV(String r14_NP_LOAN_PREV) {
		R14_NP_LOAN_PREV = r14_NP_LOAN_PREV;
	}

	public String getR14_NON_CON_ONLAST_PREV() {
		return R14_NON_CON_ONLAST_PREV;
	}

	public void setR14_NON_CON_ONLAST_PREV(String r14_NON_CON_ONLAST_PREV) {
		R14_NON_CON_ONLAST_PREV = r14_NON_CON_ONLAST_PREV;
	}

	public String getR14_TOT_BRAN_PREV() {
		return R14_TOT_BRAN_PREV;
	}

	public void setR14_TOT_BRAN_PREV(String r14_TOT_BRAN_PREV) {
		R14_TOT_BRAN_PREV = r14_TOT_BRAN_PREV;
	}

	public String getR14_TOT_REV_RET_CUR() {
		return R14_TOT_REV_RET_CUR;
	}

	public void setR14_TOT_REV_RET_CUR(String r14_TOT_REV_RET_CUR) {
		R14_TOT_REV_RET_CUR = r14_TOT_REV_RET_CUR;
	}

	public String getR14_PROF_LOS_PORT_CUR() {
		return R14_PROF_LOS_PORT_CUR;
	}

	public void setR14_PROF_LOS_PORT_CUR(String r14_PROF_LOS_PORT_CUR) {
		R14_PROF_LOS_PORT_CUR = r14_PROF_LOS_PORT_CUR;
	}

	public String getR14_PROF_MARG_PERC_CUR() {
		return R14_PROF_MARG_PERC_CUR;
	}

	public void setR14_PROF_MARG_PERC_CUR(String r14_PROF_MARG_PERC_CUR) {
		R14_PROF_MARG_PERC_CUR = r14_PROF_MARG_PERC_CUR;
	}

	public String getR14_TOT_RET_ASET_CUR() {
		return R14_TOT_RET_ASET_CUR;
	}

	public void setR14_TOT_RET_ASET_CUR(String r14_TOT_RET_ASET_CUR) {
		R14_TOT_RET_ASET_CUR = r14_TOT_RET_ASET_CUR;
	}

	public String getR14_NON_PER_RET_PORT_CUR() {
		return R14_NON_PER_RET_PORT_CUR;
	}

	public void setR14_NON_PER_RET_PORT_CUR(String r14_NON_PER_RET_PORT_CUR) {
		R14_NON_PER_RET_PORT_CUR = r14_NON_PER_RET_PORT_CUR;
	}

	public String getR14_NO_CON_LAST_CUR() {
		return R14_NO_CON_LAST_CUR;
	}

	public void setR14_NO_CON_LAST_CUR(String r14_NO_CON_LAST_CUR) {
		R14_NO_CON_LAST_CUR = r14_NO_CON_LAST_CUR;
	}

	public String getR14_TOT_BRANCH_CUR() {
		return R14_TOT_BRANCH_CUR;
	}

	public void setR14_TOT_BRANCH_CUR(String r14_TOT_BRANCH_CUR) {
		R14_TOT_BRANCH_CUR = r14_TOT_BRANCH_CUR;
	}

	public String getR14_TOT_REV_T1() {
		return R14_TOT_REV_T1;
	}

	public void setR14_TOT_REV_T1(String r14_TOT_REV_T1) {
		R14_TOT_REV_T1 = r14_TOT_REV_T1;
	}

	public String getR14_PROF_LOS_T1() {
		return R14_PROF_LOS_T1;
	}

	public void setR14_PROF_LOS_T1(String r14_PROF_LOS_T1) {
		R14_PROF_LOS_T1 = r14_PROF_LOS_T1;
	}

	public String getR14_PROF_MARG_T1() {
		return R14_PROF_MARG_T1;
	}

	public void setR14_PROF_MARG_T1(String r14_PROF_MARG_T1) {
		R14_PROF_MARG_T1 = r14_PROF_MARG_T1;
	}

	public String getR14_TOT_RET_ASET_T1() {
		return R14_TOT_RET_ASET_T1;
	}

	public void setR14_TOT_RET_ASET_T1(String r14_TOT_RET_ASET_T1) {
		R14_TOT_RET_ASET_T1 = r14_TOT_RET_ASET_T1;
	}

	public String getR14_NON_PERF_PORT_T1() {
		return R14_NON_PERF_PORT_T1;
	}

	public void setR14_NON_PERF_PORT_T1(String r14_NON_PERF_PORT_T1) {
		R14_NON_PERF_PORT_T1 = r14_NON_PERF_PORT_T1;
	}

	public String getR14_NO_CON_LAST_T1() {
		return R14_NO_CON_LAST_T1;
	}

	public void setR14_NO_CON_LAST_T1(String r14_NO_CON_LAST_T1) {
		R14_NO_CON_LAST_T1 = r14_NO_CON_LAST_T1;
	}

	public String getR14_TOT_BRANCH_T1() {
		return R14_TOT_BRANCH_T1;
	}

	public void setR14_TOT_BRANCH_T1(String r14_TOT_BRANCH_T1) {
		R14_TOT_BRANCH_T1 = r14_TOT_BRANCH_T1;
	}

	public String getR14_TOT_REV_T2() {
		return R14_TOT_REV_T2;
	}

	public void setR14_TOT_REV_T2(String r14_TOT_REV_T2) {
		R14_TOT_REV_T2 = r14_TOT_REV_T2;
	}

	public String getR14_PROF_LOS_T2() {
		return R14_PROF_LOS_T2;
	}

	public void setR14_PROF_LOS_T2(String r14_PROF_LOS_T2) {
		R14_PROF_LOS_T2 = r14_PROF_LOS_T2;
	}

	public String getR14_PROF_MARG_T2() {
		return R14_PROF_MARG_T2;
	}

	public void setR14_PROF_MARG_T2(String r14_PROF_MARG_T2) {
		R14_PROF_MARG_T2 = r14_PROF_MARG_T2;
	}

	public String getR14_TOT_RET_ASET_T2() {
		return R14_TOT_RET_ASET_T2;
	}

	public void setR14_TOT_RET_ASET_T2(String r14_TOT_RET_ASET_T2) {
		R14_TOT_RET_ASET_T2 = r14_TOT_RET_ASET_T2;
	}

	public String getR14_NON_PERF_PORT_T2() {
		return R14_NON_PERF_PORT_T2;
	}

	public void setR14_NON_PERF_PORT_T2(String r14_NON_PERF_PORT_T2) {
		R14_NON_PERF_PORT_T2 = r14_NON_PERF_PORT_T2;
	}

	public String getR14_NO_CON_LAST_T2() {
		return R14_NO_CON_LAST_T2;
	}

	public void setR14_NO_CON_LAST_T2(String r14_NO_CON_LAST_T2) {
		R14_NO_CON_LAST_T2 = r14_NO_CON_LAST_T2;
	}

	public String getR14_TOT_BRANCH_T2() {
		return R14_TOT_BRANCH_T2;
	}

	public void setR14_TOT_BRANCH_T2(String r14_TOT_BRANCH_T2) {
		R14_TOT_BRANCH_T2 = r14_TOT_BRANCH_T2;
	}

	public String getR14_TOT_REV_T3() {
		return R14_TOT_REV_T3;
	}

	public void setR14_TOT_REV_T3(String r14_TOT_REV_T3) {
		R14_TOT_REV_T3 = r14_TOT_REV_T3;
	}

	public String getR14_PROF_LOS_T3() {
		return R14_PROF_LOS_T3;
	}

	public void setR14_PROF_LOS_T3(String r14_PROF_LOS_T3) {
		R14_PROF_LOS_T3 = r14_PROF_LOS_T3;
	}

	public String getR14_PROF_MARG_T3() {
		return R14_PROF_MARG_T3;
	}

	public void setR14_PROF_MARG_T3(String r14_PROF_MARG_T3) {
		R14_PROF_MARG_T3 = r14_PROF_MARG_T3;
	}

	public String getR14_TOT_RET_ASET_T3() {
		return R14_TOT_RET_ASET_T3;
	}

	public void setR14_TOT_RET_ASET_T3(String r14_TOT_RET_ASET_T3) {
		R14_TOT_RET_ASET_T3 = r14_TOT_RET_ASET_T3;
	}

	public String getR14_NON_PERF_PORT_T3() {
		return R14_NON_PERF_PORT_T3;
	}

	public void setR14_NON_PERF_PORT_T3(String r14_NON_PERF_PORT_T3) {
		R14_NON_PERF_PORT_T3 = r14_NON_PERF_PORT_T3;
	}

	public String getR14_NO_CON_LAST_T3() {
		return R14_NO_CON_LAST_T3;
	}

	public void setR14_NO_CON_LAST_T3(String r14_NO_CON_LAST_T3) {
		R14_NO_CON_LAST_T3 = r14_NO_CON_LAST_T3;
	}

	public String getR14_TOT_BRANCH_T3() {
		return R14_TOT_BRANCH_T3;
	}

	public void setR14_TOT_BRANCH_T3(String r14_TOT_BRANCH_T3) {
		R14_TOT_BRANCH_T3 = r14_TOT_BRANCH_T3;
	}

	public String getR14_NPL_SPD() {
		return R14_NPL_SPD;
	}

	public void setR14_NPL_SPD(String r14_NPL_SPD) {
		R14_NPL_SPD = r14_NPL_SPD;
	}

	public String getR14_RECO_NPL_SPD() {
		return R14_RECO_NPL_SPD;
	}

	public void setR14_RECO_NPL_SPD(String r14_RECO_NPL_SPD) {
		R14_RECO_NPL_SPD = r14_RECO_NPL_SPD;
	}

	public String getR14_NO_CON_ONBO_DIGI() {
		return R14_NO_CON_ONBO_DIGI;
	}

	public void setR14_NO_CON_ONBO_DIGI(String r14_NO_CON_ONBO_DIGI) {
		R14_NO_CON_ONBO_DIGI = r14_NO_CON_ONBO_DIGI;
	}

	public String getR14_NO_ACCS_AML() {
		return R14_NO_ACCS_AML;
	}

	public void setR14_NO_ACCS_AML(String r14_NO_ACCS_AML) {
		R14_NO_ACCS_AML = r14_NO_ACCS_AML;
	}

	public String getR14_TOT_ACC_LOAN_AML() {
		return R14_TOT_ACC_LOAN_AML;
	}

	public void setR14_TOT_ACC_LOAN_AML(String r14_TOT_ACC_LOAN_AML) {
		R14_TOT_ACC_LOAN_AML = r14_TOT_ACC_LOAN_AML;
	}

	public String getR14_TOT_NEW_ACCS_SPD() {
		return R14_TOT_NEW_ACCS_SPD;
	}

	public void setR14_TOT_NEW_ACCS_SPD(String r14_TOT_NEW_ACCS_SPD) {
		R14_TOT_NEW_ACCS_SPD = r14_TOT_NEW_ACCS_SPD;
	}

	public String getR14_TOT_VALS_LOANS_SPD() {
		return R14_TOT_VALS_LOANS_SPD;
	}

	public void setR14_TOT_VALS_LOANS_SPD(String r14_TOT_VALS_LOANS_SPD) {
		R14_TOT_VALS_LOANS_SPD = r14_TOT_VALS_LOANS_SPD;
	}

	public String getR14_NO_INQ_WEBMOB() {
		return R14_NO_INQ_WEBMOB;
	}

	public void setR14_NO_INQ_WEBMOB(String r14_NO_INQ_WEBMOB) {
		R14_NO_INQ_WEBMOB = r14_NO_INQ_WEBMOB;
	}

	public String getR14_NO_INQ_TRAD() {
		return R14_NO_INQ_TRAD;
	}

	public void setR14_NO_INQ_TRAD(String r14_NO_INQ_TRAD) {
		R14_NO_INQ_TRAD = r14_NO_INQ_TRAD;
	}

	public String getR14_NO_RET_POS() {
		return R14_NO_RET_POS;
	}

	public void setR14_NO_RET_POS(String r14_NO_RET_POS) {
		R14_NO_RET_POS = r14_NO_RET_POS;
	}

	public String getR14_AMT_POS_GATE() {
		return R14_AMT_POS_GATE;
	}

	public void setR14_AMT_POS_GATE(String r14_AMT_POS_GATE) {
		R14_AMT_POS_GATE = r14_AMT_POS_GATE;
	}

	public String getR14_NO_TRAN_SVF_BNK() {
		return R14_NO_TRAN_SVF_BNK;
	}

	public void setR14_NO_TRAN_SVF_BNK(String r14_NO_TRAN_SVF_BNK) {
		R14_NO_TRAN_SVF_BNK = r14_NO_TRAN_SVF_BNK;
	}

	public String getR14_AMT_RET_SVF_BNK() {
		return R14_AMT_RET_SVF_BNK;
	}

	public void setR14_AMT_RET_SVF_BNK(String r14_AMT_RET_SVF_BNK) {
		R14_AMT_RET_SVF_BNK = r14_AMT_RET_SVF_BNK;
	}

	public String getR14_TOT_WEB_MOB_VIRT() {
		return R14_TOT_WEB_MOB_VIRT;
	}

	public void setR14_TOT_WEB_MOB_VIRT(String r14_TOT_WEB_MOB_VIRT) {
		R14_TOT_WEB_MOB_VIRT = r14_TOT_WEB_MOB_VIRT;
	}

	public String getR14_VAL_UNCL_SVF() {
		return R14_VAL_UNCL_SVF;
	}

	public void setR14_VAL_UNCL_SVF(String r14_VAL_UNCL_SVF) {
		R14_VAL_UNCL_SVF = r14_VAL_UNCL_SVF;
	}

	public String getR14_NO_CON_LOW_RSK() {
		return R14_NO_CON_LOW_RSK;
	}

	public void setR14_NO_CON_LOW_RSK(String r14_NO_CON_LOW_RSK) {
		R14_NO_CON_LOW_RSK = r14_NO_CON_LOW_RSK;
	}

	public String getR14_NO_CON_HIGH_RSK() {
		return R14_NO_CON_HIGH_RSK;
	}

	public void setR14_NO_CON_HIGH_RSK(String r14_NO_CON_HIGH_RSK) {
		R14_NO_CON_HIGH_RSK = r14_NO_CON_HIGH_RSK;
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

	public String getR15_RET_ASET_LTS() {
		return R15_RET_ASET_LTS;
	}

	public void setR15_RET_ASET_LTS(String r15_RET_ASET_LTS) {
		R15_RET_ASET_LTS = r15_RET_ASET_LTS;
	}

	public String getR15_RET_ASET_LTSME() {
		return R15_RET_ASET_LTSME;
	}

	public void setR15_RET_ASET_LTSME(String r15_RET_ASET_LTSME) {
		R15_RET_ASET_LTSME = r15_RET_ASET_LTSME;
	}

	public String getR15_RET_ASET_SME_GUR() {
		return R15_RET_ASET_SME_GUR;
	}

	public void setR15_RET_ASET_SME_GUR(String r15_RET_ASET_SME_GUR) {
		R15_RET_ASET_SME_GUR = r15_RET_ASET_SME_GUR;
	}

	public String getR15_RET_LOAN_DIS() {
		return R15_RET_LOAN_DIS;
	}

	public void setR15_RET_LOAN_DIS(String r15_RET_LOAN_DIS) {
		R15_RET_LOAN_DIS = r15_RET_LOAN_DIS;
	}

	public String getR15_RET_ASET_LOAN_SME() {
		return R15_RET_ASET_LOAN_SME;
	}

	public void setR15_RET_ASET_LOAN_SME(String r15_RET_ASET_LOAN_SME) {
		R15_RET_ASET_LOAN_SME = r15_RET_ASET_LOAN_SME;
	}

	public String getR15_PER_LOAN_WEB() {
		return R15_PER_LOAN_WEB;
	}

	public void setR15_PER_LOAN_WEB(String r15_PER_LOAN_WEB) {
		R15_PER_LOAN_WEB = r15_PER_LOAN_WEB;
	}

	public String getR15_LOAN_SME_WEB_MOB() {
		return R15_LOAN_SME_WEB_MOB;
	}

	public void setR15_LOAN_SME_WEB_MOB(String r15_LOAN_SME_WEB_MOB) {
		R15_LOAN_SME_WEB_MOB = r15_LOAN_SME_WEB_MOB;
	}

	public String getR15_NO_COMPDIGI_MOB() {
		return R15_NO_COMPDIGI_MOB;
	}

	public void setR15_NO_COMPDIGI_MOB(String r15_NO_COMPDIGI_MOB) {
		R15_NO_COMPDIGI_MOB = r15_NO_COMPDIGI_MOB;
	}

	public String getR15_NO_COMP_TRADCALL() {
		return R15_NO_COMP_TRADCALL;
	}

	public void setR15_NO_COMP_TRADCALL(String r15_NO_COMP_TRADCALL) {
		R15_NO_COMP_TRADCALL = r15_NO_COMP_TRADCALL;
	}

	public String getR15_PER_COMPDIGI_WEB() {
		return R15_PER_COMPDIGI_WEB;
	}

	public void setR15_PER_COMPDIGI_WEB(String r15_PER_COMPDIGI_WEB) {
		R15_PER_COMPDIGI_WEB = r15_PER_COMPDIGI_WEB;
	}

	public String getR15_PER_COM_TRADCALL() {
		return R15_PER_COM_TRADCALL;
	}

	public void setR15_PER_COM_TRADCALL(String r15_PER_COM_TRADCALL) {
		R15_PER_COM_TRADCALL = r15_PER_COM_TRADCALL;
	}

	public String getR15_TOT_REV_PREV() {
		return R15_TOT_REV_PREV;
	}

	public void setR15_TOT_REV_PREV(String r15_TOT_REV_PREV) {
		R15_TOT_REV_PREV = r15_TOT_REV_PREV;
	}

	public String getR15_PROF_LOSS_PREV() {
		return R15_PROF_LOSS_PREV;
	}

	public void setR15_PROF_LOSS_PREV(String r15_PROF_LOSS_PREV) {
		R15_PROF_LOSS_PREV = r15_PROF_LOSS_PREV;
	}

	public String getR15_PROF_MARG_PORTFOLIO() {
		return R15_PROF_MARG_PORTFOLIO;
	}

	public void setR15_PROF_MARG_PORTFOLIO(String r15_PROF_MARG_PORTFOLIO) {
		R15_PROF_MARG_PORTFOLIO = r15_PROF_MARG_PORTFOLIO;
	}

	public String getR15_TOT_RET_ASET_PREV() {
		return R15_TOT_RET_ASET_PREV;
	}

	public void setR15_TOT_RET_ASET_PREV(String r15_TOT_RET_ASET_PREV) {
		R15_TOT_RET_ASET_PREV = r15_TOT_RET_ASET_PREV;
	}

	public String getR15_NP_LOAN_PREV() {
		return R15_NP_LOAN_PREV;
	}

	public void setR15_NP_LOAN_PREV(String r15_NP_LOAN_PREV) {
		R15_NP_LOAN_PREV = r15_NP_LOAN_PREV;
	}

	public String getR15_NON_CON_ONLAST_PREV() {
		return R15_NON_CON_ONLAST_PREV;
	}

	public void setR15_NON_CON_ONLAST_PREV(String r15_NON_CON_ONLAST_PREV) {
		R15_NON_CON_ONLAST_PREV = r15_NON_CON_ONLAST_PREV;
	}

	public String getR15_TOT_BRAN_PREV() {
		return R15_TOT_BRAN_PREV;
	}

	public void setR15_TOT_BRAN_PREV(String r15_TOT_BRAN_PREV) {
		R15_TOT_BRAN_PREV = r15_TOT_BRAN_PREV;
	}

	public String getR15_TOT_REV_RET_CUR() {
		return R15_TOT_REV_RET_CUR;
	}

	public void setR15_TOT_REV_RET_CUR(String r15_TOT_REV_RET_CUR) {
		R15_TOT_REV_RET_CUR = r15_TOT_REV_RET_CUR;
	}

	public String getR15_PROF_LOS_PORT_CUR() {
		return R15_PROF_LOS_PORT_CUR;
	}

	public void setR15_PROF_LOS_PORT_CUR(String r15_PROF_LOS_PORT_CUR) {
		R15_PROF_LOS_PORT_CUR = r15_PROF_LOS_PORT_CUR;
	}

	public String getR15_PROF_MARG_PERC_CUR() {
		return R15_PROF_MARG_PERC_CUR;
	}

	public void setR15_PROF_MARG_PERC_CUR(String r15_PROF_MARG_PERC_CUR) {
		R15_PROF_MARG_PERC_CUR = r15_PROF_MARG_PERC_CUR;
	}

	public String getR15_TOT_RET_ASET_CUR() {
		return R15_TOT_RET_ASET_CUR;
	}

	public void setR15_TOT_RET_ASET_CUR(String r15_TOT_RET_ASET_CUR) {
		R15_TOT_RET_ASET_CUR = r15_TOT_RET_ASET_CUR;
	}

	public String getR15_NON_PER_RET_PORT_CUR() {
		return R15_NON_PER_RET_PORT_CUR;
	}

	public void setR15_NON_PER_RET_PORT_CUR(String r15_NON_PER_RET_PORT_CUR) {
		R15_NON_PER_RET_PORT_CUR = r15_NON_PER_RET_PORT_CUR;
	}

	public String getR15_NO_CON_LAST_CUR() {
		return R15_NO_CON_LAST_CUR;
	}

	public void setR15_NO_CON_LAST_CUR(String r15_NO_CON_LAST_CUR) {
		R15_NO_CON_LAST_CUR = r15_NO_CON_LAST_CUR;
	}

	public String getR15_TOT_BRANCH_CUR() {
		return R15_TOT_BRANCH_CUR;
	}

	public void setR15_TOT_BRANCH_CUR(String r15_TOT_BRANCH_CUR) {
		R15_TOT_BRANCH_CUR = r15_TOT_BRANCH_CUR;
	}

	public String getR15_TOT_REV_T1() {
		return R15_TOT_REV_T1;
	}

	public void setR15_TOT_REV_T1(String r15_TOT_REV_T1) {
		R15_TOT_REV_T1 = r15_TOT_REV_T1;
	}

	public String getR15_PROF_LOS_T1() {
		return R15_PROF_LOS_T1;
	}

	public void setR15_PROF_LOS_T1(String r15_PROF_LOS_T1) {
		R15_PROF_LOS_T1 = r15_PROF_LOS_T1;
	}

	public String getR15_PROF_MARG_T1() {
		return R15_PROF_MARG_T1;
	}

	public void setR15_PROF_MARG_T1(String r15_PROF_MARG_T1) {
		R15_PROF_MARG_T1 = r15_PROF_MARG_T1;
	}

	public String getR15_TOT_RET_ASET_T1() {
		return R15_TOT_RET_ASET_T1;
	}

	public void setR15_TOT_RET_ASET_T1(String r15_TOT_RET_ASET_T1) {
		R15_TOT_RET_ASET_T1 = r15_TOT_RET_ASET_T1;
	}

	public String getR15_NON_PERF_PORT_T1() {
		return R15_NON_PERF_PORT_T1;
	}

	public void setR15_NON_PERF_PORT_T1(String r15_NON_PERF_PORT_T1) {
		R15_NON_PERF_PORT_T1 = r15_NON_PERF_PORT_T1;
	}

	public String getR15_NO_CON_LAST_T1() {
		return R15_NO_CON_LAST_T1;
	}

	public void setR15_NO_CON_LAST_T1(String r15_NO_CON_LAST_T1) {
		R15_NO_CON_LAST_T1 = r15_NO_CON_LAST_T1;
	}

	public String getR15_TOT_BRANCH_T1() {
		return R15_TOT_BRANCH_T1;
	}

	public void setR15_TOT_BRANCH_T1(String r15_TOT_BRANCH_T1) {
		R15_TOT_BRANCH_T1 = r15_TOT_BRANCH_T1;
	}

	public String getR15_TOT_REV_T2() {
		return R15_TOT_REV_T2;
	}

	public void setR15_TOT_REV_T2(String r15_TOT_REV_T2) {
		R15_TOT_REV_T2 = r15_TOT_REV_T2;
	}

	public String getR15_PROF_LOS_T2() {
		return R15_PROF_LOS_T2;
	}

	public void setR15_PROF_LOS_T2(String r15_PROF_LOS_T2) {
		R15_PROF_LOS_T2 = r15_PROF_LOS_T2;
	}

	public String getR15_PROF_MARG_T2() {
		return R15_PROF_MARG_T2;
	}

	public void setR15_PROF_MARG_T2(String r15_PROF_MARG_T2) {
		R15_PROF_MARG_T2 = r15_PROF_MARG_T2;
	}

	public String getR15_TOT_RET_ASET_T2() {
		return R15_TOT_RET_ASET_T2;
	}

	public void setR15_TOT_RET_ASET_T2(String r15_TOT_RET_ASET_T2) {
		R15_TOT_RET_ASET_T2 = r15_TOT_RET_ASET_T2;
	}

	public String getR15_NON_PERF_PORT_T2() {
		return R15_NON_PERF_PORT_T2;
	}

	public void setR15_NON_PERF_PORT_T2(String r15_NON_PERF_PORT_T2) {
		R15_NON_PERF_PORT_T2 = r15_NON_PERF_PORT_T2;
	}

	public String getR15_NO_CON_LAST_T2() {
		return R15_NO_CON_LAST_T2;
	}

	public void setR15_NO_CON_LAST_T2(String r15_NO_CON_LAST_T2) {
		R15_NO_CON_LAST_T2 = r15_NO_CON_LAST_T2;
	}

	public String getR15_TOT_BRANCH_T2() {
		return R15_TOT_BRANCH_T2;
	}

	public void setR15_TOT_BRANCH_T2(String r15_TOT_BRANCH_T2) {
		R15_TOT_BRANCH_T2 = r15_TOT_BRANCH_T2;
	}

	public String getR15_TOT_REV_T3() {
		return R15_TOT_REV_T3;
	}

	public void setR15_TOT_REV_T3(String r15_TOT_REV_T3) {
		R15_TOT_REV_T3 = r15_TOT_REV_T3;
	}

	public String getR15_PROF_LOS_T3() {
		return R15_PROF_LOS_T3;
	}

	public void setR15_PROF_LOS_T3(String r15_PROF_LOS_T3) {
		R15_PROF_LOS_T3 = r15_PROF_LOS_T3;
	}

	public String getR15_PROF_MARG_T3() {
		return R15_PROF_MARG_T3;
	}

	public void setR15_PROF_MARG_T3(String r15_PROF_MARG_T3) {
		R15_PROF_MARG_T3 = r15_PROF_MARG_T3;
	}

	public String getR15_TOT_RET_ASET_T3() {
		return R15_TOT_RET_ASET_T3;
	}

	public void setR15_TOT_RET_ASET_T3(String r15_TOT_RET_ASET_T3) {
		R15_TOT_RET_ASET_T3 = r15_TOT_RET_ASET_T3;
	}

	public String getR15_NON_PERF_PORT_T3() {
		return R15_NON_PERF_PORT_T3;
	}

	public void setR15_NON_PERF_PORT_T3(String r15_NON_PERF_PORT_T3) {
		R15_NON_PERF_PORT_T3 = r15_NON_PERF_PORT_T3;
	}

	public String getR15_NO_CON_LAST_T3() {
		return R15_NO_CON_LAST_T3;
	}

	public void setR15_NO_CON_LAST_T3(String r15_NO_CON_LAST_T3) {
		R15_NO_CON_LAST_T3 = r15_NO_CON_LAST_T3;
	}

	public String getR15_TOT_BRANCH_T3() {
		return R15_TOT_BRANCH_T3;
	}

	public void setR15_TOT_BRANCH_T3(String r15_TOT_BRANCH_T3) {
		R15_TOT_BRANCH_T3 = r15_TOT_BRANCH_T3;
	}

	public String getR15_NPL_SPD() {
		return R15_NPL_SPD;
	}

	public void setR15_NPL_SPD(String r15_NPL_SPD) {
		R15_NPL_SPD = r15_NPL_SPD;
	}

	public String getR15_RECO_NPL_SPD() {
		return R15_RECO_NPL_SPD;
	}

	public void setR15_RECO_NPL_SPD(String r15_RECO_NPL_SPD) {
		R15_RECO_NPL_SPD = r15_RECO_NPL_SPD;
	}

	public String getR15_NO_CON_ONBO_DIGI() {
		return R15_NO_CON_ONBO_DIGI;
	}

	public void setR15_NO_CON_ONBO_DIGI(String r15_NO_CON_ONBO_DIGI) {
		R15_NO_CON_ONBO_DIGI = r15_NO_CON_ONBO_DIGI;
	}

	public String getR15_NO_ACCS_AML() {
		return R15_NO_ACCS_AML;
	}

	public void setR15_NO_ACCS_AML(String r15_NO_ACCS_AML) {
		R15_NO_ACCS_AML = r15_NO_ACCS_AML;
	}

	public String getR15_TOT_ACC_LOAN_AML() {
		return R15_TOT_ACC_LOAN_AML;
	}

	public void setR15_TOT_ACC_LOAN_AML(String r15_TOT_ACC_LOAN_AML) {
		R15_TOT_ACC_LOAN_AML = r15_TOT_ACC_LOAN_AML;
	}

	public String getR15_TOT_NEW_ACCS_SPD() {
		return R15_TOT_NEW_ACCS_SPD;
	}

	public void setR15_TOT_NEW_ACCS_SPD(String r15_TOT_NEW_ACCS_SPD) {
		R15_TOT_NEW_ACCS_SPD = r15_TOT_NEW_ACCS_SPD;
	}

	public String getR15_TOT_VALS_LOANS_SPD() {
		return R15_TOT_VALS_LOANS_SPD;
	}

	public void setR15_TOT_VALS_LOANS_SPD(String r15_TOT_VALS_LOANS_SPD) {
		R15_TOT_VALS_LOANS_SPD = r15_TOT_VALS_LOANS_SPD;
	}

	public String getR15_NO_INQ_WEBMOB() {
		return R15_NO_INQ_WEBMOB;
	}

	public void setR15_NO_INQ_WEBMOB(String r15_NO_INQ_WEBMOB) {
		R15_NO_INQ_WEBMOB = r15_NO_INQ_WEBMOB;
	}

	public String getR15_NO_INQ_TRAD() {
		return R15_NO_INQ_TRAD;
	}

	public void setR15_NO_INQ_TRAD(String r15_NO_INQ_TRAD) {
		R15_NO_INQ_TRAD = r15_NO_INQ_TRAD;
	}

	public String getR15_NO_RET_POS() {
		return R15_NO_RET_POS;
	}

	public void setR15_NO_RET_POS(String r15_NO_RET_POS) {
		R15_NO_RET_POS = r15_NO_RET_POS;
	}

	public String getR15_AMT_POS_GATE() {
		return R15_AMT_POS_GATE;
	}

	public void setR15_AMT_POS_GATE(String r15_AMT_POS_GATE) {
		R15_AMT_POS_GATE = r15_AMT_POS_GATE;
	}

	public String getR15_NO_TRAN_SVF_BNK() {
		return R15_NO_TRAN_SVF_BNK;
	}

	public void setR15_NO_TRAN_SVF_BNK(String r15_NO_TRAN_SVF_BNK) {
		R15_NO_TRAN_SVF_BNK = r15_NO_TRAN_SVF_BNK;
	}

	public String getR15_AMT_RET_SVF_BNK() {
		return R15_AMT_RET_SVF_BNK;
	}

	public void setR15_AMT_RET_SVF_BNK(String r15_AMT_RET_SVF_BNK) {
		R15_AMT_RET_SVF_BNK = r15_AMT_RET_SVF_BNK;
	}

	public String getR15_TOT_WEB_MOB_VIRT() {
		return R15_TOT_WEB_MOB_VIRT;
	}

	public void setR15_TOT_WEB_MOB_VIRT(String r15_TOT_WEB_MOB_VIRT) {
		R15_TOT_WEB_MOB_VIRT = r15_TOT_WEB_MOB_VIRT;
	}

	public String getR15_VAL_UNCL_SVF() {
		return R15_VAL_UNCL_SVF;
	}

	public void setR15_VAL_UNCL_SVF(String r15_VAL_UNCL_SVF) {
		R15_VAL_UNCL_SVF = r15_VAL_UNCL_SVF;
	}

	public String getR15_NO_CON_LOW_RSK() {
		return R15_NO_CON_LOW_RSK;
	}

	public void setR15_NO_CON_LOW_RSK(String r15_NO_CON_LOW_RSK) {
		R15_NO_CON_LOW_RSK = r15_NO_CON_LOW_RSK;
	}

	public String getR15_NO_CON_HIGH_RSK() {
		return R15_NO_CON_HIGH_RSK;
	}

	public void setR15_NO_CON_HIGH_RSK(String r15_NO_CON_HIGH_RSK) {
		R15_NO_CON_HIGH_RSK = r15_NO_CON_HIGH_RSK;
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
