package com.deilify.delbackendvendorservice.service;

import com.deilify.delbackendvendorservice.dto.BankAccountDTO;
import com.deilify.delbackendvendorservice.dto.ServicesCreateDTO;
import com.deilify.delbackendvendorservice.dto.ServicesDTO;
import com.deilify.delbackendvendorservice.dto.VendorCreateDTO;
import com.deilify.delbackendvendorservice.dto.VendorDTO;
import com.deilify.delbackendvendorservice.dto.VendorBankAccountDTO;

public interface VendorService {

	VendorCreateDTO createVendor(VendorDTO vendor);

	VendorCreateDTO updateVendor(VendorDTO vendor);

	BankAccountDTO addVendorBankAccount(VendorBankAccountDTO bankAccount);

	BankAccountDTO updateVendorBankAccount(VendorBankAccountDTO bankAccount);

	ServicesCreateDTO createServicesVendor(ServicesDTO services);

}
