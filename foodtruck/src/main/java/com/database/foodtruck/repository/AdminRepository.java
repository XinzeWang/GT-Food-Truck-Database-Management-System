package com.database.foodtruck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.database.foodtruck.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
	Admin findByUserName(String userName);
}
