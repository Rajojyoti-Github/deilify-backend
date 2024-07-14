package com.deilify.delbackendvendorservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "kycdocuments")
public class KycDocumentsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long kycDocId;
	
	@Column(name = "vendor_id")
    private Long vendorId;
    
    @Column(name = "vendor_name")
    private String vendorName;
    
    @Column(name = "type_of_business")
    private String typeOfBusiness;
    
    @Column(name = "file_name")
    private String fileName;
    
    @Column(name = "created_timestamp")
	private LocalDate createdTimestamp;
	
	@Column(name = "updated_timestamp")
	private LocalDate updatedTimestamp;

	public Long getKycDocId() {
		return kycDocId;
	}

	public void setKycDocId(Long kycDocId) {
		this.kycDocId = kycDocId;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getTypeOfBusiness() {
		return typeOfBusiness;
	}

	public void setTypeOfBusiness(String typeOfBusiness) {
		this.typeOfBusiness = typeOfBusiness;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public LocalDate getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(LocalDate createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public LocalDate getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(LocalDate updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	public KycDocumentsEntity(Long kycDocId, Long vendorId, String vendorName, String typeOfBusiness, String fileName,
			LocalDate createdTimestamp, LocalDate updatedTimestamp) {
		super();
		this.kycDocId = kycDocId;
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.typeOfBusiness = typeOfBusiness;
		this.fileName = fileName;
		this.createdTimestamp = createdTimestamp;
		this.updatedTimestamp = updatedTimestamp;
	}

	public KycDocumentsEntity() {
		super();
	}

	@Override
	public String toString() {
		return "KycDocumentsEntity [kycDocId=" + kycDocId + ", vendorId=" + vendorId + ", vendorName=" + vendorName
				+ ", typeOfBusiness=" + typeOfBusiness + ", fileName=" + fileName + ", createdTimestamp="
				+ createdTimestamp + ", updatedTimestamp=" + updatedTimestamp + "]";
	}
	
}
