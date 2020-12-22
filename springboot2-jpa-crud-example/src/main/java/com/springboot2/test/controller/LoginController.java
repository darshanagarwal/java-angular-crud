package com.springboot2.test.controller;

import java.util.HashMap;


import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot2.test.model.User;
import com.springboot2.test.service.AuthService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")
public class LoginController {
	
	@Autowired
	AuthService authService;

	@PostMapping("/login")
	public Map<String, Boolean> createProduct(@Valid @RequestBody User user) {
		Map<String, Boolean> response = new HashMap<>();
		response.put("login", authService.login(user));
		return response;
		
	}

	
}
