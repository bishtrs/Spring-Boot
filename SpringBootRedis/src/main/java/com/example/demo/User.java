package com.example.demo;

import java.io.Serializable;

public class User implements Serializable {

	private String email;
	private String firstName;
	private String lastName;

	public User(String email, String firstName, String lastName) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
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

	@Override
	public String toString() {
		return "User [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	

}
