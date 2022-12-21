package com.ktp.repository;

import com.ktp.model.User;

public interface IUserRepository {

		public User login(User user);
		
		public User insertLogin(User user);
}
