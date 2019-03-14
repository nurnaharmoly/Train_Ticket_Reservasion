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

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "fareCategore_id", nullable = false)
	private FareCategory fareCategore;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public FareCategory getFareCategore() {
		return fareCategore;
	}

	public void setFareCategore(FareCategory fareCategore) {
		this.fareCategore = fareCategore;
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

	public Ticket(int ticketNo, User user, FareCategory fareCategore, Compartment compartment, SeatOrCabin seatOrCabin, Route route) {
		this.ticketNo = ticketNo;
		this.user = user;
		this.fareCategore = fareCategore;
		this.compartment = compartment;
		this.seatOrCabin = seatOrCabin;
		this.route = route;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Ticket ticket = (Ticket) o;
		return ticketNo == ticket.ticketNo &&
				Objects.equals(id, ticket.id) &&
				Objects.equals(user, ticket.user) &&
				Objects.equals(fareCategore, ticket.fareCategore) &&
				Objects.equals(compartment, ticket.compartment) &&
				Objects.equals(seatOrCabin, ticket.seatOrCabin) &&
				Objects.equals(route, ticket.route);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, ticketNo, user, fareCategore, compartment, seatOrCabin, route);
	}


	@Override
	public String toString() {
		return "Ticket{" +
				"id=" + id +
				", ticketNo=" + ticketNo +
				", user=" + user +
				", fareCategore=" + fareCategore +
				", compartment=" + compartment +
				", seatOrCabin=" + seatOrCabin +
				", route=" + route +
				'}';
	}
}
