package com.example.demo;

public class Product {

	private int id;
	private String title;
	private float price;
	private String description;
	private String clothing;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClothing() {
		return clothing;
	}

	public void setClothing(String clothing) {
		this.clothing = clothing;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", price=" + price + ", description=" + description
				+ ", clothing=" + clothing + "]";
	}

}