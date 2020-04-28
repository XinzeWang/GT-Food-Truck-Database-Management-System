package com.database.foodtruck.repository;

import com.database.foodtruck.entity.Building;
import com.database.foodtruck.vo.ViewBuildingQuery;

public interface BuildingDAO {

    /*query 8a*/
    Building findByBuildingName(String buildingName);

    /*query 7*/
    void createBuilding(String buildingName, String description);

    /*query 4*/
    void deleteByBuildingName(String buildingName);

    /*query 9*/
    void updateBuilding(String oldBuildingName, String newBuildingName, String description);
}
