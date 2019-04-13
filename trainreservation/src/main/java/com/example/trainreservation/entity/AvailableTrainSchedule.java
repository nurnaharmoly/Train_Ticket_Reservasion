package com.example.trainreservation.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "availableTrainSchedule")
public class AvailableTrainSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;


	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "availabletrainschedule_seatdetails",
			joinColumns = @JoinColumn(name = "av_trainsche_id"),
			inverseJoinColumns = @JoinColumn(name = "seatdetails_id")
	)
	private List<SeatDetails> seatDetails;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "availabletrainschedule_compartment",
			joinColumns = @JoinColumn(name = "av_trainsche_id"),
			inverseJoinColumns = @JoinColumn(name = "compartment_id")
	)
	private List<Compartment> compartmentList;



	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date availableDate;

	private boolean status;



	@ManyToOne
	@JoinColumn(name = "train_id", nullable = false)
	private Train train;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public List<SeatDetails> getSeatDetails() {
        return seatDetails;
    }

    public void setSeatDetails(List<SeatDetails> seatDetails) {
        this.seatDetails = seatDetails;
    }

    public Date getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}


	public List<Compartment> getCompartmentList() {
		return compartmentList;
	}

	public void setCompartmentList(List<Compartment> compartmentList) {
		this.compartmentList = compartmentList;
	}


	public AvailableTrainSchedule() {
	}


	public AvailableTrainSchedule(List<SeatDetails> seatDetails, List<Compartment> compartmentList, Date availableDate, boolean status, Train train) {
		this.seatDetails = seatDetails;
		this.compartmentList = compartmentList;
		this.availableDate = availableDate;
		this.status = status;
		this.train = train;
	}


	@Override
	public String toString() {
		return "AvailableTrainSchedule{" +
				"id=" + id +
				", seatDetails=" + seatDetails +
				", compartmentList=" + compartmentList +
				", availableDate=" + availableDate +
				", status=" + status +
				", train=" + train +
				'}';
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AvailableTrainSchedule that = (AvailableTrainSchedule) o;
		return status == that.status &&
				Objects.equals(id, that.id) &&
				Objects.equals(seatDetails, that.seatDetails) &&
				Objects.equals(compartmentList, that.compartmentList) &&
				Objects.equals(availableDate, that.availableDate) &&
				Objects.equals(train, that.train);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, seatDetails, compartmentList, availableDate, status, train);
	}
}
