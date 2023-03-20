package com.cook.baolema.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/logout")
public class LogoutController {
    @PostMapping("/manager")
    public String managerLogout(HttpSession session){
        session.removeAttribute("managerInfo");
        return "redirect:/login/manager";
    }

    @PostMapping("/customer")
    public String customerLogout(HttpSession session){
        session.removeAttribute("customerInfo");
        return "redirect:/login/customer";
    }

    @PostMapping("/chef")
    public String chefLogout(HttpSession session){
        session.removeAttribute("chefInfo");
        return "redirect:/login/chef";
    }

}
