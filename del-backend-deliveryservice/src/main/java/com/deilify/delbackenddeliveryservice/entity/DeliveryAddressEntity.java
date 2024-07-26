package com.deilify.delbackenddeliveryservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "deliveryaddress")
public class DeliveryAddressEntity {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer Id;
	
	@Column(name = "delivery_entity_id")
	private Integer deliveryEntityId; 

	@Column(name = "customer_mobile_number")
	private String customerMobilenumber;

	@Column(name = "customer_address_line1")
	private String customerAddressLine1;

	@Column(name = "customer_address_line2")
	private String customerAddressLine2;

	@Column(name = "customer_pin")
	private String customerPin;

	@Column(name = "customer_country")
	private String customerCountry;

	@Column(name = "customer_state")
	private String customerState;

	@Column(name = "customer_district")
	private String customerDistrict;

	@Column(name = "customer_landmark")
	private String customerLandmark;

	@Column(name = "created_timestamp")
	private LocalDate createdTimestamp;

	@Column(name = "updated_timestamp")
	private LocalDate updatedTimestamp;

	@Column(name = "modified_by")
	private String modifiedBy;
	
	@OneToMany
	@JoinColumn(name = "delivery_entity_id", referencedColumnName = "deliveryId", insertable = false, updatable = false)
	private DeliveryEntity deliveryEntity;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}

	/**
	 * @return the deliveryEntityId
	 */
	public Integer getdeliveryEntityId() {
		return deliveryEntityId;
	}

	/**
	 * @param deliveryEntityId the deliveryEntityId to set
	 */
	public void setdeliveryEntityId(Integer deliveryEntityId) {
		this.deliveryEntityId = deliveryEntityId;
	}

	/**
	 * @return the customerMobilenumber
	 */
	public String getCustomerMobilenumber() {
		return customerMobilenumber;
	}

	/**
	 * @param customerMobilenumber the customerMobilenumber to set
	 */
	public void setCustomerMobilenumber(String customerMobilenumber) {
		this.customerMobilenumber = customerMobilenumber;
	}

	/**
	 * @return the customerAddressLine1
	 */
	public String getCustomerAddressLine1() {
		return customerAddressLine1;
	}

	/**
	 * @param customerAddressLine1 the customerAddressLine1 to set
	 */
	public void setCustomerAddressLine1(String customerAddressLine1) {
		this.customerAddressLine1 = customerAddressLine1;
	}

	/**
	 * @return the customerAddressLine2
	 */
	public String getCustomerAddressLine2() {
		return customerAddressLine2;
	}

	/**
	 * @param customerAddressLine2 the customerAddressLine2 to set
	 */
	public void setCustomerAddressLine2(String customerAddressLine2) {
		this.customerAddressLine2 = customerAddressLine2;
	}

	/**
	 * @return the customerPin
	 */
	public String getCustomerPin() {
		return customerPin;
	}

	/**
	 * @param customerPin the customerPin to set
	 */
	public void setCustomerPin(String customerPin) {
		this.customerPin = customerPin;
	}

	/**
	 * @return the customerCountry
	 */
	public String getCustomerCountry() {
		return customerCountry;
	}

	/**
	 * @param customerCountry the customerCountry to set
	 */
	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}

	/**
	 * @return the customerState
	 */
	public String getCustomerState() {
		return customerState;
	}

	/**
	 * @param customerState the customerState to set
	 */
	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	/**
	 * @return the customerDistrict
	 */
	public String getCustomerDistrict() {
		return customerDistrict;
	}

	/**
	 * @param customerDistrict the customerDistrict to set
	 */
	public void setCustomerDistrict(String customerDistrict) {
		this.customerDistrict = customerDistrict;
	}

	/**
	 * @return the customerLandmark
	 */
	public String getCustomerLandmark() {
		return customerLandmark;
	}

	/**
	 * @param customerLandmark the customerLandmark to set
	 */
	public void setCustomerLandmark(String customerLandmark) {
		this.customerLandmark = customerLandmark;
	}

	/**
	 * @return the createdTimestamp
	 */
	public LocalDate getCreatedTimestamp() {
		return createdTimestamp;
	}

	/**
	 * @param createdTimestamp the createdTimestamp to set
	 */
	public void setCreatedTimestamp(LocalDate createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	/**
	 * @return the updatedTimestamp
	 */
	public LocalDate getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	/**
	 * @param updatedTimestamp the updatedTimestamp to set
	 */
	public void setUpdatedTimestamp(LocalDate updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the deliveryEntity
	 */
	public DeliveryEntity getdeliveryEntity() {
		return deliveryEntity;
	}

	/**
	 * @param deliveryEntity the deliveryEntity to set
	 */
	public void setdeliveryEntity(DeliveryEntity deliveryEntity) {
		this.deliveryEntity = deliveryEntity;
	}

	/**
	 * @param id
	 * @param deliveryEntityId
	 * @param customerMobilenumber
	 * @param customerAddressLine1
	 * @param customerAddressLine2
	 * @param customerPin
	 * @param customerCountry
	 * @param customerState
	 * @param customerDistrict
	 * @param customerLandmark
	 * @param createdTimestamp
	 * @param updatedTimestamp
	 * @param modifiedBy
	 * @param deliveryEntity
	 */
	public DeliveryAddressEntity(Integer id, Integer deliveryEntityId, String customerMobilenumber, String customerAddressLine1,
			String customerAddressLine2, String customerPin, String customerCountry, String customerState,
			String customerDistrict, String customerLandmark, LocalDate createdTimestamp, LocalDate updatedTimestamp,
			String modifiedBy, DeliveryEntity deliveryEntity) {
		super();
		Id = id;
		this.deliveryEntityId = deliveryEntityId;
		this.customerMobilenumber = customerMobilenumber;
		this.customerAddressLine1 = customerAddressLine1;
		this.customerAddressLine2 = customerAddressLine2;
		this.customerPin = customerPin;
		this.customerCountry = customerCountry;
		this.customerState = customerState;
		this.customerDistrict = customerDistrict;
		this.customerLandmark = customerLandmark;
		this.createdTimestamp = createdTimestamp;
		this.updatedTimestamp = updatedTimestamp;
		this.modifiedBy = modifiedBy;
		this.deliveryEntity = deliveryEntity;
	}

	public DeliveryAddressEntity() {
		super();
	}

	@Override
	public String toString() {
		return "deliveryAddressEntity [Id=" + Id + ", deliveryEntityId=" + deliveryEntityId + ", customerMobilenumber="
				+ customerMobilenumber + ", customerAddressLine1=" + customerAddressLine1 + ", customerAddressLine2="
				+ customerAddressLine2 + ", customerPin=" + customerPin + ", customerCountry=" + customerCountry
				+ ", customerState=" + customerState + ", customerDistrict=" + customerDistrict + ", customerLandmark="
				+ customerLandmark + ", createdTimestamp=" + createdTimestamp + ", updatedTimestamp=" + updatedTimestamp
				+ ", modifiedBy=" + modifiedBy + ", deliveryEntity=" + deliveryEntity + "]";
	}
}
