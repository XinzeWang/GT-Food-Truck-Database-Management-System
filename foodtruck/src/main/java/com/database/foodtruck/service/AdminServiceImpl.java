package com.database.foodtruck.service;

import com.database.foodtruck.dao.AdminBSQueryDAO;
import com.database.foodtruck.entity.Admin;
import com.database.foodtruck.repository.AdminRepository;
import com.database.foodtruck.vo.AdminBSQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminBSQueryDAO adminBSQueryDAO;

    @Override
    public Admin checkAdminExist(String username) {
        return adminRepository.findByUserName(username);
    }

    /*query 3*/
    @Override
    public List<AdminBSQuery> filterBS(String buildingName, String buildingTag, String stationName, Integer minCapacity, Integer maxCapacity) {
        return adminBSQueryDAO.filterBS(buildingName, buildingTag, stationName, minCapacity, maxCapacity);
    }
}
