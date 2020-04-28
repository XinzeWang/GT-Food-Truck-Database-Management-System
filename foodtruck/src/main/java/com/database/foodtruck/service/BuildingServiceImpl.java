package com.database.foodtruck.service;

import com.database.foodtruck.dao.AvailableBuildingQueryDAO;
import com.database.foodtruck.repository.BuildingDAO;
import com.database.foodtruck.repository.BuildingRepository;
import com.database.foodtruck.repository.BuildingTagDAO;
import com.database.foodtruck.vo.AvailableBuildingQuery;
import com.database.foodtruck.vo.ViewTagQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.database.foodtruck.entity.Building;

import java.util.List;
import java.util.Optional;

@Service
public class BuildingServiceImpl implements BuildingService {

	private BuildingRepository buildingRepository;
	private AvailableBuildingQueryDAO availableBuildingQueryDAO;
	private BuildingDAO buildingDAO;
	private BuildingTagDAO buildingTagDAO;

	@Autowired
	public BuildingServiceImpl(BuildingRepository buildingRepository,
							   @Qualifier("availableBuildingQueryDAOImpl") AvailableBuildingQueryDAO availableBuildingQueryDAO,
							   @Qualifier("buildingDAOImpl") BuildingDAO buildingDAO,
							   @Qualifier("buildingTagDAOImpl") BuildingTagDAO buildingTagDAO) {
		this.buildingRepository = buildingRepository;
		this.availableBuildingQueryDAO = availableBuildingQueryDAO;
		this.buildingDAO = buildingDAO;
		this.buildingTagDAO = buildingTagDAO;
	}

	@Override
	public void createBuilding(String buildingName, String description) {
		buildingDAO.createBuilding(buildingName, description);
	}

	@Override
	public void deleteByBuildingName(String buildingName) {
		buildingDAO.deleteByBuildingName(buildingName);
	}

	@Override
	public void addBuildingTag(String buildingName, String tag) {
		buildingTagDAO.addBuildingTag(buildingName, tag);
	}

	@Override
	public void removeBuildingTag(String buildingName, String tag) {
		buildingTagDAO.removeBuildingTag(buildingName, tag);
	}

	@Override
	public void updateBuilding(String oldBuildingName, String newBuildingName, String description) {
		buildingDAO.updateBuilding(oldBuildingName, newBuildingName, description);
	}

	/*query 8a*/
	@Override
	public Building findByBuildingName(String buildingName) {
		return buildingDAO.findByBuildingName(buildingName);
	}

	/*query 8b*/
	@Override
	public List<ViewTagQuery> viewBuildingTag(String buildingName) {
		return buildingTagDAO.viewBuildingTag(buildingName);
	}

	/*query 10*/
	@Override
	public List<AvailableBuildingQuery> findAvailableBuilding() {
		return availableBuildingQueryDAO.findAvailableBuilding();
	}

	@Override
	public List<Building> findAll() {
		return buildingRepository.findAll();
	}

}
