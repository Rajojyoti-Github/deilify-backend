package com.deilify.delbackenduserservice.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "userpayment")
public class UserPaymentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "user_entity_id")
	private Integer userEntityId;
	
	@Column(name = "payment_type")
	private String paymentType;
	
	@Column(name = "provider")
	private String provider;
	
	@Column(name = "account_number")
	private Integer accountNumber;
	
	@Column(name = "expiry")
	private LocalDate expiry;
	
	@ManyToOne
	@JoinColumn(name = "user_entity_id", referencedColumnName = "userId", insertable = false, updatable = false)
	private UserEntity userEntity;

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
	 * @return the userEntityId
	 */
	public Integer getUserEntityId() {
		return userEntityId;
	}

	/**
	 * @param userEntityId the userEntityId to set
	 */
	public void setUserEntityId(Integer userEntityId) {
		this.userEntityId = userEntityId;
	}

	/**
	 * @return the paymentType
	 */
	public String getPaymentType() {
		return paymentType;
	}

	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * @return the provider
	 */
	public String getProvider() {
		return provider;
	}

	/**
	 * @param provider the provider to set
	 */
	public void setProvider(String provider) {
		this.provider = provider;
	}

	/**
	 * @return the accountNumber
	 */
	public Integer getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the expiry
	 */
	public LocalDate getExpiry() {
		return expiry;
	}

	/**
	 * @param expiry the expiry to set
	 */
	public void setExpiry(LocalDate expiry) {
		this.expiry = expiry;
	}

	/**
	 * @return the userEntity
	 */
	public UserEntity getUserEntity() {
		return userEntity;
	}

	/**
	 * @param userEntity the userEntity to set
	 */
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	/**
	 * @param id
	 * @param userEntityId
	 * @param paymentType
	 * @param provider
	 * @param accountNumber
	 * @param expiry
	 * @param userEntity
	 */
	public UserPaymentEntity(Integer id, Integer userEntityId, String paymentType, String provider,
			Integer accountNumber, LocalDate expiry, UserEntity userEntity) {
		super();
		this.id = id;
		this.userEntityId = userEntityId;
		this.paymentType = paymentType;
		this.provider = provider;
		this.accountNumber = accountNumber;
		this.expiry = expiry;
		this.userEntity = userEntity;
	}

	/**
	 * 
	 */
	public UserPaymentEntity() {
		super();
	}

	@Override
	public String toString() {
		return "UserPaymentEntity [id=" + id + ", userEntityId=" + userEntityId + ", paymentType=" + paymentType
				+ ", provider=" + provider + ", accountNumber=" + accountNumber + ", expiry=" + expiry + ", userEntity="
				+ userEntity + "]";
	}
	
	
	

}
