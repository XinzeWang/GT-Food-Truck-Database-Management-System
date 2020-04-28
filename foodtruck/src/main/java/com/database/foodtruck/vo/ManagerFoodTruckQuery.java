package com.database.foodtruck.vo;

// container for query 17
public class ManagerFoodTruckQuery {
    private String foodTruckName;
    private String stationName;
    private Integer remainingCapacity;
    private Integer staffCount;
    private Integer menuItem;

    public ManagerFoodTruckQuery(String foodTruckName, String stationName, Integer remainingCapacity, Integer staffCount, Integer menuItem) {
        this.foodTruckName = foodTruckName;
        this.stationName = stationName;
        this.remainingCapacity = remainingCapacity;
        this.staffCount = staffCount;
        this.menuItem = menuItem;
    }

    public String getFoodTruckName() {
        return foodTruckName;
    }

    public void setFoodTruckName(String foodTruckName) {
        this.foodTruckName = foodTruckName;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Integer getRemainingCapacity() {
        return remainingCapacity;
    }

    public void setRemainingCapacity(Integer remainingCapacity) {
        this.remainingCapacity = remainingCapacity;
    }

    public Integer getStaffCount() {
        return staffCount;
    }

    public void setStaffCount(Integer staffCount) {
        this.staffCount = staffCount;
    }

    public Integer getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(Integer menuItem) {
        this.menuItem = menuItem;
    }
}
