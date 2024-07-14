package com.deilify.delbackenduserservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "cartitem")
public class UserCartItemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "session_id")
	private Integer sessionId;
	
	@Column(name = "product_id")
	private Integer productId;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "created_at")
	private LocalDate createdAt;
	
	@Column(name = "modified_at")
	private LocalDate modifiedAt;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the sessionId
	 */
	public Integer getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the createdAt
	 */
	public LocalDate getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the modifiedAt
	 */
	public LocalDate getModifiedAt() {
		return modifiedAt;
	}

	/**
	 * @param modifiedAt the modifiedAt to set
	 */
	public void setModifiedAt(LocalDate modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	/**
	 * @param id
	 * @param sessionId
	 * @param productId
	 * @param quantity
	 * @param createdAt
	 * @param modifiedAt
	 */
	public UserCartItemEntity(Integer id, Integer sessionId, Integer productId, Integer quantity, LocalDate createdAt,
			LocalDate modifiedAt) {
		super();
		this.id = id;
		this.sessionId = sessionId;
		this.productId = productId;
		this.quantity = quantity;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}

	/**
	 * 
	 */
	public UserCartItemEntity() {
		super();
	}

	@Override
	public String toString() {
		return "UserCartItemEntity [id=" + id + ", sessionId=" + sessionId + ", productId=" + productId + ", quantity="
				+ quantity + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + "]";
	}
	
}
