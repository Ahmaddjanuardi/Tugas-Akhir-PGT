package com.ktp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktp.model.User;
import com.ktp.repository.IUserRepository;
import com.ktp.service.IUserService;

@Service
public class UserService implements IUserService{

	@Autowired
	IUserRepository userRepository;
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userRepository.login(user);
	}
	@Override
	public User insertUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.insertLogin(user);
	}

}
