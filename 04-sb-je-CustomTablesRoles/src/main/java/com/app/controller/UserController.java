package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.UserRequest;
import com.app.dtos.UserResponse;
import com.app.services.impl.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/users")
@Slf4j
public class UserController {

	@Autowired
	private UserServiceImpl  userService;
	
	@PostMapping
	public UserResponse saveUser(@RequestBody UserRequest request) {
		log.info("UserController :: saveUser :: UserRequest: ", request.getUsername(), request.getRoles());
		return userService.createUser(request);
	}
}
