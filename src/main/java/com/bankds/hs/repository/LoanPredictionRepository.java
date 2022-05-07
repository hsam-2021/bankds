package com.bankds.hs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bankds.hs.model.LoanPrediction;

@Repository
public interface LoanPredictionRepository extends JpaRepository<LoanPrediction, Long>{

}
