package com.database.foodtruck.entity;

import com.database.foodtruck.vo.AdminBSQuery;

import javax.persistence.*;

/* query 3*/
@NamedStoredProcedureQuery(
        name = "ad_filter_building_station",
        procedureName = "ad_filter_building_station",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "i_buildingName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "i_buildingTag"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "i_stationName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "i_minCapacity"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "i_maxCapacity")
        }
)

@NamedNativeQuery(
        name = "select_ad_filter_building_station",
        query = "SELECT * FROM cs4400spring2020.ad_filter_building_station_result;",
        resultSetMapping = "AdminBSMapping"
)

@SqlResultSetMapping(
        name="AdminBSMapping",
        classes={
                @ConstructorResult(
                        targetClass=AdminBSQuery.class,
                        columns={
                                @ColumnResult(name="buildingName", type=String.class),
                                @ColumnResult(name="tags", type=String.class),
                                @ColumnResult(name="stationName", type=String.class),
                                @ColumnResult(name="capacity", type=Integer.class),
                                @ColumnResult(name="foodTruckNames", type = String.class),
                        })})

@Entity
@Table(name = "Admin")
public class Admin {
    @Id
    @Column(name = "username")
    private String userName;

    @OneToOne(targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    private Employee user;

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }
}
