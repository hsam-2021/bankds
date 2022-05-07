package com.bankds.hs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankds.hs.model.CustomerPrediction;

@Repository
public interface CustomerPredictionRepository extends JpaRepository<CustomerPrediction, Long> {

}
