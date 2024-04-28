package com.deilify.delbackendvendorservice.dto;

import java.time.LocalDate;

public class VendorDTO {

	private Integer vendorId;

	private String nameOfVendor;
	
	private String nameOfBusiness;
	
	private String address;
	
	private String phoneNumber;
	
	private String emailAddress;
	
	private Integer tradeLicenseNumber;
	
	private LocalDate tradeLicenceValidityDate;
	
	private Integer gstNumber;
	
	private LocalDate createdTimestamp;
	
	private LocalDate updatedTimestamp;
	
    private String errorMessage;
	
    private String modifiedBy;
    
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
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

	public String getNameOfBusiness() {
		return nameOfBusiness;
	}

	public void setNameOfBusiness(String nameOfBusiness) {
		this.nameOfBusiness = nameOfBusiness;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Integer getTradeLicenseNumber() {
		return tradeLicenseNumber;
	}

	public void setTradeLicenseNumber(Integer tradeLicenseNumber) {
		this.tradeLicenseNumber = tradeLicenseNumber;
	}

	public LocalDate getTradeLicenceValidityDate() {
		return tradeLicenceValidityDate;
	}

	public void setTradeLicenceValidityDate(LocalDate tradeLicenceValidityDate) {
		this.tradeLicenceValidityDate = tradeLicenceValidityDate;
	}

	public Integer getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(Integer gstNumber) {
		this.gstNumber = gstNumber;
	}

	public LocalDate getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(LocalDate createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public LocalDate getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(LocalDate updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public VendorDTO(Integer vendorId, String nameOfVendor, String nameOfBusiness, String address, String phoneNumber,
			String emailAddress, Integer tradeLicenseNumber, LocalDate tradeLicenceValidityDate, Integer gstNumber,
			LocalDate createdTimestamp, LocalDate updatedTimestamp, String modifiedBy) {
		super();
		this.vendorId = vendorId;
		this.nameOfVendor = nameOfVendor;
		this.nameOfBusiness = nameOfBusiness;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.tradeLicenseNumber = tradeLicenseNumber;
		this.tradeLicenceValidityDate = tradeLicenceValidityDate;
		this.gstNumber = gstNumber;
		this.createdTimestamp = createdTimestamp;
		this.updatedTimestamp = updatedTimestamp;
		this.modifiedBy = modifiedBy;
	}

	public VendorDTO() {
		super();
	}

	@Override
	public String toString() {
		return "VendorDTO [vendorId=" + vendorId + ", nameOfVendor=" + nameOfVendor + ", nameOfBusiness="
				+ nameOfBusiness + ", address=" + address + ", phoneNumber=" + phoneNumber + ", emailAddress="
				+ emailAddress + ", tradeLicenseNumber=" + tradeLicenseNumber + ", tradeLicenceValidityDate="
				+ tradeLicenceValidityDate + ", gstNumber=" + gstNumber + ", createdTimestamp=" + createdTimestamp
				+ ", updatedTimestamp=" + updatedTimestamp + ", modifiedBy=" + modifiedBy + "]";
	}

}
