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
@Table(name = "RT_MC_TABLE7_2")
public class RT_MC_TABLE7_2_ENTITY {

	public String R16_BANK;
	public String R16_PRODUCT;
	public String R16_RET_ASET_LTS;
	public String R16_RET_ASET_LTSME;
	public String R16_RET_ASET_SME_GUR;
	public String R16_RET_LOAN_DIS;
	public String R16_RET_ASET_LOAN_SME;
	public String R16_PER_LOAN_WEB;
	public String R16_LOAN_SME_WEB_MOB;
	public String R16_NO_COMPDIGI_MOB;
	public String R16_NO_COMP_TRADCALL;
	public String R16_PER_COMPDIGI_WEB;
	public String R16_PER_COM_TRADCALL;
	public String R16_TOT_REV_PREV;
	public String R16_PROF_LOSS_PREV;
	public String R16_PROF_MARG_PORTFOLIO;
	public String R16_TOT_RET_ASET_PREV;
	public String R16_NP_LOAN_PREV;
	public String R16_NON_CON_ONLAST_PREV;
	public String R16_TOT_BRAN_PREV;
	public String R16_TOT_REV_RET_CUR;
	public String R16_PROF_LOS_PORT_CUR;
	public String R16_PROF_MARG_PERC_CUR;
	public String R16_TOT_RET_ASET_CUR;
	public String R16_NON_PER_RET_PORT_CUR;
	public String R16_NO_CON_LAST_CUR;
	public String R16_TOT_BRANCH_CUR;
	public String R16_TOT_REV_T1;
	public String R16_PROF_LOS_T1;
	public String R16_PROF_MARG_T1;
	public String R16_TOT_RET_ASET_T1;
	public String R16_NON_PERF_PORT_T1;
	public String R16_NO_CON_LAST_T1;
	public String R16_TOT_BRANCH_T1;
	public String R16_TOT_REV_T2;
	public String R16_PROF_LOS_T2;
	public String R16_PROF_MARG_T2;
	public String R16_TOT_RET_ASET_T2;
	public String R16_NON_PERF_PORT_T2;
	public String R16_NO_CON_LAST_T2;
	public String R16_TOT_BRANCH_T2;
	public String R16_TOT_REV_T3;
	public String R16_PROF_LOS_T3;
	public String R16_PROF_MARG_T3;
	public String R16_TOT_RET_ASET_T3;
	public String R16_NON_PERF_PORT_T3;
	public String R16_NO_CON_LAST_T3;
	public String R16_TOT_BRANCH_T3;
	public String R16_NPL_SPD;
	public String R16_RECO_NPL_SPD;
	public String R16_NO_CON_ONBO_DIGI;
	public String R16_NO_ACCS_AML;
	public String R16_TOT_ACC_LOAN_AML;
	public String R16_TOT_NEW_ACCS_SPD;
	public String R16_TOT_VALS_LOANS_SPD;
	public String R16_NO_INQ_WEBMOB;
	public String R16_NO_INQ_TRAD;
	public String R16_NO_RET_POS;
	public String R16_AMT_POS_GATE;
	public String R16_NO_TRAN_SVF_BNK;
	public String R16_AMT_RET_SVF_BNK;
	public String R16_TOT_WEB_MOB_VIRT;
	public String R16_VAL_UNCL_SVF;
	public String R16_NO_CON_LOW_RSK;
	public String R16_NO_CON_HIGH_RSK;
	public String R17_BANK;
	public String R17_PRODUCT;
	public String R17_RET_ASET_LTS;
	public String R17_RET_ASET_LTSME;
	public String R17_RET_ASET_SME_GUR;
	public String R17_RET_LOAN_DIS;
	public String R17_RET_ASET_LOAN_SME;
	public String R17_PER_LOAN_WEB;
	public String R17_LOAN_SME_WEB_MOB;
	public String R17_NO_COMPDIGI_MOB;
	public String R17_NO_COMP_TRADCALL;
	public String R17_PER_COMPDIGI_WEB;
	public String R17_PER_COM_TRADCALL;
	public String R17_TOT_REV_PREV;
	public String R17_PROF_LOSS_PREV;
	public String R17_PROF_MARG_PORTFOLIO;
	public String R17_TOT_RET_ASET_PREV;
	public String R17_NP_LOAN_PREV;
	public String R17_NON_CON_ONLAST_PREV;
	public String R17_TOT_BRAN_PREV;
	public String R17_TOT_REV_RET_CUR;
	public String R17_PROF_LOS_PORT_CUR;
	public String R17_PROF_MARG_PERC_CUR;
	public String R17_TOT_RET_ASET_CUR;
	public String R17_NON_PER_RET_PORT_CUR;
	public String R17_NO_CON_LAST_CUR;
	public String R17_TOT_BRANCH_CUR;
	public String R17_TOT_REV_T1;
	public String R17_PROF_LOS_T1;
	public String R17_PROF_MARG_T1;
	public String R17_TOT_RET_ASET_T1;
	public String R17_NON_PERF_PORT_T1;
	public String R17_NO_CON_LAST_T1;
	public String R17_TOT_BRANCH_T1;
	public String R17_TOT_REV_T2;
	public String R17_PROF_LOS_T2;
	public String R17_PROF_MARG_T2;
	public String R17_TOT_RET_ASET_T2;
	public String R17_NON_PERF_PORT_T2;
	public String R17_NO_CON_LAST_T2;
	public String R17_TOT_BRANCH_T2;
	public String R17_TOT_REV_T3;
	public String R17_PROF_LOS_T3;
	public String R17_PROF_MARG_T3;
	public String R17_TOT_RET_ASET_T3;
	public String R17_NON_PERF_PORT_T3;
	public String R17_NO_CON_LAST_T3;
	public String R17_TOT_BRANCH_T3;
	public String R17_NPL_SPD;
	public String R17_RECO_NPL_SPD;
	public String R17_NO_CON_ONBO_DIGI;
	public String R17_NO_ACCS_AML;
	public String R17_TOT_ACC_LOAN_AML;
	public String R17_TOT_NEW_ACCS_SPD;
	public String R17_TOT_VALS_LOANS_SPD;
	public String R17_NO_INQ_WEBMOB;
	public String R17_NO_INQ_TRAD;
	public String R17_NO_RET_POS;
	public String R17_AMT_POS_GATE;
	public String R17_NO_TRAN_SVF_BNK;
	public String R17_AMT_RET_SVF_BNK;
	public String R17_TOT_WEB_MOB_VIRT;
	public String R17_VAL_UNCL_SVF;
	public String R17_NO_CON_LOW_RSK;
	public String R17_NO_CON_HIGH_RSK;
	public String R18_BANK;
	public String R18_PRODUCT;
	public String R18_RET_ASET_LTS;
	public String R18_RET_ASET_LTSME;
	public String R18_RET_ASET_SME_GUR;
	public String R18_RET_LOAN_DIS;
	public String R18_RET_ASET_LOAN_SME;
	public String R18_PER_LOAN_WEB;
	public String R18_LOAN_SME_WEB_MOB;
	public String R18_NO_COMPDIGI_MOB;
	public String R18_NO_COMP_TRADCALL;
	public String R18_PER_COMPDIGI_WEB;
	public String R18_PER_COM_TRADCALL;
	public String R18_TOT_REV_PREV;
	public String R18_PROF_LOSS_PREV;
	public String R18_PROF_MARG_PORTFOLIO;
	public String R18_TOT_RET_ASET_PREV;
	public String R18_NP_LOAN_PREV;
	public String R18_NON_CON_ONLAST_PREV;
	public String R18_TOT_BRAN_PREV;
	public String R18_TOT_REV_RET_CUR;
	public String R18_PROF_LOS_PORT_CUR;
	public String R18_PROF_MARG_PERC_CUR;
	public String R18_TOT_RET_ASET_CUR;
	public String R18_NON_PER_RET_PORT_CUR;
	public String R18_NO_CON_LAST_CUR;
	public String R18_TOT_BRANCH_CUR;
	public String R18_TOT_REV_T1;
	public String R18_PROF_LOS_T1;
	public String R18_PROF_MARG_T1;
	public String R18_TOT_RET_ASET_T1;
	public String R18_NON_PERF_PORT_T1;
	public String R18_NO_CON_LAST_T1;
	public String R18_TOT_BRANCH_T1;
	public String R18_TOT_REV_T2;
	public String R18_PROF_LOS_T2;
	public String R18_PROF_MARG_T2;
	public String R18_TOT_RET_ASET_T2;
	public String R18_NON_PERF_PORT_T2;
	public String R18_NO_CON_LAST_T2;
	public String R18_TOT_BRANCH_T2;
	public String R18_TOT_REV_T3;
	public String R18_PROF_LOS_T3;
	public String R18_PROF_MARG_T3;
	public String R18_TOT_RET_ASET_T3;
	public String R18_NON_PERF_PORT_T3;
	public String R18_NO_CON_LAST_T3;
	public String R18_TOT_BRANCH_T3;
	public String R18_NPL_SPD;
	public String R18_RECO_NPL_SPD;
	public String R18_NO_CON_ONBO_DIGI;
	public String R18_NO_ACCS_AML;
	public String R18_TOT_ACC_LOAN_AML;
	public String R18_TOT_NEW_ACCS_SPD;
	public String R18_TOT_VALS_LOANS_SPD;
	public String R18_NO_INQ_WEBMOB;
	public String R18_NO_INQ_TRAD;
	public String R18_NO_RET_POS;
	public String R18_AMT_POS_GATE;
	public String R18_NO_TRAN_SVF_BNK;
	public String R18_AMT_RET_SVF_BNK;
	public String R18_TOT_WEB_MOB_VIRT;
	public String R18_VAL_UNCL_SVF;
	public String R18_NO_CON_LOW_RSK;
	public String R18_NO_CON_HIGH_RSK;
	public String R19_BANK;
	public String R19_PRODUCT;
	public String R19_RET_ASET_LTS;
	public String R19_RET_ASET_LTSME;
	public String R19_RET_ASET_SME_GUR;
	public String R19_RET_LOAN_DIS;
	public String R19_RET_ASET_LOAN_SME;
	public String R19_PER_LOAN_WEB;
	public String R19_LOAN_SME_WEB_MOB;
	public String R19_NO_COMPDIGI_MOB;
	public String R19_NO_COMP_TRADCALL;
	public String R19_PER_COMPDIGI_WEB;
	public String R19_PER_COM_TRADCALL;
	public String R19_TOT_REV_PREV;
	public String R19_PROF_LOSS_PREV;
	public String R19_PROF_MARG_PORTFOLIO;
	public String R19_TOT_RET_ASET_PREV;
	public String R19_NP_LOAN_PREV;
	public String R19_NON_CON_ONLAST_PREV;
	public String R19_TOT_BRAN_PREV;
	public String R19_TOT_REV_RET_CUR;
	public String R19_PROF_LOS_PORT_CUR;
	public String R19_PROF_MARG_PERC_CUR;
	public String R19_TOT_RET_ASET_CUR;
	public String R19_NON_PER_RET_PORT_CUR;
	public String R19_NO_CON_LAST_CUR;
	public String R19_TOT_BRANCH_CUR;
	public String R19_TOT_REV_T1;
	public String R19_PROF_LOS_T1;
	public String R19_PROF_MARG_T1;
	public String R19_TOT_RET_ASET_T1;
	public String R19_NON_PERF_PORT_T1;
	public String R19_NO_CON_LAST_T1;
	public String R19_TOT_BRANCH_T1;
	public String R19_TOT_REV_T2;
	public String R19_PROF_LOS_T2;
	public String R19_PROF_MARG_T2;
	public String R19_TOT_RET_ASET_T2;
	public String R19_NON_PERF_PORT_T2;
	public String R19_NO_CON_LAST_T2;
	public String R19_TOT_BRANCH_T2;
	public String R19_TOT_REV_T3;
	public String R19_PROF_LOS_T3;
	public String R19_PROF_MARG_T3;
	public String R19_TOT_RET_ASET_T3;
	public String R19_NON_PERF_PORT_T3;
	public String R19_NO_CON_LAST_T3;
	public String R19_TOT_BRANCH_T3;
	public String R19_NPL_SPD;
	public String R19_RECO_NPL_SPD;
	public String R19_NO_CON_ONBO_DIGI;
	public String R19_NO_ACCS_AML;
	public String R19_TOT_ACC_LOAN_AML;
	public String R19_TOT_NEW_ACCS_SPD;
	public String R19_TOT_VALS_LOANS_SPD;
	public String R19_NO_INQ_WEBMOB;
	public String R19_NO_INQ_TRAD;
	public String R19_NO_RET_POS;
	public String R19_AMT_POS_GATE;
	public String R19_NO_TRAN_SVF_BNK;
	public String R19_AMT_RET_SVF_BNK;
	public String R19_TOT_WEB_MOB_VIRT;
	public String R19_VAL_UNCL_SVF;
	public String R19_NO_CON_LOW_RSK;
	public String R19_NO_CON_HIGH_RSK;
	public String R20_BANK;
	public String R20_PRODUCT;
	public String R20_RET_ASET_LTS;
	public String R20_RET_ASET_LTSME;
	public String R20_RET_ASET_SME_GUR;
	public String R20_RET_LOAN_DIS;
	public String R20_RET_ASET_LOAN_SME;
	public String R20_PER_LOAN_WEB;
	public String R20_LOAN_SME_WEB_MOB;
	public String R20_NO_COMPDIGI_MOB;
	public String R20_NO_COMP_TRADCALL;
	public String R20_PER_COMPDIGI_WEB;
	public String R20_PER_COM_TRADCALL;
	public String R20_TOT_REV_PREV;
	public String R20_PROF_LOSS_PREV;
	public String R20_PROF_MARG_PORTFOLIO;
	public String R20_TOT_RET_ASET_PREV;
	public String R20_NP_LOAN_PREV;
	public String R20_NON_CON_ONLAST_PREV;
	public String R20_TOT_BRAN_PREV;
	public String R20_TOT_REV_RET_CUR;
	public String R20_PROF_LOS_PORT_CUR;
	public String R20_PROF_MARG_PERC_CUR;
	public String R20_TOT_RET_ASET_CUR;
	public String R20_NON_PER_RET_PORT_CUR;
	public String R20_NO_CON_LAST_CUR;
	public String R20_TOT_BRANCH_CUR;
	public String R20_TOT_REV_T1;
	public String R20_PROF_LOS_T1;
	public String R20_PROF_MARG_T1;
	public String R20_TOT_RET_ASET_T1;
	public String R20_NON_PERF_PORT_T1;
	public String R20_NO_CON_LAST_T1;
	public String R20_TOT_BRANCH_T1;
	public String R20_TOT_REV_T2;
	public String R20_PROF_LOS_T2;
	public String R20_PROF_MARG_T2;
	public String R20_TOT_RET_ASET_T2;
	public String R20_NON_PERF_PORT_T2;
	public String R20_NO_CON_LAST_T2;
	public String R20_TOT_BRANCH_T2;
	public String R20_TOT_REV_T3;
	public String R20_PROF_LOS_T3;
	public String R20_PROF_MARG_T3;
	public String R20_TOT_RET_ASET_T3;
	public String R20_NON_PERF_PORT_T3;
	public String R20_NO_CON_LAST_T3;
	public String R20_TOT_BRANCH_T3;
	public String R20_NPL_SPD;
	public String R20_RECO_NPL_SPD;
	public String R20_NO_CON_ONBO_DIGI;
	public String R20_NO_ACCS_AML;
	public String R20_TOT_ACC_LOAN_AML;
	public String R20_TOT_NEW_ACCS_SPD;
	public String R20_TOT_VALS_LOANS_SPD;
	public String R20_NO_INQ_WEBMOB;
	public String R20_NO_INQ_TRAD;
	public String R20_NO_RET_POS;
	public String R20_AMT_POS_GATE;
	public String R20_NO_TRAN_SVF_BNK;
	public String R20_AMT_RET_SVF_BNK;
	public String R20_TOT_WEB_MOB_VIRT;
	public String R20_VAL_UNCL_SVF;
	public String R20_NO_CON_LOW_RSK;
	public String R20_NO_CON_HIGH_RSK;
	public String R21_BANK;
	public String R21_PRODUCT;
	public String R21_RET_ASET_LTS;
	public String R21_RET_ASET_LTSME;
	public String R21_RET_ASET_SME_GUR;
	public String R21_RET_LOAN_DIS;
	public String R21_RET_ASET_LOAN_SME;
	public String R21_PER_LOAN_WEB;
	public String R21_LOAN_SME_WEB_MOB;
	public String R21_NO_COMPDIGI_MOB;
	public String R21_NO_COMP_TRADCALL;
	public String R21_PER_COMPDIGI_WEB;
	public String R21_PER_COM_TRADCALL;
	public String R21_TOT_REV_PREV;
	public String R21_PROF_LOSS_PREV;
	public String R21_PROF_MARG_PORTFOLIO;
	public String R21_TOT_RET_ASET_PREV;
	public String R21_NP_LOAN_PREV;
	public String R21_NON_CON_ONLAST_PREV;
	public String R21_TOT_BRAN_PREV;
	public String R21_TOT_REV_RET_CUR;
	public String R21_PROF_LOS_PORT_CUR;
	public String R21_PROF_MARG_PERC_CUR;
	public String R21_TOT_RET_ASET_CUR;
	public String R21_NON_PER_RET_PORT_CUR;
	public String R21_NO_CON_LAST_CUR;
	public String R21_TOT_BRANCH_CUR;
	public String R21_TOT_REV_T1;
	public String R21_PROF_LOS_T1;
	public String R21_PROF_MARG_T1;
	public String R21_TOT_RET_ASET_T1;
	public String R21_NON_PERF_PORT_T1;
	public String R21_NO_CON_LAST_T1;
	public String R21_TOT_BRANCH_T1;
	public String R21_TOT_REV_T2;
	public String R21_PROF_LOS_T2;
	public String R21_PROF_MARG_T2;
	public String R21_TOT_RET_ASET_T2;
	public String R21_NON_PERF_PORT_T2;
	public String R21_NO_CON_LAST_T2;
	public String R21_TOT_BRANCH_T2;
	public String R21_TOT_REV_T3;
	public String R21_PROF_LOS_T3;
	public String R21_PROF_MARG_T3;
	public String R21_TOT_RET_ASET_T3;
	public String R21_NON_PERF_PORT_T3;
	public String R21_NO_CON_LAST_T3;
	public String R21_TOT_BRANCH_T3;
	public String R21_NPL_SPD;
	public String R21_RECO_NPL_SPD;
	public String R21_NO_CON_ONBO_DIGI;
	public String R21_NO_ACCS_AML;
	public String R21_TOT_ACC_LOAN_AML;
	public String R21_TOT_NEW_ACCS_SPD;
	public String R21_TOT_VALS_LOANS_SPD;
	public String R21_NO_INQ_WEBMOB;
	public String R21_NO_INQ_TRAD;
	public String R21_NO_RET_POS;
	public String R21_AMT_POS_GATE;
	public String R21_NO_TRAN_SVF_BNK;
	public String R21_AMT_RET_SVF_BNK;
	public String R21_TOT_WEB_MOB_VIRT;
	public String R21_VAL_UNCL_SVF;
	public String R21_NO_CON_LOW_RSK;
	public String R21_NO_CON_HIGH_RSK;
	public String R22_BANK;
	public String R22_PRODUCT;
	public String R22_RET_ASET_LTS;
	public String R22_RET_ASET_LTSME;
	public String R22_RET_ASET_SME_GUR;
	public String R22_RET_LOAN_DIS;
	public String R22_RET_ASET_LOAN_SME;
	public String R22_PER_LOAN_WEB;
	public String R22_LOAN_SME_WEB_MOB;
	public String R22_NO_COMPDIGI_MOB;
	public String R22_NO_COMP_TRADCALL;
	public String R22_PER_COMPDIGI_WEB;
	public String R22_PER_COM_TRADCALL;
	public String R22_TOT_REV_PREV;
	public String R22_PROF_LOSS_PREV;
	public String R22_PROF_MARG_PORTFOLIO;
	public String R22_TOT_RET_ASET_PREV;
	public String R22_NP_LOAN_PREV;
	public String R22_NON_CON_ONLAST_PREV;
	public String R22_TOT_BRAN_PREV;
	public String R22_TOT_REV_RET_CUR;
	public String R22_PROF_LOS_PORT_CUR;
	public String R22_PROF_MARG_PERC_CUR;
	public String R22_TOT_RET_ASET_CUR;
	public String R22_NON_PER_RET_PORT_CUR;
	public String R22_NO_CON_LAST_CUR;
	public String R22_TOT_BRANCH_CUR;
	public String R22_TOT_REV_T1;
	public String R22_PROF_LOS_T1;
	public String R22_PROF_MARG_T1;
	public String R22_TOT_RET_ASET_T1;
	public String R22_NON_PERF_PORT_T1;
	public String R22_NO_CON_LAST_T1;
	public String R22_TOT_BRANCH_T1;
	public String R22_TOT_REV_T2;
	public String R22_PROF_LOS_T2;
	public String R22_PROF_MARG_T2;
	public String R22_TOT_RET_ASET_T2;
	public String R22_NON_PERF_PORT_T2;
	public String R22_NO_CON_LAST_T2;
	public String R22_TOT_BRANCH_T2;
	public String R22_TOT_REV_T3;
	public String R22_PROF_LOS_T3;
	public String R22_PROF_MARG_T3;
	public String R22_TOT_RET_ASET_T3;
	public String R22_NON_PERF_PORT_T3;
	public String R22_NO_CON_LAST_T3;
	public String R22_TOT_BRANCH_T3;
	public String R22_NPL_SPD;
	public String R22_RECO_NPL_SPD;
	public String R22_NO_CON_ONBO_DIGI;
	public String R22_NO_ACCS_AML;
	public String R22_TOT_ACC_LOAN_AML;
	public String R22_TOT_NEW_ACCS_SPD;
	public String R22_TOT_VALS_LOANS_SPD;
	public String R22_NO_INQ_WEBMOB;
	public String R22_NO_INQ_TRAD;
	public String R22_NO_RET_POS;
	public String R22_AMT_POS_GATE;
	public String R22_NO_TRAN_SVF_BNK;
	public String R22_AMT_RET_SVF_BNK;
	public String R22_TOT_WEB_MOB_VIRT;
	public String R22_VAL_UNCL_SVF;
	public String R22_NO_CON_LOW_RSK;
	public String R22_NO_CON_HIGH_RSK;
	public String R23_BANK;
	public String R23_PRODUCT;
	public String R23_RET_ASET_LTS;
	public String R23_RET_ASET_LTSME;
	public String R23_RET_ASET_SME_GUR;
	public String R23_RET_LOAN_DIS;
	public String R23_RET_ASET_LOAN_SME;
	public String R23_PER_LOAN_WEB;
	public String R23_LOAN_SME_WEB_MOB;
	public String R23_NO_COMPDIGI_MOB;
	public String R23_NO_COMP_TRADCALL;
	public String R23_PER_COMPDIGI_WEB;
	public String R23_PER_COM_TRADCALL;
	public String R23_TOT_REV_PREV;
	public String R23_PROF_LOSS_PREV;
	public String R23_PROF_MARG_PORTFOLIO;
	public String R23_TOT_RET_ASET_PREV;
	public String R23_NP_LOAN_PREV;
	public String R23_NON_CON_ONLAST_PREV;
	public String R23_TOT_BRAN_PREV;
	public String R23_TOT_REV_RET_CUR;
	public String R23_PROF_LOS_PORT_CUR;
	public String R23_PROF_MARG_PERC_CUR;
	public String R23_TOT_RET_ASET_CUR;
	public String R23_NON_PER_RET_PORT_CUR;
	public String R23_NO_CON_LAST_CUR;
	public String R23_TOT_BRANCH_CUR;
	public String R23_TOT_REV_T1;
	public String R23_PROF_LOS_T1;
	public String R23_PROF_MARG_T1;
	public String R23_TOT_RET_ASET_T1;
	public String R23_NON_PERF_PORT_T1;
	public String R23_NO_CON_LAST_T1;
	public String R23_TOT_BRANCH_T1;
	public String R23_TOT_REV_T2;
	public String R23_PROF_LOS_T2;
	public String R23_PROF_MARG_T2;
	public String R23_TOT_RET_ASET_T2;
	public String R23_NON_PERF_PORT_T2;
	public String R23_NO_CON_LAST_T2;
	public String R23_TOT_BRANCH_T2;
	public String R23_TOT_REV_T3;
	public String R23_PROF_LOS_T3;
	public String R23_PROF_MARG_T3;
	public String R23_TOT_RET_ASET_T3;
	public String R23_NON_PERF_PORT_T3;
	public String R23_NO_CON_LAST_T3;
	public String R23_TOT_BRANCH_T3;
	public String R23_NPL_SPD;
	public String R23_RECO_NPL_SPD;
	public String R23_NO_CON_ONBO_DIGI;
	public String R23_NO_ACCS_AML;
	public String R23_TOT_ACC_LOAN_AML;
	public String R23_TOT_NEW_ACCS_SPD;
	public String R23_TOT_VALS_LOANS_SPD;
	public String R23_NO_INQ_WEBMOB;
	public String R23_NO_INQ_TRAD;
	public String R23_NO_RET_POS;
	public String R23_AMT_POS_GATE;
	public String R23_NO_TRAN_SVF_BNK;
	public String R23_AMT_RET_SVF_BNK;
	public String R23_TOT_WEB_MOB_VIRT;
	public String R23_VAL_UNCL_SVF;
	public String R23_NO_CON_LOW_RSK;
	public String R23_NO_CON_HIGH_RSK;
	public String R24_BANK;
	public String R24_PRODUCT;
	public String R24_RET_ASET_LTS;
	public String R24_RET_ASET_LTSME;
	public String R24_RET_ASET_SME_GUR;
	public String R24_RET_LOAN_DIS;
	public String R24_RET_ASET_LOAN_SME;
	public String R24_PER_LOAN_WEB;
	public String R24_LOAN_SME_WEB_MOB;
	public String R24_NO_COMPDIGI_MOB;
	public String R24_NO_COMP_TRADCALL;
	public String R24_PER_COMPDIGI_WEB;
	public String R24_PER_COM_TRADCALL;
	public String R24_TOT_REV_PREV;
	public String R24_PROF_LOSS_PREV;
	public String R24_PROF_MARG_PORTFOLIO;
	public String R24_TOT_RET_ASET_PREV;
	public String R24_NP_LOAN_PREV;
	public String R24_NON_CON_ONLAST_PREV;
	public String R24_TOT_BRAN_PREV;
	public String R24_TOT_REV_RET_CUR;
	public String R24_PROF_LOS_PORT_CUR;
	public String R24_PROF_MARG_PERC_CUR;
	public String R24_TOT_RET_ASET_CUR;
	public String R24_NON_PER_RET_PORT_CUR;
	public String R24_NO_CON_LAST_CUR;
	public String R24_TOT_BRANCH_CUR;
	public String R24_TOT_REV_T1;
	public String R24_PROF_LOS_T1;
	public String R24_PROF_MARG_T1;
	public String R24_TOT_RET_ASET_T1;
	public String R24_NON_PERF_PORT_T1;
	public String R24_NO_CON_LAST_T1;
	public String R24_TOT_BRANCH_T1;
	public String R24_TOT_REV_T2;
	public String R24_PROF_LOS_T2;
	public String R24_PROF_MARG_T2;
	public String R24_TOT_RET_ASET_T2;
	public String R24_NON_PERF_PORT_T2;
	public String R24_NO_CON_LAST_T2;
	public String R24_TOT_BRANCH_T2;
	public String R24_TOT_REV_T3;
	public String R24_PROF_LOS_T3;
	public String R24_PROF_MARG_T3;
	public String R24_TOT_RET_ASET_T3;
	public String R24_NON_PERF_PORT_T3;
	public String R24_NO_CON_LAST_T3;
	public String R24_TOT_BRANCH_T3;
	public String R24_NPL_SPD;
	public String R24_RECO_NPL_SPD;
	public String R24_NO_CON_ONBO_DIGI;
	public String R24_NO_ACCS_AML;
	public String R24_TOT_ACC_LOAN_AML;
	public String R24_TOT_NEW_ACCS_SPD;
	public String R24_TOT_VALS_LOANS_SPD;
	public String R24_NO_INQ_WEBMOB;
	public String R24_NO_INQ_TRAD;
	public String R24_NO_RET_POS;
	public String R24_AMT_POS_GATE;
	public String R24_NO_TRAN_SVF_BNK;
	public String R24_AMT_RET_SVF_BNK;
	public String R24_TOT_WEB_MOB_VIRT;
	public String R24_VAL_UNCL_SVF;
	public String R24_NO_CON_LOW_RSK;
	public String R24_NO_CON_HIGH_RSK;
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

	public String getR16_RET_ASET_LTS() {
		return R16_RET_ASET_LTS;
	}

	public void setR16_RET_ASET_LTS(String r16_RET_ASET_LTS) {
		R16_RET_ASET_LTS = r16_RET_ASET_LTS;
	}

	public String getR16_RET_ASET_LTSME() {
		return R16_RET_ASET_LTSME;
	}

	public void setR16_RET_ASET_LTSME(String r16_RET_ASET_LTSME) {
		R16_RET_ASET_LTSME = r16_RET_ASET_LTSME;
	}

	public String getR16_RET_ASET_SME_GUR() {
		return R16_RET_ASET_SME_GUR;
	}

	public void setR16_RET_ASET_SME_GUR(String r16_RET_ASET_SME_GUR) {
		R16_RET_ASET_SME_GUR = r16_RET_ASET_SME_GUR;
	}

	public String getR16_RET_LOAN_DIS() {
		return R16_RET_LOAN_DIS;
	}

	public void setR16_RET_LOAN_DIS(String r16_RET_LOAN_DIS) {
		R16_RET_LOAN_DIS = r16_RET_LOAN_DIS;
	}

	public String getR16_RET_ASET_LOAN_SME() {
		return R16_RET_ASET_LOAN_SME;
	}

	public void setR16_RET_ASET_LOAN_SME(String r16_RET_ASET_LOAN_SME) {
		R16_RET_ASET_LOAN_SME = r16_RET_ASET_LOAN_SME;
	}

	public String getR16_PER_LOAN_WEB() {
		return R16_PER_LOAN_WEB;
	}

	public void setR16_PER_LOAN_WEB(String r16_PER_LOAN_WEB) {
		R16_PER_LOAN_WEB = r16_PER_LOAN_WEB;
	}

	public String getR16_LOAN_SME_WEB_MOB() {
		return R16_LOAN_SME_WEB_MOB;
	}

	public void setR16_LOAN_SME_WEB_MOB(String r16_LOAN_SME_WEB_MOB) {
		R16_LOAN_SME_WEB_MOB = r16_LOAN_SME_WEB_MOB;
	}

	public String getR16_NO_COMPDIGI_MOB() {
		return R16_NO_COMPDIGI_MOB;
	}

	public void setR16_NO_COMPDIGI_MOB(String r16_NO_COMPDIGI_MOB) {
		R16_NO_COMPDIGI_MOB = r16_NO_COMPDIGI_MOB;
	}

	public String getR16_NO_COMP_TRADCALL() {
		return R16_NO_COMP_TRADCALL;
	}

	public void setR16_NO_COMP_TRADCALL(String r16_NO_COMP_TRADCALL) {
		R16_NO_COMP_TRADCALL = r16_NO_COMP_TRADCALL;
	}

	public String getR16_PER_COMPDIGI_WEB() {
		return R16_PER_COMPDIGI_WEB;
	}

	public void setR16_PER_COMPDIGI_WEB(String r16_PER_COMPDIGI_WEB) {
		R16_PER_COMPDIGI_WEB = r16_PER_COMPDIGI_WEB;
	}

	public String getR16_PER_COM_TRADCALL() {
		return R16_PER_COM_TRADCALL;
	}

	public void setR16_PER_COM_TRADCALL(String r16_PER_COM_TRADCALL) {
		R16_PER_COM_TRADCALL = r16_PER_COM_TRADCALL;
	}

	public String getR16_TOT_REV_PREV() {
		return R16_TOT_REV_PREV;
	}

	public void setR16_TOT_REV_PREV(String r16_TOT_REV_PREV) {
		R16_TOT_REV_PREV = r16_TOT_REV_PREV;
	}

	public String getR16_PROF_LOSS_PREV() {
		return R16_PROF_LOSS_PREV;
	}

	public void setR16_PROF_LOSS_PREV(String r16_PROF_LOSS_PREV) {
		R16_PROF_LOSS_PREV = r16_PROF_LOSS_PREV;
	}

	public String getR16_PROF_MARG_PORTFOLIO() {
		return R16_PROF_MARG_PORTFOLIO;
	}

	public void setR16_PROF_MARG_PORTFOLIO(String r16_PROF_MARG_PORTFOLIO) {
		R16_PROF_MARG_PORTFOLIO = r16_PROF_MARG_PORTFOLIO;
	}

	public String getR16_TOT_RET_ASET_PREV() {
		return R16_TOT_RET_ASET_PREV;
	}

	public void setR16_TOT_RET_ASET_PREV(String r16_TOT_RET_ASET_PREV) {
		R16_TOT_RET_ASET_PREV = r16_TOT_RET_ASET_PREV;
	}

	public String getR16_NP_LOAN_PREV() {
		return R16_NP_LOAN_PREV;
	}

	public void setR16_NP_LOAN_PREV(String r16_NP_LOAN_PREV) {
		R16_NP_LOAN_PREV = r16_NP_LOAN_PREV;
	}

	public String getR16_NON_CON_ONLAST_PREV() {
		return R16_NON_CON_ONLAST_PREV;
	}

	public void setR16_NON_CON_ONLAST_PREV(String r16_NON_CON_ONLAST_PREV) {
		R16_NON_CON_ONLAST_PREV = r16_NON_CON_ONLAST_PREV;
	}

	public String getR16_TOT_BRAN_PREV() {
		return R16_TOT_BRAN_PREV;
	}

	public void setR16_TOT_BRAN_PREV(String r16_TOT_BRAN_PREV) {
		R16_TOT_BRAN_PREV = r16_TOT_BRAN_PREV;
	}

	public String getR16_TOT_REV_RET_CUR() {
		return R16_TOT_REV_RET_CUR;
	}

	public void setR16_TOT_REV_RET_CUR(String r16_TOT_REV_RET_CUR) {
		R16_TOT_REV_RET_CUR = r16_TOT_REV_RET_CUR;
	}

	public String getR16_PROF_LOS_PORT_CUR() {
		return R16_PROF_LOS_PORT_CUR;
	}

	public void setR16_PROF_LOS_PORT_CUR(String r16_PROF_LOS_PORT_CUR) {
		R16_PROF_LOS_PORT_CUR = r16_PROF_LOS_PORT_CUR;
	}

	public String getR16_PROF_MARG_PERC_CUR() {
		return R16_PROF_MARG_PERC_CUR;
	}

	public void setR16_PROF_MARG_PERC_CUR(String r16_PROF_MARG_PERC_CUR) {
		R16_PROF_MARG_PERC_CUR = r16_PROF_MARG_PERC_CUR;
	}

	public String getR16_TOT_RET_ASET_CUR() {
		return R16_TOT_RET_ASET_CUR;
	}

	public void setR16_TOT_RET_ASET_CUR(String r16_TOT_RET_ASET_CUR) {
		R16_TOT_RET_ASET_CUR = r16_TOT_RET_ASET_CUR;
	}

	public String getR16_NON_PER_RET_PORT_CUR() {
		return R16_NON_PER_RET_PORT_CUR;
	}

	public void setR16_NON_PER_RET_PORT_CUR(String r16_NON_PER_RET_PORT_CUR) {
		R16_NON_PER_RET_PORT_CUR = r16_NON_PER_RET_PORT_CUR;
	}

	public String getR16_NO_CON_LAST_CUR() {
		return R16_NO_CON_LAST_CUR;
	}

	public void setR16_NO_CON_LAST_CUR(String r16_NO_CON_LAST_CUR) {
		R16_NO_CON_LAST_CUR = r16_NO_CON_LAST_CUR;
	}

	public String getR16_TOT_BRANCH_CUR() {
		return R16_TOT_BRANCH_CUR;
	}

	public void setR16_TOT_BRANCH_CUR(String r16_TOT_BRANCH_CUR) {
		R16_TOT_BRANCH_CUR = r16_TOT_BRANCH_CUR;
	}

	public String getR16_TOT_REV_T1() {
		return R16_TOT_REV_T1;
	}

	public void setR16_TOT_REV_T1(String r16_TOT_REV_T1) {
		R16_TOT_REV_T1 = r16_TOT_REV_T1;
	}

	public String getR16_PROF_LOS_T1() {
		return R16_PROF_LOS_T1;
	}

	public void setR16_PROF_LOS_T1(String r16_PROF_LOS_T1) {
		R16_PROF_LOS_T1 = r16_PROF_LOS_T1;
	}

	public String getR16_PROF_MARG_T1() {
		return R16_PROF_MARG_T1;
	}

	public void setR16_PROF_MARG_T1(String r16_PROF_MARG_T1) {
		R16_PROF_MARG_T1 = r16_PROF_MARG_T1;
	}

	public String getR16_TOT_RET_ASET_T1() {
		return R16_TOT_RET_ASET_T1;
	}

	public void setR16_TOT_RET_ASET_T1(String r16_TOT_RET_ASET_T1) {
		R16_TOT_RET_ASET_T1 = r16_TOT_RET_ASET_T1;
	}

	public String getR16_NON_PERF_PORT_T1() {
		return R16_NON_PERF_PORT_T1;
	}

	public void setR16_NON_PERF_PORT_T1(String r16_NON_PERF_PORT_T1) {
		R16_NON_PERF_PORT_T1 = r16_NON_PERF_PORT_T1;
	}

	public String getR16_NO_CON_LAST_T1() {
		return R16_NO_CON_LAST_T1;
	}

	public void setR16_NO_CON_LAST_T1(String r16_NO_CON_LAST_T1) {
		R16_NO_CON_LAST_T1 = r16_NO_CON_LAST_T1;
	}

	public String getR16_TOT_BRANCH_T1() {
		return R16_TOT_BRANCH_T1;
	}

	public void setR16_TOT_BRANCH_T1(String r16_TOT_BRANCH_T1) {
		R16_TOT_BRANCH_T1 = r16_TOT_BRANCH_T1;
	}

	public String getR16_TOT_REV_T2() {
		return R16_TOT_REV_T2;
	}

	public void setR16_TOT_REV_T2(String r16_TOT_REV_T2) {
		R16_TOT_REV_T2 = r16_TOT_REV_T2;
	}

	public String getR16_PROF_LOS_T2() {
		return R16_PROF_LOS_T2;
	}

	public void setR16_PROF_LOS_T2(String r16_PROF_LOS_T2) {
		R16_PROF_LOS_T2 = r16_PROF_LOS_T2;
	}

	public String getR16_PROF_MARG_T2() {
		return R16_PROF_MARG_T2;
	}

	public void setR16_PROF_MARG_T2(String r16_PROF_MARG_T2) {
		R16_PROF_MARG_T2 = r16_PROF_MARG_T2;
	}

	public String getR16_TOT_RET_ASET_T2() {
		return R16_TOT_RET_ASET_T2;
	}

	public void setR16_TOT_RET_ASET_T2(String r16_TOT_RET_ASET_T2) {
		R16_TOT_RET_ASET_T2 = r16_TOT_RET_ASET_T2;
	}

	public String getR16_NON_PERF_PORT_T2() {
		return R16_NON_PERF_PORT_T2;
	}

	public void setR16_NON_PERF_PORT_T2(String r16_NON_PERF_PORT_T2) {
		R16_NON_PERF_PORT_T2 = r16_NON_PERF_PORT_T2;
	}

	public String getR16_NO_CON_LAST_T2() {
		return R16_NO_CON_LAST_T2;
	}

	public void setR16_NO_CON_LAST_T2(String r16_NO_CON_LAST_T2) {
		R16_NO_CON_LAST_T2 = r16_NO_CON_LAST_T2;
	}

	public String getR16_TOT_BRANCH_T2() {
		return R16_TOT_BRANCH_T2;
	}

	public void setR16_TOT_BRANCH_T2(String r16_TOT_BRANCH_T2) {
		R16_TOT_BRANCH_T2 = r16_TOT_BRANCH_T2;
	}

	public String getR16_TOT_REV_T3() {
		return R16_TOT_REV_T3;
	}

	public void setR16_TOT_REV_T3(String r16_TOT_REV_T3) {
		R16_TOT_REV_T3 = r16_TOT_REV_T3;
	}

	public String getR16_PROF_LOS_T3() {
		return R16_PROF_LOS_T3;
	}

	public void setR16_PROF_LOS_T3(String r16_PROF_LOS_T3) {
		R16_PROF_LOS_T3 = r16_PROF_LOS_T3;
	}

	public String getR16_PROF_MARG_T3() {
		return R16_PROF_MARG_T3;
	}

	public void setR16_PROF_MARG_T3(String r16_PROF_MARG_T3) {
		R16_PROF_MARG_T3 = r16_PROF_MARG_T3;
	}

	public String getR16_TOT_RET_ASET_T3() {
		return R16_TOT_RET_ASET_T3;
	}

	public void setR16_TOT_RET_ASET_T3(String r16_TOT_RET_ASET_T3) {
		R16_TOT_RET_ASET_T3 = r16_TOT_RET_ASET_T3;
	}

	public String getR16_NON_PERF_PORT_T3() {
		return R16_NON_PERF_PORT_T3;
	}

	public void setR16_NON_PERF_PORT_T3(String r16_NON_PERF_PORT_T3) {
		R16_NON_PERF_PORT_T3 = r16_NON_PERF_PORT_T3;
	}

	public String getR16_NO_CON_LAST_T3() {
		return R16_NO_CON_LAST_T3;
	}

	public void setR16_NO_CON_LAST_T3(String r16_NO_CON_LAST_T3) {
		R16_NO_CON_LAST_T3 = r16_NO_CON_LAST_T3;
	}

	public String getR16_TOT_BRANCH_T3() {
		return R16_TOT_BRANCH_T3;
	}

	public void setR16_TOT_BRANCH_T3(String r16_TOT_BRANCH_T3) {
		R16_TOT_BRANCH_T3 = r16_TOT_BRANCH_T3;
	}

	public String getR16_NPL_SPD() {
		return R16_NPL_SPD;
	}

	public void setR16_NPL_SPD(String r16_NPL_SPD) {
		R16_NPL_SPD = r16_NPL_SPD;
	}

	public String getR16_RECO_NPL_SPD() {
		return R16_RECO_NPL_SPD;
	}

	public void setR16_RECO_NPL_SPD(String r16_RECO_NPL_SPD) {
		R16_RECO_NPL_SPD = r16_RECO_NPL_SPD;
	}

	public String getR16_NO_CON_ONBO_DIGI() {
		return R16_NO_CON_ONBO_DIGI;
	}

	public void setR16_NO_CON_ONBO_DIGI(String r16_NO_CON_ONBO_DIGI) {
		R16_NO_CON_ONBO_DIGI = r16_NO_CON_ONBO_DIGI;
	}

	public String getR16_NO_ACCS_AML() {
		return R16_NO_ACCS_AML;
	}

	public void setR16_NO_ACCS_AML(String r16_NO_ACCS_AML) {
		R16_NO_ACCS_AML = r16_NO_ACCS_AML;
	}

	public String getR16_TOT_ACC_LOAN_AML() {
		return R16_TOT_ACC_LOAN_AML;
	}

	public void setR16_TOT_ACC_LOAN_AML(String r16_TOT_ACC_LOAN_AML) {
		R16_TOT_ACC_LOAN_AML = r16_TOT_ACC_LOAN_AML;
	}

	public String getR16_TOT_NEW_ACCS_SPD() {
		return R16_TOT_NEW_ACCS_SPD;
	}

	public void setR16_TOT_NEW_ACCS_SPD(String r16_TOT_NEW_ACCS_SPD) {
		R16_TOT_NEW_ACCS_SPD = r16_TOT_NEW_ACCS_SPD;
	}

	public String getR16_TOT_VALS_LOANS_SPD() {
		return R16_TOT_VALS_LOANS_SPD;
	}

	public void setR16_TOT_VALS_LOANS_SPD(String r16_TOT_VALS_LOANS_SPD) {
		R16_TOT_VALS_LOANS_SPD = r16_TOT_VALS_LOANS_SPD;
	}

	public String getR16_NO_INQ_WEBMOB() {
		return R16_NO_INQ_WEBMOB;
	}

	public void setR16_NO_INQ_WEBMOB(String r16_NO_INQ_WEBMOB) {
		R16_NO_INQ_WEBMOB = r16_NO_INQ_WEBMOB;
	}

	public String getR16_NO_INQ_TRAD() {
		return R16_NO_INQ_TRAD;
	}

	public void setR16_NO_INQ_TRAD(String r16_NO_INQ_TRAD) {
		R16_NO_INQ_TRAD = r16_NO_INQ_TRAD;
	}

	public String getR16_NO_RET_POS() {
		return R16_NO_RET_POS;
	}

	public void setR16_NO_RET_POS(String r16_NO_RET_POS) {
		R16_NO_RET_POS = r16_NO_RET_POS;
	}

	public String getR16_AMT_POS_GATE() {
		return R16_AMT_POS_GATE;
	}

	public void setR16_AMT_POS_GATE(String r16_AMT_POS_GATE) {
		R16_AMT_POS_GATE = r16_AMT_POS_GATE;
	}

	public String getR16_NO_TRAN_SVF_BNK() {
		return R16_NO_TRAN_SVF_BNK;
	}

	public void setR16_NO_TRAN_SVF_BNK(String r16_NO_TRAN_SVF_BNK) {
		R16_NO_TRAN_SVF_BNK = r16_NO_TRAN_SVF_BNK;
	}

	public String getR16_AMT_RET_SVF_BNK() {
		return R16_AMT_RET_SVF_BNK;
	}

	public void setR16_AMT_RET_SVF_BNK(String r16_AMT_RET_SVF_BNK) {
		R16_AMT_RET_SVF_BNK = r16_AMT_RET_SVF_BNK;
	}

	public String getR16_TOT_WEB_MOB_VIRT() {
		return R16_TOT_WEB_MOB_VIRT;
	}

	public void setR16_TOT_WEB_MOB_VIRT(String r16_TOT_WEB_MOB_VIRT) {
		R16_TOT_WEB_MOB_VIRT = r16_TOT_WEB_MOB_VIRT;
	}

	public String getR16_VAL_UNCL_SVF() {
		return R16_VAL_UNCL_SVF;
	}

	public void setR16_VAL_UNCL_SVF(String r16_VAL_UNCL_SVF) {
		R16_VAL_UNCL_SVF = r16_VAL_UNCL_SVF;
	}

	public String getR16_NO_CON_LOW_RSK() {
		return R16_NO_CON_LOW_RSK;
	}

	public void setR16_NO_CON_LOW_RSK(String r16_NO_CON_LOW_RSK) {
		R16_NO_CON_LOW_RSK = r16_NO_CON_LOW_RSK;
	}

	public String getR16_NO_CON_HIGH_RSK() {
		return R16_NO_CON_HIGH_RSK;
	}

	public void setR16_NO_CON_HIGH_RSK(String r16_NO_CON_HIGH_RSK) {
		R16_NO_CON_HIGH_RSK = r16_NO_CON_HIGH_RSK;
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

	public String getR17_RET_ASET_LTS() {
		return R17_RET_ASET_LTS;
	}

	public void setR17_RET_ASET_LTS(String r17_RET_ASET_LTS) {
		R17_RET_ASET_LTS = r17_RET_ASET_LTS;
	}

	public String getR17_RET_ASET_LTSME() {
		return R17_RET_ASET_LTSME;
	}

	public void setR17_RET_ASET_LTSME(String r17_RET_ASET_LTSME) {
		R17_RET_ASET_LTSME = r17_RET_ASET_LTSME;
	}

	public String getR17_RET_ASET_SME_GUR() {
		return R17_RET_ASET_SME_GUR;
	}

	public void setR17_RET_ASET_SME_GUR(String r17_RET_ASET_SME_GUR) {
		R17_RET_ASET_SME_GUR = r17_RET_ASET_SME_GUR;
	}

	public String getR17_RET_LOAN_DIS() {
		return R17_RET_LOAN_DIS;
	}

	public void setR17_RET_LOAN_DIS(String r17_RET_LOAN_DIS) {
		R17_RET_LOAN_DIS = r17_RET_LOAN_DIS;
	}

	public String getR17_RET_ASET_LOAN_SME() {
		return R17_RET_ASET_LOAN_SME;
	}

	public void setR17_RET_ASET_LOAN_SME(String r17_RET_ASET_LOAN_SME) {
		R17_RET_ASET_LOAN_SME = r17_RET_ASET_LOAN_SME;
	}

	public String getR17_PER_LOAN_WEB() {
		return R17_PER_LOAN_WEB;
	}

	public void setR17_PER_LOAN_WEB(String r17_PER_LOAN_WEB) {
		R17_PER_LOAN_WEB = r17_PER_LOAN_WEB;
	}

	public String getR17_LOAN_SME_WEB_MOB() {
		return R17_LOAN_SME_WEB_MOB;
	}

	public void setR17_LOAN_SME_WEB_MOB(String r17_LOAN_SME_WEB_MOB) {
		R17_LOAN_SME_WEB_MOB = r17_LOAN_SME_WEB_MOB;
	}

	public String getR17_NO_COMPDIGI_MOB() {
		return R17_NO_COMPDIGI_MOB;
	}

	public void setR17_NO_COMPDIGI_MOB(String r17_NO_COMPDIGI_MOB) {
		R17_NO_COMPDIGI_MOB = r17_NO_COMPDIGI_MOB;
	}

	public String getR17_NO_COMP_TRADCALL() {
		return R17_NO_COMP_TRADCALL;
	}

	public void setR17_NO_COMP_TRADCALL(String r17_NO_COMP_TRADCALL) {
		R17_NO_COMP_TRADCALL = r17_NO_COMP_TRADCALL;
	}

	public String getR17_PER_COMPDIGI_WEB() {
		return R17_PER_COMPDIGI_WEB;
	}

	public void setR17_PER_COMPDIGI_WEB(String r17_PER_COMPDIGI_WEB) {
		R17_PER_COMPDIGI_WEB = r17_PER_COMPDIGI_WEB;
	}

	public String getR17_PER_COM_TRADCALL() {
		return R17_PER_COM_TRADCALL;
	}

	public void setR17_PER_COM_TRADCALL(String r17_PER_COM_TRADCALL) {
		R17_PER_COM_TRADCALL = r17_PER_COM_TRADCALL;
	}

	public String getR17_TOT_REV_PREV() {
		return R17_TOT_REV_PREV;
	}

	public void setR17_TOT_REV_PREV(String r17_TOT_REV_PREV) {
		R17_TOT_REV_PREV = r17_TOT_REV_PREV;
	}

	public String getR17_PROF_LOSS_PREV() {
		return R17_PROF_LOSS_PREV;
	}

	public void setR17_PROF_LOSS_PREV(String r17_PROF_LOSS_PREV) {
		R17_PROF_LOSS_PREV = r17_PROF_LOSS_PREV;
	}

	public String getR17_PROF_MARG_PORTFOLIO() {
		return R17_PROF_MARG_PORTFOLIO;
	}

	public void setR17_PROF_MARG_PORTFOLIO(String r17_PROF_MARG_PORTFOLIO) {
		R17_PROF_MARG_PORTFOLIO = r17_PROF_MARG_PORTFOLIO;
	}

	public String getR17_TOT_RET_ASET_PREV() {
		return R17_TOT_RET_ASET_PREV;
	}

	public void setR17_TOT_RET_ASET_PREV(String r17_TOT_RET_ASET_PREV) {
		R17_TOT_RET_ASET_PREV = r17_TOT_RET_ASET_PREV;
	}

	public String getR17_NP_LOAN_PREV() {
		return R17_NP_LOAN_PREV;
	}

	public void setR17_NP_LOAN_PREV(String r17_NP_LOAN_PREV) {
		R17_NP_LOAN_PREV = r17_NP_LOAN_PREV;
	}

	public String getR17_NON_CON_ONLAST_PREV() {
		return R17_NON_CON_ONLAST_PREV;
	}

	public void setR17_NON_CON_ONLAST_PREV(String r17_NON_CON_ONLAST_PREV) {
		R17_NON_CON_ONLAST_PREV = r17_NON_CON_ONLAST_PREV;
	}

	public String getR17_TOT_BRAN_PREV() {
		return R17_TOT_BRAN_PREV;
	}

	public void setR17_TOT_BRAN_PREV(String r17_TOT_BRAN_PREV) {
		R17_TOT_BRAN_PREV = r17_TOT_BRAN_PREV;
	}

	public String getR17_TOT_REV_RET_CUR() {
		return R17_TOT_REV_RET_CUR;
	}

	public void setR17_TOT_REV_RET_CUR(String r17_TOT_REV_RET_CUR) {
		R17_TOT_REV_RET_CUR = r17_TOT_REV_RET_CUR;
	}

	public String getR17_PROF_LOS_PORT_CUR() {
		return R17_PROF_LOS_PORT_CUR;
	}

	public void setR17_PROF_LOS_PORT_CUR(String r17_PROF_LOS_PORT_CUR) {
		R17_PROF_LOS_PORT_CUR = r17_PROF_LOS_PORT_CUR;
	}

	public String getR17_PROF_MARG_PERC_CUR() {
		return R17_PROF_MARG_PERC_CUR;
	}

	public void setR17_PROF_MARG_PERC_CUR(String r17_PROF_MARG_PERC_CUR) {
		R17_PROF_MARG_PERC_CUR = r17_PROF_MARG_PERC_CUR;
	}

	public String getR17_TOT_RET_ASET_CUR() {
		return R17_TOT_RET_ASET_CUR;
	}

	public void setR17_TOT_RET_ASET_CUR(String r17_TOT_RET_ASET_CUR) {
		R17_TOT_RET_ASET_CUR = r17_TOT_RET_ASET_CUR;
	}

	public String getR17_NON_PER_RET_PORT_CUR() {
		return R17_NON_PER_RET_PORT_CUR;
	}

	public void setR17_NON_PER_RET_PORT_CUR(String r17_NON_PER_RET_PORT_CUR) {
		R17_NON_PER_RET_PORT_CUR = r17_NON_PER_RET_PORT_CUR;
	}

	public String getR17_NO_CON_LAST_CUR() {
		return R17_NO_CON_LAST_CUR;
	}

	public void setR17_NO_CON_LAST_CUR(String r17_NO_CON_LAST_CUR) {
		R17_NO_CON_LAST_CUR = r17_NO_CON_LAST_CUR;
	}

	public String getR17_TOT_BRANCH_CUR() {
		return R17_TOT_BRANCH_CUR;
	}

	public void setR17_TOT_BRANCH_CUR(String r17_TOT_BRANCH_CUR) {
		R17_TOT_BRANCH_CUR = r17_TOT_BRANCH_CUR;
	}

	public String getR17_TOT_REV_T1() {
		return R17_TOT_REV_T1;
	}

	public void setR17_TOT_REV_T1(String r17_TOT_REV_T1) {
		R17_TOT_REV_T1 = r17_TOT_REV_T1;
	}

	public String getR17_PROF_LOS_T1() {
		return R17_PROF_LOS_T1;
	}

	public void setR17_PROF_LOS_T1(String r17_PROF_LOS_T1) {
		R17_PROF_LOS_T1 = r17_PROF_LOS_T1;
	}

	public String getR17_PROF_MARG_T1() {
		return R17_PROF_MARG_T1;
	}

	public void setR17_PROF_MARG_T1(String r17_PROF_MARG_T1) {
		R17_PROF_MARG_T1 = r17_PROF_MARG_T1;
	}

	public String getR17_TOT_RET_ASET_T1() {
		return R17_TOT_RET_ASET_T1;
	}

	public void setR17_TOT_RET_ASET_T1(String r17_TOT_RET_ASET_T1) {
		R17_TOT_RET_ASET_T1 = r17_TOT_RET_ASET_T1;
	}

	public String getR17_NON_PERF_PORT_T1() {
		return R17_NON_PERF_PORT_T1;
	}

	public void setR17_NON_PERF_PORT_T1(String r17_NON_PERF_PORT_T1) {
		R17_NON_PERF_PORT_T1 = r17_NON_PERF_PORT_T1;
	}

	public String getR17_NO_CON_LAST_T1() {
		return R17_NO_CON_LAST_T1;
	}

	public void setR17_NO_CON_LAST_T1(String r17_NO_CON_LAST_T1) {
		R17_NO_CON_LAST_T1 = r17_NO_CON_LAST_T1;
	}

	public String getR17_TOT_BRANCH_T1() {
		return R17_TOT_BRANCH_T1;
	}

	public void setR17_TOT_BRANCH_T1(String r17_TOT_BRANCH_T1) {
		R17_TOT_BRANCH_T1 = r17_TOT_BRANCH_T1;
	}

	public String getR17_TOT_REV_T2() {
		return R17_TOT_REV_T2;
	}

	public void setR17_TOT_REV_T2(String r17_TOT_REV_T2) {
		R17_TOT_REV_T2 = r17_TOT_REV_T2;
	}

	public String getR17_PROF_LOS_T2() {
		return R17_PROF_LOS_T2;
	}

	public void setR17_PROF_LOS_T2(String r17_PROF_LOS_T2) {
		R17_PROF_LOS_T2 = r17_PROF_LOS_T2;
	}

	public String getR17_PROF_MARG_T2() {
		return R17_PROF_MARG_T2;
	}

	public void setR17_PROF_MARG_T2(String r17_PROF_MARG_T2) {
		R17_PROF_MARG_T2 = r17_PROF_MARG_T2;
	}

	public String getR17_TOT_RET_ASET_T2() {
		return R17_TOT_RET_ASET_T2;
	}

	public void setR17_TOT_RET_ASET_T2(String r17_TOT_RET_ASET_T2) {
		R17_TOT_RET_ASET_T2 = r17_TOT_RET_ASET_T2;
	}

	public String getR17_NON_PERF_PORT_T2() {
		return R17_NON_PERF_PORT_T2;
	}

	public void setR17_NON_PERF_PORT_T2(String r17_NON_PERF_PORT_T2) {
		R17_NON_PERF_PORT_T2 = r17_NON_PERF_PORT_T2;
	}

	public String getR17_NO_CON_LAST_T2() {
		return R17_NO_CON_LAST_T2;
	}

	public void setR17_NO_CON_LAST_T2(String r17_NO_CON_LAST_T2) {
		R17_NO_CON_LAST_T2 = r17_NO_CON_LAST_T2;
	}

	public String getR17_TOT_BRANCH_T2() {
		return R17_TOT_BRANCH_T2;
	}

	public void setR17_TOT_BRANCH_T2(String r17_TOT_BRANCH_T2) {
		R17_TOT_BRANCH_T2 = r17_TOT_BRANCH_T2;
	}

	public String getR17_TOT_REV_T3() {
		return R17_TOT_REV_T3;
	}

	public void setR17_TOT_REV_T3(String r17_TOT_REV_T3) {
		R17_TOT_REV_T3 = r17_TOT_REV_T3;
	}

	public String getR17_PROF_LOS_T3() {
		return R17_PROF_LOS_T3;
	}

	public void setR17_PROF_LOS_T3(String r17_PROF_LOS_T3) {
		R17_PROF_LOS_T3 = r17_PROF_LOS_T3;
	}

	public String getR17_PROF_MARG_T3() {
		return R17_PROF_MARG_T3;
	}

	public void setR17_PROF_MARG_T3(String r17_PROF_MARG_T3) {
		R17_PROF_MARG_T3 = r17_PROF_MARG_T3;
	}

	public String getR17_TOT_RET_ASET_T3() {
		return R17_TOT_RET_ASET_T3;
	}

	public void setR17_TOT_RET_ASET_T3(String r17_TOT_RET_ASET_T3) {
		R17_TOT_RET_ASET_T3 = r17_TOT_RET_ASET_T3;
	}

	public String getR17_NON_PERF_PORT_T3() {
		return R17_NON_PERF_PORT_T3;
	}

	public void setR17_NON_PERF_PORT_T3(String r17_NON_PERF_PORT_T3) {
		R17_NON_PERF_PORT_T3 = r17_NON_PERF_PORT_T3;
	}

	public String getR17_NO_CON_LAST_T3() {
		return R17_NO_CON_LAST_T3;
	}

	public void setR17_NO_CON_LAST_T3(String r17_NO_CON_LAST_T3) {
		R17_NO_CON_LAST_T3 = r17_NO_CON_LAST_T3;
	}

	public String getR17_TOT_BRANCH_T3() {
		return R17_TOT_BRANCH_T3;
	}

	public void setR17_TOT_BRANCH_T3(String r17_TOT_BRANCH_T3) {
		R17_TOT_BRANCH_T3 = r17_TOT_BRANCH_T3;
	}

	public String getR17_NPL_SPD() {
		return R17_NPL_SPD;
	}

	public void setR17_NPL_SPD(String r17_NPL_SPD) {
		R17_NPL_SPD = r17_NPL_SPD;
	}

	public String getR17_RECO_NPL_SPD() {
		return R17_RECO_NPL_SPD;
	}

	public void setR17_RECO_NPL_SPD(String r17_RECO_NPL_SPD) {
		R17_RECO_NPL_SPD = r17_RECO_NPL_SPD;
	}

	public String getR17_NO_CON_ONBO_DIGI() {
		return R17_NO_CON_ONBO_DIGI;
	}

	public void setR17_NO_CON_ONBO_DIGI(String r17_NO_CON_ONBO_DIGI) {
		R17_NO_CON_ONBO_DIGI = r17_NO_CON_ONBO_DIGI;
	}

	public String getR17_NO_ACCS_AML() {
		return R17_NO_ACCS_AML;
	}

	public void setR17_NO_ACCS_AML(String r17_NO_ACCS_AML) {
		R17_NO_ACCS_AML = r17_NO_ACCS_AML;
	}

	public String getR17_TOT_ACC_LOAN_AML() {
		return R17_TOT_ACC_LOAN_AML;
	}

	public void setR17_TOT_ACC_LOAN_AML(String r17_TOT_ACC_LOAN_AML) {
		R17_TOT_ACC_LOAN_AML = r17_TOT_ACC_LOAN_AML;
	}

	public String getR17_TOT_NEW_ACCS_SPD() {
		return R17_TOT_NEW_ACCS_SPD;
	}

	public void setR17_TOT_NEW_ACCS_SPD(String r17_TOT_NEW_ACCS_SPD) {
		R17_TOT_NEW_ACCS_SPD = r17_TOT_NEW_ACCS_SPD;
	}

	public String getR17_TOT_VALS_LOANS_SPD() {
		return R17_TOT_VALS_LOANS_SPD;
	}

	public void setR17_TOT_VALS_LOANS_SPD(String r17_TOT_VALS_LOANS_SPD) {
		R17_TOT_VALS_LOANS_SPD = r17_TOT_VALS_LOANS_SPD;
	}

	public String getR17_NO_INQ_WEBMOB() {
		return R17_NO_INQ_WEBMOB;
	}

	public void setR17_NO_INQ_WEBMOB(String r17_NO_INQ_WEBMOB) {
		R17_NO_INQ_WEBMOB = r17_NO_INQ_WEBMOB;
	}

	public String getR17_NO_INQ_TRAD() {
		return R17_NO_INQ_TRAD;
	}

	public void setR17_NO_INQ_TRAD(String r17_NO_INQ_TRAD) {
		R17_NO_INQ_TRAD = r17_NO_INQ_TRAD;
	}

	public String getR17_NO_RET_POS() {
		return R17_NO_RET_POS;
	}

	public void setR17_NO_RET_POS(String r17_NO_RET_POS) {
		R17_NO_RET_POS = r17_NO_RET_POS;
	}

	public String getR17_AMT_POS_GATE() {
		return R17_AMT_POS_GATE;
	}

	public void setR17_AMT_POS_GATE(String r17_AMT_POS_GATE) {
		R17_AMT_POS_GATE = r17_AMT_POS_GATE;
	}

	public String getR17_NO_TRAN_SVF_BNK() {
		return R17_NO_TRAN_SVF_BNK;
	}

	public void setR17_NO_TRAN_SVF_BNK(String r17_NO_TRAN_SVF_BNK) {
		R17_NO_TRAN_SVF_BNK = r17_NO_TRAN_SVF_BNK;
	}

	public String getR17_AMT_RET_SVF_BNK() {
		return R17_AMT_RET_SVF_BNK;
	}

	public void setR17_AMT_RET_SVF_BNK(String r17_AMT_RET_SVF_BNK) {
		R17_AMT_RET_SVF_BNK = r17_AMT_RET_SVF_BNK;
	}

	public String getR17_TOT_WEB_MOB_VIRT() {
		return R17_TOT_WEB_MOB_VIRT;
	}

	public void setR17_TOT_WEB_MOB_VIRT(String r17_TOT_WEB_MOB_VIRT) {
		R17_TOT_WEB_MOB_VIRT = r17_TOT_WEB_MOB_VIRT;
	}

	public String getR17_VAL_UNCL_SVF() {
		return R17_VAL_UNCL_SVF;
	}

	public void setR17_VAL_UNCL_SVF(String r17_VAL_UNCL_SVF) {
		R17_VAL_UNCL_SVF = r17_VAL_UNCL_SVF;
	}

	public String getR17_NO_CON_LOW_RSK() {
		return R17_NO_CON_LOW_RSK;
	}

	public void setR17_NO_CON_LOW_RSK(String r17_NO_CON_LOW_RSK) {
		R17_NO_CON_LOW_RSK = r17_NO_CON_LOW_RSK;
	}

	public String getR17_NO_CON_HIGH_RSK() {
		return R17_NO_CON_HIGH_RSK;
	}

	public void setR17_NO_CON_HIGH_RSK(String r17_NO_CON_HIGH_RSK) {
		R17_NO_CON_HIGH_RSK = r17_NO_CON_HIGH_RSK;
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

	public String getR18_RET_ASET_LTS() {
		return R18_RET_ASET_LTS;
	}

	public void setR18_RET_ASET_LTS(String r18_RET_ASET_LTS) {
		R18_RET_ASET_LTS = r18_RET_ASET_LTS;
	}

	public String getR18_RET_ASET_LTSME() {
		return R18_RET_ASET_LTSME;
	}

	public void setR18_RET_ASET_LTSME(String r18_RET_ASET_LTSME) {
		R18_RET_ASET_LTSME = r18_RET_ASET_LTSME;
	}

	public String getR18_RET_ASET_SME_GUR() {
		return R18_RET_ASET_SME_GUR;
	}

	public void setR18_RET_ASET_SME_GUR(String r18_RET_ASET_SME_GUR) {
		R18_RET_ASET_SME_GUR = r18_RET_ASET_SME_GUR;
	}

	public String getR18_RET_LOAN_DIS() {
		return R18_RET_LOAN_DIS;
	}

	public void setR18_RET_LOAN_DIS(String r18_RET_LOAN_DIS) {
		R18_RET_LOAN_DIS = r18_RET_LOAN_DIS;
	}

	public String getR18_RET_ASET_LOAN_SME() {
		return R18_RET_ASET_LOAN_SME;
	}

	public void setR18_RET_ASET_LOAN_SME(String r18_RET_ASET_LOAN_SME) {
		R18_RET_ASET_LOAN_SME = r18_RET_ASET_LOAN_SME;
	}

	public String getR18_PER_LOAN_WEB() {
		return R18_PER_LOAN_WEB;
	}

	public void setR18_PER_LOAN_WEB(String r18_PER_LOAN_WEB) {
		R18_PER_LOAN_WEB = r18_PER_LOAN_WEB;
	}

	public String getR18_LOAN_SME_WEB_MOB() {
		return R18_LOAN_SME_WEB_MOB;
	}

	public void setR18_LOAN_SME_WEB_MOB(String r18_LOAN_SME_WEB_MOB) {
		R18_LOAN_SME_WEB_MOB = r18_LOAN_SME_WEB_MOB;
	}

	public String getR18_NO_COMPDIGI_MOB() {
		return R18_NO_COMPDIGI_MOB;
	}

	public void setR18_NO_COMPDIGI_MOB(String r18_NO_COMPDIGI_MOB) {
		R18_NO_COMPDIGI_MOB = r18_NO_COMPDIGI_MOB;
	}

	public String getR18_NO_COMP_TRADCALL() {
		return R18_NO_COMP_TRADCALL;
	}

	public void setR18_NO_COMP_TRADCALL(String r18_NO_COMP_TRADCALL) {
		R18_NO_COMP_TRADCALL = r18_NO_COMP_TRADCALL;
	}

	public String getR18_PER_COMPDIGI_WEB() {
		return R18_PER_COMPDIGI_WEB;
	}

	public void setR18_PER_COMPDIGI_WEB(String r18_PER_COMPDIGI_WEB) {
		R18_PER_COMPDIGI_WEB = r18_PER_COMPDIGI_WEB;
	}

	public String getR18_PER_COM_TRADCALL() {
		return R18_PER_COM_TRADCALL;
	}

	public void setR18_PER_COM_TRADCALL(String r18_PER_COM_TRADCALL) {
		R18_PER_COM_TRADCALL = r18_PER_COM_TRADCALL;
	}

	public String getR18_TOT_REV_PREV() {
		return R18_TOT_REV_PREV;
	}

	public void setR18_TOT_REV_PREV(String r18_TOT_REV_PREV) {
		R18_TOT_REV_PREV = r18_TOT_REV_PREV;
	}

	public String getR18_PROF_LOSS_PREV() {
		return R18_PROF_LOSS_PREV;
	}

	public void setR18_PROF_LOSS_PREV(String r18_PROF_LOSS_PREV) {
		R18_PROF_LOSS_PREV = r18_PROF_LOSS_PREV;
	}

	public String getR18_PROF_MARG_PORTFOLIO() {
		return R18_PROF_MARG_PORTFOLIO;
	}

	public void setR18_PROF_MARG_PORTFOLIO(String r18_PROF_MARG_PORTFOLIO) {
		R18_PROF_MARG_PORTFOLIO = r18_PROF_MARG_PORTFOLIO;
	}

	public String getR18_TOT_RET_ASET_PREV() {
		return R18_TOT_RET_ASET_PREV;
	}

	public void setR18_TOT_RET_ASET_PREV(String r18_TOT_RET_ASET_PREV) {
		R18_TOT_RET_ASET_PREV = r18_TOT_RET_ASET_PREV;
	}

	public String getR18_NP_LOAN_PREV() {
		return R18_NP_LOAN_PREV;
	}

	public void setR18_NP_LOAN_PREV(String r18_NP_LOAN_PREV) {
		R18_NP_LOAN_PREV = r18_NP_LOAN_PREV;
	}

	public String getR18_NON_CON_ONLAST_PREV() {
		return R18_NON_CON_ONLAST_PREV;
	}

	public void setR18_NON_CON_ONLAST_PREV(String r18_NON_CON_ONLAST_PREV) {
		R18_NON_CON_ONLAST_PREV = r18_NON_CON_ONLAST_PREV;
	}

	public String getR18_TOT_BRAN_PREV() {
		return R18_TOT_BRAN_PREV;
	}

	public void setR18_TOT_BRAN_PREV(String r18_TOT_BRAN_PREV) {
		R18_TOT_BRAN_PREV = r18_TOT_BRAN_PREV;
	}

	public String getR18_TOT_REV_RET_CUR() {
		return R18_TOT_REV_RET_CUR;
	}

	public void setR18_TOT_REV_RET_CUR(String r18_TOT_REV_RET_CUR) {
		R18_TOT_REV_RET_CUR = r18_TOT_REV_RET_CUR;
	}

	public String getR18_PROF_LOS_PORT_CUR() {
		return R18_PROF_LOS_PORT_CUR;
	}

	public void setR18_PROF_LOS_PORT_CUR(String r18_PROF_LOS_PORT_CUR) {
		R18_PROF_LOS_PORT_CUR = r18_PROF_LOS_PORT_CUR;
	}

	public String getR18_PROF_MARG_PERC_CUR() {
		return R18_PROF_MARG_PERC_CUR;
	}

	public void setR18_PROF_MARG_PERC_CUR(String r18_PROF_MARG_PERC_CUR) {
		R18_PROF_MARG_PERC_CUR = r18_PROF_MARG_PERC_CUR;
	}

	public String getR18_TOT_RET_ASET_CUR() {
		return R18_TOT_RET_ASET_CUR;
	}

	public void setR18_TOT_RET_ASET_CUR(String r18_TOT_RET_ASET_CUR) {
		R18_TOT_RET_ASET_CUR = r18_TOT_RET_ASET_CUR;
	}

	public String getR18_NON_PER_RET_PORT_CUR() {
		return R18_NON_PER_RET_PORT_CUR;
	}

	public void setR18_NON_PER_RET_PORT_CUR(String r18_NON_PER_RET_PORT_CUR) {
		R18_NON_PER_RET_PORT_CUR = r18_NON_PER_RET_PORT_CUR;
	}

	public String getR18_NO_CON_LAST_CUR() {
		return R18_NO_CON_LAST_CUR;
	}

	public void setR18_NO_CON_LAST_CUR(String r18_NO_CON_LAST_CUR) {
		R18_NO_CON_LAST_CUR = r18_NO_CON_LAST_CUR;
	}

	public String getR18_TOT_BRANCH_CUR() {
		return R18_TOT_BRANCH_CUR;
	}

	public void setR18_TOT_BRANCH_CUR(String r18_TOT_BRANCH_CUR) {
		R18_TOT_BRANCH_CUR = r18_TOT_BRANCH_CUR;
	}

	public String getR18_TOT_REV_T1() {
		return R18_TOT_REV_T1;
	}

	public void setR18_TOT_REV_T1(String r18_TOT_REV_T1) {
		R18_TOT_REV_T1 = r18_TOT_REV_T1;
	}

	public String getR18_PROF_LOS_T1() {
		return R18_PROF_LOS_T1;
	}

	public void setR18_PROF_LOS_T1(String r18_PROF_LOS_T1) {
		R18_PROF_LOS_T1 = r18_PROF_LOS_T1;
	}

	public String getR18_PROF_MARG_T1() {
		return R18_PROF_MARG_T1;
	}

	public void setR18_PROF_MARG_T1(String r18_PROF_MARG_T1) {
		R18_PROF_MARG_T1 = r18_PROF_MARG_T1;
	}

	public String getR18_TOT_RET_ASET_T1() {
		return R18_TOT_RET_ASET_T1;
	}

	public void setR18_TOT_RET_ASET_T1(String r18_TOT_RET_ASET_T1) {
		R18_TOT_RET_ASET_T1 = r18_TOT_RET_ASET_T1;
	}

	public String getR18_NON_PERF_PORT_T1() {
		return R18_NON_PERF_PORT_T1;
	}

	public void setR18_NON_PERF_PORT_T1(String r18_NON_PERF_PORT_T1) {
		R18_NON_PERF_PORT_T1 = r18_NON_PERF_PORT_T1;
	}

	public String getR18_NO_CON_LAST_T1() {
		return R18_NO_CON_LAST_T1;
	}

	public void setR18_NO_CON_LAST_T1(String r18_NO_CON_LAST_T1) {
		R18_NO_CON_LAST_T1 = r18_NO_CON_LAST_T1;
	}

	public String getR18_TOT_BRANCH_T1() {
		return R18_TOT_BRANCH_T1;
	}

	public void setR18_TOT_BRANCH_T1(String r18_TOT_BRANCH_T1) {
		R18_TOT_BRANCH_T1 = r18_TOT_BRANCH_T1;
	}

	public String getR18_TOT_REV_T2() {
		return R18_TOT_REV_T2;
	}

	public void setR18_TOT_REV_T2(String r18_TOT_REV_T2) {
		R18_TOT_REV_T2 = r18_TOT_REV_T2;
	}

	public String getR18_PROF_LOS_T2() {
		return R18_PROF_LOS_T2;
	}

	public void setR18_PROF_LOS_T2(String r18_PROF_LOS_T2) {
		R18_PROF_LOS_T2 = r18_PROF_LOS_T2;
	}

	public String getR18_PROF_MARG_T2() {
		return R18_PROF_MARG_T2;
	}

	public void setR18_PROF_MARG_T2(String r18_PROF_MARG_T2) {
		R18_PROF_MARG_T2 = r18_PROF_MARG_T2;
	}

	public String getR18_TOT_RET_ASET_T2() {
		return R18_TOT_RET_ASET_T2;
	}

	public void setR18_TOT_RET_ASET_T2(String r18_TOT_RET_ASET_T2) {
		R18_TOT_RET_ASET_T2 = r18_TOT_RET_ASET_T2;
	}

	public String getR18_NON_PERF_PORT_T2() {
		return R18_NON_PERF_PORT_T2;
	}

	public void setR18_NON_PERF_PORT_T2(String r18_NON_PERF_PORT_T2) {
		R18_NON_PERF_PORT_T2 = r18_NON_PERF_PORT_T2;
	}

	public String getR18_NO_CON_LAST_T2() {
		return R18_NO_CON_LAST_T2;
	}

	public void setR18_NO_CON_LAST_T2(String r18_NO_CON_LAST_T2) {
		R18_NO_CON_LAST_T2 = r18_NO_CON_LAST_T2;
	}

	public String getR18_TOT_BRANCH_T2() {
		return R18_TOT_BRANCH_T2;
	}

	public void setR18_TOT_BRANCH_T2(String r18_TOT_BRANCH_T2) {
		R18_TOT_BRANCH_T2 = r18_TOT_BRANCH_T2;
	}

	public String getR18_TOT_REV_T3() {
		return R18_TOT_REV_T3;
	}

	public void setR18_TOT_REV_T3(String r18_TOT_REV_T3) {
		R18_TOT_REV_T3 = r18_TOT_REV_T3;
	}

	public String getR18_PROF_LOS_T3() {
		return R18_PROF_LOS_T3;
	}

	public void setR18_PROF_LOS_T3(String r18_PROF_LOS_T3) {
		R18_PROF_LOS_T3 = r18_PROF_LOS_T3;
	}

	public String getR18_PROF_MARG_T3() {
		return R18_PROF_MARG_T3;
	}

	public void setR18_PROF_MARG_T3(String r18_PROF_MARG_T3) {
		R18_PROF_MARG_T3 = r18_PROF_MARG_T3;
	}

	public String getR18_TOT_RET_ASET_T3() {
		return R18_TOT_RET_ASET_T3;
	}

	public void setR18_TOT_RET_ASET_T3(String r18_TOT_RET_ASET_T3) {
		R18_TOT_RET_ASET_T3 = r18_TOT_RET_ASET_T3;
	}

	public String getR18_NON_PERF_PORT_T3() {
		return R18_NON_PERF_PORT_T3;
	}

	public void setR18_NON_PERF_PORT_T3(String r18_NON_PERF_PORT_T3) {
		R18_NON_PERF_PORT_T3 = r18_NON_PERF_PORT_T3;
	}

	public String getR18_NO_CON_LAST_T3() {
		return R18_NO_CON_LAST_T3;
	}

	public void setR18_NO_CON_LAST_T3(String r18_NO_CON_LAST_T3) {
		R18_NO_CON_LAST_T3 = r18_NO_CON_LAST_T3;
	}

	public String getR18_TOT_BRANCH_T3() {
		return R18_TOT_BRANCH_T3;
	}

	public void setR18_TOT_BRANCH_T3(String r18_TOT_BRANCH_T3) {
		R18_TOT_BRANCH_T3 = r18_TOT_BRANCH_T3;
	}

	public String getR18_NPL_SPD() {
		return R18_NPL_SPD;
	}

	public void setR18_NPL_SPD(String r18_NPL_SPD) {
		R18_NPL_SPD = r18_NPL_SPD;
	}

	public String getR18_RECO_NPL_SPD() {
		return R18_RECO_NPL_SPD;
	}

	public void setR18_RECO_NPL_SPD(String r18_RECO_NPL_SPD) {
		R18_RECO_NPL_SPD = r18_RECO_NPL_SPD;
	}

	public String getR18_NO_CON_ONBO_DIGI() {
		return R18_NO_CON_ONBO_DIGI;
	}

	public void setR18_NO_CON_ONBO_DIGI(String r18_NO_CON_ONBO_DIGI) {
		R18_NO_CON_ONBO_DIGI = r18_NO_CON_ONBO_DIGI;
	}

	public String getR18_NO_ACCS_AML() {
		return R18_NO_ACCS_AML;
	}

	public void setR18_NO_ACCS_AML(String r18_NO_ACCS_AML) {
		R18_NO_ACCS_AML = r18_NO_ACCS_AML;
	}

	public String getR18_TOT_ACC_LOAN_AML() {
		return R18_TOT_ACC_LOAN_AML;
	}

	public void setR18_TOT_ACC_LOAN_AML(String r18_TOT_ACC_LOAN_AML) {
		R18_TOT_ACC_LOAN_AML = r18_TOT_ACC_LOAN_AML;
	}

	public String getR18_TOT_NEW_ACCS_SPD() {
		return R18_TOT_NEW_ACCS_SPD;
	}

	public void setR18_TOT_NEW_ACCS_SPD(String r18_TOT_NEW_ACCS_SPD) {
		R18_TOT_NEW_ACCS_SPD = r18_TOT_NEW_ACCS_SPD;
	}

	public String getR18_TOT_VALS_LOANS_SPD() {
		return R18_TOT_VALS_LOANS_SPD;
	}

	public void setR18_TOT_VALS_LOANS_SPD(String r18_TOT_VALS_LOANS_SPD) {
		R18_TOT_VALS_LOANS_SPD = r18_TOT_VALS_LOANS_SPD;
	}

	public String getR18_NO_INQ_WEBMOB() {
		return R18_NO_INQ_WEBMOB;
	}

	public void setR18_NO_INQ_WEBMOB(String r18_NO_INQ_WEBMOB) {
		R18_NO_INQ_WEBMOB = r18_NO_INQ_WEBMOB;
	}

	public String getR18_NO_INQ_TRAD() {
		return R18_NO_INQ_TRAD;
	}

	public void setR18_NO_INQ_TRAD(String r18_NO_INQ_TRAD) {
		R18_NO_INQ_TRAD = r18_NO_INQ_TRAD;
	}

	public String getR18_NO_RET_POS() {
		return R18_NO_RET_POS;
	}

	public void setR18_NO_RET_POS(String r18_NO_RET_POS) {
		R18_NO_RET_POS = r18_NO_RET_POS;
	}

	public String getR18_AMT_POS_GATE() {
		return R18_AMT_POS_GATE;
	}

	public void setR18_AMT_POS_GATE(String r18_AMT_POS_GATE) {
		R18_AMT_POS_GATE = r18_AMT_POS_GATE;
	}

	public String getR18_NO_TRAN_SVF_BNK() {
		return R18_NO_TRAN_SVF_BNK;
	}

	public void setR18_NO_TRAN_SVF_BNK(String r18_NO_TRAN_SVF_BNK) {
		R18_NO_TRAN_SVF_BNK = r18_NO_TRAN_SVF_BNK;
	}

	public String getR18_AMT_RET_SVF_BNK() {
		return R18_AMT_RET_SVF_BNK;
	}

	public void setR18_AMT_RET_SVF_BNK(String r18_AMT_RET_SVF_BNK) {
		R18_AMT_RET_SVF_BNK = r18_AMT_RET_SVF_BNK;
	}

	public String getR18_TOT_WEB_MOB_VIRT() {
		return R18_TOT_WEB_MOB_VIRT;
	}

	public void setR18_TOT_WEB_MOB_VIRT(String r18_TOT_WEB_MOB_VIRT) {
		R18_TOT_WEB_MOB_VIRT = r18_TOT_WEB_MOB_VIRT;
	}

	public String getR18_VAL_UNCL_SVF() {
		return R18_VAL_UNCL_SVF;
	}

	public void setR18_VAL_UNCL_SVF(String r18_VAL_UNCL_SVF) {
		R18_VAL_UNCL_SVF = r18_VAL_UNCL_SVF;
	}

	public String getR18_NO_CON_LOW_RSK() {
		return R18_NO_CON_LOW_RSK;
	}

	public void setR18_NO_CON_LOW_RSK(String r18_NO_CON_LOW_RSK) {
		R18_NO_CON_LOW_RSK = r18_NO_CON_LOW_RSK;
	}

	public String getR18_NO_CON_HIGH_RSK() {
		return R18_NO_CON_HIGH_RSK;
	}

	public void setR18_NO_CON_HIGH_RSK(String r18_NO_CON_HIGH_RSK) {
		R18_NO_CON_HIGH_RSK = r18_NO_CON_HIGH_RSK;
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

	public String getR19_RET_ASET_LTS() {
		return R19_RET_ASET_LTS;
	}

	public void setR19_RET_ASET_LTS(String r19_RET_ASET_LTS) {
		R19_RET_ASET_LTS = r19_RET_ASET_LTS;
	}

	public String getR19_RET_ASET_LTSME() {
		return R19_RET_ASET_LTSME;
	}

	public void setR19_RET_ASET_LTSME(String r19_RET_ASET_LTSME) {
		R19_RET_ASET_LTSME = r19_RET_ASET_LTSME;
	}

	public String getR19_RET_ASET_SME_GUR() {
		return R19_RET_ASET_SME_GUR;
	}

	public void setR19_RET_ASET_SME_GUR(String r19_RET_ASET_SME_GUR) {
		R19_RET_ASET_SME_GUR = r19_RET_ASET_SME_GUR;
	}

	public String getR19_RET_LOAN_DIS() {
		return R19_RET_LOAN_DIS;
	}

	public void setR19_RET_LOAN_DIS(String r19_RET_LOAN_DIS) {
		R19_RET_LOAN_DIS = r19_RET_LOAN_DIS;
	}

	public String getR19_RET_ASET_LOAN_SME() {
		return R19_RET_ASET_LOAN_SME;
	}

	public void setR19_RET_ASET_LOAN_SME(String r19_RET_ASET_LOAN_SME) {
		R19_RET_ASET_LOAN_SME = r19_RET_ASET_LOAN_SME;
	}

	public String getR19_PER_LOAN_WEB() {
		return R19_PER_LOAN_WEB;
	}

	public void setR19_PER_LOAN_WEB(String r19_PER_LOAN_WEB) {
		R19_PER_LOAN_WEB = r19_PER_LOAN_WEB;
	}

	public String getR19_LOAN_SME_WEB_MOB() {
		return R19_LOAN_SME_WEB_MOB;
	}

	public void setR19_LOAN_SME_WEB_MOB(String r19_LOAN_SME_WEB_MOB) {
		R19_LOAN_SME_WEB_MOB = r19_LOAN_SME_WEB_MOB;
	}

	public String getR19_NO_COMPDIGI_MOB() {
		return R19_NO_COMPDIGI_MOB;
	}

	public void setR19_NO_COMPDIGI_MOB(String r19_NO_COMPDIGI_MOB) {
		R19_NO_COMPDIGI_MOB = r19_NO_COMPDIGI_MOB;
	}

	public String getR19_NO_COMP_TRADCALL() {
		return R19_NO_COMP_TRADCALL;
	}

	public void setR19_NO_COMP_TRADCALL(String r19_NO_COMP_TRADCALL) {
		R19_NO_COMP_TRADCALL = r19_NO_COMP_TRADCALL;
	}

	public String getR19_PER_COMPDIGI_WEB() {
		return R19_PER_COMPDIGI_WEB;
	}

	public void setR19_PER_COMPDIGI_WEB(String r19_PER_COMPDIGI_WEB) {
		R19_PER_COMPDIGI_WEB = r19_PER_COMPDIGI_WEB;
	}

	public String getR19_PER_COM_TRADCALL() {
		return R19_PER_COM_TRADCALL;
	}

	public void setR19_PER_COM_TRADCALL(String r19_PER_COM_TRADCALL) {
		R19_PER_COM_TRADCALL = r19_PER_COM_TRADCALL;
	}

	public String getR19_TOT_REV_PREV() {
		return R19_TOT_REV_PREV;
	}

	public void setR19_TOT_REV_PREV(String r19_TOT_REV_PREV) {
		R19_TOT_REV_PREV = r19_TOT_REV_PREV;
	}

	public String getR19_PROF_LOSS_PREV() {
		return R19_PROF_LOSS_PREV;
	}

	public void setR19_PROF_LOSS_PREV(String r19_PROF_LOSS_PREV) {
		R19_PROF_LOSS_PREV = r19_PROF_LOSS_PREV;
	}

	public String getR19_PROF_MARG_PORTFOLIO() {
		return R19_PROF_MARG_PORTFOLIO;
	}

	public void setR19_PROF_MARG_PORTFOLIO(String r19_PROF_MARG_PORTFOLIO) {
		R19_PROF_MARG_PORTFOLIO = r19_PROF_MARG_PORTFOLIO;
	}

	public String getR19_TOT_RET_ASET_PREV() {
		return R19_TOT_RET_ASET_PREV;
	}

	public void setR19_TOT_RET_ASET_PREV(String r19_TOT_RET_ASET_PREV) {
		R19_TOT_RET_ASET_PREV = r19_TOT_RET_ASET_PREV;
	}

	public String getR19_NP_LOAN_PREV() {
		return R19_NP_LOAN_PREV;
	}

	public void setR19_NP_LOAN_PREV(String r19_NP_LOAN_PREV) {
		R19_NP_LOAN_PREV = r19_NP_LOAN_PREV;
	}

	public String getR19_NON_CON_ONLAST_PREV() {
		return R19_NON_CON_ONLAST_PREV;
	}

	public void setR19_NON_CON_ONLAST_PREV(String r19_NON_CON_ONLAST_PREV) {
		R19_NON_CON_ONLAST_PREV = r19_NON_CON_ONLAST_PREV;
	}

	public String getR19_TOT_BRAN_PREV() {
		return R19_TOT_BRAN_PREV;
	}

	public void setR19_TOT_BRAN_PREV(String r19_TOT_BRAN_PREV) {
		R19_TOT_BRAN_PREV = r19_TOT_BRAN_PREV;
	}

	public String getR19_TOT_REV_RET_CUR() {
		return R19_TOT_REV_RET_CUR;
	}

	public void setR19_TOT_REV_RET_CUR(String r19_TOT_REV_RET_CUR) {
		R19_TOT_REV_RET_CUR = r19_TOT_REV_RET_CUR;
	}

	public String getR19_PROF_LOS_PORT_CUR() {
		return R19_PROF_LOS_PORT_CUR;
	}

	public void setR19_PROF_LOS_PORT_CUR(String r19_PROF_LOS_PORT_CUR) {
		R19_PROF_LOS_PORT_CUR = r19_PROF_LOS_PORT_CUR;
	}

	public String getR19_PROF_MARG_PERC_CUR() {
		return R19_PROF_MARG_PERC_CUR;
	}

	public void setR19_PROF_MARG_PERC_CUR(String r19_PROF_MARG_PERC_CUR) {
		R19_PROF_MARG_PERC_CUR = r19_PROF_MARG_PERC_CUR;
	}

	public String getR19_TOT_RET_ASET_CUR() {
		return R19_TOT_RET_ASET_CUR;
	}

	public void setR19_TOT_RET_ASET_CUR(String r19_TOT_RET_ASET_CUR) {
		R19_TOT_RET_ASET_CUR = r19_TOT_RET_ASET_CUR;
	}

	public String getR19_NON_PER_RET_PORT_CUR() {
		return R19_NON_PER_RET_PORT_CUR;
	}

	public void setR19_NON_PER_RET_PORT_CUR(String r19_NON_PER_RET_PORT_CUR) {
		R19_NON_PER_RET_PORT_CUR = r19_NON_PER_RET_PORT_CUR;
	}

	public String getR19_NO_CON_LAST_CUR() {
		return R19_NO_CON_LAST_CUR;
	}

	public void setR19_NO_CON_LAST_CUR(String r19_NO_CON_LAST_CUR) {
		R19_NO_CON_LAST_CUR = r19_NO_CON_LAST_CUR;
	}

	public String getR19_TOT_BRANCH_CUR() {
		return R19_TOT_BRANCH_CUR;
	}

	public void setR19_TOT_BRANCH_CUR(String r19_TOT_BRANCH_CUR) {
		R19_TOT_BRANCH_CUR = r19_TOT_BRANCH_CUR;
	}

	public String getR19_TOT_REV_T1() {
		return R19_TOT_REV_T1;
	}

	public void setR19_TOT_REV_T1(String r19_TOT_REV_T1) {
		R19_TOT_REV_T1 = r19_TOT_REV_T1;
	}

	public String getR19_PROF_LOS_T1() {
		return R19_PROF_LOS_T1;
	}

	public void setR19_PROF_LOS_T1(String r19_PROF_LOS_T1) {
		R19_PROF_LOS_T1 = r19_PROF_LOS_T1;
	}

	public String getR19_PROF_MARG_T1() {
		return R19_PROF_MARG_T1;
	}

	public void setR19_PROF_MARG_T1(String r19_PROF_MARG_T1) {
		R19_PROF_MARG_T1 = r19_PROF_MARG_T1;
	}

	public String getR19_TOT_RET_ASET_T1() {
		return R19_TOT_RET_ASET_T1;
	}

	public void setR19_TOT_RET_ASET_T1(String r19_TOT_RET_ASET_T1) {
		R19_TOT_RET_ASET_T1 = r19_TOT_RET_ASET_T1;
	}

	public String getR19_NON_PERF_PORT_T1() {
		return R19_NON_PERF_PORT_T1;
	}

	public void setR19_NON_PERF_PORT_T1(String r19_NON_PERF_PORT_T1) {
		R19_NON_PERF_PORT_T1 = r19_NON_PERF_PORT_T1;
	}

	public String getR19_NO_CON_LAST_T1() {
		return R19_NO_CON_LAST_T1;
	}

	public void setR19_NO_CON_LAST_T1(String r19_NO_CON_LAST_T1) {
		R19_NO_CON_LAST_T1 = r19_NO_CON_LAST_T1;
	}

	public String getR19_TOT_BRANCH_T1() {
		return R19_TOT_BRANCH_T1;
	}

	public void setR19_TOT_BRANCH_T1(String r19_TOT_BRANCH_T1) {
		R19_TOT_BRANCH_T1 = r19_TOT_BRANCH_T1;
	}

	public String getR19_TOT_REV_T2() {
		return R19_TOT_REV_T2;
	}

	public void setR19_TOT_REV_T2(String r19_TOT_REV_T2) {
		R19_TOT_REV_T2 = r19_TOT_REV_T2;
	}

	public String getR19_PROF_LOS_T2() {
		return R19_PROF_LOS_T2;
	}

	public void setR19_PROF_LOS_T2(String r19_PROF_LOS_T2) {
		R19_PROF_LOS_T2 = r19_PROF_LOS_T2;
	}

	public String getR19_PROF_MARG_T2() {
		return R19_PROF_MARG_T2;
	}

	public void setR19_PROF_MARG_T2(String r19_PROF_MARG_T2) {
		R19_PROF_MARG_T2 = r19_PROF_MARG_T2;
	}

	public String getR19_TOT_RET_ASET_T2() {
		return R19_TOT_RET_ASET_T2;
	}

	public void setR19_TOT_RET_ASET_T2(String r19_TOT_RET_ASET_T2) {
		R19_TOT_RET_ASET_T2 = r19_TOT_RET_ASET_T2;
	}

	public String getR19_NON_PERF_PORT_T2() {
		return R19_NON_PERF_PORT_T2;
	}

	public void setR19_NON_PERF_PORT_T2(String r19_NON_PERF_PORT_T2) {
		R19_NON_PERF_PORT_T2 = r19_NON_PERF_PORT_T2;
	}

	public String getR19_NO_CON_LAST_T2() {
		return R19_NO_CON_LAST_T2;
	}

	public void setR19_NO_CON_LAST_T2(String r19_NO_CON_LAST_T2) {
		R19_NO_CON_LAST_T2 = r19_NO_CON_LAST_T2;
	}

	public String getR19_TOT_BRANCH_T2() {
		return R19_TOT_BRANCH_T2;
	}

	public void setR19_TOT_BRANCH_T2(String r19_TOT_BRANCH_T2) {
		R19_TOT_BRANCH_T2 = r19_TOT_BRANCH_T2;
	}

	public String getR19_TOT_REV_T3() {
		return R19_TOT_REV_T3;
	}

	public void setR19_TOT_REV_T3(String r19_TOT_REV_T3) {
		R19_TOT_REV_T3 = r19_TOT_REV_T3;
	}

	public String getR19_PROF_LOS_T3() {
		return R19_PROF_LOS_T3;
	}

	public void setR19_PROF_LOS_T3(String r19_PROF_LOS_T3) {
		R19_PROF_LOS_T3 = r19_PROF_LOS_T3;
	}

	public String getR19_PROF_MARG_T3() {
		return R19_PROF_MARG_T3;
	}

	public void setR19_PROF_MARG_T3(String r19_PROF_MARG_T3) {
		R19_PROF_MARG_T3 = r19_PROF_MARG_T3;
	}

	public String getR19_TOT_RET_ASET_T3() {
		return R19_TOT_RET_ASET_T3;
	}

	public void setR19_TOT_RET_ASET_T3(String r19_TOT_RET_ASET_T3) {
		R19_TOT_RET_ASET_T3 = r19_TOT_RET_ASET_T3;
	}

	public String getR19_NON_PERF_PORT_T3() {
		return R19_NON_PERF_PORT_T3;
	}

	public void setR19_NON_PERF_PORT_T3(String r19_NON_PERF_PORT_T3) {
		R19_NON_PERF_PORT_T3 = r19_NON_PERF_PORT_T3;
	}

	public String getR19_NO_CON_LAST_T3() {
		return R19_NO_CON_LAST_T3;
	}

	public void setR19_NO_CON_LAST_T3(String r19_NO_CON_LAST_T3) {
		R19_NO_CON_LAST_T3 = r19_NO_CON_LAST_T3;
	}

	public String getR19_TOT_BRANCH_T3() {
		return R19_TOT_BRANCH_T3;
	}

	public void setR19_TOT_BRANCH_T3(String r19_TOT_BRANCH_T3) {
		R19_TOT_BRANCH_T3 = r19_TOT_BRANCH_T3;
	}

	public String getR19_NPL_SPD() {
		return R19_NPL_SPD;
	}

	public void setR19_NPL_SPD(String r19_NPL_SPD) {
		R19_NPL_SPD = r19_NPL_SPD;
	}

	public String getR19_RECO_NPL_SPD() {
		return R19_RECO_NPL_SPD;
	}

	public void setR19_RECO_NPL_SPD(String r19_RECO_NPL_SPD) {
		R19_RECO_NPL_SPD = r19_RECO_NPL_SPD;
	}

	public String getR19_NO_CON_ONBO_DIGI() {
		return R19_NO_CON_ONBO_DIGI;
	}

	public void setR19_NO_CON_ONBO_DIGI(String r19_NO_CON_ONBO_DIGI) {
		R19_NO_CON_ONBO_DIGI = r19_NO_CON_ONBO_DIGI;
	}

	public String getR19_NO_ACCS_AML() {
		return R19_NO_ACCS_AML;
	}

	public void setR19_NO_ACCS_AML(String r19_NO_ACCS_AML) {
		R19_NO_ACCS_AML = r19_NO_ACCS_AML;
	}

	public String getR19_TOT_ACC_LOAN_AML() {
		return R19_TOT_ACC_LOAN_AML;
	}

	public void setR19_TOT_ACC_LOAN_AML(String r19_TOT_ACC_LOAN_AML) {
		R19_TOT_ACC_LOAN_AML = r19_TOT_ACC_LOAN_AML;
	}

	public String getR19_TOT_NEW_ACCS_SPD() {
		return R19_TOT_NEW_ACCS_SPD;
	}

	public void setR19_TOT_NEW_ACCS_SPD(String r19_TOT_NEW_ACCS_SPD) {
		R19_TOT_NEW_ACCS_SPD = r19_TOT_NEW_ACCS_SPD;
	}

	public String getR19_TOT_VALS_LOANS_SPD() {
		return R19_TOT_VALS_LOANS_SPD;
	}

	public void setR19_TOT_VALS_LOANS_SPD(String r19_TOT_VALS_LOANS_SPD) {
		R19_TOT_VALS_LOANS_SPD = r19_TOT_VALS_LOANS_SPD;
	}

	public String getR19_NO_INQ_WEBMOB() {
		return R19_NO_INQ_WEBMOB;
	}

	public void setR19_NO_INQ_WEBMOB(String r19_NO_INQ_WEBMOB) {
		R19_NO_INQ_WEBMOB = r19_NO_INQ_WEBMOB;
	}

	public String getR19_NO_INQ_TRAD() {
		return R19_NO_INQ_TRAD;
	}

	public void setR19_NO_INQ_TRAD(String r19_NO_INQ_TRAD) {
		R19_NO_INQ_TRAD = r19_NO_INQ_TRAD;
	}

	public String getR19_NO_RET_POS() {
		return R19_NO_RET_POS;
	}

	public void setR19_NO_RET_POS(String r19_NO_RET_POS) {
		R19_NO_RET_POS = r19_NO_RET_POS;
	}

	public String getR19_AMT_POS_GATE() {
		return R19_AMT_POS_GATE;
	}

	public void setR19_AMT_POS_GATE(String r19_AMT_POS_GATE) {
		R19_AMT_POS_GATE = r19_AMT_POS_GATE;
	}

	public String getR19_NO_TRAN_SVF_BNK() {
		return R19_NO_TRAN_SVF_BNK;
	}

	public void setR19_NO_TRAN_SVF_BNK(String r19_NO_TRAN_SVF_BNK) {
		R19_NO_TRAN_SVF_BNK = r19_NO_TRAN_SVF_BNK;
	}

	public String getR19_AMT_RET_SVF_BNK() {
		return R19_AMT_RET_SVF_BNK;
	}

	public void setR19_AMT_RET_SVF_BNK(String r19_AMT_RET_SVF_BNK) {
		R19_AMT_RET_SVF_BNK = r19_AMT_RET_SVF_BNK;
	}

	public String getR19_TOT_WEB_MOB_VIRT() {
		return R19_TOT_WEB_MOB_VIRT;
	}

	public void setR19_TOT_WEB_MOB_VIRT(String r19_TOT_WEB_MOB_VIRT) {
		R19_TOT_WEB_MOB_VIRT = r19_TOT_WEB_MOB_VIRT;
	}

	public String getR19_VAL_UNCL_SVF() {
		return R19_VAL_UNCL_SVF;
	}

	public void setR19_VAL_UNCL_SVF(String r19_VAL_UNCL_SVF) {
		R19_VAL_UNCL_SVF = r19_VAL_UNCL_SVF;
	}

	public String getR19_NO_CON_LOW_RSK() {
		return R19_NO_CON_LOW_RSK;
	}

	public void setR19_NO_CON_LOW_RSK(String r19_NO_CON_LOW_RSK) {
		R19_NO_CON_LOW_RSK = r19_NO_CON_LOW_RSK;
	}

	public String getR19_NO_CON_HIGH_RSK() {
		return R19_NO_CON_HIGH_RSK;
	}

	public void setR19_NO_CON_HIGH_RSK(String r19_NO_CON_HIGH_RSK) {
		R19_NO_CON_HIGH_RSK = r19_NO_CON_HIGH_RSK;
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

	public String getR20_RET_ASET_LTS() {
		return R20_RET_ASET_LTS;
	}

	public void setR20_RET_ASET_LTS(String r20_RET_ASET_LTS) {
		R20_RET_ASET_LTS = r20_RET_ASET_LTS;
	}

	public String getR20_RET_ASET_LTSME() {
		return R20_RET_ASET_LTSME;
	}

	public void setR20_RET_ASET_LTSME(String r20_RET_ASET_LTSME) {
		R20_RET_ASET_LTSME = r20_RET_ASET_LTSME;
	}

	public String getR20_RET_ASET_SME_GUR() {
		return R20_RET_ASET_SME_GUR;
	}

	public void setR20_RET_ASET_SME_GUR(String r20_RET_ASET_SME_GUR) {
		R20_RET_ASET_SME_GUR = r20_RET_ASET_SME_GUR;
	}

	public String getR20_RET_LOAN_DIS() {
		return R20_RET_LOAN_DIS;
	}

	public void setR20_RET_LOAN_DIS(String r20_RET_LOAN_DIS) {
		R20_RET_LOAN_DIS = r20_RET_LOAN_DIS;
	}

	public String getR20_RET_ASET_LOAN_SME() {
		return R20_RET_ASET_LOAN_SME;
	}

	public void setR20_RET_ASET_LOAN_SME(String r20_RET_ASET_LOAN_SME) {
		R20_RET_ASET_LOAN_SME = r20_RET_ASET_LOAN_SME;
	}

	public String getR20_PER_LOAN_WEB() {
		return R20_PER_LOAN_WEB;
	}

	public void setR20_PER_LOAN_WEB(String r20_PER_LOAN_WEB) {
		R20_PER_LOAN_WEB = r20_PER_LOAN_WEB;
	}

	public String getR20_LOAN_SME_WEB_MOB() {
		return R20_LOAN_SME_WEB_MOB;
	}

	public void setR20_LOAN_SME_WEB_MOB(String r20_LOAN_SME_WEB_MOB) {
		R20_LOAN_SME_WEB_MOB = r20_LOAN_SME_WEB_MOB;
	}

	public String getR20_NO_COMPDIGI_MOB() {
		return R20_NO_COMPDIGI_MOB;
	}

	public void setR20_NO_COMPDIGI_MOB(String r20_NO_COMPDIGI_MOB) {
		R20_NO_COMPDIGI_MOB = r20_NO_COMPDIGI_MOB;
	}

	public String getR20_NO_COMP_TRADCALL() {
		return R20_NO_COMP_TRADCALL;
	}

	public void setR20_NO_COMP_TRADCALL(String r20_NO_COMP_TRADCALL) {
		R20_NO_COMP_TRADCALL = r20_NO_COMP_TRADCALL;
	}

	public String getR20_PER_COMPDIGI_WEB() {
		return R20_PER_COMPDIGI_WEB;
	}

	public void setR20_PER_COMPDIGI_WEB(String r20_PER_COMPDIGI_WEB) {
		R20_PER_COMPDIGI_WEB = r20_PER_COMPDIGI_WEB;
	}

	public String getR20_PER_COM_TRADCALL() {
		return R20_PER_COM_TRADCALL;
	}

	public void setR20_PER_COM_TRADCALL(String r20_PER_COM_TRADCALL) {
		R20_PER_COM_TRADCALL = r20_PER_COM_TRADCALL;
	}

	public String getR20_TOT_REV_PREV() {
		return R20_TOT_REV_PREV;
	}

	public void setR20_TOT_REV_PREV(String r20_TOT_REV_PREV) {
		R20_TOT_REV_PREV = r20_TOT_REV_PREV;
	}

	public String getR20_PROF_LOSS_PREV() {
		return R20_PROF_LOSS_PREV;
	}

	public void setR20_PROF_LOSS_PREV(String r20_PROF_LOSS_PREV) {
		R20_PROF_LOSS_PREV = r20_PROF_LOSS_PREV;
	}

	public String getR20_PROF_MARG_PORTFOLIO() {
		return R20_PROF_MARG_PORTFOLIO;
	}

	public void setR20_PROF_MARG_PORTFOLIO(String r20_PROF_MARG_PORTFOLIO) {
		R20_PROF_MARG_PORTFOLIO = r20_PROF_MARG_PORTFOLIO;
	}

	public String getR20_TOT_RET_ASET_PREV() {
		return R20_TOT_RET_ASET_PREV;
	}

	public void setR20_TOT_RET_ASET_PREV(String r20_TOT_RET_ASET_PREV) {
		R20_TOT_RET_ASET_PREV = r20_TOT_RET_ASET_PREV;
	}

	public String getR20_NP_LOAN_PREV() {
		return R20_NP_LOAN_PREV;
	}

	public void setR20_NP_LOAN_PREV(String r20_NP_LOAN_PREV) {
		R20_NP_LOAN_PREV = r20_NP_LOAN_PREV;
	}

	public String getR20_NON_CON_ONLAST_PREV() {
		return R20_NON_CON_ONLAST_PREV;
	}

	public void setR20_NON_CON_ONLAST_PREV(String r20_NON_CON_ONLAST_PREV) {
		R20_NON_CON_ONLAST_PREV = r20_NON_CON_ONLAST_PREV;
	}

	public String getR20_TOT_BRAN_PREV() {
		return R20_TOT_BRAN_PREV;
	}

	public void setR20_TOT_BRAN_PREV(String r20_TOT_BRAN_PREV) {
		R20_TOT_BRAN_PREV = r20_TOT_BRAN_PREV;
	}

	public String getR20_TOT_REV_RET_CUR() {
		return R20_TOT_REV_RET_CUR;
	}

	public void setR20_TOT_REV_RET_CUR(String r20_TOT_REV_RET_CUR) {
		R20_TOT_REV_RET_CUR = r20_TOT_REV_RET_CUR;
	}

	public String getR20_PROF_LOS_PORT_CUR() {
		return R20_PROF_LOS_PORT_CUR;
	}

	public void setR20_PROF_LOS_PORT_CUR(String r20_PROF_LOS_PORT_CUR) {
		R20_PROF_LOS_PORT_CUR = r20_PROF_LOS_PORT_CUR;
	}

	public String getR20_PROF_MARG_PERC_CUR() {
		return R20_PROF_MARG_PERC_CUR;
	}

	public void setR20_PROF_MARG_PERC_CUR(String r20_PROF_MARG_PERC_CUR) {
		R20_PROF_MARG_PERC_CUR = r20_PROF_MARG_PERC_CUR;
	}

	public String getR20_TOT_RET_ASET_CUR() {
		return R20_TOT_RET_ASET_CUR;
	}

	public void setR20_TOT_RET_ASET_CUR(String r20_TOT_RET_ASET_CUR) {
		R20_TOT_RET_ASET_CUR = r20_TOT_RET_ASET_CUR;
	}

	public String getR20_NON_PER_RET_PORT_CUR() {
		return R20_NON_PER_RET_PORT_CUR;
	}

	public void setR20_NON_PER_RET_PORT_CUR(String r20_NON_PER_RET_PORT_CUR) {
		R20_NON_PER_RET_PORT_CUR = r20_NON_PER_RET_PORT_CUR;
	}

	public String getR20_NO_CON_LAST_CUR() {
		return R20_NO_CON_LAST_CUR;
	}

	public void setR20_NO_CON_LAST_CUR(String r20_NO_CON_LAST_CUR) {
		R20_NO_CON_LAST_CUR = r20_NO_CON_LAST_CUR;
	}

	public String getR20_TOT_BRANCH_CUR() {
		return R20_TOT_BRANCH_CUR;
	}

	public void setR20_TOT_BRANCH_CUR(String r20_TOT_BRANCH_CUR) {
		R20_TOT_BRANCH_CUR = r20_TOT_BRANCH_CUR;
	}

	public String getR20_TOT_REV_T1() {
		return R20_TOT_REV_T1;
	}

	public void setR20_TOT_REV_T1(String r20_TOT_REV_T1) {
		R20_TOT_REV_T1 = r20_TOT_REV_T1;
	}

	public String getR20_PROF_LOS_T1() {
		return R20_PROF_LOS_T1;
	}

	public void setR20_PROF_LOS_T1(String r20_PROF_LOS_T1) {
		R20_PROF_LOS_T1 = r20_PROF_LOS_T1;
	}

	public String getR20_PROF_MARG_T1() {
		return R20_PROF_MARG_T1;
	}

	public void setR20_PROF_MARG_T1(String r20_PROF_MARG_T1) {
		R20_PROF_MARG_T1 = r20_PROF_MARG_T1;
	}

	public String getR20_TOT_RET_ASET_T1() {
		return R20_TOT_RET_ASET_T1;
	}

	public void setR20_TOT_RET_ASET_T1(String r20_TOT_RET_ASET_T1) {
		R20_TOT_RET_ASET_T1 = r20_TOT_RET_ASET_T1;
	}

	public String getR20_NON_PERF_PORT_T1() {
		return R20_NON_PERF_PORT_T1;
	}

	public void setR20_NON_PERF_PORT_T1(String r20_NON_PERF_PORT_T1) {
		R20_NON_PERF_PORT_T1 = r20_NON_PERF_PORT_T1;
	}

	public String getR20_NO_CON_LAST_T1() {
		return R20_NO_CON_LAST_T1;
	}

	public void setR20_NO_CON_LAST_T1(String r20_NO_CON_LAST_T1) {
		R20_NO_CON_LAST_T1 = r20_NO_CON_LAST_T1;
	}

	public String getR20_TOT_BRANCH_T1() {
		return R20_TOT_BRANCH_T1;
	}

	public void setR20_TOT_BRANCH_T1(String r20_TOT_BRANCH_T1) {
		R20_TOT_BRANCH_T1 = r20_TOT_BRANCH_T1;
	}

	public String getR20_TOT_REV_T2() {
		return R20_TOT_REV_T2;
	}

	public void setR20_TOT_REV_T2(String r20_TOT_REV_T2) {
		R20_TOT_REV_T2 = r20_TOT_REV_T2;
	}

	public String getR20_PROF_LOS_T2() {
		return R20_PROF_LOS_T2;
	}

	public void setR20_PROF_LOS_T2(String r20_PROF_LOS_T2) {
		R20_PROF_LOS_T2 = r20_PROF_LOS_T2;
	}

	public String getR20_PROF_MARG_T2() {
		return R20_PROF_MARG_T2;
	}

	public void setR20_PROF_MARG_T2(String r20_PROF_MARG_T2) {
		R20_PROF_MARG_T2 = r20_PROF_MARG_T2;
	}

	public String getR20_TOT_RET_ASET_T2() {
		return R20_TOT_RET_ASET_T2;
	}

	public void setR20_TOT_RET_ASET_T2(String r20_TOT_RET_ASET_T2) {
		R20_TOT_RET_ASET_T2 = r20_TOT_RET_ASET_T2;
	}

	public String getR20_NON_PERF_PORT_T2() {
		return R20_NON_PERF_PORT_T2;
	}

	public void setR20_NON_PERF_PORT_T2(String r20_NON_PERF_PORT_T2) {
		R20_NON_PERF_PORT_T2 = r20_NON_PERF_PORT_T2;
	}

	public String getR20_NO_CON_LAST_T2() {
		return R20_NO_CON_LAST_T2;
	}

	public void setR20_NO_CON_LAST_T2(String r20_NO_CON_LAST_T2) {
		R20_NO_CON_LAST_T2 = r20_NO_CON_LAST_T2;
	}

	public String getR20_TOT_BRANCH_T2() {
		return R20_TOT_BRANCH_T2;
	}

	public void setR20_TOT_BRANCH_T2(String r20_TOT_BRANCH_T2) {
		R20_TOT_BRANCH_T2 = r20_TOT_BRANCH_T2;
	}

	public String getR20_TOT_REV_T3() {
		return R20_TOT_REV_T3;
	}

	public void setR20_TOT_REV_T3(String r20_TOT_REV_T3) {
		R20_TOT_REV_T3 = r20_TOT_REV_T3;
	}

	public String getR20_PROF_LOS_T3() {
		return R20_PROF_LOS_T3;
	}

	public void setR20_PROF_LOS_T3(String r20_PROF_LOS_T3) {
		R20_PROF_LOS_T3 = r20_PROF_LOS_T3;
	}

	public String getR20_PROF_MARG_T3() {
		return R20_PROF_MARG_T3;
	}

	public void setR20_PROF_MARG_T3(String r20_PROF_MARG_T3) {
		R20_PROF_MARG_T3 = r20_PROF_MARG_T3;
	}

	public String getR20_TOT_RET_ASET_T3() {
		return R20_TOT_RET_ASET_T3;
	}

	public void setR20_TOT_RET_ASET_T3(String r20_TOT_RET_ASET_T3) {
		R20_TOT_RET_ASET_T3 = r20_TOT_RET_ASET_T3;
	}

	public String getR20_NON_PERF_PORT_T3() {
		return R20_NON_PERF_PORT_T3;
	}

	public void setR20_NON_PERF_PORT_T3(String r20_NON_PERF_PORT_T3) {
		R20_NON_PERF_PORT_T3 = r20_NON_PERF_PORT_T3;
	}

	public String getR20_NO_CON_LAST_T3() {
		return R20_NO_CON_LAST_T3;
	}

	public void setR20_NO_CON_LAST_T3(String r20_NO_CON_LAST_T3) {
		R20_NO_CON_LAST_T3 = r20_NO_CON_LAST_T3;
	}

	public String getR20_TOT_BRANCH_T3() {
		return R20_TOT_BRANCH_T3;
	}

	public void setR20_TOT_BRANCH_T3(String r20_TOT_BRANCH_T3) {
		R20_TOT_BRANCH_T3 = r20_TOT_BRANCH_T3;
	}

	public String getR20_NPL_SPD() {
		return R20_NPL_SPD;
	}

	public void setR20_NPL_SPD(String r20_NPL_SPD) {
		R20_NPL_SPD = r20_NPL_SPD;
	}

	public String getR20_RECO_NPL_SPD() {
		return R20_RECO_NPL_SPD;
	}

	public void setR20_RECO_NPL_SPD(String r20_RECO_NPL_SPD) {
		R20_RECO_NPL_SPD = r20_RECO_NPL_SPD;
	}

	public String getR20_NO_CON_ONBO_DIGI() {
		return R20_NO_CON_ONBO_DIGI;
	}

	public void setR20_NO_CON_ONBO_DIGI(String r20_NO_CON_ONBO_DIGI) {
		R20_NO_CON_ONBO_DIGI = r20_NO_CON_ONBO_DIGI;
	}

	public String getR20_NO_ACCS_AML() {
		return R20_NO_ACCS_AML;
	}

	public void setR20_NO_ACCS_AML(String r20_NO_ACCS_AML) {
		R20_NO_ACCS_AML = r20_NO_ACCS_AML;
	}

	public String getR20_TOT_ACC_LOAN_AML() {
		return R20_TOT_ACC_LOAN_AML;
	}

	public void setR20_TOT_ACC_LOAN_AML(String r20_TOT_ACC_LOAN_AML) {
		R20_TOT_ACC_LOAN_AML = r20_TOT_ACC_LOAN_AML;
	}

	public String getR20_TOT_NEW_ACCS_SPD() {
		return R20_TOT_NEW_ACCS_SPD;
	}

	public void setR20_TOT_NEW_ACCS_SPD(String r20_TOT_NEW_ACCS_SPD) {
		R20_TOT_NEW_ACCS_SPD = r20_TOT_NEW_ACCS_SPD;
	}

	public String getR20_TOT_VALS_LOANS_SPD() {
		return R20_TOT_VALS_LOANS_SPD;
	}

	public void setR20_TOT_VALS_LOANS_SPD(String r20_TOT_VALS_LOANS_SPD) {
		R20_TOT_VALS_LOANS_SPD = r20_TOT_VALS_LOANS_SPD;
	}

	public String getR20_NO_INQ_WEBMOB() {
		return R20_NO_INQ_WEBMOB;
	}

	public void setR20_NO_INQ_WEBMOB(String r20_NO_INQ_WEBMOB) {
		R20_NO_INQ_WEBMOB = r20_NO_INQ_WEBMOB;
	}

	public String getR20_NO_INQ_TRAD() {
		return R20_NO_INQ_TRAD;
	}

	public void setR20_NO_INQ_TRAD(String r20_NO_INQ_TRAD) {
		R20_NO_INQ_TRAD = r20_NO_INQ_TRAD;
	}

	public String getR20_NO_RET_POS() {
		return R20_NO_RET_POS;
	}

	public void setR20_NO_RET_POS(String r20_NO_RET_POS) {
		R20_NO_RET_POS = r20_NO_RET_POS;
	}

	public String getR20_AMT_POS_GATE() {
		return R20_AMT_POS_GATE;
	}

	public void setR20_AMT_POS_GATE(String r20_AMT_POS_GATE) {
		R20_AMT_POS_GATE = r20_AMT_POS_GATE;
	}

	public String getR20_NO_TRAN_SVF_BNK() {
		return R20_NO_TRAN_SVF_BNK;
	}

	public void setR20_NO_TRAN_SVF_BNK(String r20_NO_TRAN_SVF_BNK) {
		R20_NO_TRAN_SVF_BNK = r20_NO_TRAN_SVF_BNK;
	}

	public String getR20_AMT_RET_SVF_BNK() {
		return R20_AMT_RET_SVF_BNK;
	}

	public void setR20_AMT_RET_SVF_BNK(String r20_AMT_RET_SVF_BNK) {
		R20_AMT_RET_SVF_BNK = r20_AMT_RET_SVF_BNK;
	}

	public String getR20_TOT_WEB_MOB_VIRT() {
		return R20_TOT_WEB_MOB_VIRT;
	}

	public void setR20_TOT_WEB_MOB_VIRT(String r20_TOT_WEB_MOB_VIRT) {
		R20_TOT_WEB_MOB_VIRT = r20_TOT_WEB_MOB_VIRT;
	}

	public String getR20_VAL_UNCL_SVF() {
		return R20_VAL_UNCL_SVF;
	}

	public void setR20_VAL_UNCL_SVF(String r20_VAL_UNCL_SVF) {
		R20_VAL_UNCL_SVF = r20_VAL_UNCL_SVF;
	}

	public String getR20_NO_CON_LOW_RSK() {
		return R20_NO_CON_LOW_RSK;
	}

	public void setR20_NO_CON_LOW_RSK(String r20_NO_CON_LOW_RSK) {
		R20_NO_CON_LOW_RSK = r20_NO_CON_LOW_RSK;
	}

	public String getR20_NO_CON_HIGH_RSK() {
		return R20_NO_CON_HIGH_RSK;
	}

	public void setR20_NO_CON_HIGH_RSK(String r20_NO_CON_HIGH_RSK) {
		R20_NO_CON_HIGH_RSK = r20_NO_CON_HIGH_RSK;
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

	public String getR21_RET_ASET_LTS() {
		return R21_RET_ASET_LTS;
	}

	public void setR21_RET_ASET_LTS(String r21_RET_ASET_LTS) {
		R21_RET_ASET_LTS = r21_RET_ASET_LTS;
	}

	public String getR21_RET_ASET_LTSME() {
		return R21_RET_ASET_LTSME;
	}

	public void setR21_RET_ASET_LTSME(String r21_RET_ASET_LTSME) {
		R21_RET_ASET_LTSME = r21_RET_ASET_LTSME;
	}

	public String getR21_RET_ASET_SME_GUR() {
		return R21_RET_ASET_SME_GUR;
	}

	public void setR21_RET_ASET_SME_GUR(String r21_RET_ASET_SME_GUR) {
		R21_RET_ASET_SME_GUR = r21_RET_ASET_SME_GUR;
	}

	public String getR21_RET_LOAN_DIS() {
		return R21_RET_LOAN_DIS;
	}

	public void setR21_RET_LOAN_DIS(String r21_RET_LOAN_DIS) {
		R21_RET_LOAN_DIS = r21_RET_LOAN_DIS;
	}

	public String getR21_RET_ASET_LOAN_SME() {
		return R21_RET_ASET_LOAN_SME;
	}

	public void setR21_RET_ASET_LOAN_SME(String r21_RET_ASET_LOAN_SME) {
		R21_RET_ASET_LOAN_SME = r21_RET_ASET_LOAN_SME;
	}

	public String getR21_PER_LOAN_WEB() {
		return R21_PER_LOAN_WEB;
	}

	public void setR21_PER_LOAN_WEB(String r21_PER_LOAN_WEB) {
		R21_PER_LOAN_WEB = r21_PER_LOAN_WEB;
	}

	public String getR21_LOAN_SME_WEB_MOB() {
		return R21_LOAN_SME_WEB_MOB;
	}

	public void setR21_LOAN_SME_WEB_MOB(String r21_LOAN_SME_WEB_MOB) {
		R21_LOAN_SME_WEB_MOB = r21_LOAN_SME_WEB_MOB;
	}

	public String getR21_NO_COMPDIGI_MOB() {
		return R21_NO_COMPDIGI_MOB;
	}

	public void setR21_NO_COMPDIGI_MOB(String r21_NO_COMPDIGI_MOB) {
		R21_NO_COMPDIGI_MOB = r21_NO_COMPDIGI_MOB;
	}

	public String getR21_NO_COMP_TRADCALL() {
		return R21_NO_COMP_TRADCALL;
	}

	public void setR21_NO_COMP_TRADCALL(String r21_NO_COMP_TRADCALL) {
		R21_NO_COMP_TRADCALL = r21_NO_COMP_TRADCALL;
	}

	public String getR21_PER_COMPDIGI_WEB() {
		return R21_PER_COMPDIGI_WEB;
	}

	public void setR21_PER_COMPDIGI_WEB(String r21_PER_COMPDIGI_WEB) {
		R21_PER_COMPDIGI_WEB = r21_PER_COMPDIGI_WEB;
	}

	public String getR21_PER_COM_TRADCALL() {
		return R21_PER_COM_TRADCALL;
	}

	public void setR21_PER_COM_TRADCALL(String r21_PER_COM_TRADCALL) {
		R21_PER_COM_TRADCALL = r21_PER_COM_TRADCALL;
	}

	public String getR21_TOT_REV_PREV() {
		return R21_TOT_REV_PREV;
	}

	public void setR21_TOT_REV_PREV(String r21_TOT_REV_PREV) {
		R21_TOT_REV_PREV = r21_TOT_REV_PREV;
	}

	public String getR21_PROF_LOSS_PREV() {
		return R21_PROF_LOSS_PREV;
	}

	public void setR21_PROF_LOSS_PREV(String r21_PROF_LOSS_PREV) {
		R21_PROF_LOSS_PREV = r21_PROF_LOSS_PREV;
	}

	public String getR21_PROF_MARG_PORTFOLIO() {
		return R21_PROF_MARG_PORTFOLIO;
	}

	public void setR21_PROF_MARG_PORTFOLIO(String r21_PROF_MARG_PORTFOLIO) {
		R21_PROF_MARG_PORTFOLIO = r21_PROF_MARG_PORTFOLIO;
	}

	public String getR21_TOT_RET_ASET_PREV() {
		return R21_TOT_RET_ASET_PREV;
	}

	public void setR21_TOT_RET_ASET_PREV(String r21_TOT_RET_ASET_PREV) {
		R21_TOT_RET_ASET_PREV = r21_TOT_RET_ASET_PREV;
	}

	public String getR21_NP_LOAN_PREV() {
		return R21_NP_LOAN_PREV;
	}

	public void setR21_NP_LOAN_PREV(String r21_NP_LOAN_PREV) {
		R21_NP_LOAN_PREV = r21_NP_LOAN_PREV;
	}

	public String getR21_NON_CON_ONLAST_PREV() {
		return R21_NON_CON_ONLAST_PREV;
	}

	public void setR21_NON_CON_ONLAST_PREV(String r21_NON_CON_ONLAST_PREV) {
		R21_NON_CON_ONLAST_PREV = r21_NON_CON_ONLAST_PREV;
	}

	public String getR21_TOT_BRAN_PREV() {
		return R21_TOT_BRAN_PREV;
	}

	public void setR21_TOT_BRAN_PREV(String r21_TOT_BRAN_PREV) {
		R21_TOT_BRAN_PREV = r21_TOT_BRAN_PREV;
	}

	public String getR21_TOT_REV_RET_CUR() {
		return R21_TOT_REV_RET_CUR;
	}

	public void setR21_TOT_REV_RET_CUR(String r21_TOT_REV_RET_CUR) {
		R21_TOT_REV_RET_CUR = r21_TOT_REV_RET_CUR;
	}

	public String getR21_PROF_LOS_PORT_CUR() {
		return R21_PROF_LOS_PORT_CUR;
	}

	public void setR21_PROF_LOS_PORT_CUR(String r21_PROF_LOS_PORT_CUR) {
		R21_PROF_LOS_PORT_CUR = r21_PROF_LOS_PORT_CUR;
	}

	public String getR21_PROF_MARG_PERC_CUR() {
		return R21_PROF_MARG_PERC_CUR;
	}

	public void setR21_PROF_MARG_PERC_CUR(String r21_PROF_MARG_PERC_CUR) {
		R21_PROF_MARG_PERC_CUR = r21_PROF_MARG_PERC_CUR;
	}

	public String getR21_TOT_RET_ASET_CUR() {
		return R21_TOT_RET_ASET_CUR;
	}

	public void setR21_TOT_RET_ASET_CUR(String r21_TOT_RET_ASET_CUR) {
		R21_TOT_RET_ASET_CUR = r21_TOT_RET_ASET_CUR;
	}

	public String getR21_NON_PER_RET_PORT_CUR() {
		return R21_NON_PER_RET_PORT_CUR;
	}

	public void setR21_NON_PER_RET_PORT_CUR(String r21_NON_PER_RET_PORT_CUR) {
		R21_NON_PER_RET_PORT_CUR = r21_NON_PER_RET_PORT_CUR;
	}

	public String getR21_NO_CON_LAST_CUR() {
		return R21_NO_CON_LAST_CUR;
	}

	public void setR21_NO_CON_LAST_CUR(String r21_NO_CON_LAST_CUR) {
		R21_NO_CON_LAST_CUR = r21_NO_CON_LAST_CUR;
	}

	public String getR21_TOT_BRANCH_CUR() {
		return R21_TOT_BRANCH_CUR;
	}

	public void setR21_TOT_BRANCH_CUR(String r21_TOT_BRANCH_CUR) {
		R21_TOT_BRANCH_CUR = r21_TOT_BRANCH_CUR;
	}

	public String getR21_TOT_REV_T1() {
		return R21_TOT_REV_T1;
	}

	public void setR21_TOT_REV_T1(String r21_TOT_REV_T1) {
		R21_TOT_REV_T1 = r21_TOT_REV_T1;
	}

	public String getR21_PROF_LOS_T1() {
		return R21_PROF_LOS_T1;
	}

	public void setR21_PROF_LOS_T1(String r21_PROF_LOS_T1) {
		R21_PROF_LOS_T1 = r21_PROF_LOS_T1;
	}

	public String getR21_PROF_MARG_T1() {
		return R21_PROF_MARG_T1;
	}

	public void setR21_PROF_MARG_T1(String r21_PROF_MARG_T1) {
		R21_PROF_MARG_T1 = r21_PROF_MARG_T1;
	}

	public String getR21_TOT_RET_ASET_T1() {
		return R21_TOT_RET_ASET_T1;
	}

	public void setR21_TOT_RET_ASET_T1(String r21_TOT_RET_ASET_T1) {
		R21_TOT_RET_ASET_T1 = r21_TOT_RET_ASET_T1;
	}

	public String getR21_NON_PERF_PORT_T1() {
		return R21_NON_PERF_PORT_T1;
	}

	public void setR21_NON_PERF_PORT_T1(String r21_NON_PERF_PORT_T1) {
		R21_NON_PERF_PORT_T1 = r21_NON_PERF_PORT_T1;
	}

	public String getR21_NO_CON_LAST_T1() {
		return R21_NO_CON_LAST_T1;
	}

	public void setR21_NO_CON_LAST_T1(String r21_NO_CON_LAST_T1) {
		R21_NO_CON_LAST_T1 = r21_NO_CON_LAST_T1;
	}

	public String getR21_TOT_BRANCH_T1() {
		return R21_TOT_BRANCH_T1;
	}

	public void setR21_TOT_BRANCH_T1(String r21_TOT_BRANCH_T1) {
		R21_TOT_BRANCH_T1 = r21_TOT_BRANCH_T1;
	}

	public String getR21_TOT_REV_T2() {
		return R21_TOT_REV_T2;
	}

	public void setR21_TOT_REV_T2(String r21_TOT_REV_T2) {
		R21_TOT_REV_T2 = r21_TOT_REV_T2;
	}

	public String getR21_PROF_LOS_T2() {
		return R21_PROF_LOS_T2;
	}

	public void setR21_PROF_LOS_T2(String r21_PROF_LOS_T2) {
		R21_PROF_LOS_T2 = r21_PROF_LOS_T2;
	}

	public String getR21_PROF_MARG_T2() {
		return R21_PROF_MARG_T2;
	}

	public void setR21_PROF_MARG_T2(String r21_PROF_MARG_T2) {
		R21_PROF_MARG_T2 = r21_PROF_MARG_T2;
	}

	public String getR21_TOT_RET_ASET_T2() {
		return R21_TOT_RET_ASET_T2;
	}

	public void setR21_TOT_RET_ASET_T2(String r21_TOT_RET_ASET_T2) {
		R21_TOT_RET_ASET_T2 = r21_TOT_RET_ASET_T2;
	}

	public String getR21_NON_PERF_PORT_T2() {
		return R21_NON_PERF_PORT_T2;
	}

	public void setR21_NON_PERF_PORT_T2(String r21_NON_PERF_PORT_T2) {
		R21_NON_PERF_PORT_T2 = r21_NON_PERF_PORT_T2;
	}

	public String getR21_NO_CON_LAST_T2() {
		return R21_NO_CON_LAST_T2;
	}

	public void setR21_NO_CON_LAST_T2(String r21_NO_CON_LAST_T2) {
		R21_NO_CON_LAST_T2 = r21_NO_CON_LAST_T2;
	}

	public String getR21_TOT_BRANCH_T2() {
		return R21_TOT_BRANCH_T2;
	}

	public void setR21_TOT_BRANCH_T2(String r21_TOT_BRANCH_T2) {
		R21_TOT_BRANCH_T2 = r21_TOT_BRANCH_T2;
	}

	public String getR21_TOT_REV_T3() {
		return R21_TOT_REV_T3;
	}

	public void setR21_TOT_REV_T3(String r21_TOT_REV_T3) {
		R21_TOT_REV_T3 = r21_TOT_REV_T3;
	}

	public String getR21_PROF_LOS_T3() {
		return R21_PROF_LOS_T3;
	}

	public void setR21_PROF_LOS_T3(String r21_PROF_LOS_T3) {
		R21_PROF_LOS_T3 = r21_PROF_LOS_T3;
	}

	public String getR21_PROF_MARG_T3() {
		return R21_PROF_MARG_T3;
	}

	public void setR21_PROF_MARG_T3(String r21_PROF_MARG_T3) {
		R21_PROF_MARG_T3 = r21_PROF_MARG_T3;
	}

	public String getR21_TOT_RET_ASET_T3() {
		return R21_TOT_RET_ASET_T3;
	}

	public void setR21_TOT_RET_ASET_T3(String r21_TOT_RET_ASET_T3) {
		R21_TOT_RET_ASET_T3 = r21_TOT_RET_ASET_T3;
	}

	public String getR21_NON_PERF_PORT_T3() {
		return R21_NON_PERF_PORT_T3;
	}

	public void setR21_NON_PERF_PORT_T3(String r21_NON_PERF_PORT_T3) {
		R21_NON_PERF_PORT_T3 = r21_NON_PERF_PORT_T3;
	}

	public String getR21_NO_CON_LAST_T3() {
		return R21_NO_CON_LAST_T3;
	}

	public void setR21_NO_CON_LAST_T3(String r21_NO_CON_LAST_T3) {
		R21_NO_CON_LAST_T3 = r21_NO_CON_LAST_T3;
	}

	public String getR21_TOT_BRANCH_T3() {
		return R21_TOT_BRANCH_T3;
	}

	public void setR21_TOT_BRANCH_T3(String r21_TOT_BRANCH_T3) {
		R21_TOT_BRANCH_T3 = r21_TOT_BRANCH_T3;
	}

	public String getR21_NPL_SPD() {
		return R21_NPL_SPD;
	}

	public void setR21_NPL_SPD(String r21_NPL_SPD) {
		R21_NPL_SPD = r21_NPL_SPD;
	}

	public String getR21_RECO_NPL_SPD() {
		return R21_RECO_NPL_SPD;
	}

	public void setR21_RECO_NPL_SPD(String r21_RECO_NPL_SPD) {
		R21_RECO_NPL_SPD = r21_RECO_NPL_SPD;
	}

	public String getR21_NO_CON_ONBO_DIGI() {
		return R21_NO_CON_ONBO_DIGI;
	}

	public void setR21_NO_CON_ONBO_DIGI(String r21_NO_CON_ONBO_DIGI) {
		R21_NO_CON_ONBO_DIGI = r21_NO_CON_ONBO_DIGI;
	}

	public String getR21_NO_ACCS_AML() {
		return R21_NO_ACCS_AML;
	}

	public void setR21_NO_ACCS_AML(String r21_NO_ACCS_AML) {
		R21_NO_ACCS_AML = r21_NO_ACCS_AML;
	}

	public String getR21_TOT_ACC_LOAN_AML() {
		return R21_TOT_ACC_LOAN_AML;
	}

	public void setR21_TOT_ACC_LOAN_AML(String r21_TOT_ACC_LOAN_AML) {
		R21_TOT_ACC_LOAN_AML = r21_TOT_ACC_LOAN_AML;
	}

	public String getR21_TOT_NEW_ACCS_SPD() {
		return R21_TOT_NEW_ACCS_SPD;
	}

	public void setR21_TOT_NEW_ACCS_SPD(String r21_TOT_NEW_ACCS_SPD) {
		R21_TOT_NEW_ACCS_SPD = r21_TOT_NEW_ACCS_SPD;
	}

	public String getR21_TOT_VALS_LOANS_SPD() {
		return R21_TOT_VALS_LOANS_SPD;
	}

	public void setR21_TOT_VALS_LOANS_SPD(String r21_TOT_VALS_LOANS_SPD) {
		R21_TOT_VALS_LOANS_SPD = r21_TOT_VALS_LOANS_SPD;
	}

	public String getR21_NO_INQ_WEBMOB() {
		return R21_NO_INQ_WEBMOB;
	}

	public void setR21_NO_INQ_WEBMOB(String r21_NO_INQ_WEBMOB) {
		R21_NO_INQ_WEBMOB = r21_NO_INQ_WEBMOB;
	}

	public String getR21_NO_INQ_TRAD() {
		return R21_NO_INQ_TRAD;
	}

	public void setR21_NO_INQ_TRAD(String r21_NO_INQ_TRAD) {
		R21_NO_INQ_TRAD = r21_NO_INQ_TRAD;
	}

	public String getR21_NO_RET_POS() {
		return R21_NO_RET_POS;
	}

	public void setR21_NO_RET_POS(String r21_NO_RET_POS) {
		R21_NO_RET_POS = r21_NO_RET_POS;
	}

	public String getR21_AMT_POS_GATE() {
		return R21_AMT_POS_GATE;
	}

	public void setR21_AMT_POS_GATE(String r21_AMT_POS_GATE) {
		R21_AMT_POS_GATE = r21_AMT_POS_GATE;
	}

	public String getR21_NO_TRAN_SVF_BNK() {
		return R21_NO_TRAN_SVF_BNK;
	}

	public void setR21_NO_TRAN_SVF_BNK(String r21_NO_TRAN_SVF_BNK) {
		R21_NO_TRAN_SVF_BNK = r21_NO_TRAN_SVF_BNK;
	}

	public String getR21_AMT_RET_SVF_BNK() {
		return R21_AMT_RET_SVF_BNK;
	}

	public void setR21_AMT_RET_SVF_BNK(String r21_AMT_RET_SVF_BNK) {
		R21_AMT_RET_SVF_BNK = r21_AMT_RET_SVF_BNK;
	}

	public String getR21_TOT_WEB_MOB_VIRT() {
		return R21_TOT_WEB_MOB_VIRT;
	}

	public void setR21_TOT_WEB_MOB_VIRT(String r21_TOT_WEB_MOB_VIRT) {
		R21_TOT_WEB_MOB_VIRT = r21_TOT_WEB_MOB_VIRT;
	}

	public String getR21_VAL_UNCL_SVF() {
		return R21_VAL_UNCL_SVF;
	}

	public void setR21_VAL_UNCL_SVF(String r21_VAL_UNCL_SVF) {
		R21_VAL_UNCL_SVF = r21_VAL_UNCL_SVF;
	}

	public String getR21_NO_CON_LOW_RSK() {
		return R21_NO_CON_LOW_RSK;
	}

	public void setR21_NO_CON_LOW_RSK(String r21_NO_CON_LOW_RSK) {
		R21_NO_CON_LOW_RSK = r21_NO_CON_LOW_RSK;
	}

	public String getR21_NO_CON_HIGH_RSK() {
		return R21_NO_CON_HIGH_RSK;
	}

	public void setR21_NO_CON_HIGH_RSK(String r21_NO_CON_HIGH_RSK) {
		R21_NO_CON_HIGH_RSK = r21_NO_CON_HIGH_RSK;
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

	public String getR22_RET_ASET_LTS() {
		return R22_RET_ASET_LTS;
	}

	public void setR22_RET_ASET_LTS(String r22_RET_ASET_LTS) {
		R22_RET_ASET_LTS = r22_RET_ASET_LTS;
	}

	public String getR22_RET_ASET_LTSME() {
		return R22_RET_ASET_LTSME;
	}

	public void setR22_RET_ASET_LTSME(String r22_RET_ASET_LTSME) {
		R22_RET_ASET_LTSME = r22_RET_ASET_LTSME;
	}

	public String getR22_RET_ASET_SME_GUR() {
		return R22_RET_ASET_SME_GUR;
	}

	public void setR22_RET_ASET_SME_GUR(String r22_RET_ASET_SME_GUR) {
		R22_RET_ASET_SME_GUR = r22_RET_ASET_SME_GUR;
	}

	public String getR22_RET_LOAN_DIS() {
		return R22_RET_LOAN_DIS;
	}

	public void setR22_RET_LOAN_DIS(String r22_RET_LOAN_DIS) {
		R22_RET_LOAN_DIS = r22_RET_LOAN_DIS;
	}

	public String getR22_RET_ASET_LOAN_SME() {
		return R22_RET_ASET_LOAN_SME;
	}

	public void setR22_RET_ASET_LOAN_SME(String r22_RET_ASET_LOAN_SME) {
		R22_RET_ASET_LOAN_SME = r22_RET_ASET_LOAN_SME;
	}

	public String getR22_PER_LOAN_WEB() {
		return R22_PER_LOAN_WEB;
	}

	public void setR22_PER_LOAN_WEB(String r22_PER_LOAN_WEB) {
		R22_PER_LOAN_WEB = r22_PER_LOAN_WEB;
	}

	public String getR22_LOAN_SME_WEB_MOB() {
		return R22_LOAN_SME_WEB_MOB;
	}

	public void setR22_LOAN_SME_WEB_MOB(String r22_LOAN_SME_WEB_MOB) {
		R22_LOAN_SME_WEB_MOB = r22_LOAN_SME_WEB_MOB;
	}

	public String getR22_NO_COMPDIGI_MOB() {
		return R22_NO_COMPDIGI_MOB;
	}

	public void setR22_NO_COMPDIGI_MOB(String r22_NO_COMPDIGI_MOB) {
		R22_NO_COMPDIGI_MOB = r22_NO_COMPDIGI_MOB;
	}

	public String getR22_NO_COMP_TRADCALL() {
		return R22_NO_COMP_TRADCALL;
	}

	public void setR22_NO_COMP_TRADCALL(String r22_NO_COMP_TRADCALL) {
		R22_NO_COMP_TRADCALL = r22_NO_COMP_TRADCALL;
	}

	public String getR22_PER_COMPDIGI_WEB() {
		return R22_PER_COMPDIGI_WEB;
	}

	public void setR22_PER_COMPDIGI_WEB(String r22_PER_COMPDIGI_WEB) {
		R22_PER_COMPDIGI_WEB = r22_PER_COMPDIGI_WEB;
	}

	public String getR22_PER_COM_TRADCALL() {
		return R22_PER_COM_TRADCALL;
	}

	public void setR22_PER_COM_TRADCALL(String r22_PER_COM_TRADCALL) {
		R22_PER_COM_TRADCALL = r22_PER_COM_TRADCALL;
	}

	public String getR22_TOT_REV_PREV() {
		return R22_TOT_REV_PREV;
	}

	public void setR22_TOT_REV_PREV(String r22_TOT_REV_PREV) {
		R22_TOT_REV_PREV = r22_TOT_REV_PREV;
	}

	public String getR22_PROF_LOSS_PREV() {
		return R22_PROF_LOSS_PREV;
	}

	public void setR22_PROF_LOSS_PREV(String r22_PROF_LOSS_PREV) {
		R22_PROF_LOSS_PREV = r22_PROF_LOSS_PREV;
	}

	public String getR22_PROF_MARG_PORTFOLIO() {
		return R22_PROF_MARG_PORTFOLIO;
	}

	public void setR22_PROF_MARG_PORTFOLIO(String r22_PROF_MARG_PORTFOLIO) {
		R22_PROF_MARG_PORTFOLIO = r22_PROF_MARG_PORTFOLIO;
	}

	public String getR22_TOT_RET_ASET_PREV() {
		return R22_TOT_RET_ASET_PREV;
	}

	public void setR22_TOT_RET_ASET_PREV(String r22_TOT_RET_ASET_PREV) {
		R22_TOT_RET_ASET_PREV = r22_TOT_RET_ASET_PREV;
	}

	public String getR22_NP_LOAN_PREV() {
		return R22_NP_LOAN_PREV;
	}

	public void setR22_NP_LOAN_PREV(String r22_NP_LOAN_PREV) {
		R22_NP_LOAN_PREV = r22_NP_LOAN_PREV;
	}

	public String getR22_NON_CON_ONLAST_PREV() {
		return R22_NON_CON_ONLAST_PREV;
	}

	public void setR22_NON_CON_ONLAST_PREV(String r22_NON_CON_ONLAST_PREV) {
		R22_NON_CON_ONLAST_PREV = r22_NON_CON_ONLAST_PREV;
	}

	public String getR22_TOT_BRAN_PREV() {
		return R22_TOT_BRAN_PREV;
	}

	public void setR22_TOT_BRAN_PREV(String r22_TOT_BRAN_PREV) {
		R22_TOT_BRAN_PREV = r22_TOT_BRAN_PREV;
	}

	public String getR22_TOT_REV_RET_CUR() {
		return R22_TOT_REV_RET_CUR;
	}

	public void setR22_TOT_REV_RET_CUR(String r22_TOT_REV_RET_CUR) {
		R22_TOT_REV_RET_CUR = r22_TOT_REV_RET_CUR;
	}

	public String getR22_PROF_LOS_PORT_CUR() {
		return R22_PROF_LOS_PORT_CUR;
	}

	public void setR22_PROF_LOS_PORT_CUR(String r22_PROF_LOS_PORT_CUR) {
		R22_PROF_LOS_PORT_CUR = r22_PROF_LOS_PORT_CUR;
	}

	public String getR22_PROF_MARG_PERC_CUR() {
		return R22_PROF_MARG_PERC_CUR;
	}

	public void setR22_PROF_MARG_PERC_CUR(String r22_PROF_MARG_PERC_CUR) {
		R22_PROF_MARG_PERC_CUR = r22_PROF_MARG_PERC_CUR;
	}

	public String getR22_TOT_RET_ASET_CUR() {
		return R22_TOT_RET_ASET_CUR;
	}

	public void setR22_TOT_RET_ASET_CUR(String r22_TOT_RET_ASET_CUR) {
		R22_TOT_RET_ASET_CUR = r22_TOT_RET_ASET_CUR;
	}

	public String getR22_NON_PER_RET_PORT_CUR() {
		return R22_NON_PER_RET_PORT_CUR;
	}

	public void setR22_NON_PER_RET_PORT_CUR(String r22_NON_PER_RET_PORT_CUR) {
		R22_NON_PER_RET_PORT_CUR = r22_NON_PER_RET_PORT_CUR;
	}

	public String getR22_NO_CON_LAST_CUR() {
		return R22_NO_CON_LAST_CUR;
	}

	public void setR22_NO_CON_LAST_CUR(String r22_NO_CON_LAST_CUR) {
		R22_NO_CON_LAST_CUR = r22_NO_CON_LAST_CUR;
	}

	public String getR22_TOT_BRANCH_CUR() {
		return R22_TOT_BRANCH_CUR;
	}

	public void setR22_TOT_BRANCH_CUR(String r22_TOT_BRANCH_CUR) {
		R22_TOT_BRANCH_CUR = r22_TOT_BRANCH_CUR;
	}

	public String getR22_TOT_REV_T1() {
		return R22_TOT_REV_T1;
	}

	public void setR22_TOT_REV_T1(String r22_TOT_REV_T1) {
		R22_TOT_REV_T1 = r22_TOT_REV_T1;
	}

	public String getR22_PROF_LOS_T1() {
		return R22_PROF_LOS_T1;
	}

	public void setR22_PROF_LOS_T1(String r22_PROF_LOS_T1) {
		R22_PROF_LOS_T1 = r22_PROF_LOS_T1;
	}

	public String getR22_PROF_MARG_T1() {
		return R22_PROF_MARG_T1;
	}

	public void setR22_PROF_MARG_T1(String r22_PROF_MARG_T1) {
		R22_PROF_MARG_T1 = r22_PROF_MARG_T1;
	}

	public String getR22_TOT_RET_ASET_T1() {
		return R22_TOT_RET_ASET_T1;
	}

	public void setR22_TOT_RET_ASET_T1(String r22_TOT_RET_ASET_T1) {
		R22_TOT_RET_ASET_T1 = r22_TOT_RET_ASET_T1;
	}

	public String getR22_NON_PERF_PORT_T1() {
		return R22_NON_PERF_PORT_T1;
	}

	public void setR22_NON_PERF_PORT_T1(String r22_NON_PERF_PORT_T1) {
		R22_NON_PERF_PORT_T1 = r22_NON_PERF_PORT_T1;
	}

	public String getR22_NO_CON_LAST_T1() {
		return R22_NO_CON_LAST_T1;
	}

	public void setR22_NO_CON_LAST_T1(String r22_NO_CON_LAST_T1) {
		R22_NO_CON_LAST_T1 = r22_NO_CON_LAST_T1;
	}

	public String getR22_TOT_BRANCH_T1() {
		return R22_TOT_BRANCH_T1;
	}

	public void setR22_TOT_BRANCH_T1(String r22_TOT_BRANCH_T1) {
		R22_TOT_BRANCH_T1 = r22_TOT_BRANCH_T1;
	}

	public String getR22_TOT_REV_T2() {
		return R22_TOT_REV_T2;
	}

	public void setR22_TOT_REV_T2(String r22_TOT_REV_T2) {
		R22_TOT_REV_T2 = r22_TOT_REV_T2;
	}

	public String getR22_PROF_LOS_T2() {
		return R22_PROF_LOS_T2;
	}

	public void setR22_PROF_LOS_T2(String r22_PROF_LOS_T2) {
		R22_PROF_LOS_T2 = r22_PROF_LOS_T2;
	}

	public String getR22_PROF_MARG_T2() {
		return R22_PROF_MARG_T2;
	}

	public void setR22_PROF_MARG_T2(String r22_PROF_MARG_T2) {
		R22_PROF_MARG_T2 = r22_PROF_MARG_T2;
	}

	public String getR22_TOT_RET_ASET_T2() {
		return R22_TOT_RET_ASET_T2;
	}

	public void setR22_TOT_RET_ASET_T2(String r22_TOT_RET_ASET_T2) {
		R22_TOT_RET_ASET_T2 = r22_TOT_RET_ASET_T2;
	}

	public String getR22_NON_PERF_PORT_T2() {
		return R22_NON_PERF_PORT_T2;
	}

	public void setR22_NON_PERF_PORT_T2(String r22_NON_PERF_PORT_T2) {
		R22_NON_PERF_PORT_T2 = r22_NON_PERF_PORT_T2;
	}

	public String getR22_NO_CON_LAST_T2() {
		return R22_NO_CON_LAST_T2;
	}

	public void setR22_NO_CON_LAST_T2(String r22_NO_CON_LAST_T2) {
		R22_NO_CON_LAST_T2 = r22_NO_CON_LAST_T2;
	}

	public String getR22_TOT_BRANCH_T2() {
		return R22_TOT_BRANCH_T2;
	}

	public void setR22_TOT_BRANCH_T2(String r22_TOT_BRANCH_T2) {
		R22_TOT_BRANCH_T2 = r22_TOT_BRANCH_T2;
	}

	public String getR22_TOT_REV_T3() {
		return R22_TOT_REV_T3;
	}

	public void setR22_TOT_REV_T3(String r22_TOT_REV_T3) {
		R22_TOT_REV_T3 = r22_TOT_REV_T3;
	}

	public String getR22_PROF_LOS_T3() {
		return R22_PROF_LOS_T3;
	}

	public void setR22_PROF_LOS_T3(String r22_PROF_LOS_T3) {
		R22_PROF_LOS_T3 = r22_PROF_LOS_T3;
	}

	public String getR22_PROF_MARG_T3() {
		return R22_PROF_MARG_T3;
	}

	public void setR22_PROF_MARG_T3(String r22_PROF_MARG_T3) {
		R22_PROF_MARG_T3 = r22_PROF_MARG_T3;
	}

	public String getR22_TOT_RET_ASET_T3() {
		return R22_TOT_RET_ASET_T3;
	}

	public void setR22_TOT_RET_ASET_T3(String r22_TOT_RET_ASET_T3) {
		R22_TOT_RET_ASET_T3 = r22_TOT_RET_ASET_T3;
	}

	public String getR22_NON_PERF_PORT_T3() {
		return R22_NON_PERF_PORT_T3;
	}

	public void setR22_NON_PERF_PORT_T3(String r22_NON_PERF_PORT_T3) {
		R22_NON_PERF_PORT_T3 = r22_NON_PERF_PORT_T3;
	}

	public String getR22_NO_CON_LAST_T3() {
		return R22_NO_CON_LAST_T3;
	}

	public void setR22_NO_CON_LAST_T3(String r22_NO_CON_LAST_T3) {
		R22_NO_CON_LAST_T3 = r22_NO_CON_LAST_T3;
	}

	public String getR22_TOT_BRANCH_T3() {
		return R22_TOT_BRANCH_T3;
	}

	public void setR22_TOT_BRANCH_T3(String r22_TOT_BRANCH_T3) {
		R22_TOT_BRANCH_T3 = r22_TOT_BRANCH_T3;
	}

	public String getR22_NPL_SPD() {
		return R22_NPL_SPD;
	}

	public void setR22_NPL_SPD(String r22_NPL_SPD) {
		R22_NPL_SPD = r22_NPL_SPD;
	}

	public String getR22_RECO_NPL_SPD() {
		return R22_RECO_NPL_SPD;
	}

	public void setR22_RECO_NPL_SPD(String r22_RECO_NPL_SPD) {
		R22_RECO_NPL_SPD = r22_RECO_NPL_SPD;
	}

	public String getR22_NO_CON_ONBO_DIGI() {
		return R22_NO_CON_ONBO_DIGI;
	}

	public void setR22_NO_CON_ONBO_DIGI(String r22_NO_CON_ONBO_DIGI) {
		R22_NO_CON_ONBO_DIGI = r22_NO_CON_ONBO_DIGI;
	}

	public String getR22_NO_ACCS_AML() {
		return R22_NO_ACCS_AML;
	}

	public void setR22_NO_ACCS_AML(String r22_NO_ACCS_AML) {
		R22_NO_ACCS_AML = r22_NO_ACCS_AML;
	}

	public String getR22_TOT_ACC_LOAN_AML() {
		return R22_TOT_ACC_LOAN_AML;
	}

	public void setR22_TOT_ACC_LOAN_AML(String r22_TOT_ACC_LOAN_AML) {
		R22_TOT_ACC_LOAN_AML = r22_TOT_ACC_LOAN_AML;
	}

	public String getR22_TOT_NEW_ACCS_SPD() {
		return R22_TOT_NEW_ACCS_SPD;
	}

	public void setR22_TOT_NEW_ACCS_SPD(String r22_TOT_NEW_ACCS_SPD) {
		R22_TOT_NEW_ACCS_SPD = r22_TOT_NEW_ACCS_SPD;
	}

	public String getR22_TOT_VALS_LOANS_SPD() {
		return R22_TOT_VALS_LOANS_SPD;
	}

	public void setR22_TOT_VALS_LOANS_SPD(String r22_TOT_VALS_LOANS_SPD) {
		R22_TOT_VALS_LOANS_SPD = r22_TOT_VALS_LOANS_SPD;
	}

	public String getR22_NO_INQ_WEBMOB() {
		return R22_NO_INQ_WEBMOB;
	}

	public void setR22_NO_INQ_WEBMOB(String r22_NO_INQ_WEBMOB) {
		R22_NO_INQ_WEBMOB = r22_NO_INQ_WEBMOB;
	}

	public String getR22_NO_INQ_TRAD() {
		return R22_NO_INQ_TRAD;
	}

	public void setR22_NO_INQ_TRAD(String r22_NO_INQ_TRAD) {
		R22_NO_INQ_TRAD = r22_NO_INQ_TRAD;
	}

	public String getR22_NO_RET_POS() {
		return R22_NO_RET_POS;
	}

	public void setR22_NO_RET_POS(String r22_NO_RET_POS) {
		R22_NO_RET_POS = r22_NO_RET_POS;
	}

	public String getR22_AMT_POS_GATE() {
		return R22_AMT_POS_GATE;
	}

	public void setR22_AMT_POS_GATE(String r22_AMT_POS_GATE) {
		R22_AMT_POS_GATE = r22_AMT_POS_GATE;
	}

	public String getR22_NO_TRAN_SVF_BNK() {
		return R22_NO_TRAN_SVF_BNK;
	}

	public void setR22_NO_TRAN_SVF_BNK(String r22_NO_TRAN_SVF_BNK) {
		R22_NO_TRAN_SVF_BNK = r22_NO_TRAN_SVF_BNK;
	}

	public String getR22_AMT_RET_SVF_BNK() {
		return R22_AMT_RET_SVF_BNK;
	}

	public void setR22_AMT_RET_SVF_BNK(String r22_AMT_RET_SVF_BNK) {
		R22_AMT_RET_SVF_BNK = r22_AMT_RET_SVF_BNK;
	}

	public String getR22_TOT_WEB_MOB_VIRT() {
		return R22_TOT_WEB_MOB_VIRT;
	}

	public void setR22_TOT_WEB_MOB_VIRT(String r22_TOT_WEB_MOB_VIRT) {
		R22_TOT_WEB_MOB_VIRT = r22_TOT_WEB_MOB_VIRT;
	}

	public String getR22_VAL_UNCL_SVF() {
		return R22_VAL_UNCL_SVF;
	}

	public void setR22_VAL_UNCL_SVF(String r22_VAL_UNCL_SVF) {
		R22_VAL_UNCL_SVF = r22_VAL_UNCL_SVF;
	}

	public String getR22_NO_CON_LOW_RSK() {
		return R22_NO_CON_LOW_RSK;
	}

	public void setR22_NO_CON_LOW_RSK(String r22_NO_CON_LOW_RSK) {
		R22_NO_CON_LOW_RSK = r22_NO_CON_LOW_RSK;
	}

	public String getR22_NO_CON_HIGH_RSK() {
		return R22_NO_CON_HIGH_RSK;
	}

	public void setR22_NO_CON_HIGH_RSK(String r22_NO_CON_HIGH_RSK) {
		R22_NO_CON_HIGH_RSK = r22_NO_CON_HIGH_RSK;
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

	public String getR23_RET_ASET_LTS() {
		return R23_RET_ASET_LTS;
	}

	public void setR23_RET_ASET_LTS(String r23_RET_ASET_LTS) {
		R23_RET_ASET_LTS = r23_RET_ASET_LTS;
	}

	public String getR23_RET_ASET_LTSME() {
		return R23_RET_ASET_LTSME;
	}

	public void setR23_RET_ASET_LTSME(String r23_RET_ASET_LTSME) {
		R23_RET_ASET_LTSME = r23_RET_ASET_LTSME;
	}

	public String getR23_RET_ASET_SME_GUR() {
		return R23_RET_ASET_SME_GUR;
	}

	public void setR23_RET_ASET_SME_GUR(String r23_RET_ASET_SME_GUR) {
		R23_RET_ASET_SME_GUR = r23_RET_ASET_SME_GUR;
	}

	public String getR23_RET_LOAN_DIS() {
		return R23_RET_LOAN_DIS;
	}

	public void setR23_RET_LOAN_DIS(String r23_RET_LOAN_DIS) {
		R23_RET_LOAN_DIS = r23_RET_LOAN_DIS;
	}

	public String getR23_RET_ASET_LOAN_SME() {
		return R23_RET_ASET_LOAN_SME;
	}

	public void setR23_RET_ASET_LOAN_SME(String r23_RET_ASET_LOAN_SME) {
		R23_RET_ASET_LOAN_SME = r23_RET_ASET_LOAN_SME;
	}

	public String getR23_PER_LOAN_WEB() {
		return R23_PER_LOAN_WEB;
	}

	public void setR23_PER_LOAN_WEB(String r23_PER_LOAN_WEB) {
		R23_PER_LOAN_WEB = r23_PER_LOAN_WEB;
	}

	public String getR23_LOAN_SME_WEB_MOB() {
		return R23_LOAN_SME_WEB_MOB;
	}

	public void setR23_LOAN_SME_WEB_MOB(String r23_LOAN_SME_WEB_MOB) {
		R23_LOAN_SME_WEB_MOB = r23_LOAN_SME_WEB_MOB;
	}

	public String getR23_NO_COMPDIGI_MOB() {
		return R23_NO_COMPDIGI_MOB;
	}

	public void setR23_NO_COMPDIGI_MOB(String r23_NO_COMPDIGI_MOB) {
		R23_NO_COMPDIGI_MOB = r23_NO_COMPDIGI_MOB;
	}

	public String getR23_NO_COMP_TRADCALL() {
		return R23_NO_COMP_TRADCALL;
	}

	public void setR23_NO_COMP_TRADCALL(String r23_NO_COMP_TRADCALL) {
		R23_NO_COMP_TRADCALL = r23_NO_COMP_TRADCALL;
	}

	public String getR23_PER_COMPDIGI_WEB() {
		return R23_PER_COMPDIGI_WEB;
	}

	public void setR23_PER_COMPDIGI_WEB(String r23_PER_COMPDIGI_WEB) {
		R23_PER_COMPDIGI_WEB = r23_PER_COMPDIGI_WEB;
	}

	public String getR23_PER_COM_TRADCALL() {
		return R23_PER_COM_TRADCALL;
	}

	public void setR23_PER_COM_TRADCALL(String r23_PER_COM_TRADCALL) {
		R23_PER_COM_TRADCALL = r23_PER_COM_TRADCALL;
	}

	public String getR23_TOT_REV_PREV() {
		return R23_TOT_REV_PREV;
	}

	public void setR23_TOT_REV_PREV(String r23_TOT_REV_PREV) {
		R23_TOT_REV_PREV = r23_TOT_REV_PREV;
	}

	public String getR23_PROF_LOSS_PREV() {
		return R23_PROF_LOSS_PREV;
	}

	public void setR23_PROF_LOSS_PREV(String r23_PROF_LOSS_PREV) {
		R23_PROF_LOSS_PREV = r23_PROF_LOSS_PREV;
	}

	public String getR23_PROF_MARG_PORTFOLIO() {
		return R23_PROF_MARG_PORTFOLIO;
	}

	public void setR23_PROF_MARG_PORTFOLIO(String r23_PROF_MARG_PORTFOLIO) {
		R23_PROF_MARG_PORTFOLIO = r23_PROF_MARG_PORTFOLIO;
	}

	public String getR23_TOT_RET_ASET_PREV() {
		return R23_TOT_RET_ASET_PREV;
	}

	public void setR23_TOT_RET_ASET_PREV(String r23_TOT_RET_ASET_PREV) {
		R23_TOT_RET_ASET_PREV = r23_TOT_RET_ASET_PREV;
	}

	public String getR23_NP_LOAN_PREV() {
		return R23_NP_LOAN_PREV;
	}

	public void setR23_NP_LOAN_PREV(String r23_NP_LOAN_PREV) {
		R23_NP_LOAN_PREV = r23_NP_LOAN_PREV;
	}

	public String getR23_NON_CON_ONLAST_PREV() {
		return R23_NON_CON_ONLAST_PREV;
	}

	public void setR23_NON_CON_ONLAST_PREV(String r23_NON_CON_ONLAST_PREV) {
		R23_NON_CON_ONLAST_PREV = r23_NON_CON_ONLAST_PREV;
	}

	public String getR23_TOT_BRAN_PREV() {
		return R23_TOT_BRAN_PREV;
	}

	public void setR23_TOT_BRAN_PREV(String r23_TOT_BRAN_PREV) {
		R23_TOT_BRAN_PREV = r23_TOT_BRAN_PREV;
	}

	public String getR23_TOT_REV_RET_CUR() {
		return R23_TOT_REV_RET_CUR;
	}

	public void setR23_TOT_REV_RET_CUR(String r23_TOT_REV_RET_CUR) {
		R23_TOT_REV_RET_CUR = r23_TOT_REV_RET_CUR;
	}

	public String getR23_PROF_LOS_PORT_CUR() {
		return R23_PROF_LOS_PORT_CUR;
	}

	public void setR23_PROF_LOS_PORT_CUR(String r23_PROF_LOS_PORT_CUR) {
		R23_PROF_LOS_PORT_CUR = r23_PROF_LOS_PORT_CUR;
	}

	public String getR23_PROF_MARG_PERC_CUR() {
		return R23_PROF_MARG_PERC_CUR;
	}

	public void setR23_PROF_MARG_PERC_CUR(String r23_PROF_MARG_PERC_CUR) {
		R23_PROF_MARG_PERC_CUR = r23_PROF_MARG_PERC_CUR;
	}

	public String getR23_TOT_RET_ASET_CUR() {
		return R23_TOT_RET_ASET_CUR;
	}

	public void setR23_TOT_RET_ASET_CUR(String r23_TOT_RET_ASET_CUR) {
		R23_TOT_RET_ASET_CUR = r23_TOT_RET_ASET_CUR;
	}

	public String getR23_NON_PER_RET_PORT_CUR() {
		return R23_NON_PER_RET_PORT_CUR;
	}

	public void setR23_NON_PER_RET_PORT_CUR(String r23_NON_PER_RET_PORT_CUR) {
		R23_NON_PER_RET_PORT_CUR = r23_NON_PER_RET_PORT_CUR;
	}

	public String getR23_NO_CON_LAST_CUR() {
		return R23_NO_CON_LAST_CUR;
	}

	public void setR23_NO_CON_LAST_CUR(String r23_NO_CON_LAST_CUR) {
		R23_NO_CON_LAST_CUR = r23_NO_CON_LAST_CUR;
	}

	public String getR23_TOT_BRANCH_CUR() {
		return R23_TOT_BRANCH_CUR;
	}

	public void setR23_TOT_BRANCH_CUR(String r23_TOT_BRANCH_CUR) {
		R23_TOT_BRANCH_CUR = r23_TOT_BRANCH_CUR;
	}

	public String getR23_TOT_REV_T1() {
		return R23_TOT_REV_T1;
	}

	public void setR23_TOT_REV_T1(String r23_TOT_REV_T1) {
		R23_TOT_REV_T1 = r23_TOT_REV_T1;
	}

	public String getR23_PROF_LOS_T1() {
		return R23_PROF_LOS_T1;
	}

	public void setR23_PROF_LOS_T1(String r23_PROF_LOS_T1) {
		R23_PROF_LOS_T1 = r23_PROF_LOS_T1;
	}

	public String getR23_PROF_MARG_T1() {
		return R23_PROF_MARG_T1;
	}

	public void setR23_PROF_MARG_T1(String r23_PROF_MARG_T1) {
		R23_PROF_MARG_T1 = r23_PROF_MARG_T1;
	}

	public String getR23_TOT_RET_ASET_T1() {
		return R23_TOT_RET_ASET_T1;
	}

	public void setR23_TOT_RET_ASET_T1(String r23_TOT_RET_ASET_T1) {
		R23_TOT_RET_ASET_T1 = r23_TOT_RET_ASET_T1;
	}

	public String getR23_NON_PERF_PORT_T1() {
		return R23_NON_PERF_PORT_T1;
	}

	public void setR23_NON_PERF_PORT_T1(String r23_NON_PERF_PORT_T1) {
		R23_NON_PERF_PORT_T1 = r23_NON_PERF_PORT_T1;
	}

	public String getR23_NO_CON_LAST_T1() {
		return R23_NO_CON_LAST_T1;
	}

	public void setR23_NO_CON_LAST_T1(String r23_NO_CON_LAST_T1) {
		R23_NO_CON_LAST_T1 = r23_NO_CON_LAST_T1;
	}

	public String getR23_TOT_BRANCH_T1() {
		return R23_TOT_BRANCH_T1;
	}

	public void setR23_TOT_BRANCH_T1(String r23_TOT_BRANCH_T1) {
		R23_TOT_BRANCH_T1 = r23_TOT_BRANCH_T1;
	}

	public String getR23_TOT_REV_T2() {
		return R23_TOT_REV_T2;
	}

	public void setR23_TOT_REV_T2(String r23_TOT_REV_T2) {
		R23_TOT_REV_T2 = r23_TOT_REV_T2;
	}

	public String getR23_PROF_LOS_T2() {
		return R23_PROF_LOS_T2;
	}

	public void setR23_PROF_LOS_T2(String r23_PROF_LOS_T2) {
		R23_PROF_LOS_T2 = r23_PROF_LOS_T2;
	}

	public String getR23_PROF_MARG_T2() {
		return R23_PROF_MARG_T2;
	}

	public void setR23_PROF_MARG_T2(String r23_PROF_MARG_T2) {
		R23_PROF_MARG_T2 = r23_PROF_MARG_T2;
	}

	public String getR23_TOT_RET_ASET_T2() {
		return R23_TOT_RET_ASET_T2;
	}

	public void setR23_TOT_RET_ASET_T2(String r23_TOT_RET_ASET_T2) {
		R23_TOT_RET_ASET_T2 = r23_TOT_RET_ASET_T2;
	}

	public String getR23_NON_PERF_PORT_T2() {
		return R23_NON_PERF_PORT_T2;
	}

	public void setR23_NON_PERF_PORT_T2(String r23_NON_PERF_PORT_T2) {
		R23_NON_PERF_PORT_T2 = r23_NON_PERF_PORT_T2;
	}

	public String getR23_NO_CON_LAST_T2() {
		return R23_NO_CON_LAST_T2;
	}

	public void setR23_NO_CON_LAST_T2(String r23_NO_CON_LAST_T2) {
		R23_NO_CON_LAST_T2 = r23_NO_CON_LAST_T2;
	}

	public String getR23_TOT_BRANCH_T2() {
		return R23_TOT_BRANCH_T2;
	}

	public void setR23_TOT_BRANCH_T2(String r23_TOT_BRANCH_T2) {
		R23_TOT_BRANCH_T2 = r23_TOT_BRANCH_T2;
	}

	public String getR23_TOT_REV_T3() {
		return R23_TOT_REV_T3;
	}

	public void setR23_TOT_REV_T3(String r23_TOT_REV_T3) {
		R23_TOT_REV_T3 = r23_TOT_REV_T3;
	}

	public String getR23_PROF_LOS_T3() {
		return R23_PROF_LOS_T3;
	}

	public void setR23_PROF_LOS_T3(String r23_PROF_LOS_T3) {
		R23_PROF_LOS_T3 = r23_PROF_LOS_T3;
	}

	public String getR23_PROF_MARG_T3() {
		return R23_PROF_MARG_T3;
	}

	public void setR23_PROF_MARG_T3(String r23_PROF_MARG_T3) {
		R23_PROF_MARG_T3 = r23_PROF_MARG_T3;
	}

	public String getR23_TOT_RET_ASET_T3() {
		return R23_TOT_RET_ASET_T3;
	}

	public void setR23_TOT_RET_ASET_T3(String r23_TOT_RET_ASET_T3) {
		R23_TOT_RET_ASET_T3 = r23_TOT_RET_ASET_T3;
	}

	public String getR23_NON_PERF_PORT_T3() {
		return R23_NON_PERF_PORT_T3;
	}

	public void setR23_NON_PERF_PORT_T3(String r23_NON_PERF_PORT_T3) {
		R23_NON_PERF_PORT_T3 = r23_NON_PERF_PORT_T3;
	}

	public String getR23_NO_CON_LAST_T3() {
		return R23_NO_CON_LAST_T3;
	}

	public void setR23_NO_CON_LAST_T3(String r23_NO_CON_LAST_T3) {
		R23_NO_CON_LAST_T3 = r23_NO_CON_LAST_T3;
	}

	public String getR23_TOT_BRANCH_T3() {
		return R23_TOT_BRANCH_T3;
	}

	public void setR23_TOT_BRANCH_T3(String r23_TOT_BRANCH_T3) {
		R23_TOT_BRANCH_T3 = r23_TOT_BRANCH_T3;
	}

	public String getR23_NPL_SPD() {
		return R23_NPL_SPD;
	}

	public void setR23_NPL_SPD(String r23_NPL_SPD) {
		R23_NPL_SPD = r23_NPL_SPD;
	}

	public String getR23_RECO_NPL_SPD() {
		return R23_RECO_NPL_SPD;
	}

	public void setR23_RECO_NPL_SPD(String r23_RECO_NPL_SPD) {
		R23_RECO_NPL_SPD = r23_RECO_NPL_SPD;
	}

	public String getR23_NO_CON_ONBO_DIGI() {
		return R23_NO_CON_ONBO_DIGI;
	}

	public void setR23_NO_CON_ONBO_DIGI(String r23_NO_CON_ONBO_DIGI) {
		R23_NO_CON_ONBO_DIGI = r23_NO_CON_ONBO_DIGI;
	}

	public String getR23_NO_ACCS_AML() {
		return R23_NO_ACCS_AML;
	}

	public void setR23_NO_ACCS_AML(String r23_NO_ACCS_AML) {
		R23_NO_ACCS_AML = r23_NO_ACCS_AML;
	}

	public String getR23_TOT_ACC_LOAN_AML() {
		return R23_TOT_ACC_LOAN_AML;
	}

	public void setR23_TOT_ACC_LOAN_AML(String r23_TOT_ACC_LOAN_AML) {
		R23_TOT_ACC_LOAN_AML = r23_TOT_ACC_LOAN_AML;
	}

	public String getR23_TOT_NEW_ACCS_SPD() {
		return R23_TOT_NEW_ACCS_SPD;
	}

	public void setR23_TOT_NEW_ACCS_SPD(String r23_TOT_NEW_ACCS_SPD) {
		R23_TOT_NEW_ACCS_SPD = r23_TOT_NEW_ACCS_SPD;
	}

	public String getR23_TOT_VALS_LOANS_SPD() {
		return R23_TOT_VALS_LOANS_SPD;
	}

	public void setR23_TOT_VALS_LOANS_SPD(String r23_TOT_VALS_LOANS_SPD) {
		R23_TOT_VALS_LOANS_SPD = r23_TOT_VALS_LOANS_SPD;
	}

	public String getR23_NO_INQ_WEBMOB() {
		return R23_NO_INQ_WEBMOB;
	}

	public void setR23_NO_INQ_WEBMOB(String r23_NO_INQ_WEBMOB) {
		R23_NO_INQ_WEBMOB = r23_NO_INQ_WEBMOB;
	}

	public String getR23_NO_INQ_TRAD() {
		return R23_NO_INQ_TRAD;
	}

	public void setR23_NO_INQ_TRAD(String r23_NO_INQ_TRAD) {
		R23_NO_INQ_TRAD = r23_NO_INQ_TRAD;
	}

	public String getR23_NO_RET_POS() {
		return R23_NO_RET_POS;
	}

	public void setR23_NO_RET_POS(String r23_NO_RET_POS) {
		R23_NO_RET_POS = r23_NO_RET_POS;
	}

	public String getR23_AMT_POS_GATE() {
		return R23_AMT_POS_GATE;
	}

	public void setR23_AMT_POS_GATE(String r23_AMT_POS_GATE) {
		R23_AMT_POS_GATE = r23_AMT_POS_GATE;
	}

	public String getR23_NO_TRAN_SVF_BNK() {
		return R23_NO_TRAN_SVF_BNK;
	}

	public void setR23_NO_TRAN_SVF_BNK(String r23_NO_TRAN_SVF_BNK) {
		R23_NO_TRAN_SVF_BNK = r23_NO_TRAN_SVF_BNK;
	}

	public String getR23_AMT_RET_SVF_BNK() {
		return R23_AMT_RET_SVF_BNK;
	}

	public void setR23_AMT_RET_SVF_BNK(String r23_AMT_RET_SVF_BNK) {
		R23_AMT_RET_SVF_BNK = r23_AMT_RET_SVF_BNK;
	}

	public String getR23_TOT_WEB_MOB_VIRT() {
		return R23_TOT_WEB_MOB_VIRT;
	}

	public void setR23_TOT_WEB_MOB_VIRT(String r23_TOT_WEB_MOB_VIRT) {
		R23_TOT_WEB_MOB_VIRT = r23_TOT_WEB_MOB_VIRT;
	}

	public String getR23_VAL_UNCL_SVF() {
		return R23_VAL_UNCL_SVF;
	}

	public void setR23_VAL_UNCL_SVF(String r23_VAL_UNCL_SVF) {
		R23_VAL_UNCL_SVF = r23_VAL_UNCL_SVF;
	}

	public String getR23_NO_CON_LOW_RSK() {
		return R23_NO_CON_LOW_RSK;
	}

	public void setR23_NO_CON_LOW_RSK(String r23_NO_CON_LOW_RSK) {
		R23_NO_CON_LOW_RSK = r23_NO_CON_LOW_RSK;
	}

	public String getR23_NO_CON_HIGH_RSK() {
		return R23_NO_CON_HIGH_RSK;
	}

	public void setR23_NO_CON_HIGH_RSK(String r23_NO_CON_HIGH_RSK) {
		R23_NO_CON_HIGH_RSK = r23_NO_CON_HIGH_RSK;
	}

	public String getR24_BANK() {
		return R24_BANK;
	}

	public void setR24_BANK(String r24_BANK) {
		R24_BANK = r24_BANK;
	}

	public String getR24_PRODUCT() {
		return R24_PRODUCT;
	}

	public void setR24_PRODUCT(String r24_PRODUCT) {
		R24_PRODUCT = r24_PRODUCT;
	}

	public String getR24_RET_ASET_LTS() {
		return R24_RET_ASET_LTS;
	}

	public void setR24_RET_ASET_LTS(String r24_RET_ASET_LTS) {
		R24_RET_ASET_LTS = r24_RET_ASET_LTS;
	}

	public String getR24_RET_ASET_LTSME() {
		return R24_RET_ASET_LTSME;
	}

	public void setR24_RET_ASET_LTSME(String r24_RET_ASET_LTSME) {
		R24_RET_ASET_LTSME = r24_RET_ASET_LTSME;
	}

	public String getR24_RET_ASET_SME_GUR() {
		return R24_RET_ASET_SME_GUR;
	}

	public void setR24_RET_ASET_SME_GUR(String r24_RET_ASET_SME_GUR) {
		R24_RET_ASET_SME_GUR = r24_RET_ASET_SME_GUR;
	}

	public String getR24_RET_LOAN_DIS() {
		return R24_RET_LOAN_DIS;
	}

	public void setR24_RET_LOAN_DIS(String r24_RET_LOAN_DIS) {
		R24_RET_LOAN_DIS = r24_RET_LOAN_DIS;
	}

	public String getR24_RET_ASET_LOAN_SME() {
		return R24_RET_ASET_LOAN_SME;
	}

	public void setR24_RET_ASET_LOAN_SME(String r24_RET_ASET_LOAN_SME) {
		R24_RET_ASET_LOAN_SME = r24_RET_ASET_LOAN_SME;
	}

	public String getR24_PER_LOAN_WEB() {
		return R24_PER_LOAN_WEB;
	}

	public void setR24_PER_LOAN_WEB(String r24_PER_LOAN_WEB) {
		R24_PER_LOAN_WEB = r24_PER_LOAN_WEB;
	}

	public String getR24_LOAN_SME_WEB_MOB() {
		return R24_LOAN_SME_WEB_MOB;
	}

	public void setR24_LOAN_SME_WEB_MOB(String r24_LOAN_SME_WEB_MOB) {
		R24_LOAN_SME_WEB_MOB = r24_LOAN_SME_WEB_MOB;
	}

	public String getR24_NO_COMPDIGI_MOB() {
		return R24_NO_COMPDIGI_MOB;
	}

	public void setR24_NO_COMPDIGI_MOB(String r24_NO_COMPDIGI_MOB) {
		R24_NO_COMPDIGI_MOB = r24_NO_COMPDIGI_MOB;
	}

	public String getR24_NO_COMP_TRADCALL() {
		return R24_NO_COMP_TRADCALL;
	}

	public void setR24_NO_COMP_TRADCALL(String r24_NO_COMP_TRADCALL) {
		R24_NO_COMP_TRADCALL = r24_NO_COMP_TRADCALL;
	}

	public String getR24_PER_COMPDIGI_WEB() {
		return R24_PER_COMPDIGI_WEB;
	}

	public void setR24_PER_COMPDIGI_WEB(String r24_PER_COMPDIGI_WEB) {
		R24_PER_COMPDIGI_WEB = r24_PER_COMPDIGI_WEB;
	}

	public String getR24_PER_COM_TRADCALL() {
		return R24_PER_COM_TRADCALL;
	}

	public void setR24_PER_COM_TRADCALL(String r24_PER_COM_TRADCALL) {
		R24_PER_COM_TRADCALL = r24_PER_COM_TRADCALL;
	}

	public String getR24_TOT_REV_PREV() {
		return R24_TOT_REV_PREV;
	}

	public void setR24_TOT_REV_PREV(String r24_TOT_REV_PREV) {
		R24_TOT_REV_PREV = r24_TOT_REV_PREV;
	}

	public String getR24_PROF_LOSS_PREV() {
		return R24_PROF_LOSS_PREV;
	}

	public void setR24_PROF_LOSS_PREV(String r24_PROF_LOSS_PREV) {
		R24_PROF_LOSS_PREV = r24_PROF_LOSS_PREV;
	}

	public String getR24_PROF_MARG_PORTFOLIO() {
		return R24_PROF_MARG_PORTFOLIO;
	}

	public void setR24_PROF_MARG_PORTFOLIO(String r24_PROF_MARG_PORTFOLIO) {
		R24_PROF_MARG_PORTFOLIO = r24_PROF_MARG_PORTFOLIO;
	}

	public String getR24_TOT_RET_ASET_PREV() {
		return R24_TOT_RET_ASET_PREV;
	}

	public void setR24_TOT_RET_ASET_PREV(String r24_TOT_RET_ASET_PREV) {
		R24_TOT_RET_ASET_PREV = r24_TOT_RET_ASET_PREV;
	}

	public String getR24_NP_LOAN_PREV() {
		return R24_NP_LOAN_PREV;
	}

	public void setR24_NP_LOAN_PREV(String r24_NP_LOAN_PREV) {
		R24_NP_LOAN_PREV = r24_NP_LOAN_PREV;
	}

	public String getR24_NON_CON_ONLAST_PREV() {
		return R24_NON_CON_ONLAST_PREV;
	}

	public void setR24_NON_CON_ONLAST_PREV(String r24_NON_CON_ONLAST_PREV) {
		R24_NON_CON_ONLAST_PREV = r24_NON_CON_ONLAST_PREV;
	}

	public String getR24_TOT_BRAN_PREV() {
		return R24_TOT_BRAN_PREV;
	}

	public void setR24_TOT_BRAN_PREV(String r24_TOT_BRAN_PREV) {
		R24_TOT_BRAN_PREV = r24_TOT_BRAN_PREV;
	}

	public String getR24_TOT_REV_RET_CUR() {
		return R24_TOT_REV_RET_CUR;
	}

	public void setR24_TOT_REV_RET_CUR(String r24_TOT_REV_RET_CUR) {
		R24_TOT_REV_RET_CUR = r24_TOT_REV_RET_CUR;
	}

	public String getR24_PROF_LOS_PORT_CUR() {
		return R24_PROF_LOS_PORT_CUR;
	}

	public void setR24_PROF_LOS_PORT_CUR(String r24_PROF_LOS_PORT_CUR) {
		R24_PROF_LOS_PORT_CUR = r24_PROF_LOS_PORT_CUR;
	}

	public String getR24_PROF_MARG_PERC_CUR() {
		return R24_PROF_MARG_PERC_CUR;
	}

	public void setR24_PROF_MARG_PERC_CUR(String r24_PROF_MARG_PERC_CUR) {
		R24_PROF_MARG_PERC_CUR = r24_PROF_MARG_PERC_CUR;
	}

	public String getR24_TOT_RET_ASET_CUR() {
		return R24_TOT_RET_ASET_CUR;
	}

	public void setR24_TOT_RET_ASET_CUR(String r24_TOT_RET_ASET_CUR) {
		R24_TOT_RET_ASET_CUR = r24_TOT_RET_ASET_CUR;
	}

	public String getR24_NON_PER_RET_PORT_CUR() {
		return R24_NON_PER_RET_PORT_CUR;
	}

	public void setR24_NON_PER_RET_PORT_CUR(String r24_NON_PER_RET_PORT_CUR) {
		R24_NON_PER_RET_PORT_CUR = r24_NON_PER_RET_PORT_CUR;
	}

	public String getR24_NO_CON_LAST_CUR() {
		return R24_NO_CON_LAST_CUR;
	}

	public void setR24_NO_CON_LAST_CUR(String r24_NO_CON_LAST_CUR) {
		R24_NO_CON_LAST_CUR = r24_NO_CON_LAST_CUR;
	}

	public String getR24_TOT_BRANCH_CUR() {
		return R24_TOT_BRANCH_CUR;
	}

	public void setR24_TOT_BRANCH_CUR(String r24_TOT_BRANCH_CUR) {
		R24_TOT_BRANCH_CUR = r24_TOT_BRANCH_CUR;
	}

	public String getR24_TOT_REV_T1() {
		return R24_TOT_REV_T1;
	}

	public void setR24_TOT_REV_T1(String r24_TOT_REV_T1) {
		R24_TOT_REV_T1 = r24_TOT_REV_T1;
	}

	public String getR24_PROF_LOS_T1() {
		return R24_PROF_LOS_T1;
	}

	public void setR24_PROF_LOS_T1(String r24_PROF_LOS_T1) {
		R24_PROF_LOS_T1 = r24_PROF_LOS_T1;
	}

	public String getR24_PROF_MARG_T1() {
		return R24_PROF_MARG_T1;
	}

	public void setR24_PROF_MARG_T1(String r24_PROF_MARG_T1) {
		R24_PROF_MARG_T1 = r24_PROF_MARG_T1;
	}

	public String getR24_TOT_RET_ASET_T1() {
		return R24_TOT_RET_ASET_T1;
	}

	public void setR24_TOT_RET_ASET_T1(String r24_TOT_RET_ASET_T1) {
		R24_TOT_RET_ASET_T1 = r24_TOT_RET_ASET_T1;
	}

	public String getR24_NON_PERF_PORT_T1() {
		return R24_NON_PERF_PORT_T1;
	}

	public void setR24_NON_PERF_PORT_T1(String r24_NON_PERF_PORT_T1) {
		R24_NON_PERF_PORT_T1 = r24_NON_PERF_PORT_T1;
	}

	public String getR24_NO_CON_LAST_T1() {
		return R24_NO_CON_LAST_T1;
	}

	public void setR24_NO_CON_LAST_T1(String r24_NO_CON_LAST_T1) {
		R24_NO_CON_LAST_T1 = r24_NO_CON_LAST_T1;
	}

	public String getR24_TOT_BRANCH_T1() {
		return R24_TOT_BRANCH_T1;
	}

	public void setR24_TOT_BRANCH_T1(String r24_TOT_BRANCH_T1) {
		R24_TOT_BRANCH_T1 = r24_TOT_BRANCH_T1;
	}

	public String getR24_TOT_REV_T2() {
		return R24_TOT_REV_T2;
	}

	public void setR24_TOT_REV_T2(String r24_TOT_REV_T2) {
		R24_TOT_REV_T2 = r24_TOT_REV_T2;
	}

	public String getR24_PROF_LOS_T2() {
		return R24_PROF_LOS_T2;
	}

	public void setR24_PROF_LOS_T2(String r24_PROF_LOS_T2) {
		R24_PROF_LOS_T2 = r24_PROF_LOS_T2;
	}

	public String getR24_PROF_MARG_T2() {
		return R24_PROF_MARG_T2;
	}

	public void setR24_PROF_MARG_T2(String r24_PROF_MARG_T2) {
		R24_PROF_MARG_T2 = r24_PROF_MARG_T2;
	}

	public String getR24_TOT_RET_ASET_T2() {
		return R24_TOT_RET_ASET_T2;
	}

	public void setR24_TOT_RET_ASET_T2(String r24_TOT_RET_ASET_T2) {
		R24_TOT_RET_ASET_T2 = r24_TOT_RET_ASET_T2;
	}

	public String getR24_NON_PERF_PORT_T2() {
		return R24_NON_PERF_PORT_T2;
	}

	public void setR24_NON_PERF_PORT_T2(String r24_NON_PERF_PORT_T2) {
		R24_NON_PERF_PORT_T2 = r24_NON_PERF_PORT_T2;
	}

	public String getR24_NO_CON_LAST_T2() {
		return R24_NO_CON_LAST_T2;
	}

	public void setR24_NO_CON_LAST_T2(String r24_NO_CON_LAST_T2) {
		R24_NO_CON_LAST_T2 = r24_NO_CON_LAST_T2;
	}

	public String getR24_TOT_BRANCH_T2() {
		return R24_TOT_BRANCH_T2;
	}

	public void setR24_TOT_BRANCH_T2(String r24_TOT_BRANCH_T2) {
		R24_TOT_BRANCH_T2 = r24_TOT_BRANCH_T2;
	}

	public String getR24_TOT_REV_T3() {
		return R24_TOT_REV_T3;
	}

	public void setR24_TOT_REV_T3(String r24_TOT_REV_T3) {
		R24_TOT_REV_T3 = r24_TOT_REV_T3;
	}

	public String getR24_PROF_LOS_T3() {
		return R24_PROF_LOS_T3;
	}

	public void setR24_PROF_LOS_T3(String r24_PROF_LOS_T3) {
		R24_PROF_LOS_T3 = r24_PROF_LOS_T3;
	}

	public String getR24_PROF_MARG_T3() {
		return R24_PROF_MARG_T3;
	}

	public void setR24_PROF_MARG_T3(String r24_PROF_MARG_T3) {
		R24_PROF_MARG_T3 = r24_PROF_MARG_T3;
	}

	public String getR24_TOT_RET_ASET_T3() {
		return R24_TOT_RET_ASET_T3;
	}

	public void setR24_TOT_RET_ASET_T3(String r24_TOT_RET_ASET_T3) {
		R24_TOT_RET_ASET_T3 = r24_TOT_RET_ASET_T3;
	}

	public String getR24_NON_PERF_PORT_T3() {
		return R24_NON_PERF_PORT_T3;
	}

	public void setR24_NON_PERF_PORT_T3(String r24_NON_PERF_PORT_T3) {
		R24_NON_PERF_PORT_T3 = r24_NON_PERF_PORT_T3;
	}

	public String getR24_NO_CON_LAST_T3() {
		return R24_NO_CON_LAST_T3;
	}

	public void setR24_NO_CON_LAST_T3(String r24_NO_CON_LAST_T3) {
		R24_NO_CON_LAST_T3 = r24_NO_CON_LAST_T3;
	}

	public String getR24_TOT_BRANCH_T3() {
		return R24_TOT_BRANCH_T3;
	}

	public void setR24_TOT_BRANCH_T3(String r24_TOT_BRANCH_T3) {
		R24_TOT_BRANCH_T3 = r24_TOT_BRANCH_T3;
	}

	public String getR24_NPL_SPD() {
		return R24_NPL_SPD;
	}

	public void setR24_NPL_SPD(String r24_NPL_SPD) {
		R24_NPL_SPD = r24_NPL_SPD;
	}

	public String getR24_RECO_NPL_SPD() {
		return R24_RECO_NPL_SPD;
	}

	public void setR24_RECO_NPL_SPD(String r24_RECO_NPL_SPD) {
		R24_RECO_NPL_SPD = r24_RECO_NPL_SPD;
	}

	public String getR24_NO_CON_ONBO_DIGI() {
		return R24_NO_CON_ONBO_DIGI;
	}

	public void setR24_NO_CON_ONBO_DIGI(String r24_NO_CON_ONBO_DIGI) {
		R24_NO_CON_ONBO_DIGI = r24_NO_CON_ONBO_DIGI;
	}

	public String getR24_NO_ACCS_AML() {
		return R24_NO_ACCS_AML;
	}

	public void setR24_NO_ACCS_AML(String r24_NO_ACCS_AML) {
		R24_NO_ACCS_AML = r24_NO_ACCS_AML;
	}

	public String getR24_TOT_ACC_LOAN_AML() {
		return R24_TOT_ACC_LOAN_AML;
	}

	public void setR24_TOT_ACC_LOAN_AML(String r24_TOT_ACC_LOAN_AML) {
		R24_TOT_ACC_LOAN_AML = r24_TOT_ACC_LOAN_AML;
	}

	public String getR24_TOT_NEW_ACCS_SPD() {
		return R24_TOT_NEW_ACCS_SPD;
	}

	public void setR24_TOT_NEW_ACCS_SPD(String r24_TOT_NEW_ACCS_SPD) {
		R24_TOT_NEW_ACCS_SPD = r24_TOT_NEW_ACCS_SPD;
	}

	public String getR24_TOT_VALS_LOANS_SPD() {
		return R24_TOT_VALS_LOANS_SPD;
	}

	public void setR24_TOT_VALS_LOANS_SPD(String r24_TOT_VALS_LOANS_SPD) {
		R24_TOT_VALS_LOANS_SPD = r24_TOT_VALS_LOANS_SPD;
	}

	public String getR24_NO_INQ_WEBMOB() {
		return R24_NO_INQ_WEBMOB;
	}

	public void setR24_NO_INQ_WEBMOB(String r24_NO_INQ_WEBMOB) {
		R24_NO_INQ_WEBMOB = r24_NO_INQ_WEBMOB;
	}

	public String getR24_NO_INQ_TRAD() {
		return R24_NO_INQ_TRAD;
	}

	public void setR24_NO_INQ_TRAD(String r24_NO_INQ_TRAD) {
		R24_NO_INQ_TRAD = r24_NO_INQ_TRAD;
	}

	public String getR24_NO_RET_POS() {
		return R24_NO_RET_POS;
	}

	public void setR24_NO_RET_POS(String r24_NO_RET_POS) {
		R24_NO_RET_POS = r24_NO_RET_POS;
	}

	public String getR24_AMT_POS_GATE() {
		return R24_AMT_POS_GATE;
	}

	public void setR24_AMT_POS_GATE(String r24_AMT_POS_GATE) {
		R24_AMT_POS_GATE = r24_AMT_POS_GATE;
	}

	public String getR24_NO_TRAN_SVF_BNK() {
		return R24_NO_TRAN_SVF_BNK;
	}

	public void setR24_NO_TRAN_SVF_BNK(String r24_NO_TRAN_SVF_BNK) {
		R24_NO_TRAN_SVF_BNK = r24_NO_TRAN_SVF_BNK;
	}

	public String getR24_AMT_RET_SVF_BNK() {
		return R24_AMT_RET_SVF_BNK;
	}

	public void setR24_AMT_RET_SVF_BNK(String r24_AMT_RET_SVF_BNK) {
		R24_AMT_RET_SVF_BNK = r24_AMT_RET_SVF_BNK;
	}

	public String getR24_TOT_WEB_MOB_VIRT() {
		return R24_TOT_WEB_MOB_VIRT;
	}

	public void setR24_TOT_WEB_MOB_VIRT(String r24_TOT_WEB_MOB_VIRT) {
		R24_TOT_WEB_MOB_VIRT = r24_TOT_WEB_MOB_VIRT;
	}

	public String getR24_VAL_UNCL_SVF() {
		return R24_VAL_UNCL_SVF;
	}

	public void setR24_VAL_UNCL_SVF(String r24_VAL_UNCL_SVF) {
		R24_VAL_UNCL_SVF = r24_VAL_UNCL_SVF;
	}

	public String getR24_NO_CON_LOW_RSK() {
		return R24_NO_CON_LOW_RSK;
	}

	public void setR24_NO_CON_LOW_RSK(String r24_NO_CON_LOW_RSK) {
		R24_NO_CON_LOW_RSK = r24_NO_CON_LOW_RSK;
	}

	public String getR24_NO_CON_HIGH_RSK() {
		return R24_NO_CON_HIGH_RSK;
	}

	public void setR24_NO_CON_HIGH_RSK(String r24_NO_CON_HIGH_RSK) {
		R24_NO_CON_HIGH_RSK = r24_NO_CON_HIGH_RSK;
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
