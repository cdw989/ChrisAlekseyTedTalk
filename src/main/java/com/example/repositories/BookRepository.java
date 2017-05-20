package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.entities.Book;

public interface BookRepository extends CrudRepository <Book, Long> {
	Book findByIsbn(String isbn);
	
	@Query("FROM Book b WHERE b.author LIKE '%Waugh%'")
	List<Book> findWaughBooks();
}
