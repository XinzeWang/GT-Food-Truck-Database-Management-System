package com.database.foodtruck.service;

import com.database.foodtruck.dao.OrderHistoryDAO;
import com.database.foodtruck.entity.Orders;
import com.database.foodtruck.vo.OrderHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/*query 32*/
@Service
public class OrdersServiceImpl implements OrdersService {

    private OrderHistoryDAO orderHistoryDAO;

    @Autowired
    public OrdersServiceImpl(@Qualifier("orderHistoryDAOImpl") OrderHistoryDAO orderHistoryDAO) {
        this.orderHistoryDAO = orderHistoryDAO;
    }

    @Override
    public List<OrderHistory> viewOrderHistory(String customerUserName) {
        return orderHistoryDAO.viewOrderHistory(customerUserName);
    }
//
//    @Override
//    public long getNumOfRows() {
//        return orderRepository.countAllBy();
//    }
}
