package com.database.foodtruck.repository;

import com.database.foodtruck.entity.Food;

import java.util.List;

public interface FoodDAO {
    /*query 15*/
    void deleteFood(String foodName);

    /*query 16*/
    void createFood(String foodName);

    /*find all food*/
    List<Food> findAllFood();
}
