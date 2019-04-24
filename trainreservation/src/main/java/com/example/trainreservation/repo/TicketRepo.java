package com.example.trainreservation.repo;

import com.example.trainreservation.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long> {
//    Optional<Ticket> findByTicketNo(int ticketNo);
//    boolean existsTicketByTicketNo(int ticketNo);

}
