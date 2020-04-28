package com.database.foodtruck.dao;

import com.database.foodtruck.vo.StaffNameQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

/* query 20a */
@Repository
public class AvailableStaffNameQueryDAOImpl implements AvailableStaffNameQueryDAO {
    private EntityManager entityManager;

    @Autowired
    public AvailableStaffNameQueryDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<StaffNameQuery> viewFoodTruckAvailableStaff(String managerUserName, String foodTruckName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("mn_view_foodTruck_available_staff")
                        .setParameter("managerUserName", managerUserName)
                        .setParameter("foodTruckName", foodTruckName);
        buildQuery.execute();
        Query query = entityManager.createNamedQuery("select_mn_view_foodTruck_available_staff_result", StaffNameQuery.class);
        List<StaffNameQuery> res = query.getResultList();
        return res;


    }
}
