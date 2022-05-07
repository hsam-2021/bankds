package com.bankds.hs.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "hs_customer_prediction_history ", schema = "public")
@NamedQuery(name = "CustomerPredictionHistory.findAll", query = "SELECT g FROM CustomerPredictionHistory g")
public class CustomerPredictionHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "hs_customer_prediction_id_seq", sequenceName = "hs_customer_prediction_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hs_customer_prediction_id_seq")
	private int id;

	@Column(name = "age")
	private int age;

	@Column(name = "job")
	private String job;

	@Column(name = "marital")
	private String marital;

	@Column(name = "education")
	private String education;

	@Column(name = "balance")
	private int balance;

	@Column(name = "housing")
	private String housing;

	@Column(name = "loan")
	private String loan;

	@Column(name = "contact")
	private String contact;

	@Column(name = "day")
	private int day;

	@Column(name = "month")
	private String month;

	@Column(name = "duration")
	private int duration;

	@Column(name = "campaign")
	private int campaign;

	@Column(name = "previous")
	private int previous;

	@Column(name = "poutcome")
	private String poutcome;

	@Column(name = "deposit")
	private String deposit;

	@Column(name = "deletion_time")
	private Date deletionTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMarital() {
		return marital;
	}

	public void setMarital(String marital) {
		this.marital = marital;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getHousing() {
		return housing;
	}

	public void setHousing(String housing) {
		this.housing = housing;
	}

	public String getLoan() {
		return loan;
	}

	public void setLoan(String loan) {
		this.loan = loan;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getCampaign() {
		return campaign;
	}

	public void setCampaign(int campaign) {
		this.campaign = campaign;
	}

	public int getPrevious() {
		return previous;
	}

	public void setPrevious(int previous) {
		this.previous = previous;
	}

	public String getPoutcome() {
		return poutcome;
	}

	public void setPoutcome(String poutcome) {
		this.poutcome = poutcome;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public Date getDeletionTime() {
		return deletionTime;
	}

	public void setDeletionTime(Date deletionTime) {
		this.deletionTime = deletionTime;
	}

}
