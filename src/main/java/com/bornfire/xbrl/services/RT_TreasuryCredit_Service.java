package com.bornfire.xbrl.services;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.bornfire.xbrl.entities.RT_RepoDataTemplate;
import com.bornfire.xbrl.entities.RT_TreasuryCreditEntity;
import com.bornfire.xbrl.entities.RT_TreasuryCreditRepo;

@Service
public class RT_TreasuryCredit_Service {

	private static final Logger logger = LoggerFactory.getLogger(RT_TreasuryCredit_Service.class);

	/**
	 * Grey / formula columns on CBUAE Treasury Credit "Data" sheet (0-based).
	 * E-H: Bank Symbol / Islamic / Local-Foreign / Tiering (VLOOKUP)
	 * L: Final Rating CBUAE (IFNA/VLOOKUP) — Data!L4
	 * N: CBUAE Geographical Zone (VLOOKUP)
	 * R,U,X,AA,AD,AG,AJ,AM,AP,AS: utilization %
	 * AT-AW: Treasury limit / exposure totals
	 */
	private static final Set<Integer> AUTOMATIC_FORMULA_COLUMNS = new HashSet<Integer>(
			Arrays.asList(4, 5, 6, 7, 11, 13, 17, 20, 23, 26, 29, 32, 35, 38, 41, 44, 45, 46, 47, 48));
	
    @Autowired
    RT_TreasuryCreditRepo treasuryRepo;

    @Autowired
    private Environment env;
	 
		@Autowired
		AuditService auditService;


    // Update existing record
    public boolean updateTreasuryCredit(RT_TreasuryCreditEntity updatedEntity) {
        Optional<RT_TreasuryCreditEntity> existingOpt = treasuryRepo.findById(updatedEntity.getSlNo());
        
        if (existingOpt.isPresent()) {
            RT_TreasuryCreditEntity existing = existingOpt.get();           

            RT_TreasuryCreditEntity dbUser = new RT_TreasuryCreditEntity();
    		org.springframework.beans.BeanUtils.copyProperties(existing, dbUser);
    		
            // Basic Information
            existing.setReportDate(updatedEntity.getReportDate());
            existing.setBankName(updatedEntity.getBankName());
            existing.setHeadOfficeSubsidiary(updatedEntity.getHeadOfficeSubsidiary());
            existing.setSubsidiary(updatedEntity.getSubsidiary());
            existing.setBankSymbol(updatedEntity.getBankSymbol());
            existing.setConventionalIslamic(updatedEntity.getConventionalIslamic());
            existing.setLocalForeign(updatedEntity.getLocalForeign());
            existing.setCbuaeTiering(updatedEntity.getCbuaeTiering());
            // Counterparty Info
            existing.setCounterpartyName(updatedEntity.getCounterpartyName());
            existing.setCounterpartyIntRef(updatedEntity.getCounterpartyIntRef());
            existing.setCounterpartyRiskRating(updatedEntity.getCounterpartyRiskRating());
            existing.setFinalRatingCbuae(updatedEntity.getFinalRatingCbuae());
            existing.setCountryOfRisk(updatedEntity.getCountryOfRisk());
            existing.setCbuaeGeographicalZone(updatedEntity.getCbuaeGeographicalZone());
            existing.setCounterpartyType(updatedEntity.getCounterpartyType());

            // MM
            existing.setLimitAedMoneymarket(updatedEntity.getLimitAedMoneymarket());
            existing.setUtilizationAedMoneymarket(updatedEntity.getUtilizationAedMoneymarket());
            existing.setMoneymarketPercent(updatedEntity.getMoneymarketPercent());

            // Repo
            existing.setLimitAedRepo(updatedEntity.getLimitAedRepo());
            existing.setUtilizationAedRepo(updatedEntity.getUtilizationAedRepo());
            existing.setRepoPercent(updatedEntity.getRepoPercent());

            // Bonds
            existing.setLimitAedBonds(updatedEntity.getLimitAedBonds());
            existing.setUtilizationAedBonds(updatedEntity.getUtilizationAedBonds());
            existing.setBondsPercent(updatedEntity.getBondsPercent());

            // Credit
            existing.setLimitAedCredit(updatedEntity.getLimitAedCredit());
            existing.setUtilizationAedCredit(updatedEntity.getUtilizationAedCredit());
            existing.setCreditPercent(updatedEntity.getCreditPercent());

            // Other
            existing.setLimitAedOther(updatedEntity.getLimitAedOther());
            existing.setUtilizationAedOther(updatedEntity.getUtilizationAedOther());
            existing.setOtherPercent(updatedEntity.getOtherPercent());

            // Nostro
            existing.setLimitAedNostro(updatedEntity.getLimitAedNostro());
            existing.setUtilizationAedNostro(updatedEntity.getUtilizationAedNostro());
            existing.setNostroPercent(updatedEntity.getNostroPercent());

            // Derivatives
            existing.setLimitAedDerivatives(updatedEntity.getLimitAedDerivatives());
            existing.setUtilizationAedDerivatives(updatedEntity.getUtilizationAedDerivatives());
            existing.setDerivativesPercent(updatedEntity.getDerivativesPercent());

            // FX
            existing.setLimitAedFxsettlement(updatedEntity.getLimitAedFxsettlement());
            existing.setUtilizationAedFxsettlement(updatedEntity.getUtilizationAedFxsettlement());
            existing.setFxsettlementPercent(updatedEntity.getFxsettlementPercent());

            // Bond Settlement
            existing.setLimitAedBondsettlement(updatedEntity.getLimitAedBondsettlement());
            existing.setUtilizationAedBondsettlement(updatedEntity.getUtilizationAedBondsettlement());
            existing.setBondsettlementPercent(updatedEntity.getBondsettlementPercent());

            // Overall Treasury
            existing.setTreasuryLmtAed(updatedEntity.getTreasuryLmtAed());
            existing.setTreasuryLmt(updatedEntity.getTreasuryLmt());

            // Exposure
            existing.setExposureAed(updatedEntity.getExposureAed());
            existing.setExposure(updatedEntity.getExposure());

            // Final details
            existing.setReportSubmitDate(updatedEntity.getReportSubmitDate());
            existing.setModifyTime(new Date());// track update time
            


            List<String> ignoreFields = Arrays.asList("createUser", "modifyUser", "delFlg","modifyTime");

			Map<String, String> changes = new LinkedHashMap<>();

			for (Field field : RT_TreasuryCreditEntity.class.getDeclaredFields()) {
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
			

            treasuryRepo.save(existing);
            
            System.out.println("changes : "+changes);

	        // Audit only if any field was changed
	        if (!changes.isEmpty()) {
	        	auditService.createBusinessAudit(
	        			String.valueOf(updatedEntity.getSlNo()),           // Unique ID
	                "MODIFY",                             // Action
	                "TREASURY_CREDIT_LIMIT_EDIT_EDIT_SCREEN",                  // Screen name
	                changes,                              // Changed fields map
	                "BCBUAE_TREASURY_CRE_LMT_MANAGEMENT"              // Table name
	            );
	        }
	        
            return true;
        } else {
            return false;
        }
    }

    // Export Excel from DB data   
	/*
	 * public File generateTreasuryExcel() { File outputFile = null;
	 */
        

        public byte[] generateTreasuryExcel(Date Report_date) throws Exception {
            logger.info("Service: Starting Treasury Credit Excel generation process in memory.");

            List<RT_TreasuryCreditEntity> dataList = treasuryRepo.getTClist(Report_date);

            if (dataList.isEmpty()) {
                logger.warn("Service: No data found. Returning empty byte array.");
                return new byte[0];
            }

            String templateDir = env.getProperty("output.exportpathtemp");
            String templateFileName = "CBUAE_Treasury_Credit_Limit_Management_Data_Template.xlsx";
            Path templatePath = Paths.get(templateDir, templateFileName);

            logger.info("Service: Template path - {}", templatePath.toAbsolutePath());

            if (!Files.exists(templatePath)) {
                throw new FileNotFoundException("Template not found at: " + templatePath.toAbsolutePath());
            }
            if (!Files.isReadable(templatePath)) {
                throw new SecurityException("Template not readable: " + templatePath.toAbsolutePath());
            }

    		try (InputStream templateInputStream = Files.newInputStream(templatePath);
    				Workbook workbook = WorkbookFactory.create(templateInputStream);
    				ByteArrayOutputStream out = new ByteArrayOutputStream()) {

    			Sheet sheet = workbook.getSheet("Data");
    			if (sheet == null) {
    				sheet = workbook.getSheetAt(2);
    			}

    			CreationHelper createHelper = workbook.getCreationHelper();

    			CellStyle dateStyle = workbook.createCellStyle();
    			dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
    			dateStyle.setBorderBottom(BorderStyle.THIN);
    			dateStyle.setBorderTop(BorderStyle.THIN);
    			dateStyle.setBorderLeft(BorderStyle.THIN);
    			dateStyle.setBorderRight(BorderStyle.THIN);

    			CellStyle textStyle = workbook.createCellStyle();
    			textStyle.setBorderBottom(BorderStyle.THIN);
    			textStyle.setBorderTop(BorderStyle.THIN);
    			textStyle.setBorderLeft(BorderStyle.THIN);
    			textStyle.setBorderRight(BorderStyle.THIN);

    			CellStyle numberStyle = workbook.createCellStyle();
    			numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("#,##0.00"));
    			numberStyle.setBorderBottom(BorderStyle.THIN);
    			numberStyle.setBorderTop(BorderStyle.THIN);
    			numberStyle.setBorderLeft(BorderStyle.THIN);
    			numberStyle.setBorderRight(BorderStyle.THIN);

    			int startRow = 3;
    			Row templateRow = sheet.getRow(startRow);
    			Set<Integer> automaticColumns = detectAutomaticColumns(templateRow);
    			Map<Integer, String> templateFormulas = snapshotFormulas(templateRow, automaticColumns);
    			int templateExcelRow = startRow + 1;

    			for (int i = 0; i < dataList.size(); i++) {
    			    RT_TreasuryCreditEntity record = dataList.get(i);
    			    int rowIndex = startRow + i;
    			    Row row = sheet.getRow(rowIndex);
    			    if (row == null) {
    			        row = sheet.createRow(rowIndex);
    			    }

    			    copyAutomaticFormulaCells(templateRow, row, automaticColumns, templateFormulas, templateExcelRow,
    			            rowIndex + 1);

    			    setDateValue(row, 0, record.getReportDate(), dateStyle, automaticColumns);
    			    setTextValue(row, 1, record.getBankName(), textStyle, automaticColumns);
    			    setTextValue(row, 2, record.getHeadOfficeSubsidiary(), textStyle, automaticColumns);
    			    setTextValue(row, 3, record.getSubsidiary(), textStyle, automaticColumns);
    			    setTextValue(row, 8, record.getCounterpartyName(), textStyle, automaticColumns);
    			    setTextValue(row, 9, record.getCounterpartyIntRef(), textStyle, automaticColumns);
    			    setTextValue(row, 10, record.getCounterpartyRiskRating(), textStyle, automaticColumns);
    			    setTextValue(row, 12, record.getCountryOfRisk(), textStyle, automaticColumns);
    			    setTextValue(row, 14, record.getCounterpartyType(), textStyle, automaticColumns);
    			    setNumberValue(row, 15, record.getLimitAedMoneymarket(), numberStyle, automaticColumns);
    			    setNumberValue(row, 16, record.getUtilizationAedMoneymarket(), numberStyle, automaticColumns);
    			    setNumberValue(row, 18, record.getLimitAedRepo(), numberStyle, automaticColumns);
    			    setNumberValue(row, 19, record.getUtilizationAedRepo(), numberStyle, automaticColumns);
    			    setNumberValue(row, 21, record.getLimitAedBonds(), numberStyle, automaticColumns);
    			    setNumberValue(row, 22, record.getUtilizationAedBonds(), numberStyle, automaticColumns);
    			    setNumberValue(row, 24, record.getLimitAedEquity(), numberStyle, automaticColumns);
    			    setNumberValue(row, 25, record.getUtilizationAedEquity(), numberStyle, automaticColumns);
    			    setNumberValue(row, 27, record.getLimitAedCredit(), numberStyle, automaticColumns);
    			    setNumberValue(row, 28, record.getUtilizationAedCredit(), numberStyle, automaticColumns);
    			    setNumberValue(row, 30, record.getLimitAedOther(), numberStyle, automaticColumns);
    			    setNumberValue(row, 31, record.getUtilizationAedOther(), numberStyle, automaticColumns);
    			    setNumberValue(row, 33, record.getLimitAedNostro(), numberStyle, automaticColumns);
    			    setNumberValue(row, 34, record.getUtilizationAedNostro(), numberStyle, automaticColumns);
    			    setNumberValue(row, 36, record.getLimitAedDerivatives(), numberStyle, automaticColumns);
    			    setNumberValue(row, 37, record.getUtilizationAedDerivatives(), numberStyle, automaticColumns);
    			    setNumberValue(row, 39, record.getLimitAedFxsettlement(), numberStyle, automaticColumns);
    			    setNumberValue(row, 40, record.getUtilizationAedFxsettlement(), numberStyle, automaticColumns);
    			    setNumberValue(row, 42, record.getLimitAedBondsettlement(), numberStyle, automaticColumns);
    			    setNumberValue(row, 43, record.getUtilizationAedBondsettlement(), numberStyle, automaticColumns);
    			}

    			workbook.setForceFormulaRecalculation(true);
                workbook.write(out);

				/*
				 * logger.info("Service: Excel file written successfully. Size: {} bytes",
				 * out.size()); return out.toByteArray();
				 */

                String finalPath = env.getProperty("output.exportpathfinal"); // e.g. finaltemp path
                File outputFile = new File(finalPath + "CBUAE_Treasury_Credit_Limit_Management_Data_Template.xlsx");
                try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                    fos.write(out.toByteArray());
                    logger.info("Service: Excel also saved to file: {}", outputFile.getAbsolutePath());
                }

                logger.info("Service: Treasury Credit Excel data successfully written to memory buffer ({} bytes).", out.size());
                return out.toByteArray();

            }
        }

    private Set<Integer> detectAutomaticColumns(Row templateRow) {
        Set<Integer> automatic = new HashSet<Integer>(AUTOMATIC_FORMULA_COLUMNS);
        if (templateRow == null) {
            return automatic;
        }
        short lastCellNum = templateRow.getLastCellNum();
        if (lastCellNum < 0) {
            return automatic;
        }
        for (int col = 0; col < lastCellNum; col++) {
            Cell cell = templateRow.getCell(col);
            if (cell != null && cell.getCellTypeEnum() == CellType.FORMULA) {
                automatic.add(col);
            }
        }
        return automatic;
    }

    private Map<Integer, String> snapshotFormulas(Row templateRow, Set<Integer> automaticColumns) {
        Map<Integer, String> formulas = new LinkedHashMap<Integer, String>();
        if (templateRow == null) {
            return formulas;
        }
        for (Integer col : automaticColumns) {
            Cell cell = templateRow.getCell(col);
            if (cell != null && cell.getCellTypeEnum() == CellType.FORMULA) {
                formulas.put(col, cell.getCellFormula());
            }
        }
        return formulas;
    }

    private void copyAutomaticFormulaCells(Row templateRow, Row destRow, Set<Integer> automaticColumns,
            Map<Integer, String> templateFormulas, int templateExcelRow, int destExcelRow) {
        for (Integer col : automaticColumns) {
            Cell destCell = destRow.getCell(col);
            if (destCell == null) {
                destCell = destRow.createCell(col);
            } else if (destCell.getCellTypeEnum() == CellType.FORMULA && templateExcelRow == destExcelRow) {
                continue;
            }
            Cell templateCell = templateRow == null ? null : templateRow.getCell(col);
            if (templateCell != null && templateCell.getCellStyle() != null) {
                destCell.setCellStyle(templateCell.getCellStyle());
            }
            String formula = templateFormulas.get(col);
            if (formula != null && !formula.trim().isEmpty()) {
                destCell.setCellFormula(adjustFormulaRow(formula, templateExcelRow, destExcelRow));
            }
        }
    }

    private String adjustFormulaRow(String formula, int fromExcelRow, int toExcelRow) {
        if (formula == null || fromExcelRow == toExcelRow) {
            return formula;
        }
        return formula.replaceAll("(\\$?[A-Z]{1,3})(\\$?)" + fromExcelRow + "(?!\\d)", "$1$2" + toExcelRow);
    }

    private boolean skipAutomaticCell(Set<Integer> automaticColumns, Row row, int col) {
        if (automaticColumns != null && automaticColumns.contains(col)) {
            return true;
        }
        Cell existing = row.getCell(col);
        return existing != null && existing.getCellTypeEnum() == CellType.FORMULA;
    }

    private Cell writableCell(Row row, int col, Set<Integer> automaticColumns) {
        if (skipAutomaticCell(automaticColumns, row, col)) {
            return null;
        }
        Cell cell = row.getCell(col);
        if (cell == null) {
            cell = row.createCell(col);
        }
        return cell;
    }

    private void setDateValue(Row row, int col, Date value, CellStyle dateStyle, Set<Integer> automaticColumns) {
        Cell cell = writableCell(row, col, automaticColumns);
        if (cell == null) {
            return;
        }
        if (dateStyle != null) {
            cell.setCellStyle(dateStyle);
        }
        if (value != null) {
            cell.setCellValue(value);
        } else {
            cell.setCellValue("");
        }
    }

    private void setTextValue(Row row, int col, String value, CellStyle textStyle, Set<Integer> automaticColumns) {
        Cell cell = writableCell(row, col, automaticColumns);
        if (cell == null) {
            return;
        }
        if (textStyle != null) {
            cell.setCellStyle(textStyle);
        }
        cell.setCellValue(value == null ? "" : value);
    }

    private void setNumberValue(Row row, int col, Number value, CellStyle numberStyle, Set<Integer> automaticColumns) {
        Cell cell = writableCell(row, col, automaticColumns);
        if (cell == null) {
            return;
        }
        if (numberStyle != null) {
            cell.setCellStyle(numberStyle);
        }
        cell.setCellValue(value == null ? 0 : value.doubleValue());
    }

}
