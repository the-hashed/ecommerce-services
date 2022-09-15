package com.ecommerce.theHashed.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.array.StringArrayType;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the order_items database table.
 * 
 */

@TypeDefs({
    @TypeDef(
        name = "string-array", 
        typeClass = StringArrayType.class
    )
})
@Entity
@Table(name="order_items")
public class OrderItem implements Serializable {
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

	@Column(name="delivery_method")
	private String deliveryMethod;

	private String promo;

	private Integer quantity;

	//bi-directional many-to-one association to CartDetail
	@Type(type = "string-array")
    @Column(name = "cart_id", columnDefinition = "text[]")
	private String[] cartDetail;

	//bi-directional many-to-one association to CustomeAddress
	@OneToMany
	@JoinColumn(name="customer_address")
	private List<CustomerAddress> customerAddress;

	//bi-directional many-to-one association to CustomerAccount
	@ManyToOne
	@JoinColumn(name="created_by")
	private CustomerAccount createdBy;

	@ManyToOne
	@JoinColumn(name="customer_account")
	private CustomerAccount customerAccount;

	//bi-directional many-to-one association to CustomerCard
	@OneToMany
	@JoinColumn(name="customer_card")
	private List<CustomerCard> customerCard;

	public OrderItem() {
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
	
	public List<CustomerAddress> getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(List<CustomerAddress> customerAddress) {
		this.customerAddress = customerAddress;
	}

	public List<CustomerCard> getCustomerCard() {
		return customerCard;
	}

	public void setCustomerCard(List<CustomerCard> customerCard) {
		this.customerCard = customerCard;
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
		
}