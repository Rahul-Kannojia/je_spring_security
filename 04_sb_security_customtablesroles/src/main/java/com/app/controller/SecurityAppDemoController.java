package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app/v1")
public class SecurityAppDemoController {
	
	@GetMapping("/public")
	public String publicUser() {
		return "This is a Public User";
	}
	@GetMapping("/normal")
	public String normalUser() {
		return "This is a  User";
	}
	@GetMapping("/admin")
	public String adminUser() {
		return "This is a Admin ";
	}

}
