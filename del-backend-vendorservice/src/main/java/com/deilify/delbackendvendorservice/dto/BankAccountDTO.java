package com.deilify.delbackendvendorservice.dto;


public class BankAccountDTO {
	
	private Integer paymentId;
	
	private Integer vendorId;
	
    private String accountHolderName;
	
	private String bankAccountNumber;
	
	private String bankName;
	
	private String beneficiaryName;
	
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

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
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

	public BankAccountDTO(Integer paymentId, String accountHolderName, String bankAccountNumber, String bankName,
			String beneficiaryName, String ifscNumber, String upiId) {
		super();
		this.paymentId = paymentId;
		this.accountHolderName = accountHolderName;
		this.bankAccountNumber = bankAccountNumber;
		this.bankName = bankName;
		this.beneficiaryName = beneficiaryName;
		this.ifscNumber = ifscNumber;
		this.upiId = upiId;
	}

	public BankAccountDTO() {
		super();
	}

	@Override
	public String toString() {
		return "PaymentDTO [paymentId=" + paymentId + ", accountHolderName=" + accountHolderName
				+ ", bankAccountNumber=" + bankAccountNumber + ", bankName=" + bankName + ", beneficiaryName="
				+ beneficiaryName + ", ifscNumber=" + ifscNumber + ", upiId=" + upiId + "]";
	}
	
}
