package com.database.foodtruck.service;

import com.database.foodtruck.entity.Customer;
import com.database.foodtruck.vo.CusCurrentInformationBasic;
import com.database.foodtruck.vo.CusCurrentInformationFT;
import com.database.foodtruck.vo.CustomerExploreQuery;
import com.database.foodtruck.vo.FoodTruckMenuQuery;

import java.util.Date;
import java.util.List;

public interface CustomerService {
    Customer saveCustomer(String username, double balance);
    Customer checkCustomerExist(String username);
    void delete(String username);

    /*query 21*/
    List<FoodTruckMenuQuery> viewFoodTruckMenu(String foodTruckName);

    /*query 26*/
    List<CustomerExploreQuery> filterExplore(String buildingName, String stationName,
                                             String buildingTag, String foodTruckName,
                                             String foodName);

    /*query 28*/
    CusCurrentInformationBasic findCusInfoBasic(String customerUserName);

    /*query 29*/
    List<CusCurrentInformationFT> findCusInfoFT(String customerUserName);

    /*query 27*/
    void selectLocation(String customerUserName, String stationName);

    /*query 30*/
    void createOder(Date date, String customerUserName);

    /*query 31*/
    void addItemToOrder(String foodTruckName, String foodName, Integer purchaseQuantity);
}



