package com.ktp.service;

import com.ktp.model.User;

public interface IUserService {
	public User login(User user);
	
	public User insertUser(User user);

}
