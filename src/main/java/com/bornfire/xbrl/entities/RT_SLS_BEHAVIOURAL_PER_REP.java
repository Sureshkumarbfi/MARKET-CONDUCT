package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_SLS_BEHAVIOURAL_PER_REP
        extends JpaRepository<RT_SLS_BEHAVIOURAL_PER_ENTITY, String> {

    @Transactional
    @Modifying
    @Query("DELETE FROM RT_SLS_BEHAVIOURAL_PER_ENTITY a WHERE a.reportDate = ?1")
    void deleteByReportDate(Date reportDate);

    boolean existsByReportDate(Date reportDate);

    @Query("SELECT DISTINCT r.reportDate FROM RT_SLS_BEHAVIOURAL_PER_ENTITY r ORDER BY r.reportDate DESC")
    List<Date> findUploadedDates();
}