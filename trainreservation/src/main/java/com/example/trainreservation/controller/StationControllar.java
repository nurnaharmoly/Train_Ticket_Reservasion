package com.example.trainreservation.controller;


import com.example.trainreservation.entity.Station;

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
@RequestMapping(value = "/station/")
public class StationControllar {

    @Autowired
    private StationRepo repo;

    @GetMapping(value = "add")
    public String viewAdd(Model model){
        model.addAttribute("station",new Station());
        return "station/add";
    }

    @PostMapping(value = "add")
    public String add(@Valid Station station, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "station/add";
        }else{
            this.repo.save(station);
            model.addAttribute("station", new Station());
            model.addAttribute("successMsg", "Successfully Saved!");
        }

        return "station/add";
    }


    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("station",repo.getOne(id));
        return "station/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Station station, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            return "station/edit";
        }
            station.setId(id);
            this.repo.save(station);
        return "redirect:/station/list";
        }







    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/station/list";
    }


    @GetMapping(value = "list")
    public String list(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "station/list";
    }



//    @GetMapping(value = "create.jsf")
//    public String displayStation(Model model){
//        model.addAttribute("obj", new Station());
//        return "station/create";
//
//    }
//
//    @GetMapping(value = "list.jsf")
//    public String getList(){
//        return "station/list";
//
//    }
}
