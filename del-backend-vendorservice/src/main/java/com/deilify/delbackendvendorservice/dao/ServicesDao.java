package com.deilify.delbackendvendorservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deilify.delbackendvendorservice.entity.ServicesEntity;

@Repository
public interface ServicesDao extends JpaRepository<ServicesEntity, Integer>{

	List<ServicesEntity> findByVendorId(Integer vendorId);
}
