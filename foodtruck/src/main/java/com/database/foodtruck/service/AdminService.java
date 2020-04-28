package com.database.foodtruck.service;

import com.database.foodtruck.entity.Admin;
import com.database.foodtruck.vo.AdminBSQuery;

import java.util.List;

public interface AdminService {
    Admin checkAdminExist(String username);

    /*query 3*/
    List<AdminBSQuery> filterBS(String buildingName, String buildingTag, String stationName, Integer minCapacity, Integer maxCapacity);

}
