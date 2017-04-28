package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;;

public interface BookRepository extends CrudRepository <Book, Long>, RepositoryExtras {
	Book findByIsbn(String isbn);
	
	@Query("from Book b where b.author = 'Kendall '")
	List<Book> findKendallsBooks();
	
	QueryByEXampleExecutor
}
