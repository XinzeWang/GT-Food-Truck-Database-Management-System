package com.database.foodtruck.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="OrderDetail")
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID;

    @Id
    private String tag;

    @Id
    private String foodName;

    private int purchaseQuantity;

    @OneToOne(targetEntity = Orders.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "orderID", referencedColumnName = "orderID", insertable = false, updatable = false)
    private Orders orders;

    @ManyToOne(targetEntity = MenuItem.class, cascade=CascadeType.ALL)
    @JoinColumns ({
            @JoinColumn(name="foodTruckName", referencedColumnName = "foodTruckName", insertable = false, updatable = false),
            @JoinColumn(name="foodName", referencedColumnName = "foodName", insertable = false, updatable = false)
    })
    private MenuItem menuItem;

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
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
}
