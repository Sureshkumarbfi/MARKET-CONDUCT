
package com.bornfire.xbrl.services;


import org.apache.poi.ss.usermodel.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


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
    SessionFactory sessionFactory;
    @Autowired
    AuditService auditService;



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

}
