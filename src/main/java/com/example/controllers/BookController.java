package com.example.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Author;
import com.example.entities.Book;
import com.example.repositories.AuthorRepository;
import com.example.repositories.BookRepository;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

	private BookRepository bookRepo;
	private AuthorRepository authorRepo;

	public BookController(BookRepository bookRepo, AuthorRepository authorRepo)	{
		this.bookRepo = bookRepo;
		this.authorRepo = authorRepo;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Book> getList()	{
		return bookRepo.findAll();
	}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Book getBook(@PathVariable Long id) {
		return bookRepo.findOne(id);
	}

    @RequestMapping(method = RequestMethod.POST)
	public Book addBook(@RequestParam("isbn") String isbn, @RequestParam("title") String title, @RequestParam(name="edition", required=false) String edition, @RequestParam(name="firstName") String firstName, @RequestParam(name="lastName", required=false) String lastName) {
    	Author author = authorRepo.save(new Author(firstName, lastName));
    	return bookRepo.save(new Book(isbn, title, edition, author));
	}

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
    	Author author = authorRepo.save(new Author(book.getAuthor().getFirstName(), book.getAuthor().getLastName()));
    	Book updatedBook = new Book(book.getId(), book.getIsbn(), book.getTitle(), book.getEdition(), author);
    	return bookRepo.save(updatedBook);
	}

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void removeBook(@PathVariable Long id) {
		bookRepo.delete(id);
	}
	
	@RequestMapping(value="/waugh", method = RequestMethod.GET)
	public Iterable<Book> findWaughBooks()	{
		return bookRepo.findWaughBooks();
	}

}
