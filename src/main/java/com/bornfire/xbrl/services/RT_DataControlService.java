package com.bornfire.xbrl.services;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bornfire.xbrl.entities.Counterparty_Entity;
import com.bornfire.xbrl.entities.RT_DataControl;
import com.bornfire.xbrl.entities.RT_DatacontrolRepository;



@Service
public class RT_DataControlService {
	
	@Autowired
	RT_DatacontrolRepository RT_DatacontrolRepository;

	@Autowired
	AuditService auditService;
	
	public String createOrUpdate(RT_DataControl dto, String formmode,String report_name,String userid) {
	    try {
	        System.out.println("Service: createOrUpdate() called");
	        System.out.println(dto.getPortfolioDate());
	        if (dto.getPortfolioDate() == null) {
	            return "ERROR: Portfolio date is required.";
	        }

	        if ("edit".equalsIgnoreCase(formmode)) {
	            System.out.println("Form mode is EDIT — updating record.");
	            dto.setModifyFlg("Y");    // Mark that it's been modified
	        } else {
	            // New entry
				dto.setEntityFlg("Y"); // Mark as new entity
				dto.setDelFlg("N"); // Not deleted
				dto.setModifyFlg("N"); // Not modified
				dto.setReport_name(report_name);
				LocalDate localDate = dto.getPortfolioDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String DateString = localDate.format(formatter);
				RT_DataControl data = RT_DatacontrolRepository.getdata(DateString, report_name);
				if (data != null && !data.equals(null)) {
					System.out.println("Service: createOrUpdate() called  ---  Existing");

					RT_DataControl dbUser = new RT_DataControl();
					org.springframework.beans.BeanUtils.copyProperties(data, dbUser);

					data.setContactEmployee1Email1(dto.getContactEmployee1Email1());
					data.setContactEmployee1Name1(dto.getContactEmployee1Name1());
					data.setContactEmployee1Title1(dto.getContactEmployee1Title1());
					data.setContactEmployee2Email2(dto.getContactEmployee2Email2());
					data.setContactEmployee2Name2(dto.getContactEmployee2Name2());
					data.setContactEmployee2Title2(dto.getContactEmployee2Title2());
					data.setSignOffCfoEmail(dto.getSignOffCfoEmail());
					data.setSignOffCfoName(dto.getSignOffCfoName());
					data.setSignOffCroEmail(dto.getSignOffCroEmail());
					data.setSignOffCroName(dto.getSignOffCroName());
					data.setSignOffHeadOfTreasuryName(dto.getSignOffHeadOfTreasuryName());
					data.setSignOffHeadOfTreasuryEmail(dto.getSignOffHeadOfTreasuryEmail());

					List<String> ignoreFields = Arrays.asList("createUser", "modifyUser", "delFlg");

					Map<String, String> changes = new LinkedHashMap<>();

					for (Field field : RT_DataControl.class.getDeclaredFields()) {
						field.setAccessible(true);
						try {
							Object oldValue = field.get(dbUser);
							Object newValue = field.get(data);
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
					//auditService.createBusinessAudit(userid, "MODIFY", "DATACONTROL", changes, "BCBUAE_DATACONTROL");

					RT_DatacontrolRepository.save(data);
				} else {
					System.out.println("Service: createOrUpdate() called  ---  New");
					auditService.createBusinessAudit(userid, "ADD", "DATACONTROL", null, "BCBUAE_DATACONTROL");
					RT_DatacontrolRepository.save(dto);
				}

			}

	        return "Saved successfully.";
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "ERROR: " + e.getMessage();
	    }
	}

}