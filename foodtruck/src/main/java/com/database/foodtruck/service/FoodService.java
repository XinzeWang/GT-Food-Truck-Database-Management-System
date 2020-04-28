package com.database.foodtruck.service;

import com.database.foodtruck.entity.Food;
import com.database.foodtruck.vo.AdminFilterFoodQuery;

import java.util.List;

public interface FoodService {
    /*qeury 14*/
    List<AdminFilterFoodQuery> filterFood(String foodName, String sortedBy, String sortDirection);

    /*query 15*/
    void deleteFood(String foodName);

    /*query 16*/
    void createFood(String foodName);

    /*find all food*/
    List<Food> findAllFood();
}
