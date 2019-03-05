package com.example.trainreservation.controller;

import com.example.trainreservation.entity.Role;
import com.example.trainreservation.repo.RoleRepo;
import com.example.trainreservation.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleController {

    @Autowired
    private RoleRepo repo;

    @GetMapping(value = "/role-save")
    public String saveRole(){
        Role role = new Role();
        role.setRoleName("SUPERADMIN");
        repo.save(role);

        Role role1 = new Role();
        role1.setRoleName("ADMIN");
        repo.save(role1);

        Role role2 = new Role();
        role2.setRoleName("USER");
        repo.save(role2);

        return "success";
    }
}
