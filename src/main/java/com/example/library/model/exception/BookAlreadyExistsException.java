package com.example.library.model.exception;

public class BookAlreadyExistsException extends Exception{
    public BookAlreadyExistsException(String name) {
        System.out.println("Book with name "+name+" already exists");
    }
}
