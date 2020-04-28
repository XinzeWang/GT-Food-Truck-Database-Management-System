package com.database.foodtruck.service;

public interface FoodTruckService {
    /*query 18*/
    void deleteFoodTruck(String foodTruckName);

    /*query 19a*/
    void createFTAddStation(String foodTruckName, String stationName, String managerUserName);

    /*query 19b*/
    void createFTAddStaff(String foodTruckName, String staffName);

    /*query 19c*/
    void createFTAddMenuItem(String foodTruckName, Double price, String foodName);

    /*query 22a*/
    void updateFTStation(String foodTruckName, String stationName);

    /*query 22b*/
    void updateFTStaff(String foodTruckName, String staffName);

    /*query 22c*/
    void updateFTMenuItem(String foodTruckName, Double price, String foodName);
}
