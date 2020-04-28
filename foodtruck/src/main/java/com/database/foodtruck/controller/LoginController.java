package com.database.foodtruck.controller;

import com.database.foodtruck.entity.*;
import com.database.foodtruck.service.*;
import com.database.foodtruck.vo.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.database.foodtruck.util.*;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("username")
public class LoginController {
    private RegisterService registerService;

    @Autowired
    public LoginController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "1-login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                         @RequestParam String password,
                         HttpSession session,
                         Model model,
                         RedirectAttributes attributes,
                         RedirectAttributes redirectAttributes) {

        LoginResult loginResult = registerService.loginCheck(username, password);

        if (loginResult == null) {
            attributes.addFlashAttribute("message","Username/password is wrong");
            return "redirect:";
        }

        String userName = loginResult.getUserName();
        String userType = loginResult.getUserType();

        session.setAttribute("user", userName);
        session.setAttribute("userType", userType);
        model.addAttribute("userName", userName);
        model.addAttribute("userType", userType);


        if (userType.equals("Admin-Customer")) return "home/admin-customer";
        if (userType.equals("Manager-Customer")) return "home/manager-customer";
        if (userType.equals("Admin")) return "home/admin";
        if (userType.equals("Manager")) return "home/manager";
        if (userType.equals("Staff")) return "home/staff";

        if (userType.equals("Staff-Customer") || userType.equals("Customer")) return "home/customer";

        /* other bugs*/
        return "redirect:";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:";
    }

}
