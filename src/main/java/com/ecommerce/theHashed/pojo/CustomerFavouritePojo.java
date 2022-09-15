package com.ecommerce.theHashed.pojo;

import java.io.Serializable;

public class CustomerFavouritePojo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String createdBy;

	private String customerAccount;

	private String updatedBy;
	
	private String product;

	public CustomerFavouritePojo() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

}