package com.database.foodtruck.entity;

import com.database.foodtruck.vo.StaffNameQuery;

import javax.persistence.*;

/*query 20a */
@NamedStoredProcedureQuery(
        name = "mn_view_foodTruck_available_staff",
        procedureName = "mn_view_foodTruck_available_staff",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "managerUserName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "foodTruckName")
        }
)

@NamedNativeQuery(
        name = "select_mn_view_foodTruck_available_staff_result",
        query = "SELECT * FROM cs4400spring2020.mn_view_foodTruck_available_staff_result",
        resultSetMapping = "StaffNameQueryMappingA"
)

@SqlResultSetMapping(
        name= "StaffNameQueryMappingA",
        classes={
                @ConstructorResult(
                        targetClass= StaffNameQuery.class,
                        columns={
                                @ColumnResult(name="concatStaffName", type=String.class)
                        })})

/*query 20b */
@NamedStoredProcedureQuery(
        name = "mn_view_foodTruck_staff",
        procedureName = "mn_view_foodTruck_staff",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "foodTruckName")
        }
)

@NamedNativeQuery(
        name = "select_mn_view_foodTruck_staff_result",
        query = "SELECT * FROM cs4400spring2020.mn_view_foodTruck_staff_result",
        resultSetMapping = "StaffNameQueryMappingB"
)

@SqlResultSetMapping(
        name= "StaffNameQueryMappingB",
        classes={
                @ConstructorResult(
                        targetClass= StaffNameQuery.class,
                        columns={
                                @ColumnResult(name="concatStaffName", type=String.class)
                        })})

@Entity
@Table(name = "Staff")
public class Staff {
    @Id
    @Column(name = "username")
    private String userName;

    @Column(name = "foodTruckName")
    private String foodTruckname;

    @OneToOne(targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    private Employee employee;

    @ManyToOne(targetEntity = FoodTruck.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "foodTruckName", referencedColumnName = "foodTruckName", insertable = false, updatable = false)
    private FoodTruck foodTruck;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFoodTruckname() {
        return foodTruckname;
    }

    public void setFoodTruckname(String foodTruckname) {
        this.foodTruckname = foodTruckname;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public FoodTruck getFoodTruck() {
        return foodTruck;
    }

    public void setFoodTruck(FoodTruck foodTruck) {
        this.foodTruck = foodTruck;
    }
}
