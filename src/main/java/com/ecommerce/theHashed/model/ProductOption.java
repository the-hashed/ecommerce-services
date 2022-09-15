package com.ecommerce.theHashed.model;

import java.io.Serializable;
import java.util.List;


public class ProductOption implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<String> color;

	private List<String> size;

	public List<String> getColor() {
		return color;
	}

	public void setColor(List<String> color) {
		this.color = color;
	}

	public List<String> getSize() {
		return size;
	}

	public void setSize(List<String> size) {
		this.size = size;
	}
	
}
