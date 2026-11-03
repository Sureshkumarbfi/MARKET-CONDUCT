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
@Table(name = "RT_MC_TABLE1")
public class RT_MC_TABLE1_ENTITY {
	public String R6_BANK;
	public String R6_PRODUCT;
	public BigDecimal R6_NO_EMP_SPC_TP;
	public BigDecimal R6_NO_CON_SPC_TP;
	public BigDecimal R6_AVG_NO_EMP_SPC_TP;
	public BigDecimal R6_NO_BRN_SPC_TP;
	public BigDecimal R6_TOT_NO_BRN_POD;
	public BigDecimal R6_NO_ATM_SPC_TP;
	public BigDecimal R6_NO_ATM_DET_SPC_TP;
	public BigDecimal R6_NO_AUT_SPC_TP;
	public BigDecimal R6_NO_INS_BNK_SPC_TP;
	public BigDecimal R6_NO_INS_DWN_SPC_TP;
	public BigDecimal R6_NO_EMP_RSK_SPC_DTE;
	public BigDecimal R6_NO_EXT_FRD_SPC_TP;
	public BigDecimal R6_NO_INT_FRD_SPC_TP;
	public BigDecimal R6_NO_FRD_SPC_TP;
	public BigDecimal R6_NO_FRD_PP;
	public BigDecimal R6_TOT_REV_SPC_TP;
	public BigDecimal R6_TOT_INS_UNP_SPC_TP;
	public BigDecimal R6_TOT_NO_HRS_BNK;
	public BigDecimal R6_TOT_NO_INC_SPC_TP;
	public BigDecimal R6_TOT_NO_PEN_SPC_TP;
	public BigDecimal R6_TOT_NO_AUT_SPC_TP;
	public BigDecimal R6_TOT_NO_SAL_SPC_TP;
	public BigDecimal R6_TOT_NO_MER_SPC_TP;
	public BigDecimal R6_NO_INQ_SPC_TP;
	public BigDecimal R6_NO_SER_SPC_TP;
	public String R7_BANK;
	public String R7_PRODUCT;
	public BigDecimal R7_NO_EMP_SPC_TP;
	public BigDecimal R7_NO_CON_SPC_TP;
	public BigDecimal R7_AVG_NO_EMP_SPC_TP;
	public BigDecimal R7_NO_BRN_SPC_TP;
	public BigDecimal R7_TOT_NO_BRN_POD;
	public BigDecimal R7_NO_ATM_SPC_TP;
	public BigDecimal R7_NO_ATM_DET_SPC_TP;
	public BigDecimal R7_NO_AUT_SPC_TP;
	public BigDecimal R7_NO_INS_BNK_SPC_TP;
	public BigDecimal R7_NO_INS_DWN_SPC_TP;
	public BigDecimal R7_NO_EMP_RSK_SPC_DTE;
	public BigDecimal R7_NO_EXT_FRD_SPC_TP;
	public BigDecimal R7_NO_INT_FRD_SPC_TP;
	public BigDecimal R7_NO_FRD_SPC_TP;
	public BigDecimal R7_NO_FRD_PP;
	public BigDecimal R7_TOT_REV_SPC_TP;
	public BigDecimal R7_TOT_INS_UNP_SPC_TP;
	public BigDecimal R7_TOT_NO_HRS_BNK;
	public BigDecimal R7_TOT_NO_INC_SPC_TP;
	public BigDecimal R7_TOT_NO_PEN_SPC_TP;
	public BigDecimal R7_TOT_NO_AUT_SPC_TP;
	public BigDecimal R7_TOT_NO_SAL_SPC_TP;
	public BigDecimal R7_TOT_NO_MER_SPC_TP;
	public BigDecimal R7_NO_INQ_SPC_TP;
	public BigDecimal R7_NO_SER_SPC_TP;
	public String R8_BANK;
	public String R8_PRODUCT;
	public BigDecimal R8_NO_EMP_SPC_TP;
	public BigDecimal R8_NO_CON_SPC_TP;
	public BigDecimal R8_AVG_NO_EMP_SPC_TP;
	public BigDecimal R8_NO_BRN_SPC_TP;
	public BigDecimal R8_TOT_NO_BRN_POD;
	public BigDecimal R8_NO_ATM_SPC_TP;
	public BigDecimal R8_NO_ATM_DET_SPC_TP;
	public BigDecimal R8_NO_AUT_SPC_TP;
	public BigDecimal R8_NO_INS_BNK_SPC_TP;
	public BigDecimal R8_NO_INS_DWN_SPC_TP;
	public BigDecimal R8_NO_EMP_RSK_SPC_DTE;
	public BigDecimal R8_NO_EXT_FRD_SPC_TP;
	public BigDecimal R8_NO_INT_FRD_SPC_TP;
	public BigDecimal R8_NO_FRD_SPC_TP;
	public BigDecimal R8_NO_FRD_PP;
	public BigDecimal R8_TOT_REV_SPC_TP;
	public BigDecimal R8_TOT_INS_UNP_SPC_TP;
	public BigDecimal R8_TOT_NO_HRS_BNK;
	public BigDecimal R8_TOT_NO_INC_SPC_TP;
	public BigDecimal R8_TOT_NO_PEN_SPC_TP;
	public BigDecimal R8_TOT_NO_AUT_SPC_TP;
	public BigDecimal R8_TOT_NO_SAL_SPC_TP;
	public BigDecimal R8_TOT_NO_MER_SPC_TP;
	public BigDecimal R8_NO_INQ_SPC_TP;
	public BigDecimal R8_NO_SER_SPC_TP;
	public String R9_BANK;
	public String R9_PRODUCT;
	public BigDecimal R9_NO_EMP_SPC_TP;
	public BigDecimal R9_NO_CON_SPC_TP;
	public BigDecimal R9_AVG_NO_EMP_SPC_TP;
	public BigDecimal R9_NO_BRN_SPC_TP;
	public BigDecimal R9_TOT_NO_BRN_POD;
	public BigDecimal R9_NO_ATM_SPC_TP;
	public BigDecimal R9_NO_ATM_DET_SPC_TP;
	public BigDecimal R9_NO_AUT_SPC_TP;
	public BigDecimal R9_NO_INS_BNK_SPC_TP;
	public BigDecimal R9_NO_INS_DWN_SPC_TP;
	public BigDecimal R9_NO_EMP_RSK_SPC_DTE;
	public BigDecimal R9_NO_EXT_FRD_SPC_TP;
	public BigDecimal R9_NO_INT_FRD_SPC_TP;
	public BigDecimal R9_NO_FRD_SPC_TP;
	public BigDecimal R9_NO_FRD_PP;
	public BigDecimal R9_TOT_REV_SPC_TP;
	public BigDecimal R9_TOT_INS_UNP_SPC_TP;
	public BigDecimal R9_TOT_NO_HRS_BNK;
	public BigDecimal R9_TOT_NO_INC_SPC_TP;
	public BigDecimal R9_TOT_NO_PEN_SPC_TP;
	public BigDecimal R9_TOT_NO_AUT_SPC_TP;
	public BigDecimal R9_TOT_NO_SAL_SPC_TP;
	public BigDecimal R9_TOT_NO_MER_SPC_TP;
	public BigDecimal R9_NO_INQ_SPC_TP;
	public BigDecimal R9_NO_SER_SPC_TP;
	public String R10_BANK;
	public String R10_PRODUCT;
	public BigDecimal R10_NO_EMP_SPC_TP;
	public BigDecimal R10_NO_CON_SPC_TP;
	public BigDecimal R10_AVG_NO_EMP_SPC_TP;
	public BigDecimal R10_NO_BRN_SPC_TP;
	public BigDecimal R10_TOT_NO_BRN_POD;
	public BigDecimal R10_NO_ATM_SPC_TP;
	public BigDecimal R10_NO_ATM_DET_SPC_TP;
	public BigDecimal R10_NO_AUT_SPC_TP;
	public BigDecimal R10_NO_INS_BNK_SPC_TP;
	public BigDecimal R10_NO_INS_DWN_SPC_TP;
	public BigDecimal R10_NO_EMP_RSK_SPC_DTE;
	public BigDecimal R10_NO_EXT_FRD_SPC_TP;
	public BigDecimal R10_NO_INT_FRD_SPC_TP;
	public BigDecimal R10_NO_FRD_SPC_TP;
	public BigDecimal R10_NO_FRD_PP;
	public BigDecimal R10_TOT_REV_SPC_TP;
	public BigDecimal R10_TOT_INS_UNP_SPC_TP;
	public BigDecimal R10_TOT_NO_HRS_BNK;
	public BigDecimal R10_TOT_NO_INC_SPC_TP;
	public BigDecimal R10_TOT_NO_PEN_SPC_TP;
	public BigDecimal R10_TOT_NO_AUT_SPC_TP;
	public BigDecimal R10_TOT_NO_SAL_SPC_TP;
	public BigDecimal R10_TOT_NO_MER_SPC_TP;
	public BigDecimal R10_NO_INQ_SPC_TP;
	public BigDecimal R10_NO_SER_SPC_TP;
	public String R11_BANK;
	public String R11_PRODUCT;
	public BigDecimal R11_NO_EMP_SPC_TP;
	public BigDecimal R11_NO_CON_SPC_TP;
	public BigDecimal R11_AVG_NO_EMP_SPC_TP;
	public BigDecimal R11_NO_BRN_SPC_TP;
	public BigDecimal R11_TOT_NO_BRN_POD;
	public BigDecimal R11_NO_ATM_SPC_TP;
	public BigDecimal R11_NO_ATM_DET_SPC_TP;
	public BigDecimal R11_NO_AUT_SPC_TP;
	public BigDecimal R11_NO_INS_BNK_SPC_TP;
	public BigDecimal R11_NO_INS_DWN_SPC_TP;
	public BigDecimal R11_NO_EMP_RSK_SPC_DTE;
	public BigDecimal R11_NO_EXT_FRD_SPC_TP;
	public BigDecimal R11_NO_INT_FRD_SPC_TP;
	public BigDecimal R11_NO_FRD_SPC_TP;
	public BigDecimal R11_NO_FRD_PP;
	public BigDecimal R11_TOT_REV_SPC_TP;
	public BigDecimal R11_TOT_INS_UNP_SPC_TP;
	public BigDecimal R11_TOT_NO_HRS_BNK;
	public BigDecimal R11_TOT_NO_INC_SPC_TP;
	public BigDecimal R11_TOT_NO_PEN_SPC_TP;
	public BigDecimal R11_TOT_NO_AUT_SPC_TP;
	public BigDecimal R11_TOT_NO_SAL_SPC_TP;
	public BigDecimal R11_TOT_NO_MER_SPC_TP;
	public BigDecimal R11_NO_INQ_SPC_TP;
	public BigDecimal R11_NO_SER_SPC_TP;
	public String R12_BANK;
	public String R12_PRODUCT;
	public BigDecimal R12_NO_EMP_SPC_TP;
	public BigDecimal R12_NO_CON_SPC_TP;
	public BigDecimal R12_AVG_NO_EMP_SPC_TP;
	public BigDecimal R12_NO_BRN_SPC_TP;
	public BigDecimal R12_TOT_NO_BRN_POD;
	public BigDecimal R12_NO_ATM_SPC_TP;
	public BigDecimal R12_NO_ATM_DET_SPC_TP;
	public BigDecimal R12_NO_AUT_SPC_TP;
	public BigDecimal R12_NO_INS_BNK_SPC_TP;
	public BigDecimal R12_NO_INS_DWN_SPC_TP;
	public BigDecimal R12_NO_EMP_RSK_SPC_DTE;
	public BigDecimal R12_NO_EXT_FRD_SPC_TP;
	public BigDecimal R12_NO_INT_FRD_SPC_TP;
	public BigDecimal R12_NO_FRD_SPC_TP;
	public BigDecimal R12_NO_FRD_PP;
	public BigDecimal R12_TOT_REV_SPC_TP;
	public BigDecimal R12_TOT_INS_UNP_SPC_TP;
	public BigDecimal R12_TOT_NO_HRS_BNK;
	public BigDecimal R12_TOT_NO_INC_SPC_TP;
	public BigDecimal R12_TOT_NO_PEN_SPC_TP;
	public BigDecimal R12_TOT_NO_AUT_SPC_TP;
	public BigDecimal R12_TOT_NO_SAL_SPC_TP;
	public BigDecimal R12_TOT_NO_MER_SPC_TP;
	public BigDecimal R12_NO_INQ_SPC_TP;
	public BigDecimal R12_NO_SER_SPC_TP;
	public String R13_BANK;
	public String R13_PRODUCT;
	public BigDecimal R13_NO_EMP_SPC_TP;
	public BigDecimal R13_NO_CON_SPC_TP;
	public BigDecimal R13_AVG_NO_EMP_SPC_TP;
	public BigDecimal R13_NO_BRN_SPC_TP;
	public BigDecimal R13_TOT_NO_BRN_POD;
	public BigDecimal R13_NO_ATM_SPC_TP;
	public BigDecimal R13_NO_ATM_DET_SPC_TP;
	public BigDecimal R13_NO_AUT_SPC_TP;
	public BigDecimal R13_NO_INS_BNK_SPC_TP;
	public BigDecimal R13_NO_INS_DWN_SPC_TP;
	public BigDecimal R13_NO_EMP_RSK_SPC_DTE;
	public BigDecimal R13_NO_EXT_FRD_SPC_TP;
	public BigDecimal R13_NO_INT_FRD_SPC_TP;
	public BigDecimal R13_NO_FRD_SPC_TP;
	public BigDecimal R13_NO_FRD_PP;
	public BigDecimal R13_TOT_REV_SPC_TP;
	public BigDecimal R13_TOT_INS_UNP_SPC_TP;
	public BigDecimal R13_TOT_NO_HRS_BNK;
	public BigDecimal R13_TOT_NO_INC_SPC_TP;
	public BigDecimal R13_TOT_NO_PEN_SPC_TP;
	public BigDecimal R13_TOT_NO_AUT_SPC_TP;
	public BigDecimal R13_TOT_NO_SAL_SPC_TP;
	public BigDecimal R13_TOT_NO_MER_SPC_TP;
	public BigDecimal R13_NO_INQ_SPC_TP;
	public BigDecimal R13_NO_SER_SPC_TP;
	public String R14_BANK;
	public String R14_PRODUCT;
	public BigDecimal R14_NO_EMP_SPC_TP;
	public BigDecimal R14_NO_CON_SPC_TP;
	public BigDecimal R14_AVG_NO_EMP_SPC_TP;
	public BigDecimal R14_NO_BRN_SPC_TP;
	public BigDecimal R14_TOT_NO_BRN_POD;
	public BigDecimal R14_NO_ATM_SPC_TP;
	public BigDecimal R14_NO_ATM_DET_SPC_TP;
	public BigDecimal R14_NO_AUT_SPC_TP;
	public BigDecimal R14_NO_INS_BNK_SPC_TP;
	public BigDecimal R14_NO_INS_DWN_SPC_TP;
	public BigDecimal R14_NO_EMP_RSK_SPC_DTE;
	public BigDecimal R14_NO_EXT_FRD_SPC_TP;
	public BigDecimal R14_NO_INT_FRD_SPC_TP;
	public BigDecimal R14_NO_FRD_SPC_TP;
	public BigDecimal R14_NO_FRD_PP;
	public BigDecimal R14_TOT_REV_SPC_TP;
	public BigDecimal R14_TOT_INS_UNP_SPC_TP;
	public BigDecimal R14_TOT_NO_HRS_BNK;
	public BigDecimal R14_TOT_NO_INC_SPC_TP;
	public BigDecimal R14_TOT_NO_PEN_SPC_TP;
	public BigDecimal R14_TOT_NO_AUT_SPC_TP;
	public BigDecimal R14_TOT_NO_SAL_SPC_TP;
	public BigDecimal R14_TOT_NO_MER_SPC_TP;
	public BigDecimal R14_NO_INQ_SPC_TP;
	public BigDecimal R14_NO_SER_SPC_TP;
	public String R15_BANK;
	public String R15_PRODUCT;
	public BigDecimal R15_NO_EMP_SPC_TP;
	public BigDecimal R15_NO_CON_SPC_TP;
	public BigDecimal R15_AVG_NO_EMP_SPC_TP;
	public BigDecimal R15_NO_BRN_SPC_TP;
	public BigDecimal R15_TOT_NO_BRN_POD;
	public BigDecimal R15_NO_ATM_SPC_TP;
	public BigDecimal R15_NO_ATM_DET_SPC_TP;
	public BigDecimal R15_NO_AUT_SPC_TP;
	public BigDecimal R15_NO_INS_BNK_SPC_TP;
	public BigDecimal R15_NO_INS_DWN_SPC_TP;
	public BigDecimal R15_NO_EMP_RSK_SPC_DTE;
	public BigDecimal R15_NO_EXT_FRD_SPC_TP;
	public BigDecimal R15_NO_INT_FRD_SPC_TP;
	public BigDecimal R15_NO_FRD_SPC_TP;
	public BigDecimal R15_NO_FRD_PP;
	public BigDecimal R15_TOT_REV_SPC_TP;
	public BigDecimal R15_TOT_INS_UNP_SPC_TP;
	public BigDecimal R15_TOT_NO_HRS_BNK;
	public BigDecimal R15_TOT_NO_INC_SPC_TP;
	public BigDecimal R15_TOT_NO_PEN_SPC_TP;
	public BigDecimal R15_TOT_NO_AUT_SPC_TP;
	public BigDecimal R15_TOT_NO_SAL_SPC_TP;
	public BigDecimal R15_TOT_NO_MER_SPC_TP;
	public BigDecimal R15_NO_INQ_SPC_TP;
	public BigDecimal R15_NO_SER_SPC_TP;
	public String R16_BANK;
	public String R16_PRODUCT;
	public BigDecimal R16_NO_EMP_SPC_TP;
	public BigDecimal R16_NO_CON_SPC_TP;
	public BigDecimal R16_AVG_NO_EMP_SPC_TP;
	public BigDecimal R16_NO_BRN_SPC_TP;
	public BigDecimal R16_TOT_NO_BRN_POD;
	public BigDecimal R16_NO_ATM_SPC_TP;
	public BigDecimal R16_NO_ATM_DET_SPC_TP;
	public BigDecimal R16_NO_AUT_SPC_TP;
	public BigDecimal R16_NO_INS_BNK_SPC_TP;
	public BigDecimal R16_NO_INS_DWN_SPC_TP;
	public BigDecimal R16_NO_EMP_RSK_SPC_DTE;
	public BigDecimal R16_NO_EXT_FRD_SPC_TP;
	public BigDecimal R16_NO_INT_FRD_SPC_TP;
	public BigDecimal R16_NO_FRD_SPC_TP;
	public BigDecimal R16_NO_FRD_PP;
	public BigDecimal R16_TOT_REV_SPC_TP;
	public BigDecimal R16_TOT_INS_UNP_SPC_TP;
	public BigDecimal R16_TOT_NO_HRS_BNK;
	public BigDecimal R16_TOT_NO_INC_SPC_TP;
	public BigDecimal R16_TOT_NO_PEN_SPC_TP;
	public BigDecimal R16_TOT_NO_AUT_SPC_TP;
	public BigDecimal R16_TOT_NO_SAL_SPC_TP;
	public BigDecimal R16_TOT_NO_MER_SPC_TP;
	public BigDecimal R16_NO_INQ_SPC_TP;
	public BigDecimal R16_NO_SER_SPC_TP;
	public String R17_BANK;
	public String R17_PRODUCT;
	public BigDecimal R17_NO_EMP_SPC_TP;
	public BigDecimal R17_NO_CON_SPC_TP;
	public BigDecimal R17_AVG_NO_EMP_SPC_TP;
	public BigDecimal R17_NO_BRN_SPC_TP;
	public BigDecimal R17_TOT_NO_BRN_POD;
	public BigDecimal R17_NO_ATM_SPC_TP;
	public BigDecimal R17_NO_ATM_DET_SPC_TP;
	public BigDecimal R17_NO_AUT_SPC_TP;
	public BigDecimal R17_NO_INS_BNK_SPC_TP;
	public BigDecimal R17_NO_INS_DWN_SPC_TP;
	public BigDecimal R17_NO_EMP_RSK_SPC_DTE;
	public BigDecimal R17_NO_EXT_FRD_SPC_TP;
	public BigDecimal R17_NO_INT_FRD_SPC_TP;
	public BigDecimal R17_NO_FRD_SPC_TP;
	public BigDecimal R17_NO_FRD_PP;
	public BigDecimal R17_TOT_REV_SPC_TP;
	public BigDecimal R17_TOT_INS_UNP_SPC_TP;
	public BigDecimal R17_TOT_NO_HRS_BNK;
	public BigDecimal R17_TOT_NO_INC_SPC_TP;
	public BigDecimal R17_TOT_NO_PEN_SPC_TP;
	public BigDecimal R17_TOT_NO_AUT_SPC_TP;
	public BigDecimal R17_TOT_NO_SAL_SPC_TP;
	public BigDecimal R17_TOT_NO_MER_SPC_TP;
	public BigDecimal R17_NO_INQ_SPC_TP;
	public BigDecimal R17_NO_SER_SPC_TP;
	public String R18_BANK;
	public String R18_PRODUCT;
	public BigDecimal R18_NO_EMP_SPC_TP;
	public BigDecimal R18_NO_CON_SPC_TP;
	public BigDecimal R18_AVG_NO_EMP_SPC_TP;
	public BigDecimal R18_NO_BRN_SPC_TP;
	public BigDecimal R18_TOT_NO_BRN_POD;
	public BigDecimal R18_NO_ATM_SPC_TP;
	public BigDecimal R18_NO_ATM_DET_SPC_TP;
	public BigDecimal R18_NO_AUT_SPC_TP;
	public BigDecimal R18_NO_INS_BNK_SPC_TP;
	public BigDecimal R18_NO_INS_DWN_SPC_TP;
	public BigDecimal R18_NO_EMP_RSK_SPC_DTE;
	public BigDecimal R18_NO_EXT_FRD_SPC_TP;
	public BigDecimal R18_NO_INT_FRD_SPC_TP;
	public BigDecimal R18_NO_FRD_SPC_TP;
	public BigDecimal R18_NO_FRD_PP;
	public BigDecimal R18_TOT_REV_SPC_TP;
	public BigDecimal R18_TOT_INS_UNP_SPC_TP;
	public BigDecimal R18_TOT_NO_HRS_BNK;
	public BigDecimal R18_TOT_NO_INC_SPC_TP;
	public BigDecimal R18_TOT_NO_PEN_SPC_TP;
	public BigDecimal R18_TOT_NO_AUT_SPC_TP;
	public BigDecimal R18_TOT_NO_SAL_SPC_TP;
	public BigDecimal R18_TOT_NO_MER_SPC_TP;
	public BigDecimal R18_NO_INQ_SPC_TP;
	public BigDecimal R18_NO_SER_SPC_TP;
	public String R19_BANK;
	public String R19_PRODUCT;
	public BigDecimal R19_NO_EMP_SPC_TP;
	public BigDecimal R19_NO_CON_SPC_TP;
	public BigDecimal R19_AVG_NO_EMP_SPC_TP;
	public BigDecimal R19_NO_BRN_SPC_TP;
	public BigDecimal R19_TOT_NO_BRN_POD;
	public BigDecimal R19_NO_ATM_SPC_TP;
	public BigDecimal R19_NO_ATM_DET_SPC_TP;
	public BigDecimal R19_NO_AUT_SPC_TP;
	public BigDecimal R19_NO_INS_BNK_SPC_TP;
	public BigDecimal R19_NO_INS_DWN_SPC_TP;
	public BigDecimal R19_NO_EMP_RSK_SPC_DTE;
	public BigDecimal R19_NO_EXT_FRD_SPC_TP;
	public BigDecimal R19_NO_INT_FRD_SPC_TP;
	public BigDecimal R19_NO_FRD_SPC_TP;
	public BigDecimal R19_NO_FRD_PP;
	public BigDecimal R19_TOT_REV_SPC_TP;
	public BigDecimal R19_TOT_INS_UNP_SPC_TP;
	public BigDecimal R19_TOT_NO_HRS_BNK;
	public BigDecimal R19_TOT_NO_INC_SPC_TP;
	public BigDecimal R19_TOT_NO_PEN_SPC_TP;
	public BigDecimal R19_TOT_NO_AUT_SPC_TP;
	public BigDecimal R19_TOT_NO_SAL_SPC_TP;
	public BigDecimal R19_TOT_NO_MER_SPC_TP;
	public BigDecimal R19_NO_INQ_SPC_TP;
	public BigDecimal R19_NO_SER_SPC_TP;
	public String R20_BANK;
	public String R20_PRODUCT;
	public BigDecimal R20_NO_EMP_SPC_TP;
	public BigDecimal R20_NO_CON_SPC_TP;
	public BigDecimal R20_AVG_NO_EMP_SPC_TP;
	public BigDecimal R20_NO_BRN_SPC_TP;
	public BigDecimal R20_TOT_NO_BRN_POD;
	public BigDecimal R20_NO_ATM_SPC_TP;
	public BigDecimal R20_NO_ATM_DET_SPC_TP;
	public BigDecimal R20_NO_AUT_SPC_TP;
	public BigDecimal R20_NO_INS_BNK_SPC_TP;
	public BigDecimal R20_NO_INS_DWN_SPC_TP;
	public BigDecimal R20_NO_EMP_RSK_SPC_DTE;
	public BigDecimal R20_NO_EXT_FRD_SPC_TP;
	public BigDecimal R20_NO_INT_FRD_SPC_TP;
	public BigDecimal R20_NO_FRD_SPC_TP;
	public BigDecimal R20_NO_FRD_PP;
	public BigDecimal R20_TOT_REV_SPC_TP;
	public BigDecimal R20_TOT_INS_UNP_SPC_TP;
	public BigDecimal R20_TOT_NO_HRS_BNK;
	public BigDecimal R20_TOT_NO_INC_SPC_TP;
	public BigDecimal R20_TOT_NO_PEN_SPC_TP;
	public BigDecimal R20_TOT_NO_AUT_SPC_TP;
	public BigDecimal R20_TOT_NO_SAL_SPC_TP;
	public BigDecimal R20_TOT_NO_MER_SPC_TP;
	public BigDecimal R20_NO_INQ_SPC_TP;
	public BigDecimal R20_NO_SER_SPC_TP;
	public String R21_BANK;
	public String R21_PRODUCT;
	public BigDecimal R21_NO_EMP_SPC_TP;
	public BigDecimal R21_NO_CON_SPC_TP;
	public BigDecimal R21_AVG_NO_EMP_SPC_TP;
	public BigDecimal R21_NO_BRN_SPC_TP;
	public BigDecimal R21_TOT_NO_BRN_POD;
	public BigDecimal R21_NO_ATM_SPC_TP;
	public BigDecimal R21_NO_ATM_DET_SPC_TP;
	public BigDecimal R21_NO_AUT_SPC_TP;
	public BigDecimal R21_NO_INS_BNK_SPC_TP;
	public BigDecimal R21_NO_INS_DWN_SPC_TP;
	public BigDecimal R21_NO_EMP_RSK_SPC_DTE;
	public BigDecimal R21_NO_EXT_FRD_SPC_TP;
	public BigDecimal R21_NO_INT_FRD_SPC_TP;
	public BigDecimal R21_NO_FRD_SPC_TP;
	public BigDecimal R21_NO_FRD_PP;
	public BigDecimal R21_TOT_REV_SPC_TP;
	public BigDecimal R21_TOT_INS_UNP_SPC_TP;
	public BigDecimal R21_TOT_NO_HRS_BNK;
	public BigDecimal R21_TOT_NO_INC_SPC_TP;
	public BigDecimal R21_TOT_NO_PEN_SPC_TP;
	public BigDecimal R21_TOT_NO_AUT_SPC_TP;
	public BigDecimal R21_TOT_NO_SAL_SPC_TP;
	public BigDecimal R21_TOT_NO_MER_SPC_TP;
	public BigDecimal R21_NO_INQ_SPC_TP;
	public BigDecimal R21_NO_SER_SPC_TP;
	public String R22_PRODUCT;
	public String R22_BANK;
	public String R22_NO_EMP_SPC_TP;
	public String R22_NO_CON_SPC_TP;
	public String R22_AVG_NO_EMP_SPC_TP;
	public String R22_NO_BRN_SPC_TP;
	public String R22_TOT_NO_BRN_POD;
	public String R22_NO_ATM_SPC_TP;
	public String R22_NO_ATM_DET_SPC_TP;
	public String R22_NO_AUT_SPC_TP;
	public String R22_NO_INS_BNK_SPC_TP;
	public String R22_NO_INS_DWN_SPC_TP;
	public String R22_NO_EMP_RSK_SPC_DTE;
	public String R22_NO_EXT_FRD_SPC_TP;
	public String R22_NO_INT_FRD_SPC_TP;
	public String R22_NO_FRD_SPC_TP;
	public String R22_NO_FRD_PP;
	public String R22_TOT_REV_SPC_TP;
	public String R22_TOT_INS_UNP_SPC_TP;
	public String R22_TOT_NO_HRS_BNK;
	public String R22_TOT_NO_INC_SPC_TP;
	public String R22_TOT_NO_PEN_SPC_TP;
	public String R22_TOT_NO_AUT_SPC_TP;
	public String R22_TOT_NO_SAL_SPC_TP;
	public String R22_TOT_NO_MER_SPC_TP;
	public String R22_NO_INQ_SPC_TP;
	public String R22_NO_SER_SPC_TP;
	public String R23_PRODUCT;
	public String R23_NO_EMP_SPC_TP;
	public String R23_NO_CON_SPC_TP;
	public String R23_AVG_NO_EMP_SPC_TP;
	public String R23_NO_BRN_SPC_TP;
	public String R23_TOT_NO_BRN_POD;
	public String R23_NO_ATM_SPC_TP;
	public String R23_NO_ATM_DET_SPC_TP;
	public String R23_NO_AUT_SPC_TP;
	public String R23_NO_INS_BNK_SPC_TP;
	public String R23_NO_INS_DWN_SPC_TP;
	public String R23_NO_EMP_RSK_SPC_DTE;
	public String R23_NO_EXT_FRD_SPC_TP;
	public String R23_NO_INT_FRD_SPC_TP;
	public String R23_NO_FRD_SPC_TP;
	public String R23_NO_FRD_PP;
	public String R23_TOT_REV_SPC_TP;
	public String R23_TOT_INS_UNP_SPC_TP;
	public String R23_TOT_NO_HRS_BNK;
	public String R23_TOT_NO_INC_SPC_TP;
	public String R23_TOT_NO_PEN_SPC_TP;
	public String R23_TOT_NO_AUT_SPC_TP;
	public String R23_TOT_NO_SAL_SPC_TP;
	public String R23_TOT_NO_MER_SPC_TP;
	public String R23_NO_INQ_SPC_TP;
	public String R23_NO_SER_SPC_TP;
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

	public BigDecimal getR6_NO_EMP_SPC_TP() {
		return R6_NO_EMP_SPC_TP;
	}

	public void setR6_NO_EMP_SPC_TP(BigDecimal r6_NO_EMP_SPC_TP) {
		R6_NO_EMP_SPC_TP = r6_NO_EMP_SPC_TP;
	}

	public BigDecimal getR6_NO_CON_SPC_TP() {
		return R6_NO_CON_SPC_TP;
	}

	public void setR6_NO_CON_SPC_TP(BigDecimal r6_NO_CON_SPC_TP) {
		R6_NO_CON_SPC_TP = r6_NO_CON_SPC_TP;
	}

	public BigDecimal getR6_AVG_NO_EMP_SPC_TP() {
		return R6_AVG_NO_EMP_SPC_TP;
	}

	public void setR6_AVG_NO_EMP_SPC_TP(BigDecimal r6_AVG_NO_EMP_SPC_TP) {
		R6_AVG_NO_EMP_SPC_TP = r6_AVG_NO_EMP_SPC_TP;
	}

	public BigDecimal getR6_NO_BRN_SPC_TP() {
		return R6_NO_BRN_SPC_TP;
	}

	public void setR6_NO_BRN_SPC_TP(BigDecimal r6_NO_BRN_SPC_TP) {
		R6_NO_BRN_SPC_TP = r6_NO_BRN_SPC_TP;
	}

	public BigDecimal getR6_TOT_NO_BRN_POD() {
		return R6_TOT_NO_BRN_POD;
	}

	public void setR6_TOT_NO_BRN_POD(BigDecimal r6_TOT_NO_BRN_POD) {
		R6_TOT_NO_BRN_POD = r6_TOT_NO_BRN_POD;
	}

	public BigDecimal getR6_NO_ATM_SPC_TP() {
		return R6_NO_ATM_SPC_TP;
	}

	public void setR6_NO_ATM_SPC_TP(BigDecimal r6_NO_ATM_SPC_TP) {
		R6_NO_ATM_SPC_TP = r6_NO_ATM_SPC_TP;
	}

	public BigDecimal getR6_NO_ATM_DET_SPC_TP() {
		return R6_NO_ATM_DET_SPC_TP;
	}

	public void setR6_NO_ATM_DET_SPC_TP(BigDecimal r6_NO_ATM_DET_SPC_TP) {
		R6_NO_ATM_DET_SPC_TP = r6_NO_ATM_DET_SPC_TP;
	}

	public BigDecimal getR6_NO_AUT_SPC_TP() {
		return R6_NO_AUT_SPC_TP;
	}

	public void setR6_NO_AUT_SPC_TP(BigDecimal r6_NO_AUT_SPC_TP) {
		R6_NO_AUT_SPC_TP = r6_NO_AUT_SPC_TP;
	}

	public BigDecimal getR6_NO_INS_BNK_SPC_TP() {
		return R6_NO_INS_BNK_SPC_TP;
	}

	public void setR6_NO_INS_BNK_SPC_TP(BigDecimal r6_NO_INS_BNK_SPC_TP) {
		R6_NO_INS_BNK_SPC_TP = r6_NO_INS_BNK_SPC_TP;
	}

	public BigDecimal getR6_NO_INS_DWN_SPC_TP() {
		return R6_NO_INS_DWN_SPC_TP;
	}

	public void setR6_NO_INS_DWN_SPC_TP(BigDecimal r6_NO_INS_DWN_SPC_TP) {
		R6_NO_INS_DWN_SPC_TP = r6_NO_INS_DWN_SPC_TP;
	}

	public BigDecimal getR6_NO_EMP_RSK_SPC_DTE() {
		return R6_NO_EMP_RSK_SPC_DTE;
	}

	public void setR6_NO_EMP_RSK_SPC_DTE(BigDecimal r6_NO_EMP_RSK_SPC_DTE) {
		R6_NO_EMP_RSK_SPC_DTE = r6_NO_EMP_RSK_SPC_DTE;
	}

	public BigDecimal getR6_NO_EXT_FRD_SPC_TP() {
		return R6_NO_EXT_FRD_SPC_TP;
	}

	public void setR6_NO_EXT_FRD_SPC_TP(BigDecimal r6_NO_EXT_FRD_SPC_TP) {
		R6_NO_EXT_FRD_SPC_TP = r6_NO_EXT_FRD_SPC_TP;
	}

	public BigDecimal getR6_NO_INT_FRD_SPC_TP() {
		return R6_NO_INT_FRD_SPC_TP;
	}

	public void setR6_NO_INT_FRD_SPC_TP(BigDecimal r6_NO_INT_FRD_SPC_TP) {
		R6_NO_INT_FRD_SPC_TP = r6_NO_INT_FRD_SPC_TP;
	}

	public BigDecimal getR6_NO_FRD_SPC_TP() {
		return R6_NO_FRD_SPC_TP;
	}

	public void setR6_NO_FRD_SPC_TP(BigDecimal r6_NO_FRD_SPC_TP) {
		R6_NO_FRD_SPC_TP = r6_NO_FRD_SPC_TP;
	}

	public BigDecimal getR6_NO_FRD_PP() {
		return R6_NO_FRD_PP;
	}

	public void setR6_NO_FRD_PP(BigDecimal r6_NO_FRD_PP) {
		R6_NO_FRD_PP = r6_NO_FRD_PP;
	}

	public BigDecimal getR6_TOT_REV_SPC_TP() {
		return R6_TOT_REV_SPC_TP;
	}

	public void setR6_TOT_REV_SPC_TP(BigDecimal r6_TOT_REV_SPC_TP) {
		R6_TOT_REV_SPC_TP = r6_TOT_REV_SPC_TP;
	}

	public BigDecimal getR6_TOT_INS_UNP_SPC_TP() {
		return R6_TOT_INS_UNP_SPC_TP;
	}

	public void setR6_TOT_INS_UNP_SPC_TP(BigDecimal r6_TOT_INS_UNP_SPC_TP) {
		R6_TOT_INS_UNP_SPC_TP = r6_TOT_INS_UNP_SPC_TP;
	}

	public BigDecimal getR6_TOT_NO_HRS_BNK() {
		return R6_TOT_NO_HRS_BNK;
	}

	public void setR6_TOT_NO_HRS_BNK(BigDecimal r6_TOT_NO_HRS_BNK) {
		R6_TOT_NO_HRS_BNK = r6_TOT_NO_HRS_BNK;
	}

	public BigDecimal getR6_TOT_NO_INC_SPC_TP() {
		return R6_TOT_NO_INC_SPC_TP;
	}

	public void setR6_TOT_NO_INC_SPC_TP(BigDecimal r6_TOT_NO_INC_SPC_TP) {
		R6_TOT_NO_INC_SPC_TP = r6_TOT_NO_INC_SPC_TP;
	}

	public BigDecimal getR6_TOT_NO_PEN_SPC_TP() {
		return R6_TOT_NO_PEN_SPC_TP;
	}

	public void setR6_TOT_NO_PEN_SPC_TP(BigDecimal r6_TOT_NO_PEN_SPC_TP) {
		R6_TOT_NO_PEN_SPC_TP = r6_TOT_NO_PEN_SPC_TP;
	}

	public BigDecimal getR6_TOT_NO_AUT_SPC_TP() {
		return R6_TOT_NO_AUT_SPC_TP;
	}

	public void setR6_TOT_NO_AUT_SPC_TP(BigDecimal r6_TOT_NO_AUT_SPC_TP) {
		R6_TOT_NO_AUT_SPC_TP = r6_TOT_NO_AUT_SPC_TP;
	}

	public BigDecimal getR6_TOT_NO_SAL_SPC_TP() {
		return R6_TOT_NO_SAL_SPC_TP;
	}

	public void setR6_TOT_NO_SAL_SPC_TP(BigDecimal r6_TOT_NO_SAL_SPC_TP) {
		R6_TOT_NO_SAL_SPC_TP = r6_TOT_NO_SAL_SPC_TP;
	}

	public BigDecimal getR6_TOT_NO_MER_SPC_TP() {
		return R6_TOT_NO_MER_SPC_TP;
	}

	public void setR6_TOT_NO_MER_SPC_TP(BigDecimal r6_TOT_NO_MER_SPC_TP) {
		R6_TOT_NO_MER_SPC_TP = r6_TOT_NO_MER_SPC_TP;
	}

	public BigDecimal getR6_NO_INQ_SPC_TP() {
		return R6_NO_INQ_SPC_TP;
	}

	public void setR6_NO_INQ_SPC_TP(BigDecimal r6_NO_INQ_SPC_TP) {
		R6_NO_INQ_SPC_TP = r6_NO_INQ_SPC_TP;
	}

	public BigDecimal getR6_NO_SER_SPC_TP() {
		return R6_NO_SER_SPC_TP;
	}

	public void setR6_NO_SER_SPC_TP(BigDecimal r6_NO_SER_SPC_TP) {
		R6_NO_SER_SPC_TP = r6_NO_SER_SPC_TP;
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

	public BigDecimal getR7_NO_EMP_SPC_TP() {
		return R7_NO_EMP_SPC_TP;
	}

	public void setR7_NO_EMP_SPC_TP(BigDecimal r7_NO_EMP_SPC_TP) {
		R7_NO_EMP_SPC_TP = r7_NO_EMP_SPC_TP;
	}

	public BigDecimal getR7_NO_CON_SPC_TP() {
		return R7_NO_CON_SPC_TP;
	}

	public void setR7_NO_CON_SPC_TP(BigDecimal r7_NO_CON_SPC_TP) {
		R7_NO_CON_SPC_TP = r7_NO_CON_SPC_TP;
	}

	public BigDecimal getR7_AVG_NO_EMP_SPC_TP() {
		return R7_AVG_NO_EMP_SPC_TP;
	}

	public void setR7_AVG_NO_EMP_SPC_TP(BigDecimal r7_AVG_NO_EMP_SPC_TP) {
		R7_AVG_NO_EMP_SPC_TP = r7_AVG_NO_EMP_SPC_TP;
	}

	public BigDecimal getR7_NO_BRN_SPC_TP() {
		return R7_NO_BRN_SPC_TP;
	}

	public void setR7_NO_BRN_SPC_TP(BigDecimal r7_NO_BRN_SPC_TP) {
		R7_NO_BRN_SPC_TP = r7_NO_BRN_SPC_TP;
	}

	public BigDecimal getR7_TOT_NO_BRN_POD() {
		return R7_TOT_NO_BRN_POD;
	}

	public void setR7_TOT_NO_BRN_POD(BigDecimal r7_TOT_NO_BRN_POD) {
		R7_TOT_NO_BRN_POD = r7_TOT_NO_BRN_POD;
	}

	public BigDecimal getR7_NO_ATM_SPC_TP() {
		return R7_NO_ATM_SPC_TP;
	}

	public void setR7_NO_ATM_SPC_TP(BigDecimal r7_NO_ATM_SPC_TP) {
		R7_NO_ATM_SPC_TP = r7_NO_ATM_SPC_TP;
	}

	public BigDecimal getR7_NO_ATM_DET_SPC_TP() {
		return R7_NO_ATM_DET_SPC_TP;
	}

	public void setR7_NO_ATM_DET_SPC_TP(BigDecimal r7_NO_ATM_DET_SPC_TP) {
		R7_NO_ATM_DET_SPC_TP = r7_NO_ATM_DET_SPC_TP;
	}

	public BigDecimal getR7_NO_AUT_SPC_TP() {
		return R7_NO_AUT_SPC_TP;
	}

	public void setR7_NO_AUT_SPC_TP(BigDecimal r7_NO_AUT_SPC_TP) {
		R7_NO_AUT_SPC_TP = r7_NO_AUT_SPC_TP;
	}

	public BigDecimal getR7_NO_INS_BNK_SPC_TP() {
		return R7_NO_INS_BNK_SPC_TP;
	}

	public void setR7_NO_INS_BNK_SPC_TP(BigDecimal r7_NO_INS_BNK_SPC_TP) {
		R7_NO_INS_BNK_SPC_TP = r7_NO_INS_BNK_SPC_TP;
	}

	public BigDecimal getR7_NO_INS_DWN_SPC_TP() {
		return R7_NO_INS_DWN_SPC_TP;
	}

	public void setR7_NO_INS_DWN_SPC_TP(BigDecimal r7_NO_INS_DWN_SPC_TP) {
		R7_NO_INS_DWN_SPC_TP = r7_NO_INS_DWN_SPC_TP;
	}

	public BigDecimal getR7_NO_EMP_RSK_SPC_DTE() {
		return R7_NO_EMP_RSK_SPC_DTE;
	}

	public void setR7_NO_EMP_RSK_SPC_DTE(BigDecimal r7_NO_EMP_RSK_SPC_DTE) {
		R7_NO_EMP_RSK_SPC_DTE = r7_NO_EMP_RSK_SPC_DTE;
	}

	public BigDecimal getR7_NO_EXT_FRD_SPC_TP() {
		return R7_NO_EXT_FRD_SPC_TP;
	}

	public void setR7_NO_EXT_FRD_SPC_TP(BigDecimal r7_NO_EXT_FRD_SPC_TP) {
		R7_NO_EXT_FRD_SPC_TP = r7_NO_EXT_FRD_SPC_TP;
	}

	public BigDecimal getR7_NO_INT_FRD_SPC_TP() {
		return R7_NO_INT_FRD_SPC_TP;
	}

	public void setR7_NO_INT_FRD_SPC_TP(BigDecimal r7_NO_INT_FRD_SPC_TP) {
		R7_NO_INT_FRD_SPC_TP = r7_NO_INT_FRD_SPC_TP;
	}

	public BigDecimal getR7_NO_FRD_SPC_TP() {
		return R7_NO_FRD_SPC_TP;
	}

	public void setR7_NO_FRD_SPC_TP(BigDecimal r7_NO_FRD_SPC_TP) {
		R7_NO_FRD_SPC_TP = r7_NO_FRD_SPC_TP;
	}

	public BigDecimal getR7_NO_FRD_PP() {
		return R7_NO_FRD_PP;
	}

	public void setR7_NO_FRD_PP(BigDecimal r7_NO_FRD_PP) {
		R7_NO_FRD_PP = r7_NO_FRD_PP;
	}

	public BigDecimal getR7_TOT_REV_SPC_TP() {
		return R7_TOT_REV_SPC_TP;
	}

	public void setR7_TOT_REV_SPC_TP(BigDecimal r7_TOT_REV_SPC_TP) {
		R7_TOT_REV_SPC_TP = r7_TOT_REV_SPC_TP;
	}

	public BigDecimal getR7_TOT_INS_UNP_SPC_TP() {
		return R7_TOT_INS_UNP_SPC_TP;
	}

	public void setR7_TOT_INS_UNP_SPC_TP(BigDecimal r7_TOT_INS_UNP_SPC_TP) {
		R7_TOT_INS_UNP_SPC_TP = r7_TOT_INS_UNP_SPC_TP;
	}

	public BigDecimal getR7_TOT_NO_HRS_BNK() {
		return R7_TOT_NO_HRS_BNK;
	}

	public void setR7_TOT_NO_HRS_BNK(BigDecimal r7_TOT_NO_HRS_BNK) {
		R7_TOT_NO_HRS_BNK = r7_TOT_NO_HRS_BNK;
	}

	public BigDecimal getR7_TOT_NO_INC_SPC_TP() {
		return R7_TOT_NO_INC_SPC_TP;
	}

	public void setR7_TOT_NO_INC_SPC_TP(BigDecimal r7_TOT_NO_INC_SPC_TP) {
		R7_TOT_NO_INC_SPC_TP = r7_TOT_NO_INC_SPC_TP;
	}

	public BigDecimal getR7_TOT_NO_PEN_SPC_TP() {
		return R7_TOT_NO_PEN_SPC_TP;
	}

	public void setR7_TOT_NO_PEN_SPC_TP(BigDecimal r7_TOT_NO_PEN_SPC_TP) {
		R7_TOT_NO_PEN_SPC_TP = r7_TOT_NO_PEN_SPC_TP;
	}

	public BigDecimal getR7_TOT_NO_AUT_SPC_TP() {
		return R7_TOT_NO_AUT_SPC_TP;
	}

	public void setR7_TOT_NO_AUT_SPC_TP(BigDecimal r7_TOT_NO_AUT_SPC_TP) {
		R7_TOT_NO_AUT_SPC_TP = r7_TOT_NO_AUT_SPC_TP;
	}

	public BigDecimal getR7_TOT_NO_SAL_SPC_TP() {
		return R7_TOT_NO_SAL_SPC_TP;
	}

	public void setR7_TOT_NO_SAL_SPC_TP(BigDecimal r7_TOT_NO_SAL_SPC_TP) {
		R7_TOT_NO_SAL_SPC_TP = r7_TOT_NO_SAL_SPC_TP;
	}

	public BigDecimal getR7_TOT_NO_MER_SPC_TP() {
		return R7_TOT_NO_MER_SPC_TP;
	}

	public void setR7_TOT_NO_MER_SPC_TP(BigDecimal r7_TOT_NO_MER_SPC_TP) {
		R7_TOT_NO_MER_SPC_TP = r7_TOT_NO_MER_SPC_TP;
	}

	public BigDecimal getR7_NO_INQ_SPC_TP() {
		return R7_NO_INQ_SPC_TP;
	}

	public void setR7_NO_INQ_SPC_TP(BigDecimal r7_NO_INQ_SPC_TP) {
		R7_NO_INQ_SPC_TP = r7_NO_INQ_SPC_TP;
	}

	public BigDecimal getR7_NO_SER_SPC_TP() {
		return R7_NO_SER_SPC_TP;
	}

	public void setR7_NO_SER_SPC_TP(BigDecimal r7_NO_SER_SPC_TP) {
		R7_NO_SER_SPC_TP = r7_NO_SER_SPC_TP;
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

	public BigDecimal getR8_NO_EMP_SPC_TP() {
		return R8_NO_EMP_SPC_TP;
	}

	public void setR8_NO_EMP_SPC_TP(BigDecimal r8_NO_EMP_SPC_TP) {
		R8_NO_EMP_SPC_TP = r8_NO_EMP_SPC_TP;
	}

	public BigDecimal getR8_NO_CON_SPC_TP() {
		return R8_NO_CON_SPC_TP;
	}

	public void setR8_NO_CON_SPC_TP(BigDecimal r8_NO_CON_SPC_TP) {
		R8_NO_CON_SPC_TP = r8_NO_CON_SPC_TP;
	}

	public BigDecimal getR8_AVG_NO_EMP_SPC_TP() {
		return R8_AVG_NO_EMP_SPC_TP;
	}

	public void setR8_AVG_NO_EMP_SPC_TP(BigDecimal r8_AVG_NO_EMP_SPC_TP) {
		R8_AVG_NO_EMP_SPC_TP = r8_AVG_NO_EMP_SPC_TP;
	}

	public BigDecimal getR8_NO_BRN_SPC_TP() {
		return R8_NO_BRN_SPC_TP;
	}

	public void setR8_NO_BRN_SPC_TP(BigDecimal r8_NO_BRN_SPC_TP) {
		R8_NO_BRN_SPC_TP = r8_NO_BRN_SPC_TP;
	}

	public BigDecimal getR8_TOT_NO_BRN_POD() {
		return R8_TOT_NO_BRN_POD;
	}

	public void setR8_TOT_NO_BRN_POD(BigDecimal r8_TOT_NO_BRN_POD) {
		R8_TOT_NO_BRN_POD = r8_TOT_NO_BRN_POD;
	}

	public BigDecimal getR8_NO_ATM_SPC_TP() {
		return R8_NO_ATM_SPC_TP;
	}

	public void setR8_NO_ATM_SPC_TP(BigDecimal r8_NO_ATM_SPC_TP) {
		R8_NO_ATM_SPC_TP = r8_NO_ATM_SPC_TP;
	}

	public BigDecimal getR8_NO_ATM_DET_SPC_TP() {
		return R8_NO_ATM_DET_SPC_TP;
	}

	public void setR8_NO_ATM_DET_SPC_TP(BigDecimal r8_NO_ATM_DET_SPC_TP) {
		R8_NO_ATM_DET_SPC_TP = r8_NO_ATM_DET_SPC_TP;
	}

	public BigDecimal getR8_NO_AUT_SPC_TP() {
		return R8_NO_AUT_SPC_TP;
	}

	public void setR8_NO_AUT_SPC_TP(BigDecimal r8_NO_AUT_SPC_TP) {
		R8_NO_AUT_SPC_TP = r8_NO_AUT_SPC_TP;
	}

	public BigDecimal getR8_NO_INS_BNK_SPC_TP() {
		return R8_NO_INS_BNK_SPC_TP;
	}

	public void setR8_NO_INS_BNK_SPC_TP(BigDecimal r8_NO_INS_BNK_SPC_TP) {
		R8_NO_INS_BNK_SPC_TP = r8_NO_INS_BNK_SPC_TP;
	}

	public BigDecimal getR8_NO_INS_DWN_SPC_TP() {
		return R8_NO_INS_DWN_SPC_TP;
	}

	public void setR8_NO_INS_DWN_SPC_TP(BigDecimal r8_NO_INS_DWN_SPC_TP) {
		R8_NO_INS_DWN_SPC_TP = r8_NO_INS_DWN_SPC_TP;
	}

	public BigDecimal getR8_NO_EMP_RSK_SPC_DTE() {
		return R8_NO_EMP_RSK_SPC_DTE;
	}

	public void setR8_NO_EMP_RSK_SPC_DTE(BigDecimal r8_NO_EMP_RSK_SPC_DTE) {
		R8_NO_EMP_RSK_SPC_DTE = r8_NO_EMP_RSK_SPC_DTE;
	}

	public BigDecimal getR8_NO_EXT_FRD_SPC_TP() {
		return R8_NO_EXT_FRD_SPC_TP;
	}

	public void setR8_NO_EXT_FRD_SPC_TP(BigDecimal r8_NO_EXT_FRD_SPC_TP) {
		R8_NO_EXT_FRD_SPC_TP = r8_NO_EXT_FRD_SPC_TP;
	}

	public BigDecimal getR8_NO_INT_FRD_SPC_TP() {
		return R8_NO_INT_FRD_SPC_TP;
	}

	public void setR8_NO_INT_FRD_SPC_TP(BigDecimal r8_NO_INT_FRD_SPC_TP) {
		R8_NO_INT_FRD_SPC_TP = r8_NO_INT_FRD_SPC_TP;
	}

	public BigDecimal getR8_NO_FRD_SPC_TP() {
		return R8_NO_FRD_SPC_TP;
	}

	public void setR8_NO_FRD_SPC_TP(BigDecimal r8_NO_FRD_SPC_TP) {
		R8_NO_FRD_SPC_TP = r8_NO_FRD_SPC_TP;
	}

	public BigDecimal getR8_NO_FRD_PP() {
		return R8_NO_FRD_PP;
	}

	public void setR8_NO_FRD_PP(BigDecimal r8_NO_FRD_PP) {
		R8_NO_FRD_PP = r8_NO_FRD_PP;
	}

	public BigDecimal getR8_TOT_REV_SPC_TP() {
		return R8_TOT_REV_SPC_TP;
	}

	public void setR8_TOT_REV_SPC_TP(BigDecimal r8_TOT_REV_SPC_TP) {
		R8_TOT_REV_SPC_TP = r8_TOT_REV_SPC_TP;
	}

	public BigDecimal getR8_TOT_INS_UNP_SPC_TP() {
		return R8_TOT_INS_UNP_SPC_TP;
	}

	public void setR8_TOT_INS_UNP_SPC_TP(BigDecimal r8_TOT_INS_UNP_SPC_TP) {
		R8_TOT_INS_UNP_SPC_TP = r8_TOT_INS_UNP_SPC_TP;
	}

	public BigDecimal getR8_TOT_NO_HRS_BNK() {
		return R8_TOT_NO_HRS_BNK;
	}

	public void setR8_TOT_NO_HRS_BNK(BigDecimal r8_TOT_NO_HRS_BNK) {
		R8_TOT_NO_HRS_BNK = r8_TOT_NO_HRS_BNK;
	}

	public BigDecimal getR8_TOT_NO_INC_SPC_TP() {
		return R8_TOT_NO_INC_SPC_TP;
	}

	public void setR8_TOT_NO_INC_SPC_TP(BigDecimal r8_TOT_NO_INC_SPC_TP) {
		R8_TOT_NO_INC_SPC_TP = r8_TOT_NO_INC_SPC_TP;
	}

	public BigDecimal getR8_TOT_NO_PEN_SPC_TP() {
		return R8_TOT_NO_PEN_SPC_TP;
	}

	public void setR8_TOT_NO_PEN_SPC_TP(BigDecimal r8_TOT_NO_PEN_SPC_TP) {
		R8_TOT_NO_PEN_SPC_TP = r8_TOT_NO_PEN_SPC_TP;
	}

	public BigDecimal getR8_TOT_NO_AUT_SPC_TP() {
		return R8_TOT_NO_AUT_SPC_TP;
	}

	public void setR8_TOT_NO_AUT_SPC_TP(BigDecimal r8_TOT_NO_AUT_SPC_TP) {
		R8_TOT_NO_AUT_SPC_TP = r8_TOT_NO_AUT_SPC_TP;
	}

	public BigDecimal getR8_TOT_NO_SAL_SPC_TP() {
		return R8_TOT_NO_SAL_SPC_TP;
	}

	public void setR8_TOT_NO_SAL_SPC_TP(BigDecimal r8_TOT_NO_SAL_SPC_TP) {
		R8_TOT_NO_SAL_SPC_TP = r8_TOT_NO_SAL_SPC_TP;
	}

	public BigDecimal getR8_TOT_NO_MER_SPC_TP() {
		return R8_TOT_NO_MER_SPC_TP;
	}

	public void setR8_TOT_NO_MER_SPC_TP(BigDecimal r8_TOT_NO_MER_SPC_TP) {
		R8_TOT_NO_MER_SPC_TP = r8_TOT_NO_MER_SPC_TP;
	}

	public BigDecimal getR8_NO_INQ_SPC_TP() {
		return R8_NO_INQ_SPC_TP;
	}

	public void setR8_NO_INQ_SPC_TP(BigDecimal r8_NO_INQ_SPC_TP) {
		R8_NO_INQ_SPC_TP = r8_NO_INQ_SPC_TP;
	}

	public BigDecimal getR8_NO_SER_SPC_TP() {
		return R8_NO_SER_SPC_TP;
	}

	public void setR8_NO_SER_SPC_TP(BigDecimal r8_NO_SER_SPC_TP) {
		R8_NO_SER_SPC_TP = r8_NO_SER_SPC_TP;
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

	public BigDecimal getR9_NO_EMP_SPC_TP() {
		return R9_NO_EMP_SPC_TP;
	}

	public void setR9_NO_EMP_SPC_TP(BigDecimal r9_NO_EMP_SPC_TP) {
		R9_NO_EMP_SPC_TP = r9_NO_EMP_SPC_TP;
	}

	public BigDecimal getR9_NO_CON_SPC_TP() {
		return R9_NO_CON_SPC_TP;
	}

	public void setR9_NO_CON_SPC_TP(BigDecimal r9_NO_CON_SPC_TP) {
		R9_NO_CON_SPC_TP = r9_NO_CON_SPC_TP;
	}

	public BigDecimal getR9_AVG_NO_EMP_SPC_TP() {
		return R9_AVG_NO_EMP_SPC_TP;
	}

	public void setR9_AVG_NO_EMP_SPC_TP(BigDecimal r9_AVG_NO_EMP_SPC_TP) {
		R9_AVG_NO_EMP_SPC_TP = r9_AVG_NO_EMP_SPC_TP;
	}

	public BigDecimal getR9_NO_BRN_SPC_TP() {
		return R9_NO_BRN_SPC_TP;
	}

	public void setR9_NO_BRN_SPC_TP(BigDecimal r9_NO_BRN_SPC_TP) {
		R9_NO_BRN_SPC_TP = r9_NO_BRN_SPC_TP;
	}

	public BigDecimal getR9_TOT_NO_BRN_POD() {
		return R9_TOT_NO_BRN_POD;
	}

	public void setR9_TOT_NO_BRN_POD(BigDecimal r9_TOT_NO_BRN_POD) {
		R9_TOT_NO_BRN_POD = r9_TOT_NO_BRN_POD;
	}

	public BigDecimal getR9_NO_ATM_SPC_TP() {
		return R9_NO_ATM_SPC_TP;
	}

	public void setR9_NO_ATM_SPC_TP(BigDecimal r9_NO_ATM_SPC_TP) {
		R9_NO_ATM_SPC_TP = r9_NO_ATM_SPC_TP;
	}

	public BigDecimal getR9_NO_ATM_DET_SPC_TP() {
		return R9_NO_ATM_DET_SPC_TP;
	}

	public void setR9_NO_ATM_DET_SPC_TP(BigDecimal r9_NO_ATM_DET_SPC_TP) {
		R9_NO_ATM_DET_SPC_TP = r9_NO_ATM_DET_SPC_TP;
	}

	public BigDecimal getR9_NO_AUT_SPC_TP() {
		return R9_NO_AUT_SPC_TP;
	}

	public void setR9_NO_AUT_SPC_TP(BigDecimal r9_NO_AUT_SPC_TP) {
		R9_NO_AUT_SPC_TP = r9_NO_AUT_SPC_TP;
	}

	public BigDecimal getR9_NO_INS_BNK_SPC_TP() {
		return R9_NO_INS_BNK_SPC_TP;
	}

	public void setR9_NO_INS_BNK_SPC_TP(BigDecimal r9_NO_INS_BNK_SPC_TP) {
		R9_NO_INS_BNK_SPC_TP = r9_NO_INS_BNK_SPC_TP;
	}

	public BigDecimal getR9_NO_INS_DWN_SPC_TP() {
		return R9_NO_INS_DWN_SPC_TP;
	}

	public void setR9_NO_INS_DWN_SPC_TP(BigDecimal r9_NO_INS_DWN_SPC_TP) {
		R9_NO_INS_DWN_SPC_TP = r9_NO_INS_DWN_SPC_TP;
	}

	public BigDecimal getR9_NO_EMP_RSK_SPC_DTE() {
		return R9_NO_EMP_RSK_SPC_DTE;
	}

	public void setR9_NO_EMP_RSK_SPC_DTE(BigDecimal r9_NO_EMP_RSK_SPC_DTE) {
		R9_NO_EMP_RSK_SPC_DTE = r9_NO_EMP_RSK_SPC_DTE;
	}

	public BigDecimal getR9_NO_EXT_FRD_SPC_TP() {
		return R9_NO_EXT_FRD_SPC_TP;
	}

	public void setR9_NO_EXT_FRD_SPC_TP(BigDecimal r9_NO_EXT_FRD_SPC_TP) {
		R9_NO_EXT_FRD_SPC_TP = r9_NO_EXT_FRD_SPC_TP;
	}

	public BigDecimal getR9_NO_INT_FRD_SPC_TP() {
		return R9_NO_INT_FRD_SPC_TP;
	}

	public void setR9_NO_INT_FRD_SPC_TP(BigDecimal r9_NO_INT_FRD_SPC_TP) {
		R9_NO_INT_FRD_SPC_TP = r9_NO_INT_FRD_SPC_TP;
	}

	public BigDecimal getR9_NO_FRD_SPC_TP() {
		return R9_NO_FRD_SPC_TP;
	}

	public void setR9_NO_FRD_SPC_TP(BigDecimal r9_NO_FRD_SPC_TP) {
		R9_NO_FRD_SPC_TP = r9_NO_FRD_SPC_TP;
	}

	public BigDecimal getR9_NO_FRD_PP() {
		return R9_NO_FRD_PP;
	}

	public void setR9_NO_FRD_PP(BigDecimal r9_NO_FRD_PP) {
		R9_NO_FRD_PP = r9_NO_FRD_PP;
	}

	public BigDecimal getR9_TOT_REV_SPC_TP() {
		return R9_TOT_REV_SPC_TP;
	}

	public void setR9_TOT_REV_SPC_TP(BigDecimal r9_TOT_REV_SPC_TP) {
		R9_TOT_REV_SPC_TP = r9_TOT_REV_SPC_TP;
	}

	public BigDecimal getR9_TOT_INS_UNP_SPC_TP() {
		return R9_TOT_INS_UNP_SPC_TP;
	}

	public void setR9_TOT_INS_UNP_SPC_TP(BigDecimal r9_TOT_INS_UNP_SPC_TP) {
		R9_TOT_INS_UNP_SPC_TP = r9_TOT_INS_UNP_SPC_TP;
	}

	public BigDecimal getR9_TOT_NO_HRS_BNK() {
		return R9_TOT_NO_HRS_BNK;
	}

	public void setR9_TOT_NO_HRS_BNK(BigDecimal r9_TOT_NO_HRS_BNK) {
		R9_TOT_NO_HRS_BNK = r9_TOT_NO_HRS_BNK;
	}

	public BigDecimal getR9_TOT_NO_INC_SPC_TP() {
		return R9_TOT_NO_INC_SPC_TP;
	}

	public void setR9_TOT_NO_INC_SPC_TP(BigDecimal r9_TOT_NO_INC_SPC_TP) {
		R9_TOT_NO_INC_SPC_TP = r9_TOT_NO_INC_SPC_TP;
	}

	public BigDecimal getR9_TOT_NO_PEN_SPC_TP() {
		return R9_TOT_NO_PEN_SPC_TP;
	}

	public void setR9_TOT_NO_PEN_SPC_TP(BigDecimal r9_TOT_NO_PEN_SPC_TP) {
		R9_TOT_NO_PEN_SPC_TP = r9_TOT_NO_PEN_SPC_TP;
	}

	public BigDecimal getR9_TOT_NO_AUT_SPC_TP() {
		return R9_TOT_NO_AUT_SPC_TP;
	}

	public void setR9_TOT_NO_AUT_SPC_TP(BigDecimal r9_TOT_NO_AUT_SPC_TP) {
		R9_TOT_NO_AUT_SPC_TP = r9_TOT_NO_AUT_SPC_TP;
	}

	public BigDecimal getR9_TOT_NO_SAL_SPC_TP() {
		return R9_TOT_NO_SAL_SPC_TP;
	}

	public void setR9_TOT_NO_SAL_SPC_TP(BigDecimal r9_TOT_NO_SAL_SPC_TP) {
		R9_TOT_NO_SAL_SPC_TP = r9_TOT_NO_SAL_SPC_TP;
	}

	public BigDecimal getR9_TOT_NO_MER_SPC_TP() {
		return R9_TOT_NO_MER_SPC_TP;
	}

	public void setR9_TOT_NO_MER_SPC_TP(BigDecimal r9_TOT_NO_MER_SPC_TP) {
		R9_TOT_NO_MER_SPC_TP = r9_TOT_NO_MER_SPC_TP;
	}

	public BigDecimal getR9_NO_INQ_SPC_TP() {
		return R9_NO_INQ_SPC_TP;
	}

	public void setR9_NO_INQ_SPC_TP(BigDecimal r9_NO_INQ_SPC_TP) {
		R9_NO_INQ_SPC_TP = r9_NO_INQ_SPC_TP;
	}

	public BigDecimal getR9_NO_SER_SPC_TP() {
		return R9_NO_SER_SPC_TP;
	}

	public void setR9_NO_SER_SPC_TP(BigDecimal r9_NO_SER_SPC_TP) {
		R9_NO_SER_SPC_TP = r9_NO_SER_SPC_TP;
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

	public BigDecimal getR10_NO_EMP_SPC_TP() {
		return R10_NO_EMP_SPC_TP;
	}

	public void setR10_NO_EMP_SPC_TP(BigDecimal r10_NO_EMP_SPC_TP) {
		R10_NO_EMP_SPC_TP = r10_NO_EMP_SPC_TP;
	}

	public BigDecimal getR10_NO_CON_SPC_TP() {
		return R10_NO_CON_SPC_TP;
	}

	public void setR10_NO_CON_SPC_TP(BigDecimal r10_NO_CON_SPC_TP) {
		R10_NO_CON_SPC_TP = r10_NO_CON_SPC_TP;
	}

	public BigDecimal getR10_AVG_NO_EMP_SPC_TP() {
		return R10_AVG_NO_EMP_SPC_TP;
	}

	public void setR10_AVG_NO_EMP_SPC_TP(BigDecimal r10_AVG_NO_EMP_SPC_TP) {
		R10_AVG_NO_EMP_SPC_TP = r10_AVG_NO_EMP_SPC_TP;
	}

	public BigDecimal getR10_NO_BRN_SPC_TP() {
		return R10_NO_BRN_SPC_TP;
	}

	public void setR10_NO_BRN_SPC_TP(BigDecimal r10_NO_BRN_SPC_TP) {
		R10_NO_BRN_SPC_TP = r10_NO_BRN_SPC_TP;
	}

	public BigDecimal getR10_TOT_NO_BRN_POD() {
		return R10_TOT_NO_BRN_POD;
	}

	public void setR10_TOT_NO_BRN_POD(BigDecimal r10_TOT_NO_BRN_POD) {
		R10_TOT_NO_BRN_POD = r10_TOT_NO_BRN_POD;
	}

	public BigDecimal getR10_NO_ATM_SPC_TP() {
		return R10_NO_ATM_SPC_TP;
	}

	public void setR10_NO_ATM_SPC_TP(BigDecimal r10_NO_ATM_SPC_TP) {
		R10_NO_ATM_SPC_TP = r10_NO_ATM_SPC_TP;
	}

	public BigDecimal getR10_NO_ATM_DET_SPC_TP() {
		return R10_NO_ATM_DET_SPC_TP;
	}

	public void setR10_NO_ATM_DET_SPC_TP(BigDecimal r10_NO_ATM_DET_SPC_TP) {
		R10_NO_ATM_DET_SPC_TP = r10_NO_ATM_DET_SPC_TP;
	}

	public BigDecimal getR10_NO_AUT_SPC_TP() {
		return R10_NO_AUT_SPC_TP;
	}

	public void setR10_NO_AUT_SPC_TP(BigDecimal r10_NO_AUT_SPC_TP) {
		R10_NO_AUT_SPC_TP = r10_NO_AUT_SPC_TP;
	}

	public BigDecimal getR10_NO_INS_BNK_SPC_TP() {
		return R10_NO_INS_BNK_SPC_TP;
	}

	public void setR10_NO_INS_BNK_SPC_TP(BigDecimal r10_NO_INS_BNK_SPC_TP) {
		R10_NO_INS_BNK_SPC_TP = r10_NO_INS_BNK_SPC_TP;
	}

	public BigDecimal getR10_NO_INS_DWN_SPC_TP() {
		return R10_NO_INS_DWN_SPC_TP;
	}

	public void setR10_NO_INS_DWN_SPC_TP(BigDecimal r10_NO_INS_DWN_SPC_TP) {
		R10_NO_INS_DWN_SPC_TP = r10_NO_INS_DWN_SPC_TP;
	}

	public BigDecimal getR10_NO_EMP_RSK_SPC_DTE() {
		return R10_NO_EMP_RSK_SPC_DTE;
	}

	public void setR10_NO_EMP_RSK_SPC_DTE(BigDecimal r10_NO_EMP_RSK_SPC_DTE) {
		R10_NO_EMP_RSK_SPC_DTE = r10_NO_EMP_RSK_SPC_DTE;
	}

	public BigDecimal getR10_NO_EXT_FRD_SPC_TP() {
		return R10_NO_EXT_FRD_SPC_TP;
	}

	public void setR10_NO_EXT_FRD_SPC_TP(BigDecimal r10_NO_EXT_FRD_SPC_TP) {
		R10_NO_EXT_FRD_SPC_TP = r10_NO_EXT_FRD_SPC_TP;
	}

	public BigDecimal getR10_NO_INT_FRD_SPC_TP() {
		return R10_NO_INT_FRD_SPC_TP;
	}

	public void setR10_NO_INT_FRD_SPC_TP(BigDecimal r10_NO_INT_FRD_SPC_TP) {
		R10_NO_INT_FRD_SPC_TP = r10_NO_INT_FRD_SPC_TP;
	}

	public BigDecimal getR10_NO_FRD_SPC_TP() {
		return R10_NO_FRD_SPC_TP;
	}

	public void setR10_NO_FRD_SPC_TP(BigDecimal r10_NO_FRD_SPC_TP) {
		R10_NO_FRD_SPC_TP = r10_NO_FRD_SPC_TP;
	}

	public BigDecimal getR10_NO_FRD_PP() {
		return R10_NO_FRD_PP;
	}

	public void setR10_NO_FRD_PP(BigDecimal r10_NO_FRD_PP) {
		R10_NO_FRD_PP = r10_NO_FRD_PP;
	}

	public BigDecimal getR10_TOT_REV_SPC_TP() {
		return R10_TOT_REV_SPC_TP;
	}

	public void setR10_TOT_REV_SPC_TP(BigDecimal r10_TOT_REV_SPC_TP) {
		R10_TOT_REV_SPC_TP = r10_TOT_REV_SPC_TP;
	}

	public BigDecimal getR10_TOT_INS_UNP_SPC_TP() {
		return R10_TOT_INS_UNP_SPC_TP;
	}

	public void setR10_TOT_INS_UNP_SPC_TP(BigDecimal r10_TOT_INS_UNP_SPC_TP) {
		R10_TOT_INS_UNP_SPC_TP = r10_TOT_INS_UNP_SPC_TP;
	}

	public BigDecimal getR10_TOT_NO_HRS_BNK() {
		return R10_TOT_NO_HRS_BNK;
	}

	public void setR10_TOT_NO_HRS_BNK(BigDecimal r10_TOT_NO_HRS_BNK) {
		R10_TOT_NO_HRS_BNK = r10_TOT_NO_HRS_BNK;
	}

	public BigDecimal getR10_TOT_NO_INC_SPC_TP() {
		return R10_TOT_NO_INC_SPC_TP;
	}

	public void setR10_TOT_NO_INC_SPC_TP(BigDecimal r10_TOT_NO_INC_SPC_TP) {
		R10_TOT_NO_INC_SPC_TP = r10_TOT_NO_INC_SPC_TP;
	}

	public BigDecimal getR10_TOT_NO_PEN_SPC_TP() {
		return R10_TOT_NO_PEN_SPC_TP;
	}

	public void setR10_TOT_NO_PEN_SPC_TP(BigDecimal r10_TOT_NO_PEN_SPC_TP) {
		R10_TOT_NO_PEN_SPC_TP = r10_TOT_NO_PEN_SPC_TP;
	}

	public BigDecimal getR10_TOT_NO_AUT_SPC_TP() {
		return R10_TOT_NO_AUT_SPC_TP;
	}

	public void setR10_TOT_NO_AUT_SPC_TP(BigDecimal r10_TOT_NO_AUT_SPC_TP) {
		R10_TOT_NO_AUT_SPC_TP = r10_TOT_NO_AUT_SPC_TP;
	}

	public BigDecimal getR10_TOT_NO_SAL_SPC_TP() {
		return R10_TOT_NO_SAL_SPC_TP;
	}

	public void setR10_TOT_NO_SAL_SPC_TP(BigDecimal r10_TOT_NO_SAL_SPC_TP) {
		R10_TOT_NO_SAL_SPC_TP = r10_TOT_NO_SAL_SPC_TP;
	}

	public BigDecimal getR10_TOT_NO_MER_SPC_TP() {
		return R10_TOT_NO_MER_SPC_TP;
	}

	public void setR10_TOT_NO_MER_SPC_TP(BigDecimal r10_TOT_NO_MER_SPC_TP) {
		R10_TOT_NO_MER_SPC_TP = r10_TOT_NO_MER_SPC_TP;
	}

	public BigDecimal getR10_NO_INQ_SPC_TP() {
		return R10_NO_INQ_SPC_TP;
	}

	public void setR10_NO_INQ_SPC_TP(BigDecimal r10_NO_INQ_SPC_TP) {
		R10_NO_INQ_SPC_TP = r10_NO_INQ_SPC_TP;
	}

	public BigDecimal getR10_NO_SER_SPC_TP() {
		return R10_NO_SER_SPC_TP;
	}

	public void setR10_NO_SER_SPC_TP(BigDecimal r10_NO_SER_SPC_TP) {
		R10_NO_SER_SPC_TP = r10_NO_SER_SPC_TP;
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

	public BigDecimal getR11_NO_EMP_SPC_TP() {
		return R11_NO_EMP_SPC_TP;
	}

	public void setR11_NO_EMP_SPC_TP(BigDecimal r11_NO_EMP_SPC_TP) {
		R11_NO_EMP_SPC_TP = r11_NO_EMP_SPC_TP;
	}

	public BigDecimal getR11_NO_CON_SPC_TP() {
		return R11_NO_CON_SPC_TP;
	}

	public void setR11_NO_CON_SPC_TP(BigDecimal r11_NO_CON_SPC_TP) {
		R11_NO_CON_SPC_TP = r11_NO_CON_SPC_TP;
	}

	public BigDecimal getR11_AVG_NO_EMP_SPC_TP() {
		return R11_AVG_NO_EMP_SPC_TP;
	}

	public void setR11_AVG_NO_EMP_SPC_TP(BigDecimal r11_AVG_NO_EMP_SPC_TP) {
		R11_AVG_NO_EMP_SPC_TP = r11_AVG_NO_EMP_SPC_TP;
	}

	public BigDecimal getR11_NO_BRN_SPC_TP() {
		return R11_NO_BRN_SPC_TP;
	}

	public void setR11_NO_BRN_SPC_TP(BigDecimal r11_NO_BRN_SPC_TP) {
		R11_NO_BRN_SPC_TP = r11_NO_BRN_SPC_TP;
	}

	public BigDecimal getR11_TOT_NO_BRN_POD() {
		return R11_TOT_NO_BRN_POD;
	}

	public void setR11_TOT_NO_BRN_POD(BigDecimal r11_TOT_NO_BRN_POD) {
		R11_TOT_NO_BRN_POD = r11_TOT_NO_BRN_POD;
	}

	public BigDecimal getR11_NO_ATM_SPC_TP() {
		return R11_NO_ATM_SPC_TP;
	}

	public void setR11_NO_ATM_SPC_TP(BigDecimal r11_NO_ATM_SPC_TP) {
		R11_NO_ATM_SPC_TP = r11_NO_ATM_SPC_TP;
	}

	public BigDecimal getR11_NO_ATM_DET_SPC_TP() {
		return R11_NO_ATM_DET_SPC_TP;
	}

	public void setR11_NO_ATM_DET_SPC_TP(BigDecimal r11_NO_ATM_DET_SPC_TP) {
		R11_NO_ATM_DET_SPC_TP = r11_NO_ATM_DET_SPC_TP;
	}

	public BigDecimal getR11_NO_AUT_SPC_TP() {
		return R11_NO_AUT_SPC_TP;
	}

	public void setR11_NO_AUT_SPC_TP(BigDecimal r11_NO_AUT_SPC_TP) {
		R11_NO_AUT_SPC_TP = r11_NO_AUT_SPC_TP;
	}

	public BigDecimal getR11_NO_INS_BNK_SPC_TP() {
		return R11_NO_INS_BNK_SPC_TP;
	}

	public void setR11_NO_INS_BNK_SPC_TP(BigDecimal r11_NO_INS_BNK_SPC_TP) {
		R11_NO_INS_BNK_SPC_TP = r11_NO_INS_BNK_SPC_TP;
	}

	public BigDecimal getR11_NO_INS_DWN_SPC_TP() {
		return R11_NO_INS_DWN_SPC_TP;
	}

	public void setR11_NO_INS_DWN_SPC_TP(BigDecimal r11_NO_INS_DWN_SPC_TP) {
		R11_NO_INS_DWN_SPC_TP = r11_NO_INS_DWN_SPC_TP;
	}

	public BigDecimal getR11_NO_EMP_RSK_SPC_DTE() {
		return R11_NO_EMP_RSK_SPC_DTE;
	}

	public void setR11_NO_EMP_RSK_SPC_DTE(BigDecimal r11_NO_EMP_RSK_SPC_DTE) {
		R11_NO_EMP_RSK_SPC_DTE = r11_NO_EMP_RSK_SPC_DTE;
	}

	public BigDecimal getR11_NO_EXT_FRD_SPC_TP() {
		return R11_NO_EXT_FRD_SPC_TP;
	}

	public void setR11_NO_EXT_FRD_SPC_TP(BigDecimal r11_NO_EXT_FRD_SPC_TP) {
		R11_NO_EXT_FRD_SPC_TP = r11_NO_EXT_FRD_SPC_TP;
	}

	public BigDecimal getR11_NO_INT_FRD_SPC_TP() {
		return R11_NO_INT_FRD_SPC_TP;
	}

	public void setR11_NO_INT_FRD_SPC_TP(BigDecimal r11_NO_INT_FRD_SPC_TP) {
		R11_NO_INT_FRD_SPC_TP = r11_NO_INT_FRD_SPC_TP;
	}

	public BigDecimal getR11_NO_FRD_SPC_TP() {
		return R11_NO_FRD_SPC_TP;
	}

	public void setR11_NO_FRD_SPC_TP(BigDecimal r11_NO_FRD_SPC_TP) {
		R11_NO_FRD_SPC_TP = r11_NO_FRD_SPC_TP;
	}

	public BigDecimal getR11_NO_FRD_PP() {
		return R11_NO_FRD_PP;
	}

	public void setR11_NO_FRD_PP(BigDecimal r11_NO_FRD_PP) {
		R11_NO_FRD_PP = r11_NO_FRD_PP;
	}

	public BigDecimal getR11_TOT_REV_SPC_TP() {
		return R11_TOT_REV_SPC_TP;
	}

	public void setR11_TOT_REV_SPC_TP(BigDecimal r11_TOT_REV_SPC_TP) {
		R11_TOT_REV_SPC_TP = r11_TOT_REV_SPC_TP;
	}

	public BigDecimal getR11_TOT_INS_UNP_SPC_TP() {
		return R11_TOT_INS_UNP_SPC_TP;
	}

	public void setR11_TOT_INS_UNP_SPC_TP(BigDecimal r11_TOT_INS_UNP_SPC_TP) {
		R11_TOT_INS_UNP_SPC_TP = r11_TOT_INS_UNP_SPC_TP;
	}

	public BigDecimal getR11_TOT_NO_HRS_BNK() {
		return R11_TOT_NO_HRS_BNK;
	}

	public void setR11_TOT_NO_HRS_BNK(BigDecimal r11_TOT_NO_HRS_BNK) {
		R11_TOT_NO_HRS_BNK = r11_TOT_NO_HRS_BNK;
	}

	public BigDecimal getR11_TOT_NO_INC_SPC_TP() {
		return R11_TOT_NO_INC_SPC_TP;
	}

	public void setR11_TOT_NO_INC_SPC_TP(BigDecimal r11_TOT_NO_INC_SPC_TP) {
		R11_TOT_NO_INC_SPC_TP = r11_TOT_NO_INC_SPC_TP;
	}

	public BigDecimal getR11_TOT_NO_PEN_SPC_TP() {
		return R11_TOT_NO_PEN_SPC_TP;
	}

	public void setR11_TOT_NO_PEN_SPC_TP(BigDecimal r11_TOT_NO_PEN_SPC_TP) {
		R11_TOT_NO_PEN_SPC_TP = r11_TOT_NO_PEN_SPC_TP;
	}

	public BigDecimal getR11_TOT_NO_AUT_SPC_TP() {
		return R11_TOT_NO_AUT_SPC_TP;
	}

	public void setR11_TOT_NO_AUT_SPC_TP(BigDecimal r11_TOT_NO_AUT_SPC_TP) {
		R11_TOT_NO_AUT_SPC_TP = r11_TOT_NO_AUT_SPC_TP;
	}

	public BigDecimal getR11_TOT_NO_SAL_SPC_TP() {
		return R11_TOT_NO_SAL_SPC_TP;
	}

	public void setR11_TOT_NO_SAL_SPC_TP(BigDecimal r11_TOT_NO_SAL_SPC_TP) {
		R11_TOT_NO_SAL_SPC_TP = r11_TOT_NO_SAL_SPC_TP;
	}

	public BigDecimal getR11_TOT_NO_MER_SPC_TP() {
		return R11_TOT_NO_MER_SPC_TP;
	}

	public void setR11_TOT_NO_MER_SPC_TP(BigDecimal r11_TOT_NO_MER_SPC_TP) {
		R11_TOT_NO_MER_SPC_TP = r11_TOT_NO_MER_SPC_TP;
	}

	public BigDecimal getR11_NO_INQ_SPC_TP() {
		return R11_NO_INQ_SPC_TP;
	}

	public void setR11_NO_INQ_SPC_TP(BigDecimal r11_NO_INQ_SPC_TP) {
		R11_NO_INQ_SPC_TP = r11_NO_INQ_SPC_TP;
	}

	public BigDecimal getR11_NO_SER_SPC_TP() {
		return R11_NO_SER_SPC_TP;
	}

	public void setR11_NO_SER_SPC_TP(BigDecimal r11_NO_SER_SPC_TP) {
		R11_NO_SER_SPC_TP = r11_NO_SER_SPC_TP;
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

	public BigDecimal getR12_NO_EMP_SPC_TP() {
		return R12_NO_EMP_SPC_TP;
	}

	public void setR12_NO_EMP_SPC_TP(BigDecimal r12_NO_EMP_SPC_TP) {
		R12_NO_EMP_SPC_TP = r12_NO_EMP_SPC_TP;
	}

	public BigDecimal getR12_NO_CON_SPC_TP() {
		return R12_NO_CON_SPC_TP;
	}

	public void setR12_NO_CON_SPC_TP(BigDecimal r12_NO_CON_SPC_TP) {
		R12_NO_CON_SPC_TP = r12_NO_CON_SPC_TP;
	}

	public BigDecimal getR12_AVG_NO_EMP_SPC_TP() {
		return R12_AVG_NO_EMP_SPC_TP;
	}

	public void setR12_AVG_NO_EMP_SPC_TP(BigDecimal r12_AVG_NO_EMP_SPC_TP) {
		R12_AVG_NO_EMP_SPC_TP = r12_AVG_NO_EMP_SPC_TP;
	}

	public BigDecimal getR12_NO_BRN_SPC_TP() {
		return R12_NO_BRN_SPC_TP;
	}

	public void setR12_NO_BRN_SPC_TP(BigDecimal r12_NO_BRN_SPC_TP) {
		R12_NO_BRN_SPC_TP = r12_NO_BRN_SPC_TP;
	}

	public BigDecimal getR12_TOT_NO_BRN_POD() {
		return R12_TOT_NO_BRN_POD;
	}

	public void setR12_TOT_NO_BRN_POD(BigDecimal r12_TOT_NO_BRN_POD) {
		R12_TOT_NO_BRN_POD = r12_TOT_NO_BRN_POD;
	}

	public BigDecimal getR12_NO_ATM_SPC_TP() {
		return R12_NO_ATM_SPC_TP;
	}

	public void setR12_NO_ATM_SPC_TP(BigDecimal r12_NO_ATM_SPC_TP) {
		R12_NO_ATM_SPC_TP = r12_NO_ATM_SPC_TP;
	}

	public BigDecimal getR12_NO_ATM_DET_SPC_TP() {
		return R12_NO_ATM_DET_SPC_TP;
	}

	public void setR12_NO_ATM_DET_SPC_TP(BigDecimal r12_NO_ATM_DET_SPC_TP) {
		R12_NO_ATM_DET_SPC_TP = r12_NO_ATM_DET_SPC_TP;
	}

	public BigDecimal getR12_NO_AUT_SPC_TP() {
		return R12_NO_AUT_SPC_TP;
	}

	public void setR12_NO_AUT_SPC_TP(BigDecimal r12_NO_AUT_SPC_TP) {
		R12_NO_AUT_SPC_TP = r12_NO_AUT_SPC_TP;
	}

	public BigDecimal getR12_NO_INS_BNK_SPC_TP() {
		return R12_NO_INS_BNK_SPC_TP;
	}

	public void setR12_NO_INS_BNK_SPC_TP(BigDecimal r12_NO_INS_BNK_SPC_TP) {
		R12_NO_INS_BNK_SPC_TP = r12_NO_INS_BNK_SPC_TP;
	}

	public BigDecimal getR12_NO_INS_DWN_SPC_TP() {
		return R12_NO_INS_DWN_SPC_TP;
	}

	public void setR12_NO_INS_DWN_SPC_TP(BigDecimal r12_NO_INS_DWN_SPC_TP) {
		R12_NO_INS_DWN_SPC_TP = r12_NO_INS_DWN_SPC_TP;
	}

	public BigDecimal getR12_NO_EMP_RSK_SPC_DTE() {
		return R12_NO_EMP_RSK_SPC_DTE;
	}

	public void setR12_NO_EMP_RSK_SPC_DTE(BigDecimal r12_NO_EMP_RSK_SPC_DTE) {
		R12_NO_EMP_RSK_SPC_DTE = r12_NO_EMP_RSK_SPC_DTE;
	}

	public BigDecimal getR12_NO_EXT_FRD_SPC_TP() {
		return R12_NO_EXT_FRD_SPC_TP;
	}

	public void setR12_NO_EXT_FRD_SPC_TP(BigDecimal r12_NO_EXT_FRD_SPC_TP) {
		R12_NO_EXT_FRD_SPC_TP = r12_NO_EXT_FRD_SPC_TP;
	}

	public BigDecimal getR12_NO_INT_FRD_SPC_TP() {
		return R12_NO_INT_FRD_SPC_TP;
	}

	public void setR12_NO_INT_FRD_SPC_TP(BigDecimal r12_NO_INT_FRD_SPC_TP) {
		R12_NO_INT_FRD_SPC_TP = r12_NO_INT_FRD_SPC_TP;
	}

	public BigDecimal getR12_NO_FRD_SPC_TP() {
		return R12_NO_FRD_SPC_TP;
	}

	public void setR12_NO_FRD_SPC_TP(BigDecimal r12_NO_FRD_SPC_TP) {
		R12_NO_FRD_SPC_TP = r12_NO_FRD_SPC_TP;
	}

	public BigDecimal getR12_NO_FRD_PP() {
		return R12_NO_FRD_PP;
	}

	public void setR12_NO_FRD_PP(BigDecimal r12_NO_FRD_PP) {
		R12_NO_FRD_PP = r12_NO_FRD_PP;
	}

	public BigDecimal getR12_TOT_REV_SPC_TP() {
		return R12_TOT_REV_SPC_TP;
	}

	public void setR12_TOT_REV_SPC_TP(BigDecimal r12_TOT_REV_SPC_TP) {
		R12_TOT_REV_SPC_TP = r12_TOT_REV_SPC_TP;
	}

	public BigDecimal getR12_TOT_INS_UNP_SPC_TP() {
		return R12_TOT_INS_UNP_SPC_TP;
	}

	public void setR12_TOT_INS_UNP_SPC_TP(BigDecimal r12_TOT_INS_UNP_SPC_TP) {
		R12_TOT_INS_UNP_SPC_TP = r12_TOT_INS_UNP_SPC_TP;
	}

	public BigDecimal getR12_TOT_NO_HRS_BNK() {
		return R12_TOT_NO_HRS_BNK;
	}

	public void setR12_TOT_NO_HRS_BNK(BigDecimal r12_TOT_NO_HRS_BNK) {
		R12_TOT_NO_HRS_BNK = r12_TOT_NO_HRS_BNK;
	}

	public BigDecimal getR12_TOT_NO_INC_SPC_TP() {
		return R12_TOT_NO_INC_SPC_TP;
	}

	public void setR12_TOT_NO_INC_SPC_TP(BigDecimal r12_TOT_NO_INC_SPC_TP) {
		R12_TOT_NO_INC_SPC_TP = r12_TOT_NO_INC_SPC_TP;
	}

	public BigDecimal getR12_TOT_NO_PEN_SPC_TP() {
		return R12_TOT_NO_PEN_SPC_TP;
	}

	public void setR12_TOT_NO_PEN_SPC_TP(BigDecimal r12_TOT_NO_PEN_SPC_TP) {
		R12_TOT_NO_PEN_SPC_TP = r12_TOT_NO_PEN_SPC_TP;
	}

	public BigDecimal getR12_TOT_NO_AUT_SPC_TP() {
		return R12_TOT_NO_AUT_SPC_TP;
	}

	public void setR12_TOT_NO_AUT_SPC_TP(BigDecimal r12_TOT_NO_AUT_SPC_TP) {
		R12_TOT_NO_AUT_SPC_TP = r12_TOT_NO_AUT_SPC_TP;
	}

	public BigDecimal getR12_TOT_NO_SAL_SPC_TP() {
		return R12_TOT_NO_SAL_SPC_TP;
	}

	public void setR12_TOT_NO_SAL_SPC_TP(BigDecimal r12_TOT_NO_SAL_SPC_TP) {
		R12_TOT_NO_SAL_SPC_TP = r12_TOT_NO_SAL_SPC_TP;
	}

	public BigDecimal getR12_TOT_NO_MER_SPC_TP() {
		return R12_TOT_NO_MER_SPC_TP;
	}

	public void setR12_TOT_NO_MER_SPC_TP(BigDecimal r12_TOT_NO_MER_SPC_TP) {
		R12_TOT_NO_MER_SPC_TP = r12_TOT_NO_MER_SPC_TP;
	}

	public BigDecimal getR12_NO_INQ_SPC_TP() {
		return R12_NO_INQ_SPC_TP;
	}

	public void setR12_NO_INQ_SPC_TP(BigDecimal r12_NO_INQ_SPC_TP) {
		R12_NO_INQ_SPC_TP = r12_NO_INQ_SPC_TP;
	}

	public BigDecimal getR12_NO_SER_SPC_TP() {
		return R12_NO_SER_SPC_TP;
	}

	public void setR12_NO_SER_SPC_TP(BigDecimal r12_NO_SER_SPC_TP) {
		R12_NO_SER_SPC_TP = r12_NO_SER_SPC_TP;
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

	public BigDecimal getR13_NO_EMP_SPC_TP() {
		return R13_NO_EMP_SPC_TP;
	}

	public void setR13_NO_EMP_SPC_TP(BigDecimal r13_NO_EMP_SPC_TP) {
		R13_NO_EMP_SPC_TP = r13_NO_EMP_SPC_TP;
	}

	public BigDecimal getR13_NO_CON_SPC_TP() {
		return R13_NO_CON_SPC_TP;
	}

	public void setR13_NO_CON_SPC_TP(BigDecimal r13_NO_CON_SPC_TP) {
		R13_NO_CON_SPC_TP = r13_NO_CON_SPC_TP;
	}

	public BigDecimal getR13_AVG_NO_EMP_SPC_TP() {
		return R13_AVG_NO_EMP_SPC_TP;
	}

	public void setR13_AVG_NO_EMP_SPC_TP(BigDecimal r13_AVG_NO_EMP_SPC_TP) {
		R13_AVG_NO_EMP_SPC_TP = r13_AVG_NO_EMP_SPC_TP;
	}

	public BigDecimal getR13_NO_BRN_SPC_TP() {
		return R13_NO_BRN_SPC_TP;
	}

	public void setR13_NO_BRN_SPC_TP(BigDecimal r13_NO_BRN_SPC_TP) {
		R13_NO_BRN_SPC_TP = r13_NO_BRN_SPC_TP;
	}

	public BigDecimal getR13_TOT_NO_BRN_POD() {
		return R13_TOT_NO_BRN_POD;
	}

	public void setR13_TOT_NO_BRN_POD(BigDecimal r13_TOT_NO_BRN_POD) {
		R13_TOT_NO_BRN_POD = r13_TOT_NO_BRN_POD;
	}

	public BigDecimal getR13_NO_ATM_SPC_TP() {
		return R13_NO_ATM_SPC_TP;
	}

	public void setR13_NO_ATM_SPC_TP(BigDecimal r13_NO_ATM_SPC_TP) {
		R13_NO_ATM_SPC_TP = r13_NO_ATM_SPC_TP;
	}

	public BigDecimal getR13_NO_ATM_DET_SPC_TP() {
		return R13_NO_ATM_DET_SPC_TP;
	}

	public void setR13_NO_ATM_DET_SPC_TP(BigDecimal r13_NO_ATM_DET_SPC_TP) {
		R13_NO_ATM_DET_SPC_TP = r13_NO_ATM_DET_SPC_TP;
	}

	public BigDecimal getR13_NO_AUT_SPC_TP() {
		return R13_NO_AUT_SPC_TP;
	}

	public void setR13_NO_AUT_SPC_TP(BigDecimal r13_NO_AUT_SPC_TP) {
		R13_NO_AUT_SPC_TP = r13_NO_AUT_SPC_TP;
	}

	public BigDecimal getR13_NO_INS_BNK_SPC_TP() {
		return R13_NO_INS_BNK_SPC_TP;
	}

	public void setR13_NO_INS_BNK_SPC_TP(BigDecimal r13_NO_INS_BNK_SPC_TP) {
		R13_NO_INS_BNK_SPC_TP = r13_NO_INS_BNK_SPC_TP;
	}

	public BigDecimal getR13_NO_INS_DWN_SPC_TP() {
		return R13_NO_INS_DWN_SPC_TP;
	}

	public void setR13_NO_INS_DWN_SPC_TP(BigDecimal r13_NO_INS_DWN_SPC_TP) {
		R13_NO_INS_DWN_SPC_TP = r13_NO_INS_DWN_SPC_TP;
	}

	public BigDecimal getR13_NO_EMP_RSK_SPC_DTE() {
		return R13_NO_EMP_RSK_SPC_DTE;
	}

	public void setR13_NO_EMP_RSK_SPC_DTE(BigDecimal r13_NO_EMP_RSK_SPC_DTE) {
		R13_NO_EMP_RSK_SPC_DTE = r13_NO_EMP_RSK_SPC_DTE;
	}

	public BigDecimal getR13_NO_EXT_FRD_SPC_TP() {
		return R13_NO_EXT_FRD_SPC_TP;
	}

	public void setR13_NO_EXT_FRD_SPC_TP(BigDecimal r13_NO_EXT_FRD_SPC_TP) {
		R13_NO_EXT_FRD_SPC_TP = r13_NO_EXT_FRD_SPC_TP;
	}

	public BigDecimal getR13_NO_INT_FRD_SPC_TP() {
		return R13_NO_INT_FRD_SPC_TP;
	}

	public void setR13_NO_INT_FRD_SPC_TP(BigDecimal r13_NO_INT_FRD_SPC_TP) {
		R13_NO_INT_FRD_SPC_TP = r13_NO_INT_FRD_SPC_TP;
	}

	public BigDecimal getR13_NO_FRD_SPC_TP() {
		return R13_NO_FRD_SPC_TP;
	}

	public void setR13_NO_FRD_SPC_TP(BigDecimal r13_NO_FRD_SPC_TP) {
		R13_NO_FRD_SPC_TP = r13_NO_FRD_SPC_TP;
	}

	public BigDecimal getR13_NO_FRD_PP() {
		return R13_NO_FRD_PP;
	}

	public void setR13_NO_FRD_PP(BigDecimal r13_NO_FRD_PP) {
		R13_NO_FRD_PP = r13_NO_FRD_PP;
	}

	public BigDecimal getR13_TOT_REV_SPC_TP() {
		return R13_TOT_REV_SPC_TP;
	}

	public void setR13_TOT_REV_SPC_TP(BigDecimal r13_TOT_REV_SPC_TP) {
		R13_TOT_REV_SPC_TP = r13_TOT_REV_SPC_TP;
	}

	public BigDecimal getR13_TOT_INS_UNP_SPC_TP() {
		return R13_TOT_INS_UNP_SPC_TP;
	}

	public void setR13_TOT_INS_UNP_SPC_TP(BigDecimal r13_TOT_INS_UNP_SPC_TP) {
		R13_TOT_INS_UNP_SPC_TP = r13_TOT_INS_UNP_SPC_TP;
	}

	public BigDecimal getR13_TOT_NO_HRS_BNK() {
		return R13_TOT_NO_HRS_BNK;
	}

	public void setR13_TOT_NO_HRS_BNK(BigDecimal r13_TOT_NO_HRS_BNK) {
		R13_TOT_NO_HRS_BNK = r13_TOT_NO_HRS_BNK;
	}

	public BigDecimal getR13_TOT_NO_INC_SPC_TP() {
		return R13_TOT_NO_INC_SPC_TP;
	}

	public void setR13_TOT_NO_INC_SPC_TP(BigDecimal r13_TOT_NO_INC_SPC_TP) {
		R13_TOT_NO_INC_SPC_TP = r13_TOT_NO_INC_SPC_TP;
	}

	public BigDecimal getR13_TOT_NO_PEN_SPC_TP() {
		return R13_TOT_NO_PEN_SPC_TP;
	}

	public void setR13_TOT_NO_PEN_SPC_TP(BigDecimal r13_TOT_NO_PEN_SPC_TP) {
		R13_TOT_NO_PEN_SPC_TP = r13_TOT_NO_PEN_SPC_TP;
	}

	public BigDecimal getR13_TOT_NO_AUT_SPC_TP() {
		return R13_TOT_NO_AUT_SPC_TP;
	}

	public void setR13_TOT_NO_AUT_SPC_TP(BigDecimal r13_TOT_NO_AUT_SPC_TP) {
		R13_TOT_NO_AUT_SPC_TP = r13_TOT_NO_AUT_SPC_TP;
	}

	public BigDecimal getR13_TOT_NO_SAL_SPC_TP() {
		return R13_TOT_NO_SAL_SPC_TP;
	}

	public void setR13_TOT_NO_SAL_SPC_TP(BigDecimal r13_TOT_NO_SAL_SPC_TP) {
		R13_TOT_NO_SAL_SPC_TP = r13_TOT_NO_SAL_SPC_TP;
	}

	public BigDecimal getR13_TOT_NO_MER_SPC_TP() {
		return R13_TOT_NO_MER_SPC_TP;
	}

	public void setR13_TOT_NO_MER_SPC_TP(BigDecimal r13_TOT_NO_MER_SPC_TP) {
		R13_TOT_NO_MER_SPC_TP = r13_TOT_NO_MER_SPC_TP;
	}

	public BigDecimal getR13_NO_INQ_SPC_TP() {
		return R13_NO_INQ_SPC_TP;
	}

	public void setR13_NO_INQ_SPC_TP(BigDecimal r13_NO_INQ_SPC_TP) {
		R13_NO_INQ_SPC_TP = r13_NO_INQ_SPC_TP;
	}

	public BigDecimal getR13_NO_SER_SPC_TP() {
		return R13_NO_SER_SPC_TP;
	}

	public void setR13_NO_SER_SPC_TP(BigDecimal r13_NO_SER_SPC_TP) {
		R13_NO_SER_SPC_TP = r13_NO_SER_SPC_TP;
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

	public BigDecimal getR14_NO_EMP_SPC_TP() {
		return R14_NO_EMP_SPC_TP;
	}

	public void setR14_NO_EMP_SPC_TP(BigDecimal r14_NO_EMP_SPC_TP) {
		R14_NO_EMP_SPC_TP = r14_NO_EMP_SPC_TP;
	}

	public BigDecimal getR14_NO_CON_SPC_TP() {
		return R14_NO_CON_SPC_TP;
	}

	public void setR14_NO_CON_SPC_TP(BigDecimal r14_NO_CON_SPC_TP) {
		R14_NO_CON_SPC_TP = r14_NO_CON_SPC_TP;
	}

	public BigDecimal getR14_AVG_NO_EMP_SPC_TP() {
		return R14_AVG_NO_EMP_SPC_TP;
	}

	public void setR14_AVG_NO_EMP_SPC_TP(BigDecimal r14_AVG_NO_EMP_SPC_TP) {
		R14_AVG_NO_EMP_SPC_TP = r14_AVG_NO_EMP_SPC_TP;
	}

	public BigDecimal getR14_NO_BRN_SPC_TP() {
		return R14_NO_BRN_SPC_TP;
	}

	public void setR14_NO_BRN_SPC_TP(BigDecimal r14_NO_BRN_SPC_TP) {
		R14_NO_BRN_SPC_TP = r14_NO_BRN_SPC_TP;
	}

	public BigDecimal getR14_TOT_NO_BRN_POD() {
		return R14_TOT_NO_BRN_POD;
	}

	public void setR14_TOT_NO_BRN_POD(BigDecimal r14_TOT_NO_BRN_POD) {
		R14_TOT_NO_BRN_POD = r14_TOT_NO_BRN_POD;
	}

	public BigDecimal getR14_NO_ATM_SPC_TP() {
		return R14_NO_ATM_SPC_TP;
	}

	public void setR14_NO_ATM_SPC_TP(BigDecimal r14_NO_ATM_SPC_TP) {
		R14_NO_ATM_SPC_TP = r14_NO_ATM_SPC_TP;
	}

	public BigDecimal getR14_NO_ATM_DET_SPC_TP() {
		return R14_NO_ATM_DET_SPC_TP;
	}

	public void setR14_NO_ATM_DET_SPC_TP(BigDecimal r14_NO_ATM_DET_SPC_TP) {
		R14_NO_ATM_DET_SPC_TP = r14_NO_ATM_DET_SPC_TP;
	}

	public BigDecimal getR14_NO_AUT_SPC_TP() {
		return R14_NO_AUT_SPC_TP;
	}

	public void setR14_NO_AUT_SPC_TP(BigDecimal r14_NO_AUT_SPC_TP) {
		R14_NO_AUT_SPC_TP = r14_NO_AUT_SPC_TP;
	}

	public BigDecimal getR14_NO_INS_BNK_SPC_TP() {
		return R14_NO_INS_BNK_SPC_TP;
	}

	public void setR14_NO_INS_BNK_SPC_TP(BigDecimal r14_NO_INS_BNK_SPC_TP) {
		R14_NO_INS_BNK_SPC_TP = r14_NO_INS_BNK_SPC_TP;
	}

	public BigDecimal getR14_NO_INS_DWN_SPC_TP() {
		return R14_NO_INS_DWN_SPC_TP;
	}

	public void setR14_NO_INS_DWN_SPC_TP(BigDecimal r14_NO_INS_DWN_SPC_TP) {
		R14_NO_INS_DWN_SPC_TP = r14_NO_INS_DWN_SPC_TP;
	}

	public BigDecimal getR14_NO_EMP_RSK_SPC_DTE() {
		return R14_NO_EMP_RSK_SPC_DTE;
	}

	public void setR14_NO_EMP_RSK_SPC_DTE(BigDecimal r14_NO_EMP_RSK_SPC_DTE) {
		R14_NO_EMP_RSK_SPC_DTE = r14_NO_EMP_RSK_SPC_DTE;
	}

	public BigDecimal getR14_NO_EXT_FRD_SPC_TP() {
		return R14_NO_EXT_FRD_SPC_TP;
	}

	public void setR14_NO_EXT_FRD_SPC_TP(BigDecimal r14_NO_EXT_FRD_SPC_TP) {
		R14_NO_EXT_FRD_SPC_TP = r14_NO_EXT_FRD_SPC_TP;
	}

	public BigDecimal getR14_NO_INT_FRD_SPC_TP() {
		return R14_NO_INT_FRD_SPC_TP;
	}

	public void setR14_NO_INT_FRD_SPC_TP(BigDecimal r14_NO_INT_FRD_SPC_TP) {
		R14_NO_INT_FRD_SPC_TP = r14_NO_INT_FRD_SPC_TP;
	}

	public BigDecimal getR14_NO_FRD_SPC_TP() {
		return R14_NO_FRD_SPC_TP;
	}

	public void setR14_NO_FRD_SPC_TP(BigDecimal r14_NO_FRD_SPC_TP) {
		R14_NO_FRD_SPC_TP = r14_NO_FRD_SPC_TP;
	}

	public BigDecimal getR14_NO_FRD_PP() {
		return R14_NO_FRD_PP;
	}

	public void setR14_NO_FRD_PP(BigDecimal r14_NO_FRD_PP) {
		R14_NO_FRD_PP = r14_NO_FRD_PP;
	}

	public BigDecimal getR14_TOT_REV_SPC_TP() {
		return R14_TOT_REV_SPC_TP;
	}

	public void setR14_TOT_REV_SPC_TP(BigDecimal r14_TOT_REV_SPC_TP) {
		R14_TOT_REV_SPC_TP = r14_TOT_REV_SPC_TP;
	}

	public BigDecimal getR14_TOT_INS_UNP_SPC_TP() {
		return R14_TOT_INS_UNP_SPC_TP;
	}

	public void setR14_TOT_INS_UNP_SPC_TP(BigDecimal r14_TOT_INS_UNP_SPC_TP) {
		R14_TOT_INS_UNP_SPC_TP = r14_TOT_INS_UNP_SPC_TP;
	}

	public BigDecimal getR14_TOT_NO_HRS_BNK() {
		return R14_TOT_NO_HRS_BNK;
	}

	public void setR14_TOT_NO_HRS_BNK(BigDecimal r14_TOT_NO_HRS_BNK) {
		R14_TOT_NO_HRS_BNK = r14_TOT_NO_HRS_BNK;
	}

	public BigDecimal getR14_TOT_NO_INC_SPC_TP() {
		return R14_TOT_NO_INC_SPC_TP;
	}

	public void setR14_TOT_NO_INC_SPC_TP(BigDecimal r14_TOT_NO_INC_SPC_TP) {
		R14_TOT_NO_INC_SPC_TP = r14_TOT_NO_INC_SPC_TP;
	}

	public BigDecimal getR14_TOT_NO_PEN_SPC_TP() {
		return R14_TOT_NO_PEN_SPC_TP;
	}

	public void setR14_TOT_NO_PEN_SPC_TP(BigDecimal r14_TOT_NO_PEN_SPC_TP) {
		R14_TOT_NO_PEN_SPC_TP = r14_TOT_NO_PEN_SPC_TP;
	}

	public BigDecimal getR14_TOT_NO_AUT_SPC_TP() {
		return R14_TOT_NO_AUT_SPC_TP;
	}

	public void setR14_TOT_NO_AUT_SPC_TP(BigDecimal r14_TOT_NO_AUT_SPC_TP) {
		R14_TOT_NO_AUT_SPC_TP = r14_TOT_NO_AUT_SPC_TP;
	}

	public BigDecimal getR14_TOT_NO_SAL_SPC_TP() {
		return R14_TOT_NO_SAL_SPC_TP;
	}

	public void setR14_TOT_NO_SAL_SPC_TP(BigDecimal r14_TOT_NO_SAL_SPC_TP) {
		R14_TOT_NO_SAL_SPC_TP = r14_TOT_NO_SAL_SPC_TP;
	}

	public BigDecimal getR14_TOT_NO_MER_SPC_TP() {
		return R14_TOT_NO_MER_SPC_TP;
	}

	public void setR14_TOT_NO_MER_SPC_TP(BigDecimal r14_TOT_NO_MER_SPC_TP) {
		R14_TOT_NO_MER_SPC_TP = r14_TOT_NO_MER_SPC_TP;
	}

	public BigDecimal getR14_NO_INQ_SPC_TP() {
		return R14_NO_INQ_SPC_TP;
	}

	public void setR14_NO_INQ_SPC_TP(BigDecimal r14_NO_INQ_SPC_TP) {
		R14_NO_INQ_SPC_TP = r14_NO_INQ_SPC_TP;
	}

	public BigDecimal getR14_NO_SER_SPC_TP() {
		return R14_NO_SER_SPC_TP;
	}

	public void setR14_NO_SER_SPC_TP(BigDecimal r14_NO_SER_SPC_TP) {
		R14_NO_SER_SPC_TP = r14_NO_SER_SPC_TP;
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

	public BigDecimal getR15_NO_EMP_SPC_TP() {
		return R15_NO_EMP_SPC_TP;
	}

	public void setR15_NO_EMP_SPC_TP(BigDecimal r15_NO_EMP_SPC_TP) {
		R15_NO_EMP_SPC_TP = r15_NO_EMP_SPC_TP;
	}

	public BigDecimal getR15_NO_CON_SPC_TP() {
		return R15_NO_CON_SPC_TP;
	}

	public void setR15_NO_CON_SPC_TP(BigDecimal r15_NO_CON_SPC_TP) {
		R15_NO_CON_SPC_TP = r15_NO_CON_SPC_TP;
	}

	public BigDecimal getR15_AVG_NO_EMP_SPC_TP() {
		return R15_AVG_NO_EMP_SPC_TP;
	}

	public void setR15_AVG_NO_EMP_SPC_TP(BigDecimal r15_AVG_NO_EMP_SPC_TP) {
		R15_AVG_NO_EMP_SPC_TP = r15_AVG_NO_EMP_SPC_TP;
	}

	public BigDecimal getR15_NO_BRN_SPC_TP() {
		return R15_NO_BRN_SPC_TP;
	}

	public void setR15_NO_BRN_SPC_TP(BigDecimal r15_NO_BRN_SPC_TP) {
		R15_NO_BRN_SPC_TP = r15_NO_BRN_SPC_TP;
	}

	public BigDecimal getR15_TOT_NO_BRN_POD() {
		return R15_TOT_NO_BRN_POD;
	}

	public void setR15_TOT_NO_BRN_POD(BigDecimal r15_TOT_NO_BRN_POD) {
		R15_TOT_NO_BRN_POD = r15_TOT_NO_BRN_POD;
	}

	public BigDecimal getR15_NO_ATM_SPC_TP() {
		return R15_NO_ATM_SPC_TP;
	}

	public void setR15_NO_ATM_SPC_TP(BigDecimal r15_NO_ATM_SPC_TP) {
		R15_NO_ATM_SPC_TP = r15_NO_ATM_SPC_TP;
	}

	public BigDecimal getR15_NO_ATM_DET_SPC_TP() {
		return R15_NO_ATM_DET_SPC_TP;
	}

	public void setR15_NO_ATM_DET_SPC_TP(BigDecimal r15_NO_ATM_DET_SPC_TP) {
		R15_NO_ATM_DET_SPC_TP = r15_NO_ATM_DET_SPC_TP;
	}

	public BigDecimal getR15_NO_AUT_SPC_TP() {
		return R15_NO_AUT_SPC_TP;
	}

	public void setR15_NO_AUT_SPC_TP(BigDecimal r15_NO_AUT_SPC_TP) {
		R15_NO_AUT_SPC_TP = r15_NO_AUT_SPC_TP;
	}

	public BigDecimal getR15_NO_INS_BNK_SPC_TP() {
		return R15_NO_INS_BNK_SPC_TP;
	}

	public void setR15_NO_INS_BNK_SPC_TP(BigDecimal r15_NO_INS_BNK_SPC_TP) {
		R15_NO_INS_BNK_SPC_TP = r15_NO_INS_BNK_SPC_TP;
	}

	public BigDecimal getR15_NO_INS_DWN_SPC_TP() {
		return R15_NO_INS_DWN_SPC_TP;
	}

	public void setR15_NO_INS_DWN_SPC_TP(BigDecimal r15_NO_INS_DWN_SPC_TP) {
		R15_NO_INS_DWN_SPC_TP = r15_NO_INS_DWN_SPC_TP;
	}

	public BigDecimal getR15_NO_EMP_RSK_SPC_DTE() {
		return R15_NO_EMP_RSK_SPC_DTE;
	}

	public void setR15_NO_EMP_RSK_SPC_DTE(BigDecimal r15_NO_EMP_RSK_SPC_DTE) {
		R15_NO_EMP_RSK_SPC_DTE = r15_NO_EMP_RSK_SPC_DTE;
	}

	public BigDecimal getR15_NO_EXT_FRD_SPC_TP() {
		return R15_NO_EXT_FRD_SPC_TP;
	}

	public void setR15_NO_EXT_FRD_SPC_TP(BigDecimal r15_NO_EXT_FRD_SPC_TP) {
		R15_NO_EXT_FRD_SPC_TP = r15_NO_EXT_FRD_SPC_TP;
	}

	public BigDecimal getR15_NO_INT_FRD_SPC_TP() {
		return R15_NO_INT_FRD_SPC_TP;
	}

	public void setR15_NO_INT_FRD_SPC_TP(BigDecimal r15_NO_INT_FRD_SPC_TP) {
		R15_NO_INT_FRD_SPC_TP = r15_NO_INT_FRD_SPC_TP;
	}

	public BigDecimal getR15_NO_FRD_SPC_TP() {
		return R15_NO_FRD_SPC_TP;
	}

	public void setR15_NO_FRD_SPC_TP(BigDecimal r15_NO_FRD_SPC_TP) {
		R15_NO_FRD_SPC_TP = r15_NO_FRD_SPC_TP;
	}

	public BigDecimal getR15_NO_FRD_PP() {
		return R15_NO_FRD_PP;
	}

	public void setR15_NO_FRD_PP(BigDecimal r15_NO_FRD_PP) {
		R15_NO_FRD_PP = r15_NO_FRD_PP;
	}

	public BigDecimal getR15_TOT_REV_SPC_TP() {
		return R15_TOT_REV_SPC_TP;
	}

	public void setR15_TOT_REV_SPC_TP(BigDecimal r15_TOT_REV_SPC_TP) {
		R15_TOT_REV_SPC_TP = r15_TOT_REV_SPC_TP;
	}

	public BigDecimal getR15_TOT_INS_UNP_SPC_TP() {
		return R15_TOT_INS_UNP_SPC_TP;
	}

	public void setR15_TOT_INS_UNP_SPC_TP(BigDecimal r15_TOT_INS_UNP_SPC_TP) {
		R15_TOT_INS_UNP_SPC_TP = r15_TOT_INS_UNP_SPC_TP;
	}

	public BigDecimal getR15_TOT_NO_HRS_BNK() {
		return R15_TOT_NO_HRS_BNK;
	}

	public void setR15_TOT_NO_HRS_BNK(BigDecimal r15_TOT_NO_HRS_BNK) {
		R15_TOT_NO_HRS_BNK = r15_TOT_NO_HRS_BNK;
	}

	public BigDecimal getR15_TOT_NO_INC_SPC_TP() {
		return R15_TOT_NO_INC_SPC_TP;
	}

	public void setR15_TOT_NO_INC_SPC_TP(BigDecimal r15_TOT_NO_INC_SPC_TP) {
		R15_TOT_NO_INC_SPC_TP = r15_TOT_NO_INC_SPC_TP;
	}

	public BigDecimal getR15_TOT_NO_PEN_SPC_TP() {
		return R15_TOT_NO_PEN_SPC_TP;
	}

	public void setR15_TOT_NO_PEN_SPC_TP(BigDecimal r15_TOT_NO_PEN_SPC_TP) {
		R15_TOT_NO_PEN_SPC_TP = r15_TOT_NO_PEN_SPC_TP;
	}

	public BigDecimal getR15_TOT_NO_AUT_SPC_TP() {
		return R15_TOT_NO_AUT_SPC_TP;
	}

	public void setR15_TOT_NO_AUT_SPC_TP(BigDecimal r15_TOT_NO_AUT_SPC_TP) {
		R15_TOT_NO_AUT_SPC_TP = r15_TOT_NO_AUT_SPC_TP;
	}

	public BigDecimal getR15_TOT_NO_SAL_SPC_TP() {
		return R15_TOT_NO_SAL_SPC_TP;
	}

	public void setR15_TOT_NO_SAL_SPC_TP(BigDecimal r15_TOT_NO_SAL_SPC_TP) {
		R15_TOT_NO_SAL_SPC_TP = r15_TOT_NO_SAL_SPC_TP;
	}

	public BigDecimal getR15_TOT_NO_MER_SPC_TP() {
		return R15_TOT_NO_MER_SPC_TP;
	}

	public void setR15_TOT_NO_MER_SPC_TP(BigDecimal r15_TOT_NO_MER_SPC_TP) {
		R15_TOT_NO_MER_SPC_TP = r15_TOT_NO_MER_SPC_TP;
	}

	public BigDecimal getR15_NO_INQ_SPC_TP() {
		return R15_NO_INQ_SPC_TP;
	}

	public void setR15_NO_INQ_SPC_TP(BigDecimal r15_NO_INQ_SPC_TP) {
		R15_NO_INQ_SPC_TP = r15_NO_INQ_SPC_TP;
	}

	public BigDecimal getR15_NO_SER_SPC_TP() {
		return R15_NO_SER_SPC_TP;
	}

	public void setR15_NO_SER_SPC_TP(BigDecimal r15_NO_SER_SPC_TP) {
		R15_NO_SER_SPC_TP = r15_NO_SER_SPC_TP;
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

	public BigDecimal getR16_NO_EMP_SPC_TP() {
		return R16_NO_EMP_SPC_TP;
	}

	public void setR16_NO_EMP_SPC_TP(BigDecimal r16_NO_EMP_SPC_TP) {
		R16_NO_EMP_SPC_TP = r16_NO_EMP_SPC_TP;
	}

	public BigDecimal getR16_NO_CON_SPC_TP() {
		return R16_NO_CON_SPC_TP;
	}

	public void setR16_NO_CON_SPC_TP(BigDecimal r16_NO_CON_SPC_TP) {
		R16_NO_CON_SPC_TP = r16_NO_CON_SPC_TP;
	}

	public BigDecimal getR16_AVG_NO_EMP_SPC_TP() {
		return R16_AVG_NO_EMP_SPC_TP;
	}

	public void setR16_AVG_NO_EMP_SPC_TP(BigDecimal r16_AVG_NO_EMP_SPC_TP) {
		R16_AVG_NO_EMP_SPC_TP = r16_AVG_NO_EMP_SPC_TP;
	}

	public BigDecimal getR16_NO_BRN_SPC_TP() {
		return R16_NO_BRN_SPC_TP;
	}

	public void setR16_NO_BRN_SPC_TP(BigDecimal r16_NO_BRN_SPC_TP) {
		R16_NO_BRN_SPC_TP = r16_NO_BRN_SPC_TP;
	}

	public BigDecimal getR16_TOT_NO_BRN_POD() {
		return R16_TOT_NO_BRN_POD;
	}

	public void setR16_TOT_NO_BRN_POD(BigDecimal r16_TOT_NO_BRN_POD) {
		R16_TOT_NO_BRN_POD = r16_TOT_NO_BRN_POD;
	}

	public BigDecimal getR16_NO_ATM_SPC_TP() {
		return R16_NO_ATM_SPC_TP;
	}

	public void setR16_NO_ATM_SPC_TP(BigDecimal r16_NO_ATM_SPC_TP) {
		R16_NO_ATM_SPC_TP = r16_NO_ATM_SPC_TP;
	}

	public BigDecimal getR16_NO_ATM_DET_SPC_TP() {
		return R16_NO_ATM_DET_SPC_TP;
	}

	public void setR16_NO_ATM_DET_SPC_TP(BigDecimal r16_NO_ATM_DET_SPC_TP) {
		R16_NO_ATM_DET_SPC_TP = r16_NO_ATM_DET_SPC_TP;
	}

	public BigDecimal getR16_NO_AUT_SPC_TP() {
		return R16_NO_AUT_SPC_TP;
	}

	public void setR16_NO_AUT_SPC_TP(BigDecimal r16_NO_AUT_SPC_TP) {
		R16_NO_AUT_SPC_TP = r16_NO_AUT_SPC_TP;
	}

	public BigDecimal getR16_NO_INS_BNK_SPC_TP() {
		return R16_NO_INS_BNK_SPC_TP;
	}

	public void setR16_NO_INS_BNK_SPC_TP(BigDecimal r16_NO_INS_BNK_SPC_TP) {
		R16_NO_INS_BNK_SPC_TP = r16_NO_INS_BNK_SPC_TP;
	}

	public BigDecimal getR16_NO_INS_DWN_SPC_TP() {
		return R16_NO_INS_DWN_SPC_TP;
	}

	public void setR16_NO_INS_DWN_SPC_TP(BigDecimal r16_NO_INS_DWN_SPC_TP) {
		R16_NO_INS_DWN_SPC_TP = r16_NO_INS_DWN_SPC_TP;
	}

	public BigDecimal getR16_NO_EMP_RSK_SPC_DTE() {
		return R16_NO_EMP_RSK_SPC_DTE;
	}

	public void setR16_NO_EMP_RSK_SPC_DTE(BigDecimal r16_NO_EMP_RSK_SPC_DTE) {
		R16_NO_EMP_RSK_SPC_DTE = r16_NO_EMP_RSK_SPC_DTE;
	}

	public BigDecimal getR16_NO_EXT_FRD_SPC_TP() {
		return R16_NO_EXT_FRD_SPC_TP;
	}

	public void setR16_NO_EXT_FRD_SPC_TP(BigDecimal r16_NO_EXT_FRD_SPC_TP) {
		R16_NO_EXT_FRD_SPC_TP = r16_NO_EXT_FRD_SPC_TP;
	}

	public BigDecimal getR16_NO_INT_FRD_SPC_TP() {
		return R16_NO_INT_FRD_SPC_TP;
	}

	public void setR16_NO_INT_FRD_SPC_TP(BigDecimal r16_NO_INT_FRD_SPC_TP) {
		R16_NO_INT_FRD_SPC_TP = r16_NO_INT_FRD_SPC_TP;
	}

	public BigDecimal getR16_NO_FRD_SPC_TP() {
		return R16_NO_FRD_SPC_TP;
	}

	public void setR16_NO_FRD_SPC_TP(BigDecimal r16_NO_FRD_SPC_TP) {
		R16_NO_FRD_SPC_TP = r16_NO_FRD_SPC_TP;
	}

	public BigDecimal getR16_NO_FRD_PP() {
		return R16_NO_FRD_PP;
	}

	public void setR16_NO_FRD_PP(BigDecimal r16_NO_FRD_PP) {
		R16_NO_FRD_PP = r16_NO_FRD_PP;
	}

	public BigDecimal getR16_TOT_REV_SPC_TP() {
		return R16_TOT_REV_SPC_TP;
	}

	public void setR16_TOT_REV_SPC_TP(BigDecimal r16_TOT_REV_SPC_TP) {
		R16_TOT_REV_SPC_TP = r16_TOT_REV_SPC_TP;
	}

	public BigDecimal getR16_TOT_INS_UNP_SPC_TP() {
		return R16_TOT_INS_UNP_SPC_TP;
	}

	public void setR16_TOT_INS_UNP_SPC_TP(BigDecimal r16_TOT_INS_UNP_SPC_TP) {
		R16_TOT_INS_UNP_SPC_TP = r16_TOT_INS_UNP_SPC_TP;
	}

	public BigDecimal getR16_TOT_NO_HRS_BNK() {
		return R16_TOT_NO_HRS_BNK;
	}

	public void setR16_TOT_NO_HRS_BNK(BigDecimal r16_TOT_NO_HRS_BNK) {
		R16_TOT_NO_HRS_BNK = r16_TOT_NO_HRS_BNK;
	}

	public BigDecimal getR16_TOT_NO_INC_SPC_TP() {
		return R16_TOT_NO_INC_SPC_TP;
	}

	public void setR16_TOT_NO_INC_SPC_TP(BigDecimal r16_TOT_NO_INC_SPC_TP) {
		R16_TOT_NO_INC_SPC_TP = r16_TOT_NO_INC_SPC_TP;
	}

	public BigDecimal getR16_TOT_NO_PEN_SPC_TP() {
		return R16_TOT_NO_PEN_SPC_TP;
	}

	public void setR16_TOT_NO_PEN_SPC_TP(BigDecimal r16_TOT_NO_PEN_SPC_TP) {
		R16_TOT_NO_PEN_SPC_TP = r16_TOT_NO_PEN_SPC_TP;
	}

	public BigDecimal getR16_TOT_NO_AUT_SPC_TP() {
		return R16_TOT_NO_AUT_SPC_TP;
	}

	public void setR16_TOT_NO_AUT_SPC_TP(BigDecimal r16_TOT_NO_AUT_SPC_TP) {
		R16_TOT_NO_AUT_SPC_TP = r16_TOT_NO_AUT_SPC_TP;
	}

	public BigDecimal getR16_TOT_NO_SAL_SPC_TP() {
		return R16_TOT_NO_SAL_SPC_TP;
	}

	public void setR16_TOT_NO_SAL_SPC_TP(BigDecimal r16_TOT_NO_SAL_SPC_TP) {
		R16_TOT_NO_SAL_SPC_TP = r16_TOT_NO_SAL_SPC_TP;
	}

	public BigDecimal getR16_TOT_NO_MER_SPC_TP() {
		return R16_TOT_NO_MER_SPC_TP;
	}

	public void setR16_TOT_NO_MER_SPC_TP(BigDecimal r16_TOT_NO_MER_SPC_TP) {
		R16_TOT_NO_MER_SPC_TP = r16_TOT_NO_MER_SPC_TP;
	}

	public BigDecimal getR16_NO_INQ_SPC_TP() {
		return R16_NO_INQ_SPC_TP;
	}

	public void setR16_NO_INQ_SPC_TP(BigDecimal r16_NO_INQ_SPC_TP) {
		R16_NO_INQ_SPC_TP = r16_NO_INQ_SPC_TP;
	}

	public BigDecimal getR16_NO_SER_SPC_TP() {
		return R16_NO_SER_SPC_TP;
	}

	public void setR16_NO_SER_SPC_TP(BigDecimal r16_NO_SER_SPC_TP) {
		R16_NO_SER_SPC_TP = r16_NO_SER_SPC_TP;
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

	public BigDecimal getR17_NO_EMP_SPC_TP() {
		return R17_NO_EMP_SPC_TP;
	}

	public void setR17_NO_EMP_SPC_TP(BigDecimal r17_NO_EMP_SPC_TP) {
		R17_NO_EMP_SPC_TP = r17_NO_EMP_SPC_TP;
	}

	public BigDecimal getR17_NO_CON_SPC_TP() {
		return R17_NO_CON_SPC_TP;
	}

	public void setR17_NO_CON_SPC_TP(BigDecimal r17_NO_CON_SPC_TP) {
		R17_NO_CON_SPC_TP = r17_NO_CON_SPC_TP;
	}

	public BigDecimal getR17_AVG_NO_EMP_SPC_TP() {
		return R17_AVG_NO_EMP_SPC_TP;
	}

	public void setR17_AVG_NO_EMP_SPC_TP(BigDecimal r17_AVG_NO_EMP_SPC_TP) {
		R17_AVG_NO_EMP_SPC_TP = r17_AVG_NO_EMP_SPC_TP;
	}

	public BigDecimal getR17_NO_BRN_SPC_TP() {
		return R17_NO_BRN_SPC_TP;
	}

	public void setR17_NO_BRN_SPC_TP(BigDecimal r17_NO_BRN_SPC_TP) {
		R17_NO_BRN_SPC_TP = r17_NO_BRN_SPC_TP;
	}

	public BigDecimal getR17_TOT_NO_BRN_POD() {
		return R17_TOT_NO_BRN_POD;
	}

	public void setR17_TOT_NO_BRN_POD(BigDecimal r17_TOT_NO_BRN_POD) {
		R17_TOT_NO_BRN_POD = r17_TOT_NO_BRN_POD;
	}

	public BigDecimal getR17_NO_ATM_SPC_TP() {
		return R17_NO_ATM_SPC_TP;
	}

	public void setR17_NO_ATM_SPC_TP(BigDecimal r17_NO_ATM_SPC_TP) {
		R17_NO_ATM_SPC_TP = r17_NO_ATM_SPC_TP;
	}

	public BigDecimal getR17_NO_ATM_DET_SPC_TP() {
		return R17_NO_ATM_DET_SPC_TP;
	}

	public void setR17_NO_ATM_DET_SPC_TP(BigDecimal r17_NO_ATM_DET_SPC_TP) {
		R17_NO_ATM_DET_SPC_TP = r17_NO_ATM_DET_SPC_TP;
	}

	public BigDecimal getR17_NO_AUT_SPC_TP() {
		return R17_NO_AUT_SPC_TP;
	}

	public void setR17_NO_AUT_SPC_TP(BigDecimal r17_NO_AUT_SPC_TP) {
		R17_NO_AUT_SPC_TP = r17_NO_AUT_SPC_TP;
	}

	public BigDecimal getR17_NO_INS_BNK_SPC_TP() {
		return R17_NO_INS_BNK_SPC_TP;
	}

	public void setR17_NO_INS_BNK_SPC_TP(BigDecimal r17_NO_INS_BNK_SPC_TP) {
		R17_NO_INS_BNK_SPC_TP = r17_NO_INS_BNK_SPC_TP;
	}

	public BigDecimal getR17_NO_INS_DWN_SPC_TP() {
		return R17_NO_INS_DWN_SPC_TP;
	}

	public void setR17_NO_INS_DWN_SPC_TP(BigDecimal r17_NO_INS_DWN_SPC_TP) {
		R17_NO_INS_DWN_SPC_TP = r17_NO_INS_DWN_SPC_TP;
	}

	public BigDecimal getR17_NO_EMP_RSK_SPC_DTE() {
		return R17_NO_EMP_RSK_SPC_DTE;
	}

	public void setR17_NO_EMP_RSK_SPC_DTE(BigDecimal r17_NO_EMP_RSK_SPC_DTE) {
		R17_NO_EMP_RSK_SPC_DTE = r17_NO_EMP_RSK_SPC_DTE;
	}

	public BigDecimal getR17_NO_EXT_FRD_SPC_TP() {
		return R17_NO_EXT_FRD_SPC_TP;
	}

	public void setR17_NO_EXT_FRD_SPC_TP(BigDecimal r17_NO_EXT_FRD_SPC_TP) {
		R17_NO_EXT_FRD_SPC_TP = r17_NO_EXT_FRD_SPC_TP;
	}

	public BigDecimal getR17_NO_INT_FRD_SPC_TP() {
		return R17_NO_INT_FRD_SPC_TP;
	}

	public void setR17_NO_INT_FRD_SPC_TP(BigDecimal r17_NO_INT_FRD_SPC_TP) {
		R17_NO_INT_FRD_SPC_TP = r17_NO_INT_FRD_SPC_TP;
	}

	public BigDecimal getR17_NO_FRD_SPC_TP() {
		return R17_NO_FRD_SPC_TP;
	}

	public void setR17_NO_FRD_SPC_TP(BigDecimal r17_NO_FRD_SPC_TP) {
		R17_NO_FRD_SPC_TP = r17_NO_FRD_SPC_TP;
	}

	public BigDecimal getR17_NO_FRD_PP() {
		return R17_NO_FRD_PP;
	}

	public void setR17_NO_FRD_PP(BigDecimal r17_NO_FRD_PP) {
		R17_NO_FRD_PP = r17_NO_FRD_PP;
	}

	public BigDecimal getR17_TOT_REV_SPC_TP() {
		return R17_TOT_REV_SPC_TP;
	}

	public void setR17_TOT_REV_SPC_TP(BigDecimal r17_TOT_REV_SPC_TP) {
		R17_TOT_REV_SPC_TP = r17_TOT_REV_SPC_TP;
	}

	public BigDecimal getR17_TOT_INS_UNP_SPC_TP() {
		return R17_TOT_INS_UNP_SPC_TP;
	}

	public void setR17_TOT_INS_UNP_SPC_TP(BigDecimal r17_TOT_INS_UNP_SPC_TP) {
		R17_TOT_INS_UNP_SPC_TP = r17_TOT_INS_UNP_SPC_TP;
	}

	public BigDecimal getR17_TOT_NO_HRS_BNK() {
		return R17_TOT_NO_HRS_BNK;
	}

	public void setR17_TOT_NO_HRS_BNK(BigDecimal r17_TOT_NO_HRS_BNK) {
		R17_TOT_NO_HRS_BNK = r17_TOT_NO_HRS_BNK;
	}

	public BigDecimal getR17_TOT_NO_INC_SPC_TP() {
		return R17_TOT_NO_INC_SPC_TP;
	}

	public void setR17_TOT_NO_INC_SPC_TP(BigDecimal r17_TOT_NO_INC_SPC_TP) {
		R17_TOT_NO_INC_SPC_TP = r17_TOT_NO_INC_SPC_TP;
	}

	public BigDecimal getR17_TOT_NO_PEN_SPC_TP() {
		return R17_TOT_NO_PEN_SPC_TP;
	}

	public void setR17_TOT_NO_PEN_SPC_TP(BigDecimal r17_TOT_NO_PEN_SPC_TP) {
		R17_TOT_NO_PEN_SPC_TP = r17_TOT_NO_PEN_SPC_TP;
	}

	public BigDecimal getR17_TOT_NO_AUT_SPC_TP() {
		return R17_TOT_NO_AUT_SPC_TP;
	}

	public void setR17_TOT_NO_AUT_SPC_TP(BigDecimal r17_TOT_NO_AUT_SPC_TP) {
		R17_TOT_NO_AUT_SPC_TP = r17_TOT_NO_AUT_SPC_TP;
	}

	public BigDecimal getR17_TOT_NO_SAL_SPC_TP() {
		return R17_TOT_NO_SAL_SPC_TP;
	}

	public void setR17_TOT_NO_SAL_SPC_TP(BigDecimal r17_TOT_NO_SAL_SPC_TP) {
		R17_TOT_NO_SAL_SPC_TP = r17_TOT_NO_SAL_SPC_TP;
	}

	public BigDecimal getR17_TOT_NO_MER_SPC_TP() {
		return R17_TOT_NO_MER_SPC_TP;
	}

	public void setR17_TOT_NO_MER_SPC_TP(BigDecimal r17_TOT_NO_MER_SPC_TP) {
		R17_TOT_NO_MER_SPC_TP = r17_TOT_NO_MER_SPC_TP;
	}

	public BigDecimal getR17_NO_INQ_SPC_TP() {
		return R17_NO_INQ_SPC_TP;
	}

	public void setR17_NO_INQ_SPC_TP(BigDecimal r17_NO_INQ_SPC_TP) {
		R17_NO_INQ_SPC_TP = r17_NO_INQ_SPC_TP;
	}

	public BigDecimal getR17_NO_SER_SPC_TP() {
		return R17_NO_SER_SPC_TP;
	}

	public void setR17_NO_SER_SPC_TP(BigDecimal r17_NO_SER_SPC_TP) {
		R17_NO_SER_SPC_TP = r17_NO_SER_SPC_TP;
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

	public BigDecimal getR18_NO_EMP_SPC_TP() {
		return R18_NO_EMP_SPC_TP;
	}

	public void setR18_NO_EMP_SPC_TP(BigDecimal r18_NO_EMP_SPC_TP) {
		R18_NO_EMP_SPC_TP = r18_NO_EMP_SPC_TP;
	}

	public BigDecimal getR18_NO_CON_SPC_TP() {
		return R18_NO_CON_SPC_TP;
	}

	public void setR18_NO_CON_SPC_TP(BigDecimal r18_NO_CON_SPC_TP) {
		R18_NO_CON_SPC_TP = r18_NO_CON_SPC_TP;
	}

	public BigDecimal getR18_AVG_NO_EMP_SPC_TP() {
		return R18_AVG_NO_EMP_SPC_TP;
	}

	public void setR18_AVG_NO_EMP_SPC_TP(BigDecimal r18_AVG_NO_EMP_SPC_TP) {
		R18_AVG_NO_EMP_SPC_TP = r18_AVG_NO_EMP_SPC_TP;
	}

	public BigDecimal getR18_NO_BRN_SPC_TP() {
		return R18_NO_BRN_SPC_TP;
	}

	public void setR18_NO_BRN_SPC_TP(BigDecimal r18_NO_BRN_SPC_TP) {
		R18_NO_BRN_SPC_TP = r18_NO_BRN_SPC_TP;
	}

	public BigDecimal getR18_TOT_NO_BRN_POD() {
		return R18_TOT_NO_BRN_POD;
	}

	public void setR18_TOT_NO_BRN_POD(BigDecimal r18_TOT_NO_BRN_POD) {
		R18_TOT_NO_BRN_POD = r18_TOT_NO_BRN_POD;
	}

	public BigDecimal getR18_NO_ATM_SPC_TP() {
		return R18_NO_ATM_SPC_TP;
	}

	public void setR18_NO_ATM_SPC_TP(BigDecimal r18_NO_ATM_SPC_TP) {
		R18_NO_ATM_SPC_TP = r18_NO_ATM_SPC_TP;
	}

	public BigDecimal getR18_NO_ATM_DET_SPC_TP() {
		return R18_NO_ATM_DET_SPC_TP;
	}

	public void setR18_NO_ATM_DET_SPC_TP(BigDecimal r18_NO_ATM_DET_SPC_TP) {
		R18_NO_ATM_DET_SPC_TP = r18_NO_ATM_DET_SPC_TP;
	}

	public BigDecimal getR18_NO_AUT_SPC_TP() {
		return R18_NO_AUT_SPC_TP;
	}

	public void setR18_NO_AUT_SPC_TP(BigDecimal r18_NO_AUT_SPC_TP) {
		R18_NO_AUT_SPC_TP = r18_NO_AUT_SPC_TP;
	}

	public BigDecimal getR18_NO_INS_BNK_SPC_TP() {
		return R18_NO_INS_BNK_SPC_TP;
	}

	public void setR18_NO_INS_BNK_SPC_TP(BigDecimal r18_NO_INS_BNK_SPC_TP) {
		R18_NO_INS_BNK_SPC_TP = r18_NO_INS_BNK_SPC_TP;
	}

	public BigDecimal getR18_NO_INS_DWN_SPC_TP() {
		return R18_NO_INS_DWN_SPC_TP;
	}

	public void setR18_NO_INS_DWN_SPC_TP(BigDecimal r18_NO_INS_DWN_SPC_TP) {
		R18_NO_INS_DWN_SPC_TP = r18_NO_INS_DWN_SPC_TP;
	}

	public BigDecimal getR18_NO_EMP_RSK_SPC_DTE() {
		return R18_NO_EMP_RSK_SPC_DTE;
	}

	public void setR18_NO_EMP_RSK_SPC_DTE(BigDecimal r18_NO_EMP_RSK_SPC_DTE) {
		R18_NO_EMP_RSK_SPC_DTE = r18_NO_EMP_RSK_SPC_DTE;
	}

	public BigDecimal getR18_NO_EXT_FRD_SPC_TP() {
		return R18_NO_EXT_FRD_SPC_TP;
	}

	public void setR18_NO_EXT_FRD_SPC_TP(BigDecimal r18_NO_EXT_FRD_SPC_TP) {
		R18_NO_EXT_FRD_SPC_TP = r18_NO_EXT_FRD_SPC_TP;
	}

	public BigDecimal getR18_NO_INT_FRD_SPC_TP() {
		return R18_NO_INT_FRD_SPC_TP;
	}

	public void setR18_NO_INT_FRD_SPC_TP(BigDecimal r18_NO_INT_FRD_SPC_TP) {
		R18_NO_INT_FRD_SPC_TP = r18_NO_INT_FRD_SPC_TP;
	}

	public BigDecimal getR18_NO_FRD_SPC_TP() {
		return R18_NO_FRD_SPC_TP;
	}

	public void setR18_NO_FRD_SPC_TP(BigDecimal r18_NO_FRD_SPC_TP) {
		R18_NO_FRD_SPC_TP = r18_NO_FRD_SPC_TP;
	}

	public BigDecimal getR18_NO_FRD_PP() {
		return R18_NO_FRD_PP;
	}

	public void setR18_NO_FRD_PP(BigDecimal r18_NO_FRD_PP) {
		R18_NO_FRD_PP = r18_NO_FRD_PP;
	}

	public BigDecimal getR18_TOT_REV_SPC_TP() {
		return R18_TOT_REV_SPC_TP;
	}

	public void setR18_TOT_REV_SPC_TP(BigDecimal r18_TOT_REV_SPC_TP) {
		R18_TOT_REV_SPC_TP = r18_TOT_REV_SPC_TP;
	}

	public BigDecimal getR18_TOT_INS_UNP_SPC_TP() {
		return R18_TOT_INS_UNP_SPC_TP;
	}

	public void setR18_TOT_INS_UNP_SPC_TP(BigDecimal r18_TOT_INS_UNP_SPC_TP) {
		R18_TOT_INS_UNP_SPC_TP = r18_TOT_INS_UNP_SPC_TP;
	}

	public BigDecimal getR18_TOT_NO_HRS_BNK() {
		return R18_TOT_NO_HRS_BNK;
	}

	public void setR18_TOT_NO_HRS_BNK(BigDecimal r18_TOT_NO_HRS_BNK) {
		R18_TOT_NO_HRS_BNK = r18_TOT_NO_HRS_BNK;
	}

	public BigDecimal getR18_TOT_NO_INC_SPC_TP() {
		return R18_TOT_NO_INC_SPC_TP;
	}

	public void setR18_TOT_NO_INC_SPC_TP(BigDecimal r18_TOT_NO_INC_SPC_TP) {
		R18_TOT_NO_INC_SPC_TP = r18_TOT_NO_INC_SPC_TP;
	}

	public BigDecimal getR18_TOT_NO_PEN_SPC_TP() {
		return R18_TOT_NO_PEN_SPC_TP;
	}

	public void setR18_TOT_NO_PEN_SPC_TP(BigDecimal r18_TOT_NO_PEN_SPC_TP) {
		R18_TOT_NO_PEN_SPC_TP = r18_TOT_NO_PEN_SPC_TP;
	}

	public BigDecimal getR18_TOT_NO_AUT_SPC_TP() {
		return R18_TOT_NO_AUT_SPC_TP;
	}

	public void setR18_TOT_NO_AUT_SPC_TP(BigDecimal r18_TOT_NO_AUT_SPC_TP) {
		R18_TOT_NO_AUT_SPC_TP = r18_TOT_NO_AUT_SPC_TP;
	}

	public BigDecimal getR18_TOT_NO_SAL_SPC_TP() {
		return R18_TOT_NO_SAL_SPC_TP;
	}

	public void setR18_TOT_NO_SAL_SPC_TP(BigDecimal r18_TOT_NO_SAL_SPC_TP) {
		R18_TOT_NO_SAL_SPC_TP = r18_TOT_NO_SAL_SPC_TP;
	}

	public BigDecimal getR18_TOT_NO_MER_SPC_TP() {
		return R18_TOT_NO_MER_SPC_TP;
	}

	public void setR18_TOT_NO_MER_SPC_TP(BigDecimal r18_TOT_NO_MER_SPC_TP) {
		R18_TOT_NO_MER_SPC_TP = r18_TOT_NO_MER_SPC_TP;
	}

	public BigDecimal getR18_NO_INQ_SPC_TP() {
		return R18_NO_INQ_SPC_TP;
	}

	public void setR18_NO_INQ_SPC_TP(BigDecimal r18_NO_INQ_SPC_TP) {
		R18_NO_INQ_SPC_TP = r18_NO_INQ_SPC_TP;
	}

	public BigDecimal getR18_NO_SER_SPC_TP() {
		return R18_NO_SER_SPC_TP;
	}

	public void setR18_NO_SER_SPC_TP(BigDecimal r18_NO_SER_SPC_TP) {
		R18_NO_SER_SPC_TP = r18_NO_SER_SPC_TP;
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

	public BigDecimal getR19_NO_EMP_SPC_TP() {
		return R19_NO_EMP_SPC_TP;
	}

	public void setR19_NO_EMP_SPC_TP(BigDecimal r19_NO_EMP_SPC_TP) {
		R19_NO_EMP_SPC_TP = r19_NO_EMP_SPC_TP;
	}

	public BigDecimal getR19_NO_CON_SPC_TP() {
		return R19_NO_CON_SPC_TP;
	}

	public void setR19_NO_CON_SPC_TP(BigDecimal r19_NO_CON_SPC_TP) {
		R19_NO_CON_SPC_TP = r19_NO_CON_SPC_TP;
	}

	public BigDecimal getR19_AVG_NO_EMP_SPC_TP() {
		return R19_AVG_NO_EMP_SPC_TP;
	}

	public void setR19_AVG_NO_EMP_SPC_TP(BigDecimal r19_AVG_NO_EMP_SPC_TP) {
		R19_AVG_NO_EMP_SPC_TP = r19_AVG_NO_EMP_SPC_TP;
	}

	public BigDecimal getR19_NO_BRN_SPC_TP() {
		return R19_NO_BRN_SPC_TP;
	}

	public void setR19_NO_BRN_SPC_TP(BigDecimal r19_NO_BRN_SPC_TP) {
		R19_NO_BRN_SPC_TP = r19_NO_BRN_SPC_TP;
	}

	public BigDecimal getR19_TOT_NO_BRN_POD() {
		return R19_TOT_NO_BRN_POD;
	}

	public void setR19_TOT_NO_BRN_POD(BigDecimal r19_TOT_NO_BRN_POD) {
		R19_TOT_NO_BRN_POD = r19_TOT_NO_BRN_POD;
	}

	public BigDecimal getR19_NO_ATM_SPC_TP() {
		return R19_NO_ATM_SPC_TP;
	}

	public void setR19_NO_ATM_SPC_TP(BigDecimal r19_NO_ATM_SPC_TP) {
		R19_NO_ATM_SPC_TP = r19_NO_ATM_SPC_TP;
	}

	public BigDecimal getR19_NO_ATM_DET_SPC_TP() {
		return R19_NO_ATM_DET_SPC_TP;
	}

	public void setR19_NO_ATM_DET_SPC_TP(BigDecimal r19_NO_ATM_DET_SPC_TP) {
		R19_NO_ATM_DET_SPC_TP = r19_NO_ATM_DET_SPC_TP;
	}

	public BigDecimal getR19_NO_AUT_SPC_TP() {
		return R19_NO_AUT_SPC_TP;
	}

	public void setR19_NO_AUT_SPC_TP(BigDecimal r19_NO_AUT_SPC_TP) {
		R19_NO_AUT_SPC_TP = r19_NO_AUT_SPC_TP;
	}

	public BigDecimal getR19_NO_INS_BNK_SPC_TP() {
		return R19_NO_INS_BNK_SPC_TP;
	}

	public void setR19_NO_INS_BNK_SPC_TP(BigDecimal r19_NO_INS_BNK_SPC_TP) {
		R19_NO_INS_BNK_SPC_TP = r19_NO_INS_BNK_SPC_TP;
	}

	public BigDecimal getR19_NO_INS_DWN_SPC_TP() {
		return R19_NO_INS_DWN_SPC_TP;
	}

	public void setR19_NO_INS_DWN_SPC_TP(BigDecimal r19_NO_INS_DWN_SPC_TP) {
		R19_NO_INS_DWN_SPC_TP = r19_NO_INS_DWN_SPC_TP;
	}

	public BigDecimal getR19_NO_EMP_RSK_SPC_DTE() {
		return R19_NO_EMP_RSK_SPC_DTE;
	}

	public void setR19_NO_EMP_RSK_SPC_DTE(BigDecimal r19_NO_EMP_RSK_SPC_DTE) {
		R19_NO_EMP_RSK_SPC_DTE = r19_NO_EMP_RSK_SPC_DTE;
	}

	public BigDecimal getR19_NO_EXT_FRD_SPC_TP() {
		return R19_NO_EXT_FRD_SPC_TP;
	}

	public void setR19_NO_EXT_FRD_SPC_TP(BigDecimal r19_NO_EXT_FRD_SPC_TP) {
		R19_NO_EXT_FRD_SPC_TP = r19_NO_EXT_FRD_SPC_TP;
	}

	public BigDecimal getR19_NO_INT_FRD_SPC_TP() {
		return R19_NO_INT_FRD_SPC_TP;
	}

	public void setR19_NO_INT_FRD_SPC_TP(BigDecimal r19_NO_INT_FRD_SPC_TP) {
		R19_NO_INT_FRD_SPC_TP = r19_NO_INT_FRD_SPC_TP;
	}

	public BigDecimal getR19_NO_FRD_SPC_TP() {
		return R19_NO_FRD_SPC_TP;
	}

	public void setR19_NO_FRD_SPC_TP(BigDecimal r19_NO_FRD_SPC_TP) {
		R19_NO_FRD_SPC_TP = r19_NO_FRD_SPC_TP;
	}

	public BigDecimal getR19_NO_FRD_PP() {
		return R19_NO_FRD_PP;
	}

	public void setR19_NO_FRD_PP(BigDecimal r19_NO_FRD_PP) {
		R19_NO_FRD_PP = r19_NO_FRD_PP;
	}

	public BigDecimal getR19_TOT_REV_SPC_TP() {
		return R19_TOT_REV_SPC_TP;
	}

	public void setR19_TOT_REV_SPC_TP(BigDecimal r19_TOT_REV_SPC_TP) {
		R19_TOT_REV_SPC_TP = r19_TOT_REV_SPC_TP;
	}

	public BigDecimal getR19_TOT_INS_UNP_SPC_TP() {
		return R19_TOT_INS_UNP_SPC_TP;
	}

	public void setR19_TOT_INS_UNP_SPC_TP(BigDecimal r19_TOT_INS_UNP_SPC_TP) {
		R19_TOT_INS_UNP_SPC_TP = r19_TOT_INS_UNP_SPC_TP;
	}

	public BigDecimal getR19_TOT_NO_HRS_BNK() {
		return R19_TOT_NO_HRS_BNK;
	}

	public void setR19_TOT_NO_HRS_BNK(BigDecimal r19_TOT_NO_HRS_BNK) {
		R19_TOT_NO_HRS_BNK = r19_TOT_NO_HRS_BNK;
	}

	public BigDecimal getR19_TOT_NO_INC_SPC_TP() {
		return R19_TOT_NO_INC_SPC_TP;
	}

	public void setR19_TOT_NO_INC_SPC_TP(BigDecimal r19_TOT_NO_INC_SPC_TP) {
		R19_TOT_NO_INC_SPC_TP = r19_TOT_NO_INC_SPC_TP;
	}

	public BigDecimal getR19_TOT_NO_PEN_SPC_TP() {
		return R19_TOT_NO_PEN_SPC_TP;
	}

	public void setR19_TOT_NO_PEN_SPC_TP(BigDecimal r19_TOT_NO_PEN_SPC_TP) {
		R19_TOT_NO_PEN_SPC_TP = r19_TOT_NO_PEN_SPC_TP;
	}

	public BigDecimal getR19_TOT_NO_AUT_SPC_TP() {
		return R19_TOT_NO_AUT_SPC_TP;
	}

	public void setR19_TOT_NO_AUT_SPC_TP(BigDecimal r19_TOT_NO_AUT_SPC_TP) {
		R19_TOT_NO_AUT_SPC_TP = r19_TOT_NO_AUT_SPC_TP;
	}

	public BigDecimal getR19_TOT_NO_SAL_SPC_TP() {
		return R19_TOT_NO_SAL_SPC_TP;
	}

	public void setR19_TOT_NO_SAL_SPC_TP(BigDecimal r19_TOT_NO_SAL_SPC_TP) {
		R19_TOT_NO_SAL_SPC_TP = r19_TOT_NO_SAL_SPC_TP;
	}

	public BigDecimal getR19_TOT_NO_MER_SPC_TP() {
		return R19_TOT_NO_MER_SPC_TP;
	}

	public void setR19_TOT_NO_MER_SPC_TP(BigDecimal r19_TOT_NO_MER_SPC_TP) {
		R19_TOT_NO_MER_SPC_TP = r19_TOT_NO_MER_SPC_TP;
	}

	public BigDecimal getR19_NO_INQ_SPC_TP() {
		return R19_NO_INQ_SPC_TP;
	}

	public void setR19_NO_INQ_SPC_TP(BigDecimal r19_NO_INQ_SPC_TP) {
		R19_NO_INQ_SPC_TP = r19_NO_INQ_SPC_TP;
	}

	public BigDecimal getR19_NO_SER_SPC_TP() {
		return R19_NO_SER_SPC_TP;
	}

	public void setR19_NO_SER_SPC_TP(BigDecimal r19_NO_SER_SPC_TP) {
		R19_NO_SER_SPC_TP = r19_NO_SER_SPC_TP;
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

	public BigDecimal getR20_NO_EMP_SPC_TP() {
		return R20_NO_EMP_SPC_TP;
	}

	public void setR20_NO_EMP_SPC_TP(BigDecimal r20_NO_EMP_SPC_TP) {
		R20_NO_EMP_SPC_TP = r20_NO_EMP_SPC_TP;
	}

	public BigDecimal getR20_NO_CON_SPC_TP() {
		return R20_NO_CON_SPC_TP;
	}

	public void setR20_NO_CON_SPC_TP(BigDecimal r20_NO_CON_SPC_TP) {
		R20_NO_CON_SPC_TP = r20_NO_CON_SPC_TP;
	}

	public BigDecimal getR20_AVG_NO_EMP_SPC_TP() {
		return R20_AVG_NO_EMP_SPC_TP;
	}

	public void setR20_AVG_NO_EMP_SPC_TP(BigDecimal r20_AVG_NO_EMP_SPC_TP) {
		R20_AVG_NO_EMP_SPC_TP = r20_AVG_NO_EMP_SPC_TP;
	}

	public BigDecimal getR20_NO_BRN_SPC_TP() {
		return R20_NO_BRN_SPC_TP;
	}

	public void setR20_NO_BRN_SPC_TP(BigDecimal r20_NO_BRN_SPC_TP) {
		R20_NO_BRN_SPC_TP = r20_NO_BRN_SPC_TP;
	}

	public BigDecimal getR20_TOT_NO_BRN_POD() {
		return R20_TOT_NO_BRN_POD;
	}

	public void setR20_TOT_NO_BRN_POD(BigDecimal r20_TOT_NO_BRN_POD) {
		R20_TOT_NO_BRN_POD = r20_TOT_NO_BRN_POD;
	}

	public BigDecimal getR20_NO_ATM_SPC_TP() {
		return R20_NO_ATM_SPC_TP;
	}

	public void setR20_NO_ATM_SPC_TP(BigDecimal r20_NO_ATM_SPC_TP) {
		R20_NO_ATM_SPC_TP = r20_NO_ATM_SPC_TP;
	}

	public BigDecimal getR20_NO_ATM_DET_SPC_TP() {
		return R20_NO_ATM_DET_SPC_TP;
	}

	public void setR20_NO_ATM_DET_SPC_TP(BigDecimal r20_NO_ATM_DET_SPC_TP) {
		R20_NO_ATM_DET_SPC_TP = r20_NO_ATM_DET_SPC_TP;
	}

	public BigDecimal getR20_NO_AUT_SPC_TP() {
		return R20_NO_AUT_SPC_TP;
	}

	public void setR20_NO_AUT_SPC_TP(BigDecimal r20_NO_AUT_SPC_TP) {
		R20_NO_AUT_SPC_TP = r20_NO_AUT_SPC_TP;
	}

	public BigDecimal getR20_NO_INS_BNK_SPC_TP() {
		return R20_NO_INS_BNK_SPC_TP;
	}

	public void setR20_NO_INS_BNK_SPC_TP(BigDecimal r20_NO_INS_BNK_SPC_TP) {
		R20_NO_INS_BNK_SPC_TP = r20_NO_INS_BNK_SPC_TP;
	}

	public BigDecimal getR20_NO_INS_DWN_SPC_TP() {
		return R20_NO_INS_DWN_SPC_TP;
	}

	public void setR20_NO_INS_DWN_SPC_TP(BigDecimal r20_NO_INS_DWN_SPC_TP) {
		R20_NO_INS_DWN_SPC_TP = r20_NO_INS_DWN_SPC_TP;
	}

	public BigDecimal getR20_NO_EMP_RSK_SPC_DTE() {
		return R20_NO_EMP_RSK_SPC_DTE;
	}

	public void setR20_NO_EMP_RSK_SPC_DTE(BigDecimal r20_NO_EMP_RSK_SPC_DTE) {
		R20_NO_EMP_RSK_SPC_DTE = r20_NO_EMP_RSK_SPC_DTE;
	}

	public BigDecimal getR20_NO_EXT_FRD_SPC_TP() {
		return R20_NO_EXT_FRD_SPC_TP;
	}

	public void setR20_NO_EXT_FRD_SPC_TP(BigDecimal r20_NO_EXT_FRD_SPC_TP) {
		R20_NO_EXT_FRD_SPC_TP = r20_NO_EXT_FRD_SPC_TP;
	}

	public BigDecimal getR20_NO_INT_FRD_SPC_TP() {
		return R20_NO_INT_FRD_SPC_TP;
	}

	public void setR20_NO_INT_FRD_SPC_TP(BigDecimal r20_NO_INT_FRD_SPC_TP) {
		R20_NO_INT_FRD_SPC_TP = r20_NO_INT_FRD_SPC_TP;
	}

	public BigDecimal getR20_NO_FRD_SPC_TP() {
		return R20_NO_FRD_SPC_TP;
	}

	public void setR20_NO_FRD_SPC_TP(BigDecimal r20_NO_FRD_SPC_TP) {
		R20_NO_FRD_SPC_TP = r20_NO_FRD_SPC_TP;
	}

	public BigDecimal getR20_NO_FRD_PP() {
		return R20_NO_FRD_PP;
	}

	public void setR20_NO_FRD_PP(BigDecimal r20_NO_FRD_PP) {
		R20_NO_FRD_PP = r20_NO_FRD_PP;
	}

	public BigDecimal getR20_TOT_REV_SPC_TP() {
		return R20_TOT_REV_SPC_TP;
	}

	public void setR20_TOT_REV_SPC_TP(BigDecimal r20_TOT_REV_SPC_TP) {
		R20_TOT_REV_SPC_TP = r20_TOT_REV_SPC_TP;
	}

	public BigDecimal getR20_TOT_INS_UNP_SPC_TP() {
		return R20_TOT_INS_UNP_SPC_TP;
	}

	public void setR20_TOT_INS_UNP_SPC_TP(BigDecimal r20_TOT_INS_UNP_SPC_TP) {
		R20_TOT_INS_UNP_SPC_TP = r20_TOT_INS_UNP_SPC_TP;
	}

	public BigDecimal getR20_TOT_NO_HRS_BNK() {
		return R20_TOT_NO_HRS_BNK;
	}

	public void setR20_TOT_NO_HRS_BNK(BigDecimal r20_TOT_NO_HRS_BNK) {
		R20_TOT_NO_HRS_BNK = r20_TOT_NO_HRS_BNK;
	}

	public BigDecimal getR20_TOT_NO_INC_SPC_TP() {
		return R20_TOT_NO_INC_SPC_TP;
	}

	public void setR20_TOT_NO_INC_SPC_TP(BigDecimal r20_TOT_NO_INC_SPC_TP) {
		R20_TOT_NO_INC_SPC_TP = r20_TOT_NO_INC_SPC_TP;
	}

	public BigDecimal getR20_TOT_NO_PEN_SPC_TP() {
		return R20_TOT_NO_PEN_SPC_TP;
	}

	public void setR20_TOT_NO_PEN_SPC_TP(BigDecimal r20_TOT_NO_PEN_SPC_TP) {
		R20_TOT_NO_PEN_SPC_TP = r20_TOT_NO_PEN_SPC_TP;
	}

	public BigDecimal getR20_TOT_NO_AUT_SPC_TP() {
		return R20_TOT_NO_AUT_SPC_TP;
	}

	public void setR20_TOT_NO_AUT_SPC_TP(BigDecimal r20_TOT_NO_AUT_SPC_TP) {
		R20_TOT_NO_AUT_SPC_TP = r20_TOT_NO_AUT_SPC_TP;
	}

	public BigDecimal getR20_TOT_NO_SAL_SPC_TP() {
		return R20_TOT_NO_SAL_SPC_TP;
	}

	public void setR20_TOT_NO_SAL_SPC_TP(BigDecimal r20_TOT_NO_SAL_SPC_TP) {
		R20_TOT_NO_SAL_SPC_TP = r20_TOT_NO_SAL_SPC_TP;
	}

	public BigDecimal getR20_TOT_NO_MER_SPC_TP() {
		return R20_TOT_NO_MER_SPC_TP;
	}

	public void setR20_TOT_NO_MER_SPC_TP(BigDecimal r20_TOT_NO_MER_SPC_TP) {
		R20_TOT_NO_MER_SPC_TP = r20_TOT_NO_MER_SPC_TP;
	}

	public BigDecimal getR20_NO_INQ_SPC_TP() {
		return R20_NO_INQ_SPC_TP;
	}

	public void setR20_NO_INQ_SPC_TP(BigDecimal r20_NO_INQ_SPC_TP) {
		R20_NO_INQ_SPC_TP = r20_NO_INQ_SPC_TP;
	}

	public BigDecimal getR20_NO_SER_SPC_TP() {
		return R20_NO_SER_SPC_TP;
	}

	public void setR20_NO_SER_SPC_TP(BigDecimal r20_NO_SER_SPC_TP) {
		R20_NO_SER_SPC_TP = r20_NO_SER_SPC_TP;
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

	public BigDecimal getR21_NO_EMP_SPC_TP() {
		return R21_NO_EMP_SPC_TP;
	}

	public void setR21_NO_EMP_SPC_TP(BigDecimal r21_NO_EMP_SPC_TP) {
		R21_NO_EMP_SPC_TP = r21_NO_EMP_SPC_TP;
	}

	public BigDecimal getR21_NO_CON_SPC_TP() {
		return R21_NO_CON_SPC_TP;
	}

	public void setR21_NO_CON_SPC_TP(BigDecimal r21_NO_CON_SPC_TP) {
		R21_NO_CON_SPC_TP = r21_NO_CON_SPC_TP;
	}

	public BigDecimal getR21_AVG_NO_EMP_SPC_TP() {
		return R21_AVG_NO_EMP_SPC_TP;
	}

	public void setR21_AVG_NO_EMP_SPC_TP(BigDecimal r21_AVG_NO_EMP_SPC_TP) {
		R21_AVG_NO_EMP_SPC_TP = r21_AVG_NO_EMP_SPC_TP;
	}

	public BigDecimal getR21_NO_BRN_SPC_TP() {
		return R21_NO_BRN_SPC_TP;
	}

	public void setR21_NO_BRN_SPC_TP(BigDecimal r21_NO_BRN_SPC_TP) {
		R21_NO_BRN_SPC_TP = r21_NO_BRN_SPC_TP;
	}

	public BigDecimal getR21_TOT_NO_BRN_POD() {
		return R21_TOT_NO_BRN_POD;
	}

	public void setR21_TOT_NO_BRN_POD(BigDecimal r21_TOT_NO_BRN_POD) {
		R21_TOT_NO_BRN_POD = r21_TOT_NO_BRN_POD;
	}

	public BigDecimal getR21_NO_ATM_SPC_TP() {
		return R21_NO_ATM_SPC_TP;
	}

	public void setR21_NO_ATM_SPC_TP(BigDecimal r21_NO_ATM_SPC_TP) {
		R21_NO_ATM_SPC_TP = r21_NO_ATM_SPC_TP;
	}

	public BigDecimal getR21_NO_ATM_DET_SPC_TP() {
		return R21_NO_ATM_DET_SPC_TP;
	}

	public void setR21_NO_ATM_DET_SPC_TP(BigDecimal r21_NO_ATM_DET_SPC_TP) {
		R21_NO_ATM_DET_SPC_TP = r21_NO_ATM_DET_SPC_TP;
	}

	public BigDecimal getR21_NO_AUT_SPC_TP() {
		return R21_NO_AUT_SPC_TP;
	}

	public void setR21_NO_AUT_SPC_TP(BigDecimal r21_NO_AUT_SPC_TP) {
		R21_NO_AUT_SPC_TP = r21_NO_AUT_SPC_TP;
	}

	public BigDecimal getR21_NO_INS_BNK_SPC_TP() {
		return R21_NO_INS_BNK_SPC_TP;
	}

	public void setR21_NO_INS_BNK_SPC_TP(BigDecimal r21_NO_INS_BNK_SPC_TP) {
		R21_NO_INS_BNK_SPC_TP = r21_NO_INS_BNK_SPC_TP;
	}

	public BigDecimal getR21_NO_INS_DWN_SPC_TP() {
		return R21_NO_INS_DWN_SPC_TP;
	}

	public void setR21_NO_INS_DWN_SPC_TP(BigDecimal r21_NO_INS_DWN_SPC_TP) {
		R21_NO_INS_DWN_SPC_TP = r21_NO_INS_DWN_SPC_TP;
	}

	public BigDecimal getR21_NO_EMP_RSK_SPC_DTE() {
		return R21_NO_EMP_RSK_SPC_DTE;
	}

	public void setR21_NO_EMP_RSK_SPC_DTE(BigDecimal r21_NO_EMP_RSK_SPC_DTE) {
		R21_NO_EMP_RSK_SPC_DTE = r21_NO_EMP_RSK_SPC_DTE;
	}

	public BigDecimal getR21_NO_EXT_FRD_SPC_TP() {
		return R21_NO_EXT_FRD_SPC_TP;
	}

	public void setR21_NO_EXT_FRD_SPC_TP(BigDecimal r21_NO_EXT_FRD_SPC_TP) {
		R21_NO_EXT_FRD_SPC_TP = r21_NO_EXT_FRD_SPC_TP;
	}

	public BigDecimal getR21_NO_INT_FRD_SPC_TP() {
		return R21_NO_INT_FRD_SPC_TP;
	}

	public void setR21_NO_INT_FRD_SPC_TP(BigDecimal r21_NO_INT_FRD_SPC_TP) {
		R21_NO_INT_FRD_SPC_TP = r21_NO_INT_FRD_SPC_TP;
	}

	public BigDecimal getR21_NO_FRD_SPC_TP() {
		return R21_NO_FRD_SPC_TP;
	}

	public void setR21_NO_FRD_SPC_TP(BigDecimal r21_NO_FRD_SPC_TP) {
		R21_NO_FRD_SPC_TP = r21_NO_FRD_SPC_TP;
	}

	public BigDecimal getR21_NO_FRD_PP() {
		return R21_NO_FRD_PP;
	}

	public void setR21_NO_FRD_PP(BigDecimal r21_NO_FRD_PP) {
		R21_NO_FRD_PP = r21_NO_FRD_PP;
	}

	public BigDecimal getR21_TOT_REV_SPC_TP() {
		return R21_TOT_REV_SPC_TP;
	}

	public void setR21_TOT_REV_SPC_TP(BigDecimal r21_TOT_REV_SPC_TP) {
		R21_TOT_REV_SPC_TP = r21_TOT_REV_SPC_TP;
	}

	public BigDecimal getR21_TOT_INS_UNP_SPC_TP() {
		return R21_TOT_INS_UNP_SPC_TP;
	}

	public void setR21_TOT_INS_UNP_SPC_TP(BigDecimal r21_TOT_INS_UNP_SPC_TP) {
		R21_TOT_INS_UNP_SPC_TP = r21_TOT_INS_UNP_SPC_TP;
	}

	public BigDecimal getR21_TOT_NO_HRS_BNK() {
		return R21_TOT_NO_HRS_BNK;
	}

	public void setR21_TOT_NO_HRS_BNK(BigDecimal r21_TOT_NO_HRS_BNK) {
		R21_TOT_NO_HRS_BNK = r21_TOT_NO_HRS_BNK;
	}

	public BigDecimal getR21_TOT_NO_INC_SPC_TP() {
		return R21_TOT_NO_INC_SPC_TP;
	}

	public void setR21_TOT_NO_INC_SPC_TP(BigDecimal r21_TOT_NO_INC_SPC_TP) {
		R21_TOT_NO_INC_SPC_TP = r21_TOT_NO_INC_SPC_TP;
	}

	public BigDecimal getR21_TOT_NO_PEN_SPC_TP() {
		return R21_TOT_NO_PEN_SPC_TP;
	}

	public void setR21_TOT_NO_PEN_SPC_TP(BigDecimal r21_TOT_NO_PEN_SPC_TP) {
		R21_TOT_NO_PEN_SPC_TP = r21_TOT_NO_PEN_SPC_TP;
	}

	public BigDecimal getR21_TOT_NO_AUT_SPC_TP() {
		return R21_TOT_NO_AUT_SPC_TP;
	}

	public void setR21_TOT_NO_AUT_SPC_TP(BigDecimal r21_TOT_NO_AUT_SPC_TP) {
		R21_TOT_NO_AUT_SPC_TP = r21_TOT_NO_AUT_SPC_TP;
	}

	public BigDecimal getR21_TOT_NO_SAL_SPC_TP() {
		return R21_TOT_NO_SAL_SPC_TP;
	}

	public void setR21_TOT_NO_SAL_SPC_TP(BigDecimal r21_TOT_NO_SAL_SPC_TP) {
		R21_TOT_NO_SAL_SPC_TP = r21_TOT_NO_SAL_SPC_TP;
	}

	public BigDecimal getR21_TOT_NO_MER_SPC_TP() {
		return R21_TOT_NO_MER_SPC_TP;
	}

	public void setR21_TOT_NO_MER_SPC_TP(BigDecimal r21_TOT_NO_MER_SPC_TP) {
		R21_TOT_NO_MER_SPC_TP = r21_TOT_NO_MER_SPC_TP;
	}

	public BigDecimal getR21_NO_INQ_SPC_TP() {
		return R21_NO_INQ_SPC_TP;
	}

	public void setR21_NO_INQ_SPC_TP(BigDecimal r21_NO_INQ_SPC_TP) {
		R21_NO_INQ_SPC_TP = r21_NO_INQ_SPC_TP;
	}

	public BigDecimal getR21_NO_SER_SPC_TP() {
		return R21_NO_SER_SPC_TP;
	}

	public void setR21_NO_SER_SPC_TP(BigDecimal r21_NO_SER_SPC_TP) {
		R21_NO_SER_SPC_TP = r21_NO_SER_SPC_TP;
	}

	public String getR22_PRODUCT() {
		return R22_PRODUCT;
	}

	public void setR22_PRODUCT(String r22_PRODUCT) {
		R22_PRODUCT = r22_PRODUCT;
	}

	public String getR22_BANK() {
		return R22_BANK;
	}

	public void setR22_BANK(String r22_BANK) {
		R22_BANK = r22_BANK;
	}

	public String getR22_NO_EMP_SPC_TP() {
		return R22_NO_EMP_SPC_TP;
	}

	public void setR22_NO_EMP_SPC_TP(String r22_NO_EMP_SPC_TP) {
		R22_NO_EMP_SPC_TP = r22_NO_EMP_SPC_TP;
	}

	public String getR22_NO_CON_SPC_TP() {
		return R22_NO_CON_SPC_TP;
	}

	public void setR22_NO_CON_SPC_TP(String r22_NO_CON_SPC_TP) {
		R22_NO_CON_SPC_TP = r22_NO_CON_SPC_TP;
	}

	public String getR22_AVG_NO_EMP_SPC_TP() {
		return R22_AVG_NO_EMP_SPC_TP;
	}

	public void setR22_AVG_NO_EMP_SPC_TP(String r22_AVG_NO_EMP_SPC_TP) {
		R22_AVG_NO_EMP_SPC_TP = r22_AVG_NO_EMP_SPC_TP;
	}

	public String getR22_NO_BRN_SPC_TP() {
		return R22_NO_BRN_SPC_TP;
	}

	public void setR22_NO_BRN_SPC_TP(String r22_NO_BRN_SPC_TP) {
		R22_NO_BRN_SPC_TP = r22_NO_BRN_SPC_TP;
	}

	public String getR22_TOT_NO_BRN_POD() {
		return R22_TOT_NO_BRN_POD;
	}

	public void setR22_TOT_NO_BRN_POD(String r22_TOT_NO_BRN_POD) {
		R22_TOT_NO_BRN_POD = r22_TOT_NO_BRN_POD;
	}

	public String getR22_NO_ATM_SPC_TP() {
		return R22_NO_ATM_SPC_TP;
	}

	public void setR22_NO_ATM_SPC_TP(String r22_NO_ATM_SPC_TP) {
		R22_NO_ATM_SPC_TP = r22_NO_ATM_SPC_TP;
	}

	public String getR22_NO_ATM_DET_SPC_TP() {
		return R22_NO_ATM_DET_SPC_TP;
	}

	public void setR22_NO_ATM_DET_SPC_TP(String r22_NO_ATM_DET_SPC_TP) {
		R22_NO_ATM_DET_SPC_TP = r22_NO_ATM_DET_SPC_TP;
	}

	public String getR22_NO_AUT_SPC_TP() {
		return R22_NO_AUT_SPC_TP;
	}

	public void setR22_NO_AUT_SPC_TP(String r22_NO_AUT_SPC_TP) {
		R22_NO_AUT_SPC_TP = r22_NO_AUT_SPC_TP;
	}

	public String getR22_NO_INS_BNK_SPC_TP() {
		return R22_NO_INS_BNK_SPC_TP;
	}

	public void setR22_NO_INS_BNK_SPC_TP(String r22_NO_INS_BNK_SPC_TP) {
		R22_NO_INS_BNK_SPC_TP = r22_NO_INS_BNK_SPC_TP;
	}

	public String getR22_NO_INS_DWN_SPC_TP() {
		return R22_NO_INS_DWN_SPC_TP;
	}

	public void setR22_NO_INS_DWN_SPC_TP(String r22_NO_INS_DWN_SPC_TP) {
		R22_NO_INS_DWN_SPC_TP = r22_NO_INS_DWN_SPC_TP;
	}

	public String getR22_NO_EMP_RSK_SPC_DTE() {
		return R22_NO_EMP_RSK_SPC_DTE;
	}

	public void setR22_NO_EMP_RSK_SPC_DTE(String r22_NO_EMP_RSK_SPC_DTE) {
		R22_NO_EMP_RSK_SPC_DTE = r22_NO_EMP_RSK_SPC_DTE;
	}

	public String getR22_NO_EXT_FRD_SPC_TP() {
		return R22_NO_EXT_FRD_SPC_TP;
	}

	public void setR22_NO_EXT_FRD_SPC_TP(String r22_NO_EXT_FRD_SPC_TP) {
		R22_NO_EXT_FRD_SPC_TP = r22_NO_EXT_FRD_SPC_TP;
	}

	public String getR22_NO_INT_FRD_SPC_TP() {
		return R22_NO_INT_FRD_SPC_TP;
	}

	public void setR22_NO_INT_FRD_SPC_TP(String r22_NO_INT_FRD_SPC_TP) {
		R22_NO_INT_FRD_SPC_TP = r22_NO_INT_FRD_SPC_TP;
	}

	public String getR22_NO_FRD_SPC_TP() {
		return R22_NO_FRD_SPC_TP;
	}

	public void setR22_NO_FRD_SPC_TP(String r22_NO_FRD_SPC_TP) {
		R22_NO_FRD_SPC_TP = r22_NO_FRD_SPC_TP;
	}

	public String getR22_NO_FRD_PP() {
		return R22_NO_FRD_PP;
	}

	public void setR22_NO_FRD_PP(String r22_NO_FRD_PP) {
		R22_NO_FRD_PP = r22_NO_FRD_PP;
	}

	public String getR22_TOT_REV_SPC_TP() {
		return R22_TOT_REV_SPC_TP;
	}

	public void setR22_TOT_REV_SPC_TP(String r22_TOT_REV_SPC_TP) {
		R22_TOT_REV_SPC_TP = r22_TOT_REV_SPC_TP;
	}

	public String getR22_TOT_INS_UNP_SPC_TP() {
		return R22_TOT_INS_UNP_SPC_TP;
	}

	public void setR22_TOT_INS_UNP_SPC_TP(String r22_TOT_INS_UNP_SPC_TP) {
		R22_TOT_INS_UNP_SPC_TP = r22_TOT_INS_UNP_SPC_TP;
	}

	public String getR22_TOT_NO_HRS_BNK() {
		return R22_TOT_NO_HRS_BNK;
	}

	public void setR22_TOT_NO_HRS_BNK(String r22_TOT_NO_HRS_BNK) {
		R22_TOT_NO_HRS_BNK = r22_TOT_NO_HRS_BNK;
	}

	public String getR22_TOT_NO_INC_SPC_TP() {
		return R22_TOT_NO_INC_SPC_TP;
	}

	public void setR22_TOT_NO_INC_SPC_TP(String r22_TOT_NO_INC_SPC_TP) {
		R22_TOT_NO_INC_SPC_TP = r22_TOT_NO_INC_SPC_TP;
	}

	public String getR22_TOT_NO_PEN_SPC_TP() {
		return R22_TOT_NO_PEN_SPC_TP;
	}

	public void setR22_TOT_NO_PEN_SPC_TP(String r22_TOT_NO_PEN_SPC_TP) {
		R22_TOT_NO_PEN_SPC_TP = r22_TOT_NO_PEN_SPC_TP;
	}

	public String getR22_TOT_NO_AUT_SPC_TP() {
		return R22_TOT_NO_AUT_SPC_TP;
	}

	public void setR22_TOT_NO_AUT_SPC_TP(String r22_TOT_NO_AUT_SPC_TP) {
		R22_TOT_NO_AUT_SPC_TP = r22_TOT_NO_AUT_SPC_TP;
	}

	public String getR22_TOT_NO_SAL_SPC_TP() {
		return R22_TOT_NO_SAL_SPC_TP;
	}

	public void setR22_TOT_NO_SAL_SPC_TP(String r22_TOT_NO_SAL_SPC_TP) {
		R22_TOT_NO_SAL_SPC_TP = r22_TOT_NO_SAL_SPC_TP;
	}

	public String getR22_TOT_NO_MER_SPC_TP() {
		return R22_TOT_NO_MER_SPC_TP;
	}

	public void setR22_TOT_NO_MER_SPC_TP(String r22_TOT_NO_MER_SPC_TP) {
		R22_TOT_NO_MER_SPC_TP = r22_TOT_NO_MER_SPC_TP;
	}

	public String getR22_NO_INQ_SPC_TP() {
		return R22_NO_INQ_SPC_TP;
	}

	public void setR22_NO_INQ_SPC_TP(String r22_NO_INQ_SPC_TP) {
		R22_NO_INQ_SPC_TP = r22_NO_INQ_SPC_TP;
	}

	public String getR22_NO_SER_SPC_TP() {
		return R22_NO_SER_SPC_TP;
	}

	public void setR22_NO_SER_SPC_TP(String r22_NO_SER_SPC_TP) {
		R22_NO_SER_SPC_TP = r22_NO_SER_SPC_TP;
	}

	public String getR23_PRODUCT() {
		return R23_PRODUCT;
	}

	public void setR23_PRODUCT(String r23_PRODUCT) {
		R23_PRODUCT = r23_PRODUCT;
	}

	public String getR23_NO_EMP_SPC_TP() {
		return R23_NO_EMP_SPC_TP;
	}

	public void setR23_NO_EMP_SPC_TP(String r23_NO_EMP_SPC_TP) {
		R23_NO_EMP_SPC_TP = r23_NO_EMP_SPC_TP;
	}

	public String getR23_NO_CON_SPC_TP() {
		return R23_NO_CON_SPC_TP;
	}

	public void setR23_NO_CON_SPC_TP(String r23_NO_CON_SPC_TP) {
		R23_NO_CON_SPC_TP = r23_NO_CON_SPC_TP;
	}

	public String getR23_AVG_NO_EMP_SPC_TP() {
		return R23_AVG_NO_EMP_SPC_TP;
	}

	public void setR23_AVG_NO_EMP_SPC_TP(String r23_AVG_NO_EMP_SPC_TP) {
		R23_AVG_NO_EMP_SPC_TP = r23_AVG_NO_EMP_SPC_TP;
	}

	public String getR23_NO_BRN_SPC_TP() {
		return R23_NO_BRN_SPC_TP;
	}

	public void setR23_NO_BRN_SPC_TP(String r23_NO_BRN_SPC_TP) {
		R23_NO_BRN_SPC_TP = r23_NO_BRN_SPC_TP;
	}

	public String getR23_TOT_NO_BRN_POD() {
		return R23_TOT_NO_BRN_POD;
	}

	public void setR23_TOT_NO_BRN_POD(String r23_TOT_NO_BRN_POD) {
		R23_TOT_NO_BRN_POD = r23_TOT_NO_BRN_POD;
	}

	public String getR23_NO_ATM_SPC_TP() {
		return R23_NO_ATM_SPC_TP;
	}

	public void setR23_NO_ATM_SPC_TP(String r23_NO_ATM_SPC_TP) {
		R23_NO_ATM_SPC_TP = r23_NO_ATM_SPC_TP;
	}

	public String getR23_NO_ATM_DET_SPC_TP() {
		return R23_NO_ATM_DET_SPC_TP;
	}

	public void setR23_NO_ATM_DET_SPC_TP(String r23_NO_ATM_DET_SPC_TP) {
		R23_NO_ATM_DET_SPC_TP = r23_NO_ATM_DET_SPC_TP;
	}

	public String getR23_NO_AUT_SPC_TP() {
		return R23_NO_AUT_SPC_TP;
	}

	public void setR23_NO_AUT_SPC_TP(String r23_NO_AUT_SPC_TP) {
		R23_NO_AUT_SPC_TP = r23_NO_AUT_SPC_TP;
	}

	public String getR23_NO_INS_BNK_SPC_TP() {
		return R23_NO_INS_BNK_SPC_TP;
	}

	public void setR23_NO_INS_BNK_SPC_TP(String r23_NO_INS_BNK_SPC_TP) {
		R23_NO_INS_BNK_SPC_TP = r23_NO_INS_BNK_SPC_TP;
	}

	public String getR23_NO_INS_DWN_SPC_TP() {
		return R23_NO_INS_DWN_SPC_TP;
	}

	public void setR23_NO_INS_DWN_SPC_TP(String r23_NO_INS_DWN_SPC_TP) {
		R23_NO_INS_DWN_SPC_TP = r23_NO_INS_DWN_SPC_TP;
	}

	public String getR23_NO_EMP_RSK_SPC_DTE() {
		return R23_NO_EMP_RSK_SPC_DTE;
	}

	public void setR23_NO_EMP_RSK_SPC_DTE(String r23_NO_EMP_RSK_SPC_DTE) {
		R23_NO_EMP_RSK_SPC_DTE = r23_NO_EMP_RSK_SPC_DTE;
	}

	public String getR23_NO_EXT_FRD_SPC_TP() {
		return R23_NO_EXT_FRD_SPC_TP;
	}

	public void setR23_NO_EXT_FRD_SPC_TP(String r23_NO_EXT_FRD_SPC_TP) {
		R23_NO_EXT_FRD_SPC_TP = r23_NO_EXT_FRD_SPC_TP;
	}

	public String getR23_NO_INT_FRD_SPC_TP() {
		return R23_NO_INT_FRD_SPC_TP;
	}

	public void setR23_NO_INT_FRD_SPC_TP(String r23_NO_INT_FRD_SPC_TP) {
		R23_NO_INT_FRD_SPC_TP = r23_NO_INT_FRD_SPC_TP;
	}

	public String getR23_NO_FRD_SPC_TP() {
		return R23_NO_FRD_SPC_TP;
	}

	public void setR23_NO_FRD_SPC_TP(String r23_NO_FRD_SPC_TP) {
		R23_NO_FRD_SPC_TP = r23_NO_FRD_SPC_TP;
	}

	public String getR23_NO_FRD_PP() {
		return R23_NO_FRD_PP;
	}

	public void setR23_NO_FRD_PP(String r23_NO_FRD_PP) {
		R23_NO_FRD_PP = r23_NO_FRD_PP;
	}

	public String getR23_TOT_REV_SPC_TP() {
		return R23_TOT_REV_SPC_TP;
	}

	public void setR23_TOT_REV_SPC_TP(String r23_TOT_REV_SPC_TP) {
		R23_TOT_REV_SPC_TP = r23_TOT_REV_SPC_TP;
	}

	public String getR23_TOT_INS_UNP_SPC_TP() {
		return R23_TOT_INS_UNP_SPC_TP;
	}

	public void setR23_TOT_INS_UNP_SPC_TP(String r23_TOT_INS_UNP_SPC_TP) {
		R23_TOT_INS_UNP_SPC_TP = r23_TOT_INS_UNP_SPC_TP;
	}

	public String getR23_TOT_NO_HRS_BNK() {
		return R23_TOT_NO_HRS_BNK;
	}

	public void setR23_TOT_NO_HRS_BNK(String r23_TOT_NO_HRS_BNK) {
		R23_TOT_NO_HRS_BNK = r23_TOT_NO_HRS_BNK;
	}

	public String getR23_TOT_NO_INC_SPC_TP() {
		return R23_TOT_NO_INC_SPC_TP;
	}

	public void setR23_TOT_NO_INC_SPC_TP(String r23_TOT_NO_INC_SPC_TP) {
		R23_TOT_NO_INC_SPC_TP = r23_TOT_NO_INC_SPC_TP;
	}

	public String getR23_TOT_NO_PEN_SPC_TP() {
		return R23_TOT_NO_PEN_SPC_TP;
	}

	public void setR23_TOT_NO_PEN_SPC_TP(String r23_TOT_NO_PEN_SPC_TP) {
		R23_TOT_NO_PEN_SPC_TP = r23_TOT_NO_PEN_SPC_TP;
	}

	public String getR23_TOT_NO_AUT_SPC_TP() {
		return R23_TOT_NO_AUT_SPC_TP;
	}

	public void setR23_TOT_NO_AUT_SPC_TP(String r23_TOT_NO_AUT_SPC_TP) {
		R23_TOT_NO_AUT_SPC_TP = r23_TOT_NO_AUT_SPC_TP;
	}

	public String getR23_TOT_NO_SAL_SPC_TP() {
		return R23_TOT_NO_SAL_SPC_TP;
	}

	public void setR23_TOT_NO_SAL_SPC_TP(String r23_TOT_NO_SAL_SPC_TP) {
		R23_TOT_NO_SAL_SPC_TP = r23_TOT_NO_SAL_SPC_TP;
	}

	public String getR23_TOT_NO_MER_SPC_TP() {
		return R23_TOT_NO_MER_SPC_TP;
	}

	public void setR23_TOT_NO_MER_SPC_TP(String r23_TOT_NO_MER_SPC_TP) {
		R23_TOT_NO_MER_SPC_TP = r23_TOT_NO_MER_SPC_TP;
	}

	public String getR23_NO_INQ_SPC_TP() {
		return R23_NO_INQ_SPC_TP;
	}

	public void setR23_NO_INQ_SPC_TP(String r23_NO_INQ_SPC_TP) {
		R23_NO_INQ_SPC_TP = r23_NO_INQ_SPC_TP;
	}

	public String getR23_NO_SER_SPC_TP() {
		return R23_NO_SER_SPC_TP;
	}

	public void setR23_NO_SER_SPC_TP(String r23_NO_SER_SPC_TP) {
		R23_NO_SER_SPC_TP = r23_NO_SER_SPC_TP;
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
