package com.bornfire.xbrl.services;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.bornfire.xbrl.entities.RT_MmData;
import com.bornfire.xbrl.entities.RT_MmDataRepository;

@Service
public class RT_MmdataService {

	@Autowired
	private Environment env;

	private static final Logger logger = LoggerFactory.getLogger(RT_MmdataService.class);

	@Autowired
	private RT_MmDataRepository mmdataRepo;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	AuditService auditservice;

	/** New CBUAE MM template "Data" sheet column indexes (0-based). Formula columns are skipped. */
	private static final int COL_DATE = 0;
	private static final int COL_BANK_NAME = 1;
	private static final int COL_HEAD_OFFICE_SUBSIDIARY = 2;
	private static final int COL_SUBSIDIARY = 3;
	// 4-7 formula: Bank Symbol, Conventional/Islamic, Local/Foreign, CBUAE Tiering
	private static final int COL_DEAL_NO = 8;
	private static final int COL_CUSTOMER_ID = 9;
	private static final int COL_COUNTERPARTY_NAME = 10;
	private static final int COL_FINAL_RATING_BANKS = 11;
	// 12 formula: Final Rating CBUAE
	private static final int COL_COUNTRY_OF_RISK = 13;
	// 14 formula: CBUAE Geographical Zone
	private static final int COL_DEAL_TYPE = 15;
	private static final int COL_VALUE_DATE = 16;
	private static final int COL_MATURITY_DATE = 17;
	// 18-23 formula: Initial/Residual maturity fields
	private static final int COL_CURRENCY = 24;
	private static final int COL_PRINCIPAL = 25;
	private static final int COL_PRINCIPAL_AED = 26;
	private static final int COL_INTEREST_PROFIT_RATE_TYPE = 27;
	private static final int COL_FIXED_RATE = 28;
	private static final int COL_FLOATING_RATE_TYPE = 29;
	private static final int COL_FLOATING_RATE_MARGIN = 30;

	public boolean updateMmdata(RT_MmData updatedData) {
		System.out.println("Looking for record with SI_NO: " + updatedData.getDeal_no() + " and Report Date : "
				+ updatedData.getReport_date());
		System.out.println("cust id : " + updatedData.getCustomer_id());
		RT_MmData existing = mmdataRepo.getParticularDataBySI_NOReportdDate(updatedData.getReport_date(),
				updatedData.getDeal_no());

		RT_MmData dbUser = new RT_MmData();

		if (existing != null) {
			org.springframework.beans.BeanUtils.copyProperties(existing, dbUser);
			existing.setBank_name(updatedData.getBank_name());
			existing.setHead_office_subsidiary(updatedData.getHead_office_subsidiary());
			existing.setSubsidiary(updatedData.getSubsidiary());
			existing.setBank_symbol(updatedData.getBank_symbol());
			existing.setConventional_islamic(updatedData.getConventional_islamic());
			existing.setLocal_foreign(updatedData.getLocal_foreign());
			existing.setCbuae_tiering(updatedData.getCbuae_tiering());

			existing.setCustomer_id(updatedData.getCustomer_id());
			existing.setCounterparty_name(updatedData.getCounterparty_name());
			existing.setFinal_rating_banks(updatedData.getFinal_rating_banks());
			existing.setFinal_rating_cbuae(updatedData.getFinal_rating_cbuae());
			existing.setCountry_of_risk(updatedData.getCountry_of_risk());
			existing.setCbuae_geographical_zone(updatedData.getCbuae_geographical_zone());
			existing.setDeal_type(updatedData.getDeal_type());
			existing.setValue_date(updatedData.getValue_date());
			existing.setMaturity_date(updatedData.getMaturity_date());
			existing.setInitial_maturity(updatedData.getInitial_maturity());
			existing.setInitial_maturity_rounded(updatedData.getInitial_maturity_rounded());
			existing.setInitial_maturity_period(updatedData.getInitial_maturity_period());
			existing.setResidual_maturity(updatedData.getResidual_maturity());
			existing.setResidual_maturity_rounded(updatedData.getResidual_maturity_rounded());
			existing.setMaturity_period(updatedData.getMaturity_period());
			existing.setCurrency(updatedData.getCurrency());
			existing.setPrincipal(updatedData.getPrincipal());
			existing.setPrincipal_aed(updatedData.getPrincipal_aed());
			existing.setInterest_profit_rate(updatedData.getInterest_profit_rate());
			existing.setFixed_rate(updatedData.getFixed_rate());
			existing.setFloating_rate(updatedData.getFloating_rate());
			existing.setFloating_rate_basis(updatedData.getFloating_rate_basis());

			List<String> ignoreFields = Arrays.asList("createUser", "modifyUser", "delFlg");

			Map<String, String> changes = new LinkedHashMap<>();

			for (Field field : RT_MmData.class.getDeclaredFields()) {
				field.setAccessible(true);
				try {
					Object oldValue = field.get(dbUser);
					Object newValue = field.get(existing);
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

			mmdataRepo.save(existing);

			System.out.println("changes : " + changes);

			if (!changes.isEmpty()) {
				auditservice.createBusinessAudit(updatedData.getDeal_no(), "MODIFY", "MM_DATA_EDIT_SCREEN", changes,
						"BCBUAE_MM_DATA");
			}

			return true;
		} else {
			System.out.println("No record found for SI_NO: " + updatedData.getDeal_no());
			return false;
		}
	}

	public byte[] generateMmExcel(Date Report_date) throws Exception {
		logger.info("Service: Starting MM Excel generation process in memory. Report_date={}", Report_date);

		List<Object[]> mmDataList = mmdataRepo.getmmdatalistdata1(Report_date);

		if (mmDataList == null || mmDataList.isEmpty()) {
			logger.warn("Service: No data found for MM report. Returning empty result.");
			return new byte[0];
		}

		String templateDir = env.getProperty("output.exportpathtemp");
		String templateFileName = "CBUAE_Mm_Data_Template.xlsx";
		Path templatePath = Paths.get(templateDir, templateFileName);

		logger.info("Service: Attempting to load template from path: {}", templatePath.toAbsolutePath());

		if (!Files.exists(templatePath)) {
			throw new FileNotFoundException("Template file not found at: " + templatePath.toAbsolutePath());
		}

		if (!Files.isReadable(templatePath)) {
			throw new SecurityException("Template file exists but is not readable: " + templatePath.toAbsolutePath());
		}

		try (InputStream templateInputStream = Files.newInputStream(templatePath);
				Workbook workbook = WorkbookFactory.create(templateInputStream);
				ByteArrayOutputStream out = new ByteArrayOutputStream()) {

			Sheet sheet = resolveDataSheet(workbook);
			CreationHelper createHelper = workbook.getCreationHelper();

			CellStyle dateStyle = workbook.createCellStyle();
			dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("MM-dd-yyyy"));
			applyThinBorder(dateStyle);

			CellStyle textStyle = workbook.createCellStyle();
			applyThinBorder(textStyle);

			CellStyle numberStyle = workbook.createCellStyle();
			numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("#,##0.00"));
			applyThinBorder(numberStyle);

			int startRow = 3; // data starts from Excel row 4 (0-based index 3)

			for (int i = 0; i < mmDataList.size(); i++) {
				Object[] mm = mmDataList.get(i);
				if (mm == null) {
					continue;
				}

				Row row = sheet.getRow(startRow + i);
				if (row == null) {
					row = sheet.createRow(startRow + i);
				}

				// Write only non-formula columns; Date = BANK_DATE (fallback REPORT_DATE via SQL NVL)
				setDateCell(row, COL_DATE, toDate(mm, 0), dateStyle);
				setTextCell(row, COL_BANK_NAME, toText(mm, 1), textStyle);
				setTextCell(row, COL_HEAD_OFFICE_SUBSIDIARY, toText(mm, 2), textStyle);
				setTextCell(row, COL_SUBSIDIARY, toText(mm, 3), textStyle);
				setTextCell(row, COL_DEAL_NO, toText(mm, 4), textStyle);
				setTextCell(row, COL_CUSTOMER_ID, toText(mm, 5), textStyle);
				setTextCell(row, COL_COUNTERPARTY_NAME, toText(mm, 6), textStyle);
				setTextCell(row, COL_FINAL_RATING_BANKS, toText(mm, 7), textStyle);
				setTextCell(row, COL_COUNTRY_OF_RISK, toText(mm, 8), textStyle);
				setTextCell(row, COL_DEAL_TYPE, toText(mm, 9), textStyle);
				setDateCell(row, COL_VALUE_DATE, toDate(mm, 10), dateStyle);
				setDateCell(row, COL_MATURITY_DATE, toDate(mm, 11), dateStyle);
				setTextCell(row, COL_CURRENCY, toText(mm, 12), textStyle);
				setNumberCell(row, COL_PRINCIPAL, toBigDecimal(mm, 13), numberStyle);
				setNumberCell(row, COL_PRINCIPAL_AED, toBigDecimal(mm, 14), numberStyle);
				setTextCell(row, COL_INTEREST_PROFIT_RATE_TYPE, toText(mm, 15), textStyle);
				setTextCell(row, COL_FIXED_RATE, toText(mm, 16), textStyle);
				setTextCell(row, COL_FLOATING_RATE_TYPE, toText(mm, 17), textStyle);
				setTextCell(row, COL_FLOATING_RATE_MARGIN, toText(mm, 18), textStyle);
			}

			workbook.setForceFormulaRecalculation(true);
			workbook.write(out);

			logger.info("Service: Excel data successfully written to memory buffer ({} bytes).", out.size());
			return out.toByteArray();
		}
	}

	private Sheet resolveDataSheet(Workbook workbook) {
		Sheet sheet = workbook.getSheet("Data");
		if (sheet != null) {
			return sheet;
		}
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			String name = workbook.getSheetName(i);
			if (name != null && "data".equalsIgnoreCase(name.trim())) {
				return workbook.getSheetAt(i);
			}
		}
		if (workbook.getNumberOfSheets() > 2) {
			logger.warn("Sheet 'Data' not found; falling back to sheet index 2 ({})", workbook.getSheetName(2));
			return workbook.getSheetAt(2);
		}
		throw new IllegalStateException("Sheet named 'Data' not found in CBUAE_Mm_Data_Template.xlsx");
	}

	private void applyThinBorder(CellStyle style) {
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
	}

	private Cell getOrCreateCell(Row row, int col) {
		Cell cell = row.getCell(col);
		if (cell == null) {
			cell = row.createCell(col);
		}
		return cell;
	}

	private void setTextCell(Row row, int col, String value, CellStyle style) {
		Cell cell = getOrCreateCell(row, col);
		cell.setCellValue(value == null ? "" : value);
		if (style != null) {
			cell.setCellStyle(style);
		}
	}

	private void setDateCell(Row row, int col, Date value, CellStyle dateStyle) {
		Cell cell = getOrCreateCell(row, col);
		if (value != null) {
			cell.setCellValue(value);
		} else {
			cell.setCellValue("");
		}
		if (dateStyle != null) {
			cell.setCellStyle(dateStyle);
		}
	}

	private void setNumberCell(Row row, int col, BigDecimal value, CellStyle numberStyle) {
		Cell cell = getOrCreateCell(row, col);
		if (value != null) {
			cell.setCellValue(value.doubleValue());
		} else {
			cell.setCellValue("");
		}
		if (numberStyle != null) {
			cell.setCellStyle(numberStyle);
		}
	}

	private String toText(Object[] row, int idx) {
		if (row == null || idx >= row.length || row[idx] == null) {
			return "";
		}
		return String.valueOf(row[idx]);
	}

	private Date toDate(Object[] row, int idx) {
		if (row == null || idx >= row.length || row[idx] == null) {
			return null;
		}
		Object val = row[idx];
		if (val instanceof Date) {
			return (Date) val;
		}
		return null;
	}

	private BigDecimal toBigDecimal(Object[] row, int idx) {
		if (row == null || idx >= row.length || row[idx] == null) {
			return null;
		}
		Object val = row[idx];
		if (val instanceof BigDecimal) {
			return (BigDecimal) val;
		}
		if (val instanceof Number) {
			return BigDecimal.valueOf(((Number) val).doubleValue());
		}
		try {
			return new BigDecimal(val.toString().trim());
		} catch (Exception e) {
			return null;
		}
	}
}
