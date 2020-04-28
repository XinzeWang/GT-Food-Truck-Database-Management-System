package com.database.foodtruck.dao;

import com.database.foodtruck.vo.FoodTruckMenuQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

/* query 21*/
@Repository
public class FoodTruckMenuQueryDAOImpl implements FoodTruckMenuQueryDAO {

    private EntityManager entityManager;

    @Autowired
    public FoodTruckMenuQueryDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<FoodTruckMenuQuery> viewFoodTruckMenu(String foodTruckName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("mn_view_foodTruck_menu")
                        .setParameter("foodTruckName", foodTruckName);
        buildQuery.execute();
        Query query = entityManager.createNamedQuery("select_mn_view_foodTruck_menu_result", FoodTruckMenuQuery.class);
        List<FoodTruckMenuQuery> res = query.getResultList();
        return res;
    }
}

