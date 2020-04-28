package com.database.foodtruck.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDetailId implements Serializable {
    private int orderID;
    private String tag;
    private String foodName;

    public OrderDetailId() {
    }

    public OrderDetailId(int orderID, String tag, String foodName) {
        this.orderID = orderID;
        this.tag = tag;
        this.foodName = foodName;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailId that = (OrderDetailId) o;
        return orderID == that.orderID &&
                Objects.equals(tag, that.tag) &&
                Objects.equals(foodName, that.foodName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, tag, foodName);
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
