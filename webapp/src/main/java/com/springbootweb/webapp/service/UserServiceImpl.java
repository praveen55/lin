package com.springbootweb.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootweb.webapp.model.User;
import com.springbootweb.webapp.repository.UserDAO;

@Service
public class UserServiceImpl {
@Autowired
	private UserDAO userDAO;
	//Login
	public User login(String username , String password, String role) {
		User user = userDAO.findByUsernameAndPasswordAndRole(username,password,role);
		return user;
	}
	//Registration
	public List<User> All(){
		return userDAO.findAll();
	}
	
	public void save(User user) {
		userDAO.save(user);
	}
	
	public User get(long id) {
		return userDAO.findById(id).get();
	}
	
	public void delete(long id) {
		userDAO.deleteById(id);
	}
}