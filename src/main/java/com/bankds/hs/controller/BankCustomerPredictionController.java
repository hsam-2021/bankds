package com.bankds.hs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankds.hs.model.CustomerPrediction;
import com.bankds.hs.model.CustomerPredictionHistory;
import com.bankds.hs.model.LoanPrediction;
import com.bankds.hs.model.LoanPredictionHistory;
import com.bankds.hs.services.ICustomerPrediction;
import com.zebra.pm.domainobjects.services.CustomerData;
import com.zebra.pm.domainobjects.services.CustomerDeletedData;
import com.zebra.pm.domainobjects.services.LoanData;
import com.zebra.pm.domainobjects.services.LoanDeletedData;

@CrossOrigin
@RestController
@RequestMapping("/customer/v1")
@ResponseBody
public class BankCustomerPredictionController {

	@Autowired
	ICustomerPrediction customerPrediction;

	@RequestMapping(value = "/createPredictionRecord", method = RequestMethod.POST)
	public ResponseEntity<String> createPredictionRecord(@RequestBody CustomerData request) {
		return customerPrediction.createPredictionRecord(request);
	}

	@RequestMapping(value = "/createLoanPredictionRecord", method = RequestMethod.POST)
	public ResponseEntity<String> createLoanPredictionRecord(@RequestBody LoanData request) {
		return customerPrediction.createLoanPredictionRecord(request);
	}

	@RequestMapping(value = "/getCustomerData", method = RequestMethod.GET)
	public List<CustomerPrediction> getCustomerData() {
		return customerPrediction.getCustomerData();
	}

	@RequestMapping(value = "/getLoanData", method = RequestMethod.GET)
	public List<LoanPrediction> getLoanData() {
		return customerPrediction.getLoanData();
	}
	
	@RequestMapping(value = "/getCustomerHistoricalData", method = RequestMethod.GET)
	public List<CustomerPredictionHistory> getCustomerHistoricalData() {
		return customerPrediction.getCustomerHistoricalData();
	}

	@RequestMapping(value = "/getLoanHistoricalData", method = RequestMethod.GET)
	public List<LoanPredictionHistory> getLoanHistoricalData() {
		return customerPrediction.getLoanHistoricalData();
	}
	
	@RequestMapping(value = "/deleteCustRecords", method = RequestMethod.POST)
	public ResponseEntity<String> deleteCustRecords(@RequestBody CustomerDeletedData request){
		return customerPrediction.deleteCustRecords(request);
	}
	
	@RequestMapping(value = "/deleteLoanRecords", method = RequestMethod.POST)
	public ResponseEntity<String> deleteLoanRecords(@RequestBody LoanDeletedData request){
		return customerPrediction.deleteLoanRecords(request);
	}
}