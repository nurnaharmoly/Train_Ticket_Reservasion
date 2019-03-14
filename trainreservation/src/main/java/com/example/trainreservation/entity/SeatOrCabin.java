package com.example.trainreservation.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "seat")
public class SeatOrCabin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;

	private int seatNo;

	private int cabinNo;



	@ManyToOne
	@JoinColumn(name = "compartment_id", nullable = false)
	private Compartment compartment;


	@ManyToOne
	@JoinColumn(name = "trainClass_id", nullable = false)
	private TrainClass trainClass;


	@ManyToOne
	@JoinColumn(name = "train_id", nullable = false)
	private Train train;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public int getCabinNo() {
		return cabinNo;
	}

	public void setCabinNo(int cabinNo) {
		this.cabinNo = cabinNo;
	}

	public Compartment getCompartment() {
		return compartment;
	}

	public void setCompartment(Compartment compartment) {
		this.compartment = compartment;
	}

	public TrainClass getTrainClass() {
		return trainClass;
	}

	public void setTrainClass(TrainClass trainClass) {
		this.trainClass = trainClass;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public SeatOrCabin() {
	}

	public SeatOrCabin(int seatNo, int cabinNo, Compartment compartment, TrainClass trainClass, Train train) {
		this.seatNo = seatNo;
		this.cabinNo = cabinNo;
		this.compartment = compartment;
		this.trainClass = trainClass;

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SeatOrCabin that = (SeatOrCabin) o;
		return seatNo == that.seatNo &&
				cabinNo == that.cabinNo &&
				Objects.equals(id, that.id) &&
				Objects.equals(compartment, that.compartment) &&
				Objects.equals(trainClass, that.trainClass);

	}

	@Override
	public int hashCode() {
		return Objects.hash(id, seatNo, cabinNo, compartment, trainClass);
	}

	@Override
	public String toString() {
		return "SeatOrCabin{" +
				"id=" + id +
				", seatNo=" + seatNo +
				", cabinNo=" + cabinNo +
				", compartment=" + compartment +
				", trainClass=" + trainClass +

				'}';
	}
}
