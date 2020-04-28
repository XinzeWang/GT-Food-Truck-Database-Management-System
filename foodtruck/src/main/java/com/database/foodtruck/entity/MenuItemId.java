package com.database.foodtruck.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class MenuItemId implements Serializable {
    private String foodTruckName;
    private String foodName;

    public MenuItemId() {
    }

    public MenuItemId(String foodTruckName, String foodName) {
        this.foodTruckName = foodTruckName;
        this.foodName = foodName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodTruckName() {
        return foodTruckName;
    }

    public void setFoodTruckName(String truckName) {
        this.foodTruckName = truckName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItemId that = (MenuItemId) o;
        return Objects.equals(foodTruckName, that.foodTruckName) &&
                Objects.equals(foodName, that.foodName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodTruckName, foodName);
    }
}

