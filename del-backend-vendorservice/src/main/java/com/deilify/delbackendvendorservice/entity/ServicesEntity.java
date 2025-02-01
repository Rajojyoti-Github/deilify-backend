package com.deilify.delbackendvendorservice.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "services")
public class ServicesEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	@Column(name = "vendor_id")
    private Integer vendorId;
    
	@Column(name = "name_of_vendor")
    private String nameOfVendor;
    
    private String category;
    
	@Column(name = "vendor_store_id")
    private String vendorStoreId;
    
	@Column(name = "sub_category")
    private String subCategory;
    
	@Column(name = "service_line")
    private String serviceLine;
    
    private BigDecimal price;
    
	@Column(name = "created_timestamp")
    private LocalDateTime createdTimestamp;
    
	@Column(name = "updated_timestamp")
    private LocalDateTime updatedTimestamp;
    
    @ManyToOne
	@JoinColumn(name = "vendor_id", referencedColumnName = "id", insertable = false, updatable = false)
	private VendorEntity vendorEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public String getNameOfVendor() {
		return nameOfVendor;
	}

	public void setNameOfVendor(String nameOfVendor) {
		this.nameOfVendor = nameOfVendor;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getVendorStoreId() {
		return vendorStoreId;
	}

	public void setVendorStoreId(String vendorStoreId) {
		this.vendorStoreId = vendorStoreId;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getServiceLine() {
		return serviceLine;
	}

	public void setServiceLine(String serviceLine) {
		this.serviceLine = serviceLine;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDateTime getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public LocalDateTime getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(LocalDateTime updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	public VendorEntity getVendorEntity() {
		return vendorEntity;
	}

	public void setVendorEntity(VendorEntity vendorEntity) {
		this.vendorEntity = vendorEntity;
	}

	public ServicesEntity(Long id, Integer vendorId, String nameOfVendor, String category, String vendorStoreId,
			String subCategory, String serviceLine, BigDecimal price, LocalDateTime createdTimestamp,
			LocalDateTime updatedTimestamp, VendorEntity vendorEntity) {
		super();
		this.id = id;
		this.vendorId = vendorId;
		this.nameOfVendor = nameOfVendor;
		this.category = category;
		this.vendorStoreId = vendorStoreId;
		this.subCategory = subCategory;
		this.serviceLine = serviceLine;
		this.price = price;
		this.createdTimestamp = createdTimestamp;
		this.updatedTimestamp = updatedTimestamp;
		this.vendorEntity = vendorEntity;
	}

	public ServicesEntity() {
		super();
	}

	@Override
	public String toString() {
		return "ServicesEntity [id=" + id + ", vendorId=" + vendorId + ", nameOfVendor=" + nameOfVendor + ", category="
				+ category + ", vendorStoreId=" + vendorStoreId + ", subCategory=" + subCategory + ", serviceLine="
				+ serviceLine + ", price=" + price + ", createdTimestamp=" + createdTimestamp + ", updatedTimestamp="
				+ updatedTimestamp + ", vendorEntity=" + vendorEntity + "]";
	}
}
