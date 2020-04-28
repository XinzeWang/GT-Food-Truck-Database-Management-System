package com.database.foodtruck.service;

import java.util.List;

import com.database.foodtruck.entity.User;

public interface UserService {
	User checkUser(String username, String password);
	User checkUserExist(String username);
	User saveUser(String username, String password, String firstName, String lastName);
	void delete(String username);


//	public List<User> findAll();
//
//	public User findByUserName(String theUserName);
//
//	public void save(User theEmployee);
//
//	public void deleteByUserName(String theUserName);
	
}
