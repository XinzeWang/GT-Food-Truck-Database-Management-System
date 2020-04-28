package com.database.foodtruck.service;

import com.database.foodtruck.dao.AdminFilterFoodQueryDAO;
import com.database.foodtruck.entity.Food;
import com.database.foodtruck.repository.FoodDAO;
import com.database.foodtruck.vo.AdminFilterFoodQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    FoodDAO foodDAO;
    AdminFilterFoodQueryDAO adminFilterFoodQueryDAO;

    @Autowired
    public FoodServiceImpl(@Qualifier("adminFilterFoodQueryDAOImpl") AdminFilterFoodQueryDAO adminFilterFoodQueryDAO,
                           @Qualifier("foodDAOImpl") FoodDAO foodDAO) {
        this.foodDAO = foodDAO;
        this.adminFilterFoodQueryDAO = adminFilterFoodQueryDAO;
    }

    @Override
    public List<AdminFilterFoodQuery> filterFood(String foodName, String sortedBy, String sortDirection) {
        return adminFilterFoodQueryDAO.filterFood(foodName, sortedBy, sortDirection);
    }

    @Override
    public void deleteFood(String foodName) {
        foodDAO.deleteFood(foodName);
    }

    @Override
    public void createFood(String foodName) {
        foodDAO.createFood(foodName);
    }

    @Override
    public List<Food> findAllFood() {
        return foodDAO.findAllFood();
    }
}
