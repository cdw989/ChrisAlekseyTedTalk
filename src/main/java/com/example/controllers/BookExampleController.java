package com.example.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Author;
import com.example.entities.Book;
import com.example.repositories.AuthorRepository;
import com.example.repositories.BookExampleRepository;

@RestController
@RequestMapping("/api/v1/booksExample")
public class BookExampleController {

	private BookExampleRepository bookRepo;
	private AuthorRepository authorRepo;

	public BookExampleController(BookExampleRepository bookRepo, AuthorRepository authorRepo)	{
		this.bookRepo = bookRepo;
		this.authorRepo = authorRepo;
	}
	
	@RequestMapping(value="/Waugh", method = RequestMethod.GET)
	public Iterable<Book> findWaughBooks()	{
		return bookRepo.findWaughBooks();
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

    @RequestMapping(method = RequestMethod.POST)
	public Book addBook(@RequestParam("isbn") String isbn, @RequestParam("title") String title, @RequestParam(name="edition", required=false) String edition, @RequestParam(name="firstName") String firstName, @RequestParam(name="lastName", required=false) String lastName) {
    	Author author = authorRepo.save(new Author(firstName, lastName));
    	Book book = new Book(isbn, title, edition, author);
    	if(!bookRepo.hasValidBook(book)) {
    		System.out.println("Invalid Book");
    		return book;
    	}
    	return bookRepo.save(book);
	}

}