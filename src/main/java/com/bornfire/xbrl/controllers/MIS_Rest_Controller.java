package com.bornfire.xbrl.controllers;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bornfire.xbrl.dto.AnalyticalPivotColumnDto;
import com.bornfire.xbrl.dto.AnalyticalPivotLayoutDto;
import com.bornfire.xbrl.dto.AnalyticalPivotRequestDto;
import com.bornfire.xbrl.dto.AnalyticalPivotRunResponseDto;
import com.bornfire.xbrl.dto.AnalyticalPivotTableDto;
import com.bornfire.xbrl.dto.DataInventoryExportResultDto;
import com.bornfire.xbrl.dto.DataInventoryItemDto;
import com.bornfire.xbrl.dto.ReportControlMasterRowDto;
import com.bornfire.xbrl.dto.ReportControlRunAllResponseDto;
import com.bornfire.xbrl.dto.ReportControlRunStepResponseDto;
import com.bornfire.xbrl.dto.ReportControlStepsResponseDto;
import com.bornfire.xbrl.entities.Capitaladequacyratio_rep;
import com.bornfire.xbrl.entities.Elar_summary_report_entity;
import com.bornfire.xbrl.entities.Elar_summary_report_rep;
import com.bornfire.xbrl.entities.Groupexp_cust_maintain_entity;
import com.bornfire.xbrl.entities.Groupexp_cust_maintain_rep;
import com.bornfire.xbrl.entities.Leverage_ratio_rep;
import com.bornfire.xbrl.entities.MatrixRunJobEntity;
import com.bornfire.xbrl.entities.Mis_exposure_bill_detail_entity;
import com.bornfire.xbrl.entities.RT_Chart_pojo;
import com.bornfire.xbrl.entities.RT_Data_Inventory_Entity;
import com.bornfire.xbrl.entities.RT_Data_Inventory_Repo;
import com.bornfire.xbrl.entities.RT_IRS2_REPOSITORY;
import com.bornfire.xbrl.entities.RT_IRS_ENTITY;
import com.bornfire.xbrl.entities.RT_IRS_ENTITY2;
import com.bornfire.xbrl.entities.RT_IRS_REPOSITORY;
import com.bornfire.xbrl.entities.RT_MID_FX_DEAL_REPO;
import com.bornfire.xbrl.entities.RT_Matrix_monitoring_entity;
import com.bornfire.xbrl.entities.RT_Matrix_monitoring_rep;
import com.bornfire.xbrl.entities.RT_Mis_Fund_Based_Adv_Rep;
import com.bornfire.xbrl.entities.RT_Noop_net_position_rep;
import com.bornfire.xbrl.entities.RT_Noop_net_position_summ_rep;
import com.bornfire.xbrl.entities.RT_Overnight_Foreign_Ccy_Data_Summ_Repo;
import com.bornfire.xbrl.entities.RT_RWA_Fund_base_data_entity;
import com.bornfire.xbrl.entities.RT_RWA_Fund_base_data_rep;
import com.bornfire.xbrl.entities.RT_Return_On_Asset_Entity;
import com.bornfire.xbrl.entities.RT_Return_On_Asset_Repo;
import com.bornfire.xbrl.entities.RT_SLS_Repository;
import com.bornfire.xbrl.entities.RT_VAR_PORTFOLIO_Repo;
import com.bornfire.xbrl.entities.Rt_AcprSecuredUnsecuredEntity;
import com.bornfire.xbrl.entities.Rt_AcprSecuredUnsecuredrep;
import com.bornfire.xbrl.entities.Stableresourcesratio_entity;
import com.bornfire.xbrl.entities.Stableresourcesratio_rep;
import com.bornfire.xbrl.services.AnalyticalPivotService;
import com.bornfire.xbrl.services.AuditService;
import com.bornfire.xbrl.services.DataInventoryService;
import com.bornfire.xbrl.services.DataInventoryService.NoDataForExportException;
import com.bornfire.xbrl.services.Excel_Services;
import com.bornfire.xbrl.services.MatrixRunService;
import com.bornfire.xbrl.services.ReportControlCenterStepService;
import com.bornfire.xbrl.services.counter_services;

@RestController
public class MIS_Rest_Controller {
	private static final Logger logger = LoggerFactory.getLogger(MIS_Rest_Controller.class);

	@Autowired
	private Excel_Services excelServices;

	@Autowired
	Rt_AcprSecuredUnsecuredrep rt_acprsecuredunsecuredrep;

	@Autowired
	AuditService auditService;

	@Autowired
	counter_services counter_services;

	@Autowired
	RT_Matrix_monitoring_rep RT_Matrix_monitoring_rep;

	@Autowired
	Elar_summary_report_rep Elar_summary_report_rep;

	@Autowired
	RT_RWA_Fund_base_data_rep RT_RWA_Fund_base_data_rep;

	@Autowired
	Stableresourcesratio_rep Stableresourcesratio_rep;

	@Autowired
	Leverage_ratio_rep Leverage_ratio_rep;

	@Autowired
	Capitaladequacyratio_rep Capitaladequacyratio_rep;

	@Autowired
	RT_Mis_Fund_Based_Adv_Rep RT_Mis_Fund_Based_Adv_Rep;

	@Autowired
	RT_Noop_net_position_rep RT_Noop_net_position_rep;

	@Autowired
	RT_Noop_net_position_summ_rep RT_Noop_net_position_summ_rep;

	@Autowired
	Groupexp_cust_maintain_rep Groupexp_cust_maintain_rep;

	@Autowired
	RT_SLS_Repository RT_SLS_Repository;

	@Autowired
	RT_MID_FX_DEAL_REPO RT_MID_FX_DEAL_REPO;

	@Autowired
	MatrixRunService matrixRunService;
	
	@Autowired
	RT_IRS_REPOSITORY RT_irs_repository;

	@Autowired
	RT_IRS2_REPOSITORY RT_IRS2_REPOSITORY;

	@Autowired
	private ReportControlCenterStepService reportControlCenterStepService;

	@Autowired
	private AnalyticalPivotService analyticalPivotService;

	@Autowired
	private DataInventoryService dataInventoryService;

	@Autowired
	private RT_Data_Inventory_Repo dataInventoryRepo;
	
	@Autowired
	RT_Return_On_Asset_Repo RT_Return_On_Asset_Repo;

	@Autowired
	RT_Overnight_Foreign_Ccy_Data_Summ_Repo RT_Overnight_Foreign_Ccy_Data_Summ_Repo;
	
	@Autowired
	RT_VAR_PORTFOLIO_Repo RT_VAR_PORTFOLIO_Repo;
	
	@Autowired
    JdbcTemplate jdbcTemplate;	

	@GetMapping("/api/report-control/reports/{reportId}/steps")
	public ResponseEntity<ReportControlStepsResponseDto> reportControlGetSteps(@PathVariable String reportId,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reportDate,
			HttpServletRequest req) {
		try {
			BigDecimal rid = new BigDecimal(reportId.trim());
			Date day = java.sql.Date.valueOf(reportDate);
			String user = req.getSession() != null ? (String) req.getSession().getAttribute("USERID") : null;
			return ResponseEntity.ok(reportControlCenterStepService.getStepsResponseForReportAndDay(rid, day, user));
		} catch (NumberFormatException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/api/report-control/master")
	public ResponseEntity<List<ReportControlMasterRowDto>> reportControlMaster(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reportDate) {
		Date day = java.sql.Date.valueOf(reportDate);
		return ResponseEntity.ok(reportControlCenterStepService.getMasterRowsForDay(day));
	}

	@PostMapping("/api/report-control/reports/{reportId}/steps/{stepId}/run")
	public ReportControlRunStepResponseDto reportControlRunStep(@PathVariable String reportId,
			@PathVariable Long stepId,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reportDate,
			HttpServletRequest req) {
		try {
			BigDecimal rid = new BigDecimal(reportId.trim());
			Date day = java.sql.Date.valueOf(reportDate);
			String execUser = req.getSession() != null ? (String) req.getSession().getAttribute("USERID") : null;
			return reportControlCenterStepService.startStep(rid, stepId, day, execUser);
		} catch (NumberFormatException e) {
			return new ReportControlRunStepResponseDto(ReportControlCenterStepService.ST_FAILED, "Invalid report id");
		}
	}

	@PostMapping("/api/report-control/reports/{reportId}/run-all")
	public ResponseEntity<ReportControlRunAllResponseDto> reportControlRunAll(@PathVariable String reportId,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reportDate,
			HttpServletRequest req) {
		try {
			BigDecimal rid = new BigDecimal(reportId.trim());
			Date day = java.sql.Date.valueOf(reportDate);
			String execUser = req.getSession() != null ? (String) req.getSession().getAttribute("USERID") : null;
			return ResponseEntity.ok(reportControlCenterStepService.startAllSteps(rid, day, execUser));
		} catch (NumberFormatException e) {
			return ResponseEntity.badRequest().body(new ReportControlRunAllResponseDto(
					ReportControlCenterStepService.ST_FAILED, "Invalid report id", 0, 0, null));
		}
	}

	/** Keeps the HTTP session alive during long-running report steps (same interval as login). */
	@GetMapping("/api/session/ping")
	public ResponseEntity<Map<String, Object>> sessionPing(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("USERID") == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		session.setMaxInactiveInterval(2 * 60 * 60);
		return ResponseEntity.ok(Collections.singletonMap("ok", true));
	}

	@GetMapping("/api/analytical/tables")
	public List<AnalyticalPivotTableDto> analyticalTables() {
		return analyticalPivotService.getAllowedTables();
	}

	@GetMapping("/api/analytical/tables/{tableName}/columns")
	public ResponseEntity<?> analyticalColumns(@PathVariable String tableName) {
		try {
			List<AnalyticalPivotColumnDto> out = analyticalPivotService.getColumnsForTable(tableName);
			return ResponseEntity.ok(out);
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	@GetMapping("/api/analytical/tables/{tableName}/columns/{columnName}/distinct-values")
	public ResponseEntity<?> analyticalDistinctValues(@PathVariable String tableName,
			@PathVariable String columnName, @RequestParam(defaultValue = "200") int limit) {
		try {
			return ResponseEntity.ok(analyticalPivotService.getDistinctColumnValues(tableName, columnName, limit));
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	@PostMapping("/api/analytical/pivot/run")
	public ResponseEntity<?> analyticalRun(@RequestBody AnalyticalPivotRequestDto request) {
		try {
			AnalyticalPivotRunResponseDto response = analyticalPivotService.runPivot(request);
			return ResponseEntity.ok(response);
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	@PostMapping("/api/analytical/layouts")
	public ResponseEntity<?> saveAnalyticalLayout(@RequestBody AnalyticalPivotLayoutDto request, HttpServletRequest req) {
		String userId = (String) req.getSession().getAttribute("USERID");
		try {
			AnalyticalPivotLayoutDto saved = analyticalPivotService.saveLayout(userId, request);
			return ResponseEntity.ok(saved);
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	@GetMapping("/api/analytical/layouts")
	public ResponseEntity<List<AnalyticalPivotLayoutDto>> loadAnalyticalLayouts(HttpServletRequest req) {
		String userId = (String) req.getSession().getAttribute("USERID");
		return ResponseEntity.ok(analyticalPivotService.loadLayouts(userId));
	}

	/**
	 * Upsert {@code RT_RETURN_ON_ASSET} for the report date (insert or replace values). Used by dashboard ROA editor.
	 */
	@PostMapping("/api/rt-return-on-asset/save")
	public ResponseEntity<Map<String, String>> saveReturnOnAsset(@RequestParam("reportDate") String reportDateStr,
			@RequestParam(value = "dailyAvgAssets", required = false) String dailyAvgAssets,
			@RequestParam(value = "netProfit", required = false) String netProfit,
			@RequestParam(value = "returnOnAssetPercent", required = false) String returnOnAssetPercent) {
		try {
			String raw = reportDateStr != null && reportDateStr.contains("T") ? reportDateStr.split("T")[0]
					: reportDateStr;
			String norm = normalizeDate(raw.trim());
			java.sql.Date d = java.sql.Date.valueOf(LocalDate.parse(norm));
			RT_Return_On_Asset_Entity e = RT_Return_On_Asset_Repo.findById(d).orElse(new RT_Return_On_Asset_Entity());
			e.setReport_date(d);
			e.setDaily_avg_assets_net_of_inter_branch_borr(parseBigDecimalParam(dailyAvgAssets));
			e.setNet_profit(parseBigDecimalParam(netProfit));
			e.setReturn_on_asst_per(parseBigDecimalParam(returnOnAssetPercent));
			RT_Return_On_Asset_Repo.save(e);
			return ResponseEntity.ok(Collections.singletonMap("status", "OK"));
		} catch (Exception ex) {
			logger.warn("saveReturnOnAsset failed", ex);
			return ResponseEntity.badRequest()
					.body(Collections.singletonMap("message", ex.getMessage() != null ? ex.getMessage() : "Save failed"));
		}
	}

	private static BigDecimal parseBigDecimalParam(String s) {
		if (s == null) {
			return null;
		}
		String t = s.trim();
		if (t.isEmpty()) {
			return null;
		}
		try {
			return new BigDecimal(t.replace(",", ""));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid number: " + s);
		}
	}

	@PostMapping("/api/analytical/pivot/export")
	public ResponseEntity<?> analyticalExport(@RequestBody AnalyticalPivotRequestDto request, HttpServletRequest req) {
		try {
			byte[] excel = analyticalPivotService.exportPivotExcel(request);
			String tableName = request != null && request.getTableName() != null ? request.getTableName().trim()
					: "TABLE";
			String fileName = "Analytical_Pivot_" + tableName + "_"
					+ new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".xlsx";

			String userId = (String) req.getSession().getAttribute("USERID");
			auditService.createBusinessAudit(userId, "DOWNLOAD", "ANALYTICAL_PIVOT_EXCEL", null, tableName);

			HttpHeaders headers = new HttpHeaders();
			headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"");

			return ResponseEntity.ok().headers(headers).contentLength(excel.length).contentType(MediaType.parseMediaType(
					"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
					.body(new ByteArrayResource(excel));
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		} catch (Exception ex) {
			logger.error("Error generating analytical pivot excel", ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating excel");
		}
	}

	@GetMapping("/api/data-inventory")
	public ResponseEntity<List<DataInventoryItemDto>> dataInventoryList() {
		return ResponseEntity.ok(dataInventoryService.listActiveInventory());
	}

	@GetMapping("/api/data-inventory/{id}/export")
	public ResponseEntity<?> dataInventoryExport(@PathVariable Long id,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reportDate,
			@RequestParam(defaultValue = "excel") String format,
			HttpServletRequest req) {
		try {
			RT_Data_Inventory_Entity config = dataInventoryRepo.findById(id).orElse(null);
			DataInventoryExportResultDto exportResult = dataInventoryService.export(id, reportDate, format);

			String userId = req.getSession() != null ? (String) req.getSession().getAttribute("USERID") : null;
			String reportName = config != null ? config.getReportName() : String.valueOf(id);
			String tableName = config != null ? config.getTableName() : "";
			Map<String, String> auditDetails = new java.util.HashMap<String, String>();
			auditDetails.put("reportName", reportName);
			auditDetails.put("reportDate", reportDate.toString());
			auditService.createBusinessAudit(userId, "DOWNLOAD", "DATA_INVENTORY_EXPORT", auditDetails, tableName);

			HttpHeaders headers = new HttpHeaders();
			headers.set(HttpHeaders.CONTENT_DISPOSITION,
					"attachment; filename=\"" + exportResult.getFileName() + "\"");

			return ResponseEntity.ok().headers(headers).contentLength(exportResult.getContent().length)
					.contentType(MediaType.parseMediaType(exportResult.getContentType()))
					.body(new ByteArrayResource(exportResult.getContent()));
		} catch (NoDataForExportException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		} catch (Exception ex) {
			logger.error("Error exporting data inventory", ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating export");
		}
	}

	@GetMapping("/download/excel")
	public void downloadExcel(HttpServletResponse response, @RequestParam(required = false) String mode) {

		if (mode.equals("exposure")) {
			try {
				logger.info("Template download for Exposure Data...");
				byte[] fileData = excelServices.generateExcel();
				logger.info("Generated file size: {}", fileData.length);

				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition", "attachment; filename=\"Exposure Data.xlsx\"");
				response.getOutputStream().write(fileData);
				response.getOutputStream().flush();
			} catch (Exception e) {
				logger.error("Error while generating  Excel file For Exposure Data", e);
			}
		} else if (mode.equals("placement")) {
			try {
				logger.info("Template download for Treasury Placement...");
				byte[] fileData = excelServices.generateExcel_placement();
				logger.info("Generated file size: {}", fileData.length);

				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition", "attachment; filename=\"Treasury Placements.xlsx\"");
				response.getOutputStream().write(fileData);
				response.getOutputStream().flush();
			} catch (Exception e) {
				logger.error("Error while generating for Treasury Placement", e);
			}

		} else if (mode.equals("settlement")) {
			try {
				logger.info("Template download for settlement...");
				byte[] fileData = excelServices.generateExcel_Settlement();
				logger.info("Generated file size: {}", fileData.length);

				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition", "attachment; filename=\"Settlement.xlsx\"");
				response.getOutputStream().write(fileData);
				response.getOutputStream().flush();
			} catch (Exception e) {
				logger.error("Error while generating  Excel file for settlement", e);
			}

		}
	}

	@GetMapping("/download/final")
	public void final_sheet(HttpServletResponse response, HttpServletRequest req,
			@RequestParam("ReportDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate ReportDate) {
		try {
			byte[] fileData = excelServices.generate_final_sheet(ReportDate);
			logger.info("Generated file size: {}", fileData.length);
			String userid = (String) req.getSession().getAttribute("USERID");
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition",
					"attachment; filename=\"Counterparty Bank Exposure (ASL) statement " + ReportDate + ".xlsx\"");
			response.getOutputStream().write(fileData);
			response.getOutputStream().flush();
			auditService.createBusinessAudit(userid, "DOWNLOAD", "Final Sheet", null, "MIS_BANK_LIMITS");
		} catch (Exception e) {
			logger.error("Error while generating Final sheet Excel file", e);
		}
	}

	@GetMapping("/download/Download_detail_report")
	public void Download_detail_report(HttpServletResponse response, HttpServletRequest req,
			@RequestParam("ReportDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate ReportDate) {
		try {
			byte[] fileData = excelServices.Generate_detail_statement(ReportDate);
			logger.info("Generated file size: {}", fileData.length);
			String userid = (String) req.getSession().getAttribute("USERID");
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition",
					"attachment; filename=\"Counterparty Bank Exposure (ASL) detail statement " + ReportDate
							+ ".xlsx\"");
			response.getOutputStream().write(fileData);
			response.getOutputStream().flush();
			auditService.createBusinessAudit(userid, "DOWNLOAD", "Final Sheet", null, "MIS_BANK_LIMITS");
		} catch (Exception e) {
			logger.error("Error while generating Final sheet Excel file", e);
		}
	}

	@GetMapping("/download/Exposure")
	public void Exposure(HttpServletResponse response, HttpServletRequest req,
			@RequestParam("ReportDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate ReportDate,
			@RequestParam(required = false) String branch) {
		String userid = (String) req.getSession().getAttribute("USERID");
		try {
			byte[] fileData = excelServices.generate_Exposure(ReportDate, branch);
			logger.info("Generated file size: {}", fileData.length);
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment; filename=\"Exposure Data.xlsx\"");
			response.getOutputStream().write(fileData);
			response.getOutputStream().flush();
			auditService.createBusinessAudit(userid, "DOWNLOAD", "Exposure Data", null, "MIS_ASL_DETAIL_REPORT");
		} catch (Exception e) {
			logger.error("Error while generating Exposure Excel file", e);
		}
	}

	@GetMapping("/download/Placement")
	public void Placement(HttpServletResponse response, HttpServletRequest req,
			@RequestParam("Report_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate Report_date) {

		try {
			byte[] fileData = excelServices.generate_Placement(Report_date);
			logger.info("Generated file size: {}", fileData.length);
			String userid = (String) req.getSession().getAttribute("USERID");
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment; filename=\"Treasury Placement.xlsx\"");
			response.getOutputStream().write(fileData);
			response.getOutputStream().flush();
			auditService.createBusinessAudit(userid, "DOWNLOAD", "Treasury Placement", null, "MIS_TREASURY_PLACEMENT");
		} catch (Exception e) {
			logger.error("Error while generating Exposure Excel file", e);
		}
	}

	@GetMapping("/download/treasuryLimit")
	public void treasuryLimit(HttpServletResponse response, HttpServletRequest req,
			@RequestParam("ReportDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate ReportDate) {
		String userid = (String) req.getSession().getAttribute("USERID");
		try {
			byte[] fileData = excelServices.treasuryLimit(ReportDate);
			logger.info("Generated file size: {}", fileData.length);
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment; filename=\"Treasury Limit.xlsx\"");
			response.getOutputStream().write(fileData);
			response.getOutputStream().flush();
			auditService.createBusinessAudit(userid, "DOWNLOAD", "Treasury Limit", null, "MIS_TREASURY_LIMITS");
		} catch (Exception e) {
			logger.error("Error while generating Exposure Excel file", e);
		}
	}

	@GetMapping("/download/SettlementLimit")
	public void SettlementLimit(HttpServletResponse response, HttpServletRequest req,
			@RequestParam("ReportDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate ReportDate) {
		String userid = (String) req.getSession().getAttribute("USERID");
		try {
			byte[] fileData = excelServices.SettlementLimit(ReportDate);
			logger.info("Generated file size: {}", fileData.length);
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment; filename=\"Settlement Limit.xlsx\"");
			response.getOutputStream().write(fileData);
			response.getOutputStream().flush();
			auditService.createBusinessAudit(userid, "DOWNLOAD", "Settlement Limit", null, "MIS_SETTLEMENT");
		} catch (Exception e) {
			logger.error("Error while generating Exposure Excel file", e);
		}
	}

	@PostMapping("/Exposurebillservice")
	@ResponseBody
	public String Exposurebillservice(@ModelAttribute Mis_exposure_bill_detail_entity Mis_exposure_bill_detail_entity,
			Model md, HttpServletResponse response, HttpServletRequest rq,
			@RequestParam(required = false) String formmode) {
		logger.info("==> Entered Exposure bill service api controller");

		try {

			String msg = counter_services.Exposurebillservice(Mis_exposure_bill_detail_entity, formmode, rq);
			logger.info("✅ Returning message to UI: {}", msg);
			return msg;
		} catch (Exception e) {
			logger.error("Error occurred while Add  New Bill: {}", e.getMessage(), e);
			return e.getMessage();
		}
	}

	@GetMapping("/getMappedBankName")
	@ResponseBody
	public String getMappedBankName(@RequestParam("oldBankName") String oldBankName) {
		String mapped = counter_services.getMappedBankName(oldBankName);
		return mapped != null ? mapped : "";
	}

	/// Group detail / Updated Del Flg
	@GetMapping("/UpdatedCustgroupdetail")
	public String Groupdetailservice(@RequestParam(value = "Group_id", required = true) String Group_id,
			@RequestParam(value = "funtion_code", required = true) String funtion_code,
			@ModelAttribute Groupexp_cust_maintain_entity Groupdetail_entry) {
		String response_msg = "";
		if (funtion_code.equals("00")) {
			Groupexp_cust_maintain_entity Groupdetail = Groupexp_cust_maintain_rep.Getgroupdetails(Group_id);

			Groupdetail.setDel_flg("Y");
			Groupexp_cust_maintain_rep.save(Groupdetail);

			response_msg = "Group " + Group_id + " was successfully marked as Inactive.";
		} else if (funtion_code.equals("01")) {
			Groupexp_cust_maintain_entity New_group_entry = new Groupexp_cust_maintain_entity();

			New_group_entry.setGroup_id(Groupdetail_entry.getGroup_id());
			New_group_entry.setGroup_name(Groupdetail_entry.getGroup_name());
			New_group_entry.setBelonging_customer_id(Groupdetail_entry.getBelonging_customer_id());
			New_group_entry.setDel_flg("N");

			Groupexp_cust_maintain_rep.save(New_group_entry);
		}

		return response_msg;

	}

	@PostMapping("/CustomerGrp_Maintenance_Rest")
	public String CustomerGrp_Maintenance(@RequestParam(value = "Group_id", required = false) String Group_id,
			@ModelAttribute Groupexp_cust_maintain_entity Groupdetail_entry) {
		String response_msg = "";
		System.out.println("Entered");
		Groupexp_cust_maintain_entity New_group_entry = new Groupexp_cust_maintain_entity();

		New_group_entry.setGroup_id(Groupdetail_entry.getGroup_id());
		New_group_entry.setGroup_name(Groupdetail_entry.getGroup_name());
		New_group_entry.setBelonging_customer_id(Groupdetail_entry.getBelonging_customer_id());
		New_group_entry.setDel_flg("N");

		Groupexp_cust_maintain_rep.save(New_group_entry);
		response_msg = "Added Successfully";

		return response_msg;

	}

	@GetMapping("/GetStocklimitdetail")
	public List<Object[]> GetStocklimitdetail(
			@RequestParam(value = "Matrix_Srl_no", required = true) String Matrix_Srl_no,
			@RequestParam(value = "Report_date", required = false) String Report_date) {
		List<Object[]> Exposuredata = new ArrayList<>();
		System.out.println("Bar chart Entered");

		if (Report_date.contains("T")) {
			Report_date = Report_date.split("T")[0];
			System.out.println(Report_date + " Splitted date");
		}

		Date Selecteddate = java.sql.Date.valueOf(normalizeDate(Report_date.toString()));

		if (Matrix_Srl_no.equals("45")) {
			Exposuredata = RT_SLS_Repository.GetStockapproachratioGraph(Selecteddate);
		}
		return Exposuredata;
	}
	
	
	
	
	

	@GetMapping("/Getbarchart")
	public List<RT_Chart_pojo> Getbarchart(@RequestParam(value = "Matrix_Srl_no", required = true) String Matrix_Srl_no,
			@RequestParam(value = "Report_date", required = false) String Report_date) {
		System.out.println("Bar chart Entered for S_NO=" + Matrix_Srl_no);

		if (Report_date != null && Report_date.contains("T")) {
			Report_date = Report_date.split("T")[0];
		}

		Date Selecteddate = java.sql.Date.valueOf(normalizeDate(Report_date.toString()));
		List<Object[]> getchartval = RT_Matrix_monitoring_rep.GetMatrixChartMonthlyBySno(Selecteddate, Matrix_Srl_no);
		return mapMatrixChartRows(getchartval, Matrix_Srl_no);
	}

	@GetMapping("/groupdetail/customer-search")
	public List<String> GetGroupCustomerlist(@RequestParam(value = "term", required = true) String term) {
		List<String> Customerlist = new ArrayList<>();
		System.out.println("Enterd");
		Customerlist = RT_RWA_Fund_base_data_rep.Getsortingcustomerlist(term);
		System.out.println(Customerlist.size());
		return Customerlist;
	}

	@GetMapping("/Getprogresschart")
	public List<RT_Chart_pojo> Getprogresschart(
			@RequestParam(value = "Matrix_Srl_no", required = true) String Matrix_Srl_no,
			@RequestParam(value = "Report_date", required = false) String Report_date) {
		System.out.println("Progress Chart Entered for S_NO=" + Matrix_Srl_no);

		if (Report_date != null && Report_date.contains("T")) {
			Report_date = Report_date.split("T")[0];
		}

		Date Selecteddate = java.sql.Date.valueOf(normalizeDate(Report_date.toString()));
		List<Object[]> getchartval = RT_Matrix_monitoring_rep.GetMatrixChartDailyBySno(Selecteddate, Matrix_Srl_no);
		return mapMatrixChartRows(getchartval, Matrix_Srl_no);
	}

	@GetMapping("/GetSecuredUnsecureddata")
	public Rt_AcprSecuredUnsecuredEntity GetSecuredUnsecureddata(@RequestParam("Report_date") String Report_date)
			throws ParseException {

		if (Report_date.contains("T")) {
			Report_date = Report_date.split("T")[0];
			System.out.println(Report_date + " Splitted date");
		}

		Date Selecteddate = java.sql.Date.valueOf(normalizeDate(Report_date.toString()));
		System.out.println(Selecteddate);
		Rt_AcprSecuredUnsecuredEntity Rt_AcprSecuredlist = rt_acprsecuredunsecuredrep
				.GetSecuredUnsecuredreport(Selecteddate);

		return Rt_AcprSecuredlist;

	}

	@GetMapping("/GetElarreport")
	public Elar_summary_report_entity GetElarreport(@RequestParam("Report_date") String Report_date)
			throws ParseException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date Selecteddate = dateFormat.parse(Report_date);

		Elar_summary_report_entity Elar_summary_report_entity = Elar_summary_report_rep.Getelarreport(Selecteddate);

		return Elar_summary_report_entity;

	}

	@GetMapping("/GetAsrrreport")
	public Stableresourcesratio_entity GetAsrrreport(@RequestParam("Report_date") String Report_date)
			throws ParseException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date Selecteddate = dateFormat.parse(Report_date);

		Stableresourcesratio_entity Elar_summary_report_entity = Stableresourcesratio_rep.GetAsrrreport(Selecteddate);

		return Elar_summary_report_entity;

	}

	@GetMapping("/Getcategorychart")
	public List<RT_Chart_pojo> Getcategorychart(@RequestParam("Report_date") String Report_date,
			@RequestParam("Branch_name") String Branch_name) throws ParseException {

		List<RT_Chart_pojo> chartList = new ArrayList<>();

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date Selecteddate = dateFormat.parse(Report_date);

		List<Object[]> RT_Chart_Data;
		if ("Total".equalsIgnoreCase(Branch_name)) {
			RT_Chart_Data = RT_RWA_Fund_base_data_rep.getoverallcategorywiseportfolio(Selecteddate);
		} else {
			RT_Chart_Data = RT_RWA_Fund_base_data_rep.getcatorywiseportfolio(Selecteddate, Branch_name);
		}

		for (Object[] RT_data : RT_Chart_Data) {

			RT_Chart_pojo RT_Chart_pojo = new RT_Chart_pojo();

			RT_Chart_pojo.setClassification(String.valueOf(RT_data[0] != null ? RT_data[0] : ""));
			RT_Chart_pojo.setExposurebal(new BigDecimal(String.valueOf(RT_data[1] != null ? RT_data[1] : "0.00")));
			RT_Chart_pojo.setExposureperc(new BigDecimal(String.valueOf(RT_data[2] != null ? RT_data[2] : "0.00")));

			chartList.add(RT_Chart_pojo);
		}

		return chartList;

	}

	// This is used to pull the list of data's for the dashboard page
	@PostMapping("Limitdetaildata")
	@ResponseBody
	public List<Object[]> GetSingleandGroupExposurevalue(
			@RequestParam(value = "Report_date", required = true) String Report_date,
			@RequestParam(value = "Data_Type_Used", required = true) String Data_Type_Used,
			@RequestParam(value = "Tier1capital", required = false) String Tier1capital) throws ParseException {

		System.out.println("Tier 1 Capital for the year " + Tier1capital + "\r\n and Report date is : " + Report_date);

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		if (Report_date.contains("T")) {
			Report_date = Report_date.split("T")[0];
			System.out.println(Report_date + " Splitted date");
		}

		Date Selecteddate = java.sql.Date.valueOf(normalizeDate(Report_date.toString()));

		System.out.println("Final Date for Searching - " + Selecteddate);

		List<Object[]> Exposuredata = new ArrayList<>();
		if (Data_Type_Used.equals("ToptenSingleExposure")) {
			Exposuredata = RT_RWA_Fund_base_data_rep.GetsingleExposure(Selecteddate);
		} else if (Data_Type_Used.equals("ToptenGroupExposure")) {
			Exposuredata = RT_RWA_Fund_base_data_rep.Getgroupexposure(Selecteddate);
		} else if (Data_Type_Used.equals("Exposureoutsidegcc")) {
			Exposuredata = RT_RWA_Fund_base_data_rep.GetoutsideGccExposure(Selecteddate);
		} else if (Data_Type_Used.equals("Exposureonlygcc")) {
			Exposuredata = RT_RWA_Fund_base_data_rep.GetGccExposure(Selecteddate);
		} else if (Data_Type_Used.equals("Exposuresummarydata")) {
			Exposuredata = RT_RWA_Fund_base_data_rep.CountryExpSummary(Selecteddate);
		} else if (Data_Type_Used.equals("Mortageloanappetite")) {
			Exposuredata = RT_Mis_Fund_Based_Adv_Rep.GetMortageloanappetite(Selecteddate);
		} else if (Data_Type_Used.equals("Toptenhousingloandata")) {
			Exposuredata = RT_Mis_Fund_Based_Adv_Rep.GetHousingloantoptencust(Selecteddate);
		} else if (Data_Type_Used.equals("Toptentopuploandata")) {
			Exposuredata = RT_Mis_Fund_Based_Adv_Rep.GetTopuploantoptencust(Selecteddate);
		} else if (Data_Type_Used.equals("Mortgageloantopten")) {
			Exposuredata = RT_Mis_Fund_Based_Adv_Rep.GetMortgageloantencust(Selecteddate);
		} else if (Data_Type_Used.equals("FreshslippageQoQ")) {
			// Here it is based in Quaterly Calculation so that i am taking RWA Table
			Exposuredata = RT_RWA_Fund_base_data_rep.Freshslippage(Selecteddate);
		} else if (Data_Type_Used.equals("Sector_Industry")) {
			Exposuredata = RT_RWA_Fund_base_data_rep.Industry_Classifi(Selecteddate);
		} else if (Data_Type_Used.equals("Sector_Trading")) {
			Exposuredata = RT_RWA_Fund_base_data_rep.Trading_Classifi(Selecteddate);
		} else if (Data_Type_Used.equals("Sector_Services")) {
			System.out.println("Fetching Services Details");
			Exposuredata = RT_RWA_Fund_base_data_rep.Services_Classifi(Selecteddate);
		} else if (Data_Type_Used.equals("Sector_Banks")) {
			Exposuredata = RT_RWA_Fund_base_data_rep.Banks_Classifi(Selecteddate);
		} else if (Data_Type_Used.equals("Sector_Real_Estate")) {
			Exposuredata = RT_RWA_Fund_base_data_rep.RealEstate_Classifi(Selecteddate);
		} else if (Data_Type_Used.equals("Sector_Others")) {
			Exposuredata = RT_RWA_Fund_base_data_rep.Others_Classifi(Selecteddate);
		} else if (Data_Type_Used.equals("CapitalAdequacyratio")) {
			Exposuredata = Capitaladequacyratio_rep.GetCapitalAdequecyvalues(Selecteddate);

			System.out.println("Size of the Exposure data : " + Exposuredata.size());

		} else if (Data_Type_Used.equals("NetOvernight_noop")) {
			Exposuredata = RT_Noop_net_position_summ_rep.Get_Noop_netposition(Selecteddate);
		} else if (Data_Type_Used.equals("RealEstateaccountdetail")) {
			Exposuredata = RT_RWA_Fund_base_data_rep.GetToptenRealestateaccountdetail(Selecteddate);
			System.out.println("Selected Real Estate Detail size : " + Exposuredata.size());
		} else if (Data_Type_Used.equals("tenaccountdetailSlippage")) {
			Exposuredata = RT_RWA_Fund_base_data_rep.GetToptenSlippage(Selecteddate);
		} else if (Data_Type_Used.equals("teaccountProvisionCoverageRatio")) {
			Exposuredata = RT_RWA_Fund_base_data_rep.GetToptenProvision(Selecteddate);
		} else if (Data_Type_Used.equals("tenaccountMortgageLoanAppetite")) {
			Exposuredata = RT_Mis_Fund_Based_Adv_Rep.GetTopteMort(Selecteddate);
		}

		else if (Data_Type_Used.equals("tenaccountSectorIndustrial")) {
			Exposuredata = RT_RWA_Fund_base_data_rep.GetToptenSectorIndustrial(Selecteddate);
		} else if (Data_Type_Used.equals("tenaccountSectorTrading")) {
			Exposuredata = RT_RWA_Fund_base_data_rep.GetToptenSectorTrading(Selecteddate);
		} else if (Data_Type_Used.equals("tenaccountServicesexcludingbank")) {
			Exposuredata = RT_RWA_Fund_base_data_rep.GetToptenSectorServicesexcludingbank(Selecteddate);
		} else if (Data_Type_Used.equals("tenaccountBank")) {
			Exposuredata = RT_RWA_Fund_base_data_rep.GetToptenSectorbank(Selecteddate);
		} else if (Data_Type_Used.equals("tenaccountRealEstate")) {
			Exposuredata = RT_RWA_Fund_base_data_rep.GetToptenRealEstate(Selecteddate);
		} else if (Data_Type_Used.equals("tenaccountOtherSectors")) {
			Exposuredata = RT_RWA_Fund_base_data_rep.GetToptenOtherSectors(Selecteddate);
		} else if (Data_Type_Used.equals("LongTermAED")) {
			Exposuredata = RT_RWA_Fund_base_data_rep.GetlongtermAED(Selecteddate);
		} else if (Data_Type_Used.equals("LongTermUSD")) {
			Exposuredata = RT_RWA_Fund_base_data_rep.GetlongtermUSD(Selecteddate);
		} else if (Data_Type_Used.equals("Stockapproachratio")) {
			Exposuredata = RT_SLS_Repository.GetStockapproachratio(Selecteddate);
		} else if (Data_Type_Used.equals("Depositnonretail")) {
			Exposuredata = RT_RWA_Fund_base_data_rep.GetToptenNonretaildepo(Selecteddate);
		} else if (Data_Type_Used.equals("Depositretail")) {
			Exposuredata = RT_RWA_Fund_base_data_rep.GetToptenretaildepo(Selecteddate);
		} else if (Data_Type_Used.equals("Leverageratio")) {
			Exposuredata = Leverage_ratio_rep.GetLeverageratiodata(Selecteddate);
		} else if (Data_Type_Used.equals("Generalprovision")) {
			Exposuredata = RT_Matrix_monitoring_rep.GetSelecteddateGenepro(Selecteddate);
		} else if (Data_Type_Used.equals("BPVPV01_Detail")) {
			Exposuredata = RT_MID_FX_DEAL_REPO.GetselectedmonthBPVdata(Selecteddate);
		}else if (Data_Type_Used.equals("RETURN_ON_ASSETS")) {
			Exposuredata = RT_Return_On_Asset_Repo.GetByReportDate(Selecteddate);
		} else if (Data_Type_Used.equals("ONFC_DAILY_RISK_LIMITS")) {
			Exposuredata = RT_Overnight_Foreign_Ccy_Data_Summ_Repo.getDailyRiskLimitsForMonth(Selecteddate);
		}

		return Exposuredata;

	}

	@PostMapping("GetRT_Matrix_monitoring_entity")
	@ResponseBody
	public List<RT_Matrix_monitoring_entity> GetRT_Matrix_monitoring_entity(
			@RequestParam(value = "Report_date", required = true) String Report_date,
			@RequestParam(value = "Matrixserial_no", required = false) String Matrixserial_no,
			@RequestParam(value = "MatrixLabel", required = false) String MatrixLabel) throws ParseException {

		System.out.println("Received Report date and Serial No is : " + Report_date + " " + Matrixserial_no);

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date Selecteddate = java.sql.Date.valueOf(normalizeDate(Report_date.toString()));
		System.out.println("Received Report date and Serial No is : " + Selecteddate + " " + Matrixserial_no);
		List<RT_Matrix_monitoring_entity> Rtmatrixdata = new ArrayList<RT_Matrix_monitoring_entity>();

		// Check the data is present for the selected date

		List<RT_Matrix_monitoring_entity> Datacheck = RT_Matrix_monitoring_rep.checkdataavail(Selecteddate,
				Matrixserial_no);
		System.out.println("Data Availability : " + Datacheck.size());
		if (Datacheck.size() >= 1) {
			Rtmatrixdata = RT_Matrix_monitoring_rep.GetMatrixbysortedvalue(Selecteddate, Matrixserial_no);
		}

		return Rtmatrixdata;

	}

	@PostMapping("/matrix/runForDate")
	@ResponseBody
	public Map<String, Object> runMatrixForDate(@RequestParam(value = "reportDate", required = true) String reportDate,
			@RequestParam(value = "Serialno", required = true) String Serialno, HttpServletRequest request)
			throws ParseException {

		String normalized = normalizeDate(reportDate);
		Date selectedDate = java.sql.Date.valueOf(normalized);
		String user = (String) request.getSession().getAttribute("USERID");
		if (user == null || user.trim().isEmpty()) {
			user = "SYSTEM";
		}
		System.out.println("Calculation initiated for Serial no : " + Serialno + " Report Date : " + selectedDate);
		return matrixRunService.queueRun(selectedDate, user, Serialno);
	}

	@GetMapping("/matrix/runStatus")
	@ResponseBody
	public Map<String, Object> getRunStatus(@RequestParam("jobId") String jobId) {
		MatrixRunJobEntity job = matrixRunService.getStatus(jobId);
		Map<String, Object> response = new java.util.HashMap<String, Object>();
		if (job == null) {
			response.put("found", false);
			response.put("status", "NOT_FOUND");
			response.put("message", "Job not found.");
			return response;
		}

		response.put("found", true);
		response.put("jobId", job.getJobId());
		response.put("status", job.getStatus());
		response.put("processedRatioCount", job.getProcessedRatioCount());
		response.put("message", job.getErrorMessage());
		response.put("selectedReportDate", job.getSelectedReportDate());
		return response;
	}

	@PostMapping("/GetExposuredata")
	@ResponseBody
	public List<RT_RWA_Fund_base_data_entity> GetExposuredata(
			@RequestParam(value = "Report_date", required = false) String reportDate,
			@RequestParam(value = "classification", required = false) String classification,
			@RequestParam(value = "Branch_name", required = false) String Branch_name,
			@RequestParam(value = "Data_table_type", required = false) String Data_table_type) throws ParseException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date Selecteddate = dateFormat.parse(reportDate);

		System.out.println(Selecteddate);
		List<Object[]> TopExposuredata = new ArrayList<>();

		System.out.println(TopExposuredata.size());
		List<RT_RWA_Fund_base_data_entity> RT_RWA_Fund_base = new ArrayList<>();

		if (Data_table_type.equals("TopExposuredata")) {
			if ("Total".equalsIgnoreCase(Branch_name)) {
				TopExposuredata = RT_RWA_Fund_base_data_rep.Getoveralltopexpposure(Selecteddate, classification);
			} else {
				TopExposuredata = RT_RWA_Fund_base_data_rep.Gettopexpposure(Selecteddate, classification, Branch_name);
			}
			for (Object[] loopingExposuredata : TopExposuredata) {

				RT_RWA_Fund_base_data_entity Entitydata = new RT_RWA_Fund_base_data_entity();
				System.out.println(String.valueOf(loopingExposuredata[0]));
				Entitydata.setBranch_name(String.valueOf(loopingExposuredata[0] != null ? loopingExposuredata[0] : ""));
				Entitydata
						.setAccount_name(String.valueOf(loopingExposuredata[1] != null ? loopingExposuredata[1] : ""));
				Entitydata.setGl_code(String.valueOf(loopingExposuredata[2] != null ? loopingExposuredata[2] : ""));
				Entitydata.setConst_id(String.valueOf(loopingExposuredata[3] != null ? loopingExposuredata[3] : ""));
				Entitydata.setPurpose(String.valueOf(loopingExposuredata[4] != null ? loopingExposuredata[4] : ""));
				Entitydata.setScheme(String.valueOf(loopingExposuredata[5] != null ? loopingExposuredata[5] : ""));
				Entitydata.setRwa_class(String.valueOf(loopingExposuredata[6] != null ? loopingExposuredata[6] : ""));
				Entitydata.setInt_suspense(new BigDecimal(
						String.valueOf(loopingExposuredata[7] != null ? loopingExposuredata[7] : "0.00")));
				Entitydata.setTot_provision(new BigDecimal(
						String.valueOf(loopingExposuredata[8] != null ? loopingExposuredata[8] : "0.00")));
				Entitydata.setLimit(new BigDecimal(
						String.valueOf(loopingExposuredata[9] != null ? loopingExposuredata[9] : "0.00")));
				Entitydata.setBalance(new BigDecimal(
						String.valueOf(loopingExposuredata[10] != null ? loopingExposuredata[10] : "0.00")));
				Entitydata.setExposure(new BigDecimal(
						String.valueOf(loopingExposuredata[11] != null ? loopingExposuredata[11] : "0.00")));
				Entitydata.setRw(new BigDecimal(
						String.valueOf(loopingExposuredata[12] != null ? loopingExposuredata[12] : "0.00")));
				Entitydata.setRwa(new BigDecimal(
						String.valueOf(loopingExposuredata[13] != null ? loopingExposuredata[13] : "0.00")));
				Entitydata.setTotal_drawn_rwa(new BigDecimal(
						String.valueOf(loopingExposuredata[14] != null ? loopingExposuredata[14] : "0.00")));
				Entitydata.setTotal_rwa(new BigDecimal(
						String.valueOf(loopingExposuredata[15] != null ? loopingExposuredata[15] : "0.00")));
				RT_RWA_Fund_base.add(Entitydata);
			}
		} else if (Data_table_type.equals("Branchsnapshot")) {

			if ("Total".equalsIgnoreCase(Branch_name)) {
				TopExposuredata = RT_RWA_Fund_base_data_rep.Getallbranchportfoliosnap(Selecteddate);
			} else {
				TopExposuredata = RT_RWA_Fund_base_data_rep.Getbranchportfoliosnap(Selecteddate, Branch_name);
			}

			System.out.println(TopExposuredata.size() + " Selected Data Size");

			for (Object[] loopingExposuredata : TopExposuredata) {
				RT_RWA_Fund_base_data_entity Entitydata = new RT_RWA_Fund_base_data_entity();

				Entitydata.setBranch_name(String.valueOf(loopingExposuredata[0] != null ? loopingExposuredata[0] : ""));
				Entitydata.setBalance(new BigDecimal(
						String.valueOf(loopingExposuredata[1] != null ? loopingExposuredata[1] : "0.00"))); 
				Entitydata.setTotal_rwa(new BigDecimal(
						String.valueOf(loopingExposuredata[2] != null ? loopingExposuredata[2] : "0.00"))); 
				Entitydata.setLimit(new BigDecimal(
						String.valueOf(loopingExposuredata[3] != null ? loopingExposuredata[3] : "0.00"))); 
				Entitydata.setAdjusted_fdr(new BigDecimal(
						String.valueOf(loopingExposuredata[4] != null ? loopingExposuredata[4] : "0.00")));
				Entitydata.setCrm(new BigDecimal(
						String.valueOf(loopingExposuredata[5] != null ? loopingExposuredata[5] : "0.00")));
				Entitydata.setCrm_adj_bal(new BigDecimal(
						String.valueOf(loopingExposuredata[6] != null ? loopingExposuredata[6] : "0.00")));
				Entitydata.setCrm_gnt_adj_bal(new BigDecimal(
						String.valueOf(loopingExposuredata[7] != null ? loopingExposuredata[7] : "0.00")));
				Entitydata.setRw(new BigDecimal(
						String.valueOf(loopingExposuredata[8] != null ? loopingExposuredata[8] : "0.00")));
				Entitydata.setRwa(new BigDecimal(
						String.valueOf(loopingExposuredata[9] != null ? loopingExposuredata[9] : "0.00")));
				Entitydata.setBill_amount(new BigDecimal(
						String.valueOf(loopingExposuredata[10] != null ? loopingExposuredata[10] : "0.00")));
				Entitydata.setBill_disc_rwa(new BigDecimal(
						String.valueOf(loopingExposuredata[11] != null ? loopingExposuredata[11] : "0.00")));
				RT_RWA_Fund_base.add(Entitydata);
			}

		} else if (Data_table_type.equals("Branchsnapshotdetail")) {

			if (classification.equals("BranchTotExp")) {
				// Take the value as per the classification
				System.out.println("Selected Report Date : " + Selecteddate + " and Branch name : " + Branch_name);
				TopExposuredata = RT_RWA_Fund_base_data_rep.Gettotalexpobranch(Selecteddate, Branch_name);
			} else if (classification.equals("BranchTotRWA")) {
				TopExposuredata = RT_RWA_Fund_base_data_rep.Gettotalexpobranch(Selecteddate, Branch_name);
			} else if (classification.equals("BranchActvExp")) {
				TopExposuredata = RT_RWA_Fund_base_data_rep.Getactiveexpobranch(Selecteddate, Branch_name);
			} else if (classification.equals("BranchNPAExp")) {
				TopExposuredata = RT_RWA_Fund_base_data_rep.GetNPAexpobranch(Selecteddate, Branch_name);
			} else if (classification.equals("BranchWatchExp")) {
				TopExposuredata = RT_RWA_Fund_base_data_rep.GetWatchlistexpobranch(Selecteddate, Branch_name);
			} else if (classification.equals("BranchOverdueExp")) {
				TopExposuredata = RT_RWA_Fund_base_data_rep.GetOverdueexpobranch(Selecteddate, Branch_name);
			}

			// Then loop the data to show in front end
			for (Object[] loopingExposuredata : TopExposuredata) {

				RT_RWA_Fund_base_data_entity Entitydata = new RT_RWA_Fund_base_data_entity();
				System.out.println(String.valueOf(loopingExposuredata[0]));
				Entitydata.setBranch_name(String.valueOf(loopingExposuredata[0] != null ? loopingExposuredata[0] : ""));
				Entitydata
						.setAccount_name(String.valueOf(loopingExposuredata[1] != null ? loopingExposuredata[1] : ""));
				Entitydata.setGl_code(String.valueOf(loopingExposuredata[2] != null ? loopingExposuredata[2] : ""));
				Entitydata.setConst_id(String.valueOf(loopingExposuredata[3] != null ? loopingExposuredata[3] : ""));
				Entitydata.setPurpose(String.valueOf(loopingExposuredata[4] != null ? loopingExposuredata[4] : ""));
				Entitydata.setScheme(String.valueOf(loopingExposuredata[5] != null ? loopingExposuredata[5] : ""));
				Entitydata.setRwa_class(String.valueOf(loopingExposuredata[6] != null ? loopingExposuredata[6] : ""));
				Entitydata.setInt_suspense(new BigDecimal(
						String.valueOf(loopingExposuredata[7] != null ? loopingExposuredata[7] : "0.00")));
				Entitydata.setTot_provision(new BigDecimal(
						String.valueOf(loopingExposuredata[8] != null ? loopingExposuredata[8] : "0.00")));
				Entitydata.setLimit(new BigDecimal(
						String.valueOf(loopingExposuredata[9] != null ? loopingExposuredata[9] : "0.00")));
				Entitydata.setBalance(new BigDecimal(
						String.valueOf(loopingExposuredata[10] != null ? loopingExposuredata[10] : "0.00")));
				Entitydata.setExposure(new BigDecimal(
						String.valueOf(loopingExposuredata[11] != null ? loopingExposuredata[11] : "0.00")));
				Entitydata.setRw(new BigDecimal(
						String.valueOf(loopingExposuredata[12] != null ? loopingExposuredata[12] : "0.00")));
				Entitydata.setRwa(new BigDecimal(
						String.valueOf(loopingExposuredata[13] != null ? loopingExposuredata[13] : "0.00")));
				Entitydata.setTotal_drawn_rwa(new BigDecimal(
						String.valueOf(loopingExposuredata[14] != null ? loopingExposuredata[14] : "0.00")));
				Entitydata.setTotal_rwa(new BigDecimal(
						String.valueOf(loopingExposuredata[15] != null ? loopingExposuredata[15] : "0.00")));
				RT_RWA_Fund_base.add(Entitydata);
			}

		}
		return RT_RWA_Fund_base;

	}

	//// This is downloadfuntion need to be used for all detail download as per the
	//// limit serial no
	@RequestMapping(value = "/Limitdetaildownload", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<?> Limitdetaildownload(
			@RequestParam(value = "Matrix_Srl_no", required = true) String Matrix_Srl_no,
			@RequestParam(value = "Report_date", required = false) String Report_date, HttpServletRequest request) {
		String filename = "No";
		try {

			// -------- Date Handling --------
			if (Report_date != null && Report_date.contains("T")) {
				Report_date = Report_date.split("T")[0];
				System.out.println(Report_date + " Splitted date");
			}

			Date Selecteddate = null;
			if (Report_date != null && !Report_date.isEmpty()) {
				Selecteddate = java.sql.Date.valueOf(normalizeDate(Report_date));
			}

			// -------- Workbook --------
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("Sheet1");

			// -------- Header Style --------
			CellStyle headerStyle = workbook.createCellStyle();
			Font font = workbook.createFont();
			font.setBold(true);
			headerStyle.setFont(font);
			headerStyle.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			applyThinBorders(headerStyle);

			CellStyle dataCellStyle = workbook.createCellStyle();
			applyThinBorders(dataCellStyle);

			Row headerRow = sheet.createRow(0);

			int rowNum = 1;

			// -------- Condition Based Data --------
			if ("24".equals(Matrix_Srl_no)) {
				filename = "Noop position detail";
				String[] headers = { "REPORT_DATE", "CURRENCY", "READY_EXCHAGE_POSITION_IN_AC", "CBS_FX_POSITION_AC",
						"MTM_AC", "FORWARD_REVAL_POSITION_AC", "TOTAL_NOOP_IN_AC", "TOTAL_NOOP_IN_LC",
						"TOTAL_NOOP_IN_ USD Mn", "TOTAL_NOOP_IN_INR Crore" };

				// Create headers
				for (int i = 0; i < headers.length; i++) {
					Cell headerCell = headerRow.createCell(i);
					headerCell.setCellValue(headers[i]);
					headerCell.setCellStyle(headerStyle);
				}

				CellStyle rateHintStyle = workbook.createCellStyle();
				Font rateHintFont = workbook.createFont();
				rateHintFont.setColor(IndexedColors.RED.getIndex());
				rateHintStyle.setFont(rateHintFont);
				applyThinBorders(rateHintStyle);
				CellStyle rbiLabelStyle = workbook.createCellStyle();
				applyThinBorders(rbiLabelStyle);
				BigDecimal[] noopFedaiRates = loadNoopFedaiRates(Selecteddate);
				writeNoopRbiRefRateBlock(sheet, headerStyle, rateHintStyle, rbiLabelStyle, noopFedaiRates);

				// Fetch data
				List<Object[]> Noopdetail = RT_Noop_net_position_rep.Getnoopdetail(Selecteddate);

				// Populate data (columns A–H from DB; I–J use Excel formulas)
				final int dataColumnCount = 8;
				final int dataStartExcelRow = 2;
				int dataEndExcelRow = dataStartExcelRow - 1;
				if (Noopdetail != null && !Noopdetail.isEmpty()) {
					for (Object[] obj : Noopdetail) {
						Row row = sheet.getRow(rowNum);
						if (row == null) {
							row = sheet.createRow(rowNum);
						}
						int excelRow = row.getRowNum() + 1;
						rowNum++;

						for (int i = 0; i < dataColumnCount; i++) {
							Cell cell = row.createCell(i);

							if (i < obj.length && obj[i] != null) {

								if (i == 0) {
									cell.setCellValue(Selecteddate);
								} else if (i == 1) {
									cell.setCellValue(obj[i].toString());
								} else {
									cell.setCellValue(new BigDecimal(obj[i].toString()).doubleValue());
								}

							} else {
								cell.setCellValue("");
							}
							cell.setCellStyle(dataCellStyle);
						}

						Cell usdMnCell = row.createCell(8);
						usdMnCell.setCellFormula("H" + excelRow + "/$N$4");
						usdMnCell.setCellStyle(dataCellStyle);

						Cell inrCroreCell = row.createCell(9);
						inrCroreCell.setCellFormula("I" + excelRow + "*$N$2");
						inrCroreCell.setCellStyle(dataCellStyle);

						dataEndExcelRow = excelRow;
					}
				}

				if (dataEndExcelRow >= dataStartExcelRow) {
					writeNoopSummaryBlock(sheet, workbook, headerStyle, dataStartExcelRow, dataEndExcelRow);
				}
			} else if ("22".equals(Matrix_Srl_no)) {
				filename = "BPV PV01 detail";
				String[] headers = { "Report Date", "Forex Currency Swap, Outright Forwards",
						"IRS/CIRS", "Gsec., Corporate Bonds, Treasury Bills",
						"Investment in CPs, CDs", "Total PV01" };

				for (int i = 0; i < headers.length; i++) {
					Cell headerCell = headerRow.createCell(i);
					headerCell.setCellValue(headers[i]);
					headerCell.setCellStyle(headerStyle);
				}

				List<Object[]> bpvDetail = RT_MID_FX_DEAL_REPO.GetselectedmonthBPVdata(Selecteddate);
				if (bpvDetail != null && !bpvDetail.isEmpty()) {
					for (Object[] obj : bpvDetail) {
						Row row = sheet.createRow(rowNum++);
						for (int i = 0; i < headers.length; i++) {
							Cell cell = row.createCell(i);
							if (obj != null && i < obj.length && obj[i] != null) {
								if (i == 0) {
									cell.setCellValue(obj[i].toString());
								} else {
									cell.setCellValue(new BigDecimal(obj[i].toString()).doubleValue());
								}
							} else {
								cell.setCellValue("");
							}
							cell.setCellStyle(dataCellStyle);
						}
					}
				}
			}

			// -------- Auto-size Columns --------
			if (sheet.getRow(0) != null) {
				int colCount = Math.max(sheet.getRow(0).getLastCellNum(), 15);
				for (int i = 0; i < colCount; i++) {
					sheet.autoSizeColumn(i);
				}
			}

			// -------- Write to Output --------
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			workbook.write(outputStream);
			workbook.close();

			// -------- Response --------
			HttpHeaders headers1 = new HttpHeaders();
			headers1.add(HttpHeaders.CONTENT_DISPOSITION,
					"attachment; filename=" + filename + " " + Selecteddate + ".xlsx");

			ByteArrayResource resource = new ByteArrayResource(outputStream.toByteArray());

			return ResponseEntity.ok().headers(headers1).contentLength(outputStream.size())
					.contentType(MediaType
							.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
					.body(resource);

		} catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Collections.singletonMap("message", "Error generating the file."));
		}
	}

	/** RBI Ref Rate reference block in columns M–O (rows 1–4) for NOOP detail download. */
	private void writeNoopRbiRefRateBlock(Sheet sheet, CellStyle headerStyle, CellStyle rateHintStyle,
			CellStyle rbiLabelStyle, BigDecimal[] fedaiRates) {
		final int colM = 12;
		final int colN = 13;
		final int colO = 14;

		Row headerRow = sheet.getRow(0);
		if (headerRow == null) {
			headerRow = sheet.createRow(0);
		}
		Cell rbiHeaderCell = headerRow.createCell(colM);
		rbiHeaderCell.setCellValue("Fedai Rate");
		rbiHeaderCell.setCellStyle(headerStyle);
		Cell rbiHeaderPad = headerRow.createCell(colN);
		rbiHeaderPad.setCellStyle(headerStyle);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, colM, colN));

		String[] currencyPairs = { "USD/INR", "AED/INR", "USD/AED" };
		for (int i = 0; i < currencyPairs.length; i++) {
			int rowIdx = i + 1;
			Row row = sheet.getRow(rowIdx);
			if (row == null) {
				row = sheet.createRow(rowIdx);
			}
			Cell pairCell = row.createCell(colM);
			pairCell.setCellValue(currencyPairs[i]);
			pairCell.setCellStyle(rbiLabelStyle);
			Cell rateCell = row.createCell(colN);
			rateCell.setCellStyle(rbiLabelStyle);
			BigDecimal rate = (fedaiRates != null && i < fedaiRates.length) ? fedaiRates[i] : null;
			if (rate != null) {
				rateCell.setCellValue(rate.doubleValue());
			}
			Cell hintCell = row.createCell(colO);
			if (rate != null) {
				hintCell.setCellValue("");
			} else {
				hintCell.setCellValue("<<Enter Rate Here");
			}
			hintCell.setCellStyle(rateHintStyle);
		}
	}

	private BigDecimal[] loadNoopFedaiRates(Date reportDate) {
		BigDecimal[] rates = new BigDecimal[3];
		if (reportDate == null) {
			return rates;
		}
		List<Object[]> rows = RT_Noop_net_position_rep.getFedaiRatesByReportDate(reportDate);
		if (rows == null || rows.isEmpty() || rows.get(0) == null) {
			return rates;
		}
		Object[] row = rows.get(0);
		for (int i = 0; i < rates.length && i < row.length; i++) {
			rates[i] = toBigDecimalOrNull(row[i]);
		}
		return rates;
	}

	private BigDecimal toBigDecimalOrNull(Object value) {
		if (value == null) {
			return null;
		}
		if (value instanceof BigDecimal) {
			return (BigDecimal) value;
		}
		String text = value.toString().trim();
		if (text.isEmpty()) {
			return null;
		}
		return new BigDecimal(text);
	}

	/**
	 * NOOP summary block below data rows — labels in column G; formulas in H/I/J
	 * reference the data range dynamically (row numbers adjust to data count).
	 */
	private void writeNoopSummaryBlock(Sheet sheet, Workbook workbook, CellStyle headerStyle, int dataStartExcelRow,
			int dataEndExcelRow) {
		final int colLabel = 6;
		final int colH = 7;
		final int colI = 8;
		final int colJ = 9;

		String hRange = "H" + dataStartExcelRow + ":H" + dataEndExcelRow;
		String iRange = "I" + dataStartExcelRow + ":I" + dataEndExcelRow;
		String jRange = "J" + dataStartExcelRow + ":J" + dataEndExcelRow;

		int summaryHeaderRow = dataEndExcelRow + 2;
		int overboughtRow = summaryHeaderRow + 1;
		int oversoldRow = overboughtRow + 1;
		int noopRow = oversoldRow + 2;
		int noopInInrRow = noopRow + 1;
		int limitRow = noopInInrRow + 1;
		int headroomRow = limitRow + 1;
		int pctRow = headroomRow + 2;
		int headroomAvailRow = pctRow + 1;
		int riskRow = headroomAvailRow + 1;

		short pctFormat = workbook.getCreationHelper().createDataFormat().getFormat("0.00%");

		CellStyle labelStyle = workbook.createCellStyle();
		Font labelFont = workbook.createFont();
		labelFont.setBold(true);
		labelStyle.setFont(labelFont);
		applyThinBorders(labelStyle);

		CellStyle valueStyle = workbook.createCellStyle();
		applyThinBorders(valueStyle);

		CellStyle greenStyle = workbook.createCellStyle();
		greenStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		greenStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		applyThinBorders(greenStyle);

		CellStyle bluePctStyle = workbook.createCellStyle();
		bluePctStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
		bluePctStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		bluePctStyle.setDataFormat(pctFormat);
		Font blueFont = workbook.createFont();
		blueFont.setBold(true);
		blueFont.setColor(IndexedColors.WHITE.getIndex());
		bluePctStyle.setFont(blueFont);
		applyThinBorders(bluePctStyle);

		CellStyle headroomPctStyle = workbook.createCellStyle();
		headroomPctStyle.setDataFormat(pctFormat);
		applyThinBorders(headroomPctStyle);

		CellStyle summaryHeaderStyle = workbook.createCellStyle();
		summaryHeaderStyle.cloneStyleFrom(headerStyle);
		applyThinBorders(summaryHeaderStyle);

		Row summaryHdr = getOrCreateSheetRowByExcelNum(sheet, summaryHeaderRow);
		setCellValue(summaryHdr, colLabel, "", summaryHeaderStyle);
		setCellValue(summaryHdr, colH, "AED Mn", summaryHeaderStyle);
		setCellValue(summaryHdr, colI, "USD Mn", summaryHeaderStyle);
		setCellValue(summaryHdr, colJ, "INR Cr", summaryHeaderStyle);

		Row overbought = getOrCreateSheetRowByExcelNum(sheet, overboughtRow);
		setCellValue(overbought, colLabel, "Overbought", labelStyle);
		setCellFormula(overbought, colH, "(SUMIF(" + hRange + ",\">0\"))/10^6", valueStyle);
		setCellFormula(overbought, colI, "(SUMIF(" + iRange + ",\">0\"))/10^6", valueStyle);
		setCellFormula(overbought, colJ, "(SUMIF(" + jRange + ",\">0\"))/10^7", valueStyle);

		Row oversold = getOrCreateSheetRowByExcelNum(sheet, oversoldRow);
		setCellValue(oversold, colLabel, "Oversold", labelStyle);
		setCellFormula(oversold, colH, "(SUMIF(" + hRange + ",\"<0\"))/10^6", valueStyle);
		setCellFormula(oversold, colI, "(SUMIF(" + iRange + ",\"<0\"))/10^6", valueStyle);
		setCellFormula(oversold, colJ, "(SUMIF(" + jRange + ",\"<0\"))/10^7", valueStyle);

		Row noop = getOrCreateSheetRowByExcelNum(sheet, noopRow);
		setCellValue(noop, colLabel, "NOOP", labelStyle);
		setCellFormula(noop, colH, "MAX(ABS(H" + overboughtRow + "),ABS(H" + oversoldRow + "))", valueStyle);
		setCellFormula(noop, colI, "MAX(ABS(I" + overboughtRow + "),ABS(I" + oversoldRow + "))", valueStyle);
		setCellFormula(noop, colJ, "MAX(ABS(J" + overboughtRow + "),ABS(J" + oversoldRow + "))", valueStyle);

		Row noopInInr = getOrCreateSheetRowByExcelNum(sheet, noopInInrRow);
		setCellValue(noopInInr, colLabel, "NOOP in INR", greenStyle);
		setCellFormula(noopInInr, colH, "(H" + noopRow + "/3.673)*$N$2/10", greenStyle);
		setCellFormula(noopInInr, colI, "I" + noopRow + "*$N$2/10", greenStyle);
		setCellFormula(noopInInr, colJ, "J" + noopRow + "*1", greenStyle);

		Row limit = getOrCreateSheetRowByExcelNum(sheet, limitRow);
		setCellValue(limit, colLabel, "Limit (INR Crs)", labelStyle);
		setCellValue(limit, colH, 2000, valueStyle);
		setCellValue(limit, colI, 2000, valueStyle);
		setCellValue(limit, colJ, 2000, valueStyle);

		Row headroom = getOrCreateSheetRowByExcelNum(sheet, headroomRow);
		setCellValue(headroom, colLabel, "Headroom", labelStyle);
		setCellFormula(headroom, colH, "IF(H" + limitRow + "-H" + noopInInrRow + ">0,H" + limitRow + "-H" + noopInInrRow + ",0)",
				valueStyle);
		setCellFormula(headroom, colI, "IF(I" + limitRow + "-I" + noopInInrRow + ">0,I" + limitRow + "-I" + noopInInrRow + ",0)",
				valueStyle);
		setCellFormula(headroom, colJ, "IF(J" + limitRow + "-J" + noopInInrRow + ">0,J" + limitRow + "-J" + noopInInrRow + ",0)",
				valueStyle);

		Row pct = getOrCreateSheetRowByExcelNum(sheet, pctRow);
		setCellValue(pct, colLabel, "", bluePctStyle);
		setCellFormula(pct, colH, "H" + noopInInrRow + "/H" + limitRow, bluePctStyle);
		setCellFormula(pct, colI, "I" + noopInInrRow + "/I" + limitRow, bluePctStyle);
		setCellFormula(pct, colJ, "J" + noopInInrRow + "/J" + limitRow, bluePctStyle);

		Row headroomAvail = getOrCreateSheetRowByExcelNum(sheet, headroomAvailRow);
		setCellValue(headroomAvail, colLabel, "Head-room Available", labelStyle);
		setCellFormula(headroomAvail, colH, "1-H" + pctRow, headroomPctStyle);
		setCellFormula(headroomAvail, colI, "1-I" + pctRow, headroomPctStyle);
		setCellFormula(headroomAvail, colJ, "1-J" + pctRow, headroomPctStyle);

		Row risk = getOrCreateSheetRowByExcelNum(sheet, riskRow);
		setCellValue(risk, colLabel, "Risk Appetite Status", labelStyle);
		setCellFormula(risk, colH, "IF(H" + pctRow + ">=0.9,\"Above Risk Appetite\",\"Below Risk Appetite\")", valueStyle);
	}

	private Row getOrCreateSheetRowByExcelNum(Sheet sheet, int excelRowNum) {
		return getOrCreateSheetRow(sheet, excelRowNum - 1);
	}

	private Row getOrCreateSheetRow(Sheet sheet, int rowIdx) {
		Row row = sheet.getRow(rowIdx);
		return row != null ? row : sheet.createRow(rowIdx);
	}

	private void setCellValue(Row row, int col, String value, CellStyle style) {
		Cell cell = row.createCell(col);
		cell.setCellValue(value);
		if (style != null) {
			cell.setCellStyle(style);
		}
	}

	private void setCellValue(Row row, int col, double value, CellStyle style) {
		Cell cell = row.createCell(col);
		cell.setCellValue(value);
		if (style != null) {
			cell.setCellStyle(style);
		}
	}

	private void setCellFormula(Row row, int col, String formula, CellStyle style) {
		Cell cell = row.createCell(col);
		cell.setCellFormula(formula);
		if (style != null) {
			cell.setCellStyle(style);
		}
	}

	private void applyThinBorders(CellStyle style) {
		style.setBorderTop(BorderStyle.THIN);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
	}

	private static final BigDecimal DAYLIGHT_LIMIT_DIVISOR = new BigDecimal("45");

	/**
	 * Maps chart rows from rt_matrix_monitored_table to API pojos.
	 * S_NO 23 (daylight limit) applies the legacy display transform: value/45*100.
	 */
	private List<RT_Chart_pojo> mapMatrixChartRows(List<Object[]> rows, String matrixSrlNo) {
		if (rows == null || rows.isEmpty()) {
			return new ArrayList<>();
		}
		return rows.stream().map(row -> {
			BigDecimal value = toChartBigDecimal(row[1]);
			if ("23".equals(matrixSrlNo)) {
				value = value.divide(DAYLIGHT_LIMIT_DIVISOR, 4, RoundingMode.HALF_UP).multiply(new BigDecimal("100"));
			}
			return new RT_Chart_pojo(row[0].toString(), value);
		}).collect(Collectors.toList());
	}

	private BigDecimal toChartBigDecimal(Object raw) {
		if (raw == null) {
			return BigDecimal.ZERO;
		}
		if (raw instanceof BigDecimal) {
			return (BigDecimal) raw;
		}
		if (raw instanceof Number) {
			return BigDecimal.valueOf(((Number) raw).doubleValue());
		}
		return new BigDecimal(raw.toString());
	}

	public static String normalizeDate(String input) {
		DateTimeFormatter targetFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		// already in correct format?
		try {
			LocalDate.parse(input, targetFormat);
			return input; // return as-is
		} catch (Exception ignore) {
		}

		// try other known formats (dd-MM-yyyy before MM-dd-yyyy — dashboard uses day-first dates)
		DateTimeFormatter[] formats = { DateTimeFormatter.ofPattern("dd/MM/yyyy"),
				DateTimeFormatter.ofPattern("dd-MM-yyyy"), DateTimeFormatter.ofPattern("MM-dd-yyyy"),
				DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH) // Tue Sep 30 00:00:00 GST
																							// 2025
		};

		for (DateTimeFormatter f : formats) {
			try {
				LocalDate date = LocalDate.parse(input, f);
				return date.format(targetFormat); // convert to yyyy-MM-dd
			} catch (Exception ignore) {
			}
		}

		throw new IllegalArgumentException("Invalid date format: " + input);
	}
	
	/** Limit % per IRS bucket (same as IRS Report Analytical calculator). */
	private static final BigDecimal[] IRS_BUCKET_LIMIT_PCT = {
			new BigDecimal("0.20"),
			new BigDecimal("0.40"),
			new BigDecimal("0.40"),
			new BigDecimal("0.40"),
			new BigDecimal("0.30"),
			new BigDecimal("0.30"),
			new BigDecimal("0.30"),
			new BigDecimal("0.30"),
			new BigDecimal("0.30"),
			new BigDecimal("0.30"),
			null
	};

	private Map<String, Object> buildIrsDashboardRow(BigDecimal rsl, BigDecimal rsa, BigDecimal gap,
			BigDecimal totalAssets, BigDecimal limitPct) {
		Map<String, Object> row = new LinkedHashMap<>();
		BigDecimal safeGap = gap != null ? gap : BigDecimal.ZERO;
		BigDecimal safeRsl = rsl != null ? rsl : BigDecimal.ZERO;
		BigDecimal safeRsa = rsa != null ? rsa : BigDecimal.ZERO;
		BigDecimal netGapPct = BigDecimal.ZERO;
		if (totalAssets != null && totalAssets.signum() != 0) {
			netGapPct = safeGap.divide(totalAssets, 6, RoundingMode.HALF_UP).multiply(new BigDecimal("100"));
		}
		BigDecimal limitAmt = null;
		if (totalAssets != null && limitPct != null && limitPct.signum() > 0) {
			limitAmt = totalAssets.multiply(limitPct).setScale(2, RoundingMode.HALF_UP);
		}
		row.put("rsl", safeRsl);
		row.put("rsa", safeRsa);
		row.put("gap", safeGap);
		row.put("netGapPct", netGapPct);
		row.put("limitAmt", limitAmt);
		row.put("limitPct", limitPct);
		return row;
	}

	@RequestMapping(value = "/getIRSData", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getIRSData(
	        @RequestParam String reportdate,
	        @RequestParam String currency) throws ParseException {

		Date reportDateFor = java.sql.Date.valueOf(normalizeDate(reportdate));

	    List<RT_IRS_ENTITY> list1 =
	            RT_irs_repository.rtirslistbydate(reportDateFor, currency);

	    List<RT_IRS_ENTITY2> list2 =
	            RT_IRS2_REPOSITORY.rtirslistbydate(reportDateFor, currency);

	    Map<String, Object> response = new LinkedHashMap<>();
	    List<Map<String, Object>> rows = new ArrayList<>();

	    if (list1.isEmpty() || list2.isEmpty()) {
	    	response.put("totalAssets", BigDecimal.ZERO);
	    	response.put("rows", rows);
	        return response;
	    }

	    RT_IRS_ENTITY e1 = list1.get(0);
	    RT_IRS_ENTITY2 e2 = list2.get(0);
	    BigDecimal totalAssets = e2.getR84_total() != null ? e2.getR84_total() : BigDecimal.ZERO;

	    rows.add(buildIrsDashboardRow(e1.getR45_day1_28(), e2.getR84_day1_28(), e2.getR85_day1_28(), totalAssets, IRS_BUCKET_LIMIT_PCT[0]));
	    rows.add(buildIrsDashboardRow(e1.getR45_day29_3m(), e2.getR84_day29_3m(), e2.getR85_day29_3m(), totalAssets, IRS_BUCKET_LIMIT_PCT[1]));
	    rows.add(buildIrsDashboardRow(e1.getR45_over3m_to_6m(), e2.getR84_over3m_to_6m(), e2.getR85_over3m_to_6m(), totalAssets, IRS_BUCKET_LIMIT_PCT[2]));
	    rows.add(buildIrsDashboardRow(e1.getR45_over6m_to_1y(), e2.getR84_over6m_to_1y(), e2.getR85_over6m_to_1y(), totalAssets, IRS_BUCKET_LIMIT_PCT[3]));
	    rows.add(buildIrsDashboardRow(e1.getR45_over1y_to_3y(), e2.getR84_over1y_to_3y(), e2.getR85_over1y_to_3y(), totalAssets, IRS_BUCKET_LIMIT_PCT[4]));
	    rows.add(buildIrsDashboardRow(e1.getR45_over3y_to_5y(), e2.getR84_over3y_to_5y(), e2.getR85_over3y_to_5y(), totalAssets, IRS_BUCKET_LIMIT_PCT[5]));
	    rows.add(buildIrsDashboardRow(e1.getR45_over5y_to_7y(), e2.getR84_over5y_to_7y(), e2.getR85_over5y_to_7y(), totalAssets, IRS_BUCKET_LIMIT_PCT[6]));
	    rows.add(buildIrsDashboardRow(e1.getR45_over7y_to_10y(), e2.getR84_over7y_to_10y(), e2.getR85_over7y_to_10y(), totalAssets, IRS_BUCKET_LIMIT_PCT[7]));
	    rows.add(buildIrsDashboardRow(e1.getR45_over10y_to_15y(), e2.getR84_over10y_to_15y(), e2.getR85_over10y_to_15y(), totalAssets, IRS_BUCKET_LIMIT_PCT[8]));
	    rows.add(buildIrsDashboardRow(e1.getR45_over15y(), e2.getR84_over15y(), e2.getR85_over15y(), totalAssets, IRS_BUCKET_LIMIT_PCT[9]));
	    rows.add(buildIrsDashboardRow(e1.getR45_non_sensitive(), e2.getR84_non_sensitive(), e2.getR85_non_sensitive(), totalAssets, IRS_BUCKET_LIMIT_PCT[10]));

	    response.put("totalAssets", totalAssets);
	    response.put("rows", rows);
	    return response;
	}

	@GetMapping(value = "/dashboardvalidation/{sno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getValidationTree(@PathVariable("sno") String sno,
			@RequestParam("date") String date) {
		String sql = "SELECT GET_DYNAMIC_VALIDATION_TREE(?,?) FROM DUAL";
		String jsonTree = jdbcTemplate.queryForObject(sql, String.class, sno, date);
		return ResponseEntity.ok(jsonTree);
	}

	@PostMapping("/dashboardrunnode")
	public ResponseEntity<String> runNode(@RequestParam String nodeId, @RequestParam String reportDate,
			@RequestParam(defaultValue = "false") boolean isForceRun, HttpServletRequest request) {

		try {
			String forceFlag = isForceRun ? "Y" : "N";

			System.out.println("nodeId : " + nodeId +" and date : "+reportDate);
			
			String sql = "SELECT EXECUTE_INTERLINKED_TREE(?, ?, ?) FROM DUAL";
			String jsonTree = jdbcTemplate.queryForObject(sql, String.class, nodeId, reportDate, forceFlag);

			String sno = nodeId.substring(nodeId.lastIndexOf("_") + 1);

			if (jsonTree != null && !jsonTree.contains("\"status\":\"invalid\"")) {
//				String sql1 = "SELECT RT_MATRIX_MONITOR_CALCULATION_FUNCTION(?, ?) FROM DUAL";
//				String output = jdbcTemplate.queryForObject(sql, String.class, reportDate, sno);
				Map<String, Object> response = new java.util.HashMap<String, Object>();
				String normalized = normalizeDate(reportDate);
				Date selectedDate = java.sql.Date.valueOf(normalized);
				String user = (String) request.getSession().getAttribute("USERID");
				if (user == null || user.trim().isEmpty()) {
					user = "SYSTEM";
				}
				System.out.println("Calculation initiated for Serial no : " + sno + " Report Date : " + selectedDate);
				response = matrixRunService.queueRun(selectedDate, user, sno);
				String runStatus = "valid";
	            String runMsg = "Calculation queued successfully.";
	            
	            if (response != null) {
	                if (response.get("status") != null && response.get("status").toString().toLowerCase().contains("error")) {
	                    runStatus = "invalid";
	                }
	                if (response.get("message") != null) {
	                    runMsg = response.get("message").toString().replace("\"", "'").replace("\n", " ");
	                }
	            }
	            
	            jsonTree = "{\"nodeId\":\"JAVA_EXEC_" + sno + "\", \"nodeName\":\"Java Matrix Calculation\", \"status\":\"" + runStatus + "\", \"message\":\"" + runMsg + "\", \"children\":[" + jsonTree + "]}";
	            
			} else {
				System.out.println("Execution for S.No " + sno + " returned invalid nodes. Skipping next function.");
			}
			return ResponseEntity.ok(jsonTree);
		} catch (Exception e) {
			e.printStackTrace();
			Throwable rootCause = e;
			while (rootCause.getCause() != null && rootCause.getCause() != rootCause) {
				rootCause = rootCause.getCause();
			}
			String realError = rootCause.getMessage();
			if (realError == null) {
				realError = rootCause.toString();
			}
			realError = realError.replace("\"", "'").replace("\n", " ").replace("\r", "");
			String errorJson = "{\"nodeId\":\"ERR\", \"nodeName\":\"Database/Connection Error\", \"status\":\"invalid\", \"message\":\""
					+ realError + "\", \"children\":[]}";
					
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorJson);
		}
	}

}
