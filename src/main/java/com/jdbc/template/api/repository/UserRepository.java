package com.jdbc.template.api.repository;

import java.util.List;

import com.jdbc.template.api.entity.User;

public interface UserRepository {

	User saveUser(User user);
	User updateUser(User user);
	User findUserById(int id);
	User deleteUserById(int id);
	List<User> getAllUsers();
	
}
