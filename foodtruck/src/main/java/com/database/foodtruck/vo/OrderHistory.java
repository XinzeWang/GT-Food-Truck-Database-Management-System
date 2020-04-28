package com.database.foodtruck.vo;

import java.util.Date;

public class OrderHistory {
    private Date date;
    private String orderID;
    private Double orderTotal;
    private String foodNames;
    private Integer foodQuantity;

    public OrderHistory(Date date, String orderID, Double orderTotal, String foodNames, Integer foodQuantity) {
        this.date = date;
        this.orderID = orderID;
        this.orderTotal = orderTotal;
        this.foodNames = foodNames;
        this.foodQuantity = foodQuantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getFoodNames() {
        return foodNames;
    }

    public void setFoodNames(String foodNames) {
        this.foodNames = foodNames;
    }

    public Integer getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(Integer foodQuantity) {
        this.foodQuantity = foodQuantity;
    }
}
