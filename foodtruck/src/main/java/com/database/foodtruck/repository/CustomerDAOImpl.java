package com.database.foodtruck.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.Date;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    private EntityManager entityManager;

    @Autowired
    public CustomerDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /*query 27*/
    @Override
    public void selectLocation(String customerUserName, String stationName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("cus_select_location")
                        .setParameter("customerUserName", customerUserName)
                        .setParameter("stationName", stationName);
        buildQuery.execute();
    }

    /*query 30*/
    @Override
    public void createOder(Date date, String customerUserName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("cus_order")
                        .setParameter("date", date)
                        .setParameter("customerUserName", customerUserName);
        buildQuery.execute();
    }

    /*query 31*/
    @Override
    public void addItemToOrder(String foodTruckName, String foodName, Integer purchaseQuantity) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("cus_add_item_to_order")
                        .setParameter("foodTruckName", foodTruckName)
                        .setParameter("foodName", foodName)
                        .setParameter("purchaseQuantity", purchaseQuantity);
        buildQuery.execute();
    }
}
