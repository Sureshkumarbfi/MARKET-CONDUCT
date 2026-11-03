package com.bornfire.xbrl.services;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import javax.servlet.http.HttpServletRequest;

import javax.persistence.Table;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bornfire.xbrl.entities.AuditServicesEntity;
import com.bornfire.xbrl.entities.AuditServicesRep;
import com.bornfire.xbrl.entities.MC_Service_audit_entity;
import com.bornfire.xbrl.entities.RT_MC_Description_Repo;
import com.bornfire.xbrl.entities.Service_audit_table_Rep;
import com.bornfire.xbrl.entities.Service_audit_table_entity;
import com.bornfire.xbrl.entities.UserProfile;
import com.bornfire.xbrl.entities.MC_Service_audit_Repo;

@Service
public class AuditService {

	@Autowired
	private AuditServicesRep auditServicesRep;
	
	  @Autowired
	Service_audit_table_Rep Service_audit_table_Reps;
	@Autowired
	MC_Service_audit_Repo MC_Service_audit_Repo;
	@Autowired
	RT_MC_TABLE_ALL_Service rt_MC_TABLE_ALL_Service;

	public List<AuditServicesEntity> getUserServices(Date reportdata) {
//		System.out.println(auditServicesRep.getUserAudit());
		return auditServicesRep.getUserAudit(reportdata);
	}

	public List<AuditServicesEntity> getAuditServices() {
//		System.out.println(auditServicesRep.getServiceAudit());
		return auditServicesRep.getServiceAudit();	
	}

	public void createLoginAudit(final String customerId, final String functionCode, final String screenName,
			final Map<String, String> changeDetails, final String tableName, final UserProfile user) {
		try {
			final UUID auditID = UUID.randomUUID();
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			String userId = null;
			String username = null;
			if (attr != null) {
				HttpServletRequest request = attr.getRequest();
				userId = (String) request.getSession().getAttribute("USERID");
				username = (String) request.getSession().getAttribute("USERNAME");
			}
			final Date currentDate = new Date();

			AuditServicesEntity audit = new AuditServicesEntity();
			audit.setAudit_ref_no(auditID.toString());
			audit.setAudit_date(currentDate);
			audit.setEntry_time(currentDate);
			audit.setEntry_user(user.getUserid());
			audit.setEntry_user_name(user.getUsername());
			audit.setFunc_code(functionCode);
			audit.setAudit_table(tableName);
			audit.setAudit_screen(screenName);
			audit.setEvent_id(user.getUserid());
			audit.setEvent_name(user.getUsername());

			if (changeDetails != null && !changeDetails.isEmpty()) {
				StringBuilder changes = new StringBuilder();
				changeDetails
						.forEach((field, value) -> changes.append(field).append(": ").append(value).append("||| "));
			
	            audit.setChange_details(changes.toString()); 
			}

			if ("VERIFY".equalsIgnoreCase(functionCode)) {
				audit.setAuth_user(userId);
				audit.setAuth_user_name(username);
				audit.setAuth_time(currentDate);
			}

			audit.setReport_id(customerId);

//			System.out.println(audit);
			auditServicesRep.save(audit);

		} catch (Exception e) {
			System.err.println("Error creating business audit: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void createBusinessAudit(final String customerId, final String functionCode, final String screenName,
			final Map<String, String> changeDetails, final String tableName) {
		try {
			System.out.println("Entered Service Audit");
			final UUID auditID = UUID.randomUUID();
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			//System.out.println("ServletRequestAttributes : "+attr);
			String userId = null;
			String username = null;
			if (attr != null) {
				HttpServletRequest request = attr.getRequest();
				userId = (String) request.getSession().getAttribute("USERID");
				username = (String) request.getSession().getAttribute("USERNAME");
			}
			final Date currentDate = new Date();

			Service_audit_table_entity audit = new Service_audit_table_entity();
			audit.setAudit_ref_no(auditID.toString());
			audit.setAudit_date(currentDate);
			audit.setEntry_time(currentDate);
			audit.setEntry_user(userId);
			audit.setEntry_user_name(username);
			audit.setFunc_code(functionCode);
			audit.setAudit_table(tableName);
			audit.setAudit_screen(screenName);
			audit.setEvent_id(userId);
			audit.setEvent_name(username);

			if (changeDetails != null && !changeDetails.isEmpty()) {
				StringBuilder changes = new StringBuilder();
				changeDetails
						.forEach((field, value) -> changes.append(field).append(": ").append(value).append("||| "));
			
	            audit.setModi_details(changes.toString()); 
			}

			if ("VERIFY".equalsIgnoreCase(functionCode)) {
				audit.setAuth_user(userId);
				audit.setAuth_user_name(username);
				audit.setAuth_time(currentDate);
			}

			audit.setDomain_id(customerId);

//			System.out.println(audit);
			Service_audit_table_Reps.save(audit);

		} catch (Exception e) {
			System.err.println("Error creating business audit: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void createBusinessAuditbackground(final String customerId, final String functionCode, final String screenName,
			final Map<String, String> changeDetails, final String tableName,ServletRequestAttributes attr) {
		try {
			System.out.println("Entered Service Audit");
			final UUID auditID = UUID.randomUUID();
			//ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			//System.out.println("ServletRequestAttributes : "+attr);
			String userId = null;
			String username = null;
			if (attr != null) {
				HttpServletRequest request = attr.getRequest();
				userId = (String) request.getSession().getAttribute("USERID");
				username = (String) request.getSession().getAttribute("USERNAME");
			}
			final Date currentDate = new Date();

			Service_audit_table_entity audit = new Service_audit_table_entity();
			audit.setAudit_ref_no(auditID.toString());
			audit.setAudit_date(currentDate);
			audit.setEntry_time(currentDate);
			audit.setEntry_user(userId);
			audit.setEntry_user_name(username);
			audit.setFunc_code(functionCode);
			audit.setAudit_table(tableName);
			audit.setAudit_screen(screenName);
			audit.setEvent_id(userId);
			audit.setEvent_name(username);

			if (changeDetails != null && !changeDetails.isEmpty()) {
				StringBuilder changes = new StringBuilder();
				changeDetails
						.forEach((field, value) -> changes.append(field).append(": ").append(value).append("||| "));
			
	            audit.setModi_details(changes.toString()); 
			}

			if ("VERIFY".equalsIgnoreCase(functionCode)) {
				audit.setAuth_user(userId);
				audit.setAuth_user_name(username);
				audit.setAuth_time(currentDate);
			}

			audit.setDomain_id(customerId);

//			System.out.println(audit);
			Service_audit_table_Reps.save(audit);

		} catch (Exception e) {
			System.err.println("Error creating business audit: " + e.getMessage());
			e.printStackTrace();
		}
	}


	private boolean areEqual(Object obj1, Object obj2) {
		if (obj1 == null && obj2 == null)
			return true;
		if (obj1 == null || obj2 == null)
			return false;
		return obj1.equals(obj2);
	}

	public String fetchChanges(@RequestParam(required = false) String audit_ref_no) {

	return auditServicesRep.getchanges(audit_ref_no); 
	}

	public <T> void compareEntitiesmanual(T oldEntity, T newEntity, String id_values, String Screenname,
			String tableName) {
		System.out.println("Screen Name: " + Screenname);

		if (oldEntity == null || newEntity == null) {
			throw new IllegalArgumentException("Entities cannot be null");
		}

		// Check if both entities are of the same type
		if (!oldEntity.getClass().equals(newEntity.getClass())) {
			throw new IllegalArgumentException(
					"Entities must be of the same type. " + "Old entity type: " + oldEntity.getClass().getSimpleName()
							+ ", New entity type: " + newEntity.getClass().getSimpleName());
		}
		List<String> ignoreFields = Arrays.asList("createdAt", "updatedAt", "modifiedAt", "createdBy", "modifiedBy",
				"lastModifiedDate", "lastModifiedBy", "version");
		List<String> lowerCaseIgnoreFields = new ArrayList<String>();
		if (ignoreFields != null) {
			for (String field : ignoreFields) {
				lowerCaseIgnoreFields.add(field.toLowerCase());
			}
		}

		// Compare entities and build changes string
		StringBuilder changes = new StringBuilder();
		Class<?> clazz = oldEntity.getClass();
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			// Skip if field is in ignore list (case-insensitive)
			if (lowerCaseIgnoreFields.contains(field.getName().toLowerCase())) {
				continue;
			}

			field.setAccessible(true);
			try {
				Object oldValue = field.get(oldEntity);
				Object newValue = field.get(newEntity);

				if (!areEqual(oldValue, newValue)) {
					if (changes.length() > 0) {
						changes.append("|||");
					}
					changes.append(field.getName()).append(": OldValue: ").append(oldValue).append(", NewValue: ")
							.append(newValue);
				}
			} catch (IllegalAccessException e) {
				throw new RuntimeException("Error accessing field: " + field.getName(), e);
			}
		}

		System.out.println("Changes in Audit : " + changes);

		System.out.println("Entered Dynamic  Modify Service Audit");
		final UUID auditID = UUID.randomUUID();
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		String userId = null;
		String username = null;
		if (attr != null) {
			HttpServletRequest request = attr.getRequest();
			userId = (String) request.getSession().getAttribute("USERID");
			username = (String) request.getSession().getAttribute("USERNAME");
		}
		final Date currentDate = new Date();

		Service_audit_table_entity audit = new Service_audit_table_entity();
		audit.setAudit_ref_no(auditID.toString());
		audit.setAudit_date(currentDate);
		audit.setEntry_time(currentDate);
		audit.setEntry_user(userId);
		audit.setEntry_user_name(username);
		audit.setFunc_code("MODIFY");
		audit.setAudit_table(tableName);
		audit.setAudit_screen(Screenname);
		audit.setEvent_id(userId);
		audit.setEvent_name(username);
		audit.setModi_details(changes.toString());
		audit.setDomain_id(id_values);

		Service_audit_table_Reps.save(audit);

	}

	public <T> void compareMCEntitiesmanual(T oldEntity, T newEntity, String id_values,String auditType, String Screenname,
			String tableName, String modifyheader, String remarks) {
		System.out.println("Screen Name: " + Screenname);

		if (oldEntity == null || newEntity == null) {
			throw new IllegalArgumentException("Entities cannot be null");
		}

		if (!oldEntity.getClass().equals(newEntity.getClass())) {
			throw new IllegalArgumentException(
					"Entities must be of the same type. " + "Old entity type: " + oldEntity.getClass().getSimpleName()
							+ ", New entity type: " + newEntity.getClass().getSimpleName());
		}

		List<String> ignoreFields = Arrays.asList("createdAt", "updatedAt", "modifiedAt", "createdBy", "modifiedBy",
				"lastModifiedDate", "lastModifiedBy", "version", "modifyFlg", "verifyFlg", "columnHeader",
				"rowCol2Value", "formMode", "reportDate", "cellId", "cellName");
		List<String> lowerCaseIgnoreFields = new ArrayList<>();
		if (ignoreFields != null) {
			for (String field : ignoreFields) {
				lowerCaseIgnoreFields.add(field.toLowerCase());
			}
		}

		List<String> fieldNamesList = Arrays.asList("justification", "dataValue", "source", "remarks", "fileName1",
				"fileName2", "fileName3", "fileName4", "fileName5", "fileName6", "fileName7", "fileName8", "fileName9",
				"fileName10", "fileData1", "fileData2", "fileData3", "fileData4", "fileData5", "fileData6", "fileData7",
				"fileData8", "fileData9", "fileData10");
		List<String> equivalentValuesList = Arrays.asList("Justification", "Value", "Source", "Checker Remarks",
				"File Name 1", "File Name 2", "File Name 3", "File Name 4", "File Name 5", "File Name 6", "File Name 7",
				"File Name 8", "File Name 9", "File Name 10", "File Uploaded 1 ", "File Uploaded 2", "File Uploaded 3",
				"File Uploaded 4", "File Uploaded 5", "File Uploaded 6", "File Uploaded 7", "File Uploaded 8",
				"File Uploaded 9", "File Uploaded 10");
		StringBuilder changes = new StringBuilder();

		List<String> changedFieldNames = new ArrayList<>();
		List<Object> changedOldValues = new ArrayList<>();
		List<Object> changedNewValues = new ArrayList<>();

		Class<?> clazz = oldEntity.getClass();
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			if (lowerCaseIgnoreFields.contains(field.getName().toLowerCase())) {
				continue;
			}

			field.setAccessible(true);
			try {
				Object oldValue = field.get(oldEntity);
				Object newValue = field.get(newEntity);

				boolean isOldEmpty = (oldValue == null || oldValue.toString().trim().isEmpty());
				boolean isNewEmpty = (newValue == null || newValue.toString().trim().isEmpty());

				if (isOldEmpty && isNewEmpty) {
					continue;
				}
				
				if (!areEqual(oldValue, newValue)) {

					String finalFieldName = field.getName();
					int matchIndex = fieldNamesList.indexOf(finalFieldName);

					if (matchIndex != -1 && matchIndex < equivalentValuesList.size()) {
						finalFieldName = equivalentValuesList.get(matchIndex);
					}

					if (changes.length() > 0) {
						changes.append("|||");
					}

					changes.append(finalFieldName).append(": OldValue: ").append(oldValue).append(", NewValue: ")
							.append(newValue);

					changedFieldNames.add(finalFieldName);
					changedOldValues.add(oldValue);
					changedNewValues.add(newValue);
				}
			} catch (IllegalAccessException e) {
				throw new RuntimeException("Error accessing field: " + field.getName(), e);
			}
		}

		System.out.println("Entered MC Modify Service Audit");
		final UUID auditID = UUID.randomUUID();
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		String userId = null;
		String username = null;
		String sessionId = null;
		if (attr != null) {
			HttpServletRequest request = attr.getRequest();
			userId = (String) request.getSession().getAttribute("USERID");
			username = (String) request.getSession().getAttribute("USERNAME");
			sessionId = request.getSession().getId();
		}

		final Date currentDate = new Date();

		MC_Service_audit_entity audit = new MC_Service_audit_entity();
		audit.setAudit_ref_no(auditID.toString());
		audit.setAudit_date(currentDate);
		audit.setEntry_time(currentDate);
		audit.setEntry_user(userId);
		audit.setEntry_user_name(username);
		audit.setFunc_code(auditType);
		audit.setAudit_table(tableName);
		audit.setAudit_screen(Screenname);
		audit.setEvent_id(userId);
		audit.setEvent_name(username);
		audit.setModi_details(changes.toString());
		audit.setDomain_id(id_values);
		audit.setRemarks(remarks);
		audit.setFIELD_HEADER(modifyheader);
		audit.setSession_id(sessionId);
		boolean ismodified = (changes.toString() == null || changes.toString().trim().isEmpty());

		if (ismodified) {
			audit.setISMODIFIED("N");
		} else {
			audit.setISMODIFIED("Y");
		}
		MC_Service_audit_Repo.save(audit);
	}

	public <T> void auditAddMCEntitymanual(T newEntity, String id_values, String Screenname, String tableName,
			String modifyheader, String remarks) {
		System.out.println("Screen Name: " + Screenname);

		if (newEntity == null) {
			throw new IllegalArgumentException("Entity cannot be null for ADD operation");
		}

		List<String> ignoreFields = Arrays.asList("id","createdAt", "updatedAt", "modifiedAt", "createdBy", "modifiedBy",
				"lastModifiedDate", "lastModifiedBy", "version", "modifyFlg", "verifyFlg", "columnHeader",
				"rowCol2Value", "formMode", "reportDate", "cellId", "cellName");

		List<String> lowerCaseIgnoreFields = new ArrayList<>();
		if (ignoreFields != null) {
			for (String field : ignoreFields) {
				lowerCaseIgnoreFields.add(field.toLowerCase());
			}
		}

		List<String> fieldNamesList = Arrays.asList("justification", "dataValue", "source", "remarks", "fileName1",
				"fileName2", "fileName3", "fileName4", "fileName5", "fileName6", "fileName7", "fileName8", "fileName9",
				"fileName10", "fileData1", "fileData2", "fileData3", "fileData4", "fileData5", "fileData6", "fileData7",
				"fileData8", "fileData9", "fileData10");
		List<String> equivalentValuesList = Arrays.asList("Justification", "Value", "Source", "Checker Remarks",
				"File Name 1", "File Name 2", "File Name 3", "File Name 4", "File Name 5", "File Name 6", "File Name 7",
				"File Name 8", "File Name 9", "File Name 10", "File Uploaded 1 ", "File Uploaded 2", "File Uploaded 3",
				"File Uploaded 4", "File Uploaded 5", "File Uploaded 6", "File Uploaded 7", "File Uploaded 8",
				"File Uploaded 9", "File Uploaded 10");

		StringBuilder addedDetails = new StringBuilder();

		Class<?> clazz = newEntity.getClass();
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			if (lowerCaseIgnoreFields.contains(field.getName().toLowerCase())) {
				continue;
			}

			field.setAccessible(true);
			try {
				Object newValue = field.get(newEntity);

				if (newValue != null && !String.valueOf(newValue).trim().isEmpty()) {

					String finalFieldName = field.getName();
					int matchIndex = fieldNamesList.indexOf(finalFieldName);

					if (matchIndex != -1 && matchIndex < equivalentValuesList.size()) {
						finalFieldName = equivalentValuesList.get(matchIndex);
					}

					if (addedDetails.length() > 0) {
						addedDetails.append("|||");
					}

					addedDetails.append(finalFieldName).append(": OldValue: -").append(", NewValue: ").append(newValue);
				}
			} catch (IllegalAccessException e) {
				throw new RuntimeException("Error accessing field: " + field.getName(), e);
			}
		}

		System.out.println("Entered MC Add Service Audit");
		final UUID auditID = UUID.randomUUID();
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		String userId = null;
		String username = null;
		String sessionId = null;
		if (attr != null) {
			HttpServletRequest request = attr.getRequest();
			userId = (String) request.getSession().getAttribute("USERID");
			username = (String) request.getSession().getAttribute("USERNAME");
			sessionId = request.getSession().getId();
		}

		final Date currentDate = new Date();

		MC_Service_audit_entity audit = new MC_Service_audit_entity();
		audit.setAudit_ref_no(auditID.toString());
		audit.setAudit_date(currentDate);
		audit.setEntry_time(currentDate);
		audit.setEntry_user(userId);
		audit.setEntry_user_name(username);
		audit.setFunc_code("ADD");
		audit.setAudit_table(tableName);
		audit.setAudit_screen(Screenname);
		audit.setEvent_id(userId);
		audit.setEvent_name(username);
		audit.setModi_details(addedDetails.toString());
		audit.setDomain_id(id_values);
		audit.setRemarks(remarks);
		audit.setFIELD_HEADER(modifyheader);
		audit.setSession_id(sessionId);
		audit.setISMODIFIED("Y");
		MC_Service_audit_Repo.save(audit);
	}

	public void auditMCEntitymanual(String fun_code, String id_values, String Screenname, String tableName,
			String modifyheader, String remarks, String changedRemarks) {
		System.out.println("Screen Name: " + Screenname);
		System.out.println("Entered MC Common Service Audit");
		final UUID auditID = UUID.randomUUID();
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		String userId = null;
		String username = null;
		String sessionId = null;
		if (attr != null) {
			HttpServletRequest request = attr.getRequest();
			userId = (String) request.getSession().getAttribute("USERID");
			username = (String) request.getSession().getAttribute("USERNAME");
			sessionId = request.getSession().getId();
		}

		final Date currentDate = new Date();

		MC_Service_audit_entity audit = new MC_Service_audit_entity();
		audit.setAudit_ref_no(auditID.toString());
		audit.setAudit_date(currentDate);
		audit.setEntry_time(currentDate);
		audit.setEntry_user(userId);
		audit.setEntry_user_name(username);
		audit.setFunc_code(fun_code);
		audit.setAudit_table(tableName);
		audit.setAudit_screen(Screenname);
		audit.setEvent_id(userId);
		audit.setEvent_name(username);
		audit.setDomain_id(id_values);
		audit.setRemarks(remarks);
		audit.setFIELD_HEADER(modifyheader);
		audit.setSession_id(sessionId);
		audit.setModi_details(changedRemarks);
		boolean ismodified = (changedRemarks == null || changedRemarks.toString().trim().isEmpty());
		if (ismodified) {
			audit.setISMODIFIED("N");
		} else {
			audit.setISMODIFIED("Y");
		}

		MC_Service_audit_Repo.save(audit);
	}

	@Autowired
	RT_MC_Description_Repo rt_MC_Description_Repo;
	
	public <T> void compareMCEntitiesManualGrouped(T oldEntity, T newEntity, String id_values,
			String Screenname, String tableName,  String formmode) {

		System.out.println("Screen Name: " + Screenname);

		if (oldEntity == null || newEntity == null) {
			throw new IllegalArgumentException("Entities cannot be null");
		}

		if (!oldEntity.getClass().equals(newEntity.getClass())) {
			throw new IllegalArgumentException("Entities must be of the same type.");
		}

		List<String> ignoreFields = Arrays.asList("createdAt", "updatedAt", "modifiedAt", "createdBy", "modifiedBy",
				"lastModifiedDate", "lastModifiedBy", "version", "modifyFlg", "verifyFlg", "columnHeader",
				"rowCol2Value", "formMode", "reportDate", "cellId", "cellName");

		List<String> lowerCaseIgnoreFields = new ArrayList<>();
		for (String field : ignoreFields) {
			lowerCaseIgnoreFields.add(field.toLowerCase());
		}

		List<String> ignoreHeaders = Arrays.asList("DATE");

		Map<String, Map<String, String>> groupedChanges = new LinkedHashMap<>();

		Class<?> clazz = oldEntity.getClass();
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			if (lowerCaseIgnoreFields.contains(field.getName().toLowerCase())) {
				continue;
			}

			field.setAccessible(true);
			try {
				Object oldValue = field.get(oldEntity);
				Object newValue = field.get(newEntity);

				boolean isOldEmpty = (oldValue == null || oldValue.toString().trim().isEmpty());
				boolean isNewEmpty = (newValue == null || newValue.toString().trim().isEmpty());

				if (isOldEmpty && isNewEmpty) {
					continue;
				}

				if (!areEqual(oldValue, newValue)) {
					String rawFieldName = field.getName();
					String prefix = rawFieldName;
					String suffix = rawFieldName;

					String[] nameParts = rawFieldName.split("_", 2);
					if (nameParts.length == 2) {
						prefix = nameParts[0]; // e.g., "R5"
						suffix = nameParts[1]; // e.g., "SOMETHING_ABC"
					}

					if (ignoreHeaders.contains(suffix.toUpperCase())) {
						continue;
					}
					String resolvedFieldName = getFieldName(formmode, prefix);

					String finalItemKey = (resolvedFieldName != null && !resolvedFieldName.isEmpty())
							? resolvedFieldName
							: prefix;
					String resolvedHeader;
					if (formmode == "conductcultureassessment" || "conductcultureassessment".equals(formmode)) {
						if (suffix == "LFI_RESP") {
							resolvedHeader = "Bank Response";
						} else {
							resolvedHeader = "Evidence to be provided by Bank";
						}
					} else {
						resolvedHeader = rt_MC_Description_Repo.findHeaderNameByCode(formmode, suffix);
					}
					String finalGroupKey = (resolvedHeader != null && !resolvedHeader.isEmpty()) ? resolvedHeader
							: suffix;

					String changeText = "OldValue: " + oldValue + ", NewValue: " + newValue;

					groupedChanges.computeIfAbsent(finalGroupKey, k -> new LinkedHashMap<>()).put(finalItemKey,
							changeText);
				}
			} catch (IllegalAccessException e) {
				throw new RuntimeException("Error accessing field: " + field.getName(), e);
			}
		}

		System.out.println("Entered MC Modify Service Audit (Grouped)");

		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		String userId = null;
		String username = null;
		String sessionId = null;

		if (attr != null) {
			HttpServletRequest request = attr.getRequest();
			userId = (String) request.getSession().getAttribute("USERID");
			username = (String) request.getSession().getAttribute("USERNAME");
			sessionId = request.getSession().getId();
		}

		final Date currentDate = new Date();

		if (!groupedChanges.isEmpty()) {
			for (Map.Entry<String, Map<String, String>> groupEntry : groupedChanges.entrySet()) {

				String groupHeaderName = groupEntry.getKey();
				Map<String, String> changesForGroup = groupEntry.getValue();

				StringBuilder groupChangesBuilder = new StringBuilder();
				for (Map.Entry<String, String> change : changesForGroup.entrySet()) {
					if (groupChangesBuilder.length() > 0) {
						groupChangesBuilder.append("|||");
					}
					groupChangesBuilder.append(change.getKey()).append(": ").append(change.getValue());
				}

				MC_Service_audit_entity audit = new MC_Service_audit_entity();
				audit.setAudit_ref_no(UUID.randomUUID().toString());
				audit.setAudit_date(currentDate);
				audit.setEntry_time(currentDate);
				audit.setEntry_user(userId);
				audit.setEntry_user_name(username);
				audit.setFunc_code("MODIFY");
				audit.setAudit_table(tableName);
				audit.setAudit_screen(Screenname + " - Department Validation");
				audit.setEvent_id(userId);
				audit.setEvent_name(username);
				audit.setModi_details(groupChangesBuilder.toString());
				audit.setDomain_id(id_values);
				audit.setRemarks("Modified Successfully");

				audit.setFIELD_HEADER(groupHeaderName);

				audit.setSession_id(sessionId);
				audit.setISMODIFIED("Y");

				MC_Service_audit_Repo.save(audit);
			}
		}
	}
	public void auditManagerVerifyActionGrouped(String formMode, String reportDateStr, String actionType,
			String remarks, String timeperiod, List<String> existingCells, List<String> incomingCells) {

		System.out.println("Entered Manager Verify Service Audit");

		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		String userId = null;
		String username = null;
		String sessionId = null;

		if (attr != null) {
			HttpServletRequest request = attr.getRequest();
			userId = (String) request.getSession().getAttribute("USERID");
			username = (String) request.getSession().getAttribute("USERNAME");
			sessionId = request.getSession().getId();
		}

		final Date currentDate = new Date();
		String uniqueIdValues = reportDateStr + " - " + formMode;
		if (timeperiod != null) {
			uniqueIdValues += " - " + timeperiod;
		}

		String mappedFuncCode;
		String mappedIsModified;

		switch (actionType) {
			case "VERIFY_ALL":
				mappedFuncCode = "VERIFY";
				mappedIsModified = "N";
				break;
			case "REVERT_MR":
				mappedFuncCode = "REVERT";
				mappedIsModified = "Y";
				break;
			case "REVOKE_MGR":
				mappedFuncCode = "REVOKE";
				mappedIsModified = "N";
				break;
			default:
				mappedFuncCode = actionType;
				mappedIsModified = "Y";
		}

		if ("REVERT_MR".equals(actionType)) {

			Set<String> oldSet = new HashSet<>(existingCells != null ? existingCells : new ArrayList<>());
			Set<String> newSet = new HashSet<>(incomingCells != null ? incomingCells : new ArrayList<>());

			Set<String> newlyReverted = new HashSet<>(newSet);
			newlyReverted.removeAll(oldSet); 

			Set<String> unReverted = new HashSet<>(oldSet);
			unReverted.removeAll(newSet); 

			if (newlyReverted.isEmpty() && unReverted.isEmpty()) {
				return;
			}

			Map<String, Map<String, String>> groupedChanges = new LinkedHashMap<>();

			processCellsForAudit(newlyReverted, "Status changed to Manager Rejected", groupedChanges,formMode);
			processCellsForAudit(unReverted, "Status changed back to Verified", groupedChanges,formMode);

			for (Map.Entry<String, Map<String, String>> groupEntry : groupedChanges.entrySet()) {
				String groupHeaderName = groupEntry.getKey();
				Map<String, String> changesForGroup = groupEntry.getValue();

				StringBuilder groupChangesBuilder = new StringBuilder();
				for (Map.Entry<String, String> change : changesForGroup.entrySet()) {
					if (groupChangesBuilder.length() > 0) {
						groupChangesBuilder.append("|||");
					}
					groupChangesBuilder.append(change.getKey()).append(": ").append(change.getValue());
				}

				MC_Service_audit_entity audit = new MC_Service_audit_entity();
				audit.setAudit_ref_no(UUID.randomUUID().toString());
				audit.setAudit_date(currentDate);
				audit.setEntry_time(currentDate);
				audit.setEntry_user(userId);
				audit.setEntry_user_name(username);
				
				audit.setFunc_code(mappedFuncCode); 
				audit.setAudit_table("RT_MC_DATA_RECORD");
				audit.setAudit_screen(rt_MC_TABLE_ALL_Service.screenName(formMode));
				audit.setEvent_id(userId);
				audit.setEvent_name(username);
				audit.setModi_details(groupChangesBuilder.toString());
				audit.setDomain_id(uniqueIdValues);
				audit.setRemarks(remarks);
				audit.setFIELD_HEADER(groupHeaderName);
				audit.setSession_id(sessionId);
				
				audit.setISMODIFIED(mappedIsModified); 

				MC_Service_audit_Repo.save(audit);
			}
		}
		else {
			String actionDetails = "VERIFY_ALL".equals(actionType) ? "Entire form verified successfully."
					: "Manager actions revoked for entire form.";

			MC_Service_audit_entity audit = new MC_Service_audit_entity();
			audit.setAudit_ref_no(UUID.randomUUID().toString());
			audit.setAudit_date(currentDate);
			audit.setEntry_time(currentDate);
			audit.setEntry_user(userId);
			audit.setEntry_user_name(username);
			
			audit.setFunc_code(mappedFuncCode); 
			audit.setAudit_table("RT_MC_DATA_RECORD");
			audit.setAudit_screen(rt_MC_TABLE_ALL_Service.screenName(formMode));
			audit.setEvent_id(userId);
			audit.setEvent_name(username);
			if (mappedIsModified == "Y") {
				audit.setModi_details(actionDetails);
			}
			audit.setDomain_id(uniqueIdValues);
			audit.setRemarks(remarks);
			audit.setFIELD_HEADER(rt_MC_TABLE_ALL_Service.screenName(formMode) + " verified");

			audit.setSession_id(sessionId);

			audit.setISMODIFIED(mappedIsModified); 

			MC_Service_audit_Repo.save(audit);
		}
	}
	public String getFieldName(String formmode, String prefix) {
		if (prefix == null || prefix.trim().isEmpty()) {
			return prefix;
		}
		System.out.println("Formmode : "+formmode+" Prefix : "+prefix);
		switch (formmode) {
		case "bankinformation" :
			switch (prefix.toUpperCase()) {
			case "R6": return "Current Account";
			case "R7": return "Savings Account";
			case "R8": return "Fixed Deposit";
			case "R9": return "Mortgage Loans / Financing";
			case "R10": return "Auto Loans / Financing";
			case "R11": return "Personal Loans / Financing";
			case "R12": return "SME Loans / Financing";
			case "R13": return "SME - Guarantees & Commitments (e.g., financial guranatee and Letter of credit)";
			case "R14": return "Credit Cards";
			case "R15": return "Structured Products";
			case "R16": return "Insurance/takaful provided from Third-Parties";
			case "R17": return "Remittance*";
			case "R18": return "Foreign Exchange*";
			case "R19": return "Prepaid Cards";
			case "R20": return "SVF - Wallets (float amount)";
			case "R21": return "Any additional retail products - please specify";
			case "R22": return "Total";
			
			default:
				return prefix;
			}

		case "bankconsumers" :
			switch (prefix.toUpperCase()) {
			case "R6": return "Current Account";
			case "R7": return "Savings Account";
			case "R8": return "Fixed Deposit";
			case "R9": return "Mortgage Loans / Financing";
			case "R10": return "Auto Loans / Financing";
			case "R11": return "Personal Loans / Financing";
			case "R12": return "SME Loans / Financing";
			case "R13": return "SME - Guarantees & Commitments (e.g., financial guranatee and Letter of credit)";
			case "R14": return "Credit Cards";
			case "R15": return "Structured Products";
			case "R16": return "Insurance/takaful provided from Third-Parties";
			case "R17": return "Remittance*";
			case "R18": return "Foreign Exchange*";
			case "R19": return "Prepaid Cards";
			case "R20": return "SVF - Wallets (float amount)";
			case "R21": return "Any additional retail products - please specify";
			case "R22": return "Total";
			
			default:
				return prefix;
			}
		case "complaints":
			switch (prefix.toUpperCase()) {
			case "R6": return "Current Account";
			case "R7": return "Savings Account";
			case "R8": return "Fixed Deposit";
			case "R9": return "Mortgage Loans / Financing";
			case "R10": return "Auto Loans / Financing";
			case "R11": return "Personal Loans / Financing";
			case "R12": return "SME Loans / Financing";
			case "R13": return "SME - Guarantees & Commitments (e.g., financial guranatee and Letter of credit)";
			case "R14": return "Credit Cards";
			case "R15": return "Structured Products";
			case "R16": return "Insurance/takaful provided from Third-Parties";
			case "R17": return "Remittance*";
			case "R18": return "Foreign Exchange*";
			case "R19": return "Prepaid Cards";
			case "R20": return "SVF - Wallets (float amount)";
			case "R21": return "Any additional retail products - please specify";
			case "R22": return "Total";
			
			default:
				return prefix;
			}
		case "retailproducts":
			switch (prefix.toUpperCase()) {
			case "R6": return "Current Account";
			case "R7": return "Savings Account";
			case "R8": return "Fixed Deposit";
			case "R9": return "Mortgage Loans / Financing";
			case "R10": return "Auto Loans / Financing";
			case "R11": return "Personal Loans / Financing";
			case "R12": return "SME Loans / Financing";
			case "R13": return "SME - Guarantees & Commitments (e.g., financial guranatee and Letter of credit)";
			case "R14": return "Credit Cards";
			case "R15": return "Structured Products";
			case "R16": return "Insurance/takaful provided from Third-Parties";
			case "R17": return "Remittance*";
			case "R18": return "Foreign Exchange*";
			case "R19": return "Prepaid Cards";
			case "R20": return "SVF - Wallets (float amount)";
			case "R21": return "Any additional retail products - please specify";
			case "R22": return "Total";

			default:
				return prefix;
			}
		case "bankemployee":
			switch (prefix.toUpperCase()) {
			case "R8": return "Bank's Staff";
			case "R9": return "Authorized Agent Staff";
			case "R10": return "Insourced Authorized Agent Staff";
			case "R11": return "Consumer facing Staff (including authorised agent staff)";
			case "R12": return "Total";

			default:
				return prefix;
			}
		case "trainings":
			switch (prefix.toUpperCase()) {
			case "R7": return "Consumer Protection";
			case "R8": return "Vulnerable Consumers";
			case "R9": return "Internal Complaint Handling procedures";
			case "R10": return "Consumer Data Management";
			case "R11": return "Code of Fair Treatment of Consumers";
			case "R12": return "Total";

			default:
				return prefix;
			}
		case "additionalinformation":
			switch (prefix.toUpperCase()) {
			case "R7": return "Current Account";
			case "R8": return "Savings Account";
			case "R9": return "Fixed Deposit";
			case "R10": return "Mortgage";
			case "R11": return "Auto Loans / Financing";
			case "R12": return "Personal Loans / Financing";
			case "R13": return "SME Loans / Financing";
			case "R14": return "SME - Guarantees & Commitments (e.g., financial guranatee and Letter of credit)";
			case "R15": return "Credit Cards";
			case "R16": return "Structured Products";
			case "R17": return "Insurance provided from Third Parties";
			case "R18": return "Remittance*";
			case "R19": return "Foreign Exchange*";
			case "R20": return "Prepaid Cards";
			case "R21": return "SVF - Wallets (float amount)";
			case "R22": return "Any additional retail products - please specify";
			case "R23": return "Total";

			default:
				return prefix;
			}
		case "islamicbanking":
			switch (prefix.toUpperCase()) {
			case "R8": return "Current Account";
			case "R9": return "Savings Account";
			case "R10": return "Fixed Deposit";
			case "R11": return "Mortgage";
			case "R12": return "Auto Loans / Financing";
			case "R13": return "Personal Loans / Financing";
			case "R14": return "SME Loans / Financing";
			case "R15": return "SME - Guarantees & Commitments (e.g., financial guranatee and Letter of credit)";
			case "R16": return "Credit Cards";
			case "R17": return "Structured Products";
			case "R18": return "Insurance provided from Third Parties";
			case "R19": return "Remittance*";
			case "R20": return "Foreign Exchange*";
			case "R21": return "Prepaid Cards";
			case "R22": return "SVF - Wallets (float amount)";
			case "R23": return "Any additional retail products - please specify";
			case "R24": return "Total";

			default:
				return prefix;
			}
			
		case "conductcultureassessment":
			switch (prefix.toUpperCase()) {
			case "R9": return "Sr. No : 1.1";
			case "R10": return "Sr. No : 1.2";
			case "R11": return "Sr. No : 1.3";
			case "R12": return "Sr. No : 1.4";
			case "R13": return "Sr. No : 1.5";
			case "R14": return "Sr. No : 1.6";
			case "R15": return "Sr. No : 1.7";
			case "R16": return "Sr. No : 1.8";
			case "R17": return "Sr. No : 1.9";
			case "R20": return "Sr. No : 2.1";
			case "R21": return "Sr. No : 2.2";
			case "R24": return "Sr. No : 3.1";
			case "R25": return "Sr. No : 3.2";
			case "R26": return "Sr. No : 3.3";
			case "R27": return "Sr. No : 3.4";
			case "R28": return "Sr. No : 3.5";
			case "R29": return "Sr. No : 3.6";
			case "R30": return "Sr. No : 3.7";
			case "R31": return "Sr. No : 3.8";
			case "R34": return "Sr. No : 4.1";
			case "R35": return "Sr. No : 4.2";
			case "R38": return "Sr. No : 5.1";
			case "R39": return "Sr. No : 5.2";
			case "R42": return "Sr. No : 6.1";
			case "R43": return "Sr. No : 6.2";
			case "R44": return "Sr. No : 6.3";
			case "R47": return "Sr. No : 7.1";
			case "R50": return "Sr. No : 8.1";
			case "R51": return "Sr. No : 8.2";
			case "R52": return "Sr. No : 8.3";
			case "R53": return "Sr. No : 8.4";
			case "R54": return "Sr. No : 8.5";
			case "R55": return "Sr. No : 8.6";
			case "R56": return "Sr. No : 8.7";
			case "R57": return "Sr. No : 8.8";
			case "R58": return "Sr. No : 8.9";
			case "R59": return "Sr. No : 8.10";
			case "R60": return "Sr. No : 8.11";
			case "R61": return "Sr. No : 8.12";

			default:
				return prefix;
			}
		default:
			return prefix;
		}
	}
	private void processCellsForAudit(Set<String> cells, String statusMessage, Map<String, Map<String, String>> groupedChanges, String formMode) {
	    List<String> ignoreHeaders = Arrays.asList("DATE");

	    for (String cellName : cells) {
	        String prefix = cellName;
	        String suffix = cellName;

	        String[] nameParts = cellName.split("_", 2);
	        if (nameParts.length == 2) {
	            prefix = nameParts[0]; 
	            suffix = nameParts[1]; 
	        }

	        if (ignoreHeaders.contains(suffix.toUpperCase())) {
	            continue;
	        }
			String resolvedFieldName = getFieldName(formMode, prefix);

			String finalItemKey = (resolvedFieldName != null && !resolvedFieldName.isEmpty()) ? resolvedFieldName
					: prefix;
			String resolvedHeader;
			if (formMode == "conductcultureassessment" || "conductcultureassessment".equals(formMode)) {
				if (suffix == "LFI_RESP") {
					resolvedHeader = "Bank Response";
				} else {
					resolvedHeader = "Evidence to be provided by Bank";
				}
			} else {
				resolvedHeader = rt_MC_Description_Repo.findHeaderNameByCode(formMode, suffix);
			}
			String finalGroupKey = (resolvedHeader != null && !resolvedHeader.isEmpty()) ? resolvedHeader : suffix;

	        groupedChanges.computeIfAbsent(finalGroupKey, k -> new LinkedHashMap<>())
	                      .put(finalItemKey, statusMessage);
	    }
	}
}
