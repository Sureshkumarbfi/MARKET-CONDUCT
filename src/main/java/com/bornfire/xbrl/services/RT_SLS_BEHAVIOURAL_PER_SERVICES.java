package com.bornfire.xbrl.services;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bornfire.xbrl.entities.RT_SLS_BEHAVIOURAL_PER_ENTITY;
import com.bornfire.xbrl.entities.RT_SLS_BEHAVIOURAL_PER_REP;
import com.bornfire.xbrl.util.ExcelUploadHelper;


@Service
public class RT_SLS_BEHAVIOURAL_PER_SERVICES {

	private static final Logger logger = LoggerFactory.getLogger(RT_SLS_BEHAVIOURAL_PER_SERVICES.class);
	
	@Autowired
	AuditService auditservice;
	@Autowired
	private RT_SLS_BEHAVIOURAL_PER_REP rtSlsRepository;
	 
	public List<String> getUploadedDates() {
	        List<Date> dates = rtSlsRepository.findUploadedDates();
	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	        return dates.stream()
	                .map(sdf::format)
	                .collect(Collectors.toList());
	    }
	
	public String processAndSaveFile(MultipartFile file, Date fromDate, Date toDate, String username) throws IOException {

	    logger.info("Processing SLS File. User: {}, Reference Date: {}", username, toDate);

	    Date today = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	    boolean exists = rtSlsRepository.existsByReportDate(toDate);

	    // Block if past date already uploaded
	    if (exists && !sdf.format(today).equals(sdf.format(toDate))) {
	        throw new RuntimeException("Data already uploaded for this report date: " + toDate);
	    }

	    // If today upload again → replace
	    if (exists) {
	        rtSlsRepository.deleteByReportDate(toDate);
	    }

	    try (Workbook workbook = ExcelUploadHelper.openSlsXlsxWorkbook(file)) {

	        Sheet sheet = workbook.getSheetAt(0);

	        RT_SLS_BEHAVIOURAL_PER_ENTITY entity = new RT_SLS_BEHAVIOURAL_PER_ENTITY();

	        String uniqueId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
	        if (uniqueId.length() > 20) {
	            uniqueId = uniqueId.substring(0, 20);
	        }

	        entity.setSrl_no(uniqueId);

	        // Set dates correctly
	        entity.setReport_from_date(fromDate);
	        entity.setReport_to_date(toDate);
	        entity.setReportDate(toDate);

	        entity.setCreate_user(username);
	        entity.setCreate_time(new Date());

	        entity.setEntity_flg("N");
	        entity.setDel_flg("N");

	        /* -------- Excel Mapping -------- */

	        mapSbSection(sheet, entity, 2);
	        mapCaSection(sheet, entity, 8);
	        mapOdSection(sheet, entity, 14);
	        mapBillsSection(sheet, entity, 20);
	        mapUndrawnSection(sheet, entity, 2);
	        mapNonFundSection(sheet, entity, 9);

	        /* -------- Term Deposit -------- */

	        Row tdRow = sheet.getRow(4);
	        if (tdRow != null) {
	            entity.setTerm_deposit_retail__rollover_sdr(getNumVal(tdRow, 9));
	            entity.setTerm_deposit_retail__rollover_fdr(getNumVal(tdRow, 10));
	            entity.setTerm_deposit_retail__premature_sdr(getNumVal(tdRow, 11));
	            entity.setTerm_deposit_retail__premature_fdr(getNumVal(tdRow, 12));
	        }

	        /* -------- Prepayment -------- */

	        Row ppRow = sheet.getRow(1);
	        if (ppRow != null) {
	            entity.setSp_prepayment(getNumVal(ppRow, 28));
	        }
	        
	        auditservice.createBusinessAudit(entity.getSrl_no(), "UPLOAD", " Regulatory_Data_Ingestion_SLS", null,
					"RT_SLS_BEHAVIOURAL_PER_SC_TABLE");
	        
	        rtSlsRepository.save(entity);

	        logger.info("Saved SLS entity ID: {}", entity.getSrl_no());

	        return "SLS data uploaded successfully!";

	    } catch (Exception e) {

	        logger.error("Error processing SLS file: {}", e.getMessage());

	        throw new IOException("Failed to process file: " + e.getMessage(), e);
	    }
	}

	private void mapSbSection(Sheet sheet, RT_SLS_BEHAVIOURAL_PER_ENTITY e, int startRow) {
		for (int i = 0; i < 4; i++) {
			Row row = sheet.getRow(startRow + i);
			if (row != null) {
				String segment = getStringVal(row, 0);
				BigDecimal d1 = getNumVal(row, 2);
				BigDecimal d2 = getNumVal(row, 3);
				BigDecimal d3 = getNumVal(row, 4);
				BigDecimal d4 = getNumVal(row, 5);
				BigDecimal d5 = getNumVal(row, 6);

				if (i == 0) {
					e.setSb_q1_segment(segment);
					e.setSb_q1__1_day_outflow(d1);
					e.setSb_q1__2_7_days_out_flow(d2);
					e.setSb_q1__8_14_days_outflow(d3);
					e.setSb_q1__1_3_years(d4);
					e.setSb_q1__above_5_years(d5);
				} else if (i == 1) {
					e.setSb_q2_segment(segment);
					e.setSb_q2__1_day_outflow(d1);
					e.setSb_q2__2_7_days_out_flow(d2);
					e.setSb_q2__8_14_days_outflow(d3);
					e.setSb_q2__1_3_years(d4);
					e.setSb_q2__above_5_years(d5);
				} else if (i == 2) {
					e.setSb_q3_segment(segment);
					e.setSb_q3__1_day_outflow(d1);
					e.setSb_q3__2_7_days_out_flow(d2);
					e.setSb_q3__8_14_days_outflow(d3);
					e.setSb_q3__1_3_years(d4);
					e.setSb_q3__above_5_years(d5);
				} else if (i == 3) {
					e.setSb_q4_segment(segment);
					e.setSb_q4__1_day_outflow(d1);
					e.setSb_q4__2_7_days_out_flow(d2);
					e.setSb_q4__8_14_days_outflow(d3);
					e.setSb_q4__1_3_years(d4);
					e.setSb_q4__above_5_years(d5);
				}
			}
		}
	}

	private void mapCaSection(Sheet sheet, RT_SLS_BEHAVIOURAL_PER_ENTITY e, int startRow) {
		for (int i = 0; i < 4; i++) {
			Row r = sheet.getRow(startRow + i);
			if (r == null)
				continue;
			String seg = getStringVal(r, 0);
			BigDecimal d1 = getNumVal(r, 2), d2 = getNumVal(r, 3), d3 = getNumVal(r, 4), d4 = getNumVal(r, 5),
					d5 = getNumVal(r, 6);

			if (i == 0) {
				e.setCa_q1_segment(seg);
				e.setCa_q1__1_day_outflow(d1);
				e.setCa_q1__2_7_days_out_flow(d2);
				e.setCa_q1__8_14_days_outflow(d3);
				e.setCa_q1__1_3_years(d4);
				e.setCa_q1__above_5_years(d5);
			} else if (i == 1) {
				e.setCa_q2_segment(seg);
				e.setCa_q2__1_day_outflow(d1);
				e.setCa_q2__2_7_days_out_flow(d2);
				e.setCa_q2__8_14_days_outflow(d3);
				e.setCa_q2__1_3_years(d4);
				e.setCa_q2__above_5_years(d5);
			} else if (i == 2) {
				e.setCa_q3_segment(seg);
				e.setCa_q3__1_day_outflow(d1);
				e.setCa_q3__2_7_days_out_flow(d2);
				e.setCa_q3__8_14_days_outflow(d3);
				e.setCa_q3__1_3_years(d4);
				e.setCa_q3__above_5_years(d5);
			} else if (i == 3) {
				e.setCa_q4_segment(seg);
				e.setCa_q4__1_day_outflow(d1);
				e.setCa_q4__2_7_days_out_flow(d2);
				e.setCa_q4__8_14_days_outflow(d3);
				e.setCa_q4__1_3_years(d4);
				e.setCa_q4__above_5_years(d5);
			}
		}
	}

	private void mapOdSection(Sheet sheet, RT_SLS_BEHAVIOURAL_PER_ENTITY e, int startRow) {
		for (int i = 0; i < 4; i++) {
			Row r = sheet.getRow(startRow + i);
			if (r == null)
				continue;
			String seg = getStringVal(r, 0);
			BigDecimal d1 = getNumVal(r, 2), d2 = getNumVal(r, 3), d3 = getNumVal(r, 4), d4 = getNumVal(r, 5),
					d5 = getNumVal(r, 6);

			if (i == 0) {
				e.setOd_q1_segment(seg);
				e.setOd_q1__1_day_outflow(d1);
				e.setOd_q1__2_7_days_out_flow(d2);
				e.setOd_q1__8_14_days_outflow(d3);
				e.setOd_q1__1_3_years(d4);
				e.setOd_q1__above_5_years(d5);
			} else if (i == 1) {
				e.setOd_q2_segment(seg);
				e.setOd_q2__1_day_outflow(d1);
				e.setOd_q2__2_7_days_out_flow(d2);
				e.setOd_q2__8_14_days_outflow(d3);
				e.setOd_q2__1_3_years(d4);
				e.setOd_q2__above_5_years(d5);
			} else if (i == 2) {
				e.setOd_q3_segment(seg);
				e.setOd_q3__1_day_outflow(d1);
				e.setOd_q3__2_7_days_out_flow(d2);
				e.setOd_q3__8_14_days_outflow(d3);
				e.setOd_q3__1_3_years(d4);
				e.setOd_q3__above_5_years(d5);
			} else if (i == 3) {
				e.setOd_q4_segment(seg);
				e.setOd_q4__1_day_outflow(d1);
				e.setOd_q4__2_7_days_out_flow(d2);
				e.setOd_q4__8_14_days_outflow(d3);
				e.setOd_q4__1_3_years(d4);
				e.setOd_q4__above_5_years(d5);
			}
		}
	}

	private void mapBillsSection(Sheet sheet, RT_SLS_BEHAVIOURAL_PER_ENTITY e, int startRow) {
		for (int i = 0; i < 4; i++) {
			Row r = sheet.getRow(startRow + i);
			if (r == null)
				continue;
			String seg = getStringVal(r, 0);
			BigDecimal d1 = getNumVal(r, 2), d2 = getNumVal(r, 3), d3 = getNumVal(r, 4), d4 = getNumVal(r, 5),
					d5 = getNumVal(r, 6);

			if (i == 0) {
				e.setBills_payable_q1_segment(seg);
				e.setBills_payable_q1__1_day_outflow(d1);
				e.setBills_payable_q1__2_7_days_out_flow(d2);
				e.setBills_payable_q1__8_14_days_outflow(d3);
				e.setBills_payable_q1__1_3_years(d4);
				e.setBills_payable_q1__above_5_years(d5);
			} else if (i == 1) {
				e.setBills_payable_q2_segment(seg);
				e.setBills_payable_q2__1_day_outflow(d1);
				e.setBills_payable_q2__2_7_days_out_flow(d2);
				e.setBills_payable_q2__8_14_days_outflow(d3);
				e.setBills_payable_q2__1_3_years(d4);
				e.setBills_payable_q2__above_5_years(d5);
			} else if (i == 2) {
				e.setBills_payable_q3_segment(seg);
				e.setBills_payable_q3__1_day_outflow(d1);
				e.setBills_payable_q3__2_7_days_out_flow(d2);
				e.setBills_payable_q3__8_14_days_outflow(d3);
				e.setBills_payable_q3__1_3_years(d4);
				e.setBills_payable_q3__above_5_years(d5);
			} else if (i == 3) {
				e.setBills_payable_q4_segment(seg);
				e.setBills_payable_q4__1_day_outflow(d1);
				e.setBills_payable_q4__2_7_days_out_flow(d2);
				e.setBills_payable_q4__8_14_days_outflow(d3);
				e.setBills_payable_q4__1_3_years(d4);
				e.setBills_payable_q4__above_5_years(d5);
			}
		}
	}

	private void mapUndrawnSection(Sheet sheet, RT_SLS_BEHAVIOURAL_PER_ENTITY e, int startRow) {
		for (int i = 0; i < 4; i++) {
			Row r = sheet.getRow(startRow + i);
			if (r == null)
				continue;

			String seg = getStringVal(r, 16);
			if (seg.isEmpty())
				seg = "QRTR " + (i + 1);

			BigDecimal tot = getNumVal(r, 17);
			BigDecimal d1 = getNumVal(r, 18);
			BigDecimal d2 = getNumVal(r, 19);
			BigDecimal d3 = getNumVal(r, 20);
			BigDecimal d4 = getNumVal(r, 21);
			BigDecimal d5 = getNumVal(r, 22);
			BigDecimal d6 = getNumVal(r, 23);
			BigDecimal d7 = getNumVal(r, 24);
			BigDecimal d8 = getNumVal(r, 25);

			if (i == 0) {
				e.setUndrawn_balance_q1_segment(seg);
				e.setUndrawn_balance_q1__total(tot);
				e.setUndrawn_balance_q1__day_1(d1);
				e.setUndrawn_balance_q1__2_7_days(d2);
				e.setUndrawn_balance_q1__8_14_days(d3);
				e.setUndrawn_balance_q1__15_30_days(d4);
				e.setUndrawn_balance_q1__31_days_to_2_months(d5);
				e.setUndrawn_balance_q1__more_than_2m_to_3m(d6);
				e.setUndrawn_balance_q1__over_3m_to_6m(d7);
				e.setUndrawn_balance_q1__over_6m_to_1y(d8);
			} else if (i == 1) {
				e.setUndrawn_balance_q2_segment(seg);
				e.setUndrawn_balance_q2__total(tot);
				e.setUndrawn_balance_q2__day_1(d1);
				e.setUndrawn_balance_q2__2_7_days(d2);
				e.setUndrawn_balance_q2__8_14_days(d3);
				e.setUndrawn_balance_q2__15_30_days(d4);
				e.setUndrawn_balance_q2__31_days_to_2_months(d5);
				e.setUndrawn_balance_q2__more_than_2m_to_3m(d6);
				e.setUndrawn_balance_q2__over_3m_to_6m(d7);
				e.setUndrawn_balance_q2__over_6m_to_1y(d8);
			} else if (i == 2) {
				e.setUndrawn_balance_q3_segment(seg);
				e.setUndrawn_balance_q3__total(tot);
				e.setUndrawn_balance_q3__day_1(d1);
				e.setUndrawn_balance_q3__2_7_days(d2);
				e.setUndrawn_balance_q3__8_14_days(d3);
				e.setUndrawn_balance_q3__15_30_days(d4);
				e.setUndrawn_balance_q3__31_days_to_2_months(d5);
				e.setUndrawn_balance_q3__more_than_2m_to_3m(d6);
				e.setUndrawn_balance_q3__over_3m_to_6m(d7);
				e.setUndrawn_balance_q3__over_6m_to_1y(d8);
			} else if (i == 3) {
				e.setUndrawn_balance_q4_segment(seg);
				e.setUndrawn_balance_q4__total(tot);
				e.setUndrawn_balance_q4__day_1(d1);
				e.setUndrawn_balance_q4__2_7_days(d2);
				e.setUndrawn_balance_q4__8_14_days(d3);
				e.setUndrawn_balance_q4__15_30_days(d4);
				e.setUndrawn_balance_q4__31_days_to_2_months(d5);
				e.setUndrawn_balance_q4__more_than_2m_to_3m(d6);
				e.setUndrawn_balance_q4__over_3m_to_6m(d7);
				e.setUndrawn_balance_q4__over_6m_to_1y(d8);
			}
		}
	}

	private void mapNonFundSection(Sheet sheet, RT_SLS_BEHAVIOURAL_PER_ENTITY e, int startRow) {
		for (int i = 0; i < 4; i++) {
			Row r = sheet.getRow(startRow + i);
			if (r == null)
				continue;
			String seg = getStringVal(r, 16);
			if (seg.isEmpty())
				seg = "QRTR " + (i + 1);

			BigDecimal d1 = getNumVal(r, 17);
			BigDecimal d2 = getNumVal(r, 18);
			BigDecimal d3 = getNumVal(r, 19);
			BigDecimal d4 = getNumVal(r, 20);
			BigDecimal d5 = getNumVal(r, 21);
			BigDecimal d6 = getNumVal(r, 22);

			if (i == 0) {
				e.setNonfund_lc_bg_q1_segment(seg);
				e.setNonfund_lc_bg_q1__1_day(d1);
				e.setNonfund_lc_bg_q1__2_7_days(d2);
				e.setNonfund_lc_bg_q1__8_14_days(d3);
				e.setNonfund_lc_bg_q1__15_30_days(d4);
				e.setNonfund_lc_bg_q1__31_60_days(d5);
				e.setNonfund_lc_bg_q1__61_90_days(d6);
			} else if (i == 1) {
				e.setNonfund_lc_bg_q2_segment(seg);
				e.setNonfund_lc_bg_q2__1_day(d1);
				e.setNonfund_lc_bg_q2__2_7_days(d2);
				e.setNonfund_lc_bg_q2__8_14_days(d3);
				e.setNonfund_lc_bg_q2__15_30_days(d4);
				e.setNonfund_lc_bg_q2__31_60_days(d5);
				e.setNonfund_lc_bg_q2__61_90_days(d6);
			} else if (i == 2) {
				e.setNonfund_lc_bg_q3_segment(seg);
				e.setNonfund_lc_bg_q3__1_day(d1);
				e.setNonfund_lc_bg_q3__2_7_days(d2);
				e.setNonfund_lc_bg_q3__8_14_days(d3);
				e.setNonfund_lc_bg_q3__15_30_days(d4);
				e.setNonfund_lc_bg_q3__31_60_days(d5);
				e.setNonfund_lc_bg_q3__61_90_days(d6);
			} else if (i == 3) {
				e.setNonfund_lc_bg_q4_segment(seg);
				e.setNonfund_lc_bg_q4__1_day(d1);
				e.setNonfund_lc_bg_q4__2_7_days(d2);
				e.setNonfund_lc_bg_q4__8_14_days(d3);
				e.setNonfund_lc_bg_q4__15_30_days(d4);
				e.setNonfund_lc_bg_q4__31_60_days(d5);
				e.setNonfund_lc_bg_q4__61_90_days(d6);
			}
		}
	}

	private BigDecimal getNumVal(Row row, int cellIndex) {
		if (row == null)
			return BigDecimal.ZERO;
		Cell cell = row.getCell(cellIndex);
		if (cell == null)
			return BigDecimal.ZERO;
		try {
			if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
				return BigDecimal.valueOf(cell.getNumericCellValue());
			else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				String val = cell.getStringCellValue().replaceAll("[,%]", "").trim();
				return val.isEmpty() ? BigDecimal.ZERO : new BigDecimal(val);
			}
		} catch (Exception e) {
			logger.warn("Error parsing numeric value at index {}", cellIndex);
		}
		return BigDecimal.ZERO;
	}

	private String getStringVal(Row row, int cellIndex) {
		if (row == null)
			return "";
		Cell cell = row.getCell(cellIndex);
		return (cell != null) ? cell.toString().trim() : "";
	}

	public byte[] generateSlsTemplate() throws IOException {
		try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			XSSFSheet sheet = workbook.createSheet("SLS_Template");

			XSSFColor orangeColor = new XSSFColor(new Color(255, 192, 0));
			XSSFColor greenColor = new XSSFColor(new Color(146, 208, 80));
			XSSFColor greyColor = new XSSFColor(new Color(217, 217, 217));

			XSSFFont boldFont = workbook.createFont();
			boldFont.setBold(true);

			XSSFFont redBoldFont = workbook.createFont();
			redBoldFont.setBold(true);
			redBoldFont.setColor(IndexedColors.RED.getIndex());
			redBoldFont.setUnderline(Font.U_SINGLE);

			XSSFFont redFont = workbook.createFont();
			redFont.setColor(IndexedColors.RED.getIndex());

			XSSFCellStyle mainHeaderStyle = createStyle(workbook, orangeColor, boldFont);
			XSSFCellStyle greenHeaderStyle = createStyle(workbook, greenColor, boldFont);
			XSSFCellStyle whiteBoldStyle = createStyle(workbook, null, boldFont);
			XSSFCellStyle inputStyle = createStyle(workbook, null, null);

			XSSFCellStyle redTextWhiteBgStyle = createStyle(workbook, null, redFont);
			redTextWhiteBgStyle.setAlignment(HorizontalAlignment.LEFT);

			XSSFCellStyle redTextHeaderStyle = createStyle(workbook, null, redBoldFont);

			// --- LEFT SECTIONS ---
			String[] leftHeaders = { "1 Day", "2-7 Days", "8-14 Days", "1-3 Years", "> 5 Years" };

			createBlock(sheet, 0, 0, 6, "NON MATURING", mainHeaderStyle);

			// SB
			createLeftHeaderRow(sheet, 1, "SB", leftHeaders, greenHeaderStyle);
			createDataRows(sheet, 2, 0, 4, greenHeaderStyle, inputStyle);

			// CA
			createLeftHeaderRow(sheet, 7, "CA", leftHeaders, greenHeaderStyle);
			createDataRows(sheet, 8, 0, 4, greenHeaderStyle, inputStyle);

			// OD
			createLeftHeaderRow(sheet, 13, "OD", leftHeaders, greenHeaderStyle);
			createDataRows(sheet, 14, 0, 4, greenHeaderStyle, inputStyle);

			// BILLS
			createLeftHeaderRow(sheet, 19, "Bills payable", leftHeaders, greenHeaderStyle);
			createDataRows(sheet, 20, 0, 4, greenHeaderStyle, inputStyle);

			// --- MIDDLE SECTION (TERM DEPOSITS) ---
			int tdCol = 9;
			createMergedCell(sheet, 0, tdCol, tdCol + 3, "TERM DEPOSIT-RETAIL", mainHeaderStyle);

			Row row2 = getOrCreateRow(sheet, 2);
			createStyledCell(row2, tdCol, "Roll over %", createStyle(workbook, greyColor, null));
			sheet.addMergedRegion(new CellRangeAddress(2, 2, tdCol, tdCol + 1));
			createStyledCell(row2, tdCol + 2, "Premature %", createStyle(workbook, greyColor, null));
			sheet.addMergedRegion(new CellRangeAddress(2, 2, tdCol + 2, tdCol + 3));

			createRow(sheet, 3, tdCol, new String[] { "SDR", "FDR", "SDR", "FDR" }, greenHeaderStyle);

			Row row4 = getOrCreateRow(sheet, 4);
			for (int i = 0; i < 4; i++)
				createStyledCell(row4, tdCol + i, "", inputStyle);

			// --- RIGHT SECTION (UNDRAWN & NON-FUND) ---
			int rightCol = 15;
			createMergedCell(sheet, 0, rightCol, rightCol + 10, "UNDRAWN BALANCE AND NONFUND(LC-BG)", mainHeaderStyle);

			// UNDRAWN
			Row r1 = getOrCreateRow(sheet, 1);
			createStyledCell(r1, rightCol, "Undrawn Balance", greenHeaderStyle);
			createStyledCell(r1, rightCol + 1, "Likely availment of CCOD", redTextHeaderStyle);

			String[] udHeaders = { "", "Day - 1", "2-7 Days", "8-14 Days", "15-30 Days", "31 Days & More",
					"More than...", "Over 3 Months", "Over 6 Months and upto 1 year" };
			for (int i = 0; i < udHeaders.length; i++) {
				createStyledCell(r1, rightCol + 2 + i, udHeaders[i], whiteBoldStyle);
			}

			for (int i = 0; i < 4; i++) {
				Row row = getOrCreateRow(sheet, 2 + i);
				createStyledCell(row, rightCol, "", inputStyle);
				createStyledCell(row, rightCol + 1, "", redTextWhiteBgStyle);
				createStyledCell(row, rightCol + 2, "", inputStyle);
				for (int j = 3; j < 11; j++)
					createStyledCell(row, rightCol + j, "", inputStyle);
			}

			// NON FUND
			Row r7 = getOrCreateRow(sheet, 7);
			createStyledCell(r7, rightCol, "NON FUND", greenHeaderStyle);
			createStyledCell(r7, rightCol + 1, "Likely Devolvement of LCBG", redTextHeaderStyle);
			for (int k = 2; k < 11; k++)
				createStyledCell(r7, rightCol + k, "", inputStyle);

			Row r8 = getOrCreateRow(sheet, 8);
			createStyledCell(r8, rightCol, "", inputStyle);
			createStyledCell(r8, rightCol + 1, "Final for bucket", whiteBoldStyle);

			String[] nfHeaders = { "1 Day", "2-7 Days", "8-14 Days", "15-30 Days", "31-60 Days", "61-90 Days" };
			for (int k = 0; k < nfHeaders.length; k++) {
				createStyledCell(r8, rightCol + 2 + k, nfHeaders[k], whiteBoldStyle);
			}

			for (int i = 0; i < 4; i++) {
				Row row = getOrCreateRow(sheet, 9 + i);
				createStyledCell(row, rightCol, "", inputStyle);
				createStyledCell(row, rightCol + 1, "", inputStyle);
				for (int k = 0; k < nfHeaders.length; k++)
					createStyledCell(row, rightCol + 2 + k, "", inputStyle);
			}

			// --- PREPAYMENT ---
			int ppCol = 27;
			createMergedCell(sheet, 0, ppCol, ppCol + 1, "SYNDICATION-PREPAYMENT", mainHeaderStyle);
			Row rpp = getOrCreateRow(sheet, 1);
			createStyledCell(rpp, ppCol, "PREPAYMENT", greenHeaderStyle);
			createStyledCell(rpp, ppCol + 1, "", inputStyle);

			for (int i = 0; i < 40; i++)
				sheet.autoSizeColumn(i);

			workbook.write(out);
			return out.toByteArray();
		}
	}

	// =========================================================
	// 3. HELPER METHODS
	// =========================================================
	private XSSFCellStyle createStyle(XSSFWorkbook workbook, XSSFColor bgColor, Font font) {
		XSSFCellStyle style = workbook.createCellStyle();
		if (bgColor != null) {
			style.setFillForegroundColor(bgColor);
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}
		style.setBorderTop(BorderStyle.THIN);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		if (font != null)
			style.setFont(font);
		return style;
	}

	private void createBlock(Sheet sheet, int rowNum, int startCol, int endCol, String text, CellStyle style) {
		createMergedCell(sheet, rowNum, startCol, endCol, text, style);
	}

	private void createMergedCell(Sheet sheet, int rowNum, int startCol, int endCol, String text, CellStyle style) {
		Row row = getOrCreateRow(sheet, rowNum);
		for (int i = startCol; i <= endCol; i++)
			createStyledCell(row, i, "", style);
		Cell cell = row.getCell(startCol);
		cell.setCellValue(text);
		sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum, startCol, endCol));
	}

	private void createRow(Sheet sheet, int rowNum, int startCol, String[] values, CellStyle style) {
		Row row = getOrCreateRow(sheet, rowNum);
		for (int i = 0; i < values.length; i++)
			createStyledCell(row, startCol + i, values[i], style);
	}

	private void createLeftHeaderRow(Sheet sheet, int rowNum, String label, String[] headers, CellStyle style) {
		Row row = getOrCreateRow(sheet, rowNum);
		createStyledCell(row, 0, label, style);
		createStyledCell(row, 1, "", style);
		for (int i = 0; i < headers.length; i++)
			createStyledCell(row, 2 + i, headers[i], style);
	}

	private void createDataRows(Sheet sheet, int startRow, int startCol, int count, CellStyle labelStyle,
			CellStyle inputStyle) {
		String[] qtrLabels = { "QRTR 1", "QRTR 2", "QRTR 3", "QRTR 4" };
		for (int i = 0; i < count; i++) {
			Row row = getOrCreateRow(sheet, startRow + i);
			createStyledCell(row, startCol, "", inputStyle);
			createStyledCell(row, startCol + 1, qtrLabels[i], labelStyle);
			for (int j = 2; j < 7; j++)
				createStyledCell(row, startCol + j, "", inputStyle);
		}
	}

	private Row getOrCreateRow(Sheet sheet, int rowIndex) {
		Row row = sheet.getRow(rowIndex);
		return (row == null) ? sheet.createRow(rowIndex) : row;
	}

	private void createStyledCell(Row row, int colIndex, String value, CellStyle style) {
		Cell cell = row.getCell(colIndex);
		if (cell == null)
			cell = row.createCell(colIndex);
		cell.setCellValue(value);
		cell.setCellStyle(style);
	}
}