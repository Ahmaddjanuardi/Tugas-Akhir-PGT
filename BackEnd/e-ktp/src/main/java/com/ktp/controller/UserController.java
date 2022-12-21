package com.ktp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktp.model.User;
import com.ktp.service.IUserService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/userLogin")
public class UserController {

	@Autowired
	IUserService userService;
	
	@PostMapping("/login")
	public User login(@RequestBody User user) {
		return userService.login(user);
	}
	
	@PostMapping("/register")
	public User insertUser(@RequestBody User user) {
		return userService.insertUser(user);
	}
}
