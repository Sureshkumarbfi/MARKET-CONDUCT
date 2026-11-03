package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "RT_IRS_SUMMARY_TABLE1")
public class RT_IRS_ENTITY {

	@Id
	private String	srl_no;
	private String	r7_product;
	private BigDecimal	r7_day1_28;
	private BigDecimal	r7_day29_3m;
	private BigDecimal	r7_over3m_to_6m;
	private BigDecimal	r7_over6m_to_1y;
	private BigDecimal	r7_over1y_to_3y;
	private BigDecimal	r7_over3y_to_5y;
	private BigDecimal	r7_over5y_to_7y;
	private BigDecimal	r7_over7y_to_10y;
	private BigDecimal	r7_over10y_to_15y;
	private BigDecimal	r7_over15y;
	private BigDecimal	r7_non_sensitive;
	private BigDecimal	r7_total_rsl;
	private BigDecimal	r7_total;
	private String	r8_product;
	private BigDecimal	r8_day1_28;
	private BigDecimal	r8_day29_3m;
	private BigDecimal	r8_over3m_to_6m;
	private BigDecimal	r8_over6m_to_1y;
	private BigDecimal	r8_over1y_to_3y;
	private BigDecimal	r8_over3y_to_5y;
	private BigDecimal	r8_over5y_to_7y;
	private BigDecimal	r8_over7y_to_10y;
	private BigDecimal	r8_over10y_to_15y;
	private BigDecimal	r8_over15y;
	private BigDecimal	r8_non_sensitive;
	private BigDecimal	r8_total_rsl;
	private BigDecimal	r8_total;
	private String	r9_product;
	private BigDecimal	r9_day1_28;
	private BigDecimal	r9_day29_3m;
	private BigDecimal	r9_over3m_to_6m;
	private BigDecimal	r9_over6m_to_1y;
	private BigDecimal	r9_over1y_to_3y;
	private BigDecimal	r9_over3y_to_5y;
	private BigDecimal	r9_over5y_to_7y;
	private BigDecimal	r9_over7y_to_10y;
	private BigDecimal	r9_over10y_to_15y;
	private BigDecimal	r9_over15y;
	private BigDecimal	r9_non_sensitive;
	private BigDecimal	r9_total_rsl;
	private BigDecimal	r9_total;
	private String	r10_product;
	private BigDecimal	r10_day1_28;
	private BigDecimal	r10_day29_3m;
	private BigDecimal	r10_over3m_to_6m;
	private BigDecimal	r10_over6m_to_1y;
	private BigDecimal	r10_over1y_to_3y;
	private BigDecimal	r10_over3y_to_5y;
	private BigDecimal	r10_over5y_to_7y;
	private BigDecimal	r10_over7y_to_10y;
	private BigDecimal	r10_over10y_to_15y;
	private BigDecimal	r10_over15y;
	private BigDecimal	r10_non_sensitive;
	private BigDecimal	r10_total_rsl;
	private BigDecimal	r10_total;
	private String	r11_product;
	private BigDecimal	r11_day1_28;
	private BigDecimal	r11_day29_3m;
	private BigDecimal	r11_over3m_to_6m;
	private BigDecimal	r11_over6m_to_1y;
	private BigDecimal	r11_over1y_to_3y;
	private BigDecimal	r11_over3y_to_5y;
	private BigDecimal	r11_over5y_to_7y;
	private BigDecimal	r11_over7y_to_10y;
	private BigDecimal	r11_over10y_to_15y;
	private BigDecimal	r11_over15y;
	private BigDecimal	r11_non_sensitive;
	private BigDecimal	r11_total_rsl;
	private BigDecimal	r11_total;
	private String	r12_product;
	private BigDecimal	r12_day1_28;
	private BigDecimal	r12_day29_3m;
	private BigDecimal	r12_over3m_to_6m;
	private BigDecimal	r12_over6m_to_1y;
	private BigDecimal	r12_over1y_to_3y;
	private BigDecimal	r12_over3y_to_5y;
	private BigDecimal	r12_over5y_to_7y;
	private BigDecimal	r12_over7y_to_10y;
	private BigDecimal	r12_over10y_to_15y;
	private BigDecimal	r12_over15y;
	private BigDecimal	r12_non_sensitive;
	private BigDecimal	r12_total_rsl;
	private BigDecimal	r12_total;
	private String	r13_product;
	private BigDecimal	r13_day1_28;
	private BigDecimal	r13_day29_3m;
	private BigDecimal	r13_over3m_to_6m;
	private BigDecimal	r13_over6m_to_1y;
	private BigDecimal	r13_over1y_to_3y;
	private BigDecimal	r13_over3y_to_5y;
	private BigDecimal	r13_over5y_to_7y;
	private BigDecimal	r13_over7y_to_10y;
	private BigDecimal	r13_over10y_to_15y;
	private BigDecimal	r13_over15y;
	private BigDecimal	r13_non_sensitive;
	private BigDecimal	r13_total_rsl;
	private BigDecimal	r13_total;
	private String	r14_product;
	private BigDecimal	r14_day1_28;
	private BigDecimal	r14_day29_3m;
	private BigDecimal	r14_over3m_to_6m;
	private BigDecimal	r14_over6m_to_1y;
	private BigDecimal	r14_over1y_to_3y;
	private BigDecimal	r14_over3y_to_5y;
	private BigDecimal	r14_over5y_to_7y;
	private BigDecimal	r14_over7y_to_10y;
	private BigDecimal	r14_over10y_to_15y;
	private BigDecimal	r14_over15y;
	private BigDecimal	r14_non_sensitive;
	private BigDecimal	r14_total_rsl;
	private BigDecimal	r14_total;
	private String	r15_product;
	private BigDecimal	r15_day1_28;
	private BigDecimal	r15_day29_3m;
	private BigDecimal	r15_over3m_to_6m;
	private BigDecimal	r15_over6m_to_1y;
	private BigDecimal	r15_over1y_to_3y;
	private BigDecimal	r15_over3y_to_5y;
	private BigDecimal	r15_over5y_to_7y;
	private BigDecimal	r15_over7y_to_10y;
	private BigDecimal	r15_over10y_to_15y;
	private BigDecimal	r15_over15y;
	private BigDecimal	r15_non_sensitive;
	private BigDecimal	r15_total_rsl;
	private BigDecimal	r15_total;
	private String	r16_product;
	private BigDecimal	r16_day1_28;
	private BigDecimal	r16_day29_3m;
	private BigDecimal	r16_over3m_to_6m;
	private BigDecimal	r16_over6m_to_1y;
	private BigDecimal	r16_over1y_to_3y;
	private BigDecimal	r16_over3y_to_5y;
	private BigDecimal	r16_over5y_to_7y;
	private BigDecimal	r16_over7y_to_10y;
	private BigDecimal	r16_over10y_to_15y;
	private BigDecimal	r16_over15y;
	private BigDecimal	r16_non_sensitive;
	private BigDecimal	r16_total_rsl;
	private BigDecimal	r16_total;
	private String	r17_product;
	private BigDecimal	r17_day1_28;
	private BigDecimal	r17_day29_3m;
	private BigDecimal	r17_over3m_to_6m;
	private BigDecimal	r17_over6m_to_1y;
	private BigDecimal	r17_over1y_to_3y;
	private BigDecimal	r17_over3y_to_5y;
	private BigDecimal	r17_over5y_to_7y;
	private BigDecimal	r17_over7y_to_10y;
	private BigDecimal	r17_over10y_to_15y;
	private BigDecimal	r17_over15y;
	private BigDecimal	r17_non_sensitive;
	private BigDecimal	r17_total_rsl;
	private BigDecimal	r17_total;
	private String	r18_product;
	private BigDecimal	r18_day1_28;
	private BigDecimal	r18_day29_3m;
	private BigDecimal	r18_over3m_to_6m;
	private BigDecimal	r18_over6m_to_1y;
	private BigDecimal	r18_over1y_to_3y;
	private BigDecimal	r18_over3y_to_5y;
	private BigDecimal	r18_over5y_to_7y;
	private BigDecimal	r18_over7y_to_10y;
	private BigDecimal	r18_over10y_to_15y;
	private BigDecimal	r18_over15y;
	private BigDecimal	r18_non_sensitive;
	private BigDecimal	r18_total_rsl;
	private BigDecimal	r18_total;
	private String	r19_product;
	private BigDecimal	r19_day1_28;
	private BigDecimal	r19_day29_3m;
	private BigDecimal	r19_over3m_to_6m;
	private BigDecimal	r19_over6m_to_1y;
	private BigDecimal	r19_over1y_to_3y;
	private BigDecimal	r19_over3y_to_5y;
	private BigDecimal	r19_over5y_to_7y;
	private BigDecimal	r19_over7y_to_10y;
	private BigDecimal	r19_over10y_to_15y;
	private BigDecimal	r19_over15y;
	private BigDecimal	r19_non_sensitive;
	private BigDecimal	r19_total_rsl;
	private BigDecimal	r19_total;
	private String	r20_product;
	private BigDecimal	r20_day1_28;
	private BigDecimal	r20_day29_3m;
	private BigDecimal	r20_over3m_to_6m;
	private BigDecimal	r20_over6m_to_1y;
	private BigDecimal	r20_over1y_to_3y;
	private BigDecimal	r20_over3y_to_5y;
	private BigDecimal	r20_over5y_to_7y;
	private BigDecimal	r20_over7y_to_10y;
	private BigDecimal	r20_over10y_to_15y;
	private BigDecimal	r20_over15y;
	private BigDecimal	r20_non_sensitive;
	private BigDecimal	r20_total_rsl;
	private BigDecimal	r20_total;
	private String	r21_product;
	private BigDecimal	r21_day1_28;
	private BigDecimal	r21_day29_3m;
	private BigDecimal	r21_over3m_to_6m;
	private BigDecimal	r21_over6m_to_1y;
	private BigDecimal	r21_over1y_to_3y;
	private BigDecimal	r21_over3y_to_5y;
	private BigDecimal	r21_over5y_to_7y;
	private BigDecimal	r21_over7y_to_10y;
	private BigDecimal	r21_over10y_to_15y;
	private BigDecimal	r21_over15y;
	private BigDecimal	r21_non_sensitive;
	private BigDecimal	r21_total_rsl;
	private BigDecimal	r21_total;
	private String	r22_product;
	private BigDecimal	r22_day1_28;
	private BigDecimal	r22_day29_3m;
	private BigDecimal	r22_over3m_to_6m;
	private BigDecimal	r22_over6m_to_1y;
	private BigDecimal	r22_over1y_to_3y;
	private BigDecimal	r22_over3y_to_5y;
	private BigDecimal	r22_over5y_to_7y;
	private BigDecimal	r22_over7y_to_10y;
	private BigDecimal	r22_over10y_to_15y;
	private BigDecimal	r22_over15y;
	private BigDecimal	r22_non_sensitive;
	private BigDecimal	r22_total_rsl;
	private BigDecimal	r22_total;
	private String	r23_product;
	private BigDecimal	r23_day1_28;
	private BigDecimal	r23_day29_3m;
	private BigDecimal	r23_over3m_to_6m;
	private BigDecimal	r23_over6m_to_1y;
	private BigDecimal	r23_over1y_to_3y;
	private BigDecimal	r23_over3y_to_5y;
	private BigDecimal	r23_over5y_to_7y;
	private BigDecimal	r23_over7y_to_10y;
	private BigDecimal	r23_over10y_to_15y;
	private BigDecimal	r23_over15y;
	private BigDecimal	r23_non_sensitive;
	private BigDecimal	r23_total_rsl;
	private BigDecimal	r23_total;
	private String	r24_product;
	private BigDecimal	r24_day1_28;
	private BigDecimal	r24_day29_3m;
	private BigDecimal	r24_over3m_to_6m;
	private BigDecimal	r24_over6m_to_1y;
	private BigDecimal	r24_over1y_to_3y;
	private BigDecimal	r24_over3y_to_5y;
	private BigDecimal	r24_over5y_to_7y;
	private BigDecimal	r24_over7y_to_10y;
	private BigDecimal	r24_over10y_to_15y;
	private BigDecimal	r24_over15y;
	private BigDecimal	r24_non_sensitive;
	private BigDecimal	r24_total_rsl;
	private BigDecimal	r24_total;
	private String	r25_product;
	private BigDecimal	r25_day1_28;
	private BigDecimal	r25_day29_3m;
	private BigDecimal	r25_over3m_to_6m;
	private BigDecimal	r25_over6m_to_1y;
	private BigDecimal	r25_over1y_to_3y;
	private BigDecimal	r25_over3y_to_5y;
	private BigDecimal	r25_over5y_to_7y;
	private BigDecimal	r25_over7y_to_10y;
	private BigDecimal	r25_over10y_to_15y;
	private BigDecimal	r25_over15y;
	private BigDecimal	r25_non_sensitive;
	private BigDecimal	r25_total_rsl;
	private BigDecimal	r25_total;
	private String	r26_product;
	private BigDecimal	r26_day1_28;
	private BigDecimal	r26_day29_3m;
	private BigDecimal	r26_over3m_to_6m;
	private BigDecimal	r26_over6m_to_1y;
	private BigDecimal	r26_over1y_to_3y;
	private BigDecimal	r26_over3y_to_5y;
	private BigDecimal	r26_over5y_to_7y;
	private BigDecimal	r26_over7y_to_10y;
	private BigDecimal	r26_over10y_to_15y;
	private BigDecimal	r26_over15y;
	private BigDecimal	r26_non_sensitive;
	private BigDecimal	r26_total_rsl;
	private BigDecimal	r26_total;
	private String	r27_product;
	private BigDecimal	r27_day1_28;
	private BigDecimal	r27_day29_3m;
	private BigDecimal	r27_over3m_to_6m;
	private BigDecimal	r27_over6m_to_1y;
	private BigDecimal	r27_over1y_to_3y;
	private BigDecimal	r27_over3y_to_5y;
	private BigDecimal	r27_over5y_to_7y;
	private BigDecimal	r27_over7y_to_10y;
	private BigDecimal	r27_over10y_to_15y;
	private BigDecimal	r27_over15y;
	private BigDecimal	r27_non_sensitive;
	private BigDecimal	r27_total_rsl;
	private BigDecimal	r27_total;
	private String	r28_product;
	private BigDecimal	r28_day1_28;
	private BigDecimal	r28_day29_3m;
	private BigDecimal	r28_over3m_to_6m;
	private BigDecimal	r28_over6m_to_1y;
	private BigDecimal	r28_over1y_to_3y;
	private BigDecimal	r28_over3y_to_5y;
	private BigDecimal	r28_over5y_to_7y;
	private BigDecimal	r28_over7y_to_10y;
	private BigDecimal	r28_over10y_to_15y;
	private BigDecimal	r28_over15y;
	private BigDecimal	r28_non_sensitive;
	private BigDecimal	r28_total_rsl;
	private BigDecimal	r28_total;
	private String	r29_product;
	private BigDecimal	r29_day1_28;
	private BigDecimal	r29_day29_3m;
	private BigDecimal	r29_over3m_to_6m;
	private BigDecimal	r29_over6m_to_1y;
	private BigDecimal	r29_over1y_to_3y;
	private BigDecimal	r29_over3y_to_5y;
	private BigDecimal	r29_over5y_to_7y;
	private BigDecimal	r29_over7y_to_10y;
	private BigDecimal	r29_over10y_to_15y;
	private BigDecimal	r29_over15y;
	private BigDecimal	r29_non_sensitive;
	private BigDecimal	r29_total_rsl;
	private BigDecimal	r29_total;
	private String	r30_product;
	private BigDecimal	r30_day1_28;
	private BigDecimal	r30_day29_3m;
	private BigDecimal	r30_over3m_to_6m;
	private BigDecimal	r30_over6m_to_1y;
	private BigDecimal	r30_over1y_to_3y;
	private BigDecimal	r30_over3y_to_5y;
	private BigDecimal	r30_over5y_to_7y;
	private BigDecimal	r30_over7y_to_10y;
	private BigDecimal	r30_over10y_to_15y;
	private BigDecimal	r30_over15y;
	private BigDecimal	r30_non_sensitive;
	private BigDecimal	r30_total_rsl;
	private BigDecimal	r30_total;
	private String	r31_product;
	private BigDecimal	r31_day1_28;
	private BigDecimal	r31_day29_3m;
	private BigDecimal	r31_over3m_to_6m;
	private BigDecimal	r31_over6m_to_1y;
	private BigDecimal	r31_over1y_to_3y;
	private BigDecimal	r31_over3y_to_5y;
	private BigDecimal	r31_over5y_to_7y;
	private BigDecimal	r31_over7y_to_10y;
	private BigDecimal	r31_over10y_to_15y;
	private BigDecimal	r31_over15y;
	private BigDecimal	r31_non_sensitive;
	private BigDecimal	r31_total_rsl;
	private BigDecimal	r31_total;
	private String	r32_product;
	private BigDecimal	r32_day1_28;
	private BigDecimal	r32_day29_3m;
	private BigDecimal	r32_over3m_to_6m;
	private BigDecimal	r32_over6m_to_1y;
	private BigDecimal	r32_over1y_to_3y;
	private BigDecimal	r32_over3y_to_5y;
	private BigDecimal	r32_over5y_to_7y;
	private BigDecimal	r32_over7y_to_10y;
	private BigDecimal	r32_over10y_to_15y;
	private BigDecimal	r32_over15y;
	private BigDecimal	r32_non_sensitive;
	private BigDecimal	r32_total_rsl;
	private BigDecimal	r32_total;
	private String	r33_product;
	private BigDecimal	r33_day1_28;
	private BigDecimal	r33_day29_3m;
	private BigDecimal	r33_over3m_to_6m;
	private BigDecimal	r33_over6m_to_1y;
	private BigDecimal	r33_over1y_to_3y;
	private BigDecimal	r33_over3y_to_5y;
	private BigDecimal	r33_over5y_to_7y;
	private BigDecimal	r33_over7y_to_10y;
	private BigDecimal	r33_over10y_to_15y;
	private BigDecimal	r33_over15y;
	private BigDecimal	r33_non_sensitive;
	private BigDecimal	r33_total_rsl;
	private BigDecimal	r33_total;
	private String	r34_product;
	private BigDecimal	r34_day1_28;
	private BigDecimal	r34_day29_3m;
	private BigDecimal	r34_over3m_to_6m;
	private BigDecimal	r34_over6m_to_1y;
	private BigDecimal	r34_over1y_to_3y;
	private BigDecimal	r34_over3y_to_5y;
	private BigDecimal	r34_over5y_to_7y;
	private BigDecimal	r34_over7y_to_10y;
	private BigDecimal	r34_over10y_to_15y;
	private BigDecimal	r34_over15y;
	private BigDecimal	r34_non_sensitive;
	private BigDecimal	r34_total_rsl;
	private BigDecimal	r34_total;
	private String	r35_product;
	private BigDecimal	r35_day1_28;
	private BigDecimal	r35_day29_3m;
	private BigDecimal	r35_over3m_to_6m;
	private BigDecimal	r35_over6m_to_1y;
	private BigDecimal	r35_over1y_to_3y;
	private BigDecimal	r35_over3y_to_5y;
	private BigDecimal	r35_over5y_to_7y;
	private BigDecimal	r35_over7y_to_10y;
	private BigDecimal	r35_over10y_to_15y;
	private BigDecimal	r35_over15y;
	private BigDecimal	r35_non_sensitive;
	private BigDecimal	r35_total_rsl;
	private BigDecimal	r35_total;
	private String	r36_product;
	private BigDecimal	r36_day1_28;
	private BigDecimal	r36_day29_3m;
	private BigDecimal	r36_over3m_to_6m;
	private BigDecimal	r36_over6m_to_1y;
	private BigDecimal	r36_over1y_to_3y;
	private BigDecimal	r36_over3y_to_5y;
	private BigDecimal	r36_over5y_to_7y;
	private BigDecimal	r36_over7y_to_10y;
	private BigDecimal	r36_over10y_to_15y;
	private BigDecimal	r36_over15y;
	private BigDecimal	r36_non_sensitive;
	private BigDecimal	r36_total_rsl;
	private BigDecimal	r36_total;
	private String	r37_product;
	private BigDecimal	r37_day1_28;
	private BigDecimal	r37_day29_3m;
	private BigDecimal	r37_over3m_to_6m;
	private BigDecimal	r37_over6m_to_1y;
	private BigDecimal	r37_over1y_to_3y;
	private BigDecimal	r37_over3y_to_5y;
	private BigDecimal	r37_over5y_to_7y;
	private BigDecimal	r37_over7y_to_10y;
	private BigDecimal	r37_over10y_to_15y;
	private BigDecimal	r37_over15y;
	private BigDecimal	r37_non_sensitive;
	private BigDecimal	r37_total_rsl;
	private BigDecimal	r37_total;
	private String	r38_product;
	private BigDecimal	r38_day1_28;
	private BigDecimal	r38_day29_3m;
	private BigDecimal	r38_over3m_to_6m;
	private BigDecimal	r38_over6m_to_1y;
	private BigDecimal	r38_over1y_to_3y;
	private BigDecimal	r38_over3y_to_5y;
	private BigDecimal	r38_over5y_to_7y;
	private BigDecimal	r38_over7y_to_10y;
	private BigDecimal	r38_over10y_to_15y;
	private BigDecimal	r38_over15y;
	private BigDecimal	r38_non_sensitive;
	private BigDecimal	r38_total_rsl;
	private BigDecimal	r38_total;
	private String	r39_product;
	private BigDecimal	r39_day1_28;
	private BigDecimal	r39_day29_3m;
	private BigDecimal	r39_over3m_to_6m;
	private BigDecimal	r39_over6m_to_1y;
	private BigDecimal	r39_over1y_to_3y;
	private BigDecimal	r39_over3y_to_5y;
	private BigDecimal	r39_over5y_to_7y;
	private BigDecimal	r39_over7y_to_10y;
	private BigDecimal	r39_over10y_to_15y;
	private BigDecimal	r39_over15y;
	private BigDecimal	r39_non_sensitive;
	private BigDecimal	r39_total_rsl;
	private BigDecimal	r39_total;
	private String	r40_product;
	private BigDecimal	r40_day1_28;
	private BigDecimal	r40_day29_3m;
	private BigDecimal	r40_over3m_to_6m;
	private BigDecimal	r40_over6m_to_1y;
	private BigDecimal	r40_over1y_to_3y;
	private BigDecimal	r40_over3y_to_5y;
	private BigDecimal	r40_over5y_to_7y;
	private BigDecimal	r40_over7y_to_10y;
	private BigDecimal	r40_over10y_to_15y;
	private BigDecimal	r40_over15y;
	private BigDecimal	r40_non_sensitive;
	private BigDecimal	r40_total_rsl;
	private BigDecimal	r40_total;
	private String	r41_product;
	private BigDecimal	r41_day1_28;
	private BigDecimal	r41_day29_3m;
	private BigDecimal	r41_over3m_to_6m;
	private BigDecimal	r41_over6m_to_1y;
	private BigDecimal	r41_over1y_to_3y;
	private BigDecimal	r41_over3y_to_5y;
	private BigDecimal	r41_over5y_to_7y;
	private BigDecimal	r41_over7y_to_10y;
	private BigDecimal	r41_over10y_to_15y;
	private BigDecimal	r41_over15y;
	private BigDecimal	r41_non_sensitive;
	private BigDecimal	r41_total_rsl;
	private BigDecimal	r41_total;
	private String	r42_product;
	private BigDecimal	r42_day1_28;
	private BigDecimal	r42_day29_3m;
	private BigDecimal	r42_over3m_to_6m;
	private BigDecimal	r42_over6m_to_1y;
	private BigDecimal	r42_over1y_to_3y;
	private BigDecimal	r42_over3y_to_5y;
	private BigDecimal	r42_over5y_to_7y;
	private BigDecimal	r42_over7y_to_10y;
	private BigDecimal	r42_over10y_to_15y;
	private BigDecimal	r42_over15y;
	private BigDecimal	r42_non_sensitive;
	private BigDecimal	r42_total_rsl;
	private BigDecimal	r42_total;
	private String	r43_product;
	private BigDecimal	r43_day1_28;
	private BigDecimal	r43_day29_3m;
	private BigDecimal	r43_over3m_to_6m;
	private BigDecimal	r43_over6m_to_1y;
	private BigDecimal	r43_over1y_to_3y;
	private BigDecimal	r43_over3y_to_5y;
	private BigDecimal	r43_over5y_to_7y;
	private BigDecimal	r43_over7y_to_10y;
	private BigDecimal	r43_over10y_to_15y;
	private BigDecimal	r43_over15y;
	private BigDecimal	r43_non_sensitive;
	private BigDecimal	r43_total_rsl;
	private BigDecimal	r43_total;
	private String	r44_product;
	private BigDecimal	r44_day1_28;
	private BigDecimal	r44_day29_3m;
	private BigDecimal	r44_over3m_to_6m;
	private BigDecimal	r44_over6m_to_1y;
	private BigDecimal	r44_over1y_to_3y;
	private BigDecimal	r44_over3y_to_5y;
	private BigDecimal	r44_over5y_to_7y;
	private BigDecimal	r44_over7y_to_10y;
	private BigDecimal	r44_over10y_to_15y;
	private BigDecimal	r44_over15y;
	private BigDecimal	r44_non_sensitive;
	private BigDecimal	r44_total_rsl;
	private BigDecimal	r44_total;
	private String	r45_product;
	private BigDecimal	r45_day1_28;
	private BigDecimal	r45_day29_3m;
	private BigDecimal	r45_over3m_to_6m;
	private BigDecimal	r45_over6m_to_1y;
	private BigDecimal	r45_over1y_to_3y;
	private BigDecimal	r45_over3y_to_5y;
	private BigDecimal	r45_over5y_to_7y;
	private BigDecimal	r45_over7y_to_10y;
	private BigDecimal	r45_over10y_to_15y;
	private BigDecimal	r45_over15y;
	private BigDecimal	r45_non_sensitive;
	private BigDecimal	r45_total_rsl;
	private BigDecimal	r45_total;
	private String	r46_product;
	private BigDecimal	r46_day1_28;
	private BigDecimal	r46_day29_3m;
	private BigDecimal	r46_over3m_to_6m;
	private BigDecimal	r46_over6m_to_1y;
	private BigDecimal	r46_over1y_to_3y;
	private BigDecimal	r46_over3y_to_5y;
	private BigDecimal	r46_over5y_to_7y;
	private BigDecimal	r46_over7y_to_10y;
	private BigDecimal	r46_over10y_to_15y;
	private BigDecimal	r46_over15y;
	private BigDecimal	r46_non_sensitive;
	private BigDecimal	r46_total_rsl;
	private BigDecimal	r46_total;
	private String	r47_product;
	private BigDecimal	r47_day1_28;
	private BigDecimal	r47_day29_3m;
	private BigDecimal	r47_over3m_to_6m;
	private BigDecimal	r47_over6m_to_1y;
	private BigDecimal	r47_over1y_to_3y;
	private BigDecimal	r47_over3y_to_5y;
	private BigDecimal	r47_over5y_to_7y;
	private BigDecimal	r47_over7y_to_10y;
	private BigDecimal	r47_over10y_to_15y;
	private BigDecimal	r47_over15y;
	private BigDecimal	r47_non_sensitive;
	private BigDecimal	r47_total_rsl;
	private BigDecimal	r47_total;
	private String	r48_product;
	private BigDecimal	r48_day1_28;
	private BigDecimal	r48_day29_3m;
	private BigDecimal	r48_over3m_to_6m;
	private BigDecimal	r48_over6m_to_1y;
	private BigDecimal	r48_over1y_to_3y;
	private BigDecimal	r48_over3y_to_5y;
	private BigDecimal	r48_over5y_to_7y;
	private BigDecimal	r48_over7y_to_10y;
	private BigDecimal	r48_over10y_to_15y;
	private BigDecimal	r48_over15y;
	private BigDecimal	r48_non_sensitive;
	private BigDecimal	r48_total_rsl;
	private BigDecimal	r48_total;
	private String	r49_product;
	private BigDecimal	r49_day1_28;
	private BigDecimal	r49_day29_3m;
	private BigDecimal	r49_over3m_to_6m;
	private BigDecimal	r49_over6m_to_1y;
	private BigDecimal	r49_over1y_to_3y;
	private BigDecimal	r49_over3y_to_5y;
	private BigDecimal	r49_over5y_to_7y;
	private BigDecimal	r49_over7y_to_10y;
	private BigDecimal	r49_over10y_to_15y;
	private BigDecimal	r49_over15y;
	private BigDecimal	r49_non_sensitive;
	private BigDecimal	r49_total_rsl;
	private BigDecimal	r49_total;
	private String	r50_product;
	private BigDecimal	r50_day1_28;
	private BigDecimal	r50_day29_3m;
	private BigDecimal	r50_over3m_to_6m;
	private BigDecimal	r50_over6m_to_1y;
	private BigDecimal	r50_over1y_to_3y;
	private BigDecimal	r50_over3y_to_5y;
	private BigDecimal	r50_over5y_to_7y;
	private BigDecimal	r50_over7y_to_10y;
	private BigDecimal	r50_over10y_to_15y;
	private BigDecimal	r50_over15y;
	private BigDecimal	r50_non_sensitive;
	private BigDecimal	r50_total_rsl;
	private BigDecimal	r50_total;
	private String	r51_product;
	private BigDecimal	r51_day1_28;
	private BigDecimal	r51_day29_3m;
	private BigDecimal	r51_over3m_to_6m;
	private BigDecimal	r51_over6m_to_1y;
	private BigDecimal	r51_over1y_to_3y;
	private BigDecimal	r51_over3y_to_5y;
	private BigDecimal	r51_over5y_to_7y;
	private BigDecimal	r51_over7y_to_10y;
	private BigDecimal	r51_over10y_to_15y;
	private BigDecimal	r51_over15y;
	private BigDecimal	r51_non_sensitive;
	private BigDecimal	r51_total_rsl;
	private BigDecimal	r51_total;
	private String	r52_product;
	private BigDecimal	r52_day1_28;
	private BigDecimal	r52_day29_3m;
	private BigDecimal	r52_over3m_to_6m;
	private BigDecimal	r52_over6m_to_1y;
	private BigDecimal	r52_over1y_to_3y;
	private BigDecimal	r52_over3y_to_5y;
	private BigDecimal	r52_over5y_to_7y;
	private BigDecimal	r52_over7y_to_10y;
	private BigDecimal	r52_over10y_to_15y;
	private BigDecimal	r52_over15y;
	private BigDecimal	r52_non_sensitive;
	private BigDecimal	r52_total_rsl;
	private BigDecimal	r52_total;
	private String	r53_product;
	private BigDecimal	r53_day1_28;
	private BigDecimal	r53_day29_3m;
	private BigDecimal	r53_over3m_to_6m;
	private BigDecimal	r53_over6m_to_1y;
	private BigDecimal	r53_over1y_to_3y;
	private BigDecimal	r53_over3y_to_5y;
	private BigDecimal	r53_over5y_to_7y;
	private BigDecimal	r53_over7y_to_10y;
	private BigDecimal	r53_over10y_to_15y;
	private BigDecimal	r53_over15y;
	private BigDecimal	r53_non_sensitive;
	private BigDecimal	r53_total_rsl;
	private BigDecimal	r53_total;
	private String	r54_product;
	private BigDecimal	r54_day1_28;
	private BigDecimal	r54_day29_3m;
	private BigDecimal	r54_over3m_to_6m;
	private BigDecimal	r54_over6m_to_1y;
	private BigDecimal	r54_over1y_to_3y;
	private BigDecimal	r54_over3y_to_5y;
	private BigDecimal	r54_over5y_to_7y;
	private BigDecimal	r54_over7y_to_10y;
	private BigDecimal	r54_over10y_to_15y;
	private BigDecimal	r54_over15y;
	private BigDecimal	r54_non_sensitive;
	private BigDecimal	r54_total_rsl;
	private BigDecimal	r54_total;
	private String	r55_product;
	private BigDecimal	r55_day1_28;
	private BigDecimal	r55_day29_3m;
	private BigDecimal	r55_over3m_to_6m;
	private BigDecimal	r55_over6m_to_1y;
	private BigDecimal	r55_over1y_to_3y;
	private BigDecimal	r55_over3y_to_5y;
	private BigDecimal	r55_over5y_to_7y;
	private BigDecimal	r55_over7y_to_10y;
	private BigDecimal	r55_over10y_to_15y;
	private BigDecimal	r55_over15y;
	private BigDecimal	r55_non_sensitive;
	private BigDecimal	r55_total_rsl;
	private BigDecimal	r55_total;
	private String	r56_product;
	private BigDecimal	r56_day1_28;
	private BigDecimal	r56_day29_3m;
	private BigDecimal	r56_over3m_to_6m;
	private BigDecimal	r56_over6m_to_1y;
	private BigDecimal	r56_over1y_to_3y;
	private BigDecimal	r56_over3y_to_5y;
	private BigDecimal	r56_over5y_to_7y;
	private BigDecimal	r56_over7y_to_10y;
	private BigDecimal	r56_over10y_to_15y;
	private BigDecimal	r56_over15y;
	private BigDecimal	r56_non_sensitive;
	private BigDecimal	r56_total_rsl;
	private BigDecimal	r56_total;
	private String	r57_product;
	private BigDecimal	r57_day1_28;
	private BigDecimal	r57_day29_3m;
	private BigDecimal	r57_over3m_to_6m;
	private BigDecimal	r57_over6m_to_1y;
	private BigDecimal	r57_over1y_to_3y;
	private BigDecimal	r57_over3y_to_5y;
	private BigDecimal	r57_over5y_to_7y;
	private BigDecimal	r57_over7y_to_10y;
	private BigDecimal	r57_over10y_to_15y;
	private BigDecimal	r57_over15y;
	private BigDecimal	r57_non_sensitive;
	private BigDecimal	r57_total_rsl;
	private BigDecimal	r57_total;
	private String	r58_product;
	private BigDecimal	r58_day1_28;
	private BigDecimal	r58_day29_3m;
	private BigDecimal	r58_over3m_to_6m;
	private BigDecimal	r58_over6m_to_1y;
	private BigDecimal	r58_over1y_to_3y;
	private BigDecimal	r58_over3y_to_5y;
	private BigDecimal	r58_over5y_to_7y;
	private BigDecimal	r58_over7y_to_10y;
	private BigDecimal	r58_over10y_to_15y;
	private BigDecimal	r58_over15y;
	private BigDecimal	r58_non_sensitive;
	private BigDecimal	r58_total_rsl;
	private BigDecimal	r58_total;
	private String	r59_product;
	private BigDecimal	r59_day1_28;
	private BigDecimal	r59_day29_3m;
	private BigDecimal	r59_over3m_to_6m;
	private BigDecimal	r59_over6m_to_1y;
	private BigDecimal	r59_over1y_to_3y;
	private BigDecimal	r59_over3y_to_5y;
	private BigDecimal	r59_over5y_to_7y;
	private BigDecimal	r59_over7y_to_10y;
	private BigDecimal	r59_over10y_to_15y;
	private BigDecimal	r59_over15y;
	private BigDecimal	r59_non_sensitive;
	private BigDecimal	r59_total_rsl;
	private BigDecimal	r59_total;
	private String	r60_product;
	private BigDecimal	r60_day1_28;
	private BigDecimal	r60_day29_3m;
	private BigDecimal	r60_over3m_to_6m;
	private BigDecimal	r60_over6m_to_1y;
	private BigDecimal	r60_over1y_to_3y;
	private BigDecimal	r60_over3y_to_5y;
	private BigDecimal	r60_over5y_to_7y;
	private BigDecimal	r60_over7y_to_10y;
	private BigDecimal	r60_over10y_to_15y;
	private BigDecimal	r60_over15y;
	private BigDecimal	r60_non_sensitive;
	private BigDecimal	r60_total_rsl;
	private BigDecimal	r60_total;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	report_date;
	private String	report_version;
	private String	report_currency;
	private String	report_code;
	private String	report_desc;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	public String getSrl_no() {
		return srl_no;
	}
	public void setSrl_no(String srl_no) {
		this.srl_no = srl_no;
	}
	public String getR7_product() {
		return r7_product;
	}
	public void setR7_product(String r7_product) {
		this.r7_product = r7_product;
	}
	public BigDecimal getR7_day1_28() {
		return r7_day1_28;
	}
	public void setR7_day1_28(BigDecimal r7_day1_28) {
		this.r7_day1_28 = r7_day1_28;
	}
	public BigDecimal getR7_day29_3m() {
		return r7_day29_3m;
	}
	public void setR7_day29_3m(BigDecimal r7_day29_3m) {
		this.r7_day29_3m = r7_day29_3m;
	}
	public BigDecimal getR7_over3m_to_6m() {
		return r7_over3m_to_6m;
	}
	public void setR7_over3m_to_6m(BigDecimal r7_over3m_to_6m) {
		this.r7_over3m_to_6m = r7_over3m_to_6m;
	}
	public BigDecimal getR7_over6m_to_1y() {
		return r7_over6m_to_1y;
	}
	public void setR7_over6m_to_1y(BigDecimal r7_over6m_to_1y) {
		this.r7_over6m_to_1y = r7_over6m_to_1y;
	}
	public BigDecimal getR7_over1y_to_3y() {
		return r7_over1y_to_3y;
	}
	public void setR7_over1y_to_3y(BigDecimal r7_over1y_to_3y) {
		this.r7_over1y_to_3y = r7_over1y_to_3y;
	}
	public BigDecimal getR7_over3y_to_5y() {
		return r7_over3y_to_5y;
	}
	public void setR7_over3y_to_5y(BigDecimal r7_over3y_to_5y) {
		this.r7_over3y_to_5y = r7_over3y_to_5y;
	}
	public BigDecimal getR7_over5y_to_7y() {
		return r7_over5y_to_7y;
	}
	public void setR7_over5y_to_7y(BigDecimal r7_over5y_to_7y) {
		this.r7_over5y_to_7y = r7_over5y_to_7y;
	}
	public BigDecimal getR7_over7y_to_10y() {
		return r7_over7y_to_10y;
	}
	public void setR7_over7y_to_10y(BigDecimal r7_over7y_to_10y) {
		this.r7_over7y_to_10y = r7_over7y_to_10y;
	}
	public BigDecimal getR7_over10y_to_15y() {
		return r7_over10y_to_15y;
	}
	public void setR7_over10y_to_15y(BigDecimal r7_over10y_to_15y) {
		this.r7_over10y_to_15y = r7_over10y_to_15y;
	}
	public BigDecimal getR7_over15y() {
		return r7_over15y;
	}
	public void setR7_over15y(BigDecimal r7_over15y) {
		this.r7_over15y = r7_over15y;
	}
	public BigDecimal getR7_non_sensitive() {
		return r7_non_sensitive;
	}
	public void setR7_non_sensitive(BigDecimal r7_non_sensitive) {
		this.r7_non_sensitive = r7_non_sensitive;
	}
	public BigDecimal getR7_total_rsl() {
		return r7_total_rsl;
	}
	public void setR7_total_rsl(BigDecimal r7_total_rsl) {
		this.r7_total_rsl = r7_total_rsl;
	}
	public BigDecimal getR7_total() {
		return r7_total;
	}
	public void setR7_total(BigDecimal r7_total) {
		this.r7_total = r7_total;
	}
	public String getR8_product() {
		return r8_product;
	}
	public void setR8_product(String r8_product) {
		this.r8_product = r8_product;
	}
	public BigDecimal getR8_day1_28() {
		return r8_day1_28;
	}
	public void setR8_day1_28(BigDecimal r8_day1_28) {
		this.r8_day1_28 = r8_day1_28;
	}
	public BigDecimal getR8_day29_3m() {
		return r8_day29_3m;
	}
	public void setR8_day29_3m(BigDecimal r8_day29_3m) {
		this.r8_day29_3m = r8_day29_3m;
	}
	public BigDecimal getR8_over3m_to_6m() {
		return r8_over3m_to_6m;
	}
	public void setR8_over3m_to_6m(BigDecimal r8_over3m_to_6m) {
		this.r8_over3m_to_6m = r8_over3m_to_6m;
	}
	public BigDecimal getR8_over6m_to_1y() {
		return r8_over6m_to_1y;
	}
	public void setR8_over6m_to_1y(BigDecimal r8_over6m_to_1y) {
		this.r8_over6m_to_1y = r8_over6m_to_1y;
	}
	public BigDecimal getR8_over1y_to_3y() {
		return r8_over1y_to_3y;
	}
	public void setR8_over1y_to_3y(BigDecimal r8_over1y_to_3y) {
		this.r8_over1y_to_3y = r8_over1y_to_3y;
	}
	public BigDecimal getR8_over3y_to_5y() {
		return r8_over3y_to_5y;
	}
	public void setR8_over3y_to_5y(BigDecimal r8_over3y_to_5y) {
		this.r8_over3y_to_5y = r8_over3y_to_5y;
	}
	public BigDecimal getR8_over5y_to_7y() {
		return r8_over5y_to_7y;
	}
	public void setR8_over5y_to_7y(BigDecimal r8_over5y_to_7y) {
		this.r8_over5y_to_7y = r8_over5y_to_7y;
	}
	public BigDecimal getR8_over7y_to_10y() {
		return r8_over7y_to_10y;
	}
	public void setR8_over7y_to_10y(BigDecimal r8_over7y_to_10y) {
		this.r8_over7y_to_10y = r8_over7y_to_10y;
	}
	public BigDecimal getR8_over10y_to_15y() {
		return r8_over10y_to_15y;
	}
	public void setR8_over10y_to_15y(BigDecimal r8_over10y_to_15y) {
		this.r8_over10y_to_15y = r8_over10y_to_15y;
	}
	public BigDecimal getR8_over15y() {
		return r8_over15y;
	}
	public void setR8_over15y(BigDecimal r8_over15y) {
		this.r8_over15y = r8_over15y;
	}
	public BigDecimal getR8_non_sensitive() {
		return r8_non_sensitive;
	}
	public void setR8_non_sensitive(BigDecimal r8_non_sensitive) {
		this.r8_non_sensitive = r8_non_sensitive;
	}
	public BigDecimal getR8_total_rsl() {
		return r8_total_rsl;
	}
	public void setR8_total_rsl(BigDecimal r8_total_rsl) {
		this.r8_total_rsl = r8_total_rsl;
	}
	public BigDecimal getR8_total() {
		return r8_total;
	}
	public void setR8_total(BigDecimal r8_total) {
		this.r8_total = r8_total;
	}
	public String getR9_product() {
		return r9_product;
	}
	public void setR9_product(String r9_product) {
		this.r9_product = r9_product;
	}
	public BigDecimal getR9_day1_28() {
		return r9_day1_28;
	}
	public void setR9_day1_28(BigDecimal r9_day1_28) {
		this.r9_day1_28 = r9_day1_28;
	}
	public BigDecimal getR9_day29_3m() {
		return r9_day29_3m;
	}
	public void setR9_day29_3m(BigDecimal r9_day29_3m) {
		this.r9_day29_3m = r9_day29_3m;
	}
	public BigDecimal getR9_over3m_to_6m() {
		return r9_over3m_to_6m;
	}
	public void setR9_over3m_to_6m(BigDecimal r9_over3m_to_6m) {
		this.r9_over3m_to_6m = r9_over3m_to_6m;
	}
	public BigDecimal getR9_over6m_to_1y() {
		return r9_over6m_to_1y;
	}
	public void setR9_over6m_to_1y(BigDecimal r9_over6m_to_1y) {
		this.r9_over6m_to_1y = r9_over6m_to_1y;
	}
	public BigDecimal getR9_over1y_to_3y() {
		return r9_over1y_to_3y;
	}
	public void setR9_over1y_to_3y(BigDecimal r9_over1y_to_3y) {
		this.r9_over1y_to_3y = r9_over1y_to_3y;
	}
	public BigDecimal getR9_over3y_to_5y() {
		return r9_over3y_to_5y;
	}
	public void setR9_over3y_to_5y(BigDecimal r9_over3y_to_5y) {
		this.r9_over3y_to_5y = r9_over3y_to_5y;
	}
	public BigDecimal getR9_over5y_to_7y() {
		return r9_over5y_to_7y;
	}
	public void setR9_over5y_to_7y(BigDecimal r9_over5y_to_7y) {
		this.r9_over5y_to_7y = r9_over5y_to_7y;
	}
	public BigDecimal getR9_over7y_to_10y() {
		return r9_over7y_to_10y;
	}
	public void setR9_over7y_to_10y(BigDecimal r9_over7y_to_10y) {
		this.r9_over7y_to_10y = r9_over7y_to_10y;
	}
	public BigDecimal getR9_over10y_to_15y() {
		return r9_over10y_to_15y;
	}
	public void setR9_over10y_to_15y(BigDecimal r9_over10y_to_15y) {
		this.r9_over10y_to_15y = r9_over10y_to_15y;
	}
	public BigDecimal getR9_over15y() {
		return r9_over15y;
	}
	public void setR9_over15y(BigDecimal r9_over15y) {
		this.r9_over15y = r9_over15y;
	}
	public BigDecimal getR9_non_sensitive() {
		return r9_non_sensitive;
	}
	public void setR9_non_sensitive(BigDecimal r9_non_sensitive) {
		this.r9_non_sensitive = r9_non_sensitive;
	}
	public BigDecimal getR9_total_rsl() {
		return r9_total_rsl;
	}
	public void setR9_total_rsl(BigDecimal r9_total_rsl) {
		this.r9_total_rsl = r9_total_rsl;
	}
	public BigDecimal getR9_total() {
		return r9_total;
	}
	public void setR9_total(BigDecimal r9_total) {
		this.r9_total = r9_total;
	}
	public String getR10_product() {
		return r10_product;
	}
	public void setR10_product(String r10_product) {
		this.r10_product = r10_product;
	}
	public BigDecimal getR10_day1_28() {
		return r10_day1_28;
	}
	public void setR10_day1_28(BigDecimal r10_day1_28) {
		this.r10_day1_28 = r10_day1_28;
	}
	public BigDecimal getR10_day29_3m() {
		return r10_day29_3m;
	}
	public void setR10_day29_3m(BigDecimal r10_day29_3m) {
		this.r10_day29_3m = r10_day29_3m;
	}
	public BigDecimal getR10_over3m_to_6m() {
		return r10_over3m_to_6m;
	}
	public void setR10_over3m_to_6m(BigDecimal r10_over3m_to_6m) {
		this.r10_over3m_to_6m = r10_over3m_to_6m;
	}
	public BigDecimal getR10_over6m_to_1y() {
		return r10_over6m_to_1y;
	}
	public void setR10_over6m_to_1y(BigDecimal r10_over6m_to_1y) {
		this.r10_over6m_to_1y = r10_over6m_to_1y;
	}
	public BigDecimal getR10_over1y_to_3y() {
		return r10_over1y_to_3y;
	}
	public void setR10_over1y_to_3y(BigDecimal r10_over1y_to_3y) {
		this.r10_over1y_to_3y = r10_over1y_to_3y;
	}
	public BigDecimal getR10_over3y_to_5y() {
		return r10_over3y_to_5y;
	}
	public void setR10_over3y_to_5y(BigDecimal r10_over3y_to_5y) {
		this.r10_over3y_to_5y = r10_over3y_to_5y;
	}
	public BigDecimal getR10_over5y_to_7y() {
		return r10_over5y_to_7y;
	}
	public void setR10_over5y_to_7y(BigDecimal r10_over5y_to_7y) {
		this.r10_over5y_to_7y = r10_over5y_to_7y;
	}
	public BigDecimal getR10_over7y_to_10y() {
		return r10_over7y_to_10y;
	}
	public void setR10_over7y_to_10y(BigDecimal r10_over7y_to_10y) {
		this.r10_over7y_to_10y = r10_over7y_to_10y;
	}
	public BigDecimal getR10_over10y_to_15y() {
		return r10_over10y_to_15y;
	}
	public void setR10_over10y_to_15y(BigDecimal r10_over10y_to_15y) {
		this.r10_over10y_to_15y = r10_over10y_to_15y;
	}
	public BigDecimal getR10_over15y() {
		return r10_over15y;
	}
	public void setR10_over15y(BigDecimal r10_over15y) {
		this.r10_over15y = r10_over15y;
	}
	public BigDecimal getR10_non_sensitive() {
		return r10_non_sensitive;
	}
	public void setR10_non_sensitive(BigDecimal r10_non_sensitive) {
		this.r10_non_sensitive = r10_non_sensitive;
	}
	public BigDecimal getR10_total_rsl() {
		return r10_total_rsl;
	}
	public void setR10_total_rsl(BigDecimal r10_total_rsl) {
		this.r10_total_rsl = r10_total_rsl;
	}
	public BigDecimal getR10_total() {
		return r10_total;
	}
	public void setR10_total(BigDecimal r10_total) {
		this.r10_total = r10_total;
	}
	public String getR11_product() {
		return r11_product;
	}
	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}
	public BigDecimal getR11_day1_28() {
		return r11_day1_28;
	}
	public void setR11_day1_28(BigDecimal r11_day1_28) {
		this.r11_day1_28 = r11_day1_28;
	}
	public BigDecimal getR11_day29_3m() {
		return r11_day29_3m;
	}
	public void setR11_day29_3m(BigDecimal r11_day29_3m) {
		this.r11_day29_3m = r11_day29_3m;
	}
	public BigDecimal getR11_over3m_to_6m() {
		return r11_over3m_to_6m;
	}
	public void setR11_over3m_to_6m(BigDecimal r11_over3m_to_6m) {
		this.r11_over3m_to_6m = r11_over3m_to_6m;
	}
	public BigDecimal getR11_over6m_to_1y() {
		return r11_over6m_to_1y;
	}
	public void setR11_over6m_to_1y(BigDecimal r11_over6m_to_1y) {
		this.r11_over6m_to_1y = r11_over6m_to_1y;
	}
	public BigDecimal getR11_over1y_to_3y() {
		return r11_over1y_to_3y;
	}
	public void setR11_over1y_to_3y(BigDecimal r11_over1y_to_3y) {
		this.r11_over1y_to_3y = r11_over1y_to_3y;
	}
	public BigDecimal getR11_over3y_to_5y() {
		return r11_over3y_to_5y;
	}
	public void setR11_over3y_to_5y(BigDecimal r11_over3y_to_5y) {
		this.r11_over3y_to_5y = r11_over3y_to_5y;
	}
	public BigDecimal getR11_over5y_to_7y() {
		return r11_over5y_to_7y;
	}
	public void setR11_over5y_to_7y(BigDecimal r11_over5y_to_7y) {
		this.r11_over5y_to_7y = r11_over5y_to_7y;
	}
	public BigDecimal getR11_over7y_to_10y() {
		return r11_over7y_to_10y;
	}
	public void setR11_over7y_to_10y(BigDecimal r11_over7y_to_10y) {
		this.r11_over7y_to_10y = r11_over7y_to_10y;
	}
	public BigDecimal getR11_over10y_to_15y() {
		return r11_over10y_to_15y;
	}
	public void setR11_over10y_to_15y(BigDecimal r11_over10y_to_15y) {
		this.r11_over10y_to_15y = r11_over10y_to_15y;
	}
	public BigDecimal getR11_over15y() {
		return r11_over15y;
	}
	public void setR11_over15y(BigDecimal r11_over15y) {
		this.r11_over15y = r11_over15y;
	}
	public BigDecimal getR11_non_sensitive() {
		return r11_non_sensitive;
	}
	public void setR11_non_sensitive(BigDecimal r11_non_sensitive) {
		this.r11_non_sensitive = r11_non_sensitive;
	}
	public BigDecimal getR11_total_rsl() {
		return r11_total_rsl;
	}
	public void setR11_total_rsl(BigDecimal r11_total_rsl) {
		this.r11_total_rsl = r11_total_rsl;
	}
	public BigDecimal getR11_total() {
		return r11_total;
	}
	public void setR11_total(BigDecimal r11_total) {
		this.r11_total = r11_total;
	}
	public String getR12_product() {
		return r12_product;
	}
	public void setR12_product(String r12_product) {
		this.r12_product = r12_product;
	}
	public BigDecimal getR12_day1_28() {
		return r12_day1_28;
	}
	public void setR12_day1_28(BigDecimal r12_day1_28) {
		this.r12_day1_28 = r12_day1_28;
	}
	public BigDecimal getR12_day29_3m() {
		return r12_day29_3m;
	}
	public void setR12_day29_3m(BigDecimal r12_day29_3m) {
		this.r12_day29_3m = r12_day29_3m;
	}
	public BigDecimal getR12_over3m_to_6m() {
		return r12_over3m_to_6m;
	}
	public void setR12_over3m_to_6m(BigDecimal r12_over3m_to_6m) {
		this.r12_over3m_to_6m = r12_over3m_to_6m;
	}
	public BigDecimal getR12_over6m_to_1y() {
		return r12_over6m_to_1y;
	}
	public void setR12_over6m_to_1y(BigDecimal r12_over6m_to_1y) {
		this.r12_over6m_to_1y = r12_over6m_to_1y;
	}
	public BigDecimal getR12_over1y_to_3y() {
		return r12_over1y_to_3y;
	}
	public void setR12_over1y_to_3y(BigDecimal r12_over1y_to_3y) {
		this.r12_over1y_to_3y = r12_over1y_to_3y;
	}
	public BigDecimal getR12_over3y_to_5y() {
		return r12_over3y_to_5y;
	}
	public void setR12_over3y_to_5y(BigDecimal r12_over3y_to_5y) {
		this.r12_over3y_to_5y = r12_over3y_to_5y;
	}
	public BigDecimal getR12_over5y_to_7y() {
		return r12_over5y_to_7y;
	}
	public void setR12_over5y_to_7y(BigDecimal r12_over5y_to_7y) {
		this.r12_over5y_to_7y = r12_over5y_to_7y;
	}
	public BigDecimal getR12_over7y_to_10y() {
		return r12_over7y_to_10y;
	}
	public void setR12_over7y_to_10y(BigDecimal r12_over7y_to_10y) {
		this.r12_over7y_to_10y = r12_over7y_to_10y;
	}
	public BigDecimal getR12_over10y_to_15y() {
		return r12_over10y_to_15y;
	}
	public void setR12_over10y_to_15y(BigDecimal r12_over10y_to_15y) {
		this.r12_over10y_to_15y = r12_over10y_to_15y;
	}
	public BigDecimal getR12_over15y() {
		return r12_over15y;
	}
	public void setR12_over15y(BigDecimal r12_over15y) {
		this.r12_over15y = r12_over15y;
	}
	public BigDecimal getR12_non_sensitive() {
		return r12_non_sensitive;
	}
	public void setR12_non_sensitive(BigDecimal r12_non_sensitive) {
		this.r12_non_sensitive = r12_non_sensitive;
	}
	public BigDecimal getR12_total_rsl() {
		return r12_total_rsl;
	}
	public void setR12_total_rsl(BigDecimal r12_total_rsl) {
		this.r12_total_rsl = r12_total_rsl;
	}
	public BigDecimal getR12_total() {
		return r12_total;
	}
	public void setR12_total(BigDecimal r12_total) {
		this.r12_total = r12_total;
	}
	public String getR13_product() {
		return r13_product;
	}
	public void setR13_product(String r13_product) {
		this.r13_product = r13_product;
	}
	public BigDecimal getR13_day1_28() {
		return r13_day1_28;
	}
	public void setR13_day1_28(BigDecimal r13_day1_28) {
		this.r13_day1_28 = r13_day1_28;
	}
	public BigDecimal getR13_day29_3m() {
		return r13_day29_3m;
	}
	public void setR13_day29_3m(BigDecimal r13_day29_3m) {
		this.r13_day29_3m = r13_day29_3m;
	}
	public BigDecimal getR13_over3m_to_6m() {
		return r13_over3m_to_6m;
	}
	public void setR13_over3m_to_6m(BigDecimal r13_over3m_to_6m) {
		this.r13_over3m_to_6m = r13_over3m_to_6m;
	}
	public BigDecimal getR13_over6m_to_1y() {
		return r13_over6m_to_1y;
	}
	public void setR13_over6m_to_1y(BigDecimal r13_over6m_to_1y) {
		this.r13_over6m_to_1y = r13_over6m_to_1y;
	}
	public BigDecimal getR13_over1y_to_3y() {
		return r13_over1y_to_3y;
	}
	public void setR13_over1y_to_3y(BigDecimal r13_over1y_to_3y) {
		this.r13_over1y_to_3y = r13_over1y_to_3y;
	}
	public BigDecimal getR13_over3y_to_5y() {
		return r13_over3y_to_5y;
	}
	public void setR13_over3y_to_5y(BigDecimal r13_over3y_to_5y) {
		this.r13_over3y_to_5y = r13_over3y_to_5y;
	}
	public BigDecimal getR13_over5y_to_7y() {
		return r13_over5y_to_7y;
	}
	public void setR13_over5y_to_7y(BigDecimal r13_over5y_to_7y) {
		this.r13_over5y_to_7y = r13_over5y_to_7y;
	}
	public BigDecimal getR13_over7y_to_10y() {
		return r13_over7y_to_10y;
	}
	public void setR13_over7y_to_10y(BigDecimal r13_over7y_to_10y) {
		this.r13_over7y_to_10y = r13_over7y_to_10y;
	}
	public BigDecimal getR13_over10y_to_15y() {
		return r13_over10y_to_15y;
	}
	public void setR13_over10y_to_15y(BigDecimal r13_over10y_to_15y) {
		this.r13_over10y_to_15y = r13_over10y_to_15y;
	}
	public BigDecimal getR13_over15y() {
		return r13_over15y;
	}
	public void setR13_over15y(BigDecimal r13_over15y) {
		this.r13_over15y = r13_over15y;
	}
	public BigDecimal getR13_non_sensitive() {
		return r13_non_sensitive;
	}
	public void setR13_non_sensitive(BigDecimal r13_non_sensitive) {
		this.r13_non_sensitive = r13_non_sensitive;
	}
	public BigDecimal getR13_total_rsl() {
		return r13_total_rsl;
	}
	public void setR13_total_rsl(BigDecimal r13_total_rsl) {
		this.r13_total_rsl = r13_total_rsl;
	}
	public BigDecimal getR13_total() {
		return r13_total;
	}
	public void setR13_total(BigDecimal r13_total) {
		this.r13_total = r13_total;
	}
	public String getR14_product() {
		return r14_product;
	}
	public void setR14_product(String r14_product) {
		this.r14_product = r14_product;
	}
	public BigDecimal getR14_day1_28() {
		return r14_day1_28;
	}
	public void setR14_day1_28(BigDecimal r14_day1_28) {
		this.r14_day1_28 = r14_day1_28;
	}
	public BigDecimal getR14_day29_3m() {
		return r14_day29_3m;
	}
	public void setR14_day29_3m(BigDecimal r14_day29_3m) {
		this.r14_day29_3m = r14_day29_3m;
	}
	public BigDecimal getR14_over3m_to_6m() {
		return r14_over3m_to_6m;
	}
	public void setR14_over3m_to_6m(BigDecimal r14_over3m_to_6m) {
		this.r14_over3m_to_6m = r14_over3m_to_6m;
	}
	public BigDecimal getR14_over6m_to_1y() {
		return r14_over6m_to_1y;
	}
	public void setR14_over6m_to_1y(BigDecimal r14_over6m_to_1y) {
		this.r14_over6m_to_1y = r14_over6m_to_1y;
	}
	public BigDecimal getR14_over1y_to_3y() {
		return r14_over1y_to_3y;
	}
	public void setR14_over1y_to_3y(BigDecimal r14_over1y_to_3y) {
		this.r14_over1y_to_3y = r14_over1y_to_3y;
	}
	public BigDecimal getR14_over3y_to_5y() {
		return r14_over3y_to_5y;
	}
	public void setR14_over3y_to_5y(BigDecimal r14_over3y_to_5y) {
		this.r14_over3y_to_5y = r14_over3y_to_5y;
	}
	public BigDecimal getR14_over5y_to_7y() {
		return r14_over5y_to_7y;
	}
	public void setR14_over5y_to_7y(BigDecimal r14_over5y_to_7y) {
		this.r14_over5y_to_7y = r14_over5y_to_7y;
	}
	public BigDecimal getR14_over7y_to_10y() {
		return r14_over7y_to_10y;
	}
	public void setR14_over7y_to_10y(BigDecimal r14_over7y_to_10y) {
		this.r14_over7y_to_10y = r14_over7y_to_10y;
	}
	public BigDecimal getR14_over10y_to_15y() {
		return r14_over10y_to_15y;
	}
	public void setR14_over10y_to_15y(BigDecimal r14_over10y_to_15y) {
		this.r14_over10y_to_15y = r14_over10y_to_15y;
	}
	public BigDecimal getR14_over15y() {
		return r14_over15y;
	}
	public void setR14_over15y(BigDecimal r14_over15y) {
		this.r14_over15y = r14_over15y;
	}
	public BigDecimal getR14_non_sensitive() {
		return r14_non_sensitive;
	}
	public void setR14_non_sensitive(BigDecimal r14_non_sensitive) {
		this.r14_non_sensitive = r14_non_sensitive;
	}
	public BigDecimal getR14_total_rsl() {
		return r14_total_rsl;
	}
	public void setR14_total_rsl(BigDecimal r14_total_rsl) {
		this.r14_total_rsl = r14_total_rsl;
	}
	public BigDecimal getR14_total() {
		return r14_total;
	}
	public void setR14_total(BigDecimal r14_total) {
		this.r14_total = r14_total;
	}
	public String getR15_product() {
		return r15_product;
	}
	public void setR15_product(String r15_product) {
		this.r15_product = r15_product;
	}
	public BigDecimal getR15_day1_28() {
		return r15_day1_28;
	}
	public void setR15_day1_28(BigDecimal r15_day1_28) {
		this.r15_day1_28 = r15_day1_28;
	}
	public BigDecimal getR15_day29_3m() {
		return r15_day29_3m;
	}
	public void setR15_day29_3m(BigDecimal r15_day29_3m) {
		this.r15_day29_3m = r15_day29_3m;
	}
	public BigDecimal getR15_over3m_to_6m() {
		return r15_over3m_to_6m;
	}
	public void setR15_over3m_to_6m(BigDecimal r15_over3m_to_6m) {
		this.r15_over3m_to_6m = r15_over3m_to_6m;
	}
	public BigDecimal getR15_over6m_to_1y() {
		return r15_over6m_to_1y;
	}
	public void setR15_over6m_to_1y(BigDecimal r15_over6m_to_1y) {
		this.r15_over6m_to_1y = r15_over6m_to_1y;
	}
	public BigDecimal getR15_over1y_to_3y() {
		return r15_over1y_to_3y;
	}
	public void setR15_over1y_to_3y(BigDecimal r15_over1y_to_3y) {
		this.r15_over1y_to_3y = r15_over1y_to_3y;
	}
	public BigDecimal getR15_over3y_to_5y() {
		return r15_over3y_to_5y;
	}
	public void setR15_over3y_to_5y(BigDecimal r15_over3y_to_5y) {
		this.r15_over3y_to_5y = r15_over3y_to_5y;
	}
	public BigDecimal getR15_over5y_to_7y() {
		return r15_over5y_to_7y;
	}
	public void setR15_over5y_to_7y(BigDecimal r15_over5y_to_7y) {
		this.r15_over5y_to_7y = r15_over5y_to_7y;
	}
	public BigDecimal getR15_over7y_to_10y() {
		return r15_over7y_to_10y;
	}
	public void setR15_over7y_to_10y(BigDecimal r15_over7y_to_10y) {
		this.r15_over7y_to_10y = r15_over7y_to_10y;
	}
	public BigDecimal getR15_over10y_to_15y() {
		return r15_over10y_to_15y;
	}
	public void setR15_over10y_to_15y(BigDecimal r15_over10y_to_15y) {
		this.r15_over10y_to_15y = r15_over10y_to_15y;
	}
	public BigDecimal getR15_over15y() {
		return r15_over15y;
	}
	public void setR15_over15y(BigDecimal r15_over15y) {
		this.r15_over15y = r15_over15y;
	}
	public BigDecimal getR15_non_sensitive() {
		return r15_non_sensitive;
	}
	public void setR15_non_sensitive(BigDecimal r15_non_sensitive) {
		this.r15_non_sensitive = r15_non_sensitive;
	}
	public BigDecimal getR15_total_rsl() {
		return r15_total_rsl;
	}
	public void setR15_total_rsl(BigDecimal r15_total_rsl) {
		this.r15_total_rsl = r15_total_rsl;
	}
	public BigDecimal getR15_total() {
		return r15_total;
	}
	public void setR15_total(BigDecimal r15_total) {
		this.r15_total = r15_total;
	}
	public String getR16_product() {
		return r16_product;
	}
	public void setR16_product(String r16_product) {
		this.r16_product = r16_product;
	}
	public BigDecimal getR16_day1_28() {
		return r16_day1_28;
	}
	public void setR16_day1_28(BigDecimal r16_day1_28) {
		this.r16_day1_28 = r16_day1_28;
	}
	public BigDecimal getR16_day29_3m() {
		return r16_day29_3m;
	}
	public void setR16_day29_3m(BigDecimal r16_day29_3m) {
		this.r16_day29_3m = r16_day29_3m;
	}
	public BigDecimal getR16_over3m_to_6m() {
		return r16_over3m_to_6m;
	}
	public void setR16_over3m_to_6m(BigDecimal r16_over3m_to_6m) {
		this.r16_over3m_to_6m = r16_over3m_to_6m;
	}
	public BigDecimal getR16_over6m_to_1y() {
		return r16_over6m_to_1y;
	}
	public void setR16_over6m_to_1y(BigDecimal r16_over6m_to_1y) {
		this.r16_over6m_to_1y = r16_over6m_to_1y;
	}
	public BigDecimal getR16_over1y_to_3y() {
		return r16_over1y_to_3y;
	}
	public void setR16_over1y_to_3y(BigDecimal r16_over1y_to_3y) {
		this.r16_over1y_to_3y = r16_over1y_to_3y;
	}
	public BigDecimal getR16_over3y_to_5y() {
		return r16_over3y_to_5y;
	}
	public void setR16_over3y_to_5y(BigDecimal r16_over3y_to_5y) {
		this.r16_over3y_to_5y = r16_over3y_to_5y;
	}
	public BigDecimal getR16_over5y_to_7y() {
		return r16_over5y_to_7y;
	}
	public void setR16_over5y_to_7y(BigDecimal r16_over5y_to_7y) {
		this.r16_over5y_to_7y = r16_over5y_to_7y;
	}
	public BigDecimal getR16_over7y_to_10y() {
		return r16_over7y_to_10y;
	}
	public void setR16_over7y_to_10y(BigDecimal r16_over7y_to_10y) {
		this.r16_over7y_to_10y = r16_over7y_to_10y;
	}
	public BigDecimal getR16_over10y_to_15y() {
		return r16_over10y_to_15y;
	}
	public void setR16_over10y_to_15y(BigDecimal r16_over10y_to_15y) {
		this.r16_over10y_to_15y = r16_over10y_to_15y;
	}
	public BigDecimal getR16_over15y() {
		return r16_over15y;
	}
	public void setR16_over15y(BigDecimal r16_over15y) {
		this.r16_over15y = r16_over15y;
	}
	public BigDecimal getR16_non_sensitive() {
		return r16_non_sensitive;
	}
	public void setR16_non_sensitive(BigDecimal r16_non_sensitive) {
		this.r16_non_sensitive = r16_non_sensitive;
	}
	public BigDecimal getR16_total_rsl() {
		return r16_total_rsl;
	}
	public void setR16_total_rsl(BigDecimal r16_total_rsl) {
		this.r16_total_rsl = r16_total_rsl;
	}
	public BigDecimal getR16_total() {
		return r16_total;
	}
	public void setR16_total(BigDecimal r16_total) {
		this.r16_total = r16_total;
	}
	public String getR17_product() {
		return r17_product;
	}
	public void setR17_product(String r17_product) {
		this.r17_product = r17_product;
	}
	public BigDecimal getR17_day1_28() {
		return r17_day1_28;
	}
	public void setR17_day1_28(BigDecimal r17_day1_28) {
		this.r17_day1_28 = r17_day1_28;
	}
	public BigDecimal getR17_day29_3m() {
		return r17_day29_3m;
	}
	public void setR17_day29_3m(BigDecimal r17_day29_3m) {
		this.r17_day29_3m = r17_day29_3m;
	}
	public BigDecimal getR17_over3m_to_6m() {
		return r17_over3m_to_6m;
	}
	public void setR17_over3m_to_6m(BigDecimal r17_over3m_to_6m) {
		this.r17_over3m_to_6m = r17_over3m_to_6m;
	}
	public BigDecimal getR17_over6m_to_1y() {
		return r17_over6m_to_1y;
	}
	public void setR17_over6m_to_1y(BigDecimal r17_over6m_to_1y) {
		this.r17_over6m_to_1y = r17_over6m_to_1y;
	}
	public BigDecimal getR17_over1y_to_3y() {
		return r17_over1y_to_3y;
	}
	public void setR17_over1y_to_3y(BigDecimal r17_over1y_to_3y) {
		this.r17_over1y_to_3y = r17_over1y_to_3y;
	}
	public BigDecimal getR17_over3y_to_5y() {
		return r17_over3y_to_5y;
	}
	public void setR17_over3y_to_5y(BigDecimal r17_over3y_to_5y) {
		this.r17_over3y_to_5y = r17_over3y_to_5y;
	}
	public BigDecimal getR17_over5y_to_7y() {
		return r17_over5y_to_7y;
	}
	public void setR17_over5y_to_7y(BigDecimal r17_over5y_to_7y) {
		this.r17_over5y_to_7y = r17_over5y_to_7y;
	}
	public BigDecimal getR17_over7y_to_10y() {
		return r17_over7y_to_10y;
	}
	public void setR17_over7y_to_10y(BigDecimal r17_over7y_to_10y) {
		this.r17_over7y_to_10y = r17_over7y_to_10y;
	}
	public BigDecimal getR17_over10y_to_15y() {
		return r17_over10y_to_15y;
	}
	public void setR17_over10y_to_15y(BigDecimal r17_over10y_to_15y) {
		this.r17_over10y_to_15y = r17_over10y_to_15y;
	}
	public BigDecimal getR17_over15y() {
		return r17_over15y;
	}
	public void setR17_over15y(BigDecimal r17_over15y) {
		this.r17_over15y = r17_over15y;
	}
	public BigDecimal getR17_non_sensitive() {
		return r17_non_sensitive;
	}
	public void setR17_non_sensitive(BigDecimal r17_non_sensitive) {
		this.r17_non_sensitive = r17_non_sensitive;
	}
	public BigDecimal getR17_total_rsl() {
		return r17_total_rsl;
	}
	public void setR17_total_rsl(BigDecimal r17_total_rsl) {
		this.r17_total_rsl = r17_total_rsl;
	}
	public BigDecimal getR17_total() {
		return r17_total;
	}
	public void setR17_total(BigDecimal r17_total) {
		this.r17_total = r17_total;
	}
	public String getR18_product() {
		return r18_product;
	}
	public void setR18_product(String r18_product) {
		this.r18_product = r18_product;
	}
	public BigDecimal getR18_day1_28() {
		return r18_day1_28;
	}
	public void setR18_day1_28(BigDecimal r18_day1_28) {
		this.r18_day1_28 = r18_day1_28;
	}
	public BigDecimal getR18_day29_3m() {
		return r18_day29_3m;
	}
	public void setR18_day29_3m(BigDecimal r18_day29_3m) {
		this.r18_day29_3m = r18_day29_3m;
	}
	public BigDecimal getR18_over3m_to_6m() {
		return r18_over3m_to_6m;
	}
	public void setR18_over3m_to_6m(BigDecimal r18_over3m_to_6m) {
		this.r18_over3m_to_6m = r18_over3m_to_6m;
	}
	public BigDecimal getR18_over6m_to_1y() {
		return r18_over6m_to_1y;
	}
	public void setR18_over6m_to_1y(BigDecimal r18_over6m_to_1y) {
		this.r18_over6m_to_1y = r18_over6m_to_1y;
	}
	public BigDecimal getR18_over1y_to_3y() {
		return r18_over1y_to_3y;
	}
	public void setR18_over1y_to_3y(BigDecimal r18_over1y_to_3y) {
		this.r18_over1y_to_3y = r18_over1y_to_3y;
	}
	public BigDecimal getR18_over3y_to_5y() {
		return r18_over3y_to_5y;
	}
	public void setR18_over3y_to_5y(BigDecimal r18_over3y_to_5y) {
		this.r18_over3y_to_5y = r18_over3y_to_5y;
	}
	public BigDecimal getR18_over5y_to_7y() {
		return r18_over5y_to_7y;
	}
	public void setR18_over5y_to_7y(BigDecimal r18_over5y_to_7y) {
		this.r18_over5y_to_7y = r18_over5y_to_7y;
	}
	public BigDecimal getR18_over7y_to_10y() {
		return r18_over7y_to_10y;
	}
	public void setR18_over7y_to_10y(BigDecimal r18_over7y_to_10y) {
		this.r18_over7y_to_10y = r18_over7y_to_10y;
	}
	public BigDecimal getR18_over10y_to_15y() {
		return r18_over10y_to_15y;
	}
	public void setR18_over10y_to_15y(BigDecimal r18_over10y_to_15y) {
		this.r18_over10y_to_15y = r18_over10y_to_15y;
	}
	public BigDecimal getR18_over15y() {
		return r18_over15y;
	}
	public void setR18_over15y(BigDecimal r18_over15y) {
		this.r18_over15y = r18_over15y;
	}
	public BigDecimal getR18_non_sensitive() {
		return r18_non_sensitive;
	}
	public void setR18_non_sensitive(BigDecimal r18_non_sensitive) {
		this.r18_non_sensitive = r18_non_sensitive;
	}
	public BigDecimal getR18_total_rsl() {
		return r18_total_rsl;
	}
	public void setR18_total_rsl(BigDecimal r18_total_rsl) {
		this.r18_total_rsl = r18_total_rsl;
	}
	public BigDecimal getR18_total() {
		return r18_total;
	}
	public void setR18_total(BigDecimal r18_total) {
		this.r18_total = r18_total;
	}
	public String getR19_product() {
		return r19_product;
	}
	public void setR19_product(String r19_product) {
		this.r19_product = r19_product;
	}
	public BigDecimal getR19_day1_28() {
		return r19_day1_28;
	}
	public void setR19_day1_28(BigDecimal r19_day1_28) {
		this.r19_day1_28 = r19_day1_28;
	}
	public BigDecimal getR19_day29_3m() {
		return r19_day29_3m;
	}
	public void setR19_day29_3m(BigDecimal r19_day29_3m) {
		this.r19_day29_3m = r19_day29_3m;
	}
	public BigDecimal getR19_over3m_to_6m() {
		return r19_over3m_to_6m;
	}
	public void setR19_over3m_to_6m(BigDecimal r19_over3m_to_6m) {
		this.r19_over3m_to_6m = r19_over3m_to_6m;
	}
	public BigDecimal getR19_over6m_to_1y() {
		return r19_over6m_to_1y;
	}
	public void setR19_over6m_to_1y(BigDecimal r19_over6m_to_1y) {
		this.r19_over6m_to_1y = r19_over6m_to_1y;
	}
	public BigDecimal getR19_over1y_to_3y() {
		return r19_over1y_to_3y;
	}
	public void setR19_over1y_to_3y(BigDecimal r19_over1y_to_3y) {
		this.r19_over1y_to_3y = r19_over1y_to_3y;
	}
	public BigDecimal getR19_over3y_to_5y() {
		return r19_over3y_to_5y;
	}
	public void setR19_over3y_to_5y(BigDecimal r19_over3y_to_5y) {
		this.r19_over3y_to_5y = r19_over3y_to_5y;
	}
	public BigDecimal getR19_over5y_to_7y() {
		return r19_over5y_to_7y;
	}
	public void setR19_over5y_to_7y(BigDecimal r19_over5y_to_7y) {
		this.r19_over5y_to_7y = r19_over5y_to_7y;
	}
	public BigDecimal getR19_over7y_to_10y() {
		return r19_over7y_to_10y;
	}
	public void setR19_over7y_to_10y(BigDecimal r19_over7y_to_10y) {
		this.r19_over7y_to_10y = r19_over7y_to_10y;
	}
	public BigDecimal getR19_over10y_to_15y() {
		return r19_over10y_to_15y;
	}
	public void setR19_over10y_to_15y(BigDecimal r19_over10y_to_15y) {
		this.r19_over10y_to_15y = r19_over10y_to_15y;
	}
	public BigDecimal getR19_over15y() {
		return r19_over15y;
	}
	public void setR19_over15y(BigDecimal r19_over15y) {
		this.r19_over15y = r19_over15y;
	}
	public BigDecimal getR19_non_sensitive() {
		return r19_non_sensitive;
	}
	public void setR19_non_sensitive(BigDecimal r19_non_sensitive) {
		this.r19_non_sensitive = r19_non_sensitive;
	}
	public BigDecimal getR19_total_rsl() {
		return r19_total_rsl;
	}
	public void setR19_total_rsl(BigDecimal r19_total_rsl) {
		this.r19_total_rsl = r19_total_rsl;
	}
	public BigDecimal getR19_total() {
		return r19_total;
	}
	public void setR19_total(BigDecimal r19_total) {
		this.r19_total = r19_total;
	}
	public String getR20_product() {
		return r20_product;
	}
	public void setR20_product(String r20_product) {
		this.r20_product = r20_product;
	}
	public BigDecimal getR20_day1_28() {
		return r20_day1_28;
	}
	public void setR20_day1_28(BigDecimal r20_day1_28) {
		this.r20_day1_28 = r20_day1_28;
	}
	public BigDecimal getR20_day29_3m() {
		return r20_day29_3m;
	}
	public void setR20_day29_3m(BigDecimal r20_day29_3m) {
		this.r20_day29_3m = r20_day29_3m;
	}
	public BigDecimal getR20_over3m_to_6m() {
		return r20_over3m_to_6m;
	}
	public void setR20_over3m_to_6m(BigDecimal r20_over3m_to_6m) {
		this.r20_over3m_to_6m = r20_over3m_to_6m;
	}
	public BigDecimal getR20_over6m_to_1y() {
		return r20_over6m_to_1y;
	}
	public void setR20_over6m_to_1y(BigDecimal r20_over6m_to_1y) {
		this.r20_over6m_to_1y = r20_over6m_to_1y;
	}
	public BigDecimal getR20_over1y_to_3y() {
		return r20_over1y_to_3y;
	}
	public void setR20_over1y_to_3y(BigDecimal r20_over1y_to_3y) {
		this.r20_over1y_to_3y = r20_over1y_to_3y;
	}
	public BigDecimal getR20_over3y_to_5y() {
		return r20_over3y_to_5y;
	}
	public void setR20_over3y_to_5y(BigDecimal r20_over3y_to_5y) {
		this.r20_over3y_to_5y = r20_over3y_to_5y;
	}
	public BigDecimal getR20_over5y_to_7y() {
		return r20_over5y_to_7y;
	}
	public void setR20_over5y_to_7y(BigDecimal r20_over5y_to_7y) {
		this.r20_over5y_to_7y = r20_over5y_to_7y;
	}
	public BigDecimal getR20_over7y_to_10y() {
		return r20_over7y_to_10y;
	}
	public void setR20_over7y_to_10y(BigDecimal r20_over7y_to_10y) {
		this.r20_over7y_to_10y = r20_over7y_to_10y;
	}
	public BigDecimal getR20_over10y_to_15y() {
		return r20_over10y_to_15y;
	}
	public void setR20_over10y_to_15y(BigDecimal r20_over10y_to_15y) {
		this.r20_over10y_to_15y = r20_over10y_to_15y;
	}
	public BigDecimal getR20_over15y() {
		return r20_over15y;
	}
	public void setR20_over15y(BigDecimal r20_over15y) {
		this.r20_over15y = r20_over15y;
	}
	public BigDecimal getR20_non_sensitive() {
		return r20_non_sensitive;
	}
	public void setR20_non_sensitive(BigDecimal r20_non_sensitive) {
		this.r20_non_sensitive = r20_non_sensitive;
	}
	public BigDecimal getR20_total_rsl() {
		return r20_total_rsl;
	}
	public void setR20_total_rsl(BigDecimal r20_total_rsl) {
		this.r20_total_rsl = r20_total_rsl;
	}
	public BigDecimal getR20_total() {
		return r20_total;
	}
	public void setR20_total(BigDecimal r20_total) {
		this.r20_total = r20_total;
	}
	public String getR21_product() {
		return r21_product;
	}
	public void setR21_product(String r21_product) {
		this.r21_product = r21_product;
	}
	public BigDecimal getR21_day1_28() {
		return r21_day1_28;
	}
	public void setR21_day1_28(BigDecimal r21_day1_28) {
		this.r21_day1_28 = r21_day1_28;
	}
	public BigDecimal getR21_day29_3m() {
		return r21_day29_3m;
	}
	public void setR21_day29_3m(BigDecimal r21_day29_3m) {
		this.r21_day29_3m = r21_day29_3m;
	}
	public BigDecimal getR21_over3m_to_6m() {
		return r21_over3m_to_6m;
	}
	public void setR21_over3m_to_6m(BigDecimal r21_over3m_to_6m) {
		this.r21_over3m_to_6m = r21_over3m_to_6m;
	}
	public BigDecimal getR21_over6m_to_1y() {
		return r21_over6m_to_1y;
	}
	public void setR21_over6m_to_1y(BigDecimal r21_over6m_to_1y) {
		this.r21_over6m_to_1y = r21_over6m_to_1y;
	}
	public BigDecimal getR21_over1y_to_3y() {
		return r21_over1y_to_3y;
	}
	public void setR21_over1y_to_3y(BigDecimal r21_over1y_to_3y) {
		this.r21_over1y_to_3y = r21_over1y_to_3y;
	}
	public BigDecimal getR21_over3y_to_5y() {
		return r21_over3y_to_5y;
	}
	public void setR21_over3y_to_5y(BigDecimal r21_over3y_to_5y) {
		this.r21_over3y_to_5y = r21_over3y_to_5y;
	}
	public BigDecimal getR21_over5y_to_7y() {
		return r21_over5y_to_7y;
	}
	public void setR21_over5y_to_7y(BigDecimal r21_over5y_to_7y) {
		this.r21_over5y_to_7y = r21_over5y_to_7y;
	}
	public BigDecimal getR21_over7y_to_10y() {
		return r21_over7y_to_10y;
	}
	public void setR21_over7y_to_10y(BigDecimal r21_over7y_to_10y) {
		this.r21_over7y_to_10y = r21_over7y_to_10y;
	}
	public BigDecimal getR21_over10y_to_15y() {
		return r21_over10y_to_15y;
	}
	public void setR21_over10y_to_15y(BigDecimal r21_over10y_to_15y) {
		this.r21_over10y_to_15y = r21_over10y_to_15y;
	}
	public BigDecimal getR21_over15y() {
		return r21_over15y;
	}
	public void setR21_over15y(BigDecimal r21_over15y) {
		this.r21_over15y = r21_over15y;
	}
	public BigDecimal getR21_non_sensitive() {
		return r21_non_sensitive;
	}
	public void setR21_non_sensitive(BigDecimal r21_non_sensitive) {
		this.r21_non_sensitive = r21_non_sensitive;
	}
	public BigDecimal getR21_total_rsl() {
		return r21_total_rsl;
	}
	public void setR21_total_rsl(BigDecimal r21_total_rsl) {
		this.r21_total_rsl = r21_total_rsl;
	}
	public BigDecimal getR21_total() {
		return r21_total;
	}
	public void setR21_total(BigDecimal r21_total) {
		this.r21_total = r21_total;
	}
	public String getR22_product() {
		return r22_product;
	}
	public void setR22_product(String r22_product) {
		this.r22_product = r22_product;
	}
	public BigDecimal getR22_day1_28() {
		return r22_day1_28;
	}
	public void setR22_day1_28(BigDecimal r22_day1_28) {
		this.r22_day1_28 = r22_day1_28;
	}
	public BigDecimal getR22_day29_3m() {
		return r22_day29_3m;
	}
	public void setR22_day29_3m(BigDecimal r22_day29_3m) {
		this.r22_day29_3m = r22_day29_3m;
	}
	public BigDecimal getR22_over3m_to_6m() {
		return r22_over3m_to_6m;
	}
	public void setR22_over3m_to_6m(BigDecimal r22_over3m_to_6m) {
		this.r22_over3m_to_6m = r22_over3m_to_6m;
	}
	public BigDecimal getR22_over6m_to_1y() {
		return r22_over6m_to_1y;
	}
	public void setR22_over6m_to_1y(BigDecimal r22_over6m_to_1y) {
		this.r22_over6m_to_1y = r22_over6m_to_1y;
	}
	public BigDecimal getR22_over1y_to_3y() {
		return r22_over1y_to_3y;
	}
	public void setR22_over1y_to_3y(BigDecimal r22_over1y_to_3y) {
		this.r22_over1y_to_3y = r22_over1y_to_3y;
	}
	public BigDecimal getR22_over3y_to_5y() {
		return r22_over3y_to_5y;
	}
	public void setR22_over3y_to_5y(BigDecimal r22_over3y_to_5y) {
		this.r22_over3y_to_5y = r22_over3y_to_5y;
	}
	public BigDecimal getR22_over5y_to_7y() {
		return r22_over5y_to_7y;
	}
	public void setR22_over5y_to_7y(BigDecimal r22_over5y_to_7y) {
		this.r22_over5y_to_7y = r22_over5y_to_7y;
	}
	public BigDecimal getR22_over7y_to_10y() {
		return r22_over7y_to_10y;
	}
	public void setR22_over7y_to_10y(BigDecimal r22_over7y_to_10y) {
		this.r22_over7y_to_10y = r22_over7y_to_10y;
	}
	public BigDecimal getR22_over10y_to_15y() {
		return r22_over10y_to_15y;
	}
	public void setR22_over10y_to_15y(BigDecimal r22_over10y_to_15y) {
		this.r22_over10y_to_15y = r22_over10y_to_15y;
	}
	public BigDecimal getR22_over15y() {
		return r22_over15y;
	}
	public void setR22_over15y(BigDecimal r22_over15y) {
		this.r22_over15y = r22_over15y;
	}
	public BigDecimal getR22_non_sensitive() {
		return r22_non_sensitive;
	}
	public void setR22_non_sensitive(BigDecimal r22_non_sensitive) {
		this.r22_non_sensitive = r22_non_sensitive;
	}
	public BigDecimal getR22_total_rsl() {
		return r22_total_rsl;
	}
	public void setR22_total_rsl(BigDecimal r22_total_rsl) {
		this.r22_total_rsl = r22_total_rsl;
	}
	public BigDecimal getR22_total() {
		return r22_total;
	}
	public void setR22_total(BigDecimal r22_total) {
		this.r22_total = r22_total;
	}
	public String getR23_product() {
		return r23_product;
	}
	public void setR23_product(String r23_product) {
		this.r23_product = r23_product;
	}
	public BigDecimal getR23_day1_28() {
		return r23_day1_28;
	}
	public void setR23_day1_28(BigDecimal r23_day1_28) {
		this.r23_day1_28 = r23_day1_28;
	}
	public BigDecimal getR23_day29_3m() {
		return r23_day29_3m;
	}
	public void setR23_day29_3m(BigDecimal r23_day29_3m) {
		this.r23_day29_3m = r23_day29_3m;
	}
	public BigDecimal getR23_over3m_to_6m() {
		return r23_over3m_to_6m;
	}
	public void setR23_over3m_to_6m(BigDecimal r23_over3m_to_6m) {
		this.r23_over3m_to_6m = r23_over3m_to_6m;
	}
	public BigDecimal getR23_over6m_to_1y() {
		return r23_over6m_to_1y;
	}
	public void setR23_over6m_to_1y(BigDecimal r23_over6m_to_1y) {
		this.r23_over6m_to_1y = r23_over6m_to_1y;
	}
	public BigDecimal getR23_over1y_to_3y() {
		return r23_over1y_to_3y;
	}
	public void setR23_over1y_to_3y(BigDecimal r23_over1y_to_3y) {
		this.r23_over1y_to_3y = r23_over1y_to_3y;
	}
	public BigDecimal getR23_over3y_to_5y() {
		return r23_over3y_to_5y;
	}
	public void setR23_over3y_to_5y(BigDecimal r23_over3y_to_5y) {
		this.r23_over3y_to_5y = r23_over3y_to_5y;
	}
	public BigDecimal getR23_over5y_to_7y() {
		return r23_over5y_to_7y;
	}
	public void setR23_over5y_to_7y(BigDecimal r23_over5y_to_7y) {
		this.r23_over5y_to_7y = r23_over5y_to_7y;
	}
	public BigDecimal getR23_over7y_to_10y() {
		return r23_over7y_to_10y;
	}
	public void setR23_over7y_to_10y(BigDecimal r23_over7y_to_10y) {
		this.r23_over7y_to_10y = r23_over7y_to_10y;
	}
	public BigDecimal getR23_over10y_to_15y() {
		return r23_over10y_to_15y;
	}
	public void setR23_over10y_to_15y(BigDecimal r23_over10y_to_15y) {
		this.r23_over10y_to_15y = r23_over10y_to_15y;
	}
	public BigDecimal getR23_over15y() {
		return r23_over15y;
	}
	public void setR23_over15y(BigDecimal r23_over15y) {
		this.r23_over15y = r23_over15y;
	}
	public BigDecimal getR23_non_sensitive() {
		return r23_non_sensitive;
	}
	public void setR23_non_sensitive(BigDecimal r23_non_sensitive) {
		this.r23_non_sensitive = r23_non_sensitive;
	}
	public BigDecimal getR23_total_rsl() {
		return r23_total_rsl;
	}
	public void setR23_total_rsl(BigDecimal r23_total_rsl) {
		this.r23_total_rsl = r23_total_rsl;
	}
	public BigDecimal getR23_total() {
		return r23_total;
	}
	public void setR23_total(BigDecimal r23_total) {
		this.r23_total = r23_total;
	}
	public String getR24_product() {
		return r24_product;
	}
	public void setR24_product(String r24_product) {
		this.r24_product = r24_product;
	}
	public BigDecimal getR24_day1_28() {
		return r24_day1_28;
	}
	public void setR24_day1_28(BigDecimal r24_day1_28) {
		this.r24_day1_28 = r24_day1_28;
	}
	public BigDecimal getR24_day29_3m() {
		return r24_day29_3m;
	}
	public void setR24_day29_3m(BigDecimal r24_day29_3m) {
		this.r24_day29_3m = r24_day29_3m;
	}
	public BigDecimal getR24_over3m_to_6m() {
		return r24_over3m_to_6m;
	}
	public void setR24_over3m_to_6m(BigDecimal r24_over3m_to_6m) {
		this.r24_over3m_to_6m = r24_over3m_to_6m;
	}
	public BigDecimal getR24_over6m_to_1y() {
		return r24_over6m_to_1y;
	}
	public void setR24_over6m_to_1y(BigDecimal r24_over6m_to_1y) {
		this.r24_over6m_to_1y = r24_over6m_to_1y;
	}
	public BigDecimal getR24_over1y_to_3y() {
		return r24_over1y_to_3y;
	}
	public void setR24_over1y_to_3y(BigDecimal r24_over1y_to_3y) {
		this.r24_over1y_to_3y = r24_over1y_to_3y;
	}
	public BigDecimal getR24_over3y_to_5y() {
		return r24_over3y_to_5y;
	}
	public void setR24_over3y_to_5y(BigDecimal r24_over3y_to_5y) {
		this.r24_over3y_to_5y = r24_over3y_to_5y;
	}
	public BigDecimal getR24_over5y_to_7y() {
		return r24_over5y_to_7y;
	}
	public void setR24_over5y_to_7y(BigDecimal r24_over5y_to_7y) {
		this.r24_over5y_to_7y = r24_over5y_to_7y;
	}
	public BigDecimal getR24_over7y_to_10y() {
		return r24_over7y_to_10y;
	}
	public void setR24_over7y_to_10y(BigDecimal r24_over7y_to_10y) {
		this.r24_over7y_to_10y = r24_over7y_to_10y;
	}
	public BigDecimal getR24_over10y_to_15y() {
		return r24_over10y_to_15y;
	}
	public void setR24_over10y_to_15y(BigDecimal r24_over10y_to_15y) {
		this.r24_over10y_to_15y = r24_over10y_to_15y;
	}
	public BigDecimal getR24_over15y() {
		return r24_over15y;
	}
	public void setR24_over15y(BigDecimal r24_over15y) {
		this.r24_over15y = r24_over15y;
	}
	public BigDecimal getR24_non_sensitive() {
		return r24_non_sensitive;
	}
	public void setR24_non_sensitive(BigDecimal r24_non_sensitive) {
		this.r24_non_sensitive = r24_non_sensitive;
	}
	public BigDecimal getR24_total_rsl() {
		return r24_total_rsl;
	}
	public void setR24_total_rsl(BigDecimal r24_total_rsl) {
		this.r24_total_rsl = r24_total_rsl;
	}
	public BigDecimal getR24_total() {
		return r24_total;
	}
	public void setR24_total(BigDecimal r24_total) {
		this.r24_total = r24_total;
	}
	public String getR25_product() {
		return r25_product;
	}
	public void setR25_product(String r25_product) {
		this.r25_product = r25_product;
	}
	public BigDecimal getR25_day1_28() {
		return r25_day1_28;
	}
	public void setR25_day1_28(BigDecimal r25_day1_28) {
		this.r25_day1_28 = r25_day1_28;
	}
	public BigDecimal getR25_day29_3m() {
		return r25_day29_3m;
	}
	public void setR25_day29_3m(BigDecimal r25_day29_3m) {
		this.r25_day29_3m = r25_day29_3m;
	}
	public BigDecimal getR25_over3m_to_6m() {
		return r25_over3m_to_6m;
	}
	public void setR25_over3m_to_6m(BigDecimal r25_over3m_to_6m) {
		this.r25_over3m_to_6m = r25_over3m_to_6m;
	}
	public BigDecimal getR25_over6m_to_1y() {
		return r25_over6m_to_1y;
	}
	public void setR25_over6m_to_1y(BigDecimal r25_over6m_to_1y) {
		this.r25_over6m_to_1y = r25_over6m_to_1y;
	}
	public BigDecimal getR25_over1y_to_3y() {
		return r25_over1y_to_3y;
	}
	public void setR25_over1y_to_3y(BigDecimal r25_over1y_to_3y) {
		this.r25_over1y_to_3y = r25_over1y_to_3y;
	}
	public BigDecimal getR25_over3y_to_5y() {
		return r25_over3y_to_5y;
	}
	public void setR25_over3y_to_5y(BigDecimal r25_over3y_to_5y) {
		this.r25_over3y_to_5y = r25_over3y_to_5y;
	}
	public BigDecimal getR25_over5y_to_7y() {
		return r25_over5y_to_7y;
	}
	public void setR25_over5y_to_7y(BigDecimal r25_over5y_to_7y) {
		this.r25_over5y_to_7y = r25_over5y_to_7y;
	}
	public BigDecimal getR25_over7y_to_10y() {
		return r25_over7y_to_10y;
	}
	public void setR25_over7y_to_10y(BigDecimal r25_over7y_to_10y) {
		this.r25_over7y_to_10y = r25_over7y_to_10y;
	}
	public BigDecimal getR25_over10y_to_15y() {
		return r25_over10y_to_15y;
	}
	public void setR25_over10y_to_15y(BigDecimal r25_over10y_to_15y) {
		this.r25_over10y_to_15y = r25_over10y_to_15y;
	}
	public BigDecimal getR25_over15y() {
		return r25_over15y;
	}
	public void setR25_over15y(BigDecimal r25_over15y) {
		this.r25_over15y = r25_over15y;
	}
	public BigDecimal getR25_non_sensitive() {
		return r25_non_sensitive;
	}
	public void setR25_non_sensitive(BigDecimal r25_non_sensitive) {
		this.r25_non_sensitive = r25_non_sensitive;
	}
	public BigDecimal getR25_total_rsl() {
		return r25_total_rsl;
	}
	public void setR25_total_rsl(BigDecimal r25_total_rsl) {
		this.r25_total_rsl = r25_total_rsl;
	}
	public BigDecimal getR25_total() {
		return r25_total;
	}
	public void setR25_total(BigDecimal r25_total) {
		this.r25_total = r25_total;
	}
	public String getR26_product() {
		return r26_product;
	}
	public void setR26_product(String r26_product) {
		this.r26_product = r26_product;
	}
	public BigDecimal getR26_day1_28() {
		return r26_day1_28;
	}
	public void setR26_day1_28(BigDecimal r26_day1_28) {
		this.r26_day1_28 = r26_day1_28;
	}
	public BigDecimal getR26_day29_3m() {
		return r26_day29_3m;
	}
	public void setR26_day29_3m(BigDecimal r26_day29_3m) {
		this.r26_day29_3m = r26_day29_3m;
	}
	public BigDecimal getR26_over3m_to_6m() {
		return r26_over3m_to_6m;
	}
	public void setR26_over3m_to_6m(BigDecimal r26_over3m_to_6m) {
		this.r26_over3m_to_6m = r26_over3m_to_6m;
	}
	public BigDecimal getR26_over6m_to_1y() {
		return r26_over6m_to_1y;
	}
	public void setR26_over6m_to_1y(BigDecimal r26_over6m_to_1y) {
		this.r26_over6m_to_1y = r26_over6m_to_1y;
	}
	public BigDecimal getR26_over1y_to_3y() {
		return r26_over1y_to_3y;
	}
	public void setR26_over1y_to_3y(BigDecimal r26_over1y_to_3y) {
		this.r26_over1y_to_3y = r26_over1y_to_3y;
	}
	public BigDecimal getR26_over3y_to_5y() {
		return r26_over3y_to_5y;
	}
	public void setR26_over3y_to_5y(BigDecimal r26_over3y_to_5y) {
		this.r26_over3y_to_5y = r26_over3y_to_5y;
	}
	public BigDecimal getR26_over5y_to_7y() {
		return r26_over5y_to_7y;
	}
	public void setR26_over5y_to_7y(BigDecimal r26_over5y_to_7y) {
		this.r26_over5y_to_7y = r26_over5y_to_7y;
	}
	public BigDecimal getR26_over7y_to_10y() {
		return r26_over7y_to_10y;
	}
	public void setR26_over7y_to_10y(BigDecimal r26_over7y_to_10y) {
		this.r26_over7y_to_10y = r26_over7y_to_10y;
	}
	public BigDecimal getR26_over10y_to_15y() {
		return r26_over10y_to_15y;
	}
	public void setR26_over10y_to_15y(BigDecimal r26_over10y_to_15y) {
		this.r26_over10y_to_15y = r26_over10y_to_15y;
	}
	public BigDecimal getR26_over15y() {
		return r26_over15y;
	}
	public void setR26_over15y(BigDecimal r26_over15y) {
		this.r26_over15y = r26_over15y;
	}
	public BigDecimal getR26_non_sensitive() {
		return r26_non_sensitive;
	}
	public void setR26_non_sensitive(BigDecimal r26_non_sensitive) {
		this.r26_non_sensitive = r26_non_sensitive;
	}
	public BigDecimal getR26_total_rsl() {
		return r26_total_rsl;
	}
	public void setR26_total_rsl(BigDecimal r26_total_rsl) {
		this.r26_total_rsl = r26_total_rsl;
	}
	public BigDecimal getR26_total() {
		return r26_total;
	}
	public void setR26_total(BigDecimal r26_total) {
		this.r26_total = r26_total;
	}
	public String getR27_product() {
		return r27_product;
	}
	public void setR27_product(String r27_product) {
		this.r27_product = r27_product;
	}
	public BigDecimal getR27_day1_28() {
		return r27_day1_28;
	}
	public void setR27_day1_28(BigDecimal r27_day1_28) {
		this.r27_day1_28 = r27_day1_28;
	}
	public BigDecimal getR27_day29_3m() {
		return r27_day29_3m;
	}
	public void setR27_day29_3m(BigDecimal r27_day29_3m) {
		this.r27_day29_3m = r27_day29_3m;
	}
	public BigDecimal getR27_over3m_to_6m() {
		return r27_over3m_to_6m;
	}
	public void setR27_over3m_to_6m(BigDecimal r27_over3m_to_6m) {
		this.r27_over3m_to_6m = r27_over3m_to_6m;
	}
	public BigDecimal getR27_over6m_to_1y() {
		return r27_over6m_to_1y;
	}
	public void setR27_over6m_to_1y(BigDecimal r27_over6m_to_1y) {
		this.r27_over6m_to_1y = r27_over6m_to_1y;
	}
	public BigDecimal getR27_over1y_to_3y() {
		return r27_over1y_to_3y;
	}
	public void setR27_over1y_to_3y(BigDecimal r27_over1y_to_3y) {
		this.r27_over1y_to_3y = r27_over1y_to_3y;
	}
	public BigDecimal getR27_over3y_to_5y() {
		return r27_over3y_to_5y;
	}
	public void setR27_over3y_to_5y(BigDecimal r27_over3y_to_5y) {
		this.r27_over3y_to_5y = r27_over3y_to_5y;
	}
	public BigDecimal getR27_over5y_to_7y() {
		return r27_over5y_to_7y;
	}
	public void setR27_over5y_to_7y(BigDecimal r27_over5y_to_7y) {
		this.r27_over5y_to_7y = r27_over5y_to_7y;
	}
	public BigDecimal getR27_over7y_to_10y() {
		return r27_over7y_to_10y;
	}
	public void setR27_over7y_to_10y(BigDecimal r27_over7y_to_10y) {
		this.r27_over7y_to_10y = r27_over7y_to_10y;
	}
	public BigDecimal getR27_over10y_to_15y() {
		return r27_over10y_to_15y;
	}
	public void setR27_over10y_to_15y(BigDecimal r27_over10y_to_15y) {
		this.r27_over10y_to_15y = r27_over10y_to_15y;
	}
	public BigDecimal getR27_over15y() {
		return r27_over15y;
	}
	public void setR27_over15y(BigDecimal r27_over15y) {
		this.r27_over15y = r27_over15y;
	}
	public BigDecimal getR27_non_sensitive() {
		return r27_non_sensitive;
	}
	public void setR27_non_sensitive(BigDecimal r27_non_sensitive) {
		this.r27_non_sensitive = r27_non_sensitive;
	}
	public BigDecimal getR27_total_rsl() {
		return r27_total_rsl;
	}
	public void setR27_total_rsl(BigDecimal r27_total_rsl) {
		this.r27_total_rsl = r27_total_rsl;
	}
	public BigDecimal getR27_total() {
		return r27_total;
	}
	public void setR27_total(BigDecimal r27_total) {
		this.r27_total = r27_total;
	}
	public String getR28_product() {
		return r28_product;
	}
	public void setR28_product(String r28_product) {
		this.r28_product = r28_product;
	}
	public BigDecimal getR28_day1_28() {
		return r28_day1_28;
	}
	public void setR28_day1_28(BigDecimal r28_day1_28) {
		this.r28_day1_28 = r28_day1_28;
	}
	public BigDecimal getR28_day29_3m() {
		return r28_day29_3m;
	}
	public void setR28_day29_3m(BigDecimal r28_day29_3m) {
		this.r28_day29_3m = r28_day29_3m;
	}
	public BigDecimal getR28_over3m_to_6m() {
		return r28_over3m_to_6m;
	}
	public void setR28_over3m_to_6m(BigDecimal r28_over3m_to_6m) {
		this.r28_over3m_to_6m = r28_over3m_to_6m;
	}
	public BigDecimal getR28_over6m_to_1y() {
		return r28_over6m_to_1y;
	}
	public void setR28_over6m_to_1y(BigDecimal r28_over6m_to_1y) {
		this.r28_over6m_to_1y = r28_over6m_to_1y;
	}
	public BigDecimal getR28_over1y_to_3y() {
		return r28_over1y_to_3y;
	}
	public void setR28_over1y_to_3y(BigDecimal r28_over1y_to_3y) {
		this.r28_over1y_to_3y = r28_over1y_to_3y;
	}
	public BigDecimal getR28_over3y_to_5y() {
		return r28_over3y_to_5y;
	}
	public void setR28_over3y_to_5y(BigDecimal r28_over3y_to_5y) {
		this.r28_over3y_to_5y = r28_over3y_to_5y;
	}
	public BigDecimal getR28_over5y_to_7y() {
		return r28_over5y_to_7y;
	}
	public void setR28_over5y_to_7y(BigDecimal r28_over5y_to_7y) {
		this.r28_over5y_to_7y = r28_over5y_to_7y;
	}
	public BigDecimal getR28_over7y_to_10y() {
		return r28_over7y_to_10y;
	}
	public void setR28_over7y_to_10y(BigDecimal r28_over7y_to_10y) {
		this.r28_over7y_to_10y = r28_over7y_to_10y;
	}
	public BigDecimal getR28_over10y_to_15y() {
		return r28_over10y_to_15y;
	}
	public void setR28_over10y_to_15y(BigDecimal r28_over10y_to_15y) {
		this.r28_over10y_to_15y = r28_over10y_to_15y;
	}
	public BigDecimal getR28_over15y() {
		return r28_over15y;
	}
	public void setR28_over15y(BigDecimal r28_over15y) {
		this.r28_over15y = r28_over15y;
	}
	public BigDecimal getR28_non_sensitive() {
		return r28_non_sensitive;
	}
	public void setR28_non_sensitive(BigDecimal r28_non_sensitive) {
		this.r28_non_sensitive = r28_non_sensitive;
	}
	public BigDecimal getR28_total_rsl() {
		return r28_total_rsl;
	}
	public void setR28_total_rsl(BigDecimal r28_total_rsl) {
		this.r28_total_rsl = r28_total_rsl;
	}
	public BigDecimal getR28_total() {
		return r28_total;
	}
	public void setR28_total(BigDecimal r28_total) {
		this.r28_total = r28_total;
	}
	public String getR29_product() {
		return r29_product;
	}
	public void setR29_product(String r29_product) {
		this.r29_product = r29_product;
	}
	public BigDecimal getR29_day1_28() {
		return r29_day1_28;
	}
	public void setR29_day1_28(BigDecimal r29_day1_28) {
		this.r29_day1_28 = r29_day1_28;
	}
	public BigDecimal getR29_day29_3m() {
		return r29_day29_3m;
	}
	public void setR29_day29_3m(BigDecimal r29_day29_3m) {
		this.r29_day29_3m = r29_day29_3m;
	}
	public BigDecimal getR29_over3m_to_6m() {
		return r29_over3m_to_6m;
	}
	public void setR29_over3m_to_6m(BigDecimal r29_over3m_to_6m) {
		this.r29_over3m_to_6m = r29_over3m_to_6m;
	}
	public BigDecimal getR29_over6m_to_1y() {
		return r29_over6m_to_1y;
	}
	public void setR29_over6m_to_1y(BigDecimal r29_over6m_to_1y) {
		this.r29_over6m_to_1y = r29_over6m_to_1y;
	}
	public BigDecimal getR29_over1y_to_3y() {
		return r29_over1y_to_3y;
	}
	public void setR29_over1y_to_3y(BigDecimal r29_over1y_to_3y) {
		this.r29_over1y_to_3y = r29_over1y_to_3y;
	}
	public BigDecimal getR29_over3y_to_5y() {
		return r29_over3y_to_5y;
	}
	public void setR29_over3y_to_5y(BigDecimal r29_over3y_to_5y) {
		this.r29_over3y_to_5y = r29_over3y_to_5y;
	}
	public BigDecimal getR29_over5y_to_7y() {
		return r29_over5y_to_7y;
	}
	public void setR29_over5y_to_7y(BigDecimal r29_over5y_to_7y) {
		this.r29_over5y_to_7y = r29_over5y_to_7y;
	}
	public BigDecimal getR29_over7y_to_10y() {
		return r29_over7y_to_10y;
	}
	public void setR29_over7y_to_10y(BigDecimal r29_over7y_to_10y) {
		this.r29_over7y_to_10y = r29_over7y_to_10y;
	}
	public BigDecimal getR29_over10y_to_15y() {
		return r29_over10y_to_15y;
	}
	public void setR29_over10y_to_15y(BigDecimal r29_over10y_to_15y) {
		this.r29_over10y_to_15y = r29_over10y_to_15y;
	}
	public BigDecimal getR29_over15y() {
		return r29_over15y;
	}
	public void setR29_over15y(BigDecimal r29_over15y) {
		this.r29_over15y = r29_over15y;
	}
	public BigDecimal getR29_non_sensitive() {
		return r29_non_sensitive;
	}
	public void setR29_non_sensitive(BigDecimal r29_non_sensitive) {
		this.r29_non_sensitive = r29_non_sensitive;
	}
	public BigDecimal getR29_total_rsl() {
		return r29_total_rsl;
	}
	public void setR29_total_rsl(BigDecimal r29_total_rsl) {
		this.r29_total_rsl = r29_total_rsl;
	}
	public BigDecimal getR29_total() {
		return r29_total;
	}
	public void setR29_total(BigDecimal r29_total) {
		this.r29_total = r29_total;
	}
	public String getR30_product() {
		return r30_product;
	}
	public void setR30_product(String r30_product) {
		this.r30_product = r30_product;
	}
	public BigDecimal getR30_day1_28() {
		return r30_day1_28;
	}
	public void setR30_day1_28(BigDecimal r30_day1_28) {
		this.r30_day1_28 = r30_day1_28;
	}
	public BigDecimal getR30_day29_3m() {
		return r30_day29_3m;
	}
	public void setR30_day29_3m(BigDecimal r30_day29_3m) {
		this.r30_day29_3m = r30_day29_3m;
	}
	public BigDecimal getR30_over3m_to_6m() {
		return r30_over3m_to_6m;
	}
	public void setR30_over3m_to_6m(BigDecimal r30_over3m_to_6m) {
		this.r30_over3m_to_6m = r30_over3m_to_6m;
	}
	public BigDecimal getR30_over6m_to_1y() {
		return r30_over6m_to_1y;
	}
	public void setR30_over6m_to_1y(BigDecimal r30_over6m_to_1y) {
		this.r30_over6m_to_1y = r30_over6m_to_1y;
	}
	public BigDecimal getR30_over1y_to_3y() {
		return r30_over1y_to_3y;
	}
	public void setR30_over1y_to_3y(BigDecimal r30_over1y_to_3y) {
		this.r30_over1y_to_3y = r30_over1y_to_3y;
	}
	public BigDecimal getR30_over3y_to_5y() {
		return r30_over3y_to_5y;
	}
	public void setR30_over3y_to_5y(BigDecimal r30_over3y_to_5y) {
		this.r30_over3y_to_5y = r30_over3y_to_5y;
	}
	public BigDecimal getR30_over5y_to_7y() {
		return r30_over5y_to_7y;
	}
	public void setR30_over5y_to_7y(BigDecimal r30_over5y_to_7y) {
		this.r30_over5y_to_7y = r30_over5y_to_7y;
	}
	public BigDecimal getR30_over7y_to_10y() {
		return r30_over7y_to_10y;
	}
	public void setR30_over7y_to_10y(BigDecimal r30_over7y_to_10y) {
		this.r30_over7y_to_10y = r30_over7y_to_10y;
	}
	public BigDecimal getR30_over10y_to_15y() {
		return r30_over10y_to_15y;
	}
	public void setR30_over10y_to_15y(BigDecimal r30_over10y_to_15y) {
		this.r30_over10y_to_15y = r30_over10y_to_15y;
	}
	public BigDecimal getR30_over15y() {
		return r30_over15y;
	}
	public void setR30_over15y(BigDecimal r30_over15y) {
		this.r30_over15y = r30_over15y;
	}
	public BigDecimal getR30_non_sensitive() {
		return r30_non_sensitive;
	}
	public void setR30_non_sensitive(BigDecimal r30_non_sensitive) {
		this.r30_non_sensitive = r30_non_sensitive;
	}
	public BigDecimal getR30_total_rsl() {
		return r30_total_rsl;
	}
	public void setR30_total_rsl(BigDecimal r30_total_rsl) {
		this.r30_total_rsl = r30_total_rsl;
	}
	public BigDecimal getR30_total() {
		return r30_total;
	}
	public void setR30_total(BigDecimal r30_total) {
		this.r30_total = r30_total;
	}
	public String getR31_product() {
		return r31_product;
	}
	public void setR31_product(String r31_product) {
		this.r31_product = r31_product;
	}
	public BigDecimal getR31_day1_28() {
		return r31_day1_28;
	}
	public void setR31_day1_28(BigDecimal r31_day1_28) {
		this.r31_day1_28 = r31_day1_28;
	}
	public BigDecimal getR31_day29_3m() {
		return r31_day29_3m;
	}
	public void setR31_day29_3m(BigDecimal r31_day29_3m) {
		this.r31_day29_3m = r31_day29_3m;
	}
	public BigDecimal getR31_over3m_to_6m() {
		return r31_over3m_to_6m;
	}
	public void setR31_over3m_to_6m(BigDecimal r31_over3m_to_6m) {
		this.r31_over3m_to_6m = r31_over3m_to_6m;
	}
	public BigDecimal getR31_over6m_to_1y() {
		return r31_over6m_to_1y;
	}
	public void setR31_over6m_to_1y(BigDecimal r31_over6m_to_1y) {
		this.r31_over6m_to_1y = r31_over6m_to_1y;
	}
	public BigDecimal getR31_over1y_to_3y() {
		return r31_over1y_to_3y;
	}
	public void setR31_over1y_to_3y(BigDecimal r31_over1y_to_3y) {
		this.r31_over1y_to_3y = r31_over1y_to_3y;
	}
	public BigDecimal getR31_over3y_to_5y() {
		return r31_over3y_to_5y;
	}
	public void setR31_over3y_to_5y(BigDecimal r31_over3y_to_5y) {
		this.r31_over3y_to_5y = r31_over3y_to_5y;
	}
	public BigDecimal getR31_over5y_to_7y() {
		return r31_over5y_to_7y;
	}
	public void setR31_over5y_to_7y(BigDecimal r31_over5y_to_7y) {
		this.r31_over5y_to_7y = r31_over5y_to_7y;
	}
	public BigDecimal getR31_over7y_to_10y() {
		return r31_over7y_to_10y;
	}
	public void setR31_over7y_to_10y(BigDecimal r31_over7y_to_10y) {
		this.r31_over7y_to_10y = r31_over7y_to_10y;
	}
	public BigDecimal getR31_over10y_to_15y() {
		return r31_over10y_to_15y;
	}
	public void setR31_over10y_to_15y(BigDecimal r31_over10y_to_15y) {
		this.r31_over10y_to_15y = r31_over10y_to_15y;
	}
	public BigDecimal getR31_over15y() {
		return r31_over15y;
	}
	public void setR31_over15y(BigDecimal r31_over15y) {
		this.r31_over15y = r31_over15y;
	}
	public BigDecimal getR31_non_sensitive() {
		return r31_non_sensitive;
	}
	public void setR31_non_sensitive(BigDecimal r31_non_sensitive) {
		this.r31_non_sensitive = r31_non_sensitive;
	}
	public BigDecimal getR31_total_rsl() {
		return r31_total_rsl;
	}
	public void setR31_total_rsl(BigDecimal r31_total_rsl) {
		this.r31_total_rsl = r31_total_rsl;
	}
	public BigDecimal getR31_total() {
		return r31_total;
	}
	public void setR31_total(BigDecimal r31_total) {
		this.r31_total = r31_total;
	}
	public String getR32_product() {
		return r32_product;
	}
	public void setR32_product(String r32_product) {
		this.r32_product = r32_product;
	}
	public BigDecimal getR32_day1_28() {
		return r32_day1_28;
	}
	public void setR32_day1_28(BigDecimal r32_day1_28) {
		this.r32_day1_28 = r32_day1_28;
	}
	public BigDecimal getR32_day29_3m() {
		return r32_day29_3m;
	}
	public void setR32_day29_3m(BigDecimal r32_day29_3m) {
		this.r32_day29_3m = r32_day29_3m;
	}
	public BigDecimal getR32_over3m_to_6m() {
		return r32_over3m_to_6m;
	}
	public void setR32_over3m_to_6m(BigDecimal r32_over3m_to_6m) {
		this.r32_over3m_to_6m = r32_over3m_to_6m;
	}
	public BigDecimal getR32_over6m_to_1y() {
		return r32_over6m_to_1y;
	}
	public void setR32_over6m_to_1y(BigDecimal r32_over6m_to_1y) {
		this.r32_over6m_to_1y = r32_over6m_to_1y;
	}
	public BigDecimal getR32_over1y_to_3y() {
		return r32_over1y_to_3y;
	}
	public void setR32_over1y_to_3y(BigDecimal r32_over1y_to_3y) {
		this.r32_over1y_to_3y = r32_over1y_to_3y;
	}
	public BigDecimal getR32_over3y_to_5y() {
		return r32_over3y_to_5y;
	}
	public void setR32_over3y_to_5y(BigDecimal r32_over3y_to_5y) {
		this.r32_over3y_to_5y = r32_over3y_to_5y;
	}
	public BigDecimal getR32_over5y_to_7y() {
		return r32_over5y_to_7y;
	}
	public void setR32_over5y_to_7y(BigDecimal r32_over5y_to_7y) {
		this.r32_over5y_to_7y = r32_over5y_to_7y;
	}
	public BigDecimal getR32_over7y_to_10y() {
		return r32_over7y_to_10y;
	}
	public void setR32_over7y_to_10y(BigDecimal r32_over7y_to_10y) {
		this.r32_over7y_to_10y = r32_over7y_to_10y;
	}
	public BigDecimal getR32_over10y_to_15y() {
		return r32_over10y_to_15y;
	}
	public void setR32_over10y_to_15y(BigDecimal r32_over10y_to_15y) {
		this.r32_over10y_to_15y = r32_over10y_to_15y;
	}
	public BigDecimal getR32_over15y() {
		return r32_over15y;
	}
	public void setR32_over15y(BigDecimal r32_over15y) {
		this.r32_over15y = r32_over15y;
	}
	public BigDecimal getR32_non_sensitive() {
		return r32_non_sensitive;
	}
	public void setR32_non_sensitive(BigDecimal r32_non_sensitive) {
		this.r32_non_sensitive = r32_non_sensitive;
	}
	public BigDecimal getR32_total_rsl() {
		return r32_total_rsl;
	}
	public void setR32_total_rsl(BigDecimal r32_total_rsl) {
		this.r32_total_rsl = r32_total_rsl;
	}
	public BigDecimal getR32_total() {
		return r32_total;
	}
	public void setR32_total(BigDecimal r32_total) {
		this.r32_total = r32_total;
	}
	public String getR33_product() {
		return r33_product;
	}
	public void setR33_product(String r33_product) {
		this.r33_product = r33_product;
	}
	public BigDecimal getR33_day1_28() {
		return r33_day1_28;
	}
	public void setR33_day1_28(BigDecimal r33_day1_28) {
		this.r33_day1_28 = r33_day1_28;
	}
	public BigDecimal getR33_day29_3m() {
		return r33_day29_3m;
	}
	public void setR33_day29_3m(BigDecimal r33_day29_3m) {
		this.r33_day29_3m = r33_day29_3m;
	}
	public BigDecimal getR33_over3m_to_6m() {
		return r33_over3m_to_6m;
	}
	public void setR33_over3m_to_6m(BigDecimal r33_over3m_to_6m) {
		this.r33_over3m_to_6m = r33_over3m_to_6m;
	}
	public BigDecimal getR33_over6m_to_1y() {
		return r33_over6m_to_1y;
	}
	public void setR33_over6m_to_1y(BigDecimal r33_over6m_to_1y) {
		this.r33_over6m_to_1y = r33_over6m_to_1y;
	}
	public BigDecimal getR33_over1y_to_3y() {
		return r33_over1y_to_3y;
	}
	public void setR33_over1y_to_3y(BigDecimal r33_over1y_to_3y) {
		this.r33_over1y_to_3y = r33_over1y_to_3y;
	}
	public BigDecimal getR33_over3y_to_5y() {
		return r33_over3y_to_5y;
	}
	public void setR33_over3y_to_5y(BigDecimal r33_over3y_to_5y) {
		this.r33_over3y_to_5y = r33_over3y_to_5y;
	}
	public BigDecimal getR33_over5y_to_7y() {
		return r33_over5y_to_7y;
	}
	public void setR33_over5y_to_7y(BigDecimal r33_over5y_to_7y) {
		this.r33_over5y_to_7y = r33_over5y_to_7y;
	}
	public BigDecimal getR33_over7y_to_10y() {
		return r33_over7y_to_10y;
	}
	public void setR33_over7y_to_10y(BigDecimal r33_over7y_to_10y) {
		this.r33_over7y_to_10y = r33_over7y_to_10y;
	}
	public BigDecimal getR33_over10y_to_15y() {
		return r33_over10y_to_15y;
	}
	public void setR33_over10y_to_15y(BigDecimal r33_over10y_to_15y) {
		this.r33_over10y_to_15y = r33_over10y_to_15y;
	}
	public BigDecimal getR33_over15y() {
		return r33_over15y;
	}
	public void setR33_over15y(BigDecimal r33_over15y) {
		this.r33_over15y = r33_over15y;
	}
	public BigDecimal getR33_non_sensitive() {
		return r33_non_sensitive;
	}
	public void setR33_non_sensitive(BigDecimal r33_non_sensitive) {
		this.r33_non_sensitive = r33_non_sensitive;
	}
	public BigDecimal getR33_total_rsl() {
		return r33_total_rsl;
	}
	public void setR33_total_rsl(BigDecimal r33_total_rsl) {
		this.r33_total_rsl = r33_total_rsl;
	}
	public BigDecimal getR33_total() {
		return r33_total;
	}
	public void setR33_total(BigDecimal r33_total) {
		this.r33_total = r33_total;
	}
	public String getR34_product() {
		return r34_product;
	}
	public void setR34_product(String r34_product) {
		this.r34_product = r34_product;
	}
	public BigDecimal getR34_day1_28() {
		return r34_day1_28;
	}
	public void setR34_day1_28(BigDecimal r34_day1_28) {
		this.r34_day1_28 = r34_day1_28;
	}
	public BigDecimal getR34_day29_3m() {
		return r34_day29_3m;
	}
	public void setR34_day29_3m(BigDecimal r34_day29_3m) {
		this.r34_day29_3m = r34_day29_3m;
	}
	public BigDecimal getR34_over3m_to_6m() {
		return r34_over3m_to_6m;
	}
	public void setR34_over3m_to_6m(BigDecimal r34_over3m_to_6m) {
		this.r34_over3m_to_6m = r34_over3m_to_6m;
	}
	public BigDecimal getR34_over6m_to_1y() {
		return r34_over6m_to_1y;
	}
	public void setR34_over6m_to_1y(BigDecimal r34_over6m_to_1y) {
		this.r34_over6m_to_1y = r34_over6m_to_1y;
	}
	public BigDecimal getR34_over1y_to_3y() {
		return r34_over1y_to_3y;
	}
	public void setR34_over1y_to_3y(BigDecimal r34_over1y_to_3y) {
		this.r34_over1y_to_3y = r34_over1y_to_3y;
	}
	public BigDecimal getR34_over3y_to_5y() {
		return r34_over3y_to_5y;
	}
	public void setR34_over3y_to_5y(BigDecimal r34_over3y_to_5y) {
		this.r34_over3y_to_5y = r34_over3y_to_5y;
	}
	public BigDecimal getR34_over5y_to_7y() {
		return r34_over5y_to_7y;
	}
	public void setR34_over5y_to_7y(BigDecimal r34_over5y_to_7y) {
		this.r34_over5y_to_7y = r34_over5y_to_7y;
	}
	public BigDecimal getR34_over7y_to_10y() {
		return r34_over7y_to_10y;
	}
	public void setR34_over7y_to_10y(BigDecimal r34_over7y_to_10y) {
		this.r34_over7y_to_10y = r34_over7y_to_10y;
	}
	public BigDecimal getR34_over10y_to_15y() {
		return r34_over10y_to_15y;
	}
	public void setR34_over10y_to_15y(BigDecimal r34_over10y_to_15y) {
		this.r34_over10y_to_15y = r34_over10y_to_15y;
	}
	public BigDecimal getR34_over15y() {
		return r34_over15y;
	}
	public void setR34_over15y(BigDecimal r34_over15y) {
		this.r34_over15y = r34_over15y;
	}
	public BigDecimal getR34_non_sensitive() {
		return r34_non_sensitive;
	}
	public void setR34_non_sensitive(BigDecimal r34_non_sensitive) {
		this.r34_non_sensitive = r34_non_sensitive;
	}
	public BigDecimal getR34_total_rsl() {
		return r34_total_rsl;
	}
	public void setR34_total_rsl(BigDecimal r34_total_rsl) {
		this.r34_total_rsl = r34_total_rsl;
	}
	public BigDecimal getR34_total() {
		return r34_total;
	}
	public void setR34_total(BigDecimal r34_total) {
		this.r34_total = r34_total;
	}
	public String getR35_product() {
		return r35_product;
	}
	public void setR35_product(String r35_product) {
		this.r35_product = r35_product;
	}
	public BigDecimal getR35_day1_28() {
		return r35_day1_28;
	}
	public void setR35_day1_28(BigDecimal r35_day1_28) {
		this.r35_day1_28 = r35_day1_28;
	}
	public BigDecimal getR35_day29_3m() {
		return r35_day29_3m;
	}
	public void setR35_day29_3m(BigDecimal r35_day29_3m) {
		this.r35_day29_3m = r35_day29_3m;
	}
	public BigDecimal getR35_over3m_to_6m() {
		return r35_over3m_to_6m;
	}
	public void setR35_over3m_to_6m(BigDecimal r35_over3m_to_6m) {
		this.r35_over3m_to_6m = r35_over3m_to_6m;
	}
	public BigDecimal getR35_over6m_to_1y() {
		return r35_over6m_to_1y;
	}
	public void setR35_over6m_to_1y(BigDecimal r35_over6m_to_1y) {
		this.r35_over6m_to_1y = r35_over6m_to_1y;
	}
	public BigDecimal getR35_over1y_to_3y() {
		return r35_over1y_to_3y;
	}
	public void setR35_over1y_to_3y(BigDecimal r35_over1y_to_3y) {
		this.r35_over1y_to_3y = r35_over1y_to_3y;
	}
	public BigDecimal getR35_over3y_to_5y() {
		return r35_over3y_to_5y;
	}
	public void setR35_over3y_to_5y(BigDecimal r35_over3y_to_5y) {
		this.r35_over3y_to_5y = r35_over3y_to_5y;
	}
	public BigDecimal getR35_over5y_to_7y() {
		return r35_over5y_to_7y;
	}
	public void setR35_over5y_to_7y(BigDecimal r35_over5y_to_7y) {
		this.r35_over5y_to_7y = r35_over5y_to_7y;
	}
	public BigDecimal getR35_over7y_to_10y() {
		return r35_over7y_to_10y;
	}
	public void setR35_over7y_to_10y(BigDecimal r35_over7y_to_10y) {
		this.r35_over7y_to_10y = r35_over7y_to_10y;
	}
	public BigDecimal getR35_over10y_to_15y() {
		return r35_over10y_to_15y;
	}
	public void setR35_over10y_to_15y(BigDecimal r35_over10y_to_15y) {
		this.r35_over10y_to_15y = r35_over10y_to_15y;
	}
	public BigDecimal getR35_over15y() {
		return r35_over15y;
	}
	public void setR35_over15y(BigDecimal r35_over15y) {
		this.r35_over15y = r35_over15y;
	}
	public BigDecimal getR35_non_sensitive() {
		return r35_non_sensitive;
	}
	public void setR35_non_sensitive(BigDecimal r35_non_sensitive) {
		this.r35_non_sensitive = r35_non_sensitive;
	}
	public BigDecimal getR35_total_rsl() {
		return r35_total_rsl;
	}
	public void setR35_total_rsl(BigDecimal r35_total_rsl) {
		this.r35_total_rsl = r35_total_rsl;
	}
	public BigDecimal getR35_total() {
		return r35_total;
	}
	public void setR35_total(BigDecimal r35_total) {
		this.r35_total = r35_total;
	}
	public String getR36_product() {
		return r36_product;
	}
	public void setR36_product(String r36_product) {
		this.r36_product = r36_product;
	}
	public BigDecimal getR36_day1_28() {
		return r36_day1_28;
	}
	public void setR36_day1_28(BigDecimal r36_day1_28) {
		this.r36_day1_28 = r36_day1_28;
	}
	public BigDecimal getR36_day29_3m() {
		return r36_day29_3m;
	}
	public void setR36_day29_3m(BigDecimal r36_day29_3m) {
		this.r36_day29_3m = r36_day29_3m;
	}
	public BigDecimal getR36_over3m_to_6m() {
		return r36_over3m_to_6m;
	}
	public void setR36_over3m_to_6m(BigDecimal r36_over3m_to_6m) {
		this.r36_over3m_to_6m = r36_over3m_to_6m;
	}
	public BigDecimal getR36_over6m_to_1y() {
		return r36_over6m_to_1y;
	}
	public void setR36_over6m_to_1y(BigDecimal r36_over6m_to_1y) {
		this.r36_over6m_to_1y = r36_over6m_to_1y;
	}
	public BigDecimal getR36_over1y_to_3y() {
		return r36_over1y_to_3y;
	}
	public void setR36_over1y_to_3y(BigDecimal r36_over1y_to_3y) {
		this.r36_over1y_to_3y = r36_over1y_to_3y;
	}
	public BigDecimal getR36_over3y_to_5y() {
		return r36_over3y_to_5y;
	}
	public void setR36_over3y_to_5y(BigDecimal r36_over3y_to_5y) {
		this.r36_over3y_to_5y = r36_over3y_to_5y;
	}
	public BigDecimal getR36_over5y_to_7y() {
		return r36_over5y_to_7y;
	}
	public void setR36_over5y_to_7y(BigDecimal r36_over5y_to_7y) {
		this.r36_over5y_to_7y = r36_over5y_to_7y;
	}
	public BigDecimal getR36_over7y_to_10y() {
		return r36_over7y_to_10y;
	}
	public void setR36_over7y_to_10y(BigDecimal r36_over7y_to_10y) {
		this.r36_over7y_to_10y = r36_over7y_to_10y;
	}
	public BigDecimal getR36_over10y_to_15y() {
		return r36_over10y_to_15y;
	}
	public void setR36_over10y_to_15y(BigDecimal r36_over10y_to_15y) {
		this.r36_over10y_to_15y = r36_over10y_to_15y;
	}
	public BigDecimal getR36_over15y() {
		return r36_over15y;
	}
	public void setR36_over15y(BigDecimal r36_over15y) {
		this.r36_over15y = r36_over15y;
	}
	public BigDecimal getR36_non_sensitive() {
		return r36_non_sensitive;
	}
	public void setR36_non_sensitive(BigDecimal r36_non_sensitive) {
		this.r36_non_sensitive = r36_non_sensitive;
	}
	public BigDecimal getR36_total_rsl() {
		return r36_total_rsl;
	}
	public void setR36_total_rsl(BigDecimal r36_total_rsl) {
		this.r36_total_rsl = r36_total_rsl;
	}
	public BigDecimal getR36_total() {
		return r36_total;
	}
	public void setR36_total(BigDecimal r36_total) {
		this.r36_total = r36_total;
	}
	public String getR37_product() {
		return r37_product;
	}
	public void setR37_product(String r37_product) {
		this.r37_product = r37_product;
	}
	public BigDecimal getR37_day1_28() {
		return r37_day1_28;
	}
	public void setR37_day1_28(BigDecimal r37_day1_28) {
		this.r37_day1_28 = r37_day1_28;
	}
	public BigDecimal getR37_day29_3m() {
		return r37_day29_3m;
	}
	public void setR37_day29_3m(BigDecimal r37_day29_3m) {
		this.r37_day29_3m = r37_day29_3m;
	}
	public BigDecimal getR37_over3m_to_6m() {
		return r37_over3m_to_6m;
	}
	public void setR37_over3m_to_6m(BigDecimal r37_over3m_to_6m) {
		this.r37_over3m_to_6m = r37_over3m_to_6m;
	}
	public BigDecimal getR37_over6m_to_1y() {
		return r37_over6m_to_1y;
	}
	public void setR37_over6m_to_1y(BigDecimal r37_over6m_to_1y) {
		this.r37_over6m_to_1y = r37_over6m_to_1y;
	}
	public BigDecimal getR37_over1y_to_3y() {
		return r37_over1y_to_3y;
	}
	public void setR37_over1y_to_3y(BigDecimal r37_over1y_to_3y) {
		this.r37_over1y_to_3y = r37_over1y_to_3y;
	}
	public BigDecimal getR37_over3y_to_5y() {
		return r37_over3y_to_5y;
	}
	public void setR37_over3y_to_5y(BigDecimal r37_over3y_to_5y) {
		this.r37_over3y_to_5y = r37_over3y_to_5y;
	}
	public BigDecimal getR37_over5y_to_7y() {
		return r37_over5y_to_7y;
	}
	public void setR37_over5y_to_7y(BigDecimal r37_over5y_to_7y) {
		this.r37_over5y_to_7y = r37_over5y_to_7y;
	}
	public BigDecimal getR37_over7y_to_10y() {
		return r37_over7y_to_10y;
	}
	public void setR37_over7y_to_10y(BigDecimal r37_over7y_to_10y) {
		this.r37_over7y_to_10y = r37_over7y_to_10y;
	}
	public BigDecimal getR37_over10y_to_15y() {
		return r37_over10y_to_15y;
	}
	public void setR37_over10y_to_15y(BigDecimal r37_over10y_to_15y) {
		this.r37_over10y_to_15y = r37_over10y_to_15y;
	}
	public BigDecimal getR37_over15y() {
		return r37_over15y;
	}
	public void setR37_over15y(BigDecimal r37_over15y) {
		this.r37_over15y = r37_over15y;
	}
	public BigDecimal getR37_non_sensitive() {
		return r37_non_sensitive;
	}
	public void setR37_non_sensitive(BigDecimal r37_non_sensitive) {
		this.r37_non_sensitive = r37_non_sensitive;
	}
	public BigDecimal getR37_total_rsl() {
		return r37_total_rsl;
	}
	public void setR37_total_rsl(BigDecimal r37_total_rsl) {
		this.r37_total_rsl = r37_total_rsl;
	}
	public BigDecimal getR37_total() {
		return r37_total;
	}
	public void setR37_total(BigDecimal r37_total) {
		this.r37_total = r37_total;
	}
	public String getR38_product() {
		return r38_product;
	}
	public void setR38_product(String r38_product) {
		this.r38_product = r38_product;
	}
	public BigDecimal getR38_day1_28() {
		return r38_day1_28;
	}
	public void setR38_day1_28(BigDecimal r38_day1_28) {
		this.r38_day1_28 = r38_day1_28;
	}
	public BigDecimal getR38_day29_3m() {
		return r38_day29_3m;
	}
	public void setR38_day29_3m(BigDecimal r38_day29_3m) {
		this.r38_day29_3m = r38_day29_3m;
	}
	public BigDecimal getR38_over3m_to_6m() {
		return r38_over3m_to_6m;
	}
	public void setR38_over3m_to_6m(BigDecimal r38_over3m_to_6m) {
		this.r38_over3m_to_6m = r38_over3m_to_6m;
	}
	public BigDecimal getR38_over6m_to_1y() {
		return r38_over6m_to_1y;
	}
	public void setR38_over6m_to_1y(BigDecimal r38_over6m_to_1y) {
		this.r38_over6m_to_1y = r38_over6m_to_1y;
	}
	public BigDecimal getR38_over1y_to_3y() {
		return r38_over1y_to_3y;
	}
	public void setR38_over1y_to_3y(BigDecimal r38_over1y_to_3y) {
		this.r38_over1y_to_3y = r38_over1y_to_3y;
	}
	public BigDecimal getR38_over3y_to_5y() {
		return r38_over3y_to_5y;
	}
	public void setR38_over3y_to_5y(BigDecimal r38_over3y_to_5y) {
		this.r38_over3y_to_5y = r38_over3y_to_5y;
	}
	public BigDecimal getR38_over5y_to_7y() {
		return r38_over5y_to_7y;
	}
	public void setR38_over5y_to_7y(BigDecimal r38_over5y_to_7y) {
		this.r38_over5y_to_7y = r38_over5y_to_7y;
	}
	public BigDecimal getR38_over7y_to_10y() {
		return r38_over7y_to_10y;
	}
	public void setR38_over7y_to_10y(BigDecimal r38_over7y_to_10y) {
		this.r38_over7y_to_10y = r38_over7y_to_10y;
	}
	public BigDecimal getR38_over10y_to_15y() {
		return r38_over10y_to_15y;
	}
	public void setR38_over10y_to_15y(BigDecimal r38_over10y_to_15y) {
		this.r38_over10y_to_15y = r38_over10y_to_15y;
	}
	public BigDecimal getR38_over15y() {
		return r38_over15y;
	}
	public void setR38_over15y(BigDecimal r38_over15y) {
		this.r38_over15y = r38_over15y;
	}
	public BigDecimal getR38_non_sensitive() {
		return r38_non_sensitive;
	}
	public void setR38_non_sensitive(BigDecimal r38_non_sensitive) {
		this.r38_non_sensitive = r38_non_sensitive;
	}
	public BigDecimal getR38_total_rsl() {
		return r38_total_rsl;
	}
	public void setR38_total_rsl(BigDecimal r38_total_rsl) {
		this.r38_total_rsl = r38_total_rsl;
	}
	public BigDecimal getR38_total() {
		return r38_total;
	}
	public void setR38_total(BigDecimal r38_total) {
		this.r38_total = r38_total;
	}
	public String getR39_product() {
		return r39_product;
	}
	public void setR39_product(String r39_product) {
		this.r39_product = r39_product;
	}
	public BigDecimal getR39_day1_28() {
		return r39_day1_28;
	}
	public void setR39_day1_28(BigDecimal r39_day1_28) {
		this.r39_day1_28 = r39_day1_28;
	}
	public BigDecimal getR39_day29_3m() {
		return r39_day29_3m;
	}
	public void setR39_day29_3m(BigDecimal r39_day29_3m) {
		this.r39_day29_3m = r39_day29_3m;
	}
	public BigDecimal getR39_over3m_to_6m() {
		return r39_over3m_to_6m;
	}
	public void setR39_over3m_to_6m(BigDecimal r39_over3m_to_6m) {
		this.r39_over3m_to_6m = r39_over3m_to_6m;
	}
	public BigDecimal getR39_over6m_to_1y() {
		return r39_over6m_to_1y;
	}
	public void setR39_over6m_to_1y(BigDecimal r39_over6m_to_1y) {
		this.r39_over6m_to_1y = r39_over6m_to_1y;
	}
	public BigDecimal getR39_over1y_to_3y() {
		return r39_over1y_to_3y;
	}
	public void setR39_over1y_to_3y(BigDecimal r39_over1y_to_3y) {
		this.r39_over1y_to_3y = r39_over1y_to_3y;
	}
	public BigDecimal getR39_over3y_to_5y() {
		return r39_over3y_to_5y;
	}
	public void setR39_over3y_to_5y(BigDecimal r39_over3y_to_5y) {
		this.r39_over3y_to_5y = r39_over3y_to_5y;
	}
	public BigDecimal getR39_over5y_to_7y() {
		return r39_over5y_to_7y;
	}
	public void setR39_over5y_to_7y(BigDecimal r39_over5y_to_7y) {
		this.r39_over5y_to_7y = r39_over5y_to_7y;
	}
	public BigDecimal getR39_over7y_to_10y() {
		return r39_over7y_to_10y;
	}
	public void setR39_over7y_to_10y(BigDecimal r39_over7y_to_10y) {
		this.r39_over7y_to_10y = r39_over7y_to_10y;
	}
	public BigDecimal getR39_over10y_to_15y() {
		return r39_over10y_to_15y;
	}
	public void setR39_over10y_to_15y(BigDecimal r39_over10y_to_15y) {
		this.r39_over10y_to_15y = r39_over10y_to_15y;
	}
	public BigDecimal getR39_over15y() {
		return r39_over15y;
	}
	public void setR39_over15y(BigDecimal r39_over15y) {
		this.r39_over15y = r39_over15y;
	}
	public BigDecimal getR39_non_sensitive() {
		return r39_non_sensitive;
	}
	public void setR39_non_sensitive(BigDecimal r39_non_sensitive) {
		this.r39_non_sensitive = r39_non_sensitive;
	}
	public BigDecimal getR39_total_rsl() {
		return r39_total_rsl;
	}
	public void setR39_total_rsl(BigDecimal r39_total_rsl) {
		this.r39_total_rsl = r39_total_rsl;
	}
	public BigDecimal getR39_total() {
		return r39_total;
	}
	public void setR39_total(BigDecimal r39_total) {
		this.r39_total = r39_total;
	}
	public String getR40_product() {
		return r40_product;
	}
	public void setR40_product(String r40_product) {
		this.r40_product = r40_product;
	}
	public BigDecimal getR40_day1_28() {
		return r40_day1_28;
	}
	public void setR40_day1_28(BigDecimal r40_day1_28) {
		this.r40_day1_28 = r40_day1_28;
	}
	public BigDecimal getR40_day29_3m() {
		return r40_day29_3m;
	}
	public void setR40_day29_3m(BigDecimal r40_day29_3m) {
		this.r40_day29_3m = r40_day29_3m;
	}
	public BigDecimal getR40_over3m_to_6m() {
		return r40_over3m_to_6m;
	}
	public void setR40_over3m_to_6m(BigDecimal r40_over3m_to_6m) {
		this.r40_over3m_to_6m = r40_over3m_to_6m;
	}
	public BigDecimal getR40_over6m_to_1y() {
		return r40_over6m_to_1y;
	}
	public void setR40_over6m_to_1y(BigDecimal r40_over6m_to_1y) {
		this.r40_over6m_to_1y = r40_over6m_to_1y;
	}
	public BigDecimal getR40_over1y_to_3y() {
		return r40_over1y_to_3y;
	}
	public void setR40_over1y_to_3y(BigDecimal r40_over1y_to_3y) {
		this.r40_over1y_to_3y = r40_over1y_to_3y;
	}
	public BigDecimal getR40_over3y_to_5y() {
		return r40_over3y_to_5y;
	}
	public void setR40_over3y_to_5y(BigDecimal r40_over3y_to_5y) {
		this.r40_over3y_to_5y = r40_over3y_to_5y;
	}
	public BigDecimal getR40_over5y_to_7y() {
		return r40_over5y_to_7y;
	}
	public void setR40_over5y_to_7y(BigDecimal r40_over5y_to_7y) {
		this.r40_over5y_to_7y = r40_over5y_to_7y;
	}
	public BigDecimal getR40_over7y_to_10y() {
		return r40_over7y_to_10y;
	}
	public void setR40_over7y_to_10y(BigDecimal r40_over7y_to_10y) {
		this.r40_over7y_to_10y = r40_over7y_to_10y;
	}
	public BigDecimal getR40_over10y_to_15y() {
		return r40_over10y_to_15y;
	}
	public void setR40_over10y_to_15y(BigDecimal r40_over10y_to_15y) {
		this.r40_over10y_to_15y = r40_over10y_to_15y;
	}
	public BigDecimal getR40_over15y() {
		return r40_over15y;
	}
	public void setR40_over15y(BigDecimal r40_over15y) {
		this.r40_over15y = r40_over15y;
	}
	public BigDecimal getR40_non_sensitive() {
		return r40_non_sensitive;
	}
	public void setR40_non_sensitive(BigDecimal r40_non_sensitive) {
		this.r40_non_sensitive = r40_non_sensitive;
	}
	public BigDecimal getR40_total_rsl() {
		return r40_total_rsl;
	}
	public void setR40_total_rsl(BigDecimal r40_total_rsl) {
		this.r40_total_rsl = r40_total_rsl;
	}
	public BigDecimal getR40_total() {
		return r40_total;
	}
	public void setR40_total(BigDecimal r40_total) {
		this.r40_total = r40_total;
	}
	public String getR41_product() {
		return r41_product;
	}
	public void setR41_product(String r41_product) {
		this.r41_product = r41_product;
	}
	public BigDecimal getR41_day1_28() {
		return r41_day1_28;
	}
	public void setR41_day1_28(BigDecimal r41_day1_28) {
		this.r41_day1_28 = r41_day1_28;
	}
	public BigDecimal getR41_day29_3m() {
		return r41_day29_3m;
	}
	public void setR41_day29_3m(BigDecimal r41_day29_3m) {
		this.r41_day29_3m = r41_day29_3m;
	}
	public BigDecimal getR41_over3m_to_6m() {
		return r41_over3m_to_6m;
	}
	public void setR41_over3m_to_6m(BigDecimal r41_over3m_to_6m) {
		this.r41_over3m_to_6m = r41_over3m_to_6m;
	}
	public BigDecimal getR41_over6m_to_1y() {
		return r41_over6m_to_1y;
	}
	public void setR41_over6m_to_1y(BigDecimal r41_over6m_to_1y) {
		this.r41_over6m_to_1y = r41_over6m_to_1y;
	}
	public BigDecimal getR41_over1y_to_3y() {
		return r41_over1y_to_3y;
	}
	public void setR41_over1y_to_3y(BigDecimal r41_over1y_to_3y) {
		this.r41_over1y_to_3y = r41_over1y_to_3y;
	}
	public BigDecimal getR41_over3y_to_5y() {
		return r41_over3y_to_5y;
	}
	public void setR41_over3y_to_5y(BigDecimal r41_over3y_to_5y) {
		this.r41_over3y_to_5y = r41_over3y_to_5y;
	}
	public BigDecimal getR41_over5y_to_7y() {
		return r41_over5y_to_7y;
	}
	public void setR41_over5y_to_7y(BigDecimal r41_over5y_to_7y) {
		this.r41_over5y_to_7y = r41_over5y_to_7y;
	}
	public BigDecimal getR41_over7y_to_10y() {
		return r41_over7y_to_10y;
	}
	public void setR41_over7y_to_10y(BigDecimal r41_over7y_to_10y) {
		this.r41_over7y_to_10y = r41_over7y_to_10y;
	}
	public BigDecimal getR41_over10y_to_15y() {
		return r41_over10y_to_15y;
	}
	public void setR41_over10y_to_15y(BigDecimal r41_over10y_to_15y) {
		this.r41_over10y_to_15y = r41_over10y_to_15y;
	}
	public BigDecimal getR41_over15y() {
		return r41_over15y;
	}
	public void setR41_over15y(BigDecimal r41_over15y) {
		this.r41_over15y = r41_over15y;
	}
	public BigDecimal getR41_non_sensitive() {
		return r41_non_sensitive;
	}
	public void setR41_non_sensitive(BigDecimal r41_non_sensitive) {
		this.r41_non_sensitive = r41_non_sensitive;
	}
	public BigDecimal getR41_total_rsl() {
		return r41_total_rsl;
	}
	public void setR41_total_rsl(BigDecimal r41_total_rsl) {
		this.r41_total_rsl = r41_total_rsl;
	}
	public BigDecimal getR41_total() {
		return r41_total;
	}
	public void setR41_total(BigDecimal r41_total) {
		this.r41_total = r41_total;
	}
	public String getR42_product() {
		return r42_product;
	}
	public void setR42_product(String r42_product) {
		this.r42_product = r42_product;
	}
	public BigDecimal getR42_day1_28() {
		return r42_day1_28;
	}
	public void setR42_day1_28(BigDecimal r42_day1_28) {
		this.r42_day1_28 = r42_day1_28;
	}
	public BigDecimal getR42_day29_3m() {
		return r42_day29_3m;
	}
	public void setR42_day29_3m(BigDecimal r42_day29_3m) {
		this.r42_day29_3m = r42_day29_3m;
	}
	public BigDecimal getR42_over3m_to_6m() {
		return r42_over3m_to_6m;
	}
	public void setR42_over3m_to_6m(BigDecimal r42_over3m_to_6m) {
		this.r42_over3m_to_6m = r42_over3m_to_6m;
	}
	public BigDecimal getR42_over6m_to_1y() {
		return r42_over6m_to_1y;
	}
	public void setR42_over6m_to_1y(BigDecimal r42_over6m_to_1y) {
		this.r42_over6m_to_1y = r42_over6m_to_1y;
	}
	public BigDecimal getR42_over1y_to_3y() {
		return r42_over1y_to_3y;
	}
	public void setR42_over1y_to_3y(BigDecimal r42_over1y_to_3y) {
		this.r42_over1y_to_3y = r42_over1y_to_3y;
	}
	public BigDecimal getR42_over3y_to_5y() {
		return r42_over3y_to_5y;
	}
	public void setR42_over3y_to_5y(BigDecimal r42_over3y_to_5y) {
		this.r42_over3y_to_5y = r42_over3y_to_5y;
	}
	public BigDecimal getR42_over5y_to_7y() {
		return r42_over5y_to_7y;
	}
	public void setR42_over5y_to_7y(BigDecimal r42_over5y_to_7y) {
		this.r42_over5y_to_7y = r42_over5y_to_7y;
	}
	public BigDecimal getR42_over7y_to_10y() {
		return r42_over7y_to_10y;
	}
	public void setR42_over7y_to_10y(BigDecimal r42_over7y_to_10y) {
		this.r42_over7y_to_10y = r42_over7y_to_10y;
	}
	public BigDecimal getR42_over10y_to_15y() {
		return r42_over10y_to_15y;
	}
	public void setR42_over10y_to_15y(BigDecimal r42_over10y_to_15y) {
		this.r42_over10y_to_15y = r42_over10y_to_15y;
	}
	public BigDecimal getR42_over15y() {
		return r42_over15y;
	}
	public void setR42_over15y(BigDecimal r42_over15y) {
		this.r42_over15y = r42_over15y;
	}
	public BigDecimal getR42_non_sensitive() {
		return r42_non_sensitive;
	}
	public void setR42_non_sensitive(BigDecimal r42_non_sensitive) {
		this.r42_non_sensitive = r42_non_sensitive;
	}
	public BigDecimal getR42_total_rsl() {
		return r42_total_rsl;
	}
	public void setR42_total_rsl(BigDecimal r42_total_rsl) {
		this.r42_total_rsl = r42_total_rsl;
	}
	public BigDecimal getR42_total() {
		return r42_total;
	}
	public void setR42_total(BigDecimal r42_total) {
		this.r42_total = r42_total;
	}
	public String getR43_product() {
		return r43_product;
	}
	public void setR43_product(String r43_product) {
		this.r43_product = r43_product;
	}
	public BigDecimal getR43_day1_28() {
		return r43_day1_28;
	}
	public void setR43_day1_28(BigDecimal r43_day1_28) {
		this.r43_day1_28 = r43_day1_28;
	}
	public BigDecimal getR43_day29_3m() {
		return r43_day29_3m;
	}
	public void setR43_day29_3m(BigDecimal r43_day29_3m) {
		this.r43_day29_3m = r43_day29_3m;
	}
	public BigDecimal getR43_over3m_to_6m() {
		return r43_over3m_to_6m;
	}
	public void setR43_over3m_to_6m(BigDecimal r43_over3m_to_6m) {
		this.r43_over3m_to_6m = r43_over3m_to_6m;
	}
	public BigDecimal getR43_over6m_to_1y() {
		return r43_over6m_to_1y;
	}
	public void setR43_over6m_to_1y(BigDecimal r43_over6m_to_1y) {
		this.r43_over6m_to_1y = r43_over6m_to_1y;
	}
	public BigDecimal getR43_over1y_to_3y() {
		return r43_over1y_to_3y;
	}
	public void setR43_over1y_to_3y(BigDecimal r43_over1y_to_3y) {
		this.r43_over1y_to_3y = r43_over1y_to_3y;
	}
	public BigDecimal getR43_over3y_to_5y() {
		return r43_over3y_to_5y;
	}
	public void setR43_over3y_to_5y(BigDecimal r43_over3y_to_5y) {
		this.r43_over3y_to_5y = r43_over3y_to_5y;
	}
	public BigDecimal getR43_over5y_to_7y() {
		return r43_over5y_to_7y;
	}
	public void setR43_over5y_to_7y(BigDecimal r43_over5y_to_7y) {
		this.r43_over5y_to_7y = r43_over5y_to_7y;
	}
	public BigDecimal getR43_over7y_to_10y() {
		return r43_over7y_to_10y;
	}
	public void setR43_over7y_to_10y(BigDecimal r43_over7y_to_10y) {
		this.r43_over7y_to_10y = r43_over7y_to_10y;
	}
	public BigDecimal getR43_over10y_to_15y() {
		return r43_over10y_to_15y;
	}
	public void setR43_over10y_to_15y(BigDecimal r43_over10y_to_15y) {
		this.r43_over10y_to_15y = r43_over10y_to_15y;
	}
	public BigDecimal getR43_over15y() {
		return r43_over15y;
	}
	public void setR43_over15y(BigDecimal r43_over15y) {
		this.r43_over15y = r43_over15y;
	}
	public BigDecimal getR43_non_sensitive() {
		return r43_non_sensitive;
	}
	public void setR43_non_sensitive(BigDecimal r43_non_sensitive) {
		this.r43_non_sensitive = r43_non_sensitive;
	}
	public BigDecimal getR43_total_rsl() {
		return r43_total_rsl;
	}
	public void setR43_total_rsl(BigDecimal r43_total_rsl) {
		this.r43_total_rsl = r43_total_rsl;
	}
	public BigDecimal getR43_total() {
		return r43_total;
	}
	public void setR43_total(BigDecimal r43_total) {
		this.r43_total = r43_total;
	}
	public String getR44_product() {
		return r44_product;
	}
	public void setR44_product(String r44_product) {
		this.r44_product = r44_product;
	}
	public BigDecimal getR44_day1_28() {
		return r44_day1_28;
	}
	public void setR44_day1_28(BigDecimal r44_day1_28) {
		this.r44_day1_28 = r44_day1_28;
	}
	public BigDecimal getR44_day29_3m() {
		return r44_day29_3m;
	}
	public void setR44_day29_3m(BigDecimal r44_day29_3m) {
		this.r44_day29_3m = r44_day29_3m;
	}
	public BigDecimal getR44_over3m_to_6m() {
		return r44_over3m_to_6m;
	}
	public void setR44_over3m_to_6m(BigDecimal r44_over3m_to_6m) {
		this.r44_over3m_to_6m = r44_over3m_to_6m;
	}
	public BigDecimal getR44_over6m_to_1y() {
		return r44_over6m_to_1y;
	}
	public void setR44_over6m_to_1y(BigDecimal r44_over6m_to_1y) {
		this.r44_over6m_to_1y = r44_over6m_to_1y;
	}
	public BigDecimal getR44_over1y_to_3y() {
		return r44_over1y_to_3y;
	}
	public void setR44_over1y_to_3y(BigDecimal r44_over1y_to_3y) {
		this.r44_over1y_to_3y = r44_over1y_to_3y;
	}
	public BigDecimal getR44_over3y_to_5y() {
		return r44_over3y_to_5y;
	}
	public void setR44_over3y_to_5y(BigDecimal r44_over3y_to_5y) {
		this.r44_over3y_to_5y = r44_over3y_to_5y;
	}
	public BigDecimal getR44_over5y_to_7y() {
		return r44_over5y_to_7y;
	}
	public void setR44_over5y_to_7y(BigDecimal r44_over5y_to_7y) {
		this.r44_over5y_to_7y = r44_over5y_to_7y;
	}
	public BigDecimal getR44_over7y_to_10y() {
		return r44_over7y_to_10y;
	}
	public void setR44_over7y_to_10y(BigDecimal r44_over7y_to_10y) {
		this.r44_over7y_to_10y = r44_over7y_to_10y;
	}
	public BigDecimal getR44_over10y_to_15y() {
		return r44_over10y_to_15y;
	}
	public void setR44_over10y_to_15y(BigDecimal r44_over10y_to_15y) {
		this.r44_over10y_to_15y = r44_over10y_to_15y;
	}
	public BigDecimal getR44_over15y() {
		return r44_over15y;
	}
	public void setR44_over15y(BigDecimal r44_over15y) {
		this.r44_over15y = r44_over15y;
	}
	public BigDecimal getR44_non_sensitive() {
		return r44_non_sensitive;
	}
	public void setR44_non_sensitive(BigDecimal r44_non_sensitive) {
		this.r44_non_sensitive = r44_non_sensitive;
	}
	public BigDecimal getR44_total_rsl() {
		return r44_total_rsl;
	}
	public void setR44_total_rsl(BigDecimal r44_total_rsl) {
		this.r44_total_rsl = r44_total_rsl;
	}
	public BigDecimal getR44_total() {
		return r44_total;
	}
	public void setR44_total(BigDecimal r44_total) {
		this.r44_total = r44_total;
	}
	public String getR45_product() {
		return r45_product;
	}
	public void setR45_product(String r45_product) {
		this.r45_product = r45_product;
	}
	public BigDecimal getR45_day1_28() {
		return r45_day1_28;
	}
	public void setR45_day1_28(BigDecimal r45_day1_28) {
		this.r45_day1_28 = r45_day1_28;
	}
	public BigDecimal getR45_day29_3m() {
		return r45_day29_3m;
	}
	public void setR45_day29_3m(BigDecimal r45_day29_3m) {
		this.r45_day29_3m = r45_day29_3m;
	}
	public BigDecimal getR45_over3m_to_6m() {
		return r45_over3m_to_6m;
	}
	public void setR45_over3m_to_6m(BigDecimal r45_over3m_to_6m) {
		this.r45_over3m_to_6m = r45_over3m_to_6m;
	}
	public BigDecimal getR45_over6m_to_1y() {
		return r45_over6m_to_1y;
	}
	public void setR45_over6m_to_1y(BigDecimal r45_over6m_to_1y) {
		this.r45_over6m_to_1y = r45_over6m_to_1y;
	}
	public BigDecimal getR45_over1y_to_3y() {
		return r45_over1y_to_3y;
	}
	public void setR45_over1y_to_3y(BigDecimal r45_over1y_to_3y) {
		this.r45_over1y_to_3y = r45_over1y_to_3y;
	}
	public BigDecimal getR45_over3y_to_5y() {
		return r45_over3y_to_5y;
	}
	public void setR45_over3y_to_5y(BigDecimal r45_over3y_to_5y) {
		this.r45_over3y_to_5y = r45_over3y_to_5y;
	}
	public BigDecimal getR45_over5y_to_7y() {
		return r45_over5y_to_7y;
	}
	public void setR45_over5y_to_7y(BigDecimal r45_over5y_to_7y) {
		this.r45_over5y_to_7y = r45_over5y_to_7y;
	}
	public BigDecimal getR45_over7y_to_10y() {
		return r45_over7y_to_10y;
	}
	public void setR45_over7y_to_10y(BigDecimal r45_over7y_to_10y) {
		this.r45_over7y_to_10y = r45_over7y_to_10y;
	}
	public BigDecimal getR45_over10y_to_15y() {
		return r45_over10y_to_15y;
	}
	public void setR45_over10y_to_15y(BigDecimal r45_over10y_to_15y) {
		this.r45_over10y_to_15y = r45_over10y_to_15y;
	}
	public BigDecimal getR45_over15y() {
		return r45_over15y;
	}
	public void setR45_over15y(BigDecimal r45_over15y) {
		this.r45_over15y = r45_over15y;
	}
	public BigDecimal getR45_non_sensitive() {
		return r45_non_sensitive;
	}
	public void setR45_non_sensitive(BigDecimal r45_non_sensitive) {
		this.r45_non_sensitive = r45_non_sensitive;
	}
	public BigDecimal getR45_total_rsl() {
		return r45_total_rsl;
	}
	public void setR45_total_rsl(BigDecimal r45_total_rsl) {
		this.r45_total_rsl = r45_total_rsl;
	}
	public BigDecimal getR45_total() {
		return r45_total;
	}
	public void setR45_total(BigDecimal r45_total) {
		this.r45_total = r45_total;
	}
	public String getR46_product() {
		return r46_product;
	}
	public void setR46_product(String r46_product) {
		this.r46_product = r46_product;
	}
	public BigDecimal getR46_day1_28() {
		return r46_day1_28;
	}
	public void setR46_day1_28(BigDecimal r46_day1_28) {
		this.r46_day1_28 = r46_day1_28;
	}
	public BigDecimal getR46_day29_3m() {
		return r46_day29_3m;
	}
	public void setR46_day29_3m(BigDecimal r46_day29_3m) {
		this.r46_day29_3m = r46_day29_3m;
	}
	public BigDecimal getR46_over3m_to_6m() {
		return r46_over3m_to_6m;
	}
	public void setR46_over3m_to_6m(BigDecimal r46_over3m_to_6m) {
		this.r46_over3m_to_6m = r46_over3m_to_6m;
	}
	public BigDecimal getR46_over6m_to_1y() {
		return r46_over6m_to_1y;
	}
	public void setR46_over6m_to_1y(BigDecimal r46_over6m_to_1y) {
		this.r46_over6m_to_1y = r46_over6m_to_1y;
	}
	public BigDecimal getR46_over1y_to_3y() {
		return r46_over1y_to_3y;
	}
	public void setR46_over1y_to_3y(BigDecimal r46_over1y_to_3y) {
		this.r46_over1y_to_3y = r46_over1y_to_3y;
	}
	public BigDecimal getR46_over3y_to_5y() {
		return r46_over3y_to_5y;
	}
	public void setR46_over3y_to_5y(BigDecimal r46_over3y_to_5y) {
		this.r46_over3y_to_5y = r46_over3y_to_5y;
	}
	public BigDecimal getR46_over5y_to_7y() {
		return r46_over5y_to_7y;
	}
	public void setR46_over5y_to_7y(BigDecimal r46_over5y_to_7y) {
		this.r46_over5y_to_7y = r46_over5y_to_7y;
	}
	public BigDecimal getR46_over7y_to_10y() {
		return r46_over7y_to_10y;
	}
	public void setR46_over7y_to_10y(BigDecimal r46_over7y_to_10y) {
		this.r46_over7y_to_10y = r46_over7y_to_10y;
	}
	public BigDecimal getR46_over10y_to_15y() {
		return r46_over10y_to_15y;
	}
	public void setR46_over10y_to_15y(BigDecimal r46_over10y_to_15y) {
		this.r46_over10y_to_15y = r46_over10y_to_15y;
	}
	public BigDecimal getR46_over15y() {
		return r46_over15y;
	}
	public void setR46_over15y(BigDecimal r46_over15y) {
		this.r46_over15y = r46_over15y;
	}
	public BigDecimal getR46_non_sensitive() {
		return r46_non_sensitive;
	}
	public void setR46_non_sensitive(BigDecimal r46_non_sensitive) {
		this.r46_non_sensitive = r46_non_sensitive;
	}
	public BigDecimal getR46_total_rsl() {
		return r46_total_rsl;
	}
	public void setR46_total_rsl(BigDecimal r46_total_rsl) {
		this.r46_total_rsl = r46_total_rsl;
	}
	public BigDecimal getR46_total() {
		return r46_total;
	}
	public void setR46_total(BigDecimal r46_total) {
		this.r46_total = r46_total;
	}
	public String getR47_product() {
		return r47_product;
	}
	public void setR47_product(String r47_product) {
		this.r47_product = r47_product;
	}
	public BigDecimal getR47_day1_28() {
		return r47_day1_28;
	}
	public void setR47_day1_28(BigDecimal r47_day1_28) {
		this.r47_day1_28 = r47_day1_28;
	}
	public BigDecimal getR47_day29_3m() {
		return r47_day29_3m;
	}
	public void setR47_day29_3m(BigDecimal r47_day29_3m) {
		this.r47_day29_3m = r47_day29_3m;
	}
	public BigDecimal getR47_over3m_to_6m() {
		return r47_over3m_to_6m;
	}
	public void setR47_over3m_to_6m(BigDecimal r47_over3m_to_6m) {
		this.r47_over3m_to_6m = r47_over3m_to_6m;
	}
	public BigDecimal getR47_over6m_to_1y() {
		return r47_over6m_to_1y;
	}
	public void setR47_over6m_to_1y(BigDecimal r47_over6m_to_1y) {
		this.r47_over6m_to_1y = r47_over6m_to_1y;
	}
	public BigDecimal getR47_over1y_to_3y() {
		return r47_over1y_to_3y;
	}
	public void setR47_over1y_to_3y(BigDecimal r47_over1y_to_3y) {
		this.r47_over1y_to_3y = r47_over1y_to_3y;
	}
	public BigDecimal getR47_over3y_to_5y() {
		return r47_over3y_to_5y;
	}
	public void setR47_over3y_to_5y(BigDecimal r47_over3y_to_5y) {
		this.r47_over3y_to_5y = r47_over3y_to_5y;
	}
	public BigDecimal getR47_over5y_to_7y() {
		return r47_over5y_to_7y;
	}
	public void setR47_over5y_to_7y(BigDecimal r47_over5y_to_7y) {
		this.r47_over5y_to_7y = r47_over5y_to_7y;
	}
	public BigDecimal getR47_over7y_to_10y() {
		return r47_over7y_to_10y;
	}
	public void setR47_over7y_to_10y(BigDecimal r47_over7y_to_10y) {
		this.r47_over7y_to_10y = r47_over7y_to_10y;
	}
	public BigDecimal getR47_over10y_to_15y() {
		return r47_over10y_to_15y;
	}
	public void setR47_over10y_to_15y(BigDecimal r47_over10y_to_15y) {
		this.r47_over10y_to_15y = r47_over10y_to_15y;
	}
	public BigDecimal getR47_over15y() {
		return r47_over15y;
	}
	public void setR47_over15y(BigDecimal r47_over15y) {
		this.r47_over15y = r47_over15y;
	}
	public BigDecimal getR47_non_sensitive() {
		return r47_non_sensitive;
	}
	public void setR47_non_sensitive(BigDecimal r47_non_sensitive) {
		this.r47_non_sensitive = r47_non_sensitive;
	}
	public BigDecimal getR47_total_rsl() {
		return r47_total_rsl;
	}
	public void setR47_total_rsl(BigDecimal r47_total_rsl) {
		this.r47_total_rsl = r47_total_rsl;
	}
	public BigDecimal getR47_total() {
		return r47_total;
	}
	public void setR47_total(BigDecimal r47_total) {
		this.r47_total = r47_total;
	}
	public String getR48_product() {
		return r48_product;
	}
	public void setR48_product(String r48_product) {
		this.r48_product = r48_product;
	}
	public BigDecimal getR48_day1_28() {
		return r48_day1_28;
	}
	public void setR48_day1_28(BigDecimal r48_day1_28) {
		this.r48_day1_28 = r48_day1_28;
	}
	public BigDecimal getR48_day29_3m() {
		return r48_day29_3m;
	}
	public void setR48_day29_3m(BigDecimal r48_day29_3m) {
		this.r48_day29_3m = r48_day29_3m;
	}
	public BigDecimal getR48_over3m_to_6m() {
		return r48_over3m_to_6m;
	}
	public void setR48_over3m_to_6m(BigDecimal r48_over3m_to_6m) {
		this.r48_over3m_to_6m = r48_over3m_to_6m;
	}
	public BigDecimal getR48_over6m_to_1y() {
		return r48_over6m_to_1y;
	}
	public void setR48_over6m_to_1y(BigDecimal r48_over6m_to_1y) {
		this.r48_over6m_to_1y = r48_over6m_to_1y;
	}
	public BigDecimal getR48_over1y_to_3y() {
		return r48_over1y_to_3y;
	}
	public void setR48_over1y_to_3y(BigDecimal r48_over1y_to_3y) {
		this.r48_over1y_to_3y = r48_over1y_to_3y;
	}
	public BigDecimal getR48_over3y_to_5y() {
		return r48_over3y_to_5y;
	}
	public void setR48_over3y_to_5y(BigDecimal r48_over3y_to_5y) {
		this.r48_over3y_to_5y = r48_over3y_to_5y;
	}
	public BigDecimal getR48_over5y_to_7y() {
		return r48_over5y_to_7y;
	}
	public void setR48_over5y_to_7y(BigDecimal r48_over5y_to_7y) {
		this.r48_over5y_to_7y = r48_over5y_to_7y;
	}
	public BigDecimal getR48_over7y_to_10y() {
		return r48_over7y_to_10y;
	}
	public void setR48_over7y_to_10y(BigDecimal r48_over7y_to_10y) {
		this.r48_over7y_to_10y = r48_over7y_to_10y;
	}
	public BigDecimal getR48_over10y_to_15y() {
		return r48_over10y_to_15y;
	}
	public void setR48_over10y_to_15y(BigDecimal r48_over10y_to_15y) {
		this.r48_over10y_to_15y = r48_over10y_to_15y;
	}
	public BigDecimal getR48_over15y() {
		return r48_over15y;
	}
	public void setR48_over15y(BigDecimal r48_over15y) {
		this.r48_over15y = r48_over15y;
	}
	public BigDecimal getR48_non_sensitive() {
		return r48_non_sensitive;
	}
	public void setR48_non_sensitive(BigDecimal r48_non_sensitive) {
		this.r48_non_sensitive = r48_non_sensitive;
	}
	public BigDecimal getR48_total_rsl() {
		return r48_total_rsl;
	}
	public void setR48_total_rsl(BigDecimal r48_total_rsl) {
		this.r48_total_rsl = r48_total_rsl;
	}
	public BigDecimal getR48_total() {
		return r48_total;
	}
	public void setR48_total(BigDecimal r48_total) {
		this.r48_total = r48_total;
	}
	public String getR49_product() {
		return r49_product;
	}
	public void setR49_product(String r49_product) {
		this.r49_product = r49_product;
	}
	public BigDecimal getR49_day1_28() {
		return r49_day1_28;
	}
	public void setR49_day1_28(BigDecimal r49_day1_28) {
		this.r49_day1_28 = r49_day1_28;
	}
	public BigDecimal getR49_day29_3m() {
		return r49_day29_3m;
	}
	public void setR49_day29_3m(BigDecimal r49_day29_3m) {
		this.r49_day29_3m = r49_day29_3m;
	}
	public BigDecimal getR49_over3m_to_6m() {
		return r49_over3m_to_6m;
	}
	public void setR49_over3m_to_6m(BigDecimal r49_over3m_to_6m) {
		this.r49_over3m_to_6m = r49_over3m_to_6m;
	}
	public BigDecimal getR49_over6m_to_1y() {
		return r49_over6m_to_1y;
	}
	public void setR49_over6m_to_1y(BigDecimal r49_over6m_to_1y) {
		this.r49_over6m_to_1y = r49_over6m_to_1y;
	}
	public BigDecimal getR49_over1y_to_3y() {
		return r49_over1y_to_3y;
	}
	public void setR49_over1y_to_3y(BigDecimal r49_over1y_to_3y) {
		this.r49_over1y_to_3y = r49_over1y_to_3y;
	}
	public BigDecimal getR49_over3y_to_5y() {
		return r49_over3y_to_5y;
	}
	public void setR49_over3y_to_5y(BigDecimal r49_over3y_to_5y) {
		this.r49_over3y_to_5y = r49_over3y_to_5y;
	}
	public BigDecimal getR49_over5y_to_7y() {
		return r49_over5y_to_7y;
	}
	public void setR49_over5y_to_7y(BigDecimal r49_over5y_to_7y) {
		this.r49_over5y_to_7y = r49_over5y_to_7y;
	}
	public BigDecimal getR49_over7y_to_10y() {
		return r49_over7y_to_10y;
	}
	public void setR49_over7y_to_10y(BigDecimal r49_over7y_to_10y) {
		this.r49_over7y_to_10y = r49_over7y_to_10y;
	}
	public BigDecimal getR49_over10y_to_15y() {
		return r49_over10y_to_15y;
	}
	public void setR49_over10y_to_15y(BigDecimal r49_over10y_to_15y) {
		this.r49_over10y_to_15y = r49_over10y_to_15y;
	}
	public BigDecimal getR49_over15y() {
		return r49_over15y;
	}
	public void setR49_over15y(BigDecimal r49_over15y) {
		this.r49_over15y = r49_over15y;
	}
	public BigDecimal getR49_non_sensitive() {
		return r49_non_sensitive;
	}
	public void setR49_non_sensitive(BigDecimal r49_non_sensitive) {
		this.r49_non_sensitive = r49_non_sensitive;
	}
	public BigDecimal getR49_total_rsl() {
		return r49_total_rsl;
	}
	public void setR49_total_rsl(BigDecimal r49_total_rsl) {
		this.r49_total_rsl = r49_total_rsl;
	}
	public BigDecimal getR49_total() {
		return r49_total;
	}
	public void setR49_total(BigDecimal r49_total) {
		this.r49_total = r49_total;
	}
	public String getR50_product() {
		return r50_product;
	}
	public void setR50_product(String r50_product) {
		this.r50_product = r50_product;
	}
	public BigDecimal getR50_day1_28() {
		return r50_day1_28;
	}
	public void setR50_day1_28(BigDecimal r50_day1_28) {
		this.r50_day1_28 = r50_day1_28;
	}
	public BigDecimal getR50_day29_3m() {
		return r50_day29_3m;
	}
	public void setR50_day29_3m(BigDecimal r50_day29_3m) {
		this.r50_day29_3m = r50_day29_3m;
	}
	public BigDecimal getR50_over3m_to_6m() {
		return r50_over3m_to_6m;
	}
	public void setR50_over3m_to_6m(BigDecimal r50_over3m_to_6m) {
		this.r50_over3m_to_6m = r50_over3m_to_6m;
	}
	public BigDecimal getR50_over6m_to_1y() {
		return r50_over6m_to_1y;
	}
	public void setR50_over6m_to_1y(BigDecimal r50_over6m_to_1y) {
		this.r50_over6m_to_1y = r50_over6m_to_1y;
	}
	public BigDecimal getR50_over1y_to_3y() {
		return r50_over1y_to_3y;
	}
	public void setR50_over1y_to_3y(BigDecimal r50_over1y_to_3y) {
		this.r50_over1y_to_3y = r50_over1y_to_3y;
	}
	public BigDecimal getR50_over3y_to_5y() {
		return r50_over3y_to_5y;
	}
	public void setR50_over3y_to_5y(BigDecimal r50_over3y_to_5y) {
		this.r50_over3y_to_5y = r50_over3y_to_5y;
	}
	public BigDecimal getR50_over5y_to_7y() {
		return r50_over5y_to_7y;
	}
	public void setR50_over5y_to_7y(BigDecimal r50_over5y_to_7y) {
		this.r50_over5y_to_7y = r50_over5y_to_7y;
	}
	public BigDecimal getR50_over7y_to_10y() {
		return r50_over7y_to_10y;
	}
	public void setR50_over7y_to_10y(BigDecimal r50_over7y_to_10y) {
		this.r50_over7y_to_10y = r50_over7y_to_10y;
	}
	public BigDecimal getR50_over10y_to_15y() {
		return r50_over10y_to_15y;
	}
	public void setR50_over10y_to_15y(BigDecimal r50_over10y_to_15y) {
		this.r50_over10y_to_15y = r50_over10y_to_15y;
	}
	public BigDecimal getR50_over15y() {
		return r50_over15y;
	}
	public void setR50_over15y(BigDecimal r50_over15y) {
		this.r50_over15y = r50_over15y;
	}
	public BigDecimal getR50_non_sensitive() {
		return r50_non_sensitive;
	}
	public void setR50_non_sensitive(BigDecimal r50_non_sensitive) {
		this.r50_non_sensitive = r50_non_sensitive;
	}
	public BigDecimal getR50_total_rsl() {
		return r50_total_rsl;
	}
	public void setR50_total_rsl(BigDecimal r50_total_rsl) {
		this.r50_total_rsl = r50_total_rsl;
	}
	public BigDecimal getR50_total() {
		return r50_total;
	}
	public void setR50_total(BigDecimal r50_total) {
		this.r50_total = r50_total;
	}
	public String getR51_product() {
		return r51_product;
	}
	public void setR51_product(String r51_product) {
		this.r51_product = r51_product;
	}
	public BigDecimal getR51_day1_28() {
		return r51_day1_28;
	}
	public void setR51_day1_28(BigDecimal r51_day1_28) {
		this.r51_day1_28 = r51_day1_28;
	}
	public BigDecimal getR51_day29_3m() {
		return r51_day29_3m;
	}
	public void setR51_day29_3m(BigDecimal r51_day29_3m) {
		this.r51_day29_3m = r51_day29_3m;
	}
	public BigDecimal getR51_over3m_to_6m() {
		return r51_over3m_to_6m;
	}
	public void setR51_over3m_to_6m(BigDecimal r51_over3m_to_6m) {
		this.r51_over3m_to_6m = r51_over3m_to_6m;
	}
	public BigDecimal getR51_over6m_to_1y() {
		return r51_over6m_to_1y;
	}
	public void setR51_over6m_to_1y(BigDecimal r51_over6m_to_1y) {
		this.r51_over6m_to_1y = r51_over6m_to_1y;
	}
	public BigDecimal getR51_over1y_to_3y() {
		return r51_over1y_to_3y;
	}
	public void setR51_over1y_to_3y(BigDecimal r51_over1y_to_3y) {
		this.r51_over1y_to_3y = r51_over1y_to_3y;
	}
	public BigDecimal getR51_over3y_to_5y() {
		return r51_over3y_to_5y;
	}
	public void setR51_over3y_to_5y(BigDecimal r51_over3y_to_5y) {
		this.r51_over3y_to_5y = r51_over3y_to_5y;
	}
	public BigDecimal getR51_over5y_to_7y() {
		return r51_over5y_to_7y;
	}
	public void setR51_over5y_to_7y(BigDecimal r51_over5y_to_7y) {
		this.r51_over5y_to_7y = r51_over5y_to_7y;
	}
	public BigDecimal getR51_over7y_to_10y() {
		return r51_over7y_to_10y;
	}
	public void setR51_over7y_to_10y(BigDecimal r51_over7y_to_10y) {
		this.r51_over7y_to_10y = r51_over7y_to_10y;
	}
	public BigDecimal getR51_over10y_to_15y() {
		return r51_over10y_to_15y;
	}
	public void setR51_over10y_to_15y(BigDecimal r51_over10y_to_15y) {
		this.r51_over10y_to_15y = r51_over10y_to_15y;
	}
	public BigDecimal getR51_over15y() {
		return r51_over15y;
	}
	public void setR51_over15y(BigDecimal r51_over15y) {
		this.r51_over15y = r51_over15y;
	}
	public BigDecimal getR51_non_sensitive() {
		return r51_non_sensitive;
	}
	public void setR51_non_sensitive(BigDecimal r51_non_sensitive) {
		this.r51_non_sensitive = r51_non_sensitive;
	}
	public BigDecimal getR51_total_rsl() {
		return r51_total_rsl;
	}
	public void setR51_total_rsl(BigDecimal r51_total_rsl) {
		this.r51_total_rsl = r51_total_rsl;
	}
	public BigDecimal getR51_total() {
		return r51_total;
	}
	public void setR51_total(BigDecimal r51_total) {
		this.r51_total = r51_total;
	}
	public String getR52_product() {
		return r52_product;
	}
	public void setR52_product(String r52_product) {
		this.r52_product = r52_product;
	}
	public BigDecimal getR52_day1_28() {
		return r52_day1_28;
	}
	public void setR52_day1_28(BigDecimal r52_day1_28) {
		this.r52_day1_28 = r52_day1_28;
	}
	public BigDecimal getR52_day29_3m() {
		return r52_day29_3m;
	}
	public void setR52_day29_3m(BigDecimal r52_day29_3m) {
		this.r52_day29_3m = r52_day29_3m;
	}
	public BigDecimal getR52_over3m_to_6m() {
		return r52_over3m_to_6m;
	}
	public void setR52_over3m_to_6m(BigDecimal r52_over3m_to_6m) {
		this.r52_over3m_to_6m = r52_over3m_to_6m;
	}
	public BigDecimal getR52_over6m_to_1y() {
		return r52_over6m_to_1y;
	}
	public void setR52_over6m_to_1y(BigDecimal r52_over6m_to_1y) {
		this.r52_over6m_to_1y = r52_over6m_to_1y;
	}
	public BigDecimal getR52_over1y_to_3y() {
		return r52_over1y_to_3y;
	}
	public void setR52_over1y_to_3y(BigDecimal r52_over1y_to_3y) {
		this.r52_over1y_to_3y = r52_over1y_to_3y;
	}
	public BigDecimal getR52_over3y_to_5y() {
		return r52_over3y_to_5y;
	}
	public void setR52_over3y_to_5y(BigDecimal r52_over3y_to_5y) {
		this.r52_over3y_to_5y = r52_over3y_to_5y;
	}
	public BigDecimal getR52_over5y_to_7y() {
		return r52_over5y_to_7y;
	}
	public void setR52_over5y_to_7y(BigDecimal r52_over5y_to_7y) {
		this.r52_over5y_to_7y = r52_over5y_to_7y;
	}
	public BigDecimal getR52_over7y_to_10y() {
		return r52_over7y_to_10y;
	}
	public void setR52_over7y_to_10y(BigDecimal r52_over7y_to_10y) {
		this.r52_over7y_to_10y = r52_over7y_to_10y;
	}
	public BigDecimal getR52_over10y_to_15y() {
		return r52_over10y_to_15y;
	}
	public void setR52_over10y_to_15y(BigDecimal r52_over10y_to_15y) {
		this.r52_over10y_to_15y = r52_over10y_to_15y;
	}
	public BigDecimal getR52_over15y() {
		return r52_over15y;
	}
	public void setR52_over15y(BigDecimal r52_over15y) {
		this.r52_over15y = r52_over15y;
	}
	public BigDecimal getR52_non_sensitive() {
		return r52_non_sensitive;
	}
	public void setR52_non_sensitive(BigDecimal r52_non_sensitive) {
		this.r52_non_sensitive = r52_non_sensitive;
	}
	public BigDecimal getR52_total_rsl() {
		return r52_total_rsl;
	}
	public void setR52_total_rsl(BigDecimal r52_total_rsl) {
		this.r52_total_rsl = r52_total_rsl;
	}
	public BigDecimal getR52_total() {
		return r52_total;
	}
	public void setR52_total(BigDecimal r52_total) {
		this.r52_total = r52_total;
	}
	public String getR53_product() {
		return r53_product;
	}
	public void setR53_product(String r53_product) {
		this.r53_product = r53_product;
	}
	public BigDecimal getR53_day1_28() {
		return r53_day1_28;
	}
	public void setR53_day1_28(BigDecimal r53_day1_28) {
		this.r53_day1_28 = r53_day1_28;
	}
	public BigDecimal getR53_day29_3m() {
		return r53_day29_3m;
	}
	public void setR53_day29_3m(BigDecimal r53_day29_3m) {
		this.r53_day29_3m = r53_day29_3m;
	}
	public BigDecimal getR53_over3m_to_6m() {
		return r53_over3m_to_6m;
	}
	public void setR53_over3m_to_6m(BigDecimal r53_over3m_to_6m) {
		this.r53_over3m_to_6m = r53_over3m_to_6m;
	}
	public BigDecimal getR53_over6m_to_1y() {
		return r53_over6m_to_1y;
	}
	public void setR53_over6m_to_1y(BigDecimal r53_over6m_to_1y) {
		this.r53_over6m_to_1y = r53_over6m_to_1y;
	}
	public BigDecimal getR53_over1y_to_3y() {
		return r53_over1y_to_3y;
	}
	public void setR53_over1y_to_3y(BigDecimal r53_over1y_to_3y) {
		this.r53_over1y_to_3y = r53_over1y_to_3y;
	}
	public BigDecimal getR53_over3y_to_5y() {
		return r53_over3y_to_5y;
	}
	public void setR53_over3y_to_5y(BigDecimal r53_over3y_to_5y) {
		this.r53_over3y_to_5y = r53_over3y_to_5y;
	}
	public BigDecimal getR53_over5y_to_7y() {
		return r53_over5y_to_7y;
	}
	public void setR53_over5y_to_7y(BigDecimal r53_over5y_to_7y) {
		this.r53_over5y_to_7y = r53_over5y_to_7y;
	}
	public BigDecimal getR53_over7y_to_10y() {
		return r53_over7y_to_10y;
	}
	public void setR53_over7y_to_10y(BigDecimal r53_over7y_to_10y) {
		this.r53_over7y_to_10y = r53_over7y_to_10y;
	}
	public BigDecimal getR53_over10y_to_15y() {
		return r53_over10y_to_15y;
	}
	public void setR53_over10y_to_15y(BigDecimal r53_over10y_to_15y) {
		this.r53_over10y_to_15y = r53_over10y_to_15y;
	}
	public BigDecimal getR53_over15y() {
		return r53_over15y;
	}
	public void setR53_over15y(BigDecimal r53_over15y) {
		this.r53_over15y = r53_over15y;
	}
	public BigDecimal getR53_non_sensitive() {
		return r53_non_sensitive;
	}
	public void setR53_non_sensitive(BigDecimal r53_non_sensitive) {
		this.r53_non_sensitive = r53_non_sensitive;
	}
	public BigDecimal getR53_total_rsl() {
		return r53_total_rsl;
	}
	public void setR53_total_rsl(BigDecimal r53_total_rsl) {
		this.r53_total_rsl = r53_total_rsl;
	}
	public BigDecimal getR53_total() {
		return r53_total;
	}
	public void setR53_total(BigDecimal r53_total) {
		this.r53_total = r53_total;
	}
	public String getR54_product() {
		return r54_product;
	}
	public void setR54_product(String r54_product) {
		this.r54_product = r54_product;
	}
	public BigDecimal getR54_day1_28() {
		return r54_day1_28;
	}
	public void setR54_day1_28(BigDecimal r54_day1_28) {
		this.r54_day1_28 = r54_day1_28;
	}
	public BigDecimal getR54_day29_3m() {
		return r54_day29_3m;
	}
	public void setR54_day29_3m(BigDecimal r54_day29_3m) {
		this.r54_day29_3m = r54_day29_3m;
	}
	public BigDecimal getR54_over3m_to_6m() {
		return r54_over3m_to_6m;
	}
	public void setR54_over3m_to_6m(BigDecimal r54_over3m_to_6m) {
		this.r54_over3m_to_6m = r54_over3m_to_6m;
	}
	public BigDecimal getR54_over6m_to_1y() {
		return r54_over6m_to_1y;
	}
	public void setR54_over6m_to_1y(BigDecimal r54_over6m_to_1y) {
		this.r54_over6m_to_1y = r54_over6m_to_1y;
	}
	public BigDecimal getR54_over1y_to_3y() {
		return r54_over1y_to_3y;
	}
	public void setR54_over1y_to_3y(BigDecimal r54_over1y_to_3y) {
		this.r54_over1y_to_3y = r54_over1y_to_3y;
	}
	public BigDecimal getR54_over3y_to_5y() {
		return r54_over3y_to_5y;
	}
	public void setR54_over3y_to_5y(BigDecimal r54_over3y_to_5y) {
		this.r54_over3y_to_5y = r54_over3y_to_5y;
	}
	public BigDecimal getR54_over5y_to_7y() {
		return r54_over5y_to_7y;
	}
	public void setR54_over5y_to_7y(BigDecimal r54_over5y_to_7y) {
		this.r54_over5y_to_7y = r54_over5y_to_7y;
	}
	public BigDecimal getR54_over7y_to_10y() {
		return r54_over7y_to_10y;
	}
	public void setR54_over7y_to_10y(BigDecimal r54_over7y_to_10y) {
		this.r54_over7y_to_10y = r54_over7y_to_10y;
	}
	public BigDecimal getR54_over10y_to_15y() {
		return r54_over10y_to_15y;
	}
	public void setR54_over10y_to_15y(BigDecimal r54_over10y_to_15y) {
		this.r54_over10y_to_15y = r54_over10y_to_15y;
	}
	public BigDecimal getR54_over15y() {
		return r54_over15y;
	}
	public void setR54_over15y(BigDecimal r54_over15y) {
		this.r54_over15y = r54_over15y;
	}
	public BigDecimal getR54_non_sensitive() {
		return r54_non_sensitive;
	}
	public void setR54_non_sensitive(BigDecimal r54_non_sensitive) {
		this.r54_non_sensitive = r54_non_sensitive;
	}
	public BigDecimal getR54_total_rsl() {
		return r54_total_rsl;
	}
	public void setR54_total_rsl(BigDecimal r54_total_rsl) {
		this.r54_total_rsl = r54_total_rsl;
	}
	public BigDecimal getR54_total() {
		return r54_total;
	}
	public void setR54_total(BigDecimal r54_total) {
		this.r54_total = r54_total;
	}
	public String getR55_product() {
		return r55_product;
	}
	public void setR55_product(String r55_product) {
		this.r55_product = r55_product;
	}
	public BigDecimal getR55_day1_28() {
		return r55_day1_28;
	}
	public void setR55_day1_28(BigDecimal r55_day1_28) {
		this.r55_day1_28 = r55_day1_28;
	}
	public BigDecimal getR55_day29_3m() {
		return r55_day29_3m;
	}
	public void setR55_day29_3m(BigDecimal r55_day29_3m) {
		this.r55_day29_3m = r55_day29_3m;
	}
	public BigDecimal getR55_over3m_to_6m() {
		return r55_over3m_to_6m;
	}
	public void setR55_over3m_to_6m(BigDecimal r55_over3m_to_6m) {
		this.r55_over3m_to_6m = r55_over3m_to_6m;
	}
	public BigDecimal getR55_over6m_to_1y() {
		return r55_over6m_to_1y;
	}
	public void setR55_over6m_to_1y(BigDecimal r55_over6m_to_1y) {
		this.r55_over6m_to_1y = r55_over6m_to_1y;
	}
	public BigDecimal getR55_over1y_to_3y() {
		return r55_over1y_to_3y;
	}
	public void setR55_over1y_to_3y(BigDecimal r55_over1y_to_3y) {
		this.r55_over1y_to_3y = r55_over1y_to_3y;
	}
	public BigDecimal getR55_over3y_to_5y() {
		return r55_over3y_to_5y;
	}
	public void setR55_over3y_to_5y(BigDecimal r55_over3y_to_5y) {
		this.r55_over3y_to_5y = r55_over3y_to_5y;
	}
	public BigDecimal getR55_over5y_to_7y() {
		return r55_over5y_to_7y;
	}
	public void setR55_over5y_to_7y(BigDecimal r55_over5y_to_7y) {
		this.r55_over5y_to_7y = r55_over5y_to_7y;
	}
	public BigDecimal getR55_over7y_to_10y() {
		return r55_over7y_to_10y;
	}
	public void setR55_over7y_to_10y(BigDecimal r55_over7y_to_10y) {
		this.r55_over7y_to_10y = r55_over7y_to_10y;
	}
	public BigDecimal getR55_over10y_to_15y() {
		return r55_over10y_to_15y;
	}
	public void setR55_over10y_to_15y(BigDecimal r55_over10y_to_15y) {
		this.r55_over10y_to_15y = r55_over10y_to_15y;
	}
	public BigDecimal getR55_over15y() {
		return r55_over15y;
	}
	public void setR55_over15y(BigDecimal r55_over15y) {
		this.r55_over15y = r55_over15y;
	}
	public BigDecimal getR55_non_sensitive() {
		return r55_non_sensitive;
	}
	public void setR55_non_sensitive(BigDecimal r55_non_sensitive) {
		this.r55_non_sensitive = r55_non_sensitive;
	}
	public BigDecimal getR55_total_rsl() {
		return r55_total_rsl;
	}
	public void setR55_total_rsl(BigDecimal r55_total_rsl) {
		this.r55_total_rsl = r55_total_rsl;
	}
	public BigDecimal getR55_total() {
		return r55_total;
	}
	public void setR55_total(BigDecimal r55_total) {
		this.r55_total = r55_total;
	}
	public String getR56_product() {
		return r56_product;
	}
	public void setR56_product(String r56_product) {
		this.r56_product = r56_product;
	}
	public BigDecimal getR56_day1_28() {
		return r56_day1_28;
	}
	public void setR56_day1_28(BigDecimal r56_day1_28) {
		this.r56_day1_28 = r56_day1_28;
	}
	public BigDecimal getR56_day29_3m() {
		return r56_day29_3m;
	}
	public void setR56_day29_3m(BigDecimal r56_day29_3m) {
		this.r56_day29_3m = r56_day29_3m;
	}
	public BigDecimal getR56_over3m_to_6m() {
		return r56_over3m_to_6m;
	}
	public void setR56_over3m_to_6m(BigDecimal r56_over3m_to_6m) {
		this.r56_over3m_to_6m = r56_over3m_to_6m;
	}
	public BigDecimal getR56_over6m_to_1y() {
		return r56_over6m_to_1y;
	}
	public void setR56_over6m_to_1y(BigDecimal r56_over6m_to_1y) {
		this.r56_over6m_to_1y = r56_over6m_to_1y;
	}
	public BigDecimal getR56_over1y_to_3y() {
		return r56_over1y_to_3y;
	}
	public void setR56_over1y_to_3y(BigDecimal r56_over1y_to_3y) {
		this.r56_over1y_to_3y = r56_over1y_to_3y;
	}
	public BigDecimal getR56_over3y_to_5y() {
		return r56_over3y_to_5y;
	}
	public void setR56_over3y_to_5y(BigDecimal r56_over3y_to_5y) {
		this.r56_over3y_to_5y = r56_over3y_to_5y;
	}
	public BigDecimal getR56_over5y_to_7y() {
		return r56_over5y_to_7y;
	}
	public void setR56_over5y_to_7y(BigDecimal r56_over5y_to_7y) {
		this.r56_over5y_to_7y = r56_over5y_to_7y;
	}
	public BigDecimal getR56_over7y_to_10y() {
		return r56_over7y_to_10y;
	}
	public void setR56_over7y_to_10y(BigDecimal r56_over7y_to_10y) {
		this.r56_over7y_to_10y = r56_over7y_to_10y;
	}
	public BigDecimal getR56_over10y_to_15y() {
		return r56_over10y_to_15y;
	}
	public void setR56_over10y_to_15y(BigDecimal r56_over10y_to_15y) {
		this.r56_over10y_to_15y = r56_over10y_to_15y;
	}
	public BigDecimal getR56_over15y() {
		return r56_over15y;
	}
	public void setR56_over15y(BigDecimal r56_over15y) {
		this.r56_over15y = r56_over15y;
	}
	public BigDecimal getR56_non_sensitive() {
		return r56_non_sensitive;
	}
	public void setR56_non_sensitive(BigDecimal r56_non_sensitive) {
		this.r56_non_sensitive = r56_non_sensitive;
	}
	public BigDecimal getR56_total_rsl() {
		return r56_total_rsl;
	}
	public void setR56_total_rsl(BigDecimal r56_total_rsl) {
		this.r56_total_rsl = r56_total_rsl;
	}
	public BigDecimal getR56_total() {
		return r56_total;
	}
	public void setR56_total(BigDecimal r56_total) {
		this.r56_total = r56_total;
	}
	public String getR57_product() {
		return r57_product;
	}
	public void setR57_product(String r57_product) {
		this.r57_product = r57_product;
	}
	public BigDecimal getR57_day1_28() {
		return r57_day1_28;
	}
	public void setR57_day1_28(BigDecimal r57_day1_28) {
		this.r57_day1_28 = r57_day1_28;
	}
	public BigDecimal getR57_day29_3m() {
		return r57_day29_3m;
	}
	public void setR57_day29_3m(BigDecimal r57_day29_3m) {
		this.r57_day29_3m = r57_day29_3m;
	}
	public BigDecimal getR57_over3m_to_6m() {
		return r57_over3m_to_6m;
	}
	public void setR57_over3m_to_6m(BigDecimal r57_over3m_to_6m) {
		this.r57_over3m_to_6m = r57_over3m_to_6m;
	}
	public BigDecimal getR57_over6m_to_1y() {
		return r57_over6m_to_1y;
	}
	public void setR57_over6m_to_1y(BigDecimal r57_over6m_to_1y) {
		this.r57_over6m_to_1y = r57_over6m_to_1y;
	}
	public BigDecimal getR57_over1y_to_3y() {
		return r57_over1y_to_3y;
	}
	public void setR57_over1y_to_3y(BigDecimal r57_over1y_to_3y) {
		this.r57_over1y_to_3y = r57_over1y_to_3y;
	}
	public BigDecimal getR57_over3y_to_5y() {
		return r57_over3y_to_5y;
	}
	public void setR57_over3y_to_5y(BigDecimal r57_over3y_to_5y) {
		this.r57_over3y_to_5y = r57_over3y_to_5y;
	}
	public BigDecimal getR57_over5y_to_7y() {
		return r57_over5y_to_7y;
	}
	public void setR57_over5y_to_7y(BigDecimal r57_over5y_to_7y) {
		this.r57_over5y_to_7y = r57_over5y_to_7y;
	}
	public BigDecimal getR57_over7y_to_10y() {
		return r57_over7y_to_10y;
	}
	public void setR57_over7y_to_10y(BigDecimal r57_over7y_to_10y) {
		this.r57_over7y_to_10y = r57_over7y_to_10y;
	}
	public BigDecimal getR57_over10y_to_15y() {
		return r57_over10y_to_15y;
	}
	public void setR57_over10y_to_15y(BigDecimal r57_over10y_to_15y) {
		this.r57_over10y_to_15y = r57_over10y_to_15y;
	}
	public BigDecimal getR57_over15y() {
		return r57_over15y;
	}
	public void setR57_over15y(BigDecimal r57_over15y) {
		this.r57_over15y = r57_over15y;
	}
	public BigDecimal getR57_non_sensitive() {
		return r57_non_sensitive;
	}
	public void setR57_non_sensitive(BigDecimal r57_non_sensitive) {
		this.r57_non_sensitive = r57_non_sensitive;
	}
	public BigDecimal getR57_total_rsl() {
		return r57_total_rsl;
	}
	public void setR57_total_rsl(BigDecimal r57_total_rsl) {
		this.r57_total_rsl = r57_total_rsl;
	}
	public BigDecimal getR57_total() {
		return r57_total;
	}
	public void setR57_total(BigDecimal r57_total) {
		this.r57_total = r57_total;
	}
	public String getR58_product() {
		return r58_product;
	}
	public void setR58_product(String r58_product) {
		this.r58_product = r58_product;
	}
	public BigDecimal getR58_day1_28() {
		return r58_day1_28;
	}
	public void setR58_day1_28(BigDecimal r58_day1_28) {
		this.r58_day1_28 = r58_day1_28;
	}
	public BigDecimal getR58_day29_3m() {
		return r58_day29_3m;
	}
	public void setR58_day29_3m(BigDecimal r58_day29_3m) {
		this.r58_day29_3m = r58_day29_3m;
	}
	public BigDecimal getR58_over3m_to_6m() {
		return r58_over3m_to_6m;
	}
	public void setR58_over3m_to_6m(BigDecimal r58_over3m_to_6m) {
		this.r58_over3m_to_6m = r58_over3m_to_6m;
	}
	public BigDecimal getR58_over6m_to_1y() {
		return r58_over6m_to_1y;
	}
	public void setR58_over6m_to_1y(BigDecimal r58_over6m_to_1y) {
		this.r58_over6m_to_1y = r58_over6m_to_1y;
	}
	public BigDecimal getR58_over1y_to_3y() {
		return r58_over1y_to_3y;
	}
	public void setR58_over1y_to_3y(BigDecimal r58_over1y_to_3y) {
		this.r58_over1y_to_3y = r58_over1y_to_3y;
	}
	public BigDecimal getR58_over3y_to_5y() {
		return r58_over3y_to_5y;
	}
	public void setR58_over3y_to_5y(BigDecimal r58_over3y_to_5y) {
		this.r58_over3y_to_5y = r58_over3y_to_5y;
	}
	public BigDecimal getR58_over5y_to_7y() {
		return r58_over5y_to_7y;
	}
	public void setR58_over5y_to_7y(BigDecimal r58_over5y_to_7y) {
		this.r58_over5y_to_7y = r58_over5y_to_7y;
	}
	public BigDecimal getR58_over7y_to_10y() {
		return r58_over7y_to_10y;
	}
	public void setR58_over7y_to_10y(BigDecimal r58_over7y_to_10y) {
		this.r58_over7y_to_10y = r58_over7y_to_10y;
	}
	public BigDecimal getR58_over10y_to_15y() {
		return r58_over10y_to_15y;
	}
	public void setR58_over10y_to_15y(BigDecimal r58_over10y_to_15y) {
		this.r58_over10y_to_15y = r58_over10y_to_15y;
	}
	public BigDecimal getR58_over15y() {
		return r58_over15y;
	}
	public void setR58_over15y(BigDecimal r58_over15y) {
		this.r58_over15y = r58_over15y;
	}
	public BigDecimal getR58_non_sensitive() {
		return r58_non_sensitive;
	}
	public void setR58_non_sensitive(BigDecimal r58_non_sensitive) {
		this.r58_non_sensitive = r58_non_sensitive;
	}
	public BigDecimal getR58_total_rsl() {
		return r58_total_rsl;
	}
	public void setR58_total_rsl(BigDecimal r58_total_rsl) {
		this.r58_total_rsl = r58_total_rsl;
	}
	public BigDecimal getR58_total() {
		return r58_total;
	}
	public void setR58_total(BigDecimal r58_total) {
		this.r58_total = r58_total;
	}
	public String getR59_product() {
		return r59_product;
	}
	public void setR59_product(String r59_product) {
		this.r59_product = r59_product;
	}
	public BigDecimal getR59_day1_28() {
		return r59_day1_28;
	}
	public void setR59_day1_28(BigDecimal r59_day1_28) {
		this.r59_day1_28 = r59_day1_28;
	}
	public BigDecimal getR59_day29_3m() {
		return r59_day29_3m;
	}
	public void setR59_day29_3m(BigDecimal r59_day29_3m) {
		this.r59_day29_3m = r59_day29_3m;
	}
	public BigDecimal getR59_over3m_to_6m() {
		return r59_over3m_to_6m;
	}
	public void setR59_over3m_to_6m(BigDecimal r59_over3m_to_6m) {
		this.r59_over3m_to_6m = r59_over3m_to_6m;
	}
	public BigDecimal getR59_over6m_to_1y() {
		return r59_over6m_to_1y;
	}
	public void setR59_over6m_to_1y(BigDecimal r59_over6m_to_1y) {
		this.r59_over6m_to_1y = r59_over6m_to_1y;
	}
	public BigDecimal getR59_over1y_to_3y() {
		return r59_over1y_to_3y;
	}
	public void setR59_over1y_to_3y(BigDecimal r59_over1y_to_3y) {
		this.r59_over1y_to_3y = r59_over1y_to_3y;
	}
	public BigDecimal getR59_over3y_to_5y() {
		return r59_over3y_to_5y;
	}
	public void setR59_over3y_to_5y(BigDecimal r59_over3y_to_5y) {
		this.r59_over3y_to_5y = r59_over3y_to_5y;
	}
	public BigDecimal getR59_over5y_to_7y() {
		return r59_over5y_to_7y;
	}
	public void setR59_over5y_to_7y(BigDecimal r59_over5y_to_7y) {
		this.r59_over5y_to_7y = r59_over5y_to_7y;
	}
	public BigDecimal getR59_over7y_to_10y() {
		return r59_over7y_to_10y;
	}
	public void setR59_over7y_to_10y(BigDecimal r59_over7y_to_10y) {
		this.r59_over7y_to_10y = r59_over7y_to_10y;
	}
	public BigDecimal getR59_over10y_to_15y() {
		return r59_over10y_to_15y;
	}
	public void setR59_over10y_to_15y(BigDecimal r59_over10y_to_15y) {
		this.r59_over10y_to_15y = r59_over10y_to_15y;
	}
	public BigDecimal getR59_over15y() {
		return r59_over15y;
	}
	public void setR59_over15y(BigDecimal r59_over15y) {
		this.r59_over15y = r59_over15y;
	}
	public BigDecimal getR59_non_sensitive() {
		return r59_non_sensitive;
	}
	public void setR59_non_sensitive(BigDecimal r59_non_sensitive) {
		this.r59_non_sensitive = r59_non_sensitive;
	}
	public BigDecimal getR59_total_rsl() {
		return r59_total_rsl;
	}
	public void setR59_total_rsl(BigDecimal r59_total_rsl) {
		this.r59_total_rsl = r59_total_rsl;
	}
	public BigDecimal getR59_total() {
		return r59_total;
	}
	public void setR59_total(BigDecimal r59_total) {
		this.r59_total = r59_total;
	}
	public String getR60_product() {
		return r60_product;
	}
	public void setR60_product(String r60_product) {
		this.r60_product = r60_product;
	}
	public BigDecimal getR60_day1_28() {
		return r60_day1_28;
	}
	public void setR60_day1_28(BigDecimal r60_day1_28) {
		this.r60_day1_28 = r60_day1_28;
	}
	public BigDecimal getR60_day29_3m() {
		return r60_day29_3m;
	}
	public void setR60_day29_3m(BigDecimal r60_day29_3m) {
		this.r60_day29_3m = r60_day29_3m;
	}
	public BigDecimal getR60_over3m_to_6m() {
		return r60_over3m_to_6m;
	}
	public void setR60_over3m_to_6m(BigDecimal r60_over3m_to_6m) {
		this.r60_over3m_to_6m = r60_over3m_to_6m;
	}
	public BigDecimal getR60_over6m_to_1y() {
		return r60_over6m_to_1y;
	}
	public void setR60_over6m_to_1y(BigDecimal r60_over6m_to_1y) {
		this.r60_over6m_to_1y = r60_over6m_to_1y;
	}
	public BigDecimal getR60_over1y_to_3y() {
		return r60_over1y_to_3y;
	}
	public void setR60_over1y_to_3y(BigDecimal r60_over1y_to_3y) {
		this.r60_over1y_to_3y = r60_over1y_to_3y;
	}
	public BigDecimal getR60_over3y_to_5y() {
		return r60_over3y_to_5y;
	}
	public void setR60_over3y_to_5y(BigDecimal r60_over3y_to_5y) {
		this.r60_over3y_to_5y = r60_over3y_to_5y;
	}
	public BigDecimal getR60_over5y_to_7y() {
		return r60_over5y_to_7y;
	}
	public void setR60_over5y_to_7y(BigDecimal r60_over5y_to_7y) {
		this.r60_over5y_to_7y = r60_over5y_to_7y;
	}
	public BigDecimal getR60_over7y_to_10y() {
		return r60_over7y_to_10y;
	}
	public void setR60_over7y_to_10y(BigDecimal r60_over7y_to_10y) {
		this.r60_over7y_to_10y = r60_over7y_to_10y;
	}
	public BigDecimal getR60_over10y_to_15y() {
		return r60_over10y_to_15y;
	}
	public void setR60_over10y_to_15y(BigDecimal r60_over10y_to_15y) {
		this.r60_over10y_to_15y = r60_over10y_to_15y;
	}
	public BigDecimal getR60_over15y() {
		return r60_over15y;
	}
	public void setR60_over15y(BigDecimal r60_over15y) {
		this.r60_over15y = r60_over15y;
	}
	public BigDecimal getR60_non_sensitive() {
		return r60_non_sensitive;
	}
	public void setR60_non_sensitive(BigDecimal r60_non_sensitive) {
		this.r60_non_sensitive = r60_non_sensitive;
	}
	public BigDecimal getR60_total_rsl() {
		return r60_total_rsl;
	}
	public void setR60_total_rsl(BigDecimal r60_total_rsl) {
		this.r60_total_rsl = r60_total_rsl;
	}
	public BigDecimal getR60_total() {
		return r60_total;
	}
	public void setR60_total(BigDecimal r60_total) {
		this.r60_total = r60_total;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getReport_version() {
		return report_version;
	}
	public void setReport_version(String report_version) {
		this.report_version = report_version;
	}
	public String getReport_currency() {
		return report_currency;
	}
	public void setReport_currency(String report_currency) {
		this.report_currency = report_currency;
	}
	public String getReport_code() {
		return report_code;
	}
	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}
	public String getReport_desc() {
		return report_desc;
	}
	public void setReport_desc(String report_desc) {
		this.report_desc = report_desc;
	}
	public String getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	public String getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public RT_IRS_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
