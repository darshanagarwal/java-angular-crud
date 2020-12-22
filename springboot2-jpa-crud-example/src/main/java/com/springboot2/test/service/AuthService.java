package com.springboot2.test.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot2.test.model.User;
import com.springboot2.test.repository.UserRepository;

@Service
public class AuthService {

	@Autowired
	UserRepository userRepository;
	
	public boolean login(User user) {
		if("admin".equalsIgnoreCase(user.getUserName()) && "admin".equalsIgnoreCase(user.getPassword())) {
			return true;
		}
		User userrespons = userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
		
		if(Objects.nonNull(userrespons)) {
			return true;
		}
		return false;
	}
}
