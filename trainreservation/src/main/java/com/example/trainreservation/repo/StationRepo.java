package com.example.trainreservation.repo;

import com.example.trainreservation.entity.Role;
import com.example.trainreservation.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StationRepo extends JpaRepository<Station, Long> {


}
