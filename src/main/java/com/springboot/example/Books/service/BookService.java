package com.springboot.example.Books.service;

import com.springboot.example.Books.model.BookModel;
import com.springboot.example.Books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Stream;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @PostConstruct
    private void loadData()
    {
        loadBooksIntoHSQL();
    }

    private void loadBooksIntoHSQL() {

        Stream.of(
                new BookModel("1", "How Mind Works", "Kindle", new String[] {"xyz"}, "July 2nd" ),
                new BookModel("2", "How Body Works", "Kindle", new String[] {"abc"}, "June 30"),
                new BookModel("3", "Why we sleep", "Kindle", new String[] {"efg"}, "May 1")
        ).forEach(book -> {
            bookRepository.save(book);
        });
    }

    public List<BookModel> getAllBooks() {

       return bookRepository.findAll();
    }

    public BookModel getBook(String id) {
        return bookRepository.findById(id).get();
    }
}
