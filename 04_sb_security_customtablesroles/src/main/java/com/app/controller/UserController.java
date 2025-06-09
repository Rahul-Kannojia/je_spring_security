package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserRequest;
import com.app.dto.UserResponse;
import com.app.service.UserService;

@RestController
@RequestMapping("app/v1/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public UserResponse createUser(@RequestBody UserRequest userRequest) {
		return userService.saveUser(userRequest);
	}
	
}
