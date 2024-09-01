package com.deilify.delbackendvendorservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendorpayment")
public class VendorPaymentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "vendor_entity_id")
	private Integer vendorEntityId;
	
	@Column(name = "account_holder_name")
	private String accountHolderName;
	
	@Column(name = "bank_name")
	private String bankName;
	
	@Column(name = "beneficiary_name")
	private String beneficiaryName;
	
	@Column(name = "account_number")
	private String bankAccountNumber;
	
	@Column(name = "ifsc_code")
	private String ifscCode;
	
	@Column(name = "upi_id")
	private String upiId;
	
	@OneToOne
	@JoinColumn(name = "vendor_entity_id", referencedColumnName = "id", insertable = false, updatable = false)
	private VendorEntity vendorEntity;

	public VendorEntity getVendorEntity() {
		return vendorEntity;
	}

	public void setVendorEntity(VendorEntity vendorEntity) {
		this.vendorEntity = vendorEntity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVendorEntityId() {
		return vendorEntityId;
	}

	public void setVendorEntityId(Integer vendorEntityId) {
		this.vendorEntityId = vendorEntityId;
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

	public VendorPaymentEntity(Integer id, Integer vendorEntityId, String accountHolderName, String bankName,
			String beneficiaryName, String bankAccountNumber, String ifscCode, String upiId,
			VendorEntity vendorEntity) {
		super();
		this.id = id;
		this.vendorEntityId = vendorEntityId;
		this.accountHolderName = accountHolderName;
		this.bankName = bankName;
		this.beneficiaryName = beneficiaryName;
		this.bankAccountNumber = bankAccountNumber;
		this.ifscCode = ifscCode;
		this.upiId = upiId;
	}

	public VendorPaymentEntity() {
		super();
	}

	@Override
	public String toString() {
		return "VendorPaymentEntity [id=" + id + ", vendorEntityId=" + vendorEntityId + ", accountHolderName="
				+ accountHolderName + ", bankName=" + bankName + ", beneficiaryName=" + beneficiaryName
				+ ", bankAccountNumber=" + bankAccountNumber + ", ifscCode=" + ifscCode + ", upiId=" + upiId
				+ "]";
	}

}
