package com.database.foodtruck.controller;

import com.database.foodtruck.entity.Food;
import com.database.foodtruck.service.AdminService;
import com.database.foodtruck.service.BuildingService;
import com.database.foodtruck.service.FoodService;
import com.database.foodtruck.service.StationService;
import com.database.foodtruck.vo.AdminBSQuery;
import com.database.foodtruck.vo.AdminFilterFoodQuery;
import com.database.foodtruck.vo.AvailableBuildingQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private AdminService adminService;
    private BuildingService buildingService;
    private StationService stationService;
    private FoodService foodService;

    @Autowired
    public AdminController(AdminService adminService, BuildingService buildingService, StationService stationService, FoodService foodService) {
        this.adminService = adminService;
        this.buildingService = buildingService;
        this.stationService = stationService;
        this.foodService = foodService;
    }

    /*Screen 4*/
    @GetMapping("/manageBS")
    public String manageBS(Model theModel) {
        AdminBSQuery a = new AdminBSQuery("Clough", "test", "COC station", 20, "foodturck1");
        List<AdminBSQuery> adminBSQueries = new ArrayList<>();
        adminBSQueries.add(a);
        theModel.addAttribute("adminBSQueries", adminBSQueries);
        theModel.addAttribute("buildingList", buildingService.findAll());
        theModel.addAttribute("stationList", stationService.findAll());
        return "admin/managebuilding&station";
    }

    /*filter function*/
    @GetMapping("/filter")
    public String filter(@RequestParam("buildingName") String buildingName,
                         @RequestParam("buildingTag") String buildingTag,
                         @RequestParam("stationName") String stationName,
                         @RequestParam("minCapacity") Integer minCapacity,
                         @RequestParam("maxCapacity") Integer maxCapacity, Model theModel) {

        List<AdminBSQuery> adminBSQueries = adminService.filterBS(buildingName, buildingTag, stationName, minCapacity, maxCapacity);
        theModel.addAttribute("adminBSQueries", adminBSQueries);
        theModel.addAttribute("buildingList", buildingService.findAll());
        theModel.addAttribute("stationList", stationService.findAll());

        return "admin/managebuilding&station";
    }

    /*Go back to Screen 3*/
    @GetMapping("/home")
    public String getHome() {
        return "home/admin";
    }

    /*Screen 4 query 4*/
    @GetMapping("/deletebuilding")
    public String deleteBuilding(@RequestParam("buildingName") String buildingName) {
        buildingService.deleteByBuildingName(buildingName);
        return "redirect:/admin/home";
    }

    /*Screen 4 query 5*/
    @GetMapping("/deletestation")
    public String deleteStation(@RequestParam("stationName") String stationName) {
        stationService.deleteByStationName(stationName);
        return "admin/managebuilding&station";
    }

    /*Screen 5*/
    @GetMapping("/createbuilding")
    public String createBuilding(Model theModel) {
        return "admin/createbuilding";
    }

    /*Screen 5 save new building query 7*/
    @PostMapping("/savebuilding")
    public String saveNewBuilding(@RequestParam("buildingName") String buildingName,
                                  @RequestParam("description") String description,
                                  @RequestParam("tag1") String tag1,
                                  @RequestParam("tag2") String tag2) {
        buildingService.createBuilding(buildingName, description);
        if (!tag1.equals("")) {
            buildingService.addBuildingTag(buildingName, tag1);
        }
        if (!tag2.equals("")) {
            buildingService.addBuildingTag(buildingName, tag2);
        }
        // use a redirect to prevent duplicate submissions
        return "admin/managebuilding&station";
    }

    /*Screen 6 query 9*/
    @PostMapping("/saveupdatedbuilding")
    public String saveUpdatedBuilding(@RequestParam("oldBuildingName") String oldBuildingName,
                                      @RequestParam("buildingName") String buildingName,
                                  @RequestParam("description") String description,
                                  @RequestParam("tag1") String tag1,
                                  @RequestParam("tag2") String tag2) {
        buildingService.updateBuilding(oldBuildingName, buildingName, description);
        if (!tag2.equals("")) {
            buildingService.addBuildingTag(buildingName, tag1);
        }
        if (!tag2.equals("")) {
            buildingService.addBuildingTag(buildingName, tag2);
        }
        // use a redirect to prevent duplicate submissions
        return "admin/managebuilding&station";
    }

    /*Screen 6*/
    @GetMapping("/updatebuilding")
    public String updateBuilding(Model theModel,
                                 @RequestParam("buildingName") String buildingName,
                                 @RequestParam("buildingTag") String buildingTag) {
        theModel.addAttribute("buildingName", buildingName);
        theModel.addAttribute("tag", buildingTag);
        return "admin/updatebuilding";
    }

    /*Screen 7*/
    @GetMapping("/createstation")
    public String createStation(Model theModel) {
        List<AvailableBuildingQuery> availableBuildingQueryList = buildingService.findAvailableBuilding();
        theModel.addAttribute("available", availableBuildingQueryList);
        return "admin/createstation";
    }

    /*Screen 7*/
    @PostMapping("savestation")
    public String saveNewStation(@RequestParam("stationName") String stationName,
                                 @RequestParam("capacity") Integer capacity,
                                 @RequestParam("buildingName") String buildingName) {
        stationService.createStation(stationName, buildingName, capacity);
        return "admin/managebuilding&station";
    }

    /*Screen 7 query9*/
    @PostMapping("saveupdatedstation")
    public String saveUpdatedStation(@RequestParam("stationName") String stationName,
                                 @RequestParam("capacity") Integer capacity,
                                 @RequestParam("buildingName") String buildingName) {
        stationService.updateStation(stationName, capacity, buildingName);
        return "admin/managebuilding&station";
    }

    /*Screen 8*/
    @GetMapping("/updatestation")
    public String updateStation(Model theModel,
                                @RequestParam("stationName") String stationName,
                                @RequestParam("capacity") Integer capacity) {
        List<AvailableBuildingQuery> availableBuildingQueryList = buildingService.findAvailableBuilding();
        theModel.addAttribute("available", availableBuildingQueryList);
        theModel.addAttribute("stationName", stationName);
        theModel.addAttribute("capacity", capacity);
        return "admin/updatestation";
    }

    /*Screen 9*/
    @GetMapping("/managefood")
    public String manageFood(Model theModel) {
        /*default*/
        AdminFilterFoodQuery adminFilterFoodQuery = new AdminFilterFoodQuery("Apple", 10, 20);
        List<AdminFilterFoodQuery> queryList = new ArrayList<>();
        queryList.add(adminFilterFoodQuery);
        theModel.addAttribute("queryList", queryList);

        /*add all the food*/
        List<Food> foodList = foodService.findAllFood();
        theModel.addAttribute("foodList", foodList);
        return "admin/managefood";
    }

    @GetMapping("/filterfood")
    public String filterFood(@RequestParam("foodName") String foodName,
                             @RequestParam("sortedBy") String sortedBy,
                             @RequestParam("sortDirection") String sortDirection, Model theModel) {
        List<AdminFilterFoodQuery> queryList = foodService.filterFood(foodName, sortedBy, sortDirection);
        theModel.addAttribute("queryList", queryList);
        List<Food> foodList = foodService.findAllFood();
        theModel.addAttribute("foodList", foodList);
        return "admin/managefood";
    }

    /*Screen 9 deletefood*/
    @GetMapping("/deletefood")
    public String deleteFood(@RequestParam("foodName") String foodName, Model theModel) {
        foodService.deleteFood(foodName);
        List<Food> foodList = foodService.findAllFood();
        theModel.addAttribute("foodList", foodList);
        return "redirect:/admin/home";
    }

    /*Screen 10*/
    @GetMapping("/createfood")
    public String createFood(Model theModel) {
        return "admin/createfood";
    }

    @PostMapping("/savefood")
    public String saveFood(@RequestParam("foodName") String foodName, Model theModel) {
        foodService.createFood(foodName);
        List<Food> foodList = foodService.findAllFood();
        theModel.addAttribute("foodList", foodList);
        return "admin/managefood";
    }


}
