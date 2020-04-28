package com.database.foodtruck.vo;

/*not used, could be deleted later*/
public class ViewStationQuery {
    private String stationName;
    private Integer capacity;
    private String buildingName;

    public ViewStationQuery(String stationName, Integer capacity, String buildingName) {
        this.stationName = stationName;
        this.capacity = capacity;
        this.buildingName = buildingName;
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

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
}
