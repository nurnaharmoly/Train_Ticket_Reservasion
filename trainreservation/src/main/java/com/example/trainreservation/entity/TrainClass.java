package com.example.trainreservation.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "train_class")
public class TrainClass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;

	private String className;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public TrainClass() {
	}


	public TrainClass(String className) {
		this.className = className;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TrainClass that = (TrainClass) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(className, that.className);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, className);
	}

	@Override
	public String toString() {
		return "TrainClass{" +
				"id=" + id +
				", className='" + className + '\'' +
				'}';
	}
}
