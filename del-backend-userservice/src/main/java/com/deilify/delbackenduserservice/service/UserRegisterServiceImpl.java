package com.deilify.delbackenduserservice.service;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.deilify.delbackenduserservice.dao.UserCreateDao;
import com.deilify.delbackenduserservice.dto.RegisterMobileDTO;
import com.deilify.delbackenduserservice.dto.SampleKafkaDto;
import com.deilify.delbackenduserservice.dto.UserCreateDTO;
import com.deilify.delbackenduserservice.dto.UserDTO;
import com.deilify.delbackenduserservice.entity.UserEntity;
import com.deilify.delbackenduserservice.kafka.UserKafkaProducer;
import com.deilify.delbackenduserservice.util.AwsSNSClient;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

	@Autowired
	UserCreateDao userCreateDao;
	
//	@Autowired
//	UserKafkaProducer userKafkaProducer;
//	
//	@Autowired
//	AwsSNSClient awsSNSClient;

	public UserCreateDTO createUser(UserDTO user) {
		if (user.getUsername() != null) {
			UserEntity userCreateDTO = userCreateDao.findByUserName(user.getPhone());
			if (userCreateDTO == null) {
				UserEntity userEntity = new UserEntity();
				userEntity.setUsername(user.getUsername());
				userEntity.setFirstName(user.getFirstName());
				userEntity.setLastName(user.getLastName());
				userEntity.setMobileNumber(user.getPhone());
				userEntity.setPassword(user.getPassword());
				userEntity.setCreatedTimestamp(LocalDate.now());
				userEntity.setUpdatedTimestamp(LocalDate.now());
				userEntity.setModifiedBy("System");

				userCreateDao.save(userEntity);
				SampleKafkaDto sampleKafkaDto = new SampleKafkaDto();
				sampleKafkaDto.setName("Rajojyoti");
				sampleKafkaDto.setMobileNumber("8013341617");
				sampleKafkaDto.setEmailAddress("rajojyoti87@gmail.com");
				
				UserKafkaProducer userKafkaProducer = new UserKafkaProducer();
				userKafkaProducer.messageBuilder(sampleKafkaDto);
				System.out.println("User has been successfully registered");
				return mapUserToDto(user);
			} else {
				System.out.println("UserId is already present");
			}
		}
		System.out.println("UserId is already present");
		return null;
	}

	private UserCreateDTO mapUserToDto(UserDTO user) {
		UserEntity newUser = userCreateDao.findByUserName(user.getUsername());
		UserCreateDTO myNewUser = new UserCreateDTO();

		if (newUser.getUsername() != null) {
			if (newUser.getUserId() != null) {
				myNewUser.setUserId(newUser.getUserId().toString());
			}
			if (user.getUsername() != null) {
				myNewUser.setUsername(user.getUsername());
			}
			if (user.getPassword() != null) {
				myNewUser.setPassword(user.getPassword());
			}
			if (user.getFirstName() != null) {
				myNewUser.setFirstName(user.getFirstName());
			}
			if (user.getLastName() != null) {
				myNewUser.setLastName(user.getLastName());
			}
			if (user.getPhone() != null) {
				myNewUser.setPhone(user.getPhone());
			}

			myNewUser.setModified_By("System");
			myNewUser.setCreatedTimestamp(LocalDate.now());
			myNewUser.setUpdatedTimestamp(LocalDate.now());
		}

		return myNewUser;
	}

	@Override
	public UserCreateDTO updateUser(UserDTO user) {
		
		
		if (user.getUsername() != null) {
			UserEntity userUpdateDTO = userCreateDao.findByUserName(user.getUsername());
			
			if(userUpdateDTO != null) {
				if(!isBlankNullEmpty(user.getFirstName())) {
					userUpdateDTO.setFirstName(user.getFirstName());
				}
				if(!isBlankNullEmpty(user.getLastName())) {
					userUpdateDTO.setFirstName(user.getLastName());
				}
				if(!isBlankNullEmpty(user.getLastName())) {
					userUpdateDTO.setLastName(user.getLastName());
				}
				if(!isBlankNullEmpty(user.getPhone())) {
					userUpdateDTO.setMobileNumber(user.getPhone());
				}
				if(!isBlankNullEmpty(user.getPhone())) {
					userUpdateDTO.setMobileNumber(user.getPhone());
				}
				if(!isBlankNullEmpty(user.getPassword())) {
					userUpdateDTO.setPassword(user.getPassword());
				}
				userUpdateDTO.setUpdatedTimestamp(LocalDate.now());
				userUpdateDTO.setModifiedBy("System");
				userCreateDao.save(userUpdateDTO);
				
			}
		}
		return mapUserToDto(user);
	}
	
	private boolean isBlankNullEmpty(String parameter) {
		boolean isEmpty = false;
		if(parameter.isBlank() || parameter.isEmpty() || parameter == null) {
			isEmpty = true;
		}
		return isEmpty;
	}
	
	@Override
	public RegisterMobileDTO registerMobile(RegisterMobileDTO dto) {
		if(dto != null) {
			UserEntity getUser = userCreateDao.findByUserName(dto.getMobileNumber());
			if(getUser == null) {
				UserEntity entity = new UserEntity();
				if(!isBlankNullEmpty(dto.getMobileNumber())) {
					entity.setMobileNumber(dto.getMobileNumber());
				}
				userCreateDao.save(entity);
				AwsSNSClient awsSNSClient = new AwsSNSClient();
				Boolean success = awsSNSClient.subscribeMobile(dto.getMobileNumber());
				if(success) {
					Random random = new Random();
					String id = String.format("%04d", random.nextInt(10000));
					Integer otp = Integer.valueOf(id);
					String message = "Otp for to Login to Deilify " + dto.getMobileNumber() + " is " + otp;
					awsSNSClient.publishMessageToSNSTopic(message, dto.getMobileNumber());
				}
			}
		}
		return null;
	}

}
