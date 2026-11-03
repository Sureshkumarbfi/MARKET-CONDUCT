package com.bornfire.xbrl.services;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bornfire.xbrl.entities.RT_IRS_ENTITY;
import com.bornfire.xbrl.entities.RT_IRS_REPOSITORY;
import com.bornfire.xbrl.entities.RT_IRS_SENS_ENTITIES;
import com.bornfire.xbrl.entities.RT_IRS_SENS_Repository;
import com.bornfire.xbrl.entities.RT_SLS_ENTITIES;
import com.bornfire.xbrl.entities.RT_SLS_Repository;
import com.bornfire.xbrl.entities.RT_SLS_SENS_ENTITIES;
import com.bornfire.xbrl.entities.RT_SLS_SENS_Repository;

@Service
public class RtLiquidityReportService {

	private static final SimpleDateFormat DISPLAY_DATE = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

	@Autowired
	private RT_SLS_Repository slsRepository;

	@Autowired
	private RT_IRS_REPOSITORY irsRepository;

	@Autowired
	private RT_SLS_SENS_Repository slsSensRepository;

	@Autowired
	private RT_IRS_SENS_Repository irsSensRepository;

	public Optional<RT_SLS_ENTITIES> findLatestSlsReport() {
		return slsRepository.findLatestReport();
	}

	public Optional<RT_IRS_ENTITY> findLatestIrsReport() {
		return irsRepository.findLatestReport();
	}

	public Optional<RT_SLS_SENS_ENTITIES> findLatestSlsSensReport() {
		return resolveLatestSlsSensEntryPoint();
	}

	public Optional<RT_IRS_SENS_ENTITIES> findLatestIrsSensReport() {
		return resolveLatestIrsSensEntryPoint();
	}

	public Optional<RT_SLS_SENS_ENTITIES> resolveLatestSlsSensEntryPoint() {
		List<Date> dates = slsSensRepository.findDistinctPositionDates();
		if (dates.isEmpty()) {
			return Optional.empty();
		}
		Date maxPositionDate = dates.get(0);
		List<RT_SLS_SENS_ENTITIES> currencyRows = slsSensRepository.findCurrenciesByPositionDate(maxPositionDate);
		if (currencyRows.isEmpty()) {
			return Optional.empty();
		}
		String currency = pickPreferredSensCurrency(currencyRows);
		return slsSensRepository.findByPositionDateAndDayOffsetAndCurrency(maxPositionDate, 0, currency);
	}

	public Optional<RT_IRS_SENS_ENTITIES> resolveLatestIrsSensEntryPoint() {
		List<Date> dates = irsSensRepository.findDistinctPositionDates();
		if (dates.isEmpty()) {
			return Optional.empty();
		}
		Date maxPositionDate = dates.get(0);
		List<RT_IRS_SENS_ENTITIES> currencyRows = irsSensRepository.findCurrenciesByPositionDate(maxPositionDate);
		if (currencyRows.isEmpty()) {
			return Optional.empty();
		}
		String currency = pickPreferredIrsSensCurrency(currencyRows);
		return irsSensRepository.findByPositionDateAndDayOffsetAndCurrency(maxPositionDate, 0, currency);
	}

	private static String pickPreferredSensCurrency(List<RT_SLS_SENS_ENTITIES> currencyRows) {
		for (RT_SLS_SENS_ENTITIES row : currencyRows) {
			if ("ONLY_USD_CCY_REPORT".equals(row.getREPORT_CURRENCY())) {
				return row.getREPORT_CURRENCY();
			}
		}
		return currencyRows.get(0).getREPORT_CURRENCY();
	}

	private static String pickPreferredIrsSensCurrency(List<RT_IRS_SENS_ENTITIES> currencyRows) {
		for (RT_IRS_SENS_ENTITIES row : currencyRows) {
			if ("ONLY_USD_CCY_REPORT".equals(row.getReport_currency())) {
				return row.getReport_currency();
			}
		}
		return currencyRows.get(0).getReport_currency();
	}

	public List<Date> findDistinctSlsReportDates() {
		return slsRepository.findDistinctReportDates();
	}

	public List<Date> findDistinctIrsReportDates() {
		return irsRepository.findDistinctReportDates();
	}

	public List<Date> findDistinctSlsSensPositionDates() {
		return slsSensRepository.findDistinctPositionDates();
	}

	public List<Date> findDistinctIrsSensPositionDates() {
		return irsSensRepository.findDistinctPositionDates();
	}

	public Optional<RT_SLS_ENTITIES> findSlsReportForDateAndCurrency(Date reportDate, String currency) {
		if (reportDate == null || currency == null || currency.trim().isEmpty()) {
			return Optional.empty();
		}
		return slsRepository.findLatestByDateAndCurrency(reportDate, currency);
	}

	public Optional<RT_IRS_ENTITY> findIrsReportForDateAndCurrency(Date reportDate, String currency) {
		if (reportDate == null || currency == null || currency.trim().isEmpty()) {
			return Optional.empty();
		}
		return irsRepository.findLatestByDateAndCurrency(reportDate, currency);
	}

	public List<RT_SLS_ENTITIES> resolveSlsSummaryList(Date reportDate, String currency) {
		Optional<RT_SLS_ENTITIES> latest = findSlsReportForDateAndCurrency(reportDate, currency);
		if (latest.isPresent()) {
			return Collections.singletonList(latest.get());
		}
		if (reportDate == null || currency == null || currency.trim().isEmpty()) {
			return Collections.emptyList();
		}
		return slsRepository.rtslslistbydate(reportDate, currency);
	}

	public List<RT_IRS_ENTITY> resolveIrsSummaryList(Date reportDate, String currency) {
		Optional<RT_IRS_ENTITY> latest = findIrsReportForDateAndCurrency(reportDate, currency);
		if (latest.isPresent()) {
			return Collections.singletonList(latest.get());
		}
		if (reportDate == null || currency == null || currency.trim().isEmpty()) {
			return Collections.emptyList();
		}
		return irsRepository.rtirslistbydate(reportDate, currency);
	}

	public String formatReportDate(Date date) {
		return date != null ? DISPLAY_DATE.format(date) : "";
	}

	public String buildSlsReportRedirectUrl(RT_SLS_ENTITIES row) {
		return "redirect:/SLSREPORT?formmode=summary"
				+ "&reportdate=" + encode(formatReportDate(row.getREPORT_DATE()))
				+ "&currency=" + encode(row.getREPORT_CURRENCY());
	}

	public String buildIrsReportRedirectUrl(RT_IRS_ENTITY row) {
		return "redirect:/IRSREPORT?formmode=summary"
				+ "&reportdate=" + encode(formatReportDate(row.getReport_date()))
				+ "&currency=" + encode(row.getReport_currency());
	}

	public String buildSlsSensReportRedirectUrl(RT_SLS_SENS_ENTITIES row) {
		Integer dayOffset = row.getSENS_DAY_OFFSET() != null ? row.getSENS_DAY_OFFSET() : 0;
		Date asOf = row.getAS_OF_DATE();
		if (asOf == null && row.getREPORT_DATE() != null) {
			asOf = SlsSensReportService.addCalendarDays(row.getREPORT_DATE(), dayOffset);
		}
		String url = "redirect:/SLS_SENSREPORT?formmode=summary"
				+ "&reportdate=" + encode(formatReportDate(row.getREPORT_DATE()))
				+ "&dayOffset=" + dayOffset
				+ "&currency=" + encode(row.getREPORT_CURRENCY());
		if (asOf != null) {
			url += "&asOfDate=" + encode(formatReportDate(asOf));
		}
		return url;
	}

	public String buildIrsSensReportRedirectUrl(RT_IRS_SENS_ENTITIES row) {
		Integer dayOffset = row.getSens_day_offset() != null ? row.getSens_day_offset() : 0;
		Date asOf = row.getAs_of_date();
		if (asOf == null && row.getReport_date() != null) {
			asOf = IrsSensReportService.addCalendarDays(row.getReport_date(), dayOffset);
		}
		String url = "redirect:/IRS_SENSREPORT?formmode=summary"
				+ "&reportdate=" + encode(formatReportDate(row.getReport_date()))
				+ "&dayOffset=" + dayOffset
				+ "&currency=" + encode(row.getReport_currency());
		if (asOf != null) {
			url += "&asOfDate=" + encode(formatReportDate(asOf));
		}
		return url;
	}

	private static String encode(String value) {
		try {
			return URLEncoder.encode(value != null ? value : "", StandardCharsets.UTF_8.name());
		} catch (UnsupportedEncodingException e) {
			return value != null ? value : "";
		}
	}
}
