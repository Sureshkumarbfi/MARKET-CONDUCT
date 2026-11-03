package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MIS_COUNTER_PARTY_LIMIT_DETAILS_REPO extends JpaRepository<MIS_COUNTER_PARTY_LIMIT_DETAILS_ENTITY, Long> {
    // Find details linked to a specific Master Serial Number
    List<MIS_COUNTER_PARTY_LIMIT_DETAILS_ENTITY> findBySrlNo(String srlNo);
}