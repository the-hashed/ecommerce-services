package com.ecommerce.theHashed.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;


/**
 * The persistent class for the card_type database table.
 * 
 */
@Entity
@Table(name="customer_rewards")
public class CustomerRewards implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	public String getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CustomerAccount)) {
			return false;
		}
		CustomerAccount other = (CustomerAccount) obj;
		return getId().equals(other.getId());
	}
	

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}


	@Column(name="coupon_name")
	private String couponName;
	
	@Column(name="discount_amount")
	private Double discountAmount;
	
	@Column(name="discount_percentage")
	private Integer discountPercentage;
	
	@ManyToOne
	@JoinColumn(name="customer_account")
	private CustomerAccount customerAccount;
	
	@Column(name="created_at")
	private Timestamp createdAt;
	
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

	public CustomerRewards() {
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Integer getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Integer discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
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
}