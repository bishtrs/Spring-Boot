package com.example.demo;

public class Novel {

	private String title;
	private String author;

	public Novel(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Novel [title=" + title + ", author=" + author + "]";
	}

}
