package com.example.trainreservation.controller;


import com.example.trainreservation.entity.Train;
import com.example.trainreservation.repo.RouteRepo;
import com.example.trainreservation.repo.ScheduleTimeRepo;
import com.example.trainreservation.repo.StationRepo;
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
@RequestMapping(value = "/train/")
public class TrainControllar {


    @Autowired
    private TrainRepo repo;

    @Autowired
    private ScheduleTimeRepo scheduleTimeRepo;

    @Autowired
    private RouteRepo routeRepo;

    @Autowired
    private StationRepo stationRepo;

    @GetMapping(value = "add")
    public String viewAdd(Model model){
        model.addAttribute("train",new Train());
        model.addAttribute("sheduleTimelist", scheduleTimeRepo.findAll());
        model.addAttribute("routeList", routeRepo.findAll());
        model.addAttribute("stationlist", stationRepo.findAll());
        return "train/add";
    }

    @PostMapping(value = "add")
    public String add(@Valid Train train, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("sheduleTimelist", scheduleTimeRepo.findAll());
            model.addAttribute("routeList", routeRepo.findAll());
            model.addAttribute("stationlist", stationRepo.findAll());
            return "train/add";

        }else{
            this.repo.save(train);
            model.addAttribute("successMsg", "Successfully Saved!");
            model.addAttribute("sheduleTimelist", scheduleTimeRepo.findAll());
            model.addAttribute("routeList", routeRepo.findAll());
            model.addAttribute("stationlist", stationRepo.findAll());
            model.addAttribute("train", new Train());

        }

        return "train/add";
    }


    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("train",repo.getOne(id));
        model.addAttribute("sheduleTimelist", scheduleTimeRepo.findAll());
        model.addAttribute("routeList", routeRepo.findAll());
        model.addAttribute("stationlist", stationRepo.findAll());
        return "train/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Train train, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            model.addAttribute("sheduleTimelist", scheduleTimeRepo.findAll());
            model.addAttribute("routeList", routeRepo.findAll());
            model.addAttribute("stationlist", stationRepo.findAll());
            return "train/edit";
        } else {
            train.setId(id);
            this.repo.save(train);
            model.addAttribute("sheduleTimelist", scheduleTimeRepo.findAll());
            model.addAttribute("routeList", routeRepo.findAll());
            model.addAttribute("stationlist", stationRepo.findAll());
            return "redirect:/train/list";
        }


    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/train/list";
    }


    @GetMapping(value = "list")
    public String list(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "train/list";
    }

    @GetMapping(value = "traindetails")
    public String listbytrain(Model model){
        model.addAttribute("train",this.repo.findByTrainNo(734));
        model.addAttribute("trainlist",this.repo.findAll());
        return "train/listbytrain";
    }

}
