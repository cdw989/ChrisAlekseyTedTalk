package com.example.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Book;
import com.example.repositories.BookExampleRepository;

@RestController
@RequestMapping("/api/v1/booksExample")
public class BookExampleController {

	private BookExampleRepository bookRepo;

	public BookExampleController(BookExampleRepository bookRepo)	{
		this.bookRepo = bookRepo;
	}
	
	@RequestMapping(value="/isbn/{isbn}", method = RequestMethod.GET)
	public Book findByIsbn(@PathVariable String isbn)	{
		return bookRepo.findByIsbn(isbn);
	}
	
	@RequestMapping(value="/firstName/{firstName}", method = RequestMethod.GET)
	public List<Book> findByAuthorFirstName(@PathVariable String firstName)	{
		return bookRepo.findByAuthor_FirstName(firstName);
	}
	
	@RequestMapping(value="/count/{firstName}", method = RequestMethod.GET)
	public Long countByAuthorLastName(@PathVariable String firstName)	{
		return bookRepo.countByAuthorFirstName(firstName);
	}
	
	@RequestMapping(value="/javaQuery", method = RequestMethod.GET)
	public List<Book> findJavaBooksQuery()	{
		return bookRepo.findJavaBooksQuery();
	}
	
	@RequestMapping(value="/contains/{title}", method = RequestMethod.GET)
	public List<Book> findJavaBooksByTitleContains(@PathVariable String title)	{
		return bookRepo.findJavaBooksByTitleContains(title);
	}
	
	@RequestMapping(value="/distinct/{firstName}", method = RequestMethod.GET)
	public List<Book> findDistinctBooksByAuthorFirstName(@PathVariable String firstName)	{
		return bookRepo.findDistinctBooksByAuthorFirstName(firstName);
	}

}
