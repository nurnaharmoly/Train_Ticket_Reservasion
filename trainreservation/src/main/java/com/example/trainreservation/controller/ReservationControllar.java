package com.example.trainreservation.controller;

import com.example.trainreservation.entity.*;
import com.example.trainreservation.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/reservation/")
public class ReservationControllar {


    @Autowired
    private ReservationRepo repo;

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private CompartmentRepo compartmentRepo;

    @Autowired
    private TrainRepo trainRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "add")
    public String viewAdd(Model model){
        model.addAttribute("reservation",new Reservation());
        model.addAttribute("ticketlist", ticketRepo.findAll());
        model.addAttribute("compartmentlist", compartmentRepo.findAll());
        model.addAttribute("trainlist", trainRepo.findAll());
        model.addAttribute("userlist", userRepo.findAll());
        return "reservation/add";
    }

    @PostMapping(value = "add")
    public String add(@Valid Reservation reservation, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("ticketlist", ticketRepo.findAll());
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            model.addAttribute("trainlist", trainRepo.findAll());
            model.addAttribute("userlist", userRepo.findAll());
            return "reservation/add";
        }else{
            this.repo.save(reservation);
            model.addAttribute("reservation", new Reservation());
            model.addAttribute("successMsg", "Successfully Saved!");
            model.addAttribute("ticketlist", ticketRepo.findAll());
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            model.addAttribute("trainlist", trainRepo.findAll());
            model.addAttribute("userlist", userRepo.findAll());
        }

        return "reservation/add";
    }


    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("reservation",repo.getOne(id));
        model.addAttribute("ticketlist", ticketRepo.findAll());
        model.addAttribute("compartmentlist", compartmentRepo.findAll());
        model.addAttribute("trainlist", trainRepo.findAll());
        model.addAttribute("userlist", userRepo.findAll());
        return "reservation/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Reservation reservation, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            model.addAttribute("ticketlist", ticketRepo.findAll());
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            model.addAttribute("trainlist", trainRepo.findAll());
            model.addAttribute("userlist", userRepo.findAll());
            return "reservation/edit";
        } else {
            reservation.setId(id);
            this.repo.save(reservation);
            model.addAttribute("ticketlist", ticketRepo.findAll());
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            model.addAttribute("trainlist", trainRepo.findAll());
            model.addAttribute("userlist", userRepo.findAll());
            return "redirect:/reservation/list";
        }
    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/reservation/list";
    }


    @GetMapping(value = "list")
    public String list(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "reservation/list";
    }





//    @GetMapping(value = "create.jsf")
//    public String displayReservation(Model model){
//        model.addAttribute("obj", new Reservation());
//        return "reservation/create";
//
//    }
//
//    @GetMapping(value = "list.jsf")
//    public String getList(){
//        return "reservation/list";
//
//    }
}
