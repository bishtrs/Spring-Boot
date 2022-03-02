package com.example.demo;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String email;
	private String firstName;
	private String lastName;

	public User(int id, String email, String firstName, String lastName) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

}
