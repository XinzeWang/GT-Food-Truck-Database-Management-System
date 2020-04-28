package com.database.foodtruck.dao;

import com.database.foodtruck.vo.AvailableBuildingQuery;

import java.util.List;

/* query 10*/
public interface AvailableBuildingQueryDAO {
    List<AvailableBuildingQuery> findAvailableBuilding();
}