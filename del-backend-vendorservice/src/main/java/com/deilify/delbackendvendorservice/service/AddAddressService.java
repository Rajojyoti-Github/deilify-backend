package com.deilify.delbackendvendorservice.service;

import com.deilify.delbackendvendorservice.dto.StoreAddressCreateDTO;
import com.deilify.delbackendvendorservice.dto.StoreAddressDto;

import java.util.List;

import com.deilify.delbackendvendorservice.dto.RegisteredAddressCreateDTO;
import com.deilify.delbackendvendorservice.dto.RegisteredAddressDTO;

public interface AddAddressService {

	List<StoreAddressCreateDTO> addStoreAddress(List<StoreAddressDto> storeAddress);

	List<StoreAddressCreateDTO> updateStoreAddress(List<StoreAddressDto> storeAddress);

	RegisteredAddressCreateDTO addRegisteredAddress(RegisteredAddressDTO registeredAddress);

	RegisteredAddressCreateDTO updateRegisteredAddress(RegisteredAddressDTO registeredAddress);
}
