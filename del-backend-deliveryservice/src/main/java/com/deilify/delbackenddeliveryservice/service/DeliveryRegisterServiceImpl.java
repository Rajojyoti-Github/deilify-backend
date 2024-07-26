package com.deilify.delbackenddeliveryservice.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deilify.delbackenddeliveryservice.dao.DeliveryCreateDao;
import com.deilify.delbackenddeliveryservice.dto.DeliveryCreateDTO;
import com.deilify.delbackenddeliveryservice.dto.DeliveryDTO;
import com.deilify.delbackenddeliveryservice.entity.DeliveryEntity;

@Service
public class DeliveryRegisterServiceImpl implements DeliveryRegisterService {

	@Autowired
	DeliveryCreateDao DeliveryCreateDao;

	public DeliveryCreateDTO createDelivery(DeliveryDTO Delivery) {
		if (Delivery.getDeliveryname() != null) {
			DeliveryEntity DeliveryCreateDTO = DeliveryCreateDao.findByDeliveryName(Delivery.getDeliveryname());
			if (DeliveryCreateDTO == null) {
				DeliveryEntity deliveryEntity = new DeliveryEntity();
				deliveryEntity.setDeliveryname(Delivery.getDeliveryname());
				deliveryEntity.setFirstName(Delivery.getFirstName());
				deliveryEntity.setLastName(Delivery.getLastName());
				deliveryEntity.setPhone(Delivery.getPhone());
				deliveryEntity.setPassword(Delivery.getPassword());
				deliveryEntity.setCreatedTimestamp(LocalDate.now());
				deliveryEntity.setUpdatedTimestamp(LocalDate.now());
				deliveryEntity.setModifiedBy("System");

				DeliveryCreateDao.save(deliveryEntity);
				System.out.println("Delivery has been successfully registered");
				return mapDeliveryToDto(Delivery);
			} else {
				System.out.println("DeliveryId is already present");
			}
		}
		System.out.println("DeliveryId is already present");
		return null;
	}

	private DeliveryCreateDTO mapDeliveryToDto(DeliveryDTO Delivery) {
		DeliveryEntity newDelivery = DeliveryCreateDao.findByDeliveryName(Delivery.getDeliveryname());
		DeliveryCreateDTO myNewDelivery = new DeliveryCreateDTO();

		if (newDelivery.getDeliveryname() != null) {
			if (newDelivery.getDeliveryId() != null) {
				myNewDelivery.setDeliveryId(newDelivery.getDeliveryId().toString());
			}
			if (Delivery.getDeliveryname() != null) {
				myNewDelivery.setDeliveryname(Delivery.getDeliveryname());
			}
			if (Delivery.getPassword() != null) {
				myNewDelivery.setPassword(Delivery.getPassword());
			}
			if (Delivery.getFirstName() != null) {
				myNewDelivery.setFirstName(Delivery.getFirstName());
			}
			if (Delivery.getLastName() != null) {
				myNewDelivery.setLastName(Delivery.getLastName());
			}
			if (Delivery.getPhone() != null) {
				myNewDelivery.setPhone(Delivery.getPhone());
			}

			myNewDelivery.setModified_By("System");
			myNewDelivery.setCreatedTimestamp(LocalDate.now());
			myNewDelivery.setUpdatedTimestamp(LocalDate.now());
		}

		return myNewDelivery;
	}

	@Override
	public DeliveryCreateDTO updateDelivery(DeliveryDTO Delivery) {
		
		
		if (Delivery.getDeliveryname() != null) {
			DeliveryEntity DeliveryUpdateDTO = DeliveryCreateDao.findByDeliveryName(Delivery.getDeliveryname());
			
			if(DeliveryUpdateDTO != null) {
				if(!isBlankNullEmpty(Delivery.getFirstName())) {
					DeliveryUpdateDTO.setFirstName(Delivery.getFirstName());
				}
				if(!isBlankNullEmpty(Delivery.getLastName())) {
					DeliveryUpdateDTO.setFirstName(Delivery.getLastName());
				}
				if(!isBlankNullEmpty(Delivery.getLastName())) {
					DeliveryUpdateDTO.setLastName(Delivery.getLastName());
				}
				if(!isBlankNullEmpty(Delivery.getPhone())) {
					DeliveryUpdateDTO.setPhone(Delivery.getPhone());
				}
				if(!isBlankNullEmpty(Delivery.getPhone())) {
					DeliveryUpdateDTO.setPhone(Delivery.getPhone());
				}
				if(!isBlankNullEmpty(Delivery.getPassword())) {
					DeliveryUpdateDTO.setPassword(Delivery.getPassword());
				}
				DeliveryUpdateDTO.setUpdatedTimestamp(LocalDate.now());
				DeliveryUpdateDTO.setModifiedBy("System");
				DeliveryCreateDao.save(DeliveryUpdateDTO);
				
			}
		}
		return mapDeliveryToDto(Delivery);
	}
	
	private boolean isBlankNullEmpty(String parameter) {
		boolean isEmpty = false;
		if(parameter.isBlank() || parameter.isEmpty() || parameter == null) {
			isEmpty = true;
		}
		return isEmpty;
	}

}
