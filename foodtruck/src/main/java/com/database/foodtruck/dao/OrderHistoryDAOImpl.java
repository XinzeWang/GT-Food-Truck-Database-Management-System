package com.database.foodtruck.dao;

import com.database.foodtruck.vo.OrderHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

/*query 32*/
@Repository
public class OrderHistoryDAOImpl implements OrderHistoryDAO {
    private EntityManager entityManager;

    @Autowired
    public OrderHistoryDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<OrderHistory> viewOrderHistory(String customerUserName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("cus_order_history")
                        .setParameter("customerUserName", customerUserName);
        buildQuery.execute();
        Query query = entityManager.createNamedQuery("select_cus_order_history_result", OrderHistory.class);
        List<OrderHistory> res = query.getResultList();
        return res;
    }
}
