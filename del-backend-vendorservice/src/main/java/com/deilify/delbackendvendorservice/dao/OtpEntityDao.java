package com.deilify.delbackendvendorservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.deilify.delbackendvendorservice.entity.OtpEntity;

public interface OtpEntityDao extends JpaRepository<OtpEntity, Integer> {
	
	@Query(value = "Select * from deilify.vendorotp votp where votp.mobile_number = :mobileNumber", nativeQuery = true)
	OtpEntity getEntryByMobile(@Param("mobileNumber") String mobileNumber);

}
