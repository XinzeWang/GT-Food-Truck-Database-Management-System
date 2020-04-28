package com.database.foodtruck.dao;

import com.database.foodtruck.vo.AdminFilterFoodQuery;

import java.util.List;

/* query 14*/
public interface AdminFilterFoodQueryDAO {
    List<AdminFilterFoodQuery> filterFood(String foodName, String sortedBy, String sortDirection);
}
