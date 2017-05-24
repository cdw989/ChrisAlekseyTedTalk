package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.entities.Book;

public interface BookExampleRepository extends CrudRepository<Book, Long>, BookExampleRepositoryCustom {
	
	Book findByIsbn(String isbn);

	List<Book> findByAuthorFirstName(String firstName);
	List<Book> findByAuthor_FirstName(String firstName);
	
	Long countByAuthorLastName(String lastName);
	
	@Query("FROM Book b WHERE b.author LIKE '%Waugh%'")
	List<Book> findWaughBooks();

	List<Book> findDistinctBooksByTitle(String title);
	List<Book> findBooksDistinctByTitle(String title);

	List<Book> findByTitleIgnoreCase(String title);
	List<Book> findByTitleOrIsbnAllIgnoreCase(String title, String isbn);
	
	List<Book> findFirstBooksByAuthorFirstName(String firstName);
	List<Book> findFirst3BooksByAuthorFirstName(String firstName);
	List<Book> findTopBooksByAuthorFirstName(String firstName);
	List<Book> findTop2BooksByAuthorFirstName(String firstName);

	List<Book> findBooksByTitleOrderByAuthorFirstNameAsc(String title);
	List<Book> findBooksByTitleOrderByAuthorFirstNameDesc(String title);
	
}
