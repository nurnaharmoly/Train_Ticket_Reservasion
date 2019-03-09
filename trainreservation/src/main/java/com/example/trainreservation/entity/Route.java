package com.example.trainreservation.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "route")
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;

	private String routeName;


	private String stationFrom;


	private String stationTo;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getStationFrom() {
		return stationFrom;
	}

	public void setStationFrom(String stationFrom) {
		this.stationFrom = stationFrom;
	}

	public String getStationTo() {
		return stationTo;
	}

	public void setStationTo(String stationTo) {
		this.stationTo = stationTo;
	}

	public Route() {
	}

	public Route(String routeName, String stationFrom, String stationTo) {
		this.routeName = routeName;
		this.stationFrom = stationFrom;
		this.stationTo = stationTo;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Route route = (Route) o;
		return Objects.equals(id, route.id) &&
				Objects.equals(routeName, route.routeName) &&
				Objects.equals(stationFrom, route.stationFrom) &&
				Objects.equals(stationTo, route.stationTo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, routeName, stationFrom, stationTo);
	}


	@Override
	public String toString() {
		return "Route{" +
				"id=" + id +
				", routeName='" + routeName + '\'' +
				", stationFrom='" + stationFrom + '\'' +
				", stationTo='" + stationTo + '\'' +
				'}';
	}
}
