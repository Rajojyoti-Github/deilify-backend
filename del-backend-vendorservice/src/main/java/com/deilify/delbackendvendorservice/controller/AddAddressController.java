package com.deilify.delbackendvendorservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deilify.delbackendvendorservice.dto.StoreAddressCreateDTO;
import com.deilify.delbackendvendorservice.dto.StoreAddressDto;
import com.deilify.delbackendvendorservice.dto.RegisteredAddressCreateDTO;
import com.deilify.delbackendvendorservice.dto.RegisteredAddressDTO;
import com.deilify.delbackendvendorservice.service.AddAddressService;

@RestController
@RequestMapping(value = "/api")
public class AddAddressController {
	
	@Autowired
	AddAddressService addressService;
	
	@PostMapping(value = "/addStoreAddress")
	public ResponseEntity<List<StoreAddressCreateDTO>> addStoreAddress (@RequestBody List<StoreAddressDto> storeAddress ){
		return new ResponseEntity<>(addressService.addStoreAddress(storeAddress), HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateStoreAddress")
	public ResponseEntity<List<StoreAddressCreateDTO>> updateStoreAddress (@RequestBody List<StoreAddressDto> storeAddress ){
		return new ResponseEntity<>(addressService.updateStoreAddress(storeAddress), HttpStatus.OK);
	}
	
	@PostMapping(value = "/addRegisteredAddress")
	public ResponseEntity<RegisteredAddressCreateDTO> addRegisteredAddress (@RequestBody RegisteredAddressDTO registeredAddress ){
		return new ResponseEntity<>(addressService.addRegisteredAddress(registeredAddress), HttpStatus.OK);
	}

	@PutMapping(value = "/updateRegisteredAddress")
	public ResponseEntity<RegisteredAddressCreateDTO> updateRegisteredAddress (@RequestBody RegisteredAddressDTO registeredAddress ){
		return new ResponseEntity<>(addressService.updateRegisteredAddress(registeredAddress), HttpStatus.OK);
	}
}
