package com.database.foodtruck.vo;

// container for query 29
public class CusCurrentInformationFT {
    private String foodTruckName;
    private String managerName;
    private String foodNames;

    public CusCurrentInformationFT(String foodTruckName, String managerName, String foodNames) {
        this.foodTruckName = foodTruckName;
        this.managerName = managerName;
        this.foodNames = foodNames;
    }

    public String getFoodTruckName() {
        return foodTruckName;
    }

    public void setFoodTruckName(String foodTruckName) {
        this.foodTruckName = foodTruckName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getFoodNames() {
        return foodNames;
    }

    public void setFoodNames(String foodNames) {
        this.foodNames = foodNames;
    }
}
