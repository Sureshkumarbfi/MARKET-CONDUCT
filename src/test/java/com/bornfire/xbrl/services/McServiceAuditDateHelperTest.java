package com.bornfire.xbrl.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.bornfire.xbrl.services.McServiceAuditDateHelper.ResolvedDates;

public class McServiceAuditDateHelperTest {

	@Test
	public void rangeIncludesFromAndToDatesWithExclusiveNextDayBound() {
		ResolvedDates result = McServiceAuditDateHelper.resolveRange("01-09-2026", "05-09-2026");
		assertFalse(result.hasError());
		assertTrue(result.isExclusiveEnd());
		assertEquals(startOfDay("01-09-2026"), result.getStartInclusive());
		assertEquals(startOfDay("06-09-2026"), result.getEndBound());
	}

	@Test
	public void sameFromAndToDateIsValidSingleDayRange() {
		ResolvedDates result = McServiceAuditDateHelper.resolveRange("05-09-2026", "05-09-2026");
		assertFalse(result.hasError());
		assertEquals(startOfDay("05-09-2026"), result.getStartInclusive());
		assertEquals(startOfDay("06-09-2026"), result.getEndBound());
	}

	@Test
	public void fromDateGreaterThanToDateIsRejected() {
		ResolvedDates result = McServiceAuditDateHelper.resolveRange("05-09-2026", "01-09-2026");
		assertTrue(result.hasError());
		assertEquals("From Date cannot be greater than To Date.", result.getErrorMessage());
		assertFalse(result.hasBounds());
	}

	@Test
	public void missingFromDateIsRejected() {
		ResolvedDates result = McServiceAuditDateHelper.resolveRange("", "05-09-2026");
		assertTrue(result.hasError());
		assertEquals("Please select From Date.", result.getErrorMessage());
	}

	@Test
	public void missingToDateIsRejected() {
		ResolvedDates result = McServiceAuditDateHelper.resolveRange("01-09-2026", " ");
		assertTrue(result.hasError());
		assertEquals("Please select To Date.", result.getErrorMessage());
	}

	@Test
	public void bothDatesMissingAreRejected() {
		ResolvedDates result = McServiceAuditDateHelper.resolveRange(null, null);
		assertTrue(result.hasError());
		assertEquals("Please select From Date and To Date.", result.getErrorMessage());
	}

	@Test
	public void invalidCalendarDateIsRejected() {
		ResolvedDates result = McServiceAuditDateHelper.resolveRange("31-02-2026", "05-09-2026");
		assertTrue(result.hasError());
		assertTrue(result.getErrorMessage().contains("Invalid From Date"));
	}

	@Test
	public void invalidFormatIsRejected() {
		ResolvedDates result = McServiceAuditDateHelper.resolveRange("2026-09-01", "05-09-2026");
		assertTrue(result.hasError());
		assertTrue(result.getErrorMessage().contains("Invalid From Date"));
	}

	@Test
	public void singleDateKeepsExistingEndOfDayBound() {
		ResolvedDates result = McServiceAuditDateHelper.resolveSingle("05-09-2026");
		assertFalse(result.hasError());
		assertFalse(result.isExclusiveEnd());
		assertEquals(existingStartOfDay("05-09-2026"), result.getStartInclusive());
		assertEquals(existingEndOfDay("05-09-2026"), result.getEndBound());
	}

	@Test
	public void viewWithoutDateDoesNotApplyFilter() {
		ResolvedDates result = McServiceAuditDateHelper.resolveForView("SINGLE", null, "01-09-2026", "05-09-2026");
		assertFalse(result.hasError());
		assertFalse(result.hasBounds());
	}

	@Test
	public void viewRangeIgnoresStaleParticularDate() {
		ResolvedDates result = McServiceAuditDateHelper.resolveForView("RANGE", "21-09-2026", "01-09-2026",
				"05-09-2026");
		assertFalse(result.hasError());
		assertTrue(result.isExclusiveEnd());
		assertEquals(startOfDay("01-09-2026"), result.getStartInclusive());
		assertEquals(startOfDay("06-09-2026"), result.getEndBound());
	}

	@Test
	public void downloadSingleUsesExistingBetweenWindow() {
		ResolvedDates result = McServiceAuditDateHelper.resolveForDownload("SINGLE", "05-09-2026", null, null);
		assertFalse(result.hasError());
		assertFalse(result.isExclusiveEnd());
		assertEquals(existingEndOfDay("05-09-2026"), result.getEndBound());
	}

	@Test
	public void downloadRangeUsesExclusiveUpperBound() {
		ResolvedDates result = McServiceAuditDateHelper.resolveForDownload("RANGE", "21-09-2026", "01-09-2026",
				"05-09-2026");
		assertTrue(result.isExclusiveEnd());
		assertEquals(startOfDay("06-09-2026"), result.getEndBound());
	}

	@Test
	public void legacyDownloadWithoutSearchTypeKeepsExistingInclusiveEndOfDay() {
		ResolvedDates result = McServiceAuditDateHelper.resolveForDownload(null, null, "01-09-2026", "05-09-2026");
		assertFalse(result.hasError());
		assertFalse(result.isExclusiveEnd());
		assertEquals(existingStartOfDay("01-09-2026"), result.getStartInclusive());
		assertEquals(existingEndOfDay("05-09-2026"), result.getEndBound());
	}

	@Test
	public void downloadSingleRequiresDate() {
		ResolvedDates result = McServiceAuditDateHelper.resolveForDownload("SINGLE", " ", "", null);
		assertTrue(result.hasError());
		assertEquals("Please select a date.", result.getErrorMessage());
	}

	@Test
	public void strictParserRejectsInvalidDay() {
		try {
			McServiceAuditDateHelper.parseStrictDdMmYyyy("31-02-2026");
			fail("Expected ParseException");
		} catch (ParseException expected) {
			assertNotNull(expected.getMessage());
		}
	}

	@Test
	public void timeOnToDateIsCoveredByExclusiveBound() throws Exception {
		ResolvedDates result = McServiceAuditDateHelper.resolveRange("05-09-2026", "05-09-2026");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date lateOnToDate = sdf.parse("05-09-2026 23:59:59");
		Date nextMorning = sdf.parse("06-09-2026 00:00:00");
		assertFalse(lateOnToDate.before(result.getStartInclusive()));
		assertTrue(lateOnToDate.before(result.getEndBound()));
		assertFalse(nextMorning.before(result.getEndBound()));
		assertFalse(nextMorning.equals(result.getStartInclusive()));
	}

	private Date startOfDay(String ddMMyyyy) {
		try {
			return McServiceAuditDateHelper.startOfDay(McServiceAuditDateHelper.parseStrictDdMmYyyy(ddMMyyyy), true);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	private Date existingStartOfDay(String ddMMyyyy) {
		try {
			Date parsed = new SimpleDateFormat("dd-MM-yyyy").parse(ddMMyyyy);
			Calendar cal = Calendar.getInstance();
			cal.setTime(parsed);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			return cal.getTime();
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	private Date existingEndOfDay(String ddMMyyyy) {
		try {
			Date parsed = new SimpleDateFormat("dd-MM-yyyy").parse(ddMMyyyy);
			Calendar cal = Calendar.getInstance();
			cal.setTime(parsed);
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			return cal.getTime();
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
