package com.database.foodtruck.dao;

import com.database.foodtruck.vo.CusCurrentInformationBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

/* query 28 */
@Repository
public class CusCurrentInformationBasicDAOImpl implements CusCurrentInformationBasicDAO {
    private EntityManager entityManager;

    @Autowired
    public CusCurrentInformationBasicDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public CusCurrentInformationBasic findCusInfoBasic(String customerUserName) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("cus_current_information_basic")
                        .setParameter("customerUserName", customerUserName);
        buildQuery.execute();
        Query query = entityManager.createNamedQuery("select_cus_current_information_basic_result", CusCurrentInformationBasic.class);
        CusCurrentInformationBasic res = (CusCurrentInformationBasic) query.getSingleResult();
        return res;
    }
}
