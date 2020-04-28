package com.database.foodtruck.dao;

import com.database.foodtruck.vo.AdminBSQuery;
import com.database.foodtruck.vo.AdminFilterFoodQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

/*query 14*/

@Repository
public class AdminFilterFoodQueryDAOImpl implements AdminFilterFoodQueryDAO {

    private EntityManager entityManager;

    @Autowired
    public AdminFilterFoodQueryDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<AdminFilterFoodQuery> filterFood(String foodName, String sortedBy, String sortDirection) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("ad_filter_food")
                        .setParameter("foodName", foodName)
                        .setParameter("sortedBy", sortedBy)
                        .setParameter("sortDirection", sortDirection);
        buildQuery.execute();
        Query query = entityManager.createNamedQuery("select_ad_filter_food_result", AdminFilterFoodQuery.class);
        List<AdminFilterFoodQuery> res = query.getResultList();
        return res;
    }
}
