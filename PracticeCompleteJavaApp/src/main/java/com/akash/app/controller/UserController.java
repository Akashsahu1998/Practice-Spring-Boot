package com.akash.app.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash.app.dto.UserDTO;
import com.akash.app.request.UserDetailsRequestModel;
import com.akash.app.response.UserResponse;
import com.akash.app.service.UserService;

@RestController
@RequestMapping("user/") // http://localhost:8080/user
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("create")
	public UserResponse createUser(@RequestBody UserDetailsRequestModel userDetails) {
		UserResponse userResponse = new UserResponse();

		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(userDetails, userDTO);

		UserDTO createdUserDTO = userService.createUser(userDTO);
		BeanUtils.copyProperties(createdUserDTO, userResponse);

		return userResponse;
	}

	@GetMapping("getuser")
	public String getUser() {
		return "get user";
	}

}
