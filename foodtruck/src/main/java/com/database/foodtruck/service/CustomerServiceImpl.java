package com.database.foodtruck.service;

import com.database.foodtruck.dao.CusCurrentInformationBasicDAO;
import com.database.foodtruck.dao.CusCurrentInformationFTDAO;
import com.database.foodtruck.dao.CustomerExploreQueryDAO;
import com.database.foodtruck.dao.FoodTruckMenuQueryDAO;
import com.database.foodtruck.entity.Customer;
import com.database.foodtruck.repository.CustomerDAO;
import com.database.foodtruck.repository.CustomerRepository;
import com.database.foodtruck.repository.UserRepository;
import com.database.foodtruck.vo.CusCurrentInformationBasic;
import com.database.foodtruck.vo.CusCurrentInformationFT;
import com.database.foodtruck.vo.CustomerExploreQuery;
import com.database.foodtruck.vo.FoodTruckMenuQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    private UserRepository userRepository;

    private CusCurrentInformationBasicDAO cusCurrentInformationBasicDAO;

    private CusCurrentInformationFTDAO cusCurrentInformationFTDAO;

    private CustomerExploreQueryDAO customerExploreQueryDAO;

    private FoodTruckMenuQueryDAO foodTruckMenuQueryDAO;

    private CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository,
                               UserRepository userRepository,
                               @Qualifier("cusCurrentInformationBasicDAOImpl") CusCurrentInformationBasicDAO cusCurrentInformationBasicDAO,
                               @Qualifier("cusCurrentInformationFTDAOImpl") CusCurrentInformationFTDAO cusCurrentInformationFTDAO,
                               @Qualifier("customerExploreQueryDAOImpl") CustomerExploreQueryDAO customerExploreQueryDAO,
                               @Qualifier("customerDAOImpl") CustomerDAO customerDAO,
                               @Qualifier("foodTruckMenuQueryDAOImpl") FoodTruckMenuQueryDAO foodTruckMenuQueryDAO) {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
        this.cusCurrentInformationBasicDAO = cusCurrentInformationBasicDAO;
        this.cusCurrentInformationFTDAO = cusCurrentInformationFTDAO;
        this.customerExploreQueryDAO = customerExploreQueryDAO;
        this.customerDAO = customerDAO;
        this.foodTruckMenuQueryDAO = foodTruckMenuQueryDAO;
    }

    @Transactional
    @Override
    public Customer saveCustomer(String username, double balance) {
        Customer customer = new Customer();
        customer.setUserName(username);
        customer.setBalance(balance);
        // User u = userRepository.findByUsername(username);
        // customer.setUser(u);
        return customerRepository.saveAndFlush(customer);
    }

    @Override
    public Customer checkCustomerExist(String username) {
        return customerRepository.findByUserName(username);
    }

    @Transactional
    @Override
    public void delete(String username) {
        customerRepository.deleteByUserName(username);
    }

    @Override
    public List<FoodTruckMenuQuery> viewFoodTruckMenu(String foodTruckName) {
        return foodTruckMenuQueryDAO.viewFoodTruckMenu(foodTruckName);
    }

    @Override
    public List<CustomerExploreQuery> filterExplore(String buildingName, String stationName, String buildingTag, String foodTruckName, String foodName) {
        return customerExploreQueryDAO.filterExplore(buildingName, stationName, buildingTag, foodTruckName, foodName);
    }

    @Override
    public CusCurrentInformationBasic findCusInfoBasic(String customerUserName) {
        return cusCurrentInformationBasicDAO.findCusInfoBasic(customerUserName);
    }

    @Override
    public List<CusCurrentInformationFT> findCusInfoFT(String customerUserName) {
        return cusCurrentInformationFTDAO.findCusInfoFT(customerUserName);
    }

    @Override
    public void selectLocation(String customerUserName, String stationName) {
        customerDAO.selectLocation(customerUserName, stationName);
    }

    @Override
    public void createOder(Date date, String customerUserName) {
        customerDAO.createOder(date, customerUserName);
    }

    @Override
    public void addItemToOrder(String foodTruckName, String foodName, Integer purchaseQuantity) {
        customerDAO.addItemToOrder(foodTruckName, foodName, purchaseQuantity);
    }
}
