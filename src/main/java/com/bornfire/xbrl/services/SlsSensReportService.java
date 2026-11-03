package com.bornfire.xbrl.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bornfire.xbrl.dto.SlsSensAnalyticalSnapshotDto;
import com.bornfire.xbrl.dto.SlsSensDayVariationDto;
import com.bornfire.xbrl.dto.SlsSensPositionDateGroupDto;
import com.bornfire.xbrl.dto.SlsSensScenarioDto;
import com.bornfire.xbrl.entities.RT_SLS_SENS_ENTITIES;
import com.bornfire.xbrl.entities.RT_SLS_SENS_Repository;

@Service
public class SlsSensReportService {

	private static final SimpleDateFormat DISPLAY_DATE = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

	@Autowired
	private RT_SLS_SENS_Repository sensRepository;

	public List<SlsSensPositionDateGroupDto> buildPositionDateGroups() {
		List<RT_SLS_SENS_ENTITIES> all = sensRepository.findAllForGroupedList();
		Map<String, SlsSensPositionDateGroupDto> groups = new LinkedHashMap<>();

		for (RT_SLS_SENS_ENTITIES row : all) {
			if (row.getREPORT_DATE() == null) {
				continue;
			}
			String currency = row.getREPORT_CURRENCY() != null ? row.getREPORT_CURRENCY() : "";
			String key = row.getREPORT_DATE().getTime() + "|" + currency;
			SlsSensPositionDateGroupDto group = groups.get(key);
			if (group == null) {
				group = new SlsSensPositionDateGroupDto();
				group.setPositionDate(row.getREPORT_DATE());
				group.setPositionDateFormatted(formatDate(row.getREPORT_DATE()));
				group.setReportCurrency(currency);
				groups.put(key, group);
			}
			group.getScenarios().add(toScenarioDto(row));
		}

		List<SlsSensPositionDateGroupDto> result = new ArrayList<>(groups.values());
		for (SlsSensPositionDateGroupDto g : result) {
			g.getScenarios().sort(Comparator.comparing(s -> s.getSensDayOffset() != null ? s.getSensDayOffset() : 0));
			g.setScenarioCount(g.getScenarios().size());
		}
		result.sort((a, b) -> b.getPositionDate().compareTo(a.getPositionDate()));
		return result;
	}

	public List<SlsSensScenarioDto> findScenariosForPositionDate(Date positionDate, String currency) {
		List<RT_SLS_SENS_ENTITIES> rows = sensRepository.findScenariosByPositionDateAndCurrency(positionDate, currency);
		List<SlsSensScenarioDto> out = new ArrayList<>();
		for (RT_SLS_SENS_ENTITIES row : rows) {
			out.add(toScenarioDto(row));
		}
		out.sort(Comparator.comparing(s -> s.getSensDayOffset() != null ? s.getSensDayOffset() : 0));
		return out;
	}

	public Optional<RT_SLS_SENS_ENTITIES> findScenarioRow(Date positionDate, Integer dayOffset, String currency) {
		if (dayOffset != null) {
			return sensRepository.findByPositionDateAndDayOffsetAndCurrency(positionDate, dayOffset, currency);
		}
		return Optional.empty();
	}

	public Optional<RT_SLS_SENS_ENTITIES> findScenarioRowByAsOf(Date positionDate, Date asOfDate, String currency) {
		return sensRepository.findByPositionDateAndAsOfDateAndCurrency(positionDate, asOfDate, currency);
	}

	public SlsSensScenarioDto toScenarioDto(RT_SLS_SENS_ENTITIES row) {
		SlsSensScenarioDto dto = new SlsSensScenarioDto();
		Date position = row.getREPORT_DATE();
		Integer offset = row.getSENS_DAY_OFFSET();
		if (offset == null) {
			offset = 0;
		}
		Date asOf = row.getAS_OF_DATE();
		if (asOf == null && position != null) {
			asOf = addCalendarDays(position, offset);
		}
		dto.setPositionDate(position);
		dto.setPositionDateFormatted(formatDate(position));
		dto.setAsOfDate(asOf);
		dto.setAsOfDateFormatted(formatDate(asOf));
		dto.setSensDayOffset(offset);
		dto.setReportCurrency(row.getREPORT_CURRENCY());
		dto.setBaseScenario(offset == 0);
		dto.setScenarioLabel(scenarioLabel(offset));
		return dto;
	}

	public static String scenarioLabel(Integer offset) {
		if (offset == null || offset == 0) {
			return "Base (Day 0)";
		}
		return "Day +" + offset;
	}

	public static Date addCalendarDays(Date base, int days) {
		if (base == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(base);
		c.add(Calendar.DAY_OF_MONTH, days);
		return c.getTime();
	}

	public static String formatDate(Date d) {
		if (d == null) {
			return "";
		}
		synchronized (DISPLAY_DATE) {
			return DISPLAY_DATE.format(d);
		}
	}

	public Map<String, Object> buildSevenDayTotalsSummary(Date positionDate, String currency) {
		Map<String, Object> result = new LinkedHashMap<>();
		List<SlsSensDayVariationDto> variations = new ArrayList<>();
		SlsSensAnalyticalSnapshotDto base = null;

		for (int offset = 0; offset <= 6; offset++) {
			Optional<RT_SLS_SENS_ENTITIES> rowOpt = findScenarioRow(positionDate, offset, currency);
			if (offset == 0) {
				if (rowOpt.isPresent()) {
					base = buildAnalyticalSnapshot(rowOpt.get(), offset);
				} else {
					base = emptyAnalyticalSnapshot(offset, formatDate(positionDate));
				}
				continue;
			}

			SlsSensDayVariationDto variation = new SlsSensDayVariationDto();
			variation.setSensDayOffset(offset);
			variation.setScenarioLabel(scenarioLabel(offset));

			if (rowOpt.isPresent()) {
				RT_SLS_SENS_ENTITIES row = rowOpt.get();
				SlsSensAnalyticalSnapshotDto daySnapshot = buildAnalyticalSnapshot(row, offset);
				variation.setAsOfDateFormatted(daySnapshot.getAsOfDateFormatted());
				if (base != null) {
					variation.setDeltaOutflowMediumTerm(
							delta(daySnapshot.getOutflowMediumTerm(), base.getOutflowMediumTerm()));
					variation.setDeltaOutflowLongTerm(
							delta(daySnapshot.getOutflowLongTerm(), base.getOutflowLongTerm()));
					variation.setDeltaInflowMediumTerm(
							delta(daySnapshot.getInflowMediumTerm(), base.getInflowMediumTerm()));
					variation.setDeltaInflowLongTerm(
							delta(daySnapshot.getInflowLongTerm(), base.getInflowLongTerm()));
					variation.setLongTermRatio(daySnapshot.getLongTermRatio());
					variation.setMedLongTermRatio(daySnapshot.getMedLongTermRatio());
					variation.setDeltaLongTermRatio(
							delta(daySnapshot.getLongTermRatio(), base.getLongTermRatio()));
					variation.setDeltaMedLongTermRatio(
							delta(daySnapshot.getMedLongTermRatio(), base.getMedLongTermRatio()));
				}
			} else {
				variation.setAsOfDateFormatted(formatDate(addCalendarDays(positionDate, offset)));
			}
			variations.add(variation);
		}

		result.put("success", true);
		result.put("positionDate", formatDate(positionDate));
		result.put("currency", currency);
		result.put("base", base);
		result.put("variations", variations);
		return result;
	}

	private SlsSensAnalyticalSnapshotDto buildAnalyticalSnapshot(RT_SLS_SENS_ENTITIES row, int offset) {
		SlsSensAnalyticalSnapshotDto snapshot = new SlsSensAnalyticalSnapshotDto();
		SlsSensScenarioDto scenario = toScenarioDto(row);
		snapshot.setSensDayOffset(offset);
		snapshot.setScenarioLabel(scenarioLabel(offset));
		snapshot.setAsOfDateFormatted(scenario.getAsOfDateFormatted());

		BigDecimal outMed = sum(row.getR39_OVER6M_TO_1Y(), row.getR39_OVER1Y_TO_3Y());
		BigDecimal outLong = sum(row.getR39_OVER3Y_TO_5Y(), row.getR39_OVER5Y());
		BigDecimal inMed = sum(row.getR70_OVER6M_TO_1Y(), row.getR70_OVER1Y_TO_3Y());
		BigDecimal inLong = sum(row.getR70_OVER3Y_TO_5Y(), row.getR70_OVER5Y());

		snapshot.setOutflowMediumTerm(outMed);
		snapshot.setOutflowLongTerm(outLong);
		snapshot.setInflowMediumTerm(inMed);
		snapshot.setInflowLongTerm(inLong);
		snapshot.setLongTermRatio(ratioPercent(outLong, inLong));
		snapshot.setMedLongTermRatio(ratioPercent(sum(outMed, outLong), sum(inMed, inLong)));
		return snapshot;
	}

	private static SlsSensAnalyticalSnapshotDto emptyAnalyticalSnapshot(int offset, String asOfFormatted) {
		SlsSensAnalyticalSnapshotDto snapshot = new SlsSensAnalyticalSnapshotDto();
		snapshot.setSensDayOffset(offset);
		snapshot.setScenarioLabel(scenarioLabel(offset));
		snapshot.setAsOfDateFormatted(asOfFormatted);
		return snapshot;
	}

	private static BigDecimal sum(BigDecimal a, BigDecimal b) {
		return nz(a).add(nz(b));
	}

	private static BigDecimal nz(BigDecimal value) {
		return value != null ? value : BigDecimal.ZERO;
	}

	private static BigDecimal delta(BigDecimal current, BigDecimal base) {
		return nz(current).subtract(nz(base));
	}

	private static BigDecimal ratioPercent(BigDecimal numerator, BigDecimal denominator) {
		if (denominator == null || denominator.compareTo(BigDecimal.ZERO) == 0) {
			return null;
		}
		return nz(numerator).multiply(new BigDecimal("100"))
				.divide(denominator, 4, RoundingMode.HALF_UP);
	}
}
