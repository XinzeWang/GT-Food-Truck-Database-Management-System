package com.database.foodtruck.dao;

import com.database.foodtruck.vo.OrderHistory;

import java.util.Date;
import java.util.List;

/*query 32*/
public interface OrderHistoryDAO {
    List<OrderHistory> viewOrderHistory(String customerUserName);
}
