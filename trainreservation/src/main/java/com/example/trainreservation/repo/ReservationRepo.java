package com.example.trainreservation.repo;

import com.example.trainreservation.entity.Purchase;
import com.example.trainreservation.entity.Reservation;
import com.example.trainreservation.entity.Route;
import com.example.trainreservation.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long> {
    Reservation findByTicket(Ticket ticket);

}
