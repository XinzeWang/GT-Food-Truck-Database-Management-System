package com.database.foodtruck.dao;

import com.database.foodtruck.vo.FoodTruckSummary;

import java.util.Date;
import java.util.List;

/*query 24*/
public interface FoodTruckSummaryDAO {
    List<FoodTruckSummary> filterSummary(String managerUserName, String foodTruckName,
                                         String stationName, Date minDate,
                                         Date maxDate, String sortedBy,
                                         String sortedDirection);
}
