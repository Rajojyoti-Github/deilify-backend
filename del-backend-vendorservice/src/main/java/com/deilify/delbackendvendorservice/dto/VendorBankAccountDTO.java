package com.deilify.delbackendvendorservice.dto;

public class VendorBankAccountDTO {

	private Integer paymentId;
	
	private Integer vendorId;
	
	private String accountHolderName;
	
    private String bankName;
	
	private String beneficiaryName;
	
	private String bankAccountNumber;
	
	private String ifscNumber;
	
	private String upiId;

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
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

	public String getIfscNumber() {
		return ifscNumber;
	}

	public void setIfscNumber(String ifscNumber) {
		this.ifscNumber = ifscNumber;
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public VendorBankAccountDTO(Integer paymentId, String accountHolderName, String bankName, String beneficiaryName,
			String bankAccountNumber, String ifscNumber, String upiId) {
		super();
		this.paymentId = paymentId;
		this.accountHolderName = accountHolderName;
		this.bankName = bankName;
		this.beneficiaryName = beneficiaryName;
		this.bankAccountNumber = bankAccountNumber;
		this.ifscNumber = ifscNumber;
		this.upiId = upiId;
	}

	public VendorBankAccountDTO() {
		super();
	}

	@Override
	public String toString() {
		return "VendorPaymentDTO [paymentId=" + paymentId + ", accountHolderName=" + accountHolderName + ", bankName="
				+ bankName + ", beneficiaryName=" + beneficiaryName + ", bankAccountNumber=" + bankAccountNumber
				+ ", ifscNumber=" + ifscNumber + ", upiId=" + upiId + "]";
	}
	
}
