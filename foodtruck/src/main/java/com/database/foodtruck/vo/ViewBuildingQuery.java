package com.database.foodtruck.vo;

/*not used, could be deleted later*/
public class ViewBuildingQuery {
    private String buildingName;
    private String description;

    public ViewBuildingQuery(String buildingName, String description) {
        this.buildingName = buildingName;
        this.description = description;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
