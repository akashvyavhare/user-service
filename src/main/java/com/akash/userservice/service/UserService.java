package com.akash.userservice.service;

import java.util.List;

import com.akash.userservice.entity.User;

public interface UserService {

	public User saveUser(User user);
	
	public User getUser(String userId);
	
	public List<User> getAllUsers();
	
}
