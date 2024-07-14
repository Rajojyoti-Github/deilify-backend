package com.deilify.delbackendvendorservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deilify.delbackendvendorservice.dao.VendorStoreAddressDao;
import com.deilify.delbackendvendorservice.dao.VendorCreateDao;
import com.deilify.delbackendvendorservice.dao.VendorRegisteredAddressDao;
import com.deilify.delbackendvendorservice.dto.StoreAddressCreateDTO;
import com.deilify.delbackendvendorservice.dto.StoreAddressDto;
import com.deilify.delbackendvendorservice.dto.RegisteredAddressCreateDTO;
import com.deilify.delbackendvendorservice.dto.RegisteredAddressDTO;
import com.deilify.delbackendvendorservice.entity.VendorStoreAddressEnitity;
import com.deilify.delbackendvendorservice.entity.VendorEntity;
import com.deilify.delbackendvendorservice.entity.VendorRegisteredAddressEnitity;

@Service
public class AddAddressServiceImpl implements AddAddressService {

	@Autowired
	VendorCreateDao vendorDao;

	@Autowired
	VendorStoreAddressDao storeAddressDao;

	@Autowired
	VendorRegisteredAddressDao registeredAddressDao;

	@Override
	public List<StoreAddressCreateDTO> addStoreAddress(List<StoreAddressDto> storeAddress) {
		List<VendorStoreAddressEnitity> addressEntityList = new ArrayList<>();
		VendorEntity entity = vendorDao.findById(storeAddress.get(0).getVendorEntityId()).get();

		if (entity != null) {
			for (StoreAddressDto storeAddressDto : storeAddress) {
				VendorStoreAddressEnitity storeAddressEnitity = new VendorStoreAddressEnitity();
				storeAddressEnitity.setVendorEntityId(storeAddressDto.getVendorEntityId());
				storeAddressEnitity.setAddressLine1(storeAddressDto.getAddressLine1());
				storeAddressEnitity.setAddressLine2(storeAddressDto.getAddressLine2());
				storeAddressEnitity.setCity(storeAddressDto.getCity());
				storeAddressEnitity.setCountry(storeAddressDto.getCountry());
				storeAddressEnitity.setDistrict(storeAddressDto.getDistrict());
				storeAddressEnitity.setPin(storeAddressDto.getPin());
				storeAddressEnitity.setState(storeAddressDto.getState());
				addressEntityList.add(storeAddressEnitity);
			}
		}
		storeAddressDao.saveAll(addressEntityList);
		System.out.println("Store address has been successfully added");
		return mapVendorAddressToDtoList(addressEntityList);
	}

	private List<StoreAddressCreateDTO> mapVendorAddressToDtoList(List<VendorStoreAddressEnitity> addressEntityList) {
		List<StoreAddressCreateDTO> addressDtoList = new ArrayList<>();
		for (VendorStoreAddressEnitity storeAddressDto : addressEntityList) {
			StoreAddressCreateDTO addressDto = new StoreAddressCreateDTO();
			addressDto.setStoreAddressId(storeAddressDto.getStoreAddressId());
			addressDto.setVendorEntityId(storeAddressDto.getVendorEntityId());
			addressDto.setAddressLine1(storeAddressDto.getAddressLine1());
			addressDto.setAddressLine2(storeAddressDto.getAddressLine2());
			addressDto.setCity(storeAddressDto.getCity());
			addressDto.setCountry(storeAddressDto.getCountry());
			addressDto.setDistrict(storeAddressDto.getDistrict());
			addressDto.setPin(storeAddressDto.getPin());
			addressDto.setState(storeAddressDto.getState());
			addressDtoList.add(addressDto);
		}
		return addressDtoList;
	}

	@Override
	public List<StoreAddressCreateDTO> updateStoreAddress(List<StoreAddressDto> storeAddress) {
		List<VendorStoreAddressEnitity> addressEntityList = new ArrayList<>();
		VendorEntity entity = vendorDao.findById(storeAddress.get(0).getVendorEntityId()).get();

		if (entity != null) {
			for (StoreAddressDto storeAddressDto : storeAddress) {
				VendorStoreAddressEnitity storeAddressEnitity = new VendorStoreAddressEnitity();
				storeAddressEnitity.setStoreAddressId(storeAddressDto.getStoreAddressId());
				storeAddressEnitity.setVendorEntityId(storeAddressDto.getVendorEntityId());
				storeAddressEnitity.setAddressLine1(storeAddressDto.getAddressLine1());
				storeAddressEnitity.setAddressLine2(storeAddressDto.getAddressLine2());
				storeAddressEnitity.setCity(storeAddressDto.getCity());
				storeAddressEnitity.setCountry(storeAddressDto.getCountry());
				storeAddressEnitity.setDistrict(storeAddressDto.getDistrict());
				storeAddressEnitity.setPin(storeAddressDto.getPin());
				storeAddressEnitity.setState(storeAddressDto.getState());
				addressEntityList.add(storeAddressEnitity);
			}
		}
		storeAddressDao.saveAll(addressEntityList);
		System.out.println("Store address has been successfully updated account detailed");
		return mapVendorAddressToDto(storeAddress);
	}

	private List<StoreAddressCreateDTO> mapVendorAddressToDto(List<StoreAddressDto> storeAddress) {
		List<StoreAddressCreateDTO> addressDtoList = new ArrayList<>();
		for (StoreAddressDto storeAddressDto : storeAddress) {
			StoreAddressCreateDTO addressDto = new StoreAddressCreateDTO();
			addressDto.setStoreAddressId(storeAddressDto.getStoreAddressId());
			addressDto.setVendorEntityId(storeAddressDto.getVendorEntityId());
			addressDto.setAddressLine1(storeAddressDto.getAddressLine1());
			addressDto.setAddressLine2(storeAddressDto.getAddressLine2());
			addressDto.setCity(storeAddressDto.getCity());
			addressDto.setCountry(storeAddressDto.getCountry());
			addressDto.setDistrict(storeAddressDto.getDistrict());
			addressDto.setPin(storeAddressDto.getPin());
			addressDto.setState(storeAddressDto.getState());
			addressDtoList.add(addressDto);
		}
		return addressDtoList;
	}

	@Override
	public RegisteredAddressCreateDTO addRegisteredAddress(RegisteredAddressDTO registeredAddress) {
		VendorRegisteredAddressEnitity registeredAddressEnitity = new VendorRegisteredAddressEnitity();
		VendorEntity entity = vendorDao.findById(registeredAddress.getVendorEntityId()).get();

		if (entity != null) {
			registeredAddressEnitity.setAddressLine1(registeredAddress.getAddressLine1());
			registeredAddressEnitity.setAddressLine2(registeredAddress.getAddressLine2());
			registeredAddressEnitity.setCity(registeredAddress.getCity());
			registeredAddressEnitity.setCountry(registeredAddress.getCountry());
			registeredAddressEnitity.setDistrict(registeredAddress.getDistrict());
			registeredAddressEnitity.setPin(registeredAddress.getPin());
			registeredAddressEnitity.setState(registeredAddress.getState());
		}
		registeredAddressDao.save(registeredAddressEnitity);
		System.out.println("Registered address has been successfully added");
		return mapVendorAddressToDto(registeredAddress, registeredAddressEnitity.getRegisteredAddressId());
	}

	@Override
	public RegisteredAddressCreateDTO updateRegisteredAddress(RegisteredAddressDTO registeredAddress) {
		VendorRegisteredAddressEnitity registeredAddressEnitity = new VendorRegisteredAddressEnitity();
		VendorEntity entity = vendorDao.findById(registeredAddress.getVendorEntityId()).get();

		if (entity != null) {
			registeredAddressEnitity.setRegisteredAddressId(registeredAddress.getRegisteredAddressId());
			registeredAddressEnitity.setVendorEntityId(registeredAddress.getVendorEntityId());
			registeredAddressEnitity.setAddressLine1(registeredAddress.getAddressLine1());
			registeredAddressEnitity.setAddressLine2(registeredAddress.getAddressLine2());
			registeredAddressEnitity.setCity(registeredAddress.getCity());
			registeredAddressEnitity.setCountry(registeredAddress.getCountry());
			registeredAddressEnitity.setDistrict(registeredAddress.getDistrict());
			registeredAddressEnitity.setPin(registeredAddress.getPin());
			registeredAddressEnitity.setState(registeredAddress.getState());
		}
		registeredAddressDao.save(registeredAddressEnitity);
		System.out.println("Registered address has been successfully added");
		return mapVendorAddressToDto(registeredAddress, registeredAddress.getRegisteredAddressId());
	}

	private RegisteredAddressCreateDTO mapVendorAddressToDto(RegisteredAddressDTO registeredAddress, Integer id) {
		RegisteredAddressCreateDTO addressDto = new RegisteredAddressCreateDTO();

		addressDto.setRegisteredAddressId(id);
		addressDto.setVendorEntityId(registeredAddress.getVendorEntityId());
		addressDto.setAddressLine1(registeredAddress.getAddressLine1());
		addressDto.setAddressLine2(registeredAddress.getAddressLine2());
		addressDto.setCity(registeredAddress.getCity());
		addressDto.setCountry(registeredAddress.getCountry());
		addressDto.setDistrict(registeredAddress.getDistrict());
		addressDto.setPin(registeredAddress.getPin());
		addressDto.setState(registeredAddress.getState());
		return addressDto;
	}
}
