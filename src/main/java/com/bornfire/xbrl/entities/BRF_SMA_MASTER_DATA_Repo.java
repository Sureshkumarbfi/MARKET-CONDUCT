package com.bornfire.xbrl.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BRF_SMA_MASTER_DATA_Repo extends JpaRepository<BRF_SMA_MASTER_DATA_Entity, BRF_SMA_MASTER_DATA_id> {

}
