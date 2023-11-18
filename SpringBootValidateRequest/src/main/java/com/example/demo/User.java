package com.example.demo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

	@NotEmpty(message = "user name can't be empty")
	@Size(min=1, max=128)
	private String name;

	@NotNull(message = "phone number can't be null")
	private Long phoneNumber;

	public User() {
	}

	public User(String name, Long phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}