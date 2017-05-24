package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.entities.Author;
import com.example.entities.Book;
import com.example.repositories.AuthorRepository;
import com.example.repositories.BookRepository;


@Component
public class AppContextListener implements ApplicationListener<ContextRefreshedEvent> {

	private BookRepository bookRepo;

	private AuthorRepository authorRepo;

    @Autowired
    public AppContextListener(BookRepository bookRepo, AuthorRepository authorRepo) {
		this.bookRepo = bookRepo;
		this.authorRepo = authorRepo;
    }
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
    	Author author = authorRepo.save(new Author("Craig Walls"));
    	bookRepo.save(new Book("978-1-61729-254-5", "Spring Boot in Action", author));
    	bookRepo.save(new Book("978-1-617291-20-3", "Spring in Action", author));

    	author = authorRepo.save(new Author("Chris Waugh"));
    	bookRepo.save(new Book("978-1-234567-89-0", "My Best Book", author));
    }
}
