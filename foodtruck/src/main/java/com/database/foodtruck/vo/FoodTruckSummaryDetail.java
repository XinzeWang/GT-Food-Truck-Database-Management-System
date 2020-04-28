package com.database.foodtruck.vo;

import java.util.Date;

// container for query 25
public class FoodTruckSummaryDetail {
    private Date date;
    private String customerName;
    private Double totalPurchase;
    private Integer orderCount;
    private String foodNames;

    public FoodTruckSummaryDetail(Date date, String customerName, Double totalPurchase, Integer orderCount, String foodNames) {
        this.date = date;
        this.customerName = customerName;
        this.totalPurchase = totalPurchase;
        this.orderCount = orderCount;
        this.foodNames = foodNames;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getTotalPurchase() {
        return totalPurchase;
    }

    public void setTotalPurchase(Double totalPurchase) {
        this.totalPurchase = totalPurchase;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public String getFoodNames() {
        return foodNames;
    }

    public void setFoodNames(String foodNames) {
        this.foodNames = foodNames;
    }
}
