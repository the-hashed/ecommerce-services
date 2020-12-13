package com.ecommerce.theHashed.model;

import javax.persistence.*;

@Entity
@Table(name="account_type")
public class AccountType{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="account_type")
	private String accountType;

	public AccountType() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}