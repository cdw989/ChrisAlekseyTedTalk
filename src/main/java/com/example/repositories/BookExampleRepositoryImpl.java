package com.example.repositories;

import com.example.entities.Book;

public class BookExampleRepositoryImpl implements BookExampleRepositoryCustom {

	public Boolean hasValidBook(Book book) {
		return book.getTitle() != null && 
			   book.getIsbn() != null && 
			   book.getAuthor().getFirstName() != null && 
			   book.getAuthor().getLastName() != null;		
	}

}
