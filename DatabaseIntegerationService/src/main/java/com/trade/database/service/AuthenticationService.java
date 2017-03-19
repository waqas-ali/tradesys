package com.trade.database.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trade.database.pojo.User;

@RestController
@RequestMapping("/auth")
public class AuthenticationService {
	@RequestMapping("/login")
	public User login() {
		User user = new User();
		return user;
	}
}
