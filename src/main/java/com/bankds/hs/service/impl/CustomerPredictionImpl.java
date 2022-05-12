package com.bankds.hs.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.bankds.hs.model.CustomerPrediction;
import com.bankds.hs.model.CustomerPredictionHistory;
import com.bankds.hs.model.LoanPrediction;
import com.bankds.hs.model.LoanPredictionHistory;
import com.bankds.hs.repository.CustomerPredictionHistoryRepository;
import com.bankds.hs.repository.CustomerPredictionRepository;
import com.bankds.hs.repository.LoanPredictionHistoryRepository;
import com.bankds.hs.repository.LoanPredictionRepository;
import com.bankds.hs.services.ICustomerPrediction;
import com.zebra.pm.domainobjects.services.CustomerData;
import com.zebra.pm.domainobjects.services.CustomerDeletedData;
import com.zebra.pm.domainobjects.services.LoanData;
import com.zebra.pm.domainobjects.services.LoanDeletedData;

@Component
public class CustomerPredictionImpl implements ICustomerPrediction {
	private static final Logger LOG = LoggerFactory.getLogger(CustomerPredictionImpl.class);

	@Autowired
	CustomerPredictionRepository customerPredictionRepository;

	@Autowired
	LoanPredictionRepository loanPredictionRepository;

	@Autowired
	CustomerPredictionHistoryRepository customerPredictionHistoryRepository;

	@Autowired
	LoanPredictionHistoryRepository loanPredictionHistoryRepository;

	@Override
	public ResponseEntity<String> createPredictionRecord(CustomerData request) {
		CustomerPrediction customerPrediction = null;
		boolean success = true;
		if (request != null) {
			try {
				customerPrediction = new CustomerPrediction();
				customerPrediction.setAge(request.getAge());
				customerPrediction.setJob(request.getJob());
				customerPrediction.setMarital(request.getMaritalStatus());
				customerPrediction.setEducation(request.getEducation());
				customerPrediction.setBalance(request.getBalance());
				customerPrediction.setHousing(request.getHousing());
				customerPrediction.setLoan(request.getLoan());
				customerPrediction.setContact(request.getContact());
				customerPrediction.setDay(request.getDay());
				customerPrediction.setMonth(request.getMonth());
				customerPrediction.setDuration(request.getDuration());
				customerPrediction.setCampaign(request.getCampaign());
				customerPrediction.setPrevious(request.getPrevious());
				customerPrediction.setPoutcome(request.getPoutcome());
				customerPrediction.setDeposit(request.getDeposit());
				customerPredictionRepository.save(customerPrediction);
			} catch (Exception e) {

				success = false;
				LOG.info("Exception occurred saving customer prediction record " + e.getMessage());
			}
		} else {
			success = false;
			LOG.info("No Records to update");
		}
		if (success) {
			return ResponseEntity.ok().body("Customer Data Saved successfully");
		} else {
			return new ResponseEntity<String>("Fail -> Error Saving Customer Data!", HttpStatus.BAD_REQUEST);
		}

	}

	@Override
	public ResponseEntity<String> createLoanPredictionRecord(LoanData request) {
		boolean success = true;
		LoanPrediction loanPrediction = null;
		if (request != null) {
			try {
				loanPrediction = new LoanPrediction();
				loanPrediction.setGender(request.getGender());
				loanPrediction.setMarried(request.getMarried());
				loanPrediction.setDependents(request.getDependent());
				loanPrediction.setEducation(request.getEducation());
				loanPrediction.setSelfEmployed(request.getSelfEmployed());
				loanPrediction.setApplicantIncome(request.getApplicantIncome());
				loanPrediction.setCoapplicantIncome(request.getCoApplicantIncome());
				loanPrediction.setLoanamount(request.getLoanAmount());
				loanPrediction.setLoanAmountTerm(request.getLoanAmountTerm());
				loanPrediction.setCreditHistory(request.getCreditHistory());
				loanPrediction.setPropertyArea(request.getPropertyArea());
				loanPrediction.setLoanStatus(request.getLoanStatus());
				loanPredictionRepository.save(loanPrediction);
			} catch (Exception e) {
				success = false;
				LOG.info("Exception occurred saving loan prediction record " + e.getMessage());
			}
		} else {
			success = false;
			LOG.info("No Records to update");
		}

		if (success) {
			return ResponseEntity.ok().body("Loan Data Saved successfully");
		} else {
			return new ResponseEntity<String>("Fail -> Error Saving Loan Data!", HttpStatus.BAD_REQUEST);
		}

	}

	public List<CustomerPrediction> getCustomerData() {
		return customerPredictionRepository.findAll();
	}

	public List<LoanPrediction> getLoanData() {
		return loanPredictionRepository.findAll();
	}

	public List<CustomerPredictionHistory> getCustomerHistoricalData() {
		return customerPredictionHistoryRepository.findAll();
	}

	public List<LoanPredictionHistory> getLoanHistoricalData() {
		return loanPredictionHistoryRepository.findAll();
	}

	public ResponseEntity<String> deleteCustRecords(CustomerDeletedData request) {
		boolean success = true;
		if (request != null) {

			try {
				for (int custId : request.getCustId()) {
					customerPredictionRepository.deleteCustomerRecords(custId);
				}
			} catch (Exception e) {
				LOG.error("Exception Occured while deleting customer records:" + e.getMessage());
				success = false;
			}

		} else {
			LOG.info("No Records to delete");
			success = false;
		}
		if (success) {
			return ResponseEntity.ok().body("Customer Data deleted successfully");
		} else {
			return new ResponseEntity<String>("Fail -> Error Deleting Customer Data!", HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<String> deleteLoanRecords(LoanDeletedData request) {
		boolean success = true;
		if (request != null) {
			try {
				for (int loanId : request.getLoanId()) {
					loanPredictionRepository.deleteLoanRecords(loanId);
				}
			} catch (Exception e) {
				LOG.error("Exception Occured while deleting loan records:" + e.getMessage());
				success = false;
			}
		} else {
			LOG.info("No Records to delete");
			success = false;
		}
		if (success) {
			return ResponseEntity.ok().body("Loan Data deleted successfully");
		} else {
			return new ResponseEntity<String>("Fail -> Error Deleting Loan Data!", HttpStatus.BAD_REQUEST);
		}
	}
}
