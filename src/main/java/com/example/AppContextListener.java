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
    	Author craig = authorRepo.save(new Author("Craig", "Walls"));
    	bookRepo.save(new Book("978-1-61729-254-5", "Spring Boot in Action", null, craig));
    	bookRepo.save(new Book("978-1-617291-20-3", "Spring in Action", null, craig));

    	Author me = authorRepo.save(new Author("Chris", "Waugh"));
    	bookRepo.save(new Book("978-1-234567-89-0", "My Best Book", null, me));
    	
    	Author alan = authorRepo.save(new Author("Alan", " Mycroft"));
    	bookRepo.save(new Book("978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming", null, alan));
    	
    	Author joshua = authorRepo.save(new Author("Joshua", " Bloch"));
    	bookRepo.save(new Book("978-0321356680", "Effective Java", "2nd", joshua));
    	
    	Author robert = authorRepo.save(new Author("Robert", " Liguori"));
    	bookRepo.save(new Book("978-1491900864", "Java 8 Pocket Guide: Instant Help for Java Programmers", "1st", robert));

    	Author tomasz = authorRepo.save(new Author("Tomasz", "Nurkiewicz"));
    	Author coAuthor = authorRepo.save(new Author("Ben", "Christensen"));    	
    	bookRepo.save(new Book("978-1491900864", "Reactive Programming with RxJava: Creating Asynchronous, Event-Based Applications", "1st", tomasz));
    }
}
