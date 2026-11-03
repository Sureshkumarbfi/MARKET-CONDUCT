
package com.bornfire.xbrl.services;


import org.apache.poi.ss.usermodel.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bornfire.xbrl.entities.ASL_Report_Entity;
import com.bornfire.xbrl.entities.ASL_Report_Rep;
import com.bornfire.xbrl.entities.MIS_SETTLEMENT_ENTITY;
import com.bornfire.xbrl.entities.MIS_SETTLEMENT_ENTITY_REP;
import com.bornfire.xbrl.entities.MIS_TREASURY_PLACEMENT_ENTITY;
import com.bornfire.xbrl.entities.Mis_treasury_placement_repo;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import javax.transaction.Transactional;
import org.apache.poi.EncryptedDocumentException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Iterator;

@Service
@Transactional
public class ASL_Excel_Services {
	
	private static final Logger logger = LoggerFactory.getLogger(ASL_Excel_Services.class);

	@Autowired
	MIS_SETTLEMENT_ENTITY_REP MIS_SETTLEMENT_ENTITY_REPs;
	@Autowired
	Mis_treasury_placement_repo Mis_treasury_placement_repo;
	@Autowired
	ASL_Report_Rep ASL_Report_Reps;
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    AuditService auditService;


    public String addASL(String iBranchCode, String iBranchName, LocalDate reportDate,
            String uploadedBy, MultipartFile file, String userid,String mode) {

        String msg = "";
        
        if(mode.equals("exposure")) {
        logger.info("Starting file upload for Exposure Data.. branch: {}, reportDate: {}, uploadedBy: {}", iBranchName, reportDate, uploadedBy);

        try (InputStream is = file.getInputStream()) {
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            if (rowIterator.hasNext()) rowIterator.next(); // Skip header row

            Session session = sessionFactory.getCurrentSession();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                ASL_Report_Entity entity = new ASL_Report_Entity();
                BigDecimal id = (BigDecimal) session.createNativeQuery("SELECT ASL_ID.NEXTVAL FROM DUAL").getSingleResult();
                if (id == null) throw new RuntimeException("Failed to retrieve ASL_ID.NEXTVAL from database");

                entity.setId(id.longValue());

                String branchName = getCellValue(row.getCell(0));
                if (branchName == null || branchName.isEmpty()) continue;
                entity.setBranchName(branchName);
                entity.setSrlNo(getCellValue(row.getCell(1)));
                entity.setCounterpartyBankName(getCellValue(row.getCell(2)));
                entity.setCounterpartyBank(getCellValue(row.getCell(2)));
                entity.setBuyersCredit(getNumericValue(row.getCell(3)));
                entity.setForeignBillDiscounting(getNumericValue(row.getCell(4)));
                entity.setLocalBillDiscounting(getNumericValue(row.getCell(5)));
                entity.setGuaranteeSblcs(getNumericValue(row.getCell(6)));
                entity.setSyndicatedLoansInvestment(getNumericValue(row.getCell(7)));
                entity.setOthers(getNumericValue(row.getCell(8)));
                entity.setRemarks(getCellValue(row.getCell(9)));
                entity.setiBranchCode(iBranchCode);
                entity.setiBranchName(iBranchName);
                entity.setUploadedBy(uploadedBy);
                entity.setReportDate(java.sql.Date.valueOf(reportDate));

                session.save(entity);
            }
            auditService.createBusinessAudit(userid, "UPLOAD", "UPLOAD FILE OF COUNTERPARTY", null,"MIS_ASL_DETAIL_REPORT");
            session.flush();   
            session.clear();
            msg = "File Uploaded and Data Saved Successfully";
            logger.info("Upload successful for Exposure Data..");

        } catch (Exception e) {
            msg = "Error occurred while processing file. Please contact administrator.";
            logger.error("Exception during file upload for Exposure Data: ", e);
        }
        
        }else if(mode.equals("placement")) {
        	 logger.info("Starting file upload for placement.. branch: {}, reportDate: {}, uploadedBy: {}", iBranchName, reportDate, uploadedBy);

             try (InputStream is = file.getInputStream()) {
                 Workbook workbook = WorkbookFactory.create(is);
                 Sheet sheet = workbook.getSheetAt(0);
                 Iterator<Row> rowIterator = sheet.iterator();

                 if (rowIterator.hasNext()) rowIterator.next(); // Skip header row

                 Session session = sessionFactory.getCurrentSession();
                
                 while (rowIterator.hasNext()) {
                	    Row row = rowIterator.next();

                	    // Get titre value first
                	    String titreValue = getCellValue(row.getCell(0));
                	    
                	    // If titre is empty or null, break the loop
                	    if (titreValue == null || titreValue.trim().isEmpty()) {
                	        logger.info("Empty titre encountered. Stopping file processing.");
                	        break;
                	    }

                	    MIS_TREASURY_PLACEMENT_ENTITY entity = new MIS_TREASURY_PLACEMENT_ENTITY();
                	    BigDecimal id = (BigDecimal) session.createNativeQuery("SELECT PLACEMENT_ID.NEXTVAL FROM DUAL").getSingleResult();
                	    if (id == null) throw new RuntimeException("Failed to retrieve PLACEMENT_ID.NEXTVAL from database");

						
						  entity.setNum_operation(String.valueOf(id));
						  entity.setTitre(titreValue);
						  entity.setDevise_1(getCellValue(row.getCell(1)));
						  entity.setNominal_1(new BigDecimal(getNumericValue(row.getCell(2))));
						  entity.setDate_operation(getExcelSqlDate(row.getCell(3)));
						  entity.setDate_valeur(getExcelSqlDate(row.getCell(4)));
						  entity.setDate_echeance(getExcelSqlDate(row.getCell(5)));
						  entity.setPortefeuille(getCellValue(row.getCell(6)));
						  entity.setContrepartie(getCellValue(row.getCell(7)));
						  entity.setBranch_code(iBranchCode);
						  entity.setBranch_name(iBranchName);
						  entity.setCreate_user(uploadedBy);
						  entity.setReport_date(java.sql.Date.valueOf(reportDate));
						 

                	    session.save(entity);
                	}
                 session.flush();   
                 session.clear();

                 msg = "File Uploaded and Data Saved Successfully";
                 auditService.createBusinessAudit(userid, "UPLOAD", "UPLOAD FILE OF TREASURY PLACEMENT", null,"MIS_TREASURY_PLACEMENT");
                 logger.info("Upload successful for placement..");

             } catch (Exception e) {
                 msg = "Error occurred while processing file. Please contact administrator.";
                 logger.error("Exception during file upload for placement: ", e);
             }
        	
        }else if(mode.equals("settlement")) {
        	 logger.info("Starting file upload for Settlement.. branch: {}, reportDate: {}, uploadedBy: {}", iBranchName, reportDate, uploadedBy);

             try (InputStream is = file.getInputStream()) {
                 Workbook workbook = WorkbookFactory.create(is);
                 Sheet sheet = workbook.getSheetAt(0);
                 Iterator<Row> rowIterator = sheet.iterator();

                 if (rowIterator.hasNext()) rowIterator.next(); // Skip header row

                 Session session = sessionFactory.getCurrentSession();

                 while (rowIterator.hasNext()) {
                	    Row row = rowIterator.next();

                	    String dealId = getCellValue(row.getCell(0));

                	    // Break the loop if DealId is empty or null
                	    if (dealId == null || dealId.trim().isEmpty()) {
                	        logger.info("Empty DealId encountered. Stopping file processing.");
                	        break;
                	    }

                	    MIS_SETTLEMENT_ENTITY entity = new MIS_SETTLEMENT_ENTITY();

                	    entity.setDealId(dealId);
                	    entity.setAmount1(getNumericValue(row.getCell(1)));
                	    entity.setAmount2(getNumericValue(row.getCell(2)));
                	    entity.setRateOrPrice(getNumericValue(row.getCell(3)));
                	    entity.setSecurity(getCellValue(row.getCell(4)));
                	    entity.setTradeDate(getExcelSqlDate(row.getCell(5)));
                	    entity.setValueDate(getExcelSqlDate(row.getCell(6)));
                	    entity.setMaturityDate(getExcelSqlDate(row.getCell(7)));
                	    entity.setCounterpartyCode(getCellValue(row.getCell(8)));
                	    entity.setBranchCode(iBranchCode);
                	    entity.setBranchName(iBranchName);
                	    entity.setCreateUser(uploadedBy);
                	    entity.setReportDate(java.sql.Date.valueOf(reportDate));

                	    session.save(entity);
                	}

                 session.flush();   
                 session.clear();
                 msg = "File Uploaded and Data Saved Successfully";
                 auditService.createBusinessAudit(userid, "UPLOAD", "UPLOAD FILE OF SWAP SETTLEMENT", null,"MIS_SETTLEMENT");
                 logger.info("Upload successful for Settlement..");

             } catch (Exception e) {
                 msg = "Error occurred while processing file. Please contact administrator.";
                 logger.error("Exception during file upload for Settlement: ", e);
             }
        	
        }


        return msg;
    }


//Helper methods
    
    private java.sql.Date getExcelSqlDate(Cell cell) {
        if (cell == null) return null;
        if (DateUtil.isCellDateFormatted(cell)) {
            return new java.sql.Date(cell.getDateCellValue().getTime());
        }
        return null;
    }

private String getCellValue(Cell cell) {
if (cell == null) return "";
cell.setCellType(CellType.STRING);
return cell.getStringCellValue().trim();
}

private Double getNumericValue(Cell cell) {
if (cell == null) return 0.0;
try {
return cell.getNumericCellValue();
} catch (Exception e) {
try {
   return Double.parseDouble(cell.toString());
} catch (Exception ex) {
   return 0.0;
}
}
}
public String Replace_data(String iBranchCode, String iBranchName, LocalDate reportDate,
        String uploadedBy, MultipartFile file, String userid,String mode) {

    String msg = "";

    if(mode.equals("exposure")) {

    logger.info("Replacing data  for Exposure Data.. branch: {}, reportDate: {}, uploadedBy: {}", iBranchName, reportDate, uploadedBy);

    try (InputStream is = file.getInputStream()) {
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();

        if (rowIterator.hasNext()) rowIterator.next(); // Skip header row

        Session session = sessionFactory.getCurrentSession();

        // Delete existing records for the same report date
        ASL_Report_Reps.deleteByReportDate(java.sql.Date.valueOf(reportDate),iBranchName);
        logger.info("Deleted existing records for for Exposure Data the report date: {}", reportDate);

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            ASL_Report_Entity entity = new ASL_Report_Entity();
            BigDecimal id = (BigDecimal) session.createNativeQuery("SELECT ASL_ID.NEXTVAL FROM DUAL").getSingleResult();
            if (id == null) throw new RuntimeException("Failed to retrieve ASL_ID.NEXTVAL from database");

            entity.setId(id.longValue());

            String branchName = getCellValue(row.getCell(0));
            if (branchName == null || branchName.isEmpty()) continue;
            entity.setBranchName(branchName);
            entity.setSrlNo(getCellValue(row.getCell(1)));
            entity.setCounterpartyBankName(getCellValue(row.getCell(2)));
            entity.setCounterpartyBank(getCellValue(row.getCell(2)));
            entity.setBuyersCredit(getNumericValue(row.getCell(3)));
            entity.setForeignBillDiscounting(getNumericValue(row.getCell(4)));
            entity.setLocalBillDiscounting(getNumericValue(row.getCell(5)));
            entity.setGuaranteeSblcs(getNumericValue(row.getCell(6)));
            entity.setSyndicatedLoansInvestment(getNumericValue(row.getCell(7)));
            entity.setOthers(getNumericValue(row.getCell(8)));
            entity.setRemarks(getCellValue(row.getCell(9)));
            entity.setiBranchCode(iBranchCode);
            entity.setiBranchName(iBranchName);
            entity.setUploadedBy(uploadedBy);
            entity.setReportDate(java.sql.Date.valueOf(reportDate));

            session.save(entity);
        }

        msg = "File Uploaded and Data Saved Successfully";
        logger.info("Data replaced successfully for Exposure Data the branch: {}", iBranchName);

    } catch (Exception e) {
        msg = "Error occurred while processing file. Please contact administrator.";
        logger.error("Exception during replace for Exposure data operation: ", e);
    }
    }else if(mode.equals("placement")) {
    	
    	 logger.info("Replacing data  for placement Data.. branch: {}, reportDate: {}, uploadedBy: {}", iBranchName, reportDate, uploadedBy);

    	    try (InputStream is = file.getInputStream()) {
    	        Workbook workbook = WorkbookFactory.create(is);
    	        Sheet sheet = workbook.getSheetAt(0);
    	        Iterator<Row> rowIterator = sheet.iterator();

    	        if (rowIterator.hasNext()) rowIterator.next(); // Skip header row

    	        Session session = sessionFactory.getCurrentSession();

    	        // Delete existing records for the same report date
    	        Mis_treasury_placement_repo.Deletedatabyreport_date(java.sql.Date.valueOf(reportDate),iBranchName);
    	        logger.info("Deleted existing records for for placement Data the report date: {}", reportDate);

    	        while (rowIterator.hasNext()) {
            	    Row row = rowIterator.next();

            	    // Get titre value first
            	    String titreValue = getCellValue(row.getCell(0));
            	    
            	    // If titre is empty or null, break the loop
            	    if (titreValue == null || titreValue.trim().isEmpty()) {
            	        logger.info("Empty titre encountered. Stopping file processing.");
            	        break;
            	    }

            	    MIS_TREASURY_PLACEMENT_ENTITY entity = new MIS_TREASURY_PLACEMENT_ENTITY();
            	    BigDecimal id = (BigDecimal) session.createNativeQuery("SELECT PLACEMENT_ID.NEXTVAL FROM DUAL").getSingleResult();
            	    if (id == null) throw new RuntimeException("Failed to retrieve PLACEMENT_ID.NEXTVAL from database");

            	      entity.setNum_operation(String.valueOf(id));
					  entity.setTitre(titreValue);
					  entity.setDevise_1(getCellValue(row.getCell(1)));
					  entity.setNominal_1(new BigDecimal(getNumericValue(row.getCell(2))));
					  entity.setDate_operation(getExcelSqlDate(row.getCell(3)));
					  entity.setDate_valeur(getExcelSqlDate(row.getCell(4)));
					  entity.setDate_echeance(getExcelSqlDate(row.getCell(5)));
					  entity.setPortefeuille(getCellValue(row.getCell(6)));
					  entity.setContrepartie(getCellValue(row.getCell(7)));
					  entity.setBranch_code(iBranchCode);
					  entity.setBranch_name(iBranchName);
					  entity.setCreate_user(uploadedBy);
					  entity.setReport_date(java.sql.Date.valueOf(reportDate));

            	    session.save(entity);
            	}

                msg = "File Uploaded and Data Saved Successfully";
                logger.info("Upload successful for placement..");

            } catch (Exception e) {
                msg = "Error occurred while processing file. Please contact administrator.";
                logger.error("Exception during file upload for placement: ", e);
            }

    }else if(mode.equals("settlement")) {
    	 logger.info("Replacing data  for settlement Data.. branch: {}, reportDate: {}, uploadedBy: {}", iBranchName, reportDate, uploadedBy);

 	    try (InputStream is = file.getInputStream()) {
 	        Workbook workbook = WorkbookFactory.create(is);
 	        Sheet sheet = workbook.getSheetAt(0);
 	        Iterator<Row> rowIterator = sheet.iterator();

 	        if (rowIterator.hasNext()) rowIterator.next(); // Skip header row

 	        Session session = sessionFactory.getCurrentSession();

 	        // Delete existing records for the same report date
 	       MIS_SETTLEMENT_ENTITY_REPs.deleteByReportDate(java.sql.Date.valueOf(reportDate),iBranchName);
 	        logger.info("Deleted existing records for for settlement Data the report date: {}", reportDate);

 	       while (rowIterator.hasNext()) {
       	    Row row = rowIterator.next();

       	    String dealId = getCellValue(row.getCell(0));

       	    // Break the loop if DealId is empty or null
       	    if (dealId == null || dealId.trim().isEmpty()) {
       	        logger.info("Empty DealId encountered. Stopping file processing.");
       	        break;
       	    }

       	    MIS_SETTLEMENT_ENTITY entity = new MIS_SETTLEMENT_ENTITY();

       	    entity.setDealId(dealId);
       	    entity.setAmount1(getNumericValue(row.getCell(1)));
       	    entity.setAmount2(getNumericValue(row.getCell(2)));
       	    entity.setRateOrPrice(getNumericValue(row.getCell(3)));
       	    entity.setSecurity(getCellValue(row.getCell(4)));
       	    entity.setTradeDate(getExcelSqlDate(row.getCell(5)));
       	    entity.setValueDate(getExcelSqlDate(row.getCell(6)));
       	    entity.setMaturityDate(getExcelSqlDate(row.getCell(7)));
       	    entity.setCounterpartyCode(getCellValue(row.getCell(8)));
       	    entity.setBranchCode(iBranchCode);
       	    entity.setBranchName(iBranchName);
       	    entity.setCreateUser(uploadedBy);
       	    entity.setReportDate(java.sql.Date.valueOf(reportDate));

       	    session.save(entity);
       	}

             msg = "File Uploaded and Data Saved Successfully";
             logger.info("Upload successful for settlement..");

         } catch (Exception e) {
             msg = "Error occurred while processing file. Please contact administrator.";
             logger.error("Exception during file upload for settlement: ", e);
         }
    }

    return msg;
}


}
