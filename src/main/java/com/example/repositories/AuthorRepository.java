package com.example.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.entities.Author;

public interface AuthorRepository extends CrudRepository <Author, Long> {

}
