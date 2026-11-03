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
