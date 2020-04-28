package com.database.foodtruck.dao;

import com.database.foodtruck.vo.CustomerExploreQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

/* query 26*/
@Repository
public class CustomerExploreQueryDAOImpl implements CustomerExploreQueryDAO {
    private EntityManager entityManager;

    @Autowired
    public CustomerExploreQueryDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<CustomerExploreQuery> filterExplore(String buildingName, String stationName, String buildingTag, String foodTruckName, String foodName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("cus_filter_explore")
                        .setParameter("buildingName", buildingName)
                        .setParameter("stationName", stationName)
                        .setParameter("buildingTag", buildingTag)
                        .setParameter("foodTruckName", foodTruckName)
                        .setParameter("foodName", foodName);
        buildQuery.execute();
        Query query = entityManager.createNamedQuery("select_cus_filter_explore_result", CustomerExploreQuery.class);
        List<CustomerExploreQuery> res = query.getResultList();
        return res;
    }
}
