package com.app.security.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.entity.UserInfo;
import com.app.entity.UserRoles;

public class CustomerUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	private Collection<? extends GrantedAuthority> authority;

	public CustomerUserDetails(UserInfo userInfo) {
		this.username = userInfo.getUsername();
		this.password = userInfo.getPassword();
		List<GrantedAuthority> auths = new ArrayList<>();
		for (UserRoles role : userInfo.getRoles()) {
			auths.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
		}

		// Set<GrantedAuthority> auths =userInfo.getRoles().stream().map(role-> new
		// SimpleGrantedAuthority(role.getName().toUpperCase())).collect(Collectors.toSet());

		this.authority = auths;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authority;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

}
