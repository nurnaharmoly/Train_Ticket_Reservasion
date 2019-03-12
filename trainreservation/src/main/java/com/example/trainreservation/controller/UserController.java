package com.example.trainreservation.controller;


import com.example.trainreservation.entity.Role;
import com.example.trainreservation.entity.User;
import com.example.trainreservation.repo.RoleRepo;
import com.example.trainreservation.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping(value = "/user/")
public class UserController {

//    @Autowired
//    private UserRepo repo;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//
//    @GetMapping(value = "/user-save")
//    public String saveUser(){
//        Set<Role> roles = new HashSet<>();
//        roles.add(new Role(2L));
//
//        User user = new User("nur", "moly", "admin",  "moly@gmail.com", passwordEncoder.encode("1234"),true, null, roles);
//        repo.save(user);
//
////        Set<Role> roles1 = new HashSet<>();
////        roles1.add(new Role(3L));
////        User user1 = new User("khan","tina", "user", "tina@gmail.com",passwordEncoder.encode("1234"), true, null, roles1);
////        repo.save(user1);
////
////        Set<Role> roles2 = new HashSet<>();
////        roles2.add(new Role(2L));
////        User user2 = new User("akter","koli", "superadmin",  "koli@gmail.com",passwordEncoder.encode("1234"), true, null, roles2);
////        repo.save(user2);
//
//        return "success";
//                }

    @Autowired
    private UserRepo repo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "add")
    public String viewAdd(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("rolelist", roleRepo.findAll());
        return "users/add";
    }
    @PostMapping(value = "add")
    public String add(@Valid User user, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("rolelist", roleRepo.findAll());
            return "users/add";
        }
        if(repo.existsByEmail(user.getEmail())){
            model.addAttribute("rejectMsg","Already Have This Entry");
            model.addAttribute("rolelist", roleRepo.findAll());
        }else{
            String username = user.getEmail().split("\\@")[0];
            user.setUserName(username);
            user.setEnabled(true);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setConfirmationToken(UUID.randomUUID().toString());
            this.repo.save(user);
            model.addAttribute("user", new User());
            model.addAttribute("successMsg","Successfully Saved!");
            model.addAttribute("rolelist", roleRepo.findAll());
        }

        return "users/add";
    }


    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("user",repo.getOne(id));
        model.addAttribute("rolelist", roleRepo.findAll());
        return "users/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid User user, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            model.addAttribute("rolelist", roleRepo.findAll());
            return "users/edit";
        }
        Optional<User> u = this.repo.findByEmail(user.getEmail());
        if(u.get().getId() != id){

            model.addAttribute("rejectMsg","Already Have This Entry");
            return "users/edit";
        }else{

            user.setId(id);

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            this.repo.save(user);
            model.addAttribute("successMsg","Successfully Saved!");
            model.addAttribute("rolelist", roleRepo.findAll());
        }

        return "redirect:/user/list";
    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/user/list";
    }

    @GetMapping(value = "list")
    public String list(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "users/list";
    }
                }
