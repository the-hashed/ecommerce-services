package com.ecommerce.theHashed.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the custome_address database table.
 * 
 */
@Entity
@Table(name="customer_address")
public class CustomerAddress implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AccountType)) {
			return false;
		}
		AccountType other = (AccountType) obj;
		return getId().equals(other.getId());
	}


	@Column(name="address_1")
	private String address1;

	@Column(name="address_2")
	private String address2;

	@Column(name="city")
	private String city;

	@Column(name="company_name")
	private String companyName;

	@Column(name="country")
	private String country;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="mobile_no")
	private String mobileNo;
	
	@Column(name="region")
	private String region;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="zip_code")
	private Integer zipCode;

	@Column(name = "isShippingAddress")
	private Boolean isShippingAddress;
	
	@Column(name = "isBillingAddress")
	private Boolean isBillingAddress;

	@ManyToOne
	@JoinColumn(name="created_by")
	private CustomerAccount createdBy;

	@ManyToOne
	@JoinColumn(name="customer_account")
	private CustomerAccount customerAccount;

	@ManyToOne
	@JoinColumn(name="updated_by")
	private CustomerAccount updatedBy;
	
	@Column(name = "isdefault")
	private Boolean isdefault;


	public CustomerAddress() {
	}

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

	public CustomerAccount getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(CustomerAccount createdBy) {
		this.createdBy = createdBy;
	}

	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}

	public CustomerAccount getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(CustomerAccount updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Boolean getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(Boolean isdefault) {
		this.isdefault = isdefault;
	}
}