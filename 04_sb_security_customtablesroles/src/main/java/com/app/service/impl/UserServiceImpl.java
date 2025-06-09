package com.app.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dto.UserRequest;
import com.app.dto.UserResponse;
import com.app.entity.UserInfo;
import com.app.repository.UserRepository;
import com.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserResponse saveUser(UserRequest userRequest) {

		UserInfo userInfo = new UserInfo();
		
		// converting UserRequest to UserInfo
		BeanUtils.copyProperties(userRequest, userInfo);

		// Encoding the password
		userInfo.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		
		// Saving UserInfo to Database
		userRepository.save(userInfo);
		
		//Converting UserInfo to UserResponse
		UserResponse userResponse = new UserResponse();
		BeanUtils.copyProperties(userInfo,userResponse);
		
		return userResponse;
	}

}
