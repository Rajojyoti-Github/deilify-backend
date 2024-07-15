package com.deilify.delbackenduserservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deilify.delbackenduserservice.dto.UserCreateDTO;
import com.deilify.delbackenduserservice.dto.UserDTO;
import com.deilify.delbackenduserservice.service.UserRegisterService;

@RestController
@RequestMapping(value = "/api")
public class UserController {
	
	@Autowired
	UserRegisterService registerService;
	
	@PostMapping(value = "/registerUser")
	public ResponseEntity<UserCreateDTO> registerUser (@RequestBody UserDTO user ){
		return new ResponseEntity<>(registerService.createUser(user), HttpStatus.OK);
		
	}
	
	@PutMapping(value = "/updateUser")
	public ResponseEntity<UserCreateDTO> updateUser (@RequestBody UserDTO user ){
		return new ResponseEntity<>(registerService.updateUser(user), HttpStatus.OK);
		
	}

}
