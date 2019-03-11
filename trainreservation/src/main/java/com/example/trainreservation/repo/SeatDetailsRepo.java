package com.example.trainreservation.repo;

import com.example.trainreservation.entity.Route;
import com.example.trainreservation.entity.SeatDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatDetailsRepo extends JpaRepository<SeatDetails, Long> {


}
