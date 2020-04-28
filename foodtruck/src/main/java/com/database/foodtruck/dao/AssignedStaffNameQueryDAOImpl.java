package com.database.foodtruck.dao;

import com.database.foodtruck.vo.StaffNameQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

/* query 20b */
@Repository
public class AssignedStaffNameQueryDAOImpl implements AssignedStaffNameQueryDAO {
    private EntityManager entityManager;

    @Autowired
    public AssignedStaffNameQueryDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<StaffNameQuery> viewFoodTruckStaff(String foodTruckName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("mn_view_foodTruck_staff")
                        .setParameter("foodTruckName", foodTruckName);
        buildQuery.execute();
        Query query = entityManager.createNamedQuery("select_mn_view_foodTruck_staff_result", StaffNameQuery.class);
        List<StaffNameQuery> res = query.getResultList();
        return res;

    }
}
