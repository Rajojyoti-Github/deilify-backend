package com.deilify.delbackendvendorservice.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sub_category")
public class SubCategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String value;
    
    @Column(name = "category_id")
    private Long categoryId;
    
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
    private CategoryEntity categoryEntity;
    
    @OneToMany(mappedBy = "subCategory")
    private List<ServiceLineEntity> serviceLine;

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

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

	public List<ServiceLineEntity> getServiceLine() {
		return serviceLine;
	}

	public void setServiceLine(List<ServiceLineEntity> serviceLine) {
		this.serviceLine = serviceLine;
	}

	public SubCategoryEntity(Long id, String value, Long categoryId, CategoryEntity categoryEntity,
			List<ServiceLineEntity> serviceLine) {
		super();
		this.id = id;
		this.value = value;
		this.categoryId = categoryId;
		this.categoryEntity = categoryEntity;
		this.serviceLine = serviceLine;
	}

	public SubCategoryEntity() {
		super();
	}

	@Override
	public String toString() {
		return "SubCategoryEntity [id=" + id + ", value=" + value + ", categoryId=" + categoryId + ", categoryEntity="
				+ categoryEntity + ", serviceLine=" + serviceLine + "]";
	}
    
}
