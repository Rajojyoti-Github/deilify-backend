package com.deilify.delbackendvendorservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.deilify.delbackendvendorservice.entity.VendorPaymentEntity;

public interface VendorPaymentDao extends JpaRepository<VendorPaymentEntity, Integer>{

	@Query(value = "Select * from deilify.vendorpayment vendor where vendor.vendor_entity_id = :vendorId", nativeQuery = true)
	VendorPaymentEntity findByVendorId(@Param("vendorId") Integer vendorId);
	
}
