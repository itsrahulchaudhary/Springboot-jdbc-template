package com.jdbc.template.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc.template.api.entity.User;
import com.jdbc.template.api.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return userRepository.saveUser(user);
	}
	
	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		return userRepository.updateUser(user);
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return userRepository.findUserById(id);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.getAllUsers();
	}

	@DeleteMapping("/user/{id}")
	String deleteUser(@PathVariable("id") int id) {
		return userRepository.deleteUserById(id);	
	}
}
