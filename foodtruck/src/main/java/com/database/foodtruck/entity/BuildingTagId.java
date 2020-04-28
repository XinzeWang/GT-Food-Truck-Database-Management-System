package com.database.foodtruck.entity;

import java.io.Serializable;
import java.util.Objects;


import javax.persistence.Embeddable;

@Embeddable

public class BuildingTagId implements Serializable {
    private String tag;
    private String buildingName;

    public BuildingTagId() {
    }

    public BuildingTagId(String tag, String buildingName) {
        this.tag = tag;
        this.buildingName = buildingName;
    }

    public String getBuildingName() {
        return tag;
    }

    public void setBuildingName(String stationName) {
        this.tag = stationName;
    }

    public String getTag() {
        return buildingName;
    }

    public void setTag(String buildingName) {
        this.buildingName = buildingName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuildingTagId that = (BuildingTagId) o;
        return Objects.equals(tag, that.tag) &&
                Objects.equals(buildingName, that.buildingName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag, buildingName);
    }
}

