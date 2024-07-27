package com.deilify.delbackenddeliveryservice.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.deilify.delbackenddeliveryservice.dao.DeliveryCreateDao;
import com.deilify.delbackenddeliveryservice.dto.DeliveryCreateDTO;
import com.deilify.delbackenddeliveryservice.dto.DeliveryDTO;
import com.deilify.delbackenddeliveryservice.dto.SearchRequest;
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

	@Override
	public List<DeliveryCreateDTO> getDeliveryById(Integer Id) {
		Optional<DeliveryEntity> deliveryEntities = DeliveryCreateDao.findById(Id);
		return deliveryEntities.stream().map(this::getMapDeliveryToDto).collect(Collectors.toList());
	}

	
	 private DeliveryCreateDTO getMapDeliveryToDto(DeliveryEntity deliveryEntity) {
		 	DeliveryCreateDTO deliveryDto=new DeliveryCreateDTO();
	        
	        deliveryDto.setDeliveryId(deliveryEntity.getDeliveryId().toString());
	        deliveryDto.setDeliveryname(deliveryEntity.getDeliveryname());
	        deliveryDto.setFirstName(deliveryEntity.getFirstName());
	        deliveryDto.setLastName(deliveryEntity.getLastName());
	        deliveryDto.setPhone(deliveryEntity.getPhone());
	        deliveryDto.setPassword(deliveryEntity.getPassword());
	        deliveryDto.setModified_By(deliveryEntity.getModifiedBy());
	        deliveryDto.setCreatedTimestamp(deliveryEntity.getCreatedTimestamp());
	        deliveryDto.setUpdatedTimestamp(deliveryEntity.getUpdatedTimestamp());       
	                
	        return deliveryDto;
	    }

	@Override
	public Page<DeliveryCreateDTO> searchDeliveries(SearchRequest searchRequest, Pageable pageable) {
		List<DeliveryEntity> filteredDeliveries = DeliveryCreateDao.findAll().stream().filter(delivery->deliveryMatcherCriteria(delivery, searchRequest.getServices())).collect(Collectors.toList());
		 int start = (int) pageable.getOffset();
	     int end = Math.min((start + pageable.getPageSize()), filteredDeliveries.size());
	     List<DeliveryCreateDTO> paginatedList = filteredDeliveries.subList(start, end).stream().map(delivery->convertToDTo(delivery)).collect(Collectors.toList());
		return new PageImpl<>(paginatedList,pageable,filteredDeliveries.size());
	}
	private DeliveryCreateDTO convertToDTo(DeliveryEntity delivery) {
		DeliveryCreateDTO deliveriesDto = new DeliveryCreateDTO();
		deliveriesDto.setDeliveryId(delivery.getDeliveryId().toString());
		deliveriesDto.setDeliveryname(delivery.getDeliveryname());
		deliveriesDto.setFirstName(delivery.getFirstName());
		deliveriesDto.setLastName(delivery.getLastName());
		deliveriesDto.setPhone(delivery.getPhone());
		deliveriesDto.setPassword(delivery.getPassword());
		deliveriesDto.setCreatedTimestamp(delivery.getCreatedTimestamp());
		deliveriesDto.setUpdatedTimestamp(delivery.getUpdatedTimestamp());
		return null;
	}

	private boolean deliveryMatcherCriteria(DeliveryEntity delivery,List<DeliveryDTO> list) {
		return true;
	}
}
