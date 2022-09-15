package com.ecommerce.theHashed.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class CustomerAddressPojo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String address1;

	private String address2;

	private String city;

	private String companyName;

	private String country;

	private Timestamp createdAt;

	private String firstName;

	private String lastName;

	private String mobileNo;

	private String region;

	private Timestamp updatedAt;

	private Integer zipCode;

	private Boolean isShippingAddress;

	private Boolean isBillingAddress;
	
	private String createdBy;

	private String customerAccount;

	private String updatedBy;
	
	private Boolean isDefault;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
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

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public Boolean getIsShippingAddress() {
		return isShippingAddress;
	}

	public void setIsShippingAddress(Boolean isShippingAddress) {
		this.isShippingAddress = isShippingAddress;
	}

	public Boolean getIsBillingAddress() {
		return isBillingAddress;
	}

	public void setIsBillingAddress(Boolean isBillingAddress) {
		this.isBillingAddress = isBillingAddress;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(String customerAccount) {
		this.customerAccount = customerAccount;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}
		
}