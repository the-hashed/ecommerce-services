package com.ecommerce.theHashed.model;

import java.io.Serializable;

import javax.persistence.*;
/**
 * The persistent class for the customer_currency database table.
 * 
 */
@Entity
@Table(name="customer_currency")
public class CustomerCurrency implements Serializable {

	/**
	 * 
	 */
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
	

	@Column(name="currency_name")
	private String currencyName;

	public CustomerCurrency() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCurrencyName() {
		return this.currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
}