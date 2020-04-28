package com.database.foodtruck.vo;

// container for query 14
public class AdminFilterFoodQuery {
    private String foodName;
    private Integer menuCount;
    private Integer purchaseCount;

    public AdminFilterFoodQuery(String foodName, Integer menuCount, Integer purchaseCount) {
        this.foodName = foodName;
        this.menuCount = menuCount;
        this.purchaseCount = purchaseCount;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getMenuCount() {
        return menuCount;
    }

    public void setMenuCount(Integer menuCount) {
        this.menuCount = menuCount;
    }

    public Integer getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(Integer purchaseCount) {
        this.purchaseCount = purchaseCount;
    }
}
