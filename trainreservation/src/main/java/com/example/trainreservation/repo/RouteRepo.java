package com.example.trainreservation.repo;

import com.example.trainreservation.entity.Route;
import com.example.trainreservation.entity.ScheduleTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepo extends JpaRepository<Route, Long> {


}
