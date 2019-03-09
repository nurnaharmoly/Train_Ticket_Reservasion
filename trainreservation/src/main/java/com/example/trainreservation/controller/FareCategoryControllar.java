package com.example.trainreservation.controller;

import com.example.trainreservation.entity.AvailableSeats;
import com.example.trainreservation.entity.FareCategory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/fareCategory/")
public class FareCategoryControllar {
    @GetMapping(value = "create.jsf")
    public String displayFareCategory(Model model){
        model.addAttribute("obj", new FareCategory());
        return "fareCategory/create";

    }

    @GetMapping(value = "list.jsf")
    public String getList(){
        return "fareCategory/list";

    }
}
