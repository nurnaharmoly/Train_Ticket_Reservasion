package com.example.trainreservation.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "summary")
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ticketNo;
    private double totalQty;
    private double soldQty;
    private int availableQty;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "availableSeat_id", nullable = false)
    private AvailableSeats availableSeat;

    @OneToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;


    public Summary() {
    }

    public Summary(String ticketNo, double totalQty, double soldQty, Date lastUpdate, AvailableSeats availableSeat, Ticket ticket) {
        this.ticketNo = ticketNo;
        this.totalQty = totalQty;
        this.soldQty = soldQty;
        this.lastUpdate = lastUpdate;
        this.availableSeat = availableSeat;
        this.ticket = ticket;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public double getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(double totalQty) {
        this.totalQty = totalQty;
    }

    public double getSoldQty() {
        return soldQty;
    }

    public void setSoldQty(double soldQty) {
        this.soldQty = soldQty;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public AvailableSeats getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(AvailableSeats availableSeat) {
        this.availableSeat = availableSeat;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Summary{" +
                "id=" + id +
                ", ticketNo='" + ticketNo + '\'' +
                ", totalQty=" + totalQty +
                ", soldQty=" + soldQty +
                ", lastUpdate=" + lastUpdate +
                ", availableSeat=" + availableSeat +
                ", ticket=" + ticket +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summary summary = (Summary) o;
        return Double.compare(summary.totalQty, totalQty) == 0 &&
                Double.compare(summary.soldQty, soldQty) == 0 &&
                Objects.equals(id, summary.id) &&
                Objects.equals(ticketNo, summary.ticketNo) &&
                Objects.equals(lastUpdate, summary.lastUpdate) &&
                Objects.equals(availableSeat, summary.availableSeat) &&
                Objects.equals(ticket, summary.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ticketNo, totalQty, soldQty, lastUpdate, availableSeat, ticket);
    }
}
