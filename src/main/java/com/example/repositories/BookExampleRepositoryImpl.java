package com.example.repositories;

import com.example.entities.Book;

public class BookExampleRepositoryImpl implements BookExampleRepositoryCustom {

	public Boolean checkBook(Book book) {
		return book.getId() != null && 
			   book.getIsbn() != null && 
			   book.getLocation() != null && 
			   book.getTitle() != null;		
	}

}
