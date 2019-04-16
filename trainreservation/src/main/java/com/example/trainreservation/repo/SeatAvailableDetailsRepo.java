package com.example.trainreservation.repo;

import com.example.trainreservation.entity.SeatAvailableDetails;
import com.example.trainreservation.entity.SeatDetails;
import com.example.trainreservation.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatAvailableDetailsRepo extends JpaRepository<SeatAvailableDetails, Long> {

   List<SeatAvailableDetails> findByTrain(Train train);
}
