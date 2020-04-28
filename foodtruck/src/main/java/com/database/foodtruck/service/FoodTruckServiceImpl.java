package com.database.foodtruck.service;

import com.database.foodtruck.repository.FoodTruckDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FoodTruckServiceImpl implements FoodTruckService {
    private FoodTruckDAO foodTruckDAO;

    public FoodTruckServiceImpl(@Qualifier("foodTruckDAOImpl") FoodTruckDAO foodTruckDAO) {
        this.foodTruckDAO = foodTruckDAO;
    }

    @Override
    public void deleteFoodTruck(String foodTruckName) {
        foodTruckDAO.deleteFoodTruck(foodTruckName);
    }

    @Override
    public void createFTAddStation(String foodTruckName, String stationName, String managerUserName) {
        foodTruckDAO.createFTAddStation(foodTruckName, stationName, managerUserName);
    }

    @Override
    public void createFTAddStaff(String foodTruckName, String staffName) {
        foodTruckDAO.createFTAddStaff(foodTruckName, staffName);
    }

    @Override
    public void createFTAddMenuItem(String foodTruckName, Double price, String foodName) {
        foodTruckDAO.createFTAddMenuItem(foodTruckName, price, foodName);
    }

    @Override
    public void updateFTStation(String foodTruckName, String stationName) {
        foodTruckDAO.updateFTStation(foodTruckName, stationName);
    }

    @Override
    public void updateFTStaff(String foodTruckName, String staffName) {
        foodTruckDAO.updateFTStaff(foodTruckName, staffName);
    }

    @Override
    public void updateFTMenuItem(String foodTruckName, Double price, String foodName) {
        foodTruckDAO.updateFTMenuItem(foodTruckName, price, foodName);
    }
}
