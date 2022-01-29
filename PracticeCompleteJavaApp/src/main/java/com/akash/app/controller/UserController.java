package com.akash.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/") // http://localhost:8080/user
public class UserController {

	@PostMapping("create")
	public String createUser() {
		return "user created";
	}
}
