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

import com.bornfire.xbrl.entities.AuditServicesEntity;
import com.bornfire.xbrl.entities.AuditServicesRep;
import com.bornfire.xbrl.entities.Counterparty_Entity;
import com.bornfire.xbrl.entities.Counterparty_Rep;
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
	UserProfileRep UserProfileReps;
	
	@Autowired
	Counterparty_Rep Counterparty_Reps;
	
	
	@Autowired
	SessionFactory sessionFactory;


	
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
	

}
