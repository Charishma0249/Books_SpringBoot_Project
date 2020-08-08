package com.springboot.example.Books.repository;

import com.springboot.example.Books.model.BookModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<BookModel,String> {

}

