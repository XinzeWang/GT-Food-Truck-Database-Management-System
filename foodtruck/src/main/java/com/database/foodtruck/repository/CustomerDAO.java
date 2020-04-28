package com.database.foodtruck.repository;

import java.util.Date;

public interface CustomerDAO {
    /*query 27*/
    void selectLocation(String customerUserName, String stationName);

    /*query 30*/
    void createOder(Date date, String customerUserName);

    /*query 31*/
    void addItemToOrder(String foodTruckName, String foodName, Integer purchaseQuantity);
}
