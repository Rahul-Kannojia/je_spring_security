package com.app.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dtos.UserRequest;
import com.app.dtos.UserResponse;
import com.app.entities.UserInfo;
import com.app.repository.UserInfoReposiroty;
import com.app.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserInfoReposiroty userInfoReposiroty;
	
	@Override
	public UserResponse createUser(UserRequest userRequest) {
		log.info("UserServiceImpl :: createUser :: UserRequest :", userRequest.getUsername());
		// UserRequest to UserInfo
		UserInfo userInfo = modelMapper.map(userRequest, UserInfo.class);
		//Encode the Password
		userInfo.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		// Save to Database & Convert UserInfo to UserResponse  
		return modelMapper.map(userInfoReposiroty.save(userInfo), UserResponse.class);
	}

}
