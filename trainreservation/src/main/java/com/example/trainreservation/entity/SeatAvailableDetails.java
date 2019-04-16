package com.example.trainreservation.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "seatAvailableDetails")
public class SeatAvailableDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;


	@ManyToOne
	@JoinColumn(name = "train_id", nullable = false)
	private Train train;

	@ManyToOne
	@JoinColumn(name = "compartment_id", nullable = false)
	private Compartment compartment;

	@ManyToOne
	@JoinColumn(name = "seatOrCabin_id", nullable = false)
	private SeatOrCabin seatOrCabin;


	private Boolean status;


	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date journyDate;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public SeatOrCabin getSeatOrCabin() {
		return seatOrCabin;
	}

	public void setSeatOrCabin(SeatOrCabin seatOrCabin) {
		this.seatOrCabin = seatOrCabin;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}


	public Date getJournyDate() {
		return journyDate;
	}

	public void setJournyDate(Date journyDate) {
		this.journyDate = journyDate;
	}

	public SeatAvailableDetails() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SeatAvailableDetails that = (SeatAvailableDetails) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(train, that.train) &&
				Objects.equals(compartment, that.compartment) &&
				Objects.equals(seatOrCabin, that.seatOrCabin) &&
				Objects.equals(status, that.status) &&
				Objects.equals(journyDate, that.journyDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, train, compartment, seatOrCabin, status, journyDate);
	}


	@Override
	public String toString() {
		return "SeatAvailableDetails{" +
				"id=" + id +
				", train=" + train +
				", compartment=" + compartment +
				", seatOrCabin=" + seatOrCabin +
				", status=" + status +
				", journyDate=" + journyDate +
				'}';
	}

	public SeatAvailableDetails(Train train, Compartment compartment, SeatOrCabin seatOrCabin, Boolean status, Date journyDate) {
		this.train = train;
		this.compartment = compartment;
		this.seatOrCabin = seatOrCabin;
		this.status = status;
		this.journyDate = journyDate;
	}
}
