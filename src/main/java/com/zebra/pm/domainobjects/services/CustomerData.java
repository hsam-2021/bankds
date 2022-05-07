//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.05.01 at 11:31:08 AM EDT 
//


package com.zebra.pm.domainobjects.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="age" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="job" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="marital_status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="education" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="balance" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="housing" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="loan" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contact" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="day" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="month" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="campaign" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="previous" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="poutcome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deposit" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "age",
    "job",
    "maritalStatus",
    "education",
    "balance",
    "housing",
    "loan",
    "contact",
    "day",
    "month",
    "duration",
    "campaign",
    "previous",
    "poutcome",
    "deposit"
})
@XmlRootElement(name = "customerData")
public class CustomerData {

    protected int age;
    @XmlElement(required = true)
    protected String job;
    @XmlElement(name = "marital_status", required = true)
    protected String maritalStatus;
    @XmlElement(required = true)
    protected String education;
    protected int balance;
    @XmlElement(required = true)
    protected String housing;
    @XmlElement(required = true)
    protected String loan;
    @XmlElement(required = true)
    protected String contact;
    protected int day;
    @XmlElement(required = true)
    protected String month;
    protected int duration;
    protected int campaign;
    protected int previous;
    @XmlElement(required = true)
    protected String poutcome;
    @XmlElement(required = true)
    protected String deposit;

    /**
     * Gets the value of the age property.
     * 
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     */
    public void setAge(int value) {
        this.age = value;
    }

    /**
     * Gets the value of the job property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJob() {
        return job;
    }

    /**
     * Sets the value of the job property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJob(String value) {
        this.job = value;
    }

    /**
     * Gets the value of the maritalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * Sets the value of the maritalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaritalStatus(String value) {
        this.maritalStatus = value;
    }

    /**
     * Gets the value of the education property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEducation() {
        return education;
    }

    /**
     * Sets the value of the education property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEducation(String value) {
        this.education = value;
    }

    /**
     * Gets the value of the balance property.
     * 
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Sets the value of the balance property.
     * 
     */
    public void setBalance(int value) {
        this.balance = value;
    }

    /**
     * Gets the value of the housing property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHousing() {
        return housing;
    }

    /**
     * Sets the value of the housing property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHousing(String value) {
        this.housing = value;
    }

    /**
     * Gets the value of the loan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoan() {
        return loan;
    }

    /**
     * Sets the value of the loan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoan(String value) {
        this.loan = value;
    }

    /**
     * Gets the value of the contact property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContact(String value) {
        this.contact = value;
    }

    /**
     * Gets the value of the day property.
     * 
     */
    public int getDay() {
        return day;
    }

    /**
     * Sets the value of the day property.
     * 
     */
    public void setDay(int value) {
        this.day = value;
    }

    /**
     * Gets the value of the month property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonth() {
        return month;
    }

    /**
     * Sets the value of the month property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonth(String value) {
        this.month = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     */
    public void setDuration(int value) {
        this.duration = value;
    }

    /**
     * Gets the value of the campaign property.
     * 
     */
    public int getCampaign() {
        return campaign;
    }

    /**
     * Sets the value of the campaign property.
     * 
     */
    public void setCampaign(int value) {
        this.campaign = value;
    }

    /**
     * Gets the value of the previous property.
     * 
     */
    public int getPrevious() {
        return previous;
    }

    /**
     * Sets the value of the previous property.
     * 
     */
    public void setPrevious(int value) {
        this.previous = value;
    }

    /**
     * Gets the value of the poutcome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoutcome() {
        return poutcome;
    }

    /**
     * Sets the value of the poutcome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoutcome(String value) {
        this.poutcome = value;
    }

    /**
     * Gets the value of the deposit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeposit() {
        return deposit;
    }

    /**
     * Sets the value of the deposit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeposit(String value) {
        this.deposit = value;
    }

}
