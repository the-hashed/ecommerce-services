package com.ecommerce.theHashed.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import java.sql.Timestamp;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@TypeDef(name = "json", typeClass = JsonBinaryType.class)
public class Product implements Serializable {
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

	private Integer discount;

	private String name;
	
	private String brand;
	
	private String fabric;

	private Double price;

	@Column(name="products_status")
	private String productsStatus;

	private Integer quantity;

	@Type( type = "json" )
	@Column (nullable = true, columnDefinition = "jsonb")
	private ProductOption sizecoloroption;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	private Integer weight;

	//bi-directional many-to-one association to Collection
	@ManyToOne
	@JoinColumn(name="collection")
	private Collection collection;

	//bi-directional many-to-one association to CustomerAccount
	@ManyToOne
	@JoinColumn(name="created_by")
	private CustomerAccount createdBy;

	//bi-directional many-to-one association to CustomerAccount
	@ManyToOne
	@JoinColumn(name="updated_by")
	private CustomerAccount updatedBy;

	//bi-directional many-to-one association to Media
	@ManyToOne
	@JoinColumn(name="main_media")
	private Media mainMedia;

	//bi-directional many-to-one association to Media
	@ManyToOne
	@JoinColumn(name="media_item")
	private Media mediaItem;

	public Product() {
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

	public Integer getDiscount() {
		return this.discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getFabric() {
		return fabric;
	}

	public void setFabric(String fabric) {
		this.fabric = fabric;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getProductsStatus() {
		return this.productsStatus;
	}

	public void setProductsStatus(String productsStatus) {
		this.productsStatus = productsStatus;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public ProductOption getSizecoloroption() {
		return sizecoloroption;
	}

	public void setSizecoloroption(ProductOption sizecoloroption) {
		this.sizecoloroption = sizecoloroption;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Collection getCollection() {
		return this.collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
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

	public Media getMainMedia() {
		return mainMedia;
	}

	public void setMainMedia(Media mainMedia) {
		this.mainMedia = mainMedia;
	}

	public Media getMediaItem() {
		return mediaItem;
	}

	public void setMediaItem(Media mediaItem) {
		this.mediaItem = mediaItem;
	}
}