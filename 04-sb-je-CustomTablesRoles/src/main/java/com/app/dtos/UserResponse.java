package com.app.dtos;

import java.util.Set;

import com.app.entities.UserRoles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

	private Long id;
	private String username;
	private Set<UserRoles> roles;
}
