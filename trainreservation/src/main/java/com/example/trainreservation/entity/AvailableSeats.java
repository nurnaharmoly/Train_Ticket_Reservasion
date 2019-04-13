package com.example.trainreservation.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "availableSeats")
public class AvailableSeats {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;

	private String availSeat;

	private String soldSeats;

	private String totalSeats;

	@ManyToOne
	@JoinColumn(name = "train_id", nullable = false)
	private Train train;

	@ManyToOne
	@JoinColumn(name = "compartment_id", nullable = false)
	private Compartment compartment;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAvailSeat() {
		return availSeat;
	}

	public void setAvailSeat(String availSeat) {
		this.availSeat = availSeat;
	}

	public String getSoldSeats() {
		return soldSeats;
	}

	public void setSoldSeats(String soldSeats) {
		this.soldSeats = soldSeats;
	}

	public String getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(String totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public Compartment getCompartment() {
		return compartment;
	}

	public void setCompartment(Compartment compartment) {
		this.compartment = compartment;
	}


	public AvailableSeats() {
	}


	public AvailableSeats(String availSeat, String soldSeats, String totalSeats, Train train, Compartment compartment) {
		this.availSeat = availSeat;
		this.soldSeats = soldSeats;
		this.totalSeats = totalSeats;
		this.train = train;
		this.compartment = compartment;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AvailableSeats that = (AvailableSeats) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(availSeat, that.availSeat) &&
				Objects.equals(soldSeats, that.soldSeats) &&
				Objects.equals(totalSeats, that.totalSeats) &&
				Objects.equals(train, that.train) &&
				Objects.equals(compartment, that.compartment);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, availSeat, soldSeats, totalSeats, train, compartment);
	}


	@Override
	public String toString() {
		return "AvailableSeats{" +
				"id=" + id +
				", availSeat='" + availSeat + '\'' +
				", soldSeats='" + soldSeats + '\'' +
				", totalSeats='" + totalSeats + '\'' +
				", train=" + train +
				", compartment=" + compartment +
				'}';
	}
}
