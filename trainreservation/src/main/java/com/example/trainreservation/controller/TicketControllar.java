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
import java.util.Optional;

@Controller
@RequestMapping(value = "/ticket/")
public class TicketControllar {


    @Autowired
    private TicketRepo repo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private FareCategoryRepo fareCategoryRepo;

    @Autowired
    private CompartmentRepo compartmentRepo;

    @Autowired
    private SeatOrCabinRepo seatOrCabinRepo;

    @Autowired
    private RouteRepo routeRepo;

    @GetMapping(value = "add")
    public String viewAdd(Model model){
        model.addAttribute("ticket",new Train());
        model.addAttribute("userlist", userRepo.findAll());
        model.addAttribute("fareCategorylist", fareCategoryRepo.findAll());
        model.addAttribute("compartmentlist", compartmentRepo.findAll());
        model.addAttribute("seatOrCabinlist", seatOrCabinRepo.findAll());
        model.addAttribute("routelist", routeRepo.findAll());
        return "ticket/add";
    }
    @PostMapping(value = "add")
    public String add(@Valid Ticket ticket, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("userlist", userRepo.findAll());
            model.addAttribute("fareCategorylist", fareCategoryRepo.findAll());
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            model.addAttribute("seatOrCabinlist", seatOrCabinRepo.findAll());
            model.addAttribute("routelist", routeRepo.findAll());
            return "ticket/add";
        }
        if(repo.existsTicketByTicketNo(ticket.getTicketNo())){
            model.addAttribute("rejectMsg","Already Have This Entry");
        }else{

            this.repo.save(ticket);
            model.addAttribute("successMsg","Successfully Saved!");
            model.addAttribute("userlist", userRepo.findAll());
            model.addAttribute("fareCategorylist", fareCategoryRepo.findAll());
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            model.addAttribute("seatOrCabinlist", seatOrCabinRepo.findAll());
            model.addAttribute("routelist", routeRepo.findAll());
        }

        return "ticket/add";
    }
    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("ticket",repo.getOne(id));
        model.addAttribute("userlist", userRepo.findAll());
        model.addAttribute("fareCategorylist", fareCategoryRepo.findAll());
        model.addAttribute("compartmentlist", compartmentRepo.findAll());
        model.addAttribute("seatOrCabinlist", seatOrCabinRepo.findAll());
        model.addAttribute("routelist", routeRepo.findAll());
        return "ticket/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Ticket ticket, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            return "ticket/edit";
        }
        Optional<Ticket> ticket1 = this.repo.findByTicketNo(ticket.getTicketNo());
        if(ticket1.get().getId() != id){
            model.addAttribute("rejectMsg","Already Have This Entry");
            return "ticket/edit";
        }else{
            ticket.setId(id);
            this.repo.save(ticket);
            model.addAttribute("userlist", userRepo.findAll());
            model.addAttribute("fareCategorylist", fareCategoryRepo.findAll());
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            model.addAttribute("seatOrCabinlist", seatOrCabinRepo.findAll());
            model.addAttribute("routelist", routeRepo.findAll());
        }

        return "redirect:/ticket/list";
    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/ticket/list";
    }

    @GetMapping(value = "list")
    public String list(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "ticket/list";
    }





//    @GetMapping(value = "create.jsf")
//    public String displayTicket(Model model){
//        model.addAttribute("obj", new Ticket());
//        return "ticket/create";
//
//    }
//
//    @GetMapping(value = "list.jsf")
//    public String getList(){
//        return "ticket/list";
//
//    }
}
