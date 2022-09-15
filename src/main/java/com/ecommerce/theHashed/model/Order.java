package com.ecommerce.theHashed.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;


/**
 * The persistent class for the orders database table.
 * 
 */
@TypeDefs({
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@Entity
@Table(name="orders")
public class Order implements Serializable {
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
	
	@Type(type = "jsonb")
    @Column(name="billing_info", columnDefinition = "jsonb")
	private String billingInfo;

	@Column(name="billing_no")
	private Integer billingNo;

	@Type(type = "jsonb")
    @Column(name="buyer_info", columnDefinition = "jsonb")
	private List<Map<String,String>> buyerInfo;

	@Column(name="created_at")
	private Timestamp createdAt;

	private Double discount;

	@Column(name="payment_status")
	private String paymentStatus;

	@Type(type = "jsonb")
    @Column(name="products", columnDefinition = "jsonb")
	private List<Product> products;
	
	@Type(type = "jsonb")
    @Column(name="product_info", columnDefinition = "jsonb")
	private List<Map<String,String>> productInfo;

	@Type(type = "jsonb")
    @Column(name="shipping_info", columnDefinition = "jsonb")
	private String shippingInfo;

	private String status;

	private Double total;
	
	@Column(name="final_Amount")
	private Double finalAmount;

	//bi-directional many-to-one association to CustomerAccount
	@ManyToOne
	@JoinColumn(name="customer_account")
	private CustomerAccount customerAccount;

	//bi-directional many-to-one association to OrderItem
	@OneToOne
	@JoinColumn(name="order_items")
	private OrderItem orderItem;
	
	@Column(name = "is_active")
	private Boolean isActive;

	public Order() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBillingInfo() {
		return billingInfo;
	}

	public void setBillingInfo(String string) {
		this.billingInfo = string;
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

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double d) {
		this.discount = d;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public List<Map<String, String>> getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(List<Map<String, String>> productInfo) {
		this.productInfo = productInfo;
	}

	public String getShippingInfo() {
		return shippingInfo;
	}

	public void setShippingInfo(String string) {
		this.shippingInfo = string;
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

	public Double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(Double finalAmount) {
		this.finalAmount = finalAmount;
	}

	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}