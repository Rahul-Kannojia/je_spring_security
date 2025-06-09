package com.app.service;

import com.app.dto.UserRequest;
import com.app.dto.UserResponse;

public interface UserService {

	UserResponse saveUser(UserRequest userRequest);

}
