package com.database.foodtruck.repository;

import com.database.foodtruck.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, String> {
    Manager findByUserName(String username);
}
