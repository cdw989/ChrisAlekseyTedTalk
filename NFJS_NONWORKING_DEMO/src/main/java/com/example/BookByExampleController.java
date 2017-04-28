package com.example;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookByExampleController {
	
	private BookRepository repo;
	
	public BookByExampleController(BookRepository repo)	{
		this.repo = repo;
	}
	
	@GetMapping
	public Iterable<Book> someBooksByExample()	{
		Author author = new Author("ken");
		Example <Book> example Example<T>.of(new Book(author));
		ExampleMatcher.matching().withStringMatcher(StringMatcher.ENDING);
		
		return repo.findAll(example);
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
