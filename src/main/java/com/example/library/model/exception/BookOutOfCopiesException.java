package com.example.library.model.exception;

public class BookOutOfCopiesException extends Exception{

    public BookOutOfCopiesException(Long bookId) {
        super();
        System.out.println("Book with id: " + bookId + "is out of copies");
    }
}