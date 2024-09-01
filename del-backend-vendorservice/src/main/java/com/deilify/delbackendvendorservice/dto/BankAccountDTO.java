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

	public BankAccountDTO() {
		super();
	}

	public BankAccountDTO(Integer paymentId, Integer vendorId, String accountHolderName, String bankName,
			String beneficiaryName, String bankAccountNumber, String ifscCode, String upiId) {
		super();
		this.paymentId = paymentId;
		this.vendorId = vendorId;
		this.accountHolderName = accountHolderName;
		this.bankName = bankName;
		this.beneficiaryName = beneficiaryName;
		this.bankAccountNumber = bankAccountNumber;
		this.ifscCode = ifscCode;
		this.upiId = upiId;
	}

	@Override
	public String toString() {
		return "BankAccountDTO [paymentId=" + paymentId + ", vendorId=" + vendorId + ", accountHolderName="
				+ accountHolderName + ", bankName=" + bankName + ", beneficiaryName=" + beneficiaryName
				+ ", bankAccountNumber=" + bankAccountNumber + ", ifscCode=" + ifscCode + ", upiId=" + upiId + "]";
	}
}
