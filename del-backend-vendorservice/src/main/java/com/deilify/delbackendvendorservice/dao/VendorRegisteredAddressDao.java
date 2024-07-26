package com.deilify.delbackendvendorservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deilify.delbackendvendorservice.entity.VendorRegisteredAddressEnitity;

public interface VendorRegisteredAddressDao extends JpaRepository<VendorRegisteredAddressEnitity, Integer>{

}
