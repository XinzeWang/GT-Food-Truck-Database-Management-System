package com.database.foodtruck.repository;

import com.database.foodtruck.entity.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

@Repository
public class BuildingDAOImpl implements BuildingDAO {
    private EntityManager entityManager;

    @Autowired
    public BuildingDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /* query 8a */
    @Override
    public Building findByBuildingName(String buildingName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("ad_view_building_general")
                        .setParameter("buildingName", buildingName);
        buildQuery.execute();
        Query query = entityManager.createNamedQuery("select_ad_view_building_general_result", Building.class);
        Building res = (Building) query.getSingleResult();
        return res;
    }


    /*query 7*/
    @Override
    public void createBuilding(String buildingName, String description) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("ad_create_building")
                        .setParameter("buildingName", buildingName)
                        .setParameter("description", description);
        buildQuery.execute();
    }

    /*query 4*/
    @Override
    public void deleteByBuildingName(String buildingName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("ad_delete_building")
                        .setParameter("buildingName", buildingName);
        buildQuery.execute();
    }

    /*query 9*/
    @Override
    public void updateBuilding(String oldBuildingName, String newBuildingName, String description) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("ad_update_building")
                        .setParameter("oldBuildingName", oldBuildingName)
                        .setParameter("newBuildingName", newBuildingName)
                        .setParameter("description", description);
        buildQuery.execute();
    }
}
