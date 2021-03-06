package com.example.demo;

public class Address {

	private String id;
	private String address;

	public Address() {
	}

	public Address(String id, String address) {
		super();
		this.id = id;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + "]";
	}

}