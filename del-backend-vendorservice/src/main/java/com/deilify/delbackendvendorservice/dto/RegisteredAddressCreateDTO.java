package com.deilify.delbackendvendorservice.dto;


public class RegisteredAddressCreateDTO {

	private Integer registeredAddressId;
	
	private Integer vendorEntityId;
	
    private String addressLine1;
    
    private String addressLine2;
    
    private String city;
    
    private String state;
    
    private String district;
	
    private String pin;
    
    private String country;

	public Integer getRegisteredAddressId() {
		return registeredAddressId;
	}

	public void setRegisteredAddressId(Integer registeredAddressId) {
		this.registeredAddressId = registeredAddressId;
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

	public RegisteredAddressCreateDTO(Integer registeredAddressId, Integer vendorEntityId, String addressLine1,
			String addressLine2, String city, String state, String district, String pin, String country) {
		super();
		this.registeredAddressId = registeredAddressId;
		this.vendorEntityId = vendorEntityId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.district = district;
		this.pin = pin;
		this.country = country;
	}

	public RegisteredAddressCreateDTO() {
		super();
	}

	@Override
	public String toString() {
		return "RegisteredAddressCreateDTO [registeredAddressId=" + registeredAddressId + ", vendorEntityId="
				+ vendorEntityId + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city="
				+ city + ", state=" + state + ", district=" + district + ", pin=" + pin + ", country=" + country + "]";
	}
}
