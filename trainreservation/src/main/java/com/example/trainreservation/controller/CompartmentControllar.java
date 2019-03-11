package com.example.trainreservation.controller;

import com.example.trainreservation.entity.Compartment;
import com.example.trainreservation.entity.Role;
import com.example.trainreservation.entity.Route;
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
@RequestMapping(value = "/compartment/")
public class CompartmentControllar {

    @Autowired
    private CompartmentRepo repo;

    @Autowired
    private TrainRepo trainRepo;

    @GetMapping(value = "add")
    public String viewAdd(Model model){
        model.addAttribute("compartment",new Compartment());
        model.addAttribute("traintlist",trainRepo.findAll());
        return "compartment/add";
    }

    @PostMapping(value = "add")
    public String add(@Valid Compartment compartment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("traintlist",trainRepo.findAll());
            return "compartment/add";
        }else{
            this.repo.save(compartment);
            model.addAttribute("compartment", new Compartment());
            model.addAttribute("traintlist",trainRepo.findAll());

        }

        return "compartment/add";
    }


    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("compartment",repo.getOne(id));
        model.addAttribute("traintlist",trainRepo.findAll());
        return "compartment/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Compartment compartment, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            return "compartment/edit";
        } else {
            compartment.setId(id);
            this.repo.save(compartment);
            model.addAttribute("traintlist",trainRepo.findAll());
            return "redirect:/compartment/list";
        }
    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/compartment/list";
    }


    @GetMapping(value = "list")
    public String list(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "compartment/list";
    }






//    @GetMapping(value = "create.jsf")
//    public String displayCompartment(Model model){
//        model.addAttribute("obj", new Compartment());
//
//        return "compartment/create";
//
//    }
//
//    @GetMapping(value = "list.jsf")
//    public String getList(){
//        return "compartment/list";
//
//    }
}
