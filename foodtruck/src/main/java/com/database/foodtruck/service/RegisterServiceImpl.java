package com.database.foodtruck.service;

import com.database.foodtruck.dao.*;
import com.database.foodtruck.repository.CustomerDAO;
import com.database.foodtruck.repository.CustomerRepository;
import com.database.foodtruck.repository.UserRepository;
import com.database.foodtruck.vo.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService{

    private RegisterQueryDAO registerQueryDAO;

    @Autowired
    public RegisterServiceImpl(@Qualifier("registerQueryDAOImpl") RegisterQueryDAO registerQueryDAO) {
        this.registerQueryDAO = registerQueryDAO;
    }

    @Override
    public LoginResult loginCheck(String userName, String password) {
        return registerQueryDAO.loginCheck(userName, password);
    }

    @Override
    public void register(String username, String email, String firstname, String lastname, String password, Double balance, String type) {
        registerQueryDAO.register(username, email, firstname, lastname, password, balance, type);
    }
}
