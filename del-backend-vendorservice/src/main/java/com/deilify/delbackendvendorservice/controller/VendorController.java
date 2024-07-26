package com.deilify.delbackendvendorservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deilify.delbackendvendorservice.dto.BankAccountDTO;
import com.deilify.delbackendvendorservice.dto.ServicesCreateDTO;
import com.deilify.delbackendvendorservice.dto.ServicesDTO;
import com.deilify.delbackendvendorservice.dto.VendorCreateDTO;
import com.deilify.delbackendvendorservice.dto.VendorDTO;
import com.deilify.delbackendvendorservice.dto.VendorBankAccountDTO;
import com.deilify.delbackendvendorservice.service.VendorService;

@RestController
@RequestMapping(value = "/api")
public class VendorController {
	
	@Autowired
	VendorService vendorService;
	
	@PostMapping(value = "/registerVendor")
	public ResponseEntity<VendorCreateDTO> registerVendor (@RequestBody VendorDTO vendor ){
		return new ResponseEntity<>(vendorService.createVendor(vendor), HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateVendor")
	public ResponseEntity<VendorCreateDTO> updateVendor (@RequestBody VendorDTO vendor ){
		return new ResponseEntity<>(vendorService.updateVendor(vendor), HttpStatus.OK);
	}
	
	@PostMapping(value = "/addBankAccount")
	public ResponseEntity<BankAccountDTO> addVendorBankAccount (@RequestBody VendorBankAccountDTO vendor ){
		return new ResponseEntity<>(vendorService.addVendorBankAccount(vendor), HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateBankAccount")
	public ResponseEntity<BankAccountDTO> updateVendorBankAccount (@RequestBody VendorBankAccountDTO vendor ){
		return new ResponseEntity<>(vendorService.updateVendorBankAccount(vendor), HttpStatus.OK);
	}
	
	@PostMapping(value = "/services")
	public ResponseEntity<ServicesCreateDTO> createServicesVendor (@RequestBody ServicesDTO services ){
		return new ResponseEntity<>(vendorService.createServicesVendor(services), HttpStatus.OK);
	}
}