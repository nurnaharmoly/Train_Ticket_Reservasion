package com.example.trainreservation.repo;

import com.example.trainreservation.entity.Sales;
import com.example.trainreservation.entity.Ticket;
import com.example.trainreservation.entity.TrainClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepo extends JpaRepository<Sales, Long> {
    Sales findByTicket(Ticket ticket);
}
