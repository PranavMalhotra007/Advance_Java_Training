package com.lpu.extraAnnotations;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Table(name = "book_table")
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "book_name" , unique = true, nullable = false)
	private String title;
	@Column(updatable = false)
	private String author;
	@CreationTimestamp
	private LocalDateTime creation_date;
	@UpdateTimestamp
	private LocalDateTime updation_date;
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
	public LocalDateTime getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(LocalDateTime creation_date) {
		this.creation_date = creation_date;
	}
	public LocalDateTime getUpdation_date() {
		return updation_date;
	}
	public void setUpdation_date(LocalDateTime updation_date) {
		this.updation_date = updation_date;
	}
	public Book() {
		super();
	}
	
}
