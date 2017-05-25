package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.entities.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	
	@Query("FROM Book b WHERE b.author.lastName LIKE '%Waugh%'")
	List<Book> findWaughBooks();

}
