package com.database.foodtruck.service;

import com.database.foodtruck.entity.Staff;
import com.database.foodtruck.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    private StaffRepository staffRepository;

    @Autowired
    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public Staff checkStaffExist(String username) {
        return staffRepository.findByUserName(username);
    }

    @Override
    public Staff findByUserName(String username) {
        return staffRepository.findByUserName(username);
    }

    @Override
    public List<Staff> findAll() {
        return staffRepository.findAll();
    }
}
