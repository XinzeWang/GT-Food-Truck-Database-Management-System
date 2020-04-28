package com.database.foodtruck.dao;

import com.database.foodtruck.entity.Admin;
import com.database.foodtruck.vo.AdminBSQuery;

import java.util.List;

/* for query3, Screen 4 Admin Manage
 Building & Station*/
public interface AdminBSQueryDAO {
    List<AdminBSQuery> filterBS(String buildingName, String buildingTag,
                   String stationName, Integer minCapacity, Integer maxCapacity);
}
