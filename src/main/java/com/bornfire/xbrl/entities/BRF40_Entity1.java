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
@Table(name="BRF40A_SUMMARYTABLE")
public class BRF40_Entity1 {
	private String	r10_asset_classes;
	private BigDecimal	r10_outstanding_balance;
	private BigDecimal	r10_provision_suspense;
	private BigDecimal	r10_stage3_provision;
	private BigDecimal	r10_other_alloate;
	private BigDecimal	r10_1_asset;
	private BigDecimal	r10_2_asset;
	private BigDecimal	r10_3a_asset;
	private BigDecimal	r10_3b_asset;
	private BigDecimal	r10_3c_asset;
	private BigDecimal	r10_1_provision;
	private BigDecimal	r10_2_provision;
	private BigDecimal	r10_3a_provision;
	private BigDecimal	r10_3b_provision;
	private BigDecimal	r10_3c_provision;
	private BigDecimal	r10_current;
	private BigDecimal	r10_lessthan_30;
	private BigDecimal	r10_exclusive_90days;
	private BigDecimal	r10_exclusive_120days;
	private BigDecimal	r10_exclusive_180days;
	private BigDecimal	r10_exclusive_over_180days;
	private BigDecimal	r10_total_past;
	private BigDecimal	r10_new_stage3;
	private BigDecimal	r10_new_specific;
	private BigDecimal	r10_new_other;
	private BigDecimal	r10_performing_accounts;
	private BigDecimal	r10_non_performing_accounts;
	private String	r10_outstanding_check;
	private String	r10_provision_check;
	private String	r10_past_due_date;
	private String	r11_asset_classes;
	private BigDecimal	r11_outstanding_balance;
	private BigDecimal	r11_provision_suspense;
	private BigDecimal	r11_stage3_provision;
	private BigDecimal	r11_other_alloate;
	private BigDecimal	r11_1_asset;
	private BigDecimal	r11_2_asset;
	private BigDecimal	r11_3a_asset;
	private BigDecimal	r11_3b_asset;
	private BigDecimal	r11_3c_asset;
	private BigDecimal	r11_1_provision;
	private BigDecimal	r11_2_provision;
	private BigDecimal	r11_3a_provision;
	private BigDecimal	r11_3b_provision;
	private BigDecimal	r11_3c_provision;
	private BigDecimal	r11_current;
	private BigDecimal	r11_lessthan_30;
	private BigDecimal	r11_exclusive_90days;
	private BigDecimal	r11_exclusive_120days;
	private BigDecimal	r11_exclusive_180days;
	private BigDecimal	r11_exclusive_over_180days;
	private BigDecimal	r11_total_past;
	private BigDecimal	r11_new_stage3;
	private BigDecimal	r11_new_specific;
	private BigDecimal	r11_new_other;
	private BigDecimal	r11_performing_accounts;
	private BigDecimal	r11_non_performing_accounts;
	private String	r11_outstanding_check;
	private String	r11_provision_check;
	private String	r11_past_due_date;
	private String	r12_asset_classes;
	private BigDecimal	r12_outstanding_balance;
	private BigDecimal	r12_provision_suspense;
	private BigDecimal	r12_stage3_provision;
	private BigDecimal	r12_other_alloate;
	private BigDecimal	r12_1_asset;
	private BigDecimal	r12_2_asset;
	private BigDecimal	r12_3a_asset;
	private BigDecimal	r12_3b_asset;
	private BigDecimal	r12_3c_asset;
	private BigDecimal	r12_1_provision;
	private BigDecimal	r12_2_provision;
	private BigDecimal	r12_3a_provision;
	private BigDecimal	r12_3b_provision;
	private BigDecimal	r12_3c_provision;
	private BigDecimal	r12_current;
	private BigDecimal	r12_lessthan_30;
	private BigDecimal	r12_exclusive_90days;
	private BigDecimal	r12_exclusive_120days;
	private BigDecimal	r12_exclusive_180days;
	private BigDecimal	r12_exclusive_over_180days;
	private BigDecimal	r12_total_past;
	private BigDecimal	r12_new_stage3;
	private BigDecimal	r12_new_specific;
	private BigDecimal	r12_new_other;
	private BigDecimal	r12_performing_accounts;
	private BigDecimal	r12_non_performing_accounts;
	private String	r12_outstanding_check;
	private String	r12_provision_check;
	private String	r12_past_due_date;
	private String	r13_asset_classes;
	private BigDecimal	r13_outstanding_balance;
	private BigDecimal	r13_provision_suspense;
	private BigDecimal	r13_stage3_provision;
	private BigDecimal	r13_other_alloate;
	private BigDecimal	r13_1_asset;
	private BigDecimal	r13_2_asset;
	private BigDecimal	r13_3a_asset;
	private BigDecimal	r13_3b_asset;
	private BigDecimal	r13_3c_asset;
	private BigDecimal	r13_1_provision;
	private BigDecimal	r13_2_provision;
	private BigDecimal	r13_3a_provision;
	private BigDecimal	r13_3b_provision;
	private BigDecimal	r13_3c_provision;
	private BigDecimal	r13_current;
	private BigDecimal	r13_lessthan_30;
	private BigDecimal	r13_exclusive_90days;
	private BigDecimal	r13_exclusive_120days;
	private BigDecimal	r13_exclusive_180days;
	private BigDecimal	r13_exclusive_over_180days;
	private BigDecimal	r13_total_past;
	private BigDecimal	r13_new_stage3;
	private BigDecimal	r13_new_specific;
	private BigDecimal	r13_new_other;
	private BigDecimal	r13_performing_accounts;
	private BigDecimal	r13_non_performing_accounts;
	private String	r13_outstanding_check;
	private String	r13_provision_check;
	private String	r13_past_due_date;
	private String	r14_asset_classes;
	private BigDecimal	r14_outstanding_balance;
	private BigDecimal	r14_provision_suspense;
	private BigDecimal	r14_stage3_provision;
	private BigDecimal	r14_other_alloate;
	private BigDecimal	r14_1_asset;
	private BigDecimal	r14_2_asset;
	private BigDecimal	r14_3a_asset;
	private BigDecimal	r14_3b_asset;
	private BigDecimal	r14_3c_asset;
	private BigDecimal	r14_1_provision;
	private BigDecimal	r14_2_provision;
	private BigDecimal	r14_3a_provision;
	private BigDecimal	r14_3b_provision;
	private BigDecimal	r14_3c_provision;
	private BigDecimal	r14_current;
	private BigDecimal	r14_lessthan_30;
	private BigDecimal	r14_exclusive_90days;
	private BigDecimal	r14_exclusive_120days;
	private BigDecimal	r14_exclusive_180days;
	private BigDecimal	r14_exclusive_over_180days;
	private BigDecimal	r14_total_past;
	private BigDecimal	r14_new_stage3;
	private BigDecimal	r14_new_specific;
	private BigDecimal	r14_new_other;
	private BigDecimal	r14_performing_accounts;
	private BigDecimal	r14_non_performing_accounts;
	private String	r14_outstanding_check;
	private String	r14_provision_check;
	private String	r14_past_due_date;
	private String	r15_asset_classes;
	private BigDecimal	r15_outstanding_balance;
	private BigDecimal	r15_provision_suspense;
	private BigDecimal	r15_stage3_provision;
	private BigDecimal	r15_other_alloate;
	private BigDecimal	r15_1_asset;
	private BigDecimal	r15_2_asset;
	private BigDecimal	r15_3a_asset;
	private BigDecimal	r15_3b_asset;
	private BigDecimal	r15_3c_asset;
	private BigDecimal	r15_1_provision;
	private BigDecimal	r15_2_provision;
	private BigDecimal	r15_3a_provision;
	private BigDecimal	r15_3b_provision;
	private BigDecimal	r15_3c_provision;
	private BigDecimal	r15_current;
	private BigDecimal	r15_lessthan_30;
	private BigDecimal	r15_exclusive_90days;
	private BigDecimal	r15_exclusive_120days;
	private BigDecimal	r15_exclusive_180days;
	private BigDecimal	r15_exclusive_over_180days;
	private BigDecimal	r15_total_past;
	private BigDecimal	r15_new_stage3;
	private BigDecimal	r15_new_specific;
	private BigDecimal	r15_new_other;
	private BigDecimal	r15_performing_accounts;
	private BigDecimal	r15_non_performing_accounts;
	private String	r15_outstanding_check;
	private String	r15_provision_check;
	private String	r15_past_due_date;
	private String	r16_asset_classes;
	private BigDecimal	r16_outstanding_balance;
	private BigDecimal	r16_provision_suspense;
	private BigDecimal	r16_stage3_provision;
	private BigDecimal	r16_other_alloate;
	private BigDecimal	r16_1_asset;
	private BigDecimal	r16_2_asset;
	private BigDecimal	r16_3a_asset;
	private BigDecimal	r16_3b_asset;
	private BigDecimal	r16_3c_asset;
	private BigDecimal	r16_1_provision;
	private BigDecimal	r16_2_provision;
	private BigDecimal	r16_3a_provision;
	private BigDecimal	r16_3b_provision;
	private BigDecimal	r16_3c_provision;
	private BigDecimal	r16_current;
	private BigDecimal	r16_lessthan_30;
	private BigDecimal	r16_exclusive_90days;
	private BigDecimal	r16_exclusive_120days;
	private BigDecimal	r16_exclusive_180days;
	private BigDecimal	r16_exclusive_over_180days;
	private BigDecimal	r16_total_past;
	private BigDecimal	r16_new_stage3;
	private BigDecimal	r16_new_specific;
	private BigDecimal	r16_new_other;
	private BigDecimal	r16_performing_accounts;
	private BigDecimal	r16_non_performing_accounts;
	private String	r16_outstanding_check;
	private String	r16_provision_check;
	private String	r16_past_due_date;
	private String	r17_asset_classes;
	private BigDecimal	r17_outstanding_balance;
	private BigDecimal	r17_provision_suspense;
	private BigDecimal	r17_stage3_provision;
	private BigDecimal	r17_other_alloate;
	private BigDecimal	r17_1_asset;
	private BigDecimal	r17_2_asset;
	private BigDecimal	r17_3a_asset;
	private BigDecimal	r17_3b_asset;
	private BigDecimal	r17_3c_asset;
	private BigDecimal	r17_1_provision;
	private BigDecimal	r17_2_provision;
	private BigDecimal	r17_3a_provision;
	private BigDecimal	r17_3b_provision;
	private BigDecimal	r17_3c_provision;
	private BigDecimal	r17_current;
	private BigDecimal	r17_lessthan_30;
	private BigDecimal	r17_exclusive_90days;
	private BigDecimal	r17_exclusive_120days;
	private BigDecimal	r17_exclusive_180days;
	private BigDecimal	r17_exclusive_over_180days;
	private BigDecimal	r17_total_past;
	private BigDecimal	r17_new_stage3;
	private BigDecimal	r17_new_specific;
	private BigDecimal	r17_new_other;
	private BigDecimal	r17_performing_accounts;
	private BigDecimal	r17_non_performing_accounts;
	private String	r17_outstanding_check;
	private String	r17_provision_check;
	private String	r17_past_due_date;
	private String	r18_asset_classes;
	private BigDecimal	r18_outstanding_balance;
	private BigDecimal	r18_provision_suspense;
	private BigDecimal	r18_stage3_provision;
	private BigDecimal	r18_other_alloate;
	private BigDecimal	r18_1_asset;
	private BigDecimal	r18_2_asset;
	private BigDecimal	r18_3a_asset;
	private BigDecimal	r18_3b_asset;
	private BigDecimal	r18_3c_asset;
	private BigDecimal	r18_1_provision;
	private BigDecimal	r18_2_provision;
	private BigDecimal	r18_3a_provision;
	private BigDecimal	r18_3b_provision;
	private BigDecimal	r18_3c_provision;
	private BigDecimal	r18_current;
	private BigDecimal	r18_lessthan_30;
	private BigDecimal	r18_exclusive_90days;
	private BigDecimal	r18_exclusive_120days;
	private BigDecimal	r18_exclusive_180days;
	private BigDecimal	r18_exclusive_over_180days;
	private BigDecimal	r18_total_past;
	private BigDecimal	r18_new_stage3;
	private BigDecimal	r18_new_specific;
	private BigDecimal	r18_new_other;
	private BigDecimal	r18_performing_accounts;
	private BigDecimal	r18_non_performing_accounts;
	private String	r18_outstanding_check;
	private String	r18_provision_check;
	private String	r18_past_due_date;
	private String	r19_asset_classes;
	private BigDecimal	r19_outstanding_balance;
	private BigDecimal	r19_provision_suspense;
	private BigDecimal	r19_stage3_provision;
	private BigDecimal	r19_other_alloate;
	private BigDecimal	r19_1_asset;
	private BigDecimal	r19_2_asset;
	private BigDecimal	r19_3a_asset;
	private BigDecimal	r19_3b_asset;
	private BigDecimal	r19_3c_asset;
	private BigDecimal	r19_1_provision;
	private BigDecimal	r19_2_provision;
	private BigDecimal	r19_3a_provision;
	private BigDecimal	r19_3b_provision;
	private BigDecimal	r19_3c_provision;
	private BigDecimal	r19_current;
	private BigDecimal	r19_lessthan_30;
	private BigDecimal	r19_exclusive_90days;
	private BigDecimal	r19_exclusive_120days;
	private BigDecimal	r19_exclusive_180days;
	private BigDecimal	r19_exclusive_over_180days;
	private BigDecimal	r19_total_past;
	private BigDecimal	r19_new_stage3;
	private BigDecimal	r19_new_specific;
	private BigDecimal	r19_new_other;
	private BigDecimal	r19_performing_accounts;
	private BigDecimal	r19_non_performing_accounts;
	private String	r19_outstanding_check;
	private String	r19_provision_check;
	private String	r19_past_due_date;
	private String	r20_asset_classes;
	private BigDecimal	r20_outstanding_balance;
	private BigDecimal	r20_provision_suspense;
	private BigDecimal	r20_stage3_provision;
	private BigDecimal	r20_other_alloate;
	private BigDecimal	r20_1_asset;
	private BigDecimal	r20_2_asset;
	private BigDecimal	r20_3a_asset;
	private BigDecimal	r20_3b_asset;
	private BigDecimal	r20_3c_asset;
	private BigDecimal	r20_1_provision;
	private BigDecimal	r20_2_provision;
	private BigDecimal	r20_3a_provision;
	private BigDecimal	r20_3b_provision;
	private BigDecimal	r20_3c_provision;
	private BigDecimal	r20_current;
	private BigDecimal	r20_lessthan_30;
	private BigDecimal	r20_exclusive_90days;
	private BigDecimal	r20_exclusive_120days;
	private BigDecimal	r20_exclusive_180days;
	private BigDecimal	r20_exclusive_over_180days;
	private BigDecimal	r20_total_past;
	private BigDecimal	r20_new_stage3;
	private BigDecimal	r20_new_specific;
	private BigDecimal	r20_new_other;
	private BigDecimal	r20_performing_accounts;
	private BigDecimal	r20_non_performing_accounts;
	private String	r20_outstanding_check;
	private String	r20_provision_check;
	private String	r20_past_due_date;
	private String	r21_asset_classes;
	private BigDecimal	r21_outstanding_balance;
	private BigDecimal	r21_provision_suspense;
	private BigDecimal	r21_stage3_provision;
	private BigDecimal	r21_other_alloate;
	private BigDecimal	r21_1_asset;
	private BigDecimal	r21_2_asset;
	private BigDecimal	r21_3a_asset;
	private BigDecimal	r21_3b_asset;
	private BigDecimal	r21_3c_asset;
	private BigDecimal	r21_1_provision;
	private BigDecimal	r21_2_provision;
	private BigDecimal	r21_3a_provision;
	private BigDecimal	r21_3b_provision;
	private BigDecimal	r21_3c_provision;
	private BigDecimal	r21_current;
	private BigDecimal	r21_lessthan_30;
	private BigDecimal	r21_exclusive_90days;
	private BigDecimal	r21_exclusive_120days;
	private BigDecimal	r21_exclusive_180days;
	private BigDecimal	r21_exclusive_over_180days;
	private BigDecimal	r21_total_past;
	private BigDecimal	r21_new_stage3;
	private BigDecimal	r21_new_specific;
	private BigDecimal	r21_new_other;
	private BigDecimal	r21_performing_accounts;
	private BigDecimal	r21_non_performing_accounts;
	private String	r21_outstanding_check;
	private String	r21_provision_check;
	private String	r21_past_due_date;
	private String	r22_asset_classes;
	private BigDecimal	r22_outstanding_balance;
	private BigDecimal	r22_provision_suspense;
	private BigDecimal	r22_stage3_provision;
	private BigDecimal	r22_other_alloate;
	private BigDecimal	r22_1_asset;
	private BigDecimal	r22_2_asset;
	private BigDecimal	r22_3a_asset;
	private BigDecimal	r22_3b_asset;
	private BigDecimal	r22_3c_asset;
	private BigDecimal	r22_1_provision;
	private BigDecimal	r22_2_provision;
	private BigDecimal	r22_3a_provision;
	private BigDecimal	r22_3b_provision;
	private BigDecimal	r22_3c_provision;
	private BigDecimal	r22_current;
	private BigDecimal	r22_lessthan_30;
	private BigDecimal	r22_exclusive_90days;
	private BigDecimal	r22_exclusive_120days;
	private BigDecimal	r22_exclusive_180days;
	private BigDecimal	r22_exclusive_over_180days;
	private BigDecimal	r22_total_past;
	private BigDecimal	r22_new_stage3;
	private BigDecimal	r22_new_specific;
	private BigDecimal	r22_new_other;
	private BigDecimal	r22_performing_accounts;
	private BigDecimal	r22_non_performing_accounts;
	private String	r22_outstanding_check;
	private String	r22_provision_check;
	private String	r22_past_due_date;
	private String	r23_asset_classes;
	private BigDecimal	r23_outstanding_balance;
	private BigDecimal	r23_provision_suspense;
	private BigDecimal	r23_stage3_provision;
	private BigDecimal	r23_other_alloate;
	private BigDecimal	r23_1_asset;
	private BigDecimal	r23_2_asset;
	private BigDecimal	r23_3a_asset;
	private BigDecimal	r23_3b_asset;
	private BigDecimal	r23_3c_asset;
	private BigDecimal	r23_1_provision;
	private BigDecimal	r23_2_provision;
	private BigDecimal	r23_3a_provision;
	private BigDecimal	r23_3b_provision;
	private BigDecimal	r23_3c_provision;
	private BigDecimal	r23_current;
	private BigDecimal	r23_lessthan_30;
	private BigDecimal	r23_exclusive_90days;
	private BigDecimal	r23_exclusive_120days;
	private BigDecimal	r23_exclusive_180days;
	private BigDecimal	r23_exclusive_over_180days;
	private BigDecimal	r23_total_past;
	private BigDecimal	r23_new_stage3;
	private BigDecimal	r23_new_specific;
	private BigDecimal	r23_new_other;
	private BigDecimal	r23_performing_accounts;
	private BigDecimal	r23_non_performing_accounts;
	private String	r23_outstanding_check;
	private String	r23_provision_check;
	private String	r23_past_due_date;
	private String	r24_asset_classes;
	private BigDecimal	r24_outstanding_balance;
	private BigDecimal	r24_provision_suspense;
	private BigDecimal	r24_stage3_provision;
	private BigDecimal	r24_other_alloate;
	private BigDecimal	r24_1_asset;
	private BigDecimal	r24_2_asset;
	private BigDecimal	r24_3a_asset;
	private BigDecimal	r24_3b_asset;
	private BigDecimal	r24_3c_asset;
	private BigDecimal	r24_1_provision;
	private BigDecimal	r24_2_provision;
	private BigDecimal	r24_3a_provision;
	private BigDecimal	r24_3b_provision;
	private BigDecimal	r24_3c_provision;
	private BigDecimal	r24_current;
	private BigDecimal	r24_lessthan_30;
	private BigDecimal	r24_exclusive_90days;
	private BigDecimal	r24_exclusive_120days;
	private BigDecimal	r24_exclusive_180days;
	private BigDecimal	r24_exclusive_over_180days;
	private BigDecimal	r24_total_past;
	private BigDecimal	r24_new_stage3;
	private BigDecimal	r24_new_specific;
	private BigDecimal	r24_new_other;
	private BigDecimal	r24_performing_accounts;
	private BigDecimal	r24_non_performing_accounts;
	private String	r24_outstanding_check;
	private String	r24_provision_check;
	private String	r24_past_due_date;
	private String	r25_asset_classes;
	private BigDecimal	r25_outstanding_balance;
	private BigDecimal	r25_provision_suspense;
	private BigDecimal	r25_stage3_provision;
	private BigDecimal	r25_other_alloate;
	private BigDecimal	r25_1_asset;
	private BigDecimal	r25_2_asset;
	private BigDecimal	r25_3a_asset;
	private BigDecimal	r25_3b_asset;
	private BigDecimal	r25_3c_asset;
	private BigDecimal	r25_1_provision;
	private BigDecimal	r25_2_provision;
	private BigDecimal	r25_3a_provision;
	private BigDecimal	r25_3b_provision;
	private BigDecimal	r25_3c_provision;
	private BigDecimal	r25_current;
	private BigDecimal	r25_lessthan_30;
	private BigDecimal	r25_exclusive_90days;
	private BigDecimal	r25_exclusive_120days;
	private BigDecimal	r25_exclusive_180days;
	private BigDecimal	r25_exclusive_over_180days;
	private BigDecimal	r25_total_past;
	private BigDecimal	r25_new_stage3;
	private BigDecimal	r25_new_specific;
	private BigDecimal	r25_new_other;
	private BigDecimal	r25_performing_accounts;
	private BigDecimal	r25_non_performing_accounts;
	private String	r25_outstanding_check;
	private String	r25_provision_check;
	private String	r25_past_due_date;
	private String	r26_asset_classes;
	private BigDecimal	r26_outstanding_balance;
	private BigDecimal	r26_provision_suspense;
	private BigDecimal	r26_stage3_provision;
	private BigDecimal	r26_other_alloate;
	private BigDecimal	r26_1_asset;
	private BigDecimal	r26_2_asset;
	private BigDecimal	r26_3a_asset;
	private BigDecimal	r26_3b_asset;
	private BigDecimal	r26_3c_asset;
	private BigDecimal	r26_1_provision;
	private BigDecimal	r26_2_provision;
	private BigDecimal	r26_3a_provision;
	private BigDecimal	r26_3b_provision;
	private BigDecimal	r26_3c_provision;
	private BigDecimal	r26_current;
	private BigDecimal	r26_lessthan_30;
	private BigDecimal	r26_exclusive_90days;
	private BigDecimal	r26_exclusive_120days;
	private BigDecimal	r26_exclusive_180days;
	private BigDecimal	r26_exclusive_over_180days;
	private BigDecimal	r26_total_past;
	private BigDecimal	r26_new_stage3;
	private BigDecimal	r26_new_specific;
	private BigDecimal	r26_new_other;
	private BigDecimal	r26_performing_accounts;
	private BigDecimal	r26_non_performing_accounts;
	private String	r26_outstanding_check;
	private String	r26_provision_check;
	private String	r26_past_due_date;
	private String	r27_asset_classes;
	private BigDecimal	r27_outstanding_balance;
	private BigDecimal	r27_provision_suspense;
	private BigDecimal	r27_stage3_provision;
	private BigDecimal	r27_other_alloate;
	private BigDecimal	r27_1_asset;
	private BigDecimal	r27_2_asset;
	private BigDecimal	r27_3a_asset;
	private BigDecimal	r27_3b_asset;
	private BigDecimal	r27_3c_asset;
	private BigDecimal	r27_1_provision;
	private BigDecimal	r27_2_provision;
	private BigDecimal	r27_3a_provision;
	private BigDecimal	r27_3b_provision;
	private BigDecimal	r27_3c_provision;
	private BigDecimal	r27_current;
	private BigDecimal	r27_lessthan_30;
	private BigDecimal	r27_exclusive_90days;
	private BigDecimal	r27_exclusive_120days;
	private BigDecimal	r27_exclusive_180days;
	private BigDecimal	r27_exclusive_over_180days;
	private BigDecimal	r27_total_past;
	private BigDecimal	r27_new_stage3;
	private BigDecimal	r27_new_specific;
	private BigDecimal	r27_new_other;
	private BigDecimal	r27_performing_accounts;
	private BigDecimal	r27_non_performing_accounts;
	private String	r27_outstanding_check;
	private String	r27_provision_check;
	private String	r27_past_due_date;
	private String	r28_asset_classes;
	private BigDecimal	r28_outstanding_balance;
	private BigDecimal	r28_provision_suspense;
	private BigDecimal	r28_stage3_provision;
	private BigDecimal	r28_other_alloate;
	private BigDecimal	r28_1_asset;
	private BigDecimal	r28_2_asset;
	private BigDecimal	r28_3a_asset;
	private BigDecimal	r28_3b_asset;
	private BigDecimal	r28_3c_asset;
	private BigDecimal	r28_1_provision;
	private BigDecimal	r28_2_provision;
	private BigDecimal	r28_3a_provision;
	private BigDecimal	r28_3b_provision;
	private BigDecimal	r28_3c_provision;
	private BigDecimal	r28_current;
	private BigDecimal	r28_lessthan_30;
	private BigDecimal	r28_exclusive_90days;
	private BigDecimal	r28_exclusive_120days;
	private BigDecimal	r28_exclusive_180days;
	private BigDecimal	r28_exclusive_over_180days;
	private BigDecimal	r28_total_past;
	private BigDecimal	r28_new_stage3;
	private BigDecimal	r28_new_specific;
	private BigDecimal	r28_new_other;
	private BigDecimal	r28_performing_accounts;
	private BigDecimal	r28_non_performing_accounts;
	private String	r28_outstanding_check;
	private String	r28_provision_check;
	private String	r28_past_due_date;
	private String	r29_asset_classes;
	private BigDecimal	r29_outstanding_balance;
	private BigDecimal	r29_provision_suspense;
	private BigDecimal	r29_stage3_provision;
	private BigDecimal	r29_other_alloate;
	private BigDecimal	r29_1_asset;
	private BigDecimal	r29_2_asset;
	private BigDecimal	r29_3a_asset;
	private BigDecimal	r29_3b_asset;
	private BigDecimal	r29_3c_asset;
	private BigDecimal	r29_1_provision;
	private BigDecimal	r29_2_provision;
	private BigDecimal	r29_3a_provision;
	private BigDecimal	r29_3b_provision;
	private BigDecimal	r29_3c_provision;
	private BigDecimal	r29_current;
	private BigDecimal	r29_lessthan_30;
	private BigDecimal	r29_exclusive_90days;
	private BigDecimal	r29_exclusive_120days;
	private BigDecimal	r29_exclusive_180days;
	private BigDecimal	r29_exclusive_over_180days;
	private BigDecimal	r29_total_past;
	private BigDecimal	r29_new_stage3;
	private BigDecimal	r29_new_specific;
	private BigDecimal	r29_new_other;
	private BigDecimal	r29_performing_accounts;
	private BigDecimal	r29_non_performing_accounts;
	private String	r29_outstanding_check;
	private String	r29_provision_check;
	private String	r29_past_due_date;
	private String	r30_asset_classes;
	private BigDecimal	r30_outstanding_balance;
	private BigDecimal	r30_provision_suspense;
	private BigDecimal	r30_stage3_provision;
	private BigDecimal	r30_other_alloate;
	private BigDecimal	r30_1_asset;
	private BigDecimal	r30_2_asset;
	private BigDecimal	r30_3a_asset;
	private BigDecimal	r30_3b_asset;
	private BigDecimal	r30_3c_asset;
	private BigDecimal	r30_1_provision;
	private BigDecimal	r30_2_provision;
	private BigDecimal	r30_3a_provision;
	private BigDecimal	r30_3b_provision;
	private BigDecimal	r30_3c_provision;
	private BigDecimal	r30_current;
	private BigDecimal	r30_lessthan_30;
	private BigDecimal	r30_exclusive_90days;
	private BigDecimal	r30_exclusive_120days;
	private BigDecimal	r30_exclusive_180days;
	private BigDecimal	r30_exclusive_over_180days;
	private BigDecimal	r30_total_past;
	private BigDecimal	r30_new_stage3;
	private BigDecimal	r30_new_specific;
	private BigDecimal	r30_new_other;
	private BigDecimal	r30_performing_accounts;
	private BigDecimal	r30_non_performing_accounts;
	private String	r30_outstanding_check;
	private String	r30_provision_check;
	private String	r30_past_due_date;
	private String	r31_asset_classes;
	private BigDecimal	r31_outstanding_balance;
	private BigDecimal	r31_provision_suspense;
	private BigDecimal	r31_stage3_provision;
	private BigDecimal	r31_other_alloate;
	private BigDecimal	r31_1_asset;
	private BigDecimal	r31_2_asset;
	private BigDecimal	r31_3a_asset;
	private BigDecimal	r31_3b_asset;
	private BigDecimal	r31_3c_asset;
	private BigDecimal	r31_1_provision;
	private BigDecimal	r31_2_provision;
	private BigDecimal	r31_3a_provision;
	private BigDecimal	r31_3b_provision;
	private BigDecimal	r31_3c_provision;
	private BigDecimal	r31_current;
	private BigDecimal	r31_lessthan_30;
	private BigDecimal	r31_exclusive_90days;
	private BigDecimal	r31_exclusive_120days;
	private BigDecimal	r31_exclusive_180days;
	private BigDecimal	r31_exclusive_over_180days;
	private BigDecimal	r31_total_past;
	private BigDecimal	r31_new_stage3;
	private BigDecimal	r31_new_specific;
	private BigDecimal	r31_new_other;
	private BigDecimal	r31_performing_accounts;
	private BigDecimal	r31_non_performing_accounts;
	private String	r31_outstanding_check;
	private String	r31_provision_check;
	private String	r31_past_due_date;
	private String	r32_asset_classes;
	private BigDecimal	r32_outstanding_balance;
	private BigDecimal	r32_provision_suspense;
	private BigDecimal	r32_stage3_provision;
	private BigDecimal	r32_other_alloate;
	private BigDecimal	r32_1_asset;
	private BigDecimal	r32_2_asset;
	private BigDecimal	r32_3a_asset;
	private BigDecimal	r32_3b_asset;
	private BigDecimal	r32_3c_asset;
	private BigDecimal	r32_1_provision;
	private BigDecimal	r32_2_provision;
	private BigDecimal	r32_3a_provision;
	private BigDecimal	r32_3b_provision;
	private BigDecimal	r32_3c_provision;
	private BigDecimal	r32_current;
	private BigDecimal	r32_lessthan_30;
	private BigDecimal	r32_exclusive_90days;
	private BigDecimal	r32_exclusive_120days;
	private BigDecimal	r32_exclusive_180days;
	private BigDecimal	r32_exclusive_over_180days;
	private BigDecimal	r32_total_past;
	private BigDecimal	r32_new_stage3;
	private BigDecimal	r32_new_specific;
	private BigDecimal	r32_new_other;
	private BigDecimal	r32_performing_accounts;
	private BigDecimal	r32_non_performing_accounts;
	private String	r32_outstanding_check;
	private String	r32_provision_check;
	private String	r32_past_due_date;
	private String	r33_asset_classes;
	private BigDecimal	r33_outstanding_balance;
	private BigDecimal	r33_provision_suspense;
	private BigDecimal	r33_stage3_provision;
	private BigDecimal	r33_other_alloate;
	private BigDecimal	r33_1_asset;
	private BigDecimal	r33_2_asset;
	private BigDecimal	r33_3a_asset;
	private BigDecimal	r33_3b_asset;
	private BigDecimal	r33_3c_asset;
	private BigDecimal	r33_1_provision;
	private BigDecimal	r33_2_provision;
	private BigDecimal	r33_3a_provision;
	private BigDecimal	r33_3b_provision;
	private BigDecimal	r33_3c_provision;
	private BigDecimal	r33_current;
	private BigDecimal	r33_lessthan_30;
	private BigDecimal	r33_exclusive_90days;
	private BigDecimal	r33_exclusive_120days;
	private BigDecimal	r33_exclusive_180days;
	private BigDecimal	r33_exclusive_over_180days;
	private BigDecimal	r33_total_past;
	private BigDecimal	r33_new_stage3;
	private BigDecimal	r33_new_specific;
	private BigDecimal	r33_new_other;
	private BigDecimal	r33_performing_accounts;
	private BigDecimal	r33_non_performing_accounts;
	private String	r33_outstanding_check;
	private String	r33_provision_check;
	private String	r33_past_due_date;
	private String	r34_asset_classes;
	private BigDecimal	r34_outstanding_balance;
	private BigDecimal	r34_provision_suspense;
	private BigDecimal	r34_stage3_provision;
	private BigDecimal	r34_other_alloate;
	private BigDecimal	r34_1_asset;
	private BigDecimal	r34_2_asset;
	private BigDecimal	r34_3a_asset;
	private BigDecimal	r34_3b_asset;
	private BigDecimal	r34_3c_asset;
	private BigDecimal	r34_1_provision;
	private BigDecimal	r34_2_provision;
	private BigDecimal	r34_3a_provision;
	private BigDecimal	r34_3b_provision;
	private BigDecimal	r34_3c_provision;
	private BigDecimal	r34_current;
	private BigDecimal	r34_lessthan_30;
	private BigDecimal	r34_exclusive_90days;
	private BigDecimal	r34_exclusive_120days;
	private BigDecimal	r34_exclusive_180days;
	private BigDecimal	r34_exclusive_over_180days;
	private BigDecimal	r34_total_past;
	private BigDecimal	r34_new_stage3;
	private BigDecimal	r34_new_specific;
	private BigDecimal	r34_new_other;
	private BigDecimal	r34_performing_accounts;
	private BigDecimal	r34_non_performing_accounts;
	private String	r34_outstanding_check;
	private String	r34_provision_check;
	private String	r34_past_due_date;
	private String	r35_asset_classes;
	private BigDecimal	r35_outstanding_balance;
	private BigDecimal	r35_provision_suspense;
	private BigDecimal	r35_stage3_provision;
	private BigDecimal	r35_other_alloate;
	private BigDecimal	r35_1_asset;
	private BigDecimal	r35_2_asset;
	private BigDecimal	r35_3a_asset;
	private BigDecimal	r35_3b_asset;
	private BigDecimal	r35_3c_asset;
	private BigDecimal	r35_1_provision;
	private BigDecimal	r35_2_provision;
	private BigDecimal	r35_3a_provision;
	private BigDecimal	r35_3b_provision;
	private BigDecimal	r35_3c_provision;
	private BigDecimal	r35_current;
	private BigDecimal	r35_lessthan_30;
	private BigDecimal	r35_exclusive_90days;
	private BigDecimal	r35_exclusive_120days;
	private BigDecimal	r35_exclusive_180days;
	private BigDecimal	r35_exclusive_over_180days;
	private BigDecimal	r35_total_past;
	private BigDecimal	r35_new_stage3;
	private BigDecimal	r35_new_specific;
	private BigDecimal	r35_new_other;
	private BigDecimal	r35_performing_accounts;
	private BigDecimal	r35_non_performing_accounts;
	private String	r35_outstanding_check;
	private String	r35_provision_check;
	private String	r35_past_due_date;
	private String	r36_asset_classes;
	private BigDecimal	r36_outstanding_balance;
	private BigDecimal	r36_provision_suspense;
	private BigDecimal	r36_stage3_provision;
	private BigDecimal	r36_other_alloate;
	private BigDecimal	r36_1_asset;
	private BigDecimal	r36_2_asset;
	private BigDecimal	r36_3a_asset;
	private BigDecimal	r36_3b_asset;
	private BigDecimal	r36_3c_asset;
	private BigDecimal	r36_1_provision;
	private BigDecimal	r36_2_provision;
	private BigDecimal	r36_3a_provision;
	private BigDecimal	r36_3b_provision;
	private BigDecimal	r36_3c_provision;
	private BigDecimal	r36_current;
	private BigDecimal	r36_lessthan_30;
	private BigDecimal	r36_exclusive_90days;
	private BigDecimal	r36_exclusive_120days;
	private BigDecimal	r36_exclusive_180days;
	private BigDecimal	r36_exclusive_over_180days;
	private BigDecimal	r36_total_past;
	private BigDecimal	r36_new_stage3;
	private BigDecimal	r36_new_specific;
	private BigDecimal	r36_new_other;
	private BigDecimal	r36_performing_accounts;
	private BigDecimal	r36_non_performing_accounts;
	private String	r36_outstanding_check;
	private String	r36_provision_check;
	private String	r36_past_due_date;
	private String	r37_asset_classes;
	private BigDecimal	r37_outstanding_balance;
	private BigDecimal	r37_provision_suspense;
	private BigDecimal	r37_stage3_provision;
	private BigDecimal	r37_other_alloate;
	private BigDecimal	r37_1_asset;
	private BigDecimal	r37_2_asset;
	private BigDecimal	r37_3a_asset;
	private BigDecimal	r37_3b_asset;
	private BigDecimal	r37_3c_asset;
	private BigDecimal	r37_1_provision;
	private BigDecimal	r37_2_provision;
	private BigDecimal	r37_3a_provision;
	private BigDecimal	r37_3b_provision;
	private BigDecimal	r37_3c_provision;
	private BigDecimal	r37_current;
	private BigDecimal	r37_lessthan_30;
	private BigDecimal	r37_exclusive_90days;
	private BigDecimal	r37_exclusive_120days;
	private BigDecimal	r37_exclusive_180days;
	private BigDecimal	r37_exclusive_over_180days;
	private BigDecimal	r37_total_past;
	private BigDecimal	r37_new_stage3;
	private BigDecimal	r37_new_specific;
	private BigDecimal	r37_new_other;
	private BigDecimal	r37_performing_accounts;
	private BigDecimal	r37_non_performing_accounts;
	private String	r37_outstanding_check;
	private String	r37_provision_check;
	private String	r37_past_due_date;
	private String	r38_asset_classes;
	private BigDecimal	r38_outstanding_balance;
	private BigDecimal	r38_provision_suspense;
	private BigDecimal	r38_stage3_provision;
	private BigDecimal	r38_other_alloate;
	private BigDecimal	r38_1_asset;
	private BigDecimal	r38_2_asset;
	private BigDecimal	r38_3a_asset;
	private BigDecimal	r38_3b_asset;
	private BigDecimal	r38_3c_asset;
	private BigDecimal	r38_1_provision;
	private BigDecimal	r38_2_provision;
	private BigDecimal	r38_3a_provision;
	private BigDecimal	r38_3b_provision;
	private BigDecimal	r38_3c_provision;
	private BigDecimal	r38_current;
	private BigDecimal	r38_lessthan_30;
	private BigDecimal	r38_exclusive_90days;
	private BigDecimal	r38_exclusive_120days;
	private BigDecimal	r38_exclusive_180days;
	private BigDecimal	r38_exclusive_over_180days;
	private BigDecimal	r38_total_past;
	private BigDecimal	r38_new_stage3;
	private BigDecimal	r38_new_specific;
	private BigDecimal	r38_new_other;
	private BigDecimal	r38_performing_accounts;
	private BigDecimal	r38_non_performing_accounts;
	private String	r38_outstanding_check;
	private String	r38_provision_check;
	private String	r38_past_due_date;
	private String	r39_asset_classes;
	private BigDecimal	r39_outstanding_balance;
	private BigDecimal	r39_provision_suspense;
	private BigDecimal	r39_stage3_provision;
	private BigDecimal	r39_other_alloate;
	private BigDecimal	r39_1_asset;
	private BigDecimal	r39_2_asset;
	private BigDecimal	r39_3a_asset;
	private BigDecimal	r39_3b_asset;
	private BigDecimal	r39_3c_asset;
	private BigDecimal	r39_1_provision;
	private BigDecimal	r39_2_provision;
	private BigDecimal	r39_3a_provision;
	private BigDecimal	r39_3b_provision;
	private BigDecimal	r39_3c_provision;
	private BigDecimal	r39_current;
	private BigDecimal	r39_lessthan_30;
	private BigDecimal	r39_exclusive_90days;
	private BigDecimal	r39_exclusive_120days;
	private BigDecimal	r39_exclusive_180days;
	private BigDecimal	r39_exclusive_over_180days;
	private BigDecimal	r39_total_past;
	private BigDecimal	r39_new_stage3;
	private BigDecimal	r39_new_specific;
	private BigDecimal	r39_new_other;
	private BigDecimal	r39_performing_accounts;
	private BigDecimal	r39_non_performing_accounts;
	private String	r39_outstanding_check;
	private String	r39_provision_check;
	private String	r39_past_due_date;
	private String	r40_asset_classes;
	private BigDecimal	r40_outstanding_balance;
	private BigDecimal	r40_provision_suspense;
	private BigDecimal	r40_stage3_provision;
	private BigDecimal	r40_other_alloate;
	private BigDecimal	r40_1_asset;
	private BigDecimal	r40_2_asset;
	private BigDecimal	r40_3a_asset;
	private BigDecimal	r40_3b_asset;
	private BigDecimal	r40_3c_asset;
	private BigDecimal	r40_1_provision;
	private BigDecimal	r40_2_provision;
	private BigDecimal	r40_3a_provision;
	private BigDecimal	r40_3b_provision;
	private BigDecimal	r40_3c_provision;
	private BigDecimal	r40_current;
	private BigDecimal	r40_lessthan_30;
	private BigDecimal	r40_exclusive_90days;
	private BigDecimal	r40_exclusive_120days;
	private BigDecimal	r40_exclusive_180days;
	private BigDecimal	r40_exclusive_over_180days;
	private BigDecimal	r40_total_past;
	private BigDecimal	r40_new_stage3;
	private BigDecimal	r40_new_specific;
	private BigDecimal	r40_new_other;
	private BigDecimal	r40_performing_accounts;
	private BigDecimal	r40_non_performing_accounts;
	private String	r40_outstanding_check;
	private String	r40_provision_check;
	private String	r40_past_due_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;	
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	report_date;
	private String	repdesc;
	private String	frequency;
	public String getR10_asset_classes() {
		return r10_asset_classes;
	}
	public void setR10_asset_classes(String r10_asset_classes) {
		this.r10_asset_classes = r10_asset_classes;
	}
	public BigDecimal getR10_outstanding_balance() {
		return r10_outstanding_balance;
	}
	public void setR10_outstanding_balance(BigDecimal r10_outstanding_balance) {
		this.r10_outstanding_balance = r10_outstanding_balance;
	}
	public BigDecimal getR10_provision_suspense() {
		return r10_provision_suspense;
	}
	public void setR10_provision_suspense(BigDecimal r10_provision_suspense) {
		this.r10_provision_suspense = r10_provision_suspense;
	}
	public BigDecimal getR10_stage3_provision() {
		return r10_stage3_provision;
	}
	public void setR10_stage3_provision(BigDecimal r10_stage3_provision) {
		this.r10_stage3_provision = r10_stage3_provision;
	}
	public BigDecimal getR10_other_alloate() {
		return r10_other_alloate;
	}
	public void setR10_other_alloate(BigDecimal r10_other_alloate) {
		this.r10_other_alloate = r10_other_alloate;
	}
	public BigDecimal getR10_1_asset() {
		return r10_1_asset;
	}
	public void setR10_1_asset(BigDecimal r10_1_asset) {
		this.r10_1_asset = r10_1_asset;
	}
	public BigDecimal getR10_2_asset() {
		return r10_2_asset;
	}
	public void setR10_2_asset(BigDecimal r10_2_asset) {
		this.r10_2_asset = r10_2_asset;
	}
	public BigDecimal getR10_3a_asset() {
		return r10_3a_asset;
	}
	public void setR10_3a_asset(BigDecimal r10_3a_asset) {
		this.r10_3a_asset = r10_3a_asset;
	}
	public BigDecimal getR10_3b_asset() {
		return r10_3b_asset;
	}
	public void setR10_3b_asset(BigDecimal r10_3b_asset) {
		this.r10_3b_asset = r10_3b_asset;
	}
	public BigDecimal getR10_3c_asset() {
		return r10_3c_asset;
	}
	public void setR10_3c_asset(BigDecimal r10_3c_asset) {
		this.r10_3c_asset = r10_3c_asset;
	}
	public BigDecimal getR10_1_provision() {
		return r10_1_provision;
	}
	public void setR10_1_provision(BigDecimal r10_1_provision) {
		this.r10_1_provision = r10_1_provision;
	}
	public BigDecimal getR10_2_provision() {
		return r10_2_provision;
	}
	public void setR10_2_provision(BigDecimal r10_2_provision) {
		this.r10_2_provision = r10_2_provision;
	}
	public BigDecimal getR10_3a_provision() {
		return r10_3a_provision;
	}
	public void setR10_3a_provision(BigDecimal r10_3a_provision) {
		this.r10_3a_provision = r10_3a_provision;
	}
	public BigDecimal getR10_3b_provision() {
		return r10_3b_provision;
	}
	public void setR10_3b_provision(BigDecimal r10_3b_provision) {
		this.r10_3b_provision = r10_3b_provision;
	}
	public BigDecimal getR10_3c_provision() {
		return r10_3c_provision;
	}
	public void setR10_3c_provision(BigDecimal r10_3c_provision) {
		this.r10_3c_provision = r10_3c_provision;
	}
	public BigDecimal getR10_current() {
		return r10_current;
	}
	public void setR10_current(BigDecimal r10_current) {
		this.r10_current = r10_current;
	}
	public BigDecimal getR10_lessthan_30() {
		return r10_lessthan_30;
	}
	public void setR10_lessthan_30(BigDecimal r10_lessthan_30) {
		this.r10_lessthan_30 = r10_lessthan_30;
	}
	public BigDecimal getR10_exclusive_90days() {
		return r10_exclusive_90days;
	}
	public void setR10_exclusive_90days(BigDecimal r10_exclusive_90days) {
		this.r10_exclusive_90days = r10_exclusive_90days;
	}
	public BigDecimal getR10_exclusive_120days() {
		return r10_exclusive_120days;
	}
	public void setR10_exclusive_120days(BigDecimal r10_exclusive_120days) {
		this.r10_exclusive_120days = r10_exclusive_120days;
	}
	public BigDecimal getR10_exclusive_180days() {
		return r10_exclusive_180days;
	}
	public void setR10_exclusive_180days(BigDecimal r10_exclusive_180days) {
		this.r10_exclusive_180days = r10_exclusive_180days;
	}
	public BigDecimal getR10_exclusive_over_180days() {
		return r10_exclusive_over_180days;
	}
	public void setR10_exclusive_over_180days(BigDecimal r10_exclusive_over_180days) {
		this.r10_exclusive_over_180days = r10_exclusive_over_180days;
	}
	public BigDecimal getR10_total_past() {
		return r10_total_past;
	}
	public void setR10_total_past(BigDecimal r10_total_past) {
		this.r10_total_past = r10_total_past;
	}
	public BigDecimal getR10_new_stage3() {
		return r10_new_stage3;
	}
	public void setR10_new_stage3(BigDecimal r10_new_stage3) {
		this.r10_new_stage3 = r10_new_stage3;
	}
	public BigDecimal getR10_new_specific() {
		return r10_new_specific;
	}
	public void setR10_new_specific(BigDecimal r10_new_specific) {
		this.r10_new_specific = r10_new_specific;
	}
	public BigDecimal getR10_new_other() {
		return r10_new_other;
	}
	public void setR10_new_other(BigDecimal r10_new_other) {
		this.r10_new_other = r10_new_other;
	}
	public BigDecimal getR10_performing_accounts() {
		return r10_performing_accounts;
	}
	public void setR10_performing_accounts(BigDecimal r10_performing_accounts) {
		this.r10_performing_accounts = r10_performing_accounts;
	}
	public BigDecimal getR10_non_performing_accounts() {
		return r10_non_performing_accounts;
	}
	public void setR10_non_performing_accounts(BigDecimal r10_non_performing_accounts) {
		this.r10_non_performing_accounts = r10_non_performing_accounts;
	}
	public String getR10_outstanding_check() {
		return r10_outstanding_check;
	}
	public void setR10_outstanding_check(String r10_outstanding_check) {
		this.r10_outstanding_check = r10_outstanding_check;
	}
	public String getR10_provision_check() {
		return r10_provision_check;
	}
	public void setR10_provision_check(String r10_provision_check) {
		this.r10_provision_check = r10_provision_check;
	}
	public String getR10_past_due_date() {
		return r10_past_due_date;
	}
	public void setR10_past_due_date(String r10_past_due_date) {
		this.r10_past_due_date = r10_past_due_date;
	}
	public String getR11_asset_classes() {
		return r11_asset_classes;
	}
	public void setR11_asset_classes(String r11_asset_classes) {
		this.r11_asset_classes = r11_asset_classes;
	}
	public BigDecimal getR11_outstanding_balance() {
		return r11_outstanding_balance;
	}
	public void setR11_outstanding_balance(BigDecimal r11_outstanding_balance) {
		this.r11_outstanding_balance = r11_outstanding_balance;
	}
	public BigDecimal getR11_provision_suspense() {
		return r11_provision_suspense;
	}
	public void setR11_provision_suspense(BigDecimal r11_provision_suspense) {
		this.r11_provision_suspense = r11_provision_suspense;
	}
	public BigDecimal getR11_stage3_provision() {
		return r11_stage3_provision;
	}
	public void setR11_stage3_provision(BigDecimal r11_stage3_provision) {
		this.r11_stage3_provision = r11_stage3_provision;
	}
	public BigDecimal getR11_other_alloate() {
		return r11_other_alloate;
	}
	public void setR11_other_alloate(BigDecimal r11_other_alloate) {
		this.r11_other_alloate = r11_other_alloate;
	}
	public BigDecimal getR11_1_asset() {
		return r11_1_asset;
	}
	public void setR11_1_asset(BigDecimal r11_1_asset) {
		this.r11_1_asset = r11_1_asset;
	}
	public BigDecimal getR11_2_asset() {
		return r11_2_asset;
	}
	public void setR11_2_asset(BigDecimal r11_2_asset) {
		this.r11_2_asset = r11_2_asset;
	}
	public BigDecimal getR11_3a_asset() {
		return r11_3a_asset;
	}
	public void setR11_3a_asset(BigDecimal r11_3a_asset) {
		this.r11_3a_asset = r11_3a_asset;
	}
	public BigDecimal getR11_3b_asset() {
		return r11_3b_asset;
	}
	public void setR11_3b_asset(BigDecimal r11_3b_asset) {
		this.r11_3b_asset = r11_3b_asset;
	}
	public BigDecimal getR11_3c_asset() {
		return r11_3c_asset;
	}
	public void setR11_3c_asset(BigDecimal r11_3c_asset) {
		this.r11_3c_asset = r11_3c_asset;
	}
	public BigDecimal getR11_1_provision() {
		return r11_1_provision;
	}
	public void setR11_1_provision(BigDecimal r11_1_provision) {
		this.r11_1_provision = r11_1_provision;
	}
	public BigDecimal getR11_2_provision() {
		return r11_2_provision;
	}
	public void setR11_2_provision(BigDecimal r11_2_provision) {
		this.r11_2_provision = r11_2_provision;
	}
	public BigDecimal getR11_3a_provision() {
		return r11_3a_provision;
	}
	public void setR11_3a_provision(BigDecimal r11_3a_provision) {
		this.r11_3a_provision = r11_3a_provision;
	}
	public BigDecimal getR11_3b_provision() {
		return r11_3b_provision;
	}
	public void setR11_3b_provision(BigDecimal r11_3b_provision) {
		this.r11_3b_provision = r11_3b_provision;
	}
	public BigDecimal getR11_3c_provision() {
		return r11_3c_provision;
	}
	public void setR11_3c_provision(BigDecimal r11_3c_provision) {
		this.r11_3c_provision = r11_3c_provision;
	}
	public BigDecimal getR11_current() {
		return r11_current;
	}
	public void setR11_current(BigDecimal r11_current) {
		this.r11_current = r11_current;
	}
	public BigDecimal getR11_lessthan_30() {
		return r11_lessthan_30;
	}
	public void setR11_lessthan_30(BigDecimal r11_lessthan_30) {
		this.r11_lessthan_30 = r11_lessthan_30;
	}
	public BigDecimal getR11_exclusive_90days() {
		return r11_exclusive_90days;
	}
	public void setR11_exclusive_90days(BigDecimal r11_exclusive_90days) {
		this.r11_exclusive_90days = r11_exclusive_90days;
	}
	public BigDecimal getR11_exclusive_120days() {
		return r11_exclusive_120days;
	}
	public void setR11_exclusive_120days(BigDecimal r11_exclusive_120days) {
		this.r11_exclusive_120days = r11_exclusive_120days;
	}
	public BigDecimal getR11_exclusive_180days() {
		return r11_exclusive_180days;
	}
	public void setR11_exclusive_180days(BigDecimal r11_exclusive_180days) {
		this.r11_exclusive_180days = r11_exclusive_180days;
	}
	public BigDecimal getR11_exclusive_over_180days() {
		return r11_exclusive_over_180days;
	}
	public void setR11_exclusive_over_180days(BigDecimal r11_exclusive_over_180days) {
		this.r11_exclusive_over_180days = r11_exclusive_over_180days;
	}
	public BigDecimal getR11_total_past() {
		return r11_total_past;
	}
	public void setR11_total_past(BigDecimal r11_total_past) {
		this.r11_total_past = r11_total_past;
	}
	public BigDecimal getR11_new_stage3() {
		return r11_new_stage3;
	}
	public void setR11_new_stage3(BigDecimal r11_new_stage3) {
		this.r11_new_stage3 = r11_new_stage3;
	}
	public BigDecimal getR11_new_specific() {
		return r11_new_specific;
	}
	public void setR11_new_specific(BigDecimal r11_new_specific) {
		this.r11_new_specific = r11_new_specific;
	}
	public BigDecimal getR11_new_other() {
		return r11_new_other;
	}
	public void setR11_new_other(BigDecimal r11_new_other) {
		this.r11_new_other = r11_new_other;
	}
	public BigDecimal getR11_performing_accounts() {
		return r11_performing_accounts;
	}
	public void setR11_performing_accounts(BigDecimal r11_performing_accounts) {
		this.r11_performing_accounts = r11_performing_accounts;
	}
	public BigDecimal getR11_non_performing_accounts() {
		return r11_non_performing_accounts;
	}
	public void setR11_non_performing_accounts(BigDecimal r11_non_performing_accounts) {
		this.r11_non_performing_accounts = r11_non_performing_accounts;
	}
	public String getR11_outstanding_check() {
		return r11_outstanding_check;
	}
	public void setR11_outstanding_check(String r11_outstanding_check) {
		this.r11_outstanding_check = r11_outstanding_check;
	}
	public String getR11_provision_check() {
		return r11_provision_check;
	}
	public void setR11_provision_check(String r11_provision_check) {
		this.r11_provision_check = r11_provision_check;
	}
	public String getR11_past_due_date() {
		return r11_past_due_date;
	}
	public void setR11_past_due_date(String r11_past_due_date) {
		this.r11_past_due_date = r11_past_due_date;
	}
	public String getR12_asset_classes() {
		return r12_asset_classes;
	}
	public void setR12_asset_classes(String r12_asset_classes) {
		this.r12_asset_classes = r12_asset_classes;
	}
	public BigDecimal getR12_outstanding_balance() {
		return r12_outstanding_balance;
	}
	public void setR12_outstanding_balance(BigDecimal r12_outstanding_balance) {
		this.r12_outstanding_balance = r12_outstanding_balance;
	}
	public BigDecimal getR12_provision_suspense() {
		return r12_provision_suspense;
	}
	public void setR12_provision_suspense(BigDecimal r12_provision_suspense) {
		this.r12_provision_suspense = r12_provision_suspense;
	}
	public BigDecimal getR12_stage3_provision() {
		return r12_stage3_provision;
	}
	public void setR12_stage3_provision(BigDecimal r12_stage3_provision) {
		this.r12_stage3_provision = r12_stage3_provision;
	}
	public BigDecimal getR12_other_alloate() {
		return r12_other_alloate;
	}
	public void setR12_other_alloate(BigDecimal r12_other_alloate) {
		this.r12_other_alloate = r12_other_alloate;
	}
	public BigDecimal getR12_1_asset() {
		return r12_1_asset;
	}
	public void setR12_1_asset(BigDecimal r12_1_asset) {
		this.r12_1_asset = r12_1_asset;
	}
	public BigDecimal getR12_2_asset() {
		return r12_2_asset;
	}
	public void setR12_2_asset(BigDecimal r12_2_asset) {
		this.r12_2_asset = r12_2_asset;
	}
	public BigDecimal getR12_3a_asset() {
		return r12_3a_asset;
	}
	public void setR12_3a_asset(BigDecimal r12_3a_asset) {
		this.r12_3a_asset = r12_3a_asset;
	}
	public BigDecimal getR12_3b_asset() {
		return r12_3b_asset;
	}
	public void setR12_3b_asset(BigDecimal r12_3b_asset) {
		this.r12_3b_asset = r12_3b_asset;
	}
	public BigDecimal getR12_3c_asset() {
		return r12_3c_asset;
	}
	public void setR12_3c_asset(BigDecimal r12_3c_asset) {
		this.r12_3c_asset = r12_3c_asset;
	}
	public BigDecimal getR12_1_provision() {
		return r12_1_provision;
	}
	public void setR12_1_provision(BigDecimal r12_1_provision) {
		this.r12_1_provision = r12_1_provision;
	}
	public BigDecimal getR12_2_provision() {
		return r12_2_provision;
	}
	public void setR12_2_provision(BigDecimal r12_2_provision) {
		this.r12_2_provision = r12_2_provision;
	}
	public BigDecimal getR12_3a_provision() {
		return r12_3a_provision;
	}
	public void setR12_3a_provision(BigDecimal r12_3a_provision) {
		this.r12_3a_provision = r12_3a_provision;
	}
	public BigDecimal getR12_3b_provision() {
		return r12_3b_provision;
	}
	public void setR12_3b_provision(BigDecimal r12_3b_provision) {
		this.r12_3b_provision = r12_3b_provision;
	}
	public BigDecimal getR12_3c_provision() {
		return r12_3c_provision;
	}
	public void setR12_3c_provision(BigDecimal r12_3c_provision) {
		this.r12_3c_provision = r12_3c_provision;
	}
	public BigDecimal getR12_current() {
		return r12_current;
	}
	public void setR12_current(BigDecimal r12_current) {
		this.r12_current = r12_current;
	}
	public BigDecimal getR12_lessthan_30() {
		return r12_lessthan_30;
	}
	public void setR12_lessthan_30(BigDecimal r12_lessthan_30) {
		this.r12_lessthan_30 = r12_lessthan_30;
	}
	public BigDecimal getR12_exclusive_90days() {
		return r12_exclusive_90days;
	}
	public void setR12_exclusive_90days(BigDecimal r12_exclusive_90days) {
		this.r12_exclusive_90days = r12_exclusive_90days;
	}
	public BigDecimal getR12_exclusive_120days() {
		return r12_exclusive_120days;
	}
	public void setR12_exclusive_120days(BigDecimal r12_exclusive_120days) {
		this.r12_exclusive_120days = r12_exclusive_120days;
	}
	public BigDecimal getR12_exclusive_180days() {
		return r12_exclusive_180days;
	}
	public void setR12_exclusive_180days(BigDecimal r12_exclusive_180days) {
		this.r12_exclusive_180days = r12_exclusive_180days;
	}
	public BigDecimal getR12_exclusive_over_180days() {
		return r12_exclusive_over_180days;
	}
	public void setR12_exclusive_over_180days(BigDecimal r12_exclusive_over_180days) {
		this.r12_exclusive_over_180days = r12_exclusive_over_180days;
	}
	public BigDecimal getR12_total_past() {
		return r12_total_past;
	}
	public void setR12_total_past(BigDecimal r12_total_past) {
		this.r12_total_past = r12_total_past;
	}
	public BigDecimal getR12_new_stage3() {
		return r12_new_stage3;
	}
	public void setR12_new_stage3(BigDecimal r12_new_stage3) {
		this.r12_new_stage3 = r12_new_stage3;
	}
	public BigDecimal getR12_new_specific() {
		return r12_new_specific;
	}
	public void setR12_new_specific(BigDecimal r12_new_specific) {
		this.r12_new_specific = r12_new_specific;
	}
	public BigDecimal getR12_new_other() {
		return r12_new_other;
	}
	public void setR12_new_other(BigDecimal r12_new_other) {
		this.r12_new_other = r12_new_other;
	}
	public BigDecimal getR12_performing_accounts() {
		return r12_performing_accounts;
	}
	public void setR12_performing_accounts(BigDecimal r12_performing_accounts) {
		this.r12_performing_accounts = r12_performing_accounts;
	}
	public BigDecimal getR12_non_performing_accounts() {
		return r12_non_performing_accounts;
	}
	public void setR12_non_performing_accounts(BigDecimal r12_non_performing_accounts) {
		this.r12_non_performing_accounts = r12_non_performing_accounts;
	}
	public String getR12_outstanding_check() {
		return r12_outstanding_check;
	}
	public void setR12_outstanding_check(String r12_outstanding_check) {
		this.r12_outstanding_check = r12_outstanding_check;
	}
	public String getR12_provision_check() {
		return r12_provision_check;
	}
	public void setR12_provision_check(String r12_provision_check) {
		this.r12_provision_check = r12_provision_check;
	}
	public String getR12_past_due_date() {
		return r12_past_due_date;
	}
	public void setR12_past_due_date(String r12_past_due_date) {
		this.r12_past_due_date = r12_past_due_date;
	}
	public String getR13_asset_classes() {
		return r13_asset_classes;
	}
	public void setR13_asset_classes(String r13_asset_classes) {
		this.r13_asset_classes = r13_asset_classes;
	}
	public BigDecimal getR13_outstanding_balance() {
		return r13_outstanding_balance;
	}
	public void setR13_outstanding_balance(BigDecimal r13_outstanding_balance) {
		this.r13_outstanding_balance = r13_outstanding_balance;
	}
	public BigDecimal getR13_provision_suspense() {
		return r13_provision_suspense;
	}
	public void setR13_provision_suspense(BigDecimal r13_provision_suspense) {
		this.r13_provision_suspense = r13_provision_suspense;
	}
	public BigDecimal getR13_stage3_provision() {
		return r13_stage3_provision;
	}
	public void setR13_stage3_provision(BigDecimal r13_stage3_provision) {
		this.r13_stage3_provision = r13_stage3_provision;
	}
	public BigDecimal getR13_other_alloate() {
		return r13_other_alloate;
	}
	public void setR13_other_alloate(BigDecimal r13_other_alloate) {
		this.r13_other_alloate = r13_other_alloate;
	}
	public BigDecimal getR13_1_asset() {
		return r13_1_asset;
	}
	public void setR13_1_asset(BigDecimal r13_1_asset) {
		this.r13_1_asset = r13_1_asset;
	}
	public BigDecimal getR13_2_asset() {
		return r13_2_asset;
	}
	public void setR13_2_asset(BigDecimal r13_2_asset) {
		this.r13_2_asset = r13_2_asset;
	}
	public BigDecimal getR13_3a_asset() {
		return r13_3a_asset;
	}
	public void setR13_3a_asset(BigDecimal r13_3a_asset) {
		this.r13_3a_asset = r13_3a_asset;
	}
	public BigDecimal getR13_3b_asset() {
		return r13_3b_asset;
	}
	public void setR13_3b_asset(BigDecimal r13_3b_asset) {
		this.r13_3b_asset = r13_3b_asset;
	}
	public BigDecimal getR13_3c_asset() {
		return r13_3c_asset;
	}
	public void setR13_3c_asset(BigDecimal r13_3c_asset) {
		this.r13_3c_asset = r13_3c_asset;
	}
	public BigDecimal getR13_1_provision() {
		return r13_1_provision;
	}
	public void setR13_1_provision(BigDecimal r13_1_provision) {
		this.r13_1_provision = r13_1_provision;
	}
	public BigDecimal getR13_2_provision() {
		return r13_2_provision;
	}
	public void setR13_2_provision(BigDecimal r13_2_provision) {
		this.r13_2_provision = r13_2_provision;
	}
	public BigDecimal getR13_3a_provision() {
		return r13_3a_provision;
	}
	public void setR13_3a_provision(BigDecimal r13_3a_provision) {
		this.r13_3a_provision = r13_3a_provision;
	}
	public BigDecimal getR13_3b_provision() {
		return r13_3b_provision;
	}
	public void setR13_3b_provision(BigDecimal r13_3b_provision) {
		this.r13_3b_provision = r13_3b_provision;
	}
	public BigDecimal getR13_3c_provision() {
		return r13_3c_provision;
	}
	public void setR13_3c_provision(BigDecimal r13_3c_provision) {
		this.r13_3c_provision = r13_3c_provision;
	}
	public BigDecimal getR13_current() {
		return r13_current;
	}
	public void setR13_current(BigDecimal r13_current) {
		this.r13_current = r13_current;
	}
	public BigDecimal getR13_lessthan_30() {
		return r13_lessthan_30;
	}
	public void setR13_lessthan_30(BigDecimal r13_lessthan_30) {
		this.r13_lessthan_30 = r13_lessthan_30;
	}
	public BigDecimal getR13_exclusive_90days() {
		return r13_exclusive_90days;
	}
	public void setR13_exclusive_90days(BigDecimal r13_exclusive_90days) {
		this.r13_exclusive_90days = r13_exclusive_90days;
	}
	public BigDecimal getR13_exclusive_120days() {
		return r13_exclusive_120days;
	}
	public void setR13_exclusive_120days(BigDecimal r13_exclusive_120days) {
		this.r13_exclusive_120days = r13_exclusive_120days;
	}
	public BigDecimal getR13_exclusive_180days() {
		return r13_exclusive_180days;
	}
	public void setR13_exclusive_180days(BigDecimal r13_exclusive_180days) {
		this.r13_exclusive_180days = r13_exclusive_180days;
	}
	public BigDecimal getR13_exclusive_over_180days() {
		return r13_exclusive_over_180days;
	}
	public void setR13_exclusive_over_180days(BigDecimal r13_exclusive_over_180days) {
		this.r13_exclusive_over_180days = r13_exclusive_over_180days;
	}
	public BigDecimal getR13_total_past() {
		return r13_total_past;
	}
	public void setR13_total_past(BigDecimal r13_total_past) {
		this.r13_total_past = r13_total_past;
	}
	public BigDecimal getR13_new_stage3() {
		return r13_new_stage3;
	}
	public void setR13_new_stage3(BigDecimal r13_new_stage3) {
		this.r13_new_stage3 = r13_new_stage3;
	}
	public BigDecimal getR13_new_specific() {
		return r13_new_specific;
	}
	public void setR13_new_specific(BigDecimal r13_new_specific) {
		this.r13_new_specific = r13_new_specific;
	}
	public BigDecimal getR13_new_other() {
		return r13_new_other;
	}
	public void setR13_new_other(BigDecimal r13_new_other) {
		this.r13_new_other = r13_new_other;
	}
	public BigDecimal getR13_performing_accounts() {
		return r13_performing_accounts;
	}
	public void setR13_performing_accounts(BigDecimal r13_performing_accounts) {
		this.r13_performing_accounts = r13_performing_accounts;
	}
	public BigDecimal getR13_non_performing_accounts() {
		return r13_non_performing_accounts;
	}
	public void setR13_non_performing_accounts(BigDecimal r13_non_performing_accounts) {
		this.r13_non_performing_accounts = r13_non_performing_accounts;
	}
	public String getR13_outstanding_check() {
		return r13_outstanding_check;
	}
	public void setR13_outstanding_check(String r13_outstanding_check) {
		this.r13_outstanding_check = r13_outstanding_check;
	}
	public String getR13_provision_check() {
		return r13_provision_check;
	}
	public void setR13_provision_check(String r13_provision_check) {
		this.r13_provision_check = r13_provision_check;
	}
	public String getR13_past_due_date() {
		return r13_past_due_date;
	}
	public void setR13_past_due_date(String r13_past_due_date) {
		this.r13_past_due_date = r13_past_due_date;
	}
	public String getR14_asset_classes() {
		return r14_asset_classes;
	}
	public void setR14_asset_classes(String r14_asset_classes) {
		this.r14_asset_classes = r14_asset_classes;
	}
	public BigDecimal getR14_outstanding_balance() {
		return r14_outstanding_balance;
	}
	public void setR14_outstanding_balance(BigDecimal r14_outstanding_balance) {
		this.r14_outstanding_balance = r14_outstanding_balance;
	}
	public BigDecimal getR14_provision_suspense() {
		return r14_provision_suspense;
	}
	public void setR14_provision_suspense(BigDecimal r14_provision_suspense) {
		this.r14_provision_suspense = r14_provision_suspense;
	}
	public BigDecimal getR14_stage3_provision() {
		return r14_stage3_provision;
	}
	public void setR14_stage3_provision(BigDecimal r14_stage3_provision) {
		this.r14_stage3_provision = r14_stage3_provision;
	}
	public BigDecimal getR14_other_alloate() {
		return r14_other_alloate;
	}
	public void setR14_other_alloate(BigDecimal r14_other_alloate) {
		this.r14_other_alloate = r14_other_alloate;
	}
	public BigDecimal getR14_1_asset() {
		return r14_1_asset;
	}
	public void setR14_1_asset(BigDecimal r14_1_asset) {
		this.r14_1_asset = r14_1_asset;
	}
	public BigDecimal getR14_2_asset() {
		return r14_2_asset;
	}
	public void setR14_2_asset(BigDecimal r14_2_asset) {
		this.r14_2_asset = r14_2_asset;
	}
	public BigDecimal getR14_3a_asset() {
		return r14_3a_asset;
	}
	public void setR14_3a_asset(BigDecimal r14_3a_asset) {
		this.r14_3a_asset = r14_3a_asset;
	}
	public BigDecimal getR14_3b_asset() {
		return r14_3b_asset;
	}
	public void setR14_3b_asset(BigDecimal r14_3b_asset) {
		this.r14_3b_asset = r14_3b_asset;
	}
	public BigDecimal getR14_3c_asset() {
		return r14_3c_asset;
	}
	public void setR14_3c_asset(BigDecimal r14_3c_asset) {
		this.r14_3c_asset = r14_3c_asset;
	}
	public BigDecimal getR14_1_provision() {
		return r14_1_provision;
	}
	public void setR14_1_provision(BigDecimal r14_1_provision) {
		this.r14_1_provision = r14_1_provision;
	}
	public BigDecimal getR14_2_provision() {
		return r14_2_provision;
	}
	public void setR14_2_provision(BigDecimal r14_2_provision) {
		this.r14_2_provision = r14_2_provision;
	}
	public BigDecimal getR14_3a_provision() {
		return r14_3a_provision;
	}
	public void setR14_3a_provision(BigDecimal r14_3a_provision) {
		this.r14_3a_provision = r14_3a_provision;
	}
	public BigDecimal getR14_3b_provision() {
		return r14_3b_provision;
	}
	public void setR14_3b_provision(BigDecimal r14_3b_provision) {
		this.r14_3b_provision = r14_3b_provision;
	}
	public BigDecimal getR14_3c_provision() {
		return r14_3c_provision;
	}
	public void setR14_3c_provision(BigDecimal r14_3c_provision) {
		this.r14_3c_provision = r14_3c_provision;
	}
	public BigDecimal getR14_current() {
		return r14_current;
	}
	public void setR14_current(BigDecimal r14_current) {
		this.r14_current = r14_current;
	}
	public BigDecimal getR14_lessthan_30() {
		return r14_lessthan_30;
	}
	public void setR14_lessthan_30(BigDecimal r14_lessthan_30) {
		this.r14_lessthan_30 = r14_lessthan_30;
	}
	public BigDecimal getR14_exclusive_90days() {
		return r14_exclusive_90days;
	}
	public void setR14_exclusive_90days(BigDecimal r14_exclusive_90days) {
		this.r14_exclusive_90days = r14_exclusive_90days;
	}
	public BigDecimal getR14_exclusive_120days() {
		return r14_exclusive_120days;
	}
	public void setR14_exclusive_120days(BigDecimal r14_exclusive_120days) {
		this.r14_exclusive_120days = r14_exclusive_120days;
	}
	public BigDecimal getR14_exclusive_180days() {
		return r14_exclusive_180days;
	}
	public void setR14_exclusive_180days(BigDecimal r14_exclusive_180days) {
		this.r14_exclusive_180days = r14_exclusive_180days;
	}
	public BigDecimal getR14_exclusive_over_180days() {
		return r14_exclusive_over_180days;
	}
	public void setR14_exclusive_over_180days(BigDecimal r14_exclusive_over_180days) {
		this.r14_exclusive_over_180days = r14_exclusive_over_180days;
	}
	public BigDecimal getR14_total_past() {
		return r14_total_past;
	}
	public void setR14_total_past(BigDecimal r14_total_past) {
		this.r14_total_past = r14_total_past;
	}
	public BigDecimal getR14_new_stage3() {
		return r14_new_stage3;
	}
	public void setR14_new_stage3(BigDecimal r14_new_stage3) {
		this.r14_new_stage3 = r14_new_stage3;
	}
	public BigDecimal getR14_new_specific() {
		return r14_new_specific;
	}
	public void setR14_new_specific(BigDecimal r14_new_specific) {
		this.r14_new_specific = r14_new_specific;
	}
	public BigDecimal getR14_new_other() {
		return r14_new_other;
	}
	public void setR14_new_other(BigDecimal r14_new_other) {
		this.r14_new_other = r14_new_other;
	}
	public BigDecimal getR14_performing_accounts() {
		return r14_performing_accounts;
	}
	public void setR14_performing_accounts(BigDecimal r14_performing_accounts) {
		this.r14_performing_accounts = r14_performing_accounts;
	}
	public BigDecimal getR14_non_performing_accounts() {
		return r14_non_performing_accounts;
	}
	public void setR14_non_performing_accounts(BigDecimal r14_non_performing_accounts) {
		this.r14_non_performing_accounts = r14_non_performing_accounts;
	}
	public String getR14_outstanding_check() {
		return r14_outstanding_check;
	}
	public void setR14_outstanding_check(String r14_outstanding_check) {
		this.r14_outstanding_check = r14_outstanding_check;
	}
	public String getR14_provision_check() {
		return r14_provision_check;
	}
	public void setR14_provision_check(String r14_provision_check) {
		this.r14_provision_check = r14_provision_check;
	}
	public String getR14_past_due_date() {
		return r14_past_due_date;
	}
	public void setR14_past_due_date(String r14_past_due_date) {
		this.r14_past_due_date = r14_past_due_date;
	}
	public String getR15_asset_classes() {
		return r15_asset_classes;
	}
	public void setR15_asset_classes(String r15_asset_classes) {
		this.r15_asset_classes = r15_asset_classes;
	}
	public BigDecimal getR15_outstanding_balance() {
		return r15_outstanding_balance;
	}
	public void setR15_outstanding_balance(BigDecimal r15_outstanding_balance) {
		this.r15_outstanding_balance = r15_outstanding_balance;
	}
	public BigDecimal getR15_provision_suspense() {
		return r15_provision_suspense;
	}
	public void setR15_provision_suspense(BigDecimal r15_provision_suspense) {
		this.r15_provision_suspense = r15_provision_suspense;
	}
	public BigDecimal getR15_stage3_provision() {
		return r15_stage3_provision;
	}
	public void setR15_stage3_provision(BigDecimal r15_stage3_provision) {
		this.r15_stage3_provision = r15_stage3_provision;
	}
	public BigDecimal getR15_other_alloate() {
		return r15_other_alloate;
	}
	public void setR15_other_alloate(BigDecimal r15_other_alloate) {
		this.r15_other_alloate = r15_other_alloate;
	}
	public BigDecimal getR15_1_asset() {
		return r15_1_asset;
	}
	public void setR15_1_asset(BigDecimal r15_1_asset) {
		this.r15_1_asset = r15_1_asset;
	}
	public BigDecimal getR15_2_asset() {
		return r15_2_asset;
	}
	public void setR15_2_asset(BigDecimal r15_2_asset) {
		this.r15_2_asset = r15_2_asset;
	}
	public BigDecimal getR15_3a_asset() {
		return r15_3a_asset;
	}
	public void setR15_3a_asset(BigDecimal r15_3a_asset) {
		this.r15_3a_asset = r15_3a_asset;
	}
	public BigDecimal getR15_3b_asset() {
		return r15_3b_asset;
	}
	public void setR15_3b_asset(BigDecimal r15_3b_asset) {
		this.r15_3b_asset = r15_3b_asset;
	}
	public BigDecimal getR15_3c_asset() {
		return r15_3c_asset;
	}
	public void setR15_3c_asset(BigDecimal r15_3c_asset) {
		this.r15_3c_asset = r15_3c_asset;
	}
	public BigDecimal getR15_1_provision() {
		return r15_1_provision;
	}
	public void setR15_1_provision(BigDecimal r15_1_provision) {
		this.r15_1_provision = r15_1_provision;
	}
	public BigDecimal getR15_2_provision() {
		return r15_2_provision;
	}
	public void setR15_2_provision(BigDecimal r15_2_provision) {
		this.r15_2_provision = r15_2_provision;
	}
	public BigDecimal getR15_3a_provision() {
		return r15_3a_provision;
	}
	public void setR15_3a_provision(BigDecimal r15_3a_provision) {
		this.r15_3a_provision = r15_3a_provision;
	}
	public BigDecimal getR15_3b_provision() {
		return r15_3b_provision;
	}
	public void setR15_3b_provision(BigDecimal r15_3b_provision) {
		this.r15_3b_provision = r15_3b_provision;
	}
	public BigDecimal getR15_3c_provision() {
		return r15_3c_provision;
	}
	public void setR15_3c_provision(BigDecimal r15_3c_provision) {
		this.r15_3c_provision = r15_3c_provision;
	}
	public BigDecimal getR15_current() {
		return r15_current;
	}
	public void setR15_current(BigDecimal r15_current) {
		this.r15_current = r15_current;
	}
	public BigDecimal getR15_lessthan_30() {
		return r15_lessthan_30;
	}
	public void setR15_lessthan_30(BigDecimal r15_lessthan_30) {
		this.r15_lessthan_30 = r15_lessthan_30;
	}
	public BigDecimal getR15_exclusive_90days() {
		return r15_exclusive_90days;
	}
	public void setR15_exclusive_90days(BigDecimal r15_exclusive_90days) {
		this.r15_exclusive_90days = r15_exclusive_90days;
	}
	public BigDecimal getR15_exclusive_120days() {
		return r15_exclusive_120days;
	}
	public void setR15_exclusive_120days(BigDecimal r15_exclusive_120days) {
		this.r15_exclusive_120days = r15_exclusive_120days;
	}
	public BigDecimal getR15_exclusive_180days() {
		return r15_exclusive_180days;
	}
	public void setR15_exclusive_180days(BigDecimal r15_exclusive_180days) {
		this.r15_exclusive_180days = r15_exclusive_180days;
	}
	public BigDecimal getR15_exclusive_over_180days() {
		return r15_exclusive_over_180days;
	}
	public void setR15_exclusive_over_180days(BigDecimal r15_exclusive_over_180days) {
		this.r15_exclusive_over_180days = r15_exclusive_over_180days;
	}
	public BigDecimal getR15_total_past() {
		return r15_total_past;
	}
	public void setR15_total_past(BigDecimal r15_total_past) {
		this.r15_total_past = r15_total_past;
	}
	public BigDecimal getR15_new_stage3() {
		return r15_new_stage3;
	}
	public void setR15_new_stage3(BigDecimal r15_new_stage3) {
		this.r15_new_stage3 = r15_new_stage3;
	}
	public BigDecimal getR15_new_specific() {
		return r15_new_specific;
	}
	public void setR15_new_specific(BigDecimal r15_new_specific) {
		this.r15_new_specific = r15_new_specific;
	}
	public BigDecimal getR15_new_other() {
		return r15_new_other;
	}
	public void setR15_new_other(BigDecimal r15_new_other) {
		this.r15_new_other = r15_new_other;
	}
	public BigDecimal getR15_performing_accounts() {
		return r15_performing_accounts;
	}
	public void setR15_performing_accounts(BigDecimal r15_performing_accounts) {
		this.r15_performing_accounts = r15_performing_accounts;
	}
	public BigDecimal getR15_non_performing_accounts() {
		return r15_non_performing_accounts;
	}
	public void setR15_non_performing_accounts(BigDecimal r15_non_performing_accounts) {
		this.r15_non_performing_accounts = r15_non_performing_accounts;
	}
	public String getR15_outstanding_check() {
		return r15_outstanding_check;
	}
	public void setR15_outstanding_check(String r15_outstanding_check) {
		this.r15_outstanding_check = r15_outstanding_check;
	}
	public String getR15_provision_check() {
		return r15_provision_check;
	}
	public void setR15_provision_check(String r15_provision_check) {
		this.r15_provision_check = r15_provision_check;
	}
	public String getR15_past_due_date() {
		return r15_past_due_date;
	}
	public void setR15_past_due_date(String r15_past_due_date) {
		this.r15_past_due_date = r15_past_due_date;
	}
	public String getR16_asset_classes() {
		return r16_asset_classes;
	}
	public void setR16_asset_classes(String r16_asset_classes) {
		this.r16_asset_classes = r16_asset_classes;
	}
	public BigDecimal getR16_outstanding_balance() {
		return r16_outstanding_balance;
	}
	public void setR16_outstanding_balance(BigDecimal r16_outstanding_balance) {
		this.r16_outstanding_balance = r16_outstanding_balance;
	}
	public BigDecimal getR16_provision_suspense() {
		return r16_provision_suspense;
	}
	public void setR16_provision_suspense(BigDecimal r16_provision_suspense) {
		this.r16_provision_suspense = r16_provision_suspense;
	}
	public BigDecimal getR16_stage3_provision() {
		return r16_stage3_provision;
	}
	public void setR16_stage3_provision(BigDecimal r16_stage3_provision) {
		this.r16_stage3_provision = r16_stage3_provision;
	}
	public BigDecimal getR16_other_alloate() {
		return r16_other_alloate;
	}
	public void setR16_other_alloate(BigDecimal r16_other_alloate) {
		this.r16_other_alloate = r16_other_alloate;
	}
	public BigDecimal getR16_1_asset() {
		return r16_1_asset;
	}
	public void setR16_1_asset(BigDecimal r16_1_asset) {
		this.r16_1_asset = r16_1_asset;
	}
	public BigDecimal getR16_2_asset() {
		return r16_2_asset;
	}
	public void setR16_2_asset(BigDecimal r16_2_asset) {
		this.r16_2_asset = r16_2_asset;
	}
	public BigDecimal getR16_3a_asset() {
		return r16_3a_asset;
	}
	public void setR16_3a_asset(BigDecimal r16_3a_asset) {
		this.r16_3a_asset = r16_3a_asset;
	}
	public BigDecimal getR16_3b_asset() {
		return r16_3b_asset;
	}
	public void setR16_3b_asset(BigDecimal r16_3b_asset) {
		this.r16_3b_asset = r16_3b_asset;
	}
	public BigDecimal getR16_3c_asset() {
		return r16_3c_asset;
	}
	public void setR16_3c_asset(BigDecimal r16_3c_asset) {
		this.r16_3c_asset = r16_3c_asset;
	}
	public BigDecimal getR16_1_provision() {
		return r16_1_provision;
	}
	public void setR16_1_provision(BigDecimal r16_1_provision) {
		this.r16_1_provision = r16_1_provision;
	}
	public BigDecimal getR16_2_provision() {
		return r16_2_provision;
	}
	public void setR16_2_provision(BigDecimal r16_2_provision) {
		this.r16_2_provision = r16_2_provision;
	}
	public BigDecimal getR16_3a_provision() {
		return r16_3a_provision;
	}
	public void setR16_3a_provision(BigDecimal r16_3a_provision) {
		this.r16_3a_provision = r16_3a_provision;
	}
	public BigDecimal getR16_3b_provision() {
		return r16_3b_provision;
	}
	public void setR16_3b_provision(BigDecimal r16_3b_provision) {
		this.r16_3b_provision = r16_3b_provision;
	}
	public BigDecimal getR16_3c_provision() {
		return r16_3c_provision;
	}
	public void setR16_3c_provision(BigDecimal r16_3c_provision) {
		this.r16_3c_provision = r16_3c_provision;
	}
	public BigDecimal getR16_current() {
		return r16_current;
	}
	public void setR16_current(BigDecimal r16_current) {
		this.r16_current = r16_current;
	}
	public BigDecimal getR16_lessthan_30() {
		return r16_lessthan_30;
	}
	public void setR16_lessthan_30(BigDecimal r16_lessthan_30) {
		this.r16_lessthan_30 = r16_lessthan_30;
	}
	public BigDecimal getR16_exclusive_90days() {
		return r16_exclusive_90days;
	}
	public void setR16_exclusive_90days(BigDecimal r16_exclusive_90days) {
		this.r16_exclusive_90days = r16_exclusive_90days;
	}
	public BigDecimal getR16_exclusive_120days() {
		return r16_exclusive_120days;
	}
	public void setR16_exclusive_120days(BigDecimal r16_exclusive_120days) {
		this.r16_exclusive_120days = r16_exclusive_120days;
	}
	public BigDecimal getR16_exclusive_180days() {
		return r16_exclusive_180days;
	}
	public void setR16_exclusive_180days(BigDecimal r16_exclusive_180days) {
		this.r16_exclusive_180days = r16_exclusive_180days;
	}
	public BigDecimal getR16_exclusive_over_180days() {
		return r16_exclusive_over_180days;
	}
	public void setR16_exclusive_over_180days(BigDecimal r16_exclusive_over_180days) {
		this.r16_exclusive_over_180days = r16_exclusive_over_180days;
	}
	public BigDecimal getR16_total_past() {
		return r16_total_past;
	}
	public void setR16_total_past(BigDecimal r16_total_past) {
		this.r16_total_past = r16_total_past;
	}
	public BigDecimal getR16_new_stage3() {
		return r16_new_stage3;
	}
	public void setR16_new_stage3(BigDecimal r16_new_stage3) {
		this.r16_new_stage3 = r16_new_stage3;
	}
	public BigDecimal getR16_new_specific() {
		return r16_new_specific;
	}
	public void setR16_new_specific(BigDecimal r16_new_specific) {
		this.r16_new_specific = r16_new_specific;
	}
	public BigDecimal getR16_new_other() {
		return r16_new_other;
	}
	public void setR16_new_other(BigDecimal r16_new_other) {
		this.r16_new_other = r16_new_other;
	}
	public BigDecimal getR16_performing_accounts() {
		return r16_performing_accounts;
	}
	public void setR16_performing_accounts(BigDecimal r16_performing_accounts) {
		this.r16_performing_accounts = r16_performing_accounts;
	}
	public BigDecimal getR16_non_performing_accounts() {
		return r16_non_performing_accounts;
	}
	public void setR16_non_performing_accounts(BigDecimal r16_non_performing_accounts) {
		this.r16_non_performing_accounts = r16_non_performing_accounts;
	}
	public String getR16_outstanding_check() {
		return r16_outstanding_check;
	}
	public void setR16_outstanding_check(String r16_outstanding_check) {
		this.r16_outstanding_check = r16_outstanding_check;
	}
	public String getR16_provision_check() {
		return r16_provision_check;
	}
	public void setR16_provision_check(String r16_provision_check) {
		this.r16_provision_check = r16_provision_check;
	}
	public String getR16_past_due_date() {
		return r16_past_due_date;
	}
	public void setR16_past_due_date(String r16_past_due_date) {
		this.r16_past_due_date = r16_past_due_date;
	}
	public String getR17_asset_classes() {
		return r17_asset_classes;
	}
	public void setR17_asset_classes(String r17_asset_classes) {
		this.r17_asset_classes = r17_asset_classes;
	}
	public BigDecimal getR17_outstanding_balance() {
		return r17_outstanding_balance;
	}
	public void setR17_outstanding_balance(BigDecimal r17_outstanding_balance) {
		this.r17_outstanding_balance = r17_outstanding_balance;
	}
	public BigDecimal getR17_provision_suspense() {
		return r17_provision_suspense;
	}
	public void setR17_provision_suspense(BigDecimal r17_provision_suspense) {
		this.r17_provision_suspense = r17_provision_suspense;
	}
	public BigDecimal getR17_stage3_provision() {
		return r17_stage3_provision;
	}
	public void setR17_stage3_provision(BigDecimal r17_stage3_provision) {
		this.r17_stage3_provision = r17_stage3_provision;
	}
	public BigDecimal getR17_other_alloate() {
		return r17_other_alloate;
	}
	public void setR17_other_alloate(BigDecimal r17_other_alloate) {
		this.r17_other_alloate = r17_other_alloate;
	}
	public BigDecimal getR17_1_asset() {
		return r17_1_asset;
	}
	public void setR17_1_asset(BigDecimal r17_1_asset) {
		this.r17_1_asset = r17_1_asset;
	}
	public BigDecimal getR17_2_asset() {
		return r17_2_asset;
	}
	public void setR17_2_asset(BigDecimal r17_2_asset) {
		this.r17_2_asset = r17_2_asset;
	}
	public BigDecimal getR17_3a_asset() {
		return r17_3a_asset;
	}
	public void setR17_3a_asset(BigDecimal r17_3a_asset) {
		this.r17_3a_asset = r17_3a_asset;
	}
	public BigDecimal getR17_3b_asset() {
		return r17_3b_asset;
	}
	public void setR17_3b_asset(BigDecimal r17_3b_asset) {
		this.r17_3b_asset = r17_3b_asset;
	}
	public BigDecimal getR17_3c_asset() {
		return r17_3c_asset;
	}
	public void setR17_3c_asset(BigDecimal r17_3c_asset) {
		this.r17_3c_asset = r17_3c_asset;
	}
	public BigDecimal getR17_1_provision() {
		return r17_1_provision;
	}
	public void setR17_1_provision(BigDecimal r17_1_provision) {
		this.r17_1_provision = r17_1_provision;
	}
	public BigDecimal getR17_2_provision() {
		return r17_2_provision;
	}
	public void setR17_2_provision(BigDecimal r17_2_provision) {
		this.r17_2_provision = r17_2_provision;
	}
	public BigDecimal getR17_3a_provision() {
		return r17_3a_provision;
	}
	public void setR17_3a_provision(BigDecimal r17_3a_provision) {
		this.r17_3a_provision = r17_3a_provision;
	}
	public BigDecimal getR17_3b_provision() {
		return r17_3b_provision;
	}
	public void setR17_3b_provision(BigDecimal r17_3b_provision) {
		this.r17_3b_provision = r17_3b_provision;
	}
	public BigDecimal getR17_3c_provision() {
		return r17_3c_provision;
	}
	public void setR17_3c_provision(BigDecimal r17_3c_provision) {
		this.r17_3c_provision = r17_3c_provision;
	}
	public BigDecimal getR17_current() {
		return r17_current;
	}
	public void setR17_current(BigDecimal r17_current) {
		this.r17_current = r17_current;
	}
	public BigDecimal getR17_lessthan_30() {
		return r17_lessthan_30;
	}
	public void setR17_lessthan_30(BigDecimal r17_lessthan_30) {
		this.r17_lessthan_30 = r17_lessthan_30;
	}
	public BigDecimal getR17_exclusive_90days() {
		return r17_exclusive_90days;
	}
	public void setR17_exclusive_90days(BigDecimal r17_exclusive_90days) {
		this.r17_exclusive_90days = r17_exclusive_90days;
	}
	public BigDecimal getR17_exclusive_120days() {
		return r17_exclusive_120days;
	}
	public void setR17_exclusive_120days(BigDecimal r17_exclusive_120days) {
		this.r17_exclusive_120days = r17_exclusive_120days;
	}
	public BigDecimal getR17_exclusive_180days() {
		return r17_exclusive_180days;
	}
	public void setR17_exclusive_180days(BigDecimal r17_exclusive_180days) {
		this.r17_exclusive_180days = r17_exclusive_180days;
	}
	public BigDecimal getR17_exclusive_over_180days() {
		return r17_exclusive_over_180days;
	}
	public void setR17_exclusive_over_180days(BigDecimal r17_exclusive_over_180days) {
		this.r17_exclusive_over_180days = r17_exclusive_over_180days;
	}
	public BigDecimal getR17_total_past() {
		return r17_total_past;
	}
	public void setR17_total_past(BigDecimal r17_total_past) {
		this.r17_total_past = r17_total_past;
	}
	public BigDecimal getR17_new_stage3() {
		return r17_new_stage3;
	}
	public void setR17_new_stage3(BigDecimal r17_new_stage3) {
		this.r17_new_stage3 = r17_new_stage3;
	}
	public BigDecimal getR17_new_specific() {
		return r17_new_specific;
	}
	public void setR17_new_specific(BigDecimal r17_new_specific) {
		this.r17_new_specific = r17_new_specific;
	}
	public BigDecimal getR17_new_other() {
		return r17_new_other;
	}
	public void setR17_new_other(BigDecimal r17_new_other) {
		this.r17_new_other = r17_new_other;
	}
	public BigDecimal getR17_performing_accounts() {
		return r17_performing_accounts;
	}
	public void setR17_performing_accounts(BigDecimal r17_performing_accounts) {
		this.r17_performing_accounts = r17_performing_accounts;
	}
	public BigDecimal getR17_non_performing_accounts() {
		return r17_non_performing_accounts;
	}
	public void setR17_non_performing_accounts(BigDecimal r17_non_performing_accounts) {
		this.r17_non_performing_accounts = r17_non_performing_accounts;
	}
	public String getR17_outstanding_check() {
		return r17_outstanding_check;
	}
	public void setR17_outstanding_check(String r17_outstanding_check) {
		this.r17_outstanding_check = r17_outstanding_check;
	}
	public String getR17_provision_check() {
		return r17_provision_check;
	}
	public void setR17_provision_check(String r17_provision_check) {
		this.r17_provision_check = r17_provision_check;
	}
	public String getR17_past_due_date() {
		return r17_past_due_date;
	}
	public void setR17_past_due_date(String r17_past_due_date) {
		this.r17_past_due_date = r17_past_due_date;
	}
	public String getR18_asset_classes() {
		return r18_asset_classes;
	}
	public void setR18_asset_classes(String r18_asset_classes) {
		this.r18_asset_classes = r18_asset_classes;
	}
	public BigDecimal getR18_outstanding_balance() {
		return r18_outstanding_balance;
	}
	public void setR18_outstanding_balance(BigDecimal r18_outstanding_balance) {
		this.r18_outstanding_balance = r18_outstanding_balance;
	}
	public BigDecimal getR18_provision_suspense() {
		return r18_provision_suspense;
	}
	public void setR18_provision_suspense(BigDecimal r18_provision_suspense) {
		this.r18_provision_suspense = r18_provision_suspense;
	}
	public BigDecimal getR18_stage3_provision() {
		return r18_stage3_provision;
	}
	public void setR18_stage3_provision(BigDecimal r18_stage3_provision) {
		this.r18_stage3_provision = r18_stage3_provision;
	}
	public BigDecimal getR18_other_alloate() {
		return r18_other_alloate;
	}
	public void setR18_other_alloate(BigDecimal r18_other_alloate) {
		this.r18_other_alloate = r18_other_alloate;
	}
	public BigDecimal getR18_1_asset() {
		return r18_1_asset;
	}
	public void setR18_1_asset(BigDecimal r18_1_asset) {
		this.r18_1_asset = r18_1_asset;
	}
	public BigDecimal getR18_2_asset() {
		return r18_2_asset;
	}
	public void setR18_2_asset(BigDecimal r18_2_asset) {
		this.r18_2_asset = r18_2_asset;
	}
	public BigDecimal getR18_3a_asset() {
		return r18_3a_asset;
	}
	public void setR18_3a_asset(BigDecimal r18_3a_asset) {
		this.r18_3a_asset = r18_3a_asset;
	}
	public BigDecimal getR18_3b_asset() {
		return r18_3b_asset;
	}
	public void setR18_3b_asset(BigDecimal r18_3b_asset) {
		this.r18_3b_asset = r18_3b_asset;
	}
	public BigDecimal getR18_3c_asset() {
		return r18_3c_asset;
	}
	public void setR18_3c_asset(BigDecimal r18_3c_asset) {
		this.r18_3c_asset = r18_3c_asset;
	}
	public BigDecimal getR18_1_provision() {
		return r18_1_provision;
	}
	public void setR18_1_provision(BigDecimal r18_1_provision) {
		this.r18_1_provision = r18_1_provision;
	}
	public BigDecimal getR18_2_provision() {
		return r18_2_provision;
	}
	public void setR18_2_provision(BigDecimal r18_2_provision) {
		this.r18_2_provision = r18_2_provision;
	}
	public BigDecimal getR18_3a_provision() {
		return r18_3a_provision;
	}
	public void setR18_3a_provision(BigDecimal r18_3a_provision) {
		this.r18_3a_provision = r18_3a_provision;
	}
	public BigDecimal getR18_3b_provision() {
		return r18_3b_provision;
	}
	public void setR18_3b_provision(BigDecimal r18_3b_provision) {
		this.r18_3b_provision = r18_3b_provision;
	}
	public BigDecimal getR18_3c_provision() {
		return r18_3c_provision;
	}
	public void setR18_3c_provision(BigDecimal r18_3c_provision) {
		this.r18_3c_provision = r18_3c_provision;
	}
	public BigDecimal getR18_current() {
		return r18_current;
	}
	public void setR18_current(BigDecimal r18_current) {
		this.r18_current = r18_current;
	}
	public BigDecimal getR18_lessthan_30() {
		return r18_lessthan_30;
	}
	public void setR18_lessthan_30(BigDecimal r18_lessthan_30) {
		this.r18_lessthan_30 = r18_lessthan_30;
	}
	public BigDecimal getR18_exclusive_90days() {
		return r18_exclusive_90days;
	}
	public void setR18_exclusive_90days(BigDecimal r18_exclusive_90days) {
		this.r18_exclusive_90days = r18_exclusive_90days;
	}
	public BigDecimal getR18_exclusive_120days() {
		return r18_exclusive_120days;
	}
	public void setR18_exclusive_120days(BigDecimal r18_exclusive_120days) {
		this.r18_exclusive_120days = r18_exclusive_120days;
	}
	public BigDecimal getR18_exclusive_180days() {
		return r18_exclusive_180days;
	}
	public void setR18_exclusive_180days(BigDecimal r18_exclusive_180days) {
		this.r18_exclusive_180days = r18_exclusive_180days;
	}
	public BigDecimal getR18_exclusive_over_180days() {
		return r18_exclusive_over_180days;
	}
	public void setR18_exclusive_over_180days(BigDecimal r18_exclusive_over_180days) {
		this.r18_exclusive_over_180days = r18_exclusive_over_180days;
	}
	public BigDecimal getR18_total_past() {
		return r18_total_past;
	}
	public void setR18_total_past(BigDecimal r18_total_past) {
		this.r18_total_past = r18_total_past;
	}
	public BigDecimal getR18_new_stage3() {
		return r18_new_stage3;
	}
	public void setR18_new_stage3(BigDecimal r18_new_stage3) {
		this.r18_new_stage3 = r18_new_stage3;
	}
	public BigDecimal getR18_new_specific() {
		return r18_new_specific;
	}
	public void setR18_new_specific(BigDecimal r18_new_specific) {
		this.r18_new_specific = r18_new_specific;
	}
	public BigDecimal getR18_new_other() {
		return r18_new_other;
	}
	public void setR18_new_other(BigDecimal r18_new_other) {
		this.r18_new_other = r18_new_other;
	}
	public BigDecimal getR18_performing_accounts() {
		return r18_performing_accounts;
	}
	public void setR18_performing_accounts(BigDecimal r18_performing_accounts) {
		this.r18_performing_accounts = r18_performing_accounts;
	}
	public BigDecimal getR18_non_performing_accounts() {
		return r18_non_performing_accounts;
	}
	public void setR18_non_performing_accounts(BigDecimal r18_non_performing_accounts) {
		this.r18_non_performing_accounts = r18_non_performing_accounts;
	}
	public String getR18_outstanding_check() {
		return r18_outstanding_check;
	}
	public void setR18_outstanding_check(String r18_outstanding_check) {
		this.r18_outstanding_check = r18_outstanding_check;
	}
	public String getR18_provision_check() {
		return r18_provision_check;
	}
	public void setR18_provision_check(String r18_provision_check) {
		this.r18_provision_check = r18_provision_check;
	}
	public String getR18_past_due_date() {
		return r18_past_due_date;
	}
	public void setR18_past_due_date(String r18_past_due_date) {
		this.r18_past_due_date = r18_past_due_date;
	}
	public String getR19_asset_classes() {
		return r19_asset_classes;
	}
	public void setR19_asset_classes(String r19_asset_classes) {
		this.r19_asset_classes = r19_asset_classes;
	}
	public BigDecimal getR19_outstanding_balance() {
		return r19_outstanding_balance;
	}
	public void setR19_outstanding_balance(BigDecimal r19_outstanding_balance) {
		this.r19_outstanding_balance = r19_outstanding_balance;
	}
	public BigDecimal getR19_provision_suspense() {
		return r19_provision_suspense;
	}
	public void setR19_provision_suspense(BigDecimal r19_provision_suspense) {
		this.r19_provision_suspense = r19_provision_suspense;
	}
	public BigDecimal getR19_stage3_provision() {
		return r19_stage3_provision;
	}
	public void setR19_stage3_provision(BigDecimal r19_stage3_provision) {
		this.r19_stage3_provision = r19_stage3_provision;
	}
	public BigDecimal getR19_other_alloate() {
		return r19_other_alloate;
	}
	public void setR19_other_alloate(BigDecimal r19_other_alloate) {
		this.r19_other_alloate = r19_other_alloate;
	}
	public BigDecimal getR19_1_asset() {
		return r19_1_asset;
	}
	public void setR19_1_asset(BigDecimal r19_1_asset) {
		this.r19_1_asset = r19_1_asset;
	}
	public BigDecimal getR19_2_asset() {
		return r19_2_asset;
	}
	public void setR19_2_asset(BigDecimal r19_2_asset) {
		this.r19_2_asset = r19_2_asset;
	}
	public BigDecimal getR19_3a_asset() {
		return r19_3a_asset;
	}
	public void setR19_3a_asset(BigDecimal r19_3a_asset) {
		this.r19_3a_asset = r19_3a_asset;
	}
	public BigDecimal getR19_3b_asset() {
		return r19_3b_asset;
	}
	public void setR19_3b_asset(BigDecimal r19_3b_asset) {
		this.r19_3b_asset = r19_3b_asset;
	}
	public BigDecimal getR19_3c_asset() {
		return r19_3c_asset;
	}
	public void setR19_3c_asset(BigDecimal r19_3c_asset) {
		this.r19_3c_asset = r19_3c_asset;
	}
	public BigDecimal getR19_1_provision() {
		return r19_1_provision;
	}
	public void setR19_1_provision(BigDecimal r19_1_provision) {
		this.r19_1_provision = r19_1_provision;
	}
	public BigDecimal getR19_2_provision() {
		return r19_2_provision;
	}
	public void setR19_2_provision(BigDecimal r19_2_provision) {
		this.r19_2_provision = r19_2_provision;
	}
	public BigDecimal getR19_3a_provision() {
		return r19_3a_provision;
	}
	public void setR19_3a_provision(BigDecimal r19_3a_provision) {
		this.r19_3a_provision = r19_3a_provision;
	}
	public BigDecimal getR19_3b_provision() {
		return r19_3b_provision;
	}
	public void setR19_3b_provision(BigDecimal r19_3b_provision) {
		this.r19_3b_provision = r19_3b_provision;
	}
	public BigDecimal getR19_3c_provision() {
		return r19_3c_provision;
	}
	public void setR19_3c_provision(BigDecimal r19_3c_provision) {
		this.r19_3c_provision = r19_3c_provision;
	}
	public BigDecimal getR19_current() {
		return r19_current;
	}
	public void setR19_current(BigDecimal r19_current) {
		this.r19_current = r19_current;
	}
	public BigDecimal getR19_lessthan_30() {
		return r19_lessthan_30;
	}
	public void setR19_lessthan_30(BigDecimal r19_lessthan_30) {
		this.r19_lessthan_30 = r19_lessthan_30;
	}
	public BigDecimal getR19_exclusive_90days() {
		return r19_exclusive_90days;
	}
	public void setR19_exclusive_90days(BigDecimal r19_exclusive_90days) {
		this.r19_exclusive_90days = r19_exclusive_90days;
	}
	public BigDecimal getR19_exclusive_120days() {
		return r19_exclusive_120days;
	}
	public void setR19_exclusive_120days(BigDecimal r19_exclusive_120days) {
		this.r19_exclusive_120days = r19_exclusive_120days;
	}
	public BigDecimal getR19_exclusive_180days() {
		return r19_exclusive_180days;
	}
	public void setR19_exclusive_180days(BigDecimal r19_exclusive_180days) {
		this.r19_exclusive_180days = r19_exclusive_180days;
	}
	public BigDecimal getR19_exclusive_over_180days() {
		return r19_exclusive_over_180days;
	}
	public void setR19_exclusive_over_180days(BigDecimal r19_exclusive_over_180days) {
		this.r19_exclusive_over_180days = r19_exclusive_over_180days;
	}
	public BigDecimal getR19_total_past() {
		return r19_total_past;
	}
	public void setR19_total_past(BigDecimal r19_total_past) {
		this.r19_total_past = r19_total_past;
	}
	public BigDecimal getR19_new_stage3() {
		return r19_new_stage3;
	}
	public void setR19_new_stage3(BigDecimal r19_new_stage3) {
		this.r19_new_stage3 = r19_new_stage3;
	}
	public BigDecimal getR19_new_specific() {
		return r19_new_specific;
	}
	public void setR19_new_specific(BigDecimal r19_new_specific) {
		this.r19_new_specific = r19_new_specific;
	}
	public BigDecimal getR19_new_other() {
		return r19_new_other;
	}
	public void setR19_new_other(BigDecimal r19_new_other) {
		this.r19_new_other = r19_new_other;
	}
	public BigDecimal getR19_performing_accounts() {
		return r19_performing_accounts;
	}
	public void setR19_performing_accounts(BigDecimal r19_performing_accounts) {
		this.r19_performing_accounts = r19_performing_accounts;
	}
	public BigDecimal getR19_non_performing_accounts() {
		return r19_non_performing_accounts;
	}
	public void setR19_non_performing_accounts(BigDecimal r19_non_performing_accounts) {
		this.r19_non_performing_accounts = r19_non_performing_accounts;
	}
	public String getR19_outstanding_check() {
		return r19_outstanding_check;
	}
	public void setR19_outstanding_check(String r19_outstanding_check) {
		this.r19_outstanding_check = r19_outstanding_check;
	}
	public String getR19_provision_check() {
		return r19_provision_check;
	}
	public void setR19_provision_check(String r19_provision_check) {
		this.r19_provision_check = r19_provision_check;
	}
	public String getR19_past_due_date() {
		return r19_past_due_date;
	}
	public void setR19_past_due_date(String r19_past_due_date) {
		this.r19_past_due_date = r19_past_due_date;
	}
	public String getR20_asset_classes() {
		return r20_asset_classes;
	}
	public void setR20_asset_classes(String r20_asset_classes) {
		this.r20_asset_classes = r20_asset_classes;
	}
	public BigDecimal getR20_outstanding_balance() {
		return r20_outstanding_balance;
	}
	public void setR20_outstanding_balance(BigDecimal r20_outstanding_balance) {
		this.r20_outstanding_balance = r20_outstanding_balance;
	}
	public BigDecimal getR20_provision_suspense() {
		return r20_provision_suspense;
	}
	public void setR20_provision_suspense(BigDecimal r20_provision_suspense) {
		this.r20_provision_suspense = r20_provision_suspense;
	}
	public BigDecimal getR20_stage3_provision() {
		return r20_stage3_provision;
	}
	public void setR20_stage3_provision(BigDecimal r20_stage3_provision) {
		this.r20_stage3_provision = r20_stage3_provision;
	}
	public BigDecimal getR20_other_alloate() {
		return r20_other_alloate;
	}
	public void setR20_other_alloate(BigDecimal r20_other_alloate) {
		this.r20_other_alloate = r20_other_alloate;
	}
	public BigDecimal getR20_1_asset() {
		return r20_1_asset;
	}
	public void setR20_1_asset(BigDecimal r20_1_asset) {
		this.r20_1_asset = r20_1_asset;
	}
	public BigDecimal getR20_2_asset() {
		return r20_2_asset;
	}
	public void setR20_2_asset(BigDecimal r20_2_asset) {
		this.r20_2_asset = r20_2_asset;
	}
	public BigDecimal getR20_3a_asset() {
		return r20_3a_asset;
	}
	public void setR20_3a_asset(BigDecimal r20_3a_asset) {
		this.r20_3a_asset = r20_3a_asset;
	}
	public BigDecimal getR20_3b_asset() {
		return r20_3b_asset;
	}
	public void setR20_3b_asset(BigDecimal r20_3b_asset) {
		this.r20_3b_asset = r20_3b_asset;
	}
	public BigDecimal getR20_3c_asset() {
		return r20_3c_asset;
	}
	public void setR20_3c_asset(BigDecimal r20_3c_asset) {
		this.r20_3c_asset = r20_3c_asset;
	}
	public BigDecimal getR20_1_provision() {
		return r20_1_provision;
	}
	public void setR20_1_provision(BigDecimal r20_1_provision) {
		this.r20_1_provision = r20_1_provision;
	}
	public BigDecimal getR20_2_provision() {
		return r20_2_provision;
	}
	public void setR20_2_provision(BigDecimal r20_2_provision) {
		this.r20_2_provision = r20_2_provision;
	}
	public BigDecimal getR20_3a_provision() {
		return r20_3a_provision;
	}
	public void setR20_3a_provision(BigDecimal r20_3a_provision) {
		this.r20_3a_provision = r20_3a_provision;
	}
	public BigDecimal getR20_3b_provision() {
		return r20_3b_provision;
	}
	public void setR20_3b_provision(BigDecimal r20_3b_provision) {
		this.r20_3b_provision = r20_3b_provision;
	}
	public BigDecimal getR20_3c_provision() {
		return r20_3c_provision;
	}
	public void setR20_3c_provision(BigDecimal r20_3c_provision) {
		this.r20_3c_provision = r20_3c_provision;
	}
	public BigDecimal getR20_current() {
		return r20_current;
	}
	public void setR20_current(BigDecimal r20_current) {
		this.r20_current = r20_current;
	}
	public BigDecimal getR20_lessthan_30() {
		return r20_lessthan_30;
	}
	public void setR20_lessthan_30(BigDecimal r20_lessthan_30) {
		this.r20_lessthan_30 = r20_lessthan_30;
	}
	public BigDecimal getR20_exclusive_90days() {
		return r20_exclusive_90days;
	}
	public void setR20_exclusive_90days(BigDecimal r20_exclusive_90days) {
		this.r20_exclusive_90days = r20_exclusive_90days;
	}
	public BigDecimal getR20_exclusive_120days() {
		return r20_exclusive_120days;
	}
	public void setR20_exclusive_120days(BigDecimal r20_exclusive_120days) {
		this.r20_exclusive_120days = r20_exclusive_120days;
	}
	public BigDecimal getR20_exclusive_180days() {
		return r20_exclusive_180days;
	}
	public void setR20_exclusive_180days(BigDecimal r20_exclusive_180days) {
		this.r20_exclusive_180days = r20_exclusive_180days;
	}
	public BigDecimal getR20_exclusive_over_180days() {
		return r20_exclusive_over_180days;
	}
	public void setR20_exclusive_over_180days(BigDecimal r20_exclusive_over_180days) {
		this.r20_exclusive_over_180days = r20_exclusive_over_180days;
	}
	public BigDecimal getR20_total_past() {
		return r20_total_past;
	}
	public void setR20_total_past(BigDecimal r20_total_past) {
		this.r20_total_past = r20_total_past;
	}
	public BigDecimal getR20_new_stage3() {
		return r20_new_stage3;
	}
	public void setR20_new_stage3(BigDecimal r20_new_stage3) {
		this.r20_new_stage3 = r20_new_stage3;
	}
	public BigDecimal getR20_new_specific() {
		return r20_new_specific;
	}
	public void setR20_new_specific(BigDecimal r20_new_specific) {
		this.r20_new_specific = r20_new_specific;
	}
	public BigDecimal getR20_new_other() {
		return r20_new_other;
	}
	public void setR20_new_other(BigDecimal r20_new_other) {
		this.r20_new_other = r20_new_other;
	}
	public BigDecimal getR20_performing_accounts() {
		return r20_performing_accounts;
	}
	public void setR20_performing_accounts(BigDecimal r20_performing_accounts) {
		this.r20_performing_accounts = r20_performing_accounts;
	}
	public BigDecimal getR20_non_performing_accounts() {
		return r20_non_performing_accounts;
	}
	public void setR20_non_performing_accounts(BigDecimal r20_non_performing_accounts) {
		this.r20_non_performing_accounts = r20_non_performing_accounts;
	}
	public String getR20_outstanding_check() {
		return r20_outstanding_check;
	}
	public void setR20_outstanding_check(String r20_outstanding_check) {
		this.r20_outstanding_check = r20_outstanding_check;
	}
	public String getR20_provision_check() {
		return r20_provision_check;
	}
	public void setR20_provision_check(String r20_provision_check) {
		this.r20_provision_check = r20_provision_check;
	}
	public String getR20_past_due_date() {
		return r20_past_due_date;
	}
	public void setR20_past_due_date(String r20_past_due_date) {
		this.r20_past_due_date = r20_past_due_date;
	}
	public String getR21_asset_classes() {
		return r21_asset_classes;
	}
	public void setR21_asset_classes(String r21_asset_classes) {
		this.r21_asset_classes = r21_asset_classes;
	}
	public BigDecimal getR21_outstanding_balance() {
		return r21_outstanding_balance;
	}
	public void setR21_outstanding_balance(BigDecimal r21_outstanding_balance) {
		this.r21_outstanding_balance = r21_outstanding_balance;
	}
	public BigDecimal getR21_provision_suspense() {
		return r21_provision_suspense;
	}
	public void setR21_provision_suspense(BigDecimal r21_provision_suspense) {
		this.r21_provision_suspense = r21_provision_suspense;
	}
	public BigDecimal getR21_stage3_provision() {
		return r21_stage3_provision;
	}
	public void setR21_stage3_provision(BigDecimal r21_stage3_provision) {
		this.r21_stage3_provision = r21_stage3_provision;
	}
	public BigDecimal getR21_other_alloate() {
		return r21_other_alloate;
	}
	public void setR21_other_alloate(BigDecimal r21_other_alloate) {
		this.r21_other_alloate = r21_other_alloate;
	}
	public BigDecimal getR21_1_asset() {
		return r21_1_asset;
	}
	public void setR21_1_asset(BigDecimal r21_1_asset) {
		this.r21_1_asset = r21_1_asset;
	}
	public BigDecimal getR21_2_asset() {
		return r21_2_asset;
	}
	public void setR21_2_asset(BigDecimal r21_2_asset) {
		this.r21_2_asset = r21_2_asset;
	}
	public BigDecimal getR21_3a_asset() {
		return r21_3a_asset;
	}
	public void setR21_3a_asset(BigDecimal r21_3a_asset) {
		this.r21_3a_asset = r21_3a_asset;
	}
	public BigDecimal getR21_3b_asset() {
		return r21_3b_asset;
	}
	public void setR21_3b_asset(BigDecimal r21_3b_asset) {
		this.r21_3b_asset = r21_3b_asset;
	}
	public BigDecimal getR21_3c_asset() {
		return r21_3c_asset;
	}
	public void setR21_3c_asset(BigDecimal r21_3c_asset) {
		this.r21_3c_asset = r21_3c_asset;
	}
	public BigDecimal getR21_1_provision() {
		return r21_1_provision;
	}
	public void setR21_1_provision(BigDecimal r21_1_provision) {
		this.r21_1_provision = r21_1_provision;
	}
	public BigDecimal getR21_2_provision() {
		return r21_2_provision;
	}
	public void setR21_2_provision(BigDecimal r21_2_provision) {
		this.r21_2_provision = r21_2_provision;
	}
	public BigDecimal getR21_3a_provision() {
		return r21_3a_provision;
	}
	public void setR21_3a_provision(BigDecimal r21_3a_provision) {
		this.r21_3a_provision = r21_3a_provision;
	}
	public BigDecimal getR21_3b_provision() {
		return r21_3b_provision;
	}
	public void setR21_3b_provision(BigDecimal r21_3b_provision) {
		this.r21_3b_provision = r21_3b_provision;
	}
	public BigDecimal getR21_3c_provision() {
		return r21_3c_provision;
	}
	public void setR21_3c_provision(BigDecimal r21_3c_provision) {
		this.r21_3c_provision = r21_3c_provision;
	}
	public BigDecimal getR21_current() {
		return r21_current;
	}
	public void setR21_current(BigDecimal r21_current) {
		this.r21_current = r21_current;
	}
	public BigDecimal getR21_lessthan_30() {
		return r21_lessthan_30;
	}
	public void setR21_lessthan_30(BigDecimal r21_lessthan_30) {
		this.r21_lessthan_30 = r21_lessthan_30;
	}
	public BigDecimal getR21_exclusive_90days() {
		return r21_exclusive_90days;
	}
	public void setR21_exclusive_90days(BigDecimal r21_exclusive_90days) {
		this.r21_exclusive_90days = r21_exclusive_90days;
	}
	public BigDecimal getR21_exclusive_120days() {
		return r21_exclusive_120days;
	}
	public void setR21_exclusive_120days(BigDecimal r21_exclusive_120days) {
		this.r21_exclusive_120days = r21_exclusive_120days;
	}
	public BigDecimal getR21_exclusive_180days() {
		return r21_exclusive_180days;
	}
	public void setR21_exclusive_180days(BigDecimal r21_exclusive_180days) {
		this.r21_exclusive_180days = r21_exclusive_180days;
	}
	public BigDecimal getR21_exclusive_over_180days() {
		return r21_exclusive_over_180days;
	}
	public void setR21_exclusive_over_180days(BigDecimal r21_exclusive_over_180days) {
		this.r21_exclusive_over_180days = r21_exclusive_over_180days;
	}
	public BigDecimal getR21_total_past() {
		return r21_total_past;
	}
	public void setR21_total_past(BigDecimal r21_total_past) {
		this.r21_total_past = r21_total_past;
	}
	public BigDecimal getR21_new_stage3() {
		return r21_new_stage3;
	}
	public void setR21_new_stage3(BigDecimal r21_new_stage3) {
		this.r21_new_stage3 = r21_new_stage3;
	}
	public BigDecimal getR21_new_specific() {
		return r21_new_specific;
	}
	public void setR21_new_specific(BigDecimal r21_new_specific) {
		this.r21_new_specific = r21_new_specific;
	}
	public BigDecimal getR21_new_other() {
		return r21_new_other;
	}
	public void setR21_new_other(BigDecimal r21_new_other) {
		this.r21_new_other = r21_new_other;
	}
	public BigDecimal getR21_performing_accounts() {
		return r21_performing_accounts;
	}
	public void setR21_performing_accounts(BigDecimal r21_performing_accounts) {
		this.r21_performing_accounts = r21_performing_accounts;
	}
	public BigDecimal getR21_non_performing_accounts() {
		return r21_non_performing_accounts;
	}
	public void setR21_non_performing_accounts(BigDecimal r21_non_performing_accounts) {
		this.r21_non_performing_accounts = r21_non_performing_accounts;
	}
	public String getR21_outstanding_check() {
		return r21_outstanding_check;
	}
	public void setR21_outstanding_check(String r21_outstanding_check) {
		this.r21_outstanding_check = r21_outstanding_check;
	}
	public String getR21_provision_check() {
		return r21_provision_check;
	}
	public void setR21_provision_check(String r21_provision_check) {
		this.r21_provision_check = r21_provision_check;
	}
	public String getR21_past_due_date() {
		return r21_past_due_date;
	}
	public void setR21_past_due_date(String r21_past_due_date) {
		this.r21_past_due_date = r21_past_due_date;
	}
	public String getR22_asset_classes() {
		return r22_asset_classes;
	}
	public void setR22_asset_classes(String r22_asset_classes) {
		this.r22_asset_classes = r22_asset_classes;
	}
	public BigDecimal getR22_outstanding_balance() {
		return r22_outstanding_balance;
	}
	public void setR22_outstanding_balance(BigDecimal r22_outstanding_balance) {
		this.r22_outstanding_balance = r22_outstanding_balance;
	}
	public BigDecimal getR22_provision_suspense() {
		return r22_provision_suspense;
	}
	public void setR22_provision_suspense(BigDecimal r22_provision_suspense) {
		this.r22_provision_suspense = r22_provision_suspense;
	}
	public BigDecimal getR22_stage3_provision() {
		return r22_stage3_provision;
	}
	public void setR22_stage3_provision(BigDecimal r22_stage3_provision) {
		this.r22_stage3_provision = r22_stage3_provision;
	}
	public BigDecimal getR22_other_alloate() {
		return r22_other_alloate;
	}
	public void setR22_other_alloate(BigDecimal r22_other_alloate) {
		this.r22_other_alloate = r22_other_alloate;
	}
	public BigDecimal getR22_1_asset() {
		return r22_1_asset;
	}
	public void setR22_1_asset(BigDecimal r22_1_asset) {
		this.r22_1_asset = r22_1_asset;
	}
	public BigDecimal getR22_2_asset() {
		return r22_2_asset;
	}
	public void setR22_2_asset(BigDecimal r22_2_asset) {
		this.r22_2_asset = r22_2_asset;
	}
	public BigDecimal getR22_3a_asset() {
		return r22_3a_asset;
	}
	public void setR22_3a_asset(BigDecimal r22_3a_asset) {
		this.r22_3a_asset = r22_3a_asset;
	}
	public BigDecimal getR22_3b_asset() {
		return r22_3b_asset;
	}
	public void setR22_3b_asset(BigDecimal r22_3b_asset) {
		this.r22_3b_asset = r22_3b_asset;
	}
	public BigDecimal getR22_3c_asset() {
		return r22_3c_asset;
	}
	public void setR22_3c_asset(BigDecimal r22_3c_asset) {
		this.r22_3c_asset = r22_3c_asset;
	}
	public BigDecimal getR22_1_provision() {
		return r22_1_provision;
	}
	public void setR22_1_provision(BigDecimal r22_1_provision) {
		this.r22_1_provision = r22_1_provision;
	}
	public BigDecimal getR22_2_provision() {
		return r22_2_provision;
	}
	public void setR22_2_provision(BigDecimal r22_2_provision) {
		this.r22_2_provision = r22_2_provision;
	}
	public BigDecimal getR22_3a_provision() {
		return r22_3a_provision;
	}
	public void setR22_3a_provision(BigDecimal r22_3a_provision) {
		this.r22_3a_provision = r22_3a_provision;
	}
	public BigDecimal getR22_3b_provision() {
		return r22_3b_provision;
	}
	public void setR22_3b_provision(BigDecimal r22_3b_provision) {
		this.r22_3b_provision = r22_3b_provision;
	}
	public BigDecimal getR22_3c_provision() {
		return r22_3c_provision;
	}
	public void setR22_3c_provision(BigDecimal r22_3c_provision) {
		this.r22_3c_provision = r22_3c_provision;
	}
	public BigDecimal getR22_current() {
		return r22_current;
	}
	public void setR22_current(BigDecimal r22_current) {
		this.r22_current = r22_current;
	}
	public BigDecimal getR22_lessthan_30() {
		return r22_lessthan_30;
	}
	public void setR22_lessthan_30(BigDecimal r22_lessthan_30) {
		this.r22_lessthan_30 = r22_lessthan_30;
	}
	public BigDecimal getR22_exclusive_90days() {
		return r22_exclusive_90days;
	}
	public void setR22_exclusive_90days(BigDecimal r22_exclusive_90days) {
		this.r22_exclusive_90days = r22_exclusive_90days;
	}
	public BigDecimal getR22_exclusive_120days() {
		return r22_exclusive_120days;
	}
	public void setR22_exclusive_120days(BigDecimal r22_exclusive_120days) {
		this.r22_exclusive_120days = r22_exclusive_120days;
	}
	public BigDecimal getR22_exclusive_180days() {
		return r22_exclusive_180days;
	}
	public void setR22_exclusive_180days(BigDecimal r22_exclusive_180days) {
		this.r22_exclusive_180days = r22_exclusive_180days;
	}
	public BigDecimal getR22_exclusive_over_180days() {
		return r22_exclusive_over_180days;
	}
	public void setR22_exclusive_over_180days(BigDecimal r22_exclusive_over_180days) {
		this.r22_exclusive_over_180days = r22_exclusive_over_180days;
	}
	public BigDecimal getR22_total_past() {
		return r22_total_past;
	}
	public void setR22_total_past(BigDecimal r22_total_past) {
		this.r22_total_past = r22_total_past;
	}
	public BigDecimal getR22_new_stage3() {
		return r22_new_stage3;
	}
	public void setR22_new_stage3(BigDecimal r22_new_stage3) {
		this.r22_new_stage3 = r22_new_stage3;
	}
	public BigDecimal getR22_new_specific() {
		return r22_new_specific;
	}
	public void setR22_new_specific(BigDecimal r22_new_specific) {
		this.r22_new_specific = r22_new_specific;
	}
	public BigDecimal getR22_new_other() {
		return r22_new_other;
	}
	public void setR22_new_other(BigDecimal r22_new_other) {
		this.r22_new_other = r22_new_other;
	}
	public BigDecimal getR22_performing_accounts() {
		return r22_performing_accounts;
	}
	public void setR22_performing_accounts(BigDecimal r22_performing_accounts) {
		this.r22_performing_accounts = r22_performing_accounts;
	}
	public BigDecimal getR22_non_performing_accounts() {
		return r22_non_performing_accounts;
	}
	public void setR22_non_performing_accounts(BigDecimal r22_non_performing_accounts) {
		this.r22_non_performing_accounts = r22_non_performing_accounts;
	}
	public String getR22_outstanding_check() {
		return r22_outstanding_check;
	}
	public void setR22_outstanding_check(String r22_outstanding_check) {
		this.r22_outstanding_check = r22_outstanding_check;
	}
	public String getR22_provision_check() {
		return r22_provision_check;
	}
	public void setR22_provision_check(String r22_provision_check) {
		this.r22_provision_check = r22_provision_check;
	}
	public String getR22_past_due_date() {
		return r22_past_due_date;
	}
	public void setR22_past_due_date(String r22_past_due_date) {
		this.r22_past_due_date = r22_past_due_date;
	}
	public String getR23_asset_classes() {
		return r23_asset_classes;
	}
	public void setR23_asset_classes(String r23_asset_classes) {
		this.r23_asset_classes = r23_asset_classes;
	}
	public BigDecimal getR23_outstanding_balance() {
		return r23_outstanding_balance;
	}
	public void setR23_outstanding_balance(BigDecimal r23_outstanding_balance) {
		this.r23_outstanding_balance = r23_outstanding_balance;
	}
	public BigDecimal getR23_provision_suspense() {
		return r23_provision_suspense;
	}
	public void setR23_provision_suspense(BigDecimal r23_provision_suspense) {
		this.r23_provision_suspense = r23_provision_suspense;
	}
	public BigDecimal getR23_stage3_provision() {
		return r23_stage3_provision;
	}
	public void setR23_stage3_provision(BigDecimal r23_stage3_provision) {
		this.r23_stage3_provision = r23_stage3_provision;
	}
	public BigDecimal getR23_other_alloate() {
		return r23_other_alloate;
	}
	public void setR23_other_alloate(BigDecimal r23_other_alloate) {
		this.r23_other_alloate = r23_other_alloate;
	}
	public BigDecimal getR23_1_asset() {
		return r23_1_asset;
	}
	public void setR23_1_asset(BigDecimal r23_1_asset) {
		this.r23_1_asset = r23_1_asset;
	}
	public BigDecimal getR23_2_asset() {
		return r23_2_asset;
	}
	public void setR23_2_asset(BigDecimal r23_2_asset) {
		this.r23_2_asset = r23_2_asset;
	}
	public BigDecimal getR23_3a_asset() {
		return r23_3a_asset;
	}
	public void setR23_3a_asset(BigDecimal r23_3a_asset) {
		this.r23_3a_asset = r23_3a_asset;
	}
	public BigDecimal getR23_3b_asset() {
		return r23_3b_asset;
	}
	public void setR23_3b_asset(BigDecimal r23_3b_asset) {
		this.r23_3b_asset = r23_3b_asset;
	}
	public BigDecimal getR23_3c_asset() {
		return r23_3c_asset;
	}
	public void setR23_3c_asset(BigDecimal r23_3c_asset) {
		this.r23_3c_asset = r23_3c_asset;
	}
	public BigDecimal getR23_1_provision() {
		return r23_1_provision;
	}
	public void setR23_1_provision(BigDecimal r23_1_provision) {
		this.r23_1_provision = r23_1_provision;
	}
	public BigDecimal getR23_2_provision() {
		return r23_2_provision;
	}
	public void setR23_2_provision(BigDecimal r23_2_provision) {
		this.r23_2_provision = r23_2_provision;
	}
	public BigDecimal getR23_3a_provision() {
		return r23_3a_provision;
	}
	public void setR23_3a_provision(BigDecimal r23_3a_provision) {
		this.r23_3a_provision = r23_3a_provision;
	}
	public BigDecimal getR23_3b_provision() {
		return r23_3b_provision;
	}
	public void setR23_3b_provision(BigDecimal r23_3b_provision) {
		this.r23_3b_provision = r23_3b_provision;
	}
	public BigDecimal getR23_3c_provision() {
		return r23_3c_provision;
	}
	public void setR23_3c_provision(BigDecimal r23_3c_provision) {
		this.r23_3c_provision = r23_3c_provision;
	}
	public BigDecimal getR23_current() {
		return r23_current;
	}
	public void setR23_current(BigDecimal r23_current) {
		this.r23_current = r23_current;
	}
	public BigDecimal getR23_lessthan_30() {
		return r23_lessthan_30;
	}
	public void setR23_lessthan_30(BigDecimal r23_lessthan_30) {
		this.r23_lessthan_30 = r23_lessthan_30;
	}
	public BigDecimal getR23_exclusive_90days() {
		return r23_exclusive_90days;
	}
	public void setR23_exclusive_90days(BigDecimal r23_exclusive_90days) {
		this.r23_exclusive_90days = r23_exclusive_90days;
	}
	public BigDecimal getR23_exclusive_120days() {
		return r23_exclusive_120days;
	}
	public void setR23_exclusive_120days(BigDecimal r23_exclusive_120days) {
		this.r23_exclusive_120days = r23_exclusive_120days;
	}
	public BigDecimal getR23_exclusive_180days() {
		return r23_exclusive_180days;
	}
	public void setR23_exclusive_180days(BigDecimal r23_exclusive_180days) {
		this.r23_exclusive_180days = r23_exclusive_180days;
	}
	public BigDecimal getR23_exclusive_over_180days() {
		return r23_exclusive_over_180days;
	}
	public void setR23_exclusive_over_180days(BigDecimal r23_exclusive_over_180days) {
		this.r23_exclusive_over_180days = r23_exclusive_over_180days;
	}
	public BigDecimal getR23_total_past() {
		return r23_total_past;
	}
	public void setR23_total_past(BigDecimal r23_total_past) {
		this.r23_total_past = r23_total_past;
	}
	public BigDecimal getR23_new_stage3() {
		return r23_new_stage3;
	}
	public void setR23_new_stage3(BigDecimal r23_new_stage3) {
		this.r23_new_stage3 = r23_new_stage3;
	}
	public BigDecimal getR23_new_specific() {
		return r23_new_specific;
	}
	public void setR23_new_specific(BigDecimal r23_new_specific) {
		this.r23_new_specific = r23_new_specific;
	}
	public BigDecimal getR23_new_other() {
		return r23_new_other;
	}
	public void setR23_new_other(BigDecimal r23_new_other) {
		this.r23_new_other = r23_new_other;
	}
	public BigDecimal getR23_performing_accounts() {
		return r23_performing_accounts;
	}
	public void setR23_performing_accounts(BigDecimal r23_performing_accounts) {
		this.r23_performing_accounts = r23_performing_accounts;
	}
	public BigDecimal getR23_non_performing_accounts() {
		return r23_non_performing_accounts;
	}
	public void setR23_non_performing_accounts(BigDecimal r23_non_performing_accounts) {
		this.r23_non_performing_accounts = r23_non_performing_accounts;
	}
	public String getR23_outstanding_check() {
		return r23_outstanding_check;
	}
	public void setR23_outstanding_check(String r23_outstanding_check) {
		this.r23_outstanding_check = r23_outstanding_check;
	}
	public String getR23_provision_check() {
		return r23_provision_check;
	}
	public void setR23_provision_check(String r23_provision_check) {
		this.r23_provision_check = r23_provision_check;
	}
	public String getR23_past_due_date() {
		return r23_past_due_date;
	}
	public void setR23_past_due_date(String r23_past_due_date) {
		this.r23_past_due_date = r23_past_due_date;
	}
	public String getR24_asset_classes() {
		return r24_asset_classes;
	}
	public void setR24_asset_classes(String r24_asset_classes) {
		this.r24_asset_classes = r24_asset_classes;
	}
	public BigDecimal getR24_outstanding_balance() {
		return r24_outstanding_balance;
	}
	public void setR24_outstanding_balance(BigDecimal r24_outstanding_balance) {
		this.r24_outstanding_balance = r24_outstanding_balance;
	}
	public BigDecimal getR24_provision_suspense() {
		return r24_provision_suspense;
	}
	public void setR24_provision_suspense(BigDecimal r24_provision_suspense) {
		this.r24_provision_suspense = r24_provision_suspense;
	}
	public BigDecimal getR24_stage3_provision() {
		return r24_stage3_provision;
	}
	public void setR24_stage3_provision(BigDecimal r24_stage3_provision) {
		this.r24_stage3_provision = r24_stage3_provision;
	}
	public BigDecimal getR24_other_alloate() {
		return r24_other_alloate;
	}
	public void setR24_other_alloate(BigDecimal r24_other_alloate) {
		this.r24_other_alloate = r24_other_alloate;
	}
	public BigDecimal getR24_1_asset() {
		return r24_1_asset;
	}
	public void setR24_1_asset(BigDecimal r24_1_asset) {
		this.r24_1_asset = r24_1_asset;
	}
	public BigDecimal getR24_2_asset() {
		return r24_2_asset;
	}
	public void setR24_2_asset(BigDecimal r24_2_asset) {
		this.r24_2_asset = r24_2_asset;
	}
	public BigDecimal getR24_3a_asset() {
		return r24_3a_asset;
	}
	public void setR24_3a_asset(BigDecimal r24_3a_asset) {
		this.r24_3a_asset = r24_3a_asset;
	}
	public BigDecimal getR24_3b_asset() {
		return r24_3b_asset;
	}
	public void setR24_3b_asset(BigDecimal r24_3b_asset) {
		this.r24_3b_asset = r24_3b_asset;
	}
	public BigDecimal getR24_3c_asset() {
		return r24_3c_asset;
	}
	public void setR24_3c_asset(BigDecimal r24_3c_asset) {
		this.r24_3c_asset = r24_3c_asset;
	}
	public BigDecimal getR24_1_provision() {
		return r24_1_provision;
	}
	public void setR24_1_provision(BigDecimal r24_1_provision) {
		this.r24_1_provision = r24_1_provision;
	}
	public BigDecimal getR24_2_provision() {
		return r24_2_provision;
	}
	public void setR24_2_provision(BigDecimal r24_2_provision) {
		this.r24_2_provision = r24_2_provision;
	}
	public BigDecimal getR24_3a_provision() {
		return r24_3a_provision;
	}
	public void setR24_3a_provision(BigDecimal r24_3a_provision) {
		this.r24_3a_provision = r24_3a_provision;
	}
	public BigDecimal getR24_3b_provision() {
		return r24_3b_provision;
	}
	public void setR24_3b_provision(BigDecimal r24_3b_provision) {
		this.r24_3b_provision = r24_3b_provision;
	}
	public BigDecimal getR24_3c_provision() {
		return r24_3c_provision;
	}
	public void setR24_3c_provision(BigDecimal r24_3c_provision) {
		this.r24_3c_provision = r24_3c_provision;
	}
	public BigDecimal getR24_current() {
		return r24_current;
	}
	public void setR24_current(BigDecimal r24_current) {
		this.r24_current = r24_current;
	}
	public BigDecimal getR24_lessthan_30() {
		return r24_lessthan_30;
	}
	public void setR24_lessthan_30(BigDecimal r24_lessthan_30) {
		this.r24_lessthan_30 = r24_lessthan_30;
	}
	public BigDecimal getR24_exclusive_90days() {
		return r24_exclusive_90days;
	}
	public void setR24_exclusive_90days(BigDecimal r24_exclusive_90days) {
		this.r24_exclusive_90days = r24_exclusive_90days;
	}
	public BigDecimal getR24_exclusive_120days() {
		return r24_exclusive_120days;
	}
	public void setR24_exclusive_120days(BigDecimal r24_exclusive_120days) {
		this.r24_exclusive_120days = r24_exclusive_120days;
	}
	public BigDecimal getR24_exclusive_180days() {
		return r24_exclusive_180days;
	}
	public void setR24_exclusive_180days(BigDecimal r24_exclusive_180days) {
		this.r24_exclusive_180days = r24_exclusive_180days;
	}
	public BigDecimal getR24_exclusive_over_180days() {
		return r24_exclusive_over_180days;
	}
	public void setR24_exclusive_over_180days(BigDecimal r24_exclusive_over_180days) {
		this.r24_exclusive_over_180days = r24_exclusive_over_180days;
	}
	public BigDecimal getR24_total_past() {
		return r24_total_past;
	}
	public void setR24_total_past(BigDecimal r24_total_past) {
		this.r24_total_past = r24_total_past;
	}
	public BigDecimal getR24_new_stage3() {
		return r24_new_stage3;
	}
	public void setR24_new_stage3(BigDecimal r24_new_stage3) {
		this.r24_new_stage3 = r24_new_stage3;
	}
	public BigDecimal getR24_new_specific() {
		return r24_new_specific;
	}
	public void setR24_new_specific(BigDecimal r24_new_specific) {
		this.r24_new_specific = r24_new_specific;
	}
	public BigDecimal getR24_new_other() {
		return r24_new_other;
	}
	public void setR24_new_other(BigDecimal r24_new_other) {
		this.r24_new_other = r24_new_other;
	}
	public BigDecimal getR24_performing_accounts() {
		return r24_performing_accounts;
	}
	public void setR24_performing_accounts(BigDecimal r24_performing_accounts) {
		this.r24_performing_accounts = r24_performing_accounts;
	}
	public BigDecimal getR24_non_performing_accounts() {
		return r24_non_performing_accounts;
	}
	public void setR24_non_performing_accounts(BigDecimal r24_non_performing_accounts) {
		this.r24_non_performing_accounts = r24_non_performing_accounts;
	}
	public String getR24_outstanding_check() {
		return r24_outstanding_check;
	}
	public void setR24_outstanding_check(String r24_outstanding_check) {
		this.r24_outstanding_check = r24_outstanding_check;
	}
	public String getR24_provision_check() {
		return r24_provision_check;
	}
	public void setR24_provision_check(String r24_provision_check) {
		this.r24_provision_check = r24_provision_check;
	}
	public String getR24_past_due_date() {
		return r24_past_due_date;
	}
	public void setR24_past_due_date(String r24_past_due_date) {
		this.r24_past_due_date = r24_past_due_date;
	}
	public String getR25_asset_classes() {
		return r25_asset_classes;
	}
	public void setR25_asset_classes(String r25_asset_classes) {
		this.r25_asset_classes = r25_asset_classes;
	}
	public BigDecimal getR25_outstanding_balance() {
		return r25_outstanding_balance;
	}
	public void setR25_outstanding_balance(BigDecimal r25_outstanding_balance) {
		this.r25_outstanding_balance = r25_outstanding_balance;
	}
	public BigDecimal getR25_provision_suspense() {
		return r25_provision_suspense;
	}
	public void setR25_provision_suspense(BigDecimal r25_provision_suspense) {
		this.r25_provision_suspense = r25_provision_suspense;
	}
	public BigDecimal getR25_stage3_provision() {
		return r25_stage3_provision;
	}
	public void setR25_stage3_provision(BigDecimal r25_stage3_provision) {
		this.r25_stage3_provision = r25_stage3_provision;
	}
	public BigDecimal getR25_other_alloate() {
		return r25_other_alloate;
	}
	public void setR25_other_alloate(BigDecimal r25_other_alloate) {
		this.r25_other_alloate = r25_other_alloate;
	}
	public BigDecimal getR25_1_asset() {
		return r25_1_asset;
	}
	public void setR25_1_asset(BigDecimal r25_1_asset) {
		this.r25_1_asset = r25_1_asset;
	}
	public BigDecimal getR25_2_asset() {
		return r25_2_asset;
	}
	public void setR25_2_asset(BigDecimal r25_2_asset) {
		this.r25_2_asset = r25_2_asset;
	}
	public BigDecimal getR25_3a_asset() {
		return r25_3a_asset;
	}
	public void setR25_3a_asset(BigDecimal r25_3a_asset) {
		this.r25_3a_asset = r25_3a_asset;
	}
	public BigDecimal getR25_3b_asset() {
		return r25_3b_asset;
	}
	public void setR25_3b_asset(BigDecimal r25_3b_asset) {
		this.r25_3b_asset = r25_3b_asset;
	}
	public BigDecimal getR25_3c_asset() {
		return r25_3c_asset;
	}
	public void setR25_3c_asset(BigDecimal r25_3c_asset) {
		this.r25_3c_asset = r25_3c_asset;
	}
	public BigDecimal getR25_1_provision() {
		return r25_1_provision;
	}
	public void setR25_1_provision(BigDecimal r25_1_provision) {
		this.r25_1_provision = r25_1_provision;
	}
	public BigDecimal getR25_2_provision() {
		return r25_2_provision;
	}
	public void setR25_2_provision(BigDecimal r25_2_provision) {
		this.r25_2_provision = r25_2_provision;
	}
	public BigDecimal getR25_3a_provision() {
		return r25_3a_provision;
	}
	public void setR25_3a_provision(BigDecimal r25_3a_provision) {
		this.r25_3a_provision = r25_3a_provision;
	}
	public BigDecimal getR25_3b_provision() {
		return r25_3b_provision;
	}
	public void setR25_3b_provision(BigDecimal r25_3b_provision) {
		this.r25_3b_provision = r25_3b_provision;
	}
	public BigDecimal getR25_3c_provision() {
		return r25_3c_provision;
	}
	public void setR25_3c_provision(BigDecimal r25_3c_provision) {
		this.r25_3c_provision = r25_3c_provision;
	}
	public BigDecimal getR25_current() {
		return r25_current;
	}
	public void setR25_current(BigDecimal r25_current) {
		this.r25_current = r25_current;
	}
	public BigDecimal getR25_lessthan_30() {
		return r25_lessthan_30;
	}
	public void setR25_lessthan_30(BigDecimal r25_lessthan_30) {
		this.r25_lessthan_30 = r25_lessthan_30;
	}
	public BigDecimal getR25_exclusive_90days() {
		return r25_exclusive_90days;
	}
	public void setR25_exclusive_90days(BigDecimal r25_exclusive_90days) {
		this.r25_exclusive_90days = r25_exclusive_90days;
	}
	public BigDecimal getR25_exclusive_120days() {
		return r25_exclusive_120days;
	}
	public void setR25_exclusive_120days(BigDecimal r25_exclusive_120days) {
		this.r25_exclusive_120days = r25_exclusive_120days;
	}
	public BigDecimal getR25_exclusive_180days() {
		return r25_exclusive_180days;
	}
	public void setR25_exclusive_180days(BigDecimal r25_exclusive_180days) {
		this.r25_exclusive_180days = r25_exclusive_180days;
	}
	public BigDecimal getR25_exclusive_over_180days() {
		return r25_exclusive_over_180days;
	}
	public void setR25_exclusive_over_180days(BigDecimal r25_exclusive_over_180days) {
		this.r25_exclusive_over_180days = r25_exclusive_over_180days;
	}
	public BigDecimal getR25_total_past() {
		return r25_total_past;
	}
	public void setR25_total_past(BigDecimal r25_total_past) {
		this.r25_total_past = r25_total_past;
	}
	public BigDecimal getR25_new_stage3() {
		return r25_new_stage3;
	}
	public void setR25_new_stage3(BigDecimal r25_new_stage3) {
		this.r25_new_stage3 = r25_new_stage3;
	}
	public BigDecimal getR25_new_specific() {
		return r25_new_specific;
	}
	public void setR25_new_specific(BigDecimal r25_new_specific) {
		this.r25_new_specific = r25_new_specific;
	}
	public BigDecimal getR25_new_other() {
		return r25_new_other;
	}
	public void setR25_new_other(BigDecimal r25_new_other) {
		this.r25_new_other = r25_new_other;
	}
	public BigDecimal getR25_performing_accounts() {
		return r25_performing_accounts;
	}
	public void setR25_performing_accounts(BigDecimal r25_performing_accounts) {
		this.r25_performing_accounts = r25_performing_accounts;
	}
	public BigDecimal getR25_non_performing_accounts() {
		return r25_non_performing_accounts;
	}
	public void setR25_non_performing_accounts(BigDecimal r25_non_performing_accounts) {
		this.r25_non_performing_accounts = r25_non_performing_accounts;
	}
	public String getR25_outstanding_check() {
		return r25_outstanding_check;
	}
	public void setR25_outstanding_check(String r25_outstanding_check) {
		this.r25_outstanding_check = r25_outstanding_check;
	}
	public String getR25_provision_check() {
		return r25_provision_check;
	}
	public void setR25_provision_check(String r25_provision_check) {
		this.r25_provision_check = r25_provision_check;
	}
	public String getR25_past_due_date() {
		return r25_past_due_date;
	}
	public void setR25_past_due_date(String r25_past_due_date) {
		this.r25_past_due_date = r25_past_due_date;
	}
	public String getR26_asset_classes() {
		return r26_asset_classes;
	}
	public void setR26_asset_classes(String r26_asset_classes) {
		this.r26_asset_classes = r26_asset_classes;
	}
	public BigDecimal getR26_outstanding_balance() {
		return r26_outstanding_balance;
	}
	public void setR26_outstanding_balance(BigDecimal r26_outstanding_balance) {
		this.r26_outstanding_balance = r26_outstanding_balance;
	}
	public BigDecimal getR26_provision_suspense() {
		return r26_provision_suspense;
	}
	public void setR26_provision_suspense(BigDecimal r26_provision_suspense) {
		this.r26_provision_suspense = r26_provision_suspense;
	}
	public BigDecimal getR26_stage3_provision() {
		return r26_stage3_provision;
	}
	public void setR26_stage3_provision(BigDecimal r26_stage3_provision) {
		this.r26_stage3_provision = r26_stage3_provision;
	}
	public BigDecimal getR26_other_alloate() {
		return r26_other_alloate;
	}
	public void setR26_other_alloate(BigDecimal r26_other_alloate) {
		this.r26_other_alloate = r26_other_alloate;
	}
	public BigDecimal getR26_1_asset() {
		return r26_1_asset;
	}
	public void setR26_1_asset(BigDecimal r26_1_asset) {
		this.r26_1_asset = r26_1_asset;
	}
	public BigDecimal getR26_2_asset() {
		return r26_2_asset;
	}
	public void setR26_2_asset(BigDecimal r26_2_asset) {
		this.r26_2_asset = r26_2_asset;
	}
	public BigDecimal getR26_3a_asset() {
		return r26_3a_asset;
	}
	public void setR26_3a_asset(BigDecimal r26_3a_asset) {
		this.r26_3a_asset = r26_3a_asset;
	}
	public BigDecimal getR26_3b_asset() {
		return r26_3b_asset;
	}
	public void setR26_3b_asset(BigDecimal r26_3b_asset) {
		this.r26_3b_asset = r26_3b_asset;
	}
	public BigDecimal getR26_3c_asset() {
		return r26_3c_asset;
	}
	public void setR26_3c_asset(BigDecimal r26_3c_asset) {
		this.r26_3c_asset = r26_3c_asset;
	}
	public BigDecimal getR26_1_provision() {
		return r26_1_provision;
	}
	public void setR26_1_provision(BigDecimal r26_1_provision) {
		this.r26_1_provision = r26_1_provision;
	}
	public BigDecimal getR26_2_provision() {
		return r26_2_provision;
	}
	public void setR26_2_provision(BigDecimal r26_2_provision) {
		this.r26_2_provision = r26_2_provision;
	}
	public BigDecimal getR26_3a_provision() {
		return r26_3a_provision;
	}
	public void setR26_3a_provision(BigDecimal r26_3a_provision) {
		this.r26_3a_provision = r26_3a_provision;
	}
	public BigDecimal getR26_3b_provision() {
		return r26_3b_provision;
	}
	public void setR26_3b_provision(BigDecimal r26_3b_provision) {
		this.r26_3b_provision = r26_3b_provision;
	}
	public BigDecimal getR26_3c_provision() {
		return r26_3c_provision;
	}
	public void setR26_3c_provision(BigDecimal r26_3c_provision) {
		this.r26_3c_provision = r26_3c_provision;
	}
	public BigDecimal getR26_current() {
		return r26_current;
	}
	public void setR26_current(BigDecimal r26_current) {
		this.r26_current = r26_current;
	}
	public BigDecimal getR26_lessthan_30() {
		return r26_lessthan_30;
	}
	public void setR26_lessthan_30(BigDecimal r26_lessthan_30) {
		this.r26_lessthan_30 = r26_lessthan_30;
	}
	public BigDecimal getR26_exclusive_90days() {
		return r26_exclusive_90days;
	}
	public void setR26_exclusive_90days(BigDecimal r26_exclusive_90days) {
		this.r26_exclusive_90days = r26_exclusive_90days;
	}
	public BigDecimal getR26_exclusive_120days() {
		return r26_exclusive_120days;
	}
	public void setR26_exclusive_120days(BigDecimal r26_exclusive_120days) {
		this.r26_exclusive_120days = r26_exclusive_120days;
	}
	public BigDecimal getR26_exclusive_180days() {
		return r26_exclusive_180days;
	}
	public void setR26_exclusive_180days(BigDecimal r26_exclusive_180days) {
		this.r26_exclusive_180days = r26_exclusive_180days;
	}
	public BigDecimal getR26_exclusive_over_180days() {
		return r26_exclusive_over_180days;
	}
	public void setR26_exclusive_over_180days(BigDecimal r26_exclusive_over_180days) {
		this.r26_exclusive_over_180days = r26_exclusive_over_180days;
	}
	public BigDecimal getR26_total_past() {
		return r26_total_past;
	}
	public void setR26_total_past(BigDecimal r26_total_past) {
		this.r26_total_past = r26_total_past;
	}
	public BigDecimal getR26_new_stage3() {
		return r26_new_stage3;
	}
	public void setR26_new_stage3(BigDecimal r26_new_stage3) {
		this.r26_new_stage3 = r26_new_stage3;
	}
	public BigDecimal getR26_new_specific() {
		return r26_new_specific;
	}
	public void setR26_new_specific(BigDecimal r26_new_specific) {
		this.r26_new_specific = r26_new_specific;
	}
	public BigDecimal getR26_new_other() {
		return r26_new_other;
	}
	public void setR26_new_other(BigDecimal r26_new_other) {
		this.r26_new_other = r26_new_other;
	}
	public BigDecimal getR26_performing_accounts() {
		return r26_performing_accounts;
	}
	public void setR26_performing_accounts(BigDecimal r26_performing_accounts) {
		this.r26_performing_accounts = r26_performing_accounts;
	}
	public BigDecimal getR26_non_performing_accounts() {
		return r26_non_performing_accounts;
	}
	public void setR26_non_performing_accounts(BigDecimal r26_non_performing_accounts) {
		this.r26_non_performing_accounts = r26_non_performing_accounts;
	}
	public String getR26_outstanding_check() {
		return r26_outstanding_check;
	}
	public void setR26_outstanding_check(String r26_outstanding_check) {
		this.r26_outstanding_check = r26_outstanding_check;
	}
	public String getR26_provision_check() {
		return r26_provision_check;
	}
	public void setR26_provision_check(String r26_provision_check) {
		this.r26_provision_check = r26_provision_check;
	}
	public String getR26_past_due_date() {
		return r26_past_due_date;
	}
	public void setR26_past_due_date(String r26_past_due_date) {
		this.r26_past_due_date = r26_past_due_date;
	}
	public String getR27_asset_classes() {
		return r27_asset_classes;
	}
	public void setR27_asset_classes(String r27_asset_classes) {
		this.r27_asset_classes = r27_asset_classes;
	}
	public BigDecimal getR27_outstanding_balance() {
		return r27_outstanding_balance;
	}
	public void setR27_outstanding_balance(BigDecimal r27_outstanding_balance) {
		this.r27_outstanding_balance = r27_outstanding_balance;
	}
	public BigDecimal getR27_provision_suspense() {
		return r27_provision_suspense;
	}
	public void setR27_provision_suspense(BigDecimal r27_provision_suspense) {
		this.r27_provision_suspense = r27_provision_suspense;
	}
	public BigDecimal getR27_stage3_provision() {
		return r27_stage3_provision;
	}
	public void setR27_stage3_provision(BigDecimal r27_stage3_provision) {
		this.r27_stage3_provision = r27_stage3_provision;
	}
	public BigDecimal getR27_other_alloate() {
		return r27_other_alloate;
	}
	public void setR27_other_alloate(BigDecimal r27_other_alloate) {
		this.r27_other_alloate = r27_other_alloate;
	}
	public BigDecimal getR27_1_asset() {
		return r27_1_asset;
	}
	public void setR27_1_asset(BigDecimal r27_1_asset) {
		this.r27_1_asset = r27_1_asset;
	}
	public BigDecimal getR27_2_asset() {
		return r27_2_asset;
	}
	public void setR27_2_asset(BigDecimal r27_2_asset) {
		this.r27_2_asset = r27_2_asset;
	}
	public BigDecimal getR27_3a_asset() {
		return r27_3a_asset;
	}
	public void setR27_3a_asset(BigDecimal r27_3a_asset) {
		this.r27_3a_asset = r27_3a_asset;
	}
	public BigDecimal getR27_3b_asset() {
		return r27_3b_asset;
	}
	public void setR27_3b_asset(BigDecimal r27_3b_asset) {
		this.r27_3b_asset = r27_3b_asset;
	}
	public BigDecimal getR27_3c_asset() {
		return r27_3c_asset;
	}
	public void setR27_3c_asset(BigDecimal r27_3c_asset) {
		this.r27_3c_asset = r27_3c_asset;
	}
	public BigDecimal getR27_1_provision() {
		return r27_1_provision;
	}
	public void setR27_1_provision(BigDecimal r27_1_provision) {
		this.r27_1_provision = r27_1_provision;
	}
	public BigDecimal getR27_2_provision() {
		return r27_2_provision;
	}
	public void setR27_2_provision(BigDecimal r27_2_provision) {
		this.r27_2_provision = r27_2_provision;
	}
	public BigDecimal getR27_3a_provision() {
		return r27_3a_provision;
	}
	public void setR27_3a_provision(BigDecimal r27_3a_provision) {
		this.r27_3a_provision = r27_3a_provision;
	}
	public BigDecimal getR27_3b_provision() {
		return r27_3b_provision;
	}
	public void setR27_3b_provision(BigDecimal r27_3b_provision) {
		this.r27_3b_provision = r27_3b_provision;
	}
	public BigDecimal getR27_3c_provision() {
		return r27_3c_provision;
	}
	public void setR27_3c_provision(BigDecimal r27_3c_provision) {
		this.r27_3c_provision = r27_3c_provision;
	}
	public BigDecimal getR27_current() {
		return r27_current;
	}
	public void setR27_current(BigDecimal r27_current) {
		this.r27_current = r27_current;
	}
	public BigDecimal getR27_lessthan_30() {
		return r27_lessthan_30;
	}
	public void setR27_lessthan_30(BigDecimal r27_lessthan_30) {
		this.r27_lessthan_30 = r27_lessthan_30;
	}
	public BigDecimal getR27_exclusive_90days() {
		return r27_exclusive_90days;
	}
	public void setR27_exclusive_90days(BigDecimal r27_exclusive_90days) {
		this.r27_exclusive_90days = r27_exclusive_90days;
	}
	public BigDecimal getR27_exclusive_120days() {
		return r27_exclusive_120days;
	}
	public void setR27_exclusive_120days(BigDecimal r27_exclusive_120days) {
		this.r27_exclusive_120days = r27_exclusive_120days;
	}
	public BigDecimal getR27_exclusive_180days() {
		return r27_exclusive_180days;
	}
	public void setR27_exclusive_180days(BigDecimal r27_exclusive_180days) {
		this.r27_exclusive_180days = r27_exclusive_180days;
	}
	public BigDecimal getR27_exclusive_over_180days() {
		return r27_exclusive_over_180days;
	}
	public void setR27_exclusive_over_180days(BigDecimal r27_exclusive_over_180days) {
		this.r27_exclusive_over_180days = r27_exclusive_over_180days;
	}
	public BigDecimal getR27_total_past() {
		return r27_total_past;
	}
	public void setR27_total_past(BigDecimal r27_total_past) {
		this.r27_total_past = r27_total_past;
	}
	public BigDecimal getR27_new_stage3() {
		return r27_new_stage3;
	}
	public void setR27_new_stage3(BigDecimal r27_new_stage3) {
		this.r27_new_stage3 = r27_new_stage3;
	}
	public BigDecimal getR27_new_specific() {
		return r27_new_specific;
	}
	public void setR27_new_specific(BigDecimal r27_new_specific) {
		this.r27_new_specific = r27_new_specific;
	}
	public BigDecimal getR27_new_other() {
		return r27_new_other;
	}
	public void setR27_new_other(BigDecimal r27_new_other) {
		this.r27_new_other = r27_new_other;
	}
	public BigDecimal getR27_performing_accounts() {
		return r27_performing_accounts;
	}
	public void setR27_performing_accounts(BigDecimal r27_performing_accounts) {
		this.r27_performing_accounts = r27_performing_accounts;
	}
	public BigDecimal getR27_non_performing_accounts() {
		return r27_non_performing_accounts;
	}
	public void setR27_non_performing_accounts(BigDecimal r27_non_performing_accounts) {
		this.r27_non_performing_accounts = r27_non_performing_accounts;
	}
	public String getR27_outstanding_check() {
		return r27_outstanding_check;
	}
	public void setR27_outstanding_check(String r27_outstanding_check) {
		this.r27_outstanding_check = r27_outstanding_check;
	}
	public String getR27_provision_check() {
		return r27_provision_check;
	}
	public void setR27_provision_check(String r27_provision_check) {
		this.r27_provision_check = r27_provision_check;
	}
	public String getR27_past_due_date() {
		return r27_past_due_date;
	}
	public void setR27_past_due_date(String r27_past_due_date) {
		this.r27_past_due_date = r27_past_due_date;
	}
	public String getR28_asset_classes() {
		return r28_asset_classes;
	}
	public void setR28_asset_classes(String r28_asset_classes) {
		this.r28_asset_classes = r28_asset_classes;
	}
	public BigDecimal getR28_outstanding_balance() {
		return r28_outstanding_balance;
	}
	public void setR28_outstanding_balance(BigDecimal r28_outstanding_balance) {
		this.r28_outstanding_balance = r28_outstanding_balance;
	}
	public BigDecimal getR28_provision_suspense() {
		return r28_provision_suspense;
	}
	public void setR28_provision_suspense(BigDecimal r28_provision_suspense) {
		this.r28_provision_suspense = r28_provision_suspense;
	}
	public BigDecimal getR28_stage3_provision() {
		return r28_stage3_provision;
	}
	public void setR28_stage3_provision(BigDecimal r28_stage3_provision) {
		this.r28_stage3_provision = r28_stage3_provision;
	}
	public BigDecimal getR28_other_alloate() {
		return r28_other_alloate;
	}
	public void setR28_other_alloate(BigDecimal r28_other_alloate) {
		this.r28_other_alloate = r28_other_alloate;
	}
	public BigDecimal getR28_1_asset() {
		return r28_1_asset;
	}
	public void setR28_1_asset(BigDecimal r28_1_asset) {
		this.r28_1_asset = r28_1_asset;
	}
	public BigDecimal getR28_2_asset() {
		return r28_2_asset;
	}
	public void setR28_2_asset(BigDecimal r28_2_asset) {
		this.r28_2_asset = r28_2_asset;
	}
	public BigDecimal getR28_3a_asset() {
		return r28_3a_asset;
	}
	public void setR28_3a_asset(BigDecimal r28_3a_asset) {
		this.r28_3a_asset = r28_3a_asset;
	}
	public BigDecimal getR28_3b_asset() {
		return r28_3b_asset;
	}
	public void setR28_3b_asset(BigDecimal r28_3b_asset) {
		this.r28_3b_asset = r28_3b_asset;
	}
	public BigDecimal getR28_3c_asset() {
		return r28_3c_asset;
	}
	public void setR28_3c_asset(BigDecimal r28_3c_asset) {
		this.r28_3c_asset = r28_3c_asset;
	}
	public BigDecimal getR28_1_provision() {
		return r28_1_provision;
	}
	public void setR28_1_provision(BigDecimal r28_1_provision) {
		this.r28_1_provision = r28_1_provision;
	}
	public BigDecimal getR28_2_provision() {
		return r28_2_provision;
	}
	public void setR28_2_provision(BigDecimal r28_2_provision) {
		this.r28_2_provision = r28_2_provision;
	}
	public BigDecimal getR28_3a_provision() {
		return r28_3a_provision;
	}
	public void setR28_3a_provision(BigDecimal r28_3a_provision) {
		this.r28_3a_provision = r28_3a_provision;
	}
	public BigDecimal getR28_3b_provision() {
		return r28_3b_provision;
	}
	public void setR28_3b_provision(BigDecimal r28_3b_provision) {
		this.r28_3b_provision = r28_3b_provision;
	}
	public BigDecimal getR28_3c_provision() {
		return r28_3c_provision;
	}
	public void setR28_3c_provision(BigDecimal r28_3c_provision) {
		this.r28_3c_provision = r28_3c_provision;
	}
	public BigDecimal getR28_current() {
		return r28_current;
	}
	public void setR28_current(BigDecimal r28_current) {
		this.r28_current = r28_current;
	}
	public BigDecimal getR28_lessthan_30() {
		return r28_lessthan_30;
	}
	public void setR28_lessthan_30(BigDecimal r28_lessthan_30) {
		this.r28_lessthan_30 = r28_lessthan_30;
	}
	public BigDecimal getR28_exclusive_90days() {
		return r28_exclusive_90days;
	}
	public void setR28_exclusive_90days(BigDecimal r28_exclusive_90days) {
		this.r28_exclusive_90days = r28_exclusive_90days;
	}
	public BigDecimal getR28_exclusive_120days() {
		return r28_exclusive_120days;
	}
	public void setR28_exclusive_120days(BigDecimal r28_exclusive_120days) {
		this.r28_exclusive_120days = r28_exclusive_120days;
	}
	public BigDecimal getR28_exclusive_180days() {
		return r28_exclusive_180days;
	}
	public void setR28_exclusive_180days(BigDecimal r28_exclusive_180days) {
		this.r28_exclusive_180days = r28_exclusive_180days;
	}
	public BigDecimal getR28_exclusive_over_180days() {
		return r28_exclusive_over_180days;
	}
	public void setR28_exclusive_over_180days(BigDecimal r28_exclusive_over_180days) {
		this.r28_exclusive_over_180days = r28_exclusive_over_180days;
	}
	public BigDecimal getR28_total_past() {
		return r28_total_past;
	}
	public void setR28_total_past(BigDecimal r28_total_past) {
		this.r28_total_past = r28_total_past;
	}
	public BigDecimal getR28_new_stage3() {
		return r28_new_stage3;
	}
	public void setR28_new_stage3(BigDecimal r28_new_stage3) {
		this.r28_new_stage3 = r28_new_stage3;
	}
	public BigDecimal getR28_new_specific() {
		return r28_new_specific;
	}
	public void setR28_new_specific(BigDecimal r28_new_specific) {
		this.r28_new_specific = r28_new_specific;
	}
	public BigDecimal getR28_new_other() {
		return r28_new_other;
	}
	public void setR28_new_other(BigDecimal r28_new_other) {
		this.r28_new_other = r28_new_other;
	}
	public BigDecimal getR28_performing_accounts() {
		return r28_performing_accounts;
	}
	public void setR28_performing_accounts(BigDecimal r28_performing_accounts) {
		this.r28_performing_accounts = r28_performing_accounts;
	}
	public BigDecimal getR28_non_performing_accounts() {
		return r28_non_performing_accounts;
	}
	public void setR28_non_performing_accounts(BigDecimal r28_non_performing_accounts) {
		this.r28_non_performing_accounts = r28_non_performing_accounts;
	}
	public String getR28_outstanding_check() {
		return r28_outstanding_check;
	}
	public void setR28_outstanding_check(String r28_outstanding_check) {
		this.r28_outstanding_check = r28_outstanding_check;
	}
	public String getR28_provision_check() {
		return r28_provision_check;
	}
	public void setR28_provision_check(String r28_provision_check) {
		this.r28_provision_check = r28_provision_check;
	}
	public String getR28_past_due_date() {
		return r28_past_due_date;
	}
	public void setR28_past_due_date(String r28_past_due_date) {
		this.r28_past_due_date = r28_past_due_date;
	}
	public String getR29_asset_classes() {
		return r29_asset_classes;
	}
	public void setR29_asset_classes(String r29_asset_classes) {
		this.r29_asset_classes = r29_asset_classes;
	}
	public BigDecimal getR29_outstanding_balance() {
		return r29_outstanding_balance;
	}
	public void setR29_outstanding_balance(BigDecimal r29_outstanding_balance) {
		this.r29_outstanding_balance = r29_outstanding_balance;
	}
	public BigDecimal getR29_provision_suspense() {
		return r29_provision_suspense;
	}
	public void setR29_provision_suspense(BigDecimal r29_provision_suspense) {
		this.r29_provision_suspense = r29_provision_suspense;
	}
	public BigDecimal getR29_stage3_provision() {
		return r29_stage3_provision;
	}
	public void setR29_stage3_provision(BigDecimal r29_stage3_provision) {
		this.r29_stage3_provision = r29_stage3_provision;
	}
	public BigDecimal getR29_other_alloate() {
		return r29_other_alloate;
	}
	public void setR29_other_alloate(BigDecimal r29_other_alloate) {
		this.r29_other_alloate = r29_other_alloate;
	}
	public BigDecimal getR29_1_asset() {
		return r29_1_asset;
	}
	public void setR29_1_asset(BigDecimal r29_1_asset) {
		this.r29_1_asset = r29_1_asset;
	}
	public BigDecimal getR29_2_asset() {
		return r29_2_asset;
	}
	public void setR29_2_asset(BigDecimal r29_2_asset) {
		this.r29_2_asset = r29_2_asset;
	}
	public BigDecimal getR29_3a_asset() {
		return r29_3a_asset;
	}
	public void setR29_3a_asset(BigDecimal r29_3a_asset) {
		this.r29_3a_asset = r29_3a_asset;
	}
	public BigDecimal getR29_3b_asset() {
		return r29_3b_asset;
	}
	public void setR29_3b_asset(BigDecimal r29_3b_asset) {
		this.r29_3b_asset = r29_3b_asset;
	}
	public BigDecimal getR29_3c_asset() {
		return r29_3c_asset;
	}
	public void setR29_3c_asset(BigDecimal r29_3c_asset) {
		this.r29_3c_asset = r29_3c_asset;
	}
	public BigDecimal getR29_1_provision() {
		return r29_1_provision;
	}
	public void setR29_1_provision(BigDecimal r29_1_provision) {
		this.r29_1_provision = r29_1_provision;
	}
	public BigDecimal getR29_2_provision() {
		return r29_2_provision;
	}
	public void setR29_2_provision(BigDecimal r29_2_provision) {
		this.r29_2_provision = r29_2_provision;
	}
	public BigDecimal getR29_3a_provision() {
		return r29_3a_provision;
	}
	public void setR29_3a_provision(BigDecimal r29_3a_provision) {
		this.r29_3a_provision = r29_3a_provision;
	}
	public BigDecimal getR29_3b_provision() {
		return r29_3b_provision;
	}
	public void setR29_3b_provision(BigDecimal r29_3b_provision) {
		this.r29_3b_provision = r29_3b_provision;
	}
	public BigDecimal getR29_3c_provision() {
		return r29_3c_provision;
	}
	public void setR29_3c_provision(BigDecimal r29_3c_provision) {
		this.r29_3c_provision = r29_3c_provision;
	}
	public BigDecimal getR29_current() {
		return r29_current;
	}
	public void setR29_current(BigDecimal r29_current) {
		this.r29_current = r29_current;
	}
	public BigDecimal getR29_lessthan_30() {
		return r29_lessthan_30;
	}
	public void setR29_lessthan_30(BigDecimal r29_lessthan_30) {
		this.r29_lessthan_30 = r29_lessthan_30;
	}
	public BigDecimal getR29_exclusive_90days() {
		return r29_exclusive_90days;
	}
	public void setR29_exclusive_90days(BigDecimal r29_exclusive_90days) {
		this.r29_exclusive_90days = r29_exclusive_90days;
	}
	public BigDecimal getR29_exclusive_120days() {
		return r29_exclusive_120days;
	}
	public void setR29_exclusive_120days(BigDecimal r29_exclusive_120days) {
		this.r29_exclusive_120days = r29_exclusive_120days;
	}
	public BigDecimal getR29_exclusive_180days() {
		return r29_exclusive_180days;
	}
	public void setR29_exclusive_180days(BigDecimal r29_exclusive_180days) {
		this.r29_exclusive_180days = r29_exclusive_180days;
	}
	public BigDecimal getR29_exclusive_over_180days() {
		return r29_exclusive_over_180days;
	}
	public void setR29_exclusive_over_180days(BigDecimal r29_exclusive_over_180days) {
		this.r29_exclusive_over_180days = r29_exclusive_over_180days;
	}
	public BigDecimal getR29_total_past() {
		return r29_total_past;
	}
	public void setR29_total_past(BigDecimal r29_total_past) {
		this.r29_total_past = r29_total_past;
	}
	public BigDecimal getR29_new_stage3() {
		return r29_new_stage3;
	}
	public void setR29_new_stage3(BigDecimal r29_new_stage3) {
		this.r29_new_stage3 = r29_new_stage3;
	}
	public BigDecimal getR29_new_specific() {
		return r29_new_specific;
	}
	public void setR29_new_specific(BigDecimal r29_new_specific) {
		this.r29_new_specific = r29_new_specific;
	}
	public BigDecimal getR29_new_other() {
		return r29_new_other;
	}
	public void setR29_new_other(BigDecimal r29_new_other) {
		this.r29_new_other = r29_new_other;
	}
	public BigDecimal getR29_performing_accounts() {
		return r29_performing_accounts;
	}
	public void setR29_performing_accounts(BigDecimal r29_performing_accounts) {
		this.r29_performing_accounts = r29_performing_accounts;
	}
	public BigDecimal getR29_non_performing_accounts() {
		return r29_non_performing_accounts;
	}
	public void setR29_non_performing_accounts(BigDecimal r29_non_performing_accounts) {
		this.r29_non_performing_accounts = r29_non_performing_accounts;
	}
	public String getR29_outstanding_check() {
		return r29_outstanding_check;
	}
	public void setR29_outstanding_check(String r29_outstanding_check) {
		this.r29_outstanding_check = r29_outstanding_check;
	}
	public String getR29_provision_check() {
		return r29_provision_check;
	}
	public void setR29_provision_check(String r29_provision_check) {
		this.r29_provision_check = r29_provision_check;
	}
	public String getR29_past_due_date() {
		return r29_past_due_date;
	}
	public void setR29_past_due_date(String r29_past_due_date) {
		this.r29_past_due_date = r29_past_due_date;
	}
	public String getR30_asset_classes() {
		return r30_asset_classes;
	}
	public void setR30_asset_classes(String r30_asset_classes) {
		this.r30_asset_classes = r30_asset_classes;
	}
	public BigDecimal getR30_outstanding_balance() {
		return r30_outstanding_balance;
	}
	public void setR30_outstanding_balance(BigDecimal r30_outstanding_balance) {
		this.r30_outstanding_balance = r30_outstanding_balance;
	}
	public BigDecimal getR30_provision_suspense() {
		return r30_provision_suspense;
	}
	public void setR30_provision_suspense(BigDecimal r30_provision_suspense) {
		this.r30_provision_suspense = r30_provision_suspense;
	}
	public BigDecimal getR30_stage3_provision() {
		return r30_stage3_provision;
	}
	public void setR30_stage3_provision(BigDecimal r30_stage3_provision) {
		this.r30_stage3_provision = r30_stage3_provision;
	}
	public BigDecimal getR30_other_alloate() {
		return r30_other_alloate;
	}
	public void setR30_other_alloate(BigDecimal r30_other_alloate) {
		this.r30_other_alloate = r30_other_alloate;
	}
	public BigDecimal getR30_1_asset() {
		return r30_1_asset;
	}
	public void setR30_1_asset(BigDecimal r30_1_asset) {
		this.r30_1_asset = r30_1_asset;
	}
	public BigDecimal getR30_2_asset() {
		return r30_2_asset;
	}
	public void setR30_2_asset(BigDecimal r30_2_asset) {
		this.r30_2_asset = r30_2_asset;
	}
	public BigDecimal getR30_3a_asset() {
		return r30_3a_asset;
	}
	public void setR30_3a_asset(BigDecimal r30_3a_asset) {
		this.r30_3a_asset = r30_3a_asset;
	}
	public BigDecimal getR30_3b_asset() {
		return r30_3b_asset;
	}
	public void setR30_3b_asset(BigDecimal r30_3b_asset) {
		this.r30_3b_asset = r30_3b_asset;
	}
	public BigDecimal getR30_3c_asset() {
		return r30_3c_asset;
	}
	public void setR30_3c_asset(BigDecimal r30_3c_asset) {
		this.r30_3c_asset = r30_3c_asset;
	}
	public BigDecimal getR30_1_provision() {
		return r30_1_provision;
	}
	public void setR30_1_provision(BigDecimal r30_1_provision) {
		this.r30_1_provision = r30_1_provision;
	}
	public BigDecimal getR30_2_provision() {
		return r30_2_provision;
	}
	public void setR30_2_provision(BigDecimal r30_2_provision) {
		this.r30_2_provision = r30_2_provision;
	}
	public BigDecimal getR30_3a_provision() {
		return r30_3a_provision;
	}
	public void setR30_3a_provision(BigDecimal r30_3a_provision) {
		this.r30_3a_provision = r30_3a_provision;
	}
	public BigDecimal getR30_3b_provision() {
		return r30_3b_provision;
	}
	public void setR30_3b_provision(BigDecimal r30_3b_provision) {
		this.r30_3b_provision = r30_3b_provision;
	}
	public BigDecimal getR30_3c_provision() {
		return r30_3c_provision;
	}
	public void setR30_3c_provision(BigDecimal r30_3c_provision) {
		this.r30_3c_provision = r30_3c_provision;
	}
	public BigDecimal getR30_current() {
		return r30_current;
	}
	public void setR30_current(BigDecimal r30_current) {
		this.r30_current = r30_current;
	}
	public BigDecimal getR30_lessthan_30() {
		return r30_lessthan_30;
	}
	public void setR30_lessthan_30(BigDecimal r30_lessthan_30) {
		this.r30_lessthan_30 = r30_lessthan_30;
	}
	public BigDecimal getR30_exclusive_90days() {
		return r30_exclusive_90days;
	}
	public void setR30_exclusive_90days(BigDecimal r30_exclusive_90days) {
		this.r30_exclusive_90days = r30_exclusive_90days;
	}
	public BigDecimal getR30_exclusive_120days() {
		return r30_exclusive_120days;
	}
	public void setR30_exclusive_120days(BigDecimal r30_exclusive_120days) {
		this.r30_exclusive_120days = r30_exclusive_120days;
	}
	public BigDecimal getR30_exclusive_180days() {
		return r30_exclusive_180days;
	}
	public void setR30_exclusive_180days(BigDecimal r30_exclusive_180days) {
		this.r30_exclusive_180days = r30_exclusive_180days;
	}
	public BigDecimal getR30_exclusive_over_180days() {
		return r30_exclusive_over_180days;
	}
	public void setR30_exclusive_over_180days(BigDecimal r30_exclusive_over_180days) {
		this.r30_exclusive_over_180days = r30_exclusive_over_180days;
	}
	public BigDecimal getR30_total_past() {
		return r30_total_past;
	}
	public void setR30_total_past(BigDecimal r30_total_past) {
		this.r30_total_past = r30_total_past;
	}
	public BigDecimal getR30_new_stage3() {
		return r30_new_stage3;
	}
	public void setR30_new_stage3(BigDecimal r30_new_stage3) {
		this.r30_new_stage3 = r30_new_stage3;
	}
	public BigDecimal getR30_new_specific() {
		return r30_new_specific;
	}
	public void setR30_new_specific(BigDecimal r30_new_specific) {
		this.r30_new_specific = r30_new_specific;
	}
	public BigDecimal getR30_new_other() {
		return r30_new_other;
	}
	public void setR30_new_other(BigDecimal r30_new_other) {
		this.r30_new_other = r30_new_other;
	}
	public BigDecimal getR30_performing_accounts() {
		return r30_performing_accounts;
	}
	public void setR30_performing_accounts(BigDecimal r30_performing_accounts) {
		this.r30_performing_accounts = r30_performing_accounts;
	}
	public BigDecimal getR30_non_performing_accounts() {
		return r30_non_performing_accounts;
	}
	public void setR30_non_performing_accounts(BigDecimal r30_non_performing_accounts) {
		this.r30_non_performing_accounts = r30_non_performing_accounts;
	}
	public String getR30_outstanding_check() {
		return r30_outstanding_check;
	}
	public void setR30_outstanding_check(String r30_outstanding_check) {
		this.r30_outstanding_check = r30_outstanding_check;
	}
	public String getR30_provision_check() {
		return r30_provision_check;
	}
	public void setR30_provision_check(String r30_provision_check) {
		this.r30_provision_check = r30_provision_check;
	}
	public String getR30_past_due_date() {
		return r30_past_due_date;
	}
	public void setR30_past_due_date(String r30_past_due_date) {
		this.r30_past_due_date = r30_past_due_date;
	}
	public String getR31_asset_classes() {
		return r31_asset_classes;
	}
	public void setR31_asset_classes(String r31_asset_classes) {
		this.r31_asset_classes = r31_asset_classes;
	}
	public BigDecimal getR31_outstanding_balance() {
		return r31_outstanding_balance;
	}
	public void setR31_outstanding_balance(BigDecimal r31_outstanding_balance) {
		this.r31_outstanding_balance = r31_outstanding_balance;
	}
	public BigDecimal getR31_provision_suspense() {
		return r31_provision_suspense;
	}
	public void setR31_provision_suspense(BigDecimal r31_provision_suspense) {
		this.r31_provision_suspense = r31_provision_suspense;
	}
	public BigDecimal getR31_stage3_provision() {
		return r31_stage3_provision;
	}
	public void setR31_stage3_provision(BigDecimal r31_stage3_provision) {
		this.r31_stage3_provision = r31_stage3_provision;
	}
	public BigDecimal getR31_other_alloate() {
		return r31_other_alloate;
	}
	public void setR31_other_alloate(BigDecimal r31_other_alloate) {
		this.r31_other_alloate = r31_other_alloate;
	}
	public BigDecimal getR31_1_asset() {
		return r31_1_asset;
	}
	public void setR31_1_asset(BigDecimal r31_1_asset) {
		this.r31_1_asset = r31_1_asset;
	}
	public BigDecimal getR31_2_asset() {
		return r31_2_asset;
	}
	public void setR31_2_asset(BigDecimal r31_2_asset) {
		this.r31_2_asset = r31_2_asset;
	}
	public BigDecimal getR31_3a_asset() {
		return r31_3a_asset;
	}
	public void setR31_3a_asset(BigDecimal r31_3a_asset) {
		this.r31_3a_asset = r31_3a_asset;
	}
	public BigDecimal getR31_3b_asset() {
		return r31_3b_asset;
	}
	public void setR31_3b_asset(BigDecimal r31_3b_asset) {
		this.r31_3b_asset = r31_3b_asset;
	}
	public BigDecimal getR31_3c_asset() {
		return r31_3c_asset;
	}
	public void setR31_3c_asset(BigDecimal r31_3c_asset) {
		this.r31_3c_asset = r31_3c_asset;
	}
	public BigDecimal getR31_1_provision() {
		return r31_1_provision;
	}
	public void setR31_1_provision(BigDecimal r31_1_provision) {
		this.r31_1_provision = r31_1_provision;
	}
	public BigDecimal getR31_2_provision() {
		return r31_2_provision;
	}
	public void setR31_2_provision(BigDecimal r31_2_provision) {
		this.r31_2_provision = r31_2_provision;
	}
	public BigDecimal getR31_3a_provision() {
		return r31_3a_provision;
	}
	public void setR31_3a_provision(BigDecimal r31_3a_provision) {
		this.r31_3a_provision = r31_3a_provision;
	}
	public BigDecimal getR31_3b_provision() {
		return r31_3b_provision;
	}
	public void setR31_3b_provision(BigDecimal r31_3b_provision) {
		this.r31_3b_provision = r31_3b_provision;
	}
	public BigDecimal getR31_3c_provision() {
		return r31_3c_provision;
	}
	public void setR31_3c_provision(BigDecimal r31_3c_provision) {
		this.r31_3c_provision = r31_3c_provision;
	}
	public BigDecimal getR31_current() {
		return r31_current;
	}
	public void setR31_current(BigDecimal r31_current) {
		this.r31_current = r31_current;
	}
	public BigDecimal getR31_lessthan_30() {
		return r31_lessthan_30;
	}
	public void setR31_lessthan_30(BigDecimal r31_lessthan_30) {
		this.r31_lessthan_30 = r31_lessthan_30;
	}
	public BigDecimal getR31_exclusive_90days() {
		return r31_exclusive_90days;
	}
	public void setR31_exclusive_90days(BigDecimal r31_exclusive_90days) {
		this.r31_exclusive_90days = r31_exclusive_90days;
	}
	public BigDecimal getR31_exclusive_120days() {
		return r31_exclusive_120days;
	}
	public void setR31_exclusive_120days(BigDecimal r31_exclusive_120days) {
		this.r31_exclusive_120days = r31_exclusive_120days;
	}
	public BigDecimal getR31_exclusive_180days() {
		return r31_exclusive_180days;
	}
	public void setR31_exclusive_180days(BigDecimal r31_exclusive_180days) {
		this.r31_exclusive_180days = r31_exclusive_180days;
	}
	public BigDecimal getR31_exclusive_over_180days() {
		return r31_exclusive_over_180days;
	}
	public void setR31_exclusive_over_180days(BigDecimal r31_exclusive_over_180days) {
		this.r31_exclusive_over_180days = r31_exclusive_over_180days;
	}
	public BigDecimal getR31_total_past() {
		return r31_total_past;
	}
	public void setR31_total_past(BigDecimal r31_total_past) {
		this.r31_total_past = r31_total_past;
	}
	public BigDecimal getR31_new_stage3() {
		return r31_new_stage3;
	}
	public void setR31_new_stage3(BigDecimal r31_new_stage3) {
		this.r31_new_stage3 = r31_new_stage3;
	}
	public BigDecimal getR31_new_specific() {
		return r31_new_specific;
	}
	public void setR31_new_specific(BigDecimal r31_new_specific) {
		this.r31_new_specific = r31_new_specific;
	}
	public BigDecimal getR31_new_other() {
		return r31_new_other;
	}
	public void setR31_new_other(BigDecimal r31_new_other) {
		this.r31_new_other = r31_new_other;
	}
	public BigDecimal getR31_performing_accounts() {
		return r31_performing_accounts;
	}
	public void setR31_performing_accounts(BigDecimal r31_performing_accounts) {
		this.r31_performing_accounts = r31_performing_accounts;
	}
	public BigDecimal getR31_non_performing_accounts() {
		return r31_non_performing_accounts;
	}
	public void setR31_non_performing_accounts(BigDecimal r31_non_performing_accounts) {
		this.r31_non_performing_accounts = r31_non_performing_accounts;
	}
	public String getR31_outstanding_check() {
		return r31_outstanding_check;
	}
	public void setR31_outstanding_check(String r31_outstanding_check) {
		this.r31_outstanding_check = r31_outstanding_check;
	}
	public String getR31_provision_check() {
		return r31_provision_check;
	}
	public void setR31_provision_check(String r31_provision_check) {
		this.r31_provision_check = r31_provision_check;
	}
	public String getR31_past_due_date() {
		return r31_past_due_date;
	}
	public void setR31_past_due_date(String r31_past_due_date) {
		this.r31_past_due_date = r31_past_due_date;
	}
	public String getR32_asset_classes() {
		return r32_asset_classes;
	}
	public void setR32_asset_classes(String r32_asset_classes) {
		this.r32_asset_classes = r32_asset_classes;
	}
	public BigDecimal getR32_outstanding_balance() {
		return r32_outstanding_balance;
	}
	public void setR32_outstanding_balance(BigDecimal r32_outstanding_balance) {
		this.r32_outstanding_balance = r32_outstanding_balance;
	}
	public BigDecimal getR32_provision_suspense() {
		return r32_provision_suspense;
	}
	public void setR32_provision_suspense(BigDecimal r32_provision_suspense) {
		this.r32_provision_suspense = r32_provision_suspense;
	}
	public BigDecimal getR32_stage3_provision() {
		return r32_stage3_provision;
	}
	public void setR32_stage3_provision(BigDecimal r32_stage3_provision) {
		this.r32_stage3_provision = r32_stage3_provision;
	}
	public BigDecimal getR32_other_alloate() {
		return r32_other_alloate;
	}
	public void setR32_other_alloate(BigDecimal r32_other_alloate) {
		this.r32_other_alloate = r32_other_alloate;
	}
	public BigDecimal getR32_1_asset() {
		return r32_1_asset;
	}
	public void setR32_1_asset(BigDecimal r32_1_asset) {
		this.r32_1_asset = r32_1_asset;
	}
	public BigDecimal getR32_2_asset() {
		return r32_2_asset;
	}
	public void setR32_2_asset(BigDecimal r32_2_asset) {
		this.r32_2_asset = r32_2_asset;
	}
	public BigDecimal getR32_3a_asset() {
		return r32_3a_asset;
	}
	public void setR32_3a_asset(BigDecimal r32_3a_asset) {
		this.r32_3a_asset = r32_3a_asset;
	}
	public BigDecimal getR32_3b_asset() {
		return r32_3b_asset;
	}
	public void setR32_3b_asset(BigDecimal r32_3b_asset) {
		this.r32_3b_asset = r32_3b_asset;
	}
	public BigDecimal getR32_3c_asset() {
		return r32_3c_asset;
	}
	public void setR32_3c_asset(BigDecimal r32_3c_asset) {
		this.r32_3c_asset = r32_3c_asset;
	}
	public BigDecimal getR32_1_provision() {
		return r32_1_provision;
	}
	public void setR32_1_provision(BigDecimal r32_1_provision) {
		this.r32_1_provision = r32_1_provision;
	}
	public BigDecimal getR32_2_provision() {
		return r32_2_provision;
	}
	public void setR32_2_provision(BigDecimal r32_2_provision) {
		this.r32_2_provision = r32_2_provision;
	}
	public BigDecimal getR32_3a_provision() {
		return r32_3a_provision;
	}
	public void setR32_3a_provision(BigDecimal r32_3a_provision) {
		this.r32_3a_provision = r32_3a_provision;
	}
	public BigDecimal getR32_3b_provision() {
		return r32_3b_provision;
	}
	public void setR32_3b_provision(BigDecimal r32_3b_provision) {
		this.r32_3b_provision = r32_3b_provision;
	}
	public BigDecimal getR32_3c_provision() {
		return r32_3c_provision;
	}
	public void setR32_3c_provision(BigDecimal r32_3c_provision) {
		this.r32_3c_provision = r32_3c_provision;
	}
	public BigDecimal getR32_current() {
		return r32_current;
	}
	public void setR32_current(BigDecimal r32_current) {
		this.r32_current = r32_current;
	}
	public BigDecimal getR32_lessthan_30() {
		return r32_lessthan_30;
	}
	public void setR32_lessthan_30(BigDecimal r32_lessthan_30) {
		this.r32_lessthan_30 = r32_lessthan_30;
	}
	public BigDecimal getR32_exclusive_90days() {
		return r32_exclusive_90days;
	}
	public void setR32_exclusive_90days(BigDecimal r32_exclusive_90days) {
		this.r32_exclusive_90days = r32_exclusive_90days;
	}
	public BigDecimal getR32_exclusive_120days() {
		return r32_exclusive_120days;
	}
	public void setR32_exclusive_120days(BigDecimal r32_exclusive_120days) {
		this.r32_exclusive_120days = r32_exclusive_120days;
	}
	public BigDecimal getR32_exclusive_180days() {
		return r32_exclusive_180days;
	}
	public void setR32_exclusive_180days(BigDecimal r32_exclusive_180days) {
		this.r32_exclusive_180days = r32_exclusive_180days;
	}
	public BigDecimal getR32_exclusive_over_180days() {
		return r32_exclusive_over_180days;
	}
	public void setR32_exclusive_over_180days(BigDecimal r32_exclusive_over_180days) {
		this.r32_exclusive_over_180days = r32_exclusive_over_180days;
	}
	public BigDecimal getR32_total_past() {
		return r32_total_past;
	}
	public void setR32_total_past(BigDecimal r32_total_past) {
		this.r32_total_past = r32_total_past;
	}
	public BigDecimal getR32_new_stage3() {
		return r32_new_stage3;
	}
	public void setR32_new_stage3(BigDecimal r32_new_stage3) {
		this.r32_new_stage3 = r32_new_stage3;
	}
	public BigDecimal getR32_new_specific() {
		return r32_new_specific;
	}
	public void setR32_new_specific(BigDecimal r32_new_specific) {
		this.r32_new_specific = r32_new_specific;
	}
	public BigDecimal getR32_new_other() {
		return r32_new_other;
	}
	public void setR32_new_other(BigDecimal r32_new_other) {
		this.r32_new_other = r32_new_other;
	}
	public BigDecimal getR32_performing_accounts() {
		return r32_performing_accounts;
	}
	public void setR32_performing_accounts(BigDecimal r32_performing_accounts) {
		this.r32_performing_accounts = r32_performing_accounts;
	}
	public BigDecimal getR32_non_performing_accounts() {
		return r32_non_performing_accounts;
	}
	public void setR32_non_performing_accounts(BigDecimal r32_non_performing_accounts) {
		this.r32_non_performing_accounts = r32_non_performing_accounts;
	}
	public String getR32_outstanding_check() {
		return r32_outstanding_check;
	}
	public void setR32_outstanding_check(String r32_outstanding_check) {
		this.r32_outstanding_check = r32_outstanding_check;
	}
	public String getR32_provision_check() {
		return r32_provision_check;
	}
	public void setR32_provision_check(String r32_provision_check) {
		this.r32_provision_check = r32_provision_check;
	}
	public String getR32_past_due_date() {
		return r32_past_due_date;
	}
	public void setR32_past_due_date(String r32_past_due_date) {
		this.r32_past_due_date = r32_past_due_date;
	}
	public String getR33_asset_classes() {
		return r33_asset_classes;
	}
	public void setR33_asset_classes(String r33_asset_classes) {
		this.r33_asset_classes = r33_asset_classes;
	}
	public BigDecimal getR33_outstanding_balance() {
		return r33_outstanding_balance;
	}
	public void setR33_outstanding_balance(BigDecimal r33_outstanding_balance) {
		this.r33_outstanding_balance = r33_outstanding_balance;
	}
	public BigDecimal getR33_provision_suspense() {
		return r33_provision_suspense;
	}
	public void setR33_provision_suspense(BigDecimal r33_provision_suspense) {
		this.r33_provision_suspense = r33_provision_suspense;
	}
	public BigDecimal getR33_stage3_provision() {
		return r33_stage3_provision;
	}
	public void setR33_stage3_provision(BigDecimal r33_stage3_provision) {
		this.r33_stage3_provision = r33_stage3_provision;
	}
	public BigDecimal getR33_other_alloate() {
		return r33_other_alloate;
	}
	public void setR33_other_alloate(BigDecimal r33_other_alloate) {
		this.r33_other_alloate = r33_other_alloate;
	}
	public BigDecimal getR33_1_asset() {
		return r33_1_asset;
	}
	public void setR33_1_asset(BigDecimal r33_1_asset) {
		this.r33_1_asset = r33_1_asset;
	}
	public BigDecimal getR33_2_asset() {
		return r33_2_asset;
	}
	public void setR33_2_asset(BigDecimal r33_2_asset) {
		this.r33_2_asset = r33_2_asset;
	}
	public BigDecimal getR33_3a_asset() {
		return r33_3a_asset;
	}
	public void setR33_3a_asset(BigDecimal r33_3a_asset) {
		this.r33_3a_asset = r33_3a_asset;
	}
	public BigDecimal getR33_3b_asset() {
		return r33_3b_asset;
	}
	public void setR33_3b_asset(BigDecimal r33_3b_asset) {
		this.r33_3b_asset = r33_3b_asset;
	}
	public BigDecimal getR33_3c_asset() {
		return r33_3c_asset;
	}
	public void setR33_3c_asset(BigDecimal r33_3c_asset) {
		this.r33_3c_asset = r33_3c_asset;
	}
	public BigDecimal getR33_1_provision() {
		return r33_1_provision;
	}
	public void setR33_1_provision(BigDecimal r33_1_provision) {
		this.r33_1_provision = r33_1_provision;
	}
	public BigDecimal getR33_2_provision() {
		return r33_2_provision;
	}
	public void setR33_2_provision(BigDecimal r33_2_provision) {
		this.r33_2_provision = r33_2_provision;
	}
	public BigDecimal getR33_3a_provision() {
		return r33_3a_provision;
	}
	public void setR33_3a_provision(BigDecimal r33_3a_provision) {
		this.r33_3a_provision = r33_3a_provision;
	}
	public BigDecimal getR33_3b_provision() {
		return r33_3b_provision;
	}
	public void setR33_3b_provision(BigDecimal r33_3b_provision) {
		this.r33_3b_provision = r33_3b_provision;
	}
	public BigDecimal getR33_3c_provision() {
		return r33_3c_provision;
	}
	public void setR33_3c_provision(BigDecimal r33_3c_provision) {
		this.r33_3c_provision = r33_3c_provision;
	}
	public BigDecimal getR33_current() {
		return r33_current;
	}
	public void setR33_current(BigDecimal r33_current) {
		this.r33_current = r33_current;
	}
	public BigDecimal getR33_lessthan_30() {
		return r33_lessthan_30;
	}
	public void setR33_lessthan_30(BigDecimal r33_lessthan_30) {
		this.r33_lessthan_30 = r33_lessthan_30;
	}
	public BigDecimal getR33_exclusive_90days() {
		return r33_exclusive_90days;
	}
	public void setR33_exclusive_90days(BigDecimal r33_exclusive_90days) {
		this.r33_exclusive_90days = r33_exclusive_90days;
	}
	public BigDecimal getR33_exclusive_120days() {
		return r33_exclusive_120days;
	}
	public void setR33_exclusive_120days(BigDecimal r33_exclusive_120days) {
		this.r33_exclusive_120days = r33_exclusive_120days;
	}
	public BigDecimal getR33_exclusive_180days() {
		return r33_exclusive_180days;
	}
	public void setR33_exclusive_180days(BigDecimal r33_exclusive_180days) {
		this.r33_exclusive_180days = r33_exclusive_180days;
	}
	public BigDecimal getR33_exclusive_over_180days() {
		return r33_exclusive_over_180days;
	}
	public void setR33_exclusive_over_180days(BigDecimal r33_exclusive_over_180days) {
		this.r33_exclusive_over_180days = r33_exclusive_over_180days;
	}
	public BigDecimal getR33_total_past() {
		return r33_total_past;
	}
	public void setR33_total_past(BigDecimal r33_total_past) {
		this.r33_total_past = r33_total_past;
	}
	public BigDecimal getR33_new_stage3() {
		return r33_new_stage3;
	}
	public void setR33_new_stage3(BigDecimal r33_new_stage3) {
		this.r33_new_stage3 = r33_new_stage3;
	}
	public BigDecimal getR33_new_specific() {
		return r33_new_specific;
	}
	public void setR33_new_specific(BigDecimal r33_new_specific) {
		this.r33_new_specific = r33_new_specific;
	}
	public BigDecimal getR33_new_other() {
		return r33_new_other;
	}
	public void setR33_new_other(BigDecimal r33_new_other) {
		this.r33_new_other = r33_new_other;
	}
	public BigDecimal getR33_performing_accounts() {
		return r33_performing_accounts;
	}
	public void setR33_performing_accounts(BigDecimal r33_performing_accounts) {
		this.r33_performing_accounts = r33_performing_accounts;
	}
	public BigDecimal getR33_non_performing_accounts() {
		return r33_non_performing_accounts;
	}
	public void setR33_non_performing_accounts(BigDecimal r33_non_performing_accounts) {
		this.r33_non_performing_accounts = r33_non_performing_accounts;
	}
	public String getR33_outstanding_check() {
		return r33_outstanding_check;
	}
	public void setR33_outstanding_check(String r33_outstanding_check) {
		this.r33_outstanding_check = r33_outstanding_check;
	}
	public String getR33_provision_check() {
		return r33_provision_check;
	}
	public void setR33_provision_check(String r33_provision_check) {
		this.r33_provision_check = r33_provision_check;
	}
	public String getR33_past_due_date() {
		return r33_past_due_date;
	}
	public void setR33_past_due_date(String r33_past_due_date) {
		this.r33_past_due_date = r33_past_due_date;
	}
	public String getR34_asset_classes() {
		return r34_asset_classes;
	}
	public void setR34_asset_classes(String r34_asset_classes) {
		this.r34_asset_classes = r34_asset_classes;
	}
	public BigDecimal getR34_outstanding_balance() {
		return r34_outstanding_balance;
	}
	public void setR34_outstanding_balance(BigDecimal r34_outstanding_balance) {
		this.r34_outstanding_balance = r34_outstanding_balance;
	}
	public BigDecimal getR34_provision_suspense() {
		return r34_provision_suspense;
	}
	public void setR34_provision_suspense(BigDecimal r34_provision_suspense) {
		this.r34_provision_suspense = r34_provision_suspense;
	}
	public BigDecimal getR34_stage3_provision() {
		return r34_stage3_provision;
	}
	public void setR34_stage3_provision(BigDecimal r34_stage3_provision) {
		this.r34_stage3_provision = r34_stage3_provision;
	}
	public BigDecimal getR34_other_alloate() {
		return r34_other_alloate;
	}
	public void setR34_other_alloate(BigDecimal r34_other_alloate) {
		this.r34_other_alloate = r34_other_alloate;
	}
	public BigDecimal getR34_1_asset() {
		return r34_1_asset;
	}
	public void setR34_1_asset(BigDecimal r34_1_asset) {
		this.r34_1_asset = r34_1_asset;
	}
	public BigDecimal getR34_2_asset() {
		return r34_2_asset;
	}
	public void setR34_2_asset(BigDecimal r34_2_asset) {
		this.r34_2_asset = r34_2_asset;
	}
	public BigDecimal getR34_3a_asset() {
		return r34_3a_asset;
	}
	public void setR34_3a_asset(BigDecimal r34_3a_asset) {
		this.r34_3a_asset = r34_3a_asset;
	}
	public BigDecimal getR34_3b_asset() {
		return r34_3b_asset;
	}
	public void setR34_3b_asset(BigDecimal r34_3b_asset) {
		this.r34_3b_asset = r34_3b_asset;
	}
	public BigDecimal getR34_3c_asset() {
		return r34_3c_asset;
	}
	public void setR34_3c_asset(BigDecimal r34_3c_asset) {
		this.r34_3c_asset = r34_3c_asset;
	}
	public BigDecimal getR34_1_provision() {
		return r34_1_provision;
	}
	public void setR34_1_provision(BigDecimal r34_1_provision) {
		this.r34_1_provision = r34_1_provision;
	}
	public BigDecimal getR34_2_provision() {
		return r34_2_provision;
	}
	public void setR34_2_provision(BigDecimal r34_2_provision) {
		this.r34_2_provision = r34_2_provision;
	}
	public BigDecimal getR34_3a_provision() {
		return r34_3a_provision;
	}
	public void setR34_3a_provision(BigDecimal r34_3a_provision) {
		this.r34_3a_provision = r34_3a_provision;
	}
	public BigDecimal getR34_3b_provision() {
		return r34_3b_provision;
	}
	public void setR34_3b_provision(BigDecimal r34_3b_provision) {
		this.r34_3b_provision = r34_3b_provision;
	}
	public BigDecimal getR34_3c_provision() {
		return r34_3c_provision;
	}
	public void setR34_3c_provision(BigDecimal r34_3c_provision) {
		this.r34_3c_provision = r34_3c_provision;
	}
	public BigDecimal getR34_current() {
		return r34_current;
	}
	public void setR34_current(BigDecimal r34_current) {
		this.r34_current = r34_current;
	}
	public BigDecimal getR34_lessthan_30() {
		return r34_lessthan_30;
	}
	public void setR34_lessthan_30(BigDecimal r34_lessthan_30) {
		this.r34_lessthan_30 = r34_lessthan_30;
	}
	public BigDecimal getR34_exclusive_90days() {
		return r34_exclusive_90days;
	}
	public void setR34_exclusive_90days(BigDecimal r34_exclusive_90days) {
		this.r34_exclusive_90days = r34_exclusive_90days;
	}
	public BigDecimal getR34_exclusive_120days() {
		return r34_exclusive_120days;
	}
	public void setR34_exclusive_120days(BigDecimal r34_exclusive_120days) {
		this.r34_exclusive_120days = r34_exclusive_120days;
	}
	public BigDecimal getR34_exclusive_180days() {
		return r34_exclusive_180days;
	}
	public void setR34_exclusive_180days(BigDecimal r34_exclusive_180days) {
		this.r34_exclusive_180days = r34_exclusive_180days;
	}
	public BigDecimal getR34_exclusive_over_180days() {
		return r34_exclusive_over_180days;
	}
	public void setR34_exclusive_over_180days(BigDecimal r34_exclusive_over_180days) {
		this.r34_exclusive_over_180days = r34_exclusive_over_180days;
	}
	public BigDecimal getR34_total_past() {
		return r34_total_past;
	}
	public void setR34_total_past(BigDecimal r34_total_past) {
		this.r34_total_past = r34_total_past;
	}
	public BigDecimal getR34_new_stage3() {
		return r34_new_stage3;
	}
	public void setR34_new_stage3(BigDecimal r34_new_stage3) {
		this.r34_new_stage3 = r34_new_stage3;
	}
	public BigDecimal getR34_new_specific() {
		return r34_new_specific;
	}
	public void setR34_new_specific(BigDecimal r34_new_specific) {
		this.r34_new_specific = r34_new_specific;
	}
	public BigDecimal getR34_new_other() {
		return r34_new_other;
	}
	public void setR34_new_other(BigDecimal r34_new_other) {
		this.r34_new_other = r34_new_other;
	}
	public BigDecimal getR34_performing_accounts() {
		return r34_performing_accounts;
	}
	public void setR34_performing_accounts(BigDecimal r34_performing_accounts) {
		this.r34_performing_accounts = r34_performing_accounts;
	}
	public BigDecimal getR34_non_performing_accounts() {
		return r34_non_performing_accounts;
	}
	public void setR34_non_performing_accounts(BigDecimal r34_non_performing_accounts) {
		this.r34_non_performing_accounts = r34_non_performing_accounts;
	}
	public String getR34_outstanding_check() {
		return r34_outstanding_check;
	}
	public void setR34_outstanding_check(String r34_outstanding_check) {
		this.r34_outstanding_check = r34_outstanding_check;
	}
	public String getR34_provision_check() {
		return r34_provision_check;
	}
	public void setR34_provision_check(String r34_provision_check) {
		this.r34_provision_check = r34_provision_check;
	}
	public String getR34_past_due_date() {
		return r34_past_due_date;
	}
	public void setR34_past_due_date(String r34_past_due_date) {
		this.r34_past_due_date = r34_past_due_date;
	}
	public String getR35_asset_classes() {
		return r35_asset_classes;
	}
	public void setR35_asset_classes(String r35_asset_classes) {
		this.r35_asset_classes = r35_asset_classes;
	}
	public BigDecimal getR35_outstanding_balance() {
		return r35_outstanding_balance;
	}
	public void setR35_outstanding_balance(BigDecimal r35_outstanding_balance) {
		this.r35_outstanding_balance = r35_outstanding_balance;
	}
	public BigDecimal getR35_provision_suspense() {
		return r35_provision_suspense;
	}
	public void setR35_provision_suspense(BigDecimal r35_provision_suspense) {
		this.r35_provision_suspense = r35_provision_suspense;
	}
	public BigDecimal getR35_stage3_provision() {
		return r35_stage3_provision;
	}
	public void setR35_stage3_provision(BigDecimal r35_stage3_provision) {
		this.r35_stage3_provision = r35_stage3_provision;
	}
	public BigDecimal getR35_other_alloate() {
		return r35_other_alloate;
	}
	public void setR35_other_alloate(BigDecimal r35_other_alloate) {
		this.r35_other_alloate = r35_other_alloate;
	}
	public BigDecimal getR35_1_asset() {
		return r35_1_asset;
	}
	public void setR35_1_asset(BigDecimal r35_1_asset) {
		this.r35_1_asset = r35_1_asset;
	}
	public BigDecimal getR35_2_asset() {
		return r35_2_asset;
	}
	public void setR35_2_asset(BigDecimal r35_2_asset) {
		this.r35_2_asset = r35_2_asset;
	}
	public BigDecimal getR35_3a_asset() {
		return r35_3a_asset;
	}
	public void setR35_3a_asset(BigDecimal r35_3a_asset) {
		this.r35_3a_asset = r35_3a_asset;
	}
	public BigDecimal getR35_3b_asset() {
		return r35_3b_asset;
	}
	public void setR35_3b_asset(BigDecimal r35_3b_asset) {
		this.r35_3b_asset = r35_3b_asset;
	}
	public BigDecimal getR35_3c_asset() {
		return r35_3c_asset;
	}
	public void setR35_3c_asset(BigDecimal r35_3c_asset) {
		this.r35_3c_asset = r35_3c_asset;
	}
	public BigDecimal getR35_1_provision() {
		return r35_1_provision;
	}
	public void setR35_1_provision(BigDecimal r35_1_provision) {
		this.r35_1_provision = r35_1_provision;
	}
	public BigDecimal getR35_2_provision() {
		return r35_2_provision;
	}
	public void setR35_2_provision(BigDecimal r35_2_provision) {
		this.r35_2_provision = r35_2_provision;
	}
	public BigDecimal getR35_3a_provision() {
		return r35_3a_provision;
	}
	public void setR35_3a_provision(BigDecimal r35_3a_provision) {
		this.r35_3a_provision = r35_3a_provision;
	}
	public BigDecimal getR35_3b_provision() {
		return r35_3b_provision;
	}
	public void setR35_3b_provision(BigDecimal r35_3b_provision) {
		this.r35_3b_provision = r35_3b_provision;
	}
	public BigDecimal getR35_3c_provision() {
		return r35_3c_provision;
	}
	public void setR35_3c_provision(BigDecimal r35_3c_provision) {
		this.r35_3c_provision = r35_3c_provision;
	}
	public BigDecimal getR35_current() {
		return r35_current;
	}
	public void setR35_current(BigDecimal r35_current) {
		this.r35_current = r35_current;
	}
	public BigDecimal getR35_lessthan_30() {
		return r35_lessthan_30;
	}
	public void setR35_lessthan_30(BigDecimal r35_lessthan_30) {
		this.r35_lessthan_30 = r35_lessthan_30;
	}
	public BigDecimal getR35_exclusive_90days() {
		return r35_exclusive_90days;
	}
	public void setR35_exclusive_90days(BigDecimal r35_exclusive_90days) {
		this.r35_exclusive_90days = r35_exclusive_90days;
	}
	public BigDecimal getR35_exclusive_120days() {
		return r35_exclusive_120days;
	}
	public void setR35_exclusive_120days(BigDecimal r35_exclusive_120days) {
		this.r35_exclusive_120days = r35_exclusive_120days;
	}
	public BigDecimal getR35_exclusive_180days() {
		return r35_exclusive_180days;
	}
	public void setR35_exclusive_180days(BigDecimal r35_exclusive_180days) {
		this.r35_exclusive_180days = r35_exclusive_180days;
	}
	public BigDecimal getR35_exclusive_over_180days() {
		return r35_exclusive_over_180days;
	}
	public void setR35_exclusive_over_180days(BigDecimal r35_exclusive_over_180days) {
		this.r35_exclusive_over_180days = r35_exclusive_over_180days;
	}
	public BigDecimal getR35_total_past() {
		return r35_total_past;
	}
	public void setR35_total_past(BigDecimal r35_total_past) {
		this.r35_total_past = r35_total_past;
	}
	public BigDecimal getR35_new_stage3() {
		return r35_new_stage3;
	}
	public void setR35_new_stage3(BigDecimal r35_new_stage3) {
		this.r35_new_stage3 = r35_new_stage3;
	}
	public BigDecimal getR35_new_specific() {
		return r35_new_specific;
	}
	public void setR35_new_specific(BigDecimal r35_new_specific) {
		this.r35_new_specific = r35_new_specific;
	}
	public BigDecimal getR35_new_other() {
		return r35_new_other;
	}
	public void setR35_new_other(BigDecimal r35_new_other) {
		this.r35_new_other = r35_new_other;
	}
	public BigDecimal getR35_performing_accounts() {
		return r35_performing_accounts;
	}
	public void setR35_performing_accounts(BigDecimal r35_performing_accounts) {
		this.r35_performing_accounts = r35_performing_accounts;
	}
	public BigDecimal getR35_non_performing_accounts() {
		return r35_non_performing_accounts;
	}
	public void setR35_non_performing_accounts(BigDecimal r35_non_performing_accounts) {
		this.r35_non_performing_accounts = r35_non_performing_accounts;
	}
	public String getR35_outstanding_check() {
		return r35_outstanding_check;
	}
	public void setR35_outstanding_check(String r35_outstanding_check) {
		this.r35_outstanding_check = r35_outstanding_check;
	}
	public String getR35_provision_check() {
		return r35_provision_check;
	}
	public void setR35_provision_check(String r35_provision_check) {
		this.r35_provision_check = r35_provision_check;
	}
	public String getR35_past_due_date() {
		return r35_past_due_date;
	}
	public void setR35_past_due_date(String r35_past_due_date) {
		this.r35_past_due_date = r35_past_due_date;
	}
	public String getR36_asset_classes() {
		return r36_asset_classes;
	}
	public void setR36_asset_classes(String r36_asset_classes) {
		this.r36_asset_classes = r36_asset_classes;
	}
	public BigDecimal getR36_outstanding_balance() {
		return r36_outstanding_balance;
	}
	public void setR36_outstanding_balance(BigDecimal r36_outstanding_balance) {
		this.r36_outstanding_balance = r36_outstanding_balance;
	}
	public BigDecimal getR36_provision_suspense() {
		return r36_provision_suspense;
	}
	public void setR36_provision_suspense(BigDecimal r36_provision_suspense) {
		this.r36_provision_suspense = r36_provision_suspense;
	}
	public BigDecimal getR36_stage3_provision() {
		return r36_stage3_provision;
	}
	public void setR36_stage3_provision(BigDecimal r36_stage3_provision) {
		this.r36_stage3_provision = r36_stage3_provision;
	}
	public BigDecimal getR36_other_alloate() {
		return r36_other_alloate;
	}
	public void setR36_other_alloate(BigDecimal r36_other_alloate) {
		this.r36_other_alloate = r36_other_alloate;
	}
	public BigDecimal getR36_1_asset() {
		return r36_1_asset;
	}
	public void setR36_1_asset(BigDecimal r36_1_asset) {
		this.r36_1_asset = r36_1_asset;
	}
	public BigDecimal getR36_2_asset() {
		return r36_2_asset;
	}
	public void setR36_2_asset(BigDecimal r36_2_asset) {
		this.r36_2_asset = r36_2_asset;
	}
	public BigDecimal getR36_3a_asset() {
		return r36_3a_asset;
	}
	public void setR36_3a_asset(BigDecimal r36_3a_asset) {
		this.r36_3a_asset = r36_3a_asset;
	}
	public BigDecimal getR36_3b_asset() {
		return r36_3b_asset;
	}
	public void setR36_3b_asset(BigDecimal r36_3b_asset) {
		this.r36_3b_asset = r36_3b_asset;
	}
	public BigDecimal getR36_3c_asset() {
		return r36_3c_asset;
	}
	public void setR36_3c_asset(BigDecimal r36_3c_asset) {
		this.r36_3c_asset = r36_3c_asset;
	}
	public BigDecimal getR36_1_provision() {
		return r36_1_provision;
	}
	public void setR36_1_provision(BigDecimal r36_1_provision) {
		this.r36_1_provision = r36_1_provision;
	}
	public BigDecimal getR36_2_provision() {
		return r36_2_provision;
	}
	public void setR36_2_provision(BigDecimal r36_2_provision) {
		this.r36_2_provision = r36_2_provision;
	}
	public BigDecimal getR36_3a_provision() {
		return r36_3a_provision;
	}
	public void setR36_3a_provision(BigDecimal r36_3a_provision) {
		this.r36_3a_provision = r36_3a_provision;
	}
	public BigDecimal getR36_3b_provision() {
		return r36_3b_provision;
	}
	public void setR36_3b_provision(BigDecimal r36_3b_provision) {
		this.r36_3b_provision = r36_3b_provision;
	}
	public BigDecimal getR36_3c_provision() {
		return r36_3c_provision;
	}
	public void setR36_3c_provision(BigDecimal r36_3c_provision) {
		this.r36_3c_provision = r36_3c_provision;
	}
	public BigDecimal getR36_current() {
		return r36_current;
	}
	public void setR36_current(BigDecimal r36_current) {
		this.r36_current = r36_current;
	}
	public BigDecimal getR36_lessthan_30() {
		return r36_lessthan_30;
	}
	public void setR36_lessthan_30(BigDecimal r36_lessthan_30) {
		this.r36_lessthan_30 = r36_lessthan_30;
	}
	public BigDecimal getR36_exclusive_90days() {
		return r36_exclusive_90days;
	}
	public void setR36_exclusive_90days(BigDecimal r36_exclusive_90days) {
		this.r36_exclusive_90days = r36_exclusive_90days;
	}
	public BigDecimal getR36_exclusive_120days() {
		return r36_exclusive_120days;
	}
	public void setR36_exclusive_120days(BigDecimal r36_exclusive_120days) {
		this.r36_exclusive_120days = r36_exclusive_120days;
	}
	public BigDecimal getR36_exclusive_180days() {
		return r36_exclusive_180days;
	}
	public void setR36_exclusive_180days(BigDecimal r36_exclusive_180days) {
		this.r36_exclusive_180days = r36_exclusive_180days;
	}
	public BigDecimal getR36_exclusive_over_180days() {
		return r36_exclusive_over_180days;
	}
	public void setR36_exclusive_over_180days(BigDecimal r36_exclusive_over_180days) {
		this.r36_exclusive_over_180days = r36_exclusive_over_180days;
	}
	public BigDecimal getR36_total_past() {
		return r36_total_past;
	}
	public void setR36_total_past(BigDecimal r36_total_past) {
		this.r36_total_past = r36_total_past;
	}
	public BigDecimal getR36_new_stage3() {
		return r36_new_stage3;
	}
	public void setR36_new_stage3(BigDecimal r36_new_stage3) {
		this.r36_new_stage3 = r36_new_stage3;
	}
	public BigDecimal getR36_new_specific() {
		return r36_new_specific;
	}
	public void setR36_new_specific(BigDecimal r36_new_specific) {
		this.r36_new_specific = r36_new_specific;
	}
	public BigDecimal getR36_new_other() {
		return r36_new_other;
	}
	public void setR36_new_other(BigDecimal r36_new_other) {
		this.r36_new_other = r36_new_other;
	}
	public BigDecimal getR36_performing_accounts() {
		return r36_performing_accounts;
	}
	public void setR36_performing_accounts(BigDecimal r36_performing_accounts) {
		this.r36_performing_accounts = r36_performing_accounts;
	}
	public BigDecimal getR36_non_performing_accounts() {
		return r36_non_performing_accounts;
	}
	public void setR36_non_performing_accounts(BigDecimal r36_non_performing_accounts) {
		this.r36_non_performing_accounts = r36_non_performing_accounts;
	}
	public String getR36_outstanding_check() {
		return r36_outstanding_check;
	}
	public void setR36_outstanding_check(String r36_outstanding_check) {
		this.r36_outstanding_check = r36_outstanding_check;
	}
	public String getR36_provision_check() {
		return r36_provision_check;
	}
	public void setR36_provision_check(String r36_provision_check) {
		this.r36_provision_check = r36_provision_check;
	}
	public String getR36_past_due_date() {
		return r36_past_due_date;
	}
	public void setR36_past_due_date(String r36_past_due_date) {
		this.r36_past_due_date = r36_past_due_date;
	}
	public String getR37_asset_classes() {
		return r37_asset_classes;
	}
	public void setR37_asset_classes(String r37_asset_classes) {
		this.r37_asset_classes = r37_asset_classes;
	}
	public BigDecimal getR37_outstanding_balance() {
		return r37_outstanding_balance;
	}
	public void setR37_outstanding_balance(BigDecimal r37_outstanding_balance) {
		this.r37_outstanding_balance = r37_outstanding_balance;
	}
	public BigDecimal getR37_provision_suspense() {
		return r37_provision_suspense;
	}
	public void setR37_provision_suspense(BigDecimal r37_provision_suspense) {
		this.r37_provision_suspense = r37_provision_suspense;
	}
	public BigDecimal getR37_stage3_provision() {
		return r37_stage3_provision;
	}
	public void setR37_stage3_provision(BigDecimal r37_stage3_provision) {
		this.r37_stage3_provision = r37_stage3_provision;
	}
	public BigDecimal getR37_other_alloate() {
		return r37_other_alloate;
	}
	public void setR37_other_alloate(BigDecimal r37_other_alloate) {
		this.r37_other_alloate = r37_other_alloate;
	}
	public BigDecimal getR37_1_asset() {
		return r37_1_asset;
	}
	public void setR37_1_asset(BigDecimal r37_1_asset) {
		this.r37_1_asset = r37_1_asset;
	}
	public BigDecimal getR37_2_asset() {
		return r37_2_asset;
	}
	public void setR37_2_asset(BigDecimal r37_2_asset) {
		this.r37_2_asset = r37_2_asset;
	}
	public BigDecimal getR37_3a_asset() {
		return r37_3a_asset;
	}
	public void setR37_3a_asset(BigDecimal r37_3a_asset) {
		this.r37_3a_asset = r37_3a_asset;
	}
	public BigDecimal getR37_3b_asset() {
		return r37_3b_asset;
	}
	public void setR37_3b_asset(BigDecimal r37_3b_asset) {
		this.r37_3b_asset = r37_3b_asset;
	}
	public BigDecimal getR37_3c_asset() {
		return r37_3c_asset;
	}
	public void setR37_3c_asset(BigDecimal r37_3c_asset) {
		this.r37_3c_asset = r37_3c_asset;
	}
	public BigDecimal getR37_1_provision() {
		return r37_1_provision;
	}
	public void setR37_1_provision(BigDecimal r37_1_provision) {
		this.r37_1_provision = r37_1_provision;
	}
	public BigDecimal getR37_2_provision() {
		return r37_2_provision;
	}
	public void setR37_2_provision(BigDecimal r37_2_provision) {
		this.r37_2_provision = r37_2_provision;
	}
	public BigDecimal getR37_3a_provision() {
		return r37_3a_provision;
	}
	public void setR37_3a_provision(BigDecimal r37_3a_provision) {
		this.r37_3a_provision = r37_3a_provision;
	}
	public BigDecimal getR37_3b_provision() {
		return r37_3b_provision;
	}
	public void setR37_3b_provision(BigDecimal r37_3b_provision) {
		this.r37_3b_provision = r37_3b_provision;
	}
	public BigDecimal getR37_3c_provision() {
		return r37_3c_provision;
	}
	public void setR37_3c_provision(BigDecimal r37_3c_provision) {
		this.r37_3c_provision = r37_3c_provision;
	}
	public BigDecimal getR37_current() {
		return r37_current;
	}
	public void setR37_current(BigDecimal r37_current) {
		this.r37_current = r37_current;
	}
	public BigDecimal getR37_lessthan_30() {
		return r37_lessthan_30;
	}
	public void setR37_lessthan_30(BigDecimal r37_lessthan_30) {
		this.r37_lessthan_30 = r37_lessthan_30;
	}
	public BigDecimal getR37_exclusive_90days() {
		return r37_exclusive_90days;
	}
	public void setR37_exclusive_90days(BigDecimal r37_exclusive_90days) {
		this.r37_exclusive_90days = r37_exclusive_90days;
	}
	public BigDecimal getR37_exclusive_120days() {
		return r37_exclusive_120days;
	}
	public void setR37_exclusive_120days(BigDecimal r37_exclusive_120days) {
		this.r37_exclusive_120days = r37_exclusive_120days;
	}
	public BigDecimal getR37_exclusive_180days() {
		return r37_exclusive_180days;
	}
	public void setR37_exclusive_180days(BigDecimal r37_exclusive_180days) {
		this.r37_exclusive_180days = r37_exclusive_180days;
	}
	public BigDecimal getR37_exclusive_over_180days() {
		return r37_exclusive_over_180days;
	}
	public void setR37_exclusive_over_180days(BigDecimal r37_exclusive_over_180days) {
		this.r37_exclusive_over_180days = r37_exclusive_over_180days;
	}
	public BigDecimal getR37_total_past() {
		return r37_total_past;
	}
	public void setR37_total_past(BigDecimal r37_total_past) {
		this.r37_total_past = r37_total_past;
	}
	public BigDecimal getR37_new_stage3() {
		return r37_new_stage3;
	}
	public void setR37_new_stage3(BigDecimal r37_new_stage3) {
		this.r37_new_stage3 = r37_new_stage3;
	}
	public BigDecimal getR37_new_specific() {
		return r37_new_specific;
	}
	public void setR37_new_specific(BigDecimal r37_new_specific) {
		this.r37_new_specific = r37_new_specific;
	}
	public BigDecimal getR37_new_other() {
		return r37_new_other;
	}
	public void setR37_new_other(BigDecimal r37_new_other) {
		this.r37_new_other = r37_new_other;
	}
	public BigDecimal getR37_performing_accounts() {
		return r37_performing_accounts;
	}
	public void setR37_performing_accounts(BigDecimal r37_performing_accounts) {
		this.r37_performing_accounts = r37_performing_accounts;
	}
	public BigDecimal getR37_non_performing_accounts() {
		return r37_non_performing_accounts;
	}
	public void setR37_non_performing_accounts(BigDecimal r37_non_performing_accounts) {
		this.r37_non_performing_accounts = r37_non_performing_accounts;
	}
	public String getR37_outstanding_check() {
		return r37_outstanding_check;
	}
	public void setR37_outstanding_check(String r37_outstanding_check) {
		this.r37_outstanding_check = r37_outstanding_check;
	}
	public String getR37_provision_check() {
		return r37_provision_check;
	}
	public void setR37_provision_check(String r37_provision_check) {
		this.r37_provision_check = r37_provision_check;
	}
	public String getR37_past_due_date() {
		return r37_past_due_date;
	}
	public void setR37_past_due_date(String r37_past_due_date) {
		this.r37_past_due_date = r37_past_due_date;
	}
	public String getR38_asset_classes() {
		return r38_asset_classes;
	}
	public void setR38_asset_classes(String r38_asset_classes) {
		this.r38_asset_classes = r38_asset_classes;
	}
	public BigDecimal getR38_outstanding_balance() {
		return r38_outstanding_balance;
	}
	public void setR38_outstanding_balance(BigDecimal r38_outstanding_balance) {
		this.r38_outstanding_balance = r38_outstanding_balance;
	}
	public BigDecimal getR38_provision_suspense() {
		return r38_provision_suspense;
	}
	public void setR38_provision_suspense(BigDecimal r38_provision_suspense) {
		this.r38_provision_suspense = r38_provision_suspense;
	}
	public BigDecimal getR38_stage3_provision() {
		return r38_stage3_provision;
	}
	public void setR38_stage3_provision(BigDecimal r38_stage3_provision) {
		this.r38_stage3_provision = r38_stage3_provision;
	}
	public BigDecimal getR38_other_alloate() {
		return r38_other_alloate;
	}
	public void setR38_other_alloate(BigDecimal r38_other_alloate) {
		this.r38_other_alloate = r38_other_alloate;
	}
	public BigDecimal getR38_1_asset() {
		return r38_1_asset;
	}
	public void setR38_1_asset(BigDecimal r38_1_asset) {
		this.r38_1_asset = r38_1_asset;
	}
	public BigDecimal getR38_2_asset() {
		return r38_2_asset;
	}
	public void setR38_2_asset(BigDecimal r38_2_asset) {
		this.r38_2_asset = r38_2_asset;
	}
	public BigDecimal getR38_3a_asset() {
		return r38_3a_asset;
	}
	public void setR38_3a_asset(BigDecimal r38_3a_asset) {
		this.r38_3a_asset = r38_3a_asset;
	}
	public BigDecimal getR38_3b_asset() {
		return r38_3b_asset;
	}
	public void setR38_3b_asset(BigDecimal r38_3b_asset) {
		this.r38_3b_asset = r38_3b_asset;
	}
	public BigDecimal getR38_3c_asset() {
		return r38_3c_asset;
	}
	public void setR38_3c_asset(BigDecimal r38_3c_asset) {
		this.r38_3c_asset = r38_3c_asset;
	}
	public BigDecimal getR38_1_provision() {
		return r38_1_provision;
	}
	public void setR38_1_provision(BigDecimal r38_1_provision) {
		this.r38_1_provision = r38_1_provision;
	}
	public BigDecimal getR38_2_provision() {
		return r38_2_provision;
	}
	public void setR38_2_provision(BigDecimal r38_2_provision) {
		this.r38_2_provision = r38_2_provision;
	}
	public BigDecimal getR38_3a_provision() {
		return r38_3a_provision;
	}
	public void setR38_3a_provision(BigDecimal r38_3a_provision) {
		this.r38_3a_provision = r38_3a_provision;
	}
	public BigDecimal getR38_3b_provision() {
		return r38_3b_provision;
	}
	public void setR38_3b_provision(BigDecimal r38_3b_provision) {
		this.r38_3b_provision = r38_3b_provision;
	}
	public BigDecimal getR38_3c_provision() {
		return r38_3c_provision;
	}
	public void setR38_3c_provision(BigDecimal r38_3c_provision) {
		this.r38_3c_provision = r38_3c_provision;
	}
	public BigDecimal getR38_current() {
		return r38_current;
	}
	public void setR38_current(BigDecimal r38_current) {
		this.r38_current = r38_current;
	}
	public BigDecimal getR38_lessthan_30() {
		return r38_lessthan_30;
	}
	public void setR38_lessthan_30(BigDecimal r38_lessthan_30) {
		this.r38_lessthan_30 = r38_lessthan_30;
	}
	public BigDecimal getR38_exclusive_90days() {
		return r38_exclusive_90days;
	}
	public void setR38_exclusive_90days(BigDecimal r38_exclusive_90days) {
		this.r38_exclusive_90days = r38_exclusive_90days;
	}
	public BigDecimal getR38_exclusive_120days() {
		return r38_exclusive_120days;
	}
	public void setR38_exclusive_120days(BigDecimal r38_exclusive_120days) {
		this.r38_exclusive_120days = r38_exclusive_120days;
	}
	public BigDecimal getR38_exclusive_180days() {
		return r38_exclusive_180days;
	}
	public void setR38_exclusive_180days(BigDecimal r38_exclusive_180days) {
		this.r38_exclusive_180days = r38_exclusive_180days;
	}
	public BigDecimal getR38_exclusive_over_180days() {
		return r38_exclusive_over_180days;
	}
	public void setR38_exclusive_over_180days(BigDecimal r38_exclusive_over_180days) {
		this.r38_exclusive_over_180days = r38_exclusive_over_180days;
	}
	public BigDecimal getR38_total_past() {
		return r38_total_past;
	}
	public void setR38_total_past(BigDecimal r38_total_past) {
		this.r38_total_past = r38_total_past;
	}
	public BigDecimal getR38_new_stage3() {
		return r38_new_stage3;
	}
	public void setR38_new_stage3(BigDecimal r38_new_stage3) {
		this.r38_new_stage3 = r38_new_stage3;
	}
	public BigDecimal getR38_new_specific() {
		return r38_new_specific;
	}
	public void setR38_new_specific(BigDecimal r38_new_specific) {
		this.r38_new_specific = r38_new_specific;
	}
	public BigDecimal getR38_new_other() {
		return r38_new_other;
	}
	public void setR38_new_other(BigDecimal r38_new_other) {
		this.r38_new_other = r38_new_other;
	}
	public BigDecimal getR38_performing_accounts() {
		return r38_performing_accounts;
	}
	public void setR38_performing_accounts(BigDecimal r38_performing_accounts) {
		this.r38_performing_accounts = r38_performing_accounts;
	}
	public BigDecimal getR38_non_performing_accounts() {
		return r38_non_performing_accounts;
	}
	public void setR38_non_performing_accounts(BigDecimal r38_non_performing_accounts) {
		this.r38_non_performing_accounts = r38_non_performing_accounts;
	}
	public String getR38_outstanding_check() {
		return r38_outstanding_check;
	}
	public void setR38_outstanding_check(String r38_outstanding_check) {
		this.r38_outstanding_check = r38_outstanding_check;
	}
	public String getR38_provision_check() {
		return r38_provision_check;
	}
	public void setR38_provision_check(String r38_provision_check) {
		this.r38_provision_check = r38_provision_check;
	}
	public String getR38_past_due_date() {
		return r38_past_due_date;
	}
	public void setR38_past_due_date(String r38_past_due_date) {
		this.r38_past_due_date = r38_past_due_date;
	}
	public String getR39_asset_classes() {
		return r39_asset_classes;
	}
	public void setR39_asset_classes(String r39_asset_classes) {
		this.r39_asset_classes = r39_asset_classes;
	}
	public BigDecimal getR39_outstanding_balance() {
		return r39_outstanding_balance;
	}
	public void setR39_outstanding_balance(BigDecimal r39_outstanding_balance) {
		this.r39_outstanding_balance = r39_outstanding_balance;
	}
	public BigDecimal getR39_provision_suspense() {
		return r39_provision_suspense;
	}
	public void setR39_provision_suspense(BigDecimal r39_provision_suspense) {
		this.r39_provision_suspense = r39_provision_suspense;
	}
	public BigDecimal getR39_stage3_provision() {
		return r39_stage3_provision;
	}
	public void setR39_stage3_provision(BigDecimal r39_stage3_provision) {
		this.r39_stage3_provision = r39_stage3_provision;
	}
	public BigDecimal getR39_other_alloate() {
		return r39_other_alloate;
	}
	public void setR39_other_alloate(BigDecimal r39_other_alloate) {
		this.r39_other_alloate = r39_other_alloate;
	}
	public BigDecimal getR39_1_asset() {
		return r39_1_asset;
	}
	public void setR39_1_asset(BigDecimal r39_1_asset) {
		this.r39_1_asset = r39_1_asset;
	}
	public BigDecimal getR39_2_asset() {
		return r39_2_asset;
	}
	public void setR39_2_asset(BigDecimal r39_2_asset) {
		this.r39_2_asset = r39_2_asset;
	}
	public BigDecimal getR39_3a_asset() {
		return r39_3a_asset;
	}
	public void setR39_3a_asset(BigDecimal r39_3a_asset) {
		this.r39_3a_asset = r39_3a_asset;
	}
	public BigDecimal getR39_3b_asset() {
		return r39_3b_asset;
	}
	public void setR39_3b_asset(BigDecimal r39_3b_asset) {
		this.r39_3b_asset = r39_3b_asset;
	}
	public BigDecimal getR39_3c_asset() {
		return r39_3c_asset;
	}
	public void setR39_3c_asset(BigDecimal r39_3c_asset) {
		this.r39_3c_asset = r39_3c_asset;
	}
	public BigDecimal getR39_1_provision() {
		return r39_1_provision;
	}
	public void setR39_1_provision(BigDecimal r39_1_provision) {
		this.r39_1_provision = r39_1_provision;
	}
	public BigDecimal getR39_2_provision() {
		return r39_2_provision;
	}
	public void setR39_2_provision(BigDecimal r39_2_provision) {
		this.r39_2_provision = r39_2_provision;
	}
	public BigDecimal getR39_3a_provision() {
		return r39_3a_provision;
	}
	public void setR39_3a_provision(BigDecimal r39_3a_provision) {
		this.r39_3a_provision = r39_3a_provision;
	}
	public BigDecimal getR39_3b_provision() {
		return r39_3b_provision;
	}
	public void setR39_3b_provision(BigDecimal r39_3b_provision) {
		this.r39_3b_provision = r39_3b_provision;
	}
	public BigDecimal getR39_3c_provision() {
		return r39_3c_provision;
	}
	public void setR39_3c_provision(BigDecimal r39_3c_provision) {
		this.r39_3c_provision = r39_3c_provision;
	}
	public BigDecimal getR39_current() {
		return r39_current;
	}
	public void setR39_current(BigDecimal r39_current) {
		this.r39_current = r39_current;
	}
	public BigDecimal getR39_lessthan_30() {
		return r39_lessthan_30;
	}
	public void setR39_lessthan_30(BigDecimal r39_lessthan_30) {
		this.r39_lessthan_30 = r39_lessthan_30;
	}
	public BigDecimal getR39_exclusive_90days() {
		return r39_exclusive_90days;
	}
	public void setR39_exclusive_90days(BigDecimal r39_exclusive_90days) {
		this.r39_exclusive_90days = r39_exclusive_90days;
	}
	public BigDecimal getR39_exclusive_120days() {
		return r39_exclusive_120days;
	}
	public void setR39_exclusive_120days(BigDecimal r39_exclusive_120days) {
		this.r39_exclusive_120days = r39_exclusive_120days;
	}
	public BigDecimal getR39_exclusive_180days() {
		return r39_exclusive_180days;
	}
	public void setR39_exclusive_180days(BigDecimal r39_exclusive_180days) {
		this.r39_exclusive_180days = r39_exclusive_180days;
	}
	public BigDecimal getR39_exclusive_over_180days() {
		return r39_exclusive_over_180days;
	}
	public void setR39_exclusive_over_180days(BigDecimal r39_exclusive_over_180days) {
		this.r39_exclusive_over_180days = r39_exclusive_over_180days;
	}
	public BigDecimal getR39_total_past() {
		return r39_total_past;
	}
	public void setR39_total_past(BigDecimal r39_total_past) {
		this.r39_total_past = r39_total_past;
	}
	public BigDecimal getR39_new_stage3() {
		return r39_new_stage3;
	}
	public void setR39_new_stage3(BigDecimal r39_new_stage3) {
		this.r39_new_stage3 = r39_new_stage3;
	}
	public BigDecimal getR39_new_specific() {
		return r39_new_specific;
	}
	public void setR39_new_specific(BigDecimal r39_new_specific) {
		this.r39_new_specific = r39_new_specific;
	}
	public BigDecimal getR39_new_other() {
		return r39_new_other;
	}
	public void setR39_new_other(BigDecimal r39_new_other) {
		this.r39_new_other = r39_new_other;
	}
	public BigDecimal getR39_performing_accounts() {
		return r39_performing_accounts;
	}
	public void setR39_performing_accounts(BigDecimal r39_performing_accounts) {
		this.r39_performing_accounts = r39_performing_accounts;
	}
	public BigDecimal getR39_non_performing_accounts() {
		return r39_non_performing_accounts;
	}
	public void setR39_non_performing_accounts(BigDecimal r39_non_performing_accounts) {
		this.r39_non_performing_accounts = r39_non_performing_accounts;
	}
	public String getR39_outstanding_check() {
		return r39_outstanding_check;
	}
	public void setR39_outstanding_check(String r39_outstanding_check) {
		this.r39_outstanding_check = r39_outstanding_check;
	}
	public String getR39_provision_check() {
		return r39_provision_check;
	}
	public void setR39_provision_check(String r39_provision_check) {
		this.r39_provision_check = r39_provision_check;
	}
	public String getR39_past_due_date() {
		return r39_past_due_date;
	}
	public void setR39_past_due_date(String r39_past_due_date) {
		this.r39_past_due_date = r39_past_due_date;
	}
	public String getR40_asset_classes() {
		return r40_asset_classes;
	}
	public void setR40_asset_classes(String r40_asset_classes) {
		this.r40_asset_classes = r40_asset_classes;
	}
	public BigDecimal getR40_outstanding_balance() {
		return r40_outstanding_balance;
	}
	public void setR40_outstanding_balance(BigDecimal r40_outstanding_balance) {
		this.r40_outstanding_balance = r40_outstanding_balance;
	}
	public BigDecimal getR40_provision_suspense() {
		return r40_provision_suspense;
	}
	public void setR40_provision_suspense(BigDecimal r40_provision_suspense) {
		this.r40_provision_suspense = r40_provision_suspense;
	}
	public BigDecimal getR40_stage3_provision() {
		return r40_stage3_provision;
	}
	public void setR40_stage3_provision(BigDecimal r40_stage3_provision) {
		this.r40_stage3_provision = r40_stage3_provision;
	}
	public BigDecimal getR40_other_alloate() {
		return r40_other_alloate;
	}
	public void setR40_other_alloate(BigDecimal r40_other_alloate) {
		this.r40_other_alloate = r40_other_alloate;
	}
	public BigDecimal getR40_1_asset() {
		return r40_1_asset;
	}
	public void setR40_1_asset(BigDecimal r40_1_asset) {
		this.r40_1_asset = r40_1_asset;
	}
	public BigDecimal getR40_2_asset() {
		return r40_2_asset;
	}
	public void setR40_2_asset(BigDecimal r40_2_asset) {
		this.r40_2_asset = r40_2_asset;
	}
	public BigDecimal getR40_3a_asset() {
		return r40_3a_asset;
	}
	public void setR40_3a_asset(BigDecimal r40_3a_asset) {
		this.r40_3a_asset = r40_3a_asset;
	}
	public BigDecimal getR40_3b_asset() {
		return r40_3b_asset;
	}
	public void setR40_3b_asset(BigDecimal r40_3b_asset) {
		this.r40_3b_asset = r40_3b_asset;
	}
	public BigDecimal getR40_3c_asset() {
		return r40_3c_asset;
	}
	public void setR40_3c_asset(BigDecimal r40_3c_asset) {
		this.r40_3c_asset = r40_3c_asset;
	}
	public BigDecimal getR40_1_provision() {
		return r40_1_provision;
	}
	public void setR40_1_provision(BigDecimal r40_1_provision) {
		this.r40_1_provision = r40_1_provision;
	}
	public BigDecimal getR40_2_provision() {
		return r40_2_provision;
	}
	public void setR40_2_provision(BigDecimal r40_2_provision) {
		this.r40_2_provision = r40_2_provision;
	}
	public BigDecimal getR40_3a_provision() {
		return r40_3a_provision;
	}
	public void setR40_3a_provision(BigDecimal r40_3a_provision) {
		this.r40_3a_provision = r40_3a_provision;
	}
	public BigDecimal getR40_3b_provision() {
		return r40_3b_provision;
	}
	public void setR40_3b_provision(BigDecimal r40_3b_provision) {
		this.r40_3b_provision = r40_3b_provision;
	}
	public BigDecimal getR40_3c_provision() {
		return r40_3c_provision;
	}
	public void setR40_3c_provision(BigDecimal r40_3c_provision) {
		this.r40_3c_provision = r40_3c_provision;
	}
	public BigDecimal getR40_current() {
		return r40_current;
	}
	public void setR40_current(BigDecimal r40_current) {
		this.r40_current = r40_current;
	}
	public BigDecimal getR40_lessthan_30() {
		return r40_lessthan_30;
	}
	public void setR40_lessthan_30(BigDecimal r40_lessthan_30) {
		this.r40_lessthan_30 = r40_lessthan_30;
	}
	public BigDecimal getR40_exclusive_90days() {
		return r40_exclusive_90days;
	}
	public void setR40_exclusive_90days(BigDecimal r40_exclusive_90days) {
		this.r40_exclusive_90days = r40_exclusive_90days;
	}
	public BigDecimal getR40_exclusive_120days() {
		return r40_exclusive_120days;
	}
	public void setR40_exclusive_120days(BigDecimal r40_exclusive_120days) {
		this.r40_exclusive_120days = r40_exclusive_120days;
	}
	public BigDecimal getR40_exclusive_180days() {
		return r40_exclusive_180days;
	}
	public void setR40_exclusive_180days(BigDecimal r40_exclusive_180days) {
		this.r40_exclusive_180days = r40_exclusive_180days;
	}
	public BigDecimal getR40_exclusive_over_180days() {
		return r40_exclusive_over_180days;
	}
	public void setR40_exclusive_over_180days(BigDecimal r40_exclusive_over_180days) {
		this.r40_exclusive_over_180days = r40_exclusive_over_180days;
	}
	public BigDecimal getR40_total_past() {
		return r40_total_past;
	}
	public void setR40_total_past(BigDecimal r40_total_past) {
		this.r40_total_past = r40_total_past;
	}
	public BigDecimal getR40_new_stage3() {
		return r40_new_stage3;
	}
	public void setR40_new_stage3(BigDecimal r40_new_stage3) {
		this.r40_new_stage3 = r40_new_stage3;
	}
	public BigDecimal getR40_new_specific() {
		return r40_new_specific;
	}
	public void setR40_new_specific(BigDecimal r40_new_specific) {
		this.r40_new_specific = r40_new_specific;
	}
	public BigDecimal getR40_new_other() {
		return r40_new_other;
	}
	public void setR40_new_other(BigDecimal r40_new_other) {
		this.r40_new_other = r40_new_other;
	}
	public BigDecimal getR40_performing_accounts() {
		return r40_performing_accounts;
	}
	public void setR40_performing_accounts(BigDecimal r40_performing_accounts) {
		this.r40_performing_accounts = r40_performing_accounts;
	}
	public BigDecimal getR40_non_performing_accounts() {
		return r40_non_performing_accounts;
	}
	public void setR40_non_performing_accounts(BigDecimal r40_non_performing_accounts) {
		this.r40_non_performing_accounts = r40_non_performing_accounts;
	}
	public String getR40_outstanding_check() {
		return r40_outstanding_check;
	}
	public void setR40_outstanding_check(String r40_outstanding_check) {
		this.r40_outstanding_check = r40_outstanding_check;
	}
	public String getR40_provision_check() {
		return r40_provision_check;
	}
	public void setR40_provision_check(String r40_provision_check) {
		this.r40_provision_check = r40_provision_check;
	}
	public String getR40_past_due_date() {
		return r40_past_due_date;
	}
	public void setR40_past_due_date(String r40_past_due_date) {
		this.r40_past_due_date = r40_past_due_date;
	}
	public Date getReport_from_date() {
		return report_from_date;
	}
	public void setReport_from_date(Date report_from_date) {
		this.report_from_date = report_from_date;
	}
	public Date getReport_to_date() {
		return report_to_date;
	}
	public void setReport_to_date(Date report_to_date) {
		this.report_to_date = report_to_date;
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
	public String getReport_code() {
		return report_code;
	}
	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}
	public Date getReport_submit_date() {
		return report_submit_date;
	}
	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getRepdesc() {
		return repdesc;
	}
	public void setRepdesc(String repdesc) {
		this.repdesc = repdesc;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public BRF40_Entity1() {
		super();
		// TODO Auto-generated constructor stub
	}
}