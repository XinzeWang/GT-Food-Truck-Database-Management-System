package com.database.foodtruck.entity;

import com.database.foodtruck.vo.ManagerFoodTruckQuery;

import javax.persistence.*;

/* query 17*/
@NamedStoredProcedureQuery(
        name = "mn_filter_foodTruck",
        procedureName = "mn_filter_foodTruck",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "managerUserName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "foodTruckName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "stationName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "minStaffCount"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "maxStaffCount"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Boolean.class, name = "hasRemainingCapacity")
        }
)

@NamedNativeQuery(
        name = "select_mn_filter_foodTruck_result",
        query = "SELECT * FROM cs4400spring2020.mn_filter_foodTruck_result",
        resultSetMapping = "ManagerFoodTruckQueryMapping"
)

@SqlResultSetMapping(
        name= "ManagerFoodTruckQueryMapping",
        classes={
                @ConstructorResult(
                        targetClass= ManagerFoodTruckQuery.class,
                        columns={
                                @ColumnResult(name="foodTruckName", type=String.class),
                                @ColumnResult(name="stationName", type=String.class),
                                @ColumnResult(name="remainingCapacity", type=Integer.class),
                                @ColumnResult(name="staffCount", type=Integer.class),
                                @ColumnResult(name="menuItemCount", type=Integer.class),
                        })})

@Entity
@Table(name = "Manager")
public class Manager {
    @Id
    @Column(name = "username")
    private String userName;

    @OneToOne(targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    private Employee user;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }
}
