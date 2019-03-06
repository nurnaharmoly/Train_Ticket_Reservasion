package com.example.trainreservation.controller;

import com.example.trainreservation.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

 @GetMapping(value = "/")
    public String displayDashboard(){
        return "index";
    }

}