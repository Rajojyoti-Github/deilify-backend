package com.deilify.delbackendvendorservice.dto;

public class BusinessTypeCreateDto {
private Long vendorId;
	
    private String vendorName;
    
    private String typeOfBusiness;

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getTypeOfBusiness() {
		return typeOfBusiness;
	}

	public void setTypeOfBusiness(String typeOfBusiness) {
		this.typeOfBusiness = typeOfBusiness;
	}

	public BusinessTypeCreateDto(Long vendorId, String vendorName, String typeOfBusiness) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.typeOfBusiness = typeOfBusiness;
	}

	public BusinessTypeCreateDto() {
		super();
	}

	@Override
	public String toString() {
		return "BusinessTypeDto [vendorId=" + vendorId + ", vendorName=" + vendorName + ", typeOfBusiness="
				+ typeOfBusiness + "]";
	}
    
}
