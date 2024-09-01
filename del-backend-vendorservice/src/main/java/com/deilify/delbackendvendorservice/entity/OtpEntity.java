package com.deilify.delbackendvendorservice.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendorotp")
public class OtpEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "mobile_number")
    private String mobileNumber;
	
	@Column(name = "otp")
    private String otp;
	
	@Column(name = "status")
    private String status;
	
	@Column(name = "created_time_stamp")
    private LocalDateTime createdTimeStamp;


    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(LocalDateTime createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

    // toString method
    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", otp='" + otp + '\'' +
                ", status='" + status + '\'' +
                ", createdTimeStamp=" + createdTimeStamp +
                '}';
    }
    
    // Constructors
    public OtpEntity() {
        // Default constructor
    }

    public OtpEntity(Integer id, String mobileNumber, String otp, String status, LocalDateTime createdTimeStamp) {
        this.id = id;
        this.mobileNumber = mobileNumber;
        this.otp = otp;
        this.status = status;
        this.createdTimeStamp = createdTimeStamp;
    }

}
