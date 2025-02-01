package com.deilify.delbackendvendorservice.entity;

import java.time.LocalDate;
import java.util.List;


import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "vendor")
public class VendorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name_of_vendor")
	private String nameOfVendor;
	
	@Column(name = "name_of_business")
	private String nameOfBusiness;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "email_address")
	private String emailAddress;
	
	@Column(name = "trade_license_number")
	private Integer tradeLicenseNumber;
	
	@Column(name = "trade_licence_validity_date")
	private LocalDate tradeLicenceValidityDate;
	
	@Column(name = "gst_number")
	private Integer gstNumber;
	
	@Column(name = "created_timestamp")
	private LocalDate createdTimestamp;
	
	@Column(name = "updated_timestamp")
	private LocalDate updatedTimestamp;
	
	@Column(name = "modified_by")
	private String modifiedBy;
	
	@OneToMany(mappedBy = "vendorEntity")
    private List<VendorStoreAddressEnitity> storeAddresses;

	@OneToMany(mappedBy = "vendorEntity")
    private List<VendorRegisteredAddressEnitity> registeredAddresses;
	
	@OneToMany(mappedBy = "vendorEntity", cascade = CascadeType.ALL)
    private List<ServicesEntity> serviceEntities;
	
	@OneToMany(mappedBy = "vendorEntity", cascade = CascadeType.ALL)
    private List<VendorPaymentEntity> paymentAddresses;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<VendorStoreAddressEnitity> getStoreAddresses() {
		return storeAddresses;
	}

	public void setStoreAddresses(List<VendorStoreAddressEnitity> storeAddresses) {
		this.storeAddresses = storeAddresses;
	}

	public List<VendorRegisteredAddressEnitity> getRegisteredAddresses() {
		return registeredAddresses;
	}

	public void setRegisteredAddresses(List<VendorRegisteredAddressEnitity> registeredAddresses) {
		this.registeredAddresses = registeredAddresses;
	}

	public List<VendorPaymentEntity> getPaymentAddresses() {
		return paymentAddresses;
	}

	public void setPaymentAddresses(List<VendorPaymentEntity> paymentAddresses) {
		this.paymentAddresses = paymentAddresses;
	}

	public VendorEntity(Integer id, String nameOfVendor, String nameOfBusiness, String address, String phoneNumber,
			String emailAddress, Integer tradeLicenseNumber, LocalDate tradeLicenceValidityDate, Integer gstNumber,
			LocalDate createdTimestamp, LocalDate updatedTimestamp, String modifiedBy,
			List<VendorStoreAddressEnitity> storeAddresses, List<VendorRegisteredAddressEnitity> registeredAddresses,
			List<VendorPaymentEntity> paymentAddresses) {
		super();
		this.id = id;
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
		this.storeAddresses = storeAddresses;
		this.registeredAddresses = registeredAddresses;
		this.paymentAddresses = paymentAddresses;
	}

	public VendorEntity() {
		super();
	}

	@Override
	public String toString() {
		return "VendorEntity [id=" + id + ", nameOfVendor=" + nameOfVendor + ", nameOfBusiness=" + nameOfBusiness
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + ", emailAddress=" + emailAddress
				+ ", tradeLicenseNumber=" + tradeLicenseNumber + ", tradeLicenceValidityDate="
				+ tradeLicenceValidityDate + ", gstNumber=" + gstNumber + ", createdTimestamp=" + createdTimestamp
				+ ", updatedTimestamp=" + updatedTimestamp + ", modifiedBy=" + modifiedBy + ", storeAddresses="
				+ storeAddresses + ", registeredAddresses=" + registeredAddresses + ", paymentAddresses="
				+ paymentAddresses + "]";
	}
	
}
