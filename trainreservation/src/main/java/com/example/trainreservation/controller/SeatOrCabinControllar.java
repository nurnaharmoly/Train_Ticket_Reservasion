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
@RequestMapping(value = "/seatOrCabin/")
public class SeatOrCabinControllar {


    @Autowired
    private SeatOrCabinRepo repo;

    @Autowired
    private CompartmentRepo compartmentRepo;

    @Autowired
    private TrainClassRepo trainClassRepo;

    @Autowired
    private TrainRepo trainRepo;

    @Autowired
    private SeatDetailsRepo seatDetailsRepo;

    @GetMapping(value = "add")
    public String viewAdd(Model model){
        model.addAttribute("seatOrCabin",new SeatOrCabin());
        model.addAttribute("compartmentlist", compartmentRepo.findAll());
        model.addAttribute("trainClasslist", trainClassRepo.findAll());
        model.addAttribute("trainlist", trainRepo.findAll());

        return "seatOrCabin/add";
    }

    @PostMapping(value = "add")
    public String add(@Valid SeatOrCabin seatOrCabin, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            model.addAttribute("trainClasslist", trainClassRepo.findAll());
            model.addAttribute("trainlist", trainRepo.findAll());
            return "seatOrCabin/add";
        }else{
            this.repo.save(seatOrCabin);

            SeatDetails sd=new SeatDetails();
            sd.setStatus(true);
            sd.setCompartment(seatOrCabin.getCompartment());
            sd.setTrain(seatOrCabin.getTrain());
            sd.setSeatOrCabin(seatOrCabin);
            this.seatDetailsRepo.save(sd);

            model.addAttribute("seatOrCabin", new SeatOrCabin());
            model.addAttribute("successMsg", "Successfully Saved!");
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            model.addAttribute("trainClasslist", trainClassRepo.findAll());
            model.addAttribute("trainlist", trainRepo.findAll());
        }

        return "seatOrCabin/add";
    }


    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("seatOrCabin",repo.getOne(id));
        model.addAttribute("compartmentlist", compartmentRepo.findAll());
        model.addAttribute("trainClasslist", trainClassRepo.findAll());
        model.addAttribute("trainlist", trainRepo.findAll());
        return "seatOrCabin/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid SeatOrCabin seatOrCabin, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            model.addAttribute("trainClasslist", trainClassRepo.findAll());
            model.addAttribute("trainlist", trainRepo.findAll());
            return "seatOrCabin/edit";
        } else {
             seatOrCabin.setId(id);
            this.repo.save(seatOrCabin);
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            model.addAttribute("trainClasslist", trainClassRepo.findAll());
            model.addAttribute("trainlist", trainRepo.findAll());
            return "redirect:/seatOrCabin/list";
        }
    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/seatOrCabin/list";
    }


    @GetMapping(value = "list")
    public String list(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "seatOrCabin/list";
    }









//    @GetMapping(value = "create.jsf")
//    public String displaySeatOrCabin(Model model){
//        model.addAttribute("obj", new SeatOrCabin());
//        return "seatOrCabin/create";
//
//    }
//
//    @GetMapping(value = "list.jsf")
//    public String getList(){
//        return "seatOrCabin/list";
//
//    }
}
