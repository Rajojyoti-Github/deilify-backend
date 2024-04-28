package com.deilify.delbackendvendorservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_line")
public class ServiceLineEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String value;
    
    @Column(name = "sub_category_id")
    private Long subCategoryId;

    @ManyToOne
    @JoinColumn(name = "sub_category_id", referencedColumnName = "id", insertable = false, updatable = false)
    private SubCategoryEntity subCategory;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(Long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public SubCategoryEntity getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategoryEntity subCategory) {
		this.subCategory = subCategory;
	}

	public ServiceLineEntity(Long id, String value, Long subCategoryId, SubCategoryEntity subCategory) {
		super();
		this.id = id;
		this.value = value;
		this.subCategoryId = subCategoryId;
		this.subCategory = subCategory;
	}

	public ServiceLineEntity() {
		super();
	}

	@Override
	public String toString() {
		return "ServiceLineEntity [id=" + id + ", value=" + value + ", subCategoryId=" + subCategoryId
				+ ", subCategory=" + subCategory + "]";
	}

}