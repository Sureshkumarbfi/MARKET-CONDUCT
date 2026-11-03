package com.bornfire.xbrl.entities;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface MatrixRunJobRepository extends JpaRepository<MatrixRunJobEntity, String> {

    @Query("SELECT COUNT(j) FROM MatrixRunJobEntity j "
            + "WHERE j.selectedReportDate = :reportDate "
            + "AND j.requestedBy = :requestedBy "
            + "AND j.status IN ('QUEUED','RUNNING')")
    Long countActiveJobsForUserAndDate(
            @Param("reportDate") Date reportDate,
            @Param("requestedBy") String requestedBy);
}
