package com.bornfire.xbrl.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.bornfire.xbrl.entities.Eod_acct_balance_pojo;
import com.bornfire.xbrl.entities.General_master_tb_pojo;
import com.bornfire.xbrl.entities.RT_Bank_bill_data_pojo;
import com.bornfire.xbrl.entities.RT_RWA_Fund_base_data_entity;
import com.bornfire.xbrl.entities.RT_RWA_Fund_base_data_rep;
import com.bornfire.xbrl.entities.RT_RWA_NonFund_base_data_entity;
import com.bornfire.xbrl.entities.RT_RWA_NonFund_base_data_rep;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

@Service
public class RwaDataUploadService {

	private static final Logger logger = LoggerFactory.getLogger(RwaDataUploadService.class);

	@Autowired
	private RT_RWA_Fund_base_data_rep fundRepo;

	@Autowired
	private RT_RWA_NonFund_base_data_rep nonFundRepo;
	@Autowired
	AuditService auditservice;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource srcdataSource;
	
	  public List<String> getUploadedFundDates() {
	        List<Date> dates = fundRepo.findUploadedDates();
	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	        return dates.stream()
	                .map(sdf::format)
	                .collect(Collectors.toList());
	    }
	  public List<String> getUploadedNonFundDates() {
	        List<Date> dates = nonFundRepo.findUploadedDates();
	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	        return dates.stream()
	                .map(sdf::format)
	                .collect(Collectors.toList());
	    } public List<String> getUploadedBillDates() {
	        String sql = "SELECT DISTINCT REPORT_DATE FROM brf95_rwa_data_bill ORDER BY REPORT_DATE";
	        List<Date> dates = jdbcTemplate.query(sql,(rs, rowNum) -> rs.getDate("REPORT_DATE"));
	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	        return dates.stream()
	                .map(sdf::format)
	                .collect(Collectors.toList());
	    }
	    private Date getRwaFileReportDate(MultipartFile file) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
	        String line;
	        while ((line = br.readLine()) != null) {
	            line = line.trim();
	            if (line.isEmpty()) {
	                continue;
	            }
	            String delimiter = line.contains("|") ? "\\|" : "\t";
	            String[] data = line.split(delimiter, -1);
	            if (data.length == 0) {
	                continue;
	            }
	            String firstCol = data[0].trim();
	            // Skip header rows safely
	            if (firstCol.equalsIgnoreCase("DATE")
	                    || firstCol.equalsIgnoreCase("REPORT_DATE")
	                    || firstCol.equalsIgnoreCase("MOC")
	                    || firstCol.contains("DATE")) {
	                continue;
	            }
	            try {
	                return new SimpleDateFormat("dd-MM-yyyy").parse(firstCol);
	            } catch (Exception e) {
	                continue;
	            }
	        }
	        return null;
	    }
	    @Transactional
	    public String uploadRwaTextFile(MultipartFile file, String reportType, Date toDate, boolean forceUpload) throws Exception {
	        Date fileReportDate = getRwaFileReportDate(file);
	        SimpleDateFormat compare = new SimpleDateFormat("ddMMyyyy");
	        // Step 1: Report date mismatch first
	        if (!forceUpload &&
	                fileReportDate != null &&
	                !compare.format(fileReportDate).equals(compare.format(toDate))) {

	            throw new RuntimeException("REPORT_DATE_MISMATCH");
	        }
	        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
	            if ("RWAFUND".equals(reportType)) {
	                return processFunded(br, toDate);
	            } else if ("RWANONFUND".equals(reportType)) {
	                return processNonFunded(br, toDate);
	            } else {
	                throw new Exception("Unsupported Report Type");
	            }
	        }
	    }
	/*
	 * public String uploadRwaTextFile(MultipartFile file, String reportType, Date
	 * toDate, boolean forceUpload) throws Exception { Date fileReportDate =
	 * getRwaFileReportDate(file);
	 * 
	 * SimpleDateFormat compare = new SimpleDateFormat("ddMMyyyy");
	 * 
	 * if (!forceUpload && fileReportDate != null &&
	 * !compare.format(fileReportDate).equals(compare.format(toDate))) {
	 * 
	 * throw new RuntimeException("REPORT_DATE_MISMATCH"); } try (BufferedReader br
	 * = new BufferedReader(new InputStreamReader(file.getInputStream()))) { String
	 * line; br.readLine(); // Skip Header
	 * 
	 * if ("RWAFUND".equals(reportType)) { return processFunded(br, toDate); } else
	 * if ("RWANONFUND".equals(reportType)) { return processNonFunded(br, toDate); }
	 * else { throw new Exception("Unsupported Report Type"); } } }
	 */

	// ================= NON-FUNDED PROCESSING =================
	private String processNonFunded(BufferedReader br, Date toDate) throws Exception {

	    Date today = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	    boolean exists = nonFundRepo.existsReportDate(toDate) > 0;

	    // Block duplicate for past date
	    if (exists && !sdf.format(today).equals(sdf.format(toDate))) {
	        throw new RuntimeException("Data already uploaded for report date : " + toDate);
	    }

	    // Allow overwrite for today
	    if (exists) {
	        nonFundRepo.deleteByReportDate(toDate);
	    }

	    List<RT_RWA_NonFund_base_data_entity> nonFundList = new ArrayList<>();

	    String line;
	    int rowCount = 1;

	    while ((line = br.readLine()) != null) {

	        rowCount++;

	        if (line.trim().isEmpty())
	            continue;

	        String delimiter = line.contains("|") ? "\\|" : "\t";
	        String[] data = line.split(delimiter, -1);
	        
	        if (data[0].matches(".*[a-zA-Z].*") && data[1].matches(".*[a-zA-Z].*") && data[2].matches(".*[a-zA-Z].*") && data[3].matches(".*[a-zA-Z].*") && data[4].matches(".*[a-zA-Z].*")) {
	            continue;
	        }

	        if (data.length < 58) {
	            logger.warn("Non-Fund Row {} skipped: insufficient columns {}", rowCount, data.length);
	            continue;
	        }

	        try {

	            RT_RWA_NonFund_base_data_entity ent = new RT_RWA_NonFund_base_data_entity();

	            // Always use UI selected date
	            ent.setReport_date(toDate);

	            ent.setMoc(parseDecimal(data[1]));
	            ent.setTerritory(data[2]);
	            ent.setBranch_name(data[3]);
	            ent.setCust_id(data[4]);
	            ent.setCust_name(data[5]);
	            ent.setType(data[6]);
	            ent.setLcbg_id(data[7].trim());

	            ent.setGl_code(data[8]);
	            ent.setGl_code_description(data[9]);
	            ent.setConst_id(data[10]);
	            ent.setConst_description(data[11]);
	            ent.setPurpose(data[12]);
	            ent.setPurpose_description(data[13]);
	            ent.setNationality(data[14]);
	            ent.setLegal_entity(data[15]);
	            ent.setClass_val(data[16]);
	            ent.setSub_class(data[17]);
	            ent.setNpa_date(parseDateSafe(data[18]));
	            ent.setTot_provision(parseDecimal(data[19]));
	            ent.setLcbg_prov(parseDecimal(data[20]));
	            ent.setProvision_percent(data[21]);
	            ent.setCategory(data[22]);
	            ent.setSub_category(data[23]);
	            ent.setBs_turnover(parseDecimal(data[24]));
	            ent.setNet_worth(parseDecimal(data[25]));
	            ent.setLcbg_limit(parseDecimal(data[26]));
	            ent.setSecurity_fd_primary(parseDecimal(data[27]));
	            ent.setSecurity_fd_collat(parseDecimal(data[28]));
	            ent.setCurrency(data[29]);
	            ent.setLcbg_balance(parseDecimal(data[30]));
	            ent.setLcbg_exposure(parseDecimal(data[31]));
	            ent.setCcf(parseDecimal(data[32]));
	            ent.setLcbg_ccf_adj_amt(parseDecimal(data[33]));
	            ent.setLcbg_crm(parseDecimal(data[34]));
	            ent.setCrm(parseDecimal(data[35]));
	            ent.setCrm_adj_bal(parseDecimal(data[36]));
	            ent.setAcceptance_amount(parseDecimal(data[37]));
	            ent.setRisk_pcnt(parseDecimal(data[38]));
	            ent.setRwa(parseDecimal(data[39]));
	            ent.setAc_rwp(parseDecimal(data[40]));
	            ent.setRating(data[41]);
	            ent.setUndrwn_balance(parseDecimal(data[42]));
	            ent.setUndrwn_ccf(parseDecimal(data[43]));
	            ent.setUndrwn_ccf_balance(parseDecimal(data[44]));
	            ent.setUndrwn_crm(parseDecimal(data[45]));
	            ent.setUndrwn_rwa(parseDecimal(data[46]));
	            ent.setBg_type(data[47]);
	            ent.setRrp_exp(parseDecimal(data[48]));
	            ent.setLc_nature(data[49]);

	            ent.setRating_date(parseDateSafe(data[51]));
	            ent.setRating_expiry(parseDateSafe(data[52]));

	            ent.setInd_report_order(parseDecimal(data[54]));
	            ent.setInd_desc(data[55]);
	            ent.setNo_of_employees(parseDecimal(data[56]));
	            ent.setMaturity_date(parseDateSafe(data[57]));

	            nonFundList.add(ent);

	        } catch (Exception e) {
	            logger.error("Error at Non-Fund Row {} : {}", rowCount, e.getMessage());
	        }
	    }

	    logger.info("Total Non-Fund rows parsed : {}", nonFundList.size());

	  //  auditservice.createBusinessAudit(entity.getReport_date(), "UPLOAD", " Regulatory_Data_Ingestion_RWA_NONFUNDDATA", null,
			//	"BRF95_RWA_DATA_NONFUNDBASED");
	    String reportDateStr = new SimpleDateFormat("dd-MM-yyyy").format(toDate);
        auditservice.createBusinessAudit(  reportDateStr, "UPLOAD",  "Regulatory_Data_Ingestion_RWA_NONFUNDDATA", null,
                "BRF95_RWA_DATA_NONFUNDBASED");
	    
	    if (!nonFundList.isEmpty()) {
	        nonFundRepo.saveAll(nonFundList);
	        nonFundRepo.flush();
	    }

	    return "Non-Funded: Successfully uploaded " + nonFundList.size() + " records.";
	}
	
	public String UploadEabandGamdata(MultipartFile file, String reportType, Date toDate) {

		List<General_master_tb_pojo> generalDetail = new ArrayList<>();

		DateTimeFormatter formatter1 = new DateTimeFormatterBuilder().parseCaseInsensitive()
				.appendPattern("dd-MMM-yyyy").toFormatter(Locale.ENGLISH);

		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		// Step 1: Read file
		try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

			String line;
			String delimiter = "\\|";

			while ((line = br.readLine()) != null) {

				line = line.trim();
				if (line.isEmpty())
					continue;

				String upper = line.toUpperCase();
				if (upper.startsWith("SQL") || upper.startsWith("ACID") || upper.startsWith("--"))
					continue;

					if (Character.isDigit(line.charAt(0)))
						continue;

					String[] values = line.split(delimiter);

					if (values.length < 12)
						continue;

					General_master_tb_pojo pojo = new General_master_tb_pojo();

					pojo.setAcct_crncy_code(values[0].trim());
					pojo.setGl_sub_head_code(values[1].trim());
					pojo.setSchm_type(values[2].trim());
					pojo.setSchm_code(values[3].trim());
					pojo.setCust_id(values[4].trim());
					pojo.setAcct_number(values[5].trim());
					pojo.setAcct_name(values[6].trim());
					pojo.setReport_date(java.sql.Date.valueOf(LocalDate.parse(values[7].trim(), formatter1)));
					pojo.setAcct_balance_amt_ac(new BigDecimal(values[8].trim()));
					pojo.setAcid(values[9].trim());
					pojo.setSol_id(values[10].trim());
					pojo.setAcct_opn_date(java.sql.Date.valueOf(LocalDate.parse(values[11].trim(), formatter2)));

					generalDetail.add(pojo);
				
			}

		} catch (Exception e) {
			throw new RuntimeException("ERROR: File reading failed", e);
		}

		int batchSize = 5000;
		int totalInserted = 0;
		Connection conn = null;
		try { // ✅ Using centralized connection

			conn = srcdataSource.getConnection();
			conn.setAutoCommit(false);

			oracle.jdbc.OracleConnection oracleConn = (oracle.jdbc.OracleConnection) conn;

			StructDescriptor structDescriptor = StructDescriptor.createDescriptor("GENERAL_MASTER_OBJECT", oracleConn);

			ArrayDescriptor arrayDescriptor = ArrayDescriptor.createDescriptor("GENERAL_MASTER_UPLOAD_TABLE",
					oracleConn);
			String loadId = UUID.randomUUID().toString();
			for (int i = 0; i < generalDetail.size(); i += batchSize) {

				List<General_master_tb_pojo> batch = generalDetail.subList(i,
						Math.min(i + batchSize, generalDetail.size()));

				STRUCT[] structArray = new STRUCT[batch.size()];
				int idx = 0;

				for (General_master_tb_pojo pojo : batch) {

					Object[] attributes = new Object[] { pojo.getAcct_crncy_code(), pojo.getGl_sub_head_code(),
							pojo.getSchm_type(), pojo.getSchm_code(), pojo.getCust_id(), pojo.getAcct_number(),
							pojo.getAcct_name(), pojo.getReport_date(), pojo.getAcct_balance_amt_ac(), pojo.getAcid(),
							pojo.getSol_id(), pojo.getAcct_opn_date() };

					structArray[idx++] = new STRUCT(structDescriptor, oracleConn, attributes);
				}

				ARRAY oracleArray = new ARRAY(arrayDescriptor, oracleConn, structArray);

				CallableStatement cs = conn.prepareCall("{ ? = call SAVE_GENERAL_MASTER_DATA_UPLOAD_FN(?,?) }");

				cs.registerOutParameter(1, Types.NUMERIC);
				cs.setArray(2, oracleArray);
				cs.setString(3, loadId);
				cs.execute();

				totalInserted += cs.getInt(1);
				cs.close();
			}

			conn.commit();

		} catch (Exception e) {
			e.getSuppressed();
			e.printStackTrace();
			throw new RuntimeException("ERROR:Gam dump data upload failed", e);
			
		}

		return "Gam dump data Upload Complete. Inserted Rows: " + totalInserted;
	}
	
	public String UploadEabdata(MultipartFile file, String reportType, Date toDate) {

		List<Eod_acct_balance_pojo> EodDetail = new ArrayList<>();

		DateTimeFormatter formatter1 = new DateTimeFormatterBuilder().parseCaseInsensitive()
				.appendPattern("dd-MMM-yyyy").toFormatter(Locale.ENGLISH);

		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		// Step 1: Read file
		try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

			String line;
			String delimiter = "\\|";

			while ((line = br.readLine()) != null) {

				line = line.trim();
				if (line.isEmpty())
					continue;

				String upper = line.toUpperCase();
				if (upper.startsWith("SQL") || upper.startsWith("ACID") || upper.startsWith("--"))
					continue;

				String[] values = line.split(delimiter);

				if (values.length < 14)
					continue;

				Eod_acct_balance_pojo pojo = new Eod_acct_balance_pojo();

				pojo.setAcid(values[0].trim());
				pojo.setEod_date(java.sql.Date.valueOf(LocalDate.parse(values[1].trim(), formatter2)));
				pojo.setTran_date_bal(new BigDecimal(values[2].trim()));
				pojo.setTran_date_tot_tran(new BigDecimal(values[3].trim()));
				pojo.setValue_date_bal(new BigDecimal(values[4].trim()));
				pojo.setValue_date_tot_tran(new BigDecimal(values[5].trim()));
				pojo.setEnd_eod_date(java.sql.Date.valueOf(LocalDate.parse(values[6].trim(), formatter2)));
				pojo.setLchg_user_id(values[7].trim());
				pojo.setLchg_time(java.sql.Date.valueOf(LocalDate.parse(values[8].trim(), formatter2)));
				pojo.setRcre_user_id(values[9].trim());
				pojo.setRcre_time(java.sql.Date.valueOf(LocalDate.parse(values[10].trim(), formatter2)));
				pojo.setTs_cnt(values[11].trim());
				pojo.setEab_crncy_code(values[12].trim());
				pojo.setBank_id(values[13].trim());
				
				EodDetail.add(pojo);

			}

		} catch (Exception e) {
			throw new RuntimeException("ERROR: File reading failed", e);
		}

		int batchSize = 5000;
		int totalInserted = 0;
		Connection conn = null;
		try { // ✅ Using centralized connection

			conn = srcdataSource.getConnection();
			conn.setAutoCommit(false);

			oracle.jdbc.OracleConnection oracleConn = (oracle.jdbc.OracleConnection) conn;

			StructDescriptor structDescriptor = StructDescriptor.createDescriptor("EOD_ACCT_MASTER_OBJECT", oracleConn);

			ArrayDescriptor arrayDescriptor = ArrayDescriptor.createDescriptor("EOD_ACCT_MASTER_UPLOAD_TABLE",
					oracleConn);
			String loadId = UUID.randomUUID().toString();
			for (int i = 0; i < EodDetail.size(); i += batchSize) {

				List<Eod_acct_balance_pojo> batch = EodDetail.subList(i,
						Math.min(i + batchSize, EodDetail.size()));

				STRUCT[] structArray = new STRUCT[batch.size()];
				int idx = 0;

				for (Eod_acct_balance_pojo pojo : batch) {

					Object[] attributes = new Object[] {pojo.getAcid(),pojo.getEod_date(),pojo.getTran_date_bal(),pojo.getTran_date_tot_tran(),
							pojo.getValue_date_bal(),pojo.getValue_date_tot_tran(),pojo.getEnd_eod_date(),pojo.getLchg_user_id(),
							pojo.getLchg_time(),pojo.getRcre_user_id(),pojo.getRcre_time(),pojo.getTs_cnt(),pojo.getEab_crncy_code(),pojo.getBank_id()};

					structArray[idx++] = new STRUCT(structDescriptor, oracleConn, attributes);
				}

				ARRAY oracleArray = new ARRAY(arrayDescriptor, oracleConn, structArray);

				CallableStatement cs = conn.prepareCall("{ ? = call SAVE_EOD_ACCT_MASTER_DATA_UPLOAD_FN(?,?) }");

				cs.registerOutParameter(1, Types.NUMERIC);
				cs.setArray(2, oracleArray);
				cs.setString(3, loadId);
				cs.execute();

				totalInserted += cs.getInt(1);
				cs.close();
			}

			conn.commit();

		} catch (Exception e) {
			e.getSuppressed();
			e.printStackTrace();
			throw new RuntimeException("ERROR: Upload failed", e);

		}

		return "Upload Complete. Inserted Rows: " + totalInserted;
	}
	
	
	public String Uploadrwadata(MultipartFile file, String reportType, Date toDate, boolean forceUpload) throws Exception {

		String checkSql = "SELECT COUNT(*) FROM brf95_rwa_data_bill WHERE TRUNC(REPORT_DATE)=TRUNC(?)";

	    Integer count = jdbcTemplate.queryForObject(
	            checkSql,
	            Integer.class,
	            new java.sql.Date(toDate.getTime())
	    );

	    Date today = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	    // Block if past date uploaded
	    if (count != null && count > 0 && !sdf.format(today).equals(sdf.format(toDate))) {
	        throw new RuntimeException("Data already uploaded for report date : " + toDate);
	    }

	    // Today duplicate 
	    if (count != null && count > 0 && sdf.format(today).equals(sdf.format(toDate)) && !forceUpload) {
	        throw new RuntimeException("already uploaded");
	    }
	    // Today duplicate confirmed replace
	    if (count != null && count > 0 && forceUpload) {
	        String deleteSql = "DELETE FROM brf95_rwa_data_bill WHERE TRUNC(REPORT_DATE)=TRUNC(?)";
	        jdbcTemplate.update(deleteSql, new java.sql.Date(toDate.getTime()));
	    }

	    List<RT_Bank_bill_data_pojo> EodDetail = new ArrayList<>();

		DateTimeFormatter formatter1 = new DateTimeFormatterBuilder().parseCaseInsensitive()
				.appendPattern("dd-MMM-yyyy").toFormatter(Locale.ENGLISH);

		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		// Step 1: Read file
		try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

			String line;
			String delimiter = "\\|";

			while ((line = br.readLine()) != null) {

				line = line.trim();
				if (line.isEmpty())
					continue;

				String upper = line.toUpperCase();
				if (upper.startsWith("SQL") || upper.startsWith("SOL_") || upper.startsWith("SOL") || upper.startsWith("--"))
					continue;

				String[] values = line.split(delimiter);

				if (values.length < 14)
					continue;

				RT_Bank_bill_data_pojo pojo = new RT_Bank_bill_data_pojo();
				pojo.setReport_date(new java.sql.Date(toDate.getTime()));
				pojo.setSol_(values[0].trim());
				pojo.setCust_id(values[1].trim());
				pojo.setForacid(values[2].trim());
				pojo.setSub_head_gl_code(values[3].trim());
				pojo.setBill_id(values[4].trim());
				pojo.setBill_date(java.sql.Date.valueOf(LocalDate.parse(values[5].trim(), formatter2)));
				pojo.setDue_date(java.sql.Date.valueOf(LocalDate.parse(values[6].trim(), formatter2)));
				pojo.setBil(values[7].trim());
				pojo.setBill_os_amt(new BigDecimal(values[8].trim()));
				pojo.setBill_os_amt_aed(new BigDecimal(values[9].trim()));
				pojo.setDrawee_bank_code(values[10].trim());
				pojo.setBank_name(values[11].trim());
				pojo.setRw(values[12].trim());
				pojo.setBill_disc_rwa(new BigDecimal(values[13].trim()));
				
				
				EodDetail.add(pojo);

			}

		} catch (Exception e) {
			throw new RuntimeException("ERROR: Upload failed", e);
		}

		int batchSize = 5000;
		int totalInserted = 0;
		Connection conn = null;
		try { // ✅ Using centralized connection

			conn = srcdataSource.getConnection();
			conn.setAutoCommit(false);

			oracle.jdbc.OracleConnection oracleConn = (oracle.jdbc.OracleConnection) conn;

			StructDescriptor structDescriptor = StructDescriptor.createDescriptor("RWA_BILL_DATA_OBJECT", oracleConn);

			ArrayDescriptor arrayDescriptor = ArrayDescriptor.createDescriptor("RWA_BILL_DATA_UPLOAD_TABLE",
					oracleConn);
			String loadId = UUID.randomUUID().toString();
			for (int i = 0; i < EodDetail.size(); i += batchSize) {

				List<RT_Bank_bill_data_pojo> batch = EodDetail.subList(i,
						Math.min(i + batchSize, EodDetail.size()));

				STRUCT[] structArray = new STRUCT[batch.size()];
				int idx = 0;

				for (RT_Bank_bill_data_pojo pojo : batch) {

					Object[] attributes = new Object[] {pojo.getReport_date(),pojo.getSol_(),pojo.getCust_id(),pojo.getForacid(),pojo.getSub_head_gl_code(),
							pojo.getBill_id(),pojo.getBill_date(),pojo.getDue_date(),pojo.getBil(),pojo.getBill_os_amt(),
							pojo.getBill_os_amt_aed(),pojo.getDrawee_bank_code(),pojo.getBank_name(),pojo.getRw(),
							pojo.getBill_disc_rwa()};

					structArray[idx++] = new STRUCT(structDescriptor, oracleConn, attributes);
				}

				ARRAY oracleArray = new ARRAY(arrayDescriptor, oracleConn, structArray);

				CallableStatement cs = conn.prepareCall("{ ? = call SAVE_RWA_BILL_DATA_DATA_UPLOAD_FN(?,?) }");

				cs.registerOutParameter(1, Types.NUMERIC);
				cs.setArray(2, oracleArray);
				cs.setString(3, loadId);
				cs.execute();
				totalInserted += cs.getInt(1);
				cs.close();
			}

			conn.commit();
			String reportDateStr = new SimpleDateFormat("dd-MM-yyyy").format(toDate);

			auditservice.createBusinessAudit(reportDateStr,"UPLOAD",
			    "Regulatory_Data_Ingestion_RWA_BILL_DATA",  null,  "BRF95_RWA_DATA_BILL");
		} catch (Exception e) {
			e.getSuppressed();
			e.printStackTrace();
			 auditservice.createBusinessAudit(
				        new SimpleDateFormat("dd-MM-yyyy").format(toDate),
				        "UPLOAD_FAILED",
				        "Regulatory_Data_Ingestion_EAB_DATA",
				        null,
				        "EOD_ACCT_BALANCE"
				    );
			 throw new RuntimeException("ERROR: Upload failed", e);

		}

		return "Upload Complete. Inserted Rows: " + totalInserted;
	}
	

	// ================= FUNDED PROCESSING =================
	private String processFunded(BufferedReader br, Date toDate) throws Exception {

	    Date today = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	    boolean exists = fundRepo.existsReportDate(toDate) > 0;

	    // Block past duplicate upload
	    if (exists && !sdf.format(today).equals(sdf.format(toDate))) {
	        throw new RuntimeException("Data already uploaded for this report date : " + toDate);
	    }

	    // Allow overwrite for today
	    if (exists) {
	        fundRepo.deleteByReportDate(toDate);
	    }

	    List<RT_RWA_Fund_base_data_entity> fundList = new ArrayList<>();

	    String line;
	    int rowCount = 1;

	    while ((line = br.readLine()) != null) {

	        rowCount++;

	        if (line.trim().isEmpty())
	            continue;

	        String delimiter = line.contains("|") ? "\\|" : "\t";
	        String[] data = line.split(delimiter, -1);
	        
	        if (data[0].matches(".*[a-zA-Z].*") && data[1].matches(".*[a-zA-Z].*") && data[2].matches(".*[a-zA-Z].*") && data[3].matches(".*[a-zA-Z].*") && data[4].matches(".*[a-zA-Z].*")) {
	            continue;
	        }

	        if (data.length < 71) {
	            logger.warn("Skipped row {} : insufficient columns {}", rowCount, data.length);
	            continue;
	        }

	        try {

	            RT_RWA_Fund_base_data_entity ent = new RT_RWA_Fund_base_data_entity();

	            // Always use selected UI report date
	            ent.setReport_date(toDate);

	            ent.setMoc(parseDecimal(data[1]));
	            ent.setTerritory(data[2]);
	            ent.setBranch_name(data[3]);
	            ent.setCust_id(data[4]);
	            ent.setAccount_id(data[5].trim());
	            ent.setAccount_name(data[6]);
	            ent.setGl_code(data[7]);
	            ent.setGl_code_description(data[8]);
	            ent.setConst_id(data[9]);
	            ent.setConst_description(data[10]);
	            ent.setPurpose(data[11]);
	            ent.setPurpose_description(data[12]);
	            ent.setScheme(data[13]);
	            ent.setSchm_code_desc(data[14]);
	            ent.setNationality(data[15]);
	            ent.setLegal_entity(data[16]);
	            ent.setOpen_date(parseDateSafe(data[17]));
	            ent.setRwa_class(data[18]);
	            ent.setSub_class(data[19]);
	            ent.setNpa_date(parseDateSafe(data[20]));
	            ent.setInt_suspense(parseDecimal(data[21]));
	            ent.setTot_provision(parseDecimal(data[22]));
	            ent.setProv_pcnt(parseDecimal(data[23]));
	            ent.setCategory(data[24]);
	            ent.setSub_category(data[25]);
	            ent.setBs_turnover(parseDecimal(data[26]));
	            ent.setNet_worth(parseDecimal(data[27]));
	            ent.setReshdl_date(parseDateSafe(data[28]));
	            ent.setRes_sec_value(parseDecimal(data[29]));
	            ent.setLtv(data[30]);
	            ent.setGov_guarantee(parseDecimal(data[31]));
	            ent.setCurrency(data[32]);
	            ent.setLimit(parseDecimal(data[33]));
	            ent.setBalance(parseDecimal(data[34]));
	            ent.setExposure(parseDecimal(data[35]));
	            ent.setSecurity_fdr(parseDecimal(data[36]));
	            ent.setFdr_currency(data[37]);
	            ent.setAdjusted_fdr(parseDecimal(data[38]));
	            ent.setCrm(parseDecimal(data[39]));
	            ent.setCrm_adj_bal(parseDecimal(data[40]));
	            ent.setCrm_gnt_adj_bal(parseDecimal(data[41]));
	            ent.setRw(parseDecimal(data[42]));
	            ent.setRwa(parseDecimal(data[43]));
	            ent.setBill_amount(parseDecimal(data[44]));
	            ent.setBill_disc_rwa(parseDecimal(data[45]));
	            ent.setTotal_drawn_rwa(parseDecimal(data[46]));
	            ent.setBill_disc_dtls(data[47]);
	            ent.setConditional_cancel(data[48]);
	            ent.setUndrwn_balance(parseDecimal(data[49]));
	            ent.setDisb_amt1(parseDecimal(data[50]));
	            ent.setDisb_amt2(parseDecimal(data[51]));
	            ent.setLoan_disb_amt(parseDecimal(data[52]));
	            ent.setUndrwn_ccf(parseDecimal(data[53]));
	            ent.setUndrwn_crm(parseDecimal(data[54]));
	            ent.setUndrwn_ccf_balance(parseDecimal(data[55]));
	            ent.setUndrwn_rwa(parseDecimal(data[56]));
	            //ent.setUndrwn_disb(data[57]);
	            ent.setUndrwn_disb(trimToLength(data[57], 10));
	            ent.setAc_rwp(parseDecimal(data[58]));

	            ent.setRating(data[59]);
	            ent.setRating_date(parseDateSafe(data[61]));
	            ent.setRating_expiry(parseDateSafe(data[62]));
	            ent.setPan_number(data[63]);
	            ent.setInd_report_order(parseDecimal(data[64]));
	            ent.setInd_desc(data[65]);
	            ent.setInt_rate(parseDecimal(data[66]));
	            ent.setNo_of_employees(parseDecimal(data[67]));
	            ent.setInt_tbl_code(data[68]);
	            ent.setMaturity_date(parseDateSafe(data[69]));
	            ent.setFrequency(data[70]);

	            fundList.add(ent);

	        } catch (Exception e) {
	            logger.error("Error at Funded Row {} : {}", rowCount, e.getMessage());
	        }
	    }

	    logger.info("Total Fund rows parsed: {}", fundList.size());
	    
	    String reportDateStr = new SimpleDateFormat("dd-MM-yyyy").format(toDate);
        auditservice.createBusinessAudit(  reportDateStr, "UPLOAD",  "Regulatory_Data_Ingestion_RWA_FUNDDATA", null,
                "BRF95_RWA_DATA_FUNDBASED");
	    
	    if (!fundList.isEmpty()) {
	        fundRepo.saveAll(fundList);
	        fundRepo.flush();
	    }

	    return "Funded: Successfully uploaded " + fundList.size() + " records.";
	}

	public void deleteBillDataByReportDate(Date reportDate) {
	    if (reportDate == null) {
	        throw new RuntimeException("Report date is required.");
	    }
	    jdbcTemplate.update(
	            "DELETE FROM brf95_rwa_data_bill WHERE TRUNC(REPORT_DATE)=TRUNC(?)",
	            new java.sql.Date(reportDate.getTime()));
	}

	public void deleteGamDataByReportDate(Date reportDate) {
	    if (reportDate == null) {
	        throw new RuntimeException("Report date is required.");
	    }
	    jdbcTemplate.update(
	            "DELETE FROM GENERAL_MASTER_TB WHERE TRUNC(REPORT_DATE)=TRUNC(?)",
	            new java.sql.Date(reportDate.getTime()));
	}

	public void deleteEabDataByReportDate(Date reportDate) {
	    if (reportDate == null) {
	        throw new RuntimeException("Report date is required.");
	    }
	    jdbcTemplate.update(
	            "DELETE FROM EOD_ACCT_BALANCE WHERE TRUNC(EOD_DATE)=TRUNC(?)",
	            new java.sql.Date(reportDate.getTime()));
	}

	// ================= UTIL METHODS =================

	private BigDecimal parseDecimal(String val) {
		if (val == null || val.trim().isEmpty() || val.equalsIgnoreCase("NULL") || val.equals(".")
				|| val.equals("PJSC")) {
			return BigDecimal.ZERO;
		}
		try {
			return new BigDecimal(val.trim().replace(",", ""));
		} catch (Exception e) {
			return BigDecimal.ZERO;
		}
	}

	private Date parseDateSafe(String val) {
		if (val == null || val.trim().isEmpty() || val.equalsIgnoreCase("NULL"))
			return null;
		String s = val.trim();
		try {
			// Handles both 30-11-25 and 30-11-2025
			if (s.length() <= 8) {
				return new SimpleDateFormat("dd-MM-yy").parse(s);
			}
			return new SimpleDateFormat("dd-MM-yyyy").parse(s);
		} catch (Exception e) {
			return null;
		}
	}
	private String trimToLength(String value, int len) {
	    if (value == null) return null;
	    value = value.trim();
	    return value.length() > len ? value.substring(0, len) : value;
	}
}