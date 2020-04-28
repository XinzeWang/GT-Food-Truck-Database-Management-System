package com.database.foodtruck.service;

import com.database.foodtruck.entity.Manager;
import com.database.foodtruck.vo.*;

import java.util.Date;
import java.util.List;

public interface ManagerService {
    Manager checkManagerExist(String username);

    /*query 17*/
    List<ManagerFoodTruckQuery> filterFoodTruck(String managerUserName, String foodTruckName,
                                                String stationName, Integer minStaffCount,
                                                Integer maxStaffCount, Boolean hasRemainingCapacity);

    /*query 20a*/
    List<StaffNameQuery> viewFoodTruckAvailableStaff(String managerUserName, String foodTruckName);

    /*query 20b*/
    List<StaffNameQuery> viewFoodTruckStaff(String foodTruckName);

    /*query 23*/
    List<ManagerGetStation> mnGetStation(String managerUserName);

    /*query 24*/
    List<FoodTruckSummary> filterSummary(String managerUserName, String foodTruckName,
                                         String stationName, Date minDate,
                                         Date maxDate, String sortedBy,
                                         String sortedDirection);

    /*query 25*/
    List<FoodTruckSummaryDetail> viewSummaryDetail(String managerUserName, String foodTruckName);


}
