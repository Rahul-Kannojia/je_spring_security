package com.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.app.security.helper.CustomUserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

	// @Autowired
	// private DataSource dataSource;

	@Bean
	SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf(obj -> obj.disable())
				.authorizeHttpRequests(request -> request.requestMatchers("app/v1/normal").hasRole("USER")
						.requestMatchers("app/v1/admin").hasAnyRole("ADMIN", "SUPER_ADMIN")
						.requestMatchers("app/v1/public", "app/v1/users").permitAll())
				.formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());

		return httpSecurity.build();
	}

	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

	@Bean
	AuthenticationProvider authenticationProvider() {
		/**
		 * The new, preferred way is to first create the object by providing a
		 * UserDetailsService in its constructor, and then, as a separate step, use the
		 * setPasswordEncoder() method on the created object to set the PasswordEncoder.
		 */
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsService());
		// authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Bean
	UserDetailsService userDetailsService() {
		return new CustomUserDetailsServiceImpl();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * If we write pattern like "app/v1/*" then username : user or admin password:
	 * user123 or admin123
	 * 
	 * both will work
	 */
//	@Bean
//	SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.authorizeHttpRequests(request -> request.requestMatchers("app/v1/*").hasAnyRole("USER","ADMIN")
//				.requestMatchers("app/v1/public").permitAll())		
//		.formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());
//		
//		return httpSecurity.build();
//	}

}
