package com.deilify.delbackenddeliveryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deilify.delbackenddeliveryservice.dto.DeliveryCreateDTO;
import com.deilify.delbackenddeliveryservice.dto.DeliveryDTO;
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

}
