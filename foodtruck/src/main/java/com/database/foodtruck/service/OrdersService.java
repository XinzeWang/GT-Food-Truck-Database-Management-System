package com.database.foodtruck.service;

import com.database.foodtruck.entity.Orders;
import com.database.foodtruck.vo.OrderHistory;

import javax.persistence.criteria.Order;
import java.util.List;

public interface OrdersService {

    /*query 32*/
    List<OrderHistory> viewOrderHistory(String customerUserName);

}
