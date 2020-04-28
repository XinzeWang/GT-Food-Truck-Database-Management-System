package com.database.foodtruck.entity;

import com.database.foodtruck.vo.AdminFilterFoodQuery;

import javax.persistence.*;

/*Query 14*/
@NamedStoredProcedureQuery(
        name = "ad_filter_food",
        procedureName = "ad_filter_food",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "foodName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "sortedBy"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "sortDirection")
        }
)

@NamedNativeQuery(
        name = "select_ad_filter_food_result",
        query = "SELECT * FROM cs4400spring2020.ad_filter_food_result",
        resultSetMapping = "AdminFilterFoodQueryMapping"
)

@SqlResultSetMapping(
        name= "AdminFilterFoodQueryMapping",
        classes={
                @ConstructorResult(
                        targetClass= AdminFilterFoodQuery.class,
                        columns={
                                @ColumnResult(name="foodName", type=String.class),
                                @ColumnResult(name="menuCount", type=Integer.class),
                                @ColumnResult(name="purchaseCount", type=Integer.class)
                        })})

/*query 15*/
@NamedStoredProcedureQuery(
        name = "ad_delete_food",
        procedureName = "ad_delete_food",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "foodName")

        }
)

/*query 16*/
@NamedStoredProcedureQuery(
        name = "ad_create_food",
        procedureName = "ad_create_food",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "foodName")
        }
)

@Entity
@Table(name = "Food")
public class Food {
    @Id
    @Column(name = "foodName")
    private String foodName;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
