package com.deilify.delbackendvendorservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ServicesDTO {

	private Long id;

	private Integer vendorId;

	private String nameOfVendor;

	private String category;

	private String vendorStoreId;

	private String subCategory;

	private String serviceLine;

	private BigDecimal price;

	private LocalDateTime createdTimestamp;

	private LocalDateTime updatedTimestamp;

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

	public ServicesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServicesDTO(Long id, Integer vendorId, String nameOfVendor, String category, String vendorStoreId,
			String subCategory, String serviceLine, BigDecimal price, LocalDateTime createdTimestamp,
			LocalDateTime updatedTimestamp) {
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
	}

	@Override
	public String toString() {
		return "ServicesDTO [id=" + id + ", vendorId=" + vendorId + ", nameOfVendor=" + nameOfVendor + ", category="
				+ category + ", vendorStoreId=" + vendorStoreId + ", subCategory=" + subCategory + ", serviceLine="
				+ serviceLine + ", price=" + price + ", createdTimestamp=" + createdTimestamp + ", updatedTimestamp="
				+ updatedTimestamp + "]";
	}
	
}
