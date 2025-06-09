package com.app.dto;

import java.util.Set;

import com.app.entity.UserRoles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

	private Long id;
	private String username;
	private Set<UserRoles> roles;
}
