package com.database.foodtruck.dao;

import com.database.foodtruck.entity.Admin;
import com.database.foodtruck.vo.AdminBSQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

/*query 3*/
@Repository
public class AdminBSQueryDAOImpl implements AdminBSQueryDAO {
    private EntityManager entityManager;

    @Autowired
    public AdminBSQueryDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // return query 3
    @Override
    public List<AdminBSQuery> filterBS(String buildingName, String buildingTag, String stationName, Integer minCapacity, Integer maxCapacity) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("ad_filter_building_station")
                        .setParameter("i_buildingName", buildingName)
                        .setParameter("i_buildingTag", buildingTag)
                        .setParameter("i_stationName", stationName)
                        .setParameter("i_minCapacity", minCapacity)
                        .setParameter("i_maxCapacity", maxCapacity);
        buildQuery.execute();
        Query query = entityManager.createNamedQuery("select_ad_filter_building_station", AdminBSQuery.class);
        List<AdminBSQuery> res = query.getResultList();
        return res;
    }
}
