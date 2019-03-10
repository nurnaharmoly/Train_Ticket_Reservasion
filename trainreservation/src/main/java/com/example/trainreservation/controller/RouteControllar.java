package com.example.trainreservation.controller;

import com.example.trainreservation.entity.AvailableSeats;
import com.example.trainreservation.entity.Route;
import com.example.trainreservation.entity.Station;
import com.example.trainreservation.repo.RouteRepo;
import com.example.trainreservation.repo.StationRepo;
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
@RequestMapping(value = "/route/")
public class RouteControllar {



    @Autowired
    private RouteRepo repo;

    @GetMapping(value = "add")
    public String viewAdd(Model model){
        model.addAttribute("route",new Route());
        return "route/add";
    }

    @PostMapping(value = "add")
    public String add(@Valid Route route, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "route/add";
        }else{
            this.repo.save(route);
            model.addAttribute("route", new Route());
            model.addAttribute("successMsg", "Successfully Saved!");
        }

        return "route/add";
    }


    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("route",repo.getOne(id));
        return "route/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Route route, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            return "route/edit";
        } else {

            this.repo.save(route);
        }

        return "redirect:/route/list";
    }




    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/route/list";
    }


    @GetMapping(value = "list")
    public String list(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "route/list";
    }







//    @GetMapping(value = "create.jsf")
//    public String displayRoute(Model model){
//        model.addAttribute("obj", new Route());
//        return "route/create";
//
//    }
//
//    @GetMapping(value = "list.jsf")
//    public String getList(){
//        return "route/list";
//
//    }
}
