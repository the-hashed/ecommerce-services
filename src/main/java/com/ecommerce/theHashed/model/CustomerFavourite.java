package com.ecommerce.theHashed.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the customer_favourites database table.
 * 
 */
@Entity
@Table(name="customer_favourites")
public class CustomerFavourite implements Serializable {
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

	@ManyToOne
	@JoinColumn(name="created_by")
	private CustomerAccount createdBy;

	//bi-directional many-to-one association to CustomerAccount
	@ManyToOne
	@JoinColumn(name="customer_account")
	private CustomerAccount customerAccount;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	public CustomerFavourite() {
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

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}