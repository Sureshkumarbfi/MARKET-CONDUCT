package com.bornfire.xbrl.services;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.bornfire.xbrl.entities.RT_Liquidity_Risk_Data_Template;
import com.bornfire.xbrl.entities.RT_Liquidity_Risk_Data_Template_Repository;
import com.bornfire.xbrl.entities.RT_RepoDataTemplate;

@Service
public class RT_Liquidity_Risk_Data_Service {

	private static final Logger logger = LoggerFactory.getLogger(RT_Liquidity_Risk_Data_Service.class);

	private static final String LIQUIDITY_GAP_SHEET_NAME = "Liquidity Gap";
	private static final int AED_HEADER_ROW = 0; // Excel row 1
	private static final int TEMPLATE_DATA_ROW = 1; // Excel row 2 — empty row with formulas
	private static final int TEMPLATE_EMPTY_ROW = 2; // Excel row 3
	private static final int EMPTY_ROWS_AFTER_AED = 2;
	
    @Autowired
    RT_Liquidity_Risk_Data_Template_Repository LiquidityRiskDataRepository;

    @Autowired
    private Environment env;

	@Autowired
	AuditService auditService;
    // Update existing record
    public boolean updateLiquidityRisk(RT_Liquidity_Risk_Data_Template updatedEntity) {
        //Optional<RT_Liquidity_Risk_Data_Template> existingOpt = LiquidityRiskDataRepository.findById(updatedEntity.getSlno());
        RT_Liquidity_Risk_Data_Template existingOpt = LiquidityRiskDataRepository
				.getbyGlLevelsReportDateIC(updatedEntity.getReportDate(), updatedEntity.getGlLevel1(),updatedEntity.getGlLevel2(),updatedEntity.getGlLevel3(),updatedEntity.getInstrumentCurrency());
		
        if (!existingOpt.equals(null)) {
            RT_Liquidity_Risk_Data_Template existing = existingOpt;

            RT_Liquidity_Risk_Data_Template dbUser = new RT_Liquidity_Risk_Data_Template();
			org.springframework.beans.BeanUtils.copyProperties(existing, dbUser);

            existing.setDataDate(updatedEntity.getDataDate());
            existing.setBankName(updatedEntity.getBankName());
            existing.setHeadOfficeSubsidiary(updatedEntity.getHeadOfficeSubsidiary());
            existing.setBankSymbol(updatedEntity.getBankSymbol());
            existing.setConventionalIslamic(updatedEntity.getConventionalIslamic());
            existing.setLocalForeign(updatedEntity.getLocalForeign());
            existing.setCbuaeTiering(updatedEntity.getCbuaeTiering());
            existing.setGlLevel1(updatedEntity.getGlLevel1());
            existing.setGlLevel2(updatedEntity.getGlLevel2());
            existing.setGlLevel3(updatedEntity.getGlLevel3());
            existing.setOptionType(updatedEntity.getOptionType());
            existing.setRateType(updatedEntity.getRateType());
            existing.setReferenceRate(updatedEntity.getReferenceRate());
            existing.setInstrumentCurrency(updatedEntity.getInstrumentCurrency());

            existing.setOutstandingBalance(updatedEntity.getOutstandingBalance());
            existing.setOvernight(updatedEntity.getOvernight());
            existing.setOnTo1m(updatedEntity.getOnTo1m());
            existing.setOneMTo3m(updatedEntity.getOneMTo3m());
            existing.setThreeMTo6m(updatedEntity.getThreeMTo6m());
            existing.setSixMTo9m(updatedEntity.getSixMTo9m());
            existing.setNineMTo1y(updatedEntity.getNineMTo1y());
            existing.setOneYTo1_5y(updatedEntity.getOneYTo1_5y());
            existing.setOne5yTo2y(updatedEntity.getOne5yTo2y());
            existing.setTwoYTo3y(updatedEntity.getTwoYTo3y());
            existing.setThreeYTo4y(updatedEntity.getThreeYTo4y());
            existing.setFourYTo5y(updatedEntity.getFourYTo5y());
            existing.setFiveYTo6y(updatedEntity.getFiveYTo6y());
            existing.setSixYTo7y(updatedEntity.getSixYTo7y());
            existing.setSevenYTo8y(updatedEntity.getSevenYTo8y());
            existing.setEightYTo9y(updatedEntity.getEightYTo9y());
            existing.setNineYTo10y(updatedEntity.getNineYTo10y());
            existing.setTenYTo15y(updatedEntity.getTenYTo15y());
            existing.setFifteenYTo20y(updatedEntity.getFifteenYTo20y());
            existing.setTwentyYAbove(updatedEntity.getTwentyYAbove());
            existing.setNonMaturing(updatedEntity.getNonMaturing());
            // Final details
            existing.setReportSubmitDate(updatedEntity.getReportSubmitDate());
            existing.setModifyTime(new Date());// track update time
            

            List<String> ignoreFields = Arrays.asList("createUser", "modifyUser", "delFlg","modifyTime");

			Map<String, String> changes = new LinkedHashMap<>();

			for (Field field : RT_Liquidity_Risk_Data_Template.class.getDeclaredFields()) {
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
			
            LiquidityRiskDataRepository.save(existing);

			 System.out.println("changes : "+changes);

		        // Audit only if any field was changed
		        if (!changes.isEmpty()) {
		        	auditService.createBusinessAudit(
		        			String.valueOf(updatedEntity.getSlno()),           // Unique ID
		                "MODIFY",                             // Action
		                "LIQUIDITY_RISK_DATA_EDIT_SCREEN",                  // Screen name
		                changes,                              // Changed fields map
		                "BCBUAE_LIQUIDITY_RISK_DATA_TEMPLATE"              // Table name
		            );
		        }
		        
            return true;
        } else {
            return false;
        }
    }
    public byte[] generateLiquidityDataExcel(Date Report_date) throws Exception {
        logger.info("Service: Starting Liquidity Risk Excel generation process in memory.");

        List<RT_Liquidity_Risk_Data_Template> dataList = LiquidityRiskDataRepository.getLiquiditylist(Report_date);
        if (dataList.isEmpty()) {
            logger.warn("Service: No data found. Returning empty byte array.");
            return new byte[0];
        }

        String templateDir = env.getProperty("output.exportpathtemp");
        String templateFileName = "CBUAE_Liquidity Risk_Data_Template.xlsx";
        System.out.println("Template Dir = [" + templateDir + "]");
        Path templatePath = Paths.get(templateDir, templateFileName);
        logger.info("Service: Template path - {}", templatePath.toAbsolutePath());

        if (!Files.exists(templatePath)) throw new FileNotFoundException("Template not found at: " + templatePath.toAbsolutePath());
        if (!Files.isReadable(templatePath)) throw new SecurityException("Template not readable: " + templatePath.toAbsolutePath());

        try (InputStream templateInputStream = Files.newInputStream(templatePath);
             Workbook workbook = WorkbookFactory.create(templateInputStream);
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            Sheet sheet = findSheet(workbook, LIQUIDITY_GAP_SHEET_NAME);
            if (sheet == null) {
                throw new FileNotFoundException("Sheet '" + LIQUIDITY_GAP_SHEET_NAME
                        + "' was not found in template: " + templatePath.toAbsolutePath());
            }
            int liquidityGapIndex = workbook.getSheetIndex(sheet);
            workbook.setActiveSheet(liquidityGapIndex);
            workbook.setSelectedTab(liquidityGapIndex);
            logger.info("Service: Writing Liquidity Risk data to sheet '{}' (index {}).", sheet.getSheetName(),
                    liquidityGapIndex);

            List<RT_Liquidity_Risk_Data_Template> aedList = new ArrayList<>();
            List<RT_Liquidity_Risk_Data_Template> usdList = new ArrayList<>();
            partitionByInstrumentCurrency(dataList, aedList, usdList);
            logger.info("Service: Liquidity Gap split - AED rows {}, USD rows {}.", aedList.size(), usdList.size());

            RowSnapshot headerSnapshot = snapshotRow(sheet, AED_HEADER_ROW);
            RowSnapshot dataTemplateSnapshot = snapshotRow(sheet, TEMPLATE_DATA_ROW);
            RowSnapshot emptyRowSnapshot = snapshotRow(sheet, TEMPLATE_EMPTY_ROW);
            int eurHeaderRow = findNextSectionHeaderRow(sheet);
            RowSnapshot eurHeaderSnapshot = snapshotRow(sheet, eurHeaderRow);
            int templateExcelRow = TEMPLATE_DATA_ROW + 1;

            int nextRow = TEMPLATE_DATA_ROW;
            nextRow = writeRecordsFromTemplate(sheet, nextRow, aedList, dataTemplateSnapshot, templateExcelRow);
            nextRow = pasteEmptyRows(sheet, emptyRowSnapshot, nextRow, EMPTY_ROWS_AFTER_AED);

            if (!usdList.isEmpty()) {
                pasteRow(sheet, headerSnapshot, nextRow, AED_HEADER_ROW + 1);
                nextRow++;
                nextRow = writeRecordsFromTemplate(sheet, nextRow, usdList, dataTemplateSnapshot, templateExcelRow);
                nextRow = pasteEmptyRows(sheet, emptyRowSnapshot, nextRow, EMPTY_ROWS_AFTER_AED);
            }

            pasteRow(sheet, eurHeaderSnapshot, nextRow, eurHeaderRow + 1);
            workbook.setForceFormulaRecalculation(true);
            logger.info("Service: Liquidity Gap written through Excel row {} with separate AED/USD/EUR headers.",
                    nextRow + 1);
            workbook.write(out);
            logger.info("Service: Liquidity Risk Excel written to memory buffer ({} bytes).", out.size());
            return out.toByteArray();
        }
    }

	private void partitionByInstrumentCurrency(List<RT_Liquidity_Risk_Data_Template> dataList,
			List<RT_Liquidity_Risk_Data_Template> aedList, List<RT_Liquidity_Risk_Data_Template> usdList) {
		for (RT_Liquidity_Risk_Data_Template record : dataList) {
			if (isCurrency(record, "AED")) {
				aedList.add(record);
			} else if (isCurrency(record, "USD")) {
				usdList.add(record);
			}
		}
	}

	private boolean isCurrency(RT_Liquidity_Risk_Data_Template record, String currency) {
		String instrumentCurrency = record.getInstrumentCurrency();
		return instrumentCurrency != null && instrumentCurrency.trim().equalsIgnoreCase(currency);
	}

	private Sheet findSheet(Workbook workbook, String expectedName) {
		Sheet sheet = workbook.getSheet(expectedName);
		if (sheet != null) {
			return sheet;
		}
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			String name = workbook.getSheetName(i);
			if (name != null && name.trim().equalsIgnoreCase(expectedName)) {
				return workbook.getSheetAt(i);
			}
		}
		logger.warn("Service: Sheet '{}' not found. Available sheets: {}", expectedName, listSheetNames(workbook));
		return null;
	}

	private String listSheetNames(Workbook workbook) {
		StringBuilder names = new StringBuilder();
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			if (i > 0) {
				names.append(", ");
			}
			names.append(i).append(":").append(workbook.getSheetName(i));
		}
		return names.toString();
	}

	private int findNextSectionHeaderRow(Sheet sheet) {
		int headerCount = 0;
		int maxScan = Math.min(sheet.getLastRowNum(), 20);
		for (int r = 0; r <= maxScan; r++) {
			Row row = sheet.getRow(r);
			if (row == null) {
				continue;
			}
			Cell cell = row.getCell(0);
			if (cell == null || cell.getCellTypeEnum() != CellType.STRING) {
				continue;
			}
			String value = cell.getStringCellValue();
			if (value != null && "Date".equalsIgnoreCase(value.trim())) {
				headerCount++;
				if (headerCount == 3) {
					return r;
				}
			}
		}
		return 8;
	}

	private int writeRecordsFromTemplate(Sheet sheet, int startRow, List<RT_Liquidity_Risk_Data_Template> records,
			RowSnapshot dataTemplate, int templateExcelRow) {
		int rowIndex = startRow;
		for (RT_Liquidity_Risk_Data_Template record : records) {
			pasteRow(sheet, dataTemplate, rowIndex, templateExcelRow);
			fillTemplateInputColumns(sheet.getRow(rowIndex), record);
			rowIndex++;
		}
		return rowIndex;
	}

	private int pasteEmptyRows(Sheet sheet, RowSnapshot emptyRowSnapshot, int startRow, int count) {
		int rowIndex = startRow;
		for (int i = 0; i < count; i++) {
			clearRowValues(sheet, rowIndex);
			pasteRow(sheet, emptyRowSnapshot, rowIndex, TEMPLATE_EMPTY_ROW + 1);
			rowIndex++;
		}
		return rowIndex;
	}

	private RowSnapshot snapshotRow(Sheet sheet, int rowIndex) {
		RowSnapshot snapshot = new RowSnapshot();
		Row row = sheet.getRow(rowIndex);
		if (row == null) {
			return snapshot;
		}
		snapshot.height = row.getHeight();
		short lastCellNum = row.getLastCellNum();
		if (lastCellNum < 0) {
			return snapshot;
		}
		for (int i = 0; i < lastCellNum; i++) {
			Cell cell = row.getCell(i);
			if (cell == null) {
				continue;
			}
			CellSnapshot copied = new CellSnapshot();
			copied.column = i;
			copied.type = cell.getCellTypeEnum();
			copied.style = cell.getCellStyle();
			switch (copied.type) {
			case STRING:
				copied.stringValue = cell.getStringCellValue();
				break;
			case NUMERIC:
				copied.numericValue = cell.getNumericCellValue();
				break;
			case BOOLEAN:
				copied.booleanValue = cell.getBooleanCellValue();
				break;
			case FORMULA:
				copied.formula = cell.getCellFormula();
				break;
			case ERROR:
				copied.errorValue = cell.getErrorCellValue();
				break;
			default:
				break;
			}
			snapshot.cells.add(copied);
		}
		return snapshot;
	}

	private void pasteRow(Sheet sheet, RowSnapshot snapshot, int destRowNum, int sourceExcelRow) {
		Row destRow = sheet.getRow(destRowNum);
		if (destRow == null) {
			destRow = sheet.createRow(destRowNum);
		} else {
			clearRowValues(sheet, destRowNum);
			destRow = sheet.getRow(destRowNum);
			if (destRow == null) {
				destRow = sheet.createRow(destRowNum);
			}
		}
		destRow.setHeight(snapshot.height);
		int destExcelRow = destRowNum + 1;
		for (CellSnapshot copied : snapshot.cells) {
			Cell newCell = destRow.createCell(copied.column);
			if (copied.style != null) {
				newCell.setCellStyle(copied.style);
			}
			switch (copied.type) {
			case STRING:
				newCell.setCellValue(copied.stringValue == null ? "" : copied.stringValue);
				break;
			case NUMERIC:
				newCell.setCellValue(copied.numericValue);
				break;
			case BOOLEAN:
				newCell.setCellValue(copied.booleanValue);
				break;
			case FORMULA:
				if (copied.formula != null && !copied.formula.isEmpty()) {
					newCell.setCellFormula(adjustFormulaRow(copied.formula, sourceExcelRow, destExcelRow));
				}
				break;
			case BLANK:
				newCell.setCellType(CellType.BLANK);
				break;
			case ERROR:
				newCell.setCellErrorValue(copied.errorValue);
				break;
			default:
				break;
			}
		}
	}

	private void clearRowValues(Sheet sheet, int rowIndex) {
		Row row = sheet.getRow(rowIndex);
		if (row == null) {
			return;
		}
		short lastCellNum = row.getLastCellNum();
		if (lastCellNum < 0) {
			return;
		}
		for (int i = lastCellNum - 1; i >= 0; i--) {
			Cell cell = row.getCell(i);
			if (cell != null) {
				row.removeCell(cell);
			}
		}
	}

	private String adjustFormulaRow(String formula, int fromExcelRow, int toExcelRow) {
		if (formula == null || fromExcelRow == toExcelRow) {
			return formula;
		}
		return formula.replaceAll("(\\$?[A-Z]{1,3})(\\$?)" + fromExcelRow + "(?!\\d)", "$1$2" + toExcelRow);
	}

	private void fillTemplateInputColumns(Row row, RT_Liquidity_Risk_Data_Template record) {
		setDateValue(row, 0, record.getDataDate());
		setStringValue(row, 1, record.getBankName());
		setStringValue(row, 2, record.getHeadOfficeSubsidiary());
		setStringValue(row, 7, record.getGlLevel1());
		setStringValue(row, 8, record.getGlLevel2());
		setStringValue(row, 9, record.getGlLevel3());
		setStringValue(row, 10, record.getOptionType());
		setStringValue(row, 11, record.getRateType());
		setStringValue(row, 12, record.getReferenceRate());
		setStringValue(row, 13, record.getInstrumentCurrency());
		setNumberValue(row, 15, record.getOvernight());
		setNumberValue(row, 16, record.getOnTo1m());
		setNumberValue(row, 17, record.getOneMTo3m());
		setNumberValue(row, 18, record.getThreeMTo6m());
		setNumberValue(row, 19, record.getSixMTo9m());
		setNumberValue(row, 20, record.getNineMTo1y());
		setNumberValue(row, 21, record.getOneYTo1_5y());
		setNumberValue(row, 22, record.getOne5yTo2y());
		setNumberValue(row, 23, record.getTwoYTo3y());
		setNumberValue(row, 24, record.getThreeYTo4y());
		setNumberValue(row, 25, record.getFourYTo5y());
		setNumberValue(row, 26, record.getFiveYTo6y());
		setNumberValue(row, 27, record.getSixYTo7y());
		setNumberValue(row, 28, record.getSevenYTo8y());
		setNumberValue(row, 29, record.getEightYTo9y());
		setNumberValue(row, 30, record.getNineYTo10y());
		setNumberValue(row, 31, record.getTenYTo15y());
		setNumberValue(row, 32, record.getFifteenYTo20y());
		setNumberValue(row, 33, record.getTwentyYAbove());
		setNumberValue(row, 34, record.getNonMaturing());
	}

	private Cell ensureCell(Row row, int column) {
		Cell cell = row.getCell(column);
		if (cell == null) {
			cell = row.createCell(column);
		}
		return cell;
	}

	private void setStringValue(Row row, int column, String value) {
		ensureCell(row, column).setCellValue(value != null ? value : "");
	}

	private void setDateValue(Row row, int column, Date value) {
		Cell cell = ensureCell(row, column);
		if (value != null) {
			cell.setCellValue(value);
		} else {
			cell.setCellValue("");
		}
	}

	private void setNumberValue(Row row, int column, java.math.BigDecimal value) {
		ensureCell(row, column).setCellValue(value != null ? value.doubleValue() : 0.0);
	}

	private static final class RowSnapshot {
		private short height;
		private final List<CellSnapshot> cells = new ArrayList<CellSnapshot>();
	}

	private static final class CellSnapshot {
		private int column;
		private CellType type;
		private CellStyle style;
		private String stringValue;
		private double numericValue;
		private boolean booleanValue;
		private String formula;
		private byte errorValue;
	}

}
