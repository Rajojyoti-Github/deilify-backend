package com.deilify.delbackendvendorservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vendorstoreaddressenitity")
public class VendorStoreAddressEnitity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "store_address_id")
	private Integer storeAddressId;
	
	@Column(name = "vendor_entity_id")
	private Integer vendorEntityId;
	
	@Column(name = "address_line_1")
    private String addressLine1;
    
	@Column(name = "address_line_2")
    private String addressLine2;
    
	@Column(name = "city")
    private String city;
    
	@Column(name = "state")
    private String state;
    
	@Column(name = "district")
    private String district;
	
	@Column(name = "pin")
    private String pin;
    
	@Column(name = "country")
    private String country;

	@ManyToOne
	@JoinColumn(name = "vendor_entity_id", referencedColumnName = "id", insertable = false, updatable = false)
	private VendorEntity vendorEntity;
	
	public VendorEntity getVendorEntity() {
		return vendorEntity;
	}

	public void setVendorEntity(VendorEntity vendorEntity) {
		this.vendorEntity = vendorEntity;
	}

	public Integer getStoreAddressId() {
		return storeAddressId;
	}

	public void setStoreAddressId(Integer storeAddressId) {
		this.storeAddressId = storeAddressId;
	}

	public Integer getVendorEntityId() {
		return vendorEntityId;
	}

	public void setVendorEntityId(Integer vendorEntityId) {
		this.vendorEntityId = vendorEntityId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public VendorStoreAddressEnitity(Integer storeAddressId, Integer vendorEntityId, String addressLine1,
			String addressLine2, String city, String state, String district, String pin, String country) {
		super();
		this.storeAddressId = storeAddressId;
		this.vendorEntityId = vendorEntityId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.district = district;
		this.pin = pin;
		this.country = country;
	}

	public VendorStoreAddressEnitity() {
		super();
	}

	@Override
	public String toString() {
		return "VendorStoreAddressEnitity [storeAddressId=" + storeAddressId + ", vendorEntityId="
				+ vendorEntityId + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city="
				+ city + ", state=" + state + ", district=" + district + ", pin=" + pin + ", country=" + country + "]";
	}
    
}
