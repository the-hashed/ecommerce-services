package com.ecommerce.theHashed.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the customer_account database table.
 * 
 */
@Entity
@Table(name="customer_account")
public class CustomerAccount{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "password")
	private String password;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="account_type")
	private AccountType accountType;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="customer_currency")
	private CustomerCurrency customerCurrency;
	
	@Column(name = "isEmailVerified")
	private Boolean isEmailVerified;
	
	@Column(name = "isMobileVerified")
	private Boolean isMobileVerified;

	@Column(name = "passwordResetCompleted")
	private Boolean passwordResetCompleted;
	
	public CustomerAccount() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountType getAccountType() {
		return this.accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
	public CustomerCurrency getCustomerCurrency() {
		return customerCurrency;
	}

	public void setCustomerCurrency(CustomerCurrency customerCurrency) {
		this.customerCurrency = customerCurrency;
	}

	public Boolean isEmailVerified() {
		return isEmailVerified;
	}

	public void setEmailVerified(Boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}

	
	public Boolean isMobileVerified() {
		return isMobileVerified;
	}

	public void setMobileVerified(Boolean isMobileVerified) {
		this.isMobileVerified = isMobileVerified;
	}

	public Boolean isPasswordResetCompleted() {
		return passwordResetCompleted;
	}

	public void setPasswordResetCompleted(Boolean passwordResetCompleted) {
		this.passwordResetCompleted = passwordResetCompleted;
	}

}