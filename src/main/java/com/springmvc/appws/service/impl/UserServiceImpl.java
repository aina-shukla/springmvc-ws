package com.springmvc.appws.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.appws.entity.UserEntity;
import com.springmvc.appws.repository.UserRepository;
import com.springmvc.appws.service.UserService;
import com.springmvc.appws.shared.Utils;
import com.springmvc.appws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	Utils utils;
	
	@Override
	public UserDto createUser(UserDto user) {

		if (userRepo.findByEmail(user.getEmail()) != null)
			throw new RuntimeException("Email/record already exists");

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);

		String newUserId= utils.generateUserId(30);
		userEntity.setEncryptedPassword("k8ll9iih74");
		userEntity.setUserId(newUserId);

		UserEntity saveUserDetails = userRepo.save(userEntity);

		UserDto returnDto = new UserDto();
		BeanUtils.copyProperties(saveUserDetails, returnDto);

		return returnDto;
	}

}
