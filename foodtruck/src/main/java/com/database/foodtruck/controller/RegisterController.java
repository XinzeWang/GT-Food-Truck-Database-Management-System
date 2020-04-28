package com.database.foodtruck.controller;

import com.database.foodtruck.entity.*;
import com.database.foodtruck.service.*;
import com.database.foodtruck.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private RegisterService registerService;

    @GetMapping("/registration")
    public String register() {
        return "2-register";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam String username,
                               @RequestParam String email,
                               @RequestParam String firstname,
                               @RequestParam String lastname,
                               @RequestParam String password,
                               @RequestParam String confirmpassword,
                               @RequestParam(value = "balance", required = false) Double balance,
                               @RequestParam(value = "role") String role,
                               RedirectAttributes attributes) {

        if (!password.equals(confirmpassword)) {
            attributes.addFlashAttribute("message", "Password does not match the confirmation password.");
            return "redirect:/registration";
        }

        if (password.length() < 8) {
            attributes.addFlashAttribute("message", "Password length should be larger than 8");
            return "redirect:/registration";
        }

        if (userService.checkUserExist(username) != null) {
            attributes.addFlashAttribute("message", "User already exists.");
            return "redirect:/register";
        }

        registerService.register(username, email, firstname, lastname, password, balance, role);

        return "redirect:/login";
    }
}
