package com.springboot.example.Books.controller;

import com.springboot.example.Books.model.BookModel;
import com.springboot.example.Books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<Object> getAllBooks()
    {
        List<BookModel> books= bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping(path = "/{bookId}")
    public ResponseEntity<Object> getBookById(@PathVariable String bookId)
    {
        BookModel book = bookService.getBook(bookId);
        System.out.println("Get Book by id");
        return  new ResponseEntity<>(book, HttpStatus.OK);
    }

}
