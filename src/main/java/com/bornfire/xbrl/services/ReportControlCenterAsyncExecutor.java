package com.bornfire.xbrl.services;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Runs report-control procedures off the HTTP thread so long steps do not block the browser.
 */
@Service
public class ReportControlCenterAsyncExecutor {

	@Autowired
	@Lazy
	private ReportControlCenterStepService stepService;

	@Async
	public void executeStepAsync(BigDecimal reportId, Long stepId, Date reportDay, String execUserName) {
		stepService.finishStepExecution(reportId, stepId, reportDay, execUserName);
	}

	@Async
	public void executeAllStepsAsync(BigDecimal reportId, Date reportDay, String execUserName) {
		stepService.runAllStepsBlocking(reportId, reportDay, execUserName);
	}
}
