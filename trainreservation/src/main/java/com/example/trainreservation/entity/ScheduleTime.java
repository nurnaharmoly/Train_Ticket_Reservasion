package com.example.trainreservation.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "shedule_time")
public class ScheduleTime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;


//	@Temporal(TemporalType.TIME)
//    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
//	private LocalDateTime startTime;
//
//	@Temporal(TemporalType.TIME)
//	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
//    private LocalDateTime arrivalTime;
//
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//    public LocalDateTime getStartTime() {
//        return startTime;
//    }
//
//    public void setStartTime(LocalDateTime startTime) {
//        this.startTime = startTime;
//    }
//
//    public LocalDateTime getArrivalTime() {
//        return arrivalTime;
//    }
//
//    public void setArrivalTime(LocalDateTime arrivalTime) {
//        this.arrivalTime = arrivalTime;
//    }
}
