package com.example.trainreservation.repo;

import com.example.trainreservation.entity.AvailableSeats;
import com.example.trainreservation.entity.AvailableTrainSchedule;
import com.example.trainreservation.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableTrainScheduleRepo extends JpaRepository<AvailableTrainSchedule, Long> {


}
