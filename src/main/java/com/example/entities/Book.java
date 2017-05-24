package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	private final String API = "/api/v1/books/";
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String isbn;
	private String title;
	private String edition;
	@ManyToOne	
	private Author author;
	
	public Book(){}
	
	public Book	(String isbn, String title, String edition, Author author)	{
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.edition = edition;
	}
	
	public Book	(Long id, String isbn, String title, String edition, Author author)	{
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.edition = edition;
	}

	public Long getId() {
		return id;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getApi() {
		return API + id;
	}
	public String getTitle() {
		return title;
	}
	public String getEdition() {
		return edition;
	}	
	public Author getAuthor() {
		return author;
	}
	
}
