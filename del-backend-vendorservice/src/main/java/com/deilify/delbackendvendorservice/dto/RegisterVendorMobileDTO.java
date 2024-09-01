package com.deilify.delbackendvendorservice.dto;

public class RegisterVendorMobileDTO {
	
	private String mobileNumber;
	
	private String otp;
	
	private String message;
	
	private String vendorId;

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
	 * @return the otp
	 */
	public String getOtp() {
		return otp;
	}

	/**
	 * @param otp the otp to set
	 */
	public void setOtp(String otp) {
		this.otp = otp;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the vendorId
	 */
	public String getVendorId() {
		return vendorId;
	}

	/**
	 * @param vendorId the vendorId to set
	 */
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	/**
	 * @param mobileNumber
	 * @param otp
	 * @param message
	 * @param vendorId
	 */
	public RegisterVendorMobileDTO(String mobileNumber, String otp, String message, String vendorId) {
		super();
		this.mobileNumber = mobileNumber;
		this.otp = otp;
		this.message = message;
		this.vendorId = vendorId;
	}

	/**
	 * 
	 */
	public RegisterVendorMobileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RegisterVendorMobileDTO [mobileNumber=" + mobileNumber + ", otp=" + otp + ", message=" + message
				+ ", vendorId=" + vendorId + "]";
	}
	
	

}
