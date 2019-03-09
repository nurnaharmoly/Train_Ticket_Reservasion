package com.example.trainreservation.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "train")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "train_name")
    private String trainName;


    private int trainNo;
    @ManyToOne
    @JoinColumn(name = "sheduleTime_id")
    private ScheduleTime sheduleTime;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;
    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
    }

    public ScheduleTime getSheduleTime() {
        return sheduleTime;
    }

    public void setSheduleTime(ScheduleTime sheduleTime) {
        this.sheduleTime = sheduleTime;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }


    public Train() {
    }

    public Train(String trainName, int trainNo, ScheduleTime sheduleTime, Route route, Station station) {
        this.trainName = trainName;
        this.trainNo = trainNo;
        this.sheduleTime = sheduleTime;
        this.route = route;
        this.station = station;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return trainNo == train.trainNo &&
                Objects.equals(id, train.id) &&
                Objects.equals(trainName, train.trainName) &&
                Objects.equals(sheduleTime, train.sheduleTime) &&
                Objects.equals(route, train.route) &&
                Objects.equals(station, train.station);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trainName, trainNo, sheduleTime, route, station);
    }


    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", trainName='" + trainName + '\'' +
                ", trainNo=" + trainNo +
                ", sheduleTime=" + sheduleTime +
                ", route=" + route +
                ", station=" + station +
                '}';
    }
}
