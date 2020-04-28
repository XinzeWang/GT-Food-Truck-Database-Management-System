package com.database.foodtruck.entity;

import com.database.foodtruck.vo.OrderHistory;

import javax.persistence.*;
import java.util.Date;


/*query 32*/
@NamedStoredProcedureQuery(
        name = "cus_order_history",
        procedureName = "cus_order_history",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "customerUserName")
        }
)

@NamedNativeQuery(
        name = "select_cus_order_history_result",
        query = "SELECT * FROM cs4400spring2020.cus_order_history_result",
        resultSetMapping = "OrderHistoryMapping"
)

@SqlResultSetMapping(
        name= "OrderHistoryMapping",
        classes={
                @ConstructorResult(
                        targetClass= OrderHistory.class,
                        columns={
                                @ColumnResult(name="date", type=Date.class),
                                @ColumnResult(name="orderID", type=String.class),
                                @ColumnResult(name="orderTotal", type=Double.class),
                                @ColumnResult(name="foodNames", type=String.class),
                                @ColumnResult(name="foodQuantity", type=Integer.class)
                        })})


@Entity
@Table(name="Orders")
public class Orders {
    @Id
    @Column(name = "orderID")
    private Integer orderID;

    @Column(name = "date")
    private Date date;

    @Column(name = "customerUsername")
    private String customerUsername;

    @ManyToOne(targetEntity = Customer.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "customerUsername", referencedColumnName = "username", insertable = false, updatable = false)
    private Customer customer;

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderId) {
        this.orderID = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerName) {
        this.customerUsername = customerName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

