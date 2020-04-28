package com.database.foodtruck.service;

import com.database.foodtruck.entity.Staff;

import java.util.List;

public interface StaffService {
    Staff checkStaffExist(String username);

    Staff findByUserName(String username);

    /*find all users*/
    List<Staff> findAll();
}
