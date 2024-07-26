package com.deilify.delbackenddeliveryservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.deilify.delbackenddeliveryservice.entity.DeliveryEntity;

public interface DeliveryCreateDao extends JpaRepository<DeliveryEntity, Integer> {
	
	@Query(value = "Select * from deilify.delivery u where u.deliveryname = :deliveryname", nativeQuery = true)
	DeliveryEntity findByDeliveryName(@Param("deliveryname") String deliveryname);

}
