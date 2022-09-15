package com.ecommerce.theHashed.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class OrderPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private List<String> billingInfo;
	private Integer billingNo;
	private List<Map<String,String>> buyerInfo;
	private Integer discount;
	private String paymentStatus;
	private List<String> products;
	private List<String> shippingInfo;
	private String status;
	private Double total;
	private String customerAccount;
	private String orderItem;

	public OrderPojo() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getBillingInfo() {
		return billingInfo;
	}

	public void setBillingInfo(List<String> billingInfo) {
		this.billingInfo = billingInfo;
	}

	public Integer getBillingNo() {
		return billingNo;
	}

	public void setBillingNo(Integer billingNo) {
		this.billingNo = billingNo;
	}

	public List<Map<String, String>> getBuyerInfo() {
		return buyerInfo;
	}

	public void setBuyerInfo(List<Map<String, String>> buyerInfo) {
		this.buyerInfo = buyerInfo;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public List<String> getProducts() {
		return products;
	}

	public void setProducts(List<String> products) {
		this.products = products;
	}

	public List<String> getShippingInfo() {
		return shippingInfo;
	}

	public void setShippingInfo(List<String> shippingInfo) {
		this.shippingInfo = shippingInfo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(String customerAccount) {
		this.customerAccount = customerAccount;
	}

	public String getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}
}