package com.example.trainreservation.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "availableSeats")
public class AvailableSeats {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;

	private int availableSeat;

	private int soldSeats;

	private int totalSeats;

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

	public int getAvailableSeat() {
		return availableSeat;
	}

	public void setAvailableSeat(int availableSeat) {
		this.availableSeat = availableSeat;
	}

	public int getSoldSeats() {
		return soldSeats;
	}

	public void setSoldSeats(int soldSeats) {
		this.soldSeats = soldSeats;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
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

	public AvailableSeats(int availableSeat, int soldSeats, int totalSeats, Train train, Compartment compartment) {
		this.availableSeat = availableSeat;
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
		return availableSeat == that.availableSeat &&
				soldSeats == that.soldSeats &&
				totalSeats == that.totalSeats &&
				Objects.equals(id, that.id) &&
				Objects.equals(train, that.train) &&
				Objects.equals(compartment, that.compartment);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, availableSeat, soldSeats, totalSeats, train, compartment);
	}

	@Override
	public String toString() {
		return "AvailableSeats{" +
				"id=" + id +
				", availableSeats=" + availableSeat +
				", soldSeats=" + soldSeats +
				", totalSeats=" + totalSeats +
				", train=" + train +
				", compartment=" + compartment +
				'}';
	}
}
