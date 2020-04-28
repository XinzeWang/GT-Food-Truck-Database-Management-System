package com.database.foodtruck.dao;

import com.database.foodtruck.vo.StaffNameQuery;

import java.util.List;

/*query 20a*/
public interface AvailableStaffNameQueryDAO {
    List<StaffNameQuery> viewFoodTruckAvailableStaff(String managerUserName, String foodTruckName);

}
