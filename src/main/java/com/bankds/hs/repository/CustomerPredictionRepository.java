package com.bankds.hs.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bankds.hs.model.CustomerPrediction;

@Repository
public interface CustomerPredictionRepository extends JpaRepository<CustomerPrediction, Long> {
	
	@Modifying
	@Transactional
	@Query("delete from CustomerPrediction a where a.id =:custId")
	public void deleteCustomerRecords(@Param("custId") int custId);

}
