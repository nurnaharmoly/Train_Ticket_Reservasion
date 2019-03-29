package com.example.trainreservation.repo;

import com.example.trainreservation.entity.Purchase;
import com.example.trainreservation.entity.Ticket;
import com.example.trainreservation.entity.TrainClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepo extends JpaRepository<Purchase, Long> {

   Purchase findByTicket(Ticket ticket);
}
