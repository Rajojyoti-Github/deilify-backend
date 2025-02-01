package com.deilify.delbackendvendorservice.dto;


public class BankAccountDTO {
	
	private Integer paymentId;
	
	private Integer vendorId;
	
    private String accountHolderName;
	
	private String bankAccountNumber;
	
	private String bankName;
	
	private String beneficiaryName;
	
	private String ifscCode;
	
	private String upiId;
	
	private String status;

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BankAccountDTO() {
		super();
	}

	/**
	 * @param paymentId
	 * @param vendorId
	 * @param accountHolderName
	 * @param bankAccountNumber
	 * @param bankName
	 * @param beneficiaryName
	 * @param ifscCode
	 * @param upiId
	 * @param status
	 */
	public BankAccountDTO(Integer paymentId, Integer vendorId, String accountHolderName, String bankAccountNumber,
			String bankName, String beneficiaryName, String ifscCode, String upiId, String status) {
		super();
		this.paymentId = paymentId;
		this.vendorId = vendorId;
		this.accountHolderName = accountHolderName;
		this.bankAccountNumber = bankAccountNumber;
		this.bankName = bankName;
		this.beneficiaryName = beneficiaryName;
		this.ifscCode = ifscCode;
		this.upiId = upiId;
		this.status = status;
	}

	@Override
	public String toString() {
		return "BankAccountDTO [paymentId=" + paymentId + ", vendorId=" + vendorId + ", accountHolderName="
				+ accountHolderName + ", bankAccountNumber=" + bankAccountNumber + ", bankName=" + bankName
				+ ", beneficiaryName=" + beneficiaryName + ", ifscCode=" + ifscCode + ", upiId=" + upiId + ", status="
				+ status + "]";
	}
	
}
