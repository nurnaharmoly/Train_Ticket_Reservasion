package com.example.trainreservation.controller;


import com.example.trainreservation.entity.Role;
import com.example.trainreservation.entity.User;
import com.example.trainreservation.repo.RoleRepo;
import com.example.trainreservation.repo.UserRepo;
import com.example.trainreservation.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.plugin.util.UIUtil;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Controller
public class UserControllerOLD {

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

    @GetMapping(value = "/user-save")
    public String saveUser() {

        Set<Role> roles=new HashSet<>();
        roles.add(new Role("SUPERADMIN"));
        roles.add(new Role("ADMIN"));
        roles.add(new Role("CADMIN"));
        roles.add(new Role("PM"));
        roles.add(new Role("TEAMLEAD"));
        roles.add(new Role("DEVELOPER"));
        roles.add(new Role("USER"));
        roles.forEach((role -> {
            roleRepo.save(role);
        }));

        roles.add(new Role(1L));
        roles.add(new Role(2L));

        User user = new User("Md.","R","sadmin","admin@pms.com",new Date(),true, UUID.randomUUID().toString(),roles);
        user.setPassword(passwordEncoder.encode("1234456789"));
        repo.save(user);
        return "success";
    }

    @GetMapping(value = "/register")
    public ModelAndView displayRegister(User user){
        ModelAndView mv=new ModelAndView();
        mv.addObject("user",user);
        mv.setViewName("signup");
        return mv;
    }

                }
