package com.example.trainreservation.controller;

import com.example.trainreservation.entity.AvailableSeats;
import com.example.trainreservation.entity.Route;
import com.example.trainreservation.entity.SeatDetails;
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
@RequestMapping(value = "/seatDetails/")
public class SeatDetailsControllar {



    @Autowired
    private SeatDetailsRepo repo;


    @Autowired
    private TrainRepo trainRepo;


    @Autowired
    private CompartmentRepo compartmentRepo;


    @Autowired
    private SeatOrCabinRepo seatOrCabinRepo;


    @GetMapping(value = "add")
    public String viewAdd(Model model){
        model.addAttribute("seatDetails",new SeatDetails());
        model.addAttribute("trainlist", trainRepo.findAll());
        model.addAttribute("compartmentlist", compartmentRepo.findAll());
        model.addAttribute("seatOrCabinlist", seatOrCabinRepo.findAll());
        return "seatDetails/add";
    }

    @PostMapping(value = "add")
    public String add(@Valid SeatDetails seatDetails, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("trainlist", trainRepo.findAll());
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            model.addAttribute("seatOrCabinlist", seatOrCabinRepo.findAll());
            return "seatDetails/add";
        }else{

            this.repo.save(seatDetails);
            model.addAttribute("seatDetails", new SeatDetails());
            model.addAttribute("successMsg", "Successfully Saved!");
            model.addAttribute("trainlist", trainRepo.findAll());
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            model.addAttribute("seatOrCabinlist", seatOrCabinRepo.findAll());
        }

        return "seatDetails/add";
    }


    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("seatDetails",repo.getOne(id));
        model.addAttribute("trainlist", trainRepo.findAll());
        model.addAttribute("compartmentlist", compartmentRepo.findAll());
        model.addAttribute("seatOrCabinlist", seatOrCabinRepo.findAll());
        return "seatDetails/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid SeatDetails seatDetails, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            model.addAttribute("trainlist", trainRepo.findAll());
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            model.addAttribute("seatOrCabinlist", seatOrCabinRepo.findAll());
            return "seatDetails/edit";
        } else {
            seatDetails.setId(id);
            this.repo.save(seatDetails);
            model.addAttribute("trainlist", trainRepo.findAll());
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            model.addAttribute("seatOrCabinlist", seatOrCabinRepo.findAll());
            return "redirect:/seatDetails/list";
        }
    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/seatDetails/list";
    }


    @GetMapping(value = "list")
    public String list(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "seatDetails/list";
    }











//    @GetMapping(value = "create.jsf")
//    public String displaySeatDetails(Model model){
//        model.addAttribute("obj", new SeatDetails());
//        return "seatDetails/create";
//
//    }
//
//    @GetMapping(value = "list.jsf")
//    public String getList(){
//        return "seatDetails/list";
//
//    }



}
