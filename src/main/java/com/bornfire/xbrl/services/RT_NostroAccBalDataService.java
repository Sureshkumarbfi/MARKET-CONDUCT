package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.bornfire.xbrl.entities.RT_DataControl;
import com.bornfire.xbrl.entities.RT_NostroAccBalData;
import com.bornfire.xbrl.entities.RT_NostroAccBalDataRepository;

@Service
public class RT_NostroAccBalDataService {

	@Autowired
	RT_NostroAccBalDataRepository nostroAccBalRepo;

	@Autowired
	AuditService auditservice;
	
	@Autowired
	private Environment env;

	public boolean updateNostro(RT_NostroAccBalData updatedData) {
		System.out.println("Report Date : "+updatedData.getReportDate()+" Act no : "+updatedData.getAccountNo());
	    RT_NostroAccBalData existingOpt = nostroAccBalRepo.getbyAcctNoReportDate(updatedData.getReportDate(),updatedData.getAccountNo());

	    if (!existingOpt.equals(null)) {
	        RT_NostroAccBalData existing = existingOpt;
	        
	        RT_NostroAccBalData dbUser = new RT_NostroAccBalData();
			org.springframework.beans.BeanUtils.copyProperties(existing, dbUser);
			
	        /*        Map<String, String> changes = new LinkedHashMap<>();

	        // Compare fields before updating and track changes
	        if (!Objects.equals(existing.getBankName(), updatedData.getBankName())) {
	            changes.put("bankName", "OldValue: " + existing.getBankName() + ", NewValue: " + updatedData.getBankName());
	        }

	        if (!Objects.equals(existing.getHeadOfficeSubsidiary(), updatedData.getHeadOfficeSubsidiary())) {
	            changes.put("headOfficeSubsidiary", "OldValue: " + existing.getHeadOfficeSubsidiary() + ", NewValue: " + updatedData.getHeadOfficeSubsidiary());
	        }

	        if (!Objects.equals(existing.getSubsidiary(), updatedData.getSubsidiary())) {
	            changes.put("subsidiary", "OldValue: " + existing.getSubsidiary() + ", NewValue: " + updatedData.getSubsidiary());
	        }

	        if (!Objects.equals(existing.getBankSymbol(), updatedData.getBankSymbol())) {
	            changes.put("bankSymbol", "OldValue: " + existing.getBankSymbol() + ", NewValue: " + updatedData.getBankSymbol());
	        }

	        if (!Objects.equals(existing.getConventionalIslamic(), updatedData.getConventionalIslamic())) {
	            changes.put("conventionalIslamic", "OldValue: " + existing.getConventionalIslamic() + ", NewValue: " + updatedData.getConventionalIslamic());
	        }

	        if (!Objects.equals(existing.getLocalForeign(), updatedData.getLocalForeign())) {
	            changes.put("localForeign", "OldValue: " + existing.getLocalForeign() + ", NewValue: " + updatedData.getLocalForeign());
	        }

	        if (!Objects.equals(existing.getCbuaeTiering(), updatedData.getCbuaeTiering())) {
	            changes.put("cbuaeTiering", "OldValue: " + existing.getCbuaeTiering() + ", NewValue: " + updatedData.getCbuaeTiering());
	        }

	        if (!Objects.equals(existing.getCounterpartyNostroAccount(), updatedData.getCounterpartyNostroAccount())) {
	            changes.put("counterpartyNostroAccount", "OldValue: " + existing.getCounterpartyNostroAccount() + ", NewValue: " + updatedData.getCounterpartyNostroAccount());
	        }

	        if (!Objects.equals(existing.getFinalRatingBanks(), updatedData.getFinalRatingBanks())) {
	            changes.put("finalRatingBanks", "OldValue: " + existing.getFinalRatingBanks() + ", NewValue: " + updatedData.getFinalRatingBanks());
	        }

	        if (!Objects.equals(existing.getFinalRatingCbuae(), updatedData.getFinalRatingCbuae())) {
	            changes.put("finalRatingCbuae", "OldValue: " + existing.getFinalRatingCbuae() + ", NewValue: " + updatedData.getFinalRatingCbuae());
	        }

	        if (!Objects.equals(existing.getCountryOfRisk(), updatedData.getCountryOfRisk())) {
	            changes.put("countryOfRisk", "OldValue: " + existing.getCountryOfRisk() + ", NewValue: " + updatedData.getCountryOfRisk());
	        }

	        if (!Objects.equals(existing.getCbuaeGeographicalZone(), updatedData.getCbuaeGeographicalZone())) {
	            changes.put("cbuaeGeographicalZone", "OldValue: " + existing.getCbuaeGeographicalZone() + ", NewValue: " + updatedData.getCbuaeGeographicalZone());
	        }

	        if (!Objects.equals(existing.getCurrency(), updatedData.getCurrency())) {
	            changes.put("currency", "OldValue: " + existing.getCurrency() + ", NewValue: " + updatedData.getCurrency());
	        }

	        if (!Objects.equals(existing.getCounterpartySettlementDate(), updatedData.getCounterpartySettlementDate())) {
	            changes.put("counterpartySettlementDate", "OldValue: " + existing.getCounterpartySettlementDate() + ", NewValue: " + updatedData.getCounterpartySettlementDate());
	        }

	        if (!Objects.equals(existing.getCounterpartyBalance(), updatedData.getCounterpartyBalance())) {
	            changes.put("counterpartyBalance", "OldValue: " + existing.getCounterpartyBalance() + ", NewValue: " + updatedData.getCounterpartyBalance());
	        }

	        if (!Objects.equals(existing.getCounterpartyBalanceAed(), updatedData.getCounterpartyBalanceAed())) {
	            changes.put("counterpartyBalanceAed", "OldValue: " + existing.getCounterpartyBalanceAed() + ", NewValue: " + updatedData.getCounterpartyBalanceAed());
	        }

	        if (!Objects.equals(existing.getBankInternalSettlementDate(), updatedData.getBankInternalSettlementDate())) {
	            changes.put("bankInternalSettlementDate", "OldValue: " + existing.getBankInternalSettlementDate() + ", NewValue: " + updatedData.getBankInternalSettlementDate());
	        }

	        if (!Objects.equals(existing.getBankBalance(), updatedData.getBankBalance())) {
	            changes.put("bankBalance", "OldValue: " + existing.getBankBalance() + ", NewValue: " + updatedData.getBankBalance());
	        }

	        if (!Objects.equals(existing.getBankBalanceAed(), updatedData.getBankBalanceAed())) {
	            changes.put("bankBalanceAed", "OldValue: " + existing.getBankBalanceAed() + ", NewValue: " + updatedData.getBankBalanceAed());
	        }

	        if (!Objects.equals(existing.getGap(), updatedData.getGap())) {
	            changes.put("gap", "OldValue: " + existing.getGap() + ", NewValue: " + updatedData.getGap());
	        }

	        if (!Objects.equals(existing.getReportSubmitDate(), updatedData.getReportSubmitDate())) {
	            changes.put("reportSubmitDate", "OldValue: " + existing.getReportSubmitDate() + ", NewValue: " + updatedData.getReportSubmitDate());
	        }
*/
	        // Update all fields (as you originally had)
	        existing.setBankName(updatedData.getBankName());
	        existing.setHeadOfficeSubsidiary(updatedData.getHeadOfficeSubsidiary());
	        existing.setSubsidiary(updatedData.getSubsidiary());
	        existing.setBankSymbol(updatedData.getBankSymbol());
	        existing.setConventionalIslamic(updatedData.getConventionalIslamic());
	        existing.setLocalForeign(updatedData.getLocalForeign());
	        existing.setCbuaeTiering(updatedData.getCbuaeTiering());
	        existing.setCounterpartyNostroAccount(updatedData.getCounterpartyNostroAccount());
	        existing.setFinalRatingBanks(updatedData.getFinalRatingBanks());
	        existing.setFinalRatingCbuae(updatedData.getFinalRatingCbuae());
	        existing.setCountryOfRisk(updatedData.getCountryOfRisk());
	        existing.setCbuaeGeographicalZone(updatedData.getCbuaeGeographicalZone());
	        existing.setCurrency(updatedData.getCurrency());
	        existing.setCounterpartySettlementDate(updatedData.getCounterpartySettlementDate());
	        existing.setCounterpartyBalance(updatedData.getCounterpartyBalance());
	        existing.setCounterpartyBalanceAed(updatedData.getCounterpartyBalanceAed());
	        existing.setBankInternalSettlementDate(updatedData.getBankInternalSettlementDate());
	        existing.setBankBalance(updatedData.getBankBalance());
	        existing.setBankBalanceAed(updatedData.getBankBalanceAed());
	        existing.setGap(updatedData.getGap());
	        existing.setReportSubmitDate(updatedData.getReportSubmitDate());
	        

			List<String> ignoreFields = Arrays.asList("createUser", "modifyUser", "delFlg");

			Map<String, String> changes = new LinkedHashMap<>();

			for (Field field : RT_NostroAccBalData.class.getDeclaredFields()) {
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
						}if (oldValue != null && newValue != null) {
			                try {
			                    BigDecimal oldNum = new BigDecimal(oldValue.toString());
			                    BigDecimal newNum = new BigDecimal(newValue.toString());			                    
			                    if (oldNum.compareTo(newNum) == 0) {
			                        continue; 
			                    }
			                } catch (NumberFormatException ignored) {
			                }
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
	        

	        // Save the data
	        nostroAccBalRepo.save(existing);
	        
	        System.out.println("changes : "+changes);

	        // Audit only if any field was changed
	        if (!changes.isEmpty()) {
	            auditservice.createBusinessAudit(
	                updatedData.getAccountNo(),           // Unique ID
	                "MODIFY",                             // Action
	                "NOSTRO_ACC_SCREEN",                  // Screen name
	                changes,                              // Changed fields map
	                "RT_NOSTRO_ACC_BAL_DATA"              // Table name
	            );
	        }

	        return true;
	    } else {
	        return false; // record not found
	    }
	}

	public File generateNostroExcel(Date Report_date) {
		File outputFile = null;

		try {
			List<Object[]> nostroList = nostroAccBalRepo.getnostrodatalistdata1(Report_date);
			File templateFile = new File(
					env.getProperty("output.exportpathtemp") + "CBUAE_Nostro Account_Balance_Data_Template.xlsx");
			Workbook workbook = WorkbookFactory.create(new FileInputStream(templateFile));
			Sheet sheet = workbook.getSheetAt(2);

			CreationHelper createHelper = workbook.getCreationHelper();
			CellStyle dateStyle = workbook.createCellStyle();
			dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

			int startRow = 4;

			if (!nostroList.isEmpty()) {
				for (int i = 0; i < nostroList.size(); i++) {
					Object[] data = nostroList.get(i);
					Row row = sheet.getRow(startRow + i);
					if (row == null)
						row = sheet.createRow(startRow + i);

					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

					// 0 - DATA_DATE
					Cell cell0 = row.getCell(0);
					if (cell0 == null)
						cell0 = row.createCell(0);
					if (data[0] != null && data[0] instanceof Date) {
						cell0.setCellValue(sdf.format((Date) data[0]));
					} else {
						cell0.setCellValue("");
					}

					// 1 - BANK_NAME
					Cell cell1 = row.getCell(1);
					if (cell1 == null)
						cell1 = row.createCell(1);
					cell1.setCellValue(data[1] == null ? "" : data[1].toString());

					// 2 - HEAD_OFFICE_SUBSIDIARY
					Cell cell2 = row.getCell(2);
					if (cell2 == null)
						cell2 = row.createCell(2);
					cell2.setCellValue(data[2] == null ? "" : data[2].toString());

					// 3 - SUBSIDIARY
					Cell cell3 = row.getCell(3);
					if (cell3 == null)
						cell3 = row.createCell(3);
					cell3.setCellValue(data[3] == null ? "" : data[3].toString());

					// 4 - BANK_SYMBOL
					Cell cell4 = row.getCell(4);
					if (cell4 == null)
						cell4 = row.createCell(4);
					cell4.setCellValue(data[4] == null ? "" : data[4].toString());

					// 5 - CONVENTIONAL_ISLAMIC
					Cell cell5 = row.getCell(5);
					if (cell5 == null)
						cell5 = row.createCell(5);
					cell5.setCellValue(data[5] == null ? "" : data[5].toString());

					// 6 - LOCAL_FOREIGN
					Cell cell6 = row.getCell(6);
					if (cell6 == null)
						cell6 = row.createCell(6);
					cell6.setCellValue(data[6] == null ? "" : data[6].toString());

					// 7 - CBUAE_TIERING
					Cell cell7 = row.getCell(7);
					if (cell7 == null)
						cell7 = row.createCell(7);
					cell7.setCellValue(data[7] == null ? "" : data[7].toString());

					// 8 - COUNTERPARTY_NOSTRO_ACCOUNT
					Cell cell8 = row.getCell(8);
					if (cell8 == null)
						cell8 = row.createCell(8);
					cell8.setCellValue(data[8] == null ? "" : data[8].toString());

					// 9 - FINAL_RATING_BANKS
					Cell cell9 = row.getCell(9);
					if (cell9 == null)
						cell9 = row.createCell(9);
					cell9.setCellValue(data[9] == null ? "" : data[9].toString());

					// 10 - FINAL_RATING_CBUAE
					Cell cell10 = row.getCell(10);
					if (cell10 == null)
						cell10 = row.createCell(10);
					cell10.setCellValue(data[10] == null ? "" : data[10].toString());

					// 11 - COUNTRY_OF_RISK
					Cell cell11 = row.getCell(11);
					if (cell11 == null)
						cell11 = row.createCell(11);
					cell11.setCellValue(data[11] == null ? "" : data[11].toString());

					// 12 - CBUAE_GEOGRAPHICAL_ZONE
					Cell cell12 = row.getCell(12);
					if (cell12 == null)
						cell12 = row.createCell(12);
					cell12.setCellValue(data[12] == null ? "" : data[12].toString());

					// 13 - CURRENCY
					Cell cell13 = row.getCell(13);
					if (cell13 == null)
						cell13 = row.createCell(13);
					cell13.setCellValue(data[13] == null ? "" : data[13].toString());

					// 14 - COUNTERPARTY_SETTLEMENT_DATE
					Cell cell14 = row.getCell(14);
					if (cell14 == null)
						cell14 = row.createCell(14);

					if (data[14] != null && data[14] instanceof Date) {
						cell14.setCellValue(sdf.format((Date) data[14]));
					} else {
						cell14.setCellValue("");
					}

					// 15 - COUNTERPARTY_BALANCE
					Cell cell15 = row.getCell(15);
					if (cell15 == null)
						cell15 = row.createCell(15);
					cell15.setCellValue(data[15] instanceof BigDecimal ? ((BigDecimal) data[15]).doubleValue() : 0);

					// 16 - COUNTERPARTY_BALANCE_AED
					Cell cell16 = row.getCell(16);
					if (cell16 == null)
						cell16 = row.createCell(16);
					cell16.setCellValue(data[16] instanceof BigDecimal ? ((BigDecimal) data[16]).doubleValue() : 0);

					// 17 - BANK_INTERNAL_SETTLEMENT_DATE
					Cell cell17 = row.getCell(17);
					if (cell17 == null)
						cell17 = row.createCell(17);

					if (data[17] != null && data[17] instanceof Date) {
						cell17.setCellValue(sdf.format((Date) data[17]));
					} else {
						cell17.setCellValue("");
					}

					// 18 - BANK_BALANCE
					Cell cell18 = row.getCell(18);
					if (cell18 == null)
						cell18 = row.createCell(18);
					cell18.setCellValue(data[18] instanceof BigDecimal ? ((BigDecimal) data[18]).doubleValue() : 0);

					// 19 - BANK_BALANCE_AED
					Cell cell19 = row.getCell(19);
					if (cell19 == null)
						cell19 = row.createCell(19);
					cell19.setCellValue(data[19] instanceof BigDecimal ? ((BigDecimal) data[19]).doubleValue() : 0);

					// 20 - ACCOUNT_NO
					Cell cell20 = row.getCell(20);
					if (cell20 == null)
						cell20 = row.createCell(20);
					cell20.setCellValue(data[20] == null ? "" : data[20].toString());

					// 21 - GAP
					Cell cell21 = row.getCell(21);
					if (cell21 == null)
						cell21 = row.createCell(21);
					cell21.setCellValue(data[21] instanceof BigDecimal ? ((BigDecimal) data[21]).doubleValue() : 0);
				}

				workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();

				outputFile = new File(env.getProperty("output.exportpathfinal") + "NostroAccBalance.xlsx");
				try (FileOutputStream fos = new FileOutputStream(outputFile)) {
					workbook.write(fos);
					System.out.println("Nostro Excel generated: " + outputFile.getAbsolutePath());
				}
				workbook.close();
			} else {
				System.out.println("codeNo Nostro Account Balance data found.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return outputFile;
	}
}
