package com.ecommerce.theHashed.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the customer_cards database table.
 * 
 */
@Entity
@Table(name="customer_cards")
public class CustomerCard implements Serializable {
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
	
	@Column(name="bank_name")
	private String bankName;

	@Column(name="card_no")
	private String cardNo;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="customer_name")
	private String customerName;

	private Integer cvv;

	@Column(name="expiry_date")
	private String expiryDate;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	//bi-directional many-to-one association to CardType
	@ManyToOne
	@JoinColumn(name="card_type")
	private CardType cardType;
	
	@ManyToOne
	@JoinColumn(name="customer_address")
	private CustomerAddress customerAddress;
	
	@Column(name = "isVerified")
	private Boolean isVerified;
	
	@Column(name = "isdefault")
	private Boolean isdefault;

	//bi-directional many-to-one association to CustomerAccount
	@ManyToOne
	@JoinColumn(name="created_by")
	private CustomerAccount createdBy;

	//bi-directional many-to-one association to CustomerAccount
	@ManyToOne
	@JoinColumn(name="customer_account")
	private CustomerAccount customerAccount;

	//bi-directional many-to-one association to CustomerAccount
	@ManyToOne
	@JoinColumn(name="updated_by")
	private CustomerAccount updatedBy;

	public CustomerCard() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getCvv() {
		return this.cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public String getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public CustomerAddress getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Boolean getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(Boolean isdefault) {
		this.isdefault = isdefault;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
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
	
}