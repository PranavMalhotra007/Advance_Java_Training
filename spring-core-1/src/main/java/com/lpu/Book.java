package com.lpu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "MyBook")
public class Book {
	private int id;
	private String title;
	private String author;
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
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	public Book(@Value("10")int id,@Value("Harry Potter") String title, @Value("JK Rowling")String author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
	}
	
}
