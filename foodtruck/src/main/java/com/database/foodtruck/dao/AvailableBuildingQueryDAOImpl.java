package com.database.foodtruck.dao;

import com.database.foodtruck.vo.AvailableBuildingQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

/* query 10 */
@Repository
public class AvailableBuildingQueryDAOImpl implements AvailableBuildingQueryDAO {

    private EntityManager entityManager;

    @Autowired
    public AvailableBuildingQueryDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<AvailableBuildingQuery> findAvailableBuilding() {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("ad_get_available_building");
        buildQuery.execute();
        Query query = entityManager.createNamedQuery("select_ad_get_available_building", AvailableBuildingQuery.class);
        List<AvailableBuildingQuery> res = query.getResultList();
        return res;
    }
}
