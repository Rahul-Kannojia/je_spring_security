package com.app.services;

import com.app.dtos.UserRequest;
import com.app.dtos.UserResponse;

public interface UserService {

	UserResponse createUser(UserRequest userRequest);
}
