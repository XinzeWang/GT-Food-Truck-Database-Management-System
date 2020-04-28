package com.database.foodtruck.dao;

import com.database.foodtruck.vo.CusCurrentInformationFT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

/* query 29*/
@Repository
public class CusCurrentInformationFTDAOImpl implements CusCurrentInformationFTDAO {
    private EntityManager entityManager;

    @Autowired
    public CusCurrentInformationFTDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<CusCurrentInformationFT> findCusInfoFT(String customerUserName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("cus_current_information_foodTruck")
                        .setParameter("customerUserName", customerUserName);
        buildQuery.execute();
        Query query = entityManager.createNamedQuery("select_cus_current_information_foodTruck_result", CusCurrentInformationFT.class);
        List<CusCurrentInformationFT> res = query.getResultList();
        return res;

    }
}
