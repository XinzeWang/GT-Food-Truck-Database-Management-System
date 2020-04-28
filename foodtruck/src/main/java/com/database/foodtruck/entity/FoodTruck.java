package com.database.foodtruck.entity;

import com.database.foodtruck.vo.FoodTruckMenuQuery;
import com.database.foodtruck.vo.FoodTruckSummary;
import com.database.foodtruck.vo.FoodTruckSummaryDetail;

import javax.persistence.*;
import java.util.Date;

/*query 18*/
@NamedStoredProcedureQuery(
        name = "mn_delete_foodTruck",
        procedureName = "mn_delete_foodTruck",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "foodTruckName")
        }
)

/*query 19a*/
@NamedStoredProcedureQuery(
        name = "mn_create_foodTruck_add_station",
        procedureName = "mn_create_foodTruck_add_station",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "foodTruckName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "stationName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "managerUserName")

        }
)

/*query 19b*/
@NamedStoredProcedureQuery(
        name = "mn_create_foodTruck_add_staff",
        procedureName = "mn_create_foodTruck_add_staff",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "foodTruckName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "staffName")

        }
)

/*query 19c*/
@NamedStoredProcedureQuery(
        name = "mn_create_foodTruck_add_menu_item",
        procedureName = "mn_create_foodTruck_add_menu_item",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "foodTruckName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Double.class, name = "price"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "foodName")

        }
)

/*query 22a*/
@NamedStoredProcedureQuery(
        name = "mn_update_foodTruck_station",
        procedureName = "mn_update_foodTruck_station",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "foodTruckName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "stationName")
        }
)

/*query 22b*/
@NamedStoredProcedureQuery(
        name = "mn_update_foodTruck_staff",
        procedureName = "mn_update_foodTruck_staff",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "foodTruckName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "staffName")
        }
)

/*query 22c*/
@NamedStoredProcedureQuery(
        name = "mn_update_foodTruck_menu_item",
        procedureName = "mn_update_foodTruck_menu_item",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "foodTruckName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Double.class, name = "price"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "foodName")

        }
)

/*query 21*/
@NamedStoredProcedureQuery(
        name = "mn_view_foodTruck_menu",
        procedureName = "mn_view_foodTruck_menu",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "foodTruckName")
        }
)

@NamedNativeQuery(
        name = "select_mn_view_foodTruck_menu_result",
        query = "SELECT * FROM cs4400spring2020.mn_view_foodTruck_menu_result",
        resultSetMapping = "FoodTruckMenuQueryMapping"
)

@SqlResultSetMapping(
        name= "FoodTruckMenuQueryMapping",
        classes={
                @ConstructorResult(
                        targetClass= FoodTruckMenuQuery.class,
                        columns={
                                @ColumnResult(name="foodTruckName", type=String.class),
                                @ColumnResult(name="stationName", type=String.class),
                                @ColumnResult(name="foodName", type=String.class),
                                @ColumnResult(name="price", type=Double.class)
                        })})

/*query 24*/
@NamedStoredProcedureQuery(
        name = "mn_filter_summary",
        procedureName = "mn_filter_summary",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "managerUserName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "foodTruckName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "stationName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "minDate"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "maxDate"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "sortedBy"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "sortedDirection"),
        }
)

@NamedNativeQuery(
        name = "select_mn_filter_summary_result",
        query = "SELECT * FROM cs4400spring2020.mn_filter_summary_result",
        resultSetMapping = "FoodTruckMenuSummaryMapping"
)

@SqlResultSetMapping(
        name= "FoodTruckMenuSummaryMapping",
        classes={
                @ConstructorResult(
                        targetClass= FoodTruckSummary.class,
                        columns={
                                @ColumnResult(name="foodTruckName", type=String.class),
                                @ColumnResult(name="totalOrder", type=Integer.class),
                                @ColumnResult(name="totalRevenue", type=Double.class),
                                @ColumnResult(name="totalCustomer", type=Integer.class)
                        })})


/*query 25*/
@NamedStoredProcedureQuery(
        name = "mn_summary_detail",
        procedureName = "mn_summary_detail",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "managerUserName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "foodTruckName")
        }
)

@NamedNativeQuery(
        name = "select_mn_summary_detail_result",
        query = "SELECT * FROM cs4400spring2020.mn_summary_detail_result",
        resultSetMapping = "FoodTruckSummaryDetailMapping"
)

@SqlResultSetMapping(
        name= "FoodTruckSummaryDetailMapping",
        classes={
                @ConstructorResult(
                        targetClass= FoodTruckSummaryDetail.class,
                        columns={
                                @ColumnResult(name="date", type=Date.class),
                                @ColumnResult(name="customerName", type=String.class),
                                @ColumnResult(name="totalPurchase", type=Double.class),
                                @ColumnResult(name="orderCount", type=Integer.class),
                                @ColumnResult(name="foodNames", type=String.class)
                        })})

@Entity
@Table(name = "FoodTruck")
public class FoodTruck {
    @Id
    @Column(name = "foodTruckName")
    private String truckName;

    @Column(name = "stationName")
    private String stationName;

    @Column(name = "managerUsername")
    private String managerName;

    @ManyToOne(targetEntity = Station.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "stationName", referencedColumnName = "stationName", insertable = false, updatable = false)
    private Station station;


    @ManyToOne(targetEntity = Manager.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "managerUsername", referencedColumnName = "username", insertable = false, updatable = false)
    private Manager manager;

    public String getTruckName() {
        return truckName;
    }

    public void setTruckName(String truckName) {
        this.truckName = truckName;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}

