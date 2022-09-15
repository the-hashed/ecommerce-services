package com.ecommerce.theHashed.pojo;

import java.io.Serializable;

public class CustomerCardPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String bankName;

	private Long cardNo;

	private String customerName;

	private Integer cvv;

	private String expiryDate;

	private CardTypePojo cardTypePojo;
	
	private CustomerAddressPojo customerAddressPojo;
	
	private Boolean isVerified;
	
	private Boolean isdefault;

	private String createdBy;

	private String customerAccount;

	private String updatedBy;

	public CustomerCardPojo() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Long getCardNo() {
		return cardNo;
	}

	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public CardTypePojo getCardTypePojo() {
		return cardTypePojo;
	}

	public void setCardTypePojo(CardTypePojo cardTypePojo) {
		this.cardTypePojo = cardTypePojo;
	}

	public CustomerAddressPojo getCustomerAddressPojo() {
		return customerAddressPojo;
	}

	public void setCustomerAddressPojo(CustomerAddressPojo customerAddressPojo) {
		this.customerAddressPojo = customerAddressPojo;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public Boolean getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(Boolean isdefault) {
		this.isdefault = isdefault;
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
	
}