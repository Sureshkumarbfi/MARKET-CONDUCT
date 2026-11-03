package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.ss.usermodel.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.bornfire.xbrl.entities.RT_Fxriskdata;
import com.bornfire.xbrl.entities.RT_Investment_Risk_Data_Dashboard_Template;
import com.bornfire.xbrl.entities.RT_MmData;
import com.bornfire.xbrl.entities.RT_MmDataRepository;
import com.bornfire.xbrl.entities.RT_TradeLevelDataDerivatives;
import com.bornfire.xbrl.entities.RT_TradeLevelDataDerivativesRepository;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.io.FileNotFoundException;

@Service
public class RT_TradeLevelDerivativesService {
    private static final Logger logger = LoggerFactory.getLogger(RT_TradeLevelDerivativesService.class);


    @Autowired
    private Environment env;

    @Autowired
    private RT_TradeLevelDataDerivativesRepository tradeleveldataderivaticeRepo;

    @Autowired
    private SessionFactory sessionFactory;

	@Autowired
	AuditService auditservice;    
	
    public boolean updatetradeleveldataderivative(RT_TradeLevelDataDerivatives updatedData) {
	    System.out.println("Looking for record with SI_NO: " + updatedData.getSI_NO());

	    RT_TradeLevelDataDerivatives existing = tradeleveldataderivaticeRepo.getParticularDataBySI_NO(updatedData.getSI_NO());

	    RT_TradeLevelDataDerivatives dbUser = new RT_TradeLevelDataDerivatives();
		org.springframework.beans.BeanUtils.copyProperties(existing, dbUser);
	    
	    if (existing != null) {
	        // Update fields
	       
	    	existing.setBank_name(updatedData.getBank_name());
	    	existing.setHead_office_subsidiary(updatedData.getHead_office_subsidiary());
	    	existing.setSubsidiary(updatedData.getSubsidiary());
	    	existing.setBank_symbol(updatedData.getBank_symbol());
	    	existing.setConventional_islamic(updatedData.getConventional_islamic());
	    	existing.setCbuae_tiering1(updatedData.getCbuae_tiering1());
	    	existing.setCbuae_tiering2(updatedData.getCbuae_tiering2());
	    	existing.setCpty_name(updatedData.getCpty_name());
	    	existing.setInternal_counterparty_ref(updatedData.getInternal_counterparty_ref());
	    	existing.setInternal_transaction_ref(updatedData.getInternal_transaction_ref());
	    	existing.setUnderlying_asset_class(updatedData.getUnderlying_asset_class());
	    	existing.setDerivatives_type(updatedData.getDerivatives_type());
	    	existing.setTransaction_rationale(updatedData.getTransaction_rationale());
	    	existing.setBundle_transaction(updatedData.getBundle_transaction());
	    	existing.setBack_to_back_transaction(updatedData.getBack_to_back_transaction());
	    	existing.setInstruments_characteristics(updatedData.getInstruments_characteristics());
	    	existing.setCurrency_valuation(updatedData.getCurrency_valuation());
	    	existing.setAed_fx_spot_rate_conversion(updatedData.getAed_fx_spot_rate_conversion());
	    	existing.setStart_date(updatedData.getStart_date());
	    	existing.setEffective_delivery_date(updatedData.getEffective_delivery_date());
	    	existing.setFinal_maturity_date(updatedData.getFinal_maturity_date());
	    	existing.setResidual_maturity(updatedData.getResidual_maturity());
	    	existing.setResidual_maturity_rounded(updatedData.getResidual_maturity_rounded());
	    	existing.setMaturity_period(updatedData.getMaturity_period());
	    	existing.setPosition(updatedData.getPosition());
	    	existing.setNotional_type(updatedData.getNotional_type());
	    	existing.setCancellable(updatedData.getCancellable());
	    	existing.setCancellable_date(updatedData.getCancellable_date());
	    	existing.setCancellable_option_type(updatedData.getCancellable_option_type());
	    	existing.setNotional1_assets(updatedData.getNotional1_assets());
	    	existing.setNotional1_currency(updatedData.getNotional1_currency());
	    	existing.setPay_receive1(updatedData.getPay_receive1());
	    	existing.setCoupon_fixed_rate1(updatedData.getCoupon_fixed_rate1());
	    	existing.setMargin1(updatedData.getMargin1());
	    	existing.setBenchmark_floating_rate1(updatedData.getBenchmark_floating_rate1());
	    	existing.setBenchmark_rate_tenor1(updatedData.getBenchmark_rate_tenor1());
	    	existing.setNotional2_liabilities(updatedData.getNotional2_liabilities());
	    	existing.setNotional2_currency(updatedData.getNotional2_currency());
	    	existing.setPay_receive2(updatedData.getPay_receive2());
	    	existing.setCoupon_fixed_rate2(updatedData.getCoupon_fixed_rate2());
	    	existing.setMargin2(updatedData.getMargin2());
	    	existing.setBenchmark_floating_rate2(updatedData.getBenchmark_floating_rate2());
	    	existing.setBenchmark_rate_tenor2(updatedData.getBenchmark_rate_tenor2());
	    	existing.setClean_value_aed(updatedData.getClean_value_aed());
	    	existing.setAccrued_interest_aed(updatedData.getAccrued_interest_aed());
	    	existing.setDv01_aed(updatedData.getDv01_aed());
	    	existing.setBr01_aed(updatedData.getBr01_aed());
	    	existing.setDollar_delta_aed(updatedData.getDollar_delta_aed());
	    	existing.setDollar_vega_aed(updatedData.getDollar_vega_aed());
	    	existing.setDollar_gamma_aed(updatedData.getDollar_gamma_aed());
	    	existing.setDollar_theta_aed(updatedData.getDollar_theta_aed());
	    	existing.setUleg1_notional(updatedData.getUleg1_notional());
	    	existing.setUleg1_currency(updatedData.getUleg1_currency());
	    	existing.setUleg1_pay_receive(updatedData.getUleg1_pay_receive());
	    	existing.setUleg1_coupon(updatedData.getUleg1_coupon());
	    	existing.setUleg1_margin(updatedData.getUleg1_margin());
	    	existing.setUleg1_benchmark(updatedData.getUleg1_benchmark());
	    	existing.setUleg1_tenor(updatedData.getUleg1_tenor());
	    	existing.setUnderlying_leg1(updatedData.getUnderlying_leg1());
	    	existing.setUleg1_details(updatedData.getUleg1_details());
	    	existing.setUleg2_notional(updatedData.getUleg2_notional());
	    	existing.setUleg2_currency(updatedData.getUleg2_currency());
	    	existing.setUleg2_pay_receive(updatedData.getUleg2_pay_receive());
	    	existing.setUleg2_coupon(updatedData.getUleg2_coupon());
	    	existing.setUleg2_margin(updatedData.getUleg2_margin());
	    	existing.setUleg2_benchmark(updatedData.getUleg2_benchmark());
	    	existing.setUleg2_tenor(updatedData.getUleg2_tenor());
	    	existing.setUnderlying_leg2(updatedData.getUnderlying_leg2());
	    	existing.setUleg2_details(updatedData.getUleg2_details());
	    	existing.setUleg2_clean_value_aed(updatedData.getUleg2_clean_value_aed());
	    	existing.setUleg2_accrued_interest_aed(updatedData.getUleg2_accrued_interest_aed());
	    	existing.setUleg2_dv01_aed(updatedData.getUleg2_dv01_aed());
	    	existing.setCds_type(updatedData.getCds_type());
	    	existing.setCds_underlyings(updatedData.getCds_underlyings());
	    	existing.setQuanto(updatedData.getQuanto());
	    	existing.setNominal(updatedData.getNominal());
	    	existing.setCleanvalue_aed(updatedData.getCleanvalue_aed());
	    	existing.setIr_dv01_aed(updatedData.getIr_dv01_aed());
	    	existing.setCs01_aed(updatedData.getCs01_aed());
	    	existing.setFuture_type(updatedData.getFuture_type());
	    	existing.setFuture_underlying_contract(updatedData.getFuture_underlying_contract());
	    	existing.setFuture_qty(updatedData.getFuture_qty());
	    	existing.setFuture_contract_size(updatedData.getFuture_contract_size());
	    	existing.setFuture_contract_rate(updatedData.getFuture_contract_rate());
	    	existing.setFuture_market_rate(updatedData.getFuture_market_rate());
	    	existing.setFuture_contract_valuation(updatedData.getFuture_contract_valuation());
	    	existing.setFuture_sensitivity_aed(updatedData.getFuture_sensitivity_aed());
	    	existing.setOptions_list(updatedData.getOptions_list());
	    	existing.setOption_type(updatedData.getOption_type());
	    	existing.setOption_underlying_type(updatedData.getOption_underlying_type());
	    	existing.setOption_underlying_details(updatedData.getOption_underlying_details());
	    	existing.setStrike(updatedData.getStrike());
	    	existing.setOption_market_rate(updatedData.getOption_market_rate());
	    	existing.setBarrier_type(updatedData.getBarrier_type());
	    	existing.setBarrier_upper_range(updatedData.getBarrier_upper_range());
	    	existing.setBarrier_lower_range(updatedData.getBarrier_lower_range());
	    	existing.setOption_fair_value_aed(updatedData.getOption_fair_value_aed());
	    	existing.setOption_dollar_delta(updatedData.getOption_dollar_delta());
	    	existing.setOption_dollar_vega(updatedData.getOption_dollar_vega());
	    	existing.setOption_dollar_gamma(updatedData.getOption_dollar_gamma());
	    	existing.setOption_dollar_rho(updatedData.getOption_dollar_rho());
	    	existing.setOption_dollar_theta(updatedData.getOption_dollar_theta());
	    	existing.setOverall_mtm_aed(updatedData.getOverall_mtm_aed());
	    	existing.setIrs_positive_mtm(updatedData.getIrs_positive_mtm());
	    	existing.setAsset_swap_positive_mtm(updatedData.getAsset_swap_positive_mtm());
	    	existing.setCds_positive_mtm(updatedData.getCds_positive_mtm());
	    	existing.setFuture_contract_positive_mtm(updatedData.getFuture_contract_positive_mtm());
	    	existing.setOption_positive_mtm(updatedData.getOption_positive_mtm());
	    	existing.setOverall_positive_mtm(updatedData.getOverall_positive_mtm());
	    	existing.setIndividual_positive_contribution(updatedData.getIndividual_positive_contribution());
	    	existing.setIrs_negative_mtm(updatedData.getIrs_negative_mtm());
	    	existing.setAsset_swap_negative_mtm(updatedData.getAsset_swap_negative_mtm());
	    	existing.setCds_negative_mtm(updatedData.getCds_negative_mtm());
	    	existing.setFuture_contract_negative_mtm(updatedData.getFuture_contract_negative_mtm());
	    	existing.setOption_negative_mtm(updatedData.getOption_negative_mtm());
	    	existing.setOverall_negative_mtm(updatedData.getOverall_negative_mtm());
	    	existing.setIndividual_negative_contribution(updatedData.getIndividual_negative_contribution());



			List<String> ignoreFields = Arrays.asList("createUser", "modifyUser", "delFlg");

			Map<String, String> changes = new LinkedHashMap<>();

			for (Field field : RT_TradeLevelDataDerivatives.class.getDeclaredFields()) {
				field.setAccessible(true);
				try {
					Object oldValue = field.get(dbUser);
					Object newValue = field.get(existing);
					if ((oldValue == null || oldValue.toString().trim().isEmpty())
							&& (newValue == null || newValue.toString().trim().isEmpty())) {
						continue;
					}

					if (ignoreFields.contains(field.getName()) && newValue == null) {
						continue;
					}

					if (oldValue instanceof Date || newValue instanceof Date) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String oldDateStr = (oldValue != null) ? sdf.format(oldValue) : null;
						String newDateStr = (newValue != null) ? sdf.format(newValue) : null;

						if (Objects.equals(oldDateStr, newDateStr)) {
							continue;
						}
					} else {
						if (Objects.equals(oldValue, newValue)) {
							continue;
						}
					}

					if (newValue == null) {
						changes.put(field.getName(), "OldValue: " + oldValue + ", NewValue: null");
					} else {
						changes.put(field.getName(), "OldValue: " + oldValue + ", NewValue: " + newValue);
					}

					if (newValue != null) {
						field.set(dbUser, newValue);
					}

				} catch (IllegalAccessException e) {
					System.err.println("Access error for field: " + field.getName() + " - " + e.getMessage());
				}
			}
			


	    	tradeleveldataderivaticeRepo.save(existing);
	    	

	        System.out.println("changes : "+changes);

	        // Audit only if any field was changed
	        if (!changes.isEmpty()) {
	            auditservice.createBusinessAudit(
	            		String.valueOf(updatedData.getSI_NO()),           // Unique ID
	                "MODIFY",                             // Action
	                "TRADE_LEVEL_DATA_DERIVATIVE_EDIT_SCREEN",                  // Screen name
	                changes,                              // Changed fields map
	                "BCBUAE_TRADE_LEVEL_DERIVATIVES"              // Table name
	            );
	        }
	        
	        
	        return true;
	    } else {
	        System.out.println("No record found for SI_NO: " + updatedData.getSI_NO());
	        return false;
	    }
	}
    
    
    public byte[] generateTradeleveldataderivativeExcel(Date Report_date) throws Exception {
        logger.info("Service: Starting Trade level Data Derivative Excel generation process in memory.");

        List<Object[]> tradeleveldataDerivative = tradeleveldataderivaticeRepo.gettradeleveldataderivative1(Report_date);

        if (tradeleveldataDerivative.isEmpty()) {
            logger.warn("Service: No data found for Trade level data derivative report. Returning empty result.");
            return new byte[0];
        }

        String templateDir = env.getProperty("output.exportpathtemp"); // Config property key
       // String templateFileName = "CBUAE_Trade_Level_Data_Derivative_Template.xls";
        String templateFileName = "CBUAE_Trade_Level_Data_Derivatives_Template.xlsx";
        Path templatePath = Paths.get(templateDir, templateFileName);
        System.out.println("Template Dir = [" + templateDir + "]");
        logger.info("Service: Attempting to load template from path: {}", templatePath.toAbsolutePath());

        if (!Files.exists(templatePath)) {
            throw new FileNotFoundException("Template file not found at: " + templatePath.toAbsolutePath());
        }

        if (!Files.isReadable(templatePath)) {
            throw new SecurityException("Template file exists but is not readable: " + templatePath.toAbsolutePath());
        }

        try (InputStream templateInputStream = Files.newInputStream(templatePath);
             Workbook workbook = WorkbookFactory.create(templateInputStream);
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            Sheet sheet = workbook.getSheetAt(2);
            CreationHelper createHelper = workbook.getCreationHelper();

            // Define cell styles
            CellStyle dateStyle = workbook.createCellStyle();
            dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
            dateStyle.setBorderBottom(BorderStyle.THIN);
            dateStyle.setBorderTop(BorderStyle.THIN);
            dateStyle.setBorderLeft(BorderStyle.THIN);
            dateStyle.setBorderRight(BorderStyle.THIN);

            CellStyle textStyle = workbook.createCellStyle();
            textStyle.setBorderBottom(BorderStyle.THIN);
            textStyle.setBorderTop(BorderStyle.THIN);
            textStyle.setBorderLeft(BorderStyle.THIN);
            textStyle.setBorderRight(BorderStyle.THIN);

            CellStyle numberStyle = workbook.createCellStyle();
            numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("#,##0.00"));
            numberStyle.setBorderBottom(BorderStyle.THIN);
            numberStyle.setBorderTop(BorderStyle.THIN);
            numberStyle.setBorderLeft(BorderStyle.THIN);
            numberStyle.setBorderRight(BorderStyle.THIN);

            int startRow = 4; // Assuming data starts from row index 3 (4rd row)

            if (!tradeleveldataDerivative.isEmpty()) {
                for (int i = 0; i < tradeleveldataDerivative.size(); i++) {
                    Object[] mm = tradeleveldataDerivative.get(i);
                    Row row = sheet.getRow(startRow + i);
                    if (row == null) row = sheet.createRow(startRow + i);
                    
                 // 0 - bank_date (DATE)
                    Cell cell0 = row.getCell(0); if (cell0 == null) cell0 = row.createCell(0);
                    if (mm[0] instanceof Date) {
                        cell0.setCellValue((Date) mm[0]);
                        cell0.setCellStyle(dateStyle);
                    } else {
                        cell0.setCellValue("");
                    }

                    // 1 - bank_name
                    Cell cell1 = row.getCell(1); if (cell1 == null) cell1 = row.createCell(1);
                    cell1.setCellValue(mm[1] == null ? "" : mm[1].toString());

                    // 2 - head_office_subsidiary
                    Cell cell2 = row.getCell(2); if (cell2 == null) cell2 = row.createCell(2);
                    cell2.setCellValue(mm[2] == null ? "" : mm[2].toString());

                    // 3 - subsidiary
                    Cell cell3 = row.getCell(3); if (cell3 == null) cell3 = row.createCell(3);
                    cell3.setCellValue(mm[3] == null ? "" : mm[3].toString());

                    // 4 - bank_symbol
                    Cell cell4 = row.getCell(4); if (cell4 == null) cell4 = row.createCell(4);
                    cell4.setCellValue(mm[4] == null ? "" : mm[4].toString());

                    // 5 - conventional_islamic
                    Cell cell5 = row.getCell(5); if (cell5 == null) cell5 = row.createCell(5);
                    cell5.setCellValue(mm[5] == null ? "" : mm[5].toString());

                    // 6 - cbuae_tiering1
                    Cell cell6 = row.getCell(6); if (cell6 == null) cell6 = row.createCell(6);
                    cell6.setCellValue(mm[6] == null ? "" : mm[6].toString());

                    // 7 - cbuae_tiering2
                    Cell cell7 = row.getCell(7); if (cell7 == null) cell7 = row.createCell(7);
                    cell7.setCellValue(mm[7] == null ? "" : mm[7].toString());

                    // 8 - cpty_name
                    Cell cell8 = row.getCell(8); if (cell8 == null) cell8 = row.createCell(8);
                    cell8.setCellValue(mm[8] == null ? "" : mm[8].toString());

                    // 9 - internal_counterparty_ref
                    Cell cell9 = row.getCell(9); if (cell9 == null) cell9 = row.createCell(9);
                    cell9.setCellValue(mm[9] == null ? "" : mm[9].toString());

                    // 10 - internal_transaction_ref
                    Cell cell10 = row.getCell(10); if (cell10 == null) cell10 = row.createCell(10);
                    cell10.setCellValue(mm[10] == null ? "" : mm[10].toString());

                    // 11 - underlying_asset_class
                    Cell cell11 = row.getCell(11); if (cell11 == null) cell11 = row.createCell(11);
                    cell11.setCellValue(mm[11] == null ? "" : mm[11].toString());

                    // 12 - derivatives_type
                    Cell cell12 = row.getCell(12); if (cell12 == null) cell12 = row.createCell(12);
                    cell12.setCellValue(mm[12] == null ? "" : mm[12].toString());

                    // 13 - transaction_rationale
                    Cell cell13 = row.getCell(13); if (cell13 == null) cell13 = row.createCell(13);
                    cell13.setCellValue(mm[13] == null ? "" : mm[13].toString());

                    // 14 - bundle_transaction
                    Cell cell14 = row.getCell(14); if (cell14 == null) cell14 = row.createCell(14);
                    cell14.setCellValue(mm[14] == null ? "" : mm[14].toString());

                    // 15 - back_to_back_transaction
                    Cell cell15 = row.getCell(15); if (cell15 == null) cell15 = row.createCell(15);
                    cell15.setCellValue(mm[15] == null ? "" : mm[15].toString());

                    // 16 - instruments_characteristics
                    Cell cell16 = row.getCell(16); if (cell16 == null) cell16 = row.createCell(16);
                    cell16.setCellValue(mm[16] == null ? "" : mm[16].toString());

                    // 17 - currency_valuation
                    Cell cell17 = row.getCell(17); if (cell17 == null) cell17 = row.createCell(17);
                    cell17.setCellValue(mm[17] == null ? "" : mm[17].toString());

                    // 18 - aed_fx_spot_rate_conversion
                    Cell cell18 = row.getCell(18); if (cell18 == null) cell18 = row.createCell(18);
                    cell18.setCellValue(mm[18] == null ? "" : mm[18].toString());

                    // 19 - start_date (DATE)
                    Cell cell19 = row.getCell(19); if (cell19 == null) cell19 = row.createCell(19);
                    if (mm[19] instanceof Date) {
                        cell19.setCellValue((Date) mm[19]);
                        cell19.setCellStyle(dateStyle);
                    } else {
                        cell19.setCellValue("");
                    }

                    // 20 - effective_delivery_date (DATE)
                    Cell cell20 = row.getCell(20); if (cell20 == null) cell20 = row.createCell(20);
                    if (mm[20] instanceof Date) {
                        cell20.setCellValue((Date) mm[20]);
                        cell20.setCellStyle(dateStyle);
                    } else {
                        cell20.setCellValue("");
                    }

                    // 21 - final_maturity_date (DATE)
                    Cell cell21 = row.getCell(21); if (cell21 == null) cell21 = row.createCell(21);
                    if (mm[21] instanceof Date) {
                        cell21.setCellValue((Date) mm[21]);
                        cell21.setCellStyle(dateStyle);
                    } else {
                        cell21.setCellValue("");
                    }

                    // 22 - residual_maturity
                    Cell cell22 = row.getCell(22); if (cell22 == null) cell22 = row.createCell(22);
                    cell22.setCellValue(mm[22] == null ? "" : mm[22].toString());

                    // 23 - residual_maturity_rounded
                    Cell cell23 = row.getCell(23); if (cell23 == null) cell23 = row.createCell(23);
                    cell23.setCellValue(mm[23] == null ? "" : mm[23].toString());

                    // 24 - maturity_period
                    Cell cell24 = row.getCell(24); if (cell24 == null) cell24 = row.createCell(24);
                    cell24.setCellValue(mm[24] == null ? "" : mm[24].toString());

                    // 25 - position
                    Cell cell25 = row.getCell(25); if (cell25 == null) cell25 = row.createCell(25);
                    cell25.setCellValue(mm[25] == null ? "" : mm[25].toString());

                    // 26 - notional_type
                    Cell cell26 = row.getCell(26); if (cell26 == null) cell26 = row.createCell(26);
                    cell26.setCellValue(mm[26] == null ? "" : mm[26].toString());

                    // 27 - cancellable
                    Cell cell27 = row.getCell(27); if (cell27 == null) cell27 = row.createCell(27);
                    cell27.setCellValue(mm[27] == null ? "" : mm[27].toString());
                    
                 // 28 - cancellable_date
                    Cell cell28 = row.getCell(28); if (cell28 == null) cell28 = row.createCell(28);
                    if (mm[28] instanceof Date) {
                        cell28.setCellValue((Date) mm[28]);
                        cell28.setCellStyle(dateStyle);
                    } else {
                        cell28.setCellValue("");
                    }

                    // 29 - cancellable_option_type
                    Cell cell29 = row.getCell(29); if (cell29 == null) cell29 = row.createCell(29);
                    cell29.setCellValue(mm[29] == null ? "" : mm[29].toString());

                    // 30 - notional1_assets
                    Cell cell30 = row.getCell(30); if (cell30 == null) cell30 = row.createCell(30);
                    cell30.setCellValue(mm[30] == null ? "" : mm[30].toString());

                    // 31 - notional1_currency
                    Cell cell31 = row.getCell(31); if (cell31 == null) cell31 = row.createCell(31);
                    cell31.setCellValue(mm[31] == null ? "" : mm[31].toString());

                    // 32 - pay_receive1
                    Cell cell32 = row.getCell(32); if (cell32 == null) cell32 = row.createCell(32);
                    cell32.setCellValue(mm[32] == null ? "" : mm[32].toString());
                    
                 // 33 - coupon_fixed_rate1
                    Cell cell33 = row.getCell(33); if (cell33 == null) cell33 = row.createCell(33);
                    cell33.setCellValue(mm[33] == null ? "" : mm[33].toString());

                    // 34 - margin1
                    Cell cell34 = row.getCell(34); if (cell34 == null) cell34 = row.createCell(34);
                    cell34.setCellValue(mm[34] == null ? "" : mm[34].toString());

                    // 35 - benchmark_floating_rate1
                    Cell cell35 = row.getCell(35); if (cell35 == null) cell35 = row.createCell(35);
                    cell35.setCellValue(mm[35] == null ? "" : mm[35].toString());

                    // 36 - benchmark_rate_tenor1
                    Cell cell36 = row.getCell(36); if (cell36 == null) cell36 = row.createCell(36);
                    cell36.setCellValue(mm[36] == null ? "" : mm[36].toString());

                    // 37 - notional2_liabilities
                    Cell cell37 = row.getCell(37); if (cell37 == null) cell37 = row.createCell(37);
                    cell37.setCellValue(mm[37] == null ? "" : mm[37].toString());

                    // 38 - notional2_currency
                    Cell cell38 = row.getCell(38); if (cell38 == null) cell38 = row.createCell(38);
                    cell38.setCellValue(mm[38] == null ? "" : mm[38].toString());

                    // 39 - pay_receive2
                    Cell cell39 = row.getCell(39); if (cell39 == null) cell39 = row.createCell(39);
                    cell39.setCellValue(mm[39] == null ? "" : mm[39].toString());

                    // 40 - coupon_fixed_rate2
                    Cell cell40 = row.getCell(40); if (cell40 == null) cell40 = row.createCell(40);
                    cell40.setCellValue(mm[40] == null ? "" : mm[40].toString());

                    // 41 - margin2
                    Cell cell41 = row.getCell(41); if (cell41 == null) cell41 = row.createCell(41);
                    cell41.setCellValue(mm[41] == null ? "" : mm[41].toString());

                    // 42 - benchmark_floating_rate2
                    Cell cell42 = row.getCell(42); if (cell42 == null) cell42 = row.createCell(42);
                    cell42.setCellValue(mm[42] == null ? "" : mm[42].toString());

                    // 43 - benchmark_rate_tenor2
                    Cell cell43 = row.getCell(43); if (cell43 == null) cell43 = row.createCell(43);
                    cell43.setCellValue(mm[43] == null ? "" : mm[43].toString());

                    // 44 - clean_value_aed
                    Cell cell44 = row.getCell(44); if (cell44 == null) cell44 = row.createCell(44);
                    cell44.setCellValue(mm[44] == null ? "" : mm[44].toString());

                    // 45 - accrued_interest_aed
                    Cell cell45 = row.getCell(45); if (cell45 == null) cell45 = row.createCell(45);
                    cell45.setCellValue(mm[45] == null ? "" : mm[45].toString());

                    // 46 - dv01_aed
                    Cell cell46 = row.getCell(46); if (cell46 == null) cell46 = row.createCell(46);
                    cell46.setCellValue(mm[46] == null ? "" : mm[46].toString());

                    // 47 - br01_aed
                    Cell cell47 = row.getCell(47); if (cell47 == null) cell47 = row.createCell(47);
                    cell47.setCellValue(mm[47] == null ? "" : mm[47].toString());

                    // 48 - dollar_delta_aed
                    Cell cell48 = row.getCell(48); if (cell48 == null) cell48 = row.createCell(48);
                    cell48.setCellValue(mm[48] == null ? "" : mm[48].toString());

                    // 49 - dollar_vega_aed
                    Cell cell49 = row.getCell(49); if (cell49 == null) cell49 = row.createCell(49);
                    cell49.setCellValue(mm[49] == null ? "" : mm[49].toString());

                    // 50 - dollar_gamma_aed
                    Cell cell50 = row.getCell(50); if (cell50 == null) cell50 = row.createCell(50);
                    cell50.setCellValue(mm[50] == null ? "" : mm[50].toString());

                    // 51 - dollar_theta_aed
                    Cell cell51 = row.getCell(51); if (cell51 == null) cell51 = row.createCell(51);
                    cell51.setCellValue(mm[51] == null ? "" : mm[51].toString());

                    // 52 - uleg1_notional
                    Cell cell52 = row.getCell(52); if (cell52 == null) cell52 = row.createCell(52);
                    cell52.setCellValue(mm[52] == null ? "" : mm[52].toString());

                    // 53 - uleg1_currency
                    Cell cell53 = row.getCell(53); if (cell53 == null) cell53 = row.createCell(53);
                    cell53.setCellValue(mm[53] == null ? "" : mm[53].toString());

                    // 54 - uleg1_pay_receive
                    Cell cell54 = row.getCell(54); if (cell54 == null) cell54 = row.createCell(54);
                    cell54.setCellValue(mm[54] == null ? "" : mm[54].toString());

                    // 55 - uleg1_coupon
                    Cell cell55 = row.getCell(55); if (cell55 == null) cell55 = row.createCell(55);
                    cell55.setCellValue(mm[55] == null ? "" : mm[55].toString());

                    // 56 - uleg1_margin
                    Cell cell56 = row.getCell(56); if (cell56 == null) cell56 = row.createCell(56);
                    cell56.setCellValue(mm[56] == null ? "" : mm[56].toString());

                    // 57 - uleg1_benchmark
                    Cell cell57 = row.getCell(57); if (cell57 == null) cell57 = row.createCell(57);
                    cell57.setCellValue(mm[57] == null ? "" : mm[57].toString());

                    // 58 - uleg1_tenor
                    Cell cell58 = row.getCell(58); if (cell58 == null) cell58 = row.createCell(58);
                    cell58.setCellValue(mm[58] == null ? "" : mm[58].toString());
                    
                 // 59 - underlying_leg1
                    Cell cell59 = row.getCell(59); if (cell59 == null) cell59 = row.createCell(59);
                    cell59.setCellValue(mm[59] == null ? "" : mm[59].toString());
                    
                 // 60 - uleg1_details
                    Cell cell60 = row.getCell(60); if (cell60 == null) cell60 = row.createCell(60);
                    cell60.setCellValue(mm[60] == null ? "" : mm[60].toString());

                    // 61 - uleg2_notional
                    Cell cell61 = row.getCell(61); if (cell61 == null) cell61 = row.createCell(61);
                    cell61.setCellValue(mm[61] == null ? "" : mm[61].toString());

                    // 62 - uleg2_currency
                    Cell cell62 = row.getCell(62); if (cell62 == null) cell62 = row.createCell(62);
                    cell62.setCellValue(mm[62] == null ? "" : mm[62].toString());

                    // 63 - uleg2_pay_receive
                    Cell cell63 = row.getCell(63); if (cell63 == null) cell63 = row.createCell(63);
                    cell63.setCellValue(mm[63] == null ? "" : mm[63].toString());

                    // 64 - uleg2_coupon
                    Cell cell64 = row.getCell(64); if (cell64 == null) cell64 = row.createCell(64);
                    cell64.setCellValue(mm[64] == null ? "" : mm[64].toString());

                    // 65 - uleg2_margin
                    Cell cell65 = row.getCell(65); if (cell65 == null) cell65 = row.createCell(65);
                    cell65.setCellValue(mm[65] == null ? "" : mm[65].toString());

                    // 66 - uleg2_benchmark
                    Cell cell66 = row.getCell(66); if (cell66 == null) cell66 = row.createCell(66);
                    cell66.setCellValue(mm[66] == null ? "" : mm[66].toString());

                    // 67 - uleg2_tenor
                    Cell cell67 = row.getCell(67); if (cell67 == null) cell67 = row.createCell(67);
                    cell67.setCellValue(mm[67] == null ? "" : mm[67].toString());

                    // 68 - underlying_leg2
                    Cell cell68 = row.getCell(68); if (cell68 == null) cell68 = row.createCell(68);
                    cell68.setCellValue(mm[68] == null ? "" : mm[68].toString());

                    // 69 - uleg2_details
                    Cell cell69 = row.getCell(69); if (cell69 == null) cell69 = row.createCell(69);
                    cell69.setCellValue(mm[69] == null ? "" : mm[69].toString());

                    // 70 - uleg2_clean_value_aed
                    Cell cell70 = row.getCell(70); if (cell70 == null) cell70 = row.createCell(70);
                    cell70.setCellValue(mm[70] == null ? "" : mm[70].toString());

                    // 71 - uleg2_accrued_interest_aed
                    Cell cell71 = row.getCell(71); if (cell71 == null) cell71 = row.createCell(71);
                    cell71.setCellValue(mm[71] == null ? "" : mm[71].toString());

                    // 72 - uleg2_dv01_aed
                    Cell cell72 = row.getCell(72); if (cell72 == null) cell72 = row.createCell(72);
                    cell72.setCellValue(mm[72] == null ? "" : mm[72].toString());

                    // 73 - cds_type
                    Cell cell73 = row.getCell(73); if (cell73 == null) cell73 = row.createCell(73);
                    cell73.setCellValue(mm[73] == null ? "" : mm[73].toString());

                    // 74 - cds_underlyings
                    Cell cell74 = row.getCell(74); if (cell74 == null) cell74 = row.createCell(74);
                    cell74.setCellValue(mm[74] == null ? "" : mm[74].toString());

                    // 75 - quanto
                    Cell cell75 = row.getCell(75); if (cell75 == null) cell75 = row.createCell(75);
                    cell75.setCellValue(mm[75] == null ? "" : mm[75].toString());

                    // 76 - nominal
                    Cell cell76 = row.getCell(76); if (cell76 == null) cell76 = row.createCell(76);
                    cell76.setCellValue(mm[76] == null ? "" : mm[76].toString());
                    
                 // 77 - cleanvalue_aed
                    Cell cell77 = row.getCell(77); if (cell77 == null) cell77 = row.createCell(77);
                    cell77.setCellValue(mm[77] == null ? "" : mm[77].toString());

                    // 78 - ir_dv01_aed
                    Cell cell78 = row.getCell(78); if (cell78 == null) cell78 = row.createCell(78);
                    cell78.setCellValue(mm[78] == null ? "" : mm[78].toString());

                    // 79 - cs01_aed
                    Cell cell79 = row.getCell(79); if (cell79 == null) cell79 = row.createCell(79);
                    cell79.setCellValue(mm[79] == null ? "" : mm[79].toString());

                    // 80 - future_type
                    Cell cell80 = row.getCell(80); if (cell80 == null) cell80 = row.createCell(80);
                    cell80.setCellValue(mm[80] == null ? "" : mm[80].toString());

                    // 81 - future_underlying_contract
                    Cell cell81 = row.getCell(81); if (cell81 == null) cell81 = row.createCell(81);
                    cell81.setCellValue(mm[81] == null ? "" : mm[81].toString());

                    // 82 - future_qty
                    Cell cell82 = row.getCell(82); if (cell82 == null) cell82 = row.createCell(82);
                    cell82.setCellValue(mm[82] == null ? "" : mm[82].toString());

                    // 83 - future_contract_size
                    Cell cell83 = row.getCell(83); if (cell83 == null) cell83 = row.createCell(83);
                    cell83.setCellValue(mm[83] == null ? "" : mm[83].toString());

                    // 84 - future_contract_rate
                    Cell cell84 = row.getCell(84); if (cell84 == null) cell84 = row.createCell(84);
                    cell84.setCellValue(mm[84] == null ? "" : mm[84].toString());

                    // 85 - future_market_rate
                    Cell cell85 = row.getCell(85); if (cell85 == null) cell85 = row.createCell(85);
                    cell85.setCellValue(mm[85] == null ? "" : mm[85].toString());

                    // 86 - future_contract_valuation
                    Cell cell86 = row.getCell(86); if (cell86 == null) cell86 = row.createCell(86);
                    cell86.setCellValue(mm[86] == null ? "" : mm[86].toString());

                    // 87 - future_sensitivity_aed
                    Cell cell87 = row.getCell(87); if (cell87 == null) cell87 = row.createCell(87);
                    cell87.setCellValue(mm[87] == null ? "" : mm[87].toString());

                    // 88 - options_list
                    Cell cell88 = row.getCell(88); if (cell88 == null) cell88 = row.createCell(88);
                    cell88.setCellValue(mm[88] == null ? "" : mm[88].toString());

                    // 89 - option_type
                    Cell cell89 = row.getCell(89); if (cell89 == null) cell89 = row.createCell(89);
                    cell89.setCellValue(mm[89] == null ? "" : mm[89].toString());

                    // 90 - option_underlying_type
                    Cell cell90 = row.getCell(90); if (cell90 == null) cell90 = row.createCell(90);
                    cell90.setCellValue(mm[90] == null ? "" : mm[90].toString());

                    // 91 - option_underlying_details
                    Cell cell91 = row.getCell(91); if (cell91 == null) cell91 = row.createCell(91);
                    cell91.setCellValue(mm[91] == null ? "" : mm[91].toString());

                    // 92 - strike
                    Cell cell92 = row.getCell(92); if (cell92 == null) cell92 = row.createCell(92);
                    cell92.setCellValue(mm[92] == null ? "" : mm[92].toString());

                    // 93 - option_market_rate
                    Cell cell93 = row.getCell(93); if (cell93 == null) cell93 = row.createCell(93);
                    cell93.setCellValue(mm[93] == null ? "" : mm[93].toString());

                    // 94 - barrier_type
                    Cell cell94 = row.getCell(94); if (cell94 == null) cell94 = row.createCell(94);
                    cell94.setCellValue(mm[94] == null ? "" : mm[94].toString());

                    // 95 - barrier_upper_range
                    Cell cell95 = row.getCell(95); if (cell95 == null) cell95 = row.createCell(95);
                    cell95.setCellValue(mm[95] == null ? "" : mm[95].toString());

                    // 96 - barrier_lower_range
                    Cell cell96 = row.getCell(96); if (cell96 == null) cell96 = row.createCell(96);
                    cell96.setCellValue(mm[96] == null ? "" : mm[96].toString());

                    // 97 - option_fair_value_aed
                    Cell cell97 = row.getCell(97); if (cell97 == null) cell97 = row.createCell(97);
                    cell97.setCellValue(mm[97] == null ? "" : mm[97].toString());

                    // 98 - option_dollar_delta
                    Cell cell98 = row.getCell(98); if (cell98 == null) cell98 = row.createCell(98);
                    cell98.setCellValue(mm[98] == null ? "" : mm[98].toString());

                    // 99 - option_dollar_vega
                    Cell cell99 = row.getCell(99); if (cell99 == null) cell99 = row.createCell(99);
                    cell99.setCellValue(mm[99] == null ? "" : mm[99].toString());

                    // 100 - option_dollar_gamma
                    Cell cell100 = row.getCell(100); if (cell100 == null) cell100 = row.createCell(100);
                    cell100.setCellValue(mm[100] == null ? "" : mm[100].toString());

                    // 101 - option_dollar_rho
                    Cell cell101 = row.getCell(101); if (cell101 == null) cell101 = row.createCell(101);
                    cell101.setCellValue(mm[101] == null ? "" : mm[101].toString());

                    // 102 - option_dollar_theta
                    Cell cell102 = row.getCell(102); if (cell102 == null) cell102 = row.createCell(102);
                    cell102.setCellValue(mm[102] == null ? "" : mm[102].toString());

                    // 103 - overall_mtm_aed
                    Cell cell103 = row.getCell(103); if (cell103 == null) cell103 = row.createCell(103);
                    cell103.setCellValue(mm[103] == null ? "" : mm[103].toString());

                    // 104 - irs_positive_mtm
                    Cell cell104 = row.getCell(104); if (cell104 == null) cell104 = row.createCell(104);
                    cell104.setCellValue(mm[104] == null ? "" : mm[104].toString());

                    // 105 - asset_swap_positive_mtm
                    Cell cell105 = row.getCell(105); if (cell105 == null) cell105 = row.createCell(105);
                    cell105.setCellValue(mm[105] == null ? "" : mm[105].toString());

                    // 106 - cds_positive_mtm
                    Cell cell106 = row.getCell(106); if (cell106 == null) cell106 = row.createCell(106);
                    cell106.setCellValue(mm[106] == null ? "" : mm[106].toString());

                    // 107 - future_contract_positive_mtm
                    Cell cell107 = row.getCell(107); if (cell107 == null) cell107 = row.createCell(107);
                    cell107.setCellValue(mm[107] == null ? "" : mm[107].toString());

                    // 108 - option_positive_mtm
                    Cell cell108 = row.getCell(108); if (cell108 == null) cell108 = row.createCell(108);
                    cell108.setCellValue(mm[108] == null ? "" : mm[108].toString());

                    // 109 - overall_positive_mtm
                    Cell cell109 = row.getCell(109); if (cell109 == null) cell109 = row.createCell(109);
                    cell109.setCellValue(mm[109] == null ? "" : mm[109].toString());

                    // 110 - individual_positive_contribution
                    Cell cell110 = row.getCell(110); if (cell110 == null) cell110 = row.createCell(110);
                    cell110.setCellValue(mm[110] == null ? "" : mm[110].toString());

                    // 111 - irs_negative_mtm
                    Cell cell111 = row.getCell(111); if (cell111 == null) cell111 = row.createCell(111);
                    cell111.setCellValue(mm[111] == null ? "" : mm[111].toString());

                    // 112 - asset_swap_negative_mtm
                    Cell cell112 = row.getCell(112); if (cell112 == null) cell112 = row.createCell(112);
                    cell112.setCellValue(mm[112] == null ? "" : mm[112].toString());

                    // 113 - cds_negative_mtm
                    Cell cell113 = row.getCell(113); if (cell113 == null) cell113 = row.createCell(113);
                    cell113.setCellValue(mm[113] == null ? "" : mm[113].toString());

                    // 114 - future_contract_negative_mtm
                    Cell cell114 = row.getCell(114); if (cell114 == null) cell114 = row.createCell(114);
                    cell114.setCellValue(mm[114] == null ? "" : mm[114].toString());

                    // 115 - option_negative_mtm
                    Cell cell115 = row.getCell(115); if (cell115 == null) cell115 = row.createCell(115);
                    cell115.setCellValue(mm[115] == null ? "" : mm[115].toString());

                    // 116 - overall_negative_mtm
                    Cell cell116 = row.getCell(116); if (cell116 == null) cell116 = row.createCell(116);
                    cell116.setCellValue(mm[116] == null ? "" : mm[116].toString());

                    // 117 - individual_negative_contribution
                    Cell cell117 = row.getCell(117); if (cell117 == null) cell117 = row.createCell(117);
                    cell117.setCellValue(mm[117] == null ? "" : mm[117].toString());

   
                }

                workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
			} else {
				System.out.println("No Trade level data derivatives found to generate the Excel file.");
			}

			// Write the final workbook content to the in-memory stream.
			workbook.write(out);

			logger.info("Service: Excel data successfully written to memory buffer ({} bytes).", out.size());

			return out.toByteArray();
		}
	}
}
