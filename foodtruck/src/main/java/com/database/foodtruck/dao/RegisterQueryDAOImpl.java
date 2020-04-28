package com.database.foodtruck.dao;

import com.database.foodtruck.vo.CustomerExploreQuery;
import com.database.foodtruck.vo.LoginResult;
import com.database.foodtruck.vo.RegisterQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Repository
public class RegisterQueryDAOImpl implements RegisterQueryDAO{
    private EntityManager entityManager;

    @Autowired
    public RegisterQueryDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /*query 1*/
    @Override
    public LoginResult loginCheck(String userName, String password) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("login")
                        .setParameter("userName", userName)
                        .setParameter("password", password);
        buildQuery.execute();
        Query query = entityManager.createNamedQuery("select_login_result", LoginResult.class);
        LoginResult res = (LoginResult) query.getSingleResult();
        return res;
    }

    /* query 2*/
    @Override
    public void register(String username, String email, String firstname, String lastname, String password, Double balance, String type) {
        StoredProcedureQuery buildQuery =
                entityManager.createNamedStoredProcedureQuery("register")
                        .setParameter("username", username)
                        .setParameter("email", email)
                        .setParameter("firstname", firstname)
                        .setParameter("lastname", lastname)
                        .setParameter("password", password)
                        .setParameter("balance", balance)
                        .setParameter("type", type);
        buildQuery.execute();
    }
}


