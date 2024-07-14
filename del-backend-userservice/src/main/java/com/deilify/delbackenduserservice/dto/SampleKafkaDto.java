package com.deilify.delbackenduserservice.dto;

public class SampleKafkaDto {
	
	private String name;
	
	private String mobileNumber;
	
	private String emailAddress;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @param name
	 * @param mobileNumber
	 * @param emailAddress
	 */
	public SampleKafkaDto(String name, String mobileNumber, String emailAddress) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
	}

	/**
	 * 
	 */
	public SampleKafkaDto() {
		super();
	}

	@Override
	public String toString() {
		return "SampleKafkaDto [name=" + name + ", mobileNumber=" + mobileNumber + ", emailAddress=" + emailAddress
				+ "]";
	}
	
	

}
