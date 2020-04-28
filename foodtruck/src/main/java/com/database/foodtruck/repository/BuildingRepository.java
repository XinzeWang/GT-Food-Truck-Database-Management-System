package com.database.foodtruck.repository;

import com.database.foodtruck.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingRepository extends JpaRepository<Building, String> {
    /*find building by name*/
    Building findByBuildingName(String buildingName);

    /*find all buildings*/
    List<Building> findAll();
}
