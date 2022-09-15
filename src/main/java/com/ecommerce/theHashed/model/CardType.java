package com.ecommerce.theHashed.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the card_type database table.
 * 
 */
@Entity
@Table(name="card_type")
public class CardType implements Serializable {
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


	@Column(name="card_type")
	private String cardType;
	
	@Column(name="card_company_name")
	private String cardCompanyName;

	public CardType() {
	}

	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardCompanyName() {
		return cardCompanyName;
	}

	public void setCardCompanyName(String cardCompanyName) {
		this.cardCompanyName = cardCompanyName;
	}
	
}