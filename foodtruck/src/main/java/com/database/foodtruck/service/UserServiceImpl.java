package com.database.foodtruck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.foodtruck.repository.UserRepository;
import com.database.foodtruck.entity.User;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository theEmployeeRepository) {
		userRepository = theEmployeeRepository;
	}

	@Override
	public User checkUser(String username, String password) {
		User user = userRepository.findByUserNameAndPassword(username, password);
		return user;
	}

	@Override
	public User checkUserExist(String username) {
		User user = userRepository.findByUserName(username);
		return user;
	}

	@Transactional
	@Override
	public User saveUser(String username, String firstName, String lastName, String password) {
		User user = new User(username, firstName, lastName, password);
//		user.setFirstName(firstName);
//		user.setLastName(lastName);
//		user.setUserName(username);
//		user.setPassword(password);
		return userRepository.saveAndFlush(user);
	}

	@Transactional
	@Override
	public void delete(String username) {
		userRepository.deleteByUserName(username);
	}



}






