package com.visioture.model.dto;

import java.sql.Timestamp;

public class Actor {

	private int id;
	private String firstName;
	private String lastName;
	private Timestamp lastUpdate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Actor id: " + id + "\nFirst name: " + firstName + "\nLast name: " + lastName + "\nLast update: "
				+ lastUpdate;
	}
	
}
