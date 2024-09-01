package com.deilify.delbackendvendorservice.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.deilify.delbackendvendorservice.dto.BankAccountDTO;
import com.deilify.delbackendvendorservice.dto.RegisterVendorMobileDTO;
import com.deilify.delbackendvendorservice.dto.SearchCriteria;
import com.deilify.delbackendvendorservice.dto.ServicesCreateDTO;
import com.deilify.delbackendvendorservice.dto.ServicesDTO;
import com.deilify.delbackendvendorservice.dto.VendorCreateDTO;
import com.deilify.delbackendvendorservice.dto.VendorDTO;
import com.deilify.delbackendvendorservice.entity.VendorEntity;
import com.deilify.delbackendvendorservice.dto.VendorBankAccountDTO;

public interface VendorService {

	VendorCreateDTO createVendor(VendorDTO vendor);

	VendorCreateDTO updateVendor(VendorDTO vendor);

	BankAccountDTO addVendorBankAccount(VendorBankAccountDTO bankAccount);

	BankAccountDTO updateVendorBankAccount(VendorBankAccountDTO bankAccount);

	ServicesCreateDTO createServicesVendor(ServicesDTO services);
	
    List<ServicesCreateDTO> getServicesByVendorId(Integer vendorId);
    
    void deleteVendorById(Integer id);

    Page<ServicesCreateDTO> searchServices(SearchCriteria searchCriteria, Pageable pageable);
    
    RegisterVendorMobileDTO registerVendorMobile(RegisterVendorMobileDTO dto);

	RegisterVendorMobileDTO verifyOtp(RegisterVendorMobileDTO dto);

}
