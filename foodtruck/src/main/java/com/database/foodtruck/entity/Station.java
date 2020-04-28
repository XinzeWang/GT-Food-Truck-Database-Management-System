package com.database.foodtruck.entity;

import com.database.foodtruck.vo.ManagerGetStation;

import javax.persistence.*;

/*query 5*/
@NamedStoredProcedureQuery(
        name = "ad_delete_station",
        procedureName = "ad_delete_station",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "stationName")
        }
)

/*query 11*/
@NamedStoredProcedureQuery(
        name = "ad_create_station",
        procedureName = "ad_create_station",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "stationName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "buildingName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "capacity")
        }
)

/*query 12*/
@NamedStoredProcedureQuery(
        name = "ad_view_station",
        procedureName = "ad_view_station",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "stationName")
        }
)

@NamedNativeQuery(
        name = "select_ad_view_station_result",
        query = "SELECT * FROM cs4400spring2020.ad_view_station_result",
        resultSetMapping = "StationMapping"
)

@SqlResultSetMapping(
        name= "StationMapping",
        classes={
                @ConstructorResult(
                        targetClass= Station.class,
                        columns={
                                @ColumnResult(name="stationName", type=String.class),
                                @ColumnResult(name="capacity", type=Integer.class),
                                @ColumnResult(name="buildingName", type=String.class)
                        })})

/*query 13*/
@NamedStoredProcedureQuery(
        name = "ad_update_station",
        procedureName = "ad_update_station",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "stationName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "capacity"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "buildingName"),
        }
)

/*query 23*/
@NamedStoredProcedureQuery(
        name = "mn_get_station",
        procedureName = "mn_get_station",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "managerUserName")
        }
)

@NamedNativeQuery(
        name = "select_mn_get_station_result",
        query = "SELECT * FROM cs4400spring2020.mn_get_station_result",
        resultSetMapping = "ManagerGetStationMapping"
)

@SqlResultSetMapping(
        name= "ManagerGetStationMapping",
        classes={
                @ConstructorResult(
                        targetClass= ManagerGetStation.class,
                        columns={
                                @ColumnResult(name="stationName", type=String.class)
                        })})


@Entity
@Table(name = "Station")
public class Station {
    @Id
    @Column(name = "stationName")
    private String stationName;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "buildingName")
    private String buildingName;

    @OneToOne(targetEntity = Building.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "buildingName", referencedColumnName = "buildingName", insertable = false, updatable = false)
    private Building building;

    public void setBuilding(Building building) {
        this.building = building;
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
