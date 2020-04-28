package com.database.foodtruck.repository;

import com.database.foodtruck.vo.ViewTagQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Repository
public class BuildingTagDAOImpl implements BuildingTagDAO {
    private EntityManager entityManager;

    @Autowired
    public BuildingTagDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /*query 6a*/
    @Override
    public void addBuildingTag(String buildingName, String tag) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("ad_add_building_tag")
                        .setParameter("buildingName", buildingName)
                        .setParameter("tag", tag);
        buildQuery.execute();
    }

    /*query 6b*/
    @Override
    public void removeBuildingTag(String buildingName, String tag) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("ad_remove_building_tag")
                        .setParameter("buildingName", buildingName)
                        .setParameter("tag", tag);
        buildQuery.execute();
    }

    /*query 8b*/
    @Override
    public List<ViewTagQuery> viewBuildingTag(String buildingName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("ad_view_building_tags")
                        .setParameter("buildingName", buildingName);
        buildQuery.execute();
        Query query = entityManager.createNamedQuery("select_ad_view_building_tags_result", ViewTagQuery.class);
        List<ViewTagQuery> res = query.getResultList();
        return res;
    }
}
