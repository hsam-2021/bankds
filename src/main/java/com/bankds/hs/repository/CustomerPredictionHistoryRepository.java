package com.bankds.hs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankds.hs.model.CustomerPredictionHistory;

@Repository
public interface CustomerPredictionHistoryRepository extends JpaRepository<CustomerPredictionHistory, Long> {

}
