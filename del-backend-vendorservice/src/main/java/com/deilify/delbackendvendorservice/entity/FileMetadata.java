package com.deilify.delbackendvendorservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "kycdocuments")
public class FileMetadata {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private Long id;
	
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
	
	@Column(name = "file_path")
    private String filePath;
    
	@Column(name = "file_type")
    private String fileType;
    
	@Column(name = "file_size")
    private Long fileSize;
    
	@Column(name = "file_category")
    private String category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public FileMetadata() {
		super();
	}

	public FileMetadata(Long id, Long vendorId, String vendorName, String typeOfBusiness, String fileName,
			LocalDate createdTimestamp, LocalDate updatedTimestamp, String filePath, String fileType, Long fileSize,
			String category) {
		super();
		this.id = id;
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.typeOfBusiness = typeOfBusiness;
		this.fileName = fileName;
		this.createdTimestamp = createdTimestamp;
		this.updatedTimestamp = updatedTimestamp;
		this.filePath = filePath;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.category = category;
	}

	@Override
	public String toString() {
		return "FileMetadata [id=" + id + ", vendorId=" + vendorId + ", vendorName=" + vendorName + ", typeOfBusiness="
				+ typeOfBusiness + ", fileName=" + fileName + ", createdTimestamp=" + createdTimestamp
				+ ", updatedTimestamp=" + updatedTimestamp + ", filePath=" + filePath + ", fileType=" + fileType
				+ ", fileSize=" + fileSize + ", category=" + category + "]";
	}
    
}
