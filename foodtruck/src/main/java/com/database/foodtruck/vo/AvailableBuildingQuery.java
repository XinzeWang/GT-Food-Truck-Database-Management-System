package com.database.foodtruck.vo;

// container for query 10
public class AvailableBuildingQuery {
    String buildingName;

    public AvailableBuildingQuery(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
}
