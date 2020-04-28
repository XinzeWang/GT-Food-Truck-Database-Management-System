package com.database.foodtruck.entity;

import java.io.Serializable;

import javax.persistence.*;



@Entity
@NamedQuery(
        name = "MenuItem.findByFoodNameAndFoodTruckName",
        query = "SELECT menuitem.foodName, menuitem.price FROM MenuItem menuitem WHERE menuitem.foodTruckName = ?1 and menuitem.foodName = ?2"
)
@Table(name = "MenuItem")
@IdClass(MenuItemId.class)
public class MenuItem implements Serializable {
    @Id
    @Column(name = "foodTruckName")
    private String foodTruckName;

    @Id
    @Column(name = "foodName")
    private String foodName;

    @Column(name = "price")
    private double price;

    @ManyToOne(targetEntity = FoodTruck.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "foodTruckName", referencedColumnName = "foodTruckName", insertable = false, updatable = false)
    private FoodTruck foodTruck;

    @ManyToOne(targetEntity = Food.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "foodName", referencedColumnName = "foodName", insertable = false, updatable = false)
    private Food food;

    public String getFoodTruckName() {
        return foodTruckName;
    }

    public void setFoodTruckName(String truckName) {
        this.foodTruckName = truckName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public FoodTruck getFoodTruck() {
        return foodTruck;
    }

    public void setFoodTruck(FoodTruck foodTruck) {
        this.foodTruck = foodTruck;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
