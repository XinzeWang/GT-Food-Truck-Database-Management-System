package com.database.foodtruck.vo;

// container for query 26
public class CustomerExploreQuery {
    private String stationName;
    private String buildingName;
    private String foodTruckNames;
    private String foodNames;

    @Override
    public String toString() {
        return "CustomerExploreQuery{" +
                "stationName='" + stationName + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", foodTruckNames='" + foodTruckNames + '\'' +
                ", foodNames='" + foodNames + '\'' +
                '}';
    }

    public CustomerExploreQuery(String stationName, String buildingName, String foodTruckNames, String foodNames) {
        this.stationName = stationName;
        this.buildingName = buildingName;
        this.foodTruckNames = foodTruckNames;
        this.foodNames = foodNames;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getFoodTruckNames() {
        return foodTruckNames;
    }

    public void setFoodTruckNames(String foodTruckNames) {
        this.foodTruckNames = foodTruckNames;
    }

    public String getFoodNames() {
        return foodNames;
    }

    public void setFoodNames(String foodNames) {
        this.foodNames = foodNames;
    }
}
