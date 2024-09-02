package com.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

	@Autowired
	private DataSource dataSource;
	
	@Bean
	UserDetailsService getUserDetailsService() {
		return new JdbcUserDetailsManager(dataSource);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// authorize or request- any input parameter name we can give
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(authorize -> authorize.requestMatchers("app/v1/admin", "app/v1/normal")
//				.authenticated().requestMatchers("app/v1/public").permitAll()).httpBasic(Customizer.withDefaults())
//				.formLogin(Customizer.withDefaults());
//
//		return http.build();
//	}
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.csrf(t ->t.disable()) 
		.authorizeHttpRequests(request -> request
				.requestMatchers("app/v1/admin").hasAnyRole("ADMIN")
				.requestMatchers("app/v1/normal").hasAnyRole("USER")
				.requestMatchers("app/v1/public","api/v1/users").permitAll()
				)
		        .httpBasic(Customizer.withDefaults())
				.formLogin(Customizer.withDefaults());

		return http.build();
	}
}
