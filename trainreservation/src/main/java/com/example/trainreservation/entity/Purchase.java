package com.example.trainreservation.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    private int qty;
    private double unitPrice;
    private double totalPrice;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date purchasedate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pasenger_id", nullable = false)
    private User pasenger;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Purchase() {
    }

    public Purchase(Ticket ticket, int qty, double unitPrice, double totalPrice, Date purchasedate, User pasenger) {
        this.ticket = ticket;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.purchasedate = purchasedate;
        this.pasenger = pasenger;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getPurchasedate() {
        return purchasedate;
    }

    public void setPurchasedate(Date purchasedate) {
        this.purchasedate = purchasedate;
    }

    public User getPasenger() {
        return pasenger;
    }

    public void setPasenger(User pasenger) {
        this.pasenger = pasenger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return qty == purchase.qty &&
                Double.compare(purchase.unitPrice, unitPrice) == 0 &&
                Double.compare(purchase.totalPrice, totalPrice) == 0 &&
                Objects.equals(id, purchase.id) &&
                Objects.equals(ticket, purchase.ticket) &&
                Objects.equals(purchasedate, purchase.purchasedate) &&
                Objects.equals(pasenger, purchase.pasenger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ticket, qty, unitPrice, totalPrice, purchasedate, pasenger);
    }
}
