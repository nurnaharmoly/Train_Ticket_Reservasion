package com.example.trainreservation.controller;


import com.example.trainreservation.entity.AvailableTrainSchedule;

import com.example.trainreservation.entity.SeatDetails;
import com.example.trainreservation.entity.Train;
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
import java.util.List;

@Controller
@RequestMapping(value = "/availableTrainSchedule/")
public class AvailableTrainScheduleController {

    @Autowired
    private AvailableTrainScheduleRepo repo;

    @Autowired
    private SeatDetailsRepo seatDetailsRepo;

    @Autowired
    private TrainRepo trainRepo;

    @Autowired
    private CompartmentRepo compartmentRepo;


    @GetMapping(value = "add")
    public String viewAdd(Model model){
        model.addAttribute("availableTrainSchedule",new AvailableTrainSchedule());
//        model.addAttribute("seatDetailslist", seatDetailsRepo.findAll());
        model.addAttribute("train",this.trainRepo.findByTrainNo(734));
        model.addAttribute("trainlist",this.trainRepo.findAll());
        model.addAttribute("compartmentlist",this.compartmentRepo.findAll());

        return "availableTrainSchedule/add";
    }

    @PostMapping(value = "add")
    public String add(@Valid AvailableTrainSchedule availableTrainSchedule, BindingResult result, Model model) {
        Train train=this.trainRepo.findByTrainNo(availableTrainSchedule.getTrain().getTrainNo());
        availableTrainSchedule.setTrain(train);
        availableTrainSchedule.setStatus(true);
        for(int i=0; i < train.getCompartmentList().size(); i++){
            availableTrainSchedule.setSeatDetails(train.getCompartmentList().get(i).getSeatDetailsList());

        }
        this.repo.save(availableTrainSchedule);
            model.addAttribute("availableTrainSchedule",new AvailableTrainSchedule());
            model.addAttribute("successMsg", "Successfully Saved!");
            model.addAttribute("seatDetailslist", seatDetailsRepo.findAll());

        model.addAttribute("compartmentlist",this.compartmentRepo.findAll());
        return "availableTrainSchedule/add";
    }


    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("availableTrainSchedule",repo.getOne(id));
        model.addAttribute("seatDetailslist", seatDetailsRepo.findAll());
        model.addAttribute("compartmentlist",this.compartmentRepo.findAll());
        return "availableTrainSchedule/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid AvailableTrainSchedule availableTrainSchedule, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            model.addAttribute("seatDetailslist", seatDetailsRepo.findAll());
            model.addAttribute("compartmentlist",this.compartmentRepo.findAll());
            return "availableTrainSchedule/edit";
        } else {
            availableTrainSchedule.setId(id);
            this.repo.save(availableTrainSchedule);
            model.addAttribute("seatDetailslist", seatDetailsRepo.findAll());
            model.addAttribute("compartmentlist",this.compartmentRepo.findAll());
            return "redirect:/availableTrainSchedule/list";
        }
    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/availableTrainSchedule/list";
    }


    @GetMapping(value = "list")
    public String list(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "availableTrainSchedule/list";
    }



}
