package com.example.demo;

import java.util.Arrays;

import org.springframework.data.annotation.Id;

public class User {

	@Id
	private int id;

	private String email;

	private String[] addresses;

	public User() {

	}

	public User(int id, String email) {
		this.id = id;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String[] getAddresses() {
		return addresses;
	}

	public void setAddresses(String[] addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", addresses=" + Arrays.toString(addresses) + "]";
	}

}
