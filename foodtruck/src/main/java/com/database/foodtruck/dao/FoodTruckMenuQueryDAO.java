package com.database.foodtruck.dao;

import com.database.foodtruck.vo.FoodTruckMenuQuery;

import java.util.List;

/* query 21*/
public interface FoodTruckMenuQueryDAO {
    List<FoodTruckMenuQuery> viewFoodTruckMenu(String foodTruckName);
}
