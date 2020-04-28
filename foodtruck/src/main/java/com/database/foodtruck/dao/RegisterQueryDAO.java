package com.database.foodtruck.dao;

import com.database.foodtruck.vo.CustomerExploreQuery;
import com.database.foodtruck.vo.LoginResult;
import com.database.foodtruck.vo.RegisterQuery;

import javax.persistence.ColumnResult;
import java.util.List;


public interface RegisterQueryDAO {
    /*query 1 login*/
    LoginResult loginCheck(String userName, String password);

    /*query 2*/
    void register(String username, String email,
                                      String firstname, String lastname,
                                      String password, Double balance, String type);
}

