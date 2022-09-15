package com.ecommerce.theHashed.pojo;

import java.io.Serializable;

public class CardTypePojo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	private String cardType;

	private String cardCompanyName;

	public CardTypePojo() {
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