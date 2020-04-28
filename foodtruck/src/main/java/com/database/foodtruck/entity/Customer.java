package com.database.foodtruck.entity;

import com.database.foodtruck.vo.CusCurrentInformationBasic;
import com.database.foodtruck.vo.CusCurrentInformationFT;
import com.database.foodtruck.vo.CustomerExploreQuery;

import javax.persistence.*;
import java.util.Date;

/* query 26 explore */
@NamedStoredProcedureQuery(
        name = "cus_filter_explore",
        procedureName = "cus_filter_explore",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "buildingName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "stationName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "buildingTag"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "foodTruckName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "foodName")
        }
)

@NamedNativeQuery(
        name = "select_cus_filter_explore_result",
        query = "SELECT * FROM cs4400spring2020.cus_filter_explore_result",
        resultSetMapping = "CustomerExploreQueryMapping"
)

@SqlResultSetMapping(
        name= "CustomerExploreQueryMapping",
        classes={
                @ConstructorResult(
                        targetClass= CustomerExploreQuery.class,
                        columns={
                                @ColumnResult(name="stationName", type=String.class),
                                @ColumnResult(name="buildingName", type=String.class),
                                @ColumnResult(name="foodTruckNames", type=String.class),
                                @ColumnResult(name="foodNames", type=String.class)
                        })})


/* query 28 basic */
@NamedStoredProcedureQuery(
        name = "cus_current_information_basic",
        procedureName = "cus_current_information_basic",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "customerUserName")
        }
)

@NamedNativeQuery(
        name = "select_cus_current_information_basic_result",
        query = "SELECT * FROM cs4400spring2020.cus_current_information_basic_result",
        resultSetMapping = "CusCurrentInformationBasicMapping"
)

@SqlResultSetMapping(
        name= "CusCurrentInformationBasicMapping",
        classes={
                @ConstructorResult(
                        targetClass= CusCurrentInformationBasic.class,
                        columns={
                                @ColumnResult(name="stationName", type=String.class),
                                @ColumnResult(name="buildingName", type=String.class),
                                @ColumnResult(name="tags", type=String.class),
                                @ColumnResult(name="description", type=String.class),
                                @ColumnResult(name="balance", type=Double.class),
                        })})

/* query 29 ft */
@NamedStoredProcedureQuery(
        name = "cus_current_information_foodTruck",
        procedureName = "cus_current_information_foodTruck",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "customerUserName"),
        }
)

@NamedNativeQuery(
        name = "select_cus_current_information_foodTruck_result",
        query = "SELECT * FROM cs4400spring2020.cus_current_information_foodTruck_result",
        resultSetMapping = "CusCurrentInformationFTMapping"
)

@SqlResultSetMapping(
        name= "CusCurrentInformationFTMapping",
        classes={
                @ConstructorResult(
                        targetClass= CusCurrentInformationFT.class,
                        columns={
                                @ColumnResult(name="foodTruckName", type=String.class),
                                @ColumnResult(name="managerName", type=String.class),
                                @ColumnResult(name="foodNames", type=String.class)
                        })})

/*query 27*/
@NamedStoredProcedureQuery(
        name = "cus_select_location",
        procedureName = "cus_select_location",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "customerUserName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "stationName")
        }
)

/*query 30*/
@NamedStoredProcedureQuery(
        name = "cus_order",
        procedureName = "cus_order",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "date"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "customerUserName")
        }
)

/*query 31*/
@NamedStoredProcedureQuery(
        name = "cus_add_item_to_order",
        procedureName = "cus_add_item_to_order",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "foodTruckName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "foodName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "purchaseQuantity")
        }
)

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @Column(name = "username")
    private String userName;

    @Column(name = "balance")
    private double balance;

    @Column(name = "stationName")
    private String stationName;

    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    private User user;

    @OneToOne(targetEntity = Station.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "stationName", referencedColumnName = "stationName", insertable = false, updatable = false)
    private Station station;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userName='" + userName + '\'' +
                ", balance=" + balance +
                ", stationName='" + stationName + '\'' +
                '}';
    }
}
