package com.example.trainreservation.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "availableSeats")
public class AvailableSeats {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;

	private int availableSeats;

	private int soldSeats;

	private int totalSeats;

	@ManyToOne
	@JoinColumn(name = "train_id")
	private Train train;

	@ManyToOne
	@JoinColumn(name = "compartment_id")
	private Compartment compartment;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
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

	public AvailableSeats(int availableSeats, int soldSeats, int totalSeats, Train train, Compartment compartment) {
		this.availableSeats = availableSeats;
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
		return availableSeats == that.availableSeats &&
				soldSeats == that.soldSeats &&
				totalSeats == that.totalSeats &&
				Objects.equals(id, that.id) &&
				Objects.equals(train, that.train) &&
				Objects.equals(compartment, that.compartment);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, availableSeats, soldSeats, totalSeats, train, compartment);
	}

	@Override
	public String toString() {
		return "AvailableSeats{" +
				"id=" + id +
				", availableSeats=" + availableSeats +
				", soldSeats=" + soldSeats +
				", totalSeats=" + totalSeats +
				", train=" + train +
				", compartment=" + compartment +
				'}';
	}
}
