package com.example.trainreservation.repo;

import com.example.trainreservation.entity.FareCategory;
import com.example.trainreservation.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FareCategoryRepo extends JpaRepository<FareCategory, Long> {


}
