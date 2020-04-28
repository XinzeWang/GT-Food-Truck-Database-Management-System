package com.database.foodtruck.dao;

import com.database.foodtruck.vo.ManagerFoodTruckQuery;

import java.util.List;

/* query 17 */
public interface ManagerFoodTruckQueryDAO {
    List<ManagerFoodTruckQuery> filterFoodTruck(String managerUserName, String foodTruckName,
                                                String stationName, Integer minStaffCount,
                                                Integer maxStaffCount, Boolean hasRemainingCapacity);
}
