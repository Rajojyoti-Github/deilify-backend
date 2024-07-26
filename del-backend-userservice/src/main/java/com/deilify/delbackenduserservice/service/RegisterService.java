package com.deilify.delbackenduserservice.service;

import com.deilify.delbackenduserservice.dto.UserCreateDTO;
import com.deilify.delbackenduserservice.dto.UserDTO;

public interface RegisterService {

	UserCreateDTO createUser(UserDTO user);

	UserCreateDTO updateUser(UserDTO user);

}
