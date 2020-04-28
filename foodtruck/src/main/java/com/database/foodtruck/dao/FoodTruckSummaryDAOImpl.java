package com.database.foodtruck.dao;

import com.database.foodtruck.vo.FoodTruckSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.Date;
import java.util.List;

/*query 24*/
@Repository
public class FoodTruckSummaryDAOImpl implements FoodTruckSummaryDAO {
    private EntityManager entityManager;

    @Autowired
    public FoodTruckSummaryDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<FoodTruckSummary> filterSummary(String managerUserName, String foodTruckName, String stationName, Date minDate, Date maxDate, String sortedBy, String sortedDirection) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("mn_filter_summary")
                        .setParameter("managerUserName", managerUserName)
                        .setParameter("foodTruckName", foodTruckName)
                        .setParameter("stationName", stationName)
                        .setParameter("minDate", minDate)
                        .setParameter("maxDate", maxDate)
                        .setParameter("sortedBy", sortedBy)
                        .setParameter("sortedDirection", sortedDirection);

        buildQuery.execute();
        Query query = entityManager.createNamedQuery("select_mn_filter_summary_result", FoodTruckSummary.class);
        List<FoodTruckSummary> res = query.getResultList();
        return res;
    }
}
