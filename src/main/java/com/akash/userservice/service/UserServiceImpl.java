package com.akash.userservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.userservice.Exceptions.UserNotFound;
import com.akash.userservice.entity.User;
import com.akash.userservice.repository.UserRepository;


@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		String userId =  UUID.randomUUID().toString();
		user.setUserId(userId);
		return userRepository.save(user);
	}

	@Override
	public User getUser(String userId) {
		return userRepository.findById(userId).orElseThrow(()-> new UserNotFound("No User Found With given Id : "+userId));
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	
	
}
