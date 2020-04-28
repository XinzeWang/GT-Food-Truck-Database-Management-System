package com.database.foodtruck.vo;

public class ManagerGetStation {
    private String stationName;

    public ManagerGetStation(String stationName) {
        this.stationName = stationName;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}
