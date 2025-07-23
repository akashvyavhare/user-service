package com.akash.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akash.userservice.entity.User;

public interface UserRepository  extends JpaRepository<User, String>{

}
