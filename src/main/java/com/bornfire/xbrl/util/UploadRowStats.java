package com.bornfire.xbrl.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Tracks row-level upload outcomes for monitor metrics and user messages.
 */
public final class UploadRowStats {

	private static final int MAX_SAMPLE_ERRORS = 5;

	private int inserted;
	private int failed;
	private int total;
	private final List<String> sampleErrors = new ArrayList<String>();

	public void recordSuccess() {
		inserted++;
		total++;
	}

	public void recordFailure(int excelRowNum, Exception error) {
		failed++;
		total++;
		if (sampleErrors.size() < MAX_SAMPLE_ERRORS) {
			sampleErrors.add(UploadMessageHelper.rowError(excelRowNum, error));
		}
	}

	public int getInserted() {
		return inserted;
	}

	public int getFailed() {
		return failed;
	}

	public int getTotal() {
		return total;
	}

	public List<String> getSampleErrors() {
		return Collections.unmodifiableList(sampleErrors);
	}
}
