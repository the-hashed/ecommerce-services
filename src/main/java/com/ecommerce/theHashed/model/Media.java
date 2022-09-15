package com.ecommerce.theHashed.model;

import java.io.Serializable;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the media database table.
 * 
 */
@Entity
public class Media implements Serializable {
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

	@Column(name="created_by")
	private Integer createdBy;

	private String description;

	private byte[] media;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="updated_by")
	private Integer updatedBy;

	public Media() {
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

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getMedia() {
		return this.media;
	}

	public void setMedia(byte[] media) {
		this.media = media;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

}