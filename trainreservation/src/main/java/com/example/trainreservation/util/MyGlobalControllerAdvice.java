package com.example.trainreservation.util;

import com.example.trainreservation.entity.User;
import com.example.trainreservation.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class MyGlobalControllerAdvice {
    @Autowired

    private UserRepo userRepo;

    @ModelAttribute("uu")
    public User getUserDetails(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUserName(auth.getName());
        return user;

    }

}
