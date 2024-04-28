package com.deilify.delbackendvendorservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ServicesCreateDTO {
	private Long id;

	private Integer vendorId;

	private String nameOfVendor;

	private List<String> category;

	private String vendorStoreId;

	private List<String> subCategory;

	private List<String> serviceLine;

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

	public List<String> getCategory() {
		return category;
	}

	public void setCategory(List<String> category) {
		this.category = category;
	}

	public String getVendorStoreId() {
		return vendorStoreId;
	}

	public void setVendorStoreId(String vendorStoreId) {
		this.vendorStoreId = vendorStoreId;
	}

	public List<String> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(List<String> subCategory) {
		this.subCategory = subCategory;
	}

	public List<String> getServiceLine() {
		return serviceLine;
	}

	public void setServiceLine(List<String> serviceLine) {
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

	public ServicesCreateDTO(Long id, Integer vendorId, String nameOfVendor, List<String> category, String vendorStoreId,
			List<String> subCategory, List<String> serviceLine, BigDecimal price, LocalDateTime createdTimestamp,
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

	public ServicesCreateDTO() {
		super();
	}

	@Override
	public String toString() {
		return "ServicesDTO [id=" + id + ", vendorId=" + vendorId + ", nameOfVendor=" + nameOfVendor + ", category="
				+ category + ", vendorStoreId=" + vendorStoreId + ", subCategory=" + subCategory + ", serviceLine="
				+ serviceLine + ", price=" + price + ", createdTimestamp=" + createdTimestamp + ", updatedTimestamp="
				+ updatedTimestamp + "]";
	}
}
