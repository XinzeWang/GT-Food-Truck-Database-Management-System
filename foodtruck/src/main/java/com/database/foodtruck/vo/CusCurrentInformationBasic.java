package com.database.foodtruck.vo;

// container for query 28
public class CusCurrentInformationBasic {
    private String stationName;
    private String buildingName;
    private String tags;
    private String description;
    private Double balance;

    public CusCurrentInformationBasic(String stationName, String buildingName, String tags, String description, Double balance) {
        this.stationName = stationName;
        this.buildingName = buildingName;
        this.tags = tags;
        this.description = description;
        this.balance = balance;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
