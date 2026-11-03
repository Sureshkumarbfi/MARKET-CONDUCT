package com.bornfire.xbrl.services;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Shared date parsing and bound calculation for Market Conduct Service Audit
 * View and Download. SINGLE mode preserves the existing start-of-day through
 * 23:59:59 BETWEEN window. RANGE mode uses an inclusive From Date and an
 * exclusive next-day upper bound so the full To Date is included even when
 * the column stores a time component.
 */
public final class McServiceAuditDateHelper {

	public static final String MODE_SINGLE = "SINGLE";
	public static final String MODE_RANGE = "RANGE";
	public static final String DATE_PATTERN = "dd-MM-yyyy";

	private McServiceAuditDateHelper() {
	}

	public static boolean isRangeMode(String searchType) {
		return MODE_RANGE.equalsIgnoreCase(trimToEmpty(searchType));
	}

	public static boolean isSingleMode(String searchType) {
		return MODE_SINGLE.equalsIgnoreCase(trimToEmpty(searchType));
	}

	public static ResolvedDates resolveForView(String searchType, String entryDate, String fromDate, String toDate) {
		if (isRangeMode(searchType)) {
			return resolveRange(fromDate, toDate);
		}
		if (isBlank(entryDate)) {
			return ResolvedDates.none(MODE_SINGLE);
		}
		return resolveSingle(entryDate);
	}

	public static ResolvedDates resolveForDownload(String searchType, String entryDate, String fromDate, String toDate) {
		if (isRangeMode(searchType)) {
			return resolveRange(fromDate, toDate);
		}
		if (isSingleMode(searchType)) {
			String dateValue = firstNonBlank(entryDate, fromDate, toDate);
			if (isBlank(dateValue)) {
				return ResolvedDates.error(MODE_SINGLE, "Please select a date.");
			}
			return resolveSingle(dateValue);
		}
		return resolveLegacyDownload(fromDate, toDate);
	}

	public static ResolvedDates resolveRange(String fromDateStr, String toDateStr) {
		boolean fromBlank = isBlank(fromDateStr);
		boolean toBlank = isBlank(toDateStr);
		if (fromBlank && toBlank) {
			return ResolvedDates.error(MODE_RANGE, "Please select From Date and To Date.");
		}
		if (fromBlank) {
			return ResolvedDates.error(MODE_RANGE, "Please select From Date.");
		}
		if (toBlank) {
			return ResolvedDates.error(MODE_RANGE, "Please select To Date.");
		}

		Date fromDate;
		Date toDate;
		try {
			fromDate = parseStrictDdMmYyyy(fromDateStr);
		} catch (ParseException e) {
			return ResolvedDates.error(MODE_RANGE, invalidDateMessage("From Date"));
		}
		try {
			toDate = parseStrictDdMmYyyy(toDateStr);
		} catch (ParseException e) {
			return ResolvedDates.error(MODE_RANGE, invalidDateMessage("To Date"));
		}

		Date startInclusive = startOfDay(fromDate, true);
		Date toDayStart = startOfDay(toDate, true);
		if (startInclusive.after(toDayStart)) {
			return ResolvedDates.error(MODE_RANGE, "From Date cannot be greater than To Date.");
		}
		return ResolvedDates.range(startInclusive, startOfNextDay(toDate));
	}

	public static ResolvedDates resolveSingle(String dateStr) {
		if (isBlank(dateStr)) {
			return ResolvedDates.error(MODE_SINGLE, "Please select a date.");
		}
		try {
			Date parsed = parseStrictDdMmYyyy(dateStr);
			return ResolvedDates.single(startOfDay(parsed, false), endOfDayExisting(parsed));
		} catch (ParseException e) {
			return ResolvedDates.error(MODE_SINGLE, invalidDateMessage("Date"));
		}
	}

	private static ResolvedDates resolveLegacyDownload(String fromDateStr, String toDateStr) {
		boolean fromBlank = isBlank(fromDateStr);
		boolean toBlank = isBlank(toDateStr);
		if (fromBlank && toBlank) {
			return ResolvedDates.error(MODE_RANGE, "Please select From Date and To Date.");
		}
		if (fromBlank) {
			return ResolvedDates.error(MODE_RANGE, "Please select From Date.");
		}
		if (toBlank) {
			return ResolvedDates.error(MODE_RANGE, "Please select To Date.");
		}

		Date fromDate;
		Date toDate;
		try {
			fromDate = parseStrictDdMmYyyy(fromDateStr);
		} catch (ParseException e) {
			return ResolvedDates.error(MODE_RANGE, invalidDateMessage("From Date"));
		}
		try {
			toDate = parseStrictDdMmYyyy(toDateStr);
		} catch (ParseException e) {
			return ResolvedDates.error(MODE_RANGE, invalidDateMessage("To Date"));
		}

		Date startInclusive = startOfDay(fromDate, false);
		Date toDayStart = startOfDay(toDate, false);
		if (startInclusive.after(toDayStart)) {
			return ResolvedDates.error(MODE_RANGE, "From Date cannot be greater than To Date.");
		}
		return ResolvedDates.single(startInclusive, endOfDayExisting(toDate));
	}

	public static Date parseStrictDdMmYyyy(String value) throws ParseException {
		String trimmed = value.trim();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		sdf.setLenient(false);
		ParsePosition pos = new ParsePosition(0);
		Date parsed = sdf.parse(trimmed, pos);
		if (parsed == null || pos.getIndex() != trimmed.length()) {
			throw new ParseException("Invalid date: " + trimmed, pos.getErrorIndex());
		}
		return parsed;
	}

	public static Date startOfDay(Date date, boolean resetMillis) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		if (resetMillis) {
			cal.set(Calendar.MILLISECOND, 0);
		}
		return cal.getTime();
	}

	public static Date endOfDayExisting(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	public static Date startOfNextDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startOfDay(date, true));
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}

	private static String invalidDateMessage(String fieldLabel) {
		return "Invalid " + fieldLabel + ". Please enter a valid date in DD-MM-YYYY format.";
	}

	private static String firstNonBlank(String... values) {
		if (values == null) {
			return null;
		}
		for (String value : values) {
			if (!isBlank(value)) {
				return value.trim();
			}
		}
		return null;
	}

	public static boolean isBlank(String value) {
		return value == null || value.trim().isEmpty();
	}

	private static String trimToEmpty(String value) {
		return value == null ? "" : value.trim();
	}

	public static final class ResolvedDates {
		private final String mode;
		private final String errorMessage;
		private final Date startInclusive;
		private final Date endBound;
		private final boolean exclusiveEnd;

		private ResolvedDates(String mode, String errorMessage, Date startInclusive, Date endBound,
				boolean exclusiveEnd) {
			this.mode = mode;
			this.errorMessage = errorMessage;
			this.startInclusive = startInclusive;
			this.endBound = endBound;
			this.exclusiveEnd = exclusiveEnd;
		}

		public static ResolvedDates error(String mode, String message) {
			return new ResolvedDates(mode, message, null, null, false);
		}

		public static ResolvedDates none(String mode) {
			return new ResolvedDates(mode, null, null, null, false);
		}

		public static ResolvedDates single(Date startInclusive, Date endInclusive) {
			return new ResolvedDates(MODE_SINGLE, null, startInclusive, endInclusive, false);
		}

		public static ResolvedDates range(Date startInclusive, Date exclusiveEnd) {
			return new ResolvedDates(MODE_RANGE, null, startInclusive, exclusiveEnd, true);
		}

		public boolean hasError() {
			return errorMessage != null;
		}

		public boolean hasBounds() {
			return startInclusive != null && endBound != null;
		}

		public String getMode() {
			return mode;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public Date getStartInclusive() {
			return startInclusive;
		}

		public Date getEndBound() {
			return endBound;
		}

		public boolean isExclusiveEnd() {
			return exclusiveEnd;
		}
	}
}
