package com.bornfire.xbrl.services;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bornfire.xbrl.entities.AccessAndRoles;
import com.bornfire.xbrl.entities.RtBloombergData;
import com.bornfire.xbrl.entities.RtBloombergData_Rep;

@Service
@ConfigurationProperties("output")
@Transactional
public class Bloomberg_services {

    @Autowired
    RtBloombergData_Rep repo;
    
    @Autowired
	AuditService auditservice;

    
 
    public String addData(RtBloombergData data, String formmode, String userid) {

        if ("add".equalsIgnoreCase(formmode)) {

            if (repo.existsByIsinAndDelFlg(data.getIsin(),"N")) {
                return "ISIN Already Exists";
            }

            data.setEntryUser(userid);
            data.setEntryDate(new Date());
            data.setDelFlg("N");
            repo.save(data);
            
            //audit
            RtBloombergData newdata=new RtBloombergData(); 
	        Map<String, String> changes = new LinkedHashMap<>();

	        for (Field field : RtBloombergData.class.getDeclaredFields()) {
	            field.setAccessible(true);
	            try {
	                Object oldValue = field.get(newdata);
	                Object newValue = field.get(data);    
	                if ((oldValue == null || oldValue.toString().trim().isEmpty()) &&
	                    (newValue == null || newValue.toString().trim().isEmpty())) {
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
	            auditservice.createBusinessAudit(userid,"ADD","Bloomberg_Data_SCREEN",changes,"RT_BLOOMBERG_DATA");
	        } 

            return "Bloomberg Data Added Successfully";
        }

        else if ("edit".equalsIgnoreCase(formmode)) {

            Optional<RtBloombergData> optional = repo.findByIsinAndDelFlg(data.getIsin(),"N");

            if (!optional.isPresent()) {
                return "ISIN NOT FOUND";
            }

            RtBloombergData existing = optional.get();

            existing.setCouponType(data.getCouponType());
            existing.setName(data.getName());
            existing.setCountryOfRisk(data.getCountryOfRisk());
            existing.setDescription(data.getDescription());
            existing.setSector(data.getSector());
            existing.setCurrency(data.getCurrency());
            existing.setAmountIssued(data.getAmountIssued());
            existing.setCleanPrice(data.getCleanPrice());
            existing.setYtm(data.getYtm());
            existing.setMaturityDate(data.getMaturityDate());
            existing.setStatusflg(data.getStatusflg());
            existing.setModifyUser(userid);
            existing.setModifyDate(new Date());;

   
            
          //audit
            RtBloombergData dbUser = optional.get();
	        List<String> ignoreFields = Arrays.asList(
            	    "entryDate", "modifyDate", "verifyDate", "entryUser",
            	    "modifyUser", "verifyUser", "entryFlg","modifyFlg","verifyFlg",
            	    "delFlg"
            	);
	         
	        Map<String, String> changes = new LinkedHashMap<>();

	        for (Field field : RtBloombergData.class.getDeclaredFields()) {
	            field.setAccessible(true);
	            try {
	                Object oldValue = field.get(dbUser);
	                Object newValue = field.get(existing);    
	                if ((oldValue == null || oldValue.toString().trim().isEmpty()) &&
	                    (newValue == null || newValue.toString().trim().isEmpty())) {
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
	        auditservice.createBusinessAudit(userid,"MODIFY","Bloomberg_Data_SCREEN",changes,"RT_BLOOMBERG_DATA");

	        repo.save(existing);
            return "Bloomberg Data Updated Successfully";
        }
        
        else if("Delete".equalsIgnoreCase(formmode)) {
        	 Optional<RtBloombergData> optional = repo.findByIsinAndDelFlg(data.getIsin(),"N");
        	 
             if (!optional.isPresent()) {
                 return "ISIN NOT FOUND";
             }
             
             RtBloombergData existing = optional.get();
             existing.setDelFlg("Y");
             
             RtBloombergData newdata=new RtBloombergData(); 
 	        Map<String, String> changes = new LinkedHashMap<>();

 	        for (Field field : RtBloombergData.class.getDeclaredFields()) {
 	            field.setAccessible(true);
 	            try {
 	                Object oldValue = field.get(data);
 	                Object newValue = field.get(newdata);    
 	                if ((oldValue == null || oldValue.toString().trim().isEmpty()) &&
 	                    (newValue == null || newValue.toString().trim().isEmpty())) {
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
 	        }               auditservice.createBusinessAudit(userid,"Delete","Bloomberg_Data_SCREEN",changes,"RT_BLOOMBERG_DATA");
 	        
             
             
             repo.save(existing);
             
             return "Bloomberg Data Deleted Successfully";
        }
        
        
        
        
        return "Invalid Operation";
    }
  
}
