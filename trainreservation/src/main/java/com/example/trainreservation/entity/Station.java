package com.example.trainreservation.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "station")
public class Station {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;

	private String stationName;

	private String adress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}


	public Station() {
	}

	public Station(String stationName, String adress) {
		this.stationName = stationName;
		this.adress = adress;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Station station = (Station) o;
		return Objects.equals(id, station.id) &&
				Objects.equals(stationName, station.stationName) &&
				Objects.equals(adress, station.adress);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, stationName, adress);
	}

	@Override
	public String toString() {
		return "Station{" +
				"id=" + id +
				", stationName='" + stationName + '\'' +
				", adress='" + adress + '\'' +
				'}';
	}
}
