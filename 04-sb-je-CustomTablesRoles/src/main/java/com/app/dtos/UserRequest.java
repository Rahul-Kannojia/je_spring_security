package com.app.dtos;

import java.util.Set;

import com.app.entities.UserRoles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserRequest {

	private Long id;
	private String username;
	private String password;
	private Set<UserRoles> roles;
}
