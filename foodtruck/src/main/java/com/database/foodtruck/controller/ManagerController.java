package com.database.foodtruck.controller;

import com.database.foodtruck.entity.Food;
import com.database.foodtruck.entity.Staff;
import com.database.foodtruck.entity.Station;
import com.database.foodtruck.service.*;
import com.database.foodtruck.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    String username;

    private FoodTruckService foodTruckService;
    private ManagerService managerService;
    private StaffService staffService;
    private StationService stationService;
    private FoodService foodService;

    @Autowired
    public ManagerController(FoodTruckService foodTruckService, ManagerService managerService, StaffService staffService, StationService stationService, FoodService foodService) {
        this.foodTruckService = foodTruckService;
        this.managerService = managerService;
        this.staffService = staffService;
        this.stationService = stationService;
        this.foodService = foodService;
    }

    @GetMapping("/home")
    public String manager(@RequestParam("userName") String userName, Model model) {
        model.addAttribute("userName", userName);
        return "home/manager";
    }

    /*Screen 11*/
    @GetMapping("/truckmanagement")
    public String manageFoodTruck(@RequestParam("userName") String userName, Model model) {
        username = userName;
        List<ManagerGetStation> theStations = managerService.mnGetStation(username);
        model.addAttribute("stations", theStations);
        model.addAttribute("userName", userName);
        return "11-managefoodtruck";
    }

    @GetMapping("/filterfoodtruck")
    public String filterFoodTruck(@RequestParam String foodTruckName,
                                  @RequestParam String stationName,
                                  @RequestParam Integer minStaffCount,
                                  @RequestParam Integer maxStaffCount,
                                  @RequestParam(value = "hasRemainingCapacity", required = false) Boolean hasRemainingCapacity,
                                  Model model) {
        if(hasRemainingCapacity == null) {
            hasRemainingCapacity = false;
        }
        List<ManagerFoodTruckQuery> theTrucks = managerService.filterFoodTruck(username, foodTruckName, stationName, minStaffCount, maxStaffCount, hasRemainingCapacity);
        List<ManagerGetStation> theStations = managerService.mnGetStation(username);
        model.addAttribute("trucks", theTrucks);
        model.addAttribute("stations", theStations);
        model.addAttribute("userName", username);
        return "11-managefoodtruck";
    }

    /*Screen 11*/
    @GetMapping("/deletefoodtruck")
    public String deleteFoodTruck(@RequestParam String foodTruckName) {
        foodTruckService.deleteFoodTruck(foodTruckName);
        return "redirect:/truckmanagement";
    }

    /*Screen 12*/
    @GetMapping("/createtruck")
    public String createFoodtruck(Model model) {
        List<Staff> staff = staffService.findAll();
        List<ManagerGetStation> allStations = managerService.mnGetStation(username);
        List<Food> foods = foodService.findAllFood();
        model.addAttribute("allstations", allStations);
        model.addAttribute("staff", staff);
        model.addAttribute("foods", foods);
        return "12-createfoodtruck";
    }

    /*Screen 12*/
    @PostMapping("/createtruck")
    public String createFoodtruck(@RequestParam String foodTruckName,
                                  @RequestParam String stationName,
                                  @RequestParam String staffName,
                                  @RequestParam String foodName,
                                  @RequestParam Double price,
                                  Model model) {
        foodTruckService.createFTAddStation(foodTruckName, stationName, username);
        foodTruckService.createFTAddStaff(foodTruckName, staffName);
        foodTruckService.createFTAddMenuItem(foodTruckName, price, foodName);
        model.addAttribute("userName", username);
        return "11-managefoodtruck";
    }

    /*Screen 13*/
    @GetMapping("/truckupdate")
    public String updateFoodtruck(@RequestParam String foodTruckName,
                                  @RequestParam String stationName,
                                  HttpSession session, Model model) {
        List<Staff> staff = staffService.findAll();
        List<ManagerGetStation> allStations = managerService.mnGetStation(username);
        List<Food> foods = foodService.findAllFood();
        model.addAttribute("oldTruckName", foodTruckName);
        model.addAttribute("oldStationName", stationName);
        model.addAttribute("allstations", allStations);
        model.addAttribute("staff", staff);
        model.addAttribute("foods", foods);
        return "13-updatefoodtruck";
    }

    @PostMapping("/truckupdate")
    public String UpdateFoodTruck(@RequestParam String foodTruckName,
                                  @RequestParam String stationName,
                                  @RequestParam String staffName,
                                  @RequestParam String foodName,
                                  @RequestParam Double price,
                                  Model model) {
        foodTruckService.updateFTStation(foodTruckName, stationName);
        foodTruckService.updateFTStaff(foodTruckName, staffName);
        foodTruckService.updateFTMenuItem(foodTruckName, price, foodName);
        model.addAttribute("userName", username);
        return "11-managefoodtruck";
    }


    /*Screen 14*/
    @GetMapping("trucksummary")
    public String foodtruckSummary(@RequestParam("userName") String userName, Model model) {
        username = userName;

        List<ManagerGetStation> theStations = managerService.mnGetStation(username);
        model.addAttribute("stations", theStations);
        model.addAttribute("userName", userName);

        return "14-foodtrucksummary";
    }

    /*Screen 14 filter*/
    @GetMapping("filterfoodtrucksummary")
    public String filterFoodTruck(Model theModel,
                                  @RequestParam("foodTruckName") String foodTruckName,
                                  @RequestParam("stationName") String stationName,
                                  @RequestParam("minDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date minDate,
                                  @RequestParam("maxDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date maxDate,
                                  @RequestParam("sortedBy") String sortedBy,
                                  @RequestParam("sortedDirection") String sortedDirection) {
        List<FoodTruckSummary> theTrucks = managerService.filterSummary(username, foodTruckName,stationName,minDate, maxDate,sortedBy, sortedDirection);
        theModel.addAttribute("summaryList", theTrucks);
        theModel.addAttribute("userName", username);
        return "14-foodtrucksummary";
    }

    /*Screen 15*/
    @GetMapping("trucksummarydetail")
    public String foodTruckSummaryDeatil(Model theModel,
                                         @RequestParam("foodTruckName") String foodTruckName) {
        List<FoodTruckSummaryDetail> summaryDetailList = managerService.viewSummaryDetail(username, foodTruckName);
        theModel.addAttribute("summaryDetailList", summaryDetailList);
        theModel.addAttribute("foodTruckName", foodTruckName);
        theModel.addAttribute("userName", username);
        return "15-summarydetail";
    }


}
