package com.example.trainreservation.config;

import com.example.trainreservation.entity.User;
import com.example.trainreservation.repo.UserRepo;
import com.example.trainreservation.entity.User;
import com.example.trainreservation.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
   private UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Optional<User> optionalUsers =userRepo.findByUserNameOrEmail(usernameOrEmail, usernameOrEmail);
        optionalUsers
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUsers.map(CustomUserDetails::new).get();
    }
}
