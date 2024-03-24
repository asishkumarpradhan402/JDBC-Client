package com.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.main.dao.UserDAO;
import com.main.exception.UserNotExistsException;
import com.main.model.User;
import com.main.request.model.UserRequest;

@Service
public class UserServiceImpl {

	private UserDAO userDAO;
	
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public String createUser(UserRequest userRequest) {
		int saveUser = userDAO.saveUser(userRequest);
		if(saveUser != 0) {
			return "Created Successfully";
		} else {
			return "Not Created";
		}
	}
	
	public List<User> getAllUsers(){
		return userDAO.getAllUsers();
	}
	
	public User getUserById(Integer id){
		Optional<User> usersById = userDAO.getUsersById(id);
		if(usersById.isEmpty()) {
			throw new UserNotExistsException(id);
		} else {
			return usersById.get();
		}
	}
}
