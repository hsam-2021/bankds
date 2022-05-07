package com.bankds.hs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.bankds.hs.services.ICustomerPrediction;
import com.zebra.pm.domainobjects.services.CustomerData;
import com.zebra.pm.domainobjects.services.LoanData;

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

}
