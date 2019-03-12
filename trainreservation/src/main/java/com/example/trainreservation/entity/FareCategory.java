package com.example.trainreservation.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "fare")
public class FareCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;

	private String fareCategoreName;

	private int fareCategoreNo;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFareCategoreName() {
		return fareCategoreName;
	}

	public void setFareCategoreName(String fareCategoreName) {
		this.fareCategoreName = fareCategoreName;
	}

	public int getFareCategoreNo() {
		return fareCategoreNo;
	}

	public void setFareCategoreNo(int fareCategoreNo) {
		this.fareCategoreNo = fareCategoreNo;
	}

	public FareCategory() {
	}


	public FareCategory(String fareCategoreName, int fareCategoreNo) {
		this.fareCategoreName = fareCategoreName;
		this.fareCategoreNo = fareCategoreNo;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FareCategory that = (FareCategory) o;
		return fareCategoreNo == that.fareCategoreNo &&
				Objects.equals(id, that.id) &&
				Objects.equals(fareCategoreName, that.fareCategoreName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, fareCategoreName, fareCategoreNo);
	}


	@Override
	public String toString() {
		return "FareCategory{" +
				"id=" + id +
				", fareCategoreName='" + fareCategoreName + '\'' +
				", fareCategoreNo=" + fareCategoreNo +
				'}';
	}
}
