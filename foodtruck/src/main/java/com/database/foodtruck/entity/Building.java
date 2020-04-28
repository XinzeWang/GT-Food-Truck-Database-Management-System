package com.database.foodtruck.entity;

import com.database.foodtruck.vo.AvailableBuildingQuery;
import com.database.foodtruck.vo.ViewBuildingQuery;

import javax.persistence.*;

/* query 4*/
@NamedStoredProcedureQuery(
        name = "ad_delete_building",
        procedureName = "ad_delete_building",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "buildingName")
        }
)

/* query 7*/
@NamedStoredProcedureQuery(
        name = "ad_create_building",
        procedureName = "ad_create_building",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "buildingName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "description")
        }
)

/* query 8a , mapping using Building*/
@NamedStoredProcedureQuery(
        name = "ad_view_building_general",
        procedureName = "ad_view_building_general",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "buildingName")
        }
)

@NamedNativeQuery(
        name = "select_ad_view_building_general_result",
        query = "SELECT * FROM cs4400spring2020.ad_view_building_general_result",
        resultSetMapping = "BuildingMapping"
)

@SqlResultSetMapping(
        name= "BuildingMapping",
        classes={
                @ConstructorResult(
                        targetClass= Building.class,
                        columns={
                                @ColumnResult(name="buildingName", type=String.class),
                                @ColumnResult(name="description", type=String.class)
                        })})

/* query 9 */
@NamedStoredProcedureQuery(
        name = "ad_update_building",
        procedureName = "ad_update_building",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "oldBuildingName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "newBuildingName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "description")

        }
)

/* query 10 */
@NamedStoredProcedureQuery(
        name = "ad_get_available_building",
        procedureName = "ad_get_available_building"
)

@NamedNativeQuery(
        name = "select_ad_get_available_building",
        query = "SELECT * FROM cs4400spring2020.ad_get_available_building_result",
        resultSetMapping = "AvailableBuildingQueryMapping"
)

@SqlResultSetMapping(
        name="AvailableBuildingQueryMapping",
        classes={
                @ConstructorResult(
                        targetClass= AvailableBuildingQuery.class,
                        columns={
                                @ColumnResult(name="buildingName", type=String.class),
                        })})

@Entity
@Table(name = "Building")
public class Building {
    @Id
    @Column(name = "buildingName")
    private String buildingName;

    @Column(name = "description")
    private String buildingDescription;
    
    // only for test

    public Building() {

    }

    public Building(String buildingName, String buildingDescription) {
		this.buildingName = buildingName;
		this.buildingDescription = buildingDescription;
	}

    public String getBuildingName() {
        return buildingName;
    }

	public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingDescription() {
        return buildingDescription;
    }

    public void setBuildingDescription(String buildingDescription) {
        this.buildingDescription = buildingDescription;
    }
}
