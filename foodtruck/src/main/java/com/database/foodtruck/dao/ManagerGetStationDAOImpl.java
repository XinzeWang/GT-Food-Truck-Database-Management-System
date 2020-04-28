package com.database.foodtruck.dao;

import com.database.foodtruck.vo.ManagerGetStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

/*query 23*/
@Repository
public class ManagerGetStationDAOImpl implements ManagerGetStationDAO {
    private EntityManager entityManager;

    @Autowired
    public ManagerGetStationDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ManagerGetStation> mnGetStation(String managerUserName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("mn_get_station")
                        .setParameter("managerUserName", managerUserName);
        buildQuery.execute();
        Query query = entityManager.createNamedQuery("select_mn_get_station_result", ManagerGetStation.class);
        List<ManagerGetStation> res = query.getResultList();
        return res;
    }
}
