package com.database.foodtruck.controller;

import com.database.foodtruck.entity.Building;
import com.database.foodtruck.repository.BuildingRepository;
import com.database.foodtruck.repository.StationRepository;
import com.database.foodtruck.service.BuildingService;
import com.database.foodtruck.service.CustomerService;
import com.database.foodtruck.service.OrdersService;
import com.database.foodtruck.service.StationService;
import com.database.foodtruck.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    String userName;

    private CustomerService customerService;
    private OrdersService ordersService;
    private BuildingService buildingService;
    private StationService stationService;

    @Autowired
    public CustomerController(CustomerService customerService, OrdersService ordersService, BuildingService buildingService, StationService stationService) {
        this.customerService = customerService;
        this.ordersService = ordersService;
        this.buildingService = buildingService;
        this.stationService = stationService;
    }

    @GetMapping("/home")
    public String customer(@RequestParam("userName") String userName, Model model) {
        userName = userName;

        model.addAttribute("userName", userName);
        return "home/customer";
    }

    @GetMapping("/explore")
    public String filterGet(@RequestParam("userName") String userName,
                            Model model) {
        model.addAttribute("userName", userName);
        model.addAttribute("buildingList", buildingService.findAll());
        model.addAttribute("stationList", stationService.findAll());
        return "16-explore";
    }

    @PostMapping("/explore")
    public String explorefilter(@RequestParam String buildingName,
                             @RequestParam String stationName,
                             @RequestParam String buildingTag,
                             @RequestParam String foodTruckName,
                             @RequestParam String foodName,
                             @RequestParam("userName") String userName,
                             Model model) {
        List<CustomerExploreQuery> customerExploreQueries = customerService.filterExplore(buildingName, stationName, buildingTag, foodTruckName, foodName);
        model.addAttribute("buildingList", buildingService.findAll());
        model.addAttribute("stationList", stationService.findAll());
        model.addAttribute("Queries", customerExploreQueries);
        model.addAttribute("userName", userName);
        return "16-explore";
    }

    @PostMapping("/select_location")
    public String selectLocation(@RequestParam("userName") String userName, @RequestParam String stationName, Model model) {
        customerService.selectLocation(userName, stationName);
        model.addAttribute("userName", userName);
        return "16-explore";

/*
        return "redirect:/customer/explore";
*/
    }

    @GetMapping("/information_basic")
    public String getInformation(@RequestParam("userName") String userName, Model model) {
        CusCurrentInformationBasic cusInfoBasic = customerService.findCusInfoBasic(userName);
        model.addAttribute("userName", userName);
        model.addAttribute("cusInfoBasic", cusInfoBasic);
        List<CusCurrentInformationFT> cusInfoFT = customerService.findCusInfoFT(userName);
        model.addAttribute("cusInfoFT", cusInfoFT);
        return "17-currentinformation";
    }

    @PostMapping("/order")
    // POJO
    public String placeOrder(@RequestParam("userName") String userName,
                             @RequestParam("foodTruckName") String foodTruckName,
                             Model model) {
        List<FoodTruckMenuQuery> foodTruckMenuQueryList = customerService.viewFoodTruckMenu(foodTruckName);
        model.addAttribute("foodTruckMenuQueryList", foodTruckMenuQueryList);
        model.addAttribute("foodTruckName", foodTruckName);
        model.addAttribute("userName", userName);
        return "18-order";
    }

    @PostMapping("/placeorder")
    public String placeOrder(@RequestParam("userName") String userName,
                             @RequestParam String foodTruckName,
                             @RequestParam String date, String[] foodNames,
                             Integer[] purchaseQuantities, Model model) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateForm = sdf.parse(date);
        customerService.createOder(dateForm, userName);

        for (int i = 0; i < foodNames.length; i++) {
            customerService.addItemToOrder(foodTruckName, foodNames[i], purchaseQuantities[i]);
        }
        model.addAttribute("userName", userName);
        return "home/customer";
    }

    @GetMapping("/orderHistory")
    public String orderHistory(@RequestParam("userName") String userName, Model model) {
        model.addAttribute("orders", ordersService.viewOrderHistory(userName));
        model.addAttribute("userName", userName);
        return "19-orderhistory";
    }
}
