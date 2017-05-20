package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.entities.Book;
import com.example.repositories.BookRepository;


@Component
public class AppContextListener implements ApplicationListener<ContextRefreshedEvent> {

	private BookRepository repo;

    @Autowired
    public AppContextListener(BookRepository repo) {
		this.repo = repo;
    }
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) { 
		repo.save(new Book("978-1-61729-254-5", "Spring Boot in Action", "Craig Walls"));
		repo.save(new Book("978-1-617291-20-3", "Spring in Action", "Craig Walls"));

		repo.save(new Book("978-1-234567-89-0", "My Best Book", "Chris Waugh"));
}
}
