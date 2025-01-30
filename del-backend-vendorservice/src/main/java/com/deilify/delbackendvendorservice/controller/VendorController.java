package com.deilify.delbackendvendorservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deilify.delbackendvendorservice.dto.BankAccountDTO;
import com.deilify.delbackendvendorservice.dto.CustomResponse;
import com.deilify.delbackendvendorservice.dto.RegisterVendorMobileDTO;
import com.deilify.delbackendvendorservice.dto.SearchCriteria;
import com.deilify.delbackendvendorservice.dto.ServicesCreateDTO;
import com.deilify.delbackendvendorservice.dto.ServicesDTO;
import com.deilify.delbackendvendorservice.dto.VendorCreateDTO;
import com.deilify.delbackendvendorservice.dto.VendorDTO;
import com.deilify.delbackendvendorservice.entity.VendorEntity;
import com.deilify.delbackendvendorservice.dto.VendorBankAccountDTO;
import com.deilify.delbackendvendorservice.service.VendorService;

@RestController
@RequestMapping(value = "/api")
public class VendorController {
	
	@Autowired
	VendorService vendorService;
	
	@PostMapping(value = "/registerVendorMobileNumber")
	public ResponseEntity<RegisterVendorMobileDTO> registerMobile(@RequestBody RegisterVendorMobileDTO dto){
		return new ResponseEntity<>(vendorService.registerVendorMobile(dto), HttpStatus.OK);
	}
	
	@PostMapping(value = "/verifyOtpForVendor")
	public ResponseEntity<RegisterVendorMobileDTO> verifyOtpForVendor(@RequestBody RegisterVendorMobileDTO dto){
		return new ResponseEntity<>(vendorService.verifyOtp(dto), HttpStatus.OK);
	}
	
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
	
	@GetMapping(value = "/services/{vendorId}")
    public ResponseEntity<List<ServicesCreateDTO>> getServicesByVendorId(@PathVariable Integer vendorId) {
        List<ServicesCreateDTO> services = vendorService.getServicesByVendorId(vendorId);
        return new ResponseEntity<>(services, HttpStatus.OK);
    }
	
	@DeleteMapping(value = "/deleteVendor/{id}")
    public ResponseEntity<Void> deleteServicesById(@PathVariable Integer id) {
        vendorService.deleteVendorById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	@PostMapping(value = "/searchServices")
    public ResponseEntity<CustomResponse<ServicesCreateDTO>> searchServices(@RequestBody SearchCriteria searchCriteria) {
        Pageable pageable = PageRequest.of(searchCriteria.getPage(), searchCriteria.getSize());
        Page<ServicesCreateDTO> services = vendorService.searchServices(searchCriteria, pageable);
        CustomResponse<ServicesCreateDTO> customResponse = new CustomResponse<>(services.getContent());
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }
}
