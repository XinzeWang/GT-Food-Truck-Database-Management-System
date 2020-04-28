package com.database.foodtruck.repository;

import com.database.foodtruck.entity.Staff;
import com.database.foodtruck.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, String> {
    Staff findByUserName(String username);
    List<Staff> findAll();
}
