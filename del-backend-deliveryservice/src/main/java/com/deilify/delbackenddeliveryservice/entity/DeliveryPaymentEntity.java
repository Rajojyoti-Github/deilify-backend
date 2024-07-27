//package com.deilify.delbackenddeliveryservice.entity;
//
//import java.time.LocalDate;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//
//
//@Entity
//@Table(name = "userpayment")
//public class DeliveryPaymentEntity {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "id")
//	private Integer id;
//	
//	@Column(name = "user_entity_id")
//	private Integer userEntityId;
//	
//	@Column(name = "payment_type")
//	private String paymentType;
//	
//	@Column(name = "provider")
//	private String provider;
//	
//	@Column(name = "account_number")
//	private Integer accountNumber;
//	
//	@Column(name = "expiry")
//	private LocalDate expiry;
//	
//	@OneToMany
//	@JoinColumn(name = "deliveryEntityId", referencedColumnName = "deliveryId", insertable = false, updatable = false)
//	private DeliveryEntity deliveryEntity;
//
//	/**
//	 * @return the id
//	 */
//	public Integer getId() {
//		return id;
//	}
//
//	/**
//	 * @param id the id to set
//	 */
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	/**
//	 * @return the userEntityId
//	 */
//	public Integer getUserEntityId() {
//		return userEntityId;
//	}
//
//	/**
//	 * @param userEntityId the userEntityId to set
//	 */
//	public void setUserEntityId(Integer userEntityId) {
//		this.userEntityId = userEntityId;
//	}
//
//	/**
//	 * @return the paymentType
//	 */
//	public String getPaymentType() {
//		return paymentType;
//	}
//
//	/**
//	 * @param paymentType the paymentType to set
//	 */
//	public void setPaymentType(String paymentType) {
//		this.paymentType = paymentType;
//	}
//
//	/**
//	 * @return the provider
//	 */
//	public String getProvider() {
//		return provider;
//	}
//
//	/**
//	 * @param provider the provider to set
//	 */
//	public void setProvider(String provider) {
//		this.provider = provider;
//	}
//
//	/**
//	 * @return the accountNumber
//	 */
//	public Integer getAccountNumber() {
//		return accountNumber;
//	}
//
//	/**
//	 * @param accountNumber the accountNumber to set
//	 */
//	public void setAccountNumber(Integer accountNumber) {
//		this.accountNumber = accountNumber;
//	}
//
//	/**
//	 * @return the expiry
//	 */
//	public LocalDate getExpiry() {
//		return expiry;
//	}
//
//	/**
//	 * @param expiry the expiry to set
//	 */
//	public void setExpiry(LocalDate expiry) {
//		this.expiry = expiry;
//	}
//
//	/**
//	 * @return the userEntity
//	 */
//	public DeliveryEntity getUserEntity() {
//		return deliveryEntity;
//	}
//
//	/**
//	 * @param deliveryEntity the userEntity to set
//	 */
//	public void setUserEntity(DeliveryEntity deliveryEntity) {
//		this.deliveryEntity = deliveryEntity;
//	}
//
//	/**
//	 * @param id
//	 * @param userEntityId
//	 * @param paymentType
//	 * @param provider
//	 * @param accountNumber
//	 * @param expiry
//	 * @param deliveryEntity
//	 */
//	public DeliveryPaymentEntity(Integer id, Integer userEntityId, String paymentType, String provider,
//			Integer accountNumber, LocalDate expiry, DeliveryEntity deliveryEntity) {
//		super();
//		this.id = id;
//		this.userEntityId = userEntityId;
//		this.paymentType = paymentType;
//		this.provider = provider;
//		this.accountNumber = accountNumber;
//		this.expiry = expiry;
//		this.deliveryEntity = deliveryEntity;
//	}
//
//	/**
//	 * 
//	 */
//	public DeliveryPaymentEntity() {
//		super();
//	}
//
//	@Override
//	public String toString() {
//		return "UserPaymentEntity [id=" + id + ", userEntityId=" + userEntityId + ", paymentType=" + paymentType
//				+ ", provider=" + provider + ", accountNumber=" + accountNumber + ", expiry=" + expiry + ", userEntity="
//				+ deliveryEntity + "]";
//	}
//	
//	
//	
//
//}
