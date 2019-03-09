package com.example.trainreservation.controller;

import com.example.trainreservation.entity.AvailableSeats;
import com.example.trainreservation.entity.Route;
import com.example.trainreservation.entity.Ticket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/ticket/")
public class TicketControllar {
    @GetMapping(value = "create.jsf")
    public String displayTicket(Model model){
        model.addAttribute("obj", new Ticket());
        return "ticket/create";

    }

    @GetMapping(value = "list.jsf")
    public String getList(){
        return "ticket/list";

    }
}
