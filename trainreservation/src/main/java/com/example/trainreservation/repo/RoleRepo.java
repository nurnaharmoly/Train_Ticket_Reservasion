package com.example.trainreservation.repo;

import com.example.trainreservation.entity.Role;
import com.example.trainreservation.entity.User;
import com.example.trainreservation.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

}
