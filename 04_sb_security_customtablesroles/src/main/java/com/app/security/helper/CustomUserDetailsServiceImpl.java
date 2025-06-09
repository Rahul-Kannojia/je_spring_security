package com.app.security.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.app.entity.UserInfo;
import com.app.repository.UserRepository;

@Component
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo dbUserInfo = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Username not found"));

		return new CustomerUserDetails(dbUserInfo);
	}

}
