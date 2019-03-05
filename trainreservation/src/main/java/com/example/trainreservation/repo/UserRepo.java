package com.example.trainreservation.repo;

import com.example.trainreservation.entity.User;
import com.example.trainreservation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUserNameOrEmail(String userName, String email);
    User findByUserName(String userName);
    //User findByEmail(String email);
    //User findByConfirmationToken(String confirmationToken);


}
