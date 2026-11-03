package com.bornfire.xbrl.controllers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.http.HttpStatus;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bornfire.xbrl.entities.*;
import com.bornfire.xbrl.entities.RT_MC_DATA_RECORD_REPO.RecordMetadataProjection;
import com.bornfire.xbrl.dto.EodAcctBalExcepUpdateDto;
import com.bornfire.xbrl.services.ASL_Excel_Services;
import com.bornfire.xbrl.services.AccessAndRolesServices;
import com.bornfire.xbrl.services.AuditService;
import com.bornfire.xbrl.services.McServiceAuditDateHelper;
import com.bornfire.xbrl.services.McServiceAuditDateHelper.ResolvedDates;
import com.bornfire.xbrl.services.Bloomberg_services;
import com.bornfire.xbrl.services.BankingBookBillDataService;
import com.bornfire.xbrl.services.Excel_Services;
import com.bornfire.xbrl.services.LoginServices;
import com.bornfire.xbrl.services.ProvisioningFileUploadService;
import com.bornfire.xbrl.services.RT_ACPR_SERVICE;
import com.bornfire.xbrl.services.RT_CCR_DATA_Service;
import com.bornfire.xbrl.services.RT_DataControlService;
import com.bornfire.xbrl.services.RT_FX_Position_Service;
import com.bornfire.xbrl.services.RT_ForeignCurrencyDepositService;
import com.bornfire.xbrl.services.RT_FxriskdataService;
import com.bornfire.xbrl.services.RT_IRSService;
import com.bornfire.xbrl.services.RT_ImpactAnalysisService;
import com.bornfire.xbrl.services.RT_InvestmentRiskDataDashboard_Service;
import com.bornfire.xbrl.services.RT_InvestmentSecurity_Service;
import com.bornfire.xbrl.services.RT_Irrbb_Discount_Rates_Service;
import com.bornfire.xbrl.services.RT_Irrbb_Ear_Service;
import com.bornfire.xbrl.services.RT_Irrbb_Eve_Service;
import com.bornfire.xbrl.services.RT_Liquidity_Risk_Data_Service;
import com.bornfire.xbrl.services.RT_LiquidityriskdashboardService;
import com.bornfire.xbrl.services.RT_MC_TABLE_ALL_Service;
import com.bornfire.xbrl.services.RT_MID_FX_DEAL_SERVICE;
import com.bornfire.xbrl.services.RT_MmdataService;
import com.bornfire.xbrl.services.RT_NostroAccBalDataService;
import com.bornfire.xbrl.services.RT_RepoService;
import com.bornfire.xbrl.services.RT_SLSServices;
import com.bornfire.xbrl.services.SlsSensReportService;
import com.bornfire.xbrl.services.IrsSensReportService;
import com.bornfire.xbrl.services.RtLiquidityReportService;
import com.bornfire.xbrl.dto.SlsSensScenarioDto;
import com.bornfire.xbrl.util.UploadMessageHelper;
import com.bornfire.xbrl.services.RT_SLS_BEHAVIOURAL_PER_SERVICES;
import com.bornfire.xbrl.services.RT_TradeLevelDerivativesService;
import com.bornfire.xbrl.services.RT_TradeLevelDerivativesSimplifiedService;
import com.bornfire.xbrl.services.RT_TradeMarketRiskService;
import com.bornfire.xbrl.services.RT_TreasuryCredit_Service;
import com.bornfire.xbrl.services.RtInvestmentDealDataDump_Service;
import com.bornfire.xbrl.services.RwaDataUploadService;
import com.bornfire.xbrl.services.UploadMonitorService;
import com.bornfire.xbrl.services.DaylightDataUploadService;
import com.bornfire.xbrl.services.ECLDataUploadService;
import com.bornfire.xbrl.services.OvernightForeignCcyUploadService;
import com.bornfire.xbrl.services.VarPortfolioUploadService;
import com.bornfire.xbrl.services.SMAFileUploadService;
import com.bornfire.xbrl.services.counter_services;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@ConfigurationProperties("default")
public class XBRLNavigationController {

	private static final Logger logger = LoggerFactory.getLogger(XBRLNavigationController.class);
	/*
	 * @PersistenceContext private EntityManager entityManager;
	 * 
	 */
	@Autowired
	Bloomberg_services bloombergService;
	
	@Autowired
	VarPortfolioUploadService varportfoliouploadservice;

	@Autowired
	DaylightDataUploadService daylightDataUploadService;

	@Autowired
	OvernightForeignCcyUploadService overnightForeignCcyUploadService;
	
	@Autowired
	ECLDataUploadService ecldatauploadservice;
	
	@Autowired
	RtVarReportLimits_Rep rtvarreportlimits_rep;
	@Autowired
	KriMasterTable_Rep krimastertablerep;
	
	@Autowired
	RtInvestmentRiskDataDetail_Rep rtinvestmentriskdatadetailrep;
	@Autowired
	RtInvestmentDealDataDump_Service rtinvestmentdealdatadump_service;
	
	@Autowired
	RtBloombergData_Rep rtBloombergdata_rep;

	@Autowired
	RT_IRRBB_Data_EVE_Template_Detail_Rep rt_irrbb_data_eve_template_detail_rep;
	@Autowired
	RT_SLSServices RT_SLSServices;
	
	@Autowired
	Limit_Request_Rep limit_request_rep;
	
	@Autowired
	RT_RWA_RATING_GUIDELINES_Rep rt_rwa_rating_guidelines_rep;

	@Autowired
	RT_IRSService rtIrsService;

	@Autowired
	RT_SLS_Detail_Repository rt_sls_detail_repository;

	@Autowired
	RT_SLS_Repository rt_sls_repository;

	@Autowired
	RT_SLS_SENS_Repository rt_sls_sens_repository;

	@Autowired
	SlsSensReportService slsSensReportService;

	@Autowired
	RT_IRS_SENS_Repository rt_irs_sens_repository;

	@Autowired
	RT_IRS_SENS2_REPOSITORY rt_irs_sens2_repository;

	@Autowired
	IrsSensReportService irsSensReportService;

	@Autowired
	RtLiquidityReportService rtLiquidityReportService;

	@Autowired
	AuditService auditService;
	@Autowired
	RT_Investment_Risk_Data_Dashboard_TemplateRepository RT_Investment_Risk_Data_Dashboard_TemplateRepositoryS;
	@Autowired
	UserProfileRep UserProfileReps;
	@Autowired
	private BRF40_Rep1 brf40aRepository;
	@Autowired
	MIS_TREASURY_LIMITS_ENTITY_REP MIS_TREASURY_LIMITS_ENTITY_REPs;
	@Autowired
	private BRF40_Rep2 brf40bRepository;
	@Autowired
	BRF095AServiceRepo BRF095AServiceRepos;
	@Autowired
	BankLimit_Rep banklimit_rep;

	@Autowired
	MIS_SETTLEMENT_ENTITY_REP MIS_SETTLEMENT_ENTITY_REPs;
	@Autowired
	private ASL_BANKMASTER_REPO ASL_BANKMASTER_REPO;
	@Autowired
	private BRF39_ENTITYREP brf39_entityrep;
	@Autowired
	Mis_treasury_placement_repo Mis_treasury_placement_repo;
	@Autowired
	ASL_Excel_Services ASL_Excel_Servicess;
	@Autowired
	ASL_Report_Rep ASL_Report_Reps;
	@Autowired
	Excel_Services Excel_Servicess;
	@Autowired
	Counterparty_Rep Counterparty_Reps;
	@Autowired
	counter_services counter_servicess;
	@Autowired
	LoginServices loginServices;
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	private RT_FxriskdataService fxriskdataService;

	@Autowired
	AccessAndRolesServices AccessRoleService;

	@Autowired
	AccessandRolesRepository accessandrolesrepository;

	@Autowired
	RT_NostroAccBalDataRepository nostroAccBalRepo;

	@Autowired
	RT_NostroAccBalDataService nostroService;

	@Autowired
	RT_DataControlService RT_DataControlService;

	@Autowired
	RT_DatacontrolRepository RT_DatacontrolRepository;

	@Autowired
	RT_FxRiskDataRepository friskdataRepo;

	@Autowired
	RT_BankNameMasterRepository bankRepo;

	@Autowired
	RT_CountryRiskDropdownRepo countryRepo;

	@Autowired
	RT_MmDataRepository mmdataRepo;

	@Autowired
	private RT_MmdataService mmdataService;

	@Autowired
	private BankingBookBillDataService bankingBookBillDataService;

	@Autowired
	private BankingBookBillDataRepo bankingBookBillDataRepo;

	@Autowired
	RT_RepoDataTemplateRepository repoRepo;

	@Autowired
	RT_TreasuryCreditRepo treasuryCreditRepo;

	@Autowired
	RT_RepoService repoService;

	@Autowired
	RT_TreasuryCredit_Service treasuryCreditService;
	@Autowired
	RT_InvestmentSecurity_Service investmentSecurity_Service;

	@Autowired
	RT_TradeLevelDataDerivativesRepository tradeleveldataderivativesRepo;

	@Autowired
	RT_TradeLevelDerivativesService tradeleveldataderivativeService;

	@Autowired
	RT_ForeignCurrencyDepositService foreigncurrencydepositService;

	@Autowired
	RT_ForeignCurrencyDepositRepository foreigncurrencydepositRepo;

	@Autowired
	RT_Investment_Securities_Data_Template_Repo investmentSecuritiesDataTemplateRepo;

	@Autowired
	private RT_ImpactAnalysisService impactanalysisService;

	@Autowired
	RT_Liquidity_Risk_Data_Service liquidityRiskDataService;

	@Autowired
	RT_Liquidity_Risk_Data_Template_Repository LiquidityRiskDataRepository;

	@Autowired
	RT_ImpactAnalysisRepository impactanalysisRepo;

	@Autowired
	RT_Liquidity_Risk_Dashboard_Template_repository LiquidityRiskDashboardRepo;

	@Autowired

	RT_TradeLevelDataDerivativesSimplifiedRepository tradeleveldataderivativessimplifiedRepo;

	@Autowired
	RT_TradeLevelDerivativesSimplifiedService tradeleveldataderivativesimplifiedService;

	@Autowired
	RT_InvestmentRiskDataDashboard_Service investmentriskdatadictionaryService;

	@Autowired
	RT_IRRBB_Data_EVE_Template_Repository IRRB_EVE_Repo;
	@Autowired
	RT_IRRBB_Data_EAR_Repository IRRBB_EAR_Repository;

	@Autowired
	RT_IRRBB_Data_Discount_Rates_Repository IRRBB_Data_Template_DiscountRate_repo;

	@Autowired
	RT_IRRBB_RECON_Repository rt_irrbb_recon_repository;

	@Autowired
	RT_LiquidityriskdashboardService liquidityriskdashboardService;

	@Autowired
	RT_Irrbb_Eve_Service irrbbeveService;

	@Autowired
	RT_Irrbb_Ear_Service irrbbearService;

	@Autowired
	RT_Irrbb_Discount_Rates_Service discountratesService;

	@Autowired
	RT_Matrix_monitoring_rep RT_Matrix_monitoring_rep;

	@Autowired
	RT_RWA_Fund_base_data_rep RT_RWA_Fund_base_data_rep;

	@Autowired
	Groupexp_cust_maintain_rep Groupexp_cust_maintain_rep;

	@Autowired
	Capitaladequacyratio_rep Capitaladequacyratio_rep;

	@Autowired
	RT_IRS_REPOSITORY RT_irs_repository;

	@Autowired
	RT_IRS2_REPOSITORY RT_IRS2_REPOSITORY;

	@Autowired
	RT_IRS_DETAIL_REPO RT_IRS_DETAIL_REPO;

	@Autowired
	MIS_COUNTER_PARTY_LIMIT_DETAILS_REPO misCounterPartyLimitDetailsRepo;
	
	@Autowired
	RT_MC_TABLE1_REPO RT_MC_TABLE1_REPO;
	@Autowired
	RT_MC_TABLE2_1_REPO RT_MC_TABLE2_1_REPO;
	@Autowired
	RT_MC_TABLE2_2_REPO RT_MC_TABLE2_2_REPO;
	@Autowired
	RT_MC_TABLE3_REPO RT_MC_TABLE3_REPO;
	@Autowired
	RT_MC_TABLE4_1_REPO RT_MC_TABLE4_1_REPO;
	@Autowired
	RT_MC_TABLE4_2_REPO RT_MC_TABLE4_2_REPO;	
	@Autowired
	RT_MC_TABLE5_REPO RT_MC_TABLE5_REPO;
	@Autowired
	RT_MC_TABLE6_REPO RT_MC_TABLE6_REPO;	
	@Autowired
	RT_MC_TABLE7_1_REPO RT_MC_TABLE7_1_REPO;
	@Autowired
	RT_MC_TABLE7_2_REPO RT_MC_TABLE7_2_REPO;
	@Autowired
	RT_MC_TABLE8_REPO RT_MC_TABLE8_REPO;
	@Autowired
	RT_MC_TABLE9_REPO RT_MC_TABLE9_REPO;
	@Autowired
	RT_MC_TABLE_ALL_Service rT_MC_TABLE_Service;
	
	@Autowired
	SMAFileUploadService SMAFileUploadService;

	@Autowired
	ProvisioningFileUploadService ProvisioningFileUploadService;
	
	@Autowired
	private UploadMonitorService uploadMonitorService;
	
	@Autowired
	RT_MC_DATA_RECORD_REPO rT_MC_DATA_RECORD_REPO;
	
	@Autowired
	RT_Report_Master_Repo Rpt_Master_Repo;

	@Autowired
	Eod_Acct_Bal_Excep_Table_Repo eodAcctBalExcepTableRepo;
	
	@Autowired
	RT_MC_Description_Repo RT_MC_Description_Repo;
	
	private String pagesize;

	public String getPagesize() {
		return pagesize;
	}

	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}

	@RequestMapping(value = "MenuLanding", method = { RequestMethod.GET, RequestMethod.POST })
	public String menuLanding(HttpServletRequest req) {
		Boolean otpPending = (Boolean) req.getSession().getAttribute("LOGIN_OTP_PENDING");
		Boolean otpVerified = (Boolean) req.getSession().getAttribute("LOGIN_OTP_VERIFIED");
		if (Boolean.TRUE.equals(otpPending) || !Boolean.TRUE.equals(otpVerified)) {
			return "redirect:/login-otp";
		}
		return "XBRLMenuLanding";
	}

	@RequestMapping(value = "Dashboard", method = { RequestMethod.GET, RequestMethod.POST })
	public String dashboard(Model md, HttpServletRequest req) {
		Boolean otpPending = (Boolean) req.getSession().getAttribute("LOGIN_OTP_PENDING");
		Boolean otpVerified = (Boolean) req.getSession().getAttribute("LOGIN_OTP_VERIFIED");
		if (Boolean.TRUE.equals(otpPending) || !Boolean.TRUE.equals(otpVerified)) {
			return "redirect:/login-otp";
		}

		String domainid = (String) req.getSession().getAttribute("DOMAINID");
		String userid = (String) req.getSession().getAttribute("USERID");
		String ROLEID = (String) req.getSession().getAttribute("ROLEID");
		String BRANCH_NAME = (String) req.getSession().getAttribute("BRANCHNAME");

		LocalDate today = LocalDate.now(); // Get today's date
		Date Todaydate = java.sql.Date.valueOf(today.minusDays(0));

		md.addAttribute("changepassword", loginServices.checkPasswordChangeReq(userid));
		md.addAttribute("checkpassExpiry", loginServices.checkpassexpirty(userid));
		md.addAttribute("checkAcctExpiry", loginServices.checkAcctexpirty(userid));
		int completed = 0;
		int uncompleted = 0;

		// Retrive Current date Matrix data
		List<RT_Matrix_monitoring_entity> Matrixdata = RT_Matrix_monitoring_rep.Getcurrentdatematrixcal();

		md.addAttribute("completed", completed);
		md.addAttribute("uncompleted", uncompleted);
		md.addAttribute("Matrixlistdata", Matrixdata);
		md.addAttribute("menu", "Dashboard");
		md.addAttribute("CurrentYear_Tier_1_capital", Capitaladequacyratio_rep.GetCurrentyear_tier_1_capital());
		return "XBRLDashboard";
	}

	@RequestMapping(value = "matrix-analytics", method = { RequestMethod.GET, RequestMethod.POST })
	public String matrixAnalytics(@RequestParam("sno") String sno,
			@RequestParam("reportDate") String reportDate,
			@RequestParam("label") String label,
			HttpServletRequest req) {
		Boolean otpPending = (Boolean) req.getSession().getAttribute("LOGIN_OTP_PENDING");
		Boolean otpVerified = (Boolean) req.getSession().getAttribute("LOGIN_OTP_VERIFIED");
		if (Boolean.TRUE.equals(otpPending) || !Boolean.TRUE.equals(otpVerified)) {
			return "redirect:/login-otp";
		}

		return "redirect:Dashboard?sno=" + encodeQueryParam(sno)
				+ "&reportDate=" + encodeQueryParam(reportDate)
				+ "&label=" + encodeQueryParam(label);
	}

	private static String encodeQueryParam(String value) {
		try {
			return URLEncoder.encode(value != null ? value : "", StandardCharsets.UTF_8.name());
		} catch (UnsupportedEncodingException e) {
			return value != null ? value : "";
		}
	}

	@RequestMapping(value = "AccessandRoles", method = { RequestMethod.GET, RequestMethod.POST })
	public String IPSAccessandRoles(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String userid, @RequestParam(required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size, Model md, HttpServletRequest req) {

		String roleId = (String) req.getSession().getAttribute("ROLEID");
		// System.out.println("role id is : " + roleId);
		md.addAttribute("IPSRoleMenu", AccessRoleService.getRoleMenu(roleId));

		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("menu", "ACCESS AND ROLES");
			md.addAttribute("menuname", "ACCESS AND ROLES");
			md.addAttribute("formmode", "list");
			md.addAttribute("AccessandRoles", accessandrolesrepository.rulelist());

		}/* else if (formmode.equals("add")) {

		} *//*
			 * else if (formmode.equals("add")) { md.addAttribute("menuname",
			 * "ACCESS AND ROLES - ADD"); md.addAttribute("formmode", "add"); }
			 */
		else if (formmode.equals("add")) {

		    md.addAttribute("menuname", "ACCESS AND ROLES - ADD");
		    md.addAttribute("formmode", "add");

		    // Create a new empty AccessAndRoles object
		    AccessAndRoles newRole = new AccessAndRoles();
		    md.addAttribute("IPSAccessRole", newRole);
		}else if (formmode.equals("edit")) {
			md.addAttribute("menuname", "ACCESS AND ROLES - EDIT");
			md.addAttribute("formmode", formmode);
			md.addAttribute("IPSAccessRole", AccessRoleService.getRoleId(userid));
		} else if (formmode.equals("view")) {
			md.addAttribute("menuname", "ACCESS AND ROLES - INQUIRY");
			md.addAttribute("formmode", formmode);
			md.addAttribute("IPSAccessRole", AccessRoleService.getRoleId(userid));

		} else if (formmode.equals("verify")) {
			md.addAttribute("menuname", "ACCESS AND ROLES - VERIFY");
			md.addAttribute("formmode", formmode);
			md.addAttribute("IPSAccessRole", AccessRoleService.getRoleId(userid));

		} else if (formmode.equals("delete")) {
			md.addAttribute("menuname", "ACCESS AND ROLES - DELETE");
			md.addAttribute("formmode", formmode);
			md.addAttribute("IPSAccessRole", AccessRoleService.getRoleId(userid));
		}

		md.addAttribute("adminflag", "adminflag");
		md.addAttribute("userprofileflag", "userprofileflag");

		return "AccessandRoles";
	}
	
	
	@RequestMapping(value = "BloombergData", method = { RequestMethod.GET, RequestMethod.POST })
	public String BloombergData(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String userid, @RequestParam(required = false) String isin,
			 Model md, HttpServletRequest req) {

		String roleId = (String) req.getSession().getAttribute("ROLEID");
		// System.out.println("role id is : " + roleId);
		md.addAttribute("roleId", roleId);

		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("menu", "Bloomberg Data");
			md.addAttribute("menuname", "Bloomberg Data");
			md.addAttribute("formmode", "list");
			md.addAttribute("BloombergDatalist", rtBloombergdata_rep.getrtbloombergdatalist());
			

		} else if (formmode.equals("add")) {
			md.addAttribute("menu", "Bloomberg Data");
			md.addAttribute("menuname", "Bloomberg Data");
			md.addAttribute("formmode", "add");
			md.addAttribute("BloombergData", new RtBloombergData());
		}
		
		else if (formmode.equals("edit")) {
			md.addAttribute("menu", "Bloomberg Data");
			md.addAttribute("menuname", "Bloomberg Data");
			md.addAttribute("formmode", "edit");
			md.addAttribute("BloombergData",rtBloombergdata_rep.getrtbloombergdatabyisin(isin));
		}
		

		return "BloombergData";
	}
	
	@PostMapping("/saveBloomberg")
	@ResponseBody
	public String saveBloomberg(
	        @ModelAttribute RtBloombergData data,
	        @RequestParam("formmode") String formmode,
	        HttpServletRequest rq) {

	    String userid = (String) rq.getSession().getAttribute("USERID");

	    if (userid == null) {
	        return "Session Expired. Please login again.";
	    }

	    String msg = bloombergService.addData(data, formmode, userid);

	    System.out.println("msg=" + msg);

	    return msg;
	}
	
	

	@RequestMapping(value = "createAccessRole", method = RequestMethod.POST)
	@ResponseBody
	public String createAccessRoleEn(@RequestParam("formmode") String formmode,
			@RequestParam(value = "adminValue", required = false) String adminValue,
			@RequestParam(value = "RT_ReportsValue", required = false) String RT_ReportsValue,
			@RequestParam(value = "aslValue", required = false) String aslValue,
			@RequestParam(value = "aslUploadValue", required = false) String aslUploadValue,
			@RequestParam(value = "auditUsValue", required = false) String auditUsValue,
			@RequestParam(value = "finalString", required = false) String finalString,
			@ModelAttribute AccessAndRoles alertparam, Model md, HttpServletRequest rq) {

		String userid = (String) rq.getSession().getAttribute("USERID");
		String roleId = (String) rq.getSession().getAttribute("ROLEID");
		md.addAttribute("IPSRoleMenu", AccessRoleService.getRoleMenu(roleId));

		String msg = AccessRoleService.addPARAMETER(alertparam, formmode, adminValue, RT_ReportsValue, aslValue,
				aslUploadValue, auditUsValue, finalString, userid);

		return msg;
	}

	@PostMapping("verifyRole")
	@ResponseBody
	public String verifyRole(@RequestParam("roleId") String roleId, HttpServletRequest rq) {
		String userId = (String) rq.getSession().getAttribute("USERID");

		Optional<AccessAndRoles> optionalRole = accessandrolesrepository.findById(roleId);

		if (!optionalRole.isPresent()) {
			return "Role not found. Cannot verify.";
		}

		AccessAndRoles role = optionalRole.get();

		if ("Y".equalsIgnoreCase(role.getEntityFlg())) {
			return "Role already verified.";
		}

		role.setEntityFlg("Y");
		role.setAuthUser(userId);
		role.setAuthTime(new Date());

		accessandrolesrepository.save(role);

		return "Role verified successfully.";
	}

	@GetMapping("/checkRoleExists")
	@ResponseBody
	public String checkRoleExists(@RequestParam("roleId") String roleId) {
		boolean exists = accessandrolesrepository.findById(roleId).isPresent();
		return exists ? "exists" : "not_exists";
	}

	@RequestMapping(value = "UserProfile", method = { RequestMethod.GET, RequestMethod.POST })
	public String userprofile(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String userid, Model md, HttpServletRequest req) {

		String loginuserid = (String) req.getSession().getAttribute("USERID");
		String WORKCLASSAC = (String) req.getSession().getAttribute("WORKCLASS");
		String ROLEIDAC = (String) req.getSession().getAttribute("ROLEID");

		// Always provide these for dropdowns/logic
		md.addAttribute("RuleIDType", accessandrolesrepository.roleidtype());
		md.addAttribute("WORKCLASSAC", WORKCLASSAC);
		md.addAttribute("ROLEIDAC", ROLEIDAC);
		md.addAttribute("loginuserid", loginuserid);

		List<String> dropdownOptions = Arrays.asList("IT", "Risk", "HR", "Operations","CFO","CED","Digital","FRM","Retail-CASA","ISO","Retail/SME","Recovery","Marketing","IA","Compliance");
		md.addAttribute("md", dropdownOptions);
		
		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("formmode", "list");
			md.addAttribute("userProfiles", loginServices.getUsersList());
		} else {
			md.addAttribute("formmode", formmode);
			UserProfile user;
			if (formmode.equals("add")) {
				user = new UserProfile();
				user.setLogin_low("00:00");
				user.setLogin_high("23:59");
			} else {
				user = loginServices.getUser(userid);
			}
			md.addAttribute("userProfile", user);
		}
		return "XBRLUserprofile";
	}

	@RequestMapping(value = "verifyUser", method = RequestMethod.POST)
	@ResponseBody
	public String verifyUser(@ModelAttribute UserProfile userprofile, Model md, HttpServletRequest rq) {
		String userid = (String) rq.getSession().getAttribute("USERID");
		String msg = loginServices.verifyUser(userprofile, userid);

		return msg;

	}

	@GetMapping("/getRoleDetails")
	@ResponseBody
	public AccessAndRoles getRoleDetails(@RequestParam String roleId) {
		// System.out.println("role id for fetching is : " + roleId);
		AccessAndRoles access = accessandrolesrepository.findById(roleId).orElse(null);

		/*
		 * if (access != null) { System.out.println("roleDesc = " +
		 * access.getRoleDesc()); // <== ADD THIS System.out.println("workClass = " +
		 * access.getWorkClass()); // <== ADD THIS System.out.println("permission = " +
		 * access.getPermissions()); // <== ADD THIS System.out.println("module = " +
		 * access.getDomainId()); // <== ADD THIS }
		 */

		return access;
	}

	@RequestMapping(value = "createUser", method = RequestMethod.POST)
	@ResponseBody
	public String createUser(@RequestParam("formmode") String formmode, @ModelAttribute UserProfile userprofile,
			Model md, HttpServletRequest rq) {

		String mob = (String) rq.getSession().getAttribute("MOBILENUMBER");
		String role = (String) rq.getSession().getAttribute("ROLEDESC");
		String userId = (String) rq.getSession().getAttribute("USERID");
		String userName = (String) rq.getSession().getAttribute("USERNAME");
		String msg = loginServices.addUser(userprofile, formmode, userId, userName, mob, role);

		return msg;
	}

	@RequestMapping(value = "deleteuser", method = RequestMethod.POST)
	@ResponseBody
	public String deleteuser(@RequestParam("formmode") String userid, Model md, HttpServletRequest rq) {

		String msg = loginServices.deleteuser(userid);

		return msg;

	}

	// In Reports
	// In Modify section If we select the Bank name other details are fetching code
	@RequestMapping(value = "getBankDetails", method = RequestMethod.GET)
	public ResponseEntity<Map<String, String>> getBankDetails(@RequestParam String bankName) {

		RT_BankNameMaster bank = bankRepo.findByBankName(bankName);
		if (bank == null) {
			return ResponseEntity.notFound().build();
		}

		Map<String, String> bankDetails = new HashMap<>();
		bankDetails.put("bankSymbol", bank.getBankSymbol());
		bankDetails.put("conventionalIslamic", bank.getConventionalIslamic());
		bankDetails.put("localForeign", bank.getLocalForeign());
		bankDetails.put("cbuaeTiering", bank.getCbuaeTiering());

		return ResponseEntity.ok(bankDetails);
	}

	// In Modify section If we select the Country of Risk, cbuaeGeographicalZone
	// fetching code
	@RequestMapping(value = "getCountryDetails", method = RequestMethod.GET)
	public ResponseEntity<Map<String, String>> getCountryDetails(@RequestParam String countryName) {
		RT_CountryRiskDropdown country = countryRepo.findByCountryOfRisk(countryName);
		System.out.println("Fetched country details for: " + countryName);

		if (country == null) {
			return ResponseEntity.notFound().build();
		}

		Map<String, String> response = new HashMap<>();
		response.put("cbuaeGeographicalZone", country.getCbuaeGeographicalZone());

		return ResponseEntity.ok(response);
	}

	// Creating Data Control
	@PostMapping("/createDataControl")
	@ResponseBody
	public String createDataControl(
			@RequestParam(name = "formmode", required = false, defaultValue = "add") String formmode,
			@RequestParam(name = "report_name", required = false, defaultValue = "add") String report_name,
			@ModelAttribute RT_DataControl dto, HttpServletRequest req) {
		System.out.println("Controller: createOrUpdateNostro() called");
		System.out.println("report name is: " + report_name);

		String userid = (String) req.getSession().getAttribute("USERID");
		//auditService.createBusinessAudit(userid, "ADD", "DATACONTROL", null, "BCBUAE_DATACONTROL");  -- call in service

		return RT_DataControlService.createOrUpdate(dto, formmode, report_name,userid);
	}

	// Nostro Report Codes Given Below
	@RequestMapping(value = "Nostro_Account_Bal", method = RequestMethod.GET)
	public String NostroAccountBal(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String accountNo, Model md, HttpServletRequest req,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		       

		   LocalDate today = LocalDate.now();
		   String formattedDate = null;
		   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		   
		   // ✅ Convert Report_date → String safely
		   if (Report_date != null) {
		       formattedDate = sdf.format(Report_date);
		   }

		if ("edit".equalsIgnoreCase(formmode) && accountNo != null && !accountNo.isEmpty()) {
			RT_NostroAccBalData data = nostroAccBalRepo.getbyAcctNoReportDate(Report_date,accountNo);
			md.addAttribute("nostroData", data);
			System.out.println("edit is formmode");
			md.addAttribute("lastDate",LocalDate.parse(formattedDate, formatter) );
			md.addAttribute("formmode", "edit");
		} else if ("list".equalsIgnoreCase(formmode)) {
			if (Report_date == null) {
			    md.addAttribute("branchList", Collections.emptyList());
			} else {
			    List<RT_NostroAccBalData> list = nostroAccBalRepo.getlist(Report_date);
			    md.addAttribute("branchList", list != null ? list : Collections.emptyList());
			}
			System.out.println("list is formmode");
			md.addAttribute("formmode", "list");
			if (formattedDate != null && !formattedDate.trim().isEmpty()) {
			    md.addAttribute("lastDate", LocalDate.parse(formattedDate, formatter));
			} else {
			    LocalDate endDateFallback = null; 
			    md.addAttribute("lastDate", endDateFallback);
			}
		} else {
			Timestamp lastdatetimestamp = nostroAccBalRepo.findLastReportDate();
			Timestamp secondlastdatetimestamp = nostroAccBalRepo.findSecondLastReportDate();
			 String lastDateString = null;
		     String secondLastDateString = null;
		     LocalDate lastDate = null;
					
			
			if (lastdatetimestamp != null) {
	            lastDate = lastdatetimestamp.toLocalDateTime().toLocalDate();
	            lastDateString = lastdatetimestamp.toLocalDateTime().format(formatter);
	        }

	        if (secondlastdatetimestamp != null) {
	            secondLastDateString = secondlastdatetimestamp.toLocalDateTime().format(formatter);
	        }
			RT_DataControl data= RT_DatacontrolRepository.getdata(lastDateString,"CBUAE_Nostro Account_Balance_Data_Template");
			RT_DataControl secondlastdata= RT_DatacontrolRepository.getdata(secondLastDateString,"CBUAE_Nostro Account_Balance_Data_Template");
			RT_DataControl report_datedata = null;
			
			 if (formattedDate != null) {
		            report_datedata = RT_DatacontrolRepository.getdata(formattedDate, "CBUAE_Nostro Account_Balance_Data_Template");
		        }
		        
		        System.out.println(formattedDate);

		        // ✅ FIXED NULL CHECKS
		        if (report_datedata != null) {
		        	System.out.println(formattedDate);
		        	lastDate = LocalDate.parse(formattedDate, formatter);
		            md.addAttribute("data", report_datedata);
		            md.addAttribute("formmode", "exist");
		        }
			
			else if(data != null && !data.equals(null)) {
				md.addAttribute("data", data);
				md.addAttribute("formmode", "exist");
			}
			else if(secondlastdata != null && !secondlastdata.equals(null)){
				md.addAttribute("data", secondlastdata);
				md.addAttribute("formmode", "exist");
			}else {
				md.addAttribute("formmode", "add");
				md.addAttribute("formmode", "null");
			}
			md.addAttribute("lastDate", lastDate);
			md.addAttribute("bankname", "Bank of Baroda");
			
		}

		List<RT_BankNameMaster> bankList = bankRepo.findAllByOrderByBankNameAsc();
		List<RT_CountryRiskDropdown> countryList = countryRepo.findAllByOrderByCountryOfRiskAsc();

		md.addAttribute("bankList", bankList);
		md.addAttribute("countryList", countryList);

		return "RT/Nostro_Account_Bal";
	}

	// Update Submit code in nostro
	@RequestMapping("/updateNostro")
	@ResponseBody
	public String updateNostro(@ModelAttribute RT_NostroAccBalData nostroData, HttpServletRequest req) {

		boolean updated = nostroService.updateNostro(nostroData);
		System.out.println("msg is : " + updated);

		if (updated) {
			System.out.println("Update successful");
			return "Updated successfully";
		} else {
			System.out.println("Update Record not found for update");
			return "Record not found for update";
		}

	}

//-------------------------------------Repo Report Start---------------------------------------
// Repo Report code
	@RequestMapping(value = "Repo_Data_Template", method = RequestMethod.GET)
	public String RepoDataTemplate(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) Long slNo, // changed from accountNo to slNo
			Model md, HttpServletRequest req,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		

			    LocalDate today = LocalDate.now();
			    String formattedDate = null;
			    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			   
			    if (Report_date != null) {
			        formattedDate = sdf.format(Report_date);
			    }

		if ("edit".equalsIgnoreCase(formmode) && slNo != null) {
			RT_RepoDataTemplate data = repoRepo.findById(slNo).orElse(null); // make sure entity class matches
			md.addAttribute("repoData", data);
			System.out.println("edit is formmode");
			md.addAttribute("formmode", "edit");
			md.addAttribute("lastDate", LocalDate.parse(sdf.format(data.getReportDate()), formatter));
		} else if ("list".equalsIgnoreCase(formmode)) {
//			md.addAttribute("repoList", repoRepo.getlist(Report_date));
//			System.out.println("list is formmode");
//			md.addAttribute("formmode", "list");
//			md.addAttribute("lastDate",LocalDate.parse(formattedDate, formatter) );
//			
			if (Report_date == null) {
			    md.addAttribute("repoList", Collections.emptyList());
			} else {
			    List<RT_RepoDataTemplate> list = repoRepo.getlist(Report_date);
			    md.addAttribute("repoList", list != null ? list : Collections.emptyList());
			}
			System.out.println("list is formmode");
			md.addAttribute("formmode", "list");
			if (formattedDate != null && !formattedDate.trim().isEmpty()) {
			    md.addAttribute("lastDate", LocalDate.parse(formattedDate, formatter));
			} else {
			    LocalDate endDateFallback = null; 
			    md.addAttribute("lastDate", endDateFallback);
			}
			
		} else {
			Timestamp lastdatetimestamp = repoRepo.findLastReportDate();
			Timestamp secondlastdatetimestamp = repoRepo.findSecondLastReportDate();	
			
			  	String lastDateString = null;
		        String secondLastDateString = null;
		        LocalDate lastDate = null;

		        if (lastdatetimestamp != null) {
		            lastDate = lastdatetimestamp.toLocalDateTime().toLocalDate();
		            lastDateString = lastdatetimestamp.toLocalDateTime().format(formatter);
		        }

		        if (secondlastdatetimestamp != null) {
		            secondLastDateString = secondlastdatetimestamp.toLocalDateTime().format(formatter);
		        }
		        
			RT_DataControl data= RT_DatacontrolRepository.getdata(lastDateString,"CBUAE_Repo_Data_Template");
			RT_DataControl secondlastdata= RT_DatacontrolRepository.getdata(secondLastDateString,"CBUAE_Repo_Data_Template");
			
			 RT_DataControl report_datedata = null;

		        if (formattedDate != null) {
		            report_datedata = RT_DatacontrolRepository.getdata(formattedDate, "CBUAE_Repo_Data_Template");
		        }
		        
		       

		     
	        if (report_datedata != null) {
	        	System.out.println(formattedDate);
	        	lastDate = LocalDate.parse(formattedDate, formatter);
	            md.addAttribute("data", report_datedata);
	            md.addAttribute("formmode", "exist");

	        }
			else if (data != null && !data.equals(null)) {
				md.addAttribute("data", data);
				md.addAttribute("formmode", "exist");
			}
			else if(secondlastdata != null && !secondlastdata.equals(null)){
				md.addAttribute("data", secondlastdata);
				md.addAttribute("formmode", "exist");
			}else {
				md.addAttribute("formmode", "add");
				md.addAttribute("formmode", "null");
			}
			md.addAttribute("lastDate", lastDate);
			md.addAttribute("bankname", "Bank of Baroda");
		}

		List<RT_BankNameMaster> bankList = bankRepo.findAllByOrderByBankNameAsc();
		List<RT_CountryRiskDropdown> countryList = countryRepo.findAllByOrderByCountryOfRiskAsc();

		md.addAttribute("bankList", bankList);
		md.addAttribute("countryList", countryList);

		return "RT/Repo_Data_Template";
	}

//Updated data saving code for Repo
	@RequestMapping("/updateRepo")
	@ResponseBody
	public String updateRepo(@ModelAttribute RT_RepoDataTemplate repoData, HttpServletRequest request) {

		// Call the update logic from service or directly use the repository if simple
		boolean updated = repoService.updateRepoData(repoData);

		if (updated) {
			System.out.println("Update successful for SL_NO: " + repoData.getSlNo());
			return "Updated successfully";
		} else {
			System.out.println("Record not found for update for SL_NO: " + repoData.getSlNo());
			return "Record not found for update";
		}
	}

//Downloading Excel for Repo
	@RequestMapping(value = "downloadRepoExcel", method = RequestMethod.GET)
	public ResponseEntity<byte[]> downloadRepoExcel(HttpServletRequest req,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) throws IOException {
		System.out.println("Entered controller downloadRepoExcel");

		File excelFile = repoService.generateRepoExcel(Report_date);
		byte[] excelData = java.nio.file.Files.readAllBytes(excelFile.toPath());

		HttpHeaders headersResponse = new HttpHeaders();
		headersResponse.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headersResponse.setContentDispositionFormData("attachment", "CBUAE_Repo_Data_Template.xls");
		

		String userid = (String) req.getSession().getAttribute("USERID");

		auditService.createBusinessAudit(userid, "DOWNLOAD", "REPO_DATA_TEMPLATE_EXCEL", null, "BCBUAE_REPO_DATA_TEMPLATE");


		return ResponseEntity.ok().headers(headersResponse).body(excelData);
	}

//-------------------------------------Repo Report End---------------------------------------

	// -------------------------------------Treasury_Credit_Limit_Management---------------------------------------

	@RequestMapping(value = "Treasury_Credit_Limit_Management", method = RequestMethod.GET)
	public String TreasuryCredit(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) Integer slNo, Model model,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {

		LocalDate today = LocalDate.now();
	    String formattedDate = null;
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    
	    if (Report_date != null) {
	        formattedDate = sdf.format(Report_date);
	    }

	        
		if ("edit".equalsIgnoreCase(formmode) && slNo != null) {
			model.addAttribute("formmode", "edit");
			model.addAttribute("creditData", treasuryCreditRepo.findById(slNo).orElse(new RT_TreasuryCreditEntity()));
			model.addAttribute("lastDate",LocalDate.parse(sdf.format(treasuryCreditRepo.findById(slNo).orElse(new RT_TreasuryCreditEntity()).getReportDate()), formatter) );
		} else if ("list".equalsIgnoreCase(formmode)) {
//			model.addAttribute("formmode", "list");
//			model.addAttribute("TClist", treasuryCreditRepo.getTClist(Report_date));
//			model.addAttribute("lastDate",LocalDate.parse(formattedDate, formatter) );
//			
			
			if (Report_date == null) {
				model.addAttribute("TClist", Collections.emptyList());
			} else {
			    List<RT_TreasuryCreditEntity> list = treasuryCreditRepo.getTClist(Report_date);
			    model.addAttribute("TClist", list != null ? list : Collections.emptyList());
			}
			System.out.println("list is formmode");
			model.addAttribute("formmode", "list");
			if (formattedDate != null && !formattedDate.trim().isEmpty()) {
				model.addAttribute("lastDate", LocalDate.parse(formattedDate, formatter));
			} else {
			    LocalDate endDateFallback = null; 
			    model.addAttribute("lastDate", endDateFallback);
			}
			
		} else {
			Timestamp lastdatetimestamp = treasuryCreditRepo.findLastReportDate();
			Timestamp secondlastdatetimestamp = treasuryCreditRepo.findSecondLastReportDate();	
			String lastDateString = null;
		    String secondLastDateString = null;
		    LocalDate lastDate = null;
		    
		    if (lastdatetimestamp != null) {
	            lastDate = lastdatetimestamp.toLocalDateTime().toLocalDate();
	            lastDateString = lastdatetimestamp.toLocalDateTime().format(formatter);
	        }

	        if (secondlastdatetimestamp != null) {
	            secondLastDateString = secondlastdatetimestamp.toLocalDateTime().format(formatter);
	        }

		    
			RT_DataControl data= RT_DatacontrolRepository.getdata(lastDateString,"CBUAE_Treasury_Credit_Limit_Management_Data_Template");
			RT_DataControl secondlastdata= RT_DatacontrolRepository.getdata(secondLastDateString,"CBUAE_Treasury_Credit_Limit_Management_Data_Template");
			
			RT_DataControl report_datedata = null;

			if (formattedDate != null) {
	            report_datedata = RT_DatacontrolRepository.getdata(formattedDate, "CBUAE_Treasury_Credit_Limit_Management_Data_Template");
	        }
	        
	        System.out.println(formattedDate);

	  
	        if (report_datedata != null) {
	        	System.out.println(formattedDate);
	        	lastDate = LocalDate.parse(formattedDate, formatter);
	        	model.addAttribute("data", report_datedata);
	        	model.addAttribute("formmode", "exist");
	        }
			
			else if (data != null && !data.equals(null)) {
				model.addAttribute("data", data);
				model.addAttribute("formmode", "exist");
			}
			else if(secondlastdata != null && !secondlastdata.equals(null)){
				model.addAttribute("data", secondlastdata);
				model.addAttribute("formmode", "exist");
			}else {
				model.addAttribute("formmode", "add");
				model.addAttribute("formmode", "null");
			}
			model.addAttribute("lastDate", lastDate);
			model.addAttribute("bankname", "Bank of Baroda");
		}

		List<RT_BankNameMaster> bankList = bankRepo.findAllByOrderByBankNameAsc();
		List<RT_CountryRiskDropdown> countryList = countryRepo.findAllByOrderByCountryOfRiskAsc();
		model.addAttribute("bankList", bankList);
		model.addAttribute("countryList", countryList);

		return "RT/Treasury_Credit.html";
	}

	@PostMapping("/updateTreasuryCredit")
	@ResponseBody
	public String updateTreasuryCredit(@ModelAttribute("creditData") RT_TreasuryCreditEntity creditData,
			RedirectAttributes redirectAttributes) {

		boolean updated = treasuryCreditService.updateTreasuryCredit(creditData);

		/*
		 * if (updated) { redirectAttributes.addFlashAttribute("updateMsg",
		 * "Updated Successfully"); } else {
		 * redirectAttributes.addFlashAttribute("updateMsg",
		 * "Record not found for update"); }
		 * 
		 * return "redirect:/Treasury_Credit_Limit_Management?formmode=list";
		 */

		if (updated) {
			return "Updated successfully";
		} else {
			return "Record not found for update";
		}
	}

	@RequestMapping(value = "/downloadTreasuryCreditExcel", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> downloadTreasuryCreditExcel(HttpServletRequest req,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		logger.info("Controller: Received request for Treasury credit Excel download.");

		try {
			byte[] excelData = treasuryCreditService.generateTreasuryExcel(Report_date);

			if (excelData.length == 0) {
				logger.warn("Controller: Service returned no data. Responding with 204 No Content.");
				return ResponseEntity.noContent().build();
			}

			ByteArrayResource resource = new ByteArrayResource(excelData);

			HttpHeaders headers = new HttpHeaders();
			String filename = "CBUAE_Treasury_Credit_Limit_Management_Data_Template.xlsx";
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

			logger.info("Controller: Sending file '{}' to client ({} bytes).", filename, excelData.length);
			
			String userid = (String) req.getSession().getAttribute("USERID");

			auditService.createBusinessAudit(userid, "DOWNLOAD", "TREASURY_CREDIT_LIMIT_MANAGEMENT_EXCEL", null, "BCBUAE_TREASURY_CRE_LMT_MANAGEMENT");
			
			return ResponseEntity.ok().headers(headers).contentLength(excelData.length)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(resource);

		} catch (FileNotFoundException e) {
			logger.error("Controller ERROR: A required template file was not found.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (Exception e) {
			logger.error("Controller ERROR: A critical error occurred during file generation.", e);

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	// -------------------------------------Treasury_Credit_Limit_Management
	// End---------------------------------------

	// -------------------------------------Investent_Securities_Data
	// START---------------------------------------

	/*
	 * @RequestMapping(value = "Investment_Securities_Data", method =
	 * RequestMethod.GET) public String TreasuryCredit(@RequestParam(required =
	 * false) BigDecimal siNo,String formmode,
	 * 
	 * @RequestParam(required = false) Model model) {
	 * 
	 * if ("edit".equalsIgnoreCase(formmode) && siNo != null) {
	 * model.addAttribute("formmode", "edit"); model.addAttribute("creditData",
	 * treasuryCreditRepo.findById(siNo).orElse(new RT_TreasuryCreditEntity())); }
	 * else if ("list".equalsIgnoreCase(formmode)) { model.addAttribute("formmode",
	 * "list"); model.addAttribute("TClist", treasuryCreditRepo.getTClist()); } else
	 * { model.addAttribute("formmode", "add"); }
	 * 
	 * return "RT/InvestmentSecurityData.html";
	 */

	@RequestMapping(value = "Investment_Securities_Data", method = RequestMethod.GET)
	public String treasuryCredit(@RequestParam(required = false) String siNo,
			@RequestParam(required = false) String formmode, Model model,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {

		LocalDate today = LocalDate.now();
		   String formattedDate = null;
		   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		   
		   // ✅ Convert Report_date → String safely
		   if (Report_date != null) {
		       formattedDate = sdf.format(Report_date);
		   }
		   
		if ("edit".equalsIgnoreCase(formmode) && siNo != null) {
			model.addAttribute("formmode", "edit");
			model.addAttribute("InvestmentData", investmentSecuritiesDataTemplateRepo.findById(siNo));
			model.addAttribute("lastDate",LocalDate.parse(sdf.format(investmentSecuritiesDataTemplateRepo.findById(siNo).get().getReportDate()), formatter) );
		} else if ("list".equalsIgnoreCase(formmode)) {
//			List<RT_Investment_Securities_Data_Template> list = investmentSecuritiesDataTemplateRepo.getsecDatalist(Report_date);
//
//			model.addAttribute("formmode", "list");
//			model.addAttribute("ISList", list); // Used in HTML table
//			model.addAttribute("lastDate",LocalDate.parse(formattedDate, formatter) );
			
			if (Report_date == null) {
				model.addAttribute("ISList", Collections.emptyList());
			} else {
			    List<RT_Investment_Securities_Data_Template> list = investmentSecuritiesDataTemplateRepo.getsecDatalist(Report_date);
			    model.addAttribute("ISList", list != null ? list : Collections.emptyList());
			}
			System.out.println("list is formmode");
			model.addAttribute("formmode", "list");
			if (formattedDate != null && !formattedDate.trim().isEmpty()) {
				model.addAttribute("lastDate", LocalDate.parse(formattedDate, formatter));
			} else {
			    LocalDate endDateFallback = null; 
			    model.addAttribute("lastDate", endDateFallback);
			}
			
			
		} /*
			 * else { model.addAttribute("formmode", "add");
			 * model.addAttribute("securityData", new
			 * RT_Investment_Securities_Data_Template()); }
			 */else {
				 Timestamp lastdatetimestamp = investmentSecuritiesDataTemplateRepo.findLastReportDate();
				 Timestamp secondlastdatetimestamp = nostroAccBalRepo.findSecondLastReportDate();
				 String lastDateString = null;
			     String secondLastDateString = null;
			     LocalDate lastDate = null;
						
				
				if (lastdatetimestamp != null) {
		            lastDate = lastdatetimestamp.toLocalDateTime().toLocalDate();
		            lastDateString = lastdatetimestamp.toLocalDateTime().format(formatter);
		        }

		        if (secondlastdatetimestamp != null) {
		            secondLastDateString = secondlastdatetimestamp.toLocalDateTime().format(formatter);
		        }
					RT_DataControl data= RT_DatacontrolRepository.getdata(lastDateString,"CBUAE_Investment_Securities_Data_Template");
					RT_DataControl secondlastdata= RT_DatacontrolRepository.getdata(secondLastDateString,"CBUAE_Investment_Securities_Data_Template");
					RT_DataControl report_datedata = null;
					
					 if (formattedDate != null) {
				            report_datedata = RT_DatacontrolRepository.getdata(formattedDate, "CBUAE_Investment_Securities_Data_Template");
				        }
				        
				        System.out.println(formattedDate);

				        // ✅ FIXED NULL CHECKS
				        if (report_datedata != null) {
				        	System.out.println(formattedDate);
				        	lastDate = LocalDate.parse(formattedDate, formatter);
				        	model.addAttribute("data", report_datedata);
				        	model.addAttribute("formmode", "exist");
				        }
					
					else if(data != null && !data.equals(null)) {
						model.addAttribute("data", data);
						model.addAttribute("formmode", "exist");
					}
					else if(secondlastdata != null && !secondlastdata.equals(null)){
						model.addAttribute("data", secondlastdata);
						model.addAttribute("formmode", "exist");
					}else {
						model.addAttribute("formmode", "add");
						model.addAttribute("formmode", "null");
					}
					model.addAttribute("lastDate", lastDate);
					model.addAttribute("bankname", "Bank of Baroda");
		}

		List<RT_BankNameMaster> bankList = bankRepo.findAllByOrderByBankNameAsc();
		List<RT_CountryRiskDropdown> countryList = countryRepo.findAllByOrderByCountryOfRiskAsc();
		model.addAttribute("bankList", bankList);
		model.addAttribute("countryList", countryList);

		return "RT/Investment_SecurityData";
	}
	@PostMapping("/updateInvestmentSecurity")
	@ResponseBody
	public String updateInvestmentSecurity(
			@ModelAttribute("InvestmentData") RT_Investment_Securities_Data_Template InvestmentData) {

		boolean updated = investmentSecurity_Service.updateInvestmentSecurity(InvestmentData);

		if (updated) {
			return "Updated successfully";
		} else {
			return "Record not found for update";
		}
	}

	// -------------------------------------Liquidity_Risk_Data
	// -start---------------------------------------

	@RequestMapping(value = "Liquidity_Risk_Data", method = RequestMethod.GET)
	public String liquidityData(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) BigDecimal slno, Model model,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date,
			@RequestParam(required = false) String glLevel1, @RequestParam(required = false) String glLevel2,
			@RequestParam(required = false) String glLevel3,
			@RequestParam(required = false) String instrumentCurrency) {
		LocalDate today = LocalDate.now();
		   String formattedDate = null;
		   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		   
		   // ✅ Convert Report_date → String safely
		   if (Report_date != null) {
		       formattedDate = sdf.format(Report_date);
		   }
		   
		   System.out.println("formattedDate="+formattedDate);

		   
			if ("edit".equalsIgnoreCase(formmode) && glLevel1 != null && glLevel2 != null && glLevel3 != null
					&& Report_date != null && instrumentCurrency != null) {
				model.addAttribute("formmode", "edit");
				RT_Liquidity_Risk_Data_Template data = LiquidityRiskDataRepository
						.getbyGlLevelsReportDateIC(Report_date, glLevel1, glLevel2, glLevel3, instrumentCurrency);
				model.addAttribute("liquidityData", data);
				model.addAttribute("lastDate", LocalDate.parse(sdf.format(data.getReportDate()), formatter));
		} else if ("list".equalsIgnoreCase(formmode)) {
//			model.addAttribute("formmode", "list");
//			model.addAttribute("liquidityList", LiquidityRiskDataRepository.getLiquiditylist(Report_date));
//			model.addAttribute("lastDate",LocalDate.parse(formattedDate, formatter) );

			if (Report_date == null) {
				model.addAttribute("liquidityList", Collections.emptyList());
			} else {
			    List<RT_Liquidity_Risk_Data_Template> list = LiquidityRiskDataRepository.getLiquiditylist(Report_date);
			    model.addAttribute("liquidityList", list != null ? list : Collections.emptyList());
			}
			System.out.println("list is formmode");
			model.addAttribute("formmode", "list");
			if (formattedDate != null && !formattedDate.trim().isEmpty()) {
				model.addAttribute("lastDate", LocalDate.parse(formattedDate, formatter));
			} else {
			    LocalDate endDateFallback = null; 
			    model.addAttribute("lastDate", endDateFallback);
			}
			
			
		} else {
			Timestamp lastdatetimestamp = LiquidityRiskDataRepository.findLastReportDate();
			Timestamp secondlastdatetimestamp = LiquidityRiskDataRepository.findSecondLastReportDate();
			 String lastDateString = null;
		     String secondLastDateString = null;
		     LocalDate lastDate = null;
					
			
			if (lastdatetimestamp != null) {
	            lastDate = lastdatetimestamp.toLocalDateTime().toLocalDate();
	            lastDateString = lastdatetimestamp.toLocalDateTime().format(formatter);
	        }

	        if (secondlastdatetimestamp != null) {
	            secondLastDateString = secondlastdatetimestamp.toLocalDateTime().format(formatter);
	        }
			RT_DataControl data= RT_DatacontrolRepository.getdata(lastDateString,"CBUAE_Liquidity_Risk_Data_Template");
			RT_DataControl secondlastdata= RT_DatacontrolRepository.getdata(secondLastDateString,"CBUAE_Liquidity_Risk_Data_Template");
			RT_DataControl report_datedata = null;
			
			 if (formattedDate != null) {
		            report_datedata = RT_DatacontrolRepository.getdata(formattedDate, "CBUAE_Liquidity_Risk_Data_Template");
		        }
		        
		        System.out.println(formattedDate);

		        // ✅ FIXED NULL CHECKS
		        if (report_datedata != null) {
		        	System.out.println(formattedDate);
		        	lastDate = LocalDate.parse(formattedDate, formatter);
		        	model.addAttribute("data", report_datedata);
		            model.addAttribute("formmode", "exist");
		        }
			
			else if(data != null && !data.equals(null)) {
				model.addAttribute("data", data);
				model.addAttribute("formmode", "exist");
			}
			else if(secondlastdata != null && !secondlastdata.equals(null)){
				model.addAttribute("data", secondlastdata);
				model.addAttribute("formmode", "exist");
			}else {
				model.addAttribute("formmode", "add");
				model.addAttribute("formmode", "null");
			}
			model.addAttribute("lastDate", lastDate);
			model.addAttribute("bankname", "Bank of Baroda");
		}

		List<RT_BankNameMaster> bankList = bankRepo.findAllByOrderByBankNameAsc();
		List<RT_CountryRiskDropdown> countryList = countryRepo.findAllByOrderByCountryOfRiskAsc();
		model.addAttribute("bankList", bankList);
		model.addAttribute("countryList", countryList);

		return "RT/Liquidity_Risk_Data";
	}

	@PostMapping("/updateLiquidityRiskData")
	@ResponseBody
	public String updateLiquidityRiskData(@ModelAttribute RT_Liquidity_Risk_Data_Template LiquidityData) {
		boolean updated = liquidityRiskDataService.updateLiquidityRisk(LiquidityData);

		if (updated) {
			return "Updated successfully";
		} else {
			return "Record not found for update";
		}
	}

	@RequestMapping(value = "/downloadLiquidityRiskData", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> downloadLiquidityRiskData(HttpServletRequest req,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		logger.info("Controller: Received request for Trade Market Risk Excel download.");

		try {
			byte[] excelData = liquidityRiskDataService.generateLiquidityDataExcel(Report_date);

			if (excelData.length == 0) {
				logger.warn("Controller: Service returned no data. Responding with 204 No Content.");
				return ResponseEntity.noContent().build();
			}

			ByteArrayResource resource = new ByteArrayResource(excelData);

			HttpHeaders headers = new HttpHeaders();
			String filename = "CBUAE_Liquidity Risk_Data_Template.xlsx";
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

			logger.info("Controller: Sending file '{}' to client ({} bytes).", filename, excelData.length);
			
			String userid = (String) req.getSession().getAttribute("USERID");

			auditService.createBusinessAudit(userid, "DOWNLOAD", "LIQUIDITY_RISK_DATA_EXCEL", null, "BCBUAE_LIQUIDITY_RISK_DATA_TEMPLATE");
			
			return ResponseEntity.ok().headers(headers).contentLength(excelData.length)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(resource);

		} catch (FileNotFoundException e) {
			logger.error("Controller ERROR: A required template file was not found.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (Exception e) {
			logger.error("Controller ERROR: A critical error occurred during file generation.", e);

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	// -------------------------------------Liquidity_Risk_Data
	// End---------------------------------------

	@Autowired
	private RT_InvestmentSecurity_Service rtInvestmentSecuritiesService;

	// ... other controller methods ...

	@RequestMapping(value = "/downloadInvestmentSecuritiesExcel", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> downloadInvestmentSecuritiesExcel(HttpServletRequest req,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		logger.info("Controller: Received request for Investment Securities Excel download.");

		try {
			byte[] excelData = rtInvestmentSecuritiesService.generateInvestmentSecuritiesExcel(Report_date);

			if (excelData.length == 0) {
				logger.warn(
						"Controller: Service returned no data for Investment Securities. Responding with 204 No Content.");
				return ResponseEntity.noContent().build();
			}

			ByteArrayResource resource = new ByteArrayResource(excelData);

			HttpHeaders headers = new HttpHeaders();
			String filename = "CBUAE_Investment_Securities_Data_Template_Pillar2.xlsx";
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

			logger.info("Controller: Sending file '{}' to client ({} bytes).", filename, excelData.length);
			
			String userid = (String) req.getSession().getAttribute("USERID");

			auditService.createBusinessAudit(userid, "DOWNLOAD", "INVESTMENT_SECURITIES_DATA_EXCEL", null, "BCBUAE_INVESTMENT_SECURITIES_DATA");

			return ResponseEntity.ok().headers(headers).contentLength(excelData.length)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(resource);

		} catch (FileNotFoundException e) {
			logger.error(
					"Controller ERROR: The CBUAE_Investment_Securities_Data_Template_Pillar2.xlsx template file was not found.",
					e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (Exception e) {
			logger.error("Controller ERROR: A critical error occurred during Investment Securities file generation.",
					e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	// -------------------------------------Investent_Securities_Data
	// End---------------------------------------

//-------------------------------------Investment Risk Data Report Start---------------------------------------
	// Investment Report code
	@RequestMapping(value = "Investment_Risk_Data_Dashboard_Template", method = RequestMethod.GET)
	public String InvestmentRiskDataDashboardTemplate(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String reportdate,
			@RequestParam(required = false) String SI_NO,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "100") int size,
			@RequestParam(required = false) String columnId,
			Model md, HttpServletRequest req,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		
		 	LocalDate today = LocalDate.now();
		    String formattedDate = null;
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		    
		    if (Report_date != null) {
		        formattedDate = sdf.format(Report_date);
		    }
		
		if ("edit".equalsIgnoreCase(formmode) && SI_NO != null && !SI_NO.isEmpty()) {
			Long Serialnumber = Long.parseLong(SI_NO);
			RT_Investment_Risk_Data_Dashboard_Template data = RT_Investment_Risk_Data_Dashboard_TemplateRepositoryS
					.getParticularDataBySI_NO(Serialnumber);
			md.addAttribute("investmentriskdatadashboard", data);
			System.out.println("edit is formmode");
			md.addAttribute("lastDate",LocalDate.parse(sdf.format(data.getReportDate()), formatter) );
			md.addAttribute("formmode", "edit");
		} else if ("list".equalsIgnoreCase(formmode)) {
//			md.addAttribute("InvestmentRiskDatalist", RT_Investment_Risk_Data_Dashboard_TemplateRepositoryS.getlist(Report_date));
//			md.addAttribute("formmode", "list");
//			md.addAttribute("lastDate",LocalDate.parse(formattedDate, formatter) );
//			
			if (Report_date == null) {
			    md.addAttribute("InvestmentRiskDatalist", Collections.emptyList());
			} else {
			    List<RT_Investment_Risk_Data_Dashboard_Template> list = RT_Investment_Risk_Data_Dashboard_TemplateRepositoryS.getlist(Report_date);
			    md.addAttribute("InvestmentRiskDatalist", list != null ? list : Collections.emptyList());
			}
			System.out.println("list is formmode");
			md.addAttribute("formmode", "list");
			if (formattedDate != null && !formattedDate.trim().isEmpty()) {
			    md.addAttribute("lastDate", LocalDate.parse(formattedDate, formatter));
			} else {
			    LocalDate endDateFallback = null; 
			    md.addAttribute("lastDate", endDateFallback);
			}
		}
		
		else if ("limits".equalsIgnoreCase(formmode)) {
			md.addAttribute("formmode", "limits");
			RtVarReportLimits limitobj= new RtVarReportLimits();
			
			RtVarReportLimits limitdata =rtvarreportlimits_rep.RtInvestmentRiskDatalistrowid(Report_date);
			
			if(limitdata!=null) {
				limitobj=limitdata;
			}
			md.addAttribute("limitsdata",limitobj);
			md.addAttribute("lastDate",LocalDate.parse(formattedDate, formatter) );
		}
		
		else if ("Detail".equalsIgnoreCase(formmode)) {
			
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date reportdatefor = null;

			try {
				if (reportdate != null) {
					reportdatefor = dateFormat.parse(reportdate);
				}
			} catch (ParseException e) {
				e.printStackTrace();
				md.addAttribute("error", "Invalid date format. Expected dd/MM/yyyy");
				return "RT/Investment_Risk_Data_Dashboard_Template";
			}
			
			int pageSize = size;
			int offset = page;
			int totalRows=0;
			int totalPages=0;
			totalRows = rtinvestmentriskdatadetailrep.RtInvestmentRiskDatacountROWID(reportdatefor, columnId);
			System.out.println("columnId="+columnId);
			totalPages = (int) Math.ceil((double) totalRows / pageSize);
			List<RtInvestmentRiskDataDetail> RtInvestmentRiskdetaillist = rtinvestmentriskdatadetailrep.RtInvestmentRiskDatalistrowid(reportdatefor,columnId, offset, pageSize);
			System.out.println("size="+RtInvestmentRiskdetaillist.size());
			md.addAttribute("formmode", "Detail");
			md.addAttribute("invriskdetaillist", RtInvestmentRiskdetaillist);
			md.addAttribute("reportdate", reportdate);
			md.addAttribute("pagination", "YES");
			md.addAttribute("currentPage", page);
			md.addAttribute("totalPages", totalPages);
			md.addAttribute("columnId", columnId);
		}
		
		
		else {
			Timestamp lastdatetimestamp = RT_Investment_Risk_Data_Dashboard_TemplateRepositoryS.findLastReportDate();
			Timestamp secondlastdatetimestamp = RT_Investment_Risk_Data_Dashboard_TemplateRepositoryS.findSecondLastReportDate();	
			
			 	String lastDateString = null;
		        String secondLastDateString = null;
		        LocalDate lastDate = null;

		        if (lastdatetimestamp != null) {
		            lastDate = lastdatetimestamp.toLocalDateTime().toLocalDate();
		            lastDateString = lastdatetimestamp.toLocalDateTime().format(formatter);
		        }

		        if (secondlastdatetimestamp != null) {
		            secondLastDateString = secondlastdatetimestamp.toLocalDateTime().format(formatter);
		        }

		        
			RT_DataControl data= RT_DatacontrolRepository.getdata(lastDateString,"Investment_Risk_Data_Dashboard_Template");
			RT_DataControl secondlastdata= RT_DatacontrolRepository.getdata(secondLastDateString,"Investment_Risk_Data_Dashboard_Template");
			RT_DataControl report_datedata = null;

	        if (formattedDate != null) {
	            report_datedata = RT_DatacontrolRepository.getdata(formattedDate, "Investment_Risk_Data_Dashboard_Template");
	        }
	        
	        System.out.println(formattedDate);

	       if (report_datedata != null) {
	        	System.out.println(formattedDate);
	        	lastDate = LocalDate.parse(formattedDate, formatter);
	            md.addAttribute("data", report_datedata);
	            md.addAttribute("formmode", "exist");

	        }
			
			else if (data != null && !data.equals(null)) {
				
				md.addAttribute("data", data);
				md.addAttribute("formmode", "exist");
			}
			else if(secondlastdata != null && !secondlastdata.equals(null)){
				lastDate = LocalDate.parse(secondLastDateString, formatter);
				md.addAttribute("data", secondlastdata);
				md.addAttribute("formmode", "exist");
			}else {
				md.addAttribute("formmode", "add");
				md.addAttribute("formmode", "null");
			}
			md.addAttribute("lastDate", lastDate);
			md.addAttribute("bankname", "Bank of Baroda");
		}

		List<RT_BankNameMaster> bankList = bankRepo.findAllByOrderByBankNameAsc();
		List<RT_CountryRiskDropdown> countryList = countryRepo.findAllByOrderByCountryOfRiskAsc();

		md.addAttribute("bankList", bankList);
		md.addAttribute("countryList", countryList);

		return "RT/Investment_Risk_Data_Dashboard_Template";
	}

	@PostMapping("/updateinvestmentriskdatadictionary")
	@ResponseBody
	public String updateinvestmentriskdatadictionary(
			@ModelAttribute RT_Investment_Risk_Data_Dashboard_Template investmentriskdatadashboard) {
		boolean updated = investmentriskdatadictionaryService
				.updateinvestmentriskdatadictionary(investmentriskdatadashboard);

		if (updated) {
			return "Updated successfully";
		} else {
			return "Record not found for update";
		}

	}

	// Updated data saving code for Repo
	@RequestMapping("/updateInvenstment")
	@ResponseBody
	public String updateInvenstment(@ModelAttribute RT_RepoDataTemplate repoData, HttpServletRequest request) {

		// Call the update logic from service or directly use the repository if simple
		boolean updated = repoService.updateRepoData(repoData);

		if (updated) {
			System.out.println("Update successful for SL_NO: " + repoData.getSlNo());
			return "Updated successful";
		} else {
			System.out.println("Record not found for update for SL_NO: " + repoData.getSlNo());
			return "Record not found for update";
		}
	}

	// Downloading Excel for Repo
	@RequestMapping(value = "downloadInvestmentExcel", method = RequestMethod.GET)
	public ResponseEntity<byte[]> downloadInvenstmentExcel(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) throws IOException {
		System.out.println("Entered controller downloadRepoExcel");

		File excelFile = repoService.generateRepoExcel(Report_date);
		byte[] excelData = java.nio.file.Files.readAllBytes(excelFile.toPath());

		HttpHeaders headersResponse = new HttpHeaders();
		headersResponse.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headersResponse.setContentDispositionFormData("attachment", "RepoDataTemplate.xls");

		return ResponseEntity.ok().headers(headersResponse).body(excelData);
	}

//-------------------------------------Repo Report End---------------------------------------		
	@PostMapping("/updateFxriskdata")
	@ResponseBody
	public String updateFxriskdata(@ModelAttribute RT_Fxriskdata fxriskData) {
		boolean updated = fxriskdataService.updateFxriskdata(fxriskData);

		if (updated) {
			return "Updated successful";
		} else {
			return "Record not found for update";
		}
	}

	@PostMapping("/updateMmdata")
	@ResponseBody
	public String updateMmdata(@ModelAttribute RT_MmData mmData) {
		boolean updated = mmdataService.updateMmdata(mmData);

		if (updated) {
			return "Updated successful";
		} else {
			return "Record not found for update";
		}
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@RequestMapping(value = "Fx_Risk_Data", method = RequestMethod.GET)
	public String Fxriskdata(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String SI_NO, Model md, HttpServletRequest req,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		   LocalDate today = LocalDate.now();
		   String formattedDate = null;
		   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		   
		   // ✅ Convert Report_date → String safely
		   if (Report_date != null) {
		       formattedDate = sdf.format(Report_date);
		   }

		if ("edit".equalsIgnoreCase(formmode) && SI_NO != null && !SI_NO.isEmpty()) {
			RT_Fxriskdata data = friskdataRepo.getParticularDataBySI_NO(SI_NO);
			md.addAttribute("fxriskData", data);
			System.out.println("edit is formmode");
			md.addAttribute("lastDate",LocalDate.parse(sdf.format(data.getReport_date()), formatter) );
			md.addAttribute("formmode", "edit");

		} else if ("list".equalsIgnoreCase(formmode)) {
//			md.addAttribute("branchList", friskdataRepo.getlist(Report_date));
//			System.out.println("list is formmode");
//			md.addAttribute("formmode", "list");
//			md.addAttribute("lastDate",LocalDate.parse(formattedDate, formatter) );
			
			if (Report_date == null) {
			    md.addAttribute("branchList", Collections.emptyList());
			} else {
			    List<RT_Fxriskdata> list = friskdataRepo.getlist(Report_date);
			    md.addAttribute("branchList", list != null ? list : Collections.emptyList());
			}
			System.out.println("list is formmode");
			md.addAttribute("formmode", "list");
			if (formattedDate != null && !formattedDate.trim().isEmpty()) {
			    md.addAttribute("lastDate", LocalDate.parse(formattedDate, formatter));
			} else {
			    LocalDate endDateFallback = null; 
			    md.addAttribute("lastDate", endDateFallback);
			}
			
			
		} else {
			Timestamp lastdatetimestamp = friskdataRepo.findLastReportDate();
			Timestamp secondlastdatetimestamp = nostroAccBalRepo.findSecondLastReportDate();
			 String lastDateString = null;
		     String secondLastDateString = null;
		     LocalDate lastDate = null;
					
			
			if (lastdatetimestamp != null) {
	            lastDate = lastdatetimestamp.toLocalDateTime().toLocalDate();
	            lastDateString = lastdatetimestamp.toLocalDateTime().format(formatter);
	        }

	        if (secondlastdatetimestamp != null) {
	            secondLastDateString = secondlastdatetimestamp.toLocalDateTime().format(formatter);
	        }
			RT_DataControl data= RT_DatacontrolRepository.getdata(lastDateString,"CBUAE_Fx_Risk_Data_Template");
			RT_DataControl secondlastdata= RT_DatacontrolRepository.getdata(secondLastDateString,"CBUAE_Fx_Risk_Data_Template");
			RT_DataControl report_datedata = null;
			
			 if (formattedDate != null) {
		            report_datedata = RT_DatacontrolRepository.getdata(formattedDate, "CBUAE_Fx_Risk_Data_Template");
		        }
		        
		        System.out.println(formattedDate);

		        // ✅ FIXED NULL CHECKS
		        if (report_datedata != null) {
		        	System.out.println(formattedDate);
		        	lastDate = LocalDate.parse(formattedDate, formatter);
		            md.addAttribute("data", report_datedata);
		            md.addAttribute("formmode", "exist");
		        }
			
			else if(data != null && !data.equals(null)) {
				md.addAttribute("data", data);
				md.addAttribute("formmode", "exist");
			}
			else if(secondlastdata != null && !secondlastdata.equals(null)){
				md.addAttribute("data", secondlastdata);
				md.addAttribute("formmode", "exist");
			}else {
				md.addAttribute("formmode", "add");
				md.addAttribute("formmode", "null");
			}
			md.addAttribute("lastDate", lastDate);
			md.addAttribute("bankname", "Bank of Baroda");

			// You had md.addAttribute("formmode", "null"); — removed this line because it
			// would overwrite the previous one
		}

		List<RT_BankNameMaster> bankList = bankRepo.findAllByOrderByBankNameAsc();
		md.addAttribute("bankList", bankList);

		return "RT/Fx_Risk_Data";
	}


	// For download excel for fxriskdata

	@RequestMapping(value = "/downloadFxriskExcel", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> downloadFxriskExcel(HttpServletRequest req,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		logger.info("Controller: Received request for Fx Risk Excel download.");

		try {
			byte[] excelData = fxriskdataService.generateFxRiskExcel(Report_date);

			if (excelData.length == 0) {
				logger.warn("Controller: Service returned no data. Responding with 204 No Content.");
				return ResponseEntity.noContent().build();
			}

			ByteArrayResource resource = new ByteArrayResource(excelData);

			HttpHeaders headers = new HttpHeaders();
			String filename = "CBUAE_FX_Risk_Data_Template.xlsx";
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

			logger.info("Controller: Sending file '{}' to client ({} bytes).", filename, excelData.length);
			

			String userid = (String) req.getSession().getAttribute("USERID");

			auditService.createBusinessAudit(userid, "DOWNLOAD", "FX_RISK_DATA_EXCEL", null, "BCBUAE_FX_RISK_DATA");

			return ResponseEntity.ok().headers(headers).contentLength(excelData.length)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(resource);

		} catch (FileNotFoundException e) {
			logger.error("Controller ERROR: A required template file was not found.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (Exception e) {
			logger.error("Controller ERROR: A critical error occurred during file generation.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// For download excel for downloadNostroExcel

	@RequestMapping(value = "downloadNostroExcel", method = RequestMethod.GET)
	public ResponseEntity<byte[]> downloadNostroExcel(HttpServletRequest req,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date
) throws IOException {
		System.out.println("Entered controller downloadNostroExcel");

		String userid = (String) req.getSession().getAttribute("USERID");

		auditService.createBusinessAudit(userid, "DOWNLOAD", "NOSTRO_EXCEL", null, "BCBUAE_NOSTRO_BALANCE");

		// ✅ Generate Excel file and prepare response
		File excelFile = nostroService.generateNostroExcel(Report_date);
		if (excelFile == null) {
			logger.warn("Controller: NOSTRO_EXCEL file has no data. Returning 204.");
			return ResponseEntity.noContent().build();
		}
		byte[] excelData = java.nio.file.Files.readAllBytes(excelFile.toPath());
		
		HttpHeaders headersResponse = new HttpHeaders();
		headersResponse.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headersResponse.setContentDispositionFormData("attachment", "NostroAccBalance.xlsx");

		return ResponseEntity.ok().headers(headersResponse).body(excelData);
	}

	@Autowired
	private RT_TradeMarketriskDataRepository trade_market_risk_repo;

	@RequestMapping(value = "/Trade_Market_Risk", method = RequestMethod.GET)
	public String tradeMarketRisk(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date reportDate, Model model,
			HttpServletRequest request,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {

			LocalDate today = LocalDate.now();
			String formattedDate = null;
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			   
		   // ✅ Convert Report_date → String safely
		   if (Report_date != null) {
		       formattedDate = sdf.format(Report_date);
		   }

		if ("edit".equalsIgnoreCase(formmode) && reportDate != null) {
			RT_TradeMarketRiskData data = trade_market_risk_repo.findById(reportDate).orElse(null);
			model.addAttribute("data", data);
			model.addAttribute("formmode", "edit");
			System.out.println("Edit mode activated");
			model.addAttribute("lastDate",LocalDate.parse(sdf.format(reportDate), formatter) );
		} else if ("list".equalsIgnoreCase(formmode)) {
//			List<RT_TradeMarketRiskData> list = trade_market_risk_repo.getlist(Report_date);
//			model.addAttribute("dataList", list);
//			model.addAttribute("formmode", "list");
//			System.out.println("List mode activated");
//			model.addAttribute("lastDate",LocalDate.parse(formattedDate, formatter) );
//			
			if (Report_date == null) {
				model.addAttribute("dataList", Collections.emptyList());
			} else {
			    List<RT_TradeMarketRiskData> list = trade_market_risk_repo.getlist(Report_date);
			    model.addAttribute("dataList", list != null ? list : Collections.emptyList());
			}
			System.out.println("list is formmode");
			model.addAttribute("formmode", "list");
			if (formattedDate != null && !formattedDate.trim().isEmpty()) {
				model.addAttribute("lastDate", LocalDate.parse(formattedDate, formatter));
			} else {
			    LocalDate endDateFallback = null; 
			    model.addAttribute("lastDate", endDateFallback);
			}
		} else {
			
			  
			Timestamp lastdatetimestamp = trade_market_risk_repo.findLastReportDate();
			Timestamp secondlastdatetimestamp = trade_market_risk_repo.findSecondLastReportDate();	
			 String lastDateString = null;
		        String secondLastDateString = null;
		        LocalDate lastDate = null;

		        // ✅ NULL SAFE
		        if (lastdatetimestamp != null) {
		            lastDate = lastdatetimestamp.toLocalDateTime().toLocalDate();
		            lastDateString = lastdatetimestamp.toLocalDateTime().format(formatter);
		        }

		        if (secondlastdatetimestamp != null) {
		            secondLastDateString = secondlastdatetimestamp.toLocalDateTime().format(formatter);
		        }

			RT_DataControl data= RT_DatacontrolRepository.getdata(lastDateString,"CBUAE_Trade_Market_Risk_Data_Template");
			RT_DataControl secondlastdata= RT_DatacontrolRepository.getdata(secondLastDateString,"CBUAE_Trade_Market_Risk_Data_Template");
			 RT_DataControl report_datedata = null;

	        if (formattedDate != null) {
	            report_datedata = RT_DatacontrolRepository.getdata(formattedDate, "CBUAE_Trade_Market_Risk_Data_Template");
	        }
	        
	        
	        // ✅ FIXED NULL CHECKS
	        if (report_datedata != null) {
	        	System.out.println(formattedDate);
	        	lastDate = LocalDate.parse(formattedDate, formatter);
	        	model.addAttribute("data", report_datedata);
	        	model.addAttribute("formmode", "exist");

	        }
			else if (data != null && !data.equals(null)) {
				model.addAttribute("data", data);
				model.addAttribute("formmode", "exist");
			}
			else if(secondlastdata != null && !secondlastdata.equals(null)){
				model.addAttribute("data", secondlastdata);
				model.addAttribute("formmode", "exist");
			}else {
				model.addAttribute("formmode", "add");
				model.addAttribute("formmode", "null");
			}
			model.addAttribute("lastDate", lastDate);
			model.addAttribute("bankname", "Bank of Baroda");
		}
		List<RT_BankNameMaster> bankList = bankRepo.findAllByOrderByBankNameAsc();
		List<RT_CountryRiskDropdown> countryList = countryRepo.findAllByOrderByCountryOfRiskAsc();
		model.addAttribute("bankList", bankList);
		model.addAttribute("countryList", countryList);

		return "RT/Trade_Market_Risk";
	}

	@RequestMapping(value = "updateTradeMarketRisk", method = RequestMethod.POST)
	@ResponseBody
	public String updateTradeMarketRisk(@ModelAttribute RT_TradeMarketRiskData data, HttpServletRequest request) {

		System.out.println("User [" + request.getSession().getAttribute("USERID")
				+ "] requested update for Report Date: " + data.getReportDate());

		String userid = (String) request.getSession().getAttribute("USERID");

		try {
			if (data.getReportDate() == null) {
				return "Error: Report Date (ID) is missing.";
			}

			if (!trade_market_risk_repo.existsById(data.getReportDate())) {
				return "Error: Record not found for update.";
			}

			data.setModifyFlg("Y");
			data.setEntityFlg("Y");
			data.setDelFlg("N");
			data.setModifyUser(userid);
			
			Optional<RT_TradeMarketRiskData> existingData = trade_market_risk_repo.findById(data.getReportDate());
			
			RT_TradeMarketRiskData existing= existingData.get();
			
		    RT_TradeMarketRiskData dbUser = new RT_TradeMarketRiskData();
			org.springframework.beans.BeanUtils.copyProperties(existing, dbUser);
			List<String> ignoreFields = Arrays.asList("createUser", "modifyUser", "delFlg");

			Map<String, String> changes = new LinkedHashMap<>();

			for (Field field : RT_TradeMarketRiskData.class.getDeclaredFields()) {
				field.setAccessible(true);
				try {
					Object oldValue = field.get(dbUser);
					Object newValue = field.get(data);
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

			trade_market_risk_repo.save(data);
			
			 System.out.println("changes : "+changes);

		        // Audit only if any field was changed
		        if (!changes.isEmpty()) {
		        	auditService.createBusinessAudit(
		        			String.valueOf(data.getReportDate()),           // Unique ID
		                "MODIFY",                             // Action
		                "TRADE_MARKET_RISK_DATA_EDIT_SCREEN",                  // Screen name
		                changes,                              // Changed fields map
		                "BCBUAE_TRADE_MARKET_RISK_DATA"              // Table name
		            );
		        }
		        

			return "Updated successfully";
		} catch (Exception e) {
			return "Error while updating: " + e.getMessage();
		}
	}

	@Autowired
	private RT_TradeMarketRiskService rtTradeMarketRiskService;

	@RequestMapping(value = "/downloadTradeMarketRiskExcel", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> downloadTradeMarketRiskExcel(HttpServletRequest req
			,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		logger.info("Controller: Received request for Trade Market Risk Excel download.");

		try {
			byte[] excelData = rtTradeMarketRiskService.generateTradeMarketRiskExcel(Report_date);

			if (excelData.length == 0) {
				logger.warn("Controller: Service returned no data. Responding with 204 No Content.");
				return ResponseEntity.noContent().build();
			}

			ByteArrayResource resource = new ByteArrayResource(excelData);

			HttpHeaders headers = new HttpHeaders();
			String filename = "CBUAE_Trade_Market_Risk_Data_Template.xls";
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

			logger.info("Controller: Sending file '{}' to client ({} bytes).", filename, excelData.length);
			

			String userid = (String) req.getSession().getAttribute("USERID");

			auditService.createBusinessAudit(userid, "DOWNLOAD", "TRADE_MARKET_RISK_DATA_EXCEL", null, "BCBUAE_TRADE_MARKET_RISK_DATA");

			
			return ResponseEntity.ok().headers(headers).contentLength(excelData.length)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(resource);

		} catch (FileNotFoundException e) {
			logger.error("Controller ERROR: A required template file was not found.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (Exception e) {
			logger.error("Controller ERROR: A critical error occurred during file generation.", e);

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "Mm_Data", method = RequestMethod.GET)
	public String Mmdata(@RequestParam(required = false) String formmode,
	                     @RequestParam(required = false) String deal_no,
	                     Model md,
	                     HttpServletRequest req,
	                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {

	    LocalDate today = LocalDate.now();
	    String formattedDate = null;
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    // ✅ Convert Report_date → String safely
	    if (Report_date != null) {
	        formattedDate = sdf.format(Report_date);
	    }

	    // ================= EDIT =================
	    if ("edit".equalsIgnoreCase(formmode) && deal_no != null && !deal_no.isEmpty()) {

	        RT_MmData data = mmdataRepo.getParticularDataBySI_NOReportdDate(Report_date,deal_no);
	        md.addAttribute("mmData", data);
	        md.addAttribute("formmode", "edit");
	        md.addAttribute("lastDate",LocalDate.parse(sdf.format(data.getReport_date()), formatter) );

	    }

	    // ================= LIST =================
	    else if ("list".equalsIgnoreCase(formmode)) {

//	        md.addAttribute("branchList", mmdataRepo.getlist(Report_date));
//	        md.addAttribute("formmode", "list");
//	        md.addAttribute("lastDate",LocalDate.parse(formattedDate, formatter) );

	        if (Report_date == null) {
			    md.addAttribute("branchList", Collections.emptyList());
			} else {
			    List<RT_MmData> list = mmdataRepo.getlist(Report_date);
			    md.addAttribute("branchList", list != null ? list : Collections.emptyList());
			}
			System.out.println("list is formmode");
			md.addAttribute("formmode", "list");
			if (formattedDate != null && !formattedDate.trim().isEmpty()) {
			    md.addAttribute("lastDate", LocalDate.parse(formattedDate, formatter));
			} else {
			    LocalDate endDateFallback = null; 
			    md.addAttribute("lastDate", endDateFallback);
			}
	        
	        
	    }

	    // ================= DEFAULT =================
	    else {

	        Timestamp lastdatetimestamp = mmdataRepo.findLastReportDate();
	        Timestamp secondlastdatetimestamp = mmdataRepo.findSecondLastReportDate();

	        

	        String lastDateString = null;
	        String secondLastDateString = null;
	        LocalDate lastDate = null;

	        // ✅ NULL SAFE
	        if (lastdatetimestamp != null) {
	            lastDate = lastdatetimestamp.toLocalDateTime().toLocalDate();
	            lastDateString = lastdatetimestamp.toLocalDateTime().format(formatter);
	        }

	        if (secondlastdatetimestamp != null) {
	            secondLastDateString = secondlastdatetimestamp.toLocalDateTime().format(formatter);
	        }

	        RT_DataControl data = RT_DatacontrolRepository.getdata(lastDateString, "CBUAE_MM_DATA_TEMPLATE");
	        RT_DataControl secondlastdata = RT_DatacontrolRepository.getdata(secondLastDateString, "CBUAE_MM_DATA_TEMPLATE");

	        RT_DataControl report_datedata = null;

	        if (formattedDate != null) {
	            report_datedata = RT_DatacontrolRepository.getdata(formattedDate, "CBUAE_MM_DATA_TEMPLATE");
	        }
	        
	        System.out.println(formattedDate);

	        // ✅ FIXED NULL CHECKS
	        if (report_datedata != null) {
	        	System.out.println(formattedDate);
	        	lastDate = LocalDate.parse(formattedDate, formatter);
	            md.addAttribute("data", report_datedata);
	            md.addAttribute("formmode", "exist");

	        } else if (data != null) {
	        	
	            md.addAttribute("data", data);
	            md.addAttribute("formmode", "exist");

	        } else if (secondlastdata != null) {
	        	lastDate = LocalDate.parse(secondLastDateString, formatter);
	            md.addAttribute("data", secondlastdata);
	            md.addAttribute("formmode", "exist");

	        } else {

	            md.addAttribute("formmode", "add");
	        }
	        
	        md.addAttribute("lastDate", lastDate);
	        md.addAttribute("bankname", "Bank of Baroda");
	    }

	    // ================= DROPDOWNS =================
	    List<RT_BankNameMaster> bankList = bankRepo.findAllByOrderByBankNameAsc();
	    List<RT_CountryRiskDropdown> countryList = countryRepo.findAllByOrderByCountryOfRiskAsc();

	    md.addAttribute("bankList", bankList);
	    md.addAttribute("countryList", countryList);

	    return "RT/Mm_Data";
	}

	@RequestMapping(value = "/downloadMmExcel", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> downloadMmExcel(HttpServletRequest req,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		logger.info("Controller: Received request for MM Excel download.");

		try {

			byte[] excelData = mmdataService.generateMmExcel(Report_date);

			if (excelData.length == 0) {
				logger.warn("Controller: MM Excel file has no data. Returning 204.");
				return ResponseEntity.noContent().build();
			}

			ByteArrayResource resource = new ByteArrayResource(excelData);
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=MmData.xlsx");
			
			String userid = (String) req.getSession().getAttribute("USERID");

			auditService.createBusinessAudit(userid, "DOWNLOAD", "MM_DATA_EXCEL", null, "BCBUAE_MM_DATA");

			
			return ResponseEntity.ok().headers(headers).contentLength(excelData.length)
					.contentType(MediaType.parseMediaType(
							"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
					.body(resource);

		} catch (FileNotFoundException e) {
			logger.error("Controller ERROR: MM template file not found.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (Exception e) {
			logger.error("Controller ERROR: Error generating MM Excel file.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "Bill_Details", method = RequestMethod.GET)
	public String billDetails(@RequestParam(required = false) String formmode, Model md,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		if ("list".equalsIgnoreCase(formmode) && Report_date != null) {
			md.addAttribute("branchList", bankingBookBillDataService.getBillDetailsByReportDate(Report_date));
			md.addAttribute("formmode", "list");
			md.addAttribute("lastDate", LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(Report_date), formatter));
		} else {
			Timestamp lastdatetimestamp = bankingBookBillDataRepo.findLastReportDate();
			LocalDate lastDate = null;
			if (lastdatetimestamp != null) {
				lastDate = lastdatetimestamp.toLocalDateTime().toLocalDate();
			}
			md.addAttribute("lastDate", lastDate);
			md.addAttribute("formmode", "list");
			if (lastDate != null) {
				md.addAttribute("branchList",
						bankingBookBillDataService.getBillDetailsByReportDate(java.sql.Date.valueOf(lastDate)));
			}
		}
		return "RT/Bill_Details";
	}

	@RequestMapping(value = "/downloadBillDetailsExcel", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> downloadBillDetailsExcel(HttpServletRequest req,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		logger.info("Controller: Received request for Bill Details Excel download.");
		try {
			byte[] excelData = bankingBookBillDataService.generateBillDetailsExcel(Report_date);
			if (excelData.length == 0) {
				return ResponseEntity.noContent().build();
			}
			ByteArrayResource resource = new ByteArrayResource(excelData);
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Bill_Details.xlsx");

			String userid = (String) req.getSession().getAttribute("USERID");
			auditService.createBusinessAudit(userid, "DOWNLOAD", "BILL_DETAILS_EXCEL", null, "BANKING_BOOK_BILL_DATA");

			return ResponseEntity.ok().headers(headers).contentLength(excelData.length)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(resource);
		} catch (Exception e) {
			logger.error("Controller ERROR: Error generating Bill Details Excel file.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "counterparty", method = { RequestMethod.GET, RequestMethod.POST })
	public String counterparty(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String id, @RequestParam(required = false) String userid, Model md,
			HttpServletRequest req) {
		logger.info("Enter controller of counterparty");

		String roleId = (String) req.getSession().getAttribute("ROLEID");
		String loginUserId = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("roleId", roleId);
		md.addAttribute("loginUserId", loginUserId);
		md.addAttribute("canRequestDelete", counter_servicess.isDeleteRequester(roleId));
		md.addAttribute("canApproveDelete", counter_servicess.isDeleteApprover(roleId));

		md.addAttribute("menu", "List Of Counterparty Bank"); // To highlight the menu
		String domIds = ((String) req.getSession().getAttribute("DOMAINID")).trim();
		md.addAttribute("dom_ids", domIds); // To highlight the menu
		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("formmode", "list");
			md.addAttribute("currentDate", new Date()); // java.util.Date
			md.addAttribute("listall", Counterparty_Reps.getalllist());
		} else if (formmode.equals("edit")) {
			md.addAttribute("formmode", formmode);
			logger.info("modify screen id is: " + id);
			md.addAttribute("list", Counterparty_Reps.getBYID(Long.valueOf(id)));
			List<String> counterList = Counterparty_Reps.getall();
			md.addAttribute("counterlist", counterList);
			md.addAttribute("LOCATION", Counterparty_Reps.getallLOCATION());
			List<String> getcode = Counterparty_Reps.getcodes();
			md.addAttribute("ratinglist", rt_rwa_rating_guidelines_rep.getratinglist());
			md.addAttribute("getcode", getcode);
		}

		else if (formmode.equals("view")) {
			md.addAttribute("formmode", formmode);
			logger.info("modify screen id is: " + id);
			md.addAttribute("list", Counterparty_Reps.getBYID(Long.valueOf(id)));
			List<String> counterList = Counterparty_Reps.getall();
			md.addAttribute("counterlist", counterList);
			List<String> getcode = Counterparty_Reps.getcodes();
			md.addAttribute("getcode", getcode);
		}

		else {
			logger.info("Adding new Counterparty Bank form initialization started.");
			md.addAttribute("menu", "Counterparty Bank - Add");
			md.addAttribute("formmode", formmode);

			List<String> counterList = Counterparty_Reps.getall();
			md.addAttribute("counterlist", counterList);
			List<String> getcode = Counterparty_Reps.getcodes();
			md.addAttribute("getcode", getcode);
			md.addAttribute("LOCATION", Counterparty_Reps.getallLOCATION());
			
			logger.info("Fetched counterparty list: size={}", counterList.size());

			Integer maxSuffix = Counterparty_Reps.findMaxSrlNoSuffix(); // e.g., returns 1
			int nextSuffix = (maxSuffix != null) ? maxSuffix + 1 : 1;
			String serialNo = String.format("%s%03d", "BOBUAE", nextSuffix); // BOBUAE002
			md.addAttribute("serialNo", serialNo);
			md.addAttribute("ratinglist", rt_rwa_rating_guidelines_rep.getratinglist());
			logger.info("Generated serial number: {}", serialNo);
		}
		return "MIS/counterparty.html";
	}

	@RequestMapping(value = "Addcounter", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String Addcounter(@ModelAttribute Counterparty_Entity Counterparty_Entity,
			@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String remarks, Model md, HttpServletRequest rq) {
		logger.info("Add counter party...");
		String userid = (String) rq.getSession().getAttribute("USERID");
		String roleId = (String) rq.getSession().getAttribute("ROLEID");
		String msg = counter_servicess.addcunter(Counterparty_Entity, userid, formmode, roleId, remarks);
		return msg;

	}

	@RequestMapping(value = "counterpartyDeleteDetails", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> counterpartyDeleteDetails(@RequestParam Long id) {
		return counter_servicess.getDeleteRequestDetails(id);
	}

	@Autowired
	Mis_exposure_bill_detail_rep Mis_exposure_bill_detail_rep;

	@RequestMapping(value = "counterparty_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String counterparty_list(@RequestParam(required = false) String formmode,
			@RequestParam(value = "Exposurebillid", required = false) String Exposurebillid,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date, Model md,
			HttpServletRequest req) {
		String userid = (String) req.getSession().getAttribute("USERID");
		String BRANCHCODE = (String) req.getSession().getAttribute("BRANCHCODE");
		String BRANCHNAME = (String) req.getSession().getAttribute("BRANCHNAME");
		String ROLEID = (String) req.getSession().getAttribute("ROLEID");
		String domIds = ((String) req.getSession().getAttribute("DOMAINID")).trim();
		logger.info("User '{}' accessed counterparty_list with formmode='{}'", userid, formmode);
		LocalDate today = LocalDate.now();
		md.addAttribute("dom_ids", domIds); // To highlight the menu

		if ("list".equalsIgnoreCase(formmode)) {
			logger.info("Loading exposure data list view for branch '{}'", BRANCHNAME);

			md.addAttribute("menu", "List Of Exposure Data"); // Default menu label
			md.addAttribute("formmode", "list");
			Date currentDate = new Date(); // current system date
			md.addAttribute("currentDate", currentDate);
			List<String> branchList = ASL_Report_Reps.getAllBranchNames();
			md.addAttribute("branches", branchList);
			md.addAttribute("BRANCHCODE", BRANCHCODE);
			md.addAttribute("ROLEID", ROLEID);

			System.out.println("ROLEID--" + ROLEID);
			md.addAttribute("currentBranch", BRANCHNAME);
			List<String> branchesl;
			if ("ADM".equalsIgnoreCase(ROLEID)) {
				branchesl = ASL_Report_Reps.getAllBranchNames();
			} else {
				branchesl = Collections.singletonList(BRANCHNAME);
			}

			md.addAttribute("branchesl", branchesl);

			java.sql.Date sqlDate = java.sql.Date.valueOf(today);
			List<ASL_Report_Entity> list = ASL_Report_Reps.getAlls(sqlDate, BRANCHNAME.trim());
			logger.info("Fetched {} exposure records for branch '{}' date '{}'", list.size(), BRANCHNAME, sqlDate);
			md.addAttribute("listall", list);

		} else if ("Billdetaillist".equalsIgnoreCase(formmode) || "Billdetaillistall".equalsIgnoreCase(formmode)) {

			if (Report_date != null) {
				Report_date = java.sql.Date.valueOf(normalizeDate(Report_date.toString()));
			} else {
				Report_date = java.sql.Date.valueOf(today.minusDays(0));
			}
			md.addAttribute("Todateselected", Report_date);
			md.addAttribute("formmode", formmode);
			boolean viewAllBills = "Billdetaillistall".equalsIgnoreCase(formmode);
			md.addAttribute("viewAllBills", viewAllBills);
			md.addAttribute("menuname",
					viewAllBills ? "Bill detail operation - all bills" : "Bill detail operation - list");

			if ("USR-M".equalsIgnoreCase(ROLEID) || "USR-C".equalsIgnoreCase(ROLEID)) {
				System.out.println("Selected Report : " + Report_date + ": and user id is : " + ROLEID);
				if (viewAllBills) {
					md.addAttribute("Activebilldetails", Mis_exposure_bill_detail_rep
							.getallbilldetailsbranchwise(BRANCHNAME, Report_date));
				} else {
					md.addAttribute("Activebilldetails",
							Mis_exposure_bill_detail_rep.getbilldetailsbranchwise(BRANCHNAME, Report_date));
				}
			} else {
				System.out.println("Selected Report : " + Report_date + ": and user id is : " + ROLEID
						+ " and Branch Name is : " + BRANCHNAME);
				if (viewAllBills) {
					md.addAttribute("Activebilldetails",
							Mis_exposure_bill_detail_rep.getallbilldetails(Report_date));
				} else {
					md.addAttribute("Activebilldetails", Mis_exposure_bill_detail_rep.getbilldetails(Report_date));
				}
			}

		} else if ("Addbilldetail".equalsIgnoreCase(formmode)) {

			md.addAttribute("formmode", formmode);
			md.addAttribute("menuname", "Bill detail operation - Add");
			Mis_exposure_bill_detail_entity Mis_exposure_bill_detail_entity = new Mis_exposure_bill_detail_entity();

			Mis_exposure_bill_detail_entity.setDate_of_loan(new Date());
			Mis_exposure_bill_detail_entity.setDue_date(new Date());
			Mis_exposure_bill_detail_entity.setSrl_no(String.valueOf(Mis_exposure_bill_detail_rep.Generatesrl_no()));

			if ("USR-M".equalsIgnoreCase(ROLEID) || "USR-C".equalsIgnoreCase(ROLEID)) {

				Mis_exposure_bill_detail_entity.setBranch_name(BRANCHNAME);
			}

			md.addAttribute("billdata", Mis_exposure_bill_detail_entity);
			md.addAttribute("Counterpartynamelist", Counterparty_Reps.Getcounterpartyname());

		} else if ("Editbilldetail".equalsIgnoreCase(formmode)) {

			md.addAttribute("formmode", formmode);
			md.addAttribute("menuname", "Bill detail operation - Edit");
			md.addAttribute("Todateselected", Report_date);
			System.out.println("Edit Exposure Menu Received bill detail is : " + Exposurebillid);
			System.out.println("Report date for bill : " + Report_date);
			md.addAttribute("billdata", Mis_exposure_bill_detail_rep.getbilldetail(Exposurebillid, Report_date));
			md.addAttribute("Counterpartynamelist", Counterparty_Reps.Getcounterpartyname());

		} else if ("Deletebilldetail".equalsIgnoreCase(formmode)) {

			md.addAttribute("formmode", formmode);

			md.addAttribute("menuname", "Bill detail operation - Delete");
			md.addAttribute("billdata", Mis_exposure_bill_detail_rep.getbilldetail(Exposurebillid, Report_date));
			md.addAttribute("Counterpartynamelist", Counterparty_Reps.Getcounterpartyname());
		} else if ("Verifybilldetail".equalsIgnoreCase(formmode)) {

			md.addAttribute("formmode", formmode);
			md.addAttribute("menuname", "Bill detail operation - Verify");
			md.addAttribute("billdata", Mis_exposure_bill_detail_rep.getbilldetail(Exposurebillid, Report_date));
			md.addAttribute("Counterpartynamelist", Counterparty_Reps.Getcounterpartyname());
		} else {
			logger.info("Opening file upload mode for counterparty. User: '{}', Branch: '{}'", userid, BRANCHNAME);
			md.addAttribute("menu", "List Of Counterparty"); // Default menu label
			md.addAttribute("menu", "Upload File Of Counterparty");
			md.addAttribute("formmode", "add");
			md.addAttribute("userid", userid);

			if ("ADM-M".equalsIgnoreCase(ROLEID) || "ADM-C".equalsIgnoreCase(ROLEID)
					|| "MGR".equalsIgnoreCase(ROLEID)) {
				List<String> codes = UserProfileReps.getallcodes();
				logger.info("Counter party bank code Size: '{}', Role id is :'{}'", codes.size(), ROLEID);
				md.addAttribute("codes", codes);
			}
			// Add for all roles
			md.addAttribute("BRANCHCODE", BRANCHCODE);
			md.addAttribute("BRANCHNAME", BRANCHNAME);
			md.addAttribute("ROLEID", ROLEID);

			System.out.println("ROLEID--" + ROLEID);

		}

		return "MIS/counterpart_list.html";
	}

	@RequestMapping(value = "/asl_dashboard", method = { RequestMethod.GET, RequestMethod.POST })
	public String asl_dashboard(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String reportDate, Model md, HttpServletRequest req) {
		String domIds = ((String) req.getSession().getAttribute("DOMAINID")).trim();
		md.addAttribute("dom_ids", domIds); // To highlight the menu
		if (formmode == null || formmode.equals("list")) {
			logger.info("list of Final Risk View.");
			md.addAttribute("formmode", "list");
			Date currentDate = new Date(); // current system date
			List<BankLimit_Entity> banklist = banklimit_rep.getalllist(currentDate);
			md.addAttribute("list", banklist);
			md.addAttribute("currentDate", currentDate);

			// Bank Limit
			md.addAttribute("Bank_limit_size", banklist.size());
			// Exposure Datas:-
			List<ASL_Report_Entity> Exposure = ASL_Report_Reps.getAllListByDate(currentDate);
			md.addAttribute("Exposure_size", Exposure.size());
			// List Of Treasury Placements
			List<MIS_TREASURY_PLACEMENT_ENTITY> placements = Mis_treasury_placement_repo.getAllListByDate(currentDate);
			md.addAttribute("placements_size", placements.size());
			/// List Of Treasury Limits
			// List<MIS_TREASURY_LIMITS_ENTITY> limits =
			/// MIS_TREASURY_LIMITS_ENTITY_REPs.getAllListByDate(currentDate);
			// md.addAttribute("Treasry_size", limits.size());
			/// swap_settlement
			List<MIS_SETTLEMENT_ENTITY> swapList = MIS_SETTLEMENT_ENTITY_REPs.getAllListByDate(currentDate);
			md.addAttribute("swap_size", swapList.size());

		} else if (formmode.equals("search")) {
			logger.info("list of Final Risk View.");
			md.addAttribute("formmode", "list");
			Date reportDateConverted = java.sql.Date.valueOf(reportDate); // current system date
			md.addAttribute("list", banklimit_rep.getalllist(reportDateConverted));
			md.addAttribute("currentDate", reportDateConverted);

			// Exposure Datas:-
			List<ASL_Report_Entity> Exposure = ASL_Report_Reps.getAllListByDate(reportDateConverted);
			md.addAttribute("Exposure_size", Exposure.size());
			// List Of Treasury Placements
			List<MIS_TREASURY_PLACEMENT_ENTITY> placements = Mis_treasury_placement_repo
					.getAllListByDate(reportDateConverted);
			md.addAttribute("placements_size", placements.size());
			/// List Of Treasury Limits
			List<MIS_TREASURY_LIMITS_ENTITY> limits = MIS_TREASURY_LIMITS_ENTITY_REPs
					.getAllListByDate(reportDateConverted);
			md.addAttribute("Treasry_size", limits.size());
			/// swap_settlement
			List<MIS_SETTLEMENT_ENTITY> swapList = MIS_SETTLEMENT_ENTITY_REPs.getAllListByDate(reportDateConverted);
			md.addAttribute("swap_size", swapList.size());

		}
		logger.info("Returning view: Asl_dashboard");

		return "MIS/Asl_dashboard";
	}

	@RequestMapping(value = "/CallmanualReconprocedurerun", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<?> CallmanualReconprocedurerun(
			@RequestParam("report_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date reportDate) {

		String msg = "";
		System.out.println("Reconciliation Started");

		// Format the date to '27-MAY-2025'
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		String formattedDate = sdf.format(reportDate).toUpperCase();

		// Call stored procedure with 1 VARCHAR2 parameter

		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("RT_ASL_FINAL_STATEMENT_GENERATE_PROCEDURE");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, formattedDate);
		query.execute();

		msg = "Reconciliation completed for " + formattedDate;

		return ResponseEntity.ok(msg);
	}

	@RequestMapping(value = "Add_ASL", method = { RequestMethod.POST })
	@ResponseBody
	public String Add_ASL(@RequestParam("iBranchCode") String iBranchCode,
			@RequestParam("iBranchName") String iBranchName,
			@RequestParam("reportDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reportDate,
			@RequestParam("file") MultipartFile file, @RequestParam("uploadedBy") String uploadedBy,
			HttpServletRequest request, @RequestParam(required = false) String mode) {
		mode = (mode == null) ? "" : mode.trim().toLowerCase();

		logger.info("Upload mode received: [{}]", mode);
		String msg = "";
		String userid = (String) request.getSession().getAttribute("USERID");
		if (mode.equals("exposure")) {
			logger.info("Enter theExposure data Upload File: " + "Branch: " + iBranchCode + ", File: "
					+ file.getOriginalFilename());
			msg = ASL_Excel_Servicess.addASL(iBranchCode, iBranchName, reportDate, uploadedBy, file, userid, mode);
		} else if (mode.equals("placement")) {
			logger.info("Enter theExposure data Upload File: " + "Branch: " + iBranchCode + ", File: "
					+ file.getOriginalFilename());
			msg = ASL_Excel_Servicess.addASL(iBranchCode, iBranchName, reportDate, uploadedBy, file, userid, mode);
		} else if (mode.equals("settlement")) {
			logger.info("Enter theExposure data Upload File: " + "Branch: " + iBranchCode + ", File: "
					+ file.getOriginalFilename());
			msg = ASL_Excel_Servicess.addASL(iBranchCode, iBranchName, reportDate, uploadedBy, file, userid, mode);

		}
		return msg;

	}

	@RequestMapping(value = "/getvalues", method = RequestMethod.POST)
	@ResponseBody
	public List<BRF_095_A_REPORT_ENTITY> getvalues(@RequestParam(required = false) String year) {
		logger.info("Received request to fetch BRF095A values for year: {}", year);

		List<BRF_095_A_REPORT_ENTITY> resultList = null;
		try {
			resultList = BRF095AServiceRepos.getvalues(year);
			logger.info("Successfully fetched {} records for year: {}", (resultList != null ? resultList.size() : 0),
					year);
		} catch (Exception e) {
			logger.error("Error while fetching BRF095A values for year {}: {}", year, e.getMessage(), e);
		}

		return resultList;
	}

	// Fetch bank details by bank name
	@RequestMapping(value = "/loadbankdata", method = RequestMethod.POST)
	@ResponseBody
	public List<ASL_BANKMASTER_ENTITY> getBankDetailss(@RequestParam(required = false) String name) {
		logger.info("Fetching bank details for bank name: {}", name);

		List<ASL_BANKMASTER_ENTITY> bankDetails = ASL_BANKMASTER_REPO.getBankDetails(name);

		logger.info("Found {} bank record(s) for name: {}", bankDetails.size(), name);

		return bankDetails;
	}

	@RequestMapping(value = "/banks", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getAllBanks() {
		logger.info("Fetching all distinct bank names");

		List<String> bankNames = ASL_BANKMASTER_REPO.findDistinctBankNames();

		logger.info("Total banks retrieved: {}", bankNames.size());

		return bankNames;
	}

	@RequestMapping(value = "/loadOverallTop10BRF39", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> loadOverallTop10BRF39Data(HttpServletRequest req) {
		logger.info("Entered /loadOverallTop10BRF39 ");

		List<Map<String, Object>> list = counter_servicess.loadOverallTop10BRF39Data();
		return list;
	}

	@RequestMapping(value = "/getcounterpartylist", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getcounterpartylist(HttpServletRequest req) {
		logger.info("Entered /getcounterpartylist ");

		List<Map<String, Object>> list = counter_servicess.getcounterpartylist();
		return list;
	}

	private String getCurrentYear() {
		return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
	}

	@RequestMapping(value = "/individualraw", method = RequestMethod.GET)
	@ResponseBody
	public List<BRF40_Entity1> getRawIndividualExposureData(
			@RequestParam(name = "year", required = false) String yearParam) {

		String year = (yearParam == null || yearParam.trim().isEmpty()) ? getCurrentYear() : yearParam;
		logger.info("Fetching individual raw exposure data for year: {}", year);

		try {
			List<BRF40_Entity1> data = brf40aRepository.getassetvalues(year);
			if (data == null || data.isEmpty()) {
				logger.warn("No data found for year: {}", year);
				return new ArrayList<>();
			}
			logger.info("Fetched {} records for year: {}", data.size(), year);
			return data;
		} catch (Exception e) {
			logger.error("Error while fetching individual raw exposure data for year: {}", year, e);
			return new ArrayList<>();
		}
	}

	@RequestMapping(value = "/corporateraw", method = RequestMethod.GET)
	@ResponseBody
	public List<BRF40_Entity1> getRawCorporateExposureData(
			@RequestParam(name = "year", required = false) String yearParam) {

		String year = (yearParam == null || yearParam.trim().isEmpty()) ? getCurrentYear() : yearParam;
		logger.info("Fetching corporate raw exposure data for year: {}", year);

		try {
			List<BRF40_Entity1> data = brf40aRepository.getassetvalues(year);
			if (data == null || data.isEmpty()) {
				logger.warn("No corporate exposure data found for year: {}", year);
				return new ArrayList<>();
			}
			logger.info("Fetched {} corporate exposure records for year: {}", data.size(), year);
			return data;
		} catch (Exception e) {
			logger.error("Error while fetching corporate exposure data for year: {}", year, e);
			return new ArrayList<>();
		}
	}

	@RequestMapping(value = "/economicsectorsraw", method = RequestMethod.GET)
	@ResponseBody
	public List<BRF40_Entity2> getRawEconomicSectorsExposureData(
			@RequestParam(name = "year", required = false) String yearParam) {

		String year = (yearParam == null || yearParam.trim().isEmpty()) ? getCurrentYear() : yearParam;
		logger.info("Fetching economic sector exposure data for year: {}", year);

		try {
			List<BRF40_Entity2> data = brf40bRepository.getasseteconomicvalues(year);
			if (data == null || data.isEmpty()) {
				logger.warn("No economic sector data found for year: {}", year);
				return new ArrayList<>();
			}
			logger.info("Fetched {} economic sector exposure records for year: {}", data.size(), year);
			return data;
		} catch (Exception e) {
			logger.error("Error occurred while fetching economic sector exposure data for year: {}", year, e);
			return new ArrayList<>();
		}
	}

	@RequestMapping(value = "Interbank_placement", method = { RequestMethod.GET, RequestMethod.POST })
	public String Interbank_placement(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date, Model md,
			HttpServletRequest req) {

		/// From Attributes
		String domIds = ((String) req.getSession().getAttribute("DOMAINID")).trim();
		String userid = (String) req.getSession().getAttribute("USERID");
		String BRANCHCODE = (String) req.getSession().getAttribute("BRANCHCODE");
		String BRANCHNAME = (String) req.getSession().getAttribute("BRANCHNAME");
		String ROLEID = (String) req.getSession().getAttribute("ROLEID");

		LocalDate today = LocalDate.now(); // Get today's date

		if (Report_date != null) {
			Report_date = java.sql.Date.valueOf(normalizeDate(Report_date.toString()));
		} else {
			Report_date = java.sql.Date.valueOf(today.minusDays(0));
		}

		try {

			if (formmode == null || "list".equalsIgnoreCase(formmode)) {
				md.addAttribute("menu", "List Of Treasury Placements");
				md.addAttribute("formmode", "list");
				// Fecth Treasury detail as per date
				List<MIS_TREASURY_PLACEMENT_ENTITY> Treasurydata = Mis_treasury_placement_repo
						.Gettreasurydata(Report_date);
				md.addAttribute("listss", Treasurydata);
				md.addAttribute("Report_date", Report_date);
				logger.info("Fetched {} treasury placements.", Report_date + " " + Treasurydata.size());
			} else if ("add".equalsIgnoreCase(formmode)) {
				logger.info("Opening file upload mode for Treasury Placement. User: '{}', Branch: '{}'", userid,
						BRANCHNAME);
				md.addAttribute("menu", "List Of Treasury Placement"); // Default menu label
				md.addAttribute("menu", "Upload File Of Treasury Placement");
				md.addAttribute("formmode", "add");
				md.addAttribute("userid", userid);

				if ("ADM-M".equalsIgnoreCase(ROLEID) || "ADM-C".equalsIgnoreCase(ROLEID)
						|| "MGR".equalsIgnoreCase(ROLEID)) {
					List<String> codes = UserProfileReps.getallcodes();
					logger.info("Counter party bank code Size: '{}', Role id is :'{}'", codes.size(), ROLEID);
					md.addAttribute("codes", codes);
				}
				// Add for all roles
				md.addAttribute("BRANCHCODE", BRANCHCODE);
				md.addAttribute("BRANCHNAME", BRANCHNAME);
				md.addAttribute("ROLEID", ROLEID);
				md.addAttribute("Report_date", Report_date);
			}

		} catch (Exception e) {
			logger.error("Error in Interbank_placement controller for formmode: {}", formmode, e);
		}

		return "MIS/Interbank_Placements.html";
	}

	@RequestMapping(value = "swap_settlement", method = { RequestMethod.GET, RequestMethod.POST })
	public String swap_settlement(@RequestParam(required = false) String formmode, Model md, HttpServletRequest req) {
		logger.info("Entered swap_settlement controller with formmode: {}", formmode);

		String userid = (String) req.getSession().getAttribute("USERID");
		String BRANCHCODE = (String) req.getSession().getAttribute("BRANCHCODE");
		String BRANCHNAME = (String) req.getSession().getAttribute("BRANCHNAME");
		String ROLEID = (String) req.getSession().getAttribute("ROLEID");

		try {
			md.addAttribute("menu", "List Of Settlement"); // Default menu label
			String domIds = ((String) req.getSession().getAttribute("DOMAINID")).trim();
			md.addAttribute("dom_ids", domIds); // To highlight the menu
			logger.debug("DOMAINID from session: {}", domIds);

			if (formmode == null || "list".equalsIgnoreCase(formmode)) {
				md.addAttribute("formmode", "list");
				List<Map<String, Object>> swapList = counter_servicess.getSwap();
				md.addAttribute("listall", swapList);
				logger.info("Loaded {} swap settlement records", swapList.size());
			} else if ("add".equalsIgnoreCase(formmode)) {
				logger.info("Opening file upload mode for Swap Settlement. User: '{}', Branch: '{}'", userid,
						BRANCHNAME);
				md.addAttribute("menu", "List Of Swap Settlement"); // Default menu label
				md.addAttribute("menu", "Upload File Of Swap Settlement");
				md.addAttribute("formmode", "add");
				md.addAttribute("userid", userid);
				if ("ADM-M".equalsIgnoreCase(ROLEID) || "ADM-C".equalsIgnoreCase(ROLEID)
						|| "MGR".equalsIgnoreCase(ROLEID)) {
					List<String> codes = UserProfileReps.getallcodes();
					logger.info("Counter party bank code Size: '{}', Role id is :'{}'", codes.size(), ROLEID);
					md.addAttribute("codes", codes);
				}
				// Add for all roles
				md.addAttribute("BRANCHCODE", BRANCHCODE);
				md.addAttribute("BRANCHNAME", BRANCHNAME);
				md.addAttribute("ROLEID", ROLEID);
			}

		} catch (Exception e) {
			logger.error("Error occurred in swap_settlement method", e);
		}

		return "MIS/Swap_Settlement.html";
	}

	@GetMapping("/getExplosure_datas")
	@ResponseBody
	public List<Map<String, Object>> getExplosureDatas(
			@RequestParam("reportDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reportDate,
			@RequestParam("selected_branch") String selected_branch) {

		logger.info("Received request to getExplosureDatas with reportDate: {} and selected_branch: {}", reportDate,
				selected_branch);

		Date reportDateConverted = java.sql.Date.valueOf(reportDate);

		List<Map<String, Object>> response = new ArrayList<>();
		try {
			response = counter_servicess.getExploreData(reportDateConverted, selected_branch);
			logger.info("Fetched {} records for reportDate {} and branch {}", response.size(), reportDate,
					selected_branch);
		} catch (Exception e) {
			logger.error("Error fetching exposure data for reportDate {} and branch {}", reportDate, selected_branch,
					e);
		}

		return response;
	}

	@GetMapping("/getExploreDataBranch")
	@ResponseBody
	public List<Map<String, Object>> getExploreDataBranch(@RequestParam("selected_branch") String selected_branch) {

		Logger logger = LoggerFactory.getLogger(this.getClass());

		logger.info("Received request for branch: {}", selected_branch);

		List<Map<String, Object>> result = new ArrayList<>();
		try {
			result = counter_servicess.getExploreDataBranch(selected_branch);
			logger.info("Fetched {} records for branch: {}", result.size(), selected_branch);
		} catch (Exception e) {
			logger.error("Error while fetching data for branch: {}", selected_branch, e);
		}

		return result;
	}

	@GetMapping("/getTre_limit_Datas")
	@ResponseBody
	public List<Map<String, Object>> getTre_limit_Datas(
			@RequestParam("reportDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reportDate) {

		Logger logger = LoggerFactory.getLogger(this.getClass());
		logger.info("Received request to fetch Treasury Limit Data for report date: {}", reportDate);

		Date reportDateConverted = java.sql.Date.valueOf(reportDate);

		List<Map<String, Object>> result = new ArrayList<>();
		try {
			result = counter_servicess.getTre_limit_Datas(reportDateConverted);
			logger.info("Fetched {} treasury limit records for report date {}", result.size(), reportDate);
		} catch (Exception e) {
			logger.error("Error fetching treasury limit data for report date: {}", reportDate, e);
		}

		return result;
	}

	@GetMapping("/getSwap_Datas")
	@ResponseBody
	public List<Map<String, Object>> getSwap_Datas(
			@RequestParam("reportDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reportDate) {
		logger.info("Received request to fetch Swap settlement Data for report date: {}", reportDate);

		Date reportDateConverted = java.sql.Date.valueOf(reportDate);

		List<Map<String, Object>> result = new ArrayList<>();
		try {
			result = counter_servicess.getSwap_Datas(reportDateConverted);
			logger.info("Fetched {}  Swap settlement records for report date {}", result.size(), reportDate);
		} catch (Exception e) {
			logger.error("Error fetching  Swap settlement data for report date: {}", reportDate, e);
		}
		return result;

	}

	@RequestMapping(value = "search_date", method = RequestMethod.GET)
	@ResponseBody
	public int search_date(
			@RequestParam("reportDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reportDate,
			@RequestParam("iBranchCode") String iBranchCode, @RequestParam(required = false) String mode) {

		Logger logger = LoggerFactory.getLogger(this.getClass());

		mode = (mode == null) ? "" : mode.trim().toLowerCase();
		logger.info("Searching data | Date: {} | Branch: {} | Mode: {}", reportDate, iBranchCode, mode);

		int size = 0;

		try {
			if ("exposure".equals(mode)) {
				size = ASL_Report_Reps.getByReportDateAndBR(java.sql.Date.valueOf(reportDate), iBranchCode).size();

			} else if ("placement".equals(mode)) {
				size = Mis_treasury_placement_repo.getByReportDateAndBR(java.sql.Date.valueOf(reportDate), iBranchCode)
						.size();

			} else if ("settlement".equals(mode)) {
				size = MIS_SETTLEMENT_ENTITY_REPs.getByReportDateAndBR(java.sql.Date.valueOf(reportDate), iBranchCode)
						.size();
			}
		} catch (Exception e) {
			logger.error("Error while checking existing data", e);
			return 0;
		}

		logger.info("Final record count returned to UI = {}", size);
		return size; // ✔ 0 = NOT EXISTS | >0 = EXISTS
	}

	@RequestMapping(value = "Replace_data", method = { RequestMethod.POST })
	@ResponseBody
	public String Replace_data(@RequestParam("iBranchCode") String iBranchCode,
			@RequestParam("iBranchName") String iBranchName,
			@RequestParam("reportDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reportDate,
			@RequestParam("file") MultipartFile file, @RequestParam("uploadedBy") String uploadedBy,
			HttpServletRequest request, @RequestParam(required = false) String mode) {
		Logger logger = LoggerFactory.getLogger(this.getClass());
		String userid = (String) request.getSession().getAttribute("USERID");

		logger.info(
				"Replace_data called - BranchCode: {}, BranchName: {}, ReportDate: {}, File: {}, UploadedBy: {}, UserID: {}",
				iBranchCode, iBranchName, reportDate, file.getOriginalFilename(), uploadedBy, userid);
		String result;
		try {
			result = ASL_Excel_Servicess.Replace_data(iBranchCode, iBranchName, reportDate, uploadedBy, file, userid,
					mode);
			logger.info("Replace_data processed successfully for BranchCode: {}", iBranchCode);
		} catch (Exception e) {
			logger.error("Error during Replace_data for BranchCode: {}", iBranchCode, e);
			result = "Failed to process replacement data.";
		}

		return result;
	}

	@RequestMapping(value = "getbranch", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String getbranch(@RequestParam(required = false) String selected_branch) {
		return counter_servicess.getbranch(selected_branch);
	}

	@RequestMapping(value = "/downloadTradeleveldataderivativeExcel", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> downloadTradeleveldataderivativeExcel(HttpServletRequest req,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		logger.info("Controller: Received request for Trade Level Data Derivative Excel download.");

		try {
			byte[] excelData = tradeleveldataderivativeService.generateTradeleveldataderivativeExcel(Report_date);

			if (excelData.length == 0) {
				logger.warn(
						"Controller: No data found for Trade Level Data Derivative report. Responding with 204 No Content.");
				return ResponseEntity.noContent().build();
			}

			ByteArrayResource resource = new ByteArrayResource(excelData);

			String filename = "CBUAE_Trade_Level_Data_Derivatives_Template.xlsx";
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

			logger.info("Controller: Sending file '{}' to client ({} bytes).", filename, excelData.length);
			
			String userid = (String) req.getSession().getAttribute("USERID");

			auditService.createBusinessAudit(userid, "DOWNLOAD", "TRADE_LEVEL_DATA_DERIVATVE_EXCEL", null, "BCBUAE_TRADE_LEVEL_DERIVATIVES");

			return ResponseEntity.ok().headers(headers).contentLength(excelData.length)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(resource);

		} catch (FileNotFoundException e) {
			logger.error("Controller ERROR: Trade Level Data Derivative Excel template file not found.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (Exception e) {
			logger.error("Controller ERROR: Unexpected error occurred during file generation.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "Trade_Level_Data_Derivatives", method = RequestMethod.GET)
	public String Tradeleveldataderivatives(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String SI_NO, Model md, HttpServletRequest req,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {

		  LocalDate today = LocalDate.now();
		   String formattedDate = null;
		   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		   
		   // ✅ Convert Report_date → String safely
		   if (Report_date != null) {
		       formattedDate = sdf.format(Report_date);
		   }
		   
		if ("edit".equalsIgnoreCase(formmode) && SI_NO != null && !SI_NO.isEmpty()) {
			RT_TradeLevelDataDerivatives data = tradeleveldataderivativesRepo.getParticularDataBySI_NO(SI_NO);
			md.addAttribute("tradeleveldataderivative", data);
			System.out.println("edit is formmode");
			md.addAttribute("formmode", "edit");
			md.addAttribute("lastDate",LocalDate.parse(sdf.format(data.getReport_date()), formatter) );

		} else if ("list".equalsIgnoreCase(formmode)) {
//			md.addAttribute("branchList", tradeleveldataderivativesRepo.getlist(Report_date));
//			System.out.println("list is formmode");
//			md.addAttribute("formmode", "list");
//			md.addAttribute("lastDate",LocalDate.parse(formattedDate, formatter) );

			if (Report_date == null) {
			    md.addAttribute("branchList", Collections.emptyList());
			} else {
			    List<RT_TradeLevelDataDerivatives> list = tradeleveldataderivativesRepo.getlist(Report_date);
			    md.addAttribute("branchList", list != null ? list : Collections.emptyList());
			}
			System.out.println("list is formmode");
			md.addAttribute("formmode", "list");
			if (formattedDate != null && !formattedDate.trim().isEmpty()) {
			    md.addAttribute("lastDate", LocalDate.parse(formattedDate, formatter));
			} else {
			    LocalDate endDateFallback = null; 
			    md.addAttribute("lastDate", endDateFallback);
			}
			
			
		} else {
			Timestamp lastdatetimestamp = tradeleveldataderivativesRepo.findLastReportDate();
			Timestamp secondlastdatetimestamp = nostroAccBalRepo.findSecondLastReportDate();
			 String lastDateString = null;
		     String secondLastDateString = null;
		     LocalDate lastDate = null;
					
			
			if (lastdatetimestamp != null) {
	            lastDate = lastdatetimestamp.toLocalDateTime().toLocalDate();
	            lastDateString = lastdatetimestamp.toLocalDateTime().format(formatter);
	        }

	        if (secondlastdatetimestamp != null) {
	            secondLastDateString = secondlastdatetimestamp.toLocalDateTime().format(formatter);
	        }
			RT_DataControl data= RT_DatacontrolRepository.getdata(lastDateString,"CBUAE_Trade_Level_Data_Derivative_Template");
			RT_DataControl secondlastdata= RT_DatacontrolRepository.getdata(secondLastDateString,"CBUAE_Trade_Level_Data_Derivatives_Template");
			RT_DataControl report_datedata = null;
			
			 if (formattedDate != null) {
		            report_datedata = RT_DatacontrolRepository.getdata(formattedDate, "CBUAE_Trade_Level_Data_Derivative_Template");
		        }
		        
		        System.out.println(formattedDate);

		        // ✅ FIXED NULL CHECKS
		        if (report_datedata != null) {
		        	System.out.println(formattedDate);
		        	lastDate = LocalDate.parse(formattedDate, formatter);
		            md.addAttribute("data", report_datedata);
		            md.addAttribute("formmode", "exist");
		        }
			
			else if(data != null && !data.equals(null)) {
				md.addAttribute("data", data);
				md.addAttribute("formmode", "exist");
			}
			else if(secondlastdata != null && !secondlastdata.equals(null)){
				md.addAttribute("data", secondlastdata);
				md.addAttribute("formmode", "exist");
			}else {
				md.addAttribute("formmode", "add");
				md.addAttribute("formmode", "null");
			}
			md.addAttribute("lastDate", lastDate);
			md.addAttribute("bankname", "Bank of Baroda");

			// You had md.addAttribute("formmode", "null"); — removed this line because it
			// would overwrite the previous one
		}

		List<RT_BankNameMaster> bankList = bankRepo.findAllByOrderByBankNameAsc();
		md.addAttribute("bankList", bankList);

		return "RT/Trade_Level_Data_Derivatives";
	}

	@PostMapping("/updatetradeleveldataderivative")
	@ResponseBody
	public String updatetradeleveldataderivative(
			@ModelAttribute RT_TradeLevelDataDerivatives tradeleveldataderivative) {
		boolean updated = tradeleveldataderivativeService.updatetradeleveldataderivative(tradeleveldataderivative);

		if (updated) {
			return "Updated successfully";
		} else {
			return "Record not found for update";
		}

	}

	@Autowired
	RT_CCR_DATA_TEMPLATE_REPOSITORY ccr_data_template_repository;

	/*
	 * CCR_Data_Templates CREATED BY : SANJEEVI S
	 * 
	 */
	@PersistenceContext
	private EntityManager entityManager;

	@RequestMapping(value = "CCR_Data_Templates", method = RequestMethod.GET)
	public String CCR_Data_Templates(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String siNo, @RequestParam(required = false) String tab, // changed from
																										// accountNo to
																										// slNo
			Model md, HttpServletRequest req,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		  
		LocalDate today = LocalDate.now();
		    String formattedDate = null;
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		    // ✅ Convert Report_date → String safely
		    if (Report_date != null) {
		        formattedDate = sdf.format(Report_date);
		    }
		if ("edit".equalsIgnoreCase(formmode) && siNo != null) {
			// RT_CCR_DATA_TEMPLATE data = ccr_data_template_repository.editccr(siNo);
			RT_CCR_DATA_TEMPLATE data = ccr_data_template_repository.findById(siNo).orElse(null);
// make sure entity class matches
			md.addAttribute("repoData", data);
			System.out.println("edit is formmode");
			md.addAttribute("formmode", "edit");
			md.addAttribute("lastDate",LocalDate.parse(sdf.format(data.getReportDate()), formatter) );
			System.out.println("marginCallFrequency = " + data.getMarginCallFrequency());
			System.out.println("netCollateralOutstandingAed = " + data.getNetCollateralOutstandingAed());

		} else if ("list".equalsIgnoreCase(formmode)) {

//			List<RT_CCR_DATA_TEMPLATE> repoList = ccr_data_template_repository.getlist(Report_date);
//			System.out.println("testing count" + ccr_data_template_repository.getlist(Report_date).size());
//			;
//			md.addAttribute("repoList1", repoList);
//			System.out.println("list is formmode");
//			md.addAttribute("formmode", "list");
//		    md.addAttribute("lastDate",LocalDate.parse(formattedDate, formatter) );
		    
		    if (Report_date == null) {
			    md.addAttribute("repoList1", Collections.emptyList());
			} else {
			    List<RT_CCR_DATA_TEMPLATE> list = ccr_data_template_repository.getlist(Report_date);
			    md.addAttribute("repoList1", list != null ? list : Collections.emptyList());
			}
			System.out.println("list is formmode");
			md.addAttribute("formmode", "list");
			if (formattedDate != null && !formattedDate.trim().isEmpty()) {
			    md.addAttribute("lastDate", LocalDate.parse(formattedDate, formatter));
			} else {
			    LocalDate endDateFallback = null; 
			    md.addAttribute("lastDate", endDateFallback);
			}
			
			
		} else {
			/*
			 * md.addAttribute("formmode", "add");
			 * 
			 * if ("template".equalsIgnoreCase(tab)) { md.addAttribute("tab", "template"); }
			 * else { md.addAttribute("tab", "datacontrols"); // fallback default }
			 */
			        Timestamp lastdatetimestamp = ccr_data_template_repository.findLastReportDate();
			        Timestamp secondlastdatetimestamp = ccr_data_template_repository.findSecondLastReportDate();

			        

			        String lastDateString = null;
			        String secondLastDateString = null;
			        LocalDate lastDate = null;

			        // ✅ NULL SAFE
			        if (lastdatetimestamp != null) {
			            lastDate = lastdatetimestamp.toLocalDateTime().toLocalDate();
			            lastDateString = lastdatetimestamp.toLocalDateTime().format(formatter);
			        }

			        if (secondlastdatetimestamp != null) {
			            secondLastDateString = secondlastdatetimestamp.toLocalDateTime().format(formatter);
			        }

			        RT_DataControl data = RT_DatacontrolRepository.getdata(lastDateString, "CBUAE_CCR_Data_Template");
			        RT_DataControl secondlastdata = RT_DatacontrolRepository.getdata(secondLastDateString, "CBUAE_CCR_Data_Template");

			        RT_DataControl report_datedata = null;

			        if (formattedDate != null) {
			            report_datedata = RT_DatacontrolRepository.getdata(formattedDate, "CBUAE_CCR_Data_Template");
			        }
			        
			        System.out.println(formattedDate);

			        // ✅ FIXED NULL CHECKS
			        if (report_datedata != null) {
			        	System.out.println(formattedDate);
			        	lastDate = LocalDate.parse(formattedDate, formatter);
			            md.addAttribute("data", report_datedata);
			            md.addAttribute("formmode", "exist");

			        } else if (data != null) {
			        	
			            md.addAttribute("data", data);
			            md.addAttribute("formmode", "exist");

			        } else if (secondlastdata != null) {
			        	lastDate = LocalDate.parse(secondLastDateString, formatter);
			            md.addAttribute("data", secondlastdata);
			            md.addAttribute("formmode", "exist");

			        } else {

			            md.addAttribute("formmode", "add");
			        }
			        
			        md.addAttribute("lastDate", lastDate);
			        md.addAttribute("bankname", "Bank of Baroda");
			    }

			    // ================= DROPDOWNS =================
			    List<RT_BankNameMaster> bankList = bankRepo.findAllByOrderByBankNameAsc();
			    List<RT_CountryRiskDropdown> countryList = countryRepo.findAllByOrderByCountryOfRiskAsc();

			    md.addAttribute("bankList", bankList);
			    md.addAttribute("countryList", countryList);

		return "RT/CCR_Data_Templates";
	}

	@PostMapping("/updateCCRData")
	@ResponseBody
	public String updateCCRData(@ModelAttribute("repoData") RT_CCR_DATA_TEMPLATE repoData,
			RedirectAttributes redirectAttributes) {

		boolean updated = rtCCRDataService.updateCCRData(repoData);

		/*
		 * if (updated) { redirectAttributes.addFlashAttribute("updateMsg",
		 * "Updated Successfully"); } else {
		 * redirectAttributes.addFlashAttribute("updateMsg",
		 * "Record not found for update"); }
		 * 
		 * return "redirect:/Treasury_Credit_Limit_Management?formmode=list";
		 */

		if (updated) {
			return "Updated successfully";
		} else {
			return "Record not found for update";
		}
	}

	@Autowired
	private RT_CCR_DATA_Service rtCCRDataService;

	@RequestMapping(value = "/downloadCCRDataExcel", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> downloadCCRDataExcel(HttpServletRequest req,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		logger.info("Controller: Received request for CCR DATA Excel download.");

		try {
			byte[] excelData = rtCCRDataService.generateCCRDataExcel(Report_date);

			if (excelData.length == 0) {
				logger.warn("Controller: Service returned no data for CCR DATA. Responding with 204 No Content.");
				return ResponseEntity.noContent().build();
			}

			ByteArrayResource resource = new ByteArrayResource(excelData);

			HttpHeaders headers = new HttpHeaders();
			String filename = "CBUAE_CCR_Data_Template.xlsx";
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

			logger.info("Controller: Sending file '{}' to client ({} bytes).", filename, excelData.length);
			
			String userid = (String) req.getSession().getAttribute("USERID");

			auditService.createBusinessAudit(userid, "DOWNLOAD", "CCR_DATA_TEMPLATE_EXCEL", null, "BCBUAE_CCR_DATA_TABLE");

			return ResponseEntity.ok().headers(headers).contentLength(excelData.length)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(resource);

		} catch (FileNotFoundException e) {
			logger.error("Controller ERROR: The CBUAE_CCR_Data_Template.xls template file was not found.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (Exception e) {
			logger.error("Controller ERROR: A critical error occurred during CCR_DATA file generation.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "Foreign_Currency_Deposit", method = RequestMethod.GET)
	public String Foreigncurrencydeposit(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String SI_NO, Model md, HttpServletRequest req,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {

		LocalDate today = LocalDate.now();
		   String formattedDate = null;
		   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		   
		   // ✅ Convert Report_date → String safely
		   if (Report_date != null) {
		       formattedDate = sdf.format(Report_date);
		   }
		if ("edit".equalsIgnoreCase(formmode) && SI_NO != null && !SI_NO.isEmpty()) {
			RT_ForeignCurrencyDeposit data = foreigncurrencydepositRepo.getParticularDataBySI_NO(SI_NO);
			md.addAttribute("foreigncurrencydeposit", data);
			System.out.println("edit is formmode");
			md.addAttribute("formmode", "edit");
			md.addAttribute("lastDate", LocalDate.parse(sdf.format(data.getDate()), formatter));

		} else if ("list".equalsIgnoreCase(formmode)) {
//			md.addAttribute("branchList", foreigncurrencydepositRepo.getlist(Report_date));
//			System.out.println("list is formmode");
//			md.addAttribute("formmode", "list");
//			md.addAttribute("lastDate",LocalDate.parse(formattedDate, formatter) );
			
			if (Report_date == null) {
			    md.addAttribute("branchList", Collections.emptyList());
			} else {
			    List<RT_ForeignCurrencyDeposit> list = foreigncurrencydepositRepo.getlist(Report_date);
			    md.addAttribute("branchList", list != null ? list : Collections.emptyList());
			}
			System.out.println("list is formmode");
			md.addAttribute("formmode", "list");
			if (formattedDate != null && !formattedDate.trim().isEmpty()) {
			    md.addAttribute("lastDate", LocalDate.parse(formattedDate, formatter));
			} else {
			    LocalDate endDateFallback = null; 
			    md.addAttribute("lastDate", endDateFallback);
			}
			

		} else {
			Timestamp lastdatetimestamp = foreigncurrencydepositRepo.findLastReportDate();
			Timestamp secondlastdatetimestamp = nostroAccBalRepo.findSecondLastReportDate();
			 String lastDateString = null;
		     String secondLastDateString = null;
		     LocalDate lastDate = null;
					
			
			if (lastdatetimestamp != null) {
	            lastDate = lastdatetimestamp.toLocalDateTime().toLocalDate();
	            lastDateString = lastdatetimestamp.toLocalDateTime().format(formatter);
	        }

	        if (secondlastdatetimestamp != null) {
	            secondLastDateString = secondlastdatetimestamp.toLocalDateTime().format(formatter);
	        }
			RT_DataControl data= RT_DatacontrolRepository.getdata(lastDateString,"CBUAE_Cross_Currency_Funding_Spread_Template");
			RT_DataControl secondlastdata= RT_DatacontrolRepository.getdata(secondLastDateString,"CBUAE_Cross_Currency_Funding_Spread_Template");
			RT_DataControl report_datedata = null;
			
			 if (formattedDate != null) {
		            report_datedata = RT_DatacontrolRepository.getdata(formattedDate, "CBUAE_Cross_Currency_Funding_Spread_Template");
		        }
		        
		        System.out.println(formattedDate);

		        // ✅ FIXED NULL CHECKS
		        if (report_datedata != null) {
		        	System.out.println(formattedDate);
		        	lastDate = LocalDate.parse(formattedDate, formatter);
		        	md.addAttribute("data", report_datedata);
		        	md.addAttribute("formmode", "exist");
		        }
			
			else if(data != null && !data.equals(null)) {
				md.addAttribute("data", data);
				md.addAttribute("formmode", "exist");
			}
			else if(secondlastdata != null && !secondlastdata.equals(null)){
				md.addAttribute("data", secondlastdata);
				md.addAttribute("formmode", "exist");
			}else {
				md.addAttribute("formmode", "add");
				md.addAttribute("formmode", "null");
			}
			md.addAttribute("lastDate", lastDate);
			md.addAttribute("bankname", "Bank of Baroda");

			// You had md.addAttribute("formmode", "null"); — removed this line because it
			// would overwrite the previous one
		}

		List<RT_BankNameMaster> bankList = bankRepo.findAllByOrderByBankNameAsc();
		List<RT_CountryRiskDropdown> countryList = countryRepo.findAllByOrderByCountryOfRiskAsc();
		md.addAttribute("bankList", bankList);
		md.addAttribute("countryList", countryList);

		return "RT/Foreign_Currency_Deposit";
	}

	@PostMapping("/updateForeignCurrencyDeposit")
	@ResponseBody
	public String updateForeignCurrencyDeposit(@ModelAttribute RT_ForeignCurrencyDeposit fxriskData) {
		boolean updated = foreigncurrencydepositService.updateForeignCurrencyDeposit(fxriskData);

		if (updated) {
			return "Update successful";
		} else {
			return "Record not found for update";
		}
	}

	@RequestMapping(value = "Impact_Analysis", method = RequestMethod.GET)
	public String ImpactAnalysis(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String SI_NO, Model md, HttpServletRequest req,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {

		LocalDate today = LocalDate.now();
		   String formattedDate = null;
		   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		   
		   // ✅ Convert Report_date → String safely
		   if (Report_date != null) {
		       formattedDate = sdf.format(Report_date);
		   }
		if ("edit".equalsIgnoreCase(formmode) && SI_NO != null && !SI_NO.isEmpty()) {
			RT_ImpactAnalysis data = impactanalysisRepo.getParticularDataBySI_NO(SI_NO);
			md.addAttribute("ImpactAnalysis", data);
			System.out.println("edit is formmode");
			md.addAttribute("formmode", "edit");
			md.addAttribute("lastDate", LocalDate.parse(sdf.format(data.getDate()), formatter));

		} else if ("list".equalsIgnoreCase(formmode)) {
//			md.addAttribute("branchList", impactanalysisRepo.getlist(Report_date));
//			System.out.println("list is formmode");
//			md.addAttribute("formmode", "list");
//			md.addAttribute("lastDate",LocalDate.parse(formattedDate, formatter) );
			
			if (Report_date == null) {
			    md.addAttribute("branchList", Collections.emptyList());
			} else {
			    List<RT_ImpactAnalysis> list = impactanalysisRepo.getlist(Report_date);
			    md.addAttribute("branchList", list != null ? list : Collections.emptyList());
			}
			System.out.println("list is formmode");
			md.addAttribute("formmode", "list");
			if (formattedDate != null && !formattedDate.trim().isEmpty()) {
			    md.addAttribute("lastDate", LocalDate.parse(formattedDate, formatter));
			} else {
			    LocalDate endDateFallback = null; 
			    md.addAttribute("lastDate", endDateFallback);
			}
			

		} else {
			md.addAttribute("formmode", "add");
			md.addAttribute("formmode", "null");

			// You had md.addAttribute("formmode", "null"); — removed this line because it
			// would overwrite the previous one
		}

		List<RT_BankNameMaster> bankList = bankRepo.findAllByOrderByBankNameAsc();
		List<RT_CountryRiskDropdown> countryList = countryRepo.findAllByOrderByCountryOfRiskAsc();
		md.addAttribute("bankList", bankList);
		md.addAttribute("countryList", countryList);

		return "RT/ImpactAnalysis";
	}

	@PostMapping("/updateImpactAnalysis")
	@ResponseBody
	public String updateImpactAnalysis(@ModelAttribute RT_ImpactAnalysis impactanalysis) {
		boolean updated = impactanalysisService.updateImpactAnalysis(impactanalysis);

		if (updated) {
			return "Updated successful";
		} else {
			return "Record not found for update";
		}
	}

	/*--IRRBB Data template--*/
	@RequestMapping(value = "IRRBB_data_Template", method = RequestMethod.GET)
	public String IRRBB_data_Template(@RequestParam(required = false) BigDecimal SI_NO, @RequestParam(required = false) Date reportDate,
			@RequestParam(required = false) String scenario,@RequestParam(required = false) String glLevel1,@RequestParam(required = false) String glLevel2,
			@RequestParam(required = false) String glLevel3,@RequestParam(required = false) String optionType,@RequestParam(required = false) String rateType,
			@RequestParam(required = false) String referenceRate,@RequestParam(required = false) String instrumentCurrency,
			@RequestParam(required = false) String formmode, Model md,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		
			String formattedDate = null;
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		    if (Report_date != null) {
		        formattedDate = sdf.format(Report_date);
		    }

		    try {
		if ("edit".equalsIgnoreCase(formmode) || "editear".equalsIgnoreCase(formmode)) {
			//RT_IRRBB_Data_EAR data = IRRBB_EAR_Repository.getParticularDataBySI_NO(SI_NO);
			
			//RT_IRRBB_Data_EAR data =IRRBB_EAR_Repository.findById(SI_NO).orElse(null);
			RT_IRRBB_Data_EAR data =null;

			md.addAttribute("irrbbear", data);
			System.out.println("edit is formmode");
			md.addAttribute("formmode", "editear");

		}

		else if ("editeve".equalsIgnoreCase(formmode)) {
			System.out.println("EVE is formmode");
			//RT_IRRBB_Data_EVE_Template data = IRRB_EVE_Repo.getParticularDataBySI_NO(SI_NO);
			//RT_IRRBB_Data_EVE_Template data =IRRB_EVE_Repo.findById(SI_NO).orElse(null);
			RT_IRRBB_Data_EVE_Template data =null;
			md.addAttribute("irrbbeve", data);
			md.addAttribute("formmode", "editeve");
		}

		else if ("editdiscount".equalsIgnoreCase(formmode)) {
			RT_IRRBB_Data_Discount_Rates data = IRRBB_Data_Template_DiscountRate_repo.getParticularDataBySI_NO(SI_NO);
			md.addAttribute("irrbbdiscount", data); // Same variable name used, if form is reused
			md.addAttribute("formmode", "editdiscount");
		}

		else if ("list".equalsIgnoreCase(formmode)) {
			List<RT_IRRBB_Data_EVE_Template> list = IRRB_EVE_Repo.getAlldetails(Report_date);

			//System.out.println("IRRBB EVE " + IRRB_EVE_Repo.getAlldetails(Report_date).size());
			md.addAttribute("formmode", "list");
			md.addAttribute("ISList", list); // Used in HTML table
			md.addAttribute("lastDate",LocalDate.parse(formattedDate, formatter) );
		} else if ("EAR".equalsIgnoreCase(formmode)) {
			System.out.println("THE EAR REPORT START");
			List<RT_IRRBB_Data_EAR> list = IRRBB_EAR_Repository.getAlldetails(Report_date);
			md.addAttribute("formmode", "EAR");
			md.addAttribute("ISListEar", list); // Used in HTML table
			md.addAttribute("lastDate",LocalDate.parse(formattedDate, formatter) );
			System.out.println("Formmode" + formmode);
		} else if ("DiscountRate".equalsIgnoreCase(formmode)) {
			System.out.println("---- Discount Rate---");
			List<RT_IRRBB_Data_Discount_Rates> list = IRRBB_Data_Template_DiscountRate_repo.getAlldetails(Report_date);
			md.addAttribute("formmode", "DiscountRate");
			md.addAttribute("ISListDiscount", list); // Used in HTML table
			System.out.println("Formmode" + formmode);
			md.addAttribute("lastDate",LocalDate.parse(formattedDate, formatter) );
		}
		else if ("Reconciliation".equalsIgnoreCase(formmode)) {
			System.out.println("---- Reconciliation Report Start ----");
			if (Report_date == null) {
				Timestamp lastDateTs = Stream.of(
						rt_irrbb_recon_repository.findLastReportDate(),
						IRRB_EVE_Repo.findLastReportDate(),
						IRRBB_EAR_Repository.findLastReportDate(),
						IRRBB_Data_Template_DiscountRate_repo.findLastReportDate()
				).filter(Objects::nonNull).max(Timestamp::compareTo).orElse(null);
				if (lastDateTs != null) {
					Report_date = new Date(lastDateTs.getTime());
					formattedDate = sdf.format(Report_date);
				}
			}
			List<RT_IRRBB_RECON> list = null;
			if (Report_date != null) {
				list = rt_irrbb_recon_repository.getAlldetails(Report_date);
				if (list == null || list.isEmpty()) {
					list = rt_irrbb_recon_repository.getDetailsByReportDate(Report_date);
				}
			}
			if (list == null || list.isEmpty()) {
				list = rt_irrbb_recon_repository.getAllRecords();
			}
			RT_IRRBB_RECON reconSummary = null;
			if (list != null && !list.isEmpty()) {
				for (RT_IRRBB_RECON r : list) {
					if (r.getAssetsLiabilitiesPortfolioDate() != null
							|| r.getAbsoluteDifference() != null
							|| r.getPercentageDifference() != null
							|| r.getReportedBehaviouralRepricingGap() != null
							|| r.getRelativeDifference() != null) {
						reconSummary = r;
						break;
					}
				}
				if (reconSummary == null) {
					reconSummary = list.get(0);
				}
			}
			md.addAttribute("reconSummary", reconSummary);
			md.addAttribute("formmode", "Reconciliation");
			md.addAttribute("ISListRecon", list != null ? list : Collections.emptyList());
			if (formattedDate != null) {
				md.addAttribute("lastDate", LocalDate.parse(formattedDate, formatter));
			} else {
				md.addAttribute("lastDate", LocalDate.now());
			}
			System.out.println("Formmode " + formmode);
		}
		else if ("Detaillist".equalsIgnoreCase(formmode)) {
			List<RT_IRRBB_Data_EVE_Template_Detail> list =rt_irrbb_data_eve_template_detail_rep.getAlldetails(reportDate,scenario,glLevel1,glLevel2,glLevel3,optionType,rateType,referenceRate,instrumentCurrency);
			System.out.println("IRRBB EVE " + list.size());
			md.addAttribute("formmode", "Detaillist");
			md.addAttribute("ISList", list); // Used in HTML table
			md.addAttribute("lastDate",LocalDate.parse(sdf.format(reportDate), formatter) );
		}

		/*
		 * else { model.addAttribute("formmode", "add");
		 * model.addAttribute("securityData", new
		 * RT_Investment_Securities_Data_Template()); }
		 */else {
			 	Timestamp lastdatetimestampeve = IRRB_EVE_Repo.findLastReportDate();
			 	Timestamp lastdatetimestampear = IRRBB_EAR_Repository.findLastReportDate();
			 	Timestamp lastdatetimestampdr = IRRBB_Data_Template_DiscountRate_repo.findLastReportDate();
			 	Timestamp lastdatetimestamprecon = rt_irrbb_recon_repository.findLastReportDate();
			 	Timestamp secondlastdatetimestampeve = IRRB_EVE_Repo.findSecondLastReportDate();
			 	Timestamp secondlastdatetimestampear = IRRBB_EAR_Repository.findSecondLastReportDate();
			 	Timestamp secondlastdatetimestampdr = IRRBB_Data_Template_DiscountRate_repo.findSecondLastReportDate();
			 	Timestamp secondlastdatetimestamprecon = rt_irrbb_recon_repository.findSecondLastReportDate();
				
				Timestamp lastdatetimestamp = Stream
						.of(lastdatetimestampeve, lastdatetimestampear, lastdatetimestampdr, lastdatetimestamprecon).filter(Objects::nonNull)
						.max(Timestamp::compareTo).orElse(null);
				
				Timestamp secondlastdatetimestamp = Stream
						.of(secondlastdatetimestampeve, secondlastdatetimestampear, secondlastdatetimestampdr, secondlastdatetimestamprecon).filter(Objects::nonNull)
						.max(Timestamp::compareTo).orElse(null);
			 	
			 	String lastDateString = null;
		        String secondLastDateString = null;
		        LocalDate lastDate = null;
		        
		        if (lastdatetimestamp != null) {
		            lastDate = lastdatetimestamp.toLocalDateTime().toLocalDate();
		            lastDateString = lastdatetimestamp.toLocalDateTime().format(formatter);
		        }
		        if (secondlastdatetimestamp != null) {
		            secondLastDateString = secondlastdatetimestamp.toLocalDateTime().format(formatter);
		        }
		        
				RT_DataControl data= RT_DatacontrolRepository.getdata(lastDateString,"CBUAE_IRRBB_Data_Template");
				RT_DataControl secondlastdata= RT_DatacontrolRepository.getdata(secondLastDateString,"CBUAE_IRRBB_Data_Template");
				RT_DataControl report_datedata = null;
				

		        if (formattedDate != null) {
		            report_datedata = RT_DatacontrolRepository.getdata(formattedDate, "CBUAE_IRRBB_Data_Template");
		        }
		        System.out.println(formattedDate);

		       if (report_datedata != null) {
		        	System.out.println(formattedDate);
		        	lastDate = LocalDate.parse(formattedDate, formatter);
		            md.addAttribute("data", report_datedata);
		            md.addAttribute("formmode", "exist");

		        }

				else if (data != null && !data.equals(null)) {
					md.addAttribute("data", data);
					md.addAttribute("formmode", "exist");
				}
				else if(secondlastdata != null && !secondlastdata.equals(null)){
					md.addAttribute("data", secondlastdata);
					md.addAttribute("formmode", "exist");
				}else {
					md.addAttribute("formmode", "null");
					md.addAttribute("formmode", "add");
				}
				md.addAttribute("lastDate", lastDate);
				md.addAttribute("bankname", "Bank of Baroda");			 
		}

		List<RT_BankNameMaster> bankList = bankRepo.findAllByOrderByBankNameAsc();
		List<RT_CountryRiskDropdown> countryList = countryRepo.findAllByOrderByCountryOfRiskAsc();

		md.addAttribute("bankList", bankList);
		md.addAttribute("countryList", countryList);
		    } catch (Exception e) {
		    	logger.error("Error fetching data for report date: {}", reportDate, e);
			}
		return "RT/IRRBB_data_Template";
	}

	@RequestMapping(value = "/downloadForeigncurrencyExcel", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> downloadForeigncurrencyExcel(HttpServletRequest req,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		logger.info("Controller: Received request for Foreign Currency Deposit Excel download.");

		try {
			byte[] excelData = foreigncurrencydepositService.generateForeignCurrencyDepositExcel(Report_date);

			if (excelData.length == 0) {
				logger.warn("Controller: No data found for Foreign Currency report. Responding with 204 No Content.");
				return ResponseEntity.noContent().build();
			}

			ByteArrayResource resource = new ByteArrayResource(excelData);
			
			String filename = "CBUAE_Cross_Currency_Funding_Spread_Template.xlsx";
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

			logger.info("Controller: Sending file '{}' to client ({} bytes).", filename, excelData.length);
			
			String userid = (String) req.getSession().getAttribute("USERID");

			auditService.createBusinessAudit(userid, "DOWNLOAD", "CROSS_CURRENCY_FUNDING_SPREAD_EXCEL", null, "BCBUAE_CROSS_CUR_FUNDING_FOREIGN_DEPOSITS");

			return ResponseEntity.ok().headers(headers).contentLength(excelData.length)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(resource);

		} catch (FileNotFoundException e) {
			logger.error("Controller ERROR: Foreign Currency Excel template file not found.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (Exception e) {
			logger.error("Controller ERROR: Unexpected error occurred during file generation.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "/downloadImpactanalysisExcel", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> downloadImpactanalysisExcel(HttpServletRequest req,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		logger.info("Controller: Received request for Impact Analysis Excel download.");

		try {
			byte[] excelData = impactanalysisService.generateImpactAnalysisExcel(Report_date);

			if (excelData.length == 0) {
				logger.warn("Controller: No data found for Impact Analysis report. Responding with 204 No Content.");
				return ResponseEntity.noContent().build();
			}

			ByteArrayResource resource = new ByteArrayResource(excelData);

			String filename ="CBUAE_Cross_Currency_Funding_Spread_Template.xlsx";
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

			logger.info("Controller: Sending file '{}' to client ({} bytes).", filename, excelData.length);
			
			String userid = (String) req.getSession().getAttribute("USERID");

			auditService.createBusinessAudit(userid, "DOWNLOAD", "IMPACT_ANALYSIS_EXCEL", null, "BCBUAE_CROSS_CUR_FUNDING_IMPACT_ANALYSIS");

			return ResponseEntity.ok().headers(headers).contentLength(excelData.length)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(resource);

		} catch (FileNotFoundException e) {
			logger.error("Controller ERROR: Impact Analysis Excel template file not found.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (Exception e) {
			logger.error("Controller ERROR: Unexpected error occurred during file generation.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "Trade_Level_Data_Derivatives_Simplified", method = RequestMethod.GET)
	public String TradeleveldataderivativesSimplified(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String SI_NO, Model md, HttpServletRequest req,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		  LocalDate today = LocalDate.now();
		   String formattedDate = null;
		   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		   
		   // ✅ Convert Report_date → String safely
		   if (Report_date != null) {
		       formattedDate = sdf.format(Report_date);
		   }

		if ("edit".equalsIgnoreCase(formmode) && SI_NO != null && !SI_NO.isEmpty()) {
			RT_TradeLevelDataDerivativesSimplified data = tradeleveldataderivativessimplifiedRepo
					.getParticularDataBySI_NO(SI_NO);
			md.addAttribute("tradeleveldataderivative", data);
			System.out.println("edit is formmode");
			md.addAttribute("formmode", "edit");
			md.addAttribute("lastDate",LocalDate.parse(sdf.format(data.getReport_date()), formatter) );

			
		} else if ("list".equalsIgnoreCase(formmode)) {
//			md.addAttribute("branchList", tradeleveldataderivativessimplifiedRepo.getlist(Report_date));
//			System.out.println("list is formmode");
//			md.addAttribute("formmode", "list");
//			md.addAttribute("lastDate",LocalDate.parse(formattedDate, formatter) );
			
			if (Report_date == null) {
			    md.addAttribute("branchList", Collections.emptyList());
			} else {
			    List<RT_TradeLevelDataDerivativesSimplified> list = tradeleveldataderivativessimplifiedRepo.getlist(Report_date);
			    md.addAttribute("branchList", list != null ? list : Collections.emptyList());
			}
			System.out.println("list is formmode");
			md.addAttribute("formmode", "list");
			if (formattedDate != null && !formattedDate.trim().isEmpty()) {
			    md.addAttribute("lastDate", LocalDate.parse(formattedDate, formatter));
			} else {
			    LocalDate endDateFallback = null; 
			    md.addAttribute("lastDate", endDateFallback);
			}
			
		} else {
			Timestamp lastdatetimestamp = tradeleveldataderivativessimplifiedRepo.findLastReportDate();
			Timestamp secondlastdatetimestamp = nostroAccBalRepo.findSecondLastReportDate();
			 String lastDateString = null;
		     String secondLastDateString = null;
		     LocalDate lastDate = null;
					
			
			if (lastdatetimestamp != null) {
	            lastDate = lastdatetimestamp.toLocalDateTime().toLocalDate();
	            lastDateString = lastdatetimestamp.toLocalDateTime().format(formatter);
	        }

	        if (secondlastdatetimestamp != null) {
	            secondLastDateString = secondlastdatetimestamp.toLocalDateTime().format(formatter);
	        }
			RT_DataControl data= RT_DatacontrolRepository.getdata(lastDateString,"CBUAE_Trade_Level_Data_Derivative_Simplified_Template");
			RT_DataControl secondlastdata= RT_DatacontrolRepository.getdata(secondLastDateString,"CBUAE_Trade_Level_Data_Derivative_Simplified_Template");
			RT_DataControl report_datedata = null;
			
			 if (formattedDate != null) {
		            report_datedata = RT_DatacontrolRepository.getdata(formattedDate, "CBUAE_Trade_Level_Data_Derivative_Simplified_Template");
		        }
		        
		        System.out.println(formattedDate);

		        // ✅ FIXED NULL CHECKS
		        if (report_datedata != null) {
		        	System.out.println(formattedDate);
		        	lastDate = LocalDate.parse(formattedDate, formatter);
		            md.addAttribute("data", report_datedata);
		            md.addAttribute("formmode", "exist");
		        }
			
			else if(data != null && !data.equals(null)) {
				md.addAttribute("data", data);
				md.addAttribute("formmode", "exist");
			}
			else if(secondlastdata != null && !secondlastdata.equals(null)){
				md.addAttribute("data", secondlastdata);
				md.addAttribute("formmode", "exist");
			}else {
				md.addAttribute("formmode", "add");
				md.addAttribute("formmode", "null");
			}
			md.addAttribute("lastDate", lastDate);
			md.addAttribute("bankname", "Bank of Baroda");



			// You had md.addAttribute("formmode", "null"); — removed this line because it
			// would overwrite the previous one
		}

		List<RT_BankNameMaster> bankList = bankRepo.findAllByOrderByBankNameAsc();
		md.addAttribute("bankList", bankList);

		return "RT/Trade_Level_Data_Derivatives_Simplified";
	}

	@PostMapping("/updatetradeleveldataderivativesimplified")
	@ResponseBody
	public String updatetradeleveldataderivativesimplified(
			@ModelAttribute RT_TradeLevelDataDerivatives tradeleveldataderivative) {
		boolean updated = tradeleveldataderivativesimplifiedService
				.updatetradeleveldataderivative(tradeleveldataderivative);

		if (updated) {
			return "Updated successfully";
		} else {
			return "Record not found for update";
		}

	}

	@RequestMapping(value = "/downloadTradeleveldataderivativesimplifiedExcel", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> downloadTradeleveldataderivativesimplifiedExcel(HttpServletRequest req,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		logger.info("Controller: Received request for Trade Level Data Derivative Simplified Excel download.");

		try {
			byte[] excelData = tradeleveldataderivativesimplifiedService
					.generateTradeleveldataderivativesimplifiedExcel(Report_date);
System.out.println("sixe==="+excelData.length);
			if (excelData.length == 0) {
				logger.warn(
						"Controller: No data found for Trade Level Data Derivative Simplified report. Responding with 204 No Content.");
				return ResponseEntity.noContent().build();
			}

			ByteArrayResource resource = new ByteArrayResource(excelData);

			String filename = "CBUAE_Trade_Level_Data_Derivative_Simplified_Template.xlsx";
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

			logger.info("Controller: Sending file '{}' to client ({} bytes).", filename, excelData.length);
			
			String userid = (String) req.getSession().getAttribute("USERID");

			auditService.createBusinessAudit(userid, "DOWNLOAD", "TRADE_LEVEL_DATA_DERIVATVE_SIMPLIFIED_EXCEL", null, "BCBUAE_TRADE_LEVEL_DERIVATIVES_SIMPLIFIED");

			return ResponseEntity.ok().headers(headers).contentLength(excelData.length)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(resource);

		} catch (FileNotFoundException e) {
			logger.error("Controller ERROR: Trade Level Data Derivative Simplified Excel template file not found.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (Exception e) {
			logger.error("Controller ERROR: Unexpected error occurred during file generation.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "/downloadInvestmentriskdatadashboardExcel", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> downloadInvestmentriskdatadashboardExcel(HttpServletRequest req,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		logger.info("Controller: Received request for Investment Risk Data Dashboard Excel download.");

		try {
			byte[] excelData = investmentriskdatadictionaryService.generateInvestmentriskdataExcel(Report_date);

			if (excelData.length == 0) {
				logger.warn(
						"Controller: No data found for Investment Risk Data Dashboard report. Responding with 204 No Content.");
				return ResponseEntity.noContent().build();
			}

			ByteArrayResource resource = new ByteArrayResource(excelData);

			String filename = "CBUAE_Investment Risk Data_Dashboard_Template.xlsx";
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

			logger.info("Controller: Sending file '{}' to client ({} bytes).", filename, excelData.length);
			
			String userid = (String) req.getSession().getAttribute("USERID");

			auditService.createBusinessAudit(userid, "DOWNLOAD", "INVESTMENT_RISK_DATA_DASHBOARD_TEMPLATE_EXCEL", null, "BCBUAE_INVESTMENT_RISK_DATA_DASHBOARD_TEMPLATE");

			return ResponseEntity.ok().headers(headers).contentLength(excelData.length)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(resource);

		} catch (FileNotFoundException e) {
			logger.error("Controller ERROR: Investment Risk Data Dashboard Excel template file not found.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (Exception e) {
			logger.error("Controller ERROR: Unexpected error occurred during file generation.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/* iquidity risk Dashboard template */
	 @Autowired
	    private JdbcTemplate jdbcTemplate;
	private static final Map<String, byte[]> backgroundFileStore = new java.util.concurrent.ConcurrentHashMap<>();

	@RequestMapping(value = "Liquidity_Risk_Dashboard_Template", method = RequestMethod.GET)
	public String Liquidity_Risk_Dashboard_Template(
	        @RequestParam(required = false) String SI_NO,
	        @RequestParam(required = false) String formmode, 
	        @RequestParam(required = false) String report_date,
	        @RequestParam(required = false) String rowid, @RequestParam(required = false) String tablename,
	        Model model) {

		   String formattedDate = null;
		   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		   
		   // report_date is a request String (dd-MM-yyyy or yyyy-MM-dd), not a Date.
		   // SimpleDateFormat.format() only accepts Date and throws IllegalArgumentException on String.
		   if (report_date != null && !report_date.trim().isEmpty()) {
		       try {
		           formattedDate = LocalDate.parse(normalizeDate(report_date.trim())).format(formatter);
		       } catch (Exception e) {
		           formattedDate = report_date.trim();
		       }
		   }
		   
		   
	    // 1. DETAIL SCREEN (Cash -> ROW101 / Due from Banks -> ROW102)
		if ("detail".equalsIgnoreCase(formmode)) {
	    	System.out.println("rowid : "+rowid);
	    	 String sql;
	    	
	    	if("BRF8_MAPPING_TABLE".equals(tablename) || tablename=="BRF8_MAPPING_TABLE") {
	    		sql = "SELECT CUST_ID, FORACID, ACCT_NAME, ACT_BALANCE_AMT_LC AS ACCT_BALANCE_LC, "
		                + "ROWIDTOCHAR(ROWID) AS RID, REPORT_DATE " 
		                + "FROM " + tablename  
		                + " WHERE TO_CHAR(REPORT_DATE, 'DD-MM-YYYY') = ? AND REPORT_LABEL_1 = ? ";
	    		
	    	}
	    	else {   	
	        sql = "SELECT CUST_ID, FORACID, ACCT_NAME, ACCT_BALANCE_LC, "
	                + "ROWIDTOCHAR(ROWID) AS RID, REPORT_DATE " 
	                + "FROM " + tablename  
	                + " WHERE TO_CHAR(REPORT_DATE, 'DD-MM-YYYY') = ? AND REPORT_LABLE_1 = ?";
	    	}
	        
			List<Map<String, Object>> allData = new ArrayList<>();
			String[] rowidarray = rowid.replace(" ", "").split(",");

			for (String singlerowid : rowidarray) {
				Object[] args = new Object[] { formattedDate != null ? formattedDate : report_date, singlerowid.trim() };
				List<Map<String, Object>> data = jdbcTemplate.queryForList(sql, args);

				allData.addAll(data);
			}
		    model.addAttribute("lastDate", formattedDate != null
		            ? LocalDate.parse(formattedDate, formatter)
		            : null);
	        model.addAttribute("reportdetails", allData);
	        model.addAttribute("formmode", "detail");
	        model.addAttribute("rowid", rowid);
	    }
	    // 2. LIST MODE (Main Dashboard Table)
	    else if ("list".equalsIgnoreCase(formmode)) {
//	        model.addAttribute("branchList", LiquidityRiskDashboardRepo.getAlldetails(report_date));
//	        model.addAttribute("formmode", "list");
//	        model.addAttribute("lastDate",LocalDate.parse(report_date, formatter) );
	        
	        if (formattedDate == null) {
	        	model.addAttribute("branchList", Collections.emptyList());
			} else {
			    List<RT_Liquidity_Risk_Dashboard_Template> list = liquidityriskdashboardService.findByReportDate(formattedDate);
			    model.addAttribute("branchList", list != null ? list : Collections.emptyList());
			}
			System.out.println("list is formmode");
			model.addAttribute("formmode", "list");
			if (formattedDate != null && !formattedDate.trim().isEmpty()) {
				model.addAttribute("lastDate", LocalDate.parse(formattedDate, formatter));
			} else {
			    LocalDate endDateFallback = null; 
			    model.addAttribute("lastDate", endDateFallback);
			}
			
	        
	    } 
	    // 3. EDIT MODE
	    else if ("edit".equalsIgnoreCase(formmode) && SI_NO != null) {
	        RT_Liquidity_Risk_Dashboard_Template data = liquidityriskdashboardService.findBySiNo(SI_NO);
	        model.addAttribute("liquidityriskdashboard", data);
	        model.addAttribute("formmode", "edit");
	        if (data != null && data.getReportDate() != null) {
	            model.addAttribute("lastDate", LocalDate.parse(sdf.format(data.getReportDate()), formatter));
	        }
	    }
	    // 4. ADD MODE (Default Data Controls)
	    else {
	    	Timestamp lastdatetimestamp = LiquidityRiskDashboardRepo.findLastReportDate();
			Timestamp secondlastdatetimestamp = LiquidityRiskDashboardRepo.findSecondLastReportDate();	
			String lastDateString = null;
		    String secondLastDateString = null;
		    LocalDate lastDate = null;
		        
		    if (lastdatetimestamp != null) {
	            lastDate = lastdatetimestamp.toLocalDateTime().toLocalDate();
	            lastDateString = lastdatetimestamp.toLocalDateTime().format(formatter);
	        }

	        if (secondlastdatetimestamp != null) {
	            secondLastDateString = secondlastdatetimestamp.toLocalDateTime().format(formatter);
	        }
	        
			RT_DataControl data= RT_DatacontrolRepository.getdata(lastDateString,"CBUAE_Liquidity_Risk_Dashboard_Template");
			RT_DataControl secondlastdata= RT_DatacontrolRepository.getdata(secondLastDateString,"CBUAE_Liquidity_Risk_Dashboard_Template");
			RT_DataControl report_datedata = null;

	        if (formattedDate != null) {
	            report_datedata = RT_DatacontrolRepository.getdata(formattedDate, "CBUAE_Liquidity_Risk_Dashboard_Template");
	        }
	        
	        System.out.println(formattedDate);
	       
	        if (report_datedata != null) {
	        	System.out.println(formattedDate);
	        	lastDate = LocalDate.parse(formattedDate, formatter);
	        	model.addAttribute("data", report_datedata);
	        	model.addAttribute("formmode", "exist");
	        }
			
			else if (data != null && !data.equals(null)) {
				model.addAttribute("data", data);
				model.addAttribute("formmode", "exist");
			}
			else if(secondlastdata != null && !secondlastdata.equals(null)){
				model.addAttribute("data", secondlastdata);
				model.addAttribute("formmode", "exist");
			}else {				
				model.addAttribute("formmode", "null");
				model.addAttribute("formmode", "add");
			}
			model.addAttribute("lastDate", lastDate);
			model.addAttribute("bankname", "Bank of Baroda");
	    }
	    model.addAttribute("bankList", bankRepo.findAllByOrderByBankNameAsc());
	    return "RT/Liquidity_Risk_Dashboard_Template";
	}

	@GetMapping("/startBackgroundJob")
	@ResponseBody
	public String startBackgroundJob(@RequestParam String report_date, @RequestParam String rowid, @RequestParam String tablename) {
	    String jobId = UUID.randomUUID().toString();
	    new Thread(() -> {
	        try {
	        	System.out.println("rowid : " + rowid);

	        	String labelColumn = "BRF8_MAPPING_TABLE".equals(tablename) ? "REPORT_LABEL_1" : "REPORT_LABLE_1";
	        	String balanceColumn = "BRF8_MAPPING_TABLE".equals(tablename) ? "ACT_BALANCE_AMT_LC AS ACCT_BALANCE_LC" : "ACCT_BALANCE_LC";

	        	String sql = "SELECT CUST_ID, FORACID, ACCT_NAME, " + balanceColumn + ", "
	        	           + "ROWIDTOCHAR(ROWID) AS RID, REPORT_DATE "
	        	           + "FROM " + tablename
	        	           + " WHERE TO_CHAR(REPORT_DATE, 'DD-MM-YYYY') = ?";

	        	List<Map<String, Object>> allData = new ArrayList<>();

	        	if ("ALL".equalsIgnoreCase(rowid)) {
	        	    allData = jdbcTemplate.queryForList(sql, new Object[]{report_date});
	        	} else {
	        	    sql += " AND " + labelColumn + " = ?";
	        	    String[] rowidarray = rowid.replace(" ", "").split(",");
	        	    for (String singlerowid : rowidarray) {
	        	        Object[] args = new Object[]{report_date, singlerowid.trim()};
	        	        List<Map<String, Object>> data = jdbcTemplate.queryForList(sql, args);
	        	        allData.addAll(data);
	        	    }
	        	}

	        	if (allData.isEmpty()) {
	        	    backgroundFileStore.put(jobId, "NODATA".getBytes());
	        	    return;
	        	}

	            SXSSFWorkbook workbook = new SXSSFWorkbook(100);
	            Sheet sheet = workbook.createSheet("Detail");
	            ((SXSSFSheet) sheet).trackAllColumnsForAutoSizing();

	            /* --- STYLES --- */
	            Font headFont = workbook.createFont(); headFont.setBold(true);
	            CellStyle headStyle = workbook.createCellStyle(); headStyle.setFont(headFont);
	            setBorders(headStyle);

	            CellStyle dataStyle = workbook.createCellStyle(); setBorders(dataStyle);
	            
	            CellStyle dateStyle = workbook.createCellStyle(); setBorders(dateStyle);
	            dateStyle.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat("dd-MM-yyyy"));

	            /* --- HEADER --- */
	            String[] h = {"CUST ID", "ACCOUNT NO", "NAME", "BALANCE (AED)", "DATE"};
	            Row hr = sheet.createRow(0);
	            for(int i=0; i<h.length; i++) { Cell c = hr.createCell(i); c.setCellValue(h[i]); c.setCellStyle(headStyle); }

	            /* --- DATA --- */
				int rx = 1;
				for (Map<String, Object> m : allData) {
					Row r = sheet.createRow(rx++);
					Object custId = m.get("CUST_ID");
					fillCell(r, 0, custId != null ? custId.toString() : "", dataStyle);
					Object foracid = m.get("FORACID");
					fillCell(r, 1, foracid != null ? foracid.toString() : "", dataStyle);
					Object acctName = m.get("ACCT_NAME");
					fillCell(r, 2, acctName != null ? acctName.toString() : "", dataStyle);
					Cell c3 = r.createCell(3);
					Object balance = m.get("ACCT_BALANCE_LC");
					if (balance != null) {
						c3.setCellValue(Double.parseDouble(balance.toString()));
					}
					c3.setCellStyle(dataStyle);

					Cell c4 = r.createCell(4);
					Object reportDate = m.get("REPORT_DATE");
					if (reportDate instanceof Date) {
						c4.setCellValue((Date) reportDate);
					}
					c4.setCellStyle(dateStyle);
				}

	            for(int i=0; i<h.length; i++) sheet.autoSizeColumn(i);

	            ByteArrayOutputStream bos = new ByteArrayOutputStream();
	            workbook.write(bos);
	            backgroundFileStore.put(jobId, bos.toByteArray());
	            workbook.dispose();
	        } catch (Exception e) { e.printStackTrace(); }
	    }).start();
	    return jobId;
	}

	private void setBorders(CellStyle s) {
	    s.setBorderTop(BorderStyle.THIN); s.setBorderBottom(BorderStyle.THIN);
	    s.setBorderLeft(BorderStyle.THIN); s.setBorderRight(BorderStyle.THIN);
	}
	private void fillCell(Row r, int i, String v, CellStyle s) { Cell c = r.createCell(i); c.setCellValue(v); c.setCellStyle(s); }

	@GetMapping("/checkJobStatus")
	@ResponseBody
	public String checkJobStatus(@RequestParam String jobId) {
	    if (!backgroundFileStore.containsKey(jobId)) return "PROCESSING";
	    return new String(backgroundFileStore.get(jobId)).equals("NODATA") ? "ERROR" : "READY";
	}

	@GetMapping("/getBackgroundFile")
	public ResponseEntity<byte[]> getFile(@RequestParam String jobId) {
	    byte[] data = backgroundFileStore.remove(jobId);
	    return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Detail_Report.xlsx").body(data);
	}

	@PostMapping("/updateliquidityriskdashboard")
	@ResponseBody
	public String updateliquidityriskdashboard(
			@ModelAttribute RT_Liquidity_Risk_Dashboard_Template liquidityriskdashboard) {
		boolean updated = liquidityriskdashboardService.updateliquidityriskdashboard(liquidityriskdashboard);

		if (updated) {
			return "Updated successfully";
		} else {
			return "Record not found for update";
		}

	}

	@RequestMapping(value = "/downloadLiquidityriskdashboardExcel", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> downloadLiquidityriskdashboardExcel(HttpServletRequest req ,@RequestParam(required = false) String report_date) {
		logger.info("Controller: Received request for Liquidity Risk Dashboard Template Excel download.");

		try {
			byte[] excelData = liquidityriskdashboardService.generateLiquidityriskdashboardExcel(report_date);

			if (excelData.length == 0) {
				logger.warn(
						"Controller: No data found for Liquidity Risk Dashboard Template Excel report. Responding with 204 No Content.");
				return ResponseEntity.noContent().build();
			}

			ByteArrayResource resource = new ByteArrayResource(excelData);

			String filename = "Liquidityriskdashboard.xls";
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

			logger.info("Controller: Sending file '{}' to client ({} bytes).", filename, excelData.length);
			
			String userid = (String) req.getSession().getAttribute("USERID");

			auditService.createBusinessAudit(userid, "DOWNLOAD", "LIQUIDITY_RISK_DASHBOARD_TEMPLATE_EXCEL", null, "BCBUAE_LIQUIDITY_RISK_DASHBOARD_TEMPLATE");

			return ResponseEntity.ok().headers(headers).contentLength(excelData.length)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(resource);

		} catch (FileNotFoundException e) {
			logger.error("Controller ERROR: Liquidity Risk Dashboard Template Excel template file not found.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (Exception e) {
			logger.error("Controller ERROR: Unexpected error occurred during file generation.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/updateirrbear")
	@ResponseBody
	public String updateirrbear(@ModelAttribute RT_IRRBB_Data_EAR irrbbear) {
		boolean updated = irrbbearService.updateirrbbear(irrbbear);

		if (updated) {
			return "Updated successfully";
		} else {
			return "Record not found for update";
		}

	}

	@PostMapping("/updateirrbeve")
	@ResponseBody
	public String updateirrbeve(@ModelAttribute RT_IRRBB_Data_EVE_Template irrbbeve) {
		boolean updated = irrbbeveService.updateirrbbeve(irrbbeve);

		if (updated) {
			return "Updated successfully";
		} else {
			return "Record not found for update";
		}

	}

	@PostMapping("/updateirrbdiscount")
	@ResponseBody
	public String updateirrbdiscount(@ModelAttribute RT_IRRBB_Data_Discount_Rates irrbbdiscount) {
		boolean updated = discountratesService.updateirrbbdiscount(irrbbdiscount);

		if (updated) {
			return "Updated successfully";
		} else {
			return "Record not found for update";
		}

	}

	@RequestMapping(value = "/downloadIrrbbeveExcel", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> downloadIrrbbeveExcel(HttpServletRequest req,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		logger.info("Controller: Received request for IRRBB Data EVE Excel download for report date {}.", Report_date);

		try {
			byte[] excelData = irrbbeveService.generateIrrbbeveExcel(Report_date);

			if (excelData.length == 0) {
				logger.warn("Controller: No data found for IRRBB Data EVE report. Responding with 204 No Content.");
				return ResponseEntity.noContent().build();
			}

			ByteArrayResource resource = new ByteArrayResource(excelData);

			String filename = "IrrbbDataEVE.xlsx";
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

			logger.info("Controller: Sending file '{}' to client ({} bytes).", filename, excelData.length);
			
			String userid = (String) req.getSession().getAttribute("USERID");

			auditService.createBusinessAudit(userid, "DOWNLOAD", "IRRBB_DATA_TEMPLATE_EVE_EXCEL", null, "BCBUAE_IRRBB_DATA_TEMPLATE");

			return ResponseEntity.ok().headers(headers).contentLength(excelData.length)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(resource);

		} catch (FileNotFoundException e) {
			logger.error("Controller ERROR: IRRBB Data EVE Excel template file not found.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (Exception e) {
			logger.error("Controller ERROR: Unexpected error occurred during file generation.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(value = "/downloadIrrbbExcel", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> downloadIrrbbExcel(HttpServletRequest req,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		logger.info("Controller: Received request for IRRBB Consolidated Excel download for report date {}.", Report_date);

		try {
			byte[] excelData = irrbbeveService.generateIrrbbExcel(Report_date);

			if (excelData.length == 0) {
				logger.warn("Controller: No data found for IRRBB Data EVE report. Responding with 204 No Content.");
				return ResponseEntity.noContent().build();
			}

			ByteArrayResource resource = new ByteArrayResource(excelData);

			String filename = "CBUAE_IRRBB_Data_template.xlsx";
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

			logger.info("Controller: Sending file '{}' to client ({} bytes).", filename, excelData.length);
			
			String userid = (String) req.getSession().getAttribute("USERID");

			auditService.createBusinessAudit(userid, "DOWNLOAD", "IRRBB_CONSOLIDATED_DATA_TEMPLATE_EXCEL", null, "BCBUAE_IRRBB_DATA_TEMPLATE");

			return ResponseEntity.ok().headers(headers).contentLength(excelData.length)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(resource);

		} catch (FileNotFoundException e) {
			logger.error("Controller ERROR: IRRBB Data EVE Excel template file not found.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (Exception e) {
			logger.error("Controller ERROR: Unexpected error occurred during file generation.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	

	@RequestMapping(value = "/downloadIrrbbearExcel", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> downloadIrrbbearExcel(HttpServletRequest req,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		logger.info("Controller: Received request for IRRBB Data EAR Excel download for report date {}.", Report_date);

		try {
			byte[] excelData = irrbbearService.generateIrrbbearExcel(Report_date);

			if (excelData.length == 0) {
				logger.warn("Controller: No data found for IRRBB Data EAR report. Responding with 204 No Content.");
				return ResponseEntity.noContent().build();
			}

			ByteArrayResource resource = new ByteArrayResource(excelData);

			String filename = "IrrbbDataEAR.xlsx";
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

			logger.info("Controller: Sending file '{}' to client ({} bytes).", filename, excelData.length);
			
			String userid = (String) req.getSession().getAttribute("USERID");

			auditService.createBusinessAudit(userid, "DOWNLOAD", "IRRBB_DATA_TEMPLATE_EAR_EXCEL", null, "BCBUAE_IRRBB_EAR");

			return ResponseEntity.ok().headers(headers).contentLength(excelData.length)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(resource);

		} catch (FileNotFoundException e) {
			logger.error("Controller ERROR: IRRBB Data EAR Excel template file not found.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (Exception e) {
			logger.error("Controller ERROR: Unexpected error occurred during file generation.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "/downloadIrrbbdiscountrateExcel", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> downloadIrrbbdiscountrateExcel(HttpServletRequest req,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date) {
		logger.info("Controller: Received request for IRRBB Discount Rate Excel download for report date {}.", Report_date);

		try {
			byte[] excelData = discountratesService.generateIrrbbdiscountrateExcel(Report_date);

			if (excelData.length == 0) {
				logger.warn(
						"Controller: No data found for IRRBB Data Discount Rate report. Responding with 204 No Content.");
				return ResponseEntity.noContent().build();
			}

			ByteArrayResource resource = new ByteArrayResource(excelData);

			String filename = "IrrbbDataDiscountRate.xls";
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

			logger.info("Controller: Sending file '{}' to client ({} bytes).", filename, excelData.length);
			

			String userid = (String) req.getSession().getAttribute("USERID");

			auditService.createBusinessAudit(userid, "DOWNLOAD", "IRRBB_DATA_TEMPLATE_DISCOUNT_RATE _EXCEL", null, "BCBUAE_IRRBB_DISCOUNT_RATES");

			return ResponseEntity.ok().headers(headers).contentLength(excelData.length)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(resource);

		} catch (FileNotFoundException e) {
			logger.error("Controller ERROR: IRRBB Data Discount Rate Excel template file not found.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (Exception e) {
			logger.error("Controller ERROR: Unexpected error occurred during file generation.", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "RT", method = { RequestMethod.GET, RequestMethod.POST })
	public String RT(Model md, HttpServletRequest req) {
		return rtLiquidityReportService.findLatestSlsReport()
				.map(rtLiquidityReportService::buildSlsReportRedirectUrl)
				.orElseGet(() -> {
					md.addAttribute("slslist", rt_sls_repository.rtslslist());
					return "RT/RT_SLS";
				});
	}

	@RequestMapping(value = "IRS", method = { RequestMethod.GET, RequestMethod.POST })
	public String IRS(Model md, HttpServletRequest req) {
		return rtLiquidityReportService.findLatestIrsReport()
				.map(rtLiquidityReportService::buildIrsReportRedirectUrl)
				.orElseGet(() -> {
					md.addAttribute("irsList", RT_irs_repository.rtirslist());
					return "RT/RT_IRS";
				});
	}

	@RequestMapping(value = "SLSREPORT", method = { RequestMethod.GET, RequestMethod.POST })
	public String SLSREPORT(@RequestParam(required = false) String currency,
			@RequestParam(required = false) String reportdate, @RequestParam(required = false) String formmode,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "100") int size,
			@RequestParam(required = false) String Rowid, Model md, HttpServletRequest req) {

		// Match the input format: 30/04/2025
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date reportdatefor = null;

		try {
			if (reportdate != null) {
				reportdatefor = dateFormat.parse(reportdate);
			}
		} catch (ParseException e) {
			e.printStackTrace();
			md.addAttribute("error", "Invalid date format. Expected dd/MM/yyyy");
			return "RT/RT_SLSREPORT";
		}

		if (formmode == null || formmode.equals("summary")) {
			// --- Summary Mode ---
			List<RT_SLS_ENTITIES> slslist = rtLiquidityReportService.resolveSlsSummaryList(reportdatefor, currency);
			md.addAttribute("slslist", slslist);

			List<RT_SLS_ENTITIES> currencylist = rt_sls_repository.rtslslistonlydate(reportdatefor);
			md.addAttribute("currencylist", currencylist);
			md.addAttribute("reportDateOptions", rtLiquidityReportService.findDistinctSlsReportDates());

			md.addAttribute("currency", currency);
			md.addAttribute("reportdate", reportdate);
			md.addAttribute("formmode", "summary");

		} else if (formmode.equals("Detail")) {
			// --- Detail Mode ---
			int pageSize = size;
			int offset = page * pageSize;
			int totalRows=0;
			int totalPages=0;
			

			if (Rowid != null && !Rowid.isEmpty()) {
				
				
				String[] arrcurr=currency.split("_");
				List<RT_SLS_Detail_Enitity> slsdetaillist=null;
				String currency1=null;
				if(arrcurr[0].equals("All")) {
					currency1=arrcurr[4];
					totalRows = rt_sls_detail_repository.slsdetaillistcountROWID(reportdatefor, Rowid);
					totalPages = (int) Math.ceil((double) totalRows / pageSize);
					slsdetaillist = rt_sls_detail_repository.slsdetaillistrowid(reportdatefor,Rowid, offset, pageSize);
				}else if(arrcurr[0].equals("ONLY")) {
					currency1=arrcurr[1];
					totalRows = rt_sls_detail_repository.slsdetaillistcountROWID(reportdatefor, Rowid,currency1);
					totalPages = (int) Math.ceil((double) totalRows / pageSize);
					slsdetaillist = rt_sls_detail_repository.slsdetaillistrowid(reportdatefor,Rowid, currency1,offset, pageSize);
				}
				
				System.out.println(currency1);
				

				
				md.addAttribute("slsdetaillist", slsdetaillist);
				md.addAttribute("reportdate", reportdate);
				md.addAttribute("formmode", "Detail");
				md.addAttribute("pagination", "YES");
				md.addAttribute("currency", currency);
				md.addAttribute("currentPage", page);
				md.addAttribute("totalPages", totalPages);

			} else {
				// int totalRows = rt_sls_detail_repository.slsdetaillistcount(reportdatefor);
				
				String[] arrcurr=currency.split("_");
				List<RT_SLS_Detail_Enitity> slsdetaillist=null;
				String currency1=null;
				if(arrcurr[0].equals("All")) {
					currency1=arrcurr[4];
					totalRows = rt_sls_detail_repository.slsdetaillistcount(reportdatefor);
					totalPages = (int) Math.ceil((double) totalRows / pageSize);
					slsdetaillist = rt_sls_detail_repository.slsdetaillist(reportdatefor, offset, pageSize);
				}else if(arrcurr[0].equals("ONLY")) {
					currency1=arrcurr[1];
					totalRows = rt_sls_detail_repository.slsdetaillistcount(reportdatefor, currency1);
					totalPages = (int) Math.ceil((double) totalRows / pageSize);
					slsdetaillist = rt_sls_detail_repository.slsdetaillist(reportdatefor,currency1, offset, pageSize);
					 
				}
				System.out.println(currency);

				System.out.println("offset==" + offset);
				
				md.addAttribute("slsdetaillist", slsdetaillist);
				md.addAttribute("reportdate", reportdate);
				md.addAttribute("formmode", "Detail");
				md.addAttribute("currency", currency);
				md.addAttribute("pagination", "YES");
				md.addAttribute("currentPage", page);
				md.addAttribute("totalPages", totalPages);
			}
			
		}

		return "RT/RT_SLSREPORT";
	}

	@RequestMapping(value = "/slsAnalyticalLongTermRatioS2", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> slsAnalyticalLongTermRatioS2(@RequestParam String reportdate,
			@RequestParam String currency) {
		Map<String, Object> result = new HashMap<>();
		try {
			Date reportDateFor = parseSlsAnalyticalReportDate(reportdate);
			List<BigDecimal> rows = rt_sls_repository.getSlsAnalyticalLongTermRatioS2(reportDateFor, currency);
			BigDecimal ratio = (rows != null && !rows.isEmpty()) ? rows.get(0) : null;
			if (ratio != null) {
				ratio = ratio.setScale(2, RoundingMode.HALF_UP);
			}
			result.put("success", true);
			result.put("ratio", ratio);
		} catch (Exception e) {
			logger.error("Error fetching SLS analytical long-term ratio for section 2", e);
			result.put("success", false);
			result.put("error", e.getMessage());
			result.put("ratio", null);
		}
		return result;
	}

	@RequestMapping(value = "/slsAnalyticalMedLongTermRatioS2", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> slsAnalyticalMedLongTermRatioS2(@RequestParam String reportdate,
			@RequestParam String currency) {
		Map<String, Object> result = new HashMap<>();
		try {
			Date reportDateFor = parseSlsAnalyticalReportDate(reportdate);
			List<BigDecimal> rows = rt_sls_repository.getSlsAnalyticalMedLongTermRatioS2(reportDateFor, currency);
			BigDecimal ratio = (rows != null && !rows.isEmpty()) ? rows.get(0) : null;
			if (ratio != null) {
				ratio = ratio.setScale(2, RoundingMode.HALF_UP);
			}
			result.put("success", true);
			result.put("ratio", ratio);
		} catch (Exception e) {
			logger.error("Error fetching SLS analytical medium-to-long-term ratio for section 2", e);
			result.put("success", false);
			result.put("error", e.getMessage());
			result.put("ratio", null);
		}
		return result;
	}

	private Date parseSlsAnalyticalReportDate(String reportdate) throws ParseException {
		if (reportdate == null || reportdate.trim().isEmpty()) {
			throw new ParseException("Report date is required", 0);
		}
		String trimmed = reportdate.trim();
		if (trimmed.contains("-")) {
			return new SimpleDateFormat("yyyy-MM-dd").parse(trimmed);
		}
		return new SimpleDateFormat("dd/MM/yyyy").parse(trimmed);
	}

	@RequestMapping(value = "RT_SLS_SENS", method = { RequestMethod.GET, RequestMethod.POST })
	public String RT_SLS_SENS(Model md, HttpServletRequest req) {
		return rtLiquidityReportService.findLatestSlsSensReport()
				.map(rtLiquidityReportService::buildSlsSensReportRedirectUrl)
				.orElseGet(() -> {
					md.addAttribute("positionDateGroups", slsSensReportService.buildPositionDateGroups());
					return "RT/RT_SLS_SENS";
				});
	}

	@RequestMapping(value = "SLS_SENSREPORT", method = { RequestMethod.GET, RequestMethod.POST })
	public String SLS_SENSREPORT(@RequestParam(required = false) String currency,
			@RequestParam(required = false) String reportdate,
			@RequestParam(required = false) String asOfDate,
			@RequestParam(required = false) Integer dayOffset,
			@RequestParam(required = false) String formmode,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "100") int size,
			@RequestParam(required = false) String Rowid, Model md, HttpServletRequest req) {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date positionDate = null;
		Date asOfDateParsed = null;

		try {
			if (reportdate != null && !reportdate.trim().isEmpty()) {
				positionDate = dateFormat.parse(reportdate.trim());
			}
			if (asOfDate != null && !asOfDate.trim().isEmpty()) {
				asOfDateParsed = dateFormat.parse(asOfDate.trim());
			}
		} catch (ParseException e) {
			logger.warn("SLS_SENSREPORT: invalid date", e);
			md.addAttribute("error", "Invalid date format. Expected dd/MM/yyyy");
			return "RT/RT_SLS_SENSREPORT";
		}

		if (positionDate == null) {
			md.addAttribute("error", "Position date is required.");
			return "RT/RT_SLS_SENSREPORT";
		}

		if (dayOffset == null && asOfDateParsed != null) {
			long diffMs = asOfDateParsed.getTime() - positionDate.getTime();
			dayOffset = (int) (diffMs / (24L * 60 * 60 * 1000));
			if (dayOffset < 0) {
				dayOffset = 0;
			}
		}
		if (dayOffset == null) {
			dayOffset = 0;
		}
		if (asOfDateParsed == null) {
			asOfDateParsed = SlsSensReportService.addCalendarDays(positionDate, dayOffset);
		}

		if (formmode == null || formmode.equals("summary")) {
			Optional<RT_SLS_SENS_ENTITIES> scenarioOpt = slsSensReportService.findScenarioRow(positionDate, dayOffset,
					currency);
			if (!scenarioOpt.isPresent() && asOfDateParsed != null) {
				scenarioOpt = slsSensReportService.findScenarioRowByAsOf(positionDate, asOfDateParsed, currency);
			}
			if (!scenarioOpt.isPresent()) {
				md.addAttribute("error",
						"No sensitivity scenario found for position date, currency, and day offset.");
				md.addAttribute("reportdate", reportdate);
				md.addAttribute("currency", currency);
				md.addAttribute("formmode", "summary");
				return "RT/RT_SLS_SENSREPORT";
			}

			RT_SLS_SENS_ENTITIES row = scenarioOpt.get();
			List<RT_SLS_SENS_ENTITIES> slslist = Collections.singletonList(row);
			md.addAttribute("slslist", slslist);

			List<RT_SLS_SENS_ENTITIES> currencylist = rt_sls_sens_repository.findCurrenciesByPositionDate(positionDate);
			md.addAttribute("currencylist", currencylist);

			List<SlsSensScenarioDto> scenarioSwitcher = slsSensReportService
					.findScenariosForPositionDate(positionDate, currency);

			SlsSensScenarioDto activeScenario = slsSensReportService.toScenarioDto(row);
			md.addAttribute("currency", currency);
			md.addAttribute("reportdate", reportdate);
			md.addAttribute("asOfDate", SlsSensReportService.formatDate(asOfDateParsed));
			md.addAttribute("dayOffset", dayOffset);
			md.addAttribute("scenarioLabel", activeScenario.getScenarioLabel());
			md.addAttribute("baseScenario", activeScenario.isBaseScenario());
			md.addAttribute("scenarioSwitcher", scenarioSwitcher);
			md.addAttribute("positionDateFormatted", SlsSensReportService.formatDate(positionDate));
			md.addAttribute("positionDateOptions", rtLiquidityReportService.findDistinctSlsSensPositionDates());
			md.addAttribute("formmode", "summary");
		} else if (formmode.equals("Detail")) {
			md.addAttribute("error", "Detail view is not configured for SLS Sensitivity Report.");
			md.addAttribute("reportdate", reportdate);
			md.addAttribute("asOfDate", asOfDate);
			md.addAttribute("dayOffset", dayOffset);
			md.addAttribute("currency", currency);
			md.addAttribute("formmode", "summary");
		}

		return "RT/RT_SLS_SENSREPORT";
	}

	@RequestMapping(value = "/slsSensAnalyticalLongTermRatioS2", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> slsSensAnalyticalLongTermRatioS2(@RequestParam String reportdate,
			@RequestParam String currency,
			@RequestParam(defaultValue = "0") Integer dayOffset) {
		Map<String, Object> result = new HashMap<>();
		try {
			Date reportDateFor = parseSlsAnalyticalReportDate(reportdate);
			List<BigDecimal> rows = rt_sls_sens_repository.getSlsAnalyticalLongTermRatioS2(reportDateFor, currency,
					dayOffset);
			BigDecimal ratio = (rows != null && !rows.isEmpty()) ? rows.get(0) : null;
			if (ratio != null) {
				ratio = ratio.setScale(2, RoundingMode.HALF_UP);
			}
			result.put("success", true);
			result.put("ratio", ratio);
		} catch (Exception e) {
			logger.error("Error fetching SLS sensitivity analytical long-term ratio for section 2", e);
			result.put("success", false);
			result.put("error", e.getMessage());
			result.put("ratio", null);
		}
		return result;
	}

	@RequestMapping(value = "/slsSensAnalyticalMedLongTermRatioS2", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> slsSensAnalyticalMedLongTermRatioS2(@RequestParam String reportdate,
			@RequestParam String currency,
			@RequestParam(defaultValue = "0") Integer dayOffset) {
		Map<String, Object> result = new HashMap<>();
		try {
			Date reportDateFor = parseSlsAnalyticalReportDate(reportdate);
			List<BigDecimal> rows = rt_sls_sens_repository.getSlsAnalyticalMedLongTermRatioS2(reportDateFor, currency,
					dayOffset);
			BigDecimal ratio = (rows != null && !rows.isEmpty()) ? rows.get(0) : null;
			if (ratio != null) {
				ratio = ratio.setScale(2, RoundingMode.HALF_UP);
			}
			result.put("success", true);
			result.put("ratio", ratio);
		} catch (Exception e) {
			logger.error("Error fetching SLS sensitivity analytical medium-to-long-term ratio for section 2", e);
			result.put("success", false);
			result.put("error", e.getMessage());
			result.put("ratio", null);
		}
		return result;
	}

	@RequestMapping(value = "/slsSensSevenDaySummary", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> slsSensSevenDaySummary(@RequestParam String reportdate, @RequestParam String currency) {
		Map<String, Object> result = new HashMap<>();
		try {
			Date positionDate = parseSlsAnalyticalReportDate(reportdate);
			result.putAll(slsSensReportService.buildSevenDayTotalsSummary(positionDate, currency));
		} catch (Exception e) {
			logger.error("Error building SLS sensitivity seven-day summary", e);
			result.put("success", false);
			result.put("error", e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "RT_IRS_SENS", method = { RequestMethod.GET, RequestMethod.POST })
	public String RT_IRS_SENS(Model md, HttpServletRequest req) {
		return rtLiquidityReportService.findLatestIrsSensReport()
				.map(rtLiquidityReportService::buildIrsSensReportRedirectUrl)
				.orElseGet(() -> {
					md.addAttribute("positionDateGroups", irsSensReportService.buildPositionDateGroups());
					return "RT/RT_IRS_SENS";
				});
	}

	@RequestMapping(value = "IRS_SENSREPORT", method = { RequestMethod.GET, RequestMethod.POST })
	public String IRS_SENSREPORT(@RequestParam(required = false) String currency,
			@RequestParam(required = false) String reportdate,
			@RequestParam(required = false) String asOfDate,
			@RequestParam(required = false) Integer dayOffset,
			@RequestParam(required = false) String formmode,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "100") int size,
			@RequestParam(required = false) String rowid, Model md, HttpServletRequest req) {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date positionDate = null;
		Date asOfDateParsed = null;

		try {
			if (reportdate != null && !reportdate.trim().isEmpty()) {
				positionDate = dateFormat.parse(reportdate.trim());
			}
			if (asOfDate != null && !asOfDate.trim().isEmpty()) {
				asOfDateParsed = dateFormat.parse(asOfDate.trim());
			}
		} catch (ParseException e) {
			logger.warn("IRS_SENSREPORT: invalid date", e);
			md.addAttribute("error", "Invalid date format. Expected dd/MM/yyyy");
			return "RT/RT_IRS_SENSREPORT";
		}

		if (positionDate == null) {
			md.addAttribute("error", "Position date is required.");
			return "RT/RT_IRS_SENSREPORT";
		}

		if (dayOffset == null && asOfDateParsed != null) {
			long diffMs = asOfDateParsed.getTime() - positionDate.getTime();
			dayOffset = (int) (diffMs / (24L * 60 * 60 * 1000));
			if (dayOffset < 0) {
				dayOffset = 0;
			}
		}
		if (dayOffset == null) {
			dayOffset = 0;
		}
		if (asOfDateParsed == null) {
			asOfDateParsed = IrsSensReportService.addCalendarDays(positionDate, dayOffset);
		}

		md.addAttribute("reportdate", reportdate);
		md.addAttribute("currency", currency);
		md.addAttribute("formmode", formmode != null ? formmode : "summary");

		if (formmode == null || formmode.equals("summary")) {
			Optional<RT_IRS_SENS_ENTITIES> scenarioOpt = irsSensReportService.findScenarioRow(positionDate, dayOffset,
					currency);
			if (!scenarioOpt.isPresent() && asOfDateParsed != null) {
				scenarioOpt = irsSensReportService.findScenarioRowByAsOf(positionDate, asOfDateParsed, currency);
			}
			if (!scenarioOpt.isPresent()) {
				md.addAttribute("error",
						"No sensitivity scenario found for position date, currency, and day offset.");
				md.addAttribute("formmode", "summary");
				return "RT/RT_IRS_SENSREPORT";
			}

			RT_IRS_SENS_ENTITIES row = scenarioOpt.get();
			List<RT_IRS_SENS_ENTITIES> irslist = Collections.singletonList(row);
			List<RT_IRS_SENS_ENTITIES2> irsList2 = rt_irs_sens2_repository
					.findByPositionDateAndCurrencyAndDayOffset(positionDate, currency, dayOffset);
			List<RT_IRS_SENS_ENTITIES> currencylist = rt_irs_sens_repository.findCurrenciesByPositionDate(positionDate);
			List<SlsSensScenarioDto> scenarioSwitcher = irsSensReportService
					.findScenariosForPositionDate(positionDate, currency);
			SlsSensScenarioDto activeScenario = irsSensReportService.toScenarioDto(row);

			md.addAttribute("irslist", irslist);
			md.addAttribute("irsList2", irsList2);
			md.addAttribute("currencylist", currencylist);
			md.addAttribute("asOfDate", IrsSensReportService.formatDate(asOfDateParsed));
			md.addAttribute("dayOffset", dayOffset);
			md.addAttribute("scenarioLabel", activeScenario.getScenarioLabel());
			md.addAttribute("baseScenario", activeScenario.isBaseScenario());
			md.addAttribute("scenarioSwitcher", scenarioSwitcher);
			md.addAttribute("positionDateFormatted", IrsSensReportService.formatDate(positionDate));
			md.addAttribute("positionDateOptions", rtLiquidityReportService.findDistinctIrsSensPositionDates());
			md.addAttribute("formmode", "summary");
		} else if (formmode.equals("Detail")) {
			md.addAttribute("error", "Detail view is not configured for IRS Sensitivity Report.");
			md.addAttribute("asOfDate", asOfDate);
			md.addAttribute("dayOffset", dayOffset);
			md.addAttribute("formmode", "summary");
		}

		return "RT/RT_IRS_SENSREPORT";
	}

	@RequestMapping(value = "/irsSensAnalyticalLongTermRatioS2", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> irsSensAnalyticalLongTermRatioS2(@RequestParam String reportdate,
			@RequestParam String currency,
			@RequestParam(defaultValue = "0") Integer dayOffset) {
		Map<String, Object> result = new HashMap<>();
		try {
			Date reportDateFor = parseSlsAnalyticalReportDate(reportdate);
			List<BigDecimal> rows = rt_irs_sens_repository.getIrsAnalyticalLongTermRatioS2(reportDateFor, currency,
					dayOffset);
			BigDecimal ratio = (rows != null && !rows.isEmpty()) ? rows.get(0) : null;
			if (ratio != null) {
				ratio = ratio.setScale(2, RoundingMode.HALF_UP);
			}
			result.put("success", true);
			result.put("ratio", ratio);
		} catch (Exception e) {
			logger.error("Error fetching IRS sensitivity analytical long-term ratio for section 2", e);
			result.put("success", false);
			result.put("error", e.getMessage());
			result.put("ratio", null);
		}
		return result;
	}

	@RequestMapping(value = "/irsSensAnalyticalMedLongTermRatioS2", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> irsSensAnalyticalMedLongTermRatioS2(@RequestParam String reportdate,
			@RequestParam String currency,
			@RequestParam(defaultValue = "0") Integer dayOffset) {
		Map<String, Object> result = new HashMap<>();
		try {
			Date reportDateFor = parseSlsAnalyticalReportDate(reportdate);
			List<BigDecimal> rows = rt_irs_sens_repository.getIrsAnalyticalMedLongTermRatioS2(reportDateFor, currency,
					dayOffset);
			BigDecimal ratio = (rows != null && !rows.isEmpty()) ? rows.get(0) : null;
			if (ratio != null) {
				ratio = ratio.setScale(2, RoundingMode.HALF_UP);
			}
			result.put("success", true);
			result.put("ratio", ratio);
		} catch (Exception e) {
			logger.error("Error fetching IRS sensitivity analytical medium-to-long-term ratio for section 2", e);
			result.put("success", false);
			result.put("error", e.getMessage());
			result.put("ratio", null);
		}
		return result;
	}

	@RequestMapping(value = "/irsSensSevenDaySummary", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> irsSensSevenDaySummary(@RequestParam String reportdate, @RequestParam String currency) {
		Map<String, Object> result = new HashMap<>();
		try {
			Date positionDate = parseSlsAnalyticalReportDate(reportdate);
			result.putAll(irsSensReportService.buildSevenDayTotalsSummary(positionDate, currency));
		} catch (Exception e) {
			logger.error("Error building IRS sensitivity seven-day summary", e);
			result.put("success", false);
			result.put("error", e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "IRSREPORT", method = { RequestMethod.GET, RequestMethod.POST })
	public String IRSREPORT(@RequestParam String reportdate, @RequestParam String currency,
			@RequestParam(defaultValue = "summary") String formmode, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "100") int size, @RequestParam(required = false) String rowid, Model md) {

		Date reportDateFor;

		try {
			reportDateFor = new SimpleDateFormat("dd/MM/yyyy").parse(reportdate);
		} catch (Exception e) {
			md.addAttribute("error", "Invalid date format. Expected dd/MM/yyyy");
			return "RT/RT_IRSREPORT";
		}

		/* ===================== COMMON ATTRIBUTES ===================== */
		md.addAttribute("reportdate", reportdate);
		md.addAttribute("currency", currency);
		md.addAttribute("formmode", formmode);

		/* ===================== SUMMARY ===================== */
		if ("summary".equalsIgnoreCase(formmode)) {

			List<RT_IRS_ENTITY> irslist = rtLiquidityReportService.resolveIrsSummaryList(reportDateFor, currency);

			List<RT_IRS_ENTITY2> irsList2 = RT_IRS2_REPOSITORY.rtirslistbydate(reportDateFor, currency);

			List<RT_IRS_ENTITY> currencyList = RT_irs_repository.getIrsCurrencyByDate(reportDateFor);

			md.addAttribute("irslist", irslist);
			md.addAttribute("irsList2", irsList2);
			md.addAttribute("currencylist", currencyList);
			md.addAttribute("reportDateOptions", rtLiquidityReportService.findDistinctIrsReportDates());
		}

		/* ===================== DETAIL ===================== */
		else if ("Detail".equalsIgnoreCase(formmode)) {

			if (rowid != null && !rowid.trim().isEmpty()) {

				// 🔹 Detail by ROWID
				List<RT_IRS_DETAIL_ENTITY> detailsList = RT_IRS_DETAIL_REPO.IRSdetaillistrowid(reportDateFor, rowid);

				int totalCount = RT_IRS_DETAIL_REPO.IRSdetaillistcountROWID(reportDateFor, rowid);

				md.addAttribute("detailsList", detailsList);
				md.addAttribute("rowid", rowid);
				md.addAttribute("currentPage", page);
				md.addAttribute("totalPages", (int) Math.ceil((double) totalCount / size));
			} else {

				// 🔹 Normal paginated detail
				List<RT_IRS_DETAIL_ENTITY> detailsList = RT_IRS_DETAIL_REPO.irsdetaillist(reportDateFor, page, size);

				int totalCount = RT_IRS_DETAIL_REPO.IRSdetaillistcount(reportDateFor);

				md.addAttribute("detailsList", detailsList);
				md.addAttribute("pagination", "YES");
				md.addAttribute("currentPage", page);
				md.addAttribute("totalPages", (int) Math.ceil((double) totalCount / size));
			}
		}

		return "RT/RT_IRSREPORT"; // SAME SCREEN
	}

	@RequestMapping(value = "downloadExcel", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ResponseEntity<ByteArrayResource> summaryDownload(HttpServletResponse response,
			@RequestParam("reportdate") String reportdate, @RequestParam("currency") String currency,
			@RequestParam("type") String type, @RequestParam("report") String report, // ✅ ADD THIS
			@RequestParam(value = "version", required = false) String version,
			@RequestParam(value = "filename", required = false) String filename) {

		response.setContentType("application/octet-stream");

		try {
			// ✅ Date format conversion
			DateFormat outFormat = new SimpleDateFormat("dd-MMM-yyyy");
			reportdate = outFormat.format(new SimpleDateFormat("dd/MM/yyyy").parse(reportdate));

			byte[] excelData = null;

			if ("summary".equalsIgnoreCase(type)) {

				if ("SLS".equalsIgnoreCase(report)) {
					excelData = RT_SLSServices.getSlsExcel(filename, reportdate, currency, version);

				} else if ("IRS".equalsIgnoreCase(report)) {
					excelData = rtIrsService.getIrsExcel(filename, reportdate, currency, version);
				}
			}

			// ✅ NO DATA
			if (excelData == null || excelData.length == 0) {
				logger.warn("No data available for Excel download");
				return ResponseEntity.noContent().build(); // 204
			}

			ByteArrayResource resource = new ByteArrayResource(excelData);

			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename + " "+currency+ ".xls");

			return ResponseEntity.ok().headers(headers).contentLength(excelData.length)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(resource);

		} catch (Exception e) {
			logger.error("Excel download error", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "downloaddetailExcel", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ResponseEntity<ByteArrayResource> detailDownload(HttpServletResponse response,
			@RequestParam("jobId") String jobId, @RequestParam("filename") String filename,
			@RequestParam(value = "type", required = false) String type) { // Added type param

		try {
			byte[] excelData = null;

			// Routing logic based on type
			if ("IRS".equalsIgnoreCase(type)) {
				excelData = rtIrsService.getReport(jobId);
			} else {
				// Default to SLS if no type or type is SLS
				excelData = RT_SLSServices.getReport(jobId);
			}

			if (excelData == null || excelData.length == 0) {
				return ResponseEntity.noContent().build();
			}

			ByteArrayResource resource = new ByteArrayResource(excelData);
			HttpHeaders headers = new HttpHeaders();

			// Ensure filename has extension
			String finalFileName = filename.endsWith(".xls") ? filename : filename + ".xls";

			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + finalFileName);

			return ResponseEntity.ok().headers(headers).contentLength(excelData.length)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(resource);

		} catch (Exception e) {
			logger.error("Controller ERROR: Detail download failed", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "/startreport", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody // forces raw text instead of HTML view
	public String startReport(@RequestParam String filename, @RequestParam String reportdate,
			@RequestParam String currency, @RequestParam(value = "version", required = false) String version) {
		String jobId = UUID.randomUUID().toString();
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		System.out.println("startreport inside....");
		try {

			reportdate = dateFormat.format(new SimpleDateFormat("dd/MM/yyyy").parse(reportdate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		RT_SLSServices.generateReportAsync(jobId, filename, reportdate, currency, version);
		return jobId;
	}

	// 2️⃣ Check if report is ready
	@RequestMapping(value = "/checkreport", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody // forces raw text instead of HTML view
	public ResponseEntity<String> checkReport(@RequestParam String jobId) {
		System.out.println(jobId);
		byte[] report = RT_SLSServices.getReport(jobId);
		System.out.println("Report generation completed for: " + jobId + "    the reoport   " + report);
		if (report == null) {
			return ResponseEntity.ok("PROCESSING");
		}
		return ResponseEntity.ok("READY");
	}

	@RequestMapping(value = "/startIRSDetailReport", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody // forces raw text instead of HTML view
	public String startIRSDetailReport(@RequestParam String filename, @RequestParam String reportdate,
			@RequestParam String currency, @RequestParam(value = "version", required = false) String version) {
		String jobId = UUID.randomUUID().toString();
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		try {

			reportdate = dateFormat.format(new SimpleDateFormat("dd/MM/yyyy").parse(reportdate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		rtIrsService.generateReportAsync(jobId, filename, reportdate, currency, version);
		return jobId;
	}

	@RequestMapping(value = "/checkirsreport", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody // forces raw text instead of HTML view
	public ResponseEntity<String> checkirsreport(@RequestParam String jobId) {
		byte[] report = rtIrsService.getReport(jobId);
		// System.out.println("Report generation completed for: " + jobId);
		if (report == null) {
			return ResponseEntity.ok("PROCESSING");
		}
		return ResponseEntity.ok("READY");
	}
	///// Credit Risk Analysis Report

	@RequestMapping(value = "Credit_risk", method = { RequestMethod.GET, RequestMethod.POST })
	public String Credit_risk_analysis(@RequestParam(required = false) String formmode, Model md,
			@RequestParam(value = "Report_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Report_date,
			HttpServletRequest req) {

		System.out.println("Initial Report date : " + Report_date);

		LocalDate today = LocalDate.now(); // Get today's date

		if (Report_date != null) {
			Report_date = java.sql.Date.valueOf(normalizeDate(Report_date.toString()));
		} else {
			Report_date = java.sql.Date.valueOf(today.minusDays(1));
		}

		System.out.println("After validation Todaydate : " + Report_date);

		if (formmode.equals("Portfolio_analysis")) {
			List<Object[]> portfolioData = RT_RWA_Fund_base_data_rep.Getbranchwiseportfolio(Report_date);
			List<RT_Chart_pojo> chartList = new ArrayList<>();

			for (Object[] row : portfolioData) {

				RT_Chart_pojo chart = new RT_Chart_pojo();

				chart.setClassification(row[0] != null ? row[0].toString() : "Un Mapped Accounts");

				chart.setExposurebal(row[1] != null ? new BigDecimal(row[1].toString()) : BigDecimal.ZERO);

				chart.setExposureperc(row[2] != null ? new BigDecimal(row[2].toString()) : BigDecimal.ZERO);

				System.out.println("Classification > " + row[0] + " and Exposure Balance > " + row[1]
						+ " Exposure Perc > " + row[2]);
				chartList.add(chart); // ✔ IMPORTANT
			}

			md.addAttribute("Report_date", Report_date);
			md.addAttribute("Analysistabledata", chartList);
			md.addAttribute("formmode", "Portfolio_analysis");
			md.addAttribute("menuname", "Total Portfolio Exposure");

		}

		return "RT/RT_Credit_Risk_analysis.html";
	}

	@RequestMapping(value = "CustomerGrp_Maintenance", method = { RequestMethod.GET, RequestMethod.POST })
	public String CustomerGrp_Maintenance(@RequestParam(required = false) String formmode, Model md,
			@RequestParam(value = "Group_id", required = false) String Group_id, HttpServletRequest req) {

		if (formmode.equals("list")) {

			List<Groupexp_cust_maintain_entity> Groupdetails = Groupexp_cust_maintain_rep.Getactivegroupdetails();
			md.addAttribute("Groupdetails", Groupdetails);
			md.addAttribute("formmode", "list");
			md.addAttribute("menuname", "Group Exposure - list");
		} else if (formmode.equals("add")) {
			md.addAttribute("Groupdetail", new Groupexp_cust_maintain_entity());
			md.addAttribute("formmode", "add");
			md.addAttribute("menuname", "Group Exposure - Add");
			md.addAttribute("customerList", RT_RWA_Fund_base_data_rep.getcustomerdetail());
		} else if (formmode.equals("edit")) {
			md.addAttribute("formmode", formmode);
			md.addAttribute("Groupdetail", Groupexp_cust_maintain_rep.Getgroupdetails(Group_id));
			md.addAttribute("customerList", RT_RWA_Fund_base_data_rep.getcustomerdetail());
			md.addAttribute("menuname", "Group Exposure - Modify");
		}

		return "RT/RT_Cust_group_exposure.html";
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

	@Autowired
	private RT_SLS_BEHAVIOURAL_PER_SERVICES rtSlsService;

	@Autowired
	private RT_FX_Position_Service rtFxPositionService;

	@Autowired
	RwaDataUploadService rwaService;

	@Autowired
	private RT_ACPR_SERVICE acprService;

	@Autowired
	RT_MID_FX_DEAL_SERVICE rtmidFxDealservice;

	

	// Page for FX
	@RequestMapping(value = "FXUPLOAD", method = { RequestMethod.GET, RequestMethod.POST })
	public String getFxPage(Model model) {
		return "RT_FX_Upload";
	}

	@RequestMapping(value = "SLSUPLOAD", method = { RequestMethod.GET, RequestMethod.POST })
	public String getSlsUploadPage(Model model) {
		return "RT_SLS_Upload";
	}

	@GetMapping("/getUploadedDates")
	@ResponseBody
	public List<String> getUploadedDates(@RequestParam String reportType) {

	    if (reportType == null || reportType.trim().isEmpty()) {
	        return new ArrayList<>();
	    }

	    if ("MFD".equals(reportType)) {
	        return rtmidFxDealservice.getUploadedDates();
	    } else if ("SLS".equals(reportType)) {
	        return rtSlsService.getUploadedDates();
	    } else if ("ACPR".equals(reportType)) {
	        return acprService.getUploadedDates();
	    } else if ("ACPRNF".equals(reportType)) {
	        return acprService.getUploadedDate();
	    } else if ("RWAFUND".equals(reportType)) {
	        return rwaService.getUploadedFundDates();
	    } else if ("RWANONFUND".equals(reportType)) {
	        return rwaService.getUploadedNonFundDates();
	    } else if ("RWABILLDETAIL".equals(reportType)) {
	        return rwaService.getUploadedBillDates();
	    } else if ("FXP".equals(reportType)) {
	        return rtFxPositionService.getUploadedDates();
	    } else if ("ONFC".equals(reportType)) {
	        return overnightForeignCcyUploadService.getUploadedDates();
	    } else if ("TR_PLC".equals(reportType)) {
	        return rtmidFxDealservice.getTreasuryPlacementUploadedDates();
	    } else if ("TR_TB".equals(reportType)) {
	        return rtmidFxDealservice.getTreasuryTbUploadedDates();
	    } else if ("TR_SWD".equals(reportType)) {
	        return rtmidFxDealservice.getTreasurySwdUploadedDates();
	    } else if ("FWD_RVL".equals(reportType)) {
	        return rtmidFxDealservice.getForwardRevealUploadedDates();
	    } else if ("TR_INV_DEAL_DUMP".equals(reportType)) {
	        return rtinvestmentdealdatadump_service.getInvestmentDealDumpUploadedDates();
	    } else if ("plcdealdump".equals(reportType)) {
	        return rtinvestmentdealdatadump_service.getPlacementDealDumpUploadedDates();
	    } else if ("GAMDATADUMP".equals(reportType) || "ONLY_EAB_TABLE_DATA".equals(reportType)
	            || "TR_INV".equals(reportType)) {
	        return uploadMonitorService.getSuccessfulUploadDatesForReportType(reportType);
	    }

	    return new ArrayList<>();
	}
	@PostMapping("/commonUploadFile")
	@ResponseBody
	public ResponseEntity<String> commonUploadFile(
	        @RequestParam("file") MultipartFile file,
	        @RequestParam("reportType") String reportType,
	        @RequestParam(value = "fromDate", required = false) String fromDateStr,
	        @RequestParam("toDate") String toDateStr,
	        @RequestParam(value = "forceUpload", defaultValue = "false") boolean forceUpload,
	        HttpServletRequest request) {

	    String username = (String) request.getSession().getAttribute("USERNAME");
	    if (username == null)
	        username = "SYSTEM";

	    String uploadId = null;
	    try {

	        if (reportType != null && reportType.contains(",")) {
	            reportType = reportType.split(",")[0].trim();
	        }

	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	        Date toDate = null;
	        Date fromDate = null;

	        if (toDateStr != null && !toDateStr.trim().isEmpty()) {
	            toDate = sdf.parse(toDateStr.trim());
	        } else {
	            return ResponseEntity.badRequest().body("Reference Date is required.");
	        }

	        if (fromDateStr != null && !fromDateStr.trim().isEmpty()) {
	            fromDate = sdf.parse(fromDateStr.trim());
	        }
	        logger.info("Initiating Common Upload. Type: {}, User: {}, Reference Date: {}", reportType, username, toDate);

	        if (file.isEmpty()) {
	            return ResponseEntity.badRequest().body("Please select a valid file.");
	        }

	        try {
	            com.bornfire.xbrl.util.ExcelUploadHelper.validateUploadFile(file, reportType);
	        } catch (RuntimeException ex) {
	            return ResponseEntity.badRequest().body(ex.getMessage());
	        }

	        UploadMonitorEntity startedMonitor = uploadMonitorService.startUpload(
	                reportType, toDate, fromDate, file, username, forceUpload);
	        uploadId = startedMonitor.getUploadId();

	        String resultMsg = "";

	        if ("ACPR".equals(reportType)) {

	            resultMsg = acprService.uploadAcprFile(file, toDate, username, forceUpload);

	        } else if ("ACPRNF".equals(reportType)) {

	            resultMsg = acprService.uploadAcprnfFile(file, fromDate, toDate, username, forceUpload);

	        } else if ("RWAFUND".equals(reportType) || "RWANONFUND".equals(reportType)) {

	            resultMsg = rwaService.uploadRwaTextFile(file, reportType, toDate, forceUpload);

	        } else if ("FXP".equals(reportType)) {

	            resultMsg = rtFxPositionService.uploadFxData(file, fromDate, toDate, username);

	        } else if ("SLS".equals(reportType)) {

	            resultMsg = rtSlsService.processAndSaveFile(file, fromDate, toDate, username);

	        } else if ("MFD".equals(reportType)) {

	            resultMsg = rtmidFxDealservice.uploadMidFxDealData(file, toDate, username);
	        } else if ("RWABILLDETAIL".equals(reportType)) {

	            resultMsg = rwaService.Uploadrwadata(file, reportType, toDate, forceUpload);

	        }else if ("GAMDATADUMP".equals(reportType)) {

	            resultMsg = rwaService.UploadEabandGamdata(file, reportType, toDate);

	        } else if ("ONLY_EAB_TABLE_DATA".equals(reportType)) {

	            resultMsg = rwaService.UploadEabdata(file, reportType, toDate);

	        } else if ("TR_PLC".equals(reportType) || "TR_TB".equals(reportType) || "TR_SWD".equals(reportType)
	        		|| "FWD_RVL".equals(reportType)) {

	            resultMsg = rtmidFxDealservice.UploadTrplorTb(file, toDate, username,reportType); //Mid Service used as upload Service treasury details

	        }else if("TR_INV_DEAL_DUMP".equals(reportType) || "plcdealdump".equals(reportType)) {
	        	resultMsg =rtinvestmentdealdatadump_service.Uploadinvdump(file, toDate, username,reportType);
	        }
	        
	        else if("ECL".equals(reportType)) {
	        	resultMsg = ecldatauploadservice.uploadECLdata(file, toDate,forceUpload);
	        }
	        
	        else if("SMA".equals(reportType)) {
	        	resultMsg =SMAFileUploadService.SMAFileUpload(file, reportType, toDate, forceUpload);
	        }
	        else if("Provisioning".equals(reportType)) {
	        	resultMsg =ProvisioningFileUploadService.ProvisioningFileUpload(file, reportType, toDate, forceUpload);
	        }
	        else if("VARFILE".equals(reportType)) {
	        	resultMsg =varportfoliouploadservice.uploadVarPortfolio(file, reportType, toDate, forceUpload);
	        } else if("DAY_LIGHT".equals(reportType)) {
	        	resultMsg = daylightDataUploadService.UploadDaylight(file, reportType, toDate, forceUpload);
	        } else if ("ONFC".equals(reportType)) {
	        	resultMsg = overnightForeignCcyUploadService.uploadOvernightForeignCcy(file, toDate, forceUpload);
	        }
	        else {
	        	uploadMonitorService.completeFailure(uploadId, "Unsupported Report Type: " + reportType);
	            return ResponseEntity.badRequest().body("Unsupported Report Type: " + reportType);
	        }

	        Map<String, Long> metrics = extractUploadMetrics(resultMsg);
	        uploadMonitorService.completeSuccess(
	                uploadId,
	                resultMsg,
	                metrics.get("total"),
	                metrics.get("loaded"),
	                metrics.get("failed"));
	        return ResponseEntity.ok(resultMsg);

	    } catch (RuntimeException e) {
	        if (uploadId != null) {
	            uploadMonitorService.completeFailure(uploadId, UploadMessageHelper.userFriendlyError(e));
	        }
	        return ResponseEntity.badRequest().body(UploadMessageHelper.userFriendlyError(e));
	    } catch (Exception e) {
	        if (uploadId != null) {
	            uploadMonitorService.completeFailure(uploadId, UploadMessageHelper.userFriendlyError(e));
	        }
	        return ResponseEntity.badRequest().body(UploadMessageHelper.userFriendlyError(e));
	    }
	}

	@GetMapping("/upload-monitor/summary")
	@ResponseBody
	public ResponseEntity<?> getUploadMonitorSummary(
	        @RequestParam("reportType") String reportType,
	        @RequestParam(value = "reportDate", required = false) String reportDateStr,
	        @RequestParam(value = "fromDate", required = false) String fromDateStr,
	        @RequestParam(value = "toDate", required = false) String toDateStr) {
	    try {
	        Date reportDate = parseDdMmYyyyDate(reportDateStr);
	        Date fromDate = parseDdMmYyyyDate(fromDateStr);
	        Date toDate = parseDdMmYyyyDate(toDateStr);
	        return ResponseEntity.ok(uploadMonitorService.getSummary(reportType, reportDate, fromDate, toDate));
	    } catch (Exception e) {
	        return ResponseEntity.badRequest().body("Error fetching summary: " + e.getMessage());
	    }
	}

	@GetMapping("/upload-monitor/history")
	@ResponseBody
	public ResponseEntity<?> getUploadMonitorHistory(
	        @RequestParam("reportType") String reportType,
	        @RequestParam(value = "reportDate", required = false) String reportDateStr,
	        @RequestParam(value = "page", defaultValue = "0") int page,
	        @RequestParam(value = "size", defaultValue = "10") int size) {
	    try {
	        Date reportDate = parseDdMmYyyyDate(reportDateStr);
	        return ResponseEntity.ok(uploadMonitorService.getHistory(reportType, reportDate, page, size));
	    } catch (Exception e) {
	        return ResponseEntity.badRequest().body("Error fetching history: " + e.getMessage());
	    }
	}

	@GetMapping("/upload-monitor/details/{uploadId}")
	@ResponseBody
	public ResponseEntity<?> getUploadMonitorDetails(@PathVariable("uploadId") String uploadId) {
	    UploadMonitorEntity details = uploadMonitorService.getDetails(uploadId);
	    if (details == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Upload monitor record not found.");
	    }
	    return ResponseEntity.ok(details);
	}

	@GetMapping("/upload-monitor/context")
	@ResponseBody
	public ResponseEntity<?> getUploadMonitorContext(HttpServletRequest request) {
	    String username = (String) request.getSession().getAttribute("USERNAME");
	    if (username == null) {
	        username = "SYSTEM";
	    }
	    return ResponseEntity.ok(uploadMonitorService.getMonitorContext(username));
	}

	@PostMapping("/upload-monitor/delete-request")
	@ResponseBody
	public ResponseEntity<String> requestUploadDelete(
	        @RequestParam("uploadId") String uploadId,
	        @RequestParam("remarks") String remarks,
	        HttpServletRequest request) {
	    try {
	        String username = (String) request.getSession().getAttribute("USERNAME");
	        if (username == null) {
	            username = "SYSTEM";
	        }
	        uploadMonitorService.requestDelete(uploadId, username, remarks);
	        return ResponseEntity.ok("Delete request submitted successfully. Waiting for approver confirmation.");
	    } catch (RuntimeException e) {
	        return ResponseEntity.badRequest().body(e.getMessage());
	    }
	}

	@PostMapping("/upload-monitor/approve-delete")
	@ResponseBody
	public ResponseEntity<String> approveUploadDelete(
	        @RequestParam("uploadId") String uploadId,
	        HttpServletRequest request) {
	    try {
	        String username = (String) request.getSession().getAttribute("USERNAME");
	        if (username == null) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Session expired. Please log in again.");
	        }
	        UploadMonitorEntity monitor = uploadMonitorService.approveDelete(uploadId, username);
	        return ResponseEntity.ok("Upload data deleted successfully for report date "
	                + new SimpleDateFormat("dd-MM-yyyy").format(monitor.getReportDate()) + ".");
	    } catch (RuntimeException e) {
	        return ResponseEntity.badRequest().body(e.getMessage());
	    }
	}

	private Date parseDdMmYyyyDate(String value) throws ParseException {
	    if (value == null || value.trim().isEmpty()) {
	        return null;
	    }
	    return new SimpleDateFormat("dd-MM-yyyy").parse(value.trim());
	}

	private Map<String, Long> extractUploadMetrics(String message) {
	    Map<String, Long> metrics = new HashMap<String, Long>();
	    metrics.put("total", 0L);
	    metrics.put("loaded", 0L);
	    metrics.put("failed", 0L);
	    if (message == null || message.trim().isEmpty()) {
	        return metrics;
	    }

	    Long total = extractMetricValue(message,
	            "(?i)(total\\s*rows\\s*processed|data\\s*rows\\s*processed|total\\s*(records|rows)?|records\\s*total)\\D*(\\d+)");
	    Long loaded = extractMetricValue(message,
	            "(?i)(inserted\\s*rows|loaded|inserted|processed\\s*success|success\\s*count|record\\s*count)\\D*(\\d+)");
	    Long failed = extractMetricValue(message, "(?i)(failed\\s*rows|failed|rejected|error\\s*count)\\D*(\\d+)");

	    if (total != null) {
	        metrics.put("total", total);
	    }
	    if (loaded != null) {
	        metrics.put("loaded", loaded);
	    }
	    if (failed != null) {
	        metrics.put("failed", failed);
	    }
	    if (metrics.get("total") == 0L && (metrics.get("loaded") > 0 || metrics.get("failed") > 0)) {
	        metrics.put("total", metrics.get("loaded") + metrics.get("failed"));
	    }
	    return metrics;
	}

	private Long extractMetricValue(String message, String regex) {
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(message);
	    if (!matcher.find()) {
	        return null;
	    }

	    for (int i = matcher.groupCount(); i >= 1; i--) {
	        String group = matcher.group(i);
	        if (group != null && group.matches("\\d+")) {
	            return Long.parseLong(group);
	        }
	    }
	    return null;
	}

	@RequestMapping(value = "rt-sls/downloadTemplate", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> downloadTemplate() {
		logger.info("Generating dynamic SLS Excel Template");

		try {
			byte[] excelContent = rtSlsService.generateSlsTemplate();
			ByteArrayResource resource = new ByteArrayResource(excelContent);

			return ResponseEntity.ok()
					.contentType(MediaType
							.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"SLS_Scorecard_Template.xlsx\"")
					.body(resource);

		} catch (Exception e) {
			logger.error("Error generating template", e);

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "/getAdhocDetails", method = RequestMethod.GET)
	@ResponseBody
	public List<MIS_COUNTER_PARTY_LIMIT_DETAILS_ENTITY> getAdhocDetails(@RequestParam String srlNo) {
		return misCounterPartyLimitDetailsRepo.findBySrlNo(srlNo);
	}

	// 2. Updated Save Details with Alert Logic
	@RequestMapping(value = "/saveDetailsRecord", method = RequestMethod.POST)
	@ResponseBody
	public String saveDetailsRecord(@RequestParam("adhocDetailsJson") String json, @RequestParam("srlNo") String srlNo,
			@RequestParam("bankName") String bankName, HttpServletRequest request) {
		try {
			String userId = (String) request.getSession().getAttribute("USER_ID");
			if (userId == null)
				userId = "SYSTEM";

			ObjectMapper mapper = new ObjectMapper();
			mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
			List<MIS_COUNTER_PARTY_LIMIT_DETAILS_ENTITY> details = mapper.readValue(json,
					new TypeReference<List<MIS_COUNTER_PARTY_LIMIT_DETAILS_ENTITY>>() {
					});

			// Delete existing details for this SrlNo to perform a clean update
			List<MIS_COUNTER_PARTY_LIMIT_DETAILS_ENTITY> existing = misCounterPartyLimitDetailsRepo.findBySrlNo(srlNo);
			if (!existing.isEmpty()) {
				misCounterPartyLimitDetailsRepo.deleteAll(existing);
			}

			if (details != null) {
				for (MIS_COUNTER_PARTY_LIMIT_DETAILS_ENTITY detail : details) {
					if (detail.getAdhocLimit() == null) {
						continue;
					}
					detail.setSrlNo(srlNo);
					detail.setCounterPartyBank(bankName);
					detail.setCreateUser(userId);
					detail.setCreateTime(new Date());
					detail.setEntityFlg("N");
					detail.setModifyFlg("N");
					detail.setDelFlg("N");
					misCounterPartyLimitDetailsRepo.save(detail);
				}
			}
			return "SUCCESS";
		} catch (Exception e) {
			return "ERROR: " + e.getMessage();
		}
	}

	@Autowired
	MIS_SBLC_Maintenance_Repo sblcRepo;

	@RequestMapping(value = "/sblc_maintenance", method = RequestMethod.GET)
	public String sblcMaint(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) BigDecimal id, Model model) {

		String mode = (formmode == null) ? "list" : formmode;
		model.addAttribute("formmode", mode);

		if (mode.equals("list")) {
			model.addAttribute("listall", sblcRepo.getalllist());
		} else if (mode.equals("add")) {
			model.addAttribute("nextId", sblcRepo.getNextId());
			// Add an empty entity to the model for form binding
			model.addAttribute("list", new MIS_SBLC_Maintenance_Entity());
			model.addAttribute("Counterpartynamelist", Counterparty_Reps.Getcounterpartyname());

		} else if (mode.equals("edit") || mode.equals("view")) {
			model.addAttribute("list", sblcRepo.findById(id).orElse(new MIS_SBLC_Maintenance_Entity()));
			model.addAttribute("Counterpartynamelist", Counterparty_Reps.Getcounterpartyname());
		}
		return "MIS/SBLC_Maintenance";
	}

	@RequestMapping(value = "/sblc_save", method = RequestMethod.POST)
	@ResponseBody
	public String sblcSave(@ModelAttribute("list") MIS_SBLC_Maintenance_Entity sblc, @RequestParam String formmode,
			@RequestParam(required = false) BigDecimal id, // ID comes from query param for delete
			HttpSession session) {

		String user = (String) session.getAttribute("USERID");

		// Case 1: DELETE (Soft Delete)
		if ("delete".equals(formmode)) {
			if (id == null)
				return "ID is required for deletion";
			Optional<MIS_SBLC_Maintenance_Entity> existing = sblcRepo.findById(id);
			if (existing.isPresent()) {
				MIS_SBLC_Maintenance_Entity entity = existing.get();
				entity.setDel_flg("Y");
				entity.setModify_user(user);
				entity.setModify_time(new Date());
				sblcRepo.save(entity);
				return "Record Deleted Successfully";
			}
			return "Record Not Found";
		}

		// Case 2: ADD
		if ("add".equals(formmode)) {
			sblc.setCreate_user(user);
			sblc.setCreate_time(new Date());
			sblc.setDel_flg("N");
			sblcRepo.save(sblc);
			return "Record Added Successfully";
		}

		// Case 3: EDIT
		if ("edit".equals(formmode)) {
			// In JPA, save() updates if the ID property is set in the entity
			sblc.setModify_user(user);
			sblc.setModify_time(new Date());
			sblc.setDel_flg("N"); // Ensure flag stays N
			sblcRepo.save(sblc);
			return "Record Modified Successfully";
		}

		return "Invalid Request";
	}
	
	@RequestMapping(value = "/ASLCheck",  method = RequestMethod.GET)
	public String ASLCheckS(@RequestParam(required = false) String formmode,Model md,HttpServletRequest request)  {
		String roleId = (String) request.getSession().getAttribute("ROLEID");
		String BRANCHCODE = (String) request.getSession().getAttribute("BRANCHCODE");
		md.addAttribute("roleId", roleId);
		md.addAttribute("branchcode", BRANCHCODE);
		if(formmode==null||formmode.equals("ASLCheck")) {
			md.addAttribute("menu", "Current Bank Limit - ASL");
			md.addAttribute("formmode", "ASLChecklist");
		}else if(formmode.equals("Branchrequestadd")) {
			md.addAttribute("menu", "Limit Request - ASL");
			md.addAttribute("formmode", "Branchrequestadd");
			md.addAttribute("currentDate", new Date());
		}else if(formmode.equals("Branchrequestlistactive")) {
			md.addAttribute("menu", "Active Limit Request List - ASL");
			md.addAttribute("formmode", "Branchrequestlistactive");
			md.addAttribute("Requestlist", limit_request_rep.getAllLimitRequestList());
			
		}else if(formmode.equals("Branchrequestlisthistory")) {
			md.addAttribute("menu", "History Limit Request List - ASL");
			md.addAttribute("formmode", "Branchrequestlisthistory");
			md.addAttribute("Requestlist", limit_request_rep.getAllLimitRequestListhis());
			
			
		}
		
		List<BankLimit_Entity> BankLimitdata =banklimit_rep.getallbanknamemaxdate();
		List<Limit_Request_Entity> tempreqlimit=limit_request_rep.getAllLimitRequestList();
		for(Limit_Request_Entity reqlimit:tempreqlimit) {
			BankLimit_Entity tembanklimitdata=new BankLimit_Entity();
			String RequestType =reqlimit.getRequestType();
			if(RequestType.equals("TradeFinance")) {
				tembanklimitdata.setTrade_finance_exposure(reqlimit.getProposedAmt());
				tembanklimitdata.setBank_name(reqlimit.getBankName());
			}
			else if(RequestType.equals("MoneyMarket")) {
				tembanklimitdata.setMoney_market_exposure(reqlimit.getProposedAmt());
				tembanklimitdata.setBank_name(reqlimit.getBankName());
			}else if(RequestType.equals("SettlementLimit")) {
				tembanklimitdata.setSettlement_exposure(reqlimit.getProposedAmt());
				tembanklimitdata.setBank_name(reqlimit.getBankName());
			}
			
			BankLimitdata.add(tembanklimitdata);
		}
		
		md.addAttribute("BankLimitdata",BankLimitdata);
	return "RT/RT_ASLCheck";
		
	}
	
	@RequestMapping(value = "AddLimitRequest", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String AddLimitRequest(@ModelAttribute Limit_Request_Entity Limit_Request_Entity,
			@RequestParam(required = false) String formmode, Model md, HttpServletRequest rq) {
		logger.info("Add counter party...");
		String userid = (String) rq.getSession().getAttribute("USERID");
		String msg = counter_servicess.AddLimitRequest(Limit_Request_Entity, userid, formmode);
		return msg;

	}
	
	@RequestMapping(value = "LRDT_loansAdvancesConvertedAed", method = RequestMethod.GET)
	public String Liquidity_Risk_Dashboard_Template_loansAdvancesConvertedAed(
	        @RequestParam(required = false) String report_date, @RequestParam(required = false) String formmode, 
	        @RequestParam(required = false) String rowcurrency, 
	        Model model) {

	    List<Map<String, Object>> allData = new ArrayList<>();

	    boolean filterByCurrency = rowcurrency != null && !"ALL".equalsIgnoreCase(rowcurrency.trim());

	    String tablename1 = "BRF7_MAPPING_TABLE";
	    String rowid1 = "ROW101,ROW102";
	    
	    String sql1 = "SELECT CUST_ID, FORACID, ACCT_NAME, ACT_BALANCE_AMT_LC AS ACCT_BALANCE_LC, "
	            + "ROWIDTOCHAR(ROWID) AS RID, REPORT_DATE FROM " + tablename1
	            + " WHERE TO_CHAR(REPORT_DATE, 'DD-MM-YYYY') = ? AND REPORT_LABEL_1 = ? ";

	    if (filterByCurrency) {
	        sql1 += " AND ACCT_CRNCY_CODE = ?";
	    }

	    String[] rowidarray1 = rowid1.replace(" ", "").split(",");
	    for (String singlerowid : rowidarray1) {
	        Object[] args = filterByCurrency 
	            ? new Object[] { report_date, singlerowid.trim(), rowcurrency.trim() }
	            : new Object[] { report_date, singlerowid.trim() };
	            
	        allData.addAll(jdbcTemplate.queryForList(sql1, args));
	    }


	    String tablename2 = "brf9_detailtable";
	    String rowid2 = "ROW108";
	    String report_crit2 = "ROW108G,ROW108H,ROW108I,ROW108J";
	    
	    String sql2 = "SELECT CUST_ID, FORACID, ACCT_NAME, ACT_BALANCE_AMT_LC AS ACCT_BALANCE_LC, "
	            + "ROWIDTOCHAR(ROWID) AS RID, REPORT_DATE FROM " + tablename2
	            + " WHERE TO_CHAR(REPORT_DATE, 'DD-MM-YYYY') = ? AND REPORT_LABEL_1 = ? AND report_addl_criteria_1 = ? ";
	    
	    if (filterByCurrency) {
	        sql2 += " AND ACCT_CRNCY_CODE = ?";
	    }

	    String[] report_critarray2 = report_crit2.replace(" ", "").split(",");
	    for (String singlereport_crit : report_critarray2) {
	        Object[] args = filterByCurrency
	            ? new Object[] { report_date, rowid2, singlereport_crit.trim(), rowcurrency.trim() }
	            : new Object[] { report_date, rowid2, singlereport_crit.trim() };
	            
	        allData.addAll(jdbcTemplate.queryForList(sql2, args));
	    }

	    String tablename3 = "brf9_detailtable";
	    String rowid3 = "ROW106";
	    String report_crit3 = "ROW106G,ROW106H,ROW106I,ROW106J";

	    String sql3 = "SELECT CUST_ID, FORACID, ACCT_NAME, ACT_BALANCE_AMT_LC AS ACCT_BALANCE_LC, "
	            + "ROWIDTOCHAR(ROWID) AS RID, REPORT_DATE FROM " + tablename3
	            + " WHERE TO_CHAR(REPORT_DATE, 'DD-MM-YYYY') = ? AND REPORT_LABEL_1 = ? AND report_addl_criteria_1 = ? ";
	    
	    if (filterByCurrency) {
	        sql3 += " AND ACCT_CRNCY_CODE = ?";
	    }

	    String[] report_critarray3 = report_crit3.replace(" ", "").split(",");
	    for (String singlereport_crit : report_critarray3) {
	        Object[] args = filterByCurrency
	            ? new Object[] { report_date, rowid3, singlereport_crit.trim(), rowcurrency.trim() }
	            : new Object[] { report_date, rowid3, singlereport_crit.trim() };
	            
	        allData.addAll(jdbcTemplate.queryForList(sql3, args));
	    }


	    model.addAttribute("reportdetails", allData);
	    model.addAttribute("formmode", formmode);

	    return "RT/Liquidity_Risk_Dashboard_Template";
	}

	@RequestMapping(value = "LRDT_stableResourcesConvertedAed", method = RequestMethod.GET)
	public String Liquidity_Risk_Dashboard_Template_stableResourcesConvertedAed(
			@RequestParam(required = false) String report_date, @RequestParam(required = false) String formmode,
			@RequestParam(required = false) String rowcurrency, Model model) {

		List<Map<String, Object>> allData = new ArrayList<>();

		boolean filterByCurrency = rowcurrency != null && !"ALL".equalsIgnoreCase(rowcurrency.trim());

		String tablename1 = "brf2_detailtable";
		String rowid1 = "ROW151";

		String sql1 = "SELECT CUST_ID, FORACID, ACCT_NAME, ACT_BALANCE_AMT_LC AS ACCT_BALANCE_LC, "
				+ "ROWIDTOCHAR(ROWID) AS RID, REPORT_DATE FROM " + tablename1
				+ " WHERE TO_CHAR(REPORT_DATE, 'DD-MM-YYYY') = ? AND REPORT_LABEL_1 = ? ";

		if (filterByCurrency) {
			sql1 += " AND ACCT_CRNCY_CODE = ?";
		}

		String[] rowidarray1 = rowid1.replace(" ", "").split(",");
		for (String singlerowid : rowidarray1) {
			Object[] args = filterByCurrency ? new Object[] { report_date, singlerowid.trim(), rowcurrency.trim() }
					: new Object[] { report_date, singlerowid.trim() };

			allData.addAll(jdbcTemplate.queryForList(sql1, args));
		}

		String tablename2 = "BRF7_MAPPING_TABLE";
		String rowid2 = "ROW111";

		String sql2 = "SELECT CUST_ID, FORACID, ACCT_NAME, ACT_BALANCE_AMT_LC AS ACCT_BALANCE_LC, "
				+ "ROWIDTOCHAR(ROWID) AS RID, REPORT_DATE FROM " + tablename2
				+ " WHERE TO_CHAR(REPORT_DATE, 'DD-MM-YYYY') = ? AND REPORT_LABEL_1 = ? ";

		if (filterByCurrency) {
			sql2 += " AND ACCT_CRNCY_CODE = ?";
		}

		String[] rowidarray2 = rowid2.replace(" ", "").split(",");
		for (String singlerowid : rowidarray2) {
			Object[] args = filterByCurrency ? new Object[] { report_date, singlerowid.trim(), rowcurrency.trim() }
					: new Object[] { report_date, singlerowid.trim() };

			allData.addAll(jdbcTemplate.queryForList(sql2, args));
		}

		String tablename3 = "brf9_detailtable";
		String rowid3 = "ROW143";
		String report_crit3 = "ROW143H,ROW143I,ROW143J";

		String sql3 = "SELECT CUST_ID, FORACID, ACCT_NAME, ACT_BALANCE_AMT_LC AS ACCT_BALANCE_LC, "
				+ "ROWIDTOCHAR(ROWID) AS RID, REPORT_DATE FROM " + tablename3
				+ " WHERE TO_CHAR(REPORT_DATE, 'DD-MM-YYYY') = ? AND REPORT_LABEL_1 = ? AND report_addl_criteria_1 = ? ";

		if (filterByCurrency) {
			sql3 += " AND ACCT_CRNCY_CODE = ?";
		}

		String[] report_critarray3 = report_crit3.replace(" ", "").split(",");
		for (String singlereport_crit : report_critarray3) {
			Object[] args = filterByCurrency
					? new Object[] { report_date, rowid3, singlereport_crit.trim(), rowcurrency.trim() }
					: new Object[] { report_date, rowid3, singlereport_crit.trim() };

			allData.addAll(jdbcTemplate.queryForList(sql3, args));
		}

		rowid3 = "ROW149";
		report_crit3 = "ROW149H,ROW149I,ROW149J";

		report_critarray3 = report_crit3.replace(" ", "").split(",");
		for (String singlereport_crit : report_critarray3) {
			Object[] args = filterByCurrency
					? new Object[] { report_date, rowid3, singlereport_crit.trim(), rowcurrency.trim() }
					: new Object[] { report_date, rowid3, singlereport_crit.trim() };

			allData.addAll(jdbcTemplate.queryForList(sql3, args));
		}
		rowid3 = "ROW150";
		report_crit3 = "ROW150H";

		report_critarray3 = report_crit3.replace(" ", "").split(",");
		for (String singlereport_crit : report_critarray3) {
			Object[] args = filterByCurrency
					? new Object[] { report_date, rowid3, singlereport_crit.trim(), rowcurrency.trim() }
					: new Object[] { report_date, rowid3, singlereport_crit.trim() };

			allData.addAll(jdbcTemplate.queryForList(sql3, args));
		}

		rowid3 = "ROW151";
		report_crit3 = "ROW151H,ROW151I,ROW151J";

		report_critarray3 = report_crit3.replace(" ", "").split(",");
		for (String singlereport_crit : report_critarray3) {
			Object[] args = filterByCurrency
					? new Object[] { report_date, rowid3, singlereport_crit.trim(), rowcurrency.trim() }
					: new Object[] { report_date, rowid3, singlereport_crit.trim() };

			allData.addAll(jdbcTemplate.queryForList(sql3, args));
		}

		rowid3 = "ROW152";
		report_crit3 = "ROW152H,ROW152I,ROW152J";

		report_critarray3 = report_crit3.replace(" ", "").split(",");
		for (String singlereport_crit : report_critarray3) {
			Object[] args = filterByCurrency
					? new Object[] { report_date, rowid3, singlereport_crit.trim(), rowcurrency.trim() }
					: new Object[] { report_date, rowid3, singlereport_crit.trim() };

			allData.addAll(jdbcTemplate.queryForList(sql3, args));
		}

		String tablename4 = "brf9_laa_cash_flow";
		String rowid4 = "ROW131";

		String[] columns = { "SIX_MON_12_MON", "ZERO_7_DAYS", "EIGHT_14_DAYS", "FIFTEEN_DAYS_1_MON", "ONE_MON_3_MON",
				"THREE_MON_6_MON" };

		String[] rowidarray4 = rowid4.replace(" ", "").split(",");

		for (String column : columns) {

			String sql = "SELECT CUST_ID, ACCT_NUMBER AS FORACID, ACCT_NAME, " + column + " AS ACCT_BALANCE_LC, "
					+ "ROWIDTOCHAR(ROWID) AS RID, REPORT_DATE FROM " + tablename4
					+ " WHERE TO_CHAR(REPORT_DATE, 'DD-MM-YYYY') = ? AND REPORT_LABEL = ?";

			if (filterByCurrency) {
				sql += " AND ACCT_CRNCY_CODE = ?";
			}

			for (String singlerowid : rowidarray4) {

				Object[] args = filterByCurrency ? new Object[] { report_date, singlerowid.trim(), rowcurrency.trim() }
						: new Object[] { report_date, singlerowid.trim() };

				allData.addAll(jdbcTemplate.queryForList(sql, args));
			}
		}

		model.addAttribute("reportdetails", allData);
		model.addAttribute("formmode", formmode);

		return "RT/Liquidity_Risk_Dashboard_Template";
	}
	
	
	@RequestMapping(value = "RT_MC_Reports", method = RequestMethod.GET)
	public String RT_MC_Reports(@RequestParam(required = false) String formmode,@RequestParam(required = false) String reportDate,
			@RequestParam(required = false) String branch, @RequestParam(required = false) String deptvalid,@RequestParam(required = false) String dept,@RequestParam(required = false) String mgrsummary,@RequestParam(required = false) String timeperiod, Model md,
			HttpServletRequest req) {

		String BRANCHCODE = (String) req.getSession().getAttribute("BRANCHCODE");
		String ROLEID = (String) req.getSession().getAttribute("ROLEID");
		String DESIGNATION = (String) req.getSession().getAttribute("DESIGNATION");
		md.addAttribute("ROLEID", ROLEID);
		md.addAttribute("DESIGNATION", DESIGNATION);
		System.out.println("ROLEID : " + ROLEID);
		if (deptvalid == null) {
			deptvalid = "NO";
		}
		if (mgrsummary == null) {
			mgrsummary = "NO";
		}
		md.addAttribute("mgrsummary", mgrsummary);
		System.out.println("DEPARTMENT VALIDATION : " + deptvalid);
		String DEPARTMENT ;
		if(dept==null || dept.isEmpty()) {
			DEPARTMENT = (String) req.getSession().getAttribute("DEPARTMENT");
		}
		else {
			DEPARTMENT=dept;
		}
		md.addAttribute("DEPARTMENT", DEPARTMENT);
		System.out.println("DEPARTMENT : " + DEPARTMENT);

		if (branch == null || branch.isEmpty()) {
			branch = BRANCHCODE;
			md.addAttribute("BRANCHCODE", BRANCHCODE);
		} else {
			md.addAttribute("BRANCHCODE", branch);
		}
		List<String> dropdownOptions = Arrays.asList("IT", "Risk", "HR", "Operations","CFO","CED","Digital","FRM","Retail-CASA","ISO","Retail/SME","Recovery","Marketing","IA","Compliance");
		md.addAttribute("md", dropdownOptions);
		System.out.println("branch : " + branch);
		
		if (reportDate == null || reportDate.isEmpty()) {
			Map<String, Object> latestReportData = RT_MC_TABLE1_REPO.findLatestReportDateAndTimeperiod();
			if (latestReportData != null && !latestReportData.isEmpty()) {
				reportDate = (String) latestReportData.get("REPORT_DATE_STRING");
				timeperiod = (String) latestReportData.get("BRANCH_CODE");
				System.out.println("Latest Date: " + reportDate);
				System.out.println("Time Period: " + timeperiod);
			}
		}

		if(reportDate == null || reportDate.isEmpty()) {
			reportDate="31-03-2026";
		}
		if (timeperiod == null) {
			timeperiod = "QUARTERLY";
		}
		md.addAttribute("REPORT_DATE", reportDate);
		md.addAttribute("timeperiod", timeperiod);
		String sessionId = req.getSession().getId();
		//System.out.println("Session ID : "+sessionId);
		
		if((ROLEID=="MGR"|| ROLEID.equals("MGR")||ROLEID=="SUP-ADM"||ROLEID.equals("SUP-ADM")||ROLEID=="ADM-M"||ROLEID.equals("ADM-M")||ROLEID=="ADM-C"||ROLEID.equals("ADM-C") )&& !(deptvalid == "YES" || deptvalid.equals("YES"))) {
			mgrsummary = "YES";
//			if ("bankinformation".equalsIgnoreCase(formmode) || formmode == null || "null".equalsIgnoreCase(formmode)) {
//				
//				Map<String, Object> reportData = rT_MC_TABLE_Service.getManagerViewData(reportDate,timeperiod);
//		        
//		        md.addAttribute("quarterDates", reportData.get("headerDates"));
//		        md.addAttribute("reportRows", reportData.get("reportRows"));
//		        md.addAttribute("yearDates", reportData.get("yearDates"));
//		        
//				md.addAttribute("formmode", "bankinformation");
//			}
}
//		else {
			md.addAttribute("mgrscreen", mgrsummary);
		if ("bankinformation".equalsIgnoreCase(formmode) || formmode == null || "null".equalsIgnoreCase(formmode)) {
			if (deptvalid == "YES" || deptvalid.equals("YES")) {
				List<RT_MC_TABLE1_ENTITY> reportlist = RT_MC_TABLE1_REPO.findBybranchcode("DEPT");

				if (reportlist == null || reportlist.isEmpty()) {
					System.out.println("Report Date : " + formatDate(reportlist.get(0).getREPORT_DATE()));
					executeprocedure(
							"RT_MC_TABLE1_PROCEDURE('" + formatDate(reportlist.get(0).getREPORT_DATE()) + "', 'DEPT')");
					reportlist = RT_MC_TABLE1_REPO.findBybranchcode("DEPT");
				}
				
				System.out.println("size : " + reportlist.size());
				md.addAttribute("reportlist", reportlist);
				md.addAttribute("DEPARTMENTVALIDATION", "YES");
			} else {				
		        if(mgrsummary == "YES" || mgrsummary.equals("YES")) {
		        	formmode= "bankinformation";
					Map<String, Object> reportData = rT_MC_TABLE_Service.getManagerViewData(formmode,reportDate,timeperiod);
			        md.addAttribute("quarterDates", reportData.get("headerDates"));
			        md.addAttribute("reportRows", reportData.get("reportRows"));
			        md.addAttribute("yearDates", reportData.get("yearDates"));
		        }
		        
				List<RT_MC_TABLE1_ENTITY> reportlist = RT_MC_TABLE1_REPO.findByReportDateAndBranchCode(reportDate,timeperiod);
				System.out.println("size : " + reportlist.size());
				md.addAttribute("reportlist", reportlist);

				List<RT_MC_TABLE1_ENTITY> deptreportlist = RT_MC_TABLE1_REPO.findBybranchcode("DEPT");

				if ((deptreportlist == null || deptreportlist.isEmpty())
						&& (reportlist != null && !reportlist.isEmpty())) {
					System.out.println("Report Date : " + formatDate(reportlist.get(0).getREPORT_DATE()));
					executeprocedure(
							"RT_MC_TABLE1_PROCEDURE('" + formatDate(reportlist.get(0).getREPORT_DATE()) + "', 'DEPT')");
					deptreportlist = RT_MC_TABLE1_REPO.findBybranchcode("DEPT");
				}

				System.out.println("size : " + deptreportlist.size());
				if (deptreportlist != null && !deptreportlist.isEmpty()) {
				    md.addAttribute("deptreportlist", deptreportlist.get(0));
				}

				md.addAttribute("DEPARTMENTVALIDATION", "NO");
			}
			md.addAttribute("formmode", "bankinformation");
		}

		else if ("bankconsumers".equalsIgnoreCase(formmode)) {
			if (deptvalid == "YES" || deptvalid.equals("YES")) {
				List<RT_MC_TABLE2_1_ENTITY> reportlist1 = RT_MC_TABLE2_1_REPO.findBybranchcode("DEPT");
				List<RT_MC_TABLE2_2_ENTITY> reportlist2 = RT_MC_TABLE2_2_REPO.findBybranchcode("DEPT");

				if (reportlist1 == null || reportlist1.isEmpty()) {
					System.out.println("Report Date :" + formatDate(reportlist1.get(0).getREPORT_DATE()));
					executeprocedure("RT_MC_TABLE2_PROCEDURE('" + formatDate(reportlist1.get(0).getREPORT_DATE())
							+ "', 'DEPT')");
					reportlist1 = RT_MC_TABLE2_1_REPO.findBybranchcode("DEPT");
					reportlist2 = RT_MC_TABLE2_2_REPO.findBybranchcode("DEPT");
				}
				
				md.addAttribute("reportlist1", reportlist1);
				md.addAttribute("reportlist2", reportlist2);
				md.addAttribute("DEPARTMENTVALIDATION", "YES");

			} else {
				 if(mgrsummary == "YES" || mgrsummary.equals("YES")) {
						Map<String, Object> reportData = rT_MC_TABLE_Service.getManagerViewData(formmode,reportDate,timeperiod);
				        md.addAttribute("quarterDates", reportData.get("headerDates"));
				        md.addAttribute("reportRows", reportData.get("reportRows"));
				        md.addAttribute("yearDates", reportData.get("yearDates"));
			        }
				List<RT_MC_TABLE2_1_ENTITY> reportlist1 = RT_MC_TABLE2_1_REPO.findByReportDateAndBranchCode(reportDate,timeperiod);
				List<RT_MC_TABLE2_2_ENTITY> reportlist2 = RT_MC_TABLE2_2_REPO.findByReportDateAndBranchCode(reportDate,timeperiod);
				md.addAttribute("reportlist1", reportlist1);
				md.addAttribute("reportlist2", reportlist2);

				List<RT_MC_TABLE2_1_ENTITY> deptreportlist1 = RT_MC_TABLE2_1_REPO.findBybranchcode("DEPT");
				List<RT_MC_TABLE2_2_ENTITY> deptreportlist2 = RT_MC_TABLE2_2_REPO.findBybranchcode("DEPT");

				if ((deptreportlist1 == null || deptreportlist1.isEmpty())
						&& (reportlist1 != null && !reportlist1.isEmpty())) {
					 System.out.println("Report Date :"+formatDate(reportlist1.get(0).getREPORT_DATE()));
					executeprocedure("RT_MC_TABLE2_PROCEDURE('" + formatDate(reportlist1.get(0).getREPORT_DATE())
							+ "', 'DEPT')");
					deptreportlist1 = RT_MC_TABLE2_1_REPO.findBybranchcode("DEPT");
					deptreportlist2 = RT_MC_TABLE2_2_REPO.findBybranchcode("DEPT");
				}
				if (deptreportlist1 != null && !deptreportlist1.isEmpty() && deptreportlist2 != null && !deptreportlist2.isEmpty()) {
					md.addAttribute("deptreportlist", deptreportlist1.get(0));
					md.addAttribute("deptreportlist2", deptreportlist2.get(0));
				}
				
				md.addAttribute("DEPARTMENTVALIDATION", "NO");

			}

			md.addAttribute("formmode", "bankconsumers");
		}

		else if ("complaints".equalsIgnoreCase(formmode)) {

			if (deptvalid == "YES" || deptvalid.equals("YES")) {
				List<RT_MC_TABLE3_ENTITY> reportlist = RT_MC_TABLE3_REPO.findBybranchcode("DEPT");

				if (reportlist == null || reportlist.isEmpty()) {
					System.out.println("Report Date : " + formatDate(reportlist.get(0).getREPORT_DATE()));
					executeprocedure(
							"RT_MC_TABLE3_PROCEDURE('" + formatDate(reportlist.get(0).getREPORT_DATE()) + "', 'DEPT')");
					reportlist = RT_MC_TABLE3_REPO.findBybranchcode("DEPT");
				}
				
				System.out.println("size : " + reportlist.size());
				md.addAttribute("reportlist", reportlist);
				md.addAttribute("DEPARTMENTVALIDATION", "YES");
			} else {
				if(mgrsummary == "YES" || mgrsummary.equals("YES")) {
					Map<String, Object> reportData = rT_MC_TABLE_Service.getManagerViewData(formmode,reportDate,timeperiod);
			        md.addAttribute("quarterDates", reportData.get("headerDates"));
			        md.addAttribute("reportRows", reportData.get("reportRows"));
			        md.addAttribute("yearDates", reportData.get("yearDates"));
		        }
				List<RT_MC_TABLE3_ENTITY> reportlist = RT_MC_TABLE3_REPO.findByReportDateAndBranchCode(reportDate,timeperiod);
				 System.out.println("Branch : " + branch);
				 System.out.println("TABLE3 Size : " + reportlist.size());

				md.addAttribute("reportlist", reportlist);

				List<RT_MC_TABLE3_ENTITY> deptreportlist = RT_MC_TABLE3_REPO.findBybranchcode("DEPT");

				if ((deptreportlist == null || deptreportlist.isEmpty())
						&& (reportlist != null && !reportlist.isEmpty())) {
					System.out.println("Report Date : " + formatDate(reportlist.get(0).getREPORT_DATE()));
					executeprocedure(
							"RT_MC_TABLE3_PROCEDURE('" + formatDate(reportlist.get(0).getREPORT_DATE()) + "', 'DEPT')");
					deptreportlist = RT_MC_TABLE3_REPO.findBybranchcode("DEPT");
				}

				System.out.println("size : " + deptreportlist.size());
				if (deptreportlist != null && !deptreportlist.isEmpty()) {
				    md.addAttribute("deptreportlist", deptreportlist.get(0));
				}

				md.addAttribute("DEPARTMENTVALIDATION", "NO");

			}
			md.addAttribute("formmode", "complaints");
		} else if ("retailproducts".equalsIgnoreCase(formmode)) {

			if (deptvalid == "YES" || deptvalid.equals("YES")) {
				List<RT_MC_TABLE4_1_ENTITY> reportlist1 = RT_MC_TABLE4_1_REPO.findBybranchcode("DEPT");
				List<RT_MC_TABLE4_2_ENTITY> reportlist2 = RT_MC_TABLE4_2_REPO.findBybranchcode("DEPT");

				if (reportlist1 == null || reportlist1.isEmpty()) {
					System.out.println("Report Date : " + formatDate(reportlist1.get(0).getREPORT_DATE()));
					executeprocedure("RT_MC_TABLE4_PROCEDURE('" + formatDate(reportlist1.get(0).getREPORT_DATE())
							+ "', 'DEPT')");
					reportlist1 = RT_MC_TABLE4_1_REPO.findBybranchcode("DEPT");
					reportlist2 = RT_MC_TABLE4_2_REPO.findBybranchcode("DEPT");
				}

				md.addAttribute("reportlist", reportlist1);
				md.addAttribute("reportlist1", reportlist2);
				md.addAttribute("DEPARTMENTVALIDATION", "YES");

			} else {
				if(mgrsummary == "YES" || mgrsummary.equals("YES")) {
					Map<String, Object> reportData = rT_MC_TABLE_Service.getManagerViewData(formmode,reportDate,timeperiod);
			        md.addAttribute("quarterDates", reportData.get("headerDates"));
			        md.addAttribute("reportRows", reportData.get("reportRows"));
			        md.addAttribute("yearDates", reportData.get("yearDates"));
		        }
				List<RT_MC_TABLE4_1_ENTITY> reportlist = RT_MC_TABLE4_1_REPO.findByReportDateAndBranchCode(reportDate,timeperiod);
				 System.out.println("Branch : " + branch);
				 System.out.println("TABLE4 Size : " + reportlist.size());
				List<RT_MC_TABLE4_2_ENTITY> reportlist1 = RT_MC_TABLE4_2_REPO.findByReportDateAndBranchCode(reportDate,timeperiod);
				md.addAttribute("reportlist", reportlist);
				md.addAttribute("reportlist1", reportlist1);

				List<RT_MC_TABLE4_1_ENTITY> deptreportlist1 = RT_MC_TABLE4_1_REPO.findBybranchcode("DEPT");
				List<RT_MC_TABLE4_2_ENTITY> deptreportlist2 = RT_MC_TABLE4_2_REPO.findBybranchcode("DEPT");

				if ((deptreportlist1 == null || deptreportlist1.isEmpty())
						&& (reportlist1 != null && !reportlist1.isEmpty())) {
					 System.out.println("Report Date : "+formatDate(reportlist.get(0).getREPORT_DATE()));
					executeprocedure("RT_MC_TABLE4_PROCEDURE('" + formatDate(reportlist1.get(0).getREPORT_DATE())
							+ "', 'DEPT')");
					deptreportlist1 = RT_MC_TABLE4_1_REPO.findBybranchcode("DEPT");
					deptreportlist2 = RT_MC_TABLE4_2_REPO.findBybranchcode("DEPT");
				}

				if (deptreportlist1 != null && !deptreportlist1.isEmpty() && deptreportlist2 != null && !deptreportlist2.isEmpty()) {
					md.addAttribute("deptreportlist", deptreportlist1.get(0));
					md.addAttribute("deptreportlist2", deptreportlist2.get(0));
				}
				md.addAttribute("DEPARTMENTVALIDATION", "NO");

			}
			md.addAttribute("formmode", "retailproducts");
		} else if ("bankemployee".equalsIgnoreCase(formmode)) {
			if (deptvalid == "YES" || deptvalid.equals("YES")) {
				List<RT_MC_TABLE5_ENTITY> reportlist = RT_MC_TABLE5_REPO.findBybranchcode("DEPT");

				if (reportlist == null || reportlist.isEmpty()) {
					System.out.println("Report Date : " + formatDate(reportlist.get(0).getREPORT_DATE()));
					executeprocedure(
							"RT_MC_TABLE5_PROCEDURE('" + formatDate(reportlist.get(0).getREPORT_DATE()) + "', 'DEPT')");
					reportlist = RT_MC_TABLE5_REPO.findBybranchcode("DEPT");
				}

				System.out.println("size : " + reportlist.size());
				md.addAttribute("reportlist", reportlist);
				md.addAttribute("DEPARTMENTVALIDATION", "YES");
			} else {
				if(mgrsummary == "YES" || mgrsummary.equals("YES")) {
					Map<String, Object> reportData = rT_MC_TABLE_Service.getManagerViewData(formmode,reportDate,timeperiod);
			        md.addAttribute("quarterDates", reportData.get("headerDates"));
			        md.addAttribute("reportRows", reportData.get("reportRows"));
			        md.addAttribute("yearDates", reportData.get("yearDates"));
		        }
				List<RT_MC_TABLE5_ENTITY> reportlist = RT_MC_TABLE5_REPO.findByReportDateAndBranchCode(reportDate,timeperiod);
				 System.out.println("size : " + reportlist.size());
				md.addAttribute("reportlist", reportlist);

				List<RT_MC_TABLE5_ENTITY> deptreportlist = RT_MC_TABLE5_REPO.findBybranchcode("DEPT");

				if ((deptreportlist == null || deptreportlist.isEmpty())
						&& (reportlist != null && !reportlist.isEmpty())) {
					 System.out.println("Report Date : " +
					 formatDate(reportlist.get(0).getREPORT_DATE()));
					executeprocedure(
							"RT_MC_TABLE5_PROCEDURE('" + formatDate(reportlist.get(0).getREPORT_DATE()) + "', 'DEPT')");
					deptreportlist = RT_MC_TABLE5_REPO.findBybranchcode("DEPT");
				}

				 System.out.println("size : " + deptreportlist.size());
				if (deptreportlist != null && !deptreportlist.isEmpty()) {
				    md.addAttribute("deptreportlist", deptreportlist.get(0));
				}

				md.addAttribute("DEPARTMENTVALIDATION", "NO");
			}

			md.addAttribute("formmode", "bankemployee");
		} else if ("trainings".equalsIgnoreCase(formmode)) {
			if (deptvalid == "YES" || deptvalid.equals("YES")) {
				List<RT_MC_TABLE6_ENTITY> reportlist = RT_MC_TABLE6_REPO.findBybranchcode("DEPT");
				if (reportlist == null || reportlist.isEmpty()) {
					System.out.println("Report Date : " + formatDate(reportlist.get(0).getREPORT_DATE()));
					executeprocedure(
							"RT_MC_TABLE6_PROCEDURE('" + formatDate(reportlist.get(0).getREPORT_DATE()) + "', 'DEPT')");
					reportlist = RT_MC_TABLE6_REPO.findBybranchcode("DEPT");
				}
				System.out.println("size : " + reportlist.size());
				md.addAttribute("reportlist", reportlist);
				md.addAttribute("DEPARTMENTVALIDATION", "YES");
			} else {
				if(mgrsummary == "YES" || mgrsummary.equals("YES")) {
					Map<String, Object> reportData = rT_MC_TABLE_Service.getManagerViewData(formmode,reportDate,timeperiod);
			        md.addAttribute("quarterDates", reportData.get("headerDates"));
			        md.addAttribute("reportRows", reportData.get("reportRows"));
			        md.addAttribute("yearDates", reportData.get("yearDates"));
		        }
				List<RT_MC_TABLE6_ENTITY> reportlist = RT_MC_TABLE6_REPO.findByReportDateAndBranchCode(reportDate,timeperiod);
				System.out.println("size : " + reportlist.size());
				md.addAttribute("reportlist", reportlist);

				List<RT_MC_TABLE6_ENTITY> deptreportlist = RT_MC_TABLE6_REPO.findBybranchcode("DEPT");

				if ((deptreportlist == null || deptreportlist.isEmpty())
						&& (reportlist != null && !reportlist.isEmpty())) {
					 System.out.println("Report Date : " +
					 formatDate(reportlist.get(0).getREPORT_DATE()));
					executeprocedure(
							"RT_MC_TABLE6_PROCEDURE('" + formatDate(reportlist.get(0).getREPORT_DATE()) + "', 'DEPT')");
					deptreportlist = RT_MC_TABLE6_REPO.findBybranchcode("DEPT");
				}

				 System.out.println("size : " + deptreportlist.size());
				if (deptreportlist != null && !deptreportlist.isEmpty()) {
				    md.addAttribute("deptreportlist", deptreportlist.get(0));
				}

				md.addAttribute("DEPARTMENTVALIDATION", "NO");
			}

			md.addAttribute("formmode", "trainings");
		} else if ("additionalinformation".equalsIgnoreCase(formmode)) {

			if (deptvalid == "YES" || deptvalid.equals("YES")) {
				List<RT_MC_TABLE7_1_ENTITY> reportlist1 = RT_MC_TABLE7_1_REPO.findBybranchcode("DEPT");
				List<RT_MC_TABLE7_2_ENTITY> reportlist2 = RT_MC_TABLE7_2_REPO.findBybranchcode("DEPT");

				if (reportlist1 == null || reportlist1.isEmpty()) {
					System.out.println("Report Date :	 " + formatDate(reportlist1.get(0).getREPORT_DATE()));
					executeprocedure("RT_MC_TABLE7_PROCEDURE('" + formatDate(reportlist1.get(0).getREPORT_DATE())
							+ "', 'DEPT')");
					reportlist1 = RT_MC_TABLE7_1_REPO.findBybranchcode("DEPT");
					reportlist2 = RT_MC_TABLE7_2_REPO.findBybranchcode("DEPT");
				}
				
				md.addAttribute("reportlist1", reportlist1);
				md.addAttribute("reportlist2", reportlist2);
				md.addAttribute("DEPARTMENTVALIDATION", "YES");

			} else {
				if(mgrsummary == "YES" || mgrsummary.equals("YES")) {
					Map<String, Object> reportData = rT_MC_TABLE_Service.getManagerViewData(formmode,reportDate,timeperiod);
			        md.addAttribute("quarterDates", reportData.get("headerDates"));
			        md.addAttribute("reportRows", reportData.get("reportRows"));
			        md.addAttribute("yearDates", reportData.get("yearDates"));
		        }
				List<RT_MC_TABLE7_1_ENTITY> reportlist1 = RT_MC_TABLE7_1_REPO.findByReportDateAndBranchCode(reportDate,timeperiod);
				List<RT_MC_TABLE7_2_ENTITY> reportlist2 = RT_MC_TABLE7_2_REPO.findByReportDateAndBranchCode(reportDate,timeperiod);
				md.addAttribute("reportlist1", reportlist1);
				md.addAttribute("reportlist2", reportlist2);

				List<RT_MC_TABLE7_1_ENTITY> deptreportlist1 = RT_MC_TABLE7_1_REPO.findBybranchcode("DEPT");
				List<RT_MC_TABLE7_2_ENTITY> deptreportlist2 = RT_MC_TABLE7_2_REPO.findBybranchcode("DEPT");

				if ((deptreportlist1 == null || deptreportlist1.isEmpty())
						&& (reportlist1 != null && !reportlist1.isEmpty())) {
					 System.out.println("Report Date :	 "+formatDate(reportlist1.get(0).getREPORT_DATE()));
					executeprocedure("RT_MC_TABLE7_PROCEDURE('" + formatDate(reportlist1.get(0).getREPORT_DATE())
							+ "', 'DEPT')");
					deptreportlist1 = RT_MC_TABLE7_1_REPO.findBybranchcode("DEPT");
					deptreportlist2 = RT_MC_TABLE7_2_REPO.findBybranchcode("DEPT");
				}

				if (deptreportlist1 != null && !deptreportlist1.isEmpty() && deptreportlist2 != null && !deptreportlist2.isEmpty()) {
					md.addAttribute("deptreportlist", deptreportlist1.get(0));
					md.addAttribute("deptreportlist2", deptreportlist2.get(0));
				}
				md.addAttribute("DEPARTMENTVALIDATION", "NO");

			}
			md.addAttribute("formmode", "additionalinformation");
		} else if ("islamicbanking".equalsIgnoreCase(formmode)) {

			if (deptvalid == "YES" || deptvalid.equals("YES")) {
				List<RT_MC_TABLE8_ENTITY> reportlist = RT_MC_TABLE8_REPO.findBybranchcode("DEPT");

				if (reportlist == null || reportlist.isEmpty()) {
					System.out.println("Report Date : " + formatDate(reportlist.get(0).getREPORT_DATE()));
					executeprocedure(
							"RT_MC_TABLE8_PROCEDURE('" + formatDate(reportlist.get(0).getREPORT_DATE()) + "', 'DEPT')");
					reportlist = RT_MC_TABLE8_REPO.findBybranchcode("DEPT");
				}

				System.out.println("size : " + reportlist.size());
				md.addAttribute("reportlist", reportlist);
				md.addAttribute("DEPARTMENTVALIDATION", "YES");
			} else {
				if(mgrsummary == "YES" || mgrsummary.equals("YES")) {
					Map<String, Object> reportData = rT_MC_TABLE_Service.getManagerViewData(formmode,reportDate,timeperiod);
			        md.addAttribute("quarterDates", reportData.get("headerDates"));
			        md.addAttribute("reportRows", reportData.get("reportRows"));
			        md.addAttribute("yearDates", reportData.get("yearDates"));
		        }
				List<RT_MC_TABLE8_ENTITY> reportlist = RT_MC_TABLE8_REPO.findByReportDateAndBranchCode(reportDate,timeperiod);
				 System.out.println("size : " + reportlist.size());
				md.addAttribute("reportlist", reportlist);

				List<RT_MC_TABLE8_ENTITY> deptreportlist = RT_MC_TABLE8_REPO.findBybranchcode("DEPT");

				if ((deptreportlist == null || deptreportlist.isEmpty())
						&& (reportlist != null && !reportlist.isEmpty())) {
					 System.out.println("Report Date : " +					 formatDate(reportlist.get(0).getREPORT_DATE()));
					executeprocedure(
							"RT_MC_TABLE8_PROCEDURE('" + formatDate(reportlist.get(0).getREPORT_DATE()) + "', 'DEPT')");
					deptreportlist = RT_MC_TABLE8_REPO.findBybranchcode("DEPT");
				}

				 System.out.println("size : " + deptreportlist.size());
				if (deptreportlist != null && !deptreportlist.isEmpty()) {
				    md.addAttribute("deptreportlist", deptreportlist.get(0));
				}

				md.addAttribute("DEPARTMENTVALIDATION", "NO");
			}

			md.addAttribute("formmode", "islamicbanking");
		} else if ("conductcultureassessment".equalsIgnoreCase(formmode)) {
			if (deptvalid == "YES" || deptvalid.equals("YES")) {
				List<RT_MC_TABLE9_ENTITY> reportlist = RT_MC_TABLE9_REPO.findBybranchcode("DEPT");

				if (reportlist == null || reportlist.isEmpty()) {
					System.out.println("Report Date : " + formatDate(reportlist.get(0).getREPORT_DATE()));
					executeprocedure(
							"RT_MC_TABLE9_PROCEDURE('" + formatDate(reportlist.get(0).getREPORT_DATE()) + "', 'DEPT')");
					reportlist = RT_MC_TABLE9_REPO.findBybranchcode("DEPT");
				}
				
				System.out.println("size : " + reportlist.size());
				md.addAttribute("reportlist", reportlist);
				md.addAttribute("DEPARTMENTVALIDATION", "YES");
			} else {
				List<RT_MC_TABLE9_ENTITY> reportlist = RT_MC_TABLE9_REPO.findByReportDateAndBranchCode(reportDate,timeperiod);
				 System.out.println("size : " + reportlist.size());
				md.addAttribute("reportlist", reportlist);

				List<RT_MC_TABLE9_ENTITY> deptreportlist = RT_MC_TABLE9_REPO.findBybranchcode("DEPT");

				if ((deptreportlist == null || deptreportlist.isEmpty())
						&& (reportlist != null && !reportlist.isEmpty())) {
					 System.out.println("Report Date : " +					 formatDate(reportlist.get(0).getREPORT_DATE()));
					executeprocedure(
							"RT_MC_TABLE9_PROCEDURE('" + formatDate(reportlist.get(0).getREPORT_DATE()) + "', 'DEPT')");
					deptreportlist = RT_MC_TABLE9_REPO.findBybranchcode("DEPT");
				}

				 System.out.println("size : " + deptreportlist.size());
				if (deptreportlist != null && !deptreportlist.isEmpty()) {
				    md.addAttribute("deptreportlist", deptreportlist.get(0));
				}

				md.addAttribute("DEPARTMENTVALIDATION", "NO");
			}

			md.addAttribute("formmode", "conductcultureassessment");
		}
		//}
		return "RBS_MC_Reports";
	}
	public static String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(date);
    }

	
	public void executeprocedure(String procString) {        
        String sql = "{call " + procString + "}";         
        jdbcTemplate.execute(sql);
    }


	@PostMapping("/saveMcReport_bankinformation")
	@ResponseBody
	public ResponseEntity<String> saveReport_bankinformation(@ModelAttribute RT_MC_TABLE1_ENTITY reportData,
			HttpServletRequest req) {

		try {
			System.out.println("branch: " + reportData.getBRANCH_CODE());
			String userid = (String) req.getSession().getAttribute("USERID");
			rT_MC_TABLE_Service.MC_TABLE1_Modify(reportData);
			reportData.setMODIFY_USERID(userid);
			RT_MC_TABLE1_REPO.save(reportData);
			return ResponseEntity.ok("Success");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving data");
		}
	}

	@PostMapping("/verifyMcReport_bankinformation")
	@ResponseBody
	public ResponseEntity<String> verifyReport_bankinformation(@ModelAttribute RT_MC_TABLE1_ENTITY reportData,
			HttpServletRequest req) {
		try {
			String userid = (String) req.getSession().getAttribute("USERID");
			if (reportData.getMODIFY_USERID() == userid || userid.equals(reportData.getMODIFY_USERID())) {
				return ResponseEntity.status(500).body("Same User can not Verify");
			} else {
				reportData.setVERIFY_FLG("Y");
				reportData.setVERIFY_USERID(userid);
				auditService.createBusinessAudit(reportData.getREPORT_DATE() + " - " + reportData.getBRANCH_CODE(), "VERIFY", "RBS_MC_TABLE1_Bank_Information", null,"RT_MC_TABLE1");
				RT_MC_TABLE1_REPO.save(reportData);
				return ResponseEntity.ok("Verified");
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error verifying data");
		}
	}

	@PostMapping("/saveMcReport_bankconsumers")
	@ResponseBody
	public ResponseEntity<String> saveReport_bankconsumers(@ModelAttribute RT_MC_TABLE2_1_ENTITY reportData1,
			RT_MC_TABLE2_2_ENTITY reportData2, HttpServletRequest req) {

		try {
			System.out.println("branch: " + reportData1.getBRANCH_CODE());
			String userid = (String) req.getSession().getAttribute("USERID");
			rT_MC_TABLE_Service.MC_TABLE2_1_Modify(reportData1);
			rT_MC_TABLE_Service.MC_TABLE2_2_Modify(reportData2);
			reportData1.setMODIFY_USERID(userid);
			reportData2.setMODIFY_USERID(userid);
			RT_MC_TABLE2_1_REPO.save(reportData1);
			RT_MC_TABLE2_2_REPO.save(reportData2);
			return ResponseEntity.ok("Success");

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving data");
		}
	}

	@PostMapping("/verifyMcReport_bankconsumers")
	@ResponseBody
	public ResponseEntity<String> verifyReport_bankconsumers(@ModelAttribute RT_MC_TABLE2_1_ENTITY reportData1,
			RT_MC_TABLE2_2_ENTITY reportData2, HttpServletRequest req) {
		try {
			String userid = (String) req.getSession().getAttribute("USERID");
			if (reportData1.getMODIFY_USERID() == userid || userid.equals(reportData1.getMODIFY_USERID())) {
				return ResponseEntity.status(500).body("Same User can not Verify");
			} else {
				reportData1.setVERIFY_FLG("Y");
				reportData1.setVERIFY_USERID(userid);
				reportData2.setVERIFY_FLG("Y");
				reportData2.setVERIFY_USERID(userid);
				auditService.createBusinessAudit(reportData1.getREPORT_DATE() + " - " + reportData1.getBRANCH_CODE(), "VERIFY", "RBS_MC_TABLE2_Bank_Consumers", null,"RT_MC_TABLE2_1");
				auditService.createBusinessAudit(reportData2.getREPORT_DATE() + " - " + reportData2.getBRANCH_CODE(), "VERIFY", "RBS_MC_TABLE2_Bank_Consumers", null,"RT_MC_TABLE2_2");
				RT_MC_TABLE2_1_REPO.save(reportData1);
				RT_MC_TABLE2_2_REPO.save(reportData2);
				return ResponseEntity.ok("Verified");
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error verifying data");
		}
	}

	@PostMapping("/saveMcReport_bankemployee")
	@ResponseBody
	public ResponseEntity<String> saveReport_bankemployee(@ModelAttribute RT_MC_TABLE5_ENTITY reportData,
			HttpServletRequest req) {

		try {
			System.out.println("branch: " + reportData.getBRANCH_CODE());
			String userid = (String) req.getSession().getAttribute("USERID");
			reportData.setMODIFY_USERID(userid);
			rT_MC_TABLE_Service.MC_TABLE5_Modify(reportData);
			RT_MC_TABLE5_REPO.save(reportData);

			return ResponseEntity.ok("Success");

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving data");
		}
	}

	@PostMapping("/verifyMcReport_bankemployee")
	@ResponseBody
	public ResponseEntity<String> verifyReport_bankemployee(@ModelAttribute RT_MC_TABLE5_ENTITY reportData,
			HttpServletRequest req) {
		try {
			String userid = (String) req.getSession().getAttribute("USERID");
			if (reportData.getMODIFY_USERID() == userid || userid.equals(reportData.getMODIFY_USERID())) {
				return ResponseEntity.status(500).body("Same User can not Verify");
			} else {
				reportData.setVERIFY_FLG("Y");
				reportData.setVERIFY_USERID(userid);
				auditService.createBusinessAudit(reportData.getREPORT_DATE() + " - " + reportData.getBRANCH_CODE(), "VERIFY", "RBS_MC_TABLE5_Bank_Employee", null,"RT_MC_TABLE5");
				RT_MC_TABLE5_REPO.save(reportData);
				return ResponseEntity.ok("Verified");
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error verifying data");
		}
	}

	@PostMapping("/saveMcReport_trainings")
	@ResponseBody
	public ResponseEntity<String> saveReport_trainings(@ModelAttribute RT_MC_TABLE6_ENTITY reportData,
			HttpServletRequest req) {

		try {
			System.out.println("branch: " + reportData.getBRANCH_CODE());
			String userid = (String) req.getSession().getAttribute("USERID");
			reportData.setMODIFY_USERID(userid);
			rT_MC_TABLE_Service.MC_TABLE6_Modify(reportData);
			RT_MC_TABLE6_REPO.save(reportData);

			return ResponseEntity.ok("Success");

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving data");
		}
	}

	@PostMapping("/verifyMcReport_trainings")
	@ResponseBody
	public ResponseEntity<String> verifyReport_trainings(@ModelAttribute RT_MC_TABLE6_ENTITY reportData,
			HttpServletRequest req) {
		try {
			String userid = (String) req.getSession().getAttribute("USERID");
			if (reportData.getMODIFY_USERID() == userid || userid.equals(reportData.getMODIFY_USERID())) {
				return ResponseEntity.status(500).body("Same User can not Verify");
			} else {
				reportData.setVERIFY_FLG("Y");
				reportData.setVERIFY_USERID(userid);
				auditService.createBusinessAudit(reportData.getREPORT_DATE() + " - " + reportData.getBRANCH_CODE(), "VERIFY", "RBS_MC_TABLE6_Trainings", null,"RT_MC_TABLE6");
				RT_MC_TABLE6_REPO.save(reportData);
				return ResponseEntity.ok("Verified");
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error verifying data");
		}
	}
	

	@PostMapping("/saveMcReport_complaints")
	@ResponseBody
	public ResponseEntity<String> saveReport_complaints(@ModelAttribute RT_MC_TABLE3_ENTITY reportData,
			HttpServletRequest req) {
		try {
			System.out.println("branch: " + reportData.getBRANCH_CODE());
			String userid = (String) req.getSession().getAttribute("USERID");
			reportData.setMODIFY_USERID(userid);
			rT_MC_TABLE_Service.MC_TABLE3_Modify(reportData);
			RT_MC_TABLE3_REPO.save(reportData);
			return ResponseEntity.ok("Success");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving data");
		}
	}

	@PostMapping("/verifyMcReport_complaints")
	@ResponseBody
	public ResponseEntity<String> verifyReport_complaints(@ModelAttribute RT_MC_TABLE3_ENTITY reportData,
			HttpServletRequest req) {
		try {
			String userid = (String) req.getSession().getAttribute("USERID");
			if (reportData.getMODIFY_USERID() == userid || userid.equals(reportData.getMODIFY_USERID())) {
				return ResponseEntity.status(500).body("Same User can not Verify");
			} else {
				reportData.setVERIFY_FLG("Y");
				reportData.setVERIFY_USERID(userid);
				auditService.createBusinessAudit(reportData.getREPORT_DATE() + " - " + reportData.getBRANCH_CODE(), "VERIFY", "RBS_MC_TABLE3_Complaints", null,"RT_MC_TABLE3");
				RT_MC_TABLE3_REPO.save(reportData);
				return ResponseEntity.ok("Verified");
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error verifying data");
		}
	}
	
	@PostMapping("/saveMcReport_retailproducts")
	@ResponseBody
	public ResponseEntity<String> saveReport_retailproducts(@ModelAttribute RT_MC_TABLE4_1_ENTITY reportData1,
			RT_MC_TABLE4_2_ENTITY reportData2, HttpServletRequest req) {

		try {
			System.out.println("branch: " + reportData1.getBRANCH_CODE());
			System.out.println("R6_BANK: " + reportData1.getR6_BANK());
			String userid = (String) req.getSession().getAttribute("USERID");
			rT_MC_TABLE_Service.MC_TABLE4_1_Modify(reportData1);
			rT_MC_TABLE_Service.MC_TABLE4_2_Modify(reportData2);
			reportData1.setMODIFY_USERID(userid);
			reportData2.setMODIFY_USERID(userid);
			RT_MC_TABLE4_1_REPO.save(reportData1);
			RT_MC_TABLE4_2_REPO.save(reportData2);
			return ResponseEntity.ok("Success");

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving data");
		}
	}

	@PostMapping("/verifyMcReport_retailproducts")
	@ResponseBody
	public ResponseEntity<String> verifyReport_retailproducts(@ModelAttribute RT_MC_TABLE4_1_ENTITY reportData1,
			RT_MC_TABLE4_2_ENTITY reportData2, HttpServletRequest req) {
		try {
			String userid = (String) req.getSession().getAttribute("USERID");
			if (reportData1.getMODIFY_USERID() == userid || userid.equals(reportData1.getMODIFY_USERID())) {
				return ResponseEntity.status(500).body("Same User can not Verify");
			} else {
				reportData1.setVERIFY_FLG("Y");
				reportData1.setVERIFY_USERID(userid);
				reportData2.setVERIFY_FLG("Y");
				reportData2.setVERIFY_USERID(userid);
				auditService.createBusinessAudit(reportData1.getREPORT_DATE() + " - " + reportData1.getBRANCH_CODE(), "VERIFY", "RBS_MC_TABLE4_Retail_Products", null,"RT_MC_TABLE4_1");
				auditService.createBusinessAudit(reportData2.getREPORT_DATE() + " - " + reportData2.getBRANCH_CODE(), "VERIFY", "RBS_MC_TABLE4_Retail_Products", null,"RT_MC_TABLE2_2");
				RT_MC_TABLE4_1_REPO.save(reportData1);
				RT_MC_TABLE4_2_REPO.save(reportData2);

				return ResponseEntity.ok("Verified");
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error verifying data");
		}
	}
	
	@PostMapping("/saveMcReport_islamicbanking")
	@ResponseBody
	public ResponseEntity<String> saveReport_islamicbanking(@ModelAttribute RT_MC_TABLE8_ENTITY reportData,
			HttpServletRequest req) {

		try {
			System.out.println("branch: " + reportData.getBRANCH_CODE());
			String userid = (String) req.getSession().getAttribute("USERID");
			reportData.setMODIFY_USERID(userid);
			rT_MC_TABLE_Service.MC_TABLE8_Modify(reportData);
			RT_MC_TABLE8_REPO.save(reportData);
			return ResponseEntity.ok("Success");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving data");
		}
	}

	@PostMapping("/verifyMcReport_islamicbanking")
	@ResponseBody
	public ResponseEntity<String> verifyReport_islamicbanking(@ModelAttribute RT_MC_TABLE8_ENTITY reportData,
			HttpServletRequest req) {
		try {
			String userid = (String) req.getSession().getAttribute("USERID");
			if (reportData.getMODIFY_USERID() == userid || userid.equals(reportData.getMODIFY_USERID())) {
				return ResponseEntity.status(500).body("Same User can not Verify");
			} else {
				reportData.setVERIFY_FLG("Y");
				reportData.setVERIFY_USERID(userid);
				auditService.createBusinessAudit(reportData.getREPORT_DATE() + " - " + reportData.getBRANCH_CODE(), "VERIFY", "RBS_MC_TABLE8_Islamic_Banking", null,"RT_MC_TABLE8");
				RT_MC_TABLE8_REPO.save(reportData);
				return ResponseEntity.ok("Verified");
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error verifying data");
		}
	}
	@PostMapping("/saveMcReport_additionalinformation")
	@ResponseBody
	public ResponseEntity<String> saveReport_additionalinformation(@ModelAttribute RT_MC_TABLE7_1_ENTITY reportData1,
			RT_MC_TABLE7_2_ENTITY reportData2, HttpServletRequest req) {

		try {
			System.out.println("branch: " + reportData1.getBRANCH_CODE());
			String userid = (String) req.getSession().getAttribute("USERID");
			rT_MC_TABLE_Service.MC_TABLE7_1_Modify(reportData1);
			rT_MC_TABLE_Service.MC_TABLE7_2_Modify(reportData2);
			reportData1.setMODIFY_USERID(userid);
			reportData2.setMODIFY_USERID(userid);
			RT_MC_TABLE7_1_REPO.save(reportData1);
			RT_MC_TABLE7_2_REPO.save(reportData2);
			return ResponseEntity.ok("Success");

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving data");
		}
	}

	@PostMapping("/verifyMcReport_additionalinformation")
	@ResponseBody
	public ResponseEntity<String> verifyReport_additionalinformation(@ModelAttribute RT_MC_TABLE7_1_ENTITY reportData1,
			RT_MC_TABLE7_2_ENTITY reportData2, HttpServletRequest req) {
		try {
			String userid = (String) req.getSession().getAttribute("USERID");
			if (reportData1.getMODIFY_USERID() == userid || userid.equals(reportData1.getMODIFY_USERID())) {
				return ResponseEntity.status(500).body("Same User can not Verify");
			} else {
				reportData1.setVERIFY_FLG("Y");
				reportData1.setVERIFY_USERID(userid);
				reportData2.setVERIFY_FLG("Y");
				reportData2.setVERIFY_USERID(userid);
				auditService.createBusinessAudit(reportData1.getREPORT_DATE() + " - " + reportData1.getBRANCH_CODE(), "VERIFY", "RBS_MC_TABLE7_Additional_Information", null,"RT_MC_TABLE7_1");
				auditService.createBusinessAudit(reportData2.getREPORT_DATE() + " - " + reportData2.getBRANCH_CODE(), "VERIFY", "RBS_MC_TABLE7_Additional_Information", null,"RT_MC_TABLE7_2");
				RT_MC_TABLE7_1_REPO.save(reportData1);
				RT_MC_TABLE7_2_REPO.save(reportData2);
				return ResponseEntity.ok("Verified");
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error verifying data");
		}
	}
	@PostMapping("/saveMcReport_conductcultureassessment")
	@ResponseBody
	public ResponseEntity<String> saveReport_conductcultureassessment(@ModelAttribute RT_MC_TABLE9_ENTITY reportData,
			HttpServletRequest req) {

		try {
			System.out.println("branch: " + reportData.getBRANCH_CODE());
			String userid = (String) req.getSession().getAttribute("USERID");
			reportData.setMODIFY_USERID(userid);
			rT_MC_TABLE_Service.MC_TABLE9_Modify(reportData);
			RT_MC_TABLE9_REPO.save(reportData);
			return ResponseEntity.ok("Success");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving data");
		}
	}

	@PostMapping("/verifyMcReport_conductcultureassessment")
	@ResponseBody
	public ResponseEntity<String> verifyReport_conductcultureassessment(@ModelAttribute RT_MC_TABLE9_ENTITY reportData,
			HttpServletRequest req) {
		try {
			String userid = (String) req.getSession().getAttribute("USERID");
			if (reportData.getMODIFY_USERID() == userid || userid.equals(reportData.getMODIFY_USERID())) {
				return ResponseEntity.status(500).body("Same User can not Verify");
			} else {
				reportData.setVERIFY_FLG("Y");
				reportData.setVERIFY_USERID(userid);
				auditService.createBusinessAudit(reportData.getREPORT_DATE() + " - " + reportData.getBRANCH_CODE(), "VERIFY", "RBS_MC_TABLE9_Conduct_Culture_Assessment", null,"RT_MC_TABLE9");
				RT_MC_TABLE9_REPO.save(reportData);
				return ResponseEntity.ok("Verified");
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error verifying data");
		}
	}
	
	private final Map<String, byte[]> newTaskFileStore = new ConcurrentHashMap<>();
	private final Map<String, Integer> newTaskProgress = new ConcurrentHashMap<>();
	private final Map<String, String> newTaskError = new ConcurrentHashMap<>();

	@GetMapping("/startMcReportJob")
	@ResponseBody
	public String startMcReportJob(@RequestParam("branch") String branch, @RequestParam("formmode") String formmode,
			@RequestParam("reportDate") String reportDate, @RequestParam("isConsolidated") String isConsolidated,
			@RequestParam(value = "reportOption", required = false) String reportOption,
			@RequestParam(value = "selectedDepartments", required = false) String selectedDepartments,
			@RequestParam(value = "specialValues", required = false) String specialValues,@RequestParam(value = "tableNames", required = false) String tableNames,
			HttpServletRequest req) {
		String jobId = UUID.randomUUID().toString();
		newTaskProgress.put(jobId, 0);
		logger.info(
				"MC download accepted jobId={} formmode={} reportDate={} branch={} consolidated={} reportOption={} departments={} specialValues={} tables={}",
				jobId, formmode, reportDate, branch, isConsolidated, reportOption, selectedDepartments, specialValues,
				tableNames);
		String userid = (String) req.getSession().getAttribute("USERID");
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		new Thread(() -> {
			try {
				logger.info("MC download thread started jobId={}", jobId);
				byte[] fileData = rT_MC_TABLE_Service.generateReportFile(branch, jobId, newTaskProgress, formmode,
						reportDate, userid, attr, isConsolidated, reportOption, selectedDepartments, specialValues, tableNames);
				logger.info("MC download thread finished jobId={} formmode={} bytes={}", jobId, formmode,
						fileData == null ? 0 : fileData.length);
				newTaskFileStore.put(jobId, fileData);
				newTaskProgress.put(jobId, 100);
			} catch (Exception e) {
				logger.error("MC download thread failed jobId={} formmode={} reportDate={} branch={}", jobId, formmode,
						reportDate, branch, e);
				String reason = e.getMessage();
				if (reason == null || reason.trim().length() == 0) {
					if (e.getCause() != null && e.getCause().getMessage() != null
							&& e.getCause().getMessage().trim().length() > 0) {
						reason = e.getCause().getMessage();
					} else {
						reason = "Unexpected error while creating the file.";
					}
				}
				if (reason.length() > 300) {
					reason = reason.substring(0, 300);
				}
				newTaskError.put(jobId, reason);
				newTaskProgress.put(jobId, -1);
			}
		}).start();

		return jobId;
	}


	@GetMapping("/checkNewTaskStatus")
	@ResponseBody
	public Map<String, Object> checkNewTaskStatus(@RequestParam String jobId) {
		Map<String, Object> response = new HashMap<>();
		response.put("percent", newTaskProgress.getOrDefault(jobId, 0));
		String errorMessage = newTaskError.get(jobId);
		if (errorMessage == null) {
			errorMessage = "";
		}
		response.put("message", errorMessage);
		return response;
	}

	@GetMapping("/getNewTaskFile")
	public ResponseEntity<byte[]> getNewTaskFile(@RequestParam String jobId, @RequestParam String fileName) {
		byte[] fileData = newTaskFileStore.remove(jobId);

		if (fileData == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(fileData);
	}
	
	@RequestMapping(value = "RT_Key_Risk_Indicator", method = RequestMethod.GET)
	public String RT_Key_Risk_Indicator(
	        @RequestParam(required = false) String formmode,
	        @RequestParam(required = false) String Report_date,
	        @RequestParam(required = false) String branch,
	        Model md, HttpServletRequest req) {

	    String ROLEID = (String) req.getSession().getAttribute("ROLEID");
	    md.addAttribute("roleId", ROLEID);

	    String DEPARTMENT = (String) req.getSession().getAttribute("DEPARTMENT");
	    md.addAttribute("DEPARTMENT", DEPARTMENT);
	    System.out.println("DEPARTMENT="+DEPARTMENT);

	    if (formmode == null || "null".equalsIgnoreCase(formmode)) {

	        md.addAttribute("menu", "Key Risk Indicator");

	        List<KriMasterTable> krslist = new ArrayList<>();

	        try {
	            Date reportDateObj = null;
	            

	            if (Report_date != null && !Report_date.isEmpty()) {
	                reportDateObj = java.sql.Date.valueOf(normalizeDate(Report_date.trim()));
	            }

	            krslist = krimastertablerep.getalllist(reportDateObj);
	           
	            if(krslist.size()>0) {
	            	 md.addAttribute("formmode", "edit");
	            }
	            else {
	            	md.addAttribute("formmode", "list");
	            }
	            
	            md.addAttribute("Report_date",reportDateObj);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        md.addAttribute("krsdata", krslist);
	       
	       
	        
	    }

	    return "RT/keyRiskIndicator";
	}
	
	
	
	
	@PostMapping("/saveKriData")
	@ResponseBody
	public String saveKriData(@RequestBody List<KriMasterTable> list, HttpServletRequest req) {
		String userid = (String) req.getSession().getAttribute("USERID");
		for(KriMasterTable krs:list) {
			krs.setDelFlg("N");
			krs.setVerifyFlg("N");
			krs.setCreateUser(userid);
		}
		krimastertablerep.saveAll(list);
		System.out.println("saveKriData");
	    return "Key Risk Indicator Add Sucessfully";
	}
	
	@PostMapping("/modifyKriData")
	@ResponseBody
	public String modifyKriData(@RequestBody List<KriMasterTable> list, HttpServletRequest req) {
		String userid = (String) req.getSession().getAttribute("USERID");
		for(KriMasterTable krs:list) {
			krs.setDelFlg("N");
			krs.setVerifyFlg("N");
			krs.setModifyUser(userid);
			krs.setModifyFlg("Y");
		}
		krimastertablerep.saveAll(list);
		System.out.println("saveKriData");
		return "Key Risk Indicator Modified Successfully";
	}

	
	@PostMapping("/verifyKriData")
	@ResponseBody
	public String verifyKriData(
	        @RequestParam(required = false) String Report_date,
	        HttpServletRequest req) {

	    String userid = (String) req.getSession().getAttribute("USERID");

	    try {
	        Date reportDateObj = null;

	        if (Report_date != null && !Report_date.isEmpty()) {
	            reportDateObj = new SimpleDateFormat("yyyy-MM-dd").parse(Report_date);
	        }

	        List<KriMasterTable> krslist = krimastertablerep.getalllist(reportDateObj);

	        if (krslist != null && !krslist.isEmpty()) {

	            for (KriMasterTable krs : krslist) {
	                krs.setVerifyFlg("Y"); 
	                krs.setVerifyUser(userid);
	                krs.setVerifyTime(new Date());
	            }

	            krimastertablerep.saveAll(krslist);

	            return "Key Risk Indicator verified Sucessfully";
	        } else {
	            return "NO DATA FOUND";
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        return "ERROR";
	    }
	}
	
	@PostMapping("/saveInvestmentLimits")
	public ResponseEntity<?> saveData(
	        @RequestBody RtVarReportLimits data,
	        @RequestParam(defaultValue = "false") boolean confirmReplace) {

	    Optional<RtVarReportLimits> existing =rtvarreportlimits_rep.findById(data.getReportDate());

	    if (existing.isPresent() && !confirmReplace) {
	        return ResponseEntity.status(HttpStatus.CONFLICT)
	                .body("Record already exists for this date");
	    }

	    data.setEntryDate(new Date());
	    data.setEntryFlg("Y");

	    rtvarreportlimits_rep.save(data);

	    return ResponseEntity.ok("Limits Saved Successfully");
	}

	@Autowired
	RT_EAR_REPO RT_EAR_REPO;
	@GetMapping("/eardashboarddata")
    public String getEntityData( @RequestParam  String reportdate, Model model) {
        System.out.println("Report Date : "+reportdate);
        LocalDate formatreportdate = LocalDate.parse(reportdate,
                DateTimeFormatter.ofPattern("dd-MM-yyyy"));

		RT_EAR_ENTITY myEntity1 = RT_EAR_REPO.findbyReportTypeandReportDate(formatreportdate,"EAR"); 
		RT_EAR_ENTITY myEntity2 = RT_EAR_REPO.findbyReportTypeandReportDate(formatreportdate,"EAR_QRTR"); 		
				
        model.addAttribute("entity1", myEntity1);
		model.addAttribute("entity2", myEntity2);
		
        return "fragments/eardashboardtable :: eardashboardtable"; 
    }


	@RequestMapping(value = "Analytical_Pivot", method = { RequestMethod.GET, RequestMethod.POST })
	public String analyticalPivot(Model md, HttpServletRequest req) {
		String domainid = (String) req.getSession().getAttribute("DOMAINID");
		String userid = (String) req.getSession().getAttribute("USERID");
		String roleId = (String) req.getSession().getAttribute("ROLEID");
		String branchName = (String) req.getSession().getAttribute("BRANCHNAME");
		md.addAttribute("menu", "Analytical_Pivot");
		md.addAttribute("domainid", domainid);
		md.addAttribute("userid", userid);
		md.addAttribute("roleId", roleId);
		md.addAttribute("branchName", branchName);
		md.addAttribute("menuname", "Analytical Pivot");
		return "RT/Analytical_Pivot";
	}
	
	private static Date defaultReportDateTMinusOne() {
		return java.sql.Date.valueOf(LocalDate.now().minusDays(1));
	}

	@RequestMapping(value = "Data_inventory_dashboard", method = { RequestMethod.GET, RequestMethod.POST })
	public String dataInventoryDashboard(Model md, HttpServletRequest req) {
		md.addAttribute("menu", "Data_inventory_dashboard");
		md.addAttribute("menuname", "Data Control Center — Data Inventory");
		return "Data_inventory_dashboard";
	}

	@RequestMapping(value = "Report_control_center", method = { RequestMethod.GET, RequestMethod.POST })
	public String Report_control_center(
			@RequestParam(value = "reportDate", required = false) String reportDateStr,
			Model md,
			HttpServletRequest req) {

		String domainid = (String) req.getSession().getAttribute("DOMAINID");
		String userid = (String) req.getSession().getAttribute("USERID");
		String ROLEID = (String) req.getSession().getAttribute("ROLEID");
		String BRANCH_NAME = (String) req.getSession().getAttribute("BRANCHNAME");

		SimpleDateFormat dayFmt = new SimpleDateFormat("yyyy-MM-dd");
		Date reportDay;
		try {
			if (reportDateStr != null && !reportDateStr.trim().isEmpty()) {
				reportDay = dayFmt.parse(reportDateStr.trim());
			} else {
				reportDay = defaultReportDateTMinusOne();
			}
		} catch (ParseException e) {
			logger.warn("Report_control_center: invalid reportDate '{}', using T-1", reportDateStr);
			reportDay = defaultReportDateTMinusOne();
		}

		// Full list: TOTAL_STEPS from RT_REPORT_STEP; COMPLETED/FAILED from RT_REPORT_STEP_EXEC for reportDay; REPORT_STATUS derived.
		List<RT_Report_Master_Entity> Rpt_master_data = Rpt_Master_Repo.Get_Report_master(reportDay);

		md.addAttribute("Report_master_data", Rpt_master_data);
		md.addAttribute("selected_report_date", dayFmt.format(reportDay));
		md.addAttribute("menuname", "Report control Center");

		return "Report_control_center";
	}

	@RequestMapping(value = "Eab_acct_Excep_mnmt", method = { RequestMethod.GET, RequestMethod.POST })
	public String eabAcctExcepMnmt(@RequestParam(value = "reportDate", required = false) String reportDateStr, Model md,
			HttpServletRequest req) {
		String domainid = (String) req.getSession().getAttribute("DOMAINID");
		String userid = (String) req.getSession().getAttribute("USERID");
		String roleId = (String) req.getSession().getAttribute("ROLEID");
		String branchName = (String) req.getSession().getAttribute("BRANCHNAME");
		SimpleDateFormat dayFmt = new SimpleDateFormat("yyyy-MM-dd");
		Date reportDate;

		try {
			if (reportDateStr != null && !reportDateStr.trim().isEmpty()) {
				reportDate = dayFmt.parse(reportDateStr.trim());
			} else {
				reportDate = defaultReportDateTMinusOne();
			}
		} catch (Exception e) {
			logger.warn("Eab_acct_Excep_mnmt: invalid reportDate '{}', using T-1", reportDateStr);
			reportDate = defaultReportDateTMinusOne();
		}

		List<Eod_Acct_Bal_Excep_Table_Entity> list = eodAcctBalExcepTableRepo.findByReportDate(reportDate);
		md.addAttribute("menu", "Eab_acct_Excep_mnmt");
		md.addAttribute("domainid", domainid);
		md.addAttribute("userid", userid);
		md.addAttribute("roleId", roleId);
		md.addAttribute("branchName", branchName);
		md.addAttribute("selected_report_date", dayFmt.format(reportDate));
		md.addAttribute("records", list);
		md.addAttribute("menuname", "Eab Account Exception Mnmt");
		return "RT/Eab_acct_Excep_mnmt";
	}

	private static String trimToNull(String s) {
		if (s == null) {
			return null;
		}
		String t = s.trim();
		return t.isEmpty() ? null : t;
	}

	@PostMapping("Eab_acct_Excep_mnmt/save")
	@ResponseBody
	public ResponseEntity<String> saveEabAcctExcepMnmt(
			@RequestParam(value = "reportDate", required = false) String reportDateQueryParam,
			@RequestBody List<EodAcctBalExcepUpdateDto> updates) {
		try {
			if (updates == null || updates.isEmpty()) {
				return ResponseEntity.badRequest().body("No rows provided");
			}

			int updated = 0;
			for (EodAcctBalExcepUpdateDto row : updates) {
				String dateStr = trimToNull(row.getRowReportDate());
				if (dateStr == null) {
					dateStr = trimToNull(reportDateQueryParam);
				}
				if (dateStr == null) {
					logger.warn("EAB exception save: missing report date for acid={}", row.getAcid());
					continue;
				}
				String acid = trimToNull(row.getAcid());
				String tranId = trimToNull(row.getTranId());
				String partTranSrl = trimToNull(row.getPartTranSrlNum());
				if (acid == null || tranId == null || partTranSrl == null) {
					logger.warn("EAB exception save: missing key acid/tranId/partTranSrlNum");
					continue;
				}
				List<Eod_Acct_Bal_Excep_Table_Entity> matches = eodAcctBalExcepTableRepo.findByReportDateStrAndKeys(dateStr,
						acid, tranId, partTranSrl);
				if (matches.isEmpty()) {
					logger.warn(
							"EAB exception save: no row for reportDateStr={}, acid=[{}], tranId=[{}], partTranSrlNum=[{}]",
							dateStr, acid, tranId, partTranSrl);
					continue;
				}
				Eod_Acct_Bal_Excep_Table_Entity entity = matches.get(0);
				entity.setSchm_type(row.getSchmType() == null ? null : row.getSchmType().toUpperCase(Locale.ROOT));
				entity.setSchm_code(row.getSchmCode() == null ? null : row.getSchmCode().toUpperCase(Locale.ROOT));
				entity.setAcct_number(row.getAcctNumber());
				eodAcctBalExcepTableRepo.save(entity);
				updated++;
			}
			if (updated == 0) {
				return ResponseEntity.badRequest().body("No matching rows found for the given keys and report date");
			}
			return ResponseEntity.ok("Saved successfully (" + updated + " row(s))");
		} catch (Exception e) {
			logger.error("Failed to save EAB Account Exception updates", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save data");
		}
	}
	
	@PostMapping("/preview")
    public ResponseEntity<byte[]> generatePreview(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename() != null ? file.getOriginalFilename().toLowerCase() : "";
            byte[] fileBytes = file.getBytes();
            HttpHeaders headers = new HttpHeaders();

            if (fileName.endsWith(".pdf")) {
                headers.setContentType(MediaType.APPLICATION_PDF);
                return ResponseEntity.ok().headers(headers).body(fileBytes);
            }

            String htmlPreview;
            if (fileName.endsWith(".xlsx") || fileName.endsWith(".xls")) {
                htmlPreview = convertExcelToHtml(fileBytes);
            } else if (fileName.endsWith(".docx")) {
                htmlPreview = convertWordToHtml(fileBytes);
            } else if (fileName.endsWith(".csv") || fileName.endsWith(".txt")) {
                htmlPreview = convertTextToHtml(fileBytes);
            } else {
                htmlPreview = getFallbackHtml("Preview not supported for this specific file type.");
            }

            headers.setContentType(MediaType.TEXT_HTML);
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(htmlPreview.getBytes("UTF-8"));

        } catch (OutOfMemoryError e) {
            System.gc(); 
            
            String errorHtml = getFallbackHtml(
                "<span style='color: #dc3545; font-size: 30px;'>⚠️</span><br><br>" +
                "<span style='color: #333;'>This Excel file contains too many rows to generate a preview.</span><br>" +
                "<span style='color: #6c757d; font-size: 13px; font-weight: normal;'>The file is too massive for the server memory to render visually.<br>However, it will still be uploaded and saved successfully.</span>"
            );
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.TEXT_HTML);
            try {
                return ResponseEntity.ok().headers(headers).body(errorHtml.getBytes("UTF-8"));
            } catch (Exception ignored) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private String convertExcelToHtml(byte[] fileBytes) throws Exception {
        StringBuilder html = new StringBuilder();
        
        html.append("<html><head><meta name='viewport' content='width=device-width, initial-scale=1.0'><style>")
            .append("body { font-family: 'Calibri', Arial, sans-serif; font-size: 14px; margin: 0; padding: 0; background-color: #f3f2f1; display: flex; flex-direction: column; height: 100vh; overflow: hidden; }")
            .append(".sheet-container { flex: 1; overflow: auto; padding: 15px; display: none; background: #c8c6c4; }") 
            .append(".sheet-container.active { display: block; }")
            .append("table { border-collapse: collapse; background: #fff; box-shadow: 0 2px 4px rgba(0,0,0,0.2); table-layout: fixed; }")
            .append("td { border: 1px solid #e0e0e0; white-space: pre-wrap; vertical-align: bottom; overflow: hidden; word-wrap: break-word; }")
            .append(".tab-bar { background-color: #f3f2f1; border-top: 1px solid #c8c6c4; padding: 5px 10px 0 10px; display: flex; gap: 2px; overflow-x: auto; overflow-y: hidden; flex-shrink: 0; }")
            .append(".sheet-tab { background-color: #e1dfdd; color: #666; padding: 6px 20px; cursor: pointer; border: 1px solid #c8c6c4; border-bottom: none; border-radius: 4px 4px 0 0; font-size: 13px; margin-bottom: -1px; transition: background 0.2s; }")
            .append(".sheet-tab:hover { background-color: #fff; }")
            .append(".sheet-tab.active { background-color: #fff; font-weight: bold; color: #217346; border-top: 3px solid #217346; position: relative; z-index: 2; }")
            .append("</style></head><body>");

        try (InputStream is = new ByteArrayInputStream(fileBytes);
             Workbook workbook = WorkbookFactory.create(is)) {

            StringBuilder sheetsHtml = new StringBuilder();
            StringBuilder tabsHtml = new StringBuilder("<div class='tab-bar'>");

            for (int s = 0; s < workbook.getNumberOfSheets(); s++) {
                Sheet sheet = workbook.getSheetAt(s);
                String activeClass = (s == 0) ? " active" : ""; 

                tabsHtml.append("<div class='sheet-tab").append(activeClass)
                        .append("' onclick='switchTab(").append(s).append(")'>")
                        .append(sheet.getSheetName()).append("</div>");

                sheetsHtml.append("<div id='sheet-").append(s).append("' class='sheet-container").append(activeClass).append("'><table>");
                
                int maxColumns = 0;
                for (Row r : sheet) {
                    if (r.getLastCellNum() > maxColumns) maxColumns = r.getLastCellNum();
                }

                sheetsHtml.append("<colgroup>");
                for (int colNum = 0; colNum < maxColumns; colNum++) {
                    int widthPx = (int) ((sheet.getColumnWidth(colNum) / 256.0) * 7.5);
                    sheetsHtml.append("<col style='width: ").append(widthPx).append("px;'/>");
                }
                sheetsHtml.append("</colgroup>");

                for (Row row : sheet) {
                    short height = row.getHeight(); 
                    if (height != sheet.getDefaultRowHeight()) {
                        float heightPt = height / 20.0f; 
                        sheetsHtml.append("<tr style='height: ").append(heightPt).append("pt;'>");
                    } else {
                        sheetsHtml.append("<tr>");
                    }
                    
                    for (int colNum = 0; colNum < maxColumns; colNum++) {
                        Cell cell = row.getCell(colNum);
                        
                        boolean skipCell = false;
                        int rowSpan = 1; int colSpan = 1;
                        for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
                            org.apache.poi.ss.util.CellRangeAddress region = sheet.getMergedRegion(i);
                            if (row.getRowNum() >= region.getFirstRow() && row.getRowNum() <= region.getLastRow() &&
                                colNum >= region.getFirstColumn() && colNum <= region.getLastColumn()) {
                                if (row.getRowNum() == region.getFirstRow() && colNum == region.getFirstColumn()) {
                                    rowSpan = region.getLastRow() - region.getFirstRow() + 1;
                                    colSpan = region.getLastColumn() - region.getFirstColumn() + 1;
                                } else { skipCell = true; }
                                break;
                            }
                        }
                        if (skipCell) continue;

                        StringBuilder inlineCss = new StringBuilder();
                        String cellValue = "";
                        
                        if (cell != null) {
                            CellStyle style = cell.getCellStyle();
                            if (style != null) {
                                if (style.getFillPatternEnum() == org.apache.poi.ss.usermodel.FillPatternType.SOLID_FOREGROUND) {
                                    String bgColor = getHexColor(style.getFillForegroundColorColor());
                                    if (bgColor != null) inlineCss.append("background-color: ").append(bgColor).append("; ");
                                }

                                switch (style.getAlignmentEnum()) {
                                    case CENTER: inlineCss.append("text-align: center; "); break;
                                    case RIGHT: inlineCss.append("text-align: right; "); break;
                                    case LEFT: inlineCss.append("text-align: left; "); break;
                                    default: break;
                                }
                                switch (style.getVerticalAlignmentEnum()) {
                                    case TOP: inlineCss.append("vertical-align: top; "); break;
                                    case CENTER: inlineCss.append("vertical-align: middle; "); break;
                                    default: inlineCss.append("vertical-align: bottom; "); break; 
                                }

                                if (style.getBorderBottomEnum() != org.apache.poi.ss.usermodel.BorderStyle.NONE) inlineCss.append("border-bottom: 1px solid #000; ");
                                if (style.getBorderTopEnum() != org.apache.poi.ss.usermodel.BorderStyle.NONE) inlineCss.append("border-top: 1px solid #000; ");
                                if (style.getBorderLeftEnum() != org.apache.poi.ss.usermodel.BorderStyle.NONE) inlineCss.append("border-left: 1px solid #000; ");
                                if (style.getBorderRightEnum() != org.apache.poi.ss.usermodel.BorderStyle.NONE) inlineCss.append("border-right: 1px solid #000; ");

                                Font font = workbook.getFontAt(style.getFontIndex());
                                inlineCss.append("font-family: '").append(font.getFontName()).append("', sans-serif; ");
                                inlineCss.append("font-size: ").append(font.getFontHeightInPoints()).append("pt; ");
                                if (font.getBold()) inlineCss.append("font-weight: bold; ");
                                if (font.getItalic()) inlineCss.append("font-style: italic; ");
                                
                                if (font instanceof XSSFFont) {
                                    String fColor = getHexColor(((XSSFFont)font).getXSSFColor());
                                    if (fColor != null) inlineCss.append("color: ").append(fColor).append("; ");
                                } else if (font instanceof HSSFFont && workbook instanceof HSSFWorkbook) {
                                    String fColor = getHexColor(((HSSFFont)font).getHSSFColor((HSSFWorkbook)workbook));
                                    if (fColor != null) inlineCss.append("color: ").append(fColor).append("; ");
                                }
                            }
                            
                            DataFormatter formatter = new DataFormatter();
                            cellValue = formatter.formatCellValue(cell);
                        }

                        sheetsHtml.append("<td");
                        if (rowSpan > 1) sheetsHtml.append(" rowspan='").append(rowSpan).append("'");
                        if (colSpan > 1) sheetsHtml.append(" colspan='").append(colSpan).append("'");
                        if (inlineCss.length() > 0) sheetsHtml.append(" style='").append(inlineCss).append("'");
                        
                        sheetsHtml.append("><div style='padding: 2px 4px;'>").append(cellValue.isEmpty() ? "&nbsp;" : cellValue).append("</div></td>");
                    }
                    sheetsHtml.append("</tr>");
                }
                sheetsHtml.append("</table></div>");
            }
            tabsHtml.append("</div>");

            html.append(sheetsHtml);
            html.append(tabsHtml);

            html.append("<script>")
                .append("function switchTab(index) {")
                .append("  document.querySelectorAll('.sheet-container').forEach(function(el) { el.classList.remove('active'); });")
                .append("  document.querySelectorAll('.sheet-tab').forEach(function(el) { el.classList.remove('active'); });")
                .append("  document.getElementById('sheet-' + index).classList.add('active');")
                .append("  document.querySelectorAll('.sheet-tab')[index].classList.add('active');")
                .append("}")
                .append("</script>");
        }
        html.append("</body></html>");
        return html.toString();
    }

    private String getHexColor(org.apache.poi.ss.usermodel.Color color) {
        if (color == null) return null;
        
        try {
            if (color instanceof XSSFColor) {
                XSSFColor xssfColor = (XSSFColor) color;
                byte[] argb = xssfColor.getARGB();
                if (argb != null && argb.length == 4) {
                    return String.format("#%02X%02X%02X", argb[1] & 0xFF, argb[2] & 0xFF, argb[3] & 0xFF);
                } else if (argb != null && argb.length == 3) {
                    return String.format("#%02X%02X%02X", argb[0] & 0xFF, argb[1] & 0xFF, argb[2] & 0xFF);
                }
            } 
            else if (color instanceof HSSFColor) {
                HSSFColor hssfColor = (HSSFColor) color;
                short[] rgb = hssfColor.getTriplet();
                if (rgb != null && rgb.length == 3) {
                    return String.format("#%02X%02X%02X", rgb[0], rgb[1], rgb[2]);
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    private String convertWordToHtml(byte[] fileBytes) throws Exception {
        StringBuilder html = new StringBuilder();
        html.append("<html><body style='font-family: Arial, sans-serif; font-size: 14px; padding: 20px; color: #333; line-height: 1.6;'>");

        try (InputStream is = new ByteArrayInputStream(fileBytes);
             XWPFDocument document = new XWPFDocument(is);
             XWPFWordExtractor extractor = new XWPFWordExtractor(document)) {
            
            String text = extractor.getText();
            html.append(text.replace("\n", "<br/>"));
        }

        html.append("</body></html>");
        return html.toString();
    }

    private String convertTextToHtml(byte[] fileBytes) {
        String content = new String(fileBytes);
        return "<html><body style='padding: 15px; margin: 0; background: #f8f9fa;'>" +
               "<pre style='font-family: Consolas, monospace; font-size: 13px; color: #333; white-space: pre-wrap;'>" +
               content +
               "</pre></body></html>";
    }

    private String getFallbackHtml(String message) {
        return "<html><body style='display: flex; align-items: center; justify-content: center; height: 100vh; font-family: Arial; color: #6c757d;'>" +
               "<h4>" + message + "</h4></body></html>";
    }

	@PostMapping("/savedatarecord")
	@Transactional
	public ResponseEntity<String> saveRecord(@RequestParam("formMode") String formMode,
			@RequestParam("reportDate") String reportDateStr,
			@RequestParam(value = "source", required = false) String source,
			@RequestParam("columnHeader") String columnHeader, @RequestParam("rowCol2Value") String rowCol2Value,
			@RequestParam("cellName") String cellName, @RequestParam("cellId") String cellId,
			@RequestParam("dataValue") String dataValue,
			@RequestParam(value = "justification", required = false) String justification,
			@RequestParam(value = "verifyFlg", required = false) String verifyFlg,
			@RequestParam(value = "modifyFlg", required = false) String modifyFlg,
			@RequestParam(value = "remarks", required = false) String remarks,
			@RequestParam(value = "timeperiod", required = false) String timeperiod,
			@RequestParam(value = "productValue", required = false) String productValue,
			@RequestParam(value = "checkerJustification", required = false) String checkerJustification,
			@RequestParam(value = "execRole", required = false) String execRole,
			@RequestParam(value = "execAction", required = false) String execAction,
			@RequestParam(value = "execRemarks", required = false) String execRemarks,
			@RequestParam(value = "retainedFiles", required = false) List<Integer> retainedFiles,
			@RequestParam(value = "files", required = false) MultipartFile[] files) {

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date contextDate = null;
			if (reportDateStr != null && !reportDateStr.trim().isEmpty()) {
				contextDate = dateFormat.parse(reportDateStr);
			}
			String auditType;
			String audittext;

			if (execRole != null && !execRole.trim().isEmpty()) {
				auditType = execRole.toUpperCase() + " " + (execAction != null ? execAction : "ACTION");
				audittext = execRole.toUpperCase() + " Action Processed Successfully";
			} else if ("Y".equals(verifyFlg)) {
				auditType = "VERIFY APPROVE";
				audittext = "Checker Verified Successfully";
			} else if ("N".equals(verifyFlg)) {
				auditType = "VERIFY REVERT";
				audittext = "Checker Reverted Successfully";
			} else if ("MR".equals(verifyFlg)) {
				auditType = "MANAGER REVISION";
				audittext = "Manager Requested Revision Successfully";
			} else if ("REVOKE_CHECKER".equals(verifyFlg)) {
				auditType = "CHECKER REVOKE";
				audittext = "Checker Revoked Successfully";
			} else if ("REVOKE_MAKER".equals(verifyFlg)) {
				auditType = "MAKER REVOKE";
				audittext = "Maker Revoked Successfully";
			} else if ("C".equals(modifyFlg) && (verifyFlg == null || verifyFlg.trim().isEmpty())) {
				auditType = "SAVE AND PROCEED TO VERIFY";
				audittext = "Maker Saved and Submitted to Checker Successfully";
			} else {
				auditType = "MODIFY";
				audittext = "Maker Modified Successfully";
			}

			if (execRole == null && ("Y".equals(verifyFlg) || "N".equals(verifyFlg) || "MR".equals(verifyFlg)
					|| "REVOKE_CHECKER".equals(verifyFlg))) {

				String flagToSave = "REVOKE_CHECKER".equals(verifyFlg) ? null : verifyFlg;

				String existingRemarks = rT_MC_DATA_RECORD_REPO
						.findRemarksByFormModeAndReportDateAndCellNameAndTimeperiod(formMode, contextDate, cellName,
								timeperiod);
				String existingCheckerJustification = rT_MC_DATA_RECORD_REPO
						.findCheckerJustificationByFormModeAndReportDateAndCellNameAndTimeperiod(formMode,
								reportDateStr, cellName, timeperiod);

				String compOldRemarks = (existingRemarks != null && !" - ".equals(existingRemarks)) ? existingRemarks
						: "";
				String compNewRemarks = (remarks != null && !" - ".equals(remarks)) ? remarks : "";

				String compOldJustification = (existingCheckerJustification != null
						&& !" - ".equals(existingCheckerJustification)) ? existingCheckerJustification : "";
				String compNewJustification = (checkerJustification != null && !" - ".equals(checkerJustification))
						? checkerJustification
						: "";

				StringJoiner changesJoiner = new StringJoiner(" ||| ");

				if (!compOldRemarks.equals(compNewRemarks)) {
					String displayOld = compOldRemarks.isEmpty() ? " - " : compOldRemarks;
					String displayNew = compNewRemarks.isEmpty() ? " - " : compNewRemarks;

					changesJoiner.add("Checker Remarks : OldValue: " + displayOld + ", NewValue: " + displayNew);
				}

				if (!compOldJustification.equals(compNewJustification)) {
					String displayOld = compOldJustification.isEmpty() ? " - " : compOldJustification;
					String displayNew = compNewJustification.isEmpty() ? " - " : compNewJustification;

					changesJoiner.add("Checker Justification : OldValue: " + displayOld + ", NewValue: " + displayNew);
				}

				int rowsUpdated = rT_MC_DATA_RECORD_REPO.updateVerifyFlg(flagToSave, formMode, contextDate, cellName,
						remarks, timeperiod, checkerJustification);

				System.out.println("Fast Verification Update. Rows affected: " + rowsUpdated);
				String changedDetails = changesJoiner.toString();
				System.out.println("Changed Details : " + changedDetails);
				auditService.auditMCEntitymanual(auditType, reportDateStr, rT_MC_TABLE_Service.screenName(formMode),
						rT_MC_TABLE_Service.getMainTableName(formMode, cellName) + " & RT_MC_DATA_RECORD",
						productValue + " - " + columnHeader, audittext, changedDetails);
				return ResponseEntity.ok("Verification status updated.");
			}

			RT_MC_DATA_RECORD_ENTITY record = null;
			RT_MC_DATA_RECORD_ENTITY oldcopy = new RT_MC_DATA_RECORD_ENTITY();
			if (contextDate != null) {
				record = rT_MC_DATA_RECORD_REPO.findTopByFormModeAndReportDateAndCellNameAndTimeperiodOrderByIdDesc(
						formMode, contextDate, cellName, timeperiod);
			}

			if (record == null) {
				auditType = "ADD";
				audittext = "Maker Saved Successfully";
				record = new RT_MC_DATA_RECORD_ENTITY();
				synchronized (this) {
					BigDecimal currentMaxId = rT_MC_DATA_RECORD_REPO.findMaxId();
					record.setId(currentMaxId.add(BigDecimal.ONE));
				}
			} else {
				BeanUtils.copyProperties(record, oldcopy);
			}

			record.setReportDate(contextDate);
			record.setSource(source);
			record.setFormMode(formMode);
			record.setColumnHeader(columnHeader);
			record.setRowCol2Value(rowCol2Value);
			record.setCellName(cellName);
			record.setCellId(cellId);
			record.setDataValue(dataValue);
			record.setJustification(justification);
			record.setCheckerJustification(checkerJustification);
			record.setTimeperiod(timeperiod);

			if (execRole != null && !execRole.trim().isEmpty()) {
				String processedAction = "REVOKE".equals(execAction) ? null : execAction;
				if ("CRO".equalsIgnoreCase(execRole)) {
					record.setCroVerifyFlg(processedAction);
					record.setCroRemarks(execRemarks);
				} else if ("CCO".equalsIgnoreCase(execRole)) {
					record.setCcoVerifyFlg(processedAction);
					record.setCcoRemarks(execRemarks);
				}

				if ("N".equals(execAction)) {
					record.setVerifyFlg("N");
				} else if (verifyFlg != null && !verifyFlg.trim().isEmpty()) {
					record.setVerifyFlg(verifyFlg);
				} else if (record.getVerifyFlg() == null) {
					record.setVerifyFlg(null);
				}
				record.setModifyFlg(modifyFlg);
				record.setRemarks(execRemarks);

			} else {
				if ("REVOKE_CHECKER".equals(verifyFlg)) {
					record.setVerifyFlg(null);
					record.setModifyFlg(modifyFlg);
				} else if ("REVOKE_MAKER".equals(verifyFlg)) {
					record.setVerifyFlg(null);
					record.setModifyFlg(null);
					record.setRemarks(null);
				} else if (verifyFlg != null && !verifyFlg.trim().isEmpty()) {
					record.setVerifyFlg(verifyFlg);
					record.setModifyFlg(modifyFlg);
				} else {
					record.setVerifyFlg(null);
					record.setRemarks(null);
					if (modifyFlg != null && !modifyFlg.trim().isEmpty()) {
						record.setModifyFlg(modifyFlg);
					} else {
						record.setModifyFlg(null);
					}
				}
				if (remarks != null && !remarks.trim().isEmpty()) {
					record.setRemarks(remarks);
				}
			}
			if (remarks != null && !remarks.trim().isEmpty()) {
				record.setRemarks(remarks);
			}

			List<Integer> keptSlots = (retainedFiles != null) ? retainedFiles : new ArrayList<>();
			for (int i = 1; i <= 10; i++) {
				if (!keptSlots.contains(i)) {
					Method setNameMethod = RT_MC_DATA_RECORD_ENTITY.class.getMethod("setFileName" + i, String.class);
					Method setDataMethod = RT_MC_DATA_RECORD_ENTITY.class.getMethod("setFileData" + i, byte[].class);
					setNameMethod.invoke(record, (String) null);
					setDataMethod.invoke(record, (byte[]) null);
				}
			}

			if (files != null && files.length > 0) {
				int fileIndex = 1;
				for (MultipartFile file : files) {
					if (!file.isEmpty()) {
						while (fileIndex <= 10) {
							Method getNameMethod = RT_MC_DATA_RECORD_ENTITY.class.getMethod("getFileName" + fileIndex);
							String existingName = (String) getNameMethod.invoke(record);
							if (existingName == null || existingName.trim().isEmpty())
								break;
							fileIndex++;
						}
						if (fileIndex <= 10) {
							Method setNameMethod = RT_MC_DATA_RECORD_ENTITY.class.getMethod("setFileName" + fileIndex,
									String.class);
							Method setDataMethod = RT_MC_DATA_RECORD_ENTITY.class.getMethod("setFileData" + fileIndex,
									byte[].class);
							setNameMethod.invoke(record, file.getOriginalFilename());
							setDataMethod.invoke(record, file.getBytes());
							fileIndex++;
						}
					}
				}
			}
			System.out.println("productValue : " + productValue);
			rT_MC_DATA_RECORD_REPO.save(record);

			String mainTable = rT_MC_TABLE_Service.getMainTableName(formMode, cellName);
			if (mainTable != null && !mainTable.isEmpty() && cellName != null && !cellName.isEmpty()
					&& contextDate != null) {
				String updateSql = "UPDATE " + mainTable + " SET " + cellName
						+ " = :val WHERE REPORT_DATE = :reportDate AND BRANCH_CODE = :timeperiod";

				try {
					int rowsAffected = entityManager.createNativeQuery(updateSql).setParameter("val", dataValue)
							.setParameter("reportDate", new java.sql.Date(contextDate.getTime()))
							.setParameter("timeperiod", timeperiod).executeUpdate();

					System.out.println("DEBUG: Main table update complete. Rows affected: " + rowsAffected);

					if (rowsAffected == 0) {
						System.out.println(
								"WARNING: 0 rows were updated. The REPORT_DATE was not found in the main table!");
					}
				} catch (Exception e) {
					System.out.println("ERROR updating main table: " + e.getMessage());
					e.printStackTrace();
				}
			}
			if (auditType == "MODIFY" || auditType.equals("MODIFY") || auditType == "SAVE AND PROCEED TO VERIFY"
					|| auditType.equals("SAVE AND PROCEED TO VERIFY")) {
				auditService.compareMCEntitiesmanual(oldcopy, record, reportDateStr, auditType,
						rT_MC_TABLE_Service.screenName(formMode),
						rT_MC_TABLE_Service.getMainTableName(formMode, cellName) + " & RT_MC_DATA_RECORD",
						productValue + " - " + columnHeader, audittext);

			} else if (auditType == "ADD" || auditType.equals("ADD")) {
				auditService.auditAddMCEntitymanual(record, reportDateStr, rT_MC_TABLE_Service.screenName(formMode),
						rT_MC_TABLE_Service.getMainTableName(formMode, cellName) + " & RT_MC_DATA_RECORD",
						productValue + " - " + columnHeader, audittext);

			} else {
				auditService.auditMCEntitymanual(auditType, reportDateStr, rT_MC_TABLE_Service.screenName(formMode),
						rT_MC_TABLE_Service.getMainTableName(formMode, cellName) + " & RT_MC_DATA_RECORD",
						productValue + " - " + columnHeader, audittext, null);
			}

			return ResponseEntity.ok("Record Saved Successfully!");

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving record");
		}
	}

	@GetMapping("/fetchdatarecord")
	public ResponseEntity<?> fetchRecord(@RequestParam("formMode") String formMode,
			@RequestParam("reportDate") String reportDateStr, @RequestParam("cellName") String cellName, @RequestParam("timeperiod") String timeperiod) {

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date reportDate = dateFormat.parse(reportDateStr);

			RecordMetadataProjection record = rT_MC_DATA_RECORD_REPO
					.findTopProjectionByFormModeAndReportDateAndCellNameAndTimeperiodOrderByIdDesc(formMode, reportDate, cellName,timeperiod);

			Map<String, Object> response = new HashMap<>();
			response.put("currentRecord", record);
			
			if (record == null && "conductcultureassessment".equalsIgnoreCase(formMode)) {
				RecordMetadataProjection pastRecord = rT_MC_DATA_RECORD_REPO
						.findTopProjectionByFormModeAndCellNameAndTimeperiodAndReportDateLessThanOrderByReportDateDesc(
								formMode, cellName, timeperiod, reportDate);
				
				if (pastRecord != null) {
					response.put("id", pastRecord.getId()); 
					response.put("fileName1", pastRecord.getFileName1());
					response.put("fileName2", pastRecord.getFileName2());
					response.put("fileName3", pastRecord.getFileName3());
					response.put("fileName4", pastRecord.getFileName4());
					response.put("fileName5", pastRecord.getFileName5());
					response.put("fileName6", pastRecord.getFileName6());
					response.put("fileName7", pastRecord.getFileName7());
					response.put("fileName8", pastRecord.getFileName8());
					response.put("fileName9", pastRecord.getFileName9());
					response.put("fileName10", pastRecord.getFileName10());
				}
			}

			String mainTable = rT_MC_TABLE_Service.getMainTableName(formMode,cellName);
			

			if (record == null && mainTable != null && !mainTable.isEmpty()) {
				String fallbackSql = "SELECT " + cellName + " FROM " + mainTable + " WHERE REPORT_DATE = :reportDate AND BRANCH_CODE = :timeperiod";
				try {
				    List<?> fallbackResults = entityManager.createNativeQuery(fallbackSql)
				            .setParameter("reportDate", reportDate)
				            .setParameter("timeperiod", timeperiod)
				            .setMaxResults(1) 
				            .getResultList();
					
					if (!fallbackResults.isEmpty()) {
						Object fallbackValue = fallbackResults.get(0);
						response.put("fallbackValue", fallbackValue != null ? fallbackValue.toString() : "");
					} else {
						response.put("fallbackValue", "");
					}
				} catch (Exception e) {
					System.out.println("Fallback fetch failed: " + e.getMessage());
					response.put("fallbackValue", "");
				}
			}

			List<Map<String, String>> historyData = new ArrayList<>();
			if (mainTable != null && !mainTable.isEmpty()) {
				String histSql = "SELECT REPORT_DATE, " + cellName + " FROM " + mainTable
						+ " WHERE REPORT_DATE < :reportDate AND BRANCH_CODE = :timeperiod ORDER BY REPORT_DATE DESC";
				try {
					@SuppressWarnings("unchecked")
					List<Object[]> histResults = entityManager.createNativeQuery(histSql)
							.setParameter("reportDate", reportDate).setParameter("timeperiod", timeperiod)
							.setMaxResults(4).getResultList();

					for (Object[] row : histResults) {
						Map<String, String> histMap = new HashMap<>();

						if (row[0] != null) {
							Date histDate = (Date) row[0];
							histMap.put("date", dateFormat.format(histDate));
						} else {
							histMap.put("date", "N/A");
						}

						histMap.put("value", row[1] != null ? row[1].toString() : "");
						historyData.add(histMap);
					}
				} catch (Exception e) {
					System.out.println("History fetch skipped or table missing: " + e.getMessage());
				}
			}

			response.put("history", historyData);

			if (mainTable != null && !mainTable.isEmpty()) {
				String deptSql = "SELECT " + cellName + " FROM " + mainTable 
                        + " WHERE BRANCH_CODE = 'DEPT'";
				try {
					Object deptValue = entityManager.createNativeQuery(deptSql)
                            .setMaxResults(1)
                            .getSingleResult();
					
					response.put("accessibleDepartments", deptValue != null ? deptValue.toString() : "");
				} catch (Exception e) {
					response.put("accessibleDepartments", "");
				}
			}

			return ResponseEntity.ok(response);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@GetMapping("/download-file")
	public ResponseEntity<byte[]> downloadFile(@RequestParam("formMode") String formMode,
	        @RequestParam("cellName") String cellName,
	        @RequestParam("timeperiod") String timeperiod,
	        @RequestParam("reportDate") String reportDateStr,
	        @RequestParam("fileIndex") int fileIndex) {

		try {
			if (fileIndex < 1 || fileIndex > 10) {
				return ResponseEntity.badRequest().build();
			}
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
			java.util.Date parsedReportDate = sdf.parse(reportDateStr);
			String hql = "SELECT r.fileName" + fileIndex + ", r.fileData" + fileIndex
					+ " FROM RT_MC_DATA_RECORD_ENTITY r "
					+ "WHERE r.formMode = :formMode "
					+ "AND r.cellName = :cellName "
					+ "AND r.timeperiod = :timeperiod "
					+ "AND r.reportDate = :reportDate";

			Object[] result;
			try {
				result = (Object[]) entityManager.createQuery(hql)
						.setParameter("formMode", formMode)
						.setParameter("cellName", cellName)
						.setParameter("timeperiod", timeperiod)
						.setParameter("reportDate", parsedReportDate)
						.getSingleResult();
			} catch (NoResultException e) {
				return ResponseEntity.notFound().build();
			}

			if (result == null || result[0] == null || result[1] == null) {
				return ResponseEntity.notFound().build();
			}

			String fileName = (String) result[0];
			byte[] fileData = (byte[]) result[1];

			String contentType = "application/octet-stream";
			String lowerName = fileName.toLowerCase();
			if (lowerName.endsWith(".pdf"))
				contentType = "application/pdf";
			else if (lowerName.endsWith(".png"))
				contentType = "image/png";
			else if (lowerName.endsWith(".jpg") || lowerName.endsWith(".jpeg"))
				contentType = "image/jpeg";
			else if (lowerName.endsWith(".txt") || lowerName.endsWith(".csv"))
				contentType = "text/plain";

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", contentType);

			return ResponseEntity.ok().headers(headers).body(fileData);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/fetchallverifyflags")
	public ResponseEntity<Map<String, String>> fetchAllVerifyFlags(@RequestParam("formMode") String formMode,
			@RequestParam("reportDate") String reportDateStr, @RequestParam("timeperiod") String timeperiod) {
		try {
			String sql = "SELECT CELL_NAME, VERIFY_FLG, MODIFY_FLG, CRO_VERIFY_FLG, CCO_VERIFY_FLG "
					+ "FROM RT_MC_DATA_RECORD r WHERE r.ID IN ("
					+ " SELECT MAX(r2.ID) FROM RT_MC_DATA_RECORD r2 "
					+ " WHERE UPPER(TRIM(r2.FORM_MODE)) = UPPER(TRIM(:formMode)) "
					+ " AND TRUNC(r2.REPORT_DATE) = TO_DATE(:reportDate, 'DD-MM-YYYY') "
					+ " AND NVL(UPPER(TRIM(r2.TIMEPERIOD)), ' ') = NVL(UPPER(TRIM(:timeperiod)), ' ') "
					+ " GROUP BY r2.CELL_NAME)";

			@SuppressWarnings("unchecked")
			List<Object[]> results = entityManager.createNativeQuery(sql).setParameter("formMode", formMode)
					.setParameter("reportDate", reportDateStr).setParameter("timeperiod", timeperiod).getResultList();

			Map<String, String> flags = new HashMap<>();

			for (Object[] row : results) {
				if (row[0] != null) {
					String cellName = row[0].toString().trim();
					String verifyFlg = row[1] != null ? row[1].toString().trim().toUpperCase() : "";
					String modifyFlg = row[2] != null ? row[2].toString().trim().toUpperCase() : "";
					String croFlg = row[3] != null ? row[3].toString().trim().toUpperCase() : "";
					String ccoFlg = row[4] != null ? row[4].toString().trim().toUpperCase() : "";

					boolean isTotalCell = cellName.toLowerCase().matches(".*(^|_)(tot|total)($|_|\\d).*")
							|| (!"bankinformation".equalsIgnoreCase(formMode) && cellName.toUpperCase().matches("^R(22|12|23)_.*"));

					if (isTotalCell) {
						if ("N".equals(croFlg) || "N".equals(ccoFlg) || "N".equals(verifyFlg)) {
							flags.put(cellName, "N");
						} else if ("Y".equals(croFlg) && "Y".equals(ccoFlg)) {
							flags.put(cellName, "Y");
						} else if (!verifyFlg.isEmpty() || "C".equalsIgnoreCase(modifyFlg)) {
							flags.put(cellName, "C");
						}
					} else {
						if (!verifyFlg.isEmpty()) {
							flags.put(cellName, verifyFlg);
						} else if ("C".equalsIgnoreCase(modifyFlg)) {
							flags.put(cellName, "C");
						}
					}
				}
			}

			return ResponseEntity.ok(flags);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@PostMapping("/managerVerifyAction")
	@Transactional
	public ResponseEntity<String> managerVerifyAction(@RequestParam("formMode") String formMode,
			@RequestParam("reportDate") String reportDateStr, @RequestParam("actionType") String actionType,
			@RequestParam(value = "remarks", required = false) String remarks,@RequestParam(value = "timeperiod", required = false) String timeperiod,
			@RequestParam(value = "mrCells", required = false) String mrCellsJson) {

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date reportDate = dateFormat.parse(reportDateStr);

			if ("VERIFY_ALL".equals(actionType)) {
				int rows_updated = rT_MC_TABLE_Service.updateVerifyFlgAndRemarks(formMode,"Y", remarks, reportDate,timeperiod);
				System.out.println("Main Table Rows Verified : " + rows_updated);

				int mr_cleaned = rT_MC_DATA_RECORD_REPO.revertMrCellsToVerified(formMode, reportDate,timeperiod);
				System.out.println("MR Cells Cleaned to Y : " + mr_cleaned);
				
				auditService.auditManagerVerifyActionGrouped(formMode, reportDateStr, actionType, remarks, timeperiod, null, null);
				return ResponseEntity.ok("Report verified successfully.");

			} else if ("REVERT_MR".equals(actionType)) {
				ObjectMapper mapper = new ObjectMapper();
				List<String> cellsToRevert = mapper.readValue(mrCellsJson, new TypeReference<List<String>>() {});

				List<String> existingMrCells = rT_MC_DATA_RECORD_REPO.findCellNamesByVerifyFlg("MR", formMode, reportDate, timeperiod);

				rT_MC_DATA_RECORD_REPO.revertMrCellsToVerified(formMode, reportDate,timeperiod);
				for (String cellName : cellsToRevert) {
					int rowsAffected = rT_MC_DATA_RECORD_REPO.updateVerifyFlgwithoutremarks("MR", formMode, reportDate, cellName,timeperiod);

					if (rowsAffected == 0) {
						RT_MC_DATA_RECORD_ENTITY newRecord = new RT_MC_DATA_RECORD_ENTITY();
						BigDecimal currentMaxId = rT_MC_DATA_RECORD_REPO.findMaxId();
						newRecord.setId(currentMaxId.add(BigDecimal.ONE));
						newRecord.setFormMode(formMode);
						newRecord.setReportDate(reportDate);
						newRecord.setCellName(cellName);
						newRecord.setVerifyFlg("MR");
						newRecord.setModifyFlg("C");
						newRecord.setTimeperiod(timeperiod);
						rT_MC_DATA_RECORD_REPO.save(newRecord);
					}
				}

				int rows_updated = rT_MC_TABLE_Service.updateVerifyFlgAndRemarks(formMode,"N", remarks, reportDate,timeperiod);
				System.out.println("Main Table Rows Reverted : " + rows_updated);
				
				auditService.auditManagerVerifyActionGrouped(formMode, reportDateStr, actionType, remarks, timeperiod, existingMrCells, cellsToRevert);
				return ResponseEntity.ok("Selected cells flagged for revision.");

			} else if ("REVOKE_MGR".equals(actionType)) {
				int rows_updated = rT_MC_TABLE_Service.updateVerifyFlgAndRemarks(formMode,null, remarks, reportDate,timeperiod);
				System.out.println("Main Table Rows Revoked : " + rows_updated);

				int mr_revoked = rT_MC_DATA_RECORD_REPO.revertMrCellsToVerified(formMode, reportDate,timeperiod);
				System.out.println("MR Cells Revoked to Y : " + mr_revoked);
				
				auditService.auditManagerVerifyActionGrouped(formMode, reportDateStr, actionType, remarks, timeperiod, null, null);
				return ResponseEntity.ok("Manager actions successfully revoked.");
			}

			return ResponseEntity.badRequest().body("Unknown action type.");

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("A database error occurred.");
		}
	}
	@GetMapping("/fetchFieldDescription")
	public ResponseEntity<String> fetchFieldDescription(@RequestParam("formMode") String formMode,
			@RequestParam("fieldName") String fieldName) {

		try {
			//System.out.println("Formmode : " + formMode+" Field Nmae : "+fieldName);
			String description = (RT_MC_Description_Repo.findTopBySectionAndElementNative(formMode, fieldName))
					.getDescription();
			//System.out.println("Descripion : " + description);
			if (description != null && !description.isEmpty()) {
				return ResponseEntity.ok(description);
			} else {
				return ResponseEntity.ok("");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Database error");
		}
	}

	@Autowired
	MC_Service_audit_Repo MC_Service_audit_Repo;

	@GetMapping("/MC_Service_Audit/downloadExcel")
	public ResponseEntity<?> downloadExcel(@RequestParam(value = "searchType", required = false) String searchType,
			@RequestParam(value = "entry_date", required = false) String entryDate,
			@RequestParam(value = "fromDate", required = false) String fromDateStr,
			@RequestParam(value = "toDate", required = false) String toDateStr) {

		ResolvedDates dateFilter = McServiceAuditDateHelper.resolveForDownload(searchType, entryDate, fromDateStr,
				toDateStr);
		if (dateFilter.hasError()) {
			return mcAuditDownloadMessage(HttpStatus.BAD_REQUEST, dateFilter.getErrorMessage());
		}
		if (!dateFilter.hasBounds()) {
			return mcAuditDownloadMessage(HttpStatus.BAD_REQUEST, "Please select a date.");
		}

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
			Pattern pattern = Pattern.compile("(.*?):\\s*OldValue:\\s*(.*?),\\s*NewValue:\\s*(.*)");

			List<MC_Service_audit_entity> logs;
			if (dateFilter.isExclusiveEnd()) {
				logs = MC_Service_audit_Repo.findByEntryTimeRange(dateFilter.getStartInclusive(),
						dateFilter.getEndBound());
			} else {
				logs = MC_Service_audit_Repo.findByEntryTimeBetween(dateFilter.getStartInclusive(),
						dateFilter.getEndBound());
			}

			if (logs == null || logs.isEmpty()) {
				return mcAuditDownloadMessage(HttpStatus.OK, "No records found");
			}

			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("Service Audit");

			sheet.setColumnWidth(0, 4000);
			sheet.setColumnWidth(1, 3000);
			sheet.setColumnWidth(2, 3500);
			sheet.setColumnWidth(3, 4000);
			sheet.setColumnWidth(4, 4000);
			sheet.setColumnWidth(5, 3000);
			sheet.setColumnWidth(6, 2500);
			sheet.setColumnWidth(7, 2500);

			Row headerRow = sheet.createRow(0);
			String[] columns = { "Screen Name", "Function Code", "Field Name", "Old Value", "New Value", "User", "Date",
					"Time" };

			CellStyle headerStyle = workbook.createCellStyle();
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerStyle.setFont(headerFont);
			headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerStyle.setBorderBottom(BorderStyle.THIN);
			headerStyle.setBorderTop(BorderStyle.THIN);
			headerStyle.setBorderRight(BorderStyle.THIN);
			headerStyle.setBorderLeft(BorderStyle.THIN);

			for (int i = 0; i < columns.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(columns[i]);
				cell.setCellStyle(headerStyle);
			}

			CellStyle dataCellStyle = workbook.createCellStyle();
			dataCellStyle.setBorderBottom(BorderStyle.THIN);
			dataCellStyle.setBorderTop(BorderStyle.THIN);
			dataCellStyle.setBorderRight(BorderStyle.THIN);
			dataCellStyle.setBorderLeft(BorderStyle.THIN);
			dataCellStyle.setWrapText(true);
			dataCellStyle.setVerticalAlignment(VerticalAlignment.TOP);

			Font fieldHeaderFont = workbook.createFont();
			fieldHeaderFont.setBold(true);
			CellStyle fieldHeaderStyle = workbook.createCellStyle();
			fieldHeaderStyle.setFont(fieldHeaderFont);
			fieldHeaderStyle.setBorderBottom(BorderStyle.THIN);
			fieldHeaderStyle.setBorderTop(BorderStyle.THIN);
			fieldHeaderStyle.setBorderRight(BorderStyle.THIN);
			fieldHeaderStyle.setBorderLeft(BorderStyle.THIN);
			fieldHeaderStyle.setAlignment(HorizontalAlignment.LEFT);
			fieldHeaderStyle.setWrapText(true);

			int rowNum = 1;

			for (MC_Service_audit_entity log : logs) {
				String currentFuncCode = log.getFunc_code() != null ? log.getFunc_code() : "";
				String funcCodeUpper = currentFuncCode.toUpperCase();
				String modiDetails = log.getModi_details() != null ? log.getModi_details() : "";
				String fieldHeader = log.getFIELD_HEADER();

				String isModifiedFlag = log.getISMODIFIED() != null ? log.getISMODIFIED() : "";

				String dateStr = log.getEntry_time() != null ? sdf.format(log.getEntry_time()) : "";
				String timeStr = log.getEntry_time() != null ? timeFormat.format(log.getEntry_time()) : "";
				String screenName = log.getAudit_screen() != null ? log.getAudit_screen() : "";
				String userName = log.getEntry_user() != null ? log.getEntry_user() : "";

				boolean showDetailedRows = "Y".equalsIgnoreCase(isModifiedFlag);
				boolean hasHeader = fieldHeader != null && !fieldHeader.trim().isEmpty() && !fieldHeader.equals("null");

				int startRowForLog = rowNum;

				if (showDetailedRows && !modiDetails.isEmpty()) {

					if (hasHeader) {
						Row fieldHeaderRow = sheet.createRow(rowNum);
						for (int c = 0; c < 8; c++) {
							Cell cell = fieldHeaderRow.createCell(c);
							cell.setCellStyle(fieldHeaderStyle);
						}

						fieldHeaderRow.getCell(0).setCellValue(screenName);
						fieldHeaderRow.getCell(1).setCellValue(currentFuncCode);
						fieldHeaderRow.getCell(5).setCellValue(userName);
						fieldHeaderRow.getCell(6).setCellValue(dateStr);
						fieldHeaderRow.getCell(7).setCellValue(timeStr);

						fieldHeaderRow.getCell(2).setCellValue(fieldHeader);
						sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum, 2, 4));
						rowNum++;
					}

					String[] changes = modiDetails.split("\\|\\|\\|");
					for (String change : changes) {
						Matcher matcher = pattern.matcher(change);
						Row dataRow = sheet.createRow(rowNum);

						for (int c = 0; c < 8; c++) {
							Cell cell = dataRow.createCell(c);
							cell.setCellStyle(dataCellStyle);
						}

						dataRow.getCell(0).setCellValue(screenName);
						dataRow.getCell(1).setCellValue(currentFuncCode);
						dataRow.getCell(5).setCellValue(userName);
						dataRow.getCell(6).setCellValue(dateStr);
						dataRow.getCell(7).setCellValue(timeStr);

						if (matcher.find()) {
							String fieldName = matcher.group(1).trim();
							String oldValue = matcher.group(2).trim();
							String newValue = matcher.group(3).trim();

							dataRow.getCell(2).setCellValue(fieldName);
							dataRow.getCell(3).setCellValue(
									"ADD".equals(funcCodeUpper) ? "-" : (oldValue.equals("null") ? "-" : oldValue));
							dataRow.getCell(4).setCellValue(newValue.equals("null") ? "-" : newValue);
						} else {
							dataRow.getCell(2).setCellValue(change);
							dataRow.getCell(3).setCellValue("-");
							dataRow.getCell(4).setCellValue("-");
						}

						dataRow.setHeightInPoints(25);
						rowNum++;
					}
				} else {
					Row singleRow = sheet.createRow(rowNum);

					for (int c = 0; c < 8; c++) {
						Cell cell = singleRow.createCell(c);
						cell.setCellStyle(dataCellStyle);
					}

					singleRow.getCell(0).setCellValue(screenName);
					singleRow.getCell(1).setCellValue(currentFuncCode);
					singleRow.getCell(5).setCellValue(userName);
					singleRow.getCell(6).setCellValue(dateStr);
					singleRow.getCell(7).setCellValue(timeStr);

					String centerText = "";
					if (hasHeader) {
						centerText = fieldHeader;
					} else if (modiDetails != null && !modiDetails.trim().isEmpty() && !modiDetails.equals("null")) {
						centerText = modiDetails;
					}

					singleRow.getCell(2).setCellValue(centerText);
					sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum, 2, 4));

					singleRow.setHeightInPoints(25);
					rowNum++;
				}

				if (rowNum - startRowForLog > 1) {
					sheet.addMergedRegion(new CellRangeAddress(startRowForLog, rowNum - 1, 0, 0));
					sheet.addMergedRegion(new CellRangeAddress(startRowForLog, rowNum - 1, 1, 1));
					sheet.addMergedRegion(new CellRangeAddress(startRowForLog, rowNum - 1, 5, 5));
					sheet.addMergedRegion(new CellRangeAddress(startRowForLog, rowNum - 1, 6, 6));
					sheet.addMergedRegion(new CellRangeAddress(startRowForLog, rowNum - 1, 7, 7));

					for (int rowIdx = startRowForLog; rowIdx < rowNum; rowIdx++) {
						Row r = sheet.getRow(rowIdx);
						if (r != null) {
							int[] colsToCenter = { 0, 1, 5, 6, 7 };
							for (int c : colsToCenter) {
								if (r.getCell(c) != null) {
									r.getCell(c).getCellStyle().setVerticalAlignment(VerticalAlignment.CENTER);
								}
							}
						}
					}
				}
			}

			for (int i = 0; i < columns.length; i++) {
				sheet.autoSizeColumn(i);
			}

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			workbook.write(out);
			workbook.close();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(
					MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
			headers.setContentDispositionFormData("attachment", "Service_Audit_Report.xlsx");
			headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

			return new ResponseEntity<>(out.toByteArray(), headers, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("Market Conduct Service Audit download failed", e);
			return mcAuditDownloadMessage(HttpStatus.INTERNAL_SERVER_ERROR,
					"Unable to download the audit report. Please try again.");
		}
	}

	private ResponseEntity<Map<String, String>> mcAuditDownloadMessage(HttpStatus status, String message) {
		Map<String, String> body = new HashMap<String, String>();
		body.put("message", message);
		return ResponseEntity.status(status).contentType(MediaType.APPLICATION_JSON).body(body);
	}
	@GetMapping("/signofftablestatus")
	public ResponseEntity<Map<String, Object>> getSystemStatus(
            @RequestParam(required = false) String reportDate,
            @RequestParam(required = false) String timePeriod) {
        List<Map<String, Object>> tableStatuses = new ArrayList<>();

        addTableStatus(tableStatuses, "Bank Information", RT_MC_TABLE1_REPO.findByReportDateAndBranchCode(reportDate,timePeriod).get(0).getVERIFY_FLG());
        addTableStatus(tableStatuses, "Bank Consumers", RT_MC_TABLE2_1_REPO.findByReportDateAndBranchCode(reportDate,timePeriod).get(0).getVERIFY_FLG()); 
        addTableStatus(tableStatuses, "Complaints", RT_MC_TABLE3_REPO.findByReportDateAndBranchCode(reportDate,timePeriod).get(0).getVERIFY_FLG());
        addTableStatus(tableStatuses, "Retail Products", RT_MC_TABLE4_1_REPO.findByReportDateAndBranchCode(reportDate,timePeriod).get(0).getVERIFY_FLG()); 
        addTableStatus(tableStatuses, "Bank Employee", RT_MC_TABLE5_REPO.findByReportDateAndBranchCode(reportDate,timePeriod).get(0).getVERIFY_FLG());
        addTableStatus(tableStatuses, "Trainings", RT_MC_TABLE6_REPO.findByReportDateAndBranchCode(reportDate,timePeriod).get(0).getVERIFY_FLG()); 
        addTableStatus(tableStatuses, "Additional Informaion", RT_MC_TABLE7_1_REPO.findByReportDateAndBranchCode(reportDate,timePeriod).get(0).getVERIFY_FLG());
        addTableStatus(tableStatuses, "Islamic Banking", RT_MC_TABLE8_REPO.findByReportDateAndBranchCode(reportDate,timePeriod).get(0).getVERIFY_FLG());

        System.out.println("Timeperiod : "+timePeriod);
        if (timePeriod=="YEARLY" || "YEARLY".equals(timePeriod)) {
            addTableStatus(tableStatuses, "Conduct Cultureassessment", RT_MC_TABLE9_REPO.findByReportDateAndBranchCode(reportDate,timePeriod).get(0).getVERIFY_FLG());
        }
        String savedRemarks = RT_MC_TABLE1_REPO.findSignOffRemarks(reportDate,timePeriod);
        if (savedRemarks == null) {
            savedRemarks = ""; 
        }
        
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("statuses", tableStatuses);
        responseData.put("remarks", savedRemarks);
        
        return ResponseEntity.ok(responseData); 
    }

    private void addTableStatus(List<Map<String, Object>> list, String tableName, String flag) {
        Map<String, Object> statusMap = new HashMap<>();
        statusMap.put("tableName", tableName);
        statusMap.put("flag", flag);
        list.add(statusMap);
    }
    @PostMapping("/signoffsave")
    public ResponseEntity<?> saveSystemStatusRemarks(@RequestBody Map<String, String> payload) {
        
        String reportDate = payload.get("reportDate");
        String timePeriod = payload.get("timePeriod");
        String remarks = payload.get("remarks");

        try {
             rT_MC_TABLE_Service.saveSignOffRemarks(reportDate, timePeriod, remarks);
            
            System.out.println("Received Report Date: " + reportDate);
            System.out.println("Received Time Period: " + timePeriod);
            System.out.println("Received Remarks: " + remarks);
            auditService.auditMCEntitymanual("Final Sign Off", reportDate,
            		"RBS Market Conduct Reports",
					"All Market Conduct Report Tables",null,"Sign Off Successfull",null);
            
            return ResponseEntity.ok().body("{\"message\": \"Saved successfully\"}");
            
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("{\"error\": \"Failed to save remarks\"}");
		}
    }
    @ResponseBody
    @GetMapping("/checkDataAvailability")
    public Map<String, Object> checkDataAvailability(
            @RequestParam("reportDate") String reportDate,
            @RequestParam("timeperiod") String timeperiod) {

        Map<String, Object> response = new HashMap<>();

        try {
            boolean isexistingRecord = verifyDataAvailability(reportDate, timeperiod);
            
            if (isexistingRecord) {
                response.put("exists", true);
                response.put("canGenerate", false);
                response.put("missingMessage", "");
                return response;
            }

            response.put("exists", false);
            
            List<String> missingItems = getMissingPrerequisites(reportDate, timeperiod);
            
            if (missingItems.isEmpty()) {
                response.put("canGenerate", true);
                response.put("missingMessage", "");
            } else {
                response.put("canGenerate", false);
                
                StringBuilder msgBuilder = new StringBuilder("Cannot generate report. The following required periods are missing:<br><ul style='margin-top: 8px; margin-bottom: 0; padding-left: 20px;'>");
                for (String item : missingItems) {
                    msgBuilder.append("<li><strong>").append(item).append("</strong></li>");
                }
                msgBuilder.append("</ul>");
                
                response.put("missingMessage", msgBuilder.toString());
            }

        } catch (Exception e) {
            response.put("exists", false);
            response.put("canGenerate", false);
            response.put("missingMessage", "Server error while verifying report availability.");
            e.printStackTrace();
        }

        return response;
    }
    @ResponseBody
    @PostMapping("/generateReportProcedures")
    public Map<String, Object> generateReportProcedures(
            @RequestParam("reportDate") String reportDate,
            @RequestParam("timeperiod") String timeperiod) {

        Map<String, Object> response = new HashMap<>();

        try {
            String callSql = "{call COMMON_RT_MC_TRIGGERING_PROCEDURE(?, ?,'ALL')}";
            
            jdbcTemplate.update(callSql, reportDate, timeperiod);

            response.put("success", true);
            response.put("errorMessage", "");

        } catch (Exception e) {
            response.put("success", false);
            String errorMsg = e.getMessage() != null ? e.getMessage() : "Unknown database error occurred.";
            response.put("errorMessage", "Procedure execution failed: " + errorMsg);
            
            e.printStackTrace();
        }

        return response;
    }

	private boolean verifyDataAvailability(String reportDate, String timeperiod) {
		if (reportDate == null || reportDate.trim().isEmpty()) {
			return false;
		}

		int count1 = RT_MC_TABLE1_REPO.countByReportDateAndTimeperiod(reportDate, timeperiod);
		int count2 = RT_MC_TABLE2_1_REPO.countByReportDateAndTimeperiod(reportDate, timeperiod);
		int count3 = RT_MC_TABLE3_REPO.countByReportDateAndTimeperiod(reportDate, timeperiod);
		int count4 = RT_MC_TABLE4_1_REPO.countByReportDateAndTimeperiod(reportDate, timeperiod);
		int count5 = RT_MC_TABLE5_REPO.countByReportDateAndTimeperiod(reportDate, timeperiod);
		int count6 = RT_MC_TABLE6_REPO.countByReportDateAndTimeperiod(reportDate, timeperiod);
		int count7 = RT_MC_TABLE7_1_REPO.countByReportDateAndTimeperiod(reportDate, timeperiod);
		int count8 = RT_MC_TABLE8_REPO.countByReportDateAndTimeperiod(reportDate, timeperiod);

		boolean baseDataExists = (count1 > 0) && (count2 > 0) && (count3 > 0) && (count4 > 0) && (count5 > 0)
				&& (count6 > 0) && (count7 > 0) && (count8 > 0);
		if (!baseDataExists) {
			return false;
		}
		if ("YEARLY".equalsIgnoreCase(timeperiod)) {
			int count9 = RT_MC_TABLE9_REPO.countByReportDateAndTimeperiod(reportDate, timeperiod);
			if (count9 == 0) {
				return false;
			}
		}
		return true;

	}

	private List<String> getMissingPrerequisites(String reportDate, String timeperiod) {
		List<String> missing = new ArrayList<>();
		if (reportDate == null || reportDate.trim().isEmpty()) {
			missing.add("Invalid report date provided.");
			return missing;
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate targetDate = LocalDate.parse(reportDate, formatter);

		if ("QUARTERLY".equalsIgnoreCase(timeperiod)) {
			boolean isQuarterlyTarget = true;
			missing.addAll(getMissingPastQuarters(targetDate, 4, formatter, isQuarterlyTarget));

		} else if ("YEARLY".equalsIgnoreCase(timeperiod)) {
			boolean isQuarterlyTarget = false;
			missing.addAll(getMissingPastQuarters(targetDate, 4, formatter, isQuarterlyTarget));

			LocalDate lastYearDate = targetDate.minusYears(1).with(TemporalAdjusters.lastDayOfMonth());
			String lastYearString = lastYearDate.format(formatter);

			if (!verifyDataAvailability(lastYearString, "YEARLY")) {
				missing.add("Yearly Report for " + lastYearDate.getYear() + " (" + lastYearString + ")");
			}
		}
		return missing;
	}

	private List<String> getMissingPastQuarters(LocalDate targetDate, int quartersToCheck, DateTimeFormatter formatter,
			boolean isQuarterlyTarget) {
		List<String> missingQuarters = new ArrayList<>();
		LocalDate currentDate = targetDate;

		String[] quarterOrdinals = { "1st", "2nd", "3rd", "4th" };

		if (isQuarterlyTarget) {
			currentDate = currentDate.minusMonths(3).with(TemporalAdjusters.lastDayOfMonth());
		}

		for (int i = 0; i < quartersToCheck; i++) {
			String pastQuarterString = currentDate.format(formatter);

			if (!verifyDataAvailability(pastQuarterString, "QUARTERLY")) {
				int month = currentDate.getMonthValue();
				int quarter = (month - 1) / 3 + 1;
				String ordinalString = quarterOrdinals[quarter - 1];
				missingQuarters.add(ordinalString + " Quarter Report for " + currentDate.getYear() + " ("
						+ pastQuarterString + ")");
			}
			currentDate = currentDate.minusMonths(3).with(TemporalAdjusters.lastDayOfMonth());
		}

		return missingQuarters;
	}
	@Autowired
	RT_MATRIX_MONITOR_BULK_RUN_GROUPS_REPO RT_MATRIX_MONITOR_BULK_RUN_GROUPS_REPO;
	
	@RequestMapping(value = "BulkRun", method = { RequestMethod.GET, RequestMethod.POST })
	public String bulk_run(Model md, HttpServletRequest req) {
		
		List<RT_Matrix_monitoring_entity> Matrixdata = RT_Matrix_monitoring_rep.Getcurrentdatematrixcal();
		md.addAttribute("dbRecords", Matrixdata);
		
		List<RT_MATRIX_MONITOR_BULK_RUN_GROUPS_ENTITY> groupRecords = RT_MATRIX_MONITOR_BULK_RUN_GROUPS_REPO.findAllActiveGroups();
        md.addAttribute("dbGroupRecords", groupRecords);
		
		return "BulkRun";
	}
	@PostMapping("/saveBulkGroup")
    @ResponseBody
    public ResponseEntity<String> saveBulkGroup(@RequestBody GroupSaveRequest request) {
        try {
            RT_MATRIX_MONITOR_BULK_RUN_GROUPS_REPO.softDeleteByGroupName(request.getGroupName());
            
            Long currentMaxId = RT_MATRIX_MONITOR_BULK_RUN_GROUPS_REPO.getMaxId();
            if(currentMaxId == null) currentMaxId = 0L;
            
            List<RT_MATRIX_MONITOR_BULK_RUN_GROUPS_ENTITY> recordsToSave = new ArrayList<>();
            
            if (request.getSnos() == null || request.getSnos().isEmpty()) {
                currentMaxId++; 
                recordsToSave.add(new RT_MATRIX_MONITOR_BULK_RUN_GROUPS_ENTITY(currentMaxId, request.getGroupName(), "EMPTY", "N"));
            } else {
                for (String sno : request.getSnos()) {
                    currentMaxId++; 
                    recordsToSave.add(new RT_MATRIX_MONITOR_BULK_RUN_GROUPS_ENTITY(currentMaxId, request.getGroupName(), sno, "N"));
                }
            }
            
            RT_MATRIX_MONITOR_BULK_RUN_GROUPS_REPO.saveAll(recordsToSave);
            return ResponseEntity.ok("{\"status\":\"success\"}");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"status\":\"error\", \"message\":\"" + e.getMessage() + "\"}");
        }
    }

    @PostMapping("/deleteBulkGroup")
    @ResponseBody
    public ResponseEntity<String> deleteBulkGroup(@RequestParam String groupName) {
        try {
            RT_MATRIX_MONITOR_BULK_RUN_GROUPS_REPO.softDeleteByGroupName(groupName);
            return ResponseEntity.ok("{\"status\":\"success\"}");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"status\":\"error\", \"message\":\"" + e.getMessage() + "\"}");
        }
    }

    public static class GroupSaveRequest {
        private String groupName;
        private List<String> snos;
        
        public String getGroupName() { return groupName; }
        public void setGroupName(String groupName) { this.groupName = groupName; }
        public List<String> getSnos() { return snos; }
        public void setSnos(List<String> snos) { this.snos = snos; }
    }
}