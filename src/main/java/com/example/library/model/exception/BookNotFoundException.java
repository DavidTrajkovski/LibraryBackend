package com.example.library.model.exception;

public class BookNotFoundException extends Exception{

    public BookNotFoundException(Long bookId) {
        super();
        System.out.println("Book with id: " + bookId + "is not found");
    }
}
