package com.deilify.delbackenddeliveryservice.dto;

import java.time.LocalDate;

public class DeliveryDTO {

	private String deliveryname;

	private String password;

	private String firstName;

	private String lastName;

	private String phone;

	private LocalDate createdTimestamp;

	private LocalDate updatedTimestamp;

	private String modifiedBy;

	/**
	 * @return the deliveryname
	 */
	public String getDeliveryname() {
		return deliveryname;
	}

	/**
	 * @param deliveryname the deliveryname to set
	 */
	public void setDeliveryname(String deliveryname) {
		this.deliveryname = deliveryname;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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
	 * @param deliveryname
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param phone
	 * @param createdTimestamp
	 * @param updatedTimestamp
	 * @param modifiedBy
	 */
	public DeliveryDTO(String deliveryname, String password, String firstName, String lastName, String phone,
			LocalDate createdTimestamp, LocalDate updatedTimestamp, String modifiedBy) {
		super();
		this.deliveryname = deliveryname;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.createdTimestamp = createdTimestamp;
		this.updatedTimestamp = updatedTimestamp;
		this.modifiedBy = modifiedBy;
	}

	/**
	 * 
	 */
	public DeliveryDTO() {
		super();
	}

	@Override
	public String toString() {
		return "deliveryDTO [deliveryname=" + deliveryname + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", phone=" + phone + ", createdTimestamp=" + createdTimestamp + ", updatedTimestamp="
				+ updatedTimestamp + ", modifiedBy=" + modifiedBy + "]";
	}

}
