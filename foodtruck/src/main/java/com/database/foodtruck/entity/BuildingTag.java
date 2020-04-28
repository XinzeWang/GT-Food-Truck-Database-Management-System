package com.database.foodtruck.entity;

import com.database.foodtruck.vo.ViewTagQuery;

import javax.persistence.*;
import java.io.Serializable;

/*query 6a*/
@NamedStoredProcedureQuery(
        name = "ad_add_building_tag",
        procedureName = "ad_add_building_tag",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "buildingName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "tag")

        }
)

/*query 6b*/
@NamedStoredProcedureQuery(
        name = "ad_remove_building_tag",
        procedureName = "ad_remove_building_tag",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "buildingName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "tag")
        }
)

/*query 8b*/
@NamedStoredProcedureQuery(
        name = "ad_view_building_tags",
        procedureName = "ad_view_building_tags",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "buildingName")
        }
)

@NamedNativeQuery(
        name = "select_ad_view_building_tags_result",
        query = "SELECT * FROM cs4400spring2020.ad_view_building_tags_result",
        resultSetMapping = "ViewTagQueryMapping"
)

@SqlResultSetMapping(
        name= "ViewTagQueryMapping",
        classes={
                @ConstructorResult(
                        targetClass= ViewTagQuery.class,
                        columns={
                                @ColumnResult(name="tag", type=String.class)
                        })})

@Entity
@Table(name = "BuildingTag")
@IdClass(BuildingTagId.class)
public class BuildingTag implements Serializable {
    @Id
    @Column(name = "buildingName")
    private String buildingName;

    @Id
    @Column(name = "tag")
    private String tag;

    @ManyToOne(targetEntity = Building.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "buildingName", referencedColumnName = "buildingName", insertable = false, updatable = false)
    private Building orderInfo;

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String stationName) {
        this.buildingName = stationName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String buildingName) {
        this.tag = buildingName;
    }

    public Building getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Building orderInfo) {
        this.orderInfo = orderInfo;
    }
}

