package com.database.foodtruck.service;

import com.database.foodtruck.entity.Building;
import com.database.foodtruck.vo.AvailableBuildingQuery;
import com.database.foodtruck.vo.ViewTagQuery;

import java.util.List;
import java.util.Optional;

public interface BuildingService {
	/*query 7*/
	void createBuilding(String buildingName, String description);

	/*query 4*/
	void deleteByBuildingName(String buildingName);

	/*query 6a*/
	void addBuildingTag(String buildingName, String tag);

	/*query 6b*/
	void removeBuildingTag(String buildingName, String tag);

	/*query 9*/
	void updateBuilding(String oldBuildingName, String newBuildingName, String description);

	/*query 8a*/
	Building findByBuildingName(String buildingName);

	/*query 8b*/
	List<ViewTagQuery> viewBuildingTag(String buildingName);

	/*query 10*/
	List<AvailableBuildingQuery> findAvailableBuilding();

	/*find all buildings*/
	List<Building> findAll();
}

