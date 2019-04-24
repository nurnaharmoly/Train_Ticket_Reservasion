package com.example.trainreservation.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;

	private int ticketNo;

//	@ManyToOne
//	@JoinColumn(name = "user_id", nullable = false)
//	private User user;
//
//	@ManyToOne
//	@JoinColumn(name = "fareCategore_id", nullable = false)
//	private FareCategory fareCategore;

	@ManyToOne
	@JoinColumn(name = "compartment_id", nullable = false)
	private Compartment compartment;

	@OneToOne
	@JoinColumn(name = "seatOrCabin_id", nullable = false)
	private  SeatOrCabin seatOrCabin;

	@OneToOne
	@JoinColumn(name = "route_id")
	private Route route;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}


	public Compartment getCompartment() {
		return compartment;
	}

	public void setCompartment(Compartment compartment) {
		this.compartment = compartment;
	}

	public SeatOrCabin getSeatOrCabin() {
		return seatOrCabin;
	}

	public void setSeatOrCabin(SeatOrCabin seatOrCabin) {
		this.seatOrCabin = seatOrCabin;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Ticket() {
	}


	public Ticket(Long id) {
		this.id = id;
	}
	public Ticket(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Ticket ticket = (Ticket) o;
		return ticketNo == ticket.ticketNo &&
				Objects.equals(id, ticket.id) &&
				Objects.equals(compartment, ticket.compartment) &&
				Objects.equals(seatOrCabin, ticket.seatOrCabin) &&
				Objects.equals(route, ticket.route);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, ticketNo, compartment, seatOrCabin, route);
	}


	@Override
	public String toString() {
		return "Ticket{" +
				"id=" + id +
				", ticketNo=" + ticketNo +
				", compartment=" + compartment +
				", seatOrCabin=" + seatOrCabin +
				", route=" + route +
				'}';
	}


	public Ticket(int ticketNo, Compartment compartment, SeatOrCabin seatOrCabin, Route route) {
		this.ticketNo = ticketNo;
		this.compartment = compartment;
		this.seatOrCabin = seatOrCabin;
		this.route = route;
	}


}
