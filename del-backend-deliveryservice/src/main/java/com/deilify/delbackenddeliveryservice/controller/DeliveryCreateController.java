package com.deilify.delbackenddeliveryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deilify.delbackenddeliveryservice.dto.CustomResponse;
import com.deilify.delbackenddeliveryservice.dto.DeliveryCreateDTO;
import com.deilify.delbackenddeliveryservice.dto.DeliveryDTO;
import com.deilify.delbackenddeliveryservice.dto.SearchRequest;
import com.deilify.delbackenddeliveryservice.service.DeliveryRegisterService;

@RestController
@RequestMapping(value = "/api")
public class DeliveryCreateController {
	
	@Autowired
	DeliveryRegisterService registerService;
	
	@PostMapping(value = "/registerDelivery")
	public ResponseEntity<DeliveryCreateDTO> registerDelivery (@RequestBody DeliveryDTO user ){
		return new ResponseEntity<>(registerService.createDelivery(user), HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateDelivery")
	public ResponseEntity<DeliveryCreateDTO> updateDelivery (@RequestBody DeliveryDTO user ){
		return new ResponseEntity<>(registerService.updateDelivery(user), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getDelivery/{id}")
	public ResponseEntity<List<DeliveryCreateDTO>> getDeliveryById(@PathVariable Integer id){
		List<DeliveryCreateDTO> delivery = registerService.getDeliveryById(id);
		return new ResponseEntity<>(delivery,HttpStatus.OK);
	}
	
	@PostMapping(value = "/searchDeliveries")
	public ResponseEntity<CustomResponse<DeliveryCreateDTO>> seacrhDeliveries(@RequestBody SearchRequest searchRequest) {
		PageRequest pageable = PageRequest.of(searchRequest.getPage(), searchRequest.getSize());
		Page<DeliveryCreateDTO> deliveries = registerService.searchDeliveries(searchRequest, pageable);
		CustomResponse<DeliveryCreateDTO> customResponse = new CustomResponse<>(deliveries.getContent());
		return new ResponseEntity<>(customResponse, HttpStatus.OK);
	}
}
