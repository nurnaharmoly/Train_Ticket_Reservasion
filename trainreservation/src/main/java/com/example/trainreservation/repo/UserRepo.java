package com.example.trainreservation.repo;

import com.example.trainreservation.entity.Role;
import com.example.trainreservation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUserNameOrEmail(String userName, String email);
    User findByUserName(String username);
    Optional<User> findByEmail(String email);
    List<User> findAllByRoles(Set<Role> roles);
    boolean existsByEmail(String email);
    User findByConfirmationToken(String token);


//    void setTokenExpiredByEmail(boolean b, String email);
}
