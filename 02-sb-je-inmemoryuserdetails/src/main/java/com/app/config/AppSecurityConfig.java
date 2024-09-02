package com.app.config;

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
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

	@Bean
	UserDetailsService getUserDetailsService() {
		UserDetails adminUser = User.withUsername("krishna").password(passwordEncoder().encode("Admin@123"))
				.roles("ADMIN").build();
		UserDetails normalUser = User.withUsername("rahul").password(passwordEncoder().encode("Rahul@123")).roles("USER")
				.build();

		return new InMemoryUserDetailsManager(adminUser, normalUser);
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
		http.authorizeHttpRequests(request -> request
				.requestMatchers("app/v1/admin").hasAnyRole("ADMIN")
				.requestMatchers("app/v1/normal").hasAnyRole("USER")
				.requestMatchers("app/v1/public").permitAll()).httpBasic(Customizer.withDefaults())
				.formLogin(Customizer.withDefaults());

		return http.build();
	}
}
