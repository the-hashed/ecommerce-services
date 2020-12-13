package com.ecommerce.theHashed.model;

import javax.persistence.*;
/**
 * The persistent class for the customer_currency database table.
 * 
 */
@Entity
@Table(name="customer_currency")
public class CustomerCurrency {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="currency_name")
	private String currencyName;

	public CustomerCurrency() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurrencyName() {
		return this.currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
}