package com.deilify.delbackendvendorservice.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    private String value;
    
    @OneToMany(mappedBy = "categoryEntity")
    private List<SubCategoryEntity> subCategory;

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

	public List<SubCategoryEntity> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(List<SubCategoryEntity> subCategory) {
		this.subCategory = subCategory;
	}

	public CategoryEntity(Long id, String value, List<SubCategoryEntity> subCategory) {
		super();
		this.id = id;
		this.value = value;
		this.subCategory = subCategory;
	}

	public CategoryEntity() {
		super();
	}

	@Override
	public String toString() {
		return "CategoryEntity [id=" + id + ", value=" + value + ", subCategory=" + subCategory + "]";
	}
}
