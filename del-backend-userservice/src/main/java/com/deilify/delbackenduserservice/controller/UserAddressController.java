package com.deilify.delbackenduserservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deilify.delbackenduserservice.dto.UserAddressCreateDTO;

@RestController
@RequestMapping(value = "/api")
public class UserAddressController {
	
//	@PostMapping(value = "/createUserAddress")
//	public ResponseEntity<UserAddressCreateDTO> registerAddress(@RequestBody ){
//		return new ResponseEntity<>(registerService.createUser(user), HttpStatus.OK);
//		
//	}

}
