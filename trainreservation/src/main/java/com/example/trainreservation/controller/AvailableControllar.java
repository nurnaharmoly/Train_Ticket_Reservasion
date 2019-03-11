package com.example.trainreservation.controller;

import com.example.trainreservation.entity.AvailableSeats;
import com.example.trainreservation.entity.Role;
import com.example.trainreservation.entity.Route;
import com.example.trainreservation.entity.Train;
import com.example.trainreservation.repo.AvailableSeatRepo;
import com.example.trainreservation.repo.CompartmentRepo;
import com.example.trainreservation.repo.RouteRepo;
import com.example.trainreservation.repo.TrainRepo;
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
@RequestMapping(value = "/availableseat/")
public class AvailableControllar {

    @Autowired
    private AvailableSeatRepo repo;

    @Autowired
    private TrainRepo trainRepo;

    @Autowired
    private CompartmentRepo compartmentRepo;

    @GetMapping(value = "add")
    public String viewAdd(Model model){
        model.addAttribute("route",new Route());
        model.addAttribute("trainlist", trainRepo.findAll());
        model.addAttribute("compartmentlist", compartmentRepo.findAll());
        return "available-seat/add";
    }

    @PostMapping(value = "add")
    public String add(@Valid AvailableSeats availableSeats, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("trainlist", trainRepo.findAll());
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            return "available-seat/add";
        }else{
            this.repo.save(availableSeats);
            model.addAttribute("availableSeats", new AvailableSeats());
           model.addAttribute("successMsg", "Successfully Saved!");
            model.addAttribute("trainlist", trainRepo.findAll());
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
        }

        return "available-seat/add";
    }


    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("availableSeats",repo.getOne(id));
        model.addAttribute("trainlist", trainRepo.findAll());
        model.addAttribute("compartmentlist", compartmentRepo.findAll());
        return "available-seat/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid AvailableSeats availableSeats, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            model.addAttribute("trainlist", trainRepo.findAll());
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            return "available-seat/edit";
        } else {
            availableSeats.setId(id);
            this.repo.save(availableSeats);
            model.addAttribute("trainlist", trainRepo.findAll());
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            return "redirect:/availableseat/list";
        }
    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/availableseat/list";
    }


    @GetMapping(value = "list")
    public String list(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "available-seat/list";
    }


//    @GetMapping(value = "create.jsf")
//    public String displayAvailable(Model model){
//        model.addAttribute("obj", new AvailableSeats());
//        return "available-seat/create";
//
//    }
//
//    @GetMapping(value = "list.jsf")
//    public String getList(){
//        return "available-seat/list";
//
//    }
}
