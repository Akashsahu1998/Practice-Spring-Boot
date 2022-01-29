package com.akash.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.akash.app.dto.UserDTO;

public interface UserService extends UserDetailsService {
	UserDTO createUser(UserDTO userDto);
}
