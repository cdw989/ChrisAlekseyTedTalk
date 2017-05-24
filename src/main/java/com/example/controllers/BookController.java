package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Book;
import com.example.repositories.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {

	private BookRepository repo;

	public BookController(BookRepository repo)	{
		this.repo = repo;
	}
	
	@GetMapping
	public Iterable<Book> allBooks()	{
		return repo.findAll();
	}

	@GetMapping("/Waugh")
	public Iterable<Book> allWaughBooks()	{
		repo.customMethod();
		
		return repo.findWaughBooks();
	}

	@GetMapping("/custom")
	public Iterable<Book> custom()	{
		repo.customMethod();
		
		return repo.findAll();
	}

}
