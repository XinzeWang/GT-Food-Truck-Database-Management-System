package com.database.foodtruck.vo;

// container for query 21
public class FoodTruckMenuQuery {
    private String foodTruckName;
    private String stationName;
    private String foodName;
    private Double price;

    public FoodTruckMenuQuery(String foodTruckName, String stationName, String foodName, Double price) {
        this.foodTruckName = foodTruckName;
        this.stationName = stationName;
        this.foodName = foodName;
        this.price = price;
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

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
