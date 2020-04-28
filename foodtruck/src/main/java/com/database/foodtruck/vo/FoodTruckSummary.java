package com.database.foodtruck.vo;

// container for query 24
public class FoodTruckSummary {
    private String foodTruckName;
    private Integer totalOrder;
    private Double totalRevenue;
    private Integer totalCustomer;

    public FoodTruckSummary(String foodTruckName, Integer totalOrder, Double totalRevenue, Integer totalCustomer) {
        this.foodTruckName = foodTruckName;
        this.totalOrder = totalOrder;
        this.totalRevenue = totalRevenue;
        this.totalCustomer = totalCustomer;
    }

    public String getFoodTruckName() {
        return foodTruckName;
    }

    public void setFoodTruckName(String foodTruckName) {
        this.foodTruckName = foodTruckName;
    }

    public Integer getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(Integer totalOrder) {
        this.totalOrder = totalOrder;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public Integer getTotalCustomer() {
        return totalCustomer;
    }

    public void setTotalCustomer(Integer totalCustomer) {
        this.totalCustomer = totalCustomer;
    }
}
