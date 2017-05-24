package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.entities.Book;

public interface BookRepository extends CrudRepository <Book, Long>, BookRepositoryCustom {
	Book findByIsbn(String isbn);
	
	@Query("FROM Book b WHERE b.author LIKE '%Waugh%'")
	List<Book> findWaughBooks();

	List<Book> findDistinctBooksByTitle(String title);
	List<Book> findBooksDistinctByTitle(String title);

	List<Book> findByTitleIgnoreCase(String title);
	List<Book> findByTitleOrIsbnAllIgnoreCase(String title, String isbn);
	
	List<Book> findFirstBooks();
	List<Book> findFirst1Books();
	List<Book> findTopBooks();
	List<Book> findTop1Books();

	List<Book> findBooksByTitleAsc(String title);
	List<Book> findBooksByTitleDesc(String title);
}
