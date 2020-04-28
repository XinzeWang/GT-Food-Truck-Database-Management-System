package com.database.foodtruck.dao;

import com.database.foodtruck.vo.CustomerExploreQuery;

import java.util.List;

/*query 26*/
public interface CustomerExploreQueryDAO {
    List<CustomerExploreQuery> filterExplore(String buildingName, String stationName,
                                             String buildingTag, String foodTruckName,
                                             String foodName);
}
