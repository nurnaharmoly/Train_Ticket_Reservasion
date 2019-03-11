package com.example.trainreservation.repo;

import com.example.trainreservation.entity.AvailableSeats;
import com.example.trainreservation.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableSeatRepo extends JpaRepository<AvailableSeats, Long> {


}
