package com.database.foodtruck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.database.foodtruck.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUserNameAndPassword(String username, String password);
    User findByUserName(String username);
    void deleteByUserName(String username);
	
}