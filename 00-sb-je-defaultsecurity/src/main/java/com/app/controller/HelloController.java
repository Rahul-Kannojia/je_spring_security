package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app/v1/")
public class HelloController {

	/**
	 * URLs: http://localhost:9091/app/v1/public (ALL- No Authentication)
	 * 		 http://localhost:9091/app/v1/normal (USER -Authentication requires)
	 *       http://localhost:9091/app/v1/admin (ADMIN- Authentication & Authorization both requires )
	 * */
	@GetMapping("public")
	public String getHello() {
		return "I am Public User";
	}
	
	@GetMapping("normal")
	public String getHello_1() {
		return "I am Normal User";
	}
	
	@GetMapping("admin")
	public String getHello_2() {
		return "I am Admin User";
	}
}
