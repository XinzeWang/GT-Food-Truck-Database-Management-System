package com.database.foodtruck.vo;

import javax.persistence.*;

public class AdminBSQuery {
    private String buildingName;
    private String tag;
    private String stationName;
    private Integer capacity;
    private String foodTruckNames;

    public AdminBSQuery() {
    }

    public AdminBSQuery(String buildingName, String tag, String stationName, Integer capacity, String foodTruckNames) {
        this.buildingName = buildingName;
        this.tag = tag;
        this.stationName = stationName;
        this.capacity = capacity;
        this.foodTruckNames = foodTruckNames;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getFoodTruckNames() {
        return foodTruckNames;
    }

    public void setFoodTruckNames(String foodTruckNames) {
        this.foodTruckNames = foodTruckNames;
    }
}
