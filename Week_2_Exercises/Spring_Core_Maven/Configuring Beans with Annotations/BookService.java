package com.library.service;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    // Constructor injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Example method that uses BookRepository
    public void performService() {
        System.out.println("Performing service using " + bookRepository);
    }
}
