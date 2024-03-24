package com.main.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.User;
import com.main.request.model.UserRequest;
import com.main.service.UserServiceImpl;

@RestController
public class UserController {

	private UserServiceImpl userServiceImpl;
	
	public UserController(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
	@PostMapping("/user")
	public ResponseEntity<String> sameUser(@RequestBody UserRequest userRequest) {
		String responseMessage = userServiceImpl.createUser(userRequest);
		return new ResponseEntity<String>(responseMessage, HttpStatus.CREATED);
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUsers = userServiceImpl.getAllUsers();
		return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(
			@PathVariable(name = "id") Integer id
			) {
		User user = userServiceImpl.getUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
