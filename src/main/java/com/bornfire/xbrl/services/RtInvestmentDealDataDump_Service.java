package com.bornfire.xbrl.services;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import com.bornfire.xbrl.util.ExcelUploadHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bornfire.xbrl.entities.MIS_TREASURY_PLACEMENT_ENTITY;
import com.bornfire.xbrl.entities.RT_Treasury_master_tb_entity;
import com.bornfire.xbrl.entities.RT_Treasury_swd_data_entity;
import com.bornfire.xbrl.entities.RtInvestmentDealDataDump;
import com.bornfire.xbrl.entities.RtInvestmentDealDataDump_Rep;
import com.bornfire.xbrl.entities.RtPlacementDealDataDump;
import com.bornfire.xbrl.entities.RtPlacementDealDataDump_Rep;

@Service
public class RtInvestmentDealDataDump_Service {
	
	// Fixed syntax error here: added .class and closing parentheses
		private static final Logger logger = LoggerFactory.getLogger(RtInvestmentDealDataDump_Service.class);
		
		@Autowired
		RtInvestmentDealDataDump_Rep rtinvestmentdealdatadump_rep;
		
		@Autowired
		RtPlacementDealDataDump_Rep rtplacementdealdatadump_rep;
		
		@Transactional
		public String Uploadinvdump(MultipartFile file, Date toDate, String username, String Report_type)
				throws Exception {
			String Response = "" ;
			Date today = new Date();
			
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMMdd");

			
			int No_of_Records = 0;

			try (Workbook workbook = ExcelUploadHelper.openExcelWorkbook(file)) {
				DataFormatter formatter = new DataFormatter();
				if (Report_type.equals("TR_INV_DEAL_DUMP")) {
					
					boolean exists = rtinvestmentdealdatadump_rep.existsByReportDate(toDate);
					

					// If today upload again → replace
					if (exists) {
						rtinvestmentdealdatadump_rep.deleteByReportDate(toDate);
						logger.info("Existing Investment Deal Dump data removed. New insert started for date: " + toDate);
					}
					
					SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
					List<RtInvestmentDealDataDump> rtinvdumplistdata = new ArrayList<>();

					
					for (Sheet sheet : workbook) {
						for (Row row : sheet) {

							// Skip header
							if (row.getRowNum() == 0)
								continue;

							RtInvestmentDealDataDump invdealdump = new RtInvestmentDealDataDump();
							invdealdump.setDealId(formatter.formatCellValue(row.getCell(0)).split(":")[1]);
							invdealdump.setTypeOfDeal(formatter.formatCellValue(row.getCell(1)));
							invdealdump.setType(formatter.formatCellValue(row.getCell(2)));
							invdealdump.setOptionType(formatter.formatCellValue(row.getCell(3)));
							invdealdump.setTypeOfEvent(formatter.formatCellValue(row.getCell(4)));
							invdealdump.setBlkNo(getSafeBigDecimal(row.getCell(5), formatter));
							invdealdump.setAmount1(getSafeBigDecimal(row.getCell(6) ,formatter));
							invdealdump.setAmount2(getSafeBigDecimal(row.getCell(7) ,formatter));
							invdealdump.setRatePrice(getSafeBigDecimal(row.getCell(8) ,formatter));
							invdealdump.setStrike(getSafeBigDecimal(row.getCell(9) ,formatter));
							//System.out.println(formatter.formatCellValue(row.getCell(9)));
							invdealdump.setClRate(getSafeBigDecimal(row.getCell(10) ,formatter));
							invdealdump.setClMargin(getSafeBigDecimal(row.getCell(11),formatter));
							
			
							invdealdump.setSecurity(formatter.formatCellValue(row.getCell(12)));
							invdealdump.setSecurityName(formatter.formatCellValue(row.getCell(13)));
							invdealdump.setTradeDate(getSafeDate(row.getCell(14)));
							invdealdump.setValueDate(getSafeDate(row.getCell(15)));
							invdealdump.setMatDate(getSafeDate(row.getCell(16)));
							invdealdump.setLiquidationDate(getSafeDate(row.getCell(17)));
						
							invdealdump.setQuantity(getSafeBigDecimal(row.getCell(18) ,formatter));
							invdealdump.setQuantity(null);
							invdealdump.setCpty(formatter.formatCellValue(row.getCell(20)));
							invdealdump.setCptyName(formatter.formatCellValue(row.getCell(21)));
							invdealdump.setUserId(formatter.formatCellValue(row.getCell(22)));
							if(!formatter.formatCellValue(row.getCell(23)).isEmpty()) {
								invdealdump.setLastUser(formatter.formatCellValue(row.getCell(23)));
							}
							
							invdealdump.setFolder(formatter.formatCellValue(row.getCell(24)));
							if(!formatter.formatCellValue(row.getCell(25)).isEmpty()) {
								invdealdump.setComments(formatter.formatCellValue(row.getCell(25)));
							}
							
							invdealdump.setLastDate(getSafeDate(row.getCell(26)));
							invdealdump.setDownloadKey(formatter.formatCellValue(row.getCell(27)));
							invdealdump.setCaptureTimestamp(formatter.formatCellValue(row.getCell(28)));
							invdealdump.setReportDate(toDate);
							invdealdump.setCreateUser(username);
							invdealdump.setCreateTime(new Date());
							rtinvdumplistdata.add(invdealdump);
							No_of_Records++;
						}
						
						rtinvestmentdealdatadump_rep.saveAll(rtinvdumplistdata);
					}
					Response = "Investment Deal Dump details processed successfully for Report Date: " + toDate + " Record Count: "
					+ No_of_Records;
				} 
				
				else if (Report_type.equals("plcdealdump")) {
					
					boolean exists = rtplacementdealdatadump_rep.existsByReportDate(toDate);
					

					// If today upload again → replace
					if (exists) {
						rtplacementdealdatadump_rep.deleteByReportDate(toDate);
						logger.info("Existing Placement Deal Dump data removed. New insert started for date: " + toDate);
					}
					
					SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
					  List<RtPlacementDealDataDump> rtplcdumplistdata = new ArrayList<>();
	                

					
					for (Sheet sheet : workbook) {
						for (Row row : sheet) {

							// Skip header
							if (row.getRowNum() == 0)
								continue;

							RtPlacementDealDataDump plcdealdump = new RtPlacementDealDataDump();
							plcdealdump.setDealId(getSafeString(row.getCell(0), formatter).split(":")[1]);
							plcdealdump.setTypeOfDeal(getSafeString(row.getCell(1), formatter));
							plcdealdump.setType(getSafeString(row.getCell(2), formatter));
							plcdealdump.setOptionType(getSafeString(row.getCell(3), formatter));
							plcdealdump.setTypeOfEvent(getSafeString(row.getCell(4), formatter));

							plcdealdump.setBlkNo(getSafeBigDecimal(row.getCell(5), formatter));
							plcdealdump.setAmount1(getSafeBigDecimal(row.getCell(6), formatter));
							plcdealdump.setAmount2(getSafeBigDecimal(row.getCell(7), formatter));
							plcdealdump.setRatePrice(getSafeBigDecimal(row.getCell(8), formatter));
							plcdealdump.setStrike(getSafeBigDecimal(row.getCell(9), formatter));
							plcdealdump.setClRate(getSafeBigDecimal(row.getCell(10), formatter));
							plcdealdump.setClMargin(getSafeBigDecimal(row.getCell(11), formatter));

							plcdealdump.setSecurity(getSafeString(row.getCell(12), formatter));
							plcdealdump.setSecurityName(getSafeString(row.getCell(13), formatter));

							plcdealdump.setTradeDate(getSafeDate(row.getCell(14)));
							plcdealdump.setValueDate(getSafeDate(row.getCell(15)));
							plcdealdump.setMatDate(getSafeDate(row.getCell(16)));
							plcdealdump.setLiquidationDate(getSafeDate(row.getCell(17)));

							plcdealdump.setQuantity(getSafeBigDecimal(row.getCell(18), formatter));

							plcdealdump.setCpty(getSafeString(row.getCell(20), formatter));
							plcdealdump.setCptyName(getSafeString(row.getCell(21), formatter));
							plcdealdump.setUserId(getSafeString(row.getCell(22), formatter));
							plcdealdump.setLastUser(getSafeString(row.getCell(23), formatter));

							plcdealdump.setFolder(getSafeString(row.getCell(24), formatter));
							plcdealdump.setComments(getSafeString(row.getCell(25), formatter));

							plcdealdump.setLastDate(getSafeDate(row.getCell(26)));
							plcdealdump.setDownloadKey(getSafeString(row.getCell(27), formatter));
							plcdealdump.setCaptureTimestamp(getSafeString(row.getCell(28), formatter));

							plcdealdump.setReportDate(toDate);
							plcdealdump.setCreateUser(username);
							plcdealdump.setCreateTime(new Date());
							rtplcdumplistdata.add(plcdealdump);
							No_of_Records++;
						}
						rtplacementdealdatadump_rep.saveAll(rtplcdumplistdata);
					}
					Response = "Placement Deal Dump details processed successfully for Report Date: " + toDate + " Record Count: "
					+ No_of_Records;
				} 
			}
			

			return Response;
		}
		
		private LocalDate getLocalDateFromCell(Cell cell) {
		    if (cell == null) return null;

		    if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
		        if (DateUtil.isCellDateFormatted(cell)) {
		            Date date = cell.getDateCellValue();
		            return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		        }
		    }
		    return null;
		}
		
		
	
		private BigDecimal getSafeBigDecimal(Cell cell, DataFormatter formatter) {
		    if (cell == null) return null;
		    String val = formatter.formatCellValue(cell).trim();
		    if (!val.isEmpty()) {
		        try {
		            return new BigDecimal(val);
		        } catch (NumberFormatException e) {
		            System.out.println("Invalid number in cell " + cell.getAddress() + ": " + val);
		        }
		    }
		    return null;
		}

		private java.sql.Date getSafeDate(Cell cell) {
		    if (cell == null) return null;
		    try {
		        LocalDate localDate = getLocalDateFromCell(cell); // assuming your method
		        if (localDate != null) {
		            return java.sql.Date.valueOf(localDate);
		        }
		    } catch (Exception e) {
		        System.out.println("Invalid date in cell " + cell.getAddress());
		    }
		    return null;
		}

		private String getSafeString(Cell cell, DataFormatter formatter) {
		    if (cell == null) return null;
		    String val = formatter.formatCellValue(cell).trim();
		    return val.isEmpty() ? null : val;
		}

		
		public List<String> getInvestmentDealDumpUploadedDates() {
			return formatReportDates(rtinvestmentdealdatadump_rep.findDistinctReportDates());
		}

		
		public List<String> getPlacementDealDumpUploadedDates() {
			return formatReportDates(rtplacementdealdatadump_rep.findDistinctReportDates());
		}

		private List<String> formatReportDates(List<Date> dates) {
			if (dates == null || dates.isEmpty()) {
				return new ArrayList<>();
			}
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			return dates.stream().filter(Objects::nonNull).map(sdf::format).collect(Collectors.toList());
		}

}
