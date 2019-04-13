package com.example.trainreservation.controller;

import com.example.trainreservation.entity.AvailableSeats;
import com.example.trainreservation.repo.AvailableSeatRepo;
import com.example.trainreservation.repo.CompartmentRepo;
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
        model.addAttribute("availableSeats",new AvailableSeats());
        model.addAttribute("trainlist", trainRepo.findAll());
        model.addAttribute("compartmentlist", compartmentRepo.findAll());
        return "availableseat/add";
    }

    @PostMapping(value = "add")
    public String add(@Valid AvailableSeats availableSeats, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("trainlist", trainRepo.findAll());
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            return "availableseat/add";
        }else{
            this.repo.save(availableSeats);
            model.addAttribute("availableSeats", new AvailableSeats());
           model.addAttribute("successMsg", "Successfully Saved!");
            model.addAttribute("trainlist", trainRepo.findAll());
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
        }

        return "availableseat/add";
    }


    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("availableSeats",repo.getOne(id));
        model.addAttribute("trainlist", trainRepo.findAll());
        model.addAttribute("compartmentlist", compartmentRepo.findAll());
        return "availableseat/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid AvailableSeats availableSeats, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            model.addAttribute("trainlist", trainRepo.findAll());
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            return "availableseat/edit";
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
        return "availableseat/list";
    }



}
