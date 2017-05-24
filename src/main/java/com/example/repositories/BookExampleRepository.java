package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.entities.Book;

public interface BookExampleRepository extends CrudRepository<Book, Long>, BookExampleRepositoryCustom {
	
	Book findByIsbn(String isbn);

	List<Book> findByAuthorFirstName(String firstName);
	List<Book> findByAuthor_FirstName(String firstName);
	
	Long countByAuthorFirstName(String firstName);
	
	@Query("FROM Book b WHERE b.title LIKE '%Java%'")
	List<Book> findJavaBooksQuery();
	
	List<Book> findJavaBooksByTitleContains(String title);

	List<Book> findDistinctBooksByAuthorFirstName(String firstName);
	List<Book> findBooksDistinctByAuthorFirstName(String firstName);

	List<Book> findByTitleIgnoreCase(String title);
	List<Book> findByTitleOrIsbnAllIgnoreCase(String title, String isbn);
	
	List<Book> findFirstBooksByAuthorFirstName(String firstName);
	List<Book> findFirst3BooksByAuthorFirstName(String firstName);
	List<Book> findTopBooksByAuthorFirstName(String firstName);
	List<Book> findTop2BooksByAuthorFirstName(String firstName);

	List<Book> findBooksByTitleOrderByAuthorFirstNameAsc(String title);
	List<Book> findBooksByTitleOrderByAuthorFirstNameDesc(String title);
	
}
