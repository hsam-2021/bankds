package com.bankds.hs.services;

import org.springframework.http.ResponseEntity;
import com.zebra.pm.domainobjects.services.CustomerData;
import com.zebra.pm.domainobjects.services.LoanData;

public interface ICustomerPrediction {
	public ResponseEntity<String> createPredictionRecord(CustomerData request);

	public ResponseEntity<String> createLoanPredictionRecord(LoanData request);
}
