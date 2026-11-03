package com.bornfire.xbrl.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bornfire.xbrl.entities.MatrixRunJobEntity;
import com.bornfire.xbrl.entities.MatrixRunJobRepository;
import com.bornfire.xbrl.entities.RT_Matrix_monitoring_rep;

import oracle.jdbc.OracleTypes;
import oracle.sql.StructDescriptor;

@Service
public class MatrixRunService {

    @Autowired
    private MatrixRunJobRepository matrixRunJobRepository;

    @Autowired
    private RT_Matrix_monitoring_rep matrixRepo;
    
    @Autowired
	private DataSource srcdataSource;

    @Transactional
    public Map<String, Object> queueRun(Date reportDate, String requestedBy,String Serialno) {
        Long active = matrixRunJobRepository.countActiveJobsForUserAndDate(reportDate, requestedBy);
        if (active != null && active > 0) {
            Map<String, Object> duplicate = new HashMap<String, Object>();
            duplicate.put("accepted", false);
            duplicate.put("message", "A run is already in progress for this date.");
            return duplicate;
        }

        MatrixRunJobEntity job = new MatrixRunJobEntity();
        job.setJobId(UUID.randomUUID().toString());
        job.setSelectedReportDate(reportDate);
        job.setRequestedBy(requestedBy);
        job.setRequestedAt(new Date());
        job.setStatus("QUEUED");
        job.setProcessedRatioCount(0L);
        matrixRunJobRepository.save(job);

        runForDateAsync(job.getJobId(),Serialno);

        Map<String, Object> accepted = new HashMap<String, Object>();
        accepted.put("accepted", true);
        accepted.put("jobId", job.getJobId());
        accepted.put("status", "QUEUED");
        accepted.put("message", "Calculation queued successfully.");
        return accepted;
    }

    @Async
    @Transactional
    public void runForDateAsync(String jobId,String Serialno) {
        MatrixRunJobEntity job = matrixRunJobRepository.findById(jobId).orElse(null);
        if (job == null) {
            return;
        }

        try {
            job.setStatus("RUNNING");
            job.setStartedAt(new Date());
            matrixRunJobRepository.save(job);

            Date selectedDate = job.getSelectedReportDate();
            System.out.println(selectedDate.toString() + " Process Started for the date");
            Connection conn = null;
            CallableStatement cs = null;
            try {
            	
            	conn = srcdataSource.getConnection();
            	conn.setAutoCommit(false);
                        	
            	cs = conn.prepareCall("{ ? = call RT_MATRIX_MONITOR_CALCULATION_FUNCTION(?,?) }");

    			cs.registerOutParameter(1, java.sql.Types.VARCHAR);
    			cs.setDate(2, new java.sql.Date(selectedDate.getTime()));
    			cs.setString(3, Serialno);
    			cs.execute();
            	
            }catch (Exception e) {
            	 e.printStackTrace();
            	throw new RuntimeException("Not able to Proceed : " + e.getMessage().split(":")[1], e);
            	
            	
			}finally {
			    try {
			        if (cs != null) cs.close();
			        if (conn != null) conn.close();
			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }
			}
            
            conn.close();
            matrixRepo.Getcurrentdatematrixcal();
            long count = matrixRepo.countByReportDate(selectedDate,Serialno);

            job.setProcessedRatioCount(count);
            job.setStatus("SUCCESS");
            job.setErrorMessage("Calculation Completed successfully. Processed ratio Date count: " + count);
            job.setEndedAt(new Date());
            matrixRunJobRepository.save(job);
        } catch (Exception ex) {
            job.setStatus("FAILED");
            job.setErrorMessage(ex.getMessage());
            job.setEndedAt(new Date());
            matrixRunJobRepository.save(job);
        }
    }

    @Transactional(readOnly = true)
    public MatrixRunJobEntity getStatus(String jobId) {
        return matrixRunJobRepository.findById(jobId).orElse(null);
    }
}
