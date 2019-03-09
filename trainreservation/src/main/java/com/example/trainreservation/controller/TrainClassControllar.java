package com.example.trainreservation.controller;

import com.example.trainreservation.entity.Role;
import com.example.trainreservation.entity.TrainClass;
import com.example.trainreservation.repo.TrainClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "/trainclass/")
public class TrainClassControllar {
    @Autowired
    private TrainClassRepo repo;

    @GetMapping(value = "add")
    public String viewAdd(Model model){
        model.addAttribute("trainClass",new TrainClass());
        return "trainClass/add";
    }
    @PostMapping(value = "add")
    public String addRole(@Valid TrainClass trainClass, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "trainClass/add";

                } else {
                    this.repo.save(trainClass);
                    model.addAttribute("trainClass1", new TrainClass());
                    model.addAttribute("successMsg", "Successfully Data");
                }


        return "trainClass/add";
    }
    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("trainClass",repo.getOne(id));
        return "trainClass/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid TrainClass trainClass, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            return "trainClass/edit";
        }
        Optional<TrainClass> tra = this.repo.findByClassName(trainClass.getClassName());
        if(tra.get().getId() != null){
            model.addAttribute("rejectMsg","Already Have This Entry");
            return "trainClass/edit";
        }else{
            trainClass.setId(id);
           this.repo.save(trainClass);
        }

        return "redirect:/trainclass/list";
    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/trainclass/list";
    }

    @GetMapping(value = "list")
    public String list(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "trainClass/list";
    }






//    @GetMapping(value = "create.jsf")
//    public String displayClass(Model model){
//        model.addAttribute("obj", new TrainClass());
//        return "trainClass/create";
//
//    }
//
//    @GetMapping(value = "list.jsf")
//    public String getList(){
//        return "trainClass/list";
//
//    }
}
