package com.deilify.delbackenddeliveryservice.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.deilify.delbackenddeliveryservice.dto.DeliveryCreateDTO;
import com.deilify.delbackenddeliveryservice.dto.DeliveryDTO;
import com.deilify.delbackenddeliveryservice.dto.SearchRequest;

public interface DeliveryRegisterService {

	DeliveryCreateDTO createDelivery(DeliveryDTO user);

	DeliveryCreateDTO updateDelivery(DeliveryDTO user);
	
	List<DeliveryCreateDTO> getDeliveryById(Integer Id);
	
	Page<DeliveryCreateDTO> searchDeliveries(SearchRequest searchRequest,Pageable pageable);

}
