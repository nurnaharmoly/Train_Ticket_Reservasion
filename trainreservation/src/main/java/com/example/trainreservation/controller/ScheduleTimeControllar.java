package com.example.trainreservation.controller;

import com.example.trainreservation.entity.AvailableSeats;
import com.example.trainreservation.entity.Route;
import com.example.trainreservation.entity.ScheduleTime;
import com.example.trainreservation.entity.Station;
import com.example.trainreservation.repo.ScheduleTimeRepo;
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
@RequestMapping(value = "/scheduleTime/")
public class ScheduleTimeControllar {

//    @Autowired
//    private ScheduleTimeRepo repo;
//
//    @GetMapping(value = "add")
//    public String viewAdd(Model model){
//        model.addAttribute("scheduleTime",new ScheduleTime());
//        return "scheduleTime/add";
//    }
//
//    @PostMapping(value = "add")
//    public String add(@Valid ScheduleTime scheduleTime, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "scheduleTime/add";
//        }else{
//            this.repo.save(scheduleTime);
//            model.addAttribute("scheduleTime", new ScheduleTime());
//            model.addAttribute("successMsg", "Successfully Saved!");
//        }
//
//        return "station/add";
//    }
//
//
//    @GetMapping(value = "edit/{id}")
//    public String viewEdit(Model model, @PathVariable("id") Long id){
//        model.addAttribute("scheduleTime",repo.getOne(id));
//        return "scheduleTime/edit";
//    }
//    @PostMapping(value = "edit/{id}")
//    public String edit(@Valid ScheduleTime scheduleTime, BindingResult result, Model model,@PathVariable("id") Long id){
//        if(result.hasErrors()){
//            return "scheduleTime/edit";
//        }
//        scheduleTime.setId(id);
//        this.repo.save(scheduleTime);
//        return "redirect:/scheduleTime/list";
//        }
//
//
//
//     @GetMapping(value = "del/{id}")
//    public String del(@PathVariable("id") Long id){
//        if(id != null) {
//            this.repo.deleteById(id);
//        }
//        return "redirect:/scheduleTime/list";
//    }
//
//
//    @GetMapping(value = "list")
//    public String list(Model model){
//        model.addAttribute("list",this.repo.findAll());
//        return "scheduleTime/list";
//    }
//






//    @GetMapping(value = "create.jsf")
//    public String displayScheduleTime(Model model){
//        model.addAttribute("obj", new ScheduleTime());
//        return "scheduleTime/create";
//
//    }
//
//    @GetMapping(value = "list.jsf")
//    public String getList(){
//        return "scheduleTime/list";
//
//    }
}
