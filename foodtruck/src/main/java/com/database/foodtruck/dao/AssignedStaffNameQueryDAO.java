package com.database.foodtruck.dao;

import com.database.foodtruck.vo.StaffNameQuery;

import java.util.List;

/*query 20b*/
public interface AssignedStaffNameQueryDAO {
    List<StaffNameQuery> viewFoodTruckStaff(String foodTruckName);
}
