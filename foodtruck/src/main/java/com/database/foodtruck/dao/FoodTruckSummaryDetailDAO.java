package com.database.foodtruck.dao;

import com.database.foodtruck.vo.FoodTruckSummaryDetail;

import java.util.List;

/*query 25*/
public interface FoodTruckSummaryDetailDAO {
    List<FoodTruckSummaryDetail> viewSummaryDetail(String managerUserName, String foodTruckName);
}
