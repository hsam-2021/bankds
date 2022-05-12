package com.bankds.hs.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bankds.hs.model.LoanPrediction;

@Repository
public interface LoanPredictionRepository extends JpaRepository<LoanPrediction, Long>{
	@Modifying
	@Transactional
	@Query("delete from LoanPrediction a where a.loanId =:loanId")
	public void deleteLoanRecords(@Param("loanId") int loanId);

}
