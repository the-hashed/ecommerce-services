package com.ecommerce.theHashed.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the customer_fraud_details database table.
 * 
 */
@Entity
@Table(name="customer_fraud_details")
public class CustomerFraudDetail implements Serializable {
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

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="is_black_listed")
	private Boolean isBlackListed;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="updated_by")
	private Integer updatedBy;

	//bi-directional many-to-one association to CustomerAccount
	@ManyToOne
	@JoinColumn(name="user_id")
	private CustomerAccount customerAccount;

	public CustomerFraudDetail() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Boolean getIsBlackListed() {
		return this.isBlackListed;
	}

	public void setIsBlackListed(Boolean isBlackListed) {
		this.isBlackListed = isBlackListed;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public CustomerAccount getCustomerAccount() {
		return this.customerAccount;
	}

	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}

}