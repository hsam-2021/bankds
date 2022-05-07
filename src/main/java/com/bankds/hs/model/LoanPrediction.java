package com.bankds.hs.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "hs_loan_prediction ", schema = "public")
@NamedQuery(name = "LoanPrediction.findAll", query = "SELECT g FROM LoanPrediction g")
public class LoanPrediction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "loan_id")
	@SequenceGenerator(name = "hs_loan_prediction_loan_id_seq", sequenceName = "hs_loan_prediction_loan_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hs_loan_prediction_loan_id_seq")
	private int loanId;

	@Column(name = "gender")
	private String gender;

	@Column(name = "married")
	private String married;

	@Column(name = "dependents")
	private int dependents;

	@Column(name = "education")
	private String education;

	@Column(name = "self_employed")
	private String selfEmployed;

	@Column(name = "applicantincome")
	private int applicantIncome;

	@Column(name = "coapplicantincome")
	private int coapplicantIncome;

	@Column(name = "loanamount")
	private int loanamount;

	@Column(name = "loan_amount_term")
	private int loanAmountTerm;

	@Column(name = "credit_history")
	private int creditHistory;

	@Column(name = "property_area")
	private String propertyArea;

	@Column(name = "loan_status")
	private String loanStatus;

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMarried() {
		return married;
	}

	public void setMarried(String married) {
		this.married = married;
	}

	public int getDependents() {
		return dependents;
	}

	public void setDependents(int dependents) {
		this.dependents = dependents;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSelfEmployed() {
		return selfEmployed;
	}

	public void setSelfEmployed(String selfEmployed) {
		this.selfEmployed = selfEmployed;
	}

	public int getApplicantIncome() {
		return applicantIncome;
	}

	public void setApplicantIncome(int applicantIncome) {
		this.applicantIncome = applicantIncome;
	}

	public int getCoapplicantIncome() {
		return coapplicantIncome;
	}

	public void setCoapplicantIncome(int coapplicantIncome) {
		this.coapplicantIncome = coapplicantIncome;
	}

	public int getCreditHistory() {
		return creditHistory;
	}

	public void setCreditHistory(int creditHistory) {
		this.creditHistory = creditHistory;
	}

	public String getPropertyArea() {
		return propertyArea;
	}

	public void setPropertyArea(String propertyArea) {
		this.propertyArea = propertyArea;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public int getLoanamount() {
		return loanamount;
	}

	public void setLoanamount(int loanamount) {
		this.loanamount = loanamount;
	}

	public int getLoanAmountTerm() {
		return loanAmountTerm;
	}

	public void setLoanAmountTerm(int loanAmountTerm) {
		this.loanAmountTerm = loanAmountTerm;
	}

}
