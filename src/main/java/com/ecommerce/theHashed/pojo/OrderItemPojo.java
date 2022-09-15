package com.ecommerce.theHashed.pojo;

import java.io.Serializable;

public class OrderItemPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String deliveryMethod;

	private String promo;

	private Integer quantity;

	private String[] cartDetail;
	
	private String createdBy;

	private String customerAccount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public String getPromo() {
		return promo;
	}

	public void setPromo(String promo) {
		this.promo = promo;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String[] getCartDetail() {
		return cartDetail;
	}

	public void setCartDetail(String[] cartDetail) {
		this.cartDetail = cartDetail;
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
}