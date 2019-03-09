package com.example.trainreservation.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "fare")
public class FareCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;

	private String fareCategoreNo;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFareCategoreNo() {
		return fareCategoreNo;
	}

	public void setFareCategoreNo(String fareCategoreNo) {
		this.fareCategoreNo = fareCategoreNo;
	}

	public FareCategory() {
	}

	public FareCategory(String fareCategoreNo) {
		this.fareCategoreNo = fareCategoreNo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FareCategory that = (FareCategory) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(fareCategoreNo, that.fareCategoreNo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, fareCategoreNo);
	}

	@Override
	public String toString() {
		return "FareCategory{" +
				"id=" + id +
				", fareCategoreNo='" + fareCategoreNo + '\'' +
				'}';
	}
}
