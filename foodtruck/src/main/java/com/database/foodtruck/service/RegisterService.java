package com.database.foodtruck.service;

import com.database.foodtruck.vo.CustomerExploreQuery;
import com.database.foodtruck.vo.LoginResult;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import java.util.List;

public interface RegisterService {
    /*query 1 login*/
    LoginResult loginCheck(String userName, String password);

    /*query 2*/
    void register(String username, String email, String firstname, String lastname, String password, Double balance, String type);
}
