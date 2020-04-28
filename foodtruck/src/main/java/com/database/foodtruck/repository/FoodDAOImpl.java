package com.database.foodtruck.repository;

import com.database.foodtruck.entity.Employee;
import com.database.foodtruck.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class FoodDAOImpl implements FoodDAO {
    private EntityManager entityManager;

    @Autowired
    public FoodDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /*query 15*/
    @Override
    public void deleteFood(String foodName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("ad_delete_food")
                        .setParameter("foodName", foodName);
        buildQuery.execute();
    }

    /*query 16*/
    @Override
    public void createFood(String foodName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("ad_create_food")
                        .setParameter("foodName", foodName);
        buildQuery.execute();
    }

    /*find all food*/
    @Override
    public List<Food> findAllFood() {
        TypedQuery<Food> theQuery = entityManager.createQuery("from Food", Food.class);
        List<Food> foodList = theQuery.getResultList();
        return foodList;
    }


}
