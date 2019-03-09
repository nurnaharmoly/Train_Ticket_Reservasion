package com.example.trainreservation.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "shedule_time")
public class ScheduleTime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;


	@Temporal(TemporalType.TIME)
	private Date startTime;

	@Temporal(TemporalType.TIME)
	private Date arrivalTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public ScheduleTime() {
	}

	public ScheduleTime(Date startTime, Date arrivalTime) {
		this.startTime = startTime;
		this.arrivalTime = arrivalTime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ScheduleTime that = (ScheduleTime) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(startTime, that.startTime) &&
				Objects.equals(arrivalTime, that.arrivalTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, startTime, arrivalTime);
	}

	@Override
	public String toString() {
		return "ScheduleTime{" +
				"id=" + id +
				", startTime=" + startTime +
				", arrivalTime=" + arrivalTime +
				'}';
	}
}
