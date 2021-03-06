package com.example.trainreservation.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "compartment")
public class Compartment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;

	private String compartmentName;

	private int compartmentNo;

	@ManyToOne
	@JoinColumn(name = "train_id", nullable = false)
	private Train train;

	@OneToMany(mappedBy = "compartment")
	private List<SeatDetails> seatDetailsList;

	public List<SeatDetails> getSeatDetailsList() {
		return seatDetailsList;
	}

	public void setSeatDetailsList(List<SeatDetails> seatDetailsList) {
		this.seatDetailsList = seatDetailsList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompartmentName() {
		return compartmentName;
	}

	public void setCompartmentName(String compartmentName) {
		this.compartmentName = compartmentName;
	}

	public int getCompartmentNo() {
		return compartmentNo;
	}

	public void setCompartmentNo(int compartmentNo) {
		this.compartmentNo = compartmentNo;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}


	public Compartment() {
	}
	public Compartment(Long id) {
		this.id=id;
	}
	public Compartment(String compartmentName, int compartmentNo, Train train) {
		this.compartmentName = compartmentName;
		this.compartmentNo = compartmentNo;
		this.train = train;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Compartment that = (Compartment) o;
		return compartmentNo == that.compartmentNo &&
				Objects.equals(id, that.id) &&
				Objects.equals(compartmentName, that.compartmentName) &&
				Objects.equals(train, that.train);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, compartmentName, compartmentNo, train);
	}

	@Override
	public String toString() {
		return "Compartment{" +
				"id=" + id +
				", compartmentName='" + compartmentName + '\'' +
				", compartmentNo=" + compartmentNo +
				", train=" + train +
				'}';
	}
}
