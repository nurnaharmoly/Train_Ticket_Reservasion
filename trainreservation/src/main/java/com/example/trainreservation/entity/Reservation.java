package com.example.trainreservation.entity;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;

	private String noOffSeats;

	private double totalPrice;

	private double unitPrice;


//	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date journyDate;

	@ManyToOne
	@JoinColumn(name = "ticket_id", nullable = false)
	private Ticket ticket;

	@ManyToOne
	@JoinColumn(name = "compartment_id", nullable = false)
	private Compartment compartment;

	@ManyToOne
	@JoinColumn(name = "train_id", nullable = false)
	private Train train;



	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pasenger_id", nullable = false)
	private User pasenger;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNoOffSeats() {
		return noOffSeats;
	}

	public void setNoOffSeats(String noOffSeats) {
		this.noOffSeats = noOffSeats;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Date getJournyDate() {
		return journyDate;
	}

	public void setJournyDate(Date journyDate) {
		this.journyDate = journyDate;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Compartment getCompartment() {
		return compartment;
	}

	public void setCompartment(Compartment compartment) {
		this.compartment = compartment;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public User getPasenger() {
		return pasenger;
	}

	public void setPasenger(User pasenger) {
		this.pasenger = pasenger;
	}

	public Reservation() {
	}

	public Reservation(String noOffSeats, double totalPrice, double unitPrice, Date journyDate, Ticket ticket, Compartment compartment, Train train, User pasenger) {
		this.noOffSeats = noOffSeats;
		this.totalPrice = totalPrice;
		this.unitPrice = unitPrice;
		this.journyDate = journyDate;
		this.ticket = ticket;
		this.compartment = compartment;
		this.train = train;
		this.pasenger = pasenger;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Reservation that = (Reservation) o;
		return Double.compare(that.totalPrice, totalPrice) == 0 &&
				Double.compare(that.unitPrice, unitPrice) == 0 &&
				Objects.equals(id, that.id) &&
				Objects.equals(noOffSeats, that.noOffSeats) &&
				Objects.equals(journyDate, that.journyDate) &&
				Objects.equals(ticket, that.ticket) &&
				Objects.equals(compartment, that.compartment) &&
				Objects.equals(train, that.train) &&
				Objects.equals(pasenger, that.pasenger);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, noOffSeats, totalPrice, unitPrice, journyDate, ticket, compartment, train, pasenger);
	}

	@Override
	public String toString() {
		return "Reservation{" +
				"id=" + id +
				", noOffSeats='" + noOffSeats + '\'' +
				", totalPrice=" + totalPrice +
				", unitPrice=" + unitPrice +
				", journyDate=" + journyDate +
				", ticket=" + ticket +
				", compartment=" + compartment +
				", train=" + train +
				", user=" + pasenger +
				'}';
	}
}
