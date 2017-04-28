package com.example;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/{isbn}")
	public Book findByIsbn(@PathVariable String isbn)	{
		return repo.findByIsbn(isbn);
	}
	
	@GetMapping("/kendall")
	public List <Book> findKendallsBooks()	{
		repo.toSomethingStupid();
		return repo.findKendallsBooks();
	}
	
}
