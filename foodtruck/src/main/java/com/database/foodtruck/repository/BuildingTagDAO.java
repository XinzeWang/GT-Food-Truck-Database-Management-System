package com.database.foodtruck.repository;

import com.database.foodtruck.vo.ViewTagQuery;

import java.util.List;

public interface BuildingTagDAO {
    /*query 6a*/
    void addBuildingTag(String buildingName, String tag);

    /*query 6b*/
    void removeBuildingTag(String buildingName, String tag);

    /*query 8b*/
    List<ViewTagQuery> viewBuildingTag(String buildingName);
}
