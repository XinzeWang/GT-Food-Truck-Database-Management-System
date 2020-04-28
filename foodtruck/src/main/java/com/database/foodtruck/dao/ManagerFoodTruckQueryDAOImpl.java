package com.database.foodtruck.dao;

import com.database.foodtruck.vo.ManagerFoodTruckQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

/*query 17*/
@Repository
public class ManagerFoodTruckQueryDAOImpl implements ManagerFoodTruckQueryDAO {
    private EntityManager entityManager;

    @Autowired
    public ManagerFoodTruckQueryDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ManagerFoodTruckQuery> filterFoodTruck(String managerUserName, String foodTruckName, String stationName, Integer minStaffCount, Integer maxStaffCount, Boolean hasRemainingCapacity) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("mn_filter_foodTruck")
                        .setParameter("managerUserName", managerUserName)
                        .setParameter("foodTruckName", foodTruckName)
                        .setParameter("stationName", stationName)
                        .setParameter("minStaffCount", minStaffCount)
                        .setParameter("maxStaffCount", maxStaffCount)
                        .setParameter("hasRemainingCapacity", hasRemainingCapacity);
        buildQuery.execute();
        Query query = entityManager.createNamedQuery("select_mn_filter_foodTruck_result", ManagerFoodTruckQuery.class);
        List<ManagerFoodTruckQuery> res = query.getResultList();
        return res;
    }
}
