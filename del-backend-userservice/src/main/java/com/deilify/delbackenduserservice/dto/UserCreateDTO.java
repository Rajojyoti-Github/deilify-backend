/**
 * 
 */
package com.deilify.delbackenduserservice.dto;

import java.time.LocalDate;

/**
 * @author user
 *
 */
public class UserCreateDTO {
	
	private String userId;
	
	private String username;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String phone;
	
	private LocalDate createdTimestamp;
	
	private LocalDate updatedTimestamp;
	
	private String modified_By;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * @return the modified_By
	 */
	public String getModified_By() {
		return modified_By;
	}

	/**
	 * @param modified_By the modified_By to set
	 */
	public void setModified_By(String modified_By) {
		this.modified_By = modified_By;
	}

	/**
	 * @param userId
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param phone
	 * @param createdTimestamp
	 * @param updatedTimestamp
	 * @param modified_By
	 */
	public UserCreateDTO(String userId, String username, String password, String firstName, String lastName,
			String phone, LocalDate createdTimestamp, LocalDate updatedTimestamp, String modified_By) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.createdTimestamp = createdTimestamp;
		this.updatedTimestamp = updatedTimestamp;
		this.modified_By = modified_By;
	}

	/**
	 * 
	 */
	public UserCreateDTO() {
		super();
	}

	@Override
	public String toString() {
		return "UserCreateDTO [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", phone=" + phone + ", createdTimestamp=" + createdTimestamp
				+ ", updatedTimestamp=" + updatedTimestamp + ", modified_By=" + modified_By + "]";
	}

	

}
