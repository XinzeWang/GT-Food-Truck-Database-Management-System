package com.database.foodtruck.dao;

import com.database.foodtruck.vo.FoodTruckSummaryDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

/*query 25*/
@Repository
public class FoodTruckSummaryDetailDAOImpl implements FoodTruckSummaryDetailDAO {
    private EntityManager entityManager;

    @Autowired
    public FoodTruckSummaryDetailDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<FoodTruckSummaryDetail> viewSummaryDetail(String managerUserName, String foodTruckName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("mn_summary_detail")
                        .setParameter("managerUserName", managerUserName)
                        .setParameter("foodTruckName", foodTruckName);
        buildQuery.execute();
        Query query = entityManager.createNamedQuery("select_mn_summary_detail_result", FoodTruckSummaryDetail.class);
        List<FoodTruckSummaryDetail> res = query.getResultList();
        return res;

    }
}
