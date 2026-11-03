package com.bornfire.xbrl.services;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil; // Added missing import
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bornfire.xbrl.entities.Forward_reveal_manual_rep;
import com.bornfire.xbrl.util.ExcelUploadHelper;
import com.bornfire.xbrl.util.UploadMessageHelper;
import com.bornfire.xbrl.util.UploadRowStats;
import com.bornfire.xbrl.entities.Forward_reveal_manual_table;
import com.bornfire.xbrl.entities.MIS_TREASURY_PLACEMENT_ENTITY;
import com.bornfire.xbrl.entities.Mis_treasury_placement_repo;
import com.bornfire.xbrl.entities.RT_MID_FX_DEAL_DC;
import com.bornfire.xbrl.entities.RT_MID_FX_DEAL_REPO;
import com.bornfire.xbrl.entities.RT_Treasury_master_tb_entity;
import com.bornfire.xbrl.entities.RT_Treasury_master_tb_repo;
import com.bornfire.xbrl.entities.RT_Treasury_swd_data_entity;
import com.bornfire.xbrl.entities.RT_Treasury_swd_data_repo;

@Service
public class RT_MID_FX_DEAL_SERVICE {

	// Fixed syntax error here: added .class and closing parentheses
	private static final Logger logger = LoggerFactory.getLogger(RT_MID_FX_DEAL_SERVICE.class);

	/**
	 * UK locale → dd/MM display. Default US DataFormatter turns 2-Jun-2026 into
	 * "06/02/2026", which dd/MM parsing then misreads as 6-Feb-2026 on Tomcat.
	 */
	private static final DataFormatter EXCEL_DATE_FORMATTER = new DataFormatter(Locale.UK);

	private static final DateTimeFormatter[] DAY_FIRST_DATE_TIME_FORMATTERS = new DateTimeFormatter[] {
			DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").withResolverStyle(ResolverStyle.STRICT),
			DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withResolverStyle(ResolverStyle.STRICT),
			DateTimeFormatter.ofPattern("dd-MM-yyyy H:mm:ss").withResolverStyle(ResolverStyle.SMART),
			DateTimeFormatter.ofPattern("dd/MM/yyyy H:mm:ss").withResolverStyle(ResolverStyle.SMART),
			DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").withResolverStyle(ResolverStyle.SMART),
			DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withResolverStyle(ResolverStyle.SMART),
	};

	private static final DateTimeFormatter[] DAY_FIRST_DATE_FORMATTERS = new DateTimeFormatter[] {
			DateTimeFormatter.ofPattern("dd-MM-yyyy").withResolverStyle(ResolverStyle.STRICT),
			DateTimeFormatter.ofPattern("dd/MM/yyyy").withResolverStyle(ResolverStyle.STRICT),
			DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH).withResolverStyle(ResolverStyle.STRICT),
			DateTimeFormatter.ofPattern("dd-MMM-yy", Locale.ENGLISH).withResolverStyle(ResolverStyle.SMART),
			DateTimeFormatter.ofPattern("dd-MM-yy").withResolverStyle(ResolverStyle.STRICT),
			DateTimeFormatter.ofPattern("dd/MM/yy").withResolverStyle(ResolverStyle.STRICT),
			DateTimeFormatter.ofPattern("d/M/uuuu", Locale.UK).withResolverStyle(ResolverStyle.SMART),
			DateTimeFormatter.ofPattern("d-M-uuuu", Locale.UK).withResolverStyle(ResolverStyle.SMART),
	};

	    @Autowired
	    RT_MID_FX_DEAL_REPO repo;
	    @Autowired
		AuditService auditservice;
	    
	    @Autowired
	    Mis_treasury_placement_repo Placement_Repo;
	    
	    @Autowired
	    RT_Treasury_master_tb_repo Tb_Master_repo;	
	    
	    @Autowired
	    RT_Treasury_swd_data_repo Tr_Swd_Repo;
	    
	    @Autowired
	    Forward_reveal_manual_rep Forward_repo;

	    // Get already uploaded dates
	    public List<String> getUploadedDates() {
	        List<Date> dates = repo.findUploadedDates();
	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	        return dates.stream()
	                .map(sdf::format)
	                .collect(Collectors.toList());
	    }

	    /** Distinct report dates for Treasury Placement upload (TR_PLC). */
	    public List<String> getTreasuryPlacementUploadedDates() {
	    	return formatReportDates(Placement_Repo.findDistinctReportDates());
	    }

	    /** Distinct report dates for Treasury TB upload (TR_TB). */
	    public List<String> getTreasuryTbUploadedDates() {
	    	return formatReportDates(Tb_Master_repo.findDistinctReportDates());
	    }

	    /** Distinct report dates for Treasury SWD upload (TR_SWD). */
	    public List<String> getTreasurySwdUploadedDates() {
	    	return formatReportDates(Tr_Swd_Repo.findDistinctReportDates());
	    }

	    /** Distinct report dates for Forward Reveal upload (FWD_RVL). */
	    public List<String> getForwardRevealUploadedDates() {
	    	return formatReportDates(Forward_repo.findUploadedDates());
	    }

	    private List<String> formatReportDates(List<Date> dates) {
	    	if (dates == null || dates.isEmpty()) {
	    		return new ArrayList<>();
	    	}
	    	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    	return dates.stream().filter(Objects::nonNull).map(sdf::format).collect(Collectors.toList());
	    }


	    // Upload MFD File
	    @Transactional
	    public String uploadMidFxDealData(MultipartFile file, Date toDate, String username) throws Exception {

	        ExcelUploadHelper.validateUploadFile(file, "MFD");
	        Date today = new Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	        boolean exists = repo.existsByReportDate(toDate);
	        if (exists && !sdf.format(today).equals(sdf.format(toDate))) {
	            throw new RuntimeException("Data already uploaded for this report date: "
	                    + UploadMessageHelper.formatReportDate(toDate));
	        }
	        if (exists) {
	            repo.deleteByReportDate(toDate);
	        }

	        try (Workbook workbook = ExcelUploadHelper.openExcelWorkbook(file)) {

	        RT_MID_FX_DEAL_DC entity = new RT_MID_FX_DEAL_DC();

	        int sheetCount = workbook.getNumberOfSheets();

	        for (int i = 0; i < sheetCount; i++) {

	            String sheetName = workbook.getSheetName(i);
	            Sheet sheet = workbook.getSheetAt(i);

	            if (sheetName.contains("Bonds")) {

	                BpvModExtract extracted = processSheet(sheet);
	                entity.setActualBonds(toSignedDecimal(extracted.bpvText));
	                entity.setAbsBonds(toAbsDecimal(extracted.bpvText));
	                entity.setActualBondsmod(toAbsDecimal(extracted.modDurText));

	            } 
	            else if (sheetName.contains("FxSwaps")) {

	                BpvModExtract extracted = processSheet(sheet);
	                entity.setActualFxSwaps(toSignedDecimal(extracted.bpvText));
	                entity.setAbsFxSwaps(toAbsDecimal(extracted.bpvText));
	                entity.setActualFxSwapsmod(toAbsDecimal(extracted.modDurText));

	            } 
	            else if (sheetName.contains("Outright Forwards")) {

	                BpvModExtract extracted = processSheet(sheet);
	                entity.setActualOutrightForwards(toSignedDecimal(extracted.bpvText));
	                entity.setAbsOutrightForwards(toAbsDecimal(extracted.bpvText));
	                entity.setActualOutrightForwardsmod(toAbsDecimal(extracted.modDurText));

	            } 
	            else if (sheetName.contains("IRS CIRS")) {

	                BpvModExtract extracted = processSheet(sheet);
	                entity.setActualIrsCirs(toSignedDecimal(extracted.bpvText));
	                entity.setAbsIrsCirs(toAbsDecimal(extracted.bpvText));
	                entity.setActualIrsCirsmod(toAbsDecimal(extracted.modDurText));

	            }
	        }

	        entity.setSrlNo(UUID.randomUUID().toString().substring(0, 20));
	        entity.setReportDate(toDate);
	        entity.setReportToDate(toDate);

	        entity.setCreateUser(username);
	        entity.setCreateTime(new Date());

	        entity.setRcreUserId(username);
	        entity.setRcreTime(new Date());

	        entity.setDelFlg("N");
	        entity.setEntityFlg("N");
	        entity.setModifyFlg("N");
	        
	        auditservice.createBusinessAudit(entity.getSrlNo(), "UPLOAD", " Regulatory_Data_Ingestion_MIS_FX_DEAL", null,
					"RT_MID_FX_DEAL");
	        
	        repo.save(entity);

	        return UploadMessageHelper.success("MFD FX Deal", toDate, 1, 0, 1);
	        } catch (RuntimeException e) {
	            throw new RuntimeException(UploadMessageHelper.userFriendlyError(e), e);
	        }
	    }
	


	/** Cell text under the "BPV (K)" and "Mod Dur" headers (row below each), after a "Total" row was seen. */
	private static final class BpvModExtract {
		final String bpvText;
		final String modDurText;

		BpvModExtract(String bpvText, String modDurText) {
			this.bpvText = bpvText;
			this.modDurText = modDurText;
		}
	}

	/**
	 * After "Total" is found, reads the value in the cell below "BPV (K)" and the value below "Mod Dur" (same
	 * column as each label). The two are stored separately.
	 */
	private BpvModExtract processSheet(Sheet sheet) {

		DataFormatter formatter = new DataFormatter();
		boolean totalFound = false;
		String bpv = null;
		String modDur = null;
		for (Row row : sheet) {
			if (row == null) {
				continue;
			}
			for (Cell cell : row) {
				if (cell == null) {
					continue;
				}
				String value = formatter.formatCellValue(cell).trim();

				if ("Total".equalsIgnoreCase(value)) {
					totalFound = true;
					continue;
				}

				if (totalFound && "BPV (K)".equalsIgnoreCase(value)) {
					Row nextRow = sheet.getRow(row.getRowNum() + 1);
					if (nextRow != null) {
						Cell nextCell = nextRow.getCell(cell.getColumnIndex());
						if (nextCell != null) {
							bpv = formatter.formatCellValue(nextCell);
						}
					}
				} else if (totalFound && "Mod Dur".equalsIgnoreCase(value)) {
					Row nextRow = sheet.getRow(row.getRowNum() + 1);
					if (nextRow != null) {
						Cell nextCell = nextRow.getCell(cell.getColumnIndex());
						if (nextCell != null) {
							modDur = formatter.formatCellValue(nextCell);
						}
					}
				}
			}
		}

		return new BpvModExtract(bpv, modDur);
	}

	/** Same rules as before: keep sign and decimal for "actual" amount. */
	private static BigDecimal toSignedDecimal(String raw) {
		if (raw == null) {
			return null;
		}
		String t = raw.replaceAll("[^0-9.-]", "");
		if (t.isEmpty()) {
			return null;
		}
		return new BigDecimal(t);
	}

	/** Digits and dot only (absolute), as used for ABS_* and *_MOD columns. */
	private static BigDecimal toAbsDecimal(String raw) {
		if (raw == null) {
			return null;
		}
		String t = raw.replaceAll("[^0-9.]", "");
		if (t.isEmpty()) {
			return null;
		}
		return new BigDecimal(t);
	}

	
	
	@Transactional
	public String UploadTrplorTb(MultipartFile file, Date toDate, String username, String Report_type)
			throws Exception {
		ExcelUploadHelper.validateUploadFile(file, Report_type);

		try (Workbook workbook = ExcelUploadHelper.openExcelWorkbook(file)) {
			DataFormatter formatter = EXCEL_DATE_FORMATTER;
			UploadRowStats stats = new UploadRowStats();
			String reportName = resolveTreasuryReportName(Report_type);

			if ("TR_PLC".equals(Report_type)) {
				uploadTreasuryPlacement(workbook, formatter, toDate, username, stats);
			} else if ("TR_TB".equals(Report_type)) {
				uploadTreasuryTb(workbook, formatter, toDate, username, stats);
			} else if ("TR_SWD".equals(Report_type)) {
				uploadTreasurySwd(workbook, formatter, toDate, username, stats);
			} else if ("FWD_RVL".equals(Report_type)) {
				uploadForwardReveal(workbook, formatter, toDate, username, stats);
			} else {
				throw new RuntimeException("Unsupported treasury upload type: " + Report_type);
			}

			return finishTreasuryUpload(reportName, toDate, stats);
		} catch (RuntimeException e) {
			throw new RuntimeException(UploadMessageHelper.userFriendlyError(e), e);
		}
	}

	private String resolveTreasuryReportName(String reportType) {
		if ("TR_PLC".equals(reportType)) {
			return "Treasury Placement";
		}
		if ("TR_TB".equals(reportType)) {
			return "Treasury TB";
		}
		if ("TR_SWD".equals(reportType)) {
			return "Treasury SWD";
		}
		if ("FWD_RVL".equals(reportType)) {
			return "Forward Reveal";
		}
		return reportType;
	}

	private String finishTreasuryUpload(String reportName, Date reportDate, UploadRowStats stats) {
		if (stats.getTotal() == 0) {
			throw new RuntimeException("No data rows found in the Excel file for " + reportName
					+ ". Please verify the file contains data below the header row.");
		}
		if (stats.getInserted() == 0) {
			throw new RuntimeException(UploadMessageHelper.failure(reportName, reportDate, stats.getFailed(),
					stats.getTotal(), stats.getSampleErrors()));
		}
		return UploadMessageHelper.success(reportName, reportDate, stats.getInserted(), stats.getFailed(),
				stats.getTotal(), stats.getSampleErrors());
	}

	private void uploadTreasuryPlacement(Workbook workbook, DataFormatter formatter, Date toDate, String username,
			UploadRowStats stats) {
		Placement_Repo.Deletebydaterecord(toDate);
		logger.info("Treasury placement upload started for report date: {}", toDate);

		for (Sheet sheet : workbook) {
			for (Row row : sheet) {
				if (row.getRowNum() == 0 || UploadMessageHelper.isBlankRow(row, formatter)) {
					continue;
				}
				int excelRowNum = row.getRowNum() + 1;
				try {
					MIS_TREASURY_PLACEMENT_ENTITY placement = new MIS_TREASURY_PLACEMENT_ENTITY();
					placement.setNum_operation(formatter.formatCellValue(row.getCell(0)));
					placement.setEntite_operation(formatter.formatCellValue(row.getCell(1)));
					placement.setPoste(formatter.formatCellValue(row.getCell(2)));
					placement.setTitre(formatter.formatCellValue(row.getCell(3)));
					placement.setDevise_1(formatter.formatCellValue(row.getCell(4)));
					placement.setNominal_1(new BigDecimal(formatter.formatCellValue(row.getCell(5))));
					placement.setDate_operation(java.sql.Date.valueOf(getLocalDateFromCell(row.getCell(6))));
					placement.setDate_valeur(java.sql.Date.valueOf(getLocalDateFromCell(row.getCell(7))));
					placement.setDate_echeance(java.sql.Date.valueOf(getLocalDateFromCell(row.getCell(8))));
					placement.setPreavis(formatter.formatCellValue(row.getCell(9)));
					placement.setEntite(formatter.formatCellValue(row.getCell(10)));
					placement.setPortefeuille(formatter.formatCellValue(row.getCell(11)));
					placement.setContrepartie(formatter.formatCellValue(row.getCell(12)));
					placement.setTitre(formatter.formatCellValue(row.getCell(13)));
					placement.setStatut(formatter.formatCellValue(row.getCell(14)));
					placement.setValeur_taux_1(new BigDecimal(formatter.formatCellValue(row.getCell(15))));
					placement.setTaux_1(formatter.formatCellValue(row.getCell(16)));
					placement.setPeriodicite_1(formatter.formatCellValue(row.getCell(17)));
					placement.setAffaire(formatter.formatCellValue(row.getCell(18)));
					placement.setDuree_init(new BigDecimal(formatter.formatCellValue(row.getCell(19))));
					placement.setDuree_restant(new BigDecimal(formatter.formatCellValue(row.getCell(20))));
					placement.setTri_1(formatter.formatCellValue(row.getCell(21)));
					placement.setTri_2(formatter.formatCellValue(row.getCell(22)));
					placement.setTri_3(formatter.formatCellValue(row.getCell(23)));
					placement.setOp_reference(formatter.formatCellValue(row.getCell(24)));
					placement.setFiltrage(formatter.formatCellValue(row.getCell(25)));
					placement.setSigne(formatter.formatCellValue(row.getCell(26)));
					placement.setDate_fin(java.sql.Date.valueOf(getLocalDateFromCell(row.getCell(27))));
					placement.setDate_debut(java.sql.Date.valueOf(getLocalDateFromCell(row.getCell(29))));
					placement.setStatut(formatter.formatCellValue(row.getCell(30)));
					placement.setOp_finance(formatter.formatCellValue(row.getCell(31)));
					placement.setReport_date(toDate);
					placement.setCreate_user(username);
					placement.setCreate_time(new Date());
					Placement_Repo.save(placement);
					stats.recordSuccess();
				} catch (Exception e) {
					logger.warn("Treasury placement row {} failed: {}", excelRowNum, e.getMessage());
					stats.recordFailure(excelRowNum, e);
				}
			}
		}
	}

	private void uploadTreasuryTb(Workbook workbook, DataFormatter formatter, Date toDate, String username,
			UploadRowStats stats) {
		Tb_Master_repo.Deletebydate(toDate);
		logger.info("Treasury TB upload started for report date: {}", toDate);

		for (Sheet sheet : workbook) {
			for (Row row : sheet) {
				if (row.getRowNum() == 0 || UploadMessageHelper.isBlankRow(row, formatter)) {
					continue;
				}
				int excelRowNum = row.getRowNum() + 1;
				try {
					RT_Treasury_master_tb_entity entity = new RT_Treasury_master_tb_entity();
					entity.setEntity(formatter.formatCellValue(row.getCell(0)));
					entity.setAcct_no(formatter.formatCellValue(row.getCell(1)));
					entity.setCurrency(formatter.formatCellValue(row.getCell(2)));
					entity.setAmount_ac(new BigDecimal(formatter.formatCellValue(row.getCell(3))));
					entity.setAmount_lc(new BigDecimal(formatter.formatCellValue(row.getCell(4))));
					entity.setAcct_name(formatter.formatCellValue(row.getCell(5)));
					entity.setDel_flg(formatter.formatCellValue(row.getCell(6)));
					entity.setReport_date(toDate);
					entity.setRcre_user_id(username);
					entity.setRcre_time(new Date());
					Tb_Master_repo.save(entity);
					stats.recordSuccess();
				} catch (Exception e) {
					logger.warn("Treasury TB row {} failed: {}", excelRowNum, e.getMessage());
					stats.recordFailure(excelRowNum, e);
				}
			}
		}
	}

	private void uploadTreasurySwd(Workbook workbook, DataFormatter formatter, Date toDate, String username,
			UploadRowStats stats) {
		Tr_Swd_Repo.Deletebyreportdate(toDate);
		logger.info("Treasury SWD upload started for report date: {}", toDate);

		Sheet sheet = workbook.getSheetAt(0);
		int headerRowIndex = -1;
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			String firstCell = formatter.formatCellValue(row.getCell(0));
			if ("Category".equalsIgnoreCase(firstCell)) {
				headerRowIndex = i;
				break;
			}
		}
		if (headerRowIndex == -1) {
			throw new RuntimeException("Header row not found in Excel file. Expected a row starting with 'Category'.");
		}

		Row headerRow = sheet.getRow(headerRowIndex);
		Map<String, Integer> columnMap = new HashMap<>();
		for (Cell cell : headerRow) {
			if (cell != null) {
				String header = formatter.formatCellValue(cell).trim();
				if (!header.isEmpty()) {
					columnMap.put(header, cell.getColumnIndex());
				}
			}
		}
		requireSwdColumn(columnMap, "Category");

		List<RT_Treasury_swd_data_entity> validRows = new ArrayList<>();
		for (int i = headerRowIndex + 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			if (row == null || UploadMessageHelper.isBlankRow(row, formatter)) {
				continue;
			}
			int excelRowNum = i + 1;
			try {
				String category = formatter.formatCellValue(row.getCell(columnMap.get("Category")));
				if (category == null || category.trim().isEmpty()
						|| !(category.trim().startsWith("BOND") || category.trim().startsWith("EQ"))) {
					continue;
				}

				RT_Treasury_swd_data_entity swdData = mapTreasurySwdRow(row, columnMap, formatter, category, toDate,
						username);
				validRows.add(swdData);
				stats.recordSuccess();
			} catch (Exception e) {
				logger.warn("Treasury SWD row {} failed: {}", excelRowNum, e.getMessage());
				stats.recordFailure(excelRowNum, e);
			}
		}

		if (!validRows.isEmpty()) {
			Tr_Swd_Repo.saveAll(validRows);
		}
	}

	private RT_Treasury_swd_data_entity mapTreasurySwdRow(Row row, Map<String, Integer> columnMap,
			DataFormatter formatter, String category, Date toDate, String username) {
		RT_Treasury_swd_data_entity swdData = new RT_Treasury_swd_data_entity();
		swdData.setData_category(category);
		swdData.setGl_code(formatter.formatCellValue(row.getCell(columnMap.get("GL Code"))));
		swdData.setPortfolio(formatter.formatCellValue(row.getCell(columnMap.get("Portfolio"))));
		swdData.setInstrument(formatter.formatCellValue(row.getCell(columnMap.get("Instr."))));
		swdData.setIsin_number(formatter.formatCellValue(row.getCell(columnMap.get("ISIN Number"))));
		swdData.setSecurity_id(formatter.formatCellValue(row.getCell(columnMap.get("Security ID"))));
		swdData.setSecurity_description(formatter.formatCellValue(row.getCell(columnMap.get("Security Description"))));

		LocalDate maturityDate = getDateFromCell(row.getCell(columnMap.get("Maturity Dt.")));
		if (maturityDate != null) {
			swdData.setMaturity_date(java.sql.Date.valueOf(maturityDate));
		}

		swdData.setIssuer_id(formatter.formatCellValue(row.getCell(columnMap.get("Issuer ID"))));
		swdData.setCpn_rate(formatter.formatCellValue(row.getCell(columnMap.get("Cpn. Rate"))));
		swdData.setCpn_freq(formatter.formatCellValue(row.getCell(columnMap.get("Cpn. Freq."))));
		swdData.setBasis(formatter.formatCellValue(row.getCell(columnMap.get("Basis"))));
		setSwdBigDecimal(row, columnMap, formatter, "No. of Securities", swdData::setNo_of_securities);
		swdData.setCurr(formatter.formatCellValue(row.getCell(columnMap.get("Curr."))));
		setSwdBigDecimal(row, columnMap, formatter, "FV Per Sec.", swdData::setFv_per_sec);
		setSwdBigDecimal(row, columnMap, formatter, "Face Value", swdData::setFace_value);
		setSwdBigDecimal(row, columnMap, formatter, "Book Value", swdData::setBook_value);
		setSwdBigDecimal(row, columnMap, formatter, "Curr. Mkt. Rate", swdData::setCurr_mkt_rate);

		LocalDate currRateDate = getDateFromCell(row.getCell(columnMap.get("Curr. Rate Dt.")));
		if (currRateDate != null) {
			swdData.setCurr_rate_date(java.sql.Date.valueOf(currRateDate));
		}

		setSwdBigDecimal(row, columnMap, formatter, "Market Value", swdData::setMarket_value);
		setSwdBigDecimal(row, columnMap, formatter, "App./ Dep. / Prov.", swdData::setApp_dep_prov);
		setSwdBigDecimal(row, columnMap, formatter, "Accrued Interest", swdData::setAccrued_interest);
		setSwdBigDecimal(row, columnMap, formatter, "Asset Class", swdData::setAsset_class);
		swdData.setAsset_class_description(formatter.formatCellValue(row.getCell(columnMap.get("Asset Class Description"))));

		LocalDate npiDate = getDateFromCell(row.getCell(columnMap.get("Date Of NPI")));
		if (npiDate != null) {
			swdData.setDate_of_npi(java.sql.Date.valueOf(npiDate));
		}

		setSwdBigDecimal(row, columnMap, formatter, "Provision Amt.", swdData::setProvision_amt);
		swdData.setIssuer_group(formatter.formatCellValue(row.getCell(columnMap.get("Issuer Group"))));

		LocalDate optStartDate = getDateFromCell(row.getCell(columnMap.get("Opt Start Date")));
		if (optStartDate != null) {
			swdData.setOpt_start_date(java.sql.Date.valueOf(optStartDate));
		}

		LocalDate optEndDate = getDateFromCell(row.getCell(columnMap.get("Opt End Date")));
		if (optEndDate != null) {
			swdData.setOpt_end_date(java.sql.Date.valueOf(optEndDate));
		}

		swdData.setPan_no(formatter.formatCellValue(row.getCell(columnMap.get("Pan No"))));
		swdData.setOption_type(formatter.formatCellValue(row.getCell(columnMap.get("Option Type"))));
		swdData.setIssuer_country_id(formatter.formatCellValue(row.getCell(columnMap.get("Issuer Country ID"))));
		swdData.setIssuer_country_name(formatter.formatCellValue(row.getCell(columnMap.get("Issuer Country Name"))));
		swdData.setGroup_name(formatter.formatCellValue(row.getCell(columnMap.get("Group"))));
		swdData.setLevel_no(formatter.formatCellValue(row.getCell(columnMap.get("Level"))));
		setSwdBigDecimal(row, columnMap, formatter, "Amort/Prem", swdData::setAmort_prem);
		setSwdBigDecimal(row, columnMap, formatter, "MTM/Reserve", swdData::setMtm_reserve);
		setSwdBigDecimal(row, columnMap, formatter, "Deal Value", swdData::setDeal_value);
		swdData.setSector_code(formatter.formatCellValue(row.getCell(columnMap.get("Sector Code"))));
		swdData.setReport_date(toDate);
		swdData.setRcre_user_id(username);
		swdData.setRcre_time(new Date());
		return swdData;
	}

	private interface BigDecimalSetter {
		void set(BigDecimal value);
	}

	private void setSwdBigDecimal(Row row, Map<String, Integer> columnMap, DataFormatter formatter, String columnName,
			BigDecimalSetter setter) {
		Integer colIndex = columnMap.get(columnName);
		if (colIndex == null || row.getCell(colIndex) == null) {
			return;
		}
		String raw = formatter.formatCellValue(row.getCell(colIndex)).replace(",", "").trim();
		if (!raw.isEmpty()) {
			setter.set(new BigDecimal(raw));
		}
	}

	private void requireSwdColumn(Map<String, Integer> columnMap, String columnName) {
		if (!columnMap.containsKey(columnName)) {
			throw new RuntimeException("Required column '" + columnName
					+ "' was not found in the Excel file. Please use the correct template.");
		}
	}

	private void uploadForwardReveal(Workbook workbook, DataFormatter formatter, Date toDate, String username,
			UploadRowStats stats) {
		logger.info("Forward reval data upload started for report date: {}", toDate);
		Forward_repo.Deletebyreportdate(toDate);

		List<Forward_reveal_manual_table> forwardRows = new ArrayList<>();
		for (Sheet sheet : workbook) {
			for (Row row : sheet) {
				if (row.getRowNum() == 0 || UploadMessageHelper.isBlankRow(row, formatter)) {
					continue;
				}
				int excelRowNum = row.getRowNum() + 1;
				try {
					Forward_reveal_manual_table fwddata = new Forward_reveal_manual_table();
					fwddata.setNum_operation(parseRequiredBigDecimal(formatter, row.getCell(0), "Operation Number"));
					fwddata.setGl_values(parseRequiredBigDecimal(formatter, row.getCell(1), "GL Value"));
					fwddata.setOp_reference(formatter.formatCellValue(row.getCell(2)));
					fwddata.setPoste(formatter.formatCellValue(row.getCell(3)));

					LocalDate dealDate = getDateFromCell(row.getCell(4));
					LocalDate valueDate = getDateFromCell(row.getCell(5));
					LocalDate maturityDate = getDateFromCell(row.getCell(6));
					if (dealDate == null || valueDate == null || maturityDate == null) {
						throw new RuntimeException("Deal date, value date, and maturity date are required.");
					}
					fwddata.setDealdate(java.sql.Date.valueOf(dealDate));
					fwddata.setValuedate(java.sql.Date.valueOf(valueDate));
					fwddata.setMaturitydate(java.sql.Date.valueOf(maturityDate));

					fwddata.setCurrency1(formatter.formatCellValue(row.getCell(7)));
					fwddata.setCurrency2(formatter.formatCellValue(row.getCell(8)));
					fwddata.setNominal_1(parseRequiredBigDecimal(formatter, row.getCell(9), "Nominal 1"));
					fwddata.setRamount(parseRequiredBigDecimal(formatter, row.getCell(10), "R Amount"));
					fwddata.setNo_of_days(parseRequiredBigDecimal(formatter, row.getCell(11), "No. of Days"));
					fwddata.setAmount1(parseRequiredBigDecimal(formatter, row.getCell(12), "Amount 1"));
					fwddata.setDealrate(parseRequiredBigDecimal(formatter, row.getCell(13), "Deal Rate"));
					fwddata.setAmount2(parseRequiredBigDecimal(formatter, row.getCell(14), "Amount 2"));
					fwddata.setReval_rate(parseRequiredBigDecimal(formatter, row.getCell(15), "Reval Rate"));
					fwddata.setReval_amount(parseRequiredBigDecimal(formatter, row.getCell(16), "Reval Amount"));
					fwddata.setProfitloss(parseRequiredBigDecimal(formatter, row.getCell(17), "Profit/Loss"));
					fwddata.setContrepartie(formatter.formatCellValue(row.getCell(18)));
					fwddata.setBranch_code(formatter.formatCellValue(row.getCell(19)));
					fwddata.setLcyrate(parseRequiredBigDecimal(formatter, row.getCell(20), "LCY Rate"));
					fwddata.setLcyprofitloss(parseRequiredBigDecimal(formatter, row.getCell(21), "LCY Profit/Loss"));
					fwddata.setReport_date(toDate);
					fwddata.setEntry_user(username);
					fwddata.setEntry_time(new Date());
					fwddata.setDel_flg("N");
					fwddata.setEntity_flg("N");
					fwddata.setModify_flg("N");
					forwardRows.add(fwddata);
					stats.recordSuccess();
				} catch (Exception e) {
					logger.warn("Forward reveal row {} failed: {}", excelRowNum, e.getMessage());
					stats.recordFailure(excelRowNum, e);
				}
			}
		}

		if (!forwardRows.isEmpty()) {
			Forward_repo.saveAll(forwardRows);
		}
	}

	private BigDecimal parseRequiredBigDecimal(DataFormatter formatter, Cell cell, String fieldName) {
		String raw = cell == null ? "" : formatter.formatCellValue(cell).replace(",", "").trim();
		if (raw.isEmpty()) {
			throw new RuntimeException(fieldName + " is required.");
		}
		return new BigDecimal(raw);
	}

	
	
	/** All treasury Excel uploads: day-month-year (dd-MM-yyyy), independent of server locale. */
	private LocalDate getLocalDateFromCell(Cell cell) {
		return getDateFromCell(cell);
	}

	private LocalDate localDateFromExcelCalendar(Calendar cal) {
		if (cal == null) {
			return null;
		}
		return LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
	}

	private LocalDate localDateFromExcelSerial(double serial) {
		if (!DateUtil.isValidExcelDate(serial)) {
			return null;
		}
		return localDateFromExcelCalendar(DateUtil.getJavaCalendar(serial, false));
	}

	private static String normalizeDateText(String raw) {
		if (raw == null) {
			return "";
		}
		return raw.trim()
				.replace('\u00A0', ' ')
				.replace('\u2007', ' ')
				.replaceAll("\\s+", " ")
				.trim();
	}

	private LocalDate parseDayFirstDateString(String raw) {
		String normalized = normalizeDateText(raw);
		if (normalized.isEmpty()) {
			return null;
		}

		LocalDate parsed = tryParseDayFirstDateTime(normalized);
		if (parsed != null) {
			return parsed;
		}

		parsed = tryParseDayFirstDateOnly(normalized);
		if (parsed != null) {
			return parsed;
		}

		int spaceIdx = normalized.indexOf(' ');
		if (spaceIdx > 0) {
			return tryParseDayFirstDateOnly(normalized.substring(0, spaceIdx).trim());
		}
		return null;
	}

	private LocalDate tryParseDayFirstDateTime(String value) {
		for (DateTimeFormatter formatter : DAY_FIRST_DATE_TIME_FORMATTERS) {
			try {
				return LocalDateTime.parse(value, formatter).toLocalDate();
			} catch (DateTimeParseException ignored) {
				// try next pattern
			}
		}
		return null;
	}

	private LocalDate tryParseDayFirstDateOnly(String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}
		for (DateTimeFormatter formatter : DAY_FIRST_DATE_FORMATTERS) {
			try {
				return LocalDate.parse(value, formatter);
			} catch (DateTimeParseException ignored) {
				// try next pattern
			}
		}
		return null;
	}

	private LocalDate getDateFromCell(Cell cell) {
		if (cell == null) {
			return null;
		}

		try {
			int cellType = cell.getCellType();
			if (cellType == Cell.CELL_TYPE_FORMULA) {
				cellType = cell.getCachedFormulaResultType();
			}

			// Excel date serial — always prefer calendar math (never US locale strings)
			if (cellType == Cell.CELL_TYPE_NUMERIC) {
				double numericValue = cell.getNumericCellValue();
				if (DateUtil.isValidExcelDate(numericValue)) {
					LocalDate fromSerial = localDateFromExcelSerial(numericValue);
					if (fromSerial != null) {
						return fromSerial;
					}
				}
			}

			// Literal text (e.g. "08/04/2026 00:00:00" or "02-06-2026")
			if (cellType == Cell.CELL_TYPE_STRING) {
				LocalDate fromString = parseDayFirstDateString(cell.getStringCellValue());
				if (fromString != null) {
					return fromString;
				}
			}

			// Fallback: UK formatter + day-first patterns only (no MM/dd)
			String formatted = EXCEL_DATE_FORMATTER.formatCellValue(cell);
			return parseDayFirstDateString(formatted);
		} catch (Exception e) {
			logger.debug("Could not parse date from cell: {}", e.getMessage());
			return null;
		}
	}
	
}