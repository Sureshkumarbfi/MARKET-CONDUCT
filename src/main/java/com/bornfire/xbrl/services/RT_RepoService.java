package com.bornfire.xbrl.services;

import org.springframework.stereotype.Service;

import com.bornfire.xbrl.entities.RT_RepoDataTemplate;
import com.bornfire.xbrl.entities.RT_RepoDataTemplateRepository;
import com.bornfire.xbrl.entities.RT_TradeMarketRiskData;

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

import org.apache.poi.ss.usermodel.BorderStyle;
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


@Service
public class RT_RepoService {

	 @Autowired
	 RT_RepoDataTemplateRepository repoRepo;

	 @Autowired
	private Environment env;
	 
		@Autowired
		AuditService auditService;
	 
	    public boolean updateRepoData(RT_RepoDataTemplate newRepoData) {
	        Optional<RT_RepoDataTemplate> existingDataOpt = repoRepo.findById(newRepoData.getSlNo());

	        RT_RepoDataTemplate existing = existingDataOpt.get();

	        RT_RepoDataTemplate dbUser = new RT_RepoDataTemplate();
			org.springframework.beans.BeanUtils.copyProperties(existing, dbUser);
			
	        if (existingDataOpt.isPresent()) {
	            RT_RepoDataTemplate existingData = existingDataOpt.get();

	            existingData.setDataDate(newRepoData.getDataDate());
	            existingData.setBankName(newRepoData.getBankName());
	            existingData.setHeadOfficeSubsidiary(newRepoData.getHeadOfficeSubsidiary());
	            existingData.setSubsidiary(newRepoData.getSubsidiary());
	            existingData.setBankSymbol(newRepoData.getBankSymbol());
	            existingData.setConventionalIslamic(newRepoData.getConventionalIslamic());
	            existingData.setLocalForeign(newRepoData.getLocalForeign());
	            existingData.setCbuaeTiering(newRepoData.getCbuaeTiering());
	            existingData.setCounterpartyName(newRepoData.getCounterpartyName());
	            existingData.setCounterpartyInternalRef(newRepoData.getCounterpartyInternalRef());
	            existingData.setFinalRatingBanks(newRepoData.getFinalRatingBanks());
	            existingData.setFinalRatingCbuae(newRepoData.getFinalRatingCbuae());
	            existingData.setCountryOfRisk(newRepoData.getCountryOfRisk());
	            existingData.setCbuaeGeoZone(newRepoData.getCbuaeGeoZone());
	            existingData.setCbuaeInternalRef(newRepoData.getCbuaeInternalRef());
	            existingData.setTransactionType(newRepoData.getTransactionType());
	            existingData.setDealNo(newRepoData.getDealNo());
	            existingData.setRepoStartDate(newRepoData.getRepoStartDate());
	            existingData.setRepoMaturityDate(newRepoData.getRepoMaturityDate());
	            existingData.setInitialMaturity(newRepoData.getInitialMaturity());
	            existingData.setInitialMaturityRounded(newRepoData.getInitialMaturityRounded());
	            existingData.setInitialMaturityPeriod(newRepoData.getInitialMaturityPeriod());
	            existingData.setResidualMaturityDate(newRepoData.getResidualMaturityDate());
	            existingData.setMaturityPeriod(newRepoData.getMaturityPeriod());
	            existingData.setRepoCurrency(newRepoData.getRepoCurrency());
	            existingData.setUnderlyingSecurityIsin(newRepoData.getUnderlyingSecurityIsin());
	            existingData.setRehypothecationStatus(newRepoData.getRehypothecationStatus());
	            existingData.setSecurityCurrency(newRepoData.getSecurityCurrency());
	            existingData.setObligor(newRepoData.getObligor());
	            existingData.setIssuerType(newRepoData.getIssuerType());
	            existingData.setIndustry(newRepoData.getIndustry());
	            existingData.setSector(newRepoData.getSector());
	            existingData.setUnderlyingBondDetails(newRepoData.getUnderlyingBondDetails());
	            existingData.setSecurityFinalRating(newRepoData.getSecurityFinalRating());
	            existingData.setFinalSecurityRatingCbuae(newRepoData.getFinalSecurityRatingCbuae());
	            existingData.setSecurityCountryOfRisk(newRepoData.getSecurityCountryOfRisk());
	            existingData.setCbuaeGeoZone2(newRepoData.getCbuaeGeoZone2());
	            existingData.setBondSukukNominal(newRepoData.getBondSukukNominal());
	            existingData.setSecurityMaturityDate(newRepoData.getSecurityMaturityDate());
	            existingData.setSecurityResidualMaturity(newRepoData.getSecurityResidualMaturity());
	            existingData.setSecurityMaturityPeriod(newRepoData.getSecurityMaturityPeriod());
	            existingData.setGmraEffectiveHaircut(newRepoData.getGmraEffectiveHaircut());
	            existingData.setSecurityStartPrice(newRepoData.getSecurityStartPrice());
	            existingData.setSecurityStartCashAmount(newRepoData.getSecurityStartCashAmount());
	            existingData.setStartCashAmount(newRepoData.getStartCashAmount());
	            existingData.setInterestProfitRate(newRepoData.getInterestProfitRate());
	            existingData.setFixedRate(newRepoData.getFixedRate());
	            existingData.setFloatingRateType(newRepoData.getFloatingRateType());
	            existingData.setRepoMargin(newRepoData.getRepoMargin());
	            existingData.setInterestAccruals(newRepoData.getInterestAccruals());
	            existingData.setRepoValuation(newRepoData.getRepoValuation());
	            existingData.setDirtyPrice(newRepoData.getDirtyPrice());
	            existingData.setGmraCollateralMtm(newRepoData.getGmraCollateralMtm());
	            existingData.setMinTransferAmount(newRepoData.getMinTransferAmount());
	            existingData.setThreshold(newRepoData.getThreshold());
	            existingData.setMarginCallFreq(newRepoData.getMarginCallFreq());


	            List<String> ignoreFields = Arrays.asList("createUser", "modifyUser", "delFlg");

				Map<String, String> changes = new LinkedHashMap<>();

				for (Field field : RT_RepoDataTemplate.class.getDeclaredFields()) {
					field.setAccessible(true);
					try {
						Object oldValue = field.get(dbUser);
						Object newValue = field.get(existingData);
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
				
	            repoRepo.save(existingData);
	            

				 System.out.println("changes : "+changes);

			        // Audit only if any field was changed
			        if (!changes.isEmpty()) {
			        	auditService.createBusinessAudit(
			        			String.valueOf(newRepoData.getSlNo()),           // Unique ID
			                "MODIFY",                             // Action
			                "REPO_DATA_TEMPLATE_EDIT_SCREEN",                  // Screen name
			                changes,                              // Changed fields map
			                "BCBUAE_REPO_DATA_TEMPLATE"              // Table name
			            );
			        }
			        
	            return true;
	        }

	        return false;
	    }
	    
	    public File generateRepoExcel(Date Report_date) {
	        File outputFile = null;

	        try {
	            List<Object[]> repoList = repoRepo.getRepoDataList(Report_date);
	            File templateFile = new File(env.getProperty("output.exportpathtemp") + "CBUAE_Repo_Data_Template.xlsx");
	            Workbook workbook = WorkbookFactory.create(new FileInputStream(templateFile));
	            Sheet sheet = workbook.getSheetAt(3);

	            CreationHelper createHelper = workbook.getCreationHelper();
	            short dateFormat = createHelper.createDataFormat().getFormat("dd-MM-yyyy");

	            int startRow = 3;
	            System.out.println(" repoList.size()"+ repoList.size());

	            if (!repoList.isEmpty()) {
	                for (int i = 0; i < repoList.size(); i++) {
	                    Object[] data = repoList.get(i);
	                    System.out.println("data of object " +i+" is " +Arrays.toString(data) );
	                    Row row = sheet.getRow(startRow + i);
	                    if (row == null)
	                        row = sheet.createRow(startRow + i);

	                    for (int j = 0; j < data.length; j++) {
	                        Cell cell = row.getCell(j);
	                        if (cell == null)
	                            cell = row.createCell(j);

	                        Object value = data[j];

	                        // Preserve the original style from the cell
	                        CellStyle originalStyle = cell.getCellStyle();

	                        if (value instanceof Date) {
	                            cell.setCellValue((Date) value);
	                            // Clone original style and apply only date format
	                            CellStyle dateCellStyle = workbook.createCellStyle();
	                            dateCellStyle.cloneStyleFrom(originalStyle);
	                            dateCellStyle.setDataFormat(dateFormat);
	                            cell.setCellStyle(dateCellStyle);
	                        } else if (value instanceof BigDecimal) {
	                            cell.setCellValue(((BigDecimal) value).doubleValue());
	                            cell.setCellStyle(originalStyle);
	                        } else if (value instanceof Number) {
	                            cell.setCellValue(((Number) value).doubleValue());
	                            cell.setCellStyle(originalStyle);
	                        } else {
	                            cell.setCellValue(value != null ? value.toString() : "");
	                            cell.setCellStyle(originalStyle);
	                        }
	                    }
	                }
	                
	                workbook.setForceFormulaRecalculation(true);

	                workbook.getCreationHelper().createFormulaEvaluator();

	                outputFile = new File(env.getProperty("output.exportpathfinal") + "CBUAE_Repo_Data_Template.xlsx");
	                try (FileOutputStream fos = new FileOutputStream(outputFile)) {
	                    workbook.write(fos);
	                    System.out.println("Repo Excel generated: " + outputFile.getAbsolutePath());
	                }

	                workbook.close();
	            } else {
	                System.out.println("No Repo data found to export.");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return outputFile;
	    }


	    
}
