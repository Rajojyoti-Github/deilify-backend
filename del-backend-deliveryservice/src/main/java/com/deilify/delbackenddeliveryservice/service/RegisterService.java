package com.deilify.delbackenddeliveryservice.service;

import com.deilify.delbackenddeliveryservice.dto.DeliveryCreateDTO;
import com.deilify.delbackenddeliveryservice.dto.DeliveryDTO;

public interface RegisterService {

	DeliveryCreateDTO createDelivery(DeliveryDTO user);

	DeliveryCreateDTO updateDelivery(DeliveryDTO user);

}
