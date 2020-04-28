package com.database.foodtruck.repository;

import com.database.foodtruck.entity.Station;
import com.database.foodtruck.vo.ViewStationQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

@Repository
public class StationDAOImpl implements StationDAO {
    private EntityManager entityManager;

    @Autowired
    public StationDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /*query 12*/
    @Override
    public Station findByStationName(String stationName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("ad_view_station")
                        .setParameter("stationName", stationName);
        buildQuery.execute();
        Query query = entityManager.createNamedQuery("select_ad_view_station_result", Station.class);
        Station res = (Station) query.getSingleResult();
        return res;
    }

    /*query 11*/
    @Override
    public void createStation(String stationName, String buildingName, Integer capacity) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("ad_create_station")
                        .setParameter("stationName", stationName)
                        .setParameter("buildingName", buildingName)
                        .setParameter("capacity", capacity);
        buildQuery.execute();
    }

    /*query 5*/
    @Override
    public void deleteByStationName(String stationName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("ad_delete_station")
                        .setParameter("stationName", stationName);
        buildQuery.execute();
    }

    /*query 13*/
    @Override
    public void updateStation(String stationName, Integer capacity, String buildingName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("ad_update_station")
                        .setParameter("stationName", stationName)
                        .setParameter("capacity", capacity)
                        .setParameter("buildingName", buildingName);
        buildQuery.execute();
    }
}
