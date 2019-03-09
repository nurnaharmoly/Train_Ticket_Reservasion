package com.example.trainreservation.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;

	private String ticketCategore;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "fareCategore_id")
	private FareCategory fareCategore;
	@ManyToOne
	@JoinColumn(name = "compartment_id")
	private Compartment compartment;

	@OneToOne
	@JoinColumn(name = "seatOrCabin_id")
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

	public String getTicketCategore() {
		return ticketCategore;
	}

	public void setTicketCategore(String ticketCategore) {
		this.ticketCategore = ticketCategore;
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

	public Ticket(String ticketCategore, User user, FareCategory fareCategore, Compartment compartment, SeatOrCabin seatOrCabin, Route route) {
		this.ticketCategore = ticketCategore;
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
		return Objects.equals(id, ticket.id) &&
				Objects.equals(ticketCategore, ticket.ticketCategore) &&
				Objects.equals(user, ticket.user) &&
				Objects.equals(fareCategore, ticket.fareCategore) &&
				Objects.equals(compartment, ticket.compartment) &&
				Objects.equals(seatOrCabin, ticket.seatOrCabin) &&
				Objects.equals(route, ticket.route);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, ticketCategore, user, fareCategore, compartment, seatOrCabin, route);
	}

	@Override
	public String toString() {
		return "Ticket{" +
				"id=" + id +
				", ticketCategore='" + ticketCategore + '\'' +
				", user=" + user +
				", fareCategore=" + fareCategore +
				", compartment=" + compartment +
				", seatOrCabin=" + seatOrCabin +
				", route=" + route +
				'}';
	}
}
