package com.ecommerce.theHashed.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the collections database table.
 * 
 */
@Entity
@Table(name="collections")
public class Collection implements Serializable {
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

	@Column(name="created_at")
	private Timestamp createdAt;

	private String description;

	private String name;
	
	private String subcollection;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	//bi-directional many-to-one association to CustomerAccount
	@ManyToOne
	@JoinColumn(name="created_by")
	private CustomerAccount createdBy;

	//bi-directional many-to-one association to CustomerAccount
	@ManyToOne
	@JoinColumn(name="updated_by")
	private CustomerAccount updatedBy;

	public Collection() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubcollection() {
		return subcollection;
	}

	public void setSubcollection(String subcollection) {
		this.subcollection = subcollection;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public CustomerAccount getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(CustomerAccount createdBy) {
		this.createdBy = createdBy;
	}

	public CustomerAccount getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(CustomerAccount updatedBy) {
		this.updatedBy = updatedBy;
	}

}