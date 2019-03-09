package com.example.trainreservation.controller;

import com.example.trainreservation.entity.AvailableSeats;
import com.example.trainreservation.entity.Route;
import com.example.trainreservation.entity.SeatDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/seatDetails/")
public class SeatDetailsControllar {
    @GetMapping(value = "create.jsf")
    public String displaySeatDetails(Model model){
        model.addAttribute("obj", new SeatDetails());
        return "seatDetails/create";

    }

    @GetMapping(value = "list.jsf")
    public String getList(){
        return "seatDetails/list";

    }
}
