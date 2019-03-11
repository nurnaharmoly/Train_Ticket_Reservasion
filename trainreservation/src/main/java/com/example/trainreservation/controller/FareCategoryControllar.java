package com.example.trainreservation.controller;

import com.example.trainreservation.entity.AvailableSeats;
import com.example.trainreservation.entity.FareCategory;
import com.example.trainreservation.entity.Station;
import com.example.trainreservation.repo.FareCategoryRepo;
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
@RequestMapping(value = "/fareCategory/")
public class FareCategoryControllar {


    @Autowired
    private FareCategoryRepo repo;

    @GetMapping(value = "add")
    public String viewAdd(Model model){
        model.addAttribute("fareCategory",new FareCategory());
        return "fareCategory/add";
    }

    @PostMapping(value = "add")
    public String add(@Valid FareCategory fareCategory, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "fareCategory/add";
        }else{
            this.repo.save(fareCategory);
            model.addAttribute("fareCategory", new FareCategory());
            model.addAttribute("successMsg", "Successfully Saved!");
        }

        return "fareCategory/add";
    }


    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("fareCategory",repo.getOne(id));
        return "fareCategory/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid FareCategory fareCategory, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            return "fareCategory/edit";
        }
        fareCategory.setId(id);
        this.repo.save(fareCategory);
        return "redirect:/fareCategory/list";
        }


    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/fareCategory/list";
    }


    @GetMapping(value = "list")
    public String list(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "fareCategory/list";
    }













//    @GetMapping(value = "create.jsf")
//    public String displayFareCategory(Model model){
//        model.addAttribute("obj", new FareCategory());
//        return "fareCategory/create";
//
//    }
//
//    @GetMapping(value = "list.jsf")
//    public String getList(){
//        return "fareCategory/list";
//
//    }
}
