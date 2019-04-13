package com.example.trainreservation.repo;

import com.example.trainreservation.entity.Route;
import com.example.trainreservation.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepo extends JpaRepository<Train, Long> {

Train findByTrainNo(int trainNo);
}
