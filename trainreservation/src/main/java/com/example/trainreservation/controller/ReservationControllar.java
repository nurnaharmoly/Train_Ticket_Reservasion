package com.example.trainreservation.controller;

import com.example.trainreservation.entity.AvailableSeats;
import com.example.trainreservation.entity.Reservation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/reservation/")
public class ReservationControllar {
    @GetMapping(value = "create.jsf")
    public String displayReservation(Model model){
        model.addAttribute("obj", new Reservation());
        return "reservation/create";

    }

    @GetMapping(value = "list.jsf")
    public String getList(){
        return "reservation/list";

    }
}
