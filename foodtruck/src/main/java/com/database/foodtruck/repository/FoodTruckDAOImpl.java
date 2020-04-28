package com.database.foodtruck.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

@Repository
public class FoodTruckDAOImpl implements FoodTruckDAO {
    private EntityManager entityManager;

    @Autowired
    public FoodTruckDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /*query 18*/
    @Override
    public void deleteFoodTruck(String foodTruckName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("mn_delete_foodTruck")
                        .setParameter("foodTruckName", foodTruckName);
        buildQuery.execute();
    }

    /*query 19a*/
    @Override
    public void createFTAddStation(String foodTruckName, String stationName, String managerUserName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("mn_create_foodTruck_add_station")
                        .setParameter("foodTruckName", foodTruckName)
                        .setParameter("stationName", stationName)
                        .setParameter("managerUserName", managerUserName);
        buildQuery.execute();
    }

    /*query 19b*/
    @Override
    public void createFTAddStaff(String foodTruckName, String staffName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("mn_create_foodTruck_add_staff")
                        .setParameter("foodTruckName", foodTruckName)
                        .setParameter("staffName", staffName);
        buildQuery.execute();
    }

    /*query 19c*/
    @Override
    public void createFTAddMenuItem(String foodTruckName, Double price, String foodName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("mn_create_foodTruck_add_menu_item")
                        .setParameter("foodTruckName", foodTruckName)
                        .setParameter("price", price)
                        .setParameter("foodName", foodName);
        buildQuery.execute();
    }

    /*query 22a*/
    @Override
    public void updateFTStation(String foodTruckName, String stationName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("mn_update_foodTruck_station")
                        .setParameter("foodTruckName", foodTruckName)
                        .setParameter("stationName", stationName);
        buildQuery.execute();
    }

    /*query 22b*/
    @Override
    public void updateFTStaff(String foodTruckName, String staffName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("mn_update_foodTruck_staff")
                        .setParameter("foodTruckName", foodTruckName)
                        .setParameter("staffName", staffName);
        buildQuery.execute();
    }

    /*query 22c*/
    @Override
    public void updateFTMenuItem(String foodTruckName, Double price, String foodName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("mn_update_foodTruck_menu_item")
                        .setParameter("foodTruckName", foodTruckName)
                        .setParameter("price", price)
                        .setParameter("foodName", foodName);
        buildQuery.execute();
    }
}
