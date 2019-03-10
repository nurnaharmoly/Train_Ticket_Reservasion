package com.example.trainreservation.repo;

import com.example.trainreservation.entity.ScheduleTime;
import com.example.trainreservation.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleTimeRepo extends JpaRepository<ScheduleTime, Long> {


}
