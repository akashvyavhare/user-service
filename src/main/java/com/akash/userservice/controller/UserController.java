package com.akash.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash.userservice.entity.User;
import com.akash.userservice.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> saveUser( @RequestBody User user)
	{
		User savedUser = userService.saveUser(user);
		if(savedUser!=null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(savedUser);
		
	}
	
	@GetMapping("/{userID}")
	public ResponseEntity<User> getUser(@PathVariable String userID )
	{
		User user = userService.getUser(userID);
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUsers = userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(allUsers);
	}

}
