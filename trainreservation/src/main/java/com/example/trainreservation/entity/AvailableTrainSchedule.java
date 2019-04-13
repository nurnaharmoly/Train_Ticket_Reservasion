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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AvailableTrainSchedule that = (AvailableTrainSchedule) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(seatDetails, that.seatDetails) &&
				Objects.equals(availableDate, that.availableDate) &&
				Objects.equals(train, that.train);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, seatDetails, availableDate, train);
	}
}
