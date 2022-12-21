package com.ktp.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ktp.model.AnggotaKeluarga;
import com.ktp.model.User;
import com.ktp.repository.IUserRepository;

@Repository
public class UserRepository implements IUserRepository{

	@Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_user WHERE email = ? AND password = ?";
		var result = jdbcTemplate.queryForObject(query,new BeanPropertyRowMapper<>(User.class), new Object[] {user.getEmail(), user.getPassword()});
		return result;
	}

	@Override
	public User insertLogin(User user) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO tb_user (email, nama, password)VALUES(?,?,?)";
		jdbcTemplate.update(query, new Object[] {user.getEmail(), user.getNama(), user.getPassword()});
		return user;
	}
}
