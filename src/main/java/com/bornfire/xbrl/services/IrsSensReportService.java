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

import com.bornfire.xbrl.dto.IrsSensBucketRowDto;
import com.bornfire.xbrl.dto.SlsSensAnalyticalSnapshotDto;
import com.bornfire.xbrl.dto.SlsSensDayVariationDto;
import com.bornfire.xbrl.dto.SlsSensPositionDateGroupDto;
import com.bornfire.xbrl.dto.SlsSensScenarioDto;
import com.bornfire.xbrl.entities.RT_IRS_SENS_ENTITIES;
import com.bornfire.xbrl.entities.RT_IRS_SENS_ENTITIES2;
import com.bornfire.xbrl.entities.RT_IRS_SENS2_REPOSITORY;
import com.bornfire.xbrl.entities.RT_IRS_SENS_Repository;

@Service
public class IrsSensReportService {

	private static final SimpleDateFormat DISPLAY_DATE = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

	private static final String[][] IRS_BUCKET_META = {
			{ "1 – 28 days", "20 % of total assets" },
			{ "29 days and upto 3 months", "40 % of total assets" },
			{ "Over 3 months and upto 6 months", "40 % of total assets" },
			{ "Over 6 months and upto 1 year", "40 % of total assets" },
			{ "Over 1 year and upto 3 years", "30 % of total assets" },
			{ "Over 3 years and upto 5 years", "30 % of total assets" },
			{ "Over 5 years and upto 7 years", "30 % of total assets" },
			{ "Over 7 years and upto 10 years", "30 % of total assets" },
			{ "Over 10 years and upto 15 years", "30 % of total assets" },
			{ "Over 15 years", "30 % of total assets" },
			{ "Non Rate Sensitive", "" }
	};

	@Autowired
	private RT_IRS_SENS_Repository sensRepository;

	@Autowired
	private RT_IRS_SENS2_REPOSITORY sens2Repository;

	public List<SlsSensPositionDateGroupDto> buildPositionDateGroups() {
		List<RT_IRS_SENS_ENTITIES> all = sensRepository.findAllForGroupedList();
		Map<String, SlsSensPositionDateGroupDto> groups = new LinkedHashMap<>();

		for (RT_IRS_SENS_ENTITIES row : all) {
			if (row.getReport_date() == null) {
				continue;
			}
			String currency = row.getReport_currency() != null ? row.getReport_currency() : "";
			String key = row.getReport_date().getTime() + "|" + currency;
			SlsSensPositionDateGroupDto group = groups.get(key);
			if (group == null) {
				group = new SlsSensPositionDateGroupDto();
				group.setPositionDate(row.getReport_date());
				group.setPositionDateFormatted(formatDate(row.getReport_date()));
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
		List<RT_IRS_SENS_ENTITIES> rows = sensRepository.findScenariosByPositionDateAndCurrency(positionDate, currency);
		List<SlsSensScenarioDto> out = new ArrayList<>();
		for (RT_IRS_SENS_ENTITIES row : rows) {
			out.add(toScenarioDto(row));
		}
		out.sort(Comparator.comparing(s -> s.getSensDayOffset() != null ? s.getSensDayOffset() : 0));
		return out;
	}

	public Optional<RT_IRS_SENS_ENTITIES> findScenarioRow(Date positionDate, Integer dayOffset, String currency) {
		if (dayOffset != null) {
			return sensRepository.findByPositionDateAndDayOffsetAndCurrency(positionDate, dayOffset, currency);
		}
		return Optional.empty();
	}

	public Optional<RT_IRS_SENS_ENTITIES> findScenarioRowByAsOf(Date positionDate, Date asOfDate, String currency) {
		return sensRepository.findByPositionDateAndAsOfDateAndCurrency(positionDate, asOfDate, currency);
	}

	public SlsSensScenarioDto toScenarioDto(RT_IRS_SENS_ENTITIES row) {
		SlsSensScenarioDto dto = new SlsSensScenarioDto();
		Date position = row.getReport_date();
		Integer offset = row.getSens_day_offset();
		if (offset == null) {
			offset = 0;
		}
		Date asOf = row.getAs_of_date();
		if (asOf == null && position != null) {
			asOf = addCalendarDays(position, offset);
		}
		dto.setPositionDate(position);
		dto.setPositionDateFormatted(formatDate(position));
		dto.setAsOfDate(asOf);
		dto.setAsOfDateFormatted(formatDate(asOf));
		dto.setSensDayOffset(offset);
		dto.setReportCurrency(row.getReport_currency());
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
			Optional<RT_IRS_SENS_ENTITIES> rowOpt = findScenarioRow(positionDate, offset, currency);
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
				RT_IRS_SENS_ENTITIES row = rowOpt.get();
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
					variation.setBuckets(buildBucketDeltas(daySnapshot.getBuckets(), base.getBuckets()));
					variation.setDeltaTotalRsl(delta(daySnapshot.getTotalRsl(), base.getTotalRsl()));
					variation.setDeltaTotalRsa(delta(daySnapshot.getTotalRsa(), base.getTotalRsa()));
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

	private SlsSensAnalyticalSnapshotDto buildAnalyticalSnapshot(RT_IRS_SENS_ENTITIES liabilitiesRow, int offset) {
		SlsSensAnalyticalSnapshotDto snapshot = new SlsSensAnalyticalSnapshotDto();
		SlsSensScenarioDto scenario = toScenarioDto(liabilitiesRow);
		snapshot.setSensDayOffset(offset);
		snapshot.setScenarioLabel(scenarioLabel(offset));
		snapshot.setAsOfDateFormatted(scenario.getAsOfDateFormatted());

		Integer dayOffset = liabilitiesRow.getSens_day_offset() != null ? liabilitiesRow.getSens_day_offset() : offset;

		BigDecimal outMed = sum(liabilitiesRow.getR39_over6m_to_1y(), liabilitiesRow.getR39_over1y_to_3y());
		BigDecimal outLong = sum(liabilitiesRow.getR39_over3y_to_5y(), liabilitiesRow.getR39_over5y_to_7y(),
				liabilitiesRow.getR39_over7y_to_10y(), liabilitiesRow.getR39_over10y_to_15y(),
				liabilitiesRow.getR39_over15y());

		BigDecimal inMed = BigDecimal.ZERO;
		BigDecimal inLong = BigDecimal.ZERO;
		Optional<RT_IRS_SENS_ENTITIES2> assetsRowOpt = findAssetsRow(liabilitiesRow.getReport_date(),
				liabilitiesRow.getReport_currency(), dayOffset);
		if (assetsRowOpt.isPresent()) {
			RT_IRS_SENS_ENTITIES2 assetsRow = assetsRowOpt.get();
			inMed = sum(assetsRow.getR70_over6m_to_1y(), assetsRow.getR70_over1y_to_3y());
			inLong = sum(assetsRow.getR70_over3y_to_5y(), assetsRow.getR70_over5y_to_7y(),
					assetsRow.getR70_over7y_to_10y(), assetsRow.getR70_over10y_to_15y(), assetsRow.getR70_over15y());
		}

		snapshot.setOutflowMediumTerm(outMed);
		snapshot.setOutflowLongTerm(outLong);
		snapshot.setInflowMediumTerm(inMed);
		snapshot.setInflowLongTerm(inLong);
		snapshot.setLongTermRatio(ratioPercent(outLong, inLong));
		snapshot.setMedLongTermRatio(ratioPercent(sum(outMed, outLong), sum(inMed, inLong)));

		RT_IRS_SENS_ENTITIES2 assetsRow = assetsRowOpt.orElse(null);
		populateBucketSnapshot(snapshot, liabilitiesRow, assetsRow);
		return snapshot;
	}

	private void populateBucketSnapshot(SlsSensAnalyticalSnapshotDto snapshot, RT_IRS_SENS_ENTITIES liabilitiesRow,
			RT_IRS_SENS_ENTITIES2 assetsRow) {
		BigDecimal[] rslValues = extractRslBuckets(liabilitiesRow);
		BigDecimal[] rsaValues = extractRsaBuckets(assetsRow);
		List<IrsSensBucketRowDto> rows = new ArrayList<>();
		BigDecimal totalRsl = BigDecimal.ZERO;
		BigDecimal totalRsa = BigDecimal.ZERO;

		for (int i = 0; i < IRS_BUCKET_META.length; i++) {
			IrsSensBucketRowDto row = new IrsSensBucketRowDto();
			row.setBucket(IRS_BUCKET_META[i][0]);
			row.setLimitPct(IRS_BUCKET_META[i][1]);
			row.setRsl(rslValues[i]);
			row.setRsa(rsaValues[i]);
			rows.add(row);
			totalRsl = totalRsl.add(nz(rslValues[i]));
			totalRsa = totalRsa.add(nz(rsaValues[i]));
		}

		snapshot.setBuckets(rows);
		snapshot.setTotalRsl(totalRsl);
		snapshot.setTotalRsa(totalRsa);
	}

	private static BigDecimal[] extractRslBuckets(RT_IRS_SENS_ENTITIES row) {
		if (row == null) {
			return emptyBucketArray();
		}
		return new BigDecimal[] {
				row.getR45_day1_28(),
				row.getR45_day29_3m(),
				row.getR45_over3m_to_6m(),
				row.getR45_over6m_to_1y(),
				row.getR45_over1y_to_3y(),
				row.getR45_over3y_to_5y(),
				row.getR45_over5y_to_7y(),
				row.getR45_over7y_to_10y(),
				row.getR45_over10y_to_15y(),
				row.getR45_over15y(),
				row.getR45_non_sensitive()
		};
	}

	private static BigDecimal[] extractRsaBuckets(RT_IRS_SENS_ENTITIES2 row) {
		if (row == null) {
			return emptyBucketArray();
		}
		return new BigDecimal[] {
				row.getR84_day1_28(),
				row.getR84_day29_3m(),
				row.getR84_over3m_to_6m(),
				row.getR84_over6m_to_1y(),
				row.getR84_over1y_to_3y(),
				row.getR84_over3y_to_5y(),
				row.getR84_over5y_to_7y(),
				row.getR84_over7y_to_10y(),
				row.getR84_over10y_to_15y(),
				row.getR84_over15y(),
				row.getR84_non_sensitive()
		};
	}

	private static BigDecimal[] emptyBucketArray() {
		BigDecimal[] values = new BigDecimal[IRS_BUCKET_META.length];
		for (int i = 0; i < values.length; i++) {
			values[i] = BigDecimal.ZERO;
		}
		return values;
	}

	private static List<IrsSensBucketRowDto> buildBucketDeltas(List<IrsSensBucketRowDto> current,
			List<IrsSensBucketRowDto> baseRows) {
		List<IrsSensBucketRowDto> deltas = new ArrayList<>();
		int size = Math.min(current != null ? current.size() : 0, baseRows != null ? baseRows.size() : 0);
		for (int i = 0; i < size; i++) {
			IrsSensBucketRowDto cur = current.get(i);
			IrsSensBucketRowDto base = baseRows.get(i);
			IrsSensBucketRowDto deltaRow = new IrsSensBucketRowDto();
			deltaRow.setBucket(cur.getBucket());
			deltaRow.setLimitPct(cur.getLimitPct());
			deltaRow.setRsl(delta(cur.getRsl(), base.getRsl()));
			deltaRow.setRsa(delta(cur.getRsa(), base.getRsa()));
			deltas.add(deltaRow);
		}
		return deltas;
	}

	private Optional<RT_IRS_SENS_ENTITIES2> findAssetsRow(Date positionDate, String currency, Integer dayOffset) {
		if (positionDate == null || currency == null) {
			return Optional.empty();
		}
		List<RT_IRS_SENS_ENTITIES2> rows = sens2Repository.findByPositionDateAndCurrencyAndDayOffset(positionDate,
				currency, dayOffset != null ? dayOffset : 0);
		return rows.isEmpty() ? Optional.empty() : Optional.of(rows.get(0));
	}

	private static SlsSensAnalyticalSnapshotDto emptyAnalyticalSnapshot(int offset, String asOfFormatted) {
		SlsSensAnalyticalSnapshotDto snapshot = new SlsSensAnalyticalSnapshotDto();
		snapshot.setSensDayOffset(offset);
		snapshot.setScenarioLabel(scenarioLabel(offset));
		snapshot.setAsOfDateFormatted(asOfFormatted);
		return snapshot;
	}

	private static BigDecimal sum(BigDecimal... values) {
		BigDecimal total = BigDecimal.ZERO;
		if (values != null) {
			for (BigDecimal value : values) {
				total = total.add(nz(value));
			}
		}
		return total;
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
