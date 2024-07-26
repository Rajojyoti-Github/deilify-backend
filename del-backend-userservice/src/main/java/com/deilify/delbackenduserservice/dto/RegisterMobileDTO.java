package com.deilify.delbackenduserservice.dto;

public class RegisterMobileDTO {
	
	private String mobileNumber;
	
	private String otp;
	
	private String message;

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

	@Override
	public String toString() {
		return "RegisterMobile [mobileNumber=" + mobileNumber + ", otp=" + otp + ", message=" + message + "]";
	}

	/**
	 * @param mobileNumber
	 * @param otp
	 * @param message
	 */
	public RegisterMobileDTO(String mobileNumber, String otp, String message) {
		super();
		this.mobileNumber = mobileNumber;
		this.otp = otp;
		this.message = message;
	}

	/**
	 * 
	 */
	public RegisterMobileDTO() {
		super();
	}
	
}
