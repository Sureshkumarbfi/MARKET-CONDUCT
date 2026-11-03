package com.bornfire.xbrl.services;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bornfire.xbrl.Exception.MISException;
import com.bornfire.xbrl.entities.ASL_Report_Entity;
import com.bornfire.xbrl.entities.ASL_Report_Rep;
import com.bornfire.xbrl.entities.AuditServicesEntity;
import com.bornfire.xbrl.entities.AuditServicesRep;
import com.bornfire.xbrl.entities.BRF39_ENTITYREP;
import com.bornfire.xbrl.entities.Counterparty_Entity;
import com.bornfire.xbrl.entities.Counterparty_Rep;
import com.bornfire.xbrl.entities.Limit_Request_Entity;
import com.bornfire.xbrl.entities.Limit_Request_Rep;
import com.bornfire.xbrl.entities.MIS_SETTLEMENT_ENTITY;
import com.bornfire.xbrl.entities.MIS_SETTLEMENT_ENTITY_REP;
import com.bornfire.xbrl.entities.MIS_TREASURY_LIMITS_ENTITY;
import com.bornfire.xbrl.entities.MIS_TREASURY_PLACEMENT_ENTITY;
import com.bornfire.xbrl.entities.Mis_exposure_bill_detail_entity;
import com.bornfire.xbrl.entities.Mis_exposure_bill_detail_rep;
import com.bornfire.xbrl.entities.Mis_exposure_bank_name_map_entity;
import com.bornfire.xbrl.entities.Mis_exposure_bank_name_map_rep;
import com.bornfire.xbrl.entities.Mis_treasury_placement_repo;
import com.bornfire.xbrl.entities.UserProfile;
import com.bornfire.xbrl.entities.UserProfileRep;

@Service
@Transactional
public class counter_services {
	private static final Logger logger = LoggerFactory.getLogger(counter_services.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	AuditService auditservice;
	@Autowired
	Limit_Request_Rep limit_request_rep;
	@Autowired
	UserProfileRep UserProfileReps;
	@Autowired
	MIS_SETTLEMENT_ENTITY_REP MIS_SETTLEMENT_ENTITY_REPs;
	@Autowired
	Counterparty_Rep Counterparty_Reps;
	@Autowired
	private BRF39_ENTITYREP brf39_entityrep;
	@Autowired
	ASL_Report_Rep ASL_Report_Reps;
	@Autowired
	Mis_treasury_placement_repo TreasuryPlacementReps;
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	Mis_exposure_bill_detail_rep Mis_exposure_bill_detail_rep;

	@Autowired
	Mis_exposure_bank_name_map_rep Mis_exposure_bank_name_map_rep;
	
	@Autowired
	AuditServicesRep auditServicesRep;

	public String addcunter(Counterparty_Entity as, String userid, String formmode, String roleId, String remarks) {
		String msg = "";

		try {
			Session hs = sessionFactory.getCurrentSession();

			if ("deleterequest".equalsIgnoreCase(formmode)) {
				msg = requestCounterpartyDelete(as, userid, roleId, remarks, hs);
			} else if ("approvedelete".equalsIgnoreCase(formmode)) {
				msg = approveCounterpartyDelete(as, userid, roleId, hs);
			} else if ("rejectdelete".equalsIgnoreCase(formmode)) {
				msg = rejectCounterpartyDelete(as, userid, roleId, remarks, hs);
			} else if ("delete".equalsIgnoreCase(formmode)) {
				msg = deleteCounterpartyDirect(as, userid, roleId, hs);
			} else if ("edit".equalsIgnoreCase(formmode)) {
				Counterparty_Entity dbUser = Counterparty_Reps.getBYID(as.getId());
				System.out.println("old" + dbUser.getRating());
				Counterparty_Entity old = Counterparty_Reps.getBYID(as.getId());

				if (old != null) {
					if (isDeletePending(old)) {
						msg = "Cannot modify. A delete request is pending for this CounterParty Bank";
					} else {

					List<String> ignoreFields = Arrays.asList("createUser", "modifyUser", "delFlg",
							"deleteRequestStatus", "deleteRemarks", "deleteRequestedBy", "deleteRequestedAt",
							"deleteApprovedBy", "deleteApprovedAt");

					Map<String, String> changes = new LinkedHashMap<>();

					for (Field field : Counterparty_Entity.class.getDeclaredFields()) {
						field.setAccessible(true);
						try {
							Object oldValue = field.get(dbUser);
							Object newValue = field.get(as);
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
					auditservice.createBusinessAudit(userid, "MODIFY", "CounterParty Bank-Modify", changes,
							"MIS_COUNTER_PARTY_TABLE");

					old.setCounterPartyBankCode(as.getCounterPartyBankCode());
					old.setCounterPartyBank(as.getCounterPartyBank());
					old.setLocation(as.getLocation());
					old.setExpiryDate(as.getExpiryDate());
					old.setRating(as.getRating());
					old.setRegularLimit(as.getRegularLimit());
					old.setAdhocLimit(as.getAdhocLimit());
					old.setCreditLimit(as.getCreditLimit());
					old.setSettlementLimit(as.getSettlementLimit());
					old.setMoneyMarketLimit(as.getMoneyMarketLimit());
					old.setTradeFinanceLimit(as.getTradeFinanceLimit());
					old.setAdhoc_Limit_exp_date(as.getAdhoc_Limit_exp_date());
					old.setModifyUser(userid);
					old.setEarmarkinglimit(as.getEarmarkinglimit());
					old.setEarmarkingdate(as.getEarmarkingdate());
					old.setCountryRating(as.getCountryRating());
					System.out.println("as.getEarmarkinglimit=" + as.getEarmarkinglimit());

					hs.update(old);
					msg = "CounterParty Bank Updated Successfully";
					}
				} else {
					msg = "Record not found for update";
				}

			} else {
				BigDecimal id = (BigDecimal) hs.createNativeQuery("SELECT COUNTERPARTY_ID.NEXTVAL FROM DUAL")
						.getSingleResult();
				as.setId(id.longValue());
				as.setCreateUser(userid);
				as.setDelFlg("N");
				as.setCounterpartyCreatedDate(new Date());

				Counterparty_Entity newdata = new Counterparty_Entity();
				Map<String, String> changes = new LinkedHashMap<>();

				for (Field field : Counterparty_Entity.class.getDeclaredFields()) {
					field.setAccessible(true);
					try {
						Object oldValue = field.get(newdata);
						Object newValue = field.get(as);
						if ((oldValue == null || oldValue.toString().trim().isEmpty())
								&& (newValue == null || newValue.toString().trim().isEmpty())) {
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
							field.set(newdata, newValue);
						}

					} catch (IllegalAccessException e) {
						System.err.println("Access error for field: " + field.getName() + " - " + e.getMessage());
					}
				}
				auditservice.createBusinessAudit(userid, "ADD", "Counterparty Bank-Add", changes,
						"MIS_COUNTER_PARTY_TABLE");

				hs.save(as);
				msg = "CounterParty Bank Added Successfully";
			}

		} catch (Exception e) {
			msg = "Kindly check the data / Please contact Administrator";
			e.printStackTrace();
		}

		return msg;
	}

	public boolean isDeleteRequester(String roleId) {
		return "USR-C".equalsIgnoreCase(roleId) || "USR-M".equalsIgnoreCase(roleId);
	}

	public boolean isDeleteApprover(String roleId) {
		return "ADM-C".equalsIgnoreCase(roleId) || "ADM-M".equalsIgnoreCase(roleId)
				|| "MGR".equalsIgnoreCase(roleId);
	}

	public Map<String, Object> getDeleteRequestDetails(Long id) {
		Map<String, Object> details = new LinkedHashMap<>();
		if (id == null) {
			details.put("error", "ID is required");
			return details;
		}
		Counterparty_Entity existing = Counterparty_Reps.getBYID(id);
		if (existing == null) {
			details.put("error", "Record not found");
			return details;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		details.put("id", existing.getId());
		details.put("srlNo", existing.getSrlNo());
		details.put("counterPartyBank", existing.getCounterPartyBank());
		details.put("counterPartyBankCode", existing.getCounterPartyBankCode());
		details.put("location", existing.getLocation());
		details.put("rating", existing.getRating());
		details.put("deleteRequestStatus", existing.getDeleteRequestStatus());
		details.put("deleteRemarks", existing.getDeleteRemarks());
		details.put("deleteRequestedBy", existing.getDeleteRequestedBy());
		details.put("deleteRequestedAt",
				existing.getDeleteRequestedAt() != null ? sdf.format(existing.getDeleteRequestedAt()) : "");
		details.put("deleteApprovedBy", existing.getDeleteApprovedBy());
		details.put("deleteApprovedAt",
				existing.getDeleteApprovedAt() != null ? sdf.format(existing.getDeleteApprovedAt()) : "");
		return details;
	}

	private boolean isDeletePending(Counterparty_Entity existing) {
		return existing != null && "PENDING".equalsIgnoreCase(existing.getDeleteRequestStatus());
	}

	private String requestCounterpartyDelete(Counterparty_Entity as, String userid, String roleId, String remarks,
			Session hs) {
		if (!isDeleteRequester(roleId)) {
			return "Only USR-C / USR-M can raise a delete request";
		}
		if (as.getId() == null) {
			return "ID is required for deletion";
		}
		Counterparty_Entity existing = Counterparty_Reps.getBYID(as.getId());
		if (existing == null) {
			return "Record not found for delete request";
		}
		if (isDeletePending(existing)) {
			return "A delete request is already pending for this CounterParty Bank";
		}
		if (remarks == null || remarks.trim().isEmpty()) {
			return "Delete remarks are required";
		}
		if (remarks.trim().length() < 10) {
			return "Delete remarks must be at least 10 characters";
		}

		Map<String, String> changes = new LinkedHashMap<>();
		changes.put("deleteRequestStatus", "OldValue: " + existing.getDeleteRequestStatus() + ", NewValue: PENDING");
		changes.put("id", String.valueOf(existing.getId()));
		changes.put("counterPartyBank", existing.getCounterPartyBank());
		changes.put("deleteRequestedBy", userid);
		changes.put("deleteRemarks", remarks.trim());
		auditservice.createBusinessAudit(userid, "DELETE_REQUEST", "CounterParty Bank-Delete Request", changes,
				"MIS_COUNTER_PARTY_TABLE");

		existing.setDeleteRequestStatus("PENDING");
		existing.setDeleteRemarks(remarks.trim());
		existing.setDeleteRequestedBy(userid);
		existing.setDeleteRequestedAt(new Date());
		existing.setDeleteApprovedBy(null);
		existing.setDeleteApprovedAt(null);
		existing.setModifyUser(userid);
		hs.update(existing);
		return "Delete request submitted successfully. Waiting for approver confirmation.";
	}

	private String approveCounterpartyDelete(Counterparty_Entity as, String userid, String roleId, Session hs) {
		if (!isDeleteApprover(roleId)) {
			return "Only ADM-C / ADM-M / MGR can approve a delete request";
		}
		if (as.getId() == null) {
			return "ID is required for deletion";
		}
		Counterparty_Entity existing = Counterparty_Reps.getBYID(as.getId());
		if (existing == null) {
			return "Record not found for delete approval";
		}
		if (!isDeletePending(existing)) {
			return "No pending delete request found for this CounterParty Bank";
		}

		Map<String, String> changes = new LinkedHashMap<>();
		changes.put("delFlg", "OldValue: " + existing.getDelFlg() + ", NewValue: Y");
		changes.put("deleteRequestStatus", "OldValue: PENDING, NewValue: DELETED");
		changes.put("id", String.valueOf(existing.getId()));
		changes.put("counterPartyBank", existing.getCounterPartyBank());
		changes.put("deleteRequestedBy", existing.getDeleteRequestedBy());
		changes.put("deleteApprovedBy", userid);
		auditservice.createBusinessAudit(userid, "DELETE_APPROVE", "CounterParty Bank-Delete Approve", changes,
				"MIS_COUNTER_PARTY_TABLE");

		existing.setDelFlg("Y");
		existing.setDeleteRequestStatus("DELETED");
		existing.setDeleteApprovedBy(userid);
		existing.setDeleteApprovedAt(new Date());
		existing.setModifyUser(userid);
		hs.update(existing);
		return "Delete request approved. CounterParty Bank Deleted Successfully";
	}

	private String rejectCounterpartyDelete(Counterparty_Entity as, String userid, String roleId, String remarks,
			Session hs) {
		if (!isDeleteApprover(roleId)) {
			return "Only ADM-C / ADM-M / MGR can reject a delete request";
		}
		if (as.getId() == null) {
			return "ID is required for rejection";
		}
		Counterparty_Entity existing = Counterparty_Reps.getBYID(as.getId());
		if (existing == null) {
			return "Record not found for delete rejection";
		}
		if (!isDeletePending(existing)) {
			return "No pending delete request found for this CounterParty Bank";
		}
		if (remarks == null || remarks.trim().isEmpty()) {
			return "Reject remarks are required";
		}
		if (remarks.trim().length() < 10) {
			return "Reject remarks must be at least 10 characters";
		}

		String originalRemarks = existing.getDeleteRemarks() != null ? existing.getDeleteRemarks() : "";
		String combinedRemarks = originalRemarks;
		if (!combinedRemarks.isEmpty()) {
			combinedRemarks = combinedRemarks + " | Rejected: " + remarks.trim();
		} else {
			combinedRemarks = "Rejected: " + remarks.trim();
		}

		Map<String, String> changes = new LinkedHashMap<>();
		changes.put("deleteRequestStatus", "OldValue: PENDING, NewValue: REJECTED");
		changes.put("id", String.valueOf(existing.getId()));
		changes.put("counterPartyBank", existing.getCounterPartyBank());
		changes.put("deleteRequestedBy", existing.getDeleteRequestedBy());
		changes.put("rejectedBy", userid);
		changes.put("rejectRemarks", remarks.trim());
		auditservice.createBusinessAudit(userid, "DELETE_REJECT", "CounterParty Bank-Delete Reject", changes,
				"MIS_COUNTER_PARTY_TABLE");

		existing.setDelFlg("N");
		existing.setDeleteRequestStatus("REJECTED");
		existing.setDeleteRemarks(combinedRemarks);
		existing.setDeleteApprovedBy(userid);
		existing.setDeleteApprovedAt(new Date());
		existing.setModifyUser(userid);
		hs.update(existing);
		return "Delete request rejected successfully";
	}

	private String deleteCounterpartyDirect(Counterparty_Entity as, String userid, String roleId, Session hs) {
		if (!isDeleteApprover(roleId)) {
			return "Only ADM-C / ADM-M / MGR can delete. USR-C / USR-M must raise a delete request";
		}
		if (as.getId() == null) {
			return "ID is required for deletion";
		}
		Counterparty_Entity existing = Counterparty_Reps.getBYID(as.getId());
		if (existing == null) {
			return "Record not found for delete";
		}
		if (isDeletePending(existing)) {
			return approveCounterpartyDelete(as, userid, roleId, hs);
		}

		Map<String, String> changes = new LinkedHashMap<>();
		changes.put("delFlg", "OldValue: " + existing.getDelFlg() + ", NewValue: Y");
		changes.put("id", String.valueOf(existing.getId()));
		changes.put("counterPartyBank", existing.getCounterPartyBank());
		auditservice.createBusinessAudit(userid, "DELETE", "CounterParty Bank-Delete", changes,
				"MIS_COUNTER_PARTY_TABLE");

		existing.setDelFlg("Y");
		existing.setDeleteRequestStatus("DELETED");
		existing.setDeleteApprovedBy(userid);
		existing.setDeleteApprovedAt(new Date());
		existing.setModifyUser(userid);
		hs.update(existing);
		return "CounterParty Bank Deleted Successfully";
	}

	public List<Map<String, Object>> getSwap() {
		logger.info("Fetching swap settlement data...");

		Date currentDate = new Date(); // current system date
		List<Map<String, Object>> formattedList = new ArrayList<>();

		try {

			LocalDate today = LocalDate.now();
			java.sql.Date sqlDate = java.sql.Date.valueOf(today);
			List<MIS_SETTLEMENT_ENTITY> deals = MIS_SETTLEMENT_ENTITY_REPs.getAllListByDate(sqlDate);

			logger.info("Number of settlement records fetched: {}", deals.size());

			DecimalFormat decimalFormat = new DecimalFormat("#.00");

			for (MIS_SETTLEMENT_ENTITY entity : deals) {
				Map<String, Object> map = new HashMap<>();
				map.put("counterpartyName", entity.getCounterpartyName() != null ? entity.getCounterpartyName() : "");
				map.put("reportDate", entity.getReportDate() != null ? entity.getReportDate() : null);

				map.put("dealId", entity.getDealId() != null ? entity.getDealId() : null);
				map.put("amount1", entity.getAmount1() != null ? decimalFormat.format(entity.getAmount1()) : "0.00");
				map.put("amount2", entity.getAmount2() != null ? decimalFormat.format(entity.getAmount2()) : "0.00");
				map.put("rateOrPrice",
						entity.getRateOrPrice() != null ? decimalFormat.format(entity.getRateOrPrice()) : "0.00");
				map.put("security", entity.getSecurity() != null ? entity.getSecurity() : null);
				map.put("tradeDate", entity.getTradeDate() != null ? entity.getTradeDate() : null);
				map.put("valueDate", entity.getValueDate() != null ? entity.getValueDate() : null);
				map.put("counterpartyCode", entity.getCounterpartyCode() != null ? entity.getCounterpartyCode() : null);

				map.put("amount", entity.getAmount() != null ? decimalFormat.format(entity.getAmount()) : "0.00");
				map.put("residualMaturity",
						entity.getResidualMaturity() != null ? entity.getResidualMaturity() : "0.00");
				map.put("maturityDate", entity.getMaturityDate() != null ? entity.getMaturityDate() : null);
				map.put("ccf", entity.getCcf() != null ? entity.getCcf() : "0.00");

				formattedList.add(map);
			}

			logger.info("Formatted {} settlement records", formattedList.size());
		} catch (Exception e) {
			logger.error("Error while fetching or formatting swap settlement data", e);
		}

		return formattedList;
	}

	public List<Map<String, Object>> getExploreData(Date reportDate, String selected_branch) {
		logger.info("Starting to fetch explore data for reportDate: {} and branch: {}", reportDate, selected_branch);

		List<Map<String, Object>> result = new ArrayList<>();
		try {
			List<ASL_Report_Entity> list = ASL_Report_Reps.getByReportDateBranch(reportDate, selected_branch);
			logger.info("Number of records retrieved from repository: {}", list.size());

			result = list.stream().map(item -> {
				Map<String, Object> row = new HashMap<>();

				// Format Report Date
				LocalDate localDate = item.getReportDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				row.put("formattedDate", localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
				row.put("counterpartyBankName",
						item.getCounterpartyBankName() != null ? item.getCounterpartyBankName() : "");
				row.put("buyersCredit", item.getBuyersCredit() != null ? item.getBuyersCredit() : "");
				row.put("foreignBillDiscounting",
						item.getForeignBillDiscounting() != null ? item.getForeignBillDiscounting() : "");
				row.put("localBillDiscounting",
						item.getLocalBillDiscounting() != null ? item.getLocalBillDiscounting() : "");
				row.put("guaranteeSblcs", item.getGuaranteeSblcs() != null ? item.getGuaranteeSblcs() : "");
				row.put("syndicatedLoansInvestment",
						item.getSyndicatedLoansInvestment() != null ? item.getSyndicatedLoansInvestment() : "");
				row.put("others", item.getOthers() != null ? item.getOthers() : "");
				row.put("remarks", item.getRemarks() != null ? item.getRemarks() : "");
				row.put("total", item.getTotal() != null ? item.getTotal() : "");
				row.put("iBranchCode", item.getiBranchCode() != null ? item.getiBranchCode() : "");
				row.put("iBranchName", item.getiBranchName() != null ? item.getiBranchName() : "");

				return row;
			}).collect(Collectors.toList());

			logger.info("Successfully mapped {} records to response format", result.size());
		} catch (Exception e) {
			logger.error("Error occurred while fetching explore data for date: {} and branch: {}", reportDate,
					selected_branch, e);
		}

		return result;
	}

	public List<Map<String, Object>> getExploreDataBranch(String selected_branch) {

		Logger logger = LoggerFactory.getLogger(this.getClass());
		logger.info("Fetching Explore Data for branch: {}", selected_branch);

		List<Map<String, Object>> result = new ArrayList<>();

		try {
			List<ASL_Report_Entity> list = ASL_Report_Reps.getByReportDateBranch(selected_branch);
			logger.info("Retrieved {} records for branch: {}", list.size(), selected_branch);

			result = list.stream().map(item -> {
				Map<String, Object> row = new HashMap<>();
				LocalDate localDate = item.getReportDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

				row.put("formattedDate", localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
				row.put("counterpartyBankName",
						item.getCounterpartyBankName() != null ? item.getCounterpartyBankName() : "");
				row.put("buyersCredit", item.getBuyersCredit() != null ? item.getBuyersCredit() : "");
				row.put("foreignBillDiscounting",
						item.getForeignBillDiscounting() != null ? item.getForeignBillDiscounting() : "");
				row.put("localBillDiscounting",
						item.getLocalBillDiscounting() != null ? item.getLocalBillDiscounting() : "");
				row.put("guaranteeSblcs", item.getGuaranteeSblcs() != null ? item.getGuaranteeSblcs() : "");
				row.put("syndicatedLoansInvestment",
						item.getSyndicatedLoansInvestment() != null ? item.getSyndicatedLoansInvestment() : "");
				row.put("others", item.getOthers() != null ? item.getOthers() : "");
				row.put("remarks", item.getRemarks() != null ? item.getRemarks() : "");
				row.put("total", item.getTotal() != null ? item.getTotal() : "");
				row.put("iBranchCode", item.getiBranchCode() != null ? item.getiBranchCode() : "");
				row.put("iBranchName", item.getiBranchName() != null ? item.getiBranchName() : "");

				return row;
			}).collect(Collectors.toList());

		} catch (Exception e) {
			logger.error("Error fetching Explore Data for branch: {}", selected_branch, e);
		}

		return result;
	}

	public List<Map<String, Object>> loadOverallTop10BRF39Data() {
		List<Map<String, Object>> responseData = new ArrayList<>();

		try {
			logger.info("Entered loadOverallTop10BRF39Data method.");

			List<Object[]> results = brf39_entityrep.top10Bank();
			logger.info("Fetched top 10 bank records: {}", results.size());

			for (Object[] row : results) {
				Map<String, Object> record = new HashMap<>();
				record.put("name_of_borrower", row[0]);
				record.put("borrower_type", row[1]);
				record.put("residency_status", row[2]);
				record.put("country", row[3]);
				record.put("economic_status", row[4]);
				record.put("currency", row[5]);
				record.put("funded_os", row[6]);
				responseData.add(record);
			}

			logger.info("Prepared response data with {} records", responseData.size());

		} catch (Exception e) {
			logger.error("Exception occurred in loadOverallTop10BRF39Data: {}", e.getMessage(), e);
		}

		return responseData;
	}

	public List<Map<String, Object>> getTre_limit_Datas(Date reportDate) {

		Logger logger = LoggerFactory.getLogger(this.getClass());
		logger.info("Fetching Treasury Limit Data for report date: {}", reportDate);

		List<Map<String, Object>> result = new ArrayList<>();

		try {
			List<MIS_TREASURY_LIMITS_ENTITY> deals = entityManager
					.createQuery("SELECT d FROM MIS_TREASURY_LIMITS_ENTITY d WHERE d.reportDate = :reportDate",
							MIS_TREASURY_LIMITS_ENTITY.class)
					.setParameter("reportDate", reportDate).getResultList();

			logger.info("Retrieved {} records for Treasury Limits", deals.size());

			result = deals.stream().map(item -> {
				Map<String, Object> row = new HashMap<>();
				java.sql.Date sqlDate = (java.sql.Date) item.getReportDate();
				LocalDate localDate = sqlDate.toLocalDate();

				row.put("formattedDate", localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
				row.put("bankName", item.getBankName());
				row.put("counterparty", item.getCounterparty());
				row.put("amtAed", item.getAmtAed());
				row.put("amtGbp", item.getAmtGbp());
				row.put("amtUsd", item.getAmtUsd());
				row.put("amtEur", item.getAmtEur());
				row.put("inUsdMn", item.getInUsdMn());

				return row;
			}).collect(Collectors.toList());

		} catch (Exception e) {
			logger.error("Error while fetching Treasury Limit Data for report date: {}", reportDate, e);
		}

		return result;
	}

	public List<Map<String, Object>> getSwap_Datas(Date reportDate) {
		DecimalFormat decimalFormat = new DecimalFormat("#.00"); // Always show 2 decimal places

		Logger logger = LoggerFactory.getLogger(this.getClass());
		logger.info("Fetching Swap Settlement Data for report date: {}", reportDate);

		List<MIS_SETTLEMENT_ENTITY> deals = new ArrayList<>();

		try {
			deals = entityManager.createQuery("SELECT d FROM MIS_SETTLEMENT_ENTITY d WHERE d.reportDate = :reportDate",
					MIS_SETTLEMENT_ENTITY.class).setParameter("reportDate", reportDate).getResultList();

			logger.info("Found {} Swap Settlement records for report date {}", deals.size(), reportDate);

		} catch (Exception e) {
			logger.error("Error while fetching Swap Settlement data for report date: {}", reportDate, e);
		}

		return deals.stream().map(item -> {
			Map<String, Object> row = new HashMap<>();
			java.sql.Date sqlDate = (java.sql.Date) item.getReportDate();
			LocalDate localDate = sqlDate.toLocalDate();

			java.sql.Date sqlDate1 = (java.sql.Date) item.getMaturityDate();
			LocalDate localDate1 = sqlDate1.toLocalDate();

			row.put("formattedDate", localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

			row.put("dealId", item.getDealId() != null ? item.getDealId() : null);
			row.put("amount1", item.getAmount1() != null ? decimalFormat.format(item.getAmount1()) : "0.00");
			row.put("amount2", item.getAmount2() != null ? decimalFormat.format(item.getAmount2()) : "0.00");
			row.put("rateOrPrice",
					item.getRateOrPrice() != null ? decimalFormat.format(item.getRateOrPrice()) : "0.00");
			row.put("security", item.getSecurity() != null ? item.getSecurity() : null);
			row.put("tradeDate", item.getTradeDate() != null ? item.getTradeDate() : null);
			row.put("valueDate", item.getValueDate() != null ? item.getValueDate() : null);
			row.put("counterpartyCode", item.getCounterpartyCode() != null ? item.getCounterpartyCode() : null);

			row.put("counterpartyName", item.getCounterpartyName());
			row.put("amount", item.getAmount() != null ? decimalFormat.format(item.getAmount()) : "0.00");
			row.put("residualMaturity",
					item.getResidualMaturity() != null ? decimalFormat.format(item.getResidualMaturity()) : "0.00");
			row.put("maturityDate", localDate1.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			row.put("ccf", item.getCcf());

			return row;
		}).collect(Collectors.toList());
	}

	public List<Map<String, Object>> getcounterpartylist() {
		List<Map<String, Object>> responseData = new ArrayList<>();

		try {
			logger.info("Entered getcounterpartylist method.");

			List<Counterparty_Entity> results = Counterparty_Reps.getalllist();
			logger.info("Fetched all records: {}", results.size());

			for (Counterparty_Entity up : results) {
				Map<String, Object> record = new HashMap<>();
				record.put("counterPartyBank", up.getCounterPartyBank());
				record.put("regularLimit", up.getRegularLimit());
				record.put("adhocLimit", up.getAdhocLimit());
				record.put("Adhoc_Limit_exp_date", up.getAdhoc_Limit_exp_date());
				responseData.add(record);
			}

			logger.info("Prepared response data with {} records", responseData.size());

		} catch (Exception e) {
			logger.error("Exception occurred in loadOverallTop10BRF39Data: {}", e.getMessage(), e);
		}

		return responseData;
	}

	public String getbranch(String code) {
		System.out.println("code is" + code);
		List<UserProfile> branches = UserProfileReps.getallbranches();
		if (branches == null || branches.isEmpty()) {
			return "";
		}

		for (UserProfile branch : branches) {
			String branchCode = branch.getBranch_code();
			String branchName = branch.getBranch_name();

			if (branchCode != null && branchCode.equalsIgnoreCase(code)) {
				return (branchName != null) ? branchName : "";
			}
		}

		return ""; // or "Not Found"
	}

	public String Exposurebillservice(Mis_exposure_bill_detail_entity incomingEntity, String formMode,
			HttpServletRequest request) {

		incomingEntity.setDel_flg("N");
		String responseMsg = "";

		if ("Editbilldetail".equalsIgnoreCase(formMode)) {

			
			Optional<Mis_exposure_bill_detail_entity> optionalExisting = Mis_exposure_bill_detail_rep
					.checkvalueispresent(incomingEntity.getSrl_no());

			if (optionalExisting.isPresent()) {
				Mis_exposure_bill_detail_entity existingEntity = optionalExisting.get();

				incomingEntity.setModify_flg("Y");
				incomingEntity.setVerify_flg("N");
				incomingEntity.setModify_user((String) request.getSession().getAttribute("USERID"));
				incomingEntity.setModify_time(new Date());
				
				Map<String, String> auditMap = Auditservice(existingEntity, incomingEntity);
				
				auditservice.createBusinessAudit((String) request.getSession().getAttribute("USERID"), "Modify", "Bill Entry Modify", auditMap,
						"MIS_ASL_EXPOSURE_BILL_DETAIL_TABLE");

				
				existingEntity.setBranch_name(incomingEntity.getBranch_name());
				existingEntity.setCountry(incomingEntity.getCountry());
				existingEntity.setDate_of_loan(incomingEntity.getDate_of_loan());
				existingEntity.setTrade_loan_amt_usd(incomingEntity.getTrade_loan_amt_usd());
				existingEntity.setTrade_loan_amt_eq_aed(incomingEntity.getTrade_loan_amt_eq_aed());
				existingEntity.setInterest_rate(incomingEntity.getInterest_rate());
				existingEntity.setDue_date(incomingEntity.getDue_date());
				String previousBankName = existingEntity.getName_of_the_bank();
				String updatedBankName = incomingEntity.getName_of_the_bank();
				existingEntity.setName_of_the_bank(updatedBankName);
				saveBankNameMappingIfChanged(previousBankName, updatedBankName, incomingEntity.getSrl_no(),
						(String) request.getSession().getAttribute("USERID"));
				existingEntity.setBill_id(incomingEntity.getBill_id());
				existingEntity.setCustomer_name(incomingEntity.getCustomer_name());
				existingEntity.setAccount_no(incomingEntity.getAccount_no());
				existingEntity.setDel_flg("N");
				existingEntity.setEntry_flg("Y");
				
				List<Counterparty_Entity> CheckBankName = Counterparty_Reps.Checkbanknameisexist(incomingEntity.getName_of_the_bank());
				
				if(CheckBankName.size() > 0) {
					existingEntity.setCounterparty_status("Y");
				}else {
					existingEntity.setCounterparty_status("N");
				}		
						
				existingEntity.setModify_flg(incomingEntity.getModify_flg());
				existingEntity.setVerify_flg(incomingEntity.getVerify_flg());
				existingEntity.setModify_user((String) request.getSession().getAttribute("USERID"));
				
				existingEntity.setModify_time(new Date());
				
				Mis_exposure_bill_detail_rep.save(existingEntity);
				if (previousBankName != null && updatedBankName != null
						&& !previousBankName.trim().equalsIgnoreCase(updatedBankName.trim())) {
					responseMsg = "Bill details updated successfully. Bank name mapping saved for future use.";
				} else {
					responseMsg = "Bill details updated successfully.";
				}

			} else {
				responseMsg = "Modification failed: invalid data. Contact admin for assistance.";
				throw new MISException(responseMsg);
			}
		}else if("Addbilldetail".equalsIgnoreCase(formMode)) {
			
			Mis_exposure_bill_detail_entity NewBillentry = new Mis_exposure_bill_detail_entity();
		
			NewBillentry.setSrl_no(incomingEntity.getSrl_no());
			NewBillentry.setBranch_name(incomingEntity.getBranch_name());
			NewBillentry.setCountry(incomingEntity.getCountry());
			NewBillentry.setDate_of_loan(incomingEntity.getDate_of_loan());
			NewBillentry.setTrade_loan_amt_usd(incomingEntity.getTrade_loan_amt_usd());
			NewBillentry.setTrade_loan_amt_eq_aed(incomingEntity.getTrade_loan_amt_eq_aed());
			NewBillentry.setInterest_rate(incomingEntity.getInterest_rate());
			NewBillentry.setDue_date(incomingEntity.getDue_date());
			NewBillentry.setName_of_the_bank(incomingEntity.getName_of_the_bank());
			NewBillentry.setBill_id(incomingEntity.getBill_id());
			NewBillentry.setCustomer_name(incomingEntity.getCustomer_name());
			NewBillentry.setAccount_no(incomingEntity.getAccount_no());
			NewBillentry.setDel_flg("N");
			NewBillentry.setEntry_flg("Y");
			NewBillentry.setModify_flg("N");
			NewBillentry.setVerify_flg("N");
			NewBillentry.setReport_date(new Date());
			List<Counterparty_Entity> CheckBankName = Counterparty_Reps.Checkbanknameisexist(incomingEntity.getName_of_the_bank());
			
			if(CheckBankName.size() > 0) {
				NewBillentry.setCounterparty_status("Y");
			}else {
				NewBillentry.setCounterparty_status("N");
			}
			NewBillentry.setEntry_user((String) request.getSession().getAttribute("USERID"));
			NewBillentry.setEntry_time(new Date());
			Mis_exposure_bill_detail_rep.save(NewBillentry);
			
			Map<String, String> auditMap = Auditservice(new Mis_exposure_bill_detail_entity(), incomingEntity);
			
			auditservice.createBusinessAudit((String) request.getSession().getAttribute("USERID"), "New Bill", "New Bill Created", auditMap,
					"MIS_ASL_EXPOSURE_BILL_DETAIL_TABLE");
			
			responseMsg = "Bill detail has been successfully recorded.";

		
		}else if("Deletebilldetail".equalsIgnoreCase(formMode)) {
			

			Optional<Mis_exposure_bill_detail_entity> optionalExisting = Mis_exposure_bill_detail_rep
					.checkvalueispresent(incomingEntity.getSrl_no());

			if (optionalExisting.isPresent()) {
				Mis_exposure_bill_detail_entity existingEntity = optionalExisting.get();
				
				incomingEntity.setDel_flg("Y");
				
				Map<String, String> auditMap = Auditservice(existingEntity, incomingEntity);
				
				auditservice.createBusinessAudit((String) request.getSession().getAttribute("USERID"), "Delete Bill", "Existing Bill Delete", auditMap,
						"MIS_ASL_EXPOSURE_BILL_DETAIL_TABLE");
				
				existingEntity.setDel_flg("Y");
				Mis_exposure_bill_detail_rep.save(existingEntity);
				
				responseMsg = "Bill details have been successfully removed.";
			
			}else {
				responseMsg = "Deletion failed: invalid data. Contact admin for assistance.";
				throw new MISException(responseMsg);
			}
		}else if("Verifybilldetail".equalsIgnoreCase(formMode)) {
			Optional<Mis_exposure_bill_detail_entity> optionalExisting = Mis_exposure_bill_detail_rep
					.checkvalueispresent(incomingEntity.getSrl_no());

			if (optionalExisting.isPresent()) {
				Mis_exposure_bill_detail_entity existingEntity = optionalExisting.get();
				List<Counterparty_Entity> CheckBankName = Counterparty_Reps.Checkbanknameisexist(incomingEntity.getName_of_the_bank());
				
				if(CheckBankName.size() > 0) {
					existingEntity.setCounterparty_status("Y");
					incomingEntity.setVerify_flg("Y");
				}else {
					existingEntity.setCounterparty_status("N");
					incomingEntity.setVerify_flg("N");
				}
				
				incomingEntity.setVerify_user((String) request.getSession().getAttribute("USERID"));
				incomingEntity.setVerify_time(new Date());
				incomingEntity.setModify_flg("N");
				
				Map<String, String> auditMap = Auditservice(existingEntity, incomingEntity);
				
				auditservice.createBusinessAudit((String) request.getSession().getAttribute("USERID"), "Verify Bill", "Bill Verification Process", auditMap,
						"MIS_ASL_EXPOSURE_BILL_DETAIL_TABLE");
				existingEntity.setVerify_flg(incomingEntity.getVerify_flg());
				existingEntity.setVerify_user((String) request.getSession().getAttribute("USERID"));
				existingEntity.setVerify_time(new Date());
				existingEntity.setModify_flg("N");
				
				Mis_exposure_bill_detail_rep.save(existingEntity);
				if(incomingEntity.getVerify_flg().equals("Y")) {
					responseMsg = "Bill details have been successfully Verified.";
				}else {
					responseMsg = "Bill details not Verified. Invalid bank name is provided";
				}
				
			}else {
				responseMsg = "Verification failed: invalid data. Contact admin for assistance.";
				throw new MISException(responseMsg);
			}
				
		}

		return responseMsg;
	}

	public Map<String, String> Auditservice(Object existingEntity, Object incomingEntity) {
		final Map<String, String> changes = new LinkedHashMap<>(); // use LinkedHashMap to preserve order

		Field[] fields = existingEntity.getClass().getDeclaredFields();

		for (Field field : fields) {
			try {
				field.setAccessible(true);

				Object oldValue = field.get(existingEntity);
				Object newValue = field.get(incomingEntity);

				// Compare carefully (null-safe)
				if (!Objects.equals(oldValue, newValue)) {
					changes.put(field.getName(), "OldValue: " + oldValue + ", NewValue: " + newValue);
				}

			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		return changes;
	}
	
	
	public String AddLimitRequest(Limit_Request_Entity as, String userid, String formmode) {
		String msg = "";

		try {
			Session hs = sessionFactory.getCurrentSession();

			
				
				as.setSRL_NO(new BigDecimal(limit_request_rep.getSrlNo()));
				as.setCreateuser(userid);
				as.setDelFlg("N");
				as.setCreatedate(new Date());

				Limit_Request_Entity newdata = new Limit_Request_Entity();
				Map<String, String> changes = new LinkedHashMap<>();

				for (Field field : Limit_Request_Entity.class.getDeclaredFields()) {
					field.setAccessible(true);
					try {
						Object oldValue = field.get(newdata);
						Object newValue = field.get(as);
						if ((oldValue == null || oldValue.toString().trim().isEmpty())
								&& (newValue == null || newValue.toString().trim().isEmpty())) {
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
							field.set(newdata, newValue);
						}

					} catch (IllegalAccessException e) {
						System.err.println("Access error for field: " + field.getName() + " - " + e.getMessage());
					}
				}
				auditservice.createBusinessAudit(userid, "ADD", "Limit Request - ASL -Add", changes,
						"Limit_Request");

				hs.save(as);
				msg = "Limit Requested Successfully.";
			

		} catch (Exception e) {
			msg = "Kindly check the data / Please contact Administrator";
			e.printStackTrace();
		}

		return msg;
	}

	private void saveBankNameMappingIfChanged(String oldBankName, String newBankName, String billSrlNo, String userId) {
		if (oldBankName == null || newBankName == null) {
			return;
		}
		String oldNorm = oldBankName.trim();
		String newNorm = newBankName.trim();
		if (oldNorm.isEmpty() || newNorm.isEmpty() || oldNorm.equalsIgnoreCase(newNorm)) {
			return;
		}

		Date now = new Date();
		Optional<Mis_exposure_bank_name_map_entity> existingMap = Mis_exposure_bank_name_map_rep
				.findActiveByOldBankName(oldNorm);

		if (existingMap.isPresent()) {
			Mis_exposure_bank_name_map_entity map = existingMap.get();
			map.setNewBankName(newNorm);
			map.setBillSrlNo(billSrlNo);
			map.setModifyUser(userId);
			map.setModifyTime(now);
			Mis_exposure_bank_name_map_rep.save(map);
			logger.info("Updated bank name map: '{}' -> '{}' (bill {})", oldNorm, newNorm, billSrlNo);
		} else {
			Mis_exposure_bank_name_map_entity map = new Mis_exposure_bank_name_map_entity();
			map.setOldBankName(oldNorm);
			map.setNewBankName(newNorm);
			map.setBillSrlNo(billSrlNo);
			map.setCreateUser(userId);
			map.setCreateTime(now);
			map.setDelFlg("N");
			Mis_exposure_bank_name_map_rep.save(map);
			logger.info("Created bank name map: '{}' -> '{}' (bill {})", oldNorm, newNorm, billSrlNo);
		}
	}

	public String getMappedBankName(String oldBankName) {
		if (oldBankName == null || oldBankName.trim().isEmpty()) {
			return null;
		}
		return Mis_exposure_bank_name_map_rep.findActiveByOldBankName(oldBankName.trim())
				.map(Mis_exposure_bank_name_map_entity::getNewBankName)
				.orElse(null);
	}

}
