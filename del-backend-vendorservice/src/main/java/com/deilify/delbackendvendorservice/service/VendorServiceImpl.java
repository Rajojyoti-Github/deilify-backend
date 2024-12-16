package com.deilify.delbackendvendorservice.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.micrometer.common.util.StringUtils;

import com.amazonaws.AbortedException;
import com.deilify.delbackendvendorservice.dao.OtpEntityDao;
import com.deilify.delbackendvendorservice.dao.ServicesDao;
import com.deilify.delbackendvendorservice.dao.VendorCreateDao;
import com.deilify.delbackendvendorservice.dao.VendorPaymentDao;
import com.deilify.delbackendvendorservice.dto.BankAccountDTO;
import com.deilify.delbackendvendorservice.dto.RegisterVendorMobileDTO;
import com.deilify.delbackendvendorservice.dto.SearchCriteria;
import com.deilify.delbackendvendorservice.dto.ServicesCreateDTO;
import com.deilify.delbackendvendorservice.dto.ServicesDTO;
import com.deilify.delbackendvendorservice.dto.VendorCreateDTO;
import com.deilify.delbackendvendorservice.dto.VendorDTO;
import com.deilify.delbackendvendorservice.dto.VendorBankAccountDTO;
import com.deilify.delbackendvendorservice.entity.OtpEntity;
import com.deilify.delbackendvendorservice.entity.ServicesEntity;
import com.deilify.delbackendvendorservice.entity.VendorEntity;
import com.deilify.delbackendvendorservice.entity.VendorPaymentEntity;
import com.deilify.delbackendvendorservice.exception.InvalidOtpFoundException;
import com.deilify.delbackendvendorservice.exception.VendorNotFoundException;
import com.deilify.delbackendvendorservice.util.AwsSNSClient;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	VendorCreateDao vendorDao;
	
	@Autowired
	ServicesDao servicesDao;

	@Autowired
	VendorPaymentDao vendorPaymentDao;
	
	@Autowired
	OtpEntityDao otpEntityDao;
	
	@Autowired
	AwsSNSClient awsSNSClientVendor;

	public VendorCreateDTO createVendor(VendorDTO vendorDto) {
		VendorEntity vendorEntity = new VendorEntity();
		VendorCreateDTO dto = new VendorCreateDTO();

		String validationResult = checkIfVendorExist(vendorDto);

		if (validationResult.equalsIgnoreCase("Proceed")) {
			vendorEntity.setNameOfVendor(vendorDto.getNameOfVendor());
			vendorEntity.setNameOfBusiness(vendorDto.getNameOfBusiness());
			vendorEntity.setAddress(vendorDto.getAddress());
			vendorEntity.setPhoneNumber(vendorDto.getPhoneNumber());
			vendorEntity.setEmailAddress(vendorDto.getEmailAddress());
			vendorEntity.setTradeLicenseNumber(vendorDto.getTradeLicenseNumber());
			vendorEntity.setTradeLicenceValidityDate(vendorDto.getTradeLicenceValidityDate());
			vendorEntity.setGstNumber(vendorDto.getGstNumber());
			vendorEntity.setCreatedTimestamp(LocalDate.now());
			vendorEntity.setUpdatedTimestamp(LocalDate.now());
			vendorEntity.setModifiedBy("System");

			vendorDao.save(vendorEntity);
			System.out.println(vendorDto.getNameOfVendor() + " has been successfully registered");
			return mapVendorToDto(vendorDto, vendorEntity.getId());
		} else {
			dto.setErrorMessage(validationResult);
			return dto;
		}

	}

	private boolean isNullBlankEmpty(String str) {
		return str == null || str.isEmpty() || str.isBlank();
	}

	private String checkIfVendorExist(VendorDTO vendorDto) {
		VendorEntity vendorNameValidation = vendorDao.findByVendorName(vendorDto.getNameOfVendor());
		VendorEntity vendorPhoneNumberValidation = vendorDao.findByVendorPhoneNumber(vendorDto.getPhoneNumber());
		VendorEntity vendorEmailIdValidation = vendorDao.findByVendorEmailId(vendorDto.getEmailAddress());

		if (vendorNameValidation != null && vendorPhoneNumberValidation != null && vendorEmailIdValidation != null) {
			return "Name, phone number and email id already exist! Try again";
		} else if (vendorNameValidation != null && vendorPhoneNumberValidation != null) {
			return "Name and phone number already exist! Try again";
		} else if (vendorPhoneNumberValidation != null && vendorEmailIdValidation != null) {
			return "Name and Email Id already exist! Try again";
		} else if (vendorNameValidation != null) {
			return "Name already exist! Try with different name";
		} else if (vendorPhoneNumberValidation != null) {
			return "Email id already exist! Try with different Email id";
		} else if (vendorEmailIdValidation != null) {
			return "Phone number already exist! Try with different Phone number";
		} else {
			return "Proceed";
		}

	}

	private VendorCreateDTO mapVendorToDto(VendorDTO vendorDto, Integer id) {
		VendorCreateDTO createNewVendor = new VendorCreateDTO();

		createNewVendor.setVendorId(id);
		createNewVendor.setNameOfVendor(vendorDto.getNameOfVendor());
		createNewVendor.setNameOfBusiness(vendorDto.getNameOfBusiness());
		createNewVendor.setAddress(vendorDto.getAddress());
		createNewVendor.setPhoneNumber(vendorDto.getPhoneNumber());
		createNewVendor.setEmailAddress(vendorDto.getEmailAddress());
		createNewVendor.setTradeLicenseNumber(vendorDto.getTradeLicenseNumber());
		createNewVendor.setTradeLicenceValidityDate(vendorDto.getTradeLicenceValidityDate());
		createNewVendor.setGstNumber(vendorDto.getGstNumber());
		createNewVendor.setCreatedTimestamp(LocalDate.now());
		createNewVendor.setUpdatedTimestamp(LocalDate.now());
		createNewVendor.setModifiedBy("System");

		return createNewVendor;
	}

	@Override
	public VendorCreateDTO updateVendor(VendorDTO vendorDto) {

		VendorEntity vendorUpdateDTO = vendorDao.findById(Integer.valueOf(vendorDto.getVendorId())).get();

		vendorUpdateDTO.setId(vendorDto.getVendorId());
		vendorUpdateDTO.setNameOfVendor(vendorDto.getNameOfVendor());
		vendorUpdateDTO.setNameOfBusiness(vendorDto.getNameOfBusiness());
		vendorUpdateDTO.setAddress(vendorDto.getAddress());
		vendorUpdateDTO.setPhoneNumber(vendorDto.getPhoneNumber());
		vendorUpdateDTO.setEmailAddress(vendorDto.getEmailAddress());
		vendorUpdateDTO.setTradeLicenseNumber(vendorDto.getTradeLicenseNumber());
		vendorUpdateDTO.setTradeLicenceValidityDate(vendorDto.getTradeLicenceValidityDate());
		vendorUpdateDTO.setGstNumber(vendorDto.getGstNumber());
		vendorUpdateDTO.setCreatedTimestamp(LocalDate.now());
		vendorUpdateDTO.setUpdatedTimestamp(LocalDate.now());
		vendorUpdateDTO.setModifiedBy("System");

		vendorDao.save(vendorUpdateDTO);
		System.out.println(vendorDto.getNameOfVendor() + " has been successfully Updated");
		return mapVendorToDto(vendorDto, vendorDto.getVendorId());
	}

	@Override
	public BankAccountDTO addVendorBankAccount(VendorBankAccountDTO vendorDto) {
		VendorPaymentEntity paymentEntity = new VendorPaymentEntity();

		VendorEntity entity = vendorDao.findById(vendorDto.getVendorId()).get();

		if (entity != null) {
			paymentEntity.setVendorEntityId(vendorDto.getVendorId());
			paymentEntity.setAccountHolderName(vendorDto.getAccountHolderName());
			paymentEntity.setBankAccountNumber(vendorDto.getBankAccountNumber());
			paymentEntity.setBankName(vendorDto.getBankName());
			paymentEntity.setBeneficiaryName(vendorDto.getBeneficiaryName());
			paymentEntity.setIfscCode(vendorDto.getIfscCode());
			paymentEntity.setUpiId(vendorDto.getUpiId());
		}
		vendorPaymentDao.save(paymentEntity);
		System.out.println(vendorDto.getAccountHolderName() + " has been successfully added account detailed");
		return mapVendorToDto(vendorDto,paymentEntity.getId());

	}

	private BankAccountDTO mapVendorToDto(VendorBankAccountDTO vendorDto, Integer id) {
		BankAccountDTO paymentDto = new BankAccountDTO();

		paymentDto.setPaymentId(id);
		paymentDto.setVendorId(vendorDto.getVendorId());
		paymentDto.setAccountHolderName(vendorDto.getAccountHolderName());
		paymentDto.setBankAccountNumber(vendorDto.getBankAccountNumber());
		paymentDto.setBankName(vendorDto.getBankName());
		paymentDto.setBeneficiaryName(vendorDto.getBeneficiaryName());
		paymentDto.setIfscCode(vendorDto.getIfscCode());
		paymentDto.setUpiId(vendorDto.getUpiId());
		paymentDto.setStatus("Success");
		return paymentDto;
	}

	@Override
	public BankAccountDTO updateVendorBankAccount(VendorBankAccountDTO vendorDto) {
		VendorPaymentEntity paymentUpdateDTO = vendorPaymentDao.findById(vendorDto.getPaymentId()).get();
		VendorEntity entity = vendorDao.findById(vendorDto.getVendorId()).get();

		if (entity != null) {
			paymentUpdateDTO.setId(vendorDto.getPaymentId());
			paymentUpdateDTO.setVendorEntityId(vendorDto.getVendorId());
			paymentUpdateDTO.setAccountHolderName(vendorDto.getAccountHolderName());
			paymentUpdateDTO.setBankAccountNumber(vendorDto.getBankAccountNumber());
			paymentUpdateDTO.setBankName(vendorDto.getBankName());
			paymentUpdateDTO.setBeneficiaryName(vendorDto.getBeneficiaryName());
			paymentUpdateDTO.setIfscCode(vendorDto.getIfscCode());
			paymentUpdateDTO.setUpiId(vendorDto.getUpiId());
		}
		vendorPaymentDao.save(paymentUpdateDTO);
		System.out.println(vendorDto.getAccountHolderName() + " has been successfully updated account detailed");
		return mapVendorToDto(vendorDto,vendorDto.getPaymentId());
	}

	@Override
	public ServicesCreateDTO createServicesVendor(ServicesDTO services) {
		ServicesEntity servicesEntity = new ServicesEntity();

		VendorEntity entity = vendorDao.findById(services.getVendorId()).get();

		if (entity != null) {
			servicesEntity.setVendorId(services.getVendorId());
			servicesEntity.setNameOfVendor(services.getNameOfVendor());
			servicesEntity.setCategory(services.getCategory());
			servicesEntity.setVendorStoreId(services.getVendorStoreId());
			servicesEntity.setSubCategory(services.getSubCategory());
			servicesEntity.setServiceLine(services.getServiceLine());
			servicesEntity.setPrice(services.getPrice());
			servicesEntity.setCreatedTimestamp(LocalDateTime.now());
			servicesEntity.setUpdatedTimestamp(LocalDateTime.now());
		}
		servicesDao.save(servicesEntity);
		System.out.println("Services for this vendorId "+ services.getVendorId() + " has been successfully added");
		return mapVendorToDto(servicesEntity);
	}

	private ServicesCreateDTO mapVendorToDto(ServicesEntity servicesEntity) {
		ServicesCreateDTO servicesDto = new ServicesCreateDTO();
		
		servicesDto.setId(servicesEntity.getId());
		servicesDto.setVendorId(servicesEntity.getVendorId());
		servicesDto.setNameOfVendor(servicesEntity.getNameOfVendor());
		servicesDto.setCategory(servicesEntity.getCategory());
		servicesDto.setVendorStoreId(servicesEntity.getVendorStoreId());
		servicesDto.setSubCategory(servicesEntity.getSubCategory());
		servicesDto.setServiceLine(servicesEntity.getServiceLine());
		servicesDto.setPrice(servicesEntity.getPrice());
		servicesDto.setCreatedTimestamp(LocalDateTime.now());
		servicesDto.setUpdatedTimestamp(LocalDateTime.now());
		
		return servicesDto;
	}
	
	@Override
    public List<ServicesCreateDTO> getServicesByVendorId(Integer vendorId) {
        List<ServicesEntity> servicesEntities = servicesDao.findByVendorId(vendorId);
        return servicesEntities.stream().map(this::getMapVendorToDto).collect(Collectors.toList());
    }

    private ServicesCreateDTO getMapVendorToDto(ServicesEntity servicesEntity) {
        ServicesCreateDTO servicesDto = new ServicesCreateDTO();
        
        servicesDto.setId(servicesEntity.getId());
        servicesDto.setVendorId(servicesEntity.getVendorId());
        servicesDto.setNameOfVendor(servicesEntity.getNameOfVendor());
        servicesDto.setCategory(servicesEntity.getCategory());
        servicesDto.setVendorStoreId(servicesEntity.getVendorStoreId());
        servicesDto.setSubCategory(servicesEntity.getSubCategory());
        servicesDto.setServiceLine(servicesEntity.getServiceLine());
        servicesDto.setPrice(servicesEntity.getPrice());
        servicesDto.setCreatedTimestamp(servicesEntity.getCreatedTimestamp());
        servicesDto.setUpdatedTimestamp(servicesEntity.getUpdatedTimestamp());
        
        return servicesDto;
    }
    
    @Override
    public void deleteVendorById(Integer id) {
    	ServicesEntity servicesEntities = servicesDao.findById(id).orElseThrow(() -> new VendorNotFoundException("Vendor not found with id: " + id));
    	servicesDao.delete(servicesEntities);
        System.out.println("Vendor with id " + id + " has been successfully deleted");
    }
    
    
    @Override
    public Page<ServicesCreateDTO> searchServices(SearchCriteria searchCriteria, Pageable pageable) {
        List<ServicesEntity> filteredServices = servicesDao.findAll().stream()
            .filter(service -> serviceMatchesCriteria(service, searchCriteria.getServices()))
            .collect(Collectors.toList());

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), filteredServices.size());
        List<ServicesCreateDTO> paginatedList = filteredServices.subList(start, end).stream()
            .map(service -> convertToDto(service))
            .collect(Collectors.toList());

        return new PageImpl<>(paginatedList, pageable, filteredServices.size());
    }

    private boolean serviceMatchesCriteria(ServicesEntity service, List<ServicesDTO> services) {
		return true;
	}

    private ServicesCreateDTO convertToDto(ServicesEntity servicesEntity) {
        ServicesCreateDTO servicesDto = new ServicesCreateDTO();
        
        servicesDto.setId(servicesEntity.getId());
        servicesDto.setVendorId(servicesEntity.getVendorId());
        servicesDto.setNameOfVendor(servicesEntity.getNameOfVendor());
        servicesDto.setCategory(servicesEntity.getCategory());
        servicesDto.setVendorStoreId(servicesEntity.getVendorStoreId());
        servicesDto.setSubCategory(servicesEntity.getSubCategory());
        servicesDto.setServiceLine(servicesEntity.getServiceLine());
        servicesDto.setPrice(servicesEntity.getPrice());
        servicesDto.setCreatedTimestamp(servicesEntity.getCreatedTimestamp());
        servicesDto.setUpdatedTimestamp(servicesEntity.getUpdatedTimestamp());
        
        return servicesDto;
    }
    
    @Override
	public RegisterVendorMobileDTO registerVendorMobile(RegisterVendorMobileDTO dto) {
		RegisterVendorMobileDTO vendorMap = new RegisterVendorMobileDTO();
		if(dto != null) {
//			AwsSNSClient awsSNSClientVendor = new AwsSNSClient();
				Boolean success = awsSNSClientVendor.subscribeMobile(dto.getMobileNumber());
				if(success) {
					Random random = new Random();
					Integer otp = random.nextInt(9000) + 1000;
					String message = otp + " is your OTP to validate your number with Deilify. Use this to login to your account and experience the new world of Laundry. Team Deilify";
					awsSNSClientVendor.publishMessageToSNSTopic(message, dto.getMobileNumber());
					
//					Insert the Moble and Otp to verify client
					OtpEntity otpEntity = otpEntityDao.getEntryByMobile(dto.getMobileNumber());
					if(otpEntity == null) {
						OtpEntity newOtpEntity = new OtpEntity();
						newOtpEntity.setMobileNumber(dto.getMobileNumber());
						newOtpEntity.setOtp(otp.toString());
						newOtpEntity.setStatus("True");
						newOtpEntity.setCreatedTimeStamp(LocalDateTime.now());
						otpEntityDao.save(newOtpEntity);
					}
					
					vendorMap = mapEntityToRegisterMobileDto(dto, otp);
				}
			}
		return vendorMap;
	}
    
    private RegisterVendorMobileDTO mapEntityToRegisterMobileDto(RegisterVendorMobileDTO dto, Integer otp) {
		// TODO Auto-generated method stub
		RegisterVendorMobileDTO vendorMap = new RegisterVendorMobileDTO();
		vendorMap.setMobileNumber(dto.getMobileNumber());
		vendorMap.setOtp(otp.toString());
		vendorMap.setMessage("Success");
		return vendorMap;
	}
    
    @Override
	public RegisterVendorMobileDTO verifyOtp(RegisterVendorMobileDTO dto) {
		
		if(StringUtils.isBlank(dto.getOtp())) {
			throw new AbortedException("Otp Cannot be blank");
		}
		RegisterVendorMobileDTO vendorDto = new RegisterVendorMobileDTO();
		if(!dto.getMobileNumber().isEmpty()) {
			
			OtpEntity otpEntity = otpEntityDao.getEntryByMobile(dto.getMobileNumber());
			if(otpEntity != null) {
				if(dto.getOtp().equalsIgnoreCase(otpEntity.getOtp())) {
					VendorEntity getVendor = vendorDao.findByVendorPhoneNumber(dto.getMobileNumber());
					if(getVendor == null) {
						VendorEntity getVendorNewEntity = new VendorEntity();
						getVendorNewEntity.setPhoneNumber(dto.getMobileNumber());
						VendorEntity entity = vendorDao.save(getVendorNewEntity);
						vendorDto = mapEntityToVendor(entity);
					} else {
						vendorDto = mapEntityToVendor(getVendor);
					}
					otpEntityDao.delete(otpEntity);
				} else {
					throw new InvalidOtpFoundException("Invalid otp found");
				}
				
			}
		}
		return vendorDto;
	}
    
    private RegisterVendorMobileDTO mapEntityToVendor(VendorEntity entity) {
		// TODO Auto-generated method stub
		RegisterVendorMobileDTO vendorDto = new RegisterVendorMobileDTO();
		if(entity != null) {
			vendorDto.setMessage("Success");
			vendorDto.setMobileNumber(entity.getPhoneNumber());
			vendorDto.setVendorId(entity.getId().toString());
		}
		return vendorDto;
	}
}
