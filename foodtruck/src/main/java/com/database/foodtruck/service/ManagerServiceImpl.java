package com.database.foodtruck.service;

import com.database.foodtruck.dao.*;
import com.database.foodtruck.entity.Manager;
import com.database.foodtruck.repository.ManagerRepository;
import com.database.foodtruck.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*17 20a 20b 24 25*/
@Service
public class ManagerServiceImpl implements ManagerService {

    private ManagerRepository managerRepository;

    private AvailableStaffNameQueryDAO availableStaffNameQueryDAO;

    private AssignedStaffNameQueryDAO assignedStaffNameQueryDAO;

    private FoodTruckSummaryDAO foodTruckSummaryDAO;

    private FoodTruckSummaryDetailDAO foodTruckSummaryDetailDAO;

    private ManagerFoodTruckQueryDAO managerFoodTruckQueryDAO;

    private ManagerGetStationDAO managerGetStationDAO;

    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository,
                              @Qualifier("availableStaffNameQueryDAOImpl") AvailableStaffNameQueryDAO availableStaffNameQueryDAO,
                              @Qualifier("assignedStaffNameQueryDAOImpl") AssignedStaffNameQueryDAO assignedStaffNameQueryDAO,
                              @Qualifier("foodTruckSummaryDAOImpl") FoodTruckSummaryDAO foodTruckSummaryDAO,
                              @Qualifier("foodTruckSummaryDetailDAOImpl") FoodTruckSummaryDetailDAO foodTruckSummaryDetailDAO,
                              @Qualifier("managerGetStationDAOImpl") ManagerGetStationDAO managerGetStationDAO,
                              @Qualifier("managerFoodTruckQueryDAOImpl") ManagerFoodTruckQueryDAO managerFoodTruckQueryDAO) {
        this.managerRepository = managerRepository;
        this.availableStaffNameQueryDAO = availableStaffNameQueryDAO;
        this.assignedStaffNameQueryDAO = assignedStaffNameQueryDAO;
        this.foodTruckSummaryDAO = foodTruckSummaryDAO;
        this.foodTruckSummaryDetailDAO = foodTruckSummaryDetailDAO;
        this.managerGetStationDAO = managerGetStationDAO;
        this.managerFoodTruckQueryDAO = managerFoodTruckQueryDAO;
    }

    @Override
    public Manager checkManagerExist(String username) {
        return managerRepository.findByUserName(username);
    }

    @Override
    public List<ManagerFoodTruckQuery> filterFoodTruck(String managerUserName, String foodTruckName, String stationName, Integer minStaffCount, Integer maxStaffCount, Boolean hasRemainingCapacity) {
        return managerFoodTruckQueryDAO.filterFoodTruck(managerUserName, foodTruckName, stationName, minStaffCount, maxStaffCount, hasRemainingCapacity);
    }

    @Override
    public List<StaffNameQuery> viewFoodTruckStaff(String foodTruckName) {
        return assignedStaffNameQueryDAO.viewFoodTruckStaff(foodTruckName);
    }

    @Override
    public List<ManagerGetStation> mnGetStation(String managerUserName) {
        return managerGetStationDAO.mnGetStation(managerUserName);
    }

    @Override
    public List<StaffNameQuery> viewFoodTruckAvailableStaff(String managerUserName, String foodTruckName) {
        return availableStaffNameQueryDAO.viewFoodTruckAvailableStaff(managerUserName, foodTruckName);
    }

    @Override
    public List<FoodTruckSummary> filterSummary(String managerUserName, String foodTruckName, String stationName, Date minDate, Date maxDate, String sortedBy, String sortedDirection) {
        return foodTruckSummaryDAO.filterSummary(managerUserName, foodTruckName, stationName, minDate, maxDate, sortedBy, sortedDirection);
    }

    @Override
    public List<FoodTruckSummaryDetail> viewSummaryDetail(String managerUserName, String foodTruckName) {
        return foodTruckSummaryDetailDAO.viewSummaryDetail(managerUserName, foodTruckName);
    }
}
