package com.bankds.hs.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.bankds.hs.model.CustomerPrediction;
import com.bankds.hs.model.CustomerPredictionHistory;
import com.bankds.hs.model.LoanPrediction;
import com.bankds.hs.model.LoanPredictionHistory;
import com.zebra.pm.domainobjects.services.CustomerData;
import com.zebra.pm.domainobjects.services.CustomerDeletedData;
import com.zebra.pm.domainobjects.services.LoanData;
import com.zebra.pm.domainobjects.services.LoanDeletedData;

public interface ICustomerPrediction {
	public ResponseEntity<String> createPredictionRecord(CustomerData request);

	public ResponseEntity<String> createLoanPredictionRecord(LoanData request);

	public List<CustomerPrediction> getCustomerData();

	public List<LoanPrediction> getLoanData();

	public List<CustomerPredictionHistory> getCustomerHistoricalData();

	public List<LoanPredictionHistory> getLoanHistoricalData();

	public ResponseEntity<String> deleteCustRecords(CustomerDeletedData request);

	public ResponseEntity<String> deleteLoanRecords(LoanDeletedData request);
}
