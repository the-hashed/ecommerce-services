package com.ecommerce.theHashed.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cart_details database table.
 * 
 */
@Entity
@Table(name="cart_details")
public class CartDetail implements Serializable {
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
		if (!(obj instanceof CustomerCurrency)) {
			return false;
		}
		CustomerCurrency other = (CustomerCurrency) obj;
		return getId().equals(other.getId());
	}


	@Column(name="created_at")
	private Timestamp createdAt;

	@ManyToOne
	@JoinColumn(name="customer_account")
	private CustomerAccount customerAccount;

	private String status;
	
	private String color;

	private String size;
	
	private Integer quantity;
	
	@Column(name="total_product_cost")
	private Double totalProductCost;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	//bi-directional many-to-one association to CustomerAccount
	@ManyToOne
	@JoinColumn(name="created_by")
	private CustomerAccount createdBy;

	//bi-directional many-to-one association to CustomerAccount
	@ManyToOne
	@JoinColumn(name="updated_by")
	private CustomerAccount updatedBy;
	
	@ManyToOne
	private Product product;

	public CartDetail() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return totalProductCost;
	}

	public void setPrice(Double totalProductCost) {
		this.totalProductCost = totalProductCost;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public CustomerAccount getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(CustomerAccount createdBy) {
		this.createdBy = createdBy;
	}

	public CustomerAccount getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(CustomerAccount updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}