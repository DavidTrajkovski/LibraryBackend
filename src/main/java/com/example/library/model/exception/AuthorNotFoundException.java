package com.example.library.model.exception;

public class AuthorNotFoundException extends Exception{

    public AuthorNotFoundException(Long authorId) {
        super();
        System.out.println("Author with id: " + authorId + "is not found");
    }
}
