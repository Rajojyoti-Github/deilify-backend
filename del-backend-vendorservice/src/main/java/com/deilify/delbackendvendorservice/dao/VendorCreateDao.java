package com.deilify.delbackendvendorservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.deilify.delbackendvendorservice.entity.VendorEntity;

public interface VendorCreateDao extends JpaRepository<VendorEntity, Integer> {
	
	@Query(value = "Select * from deilify.vendor vendor where vendor.name_of_vendor = :vendorName", nativeQuery = true)
	VendorEntity findByVendorName(@Param("vendorName") String vendorName);
	
	@Query(value = "Select * from deilify.vendor vendor where vendor.email_address = :vendorEmailId", nativeQuery = true)
	VendorEntity findByVendorEmailId(@Param("vendorEmailId") String vendorEmailId);
	
	@Query(value = "Select * from deilify.vendor vendor where vendor.phone_number = :vendorPhoneNumber", nativeQuery = true)
	VendorEntity findByVendorPhoneNumber(@Param("vendorPhoneNumber") String vendorPhoneNumber);

}
