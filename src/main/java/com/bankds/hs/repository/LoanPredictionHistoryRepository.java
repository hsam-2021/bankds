package com.bankds.hs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bankds.hs.model.LoanPredictionHistory;

@Repository
public interface LoanPredictionHistoryRepository extends JpaRepository<LoanPredictionHistory, Long> {

}
